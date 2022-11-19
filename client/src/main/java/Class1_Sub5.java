import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!mb")
public final class Class1_Sub5 extends Class1 {

	@OriginalMember(owner = "client!mb", name = "e", descriptor = "I")
	private int anInt630 = 27808;

	@OriginalMember(owner = "client!mb", name = "f", descriptor = "I")
	public final int anInt631;

	@OriginalMember(owner = "client!mb", name = "g", descriptor = "I")
	public final int anInt632;

	@OriginalMember(owner = "client!mb", name = "h", descriptor = "I")
	public final int anInt633;

	@OriginalMember(owner = "client!mb", name = "i", descriptor = "I")
	public final int anInt634;

	@OriginalMember(owner = "client!mb", name = "j", descriptor = "I")
	public final int anInt635;

	@OriginalMember(owner = "client!mb", name = "k", descriptor = "I")
	public final int anInt636;

	@OriginalMember(owner = "client!mb", name = "l", descriptor = "I")
	public final int anInt637;

	@OriginalMember(owner = "client!mb", name = "m", descriptor = "I")
	public final int anInt638;

	@OriginalMember(owner = "client!mb", name = "<init>", descriptor = "(IIIIIIIII)V")
	public Class1_Sub5(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		try {
			if (arg4 != 2) {
				this.anInt630 = -420;
			}
			this.anInt631 = arg0;
			this.anInt632 = arg8;
			this.anInt633 = arg7;
			this.anInt634 = arg2;
			this.anInt635 = arg6;
			this.anInt636 = arg1;
			this.anInt637 = arg5;
			this.anInt638 = arg3;
		} catch (@Pc(36) RuntimeException local36) {
			signlink.reporterror("77675, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + local36.toString());
			throw new RuntimeException();
		}
	}
}
