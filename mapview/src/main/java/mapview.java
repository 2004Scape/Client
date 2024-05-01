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
	private static boolean shouldDrawBorders = false;

	@OriginalMember(owner = "mapview!mapview", name = "O", descriptor = "I")
	private static int centerX;

	@OriginalMember(owner = "mapview!mapview", name = "P", descriptor = "I")
	private static int centerY;

	@OriginalMember(owner = "mapview!mapview", name = "Q", descriptor = "I")
	private static int originX;

	@OriginalMember(owner = "mapview!mapview", name = "R", descriptor = "I")
	private static int originY;

	@OriginalMember(owner = "mapview!mapview", name = "Wb", descriptor = "I")
	private static int offsetX;

	@OriginalMember(owner = "mapview!mapview", name = "Xb", descriptor = "I")
	private static int offsetY;

	@OriginalMember(owner = "mapview!mapview", name = "Nb", descriptor = "Z")
	private static boolean shouldDrawLabels = true;

	@OriginalMember(owner = "mapview!mapview", name = "N", descriptor = "I")
	private int drawTimer;

	@OriginalMember(owner = "mapview!mapview", name = "S", descriptor = "[I")
	private int[] floormapsUnderlay;

	@OriginalMember(owner = "mapview!mapview", name = "T", descriptor = "[I")
	private int[] floormapsOverlay;

	@OriginalMember(owner = "mapview!mapview", name = "U", descriptor = "[[I")
	private int[][] floormapColors;

	@OriginalMember(owner = "mapview!mapview", name = "V", descriptor = "[[I")
	private int[][] overlayColors;

	@OriginalMember(owner = "mapview!mapview", name = "W", descriptor = "[[B")
	private byte[][] overlayTypes;

	@OriginalMember(owner = "mapview!mapview", name = "X", descriptor = "[[B")
	private byte[][] locWalls;

	@OriginalMember(owner = "mapview!mapview", name = "Y", descriptor = "[[B")
	private byte[][] locIcons;

	@OriginalMember(owner = "mapview!mapview", name = "Z", descriptor = "[[B")
	private byte[][] locScenes;

	@OriginalMember(owner = "mapview!mapview", name = "cb", descriptor = "Lmapview!i;")
	private PixFontFull b12;

	@OriginalMember(owner = "mapview!mapview", name = "db", descriptor = "Lmapview!f;")
	private WorldmapFont f11;

	@OriginalMember(owner = "mapview!mapview", name = "eb", descriptor = "Lmapview!f;")
	private WorldmapFont f12;

	@OriginalMember(owner = "mapview!mapview", name = "fb", descriptor = "Lmapview!f;")
	private WorldmapFont f14;

	@OriginalMember(owner = "mapview!mapview", name = "gb", descriptor = "Lmapview!f;")
	private WorldmapFont f17;

	@OriginalMember(owner = "mapview!mapview", name = "hb", descriptor = "Lmapview!f;")
	private WorldmapFont f19;

	@OriginalMember(owner = "mapview!mapview", name = "ib", descriptor = "Lmapview!f;")
	private WorldmapFont f22;

	@OriginalMember(owner = "mapview!mapview", name = "jb", descriptor = "Lmapview!f;")
	private WorldmapFont f26;

	@OriginalMember(owner = "mapview!mapview", name = "kb", descriptor = "Lmapview!f;")
	private WorldmapFont f30;

	@OriginalMember(owner = "mapview!mapview", name = "ob", descriptor = "I")
	private int mapIconCount;

	@OriginalMember(owner = "mapview!mapview", name = "wb", descriptor = "I")
	private int lastKeyPage;

	@OriginalMember(owner = "mapview!mapview", name = "xb", descriptor = "I")
	private int keyPage;

	@OriginalMember(owner = "mapview!mapview", name = "Cb", descriptor = "I")
	private int flashTimer;

	@OriginalMember(owner = "mapview!mapview", name = "Db", descriptor = "I")
	private int imageOverviewHeight;

	@OriginalMember(owner = "mapview!mapview", name = "Eb", descriptor = "I")
	private int imageOverviewWidth;

	@OriginalMember(owner = "mapview!mapview", name = "Fb", descriptor = "I")
	private int overviewX;

	@OriginalMember(owner = "mapview!mapview", name = "Gb", descriptor = "I")
	private int overviewY;

	@OriginalMember(owner = "mapview!mapview", name = "Ib", descriptor = "Lmapview!g;")
	private Pix24 imageOverview;

	@OriginalMember(owner = "mapview!mapview", name = "Jb", descriptor = "I")
	private int lastMouseClickX;

	@OriginalMember(owner = "mapview!mapview", name = "Kb", descriptor = "I")
	private int lastMouseClickY;

	@OriginalMember(owner = "mapview!mapview", name = "Lb", descriptor = "I")
	private int lastOffsetX;

	@OriginalMember(owner = "mapview!mapview", name = "Mb", descriptor = "I")
	private int lastOffsetY;

	@OriginalMember(owner = "mapview!mapview", name = "Ob", descriptor = "I")
	private int labelCount;

	@OriginalMember(owner = "mapview!mapview", name = "G", descriptor = "I")
	private int oclorInactiveBorderTL = 0x887755;

	@OriginalMember(owner = "mapview!mapview", name = "H", descriptor = "I")
	private int colorInactive = 0x776644;

	@OriginalMember(owner = "mapview!mapview", name = "I", descriptor = "I")
	private int colorInactiveBorderBR = 0x665533;

	@OriginalMember(owner = "mapview!mapview", name = "J", descriptor = "I")
	private int colorActiveBorderTL = 0xaa0000;

	@OriginalMember(owner = "mapview!mapview", name = "K", descriptor = "I")
	private int colorActive = 0x990000;

	@OriginalMember(owner = "mapview!mapview", name = "L", descriptor = "I")
	private int colorActiveBorderBR = 0x880000;

	@OriginalMember(owner = "mapview!mapview", name = "M", descriptor = "Z")
	private boolean shouldDraw = true;

	@OriginalMember(owner = "mapview!mapview", name = "ab", descriptor = "[Lmapview!h;")
	private Pix8[] mapScenes = new Pix8[100];

	@OriginalMember(owner = "mapview!mapview", name = "bb", descriptor = "[Lmapview!g;")
	private Pix24[] mapFunctions = new Pix24[100];

	@OriginalMember(owner = "mapview!mapview", name = "lb", descriptor = "[I")
	private int[] visibleMapIconsX = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "mb", descriptor = "[I")
	private int[] visibleMapIconsY = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "nb", descriptor = "[I")
	private int[] visibleMapIcons = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "pb", descriptor = "[I")
	private int[] mapIconsX = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "qb", descriptor = "[I")
	private int[] mapIconsY = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "rb", descriptor = "[I")
	private int[] mapIcons = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "sb", descriptor = "I")
	private int keyX = 5;

	@OriginalMember(owner = "mapview!mapview", name = "tb", descriptor = "I")
	private int keyY = 13;

	@OriginalMember(owner = "mapview!mapview", name = "ub", descriptor = "I")
	private int keyWidth = 140;

	@OriginalMember(owner = "mapview!mapview", name = "vb", descriptor = "I")
	private int keyOffset = 470;

	@OriginalMember(owner = "mapview!mapview", name = "yb", descriptor = "Z")
	private boolean showKey = false;

	@OriginalMember(owner = "mapview!mapview", name = "zb", descriptor = "I")
	private int currentKeyHover = -1;

	@OriginalMember(owner = "mapview!mapview", name = "Ab", descriptor = "I")
	private int lastKeyHover = -1;

	@OriginalMember(owner = "mapview!mapview", name = "Bb", descriptor = "I")
	private int currentKey = -1;

	@OriginalMember(owner = "mapview!mapview", name = "Hb", descriptor = "Z")
	private boolean showOverview = false;

	@OriginalMember(owner = "mapview!mapview", name = "Pb", descriptor = "I")
	private int maxLabels = 1000;

	@OriginalMember(owner = "mapview!mapview", name = "Qb", descriptor = "[Ljava/lang/String;")
	private String[] labelText = new String[this.maxLabels];

	@OriginalMember(owner = "mapview!mapview", name = "Rb", descriptor = "[I")
	private int[] labelX = new int[this.maxLabels];

	@OriginalMember(owner = "mapview!mapview", name = "Sb", descriptor = "[I")
	private int[] labelY = new int[this.maxLabels];

	@OriginalMember(owner = "mapview!mapview", name = "Tb", descriptor = "[I")
	private int[] labelType = new int[this.maxLabels];

	@OriginalMember(owner = "mapview!mapview", name = "Ub", descriptor = "D")
	private double zoomX = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Vb", descriptor = "D")
	private double zoomY = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Yb", descriptor = "[Ljava/lang/String;")
	private String[] keyNames = new String[] { "General Store", "Sword Shop", "Magic Shop", "Axe Shop", "Helmet Shop", "Bank", "Quest Start", "Amulet Shop", "Mining Site", "Furnace", "Anvil", "Combat Training", "Dungeon", "Staff Shop", "Platebody Shop", "Platelegs Shop", "Scimitar Shop", "Archery Shop", "Shield Shop", "Altar", "Herbalist", "Jewelery", "Gem Shop", "Crafting Shop", "Candle Shop", "Fishing Shop", "Fishing Spot", "Clothes Shop", "Apothecary", "Silk Trader", "Kebab Seller", "Pub/Bar", "Mace Shop", "Tannery", "Rare Trees", "Spinning Wheel", "Food Shop", "Cookery Shop", "Mini-Game", "Water Source", "Cooking Range", "Skirt Shop", "Potters Wheel", "Windmill", "Mining Shop", "Chainmail Shop", "Silver Shop", "Fur Trader", "Spice Shop", "Agility Training", "Vegetable Store", "Slayer Master", "Hair Dressers", "???", "Makeover Mage" };

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
		@Pc(4) Jagfile local4 = this.getWorldmap();
		this.drawProgress("Please wait... Rendering Map", 100);
		@Pc(16) Packet local16 = new Packet(local4.read("size.dat", null));
		centerX = local16.g2();
		centerY = local16.g2();
		originX = local16.g2();
		originY = local16.g2();
		offsetX = 3200 - centerX;
		offsetY = centerY + originY - 3200;
		this.imageOverviewHeight = 180;
		this.imageOverviewWidth = originX * this.imageOverviewHeight / originY;
		this.overviewX = 635 - this.imageOverviewWidth - 5;
		this.overviewY = 503 - this.imageOverviewHeight - 20;
		@Pc(73) Packet local73 = new Packet(local4.read("labels.dat", null));
		this.labelCount = local73.g2();
		for (@Pc(79) int local79 = 0; local79 < this.labelCount; local79++) {
			this.labelText[local79] = local73.gjstr();
			this.labelX[local79] = local73.g2();
			this.labelY[local79] = local73.g2();
			this.labelType[local79] = local73.g1();
		}
		local16 = new Packet(local4.read("floorcol.dat", null));
		@Pc(121) int local121 = local16.g2();
		this.floormapsUnderlay = new int[local121 + 1];
		this.floormapsOverlay = new int[local121 + 1];
		for (@Pc(135) int local135 = 0; local135 < local121; local135++) {
			this.floormapsUnderlay[local135 + 1] = local16.g4();
			this.floormapsOverlay[local135 + 1] = local16.g4();
		}
		@Pc(162) byte[] local162 = local4.read("underlay.dat", null);
		@Pc(166) byte[][] local166 = new byte[originX][originY];
		this.decodeUnderlay(local162, local166);
		@Pc(175) byte[] local175 = local4.read("overlay.dat", null);
		this.overlayColors = new int[originX][originY];
		this.overlayTypes = new byte[originX][originY];
		this.decodeOverlay(local175, this.overlayColors, this.overlayTypes);
		@Pc(197) byte[] local197 = local4.read("loc.dat", null);
		this.locWalls = new byte[originX][originY];
		this.locScenes = new byte[originX][originY];
		this.locIcons = new byte[originX][originY];
		this.decodeLoc(local197, this.locWalls, this.locScenes, this.locIcons);
		@Pc(223) int local223;
		try {
			for (local223 = 0; local223 < 100; local223++) {
				this.mapScenes[local223] = new Pix8(local4, "mapscene", local223);
			}
		} catch (@Pc(241) Exception local241) {
		}
		try {
			for (local223 = 0; local223 < 100; local223++) {
				this.mapFunctions[local223] = new Pix24(local4, "mapfunction", local223);
			}
		} catch (@Pc(261) Exception local261) {
		}
		this.b12 = new PixFontFull(local4, "b12_full", false);
		this.f11 = new WorldmapFont(11, true, this);
		this.f12 = new WorldmapFont(12, true, this);
		this.f14 = new WorldmapFont(14, true, this);
		this.f17 = new WorldmapFont(17, true, this);
		this.f19 = new WorldmapFont(19, true, this);
		this.f22 = new WorldmapFont(22, true, this);
		this.f26 = new WorldmapFont(26, true, this);
		this.f30 = new WorldmapFont(30, true, this);
		this.floormapColors = new int[originX][originY];
		this.averageUnderlayColors(local166, this.floormapColors);
		this.imageOverview = new Pix24(this.imageOverviewWidth, this.imageOverviewHeight);
		this.imageOverview.bind();
		this.drawMap(0, 0, originX, originY, 0, 0, this.imageOverviewWidth, this.imageOverviewHeight);
		Draw2D.drawRect(0, 0, 0, this.imageOverviewWidth, this.imageOverviewHeight);
		Draw2D.drawRect(1, 1, this.oclorInactiveBorderTL, this.imageOverviewWidth - 2, this.imageOverviewHeight - 2);
		super.drawArea.bind();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B[[B[[B)V")
	private void decodeLoc(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1, @OriginalArg(2) byte[][] arg2, @OriginalArg(3) byte[][] arg3) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - centerX;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - centerY;
				@Pc(43) int local43;
				if (local16 > 0 && local27 > 0 && local16 + 64 < originX && local27 + 64 < originY) {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(51) byte[] local51 = arg1[local43 + local16];
						@Pc(57) byte[] local57 = arg2[local43 + local16];
						@Pc(63) byte[] local63 = arg3[local43 + local16];
						@Pc(69) int local69 = originY - local27 - 1;
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
									this.mapIconsX[this.mapIconCount] = local43 + local16;
									this.mapIconsY[this.mapIconCount] = local69;
									this.mapIcons[this.mapIconCount] = local80 - 160;
									this.mapIconCount++;
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
	private void decodeUnderlay(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - centerX;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - centerY;
				if (local16 > 0 && local27 > 0 && local16 + 64 < originX && local27 + 64 < originY) {
					for (@Pc(43) int local43 = 0; local43 < 64; local43++) {
						@Pc(51) byte[] local51 = arg1[local43 + local16];
						@Pc(57) int local57 = originY - local27 - 1;
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
	private void decodeOverlay(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[][] arg1, @OriginalArg(2) byte[][] arg2) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - centerX;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - centerY;
				@Pc(72) byte local72;
				@Pc(43) int local43;
				if (local16 > 0 && local27 > 0 && local16 + 64 < originX && local27 + 64 < originY) {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(51) int[] local51 = arg1[local43 + local16];
						@Pc(57) byte[] local57 = arg2[local43 + local16];
						@Pc(63) int local63 = originY - local27 - 1;
						for (@Pc(65) int local65 = -64; local65 < 0; local65++) {
							local72 = arg0[local3++];
							if (local72 == 0) {
								local51[local63--] = 0;
							} else {
								local57[local63] = arg0[local3++];
								local51[local63--] = this.floormapsOverlay[local72];
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
	private void averageUnderlayColors(@OriginalArg(0) byte[][] arg0, @OriginalArg(1) int[][] arg1) {
		@Pc(3) int local3 = originX;
		@Pc(5) int local5 = originY;
		@Pc(8) int[] local8 = new int[local5];
		for (@Pc(10) int local10 = 0; local10 < local5; local10++) {
			local8[local10] = 0;
		}
		for (@Pc(22) int local22 = 5; local22 < local3 - 5; local22++) {
			@Pc(30) byte[] local30 = arg0[local22 + 5];
			@Pc(36) byte[] local36 = arg0[local22 - 5];
			for (@Pc(38) int local38 = 0; local38 < local5; local38++) {
				local8[local38] += this.floormapsUnderlay[local30[local38] & 0xFF] - this.floormapsUnderlay[local36[local38] & 0xFF];
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
						local85[local87] = this.convertHSL((double) local77 / 8533.0D, (double) local79 / 8533.0D, (double) local81 / 8533.0D);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(DDD)I")
	private int convertHSL(@OriginalArg(0) double arg0, @OriginalArg(1) double arg1, @OriginalArg(2) double arg2) {
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
			this.floormapsUnderlay = null;
			this.floormapsOverlay = null;
			this.floormapColors = null;
			this.overlayColors = null;
			this.overlayTypes = null;
			this.locWalls = null;
			this.locIcons = null;
			this.locScenes = null;
			this.mapScenes = null;
			this.mapFunctions = null;
			this.b12 = null;
			this.visibleMapIconsX = null;
			this.visibleMapIconsY = null;
			this.visibleMapIcons = null;
			this.mapIconsX = null;
			this.mapIconsY = null;
			this.mapIcons = null;
			this.imageOverview = null;
			this.labelText = null;
			this.labelX = null;
			this.labelY = null;
			this.labelType = null;
			this.keyNames = null;
			System.gc();
		} catch (@Pc(71) Throwable local71) {
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "h", descriptor = "()V")
	@Override
	protected void update() {
		if (super.actionKey[1] == 1) {
			offsetX = (int) ((double) offsetX - 16.0D / this.zoomX);
			this.shouldDraw = true;
		}
		if (super.actionKey[2] == 1) {
			offsetX = (int) ((double) offsetX + 16.0D / this.zoomX);
			this.shouldDraw = true;
		}
		if (super.actionKey[3] == 1) {
			offsetY = (int) ((double) offsetY - 16.0D / this.zoomX);
			this.shouldDraw = true;
		}
		if (super.actionKey[4] == 1) {
			offsetY = (int) ((double) offsetY + 16.0D / this.zoomX);
			this.shouldDraw = true;
		}
		@Pc(75) int local75 = 1;
		while (true) {
			@Pc(192) int local192;
			@Pc(199) int local199;
			do {
				do {
					if (local75 <= 0) {
						if (super.mouseClickButton == 1) {
							this.lastMouseClickX = super.mouseClickX;
							this.lastMouseClickY = super.mouseClickY;
							this.lastOffsetX = offsetX;
							this.lastOffsetY = offsetY;
							if (super.mouseClickX > 170 && super.mouseClickX < 220 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.zoomY = 3.0D;
								this.lastMouseClickX = -1;
							}
							if (super.mouseClickX > 230 && super.mouseClickX < 280 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.zoomY = 4.0D;
								this.lastMouseClickX = -1;
							}
							if (super.mouseClickX > 290 && super.mouseClickX < 340 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.zoomY = 6.0D;
								this.lastMouseClickX = -1;
							}
							if (super.mouseClickX > 350 && super.mouseClickX < 400 && super.mouseClickY > 471 && super.mouseClickY < 503) {
								this.zoomY = 8.0D;
								this.lastMouseClickX = -1;
							}
							if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY + this.keyOffset && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < 503) {
								this.showKey = !this.showKey;
								this.lastMouseClickX = -1;
							}
							if (super.mouseClickX > this.overviewX && super.mouseClickY > this.overviewY + this.imageOverviewHeight && super.mouseClickX < this.overviewX + this.imageOverviewWidth && super.mouseClickY < 503) {
								this.showOverview = !this.showOverview;
								this.lastMouseClickX = -1;
							}
							if (this.showKey) {
								if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + this.keyOffset) {
									this.lastMouseClickX = -1;
								}
								if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + 18 && this.keyPage > 0) {
									this.keyPage -= 25;
								}
								if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY + this.keyOffset - 18 && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + this.keyOffset && this.keyPage < 50) {
									this.keyPage += 25;
								}
							}
							this.shouldDraw = true;
						}
						@Pc(603) int local603;
						if (this.showKey) {
							this.currentKeyHover = -1;
							if (super.mouseX > this.keyX && super.mouseX < this.keyX + this.keyWidth) {
								local603 = this.keyY + 21 + 5;
								for (local192 = 0; local192 < 25; local192++) {
									if (local192 + this.lastKeyPage >= this.keyNames.length || !this.keyNames[local192 + this.lastKeyPage].equals("???")) {
										if (super.mouseY >= local603 && super.mouseY < local603 + 17) {
											this.currentKeyHover = local192 + this.lastKeyPage;
											if (super.mouseClickButton == 1) {
												this.currentKey = local192 + this.lastKeyPage;
												this.flashTimer = 50;
											}
										}
										local603 += 17;
									}
								}
							}
							if (this.currentKeyHover != this.lastKeyHover) {
								this.lastKeyHover = this.currentKeyHover;
								this.shouldDraw = true;
							}
						}
						if ((super.mouseButton == 1 || super.mouseClickButton == 1) && this.showOverview) {
							local603 = super.mouseClickX;
							local192 = super.mouseClickY;
							if (super.mouseButton == 1) {
								local603 = super.mouseX;
								local192 = super.mouseY;
							}
							if (local603 > this.overviewX && local192 > this.overviewY && local603 < this.overviewX + this.imageOverviewWidth && local192 < this.overviewY + this.imageOverviewHeight) {
								offsetX = (local603 - this.overviewX) * originX / this.imageOverviewWidth;
								offsetY = (local192 - this.overviewY) * originY / this.imageOverviewHeight;
								this.lastMouseClickX = -1;
								this.shouldDraw = true;
							}
						}
						if (super.mouseButton == 1 && this.lastMouseClickX != -1) {
							offsetX = this.lastOffsetX + (int) ((double) (this.lastMouseClickX - super.mouseX) * 2.0D / this.zoomY);
							offsetY = this.lastOffsetY + (int) ((double) (this.lastMouseClickY - super.mouseY) * 2.0D / this.zoomY);
							this.shouldDraw = true;
						}
						if (this.zoomX < this.zoomY) {
							this.shouldDraw = true;
							this.zoomX += this.zoomX / 30.0D;
							if (this.zoomX > this.zoomY) {
								this.zoomX = this.zoomY;
							}
						}
						if (this.zoomX > this.zoomY) {
							this.shouldDraw = true;
							this.zoomX -= this.zoomX / 30.0D;
							if (this.zoomX < this.zoomY) {
								this.zoomX = this.zoomY;
							}
						}
						if (this.lastKeyPage < this.keyPage) {
							this.shouldDraw = true;
							this.lastKeyPage++;
						}
						if (this.lastKeyPage > this.keyPage) {
							this.shouldDraw = true;
							this.lastKeyPage--;
						}
						if (this.flashTimer > 0) {
							this.shouldDraw = true;
							this.flashTimer--;
						}
						local603 = offsetX - (int) (635.0D / this.zoomX);
						local192 = offsetY - (int) (503.0D / this.zoomX);
						@Pc(909) int local909 = offsetX + (int) (635.0D / this.zoomX);
						local199 = offsetY + (int) (503.0D / this.zoomX);
						if (local603 < 48) {
							offsetX = (int) (635.0D / this.zoomX) + 48;
						}
						if (local192 < 48) {
							offsetY = (int) (503.0D / this.zoomX) + 48;
						}
						if (local909 > originX - 48) {
							offsetX = originX - 48 - (int) (635.0D / this.zoomX);
						}
						if (local199 > originY - 48) {
							offsetY = originY - 48 - (int) (503.0D / this.zoomX);
						}
						return;
					}
					local75 = this.pollKey();
					if (local75 == 49) {
						this.zoomY = 3.0D;
						this.shouldDraw = true;
					}
					if (local75 == 50) {
						this.zoomY = 4.0D;
						this.shouldDraw = true;
					}
					if (local75 == 51) {
						this.zoomY = 6.0D;
						this.shouldDraw = true;
					}
					if (local75 == 52) {
						this.zoomY = 8.0D;
						this.shouldDraw = true;
					}
					if (local75 == 107 || local75 == 75) {
						this.showKey = !this.showKey;
						this.shouldDraw = true;
					}
					if (local75 == 111 || local75 == 79) {
						this.showOverview = !this.showOverview;
						this.shouldDraw = true;
					}
				} while (super.frame == null);
			} while (local75 != 101);
			System.out.println("Starting export...");
			@Pc(169) Pix24 local169 = new Pix24(originX * 2, originY * 2);
			local169.bind();
			this.drawMap(0, 0, originX, originY, 0, 0, originX * 2, originY * 2);
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
				@Pc(261) BufferedOutputStream local261 = new BufferedOutputStream(new FileOutputStream("map-" + originX * 2 + "-" + originY * 2 + "-rgb.raw"));
				local261.write(local197);
				local261.close();
			} catch (@Pc(268) Exception local268) {
				local268.printStackTrace();
			}
			System.out.println("Done export: " + originX * 2 + "," + originY * 2);
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "e", descriptor = "()V")
	@Override
	protected void draw() {
		if (this.shouldDraw) {
			this.shouldDraw = false;
			this.drawTimer = 0;
			Draw2D.clear();
			@Pc(19) int local19 = offsetX - (int) (635.0D / this.zoomX);
			@Pc(27) int local27 = offsetY - (int) (503.0D / this.zoomX);
			@Pc(35) int local35 = offsetX + (int) (635.0D / this.zoomX);
			@Pc(43) int local43 = offsetY + (int) (503.0D / this.zoomX);
			this.drawMap(local19, local27, local35, local43, 0, 0, 635, 503);
			@Pc(147) int local147;
			@Pc(169) int local169;
			@Pc(182) int local182;
			if (this.showOverview) {
				this.imageOverview.blitOpaque(this.overviewX, this.overviewY);
				Draw2D.fillRectAlpha(this.overviewX + this.imageOverviewWidth * local19 / originX, this.overviewY + this.imageOverviewHeight * local27 / originY, (local35 - local19) * this.imageOverviewWidth / originX, (local43 - local27) * this.imageOverviewHeight / originY, 16711680, 128);
				Draw2D.drawRect(this.overviewX + this.imageOverviewWidth * local19 / originX, this.overviewY + this.imageOverviewHeight * local27 / originY, 16711680, (local35 - local19) * this.imageOverviewWidth / originX, (local43 - local27) * this.imageOverviewHeight / originY);
				if (this.flashTimer > 0 && this.flashTimer % 10 < 5) {
					for (local147 = 0; local147 < this.mapIconCount; local147++) {
						if (this.mapIcons[local147] == this.currentKey) {
							local169 = this.overviewX + this.imageOverviewWidth * this.mapIconsX[local147] / originX;
							local182 = this.overviewY + this.imageOverviewHeight * this.mapIconsY[local147] / originY;
							Draw2D.fillCircle(local169, local182, 2, 16776960, 256);
						}
					}
				}
			}
			if (this.showKey) {
				this.drawString(this.keyX, this.keyY, this.keyWidth, 18, 10066329, 7829367, 5592405, "Prev page");
				this.drawString(this.keyX, this.keyY + 18, this.keyWidth, this.keyOffset - 36, 10066329, 7829367, 5592405, "");
				this.drawString(this.keyX, this.keyY + this.keyOffset - 18, this.keyWidth, 18, 10066329, 7829367, 5592405, "Next page");
				local147 = this.keyY + 3 + 18;
				for (local169 = 0; local169 < 25; local169++) {
					if (local169 + this.lastKeyPage < this.mapFunctions.length && local169 + this.lastKeyPage < this.keyNames.length) {
						if (this.keyNames[local169 + this.lastKeyPage].equals("???")) {
							continue;
						}
						this.mapFunctions[local169 + this.lastKeyPage].draw(this.keyX + 3, local147);
						this.b12.drawString(this.keyX + 21, local147 + 14, this.keyNames[local169 + this.lastKeyPage], 0);
						local182 = 16777215;
						if (this.currentKeyHover == local169 + this.lastKeyPage) {
							local182 = 12298922;
						}
						if (this.flashTimer > 0 && this.flashTimer % 10 < 5 && this.currentKey == local169 + this.lastKeyPage) {
							local182 = 16776960;
						}
						this.b12.drawString(this.keyX + 20, local147 + 13, this.keyNames[local169 + this.lastKeyPage], local182);
					}
					local147 += 17;
				}
			}
			this.drawString(this.overviewX, this.overviewY + this.imageOverviewHeight, this.imageOverviewWidth, 18, this.oclorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "Overview");
			this.drawString(this.keyX, this.keyY + this.keyOffset, this.keyWidth, 18, this.oclorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "Key");
			if (this.zoomY == 3.0D) {
				this.drawString(170, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "37%");
			} else {
				this.drawString(170, 471, 50, 30, this.oclorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "37%");
			}
			if (this.zoomY == 4.0D) {
				this.drawString(230, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "50%");
			} else {
				this.drawString(230, 471, 50, 30, this.oclorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "50%");
			}
			if (this.zoomY == 6.0D) {
				this.drawString(290, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "75%");
			} else {
				this.drawString(290, 471, 50, 30, this.oclorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "75%");
			}
			if (this.zoomY == 8.0D) {
				this.drawString(350, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "100%");
			} else {
				this.drawString(350, 471, 50, 30, this.oclorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "100%");
			}
		}
		this.drawTimer--;
		if (this.drawTimer <= 0) {
			super.drawArea.draw(super.graphics, 0, 0);
			this.drawTimer = 50;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "()V")
	@Override
	protected void refresh() {
		this.drawTimer = 0;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIILjava/lang/String;)V")
	private void drawString(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) String arg7) {
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
		this.b12.drawStringCenter(local6 + local8 / 2 + 1, local7 + local9 / 2 + 1 + 4, arg7, 0);
		this.b12.drawStringCenter(local6 + local8 / 2, local7 + local9 / 2 + 4, arg7, 16777215);
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIII)V")
	private void drawMap(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
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
				@Pc(64) int[] local64 = this.floormapColors[local27 + arg0];
				@Pc(71) int[] local71 = this.overlayColors[local27 + arg0];
				local78 = this.overlayTypes[local27 + arg0];
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
								this.drawSmoothEdges(Draw2D.data, local88 * Draw2D.width2d + local35, local64[local80 + arg1], local116, local47, local100, local144 >> 2, local140 & 0x3);
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
				local78 = this.locWalls[local43 + arg0];
				@Pc(238) byte[] local238 = this.locScenes[local43 + arg0];
				@Pc(245) byte[] local245 = this.locIcons[local43 + arg0];
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
							this.mapScenes[local284 - 1].clip(local47 - local222 / 2, local100 - local267 / 2, local222 * 2, local267 * 2);
						}
						local295 = local245[local96 + arg1] & 0xFF;
						if (local295 != 0) {
							this.visibleMapIcons[local35] = local295 - 1;
							this.visibleMapIconsX[local35] = local47 + local222 / 2;
							this.visibleMapIconsY[local35] = local100 + local267 / 2;
							local35++;
						}
					}
				}
			}
		}
		for (local47 = 0; local47 < local35; local47++) {
			this.mapFunctions[this.visibleMapIcons[local47]].draw(this.visibleMapIconsX[local47] - 7, this.visibleMapIconsY[local47] - 7);
		}
		if (this.flashTimer > 0) {
			for (local218 = 0; local218 < local35; local218++) {
				if (this.visibleMapIcons[local218] == this.currentKey) {
					this.mapFunctions[this.visibleMapIcons[local218]].draw(this.visibleMapIconsX[local218] - 7, this.visibleMapIconsY[local218] - 7);
					if (this.flashTimer % 10 < 5) {
						Draw2D.fillCircle(this.visibleMapIconsX[local218], this.visibleMapIconsY[local218], 15, 16776960, 128);
						Draw2D.fillCircle(this.visibleMapIconsX[local218], this.visibleMapIconsY[local218], 7, 16777215, 256);
					}
				}
			}
		}
		@Pc(706) int local706;
		if (this.zoomX == this.zoomY && shouldDrawLabels) {
			for (local218 = 0; local218 < this.labelCount; local218++) {
				local222 = this.labelX[local218];
				local706 = this.labelY[local218];
				local222 -= centerX;
				@Pc(716) int local716 = centerY + originY - local706;
				local80 = arg4 + (arg6 - arg4) * (local222 - arg0) / (arg2 - arg0);
				local88 = arg5 + (arg7 - arg5) * (local716 - arg1) / (arg3 - arg1);
				local96 = this.labelType[local218];
				local100 = 16777215;
				@Pc(753) WorldmapFont local753 = null;
				if (local96 == 0) {
					if (this.zoomX == 3.0D) {
						local753 = this.f11;
					}
					if (this.zoomX == 4.0D) {
						local753 = this.f12;
					}
					if (this.zoomX == 6.0D) {
						local753 = this.f14;
					}
					if (this.zoomX == 8.0D) {
						local753 = this.f17;
					}
				}
				if (local96 == 1) {
					if (this.zoomX == 3.0D) {
						local753 = this.f14;
					}
					if (this.zoomX == 4.0D) {
						local753 = this.f17;
					}
					if (this.zoomX == 6.0D) {
						local753 = this.f19;
					}
					if (this.zoomX == 8.0D) {
						local753 = this.f22;
					}
				}
				if (local96 == 2) {
					local100 = 16755200;
					if (this.zoomX == 3.0D) {
						local753 = this.f19;
					}
					if (this.zoomX == 4.0D) {
						local753 = this.f22;
					}
					if (this.zoomX == 6.0D) {
						local753 = this.f26;
					}
					if (this.zoomX == 8.0D) {
						local753 = this.f30;
					}
				}
				if (local753 != null) {
					@Pc(866) String local866 = this.labelText[local218];
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
        if (shouldDrawBorders) {
            for (local218 = centerX / 64; local218 < (centerX + originX) / 64; local218++) {
                for (local222 = centerY / 64; local222 < (centerY + originY) / 64; local222++) {
                    local706 = local218 * 64;
                    local80 = local222 * 64;
                    local706 -= centerX;
                    local80 = centerY + originY - local80;
                    local88 = arg4 + (arg6 - arg4) * (local706 - arg0) / (arg2 - arg0);
                    local96 = arg5 + (arg7 - arg5) * (local80 - 64 - arg1) / (arg3 - arg1);
                    local100 = arg4 + (arg6 - arg4) * (local706 + 64 - arg0) / (arg2 - arg0);
                    local116 = arg5 + (arg7 - arg5) * (local80 - arg1) / (arg3 - arg1);
                    Draw2D.drawRect(local88, local96, 16777215, local100 - local88, local116 - local96);
                    this.b12.drawStringRight(local100 - 5, local116 - 5, local218 + "_" + local222, 16777215);
                    if (local218 == 33 && local222 >= 71 && local222 <= 73) {
                        this.b12.drawStringCenter((local100 + local88) / 2, (local116 + local96) / 2, "u_pass", 16711680);
                    } else if (local218 >= 32 && local218 <= 34 && local222 >= 70 && local222 <= 74) {
                        this.b12.drawStringCenter((local100 + local88) / 2, (local116 + local96) / 2, "u_pass", 16776960);
                    }
                }
            }
        }
    }

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([IIIIIIII)V")
	private void drawSmoothEdges(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
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
	private Jagfile getWorldmap() {
		@Pc(1) Object local1 = null;
		@Pc(3) String local3 = null;
		@Pc(17) byte[] local17;
		try {
			local3 = this.findcachedir();
			local17 = this.cacheload(local3 + "/worldmap.dat");
			if (!this.checksha(local17)) {
				local17 = null;
			}
			if (local17 != null) {
				return new Jagfile(local17);
			}
		} catch (@Pc(31) Throwable local31) {
		}
		local17 = this.getLatestWorldmap();
		if (local3 != null && local17 != null) {
			try {
				this.cachesave(local3 + "/worldmap.dat", local17);
			} catch (@Pc(51) Throwable local51) {
			}
		}
		return new Jagfile(local17);
	}

	@OriginalMember(owner = "mapview!mapview", name = "j", descriptor = "()[B")
	private byte[] getLatestWorldmap() {
		System.out.println("Updating");
		this.drawProgress("Requesting map", 0);
		try {
			@Pc(10) String local10 = "";
			for (@Pc(12) int local12 = 0; local12 < 10; local12++) {
				local10 = local10 + sig.sha[local12];
			}
			@Pc(40) DataInputStream local40;
			if (super.frame == null) {
				local40 = new DataInputStream((new URL(this.getCodeBase(), "worldmap" + local10 + ".jag")).openStream());
			} else {
				local40 = new DataInputStream(new FileInputStream("worldmap.jag"));
			}
			@Pc(63) int local63 = 0;
			@Pc(65) int local65 = 0;
			@Pc(67) int local67 = sig.len;
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
	private String findcachedir() {
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
	private byte[] cacheload(@OriginalArg(0) String arg0) throws IOException {
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
	private void cachesave(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) throws IOException {
		@Pc(4) FileOutputStream local4 = new FileOutputStream(arg0);
		local4.write(arg1, 0, arg1.length);
		local4.close();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B)Z")
	private boolean checksha(@OriginalArg(0) byte[] arg0) throws Exception {
		if (arg0 == null) {
			return false;
		}
		@Pc(6) MessageDigest local6 = MessageDigest.getInstance("SHA");
		local6.reset();
		local6.update(arg0);
		@Pc(14) byte[] local14 = local6.digest();
		for (@Pc(16) int local16 = 0; local16 < 20; local16++) {
			if (local14[local16] != sig.sha[local16]) {
				return false;
			}
		}
		return true;
	}
}
