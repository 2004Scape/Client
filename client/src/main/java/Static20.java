import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static20 {

	@OriginalMember(owner = "client!jc", name = "c", descriptor = "I")
	private static int anInt542;

	@OriginalMember(owner = "client!jc", name = "d", descriptor = "[Lclient!jc;")
	public static Class19[] aClass19Array1;

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "Z")
	private static boolean aBoolean125 = true;

	@OriginalMember(owner = "client!jc", name = "b", descriptor = "I")
	private static final int anInt541 = 473;

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void method374(@OriginalArg(0) Class39 arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(9) Class1_Sub3_Sub3 local9 = new Class1_Sub3_Sub3(363, arg0.method536("seq.dat", null, (byte) 2));
			if (arg1 <= 0) {
				aBoolean125 = !aBoolean125;
			}
			anInt542 = local9.method393();
			if (aClass19Array1 == null) {
				aClass19Array1 = new Class19[anInt542];
			}
			for (@Pc(27) int local27 = 0; local27 < anInt542; local27++) {
				if (aClass19Array1[local27] == null) {
					aClass19Array1[local27] = new Class19();
				}
				aClass19Array1[local27].method375(false, local9);
			}
		} catch (@Pc(51) RuntimeException local51) {
			signlink.reporterror("35892, " + arg0 + ", " + arg1 + ", " + local51.toString());
			throw new RuntimeException();
		}
	}
}
