import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!k")
public final class Class2_Sub1_Sub2 extends Class2_Sub1 {

	@OriginalMember(owner = "mapview!k", name = "g", descriptor = "[I")
	private static int[] anIntArray18 = new int[256];

	@OriginalMember(owner = "mapview!k", name = "h", descriptor = "[I")
	private static final int[] anIntArray19;

	@OriginalMember(owner = "mapview!k", name = "i", descriptor = "I")
	private static int anInt90;

	@OriginalMember(owner = "mapview!k", name = "j", descriptor = "I")
	private static int anInt91;

	@OriginalMember(owner = "mapview!k", name = "k", descriptor = "I")
	private static int anInt92;

	@OriginalMember(owner = "mapview!k", name = "l", descriptor = "Lmapview!l;")
	private static Class3 aClass3_1;

	@OriginalMember(owner = "mapview!k", name = "m", descriptor = "Lmapview!l;")
	private static Class3 aClass3_2;

	@OriginalMember(owner = "mapview!k", name = "n", descriptor = "Lmapview!l;")
	private static Class3 aClass3_3;

	@OriginalMember(owner = "mapview!k", name = "e", descriptor = "[B")
	private byte[] aByteArray3;

	@OriginalMember(owner = "mapview!k", name = "f", descriptor = "I")
	public int anInt89;

	@OriginalMember(owner = "mapview!k", name = "o", descriptor = "[C")
	private char[] aCharArray1 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };

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
			anIntArray18[local4] = local7;
		}
		anIntArray19 = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };
		anInt90 = 0;
		anInt91 = 0;
		anInt92 = 0;
		aClass3_1 = new Class3();
		aClass3_2 = new Class3();
		aClass3_3 = new Class3();
	}

	@OriginalMember(owner = "mapview!k", name = "b", descriptor = "(I)Lmapview!k;")
	public static Class2_Sub1_Sub2 method104(@OriginalArg(0) int arg0) {
		@Pc(4) Class3 local4 = aClass3_2;
		@Pc(7) Class2_Sub1_Sub2 local7;
		synchronized (aClass3_2) {
			local7 = null;
			if (arg0 == 0 && anInt90 > 0) {
				anInt90 += -1;
				local7 = (Class2_Sub1_Sub2) aClass3_1.method106();
			} else if (arg0 == 1 && anInt91 > 0) {
				anInt91 += -1;
				local7 = (Class2_Sub1_Sub2) aClass3_2.method106();
			} else if (arg0 == 2 && anInt92 > 0) {
				anInt92 += -1;
				local7 = (Class2_Sub1_Sub2) aClass3_3.method106();
			}
			if (local7 != null) {
				local7.anInt89 = 0;
				return local7;
			}
		}
		local7 = new Class2_Sub1_Sub2();
		local7.anInt89 = 0;
		if (arg0 == 0) {
			local7.aByteArray3 = new byte[100];
		} else if (arg0 == 1) {
			local7.aByteArray3 = new byte[5000];
		} else {
			local7.aByteArray3 = new byte[30000];
		}
		return local7;
	}

	@OriginalMember(owner = "mapview!k", name = "<init>", descriptor = "()V")
	private Class2_Sub1_Sub2() {
	}

	@OriginalMember(owner = "mapview!k", name = "<init>", descriptor = "([B)V")
	public Class2_Sub1_Sub2(@OriginalArg(0) byte[] arg0) {
		this.aByteArray3 = arg0;
		this.anInt89 = 0;
	}

	@OriginalMember(owner = "mapview!k", name = "b", descriptor = "()I")
	public int method97() {
		this.anInt89 += 4;
		return ((this.aByteArray3[this.anInt89 - 4] & 0xFF) << 24) + ((this.aByteArray3[this.anInt89 - 3] & 0xFF) << 16) + ((this.aByteArray3[this.anInt89 - 2] & 0xFF) << 8) + (this.aByteArray3[this.anInt89 - 1] & 0xFF);
	}

	@OriginalMember(owner = "mapview!k", name = "c", descriptor = "()I")
	public int method98() {
		return this.aByteArray3[this.anInt89++] & 0xFF;
	}

	@OriginalMember(owner = "mapview!k", name = "d", descriptor = "()B")
	public byte method99() {
		return this.aByteArray3[this.anInt89++];
	}

	@OriginalMember(owner = "mapview!k", name = "e", descriptor = "()I")
	public int method100() {
		this.anInt89 += 2;
		return ((this.aByteArray3[this.anInt89 - 2] & 0xFF) << 8) + (this.aByteArray3[this.anInt89 - 1] & 0xFF);
	}

	@OriginalMember(owner = "mapview!k", name = "a", descriptor = "(I)V")
	public void method101(@OriginalArg(0) int arg0) {
		this.aByteArray3[this.anInt89++] = (byte) arg0;
	}

	@OriginalMember(owner = "mapview!k", name = "f", descriptor = "()Ljava/lang/String;")
	public String method102() {
		@Pc(2) int local2 = this.anInt89;
		while (this.aByteArray3[this.anInt89++] != 10) {
		}
		return new String(this.aByteArray3, local2, this.anInt89 - local2 - 1);
	}

	@OriginalMember(owner = "mapview!k", name = "g", descriptor = "()I")
	public int method103() {
		this.anInt89 += 3;
		return ((this.aByteArray3[this.anInt89 - 3] & 0xFF) << 16) + ((this.aByteArray3[this.anInt89 - 2] & 0xFF) << 8) + (this.aByteArray3[this.anInt89 - 1] & 0xFF);
	}

	@OriginalMember(owner = "mapview!k", name = "c", descriptor = "(I)V")
	public void method105(@OriginalArg(0) int arg0) {
		this.aByteArray3[this.anInt89++] = (byte) (arg0 >> 16);
		this.aByteArray3[this.anInt89++] = (byte) (arg0 >> 8);
		this.aByteArray3[this.anInt89++] = (byte) arg0;
	}
}
