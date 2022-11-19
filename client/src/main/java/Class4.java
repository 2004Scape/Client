import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!c")
public final class Class4 {

	@OriginalMember(owner = "client!c", name = "b", descriptor = "Z")
	private boolean aBoolean22 = true;

	@OriginalMember(owner = "client!c", name = "c", descriptor = "I")
	private int anInt80 = 8;

	@OriginalMember(owner = "client!c", name = "g", descriptor = "I")
	private final int anInt82;

	@OriginalMember(owner = "client!c", name = "h", descriptor = "I")
	private final int anInt83;

	@OriginalMember(owner = "client!c", name = "i", descriptor = "[[[I")
	private final int[][][] anIntArrayArrayArray1;

	@OriginalMember(owner = "client!c", name = "j", descriptor = "[[[B")
	private final byte[][][] aByteArrayArrayArray1;

	@OriginalMember(owner = "client!c", name = "k", descriptor = "[[[B")
	private final byte[][][] aByteArrayArrayArray2;

	@OriginalMember(owner = "client!c", name = "l", descriptor = "[[[B")
	private final byte[][][] aByteArrayArrayArray3;

	@OriginalMember(owner = "client!c", name = "m", descriptor = "[[[B")
	private final byte[][][] aByteArrayArrayArray4;

	@OriginalMember(owner = "client!c", name = "n", descriptor = "[[[B")
	private final byte[][][] aByteArrayArrayArray5;

	@OriginalMember(owner = "client!c", name = "v", descriptor = "[[[I")
	private final int[][][] anIntArrayArrayArray2;

	@OriginalMember(owner = "client!c", name = "o", descriptor = "[[[B")
	private final byte[][][] aByteArrayArrayArray6;

	@OriginalMember(owner = "client!c", name = "p", descriptor = "[[I")
	private final int[][] anIntArrayArray1;

	@OriginalMember(owner = "client!c", name = "q", descriptor = "[I")
	private final int[] anIntArray13;

	@OriginalMember(owner = "client!c", name = "r", descriptor = "[I")
	private final int[] anIntArray14;

	@OriginalMember(owner = "client!c", name = "s", descriptor = "[I")
	private final int[] anIntArray15;

	@OriginalMember(owner = "client!c", name = "t", descriptor = "[I")
	private final int[] anIntArray16;

	@OriginalMember(owner = "client!c", name = "u", descriptor = "[I")
	private final int[] anIntArray17;

	@OriginalMember(owner = "client!c", name = "<init>", descriptor = "(I[[[BI[[[II)V")
	public Class4(@OriginalArg(0) int arg0, @OriginalArg(1) byte[][][] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[][][] arg3, @OriginalArg(4) int arg4) {
		try {
			this.anInt82 = arg2;
			this.anInt83 = arg0;
			this.anIntArrayArrayArray1 = arg3;
			this.aByteArrayArrayArray1 = arg1;
			this.aByteArrayArrayArray2 = new byte[4][this.anInt82][this.anInt83];
			this.aByteArrayArrayArray3 = new byte[4][this.anInt82][this.anInt83];
			this.aByteArrayArrayArray4 = new byte[4][this.anInt82][this.anInt83];
			this.aByteArrayArrayArray5 = new byte[4][this.anInt82][this.anInt83];
			this.anIntArrayArrayArray2 = new int[4][this.anInt82 + 1][this.anInt83 + 1];
			this.aByteArrayArrayArray6 = new byte[4][this.anInt82 + 1][this.anInt83 + 1];
			this.anIntArrayArray1 = new int[this.anInt82 + 1][this.anInt83 + 1];
			this.anIntArray13 = new int[this.anInt83];
			this.anIntArray14 = new int[this.anInt83];
			if (arg4 != -35388) {
				this.anInt80 = 28;
			}
			this.anIntArray15 = new int[this.anInt83];
			this.anIntArray16 = new int[this.anInt83];
			this.anIntArray17 = new int[this.anInt83];
		} catch (@Pc(119) RuntimeException local119) {
			signlink.reporterror("87235, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local119.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IIIII)V")
	public void method36(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			@Pc(3) byte local3 = 0;
			if (arg2 != 3) {
				this.anInt80 = 123;
			}
			for (@Pc(11) int local11 = 0; local11 < Static13.anInt402; local11++) {
				if (Static13.aClass11Array1[local11].aString19.equalsIgnoreCase("water")) {
					local3 = (byte) (local11 + 1);
					break;
				}
			}
			for (@Pc(33) int local33 = arg1; local33 < arg1 + arg4; local33++) {
				for (@Pc(37) int local37 = arg0; local37 < arg0 + arg3; local37++) {
					if (local37 >= 0 && local37 < this.anInt82 && local33 >= 0 && local33 < this.anInt83) {
						this.aByteArrayArrayArray3[0][local37][local33] = local3;
						for (@Pc(62) int local62 = 0; local62 < 4; local62++) {
							this.anIntArrayArrayArray1[local62][local37][local33] = 0;
							this.aByteArrayArrayArray1[local62][local37][local33] = 0;
						}
					}
				}
			}
		} catch (@Pc(100) RuntimeException local100) {
			signlink.reporterror("25754, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local100.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "([BIIIII)V")
	public void method37(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			@Pc(7) Class1_Sub3_Sub3 local7 = new Class1_Sub3_Sub3(363, arg0);
			if (arg2 != 1) {
				this.aBoolean22 = !this.aBoolean22;
			}
			for (@Pc(20) int local20 = 0; local20 < 4; local20++) {
				for (@Pc(24) int local24 = 0; local24 < 64; local24++) {
					for (@Pc(28) int local28 = 0; local28 < 64; local28++) {
						@Pc(34) int local34 = local24 + arg4;
						@Pc(38) int local38 = local28 + arg3;
						@Pc(60) int local60;
						if (local34 >= 0 && local34 < 104 && local38 >= 0 && local38 < 104) {
							this.aByteArrayArrayArray1[local20][local34][local38] = 0;
							while (true) {
								local60 = local7.method391();
								if (local60 == 0) {
									if (local20 == 0) {
										this.anIntArrayArrayArray1[0][local34][local38] = -Static4.method42(local34 + arg1 + 932731, local38 + 556238 + arg5) * 8;
									} else {
										this.anIntArrayArrayArray1[local20][local34][local38] = this.anIntArrayArrayArray1[local20 - 1][local34][local38] - 240;
									}
									break;
								}
								if (local60 == 1) {
									@Pc(116) int local116 = local7.method391();
									if (local116 == 1) {
										local116 = 0;
									}
									if (local20 == 0) {
										this.anIntArrayArrayArray1[0][local34][local38] = -local116 * 8;
									} else {
										this.anIntArrayArrayArray1[local20][local34][local38] = this.anIntArrayArrayArray1[local20 - 1][local34][local38] - local116 * 8;
									}
									break;
								}
								if (local60 <= 49) {
									this.aByteArrayArrayArray3[local20][local34][local38] = local7.method392();
									this.aByteArrayArrayArray4[local20][local34][local38] = (byte) ((local60 - 2) / 4);
									this.aByteArrayArrayArray5[local20][local34][local38] = (byte) (local60 - 2 & 0x3);
								} else if (local60 <= 81) {
									this.aByteArrayArrayArray1[local20][local34][local38] = (byte) (local60 - 49);
								} else {
									this.aByteArrayArrayArray2[local20][local34][local38] = (byte) (local60 - 81);
								}
							}
						} else {
							while (true) {
								local60 = local7.method391();
								if (local60 == 0) {
									break;
								}
								if (local60 == 1) {
									local7.method391();
									break;
								}
								if (local60 <= 49) {
									local7.method391();
								}
							}
						}
					}
				}
			}
		} catch (@Pc(270) RuntimeException local270) {
			signlink.reporterror("89670, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local270.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "([BLclient!r;[Lclient!ec;Lclient!ob;ZII)V")
	public void method38(@OriginalArg(0) byte[] arg0, @OriginalArg(1) Class33 arg1, @OriginalArg(2) Class9[] arg2, @OriginalArg(3) Class28 arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			@Pc(7) Class1_Sub3_Sub3 local7 = new Class1_Sub3_Sub3(363, arg0);
			if (!arg4) {
				this.aBoolean22 = !this.aBoolean22;
			}
			@Pc(19) int local19 = -1;
			while (true) {
				@Pc(22) int local22 = local7.method405();
				if (local22 == 0) {
					return;
				}
				local19 += local22;
				@Pc(30) int local30 = 0;
				while (true) {
					@Pc(33) int local33 = local7.method405();
					if (local33 == 0) {
						break;
					}
					local30 += local33 - 1;
					@Pc(45) int local45 = local30 & 0x3F;
					@Pc(51) int local51 = local30 >> 6 & 0x3F;
					@Pc(55) int local55 = local30 >> 12;
					@Pc(58) int local58 = local7.method391();
					@Pc(62) int local62 = local58 >> 2;
					@Pc(66) int local66 = local58 & 0x3;
					@Pc(70) int local70 = local51 + arg6;
					@Pc(74) int local74 = local45 + arg5;
					if (local70 > 0 && local74 > 0 && local70 < 103 && local74 < 103) {
						@Pc(86) int local86 = local55;
						if ((this.aByteArrayArrayArray1[1][local70][local74] & 0x2) == 2) {
							local86 = local55 - 1;
						}
						@Pc(101) Class9 local101 = null;
						if (local86 >= 0) {
							local101 = arg2[local86];
						}
						this.method39(local101, true, local55, local74, local66, local62, arg1, arg3, local19, local70);
					}
				}
			}
		} catch (@Pc(125) RuntimeException local125) {
			signlink.reporterror("51686, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local125.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!ec;ZIIIILclient!r;Lclient!ob;II)V")
	private void method39(@OriginalArg(0) Class9 arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) Class33 arg6, @OriginalArg(7) Class28 arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9) {
		try {
			if (arg1) {
				if (Static4.aBoolean23) {
					if ((this.aByteArrayArrayArray1[arg2][arg9][arg3] & 0x10) != 0) {
						return;
					}
					if (this.method41(arg2, (byte) 10, arg9, arg3) != Static4.anInt81) {
						return;
					}
				}
				@Pc(36) int local36 = this.anIntArrayArrayArray1[arg2][arg9][arg3];
				@Pc(47) int local47 = this.anIntArrayArrayArray1[arg2][arg9 + 1][arg3];
				@Pc(60) int local60 = this.anIntArrayArrayArray1[arg2][arg9 + 1][arg3 + 1];
				@Pc(71) int local71 = this.anIntArrayArrayArray1[arg2][arg9][arg3 + 1];
				@Pc(81) int local81 = local36 + local47 + local60 + local71 >> 2;
				@Pc(84) Class2 local84 = Static2.method23(arg8);
				@Pc(96) int local96 = arg9 + (arg3 << 7) + (arg8 << 14) + 1073741824;
				if (!local84.aBoolean9) {
					local96 += Integer.MIN_VALUE;
				}
				@Pc(110) byte local110 = (byte) ((arg4 << 6) + arg5);
				@Pc(132) Class1_Sub3_Sub1 local132;
				if (arg5 != 22) {
					@Pc(209) int local209;
					if (arg5 == 10 || arg5 == 11) {
						local132 = local84.method26(10, arg4, local36, local47, local60, local71, -1);
						if (local132 != null) {
							@Pc(196) int local196 = 0;
							if (arg5 == 11) {
								local196 += 256;
							}
							@Pc(212) int local212;
							if (arg4 == 1 || arg4 == 3) {
								local209 = local84.anInt44;
								local212 = local84.anInt43;
							} else {
								local209 = local84.anInt43;
								local212 = local84.anInt44;
							}
							if (arg6.method477(local81, 775, arg2, null, local96, arg3, arg9, local209, local110, local132, local196, local212) && local84.aBoolean15) {
								for (@Pc(240) int local240 = 0; local240 <= local209; local240++) {
									for (@Pc(244) int local244 = 0; local244 <= local212; local244++) {
										@Pc(251) int local251 = local132.anInt367 / 4;
										if (local251 > 30) {
											local251 = 30;
										}
										if (local251 > this.aByteArrayArrayArray6[arg2][arg9 + local240][arg3 + local244]) {
											this.aByteArrayArrayArray6[arg2][arg9 + local240][arg3 + local244] = (byte) local251;
										}
									}
								}
							}
						}
						if (local84.aBoolean7 && arg0 != null) {
							arg0.method251(arg4, local84.anInt44, local84.anInt43, arg9, 9, arg3, local84.aBoolean8);
						}
						if (local84.anInt45 != -1) {
							arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 2, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
						}
					} else if (arg5 >= 12) {
						local132 = local84.method26(arg5, arg4, local36, local47, local60, local71, -1);
						arg6.method477(local81, 775, arg2, null, local96, arg3, arg9, 1, local110, local132, 0, 1);
						if (arg5 >= 12 && arg5 <= 17 && arg5 != 13 && arg2 > 0) {
							this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x924;
						}
						if (local84.aBoolean7 && arg0 != null) {
							arg0.method251(arg4, local84.anInt44, local84.anInt43, arg9, 9, arg3, local84.aBoolean8);
						}
						if (local84.anInt45 != -1) {
							arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 2, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
						}
					} else if (arg5 == 0) {
						local132 = local84.method26(0, arg4, local36, local47, local60, local71, -1);
						arg6.method475(0, local81, arg2, Static4.anIntArray18[arg4], 8, local132, null, arg9, local96, arg3, local110);
						if (arg4 == 0) {
							if (local84.aBoolean15) {
								this.aByteArrayArrayArray6[arg2][arg9][arg3] = 50;
								this.aByteArrayArrayArray6[arg2][arg9][arg3 + 1] = 50;
							}
							if (local84.aBoolean12) {
								this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x249;
							}
						} else if (arg4 == 1) {
							if (local84.aBoolean15) {
								this.aByteArrayArrayArray6[arg2][arg9][arg3 + 1] = 50;
								this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3 + 1] = 50;
							}
							if (local84.aBoolean12) {
								this.anIntArrayArrayArray2[arg2][arg9][arg3 + 1] |= 0x492;
							}
						} else if (arg4 == 2) {
							if (local84.aBoolean15) {
								this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3] = 50;
								this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3 + 1] = 50;
							}
							if (local84.aBoolean12) {
								this.anIntArrayArrayArray2[arg2][arg9 + 1][arg3] |= 0x249;
							}
						} else if (arg4 == 3) {
							if (local84.aBoolean15) {
								this.aByteArrayArrayArray6[arg2][arg9][arg3] = 50;
								this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3] = 50;
							}
							if (local84.aBoolean12) {
								this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x492;
							}
						}
						if (local84.aBoolean7 && arg0 != null) {
							arg0.method250(true, arg4, arg3, arg9, local84.aBoolean8, arg5);
						}
						if (local84.anInt45 != -1) {
							arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 0, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
						}
						if (local84.anInt46 != 16) {
							arg6.method484(arg2, arg3, arg9, local84.anInt46, (byte) 6);
						}
					} else if (arg5 == 1) {
						local132 = local84.method26(1, arg4, local36, local47, local60, local71, -1);
						arg6.method475(0, local81, arg2, Static4.anIntArray19[arg4], 8, local132, null, arg9, local96, arg3, local110);
						if (local84.aBoolean15) {
							if (arg4 == 0) {
								this.aByteArrayArrayArray6[arg2][arg9][arg3 + 1] = 50;
							} else if (arg4 == 1) {
								this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3 + 1] = 50;
							} else if (arg4 == 2) {
								this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3] = 50;
							} else if (arg4 == 3) {
								this.aByteArrayArrayArray6[arg2][arg9][arg3] = 50;
							}
						}
						if (local84.aBoolean7 && arg0 != null) {
							arg0.method250(true, arg4, arg3, arg9, local84.aBoolean8, arg5);
						}
						if (local84.anInt45 != -1) {
							arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 0, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
						}
					} else {
						@Pc(810) int local810;
						@Pc(832) Class1_Sub3_Sub1 local832;
						if (arg5 == 2) {
							local810 = arg4 + 1 & 0x3;
							@Pc(822) Class1_Sub3_Sub1 local822 = local84.method26(2, arg4 + 4, local36, local47, local60, local71, -1);
							local832 = local84.method26(2, local810, local36, local47, local60, local71, -1);
							arg6.method475(Static4.anIntArray18[local810], local81, arg2, Static4.anIntArray18[arg4], 8, local822, local832, arg9, local96, arg3, local110);
							if (local84.aBoolean12) {
								if (arg4 == 0) {
									this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x249;
									this.anIntArrayArrayArray2[arg2][arg9][arg3 + 1] |= 0x492;
								} else if (arg4 == 1) {
									this.anIntArrayArrayArray2[arg2][arg9][arg3 + 1] |= 0x492;
									this.anIntArrayArrayArray2[arg2][arg9 + 1][arg3] |= 0x249;
								} else if (arg4 == 2) {
									this.anIntArrayArrayArray2[arg2][arg9 + 1][arg3] |= 0x249;
									this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x492;
								} else if (arg4 == 3) {
									this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x492;
									this.anIntArrayArrayArray2[arg2][arg9][arg3] |= 0x249;
								}
							}
							if (local84.aBoolean7 && arg0 != null) {
								arg0.method250(true, arg4, arg3, arg9, local84.aBoolean8, arg5);
							}
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 0, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
							if (local84.anInt46 != 16) {
								arg6.method484(arg2, arg3, arg9, local84.anInt46, (byte) 6);
							}
						} else if (arg5 == 3) {
							local132 = local84.method26(3, arg4, local36, local47, local60, local71, -1);
							arg6.method475(0, local81, arg2, Static4.anIntArray19[arg4], 8, local132, null, arg9, local96, arg3, local110);
							if (local84.aBoolean15) {
								if (arg4 == 0) {
									this.aByteArrayArrayArray6[arg2][arg9][arg3 + 1] = 50;
								} else if (arg4 == 1) {
									this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3 + 1] = 50;
								} else if (arg4 == 2) {
									this.aByteArrayArrayArray6[arg2][arg9 + 1][arg3] = 50;
								} else if (arg4 == 3) {
									this.aByteArrayArrayArray6[arg2][arg9][arg3] = 50;
								}
							}
							if (local84.aBoolean7 && arg0 != null) {
								arg0.method250(true, arg4, arg3, arg9, local84.aBoolean8, arg5);
							}
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 0, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						} else if (arg5 == 9) {
							local132 = local84.method26(arg5, arg4, local36, local47, local60, local71, -1);
							arg6.method477(local81, 775, arg2, null, local96, arg3, arg9, 1, local110, local132, 0, 1);
							if (local84.aBoolean7 && arg0 != null) {
								arg0.method251(arg4, local84.anInt44, local84.anInt43, arg9, 9, arg3, local84.aBoolean8);
							}
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 2, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						} else if (arg5 == 4) {
							local132 = local84.method26(4, 0, local36, local47, local60, local71, -1);
							arg6.method476(local81, arg3, 0, local96, arg4 * 512, Static4.anIntArray18[arg4], 465, 0, arg9, local132, local110, arg2);
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 1, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						} else if (arg5 == 5) {
							local810 = 16;
							local209 = arg6.method494(arg2, arg9, arg3);
							if (local209 > 0) {
								local810 = Static2.method23(local209 >> 14 & 0x7FFF).anInt46;
							}
							local832 = local84.method26(4, 0, local36, local47, local60, local71, -1);
							arg6.method476(local81, arg3, Static4.anIntArray21[arg4] * local810, local96, arg4 * 512, Static4.anIntArray18[arg4], 465, Static4.anIntArray20[arg4] * local810, arg9, local832, local110, arg2);
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 1, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						} else if (arg5 == 6) {
							local132 = local84.method26(4, 0, local36, local47, local60, local71, -1);
							arg6.method476(local81, arg3, 0, local96, arg4, 256, 465, 0, arg9, local132, local110, arg2);
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 1, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						} else if (arg5 == 7) {
							local132 = local84.method26(4, 0, local36, local47, local60, local71, -1);
							arg6.method476(local81, arg3, 0, local96, arg4, 512, 465, 0, arg9, local132, local110, arg2);
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 1, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						} else if (arg5 == 8) {
							local132 = local84.method26(4, 0, local36, local47, local60, local71, -1);
							arg6.method476(local81, arg3, 0, local96, arg4, 768, 465, 0, arg9, local132, local110, arg2);
							if (local84.anInt45 != -1) {
								arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 1, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
							}
						}
					}
				} else if (!Static4.aBoolean23 || local84.aBoolean9 || local84.aBoolean16) {
					local132 = local84.method26(22, arg4, local36, local47, local60, local71, -1);
					arg6.method473(local132, (byte) 6, arg9, local96, arg3, arg2, local110, local81);
					if (local84.aBoolean7 && local84.aBoolean9 && arg0 != null) {
						arg0.method252((byte) 12, arg3, arg9);
					}
					if (local84.anInt45 != -1) {
						arg7.method453(new Class1_Sub6(true, arg8, arg2, 0, 3, Static20.aClass19Array1[local84.anInt45], arg3, arg9));
					}
				}
			}
		} catch (@Pc(1488) RuntimeException local1488) {
			signlink.reporterror("46393, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + local1488.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!r;I[Lclient!ec;)V")
	public void method40(@OriginalArg(0) Class33 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class9[] arg2) {
		try {
			@Pc(7) int local7;
			@Pc(11) int local11;
			@Pc(27) int local27;
			for (@Pc(3) int local3 = 0; local3 < 4; local3++) {
				for (local7 = 0; local7 < 104; local7++) {
					for (local11 = 0; local11 < 104; local11++) {
						if ((this.aByteArrayArrayArray1[local3][local7][local11] & 0x1) == 1) {
							local27 = local3;
							if ((this.aByteArrayArrayArray1[1][local7][local11] & 0x2) == 2) {
								local27 = local3 - 1;
							}
							if (local27 >= 0) {
								arg2[local27].method252((byte) 12, local11, local7);
							}
						}
					}
				}
			}
			Static4.anInt84 += (int) (Math.random() * 5.0D) - 2;
			if (Static4.anInt84 < -8) {
				Static4.anInt84 = -8;
			}
			if (Static4.anInt84 > 8) {
				Static4.anInt84 = 8;
			}
			Static4.anInt85 += (int) (Math.random() * 5.0D) - 2;
			if (Static4.anInt85 < -16) {
				Static4.anInt85 = -16;
			}
			if (Static4.anInt85 > 16) {
				Static4.anInt85 = 16;
			}
			@Pc(133) int local133;
			@Pc(139) int local139;
			@Pc(141) int local141;
			@Pc(145) int local145;
			@Pc(169) int local169;
			@Pc(191) int local191;
			@Pc(204) int local204;
			@Pc(210) int local210;
			@Pc(214) int local214;
			@Pc(220) int local220;
			@Pc(236) int local236;
			@Pc(284) int local284;
			for (local7 = 0; local7 < 4; local7++) {
				@Pc(108) byte[][] local108 = this.aByteArrayArrayArray6[local7];
				@Pc(110) byte local110 = 96;
				@Pc(112) short local112 = 768;
				@Pc(114) byte local114 = -50;
				@Pc(116) byte local116 = -10;
				@Pc(118) byte local118 = -50;
				local133 = (int) Math.sqrt((double) (local114 * local114 + local116 * local116 + local118 * local118));
				local139 = local112 * local133 >> 8;
				for (local141 = 1; local141 < this.anInt83 - 1; local141++) {
					for (local145 = 1; local145 < this.anInt82 - 1; local145++) {
						local169 = this.anIntArrayArrayArray1[local7][local145 + 1][local141] - this.anIntArrayArrayArray1[local7][local145 - 1][local141];
						local191 = this.anIntArrayArrayArray1[local7][local145][local141 + 1] - this.anIntArrayArrayArray1[local7][local145][local141 - 1];
						local204 = (int) Math.sqrt((double) (local169 * local169 + local191 * local191 + 65536));
						local210 = (local169 << 8) / local204;
						local214 = 65536 / local204;
						local220 = (local191 << 8) / local204;
						local236 = local110 + (local114 * local210 + local116 * local214 + local118 * local220) / local139;
						local284 = (local108[local145 - 1][local141] >> 2) + (local108[local145 + 1][local141] >> 3) + (local108[local145][local141 - 1] >> 2) + (local108[local145][local141 + 1] >> 3) + (local108[local145][local141] >> 1);
						this.anIntArrayArray1[local145][local141] = local236 - local284;
					}
				}
				for (local145 = 0; local145 < this.anInt83; local145++) {
					this.anIntArray13[local145] = 0;
					this.anIntArray14[local145] = 0;
					this.anIntArray15[local145] = 0;
					this.anIntArray16[local145] = 0;
					this.anIntArray17[local145] = 0;
				}
				for (local169 = -5; local169 < this.anInt82 + 5; local169++) {
					for (local191 = 0; local191 < this.anInt83; local191++) {
						local204 = local169 + 5;
						@Pc(419) int local419;
						if (local204 >= 0 && local204 < this.anInt82) {
							local210 = this.aByteArrayArrayArray2[local7][local204][local191] & 0xFF;
							if (local210 > 0) {
								@Pc(378) Class11 local378 = Static13.aClass11Array1[local210 - 1];
								this.anIntArray13[local191] += local378.anInt408;
								this.anIntArray14[local191] += local378.anInt406;
								this.anIntArray15[local191] += local378.anInt407;
								this.anIntArray16[local191] += local378.anInt409;
								local419 = this.anIntArray17[local191]++;
							}
						}
						local210 = local169 - 5;
						if (local210 >= 0 && local210 < this.anInt82) {
							local214 = this.aByteArrayArrayArray2[local7][local210][local191] & 0xFF;
							if (local214 > 0) {
								@Pc(451) Class11 local451 = Static13.aClass11Array1[local214 - 1];
								this.anIntArray13[local191] -= local451.anInt408;
								this.anIntArray14[local191] -= local451.anInt406;
								this.anIntArray15[local191] -= local451.anInt407;
								this.anIntArray16[local191] -= local451.anInt409;
								local419 = this.anIntArray17[local191]--;
							}
						}
					}
					if (local169 >= 1 && local169 < this.anInt82 - 1) {
						local204 = 0;
						local210 = 0;
						local214 = 0;
						local220 = 0;
						local236 = 0;
						for (local284 = -5; local284 < this.anInt83 + 5; local284++) {
							@Pc(527) int local527 = local284 + 5;
							if (local527 >= 0 && local527 < this.anInt83) {
								local204 += this.anIntArray13[local527];
								local210 += this.anIntArray14[local527];
								local214 += this.anIntArray15[local527];
								local220 += this.anIntArray16[local527];
								local236 += this.anIntArray17[local527];
							}
							@Pc(572) int local572 = local284 - 5;
							if (local572 >= 0 && local572 < this.anInt83) {
								local204 -= this.anIntArray13[local572];
								local210 -= this.anIntArray14[local572];
								local214 -= this.anIntArray15[local572];
								local220 -= this.anIntArray16[local572];
								local236 -= this.anIntArray17[local572];
							}
							if (local284 >= 1 && local284 < this.anInt83 - 1 && (!Static4.aBoolean23 || (this.aByteArrayArrayArray1[local7][local169][local284] & 0x10) == 0 && this.method41(local7, (byte) 10, local169, local284) == Static4.anInt81)) {
								@Pc(655) int local655 = this.aByteArrayArrayArray2[local7][local169][local284] & 0xFF;
								@Pc(666) int local666 = this.aByteArrayArrayArray3[local7][local169][local284] & 0xFF;
								if (local655 > 0 || local666 > 0) {
									@Pc(679) int local679 = this.anIntArrayArrayArray1[local7][local169][local284];
									@Pc(690) int local690 = this.anIntArrayArrayArray1[local7][local169 + 1][local284];
									@Pc(703) int local703 = this.anIntArrayArrayArray1[local7][local169 + 1][local284 + 1];
									@Pc(714) int local714 = this.anIntArrayArrayArray1[local7][local169][local284 + 1];
									@Pc(721) int local721 = this.anIntArrayArray1[local169][local284];
									@Pc(730) int local730 = this.anIntArrayArray1[local169 + 1][local284];
									@Pc(741) int local741 = this.anIntArrayArray1[local169 + 1][local284 + 1];
									@Pc(750) int local750 = this.anIntArrayArray1[local169][local284 + 1];
									@Pc(752) int local752 = -1;
									@Pc(754) int local754 = -1;
									@Pc(762) int local762;
									@Pc(766) int local766;
									if (local655 > 0) {
										local762 = local204 * 256 / local220;
										local766 = local210 / local236;
										@Pc(770) int local770 = local214 / local236;
										local752 = this.method49(local762, local766, local770);
										@Pc(782) int local782 = local762 + Static4.anInt84 & 0xFF;
										local770 += Static4.anInt85;
										if (local770 < 0) {
											local770 = 0;
										} else if (local770 > 255) {
											local770 = 255;
										}
										local754 = this.method49(local782, local766, local770);
									}
									if (local7 > 0) {
										@Pc(807) boolean local807 = true;
										if (local655 == 0 && this.aByteArrayArrayArray4[local7][local169][local284] != 0) {
											local807 = false;
										}
										if (local666 > 0 && !Static13.aClass11Array1[local666 - 1].aBoolean91) {
											local807 = false;
										}
										if (local807 && local679 == local690 && local679 == local703 && local679 == local714) {
											this.anIntArrayArrayArray2[local7][local169][local284] |= 0x924;
										}
									}
									local762 = 0;
									if (local752 != -1) {
										local762 = Static15.anIntArray142[Static4.method47(local754, 96)];
									}
									if (local666 == 0) {
										arg0.method472(local7, local169, local284, 0, 0, -1, local679, local690, local703, local714, Static4.method47(local752, local721), Static4.method47(local752, local730), Static4.method47(local752, local741), Static4.method47(local752, local750), 0, 0, 0, 0, local762, 0);
									} else {
										local766 = this.aByteArrayArrayArray4[local7][local169][local284] + 1;
										@Pc(919) byte local919 = this.aByteArrayArrayArray5[local7][local169][local284];
										@Pc(925) Class11 local925 = Static13.aClass11Array1[local666 - 1];
										@Pc(928) int local928 = local925.anInt404;
										@Pc(936) int local936;
										@Pc(934) int local934;
										if (local928 >= 0) {
											local934 = Static15.method293(787, local928);
											local936 = -1;
										} else if (local925.anInt403 == 16711935) {
											local934 = 0;
											local936 = -2;
											local928 = -1;
										} else {
											local936 = this.method49(local925.anInt405, local925.anInt406, local925.anInt407);
											local934 = Static15.anIntArray142[this.method48(local925.anInt410, 96)];
										}
										arg0.method472(local7, local169, local284, local766, local919, local928, local679, local690, local703, local714, Static4.method47(local752, local721), Static4.method47(local752, local730), Static4.method47(local752, local741), Static4.method47(local752, local750), this.method48(local936, local721), this.method48(local936, local730), this.method48(local936, local741), this.method48(local936, local750), local762, local934);
									}
								}
							}
						}
					}
				}
				for (local191 = 1; local191 < this.anInt83 - 1; local191++) {
					for (local204 = 1; local204 < this.anInt82 - 1; local204++) {
						arg0.method471(local7, local204, local191, this.method41(local7, (byte) 10, local204, local191));
					}
				}
			}
			while (arg1 >= 0) {
				for (local11 = 1; local11 > 0; local11++) {
				}
			}
			if (!Static4.aBoolean24) {
				arg0.method499(-10, 64, -50, 768, -50, false);
			}
			for (local11 = 0; local11 < this.anInt82; local11++) {
				for (local27 = 0; local27 < this.anInt83; local27++) {
					if ((this.aByteArrayArrayArray1[1][local11][local27] & 0x2) == 2) {
						arg0.method469(local27, local11, (byte) -41);
					}
				}
			}
			if (!Static4.aBoolean24) {
				local27 = 1;
				@Pc(1123) int local1123 = 2;
				@Pc(1125) int local1125 = 4;
				for (@Pc(1127) int local1127 = 0; local1127 < 4; local1127++) {
					if (local1127 > 0) {
						local27 <<= 0x3;
						local1123 <<= 0x3;
						local1125 <<= 0x3;
					}
					for (@Pc(1145) int local1145 = 0; local1145 <= local1127; local1145++) {
						for (local133 = 0; local133 <= this.anInt83; local133++) {
							for (local139 = 0; local139 <= this.anInt82; local139++) {
								@Pc(1284) short local1284;
								if ((this.anIntArrayArrayArray2[local1145][local139][local133] & local27) != 0) {
									local141 = local133;
									local145 = local133;
									local169 = local1145;
									local191 = local1145;
									while (local141 > 0 && (this.anIntArrayArrayArray2[local1145][local139][local141 - 1] & local27) != 0) {
										local141--;
									}
									while (local145 < this.anInt83 && (this.anIntArrayArrayArray2[local1145][local139][local145 + 1] & local27) != 0) {
										local145++;
									}
									label337: while (local169 > 0) {
										for (local204 = local141; local204 <= local145; local204++) {
											if ((this.anIntArrayArrayArray2[local169 - 1][local139][local204] & local27) == 0) {
												break label337;
											}
										}
										local169--;
									}
									label326: while (local191 < local1127) {
										for (local204 = local141; local204 <= local145; local204++) {
											if ((this.anIntArrayArrayArray2[local191 + 1][local139][local204] & local27) == 0) {
												break label326;
											}
										}
										local191++;
									}
									local204 = (local191 + 1 - local169) * (local145 + 1 - local141);
									if (local204 >= 8) {
										local1284 = 240;
										local214 = this.anIntArrayArrayArray1[local191][local139][local141] - local1284;
										local220 = this.anIntArrayArrayArray1[local169][local139][local141];
										Static25.method470(local145 * 128 + 128, local139 * 128, -802, local220, 1, local139 * 128, local1127, local214, local141 * 128);
										for (local236 = local169; local236 <= local191; local236++) {
											for (local284 = local141; local284 <= local145; local284++) {
												this.anIntArrayArrayArray2[local236][local139][local284] &= ~local27;
											}
										}
									}
								}
								if ((this.anIntArrayArrayArray2[local1145][local139][local133] & local1123) != 0) {
									local141 = local139;
									local145 = local139;
									local169 = local1145;
									local191 = local1145;
									while (local141 > 0 && (this.anIntArrayArrayArray2[local1145][local141 - 1][local133] & local1123) != 0) {
										local141--;
									}
									while (local145 < this.anInt82 && (this.anIntArrayArrayArray2[local1145][local145 + 1][local133] & local1123) != 0) {
										local145++;
									}
									label390: while (local169 > 0) {
										for (local204 = local141; local204 <= local145; local204++) {
											if ((this.anIntArrayArrayArray2[local169 - 1][local204][local133] & local1123) == 0) {
												break label390;
											}
										}
										local169--;
									}
									label379: while (local191 < local1127) {
										for (local204 = local141; local204 <= local145; local204++) {
											if ((this.anIntArrayArrayArray2[local191 + 1][local204][local133] & local1123) == 0) {
												break label379;
											}
										}
										local191++;
									}
									local204 = (local191 + 1 - local169) * (local145 + 1 - local141);
									if (local204 >= 8) {
										local1284 = 240;
										local214 = this.anIntArrayArrayArray1[local191][local141][local133] - local1284;
										local220 = this.anIntArrayArrayArray1[local169][local141][local133];
										Static25.method470(local133 * 128, local141 * 128, -802, local220, 2, local145 * 128 + 128, local1127, local214, local133 * 128);
										for (local236 = local169; local236 <= local191; local236++) {
											for (local284 = local141; local284 <= local145; local284++) {
												this.anIntArrayArrayArray2[local236][local284][local133] &= ~local1123;
											}
										}
									}
								}
								if ((this.anIntArrayArrayArray2[local1145][local139][local133] & local1125) != 0) {
									local141 = local139;
									local145 = local139;
									local169 = local133;
									local191 = local133;
									while (local169 > 0 && (this.anIntArrayArrayArray2[local1145][local139][local169 - 1] & local1125) != 0) {
										local169--;
									}
									while (local191 < this.anInt83 && (this.anIntArrayArrayArray2[local1145][local139][local191 + 1] & local1125) != 0) {
										local191++;
									}
									label443: while (local141 > 0) {
										for (local204 = local169; local204 <= local191; local204++) {
											if ((this.anIntArrayArrayArray2[local1145][local141 - 1][local204] & local1125) == 0) {
												break label443;
											}
										}
										local141--;
									}
									label432: while (local145 < this.anInt82) {
										for (local204 = local169; local204 <= local191; local204++) {
											if ((this.anIntArrayArrayArray2[local1145][local145 + 1][local204] & local1125) == 0) {
												break label432;
											}
										}
										local145++;
									}
									if ((local145 + 1 - local141) * (local191 + 1 - local169) >= 4) {
										local204 = this.anIntArrayArrayArray1[local1145][local141][local169];
										Static25.method470(local191 * 128 + 128, local141 * 128, -802, local204, 4, local145 * 128 + 128, local1127, local204, local169 * 128);
										for (local210 = local141; local210 <= local145; local210++) {
											for (local214 = local169; local214 <= local191; local214++) {
												this.anIntArrayArrayArray2[local1145][local210][local214] &= ~local1125;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (@Pc(1760) RuntimeException local1760) {
			signlink.reporterror("31873, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local1760.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IBII)I")
	private int method41(@OriginalArg(0) int arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg1 != 10) {
				this.anInt80 = 29;
			}
			if ((this.aByteArrayArrayArray1[arg0][arg2][arg3] & 0x8) == 0) {
				return arg0 <= 0 || (this.aByteArrayArrayArray1[1][arg2][arg3] & 0x2) == 0 ? arg0 : arg0 - 1;
			} else {
				return 0;
			}
		} catch (@Pc(38) RuntimeException local38) {
			signlink.reporterror("77679, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local38.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!c", name = "e", descriptor = "(II)I")
	private int method48(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		if (arg0 == -2) {
			return 12345678;
		} else if (arg0 == -1) {
			if (arg1 < 0) {
				arg1 = 0;
			} else if (arg1 > 127) {
				arg1 = 127;
			}
			return 127 - arg1;
		} else {
			arg1 = arg1 * (arg0 & 0x7F) / 128;
			if (arg1 < 2) {
				arg1 = 2;
			} else if (arg1 > 126) {
				arg1 = 126;
			}
			return (arg0 & 0xFF80) + arg1;
		}
	}

	@OriginalMember(owner = "client!c", name = "b", descriptor = "(III)I")
	private int method49(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if (arg2 > 179) {
			arg1 /= 2;
		}
		if (arg2 > 192) {
			arg1 /= 2;
		}
		if (arg2 > 217) {
			arg1 /= 2;
		}
		if (arg2 > 243) {
			arg1 /= 2;
		}
		return (arg0 / 4 << 10) + (arg1 / 32 << 7) + arg2 / 2;
	}
}
