package jagex2.config;

import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// SpotAnimType: Spot animation definitions (graphics that are not bound to an entity)
@OriginalClass("client!kc")
public final class SpotAnimType {

	@OriginalMember(owner = "client!kc", name = "b", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!kc", name = "c", descriptor = "[Lclient!kc;")
	public static SpotAnimType[] instances;

	@OriginalMember(owner = "client!kc", name = "d", descriptor = "I")
	public int index;

	@OriginalMember(owner = "client!kc", name = "e", descriptor = "I")
	private int model;

	@OriginalMember(owner = "client!kc", name = "f", descriptor = "I")
	private int anim = -1;

	@OriginalMember(owner = "client!kc", name = "g", descriptor = "Lclient!jc;")
	public SeqType seq;

	@OriginalMember(owner = "client!kc", name = "h", descriptor = "Z")
	public boolean disposeAlpha = false;

	@OriginalMember(owner = "client!kc", name = "i", descriptor = "[I")
	private final int[] recol_s = new int[6];

	@OriginalMember(owner = "client!kc", name = "j", descriptor = "[I")
	private final int[] recol_d = new int[6];

	@OriginalMember(owner = "client!kc", name = "k", descriptor = "I")
	public int resizeh = 128;

	@OriginalMember(owner = "client!kc", name = "l", descriptor = "I")
	public int resizev = 128;

	@OriginalMember(owner = "client!kc", name = "m", descriptor = "I")
	public int orientation;

	@OriginalMember(owner = "client!kc", name = "n", descriptor = "I")
	public int ambient;

	@OriginalMember(owner = "client!kc", name = "o", descriptor = "I")
	public int contrast;

	@OriginalMember(owner = "client!kc", name = "p", descriptor = "Lclient!s;")
	public static LruCache modelCache = new LruCache(30);

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void unpack(@OriginalArg(0) Jagfile arg0) {
		@Pc(13) Packet local13 = new Packet(arg0.read("spotanim.dat", null));
		count = local13.g2();
		if (instances == null) {
			instances = new SpotAnimType[count];
		}
		for (@Pc(23) int local23 = 0; local23 < count; local23++) {
			if (instances[local23] == null) {
				instances[local23] = new SpotAnimType();
			}
			instances[local23].index = local23;
			instances[local23].decode(local13);
		}
	}

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet buf) {
		@Pc(5) int opcode;
		while (true) {
			opcode = buf.g1();
			if (opcode == 0) {
				break;
			}

			if (opcode == 1) {
				this.model = buf.g2();
			} else if (opcode == 2) {
				this.anim = buf.g2();
				if (SeqType.instances != null) {
					this.seq = SeqType.instances[this.anim];
				}
			} else if (opcode == 3) {
				this.disposeAlpha = true;
			} else if (opcode == 4) {
				this.resizeh = buf.g2();
			} else if (opcode == 5) {
				this.resizev = buf.g2();
			} else if (opcode == 6) {
				this.orientation = buf.g2();
			} else if (opcode == 7) {
				this.ambient = buf.g1();
			} else if (opcode == 8) {
				this.contrast = buf.g1();
			} else if (opcode >= 40 && opcode < 50) {
				this.recol_s[opcode - 40] = buf.g2();
			} else if (opcode >= 50 && opcode < 60) {
				this.recol_d[opcode - 50] = buf.g2();
			} else {
				System.out.println("Error unrecognised spotanim config code: " + opcode);
			}
		}
	}

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "()Lclient!eb;")
	public Model getModel() {
		@Pc(6) Model local6 = (Model) modelCache.get((long) this.index);
		if (local6 != null) {
			return local6;
		}
		local6 = new Model(this.model);
		for (@Pc(19) int local19 = 0; local19 < 6; local19++) {
			if (this.recol_s[0] != 0) {
				local6.recolor(this.recol_s[local19], this.recol_d[local19]);
			}
		}
		modelCache.put((long) this.index, local6);
		return local6;
	}
}
