package jagex2.wordenc;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from rsc
@OriginalClass("client!mc")
public class WordFilter {

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
	public static void unpack(@OriginalArg(0) Jagfile jag) {
		@Pc(11) Packet fragments = new Packet(jag.read("fragmentsenc.txt", null));
		@Pc(21) Packet bad = new Packet(jag.read("badenc.txt", null));
		@Pc(31) Packet domain = new Packet(jag.read("domainenc.txt", null));
		@Pc(41) Packet tld = new Packet(jag.read("tldlist.txt", null));
		read(bad, domain, fragments, tld);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!kb;Lclient!kb;Lclient!kb;Lclient!kb;)V")
	private static void read(@OriginalArg(1) Packet bad, @OriginalArg(2) Packet domain, @OriginalArg(0) Packet fragments, @OriginalArg(3) Packet tld) {
		readBadWords(bad);
		readDomains(domain);
		readFragments(fragments);
		readTld(tld);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ZLclient!kb;)V")
	private static void readTld(@OriginalArg(1) Packet buf) {
		@Pc(4) int count = buf.g4();
		tlds = new char[count][];
		tldType = new int[count];
		for (@Pc(15) int i = 0; i < count; i++) {
			tldType[i] = buf.g1();
			@Pc(26) char[] tld = new char[buf.g1()];
			for (@Pc(28) int j = 0; j < tld.length; j++) {
				tld[j] = (char) buf.g1();
			}
			tlds[i] = tld;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ILclient!kb;)V")
	private static void readBadWords(@OriginalArg(1) Packet buf) {
		@Pc(2) int count = buf.g4();
		badWords = new char[count][];
		badCombinations = new byte[count][][];
		readBadCombinations(buf, badWords, badCombinations);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Lclient!kb;I)V")
	private static void readDomains(@OriginalArg(0) Packet buf) {
		@Pc(2) int count = buf.g4();
		domains = new char[count][];
		readDomain(buf, domains);
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(ILclient!kb;)V")
	private static void readFragments(@OriginalArg(1) Packet buf) {
		fragments = new int[buf.g4()];
		for (@Pc(5) int i = 0; i < fragments.length; i++) {
			fragments[i] = buf.g2();
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([[[B[[CLclient!kb;B)V")
	private static void readBadCombinations(@OriginalArg(2) Packet buf, @OriginalArg(1) char[][] badwords, @OriginalArg(0) byte[][][] badCombinations) {
		for (@Pc(10) int i = 0; i < badwords.length; i++) {
			@Pc(17) char[] badword = new char[buf.g1()];
			for (@Pc(19) int j = 0; j < badword.length; j++) {
				badword[j] = (char) buf.g1();
			}
			badwords[i] = badword;
			@Pc(41) byte[][] combination = new byte[buf.g1()][2];
			for (@Pc(43) int j = 0; j < combination.length; j++) {
				combination[j][0] = (byte) buf.g1();
				combination[j][1] = (byte) buf.g1();
			}
			if (combination.length > 0) {
				badCombinations[i] = combination;
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ILclient!kb;[[C)V")
	private static void readDomain(@OriginalArg(1) Packet buf, @OriginalArg(2) char[][] domains) {
		for (@Pc(5) int i = 0; i < domains.length; i++) {
			@Pc(20) char[] domain = new char[buf.g1()];
			for (@Pc(22) int j = 0; j < domain.length; j++) {
				domain[j] = (char) buf.g1();
			}
			domains[i] = domain;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CI)V")
	private static void filterCharacters(@OriginalArg(0) char[] in) {
		@Pc(3) int pos = 0;
		for (@Pc(5) int i = 0; i < in.length; i++) {
			if (allowCharacter(in[i])) {
				in[pos] = in[i];
			} else {
				in[pos] = ' ';
			}
			if (pos == 0 || in[pos] != ' ' || in[pos - 1] != ' ') {
				pos++;
			}
		}
		for (@Pc(55) int i = pos; i < in.length; i++) {
			in[i] = ' ';
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(IC)Z")
	private static boolean allowCharacter(@OriginalArg(1) char c) {
		return c >= ' ' && c <= '\u007f' || c == ' ' || c == '\n' || c == '\t' || c == '£' || c == '€';
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String filter(@OriginalArg(0) String input) {
		@Pc(3) long start = System.currentTimeMillis();
		@Pc(6) char[] outputPre = input.toCharArray();
		filterCharacters(outputPre);
		@Pc(15) String trimmed = (new String(outputPre)).trim();
		@Pc(19) char[] output = trimmed.toLowerCase().toCharArray();
		@Pc(22) String lowercase = trimmed.toLowerCase();
		filterTld(output);
		filterBad(output);
		filterDomains(output);
		filterFragments(output);
		@Pc(45) int j;
		for (@Pc(36) int i = 0; i < ALLOWLIST.length; i++) {
			j = -1;
			while ((j = lowercase.indexOf(ALLOWLIST[i], j + 1)) != -1) {
				@Pc(52) char[] allowed = ALLOWLIST[i].toCharArray();
				System.arraycopy(allowed, 0, output, 0 + j, allowed.length);
			}
		}
		replaceUpperCases(output, trimmed.toCharArray());
		formatUpperCases(output);
		@Pc(105) long end = System.currentTimeMillis();
		return (new String(output)).trim();
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CI[C)V")
	private static void replaceUpperCases(@OriginalArg(0) char[] in, @OriginalArg(2) char[] unfiltered) {
		for (@Pc(1) int i = 0; i < unfiltered.length; i++) {
			if (in[i] != '*' && isUpperCase(unfiltered[i])) {
				in[i] = unfiltered[i];
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(B[C)V")
	private static void formatUpperCases(@OriginalArg(1) char[] in) {
		@Pc(3) boolean upper = true;
		for (@Pc(12) int i = 0; i < in.length; i++) {
			@Pc(19) char c = in[i];
			if (!isAlpha(c)) {
				upper = true;
			} else if (upper) {
				if (isLowerCase(c)) {
					upper = false;
				}
			} else if (isUpperCase(c)) {
				in[i] = (char) (c + 'a' - 65);
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(Z[C)V")
	private static void filterBad(@OriginalArg(1) char[] in) {
		for (@Pc(3) int passes = 0; passes < 2; passes++) {
			for (@Pc(10) int i = badWords.length - 1; i >= 0; i--) {
				filter(badCombinations[i], in, badWords[i]);
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(B[C)V")
	private static void filterDomains(@OriginalArg(1) char[] in) {
		@Pc(3) char[] filteredAt = (char[]) in.clone();
		@Pc(18) char[] at = new char[] { '(', 'a', ')' };
		filter(null, filteredAt, at);
		@Pc(27) char[] filteredDot = (char[]) in.clone();
		@Pc(42) char[] dot = new char[] { 'd', 'o', 't' };
		filter(null, filteredDot, dot);
		for (@Pc(56) int i = domains.length - 1; i >= 0; i--) {
			filterDomain(filteredDot, filteredAt, domains[i], in);
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CI[C[C[C)V")
	private static void filterDomain(@OriginalArg(0) char[] filteredDot, @OriginalArg(2) char[] filteredAt, @OriginalArg(3) char[] domain, @OriginalArg(4) char[] in) {
		if (domain.length <= in.length) {
			@Pc(23) int stride;
			for (@Pc(15) int start = 0; start <= in.length - domain.length; start += stride) {
				@Pc(19) int end = start;
				@Pc(21) int offset = 0;
				stride = 1;
				@Pc(27) boolean match;
				filter_pass:
				while (true) {
					while (true) {
						if (end >= in.length) {
							break filter_pass;
						}
						match = false;
						@Pc(31) char b = in[end];
						@Pc(33) char c = 0;
						if (end + 1 < in.length) {
							c = in[end + 1];
						}
						@Pc(58) int charSize;
						if (offset < domain.length && (charSize = getEmulatedDomainCharSize(c, domain[offset], b)) > 0) {
							end += charSize;
							offset++;
						} else {
							if (offset == 0) {
								break filter_pass;
							}
							@Pc(79) int charSize2;
							if ((charSize2 = getEmulatedDomainCharSize(c, domain[offset - 1], b)) > 0) {
								end += charSize2;
								if (offset == 1) {
									stride++;
								}
							} else {
								if (offset >= domain.length || !isSymbol(b)) {
									break filter_pass;
								}
								end++;
							}
						}
					}
				}
				if (offset >= domain.length) {
					match = false;
					@Pc(116) int atFilter = getDomainAtFilterStatus(start, in, filteredAt);
					@Pc(124) int dotFilter = getDomainDotFilterStatus(in, filteredDot, end - 1);
					if (atFilter > 2 || dotFilter > 2) {
						match = true;
					}
					if (match) {
						for (@Pc(136) int i = start; i < end; i++) {
							in[i] = '*';
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(I[CB[C)I")
	private static int getDomainAtFilterStatus(@OriginalArg(0) int end, @OriginalArg(1) char[] a, @OriginalArg(3) char[] b) {
		if (end == 0) {
			return 2;
		}
		for (@Pc(9) int i = end - 1; i >= 0 && isSymbol(a[i]); i--) {
			if (a[i] == '@') {
				return 3;
			}
		}
		@Pc(37) int asteriskCount = 0;
		for (@Pc(41) int i = end - 1; i >= 0 && isSymbol(b[i]); i--) {
			if (b[i] == '*') {
				asteriskCount++;
			}
		}
		if (asteriskCount >= 3) {
			return 4;
		} else if (isSymbol(a[end - 1])) {
			return 1;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([C[CII)I")
	private static int getDomainDotFilterStatus(@OriginalArg(1) char[] a, @OriginalArg(0) char[] b, @OriginalArg(2) int start) {
		if (start + 1 == a.length) {
			return 2;
		} else {
			@Pc(17) int i = start + 1;
			while (true) {
				if (i < a.length && isSymbol(a[i])) {
					if (a[i] != '.' && a[i] != ',') {
						i++;
						continue;
					}
					return 3;
				}
				@Pc(44) int asteriskCount = 0;
				for (@Pc(48) int j = start + 1; j < a.length && isSymbol(b[j]); j++) {
					if (b[j] == '*') {
						asteriskCount++;
					}
				}
				if (asteriskCount >= 3) {
					return 4;
				}
				if (isSymbol(a[start + 1])) {
					return 1;
				}
				return 0;
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "([CI)V")
	private static void filterTld(@OriginalArg(0) char[] in) {
		@Pc(3) char[] filteredDot = (char[]) in.clone();
		@Pc(18) char[] dot = new char[] { 'd', 'o', 't' };
		filter(null, filteredDot, dot);
		@Pc(27) char[] filteredSlash = (char[]) in.clone();
		@Pc(50) char[] slash = new char[] { 's', 'l', 'a', 's', 'h' };
		filter(null, filteredSlash, slash);
		for (@Pc(65) int i = 0; i < tlds.length; i++) {
			filterTld(filteredSlash, tldType[i], in, tlds[i], filteredDot);
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CIZ[C[C[C)V")
	private static void filterTld(@OriginalArg(0) char[] filteredSlash, @OriginalArg(1) int type, @OriginalArg(3) char[] chars, @OriginalArg(4) char[] tld, @OriginalArg(5) char[] filteredDot) {
		@Pc(5) int stride;
		if (tld.length <= chars.length) {
			@Pc(18) boolean compare = true;
			for (@Pc(20) int start = 0; start <= chars.length - tld.length; start += stride) {
				@Pc(24) int end = start;
				@Pc(26) int offset = 0;
				stride = 1;
				@Pc(32) boolean match;
				filter_pass:
				while (true) {
					while (true) {
						if (end >= chars.length) {
							break filter_pass;
						}
						match = false;
						@Pc(36) char b = chars[end];
						@Pc(38) char c = 0;
						if (end + 1 < chars.length) {
							c = chars[end + 1];
						}
						@Pc(63) int charLen;
						if (offset < tld.length && (charLen = getEmulatedDomainCharSize(c, tld[offset], b)) > 0) {
							end += charLen;
							offset++;
						} else {
							if (offset == 0) {
								break filter_pass;
							}
							@Pc(84) int charLen2;
							if ((charLen2 = getEmulatedDomainCharSize(c, tld[offset - 1], b)) > 0) {
								end += charLen2;
								if (offset == 1) {
									stride++;
								}
							} else {
								if (offset >= tld.length || !isSymbol(b)) {
									break filter_pass;
								}
								end++;
							}
						}
					}
				}
				if (offset >= tld.length) {
					match = false;
					@Pc(121) int status0 = getTldDotFilterStatus(chars, filteredDot, start);
					@Pc(129) int status1 = getTldSlashFilterStatus(filteredSlash, end - 1, chars);
					if (type == 1 && status0 > 0 && status1 > 0) {
						match = true;
					}
					if (type == 2 && (status0 > 2 && status1 > 0 || status0 > 0 && status1 > 2)) {
						match = true;
					}
					if (type == 3 && status0 > 0 && status1 > 2) {
						match = true;
					}
					@Pc(172) boolean lastCheck = type == 3 && status0 > 2 && status1 > 0;
					if (match) {
						@Pc(179) int first = start;
						@Pc(183) int last = end - 1;
						@Pc(191) boolean findStart;
						@Pc(195) int i;
						if (status0 > 2) {
							if (status0 == 4) {
								findStart = false;
								for (i = start - 1; i >= 0; i--) {
									if (findStart) {
										if (filteredDot[i] != '*') {
											break;
										}
										first = i;
									} else if (filteredDot[i] == '*') {
										first = i;
										findStart = true;
									}
								}
							}
							findStart = false;
							for (i = first - 1; i >= 0; i--) {
								if (findStart) {
									if (isSymbol(chars[i])) {
										break;
									}
									first = i;
								} else if (!isSymbol(chars[i])) {
									findStart = true;
									first = i;
								}
							}
						}
						if (status1 > 2) {
							if (status1 == 4) {
								findStart = false;
								for (i = last + 1; i < chars.length; i++) {
									if (findStart) {
										if (filteredSlash[i] != '*') {
											break;
										}
										last = i;
									} else if (filteredSlash[i] == '*') {
										last = i;
										findStart = true;
									}
								}
							}
							findStart = false;
							for (i = last + 1; i < chars.length; i++) {
								if (findStart) {
									if (isSymbol(chars[i])) {
										break;
									}
									last = i;
								} else if (!isSymbol(chars[i])) {
									findStart = true;
									last = i;
								}
							}
						}
						for (@Pc(329) int j = first; j <= last; j++) {
							chars[j] = '*';
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CZ[CI)I")
	private static int getTldDotFilterStatus(@OriginalArg(0) char[] a, @OriginalArg(2) char[] b, @OriginalArg(3) int start) {
		if (start == 0) {
			return 2;
		}
		@Pc(9) int i = start - 1;
		while (true) {
			if (i >= 0 && isSymbol(a[i])) {
				if (a[i] != ',' && a[i] != '.') {
					i--;
					continue;
				}
				return 3;
			}
			@Pc(34) int asteriskCount = 0;
			@Pc(38) int j;
			for (j = start - 1; j >= 0 && isSymbol(b[j]); j--) {
				if (b[j] == '*') {
					asteriskCount++;
				}
			}
			if (asteriskCount >= 3) {
				return 4;
			}
			if (isSymbol(a[start - 1])) {
				return 1;
			}
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "([CII[C)I")
	private static int getTldSlashFilterStatus(@OriginalArg(0) char[] b, @OriginalArg(2) int end, @OriginalArg(3) char[] a) {
		if (end + 1 == a.length) {
			return 2;
		}
		@Pc(13) int i = end + 1;
		while (true) {
			if (i < a.length && isSymbol(a[i])) {
				if (a[i] != '\\' && a[i] != '/') {
					i++;
					continue;
				}
				return 3;
			}
			@Pc(40) int asteriskCount = 0;
			for (@Pc(44) int j = end + 1; j < a.length && isSymbol(b[j]); j++) {
				if (b[j] == '*') {
					asteriskCount++;
				}
			}
			if (asteriskCount >= 5) {
				return 4;
			}
			if (isSymbol(a[end + 1])) {
				return 1;
			}
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(B[[B[C[C)V")
	private static void filter(@OriginalArg(1) byte[][] badCombinations, @OriginalArg(2) char[] chars, @OriginalArg(3) char[] fragment) {
		if (fragment.length <= chars.length) {
			@Pc(9) boolean compare = true;
			@Pc(26) int stride;
			for (@Pc(16) int start = 0; start <= chars.length - fragment.length; start += stride) {
				@Pc(20) int end = start;
				@Pc(22) int fragOff = 0;
				@Pc(24) int iterations = 0;
				stride = 1;
				@Pc(28) boolean isSymbol = false;
				@Pc(30) boolean isEmulated = false;
				@Pc(32) boolean isNumeral = false;
				@Pc(36) boolean bad;
				@Pc(40) char b;
				@Pc(42) char c;
				label163:
				while (true) {
					while (true) {
						if (end >= chars.length || isEmulated && isNumeral) {
							break label163;
						}
						bad = false;
						b = chars[end];
						c = '\0';
						if (end + 1 < chars.length) {
							c = chars[end + 1];
						}
						@Pc(67) int charLen;
						if (fragOff < fragment.length && (charLen = getEmulatedSize(c, fragment[fragOff], b)) > 0) {
							if (charLen == 1 && isNumber(b)) {
								isEmulated = true;
							}
							if (charLen == 2 && (isNumber(b) || isNumber(c))) {
								isEmulated = true;
							}
							end += charLen;
							fragOff++;
						} else {
							if (fragOff == 0) {
								break label163;
							}
							@Pc(110) int charLen2;
							if ((charLen2 = getEmulatedSize(c, fragment[fragOff - 1], b)) > 0) {
								end += charLen2;
								if (fragOff == 1) {
									stride++;
								}
							} else {
								if (fragOff >= fragment.length || !isLowerCaseAlpha(b)) {
									break label163;
								}
								if (isSymbol(b) && b != '\'') {
									isSymbol = true;
								}
								if (isNumber(b)) {
									isNumeral = true;
								}
								end++;
								iterations++;
								if (iterations * 100 / (end - start) > 90) {
									break label163;
								}
							}
						}
					}
				}
				if (fragOff >= fragment.length && (!isEmulated || !isNumeral)) {
					bad = true;
					@Pc(271) int cur;
					if (isSymbol) {
						@Pc(221) boolean badCurrent = false;
						@Pc(223) boolean badNext = false;
						if (start - 1 < 0 || isSymbol(chars[start - 1]) && chars[start - 1] != '\'') {
							badCurrent = true;
						}
						if (end >= chars.length || isSymbol(chars[end]) && chars[end] != '\'') {
							badNext = true;
						}
						if (!badCurrent || !badNext) {
							@Pc(267) boolean good = false;
							cur = start - 2;
							if (badCurrent) {
								cur = start;
							}
							while (!good && cur < end) {
								if (cur >= 0 && (!isSymbol(chars[cur]) || chars[cur] == '\'')) {
									@Pc(293) char[] frag = new char[3];
									@Pc(295) int off;
									for (off = 0; off < 3 && cur + off < chars.length && (!isSymbol(chars[cur + off]) || chars[cur + off] == '\''); off++) {
										frag[off] = chars[cur + off];
									}
									@Pc(333) boolean valid = off != 0;
									if (off < 3 && cur - 1 >= 0 && (!isSymbol(chars[cur - 1]) || chars[cur - 1] == '\'')) {
										valid = false;
									}
									if (valid && !isBadFragment(frag)) {
										good = true;
									}
								}
								cur++;
							}
							if (!good) {
								bad = false;
							}
						}
					} else {
						b = ' ';
						if (start - 1 >= 0) {
							b = chars[start - 1];
						}
						c = ' ';
						if (end < chars.length) {
							c = chars[end];
						}
						@Pc(203) byte bIndex = getIndex(b);
						@Pc(207) byte cIndex = getIndex(c);
						if (badCombinations != null && comboMatches(bIndex, badCombinations, cIndex)) {
							bad = false;
						}
					}
					if (bad) {
						@Pc(383) int numeralCount = 0;
						@Pc(385) int alphaCount = 0;
						for (@Pc(387) int n = start; n < end; n++) {
							if (isNumber(chars[n])) {
								numeralCount++;
							} else if (isAlpha(chars[n])) {
								alphaCount++;
							}
						}
						if (numeralCount <= alphaCount) {
							for (cur = start; cur < end; cur++) {
								chars[cur] = '*';
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(IB[[BB)Z")
	private static boolean comboMatches(@OriginalArg(1) byte a, @OriginalArg(2) byte[][] combos, @OriginalArg(3) byte b) {
		@Pc(9) int first = 0;
		if (combos[first][0] == a && combos[first][1] == b) {
			return true;
		}
		@Pc(30) int last = combos.length - 1;
		if (combos[last][0] == a && combos[last][1] == b) {
			return true;
		}
		do {
			@Pc(52) int middle = (first + last) / 2;
			if (combos[middle][0] == a && combos[middle][1] == b) {
				return true;
			}
			if (a < combos[middle][0] || a == combos[middle][0] && b < combos[middle][1]) {
				last = middle;
			} else {
				first = middle;
			}
		} while (first != last && first + 1 != last);
		return false;
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(ICCC)I")
	private static int getEmulatedDomainCharSize(@OriginalArg(1) char c, @OriginalArg(2) char a, @OriginalArg(3) char b) {
		if (a == b) {
			return 1;
		} else if (a == 'o' && b == '0') {
			return 1;
		} else if (a == 'o' && b == '(' && c == ')') {
			return 2;
		} else if (a == 'c' && (b == '(' || b == '<' || b == '[')) {
			return 1;
		} else if (a == 'e' && b == '€') {
			return 1;
		} else if (a == 's' && b == '$') {
			return 1;
		} else if (a == 'l' && b == 'i') {
			return 1;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(CCCI)I")
	private static int getEmulatedSize(@OriginalArg(0) char c, @OriginalArg(1) char a, @OriginalArg(2) char b) {
		if (a == b) {
			return 1;
		}
		if (a >= 'a' && a <= 'm') {
			if (a == 'a') {
				if (b != '4' && b != '@' && b != '^') {
					if (b == '/' && c == '\\') {
						return 2;
					}
					return 0;
				}
				return 1;
			}
			if (a == 'b') {
				if (b != '6' && b != '8') {
					if (b == '1' && c == '3') {
						return 2;
					}
					return 0;
				}
				return 1;
			}
			if (a == 'c') {
				if (b != '(' && b != '<' && b != '{' && b != '[') {
					return 0;
				}
				return 1;
			}
			if (a == 'd') {
				if (b == '[' && c == ')') {
					return 2;
				}
				return 0;
			}
			if (a == 'e') {
				if (b != '3' && b != '€') {
					return 0;
				}
				return 1;
			}
			if (a == 'f') {
				if (b == 'p' && c == 'h') {
					return 2;
				}
				if (b == '£') {
					return 1;
				}
				return 0;
			}
			if (a == 'g') {
				if (b != '9' && b != '6') {
					return 0;
				}
				return 1;
			}
			if (a == 'h') {
				if (b == '#') {
					return 1;
				}
				return 0;
			}
			if (a == 'i') {
				if (b != 'y' && b != 'l' && b != 'j' && b != '1' && b != '!' && b != ':' && b != ';' && b != '|') {
					return 0;
				}
				return 1;
			}
			if (a == 'j') {
				return 0;
			}
			if (a == 'k') {
				return 0;
			}
			if (a == 'l') {
				if (b != '1' && b != '|' && b != 'i') {
					return 0;
				}
				return 1;
			}
			if (a == 'm') {
				return 0;
			}
		}
		if (a >= 'n' && a <= 'z') {
			if (a == 'n') {
				return 0;
			}
			if (a == 'o') {
				if (b != '0' && b != '*') {
					if ((b != '(' || c != ')') && (b != '[' || c != ']') && (b != '{' || c != '}') && (b != '<' || c != '>')) {
						return 0;
					}
					return 2;
				}
				return 1;
			}
			if (a == 'p') {
				return 0;
			}
			if (a == 'q') {
				return 0;
			}
			if (a == 'r') {
				return 0;
			}
			if (a == 's') {
				if (b != '5' && b != 'z' && b != '$' && b != '2') {
					return 0;
				}
				return 1;
			}
			if (a == 't') {
				if (b != '7' && b != '+') {
					return 0;
				}
				return 1;
			}
			if (a == 'u') {
				if (b == 'v') {
					return 1;
				}
				if (b == '\\' && c == '/' || b == '\\' && c == '|' || b == '|' && c == '/') {
					return 2;
				}
				return 0;
			}
			if (a == 'v') {
				if ((b != '\\' || c != '/') && (b != '\\' || c != '|') && (b != '|' || c != '/')) {
					return 0;
				}
				return 2;
			}
			if (a == 'w') {
				if (b == 'v' && c == 'v') {
					return 2;
				}
				return 0;
			}
			if (a == 'x') {
				if ((b != ')' || c != '(') && (b != '}' || c != '{') && (b != ']' || c != '[') && (b != '>' || c != '<')) {
					return 0;
				}
				return 2;
			}
			if (a == 'y') {
				return 0;
			}
			if (a == 'z') {
				return 0;
			}
		}
		if (a >= '0' && a <= '9') {
			if (a == '0') {
				if (b == 'o' || b == 'O') {
					return 1;
				} else if ((b != '(' || c != ')') && (b != '{' || c != '}') && (b != '[' || c != ']')) {
					return 0;
				} else {
					return 2;
				}
			} else if (a == '1') {
				return b == 'l' ? 1 : 0;
			} else {
				return 0;
			}
		} else if (a == ',') {
			return b == '.' ? 1 : 0;
		} else if (a == '.') {
			return b == ',' ? 1 : 0;
		} else if (a == '!') {
			return b == 'i' ? 1 : 0;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(IC)B")
	private static byte getIndex(@OriginalArg(1) char c) {
		if (c >= 'a' && c <= 'z') {
			return (byte) (c + 1 - 'a');
		} else if (c == '\'') {
			return 28;
		} else if (c >= '0' && c <= '9') {
			return (byte) (c + 29 - '0');
		} else {
			return 27;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(I[C)V")
	private static void filterFragments(@OriginalArg(1) char[] chars) {
		@Pc(3) boolean compare = false;
		@Pc(5) int end = 0;
		@Pc(11) int count = 0;
		@Pc(13) int start = 0;
		while (true) {
			do {
				@Pc(112) int index;
				if ((index = indexOfNumber(chars, end)) == -1) {
					return;
				}
				@Pc(17) boolean foundLowercase = false;
				for (@Pc(19) int i = end; i >= 0 && i < index && !foundLowercase; i++) {
					if (!isSymbol(chars[i]) && !isLowerCaseAlpha(chars[i])) {
						foundLowercase = true;
					}
				}
				if (foundLowercase) {
					count = 0;
				}
				if (count == 0) {
					start = index;
				}
				end = indexOfNonNumber(index, chars);
				@Pc(58) int value = 0;
				for (@Pc(60) int i = index; i < end; i++) {
					value = value * 10 + chars[i] - 48;
				}
				if (value <= 255 && end - index <= 8) {
					count++;
				} else {
					count = 0;
				}
			} while (count != 4);
			for (@Pc(94) int i = start; i < end; i++) {
				chars[i] = '*';
			}
			count = 0;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(I[CI)I")
	private static int indexOfNumber(@OriginalArg(1) char[] input, @OriginalArg(2) int off) {
		for (@Pc(5) int i = off; i < input.length && i >= 0; i++) {
			if (input[i] >= '0' && input[i] <= '9') {
				return i;
			}
		}
		return -1;
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(II[C)I")
	private static int indexOfNonNumber(@OriginalArg(1) int off, @OriginalArg(2) char[] input) {
		@Pc(6) int i = off;
		while (true) {
			if (i < input.length && i >= 0) {
				if (input[i] >= '0' && input[i] <= '9') {
					i++;
					continue;
				}
				return i;
			}
			return input.length;
		}
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(CI)Z")
	private static boolean isSymbol(@OriginalArg(0) char c) {
		return !isAlpha(c) && !isNumber(c);
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(CB)Z")
	private static boolean isLowerCaseAlpha(@OriginalArg(0) char c) {
		if (c >= 'a' && c <= 'z') {
			return c == 'v' || c == 'x' || c == 'j' || c == 'q' || c == 'z';
		} else {
			return true;
		}
	}

	@OriginalMember(owner = "client!mc", name = "c", descriptor = "(IC)Z")
	private static boolean isAlpha(@OriginalArg(1) char c) {
		return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(CI)Z")
	private static boolean isNumber(@OriginalArg(0) char c) {
		return c >= '0' && c <= '9';
	}

	@OriginalMember(owner = "client!mc", name = "a", descriptor = "(BC)Z")
	private static boolean isLowerCase(@OriginalArg(1) char c) {
		return c >= 'a' && c <= 'z';
	}

	@OriginalMember(owner = "client!mc", name = "d", descriptor = "(IC)Z")
	private static boolean isUpperCase(@OriginalArg(1) char c) {
		return c >= 'A' && c <= 'Z';
	}

	@OriginalMember(owner = "client!mc", name = "c", descriptor = "([CI)Z")
	private static boolean isBadFragment(@OriginalArg(0) char[] input) {
		@Pc(3) boolean skip = true;
		for (@Pc(5) int i = 0; i < input.length; i++) {
			if (!isNumber(input[i]) && input[i] != '\0') {
				skip = false;
				break;
			}
		}
		if (skip) {
			return true;
		}
		@Pc(32) int i = firstFragmentId(input);
		@Pc(34) int start = 0;
		@Pc(39) int end;
		end = fragments.length - 1;
		if (i == fragments[start] || i == fragments[end]) {
			return true;
		}
		do {
			@Pc(67) int middle = (start + end) / 2;
			if (i == fragments[middle]) {
				return true;
			}
			if (i < fragments[middle]) {
				end = middle;
			} else {
				start = middle;
			}
		} while (start != end && start + 1 != end);
		return false;
	}

	@OriginalMember(owner = "client!mc", name = "b", descriptor = "(I[C)I")
	private static int firstFragmentId(@OriginalArg(1) char[] chars) {
		if (chars.length > 6) {
			return 0;
		}
		@Pc(9) int value = 0;
		for (@Pc(11) int i = 0; i < chars.length; i++) {
			@Pc(22) char c = chars[chars.length - i - 1];
			if (c >= 'a' && c <= 'z') {
				value = value * 38 + c + 1 - 'a';
			} else if (c == '\'') {
				value = value * 38 + 27;
			} else if (c >= '0' && c <= '9') {
				value = value * 38 + c + 28 - '0';
			} else if (c != '\0') {
				return 0;
			}
		}
		return value;
	}
}
