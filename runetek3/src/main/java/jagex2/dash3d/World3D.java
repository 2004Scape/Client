package jagex2.dash3d;

import jagex2.dash3d.entity.Entity;
import jagex2.dash3d.type.*;
import jagex2.datastruct.LinkList;
import jagex2.graphics.Draw2D;
import jagex2.graphics.Draw3D;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// World3D: Renders the world into 3D space
@OriginalClass("client!r")
public final class World3D {

	@OriginalMember(owner = "client!r", name = "h", descriptor = "Z")
	public static boolean lowMemory = true;

	@OriginalMember(owner = "client!r", name = "i", descriptor = "I")
	private final int maxLevel;

	@OriginalMember(owner = "client!r", name = "j", descriptor = "I")
	private final int maxTileX;

	@OriginalMember(owner = "client!r", name = "k", descriptor = "I")
	private final int maxTileZ;

	@OriginalMember(owner = "client!r", name = "l", descriptor = "[[[I")
	private final int[][][] levelHeightmaps;

	@OriginalMember(owner = "client!r", name = "m", descriptor = "[[[Lclient!cb;")
	private final Tile[][][] levelTiles;

	@OriginalMember(owner = "client!r", name = "n", descriptor = "I")
	private int minLevel;

	@OriginalMember(owner = "client!r", name = "o", descriptor = "I")
	private int temporaryLocCount;

	@OriginalMember(owner = "client!r", name = "p", descriptor = "[Lclient!p;")
	private final Loc[] temporaryLocs = new Loc[5000];

	@OriginalMember(owner = "client!r", name = "q", descriptor = "[[[I")
	private final int[][][] levelTileOcclusionCycles;

	@OriginalMember(owner = "client!r", name = "r", descriptor = "I")
	public static int tilesRemaining;

	@OriginalMember(owner = "client!r", name = "s", descriptor = "I")
	public static int topLevel;

	@OriginalMember(owner = "client!r", name = "t", descriptor = "I")
	public static int cycle;

	@OriginalMember(owner = "client!r", name = "u", descriptor = "I")
	public static int minDrawTileX;

	@OriginalMember(owner = "client!r", name = "v", descriptor = "I")
	public static int maxDrawTileX;

	@OriginalMember(owner = "client!r", name = "w", descriptor = "I")
	public static int minDrawTileZ;

	@OriginalMember(owner = "client!r", name = "x", descriptor = "I")
	public static int maxDrawTileZ;

	@OriginalMember(owner = "client!r", name = "y", descriptor = "I")
	public static int eyeTileX;

	@OriginalMember(owner = "client!r", name = "z", descriptor = "I")
	public static int eyeTileZ;

	@OriginalMember(owner = "client!r", name = "A", descriptor = "I")
	public static int eyeX;

	@OriginalMember(owner = "client!r", name = "B", descriptor = "I")
	public static int eyeY;

	@OriginalMember(owner = "client!r", name = "C", descriptor = "I")
	public static int eyeZ;

	@OriginalMember(owner = "client!r", name = "D", descriptor = "I")
	public static int sinEyePitch;

	@OriginalMember(owner = "client!r", name = "E", descriptor = "I")
	public static int cosEyePitch;

	@OriginalMember(owner = "client!r", name = "F", descriptor = "I")
	public static int sinEyeYaw;

	@OriginalMember(owner = "client!r", name = "G", descriptor = "I")
	public static int cosEyeYaw;

	@OriginalMember(owner = "client!r", name = "H", descriptor = "[Lclient!p;")
	public static Loc[] locBuffer = new Loc[100];

	@OriginalMember(owner = "client!r", name = "I", descriptor = "[I")
	public static final int[] WALL_DECORATION_INSET_X = new int[] { 53, -53, -53, 53 };

	@OriginalMember(owner = "client!r", name = "J", descriptor = "[I")
	public static final int[] WALL_DECORATION_INSET_Z = new int[] { -53, -53, 53, 53 };

	@OriginalMember(owner = "client!r", name = "K", descriptor = "[I")
	public static final int[] WALL_DECORATION_OUTSET_X = new int[] { -45, 45, 45, -45 };

	@OriginalMember(owner = "client!r", name = "L", descriptor = "[I")
	public static final int[] WALL_DECORATION_OUTSET_Z = new int[] { 45, 45, -45, -45 };

	@OriginalMember(owner = "client!r", name = "M", descriptor = "Z")
	public static boolean takingInput;

	@OriginalMember(owner = "client!r", name = "N", descriptor = "I")
	public static int mouseX;

	@OriginalMember(owner = "client!r", name = "O", descriptor = "I")
	public static int mouseY;

	@OriginalMember(owner = "client!r", name = "P", descriptor = "I")
	public static int clickTileX = -1;

	@OriginalMember(owner = "client!r", name = "Q", descriptor = "I")
	public static int clickTileZ = -1;

	@OriginalMember(owner = "client!r", name = "R", descriptor = "I")
	public static final int LEVEL_COUNT = 4;

	@OriginalMember(owner = "client!r", name = "S", descriptor = "[I")
	public static int[] levelOccluderCount = new int[LEVEL_COUNT];

	@OriginalMember(owner = "client!r", name = "T", descriptor = "[[Lclient!m;")
	public static Occluder[][] levelOccluders = new Occluder[LEVEL_COUNT][1000];

	@OriginalMember(owner = "client!r", name = "U", descriptor = "I")
	public static int activeOccluderCount;

	@OriginalMember(owner = "client!r", name = "V", descriptor = "[Lclient!m;")
	public static final Occluder[] activeOccluders = new Occluder[500];

	@OriginalMember(owner = "client!r", name = "W", descriptor = "Lclient!ob;")
	public static LinkList drawTileQueue = new LinkList();

	@OriginalMember(owner = "client!r", name = "X", descriptor = "[I")
	public static final int[] FRONT_WALL_TYPES = new int[] { 19, 55, 38, 155, 255, 110, 137, 205, 76 };

	@OriginalMember(owner = "client!r", name = "Y", descriptor = "[I")
	public static final int[] DIRECTION_ALLOW_WALL_CORNER_TYPE = new int[] { 160, 192, 80, 96, 0, 144, 80, 48, 160 };

	@OriginalMember(owner = "client!r", name = "Z", descriptor = "[I")
	public static final int[] BACK_WALL_TYPES = new int[] { 76, 8, 137, 4, 0, 1, 38, 2, 19 };

	@OriginalMember(owner = "client!r", name = "ab", descriptor = "[I")
	public static final int[] WALL_CORNER_TYPE_16_BLOCK_LOC_SPANS = new int[] { 0, 0, 2, 0, 0, 2, 1, 1, 0 };

	@OriginalMember(owner = "client!r", name = "bb", descriptor = "[I")
	public static final int[] WALL_CORNER_TYPE_32_BLOCK_LOC_SPANS = new int[] { 2, 0, 0, 2, 0, 0, 0, 4, 4 };

	@OriginalMember(owner = "client!r", name = "cb", descriptor = "[I")
	public static final int[] WALL_CORNER_TYPE_64_BLOCK_LOC_SPANS = new int[] { 0, 4, 4, 8, 0, 0, 8, 0, 0 };

	@OriginalMember(owner = "client!r", name = "db", descriptor = "[I")
	public static final int[] WALL_CORNER_TYPE_128_BLOCK_LOC_SPANS = new int[] { 1, 1, 0, 0, 0, 8, 0, 0, 8 };

	@OriginalMember(owner = "client!r", name = "eb", descriptor = "[I")
	public static final int[] TEXTURE_HSL = new int[] { 41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 43086, 41, 41, 41, 41, 41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 41, 5056, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 3131, 41, 41, 41 };

	@OriginalMember(owner = "client!r", name = "fb", descriptor = "[I")
	private final int[] mergeIndexA = new int[10000];

	@OriginalMember(owner = "client!r", name = "gb", descriptor = "[I")
	private final int[] mergeIndexB = new int[10000];

	@OriginalMember(owner = "client!r", name = "hb", descriptor = "I")
	private int tmpMergeIndex;
	@OriginalMember(owner = "client!r", name = "ib", descriptor = "[[I")
	private final int[][] MINIMAP_TILE_MASK = new int[][] { new int[16], { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 }, { 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 } };

	@OriginalMember(owner = "client!r", name = "jb", descriptor = "[[I")
	private final int[][] MINIMAP_TILE_ROTATION_MAP = new int[][] { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 }, { 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 }, { 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, { 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 } };

	@OriginalMember(owner = "client!r", name = "kb", descriptor = "[[[[Z")
	public static boolean[][][][] visibilityMatrix = new boolean[8][32][51][51];

	@OriginalMember(owner = "client!r", name = "lb", descriptor = "[[Z")
	public static boolean[][] visibilityMap;

	@OriginalMember(owner = "client!r", name = "mb", descriptor = "I")
	private static int viewportCenterX;

	@OriginalMember(owner = "client!r", name = "nb", descriptor = "I")
	private static int viewportCenterY;

	@OriginalMember(owner = "client!r", name = "ob", descriptor = "I")
	private static int viewportLeft;

	@OriginalMember(owner = "client!r", name = "pb", descriptor = "I")
	private static int viewportTop;

	@OriginalMember(owner = "client!r", name = "qb", descriptor = "I")
	private static int viewportRight;

	@OriginalMember(owner = "client!r", name = "rb", descriptor = "I")
	private static int viewportBottom;

	@OriginalMember(owner = "client!r", name = "<init>", descriptor = "(I[[[IIII)V")
	public World3D(@OriginalArg(1) int[][][] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		this.maxLevel = arg3;
		this.maxTileX = arg4;
		this.maxTileZ = arg2;
		this.levelTiles = new Tile[arg3][arg4][arg2];
		this.levelTileOcclusionCycles = new int[arg3][arg4 + 1][arg2 + 1];
		this.levelHeightmaps = arg1;
		this.reset();
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Z)V")
	public static void unload() {
		locBuffer = null;
		levelOccluderCount = null;
		levelOccluders = null;
		drawTileQueue = null;
		visibilityMatrix = null;
		visibilityMap = null;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIII)V")
	public static void addOccluder(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(3) Occluder local3 = new Occluder();
		local3.minTileX = arg1 / 128;
		local3.maxTileX = arg5 / 128;
		local3.minTileZ = arg8 / 128;
		local3.maxTileZ = arg0 / 128;
		local3.type = arg4;
		local3.minX = arg1;
		local3.maxX = arg5;
		local3.minZ = arg8;
		local3.maxZ = arg0;
		local3.minY = arg7;
		local3.maxY = arg3;
		levelOccluders[arg6][levelOccluderCount[arg6]++] = local3;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "([IIIBII)V")
	public static void init(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		viewportLeft = 0;
		viewportTop = 0;
		viewportRight = arg2;
		viewportBottom = arg4;
		viewportCenterX = arg2 / 2;
		viewportCenterY = arg4 / 2;
		@Pc(28) boolean[][][][] local28 = new boolean[9][32][53][53];
		@Pc(34) int local34;
		@Pc(58) int local58;
		@Pc(62) int local62;
		@Pc(64) int local64;
		@Pc(74) int local74;
		@Pc(78) int local78;
		for (@Pc(30) int local30 = 128; local30 <= 384; local30 += 32) {
			for (local34 = 0; local34 < 2048; local34 += 64) {
				sinEyePitch = Model.sin[local30];
				cosEyePitch = Model.cos[local30];
				sinEyeYaw = Model.sin[local34];
				cosEyeYaw = Model.cos[local34];
				local58 = (local30 - 128) / 32;
				local62 = local34 / 64;
				for (local64 = -26; local64 <= 26; local64++) {
					for (@Pc(68) int local68 = -26; local68 <= 26; local68++) {
						local74 = local64 * 128;
						local78 = local68 * 128;
						@Pc(80) boolean local80 = false;
						for (@Pc(83) int local83 = -arg5; local83 <= arg1; local83 += 128) {
							if (testPoint(local74, local78, arg0[local58] + local83)) {
								local80 = true;
								break;
							}
						}
						local28[local58][local62][local64 + 25 + 1][local68 + 25 + 1] = local80;
					}
				}
			}
		}
		for (local34 = 0; local34 < 8; local34++) {
			for (local58 = 0; local58 < 32; local58++) {
				for (local62 = -25; local62 < 25; local62++) {
					for (local64 = -25; local64 < 25; local64++) {
						@Pc(155) boolean local155 = false;
						label83: for (local74 = -1; local74 <= 1; local74++) {
							for (local78 = -1; local78 <= 1; local78++) {
								if (local28[local34][local58][local62 + local74 + 25 + 1][local64 + local78 + 25 + 1]) {
									local155 = true;
									break label83;
								}
								if (local28[local34][(local58 + 1) % 31][local62 + local74 + 25 + 1][local64 + local78 + 25 + 1]) {
									local155 = true;
									break label83;
								}
								if (local28[local34 + 1][local58][local62 + local74 + 25 + 1][local64 + local78 + 25 + 1]) {
									local155 = true;
									break label83;
								}
								if (local28[local34 + 1][(local58 + 1) % 31][local62 + local74 + 25 + 1][local64 + local78 + 25 + 1]) {
									local155 = true;
									break label83;
								}
							}
						}
						visibilityMatrix[local34][local58][local62 + 25][local64 + 25] = local155;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "h", descriptor = "(IIII)Z")
	private static boolean testPoint(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(11) int local11 = arg1 * sinEyeYaw + arg0 * cosEyeYaw >> 16;
		@Pc(21) int local21 = arg1 * cosEyeYaw - arg0 * sinEyeYaw >> 16;
		@Pc(31) int local31 = arg2 * sinEyePitch + local21 * cosEyePitch >> 16;
		@Pc(41) int local41 = arg2 * cosEyePitch - local21 * sinEyePitch >> 16;
		@Pc(45) int local45;
		if (local31 < 50 || local31 > 3500) {
			return false;
		}
		local45 = viewportCenterX + (local11 << 9) / local31;
		@Pc(76) int local76 = viewportCenterY + (local41 << 9) / local31;
		if (local45 >= viewportLeft && local45 <= viewportRight && local76 >= viewportTop && local76 <= viewportBottom) {
			return true;
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(I)V")
	public void reset() {
		@Pc(7) int local7;
		@Pc(11) int local11;
		for (@Pc(3) int local3 = 0; local3 < this.maxLevel; local3++) {
			for (local7 = 0; local7 < this.maxTileX; local7++) {
				for (local11 = 0; local11 < this.maxTileZ; local11++) {
					this.levelTiles[local3][local7][local11] = null;
				}
			}
		}
		for (local7 = 0; local7 < LEVEL_COUNT; local7++) {
			for (local11 = 0; local11 < levelOccluderCount[local7]; local11++) {
				levelOccluders[local7][local11] = null;
			}
			levelOccluderCount[local7] = 0;
		}
		for (local11 = 0; local11 < this.temporaryLocCount; local11++) {
			this.temporaryLocs[local11] = null;
		}
		this.temporaryLocCount = 0;
		for (@Pc(88) int local88 = 0; local88 < locBuffer.length; local88++) {
			locBuffer[local88] = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(II)V")
	public void setMinLevel(@OriginalArg(1) int arg1) {
		this.minLevel = arg1;
		@Pc(10) int local10;
		for (@Pc(6) int local6 = 0; local6 < this.maxTileX; local6++) {
			for (local10 = 0; local10 < this.maxTileZ; local10++) {
				this.levelTiles[arg1][local6][local10] = new Tile(arg1, local6, local10);
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIB)V")
	public void setBridge(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(10) Tile local10 = this.levelTiles[0][arg1][arg0];
		for (@Pc(12) int local12 = 0; local12 < 3; local12++) {
			this.levelTiles[local12][arg1][arg0] = this.levelTiles[local12 + 1][arg1][arg0];
			if (this.levelTiles[local12][arg1][arg0] != null) {
				this.levelTiles[local12][arg1][arg0].level--;
			}
		}
		if (this.levelTiles[0][arg1][arg0] == null) {
			this.levelTiles[0][arg1][arg0] = new Tile(0, arg1, arg0);
		}
		this.levelTiles[0][arg1][arg0].bridge = local10;
		this.levelTiles[3][arg1][arg0] = null;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIII)V")
	public void setDrawLevel(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg1][arg2];
		if (local8 != null) {
			this.levelTiles[arg0][arg1][arg2].drawLevel = arg3;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIIIIIIIIIIIIII)V")
	public void setTile(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13, @OriginalArg(14) int arg14, @OriginalArg(15) int arg15, @OriginalArg(16) int arg16, @OriginalArg(17) int arg17, @OriginalArg(18) int arg18, @OriginalArg(19) int arg19) {
		@Pc(14) TileUnderlay local14;
		@Pc(16) int local16;
		if (arg3 == 0) {
			local14 = new TileUnderlay(arg10, arg11, arg12, arg13, -1, arg18, false);
			for (local16 = arg0; local16 >= 0; local16--) {
				if (this.levelTiles[local16][arg1][arg2] == null) {
					this.levelTiles[local16][arg1][arg2] = new Tile(local16, arg1, arg2);
				}
			}
			this.levelTiles[arg0][arg1][arg2].underlay = local14;
		} else if (arg3 == 1) {
			local14 = new TileUnderlay(arg14, arg15, arg16, arg17, arg5, arg19, arg6 == arg7 && arg6 == arg8 && arg6 == arg9);
			for (local16 = arg0; local16 >= 0; local16--) {
				if (this.levelTiles[local16][arg1][arg2] == null) {
					this.levelTiles[local16][arg1][arg2] = new Tile(local16, arg1, arg2);
				}
			}
			this.levelTiles[arg0][arg1][arg2].underlay = local14;
		} else {
			@Pc(145) TileOverlay local145 = new TileOverlay(arg1, arg3, arg15, arg7, arg12, arg4, arg10, arg9, arg19, arg14, arg5, arg17, arg18, arg8, arg16, arg13, arg6, arg2, arg11);
			for (local16 = arg0; local16 >= 0; local16--) {
				if (this.levelTiles[local16][arg1][arg2] == null) {
					this.levelTiles[local16][arg1][arg2] = new Tile(local16, arg1, arg2);
				}
			}
			this.levelTiles[arg0][arg1][arg2].overlay = local145;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;BIIIIBI)V")
	public void addGroundDecoration(@OriginalArg(0) Model arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) byte arg6, @OriginalArg(7) int arg7) {
		@Pc(3) GroundDecoration local3 = new GroundDecoration();
		local3.model = arg0;
		local3.x = arg2 * 128 + 64;
		local3.z = arg4 * 128 + 64;
		local3.y = arg7;
		local3.bitset = arg3;
		local3.info = arg6;
		if (this.levelTiles[arg5][arg2][arg4] == null) {
			this.levelTiles[arg5][arg2][arg4] = new Tile(arg5, arg2, arg4);
		}
		this.levelTiles[arg5][arg2][arg4].groundDecoration = local3;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IIIIILclient!eb;I)V")
	public void addObjStack(@OriginalArg(0) Model arg0, @OriginalArg(1) Model arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) Model arg7) {
		@Pc(3) GroundObj local3 = new GroundObj();
		local3.topObj = arg0;
		local3.x = arg6 * 128 + 64;
		local3.z = arg5 * 128 + 64;
		local3.y = arg2;
		local3.bitset = arg4;
		local3.middleObj = arg1;
		local3.bottomObj = arg7;
		@Pc(38) int local38 = 0;
		@Pc(47) Tile local47 = this.levelTiles[arg3][arg6][arg5];
		if (local47 != null) {
			for (@Pc(51) int local51 = 0; local51 < local47.locCount; local51++) {
				@Pc(60) int local60 = local47.locs[local51].model.objRaise;
				if (local60 > local38) {
					local38 = local60;
				}
			}
		}
		local3.offset = local38;
		if (this.levelTiles[arg3][arg6][arg5] == null) {
			this.levelTiles[arg3][arg6][arg5] = new Tile(arg3, arg6, arg5);
		}
		this.levelTiles[arg3][arg6][arg5].groundObj = local3;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIILclient!eb;Lclient!eb;IIIB)V")
	public void addWall(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) Model arg5, @OriginalArg(6) Model arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) byte arg10) {
		if (arg5 != null || arg6 != null) {
			@Pc(8) Wall local8 = new Wall();
			local8.bitset = arg8;
			local8.info = arg10;
			local8.x = arg7 * 128 + 64;
			local8.z = arg9 * 128 + 64;
			local8.y = arg1;
			local8.modelA = arg5;
			local8.modelB = arg6;
			local8.typeA = arg3;
			local8.typeB = arg0;
			for (@Pc(54) int local54 = arg2; local54 >= 0; local54--) {
				if (this.levelTiles[local54][arg7][arg9] == null) {
					this.levelTiles[local54][arg7][arg9] = new Tile(local54, arg7, arg9);
				}
			}
			this.levelTiles[arg2][arg7][arg9].wall = local8;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIIILclient!eb;BI)V")
	public void setWallDecoration(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) Model arg9, @OriginalArg(10) byte arg10, @OriginalArg(11) int arg11) {
		if (arg9 != null) {
			@Pc(10) WallDecoration local10 = new WallDecoration();
			local10.bitset = arg3;
			local10.info = arg10;
			local10.x = arg8 * 128 + arg7 + 64;
			local10.z = arg1 * 128 + arg2 + 64;
			local10.y = arg0;
			local10.model = arg9;
			local10.type = arg5;
			local10.orientation = arg4;
			for (@Pc(48) int local48 = arg11; local48 >= 0; local48--) {
				if (this.levelTiles[local48][arg8][arg1] == null) {
					this.levelTiles[local48][arg8][arg1] = new Tile(local48, arg8, arg1);
				}
			}
			this.levelTiles[arg11][arg8][arg1].wallDecoration = local10;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILclient!w;IIIIBLclient!eb;II)Z")
	public boolean addLoc(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) Entity arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) byte arg8, @OriginalArg(9) Model arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
		if (arg9 == null && arg3 == null) {
			return true;
		} else {
			@Pc(17) int local17 = arg6 * 128 + arg7 * 64;
			@Pc(25) int local25 = arg5 * 128 + arg11 * 64;
			return this.addLoc(arg2, arg6, arg5, arg7, arg11, local17, local25, arg0, arg9, arg3, arg10, false, arg4, arg8);
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIZLclient!eb;Lclient!w;II)Z")
	public boolean addTemporary(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6, @OriginalArg(7) Model arg7, @OriginalArg(8) Entity arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10) {
		if (arg7 == null && arg8 == null) {
			return true;
		}
		@Pc(9) int local9 = arg4 - arg2;
		@Pc(13) int local13 = arg1 - arg2;
		@Pc(17) int local17 = arg4 + arg2;
		@Pc(21) int local21 = arg1 + arg2;
		if (arg6) {
			if (arg3 > 640 && arg3 < 1408) {
				local21 += 128;
			}
			if (arg3 > 1152 && arg3 < 1920) {
				local17 += 128;
			}
			if (arg3 > 1664 || arg3 < 384) {
				local13 -= 128;
			}
			if (arg3 > 128 && arg3 < 896) {
				local9 -= 128;
			}
		}
		local9 /= 128;
		local13 /= 128;
		local17 /= 128;
		local21 /= 128;
		return this.addLoc(arg10, local9, local13, local17 + 1 - local9, local21 - local13 + 1, arg4, arg1, arg9, arg7, arg8, arg3, true, arg5, (byte) 0);
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IILclient!eb;IIIIIILclient!w;ZIII)Z")
	public boolean addTemporary(@OriginalArg(0) int arg0, @OriginalArg(2) Model arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) Entity arg9, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13) {
		return arg2 == null && arg9 == null ? true : this.addLoc(arg11, arg8, arg7, arg0 + 1 - arg8, arg12 - arg7 + 1, arg13, arg3, arg4, arg2, arg9, arg6, true, arg5, (byte) 0);
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIILclient!eb;Lclient!w;IZIB)Z")
	private boolean addLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) Model arg8, @OriginalArg(9) Entity arg9, @OriginalArg(10) int arg10, @OriginalArg(11) boolean arg11, @OriginalArg(12) int arg12, @OriginalArg(13) byte arg13) {
		if (arg8 == null && arg9 == null) {
			return false;
		}
		for (@Pc(9) int local9 = arg1; local9 < arg1 + arg3; local9++) {
			for (@Pc(13) int local13 = arg2; local13 < arg2 + arg4; local13++) {
				if (local9 < 0 || local13 < 0 || local9 >= this.maxTileX || local13 >= this.maxTileZ) {
					return false;
				}
				@Pc(38) Tile local38 = this.levelTiles[arg0][local9][local13];
				if (local38 != null && local38.locCount >= 5) {
					return false;
				}
			}
		}
		@Pc(62) Loc local62 = new Loc();
		local62.bitset = arg12;
		local62.info = arg13;
		local62.level = arg0;
		local62.x = arg5;
		local62.z = arg6;
		local62.y = arg7;
		local62.model = arg8;
		local62.entity = arg9;
		local62.yaw = arg10;
		local62.minSceneTileX = arg1;
		local62.minSceneTileZ = arg2;
		local62.maxSceneTileX = arg1 + arg3 - 1;
		local62.maxSceneTileZ = arg2 + arg4 - 1;
		for (@Pc(111) int local111 = arg1; local111 < arg1 + arg3; local111++) {
			for (@Pc(115) int local115 = arg2; local115 < arg2 + arg4; local115++) {
				@Pc(119) int local119 = 0;
				if (local111 > arg1) {
					local119++;
				}
				if (local111 < arg1 + arg3 - 1) {
					local119 += 4;
				}
				if (local115 > arg2) {
					local119 += 8;
				}
				if (local115 < arg2 + arg4 - 1) {
					local119 += 2;
				}
				for (@Pc(145) int local145 = arg0; local145 >= 0; local145--) {
					if (this.levelTiles[local145][local111][local115] == null) {
						this.levelTiles[local145][local111][local115] = new Tile(local145, local111, local115);
					}
				}
				@Pc(182) Tile local182 = this.levelTiles[arg0][local111][local115];
				local182.locs[local182.locCount] = local62;
				local182.locSpan[local182.locCount] = local119;
				local182.locSpans |= local119;
				local182.locCount++;
			}
		}
		if (arg11) {
			this.temporaryLocs[this.temporaryLocCount++] = local62;
		}
		return true;
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(I)V")
	public void clearTemporaryLocs() {
		for (@Pc(1) int local1 = 0; local1 < this.temporaryLocCount; local1++) {
			@Pc(8) Loc local8 = this.temporaryLocs[local1];
			this.removeLoc(local8);
			this.temporaryLocs[local1] = null;
		}
		this.temporaryLocCount = 0;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!p;B)V")
	private void removeLoc(@OriginalArg(0) Loc arg0) {
		for (@Pc(4) int local4 = arg0.minSceneTileX; local4 <= arg0.maxSceneTileX; local4++) {
			for (@Pc(9) int local9 = arg0.minSceneTileZ; local9 <= arg0.maxSceneTileZ; local9++) {
				@Pc(21) Tile local21 = this.levelTiles[arg0.level][local4][local9];
				if (local21 != null) {
					@Pc(41) int local41;
					for (@Pc(25) int local25 = 0; local25 < local21.locCount; local25++) {
						if (local21.locs[local25] == arg0) {
							local21.locCount--;
							for (local41 = local25; local41 < local21.locCount; local41++) {
								local21.locs[local41] = local21.locs[local41 + 1];
								local21.locSpan[local41] = local21.locSpan[local41 + 1];
							}
							local21.locs[local21.locCount] = null;
							break;
						}
					}
					local21.locSpans = 0;
					for (local41 = 0; local41 < local21.locCount; local41++) {
						local21.locSpans |= local21.locSpan[local41];
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(ILclient!eb;III)V")
	public void setLocModel(@OriginalArg(0) int arg0, @OriginalArg(1) Model arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg1 != null) {
			@Pc(13) Tile local13 = this.levelTiles[arg3][arg0][arg4];
			@Pc(21) int local21;
			if (local13 != null) {
				for (local21 = 0; local21 < local13.locCount; local21++) {
					@Pc(38) Loc local38 = local13.locs[local21];
					if ((local38.bitset >> 29 & 0x3) == 2) {
						local38.model = arg1;
						return;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIB)V")
	public void setWallDecorationOffset(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg2][arg1];
		if (local8 != null) {
			@Pc(24) WallDecoration local24 = local8.wallDecoration;
			if (local24 != null) {
				@Pc(33) int local33 = arg2 * 128 + 64;
				@Pc(39) int local39 = arg1 * 128 + 64;
				local24.x = local33 + (local24.x - local33) * arg3 / 16;
				local24.z = local39 + (local24.z - local39) * arg3 / 16;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILclient!eb;I)V")
	public void setWallDecorationModel(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Model arg3, @OriginalArg(4) int arg4) {
		if (arg3 != null) {
			@Pc(15) Tile local15 = this.levelTiles[arg4][arg2][arg1];
			if (local15 != null) {
				@Pc(21) WallDecoration local21 = local15.wallDecoration;
				if (local21 != null) {
					local21.model = arg3;
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;IIII)V")
	public void setGroundDecorationModel(@OriginalArg(0) Model arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg0 != null) {
			@Pc(15) Tile local15 = this.levelTiles[arg4][arg3][arg1];
			if (local15 != null) {
				@Pc(21) GroundDecoration local21 = local15.groundDecoration;
				if (local21 != null) {
					local21.model = arg0;
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(ILclient!eb;III)V")
	public void setWallModel(@OriginalArg(1) Model arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg1 != null) {
			@Pc(21) Tile local21 = this.levelTiles[arg4][arg3][arg2];
			if (local21 != null) {
				@Pc(27) Wall local27 = local21.wall;
				if (local27 != null) {
					local27.modelA = arg1;
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IZII)V")
	public void setWallModels(@OriginalArg(0) Model arg0, @OriginalArg(1) Model arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		if (arg0 != null) {
			@Pc(11) Tile local11 = this.levelTiles[arg5][arg4][arg2];
			if (local11 != null) {
				@Pc(17) Wall local17 = local11.wall;
				if (local17 != null) {
					local17.modelA = arg0;
					local17.modelB = arg1;
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(IIII)V")
	public void removeWall(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(8) Tile local8 = this.levelTiles[arg1][arg0][arg2];
		if (arg3 == 1 && local8 != null) {
			local8.wall = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "c", descriptor = "(IIII)V")
	public void removeWallDecoration(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg3][arg1];
		if (local8 != null) {
			local8.wallDecoration = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "d", descriptor = "(IIII)V")
	public void removeLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) {
		@Pc(10) Tile local10 = this.levelTiles[arg3][arg0][arg1];
		if (local10 != null) {
			for (@Pc(15) int local15 = 0; local15 < local10.locCount; local15++) {
				@Pc(22) Loc local22 = local10.locs[local15];
				if ((local22.bitset >> 29 & 0x3) == 2 && local22.minSceneTileX == arg0 && local22.minSceneTileZ == arg1) {
					this.removeLoc(local22);
					return;
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "e", descriptor = "(IIII)V")
	public void removeGroundDecoration(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(16) Tile local16 = this.levelTiles[arg0][arg2][arg3];
		if (local16 != null) {
			local16.groundDecoration = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(III)V")
	public void removeObjStack(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg1][arg2];
		if (local8 != null) {
			local8.groundObj = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(III)I")
	public int getWallBitset(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg1][arg2];
		return local8 == null || local8.wall == null ? 0 : local8.wall.bitset;
	}

	@OriginalMember(owner = "client!r", name = "f", descriptor = "(IIII)I")
	public int getWallDecorationBitset(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) {
		@Pc(19) Tile local19 = this.levelTiles[arg0][arg3][arg1];
		return local19 == null || local19.wallDecoration == null ? 0 : local19.wallDecoration.bitset;
	}

	@OriginalMember(owner = "client!r", name = "c", descriptor = "(III)I")
	public int getLocBitset(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg1][arg2];
		if (local8 == null) {
			return 0;
		}
		for (@Pc(14) int local14 = 0; local14 < local8.locCount; local14++) {
			@Pc(21) Loc local21 = local8.locs[local14];
			if ((local21.bitset >> 29 & 0x3) == 2 && local21.minSceneTileX == arg1 && local21.minSceneTileZ == arg2) {
				return local21.bitset;
			}
		}
		return 0;
	}

	@OriginalMember(owner = "client!r", name = "d", descriptor = "(III)I")
	public int getGroundDecorationBitset(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg1][arg2];
		return local8 == null || local8.groundDecoration == null ? 0 : local8.groundDecoration.bitset;
	}

	@OriginalMember(owner = "client!r", name = "g", descriptor = "(IIII)I")
	public int getInfo(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(8) Tile local8 = this.levelTiles[arg0][arg1][arg2];
		if (local8 == null) {
			return -1;
		} else if (local8.wall != null && local8.wall.bitset == arg3) {
			return local8.wall.info & 0xFF;
		} else if (local8.wallDecoration != null && local8.wallDecoration.bitset == arg3) {
			return local8.wallDecoration.info & 0xFF;
		} else if (local8.groundDecoration != null && local8.groundDecoration.bitset == arg3) {
			return local8.groundDecoration.info & 0xFF;
		} else {
			for (@Pc(56) int local56 = 0; local56 < local8.locCount; local56++) {
				if (local8.locs[local56].bitset == arg3) {
					return local8.locs[local56].info & 0xFF;
				}
			}
			return -1;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIZ)V")
	public void buildModels(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(16) int local16 = (int) Math.sqrt((double) (arg2 * arg2 + arg0 * arg0 + arg4 * arg4));
		@Pc(26) int local26 = arg3 * local16 >> 8;
		for (@Pc(28) int local28 = 0; local28 < this.maxLevel; local28++) {
			for (@Pc(32) int local32 = 0; local32 < this.maxTileX; local32++) {
				for (@Pc(36) int local36 = 0; local36 < this.maxTileZ; local36++) {
					@Pc(47) Tile local47 = this.levelTiles[local28][local32][local36];
					if (local47 != null) {
						@Pc(52) Wall local52 = local47.wall;
						if (local52 != null && local52.modelA != null && local52.modelA.vertexNormal != null) {
							this.mergeLocNormals(local32, 1, 1, local28, local52.modelA, local36);
							if (local52.modelB != null && local52.modelB.vertexNormal != null) {
								this.mergeLocNormals(local32, 1, 1, local28, local52.modelB, local36);
								this.mergeNormals(local52.modelA, local52.modelB, 0, 0, 0, false);
								local52.modelB.applyLighting(arg1, local26, arg2, arg0, arg4);
							}
							local52.modelA.applyLighting(arg1, local26, arg2, arg0, arg4);
						}
						for (@Pc(116) int local116 = 0; local116 < local47.locCount; local116++) {
							@Pc(123) Loc local123 = local47.locs[local116];
							if (local123 != null && local123.model != null && local123.model.vertexNormal != null) {
								this.mergeLocNormals(local32, local123.maxSceneTileX + 1 - local123.minSceneTileX, local123.maxSceneTileZ - local123.minSceneTileZ + 1, local28, local123.model, local36);
								local123.model.applyLighting(arg1, local26, arg2, arg0, arg4);
							}
						}
						@Pc(170) GroundDecoration local170 = local47.groundDecoration;
						if (local170 != null && local170.model.vertexNormal != null) {
							this.mergeGroundDecorationNormals(local28, local36, local170.model, local32);
							local170.model.applyLighting(arg1, local26, arg2, arg0, arg4);
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(BIILclient!eb;I)V")
	private void mergeGroundDecorationNormals(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Model arg3, @OriginalArg(4) int arg4) {
		@Pc(19) Tile local19;
		if (arg4 < this.maxTileX) {
			local19 = this.levelTiles[arg1][arg4 + 1][arg2];
			if (local19 != null && local19.groundDecoration != null && local19.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(arg3, local19.groundDecoration.model, 128, 0, 0, true);
			}
		}
		if (arg2 < this.maxTileX) {
			local19 = this.levelTiles[arg1][arg4][arg2 + 1];
			if (local19 != null && local19.groundDecoration != null && local19.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(arg3, local19.groundDecoration.model, 0, 0, 128, true);
			}
		}
		if (arg4 < this.maxTileX && arg2 < this.maxTileZ) {
			local19 = this.levelTiles[arg1][arg4 + 1][arg2 + 1];
			if (local19 != null && local19.groundDecoration != null && local19.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(arg3, local19.groundDecoration.model, 128, 0, 128, true);
			}
		}
		if (arg4 < this.maxTileX && arg2 > 0) {
			local19 = this.levelTiles[arg1][arg4 + 1][arg2 - 1];
			if (local19 != null && local19.groundDecoration != null && local19.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(arg3, local19.groundDecoration.model, 128, 0, -128, true);
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIILclient!eb;I)V")
	private void mergeLocNormals(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) Model arg5, @OriginalArg(6) int arg6) {
		@Pc(7) boolean local7 = true;
		@Pc(9) int local9 = arg0;
		@Pc(13) int local13 = arg0 + arg1;
		@Pc(17) int local17 = arg6 - 1;
		@Pc(21) int local21 = arg6 + arg2;
		for (@Pc(23) int local23 = arg3; local23 <= arg3 + 1; local23++) {
			if (local23 != this.maxLevel) {
				for (@Pc(31) int local31 = local9; local31 <= local13; local31++) {
					if (local31 >= 0 && local31 < this.maxTileX) {
						for (@Pc(42) int local42 = local17; local42 <= local21; local42++) {
							if (local42 >= 0 && local42 < this.maxTileZ && (!local7 || local31 >= local13 || local42 >= local21 || local42 < arg6 && local31 != arg0)) {
								@Pc(75) Tile local75 = this.levelTiles[local23][local31][local42];
								if (local75 != null) {
									@Pc(169) int local169 = (this.levelHeightmaps[local23][local31][local42] + this.levelHeightmaps[local23][local31 + 1][local42] + this.levelHeightmaps[local23][local31][local42 + 1] + this.levelHeightmaps[local23][local31 + 1][local42 + 1]) / 4 - (this.levelHeightmaps[arg3][arg0][arg6] + this.levelHeightmaps[arg3][arg0 + 1][arg6] + this.levelHeightmaps[arg3][arg0][arg6 + 1] + this.levelHeightmaps[arg3][arg0 + 1][arg6 + 1]) / 4;
									@Pc(172) Wall local172 = local75.wall;
									if (local172 != null && local172.modelA != null && local172.modelA.vertexNormal != null) {
										this.mergeNormals(arg5, local172.modelA, (local31 - arg0) * 128 + (1 - arg1) * 64, local169, (local42 - arg6) * 128 + (1 - arg2) * 64, local7);
									}
									if (local172 != null && local172.modelB != null && local172.modelB.vertexNormal != null) {
										this.mergeNormals(arg5, local172.modelB, (local31 - arg0) * 128 + (1 - arg1) * 64, local169, (local42 - arg6) * 128 + (1 - arg2) * 64, local7);
									}
									for (@Pc(250) int local250 = 0; local250 < local75.locCount; local250++) {
										@Pc(257) Loc local257 = local75.locs[local250];
										if (local257 != null && local257.model != null && local257.model.vertexNormal != null) {
											@Pc(274) int local274 = local257.maxSceneTileX + 1 - local257.minSceneTileX;
											@Pc(282) int local282 = local257.maxSceneTileZ + 1 - local257.minSceneTileZ;
											this.mergeNormals(arg5, local257.model, (local257.minSceneTileX - arg0) * 128 + (local274 - arg1) * 64, local169, (local257.minSceneTileZ - arg6) * 128 + (local282 - arg2) * 64, local7);
										}
									}
								}
							}
						}
					}
				}
				local9--;
				local7 = false;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IIIZ)V")
	private void mergeNormals(@OriginalArg(0) Model arg0, @OriginalArg(1) Model arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5) {
		this.tmpMergeIndex++;
		@Pc(9) int local9 = 0;
		@Pc(12) int[] local12 = arg1.vertexX;
		@Pc(15) int local15 = arg1.vertexCount;
		for (@Pc(17) int local17 = 0; local17 < arg0.vertexCount; local17++) {
			@Pc(24) Model.VertexNormal local24 = arg0.vertexNormal[local17];
			@Pc(29) Model.VertexNormal local29 = arg0.vertexNormalOriginal[local17];
			if (local29.w != 0) {
				@Pc(39) int local39 = arg0.vertexY[local17] - arg3;
				if (local39 <= arg1.minY) {
					@Pc(50) int local50 = arg0.vertexX[local17] - arg2;
					if (local50 >= arg1.minX && local50 <= arg1.maxX) {
						@Pc(66) int local66 = arg0.vertexZ[local17] - arg4;
						if (local66 >= arg1.minZ && local66 <= arg1.maxZ) {
							for (@Pc(77) int local77 = 0; local77 < local15; local77++) {
								@Pc(84) Model.VertexNormal local84 = arg1.vertexNormal[local77];
								@Pc(89) Model.VertexNormal local89 = arg1.vertexNormalOriginal[local77];
								if (local50 == local12[local77] && local66 == arg1.vertexZ[local77] && local39 == arg1.vertexY[local77] && local89.w != 0) {
									local24.x += local89.x;
									local24.y += local89.y;
									local24.z += local89.z;
									local24.w += local89.w;
									local84.x += local29.x;
									local84.y += local29.y;
									local84.z += local29.z;
									local84.w += local29.w;
									local9++;
									this.mergeIndexA[local17] = this.tmpMergeIndex;
									this.mergeIndexB[local77] = this.tmpMergeIndex;
								}
							}
						}
					}
				}
			}
		}
		if (local9 < 3 || !arg5) {
			return;
		}
		for (@Pc(195) int local195 = 0; local195 < arg0.faceCount; local195++) {
			if (this.mergeIndexA[arg0.faceVertexA[local195]] == this.tmpMergeIndex && this.mergeIndexA[arg0.faceVertexB[local195]] == this.tmpMergeIndex && this.mergeIndexA[arg0.faceVertexC[local195]] == this.tmpMergeIndex) {
				arg0.faceInfo[local195] = -1;
			}
		}
		for (@Pc(239) int local239 = 0; local239 < arg1.faceCount; local239++) {
			if (this.mergeIndexB[arg1.faceVertexA[local239]] == this.tmpMergeIndex && this.mergeIndexB[arg1.faceVertexB[local239]] == this.tmpMergeIndex && this.mergeIndexB[arg1.faceVertexC[local239]] == this.tmpMergeIndex) {
				arg1.faceInfo[local239] = -1;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "([IIIIII)V")
	public void drawMinimapTile(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(10) Tile local10 = this.levelTiles[arg3][arg4][arg5];
		if (local10 == null) {
			return;
		}
		@Pc(16) TileUnderlay local16 = local10.underlay;
		@Pc(26) int local26;
		if (local16 != null) {
			@Pc(21) int local21 = local16.rgb;
			if (local21 != 0) {
				for (local26 = 0; local26 < 4; local26++) {
					arg0[arg1] = local21;
					arg0[arg1 + 1] = local21;
					arg0[arg1 + 2] = local21;
					arg0[arg1 + 3] = local21;
					arg1 += arg2;
				}
			}
			return;
		}
		@Pc(62) TileOverlay local62 = local10.overlay;
		if (local62 == null) {
			return;
		}
		local26 = local62.shape;
		@Pc(71) int local71 = local62.rotation;
		@Pc(74) int local74 = local62.backgroundRgb;
		@Pc(77) int local77 = local62.foregroundRgb;
		@Pc(82) int[] local82 = this.MINIMAP_TILE_MASK[local26];
		@Pc(87) int[] local87 = this.MINIMAP_TILE_ROTATION_MAP[local71];
		@Pc(89) int local89 = 0;
		@Pc(93) int local93;
		if (local74 != 0) {
			for (local93 = 0; local93 < 4; local93++) {
				arg0[arg1] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg0[arg1 + 1] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg0[arg1 + 2] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg0[arg1 + 3] = local82[local87[local89++]] == 0 ? local74 : local77;
				arg1 += arg2;
			}
			return;
		}
		for (local93 = 0; local93 < 4; local93++) {
			if (local82[local87[local89++]] != 0) {
				arg0[arg1] = local77;
			}
			if (local82[local87[local89++]] != 0) {
				arg0[arg1 + 1] = local77;
			}
			if (local82[local87[local89++]] != 0) {
				arg0[arg1 + 2] = local77;
			}
			if (local82[local87[local89++]] != 0) {
				arg0[arg1 + 3] = local77;
			}
			arg1 += arg2;
		}
	}

	@OriginalMember(owner = "client!r", name = "e", descriptor = "(III)V")
	public void click(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		takingInput = true;
		mouseX = arg2;
		mouseY = arg1;
		clickTileX = -1;
		clickTileZ = -1;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIII)V")
	public void draw(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, int loopCycle) {
		if (arg1 < 0) {
			arg1 = 0;
		} else if (arg1 >= this.maxTileX * 128) {
			arg1 = this.maxTileX * 128 - 1;
		}
		if (arg5 < 0) {
			arg5 = 0;
		} else if (arg5 >= this.maxTileZ * 128) {
			arg5 = this.maxTileZ * 128 - 1;
		}
		cycle++;
		sinEyePitch = Model.sin[arg3];
		cosEyePitch = Model.cos[arg3];
		sinEyeYaw = Model.sin[arg0];
		cosEyeYaw = Model.cos[arg0];
		visibilityMap = visibilityMatrix[(arg3 - 128) / 32][arg0 / 64];
		eyeX = arg1;
		eyeY = arg4;
		eyeZ = arg5;
		eyeTileX = arg1 / 128;
		eyeTileZ = arg5 / 128;
		topLevel = arg2;
		minDrawTileX = eyeTileX - 25;
		if (minDrawTileX < 0) {
			minDrawTileX = 0;
		}
		minDrawTileZ = eyeTileZ - 25;
		if (minDrawTileZ < 0) {
			minDrawTileZ = 0;
		}
		maxDrawTileX = eyeTileX + 25;
		if (maxDrawTileX > this.maxTileX) {
			maxDrawTileX = this.maxTileX;
		}
		maxDrawTileZ = eyeTileZ + 25;
		if (maxDrawTileZ > this.maxTileZ) {
			maxDrawTileZ = this.maxTileZ;
		}
		this.updateActiveOccluders();
		tilesRemaining = 0;
		@Pc(147) int local147;
		@Pc(151) int local151;
		for (@Pc(138) int local138 = this.minLevel; local138 < this.maxLevel; local138++) {
			@Pc(145) Tile[][] local145 = this.levelTiles[local138];
			for (local147 = minDrawTileX; local147 < maxDrawTileX; local147++) {
				for (local151 = minDrawTileZ; local151 < maxDrawTileZ; local151++) {
					@Pc(159) Tile local159 = local145[local147][local151];
					if (local159 != null) {
						if (local159.drawLevel <= arg2 && (visibilityMap[local147 + 25 - eyeTileX][local151 + 25 - eyeTileZ] || this.levelHeightmaps[local138][local147][local151] - arg4 >= 2000)) {
							local159.visible = true;
							local159.update = true;
							if (local159.locCount > 0) {
								local159.containsLocs = true;
							} else {
								local159.containsLocs = false;
							}
							tilesRemaining++;
						} else {
							local159.visible = false;
							local159.update = false;
							local159.checkLocSpans = 0;
						}
					}
				}
			}
		}
		@Pc(258) int local258;
		@Pc(266) int local266;
		@Pc(272) int local272;
		@Pc(276) int local276;
		@Pc(254) int local254;
		for (@Pc(239) int local239 = this.minLevel; local239 < this.maxLevel; local239++) {
			@Pc(246) Tile[][] local246 = this.levelTiles[local239];
			for (local151 = -25; local151 <= 0; local151++) {
				local254 = eyeTileX + local151;
				local258 = eyeTileX - local151;
				if (local254 >= minDrawTileX || local258 < maxDrawTileX) {
					for (local266 = -25; local266 <= 0; local266++) {
						local272 = eyeTileZ + local266;
						local276 = eyeTileZ - local266;
						@Pc(288) Tile local288;
						if (local254 >= minDrawTileX) {
							if (local272 >= minDrawTileZ) {
								local288 = local246[local254][local272];
								if (local288 != null && local288.visible) {
									this.drawTile(local288, true, loopCycle);
								}
							}
							if (local276 < maxDrawTileZ) {
								local288 = local246[local254][local276];
								if (local288 != null && local288.visible) {
									this.drawTile(local288, true, loopCycle);
								}
							}
						}
						if (local258 < maxDrawTileX) {
							if (local272 >= minDrawTileZ) {
								local288 = local246[local258][local272];
								if (local288 != null && local288.visible) {
									this.drawTile(local288, true, loopCycle);
								}
							}
							if (local276 < maxDrawTileZ) {
								local288 = local246[local258][local276];
								if (local288 != null && local288.visible) {
									this.drawTile(local288, true, loopCycle);
								}
							}
						}
						if (tilesRemaining == 0) {
							takingInput = false;
							return;
						}
					}
				}
			}
		}
		for (local147 = this.minLevel; local147 < this.maxLevel; local147++) {
			@Pc(380) Tile[][] local380 = this.levelTiles[local147];
			for (local254 = -25; local254 <= 0; local254++) {
				local258 = eyeTileX + local254;
				local266 = eyeTileX - local254;
				if (local258 >= minDrawTileX || local266 < maxDrawTileX) {
					for (local272 = -25; local272 <= 0; local272++) {
						local276 = eyeTileZ + local272;
						@Pc(410) int local410 = eyeTileZ - local272;
						@Pc(422) Tile local422;
						if (local258 >= minDrawTileX) {
							if (local276 >= minDrawTileZ) {
								local422 = local380[local258][local276];
								if (local422 != null && local422.visible) {
									this.drawTile(local422, false, loopCycle);
								}
							}
							if (local410 < maxDrawTileZ) {
								local422 = local380[local258][local410];
								if (local422 != null && local422.visible) {
									this.drawTile(local422, false, loopCycle);
								}
							}
						}
						if (local266 < maxDrawTileX) {
							if (local276 >= minDrawTileZ) {
								local422 = local380[local266][local276];
								if (local422 != null && local422.visible) {
									this.drawTile(local422, false, loopCycle);
								}
							}
							if (local410 < maxDrawTileZ) {
								local422 = local380[local266][local410];
								if (local422 != null && local422.visible) {
									this.drawTile(local422, false, loopCycle);
								}
							}
						}
						if (tilesRemaining == 0) {
							takingInput = false;
							return;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!cb;Z)V")
	private void drawTile(@OriginalArg(0) Tile arg0, @OriginalArg(1) boolean arg1, int loopCycle) {
		drawTileQueue.pushBack(arg0);
		while (true) {
			@Pc(8) Tile local8;
			@Pc(17) int local17;
			@Pc(20) int local20;
			@Pc(23) int local23;
			@Pc(26) int local26;
			@Pc(31) Tile[][] local31;
			@Pc(49) Tile local49;
			@Pc(253) int local253;
			@Pc(599) int local599;
			@Pc(604) int local604;
			@Pc(609) int local609;
			@Pc(612) int local612;
			@Pc(621) int local621;
			@Pc(963) Wall local963;
			@Pc(1144) int local1144;
			@Pc(1023) int local1023;
			do {
				do {
					do {
						do {
							do {
								do {
									while (true) {
										@Pc(260) Loc var12;
										@Pc(349) int var22;
										@Pc(301) boolean var23;
										@Pc(846) Tile var35;
										while (true) {
											do {
												local8 = (Tile) drawTileQueue.pollFront();
												if (local8 == null) {
													return;
												}
											} while (!local8.update);
											local17 = local8.x;
											local20 = local8.z;
											local23 = local8.level;
											local26 = local8.occludeLevel;
											local31 = this.levelTiles[local23];
											if (!local8.visible) {
												break;
											}
											if (arg1) {
												if (local23 > 0) {
													local49 = this.levelTiles[local23 - 1][local17][local20];
													if (local49 != null && local49.update) {
														continue;
													}
												}
												if (local17 <= eyeTileX && local17 > minDrawTileX) {
													local49 = local31[local17 - 1][local20];
													if (local49 != null && local49.update && (local49.visible || (local8.locSpans & 0x1) == 0)) {
														continue;
													}
												}
												if (local17 >= eyeTileX && local17 < maxDrawTileX - 1) {
													local49 = local31[local17 + 1][local20];
													if (local49 != null && local49.update && (local49.visible || (local8.locSpans & 0x4) == 0)) {
														continue;
													}
												}
												if (local20 <= eyeTileZ && local20 > minDrawTileZ) {
													local49 = local31[local17][local20 - 1];
													if (local49 != null && local49.update && (local49.visible || (local8.locSpans & 0x8) == 0)) {
														continue;
													}
												}
												if (local20 >= eyeTileZ && local20 < maxDrawTileZ - 1) {
													local49 = local31[local17][local20 + 1];
													if (local49 != null && local49.update && (local49.visible || (local8.locSpans & 0x2) == 0)) {
														continue;
													}
												}
											} else {
												arg1 = true;
											}
											local8.visible = false;
											if (local8.bridge != null) {
												local49 = local8.bridge;
												if (local49.underlay == null) {
													if (local49.overlay != null && !this.tileVisible(0, local17, local20)) {
														this.drawTileOverlay(sinEyeYaw, local20, local49.overlay, local17, cosEyePitch, sinEyePitch, cosEyeYaw);
													}
												} else if (!this.tileVisible(0, local17, local20)) {
													this.drawTileUnderlay(local49.underlay, 0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local17, local20);
												}
												@Pc(227) Wall local227 = local49.wall;
												if (local227 != null) {
													local227.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local227.x - eyeX, local227.y - eyeY, local227.z - eyeZ, local227.bitset);
												}
												for (local253 = 0; local253 < local49.locCount; local253++) {
													var12 = local49.locs[local253];
													if (var12 != null) {
														@Pc(265) Model local265 = var12.model;
														if (local265 == null) {
															local265 = var12.entity.draw(loopCycle);
														}
														local265.draw(var12.yaw, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, var12.x - eyeX, var12.y - eyeY, var12.z - eyeZ, var12.bitset);
													}
												}
											}
											var23 = false;
											if (local8.underlay == null) {
												if (local8.overlay != null && !this.tileVisible(local26, local17, local20)) {
													var23 = true;
													this.drawTileOverlay(sinEyeYaw, local20, local8.overlay, local17, cosEyePitch, sinEyePitch, cosEyeYaw);
												}
											} else if (!this.tileVisible(local26, local17, local20)) {
												var23 = true;
												this.drawTileUnderlay(local8.underlay, local26, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local17, local20);
											}
											var22 = 0;
											local253 = 0;
											@Pc(354) Wall local354 = local8.wall;
											@Pc(357) WallDecoration local357 = local8.wallDecoration;
											if (local354 != null || local357 != null) {
												if (eyeTileX == local17) {
													var22++;
												} else if (eyeTileX < local17) {
													var22 += 2;
												}
												if (eyeTileZ == local20) {
													var22 += 3;
												} else if (eyeTileZ > local20) {
													var22 += 6;
												}
												local253 = FRONT_WALL_TYPES[var22];
												local8.backWallTypes = BACK_WALL_TYPES[var22];
											}
											if (local354 != null) {
												if ((local354.typeA & DIRECTION_ALLOW_WALL_CORNER_TYPE[var22]) == 0) {
													local8.checkLocSpans = 0;
												} else if (local354.typeA == 16) {
													local8.checkLocSpans = 3;
													local8.blockLocSpans = WALL_CORNER_TYPE_16_BLOCK_LOC_SPANS[var22];
													local8.inverseBlockLocSpans = 3 - local8.blockLocSpans;
												} else if (local354.typeA == 32) {
													local8.checkLocSpans = 6;
													local8.blockLocSpans = WALL_CORNER_TYPE_32_BLOCK_LOC_SPANS[var22];
													local8.inverseBlockLocSpans = 6 - local8.blockLocSpans;
												} else if (local354.typeA == 64) {
													local8.checkLocSpans = 12;
													local8.blockLocSpans = WALL_CORNER_TYPE_64_BLOCK_LOC_SPANS[var22];
													local8.inverseBlockLocSpans = 12 - local8.blockLocSpans;
												} else {
													local8.checkLocSpans = 9;
													local8.blockLocSpans = WALL_CORNER_TYPE_128_BLOCK_LOC_SPANS[var22];
													local8.inverseBlockLocSpans = 9 - local8.blockLocSpans;
												}
												if ((local354.typeA & local253) != 0 && !this.wallVisible(local26, local17, local20, local354.typeA)) {
													local354.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local354.x - eyeX, local354.y - eyeY, local354.z - eyeZ, local354.bitset);
												}
												if ((local354.typeB & local253) != 0 && !this.wallVisible(local26, local17, local20, local354.typeB)) {
													local354.modelB.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local354.x - eyeX, local354.y - eyeY, local354.z - eyeZ, local354.bitset);
												}
											}
											if (local357 != null && !this.visible(local26, local17, local20, local357.model.maxY)) {
												if ((local357.type & local253) != 0) {
													local357.model.draw(local357.orientation, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local357.x - eyeX, local357.y - eyeY, local357.z - eyeZ, local357.bitset);
												} else if ((local357.type & 0x300) != 0) {
													local599 = local357.x - eyeX;
													local604 = local357.y - eyeY;
													local609 = local357.z - eyeZ;
													local612 = local357.orientation;
													if (local612 == 1 || local612 == 2) {
														local621 = -local599;
													} else {
														local621 = local599;
													}
													@Pc(634) int local634;
													if (local612 == 2 || local612 == 3) {
														local634 = -local609;
													} else {
														local634 = local609;
													}
													@Pc(652) int local652;
													@Pc(658) int local658;
													if ((local357.type & 0x100) != 0 && local634 < local621) {
														local652 = local599 + WALL_DECORATION_INSET_X[local612];
														local658 = local609 + WALL_DECORATION_INSET_Z[local612];
														local357.model.draw(local612 * 512 + 256, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local652, local604, local658, local357.bitset);
													}
													if ((local357.type & 0x200) != 0 && local634 > local621) {
														local652 = local599 + WALL_DECORATION_OUTSET_X[local612];
														local658 = local609 + WALL_DECORATION_OUTSET_Z[local612];
														local357.model.draw(local612 * 512 + 1280 & 0x7FF, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local652, local604, local658, local357.bitset);
													}
												}
											}
											if (var23) {
												@Pc(719) GroundDecoration local719 = local8.groundDecoration;
												if (local719 != null) {
													local719.model.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local719.x - eyeX, local719.y - eyeY, local719.z - eyeZ, local719.bitset);
												}
												@Pc(746) GroundObj local746 = local8.groundObj;
												if (local746 != null && local746.offset == 0) {
													if (local746.middleObj != null) {
														local746.middleObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local746.x - eyeX, local746.y - eyeY, local746.z - eyeZ, local746.bitset);
													}
													if (local746.bottomObj != null) {
														local746.bottomObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local746.x - eyeX, local746.y - eyeY, local746.z - eyeZ, local746.bitset);
													}
													if (local746.topObj != null) {
														local746.topObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local746.x - eyeX, local746.y - eyeY, local746.z - eyeZ, local746.bitset);
													}
												}
											}
											local599 = local8.locSpans;
											if (local599 != 0) {
												if (local17 < eyeTileX && (local599 & 0x4) != 0) {
													var35 = local31[local17 + 1][local20];
													if (var35 != null && var35.update) {
														drawTileQueue.pushBack(var35);
													}
												}
												if (local20 < eyeTileZ && (local599 & 0x2) != 0) {
													var35 = local31[local17][local20 + 1];
													if (var35 != null && var35.update) {
														drawTileQueue.pushBack(var35);
													}
												}
												if (local17 > eyeTileX && (local599 & 0x1) != 0) {
													var35 = local31[local17 - 1][local20];
													if (var35 != null && var35.update) {
														drawTileQueue.pushBack(var35);
													}
												}
												if (local20 > eyeTileZ && (local599 & 0x8) != 0) {
													var35 = local31[local17][local20 - 1];
													if (var35 != null && var35.update) {
														drawTileQueue.pushBack(var35);
													}
												}
											}
											break;
										}
										if (local8.checkLocSpans != 0) {
											var23 = true;
											for (var22 = 0; var22 < local8.locCount; var22++) {
												if (local8.locs[var22].cycle != cycle && (local8.locSpan[var22] & local8.checkLocSpans) == local8.blockLocSpans) {
													var23 = false;
													break;
												}
											}
											if (var23) {
												local963 = local8.wall;
												if (!this.wallVisible(local26, local17, local20, local963.typeA)) {
													local963.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local963.x - eyeX, local963.y - eyeY, local963.z - eyeZ, local963.bitset);
												}
												local8.checkLocSpans = 0;
											}
										}
										if (!local8.containsLocs) {
											break;
										}
										@Pc(1002) int local1002 = local8.locCount;
										local8.containsLocs = false;
										var22 = 0;
										label559: for (local253 = 0; local253 < local1002; local253++) {
											var12 = local8.locs[local253];
											if (var12.cycle != cycle) {
												for (local1023 = var12.minSceneTileX; local1023 <= var12.maxSceneTileX; local1023++) {
													for (local599 = var12.minSceneTileZ; local599 <= var12.maxSceneTileZ; local599++) {
														var35 = local31[local1023][local599];
														if (var35.visible) {
															local8.containsLocs = true;
															continue label559;
														}
														if (var35.checkLocSpans != 0) {
															local609 = 0;
															if (local1023 > var12.minSceneTileX) {
																local609++;
															}
															if (local1023 < var12.maxSceneTileX) {
																local609 += 4;
															}
															if (local599 > var12.minSceneTileZ) {
																local609 += 8;
															}
															if (local599 < var12.maxSceneTileZ) {
																local609 += 2;
															}
															if ((local609 & var35.checkLocSpans) == local8.inverseBlockLocSpans) {
																local8.containsLocs = true;
																continue label559;
															}
														}
													}
												}
												locBuffer[var22++] = var12;
												local599 = eyeTileX - var12.minSceneTileX;
												local604 = var12.maxSceneTileX - eyeTileX;
												if (local604 > local599) {
													local599 = local604;
												}
												local609 = eyeTileZ - var12.minSceneTileZ;
												local612 = var12.maxSceneTileZ - eyeTileZ;
												if (local612 > local609) {
													var12.distance = local599 + local612;
												} else {
													var12.distance = local599 + local609;
												}
											}
										}
										while (var22 > 0) {
											local1144 = -50;
											local1023 = -1;
											@Pc(1154) Loc local1154;
											for (local599 = 0; local599 < var22; local599++) {
												local1154 = locBuffer[local599];
												if (local1154.distance > local1144 && local1154.cycle != cycle) {
													local1144 = local1154.distance;
													local1023 = local599;
												}
											}
											if (local1023 == -1) {
												break;
											}
											local1154 = locBuffer[local1023];
											local1154.cycle = cycle;
											@Pc(1184) Model local1184 = local1154.model;
											if (local1184 == null) {
												local1184 = local1154.entity.draw(loopCycle);
											}
											if (!this.locVisible(local26, local1154.minSceneTileX, local1154.maxSceneTileX, local1154.minSceneTileZ, local1154.maxSceneTileZ, local1184.maxY)) {
												local1184.draw(local1154.yaw, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local1154.x - eyeX, local1154.y - eyeY, local1154.z - eyeZ, local1154.bitset);
											}
											for (local612 = local1154.minSceneTileX; local612 <= local1154.maxSceneTileX; local612++) {
												for (local621 = local1154.minSceneTileZ; local621 <= local1154.maxSceneTileZ; local621++) {
													@Pc(1243) Tile local1243 = local31[local612][local621];
													if (local1243.checkLocSpans != 0) {
														drawTileQueue.pushBack(local1243);
													} else if ((local612 != local17 || local621 != local20) && local1243.update) {
														drawTileQueue.pushBack(local1243);
													}
												}
											}
										}
										if (!local8.containsLocs) {
											break;
										}
									}
								} while (!local8.update);
							} while (local8.checkLocSpans != 0);
							if (local17 > eyeTileX || local17 <= minDrawTileX) {
								break;
							}
							local49 = local31[local17 - 1][local20];
						} while (local49 != null && local49.update);
						if (local17 < eyeTileX || local17 >= maxDrawTileX - 1) {
							break;
						}
						local49 = local31[local17 + 1][local20];
					} while (local49 != null && local49.update);
					if (local20 > eyeTileZ || local20 <= minDrawTileZ) {
						break;
					}
					local49 = local31[local17][local20 - 1];
				} while (local49 != null && local49.update);
				if (local20 < eyeTileZ || local20 >= maxDrawTileZ - 1) {
					break;
				}
				local49 = local31[local17][local20 + 1];
			} while (local49 != null && local49.update);
			local8.update = false;
			tilesRemaining--;
			@Pc(1379) GroundObj local1379 = local8.groundObj;
			if (local1379 != null && local1379.offset != 0) {
				if (local1379.middleObj != null) {
					local1379.middleObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local1379.x - eyeX, local1379.y - eyeY - local1379.offset, local1379.z - eyeZ, local1379.bitset);
				}
				if (local1379.bottomObj != null) {
					local1379.bottomObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local1379.x - eyeX, local1379.y - eyeY - local1379.offset, local1379.z - eyeZ, local1379.bitset);
				}
				if (local1379.topObj != null) {
					local1379.topObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local1379.x - eyeX, local1379.y - eyeY - local1379.offset, local1379.z - eyeZ, local1379.bitset);
				}
			}
			if (local8.backWallTypes != 0) {
				@Pc(1474) WallDecoration local1474 = local8.wallDecoration;
				if (local1474 != null && !this.visible(local26, local17, local20, local1474.model.maxY)) {
					if ((local1474.type & local8.backWallTypes) != 0) {
						local1474.model.draw(local1474.orientation, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local1474.x - eyeX, local1474.y - eyeY, local1474.z - eyeZ, local1474.bitset);
					} else if ((local1474.type & 0x300) != 0) {
						local253 = local1474.x - eyeX;
						local1144 = local1474.y - eyeY;
						local1023 = local1474.z - eyeZ;
						local599 = local1474.orientation;
						if (local599 == 1 || local599 == 2) {
							local604 = -local253;
						} else {
							local604 = local253;
						}
						if (local599 == 2 || local599 == 3) {
							local609 = -local1023;
						} else {
							local609 = local1023;
						}
						if ((local1474.type & 0x100) != 0 && local609 >= local604) {
							local612 = local253 + WALL_DECORATION_INSET_X[local599];
							local621 = local1023 + WALL_DECORATION_INSET_Z[local599];
							local1474.model.draw(local599 * 512 + 256, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local612, local1144, local621, local1474.bitset);
						}
						if ((local1474.type & 0x200) != 0 && local609 <= local604) {
							local612 = local253 + WALL_DECORATION_OUTSET_X[local599];
							local621 = local1023 + WALL_DECORATION_OUTSET_Z[local599];
							local1474.model.draw(local599 * 512 + 1280 & 0x7FF, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local612, local1144, local621, local1474.bitset);
						}
					}
				}
				local963 = local8.wall;
				if (local963 != null) {
					if ((local963.typeB & local8.backWallTypes) != 0 && !this.wallVisible(local26, local17, local20, local963.typeB)) {
						local963.modelB.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local963.x - eyeX, local963.y - eyeY, local963.z - eyeZ, local963.bitset);
					}
					if ((local963.typeA & local8.backWallTypes) != 0 && !this.wallVisible(local26, local17, local20, local963.typeA)) {
						local963.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, local963.x - eyeX, local963.y - eyeY, local963.z - eyeZ, local963.bitset);
					}
				}
			}
			@Pc(1735) Tile local1735;
			if (local23 < this.maxLevel - 1) {
				local1735 = this.levelTiles[local23 + 1][local17][local20];
				if (local1735 != null && local1735.update) {
					drawTileQueue.pushBack(local1735);
				}
			}
			if (local17 < eyeTileX) {
				local1735 = local31[local17 + 1][local20];
				if (local1735 != null && local1735.update) {
					drawTileQueue.pushBack(local1735);
				}
			}
			if (local20 < eyeTileZ) {
				local1735 = local31[local17][local20 + 1];
				if (local1735 != null && local1735.update) {
					drawTileQueue.pushBack(local1735);
				}
			}
			if (local17 > eyeTileX) {
				local1735 = local31[local17 - 1][local20];
				if (local1735 != null && local1735.update) {
					drawTileQueue.pushBack(local1735);
				}
			}
			if (local20 > eyeTileZ) {
				local1735 = local31[local17][local20 - 1];
				if (local1735 != null && local1735.update) {
					drawTileQueue.pushBack(local1735);
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!o;IIIIIII)V")
	private void drawTileUnderlay(@OriginalArg(0) TileUnderlay arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(8) int local8;
		@Pc(9) int local9 = local8 = (arg6 << 7) - eyeX;
		@Pc(16) int local16;
		@Pc(17) int local17 = local16 = (arg7 << 7) - eyeZ;
		@Pc(22) int local22;
		@Pc(23) int local23 = local22 = local9 + 128;
		@Pc(28) int local28;
		@Pc(29) int local29 = local28 = local17 + 128;
		@Pc(40) int local40 = this.levelHeightmaps[arg1][arg6][arg7] - eyeY;
		@Pc(53) int local53 = this.levelHeightmaps[arg1][arg6 + 1][arg7] - eyeY;
		@Pc(68) int local68 = this.levelHeightmaps[arg1][arg6 + 1][arg7 + 1] - eyeY;
		@Pc(81) int local81 = this.levelHeightmaps[arg1][arg6][arg7 + 1] - eyeY;
		@Pc(91) int local91 = local17 * arg4 + local9 * arg5 >> 16;
		@Pc(101) int local101 = local17 * arg5 - local9 * arg4 >> 16;
		@Pc(103) int local103 = local91;
		@Pc(113) int local113 = local40 * arg3 - local101 * arg2 >> 16;
		@Pc(123) int local123 = local40 * arg2 + local101 * arg3 >> 16;
		@Pc(125) int local125 = local113;
		if (local123 < 50) {
			return;
		}
		local91 = local16 * arg4 + local23 * arg5 >> 16;
		@Pc(149) int local149 = local16 * arg5 - local23 * arg4 >> 16;
		local23 = local91;
		local91 = local53 * arg3 - local149 * arg2 >> 16;
		@Pc(171) int local171 = local53 * arg2 + local149 * arg3 >> 16;
		local53 = local91;
		if (local171 < 50) {
			return;
		}
		local91 = local29 * arg4 + local22 * arg5 >> 16;
		local29 = local29 * arg5 - local22 * arg4 >> 16;
		@Pc(199) int local199 = local91;
		local91 = local68 * arg3 - local29 * arg2 >> 16;
		local29 = local68 * arg2 + local29 * arg3 >> 16;
		local68 = local91;
		if (local29 < 50) {
			return;
		}
		local91 = local28 * arg4 + local8 * arg5 >> 16;
		@Pc(245) int local245 = local28 * arg5 - local8 * arg4 >> 16;
		@Pc(247) int local247 = local91;
		local91 = local81 * arg3 - local245 * arg2 >> 16;
		@Pc(267) int local267 = local81 * arg2 + local245 * arg3 >> 16;
		if (local267 < 50) {
			return;
		}
		@Pc(281) int local281 = Draw3D.centerX + (local103 << 9) / local123;
		@Pc(289) int local289 = Draw3D.centerY + (local125 << 9) / local123;
		@Pc(297) int local297 = Draw3D.centerX + (local23 << 9) / local171;
		@Pc(305) int local305 = Draw3D.centerY + (local53 << 9) / local171;
		@Pc(313) int local313 = Draw3D.centerX + (local199 << 9) / local29;
		@Pc(321) int local321 = Draw3D.centerY + (local68 << 9) / local29;
		@Pc(329) int local329 = Draw3D.centerX + (local247 << 9) / local267;
		@Pc(337) int local337 = Draw3D.centerY + (local91 << 9) / local267;
		Draw3D.alpha = 0;
		@Pc(476) int local476;
		if ((local313 - local329) * (local305 - local337) - (local321 - local337) * (local297 - local329) > 0) {
			Draw3D.clipX = false;
			if (local313 < 0 || local329 < 0 || local297 < 0 || local313 > Draw2D.boundX || local329 > Draw2D.boundX || local297 > Draw2D.boundX) {
				Draw3D.clipX = true;
			}
			if (takingInput && this.pointInsideTriangle(mouseX, mouseY, local321, local337, local305, local313, local329, local297)) {
				clickTileX = arg6;
				clickTileZ = arg7;
			}
			if (arg0.textureId == -1) {
				if (arg0.northeastColor != 12345678) {
					Draw3D.fillGouraudTriangle(local321, local337, local305, local313, local329, local297, arg0.northeastColor, arg0.northwestColor, arg0.southeastColor);
				}
			} else if (lowMemory) {
				local476 = TEXTURE_HSL[arg0.textureId];
				Draw3D.fillGouraudTriangle(local321, local337, local305, local313, local329, local297, this.mulLightness(arg0.northeastColor, local476), this.mulLightness(arg0.northwestColor, local476), this.mulLightness(arg0.southeastColor, local476));
			} else if (arg0.flat) {
				Draw3D.fillTexturedTriangle(local321, local337, local305, local313, local329, local297, arg0.northeastColor, arg0.northwestColor, arg0.southeastColor, local103, local23, local247, local125, local53, local91, local123, local171, local267, arg0.textureId);
			} else {
				Draw3D.fillTexturedTriangle(local321, local337, local305, local313, local329, local297, arg0.northeastColor, arg0.northwestColor, arg0.southeastColor, local199, local247, local23, local68, local91, local53, local29, local267, local171, arg0.textureId);
			}
		}
		if ((local281 - local297) * (local337 - local305) - (local289 - local305) * (local329 - local297) <= 0) {
			return;
		}
		Draw3D.clipX = false;
		if (local281 < 0 || local297 < 0 || local329 < 0 || local281 > Draw2D.boundX || local297 > Draw2D.boundX || local329 > Draw2D.boundX) {
			Draw3D.clipX = true;
		}
		if (takingInput && this.pointInsideTriangle(mouseX, mouseY, local289, local305, local337, local281, local297, local329)) {
			clickTileX = arg6;
			clickTileZ = arg7;
		}
		if (arg0.textureId != -1) {
			if (!lowMemory) {
				Draw3D.fillTexturedTriangle(local289, local305, local337, local281, local297, local329, arg0.southwestColor, arg0.southeastColor, arg0.northwestColor, local103, local23, local247, local125, local53, local91, local123, local171, local267, arg0.textureId);
				return;
			}
			local476 = TEXTURE_HSL[arg0.textureId];
			Draw3D.fillGouraudTriangle(local289, local305, local337, local281, local297, local329, this.mulLightness(arg0.southwestColor, local476), this.mulLightness(arg0.southeastColor, local476), this.mulLightness(arg0.northwestColor, local476));
		} else if (arg0.southwestColor != 12345678) {
			Draw3D.fillGouraudTriangle(local289, local305, local337, local281, local297, local329, arg0.southwestColor, arg0.southeastColor, arg0.northwestColor);
			return;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IILclient!i;IIIIZ)V")
	private void drawTileOverlay(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) TileOverlay arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		@Pc(5) int local5 = arg2.vertexX.length;
		@Pc(16) int local16;
		@Pc(23) int local23;
		@Pc(30) int local30;
		@Pc(40) int local40;
		for (@Pc(7) int local7 = 0; local7 < local5; local7++) {
			local16 = arg2.vertexX[local7] - eyeX;
			local23 = arg2.vertexY[local7] - eyeY;
			local30 = arg2.vertexZ[local7] - eyeZ;
			local40 = local30 * arg0 + local16 * arg6 >> 16;
			@Pc(50) int local50 = local30 * arg6 - local16 * arg0 >> 16;
			@Pc(62) int local62 = local23 * arg4 - local50 * arg5 >> 16;
			@Pc(72) int local72 = local23 * arg5 + local50 * arg4 >> 16;
			if (local72 < 50) {
				return;
			}
			if (arg2.triangleTextureIds != null) {
				TileOverlay.tmpViewspaceX[local7] = local40;
				TileOverlay.tmpViewspaceY[local7] = local62;
				TileOverlay.tmpViewspaceZ[local7] = local72;
			}
			TileOverlay.tmpScreenX[local7] = Draw3D.centerX + (local40 << 9) / local72;
			TileOverlay.tmpScreenY[local7] = Draw3D.centerY + (local62 << 9) / local72;
		}
		Draw3D.alpha = 0;
		local5 = arg2.triangleVertexA.length;
		for (local16 = 0; local16 < local5; local16++) {
			local23 = arg2.triangleVertexA[local16];
			local30 = arg2.triangleVertexB[local16];
			local40 = arg2.triangleVertexC[local16];
			@Pc(149) int local149 = TileOverlay.tmpScreenX[local23];
			@Pc(153) int local153 = TileOverlay.tmpScreenX[local30];
			@Pc(157) int local157 = TileOverlay.tmpScreenX[local40];
			@Pc(161) int local161 = TileOverlay.tmpScreenY[local23];
			@Pc(165) int local165 = TileOverlay.tmpScreenY[local30];
			@Pc(169) int local169 = TileOverlay.tmpScreenY[local40];
			if ((local149 - local153) * (local169 - local165) - (local161 - local165) * (local157 - local153) > 0) {
				Draw3D.clipX = false;
				if (local149 < 0 || local153 < 0 || local157 < 0 || local149 > Draw2D.boundX || local153 > Draw2D.boundX || local157 > Draw2D.boundX) {
					Draw3D.clipX = true;
				}
				if (takingInput && this.pointInsideTriangle(mouseX, mouseY, local161, local165, local169, local149, local153, local157)) {
					clickTileX = arg3;
					clickTileZ = arg1;
				}
				if (arg2.triangleTextureIds == null || arg2.triangleTextureIds[local16] == -1) {
					if (arg2.triangleColorA[local16] != 12345678) {
						Draw3D.fillGouraudTriangle(local161, local165, local169, local149, local153, local157, arg2.triangleColorA[local16], arg2.triangleColorB[local16], arg2.triangleColorC[local16]);
					}
				} else if (lowMemory) {
					@Pc(373) int local373 = TEXTURE_HSL[arg2.triangleTextureIds[local16]];
					Draw3D.fillGouraudTriangle(local161, local165, local169, local149, local153, local157, this.mulLightness(arg2.triangleColorA[local16], local373), this.mulLightness(arg2.triangleColorB[local16], local373), this.mulLightness(arg2.triangleColorC[local16], local373));
				} else if (arg2.flat) {
					Draw3D.fillTexturedTriangle(local161, local165, local169, local149, local153, local157, arg2.triangleColorA[local16], arg2.triangleColorB[local16], arg2.triangleColorC[local16], TileOverlay.tmpViewspaceX[0], TileOverlay.tmpViewspaceX[1], TileOverlay.tmpViewspaceX[3], TileOverlay.tmpViewspaceY[0], TileOverlay.tmpViewspaceY[1], TileOverlay.tmpViewspaceY[3], TileOverlay.tmpViewspaceZ[0], TileOverlay.tmpViewspaceZ[1], TileOverlay.tmpViewspaceZ[3], arg2.triangleTextureIds[local16]);
				} else {
					Draw3D.fillTexturedTriangle(local161, local165, local169, local149, local153, local157, arg2.triangleColorA[local16], arg2.triangleColorB[local16], arg2.triangleColorC[local16], TileOverlay.tmpViewspaceX[local23], TileOverlay.tmpViewspaceX[local30], TileOverlay.tmpViewspaceX[local40], TileOverlay.tmpViewspaceY[local23], TileOverlay.tmpViewspaceY[local30], TileOverlay.tmpViewspaceY[local40], TileOverlay.tmpViewspaceZ[local23], TileOverlay.tmpViewspaceZ[local30], TileOverlay.tmpViewspaceZ[local40], arg2.triangleTextureIds[local16]);
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "f", descriptor = "(III)I")
	private int mulLightness(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(3) int local3 = 127 - arg0;
		arg0 = local3 * (arg1 & 0x7F) / 160;
		if (arg0 < 2) {
			arg0 = 2;
		} else if (arg0 > 126) {
			arg0 = 126;
		}
		return (arg1 & 0xFF80) + arg0;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIII)Z")
	private boolean pointInsideTriangle(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else if (arg0 > arg5 && arg0 > arg6 && arg0 > arg7) {
			return false;
		} else {
			@Pc(59) int local59 = (arg1 - arg2) * (arg6 - arg5) - (arg0 - arg5) * (arg3 - arg2);
			@Pc(75) int local75 = (arg1 - arg4) * (arg5 - arg7) - (arg0 - arg7) * (arg2 - arg4);
			@Pc(91) int local91 = (arg1 - arg3) * (arg7 - arg6) - (arg0 - arg6) * (arg4 - arg3);
			return local59 * local91 > 0 && local91 * local75 > 0;
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(Z)V")
	private void updateActiveOccluders() {
		@Pc(5) int local5 = levelOccluderCount[topLevel];
		@Pc(9) Occluder[] local9 = levelOccluders[topLevel];
		activeOccluderCount = 0;
		for (@Pc(13) int local13 = 0; local13 < local5; local13++) {
			@Pc(19) Occluder local19 = local9[local13];
			@Pc(30) int local30;
			@Pc(43) int local43;
			@Pc(54) int local54;
			@Pc(84) int local84;
			@Pc(61) boolean local61;
			if (local19.type == 1) {
				local30 = local19.minTileX + 25 - eyeTileX;
				if (local30 >= 0 && local30 <= 50) {
					local43 = local19.minTileZ + 25 - eyeTileZ;
					if (local43 < 0) {
						local43 = 0;
					}
					local54 = local19.maxTileZ + 25 - eyeTileZ;
					if (local54 > 50) {
						local54 = 50;
					}
					local61 = false;
					while (local43 <= local54) {
						if (visibilityMap[local30][local43++]) {
							local61 = true;
							break;
						}
					}
					if (local61) {
						local84 = eyeX - local19.minX;
						if (local84 > 32) {
							local19.mode = 1;
						} else {
							if (local84 >= -32) {
								continue;
							}
							local19.mode = 2;
							local84 = -local84;
						}
						local19.minDeltaZ = (local19.minZ - eyeZ << 8) / local84;
						local19.maxDeltaZ = (local19.maxZ - eyeZ << 8) / local84;
						local19.minDeltaY = (local19.minY - eyeY << 8) / local84;
						local19.maxDeltaY = (local19.maxY - eyeY << 8) / local84;
						activeOccluders[activeOccluderCount++] = local19;
					}
				}
			} else if (local19.type == 2) {
				local30 = local19.minTileZ + 25 - eyeTileZ;
				if (local30 >= 0 && local30 <= 50) {
					local43 = local19.minTileX + 25 - eyeTileX;
					if (local43 < 0) {
						local43 = 0;
					}
					local54 = local19.maxTileX + 25 - eyeTileX;
					if (local54 > 50) {
						local54 = 50;
					}
					local61 = false;
					while (local43 <= local54) {
						if (visibilityMap[local43++][local30]) {
							local61 = true;
							break;
						}
					}
					if (local61) {
						local84 = eyeZ - local19.minZ;
						if (local84 > 32) {
							local19.mode = 3;
						} else {
							if (local84 >= -32) {
								continue;
							}
							local19.mode = 4;
							local84 = -local84;
						}
						local19.minDeltaX = (local19.minX - eyeX << 8) / local84;
						local19.maxDeltaX = (local19.maxX - eyeX << 8) / local84;
						local19.minDeltaY = (local19.minY - eyeY << 8) / local84;
						local19.maxDeltaY = (local19.maxY - eyeY << 8) / local84;
						activeOccluders[activeOccluderCount++] = local19;
					}
				}
			} else if (local19.type == 4) {
				local30 = local19.minY - eyeY;
				if (local30 > 128) {
					local43 = local19.minTileZ + 25 - eyeTileZ;
					if (local43 < 0) {
						local43 = 0;
					}
					local54 = local19.maxTileZ + 25 - eyeTileZ;
					if (local54 > 50) {
						local54 = 50;
					}
					if (local43 <= local54) {
						@Pc(330) int local330 = local19.minTileX + 25 - eyeTileX;
						if (local330 < 0) {
							local330 = 0;
						}
						local84 = local19.maxTileX + 25 - eyeTileX;
						if (local84 > 50) {
							local84 = 50;
						}
						@Pc(348) boolean local348 = false;
						label149: for (@Pc(350) int local350 = local330; local350 <= local84; local350++) {
							for (@Pc(354) int local354 = local43; local354 <= local54; local354++) {
								if (visibilityMap[local350][local354]) {
									local348 = true;
									break label149;
								}
							}
						}
						if (local348) {
							local19.mode = 5;
							local19.minDeltaX = (local19.minX - eyeX << 8) / local30;
							local19.maxDeltaX = (local19.maxX - eyeX << 8) / local30;
							local19.minDeltaZ = (local19.minZ - eyeZ << 8) / local30;
							local19.maxDeltaZ = (local19.maxZ - eyeZ << 8) / local30;
							activeOccluders[activeOccluderCount++] = local19;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "g", descriptor = "(III)Z")
	private boolean tileVisible(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(8) int local8 = this.levelTileOcclusionCycles[arg0][arg1][arg2];
		if (local8 == -cycle) {
			return false;
		} else if (local8 == cycle) {
			return true;
		} else {
			@Pc(23) int local23 = arg1 << 7;
			@Pc(27) int local27 = arg2 << 7;
			if (this.occluded(local23 + 1, this.levelHeightmaps[arg0][arg1][arg2], local27 + 1) && this.occluded(local23 + 128 - 1, this.levelHeightmaps[arg0][arg1 + 1][arg2], local27 + 1) && this.occluded(local23 + 128 - 1, this.levelHeightmaps[arg0][arg1 + 1][arg2 + 1], local27 + 128 - 1) && this.occluded(local23 + 1, this.levelHeightmaps[arg0][arg1][arg2 + 1], local27 + 128 - 1)) {
				this.levelTileOcclusionCycles[arg0][arg1][arg2] = cycle;
				return true;
			} else {
				this.levelTileOcclusionCycles[arg0][arg1][arg2] = -cycle;
				return false;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "i", descriptor = "(IIII)Z")
	private boolean wallVisible(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (!this.tileVisible(arg0, arg1, arg2)) {
			return false;
		}
		@Pc(11) int local11 = arg1 << 7;
		@Pc(15) int local15 = arg2 << 7;
		@Pc(26) int local26 = this.levelHeightmaps[arg0][arg1][arg2] - 1;
		@Pc(30) int local30 = local26 - 120;
		@Pc(34) int local34 = local26 - 230;
		@Pc(38) int local38 = local26 - 238;
		if (arg3 < 16) {
			if (arg3 == 1) {
				if (local11 > eyeX) {
					if (!this.occluded(local11, local26, local15)) {
						return false;
					}
					if (!this.occluded(local11, local26, local15 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(local11, local30, local15)) {
						return false;
					}
					if (!this.occluded(local11, local30, local15 + 128)) {
						return false;
					}
				}
				if (!this.occluded(local11, local34, local15)) {
					return false;
				}
				if (!this.occluded(local11, local34, local15 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 2) {
				if (local15 < eyeZ) {
					if (!this.occluded(local11, local26, local15 + 128)) {
						return false;
					}
					if (!this.occluded(local11 + 128, local26, local15 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(local11, local30, local15 + 128)) {
						return false;
					}
					if (!this.occluded(local11 + 128, local30, local15 + 128)) {
						return false;
					}
				}
				if (!this.occluded(local11, local34, local15 + 128)) {
					return false;
				}
				if (!this.occluded(local11 + 128, local34, local15 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 4) {
				if (local11 < eyeX) {
					if (!this.occluded(local11 + 128, local26, local15)) {
						return false;
					}
					if (!this.occluded(local11 + 128, local26, local15 + 128)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(local11 + 128, local30, local15)) {
						return false;
					}
					if (!this.occluded(local11 + 128, local30, local15 + 128)) {
						return false;
					}
				}
				if (!this.occluded(local11 + 128, local34, local15)) {
					return false;
				}
				if (!this.occluded(local11 + 128, local34, local15 + 128)) {
					return false;
				}
				return true;
			}
			if (arg3 == 8) {
				if (local15 > eyeZ) {
					if (!this.occluded(local11, local26, local15)) {
						return false;
					}
					if (!this.occluded(local11 + 128, local26, local15)) {
						return false;
					}
				}
				if (arg0 > 0) {
					if (!this.occluded(local11, local30, local15)) {
						return false;
					}
					if (!this.occluded(local11 + 128, local30, local15)) {
						return false;
					}
				}
				if (!this.occluded(local11, local34, local15)) {
					return false;
				}
				if (!this.occluded(local11 + 128, local34, local15)) {
					return false;
				}
				return true;
			}
		}
		if (!this.occluded(local11 + 64, local38, local15 + 64)) {
			return false;
		} else if (arg3 == 16) {
			return this.occluded(local11, local34, local15 + 128);
		} else if (arg3 == 32) {
			return this.occluded(local11 + 128, local34, local15 + 128);
		} else if (arg3 == 64) {
			return this.occluded(local11 + 128, local34, local15);
		} else if (arg3 == 128) {
			return this.occluded(local11, local34, local15);
		} else {
			System.out.println("Warning unsupported wall type");
			return true;
		}
	}

	@OriginalMember(owner = "client!r", name = "j", descriptor = "(IIII)Z")
	private boolean visible(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if (this.tileVisible(arg0, arg1, arg2)) {
			@Pc(11) int local11 = arg1 << 7;
			@Pc(15) int local15 = arg2 << 7;
			return this.occluded(local11 + 1, this.levelHeightmaps[arg0][arg1][arg2] - arg3, local15 + 1) && this.occluded(local11 + 128 - 1, this.levelHeightmaps[arg0][arg1 + 1][arg2] - arg3, local15 + 1) && this.occluded(local11 + 128 - 1, this.levelHeightmaps[arg0][arg1 + 1][arg2 + 1] - arg3, local15 + 128 - 1) && this.occluded(local11 + 1, this.levelHeightmaps[arg0][arg1][arg2 + 1] - arg3, local15 + 128 - 1);
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIII)Z")
	private boolean locVisible(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(19) int local19;
		@Pc(23) int local23;
		if (arg1 != arg2 || arg3 != arg4) {
			for (local19 = arg1; local19 <= arg2; local19++) {
				for (local23 = arg3; local23 <= arg4; local23++) {
					if (this.levelTileOcclusionCycles[arg0][local19][local23] == -cycle) {
						return false;
					}
				}
			}
			local23 = (arg1 << 7) + 1;
			@Pc(160) int local160 = (arg3 << 7) + 2;
			@Pc(171) int local171 = this.levelHeightmaps[arg0][arg1][arg3] - arg5;
			if (!this.occluded(local23, local171, local160)) {
				return false;
			}
			@Pc(185) int local185 = (arg2 << 7) - 1;
			if (!this.occluded(local185, local171, local160)) {
				return false;
			}
			@Pc(199) int local199 = (arg4 << 7) - 1;
			if (!this.occluded(local23, local171, local199)) {
				return false;
			} else if (this.occluded(local185, local171, local199)) {
				return true;
			} else {
				return false;
			}
		} else if (this.tileVisible(arg0, arg1, arg3)) {
			local19 = arg1 << 7;
			local23 = arg3 << 7;
			return this.occluded(local19 + 1, this.levelHeightmaps[arg0][arg1][arg3] - arg5, local23 + 1) && this.occluded(local19 + 128 - 1, this.levelHeightmaps[arg0][arg1 + 1][arg3] - arg5, local23 + 1) && this.occluded(local19 + 128 - 1, this.levelHeightmaps[arg0][arg1 + 1][arg3 + 1] - arg5, local23 + 128 - 1) && this.occluded(local19 + 1, this.levelHeightmaps[arg0][arg1][arg3 + 1] - arg5, local23 + 128 - 1);
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "h", descriptor = "(III)Z")
	private boolean occluded(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		for (@Pc(1) int local1 = 0; local1 < activeOccluderCount; local1++) {
			@Pc(7) Occluder local7 = activeOccluders[local1];
			@Pc(16) int local16;
			@Pc(28) int local28;
			@Pc(38) int local38;
			@Pc(48) int local48;
			@Pc(58) int local58;
			if (local7.mode == 1) {
				local16 = local7.minX - arg0;
				if (local16 > 0) {
					local28 = local7.minZ + (local7.minDeltaZ * local16 >> 8);
					local38 = local7.maxZ + (local7.maxDeltaZ * local16 >> 8);
					local48 = local7.minY + (local7.minDeltaY * local16 >> 8);
					local58 = local7.maxY + (local7.maxDeltaY * local16 >> 8);
					if (arg2 >= local28 && arg2 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.mode == 2) {
				local16 = arg0 - local7.minX;
				if (local16 > 0) {
					local28 = local7.minZ + (local7.minDeltaZ * local16 >> 8);
					local38 = local7.maxZ + (local7.maxDeltaZ * local16 >> 8);
					local48 = local7.minY + (local7.minDeltaY * local16 >> 8);
					local58 = local7.maxY + (local7.maxDeltaY * local16 >> 8);
					if (arg2 >= local28 && arg2 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.mode == 3) {
				local16 = local7.minZ - arg2;
				if (local16 > 0) {
					local28 = local7.minX + (local7.minDeltaX * local16 >> 8);
					local38 = local7.maxX + (local7.maxDeltaX * local16 >> 8);
					local48 = local7.minY + (local7.minDeltaY * local16 >> 8);
					local58 = local7.maxY + (local7.maxDeltaY * local16 >> 8);
					if (arg0 >= local28 && arg0 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.mode == 4) {
				local16 = arg2 - local7.minZ;
				if (local16 > 0) {
					local28 = local7.minX + (local7.minDeltaX * local16 >> 8);
					local38 = local7.maxX + (local7.maxDeltaX * local16 >> 8);
					local48 = local7.minY + (local7.minDeltaY * local16 >> 8);
					local58 = local7.maxY + (local7.maxDeltaY * local16 >> 8);
					if (arg0 >= local28 && arg0 <= local38 && arg1 >= local48 && arg1 <= local58) {
						return true;
					}
				}
			} else if (local7.mode == 5) {
				local16 = arg1 - local7.minY;
				if (local16 > 0) {
					local28 = local7.minX + (local7.minDeltaX * local16 >> 8);
					local38 = local7.maxX + (local7.maxDeltaX * local16 >> 8);
					local48 = local7.minZ + (local7.minDeltaZ * local16 >> 8);
					local58 = local7.maxZ + (local7.maxDeltaZ * local16 >> 8);
					if (arg0 >= local28 && arg0 <= local38 && arg2 >= local48 && arg2 <= local58) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
