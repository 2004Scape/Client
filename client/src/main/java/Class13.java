import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!gc")
public final class Class13 {

	@OriginalMember(owner = "client!gc", name = "g", descriptor = "[I")
	private int[] anIntArray143;

	@OriginalMember(owner = "client!gc", name = "c", descriptor = "Z")
	private final boolean aBoolean100 = false;

	@OriginalMember(owner = "client!gc", name = "f", descriptor = "I")
	public int anInt438 = -1;

	@OriginalMember(owner = "client!gc", name = "h", descriptor = "[I")
	private final int[] anIntArray144 = new int[6];

	@OriginalMember(owner = "client!gc", name = "i", descriptor = "[I")
	private final int[] anIntArray145 = new int[6];

	@OriginalMember(owner = "client!gc", name = "j", descriptor = "[I")
	private final int[] anIntArray146 = new int[] { -1, -1, -1, -1, -1 };

	@OriginalMember(owner = "client!gc", name = "k", descriptor = "Z")
	public boolean aBoolean101 = false;

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method305(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1) {
		try {
			if (arg0) {
				Static16.anInt435 = 65;
			}
			while (true) {
				while (true) {
					@Pc(8) int local8 = arg1.method391();
					if (local8 == 0) {
						return;
					}
					if (local8 == 1) {
						this.anInt438 = arg1.method391();
					} else if (local8 == 2) {
						@Pc(26) int local26 = arg1.method391();
						this.anIntArray143 = new int[local26];
						for (@Pc(32) int local32 = 0; local32 < local26; local32++) {
							this.anIntArray143[local32] = arg1.method393();
						}
					} else if (local8 == 3) {
						this.aBoolean101 = true;
					} else if (local8 >= 40 && local8 < 50) {
						this.anIntArray144[local8 - 40] = arg1.method393();
					} else if (local8 >= 50 && local8 < 60) {
						this.anIntArray145[local8 - 50] = arg1.method393();
					} else if (local8 >= 60 && local8 < 70) {
						this.anIntArray146[local8 - 60] = arg1.method393();
					} else {
						System.out.println("Error unrecognised config code: " + local8);
					}
				}
			}
		} catch (@Pc(113) RuntimeException local113) {
			signlink.reporterror("61151, " + arg0 + ", " + arg1 + ", " + local113.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "()Lclient!eb;")
	public Class1_Sub3_Sub1 method306() {
		if (this.anIntArray143 == null) {
			return null;
		}
		@Pc(11) Class1_Sub3_Sub1[] local11 = new Class1_Sub3_Sub1[this.anIntArray143.length];
		for (@Pc(13) int local13 = 0; local13 < this.anIntArray143.length; local13++) {
			local11[local13] = new Class1_Sub3_Sub1(false, this.anIntArray143[local13]);
		}
		@Pc(40) Class1_Sub3_Sub1 local40;
		if (local11.length == 1) {
			local40 = local11[0];
		} else {
			local40 = new Class1_Sub3_Sub1(0, local11, local11.length);
		}
		for (@Pc(52) int local52 = 0; local52 < 6 && this.anIntArray144[local52] != 0; local52++) {
			local40.method237(this.anIntArray144[local52], this.anIntArray145[local52]);
		}
		return local40;
	}

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "(Z)Lclient!eb;")
	public Class1_Sub3_Sub1 method307(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(4) Class1_Sub3_Sub1[] local4 = new Class1_Sub3_Sub1[5];
			@Pc(6) int local6 = 0;
			for (@Pc(8) int local8 = 0; local8 < 5; local8++) {
				if (this.anIntArray146[local8] != -1) {
					local4[local6++] = new Class1_Sub3_Sub1(false, this.anIntArray146[local8]);
				}
			}
			@Pc(39) Class1_Sub3_Sub1 local39 = new Class1_Sub3_Sub1(0, local4, local6);
			for (@Pc(41) int local41 = 0; local41 < 6 && this.anIntArray144[local41] != 0; local41++) {
				local39.method237(this.anIntArray144[local41], this.anIntArray145[local41]);
			}
			if (arg0) {
				for (@Pc(66) int local66 = 1; local66 > 0; local66++) {
				}
			}
			return local39;
		} catch (@Pc(74) RuntimeException local74) {
			signlink.reporterror("19364, " + arg0 + ", " + local74.toString());
			throw new RuntimeException();
		}
	}
}
