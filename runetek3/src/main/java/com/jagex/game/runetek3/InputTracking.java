package com.jagex.game.runetek3;

import com.jagex.core.io.Buffer;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

public final class InputTracking {

	@OriginalMember(owner = "client!e", name = "a", descriptor = "B")
	private static final byte flowObfuscator1 = 65;

	@OriginalMember(owner = "client!e", name = "b", descriptor = "I")
	private static int flowObfuscator2 = 78;

	@OriginalMember(owner = "client!e", name = "c", descriptor = "Z")
	private static boolean flowObfuscator3;

	@OriginalMember(owner = "client!e", name = "d", descriptor = "Z")
	private static boolean flowObfuscator4;

	@OriginalMember(owner = "client!e", name = "e", descriptor = "Z")
	public static boolean enabled;

	@OriginalMember(owner = "client!e", name = "f", descriptor = "Lclient!kb;")
	private static Buffer outBuffer = null;

	@OriginalMember(owner = "client!e", name = "g", descriptor = "Lclient!kb;")
	private static Buffer oldBuffer = null;

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
	public static synchronized void setEnabled(@OriginalArg(0) int arg0) {
		try {
			outBuffer = Buffer.alloc(1, -737);
			oldBuffer = null;
			lastTime = System.currentTimeMillis();
			if (arg0 != -31717) {
				flowObfuscator4 = !flowObfuscator4;
			}
			enabled = true;
		} catch (@Pc(20) RuntimeException local20) {
			Signlink.reporterror("89678, " + arg0 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(B)V")
	public static synchronized void setDisabled(@OriginalArg(0) byte arg0) {
		try {
			enabled = false;
			outBuffer = null;
			if (arg0 == flowObfuscator1) {
				oldBuffer = null;
			}
		} catch (@Pc(11) RuntimeException local11) {
			Signlink.reporterror("9859, " + arg0 + ", " + local11.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(I)Lclient!kb;")
	public static synchronized Buffer flush(@OriginalArg(0) int arg0) {
		try {
			@Pc(1) Buffer local1 = null;
			if (oldBuffer != null && enabled) {
				local1 = oldBuffer;
			}
			oldBuffer = null;
			if (arg0 >= 0) {
				flowObfuscator3 = !flowObfuscator3;
			}
			return local1;
		} catch (@Pc(20) RuntimeException local20) {
			Signlink.reporterror("67521, " + arg0 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(I)Lclient!kb;")
	public static synchronized Buffer stop(@OriginalArg(0) int arg0) {
		try {
			if (arg0 <= 0) {
				flowObfuscator4 = !flowObfuscator4;
			}
			@Pc(9) Buffer local9 = null;
			if (outBuffer != null && outBuffer.pos > 0 && enabled) {
				local9 = outBuffer;
			}
			setDisabled((byte) 65);
			return local9;
		} catch (@Pc(23) RuntimeException local23) {
			Signlink.reporterror("12569, " + arg0 + ", " + local23.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(II)V")
	private static synchronized void ensureCapacity(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 <= 0) {
				flowObfuscator3 = !flowObfuscator3;
			}
			if (outBuffer.pos + arg1 >= 500) {
				@Pc(15) Buffer local15 = outBuffer;
				outBuffer = Buffer.alloc(1, -737);
				oldBuffer = local15;
			}
		} catch (@Pc(23) RuntimeException local23) {
			Signlink.reporterror("3191, " + arg0 + ", " + arg1 + ", " + local23.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IIIB)V")
	public static synchronized void mousePressed(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte arg3) {
		try {
			if (enabled && (arg0 >= 0 && arg0 < 789 && arg2 >= 0 && arg2 < 532)) {
				trackedCount++;
				@Pc(19) long local19 = System.currentTimeMillis();
				@Pc(25) long local25 = (local19 - lastTime) / 10L;
				if (local25 > 250L) {
					local25 = 250L;
				}
				lastTime = local19;
				ensureCapacity(flowObfuscator2, 5);
				if (arg3 == 4) {
					if (arg1 == 1) {
						outBuffer.p1(1);
					} else {
						outBuffer.p1(2);
					}
					outBuffer.p1((int) local25);
					outBuffer.p3(arg0 + (arg2 << 10));
				}
			}
		} catch (@Pc(64) RuntimeException local64) {
			Signlink.reporterror("20421, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local64.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(II)V")
	public static synchronized void mouseReleased(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (enabled) {
				trackedCount++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - lastTime) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				lastTime = local8;
				if (arg1 == 0) {
					ensureCapacity(flowObfuscator2, 2);
					if (arg0 == 1) {
						outBuffer.p1(3);
					} else {
						outBuffer.p1(4);
					}
					outBuffer.p1((int) local14);
				}
			}
		} catch (@Pc(45) RuntimeException local45) {
			Signlink.reporterror("77824, " + arg0 + ", " + arg1 + ", " + local45.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZI)V")
	public static synchronized void mouseMoved(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		try {
			if (enabled && (arg2 >= 0 && arg2 < 789 && arg0 >= 0 && arg0 < 532)) {
				@Pc(17) long local17 = System.currentTimeMillis();
				if (!arg1) {
					flowObfuscator2 = 445;
				}
				if (local17 - lastMoveTime >= 50L) {
					lastMoveTime = local17;
					trackedCount++;
					@Pc(39) long local39 = (local17 - lastTime) / 10L;
					if (local39 > 250L) {
						local39 = 250L;
					}
					lastTime = local17;
					if (arg2 - lastX < 8 && arg2 - lastX >= -8 && arg0 - lastY < 8 && arg0 - lastY >= -8) {
						ensureCapacity(flowObfuscator2, 3);
						outBuffer.p1(5);
						outBuffer.p1((int) local39);
						outBuffer.p1(arg2 + (arg0 - lastY + 8 << 4) + 8 - lastX);
					} else if (arg2 - lastX < 128 && arg2 - lastX >= -128 && arg0 - lastY < 128 && arg0 - lastY >= -128) {
						ensureCapacity(flowObfuscator2, 4);
						outBuffer.p1(6);
						outBuffer.p1((int) local39);
						outBuffer.p1(arg2 + 128 - lastX);
						outBuffer.p1(arg0 + 128 - lastY);
					} else {
						ensureCapacity(flowObfuscator2, 5);
						outBuffer.p1(7);
						outBuffer.p1((int) local39);
						outBuffer.p3(arg2 + (arg0 << 10));
					}
					lastX = arg2;
					lastY = arg0;
				}
			}
		} catch (@Pc(163) RuntimeException local163) {
			Signlink.reporterror("20655, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local163.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZ)V")
	public static synchronized void keyPressed(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
		try {
			if (enabled) {
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
				ensureCapacity(flowObfuscator2, 3);
				if (!arg1) {
					for (@Pc(53) int local53 = 1; local53 > 0; local53++) {
					}
				}
				outBuffer.p1(8);
				outBuffer.p1((int) local14);
				outBuffer.p1(arg0);
			}
		} catch (@Pc(70) RuntimeException local70) {
			Signlink.reporterror("93007, " + arg0 + ", " + arg1 + ", " + local70.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(II)V")
	public static synchronized void keyReleased(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (enabled) {
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
				ensureCapacity(flowObfuscator2, 3);
				outBuffer.p1(9);
				outBuffer.p1((int) local14);
				outBuffer.p1(arg0);
				if (arg1 == 1) {
					;
				}
			}
		} catch (@Pc(64) RuntimeException local64) {
			Signlink.reporterror("36408, " + arg0 + ", " + arg1 + ", " + local64.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "d", descriptor = "(I)V")
	public static synchronized void focusGained(@OriginalArg(0) int arg0) {
		try {
			if (enabled) {
				trackedCount++;
				if (arg0 < 0) {
					@Pc(11) long local11 = System.currentTimeMillis();
					@Pc(17) long local17 = (local11 - lastTime) / 10L;
					if (local17 > 250L) {
						local17 = 250L;
					}
					lastTime = local11;
					ensureCapacity(flowObfuscator2, 2);
					outBuffer.p1(10);
					outBuffer.p1((int) local17);
				}
			}
		} catch (@Pc(37) RuntimeException local37) {
			Signlink.reporterror("23406, " + arg0 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "e", descriptor = "(I)V")
	public static synchronized void focusLost(@OriginalArg(0) int arg0) {
		try {
			if (enabled) {
				trackedCount++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - lastTime) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				lastTime = local8;
				ensureCapacity(flowObfuscator2, 2);
				if (arg0 != 0) {
					flowObfuscator4 = !flowObfuscator4;
				}
				outBuffer.p1(11);
				outBuffer.p1((int) local14);
			}
		} catch (@Pc(42) RuntimeException local42) {
			Signlink.reporterror("80777, " + arg0 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "f", descriptor = "(I)V")
	public static synchronized void mouseEntered(@OriginalArg(0) int arg0) {
		try {
			if (enabled) {
				trackedCount++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - lastTime) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				lastTime = local8;
				ensureCapacity(flowObfuscator2, 2);
				if (arg0 < 0) {
					outBuffer.p1(12);
					outBuffer.p1((int) local14);
				}
			}
		} catch (@Pc(39) RuntimeException local39) {
			Signlink.reporterror("47039, " + arg0 + ", " + local39.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(Z)V")
	public static synchronized void mouseExited(@OriginalArg(0) boolean arg0) {
		try {
			if (!arg0 && enabled) {
				trackedCount++;
				@Pc(11) long local11 = System.currentTimeMillis();
				@Pc(17) long local17 = (local11 - lastTime) / 10L;
				if (local17 > 250L) {
					local17 = 250L;
				}
				lastTime = local11;
				ensureCapacity(flowObfuscator2, 2);
				outBuffer.p1(13);
				outBuffer.p1((int) local17);
			}
		} catch (@Pc(37) RuntimeException local37) {
			Signlink.reporterror("76997, " + arg0 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}
}
