import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;

import jagex2.client.GameShell;
import jagex2.graphics.Draw2D;
import jagex2.graphics.Pix24;
import jagex2.graphics.Pix8;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!mapview")
public final class mapview extends GameShell {

	@OriginalMember(owner = "mapview!mapview", name = "F", descriptor = "Z")
	private static boolean aBoolean12;

	@OriginalMember(owner = "mapview!mapview", name = "O", descriptor = "I")
	private static int anInt129;

	@OriginalMember(owner = "mapview!mapview", name = "P", descriptor = "I")
	private static int anInt130;

	@OriginalMember(owner = "mapview!mapview", name = "Q", descriptor = "I")
	private static int anInt131;

	@OriginalMember(owner = "mapview!mapview", name = "R", descriptor = "I")
	private static int anInt132;

	@OriginalMember(owner = "mapview!mapview", name = "Wb", descriptor = "I")
	private static int anInt154;

	@OriginalMember(owner = "mapview!mapview", name = "Xb", descriptor = "I")
	private static int anInt155;

	@OriginalMember(owner = "mapview!mapview", name = "Nb", descriptor = "Z")
	private static boolean aBoolean16 = true;

	@OriginalMember(owner = "mapview!mapview", name = "N", descriptor = "I")
	private int anInt128;

	@OriginalMember(owner = "mapview!mapview", name = "S", descriptor = "[I")
	private int[] anIntArray21;

	@OriginalMember(owner = "mapview!mapview", name = "T", descriptor = "[I")
	private int[] anIntArray22;

	@OriginalMember(owner = "mapview!mapview", name = "U", descriptor = "[[I")
	private int[][] anIntArrayArray1;

	@OriginalMember(owner = "mapview!mapview", name = "V", descriptor = "[[I")
	private int[][] anIntArrayArray2;

	@OriginalMember(owner = "mapview!mapview", name = "W", descriptor = "[[B")
	private byte[][] aByteArrayArray2;

	@OriginalMember(owner = "mapview!mapview", name = "X", descriptor = "[[B")
	private byte[][] aByteArrayArray3;

	@OriginalMember(owner = "mapview!mapview", name = "Y", descriptor = "[[B")
	private byte[][] aByteArrayArray4;

	@OriginalMember(owner = "mapview!mapview", name = "Z", descriptor = "[[B")
	private byte[][] aByteArrayArray5;

	@OriginalMember(owner = "mapview!mapview", name = "cb", descriptor = "Lmapview!i;")
	private PixFontFull aClass1_Sub1_Sub1_Sub4_1;

	@OriginalMember(owner = "mapview!mapview", name = "db", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_1;

	@OriginalMember(owner = "mapview!mapview", name = "eb", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_2;

	@OriginalMember(owner = "mapview!mapview", name = "fb", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_3;

	@OriginalMember(owner = "mapview!mapview", name = "gb", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_4;

	@OriginalMember(owner = "mapview!mapview", name = "hb", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_5;

	@OriginalMember(owner = "mapview!mapview", name = "ib", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_6;

	@OriginalMember(owner = "mapview!mapview", name = "jb", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_7;

	@OriginalMember(owner = "mapview!mapview", name = "kb", descriptor = "Lmapview!f;")
	private WorldmapFont aClass1_Sub1_Sub1_Sub1_8;

	@OriginalMember(owner = "mapview!mapview", name = "ob", descriptor = "I")
	private int anInt133;

	@OriginalMember(owner = "mapview!mapview", name = "wb", descriptor = "I")
	private int anInt138;

	@OriginalMember(owner = "mapview!mapview", name = "xb", descriptor = "I")
	private int anInt139;

	@OriginalMember(owner = "mapview!mapview", name = "Cb", descriptor = "I")
	private int anInt143;

	@OriginalMember(owner = "mapview!mapview", name = "Db", descriptor = "I")
	private int anInt144;

	@OriginalMember(owner = "mapview!mapview", name = "Eb", descriptor = "I")
	private int anInt145;

	@OriginalMember(owner = "mapview!mapview", name = "Fb", descriptor = "I")
	private int anInt146;

	@OriginalMember(owner = "mapview!mapview", name = "Gb", descriptor = "I")
	private int anInt147;

	@OriginalMember(owner = "mapview!mapview", name = "Ib", descriptor = "Lmapview!g;")
	private Pix24 aClass1_Sub1_Sub1_Sub2_1;

	@OriginalMember(owner = "mapview!mapview", name = "Jb", descriptor = "I")
	private int anInt148;

	@OriginalMember(owner = "mapview!mapview", name = "Kb", descriptor = "I")
	private int anInt149;

	@OriginalMember(owner = "mapview!mapview", name = "Lb", descriptor = "I")
	private int anInt150;

	@OriginalMember(owner = "mapview!mapview", name = "Mb", descriptor = "I")
	private int anInt151;

	@OriginalMember(owner = "mapview!mapview", name = "Ob", descriptor = "I")
	private int anInt152;

	@OriginalMember(owner = "mapview!mapview", name = "G", descriptor = "I")
	private int anInt122 = 8943445;

	@OriginalMember(owner = "mapview!mapview", name = "H", descriptor = "I")
	private int anInt123 = 7824964;

	@OriginalMember(owner = "mapview!mapview", name = "I", descriptor = "I")
	private int anInt124 = 6706483;

	@OriginalMember(owner = "mapview!mapview", name = "J", descriptor = "I")
	private int anInt125 = 11141120;

	@OriginalMember(owner = "mapview!mapview", name = "K", descriptor = "I")
	private int anInt126 = 10027008;

	@OriginalMember(owner = "mapview!mapview", name = "L", descriptor = "I")
	private int anInt127 = 8912896;

	@OriginalMember(owner = "mapview!mapview", name = "M", descriptor = "Z")
	private boolean aBoolean13 = true;

	@OriginalMember(owner = "mapview!mapview", name = "ab", descriptor = "[Lmapview!h;")
	private Pix8[] aClass1_Sub1_Sub1_Sub3Array1 = new Pix8[100];

	@OriginalMember(owner = "mapview!mapview", name = "bb", descriptor = "[Lmapview!g;")
	private Pix24[] aClass1_Sub1_Sub1_Sub2Array3 = new Pix24[100];

	@OriginalMember(owner = "mapview!mapview", name = "lb", descriptor = "[I")
	private int[] anIntArray23 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "mb", descriptor = "[I")
	private int[] anIntArray24 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "nb", descriptor = "[I")
	private int[] anIntArray25 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "pb", descriptor = "[I")
	private int[] anIntArray26 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "qb", descriptor = "[I")
	private int[] anIntArray27 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "rb", descriptor = "[I")
	private int[] anIntArray28 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "sb", descriptor = "I")
	private int anInt134 = 5;

	@OriginalMember(owner = "mapview!mapview", name = "tb", descriptor = "I")
	private int anInt135 = 13;

	@OriginalMember(owner = "mapview!mapview", name = "ub", descriptor = "I")
	private int anInt136 = 140;

	@OriginalMember(owner = "mapview!mapview", name = "vb", descriptor = "I")
	private int anInt137 = 470;

	@OriginalMember(owner = "mapview!mapview", name = "yb", descriptor = "Z")
	private boolean aBoolean14 = false;

	@OriginalMember(owner = "mapview!mapview", name = "zb", descriptor = "I")
	private int anInt140 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "Ab", descriptor = "I")
	private int anInt141 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "Bb", descriptor = "I")
	private int anInt142 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "Hb", descriptor = "Z")
	private boolean aBoolean15 = false;

	@OriginalMember(owner = "mapview!mapview", name = "Pb", descriptor = "I")
	private int anInt153 = 1000;

	@OriginalMember(owner = "mapview!mapview", name = "Qb", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray1 = new String[this.anInt153];

	@OriginalMember(owner = "mapview!mapview", name = "Rb", descriptor = "[I")
	private int[] anIntArray29 = new int[this.anInt153];

	@OriginalMember(owner = "mapview!mapview", name = "Sb", descriptor = "[I")
	private int[] anIntArray30 = new int[this.anInt153];

	@OriginalMember(owner = "mapview!mapview", name = "Tb", descriptor = "[I")
	private int[] anIntArray31 = new int[this.anInt153];

	@OriginalMember(owner = "mapview!mapview", name = "Ub", descriptor = "D")
	private double aDouble1 = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Vb", descriptor = "D")
	private double aDouble2 = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Yb", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray2 = new String[] { "General Store", "Sword Shop", "Magic Shop", "Axe Shop", "Helmet Shop", "Bank", "Quest Start", "Amulet Shop", "Mining Site", "Furnace", "Anvil", "Combat Training", "Dungeon", "Staff Shop", "Platebody Shop", "Platelegs Shop", "Scimitar Shop", "Archery Shop", "Shield Shop", "Altar", "Herbalist", "Jewelery", "Gem Shop", "Crafting Shop", "Candle Shop", "Fishing Shop", "Fishing Spot", "Clothes Shop", "Apothecary", "Silk Trader", "Kebab Seller", "Pub/Bar", "Mace Shop", "Tannery", "Rare Trees", "Spinning Wheel", "Food Shop", "Cookery Shop", "Mini-Game", "Water Source", "Cooking Range", "Skirt Shop", "Potters Wheel", "Windmill", "Mining Shop", "Chainmail Shop", "Silver Shop", "Fur Trader", "Spice Shop", "Agility Training", "Vegetable Store", "Slayer Master", "Hair Dressers", "???", "Makeover Mage" };

	@OriginalMember(owner = "mapview!mapview", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] arg0) {
		@Pc(3) mapview local3 = new mapview();
		local3.initApplication(635, 503);
	}

	@OriginalMember(owner = "mapview!mapview", name = "<init>", descriptor = "()V")
	private mapview() {
	}

	@OriginalMember(owner = "mapview!mapview", name = "init", descriptor = "()V")
	@Override
	public void init() {
		this.initApplet(635, 503);
	}

	@OriginalMember(owner = "mapview!mapview", name = "c", descriptor = "()V")
	@Override
	protected void load() {
		@Pc(4) Jagfile local4 = this.method117();
		this.drawProgress("Please wait... Rendering Map", 100);
		@Pc(16) Packet local16 = new Packet(local4.read("size.dat", null));
		anInt129 = local16.g2();
		anInt130 = local16.g2();
		anInt131 = local16.g2();
		anInt132 = local16.g2();
		anInt154 = 3200 - anInt129;
		anInt155 = anInt130 + anInt132 - 3200;
		this.anInt144 = 180;
		this.anInt145 = anInt131 * this.anInt144 / anInt132;
		this.anInt146 = 635 - this.anInt145 - 5;
		this.anInt147 = 503 - this.anInt144 - 20;
		@Pc(73) Packet local73 = new Packet(local4.read("labels.dat", null));
		this.anInt152 = local73.g2();
		for (@Pc(79) int local79 = 0; local79 < this.anInt152; local79++) {
			this.aStringArray1[local79] = local73.gjstr();
			this.anIntArray29[local79] = local73.g2();
			this.anIntArray30[local79] = local73.g2();
			this.anIntArray31[local79] = local73.g1();
		}
		local16 = new Packet(local4.read("floorcol.dat", null));
		@Pc(121) int local121 = local16.g2();
		this.anIntArray21 = new int[local121 + 1];
		this.anIntArray22 = new int[local121 + 1];
		for (@Pc(135) int local135 = 0; local135 < local121; local135++) {
			this.anIntArray21[local135 + 1] = local16.g4();
			this.anIntArray22[local135 + 1] = local16.g4();
		}
		@Pc(162) byte[] local162 = local4.read("underlay.dat", null);
		@Pc(166) byte[][] local166 = new byte[anInt131][anInt132];
		this.method110(local162, local166);
		@Pc(175) byte[] local175 = local4.read("overlay.dat", null);
		this.anIntArrayArray2 = new int[anInt131][anInt132];
		this.aByteArrayArray2 = new byte[anInt131][anInt132];
		this.method111(local175, this.anIntArrayArray2, this.aByteArrayArray2);
		@Pc(197) byte[] local197 = local4.read("loc.dat", null);
		this.aByteArrayArray3 = new byte[anInt131][anInt132];
		this.aByteArrayArray5 = new byte[anInt131][anInt132];
		this.aByteArrayArray4 = new byte[anInt131][anInt132];
		this.method109(local197, this.aByteArrayArray3, this.aByteArrayArray5, this.aByteArrayArray4);
		@Pc(223) int local223;
		try {
			for (local223 = 0; local223 < 100; local223++) {
				this.aClass1_Sub1_Sub1_Sub3Array1[local223] = new Pix8(local4, "mapscene", local223);
			}
		} catch (@Pc(241) Exception local241) {
		}
		try {
			for (local223 = 0; local223 < 100; local223++) {
				this.aClass1_Sub1_Sub1_Sub2Array3[local223] = new Pix24(local4, "mapfunction", local223);
			}
		} catch (@Pc(261) Exception local261) {
		}
		this.aClass1_Sub1_Sub1_Sub4_1 = new PixFontFull(local4, "b12_full", false);
		this.aClass1_Sub1_Sub1_Sub1_1 = new WorldmapFont(11, true, this);
		this.aClass1_Sub1_Sub1_Sub1_2 = new WorldmapFont(12, true, this);
		this.aClass1_Sub1_Sub1_Sub1_3 = new WorldmapFont(14, true, this);
		this.aClass1_Sub1_Sub1_Sub1_4 = new WorldmapFont(17, true, this);
		this.aClass1_Sub1_Sub1_Sub1_5 = new WorldmapFont(19, true, this);
		this.aClass1_Sub1_Sub1_Sub1_6 = new WorldmapFont(22, true, this);
		this.aClass1_Sub1_Sub1_Sub1_7 = new WorldmapFont(26, true, this);
		this.aClass1_Sub1_Sub1_Sub1_8 = new WorldmapFont(30, true, this);
		this.anIntArrayArray1 = new int[anInt131][anInt132];
		this.method112(local166, this.anIntArrayArray1);
		this.aClass1_Sub1_Sub1_Sub2_1 = new Pix24(this.anInt145, this.anInt144);
		this.aClass1_Sub1_Sub1_Sub2_1.bind();
		this.method115(0, 0, anInt131, anInt132, 0, 0, this.anInt145, this.anInt144);
		Draw2D.drawRect(0, 0, 0, this.anInt145, this.anInt144);
		Draw2D.drawRect(1, 1, this.anInt122, this.anInt145 - 2, this.anInt144 - 2);
		super.drawArea.bind();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B[[B[[B)V")
	private void method109(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1, @OriginalArg(2) byte[][] arg2, @OriginalArg(3) byte[][] arg3) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - anInt129;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - anInt130;
				@Pc(43) int local43;
				if (local16 > 0 && local27 > 0 && local16 + 64 < anInt131 && local27 + 64 < anInt132) {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(51) byte[] local51 = arg1[local43 + local16];
						@Pc(57) byte[] local57 = arg2[local43 + local16];
						@Pc(63) byte[] local63 = arg3[local43 + local16];
						@Pc(69) int local69 = anInt132 - local27 - 1;
						for (@Pc(71) int local71 = -64; local71 < 0; local71++) {
							while (true) {
								@Pc(80) int local80 = arg0[local3++] & 0xFF;
								if (local80 == 0) {
									local69--;
									break;
								}
								if (local80 < 29) {
									local51[local69] = (byte) local80;
								} else if (local80 < 160) {
									local57[local69] = (byte) (local80 - 28);
								} else {
									local63[local69] = (byte) (local80 - 159);
									this.anIntArray26[this.anInt133] = local43 + local16;
									this.anIntArray27[this.anInt133] = local69;
									this.anIntArray28[this.anInt133] = local80 - 160;
									this.anInt133++;
								}
							}
						}
					}
				} else {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(164) byte local164;
						for (@Pc(157) int local157 = -64; local157 < 0; local157++) {
							do {
								local164 = arg0[local3++];
							} while (local164 != 0);
						}
					}
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B)V")
	private void method110(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - anInt129;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - anInt130;
				if (local16 > 0 && local27 > 0 && local16 + 64 < anInt131 && local27 + 64 < anInt132) {
					for (@Pc(43) int local43 = 0; local43 < 64; local43++) {
						@Pc(51) byte[] local51 = arg1[local43 + local16];
						@Pc(57) int local57 = anInt132 - local27 - 1;
						for (@Pc(59) int local59 = -64; local59 < 0; local59++) {
							local51[local57--] = arg0[local3++];
						}
					}
				} else {
					local3 += 4096;
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[I[[B)V")
	private void method111(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[][] arg1, @OriginalArg(2) byte[][] arg2) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - anInt129;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - anInt130;
				@Pc(72) byte local72;
				@Pc(43) int local43;
				if (local16 > 0 && local27 > 0 && local16 + 64 < anInt131 && local27 + 64 < anInt132) {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(51) int[] local51 = arg1[local43 + local16];
						@Pc(57) byte[] local57 = arg2[local43 + local16];
						@Pc(63) int local63 = anInt132 - local27 - 1;
						for (@Pc(65) int local65 = -64; local65 < 0; local65++) {
							local72 = arg0[local3++];
							if (local72 == 0) {
								local51[local63--] = 0;
							} else {
								local57[local63] = arg0[local3++];
								local51[local63--] = this.anIntArray22[local72];
							}
						}
					}
				} else {
					for (local43 = -4096; local43 < 0; local43++) {
						local72 = arg0[local3++];
						if (local72 != 0) {
							local3++;
						}
					}
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([[B[[I)V")
	private void method112(@OriginalArg(0) byte[][] arg0, @OriginalArg(1) int[][] arg1) {
		@Pc(3) int local3 = anInt131;
		@Pc(5) int local5 = anInt132;
		@Pc(8) int[] local8 = new int[local5];
		for (@Pc(10) int local10 = 0; local10 < local5; local10++) {
			local8[local10] = 0;
		}
		for (@Pc(22) int local22 = 5; local22 < local3 - 5; local22++) {
			@Pc(30) byte[] local30 = arg0[local22 + 5];
			@Pc(36) byte[] local36 = arg0[local22 - 5];
			for (@Pc(38) int local38 = 0; local38 < local5; local38++) {
				local8[local38] += this.anIntArray21[local30[local38] & 0xFF] - this.anIntArray21[local36[local38] & 0xFF];
			}
			if (local22 > 10 && local22 < local3 - 10) {
				@Pc(77) int local77 = 0;
				@Pc(79) int local79 = 0;
				@Pc(81) int local81 = 0;
				@Pc(85) int[] local85 = arg1[local22];
				for (@Pc(87) int local87 = 5; local87 < local5 - 5; local87++) {
					@Pc(95) int local95 = local8[local87 - 5];
					@Pc(101) int local101 = local8[local87 + 5];
					local77 += (local101 >> 20) - (local95 >> 20);
					local79 += (local101 >> 10 & 0x3FF) - (local95 >> 10 & 0x3FF);
					local81 += (local101 & 0x3FF) - (local95 & 0x3FF);
					if (local81 > 0) {
						local85[local87] = this.method113((double) local77 / 8533.0D, (double) local79 / 8533.0D, (double) local81 / 8533.0D);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(DDD)I")
	private int method113(@OriginalArg(0) double arg0, @OriginalArg(1) double arg1, @OriginalArg(2) double arg2) {
		@Pc(3) double local3 = arg2;
		@Pc(5) double local5 = arg2;
		@Pc(7) double local7 = arg2;
		if (arg1 != 0.0D) {
			@Pc(21) double local21;
			if (arg2 < 0.5D) {
				local21 = arg2 * (arg1 + 1.0D);
			} else {
				local21 = arg2 + arg1 - arg2 * arg1;
			}
			@Pc(37) double local37 = arg2 * 2.0D - local21;
			@Pc(41) double local41 = arg0 + 0.3333333333333333D;
			if (local41 > 1.0D) {
				local41--;
			}
			@Pc(55) double local55 = arg0 - 0.3333333333333333D;
			if (local55 < 0.0D) {
				local55++;
			}
			if (local41 * 6.0D < 1.0D) {
				local3 = local37 + (local21 - local37) * 6.0D * local41;
			} else if (local41 * 2.0D < 1.0D) {
				local3 = local21;
			} else if (local41 * 3.0D < 2.0D) {
				local3 = local37 + (local21 - local37) * (0.6666666666666666D - local41) * 6.0D;
			} else {
				local3 = local37;
			}
			if (arg0 * 6.0D < 1.0D) {
				local5 = local37 + (local21 - local37) * 6.0D * arg0;
			} else if (arg0 * 2.0D < 1.0D) {
				local5 = local21;
			} else if (arg0 * 3.0D < 2.0D) {
				local5 = local37 + (local21 - local37) * (0.6666666666666666D - arg0) * 6.0D;
			} else {
				local5 = local37;
			}
			if (local55 * 6.0D < 1.0D) {
				local7 = local37 + (local21 - local37) * 6.0D * local55;
			} else if (local55 * 2.0D < 1.0D) {
				local7 = local21;
			} else if (local55 * 3.0D < 2.0D) {
				local7 = local37 + (local21 - local37) * (0.6666666666666666D - local55) * 6.0D;
			} else {
				local7 = local37;
			}
		}
		@Pc(218) int local218 = (int) (local3 * 256.0D);
		@Pc(223) int local223 = (int) (local5 * 256.0D);
		@Pc(228) int local228 = (int) (local7 * 256.0D);
		return (local218 << 16) + (local223 << 8) + local228;
	}

	@OriginalMember(owner = "mapview!mapview", name = "g", descriptor = "()V")
	@Override
	protected void unload() {
		try {
			this.anIntArray21 = null;
			this.anIntArray22 = null;
			this.anIntArrayArray1 = null;
			this.anIntArrayArray2 = null;
			this.aByteArrayArray2 = null;
			this.aByteArrayArray3 = null;
			this.aByteArrayArray4 = null;
			this.aByteArrayArray5 = null;
			this.aClass1_Sub1_Sub1_Sub3Array1 = null;
			this.aClass1_Sub1_Sub1_Sub2Array3 = null;
			this.aClass1_Sub1_Sub1_Sub4_1 = null;
			this.anIntArray23 = null;
			this.anIntArray24 = null;
			this.anIntArray25 = null;
			this.anIntArray26 = null;
			this.anIntArray27 = null;
			this.anIntArray28 = null;
			this.aClass1_Sub1_Sub1_Sub2_1 = null;
			this.aStringArray1 = null;
			this.anIntArray29 = null;
			this.anIntArray30 = null;
			this.anIntArray31 = null;
			this.aStringArray2 = null;
			System.gc();
		} catch (@Pc(71) Throwable local71) {
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "h", descriptor = "()V")
	@Override
	protected void update() {
		if (super.actionKey[1] == 1) {
			anInt154 = (int) ((double) anInt154 - 16.0D / this.aDouble1);
			this.aBoolean13 = true;
		}
		if (super.actionKey[2] == 1) {
			anInt154 = (int) ((double) anInt154 + 16.0D / this.aDouble1);
			this.aBoolean13 = true;
		}
		if (super.actionKey[3] == 1) {
			anInt155 = (int) ((double) anInt155 - 16.0D / this.aDouble1);
			this.aBoolean13 = true;
		}
		if (super.actionKey[4] == 1) {
			anInt155 = (int) ((double) anInt155 + 16.0D / this.aDouble1);
			this.aBoolean13 = true;
		}
		@Pc(75) int local75 = 1;
		while (true) {
			@Pc(192) int local192;
			@Pc(199) int local199;
			do {
				do {
					if (local75 <= 0) {
						if (super.mouseClickButton == 1) {
							this.anInt148 = super.mouseClickX;
							this.anInt149 = super.mouseClickY;
							this.anInt150 = anInt154;
							this.anInt151 = anInt155;
							if (super.mouseClickX > 170 && super.mouseClickX < 220 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.aDouble2 = 3.0D;
								this.anInt148 = -1;
							}
							if (super.mouseClickX > 230 && super.mouseClickX < 280 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.aDouble2 = 4.0D;
								this.anInt148 = -1;
							}
							if (super.mouseClickX > 290 && super.mouseClickX < 340 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.aDouble2 = 6.0D;
								this.anInt148 = -1;
							}
							if (super.mouseClickX > 350 && super.mouseClickX < 400 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.aDouble2 = 8.0D;
								this.anInt148 = -1;
							}
							if (super.mouseClickX > this.anInt134 && super.mouseClickY > this.anInt135 + this.anInt137 && super.mouseClickX < this.anInt134 + this.anInt136 && super.mouseClickY < 503) {
								this.aBoolean14 = !this.aBoolean14;
								this.anInt148 = -1;
							}
							if (super.mouseClickX > this.anInt146 && super.mouseClickY > this.anInt147 + this.anInt144 && super.mouseClickX < this.anInt146 + this.anInt145 && super.mouseClickY < 503) {
								this.aBoolean15 = !this.aBoolean15;
								this.anInt148 = -1;
							}
							if (this.aBoolean14) {
								if (super.mouseClickX > this.anInt134 && super.mouseClickY > this.anInt135 && super.mouseClickX < this.anInt134 + this.anInt136 && super.mouseClickY < this.anInt135 + this.anInt137) {
									this.anInt148 = -1;
								}
								if (super.mouseClickX > this.anInt134 && super.mouseClickY > this.anInt135 && super.mouseClickX < this.anInt134 + this.anInt136 && super.mouseClickY < this.anInt135 + 18 && this.anInt139 > 0) {
									this.anInt139 -= 25;
								}
								if (super.mouseClickX > this.anInt134 && super.mouseClickY > this.anInt135 + this.anInt137 - 18 && super.mouseClickX < this.anInt134 + this.anInt136 && super.mouseClickY < this.anInt135 + this.anInt137 && this.anInt139 < 50) {
									this.anInt139 += 25;
								}
							}
							this.aBoolean13 = true;
						}
						@Pc(603) int local603;
						if (this.aBoolean14) {
							this.anInt140 = -1;
							if (super.mouseX > this.anInt134 && super.mouseX < this.anInt134 + this.anInt136) {
								local603 = this.anInt135 + 21 + 5;
								for (local192 = 0; local192 < 25; local192++) {
									if (local192 + this.anInt138 >= this.aStringArray2.length || !this.aStringArray2[local192 + this.anInt138].equals("???")) {
										if (super.mouseY >= local603 && super.mouseY < local603 + 17) {
											this.anInt140 = local192 + this.anInt138;
											if (super.mouseClickButton == 1) {
												this.anInt142 = local192 + this.anInt138;
												this.anInt143 = 50;
											}
										}
										local603 += 17;
									}
								}
							}
							if (this.anInt140 != this.anInt141) {
								this.anInt141 = this.anInt140;
								this.aBoolean13 = true;
							}
						}
						if ((super.mouseButton == 1 || super.mouseClickButton == 1) && this.aBoolean15) {
							local603 = super.mouseClickX;
							local192 = super.mouseClickY;
							if (super.mouseButton == 1) {
								local603 = super.mouseX;
								local192 = super.mouseY;
							}
							if (local603 > this.anInt146 && local192 > this.anInt147 && local603 < this.anInt146 + this.anInt145 && local192 < this.anInt147 + this.anInt144) {
								anInt154 = (local603 - this.anInt146) * anInt131 / this.anInt145;
								anInt155 = (local192 - this.anInt147) * anInt132 / this.anInt144;
								this.anInt148 = -1;
								this.aBoolean13 = true;
							}
						}
						if (super.mouseButton == 1 && this.anInt148 != -1) {
							anInt154 = this.anInt150 + (int) ((double) (this.anInt148 - super.mouseX) * 2.0D / this.aDouble2);
							anInt155 = this.anInt151 + (int) ((double) (this.anInt149 - super.mouseY) * 2.0D / this.aDouble2);
							this.aBoolean13 = true;
						}
						if (this.aDouble1 < this.aDouble2) {
							this.aBoolean13 = true;
							this.aDouble1 += this.aDouble1 / 30.0D;
							if (this.aDouble1 > this.aDouble2) {
								this.aDouble1 = this.aDouble2;
							}
						}
						if (this.aDouble1 > this.aDouble2) {
							this.aBoolean13 = true;
							this.aDouble1 -= this.aDouble1 / 30.0D;
							if (this.aDouble1 < this.aDouble2) {
								this.aDouble1 = this.aDouble2;
							}
						}
						if (this.anInt138 < this.anInt139) {
							this.aBoolean13 = true;
							this.anInt138++;
						}
						if (this.anInt138 > this.anInt139) {
							this.aBoolean13 = true;
							this.anInt138--;
						}
						if (this.anInt143 > 0) {
							this.aBoolean13 = true;
							this.anInt143--;
						}
						local603 = anInt154 - (int) (635.0D / this.aDouble1);
						local192 = anInt155 - (int) (503.0D / this.aDouble1);
						@Pc(909) int local909 = anInt154 + (int) (635.0D / this.aDouble1);
						local199 = anInt155 + (int) (503.0D / this.aDouble1);
						if (local603 < 48) {
							anInt154 = (int) (635.0D / this.aDouble1) + 48;
						}
						if (local192 < 48) {
							anInt155 = (int) (503.0D / this.aDouble1) + 48;
						}
						if (local909 > anInt131 - 48) {
							anInt154 = anInt131 - 48 - (int) (635.0D / this.aDouble1);
						}
						if (local199 > anInt132 - 48) {
							anInt155 = anInt132 - 48 - (int) (503.0D / this.aDouble1);
						}
						return;
					}
					local75 = this.pollKey();
					if (local75 == 49) {
						this.aDouble2 = 3.0D;
						this.aBoolean13 = true;
					}
					if (local75 == 50) {
						this.aDouble2 = 4.0D;
						this.aBoolean13 = true;
					}
					if (local75 == 51) {
						this.aDouble2 = 6.0D;
						this.aBoolean13 = true;
					}
					if (local75 == 52) {
						this.aDouble2 = 8.0D;
						this.aBoolean13 = true;
					}
					if (local75 == 107 || local75 == 75) {
						this.aBoolean14 = !this.aBoolean14;
						this.aBoolean13 = true;
					}
					if (local75 == 111 || local75 == 79) {
						this.aBoolean15 = !this.aBoolean15;
						this.aBoolean13 = true;
					}
				} while (super.frame == null);
			} while (local75 != 101);
			System.out.println("Starting export...");
			@Pc(169) Pix24 local169 = new Pix24(anInt131 * 2, anInt132 * 2);
			local169.bind();
			this.method115(0, 0, anInt131, anInt132, 0, 0, anInt131 * 2, anInt132 * 2);
			super.drawArea.bind();
			local192 = local169.pixels.length;
			@Pc(197) byte[] local197 = new byte[local192 * 3];
			local199 = 0;
			for (@Pc(201) int local201 = 0; local201 < local192; local201++) {
				@Pc(208) int local208 = local169.pixels[local201];
				local197[local199++] = (byte) (local208 >> 16);
				local197[local199++] = (byte) (local208 >> 8);
				local197[local199++] = (byte) local208;
			}
			System.out.println("Saving to disk");
			try {
				@Pc(261) BufferedOutputStream local261 = new BufferedOutputStream(new FileOutputStream("map-" + anInt131 * 2 + "-" + anInt132 * 2 + "-rgb.raw"));
				local261.write(local197);
				local261.close();
			} catch (@Pc(268) Exception local268) {
				local268.printStackTrace();
			}
			System.out.println("Done export: " + anInt131 * 2 + "," + anInt132 * 2);
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "e", descriptor = "()V")
	@Override
	protected void draw() {
		if (this.aBoolean13) {
			this.aBoolean13 = false;
			this.anInt128 = 0;
			Draw2D.clear();
			@Pc(19) int local19 = anInt154 - (int) (635.0D / this.aDouble1);
			@Pc(27) int local27 = anInt155 - (int) (503.0D / this.aDouble1);
			@Pc(35) int local35 = anInt154 + (int) (635.0D / this.aDouble1);
			@Pc(43) int local43 = anInt155 + (int) (503.0D / this.aDouble1);
			this.method115(local19, local27, local35, local43, 0, 0, 635, 503);
			@Pc(147) int local147;
			@Pc(169) int local169;
			@Pc(182) int local182;
			if (this.aBoolean15) {
				this.aClass1_Sub1_Sub1_Sub2_1.blitOpaque(this.anInt146, this.anInt147);
				Draw2D.fillRectAlpha(this.anInt146 + this.anInt145 * local19 / anInt131, this.anInt147 + this.anInt144 * local27 / anInt132, (local35 - local19) * this.anInt145 / anInt131, (local43 - local27) * this.anInt144 / anInt132, 16711680, 128);
				Draw2D.drawRect(this.anInt146 + this.anInt145 * local19 / anInt131, this.anInt147 + this.anInt144 * local27 / anInt132, 16711680, (local35 - local19) * this.anInt145 / anInt131, (local43 - local27) * this.anInt144 / anInt132);
				if (this.anInt143 > 0 && this.anInt143 % 10 < 5) {
					for (local147 = 0; local147 < this.anInt133; local147++) {
						if (this.anIntArray28[local147] == this.anInt142) {
							local169 = this.anInt146 + this.anInt145 * this.anIntArray26[local147] / anInt131;
							local182 = this.anInt147 + this.anInt144 * this.anIntArray27[local147] / anInt132;
							Draw2D.fillCircle(local169, local182, 2, 16776960, 256);
						}
					}
				}
			}
			if (this.aBoolean14) {
				this.method114(this.anInt134, this.anInt135, this.anInt136, 18, 10066329, 7829367, 5592405, "Prev page");
				this.method114(this.anInt134, this.anInt135 + 18, this.anInt136, this.anInt137 - 36, 10066329, 7829367, 5592405, "");
				this.method114(this.anInt134, this.anInt135 + this.anInt137 - 18, this.anInt136, 18, 10066329, 7829367, 5592405, "Next page");
				local147 = this.anInt135 + 3 + 18;
				for (local169 = 0; local169 < 25; local169++) {
					if (local169 + this.anInt138 < this.aClass1_Sub1_Sub1_Sub2Array3.length && local169 + this.anInt138 < this.aStringArray2.length) {
						if (this.aStringArray2[local169 + this.anInt138].equals("???")) {
							continue;
						}
						this.aClass1_Sub1_Sub1_Sub2Array3[local169 + this.anInt138].draw(this.anInt134 + 3, local147);
						this.aClass1_Sub1_Sub1_Sub4_1.drawString(this.anInt134 + 21, local147 + 14, this.aStringArray2[local169 + this.anInt138], 0);
						local182 = 16777215;
						if (this.anInt140 == local169 + this.anInt138) {
							local182 = 12298922;
						}
						if (this.anInt143 > 0 && this.anInt143 % 10 < 5 && this.anInt142 == local169 + this.anInt138) {
							local182 = 16776960;
						}
						this.aClass1_Sub1_Sub1_Sub4_1.drawString(this.anInt134 + 20, local147 + 13, this.aStringArray2[local169 + this.anInt138], local182);
					}
					local147 += 17;
				}
			}
			this.method114(this.anInt146, this.anInt147 + this.anInt144, this.anInt145, 18, this.anInt122, this.anInt123, this.anInt124, "Overview");
			this.method114(this.anInt134, this.anInt135 + this.anInt137, this.anInt136, 18, this.anInt122, this.anInt123, this.anInt124, "Key");
			if (this.aDouble2 == 3.0D) {
				this.method114(170, 471, 50, 30, this.anInt125, this.anInt126, this.anInt127, "37%");
			} else {
				this.method114(170, 471, 50, 30, this.anInt122, this.anInt123, this.anInt124, "37%");
			}
			if (this.aDouble2 == 4.0D) {
				this.method114(230, 471, 50, 30, this.anInt125, this.anInt126, this.anInt127, "50%");
			} else {
				this.method114(230, 471, 50, 30, this.anInt122, this.anInt123, this.anInt124, "50%");
			}
			if (this.aDouble2 == 6.0D) {
				this.method114(290, 471, 50, 30, this.anInt125, this.anInt126, this.anInt127, "75%");
			} else {
				this.method114(290, 471, 50, 30, this.anInt122, this.anInt123, this.anInt124, "75%");
			}
			if (this.aDouble2 == 8.0D) {
				this.method114(350, 471, 50, 30, this.anInt125, this.anInt126, this.anInt127, "100%");
			} else {
				this.method114(350, 471, 50, 30, this.anInt122, this.anInt123, this.anInt124, "100%");
			}
		}
		this.anInt128--;
		if (this.anInt128 <= 0) {
			super.drawArea.draw(super.graphics, 0, 0);
			this.anInt128 = 50;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "()V")
	@Override
	protected void refresh() {
		this.anInt128 = 0;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIILjava/lang/String;)V")
	private void method114(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) String arg7) {
		Draw2D.drawRect(arg0, arg1, 0, arg2, arg3);
		@Pc(6) int local6 = arg0 + 1;
		@Pc(7) int local7 = arg1 + 1;
		@Pc(8) int local8 = arg2 - 2;
		@Pc(9) int local9 = arg3 - 2;
		Draw2D.fillRect(local6, local7, arg5, local8, local9);
		Draw2D.drawHorizontalLine(local6, local7, arg4, local8);
		Draw2D.drawVerticalLine(local6, local7, arg4, local9);
		Draw2D.drawHorizontalLine(local6, local7 + local9 - 1, arg6, local8);
		Draw2D.drawVerticalLine(local6 + local8 - 1, local7, arg6, local9);
		this.aClass1_Sub1_Sub1_Sub4_1.drawStringCenter(local6 + local8 / 2 + 1, local7 + local9 / 2 + 1 + 4, arg7, 0);
		this.aClass1_Sub1_Sub1_Sub4_1.drawStringCenter(local6 + local8 / 2, local7 + local9 / 2 + 4, arg7, 16777215);
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIII)V")
	private void method115(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(5) int local5 = arg2 - arg0;
		@Pc(9) int local9 = arg3 - arg1;
		@Pc(17) int local17 = (arg6 - arg4 << 16) / local5;
		@Pc(25) int local25 = (arg7 - arg5 << 16) / local9;
		@Pc(35) int local35;
		@Pc(43) int local43;
		@Pc(47) int local47;
		@Pc(78) byte[] local78;
		@Pc(80) int local80;
		@Pc(88) int local88;
		@Pc(96) int local96;
		@Pc(100) int local100;
		@Pc(116) int local116;
		@Pc(144) int local144;
		for (@Pc(27) int local27 = 0; local27 < local5; local27++) {
			local35 = local17 * local27 >> 16;
			local43 = local17 * (local27 + 1) >> 16;
			local47 = local43 - local35;
			if (local47 > 0) {
				local35 += arg4;
				local43 += arg4;
				@Pc(64) int[] local64 = this.anIntArrayArray1[local27 + arg0];
				@Pc(71) int[] local71 = this.anIntArrayArray2[local27 + arg0];
				local78 = this.aByteArrayArray2[local27 + arg0];
				for (local80 = 0; local80 < local9; local80++) {
					local88 = local25 * local80 >> 16;
					local96 = local25 * (local80 + 1) >> 16;
					local100 = local96 - local88;
					if (local100 > 0) {
						local88 += arg5;
						local96 += arg5;
						local116 = local71[local80 + arg1];
						if (local116 == 0) {
							Draw2D.fillRect(local35, local88, local64[local80 + arg1], local43 - local35, local96 - local88);
						} else {
							@Pc(140) byte local140 = local78[local80 + arg1];
							local144 = local140 & 0xFC;
							if (local144 == 0 || local47 <= 1 || local100 <= 1) {
								Draw2D.fillRect(local35, local88, local116, local47, local100);
							} else {
								this.method116(Draw2D.data, local88 * Draw2D.width2d + local35, local64[local80 + arg1], local116, local47, local100, local144 >> 2, local140 & 0x3);
							}
						}
					}
				}
			}
		}
		if (arg2 - arg0 > arg6 - arg4) {
			return;
		}
		local35 = 0;
		@Pc(284) int local284;
		@Pc(295) int local295;
		@Pc(218) int local218;
		@Pc(222) int local222;
		for (local43 = 0; local43 < local5; local43++) {
			local47 = local17 * local43 >> 16;
			local218 = local17 * (local43 + 1) >> 16;
			local222 = local218 - local47;
			if (local222 > 0) {
				local78 = this.aByteArrayArray3[local43 + arg0];
				@Pc(238) byte[] local238 = this.aByteArrayArray5[local43 + arg0];
				@Pc(245) byte[] local245 = this.aByteArrayArray4[local43 + arg0];
				for (local96 = 0; local96 < local9; local96++) {
					local100 = local25 * local96 >> 16;
					local116 = local25 * (local96 + 1) >> 16;
					@Pc(267) int local267 = local116 - local100;
					if (local267 > 0) {
						local144 = local78[local96 + arg1] & 0xFF;
						if (local144 != 0) {
							if (local222 == 1) {
								local284 = local47;
							} else {
								local284 = local218 - 1;
							}
							if (local267 == 1) {
								local295 = local100;
							} else {
								local295 = local116 - 1;
							}
							@Pc(303) int local303 = 13421772;
							if (local144 >= 5 && local144 <= 8 || local144 >= 13 && local144 <= 16 || local144 >= 21 && local144 <= 24 || local144 == 27 || local144 == 28) {
								local303 = 13369344;
								local144 -= 4;
							}
							if (local144 == 1) {
								Draw2D.drawVerticalLine(local47, local100, local303, local267);
							} else if (local144 == 2) {
								Draw2D.drawHorizontalLine(local47, local100, local303, local222);
							} else if (local144 == 3) {
								Draw2D.drawVerticalLine(local284, local100, local303, local267);
							} else if (local144 == 4) {
								Draw2D.drawHorizontalLine(local47, local295, local303, local222);
							} else if (local144 == 9) {
								Draw2D.drawVerticalLine(local47, local100, 16777215, local267);
								Draw2D.drawHorizontalLine(local47, local100, local303, local222);
							} else if (local144 == 10) {
								Draw2D.drawVerticalLine(local284, local100, 16777215, local267);
								Draw2D.drawHorizontalLine(local47, local100, local303, local222);
							} else if (local144 == 11) {
								Draw2D.drawVerticalLine(local284, local100, 16777215, local267);
								Draw2D.drawHorizontalLine(local47, local295, local303, local222);
							} else if (local144 == 12) {
								Draw2D.drawVerticalLine(local47, local100, 16777215, local267);
								Draw2D.drawHorizontalLine(local47, local295, local303, local222);
							} else if (local144 == 17) {
								Draw2D.drawHorizontalLine(local47, local100, local303, 1);
							} else if (local144 == 18) {
								Draw2D.drawHorizontalLine(local284, local100, local303, 1);
							} else if (local144 == 19) {
								Draw2D.drawHorizontalLine(local284, local295, local303, 1);
							} else if (local144 == 20) {
								Draw2D.drawHorizontalLine(local47, local295, local303, 1);
							} else {
								@Pc(475) int local475;
								if (local144 == 25) {
									for (local475 = 0; local475 < local267; local475++) {
										Draw2D.drawHorizontalLine(local47 + local475, local295 - local475, local303, 1);
									}
								} else if (local144 == 26) {
									for (local475 = 0; local475 < local267; local475++) {
										Draw2D.drawHorizontalLine(local47 + local475, local100 + local475, local303, 1);
									}
								}
							}
						}
						local284 = local238[local96 + arg1] & 0xFF;
						if (local284 != 0) {
							this.aClass1_Sub1_Sub1_Sub3Array1[local284 - 1].clip(local47 - local222 / 2, local100 - local267 / 2, local222 * 2, local267 * 2);
						}
						local295 = local245[local96 + arg1] & 0xFF;
						if (local295 != 0) {
							this.anIntArray25[local35] = local295 - 1;
							this.anIntArray23[local35] = local47 + local222 / 2;
							this.anIntArray24[local35] = local100 + local267 / 2;
							local35++;
						}
					}
				}
			}
		}
		for (local47 = 0; local47 < local35; local47++) {
			this.aClass1_Sub1_Sub1_Sub2Array3[this.anIntArray25[local47]].draw(this.anIntArray23[local47] - 7, this.anIntArray24[local47] - 7);
		}
		if (this.anInt143 > 0) {
			for (local218 = 0; local218 < local35; local218++) {
				if (this.anIntArray25[local218] == this.anInt142) {
					this.aClass1_Sub1_Sub1_Sub2Array3[this.anIntArray25[local218]].draw(this.anIntArray23[local218] - 7, this.anIntArray24[local218] - 7);
					if (this.anInt143 % 10 < 5) {
						Draw2D.fillCircle(this.anIntArray23[local218], this.anIntArray24[local218], 15, 16776960, 128);
						Draw2D.fillCircle(this.anIntArray23[local218], this.anIntArray24[local218], 7, 16777215, 256);
					}
				}
			}
		}
		@Pc(706) int local706;
		if (this.aDouble1 == this.aDouble2 && aBoolean16) {
			for (local218 = 0; local218 < this.anInt152; local218++) {
				local222 = this.anIntArray29[local218];
				local706 = this.anIntArray30[local218];
				local222 -= anInt129;
				@Pc(716) int local716 = anInt130 + anInt132 - local706;
				local80 = arg4 + (arg6 - arg4) * (local222 - arg0) / (arg2 - arg0);
				local88 = arg5 + (arg7 - arg5) * (local716 - arg1) / (arg3 - arg1);
				local96 = this.anIntArray31[local218];
				local100 = 16777215;
				@Pc(753) WorldmapFont local753 = null;
				if (local96 == 0) {
					if (this.aDouble1 == 3.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_1;
					}
					if (this.aDouble1 == 4.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_2;
					}
					if (this.aDouble1 == 6.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_3;
					}
					if (this.aDouble1 == 8.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_4;
					}
				}
				if (local96 == 1) {
					if (this.aDouble1 == 3.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_3;
					}
					if (this.aDouble1 == 4.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_4;
					}
					if (this.aDouble1 == 6.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_5;
					}
					if (this.aDouble1 == 8.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_6;
					}
				}
				if (local96 == 2) {
					local100 = 16755200;
					if (this.aDouble1 == 3.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_5;
					}
					if (this.aDouble1 == 4.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_6;
					}
					if (this.aDouble1 == 6.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_7;
					}
					if (this.aDouble1 == 8.0D) {
						local753 = this.aClass1_Sub1_Sub1_Sub1_8;
					}
				}
				if (local753 != null) {
					@Pc(866) String local866 = this.aStringArray1[local218];
					local144 = 1;
					for (local284 = 0; local284 < local866.length(); local284++) {
						if (local866.charAt(local284) == '/') {
							local144++;
						}
					}
					local88 -= local753.method35() * (local144 - 1) / 2;
					local88 += local753.method39() / 2;
					while (true) {
						local295 = local866.indexOf("/");
						if (local295 == -1) {
							local753.method33(local866, local80, local88, local100, true);
							break;
						}
						@Pc(922) String local922 = local866.substring(0, local295);
						local753.method33(local922, local80, local88, local100, true);
						local88 += local753.method35();
						local866 = local866.substring(local295 + 1);
					}
				}
			}
		}
		if (!aBoolean12) {
			return;
		}
		for (local218 = anInt129 / 64; local218 < (anInt129 + anInt131) / 64; local218++) {
			for (local222 = anInt130 / 64; local222 < (anInt130 + anInt132) / 64; local222++) {
				local706 = local218 * 64;
				local80 = local222 * 64;
				local706 -= anInt129;
				local80 = anInt130 + anInt132 - local80;
				local88 = arg4 + (arg6 - arg4) * (local706 - arg0) / (arg2 - arg0);
				local96 = arg5 + (arg7 - arg5) * (local80 - 64 - arg1) / (arg3 - arg1);
				local100 = arg4 + (arg6 - arg4) * (local706 + 64 - arg0) / (arg2 - arg0);
				local116 = arg5 + (arg7 - arg5) * (local80 - arg1) / (arg3 - arg1);
				Draw2D.drawRect(local88, local96, 16777215, local100 - local88, local116 - local96);
				this.aClass1_Sub1_Sub1_Sub4_1.drawStringRight(local100 - 5, local116 - 5, local218 + "_" + local222, 16777215);
				if (local218 == 33 && local222 >= 71 && local222 <= 73) {
					this.aClass1_Sub1_Sub1_Sub4_1.drawStringCenter((local100 + local88) / 2, (local116 + local96) / 2, "u_pass", 16711680);
				} else if (local218 >= 32 && local218 <= 34 && local222 >= 70 && local222 <= 74) {
					this.aClass1_Sub1_Sub1_Sub4_1.drawStringCenter((local100 + local88) / 2, (local116 + local96) / 2, "u_pass", 16776960);
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([IIIIIIII)V")
	private void method116(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(5) int local5 = Draw2D.width2d - arg4;
		if (arg6 == 9) {
			arg6 = 1;
			arg7 = arg7 + 1 & 0x3;
		}
		if (arg6 == 10) {
			arg6 = 1;
			arg7 = arg7 + 3 & 0x3;
		}
		if (arg6 == 11) {
			arg6 = 8;
			arg7 = arg7 + 3 & 0x3;
		}
		@Pc(45) int local45;
		@Pc(49) int local49;
		if (arg6 == 1) {
			if (arg7 == 0) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 == 2) {
			if (arg7 == 0) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 == 3) {
			if (arg7 == 0) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 == 4) {
			if (arg7 == 0) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 >= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 <= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 != 5) {
			if (arg6 == 6) {
				if (arg7 == 0) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 <= arg4 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 1) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local45 <= arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 2) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 >= arg4 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 3) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local45 >= arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
			}
			if (arg6 == 7) {
				if (arg7 == 0) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 1) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 2) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 3) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
			}
			if (arg6 == 8) {
				if (arg7 == 0) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 1) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 2) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 3) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
			}
		} else if (arg7 == 0) {
			for (local45 = arg5 - 1; local45 >= 0; local45--) {
				for (local49 = arg4 - 1; local49 >= 0; local49--) {
					if (local49 >= local45 >> 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		} else if (arg7 == 1) {
			for (local45 = arg5 - 1; local45 >= 0; local45--) {
				for (local49 = 0; local49 < arg4; local49++) {
					if (local49 <= local45 << 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		} else if (arg7 == 2) {
			for (local45 = 0; local45 < arg5; local45++) {
				for (local49 = 0; local49 < arg4; local49++) {
					if (local49 >= local45 >> 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		} else if (arg7 == 3) {
			for (local45 = 0; local45 < arg5; local45++) {
				for (local49 = arg4 - 1; local49 >= 0; local49--) {
					if (local49 <= local45 << 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "i", descriptor = "()Lmapview!o;")
	private Jagfile method117() {
		@Pc(1) Object local1 = null;
		@Pc(3) String local3 = null;
		@Pc(17) byte[] local17;
		try {
			local3 = this.method119();
			local17 = this.method120(local3 + "/worldmap.dat");
			if (!this.method122(local17)) {
				local17 = null;
			}
			if (local17 != null) {
				return new Jagfile(local17);
			}
		} catch (@Pc(31) Throwable local31) {
		}
		local17 = this.method118();
		if (local3 != null && local17 != null) {
			try {
				this.method121(local3 + "/worldmap.dat", local17);
			} catch (@Pc(51) Throwable local51) {
			}
		}
		return new Jagfile(local17);
	}

	@OriginalMember(owner = "mapview!mapview", name = "j", descriptor = "()[B")
	private byte[] method118() {
		System.out.println("Updating");
		this.drawProgress("Requesting map", 0);
		try {
			@Pc(10) String local10 = "";
			for (@Pc(12) int local12 = 0; local12 < 10; local12++) {
				local10 = local10 + sig.anIntArray42[local12];
			}
			@Pc(40) DataInputStream local40;
			if (super.frame == null) {
				local40 = new DataInputStream((new URL(this.getCodeBase(), "worldmap" + local10 + ".jag")).openStream());
			} else {
				local40 = new DataInputStream(new FileInputStream("worldmap.jag"));
			}
			@Pc(63) int local63 = 0;
			@Pc(65) int local65 = 0;
			@Pc(67) int local67 = 300691;
			@Pc(70) byte[] local70 = new byte[local67];
			while (local65 < local67) {
				@Pc(76) int local76 = local67 - local65;
				if (local76 > 1000) {
					local76 = 1000;
				}
				@Pc(87) int local87 = local40.read(local70, local65, local76);
				if (local87 < 0) {
					throw new IOException("EOF");
				}
				local65 += local87;
				@Pc(104) int local104 = local65 * 100 / local67;
				if (local104 != local63) {
					this.drawProgress("Loading map - " + local104 + "%", local104);
				}
				local63 = local104;
			}
			local40.close();
			return local70;
		} catch (@Pc(129) IOException local129) {
			System.out.println("Error loading");
			local129.printStackTrace();
			return null;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "k", descriptor = "()Ljava/lang/String;")
	private String method119() {
		@Pc(50) String[] local50 = new String[] { "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", "/tmp/", "" };
		@Pc(52) String local52 = ".file_store_32";
		for (@Pc(54) int local54 = 0; local54 < local50.length; local54++) {
			try {
				@Pc(60) String local60 = local50[local54];
				@Pc(68) File local68;
				if (local60.length() > 0) {
					local68 = new File(local60);
					if (!local68.exists()) {
						continue;
					}
				}
				local68 = new File(local60 + local52);
				if (local68.exists() || local68.mkdir()) {
					return local60 + local52 + "/";
				}
			} catch (@Pc(103) Exception local103) {
			}
		}
		return null;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(Ljava/lang/String;)[B")
	private byte[] method120(@OriginalArg(0) String arg0) throws IOException {
		@Pc(4) File local4 = new File(arg0);
		if (!local4.exists()) {
			return null;
		}
		@Pc(13) int local13 = (int) local4.length();
		@Pc(16) byte[] local16 = new byte[local13];
		@Pc(27) DataInputStream local27 = new DataInputStream(new BufferedInputStream(new FileInputStream(arg0)));
		local27.readFully(local16, 0, local13);
		local27.close();
		return local16;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(Ljava/lang/String;[B)V")
	private void method121(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) throws IOException {
		@Pc(4) FileOutputStream local4 = new FileOutputStream(arg0);
		local4.write(arg1, 0, arg1.length);
		local4.close();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B)Z")
	private boolean method122(@OriginalArg(0) byte[] arg0) throws Exception {
		if (arg0 == null) {
			return false;
		}
		@Pc(6) MessageDigest local6 = MessageDigest.getInstance("SHA");
		local6.reset();
		local6.update(arg0);
		@Pc(14) byte[] local14 = local6.digest();
		for (@Pc(16) int local16 = 0; local16 < 20; local16++) {
			if (local14[local16] != sig.anIntArray42[local16]) {
				return false;
			}
		}
		return true;
	}
}
