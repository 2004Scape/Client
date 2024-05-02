import java.io.BufferedInputStream;
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
import jagex2.graphics.PixFont;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!mapview")
public final class mapview extends GameShell {

	@OriginalMember(owner = "mapview!mapview", name = "M", descriptor = "I")
	private int redrawTimer;

	@OriginalMember(owner = "mapview!mapview", name = "N", descriptor = "[I")
	private int[] floorcolUnderlay;

	@OriginalMember(owner = "mapview!mapview", name = "O", descriptor = "[I")
	private int[] floorcolOverlay;

	@OriginalMember(owner = "mapview!mapview", name = "P", descriptor = "[[I")
	private int[][] floormapColors;

	@OriginalMember(owner = "mapview!mapview", name = "Q", descriptor = "[[I")
	private int[][] overlayTiles;

	@OriginalMember(owner = "mapview!mapview", name = "R", descriptor = "[[B")
	private byte[][] overlayShapes;

	@OriginalMember(owner = "mapview!mapview", name = "S", descriptor = "[[B")
	private byte[][] locWalls;

	@OriginalMember(owner = "mapview!mapview", name = "T", descriptor = "[[B")
	private byte[][] locMapfunctions;

	@OriginalMember(owner = "mapview!mapview", name = "U", descriptor = "[[B")
	private byte[][] locMapscenes;

	@OriginalMember(owner = "mapview!mapview", name = "X", descriptor = "Lmapview!j;")
	private PixFont b12;

	@OriginalMember(owner = "mapview!mapview", name = "Y", descriptor = "Lmapview!g;")
	private WorldmapFont f11;

	@OriginalMember(owner = "mapview!mapview", name = "Z", descriptor = "Lmapview!g;")
	private WorldmapFont f12;

	@OriginalMember(owner = "mapview!mapview", name = "ab", descriptor = "Lmapview!g;")
	private WorldmapFont f14;

	@OriginalMember(owner = "mapview!mapview", name = "bb", descriptor = "Lmapview!g;")
	private WorldmapFont f17;

	@OriginalMember(owner = "mapview!mapview", name = "cb", descriptor = "Lmapview!g;")
	private WorldmapFont f19;

	@OriginalMember(owner = "mapview!mapview", name = "db", descriptor = "Lmapview!g;")
	private WorldmapFont f22;

	@OriginalMember(owner = "mapview!mapview", name = "eb", descriptor = "Lmapview!g;")
	private WorldmapFont f26;

	@OriginalMember(owner = "mapview!mapview", name = "fb", descriptor = "Lmapview!g;")
	private WorldmapFont f30;

	@OriginalMember(owner = "mapview!mapview", name = "jb", descriptor = "I")
	private int activeMapFunctionCount;

	@OriginalMember(owner = "mapview!mapview", name = "rb", descriptor = "I")
	private int lastKeyPage;

	@OriginalMember(owner = "mapview!mapview", name = "sb", descriptor = "I")
	private int keyPage;

	@OriginalMember(owner = "mapview!mapview", name = "xb", descriptor = "I")
	private int flashTimer;

	@OriginalMember(owner = "mapview!mapview", name = "Db", descriptor = "Lmapview!h;")
	private Pix24 imageOverview;

	@OriginalMember(owner = "mapview!mapview", name = "Eb", descriptor = "I")
	private int lastMouseClickX;

	@OriginalMember(owner = "mapview!mapview", name = "Fb", descriptor = "I")
	private int lastMouseClickY;

	@OriginalMember(owner = "mapview!mapview", name = "Gb", descriptor = "I")
	private int lastOffsetX;

	@OriginalMember(owner = "mapview!mapview", name = "Hb", descriptor = "I")
	private int lastOffsetY;

	@OriginalMember(owner = "mapview!mapview", name = "Ib", descriptor = "I")
	private int labelCount;

	@OriginalMember(owner = "mapview!mapview", name = "F", descriptor = "I")
	private int colorInactiveBorderTL = 8943445;

	@OriginalMember(owner = "mapview!mapview", name = "G", descriptor = "I")
	private int colorInactive = 7824964;

	@OriginalMember(owner = "mapview!mapview", name = "H", descriptor = "I")
	private int colorInactiveBorderBR = 6706483;

	@OriginalMember(owner = "mapview!mapview", name = "I", descriptor = "I")
	private int colorActiveBorderTL = 11141120;

	@OriginalMember(owner = "mapview!mapview", name = "J", descriptor = "I")
	private int colorActive = 10027008;

	@OriginalMember(owner = "mapview!mapview", name = "K", descriptor = "I")
	private int colorActiveBorderBR = 8912896;

	@OriginalMember(owner = "mapview!mapview", name = "L", descriptor = "Z")
	private boolean redraw = true;

	@OriginalMember(owner = "mapview!mapview", name = "V", descriptor = "[Lmapview!i;")
	private Pix8[] imageMapscene = new Pix8[50];

	@OriginalMember(owner = "mapview!mapview", name = "W", descriptor = "[Lmapview!h;")
	private Pix24[] imageMapfunction = new Pix24[50];

	@OriginalMember(owner = "mapview!mapview", name = "gb", descriptor = "[I")
	private int[] visibleMapFunctionsX = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "hb", descriptor = "[I")
	private int[] visibleMapFunctionsY = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "ib", descriptor = "[I")
	private int[] visibleMapFunctions = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "kb", descriptor = "[I")
	private int[] activeMapFunctionX = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "lb", descriptor = "[I")
	private int[] activeMapFunctionZ = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "mb", descriptor = "[I")
	private int[] activeMapFunctions = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "nb", descriptor = "I")
	private int keyX = 5;

	@OriginalMember(owner = "mapview!mapview", name = "ob", descriptor = "I")
	private int keyY = 13;

	@OriginalMember(owner = "mapview!mapview", name = "pb", descriptor = "I")
	private int keyWidth = 140;

	@OriginalMember(owner = "mapview!mapview", name = "qb", descriptor = "I")
	private int keyHeight = 470;

	@OriginalMember(owner = "mapview!mapview", name = "tb", descriptor = "Z")
	private boolean showKey = false;

	@OriginalMember(owner = "mapview!mapview", name = "ub", descriptor = "I")
	private int currentKeyHover = -1;

	@OriginalMember(owner = "mapview!mapview", name = "vb", descriptor = "I")
	private int anInt128 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "wb", descriptor = "I")
	private int currentKey = -1;

	@OriginalMember(owner = "mapview!mapview", name = "yb", descriptor = "I")
	private int imageOverviewHeight = 200;

	@OriginalMember(owner = "mapview!mapview", name = "zb", descriptor = "I")
	private int imageOverviewWidth = this.imageOverviewHeight * 1280 / 1216;

	@OriginalMember(owner = "mapview!mapview", name = "Ab", descriptor = "I")
	private int overviewX = 635 - this.imageOverviewWidth - 5;

	@OriginalMember(owner = "mapview!mapview", name = "Bb", descriptor = "I")
	private int overviewY = 503 - this.imageOverviewHeight - 20;

	@OriginalMember(owner = "mapview!mapview", name = "Cb", descriptor = "Z")
	private boolean showOverview = false;

	@OriginalMember(owner = "mapview!mapview", name = "Jb", descriptor = "I")
	private int maxLabelCount = 1000;

	@OriginalMember(owner = "mapview!mapview", name = "Kb", descriptor = "[Ljava/lang/String;")
	private String[] labelText = new String[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Lb", descriptor = "[I")
	private int[] labelX = new int[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Mb", descriptor = "[I")
	private int[] labelY = new int[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Nb", descriptor = "[I")
	private int[] labelFont = new int[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Ob", descriptor = "D")
	private double zoomX = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Pb", descriptor = "D")
	private double zoomY = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Qb", descriptor = "I")
	private int offsetX = 896;

	@OriginalMember(owner = "mapview!mapview", name = "Rb", descriptor = "I")
	private int offsetY = 832;

	@OriginalMember(owner = "mapview!mapview", name = "Sb", descriptor = "[Ljava/lang/String;")
	private String[] keyNames = new String[] { "General Store", "Sword Shop", "Magic Shop", "Axe Shop", "Helmet Shop", "Bank", "Quest Start", "Amulet Shop", "Mining Site", "Furnace", "Anvil", "Combat Training", "Dungeon", "Staff Shop", "Platebody Shop", "Platelegs Shop", "Scimitar Shop", "Archery Shop", "Shield Shop", "Altar", "Herbalist", "Jewelery", "Gem Shop", "Crafting Shop", "Candle Shop", "Fishing Shop", "Fishing Spot", "Clothes Shop", "Apothecary", "Silk Trader", "Kebab Seller", "Pub/Bar", "Mace Shop", "Tannery", "Rare Trees", "Spinning Wheel", "Food Shop", "Cookery Shop", "???", "Water Source", "Cooking Range", "Skirt Shop", "Potters Wheel", "Windmill", "Mining Shop", "Chainmail Shop", "Silver Shop", "Fur Trader", "Spice Shop" };

	@OriginalMember(owner = "mapview!mapview", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] args) {
		@Pc(3) mapview app = new mapview();
		app.initApplication(635, 503);
	}

	@OriginalMember(owner = "mapview!mapview", name = "init", descriptor = "()V")
	@Override
	public void init() {
		this.initApplet(635, 503);
	}

	@OriginalMember(owner = "mapview!mapview", name = "c", descriptor = "()V")
	@Override
	protected void load() {
		@Pc(4) Jagfile worldmap = this.loadWorldmap();

		this.drawProgress("Please wait... Rendering Map", 100);

		@Pc(16) Packet labelData = new Packet(worldmap.read("labels.dat", null));
		this.labelCount = labelData.g2();
		for (@Pc(22) int i = 0; i < this.labelCount; i++) {
			this.labelText[i] = labelData.gjstr();
			this.labelX[i] = labelData.g2();
			this.labelY[i] = labelData.g2();
			this.labelFont[i] = labelData.g1();
		}

		@Pc(61) Packet floorcolData = new Packet(worldmap.read("floorcol.dat", null));
		@Pc(64) int floorcolCount = floorcolData.g2();
		this.floorcolUnderlay = new int[floorcolCount + 1];
		this.floorcolOverlay = new int[floorcolCount + 1];
		for (@Pc(78) int i = 0; i < floorcolCount; i++) {
			this.floorcolUnderlay[i + 1] = floorcolData.g4();
			this.floorcolOverlay[i + 1] = floorcolData.g4();
		}

		@Pc(105) byte[] underlayData = worldmap.read("underlay.dat", null);
		@Pc(109) byte[][] underlayTiles = new byte[1280][1216];
		this.readUnderlayData(underlayData, underlayTiles);

		@Pc(118) byte[] overlayData = worldmap.read("overlay.dat", null);
		this.overlayTiles = new int[1280][1216];
		this.overlayShapes = new byte[1280][1216];
		this.readOverlayData(overlayData, this.overlayTiles, this.overlayShapes);

		@Pc(140) byte[] locData = worldmap.read("loc.dat", null);
		this.locWalls = new byte[1280][1216];
		this.locMapscenes = new byte[1280][1216];
		this.locMapfunctions = new byte[1280][1216];
		this.readLocData(locData, this.locWalls, this.locMapscenes, this.locMapfunctions);

		try {
			for (int i = 0; i < 50; i++) {
				this.imageMapscene[i] = new Pix8(worldmap, "mapscene", i);
			}
		} catch (@Pc(184) Exception ignore) {
		}

		try {
			for (int i = 0; i < 50; i++) {
				this.imageMapfunction[i] = new Pix24(worldmap, "mapfunction", i);
			}
		} catch (@Pc(204) Exception ignore) {
		}

		this.b12 = new PixFont(worldmap, "b12");
		this.f11 = new WorldmapFont(11, true, this);
		this.f12 = new WorldmapFont(12, true, this);
		this.f14 = new WorldmapFont(14, true, this);
		this.f17 = new WorldmapFont(17, true, this);
		this.f19 = new WorldmapFont(19, true, this);
		this.f22 = new WorldmapFont(22, true, this);
		this.f26 = new WorldmapFont(26, true, this);
		this.f30 = new WorldmapFont(30, true, this);

		this.floormapColors = new int[1280][1216];
		this.averageUnderlayColors(underlayTiles, this.floormapColors);

		this.imageOverview = new Pix24(this.imageOverviewWidth, this.imageOverviewHeight);
		this.imageOverview.bind();
		this.drawMap(0, 0, 1280, 1216, 0, 0, this.imageOverviewWidth, this.imageOverviewHeight);
		Draw2D.drawRect(0, 0, 0, this.imageOverviewWidth, this.imageOverviewHeight);
		Draw2D.drawRect(1, 1, this.colorInactiveBorderTL, this.imageOverviewWidth - 2, this.imageOverviewHeight - 2);
		super.drawArea.bind();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B[[B[[B)V")
	private void readLocData(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1, @OriginalArg(2) byte[][] arg2, @OriginalArg(3) byte[][] arg3) {
		@Pc(3) int local3 = 0;
		while (local3 < arg0.length) {
			@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - 2304;
			@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - 2816;
			@Pc(43) int local43;
			if (local16 > 0 && local27 > 0 && local16 + 64 < 1280 && local27 + 64 < 1216) {
				for (local43 = 0; local43 < 64; local43++) {
					@Pc(51) byte[] local51 = arg1[local43 + local16];
					@Pc(57) byte[] local57 = arg2[local43 + local16];
					@Pc(63) byte[] local63 = arg3[local43 + local16];
					@Pc(69) int local69 = 1216 - local27 - 1;
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
								this.activeMapFunctionX[this.activeMapFunctionCount] = local43 + local16;
								this.activeMapFunctionZ[this.activeMapFunctionCount] = local69;
								this.activeMapFunctions[this.activeMapFunctionCount] = local80 - 160;
								this.activeMapFunctionCount++;
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
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B)V")
	private void readUnderlayData(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1) {
		@Pc(3) int local3 = 0;
		while (local3 < arg0.length) {
			@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - 2304;
			@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - 2816;
			if (local16 > 0 && local27 > 0 && local16 + 64 < 1280 && local27 + 64 < 1216) {
				for (@Pc(43) int local43 = 0; local43 < 64; local43++) {
					@Pc(51) byte[] local51 = arg1[local43 + local16];
					@Pc(57) int local57 = 1216 - local27 - 1;
					for (@Pc(59) int local59 = -64; local59 < 0; local59++) {
						local51[local57--] = arg0[local3++];
					}
				}
			} else {
				local3 += 4096;
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[I[[B)V")
	private void readOverlayData(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[][] arg1, @OriginalArg(2) byte[][] arg2) {
		@Pc(3) int local3 = 0;
		while (local3 < arg0.length) {
			@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - 2304;
			@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - 2816;
			@Pc(72) byte local72;
			@Pc(43) int local43;
			if (local16 > 0 && local27 > 0 && local16 + 64 < 1280 && local27 + 64 < 1216) {
				for (local43 = 0; local43 < 64; local43++) {
					@Pc(51) int[] local51 = arg1[local43 + local16];
					@Pc(57) byte[] local57 = arg2[local43 + local16];
					@Pc(63) int local63 = 1216 - local27 - 1;
					for (@Pc(65) int local65 = -64; local65 < 0; local65++) {
						local72 = arg0[local3++];
						if (local72 == 0) {
							local51[local63--] = 0;
						} else {
							local57[local63] = arg0[local3++];
							local51[local63--] = this.floorcolOverlay[local72];
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
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([[B[[I)V")
	private void averageUnderlayColors(@OriginalArg(0) byte[][] arg0, @OriginalArg(1) int[][] arg1) {
		@Pc(3) short local3 = 1280;
		@Pc(5) short local5 = 1216;
		@Pc(8) int[] local8 = new int[local5];
		for (@Pc(10) int local10 = 0; local10 < local5; local10++) {
			local8[local10] = 0;
		}
		for (@Pc(22) int local22 = 5; local22 < local3 - 5; local22++) {
			@Pc(30) byte[] local30 = arg0[local22 + 5];
			@Pc(36) byte[] local36 = arg0[local22 - 5];
			for (@Pc(38) int local38 = 0; local38 < local5; local38++) {
				local8[local38] += this.floorcolUnderlay[local30[local38] & 0xFF] - this.floorcolUnderlay[local36[local38] & 0xFF];
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
						local85[local87] = this.convertHsl((double) local77 / 8533.0D, (double) local79 / 8533.0D, (double) local81 / 8533.0D);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(DDD)I")
	private int convertHsl(@OriginalArg(0) double arg0, @OriginalArg(1) double arg1, @OriginalArg(2) double arg2) {
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
			this.floorcolUnderlay = null;
			this.floorcolOverlay = null;
			this.floormapColors = null;
			this.overlayTiles = null;
			this.overlayShapes = null;
			this.locWalls = null;
			this.locMapfunctions = null;
			this.locMapscenes = null;
			this.imageMapscene = null;
			this.imageMapfunction = null;
			this.b12 = null;
			this.visibleMapFunctionsX = null;
			this.visibleMapFunctionsY = null;
			this.visibleMapFunctions = null;
			this.activeMapFunctionX = null;
			this.activeMapFunctionZ = null;
			this.activeMapFunctions = null;
			this.imageOverview = null;
			this.labelText = null;
			this.labelX = null;
			this.labelY = null;
			this.labelFont = null;
			this.keyNames = null;
			System.gc();
		} catch (@Pc(71) Throwable ignore) {
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "h", descriptor = "()V")
	@Override
	protected void update() {
		if (super.actionKey[1] == 1) {
			this.offsetX = (int) ((double) this.offsetX - 16.0D / this.zoomX);
			this.redraw = true;
		}
		if (super.actionKey[2] == 1) {
			this.offsetX = (int) ((double) this.offsetX + 16.0D / this.zoomX);
			this.redraw = true;
		}

		if (super.actionKey[3] == 1) {
			this.offsetY = (int) ((double) this.offsetY - 16.0D / this.zoomX);
			this.redraw = true;
		}
		if (super.actionKey[4] == 1) {
			this.offsetY = (int) ((double) this.offsetY + 16.0D / this.zoomX);
			this.redraw = true;
		}

		@Pc(83) int local83 = 1;
		while (local83 > 0) {
			local83 = this.pollKey();
			if (local83 == 49) {
				this.zoomY = 3.0D;
				this.redraw = true;
			}
			if (local83 == 50) {
				this.zoomY = 4.0D;
				this.redraw = true;
			}
			if (local83 == 51) {
				this.zoomY = 6.0D;
				this.redraw = true;
			}
			if (local83 == 52) {
				this.zoomY = 8.0D;
				this.redraw = true;
			}
			if (local83 == 107 || local83 == 75) {
				this.showKey = !this.showKey;
				this.redraw = true;
			}
			if (local83 == 111 || local83 == 79) {
				this.showOverview = !this.showOverview;
				this.redraw = true;
			}
		}

        if (super.mouseClickButton == 1) {
            this.lastMouseClickX = super.mouseClickX;
            this.lastMouseClickY = super.mouseClickY;
            this.lastOffsetX = this.offsetX;
            this.lastOffsetY = this.offsetY;
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
            if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY + this.keyHeight && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < 503) {
                this.showKey = !this.showKey;
                this.lastMouseClickX = -1;
            }
            if (super.mouseClickX > this.overviewX && super.mouseClickY > this.overviewY + this.imageOverviewHeight && super.mouseClickX < this.overviewX + this.imageOverviewWidth && super.mouseClickY < 503) {
                this.showOverview = !this.showOverview;
                this.lastMouseClickX = -1;
            }
            if (this.showKey) {
                if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + this.keyHeight) {
                    this.lastMouseClickX = -1;
                }
                if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + 18) {
                    this.keyPage = 0;
                }
                if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY + this.keyHeight - 18 && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + this.keyHeight) {
                    this.keyPage = 25;
                }
            }
            this.redraw = true;
        }

        @Pc(463) int local463;
        @Pc(465) int local465;
        if (this.showKey) {
            this.currentKeyHover = -1;
            if (super.mouseX > this.keyX && super.mouseX < this.keyX + this.keyWidth) {
                local463 = this.keyY + 21 + 5;
                for (local465 = 0; local465 < 25; local465++) {
                    if (local465 + this.lastKeyPage >= this.keyNames.length || !this.keyNames[local465 + this.lastKeyPage].equals("???")) {
                        if (super.mouseY >= local463 && super.mouseY < local463 + 17) {
                            this.currentKeyHover = local465 + this.lastKeyPage;
                            if (super.mouseClickButton == 1) {
                                this.currentKey = local465 + this.lastKeyPage;
                                this.flashTimer = 50;
                            }
                        }
                        local463 += 17;
                    }
                }
            }

            if (this.currentKeyHover != this.anInt128) {
                this.anInt128 = this.currentKeyHover;
                this.redraw = true;
            }
        }

        if ((super.mouseButton == 1 || super.mouseClickButton == 1) && this.showOverview) {
            local463 = super.mouseClickX;
            local465 = super.mouseClickY;
            if (super.mouseButton == 1) {
                local463 = super.mouseX;
                local465 = super.mouseY;
            }

            if (local463 > this.overviewX && local465 > this.overviewY && local463 < this.overviewX + this.imageOverviewWidth && local465 < this.overviewY + this.imageOverviewHeight) {
                this.offsetX = (local463 - this.overviewX) * 1280 / this.imageOverviewWidth;
                this.offsetY = (local465 - this.overviewY) * 1216 / this.imageOverviewHeight;
                this.lastMouseClickX = -1;
                this.redraw = true;
            }
        }

        if (super.mouseButton == 1 && this.lastMouseClickX != -1) {
            this.offsetX = this.lastOffsetX + (int) ((double) (this.lastMouseClickX - super.mouseX) * 2.0D / this.zoomY);
            this.offsetY = this.lastOffsetY + (int) ((double) (this.lastMouseClickY - super.mouseY) * 2.0D / this.zoomY);
            this.redraw = true;
        }

        if (this.zoomX < this.zoomY) {
            this.redraw = true;
            this.zoomX += this.zoomX / 30.0D;
            if (this.zoomX > this.zoomY) {
                this.zoomX = this.zoomY;
            }
        }

        if (this.zoomX > this.zoomY) {
            this.redraw = true;
            this.zoomX -= this.zoomX / 30.0D;
            if (this.zoomX < this.zoomY) {
                this.zoomX = this.zoomY;
            }
        }

        if (this.lastKeyPage < this.keyPage) {
            this.redraw = true;
            this.lastKeyPage++;
        }

        if (this.lastKeyPage > this.keyPage) {
            this.redraw = true;
            this.lastKeyPage--;
        }

        if (this.flashTimer > 0) {
            this.redraw = true;
            this.flashTimer--;
        }

        local463 = this.offsetX - (int) (635.0D / this.zoomX);
        local465 = this.offsetY - (int) (503.0D / this.zoomX);
        @Pc(776) int local776 = this.offsetX + (int) (635.0D / this.zoomX);
        @Pc(785) int local785 = this.offsetY + (int) (503.0D / this.zoomX);
        if (local463 < 48) {
            this.offsetX = (int) (635.0D / this.zoomX) + 48;
        }
        if (local465 < 48) {
            this.offsetY = (int) (503.0D / this.zoomX) + 48;
        }
        if (local776 > 1232) {
            this.offsetX = 1232 - (int) (635.0D / this.zoomX);
        }
        if (local785 > 1168) {
            this.offsetY = 1168 - (int) (503.0D / this.zoomX);
        }
    }

	@OriginalMember(owner = "mapview!mapview", name = "e", descriptor = "()V")
	@Override
	protected void draw() {
		if (this.redraw) {
			this.redraw = false;
			this.redrawTimer = 0;
			Draw2D.clear();
			@Pc(20) int local20 = this.offsetX - (int) (635.0D / this.zoomX);
			@Pc(29) int local29 = this.offsetY - (int) (503.0D / this.zoomX);
			@Pc(38) int local38 = this.offsetX + (int) (635.0D / this.zoomX);
			@Pc(47) int local47 = this.offsetY + (int) (503.0D / this.zoomX);
			this.drawMap(local20, local29, local38, local47, 0, 0, 635, 503);
			@Pc(151) int local151;
			@Pc(173) int local173;
			@Pc(186) int local186;
			if (this.showOverview) {
				this.imageOverview.blitOpaque(this.overviewX, this.overviewY);
				Draw2D.fillRectAlpha(this.overviewX + this.imageOverviewWidth * local20 / 1280, this.overviewY + this.imageOverviewHeight * local29 / 1216, (local38 - local20) * this.imageOverviewWidth / 1280, (local47 - local29) * this.imageOverviewHeight / 1216, 16711680, 128);
				Draw2D.drawRect(this.overviewX + this.imageOverviewWidth * local20 / 1280, this.overviewY + this.imageOverviewHeight * local29 / 1216, 16711680, (local38 - local20) * this.imageOverviewWidth / 1280, (local47 - local29) * this.imageOverviewHeight / 1216);
				if (this.flashTimer > 0 && this.flashTimer % 10 < 5) {
					for (local151 = 0; local151 < this.activeMapFunctionCount; local151++) {
						if (this.activeMapFunctions[local151] == this.currentKey) {
							local173 = this.overviewX + this.imageOverviewWidth * this.activeMapFunctionX[local151] / 1280;
							local186 = this.overviewY + this.imageOverviewHeight * this.activeMapFunctionZ[local151] / 1216;
							Draw2D.fillCircle(local173, local186, 2, 16776960, 256);
						}
					}
				}
			}
			if (this.showKey) {
				this.drawString(this.keyX, this.keyY, this.keyWidth, 18, 10066329, 7829367, 5592405, "Prev page");
				this.drawString(this.keyX, this.keyY + 18, this.keyWidth, this.keyHeight - 36, 10066329, 7829367, 5592405, "");
				this.drawString(this.keyX, this.keyY + this.keyHeight - 18, this.keyWidth, 18, 10066329, 7829367, 5592405, "Next page");
				local151 = this.keyY + 3 + 18;
				for (local173 = 0; local173 < 25; local173++) {
					if (local173 + this.lastKeyPage < this.imageMapfunction.length && local173 + this.lastKeyPage < this.keyNames.length) {
						if (this.keyNames[local173 + this.lastKeyPage].equals("???")) {
							continue;
						}
						this.imageMapfunction[local173 + this.lastKeyPage].draw(this.keyX + 3, local151);
						this.b12.drawString(this.keyX + 21, local151 + 14, this.keyNames[local173 + this.lastKeyPage], 0);
						local186 = 16777215;
						if (this.currentKeyHover == local173 + this.lastKeyPage) {
							local186 = 12298922;
						}
						if (this.flashTimer > 0 && this.flashTimer % 10 < 5 && this.currentKey == local173 + this.lastKeyPage) {
							local186 = 16776960;
						}
						this.b12.drawString(this.keyX + 20, local151 + 13, this.keyNames[local173 + this.lastKeyPage], local186);
					}
					local151 += 17;
				}
			}
			this.drawString(this.overviewX, this.overviewY + this.imageOverviewHeight, this.imageOverviewWidth, 18, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "Overview");
			this.drawString(this.keyX, this.keyY + this.keyHeight, this.keyWidth, 18, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "Key");
			if (this.zoomY == 3.0D) {
				this.drawString(170, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "37%");
			} else {
				this.drawString(170, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "37%");
			}
			if (this.zoomY == 4.0D) {
				this.drawString(230, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "50%");
			} else {
				this.drawString(230, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "50%");
			}
			if (this.zoomY == 6.0D) {
				this.drawString(290, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "75%");
			} else {
				this.drawString(290, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "75%");
			}
			if (this.zoomY == 8.0D) {
				this.drawString(350, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "100%");
			} else {
				this.drawString(350, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "100%");
			}
		}
		this.redrawTimer--;
		if (this.redrawTimer <= 0) {
			super.drawArea.draw(super.graphics, 0, 0);
			this.redrawTimer = 50;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "()V")
	@Override
	protected void refresh() {
		this.redrawTimer = 0;
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
				@Pc(71) int[] local71 = this.overlayTiles[local27 + arg0];
				local78 = this.overlayShapes[local27 + arg0];
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
				@Pc(238) byte[] local238 = this.locMapscenes[local43 + arg0];
				@Pc(245) byte[] local245 = this.locMapfunctions[local43 + arg0];
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
							this.imageMapscene[local284 - 1].clip(local47 - local222 / 2, local100 - local267 / 2, local222 * 2, local267 * 2);
						}
						local295 = local245[local96 + arg1] & 0xFF;
						if (local295 != 0) {
							this.visibleMapFunctions[local35] = local295 - 1;
							this.visibleMapFunctionsX[local35] = local47 + local222 / 2;
							this.visibleMapFunctionsY[local35] = local100 + local267 / 2;
							local35++;
						}
					}
				}
			}
		}

		for (local47 = 0; local47 < local35; local47++) {
			this.imageMapfunction[this.visibleMapFunctions[local47]].draw(this.visibleMapFunctionsX[local47] - 7, this.visibleMapFunctionsY[local47] - 7);
		}

		if (this.flashTimer > 0) {
			for (local218 = 0; local218 < local35; local218++) {
				if (this.visibleMapFunctions[local218] == this.currentKey) {
					this.imageMapfunction[this.visibleMapFunctions[local218]].draw(this.visibleMapFunctionsX[local218] - 7, this.visibleMapFunctionsY[local218] - 7);
					if (this.flashTimer % 10 < 5) {
						Draw2D.fillCircle(this.visibleMapFunctionsX[local218], this.visibleMapFunctionsY[local218], 15, 16776960, 128);
						Draw2D.fillCircle(this.visibleMapFunctionsX[local218], this.visibleMapFunctionsY[local218], 7, 16777215, 256);
					}
				}
			}
		}

        if (this.zoomX == this.zoomY) {
            for (local218 = 0; local218 < this.labelCount; local218++) {
                local222 = this.labelX[local218];
                @Pc(704) int local704 = this.labelY[local218];
                local222 -= 2304;
                @Pc(709) int local709 = 4032 - local704;
                local80 = arg4 + (arg6 - arg4) * (local222 - arg0) / (arg2 - arg0);
                local88 = arg5 + (arg7 - arg5) * (local709 - arg1) / (arg3 - arg1);
                local96 = this.labelFont[local218];
                local100 = 16777215;
                @Pc(746) WorldmapFont local746 = null;
                if (local96 == 0) {
                    if (this.zoomX == 3.0D) {
                        local746 = this.f11;
                    }
                    if (this.zoomX == 4.0D) {
                        local746 = this.f12;
                    }
                    if (this.zoomX == 6.0D) {
                        local746 = this.f14;
                    }
                    if (this.zoomX == 8.0D) {
                        local746 = this.f17;
                    }
                }
                if (local96 == 1) {
                    if (this.zoomX == 3.0D) {
                        local746 = this.f14;
                    }
                    if (this.zoomX == 4.0D) {
                        local746 = this.f17;
                    }
                    if (this.zoomX == 6.0D) {
                        local746 = this.f19;
                    }
                    if (this.zoomX == 8.0D) {
                        local746 = this.f22;
                    }
                }
                if (local96 == 2) {
                    local100 = 16755200;
                    if (this.zoomX == 3.0D) {
                        local746 = this.f19;
                    }
                    if (this.zoomX == 4.0D) {
                        local746 = this.f22;
                    }
                    if (this.zoomX == 6.0D) {
                        local746 = this.f26;
                    }
                    if (this.zoomX == 8.0D) {
                        local746 = this.f30;
                    }
                }
                if (local746 != null) {
                    @Pc(859) String local859 = this.labelText[local218];
                    local144 = 1;
                    for (local284 = 0; local284 < local859.length(); local284++) {
                        if (local859.charAt(local284) == '/') {
                            local144++;
                        }
                    }
                    local88 -= local746.getHeight() * (local144 - 1) / 2;
                    local88 += local746.getYOffset() / 2;
                    while (true) {
                        local295 = local859.indexOf("/");
                        if (local295 == -1) {
                            local746.drawStringCenter(local859, local80, local88, local100, true);
                            break;
                        }
                        @Pc(915) String local915 = local859.substring(0, local295);
                        local746.drawStringCenter(local915, local80, local88, local100, true);
                        local88 += local746.getHeight();
                        local859 = local859.substring(local295 + 1);
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

	@OriginalMember(owner = "mapview!mapview", name = "i", descriptor = "()Lmapview!p;")
	private Jagfile loadWorldmap() {
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
		local17 = this.updateWorldmap();
		if (local3 != null && local17 != null) {
			try {
				this.cachesave(local3 + "/worldmap.dat", local17);
			} catch (@Pc(51) Throwable local51) {
			}
		}
		return new Jagfile(local17);
	}

	@OriginalMember(owner = "mapview!mapview", name = "j", descriptor = "()[B")
	private byte[] updateWorldmap() {
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
