package jagex2.config;

import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bc")
public final class NpcType {

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
	public String[] ops;

	@OriginalMember(owner = "client!bc", name = "v", descriptor = "I")
	private int code90 = -1;

	@OriginalMember(owner = "client!bc", name = "w", descriptor = "I")
	private int code91 = -1;

	@OriginalMember(owner = "client!bc", name = "x", descriptor = "I")
	private int code92 = -1;

	@OriginalMember(owner = "client!bc", name = "y", descriptor = "Z")
	public boolean visonmap = true;

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
	public static NpcType get(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 20; local1++) {
			if (cache[local1].index == (long) arg0) {
				return cache[local1];
			}
		}

		cachePos = (cachePos + 1) % 20;
		@Pc(33) NpcType local33 = cache[cachePos] = new NpcType();
		dat.pos = offsets[arg0];
		local33.index = arg0;
		local33.decode(dat);
		return local33;
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(10) int code = dat.g1();
			if (code == 0) {
				return;
			}

			@Pc(19) int local19;
			@Pc(25) int local25;
			if (code == 1) {
				local19 = dat.g1();
				this.models = new int[local19];

				for (local25 = 0; local25 < local19; local25++) {
					this.models[local25] = dat.g2();
				}
			} else if (code == 2) {
				this.name = dat.gstr();
			} else if (code == 3) {
				this.desc = dat.gstr();
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
				if (this.ops == null) {
					this.ops = new String[5];
				}

				this.ops[code - 30] = dat.gstr();
				if (this.ops[code - 30].equalsIgnoreCase("hidden")) {
					this.ops[code - 30] = null;
				}
			} else if (code == 40) {
				local19 = dat.g1();
				this.recol_s = new int[local19];
				this.recol_d = new int[local19];

				for (local25 = 0; local25 < local19; local25++) {
					this.recol_s[local25] = dat.g2();
					this.recol_d[local25] = dat.g2();
				}
			} else if (code == 60) {
				local19 = dat.g1();
				this.heads = new int[local19];

				for (local25 = 0; local25 < local19; local25++) {
					this.heads[local25] = dat.g2();
				}
			} else if (code == 90) {
				this.code90 = dat.g2();
			} else if (code == 91) {
				this.code91 = dat.g2();
			} else if (code == 92) {
				this.code92 = dat.g2();
			} else if (code == 93) {
				this.visonmap = false;
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
	public Model getSequencedModel(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2) {
		@Pc(3) Model local3 = null;
		@Pc(9) Model local9 = (Model) modelCache.get(this.index);

		if (local9 == null) {
			@Pc(16) Model[] local16 = new Model[this.models.length];
			for (@Pc(18) int local18 = 0; local18 < this.models.length; local18++) {
				local16[local18] = new Model(this.models[local18]);
			}

			if (local16.length == 1) {
				local9 = local16[0];
			} else {
				local9 = new Model(local16, local16.length);
			}

			if (this.recol_s != null) {
				for (@Pc(60) int local60 = 0; local60 < this.recol_s.length; local60++) {
					local9.recolor(this.recol_s[local60], this.recol_d[local60]);
				}
			}

			local9.createLabelReferences();
			local9.calculateNormals(64, 850, -30, -50, -30, true);
			modelCache.put(this.index, local9);
		}

		local3 = new Model(local9, !this.disposeAlpha);

		if (arg0 != -1 && arg1 != -1) {
			local3.applyTransforms(arg1, arg0, arg2);
		} else if (arg0 != -1) {
			local3.applyTransform(arg0);
		}

		if (this.resizeh != 128 || this.resizev != 128) {
			local3.scale(this.resizeh, this.resizev, this.resizeh);
		}

		local3.calculateBoundsCylinder();
		local3.labelFaces = null;
		local3.labelVertices = null;

		if (this.size == 1) {
			local3.pickable = true;
		}

		return local3;
	}

	@OriginalMember(owner = "client!bc", name = "b", descriptor = "(Z)Lclient!eb;")
	public Model getHeadModel() {
		if (this.heads == null) {
			return null;
		}

		@Pc(17) Model[] local17 = new Model[this.heads.length];
		for (@Pc(19) int local19 = 0; local19 < this.heads.length; local19++) {
			local17[local19] = new Model(this.heads[local19]);
		}

		@Pc(46) Model local46;
		if (local17.length == 1) {
			local46 = local17[0];
		} else {
			local46 = new Model(local17, local17.length);
		}

		if (this.recol_s != null) {
			for (@Pc(61) int local61 = 0; local61 < this.recol_s.length; local61++) {
				local46.recolor(this.recol_s[local61], this.recol_d[local61]);
			}
		}

		return local46;
	}
}
