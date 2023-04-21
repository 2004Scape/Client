package jagex2.config;

import jagex2.datastruct.LruCache;
import jagex2.graphics.Draw2D;
import jagex2.graphics.Draw3D;
import jagex2.graphics.Model;
import jagex2.graphics.Pix24;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// ObjType: Object definitions (items)
@OriginalClass("client!cc")
public final class ObjType {

	@OriginalMember(owner = "client!cc", name = "e", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!cc", name = "f", descriptor = "[I")
	private static int[] offsets;

	@OriginalMember(owner = "client!cc", name = "g", descriptor = "Lclient!kb;")
	private static Packet dat;

	@OriginalMember(owner = "client!cc", name = "h", descriptor = "[Lclient!cc;")
	private static ObjType[] cache;

	@OriginalMember(owner = "client!cc", name = "i", descriptor = "I")
	private static int cachePos;

	@OriginalMember(owner = "client!cc", name = "j", descriptor = "Z")
	public static boolean membersWorld = true;

	@OriginalMember(owner = "client!cc", name = "k", descriptor = "I")
	public int index = -1;

	@OriginalMember(owner = "client!cc", name = "l", descriptor = "I")
	private int model;

	@OriginalMember(owner = "client!cc", name = "m", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "client!cc", name = "n", descriptor = "[B")
	public byte[] desc;

	@OriginalMember(owner = "client!cc", name = "o", descriptor = "[I")
	private int[] recol_s;

	@OriginalMember(owner = "client!cc", name = "p", descriptor = "[I")
	private int[] recol_d;

	@OriginalMember(owner = "client!cc", name = "q", descriptor = "I")
	public int zoom2d;

	@OriginalMember(owner = "client!cc", name = "r", descriptor = "I")
	public int xan2d;

	@OriginalMember(owner = "client!cc", name = "s", descriptor = "I")
	public int yan2d;

	@OriginalMember(owner = "client!cc", name = "t", descriptor = "I")
	public int zan2d;

	@OriginalMember(owner = "client!cc", name = "u", descriptor = "I")
	public int xof2d;

	@OriginalMember(owner = "client!cc", name = "v", descriptor = "I")
	public int yof2d;

	@OriginalMember(owner = "client!cc", name = "w", descriptor = "Z")
	private boolean opcode9;

	@OriginalMember(owner = "client!cc", name = "x", descriptor = "I")
	private int opcode10;

	@OriginalMember(owner = "client!cc", name = "y", descriptor = "Z")
	public boolean stackable;

	@OriginalMember(owner = "client!cc", name = "z", descriptor = "I")
	public int cost;

	@OriginalMember(owner = "client!cc", name = "A", descriptor = "Z")
	public boolean members;

	@OriginalMember(owner = "client!cc", name = "B", descriptor = "[Ljava/lang/String;")
	public String[] ops;

	@OriginalMember(owner = "client!cc", name = "C", descriptor = "[Ljava/lang/String;")
	public String[] iops;

	@OriginalMember(owner = "client!cc", name = "D", descriptor = "I")
	private int manwear;

	@OriginalMember(owner = "client!cc", name = "E", descriptor = "I")
	private int manwear2;

	@OriginalMember(owner = "client!cc", name = "F", descriptor = "B")
	private byte manwearOffsetY;

	@OriginalMember(owner = "client!cc", name = "G", descriptor = "I")
	private int womanwear;

	@OriginalMember(owner = "client!cc", name = "H", descriptor = "I")
	private int womanwear2;

	@OriginalMember(owner = "client!cc", name = "I", descriptor = "B")
	private byte womanwearOffsetY;

	@OriginalMember(owner = "client!cc", name = "J", descriptor = "I")
	private int manwear3;

	@OriginalMember(owner = "client!cc", name = "K", descriptor = "I")
	private int womanwear3;

	@OriginalMember(owner = "client!cc", name = "L", descriptor = "I")
	private int manhead;

	@OriginalMember(owner = "client!cc", name = "M", descriptor = "I")
	private int manhead2;

	@OriginalMember(owner = "client!cc", name = "N", descriptor = "I")
	private int womanhead;

	@OriginalMember(owner = "client!cc", name = "O", descriptor = "I")
	private int womanhead2;

	@OriginalMember(owner = "client!cc", name = "P", descriptor = "[I")
	public int[] countobj;

	@OriginalMember(owner = "client!cc", name = "Q", descriptor = "[I")
	public int[] countco;

	@OriginalMember(owner = "client!cc", name = "R", descriptor = "I")
	public int certlink;

	@OriginalMember(owner = "client!cc", name = "S", descriptor = "I")
	public int certtemplate;

	@OriginalMember(owner = "client!cc", name = "T", descriptor = "Lclient!s;")
	public static LruCache modelCache = new LruCache(50);

	@OriginalMember(owner = "client!cc", name = "U", descriptor = "Lclient!s;")
	public static LruCache iconCache = new LruCache(200);

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void unpack(@OriginalArg(0) Jagfile arg0) {
		dat = new Packet(arg0.read("obj.dat", null));
		@Pc(21) Packet local21 = new Packet(arg0.read("obj.idx", null));
		count = local21.g2();
		offsets = new int[count];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < count; local31++) {
			offsets[local31] = local29;
			local29 += local21.g2();
		}
		cache = new ObjType[10];
		for (@Pc(51) int local51 = 0; local51 < 10; local51++) {
			cache[local51] = new ObjType();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)V")
	public static void unload() {
		modelCache = null;
		iconCache = null;
		offsets = null;
		cache = null;
		dat = null;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(I)Lclient!cc;")
	public static ObjType get(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 10; local1++) {
			if (cache[local1].index == arg0) {
				return cache[local1];
			}
		}
		cachePos = (cachePos + 1) % 10;
		@Pc(27) ObjType local27 = cache[cachePos];
		dat.pos = offsets[arg0];
		local27.index = arg0;
		local27.reset();
		local27.decode(dat);
		if (local27.certtemplate != -1) {
			local27.toCertificate();
		}
		if (!membersWorld && local27.members) {
			local27.name = "Members Object";
			local27.desc = "Login to a members' server to use this object.".getBytes();
			local27.ops = null;
			local27.iops = null;
		}
		return local27;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(III)Lclient!hb;")
	public static Pix24 getIcon(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(7) Pix24 local7 = (Pix24) iconCache.get((long) arg0);
		if (local7 != null && local7.cropH != arg2 && local7.cropH != -1) {
			local7.unlink();
			local7 = null;
		}
		if (local7 != null) {
			return local7;
		}
		@Pc(28) ObjType local28 = get(arg0);
		if (local28.countobj == null) {
			arg2 = -1;
		}
		@Pc(38) int local38;
		@Pc(40) int local40;
		if (arg2 > 1) {
			local38 = -1;
			for (local40 = 0; local40 < 10; local40++) {
				if (arg2 >= local28.countco[local40] && local28.countco[local40] != 0) {
					local38 = local28.countobj[local40];
				}
			}
			if (local38 != -1) {
				local28 = get(local38);
			}
		}
		local7 = new Pix24(32, 32);
		local38 = Draw3D.centerX;
		local40 = Draw3D.centerY;
		@Pc(80) int[] local80 = Draw3D.lineOffset;
		@Pc(82) int[] local82 = Draw2D.data;
		@Pc(84) int local84 = Draw2D.width2d;
		@Pc(86) int local86 = Draw2D.height2d;
		@Pc(88) int local88 = Draw2D.left;
		@Pc(90) int local90 = Draw2D.right;
		@Pc(92) int local92 = Draw2D.top;
		@Pc(94) int local94 = Draw2D.bottom;
		Draw3D.jagged = false;
		Draw2D.bind(32, local7.pixels, 32);
		Draw2D.fillRect(0, 0, 0, 32, 32);
		Draw3D.init2D();
		@Pc(115) Model local115 = local28.getInterfaceModel(1);
		@Pc(125) int local125 = Draw3D.sin[local28.xan2d] * local28.zoom2d >> 16;
		@Pc(135) int local135 = Draw3D.cos[local28.xan2d] * local28.zoom2d >> 16;
		local115.drawSimple(0, local28.yan2d, local28.zan2d, local28.xan2d, local28.xof2d, local125 + local115.maxY / 2 + local28.yof2d, local135 + local28.yof2d);
		if (arg1 != 24638) {
			throw new NullPointerException();
		}
		for (@Pc(168) int local168 = 31; local168 >= 0; local168--) {
			for (local135 = 31; local135 >= 0; local135--) {
				if (local7.pixels[local168 + local135 * 32] == 0) {
					if (local168 > 0 && local7.pixels[local168 + local135 * 32 - 1] > 1) {
						local7.pixels[local168 + local135 * 32] = 1;
					} else if (local135 > 0 && local7.pixels[local168 + (local135 - 1) * 32] > 1) {
						local7.pixels[local168 + local135 * 32] = 1;
					} else if (local168 < 31 && local7.pixels[local168 + local135 * 32 + 1] > 1) {
						local7.pixels[local168 + local135 * 32] = 1;
					} else if (local135 < 31 && local7.pixels[local168 + (local135 + 1) * 32] > 1) {
						local7.pixels[local168 + local135 * 32] = 1;
					}
				}
			}
		}
		for (@Pc(291) int local291 = 31; local291 >= 0; local291--) {
			for (local135 = 31; local135 >= 0; local135--) {
				if (local7.pixels[local291 + local135 * 32] == 0 && local291 > 0 && local135 > 0 && local7.pixels[local291 + (local135 - 1) * 32 - 1] > 0) {
					local7.pixels[local291 + local135 * 32] = 3153952;
				}
			}
		}
		if (local28.certtemplate != -1) {
			@Pc(348) Pix24 local348 = getIcon(local28.certlink, 24638, 10);
			@Pc(351) int local351 = local348.cropW;
			@Pc(354) int local354 = local348.cropH;
			local348.cropW = 32;
			local348.cropH = 32;
			local348.crop(22, 5, 22, 5);
			local348.cropW = local351;
			local348.cropH = local354;
		}
		iconCache.put((long) arg0, local7);
		Draw2D.bind(local84, local82, local86);
		Draw2D.setBounds(local94, local92, local90, local88);
		Draw3D.centerX = local38;
		Draw3D.centerY = local40;
		Draw3D.lineOffset = local80;
		Draw3D.jagged = true;
		if (local28.stackable) {
			local7.cropW = 33;
		} else {
			local7.cropW = 32;
		}
		local7.cropH = arg2;
		return local7;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "()V")
	public void reset() {
		this.model = 0;
		this.name = null;
		this.desc = null;
		this.recol_s = null;
		this.recol_d = null;
		this.zoom2d = 2000;
		this.xan2d = 0;
		this.yan2d = 0;
		this.zan2d = 0;
		this.xof2d = 0;
		this.yof2d = 0;
		this.opcode9 = false;
		this.opcode10 = -1;
		this.stackable = false;
		this.cost = 1;
		this.members = false;
		this.ops = null;
		this.iops = null;
		this.manwear = -1;
		this.manwear2 = -1;
		this.manwearOffsetY = 0;
		this.womanwear = -1;
		this.womanwear2 = -1;
		this.womanwearOffsetY = 0;
		this.manwear3 = -1;
		this.womanwear3 = -1;
		this.manhead = -1;
		this.manhead2 = -1;
		this.womanhead = -1;
		this.womanhead2 = -1;
		this.countobj = null;
		this.countco = null;
		this.certlink = -1;
		this.certtemplate = -1;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet buf) {
		while (true) {
			@Pc(10) int opcode = buf.g1();
			if (opcode == 0) {
				break;
			}

			if (opcode == 1) {
				this.model = buf.g2();
			} else if (opcode == 2) {
				this.name = buf.gstr();
			} else if (opcode == 3) {
				this.desc = buf.gstrbyte();
			} else if (opcode == 4) {
				this.zoom2d = buf.g2();
			} else if (opcode == 5) {
				this.xan2d = buf.g2();
			} else if (opcode == 6) {
				this.yan2d = buf.g2();
			} else if (opcode == 7) {
				this.xof2d = buf.g2();
				if (this.xof2d > 32767) {
					this.xof2d -= 65536;
				}
			} else if (opcode == 8) {
				this.yof2d = buf.g2();
				if (this.yof2d > 32767) {
					this.yof2d -= 65536;
				}
			} else if (opcode == 9) {
				this.opcode9 = true;
			} else if (opcode == 10) {
				this.opcode10 = buf.g2();
			} else if (opcode == 11) {
				this.stackable = true;
			} else if (opcode == 12) {
				this.cost = buf.g4();
			} else if (opcode == 16) {
				this.members = true;
			} else if (opcode == 23) {
				this.manwear = buf.g2();
				this.manwearOffsetY = buf.g1b();
			} else if (opcode == 24) {
				this.manwear2 = buf.g2();
			} else if (opcode == 25) {
				this.womanwear = buf.g2();
				this.womanwearOffsetY = buf.g1b();
			} else if (opcode == 26) {
				this.womanwear2 = buf.g2();
			} else if (opcode >= 30 && opcode < 35) {
				if (this.ops == null) {
					this.ops = new String[5];
				}
				this.ops[opcode - 30] = buf.gstr();
				if (this.ops[opcode - 30].equalsIgnoreCase("hidden")) {
					this.ops[opcode - 30] = null;
				}
			} else if (opcode >= 35 && opcode < 40) {
				if (this.iops == null) {
					this.iops = new String[5];
				}
				this.iops[opcode - 35] = buf.gstr();
			} else if (opcode == 40) {
				@Pc(260) int local260 = buf.g1();
				this.recol_s = new int[local260];
				this.recol_d = new int[local260];
				for (@Pc(270) int local270 = 0; local270 < local260; local270++) {
					this.recol_s[local270] = buf.g2();
					this.recol_d[local270] = buf.g2();
				}
			} else if (opcode == 78) {
				this.manwear3 = buf.g2();
			} else if (opcode == 79) {
				this.womanwear3 = buf.g2();
			} else if (opcode == 90) {
				this.manhead = buf.g2();
			} else if (opcode == 91) {
				this.womanhead = buf.g2();
			} else if (opcode == 92) {
				this.manhead2 = buf.g2();
			} else if (opcode == 93) {
				this.womanhead2 = buf.g2();
			} else if (opcode == 95) {
				this.zan2d = buf.g2();
			} else if (opcode == 97) {
				this.certlink = buf.g2();
			} else if (opcode == 98) {
				this.certtemplate = buf.g2();
			} else if (opcode >= 100 && opcode < 110) {
				if (this.countobj == null) {
					this.countobj = new int[10];
					this.countco = new int[10];
				}
				this.countobj[opcode - 100] = buf.g2();
				this.countco[opcode - 100] = buf.g2();
			}
		}
	}

	@OriginalMember(owner = "client!cc", name = "b", descriptor = "(I)V")
	public void toCertificate() {
		@Pc(3) ObjType local3 = get(this.certtemplate);
		this.model = local3.model;
		this.zoom2d = local3.zoom2d;
		this.xan2d = local3.xan2d;
		this.yan2d = local3.yan2d;
		this.zan2d = local3.zan2d;
		this.xof2d = local3.xof2d;
		this.yof2d = local3.yof2d;
		this.recol_s = local3.recol_s;
		this.recol_d = local3.recol_d;
		@Pc(55) ObjType local55 = get(this.certlink);
		this.name = local55.name;
		this.members = local55.members;
		this.cost = local55.cost;
		@Pc(69) String local69 = "a";
		@Pc(74) char local74 = local55.name.charAt(0);
		if (local74 == 'A' || local74 == 'E' || local74 == 'I' || local74 == 'O' || local74 == 'U') {
			local69 = "an";
		}
		this.desc = ("Swap this note at any bank for " + local69 + " " + local55.name + ".").getBytes();
		this.stackable = true;
	}

	@OriginalMember(owner = "client!cc", name = "c", descriptor = "(I)Lclient!eb;")
	public Model getInterfaceModel(@OriginalArg(0) int arg0) {
		@Pc(11) int local11;
		if (this.countobj != null && arg0 > 1) {
			@Pc(9) int local9 = -1;
			for (local11 = 0; local11 < 10; local11++) {
				if (arg0 >= this.countco[local11] && this.countco[local11] != 0) {
					local9 = this.countobj[local11];
				}
			}
			if (local9 != -1) {
				return get(local9).getInterfaceModel(1);
			}
		}
		@Pc(48) Model local48 = (Model) modelCache.get((long) this.index);
		if (local48 != null) {
			return local48;
		}
		local48 = new Model(this.model);
		if (this.recol_s != null) {
			for (local11 = 0; local11 < this.recol_s.length; local11++) {
				local48.recolor(this.recol_s[local11], this.recol_d[local11]);
			}
		}
		local48.calculateNormals(64, 768, -50, -10, -50, true);
		local48.pickable = true;
		modelCache.put((long) this.index, local48);
		return local48;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(BI)Lclient!eb;")
	public Model getWornModel(@OriginalArg(1) int arg1) {
		@Pc(4) int local4 = this.manwear;
		if (arg1 == 1) {
			local4 = this.womanwear;
		}
		if (local4 == -1) {
			return null;
		}
		@Pc(25) int local25 = this.manwear2;
		@Pc(28) int local28 = this.manwear3;
		if (arg1 == 1) {
			local25 = this.womanwear2;
			local28 = this.womanwear3;
		}
		@Pc(43) Model local43 = new Model(local4);
		if (local25 != -1) {
			@Pc(55) Model local55;
			if (local28 == -1) {
				local55 = new Model(local25);
				@Pc(102) Model[] local102 = new Model[] { local43, local55 };
				local43 = new Model(local102, 2);
			} else {
				local55 = new Model(local25);
				@Pc(61) Model local61 = new Model(local28);
				@Pc(76) Model[] local76 = new Model[] { local43, local55, local61 };
				local43 = new Model(local76, 3);
			}
		}
		if (arg1 == 0 && this.manwearOffsetY != 0) {
			local43.translate(this.manwearOffsetY, 0, 0);
		}
		if (arg1 == 1 && this.womanwearOffsetY != 0) {
			local43.translate(this.womanwearOffsetY, 0, 0);
		}
		if (this.recol_s != null) {
			for (@Pc(139) int local139 = 0; local139 < this.recol_s.length; local139++) {
				local43.recolor(this.recol_s[local139], this.recol_d[local139]);
			}
		}
		return local43;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(II)Lclient!eb;")
	public Model getModel(@OriginalArg(1) int arg1) {
		@Pc(2) int local2 = this.manhead;
		if (arg1 == 1) {
			local2 = this.womanhead;
		}
		if (local2 == -1) {
			return null;
		}
		@Pc(22) int local22 = this.manhead2;
		if (arg1 == 1) {
			local22 = this.womanhead2;
		}
		@Pc(34) Model local34 = new Model(local2);
		if (local22 != -1) {
			@Pc(43) Model local43 = new Model(local22);
			@Pc(54) Model[] local54 = new Model[] { local34, local43 };
			local34 = new Model(local54, 2);
		}
		if (this.recol_s != null) {
			for (@Pc(66) int local66 = 0; local66 < this.recol_s.length; local66++) {
				local34.recolor(this.recol_s[local66], this.recol_d[local66]);
			}
		}
		return local34;
	}
}
