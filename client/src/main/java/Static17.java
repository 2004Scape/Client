import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static17 {

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "I")
	public static int anInt467;

	@OriginalMember(owner = "client!hc", name = "b", descriptor = "Z")
	private static boolean aBoolean105;

	@OriginalMember(owner = "client!hc", name = "c", descriptor = "[Lclient!hc;")
	public static Class15[] aClass15Array1;

	@OriginalMember(owner = "client!hc", name = "hb", descriptor = "Lclient!s;")
	private static Class35 aClass35_6;

	@OriginalMember(owner = "client!hc", name = "ib", descriptor = "Lclient!s;")
	private static Class35 aClass35_7;

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;[Lclient!jb;ILclient!ub;)V")
	public static void method331(@OriginalArg(0) Class39 arg0, @OriginalArg(1) Class1_Sub3_Sub2_Sub4[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class39 arg3) {
		try {
			@Pc(5) int local5 = 17 / arg2;
			aClass35_6 = new Class35((byte) 0, 50000);
			aClass35_7 = new Class35((byte) 0, 50000);
			@Pc(27) Class1_Sub3_Sub3 local27 = new Class1_Sub3_Sub3(363, arg3.method536("data", null, (byte) 2));
			@Pc(29) int local29 = -1;
			@Pc(32) int local32 = local27.method393();
			aClass15Array1 = new Class15[local32];
			while (true) {
				@Pc(62) Class15 local62;
				do {
					if (local27.anInt561 >= local27.aByteArray7.length) {
						aClass35_6 = null;
						aClass35_7 = null;
						return;
					}
					@Pc(45) int local45 = local27.method393();
					if (local45 == 65535) {
						local29 = local27.method393();
						local45 = local27.method393();
					}
					local62 = aClass15Array1[local45] = new Class15();
					local62.anInt470 = local45;
					local62.anInt471 = local29;
					local62.anInt472 = local27.method391();
					local62.anInt473 = local27.method391();
					local62.anInt474 = local27.method393();
					local62.anInt475 = local27.method393();
					local62.anInt476 = local27.method393();
					local62.anInt479 = local27.method391();
					if (local62.anInt479 == 0) {
						local62.anInt479 = -1;
					} else {
						local62.anInt479 = (local62.anInt479 - 1 << 8) + local27.method391();
					}
					@Pc(114) int local114 = local27.method391();
					@Pc(126) int local126;
					if (local114 > 0) {
						local62.anIntArray151 = new int[local114];
						local62.anIntArray152 = new int[local114];
						for (local126 = 0; local126 < local114; local126++) {
							local62.anIntArray151[local126] = local27.method391();
							local62.anIntArray152[local126] = local27.method393();
						}
					}
					local126 = local27.method391();
					@Pc(155) int local155;
					@Pc(160) int local160;
					if (local126 > 0) {
						local62.anIntArrayArray15 = new int[local126][];
						for (local155 = 0; local155 < local126; local155++) {
							local160 = local27.method393();
							local62.anIntArrayArray15[local155] = new int[local160];
							for (@Pc(168) int local168 = 0; local168 < local160; local168++) {
								local62.anIntArrayArray15[local155][local168] = local27.method393();
							}
						}
					}
					if (local62.anInt472 == 0) {
						local62.anInt480 = local27.method393();
						local62.aBoolean106 = local27.method391() == 1;
						local155 = local27.method391();
						local62.anIntArray153 = new int[local155];
						local62.anIntArray154 = new int[local155];
						local62.anIntArray155 = new int[local155];
						for (local160 = 0; local160 < local155; local160++) {
							local62.anIntArray153[local160] = local27.method393();
							local62.anIntArray154[local160] = local27.method394();
							local62.anIntArray155[local160] = local27.method394();
						}
					}
					if (local62.anInt472 == 1) {
						local62.anInt482 = local27.method393();
						local62.aBoolean107 = local27.method391() == 1;
					}
					if (local62.anInt472 == 2) {
						local62.anIntArray149 = new int[local62.anInt475 * local62.anInt476];
						local62.anIntArray150 = new int[local62.anInt475 * local62.anInt476];
						local62.aBoolean108 = local27.method391() == 1;
						local62.aBoolean109 = local27.method391() == 1;
						local62.aBoolean110 = local27.method391() == 1;
						local62.anInt483 = local27.method391();
						local62.anInt484 = local27.method391();
						local62.anIntArray156 = new int[20];
						local62.anIntArray157 = new int[20];
						local62.aClass1_Sub3_Sub2_Sub2Array8 = new Class1_Sub3_Sub2_Sub2[20];
						for (local155 = 0; local155 < 20; local155++) {
							local160 = local27.method391();
							if (local160 == 1) {
								local62.anIntArray156[local155] = local27.method394();
								local62.anIntArray157[local155] = local27.method394();
								@Pc(352) String local352 = local27.method398();
								if (arg0 != null && local352.length() > 0) {
									@Pc(361) int local361 = local352.lastIndexOf(",");
									local62.aClass1_Sub3_Sub2_Sub2Array8[local155] = method333(arg0, Integer.parseInt(local352.substring(local361 + 1)), local352.substring(0, local361), -36068);
								}
							}
						}
						local62.aStringArray10 = new String[5];
						for (local160 = 0; local160 < 5; local160++) {
							local62.aStringArray10[local160] = local27.method398();
							if (local62.aStringArray10[local160].length() == 0) {
								local62.aStringArray10[local160] = null;
							}
						}
					}
					if (local62.anInt472 == 3) {
						local62.aBoolean111 = local27.method391() == 1;
					}
					if (local62.anInt472 == 4 || local62.anInt472 == 1) {
						local62.aBoolean112 = local27.method391() == 1;
						local155 = local27.method391();
						if (arg1 != null) {
							local62.aClass1_Sub3_Sub2_Sub4_5 = arg1[local155];
						}
						local62.aBoolean113 = local27.method391() == 1;
					}
					if (local62.anInt472 == 4) {
						local62.aString20 = local27.method398();
						local62.aString21 = local27.method398();
					}
					if (local62.anInt472 == 1 || local62.anInt472 == 3 || local62.anInt472 == 4) {
						local62.anInt485 = local27.method396();
					}
					if (local62.anInt472 == 3 || local62.anInt472 == 4) {
						local62.anInt486 = local27.method396();
						local62.anInt487 = local27.method396();
					}
					if (local62.anInt472 == 5) {
						@Pc(511) String local511 = local27.method398();
						if (arg0 != null && local511.length() > 0) {
							local160 = local511.lastIndexOf(",");
							local62.aClass1_Sub3_Sub2_Sub2_12 = method333(arg0, Integer.parseInt(local511.substring(local160 + 1)), local511.substring(0, local160), -36068);
						}
						local511 = local27.method398();
						if (arg0 != null && local511.length() > 0) {
							local160 = local511.lastIndexOf(",");
							local62.aClass1_Sub3_Sub2_Sub2_13 = method333(arg0, Integer.parseInt(local511.substring(local160 + 1)), local511.substring(0, local160), -36068);
						}
					}
					if (local62.anInt472 == 6) {
						local45 = local27.method391();
						if (local45 != 0) {
							local62.aClass1_Sub3_Sub1_2 = method334(4, (local45 - 1 << 8) + local27.method391());
						}
						local45 = local27.method391();
						if (local45 != 0) {
							local62.aClass1_Sub3_Sub1_3 = method334(4, (local45 - 1 << 8) + local27.method391());
						}
						local45 = local27.method391();
						if (local45 == 0) {
							local62.anInt488 = -1;
						} else {
							local62.anInt488 = (local45 - 1 << 8) + local27.method391();
						}
						local45 = local27.method391();
						if (local45 == 0) {
							local62.anInt489 = -1;
						} else {
							local62.anInt489 = (local45 - 1 << 8) + local27.method391();
						}
						local62.anInt490 = local27.method393();
						local62.anInt491 = local27.method393();
						local62.anInt492 = local27.method393();
					}
					if (local62.anInt472 == 7) {
						local62.anIntArray149 = new int[local62.anInt475 * local62.anInt476];
						local62.anIntArray150 = new int[local62.anInt475 * local62.anInt476];
						local62.aBoolean112 = local27.method391() == 1;
						local155 = local27.method391();
						if (arg1 != null) {
							local62.aClass1_Sub3_Sub2_Sub4_5 = arg1[local155];
						}
						local62.aBoolean113 = local27.method391() == 1;
						local62.anInt485 = local27.method396();
						local62.anInt483 = local27.method394();
						local62.anInt484 = local27.method394();
						local62.aBoolean109 = local27.method391() == 1;
						local62.aStringArray10 = new String[5];
						for (local160 = 0; local160 < 5; local160++) {
							local62.aStringArray10[local160] = local27.method398();
							if (local62.aStringArray10[local160].length() == 0) {
								local62.aStringArray10[local160] = null;
							}
						}
					}
					if (local62.anInt473 == 2 || local62.anInt472 == 2) {
						local62.aString22 = local27.method398();
						local62.aString23 = local27.method398();
						local62.anInt493 = local27.method393();
					}
				} while (local62.anInt473 != 1 && local62.anInt473 != 4 && local62.anInt473 != 5 && local62.anInt473 != 6);
				local62.aString24 = local27.method398();
				if (local62.aString24.length() == 0) {
					if (local62.anInt473 == 1) {
						local62.aString24 = "Ok";
					}
					if (local62.anInt473 == 4) {
						local62.aString24 = "Select";
					}
					if (local62.anInt473 == 5) {
						local62.aString24 = "Select";
					}
					if (local62.anInt473 == 6) {
						local62.aString24 = "Continue";
					}
				}
			}
		} catch (@Pc(834) RuntimeException local834) {
			signlink.reporterror("9595, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local834.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;ILjava/lang/String;I)Lclient!hb;")
	private static Class1_Sub3_Sub2_Sub2 method333(@OriginalArg(0) Class39 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(8) long local8 = (Static30.method540(0, arg2) << 8) + (long) arg1;
			@Pc(13) Class1_Sub3_Sub2_Sub2 local13 = (Class1_Sub3_Sub2_Sub2) aClass35_6.method527(local8);
			if (arg3 != -36068) {
				throw new NullPointerException();
			} else if (local13 == null) {
				try {
					local13 = new Class1_Sub3_Sub2_Sub2(arg0, arg2, arg1);
					aClass35_6.method528(6, local8, local13);
					return local13;
				} catch (@Pc(38) Exception local38) {
					return null;
				}
			} else {
				return local13;
			}
		} catch (@Pc(43) RuntimeException local43) {
			signlink.reporterror("51863, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local43.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(II)Lclient!eb;")
	private static Class1_Sub3_Sub1 method334(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(5) Class1_Sub3_Sub1 local5 = (Class1_Sub3_Sub1) aClass35_7.method527((long) arg1);
			if (arg0 != 4) {
				aBoolean105 = !aBoolean105;
			}
			if (local5 == null) {
				local5 = new Class1_Sub3_Sub1(false, arg1);
				aClass35_7.method528(6, (long) arg1, local5);
				return local5;
			} else {
				return local5;
			}
		} catch (@Pc(33) RuntimeException local33) {
			signlink.reporterror("7272, " + arg0 + ", " + arg1 + ", " + local33.toString());
			throw new RuntimeException();
		}
	}
}
