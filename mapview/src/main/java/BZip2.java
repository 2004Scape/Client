import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!m")
public final class BZip2 {

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "Lmapview!n;")
	private static BZip2State aClass5_1 = new BZip2State();

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "(Lmapview!n;)B")
	private static byte method89(@OriginalArg(0) BZip2State arg0) {
		return (byte) method96(8, arg0);
	}

	@OriginalMember(owner = "mapview!m", name = "b", descriptor = "(Lmapview!n;)V")
	private static void method90(@OriginalArg(0) BZip2State arg0) {
		@Pc(3) boolean local3 = false;
		@Pc(5) boolean local5 = false;
		@Pc(7) boolean local7 = false;
		@Pc(9) boolean local9 = false;
		@Pc(11) boolean local11 = false;
		@Pc(13) boolean local13 = false;
		@Pc(15) boolean local15 = false;
		@Pc(17) boolean local17 = false;
		@Pc(19) boolean local19 = false;
		@Pc(21) boolean local21 = false;
		@Pc(23) boolean local23 = false;
		@Pc(25) boolean local25 = false;
		@Pc(27) boolean local27 = false;
		@Pc(29) boolean local29 = false;
		@Pc(31) boolean local31 = false;
		@Pc(33) boolean local33 = false;
		@Pc(35) boolean local35 = false;
		@Pc(37) boolean local37 = false;
		@Pc(39) boolean local39 = false;
		@Pc(41) boolean local41 = false;
		@Pc(43) int local43 = 0;
		@Pc(45) int[] local45 = null;
		@Pc(47) int[] local47 = null;
		@Pc(49) int[] local49 = null;
		arg0.anInt177 = 1;
		if (BZip2State.anIntArray35 == null) {
			BZip2State.anIntArray35 = new int[arg0.anInt177 * 100000];
		}
		@Pc(62) boolean local62 = true;
		while (true) {
			while (local62) {
				@Pc(66) byte local66 = method89(arg0);
				if (local66 == 23) {
					return;
				}
				local66 = method89(arg0);
				local66 = method89(arg0);
				local66 = method89(arg0);
				local66 = method89(arg0);
				local66 = method89(arg0);
				arg0.anInt178++;
				local66 = method89(arg0);
				local66 = method89(arg0);
				local66 = method89(arg0);
				local66 = method89(arg0);
				local66 = method93(arg0);
				if (local66 == 0) {
					arg0.aBoolean17 = false;
				} else {
					arg0.aBoolean17 = true;
				}
				if (arg0.aBoolean17) {
					System.out.println("PANIC! RANDOMISED BLOCK!");
				}
				arg0.anInt179 = 0;
				local66 = method89(arg0);
				arg0.anInt179 = arg0.anInt179 << 8 | local66 & 0xFF;
				local66 = method89(arg0);
				arg0.anInt179 = arg0.anInt179 << 8 | local66 & 0xFF;
				local66 = method89(arg0);
				arg0.anInt179 = arg0.anInt179 << 8 | local66 & 0xFF;
				@Pc(166) int local166;
				for (local166 = 0; local166 < 16; local166++) {
					local66 = method93(arg0);
					if (local66 == 1) {
						arg0.aBooleanArray2[local166] = true;
					} else {
						arg0.aBooleanArray2[local166] = false;
					}
				}
				for (local166 = 0; local166 < 256; local166++) {
					arg0.aBooleanArray1[local166] = false;
				}
				@Pc(214) int local214;
				for (local166 = 0; local166 < 16; local166++) {
					if (arg0.aBooleanArray2[local166]) {
						for (local214 = 0; local214 < 16; local214++) {
							local66 = method93(arg0);
							if (local66 == 1) {
								arg0.aBooleanArray1[local166 * 16 + local214] = true;
							}
						}
					}
				}
				method92(arg0);
				@Pc(246) int local246 = arg0.anInt183 + 2;
				@Pc(250) int local250 = method96(3, arg0);
				@Pc(254) int local254 = method96(15, arg0);
				for (local166 = 0; local166 < local254; local166++) {
					local214 = 0;
					while (true) {
						local66 = method93(arg0);
						if (local66 == 0) {
							arg0.aByteArray9[local166] = (byte) local214;
							break;
						}
						local214++;
					}
				}
				@Pc(284) byte[] local284 = new byte[6];
				@Pc(286) byte local286 = 0;
				while (local286 < local250) {
					local284[local286] = local286++;
				}
				for (local166 = 0; local166 < local254; local166++) {
					local286 = arg0.aByteArray9[local166];
					@Pc(313) byte local313 = local284[local286];
					while (local286 > 0) {
						local284[local286] = local284[local286 - 1];
						local286 += -1;
					}
					local284[0] = local313;
					arg0.aByteArray8[local166] = local313;
				}
				@Pc(345) int local345;
				for (local345 = 0; local345 < local250; local345++) {
					@Pc(351) int local351 = method96(5, arg0);
					for (local166 = 0; local166 < local246; local166++) {
						while (true) {
							local66 = method93(arg0);
							if (local66 == 0) {
								arg0.aByteArrayArray6[local345][local166] = (byte) local351;
								break;
							}
							local66 = method93(arg0);
							if (local66 == 0) {
								local351++;
							} else {
								local351--;
							}
						}
					}
				}
				for (local345 = 0; local345 < local250; local345++) {
					@Pc(396) byte local396 = 32;
					@Pc(398) byte local398 = 0;
					for (local166 = 0; local166 < local246; local166++) {
						if (arg0.aByteArrayArray6[local345][local166] > local398) {
							local398 = arg0.aByteArrayArray6[local345][local166];
						}
						if (arg0.aByteArrayArray6[local345][local166] < local396) {
							local396 = arg0.aByteArrayArray6[local345][local166];
						}
					}
					method94(arg0.anIntArrayArray3[local345], arg0.anIntArrayArray4[local345], arg0.anIntArrayArray5[local345], arg0.aByteArrayArray6[local345], local396, local398, local246);
					arg0.anIntArray37[local345] = local396;
				}
				@Pc(470) int local470 = arg0.anInt183 + 1;
				@Pc(475) int local475 = arg0.anInt177 * 100000;
				@Pc(477) int local477 = -1;
				@Pc(479) byte local479 = 0;
				for (local166 = 0; local166 <= 255; local166++) {
					arg0.anIntArray32[local166] = 0;
				}
				@Pc(494) int local494 = 4095;
				@Pc(496) int local496;
				@Pc(500) int local500;
				for (local496 = 15; local496 >= 0; local496--) {
					for (local500 = 15; local500 >= 0; local500--) {
						arg0.aByteArray7[local494] = (byte) (local496 * 16 + local500);
						local494--;
					}
					arg0.anIntArray36[local496] = local494 + 1;
				}
				@Pc(528) int local528 = 0;
				@Pc(538) byte local538;
				if (local479 == 0) {
					local477++;
					local479 = 50;
					local538 = arg0.aByteArray8[local477];
					local43 = arg0.anIntArray37[local538];
					local45 = arg0.anIntArrayArray3[local538];
					local49 = arg0.anIntArrayArray5[local538];
					local47 = arg0.anIntArrayArray4[local538];
				}
				@Pc(559) int local559 = local479 - 1;
				@Pc(561) int local561 = local43;
				@Pc(565) int local565;
				@Pc(577) byte local577;
				for (local565 = method96(local43, arg0); local565 > local45[local561]; local565 = local565 << 1 | local577) {
					local561++;
					local577 = method93(arg0);
				}
				@Pc(593) int local593 = local49[local565 - local47[local561]];
				while (true) {
					while (local593 != local470) {
						if (local593 == 0 || local593 == 1) {
							@Pc(606) int local606 = -1;
							@Pc(608) int local608 = 1;
							do {
								if (local593 == 0) {
									local606 += local608;
								} else if (local593 == 1) {
									local606 += local608 * 2;
								}
								local608 *= 2;
								if (local559 == 0) {
									local477++;
									local559 = 50;
									local538 = arg0.aByteArray8[local477];
									local43 = arg0.anIntArray37[local538];
									local45 = arg0.anIntArrayArray3[local538];
									local49 = arg0.anIntArrayArray5[local538];
									local47 = arg0.anIntArrayArray4[local538];
								}
								local559--;
								local561 = local43;
								for (local565 = method96(local43, arg0); local565 > local45[local561]; local565 = local565 << 1 | local577) {
									local561++;
									local577 = method93(arg0);
								}
								local593 = local49[local565 - local47[local561]];
							} while (local593 == 0 || local593 == 1);
							local606++;
							local66 = arg0.aByteArray6[arg0.aByteArray7[arg0.anIntArray36[0]] & 0xFF];
							arg0.anIntArray32[local66 & 0xFF] += local606;
							while (local606 > 0) {
								BZip2State.anIntArray35[local528] = local66 & 0xFF;
								local528++;
								local606--;
							}
						} else {
							@Pc(743) int local743 = local593 - 1;
							@Pc(751) int local751;
							if (local743 < 16) {
								local751 = arg0.anIntArray36[0];
								local66 = arg0.aByteArray7[local751 + local743];
								while (local743 > 3) {
									@Pc(764) int local764 = local751 + local743;
									arg0.aByteArray7[local764] = arg0.aByteArray7[local764 - 1];
									arg0.aByteArray7[local764 - 1] = arg0.aByteArray7[local764 - 2];
									arg0.aByteArray7[local764 - 2] = arg0.aByteArray7[local764 - 3];
									arg0.aByteArray7[local764 - 3] = arg0.aByteArray7[local764 - 4];
									local743 -= 4;
								}
								while (local743 > 0) {
									arg0.aByteArray7[local751 + local743] = arg0.aByteArray7[local751 + local743 - 1];
									local743--;
								}
								arg0.aByteArray7[local751] = local66;
							} else {
								@Pc(844) int local844 = local743 / 16;
								@Pc(848) int local848 = local743 % 16;
								local751 = arg0.anIntArray36[local844] + local848;
								local66 = arg0.aByteArray7[local751];
								while (local751 > arg0.anIntArray36[local844]) {
									arg0.aByteArray7[local751] = arg0.aByteArray7[local751 - 1];
									local751--;
								}
								@Pc(884) int local884 = arg0.anIntArray36[local844]++;
								while (local844 > 0) {
									arg0.anIntArray36[local844] += -1;
									arg0.aByteArray7[arg0.anIntArray36[local844]] = arg0.aByteArray7[arg0.anIntArray36[local844 - 1] + 16 - 1];
									local844--;
								}
								arg0.anIntArray36[0] += -1;
								arg0.aByteArray7[arg0.anIntArray36[0]] = local66;
								if (arg0.anIntArray36[0] == 0) {
									local494 = 4095;
									for (local496 = 15; local496 >= 0; local496--) {
										for (local500 = 15; local500 >= 0; local500--) {
											arg0.aByteArray7[local494] = arg0.aByteArray7[arg0.anIntArray36[local496] + local500];
											local494--;
										}
										arg0.anIntArray36[local496] = local494 + 1;
									}
								}
							}
							arg0.anIntArray32[arg0.aByteArray6[local66 & 0xFF] & 0xFF]++;
							BZip2State.anIntArray35[local528] = arg0.aByteArray6[local66 & 0xFF] & 0xFF;
							local528++;
							if (local559 == 0) {
								local477++;
								local559 = 50;
								local538 = arg0.aByteArray8[local477];
								local43 = arg0.anIntArray37[local538];
								local45 = arg0.anIntArrayArray3[local538];
								local49 = arg0.anIntArrayArray5[local538];
								local47 = arg0.anIntArrayArray4[local538];
							}
							local559--;
							local561 = local43;
							for (local565 = method96(local43, arg0); local565 > local45[local561]; local565 = local565 << 1 | local577) {
								local561++;
								local577 = method93(arg0);
							}
							local593 = local49[local565 - local47[local561]];
						}
					}
					arg0.anInt174 = 0;
					arg0.aByte1 = 0;
					arg0.anIntArray33[0] = 0;
					for (local166 = 1; local166 <= 256; local166++) {
						arg0.anIntArray33[local166] = arg0.anIntArray32[local166 - 1];
					}
					for (local166 = 1; local166 <= 256; local166++) {
						arg0.anIntArray33[local166] += arg0.anIntArray33[local166 - 1];
					}
					for (local166 = 0; local166 < local528; local166++) {
						local66 = (byte) (BZip2State.anIntArray35[local166] & 0xFF);
						BZip2State.anIntArray35[arg0.anIntArray33[local66 & 0xFF]] |= local166 << 8;
						arg0.anIntArray33[local66 & 0xFF]++;
					}
					arg0.anInt180 = BZip2State.anIntArray35[arg0.anInt179] >> 8;
					arg0.anInt182 = 0;
					arg0.anInt180 = BZip2State.anIntArray35[arg0.anInt180];
					arg0.anInt181 = (byte) (arg0.anInt180 & 0xFF);
					arg0.anInt180 >>= 0x8;
					arg0.anInt182++;
					arg0.anInt184 = local528;
					method91(arg0);
					if (arg0.anInt182 == arg0.anInt184 + 1 && arg0.anInt174 == 0) {
						local62 = true;
						break;
					}
					local62 = false;
					break;
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!m", name = "c", descriptor = "(Lmapview!n;)V")
	private static void method91(@OriginalArg(0) BZip2State arg0) {
		@Pc(4) byte local4 = arg0.aByte1;
		@Pc(7) int local7 = arg0.anInt174;
		@Pc(10) int local10 = arg0.anInt182;
		@Pc(13) int local13 = arg0.anInt181;
		@Pc(15) int[] local15 = BZip2State.anIntArray35;
		@Pc(18) int local18 = arg0.anInt180;
		@Pc(21) byte[] local21 = arg0.aByteArray5;
		@Pc(24) int local24 = arg0.anInt170;
		@Pc(27) int local27 = arg0.anInt171;
		@Pc(29) int local29 = local27;
		@Pc(34) int local34 = arg0.anInt184 + 1;
		label73: while (true) {
			if (local7 > 0) {
				while (true) {
					if (local27 == 0) {
						break label73;
					}
					if (local7 == 1) {
						if (local27 == 0) {
							local7 = 1;
							break label73;
						}
						local21[local24] = local4;
						local24++;
						local27--;
						break;
					}
					local21[local24] = local4;
					local7--;
					local24++;
					local27--;
				}
			}
			@Pc(70) boolean local70 = true;
			@Pc(93) byte local93;
			while (local70) {
				local70 = false;
				if (local10 == local34) {
					local7 = 0;
					break label73;
				}
				local4 = (byte) local13;
				local18 = local15[local18];
				local93 = (byte) (local18 & 0xFF);
				local18 >>= 0x8;
				local10++;
				if (local93 != local13) {
					local13 = local93;
					if (local27 == 0) {
						local7 = 1;
						break label73;
					}
					local21[local24] = local4;
					local24++;
					local27--;
					local70 = true;
				} else if (local10 == local34) {
					if (local27 == 0) {
						local7 = 1;
						break label73;
					}
					local21[local24] = local4;
					local24++;
					local27--;
					local70 = true;
				}
			}
			local7 = 2;
			local18 = local15[local18];
			local93 = (byte) (local18 & 0xFF);
			local18 >>= 0x8;
			local10++;
			if (local10 != local34) {
				if (local93 == local13) {
					local7 = 3;
					local18 = local15[local18];
					local93 = (byte) (local18 & 0xFF);
					local18 >>= 0x8;
					local10++;
					if (local10 != local34) {
						if (local93 == local13) {
							local18 = local15[local18];
							local93 = (byte) (local18 & 0xFF);
							local18 >>= 0x8;
							local10++;
							local7 = (local93 & 0xFF) + 4;
							local18 = local15[local18];
							local13 = (byte) (local18 & 0xFF);
							local18 >>= 0x8;
							local10++;
						} else {
							local13 = local93;
						}
					}
				} else {
					local13 = local93;
				}
			}
		}
		@Pc(232) int local232 = arg0.anInt172;
		arg0.anInt172 += local29 - local27;
		if (arg0.anInt172 < local232) {
			arg0.anInt173++;
		}
		arg0.aByte1 = local4;
		arg0.anInt174 = local7;
		arg0.anInt182 = local10;
		arg0.anInt181 = local13;
		BZip2State.anIntArray35 = local15;
		arg0.anInt180 = local18;
		arg0.aByteArray5 = local21;
		arg0.anInt170 = local24;
		arg0.anInt171 = local27;
	}

	@OriginalMember(owner = "mapview!m", name = "d", descriptor = "(Lmapview!n;)V")
	private static void method92(@OriginalArg(0) BZip2State arg0) {
		arg0.anInt183 = 0;
		for (@Pc(4) int local4 = 0; local4 < 256; local4++) {
			if (arg0.aBooleanArray1[local4]) {
				arg0.aByteArray6[arg0.anInt183] = (byte) local4;
				arg0.anInt183++;
			}
		}
	}

	@OriginalMember(owner = "mapview!m", name = "e", descriptor = "(Lmapview!n;)B")
	private static byte method93(@OriginalArg(0) BZip2State arg0) {
		return (byte) method96(1, arg0);
	}

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "([I[I[I[BIII)V")
	private static void method94(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) byte[] arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		@Pc(3) int local3 = 0;
		@Pc(5) int local5;
		for (local5 = arg4; local5 <= arg5; local5++) {
			for (@Pc(9) int local9 = 0; local9 < arg6; local9++) {
				if (arg3[local9] == local5) {
					arg2[local3] = local9;
					local3++;
				}
			}
		}
		for (local5 = 0; local5 < 23; local5++) {
			arg1[local5] = 0;
		}
		for (local5 = 0; local5 < arg6; local5++) {
			arg1[arg3[local5] + 1]++;
		}
		for (local5 = 1; local5 < 23; local5++) {
			arg1[local5] += arg1[local5 - 1];
		}
		for (local5 = 0; local5 < 23; local5++) {
			arg0[local5] = 0;
		}
		@Pc(93) int local93 = 0;
		for (local5 = arg4; local5 <= arg5; local5++) {
			local93 += arg1[local5 + 1] - arg1[local5];
			arg0[local5] = local93 - 1;
			local93 <<= 0x1;
		}
		for (local5 = arg4 + 1; local5 <= arg5; local5++) {
			arg1[local5] = (arg0[local5 - 1] + 1 << 1) - arg1[local5];
		}
	}

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "([BI[BII)I")
	public static int method95(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) byte[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(4) BZip2State local4 = aClass5_1;
		synchronized (aClass5_1) {
			aClass5_1.aByteArray4 = arg2;
			aClass5_1.anInt166 = arg4;
			aClass5_1.aByteArray5 = arg0;
			aClass5_1.anInt170 = 0;
			aClass5_1.anInt167 = arg3;
			aClass5_1.anInt171 = arg1;
			aClass5_1.anInt176 = 0;
			aClass5_1.anInt175 = 0;
			aClass5_1.anInt168 = 0;
			aClass5_1.anInt169 = 0;
			aClass5_1.anInt172 = 0;
			aClass5_1.anInt173 = 0;
			aClass5_1.anInt178 = 0;
			method90(aClass5_1);
			return arg1 - aClass5_1.anInt171;
		}
	}

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "(ILmapview!n;)I")
	private static int method96(@OriginalArg(0) int arg0, @OriginalArg(1) BZip2State arg1) {
		while (arg1.anInt176 < arg0) {
			arg1.anInt175 = arg1.anInt175 << 8 | arg1.aByteArray4[arg1.anInt166] & 0xFF;
			arg1.anInt176 += 8;
			arg1.anInt166++;
			arg1.anInt167 += -1;
			arg1.anInt168++;
			if (arg1.anInt168 == 0) {
				arg1.anInt169++;
			}
		}
		@Pc(21) int local21 = arg1.anInt175 >> arg1.anInt176 - arg0 & (0x1 << arg0) - 1;
		arg1.anInt176 -= arg0;
		return local21;
	}
}
