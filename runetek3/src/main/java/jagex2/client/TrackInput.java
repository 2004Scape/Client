package jagex2.client;

import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class TrackInput {

	@OriginalMember(owner = "client!e", name = "e", descriptor = "Z")
	public static boolean enabled;

	@OriginalMember(owner = "client!e", name = "f", descriptor = "Lclient!kb;")
	private static Packet outBuffer = null;

	@OriginalMember(owner = "client!e", name = "g", descriptor = "Lclient!kb;")
	private static Packet oldBuffer = null;

	@OriginalMember(owner = "client!e", name = "h", descriptor = "J")
	private static long lastTime;

	@OriginalMember(owner = "client!e", name = "i", descriptor = "I")
	private static int trackedCount;

	@OriginalMember(owner = "client!e", name = "j", descriptor = "J")
	private static long lastMoveTime;

	@OriginalMember(owner = "client!e", name = "k", descriptor = "I")
	private static int lastX;

	@OriginalMember(owner = "client!e", name = "l", descriptor = "I")
	private static int lastY;

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(I)V")
	public static synchronized void setEnabled() {
		outBuffer = Packet.alloc(1);
		oldBuffer = null;
		lastTime = System.currentTimeMillis();
		enabled = true;
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(B)V")
	public static synchronized void setDisabled() {
		enabled = false;
		outBuffer = null;
		oldBuffer = null;
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(I)Lclient!kb;")
	public static synchronized Packet flush() {
		@Pc(1) Packet local1 = null;
		if (oldBuffer != null && enabled) {
			local1 = oldBuffer;
		}
		oldBuffer = null;
		return local1;
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(I)Lclient!kb;")
	public static synchronized Packet stop() {
		@Pc(9) Packet local9 = null;
		if (outBuffer != null && outBuffer.pos > 0 && enabled) {
			local9 = outBuffer;
		}
		setDisabled();
		return local9;
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(II)V")
	private static synchronized void ensureCapacity(@OriginalArg(1) int arg1) {
		if (outBuffer.pos + arg1 >= 500) {
			@Pc(15) Packet local15 = outBuffer;
			outBuffer = Packet.alloc(1);
			oldBuffer = local15;
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IIIB)V")
	public static synchronized void mousePressed(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if (!enabled || (arg0 < 0 || arg0 >= 789 || arg2 < 0 || arg2 >= 532)) {
			return;
		}

		trackedCount++;
		@Pc(19) long local19 = System.currentTimeMillis();
		@Pc(25) long local25 = (local19 - lastTime) / 10L;
		if (local25 > 250L) {
			local25 = 250L;
		}
		lastTime = local19;
		ensureCapacity(5);
		if (arg1 == 1) {
			outBuffer.p1(1);
		} else {
			outBuffer.p1(2);
		}
		outBuffer.p1((int) local25);
		outBuffer.p3(arg0 + (arg2 << 10));
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(II)V")
	public static synchronized void mouseReleased(@OriginalArg(0) int arg0) {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - lastTime) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		lastTime = local8;
		ensureCapacity(2);
		if (arg0 == 1) {
			outBuffer.p1(3);
		} else {
			outBuffer.p1(4);
		}
		outBuffer.p1((int) local14);
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZI)V")
	public static synchronized void mouseMoved(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2) {
		if (!enabled || (arg2 < 0 || arg2 >= 789 || arg0 < 0 || arg0 >= 532)) {
			return;
		}

		@Pc(17) long local17 = System.currentTimeMillis();
		if (local17 - lastMoveTime < 50L) {
			return;
		}

		lastMoveTime = local17;
		trackedCount++;
		@Pc(39) long local39 = (local17 - lastTime) / 10L;
		if (local39 > 250L) {
			local39 = 250L;
		}
		lastTime = local17;
		if (arg2 - lastX < 8 && arg2 - lastX >= -8 && arg0 - lastY < 8 && arg0 - lastY >= -8) {
			ensureCapacity(3);
			outBuffer.p1(5);
			outBuffer.p1((int) local39);
			outBuffer.p1(arg2 + (arg0 - lastY + 8 << 4) + 8 - lastX);
		} else if (arg2 - lastX < 128 && arg2 - lastX >= -128 && arg0 - lastY < 128 && arg0 - lastY >= -128) {
			ensureCapacity(4);
			outBuffer.p1(6);
			outBuffer.p1((int) local39);
			outBuffer.p1(arg2 + 128 - lastX);
			outBuffer.p1(arg0 + 128 - lastY);
		} else {
			ensureCapacity(5);
			outBuffer.p1(7);
			outBuffer.p1((int) local39);
			outBuffer.p3(arg2 + (arg0 << 10));
		}
		lastX = arg2;
		lastY = arg0;
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZ)V")
	public static synchronized void keyPressed(@OriginalArg(0) int arg0) {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - lastTime) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		lastTime = local8;
		if (arg0 == 1000) {
			arg0 = 11;
		}
		if (arg0 == 1001) {
			arg0 = 12;
		}
		if (arg0 == 1002) {
			arg0 = 14;
		}
		if (arg0 == 1003) {
			arg0 = 15;
		}
		if (arg0 >= 1008) {
			arg0 -= 992;
		}
		ensureCapacity(3);
		outBuffer.p1(8);
		outBuffer.p1((int) local14);
		outBuffer.p1(arg0);
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(II)V")
	public static synchronized void keyReleased(@OriginalArg(0) int arg0) {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - lastTime) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		lastTime = local8;
		if (arg0 == 1000) {
			arg0 = 11;
		}
		if (arg0 == 1001) {
			arg0 = 12;
		}
		if (arg0 == 1002) {
			arg0 = 14;
		}
		if (arg0 == 1003) {
			arg0 = 15;
		}
		if (arg0 >= 1008) {
			arg0 -= 992;
		}
		ensureCapacity(3);
		outBuffer.p1(9);
		outBuffer.p1((int) local14);
		outBuffer.p1(arg0);
	}

	@OriginalMember(owner = "client!e", name = "d", descriptor = "(I)V")
	public static synchronized void focusGained() {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(11) long local11 = System.currentTimeMillis();
		@Pc(17) long local17 = (local11 - lastTime) / 10L;
		if (local17 > 250L) {
			local17 = 250L;
		}
		lastTime = local11;
		ensureCapacity(2);
		outBuffer.p1(10);
		outBuffer.p1((int) local17);
	}

	@OriginalMember(owner = "client!e", name = "e", descriptor = "(I)V")
	public static synchronized void focusLost() {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - lastTime) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		lastTime = local8;
		ensureCapacity(2);
		outBuffer.p1(11);
		outBuffer.p1((int) local14);
	}

	@OriginalMember(owner = "client!e", name = "f", descriptor = "(I)V")
	public static synchronized void mouseEntered() {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - lastTime) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		lastTime = local8;
		ensureCapacity(2);
		outBuffer.p1(12);
		outBuffer.p1((int) local14);
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(Z)V")
	public static synchronized void mouseExited() {
		if (!enabled) {
			return;
		}

		trackedCount++;
		@Pc(11) long local11 = System.currentTimeMillis();
		@Pc(17) long local17 = (local11 - lastTime) / 10L;
		if (local17 > 250L) {
			local17 = 250L;
		}
		lastTime = local11;
		ensureCapacity(2);
		outBuffer.p1(13);
		outBuffer.p1((int) local17);
	}
}
