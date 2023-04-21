package jagex2.client;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class WordFilter {

	@OriginalMember(owner = "client!mc", name = "j", descriptor = "[I")
	private static int[] fragments;

	@OriginalMember(owner = "client!mc", name = "k", descriptor = "[[C")
	private static char[][] badWords;

	@OriginalMember(owner = "client!mc", name = "l", descriptor = "[[[B")
	private static byte[][][] badCombinations;

	@OriginalMember(owner = "client!mc", name = "m", descriptor = "[[C")
	private static char[][] domains;

	@OriginalMember(owner = "client!mc", name = "n", descriptor = "[[C")
	private static char[][] tlds;

	@OriginalMember(owner = "client!mc", name = "o", descriptor = "[I")
	private static int[] tldType;

	@OriginalMember(owner = "client!mc", name = "p", descriptor = "[Ljava/lang/String;")
	private static final String[] ALLOWLIST = new String[] { "cook", "cook's", "cooks", "seeks", "sheet" };

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void unpack(@OriginalArg(0) Jagfile arg0) {
		@Pc(11) Packet local11 = new Packet(arg0.read("fragmentsenc.txt", null));
		@Pc(21) Packet local21 = new Packet(arg0.read("badenc.txt", null));
		@Pc(31) Packet local31 = new Packet(arg0.read("domainenc.txt", null));
		@Pc(41) Packet local41 = new Packet(arg0.read("tldlist.txt", null));
		read(local11, local21, local31, local41);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!kb;Lclient!kb;Lclient!kb;Lclient!kb;)V")
	private static void read(@OriginalArg(0) Packet arg0, @OriginalArg(1) Packet arg1, @OriginalArg(2) Packet arg2, @OriginalArg(3) Packet arg3) {
		readBadWords(arg1);
		readDomains(arg2);
		readFragments(arg0);
		readTld(arg3);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ZLclient!kb;)V")
	private static void readTld(@OriginalArg(1) Packet arg1) {
		@Pc(4) int local4 = arg1.g4();
		tlds = new char[local4][];
		tldType = new int[local4];
		for (@Pc(15) int local15 = 0; local15 < local4; local15++) {
			tldType[local15] = arg1.g1();
			@Pc(26) char[] local26 = new char[arg1.g1()];
			for (@Pc(28) int local28 = 0; local28 < local26.length; local28++) {
				local26[local28] = (char) arg1.g1();
			}
			tlds[local15] = local26;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ILclient!kb;)V")
	private static void readBadWords(@OriginalArg(1) Packet arg1) {
		@Pc(2) int local2 = arg1.g4();
		badWords = new char[local2][];
		badCombinations = new byte[local2][][];
		readBadCombinations(badCombinations, badWords, arg1);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!kb;I)V")
	private static void readDomains(@OriginalArg(0) Packet arg0) {
		@Pc(2) int local2 = arg0.g4();
		domains = new char[local2][];
		readDomain(arg0, domains);
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(ILclient!kb;)V")
	private static void readFragments(@OriginalArg(1) Packet arg1) {
		fragments = new int[arg1.g4()];
		for (@Pc(5) int local5 = 0; local5 < fragments.length; local5++) {
			fragments[local5] = arg1.g2();
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([[[B[[CLclient!kb;B)V")
	private static void readBadCombinations(@OriginalArg(0) byte[][][] arg0, @OriginalArg(1) char[][] arg1, @OriginalArg(2) Packet arg2) {
		@Pc(6) boolean local6 = false;
		for (@Pc(10) int local10 = 0; local10 < arg1.length; local10++) {
			@Pc(17) char[] local17 = new char[arg2.g1()];
			for (@Pc(19) int local19 = 0; local19 < local17.length; local19++) {
				local17[local19] = (char) arg2.g1();
			}
			arg1[local10] = local17;
			@Pc(41) byte[][] local41 = new byte[arg2.g1()][2];
			for (@Pc(43) int local43 = 0; local43 < local41.length; local43++) {
				local41[local43][0] = (byte) arg2.g1();
				local41[local43][1] = (byte) arg2.g1();
			}
			if (local41.length > 0) {
				arg0[local10] = local41;
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ILclient!kb;[[C)V")
	private static void readDomain(@OriginalArg(1) Packet arg1, @OriginalArg(2) char[][] arg2) {
		for (@Pc(5) int local5 = 0; local5 < arg2.length; local5++) {
			@Pc(20) char[] local20 = new char[arg1.g1()];
			for (@Pc(22) int local22 = 0; local22 < local20.length; local22++) {
				local20[local22] = (char) arg1.g1();
			}
			arg2[local5] = local20;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CI)V")
	private static void filterCharacters(@OriginalArg(0) char[] arg0) {
		@Pc(3) int local3 = 0;
		for (@Pc(5) int local5 = 0; local5 < arg0.length; local5++) {
			if (allowCharacter(arg0[local5])) {
				arg0[local3] = arg0[local5];
			} else {
				arg0[local3] = ' ';
			}
			if (local3 == 0 || arg0[local3] != ' ' || arg0[local3 - 1] != ' ') {
				local3++;
			}
		}
		for (@Pc(55) int local55 = local3; local55 < arg0.length; local55++) {
			arg0[local55] = ' ';
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(IC)Z")
	private static boolean allowCharacter(@OriginalArg(1) char arg1) {
		return arg1 > ' ' && arg1 <= '\u007f' || arg1 == ' ' || arg1 == '\n' || arg1 == '\t' || arg1 == '£' || arg1 == '€';
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String filter(@OriginalArg(0) String arg0) {
		@Pc(3) long local3 = System.currentTimeMillis();
		@Pc(6) char[] local6 = arg0.toCharArray();
		filterCharacters(local6);
		@Pc(15) String local15 = (new String(local6)).trim();
		@Pc(19) char[] local19 = local15.toLowerCase().toCharArray();
		@Pc(22) String local22 = local15.toLowerCase();
		filterTld(local19);
		filterBad(local19);
		filterDomains(local19);
		filterFragments(local19);
		@Pc(45) int local45;
		for (@Pc(36) int local36 = 0; local36 < ALLOWLIST.length; local36++) {
			local45 = -1;
			while ((local45 = local22.indexOf(ALLOWLIST[local36], local45 + 1)) != -1) {
				@Pc(52) char[] local52 = ALLOWLIST[local36].toCharArray();
				for (@Pc(54) int local54 = 0; local54 < local52.length; local54++) {
					local19[local54 + local45] = local52[local54];
				}
			}
		}
		replaceUpperCases(local19, local15.toCharArray());
		formatUpperCases(local19);
		@Pc(105) long local105 = System.currentTimeMillis();
		return (new String(local19)).trim();
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CI[C)V")
	private static void replaceUpperCases(@OriginalArg(0) char[] arg0, @OriginalArg(2) char[] arg2) {
		for (@Pc(1) int local1 = 0; local1 < arg2.length; local1++) {
			if (arg0[local1] != '*' && isUpperCase(arg2[local1])) {
				arg0[local1] = arg2[local1];
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(B[C)V")
	private static void formatUpperCases(@OriginalArg(1) char[] arg1) {
		@Pc(3) boolean local3 = true;
		@Pc(8) boolean local8 = false;
		for (@Pc(12) int local12 = 0; local12 < arg1.length; local12++) {
			@Pc(19) char local19 = arg1[local12];
			if (!isAlpha(local19)) {
				local3 = true;
			} else if (local3) {
				if (isLowerCase(local19)) {
					local3 = false;
				}
			} else if (isUpperCase(local19)) {
				arg1[local12] = (char) (local19 + 'a' - 65);
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Z[C)V")
	private static void filterBad(@OriginalArg(1) char[] arg1) {
		for (@Pc(3) int local3 = 0; local3 < 2; local3++) {
			for (@Pc(10) int local10 = badWords.length - 1; local10 >= 0; local10--) {
				filter(badCombinations[local10], arg1, badWords[local10]);
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(B[C)V")
	private static void filterDomains(@OriginalArg(1) char[] arg1) {
		@Pc(3) char[] local3 = (char[]) arg1.clone();
		@Pc(18) char[] local18 = new char[] { '(', 'a', ')' };
		filter(null, local3, local18);
		@Pc(27) char[] local27 = (char[]) arg1.clone();
		@Pc(42) char[] local42 = new char[] { 'd', 'o', 't' };
		filter(null, local27, local42);
		for (@Pc(56) int local56 = domains.length - 1; local56 >= 0; local56--) {
			filterDomain(local27, local3, domains[local56], arg1);
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CI[C[C[C)V")
	private static void filterDomain(@OriginalArg(0) char[] arg0, @OriginalArg(2) char[] arg2, @OriginalArg(3) char[] arg3, @OriginalArg(4) char[] arg4) {
		if (arg3.length > arg4.length) {
			return;
		}

		@Pc(9) boolean local9 = true;
		@Pc(23) int local23;
		for (@Pc(15) int local15 = 0; local15 <= arg4.length - arg3.length; local15 += local23) {
			@Pc(19) int local19 = local15;
			@Pc(21) int local21 = 0;
			local23 = 1;
			@Pc(27) boolean var9;
			label62: while (true) {
				while (true) {
					if (local19 >= arg4.length) {
						break label62;
					}
					var9 = false;
					@Pc(31) char local31 = arg4[local19];
					@Pc(33) char local33 = 0;
					if (local19 + 1 < arg4.length) {
						local33 = arg4[local19 + 1];
					}
					@Pc(58) int local58;
					if (local21 < arg3.length && (local58 = getEmulatedDomainCharSize(local33, arg3[local21], local31)) > 0) {
						local19 += local58;
						local21++;
					} else {
						if (local21 == 0) {
							break label62;
						}
						@Pc(79) int local79;
						if ((local79 = getEmulatedDomainCharSize(local33, arg3[local21 - 1], local31)) > 0) {
							local19 += local79;
							if (local21 == 1) {
								local23++;
							}
						} else {
							if (local21 >= arg3.length || !isSymbol(local31)) {
								break label62;
							}
							local19++;
						}
					}
				}
			}
			if (local21 >= arg3.length) {
				var9 = false;
				@Pc(116) int local116 = getDomainAtFilterStatus(local15, arg4, arg2);
				@Pc(124) int local124 = getDomainDotFilterStatus(arg0, arg4, local19 - 1);
				if (local116 > 2 || local124 > 2) {
					var9 = true;
				}
				if (var9) {
					for (@Pc(136) int local136 = local15; local136 < local19; local136++) {
						arg4[local136] = '*';
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(I[CB[C)I")
	private static int getDomainAtFilterStatus(@OriginalArg(0) int arg0, @OriginalArg(1) char[] arg1, @OriginalArg(3) char[] arg3) {
		if (arg0 == 0) {
			return 2;
		}
		for (@Pc(9) int local9 = arg0 - 1; local9 >= 0 && isSymbol(arg1[local9]); local9--) {
			if (arg1[local9] == '@') {
				return 3;
			}
		}
		@Pc(32) boolean local32 = false;
		@Pc(37) int local37 = 0;
		for (@Pc(41) int local41 = arg0 - 1; local41 >= 0 && isSymbol(arg3[local41]); local41--) {
			if (arg3[local41] == '*') {
				local37++;
			}
		}
		if (local37 >= 3) {
			return 4;
		} else if (isSymbol(arg1[arg0 - 1])) {
			return 1;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([C[CII)I")
	private static int getDomainDotFilterStatus(@OriginalArg(0) char[] arg0, @OriginalArg(1) char[] arg1, @OriginalArg(2) int arg2) {
		if (arg2 + 1 == arg1.length) {
			return 2;
		}

		@Pc(17) int local17 = arg2 + 1;
		while (true) {
			if (local17 < arg1.length && isSymbol(arg1[local17])) {
				if (arg1[local17] != '.' && arg1[local17] != ',') {
					local17++;
					continue;
				}
				return 3;
			}
			@Pc(44) int local44 = 0;
			for (@Pc(48) int local48 = arg2 + 1; local48 < arg1.length && isSymbol(arg0[local48]); local48++) {
				if (arg0[local48] == '*') {
					local44++;
				}
			}
			if (local44 >= 3) {
				return 4;
			}
			if (isSymbol(arg1[arg2 + 1])) {
				return 1;
			}
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "([CI)V")
	private static void filterTld(@OriginalArg(0) char[] arg0) {
		@Pc(3) char[] local3 = (char[]) arg0.clone();
		@Pc(18) char[] local18 = new char[] { 'd', 'o', 't' };
		filter(null, local3, local18);
		@Pc(27) char[] local27 = (char[]) arg0.clone();
		@Pc(50) char[] local50 = new char[] { 's', 'l', 'a', 's', 'h' };
		filter(null, local27, local50);
		for (@Pc(65) int local65 = 0; local65 < tlds.length; local65++) {
			filterTld(local27, tldType[local65], arg0, tlds[local65], local3);
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CIZ[C[C[C)V")
	private static void filterTld(@OriginalArg(0) char[] arg0, @OriginalArg(1) int arg1, @OriginalArg(3) char[] arg3, @OriginalArg(4) char[] arg4, @OriginalArg(5) char[] arg5) {
		@Pc(5) int local5;
		if (arg4.length > arg3.length) {
			return;
		}

		@Pc(18) boolean local18 = true;
		for (@Pc(20) int local20 = 0; local20 <= arg3.length - arg4.length; local20 += local5) {
			@Pc(24) int local24 = local20;
			@Pc(26) int local26 = 0;
			local5 = 1;
			@Pc(32) boolean var10;
			label124: while (true) {
				while (true) {
					if (local24 >= arg3.length) {
						break label124;
					}
					var10 = false;
					@Pc(36) char local36 = arg3[local24];
					@Pc(38) char local38 = 0;
					if (local24 + 1 < arg3.length) {
						local38 = arg3[local24 + 1];
					}
					@Pc(63) int local63;
					if (local26 < arg4.length && (local63 = getEmulatedDomainCharSize(local38, arg4[local26], local36)) > 0) {
						local24 += local63;
						local26++;
					} else {
						if (local26 == 0) {
							break label124;
						}
						@Pc(84) int local84;
						if ((local84 = getEmulatedDomainCharSize(local38, arg4[local26 - 1], local36)) > 0) {
							local24 += local84;
							if (local26 == 1) {
								local5++;
							}
						} else {
							if (local26 >= arg4.length || !isSymbol(local36)) {
								break label124;
							}
							local24++;
						}
					}
				}
			}
			if (local26 >= arg4.length) {
				var10 = false;
				@Pc(121) int local121 = getTldDotFilterStatus(arg3, arg5, local20);
				@Pc(129) int local129 = getTldSlashFilterStatus(arg0, local24 - 1, arg3);
				if (arg1 == 1 && local121 > 0 && local129 > 0) {
					var10 = true;
				}
				if (arg1 == 2 && (local121 > 2 && local129 > 0 || local121 > 0 && local129 > 2)) {
					var10 = true;
				}
				if (arg1 == 3 && local121 > 0 && local129 > 2) {
					var10 = true;
				}
				@Pc(172) boolean local172;
				if (arg1 == 3 && local121 > 2 && local129 > 0) {
					local172 = true;
				} else {
					local172 = false;
				}
				if (var10) {
					@Pc(179) int local179 = local20;
					@Pc(183) int local183 = local24 - 1;
					@Pc(191) boolean local191;
					@Pc(195) int local195;
					if (local121 > 2) {
						if (local121 == 4) {
							local191 = false;
							for (local195 = local20 - 1; local195 >= 0; local195--) {
								if (local191) {
									if (arg5[local195] != '*') {
										break;
									}
									local179 = local195;
								} else if (arg5[local195] == '*') {
									local179 = local195;
									local191 = true;
								}
							}
						}
						local191 = false;
						for (local195 = local179 - 1; local195 >= 0; local195--) {
							if (local191) {
								if (isSymbol(arg3[local195])) {
									break;
								}
								local179 = local195;
							} else if (!isSymbol(arg3[local195])) {
								local191 = true;
								local179 = local195;
							}
						}
					}
					if (local129 > 2) {
						if (local129 == 4) {
							local191 = false;
							for (local195 = local183 + 1; local195 < arg3.length; local195++) {
								if (local191) {
									if (arg0[local195] != '*') {
										break;
									}
									local183 = local195;
								} else if (arg0[local195] == '*') {
									local183 = local195;
									local191 = true;
								}
							}
						}
						local191 = false;
						for (local195 = local183 + 1; local195 < arg3.length; local195++) {
							if (local191) {
								if (isSymbol(arg3[local195])) {
									break;
								}
								local183 = local195;
							} else if (!isSymbol(arg3[local195])) {
								local191 = true;
								local183 = local195;
							}
						}
					}
					for (@Pc(329) int local329 = local179; local329 <= local183; local329++) {
						arg3[local329] = '*';
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CZ[CI)I")
	private static int getTldDotFilterStatus(@OriginalArg(0) char[] arg0, @OriginalArg(2) char[] arg2, @OriginalArg(3) int arg3) {
		if (arg3 == 0) {
			return 2;
		}
		@Pc(9) int local9 = arg3 - 1;
		while (true) {
			if (local9 >= 0 && isSymbol(arg0[local9])) {
				if (arg0[local9] != ',' && arg0[local9] != '.') {
					local9--;
					continue;
				}
				return 3;
			}
			@Pc(34) int local34 = 0;
			@Pc(38) int local38;
			for (local38 = arg3 - 1; local38 >= 0 && isSymbol(arg2[local38]); local38--) {
				if (arg2[local38] == '*') {
					local34++;
				}
			}
			if (local34 >= 3) {
				return 4;
			}
			if (isSymbol(arg0[arg3 - 1])) {
				return 1;
			}
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CII[C)I")
	private static int getTldSlashFilterStatus(@OriginalArg(0) char[] arg0, @OriginalArg(2) int arg2, @OriginalArg(3) char[] arg3) {
		if (arg2 + 1 == arg3.length) {
			return 2;
		}
		@Pc(13) int local13 = arg2 + 1;
		while (true) {
			if (local13 < arg3.length && isSymbol(arg3[local13])) {
				if (arg3[local13] != '\\' && arg3[local13] != '/') {
					local13++;
					continue;
				}
				return 3;
			}
			@Pc(40) int local40 = 0;
			for (@Pc(44) int local44 = arg2 + 1; local44 < arg3.length && isSymbol(arg0[local44]); local44++) {
				if (arg0[local44] == '*') {
					local40++;
				}
			}
			if (local40 >= 5) {
				return 4;
			}
			if (isSymbol(arg3[arg2 + 1])) {
				return 1;
			}
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(B[[B[C[C)V")
	private static void filter(@OriginalArg(1) byte[][] arg1, @OriginalArg(2) char[] arg2, @OriginalArg(3) char[] arg3) {
		if (arg3.length > arg2.length) {
			return;
		}

		@Pc(9) boolean local9 = true;
		@Pc(26) int local26;
		for (@Pc(16) int local16 = 0; local16 <= arg2.length - arg3.length; local16 += local26) {
			@Pc(20) int local20 = local16;
			@Pc(22) int local22 = 0;
			@Pc(24) int local24 = 0;
			local26 = 1;
			@Pc(28) boolean local28 = false;
			@Pc(30) boolean local30 = false;
			@Pc(32) boolean local32 = false;
			@Pc(36) boolean var12;
			@Pc(40) char var13;
			@Pc(42) char var14;
			label163: while (true) {
				while (true) {
					if (local20 >= arg2.length || local30 && local32) {
						break label163;
					}
					var12 = false;
					var13 = arg2[local20];
					var14 = '\u0000';
					if (local20 + 1 < arg2.length) {
						var14 = arg2[local20 + 1];
					}
					@Pc(67) int local67;
					if (local22 < arg3.length && (local67 = getEmulatedSize(var14, arg3[local22], var13)) > 0) {
						if (local67 == 1 && isNumber(var13)) {
							local30 = true;
						}
						if (local67 == 2 && (isNumber(var13) || isNumber(var14))) {
							local30 = true;
						}
						local20 += local67;
						local22++;
					} else {
						if (local22 == 0) {
							break label163;
						}
						@Pc(110) int local110;
						if ((local110 = getEmulatedSize(var14, arg3[local22 - 1], var13)) > 0) {
							local20 += local110;
							if (local22 == 1) {
								local26++;
							}
						} else {
							if (local22 >= arg3.length || !isLowerCaseAlpha(var13)) {
								break label163;
							}
							if (isSymbol(var13) && var13 != '\'') {
								local28 = true;
							}
							if (isNumber(var13)) {
								local32 = true;
							}
							local20++;
							local24++;
							if (local24 * 100 / (local20 - local16) > 90) {
								break label163;
							}
						}
					}
				}
			}
			if (local22 >= arg3.length && (!local30 || !local32)) {
				var12 = true;
				@Pc(271) int local271;
				if (local28) {
					@Pc(221) boolean local221 = false;
					@Pc(223) boolean local223 = false;
					if (local16 - 1 < 0 || isSymbol(arg2[local16 - 1]) && arg2[local16 - 1] != '\'') {
						local221 = true;
					}
					if (local20 >= arg2.length || isSymbol(arg2[local20]) && arg2[local20] != '\'') {
						local223 = true;
					}
					if (!local221 || !local223) {
						@Pc(267) boolean local267 = false;
						local271 = local16 - 2;
						if (local221) {
							local271 = local16;
						}
						while (!local267 && local271 < local20) {
							if (local271 >= 0 && (!isSymbol(arg2[local271]) || arg2[local271] == '\'')) {
								@Pc(293) char[] local293 = new char[3];
								@Pc(295) int local295;
								for (local295 = 0; local295 < 3 && local271 + local295 < arg2.length && (!isSymbol(arg2[local271 + local295]) || arg2[local271 + local295] == '\''); local295++) {
									local293[local295] = arg2[local271 + local295];
								}
								@Pc(333) boolean local333 = true;
								if (local295 == 0) {
									local333 = false;
								}
								if (local295 < 3 && local271 - 1 >= 0 && (!isSymbol(arg2[local271 - 1]) || arg2[local271 - 1] == '\'')) {
									local333 = false;
								}
								if (local333 && !isBadFragment(local293)) {
									local267 = true;
								}
							}
							local271++;
						}
						if (!local267) {
							var12 = false;
						}
					}
				} else {
					var13 = ' ';
					if (local16 - 1 >= 0) {
						var13 = arg2[local16 - 1];
					}
					var14 = ' ';
					if (local20 < arg2.length) {
						var14 = arg2[local20];
					}
					@Pc(203) byte local203 = getIndex(var13);
					@Pc(207) byte local207 = getIndex(var14);
					if (arg1 != null && comboMatches(local203, arg1, local207)) {
						var12 = false;
					}
				}
				if (var12) {
					@Pc(383) int local383 = 0;
					@Pc(385) int local385 = 0;
					for (@Pc(387) int local387 = local16; local387 < local20; local387++) {
						if (isNumber(arg2[local387])) {
							local383++;
						} else if (isAlpha(arg2[local387])) {
							local385++;
						}
					}
					if (local383 <= local385) {
						for (local271 = local16; local271 < local20; local271++) {
							arg2[local271] = '*';
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(IB[[BB)Z")
	private static boolean comboMatches(@OriginalArg(1) byte arg1, @OriginalArg(2) byte[][] arg2, @OriginalArg(3) byte arg3) {
		@Pc(9) int local9 = 0;
		if (arg2[local9][0] == arg1 && arg2[local9][1] == arg3) {
			return true;
		}
		@Pc(30) int local30 = arg2.length - 1;
		if (arg2[local30][0] == arg1 && arg2[local30][1] == arg3) {
			return true;
		}
		do {
			@Pc(52) int local52 = (local9 + local30) / 2;
			if (arg2[local52][0] == arg1 && arg2[local52][1] == arg3) {
				return true;
			}
			if (arg1 < arg2[local52][0] || arg1 == arg2[local52][0] && arg3 < arg2[local52][1]) {
				local30 = local52;
			} else {
				local9 = local52;
			}
		} while (local9 != local30 && local9 + 1 != local30);
		return false;
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ICCC)I")
	private static int getEmulatedDomainCharSize(@OriginalArg(1) char arg1, @OriginalArg(2) char arg2, @OriginalArg(3) char arg3) {
		if (arg2 == arg3) {
			return 1;
		} else if (arg2 == 'o' && arg3 == '0') {
			return 1;
		} else if (arg2 == 'o' && arg3 == '(' && arg1 == ')') {
			return 2;
		} else if (arg2 == 'c' && (arg3 == '(' || arg3 == '<' || arg3 == '[')) {
			return 1;
		} else if (arg2 == 'e' && arg3 == '€') {
			return 1;
		} else if (arg2 == 's' && arg3 == '$') {
			return 1;
		} else if (arg2 == 'l' && arg3 == 'i') {
			return 1;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(CCCI)I")
	private static int getEmulatedSize(@OriginalArg(0) char arg0, @OriginalArg(1) char arg1, @OriginalArg(2) char arg2) {
		if (arg1 == arg2) {
			return 1;
		}
		if (arg1 >= 'a' && arg1 <= 'm') {
			if (arg1 == 'a') {
				if (arg2 != '4' && arg2 != '@' && arg2 != '^') {
					if (arg2 == '/' && arg0 == '\\') {
						return 2;
					}
					return 0;
				}
				return 1;
			}
			if (arg1 == 'b') {
				if (arg2 != '6' && arg2 != '8') {
					if (arg2 == '1' && arg0 == '3') {
						return 2;
					}
					return 0;
				}
				return 1;
			}
			if (arg1 == 'c') {
				if (arg2 != '(' && arg2 != '<' && arg2 != '{' && arg2 != '[') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 'd') {
				if (arg2 == '[' && arg0 == ')') {
					return 2;
				}
				return 0;
			}
			if (arg1 == 'e') {
				if (arg2 != '3' && arg2 != '€') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 'f') {
				if (arg2 == 'p' && arg0 == 'h') {
					return 2;
				}
				if (arg2 == '£') {
					return 1;
				}
				return 0;
			}
			if (arg1 == 'g') {
				if (arg2 != '9' && arg2 != '6') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 'h') {
				if (arg2 == '#') {
					return 1;
				}
				return 0;
			}
			if (arg1 == 'i') {
				if (arg2 != 'y' && arg2 != 'l' && arg2 != 'j' && arg2 != '1' && arg2 != '!' && arg2 != ':' && arg2 != ';' && arg2 != '|') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 'j') {
				return 0;
			}
			if (arg1 == 'k') {
				return 0;
			}
			if (arg1 == 'l') {
				if (arg2 != '1' && arg2 != '|' && arg2 != 'i') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 'm') {
				return 0;
			}
		}
		if (arg1 >= 'n' && arg1 <= 'z') {
			if (arg1 == 'n') {
				return 0;
			}
			if (arg1 == 'o') {
				if (arg2 != '0' && arg2 != '*') {
					if ((arg2 != '(' || arg0 != ')') && (arg2 != '[' || arg0 != ']') && (arg2 != '{' || arg0 != '}') && (arg2 != '<' || arg0 != '>')) {
						return 0;
					}
					return 2;
				}
				return 1;
			}
			if (arg1 == 'p') {
				return 0;
			}
			if (arg1 == 'q') {
				return 0;
			}
			if (arg1 == 'r') {
				return 0;
			}
			if (arg1 == 's') {
				if (arg2 != '5' && arg2 != 'z' && arg2 != '$' && arg2 != '2') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 't') {
				if (arg2 != '7' && arg2 != '+') {
					return 0;
				}
				return 1;
			}
			if (arg1 == 'u') {
				if (arg2 == 'v') {
					return 1;
				}
				if (arg2 == '\\' && arg0 == '/' || arg2 == '\\' && arg0 == '|' || arg2 == '|' && arg0 == '/') {
					return 2;
				}
				return 0;
			}
			if (arg1 == 'v') {
				if ((arg2 != '\\' || arg0 != '/') && (arg2 != '\\' || arg0 != '|') && (arg2 != '|' || arg0 != '/')) {
					return 0;
				}
				return 2;
			}
			if (arg1 == 'w') {
				if (arg2 == 'v' && arg0 == 'v') {
					return 2;
				}
				return 0;
			}
			if (arg1 == 'x') {
				if ((arg2 != ')' || arg0 != '(') && (arg2 != '}' || arg0 != '{') && (arg2 != ']' || arg0 != '[') && (arg2 != '>' || arg0 != '<')) {
					return 0;
				}
				return 2;
			}
			if (arg1 == 'y') {
				return 0;
			}
			if (arg1 == 'z') {
				return 0;
			}
		}
		if (arg1 >= '0' && arg1 <= '9') {
			if (arg1 == '0') {
				if (arg2 == 'o' || arg2 == 'O') {
					return 1;
				} else if ((arg2 != '(' || arg0 != ')') && (arg2 != '{' || arg0 != '}') && (arg2 != '[' || arg0 != ']')) {
					return 0;
				} else {
					return 2;
				}
			} else if (arg1 == '1') {
				return arg2 == 'l' ? 1 : 0;
			} else {
				return 0;
			}
		} else if (arg1 == ',') {
			return arg2 == '.' ? 1 : 0;
		} else if (arg1 == '.') {
			return arg2 == ',' ? 1 : 0;
		} else if (arg1 == '!') {
			return arg2 == 'i' ? 1 : 0;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(IC)B")
	private static byte getIndex(@OriginalArg(1) char arg1) {
		if (arg1 >= 'a' && arg1 <= 'z') {
			return (byte) (arg1 + 1 - 'a');
		} else if (arg1 == '\'') {
			return 28;
		} else if (arg1 >= '0' && arg1 <= '9') {
			return (byte) (arg1 + 29 - '0');
		} else {
			return 27;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(I[C)V")
	private static void filterFragments(@OriginalArg(1) char[] arg1) {
		@Pc(3) boolean local3 = false;
		@Pc(5) int local5 = 0;
		@Pc(11) int local11 = 0;
		@Pc(13) int local13 = 0;
		while (true) {
			do {
				@Pc(112) int local112;
				if ((local112 = indexOfNumber(arg1, local5)) == -1) {
					return;
				}
				@Pc(17) boolean local17 = false;
				for (@Pc(19) int local19 = local5; local19 >= 0 && local19 < local112 && !local17; local19++) {
					if (!isSymbol(arg1[local19]) && !isLowerCaseAlpha(arg1[local19])) {
						local17 = true;
					}
				}
				if (local17) {
					local11 = 0;
				}
				if (local11 == 0) {
					local13 = local112;
				}
				local5 = indexOfNonNumber(local112, arg1);
				@Pc(58) int local58 = 0;
				for (@Pc(60) int local60 = local112; local60 < local5; local60++) {
					local58 = local58 * 10 + arg1[local60] - 48;
				}
				if (local58 <= 255 && local5 - local112 <= 8) {
					local11++;
				} else {
					local11 = 0;
				}
			} while (local11 != 4);
			for (@Pc(94) int local94 = local13; local94 < local5; local94++) {
				arg1[local94] = '*';
			}
			local11 = 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(I[CI)I")
	private static int indexOfNumber(@OriginalArg(1) char[] arg1, @OriginalArg(2) int arg2) {
		for (@Pc(5) int local5 = arg2; local5 < arg1.length && local5 >= 0; local5++) {
			if (arg1[local5] >= '0' && arg1[local5] <= '9') {
				return local5;
			}
		}
		return -1;
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(II[C)I")
	private static int indexOfNonNumber(@OriginalArg(1) int arg1, @OriginalArg(2) char[] arg2) {
		@Pc(6) int local6 = arg1;
		while (true) {
			if (local6 < arg2.length && local6 >= 0) {
				if (arg2[local6] >= '0' && arg2[local6] <= '9') {
					local6++;
					continue;
				}
				return local6;
			}
			return arg2.length;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(CI)Z")
	private static boolean isSymbol(@OriginalArg(0) char arg0) {
		return !isAlpha(arg0) && !isNumber(arg0);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(CB)Z")
	private static boolean isLowerCaseAlpha(@OriginalArg(0) char arg0) {
		if (arg0 >= 'a' && arg0 <= 'z') {
			return arg0 == 'v' || arg0 == 'x' || arg0 == 'j' || arg0 == 'q' || arg0 == 'z';
		} else {
			return true;
		}
	}

	@OriginalMember(owner = "client!mc", name = "c", descriptor = "(IC)Z")
	private static boolean isAlpha(@OriginalArg(1) char arg1) {
		return arg1 >= 'a' && arg1 <= 'z' || arg1 >= 'A' && arg1 <= 'Z';
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(CI)Z")
	private static boolean isNumber(@OriginalArg(0) char arg0) {
		return arg0 >= '0' && arg0 <= '9';
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(BC)Z")
	private static boolean isLowerCase(@OriginalArg(1) char arg1) {
		return arg1 >= 'a' && arg1 <= 'z';
	}

	@OriginalMember(owner = "client!mc", name = "d", descriptor = "(IC)Z")
	private static boolean isUpperCase(@OriginalArg(1) char arg1) {
		return arg1 >= 'A' && arg1 <= 'Z';
	}

	@OriginalMember(owner = "client!mc", name = "c", descriptor = "([CI)Z")
	private static boolean isBadFragment(@OriginalArg(0) char[] arg0) {
		@Pc(3) boolean local3 = true;
		for (@Pc(5) int local5 = 0; local5 < arg0.length; local5++) {
			if (!isNumber(arg0[local5]) && arg0[local5] != '\u0000') {
				local3 = false;
			}
		}
		if (local3) {
			return true;
		}
		@Pc(32) int local32 = firstFragmentId(arg0);
		@Pc(34) int local34 = 0;
		@Pc(39) int local39;
		local39 = fragments.length - 1;
		if (local32 == fragments[local34] || local32 == fragments[local39]) {
			return true;
		}
		do {
			@Pc(67) int local67 = (local34 + local39) / 2;
			if (local32 == fragments[local67]) {
				return true;
			}
			if (local32 < fragments[local67]) {
				local39 = local67;
			} else {
				local34 = local67;
			}
		} while (local34 != local39 && local34 + 1 != local39);
		return false;
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(I[C)I")
	private static int firstFragmentId(@OriginalArg(1) char[] arg1) {
		if (arg1.length > 6) {
			return 0;
		}
		@Pc(9) int local9 = 0;
		for (@Pc(11) int local11 = 0; local11 < arg1.length; local11++) {
			@Pc(22) char local22 = arg1[arg1.length - local11 - 1];
			if (local22 >= 'a' && local22 <= 'z') {
				local9 = local9 * 38 + local22 + 1 - 'a';
			} else if (local22 == '\'') {
				local9 = local9 * 38 + 27;
			} else if (local22 >= '0' && local22 <= '9') {
				local9 = local9 * 38 + local22 + 28 - '0';
			} else if (local22 != '\u0000') {
				return 0;
			}
		}
		return local9;
	}
}
