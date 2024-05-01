import java.util.Random;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!i")
public final class PixFontFull extends Draw2D {

	@OriginalMember(owner = "mapview!i", name = "p", descriptor = "[[B")
	private byte[][] aByteArrayArray1 = new byte[256][];

	@OriginalMember(owner = "mapview!i", name = "q", descriptor = "[I")
	private int[] anIntArray11 = new int[256];

	@OriginalMember(owner = "mapview!i", name = "r", descriptor = "[I")
	private int[] anIntArray12 = new int[256];

	@OriginalMember(owner = "mapview!i", name = "s", descriptor = "[I")
	private int[] anIntArray13 = new int[256];

	@OriginalMember(owner = "mapview!i", name = "t", descriptor = "[I")
	private int[] anIntArray14 = new int[256];

	@OriginalMember(owner = "mapview!i", name = "u", descriptor = "[I")
	private int[] anIntArray15 = new int[256];

	@OriginalMember(owner = "mapview!i", name = "v", descriptor = "I")
	private int anInt95 = 0;

	@OriginalMember(owner = "mapview!i", name = "w", descriptor = "Ljava/util/Random;")
	private Random aRandom1 = new Random();

	@OriginalMember(owner = "mapview!i", name = "x", descriptor = "Z")
	private boolean aBoolean6 = false;

	@OriginalMember(owner = "mapview!i", name = "<init>", descriptor = "(Lmapview!o;Ljava/lang/String;Z)V")
	public PixFontFull(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) String arg1, @OriginalArg(2) boolean arg2) {
		@Pc(53) Packet local53 = new Packet(arg0.read(arg1 + ".dat", null));
		@Pc(61) Packet local61 = new Packet(arg0.read("index.dat", null));
		@Pc(63) boolean local63 = true;
		local61.pos = local53.g2() + 4;
		@Pc(72) int local72 = local61.g1();
		if (local72 > 0) {
			local61.pos += (local72 - 1) * 3;
		}
		for (@Pc(86) int local86 = 0; local86 < 256; local86++) {
			this.anIntArray13[local86] = local61.g1();
			this.anIntArray14[local86] = local61.g1();
			@Pc(115) int local115 = this.anIntArray11[local86] = local61.g2();
			@Pc(123) int local123 = this.anIntArray12[local86] = local61.g2();
			@Pc(126) int local126 = local61.g1();
			@Pc(130) int local130 = local115 * local123;
			this.aByteArrayArray1[local86] = new byte[local130];
			@Pc(140) int local140;
			@Pc(165) int local165;
			if (local126 == 0) {
				for (local140 = 0; local140 < local130; local140++) {
					this.aByteArrayArray1[local86][local140] = local53.g1b();
				}
			} else if (local126 == 1) {
				for (local140 = 0; local140 < local115; local140++) {
					for (local165 = 0; local165 < local123; local165++) {
						this.aByteArrayArray1[local86][local140 + local165 * local115] = local53.g1b();
					}
				}
			}
			if (local123 > this.anInt95 && local86 < 128) {
				this.anInt95 = local123;
			}
			this.anIntArray13[local86] = 1;
			this.anIntArray15[local86] = local115 + 2;
			local140 = 0;
			for (local165 = local123 / 7; local165 < local123; local165++) {
				local140 += this.aByteArrayArray1[local86][local165 * local115];
			}
			if (local140 <= local123 / 7) {
				this.anIntArray15[local86] += -1;
				this.anIntArray13[local86] = 0;
			}
			local140 = 0;
			for (local165 = local123 / 7; local165 < local123; local165++) {
				local140 += this.aByteArrayArray1[local86][local115 - 1 + local165 * local115];
			}
			if (local140 <= local123 / 7) {
				this.anIntArray15[local86] += -1;
			}
		}
		if (arg2) {
			this.anIntArray15[32] = this.anIntArray15[73];
		} else {
			this.anIntArray15[32] = this.anIntArray15[105];
		}
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "(Ljava/lang/String;)I")
	private int method74(@OriginalArg(0) String arg0) {
		if (arg0 == null) {
			return 0;
		}
		@Pc(5) int local5 = 0;
		for (@Pc(7) int local7 = 0; local7 < arg0.length(); local7++) {
			local5 += this.anIntArray15[arg0.charAt(local7)];
		}
		return local5;
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "(Ljava/lang/String;III)V")
	public void method75(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (arg0 == null) {
			return;
		}
		@Pc(7) int local7 = arg2 - this.anInt95;
		for (@Pc(9) int local9 = 0; local9 < arg0.length(); local9++) {
			@Pc(15) char local15 = arg0.charAt(local9);
			if (local15 != ' ') {
				this.method78(this.aByteArrayArray1[local15], arg1 + this.anIntArray13[local15], local7 + this.anIntArray14[local15], this.anIntArray11[local15], this.anIntArray12[local15], arg3);
			}
			arg1 += this.anIntArray15[local15];
		}
	}

	@OriginalMember(owner = "mapview!i", name = "b", descriptor = "(Ljava/lang/String;III)V")
	public void method76(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		this.method75(arg0, arg1 - this.method74(arg0), arg2, arg3);
	}

	@OriginalMember(owner = "mapview!i", name = "c", descriptor = "(Ljava/lang/String;III)V")
	public void method77(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		this.method75(arg0, arg1 - this.method74(arg0) / 2, arg2, arg3);
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "([BIIIII)V")
	private void method78(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(5) int local5 = arg1 + arg2 * Draw2D.anInt85;
		@Pc(9) int local9 = Draw2D.anInt85 - arg3;
		@Pc(11) int local11 = 0;
		@Pc(13) int local13 = 0;
		@Pc(20) int local20;
		if (arg2 < Draw2D.anInt87) {
			local20 = Draw2D.anInt87 - arg2;
			arg4 -= local20;
			arg2 = Draw2D.anInt87;
			local13 += local20 * arg3;
			local5 += local20 * Draw2D.anInt85;
		}
		if (arg2 + arg4 >= Draw2D.anInt88) {
			arg4 -= arg2 + arg4 - Draw2D.anInt88 + 1;
		}
		if (arg1 < Draw2D.anInt89) {
			local20 = Draw2D.anInt89 - arg1;
			arg3 -= local20;
			arg1 = Draw2D.anInt89;
			local13 += local20;
			local5 += local20;
			local11 += local20;
			local9 += local20;
		}
		if (arg1 + arg3 >= Draw2D.anInt90) {
			local20 = arg1 + arg3 - Draw2D.anInt90 + 1;
			arg3 -= local20;
			local11 += local20;
			local9 += local20;
		}
		if (arg3 > 0 && arg4 > 0) {
			this.method79(Draw2D.anIntArray10, arg0, arg5, local13, local5, arg3, arg4, local9, local11);
		}
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "([I[BIIIIIII)V")
	private void method79(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(6) int local6 = -(arg5 >> 2);
		@Pc(11) int local11 = -(arg5 & 0x3);
		for (@Pc(14) int local14 = -arg6; local14 < 0; local14++) {
			@Pc(18) int local18;
			for (local18 = local6; local18 < 0; local18++) {
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
			}
			for (local18 = local11; local18 < 0; local18++) {
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}
}
