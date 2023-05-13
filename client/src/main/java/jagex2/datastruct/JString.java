package jagex2.datastruct;

import jagex2.client.sign.signlink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class JString {

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "Z")
	private static boolean flowObfuscator1;

	@OriginalMember(owner = "client!vb", name = "b", descriptor = "B")
	private static final byte flowObfuscator2 = 25;

	@OriginalMember(owner = "client!vb", name = "c", descriptor = "I")
	private static int flowObfuscator3 = 3;

	@OriginalMember(owner = "client!vb", name = "d", descriptor = "Z")
	private static final boolean flowObfuscator4 = true;

	@OriginalMember(owner = "client!vb", name = "e", descriptor = "I")
	private static int flowObfuscator5 = 629;

	@OriginalMember(owner = "client!vb", name = "f", descriptor = "[C")
	private static final char[] builder = new char[12];

	@OriginalMember(owner = "client!vb", name = "g", descriptor = "[C")
	private static final char[] BASE37_TABLE = new char[] { '_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(Ljava/lang/String;)J")
	public static long toBase37(@OriginalArg(0) String arg0) {
		@Pc(3) long local3 = 0L;
		for (@Pc(5) int local5 = 0; local5 < arg0.length() && local5 < 12; local5++) {
			@Pc(11) char local11 = arg0.charAt(local5);
			local3 *= 37L;
			if (local11 >= 'A' && local11 <= 'Z') {
				local3 += local11 + 1 - 65;
			} else if (local11 >= 'a' && local11 <= 'z') {
				local3 += local11 + 1 - 97;
			} else if (local11 >= '0' && local11 <= '9') {
				local3 += local11 + 27 - 48;
			}
		}
		while (local3 % 37L == 0L && local3 != 0L) {
			local3 /= 37L;
		}
		return local3;
	}

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(JZ)Ljava/lang/String;")
	public static String fromBase37(@OriginalArg(0) long arg0, @OriginalArg(1) boolean arg1) {
		try {
			if (arg0 <= 0L || arg0 >= 6582952005840035281L) {
				return "invalid_name";
			} else if (arg0 % 37L == 0L) {
				return "invalid_name";
			} else {
				@Pc(19) int local19 = 0;
				if (arg1) {
					flowObfuscator5 = -363;
				}
				while (arg0 != 0L) {
					@Pc(27) long local27 = arg0;
					arg0 /= 37L;
					builder[11 - local19++] = BASE37_TABLE[(int) (local27 - arg0 * 37L)];
				}
				return new String(builder, 12 - local19, local19);
			}
		} catch (@Pc(59) RuntimeException local59) {
			signlink.reporterror("15228, " + arg0 + ", " + arg1 + ", " + local59.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(ILjava/lang/String;)J")
	public static long hashCode(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		try {
			if (arg0 != 0) {
				throw new NullPointerException();
			}
			@Pc(8) String local8 = arg1.toUpperCase();
			@Pc(10) long local10 = 0L;
			for (@Pc(12) int local12 = 0; local12 < local8.length(); local12++) {
				local10 = local10 * 61L + (long) local8.charAt(local12) - 32L;
				local10 = local10 + (local10 >> 56) & 0xFFFFFFFFFFFFFFL;
			}
			return local10;
		} catch (@Pc(41) RuntimeException local41) {
			signlink.reporterror("43144, " + arg0 + ", " + arg1 + ", " + local41.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(II)Ljava/lang/String;")
	public static String formatIPv4(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 >= 0) {
				flowObfuscator1 = !flowObfuscator1;
			}
			return (arg1 >> 24 & 0xFF) + "." + (arg1 >> 16 & 0xFF) + "." + (arg1 >> 8 & 0xFF) + "." + (arg1 & 0xFF);
		} catch (@Pc(41) RuntimeException local41) {
			signlink.reporterror("89303, " + arg0 + ", " + arg1 + ", " + local41.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!vb", name = "b", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
	public static String formatName(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		try {
			if (arg0 != 0) {
				throw new NullPointerException();
			} else if (arg1.length() > 0) {
				@Pc(11) char[] local11 = arg1.toCharArray();
				for (@Pc(13) int local13 = 0; local13 < local11.length; local13++) {
					if (local11[local13] == '_') {
						local11[local13] = ' ';
						if (local13 + 1 < local11.length && local11[local13 + 1] >= 'a' && local11[local13 + 1] <= 'z') {
							local11[local13 + 1] = (char) (local11[local13 + 1] + 'A' - 97);
						}
					}
				}
				if (local11[0] >= 'a' && local11[0] <= 'z') {
					local11[0] = (char) (local11[0] + 'A' - 97);
				}
				return new String(local11);
			} else {
				return arg1;
			}
		} catch (@Pc(93) RuntimeException local93) {
			signlink.reporterror("71479, " + arg0 + ", " + arg1 + ", " + local93.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!vb", name = "a", descriptor = "(Ljava/lang/String;I)Ljava/lang/String;")
	public static String toSentenceCase(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(2) String local2 = arg0.toLowerCase();
			if (arg1 != 0) {
				flowObfuscator3 = -18;
			}
			@Pc(9) char[] local9 = local2.toCharArray();
			@Pc(12) int local12 = local9.length;
			@Pc(14) boolean local14 = true;
			for (@Pc(16) int local16 = 0; local16 < local12; local16++) {
				@Pc(22) char local22 = local9[local16];
				if (local14 && local22 >= 'a' && local22 <= 'z') {
					local9[local16] = (char) (local9[local16] - 32);
					local14 = false;
				}
				if (local22 == '.' || local22 == '!') {
					local14 = true;
				}
			}
			return new String(local9);
		} catch (@Pc(58) RuntimeException local58) {
			signlink.reporterror("53394, " + arg0 + ", " + arg1 + ", " + local58.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!vb", name = "c", descriptor = "(ILjava/lang/String;)Ljava/lang/String;")
	public static String toAsterisks(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		try {
			@Pc(1) String local1 = "";
			if (arg0 != 7) {
				throw new NullPointerException();
			}
			for (@Pc(10) int local10 = 0; local10 < arg1.length(); local10++) {
				local1 = local1 + "*";
			}
			return local1;
		} catch (@Pc(29) RuntimeException local29) {
			signlink.reporterror("91128, " + arg0 + ", " + arg1 + ", " + local29.toString());
			throw new RuntimeException();
		}
	}
}
