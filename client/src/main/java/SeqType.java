import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!jc")
public final class SeqType {

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "Z")
	private static boolean flowObfuscator1 = true;

	@OriginalMember(owner = "client!jc", name = "b", descriptor = "I")
	private static final int flowObfuscator2 = 473;

	@OriginalMember(owner = "client!jc", name = "c", descriptor = "I")
	private static int anInt542;

	@OriginalMember(owner = "client!jc", name = "d", descriptor = "[Lclient!jc;")
	public static SeqType[] instances;

	@OriginalMember(owner = "client!jc", name = "e", descriptor = "I")
	public int frameCount;

	@OriginalMember(owner = "client!jc", name = "f", descriptor = "[I")
	public int[] transformIds;

	@OriginalMember(owner = "client!jc", name = "g", descriptor = "[I")
	public int[] anIntArray187;

	@OriginalMember(owner = "client!jc", name = "h", descriptor = "[I")
	public int[] frameDelay;

	@OriginalMember(owner = "client!jc", name = "i", descriptor = "I")
	public int loopFrameCount = -1;

	@OriginalMember(owner = "client!jc", name = "j", descriptor = "[I")
	public int[] mask;

	@OriginalMember(owner = "client!jc", name = "k", descriptor = "Z")
	public boolean aBoolean126 = false;

	@OriginalMember(owner = "client!jc", name = "l", descriptor = "I")
	public int idleStyle = 5;

	@OriginalMember(owner = "client!jc", name = "m", descriptor = "I")
	public int rightHandOverride = -1;

	@OriginalMember(owner = "client!jc", name = "n", descriptor = "I")
	public int leftHandOverride = -1;

	@OriginalMember(owner = "client!jc", name = "o", descriptor = "I")
	public int anInt548 = 99;

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void method374(@OriginalArg(0) FileArchive arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(9) Buffer local9 = new Buffer(363, arg0.method536("seq.dat", null, (byte) 2));
			if (arg1 <= 0) {
				flowObfuscator1 = !flowObfuscator1;
			}
			anInt542 = local9.method393();
			if (instances == null) {
				instances = new SeqType[anInt542];
			}
			for (@Pc(27) int local27 = 0; local27 < anInt542; local27++) {
				if (instances[local27] == null) {
					instances[local27] = new SeqType();
				}
				instances[local27].method375(false, local9);
			}
		} catch (@Pc(51) RuntimeException local51) {
			signlink.reporterror("35892, " + arg0 + ", " + arg1 + ", " + local51.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method375(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			@Pc(5) int local5;
			if (arg0) {
				for (local5 = 1; local5 > 0; local5++) {
				}
			}
			while (true) {
				while (true) {
					local5 = arg1.method391();
					if (local5 == 0) {
						if (this.frameCount == 0) {
							this.frameCount = 1;
							this.transformIds = new int[1];
							this.transformIds[0] = -1;
							this.anIntArray187 = new int[1];
							this.anIntArray187[0] = -1;
							this.frameDelay = new int[1];
							this.frameDelay[0] = -1;
							return;
						}
						return;
					}
					@Pc(40) int local40;
					if (local5 == 1) {
						this.frameCount = arg1.method391();
						this.transformIds = new int[this.frameCount];
						this.anIntArray187 = new int[this.frameCount];
						this.frameDelay = new int[this.frameCount];
						for (local40 = 0; local40 < this.frameCount; local40++) {
							this.transformIds[local40] = arg1.method393();
							this.anIntArray187[local40] = arg1.method393();
							if (this.anIntArray187[local40] == 65535) {
								this.anIntArray187[local40] = -1;
							}
							this.frameDelay[local40] = arg1.method393();
							if (this.frameDelay[local40] == 0) {
								this.frameDelay[local40] = SeqFrame.aClass12Array1[this.transformIds[local40]].anInt411;
							}
							if (this.frameDelay[local40] == 0) {
								this.frameDelay[local40] = 1;
							}
						}
					} else if (local5 == 2) {
						this.loopFrameCount = arg1.method393();
					} else if (local5 == 3) {
						local40 = arg1.method391();
						this.mask = new int[local40 + 1];
						for (@Pc(127) int local127 = 0; local127 < local40; local127++) {
							this.mask[local127] = arg1.method391();
						}
						this.mask[local40] = 9999999;
					} else if (local5 == 4) {
						this.aBoolean126 = true;
					} else if (local5 == 5) {
						this.idleStyle = arg1.method391();
					} else if (local5 == 6) {
						this.rightHandOverride = arg1.method393();
					} else if (local5 == 7) {
						this.leftHandOverride = arg1.method393();
					} else if (local5 == 8) {
						this.anInt548 = arg1.method391();
					} else {
						System.out.println("Error unrecognised seq config code: " + local5);
					}
				}
			}
		} catch (@Pc(236) RuntimeException local236) {
			signlink.reporterror("38080, " + arg0 + ", " + arg1 + ", " + local236.toString());
			throw new RuntimeException();
		}
	}
}
