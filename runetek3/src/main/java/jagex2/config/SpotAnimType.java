package jagex2.config;

import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name derived from other types + spotanim.dat (it's been renamed in NXT)
@OriginalClass("client!kc")
public class SpotAnimType {

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
	public static void unpack(@OriginalArg(0) Jagfile config) {
		@Pc(13) Packet dat = new Packet(config.read("spotanim.dat", null));
		count = dat.g2();

		if (instances == null) {
			instances = new SpotAnimType[count];
		}

		for (@Pc(23) int id = 0; id < count; id++) {
			if (instances[id] == null) {
				instances[id] = new SpotAnimType();
			}

			instances[id].index = id;
			instances[id].decode(dat);
		}
	}

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(5) int code = dat.g1();
			if (code == 0) {
				break;
			}

			if (code == 1) {
				this.model = dat.g2();
			} else if (code == 2) {
				this.anim = dat.g2();

				if (SeqType.instances != null) {
					this.seq = SeqType.instances[this.anim];
				}
			} else if (code == 3) {
				this.disposeAlpha = true;
			} else if (code == 4) {
				this.resizeh = dat.g2();
			} else if (code == 5) {
				this.resizev = dat.g2();
			} else if (code == 6) {
				this.orientation = dat.g2();
			} else if (code == 7) {
				this.ambient = dat.g1();
			} else if (code == 8) {
				this.contrast = dat.g1();
			} else if (code >= 40 && code < 50) {
				this.recol_s[code - 40] = dat.g2();
			} else if (code >= 50 && code < 60) {
				this.recol_d[code - 50] = dat.g2();
			} else {
				System.out.println("Error unrecognised spotanim config code: " + code);
			}
		}
	}

	@OriginalMember(owner = "client!kc", name = "a", descriptor = "()Lclient!eb;")
	public Model getModel() {
		@Pc(6) Model model = (Model) modelCache.get(this.index);
		if (model != null) {
			return model;
		}

		model = new Model(this.model);
		for (@Pc(19) int i = 0; i < 6; i++) {
			if (this.recol_s[0] != 0) {
				model.recolor(this.recol_s[i], this.recol_d[i]);
			}
		}

		modelCache.put(this.index, model);
		return model;
	}
}
