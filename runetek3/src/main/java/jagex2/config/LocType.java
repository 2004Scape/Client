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
@OriginalClass("client!ac")
public class LocType {

	// shapes
	public static final int WALL_STRAIGHT = 0;
	public static final int WALL_DIAGONALCORNER = 1;
	public static final int WALL_L = 2;
	public static final int WALL_SQUARECORNER = 3;
	public static final int WALL_DIAGONAL = 9;
	public static final int WALLDECOR_STRAIGHT_NOOFFSET = 4;
	public static final int WALLDECOR_STRAIGHT_OFFSET = 5;
	public static final int WALLDECOR_DIAGONAL_OFFSET = 6;
	public static final int WALLDECOR_DIAGONAL_NOOFFSET = 7;
	public static final int WALLDECOR_DIAGONAL_BOTH = 8;
	public static final int CENTREPIECE_STRAIGHT = 10;
	public static final int CENTREPIECE_DIAGONAL = 11;
	public static final int GROUNDDECOR = 22;
	public static final int ROOF_STRAIGHT = 12;
	public static final int ROOF_DIAGONAL_WITH_ROOFEDGE = 13;
	public static final int ROOF_DIAGONAL = 14;
	public static final int ROOF_L_CONCAVE = 15;
	public static final int ROOF_L_CONVEX = 16;
	public static final int ROOF_FLAT = 17;
	public static final int ROOFEDGE_STRAIGHT = 18;
	public static final int ROOFEDGE_DIAGONALCORNER = 19;
	public static final int ROOFEDGE_L = 20;
	public static final int ROOFEDGE_SQUARECORNER = 21;

	@OriginalMember(owner = "client!ac", name = "c", descriptor = "Z")
	public static boolean reset;

	@OriginalMember(owner = "client!ac", name = "d", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!ac", name = "e", descriptor = "[I")
	private static int[] offsets;

	@OriginalMember(owner = "client!ac", name = "f", descriptor = "Lclient!kb;")
	private static Packet dat;

	@OriginalMember(owner = "client!ac", name = "g", descriptor = "[Lclient!ac;")
	private static LocType[] cache;

	@OriginalMember(owner = "client!ac", name = "h", descriptor = "I")
	private static int cachePos;

	@OriginalMember(owner = "client!ac", name = "i", descriptor = "I")
	public int index = -1;

	@OriginalMember(owner = "client!ac", name = "j", descriptor = "[I")
	private int[] models;

	@OriginalMember(owner = "client!ac", name = "k", descriptor = "[I")
	private int[] shapes;

	@OriginalMember(owner = "client!ac", name = "l", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "client!ac", name = "m", descriptor = "[B")
	public String desc;

	@OriginalMember(owner = "client!ac", name = "n", descriptor = "[I")
	private int[] recol_s;

	@OriginalMember(owner = "client!ac", name = "o", descriptor = "[I")
	private int[] recol_d;

	@OriginalMember(owner = "client!ac", name = "p", descriptor = "I")
	public int width;

	@OriginalMember(owner = "client!ac", name = "q", descriptor = "I")
	public int length;

	@OriginalMember(owner = "client!ac", name = "r", descriptor = "Z")
	public boolean blockwalk;

	@OriginalMember(owner = "client!ac", name = "s", descriptor = "Z")
	public boolean blockrange;

	@OriginalMember(owner = "client!ac", name = "t", descriptor = "Z")
	public boolean active;

	@OriginalMember(owner = "client!ac", name = "u", descriptor = "Z")
	private boolean hillskew;

	@OriginalMember(owner = "client!ac", name = "v", descriptor = "Z")
	private boolean sharelight;

	@OriginalMember(owner = "client!ac", name = "w", descriptor = "Z")
	public boolean occlude;

	@OriginalMember(owner = "client!ac", name = "x", descriptor = "I")
	public int anim;

	@OriginalMember(owner = "client!ac", name = "y", descriptor = "I")
	public int wallwidth;

	@OriginalMember(owner = "client!ac", name = "z", descriptor = "B")
	private byte ambient;

	@OriginalMember(owner = "client!ac", name = "A", descriptor = "B")
	private byte contrast;

	@OriginalMember(owner = "client!ac", name = "B", descriptor = "[Ljava/lang/String;")
	public String[] op;

	@OriginalMember(owner = "client!ac", name = "C", descriptor = "Z")
	private boolean disposeAlpha;

	@OriginalMember(owner = "client!ac", name = "D", descriptor = "I")
	public int mapfunction;

	@OriginalMember(owner = "client!ac", name = "E", descriptor = "I")
	public int mapscene;

	@OriginalMember(owner = "client!ac", name = "F", descriptor = "Z")
	private boolean mirror;

	@OriginalMember(owner = "client!ac", name = "G", descriptor = "Z")
	public boolean shadow;

	@OriginalMember(owner = "client!ac", name = "H", descriptor = "I")
	private int resizex;

	@OriginalMember(owner = "client!ac", name = "I", descriptor = "I")
	private int resizey;

	@OriginalMember(owner = "client!ac", name = "J", descriptor = "I")
	private int resizez;

	@OriginalMember(owner = "client!ac", name = "K", descriptor = "I")
	private int offsetx;

	@OriginalMember(owner = "client!ac", name = "L", descriptor = "I")
	private int offsety;

	@OriginalMember(owner = "client!ac", name = "M", descriptor = "I")
	private int offsetz;

	@OriginalMember(owner = "client!ac", name = "N", descriptor = "I")
	public int forceapproach;

	@OriginalMember(owner = "client!ac", name = "O", descriptor = "Z")
	public boolean forcedecor;

	@OriginalMember(owner = "client!ac", name = "P", descriptor = "Lclient!s;")
	public static LruCache modelCacheStatic = new LruCache(500);

	@OriginalMember(owner = "client!ac", name = "Q", descriptor = "Lclient!s;")
	public static LruCache modelCacheDynamic = new LruCache(30);

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(Lclient!ub;)V")
	public static void unpack(@OriginalArg(0) Jagfile config) {
		dat = new Packet(config.read("loc.dat", null));
		@Pc(21) Packet idx = new Packet(config.read("loc.idx", null));

		count = idx.g2();
		offsets = new int[count];

		@Pc(29) int offset = 2;
		for (@Pc(31) int id = 0; id < count; id++) {
			offsets[id] = offset;
			offset += idx.g2();
		}

		cache = new LocType[10];
		for (@Pc(51) int id = 0; id < 10; id++) {
			cache[id] = new LocType();
		}
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(Z)V")
	public static void unload() {
		modelCacheStatic = null;
		modelCacheDynamic = null;
		offsets = null;
		cache = null;
		dat = null;
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(I)Lclient!ac;")
	public static LocType get(@OriginalArg(0) int id) {
		for (@Pc(1) int i = 0; i < 10; i++) {
			if (cache[i].index == id) {
				return cache[i];
			}
		}

		cachePos = (cachePos + 1) % 10;
		@Pc(27) LocType loc = cache[cachePos];
		dat.pos = offsets[id];
		loc.index = id;
		loc.reset();
		loc.decode(dat);
		return loc;
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "()V")
	public void reset() {
		this.models = null;
		this.shapes = null;
		this.name = null;
		this.desc = null;
		this.recol_s = null;
		this.recol_d = null;
		this.width = 1;
		this.length = 1;
		this.blockwalk = true;
		this.blockrange = true;
		this.active = false;
		this.hillskew = false;
		this.sharelight = false;
		this.occlude = false;
		this.anim = -1;
		this.wallwidth = 16;
		this.ambient = 0;
		this.contrast = 0;
		this.op = null;
		this.disposeAlpha = false;
		this.mapfunction = -1;
		this.mapscene = -1;
		this.mirror = false;
		this.shadow = true;
		this.resizex = 128;
		this.resizey = 128;
		this.resizez = 128;
		this.forceapproach = 0;
		this.offsetx = 0;
		this.offsety = 0;
		this.offsetz = 0;
		this.forcedecor = false;
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		@Pc(5) int active = -1;

		while (true) {
			@Pc(15) int code = dat.g1();
			if (code == 0) {
				break;
			}

			if (code == 1) {
				int count = dat.g1();
				this.shapes = new int[count];
				this.models = new int[count];

				for (int i = 0; i < count; i++) {
					this.models[i] = dat.g2();
					this.shapes[i] = dat.g1();
				}
			} else if (code == 2) {
				this.name = dat.gjstr();
			} else if (code == 3) {
				this.desc = dat.gjstr();
			} else if (code == 14) {
				this.width = dat.g1();
			} else if (code == 15) {
				this.length = dat.g1();
			} else if (code == 17) {
				this.blockwalk = false;
			} else if (code == 18) {
				this.blockrange = false;
			} else if (code == 19) {
				active = dat.g1();

				if (active == 1) {
					this.active = true;
				}
			} else if (code == 21) {
				this.hillskew = true;
			} else if (code == 22) {
				this.sharelight = true;
			} else if (code == 23) {
				this.occlude = true;
			} else if (code == 24) {
				this.anim = dat.g2();
				if (this.anim == 65535) {
					this.anim = -1;
				}
			} else if (code == 25) {
				this.disposeAlpha = true;
			} else if (code == 28) {
				this.wallwidth = dat.g1();
			} else if (code == 29) {
				this.ambient = dat.g1b();
			} else if (code == 39) {
				this.contrast = dat.g1b();
			} else if (code >= 30 && code < 39) {
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
				this.mapfunction = dat.g2();
			} else if (code == 62) {
				this.mirror = true;
			} else if (code == 64) {
				this.shadow = false;
			} else if (code == 65) {
				this.resizex = dat.g2();
			} else if (code == 66) {
				this.resizey = dat.g2();
			} else if (code == 67) {
				this.resizez = dat.g2();
			} else if (code == 68) {
				this.mapscene = dat.g2();
			} else if (code == 69) {
				this.forceapproach = dat.g1();
			} else if (code == 70) {
				this.offsetx = dat.g2b();
			} else if (code == 71) {
				this.offsety = dat.g2b();
			} else if (code == 72) {
				this.offsetz = dat.g2b();
			} else if (code == 73) {
				this.forcedecor = true;
			}
		}

		if (this.shapes == null) {
			this.shapes = new int[0];
		}

		if (active == -1) {
			this.active = this.shapes.length > 0 && this.shapes[0] == 10;

			if (this.op != null) {
				this.active = true;
			}
		}
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(IIIIIII)Lclient!eb;")
	public Model getModel(@OriginalArg(0) int shape, @OriginalArg(1) int rotation, @OriginalArg(2) int heightmapSW, @OriginalArg(3) int heightmapSE, @OriginalArg(4) int heightmapNE, @OriginalArg(5) int heightmapNW, @OriginalArg(6) int transformId) {
		@Pc(3) int shapeIndex = -1;
		for (@Pc(5) int i = 0; i < this.shapes.length; i++) {
			if (this.shapes[i] == shape) {
				shapeIndex = i;
				break;
			}
		}

		if (shapeIndex == -1) {
			return null;
		}

		@Pc(47) long bitset = ((long) this.index << 6) + ((long) shapeIndex << 3) + rotation + ((long) (transformId + 1) << 32);
		if (reset) {
			bitset = 0L;
		}

		@Pc(56) Model cached = (Model) modelCacheDynamic.get(bitset);
		if (cached != null) {
			if (reset) {
				return cached;
			}

			if (this.hillskew || this.sharelight) {
				cached = new Model(cached, this.hillskew, this.sharelight);
			}

			if (this.hillskew) {
				int groundY = (heightmapSW + heightmapSE + heightmapNE + heightmapNW) / 4;

				for (@Pc(93) int i = 0; i < cached.vertexCount; i++) {
					@Pc(100) int x = cached.vertexX[i];
					@Pc(105) int z = cached.vertexZ[i];

					@Pc(117) int heightS = heightmapSW + (heightmapSE - heightmapSW) * (x + 64) / 128;
					@Pc(129) int heightN = heightmapNW + (heightmapNE - heightmapNW) * (x + 64) / 128;
					int y = heightS + (heightN - heightS) * (z + 64) / 128;

					cached.vertexY[i] += y - groundY;
				}

				cached.calculateBoundsY();
			}

			return cached;
		}

		if (shapeIndex >= this.models.length) {
			return null;
		}

		int modelId = this.models[shapeIndex];
		if (modelId == -1) {
			return null;
		}

		@Pc(188) boolean flipped = this.mirror ^ rotation > 3;
		if (flipped) {
			modelId += 65536;
		}

		@Pc(200) Model model = (Model) modelCacheStatic.get(modelId);
		if (model == null) {
			model = new Model(modelId & 0xFFFF);
			if (flipped) {
				model.rotateY180();
			}
			modelCacheStatic.put(modelId, model);
		}

		@Pc(235) boolean scaled = this.resizex != 128 || this.resizey != 128 || this.resizez != 128;
		@Pc(250) boolean translated = this.offsetx != 0 || this.offsety != 0 || this.offsetz != 0;

		@Pc(284) Model modified = new Model(model, this.recol_s == null, !this.disposeAlpha, rotation == 0 && transformId == -1 && !scaled && !translated);
		if (transformId != -1) {
			modified.createLabelReferences();
			modified.applyTransform(transformId);
			modified.labelFaces = null;
			modified.labelVertices = null;
		}

		while (rotation-- > 0) {
			modified.rotateY90();
		}

		if (this.recol_s != null) {
			for (int i = 0; i < this.recol_s.length; i++) {
				modified.recolor(this.recol_s[i], this.recol_d[i]);
			}
		}

		if (scaled) {
			modified.scale(this.resizex, this.resizey, this.resizez);
		}

		if (translated) {
			modified.translate(this.offsety, this.offsetx, this.offsetz);
		}

		modified.calculateNormals(this.ambient + 64, this.contrast * 5 + 768, -50, -10, -50, !this.sharelight);

		if (this.blockwalk) {
			modified.objRaise = modified.maxY;
		}

		modelCacheDynamic.put(bitset, modified);

		if (this.hillskew || this.sharelight) {
			modified = new Model(modified, this.hillskew, this.sharelight);
		}

		if (this.hillskew) {
			int groundY = (heightmapSW + heightmapSE + heightmapNE + heightmapNW) / 4;

			for (@Pc(417) int i = 0; i < modified.vertexCount; i++) {
				@Pc(424) int x = modified.vertexX[i];
				@Pc(429) int z = modified.vertexZ[i];

				@Pc(441) int heightS = heightmapSW + (heightmapSE - heightmapSW) * (x + 64) / 128;
				@Pc(453) int heightN = heightmapNW + (heightmapNE - heightmapNW) * (x + 64) / 128;
				@Pc(465) int y = heightS + (heightN - heightS) * (z + 64) / 128;

				modified.vertexY[i] += y - groundY;
			}

			modified.calculateBoundsY();
		}

		return modified;
	}
}
