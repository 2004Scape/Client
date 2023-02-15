import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!ub")
public final class FileArchive {

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "Z")
	private final boolean flowObfuscator1 = false;

	@OriginalMember(owner = "client!ub", name = "b", descriptor = "B")
	private final byte flowObfuscator2 = 2;

	@OriginalMember(owner = "client!ub", name = "c", descriptor = "I")
	private final int flowObfuscator3 = 40267;

	@OriginalMember(owner = "client!ub", name = "d", descriptor = "Z")
	private final boolean flowObfuscator4 = false;

	@OriginalMember(owner = "client!ub", name = "e", descriptor = "[B")
	private byte[] aByteArray14;

	@OriginalMember(owner = "client!ub", name = "f", descriptor = "I")
	private int anInt763;

	@OriginalMember(owner = "client!ub", name = "g", descriptor = "[I")
	private int[] anIntArray221;

	@OriginalMember(owner = "client!ub", name = "h", descriptor = "[I")
	private int[] anIntArray222;

	@OriginalMember(owner = "client!ub", name = "i", descriptor = "[I")
	private int[] anIntArray223;

	@OriginalMember(owner = "client!ub", name = "j", descriptor = "[I")
	private int[] anIntArray224;

	@OriginalMember(owner = "client!ub", name = "k", descriptor = "Z")
	private boolean aBoolean150;

	@OriginalMember(owner = "client!ub", name = "<init>", descriptor = "([BZ)V")
	public FileArchive(@OriginalArg(0) byte[] arg0, @OriginalArg(1) boolean arg1) {
		try {
			if (arg1) {
				for (@Pc(17) int local17 = 1; local17 > 0; local17++) {
				}
			}
			this.method535(true, arg0);
		} catch (@Pc(28) RuntimeException local28) {
			signlink.reporterror("94335, " + arg0 + ", " + arg1 + ", " + local28.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "(Z[B)V")
	private void method535(@OriginalArg(0) boolean arg0, @OriginalArg(1) byte[] arg1) {
		try {
			@Pc(7) Buffer local7 = new Buffer(363, arg1);
			@Pc(10) int local10 = local7.method395();
			@Pc(13) int local13 = local7.method395();
			if (local13 == local10) {
				this.aByteArray14 = arg1;
				this.aBoolean150 = false;
			} else {
				@Pc(19) byte[] local19 = new byte[local10];
				BZip2InputStream.method519(local19, local10, arg1, local13, 6);
				this.aByteArray14 = local19;
				local7 = new Buffer(363, this.aByteArray14);
				this.aBoolean150 = true;
			}
			this.anInt763 = local7.method393();
			this.anIntArray221 = new int[this.anInt763];
			this.anIntArray222 = new int[this.anInt763];
			this.anIntArray223 = new int[this.anInt763];
			this.anIntArray224 = new int[this.anInt763];
			if (arg0) {
				@Pc(82) int local82 = local7.position + this.anInt763 * 10;
				for (@Pc(84) int local84 = 0; local84 < this.anInt763; local84++) {
					this.anIntArray221[local84] = local7.method396();
					this.anIntArray222[local84] = local7.method395();
					this.anIntArray223[local84] = local7.method395();
					this.anIntArray224[local84] = local82;
					local82 += this.anIntArray223[local84];
				}
			}
		} catch (@Pc(123) RuntimeException local123) {
			signlink.reporterror("40193, " + arg0 + ", " + arg1 + ", " + local123.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "(Ljava/lang/String;[BB)[B")
	public byte[] method536(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) byte arg2) {
		try {
			@Pc(3) int local3 = 0;
			@Pc(6) String local6 = arg0.toUpperCase();
			for (@Pc(8) int local8 = 0; local8 < local6.length(); local8++) {
				local3 = local3 * 61 + local6.charAt(local8) - 32;
			}
			for (@Pc(27) int local27 = 0; local27 < this.anInt763; local27++) {
				if (this.anIntArray221[local27] == local3) {
					if (arg1 == null) {
						arg1 = new byte[this.anIntArray222[local27]];
					}
					if (this.aBoolean150) {
						for (@Pc(67) int local67 = 0; local67 < this.anIntArray222[local27]; local67++) {
							arg1[local67] = this.aByteArray14[this.anIntArray224[local27] + local67];
						}
					} else {
						BZip2InputStream.method519(arg1, this.anIntArray222[local27], this.aByteArray14, this.anIntArray223[local27], this.anIntArray224[local27]);
					}
					return arg1;
				}
			}
			if (arg2 != this.flowObfuscator2) {
				throw new NullPointerException();
			}
			return null;
		} catch (@Pc(106) RuntimeException local106) {
			signlink.reporterror("98811, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local106.toString());
			throw new RuntimeException();
		}
	}
}
