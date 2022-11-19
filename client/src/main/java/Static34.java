import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

public final class Static34 {

	@OriginalMember(owner = "client!zb", name = "r", descriptor = "[I")
	public static int[] anIntArray239;

	@OriginalMember(owner = "client!zb", name = "s", descriptor = "[I")
	public static int[] anIntArray240;

	@OriginalMember(owner = "client!zb", name = "t", descriptor = "[I")
	public static int[] anIntArray241;

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "I")
	public static final int anInt943 = 8;

	@OriginalMember(owner = "client!zb", name = "u", descriptor = "[I")
	public static final int[] anIntArray242 = new int[5];

	@OriginalMember(owner = "client!zb", name = "v", descriptor = "[I")
	public static final int[] anIntArray243 = new int[5];

	@OriginalMember(owner = "client!zb", name = "w", descriptor = "[I")
	public static final int[] anIntArray244 = new int[5];

	@OriginalMember(owner = "client!zb", name = "x", descriptor = "[I")
	public static final int[] anIntArray245 = new int[5];

	@OriginalMember(owner = "client!zb", name = "y", descriptor = "[I")
	public static final int[] anIntArray246 = new int[5];

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "()V")
	public static void method575() {
		anIntArray240 = new int[32768];
		for (@Pc(6) int local6 = 0; local6 < 32768; local6++) {
			if (Math.random() > 0.5D) {
				anIntArray240[local6] = 1;
			} else {
				anIntArray240[local6] = -1;
			}
		}
		anIntArray241 = new int[32768];
		for (@Pc(31) int local31 = 0; local31 < 32768; local31++) {
			anIntArray241[local31] = (int) (Math.sin((double) local31 / 5215.1903D) * 16384.0D);
		}
		anIntArray239 = new int[220500];
	}
}
