import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!nb")
public final class Class1_Sub6 extends Class1 {

	@OriginalMember(owner = "client!nb", name = "e", descriptor = "I")
	public int anInt651;

	@OriginalMember(owner = "client!nb", name = "f", descriptor = "I")
	public final int anInt652;

	@OriginalMember(owner = "client!nb", name = "g", descriptor = "I")
	public final int anInt653;

	@OriginalMember(owner = "client!nb", name = "h", descriptor = "I")
	public final int anInt654;

	@OriginalMember(owner = "client!nb", name = "i", descriptor = "I")
	public final int anInt655;

	@OriginalMember(owner = "client!nb", name = "j", descriptor = "Lclient!jc;")
	public final Class19 aClass19_2;

	@OriginalMember(owner = "client!nb", name = "k", descriptor = "I")
	public int anInt656;

	@OriginalMember(owner = "client!nb", name = "l", descriptor = "I")
	public int anInt657;

	@OriginalMember(owner = "client!nb", name = "<init>", descriptor = "(ZIIIILclient!jc;II)V")
	public Class1_Sub6(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) Class19 arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		try {
			this.anInt651 = arg2;
			this.anInt652 = arg4;
			this.anInt653 = arg7;
			this.anInt654 = arg6;
			if (arg3 != 0) {
				throw new NullPointerException();
			}
			this.anInt655 = arg1;
			this.aClass19_2 = arg5;
			if (arg0 && arg5.anInt544 != -1) {
				this.anInt656 = (int) (Math.random() * (double) this.aClass19_2.anInt543);
				this.anInt657 = (int) (Math.random() * (double) this.aClass19_2.anIntArray188[this.anInt656]);
			} else {
				this.anInt656 = -1;
				this.anInt657 = 0;
			}
		} catch (@Pc(61) RuntimeException local61) {
			signlink.reporterror("91798, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + local61.toString());
			throw new RuntimeException();
		}
	}
}
