package jagex2.config;

import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from rs3
@OriginalClass("client!bc")
public class NpcType {

	@OriginalMember(owner = "client!bc", name = "b", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!bc", name = "c", descriptor = "[I")
	private static int[] offsets;

	@OriginalMember(owner = "client!bc", name = "d", descriptor = "Lclient!kb;")
	private static Packet dat;

	@OriginalMember(owner = "client!bc", name = "e", descriptor = "[Lclient!bc;")
	private static NpcType[] cache;

	@OriginalMember(owner = "client!bc", name = "f", descriptor = "I")
	private static int cachePos;

	@OriginalMember(owner = "client!bc", name = "g", descriptor = "J")
	public long index = -1L;

	@OriginalMember(owner = "client!bc", name = "h", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "client!bc", name = "i", descriptor = "[B")
	public String desc;

	@OriginalMember(owner = "client!bc", name = "j", descriptor = "B")
	public byte size = 1;

	@OriginalMember(owner = "client!bc", name = "k", descriptor = "[I")
	private int[] models;

	@OriginalMember(owner = "client!bc", name = "l", descriptor = "[I")
	private int[] heads;

	@OriginalMember(owner = "client!bc", name = "m", descriptor = "I")
	public int readyanim = -1;

	@OriginalMember(owner = "client!bc", name = "n", descriptor = "I")
	public int walkanim = -1;

	@OriginalMember(owner = "client!bc", name = "o", descriptor = "I")
	public int walkanim_b = -1;

	@OriginalMember(owner = "client!bc", name = "p", descriptor = "I")
	public int walkanim_r = -1;

	@OriginalMember(owner = "client!bc", name = "q", descriptor = "I")
	public int walkanim_l = -1;

	@OriginalMember(owner = "client!bc", name = "r", descriptor = "Z")
	private boolean disposeAlpha = false;

	@OriginalMember(owner = "client!bc", name = "s", descriptor = "[I")
	private int[] recol_s;

	@OriginalMember(owner = "client!bc", name = "t", descriptor = "[I")
	private int[] recol_d;

	@OriginalMember(owner = "client!bc", name = "u", descriptor = "[Ljava/lang/String;")
	public String[] op;

	@OriginalMember(owner = "client!bc", name = "v", descriptor = "I")
	private int resizex = -1;

	@OriginalMember(owner = "client!bc", name = "w", descriptor = "I")
	private int resizey = -1;

	@OriginalMember(owner = "client!bc", name = "x", descriptor = "I")
	private int resizez = -1;

	@OriginalMember(owner = "client!bc", name = "y", descriptor = "Z")
	public boolean minimap = true;

	@OriginalMember(owner = "client!bc", name = "z", descriptor = "I")
	public int vislevel = -1;

	@OriginalMember(owner = "client!bc", name = "A", descriptor = "I")
	private int resizeh = 128;

	@OriginalMember(owner = "client!bc", name = "B", descriptor = "I")
	private int resizev = 128;

	@OriginalMember(owner = "client!bc", name = "C", descriptor = "Lclient!s;")
	public static LruCache modelCache = new LruCache(30);

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void unpack(@OriginalArg(0) Jagfile config) {
		dat = new Packet(config.read("npc.dat", null));
		@Pc(21) Packet idx = new Packet(config.read("npc.idx", null));

		count = idx.g2();
		offsets = new int[count];

		@Pc(29) int offset = 2;
		for (@Pc(31) int id = 0; id < count; id++) {
			offsets[id] = offset;
			offset += idx.g2();
		}

		cache = new NpcType[20];
		for (@Pc(51) int id = 0; id < 20; id++) {
			cache[id] = new NpcType();
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Z)V")
	public static void unload() {
		modelCache = null;
		offsets = null;
		cache = null;
		dat = null;
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(I)Lclient!bc;")
	public static NpcType get(@OriginalArg(0) int id) {
		for (@Pc(1) int i = 0; i < 20; i++) {
			if (cache[i].index == (long) id) {
				return cache[i];
			}
		}

		cachePos = (cachePos + 1) % 20;
		@Pc(33) NpcType npc = cache[cachePos] = new NpcType();
		dat.pos = offsets[id];
		npc.index = id;
		npc.decode(dat);
		return npc;
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(10) int code = dat.g1();
			if (code == 0) {
				return;
			}

			if (code == 1) {
				int count = dat.g1();
				this.models = new int[count];

				for (int i = 0; i < count; i++) {
					this.models[i] = dat.g2();
				}
			} else if (code == 2) {
				this.name = dat.gjstr();
			} else if (code == 3) {
				this.desc = dat.gjstr();
			} else if (code == 12) {
				this.size = dat.g1b();
			} else if (code == 13) {
				this.readyanim = dat.g2();
			} else if (code == 14) {
				this.walkanim = dat.g2();
			} else if (code == 16) {
				this.disposeAlpha = true;
			} else if (code == 17) {
				this.walkanim = dat.g2();
				this.walkanim_b = dat.g2();
				this.walkanim_r = dat.g2();
				this.walkanim_l = dat.g2();
			} else if (code >= 30 && code < 40) {
				if (this.op == null) {
					this.op = new String[5];
				}

				this.op[code - 30] = dat.gjstr();
				if (this.op[code - 30].equalsIgnoreCase("hidden")) {
					this.op[code - 30] = null;
				}
			} else if (code == 40) {
				int count = dat.g1();
				this.recol_s = new int[count];
				this.recol_d = new int[count];

				for (int i = 0; i < count; i++) {
					this.recol_s[i] = dat.g2();
					this.recol_d[i] = dat.g2();
				}
			} else if (code == 60) {
				int count = dat.g1();
				this.heads = new int[count];

				for (int i = 0; i < count; i++) {
					this.heads[i] = dat.g2();
				}
			} else if (code == 90) {
				// unused
				this.resizex = dat.g2();
			} else if (code == 91) {
				// unused
				this.resizey = dat.g2();
			} else if (code == 92) {
				// unused
				this.resizez = dat.g2();
			} else if (code == 93) {
				this.minimap = false;
			} else if (code == 95) {
				this.vislevel = dat.g2();
			} else if (code == 97) {
				this.resizeh = dat.g2();
			} else if (code == 98) {
				this.resizev = dat.g2();
			}
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(II[I)Lclient!eb;")
	public Model getSequencedModel(@OriginalArg(0) int primaryTransformId, @OriginalArg(1) int secondaryTransformId, @OriginalArg(2) int[] seqMask) {
		@Pc(3) Model tmp = null;
		@Pc(9) Model model = (Model) modelCache.get(this.index);

		if (model == null) {
			@Pc(16) Model[] models = new Model[this.models.length];
			for (@Pc(18) int i = 0; i < this.models.length; i++) {
				models[i] = new Model(this.models[i]);
			}

			if (models.length == 1) {
				model = models[0];
			} else {
				model = new Model(models, models.length);
			}

			if (this.recol_s != null) {
				for (@Pc(60) int i = 0; i < this.recol_s.length; i++) {
					model.recolor(this.recol_s[i], this.recol_d[i]);
				}
			}

			model.createLabelReferences();
			model.calculateNormals(64, 850, -30, -50, -30, true);
			modelCache.put(this.index, model);
		}

		tmp = new Model(model, !this.disposeAlpha);

		if (primaryTransformId != -1 && secondaryTransformId != -1) {
			tmp.applyTransforms(primaryTransformId, secondaryTransformId, seqMask);
		} else if (primaryTransformId != -1) {
			tmp.applyTransform(primaryTransformId);
		}

		if (this.resizeh != 128 || this.resizev != 128) {
			tmp.scale(this.resizeh, this.resizev, this.resizeh);
		}

		tmp.calculateBoundsCylinder();
		tmp.labelFaces = null;
		tmp.labelVertices = null;

		if (this.size == 1) {
			tmp.pickable = true;
		}

		return tmp;
	}

	@OriginalMember(owner = "client!bc", name = "b", descriptor = "(Z)Lclient!eb;")
	public Model getHeadModel() {
		if (this.heads == null) {
			return null;
		}

		@Pc(17) Model[] models = new Model[this.heads.length];
		for (@Pc(19) int i = 0; i < this.heads.length; i++) {
			models[i] = new Model(this.heads[i]);
		}

		@Pc(46) Model model;
		if (models.length == 1) {
			model = models[0];
		} else {
			model = new Model(models, models.length);
		}

		if (this.recol_s != null) {
			for (@Pc(61) int i = 0; i < this.recol_s.length; i++) {
				model.recolor(this.recol_s[i], this.recol_d[i]);
			}
		}

		return model;
	}
}
