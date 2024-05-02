import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!h")
public final class Class2_Sub1_Sub1_Sub2 extends Class2_Sub1_Sub1 {

	@OriginalMember(owner = "mapview!h", name = "p", descriptor = "[I")
	private int[] anIntArray7;

	@OriginalMember(owner = "mapview!h", name = "u", descriptor = "I")
	private int anInt59;

	@OriginalMember(owner = "mapview!h", name = "q", descriptor = "I")
	private int anInt55;

	@OriginalMember(owner = "mapview!h", name = "v", descriptor = "I")
	private int anInt60;

	@OriginalMember(owner = "mapview!h", name = "r", descriptor = "I")
	private int anInt56;

	@OriginalMember(owner = "mapview!h", name = "t", descriptor = "I")
	private int anInt58;

	@OriginalMember(owner = "mapview!h", name = "s", descriptor = "I")
	private int anInt57;

	@OriginalMember(owner = "mapview!h", name = "<init>", descriptor = "(II)V")
	public Class2_Sub1_Sub1_Sub2(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anIntArray7 = new int[arg0 * arg1];
		this.anInt55 = this.anInt59 = arg0;
		this.anInt56 = this.anInt60 = arg1;
		this.anInt57 = this.anInt58 = 0;
	}

	@OriginalMember(owner = "mapview!h", name = "<init>", descriptor = "(Lmapview!p;Ljava/lang/String;I)V")
	public Class2_Sub1_Sub1_Sub2(@OriginalArg(0) Class7 arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		@Pc(18) Class2_Sub1_Sub2 local18 = new Class2_Sub1_Sub2(arg0.method145(arg1 + ".dat", null));
		@Pc(26) Class2_Sub1_Sub2 local26 = new Class2_Sub1_Sub2(arg0.method145("index.dat", null));
		local26.anInt89 = local18.method100();
		this.anInt59 = local26.method100();
		this.anInt60 = local26.method100();
		@Pc(41) int local41 = local26.method98();
		@Pc(44) int[] local44 = new int[local41];
		@Pc(46) int local46;
		for (local46 = 0; local46 < local41 - 1; local46++) {
			local44[local46 + 1] = local26.method103();
			if (local44[local46 + 1] == 0) {
				local44[local46 + 1] = 1;
			}
		}
		for (local46 = 0; local46 < arg2; local46++) {
			local26.anInt89 += 2;
			local18.anInt89 += local26.method100() * local26.method100();
			local26.anInt89++;
		}
		this.anInt57 = local26.method98();
		this.anInt58 = local26.method98();
		this.anInt55 = local26.method100();
		this.anInt56 = local26.method100();
		local46 = local26.method98();
		@Pc(128) int local128 = this.anInt55 * this.anInt56;
		this.anIntArray7 = new int[local128];
		@Pc(136) int local136;
		if (local46 == 0) {
			for (local136 = 0; local136 < local128; local136++) {
				this.anIntArray7[local136] = local44[local18.method98()];
			}
		} else if (local46 == 1) {
			for (local136 = 0; local136 < this.anInt55; local136++) {
				for (@Pc(161) int local161 = 0; local161 < this.anInt56; local161++) {
					this.anIntArray7[local136 + local161 * this.anInt55] = local44[local18.method98()];
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!h", name = "c", descriptor = "()V")
	public void method64() {
		Class2_Sub1_Sub1.method87(this.anIntArray7, this.anInt55, this.anInt56);
	}

	@OriginalMember(owner = "mapview!h", name = "a", descriptor = "(II)V")
	public void method65(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		arg0 += this.anInt57;
		arg1 += this.anInt58;
		@Pc(15) int local15 = arg0 + arg1 * Class2_Sub1_Sub1.anInt78;
		@Pc(17) int local17 = 0;
		@Pc(20) int local20 = this.anInt56;
		@Pc(23) int local23 = this.anInt55;
		@Pc(27) int local27 = Class2_Sub1_Sub1.anInt78 - local23;
		@Pc(29) int local29 = 0;
		@Pc(36) int local36;
		if (arg1 < Class2_Sub1_Sub1.anInt80) {
			local36 = Class2_Sub1_Sub1.anInt80 - arg1;
			local20 -= local36;
			arg1 = Class2_Sub1_Sub1.anInt80;
			local17 += local36 * local23;
			local15 += local36 * Class2_Sub1_Sub1.anInt78;
		}
		if (arg1 + local20 > Class2_Sub1_Sub1.anInt81) {
			local20 -= arg1 + local20 - Class2_Sub1_Sub1.anInt81;
		}
		if (arg0 < Class2_Sub1_Sub1.anInt82) {
			local36 = Class2_Sub1_Sub1.anInt82 - arg0;
			local23 -= local36;
			arg0 = Class2_Sub1_Sub1.anInt82;
			local17 += local36;
			local15 += local36;
			local29 += local36;
			local27 += local36;
		}
		if (arg0 + local23 > Class2_Sub1_Sub1.anInt83) {
			local36 = arg0 + local23 - Class2_Sub1_Sub1.anInt83;
			local23 -= local36;
			local29 += local36;
			local27 += local36;
		}
		if (local23 > 0 && local20 > 0) {
			this.method66(Class2_Sub1_Sub1.anIntArray10, this.anIntArray7, 0, local17, local15, local23, local20, local27, local29);
		}
	}

	@OriginalMember(owner = "mapview!h", name = "a", descriptor = "([I[IIIIIIII)V")
	private void method66(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(6) int local6 = -(arg5 >> 2);
		@Pc(11) int local11 = -(arg5 & 0x3);
		for (@Pc(14) int local14 = -arg6; local14 < 0; local14++) {
			@Pc(18) int local18;
			@Pc(25) int local25;
			for (local18 = local6; local18 < 0; local18++) {
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
			}
			for (local18 = local11; local18 < 0; local18++) {
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	@OriginalMember(owner = "mapview!h", name = "b", descriptor = "(II)V")
	public void method67(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		arg0 += this.anInt57;
		arg1 += this.anInt58;
		@Pc(15) int local15 = arg0 + arg1 * Class2_Sub1_Sub1.anInt78;
		@Pc(17) int local17 = 0;
		@Pc(20) int local20 = this.anInt56;
		@Pc(23) int local23 = this.anInt55;
		@Pc(27) int local27 = Class2_Sub1_Sub1.anInt78 - local23;
		@Pc(29) int local29 = 0;
		@Pc(36) int local36;
		if (arg1 < Class2_Sub1_Sub1.anInt80) {
			local36 = Class2_Sub1_Sub1.anInt80 - arg1;
			local20 -= local36;
			arg1 = Class2_Sub1_Sub1.anInt80;
			local17 += local36 * local23;
			local15 += local36 * Class2_Sub1_Sub1.anInt78;
		}
		if (arg1 + local20 > Class2_Sub1_Sub1.anInt81) {
			local20 -= arg1 + local20 - Class2_Sub1_Sub1.anInt81;
		}
		if (arg0 < Class2_Sub1_Sub1.anInt82) {
			local36 = Class2_Sub1_Sub1.anInt82 - arg0;
			local23 -= local36;
			arg0 = Class2_Sub1_Sub1.anInt82;
			local17 += local36;
			local15 += local36;
			local29 += local36;
			local27 += local36;
		}
		if (arg0 + local23 > Class2_Sub1_Sub1.anInt83) {
			local36 = arg0 + local23 - Class2_Sub1_Sub1.anInt83;
			local23 -= local36;
			local29 += local36;
			local27 += local36;
		}
		if (local23 > 0 && local20 > 0) {
			this.method68(Class2_Sub1_Sub1.anIntArray10, this.anIntArray7, local17, local15, local23, local20, local27, local29);
		}
	}

	@OriginalMember(owner = "mapview!h", name = "a", descriptor = "([I[IIIIIII)V")
	private void method68(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(6) int local6 = -(arg4 >> 2);
		@Pc(11) int local11 = -(arg4 & 0x3);
		for (@Pc(14) int local14 = -arg5; local14 < 0; local14++) {
			@Pc(18) int local18;
			for (local18 = local6; local18 < 0; local18++) {
				arg0[arg3++] = arg1[arg2++];
				arg0[arg3++] = arg1[arg2++];
				arg0[arg3++] = arg1[arg2++];
				arg0[arg3++] = arg1[arg2++];
			}
			for (local18 = local11; local18 < 0; local18++) {
				arg0[arg3++] = arg1[arg2++];
			}
			arg3 += arg6;
			arg2 += arg7;
		}
	}
}
