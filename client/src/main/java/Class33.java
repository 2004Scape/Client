import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!r")
public final class Class33 {

	@OriginalMember(owner = "client!r", name = "c", descriptor = "I")
	private int anInt688;

	@OriginalMember(owner = "client!r", name = "n", descriptor = "I")
	private int anInt694;

	@OriginalMember(owner = "client!r", name = "o", descriptor = "I")
	private int anInt695;

	@OriginalMember(owner = "client!r", name = "hb", descriptor = "I")
	private int anInt718;

	@OriginalMember(owner = "client!r", name = "a", descriptor = "Z")
	private boolean aBoolean141 = false;

	@OriginalMember(owner = "client!r", name = "b", descriptor = "B")
	private final byte aByte36 = 6;

	@OriginalMember(owner = "client!r", name = "d", descriptor = "B")
	private final byte aByte37 = 1;

	@OriginalMember(owner = "client!r", name = "p", descriptor = "[Lclient!p;")
	private final Class29[] aClass29Array2 = new Class29[5000];

	@OriginalMember(owner = "client!r", name = "fb", descriptor = "[I")
	private final int[] anIntArray211 = new int[10000];

	@OriginalMember(owner = "client!r", name = "gb", descriptor = "[I")
	private final int[] anIntArray212 = new int[10000];

	@OriginalMember(owner = "client!r", name = "ib", descriptor = "[[I")
	private final int[][] anIntArrayArray18 = new int[][] { new int[16], { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 } };

	@OriginalMember(owner = "client!r", name = "jb", descriptor = "[[I")
	private final int[][] anIntArrayArray19 = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, { 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 }, { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, { 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 } };

	@OriginalMember(owner = "client!r", name = "i", descriptor = "I")
	private final int anInt691;

	@OriginalMember(owner = "client!r", name = "j", descriptor = "I")
	private final int anInt692;

	@OriginalMember(owner = "client!r", name = "k", descriptor = "I")
	private final int anInt693;

	@OriginalMember(owner = "client!r", name = "m", descriptor = "[[[Lclient!cb;")
	private final Class1_Sub2[][][] aClass1_Sub2ArrayArrayArray1;

	@OriginalMember(owner = "client!r", name = "q", descriptor = "[[[I")
	private final int[][][] anIntArrayArrayArray5;

	@OriginalMember(owner = "client!r", name = "l", descriptor = "[[[I")
	private final int[][][] anIntArrayArrayArray4;

	@OriginalMember(owner = "client!r", name = "<init>", descriptor = "(I[[[IIII)V")
	public Class33(@OriginalArg(0) int arg0, @OriginalArg(1) int[][][] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			this.anInt691 = arg3;
			this.anInt692 = arg4;
			this.anInt693 = arg2;
			this.aClass1_Sub2ArrayArrayArray1 = new Class1_Sub2[arg3][arg4][arg2];
			this.anIntArrayArrayArray5 = new int[arg3][arg4 + 1][arg2 + 1];
			@Pc(834) int local834 = 27 / arg0;
			this.anIntArrayArrayArray4 = arg1;
			this.method467(742);
		} catch (@Pc(849) RuntimeException local849) {
			signlink.reporterror("40163, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local849.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(I)V")
	public void method467(@OriginalArg(0) int arg0) {
		try {
			@Pc(7) int local7;
			@Pc(11) int local11;
			for (@Pc(3) int local3 = 0; local3 < this.anInt691; local3++) {
				for (local7 = 0; local7 < this.anInt692; local7++) {
					for (local11 = 0; local11 < this.anInt693; local11++) {
						this.aClass1_Sub2ArrayArrayArray1[local3][local7][local11] = null;
					}
				}
			}
			@Pc(41) int local41 = 38 / arg0;
			for (local7 = 0; local7 < Static25.anInt716; local7++) {
				for (local11 = 0; local11 < Static25.anIntArray202[local7]; local11++) {
					Static25.aClass24ArrayArray1[local7][local11] = null;
				}
				Static25.anIntArray202[local7] = 0;
			}
			for (local11 = 0; local11 < this.anInt695; local11++) {
				this.aClass29Array2[local11] = null;
			}
			this.anInt695 = 0;
			for (@Pc(88) int local88 = 0; local88 < Static25.aClass29Array3.length; local88++) {
				Static25.aClass29Array3[local88] = null;
			}
		} catch (@Pc(101) RuntimeException local101) {
			signlink.reporterror("14196, " + arg0 + ", " + local101.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(II)V")
	public void method468(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			this.anInt694 = arg1;
			@Pc(10) int local10;
			for (@Pc(6) int local6 = 0; local6 < this.anInt692; local6++) {
				for (local10 = 0; local10 < this.anInt693; local10++) {
					this.aClass1_Sub2ArrayArrayArray1[arg1][local6][local10] = new Class1_Sub2(arg1, local6, local10);
				}
			}
			if (arg0 != 0) {
				for (local10 = 1; local10 > 0; local10++) {
				}
			}
		} catch (@Pc(47) RuntimeException local47) {
			signlink.reporterror("95265, " + arg0 + ", " + arg1 + ", " + local47.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIB)V")
	public void method469(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) byte arg2) {
		try {
			@Pc(10) Class1_Sub2 local10 = this.aClass1_Sub2ArrayArrayArray1[0][arg1][arg0];
			for (@Pc(12) int local12 = 0; local12 < 3; local12++) {
				this.aClass1_Sub2ArrayArrayArray1[local12][arg1][arg0] = this.aClass1_Sub2ArrayArrayArray1[local12 + 1][arg1][arg0];
				if (this.aClass1_Sub2ArrayArrayArray1[local12][arg1][arg0] != null) {
					this.aClass1_Sub2ArrayArrayArray1[local12][arg1][arg0].anInt87--;
				}
			}
			if (this.aClass1_Sub2ArrayArrayArray1[0][arg1][arg0] == null) {
				this.aClass1_Sub2ArrayArrayArray1[0][arg1][arg0] = new Class1_Sub2(0, arg1, arg0);
			}
			this.aClass1_Sub2ArrayArrayArray1[0][arg1][arg0].aClass1_Sub2_1 = local10;
			this.aClass1_Sub2ArrayArrayArray1[3][arg1][arg0] = null;
			if (arg2 != -41) {
				for (@Pc(105) int local105 = 1; local105 > 0; local105++) {
				}
			}
		} catch (@Pc(112) RuntimeException local112) {
			signlink.reporterror("30933, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local112.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIII)V")
	public void method471(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2];
		if (local8 != null) {
			this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2].anInt93 = arg3;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIIIIIIIIIIIIII)V")
	public void method472(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13, @OriginalArg(14) int arg14, @OriginalArg(15) int arg15, @OriginalArg(16) int arg16, @OriginalArg(17) int arg17, @OriginalArg(18) int arg18, @OriginalArg(19) int arg19) {
		@Pc(14) Class27 local14;
		@Pc(16) int local16;
		if (arg3 == 0) {
			local14 = new Class27(arg10, arg11, arg12, arg13, -1, arg18, false);
			for (local16 = arg0; local16 >= 0; local16--) {
				if (this.aClass1_Sub2ArrayArrayArray1[local16][arg1][arg2] == null) {
					this.aClass1_Sub2ArrayArrayArray1[local16][arg1][arg2] = new Class1_Sub2(local16, arg1, arg2);
				}
			}
			this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2].aClass27_1 = local14;
		} else if (arg3 == 1) {
			local14 = new Class27(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);
			for (local16 = arg0; local16 >= 0; local16--) {
				if (this.aClass1_Sub2ArrayArrayArray1[local16][arg1][arg2] == null) {
					this.aClass1_Sub2ArrayArrayArray1[local16][arg1][arg2] = new Class1_Sub2(local16, arg1, arg2);
				}
			}
			this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2].aClass27_1 = local14;
		} else {
			@Pc(145) Class16 local145 = new Class16(arg1, arg3, arg15, arg7, arg12, arg4, arg10, arg9, arg19, arg14, arg5, arg17, arg18, arg8, arg16, arg13, 10659, arg6, arg2, arg11);
			for (local16 = arg0; local16 >= 0; local16--) {
				if (this.aClass1_Sub2ArrayArrayArray1[local16][arg1][arg2] == null) {
					this.aClass1_Sub2ArrayArrayArray1[local16][arg1][arg2] = new Class1_Sub2(local16, arg1, arg2);
				}
			}
			this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2].aClass16_1 = local145;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;BIIIIBI)V")
	public void method473(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) byte arg6, @OriginalArg(7) int arg7) {
		try {
			@Pc(3) Class18 local3 = new Class18();
			local3.aClass1_Sub3_Sub1_4 = arg0;
			local3.anInt521 = arg2 * 128 + 64;
			local3.anInt522 = arg4 * 128 + 64;
			local3.anInt520 = arg7;
			local3.anInt523 = arg3;
			local3.aByte25 = arg6;
			if (this.aClass1_Sub2ArrayArrayArray1[arg5][arg2][arg4] == null) {
				this.aClass1_Sub2ArrayArrayArray1[arg5][arg2][arg4] = new Class1_Sub2(arg5, arg2, arg4);
			}
			this.aClass1_Sub2ArrayArrayArray1[arg5][arg2][arg4].aClass18_1 = local3;
			if (arg1 == this.aByte36) {
				@Pc(68) boolean local68 = false;
			} else {
				Static25.aBoolean142 = !Static25.aBoolean142;
			}
		} catch (@Pc(77) RuntimeException local77) {
			signlink.reporterror("77662, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + local77.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IIIIILclient!eb;I)V")
	public void method474(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) Class1_Sub3_Sub1 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) Class1_Sub3_Sub1 arg7, @OriginalArg(8) int arg8) {
		try {
			@Pc(3) Class20 local3 = new Class20();
			local3.aClass1_Sub3_Sub1_5 = arg0;
			@Pc(10) int local10 = 90 / arg8;
			local3.anInt550 = arg6 * 128 + 64;
			local3.anInt551 = arg5 * 128 + 64;
			local3.anInt549 = arg2;
			local3.anInt552 = arg4;
			local3.aClass1_Sub3_Sub1_6 = arg1;
			local3.aClass1_Sub3_Sub1_7 = arg7;
			@Pc(38) int local38 = 0;
			@Pc(47) Class1_Sub2 local47 = this.aClass1_Sub2ArrayArrayArray1[arg3][arg6][arg5];
			if (local47 != null) {
				for (@Pc(51) int local51 = 0; local51 < local47.anInt91; local51++) {
					@Pc(60) int local60 = local47.aClass29Array1[local51].aClass1_Sub3_Sub1_8.anInt372;
					if (local60 > local38) {
						local38 = local60;
					}
				}
			}
			local3.anInt553 = local38;
			if (this.aClass1_Sub2ArrayArrayArray1[arg3][arg6][arg5] == null) {
				this.aClass1_Sub2ArrayArrayArray1[arg3][arg6][arg5] = new Class1_Sub2(arg3, arg6, arg5);
			}
			this.aClass1_Sub2ArrayArrayArray1[arg3][arg6][arg5].aClass20_1 = local3;
		} catch (@Pc(108) RuntimeException local108) {
			signlink.reporterror("55772, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + local108.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIILclient!eb;Lclient!eb;IIIB)V")
	public void method475(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) Class1_Sub3_Sub1 arg5, @OriginalArg(6) Class1_Sub3_Sub1 arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) byte arg10) {
		try {
			if (arg5 != null || arg6 != null) {
				@Pc(8) Class31 local8 = new Class31();
				local8.anInt684 = arg8;
				local8.aByte35 = arg10;
				local8.anInt680 = arg7 * 128 + 64;
				local8.anInt681 = arg9 * 128 + 64;
				local8.anInt679 = arg1;
				local8.aClass1_Sub3_Sub1_9 = arg5;
				if (arg4 != 8) {
					Static25.aBoolean142 = !Static25.aBoolean142;
				}
				local8.aClass1_Sub3_Sub1_10 = arg6;
				local8.anInt682 = arg3;
				local8.anInt683 = arg0;
				for (@Pc(54) int local54 = arg2; local54 >= 0; local54--) {
					if (this.aClass1_Sub2ArrayArrayArray1[local54][arg7][arg9] == null) {
						this.aClass1_Sub2ArrayArrayArray1[local54][arg7][arg9] = new Class1_Sub2(local54, arg7, arg9);
					}
				}
				this.aClass1_Sub2ArrayArrayArray1[arg2][arg7][arg9].aClass31_1 = local8;
			}
		} catch (@Pc(94) RuntimeException local94) {
			signlink.reporterror("66047, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + local94.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIIILclient!eb;BI)V")
	public void method476(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) Class1_Sub3_Sub1 arg9, @OriginalArg(10) byte arg10, @OriginalArg(11) int arg11) {
		try {
			@Pc(3) int local3 = 66 / arg6;
			if (arg9 != null) {
				@Pc(10) Class14 local10 = new Class14();
				local10.anInt444 = arg3;
				local10.aByte22 = arg10;
				local10.anInt440 = arg8 * 128 + arg7 + 64;
				local10.anInt441 = arg1 * 128 + arg2 + 64;
				local10.anInt439 = arg0;
				local10.aClass1_Sub3_Sub1_1 = arg9;
				local10.anInt442 = arg5;
				local10.anInt443 = arg4;
				for (@Pc(48) int local48 = arg11; local48 >= 0; local48--) {
					if (this.aClass1_Sub2ArrayArrayArray1[local48][arg8][arg1] == null) {
						this.aClass1_Sub2ArrayArrayArray1[local48][arg8][arg1] = new Class1_Sub2(local48, arg8, arg1);
					}
				}
				this.aClass1_Sub2ArrayArrayArray1[arg11][arg8][arg1].aClass14_1 = local10;
			}
		} catch (@Pc(88) RuntimeException local88) {
			signlink.reporterror("67649, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + local88.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILclient!w;IIIIBLclient!eb;II)Z")
	public boolean method477(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class1_Sub1 arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) byte arg8, @OriginalArg(9) Class1_Sub3_Sub1 arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
		try {
			@Pc(3) int local3 = 79 / arg1;
			if (arg9 == null && arg3 == null) {
				return true;
			} else {
				@Pc(17) int local17 = arg6 * 128 + arg7 * 64;
				@Pc(25) int local25 = arg5 * 128 + arg11 * 64;
				return this.method480(arg2, arg6, arg5, arg7, arg11, local17, local25, arg0, arg9, arg3, arg10, false, arg4, arg8);
			}
		} catch (@Pc(43) RuntimeException local43) {
			signlink.reporterror("16055, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + local43.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIZLclient!eb;Lclient!w;II)Z")
	public boolean method478(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6, @OriginalArg(7) Class1_Sub3_Sub1 arg7, @OriginalArg(8) Class1_Sub1 arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10) {
		try {
			if (arg7 == null && arg8 == null) {
				return true;
			}
			@Pc(9) int local9 = arg4 - arg2;
			@Pc(13) int local13 = arg1 - arg2;
			@Pc(17) int local17 = arg4 + arg2;
			@Pc(21) int local21 = arg1 + arg2;
			if (arg6) {
				if (arg3 > 640 && arg3 < 1408) {
					local21 += 128;
				}
				if (arg3 > 1152 && arg3 < 1920) {
					local17 += 128;
				}
				if (arg3 > 1664 || arg3 < 384) {
					local13 -= 128;
				}
				if (arg3 > 128 && arg3 < 896) {
					local9 -= 128;
				}
			}
			local9 /= 128;
			if (arg0 != -44713) {
				Static25.aBoolean142 = !Static25.aBoolean142;
			}
			local13 /= 128;
			local17 /= 128;
			local21 /= 128;
			return this.method480(arg10, local9, local13, local17 + 1 - local9, local21 - local13 + 1, arg4, arg1, arg9, arg7, arg8, arg3, true, arg5, (byte) 0);
		} catch (@Pc(102) RuntimeException local102) {
			signlink.reporterror("31031, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + local102.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IILclient!eb;IIIIIILclient!w;ZIII)Z")
	public boolean method479(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class1_Sub3_Sub1 arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) Class1_Sub1 arg9, @OriginalArg(10) boolean arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13) {
		try {
			if (arg10) {
				for (@Pc(3) int local3 = 1; local3 > 0; local3++) {
				}
			}
			return arg2 == null && arg9 == null ? true : this.method480(arg11, arg8, arg7, arg0 + 1 - arg8, arg12 - arg7 + 1, arg13, arg3, arg4, arg2, arg9, arg6, true, arg5, (byte) 0);
		} catch (@Pc(40) RuntimeException local40) {
			signlink.reporterror("36303, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + arg12 + ", " + arg13 + ", " + local40.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIILclient!eb;Lclient!w;IZIB)Z")
	private boolean method480(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) Class1_Sub3_Sub1 arg8, @OriginalArg(9) Class1_Sub1 arg9, @OriginalArg(10) int arg10, @OriginalArg(11) boolean arg11, @OriginalArg(12) int arg12, @OriginalArg(13) byte arg13) {
		if (arg8 == null && arg9 == null) {
			return false;
		}
		for (@Pc(9) int local9 = arg1; local9 < arg1 + arg3; local9++) {
			for (@Pc(13) int local13 = arg2; local13 < arg2 + arg4; local13++) {
				if (local9 < 0 || local13 < 0 || local9 >= this.anInt692 || local13 >= this.anInt693) {
					return false;
				}
				@Pc(38) Class1_Sub2 local38 = this.aClass1_Sub2ArrayArrayArray1[arg0][local9][local13];
				if (local38 != null && local38.anInt91 >= 5) {
					return false;
				}
			}
		}
		@Pc(62) Class29 local62 = new Class29();
		local62.anInt677 = arg12;
		local62.aByte33 = arg13;
		local62.anInt666 = arg0;
		local62.anInt668 = arg5;
		local62.anInt669 = arg6;
		local62.anInt667 = arg7;
		local62.aClass1_Sub3_Sub1_8 = arg8;
		local62.aClass1_Sub1_1 = arg9;
		local62.anInt670 = arg10;
		local62.anInt671 = arg1;
		local62.anInt673 = arg2;
		local62.anInt672 = arg1 + arg3 - 1;
		local62.anInt674 = arg2 + arg4 - 1;
		for (@Pc(111) int local111 = arg1; local111 < arg1 + arg3; local111++) {
			for (@Pc(115) int local115 = arg2; local115 < arg2 + arg4; local115++) {
				@Pc(119) int local119 = 0;
				if (local111 > arg1) {
					local119++;
				}
				if (local111 < arg1 + arg3 - 1) {
					local119 += 4;
				}
				if (local115 > arg2) {
					local119 += 8;
				}
				if (local115 < arg2 + arg4 - 1) {
					local119 += 2;
				}
				for (@Pc(145) int local145 = arg0; local145 >= 0; local145--) {
					if (this.aClass1_Sub2ArrayArrayArray1[local145][local111][local115] == null) {
						this.aClass1_Sub2ArrayArrayArray1[local145][local111][local115] = new Class1_Sub2(local145, local111, local115);
					}
				}
				@Pc(182) Class1_Sub2 local182 = this.aClass1_Sub2ArrayArrayArray1[arg0][local111][local115];
				local182.aClass29Array1[local182.anInt91] = local62;
				local182.anIntArray22[local182.anInt91] = local119;
				local182.anInt92 |= local119;
				local182.anInt91++;
			}
		}
		if (arg11) {
			this.aClass29Array2[this.anInt695++] = local62;
		}
		return true;
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(I)V")
	public void method481(@OriginalArg(0) int arg0) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.anInt695; local1++) {
				@Pc(8) Class29 local8 = this.aClass29Array2[local1];
				this.method482(local8, (byte) 1);
				this.aClass29Array2[local1] = null;
			}
			if (arg0 != 0) {
				this.aBoolean141 = !this.aBoolean141;
			}
			this.anInt695 = 0;
		} catch (@Pc(37) RuntimeException local37) {
			signlink.reporterror("68923, " + arg0 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!p;B)V")
	private void method482(@OriginalArg(0) Class29 arg0, @OriginalArg(1) byte arg1) {
		try {
			for (@Pc(4) int local4 = arg0.anInt671; local4 <= arg0.anInt672; local4++) {
				for (@Pc(9) int local9 = arg0.anInt673; local9 <= arg0.anInt674; local9++) {
					@Pc(21) Class1_Sub2 local21 = this.aClass1_Sub2ArrayArrayArray1[arg0.anInt666][local4][local9];
					if (local21 != null) {
						@Pc(41) int local41;
						for (@Pc(25) int local25 = 0; local25 < local21.anInt91; local25++) {
							if (local21.aClass29Array1[local25] == arg0) {
								local21.anInt91--;
								for (local41 = local25; local41 < local21.anInt91; local41++) {
									local21.aClass29Array1[local41] = local21.aClass29Array1[local41 + 1];
									local21.anIntArray22[local41] = local21.anIntArray22[local41 + 1];
								}
								local21.aClass29Array1[local21.anInt91] = null;
								break;
							}
						}
						local21.anInt92 = 0;
						for (local41 = 0; local41 < local21.anInt91; local41++) {
							local21.anInt92 |= local21.anIntArray22[local41];
						}
					}
				}
			}
			if (arg1 == this.aByte37) {
				@Pc(118) boolean local118 = false;
			}
		} catch (@Pc(121) RuntimeException local121) {
			signlink.reporterror("47347, " + arg0 + ", " + arg1 + ", " + local121.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(ILclient!eb;III)V")
	public void method483(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub1 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg1 != null) {
				@Pc(13) Class1_Sub2 local13 = this.aClass1_Sub2ArrayArrayArray1[arg3][arg0][arg4];
				@Pc(21) int local21;
				if (arg2 < 1 || arg2 > 1) {
					for (local21 = 1; local21 > 0; local21++) {
					}
				}
				if (local13 != null) {
					for (local21 = 0; local21 < local13.anInt91; local21++) {
						@Pc(38) Class29 local38 = local13.aClass29Array1[local21];
						if ((local38.anInt677 >> 29 & 0x3) == 2) {
							local38.aClass1_Sub3_Sub1_8 = arg1;
							return;
						}
					}
				}
			}
		} catch (@Pc(57) RuntimeException local57) {
			signlink.reporterror("18297, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local57.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIB)V")
	public void method484(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte arg4) {
		try {
			@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg2][arg1];
			if (arg4 != 6) {
				for (@Pc(13) int local13 = 1; local13 > 0; local13++) {
				}
			}
			if (local8 != null) {
				@Pc(24) Class14 local24 = local8.aClass14_1;
				if (local24 != null) {
					@Pc(33) int local33 = arg2 * 128 + 64;
					@Pc(39) int local39 = arg1 * 128 + 64;
					local24.anInt440 = local33 + (local24.anInt440 - local33) * arg3 / 16;
					local24.anInt441 = local39 + (local24.anInt441 - local39) * arg3 / 16;
				}
			}
		} catch (@Pc(65) RuntimeException local65) {
			signlink.reporterror("94433, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local65.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILclient!eb;I)V")
	public void method485(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class1_Sub3_Sub1 arg3, @OriginalArg(4) int arg4) {
		try {
			@Pc(3) int local3 = 34 / arg0;
			if (arg3 != null) {
				@Pc(15) Class1_Sub2 local15 = this.aClass1_Sub2ArrayArrayArray1[arg4][arg2][arg1];
				if (local15 != null) {
					@Pc(21) Class14 local21 = local15.aClass14_1;
					if (local21 != null) {
						local21.aClass1_Sub3_Sub1_1 = arg3;
					}
				}
			}
		} catch (@Pc(29) RuntimeException local29) {
			signlink.reporterror("71881, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local29.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;IIII)V")
	public void method486(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg2 == -48639 && arg0 != null) {
				@Pc(15) Class1_Sub2 local15 = this.aClass1_Sub2ArrayArrayArray1[arg4][arg3][arg1];
				if (local15 != null) {
					@Pc(21) Class18 local21 = local15.aClass18_1;
					if (local21 != null) {
						local21.aClass1_Sub3_Sub1_4 = arg0;
					}
				}
			}
		} catch (@Pc(29) RuntimeException local29) {
			signlink.reporterror("41961, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local29.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(ILclient!eb;III)V")
	public void method487(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub1 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg0 != 35568) {
				for (@Pc(4) int local4 = 1; local4 > 0; local4++) {
				}
			}
			if (arg1 != null) {
				@Pc(21) Class1_Sub2 local21 = this.aClass1_Sub2ArrayArrayArray1[arg4][arg3][arg2];
				if (local21 != null) {
					@Pc(27) Class31 local27 = local21.aClass31_1;
					if (local27 != null) {
						local27.aClass1_Sub3_Sub1_9 = arg1;
					}
				}
			}
		} catch (@Pc(35) RuntimeException local35) {
			signlink.reporterror("32053, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local35.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IZII)V")
	public void method488(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) Class1_Sub3_Sub1 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			if (arg0 != null) {
				@Pc(11) Class1_Sub2 local11 = this.aClass1_Sub2ArrayArrayArray1[arg5][arg4][arg2];
				if (local11 != null) {
					@Pc(17) Class31 local17 = local11.aClass31_1;
					if (local17 != null) {
						local17.aClass1_Sub3_Sub1_9 = arg0;
						local17.aClass1_Sub3_Sub1_10 = arg1;
						if (arg3) {
							this.aBoolean141 = !this.aBoolean141;
						}
					}
				}
			}
		} catch (@Pc(38) RuntimeException local38) {
			signlink.reporterror("56345, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local38.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(IIII)V")
	public void method489(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg1][arg0][arg2];
			if (arg3 == 1 && local8 != null) {
				local8.aClass31_1 = null;
			}
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("70237, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "c", descriptor = "(IIII)V")
	public void method490(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg3][arg1];
			if (arg2 < 0 || arg2 > 0) {
				this.aBoolean141 = !this.aBoolean141;
			}
			if (local8 != null) {
				local8.aClass14_1 = null;
			}
		} catch (@Pc(28) RuntimeException local28) {
			signlink.reporterror("83859, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local28.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "d", descriptor = "(IIII)V")
	public void method491(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(10) Class1_Sub2 local10 = this.aClass1_Sub2ArrayArrayArray1[arg3][arg0][arg1];
			if (local10 != null) {
				for (@Pc(15) int local15 = 0; local15 < local10.anInt91; local15++) {
					@Pc(22) Class29 local22 = local10.aClass29Array1[local15];
					if ((local22.anInt677 >> 29 & 0x3) == 2 && local22.anInt671 == arg0 && local22.anInt673 == arg1) {
						this.method482(local22, (byte) 1);
						return;
					}
				}
				if (arg2 >= 0) {
					for (@Pc(52) int local52 = 1; local52 > 0; local52++) {
					}
				}
			}
		} catch (@Pc(59) RuntimeException local59) {
			signlink.reporterror("77567, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local59.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "e", descriptor = "(IIII)V")
	public void method492(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg1 != 0) {
				Static25.aBoolean142 = !Static25.aBoolean142;
			}
			@Pc(16) Class1_Sub2 local16 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg2][arg3];
			if (local16 != null) {
				local16.aClass18_1 = null;
			}
		} catch (@Pc(24) RuntimeException local24) {
			signlink.reporterror("17123, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local24.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(III)V")
	public void method493(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2];
		if (local8 != null) {
			local8.aClass20_1 = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(III)I")
	public int method494(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2];
		return local8 == null || local8.aClass31_1 == null ? 0 : local8.aClass31_1.anInt684;
	}

	@OriginalMember(owner = "client!r", name = "f", descriptor = "(IIII)I")
	public int method495(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg2 != 3) {
				this.aBoolean141 = !this.aBoolean141;
			}
			@Pc(19) Class1_Sub2 local19 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg3][arg1];
			return local19 == null || local19.aClass14_1 == null ? 0 : local19.aClass14_1.anInt444;
		} catch (@Pc(31) RuntimeException local31) {
			signlink.reporterror("99919, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local31.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "c", descriptor = "(III)I")
	public int method496(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2];
		if (local8 == null) {
			return 0;
		}
		for (@Pc(14) int local14 = 0; local14 < local8.anInt91; local14++) {
			@Pc(21) Class29 local21 = local8.aClass29Array1[local14];
			if ((local21.anInt677 >> 29 & 0x3) == 2 && local21.anInt671 == arg1 && local21.anInt673 == arg2) {
				return local21.anInt677;
			}
		}
		return 0;
	}

	@OriginalMember(owner = "client!r", name = "d", descriptor = "(III)I")
	public int method497(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2];
		return local8 == null || local8.aClass18_1 == null ? 0 : local8.aClass18_1.anInt523;
	}

	@OriginalMember(owner = "client!r", name = "g", descriptor = "(IIII)I")
	public int method498(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(8) Class1_Sub2 local8 = this.aClass1_Sub2ArrayArrayArray1[arg0][arg1][arg2];
		if (local8 == null) {
			return -1;
		} else if (local8.aClass31_1 != null && local8.aClass31_1.anInt684 == arg3) {
			return local8.aClass31_1.aByte35 & 0xFF;
		} else if (local8.aClass14_1 != null && local8.aClass14_1.anInt444 == arg3) {
			return local8.aClass14_1.aByte22 & 0xFF;
		} else if (local8.aClass18_1 != null && local8.aClass18_1.anInt523 == arg3) {
			return local8.aClass18_1.aByte25 & 0xFF;
		} else {
			for (@Pc(56) int local56 = 0; local56 < local8.anInt91; local56++) {
				if (local8.aClass29Array1[local56].anInt677 == arg3) {
					return local8.aClass29Array1[local56].aByte33 & 0xFF;
				}
			}
			return -1;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIZ)V")
	public void method499(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5) {
		try {
			@Pc(16) int local16 = (int) Math.sqrt((double) (arg2 * arg2 + arg0 * arg0 + arg4 * arg4));
			if (arg5) {
				Static25.anInt689 = -77;
			}
			@Pc(26) int local26 = arg3 * local16 >> 8;
			for (@Pc(28) int local28 = 0; local28 < this.anInt691; local28++) {
				for (@Pc(32) int local32 = 0; local32 < this.anInt692; local32++) {
					for (@Pc(36) int local36 = 0; local36 < this.anInt693; local36++) {
						@Pc(47) Class1_Sub2 local47 = this.aClass1_Sub2ArrayArrayArray1[local28][local32][local36];
						if (local47 != null) {
							@Pc(52) Class31 local52 = local47.aClass31_1;
							if (local52 != null && local52.aClass1_Sub3_Sub1_9 != null && local52.aClass1_Sub3_Sub1_9.aClass26Array1 != null) {
								this.method501(local32, 1, 1, local28, 872, local52.aClass1_Sub3_Sub1_9, local36);
								if (local52.aClass1_Sub3_Sub1_10 != null && local52.aClass1_Sub3_Sub1_10.aClass26Array1 != null) {
									this.method501(local32, 1, 1, local28, 872, local52.aClass1_Sub3_Sub1_10, local36);
									this.method502(local52.aClass1_Sub3_Sub1_9, local52.aClass1_Sub3_Sub1_10, 0, 0, 0, false);
									local52.aClass1_Sub3_Sub1_10.method241(arg1, local26, arg2, arg0, arg4);
								}
								local52.aClass1_Sub3_Sub1_9.method241(arg1, local26, arg2, arg0, arg4);
							}
							for (@Pc(116) int local116 = 0; local116 < local47.anInt91; local116++) {
								@Pc(123) Class29 local123 = local47.aClass29Array1[local116];
								if (local123 != null && local123.aClass1_Sub3_Sub1_8 != null && local123.aClass1_Sub3_Sub1_8.aClass26Array1 != null) {
									this.method501(local32, local123.anInt672 + 1 - local123.anInt671, local123.anInt674 - local123.anInt673 + 1, local28, 872, local123.aClass1_Sub3_Sub1_8, local36);
									local123.aClass1_Sub3_Sub1_8.method241(arg1, local26, arg2, arg0, arg4);
								}
							}
							@Pc(170) Class18 local170 = local47.aClass18_1;
							if (local170 != null && local170.aClass1_Sub3_Sub1_4.aClass26Array1 != null) {
								this.method500((byte) -70, local28, local36, local170.aClass1_Sub3_Sub1_4, local32);
								local170.aClass1_Sub3_Sub1_4.method241(arg1, local26, arg2, arg0, arg4);
							}
						}
					}
				}
			}
		} catch (@Pc(209) RuntimeException local209) {
			signlink.reporterror("44219, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local209.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(BIILclient!eb;I)V")
	private void method500(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class1_Sub3_Sub1 arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg0 != -70) {
				Static25.anInt689 = -417;
			}
			@Pc(19) Class1_Sub2 local19;
			if (arg4 < this.anInt692) {
				local19 = this.aClass1_Sub2ArrayArrayArray1[arg1][arg4 + 1][arg2];
				if (local19 != null && local19.aClass18_1 != null && local19.aClass18_1.aClass1_Sub3_Sub1_4.aClass26Array1 != null) {
					this.method502(arg3, local19.aClass18_1.aClass1_Sub3_Sub1_4, 128, 0, 0, true);
				}
			}
			if (arg2 < this.anInt692) {
				local19 = this.aClass1_Sub2ArrayArrayArray1[arg1][arg4][arg2 + 1];
				if (local19 != null && local19.aClass18_1 != null && local19.aClass18_1.aClass1_Sub3_Sub1_4.aClass26Array1 != null) {
					this.method502(arg3, local19.aClass18_1.aClass1_Sub3_Sub1_4, 0, 0, 128, true);
				}
			}
			if (arg4 < this.anInt692 && arg2 < this.anInt693) {
				local19 = this.aClass1_Sub2ArrayArrayArray1[arg1][arg4 + 1][arg2 + 1];
				if (local19 != null && local19.aClass18_1 != null && local19.aClass18_1.aClass1_Sub3_Sub1_4.aClass26Array1 != null) {
					this.method502(arg3, local19.aClass18_1.aClass1_Sub3_Sub1_4, 128, 0, 128, true);
				}
			}
			if (arg4 < this.anInt692 && arg2 > 0) {
				local19 = this.aClass1_Sub2ArrayArrayArray1[arg1][arg4 + 1][arg2 - 1];
				if (local19 != null && local19.aClass18_1 != null && local19.aClass18_1.aClass1_Sub3_Sub1_4.aClass26Array1 != null) {
					this.method502(arg3, local19.aClass18_1.aClass1_Sub3_Sub1_4, 128, 0, -128, true);
					return;
				}
			}
		} catch (@Pc(156) RuntimeException local156) {
			signlink.reporterror("2423, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local156.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIILclient!eb;I)V")
	private void method501(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) Class1_Sub3_Sub1 arg5, @OriginalArg(6) int arg6) {
		try {
			@Pc(5) int local5 = 21 / arg4;
			@Pc(7) boolean local7 = true;
			@Pc(9) int local9 = arg0;
			@Pc(13) int local13 = arg0 + arg1;
			@Pc(17) int local17 = arg6 - 1;
			@Pc(21) int local21 = arg6 + arg2;
			for (@Pc(23) int local23 = arg3; local23 <= arg3 + 1; local23++) {
				if (local23 != this.anInt691) {
					for (@Pc(31) int local31 = local9; local31 <= local13; local31++) {
						if (local31 >= 0 && local31 < this.anInt692) {
							for (@Pc(42) int local42 = local17; local42 <= local21; local42++) {
								if (local42 >= 0 && local42 < this.anInt693 && (!local7 || local31 >= local13 || local42 >= local21 || local42 < arg6 && local31 != arg0)) {
									@Pc(75) Class1_Sub2 local75 = this.aClass1_Sub2ArrayArrayArray1[local23][local31][local42];
									if (local75 != null) {
										@Pc(169) int local169 = (this.anIntArrayArrayArray4[local23][local31][local42] + this.anIntArrayArrayArray4[local23][local31 + 1][local42] + this.anIntArrayArrayArray4[local23][local31][local42 + 1] + this.anIntArrayArrayArray4[local23][local31 + 1][local42 + 1]) / 4 - (this.anIntArrayArrayArray4[arg3][arg0][arg6] + this.anIntArrayArrayArray4[arg3][arg0 + 1][arg6] + this.anIntArrayArrayArray4[arg3][arg0][arg6 + 1] + this.anIntArrayArrayArray4[arg3][arg0 + 1][arg6 + 1]) / 4;
										@Pc(172) Class31 local172 = local75.aClass31_1;
										if (local172 != null && local172.aClass1_Sub3_Sub1_9 != null && local172.aClass1_Sub3_Sub1_9.aClass26Array1 != null) {
											this.method502(arg5, local172.aClass1_Sub3_Sub1_9, (local31 - arg0) * 128 + (1 - arg1) * 64, local169, (local42 - arg6) * 128 + (1 - arg2) * 64, local7);
										}
										if (local172 != null && local172.aClass1_Sub3_Sub1_10 != null && local172.aClass1_Sub3_Sub1_10.aClass26Array1 != null) {
											this.method502(arg5, local172.aClass1_Sub3_Sub1_10, (local31 - arg0) * 128 + (1 - arg1) * 64, local169, (local42 - arg6) * 128 + (1 - arg2) * 64, local7);
										}
										for (@Pc(250) int local250 = 0; local250 < local75.anInt91; local250++) {
											@Pc(257) Class29 local257 = local75.aClass29Array1[local250];
											if (local257 != null && local257.aClass1_Sub3_Sub1_8 != null && local257.aClass1_Sub3_Sub1_8.aClass26Array1 != null) {
												@Pc(274) int local274 = local257.anInt672 + 1 - local257.anInt671;
												@Pc(282) int local282 = local257.anInt674 + 1 - local257.anInt673;
												this.method502(arg5, local257.aClass1_Sub3_Sub1_8, (local257.anInt671 - arg0) * 128 + (local274 - arg1) * 64, local169, (local257.anInt673 - arg6) * 128 + (local282 - arg2) * 64, local7);
											}
										}
									}
								}
							}
						}
					}
					local9--;
					local7 = false;
				}
			}
		} catch (@Pc(337) RuntimeException local337) {
			signlink.reporterror("85496, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local337.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IIIZ)V")
	private void method502(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) Class1_Sub3_Sub1 arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5) {
		this.anInt718++;
		@Pc(9) int local9 = 0;
		@Pc(12) int[] local12 = arg1.anIntArray91;
		@Pc(15) int local15 = arg1.anInt359;
		for (@Pc(17) int local17 = 0; local17 < arg0.anInt359; local17++) {
			@Pc(24) Class26 local24 = arg0.aClass26Array1[local17];
			@Pc(29) Class26 local29 = arg0.aClass26Array2[local17];
			if (local29.anInt649 != 0) {
				@Pc(39) int local39 = arg0.anIntArray92[local17] - arg3;
				if (local39 <= arg1.anInt369) {
					@Pc(50) int local50 = arg0.anIntArray91[local17] - arg2;
					if (local50 >= arg1.anInt363 && local50 <= arg1.anInt364) {
						@Pc(66) int local66 = arg0.anIntArray93[local17] - arg4;
						if (local66 >= arg1.anInt366 && local66 <= arg1.anInt365) {
							for (@Pc(77) int local77 = 0; local77 < local15; local77++) {
								@Pc(84) Class26 local84 = arg1.aClass26Array1[local77];
								@Pc(89) Class26 local89 = arg1.aClass26Array2[local77];
								if (local50 == local12[local77] && local66 == arg1.anIntArray93[local77] && local39 == arg1.anIntArray92[local77] && local89.anInt649 != 0) {
									local24.anInt646 += local89.anInt646;
									local24.anInt647 += local89.anInt647;
									local24.anInt648 += local89.anInt648;
									local24.anInt649 += local89.anInt649;
									local84.anInt646 += local29.anInt646;
									local84.anInt647 += local29.anInt647;
									local84.anInt648 += local29.anInt648;
									local84.anInt649 += local29.anInt649;
									local9++;
									this.anIntArray211[local17] = this.anInt718;
									this.anIntArray212[local77] = this.anInt718;
								}
							}
						}
					}
				}
			}
		}
		if (local9 < 3 || !arg5) {
			return;
		}
		for (@Pc(195) int local195 = 0; local195 < arg0.anInt360; local195++) {
			if (this.anIntArray211[arg0.anIntArray94[local195]] == this.anInt718 && this.anIntArray211[arg0.anIntArray95[local195]] == this.anInt718 && this.anIntArray211[arg0.anIntArray96[local195]] == this.anInt718) {
				arg0.anIntArray100[local195] = -1;
			}
		}
		for (@Pc(239) int local239 = 0; local239 < arg1.anInt360; local239++) {
			if (this.anIntArray212[arg1.anIntArray94[local239]] == this.anInt718 && this.anIntArray212[arg1.anIntArray95[local239]] == this.anInt718 && this.anIntArray212[arg1.anIntArray96[local239]] == this.anInt718) {
				arg1.anIntArray100[local239] = -1;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "([IIIIII)V")
	public void method503(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(10) Class1_Sub2 local10 = this.aClass1_Sub2ArrayArrayArray1[arg3][arg4][arg5];
		if (local10 == null) {
			return;
		}
		@Pc(16) Class27 local16 = local10.aClass27_1;
		@Pc(26) int local26;
		if (local16 != null) {
			@Pc(21) int local21 = local16.anInt663;
			if (local21 != 0) {
				for (local26 = 0; local26 < 4; local26++) {
					arg0[arg1] = local21;
					arg0[arg1 + 1] = local21;
					arg0[arg1 + 2] = local21;
					arg0[arg1 + 3] = local21;
					arg1 += arg2;
				}
			}
			return;
		}
		@Pc(62) Class16 local62 = local10.aClass16_1;
		if (local62 == null) {
			return;
		}
		local26 = local62.anInt494;
		@Pc(71) int local71 = local62.anInt495;
		@Pc(74) int local74 = local62.anInt496;
		@Pc(77) int local77 = local62.anInt497;
		@Pc(82) int[] local82 = this.anIntArrayArray18[local26];
		@Pc(87) int[] local87 = this.anIntArrayArray19[local71];
		@Pc(89) int local89 = 0;
		@Pc(93) int local93;
		if (local74 != 0) {
			for (local93 = 0; local93 < 4; local93++) {
				arg0[arg1] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg0[arg1 + 1] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg0[arg1 + 2] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg0[arg1 + 3] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg1 += arg2;
			}
			return;
		}
		for (local93 = 0; local93 < 4; local93++) {
			if (local82[local87[local89++]] != 0) {
				arg0[arg1] = local77;
			}
			if (local82[local87[local89++]] != 0) {
				arg0[arg1 + 1] = local77;
			}
			if (local82[local87[local89++]] != 0) {
				arg0[arg1 + 2] = local77;
			}
			if (local82[local87[local89++]] != 0) {
				arg0[arg1 + 3] = local77;
			}
			arg1 += arg2;
		}
	}

	@OriginalMember(owner = "client!r", name = "e", descriptor = "(III)V")
	public void method506(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			Static25.aBoolean144 = true;
			Static25.anInt712 = arg2;
			if (arg0 >= 4 && arg0 <= 4) {
				Static25.anInt713 = arg1;
				Static25.anInt714 = -1;
				Static25.anInt715 = -1;
			}
		} catch (@Pc(18) RuntimeException local18) {
			signlink.reporterror("6259, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local18.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIII)V")
	public void method507(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			if (arg1 < 0) {
				arg1 = 0;
			} else if (arg1 >= this.anInt692 * 128) {
				arg1 = this.anInt692 * 128 - 1;
			}
			if (arg5 < 0) {
				arg5 = 0;
			} else if (arg5 >= this.anInt693 * 128) {
				arg5 = this.anInt693 * 128 - 1;
			}
			Static25.anInt698++;
			Static25.anInt708 = Static10.anIntArray124[arg3];
			Static25.anInt709 = Static10.anIntArray125[arg3];
			Static25.anInt710 = Static10.anIntArray124[arg0];
			Static25.anInt711 = Static10.anIntArray125[arg0];
			Static25.aBooleanArrayArray1 = Static25.aBooleanArrayArrayArrayArray1[(arg3 - 128) / 32][arg0 / 64];
			Static25.anInt705 = arg1;
			Static25.anInt706 = arg4;
			Static25.anInt707 = arg5;
			Static25.anInt703 = arg1 / 128;
			Static25.anInt704 = arg5 / 128;
			Static25.anInt697 = arg2;
			Static25.anInt699 = Static25.anInt703 - 25;
			if (Static25.anInt699 < 0) {
				Static25.anInt699 = 0;
			}
			Static25.anInt701 = Static25.anInt704 - 25;
			if (Static25.anInt701 < 0) {
				Static25.anInt701 = 0;
			}
			Static25.anInt700 = Static25.anInt703 + 25;
			if (arg6 != 0) {
				this.anInt688 = -462;
			}
			if (Static25.anInt700 > this.anInt692) {
				Static25.anInt700 = this.anInt692;
			}
			Static25.anInt702 = Static25.anInt704 + 25;
			if (Static25.anInt702 > this.anInt693) {
				Static25.anInt702 = this.anInt693;
			}
			this.method513(false);
			Static25.anInt696 = 0;
			@Pc(147) int local147;
			@Pc(151) int local151;
			for (@Pc(138) int local138 = this.anInt694; local138 < this.anInt691; local138++) {
				@Pc(145) Class1_Sub2[][] local145 = this.aClass1_Sub2ArrayArrayArray1[local138];
				for (local147 = Static25.anInt699; local147 < Static25.anInt700; local147++) {
					for (local151 = Static25.anInt701; local151 < Static25.anInt702; local151++) {
						@Pc(159) Class1_Sub2 local159 = local145[local147][local151];
						if (local159 != null) {
							if (local159.anInt93 <= arg2 && (Static25.aBooleanArrayArray1[local147 + 25 - Static25.anInt703][local151 + 25 - Static25.anInt704] || this.anIntArrayArrayArray4[local138][local147][local151] - arg4 >= 2000)) {
								local159.aBoolean25 = true;
								local159.aBoolean26 = true;
								if (local159.anInt91 > 0) {
									local159.aBoolean27 = true;
								} else {
									local159.aBoolean27 = false;
								}
								Static25.anInt696++;
							} else {
								local159.aBoolean25 = false;
								local159.aBoolean26 = false;
								local159.anInt94 = 0;
							}
						}
					}
				}
			}
			@Pc(258) int local258;
			@Pc(266) int local266;
			@Pc(272) int local272;
			@Pc(276) int local276;
			@Pc(254) int local254;
			for (@Pc(239) int local239 = this.anInt694; local239 < this.anInt691; local239++) {
				@Pc(246) Class1_Sub2[][] local246 = this.aClass1_Sub2ArrayArrayArray1[local239];
				for (local151 = -25; local151 <= 0; local151++) {
					local254 = Static25.anInt703 + local151;
					local258 = Static25.anInt703 - local151;
					if (local254 >= Static25.anInt699 || local258 < Static25.anInt700) {
						for (local266 = -25; local266 <= 0; local266++) {
							local272 = Static25.anInt704 + local266;
							local276 = Static25.anInt704 - local266;
							@Pc(288) Class1_Sub2 local288;
							if (local254 >= Static25.anInt699) {
								if (local272 >= Static25.anInt701) {
									local288 = local246[local254][local272];
									if (local288 != null && local288.aBoolean25) {
										this.method508(local288, true);
									}
								}
								if (local276 < Static25.anInt702) {
									local288 = local246[local254][local276];
									if (local288 != null && local288.aBoolean25) {
										this.method508(local288, true);
									}
								}
							}
							if (local258 < Static25.anInt700) {
								if (local272 >= Static25.anInt701) {
									local288 = local246[local258][local272];
									if (local288 != null && local288.aBoolean25) {
										this.method508(local288, true);
									}
								}
								if (local276 < Static25.anInt702) {
									local288 = local246[local258][local276];
									if (local288 != null && local288.aBoolean25) {
										this.method508(local288, true);
									}
								}
							}
							if (Static25.anInt696 == 0) {
								Static25.aBoolean144 = false;
								return;
							}
						}
					}
				}
			}
			for (local147 = this.anInt694; local147 < this.anInt691; local147++) {
				@Pc(380) Class1_Sub2[][] local380 = this.aClass1_Sub2ArrayArrayArray1[local147];
				for (local254 = -25; local254 <= 0; local254++) {
					local258 = Static25.anInt703 + local254;
					local266 = Static25.anInt703 - local254;
					if (local258 >= Static25.anInt699 || local266 < Static25.anInt700) {
						for (local272 = -25; local272 <= 0; local272++) {
							local276 = Static25.anInt704 + local272;
							@Pc(410) int local410 = Static25.anInt704 - local272;
							@Pc(422) Class1_Sub2 local422;
							if (local258 >= Static25.anInt699) {
								if (local276 >= Static25.anInt701) {
									local422 = local380[local258][local276];
									if (local422 != null && local422.aBoolean25) {
										this.method508(local422, false);
									}
								}
								if (local410 < Static25.anInt702) {
									local422 = local380[local258][local410];
									if (local422 != null && local422.aBoolean25) {
										this.method508(local422, false);
									}
								}
							}
							if (local266 < Static25.anInt700) {
								if (local276 >= Static25.anInt701) {
									local422 = local380[local266][local276];
									if (local422 != null && local422.aBoolean25) {
										this.method508(local422, false);
									}
								}
								if (local410 < Static25.anInt702) {
									local422 = local380[local266][local410];
									if (local422 != null && local422.aBoolean25) {
										this.method508(local422, false);
									}
								}
							}
							if (Static25.anInt696 == 0) {
								Static25.aBoolean144 = false;
								return;
							}
						}
					}
				}
			}
		} catch (@Pc(506) RuntimeException local506) {
			signlink.reporterror("14817, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local506.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!cb;Z)V")
	private void method508(@OriginalArg(0) Class1_Sub2 arg0, @OriginalArg(1) boolean arg1) {
		Static25.aClass28_9.method453(arg0);
		while (true) {
			@Pc(8) Class1_Sub2 local8;
			@Pc(17) int local17;
			@Pc(20) int local20;
			@Pc(23) int local23;
			@Pc(26) int local26;
			@Pc(31) Class1_Sub2[][] local31;
			@Pc(49) Class1_Sub2 local49;
			@Pc(253) int local253;
			@Pc(599) int local599;
			@Pc(604) int local604;
			@Pc(609) int local609;
			@Pc(612) int local612;
			@Pc(621) int local621;
			@Pc(963) Class31 local963;
			@Pc(1144) int local1144;
			@Pc(1023) int local1023;
			do {
				do {
					do {
						do {
							do {
								do {
									while (true) {
										@Pc(260) Class29 var12;
										@Pc(349) int var22;
										@Pc(301) boolean var23;
										@Pc(846) Class1_Sub2 var35;
										while (true) {
											do {
												local8 = (Class1_Sub2) Static25.aClass28_9.method455();
												if (local8 == null) {
													return;
												}
											} while (!local8.aBoolean26);
											local17 = local8.anInt88;
											local20 = local8.anInt89;
											local23 = local8.anInt87;
											local26 = local8.anInt90;
											local31 = this.aClass1_Sub2ArrayArrayArray1[local23];
											if (!local8.aBoolean25) {
												break;
											}
											if (arg1) {
												if (local23 > 0) {
													local49 = this.aClass1_Sub2ArrayArrayArray1[local23 - 1][local17][local20];
													if (local49 != null && local49.aBoolean26) {
														continue;
													}
												}
												if (local17 <= Static25.anInt703 && local17 > Static25.anInt699) {
													local49 = local31[local17 - 1][local20];
													if (local49 != null && local49.aBoolean26 && (local49.aBoolean25 || (local8.anInt92 & 0x1) == 0)) {
														continue;
													}
												}
												if (local17 >= Static25.anInt703 && local17 < Static25.anInt700 - 1) {
													local49 = local31[local17 + 1][local20];
													if (local49 != null && local49.aBoolean26 && (local49.aBoolean25 || (local8.anInt92 & 0x4) == 0)) {
														continue;
													}
												}
												if (local20 <= Static25.anInt704 && local20 > Static25.anInt701) {
													local49 = local31[local17][local20 - 1];
													if (local49 != null && local49.aBoolean26 && (local49.aBoolean25 || (local8.anInt92 & 0x8) == 0)) {
														continue;
													}
												}
												if (local20 >= Static25.anInt704 && local20 < Static25.anInt702 - 1) {
													local49 = local31[local17][local20 + 1];
													if (local49 != null && local49.aBoolean26 && (local49.aBoolean25 || (local8.anInt92 & 0x2) == 0)) {
														continue;
													}
												}
											} else {
												arg1 = true;
											}
											local8.aBoolean25 = false;
											if (local8.aClass1_Sub2_1 != null) {
												local49 = local8.aClass1_Sub2_1;
												if (local49.aClass27_1 == null) {
													if (local49.aClass16_1 != null && !this.method514(0, local17, local20)) {
														this.method510(Static25.anInt710, local20, local49.aClass16_1, local17, Static25.anInt709, Static25.anInt708, Static25.anInt711, true);
													}
												} else if (!this.method514(0, local17, local20)) {
													this.method509(local49.aClass27_1, 0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local17, local20);
												}
												@Pc(227) Class31 local227 = local49.aClass31_1;
												if (local227 != null) {
													local227.aClass1_Sub3_Sub1_9.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local227.anInt680 - Static25.anInt705, local227.anInt679 - Static25.anInt706, local227.anInt681 - Static25.anInt707, local227.anInt684);
												}
												for (local253 = 0; local253 < local49.anInt91; local253++) {
													var12 = local49.aClass29Array1[local253];
													if (var12 != null) {
														@Pc(265) Class1_Sub3_Sub1 local265 = var12.aClass1_Sub3_Sub1_8;
														if (local265 == null) {
															local265 = var12.aClass1_Sub1_1.method568(true);
														}
														local265.method244(var12.anInt670, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, var12.anInt668 - Static25.anInt705, var12.anInt667 - Static25.anInt706, var12.anInt669 - Static25.anInt707, var12.anInt677);
													}
												}
											}
											var23 = false;
											if (local8.aClass27_1 == null) {
												if (local8.aClass16_1 != null && !this.method514(local26, local17, local20)) {
													var23 = true;
													this.method510(Static25.anInt710, local20, local8.aClass16_1, local17, Static25.anInt709, Static25.anInt708, Static25.anInt711, true);
												}
											} else if (!this.method514(local26, local17, local20)) {
												var23 = true;
												this.method509(local8.aClass27_1, local26, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local17, local20);
											}
											var22 = 0;
											local253 = 0;
											@Pc(354) Class31 local354 = local8.aClass31_1;
											@Pc(357) Class14 local357 = local8.aClass14_1;
											if (local354 != null || local357 != null) {
												if (Static25.anInt703 == local17) {
													var22++;
												} else if (Static25.anInt703 < local17) {
													var22 += 2;
												}
												if (Static25.anInt704 == local20) {
													var22 += 3;
												} else if (Static25.anInt704 > local20) {
													var22 += 6;
												}
												local253 = Static25.anIntArray203[var22];
												local8.anInt97 = Static25.anIntArray205[var22];
											}
											if (local354 != null) {
												if ((local354.anInt682 & Static25.anIntArray204[var22]) == 0) {
													local8.anInt94 = 0;
												} else if (local354.anInt682 == 16) {
													local8.anInt94 = 3;
													local8.anInt95 = Static25.anIntArray206[var22];
													local8.anInt96 = 3 - local8.anInt95;
												} else if (local354.anInt682 == 32) {
													local8.anInt94 = 6;
													local8.anInt95 = Static25.anIntArray207[var22];
													local8.anInt96 = 6 - local8.anInt95;
												} else if (local354.anInt682 == 64) {
													local8.anInt94 = 12;
													local8.anInt95 = Static25.anIntArray208[var22];
													local8.anInt96 = 12 - local8.anInt95;
												} else {
													local8.anInt94 = 9;
													local8.anInt95 = Static25.anIntArray209[var22];
													local8.anInt96 = 9 - local8.anInt95;
												}
												if ((local354.anInt682 & local253) != 0 && !this.method515(local26, local17, local20, local354.anInt682)) {
													local354.aClass1_Sub3_Sub1_9.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local354.anInt680 - Static25.anInt705, local354.anInt679 - Static25.anInt706, local354.anInt681 - Static25.anInt707, local354.anInt684);
												}
												if ((local354.anInt683 & local253) != 0 && !this.method515(local26, local17, local20, local354.anInt683)) {
													local354.aClass1_Sub3_Sub1_10.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local354.anInt680 - Static25.anInt705, local354.anInt679 - Static25.anInt706, local354.anInt681 - Static25.anInt707, local354.anInt684);
												}
											}
											if (local357 != null && !this.method516(local26, local17, local20, local357.aClass1_Sub3_Sub1_1.anInt368)) {
												if ((local357.anInt442 & local253) != 0) {
													local357.aClass1_Sub3_Sub1_1.method244(local357.anInt443, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local357.anInt440 - Static25.anInt705, local357.anInt439 - Static25.anInt706, local357.anInt441 - Static25.anInt707, local357.anInt444);
												} else if ((local357.anInt442 & 0x300) != 0) {
													local599 = local357.anInt440 - Static25.anInt705;
													local604 = local357.anInt439 - Static25.anInt706;
													local609 = local357.anInt441 - Static25.anInt707;
													local612 = local357.anInt443;
													if (local612 == 1 || local612 == 2) {
														local621 = -local599;
													} else {
														local621 = local599;
													}
													@Pc(634) int local634;
													if (local612 == 2 || local612 == 3) {
														local634 = -local609;
													} else {
														local634 = local609;
													}
													@Pc(652) int local652;
													@Pc(658) int local658;
													if ((local357.anInt442 & 0x100) != 0 && local634 < local621) {
														local652 = local599 + Static25.anIntArray198[local612];
														local658 = local609 + Static25.anIntArray199[local612];
														local357.aClass1_Sub3_Sub1_1.method244(local612 * 512 + 256, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local652, local604, local658, local357.anInt444);
													}
													if ((local357.anInt442 & 0x200) != 0 && local634 > local621) {
														local652 = local599 + Static25.anIntArray200[local612];
														local658 = local609 + Static25.anIntArray201[local612];
														local357.aClass1_Sub3_Sub1_1.method244(local612 * 512 + 1280 & 0x7FF, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local652, local604, local658, local357.anInt444);
													}
												}
											}
											if (var23) {
												@Pc(719) Class18 local719 = local8.aClass18_1;
												if (local719 != null) {
													local719.aClass1_Sub3_Sub1_4.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local719.anInt521 - Static25.anInt705, local719.anInt520 - Static25.anInt706, local719.anInt522 - Static25.anInt707, local719.anInt523);
												}
												@Pc(746) Class20 local746 = local8.aClass20_1;
												if (local746 != null && local746.anInt553 == 0) {
													if (local746.aClass1_Sub3_Sub1_6 != null) {
														local746.aClass1_Sub3_Sub1_6.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local746.anInt550 - Static25.anInt705, local746.anInt549 - Static25.anInt706, local746.anInt551 - Static25.anInt707, local746.anInt552);
													}
													if (local746.aClass1_Sub3_Sub1_7 != null) {
														local746.aClass1_Sub3_Sub1_7.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local746.anInt550 - Static25.anInt705, local746.anInt549 - Static25.anInt706, local746.anInt551 - Static25.anInt707, local746.anInt552);
													}
													if (local746.aClass1_Sub3_Sub1_5 != null) {
														local746.aClass1_Sub3_Sub1_5.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local746.anInt550 - Static25.anInt705, local746.anInt549 - Static25.anInt706, local746.anInt551 - Static25.anInt707, local746.anInt552);
													}
												}
											}
											local599 = local8.anInt92;
											if (local599 != 0) {
												if (local17 < Static25.anInt703 && (local599 & 0x4) != 0) {
													var35 = local31[local17 + 1][local20];
													if (var35 != null && var35.aBoolean26) {
														Static25.aClass28_9.method453(var35);
													}
												}
												if (local20 < Static25.anInt704 && (local599 & 0x2) != 0) {
													var35 = local31[local17][local20 + 1];
													if (var35 != null && var35.aBoolean26) {
														Static25.aClass28_9.method453(var35);
													}
												}
												if (local17 > Static25.anInt703 && (local599 & 0x1) != 0) {
													var35 = local31[local17 - 1][local20];
													if (var35 != null && var35.aBoolean26) {
														Static25.aClass28_9.method453(var35);
													}
												}
												if (local20 > Static25.anInt704 && (local599 & 0x8) != 0) {
													var35 = local31[local17][local20 - 1];
													if (var35 != null && var35.aBoolean26) {
														Static25.aClass28_9.method453(var35);
													}
												}
											}
											break;
										}
										if (local8.anInt94 != 0) {
											var23 = true;
											for (var22 = 0; var22 < local8.anInt91; var22++) {
												if (local8.aClass29Array1[var22].anInt676 != Static25.anInt698 && (local8.anIntArray22[var22] & local8.anInt94) == local8.anInt95) {
													var23 = false;
													break;
												}
											}
											if (var23) {
												local963 = local8.aClass31_1;
												if (!this.method515(local26, local17, local20, local963.anInt682)) {
													local963.aClass1_Sub3_Sub1_9.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local963.anInt680 - Static25.anInt705, local963.anInt679 - Static25.anInt706, local963.anInt681 - Static25.anInt707, local963.anInt684);
												}
												local8.anInt94 = 0;
											}
										}
										if (!local8.aBoolean27) {
											break;
										}
										@Pc(1002) int local1002 = local8.anInt91;
										local8.aBoolean27 = false;
										var22 = 0;
										label559: for (local253 = 0; local253 < local1002; local253++) {
											var12 = local8.aClass29Array1[local253];
											if (var12.anInt676 != Static25.anInt698) {
												for (local1023 = var12.anInt671; local1023 <= var12.anInt672; local1023++) {
													for (local599 = var12.anInt673; local599 <= var12.anInt674; local599++) {
														var35 = local31[local1023][local599];
														if (var35.aBoolean25) {
															local8.aBoolean27 = true;
															continue label559;
														}
														if (var35.anInt94 != 0) {
															local609 = 0;
															if (local1023 > var12.anInt671) {
																local609++;
															}
															if (local1023 < var12.anInt672) {
																local609 += 4;
															}
															if (local599 > var12.anInt673) {
																local609 += 8;
															}
															if (local599 < var12.anInt674) {
																local609 += 2;
															}
															if ((local609 & var35.anInt94) == local8.anInt96) {
																local8.aBoolean27 = true;
																continue label559;
															}
														}
													}
												}
												Static25.aClass29Array3[var22++] = var12;
												local599 = Static25.anInt703 - var12.anInt671;
												local604 = var12.anInt672 - Static25.anInt703;
												if (local604 > local599) {
													local599 = local604;
												}
												local609 = Static25.anInt704 - var12.anInt673;
												local612 = var12.anInt674 - Static25.anInt704;
												if (local612 > local609) {
													var12.anInt675 = local599 + local612;
												} else {
													var12.anInt675 = local599 + local609;
												}
											}
										}
										while (var22 > 0) {
											local1144 = -50;
											local1023 = -1;
											@Pc(1154) Class29 local1154;
											for (local599 = 0; local599 < var22; local599++) {
												local1154 = Static25.aClass29Array3[local599];
												if (local1154.anInt675 > local1144 && local1154.anInt676 != Static25.anInt698) {
													local1144 = local1154.anInt675;
													local1023 = local599;
												}
											}
											if (local1023 == -1) {
												break;
											}
											local1154 = Static25.aClass29Array3[local1023];
											local1154.anInt676 = Static25.anInt698;
											@Pc(1184) Class1_Sub3_Sub1 local1184 = local1154.aClass1_Sub3_Sub1_8;
											if (local1184 == null) {
												local1184 = local1154.aClass1_Sub1_1.method568(true);
											}
											if (!this.method517(local26, local1154.anInt671, local1154.anInt672, local1154.anInt673, local1154.anInt674, local1184.anInt368)) {
												local1184.method244(local1154.anInt670, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local1154.anInt668 - Static25.anInt705, local1154.anInt667 - Static25.anInt706, local1154.anInt669 - Static25.anInt707, local1154.anInt677);
											}
											for (local612 = local1154.anInt671; local612 <= local1154.anInt672; local612++) {
												for (local621 = local1154.anInt673; local621 <= local1154.anInt674; local621++) {
													@Pc(1243) Class1_Sub2 local1243 = local31[local612][local621];
													if (local1243.anInt94 != 0) {
														Static25.aClass28_9.method453(local1243);
													} else if ((local612 != local17 || local621 != local20) && local1243.aBoolean26) {
														Static25.aClass28_9.method453(local1243);
													}
												}
											}
										}
										if (!local8.aBoolean27) {
											break;
										}
									}
								} while (!local8.aBoolean26);
							} while (local8.anInt94 != 0);
							if (local17 > Static25.anInt703 || local17 <= Static25.anInt699) {
								break;
							}
							local49 = local31[local17 - 1][local20];
						} while (local49 != null && local49.aBoolean26);
						if (local17 < Static25.anInt703 || local17 >= Static25.anInt700 - 1) {
							break;
						}
						local49 = local31[local17 + 1][local20];
					} while (local49 != null && local49.aBoolean26);
					if (local20 > Static25.anInt704 || local20 <= Static25.anInt701) {
						break;
					}
					local49 = local31[local17][local20 - 1];
				} while (local49 != null && local49.aBoolean26);
				if (local20 < Static25.anInt704 || local20 >= Static25.anInt702 - 1) {
					break;
				}
				local49 = local31[local17][local20 + 1];
			} while (local49 != null && local49.aBoolean26);
			local8.aBoolean26 = false;
			Static25.anInt696--;
			@Pc(1379) Class20 local1379 = local8.aClass20_1;
			if (local1379 != null && local1379.anInt553 != 0) {
				if (local1379.aClass1_Sub3_Sub1_6 != null) {
					local1379.aClass1_Sub3_Sub1_6.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local1379.anInt550 - Static25.anInt705, local1379.anInt549 - Static25.anInt706 - local1379.anInt553, local1379.anInt551 - Static25.anInt707, local1379.anInt552);
				}
				if (local1379.aClass1_Sub3_Sub1_7 != null) {
					local1379.aClass1_Sub3_Sub1_7.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local1379.anInt550 - Static25.anInt705, local1379.anInt549 - Static25.anInt706 - local1379.anInt553, local1379.anInt551 - Static25.anInt707, local1379.anInt552);
				}
				if (local1379.aClass1_Sub3_Sub1_5 != null) {
					local1379.aClass1_Sub3_Sub1_5.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local1379.anInt550 - Static25.anInt705, local1379.anInt549 - Static25.anInt706 - local1379.anInt553, local1379.anInt551 - Static25.anInt707, local1379.anInt552);
				}
			}
			if (local8.anInt97 != 0) {
				@Pc(1474) Class14 local1474 = local8.aClass14_1;
				if (local1474 != null && !this.method516(local26, local17, local20, local1474.aClass1_Sub3_Sub1_1.anInt368)) {
					if ((local1474.anInt442 & local8.anInt97) != 0) {
						local1474.aClass1_Sub3_Sub1_1.method244(local1474.anInt443, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local1474.anInt440 - Static25.anInt705, local1474.anInt439 - Static25.anInt706, local1474.anInt441 - Static25.anInt707, local1474.anInt444);
					} else if ((local1474.anInt442 & 0x300) != 0) {
						local253 = local1474.anInt440 - Static25.anInt705;
						local1144 = local1474.anInt439 - Static25.anInt706;
						local1023 = local1474.anInt441 - Static25.anInt707;
						local599 = local1474.anInt443;
						if (local599 == 1 || local599 == 2) {
							local604 = -local253;
						} else {
							local604 = local253;
						}
						if (local599 == 2 || local599 == 3) {
							local609 = -local1023;
						} else {
							local609 = local1023;
						}
						if ((local1474.anInt442 & 0x100) != 0 && local609 >= local604) {
							local612 = local253 + Static25.anIntArray198[local599];
							local621 = local1023 + Static25.anIntArray199[local599];
							local1474.aClass1_Sub3_Sub1_1.method244(local599 * 512 + 256, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local612, local1144, local621, local1474.anInt444);
						}
						if ((local1474.anInt442 & 0x200) != 0 && local609 <= local604) {
							local612 = local253 + Static25.anIntArray200[local599];
							local621 = local1023 + Static25.anIntArray201[local599];
							local1474.aClass1_Sub3_Sub1_1.method244(local599 * 512 + 1280 & 0x7FF, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local612, local1144, local621, local1474.anInt444);
						}
					}
				}
				local963 = local8.aClass31_1;
				if (local963 != null) {
					if ((local963.anInt683 & local8.anInt97) != 0 && !this.method515(local26, local17, local20, local963.anInt683)) {
						local963.aClass1_Sub3_Sub1_10.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local963.anInt680 - Static25.anInt705, local963.anInt679 - Static25.anInt706, local963.anInt681 - Static25.anInt707, local963.anInt684);
					}
					if ((local963.anInt682 & local8.anInt97) != 0 && !this.method515(local26, local17, local20, local963.anInt682)) {
						local963.aClass1_Sub3_Sub1_9.method244(0, Static25.anInt708, Static25.anInt709, Static25.anInt710, Static25.anInt711, local963.anInt680 - Static25.anInt705, local963.anInt679 - Static25.anInt706, local963.anInt681 - Static25.anInt707, local963.anInt684);
					}
				}
			}
			@Pc(1735) Class1_Sub2 local1735;
			if (local23 < this.anInt691 - 1) {
				local1735 = this.aClass1_Sub2ArrayArrayArray1[local23 + 1][local17][local20];
				if (local1735 != null && local1735.aBoolean26) {
					Static25.aClass28_9.method453(local1735);
				}
			}
			if (local17 < Static25.anInt703) {
				local1735 = local31[local17 + 1][local20];
				if (local1735 != null && local1735.aBoolean26) {
					Static25.aClass28_9.method453(local1735);
				}
			}
			if (local20 < Static25.anInt704) {
				local1735 = local31[local17][local20 + 1];
				if (local1735 != null && local1735.aBoolean26) {
					Static25.aClass28_9.method453(local1735);
				}
			}
			if (local17 > Static25.anInt703) {
				local1735 = local31[local17 - 1][local20];
				if (local1735 != null && local1735.aBoolean26) {
					Static25.aClass28_9.method453(local1735);
				}
			}
			if (local20 > Static25.anInt704) {
				local1735 = local31[local17][local20 - 1];
				if (local1735 != null && local1735.aBoolean26) {
					Static25.aClass28_9.method453(local1735);
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!o;IIIIIII)V")
	private void method509(@OriginalArg(0) Class27 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(8) int local8;
		@Pc(9) int local9 = local8 = (arg6 << 7) - Static25.anInt705;
		@Pc(16) int local16;
		@Pc(17) int local17 = local16 = (arg7 << 7) - Static25.anInt707;
		@Pc(22) int local22;
		@Pc(23) int local23 = local22 = local9 + 128;
		@Pc(28) int local28;
		@Pc(29) int local29 = local28 = local17 + 128;
		@Pc(40) int local40 = this.anIntArrayArrayArray4[arg1][arg6][arg7] - Static25.anInt706;
		@Pc(53) int local53 = this.anIntArrayArrayArray4[arg1][arg6 + 1][arg7] - Static25.anInt706;
		@Pc(68) int local68 = this.anIntArrayArrayArray4[arg1][arg6 + 1][arg7 + 1] - Static25.anInt706;
		@Pc(81) int local81 = this.anIntArrayArrayArray4[arg1][arg6][arg7 + 1] - Static25.anInt706;
		@Pc(91) int local91 = local17 * arg4 + local9 * arg5 >> 16;
		@Pc(101) int local101 = local17 * arg5 - local9 * arg4 >> 16;
		@Pc(103) int local103 = local91;
		@Pc(113) int local113 = local40 * arg3 - local101 * arg2 >> 16;
		@Pc(123) int local123 = local40 * arg2 + local101 * arg3 >> 16;
		@Pc(125) int local125 = local113;
		if (local123 < 50) {
			return;
		}
		local91 = local16 * arg4 + local23 * arg5 >> 16;
		@Pc(149) int local149 = local16 * arg5 - local23 * arg4 >> 16;
		local23 = local91;
		local91 = local53 * arg3 - local149 * arg2 >> 16;
		@Pc(171) int local171 = local53 * arg2 + local149 * arg3 >> 16;
		local53 = local91;
		if (local171 < 50) {
			return;
		}
		local91 = local29 * arg4 + local22 * arg5 >> 16;
		local29 = local29 * arg5 - local22 * arg4 >> 16;
		@Pc(199) int local199 = local91;
		local91 = local68 * arg3 - local29 * arg2 >> 16;
		local29 = local68 * arg2 + local29 * arg3 >> 16;
		local68 = local91;
		if (local29 < 50) {
			return;
		}
		local91 = local28 * arg4 + local8 * arg5 >> 16;
		@Pc(245) int local245 = local28 * arg5 - local8 * arg4 >> 16;
		@Pc(247) int local247 = local91;
		local91 = local81 * arg3 - local245 * arg2 >> 16;
		@Pc(267) int local267 = local81 * arg2 + local245 * arg3 >> 16;
		if (local267 < 50) {
			return;
		}
		@Pc(281) int local281 = Static15.anInt430 + (local103 << 9) / local123;
		@Pc(289) int local289 = Static15.anInt431 + (local125 << 9) / local123;
		@Pc(297) int local297 = Static15.anInt430 + (local23 << 9) / local171;
		@Pc(305) int local305 = Static15.anInt431 + (local53 << 9) / local171;
		@Pc(313) int local313 = Static15.anInt430 + (local199 << 9) / local29;
		@Pc(321) int local321 = Static15.anInt431 + (local68 << 9) / local29;
		@Pc(329) int local329 = Static15.anInt430 + (local247 << 9) / local267;
		@Pc(337) int local337 = Static15.anInt431 + (local91 << 9) / local267;
		Static15.anInt429 = 0;
		@Pc(476) int local476;
		if ((local313 - local329) * (local305 - local337) - (local321 - local337) * (local297 - local329) > 0) {
			Static15.aBoolean97 = false;
			if (local313 < 0 || local329 < 0 || local297 < 0 || local313 > Static12.anInt534 || local329 > Static12.anInt534 || local297 > Static12.anInt534) {
				Static15.aBoolean97 = true;
			}
			if (Static25.aBoolean144 && this.method512(Static25.anInt712, Static25.anInt713, local321, local337, local305, local313, local329, local297)) {
				Static25.anInt714 = arg6;
				Static25.anInt715 = arg7;
			}
			if (arg0.anInt662 == -1) {
				if (arg0.anInt660 != 12345678) {
					Static15.method298(local321, local337, local305, local313, local329, local297, arg0.anInt660, arg0.anInt661, arg0.anInt659);
				}
			} else if (Static25.aBoolean143) {
				local476 = Static25.anIntArray210[arg0.anInt662];
				Static15.method298(local321, local337, local305, local313, local329, local297, this.method511(arg0.anInt660, local476, 9), this.method511(arg0.anInt661, local476, 9), this.method511(arg0.anInt659, local476, 9));
			} else if (arg0.aBoolean138) {
				Static15.method302(local321, local337, local305, local313, local329, local297, arg0.anInt660, arg0.anInt661, arg0.anInt659, local103, local23, local247, local125, local53, local91, local123, local171, local267, arg0.anInt662);
			} else {
				Static15.method302(local321, local337, local305, local313, local329, local297, arg0.anInt660, arg0.anInt661, arg0.anInt659, local199, local247, local23, local68, local91, local53, local29, local267, local171, arg0.anInt662);
			}
		}
		if ((local281 - local297) * (local337 - local305) - (local289 - local305) * (local329 - local297) <= 0) {
			return;
		}
		Static15.aBoolean97 = false;
		if (local281 < 0 || local297 < 0 || local329 < 0 || local281 > Static12.anInt534 || local297 > Static12.anInt534 || local329 > Static12.anInt534) {
			Static15.aBoolean97 = true;
		}
		if (Static25.aBoolean144 && this.method512(Static25.anInt712, Static25.anInt713, local289, local305, local337, local281, local297, local329)) {
			Static25.anInt714 = arg6;
			Static25.anInt715 = arg7;
		}
		if (arg0.anInt662 != -1) {
			if (!Static25.aBoolean143) {
				Static15.method302(local289, local305, local337, local281, local297, local329, arg0.anInt658, arg0.anInt659, arg0.anInt661, local103, local23, local247, local125, local53, local91, local123, local171, local267, arg0.anInt662);
				return;
			}
			local476 = Static25.anIntArray210[arg0.anInt662];
			Static15.method298(local289, local305, local337, local281, local297, local329, this.method511(arg0.anInt658, local476, 9), this.method511(arg0.anInt659, local476, 9), this.method511(arg0.anInt661, local476, 9));
		} else if (arg0.anInt658 != 12345678) {
			Static15.method298(local289, local305, local337, local281, local297, local329, arg0.anInt658, arg0.anInt659, arg0.anInt661);
			return;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IILclient!i;IIIIZ)V")
	private void method510(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class16 arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) boolean arg7) {
		try {
			@Pc(5) int local5 = arg2.anIntArray158.length;
			@Pc(16) int local16;
			@Pc(23) int local23;
			@Pc(30) int local30;
			@Pc(40) int local40;
			for (@Pc(7) int local7 = 0; local7 < local5; local7++) {
				local16 = arg2.anIntArray158[local7] - Static25.anInt705;
				local23 = arg2.anIntArray159[local7] - Static25.anInt706;
				local30 = arg2.anIntArray160[local7] - Static25.anInt707;
				local40 = local30 * arg0 + local16 * arg6 >> 16;
				@Pc(50) int local50 = local30 * arg6 - local16 * arg0 >> 16;
				@Pc(62) int local62 = local23 * arg4 - local50 * arg5 >> 16;
				@Pc(72) int local72 = local23 * arg5 + local50 * arg4 >> 16;
				if (local72 < 50) {
					return;
				}
				if (arg2.anIntArray167 != null) {
					Static18.anIntArray170[local7] = local40;
					Static18.anIntArray171[local7] = local62;
					Static18.anIntArray172[local7] = local72;
				}
				Static18.anIntArray168[local7] = Static15.anInt430 + (local40 << 9) / local72;
				Static18.anIntArray169[local7] = Static15.anInt431 + (local62 << 9) / local72;
			}
			Static15.anInt429 = 0;
			local5 = arg2.anIntArray164.length;
			if (arg7) {
				for (local16 = 0; local16 < local5; local16++) {
					local23 = arg2.anIntArray164[local16];
					local30 = arg2.anIntArray165[local16];
					local40 = arg2.anIntArray166[local16];
					@Pc(149) int local149 = Static18.anIntArray168[local23];
					@Pc(153) int local153 = Static18.anIntArray168[local30];
					@Pc(157) int local157 = Static18.anIntArray168[local40];
					@Pc(161) int local161 = Static18.anIntArray169[local23];
					@Pc(165) int local165 = Static18.anIntArray169[local30];
					@Pc(169) int local169 = Static18.anIntArray169[local40];
					if ((local149 - local153) * (local169 - local165) - (local161 - local165) * (local157 - local153) > 0) {
						Static15.aBoolean97 = false;
						if (local149 < 0 || local153 < 0 || local157 < 0 || local149 > Static12.anInt534 || local153 > Static12.anInt534 || local157 > Static12.anInt534) {
							Static15.aBoolean97 = true;
						}
						if (Static25.aBoolean144 && this.method512(Static25.anInt712, Static25.anInt713, local161, local165, local169, local149, local153, local157)) {
							Static25.anInt714 = arg3;
							Static25.anInt715 = arg1;
						}
						if (arg2.anIntArray167 == null || arg2.anIntArray167[local16] == -1) {
							if (arg2.anIntArray161[local16] != 12345678) {
								Static15.method298(local161, local165, local169, local149, local153, local157, arg2.anIntArray161[local16], arg2.anIntArray162[local16], arg2.anIntArray163[local16]);
							}
						} else if (Static25.aBoolean143) {
							@Pc(373) int local373 = Static25.anIntArray210[arg2.anIntArray167[local16]];
							Static15.method298(local161, local165, local169, local149, local153, local157, this.method511(arg2.anIntArray161[local16], local373, 9), this.method511(arg2.anIntArray162[local16], local373, 9), this.method511(arg2.anIntArray163[local16], local373, 9));
						} else if (arg2.aBoolean114) {
							Static15.method302(local161, local165, local169, local149, local153, local157, arg2.anIntArray161[local16], arg2.anIntArray162[local16], arg2.anIntArray163[local16], Static18.anIntArray170[0], Static18.anIntArray170[1], Static18.anIntArray170[3], Static18.anIntArray171[0], Static18.anIntArray171[1], Static18.anIntArray171[3], Static18.anIntArray172[0], Static18.anIntArray172[1], Static18.anIntArray172[3], arg2.anIntArray167[local16]);
						} else {
							Static15.method302(local161, local165, local169, local149, local153, local157, arg2.anIntArray161[local16], arg2.anIntArray162[local16], arg2.anIntArray163[local16], Static18.anIntArray170[local23], Static18.anIntArray170[local30], Static18.anIntArray170[local40], Static18.anIntArray171[local23], Static18.anIntArray171[local30], Static18.anIntArray171[local40], Static18.anIntArray172[local23], Static18.anIntArray172[local30], Static18.anIntArray172[local40], arg2.anIntArray167[local16]);
						}
					}
				}
			}
		} catch (@Pc(410) RuntimeException local410) {
			signlink.reporterror("35054, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + local410.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "f", descriptor = "(III)I")
	private int method511(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(3) int local3 = 127 - arg0;
			if (arg2 < 9 || arg2 > 9) {
				return 4;
			}
			arg0 = local3 * (arg1 & 0x7F) / 160;
			if (arg0 < 2) {
				arg0 = 2;
			} else if (arg0 > 126) {
				arg0 = 126;
			}
			return (arg1 & 0xFF80) + arg0;
		} catch (@Pc(38) RuntimeException local38) {
			signlink.reporterror("2630, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local38.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIII)Z")
	private boolean method512(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else if (arg0 > arg5 && arg0 > arg6 && arg0 > arg7) {
			return false;
		} else {
			@Pc(59) int local59 = (arg1 - arg2) * (arg6 - arg5) - (arg0 - arg5) * (arg3 - arg2);
			@Pc(75) int local75 = (arg1 - arg4) * (arg5 - arg7) - (arg0 - arg7) * (arg2 - arg4);
			@Pc(91) int local91 = (arg1 - arg3) * (arg7 - arg6) - (arg0 - arg6) * (arg4 - arg3);
			return local59 * local91 > 0 && local91 * local75 > 0;
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(Z)V")
	private void method513(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(5) int local5 = Static25.anIntArray202[Static25.anInt697];
			@Pc(9) Class24[] local9 = Static25.aClass24ArrayArray1[Static25.anInt697];
			Static25.anInt717 = 0;
			for (@Pc(13) int local13 = 0; local13 < local5; local13++) {
				@Pc(19) Class24 local19 = local9[local13];
				@Pc(30) int local30;
				@Pc(43) int local43;
				@Pc(54) int local54;
				@Pc(84) int local84;
				@Pc(61) boolean local61;
				if (local19.anInt615 == 1) {
					local30 = local19.anInt611 + 25 - Static25.anInt703;
					if (local30 >= 0 && local30 <= 50) {
						local43 = local19.anInt613 + 25 - Static25.anInt704;
						if (local43 < 0) {
							local43 = 0;
						}
						local54 = local19.anInt614 + 25 - Static25.anInt704;
						if (local54 > 50) {
							local54 = 50;
						}
						local61 = false;
						while (local43 <= local54) {
							if (Static25.aBooleanArrayArray1[local30][local43++]) {
								local61 = true;
								break;
							}
						}
						if (local61) {
							local84 = Static25.anInt705 - local19.anInt616;
							if (local84 > 32) {
								local19.anInt622 = 1;
							} else {
								if (local84 >= -32) {
									continue;
								}
								local19.anInt622 = 2;
								local84 = -local84;
							}
							local19.anInt625 = (local19.anInt618 - Static25.anInt707 << 8) / local84;
							local19.anInt626 = (local19.anInt619 - Static25.anInt707 << 8) / local84;
							local19.anInt627 = (local19.anInt620 - Static25.anInt706 << 8) / local84;
							local19.anInt628 = (local19.anInt621 - Static25.anInt706 << 8) / local84;
							Static25.aClass24Array1[Static25.anInt717++] = local19;
						}
					}
				} else if (local19.anInt615 == 2) {
					local30 = local19.anInt613 + 25 - Static25.anInt704;
					if (local30 >= 0 && local30 <= 50) {
						local43 = local19.anInt611 + 25 - Static25.anInt703;
						if (local43 < 0) {
							local43 = 0;
						}
						local54 = local19.anInt612 + 25 - Static25.anInt703;
						if (local54 > 50) {
							local54 = 50;
						}
						local61 = false;
						while (local43 <= local54) {
							if (Static25.aBooleanArrayArray1[local43++][local30]) {
								local61 = true;
								break;
							}
						}
						if (local61) {
							local84 = Static25.anInt707 - local19.anInt618;
							if (local84 > 32) {
								local19.anInt622 = 3;
							} else {
								if (local84 >= -32) {
									continue;
								}
								local19.anInt622 = 4;
								local84 = -local84;
							}
							local19.anInt623 = (local19.anInt616 - Static25.anInt705 << 8) / local84;
							local19.anInt624 = (local19.anInt617 - Static25.anInt705 << 8) / local84;
							local19.anInt627 = (local19.anInt620 - Static25.anInt706 << 8) / local84;
							local19.anInt628 = (local19.anInt621 - Static25.anInt706 << 8) / local84;
							Static25.aClass24Array1[Static25.anInt717++] = local19;
						}
					}
				} else if (local19.anInt615 == 4) {
					local30 = local19.anInt620 - Static25.anInt706;
					if (local30 > 128) {
						local43 = local19.anInt613 + 25 - Static25.anInt704;
						if (local43 < 0) {
							local43 = 0;
						}
						local54 = local19.anInt614 + 25 - Static25.anInt704;
						if (local54 > 50) {
							local54 = 50;
						}
						if (local43 <= local54) {
							@Pc(330) int local330 = local19.anInt611 + 25 - Static25.anInt703;
							if (local330 < 0) {
								local330 = 0;
							}
							local84 = local19.anInt612 + 25 - Static25.anInt703;
							if (local84 > 50) {
								local84 = 50;
							}
							@Pc(348) boolean local348 = false;
							label149: for (@Pc(350) int local350 = local330; local350 <= local84; local350++) {
								for (@Pc(354) int local354 = local43; local354 <= local54; local354++) {
									if (Static25.aBooleanArrayArray1[local350][local354]) {
										local348 = true;
										break label149;
									}
								}
							}
							if (local348) {
								local19.anInt622 = 5;
								local19.anInt623 = (local19.anInt616 - Static25.anInt705 << 8) / local30;
								local19.anInt624 = (local19.anInt617 - Static25.anInt705 << 8) / local30;
								local19.anInt625 = (local19.anInt618 - Static25.anInt707 << 8) / local30;
								local19.anInt626 = (local19.anInt619 - Static25.anInt707 << 8) / local30;
								Static25.aClass24Array1[Static25.anInt717++] = local19;
							}
						}
					}
				}
			}
			if (!arg0) {
				;
			}
		} catch (@Pc(436) RuntimeException local436) {
			signlink.reporterror("51205, " + arg0 + ", " + local436.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!r", name = "g", descriptor = "(III)Z")
	private boolean method514(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) int local8 = this.anIntArrayArrayArray5[arg0][arg1][arg2];
		if (local8 == -Static25.anInt698) {
			return false;
		} else if (local8 == Static25.anInt698) {
			return true;
		} else {
			@Pc(23) int local23 = arg1 << 7;
			@Pc(27) int local27 = arg2 << 7;
			if (this.method518(local23 + 1, this.anIntArrayArrayArray4[arg0][arg1][arg2], local27 + 1) && this.method518(local23 + 128 - 1, this.anIntArrayArrayArray4[arg0][arg1 + 1][arg2], local27 + 1) && this.method518(local23 + 128 - 1, this.anIntArrayArrayArray4[arg0][arg1 + 1][arg2 + 1], local27 + 128 - 1) && this.method518(local23 + 1, this.anIntArrayArrayArray4[arg0][arg1][arg2 + 1], local27 + 128 - 1)) {
				this.anIntArrayArrayArray5[arg0][arg1][arg2] = Static25.anInt698;
				return true;
			} else {
				this.anIntArrayArrayArray5[arg0][arg1][arg2] = -Static25.anInt698;
				return false;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "i", descriptor = "(IIII)Z")
	private boolean method515(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (!this.method514(arg0, arg1, arg2)) {
			return false;
		}
		@Pc(11) int local11 = arg1 << 7;
		@Pc(15) int local15 = arg2 << 7;
		@Pc(26) int local26 = this.anIntArrayArrayArray4[arg0][arg1][arg2] - 1;
		@Pc(30) int local30 = local26 - 120;
		@Pc(34) int local34 = local26 - 230;
		@Pc(38) int local38 = local26 - 238;
		if (arg3 < 16) {
			if (arg3 == 1) {
				if (local11 > Static25.anInt705) {
					if (!this.method518(local11, local26, local15)) {
						return false;
					}
					if (!this.method518(local11, local26, local15 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method518(local11, local30, local15)) {
						return false;
					}
					if (!this.method518(local11, local30, local15 + 128)) {
						return false;
					}
				}
				if (!this.method518(local11, local34, local15)) {
					return false;
				}
				if (!this.method518(local11, local34, local15 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 2) {
				if (local15 < Static25.anInt707) {
					if (!this.method518(local11, local26, local15 + 128)) {
						return false;
					}
					if (!this.method518(local11 + 128, local26, local15 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method518(local11, local30, local15 + 128)) {
						return false;
					}
					if (!this.method518(local11 + 128, local30, local15 + 128)) {
						return false;
					}
				}
				if (!this.method518(local11, local34, local15 + 128)) {
					return false;
				}
				if (!this.method518(local11 + 128, local34, local15 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 4) {
				if (local11 < Static25.anInt705) {
					if (!this.method518(local11 + 128, local26, local15)) {
						return false;
					}
					if (!this.method518(local11 + 128, local26, local15 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method518(local11 + 128, local30, local15)) {
						return false;
					}
					if (!this.method518(local11 + 128, local30, local15 + 128)) {
						return false;
					}
				}
				if (!this.method518(local11 + 128, local34, local15)) {
					return false;
				}
				if (!this.method518(local11 + 128, local34, local15 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 8) {
				if (local15 > Static25.anInt707) {
					if (!this.method518(local11, local26, local15)) {
						return false;
					}
					if (!this.method518(local11 + 128, local26, local15)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.method518(local11, local30, local15)) {
						return false;
					}
					if (!this.method518(local11 + 128, local30, local15)) {
						return false;
					}
				}
				if (!this.method518(local11, local34, local15)) {
					return false;
				}
				if (!this.method518(local11 + 128, local34, local15)) {
					return false;
				}
				return true;
			}
		}
		if (!this.method518(local11 + 64, local38, local15 + 64)) {
			return false;
		} else if (arg3 == 16) {
			return this.method518(local11, local34, local15 + 128);
		} else if (arg3 == 32) {
			return this.method518(local11 + 128, local34, local15 + 128);
		} else if (arg3 == 64) {
			return this.method518(local11 + 128, local34, local15);
		} else if (arg3 == 128) {
			return this.method518(local11, local34, local15);
		} else {
			System.out.println("Warning unsupported wall type");
			return true;
		}
	}

	@OriginalMember(owner = "client!r", name = "j", descriptor = "(IIII)Z")
	private boolean method516(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (this.method514(arg0, arg1, arg2)) {
			@Pc(11) int local11 = arg1 << 7;
			@Pc(15) int local15 = arg2 << 7;
			return this.method518(local11 + 1, this.anIntArrayArrayArray4[arg0][arg1][arg2] - arg3, local15 + 1) && this.method518(local11 + 128 - 1, this.anIntArrayArrayArray4[arg0][arg1 + 1][arg2] - arg3, local15 + 1) && this.method518(local11 + 128 - 1, this.anIntArrayArrayArray4[arg0][arg1 + 1][arg2 + 1] - arg3, local15 + 128 - 1) && this.method518(local11 + 1, this.anIntArrayArrayArray4[arg0][arg1][arg2 + 1] - arg3, local15 + 128 - 1);
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIII)Z")
	private boolean method517(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(19) int local19;
		@Pc(23) int local23;
		if (arg1 != arg2 || arg3 != arg4) {
			for (local19 = arg1; local19 <= arg2; local19++) {
				for (local23 = arg3; local23 <= arg4; local23++) {
					if (this.anIntArrayArrayArray5[arg0][local19][local23] == -Static25.anInt698) {
						return false;
					}
				}
			}
			local23 = (arg1 << 7) + 1;
			@Pc(160) int local160 = (arg3 << 7) + 2;
			@Pc(171) int local171 = this.anIntArrayArrayArray4[arg0][arg1][arg3] - arg5;
			if (!this.method518(local23, local171, local160)) {
				return false;
			}
			@Pc(185) int local185 = (arg2 << 7) - 1;
			if (!this.method518(local185, local171, local160)) {
				return false;
			}
			@Pc(199) int local199 = (arg4 << 7) - 1;
			if (!this.method518(local23, local171, local199)) {
				return false;
			} else if (this.method518(local185, local171, local199)) {
				return true;
			} else {
				return false;
			}
		} else if (this.method514(arg0, arg1, arg3)) {
			local19 = arg1 << 7;
			local23 = arg3 << 7;
			return this.method518(local19 + 1, this.anIntArrayArrayArray4[arg0][arg1][arg3] - arg5, local23 + 1) && this.method518(local19 + 128 - 1, this.anIntArrayArrayArray4[arg0][arg1 + 1][arg3] - arg5, local23 + 1) && this.method518(local19 + 128 - 1, this.anIntArrayArrayArray4[arg0][arg1 + 1][arg3 + 1] - arg5, local23 + 128 - 1) && this.method518(local19 + 1, this.anIntArrayArrayArray4[arg0][arg1][arg3 + 1] - arg5, local23 + 128 - 1);
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "h", descriptor = "(III)Z")
	private boolean method518(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		for (@Pc(1) int local1 = 0; local1 < Static25.anInt717; local1++) {
			@Pc(7) Class24 local7 = Static25.aClass24Array1[local1];
			@Pc(16) int local16;
			@Pc(28) int local28;
			@Pc(38) int local38;
			@Pc(48) int local48;
			@Pc(58) int local58;
			if (local7.anInt622 == 1) {
				local16 = local7.anInt616 - arg0;
				if (local16 > 0) {
					local28 = local7.anInt618 + (local7.anInt625 * local16 >> 8);
					local38 = local7.anInt619 + (local7.anInt626 * local16 >> 8);
					local48 = local7.anInt620 + (local7.anInt627 * local16 >> 8);
					local58 = local7.anInt621 + (local7.anInt628 * local16 >> 8);
					if (arg2 >= local28 && arg2 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.anInt622 == 2) {
				local16 = arg0 - local7.anInt616;
				if (local16 > 0) {
					local28 = local7.anInt618 + (local7.anInt625 * local16 >> 8);
					local38 = local7.anInt619 + (local7.anInt626 * local16 >> 8);
					local48 = local7.anInt620 + (local7.anInt627 * local16 >> 8);
					local58 = local7.anInt621 + (local7.anInt628 * local16 >> 8);
					if (arg2 >= local28 && arg2 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.anInt622 == 3) {
				local16 = local7.anInt618 - arg2;
				if (local16 > 0) {
					local28 = local7.anInt616 + (local7.anInt623 * local16 >> 8);
					local38 = local7.anInt617 + (local7.anInt624 * local16 >> 8);
					local48 = local7.anInt620 + (local7.anInt627 * local16 >> 8);
					local58 = local7.anInt621 + (local7.anInt628 * local16 >> 8);
					if (arg0 >= local28 && arg0 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.anInt622 == 4) {
				local16 = arg2 - local7.anInt618;
				if (local16 > 0) {
					local28 = local7.anInt616 + (local7.anInt623 * local16 >> 8);
					local38 = local7.anInt617 + (local7.anInt624 * local16 >> 8);
					local48 = local7.anInt620 + (local7.anInt627 * local16 >> 8);
					local58 = local7.anInt621 + (local7.anInt628 * local16 >> 8);
					if (arg0 >= local28 && arg0 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.anInt622 == 5) {
				local16 = arg1 - local7.anInt620;
				if (local16 > 0) {
					local28 = local7.anInt616 + (local7.anInt623 * local16 >> 8);
					local38 = local7.anInt617 + (local7.anInt624 * local16 >> 8);
					local48 = local7.anInt618 + (local7.anInt625 * local16 >> 8);
					local58 = local7.anInt619 + (local7.anInt626 * local16 >> 8);
					if (arg0 >= local28 && arg0 <= local38 && arg2 >= local48 && arg2 <= local58) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
