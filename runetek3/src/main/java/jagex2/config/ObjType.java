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

// name taken from rs3
@OriginalClass("client!cc")
public class ObjType {

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
	public String desc;

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
	private boolean code9;

	@OriginalMember(owner = "client!cc", name = "x", descriptor = "I")
	private int code10;

	@OriginalMember(owner = "client!cc", name = "y", descriptor = "Z")
	public boolean stackable;

	@OriginalMember(owner = "client!cc", name = "z", descriptor = "I")
	public int cost;

	@OriginalMember(owner = "client!cc", name = "A", descriptor = "Z")
	public boolean members;

	@OriginalMember(owner = "client!cc", name = "B", descriptor = "[Ljava/lang/String;")
	public String[] op;

	@OriginalMember(owner = "client!cc", name = "C", descriptor = "[Ljava/lang/String;")
	public String[] iop;

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
	public static void unpack(@OriginalArg(0) Jagfile config) {
		dat = new Packet(config.read("obj.dat", null));
		@Pc(21) Packet idx = new Packet(config.read("obj.idx", null));

		count = idx.g2();
		offsets = new int[count];

		@Pc(29) int offset = 2;
		for (@Pc(31) int id = 0; id < count; id++) {
			offsets[id] = offset;
			offset += idx.g2();
		}

		cache = new ObjType[10];
		for (@Pc(51) int id = 0; id < 10; id++) {
			cache[id] = new ObjType();
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
	public static ObjType get(@OriginalArg(0) int id) {
		for (@Pc(1) int i = 0; i < 10; i++) {
			if (cache[i].index == id) {
				return cache[i];
			}
		}

		cachePos = (cachePos + 1) % 10;
		@Pc(27) ObjType obj = cache[cachePos];
		dat.pos = offsets[id];
		obj.index = id;
		obj.reset();
		obj.decode(dat);

		if (obj.certtemplate != -1) {
			obj.toCertificate();
		}

		if (!membersWorld && obj.members) {
			obj.name = "Members Object";
			obj.desc = "Login to a members' server to use this object.";
			obj.op = null;
			obj.iop = null;
		}

		return obj;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(III)Lclient!hb;")
	public static Pix24 getIcon(@OriginalArg(0) int id, @OriginalArg(2) int count) {
		@Pc(7) Pix24 icon = (Pix24) iconCache.get(id);
		if (icon != null && icon.cropH != count && icon.cropH != -1) {
			icon.unlink();
			icon = null;
		}

		if (icon != null) {
			return icon;
		}

		@Pc(28) ObjType obj = get(id);
		if (obj.countobj == null) {
			count = -1;
		}

		if (count > 1) {
			int countobj = -1;
			for (int i = 0; i < 10; i++) {
				if (count >= obj.countco[i] && obj.countco[i] != 0) {
					countobj = obj.countobj[i];
				}
			}

			if (countobj != -1) {
				obj = get(countobj);
			}
		}

		icon = new Pix24(32, 32);

		int _cx = Draw3D.centerX;
		int _cy = Draw3D.centerY;
		@Pc(80) int[] _loff = Draw3D.lineOffset;
		@Pc(82) int[] _data = Draw2D.data;
		@Pc(84) int _w = Draw2D.width2d;
		@Pc(86) int _h = Draw2D.height2d;
		@Pc(88) int _l = Draw2D.left;
		@Pc(90) int _r = Draw2D.right;
		@Pc(92) int _t = Draw2D.top;
		@Pc(94) int _b = Draw2D.bottom;

		Draw3D.jagged = false;
		Draw2D.bind(32, 32, icon.pixels);
		Draw2D.fillRect(0, 0, 0, 32, 32);
		Draw3D.init2D();

		@Pc(115) Model iModel = obj.getInterfaceModel(1);
		@Pc(125) int sinPitch = Draw3D.sin[obj.xan2d] * obj.zoom2d >> 16;
		@Pc(135) int cosPitch = Draw3D.cos[obj.xan2d] * obj.zoom2d >> 16;
		iModel.drawSimple(0, obj.yan2d, obj.zan2d, obj.xan2d, obj.xof2d, sinPitch + iModel.maxY / 2 + obj.yof2d, cosPitch + obj.yof2d);

		for (@Pc(168) int x = 31; x >= 0; x--) {
			for (int y = 31; y >= 0; y--) {
				if (icon.pixels[x + y * 32] != 0) {
					continue;
				}

				if (x > 0 && icon.pixels[x + y * 32 - 1] > 1) {
					icon.pixels[x + y * 32] = 1;
				} else if (y > 0 && icon.pixels[x + (y - 1) * 32] > 1) {
					icon.pixels[x + y * 32] = 1;
				} else if (x < 31 && icon.pixels[x + y * 32 + 1] > 1) {
					icon.pixels[x + y * 32] = 1;
				} else if (y < 31 && icon.pixels[x + (y + 1) * 32] > 1) {
					icon.pixels[x + y * 32] = 1;
				}
			}
		}

		for (@Pc(291) int x = 31; x >= 0; x--) {
			for (int y = 31; y >= 0; y--) {
				if (icon.pixels[x + y * 32] == 0 && x > 0 && y > 0 && icon.pixels[x + (y - 1) * 32 - 1] > 0) {
					icon.pixels[x + y * 32] = 3153952;
				}
			}
		}

		if (obj.certtemplate != -1) {
			@Pc(348) Pix24 linkedIcon = getIcon(obj.certlink, 10);
			@Pc(351) int w = linkedIcon.cropW;
			@Pc(354) int h = linkedIcon.cropH;
			linkedIcon.cropW = 32;
			linkedIcon.cropH = 32;
			linkedIcon.crop(5, 5, 22, 22);
			linkedIcon.cropW = w;
			linkedIcon.cropH = h;
		}

		iconCache.put(id, icon);
		Draw2D.bind(_w, _h, _data);
		Draw2D.setBounds(_b, _r, _t, _l);
		Draw3D.centerX = _cx;
		Draw3D.centerY = _cy;
		Draw3D.lineOffset = _loff;
		Draw3D.jagged = true;
		if (obj.stackable) {
			icon.cropW = 33;
		} else {
			icon.cropW = 32;
		}
		icon.cropH = count;
		return icon;
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
		this.code9 = false;
		this.code10 = -1;
		this.stackable = false;
		this.cost = 1;
		this.members = false;
		this.op = null;
		this.iop = null;
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
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(10) int code = dat.g1();
			if (code == 0) {
				break;
			}

			if (code == 1) {
				this.model = dat.g2();
			} else if (code == 2) {
				this.name = dat.gjstr();
			} else if (code == 3) {
				this.desc = dat.gjstr();
			} else if (code == 4) {
				this.zoom2d = dat.g2();
			} else if (code == 5) {
				this.xan2d = dat.g2();
			} else if (code == 6) {
				this.yan2d = dat.g2();
			} else if (code == 7) {
				this.xof2d = dat.g2();
				if (this.xof2d > 32767) {
					this.xof2d -= 65536;
				}
			} else if (code == 8) {
				this.yof2d = dat.g2();
				if (this.yof2d > 32767) {
					this.yof2d -= 65536;
				}
			} else if (code == 9) {
				this.code9 = true;
			} else if (code == 10) {
				this.code10 = dat.g2();
			} else if (code == 11) {
				this.stackable = true;
			} else if (code == 12) {
				this.cost = dat.g4();
			} else if (code == 16) {
				this.members = true;
			} else if (code == 23) {
				this.manwear = dat.g2();
				this.manwearOffsetY = dat.g1b();
			} else if (code == 24) {
				this.manwear2 = dat.g2();
			} else if (code == 25) {
				this.womanwear = dat.g2();
				this.womanwearOffsetY = dat.g1b();
			} else if (code == 26) {
				this.womanwear2 = dat.g2();
			} else if (code >= 30 && code < 35) {
				if (this.op == null) {
					this.op = new String[5];
				}

				this.op[code - 30] = dat.gjstr();
				if (this.op[code - 30].equalsIgnoreCase("hidden")) {
					this.op[code - 30] = null;
				}
			} else if (code >= 35 && code < 40) {
				if (this.iop == null) {
					this.iop = new String[5];
				}

				this.iop[code - 35] = dat.gjstr();
			} else if (code == 40) {
				@Pc(260) int count = dat.g1();
				this.recol_s = new int[count];
				this.recol_d = new int[count];

				for (@Pc(270) int i = 0; i < count; i++) {
					this.recol_s[i] = dat.g2();
					this.recol_d[i] = dat.g2();
				}
			} else if (code == 78) {
				this.manwear3 = dat.g2();
			} else if (code == 79) {
				this.womanwear3 = dat.g2();
			} else if (code == 90) {
				this.manhead = dat.g2();
			} else if (code == 91) {
				this.womanhead = dat.g2();
			} else if (code == 92) {
				this.manhead2 = dat.g2();
			} else if (code == 93) {
				this.womanhead2 = dat.g2();
			} else if (code == 95) {
				this.zan2d = dat.g2();
			} else if (code == 97) {
				this.certlink = dat.g2();
			} else if (code == 98) {
				this.certtemplate = dat.g2();
			} else if (code >= 100 && code < 110) {
				if (this.countobj == null) {
					this.countobj = new int[10];
					this.countco = new int[10];
				}

				this.countobj[code - 100] = dat.g2();
				this.countco[code - 100] = dat.g2();
			}
		}
	}

	@OriginalMember(owner = "client!cc", name = "b", descriptor = "(I)V")
	public void toCertificate() {
		@Pc(3) ObjType template = get(this.certtemplate);
		this.model = template.model;
		this.zoom2d = template.zoom2d;
		this.xan2d = template.xan2d;
		this.yan2d = template.yan2d;
		this.zan2d = template.zan2d;
		this.xof2d = template.xof2d;
		this.yof2d = template.yof2d;
		this.recol_s = template.recol_s;
		this.recol_d = template.recol_d;

		@Pc(55) ObjType link = get(this.certlink);
		this.name = link.name;
		this.members = link.members;
		this.cost = link.cost;

		@Pc(69) String article = "a";
		@Pc(74) char c = link.name.charAt(0);
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
			article = "an";
		}
		this.desc = "Swap this note at any bank for " + article + " " + link.name + ".";

		this.stackable = true;
	}

	@OriginalMember(owner = "client!cc", name = "c", descriptor = "(I)Lclient!eb;")
	public Model getInterfaceModel(@OriginalArg(0) int count) {
		if (this.countobj != null && count > 1) {
			@Pc(9) int id = -1;
			for (int i = 0; i < 10; i++) {
				if (count >= this.countco[i] && this.countco[i] != 0) {
					id = this.countobj[i];
				}
			}

			if (id != -1) {
				return get(id).getInterfaceModel(1);
			}
		}

		@Pc(48) Model model = (Model) modelCache.get(this.index);
		if (model != null) {
			return model;
		}

		model = new Model(this.model);
		if (this.recol_s != null) {
			for (int i = 0; i < this.recol_s.length; i++) {
				model.recolor(this.recol_s[i], this.recol_d[i]);
			}
		}

		model.calculateNormals(64, 768, -50, -10, -50, true);
		model.pickable = true;
		modelCache.put(this.index, model);
		return model;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(BI)Lclient!eb;")
	public Model getWornModel(@OriginalArg(1) int gender) {
		@Pc(4) int id1 = this.manwear;
		if (gender == 1) {
			id1 = this.womanwear;
		}

		if (id1 == -1) {
			return null;
		}

		@Pc(25) int id2 = this.manwear2;
		@Pc(28) int id3 = this.manwear3;
		if (gender == 1) {
			id2 = this.womanwear2;
			id3 = this.womanwear3;
		}

		@Pc(43) Model model = new Model(id1);
		if (id2 != -1) {
			@Pc(55) Model model2;
			model2 = new Model(id2);

			if (id3 == -1) {
				@Pc(102) Model[] models = new Model[] { model, model2 };
				model = new Model(models, 2);
			} else {
				@Pc(61) Model model3 = new Model(id3);
				@Pc(76) Model[] models = new Model[] { model, model2, model3 };
				model = new Model(models, 3);
			}
		}

		if (gender == 0 && this.manwearOffsetY != 0) {
			model.translate(this.manwearOffsetY, 0, 0);
		}

		if (gender == 1 && this.womanwearOffsetY != 0) {
			model.translate(this.womanwearOffsetY, 0, 0);
		}

		if (this.recol_s != null) {
			for (@Pc(139) int i = 0; i < this.recol_s.length; i++) {
				model.recolor(this.recol_s[i], this.recol_d[i]);
			}
		}

		return model;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(II)Lclient!eb;")
	public Model getHeadModel(@OriginalArg(1) int gender) {
		@Pc(2) int head1 = this.manhead;
		if (gender == 1) {
			head1 = this.womanhead;
		}

		if (head1 == -1) {
			return null;
		}

		@Pc(22) int head2 = this.manhead2;
		if (gender == 1) {
			head2 = this.womanhead2;
		}

		@Pc(34) Model model = new Model(head1);
		if (head2 != -1) {
			@Pc(43) Model model2 = new Model(head2);
			@Pc(54) Model[] models = new Model[] { model, model2 };
			model = new Model(models, 2);
		}

		if (this.recol_s != null) {
			for (@Pc(66) int i = 0; i < this.recol_s.length; i++) {
				model.recolor(this.recol_s[i], this.recol_d[i]);
			}
		}

		return model;
	}
}
