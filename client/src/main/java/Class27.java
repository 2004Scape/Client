import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!o")
public final class Class27 {

	@OriginalMember(owner = "client!o", name = "f", descriptor = "Z")
	public boolean aBoolean138 = true;

	@OriginalMember(owner = "client!o", name = "a", descriptor = "I")
	public final int anInt658;

	@OriginalMember(owner = "client!o", name = "b", descriptor = "I")
	public final int anInt659;

	@OriginalMember(owner = "client!o", name = "c", descriptor = "I")
	public final int anInt660;

	@OriginalMember(owner = "client!o", name = "d", descriptor = "I")
	public final int anInt661;

	@OriginalMember(owner = "client!o", name = "e", descriptor = "I")
	public final int anInt662;

	@OriginalMember(owner = "client!o", name = "g", descriptor = "I")
	public final int anInt663;

	@OriginalMember(owner = "client!o", name = "<init>", descriptor = "(IIIIIIZ)V")
	public Class27(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6) {
		this.anInt658 = arg0;
		this.anInt659 = arg1;
		this.anInt660 = arg2;
		this.anInt661 = arg3;
		this.anInt662 = arg4;
		this.anInt663 = arg5;
		this.aBoolean138 = arg6;
	}
}
