import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!yb")
public final class SoundTrack {

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "Z")
	private final boolean flowObfuscator1 = true;

	@OriginalMember(owner = "client!yb", name = "b", descriptor = "I")
	public static int flowObfuscator2 = 473;

	@OriginalMember(owner = "client!yb", name = "c", descriptor = "[Lclient!yb;")
	private static final SoundTrack[] aClass43Array1 = new SoundTrack[1000];

	@OriginalMember(owner = "client!yb", name = "d", descriptor = "[I")
	public static final int[] delays = new int[1000];

	@OriginalMember(owner = "client!yb", name = "e", descriptor = "[B")
	public static byte[] aByteArray15;

	@OriginalMember(owner = "client!yb", name = "f", descriptor = "Lclient!kb;")
	public static Buffer aClass1_Sub3_Sub3_23;

	@OriginalMember(owner = "client!yb", name = "g", descriptor = "[Lclient!zb;")
	private final SoundTone[] aClass44Array1 = new SoundTone[10];

	@OriginalMember(owner = "client!yb", name = "h", descriptor = "I")
	private int anInt878;

	@OriginalMember(owner = "client!yb", name = "i", descriptor = "I")
	private int anInt879;

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(Lclient!kb;I)V")
	public static void method561(@OriginalArg(0) Buffer arg0, @OriginalArg(1) int arg1) {
		try {
			aByteArray15 = new byte[441000];
			aClass1_Sub3_Sub3_23 = new Buffer(363, aByteArray15);
			@Pc(12) int local12 = 87 / arg1;
			SoundTone.method575();
			while (true) {
				@Pc(16) int local16 = arg0.method393();
				if (local16 == 65535) {
					return;
				}
				aClass43Array1[local16] = new SoundTrack();
				aClass43Array1[local16].method563(false, arg0);
				delays[local16] = aClass43Array1[local16].method564((byte) 7);
			}
		} catch (@Pc(42) RuntimeException local42) {
			signlink.reporterror("6214, " + arg0 + ", " + arg1 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(BII)Lclient!kb;")
	public static Buffer method562(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 != -16) {
				flowObfuscator2 = -83;
			}
			if (aClass43Array1[arg2] == null) {
				return null;
			} else {
				@Pc(12) SoundTrack local12 = aClass43Array1[arg2];
				return local12.method565(true, arg1);
			}
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("72905, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method563(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			for (@Pc(1) int local1 = 0; local1 < 10; local1++) {
				@Pc(6) int local6 = arg1.method391();
				if (local6 != 0) {
					arg1.position--;
					this.aClass44Array1[local1] = new SoundTone();
					this.aClass44Array1[local1].method578(false, arg1);
				}
			}
			if (arg0) {
				flowObfuscator2 = -307;
			}
			this.anInt878 = arg1.method393();
			this.anInt879 = arg1.method393();
		} catch (@Pc(46) RuntimeException local46) {
			signlink.reporterror("58220, " + arg0 + ", " + arg1 + ", " + local46.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(B)I")
	public int method564(@OriginalArg(0) byte arg0) {
		try {
			@Pc(3) int local3 = 9999999;
			for (@Pc(5) int local5 = 0; local5 < 10; local5++) {
				if (this.aClass44Array1[local5] != null && this.aClass44Array1[local5].anInt948 / 20 < local3) {
					local3 = this.aClass44Array1[local5].anInt948 / 20;
				}
			}
			if (arg0 == 7) {
				@Pc(38) boolean local38 = false;
			} else {
				flowObfuscator2 = -8;
			}
			if (this.anInt878 < this.anInt879 && this.anInt878 / 20 < local3) {
				local3 = this.anInt878 / 20;
			}
			if (local3 == 9999999 || local3 == 0) {
				return 0;
			}
			for (@Pc(67) int local67 = 0; local67 < 10; local67++) {
				if (this.aClass44Array1[local67] != null) {
					this.aClass44Array1[local67].anInt948 -= local3 * 20;
				}
			}
			if (this.anInt878 < this.anInt879) {
				this.anInt878 -= local3 * 20;
				this.anInt879 -= local3 * 20;
			}
			return local3;
		} catch (@Pc(113) RuntimeException local113) {
			signlink.reporterror("49328, " + arg0 + ", " + local113.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(ZI)Lclient!kb;")
	public Buffer method565(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = this.method566(arg1);
			aClass1_Sub3_Sub3_23.position = 0;
			aClass1_Sub3_Sub3_23.method385(1380533830);
			aClass1_Sub3_Sub3_23.method386(false, local3 + 36);
			aClass1_Sub3_Sub3_23.method385(1463899717);
			aClass1_Sub3_Sub3_23.method385(1718449184);
			aClass1_Sub3_Sub3_23.method386(false, 16);
			if (!arg0) {
				for (@Pc(29) int local29 = 1; local29 > 0; local29++) {
				}
			}
			aClass1_Sub3_Sub3_23.method383(this.flowObfuscator1, 1);
			aClass1_Sub3_Sub3_23.method383(this.flowObfuscator1, 1);
			aClass1_Sub3_Sub3_23.method386(false, 22050);
			aClass1_Sub3_Sub3_23.method386(false, 22050);
			aClass1_Sub3_Sub3_23.method383(this.flowObfuscator1, 1);
			aClass1_Sub3_Sub3_23.method383(this.flowObfuscator1, 8);
			aClass1_Sub3_Sub3_23.method385(1684108385);
			aClass1_Sub3_Sub3_23.method386(false, local3);
			aClass1_Sub3_Sub3_23.position += local3;
			return aClass1_Sub3_Sub3_23;
		} catch (@Pc(78) RuntimeException local78) {
			signlink.reporterror("83597, " + arg0 + ", " + arg1 + ", " + local78.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(I)I")
	private int method566(@OriginalArg(0) int arg0) {
		@Pc(3) int local3 = 0;
		for (@Pc(5) int local5 = 0; local5 < 10; local5++) {
			if (this.aClass44Array1[local5] != null && this.aClass44Array1[local5].anInt947 + this.aClass44Array1[local5].anInt948 > local3) {
				local3 = this.aClass44Array1[local5].anInt947 + this.aClass44Array1[local5].anInt948;
			}
		}
		if (local3 == 0) {
			return 0;
		}
		@Pc(51) int local51 = local3 * 22050 / 1000;
		@Pc(58) int local58 = this.anInt878 * 22050 / 1000;
		@Pc(65) int local65 = this.anInt879 * 22050 / 1000;
		if (local58 < 0 || local58 > local51 || local65 < 0 || local65 > local51 || local58 >= local65) {
			arg0 = 0;
		}
		@Pc(90) int local90 = local51 + (local65 - local58) * (arg0 - 1);
		for (@Pc(92) int local92 = 44; local92 < local90 + 44; local92++) {
			aByteArray15[local92] = -128;
		}
		@Pc(123) int local123;
		@Pc(133) int local133;
		@Pc(147) int local147;
		for (@Pc(106) int local106 = 0; local106 < 10; local106++) {
			if (this.aClass44Array1[local106] != null) {
				local123 = this.aClass44Array1[local106].anInt947 * 22050 / 1000;
				local133 = this.aClass44Array1[local106].anInt948 * 22050 / 1000;
				@Pc(145) int[] local145 = this.aClass44Array1[local106].method576(local123, this.aClass44Array1[local106].anInt947);
				for (local147 = 0; local147 < local123; local147++) {
					aByteArray15[local147 + local133 + 44] += (byte) (local145[local147] >> 8);
				}
			}
		}
		if (arg0 > 1) {
			local58 += 44;
			local65 += 44;
			local51 += 44;
			local90 += 44;
			local123 = local90 - local51;
			for (local133 = local51 - 1; local133 >= local65; local133--) {
				aByteArray15[local133 + local123] = aByteArray15[local133];
			}
			for (@Pc(205) int local205 = 1; local205 < arg0; local205++) {
				local123 = (local65 - local58) * local205;
				for (local147 = local58; local147 < local65; local147++) {
					aByteArray15[local147 + local123] = aByteArray15[local147];
				}
			}
			local90 -= 44;
		}
		return local90;
	}
}
