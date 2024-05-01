import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!g")
public final class Pix24 extends Draw2D {

	@OriginalMember(owner = "mapview!g", name = "p", descriptor = "[I")
	public int[] anIntArray7;

	@OriginalMember(owner = "mapview!g", name = "u", descriptor = "I")
	private int anInt63;

	@OriginalMember(owner = "mapview!g", name = "q", descriptor = "I")
	private int anInt59;

	@OriginalMember(owner = "mapview!g", name = "v", descriptor = "I")
	private int anInt64;

	@OriginalMember(owner = "mapview!g", name = "r", descriptor = "I")
	private int anInt60;

	@OriginalMember(owner = "mapview!g", name = "t", descriptor = "I")
	private int anInt62;

	@OriginalMember(owner = "mapview!g", name = "s", descriptor = "I")
	private int anInt61;

	@OriginalMember(owner = "mapview!g", name = "<init>", descriptor = "(II)V")
	public Pix24(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anIntArray7 = new int[arg0 * arg1];
		this.anInt59 = this.anInt63 = arg0;
		this.anInt60 = this.anInt64 = arg1;
		this.anInt61 = this.anInt62 = 0;
	}

	@OriginalMember(owner = "mapview!g", name = "<init>", descriptor = "(Lmapview!o;Ljava/lang/String;I)V")
	public Pix24(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		@Pc(18) Packet local18 = new Packet(arg0.read(arg1 + ".dat", null));
		@Pc(26) Packet local26 = new Packet(arg0.read("index.dat", null));
		local26.pos = local18.g2();
		this.anInt63 = local26.g2();
		this.anInt64 = local26.g2();
		@Pc(41) int local41 = local26.g1();
		@Pc(44) int[] local44 = new int[local41];
		@Pc(46) int local46;
		for (local46 = 0; local46 < local41 - 1; local46++) {
			local44[local46 + 1] = local26.g3();
			if (local44[local46 + 1] == 0) {
				local44[local46 + 1] = 1;
			}
		}
		for (local46 = 0; local46 < arg2; local46++) {
			local26.pos += 2;
			local18.pos += local26.g2() * local26.g2();
			local26.pos++;
		}
		this.anInt61 = local26.g1();
		this.anInt62 = local26.g1();
		this.anInt59 = local26.g2();
		this.anInt60 = local26.g2();
		local46 = local26.g1();
		@Pc(128) int local128 = this.anInt59 * this.anInt60;
		this.anIntArray7 = new int[local128];
		@Pc(136) int local136;
		if (local46 == 0) {
			for (local136 = 0; local136 < local128; local136++) {
				this.anIntArray7[local136] = local44[local18.g1()];
			}
		} else if (local46 == 1) {
			for (local136 = 0; local136 < this.anInt59; local136++) {
				for (@Pc(161) int local161 = 0; local161 < this.anInt60; local161++) {
					this.anIntArray7[local136 + local161 * this.anInt59] = local44[local18.g1()];
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!g", name = "b", descriptor = "()V")
	public void method49() {
		Draw2D.method70(this.anIntArray7, this.anInt59, this.anInt60);
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(II)V")
	public void method50(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		arg0 += this.anInt61;
		arg1 += this.anInt62;
		@Pc(15) int local15 = arg0 + arg1 * Draw2D.anInt85;
		@Pc(17) int local17 = 0;
		@Pc(20) int local20 = this.anInt60;
		@Pc(23) int local23 = this.anInt59;
		@Pc(27) int local27 = Draw2D.anInt85 - local23;
		@Pc(29) int local29 = 0;
		@Pc(36) int local36;
		if (arg1 < Draw2D.anInt87) {
			local36 = Draw2D.anInt87 - arg1;
			local20 -= local36;
			arg1 = Draw2D.anInt87;
			local17 += local36 * local23;
			local15 += local36 * Draw2D.anInt85;
		}
		if (arg1 + local20 > Draw2D.anInt88) {
			local20 -= arg1 + local20 - Draw2D.anInt88;
		}
		if (arg0 < Draw2D.anInt89) {
			local36 = Draw2D.anInt89 - arg0;
			local23 -= local36;
			arg0 = Draw2D.anInt89;
			local17 += local36;
			local15 += local36;
			local29 += local36;
			local27 += local36;
		}
		if (arg0 + local23 > Draw2D.anInt90) {
			local36 = arg0 + local23 - Draw2D.anInt90;
			local23 -= local36;
			local29 += local36;
			local27 += local36;
		}
		if (local23 > 0 && local20 > 0) {
			this.method51(Draw2D.anIntArray10, this.anIntArray7, 0, local17, local15, local23, local20, local27, local29);
		}
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "([I[IIIIIIII)V")
	private void method51(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
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

	@OriginalMember(owner = "mapview!g", name = "b", descriptor = "(II)V")
	public void method52(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		arg0 += this.anInt61;
		arg1 += this.anInt62;
		@Pc(15) int local15 = arg0 + arg1 * Draw2D.anInt85;
		@Pc(17) int local17 = 0;
		@Pc(20) int local20 = this.anInt60;
		@Pc(23) int local23 = this.anInt59;
		@Pc(27) int local27 = Draw2D.anInt85 - local23;
		@Pc(29) int local29 = 0;
		@Pc(36) int local36;
		if (arg1 < Draw2D.anInt87) {
			local36 = Draw2D.anInt87 - arg1;
			local20 -= local36;
			arg1 = Draw2D.anInt87;
			local17 += local36 * local23;
			local15 += local36 * Draw2D.anInt85;
		}
		if (arg1 + local20 > Draw2D.anInt88) {
			local20 -= arg1 + local20 - Draw2D.anInt88;
		}
		if (arg0 < Draw2D.anInt89) {
			local36 = Draw2D.anInt89 - arg0;
			local23 -= local36;
			arg0 = Draw2D.anInt89;
			local17 += local36;
			local15 += local36;
			local29 += local36;
			local27 += local36;
		}
		if (arg0 + local23 > Draw2D.anInt90) {
			local36 = arg0 + local23 - Draw2D.anInt90;
			local23 -= local36;
			local29 += local36;
			local27 += local36;
		}
		if (local23 > 0 && local20 > 0) {
			this.method53(Draw2D.anIntArray10, this.anIntArray7, local17, local15, local23, local20, local27, local29);
		}
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "([I[IIIIIII)V")
	private void method53(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
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
