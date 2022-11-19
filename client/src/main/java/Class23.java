import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!lc")
public final class Class23 {

	@OriginalMember(owner = "client!lc", name = "g", descriptor = "Ljava/lang/String;")
	private String aString25;

	@OriginalMember(owner = "client!lc", name = "h", descriptor = "I")
	private int anInt607;

	@OriginalMember(owner = "client!lc", name = "i", descriptor = "I")
	private int anInt608;

	@OriginalMember(owner = "client!lc", name = "l", descriptor = "I")
	public int anInt609;

	@OriginalMember(owner = "client!lc", name = "n", descriptor = "I")
	private int anInt610;

	@OriginalMember(owner = "client!lc", name = "j", descriptor = "Z")
	private boolean aBoolean132 = false;

	@OriginalMember(owner = "client!lc", name = "k", descriptor = "Z")
	private boolean aBoolean133 = true;

	@OriginalMember(owner = "client!lc", name = "m", descriptor = "Z")
	private boolean aBoolean134 = false;

	@OriginalMember(owner = "client!lc", name = "o", descriptor = "Z")
	private boolean aBoolean135 = false;

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(IILclient!kb;)V")
	public void method412(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class1_Sub3_Sub3 arg2) {
		try {
			if (arg0 == 13703) {
				while (true) {
					@Pc(8) int local8 = arg2.method391();
					if (local8 == 0) {
						return;
					}
					if (local8 == 1) {
						this.anInt607 = arg2.method391();
					} else if (local8 == 2) {
						this.anInt608 = arg2.method391();
					} else if (local8 == 3) {
						this.aBoolean132 = true;
						Static23.anIntArray194[Static23.anInt606++] = arg1;
					} else if (local8 == 4) {
						this.aBoolean133 = false;
					} else if (local8 == 5) {
						this.anInt609 = arg2.method393();
					} else if (local8 == 6) {
						this.aBoolean134 = true;
					} else if (local8 == 7) {
						this.anInt610 = arg2.method396();
					} else if (local8 == 8) {
						this.aBoolean135 = true;
					} else if (local8 == 10) {
						this.aString25 = arg2.method398();
					} else {
						System.out.println("Error unrecognised config code: " + local8);
					}
				}
			}
		} catch (@Pc(107) RuntimeException local107) {
			signlink.reporterror("67426, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local107.toString());
			throw new RuntimeException();
		}
	}
}
