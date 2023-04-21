package jagex2.config;

import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// NpcType: NPC definitions
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
	public byte[] desc;

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
	private int opcode90 = -1;

	@OriginalMember(owner = "client!bc", name = "w", descriptor = "I")
	private int opcode91 = -1;

	@OriginalMember(owner = "client!bc", name = "x", descriptor = "I")
	private int opcode92 = -1;

	@OriginalMember(owner = "client!bc", name = "y", descriptor = "Z")
	public boolean visonmap = true;

	@OriginalMember(owner = "client!bc", name = "z", descriptor = "I")
	public int vislevel = -1;

	@OriginalMember(owner = "client!bc", name = "A", descriptor = "I")
	private int resizex = 128;

	@OriginalMember(owner = "client!bc", name = "B", descriptor = "I")
	private int resizez = 128;

	@OriginalMember(owner = "client!bc", name = "C", descriptor = "Lclient!s;")
	public static LruCache modelCache = new LruCache(30);

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void unpack(@OriginalArg(0) Jagfile arg0) {
		dat = new Packet(arg0.read("npc.dat", null));
		@Pc(21) Packet local21 = new Packet(arg0.read("npc.idx", null));
		count = local21.g2();
		offsets = new int[count];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < count; local31++) {
			offsets[local31] = local29;
			local29 += local21.g2();
		}
		cache = new NpcType[20];
		for (@Pc(51) int local51 = 0; local51 < 20; local51++) {
			cache[local51] = new NpcType();
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
	public void decode(@OriginalArg(1) Packet buf) {
		while (true) {
			@Pc(10) int opcode = buf.g1();
			if (opcode == 0) {
				break;
			}

			@Pc(19) int local19;
			@Pc(25) int local25;
			if (opcode == 1) {
				local19 = buf.g1();
				this.models = new int[local19];
				for (local25 = 0; local25 < local19; local25++) {
					this.models[local25] = buf.g2();
				}
			} else if (opcode == 2) {
				this.name = buf.gstr();
			} else if (opcode == 3) {
				this.desc = buf.gstrbyte();
			} else if (opcode == 12) {
				this.size = buf.g1b();
			} else if (opcode == 13) {
				this.readyanim = buf.g2();
			} else if (opcode == 14) {
				this.walkanim = buf.g2();
			} else if (opcode == 16) {
				this.disposeAlpha = true;
			} else if (opcode == 17) {
				this.walkanim = buf.g2();
				this.walkanim_b = buf.g2();
				this.walkanim_r = buf.g2();
				this.walkanim_l = buf.g2();
			} else if (opcode >= 30 && opcode < 40) {
				if (this.ops == null) {
					this.ops = new String[5];
				}
				this.ops[opcode - 30] = buf.gstr();
				if (this.ops[opcode - 30].equalsIgnoreCase("hidden")) {
					this.ops[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				local19 = buf.g1();
				this.recol_s = new int[local19];
				this.recol_d = new int[local19];
				for (local25 = 0; local25 < local19; local25++) {
					this.recol_s[local25] = buf.g2();
					this.recol_d[local25] = buf.g2();
				}
			} else if (opcode == 60) {
				local19 = buf.g1();
				this.heads = new int[local19];
				for (local25 = 0; local25 < local19; local25++) {
					this.heads[local25] = buf.g2();
				}
			} else if (opcode == 90) {
				this.opcode90 = buf.g2();
			} else if (opcode == 91) {
				this.opcode91 = buf.g2();
			} else if (opcode == 92) {
				this.opcode92 = buf.g2();
			} else if (opcode == 93) {
				this.visonmap = false;
			} else if (opcode == 95) {
				this.vislevel = buf.g2();
			} else if (opcode == 97) {
				this.resizex = buf.g2();
			} else if (opcode == 98) {
				this.resizez = buf.g2();
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
		if (this.resizex != 128 || this.resizez != 128) {
			local3.scale(this.resizex, this.resizez, this.resizex);
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
		} else {
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
}
