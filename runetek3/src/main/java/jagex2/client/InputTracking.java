package jagex2.client;

import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!e")
public class InputTracking {

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
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(I)Lclient!kb;")
	public static synchronized Packet flush() {
		@Pc(1) Packet buffer = null;
		if (oldBuffer != null && enabled) {
			buffer = oldBuffer;
		}
		oldBuffer = null;
		return buffer;
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(I)Lclient!kb;")
	public static synchronized Packet stop() {
		@Pc(9) Packet buffer = null;
		if (outBuffer != null && outBuffer.pos > 0 && enabled) {
			buffer = outBuffer;
		}
		setDisabled();
		return buffer;
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(II)V")
	private static synchronized void ensureCapacity(@OriginalArg(1) int n) {
		if (outBuffer.pos + n >= 500) {
			@Pc(15) Packet buffer = outBuffer;
			outBuffer = Packet.alloc(1);
			oldBuffer = buffer;
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IIIB)V")
	public static synchronized void mousePressed(@OriginalArg(0) int x, @OriginalArg(2) int y, @OriginalArg(1) int button) {
		if (enabled && (x >= 0 && x < 789 && y >= 0 && y < 532)) {
			trackedCount++;

			@Pc(19) long now = System.currentTimeMillis();
			@Pc(25) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			ensureCapacity(5);

			if (button == 1) {
				outBuffer.p1(1);
			} else {
				outBuffer.p1(2);
			}

			outBuffer.p1((int) delta);
			outBuffer.p3(x + (y << 10));
		}
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(II)V")
	public static synchronized void mouseReleased(@OriginalArg(0) int button) {
		if (enabled) {
			trackedCount++;

			@Pc(8) long now = System.currentTimeMillis();
			@Pc(14) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			ensureCapacity(2);

			if (button == 1) {
				outBuffer.p1(3);
			} else {
				outBuffer.p1(4);
			}

			outBuffer.p1((int) delta);
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZI)V")
	public static synchronized void mouseMoved(@OriginalArg(2) int x, @OriginalArg(0) int y) {
		if (enabled && (x >= 0 && x < 789 && y >= 0 && y < 532)) {
			@Pc(17) long now = System.currentTimeMillis();

			if (now - lastMoveTime >= 50L) {
				lastMoveTime = now;
				trackedCount++;

				@Pc(39) long delta = (now - lastTime) / 10L;
				if (delta > 250L) {
					delta = 250L;
				}

				lastTime = now;
				if (x - lastX < 8 && x - lastX >= -8 && y - lastY < 8 && y - lastY >= -8) {
					ensureCapacity(3);
					outBuffer.p1(5);
					outBuffer.p1((int) delta);
					outBuffer.p1(x + (y - lastY + 8 << 4) + 8 - lastX);
				} else if (x - lastX < 128 && x - lastX >= -128 && y - lastY < 128 && y - lastY >= -128) {
					ensureCapacity(4);
					outBuffer.p1(6);
					outBuffer.p1((int) delta);
					outBuffer.p1(x + 128 - lastX);
					outBuffer.p1(y + 128 - lastY);
				} else {
					ensureCapacity(5);
					outBuffer.p1(7);
					outBuffer.p1((int) delta);
					outBuffer.p3(x + (y << 10));
				}

				lastX = x;
				lastY = y;
			}
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZ)V")
	public static synchronized void keyPressed(@OriginalArg(0) int key) {
		if (enabled) {
			trackedCount++;

			@Pc(8) long now = System.currentTimeMillis();
			@Pc(14) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			if (key == 1000) {
				key = 11;
			} else if (key == 1001) {
				key = 12;
			} else if (key == 1002) {
				key = 14;
			} else if (key == 1003) {
				key = 15;
			} else if (key >= 1008) {
				key -= 992;
			}

			ensureCapacity(3);
			outBuffer.p1(8);
			outBuffer.p1((int) delta);
			outBuffer.p1(key);
		}
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(II)V")
	public static synchronized void keyReleased(@OriginalArg(0) int key) {
		if (enabled) {
			trackedCount++;

			@Pc(8) long now = System.currentTimeMillis();
			@Pc(14) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			if (key == 1000) {
				key = 11;
			} else if (key == 1001) {
				key = 12;
			} else if (key == 1002) {
				key = 14;
			} else if (key == 1003) {
				key = 15;
			} else if (key >= 1008) {
				key -= 992;
			}

			ensureCapacity(3);
			outBuffer.p1(9);
			outBuffer.p1((int) delta);
			outBuffer.p1(key);
		}
	}

	@OriginalMember(owner = "client!e", name = "d", descriptor = "(I)V")
	public static synchronized void focusGained() {
		if (enabled) {
			trackedCount++;

			@Pc(11) long now = System.currentTimeMillis();
			@Pc(17) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			ensureCapacity(2);
			outBuffer.p1(10);
			outBuffer.p1((int) delta);
		}
	}

	@OriginalMember(owner = "client!e", name = "e", descriptor = "(I)V")
	public static synchronized void focusLost() {
		if (enabled) {
			trackedCount++;

			@Pc(8) long now = System.currentTimeMillis();
			@Pc(14) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			ensureCapacity(2);
			outBuffer.p1(11);
			outBuffer.p1((int) delta);
		}
	}

	@OriginalMember(owner = "client!e", name = "f", descriptor = "(I)V")
	public static synchronized void mouseEntered() {
		if (enabled) {
			trackedCount++;

			@Pc(8) long now = System.currentTimeMillis();
			@Pc(14) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			ensureCapacity(2);
			outBuffer.p1(12);
			outBuffer.p1((int) delta);
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(Z)V")
	public static synchronized void mouseExited() {
		if (enabled) {
			trackedCount++;

			@Pc(11) long now = System.currentTimeMillis();
			@Pc(17) long delta = (now - lastTime) / 10L;
			if (delta > 250L) {
				delta = 250L;
			}

			lastTime = now;
			ensureCapacity(2);
			outBuffer.p1(13);
			outBuffer.p1((int) delta);
		}
	}
}
