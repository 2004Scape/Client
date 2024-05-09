package jagex2.wordenc;

import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from rsc
@OriginalClass("client!wb")
public class WordPack {

	@OriginalMember(owner = "client!wb", name = "a", descriptor = "[C")
	private static final char[] charBuffer = new char[100];

	@OriginalMember(owner = "client!wb", name = "b", descriptor = "[C")
	private static final char[] TABLE = new char[] {
		// combined to save space:
		' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u',
		// allowed:
		'm', 'w', 'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
		' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '£', '$', '%', '"', '[', ']'
	};

	@OriginalMember(owner = "client!wb", name = "a", descriptor = "(Lclient!kb;II)Ljava/lang/String;")
	public static String unpack(@OriginalArg(0) Packet word, @OriginalArg(2) int length) {
		@Pc(3) int pos = 0;
		@Pc(5) int carry = -1;

		@Pc(22) int nibble;
		for (@Pc(11) int i = 0; i < length; i++) {
			@Pc(16) int value = word.g1();
			nibble = value >> 4 & 0xF;

			if (carry != -1) {
				charBuffer[pos++] = TABLE[(carry << 4) + nibble - 195];
				carry = -1;
			} else if (nibble < 13) {
				charBuffer[pos++] = TABLE[nibble];
			} else {
				carry = nibble;
			}

			nibble = value & 0xF;
			if (carry != -1) {
				charBuffer[pos++] = TABLE[(carry << 4) + nibble - 195];
				carry = -1;
			} else if (nibble < 13) {
				charBuffer[pos++] = TABLE[nibble];
			} else {
				carry = nibble;
			}
		}

		@Pc(100) boolean uppercase = true;
		for (int i = 0; i < pos; i++) {
			@Pc(108) char c = charBuffer[i];
			if (uppercase && c >= 'a' && c <= 'z') {
				charBuffer[i] = (char) (charBuffer[i] - 32);
				uppercase = false;
			}

			if (c == '.' || c == '!') {
				uppercase = true;
			}
		}
		return new String(charBuffer, 0, pos);
	}

	@OriginalMember(owner = "client!wb", name = "a", descriptor = "(Lclient!kb;ZLjava/lang/String;)V")
	public static void pack(@OriginalArg(0) Packet word, @OriginalArg(2) String str) {
		if (str.length() > 80) {
			str = str.substring(0, 80);
		}
		str = str.toLowerCase();

		@Pc(15) int carry = -1;
		for (@Pc(17) int i = 0; i < str.length(); i++) {
			@Pc(23) char c = str.charAt(i);

			@Pc(25) int index = 0;
			for (@Pc(27) int j = 0; j < TABLE.length; j++) {
				if (c == TABLE[j]) {
					index = j;
					break;
				}
			}

			if (index > 12) {
				index += 195;
			}

			if (carry == -1) {
				if (index < 13) {
					carry = index;
				} else {
					word.p1(index);
				}
			} else if (index < 13) {
				word.p1((carry << 4) + index);
				carry = -1;
			} else {
				word.p1((carry << 4) + (index >> 4));
				carry = index & 0xF;
			}
		}

		if (carry != -1) {
			word.p1(carry << 4);
		}
	}
}
