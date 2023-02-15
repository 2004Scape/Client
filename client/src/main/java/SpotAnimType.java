import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!kc")
public final class SpotAnimType {

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "I")
	private static final int flowObfuscator1 = 473;

	@OriginalMember(owner = "client!kc", name = "b", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!kc", name = "c", descriptor = "[Lclient!kc;")
	public static SpotAnimType[] instances;

	@OriginalMember(owner = "client!kc", name = "d", descriptor = "I")
	public int index;

	@OriginalMember(owner = "client!kc", name = "e", descriptor = "I")
	private int modelId;

	@OriginalMember(owner = "client!kc", name = "f", descriptor = "I")
	private int seqId = -1;

	@OriginalMember(owner = "client!kc", name = "g", descriptor = "Lclient!jc;")
	public SeqType seq;

	@OriginalMember(owner = "client!kc", name = "h", descriptor = "Z")
	public boolean disposeAlpha = false;

	@OriginalMember(owner = "client!kc", name = "i", descriptor = "[I")
	private final int[] colorSrc = new int[6];

	@OriginalMember(owner = "client!kc", name = "j", descriptor = "[I")
	private final int[] colorDst = new int[6];

	@OriginalMember(owner = "client!kc", name = "k", descriptor = "I")
	public int scaleXY = 128;

	@OriginalMember(owner = "client!kc", name = "l", descriptor = "I")
	public int scaleZ = 128;

	@OriginalMember(owner = "client!kc", name = "m", descriptor = "I")
	public int rotation;

	@OriginalMember(owner = "client!kc", name = "n", descriptor = "I")
	public int lightAmbient;

	@OriginalMember(owner = "client!kc", name = "o", descriptor = "I")
	public int lightAttenuation;

	@OriginalMember(owner = "client!kc", name = "p", descriptor = "Lclient!s;")
	public static Cache modelCache = new Cache((byte) 0, 30);

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void method407(@OriginalArg(0) FileArchive arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = 91 / arg1;
			@Pc(13) Buffer local13 = new Buffer(363, arg0.method536("spotanim.dat", null, (byte) 2));
			count = local13.method393();
			if (instances == null) {
				instances = new SpotAnimType[count];
			}
			for (@Pc(23) int local23 = 0; local23 < count; local23++) {
				if (instances[local23] == null) {
					instances[local23] = new SpotAnimType();
				}
				instances[local23].index = local23;
				instances[local23].method408(false, local13);
			}
		} catch (@Pc(52) RuntimeException local52) {
			signlink.reporterror("26561, " + arg0 + ", " + arg1 + ", " + local52.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method408(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
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
						return;
					}
					if (local5 == 1) {
						this.modelId = arg1.method393();
					} else if (local5 == 2) {
						this.seqId = arg1.method393();
						if (SeqType.instances != null) {
							this.seq = SeqType.instances[this.seqId];
						}
					} else if (local5 == 3) {
						this.disposeAlpha = true;
					} else if (local5 == 4) {
						this.scaleXY = arg1.method393();
					} else if (local5 == 5) {
						this.scaleZ = arg1.method393();
					} else if (local5 == 6) {
						this.rotation = arg1.method393();
					} else if (local5 == 7) {
						this.lightAmbient = arg1.method391();
					} else if (local5 == 8) {
						this.lightAttenuation = arg1.method391();
					} else if (local5 >= 40 && local5 < 50) {
						this.colorSrc[local5 - 40] = arg1.method393();
					} else if (local5 >= 50 && local5 < 60) {
						this.colorDst[local5 - 50] = arg1.method393();
					} else {
						System.out.println("Error unrecognised spotanim config code: " + local5);
					}
				}
			}
		} catch (@Pc(138) RuntimeException local138) {
			signlink.reporterror("42060, " + arg0 + ", " + arg1 + ", " + local138.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "()Lclient!eb;")
	public Model getModel() {
		@Pc(6) Model local6 = (Model) modelCache.get((long) this.index);
		if (local6 != null) {
			return local6;
		}
		local6 = new Model(false, this.modelId);
		for (@Pc(19) int local19 = 0; local19 < 6; local19++) {
			if (this.colorSrc[0] != 0) {
				local6.recolor(this.colorSrc[local19], this.colorDst[local19]);
			}
		}
		modelCache.put(6, (long) this.index, local6);
		return local6;
	}
}
