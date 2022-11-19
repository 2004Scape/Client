import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static3 {

	@OriginalMember(owner = "client!bc", name = "b", descriptor = "I")
	private static int anInt67;

	@OriginalMember(owner = "client!bc", name = "c", descriptor = "[I")
	private static int[] anIntArray8;

	@OriginalMember(owner = "client!bc", name = "d", descriptor = "Lclient!kb;")
	private static Class1_Sub3_Sub3 aClass1_Sub3_Sub3_2;

	@OriginalMember(owner = "client!bc", name = "e", descriptor = "[Lclient!bc;")
	private static Class3[] aClass3Array1;

	@OriginalMember(owner = "client!bc", name = "f", descriptor = "I")
	private static int anInt68;

	@OriginalMember(owner = "client!bc", name = "C", descriptor = "Lclient!s;")
	public static Class35 aClass35_3 = new Class35((byte) 0, 30);

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void method30(@OriginalArg(0) Class39 arg0) {
		aClass1_Sub3_Sub3_2 = new Class1_Sub3_Sub3(363, arg0.method536("npc.dat", null, (byte) 2));
		@Pc(21) Class1_Sub3_Sub3 local21 = new Class1_Sub3_Sub3(363, arg0.method536("npc.idx", null, (byte) 2));
		anInt67 = local21.method393();
		anIntArray8 = new int[anInt67];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < anInt67; local31++) {
			anIntArray8[local31] = local29;
			local29 += local21.method393();
		}
		aClass3Array1 = new Class3[20];
		for (@Pc(51) int local51 = 0; local51 < 20; local51++) {
			aClass3Array1[local51] = new Class3();
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Z)V")
	public static void method31(@OriginalArg(0) boolean arg0) {
		try {
			aClass35_3 = null;
			anIntArray8 = null;
			aClass3Array1 = null;
			if (!arg0) {
				for (@Pc(9) int local9 = 1; local9 > 0; local9++) {
				}
			}
			aClass1_Sub3_Sub3_2 = null;
		} catch (@Pc(18) RuntimeException local18) {
			signlink.reporterror("32991, " + arg0 + ", " + local18.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(I)Lclient!bc;")
	public static Class3 method32(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 20; local1++) {
			if (aClass3Array1[local1].aLong5 == (long) arg0) {
				return aClass3Array1[local1];
			}
		}
		anInt68 = (anInt68 + 1) % 20;
		@Pc(33) Class3 local33 = aClass3Array1[anInt68] = new Class3();
		aClass1_Sub3_Sub3_2.anInt561 = anIntArray8[arg0];
		local33.aLong5 = arg0;
		local33.method33(false, aClass1_Sub3_Sub3_2);
		return local33;
	}
}
