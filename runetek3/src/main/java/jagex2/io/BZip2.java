package jagex2.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name and packaging confirmed 100% in rs2/mapview applet strings
@OriginalClass("client!rb")
public class BZip2 {

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "Lclient!sb;")
	private static final BZip2State state = new BZip2State();

	@OriginalMember(owner = "client!rb", name = "a", descriptor = "([BI[BII)I")
	public static int read(@OriginalArg(0) byte[] decompressed, @OriginalArg(1) int length, @OriginalArg(2) byte[] stream, @OriginalArg(3) int avail_in, @OriginalArg(4) int next_in) {
		synchronized (state) {
			state.stream = stream;
			state.next_in = next_in;
			state.decompressed = decompressed;
			state.next_out = 0;
			state.avail_in = avail_in;
			state.avail_out = length;
			state.bsLive = 0;
			state.bsBuff = 0;
			state.total_in_lo32 = 0;
			state.total_in_hi32 = 0;
			state.total_out_lo32 = 0;
			state.total_out_hi32 = 0;
			state.currBlockNo = 0;
			decompress(state);
			return length - state.avail_out;
		}
	}

	// unRLE_obuf_to_output_FAST
	@OriginalMember(owner = "client!rb", name = "a", descriptor = "(Lclient!sb;)V")
	private static void finish(@OriginalArg(0) BZip2State s) {
		@Pc(4) byte c_state_out_ch = s.state_out_ch;
		@Pc(7) int c_state_out_len = s.state_out_len;
		@Pc(10) int c_nblock_used = s.c_nblock_used;
		@Pc(13) int c_k0 = s.k0;
		@Pc(15) int[] c_tt = BZip2State.tt;
		@Pc(18) int c_tPos = s.tPos;
		@Pc(21) byte[] cs_decompressed = s.decompressed;
		@Pc(24) int cs_next_out = s.next_out;
		@Pc(27) int cs_avail_out = s.avail_out;
		@Pc(29) int avail_out_INIT = cs_avail_out;
		@Pc(34) int s_save_nblockPP = s.save_nblock + 1;

		label67:
		while (true) {
			if (c_state_out_len > 0) {
				while (true) {
					if (cs_avail_out == 0) {
						break label67;
					}

					if (c_state_out_len == 1) {
						if (cs_avail_out == 0) {
							c_state_out_len = 1;
							break label67;
						}

						cs_decompressed[cs_next_out] = c_state_out_ch;
						cs_next_out++;
						cs_avail_out--;
						break;
					}

					cs_decompressed[cs_next_out] = c_state_out_ch;
					c_state_out_len--;
					cs_next_out++;
					cs_avail_out--;
				}
			}

			@Pc(64) boolean next = true;
			@Pc(87) byte k1;
			while (next) {
				next = false;
				if (c_nblock_used == s_save_nblockPP) {
					c_state_out_len = 0;
					break label67;
				}

				// macro: BZ_GET_FAST_C
				c_state_out_ch = (byte) c_k0;
				c_tPos = c_tt[c_tPos];
				k1 = (byte) (c_tPos & 0xFF);
				c_tPos >>= 0x8;
				c_nblock_used++;

				if (k1 != c_k0) {
					c_k0 = k1;
					if (cs_avail_out == 0) {
						c_state_out_len = 1;
						break label67;
					}

					cs_decompressed[cs_next_out] = c_state_out_ch;
					cs_next_out++;
					cs_avail_out--;
					next = true;
				} else if (c_nblock_used == s_save_nblockPP) {
					if (cs_avail_out == 0) {
						c_state_out_len = 1;
						break label67;
					}

					cs_decompressed[cs_next_out] = c_state_out_ch;
					cs_next_out++;
					cs_avail_out--;
					next = true;
				}
			}

			// macro: BZ_GET_FAST_C
			c_state_out_len = 2;
			c_tPos = c_tt[c_tPos];
			k1 = (byte) (c_tPos & 0xFF);
			c_tPos >>= 0x8;
			c_nblock_used++;

			if (c_nblock_used != s_save_nblockPP) {
				if (k1 == c_k0) {
					// macro: BZ_GET_FAST_C
					c_state_out_len = 3;
					c_tPos = c_tt[c_tPos];
					k1 = (byte) (c_tPos & 0xFF);
					c_tPos >>= 0x8;
					c_nblock_used++;

					if (c_nblock_used != s_save_nblockPP) {
						if (k1 == c_k0) {
							// macro: BZ_GET_FAST_C
							c_tPos = c_tt[c_tPos];
							k1 = (byte) (c_tPos & 0xFF);
							c_tPos >>= 0x8;
							c_nblock_used++;

							// macro: BZ_GET_FAST_C
							c_state_out_len = (k1 & 0xFF) + 4;
							c_tPos = c_tt[c_tPos];
							c_k0 = (byte) (c_tPos & 0xFF);
							c_tPos >>= 0x8;
							c_nblock_used++;
						} else {
							c_k0 = k1;
						}
					}
				} else {
					c_k0 = k1;
				}
			}
		}

		@Pc(224) int total_out_lo32_old = s.total_out_lo32;
		s.total_out_lo32 += avail_out_INIT - cs_avail_out;
		if (s.total_out_lo32 < total_out_lo32_old) {
			s.total_out_hi32++;
		}

		// save
		s.state_out_ch = c_state_out_ch;
		s.state_out_len = c_state_out_len;
		s.c_nblock_used = c_nblock_used;
		s.k0 = c_k0;
		BZip2State.tt = c_tt;
		s.tPos = c_tPos;
		// s.decompressed = cs_decompressed;
		s.next_out = cs_next_out;
		s.avail_out = cs_avail_out;
		// end save
	}

	// BZ2_decompress
	@OriginalMember(owner = "client!rb", name = "b", descriptor = "(Lclient!sb;)V")
	private static void decompress(@OriginalArg(0) BZip2State s) {
		// libbzip2 uses these variables in a save area
		/*@Pc(3) boolean save_i = false;
		@Pc(5) boolean save_j = false;
		@Pc(7) boolean save_t = false;
		@Pc(9) boolean save_alphaSize = false;
		@Pc(11) boolean save_nGroups = false;
		@Pc(13) boolean save_nSelectors = false;
		@Pc(15) boolean save_EOB = false;
		@Pc(17) boolean save_groupNo = false;
		@Pc(19) boolean save_groupPos = false;
		@Pc(21) boolean save_nextSym = false;
		@Pc(23) boolean save_nblockMAX = false;
		@Pc(25) boolean save_nblock = false;
		@Pc(27) boolean save_es = false;
		@Pc(29) boolean save_N = false;
		@Pc(31) boolean save_curr = false;
		@Pc(33) boolean save_zt = false;
		@Pc(35) boolean save_zn = false;
		@Pc(37) boolean save_zvec = false;
		@Pc(39) boolean save_zj = false;*/

		@Pc(41) int gMinlen = 0;
		@Pc(43) int[] gLimit = null;
		@Pc(45) int[] gBase = null;
		@Pc(47) int[] gPerm = null;

		s.blockSize100k = 1;
		if (BZip2State.tt == null) {
			BZip2State.tt = new int[s.blockSize100k * 100000];
		}

		@Pc(60) boolean reading = true;
		while (reading) {
			@Pc(64) byte uc = getUnsignedChar(s);
			if (uc == 0x17) {
				return;
			}

			// uc checks originally broke the loop and returned an error in libbzip2
			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);

			s.currBlockNo++;

			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);
			uc = getUnsignedChar(s);

			uc = getBit(s);
			s.blockRandomized = uc != 0;
			if (s.blockRandomized) {
				System.out.println("PANIC! RANDOMISED BLOCK!");
			}

			s.origPtr = 0;
			uc = getUnsignedChar(s);
			s.origPtr = s.origPtr << 8 | uc & 0xFF;
			uc = getUnsignedChar(s);
			s.origPtr = s.origPtr << 8 | uc & 0xFF;
			uc = getUnsignedChar(s);
			s.origPtr = s.origPtr << 8 | uc & 0xFF;

			// Receive the mapping table
			@Pc(164) int i;
			for (i = 0; i < 16; i++) {
				uc = getBit(s);
				s.inUse16[i] = uc == 1;
			}

			for (i = 0; i < 256; i++) {
				s.inUse[i] = false;
			}

			@Pc(212) int j;
			for (i = 0; i < 16; i++) {
				if (s.inUse16[i]) {
					for (j = 0; j < 16; j++) {
						uc = getBit(s);
						if (uc == 1) {
							s.inUse[i * 16 + j] = true;
						}
					}
				}
			}
			makeMaps(s);
			@Pc(244) int alphaSize = s.nInUse + 2;

			@Pc(248) int nGroups = getBits(3, s);
			@Pc(252) int nSelectors = getBits(15, s);
			for (i = 0; i < nSelectors; i++) {
				j = 0;

				while (true) {
					uc = getBit(s);
					if (uc == 0) {
						break;
					}
					j++;
				}

				s.selectorMtf[i] = (byte) j;
			}

			// Undo the MTF values for the selectors
			@Pc(279) byte[] pos = new byte[BZip2State.BZ_N_GROUPS];
			@Pc(281) byte v;
			for (v = 0; v < nGroups; v++) {
				pos[v] = v;
			}

			for (i = 0; i < nSelectors; i++) {
				v = s.selectorMtf[i];
				@Pc(308) byte tmp = pos[v];
				while (v > 0) {
					pos[v] = pos[v - 1];
					v--;
				}
				pos[0] = tmp;
				s.selector[i] = tmp;
			}

			// Now the coding tables
			@Pc(340) int t;
			for (t = 0; t < nGroups; t++) {
				@Pc(346) int curr = getBits(5, s);

				for (i = 0; i < alphaSize; i++) {
					while (true) {
						uc = getBit(s);
						if (uc == 0) {
							break;
						}

						uc = getBit(s);
						if (uc == 0) {
							curr++;
						} else {
							curr--;
						}
					}

					s.len[t][i] = (byte) curr;
				}
			}

			// Create the Huffman decoding tables
			for (t = 0; t < nGroups; t++) {
				@Pc(388) byte minLen = 32;
				@Pc(390) byte maxLen = 0;

				for (i = 0; i < alphaSize; i++) {
					if (s.len[t][i] > maxLen) {
						maxLen = s.len[t][i];
					}

					if (s.len[t][i] < minLen) {
						minLen = s.len[t][i];
					}
				}

				createDecodeTables(s.limit[t], s.base[t], s.perm[t], s.len[t], minLen, maxLen, alphaSize);
				s.minLens[t] = minLen;
			}

			// Now the MTF values
			@Pc(462) int EOB = s.nInUse + 1;
			@Pc(467) int nblockMAX = s.blockSize100k * 100000;
			@Pc(469) int groupNo = -1;
			@Pc(471) byte groupPos = 0;

			for (i = 0; i <= 255; i++) {
				s.unzftab[i] = 0;
			}

			// MTF init
			@Pc(486) int kk = BZip2State.MTFA_SIZE - 1;
			for (@Pc(488) int ii = 256 / BZip2State.MTFL_SIZE - 1; ii >= 0; ii--) {
				for (@Pc(492) int jj = BZip2State.MTFL_SIZE - 1; jj >= 0; jj--) {
					s.mtfa[kk] = (byte) (ii * BZip2State.MTFL_SIZE + jj);
					kk--;
				}

				s.mtfbase[ii] = kk + 1;
			}
			// end MTF init

			@Pc(520) int nblock = 0;

			// macro: GET_MTF_VAL
			@Pc(530) byte gSel;
			if (groupPos == 0) {
				groupNo++;
				groupPos = 50;
				gSel = s.selector[groupNo];
				gMinlen = s.minLens[gSel];
				gLimit = s.limit[gSel];
				gPerm = s.perm[gSel];
				gBase = s.base[gSel];
			}

			@Pc(551) int gPos = groupPos - 1;
			@Pc(553) int zn = gMinlen;
			@Pc(557) int zvec;
			@Pc(566) byte zj;
			for (zvec = getBits(gMinlen, s); zvec > gLimit[zn]; zvec = zvec << 1 | zj) {
				zn++;
				zj = getBit(s);
			}

			@Pc(582) int nextSym = gPerm[zvec - gBase[zn]];
			while (nextSym != EOB) {
				if (nextSym == BZip2State.BZ_RUNA || nextSym == BZip2State.BZ_RUNB) {
					@Pc(592) int es = -1;
					@Pc(594) int N = 1;

					do {
						if (nextSym == BZip2State.BZ_RUNA) {
							es += N;
						} else if (nextSym == BZip2State.BZ_RUNB) {
							es += N * 2;
						}

						N *= 2;
						if (gPos == 0) {
							groupNo++;
							gPos = 50;
							gSel = s.selector[groupNo];
							gMinlen = s.minLens[gSel];
							gLimit = s.limit[gSel];
							gPerm = s.perm[gSel];
							gBase = s.base[gSel];
						}

						gPos--;
						zn = gMinlen;
						for (zvec = getBits(gMinlen, s); zvec > gLimit[zn]; zvec = zvec << 1 | zj) {
							zn++;
							zj = getBit(s);
						}

						nextSym = gPerm[zvec - gBase[zn]];
					} while (nextSym == BZip2State.BZ_RUNA || nextSym == BZip2State.BZ_RUNB);

					es++;
					uc = s.seqToUnseq[s.mtfa[s.mtfbase[0]] & 0xFF];
					s.unzftab[uc & 0xFF] += es;

					while (es > 0) {
						BZip2State.tt[nblock] = uc & 0xFF;
						nblock++;
						es--;
					}
				} else {
					// uc = MTF ( nextSym-1 )
					@Pc(724) int nn = nextSym - 1;
					@Pc(732) int pp;

					if (nn < BZip2State.MTFL_SIZE) {
						// avoid general-case expense
						pp = s.mtfbase[0];
						uc = s.mtfa[pp + nn];

						while (nn > 3) {
							@Pc(745) int z = pp + nn;
							s.mtfa[z] = s.mtfa[z - 1];
							s.mtfa[z - 1] = s.mtfa[z - 2];
							s.mtfa[z - 2] = s.mtfa[z - 3];
							s.mtfa[z - 3] = s.mtfa[z - 4];
							nn -= 4;
						}

						while (nn > 0) {
							s.mtfa[pp + nn] = s.mtfa[pp + nn - 1];
							nn--;
						}

						s.mtfa[pp] = uc;
					} else {
						// general case
						@Pc(825) int lno = nn / BZip2State.MTFL_SIZE;
						@Pc(829) int off = nn % BZip2State.MTFL_SIZE;

						pp = s.mtfbase[lno] + off;
						uc = s.mtfa[pp];

						while (pp > s.mtfbase[lno]) {
							s.mtfa[pp] = s.mtfa[pp - 1];
							pp--;
						}

						s.mtfbase[lno]++;

						while (lno > 0) {
							s.mtfbase[lno]--;
							s.mtfa[s.mtfbase[lno]] = s.mtfa[s.mtfbase[lno - 1] + 16 - 1];
							lno--;
						}

						s.mtfbase[0]--;
						s.mtfa[s.mtfbase[0]] = uc;

						if (s.mtfbase[0] == 0) {
							kk = BZip2State.MTFA_SIZE - 1;
							for (@Pc(926) int ii = 256 / BZip2State.MTFL_SIZE - 1; ii >= 0; ii--) {
								for (@Pc(930) int jj = BZip2State.MTFL_SIZE - 1; jj >= 0; jj--) {
									s.mtfa[kk] = s.mtfa[s.mtfbase[ii] + jj];
									kk--;
								}

								s.mtfbase[ii] = kk + 1;
							}
						}
					}
					// end uc = MTF ( nextSym-1 )

					s.unzftab[s.seqToUnseq[uc & 0xFF] & 0xFF]++;
					BZip2State.tt[nblock] = s.seqToUnseq[uc & 0xFF] & 0xFF;
					nblock++;

					// macro: GET_MTF_VAL
					if (gPos == 0) {
						groupNo++;
						gPos = 50;
						gSel = s.selector[groupNo];
						gMinlen = s.minLens[gSel];
						gLimit = s.limit[gSel];
						gPerm = s.perm[gSel];
						gBase = s.base[gSel];
					}

					gPos--;
					zn = gMinlen;
					for (zvec = getBits(gMinlen, s); zvec > gLimit[zn]; zvec = zvec << 1 | zj) {
						zn++;
						zj = getBit(s);
					}
					nextSym = gPerm[zvec - gBase[zn]];
				}
			}

			// Set up cftab to facilitate generation of T^(-1)

			// Actually generate cftab
			s.cftab[0] = 0;

			for (i = 1; i <= 256; i++) {
				s.cftab[i] = s.unzftab[i - 1];
			}

			for (i = 1; i <= 256; i++) {
				s.cftab[i] += s.cftab[i - 1];
			}

			s.state_out_len = 0;
			s.state_out_ch = 0;

			// compute the T^(-1) vector
			for (i = 0; i < nblock; i++) {
				uc = (byte) (BZip2State.tt[i] & 0xFF);
				BZip2State.tt[s.cftab[uc & 0xFF]] |= i << 8;
				s.cftab[uc & 0xFF]++;
			}

			s.tPos = BZip2State.tt[s.origPtr] >> 8;
			s.c_nblock_used = 0;

			// macro: BZ_GET_FAST
			s.tPos = BZip2State.tt[s.tPos];
			s.k0 = (byte) (s.tPos & 0xFF);
			s.tPos >>= 8;
			s.c_nblock_used++;

			s.save_nblock = nblock;
			finish(s);

			if (s.c_nblock_used == s.save_nblock + 1 && s.state_out_len == 0) {
				reading = true;
			} else {
				reading = false;
			}
		}
	}

	// macro: GET_UCHAR
	@OriginalMember(owner = "client!rb", name = "c", descriptor = "(Lclient!sb;)B")
	private static byte getUnsignedChar(@OriginalArg(0) BZip2State s) {
		return (byte) getBits(8, s);
	}

	// macro: GET_BIT
	@OriginalMember(owner = "client!rb", name = "d", descriptor = "(Lclient!sb;)B")
	private static byte getBit(@OriginalArg(0) BZip2State s) {
		return (byte) getBits(1, s);
	}

	// macro: GET_BITS
	@OriginalMember(owner = "client!rb", name = "a", descriptor = "(ILclient!sb;)I")
	private static int getBits(@OriginalArg(0) int n, @OriginalArg(1) BZip2State s) {
		while (s.bsLive < n) {
			s.bsBuff = s.bsBuff << 8 | s.stream[s.next_in] & 0xFF;
			s.bsLive += 8;
			s.next_in++;
			s.avail_in--;
			s.total_in_lo32++;
			if (s.total_in_lo32 == 0) {
				s.total_in_hi32++;
			}
		}

		@Pc(17) int value = s.bsBuff >> s.bsLive - n & (1 << n) - 1;
		s.bsLive -= n;
		return value;
	}

	// makeMaps_d
	@OriginalMember(owner = "client!rb", name = "e", descriptor = "(Lclient!sb;)V")
	private static void makeMaps(@OriginalArg(0) BZip2State s) {
		s.nInUse = 0;

		for (@Pc(4) int i = 0; i < 256; i++) {
			if (s.inUse[i]) {
				s.seqToUnseq[s.nInUse] = (byte) i;
				s.nInUse++;
			}
		}
	}

	// BZ2_hbCreateDecodeTables
	@OriginalMember(owner = "client!rb", name = "a", descriptor = "([I[I[I[BIII)V")
	private static void createDecodeTables(@OriginalArg(0) int[] limit, @OriginalArg(1) int[] base, @OriginalArg(2) int[] perm, @OriginalArg(3) byte[] length, @OriginalArg(4) int minLen, @OriginalArg(5) int maxLen, @OriginalArg(6) int alphaSize) {
		@Pc(3) int pp = 0;
		@Pc(5) int i;

		for (i = minLen; i <= maxLen; i++) {
			for (@Pc(9) int j = 0; j < alphaSize; j++) {
				if (length[j] == i) {
					perm[pp] = j;
					pp++;
				}
			}
		}

		for (i = 0; i < BZip2State.BZ_MAX_CODE_LEN; i++) {
			base[i] = 0;
		}

		for (i = 0; i < alphaSize; i++) {
			base[length[i] + 1]++;
		}

		for (i = 1; i < BZip2State.BZ_MAX_CODE_LEN; i++) {
			base[i] += base[i - 1];
		}

		for (i = 0; i < BZip2State.BZ_MAX_CODE_LEN; i++) {
			limit[i] = 0;
		}

		@Pc(93) int vec = 0;
		for (i = minLen; i <= maxLen; i++) {
			vec += base[i + 1] - base[i];
			limit[i] = vec - 1;
			vec <<= 1;
		}

		for (i = minLen + 1; i <= maxLen; i++) {
			base[i] = (limit[i - 1] + 1 << 1) - base[i];
		}
	}

	// rsc and rs3 says this is an inner class
	@OriginalClass("client!sb")
	public static final class BZip2State {

		@OriginalMember(owner = "client!sb", name = "a", descriptor = "I")
		public static final int MTFA_SIZE = 4096;

		@OriginalMember(owner = "client!sb", name = "b", descriptor = "I")
		public static final int MTFL_SIZE = 16;

		@OriginalMember(owner = "client!sb", name = "c", descriptor = "I")
		public static final int BZ_MAX_ALPHA_SIZE = 258;

		@OriginalMember(owner = "client!sb", name = "d", descriptor = "I")
		public static final int BZ_MAX_CODE_LEN = 23;

		@OriginalMember(owner = "client!sb", name = "e", descriptor = "I")
		private static final int anInt732 = 1; // TODO

		@OriginalMember(owner = "client!sb", name = "f", descriptor = "I")
		private static final int BZ_N_GROUPS = 6;

		@OriginalMember(owner = "client!sb", name = "g", descriptor = "I")
		private static final int BZ_G_SIZE = 50;

		@OriginalMember(owner = "client!sb", name = "h", descriptor = "I")
		private static final int anInt735 = 4; // TODO

		@OriginalMember(owner = "client!sb", name = "i", descriptor = "I")
		private static final int BZ_MAX_SELECTORS = (2 + (900000 / BZ_G_SIZE)); // 18002

		public static final int BZ_RUNA = 0;
		public static final int BZ_RUNB = 1;

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
		public final byte[] mtfa = new byte[MTFA_SIZE];

		@OriginalMember(owner = "client!sb", name = "N", descriptor = "[I")
		public final int[] mtfbase = new int[256 / MTFL_SIZE];

		@OriginalMember(owner = "client!sb", name = "O", descriptor = "[B")
		public final byte[] selector = new byte[BZ_MAX_SELECTORS];

		@OriginalMember(owner = "client!sb", name = "P", descriptor = "[B")
		public final byte[] selectorMtf = new byte[BZ_MAX_SELECTORS];

		@OriginalMember(owner = "client!sb", name = "Q", descriptor = "[[B")
		public final byte[][] len = new byte[BZ_N_GROUPS][BZ_MAX_ALPHA_SIZE];

		@OriginalMember(owner = "client!sb", name = "R", descriptor = "[[I")
		public final int[][] limit = new int[BZ_N_GROUPS][BZ_MAX_ALPHA_SIZE];

		@OriginalMember(owner = "client!sb", name = "S", descriptor = "[[I")
		public final int[][] base = new int[BZ_N_GROUPS][BZ_MAX_ALPHA_SIZE];

		@OriginalMember(owner = "client!sb", name = "T", descriptor = "[[I")
		public final int[][] perm = new int[BZ_N_GROUPS][BZ_MAX_ALPHA_SIZE];

		@OriginalMember(owner = "client!sb", name = "U", descriptor = "[I")
		public final int[] minLens = new int[BZ_N_GROUPS];

		@OriginalMember(owner = "client!sb", name = "V", descriptor = "I")
		public int save_nblock;
	}
}
