import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static22 {

	@OriginalMember(owner = "client!kc", name = "b", descriptor = "I")
	private static int anInt567;

	@OriginalMember(owner = "client!kc", name = "c", descriptor = "[Lclient!kc;")
	public static Class21[] aClass21Array1;

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "I")
	private static final int anInt566 = 473;

	@OriginalMember(owner = "client!kc", name = "p", descriptor = "Lclient!s;")
	public static Class35 aClass35_8 = new Class35((byte) 0, 30);

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void method407(@OriginalArg(0) Class39 arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = 91 / arg1;
			@Pc(13) Class1_Sub3_Sub3 local13 = new Class1_Sub3_Sub3(363, arg0.method536("spotanim.dat", null, (byte) 2));
			anInt567 = local13.method393();
			if (aClass21Array1 == null) {
				aClass21Array1 = new Class21[anInt567];
			}
			for (@Pc(23) int local23 = 0; local23 < anInt567; local23++) {
				if (aClass21Array1[local23] == null) {
					aClass21Array1[local23] = new Class21();
				}
				aClass21Array1[local23].anInt568 = local23;
				aClass21Array1[local23].method408(false, local13);
			}
		} catch (@Pc(52) RuntimeException local52) {
			signlink.reporterror("26561, " + arg0 + ", " + arg1 + ", " + local52.toString());
			throw new RuntimeException();
		}
	}
}
