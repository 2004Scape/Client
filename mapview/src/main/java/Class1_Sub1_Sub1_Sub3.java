import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!h")
public final class Class1_Sub1_Sub1_Sub3 extends Class1_Sub1_Sub1 {

	@OriginalMember(owner = "mapview!h", name = "v", descriptor = "I")
	private int anInt81;

	@OriginalMember(owner = "mapview!h", name = "w", descriptor = "I")
	private int anInt82;

	@OriginalMember(owner = "mapview!h", name = "q", descriptor = "[I")
	private int[] anIntArray9;

	@OriginalMember(owner = "mapview!h", name = "t", descriptor = "I")
	private int anInt79;

	@OriginalMember(owner = "mapview!h", name = "u", descriptor = "I")
	private int anInt80;

	@OriginalMember(owner = "mapview!h", name = "r", descriptor = "I")
	private int anInt77;

	@OriginalMember(owner = "mapview!h", name = "s", descriptor = "I")
	private int anInt78;

	@OriginalMember(owner = "mapview!h", name = "p", descriptor = "[B")
	private byte[] aByteArray2;

	@OriginalMember(owner = "mapview!h", name = "<init>", descriptor = "(Lmapview!o;Ljava/lang/String;I)V")
	public Class1_Sub1_Sub1_Sub3(@OriginalArg(0) Class6 arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		@Pc(18) Class1_Sub1_Sub2 local18 = new Class1_Sub1_Sub2(arg0.method124(arg1 + ".dat", null));
		@Pc(26) Class1_Sub1_Sub2 local26 = new Class1_Sub1_Sub2(arg0.method124("index.dat", null));
		local26.anInt98 = local18.method83();
		this.anInt81 = local26.method83();
		this.anInt82 = local26.method83();
		@Pc(41) int local41 = local26.method81();
		this.anIntArray9 = new int[local41];
		@Pc(47) int local47;
		for (local47 = 0; local47 < local41 - 1; local47++) {
			this.anIntArray9[local47 + 1] = local26.method85();
		}
		for (local47 = 0; local47 < arg2; local47++) {
			local26.anInt98 += 2;
			local18.anInt98 += local26.method83() * local26.method83();
			local26.anInt98++;
		}
		this.anInt79 = local26.method81();
		this.anInt80 = local26.method81();
		this.anInt77 = local26.method83();
		this.anInt78 = local26.method83();
		local47 = local26.method81();
		@Pc(118) int local118 = this.anInt77 * this.anInt78;
		this.aByteArray2 = new byte[local118];
		@Pc(126) int local126;
		if (local47 == 0) {
			for (local126 = 0; local126 < local118; local126++) {
				this.aByteArray2[local126] = local18.method82();
			}
		} else if (local47 == 1) {
			for (local126 = 0; local126 < this.anInt77; local126++) {
				for (@Pc(149) int local149 = 0; local149 < this.anInt78; local149++) {
					this.aByteArray2[local126 + local149 * this.anInt77] = local18.method82();
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!h", name = "d", descriptor = "(IIII)V")
	public void method63(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(2) int local2 = this.anInt77;
			@Pc(5) int local5 = this.anInt78;
			@Pc(7) int local7 = 0;
			@Pc(9) int local9 = 0;
			@Pc(15) int local15 = (local2 << 16) / arg2;
			@Pc(21) int local21 = (local5 << 16) / arg3;
			@Pc(24) int local24 = this.anInt81;
			@Pc(27) int local27 = this.anInt82;
			@Pc(33) int local33 = (local24 << 16) / arg2;
			@Pc(39) int local39 = (local27 << 16) / arg3;
			arg0 += (this.anInt79 * arg2 + local24 - 1) / local24;
			arg1 += (this.anInt80 * arg3 + local27 - 1) / local27;
			if (this.anInt79 * arg2 % local24 != 0) {
				local7 = (local24 - this.anInt79 * arg2 % local24 << 16) / arg2;
			}
			if (this.anInt80 * arg3 % local27 != 0) {
				local9 = (local27 - this.anInt80 * arg3 % local27 << 16) / arg3;
			}
			arg2 = arg2 * (this.anInt77 - (local7 >> 16)) / local24;
			arg3 = arg3 * (this.anInt78 - (local9 >> 16)) / local27;
			@Pc(133) int local133 = arg0 + arg1 * Class1_Sub1_Sub1.anInt85;
			@Pc(137) int local137 = Class1_Sub1_Sub1.anInt85 - arg2;
			@Pc(144) int local144;
			if (arg1 < Class1_Sub1_Sub1.anInt87) {
				local144 = Class1_Sub1_Sub1.anInt87 - arg1;
				arg3 -= local144;
				arg1 = 0;
				local133 += local144 * Class1_Sub1_Sub1.anInt85;
				local9 += local39 * local144;
			}
			if (arg1 + arg3 > Class1_Sub1_Sub1.anInt88) {
				arg3 -= arg1 + arg3 - Class1_Sub1_Sub1.anInt88;
			}
			if (arg0 < Class1_Sub1_Sub1.anInt89) {
				local144 = Class1_Sub1_Sub1.anInt89 - arg0;
				arg2 -= local144;
				arg0 = 0;
				local133 += local144;
				local7 += local33 * local144;
				local137 += local144;
			}
			if (arg0 + arg2 > Class1_Sub1_Sub1.anInt90) {
				local144 = arg0 + arg2 - Class1_Sub1_Sub1.anInt90;
				arg2 -= local144;
				local137 += local144;
			}
			this.method64(Class1_Sub1_Sub1.anIntArray10, this.aByteArray2, this.anIntArray9, local7, local9, local133, local137, arg2, arg3, local33, local39, local2);
		} catch (@Pc(239) Exception local239) {
			System.out.println("error in sprite clipping routine");
		}
	}

	@OriginalMember(owner = "mapview!h", name = "a", descriptor = "([I[B[IIIIIIIIII)V")
	private void method64(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
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
