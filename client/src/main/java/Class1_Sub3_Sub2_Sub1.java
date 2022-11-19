import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gb")
public final class Class1_Sub3_Sub2_Sub1 extends Class1_Sub3_Sub2 {

	@OriginalMember(owner = "client!gb", name = "H", descriptor = "[I")
	public static int[] anIntArray135 = new int[512];

	@OriginalMember(owner = "client!gb", name = "I", descriptor = "[I")
	public static final int[] anIntArray136 = new int[2048];

	@OriginalMember(owner = "client!gb", name = "J", descriptor = "[I")
	public static int[] anIntArray137 = new int[2048];

	@OriginalMember(owner = "client!gb", name = "K", descriptor = "[I")
	public static int[] anIntArray138 = new int[2048];

	static {
		for (@Pc(23) int local23 = 1; local23 < 512; local23++) {
			anIntArray135[local23] = 32768 / local23;
		}
		for (@Pc(36) int local36 = 1; local36 < 2048; local36++) {
			anIntArray136[local36] = 65536 / local36;
		}
		for (@Pc(49) int local49 = 0; local49 < 2048; local49++) {
			anIntArray137[local49] = (int) (Math.sin((double) local49 * 0.0030679615D) * 65536.0D);
			anIntArray138[local49] = (int) (Math.cos((double) local49 * 0.0030679615D) * 65536.0D);
		}
	}
}
