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

import java.io.*;
import java.net.URL;
import java.security.MessageDigest;

@OriginalClass("mapview!mapview")
public final class mapview extends GameShell {

	// 2005 mapview applet features
	private static final boolean shouldDrawBorders = false;
	private static final boolean shouldDrawLabels = true;

	// overworld
	private final short startX = 3200;
	private final short startZ = 3200;
	private final short sizeX = 20 << 6;
	private final short sizeZ = 21 << 6;
	private final short originX = 35 << 6;
	private final short originZ = 43 << 6;

	// underground
//	private final short startX = 3200;
//	private final short startZ = 9600;
//	private final short sizeX = 20 << 6;
//	private final short sizeZ = 21 << 6;
//	private final short originX = 35 << 6;
//	private final short originZ = 143 << 6;

	// misc. areas (around Z 75)
//	private final short startX = 2496;
//	private final short startZ = 4736;
//	private final short sizeX = 21 << 6;
//	private final short sizeZ = 15 << 6;
//	private final short originX = 28 << 6;
//	private final short originZ = 65 << 6;

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
	private byte[][] overlayInfo;

	@OriginalMember(owner = "mapview!mapview", name = "S", descriptor = "[[B")
	private byte[][] locWalls;

	@OriginalMember(owner = "mapview!mapview", name = "T", descriptor = "[[B")
	private byte[][] locMapfunctions;

	@OriginalMember(owner = "mapview!mapview", name = "U", descriptor = "[[B")
	private byte[][] locMapscenes;

	private boolean[][] objTiles;

	private boolean[][] npcTiles;

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
	private int lastOffsetZ;

	@OriginalMember(owner = "mapview!mapview", name = "Ib", descriptor = "I")
	private int labelCount;

	@OriginalMember(owner = "mapview!mapview", name = "F", descriptor = "I")
	private final int colorInactiveBorderTL = 0x887755;

	@OriginalMember(owner = "mapview!mapview", name = "G", descriptor = "I")
	private final int colorInactive = 0x776644;

	@OriginalMember(owner = "mapview!mapview", name = "H", descriptor = "I")
	private final int colorInactiveBorderBR = 0x665533;

	@OriginalMember(owner = "mapview!mapview", name = "I", descriptor = "I")
	private final int colorActiveBorderTL = 0xaa0000;

	@OriginalMember(owner = "mapview!mapview", name = "J", descriptor = "I")
	private final int colorActive = 0x990000;

	@OriginalMember(owner = "mapview!mapview", name = "K", descriptor = "I")
	private final int colorActiveBorderBR = 0x880000;

	@OriginalMember(owner = "mapview!mapview", name = "L", descriptor = "Z")
	private boolean redraw = true;

	@OriginalMember(owner = "mapview!mapview", name = "V", descriptor = "[Lmapview!i;")
	private Pix8[] imageMapscene = new Pix8[50];

	@OriginalMember(owner = "mapview!mapview", name = "W", descriptor = "[Lmapview!h;")
	private Pix24[] imageMapfunction = new Pix24[50];

	private Pix24 imageMapdot0;
	private Pix24 imageMapdot1;
	private Pix24 imageMapdot2;
	private Pix24 imageMapdot3;

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
	private int lastKeyHover = -1;

	@OriginalMember(owner = "mapview!mapview", name = "wb", descriptor = "I")
	private int currentKey = -1;

	@OriginalMember(owner = "mapview!mapview", name = "yb", descriptor = "I")
	private int imageOverviewHeight = 200;

	@OriginalMember(owner = "mapview!mapview", name = "zb", descriptor = "I")
	private int imageOverviewWidth = (this.imageOverviewHeight * this.sizeX) / this.sizeZ;

	@OriginalMember(owner = "mapview!mapview", name = "Ab", descriptor = "I")
	private int overviewX = 635 - this.imageOverviewWidth - 5;

	@OriginalMember(owner = "mapview!mapview", name = "Bb", descriptor = "I")
	private int overviewY = 503 - this.imageOverviewHeight - 20;

	@OriginalMember(owner = "mapview!mapview", name = "Cb", descriptor = "Z")
	private boolean showOverview = false;

	@OriginalMember(owner = "mapview!mapview", name = "Jb", descriptor = "I")
	private final int maxLabelCount = 1000;

	@OriginalMember(owner = "mapview!mapview", name = "Kb", descriptor = "[Ljava/lang/String;")
	private String[] labelText = new String[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Lb", descriptor = "[I")
	private int[] labelX = new int[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Mb", descriptor = "[I")
	private int[] labelY = new int[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Nb", descriptor = "[I")
	private int[] labelFont = new int[this.maxLabelCount];

	@OriginalMember(owner = "mapview!mapview", name = "Ob", descriptor = "D")
	private double zoom = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Pb", descriptor = "D")
	private double targetZoom = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Qb", descriptor = "I")
	private int offsetX = this.startX - this.originX;

	@OriginalMember(owner = "mapview!mapview", name = "Rb", descriptor = "I")
	private int offsetZ = (this.originZ + this.sizeZ) - this.startZ;

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
		@Pc(109) byte[][] underlayTiles = new byte[this.sizeX][this.sizeZ];
		this.readUnderlayData(underlayData, underlayTiles);

		@Pc(118) byte[] overlayData = worldmap.read("overlay.dat", null);
		this.overlayTiles = new int[this.sizeX][this.sizeZ];
		this.overlayInfo = new byte[this.sizeX][this.sizeZ];
		this.readOverlayData(overlayData, this.overlayTiles, this.overlayInfo);

		@Pc(140) byte[] locData = worldmap.read("loc.dat", null);
		this.locWalls = new byte[this.sizeX][this.sizeZ];
		this.locMapscenes = new byte[this.sizeX][this.sizeZ];
		this.locMapfunctions = new byte[this.sizeX][this.sizeZ];
		this.readLocData(locData, this.locWalls, this.locMapscenes, this.locMapfunctions);

		byte[] objData = worldmap.read("obj.dat", null);
		this.objTiles = new boolean[this.sizeX][this.sizeZ];
		this.readObjData(objData, this.objTiles);

		byte[] npcData = worldmap.read("npc.dat", null);
		this.npcTiles = new boolean[this.sizeX][this.sizeZ];
		this.readNpcData(npcData, this.npcTiles);

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

		this.imageMapdot0 = new Pix24(worldmap, "mapdots", 0);
		this.imageMapdot1 = new Pix24(worldmap, "mapdots", 1);
		this.imageMapdot2 = new Pix24(worldmap, "mapdots", 2);
		this.imageMapdot3 = new Pix24(worldmap, "mapdots", 3);

		this.b12 = new PixFont(worldmap, "b12");
		this.f11 = new WorldmapFont(11, true, this);
		this.f12 = new WorldmapFont(12, true, this);
		this.f14 = new WorldmapFont(14, true, this);
		this.f17 = new WorldmapFont(17, true, this);
		this.f19 = new WorldmapFont(19, true, this);
		this.f22 = new WorldmapFont(22, true, this);
		this.f26 = new WorldmapFont(26, true, this);
		this.f30 = new WorldmapFont(30, true, this);

		this.floormapColors = new int[this.sizeX][this.sizeZ];
		this.averageUnderlayColors(underlayTiles, this.floormapColors);

		this.imageOverview = new Pix24(this.imageOverviewWidth, this.imageOverviewHeight);
		this.imageOverview.bind();
		this.drawMap(0, 0, this.sizeX, this.sizeZ, 0, 0, this.imageOverviewWidth, this.imageOverviewHeight);
		Draw2D.drawRect(0, 0, 0, this.imageOverviewWidth, this.imageOverviewHeight);
		Draw2D.drawRect(1, 1, this.colorInactiveBorderTL, this.imageOverviewWidth - 2, this.imageOverviewHeight - 2);

		super.drawArea.bind();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B[[B[[B)V")
	private void readLocData(@OriginalArg(0) byte[] data, @OriginalArg(1) byte[][] walls, @OriginalArg(2) byte[][] mapscenes, @OriginalArg(3) byte[][] mapfunctions) {
		@Pc(3) int pos = 0;
		while (pos < data.length) {
			@Pc(16) int mx = (data[pos++] & 0xFF) * 64 - this.originX;
			@Pc(27) int mz = (data[pos++] & 0xFF) * 64 - this.originZ;

			if (mx > 0 && mz > 0 && mx + 64 < this.sizeX && mz + 64 < this.sizeZ) {
				for (int x = 0; x < 64; x++) {
					@Pc(51) byte[] wall = walls[x + mx];
					@Pc(57) byte[] mapscene = mapscenes[x + mx];
					@Pc(63) byte[] mapfunction = mapfunctions[x + mx];
					@Pc(69) int zIndex = this.sizeZ - mz - 1;

					for (@Pc(71) int z = -64; z < 0; z++) {
						while (true) {
							@Pc(80) int opcode = data[pos++] & 0xFF;
							if (opcode == 0) {
								zIndex--;
								break;
							}

							if (opcode < 29) {
								wall[zIndex] = (byte) opcode;
							} else if (opcode < 160) {
								mapscene[zIndex] = (byte) (opcode - 28);
							} else {
								mapfunction[zIndex] = (byte) (opcode - 159);

								this.activeMapFunctions[this.activeMapFunctionCount] = opcode - 160;
								this.activeMapFunctionX[this.activeMapFunctionCount] = x + mx;
								this.activeMapFunctionZ[this.activeMapFunctionCount] = zIndex;
								this.activeMapFunctionCount++;
							}
						}
					}
				}
			} else {
				for (int x = 0; x < 64; x++) {
					@Pc(164) byte opcode;
					for (@Pc(157) int z = -64; z < 0; z++) {
						do {
							opcode = data[pos++];
						} while (opcode != 0);
					}
				}
			}
		}
	}

	private void readObjData(byte[] data, boolean[][] objs) {
		int pos = 0;
		while (pos < data.length) {
			int mx = (data[pos++] & 0xFF) * 64 - this.originX;
			int mz = (data[pos++] & 0xFF) * 64 - this.originZ;

			if (mx > 0 && mz > 0 && mx + 64 < this.sizeX && mz + 64 < this.sizeZ) {
				for (int x = 0; x < 64; x++) {
					boolean[] obj = objs[x + mx];
					int zIndex = this.sizeZ - mz - 1;

					for (int z = -64; z < 0; z++) {
						obj[zIndex--] = data[pos++] == 1;
					}
				}
			} else {
				pos += 4096;
			}
		}
	}

	private void readNpcData(byte[] data, boolean[][] npcs) {
		int pos = 0;
		while (pos < data.length) {
			int mx = (data[pos++] & 0xFF) * 64 - this.originX;
			int mz = (data[pos++] & 0xFF) * 64 - this.originZ;

			if (mx > 0 && mz > 0 && mx + 64 < this.sizeX && mz + 64 < this.sizeZ) {
				for (int x = 0; x < 64; x++) {
					boolean[] npc = npcs[x + mx];
					int zIndex = this.sizeZ - mz - 1;

					for (int z = -64; z < 0; z++) {
						npc[zIndex--] = data[pos++] == 1;
					}
				}
			} else {
				pos += 4096;
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B)V")
	private void readUnderlayData(@OriginalArg(0) byte[] data, @OriginalArg(1) byte[][] underlays) {
		@Pc(3) int pos = 0;
		while (pos < data.length) {
			@Pc(16) int mx = (data[pos++] & 0xFF) * 64 - this.originX;
			@Pc(27) int mz = (data[pos++] & 0xFF) * 64 - this.originZ;

			if (mx > 0 && mz > 0 && mx + 64 < this.sizeX && mz + 64 < this.sizeZ) {
				for (@Pc(43) int x = 0; x < 64; x++) {
					@Pc(51) byte[] underlay = underlays[x + mx];
					@Pc(57) int zIndex = this.sizeZ - mz - 1;

					for (@Pc(59) int z = -64; z < 0; z++) {
						underlay[zIndex--] = data[pos++];
					}
				}
			} else {
				pos += 4096;
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[I[[B)V")
	private void readOverlayData(@OriginalArg(0) byte[] data, @OriginalArg(1) int[][] tiles, @OriginalArg(2) byte[][] shapes) {
		@Pc(3) int pos = 0;
		while (pos < data.length) {
			@Pc(16) int mx = (data[pos++] & 0xFF) * 64 - this.originX;
			@Pc(27) int mz = (data[pos++] & 0xFF) * 64 - this.originZ;

			if (mx > 0 && mz > 0 && mx + 64 < this.sizeX && mz + 64 < this.sizeZ) {
				for (int x = 0; x < 64; x++) {
					@Pc(51) int[] tile = tiles[x + mx];
					@Pc(57) byte[] shape = shapes[x + mx];
					@Pc(63) int zIndex = this.sizeZ - mz - 1;

					for (@Pc(65) int z = -64; z < 0; z++) {
						int opcode = data[pos++];
						if (opcode == 0) {
							tile[zIndex--] = 0;
						} else {
							shape[zIndex] = data[pos++];
							tile[zIndex--] = this.floorcolOverlay[opcode];
						}
					}
				}
			} else {
				for (int i = -4096; i < 0; i++) {
					int opcode = data[pos++];
					if (opcode != 0) {
						pos++;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([[B[[I)V")
	private void averageUnderlayColors(@OriginalArg(0) byte[][] tiles, @OriginalArg(1) int[][] colors) {
		@Pc(3) short maxX = this.sizeX;
		@Pc(5) short maxZ = this.sizeZ;

		@Pc(8) int[] average = new int[maxZ];

		for (@Pc(22) int x = 5; x < maxX - 5; x++) {
			@Pc(30) byte[] tileEast = tiles[x + 5];
			@Pc(36) byte[] tileWest = tiles[x - 5];

			for (@Pc(38) int z = 0; z < maxZ; z++) {
				average[z] += this.floorcolUnderlay[tileEast[z] & 0xFF] - this.floorcolUnderlay[tileWest[z] & 0xFF];
			}

			if (x > 10 && x < maxX - 10) {
				@Pc(77) int r = 0;
				@Pc(79) int g = 0;
				@Pc(81) int b = 0;

				@Pc(85) int[] samples = colors[x];
				for (@Pc(87) int z = 5; z < maxZ - 5; z++) {
					@Pc(101) int tileNorth = average[z + 5];
					@Pc(95) int tileSouth = average[z - 5];

					r += (tileNorth >> 20) - (tileSouth >> 20);
					g += (tileNorth >> 10 & 0x3FF) - (tileSouth >> 10 & 0x3FF);
					b += (tileNorth & 0x3FF) - (tileSouth & 0x3FF);

					if (b > 0) {
						samples[z] = this.convertHsl((double) r / 8533.0D, (double) g / 8533.0D, (double) b / 8533.0D);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(DDD)I")
	private int convertHsl(@OriginalArg(0) double hue, @OriginalArg(1) double saturation, @OriginalArg(2) double lightness) {
		@Pc(3) double r = lightness;
		@Pc(5) double g = lightness;
		@Pc(7) double b = lightness;

		if (saturation != 0.0D) {
			@Pc(21) double q;
			if (lightness < 0.5D) {
				q = lightness * (saturation + 1.0D);
			} else {
				q = lightness + saturation - lightness * saturation;
			}

			@Pc(37) double p = lightness * 2.0D - q;
			@Pc(41) double t = hue + 0.3333333333333333D;
			if (t > 1.0D) {
				t--;
			}

			@Pc(55) double d11 = hue - 0.3333333333333333D;
			if (d11 < 0.0D) {
				d11++;
			}

			if (t * 6.0D < 1.0D) {
				r = p + (q - p) * 6.0D * t;
			} else if (t * 2.0D < 1.0D) {
				r = q;
			} else if (t * 3.0D < 2.0D) {
				r = p + (q - p) * (0.6666666666666666D - t) * 6.0D;
			} else {
				r = p;
			}

			if (hue * 6.0D < 1.0D) {
				g = p + (q - p) * 6.0D * hue;
			} else if (hue * 2.0D < 1.0D) {
				g = q;
			} else if (hue * 3.0D < 2.0D) {
				g = p + (q - p) * (0.6666666666666666D - hue) * 6.0D;
			} else {
				g = p;
			}

			if (d11 * 6.0D < 1.0D) {
				b = p + (q - p) * 6.0D * d11;
			} else if (d11 * 2.0D < 1.0D) {
				b = q;
			} else if (d11 * 3.0D < 2.0D) {
				b = p + (q - p) * (0.6666666666666666D - d11) * 6.0D;
			} else {
				b = p;
			}
		}

		@Pc(218) int intR = (int) (r * 256.0D);
		@Pc(223) int intG = (int) (g * 256.0D);
		@Pc(228) int intB = (int) (b * 256.0D);
		return (intR << 16) + (intG << 8) + intB;
	}

	@OriginalMember(owner = "mapview!mapview", name = "g", descriptor = "()V")
	@Override
	protected void unload() {
		try {
			this.floorcolUnderlay = null;
			this.floorcolOverlay = null;
			this.floormapColors = null;
			this.overlayTiles = null;
			this.overlayInfo = null;
			this.locWalls = null;
			this.locMapfunctions = null;
			this.locMapscenes = null;
			this.objTiles = null;
			this.npcTiles = null;
			this.imageMapscene = null;
			this.imageMapfunction = null;
			this.imageMapdot0 = null;
			this.imageMapdot1 = null;
			this.imageMapdot2 = null;
			this.imageMapdot3 = null;
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
			this.offsetX = (int) ((double) this.offsetX - (16.0D / this.zoom));
			this.redraw = true;
		}
		if (super.actionKey[2] == 1) {
			this.offsetX = (int) ((double) this.offsetX + (16.0D / this.zoom));
			this.redraw = true;
		}
		if (super.actionKey[3] == 1) {
			this.offsetZ = (int) ((double) this.offsetZ - (16.0D / this.zoom));
			this.redraw = true;
		}
		if (super.actionKey[4] == 1) {
			this.offsetZ = (int) ((double) this.offsetZ + (16.0D / this.zoom));
			this.redraw = true;
		}

		@Pc(83) int key = 1;
		while (key > 0) {
			key = this.pollKey();

			if (key == 49) {
				this.targetZoom = 3.0D;
				this.redraw = true;
			} else if (key == 50) {
				this.targetZoom = 4.0D;
				this.redraw = true;
			} else if (key == 51) {
				this.targetZoom = 6.0D;
				this.redraw = true;
			} else if (key == 52) {
				this.targetZoom = 8.0D;
				this.redraw = true;
			} else if (key == 107 || key == 75) {
				this.showKey = !this.showKey;
				this.redraw = true;
			} else if (key == 111 || key == 79) {
				this.showOverview = !this.showOverview;
				this.redraw = true;
			} else if (key == 101 && super.frame != null) {
				// 2005 mapview applet feature
				System.out.println("Starting export...");

				@Pc(169) Pix24 map = new Pix24(this.sizeX * 2, this.sizeZ * 2);
				map.bind();
				this.drawMap(0, 0, this.sizeX, this.sizeZ, 0, 0, this.sizeX * 2, this.sizeZ * 2);
				super.drawArea.bind();

				int len = map.pixels.length;
				@Pc(197) byte[] data = new byte[len * 3];

				int off = 0;
				for (@Pc(201) int i = 0; i < len; i++) {
					@Pc(208) int rgb = map.pixels[i];
					data[off++] = (byte) (rgb >> 16);
					data[off++] = (byte) (rgb >> 8);
					data[off++] = (byte) rgb;
				}

				System.out.println("Saving to disk");

				try {
					@Pc(261) BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream("map-" + (this.sizeX * 2) + "-" + (this.sizeZ * 2) + "-rgb.raw"));
					stream.write(data);
					stream.close();
				} catch (@Pc(268) Exception ex) {
					ex.printStackTrace();
				}

				System.out.println("Done export: " + (this.sizeX * 2) + "," + (this.sizeZ * 2));
			}
		}

        if (super.mouseClickButton == 1) {
            this.lastMouseClickX = super.mouseClickX;
            this.lastMouseClickY = super.mouseClickY;
            this.lastOffsetX = this.offsetX;
            this.lastOffsetZ = this.offsetZ;

            if (super.mouseClickX > 170 && super.mouseClickX < 220 && super.mouseClickY > 471 && super.mouseClickY < 503) {
                this.targetZoom = 3.0D;
                this.lastMouseClickX = -1;
            } else if (super.mouseClickX > 230 && super.mouseClickX < 280 && super.mouseClickY > 471 && super.mouseClickY < 503) {
                this.targetZoom = 4.0D;
                this.lastMouseClickX = -1;
            } else if (super.mouseClickX > 290 && super.mouseClickX < 340 && super.mouseClickY > 471 && super.mouseClickY < 503) {
                this.targetZoom = 6.0D;
                this.lastMouseClickX = -1;
            } else if (super.mouseClickX > 350 && super.mouseClickX < 400 && super.mouseClickY > 471 && super.mouseClickY < 503) {
                this.targetZoom = 8.0D;
                this.lastMouseClickX = -1;
            } else if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY + this.keyHeight && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < 503) {
                this.showKey = !this.showKey;
                this.lastMouseClickX = -1;
            } else if (super.mouseClickX > this.overviewX && super.mouseClickY > this.overviewY + this.imageOverviewHeight && super.mouseClickX < this.overviewX + this.imageOverviewWidth && super.mouseClickY < 503) {
                this.showOverview = !this.showOverview;
                this.lastMouseClickX = -1;
            }

            if (this.showKey) {
                if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + this.keyHeight) {
                    this.lastMouseClickX = -1;
                }

				if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + 18) {
                    this.keyPage = 0;
                } else if (super.mouseClickX > this.keyX && super.mouseClickY > this.keyY + this.keyHeight - 18 && super.mouseClickX < this.keyX + this.keyWidth && super.mouseClickY < this.keyY + this.keyHeight) {
                    this.keyPage = 25;
                }
            }

            this.redraw = true;
        }

        if (this.showKey) {
            this.currentKeyHover = -1;

            if (super.mouseX > this.keyX && super.mouseX < this.keyX + this.keyWidth) {
                int y = this.keyY + 21 + 5;

                for (int row = 0; row < 25; row++) {
                    if (row + this.lastKeyPage >= this.keyNames.length || !this.keyNames[row + this.lastKeyPage].equals("???")) {
                        if (super.mouseY >= y && super.mouseY < y + 17) {
                            this.currentKeyHover = row + this.lastKeyPage;

                            if (super.mouseClickButton == 1) {
                                this.currentKey = row + this.lastKeyPage;
                                this.flashTimer = 50;
                            }
                        }

                        y += 17;
                    }
                }
            }

            if (this.currentKeyHover != this.lastKeyHover) {
                this.lastKeyHover = this.currentKeyHover;
                this.redraw = true;
            }
        }

        if ((super.mouseButton == 1 || super.mouseClickButton == 1) && this.showOverview) {
			int mouseClickX = super.mouseClickX;
			int mouseClickY = super.mouseClickY;
            if (super.mouseButton == 1) {
                mouseClickX = super.mouseX;
                mouseClickY = super.mouseY;
            }

            if (mouseClickX > this.overviewX && mouseClickY > this.overviewY && mouseClickX < this.overviewX + this.imageOverviewWidth && mouseClickY < this.overviewY + this.imageOverviewHeight) {
                this.offsetX = (mouseClickX - this.overviewX) * this.sizeX / this.imageOverviewWidth;
                this.offsetZ = (mouseClickY - this.overviewY) * this.sizeZ / this.imageOverviewHeight;
                this.lastMouseClickX = -1;
                this.redraw = true;
            }
        }

        if (super.mouseButton == 1 && this.lastMouseClickX != -1) {
            this.offsetX = this.lastOffsetX + (int) ((double) (this.lastMouseClickX - super.mouseX) * 2.0D / this.targetZoom);
            this.offsetZ = this.lastOffsetZ + (int) ((double) (this.lastMouseClickY - super.mouseY) * 2.0D / this.targetZoom);
            this.redraw = true;
        }

        if (this.zoom < this.targetZoom) {
            this.redraw = true;
            this.zoom += this.zoom / 30.0D;
            if (this.zoom > this.targetZoom) {
                this.zoom = this.targetZoom;
            }
        }

        if (this.zoom > this.targetZoom) {
            this.redraw = true;
            this.zoom -= this.zoom / 30.0D;
            if (this.zoom < this.targetZoom) {
                this.zoom = this.targetZoom;
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

		int left = this.offsetX - (int) (635.0D / this.zoom);
		int top = this.offsetZ - (int) (503.0D / this.zoom);
        @Pc(776) int right = this.offsetX + (int) (635.0D / this.zoom);
        @Pc(785) int bottom = this.offsetZ + (int) (503.0D / this.zoom);
        if (left < 48) {
            this.offsetX = (int) (635.0D / this.zoom) + 48;
        }
        if (top < 48) {
            this.offsetZ = (int) (503.0D / this.zoom) + 48;
        }
        if (right > this.sizeX - 48) {
            this.offsetX = (this.sizeX - 48) - (int) (635.0D / this.zoom);
        }
        if (bottom > this.sizeZ - 48) {
            this.offsetZ = (this.sizeZ - 48) - (int) (503.0D / this.zoom);
        }
    }

	@OriginalMember(owner = "mapview!mapview", name = "e", descriptor = "()V")
	@Override
	protected void draw() {
		if (this.redraw) {
			this.redraw = false;
			this.redrawTimer = 0;

			Draw2D.clear();

			@Pc(20) int left = this.offsetX - (int) (635.0D / this.zoom);
			@Pc(29) int top = this.offsetZ - (int) (503.0D / this.zoom);
			@Pc(38) int right = this.offsetX + (int) (635.0D / this.zoom);
			@Pc(47) int bottom = this.offsetZ + (int) (503.0D / this.zoom);
			this.drawMap(left, top, right, bottom, 0, 0, 635, 503);

			if (this.showOverview) {
				this.imageOverview.blitOpaque(this.overviewX, this.overviewY);

				Draw2D.fillRectAlpha(this.overviewX + this.imageOverviewWidth * left / this.sizeX, this.overviewY + this.imageOverviewHeight * top / this.sizeZ, (right - left) * this.imageOverviewWidth / this.sizeX, (bottom - top) * this.imageOverviewHeight / this.sizeZ, 0xff0000, 0x80);
				Draw2D.drawRect(this.overviewX + this.imageOverviewWidth * left / this.sizeX, this.overviewY + this.imageOverviewHeight * top / this.sizeZ, 0xff0000, (right - left) * this.imageOverviewWidth / this.sizeX, (bottom - top) * this.imageOverviewHeight / this.sizeZ);

				if (this.flashTimer > 0 && this.flashTimer % 10 < 5) {
					for (int i = 0; i < this.activeMapFunctionCount; i++) {
						if (this.activeMapFunctions[i] == this.currentKey) {
							int x = this.overviewX + this.imageOverviewWidth * this.activeMapFunctionX[i] / this.sizeX;
							int y = this.overviewY + this.imageOverviewHeight * this.activeMapFunctionZ[i] / this.sizeZ;
							Draw2D.fillCircle(x, y, 2, 0xffff00, 256);
						}
					}
				}
			}

			if (this.showKey) {
				this.drawString(this.keyX, this.keyY, this.keyWidth, 18, 0x999999, 0x777777, 0x555555, "Prev page");
				this.drawString(this.keyX, this.keyY + 18, this.keyWidth, this.keyHeight - 36, 0x999999, 0x777777, 0x555555, "");
				this.drawString(this.keyX, this.keyY + this.keyHeight - 18, this.keyWidth, 18, 0x999999, 0x777777, 0x555555, "Next page");

				int y = this.keyY + 3 + 18;
				for (int row = 0; row < 25; row++) {
					if (row + this.lastKeyPage < this.imageMapfunction.length && row + this.lastKeyPage < this.keyNames.length) {
						if (this.keyNames[row + this.lastKeyPage].equals("???")) {
							continue;
						}

						this.imageMapfunction[row + this.lastKeyPage].draw(this.keyX + 3, y);
						this.b12.drawString(this.keyX + 21, y + 14, this.keyNames[row + this.lastKeyPage], 0);

						int rgb = 0xffffff;
						if (this.currentKeyHover == row + this.lastKeyPage) {
							rgb = 0xbbaaaa;
						}
						if (this.flashTimer > 0 && this.flashTimer % 10 < 5 && this.currentKey == row + this.lastKeyPage) {
							rgb = 0xffff00;
						}

						this.b12.drawString(this.keyX + 20, y + 13, this.keyNames[row + this.lastKeyPage], rgb);
					}

					y += 17;
				}
			}

			this.drawString(this.overviewX, this.overviewY + this.imageOverviewHeight, this.imageOverviewWidth, 18, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "Overview");
			this.drawString(this.keyX, this.keyY + this.keyHeight, this.keyWidth, 18, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "Key");

			if (this.targetZoom == 3.0D) {
				this.drawString(170, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "37%");
			} else {
				this.drawString(170, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "37%");
			}

			if (this.targetZoom == 4.0D) {
				this.drawString(230, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "50%");
			} else {
				this.drawString(230, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "50%");
			}

			if (this.targetZoom == 6.0D) {
				this.drawString(290, 471, 50, 30, this.colorActiveBorderTL, this.colorActive, this.colorActiveBorderBR, "75%");
			} else {
				this.drawString(290, 471, 50, 30, this.colorInactiveBorderTL, this.colorInactive, this.colorInactiveBorderBR, "75%");
			}

			if (this.targetZoom == 8.0D) {
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
	private void drawString(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int width, @OriginalArg(3) int height, @OriginalArg(4) int colorBorderTL, @OriginalArg(5) int fillColor, @OriginalArg(6) int colorBorderBR, @OriginalArg(7) String str) {
		Draw2D.drawRect(x, y, 0, width, height);

		@Pc(6) int xPad = x + 1;
		@Pc(7) int yPad = y + 1;
		@Pc(8) int widthPad = width - 2;
		@Pc(9) int heightPad = height - 2;

		Draw2D.fillRect(xPad, yPad, fillColor, widthPad, heightPad);
		Draw2D.drawHorizontalLine(xPad, yPad, colorBorderTL, widthPad);
		Draw2D.drawVerticalLine(xPad, yPad, colorBorderTL, heightPad);
		Draw2D.drawHorizontalLine(xPad, yPad + heightPad - 1, colorBorderBR, widthPad);
		Draw2D.drawVerticalLine(xPad + widthPad - 1, yPad, colorBorderBR, heightPad);

		this.b12.drawStringCenter(xPad + widthPad / 2 + 1, yPad + heightPad / 2 + 1 + 4, str, 0);
		this.b12.drawStringCenter(xPad + widthPad / 2, yPad + heightPad / 2 + 4, str, 0xffffff);
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIII)V")
	private void drawMap(@OriginalArg(0) int left, @OriginalArg(1) int top, @OriginalArg(2) int right, @OriginalArg(3) int bottom, @OriginalArg(4) int widthOffset, @OriginalArg(5) int heightOffset, @OriginalArg(6) int width, @OriginalArg(7) int height) {
		@Pc(5) int visibleX = right - left;
		@Pc(9) int visibleY = bottom - top;
		@Pc(17) int widthRatio = (width - widthOffset << 16) / visibleX;
		@Pc(25) int heightRatio = (height - heightOffset << 16) / visibleY;

		for (@Pc(27) int x = 0; x < visibleX; x++) {
			int startX = widthRatio * x >> 16;
			int endX = widthRatio * (x + 1) >> 16;
			int lengthX = endX - startX;
            if (lengthX <= 0) {
                continue;
            }

            startX += widthOffset;
            endX += widthOffset;

            @Pc(64) int[] colors = this.floormapColors[x + left];
            @Pc(71) int[] overlays = this.overlayTiles[x + left];
            byte[] shapes = this.overlayInfo[x + left];

            for (int y = 0; y < visibleY; y++) {
				int startY = heightRatio * y >> 16;
				int endY = heightRatio * (y + 1) >> 16;
				int lengthY = endY - startY;
                if (lengthY <= 0) {
                    continue;
                }

                startY += heightOffset;
                endY += heightOffset;

				int overlay = overlays[y + top];
                if (overlay == 0) {
                    Draw2D.fillRect(startX, startY, colors[y + top], endX - startX, endY - startY);
                } else {
                    @Pc(140) byte info = shapes[y + top];
					int shape = info & 0xFC;
                    if (shape == 0 || lengthX <= 1 || lengthY <= 1) {
                        Draw2D.fillRect(startX, startY, overlay, lengthX, lengthY);
                    } else {
                        this.drawSmoothEdges(Draw2D.data, startY * Draw2D.width2d + startX, colors[y + top], overlay, lengthX, lengthY, shape >> 2, info & 0x3);
                    }
                }
            }
        }

		if (right - left > width - widthOffset) {
			return;
		}

		int visibleMapFunctionCount = 0;
		for (int x = 0; x < visibleX; x++) {
			int startX = widthRatio * x >> 16;
			int endX = widthRatio * (x + 1) >> 16;
			int lengthX = endX - startX;
            if (lengthX <= 0) {
                continue;
            }

			byte[] walls = this.locWalls[x + left];
			@Pc(238) byte[] mapscenes = this.locMapscenes[x + left];
			@Pc(245) byte[] mapfunctions = this.locMapfunctions[x + left];
			for (int y = 0; y < visibleY; y++) {
				int startY = heightRatio * y >> 16;
				int endY = heightRatio * (y + 1) >> 16;
				@Pc(267) int lengthY = endY - startY;
				if (lengthY <= 0) {
					continue;
				}

				int wall = walls[y + top] & 0xFF;
				if (wall != 0) {
					int edgeX;
					if (lengthX == 1) {
						edgeX = startX;
					} else {
						edgeX = endX - 1;
					}

					int edgeY;
					if (lengthY == 1) {
						edgeY = startY;
					} else {
						edgeY = endY - 1;
					}

					@Pc(303) int rgb = 0xcccccc;
					if (wall >= 5 && wall <= 8 || wall >= 13 && wall <= 16 || wall >= 21 && wall <= 24) {
						rgb = 0xcc0000;
						wall -= 4;
					}
					if (wall == 27 || wall == 28) {
						// bugfix: drawing diagonal doors
						rgb = 0xcc0000;
						wall -= 2;
					}

					if (wall == 1) {
						Draw2D.drawVerticalLine(startX, startY, rgb, lengthY);
					} else if (wall == 2) {
						Draw2D.drawHorizontalLine(startX, startY, rgb, lengthX);
					} else if (wall == 3) {
						Draw2D.drawVerticalLine(edgeX, startY, rgb, lengthY);
					} else if (wall == 4) {
						Draw2D.drawHorizontalLine(startX, edgeY, rgb, lengthX);
					} else if (wall == 9) {
						Draw2D.drawVerticalLine(startX, startY, 0xffffff, lengthY);
						Draw2D.drawHorizontalLine(startX, startY, rgb, lengthX);
					} else if (wall == 10) {
						Draw2D.drawVerticalLine(edgeX, startY, 0xffffff, lengthY);
						Draw2D.drawHorizontalLine(startX, startY, rgb, lengthX);
					} else if (wall == 11) {
						Draw2D.drawVerticalLine(edgeX, startY, 0xffffff, lengthY);
						Draw2D.drawHorizontalLine(startX, edgeY, rgb, lengthX);
					} else if (wall == 12) {
						Draw2D.drawVerticalLine(startX, startY, 0xffffff, lengthY);
						Draw2D.drawHorizontalLine(startX, edgeY, rgb, lengthX);
					} else if (wall == 17) {
						Draw2D.drawHorizontalLine(startX, startY, rgb, 1);
					} else if (wall == 18) {
						Draw2D.drawHorizontalLine(edgeX, startY, rgb, 1);
					} else if (wall == 19) {
						Draw2D.drawHorizontalLine(edgeX, edgeY, rgb, 1);
					} else if (wall == 20) {
						Draw2D.drawHorizontalLine(startX, edgeY, rgb, 1);
					} else if (wall == 25) {
						for (int i = 0; i < lengthY; i++) {
							Draw2D.drawHorizontalLine(startX + i, edgeY - i, rgb, 1);
						}
					} else if (wall == 26) {
						for (int i = 0; i < lengthY; i++) {
							Draw2D.drawHorizontalLine(startX + i, startY + i, rgb, 1);
						}
					}
				}

				int mapscene = mapscenes[y + top] & 0xFF;
				if (mapscene != 0) {
					this.imageMapscene[mapscene - 1].clip(startX - lengthX / 2, startY - lengthY / 2, lengthX * 2, lengthY * 2);
				}

				int mapfunction = mapfunctions[y + top] & 0xFF;
				if (mapfunction != 0) {
					this.visibleMapFunctions[visibleMapFunctionCount] = mapfunction - 1;
					this.visibleMapFunctionsX[visibleMapFunctionCount] = startX + lengthX / 2;
					this.visibleMapFunctionsY[visibleMapFunctionCount] = startY + lengthY / 2;
					visibleMapFunctionCount++;
				}
			}
        }

		for (int x = 0; x < visibleX; x++) {
			int startX = widthRatio * x >> 16;
			int endX = widthRatio * (x + 1) >> 16;
			int lengthX = endX - startX;
			if (lengthX <= 0) {
				continue;
			}

			startX += widthOffset;
			endX += widthOffset;

			boolean[] objs = this.objTiles[x + left];
			for (int y = 0; y < visibleY; y++) {
				int startY = heightRatio * y >> 16;
				int endY = heightRatio * (y + 1) >> 16;
				int lengthY = endY - startY;
				if (lengthY <= 0) {
					continue;
				}

				startY += heightOffset;
				endY += heightOffset;

				if (objs[y + top]) {
					this.imageMapdot0.draw(startX, startY);
				}
			}
		}

		for (int x = 0; x < visibleX; x++) {
			int startX = widthRatio * x >> 16;
			int endX = widthRatio * (x + 1) >> 16;
			int lengthX = endX - startX;
			if (lengthX <= 0) {
				continue;
			}

			startX += widthOffset;
			endX += widthOffset;

			boolean[] npcs = this.npcTiles[x + left];
			for (int y = 0; y < visibleY; y++) {
				int startY = heightRatio * y >> 16;
				int endY = heightRatio * (y + 1) >> 16;
				int lengthY = endY - startY;
				if (lengthY <= 0) {
					continue;
				}

				startY += heightOffset;
				endY += heightOffset;

				if (npcs[y + top]) {
					this.imageMapdot1.draw(startX, startY);
				}
			}
		}

		for (int i = 0; i < visibleMapFunctionCount; i++) {
			this.imageMapfunction[this.visibleMapFunctions[i]].draw(this.visibleMapFunctionsX[i] - 7, this.visibleMapFunctionsY[i] - 7);
		}

		if (this.flashTimer > 0) {
			for (int i = 0; i < visibleMapFunctionCount; i++) {
				if (this.visibleMapFunctions[i] == this.currentKey) {
					this.imageMapfunction[this.visibleMapFunctions[i]].draw(this.visibleMapFunctionsX[i] - 7, this.visibleMapFunctionsY[i] - 7);

					if (this.flashTimer % 10 < 5) {
						Draw2D.fillCircle(this.visibleMapFunctionsX[i], this.visibleMapFunctionsY[i], 15, 0xffff00, 128);
						Draw2D.fillCircle(this.visibleMapFunctionsX[i], this.visibleMapFunctionsY[i], 7, 0xffffff, 256);
					}
				}
			}
		}

        if (this.zoom == this.targetZoom && this.shouldDrawLabels) {
            for (int i = 0; i < this.labelCount; i++) {
				int x = this.labelX[i];
                @Pc(704) int y = this.labelY[i];
                x -= this.originX;
                y = (this.originZ + this.sizeZ) - y;

				int drawX = widthOffset + (width - widthOffset) * (x - left) / (right - left);
				int drawY = heightOffset + (height - heightOffset) * (y - top) / (bottom - top);
				int fontType = this.labelFont[i];
				int rgb = 0xffffff;

                @Pc(746) WorldmapFont font = null;
                if (fontType == 0) {
                    if (this.zoom == 3.0D) {
                        font = this.f11;
                    } else if (this.zoom == 4.0D) {
                        font = this.f12;
                    } else if (this.zoom == 6.0D) {
                        font = this.f14;
                    } else if (this.zoom == 8.0D) {
                        font = this.f17;
                    }
                } else if (fontType == 1) {
                    if (this.zoom == 3.0D) {
                        font = this.f14;
                    } else if (this.zoom == 4.0D) {
                        font = this.f17;
                    } else if (this.zoom == 6.0D) {
                        font = this.f19;
                    } else if (this.zoom == 8.0D) {
                        font = this.f22;
                    }
                } else if (fontType == 2) {
                    rgb = 0xffaa00;

                    if (this.zoom == 3.0D) {
                        font = this.f19;
                    } else if (this.zoom == 4.0D) {
                        font = this.f22;
                    } else if (this.zoom == 6.0D) {
                        font = this.f26;
                    } else if (this.zoom == 8.0D) {
                        font = this.f30;
                    }
                }

                if (font != null) {
                    @Pc(859) String label = this.labelText[i];
					int lineCount = 1;
                    for (int j = 0; j < label.length(); j++) {
                        if (label.charAt(j) == '/') {
                            lineCount++;
                        }
                    }

                    drawY -= font.getHeight() * (lineCount - 1) / 2;
                    drawY += font.getYOffset() / 2;

                    while (true) {
						int newline = label.indexOf("/");
                        if (newline == -1) {
                            font.drawStringCenter(label, drawX, drawY, rgb, true);
                            break;
                        }

                        @Pc(915) String part = label.substring(0, newline);
                        font.drawStringCenter(part, drawX, drawY, rgb, true);

                        drawY += font.getHeight();
                        label = label.substring(newline + 1);
                    }
                }
            }
        }

		if (shouldDrawBorders) {
			for (int mx = this.originX / 64; mx < (this.originX + this.sizeX) / 64; mx++) {
				for (int mz = this.originZ / 64; mz < (this.originZ + this.sizeZ) / 64; mz++) {
					int x = mx * 64;
					int z = mz * 64;
					x -= this.originX;
					z = (this.originZ + this.sizeZ) - z;

					int drawLeft = widthOffset + (width - widthOffset) * (x - left) / (right - left);
					int drawTop = heightOffset + (height - heightOffset) * (z - 64 - top) / (bottom - top);
					int drawRight = widthOffset + (width - widthOffset) * (x + 64 - left) / (right - left);
					int drawBottom = heightOffset + (height - heightOffset) * (z - top) / (bottom - top);

					Draw2D.drawRect(drawLeft, drawTop, 0xffffff, drawRight - drawLeft, drawBottom - drawTop);
					this.b12.drawStringRight(drawRight - 5, drawBottom - 5, mx + "_" + mz, 0xffffff, false);

					if (mx == 33 && mz >= 71 && mz <= 73) {
						this.b12.drawStringCenter((drawRight + drawLeft) / 2, (drawBottom + drawTop) / 2, "u_pass", 0xff0000);
					} else if (mx >= 32 && mx <= 34 && mz >= 70 && mz <= 74) {
						this.b12.drawStringCenter((drawRight + drawLeft) / 2, (drawBottom + drawTop) / 2, "u_pass", 0xffff00);
					}
				}
			}
		}
    }

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([IIIIIIII)V")
	private void drawSmoothEdges(@OriginalArg(0) int[] data, @OriginalArg(1) int off, @OriginalArg(2) int color, @OriginalArg(3) int overlay, @OriginalArg(4) int width, @OriginalArg(5) int height, @OriginalArg(6) int shape, @OriginalArg(7) int rotation) {
		@Pc(5) int step = Draw2D.width2d - width;
		if (shape == 9) {
			shape = 1;
			rotation = rotation + 1 & 0x3;
		} else if (shape == 10) {
			shape = 1;
			rotation = rotation + 3 & 0x3;
		} else if (shape == 11) {
			shape = 8;
			rotation = rotation + 3 & 0x3;
		}

		if (shape == 1) {
			if (rotation == 0) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x <= y) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x <= y) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x >= y) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x >= y) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		} else if (shape == 2) {
			if (rotation == 0) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x <= y >> 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x >= y << 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = 0; y < height; y++) {
					for (int x = width - 1; x >= 0; x--) {
						if (x <= y >> 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = width - 1; x >= 0; x--) {
						if (x >= y << 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		} else if (shape == 3) {
			if (rotation == 0) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = width - 1; x >= 0; x--) {
						if (x <= y >> 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x >= y << 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x <= y >> 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = 0; y < height; y++) {
					for (int x = width - 1; x >= 0; x--) {
						if (x >= y << 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		} else if (shape == 4) {
			if (rotation == 0) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x >= y >> 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x <= y << 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = 0; y < height; y++) {
					for (int x = width - 1; x >= 0; x--) {
						if (x >= y >> 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = width - 1; x >= 0; x--) {
						if (x <= y << 1) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		} else if (shape == 5) {
            if (rotation == 0) {
                for (int y = height - 1; y >= 0; y--) {
                    for (int x = width - 1; x >= 0; x--) {
                        if (x >= y >> 1) {
                            data[off++] = overlay;
                        } else {
                            data[off++] = color;
                        }
                    }
                    off += step;
                }
            } else if (rotation == 1) {
                for (int y = height - 1; y >= 0; y--) {
                    for (int x = 0; x < width; x++) {
                        if (x <= y << 1) {
                            data[off++] = overlay;
                        } else {
                            data[off++] = color;
                        }
                    }
                    off += step;
                }
            } else if (rotation == 2) {
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        if (x >= y >> 1) {
                            data[off++] = overlay;
                        } else {
                            data[off++] = color;
                        }
                    }
                    off += step;
                }
            } else if (rotation == 3) {
                for (int y = 0; y < height; y++) {
                    for (int x = width - 1; x >= 0; x--) {
                        if (x <= y << 1) {
                            data[off++] = overlay;
                        } else {
                            data[off++] = color;
                        }
                    }
                    off += step;
                }
            }
        } else if (shape == 6) {
			if (rotation == 0) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x <= width / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (y <= height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x >= width / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (y >= height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		} else if (shape == 7) {
			if (rotation == 0) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x <= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x <= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = width - 1; x >= 0; x--) {
						if (x <= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = 0; y < height; y++) {
					for (int x = width - 1; x >= 0; x--) {
						if (x <= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		} else if (shape == 8) {
			if (rotation == 0) {
				for (int y = 0; y < height; y++) {
					for (int x = 0; x < width; x++) {
						if (x >= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 1) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = 0; x < width; x++) {
						if (x >= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 2) {
				for (int y = height - 1; y >= 0; y--) {
					for (int x = width - 1; x >= 0; x--) {
						if (x >= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			} else if (rotation == 3) {
				for (int y = 0; y < height; y++) {
					for (int x = width - 1; x >= 0; x--) {
						if (x >= y - height / 2) {
							data[off++] = overlay;
						} else {
							data[off++] = color;
						}
					}
					off += step;
				}
			}
		}
    }

	@OriginalMember(owner = "mapview!mapview", name = "i", descriptor = "()Lmapview!p;")
	private Jagfile loadWorldmap() {
		@Pc(3) String cachedir = null;
		@Pc(17) byte[] data;
		try {
			cachedir = this.findcachedir();
			data = this.cacheload(cachedir + "/worldmap.dat");
			if (!this.checksha(data)) {
				data = null;
			}
			if (data != null) {
				return new Jagfile(data);
			}
		} catch (@Pc(31) Throwable ignore) {
		}

		data = this.updateWorldmap();
		if (cachedir != null && data != null) {
			try {
				this.cachesave(cachedir + "/worldmap.dat", data);
			} catch (@Pc(51) Throwable ignore) {
			}
		}

		return new Jagfile(data);
	}

	@OriginalMember(owner = "mapview!mapview", name = "j", descriptor = "()[B")
	private byte[] updateWorldmap() {
		System.out.println("Updating");
		this.drawProgress("Requesting map", 0);

		try {
			@Pc(10) String uriSha = "";
			for (@Pc(12) int i = 0; i < 10; i++) {
				uriSha += sig.sha[i];
			}

			@Pc(40) DataInputStream stream;
			if (super.frame == null) {
				stream = new DataInputStream((new URL(this.getCodeBase(), "worldmap" + uriSha + ".jag")).openStream());
			} else {
				stream = new DataInputStream(new FileInputStream("worldmap.jag"));
			}

			@Pc(63) int lastProgress = 0;
			@Pc(65) int offset = 0;
			@Pc(67) int length = sig.len;
			@Pc(70) byte[] data = new byte[length];
			while (offset < length) {
				@Pc(76) int remaining = length - offset;
				if (remaining > 1000) {
					remaining = 1000;
				}

				@Pc(87) int read = stream.read(data, offset, remaining);
				if (read < 0) {
					throw new IOException("EOF");
				}

				offset += read;

				@Pc(104) int progress = offset * 100 / length;
				if (progress != lastProgress) {
					this.drawProgress("Loading map - " + progress + "%", progress);
				}

				lastProgress = progress;
			}

			stream.close();
			return data;
		} catch (@Pc(129) IOException ex) {
			System.out.println("Error loading");
			ex.printStackTrace();
			return null;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "k", descriptor = "()Ljava/lang/String;")
	private String findcachedir() {
		@Pc(50) String[] paths = new String[] {
			"c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/",
			"~/", "/tmp/", ""
		};
		@Pc(52) String store = ".file_store_32";

		for (@Pc(54) int i = 0; i < paths.length; i++) {
			try {
				@Pc(60) String dir = paths[i];
				@Pc(68) File cache;

				if (dir.length() > 0) {
					cache = new File(dir);

					if (!cache.exists()) {
						continue;
					}
				}

				cache = new File(dir + store);
				if (cache.exists() || cache.mkdir()) {
					return dir + store + "/";
				}
			} catch (@Pc(103) Exception ignore) {
			}
		}

		return null;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(Ljava/lang/String;)[B")
	private byte[] cacheload(@OriginalArg(0) String name) throws IOException {
		@Pc(4) File file = new File(name);
		if (!file.exists()) {
			return null;
		}

		@Pc(13) int length = (int) file.length();
		@Pc(16) byte[] data = new byte[length];
		@Pc(27) DataInputStream stream = new DataInputStream(new BufferedInputStream(new FileInputStream(name)));
		stream.readFully(data, 0, length);
		stream.close();
		return data;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(Ljava/lang/String;[B)V")
	private void cachesave(@OriginalArg(0) String name, @OriginalArg(1) byte[] data) throws IOException {
		@Pc(4) FileOutputStream stream = new FileOutputStream(name);
		stream.write(data, 0, data.length);
		stream.close();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B)Z")
	private boolean checksha(@OriginalArg(0) byte[] data) throws Exception {
		if (data == null) {
			return false;
		}

		@Pc(6) MessageDigest shaDigest = MessageDigest.getInstance("SHA");
		shaDigest.reset();
		shaDigest.update(data);

		@Pc(14) byte[] computedSha = shaDigest.digest();
		for (@Pc(16) int i = 0; i < 20; i++) {
			if (computedSha[i] != sig.sha[i]) {
				return false;
			}
		}

		return true;
	}
}
