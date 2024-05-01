import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!j")
public final class Class1_Sub1_Sub2 extends Class1_Sub1 {

	@OriginalMember(owner = "mapview!j", name = "g", descriptor = "[I")
	private static int[] anIntArray16 = new int[256];

	@OriginalMember(owner = "mapview!j", name = "h", descriptor = "[I")
	private static final int[] anIntArray17;

	@OriginalMember(owner = "mapview!j", name = "l", descriptor = "Lmapview!k;")
	private static Class2 aClass2_1;

	@OriginalMember(owner = "mapview!j", name = "m", descriptor = "Lmapview!k;")
	private static Class2 aClass2_2;

	@OriginalMember(owner = "mapview!j", name = "n", descriptor = "Lmapview!k;")
	private static Class2 aClass2_3;

	@OriginalMember(owner = "mapview!j", name = "o", descriptor = "[C")
	private static char[] aCharArray1;

	@OriginalMember(owner = "mapview!j", name = "e", descriptor = "[B")
	private byte[] aByteArray3;

	@OriginalMember(owner = "mapview!j", name = "f", descriptor = "I")
	public int anInt98;

	static {
		for (@Pc(4) int local4 = 0; local4 < 256; local4++) {
			@Pc(7) int local7 = local4;
			for (@Pc(9) int local9 = 0; local9 < 8; local9++) {
				if ((local7 & 0x1) == 1) {
					local7 = local7 >>> 1 ^ 0xEDB88320;
				} else {
					local7 >>>= 0x1;
				}
			}
			anIntArray16[local4] = local7;
		}
		anIntArray17 = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };
		aClass2_1 = new Class2();
		aClass2_2 = new Class2();
		aClass2_3 = new Class2();
		aCharArray1 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
	}

	@OriginalMember(owner = "mapview!j", name = "<init>", descriptor = "()V")
	private Class1_Sub1_Sub2() {
	}

	@OriginalMember(owner = "mapview!j", name = "<init>", descriptor = "([B)V")
	public Class1_Sub1_Sub2(@OriginalArg(0) byte[] arg0) {
		this.aByteArray3 = arg0;
		this.anInt98 = 0;
	}

	@OriginalMember(owner = "mapview!j", name = "a", descriptor = "()I")
	public int method80() {
		this.anInt98 += 4;
		return ((this.aByteArray3[this.anInt98 - 4] & 0xFF) << 24) + ((this.aByteArray3[this.anInt98 - 3] & 0xFF) << 16) + ((this.aByteArray3[this.anInt98 - 2] & 0xFF) << 8) + (this.aByteArray3[this.anInt98 - 1] & 0xFF);
	}

	@OriginalMember(owner = "mapview!j", name = "b", descriptor = "()I")
	public int method81() {
		return this.aByteArray3[this.anInt98++] & 0xFF;
	}

	@OriginalMember(owner = "mapview!j", name = "c", descriptor = "()B")
	public byte method82() {
		return this.aByteArray3[this.anInt98++];
	}

	@OriginalMember(owner = "mapview!j", name = "d", descriptor = "()I")
	public int method83() {
		this.anInt98 += 2;
		return ((this.aByteArray3[this.anInt98 - 2] & 0xFF) << 8) + (this.aByteArray3[this.anInt98 - 1] & 0xFF);
	}

	@OriginalMember(owner = "mapview!j", name = "e", descriptor = "()Ljava/lang/String;")
	public String method84() {
		@Pc(2) int local2 = this.anInt98;
		while (this.aByteArray3[this.anInt98++] != 10) {
		}
		return new String(this.aByteArray3, local2, this.anInt98 - local2 - 1);
	}

	@OriginalMember(owner = "mapview!j", name = "f", descriptor = "()I")
	public int method85() {
		this.anInt98 += 3;
		return ((this.aByteArray3[this.anInt98 - 3] & 0xFF) << 16) + ((this.aByteArray3[this.anInt98 - 2] & 0xFF) << 8) + (this.aByteArray3[this.anInt98 - 1] & 0xFF);
	}
}
