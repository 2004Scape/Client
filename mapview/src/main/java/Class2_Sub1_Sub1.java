import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!f")
public class Class2_Sub1_Sub1 extends Class2_Sub1 {

	@OriginalMember(owner = "mapview!f", name = "e", descriptor = "[I")
	public static int[] anIntArray10;

	@OriginalMember(owner = "mapview!f", name = "f", descriptor = "I")
	public static int anInt78;

	@OriginalMember(owner = "mapview!f", name = "g", descriptor = "I")
	private static int anInt79;

	@OriginalMember(owner = "mapview!f", name = "l", descriptor = "I")
	private static int anInt84;

	@OriginalMember(owner = "mapview!f", name = "m", descriptor = "I")
	private static int anInt85;

	@OriginalMember(owner = "mapview!f", name = "n", descriptor = "I")
	private static int anInt86;

	@OriginalMember(owner = "mapview!f", name = "h", descriptor = "I")
	protected static int anInt80 = 0;

	@OriginalMember(owner = "mapview!f", name = "i", descriptor = "I")
	protected static int anInt81 = 0;

	@OriginalMember(owner = "mapview!f", name = "j", descriptor = "I")
	protected static int anInt82 = 0;

	@OriginalMember(owner = "mapview!f", name = "k", descriptor = "I")
	protected static int anInt83 = 0;

	@OriginalMember(owner = "mapview!f", name = "a", descriptor = "(IIII)V")
	public static void method82(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (arg1 < anInt80 || arg1 >= anInt81) {
			return;
		}
		if (arg0 < anInt82) {
			arg2 -= anInt82 - arg0;
			arg0 = anInt82;
		}
		if (arg0 + arg2 > anInt83) {
			arg2 = anInt83 - arg0;
		}
		@Pc(32) int local32 = arg0 + arg1 * anInt78;
		for (@Pc(34) int local34 = 0; local34 < arg2; local34++) {
			anIntArray10[local32 + local34] = arg3;
		}
	}

	@OriginalMember(owner = "mapview!f", name = "b", descriptor = "(IIII)V")
	public static void method83(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (arg0 < anInt82 || arg0 >= anInt83) {
			return;
		}
		if (arg1 < anInt80) {
			arg2 -= anInt80 - arg1;
			arg1 = anInt80;
		}
		if (arg1 + arg2 > anInt81) {
			arg2 = anInt81 - arg1;
		}
		@Pc(32) int local32 = arg0 + arg1 * anInt78;
		for (@Pc(34) int local34 = 0; local34 < arg2; local34++) {
			anIntArray10[local32 + local34 * anInt78] = arg3;
		}
	}

	@OriginalMember(owner = "mapview!f", name = "c", descriptor = "(IIII)V")
	private static void method84(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (arg0 < 0) {
			arg0 = 0;
		}
		if (arg1 < 0) {
			arg1 = 0;
		}
		if (arg2 > anInt78) {
			arg2 = anInt78;
		}
		if (arg3 > anInt79) {
			arg3 = anInt79;
		}
		anInt82 = arg0;
		anInt80 = arg1;
		anInt83 = arg2;
		anInt81 = arg3;
		anInt84 = anInt83 - 1;
		anInt85 = anInt83 / 2;
		anInt86 = anInt81 / 2;
	}

	@OriginalMember(owner = "mapview!f", name = "a", descriptor = "(IIIIII)V")
	public static void method85(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		if (arg0 < anInt82) {
			arg2 -= anInt82 - arg0;
			arg0 = anInt82;
		}
		if (arg1 < anInt80) {
			arg3 -= anInt80 - arg1;
			arg1 = anInt80;
		}
		if (arg0 + arg2 > anInt83) {
			arg2 = anInt83 - arg0;
		}
		if (arg1 + arg3 > anInt81) {
			arg3 = anInt81 - arg1;
		}
		@Pc(45) int local45 = 256 - arg5;
		@Pc(53) int local53 = (arg4 >> 16 & 0xFF) * arg5;
		@Pc(61) int local61 = (arg4 >> 8 & 0xFF) * arg5;
		@Pc(67) int local67 = (arg4 & 0xFF) * arg5;
		@Pc(71) int local71 = anInt78 - arg2;
		@Pc(77) int local77 = arg0 + arg1 * anInt78;
		for (@Pc(79) int local79 = 0; local79 < arg3; local79++) {
			for (@Pc(84) int local84 = -arg2; local84 < 0; local84++) {
				@Pc(96) int local96 = (anIntArray10[local77] >> 16 & 0xFF) * local45;
				@Pc(106) int local106 = (anIntArray10[local77] >> 8 & 0xFF) * local45;
				@Pc(114) int local114 = (anIntArray10[local77] & 0xFF) * local45;
				@Pc(136) int local136 = (local53 + local96 >> 8 << 16) + (local61 + local106 >> 8 << 8) + (local67 + local114 >> 8);
				anIntArray10[local77++] = local136;
			}
			local77 += local71;
		}
	}

	@OriginalMember(owner = "mapview!f", name = "a", descriptor = "(IIIII)V")
	public static void method86(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		method82(arg0, arg1, arg2, arg4);
		method82(arg0, arg1 + arg3 - 1, arg2, arg4);
		method83(arg0, arg1, arg3, arg4);
		method83(arg0 + arg2 - 1, arg1, arg3, arg4);
	}

	@OriginalMember(owner = "mapview!f", name = "a", descriptor = "([III)V")
	public static void method87(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		anIntArray10 = arg0;
		anInt78 = arg1;
		anInt79 = arg2;
		method84(0, 0, arg1, arg2);
	}

	@OriginalMember(owner = "mapview!f", name = "b", descriptor = "(IIIII)V")
	public static void method88(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg0 < anInt82) {
			arg2 -= anInt82 - arg0;
			arg0 = anInt82;
		}
		if (arg1 < anInt80) {
			arg3 -= anInt80 - arg1;
			arg1 = anInt80;
		}
		if (arg0 + arg2 > anInt83) {
			arg2 = anInt83 - arg0;
		}
		if (arg1 + arg3 > anInt81) {
			arg3 = anInt81 - arg1;
		}
		@Pc(45) int local45 = anInt78 - arg2;
		@Pc(47) boolean local47 = true;
		@Pc(53) int local53 = arg0 + arg1 * anInt78;
		for (@Pc(56) int local56 = -arg3; local56 < 0; local56++) {
			for (@Pc(61) int local61 = -arg2; local61 < 0; local61++) {
				anIntArray10[local53++] = arg4;
			}
			local53 += local45;
		}
	}

	@OriginalMember(owner = "mapview!f", name = "b", descriptor = "()V")
	public static void method89() {
		@Pc(3) int local3 = anInt78 * anInt79;
		for (@Pc(5) int local5 = 0; local5 < local3; local5++) {
			anIntArray10[local5] = 0;
		}
	}

	@OriginalMember(owner = "mapview!f", name = "c", descriptor = "(IIIII)V")
	public static void method90(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(5) int local5 = 256 - arg4;
		@Pc(13) int local13 = (arg3 >> 16 & 0xFF) * arg4;
		@Pc(21) int local21 = (arg3 >> 8 & 0xFF) * arg4;
		@Pc(27) int local27 = (arg3 & 0xFF) * arg4;
		@Pc(31) int local31 = arg1 - arg2;
		if (local31 < 0) {
			local31 = 0;
		}
		@Pc(39) int local39 = arg1 + arg2;
		if (local39 >= anInt79) {
			local39 = anInt79 - 1;
		}
		for (@Pc(48) int local48 = local31; local48 <= local39; local48++) {
			@Pc(54) int local54 = local48 - arg1;
			@Pc(65) int local65 = (int) Math.sqrt((double) (arg2 * arg2 - local54 * local54));
			@Pc(69) int local69 = arg0 - local65;
			if (local69 < 0) {
				local69 = 0;
			}
			@Pc(77) int local77 = arg0 + local65;
			if (local77 >= anInt78) {
				local77 = anInt78 - 1;
			}
			@Pc(90) int local90 = local69 + local48 * anInt78;
			for (@Pc(92) int local92 = local69; local92 <= local77; local92++) {
				@Pc(104) int local104 = (anIntArray10[local90] >> 16 & 0xFF) * local5;
				@Pc(114) int local114 = (anIntArray10[local90] >> 8 & 0xFF) * local5;
				@Pc(122) int local122 = (anIntArray10[local90] & 0xFF) * local5;
				@Pc(144) int local144 = (local13 + local104 >> 8 << 16) + (local21 + local114 >> 8 << 8) + (local27 + local122 >> 8);
				anIntArray10[local90++] = local144;
			}
		}
	}

	@OriginalMember(owner = "mapview!f", name = "<init>", descriptor = "()V")
	protected Class2_Sub1_Sub1() {
	}
}
