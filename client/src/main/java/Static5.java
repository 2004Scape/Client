import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static5 {

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "I")
	private static int anInt98;

	@OriginalMember(owner = "client!cc", name = "e", descriptor = "I")
	private static int anInt101;

	@OriginalMember(owner = "client!cc", name = "f", descriptor = "[I")
	private static int[] anIntArray23;

	@OriginalMember(owner = "client!cc", name = "g", descriptor = "Lclient!kb;")
	private static Class1_Sub3_Sub3 aClass1_Sub3_Sub3_3;

	@OriginalMember(owner = "client!cc", name = "h", descriptor = "[Lclient!cc;")
	private static Class5[] aClass5Array1;

	@OriginalMember(owner = "client!cc", name = "i", descriptor = "I")
	private static int anInt102;

	@OriginalMember(owner = "client!cc", name = "c", descriptor = "I")
	public static int anInt99 = -192;

	@OriginalMember(owner = "client!cc", name = "j", descriptor = "Z")
	public static boolean aBoolean29 = true;

	@OriginalMember(owner = "client!cc", name = "T", descriptor = "Lclient!s;")
	public static Class35 aClass35_4 = new Class35((byte) 0, 50);

	@OriginalMember(owner = "client!cc", name = "U", descriptor = "Lclient!s;")
	public static Class35 aClass35_5 = new Class35((byte) 0, 200);

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void method52(@OriginalArg(0) Class39 arg0) {
		aClass1_Sub3_Sub3_3 = new Class1_Sub3_Sub3(363, arg0.method536("obj.dat", null, (byte) 2));
		@Pc(21) Class1_Sub3_Sub3 local21 = new Class1_Sub3_Sub3(363, arg0.method536("obj.idx", null, (byte) 2));
		anInt101 = local21.method393();
		anIntArray23 = new int[anInt101];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < anInt101; local31++) {
			anIntArray23[local31] = local29;
			local29 += local21.method393();
		}
		aClass5Array1 = new Class5[10];
		for (@Pc(51) int local51 = 0; local51 < 10; local51++) {
			aClass5Array1[local51] = new Class5();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)V")
	public static void method53(@OriginalArg(0) boolean arg0) {
		try {
			aClass35_4 = null;
			aClass35_5 = null;
			anIntArray23 = null;
			aClass5Array1 = null;
			aClass1_Sub3_Sub3_3 = null;
			if (!arg0) {
				anInt98 = -296;
			}
		} catch (@Pc(15) RuntimeException local15) {
			signlink.reporterror("12851, " + arg0 + ", " + local15.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(I)Lclient!cc;")
	public static Class5 method54(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 10; local1++) {
			if (aClass5Array1[local1].anInt103 == arg0) {
				return aClass5Array1[local1];
			}
		}
		anInt102 = (anInt102 + 1) % 10;
		@Pc(27) Class5 local27 = aClass5Array1[anInt102];
		aClass1_Sub3_Sub3_3.anInt561 = anIntArray23[arg0];
		local27.anInt103 = arg0;
		local27.method55();
		local27.method56(false, aClass1_Sub3_Sub3_3);
		if (local27.anInt124 != -1) {
			local27.method57(-856);
		}
		if (!aBoolean29 && local27.aBoolean32) {
			local27.aString3 = "Members Object";
			local27.aByteArray3 = "Login to a members' server to use this object.".getBytes();
			local27.aStringArray3 = null;
			local27.aStringArray4 = null;
		}
		return local27;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(III)Lclient!hb;")
	public static Class1_Sub3_Sub2_Sub2 method59(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(7) Class1_Sub3_Sub2_Sub2 local7 = (Class1_Sub3_Sub2_Sub2) aClass35_5.method527((long) arg0);
			if (local7 != null && local7.anInt466 != arg2 && local7.anInt466 != -1) {
				local7.method567();
				local7 = null;
			}
			if (local7 != null) {
				return local7;
			}
			@Pc(28) Class5 local28 = method54(arg0);
			if (local28.anIntArray26 == null) {
				arg2 = -1;
			}
			@Pc(38) int local38;
			@Pc(40) int local40;
			if (arg2 > 1) {
				local38 = -1;
				for (local40 = 0; local40 < 10; local40++) {
					if (arg2 >= local28.anIntArray27[local40] && local28.anIntArray27[local40] != 0) {
						local38 = local28.anIntArray26[local40];
					}
				}
				if (local38 != -1) {
					local28 = method54(local38);
				}
			}
			local7 = new Class1_Sub3_Sub2_Sub2(32, 32);
			local38 = Static15.anInt430;
			local40 = Static15.anInt431;
			@Pc(80) int[] local80 = Static15.anIntArray139;
			@Pc(82) int[] local82 = Static12.anIntArray178;
			@Pc(84) int local84 = Static12.anInt528;
			@Pc(86) int local86 = Static12.anInt529;
			@Pc(88) int local88 = Static12.anInt532;
			@Pc(90) int local90 = Static12.anInt533;
			@Pc(92) int local92 = Static12.anInt530;
			@Pc(94) int local94 = Static12.anInt531;
			Static15.aBoolean99 = false;
			Static12.method354(32, local7.anIntArray148, -657, 32);
			Static12.method358(0, 0, 0, (byte) 93, 32, 32);
			Static15.method288(anInt99);
			@Pc(115) Class1_Sub3_Sub1 local115 = local28.method58(1);
			@Pc(125) int local125 = Class1_Sub3_Sub2_Sub1.anIntArray137[local28.anInt106] * local28.anInt105 >> 16;
			@Pc(135) int local135 = Class1_Sub3_Sub2_Sub1.anIntArray138[local28.anInt106] * local28.anInt105 >> 16;
			local115.method243(0, local28.anInt107, local28.anInt108, local28.anInt106, local28.anInt109, local125 + local115.anInt368 / 2 + local28.anInt110, local135 + local28.anInt110);
			if (arg1 != 24638) {
				throw new NullPointerException();
			}
			for (@Pc(168) int local168 = 31; local168 >= 0; local168--) {
				for (local135 = 31; local135 >= 0; local135--) {
					if (local7.anIntArray148[local168 + local135 * 32] == 0) {
						if (local168 > 0 && local7.anIntArray148[local168 + local135 * 32 - 1] > 1) {
							local7.anIntArray148[local168 + local135 * 32] = 1;
						} else if (local135 > 0 && local7.anIntArray148[local168 + (local135 - 1) * 32] > 1) {
							local7.anIntArray148[local168 + local135 * 32] = 1;
						} else if (local168 < 31 && local7.anIntArray148[local168 + local135 * 32 + 1] > 1) {
							local7.anIntArray148[local168 + local135 * 32] = 1;
						} else if (local135 < 31 && local7.anIntArray148[local168 + (local135 + 1) * 32] > 1) {
							local7.anIntArray148[local168 + local135 * 32] = 1;
						}
					}
				}
			}
			for (@Pc(291) int local291 = 31; local291 >= 0; local291--) {
				for (local135 = 31; local135 >= 0; local135--) {
					if (local7.anIntArray148[local291 + local135 * 32] == 0 && local291 > 0 && local135 > 0 && local7.anIntArray148[local291 + (local135 - 1) * 32 - 1] > 0) {
						local7.anIntArray148[local291 + local135 * 32] = 3153952;
					}
				}
			}
			if (local28.anInt124 != -1) {
				@Pc(348) Class1_Sub3_Sub2_Sub2 local348 = method59(local28.anInt123, 24638, 10);
				@Pc(351) int local351 = local348.anInt465;
				@Pc(354) int local354 = local348.anInt466;
				local348.anInt465 = 32;
				local348.anInt466 = 32;
				local348.method324(22, 5, 22, 17713, 5);
				local348.anInt465 = local351;
				local348.anInt466 = local354;
			}
			aClass35_5.method528(6, (long) arg0, local7);
			Static12.method354(local84, local82, -657, local86);
			Static12.method356(local94, local92, local90, 789, local88);
			Static15.anInt430 = local38;
			Static15.anInt431 = local40;
			Static15.anIntArray139 = local80;
			Static15.aBoolean99 = true;
			if (local28.aBoolean31) {
				local7.anInt465 = 33;
			} else {
				local7.anInt465 = 32;
			}
			local7.anInt466 = arg2;
			return local7;
		} catch (@Pc(415) RuntimeException local415) {
			signlink.reporterror("43278, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local415.toString());
			throw new RuntimeException();
		}
	}
}
