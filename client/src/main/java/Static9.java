import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static9 {

	@OriginalMember(owner = "client!e", name = "c", descriptor = "Z")
	private static boolean aBoolean79;

	@OriginalMember(owner = "client!e", name = "d", descriptor = "Z")
	private static boolean aBoolean80;

	@OriginalMember(owner = "client!e", name = "e", descriptor = "Z")
	public static boolean aBoolean81;

	@OriginalMember(owner = "client!e", name = "h", descriptor = "J")
	private static long aLong11;

	@OriginalMember(owner = "client!e", name = "i", descriptor = "I")
	private static int anInt352;

	@OriginalMember(owner = "client!e", name = "j", descriptor = "J")
	private static long aLong12;

	@OriginalMember(owner = "client!e", name = "k", descriptor = "I")
	private static int anInt353;

	@OriginalMember(owner = "client!e", name = "l", descriptor = "I")
	private static int anInt354;

	@OriginalMember(owner = "client!e", name = "a", descriptor = "B")
	private static final byte aByte18 = 65;

	@OriginalMember(owner = "client!e", name = "b", descriptor = "I")
	private static int anInt351 = 78;

	@OriginalMember(owner = "client!e", name = "f", descriptor = "Lclient!kb;")
	private static Class1_Sub3_Sub3 aClass1_Sub3_Sub3_7 = null;

	@OriginalMember(owner = "client!e", name = "g", descriptor = "Lclient!kb;")
	private static Class1_Sub3_Sub3 aClass1_Sub3_Sub3_8 = null;

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(I)V")
	public static synchronized void method208(@OriginalArg(0) int arg0) {
		try {
			aClass1_Sub3_Sub3_7 = Static21.method378(1, -737);
			aClass1_Sub3_Sub3_8 = null;
			aLong11 = System.currentTimeMillis();
			if (arg0 != -31717) {
				aBoolean80 = !aBoolean80;
			}
			aBoolean81 = true;
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("89678, " + arg0 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(B)V")
	public static synchronized void method209(@OriginalArg(0) byte arg0) {
		try {
			aBoolean81 = false;
			aClass1_Sub3_Sub3_7 = null;
			if (arg0 == aByte18) {
				aClass1_Sub3_Sub3_8 = null;
			}
		} catch (@Pc(11) RuntimeException local11) {
			signlink.reporterror("9859, " + arg0 + ", " + local11.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(I)Lclient!kb;")
	public static synchronized Class1_Sub3_Sub3 method210(@OriginalArg(0) int arg0) {
		try {
			@Pc(1) Class1_Sub3_Sub3 local1 = null;
			if (aClass1_Sub3_Sub3_8 != null && aBoolean81) {
				local1 = aClass1_Sub3_Sub3_8;
			}
			aClass1_Sub3_Sub3_8 = null;
			if (arg0 >= 0) {
				aBoolean79 = !aBoolean79;
			}
			return local1;
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("67521, " + arg0 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(I)Lclient!kb;")
	public static synchronized Class1_Sub3_Sub3 method211(@OriginalArg(0) int arg0) {
		try {
			if (arg0 <= 0) {
				aBoolean80 = !aBoolean80;
			}
			@Pc(9) Class1_Sub3_Sub3 local9 = null;
			if (aClass1_Sub3_Sub3_7 != null && aClass1_Sub3_Sub3_7.anInt561 > 0 && aBoolean81) {
				local9 = aClass1_Sub3_Sub3_7;
			}
			method209((byte) 65);
			return local9;
		} catch (@Pc(23) RuntimeException local23) {
			signlink.reporterror("12569, " + arg0 + ", " + local23.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(II)V")
	private static synchronized void method212(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 <= 0) {
				aBoolean79 = !aBoolean79;
			}
			if (aClass1_Sub3_Sub3_7.anInt561 + arg1 >= 500) {
				@Pc(15) Class1_Sub3_Sub3 local15 = aClass1_Sub3_Sub3_7;
				aClass1_Sub3_Sub3_7 = Static21.method378(1, -737);
				aClass1_Sub3_Sub3_8 = local15;
			}
		} catch (@Pc(23) RuntimeException local23) {
			signlink.reporterror("3191, " + arg0 + ", " + arg1 + ", " + local23.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IIIB)V")
	public static synchronized void method213(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte arg3) {
		try {
			if (aBoolean81 && (arg0 >= 0 && arg0 < 789 && arg2 >= 0 && arg2 < 532)) {
				anInt352++;
				@Pc(19) long local19 = System.currentTimeMillis();
				@Pc(25) long local25 = (local19 - aLong11) / 10L;
				if (local25 > 250L) {
					local25 = 250L;
				}
				aLong11 = local19;
				method212(anInt351, 5);
				if (arg3 == 4) {
					if (arg1 == 1) {
						aClass1_Sub3_Sub3_7.method381(1);
					} else {
						aClass1_Sub3_Sub3_7.method381(2);
					}
					aClass1_Sub3_Sub3_7.method381((int) local25);
					aClass1_Sub3_Sub3_7.method384(arg0 + (arg2 << 10));
				}
			}
		} catch (@Pc(64) RuntimeException local64) {
			signlink.reporterror("20421, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local64.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "b", descriptor = "(II)V")
	public static synchronized void method214(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (aBoolean81) {
				anInt352++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - aLong11) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				aLong11 = local8;
				if (arg1 == 0) {
					method212(anInt351, 2);
					if (arg0 == 1) {
						aClass1_Sub3_Sub3_7.method381(3);
					} else {
						aClass1_Sub3_Sub3_7.method381(4);
					}
					aClass1_Sub3_Sub3_7.method381((int) local14);
				}
			}
		} catch (@Pc(45) RuntimeException local45) {
			signlink.reporterror("77824, " + arg0 + ", " + arg1 + ", " + local45.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZI)V")
	public static synchronized void method215(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		try {
			if (aBoolean81 && (arg2 >= 0 && arg2 < 789 && arg0 >= 0 && arg0 < 532)) {
				@Pc(17) long local17 = System.currentTimeMillis();
				if (!arg1) {
					anInt351 = 445;
				}
				if (local17 - aLong12 >= 50L) {
					aLong12 = local17;
					anInt352++;
					@Pc(39) long local39 = (local17 - aLong11) / 10L;
					if (local39 > 250L) {
						local39 = 250L;
					}
					aLong11 = local17;
					if (arg2 - anInt353 < 8 && arg2 - anInt353 >= -8 && arg0 - anInt354 < 8 && arg0 - anInt354 >= -8) {
						method212(anInt351, 3);
						aClass1_Sub3_Sub3_7.method381(5);
						aClass1_Sub3_Sub3_7.method381((int) local39);
						aClass1_Sub3_Sub3_7.method381(arg2 + (arg0 - anInt354 + 8 << 4) + 8 - anInt353);
					} else if (arg2 - anInt353 < 128 && arg2 - anInt353 >= -128 && arg0 - anInt354 < 128 && arg0 - anInt354 >= -128) {
						method212(anInt351, 4);
						aClass1_Sub3_Sub3_7.method381(6);
						aClass1_Sub3_Sub3_7.method381((int) local39);
						aClass1_Sub3_Sub3_7.method381(arg2 + 128 - anInt353);
						aClass1_Sub3_Sub3_7.method381(arg0 + 128 - anInt354);
					} else {
						method212(anInt351, 5);
						aClass1_Sub3_Sub3_7.method381(7);
						aClass1_Sub3_Sub3_7.method381((int) local39);
						aClass1_Sub3_Sub3_7.method384(arg2 + (arg0 << 10));
					}
					anInt353 = arg2;
					anInt354 = arg0;
				}
			}
		} catch (@Pc(163) RuntimeException local163) {
			signlink.reporterror("20655, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local163.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(IZ)V")
	public static synchronized void method216(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
		try {
			if (aBoolean81) {
				anInt352++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - aLong11) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				aLong11 = local8;
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
				method212(anInt351, 3);
				if (!arg1) {
					for (@Pc(53) int local53 = 1; local53 > 0; local53++) {
					}
				}
				aClass1_Sub3_Sub3_7.method381(8);
				aClass1_Sub3_Sub3_7.method381((int) local14);
				aClass1_Sub3_Sub3_7.method381(arg0);
			}
		} catch (@Pc(70) RuntimeException local70) {
			signlink.reporterror("93007, " + arg0 + ", " + arg1 + ", " + local70.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "c", descriptor = "(II)V")
	public static synchronized void method217(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (aBoolean81) {
				anInt352++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - aLong11) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				aLong11 = local8;
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
				method212(anInt351, 3);
				aClass1_Sub3_Sub3_7.method381(9);
				aClass1_Sub3_Sub3_7.method381((int) local14);
				aClass1_Sub3_Sub3_7.method381(arg0);
				if (arg1 == 1) {
					;
				}
			}
		} catch (@Pc(64) RuntimeException local64) {
			signlink.reporterror("36408, " + arg0 + ", " + arg1 + ", " + local64.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "d", descriptor = "(I)V")
	public static synchronized void method218(@OriginalArg(0) int arg0) {
		try {
			if (aBoolean81) {
				anInt352++;
				if (arg0 < 0) {
					@Pc(11) long local11 = System.currentTimeMillis();
					@Pc(17) long local17 = (local11 - aLong11) / 10L;
					if (local17 > 250L) {
						local17 = 250L;
					}
					aLong11 = local11;
					method212(anInt351, 2);
					aClass1_Sub3_Sub3_7.method381(10);
					aClass1_Sub3_Sub3_7.method381((int) local17);
				}
			}
		} catch (@Pc(37) RuntimeException local37) {
			signlink.reporterror("23406, " + arg0 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "e", descriptor = "(I)V")
	public static synchronized void method219(@OriginalArg(0) int arg0) {
		try {
			if (aBoolean81) {
				anInt352++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - aLong11) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				aLong11 = local8;
				method212(anInt351, 2);
				if (arg0 != 0) {
					aBoolean80 = !aBoolean80;
				}
				aClass1_Sub3_Sub3_7.method381(11);
				aClass1_Sub3_Sub3_7.method381((int) local14);
			}
		} catch (@Pc(42) RuntimeException local42) {
			signlink.reporterror("80777, " + arg0 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "f", descriptor = "(I)V")
	public static synchronized void method220(@OriginalArg(0) int arg0) {
		try {
			if (aBoolean81) {
				anInt352++;
				@Pc(8) long local8 = System.currentTimeMillis();
				@Pc(14) long local14 = (local8 - aLong11) / 10L;
				if (local14 > 250L) {
					local14 = 250L;
				}
				aLong11 = local8;
				method212(anInt351, 2);
				if (arg0 < 0) {
					aClass1_Sub3_Sub3_7.method381(12);
					aClass1_Sub3_Sub3_7.method381((int) local14);
				}
			}
		} catch (@Pc(39) RuntimeException local39) {
			signlink.reporterror("47039, " + arg0 + ", " + local39.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!e", name = "a", descriptor = "(Z)V")
	public static synchronized void method221(@OriginalArg(0) boolean arg0) {
		try {
			if (!arg0 && aBoolean81) {
				anInt352++;
				@Pc(11) long local11 = System.currentTimeMillis();
				@Pc(17) long local17 = (local11 - aLong11) / 10L;
				if (local17 > 250L) {
					local17 = 250L;
				}
				aLong11 = local11;
				method212(anInt351, 2);
				aClass1_Sub3_Sub3_7.method381(13);
				aClass1_Sub3_Sub3_7.method381((int) local17);
			}
		} catch (@Pc(37) RuntimeException local37) {
			signlink.reporterror("76997, " + arg0 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}
}
