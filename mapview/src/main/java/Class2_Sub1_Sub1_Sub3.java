import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!i")
public final class Class2_Sub1_Sub1_Sub3 extends Class2_Sub1_Sub1 {

	@OriginalMember(owner = "mapview!i", name = "v", descriptor = "I")
	private int anInt75;

	@OriginalMember(owner = "mapview!i", name = "w", descriptor = "I")
	private int anInt76;

	@OriginalMember(owner = "mapview!i", name = "q", descriptor = "[I")
	private int[] anIntArray9;

	@OriginalMember(owner = "mapview!i", name = "t", descriptor = "I")
	private int anInt73;

	@OriginalMember(owner = "mapview!i", name = "u", descriptor = "I")
	private int anInt74;

	@OriginalMember(owner = "mapview!i", name = "r", descriptor = "I")
	private int anInt71;

	@OriginalMember(owner = "mapview!i", name = "s", descriptor = "I")
	private int anInt72;

	@OriginalMember(owner = "mapview!i", name = "p", descriptor = "[B")
	private byte[] aByteArray2;

	@OriginalMember(owner = "mapview!i", name = "<init>", descriptor = "(Lmapview!p;Ljava/lang/String;I)V")
	public Class2_Sub1_Sub1_Sub3(@OriginalArg(0) Class7 arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		@Pc(18) Class2_Sub1_Sub2 local18 = new Class2_Sub1_Sub2(arg0.method145(arg1 + ".dat", null));
		@Pc(26) Class2_Sub1_Sub2 local26 = new Class2_Sub1_Sub2(arg0.method145("index.dat", null));
		local26.anInt89 = local18.method100();
		this.anInt75 = local26.method100();
		this.anInt76 = local26.method100();
		@Pc(41) int local41 = local26.method98();
		this.anIntArray9 = new int[local41];
		@Pc(47) int local47;
		for (local47 = 0; local47 < local41 - 1; local47++) {
			this.anIntArray9[local47 + 1] = local26.method103();
		}
		for (local47 = 0; local47 < arg2; local47++) {
			local26.anInt89 += 2;
			local18.anInt89 += local26.method100() * local26.method100();
			local26.anInt89++;
		}
		this.anInt73 = local26.method98();
		this.anInt74 = local26.method98();
		this.anInt71 = local26.method100();
		this.anInt72 = local26.method100();
		local47 = local26.method98();
		@Pc(118) int local118 = this.anInt71 * this.anInt72;
		this.aByteArray2 = new byte[local118];
		@Pc(126) int local126;
		if (local47 == 0) {
			for (local126 = 0; local126 < local118; local126++) {
				this.aByteArray2[local126] = local18.method99();
			}
		} else if (local47 == 1) {
			for (local126 = 0; local126 < this.anInt71; local126++) {
				for (@Pc(149) int local149 = 0; local149 < this.anInt72; local149++) {
					this.aByteArray2[local126 + local149 * this.anInt71] = local18.method99();
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!i", name = "d", descriptor = "(IIII)V")
	public void method79(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(2) int local2 = this.anInt71;
			@Pc(5) int local5 = this.anInt72;
			@Pc(7) int local7 = 0;
			@Pc(9) int local9 = 0;
			@Pc(15) int local15 = (local2 << 16) / arg2;
			@Pc(21) int local21 = (local5 << 16) / arg3;
			@Pc(24) int local24 = this.anInt75;
			@Pc(27) int local27 = this.anInt76;
			@Pc(33) int local33 = (local24 << 16) / arg2;
			@Pc(39) int local39 = (local27 << 16) / arg3;
			arg0 += (this.anInt73 * arg2 + local24 - 1) / local24;
			arg1 += (this.anInt74 * arg3 + local27 - 1) / local27;
			if (this.anInt73 * arg2 % local24 != 0) {
				local7 = (local24 - this.anInt73 * arg2 % local24 << 16) / arg2;
			}
			if (this.anInt74 * arg3 % local27 != 0) {
				local9 = (local27 - this.anInt74 * arg3 % local27 << 16) / arg3;
			}
			arg2 = arg2 * (this.anInt71 - (local7 >> 16)) / local24;
			arg3 = arg3 * (this.anInt72 - (local9 >> 16)) / local27;
			@Pc(133) int local133 = arg0 + arg1 * Class2_Sub1_Sub1.anInt78;
			@Pc(137) int local137 = Class2_Sub1_Sub1.anInt78 - arg2;
			@Pc(144) int local144;
			if (arg1 < Class2_Sub1_Sub1.anInt80) {
				local144 = Class2_Sub1_Sub1.anInt80 - arg1;
				arg3 -= local144;
				arg1 = 0;
				local133 += local144 * Class2_Sub1_Sub1.anInt78;
				local9 += local39 * local144;
			}
			if (arg1 + arg3 > Class2_Sub1_Sub1.anInt81) {
				arg3 -= arg1 + arg3 - Class2_Sub1_Sub1.anInt81;
			}
			if (arg0 < Class2_Sub1_Sub1.anInt82) {
				local144 = Class2_Sub1_Sub1.anInt82 - arg0;
				arg2 -= local144;
				arg0 = 0;
				local133 += local144;
				local7 += local33 * local144;
				local137 += local144;
			}
			if (arg0 + arg2 > Class2_Sub1_Sub1.anInt83) {
				local144 = arg0 + arg2 - Class2_Sub1_Sub1.anInt83;
				arg2 -= local144;
				local137 += local144;
			}
			this.method80(Class2_Sub1_Sub1.anIntArray10, this.aByteArray2, this.anIntArray9, local7, local9, local133, local137, arg2, arg3, local33, local39, local2);
		} catch (@Pc(239) Exception local239) {
			System.out.println("error in sprite clipping routine");
		}
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "([I[B[IIIIIIIIII)V")
	private void method80(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
		try {
			@Pc(3) int local3 = arg3;
			for (@Pc(6) int local6 = -arg8; local6 < 0; local6++) {
				@Pc(14) int local14 = (arg4 >> 16) * arg11;
				for (@Pc(17) int local17 = -arg7; local17 < 0; local17++) {
					@Pc(27) byte local27 = arg1[(arg3 >> 16) + local14];
					if (local27 == 0) {
						arg5++;
					} else {
						arg0[arg5++] = arg2[local27 & 0xFF];
					}
					arg3 += arg9;
				}
				arg4 += arg10;
				arg3 = local3;
				arg5 += arg6;
			}
		} catch (@Pc(63) Exception local63) {
			System.out.println("error in plot_scale");
		}
	}
}
