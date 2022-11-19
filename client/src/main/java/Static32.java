import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static32 {

	@OriginalMember(owner = "client!yb", name = "e", descriptor = "[B")
	public static byte[] aByteArray15;

	@OriginalMember(owner = "client!yb", name = "f", descriptor = "Lclient!kb;")
	public static Class1_Sub3_Sub3 aClass1_Sub3_Sub3_23;

	@OriginalMember(owner = "client!yb", name = "b", descriptor = "I")
	public static int anInt877 = 473;

	@OriginalMember(owner = "client!yb", name = "c", descriptor = "[Lclient!yb;")
	private static final Class43[] aClass43Array1 = new Class43[1000];

	@OriginalMember(owner = "client!yb", name = "d", descriptor = "[I")
	public static final int[] anIntArray231 = new int[1000];

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(Lclient!kb;I)V")
	public static void method561(@OriginalArg(0) Class1_Sub3_Sub3 arg0, @OriginalArg(1) int arg1) {
		try {
			aByteArray15 = new byte[441000];
			aClass1_Sub3_Sub3_23 = new Class1_Sub3_Sub3(363, aByteArray15);
			@Pc(12) int local12 = 87 / arg1;
			Static34.method575();
			while (true) {
				@Pc(16) int local16 = arg0.method393();
				if (local16 == 65535) {
					return;
				}
				aClass43Array1[local16] = new Class43();
				aClass43Array1[local16].method563(false, arg0);
				anIntArray231[local16] = aClass43Array1[local16].method564((byte) 7);
			}
		} catch (@Pc(42) RuntimeException local42) {
			signlink.reporterror("6214, " + arg0 + ", " + arg1 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(BII)Lclient!kb;")
	public static Class1_Sub3_Sub3 method562(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 != -16) {
				anInt877 = -83;
			}
			if (aClass43Array1[arg2] == null) {
				return null;
			} else {
				@Pc(12) Class43 local12 = aClass43Array1[arg2];
				return local12.method565(true, arg1);
			}
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("72905, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}
}
