import java.util.Random;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!j")
public final class Class2_Sub1_Sub1_Sub4 extends Class2_Sub1_Sub1 {

	@OriginalMember(owner = "mapview!j", name = "z", descriptor = "[I")
	private static int[] anIntArray17 = new int[256];

	@OriginalMember(owner = "mapview!j", name = "p", descriptor = "[[B")
	private byte[][] aByteArrayArray1 = new byte[94][];

	@OriginalMember(owner = "mapview!j", name = "q", descriptor = "[I")
	private int[] anIntArray11 = new int[94];

	@OriginalMember(owner = "mapview!j", name = "r", descriptor = "[I")
	private int[] anIntArray12 = new int[94];

	@OriginalMember(owner = "mapview!j", name = "s", descriptor = "[I")
	private int[] anIntArray13 = new int[94];

	@OriginalMember(owner = "mapview!j", name = "t", descriptor = "[I")
	private int[] anIntArray14 = new int[94];

	@OriginalMember(owner = "mapview!j", name = "u", descriptor = "[I")
	private int[] anIntArray15 = new int[95];

	@OriginalMember(owner = "mapview!j", name = "v", descriptor = "[I")
	private int[] anIntArray16 = new int[256];

	@OriginalMember(owner = "mapview!j", name = "w", descriptor = "I")
	private int anInt87 = 0;

	@OriginalMember(owner = "mapview!j", name = "x", descriptor = "Ljava/util/Random;")
	private Random aRandom1 = new Random();

	@OriginalMember(owner = "mapview!j", name = "y", descriptor = "Z")
	private boolean aBoolean18 = false;

	static {
		@Pc(4) String local4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
		for (@Pc(6) int local6 = 0; local6 < 256; local6++) {
			@Pc(11) int local11 = local4.indexOf(local6);
			if (local11 == -1) {
				local11 = 74;
			}
			anIntArray17[local6] = local11;
		}
	}

	@OriginalMember(owner = "mapview!j", name = "<init>", descriptor = "(Lmapview!p;Ljava/lang/String;)V")
	public Class2_Sub1_Sub1_Sub4(@OriginalArg(0) Class7 arg0, @OriginalArg(1) String arg1) {
		@Pc(57) Class2_Sub1_Sub2 local57 = new Class2_Sub1_Sub2(arg0.method145(arg1 + ".dat", null));
		@Pc(65) Class2_Sub1_Sub2 local65 = new Class2_Sub1_Sub2(arg0.method145("index.dat", null));
		@Pc(67) boolean local67 = true;
		local65.anInt89 = local57.method100() + 4;
		@Pc(76) int local76 = local65.method98();
		if (local76 > 0) {
			local65.anInt89 += (local76 - 1) * 3;
		}
		@Pc(90) int local90;
		for (local90 = 0; local90 < 94; local90++) {
			this.anIntArray13[local90] = local65.method98();
			this.anIntArray14[local90] = local65.method98();
			@Pc(119) int local119 = this.anIntArray11[local90] = local65.method100();
			@Pc(127) int local127 = this.anIntArray12[local90] = local65.method100();
			@Pc(130) int local130 = local65.method98();
			@Pc(134) int local134 = local119 * local127;
			this.aByteArrayArray1[local90] = new byte[local134];
			@Pc(144) int local144;
			@Pc(169) int local169;
			if (local130 == 0) {
				for (local144 = 0; local144 < local134; local144++) {
					this.aByteArrayArray1[local90][local144] = local57.method99();
				}
			} else if (local130 == 1) {
				for (local144 = 0; local144 < local119; local144++) {
					for (local169 = 0; local169 < local127; local169++) {
						this.aByteArrayArray1[local90][local144 + local169 * local119] = local57.method99();
					}
				}
			}
			if (local127 > this.anInt87) {
				this.anInt87 = local127;
			}
			this.anIntArray13[local90] = 1;
			this.anIntArray15[local90] = local119 + 2;
			local144 = 0;
			for (local169 = local127 / 7; local169 < local127; local169++) {
				local144 += this.aByteArrayArray1[local90][local169 * local119];
			}
			if (local144 <= local127 / 7) {
				this.anIntArray15[local90] += -1;
				this.anIntArray13[local90] = 0;
			}
			local144 = 0;
			for (local169 = local127 / 7; local169 < local127; local169++) {
				local144 += this.aByteArrayArray1[local90][local119 - 1 + local169 * local119];
			}
			if (local144 <= local127 / 7) {
				this.anIntArray15[local90] += -1;
			}
		}
		this.anIntArray15[94] = this.anIntArray15[8];
		for (local90 = 0; local90 < 256; local90++) {
			this.anIntArray16[local90] = this.anIntArray15[anIntArray17[local90]];
		}
	}

	@OriginalMember(owner = "mapview!j", name = "a", descriptor = "(Ljava/lang/String;III)V")
	public void method91(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (arg0 == null) {
			return;
		}
		@Pc(7) int local7 = arg2 - this.anInt87;
		for (@Pc(9) int local9 = 0; local9 < arg0.length(); local9++) {
			@Pc(17) int local17 = anIntArray17[arg0.charAt(local9)];
			if (local17 != 94) {
				this.method94(this.aByteArrayArray1[local17], arg1 + this.anIntArray13[local17], local7 + this.anIntArray14[local17], this.anIntArray11[local17], this.anIntArray12[local17], arg3);
			}
			arg1 += this.anIntArray15[local17];
		}
	}

	@OriginalMember(owner = "mapview!j", name = "b", descriptor = "(Ljava/lang/String;III)V")
	public void method92(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		this.method91(arg0, arg1 - this.method93(arg0) / 2, arg2, arg3);
	}

	@OriginalMember(owner = "mapview!j", name = "a", descriptor = "(Ljava/lang/String;)I")
	private int method93(@OriginalArg(0) String arg0) {
		if (arg0 == null) {
			return 0;
		}
		@Pc(7) int local7 = 0;
		for (@Pc(9) int local9 = 0; local9 < arg0.length(); local9++) {
			if (arg0.charAt(local9) == '@' && local9 + 4 < arg0.length() && arg0.charAt(local9 + 4) == '@') {
				local9 += 4;
			} else {
				local7 += this.anIntArray16[arg0.charAt(local9)];
			}
		}
		return local7;
	}

	@OriginalMember(owner = "mapview!j", name = "a", descriptor = "([BIIIII)V")
	private void method94(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(5) int local5 = arg1 + arg2 * Class2_Sub1_Sub1.anInt78;
		@Pc(9) int local9 = Class2_Sub1_Sub1.anInt78 - arg3;
		@Pc(11) int local11 = 0;
		@Pc(13) int local13 = 0;
		@Pc(20) int local20;
		if (arg2 < Class2_Sub1_Sub1.anInt80) {
			local20 = Class2_Sub1_Sub1.anInt80 - arg2;
			arg4 -= local20;
			arg2 = Class2_Sub1_Sub1.anInt80;
			local13 += local20 * arg3;
			local5 += local20 * Class2_Sub1_Sub1.anInt78;
		}
		if (arg2 + arg4 >= Class2_Sub1_Sub1.anInt81) {
			arg4 -= arg2 + arg4 - Class2_Sub1_Sub1.anInt81 + 1;
		}
		if (arg1 < Class2_Sub1_Sub1.anInt82) {
			local20 = Class2_Sub1_Sub1.anInt82 - arg1;
			arg3 -= local20;
			arg1 = Class2_Sub1_Sub1.anInt82;
			local13 += local20;
			local5 += local20;
			local11 += local20;
			local9 += local20;
		}
		if (arg1 + arg3 >= Class2_Sub1_Sub1.anInt83) {
			local20 = arg1 + arg3 - Class2_Sub1_Sub1.anInt83 + 1;
			arg3 -= local20;
			local11 += local20;
			local9 += local20;
		}
		if (arg3 > 0 && arg4 > 0) {
			this.method95(Class2_Sub1_Sub1.anIntArray10, arg0, arg5, local13, local5, arg3, arg4, local9, local11);
		}
	}

	@OriginalMember(owner = "mapview!j", name = "a", descriptor = "([I[BIIIIIII)V")
	private void method95(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
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
