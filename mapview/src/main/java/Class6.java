import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!o")
public final class Class6 {

	@OriginalMember(owner = "mapview!o", name = "a", descriptor = "[B")
	private byte[] aByteArray10;

	@OriginalMember(owner = "mapview!o", name = "b", descriptor = "I")
	private int anInt185;

	@OriginalMember(owner = "mapview!o", name = "c", descriptor = "[I")
	private int[] anIntArray38;

	@OriginalMember(owner = "mapview!o", name = "d", descriptor = "[I")
	private int[] anIntArray39;

	@OriginalMember(owner = "mapview!o", name = "e", descriptor = "[I")
	private int[] anIntArray40;

	@OriginalMember(owner = "mapview!o", name = "f", descriptor = "[I")
	private int[] anIntArray41;

	@OriginalMember(owner = "mapview!o", name = "g", descriptor = "Z")
	private boolean aBoolean18;

	@OriginalMember(owner = "mapview!o", name = "<init>", descriptor = "([B)V")
	public Class6(@OriginalArg(0) byte[] arg0) {
		this.method123(arg0);
	}

	@OriginalMember(owner = "mapview!o", name = "a", descriptor = "([B)V")
	private void method123(@OriginalArg(0) byte[] arg0) {
		@Pc(6) Class1_Sub1_Sub2 local6 = new Class1_Sub1_Sub2(arg0);
		@Pc(9) int local9 = local6.method85();
		@Pc(12) int local12 = local6.method85();
		if (local12 == local9) {
			this.aByteArray10 = arg0;
			this.aBoolean18 = false;
		} else {
			@Pc(18) byte[] local18 = new byte[local9];
			Class4.method95(local18, local9, arg0, local12, 6);
			this.aByteArray10 = local18;
			local6 = new Class1_Sub1_Sub2(this.aByteArray10);
			this.aBoolean18 = true;
		}
		this.anInt185 = local6.method83();
		this.anIntArray38 = new int[this.anInt185];
		this.anIntArray39 = new int[this.anInt185];
		this.anIntArray40 = new int[this.anInt185];
		this.anIntArray41 = new int[this.anInt185];
		@Pc(77) int local77 = local6.anInt98 + this.anInt185 * 10;
		for (@Pc(79) int local79 = 0; local79 < this.anInt185; local79++) {
			this.anIntArray38[local79] = local6.method80();
			this.anIntArray39[local79] = local6.method85();
			this.anIntArray40[local79] = local6.method85();
			this.anIntArray41[local79] = local77;
			local77 += this.anIntArray40[local79];
		}
	}

	@OriginalMember(owner = "mapview!o", name = "a", descriptor = "(Ljava/lang/String;[B)[B")
	public byte[] method124(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) {
		@Pc(3) int local3 = 0;
		@Pc(6) String local6 = arg0.toUpperCase();
		@Pc(8) int local8;
		for (local8 = 0; local8 < local6.length(); local8++) {
			local3 = local3 * 61 + local6.charAt(local8) - 32;
		}
		for (local8 = 0; local8 < this.anInt185; local8++) {
			if (this.anIntArray38[local8] == local3) {
				if (arg1 == null) {
					arg1 = new byte[this.anIntArray39[local8]];
				}
				if (this.aBoolean18) {
					for (@Pc(67) int local67 = 0; local67 < this.anIntArray39[local8]; local67++) {
						arg1[local67] = this.aByteArray10[this.anIntArray41[local8] + local67];
					}
				} else {
					Class4.method95(arg1, this.anIntArray39[local8], this.aByteArray10, this.anIntArray40[local8], this.anIntArray41[local8]);
				}
				return arg1;
			}
		}
		return null;
	}
}
