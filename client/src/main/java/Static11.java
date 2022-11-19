import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static11 {

	@OriginalMember(owner = "client!f", name = "a", descriptor = "[Lclient!f;")
	public static Class10[] aClass10Array1;

	@OriginalMember(owner = "client!f", name = "a", descriptor = "(ZLclient!ub;)V")
	public static void method261(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class39 arg1) {
		try {
			@Pc(11) Class1_Sub3_Sub3 local11 = new Class1_Sub3_Sub3(363, arg1.method536("base_head.dat", null, (byte) 2));
			@Pc(21) Class1_Sub3_Sub3 local21 = new Class1_Sub3_Sub3(363, arg1.method536("base_type.dat", null, (byte) 2));
			@Pc(31) Class1_Sub3_Sub3 local31 = new Class1_Sub3_Sub3(363, arg1.method536("base_label.dat", null, (byte) 2));
			@Pc(34) int local34 = local11.method393();
			@Pc(37) int local37 = local11.method393();
			aClass10Array1 = new Class10[local37 + 1];
			if (arg0) {
				throw new NullPointerException();
			}
			for (@Pc(50) int local50 = 0; local50 < local34; local50++) {
				@Pc(55) int local55 = local11.method393();
				@Pc(58) int local58 = local11.method391();
				@Pc(61) int[] local61 = new int[local58];
				@Pc(64) int[][] local64 = new int[local58][];
				for (@Pc(66) int local66 = 0; local66 < local58; local66++) {
					local61[local66] = local21.method391();
					@Pc(76) int local76 = local31.method391();
					local64[local66] = new int[local76];
					for (@Pc(83) int local83 = 0; local83 < local76; local83++) {
						local64[local66][local83] = local31.method391();
					}
				}
				aClass10Array1[local55] = new Class10();
				aClass10Array1[local55].anInt385 = local58;
				aClass10Array1[local55].anIntArray128 = local61;
				aClass10Array1[local55].anIntArrayArray11 = local64;
			}
		} catch (@Pc(127) RuntimeException local127) {
			signlink.reporterror("88924, " + arg0 + ", " + arg1 + ", " + local127.toString());
			throw new RuntimeException();
		}
	}
}
