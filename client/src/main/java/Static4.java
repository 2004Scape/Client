import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static4 {

	@OriginalMember(owner = "client!c", name = "e", descriptor = "I")
	public static int anInt81;

	@OriginalMember(owner = "client!c", name = "f", descriptor = "Z")
	public static boolean aBoolean24;

	@OriginalMember(owner = "client!c", name = "a", descriptor = "Z")
	private static boolean aBoolean21 = true;

	@OriginalMember(owner = "client!c", name = "d", descriptor = "Z")
	public static boolean aBoolean23 = true;

	@OriginalMember(owner = "client!c", name = "w", descriptor = "[I")
	public static final int[] anIntArray18 = new int[] { 1, 2, 4, 8 };

	@OriginalMember(owner = "client!c", name = "x", descriptor = "[I")
	public static final int[] anIntArray19 = new int[] { 16, 32, 64, 128 };

	@OriginalMember(owner = "client!c", name = "y", descriptor = "[I")
	public static final int[] anIntArray20 = new int[] { 1, 0, -1, 0 };

	@OriginalMember(owner = "client!c", name = "z", descriptor = "[I")
	public static final int[] anIntArray21 = new int[] { 0, -1, 0, 1 };

	@OriginalMember(owner = "client!c", name = "A", descriptor = "I")
	public static int anInt84 = (int) (Math.random() * 17.0D) - 8;

	@OriginalMember(owner = "client!c", name = "B", descriptor = "I")
	public static int anInt85 = (int) (Math.random() * 33.0D) - 16;

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(II)I")
	public static int method42(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(32) int local32 = method43(arg0 + 45365, arg1 + 91923, 4) + (method43(arg0 + 10294, arg1 + 37821, 2) - 128 >> 1) + (method43(arg0, arg1, 1) - 128 >> 2) - 128;
		local32 = (int) ((double) local32 * 0.3D) + 35;
		if (local32 < 10) {
			local32 = 10;
		} else if (local32 > 60) {
			local32 = 60;
		}
		return local32;
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(III)I")
	private static int method43(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(3) int local3 = arg0 / arg2;
		@Pc(9) int local9 = arg0 & arg2 - 1;
		@Pc(13) int local13 = arg1 / arg2;
		@Pc(19) int local19 = arg1 & arg2 - 1;
		@Pc(23) int local23 = method45(local3, local13);
		@Pc(29) int local29 = method45(local3 + 1, local13);
		@Pc(35) int local35 = method45(local3, local13 + 1);
		@Pc(43) int local43 = method45(local3 + 1, local13 + 1);
		@Pc(49) int local49 = method44(local23, local29, local9, arg2);
		@Pc(55) int local55 = method44(local35, local43, local9, arg2);
		return method44(local49, local55, local19, arg2);
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IIII)I")
	private static int method44(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(11) int local11 = 65536 - Class1_Sub3_Sub2_Sub1.anIntArray138[arg2 * 1024 / arg3] >> 1;
		return (arg0 * (65536 - local11) >> 16) + (arg1 * local11 >> 16);
	}

	@OriginalMember(owner = "client!c", name = "b", descriptor = "(II)I")
	private static int method45(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(31) int local31 = method46(arg0 - 1, arg1 - 1) + method46(arg0 + 1, arg1 - 1) + method46(arg0 - 1, arg1 + 1) + method46(arg0 + 1, arg1 + 1);
		@Pc(55) int local55 = method46(arg0 - 1, arg1) + method46(arg0 + 1, arg1) + method46(arg0, arg1 - 1) + method46(arg0, arg1 + 1);
		@Pc(59) int local59 = method46(arg0, arg1);
		return local31 / 16 + local55 / 8 + local59 / 4;
	}

	@OriginalMember(owner = "client!c", name = "c", descriptor = "(II)I")
	private static int method46(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(5) int local5 = arg0 + arg1 * 57;
		@Pc(11) int local11 = local5 << 13 ^ local5;
		@Pc(25) int local25 = local11 * (local11 * local11 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return local25 >> 19 & 0xFF;
	}

	@OriginalMember(owner = "client!c", name = "d", descriptor = "(II)I")
	public static int method47(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		if (arg0 == -1) {
			return 12345678;
		}
		arg1 = arg1 * (arg0 & 0x7F) / 128;
		if (arg1 < 2) {
			arg1 = 2;
		} else if (arg1 > 126) {
			arg1 = 126;
		}
		return (arg0 & 0xFF80) + arg1;
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(ILclient!ob;Lclient!ec;II[[[IIIIILclient!r;I)V")
	public static void method50(@OriginalArg(0) int arg0, @OriginalArg(1) Class28 arg1, @OriginalArg(2) Class9 arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int[][][] arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) Class33 arg10, @OriginalArg(11) int arg11) {
		try {
			if (arg6 != 0) {
				aBoolean21 = !aBoolean21;
			}
			@Pc(15) int local15 = arg5[arg11][arg0][arg3];
			@Pc(25) int local25 = arg5[arg11][arg0 + 1][arg3];
			@Pc(37) int local37 = arg5[arg11][arg0 + 1][arg3 + 1];
			@Pc(47) int local47 = arg5[arg11][arg0][arg3 + 1];
			@Pc(57) int local57 = local15 + local25 + local37 + local47 >> 2;
			@Pc(60) Class2 local60 = Static2.method23(arg8);
			@Pc(72) int local72 = arg0 + (arg3 << 7) + (arg8 << 14) + 1073741824;
			if (!local60.aBoolean9) {
				local72 += Integer.MIN_VALUE;
			}
			@Pc(86) byte local86 = (byte) ((arg4 << 6) + arg9);
			@Pc(99) Class1_Sub3_Sub1 local99;
			if (arg9 == 22) {
				local99 = local60.method26(22, arg4, local15, local25, local37, local47, -1);
				arg10.method473(local99, (byte) 6, arg0, local72, arg3, arg7, local86, local57);
				if (local60.aBoolean7 && local60.aBoolean9) {
					arg2.method252((byte) 12, arg3, arg0);
				}
				if (local60.anInt45 != -1) {
					arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 3, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
				}
			} else {
				@Pc(174) int local174;
				if (arg9 == 10 || arg9 == 11) {
					local99 = local60.method26(10, arg4, local15, local25, local37, local47, -1);
					if (local99 != null) {
						@Pc(161) int local161 = 0;
						if (arg9 == 11) {
							local161 += 256;
						}
						@Pc(177) int local177;
						if (arg4 == 1 || arg4 == 3) {
							local174 = local60.anInt44;
							local177 = local60.anInt43;
						} else {
							local174 = local60.anInt43;
							local177 = local60.anInt44;
						}
						arg10.method477(local57, 775, arg7, null, local72, arg3, arg0, local174, local86, local99, local161, local177);
					}
					if (local60.aBoolean7) {
						arg2.method251(arg4, local60.anInt44, local60.anInt43, arg0, 9, arg3, local60.aBoolean8);
					}
					if (local60.anInt45 != -1) {
						arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 2, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
					}
				} else if (arg9 >= 12) {
					local99 = local60.method26(arg9, arg4, local15, local25, local37, local47, -1);
					arg10.method477(local57, 775, arg7, null, local72, arg3, arg0, 1, local86, local99, 0, 1);
					if (local60.aBoolean7) {
						arg2.method251(arg4, local60.anInt44, local60.anInt43, arg0, 9, arg3, local60.aBoolean8);
					}
					if (local60.anInt45 != -1) {
						arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 2, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
					}
				} else if (arg9 == 0) {
					local99 = local60.method26(0, arg4, local15, local25, local37, local47, -1);
					arg10.method475(0, local57, arg7, anIntArray18[arg4], 8, local99, null, arg0, local72, arg3, local86);
					if (local60.aBoolean7) {
						arg2.method250(true, arg4, arg3, arg0, local60.aBoolean8, arg9);
					}
					if (local60.anInt45 != -1) {
						arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 0, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
					}
				} else if (arg9 == 1) {
					local99 = local60.method26(1, arg4, local15, local25, local37, local47, -1);
					arg10.method475(0, local57, arg7, anIntArray19[arg4], 8, local99, null, arg0, local72, arg3, local86);
					if (local60.aBoolean7) {
						arg2.method250(true, arg4, arg3, arg0, local60.aBoolean8, arg9);
					}
					if (local60.anInt45 != -1) {
						arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 0, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
					}
				} else {
					@Pc(430) int local430;
					@Pc(452) Class1_Sub3_Sub1 local452;
					if (arg9 == 2) {
						local430 = arg4 + 1 & 0x3;
						@Pc(442) Class1_Sub3_Sub1 local442 = local60.method26(2, arg4 + 4, local15, local25, local37, local47, -1);
						local452 = local60.method26(2, local430, local15, local25, local37, local47, -1);
						arg10.method475(anIntArray18[local430], local57, arg7, anIntArray18[arg4], 8, local442, local452, arg0, local72, arg3, local86);
						if (local60.aBoolean7) {
							arg2.method250(true, arg4, arg3, arg0, local60.aBoolean8, arg9);
						}
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 0, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 3) {
						local99 = local60.method26(3, arg4, local15, local25, local37, local47, -1);
						arg10.method475(0, local57, arg7, anIntArray19[arg4], 8, local99, null, arg0, local72, arg3, local86);
						if (local60.aBoolean7) {
							arg2.method250(true, arg4, arg3, arg0, local60.aBoolean8, arg9);
						}
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 0, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 9) {
						local99 = local60.method26(arg9, arg4, local15, local25, local37, local47, -1);
						arg10.method477(local57, 775, arg7, null, local72, arg3, arg0, 1, local86, local99, 0, 1);
						if (local60.aBoolean7) {
							arg2.method251(arg4, local60.anInt44, local60.anInt43, arg0, 9, arg3, local60.aBoolean8);
						}
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 2, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 4) {
						local99 = local60.method26(4, 0, local15, local25, local37, local47, -1);
						arg10.method476(local57, arg3, 0, local72, arg4 * 512, anIntArray18[arg4], 465, 0, arg0, local99, local86, arg7);
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 1, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 5) {
						local430 = 16;
						local174 = arg10.method494(arg7, arg0, arg3);
						if (local174 > 0) {
							local430 = Static2.method23(local174 >> 14 & 0x7FFF).anInt46;
						}
						local452 = local60.method26(4, 0, local15, local25, local37, local47, -1);
						arg10.method476(local57, arg3, anIntArray21[arg4] * local430, local72, arg4 * 512, anIntArray18[arg4], 465, anIntArray20[arg4] * local430, arg0, local452, local86, arg7);
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 1, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 6) {
						local99 = local60.method26(4, 0, local15, local25, local37, local47, -1);
						arg10.method476(local57, arg3, 0, local72, arg4, 256, 465, 0, arg0, local99, local86, arg7);
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 1, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 7) {
						local99 = local60.method26(4, 0, local15, local25, local37, local47, -1);
						arg10.method476(local57, arg3, 0, local72, arg4, 512, 465, 0, arg0, local99, local86, arg7);
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 1, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					} else if (arg9 == 8) {
						local99 = local60.method26(4, 0, local15, local25, local37, local47, -1);
						arg10.method476(local57, arg3, 0, local72, arg4, 768, 465, 0, arg0, local99, local86, arg7);
						if (local60.anInt45 != -1) {
							arg1.method453(new Class1_Sub6(true, arg8, arg7, 0, 1, Static20.aClass19Array1[local60.anInt45], arg3, arg0));
						}
					}
				}
			}
		} catch (@Pc(902) RuntimeException local902) {
			signlink.reporterror("74512, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + local902.toString());
			throw new RuntimeException();
		}
	}
}
