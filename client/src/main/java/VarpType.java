import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!lc")
public final class VarpType {

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "I")
	private static final int flowObfuscator1 = 473;

	@OriginalMember(owner = "client!lc", name = "b", descriptor = "I")
	private static final int flowObfuscator2 = 13703;

	@OriginalMember(owner = "client!lc", name = "c", descriptor = "I")
	private static int anInt605;

	@OriginalMember(owner = "client!lc", name = "d", descriptor = "[Lclient!lc;")
	public static VarpType[] aClass23Array1;

	@OriginalMember(owner = "client!lc", name = "e", descriptor = "I")
	public static int anInt606;

	@OriginalMember(owner = "client!lc", name = "f", descriptor = "[I")
	public static int[] anIntArray194;

	@OriginalMember(owner = "client!lc", name = "g", descriptor = "Ljava/lang/String;")
	private String aString25;

	@OriginalMember(owner = "client!lc", name = "h", descriptor = "I")
	private int anInt607;

	@OriginalMember(owner = "client!lc", name = "i", descriptor = "I")
	private int anInt608;

	@OriginalMember(owner = "client!lc", name = "j", descriptor = "Z")
	private boolean aBoolean132 = false;

	@OriginalMember(owner = "client!lc", name = "k", descriptor = "Z")
	private boolean aBoolean133 = true;

	@OriginalMember(owner = "client!lc", name = "l", descriptor = "I")
	public int anInt609;

	@OriginalMember(owner = "client!lc", name = "n", descriptor = "I")
	private int anInt610;

	@OriginalMember(owner = "client!lc", name = "m", descriptor = "Z")
	private boolean aBoolean134 = false;

	@OriginalMember(owner = "client!lc", name = "o", descriptor = "Z")
	private boolean aBoolean135 = false;

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void method411(@OriginalArg(0) FileArchive arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(9) Buffer local9 = new Buffer(363, arg0.method536("varp.dat", null, (byte) 2));
			anInt606 = 0;
			@Pc(15) int local15 = 28 / arg1;
			anInt605 = local9.method393();
			if (aClass23Array1 == null) {
				aClass23Array1 = new VarpType[anInt605];
			}
			if (anIntArray194 == null) {
				anIntArray194 = new int[anInt605];
			}
			for (@Pc(30) int local30 = 0; local30 < anInt605; local30++) {
				if (aClass23Array1[local30] == null) {
					aClass23Array1[local30] = new VarpType();
				}
				aClass23Array1[local30].method412(flowObfuscator2, local30, local9);
			}
		} catch (@Pc(55) RuntimeException local55) {
			signlink.reporterror("45283, " + arg0 + ", " + arg1 + ", " + local55.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(IILclient!kb;)V")
	public void method412(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Buffer arg2) {
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
						anIntArray194[anInt606++] = arg1;
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
