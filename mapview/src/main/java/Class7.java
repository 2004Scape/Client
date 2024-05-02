import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!p")
public final class Class7 {

	@OriginalMember(owner = "mapview!p", name = "a", descriptor = "[B")
	private byte[] aByteArray10;

	@OriginalMember(owner = "mapview!p", name = "b", descriptor = "I")
	private int anInt172;

	@OriginalMember(owner = "mapview!p", name = "c", descriptor = "[I")
	private int[] anIntArray40;

	@OriginalMember(owner = "mapview!p", name = "d", descriptor = "[I")
	private int[] anIntArray41;

	@OriginalMember(owner = "mapview!p", name = "e", descriptor = "[I")
	private int[] anIntArray42;

	@OriginalMember(owner = "mapview!p", name = "f", descriptor = "[I")
	private int[] anIntArray43;

	@OriginalMember(owner = "mapview!p", name = "g", descriptor = "Z")
	private boolean aBoolean29;

	@OriginalMember(owner = "mapview!p", name = "<init>", descriptor = "([B)V")
	public Class7(@OriginalArg(0) byte[] arg0) {
		this.method144(arg0);
	}

	@OriginalMember(owner = "mapview!p", name = "a", descriptor = "([B)V")
	private void method144(@OriginalArg(0) byte[] arg0) {
		@Pc(6) Class2_Sub1_Sub2 local6 = new Class2_Sub1_Sub2(arg0);
		@Pc(9) int local9 = local6.method103();
		@Pc(12) int local12 = local6.method103();
		if (local12 == local9) {
			this.aByteArray10 = arg0;
			this.aBoolean29 = false;
		} else {
			@Pc(18) byte[] local18 = new byte[local9];
			Class5.method142(local18, local9, arg0, local12, 6);
			this.aByteArray10 = local18;
			local6 = new Class2_Sub1_Sub2(this.aByteArray10);
			this.aBoolean29 = true;
		}
		this.anInt172 = local6.method100();
		this.anIntArray40 = new int[this.anInt172];
		this.anIntArray41 = new int[this.anInt172];
		this.anIntArray42 = new int[this.anInt172];
		this.anIntArray43 = new int[this.anInt172];
		@Pc(77) int local77 = local6.anInt89 + this.anInt172 * 10;
		for (@Pc(79) int local79 = 0; local79 < this.anInt172; local79++) {
			this.anIntArray40[local79] = local6.method97();
			this.anIntArray41[local79] = local6.method103();
			this.anIntArray42[local79] = local6.method103();
			this.anIntArray43[local79] = local77;
			local77 += this.anIntArray42[local79];
		}
	}

	@OriginalMember(owner = "mapview!p", name = "a", descriptor = "(Ljava/lang/String;[B)[B")
	public byte[] method145(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) {
		@Pc(3) int local3 = 0;
		@Pc(6) String local6 = arg0.toUpperCase();
		@Pc(8) int local8;
		for (local8 = 0; local8 < local6.length(); local8++) {
			local3 = local3 * 61 + local6.charAt(local8) - 32;
		}
		for (local8 = 0; local8 < this.anInt172; local8++) {
			if (this.anIntArray40[local8] == local3) {
				if (arg1 == null) {
					arg1 = new byte[this.anIntArray41[local8]];
				}
				if (this.aBoolean29) {
					for (@Pc(67) int local67 = 0; local67 < this.anIntArray41[local8]; local67++) {
						arg1[local67] = this.aByteArray10[this.anIntArray43[local8] + local67];
					}
				} else {
					Class5.method142(arg1, this.anIntArray41[local8], this.aByteArray10, this.anIntArray42[local8], this.anIntArray43[local8]);
				}
				return arg1;
			}
		}
		return null;
	}
}
