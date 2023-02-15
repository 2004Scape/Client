import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!cc")
public final class ObjType {

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "I")
	private static int flowObfuscator1;

	@OriginalMember(owner = "client!cc", name = "b", descriptor = "Z")
	private boolean flowObfuscator2 = false;

	@OriginalMember(owner = "client!cc", name = "c", descriptor = "I")
	public static int flowObfuscator3 = -192;

	@OriginalMember(owner = "client!cc", name = "d", descriptor = "I")
	private final int flowObfuscator4 = -22246;

	@OriginalMember(owner = "client!cc", name = "e", descriptor = "I")
	private static int flowObfuscator5;

	@OriginalMember(owner = "client!cc", name = "f", descriptor = "[I")
	private static int[] anIntArray23;

	@OriginalMember(owner = "client!cc", name = "g", descriptor = "Lclient!kb;")
	private static Buffer aClass1_Sub3_Sub3_3;

	@OriginalMember(owner = "client!cc", name = "h", descriptor = "[Lclient!cc;")
	private static ObjType[] aClass5Array1;

	@OriginalMember(owner = "client!cc", name = "i", descriptor = "I")
	private static int anInt102;

	@OriginalMember(owner = "client!cc", name = "j", descriptor = "Z")
	public static boolean members = true;

	@OriginalMember(owner = "client!cc", name = "k", descriptor = "I")
	public int anInt103 = -1;

	@OriginalMember(owner = "client!cc", name = "l", descriptor = "I")
	private int anInt104;

	@OriginalMember(owner = "client!cc", name = "m", descriptor = "Ljava/lang/String;")
	public String aString3;

	@OriginalMember(owner = "client!cc", name = "n", descriptor = "[B")
	public byte[] aByteArray3;

	@OriginalMember(owner = "client!cc", name = "o", descriptor = "[I")
	private int[] anIntArray24;

	@OriginalMember(owner = "client!cc", name = "p", descriptor = "[I")
	private int[] anIntArray25;

	@OriginalMember(owner = "client!cc", name = "q", descriptor = "I")
	public int iconZoom;

	@OriginalMember(owner = "client!cc", name = "r", descriptor = "I")
	public int iconPitch;

	@OriginalMember(owner = "client!cc", name = "s", descriptor = "I")
	public int iconYaw;

	@OriginalMember(owner = "client!cc", name = "t", descriptor = "I")
	public int anInt108;

	@OriginalMember(owner = "client!cc", name = "u", descriptor = "I")
	public int anInt109;

	@OriginalMember(owner = "client!cc", name = "v", descriptor = "I")
	public int anInt110;

	@OriginalMember(owner = "client!cc", name = "w", descriptor = "Z")
	private boolean aBoolean30;

	@OriginalMember(owner = "client!cc", name = "x", descriptor = "I")
	private int anInt111;

	@OriginalMember(owner = "client!cc", name = "y", descriptor = "Z")
	public boolean stackable;

	@OriginalMember(owner = "client!cc", name = "z", descriptor = "I")
	public int cost;

	@OriginalMember(owner = "client!cc", name = "A", descriptor = "Z")
	public boolean aBoolean32;

	@OriginalMember(owner = "client!cc", name = "B", descriptor = "[Ljava/lang/String;")
	public String[] aStringArray3;

	@OriginalMember(owner = "client!cc", name = "C", descriptor = "[Ljava/lang/String;")
	public String[] aStringArray4;

	@OriginalMember(owner = "client!cc", name = "D", descriptor = "I")
	private int anInt113;

	@OriginalMember(owner = "client!cc", name = "E", descriptor = "I")
	private int anInt114;

	@OriginalMember(owner = "client!cc", name = "F", descriptor = "B")
	private byte aByte5;

	@OriginalMember(owner = "client!cc", name = "G", descriptor = "I")
	private int anInt115;

	@OriginalMember(owner = "client!cc", name = "H", descriptor = "I")
	private int anInt116;

	@OriginalMember(owner = "client!cc", name = "I", descriptor = "B")
	private byte aByte6;

	@OriginalMember(owner = "client!cc", name = "J", descriptor = "I")
	private int anInt117;

	@OriginalMember(owner = "client!cc", name = "K", descriptor = "I")
	private int anInt118;

	@OriginalMember(owner = "client!cc", name = "L", descriptor = "I")
	private int anInt119;

	@OriginalMember(owner = "client!cc", name = "M", descriptor = "I")
	private int anInt120;

	@OriginalMember(owner = "client!cc", name = "N", descriptor = "I")
	private int anInt121;

	@OriginalMember(owner = "client!cc", name = "O", descriptor = "I")
	private int anInt122;

	@OriginalMember(owner = "client!cc", name = "P", descriptor = "[I")
	public int[] anIntArray26;

	@OriginalMember(owner = "client!cc", name = "Q", descriptor = "[I")
	public int[] anIntArray27;

	@OriginalMember(owner = "client!cc", name = "R", descriptor = "I")
	public int anInt123;

	@OriginalMember(owner = "client!cc", name = "S", descriptor = "I")
	public int anInt124;

	@OriginalMember(owner = "client!cc", name = "T", descriptor = "Lclient!s;")
	public static Cache aClass35_4 = new Cache((byte) 0, 50);

	@OriginalMember(owner = "client!cc", name = "U", descriptor = "Lclient!s;")
	public static Cache aClass35_5 = new Cache((byte) 0, 200);

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void method52(@OriginalArg(0) FileArchive arg0) {
		aClass1_Sub3_Sub3_3 = new Buffer(363, arg0.method536("obj.dat", null, (byte) 2));
		@Pc(21) Buffer local21 = new Buffer(363, arg0.method536("obj.idx", null, (byte) 2));
		flowObfuscator5 = local21.method393();
		anIntArray23 = new int[flowObfuscator5];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < flowObfuscator5; local31++) {
			anIntArray23[local31] = local29;
			local29 += local21.method393();
		}
		aClass5Array1 = new ObjType[10];
		for (@Pc(51) int local51 = 0; local51 < 10; local51++) {
			aClass5Array1[local51] = new ObjType();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(Z)V")
	public static void method53(@OriginalArg(0) boolean arg0) {
		try {
			aClass35_4 = null;
			aClass35_5 = null;
			anIntArray23 = null;
			aClass5Array1 = null;
			aClass1_Sub3_Sub3_3 = null;
			if (!arg0) {
				flowObfuscator1 = -296;
			}
		} catch (@Pc(15) RuntimeException local15) {
			signlink.reporterror("12851, " + arg0 + ", " + local15.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(I)Lclient!cc;")
	public static ObjType get(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 10; local1++) {
			if (aClass5Array1[local1].anInt103 == arg0) {
				return aClass5Array1[local1];
			}
		}
		anInt102 = (anInt102 + 1) % 10;
		@Pc(27) ObjType local27 = aClass5Array1[anInt102];
		aClass1_Sub3_Sub3_3.position = anIntArray23[arg0];
		local27.anInt103 = arg0;
		local27.method55();
		local27.method56(false, aClass1_Sub3_Sub3_3);
		if (local27.anInt124 != -1) {
			local27.method57(-856);
		}
		if (!members && local27.aBoolean32) {
			local27.aString3 = "Members Object";
			local27.aByteArray3 = "Login to a members' server to use this object.".getBytes();
			local27.aStringArray3 = null;
			local27.aStringArray4 = null;
		}
		return local27;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(III)Lclient!hb;")
	public static Image24 method59(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(7) Image24 local7 = (Image24) aClass35_5.get((long) arg0);
			if (local7 != null && local7.cropH != arg2 && local7.cropH != -1) {
				local7.method567();
				local7 = null;
			}
			if (local7 != null) {
				return local7;
			}
			@Pc(28) ObjType local28 = get(arg0);
			if (local28.anIntArray26 == null) {
				arg2 = -1;
			}
			@Pc(38) int local38;
			@Pc(40) int local40;
			if (arg2 > 1) {
				local38 = -1;
				for (local40 = 0; local40 < 10; local40++) {
					if (arg2 >= local28.anIntArray27[local40] && local28.anIntArray27[local40] != 0) {
						local38 = local28.anIntArray26[local40];
					}
				}
				if (local38 != -1) {
					local28 = get(local38);
				}
			}
			local7 = new Image24(32, 32);
			local38 = Draw3D.centerX;
			local40 = Draw3D.centerY;
			@Pc(80) int[] local80 = Draw3D.lineOffset;
			@Pc(82) int[] local82 = Draw2D.anIntArray178;
			@Pc(84) int local84 = Draw2D.anInt528;
			@Pc(86) int local86 = Draw2D.anInt529;
			@Pc(88) int local88 = Draw2D.anInt532;
			@Pc(90) int local90 = Draw2D.anInt533;
			@Pc(92) int local92 = Draw2D.anInt530;
			@Pc(94) int local94 = Draw2D.anInt531;
			Draw3D.aBoolean99 = false;
			Draw2D.method354(32, local7.pixels, -657, 32);
			Draw2D.method358(0, 0, 0, (byte) 93, 32, 32);
			Draw3D.method288(flowObfuscator3);
			@Pc(115) Model local115 = local28.method58(1);
			@Pc(125) int local125 = Draw3D.sin[local28.iconPitch] * local28.iconZoom >> 16;
			@Pc(135) int local135 = Draw3D.cos[local28.iconPitch] * local28.iconZoom >> 16;
			local115.method243(0, local28.iconYaw, local28.anInt108, local28.iconPitch, local28.anInt109, local125 + local115.minY / 2 + local28.anInt110, local135 + local28.anInt110);
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
			if (local28.anInt124 != -1) {
				@Pc(348) Image24 local348 = method59(local28.anInt123, 24638, 10);
				@Pc(351) int local351 = local348.cropW;
				@Pc(354) int local354 = local348.cropH;
				local348.cropW = 32;
				local348.cropH = 32;
				local348.method324(22, 5, 22, 17713, 5);
				local348.cropW = local351;
				local348.cropH = local354;
			}
			aClass35_5.put(6, (long) arg0, local7);
			Draw2D.method354(local84, local82, -657, local86);
			Draw2D.method356(local94, local92, local90, 789, local88);
			Draw3D.centerX = local38;
			Draw3D.centerY = local40;
			Draw3D.lineOffset = local80;
			Draw3D.aBoolean99 = true;
			if (local28.stackable) {
				local7.cropW = 33;
			} else {
				local7.cropW = 32;
			}
			local7.cropH = arg2;
			return local7;
		} catch (@Pc(415) RuntimeException local415) {
			signlink.reporterror("43278, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local415.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "()V")
	public void method55() {
		this.anInt104 = 0;
		this.aString3 = null;
		this.aByteArray3 = null;
		this.anIntArray24 = null;
		this.anIntArray25 = null;
		this.iconZoom = 2000;
		this.iconPitch = 0;
		this.iconYaw = 0;
		this.anInt108 = 0;
		this.anInt109 = 0;
		this.anInt110 = 0;
		this.aBoolean30 = false;
		this.anInt111 = -1;
		this.stackable = false;
		this.cost = 1;
		this.aBoolean32 = false;
		this.aStringArray3 = null;
		this.aStringArray4 = null;
		this.anInt113 = -1;
		this.anInt114 = -1;
		this.aByte5 = 0;
		this.anInt115 = -1;
		this.anInt116 = -1;
		this.aByte6 = 0;
		this.anInt117 = -1;
		this.anInt118 = -1;
		this.anInt119 = -1;
		this.anInt120 = -1;
		this.anInt121 = -1;
		this.anInt122 = -1;
		this.anIntArray26 = null;
		this.anIntArray27 = null;
		this.anInt123 = -1;
		this.anInt124 = -1;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method56(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			if (arg0) {
				throw new NullPointerException();
			}
			while (true) {
				while (true) {
					@Pc(10) int local10 = arg1.method391();
					if (local10 == 0) {
						return;
					}
					if (local10 == 1) {
						this.anInt104 = arg1.method393();
					} else if (local10 == 2) {
						this.aString3 = arg1.method398();
					} else if (local10 == 3) {
						this.aByteArray3 = arg1.method399((byte) 31);
					} else if (local10 == 4) {
						this.iconZoom = arg1.method393();
					} else if (local10 == 5) {
						this.iconPitch = arg1.method393();
					} else if (local10 == 6) {
						this.iconYaw = arg1.method393();
					} else if (local10 == 7) {
						this.anInt109 = arg1.method393();
						if (this.anInt109 > 32767) {
							this.anInt109 -= 65536;
						}
					} else if (local10 == 8) {
						this.anInt110 = arg1.method393();
						if (this.anInt110 > 32767) {
							this.anInt110 -= 65536;
						}
					} else if (local10 == 9) {
						this.aBoolean30 = true;
					} else if (local10 == 10) {
						this.anInt111 = arg1.method393();
					} else if (local10 == 11) {
						this.stackable = true;
					} else if (local10 == 12) {
						this.cost = arg1.method396();
					} else if (local10 == 16) {
						this.aBoolean32 = true;
					} else if (local10 == 23) {
						this.anInt113 = arg1.method393();
						this.aByte5 = arg1.method392();
					} else if (local10 == 24) {
						this.anInt114 = arg1.method393();
					} else if (local10 == 25) {
						this.anInt115 = arg1.method393();
						this.aByte6 = arg1.method392();
					} else if (local10 == 26) {
						this.anInt116 = arg1.method393();
					} else if (local10 >= 30 && local10 < 35) {
						if (this.aStringArray3 == null) {
							this.aStringArray3 = new String[5];
						}
						this.aStringArray3[local10 - 30] = arg1.method398();
						if (this.aStringArray3[local10 - 30].equalsIgnoreCase("hidden")) {
							this.aStringArray3[local10 - 30] = null;
						}
					} else if (local10 >= 35 && local10 < 40) {
						if (this.aStringArray4 == null) {
							this.aStringArray4 = new String[5];
						}
						this.aStringArray4[local10 - 35] = arg1.method398();
					} else if (local10 == 40) {
						@Pc(260) int local260 = arg1.method391();
						this.anIntArray24 = new int[local260];
						this.anIntArray25 = new int[local260];
						for (@Pc(270) int local270 = 0; local270 < local260; local270++) {
							this.anIntArray24[local270] = arg1.method393();
							this.anIntArray25[local270] = arg1.method393();
						}
					} else if (local10 == 78) {
						this.anInt117 = arg1.method393();
					} else if (local10 == 79) {
						this.anInt118 = arg1.method393();
					} else if (local10 == 90) {
						this.anInt119 = arg1.method393();
					} else if (local10 == 91) {
						this.anInt121 = arg1.method393();
					} else if (local10 == 92) {
						this.anInt120 = arg1.method393();
					} else if (local10 == 93) {
						this.anInt122 = arg1.method393();
					} else if (local10 == 95) {
						this.anInt108 = arg1.method393();
					} else if (local10 == 97) {
						this.anInt123 = arg1.method393();
					} else if (local10 == 98) {
						this.anInt124 = arg1.method393();
					} else if (local10 >= 100 && local10 < 110) {
						if (this.anIntArray26 == null) {
							this.anIntArray26 = new int[10];
							this.anIntArray27 = new int[10];
						}
						this.anIntArray26[local10 - 100] = arg1.method393();
						this.anIntArray27[local10 - 100] = arg1.method393();
					}
				}
			}
		} catch (@Pc(406) RuntimeException local406) {
			signlink.reporterror("9273, " + arg0 + ", " + arg1 + ", " + local406.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "b", descriptor = "(I)V")
	public void method57(@OriginalArg(0) int arg0) {
		try {
			@Pc(3) ObjType local3 = get(this.anInt124);
			this.anInt104 = local3.anInt104;
			this.iconZoom = local3.iconZoom;
			this.iconPitch = local3.iconPitch;
			while (arg0 >= 0) {
				this.flowObfuscator2 = !this.flowObfuscator2;
			}
			this.iconYaw = local3.iconYaw;
			this.anInt108 = local3.anInt108;
			this.anInt109 = local3.anInt109;
			this.anInt110 = local3.anInt110;
			this.anIntArray24 = local3.anIntArray24;
			this.anIntArray25 = local3.anIntArray25;
			@Pc(55) ObjType local55 = get(this.anInt123);
			this.aString3 = local55.aString3;
			this.aBoolean32 = local55.aBoolean32;
			this.cost = local55.cost;
			@Pc(69) String local69 = "a";
			@Pc(74) char local74 = local55.aString3.charAt(0);
			if (local74 == 'A' || local74 == 'E' || local74 == 'I' || local74 == 'O' || local74 == 'U') {
				local69 = "an";
			}
			this.aByteArray3 = ("Swap this note at any bank for " + local69 + " " + local55.aString3 + ".").getBytes();
			this.stackable = true;
		} catch (@Pc(113) RuntimeException local113) {
			signlink.reporterror("96838, " + arg0 + ", " + local113.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "c", descriptor = "(I)Lclient!eb;")
	public Model method58(@OriginalArg(0) int arg0) {
		@Pc(11) int local11;
		if (this.anIntArray26 != null && arg0 > 1) {
			@Pc(9) int local9 = -1;
			for (local11 = 0; local11 < 10; local11++) {
				if (arg0 >= this.anIntArray27[local11] && this.anIntArray27[local11] != 0) {
					local9 = this.anIntArray26[local11];
				}
			}
			if (local9 != -1) {
				return get(local9).method58(1);
			}
		}
		@Pc(48) Model local48 = (Model) aClass35_4.get((long) this.anInt103);
		if (local48 != null) {
			return local48;
		}
		local48 = new Model(false, this.anInt104);
		if (this.anIntArray24 != null) {
			for (local11 = 0; local11 < this.anIntArray24.length; local11++) {
				local48.recolor(this.anIntArray24[local11], this.anIntArray25[local11]);
			}
		}
		local48.calculateNormals(64, 768, -50, -10, -50, true);
		local48.pickable = true;
		aClass35_4.put(6, (long) this.anInt103, local48);
		return local48;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(BI)Lclient!eb;")
	public Model getWornModel(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(4) int local4 = this.anInt113;
			if (arg0 != 6) {
				throw new NullPointerException();
			}
			if (arg1 == 1) {
				local4 = this.anInt115;
			}
			if (local4 == -1) {
				return null;
			}
			@Pc(25) int local25 = this.anInt114;
			@Pc(28) int local28 = this.anInt117;
			if (arg1 == 1) {
				local25 = this.anInt116;
				local28 = this.anInt118;
			}
			@Pc(43) Model local43 = new Model(false, local4);
			if (local25 != -1) {
				@Pc(55) Model local55;
				if (local28 == -1) {
					local55 = new Model(false, local25);
					@Pc(102) Model[] local102 = new Model[] { local43, local55 };
					local43 = new Model(0, local102, 2);
				} else {
					local55 = new Model(false, local25);
					@Pc(61) Model local61 = new Model(false, local28);
					@Pc(76) Model[] local76 = new Model[] { local43, local55, local61 };
					local43 = new Model(0, local76, 3);
				}
			}
			if (arg1 == 0 && this.aByte5 != 0) {
				local43.translate(this.aByte5, 0, -122, 0);
			}
			if (arg1 == 1 && this.aByte6 != 0) {
				local43.translate(this.aByte6, 0, -122, 0);
			}
			if (this.anIntArray24 != null) {
				for (@Pc(139) int local139 = 0; local139 < this.anIntArray24.length; local139++) {
					local43.recolor(this.anIntArray24[local139], this.anIntArray25[local139]);
				}
			}
			return local43;
		} catch (@Pc(160) RuntimeException local160) {
			signlink.reporterror("95348, " + arg0 + ", " + arg1 + ", " + local160.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(II)Lclient!eb;")
	public Model method61(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(2) int local2 = this.anInt119;
			if (arg0 != this.flowObfuscator4) {
				flowObfuscator3 = 205;
			}
			if (arg1 == 1) {
				local2 = this.anInt121;
			}
			if (local2 == -1) {
				return null;
			}
			@Pc(22) int local22 = this.anInt120;
			if (arg1 == 1) {
				local22 = this.anInt122;
			}
			@Pc(34) Model local34 = new Model(false, local2);
			if (local22 != -1) {
				@Pc(43) Model local43 = new Model(false, local22);
				@Pc(54) Model[] local54 = new Model[] { local34, local43 };
				local34 = new Model(0, local54, 2);
			}
			if (this.anIntArray24 != null) {
				for (@Pc(66) int local66 = 0; local66 < this.anIntArray24.length; local66++) {
					local34.recolor(this.anIntArray24[local66], this.anIntArray25[local66]);
				}
			}
			return local34;
		} catch (@Pc(87) RuntimeException local87) {
			signlink.reporterror("22260, " + arg0 + ", " + arg1 + ", " + local87.toString());
			throw new RuntimeException();
		}
	}
}
