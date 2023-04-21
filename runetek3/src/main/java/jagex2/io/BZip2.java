package jagex2.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// LibBZip2 decompressor port
public final class BZip2 {

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "Lclient!sb;")
	private static final Context state = new Context();

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "([BI[BII)I")
	public static int read(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) byte[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		synchronized (state) {
			state.stream = arg2;
			state.next_in = arg4;
			state.decompressed = arg0;
			state.next_out = 0;
			state.avail_in = arg3;
			state.avail_out = arg1;
			state.bsLive = 0;
			state.bsBuff = 0;
			state.total_in_lo32 = 0;
			state.total_in_hi32 = 0;
			state.total_out_lo32 = 0;
			state.total_out_hi32 = 0;
			state.currBlockNo = 0;
			decompress(state);
			return arg1 - state.avail_out;
		}
	}

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "(Lclient!sb;)V")
	private static void finish(@OriginalArg(0) Context arg0) {
		@Pc(4) byte local4 = arg0.state_out_ch;
		@Pc(7) int local7 = arg0.state_out_len;
		@Pc(10) int local10 = arg0.c_nblock_used;
		@Pc(13) int local13 = arg0.k0;
		@Pc(15) int[] local15 = Context.tt;
		@Pc(18) int local18 = arg0.tPos;
		@Pc(21) byte[] local21 = arg0.decompressed;
		@Pc(24) int local24 = arg0.next_out;
		@Pc(27) int local27 = arg0.avail_out;
		@Pc(29) int local29 = local27;
		@Pc(34) int local34 = arg0.save_nblock + 1;
		label67: while (true) {
			if (local7 > 0) {
				while (true) {
					if (local27 == 0) {
						break label67;
					}
					if (local7 == 1) {
						if (local27 == 0) {
							local7 = 1;
							break label67;
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
			@Pc(64) boolean local64 = true;
			@Pc(87) byte local87;
			while (local64) {
				local64 = false;
				if (local10 == local34) {
					local7 = 0;
					break label67;
				}
				local4 = (byte) local13;
				local18 = local15[local18];
				local87 = (byte) (local18 & 0xFF);
				local18 >>= 0x8;
				local10++;
				if (local87 != local13) {
					local13 = local87;
					if (local27 == 0) {
						local7 = 1;
						break label67;
					}
					local21[local24] = local4;
					local24++;
					local27--;
					local64 = true;
				} else if (local10 == local34) {
					if (local27 == 0) {
						local7 = 1;
						break label67;
					}
					local21[local24] = local4;
					local24++;
					local27--;
					local64 = true;
				}
			}
			local7 = 2;
			local18 = local15[local18];
			local87 = (byte) (local18 & 0xFF);
			local18 >>= 0x8;
			local10++;
			if (local10 != local34) {
				if (local87 == local13) {
					local7 = 3;
					local18 = local15[local18];
					local87 = (byte) (local18 & 0xFF);
					local18 >>= 0x8;
					local10++;
					if (local10 != local34) {
						if (local87 == local13) {
							local18 = local15[local18];
							local87 = (byte) (local18 & 0xFF);
							local18 >>= 0x8;
							local10++;
							local7 = (local87 & 0xFF) + 4;
							local18 = local15[local18];
							local13 = (byte) (local18 & 0xFF);
							local18 >>= 0x8;
							local10++;
						} else {
							local13 = local87;
						}
					}
				} else {
					local13 = local87;
				}
			}
		}
		@Pc(224) int local224 = arg0.total_out_lo32;
		arg0.total_out_lo32 += local29 - local27;
		if (arg0.total_out_lo32 < local224) {
			arg0.total_out_hi32++;
		}
		arg0.state_out_ch = local4;
		arg0.state_out_len = local7;
		arg0.c_nblock_used = local10;
		arg0.k0 = local13;
		Context.tt = local15;
		arg0.tPos = local18;
		arg0.decompressed = local21;
		arg0.next_out = local24;
		arg0.avail_out = local27;
	}

	@OriginalMember(owner = "client!rb", name = "b", descriptor = "(Lclient!sb;)V")
	private static void decompress(@OriginalArg(0) Context arg0) {
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
		@Pc(41) int local41 = 0;
		@Pc(43) int[] local43 = null;
		@Pc(45) int[] local45 = null;
		@Pc(47) int[] local47 = null;
		arg0.blockSize100k = 1;
		if (Context.tt == null) {
			Context.tt = new int[arg0.blockSize100k * 100000];
		}
		@Pc(60) boolean local60 = true;
		while (true) {
			while (local60) {
				@Pc(64) byte local64 = getUnsignedChar(arg0);
				if (local64 == 23) {
					return;
				}
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				arg0.currBlockNo++;
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				local64 = getUnsignedChar(arg0);
				local64 = getBit(arg0);
				if (local64 == 0) {
					arg0.blockRandomized = false;
				} else {
					arg0.blockRandomized = true;
				}
				if (arg0.blockRandomized) {
					System.out.println("PANIC! RANDOMISED BLOCK!");
				}
				arg0.origPtr = 0;
				local64 = getUnsignedChar(arg0);
				arg0.origPtr = arg0.origPtr << 8 | local64 & 0xFF;
				local64 = getUnsignedChar(arg0);
				arg0.origPtr = arg0.origPtr << 8 | local64 & 0xFF;
				local64 = getUnsignedChar(arg0);
				arg0.origPtr = arg0.origPtr << 8 | local64 & 0xFF;
				@Pc(164) int local164;
				for (local164 = 0; local164 < 16; local164++) {
					local64 = getBit(arg0);
					if (local64 == 1) {
						arg0.inUse16[local164] = true;
					} else {
						arg0.inUse16[local164] = false;
					}
				}
				for (local164 = 0; local164 < 256; local164++) {
					arg0.inUse[local164] = false;
				}
				@Pc(212) int local212;
				for (local164 = 0; local164 < 16; local164++) {
					if (arg0.inUse16[local164]) {
						for (local212 = 0; local212 < 16; local212++) {
							local64 = getBit(arg0);
							if (local64 == 1) {
								arg0.inUse[local164 * 16 + local212] = true;
							}
						}
					}
				}
				makeMaps(arg0);
				@Pc(244) int local244 = arg0.nInUse + 2;
				@Pc(248) int local248 = getBits(3, arg0);
				@Pc(252) int local252 = getBits(15, arg0);
				for (local164 = 0; local164 < local252; local164++) {
					local212 = 0;
					while (true) {
						local64 = getBit(arg0);
						if (local64 == 0) {
							arg0.selectorMtf[local164] = (byte) local212;
							break;
						}
						local212++;
					}
				}
				@Pc(279) byte[] local279 = new byte[6];
				@Pc(281) byte local281 = 0;
				while (local281 < local248) {
					local279[local281] = local281++;
				}
				for (local164 = 0; local164 < local252; local164++) {
					local281 = arg0.selectorMtf[local164];
					@Pc(308) byte local308 = local279[local281];
					while (local281 > 0) {
						local279[local281] = local279[local281 - 1];
						local281--;
					}
					local279[0] = local308;
					arg0.selector[local164] = local308;
				}
				@Pc(340) int local340;
				for (local340 = 0; local340 < local248; local340++) {
					@Pc(346) int local346 = getBits(5, arg0);
					for (local164 = 0; local164 < local244; local164++) {
						while (true) {
							local64 = getBit(arg0);
							if (local64 == 0) {
								arg0.len[local340][local164] = (byte) local346;
								break;
							}
							local64 = getBit(arg0);
							if (local64 == 0) {
								local346++;
							} else {
								local346--;
							}
						}
					}
				}
				for (local340 = 0; local340 < local248; local340++) {
					@Pc(388) byte local388 = 32;
					@Pc(390) byte local390 = 0;
					for (local164 = 0; local164 < local244; local164++) {
						if (arg0.len[local340][local164] > local390) {
							local390 = arg0.len[local340][local164];
						}
						if (arg0.len[local340][local164] < local388) {
							local388 = arg0.len[local340][local164];
						}
					}
					createDecodeTables(arg0.limit[local340], arg0.base[local340], arg0.perm[local340], arg0.len[local340], local388, local390, local244);
					arg0.minLens[local340] = local388;
				}
				@Pc(462) int local462 = arg0.nInUse + 1;
				@Pc(467) int local467 = arg0.blockSize100k * 100000;
				@Pc(469) int local469 = -1;
				@Pc(471) byte local471 = 0;
				for (local164 = 0; local164 <= 255; local164++) {
					arg0.unzftab[local164] = 0;
				}
				@Pc(486) int local486 = 4095;
				for (@Pc(488) int local488 = 15; local488 >= 0; local488--) {
					for (@Pc(492) int local492 = 15; local492 >= 0; local492--) {
						arg0.mtfa[local486] = (byte) (local488 * 16 + local492);
						local486--;
					}
					arg0.mtfbase[local488] = local486 + 1;
				}
				@Pc(520) int local520 = 0;
				@Pc(530) byte local530;
				if (local471 == 0) {
					local469++;
					local471 = 50;
					local530 = arg0.selector[local469];
					local41 = arg0.minLens[local530];
					local43 = arg0.limit[local530];
					local47 = arg0.perm[local530];
					local45 = arg0.base[local530];
				}
				@Pc(551) int local551 = local471 - 1;
				@Pc(553) int local553 = local41;
				@Pc(557) int local557;
				@Pc(566) byte local566;
				for (local557 = getBits(local41, arg0); local557 > local43[local553]; local557 = local557 << 1 | local566) {
					local553++;
					local566 = getBit(arg0);
				}
				@Pc(582) int local582 = local47[local557 - local45[local553]];
				while (true) {
					while (local582 != local462) {
						if (local582 == 0 || local582 == 1) {
							@Pc(592) int local592 = -1;
							@Pc(594) int local594 = 1;
							do {
								if (local582 == 0) {
									local592 += local594;
								} else if (local582 == 1) {
									local592 += local594 * 2;
								}
								local594 *= 2;
								if (local551 == 0) {
									local469++;
									local551 = 50;
									local530 = arg0.selector[local469];
									local41 = arg0.minLens[local530];
									local43 = arg0.limit[local530];
									local47 = arg0.perm[local530];
									local45 = arg0.base[local530];
								}
								local551--;
								local553 = local41;
								for (local557 = getBits(local41, arg0); local557 > local43[local553]; local557 = local557 << 1 | local566) {
									local553++;
									local566 = getBit(arg0);
								}
								local582 = local47[local557 - local45[local553]];
							} while (local582 == 0 || local582 == 1);
							local592++;
							local64 = arg0.seqToUnseq[arg0.mtfa[arg0.mtfbase[0]] & 0xFF];
							arg0.unzftab[local64 & 0xFF] += local592;
							while (local592 > 0) {
								Context.tt[local520] = local64 & 0xFF;
								local520++;
								local592--;
							}
						} else {
							@Pc(724) int local724 = local582 - 1;
							@Pc(732) int local732;
							if (local724 < 16) {
								local732 = arg0.mtfbase[0];
								local64 = arg0.mtfa[local732 + local724];
								while (local724 > 3) {
									@Pc(745) int local745 = local732 + local724;
									arg0.mtfa[local745] = arg0.mtfa[local745 - 1];
									arg0.mtfa[local745 - 1] = arg0.mtfa[local745 - 2];
									arg0.mtfa[local745 - 2] = arg0.mtfa[local745 - 3];
									arg0.mtfa[local745 - 3] = arg0.mtfa[local745 - 4];
									local724 -= 4;
								}
								while (local724 > 0) {
									arg0.mtfa[local732 + local724] = arg0.mtfa[local732 + local724 - 1];
									local724--;
								}
								arg0.mtfa[local732] = local64;
							} else {
								@Pc(825) int local825 = local724 / 16;
								@Pc(829) int local829 = local724 % 16;
								local732 = arg0.mtfbase[local825] + local829;
								local64 = arg0.mtfa[local732];
								while (local732 > arg0.mtfbase[local825]) {
									arg0.mtfa[local732] = arg0.mtfa[local732 - 1];
									local732--;
								}
								@Pc(865) int local865 = arg0.mtfbase[local825]++;
								while (local825 > 0) {
									local865 = arg0.mtfbase[local825]--;
									arg0.mtfa[arg0.mtfbase[local825]] = arg0.mtfa[arg0.mtfbase[local825 - 1] + 16 - 1];
									local825--;
								}
								local865 = arg0.mtfbase[0]--;
								arg0.mtfa[arg0.mtfbase[0]] = local64;
								if (arg0.mtfbase[0] == 0) {
									@Pc(924) int local924 = 4095;
									for (@Pc(926) int local926 = 15; local926 >= 0; local926--) {
										for (@Pc(930) int local930 = 15; local930 >= 0; local930--) {
											arg0.mtfa[local924] = arg0.mtfa[arg0.mtfbase[local926] + local930];
											local924--;
										}
										arg0.mtfbase[local926] = local924 + 1;
									}
								}
							}
							arg0.unzftab[arg0.seqToUnseq[local64 & 0xFF] & 0xFF]++;
							Context.tt[local520] = arg0.seqToUnseq[local64 & 0xFF] & 0xFF;
							local520++;
							if (local551 == 0) {
								local469++;
								local551 = 50;
								local530 = arg0.selector[local469];
								local41 = arg0.minLens[local530];
								local43 = arg0.limit[local530];
								local47 = arg0.perm[local530];
								local45 = arg0.base[local530];
							}
							local551--;
							local553 = local41;
							for (local557 = getBits(local41, arg0); local557 > local43[local553]; local557 = local557 << 1 | local566) {
								local553++;
								local566 = getBit(arg0);
							}
							local582 = local47[local557 - local45[local553]];
						}
					}
					arg0.state_out_len = 0;
					arg0.state_out_ch = 0;
					arg0.cftab[0] = 0;
					for (local164 = 1; local164 <= 256; local164++) {
						arg0.cftab[local164] = arg0.unzftab[local164 - 1];
					}
					for (local164 = 1; local164 <= 256; local164++) {
						arg0.cftab[local164] += arg0.cftab[local164 - 1];
					}
					for (local164 = 0; local164 < local520; local164++) {
						local64 = (byte) (Context.tt[local164] & 0xFF);
						Context.tt[arg0.cftab[local64 & 0xFF]] |= local164 << 8;
						arg0.cftab[local64 & 0xFF]++;
					}
					arg0.tPos = Context.tt[arg0.origPtr] >> 8;
					arg0.c_nblock_used = 0;
					arg0.tPos = Context.tt[arg0.tPos];
					arg0.k0 = (byte) (arg0.tPos & 0xFF);
					arg0.tPos >>= 0x8;
					arg0.c_nblock_used++;
					arg0.save_nblock = local520;
					finish(arg0);
					if (arg0.c_nblock_used == arg0.save_nblock + 1 && arg0.state_out_len == 0) {
						local60 = true;
						break;
					}
					local60 = false;
					break;
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "client!rb", name = "c", descriptor = "(Lclient!sb;)B")
	private static byte getUnsignedChar(@OriginalArg(0) Context arg0) {
		return (byte) getBits(8, arg0);
	}

	@OriginalMember(owner = "client!rb", name = "d", descriptor = "(Lclient!sb;)B")
	private static byte getBit(@OriginalArg(0) Context arg0) {
		return (byte) getBits(1, arg0);
	}

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "(ILclient!sb;)I")
	private static int getBits(@OriginalArg(0) int arg0, @OriginalArg(1) Context arg1) {
		while (arg1.bsLive < arg0) {
			arg1.bsBuff = arg1.bsBuff << 8 | arg1.stream[arg1.next_in] & 0xFF;
			arg1.bsLive += 8;
			arg1.next_in++;
			arg1.avail_in--;
			arg1.total_in_lo32++;
			if (arg1.total_in_lo32 == 0) {
				arg1.total_in_hi32++;
			}
		}
		@Pc(17) int local17 = arg1.bsBuff >> arg1.bsLive - arg0 & (0x1 << arg0) - 1;
		arg1.bsLive -= arg0;
		return local17;
	}

	@OriginalMember(owner = "client!rb", name = "e", descriptor = "(Lclient!sb;)V")
	private static void makeMaps(@OriginalArg(0) Context arg0) {
		arg0.nInUse = 0;
		for (@Pc(4) int local4 = 0; local4 < 256; local4++) {
			if (arg0.inUse[local4]) {
				arg0.seqToUnseq[arg0.nInUse] = (byte) local4;
				arg0.nInUse++;
			}
		}
	}

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "([I[I[I[BIII)V")
	private static void createDecodeTables(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) byte[] arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
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

	@OriginalClass("client!sb")
	public static final class Context {

		@OriginalMember(owner = "client!sb", name = "a", descriptor = "I")
		private final int MTFA_SIZE = 4096;

		@OriginalMember(owner = "client!sb", name = "b", descriptor = "I")
		private final int MTFL_SIZE = 16;

		@OriginalMember(owner = "client!sb", name = "c", descriptor = "I")
		private final int BZ_MAX_ALPHA_SIZE = 258;

		@OriginalMember(owner = "client!sb", name = "d", descriptor = "I")
		private final int BZ_MAX_CODE_LEN = 23;

		@OriginalMember(owner = "client!sb", name = "e", descriptor = "I")
		private final int anInt732 = 1;

		@OriginalMember(owner = "client!sb", name = "f", descriptor = "I")
		private final int BZ_N_GROUPS = 6;

		@OriginalMember(owner = "client!sb", name = "g", descriptor = "I")
		private final int BZ_G_SIZE = 50;

		@OriginalMember(owner = "client!sb", name = "h", descriptor = "I")
		private final int anInt735 = 4;

		@OriginalMember(owner = "client!sb", name = "i", descriptor = "I")
		private final int BZ_MAX_SELECTORS = 18002;

		@OriginalMember(owner = "client!sb", name = "j", descriptor = "[B")
		public byte[] stream;

		@OriginalMember(owner = "client!sb", name = "k", descriptor = "I")
		public int next_in;

		@OriginalMember(owner = "client!sb", name = "l", descriptor = "I")
		public int avail_in;

		@OriginalMember(owner = "client!sb", name = "m", descriptor = "I")
		public int total_in_lo32;

		@OriginalMember(owner = "client!sb", name = "n", descriptor = "I")
		public int total_in_hi32;

		@OriginalMember(owner = "client!sb", name = "o", descriptor = "[B")
		public byte[] decompressed;

		@OriginalMember(owner = "client!sb", name = "p", descriptor = "I")
		public int next_out;

		@OriginalMember(owner = "client!sb", name = "q", descriptor = "I")
		public int avail_out;

		@OriginalMember(owner = "client!sb", name = "r", descriptor = "I")
		public int total_out_lo32;

		@OriginalMember(owner = "client!sb", name = "s", descriptor = "I")
		public int total_out_hi32;

		@OriginalMember(owner = "client!sb", name = "t", descriptor = "B")
		public byte state_out_ch;

		@OriginalMember(owner = "client!sb", name = "u", descriptor = "I")
		public int state_out_len;

		@OriginalMember(owner = "client!sb", name = "v", descriptor = "Z")
		public boolean blockRandomized;

		@OriginalMember(owner = "client!sb", name = "w", descriptor = "I")
		public int bsBuff;

		@OriginalMember(owner = "client!sb", name = "x", descriptor = "I")
		public int bsLive;

		@OriginalMember(owner = "client!sb", name = "y", descriptor = "I")
		public int blockSize100k;

		@OriginalMember(owner = "client!sb", name = "z", descriptor = "I")
		public int currBlockNo;

		@OriginalMember(owner = "client!sb", name = "A", descriptor = "I")
		public int origPtr;

		@OriginalMember(owner = "client!sb", name = "B", descriptor = "I")
		public int tPos;

		@OriginalMember(owner = "client!sb", name = "C", descriptor = "I")
		public int k0;

		@OriginalMember(owner = "client!sb", name = "D", descriptor = "[I")
		public final int[] unzftab = new int[256];

		@OriginalMember(owner = "client!sb", name = "E", descriptor = "I")
		public int c_nblock_used;

		@OriginalMember(owner = "client!sb", name = "F", descriptor = "[I")
		public final int[] cftab = new int[257];

		@OriginalMember(owner = "client!sb", name = "G", descriptor = "[I")
		private final int[] cftabCopy = new int[257];

		@OriginalMember(owner = "client!sb", name = "H", descriptor = "[I")
		public static int[] tt;

		@OriginalMember(owner = "client!sb", name = "I", descriptor = "I")
		public int nInUse;

		@OriginalMember(owner = "client!sb", name = "J", descriptor = "[Z")
		public final boolean[] inUse = new boolean[256];

		@OriginalMember(owner = "client!sb", name = "K", descriptor = "[Z")
		public final boolean[] inUse16 = new boolean[16];

		@OriginalMember(owner = "client!sb", name = "L", descriptor = "[B")
		public final byte[] seqToUnseq = new byte[256];

		@OriginalMember(owner = "client!sb", name = "M", descriptor = "[B")
		public final byte[] mtfa = new byte[4096];

		@OriginalMember(owner = "client!sb", name = "N", descriptor = "[I")
		public final int[] mtfbase = new int[16];

		@OriginalMember(owner = "client!sb", name = "O", descriptor = "[B")
		public final byte[] selector = new byte[18002];

		@OriginalMember(owner = "client!sb", name = "P", descriptor = "[B")
		public final byte[] selectorMtf = new byte[18002];

		@OriginalMember(owner = "client!sb", name = "Q", descriptor = "[[B")
		public final byte[][] len = new byte[6][258];

		@OriginalMember(owner = "client!sb", name = "R", descriptor = "[[I")
		public final int[][] limit = new int[6][258];

		@OriginalMember(owner = "client!sb", name = "S", descriptor = "[[I")
		public final int[][] base = new int[6][258];

		@OriginalMember(owner = "client!sb", name = "T", descriptor = "[[I")
		public final int[][] perm = new int[6][258];

		@OriginalMember(owner = "client!sb", name = "U", descriptor = "[I")
		public final int[] minLens = new int[6];

		@OriginalMember(owner = "client!sb", name = "V", descriptor = "I")
		public int save_nblock;
	}

}
