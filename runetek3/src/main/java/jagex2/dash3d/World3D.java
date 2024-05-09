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

// name taken from rsc
@OriginalClass("client!r")
public class World3D {

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
	public static Occluder[][] levelOccluders = new Occluder[LEVEL_COUNT][500];

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
	private final int[][] MINIMAP_OVERLAY_SHAPE = new int[][] {
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, // PLAIN_SHAPE
		{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, // DIAGONAL_SHAPE
		{ 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, // LEFT_SEMI_DIAGONAL_SMALL_SHAPE
		{ 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1 }, // RIGHT_SEMI_DIAGONAL_SMALL_SHAPE
		{ 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, // LEFT_SEMI_DIAGONAL_BIG_SHAPE
		{ 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, // RIGHT_SEMI_DIAGONAL_BIG_SHAPE
		{ 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0 }, // HALF_SQUARE_SHAPE
		{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0 }, // CORNER_SMALL_SHAPE
		{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 }, // CORNER_BIG_SHAPE
		{ 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 }, // FAN_SMALL_SHAPE
		{ 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1 }, // FAN_BIG_SHAPE
		{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 }  // TRAPEZIUM_SHAPE
	};

	@OriginalMember(owner = "client!r", name = "jb", descriptor = "[[I")
	private final int[][] MINIMAP_OVERLAY_ROTATION = new int[][] {
		{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
		{ 12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3 },
		{ 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 },
		{ 3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12 }
	};

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
	public World3D(@OriginalArg(1) int[][][] levelHeightmaps, @OriginalArg(2) int maxTileZ, @OriginalArg(3) int maxLevel, @OriginalArg(4) int maxTileX) {
		this.maxLevel = maxLevel;
		this.maxTileX = maxTileX;
		this.maxTileZ = maxTileZ;
		this.levelTiles = new Tile[maxLevel][maxTileX][maxTileZ];
		this.levelTileOcclusionCycles = new int[maxLevel][maxTileX + 1][maxTileZ + 1];
		this.levelHeightmaps = levelHeightmaps;
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
	public static void addOccluder(@OriginalArg(6) int level, @OriginalArg(4) int type, @OriginalArg(1) int minX, @OriginalArg(7) int minY, @OriginalArg(8) int minZ, @OriginalArg(5) int maxX, @OriginalArg(3) int maxY, @OriginalArg(0) int maxZ) {
		@Pc(3) Occluder occluder = new Occluder();
		occluder.minTileX = minX / 128;
		occluder.maxTileX = maxX / 128;
		occluder.minTileZ = minZ / 128;
		occluder.maxTileZ = maxZ / 128;
		occluder.type = type;
		occluder.minX = minX;
		occluder.maxX = maxX;
		occluder.minZ = minZ;
		occluder.maxZ = maxZ;
		occluder.minY = minY;
		occluder.maxY = maxY;
		levelOccluders[level][levelOccluderCount[level]++] = occluder;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "([IIIBII)V")
	public static void init(@OriginalArg(2) int viewportWidth, @OriginalArg(4) int viewportHeight, @OriginalArg(5) int frustumStart, @OriginalArg(1) int frustumEnd, @OriginalArg(0) int[] pitchDistance) {
		viewportLeft = 0;
		viewportTop = 0;
		viewportRight = viewportWidth;
		viewportBottom = viewportHeight;
		viewportCenterX = viewportWidth / 2;
		viewportCenterY = viewportHeight / 2;

		@Pc(28) boolean[][][][] matrix = new boolean[9][32][53][53];
		for (@Pc(30) int pitch = 128; pitch <= 384; pitch += 32) {
			for (int yaw = 0; yaw < 2048; yaw += 64) {
				sinEyePitch = Model.sin[pitch];
				cosEyePitch = Model.cos[pitch];
				sinEyeYaw = Model.sin[yaw];
				cosEyeYaw = Model.cos[yaw];

				int pitchLevel = (pitch - 128) / 32;
				int yawLevel = yaw / 64;
				for (int dx = -26; dx <= 26; dx++) {
					for (@Pc(68) int dz = -26; dz <= 26; dz++) {
						int x = dx * 128;
						int z = dz * 128;

						@Pc(80) boolean visible = false;
						for (@Pc(83) int y = -frustumStart; y <= frustumEnd; y += 128) {
							if (testPoint(x, z, pitchDistance[pitchLevel] + y)) {
								visible = true;
								break;
							}
						}

						matrix[pitchLevel][yawLevel][dx + 25 + 1][dz + 25 + 1] = visible;
					}
				}
			}
		}

		for (int pitchLevel = 0; pitchLevel < 8; pitchLevel++) {
			for (int yawLevel = 0; yawLevel < 32; yawLevel++) {
				for (int x = -25; x < 25; x++) {
					for (int z = -25; z < 25; z++) {
						@Pc(155) boolean visible = false;
						check_areas:
						for (int dx = -1; dx <= 1; dx++) {
							for (int dz = -1; dz <= 1; dz++) {
								if (matrix[pitchLevel][yawLevel][x + dx + 25 + 1][z + dz + 25 + 1]) {
									visible = true;
									break check_areas;
								}

								if (matrix[pitchLevel][(yawLevel + 1) % 31][x + dx + 25 + 1][z + dz + 25 + 1]) {
									visible = true;
									break check_areas;
								}

								if (matrix[pitchLevel + 1][yawLevel][x + dx + 25 + 1][z + dz + 25 + 1]) {
									visible = true;
									break check_areas;
								}

								if (matrix[pitchLevel + 1][(yawLevel + 1) % 31][x + dx + 25 + 1][z + dz + 25 + 1]) {
									visible = true;
									break check_areas;
								}
							}
						}

						visibilityMatrix[pitchLevel][yawLevel][x + 25][z + 25] = visible;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "h", descriptor = "(IIII)Z")
	private static boolean testPoint(@OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(2) int y) {
		@Pc(11) int px = z * sinEyeYaw + x * cosEyeYaw >> 16;
		@Pc(21) int tmp = z * cosEyeYaw - x * sinEyeYaw >> 16;
		@Pc(31) int pz = y * sinEyePitch + tmp * cosEyePitch >> 16;
		@Pc(41) int py = y * cosEyePitch - tmp * sinEyePitch >> 16;
		if (pz < 50 || pz > 3500) {
			return false;
		}

		@Pc(45) int viewportX = viewportCenterX + (px << 9) / pz;
		@Pc(76) int viewportY = viewportCenterY + (py << 9) / pz;
		return viewportX >= viewportLeft && viewportX <= viewportRight && viewportY >= viewportTop && viewportY <= viewportBottom;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(I)V")
	public void reset() {
		for (@Pc(3) int level = 0; level < this.maxLevel; level++) {
			for (int x = 0; x < this.maxTileX; x++) {
				for (int z = 0; z < this.maxTileZ; z++) {
					this.levelTiles[level][x][z] = null;
				}
			}
		}

		for (int l = 0; l < LEVEL_COUNT; l++) {
			for (int o = 0; o < levelOccluderCount[l]; o++) {
				levelOccluders[l][o] = null;
			}

			levelOccluderCount[l] = 0;
		}

		for (int i = 0; i < this.temporaryLocCount; i++) {
			this.temporaryLocs[i] = null;
		}

		this.temporaryLocCount = 0;

		for (@Pc(88) int i = 0; i < locBuffer.length; i++) {
			locBuffer[i] = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(II)V")
	public void setMinLevel(@OriginalArg(1) int level) {
		this.minLevel = level;

		for (@Pc(6) int stx = 0; stx < this.maxTileX; stx++) {
			for (@Pc(10) int stz = 0; stz < this.maxTileZ; stz++) {
				this.levelTiles[level][stx][stz] = new Tile(level, stx, stz);
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIB)V")
	public void setBridge(@OriginalArg(1) int stx, @OriginalArg(0) int stz) {
		@Pc(10) Tile ground = this.levelTiles[0][stx][stz];
		for (@Pc(12) int level = 0; level < 3; level++) {
			this.levelTiles[level][stx][stz] = this.levelTiles[level + 1][stx][stz];
			if (this.levelTiles[level][stx][stz] != null) {
				this.levelTiles[level][stx][stz].level--;
			}
		}

		if (this.levelTiles[0][stx][stz] == null) {
			this.levelTiles[0][stx][stz] = new Tile(0, stx, stz);
		}

		this.levelTiles[0][stx][stz].bridge = ground;
		this.levelTiles[3][stx][stz] = null;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIII)V")
	public void setDrawLevel(@OriginalArg(0) int level, @OriginalArg(1) int stx, @OriginalArg(2) int stz, @OriginalArg(3) int drawLevel) {
		@Pc(8) Tile tile = this.levelTiles[level][stx][stz];
		if (tile == null) {
			return;
		}

		this.levelTiles[level][stx][stz].drawLevel = drawLevel;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIIIIIIIIIIIIII)V")
	public void setTile(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z, @OriginalArg(3) int shape, @OriginalArg(4) int angle, @OriginalArg(5) int textureId, @OriginalArg(6) int southwestY, @OriginalArg(7) int southeastY, @OriginalArg(8) int northeastY, @OriginalArg(9) int northwestY, @OriginalArg(10) int southwestColor, @OriginalArg(11) int southeastColor, @OriginalArg(12) int northeastColor, @OriginalArg(13) int northwestColor, @OriginalArg(14) int southwestColor2, @OriginalArg(15) int southeastColor2, @OriginalArg(16) int northeastColor2, @OriginalArg(17) int northwestColor2, @OriginalArg(18) int backgroundRgb, @OriginalArg(19) int foregroundRgb) {
		@Pc(14) TileUnderlay underlay;
		@Pc(16) int l;
		if (shape == 0) {
			underlay = new TileUnderlay(southwestColor, southeastColor, northeastColor, northwestColor, -1, backgroundRgb, false);
			for (l = level; l >= 0; l--) {
				if (this.levelTiles[l][x][z] == null) {
					this.levelTiles[l][x][z] = new Tile(l, x, z);
				}
			}
			this.levelTiles[level][x][z].underlay = underlay;
		} else if (shape == 1) {
			underlay = new TileUnderlay(southwestColor2, southeastColor2, northeastColor2, northwestColor2, textureId, foregroundRgb, southwestY == southeastY && southwestY == northeastY && southwestY == northwestY);
			for (l = level; l >= 0; l--) {
				if (this.levelTiles[l][x][z] == null) {
					this.levelTiles[l][x][z] = new Tile(l, x, z);
				}
			}
			this.levelTiles[level][x][z].underlay = underlay;
		} else {
			@Pc(145) TileOverlay overlay = new TileOverlay(x, shape, southeastColor2, southeastY, northeastColor, angle, southwestColor, northwestY, foregroundRgb, southwestColor2, textureId, northwestColor2, backgroundRgb, northeastY, northeastColor2, northwestColor, southwestY, z, southeastColor);
			for (l = level; l >= 0; l--) {
				if (this.levelTiles[l][x][z] == null) {
					this.levelTiles[l][x][z] = new Tile(l, x, z);
				}
			}
			this.levelTiles[level][x][z].overlay = overlay;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;BIIIIBI)V")
	public void addGroundDecoration(@OriginalArg(0) Model model, @OriginalArg(5) int tileLevel, @OriginalArg(2) int tileX, @OriginalArg(4) int tileZ, @OriginalArg(7) int y, @OriginalArg(3) int bitset, @OriginalArg(6) byte info) {
		@Pc(3) GroundDecoration decor = new GroundDecoration();
		decor.model = model;
		decor.x = tileX * 128 + 64;
		decor.z = tileZ * 128 + 64;
		decor.y = y;
		decor.bitset = bitset;
		decor.info = info;
		if (this.levelTiles[tileLevel][tileX][tileZ] == null) {
			this.levelTiles[tileLevel][tileX][tileZ] = new Tile(tileLevel, tileX, tileZ);
		}
		this.levelTiles[tileLevel][tileX][tileZ].groundDecoration = decor;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IIIIILclient!eb;I)V")
	public void addObjStack(@OriginalArg(6) int stx, @OriginalArg(5) int stz, @OriginalArg(2) int y, @OriginalArg(3) int level, @OriginalArg(4) int bitset, @OriginalArg(0) Model topObj, @OriginalArg(7) Model middleObj, @OriginalArg(1) Model bottomObj) {
		@Pc(3) ObjStack stack = new ObjStack();
		stack.topObj = topObj;
		stack.x = stx * 128 + 64;
		stack.z = stz * 128 + 64;
		stack.y = y;
		stack.bitset = bitset;
		stack.bottomObj = bottomObj;
		stack.middleObj = middleObj;
		@Pc(38) int stackOffset = 0;
		@Pc(47) Tile tile = this.levelTiles[level][stx][stz];
		if (tile != null) {
			for (@Pc(51) int l = 0; l < tile.locCount; l++) {
				@Pc(60) int height = tile.locs[l].model.objRaise;
				if (height > stackOffset) {
					stackOffset = height;
				}
			}
		}
		stack.offset = stackOffset;
		if (this.levelTiles[level][stx][stz] == null) {
			this.levelTiles[level][stx][stz] = new Tile(level, stx, stz);
		}
		this.levelTiles[level][stx][stz].objStack = stack;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIILclient!eb;Lclient!eb;IIIB)V")
	public void addWall(@OriginalArg(2) int level, @OriginalArg(7) int tileX, @OriginalArg(9) int tileZ, @OriginalArg(1) int y, @OriginalArg(3) int typeA, @OriginalArg(0) int typeB, @OriginalArg(5) Model modelA, @OriginalArg(6) Model modelB, @OriginalArg(8) int bitset, @OriginalArg(10) byte info) {
		if (modelA == null && modelB == null) {
			return;
		}

		@Pc(8) Wall wall = new Wall();
		wall.bitset = bitset;
		wall.info = info;
		wall.x = tileX * 128 + 64;
		wall.z = tileZ * 128 + 64;
		wall.y = y;
		wall.modelA = modelA;
		wall.modelB = modelB;
		wall.typeA = typeA;
		wall.typeB = typeB;
		for (@Pc(54) int l = level; l >= 0; l--) {
			if (this.levelTiles[l][tileX][tileZ] == null) {
				this.levelTiles[l][tileX][tileZ] = new Tile(l, tileX, tileZ);
			}
		}
		this.levelTiles[level][tileX][tileZ].wall = wall;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIIILclient!eb;BI)V")
	public void setWallDecoration(@OriginalArg(11) int level, @OriginalArg(8) int tileX, @OriginalArg(1) int tileZ, @OriginalArg(0) int y, @OriginalArg(7) int offsetX, @OriginalArg(2) int offsetZ, @OriginalArg(3) int bitset, @OriginalArg(9) Model model, @OriginalArg(10) byte info, @OriginalArg(4) int angle, @OriginalArg(5) int type) {
		if (model == null) {
			return;
		}

		@Pc(10) WallDecoration decor = new WallDecoration();
		decor.bitset = bitset;
		decor.info = info;
		decor.x = tileX * 128 + offsetX + 64;
		decor.z = tileZ * 128 + offsetZ + 64;
		decor.y = y;
		decor.model = model;
		decor.type = type;
		decor.angle = angle;
		for (@Pc(48) int l = level; l >= 0; l--) {
			if (this.levelTiles[l][tileX][tileZ] == null) {
				this.levelTiles[l][tileX][tileZ] = new Tile(l, tileX, tileZ);
			}
		}
		this.levelTiles[level][tileX][tileZ].wallDecoration = decor;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILclient!w;IIIIBLclient!eb;II)Z")
	public boolean addLoc(@OriginalArg(2) int level, @OriginalArg(6) int tileX, @OriginalArg(5) int tileZ, @OriginalArg(0) int y, @OriginalArg(9) Model model, @OriginalArg(3) Entity entity, @OriginalArg(4) int bitset, @OriginalArg(8) byte info, @OriginalArg(7) int width, @OriginalArg(11) int length, @OriginalArg(10) int yaw) {
		if (model == null && entity == null) {
			return true;
		} else {
			@Pc(17) int sceneX = tileX * 128 + width * 64;
			@Pc(25) int sceneZ = tileZ * 128 + length * 64;
			return this.addLoc(sceneX, sceneZ, y, level, tileX, tileZ, width, length, model, entity, bitset, info, yaw, false);
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIZLclient!eb;Lclient!w;II)Z")
	public boolean addTemporary(@OriginalArg(10) int level, @OriginalArg(4) int x, @OriginalArg(9) int y, @OriginalArg(1) int z, @OriginalArg(7) Model model, @OriginalArg(8) Entity entity, @OriginalArg(5) int bitset, @OriginalArg(3) int yaw, @OriginalArg(2) int padding, @OriginalArg(6) boolean forwardPadding) {
		if (model == null && entity == null) {
			return true;
		}
		@Pc(9) int x0 = x - padding;
		@Pc(13) int z0 = z - padding;
		@Pc(17) int x1 = x + padding;
		@Pc(21) int z1 = z + padding;
		if (forwardPadding) {
			if (yaw > 640 && yaw < 1408) {
				z1 += 128;
			}
			if (yaw > 1152 && yaw < 1920) {
				x1 += 128;
			}
			if (yaw > 1664 || yaw < 384) {
				z0 -= 128;
			}
			if (yaw > 128 && yaw < 896) {
				x0 -= 128;
			}
		}
		x0 /= 128;
		z0 /= 128;
		x1 /= 128;
		z1 /= 128;
		return this.addLoc(x, z, y, level, x0, z0, x1 + 1 - x0, z1 - z0 + 1, model, entity, bitset, (byte) 0, yaw, true);
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IILclient!eb;IIIIIILclient!w;ZIII)Z")
	public boolean addTemporary(@OriginalArg(11) int level, @OriginalArg(13) int x, @OriginalArg(4) int y, @OriginalArg(3) int z, @OriginalArg(8) int minTileX, @OriginalArg(7) int minTileZ, @OriginalArg(0) int maxTileX, @OriginalArg(12) int maxTileZ, @OriginalArg(2) Model model, @OriginalArg(9) Entity entity, @OriginalArg(5) int bitset, @OriginalArg(6) int yaw) {
		return model == null && entity == null || this.addLoc(x, z, y, level, minTileX, minTileZ, maxTileX + 1 - minTileX, maxTileZ - minTileZ + 1, model, entity, bitset, (byte) 0, yaw, true);
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIIILclient!eb;Lclient!w;IZIB)Z")
	private boolean addLoc(@OriginalArg(5) int x, @OriginalArg(6) int z, @OriginalArg(7) int y, @OriginalArg(0) int level, @OriginalArg(1) int tileX, @OriginalArg(2) int tileZ, @OriginalArg(3) int tileSizeX, @OriginalArg(4) int tileSizeZ, @OriginalArg(8) Model model, @OriginalArg(9) Entity entity, @OriginalArg(12) int bitset, @OriginalArg(13) byte info, @OriginalArg(10) int yaw, @OriginalArg(11) boolean temporary) {
		if (model == null && entity == null) {
			return false;
		}
		for (@Pc(9) int tx = tileX; tx < tileX + tileSizeX; tx++) {
			for (@Pc(13) int tz = tileZ; tz < tileZ + tileSizeZ; tz++) {
				if (tx < 0 || tz < 0 || tx >= this.maxTileX || tz >= this.maxTileZ) {
					return false;
				}
				@Pc(38) Tile tile = this.levelTiles[level][tx][tz];
				if (tile != null && tile.locCount >= 5) {
					return false;
				}
			}
		}
		@Pc(62) Loc loc = new Loc();
		loc.bitset = bitset;
		loc.info = info;
		loc.level = level;
		loc.x = x;
		loc.z = z;
		loc.y = y;
		loc.model = model;
		loc.entity = entity;
		loc.yaw = yaw;
		loc.minSceneTileX = tileX;
		loc.minSceneTileZ = tileZ;
		loc.maxSceneTileX = tileX + tileSizeX - 1;
		loc.maxSceneTileZ = tileZ + tileSizeZ - 1;
		for (@Pc(111) int tx = tileX; tx < tileX + tileSizeX; tx++) {
			for (@Pc(115) int tz = tileZ; tz < tileZ + tileSizeZ; tz++) {
				@Pc(119) int spans = 0;
				if (tx > tileX) {
					spans |= 0x1;
				}
				if (tx < tileX + tileSizeX - 1) {
					spans += 0x4;
				}
				if (tz > tileZ) {
					spans += 0x8;
				}
				if (tz < tileZ + tileSizeZ - 1) {
					spans += 0x2;
				}
				for (@Pc(145) int l = level; l >= 0; l--) {
					if (this.levelTiles[l][tx][tz] == null) {
						this.levelTiles[l][tx][tz] = new Tile(l, tx, tz);
					}
				}
				@Pc(182) Tile tile = this.levelTiles[level][tx][tz];
				tile.locs[tile.locCount] = loc;
				tile.locSpan[tile.locCount] = spans;
				tile.locSpans |= spans;
				tile.locCount++;
			}
		}

		if (temporary) {
			this.temporaryLocs[this.temporaryLocCount++] = loc;
		}

		return true;
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(I)V")
	public void clearTemporaryLocs() {
		for (@Pc(1) int i = 0; i < this.temporaryLocCount; i++) {
			@Pc(8) Loc loc = this.temporaryLocs[i];
			this.removeLoc(loc);
			this.temporaryLocs[i] = null;
		}

		this.temporaryLocCount = 0;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!p;B)V")
	private void removeLoc(@OriginalArg(0) Loc loc) {
		for (@Pc(4) int tx = loc.minSceneTileX; tx <= loc.maxSceneTileX; tx++) {
			for (@Pc(9) int tz = loc.minSceneTileZ; tz <= loc.maxSceneTileZ; tz++) {
				@Pc(21) Tile tile = this.levelTiles[loc.level][tx][tz];
				if (tile == null) {
					continue;
				}

				for (@Pc(25) int i = 0; i < tile.locCount; i++) {
					if (tile.locs[i] == loc) {
						tile.locCount--;
						for (int j = i; j < tile.locCount; j++) {
							tile.locs[j] = tile.locs[j + 1];
							tile.locSpan[j] = tile.locSpan[j + 1];
						}
						tile.locs[tile.locCount] = null;
						break;
					}
				}

				tile.locSpans = 0;

				for (int i = 0; i < tile.locCount; i++) {
					tile.locSpans |= tile.locSpan[i];
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(ILclient!eb;III)V")
	public void setLocModel(@OriginalArg(3) int level, @OriginalArg(0) int x, @OriginalArg(4) int z, @OriginalArg(1) Model model) {
		if (model == null) {
			return;
		}

		@Pc(13) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		for (int i = 0; i < tile.locCount; i++) {
			@Pc(38) Loc loc = tile.locs[i];
			if ((loc.bitset >> 29 & 0x3) == 2) {
				loc.model = model;
				return;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIB)V")
	public void setWallDecorationOffset(@OriginalArg(0) int level, @OriginalArg(2) int x, @OriginalArg(1) int z, @OriginalArg(3) int offset) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		@Pc(24) WallDecoration decor = tile.wallDecoration;
		if (decor == null) {
			return;
		}

		@Pc(33) int sx = x * 128 + 64;
		@Pc(39) int sz = z * 128 + 64;
		decor.x = sx + (decor.x - sx) * offset / 16;
		decor.z = sz + (decor.z - sz) * offset / 16;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIILclient!eb;I)V")
	public void setWallDecorationModel(@OriginalArg(4) int level, @OriginalArg(2) int x, @OriginalArg(1) int z, @OriginalArg(3) Model model) {
		if (model == null) {
			return;
		}

		@Pc(15) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		@Pc(21) WallDecoration decor = tile.wallDecoration;
		if (decor == null) {
			return;
		}

		decor.model = model;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;IIII)V")
	public void setGroundDecorationModel(@OriginalArg(4) int level, @OriginalArg(3) int x, @OriginalArg(1) int z, @OriginalArg(0) Model model) {
		if (model == null) {
			return;
		}

		@Pc(15) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		@Pc(21) GroundDecoration decor = tile.groundDecoration;
		if (decor == null) {
			return;
		}

		decor.model = model;
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(ILclient!eb;III)V")
	public void setWallModel(@OriginalArg(4) int level, @OriginalArg(3) int x, @OriginalArg(2) int z, @OriginalArg(1) Model model) {
		if (model == null) {
			return;
		}

		@Pc(21) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		@Pc(27) Wall wall = tile.wall;
		if (wall == null) {
			return;
		}

		wall.modelA = model;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IZII)V")
	public void setWallModels(@OriginalArg(4) int x, @OriginalArg(2) int z, @OriginalArg(5) int level, @OriginalArg(0) Model modelA, @OriginalArg(1) Model modelB) {
		if (modelA == null) {
			return;
		}

		@Pc(11) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		@Pc(17) Wall wall = tile.wall;
		if (wall == null) {
			return;
		}

		wall.modelA = modelA;
		wall.modelB = modelB;
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(IIII)V")
	public void removeWall(@OriginalArg(1) int level, @OriginalArg(0) int x, @OriginalArg(2) int z, @OriginalArg(3) int force) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		if (force == 1 && tile != null) {
			tile.wall = null;
		}
	}

	@OriginalMember(owner = "client!r", name = "c", descriptor = "(IIII)V")
	public void removeWallDecoration(@OriginalArg(0) int level, @OriginalArg(3) int x, @OriginalArg(1) int z) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		tile.wallDecoration = null;
	}

	@OriginalMember(owner = "client!r", name = "d", descriptor = "(IIII)V")
	public void removeLoc(@OriginalArg(3) int level, @OriginalArg(0) int x, @OriginalArg(1) int z) {
		@Pc(10) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		for (@Pc(15) int l = 0; l < tile.locCount; l++) {
			@Pc(22) Loc loc = tile.locs[l];
			if ((loc.bitset >> 29 & 0x3) == 2 && loc.minSceneTileX == x && loc.minSceneTileZ == z) {
				this.removeLoc(loc);
				return;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "e", descriptor = "(IIII)V")
	public void removeGroundDecoration(@OriginalArg(0) int level, @OriginalArg(2) int x, @OriginalArg(3) int z) {
		@Pc(16) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		tile.groundDecoration = null;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(III)V")
	public void removeObjStack(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		tile.objStack = null;
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(III)I")
	public int getWallBitset(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		return tile == null || tile.wall == null ? 0 : tile.wall.bitset;
	}

	@OriginalMember(owner = "client!r", name = "f", descriptor = "(IIII)I")
	public int getWallDecorationBitset(@OriginalArg(0) int level, @OriginalArg(1) int z, @OriginalArg(3) int x) {
		@Pc(19) Tile tile = this.levelTiles[level][x][z];
		return tile == null || tile.wallDecoration == null ? 0 : tile.wallDecoration.bitset;
	}

	@OriginalMember(owner = "client!r", name = "c", descriptor = "(III)I")
	public int getLocBitset(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return 0;
		}

		for (@Pc(14) int l = 0; l < tile.locCount; l++) {
			@Pc(21) Loc loc = tile.locs[l];
			if ((loc.bitset >> 29 & 0x3) == 2 && loc.minSceneTileX == x && loc.minSceneTileZ == z) {
				return loc.bitset;
			}
		}

		return 0;
	}

	@OriginalMember(owner = "client!r", name = "d", descriptor = "(III)I")
	public int getGroundDecorationBitset(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		return tile == null || tile.groundDecoration == null ? 0 : tile.groundDecoration.bitset;
	}

	@OriginalMember(owner = "client!r", name = "g", descriptor = "(IIII)I")
	public int getInfo(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z, @OriginalArg(3) int bitset) {
		@Pc(8) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return -1;
		} else if (tile.wall != null && tile.wall.bitset == bitset) {
			return tile.wall.info & 0xFF;
		} else if (tile.wallDecoration != null && tile.wallDecoration.bitset == bitset) {
			return tile.wallDecoration.info & 0xFF;
		} else if (tile.groundDecoration != null && tile.groundDecoration.bitset == bitset) {
			return tile.groundDecoration.info & 0xFF;
		} else {
			for (@Pc(56) int i = 0; i < tile.locCount; i++) {
				if (tile.locs[i].bitset == bitset) {
					return tile.locs[i].info & 0xFF;
				}
			}

			return -1;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIZ)V")
	public void buildModels(@OriginalArg(1) int lightAmbient, @OriginalArg(3) int lightAttenuation, @OriginalArg(2) int lightSrcX, @OriginalArg(0) int lightSrcY, @OriginalArg(4) int lightSrcZ) {
		@Pc(16) int lightMagnitude = (int) Math.sqrt(lightSrcX * lightSrcX + lightSrcY * lightSrcY + lightSrcZ * lightSrcZ);
		@Pc(26) int attenuation = lightAttenuation * lightMagnitude >> 8;

		for (@Pc(28) int level = 0; level < this.maxLevel; level++) {
			for (@Pc(32) int tileX = 0; tileX < this.maxTileX; tileX++) {
				for (@Pc(36) int tileZ = 0; tileZ < this.maxTileZ; tileZ++) {
					@Pc(47) Tile tile = this.levelTiles[level][tileX][tileZ];
					if (tile == null) {
						continue;
					}

					@Pc(52) Wall wall = tile.wall;
					if (wall != null && wall.modelA != null && wall.modelA.vertexNormal != null) {
						this.mergeLocNormals(level, tileX, tileZ, 1, 1, wall.modelA);
						if (wall.modelB != null && wall.modelB.vertexNormal != null) {
							this.mergeLocNormals(level, tileX, tileZ, 1, 1, wall.modelB);
							this.mergeNormals(wall.modelA, wall.modelB, 0, 0, 0, false);
							wall.modelB.applyLighting(lightAmbient, attenuation, lightSrcX, lightSrcY, lightSrcZ);
						}
						wall.modelA.applyLighting(lightAmbient, attenuation, lightSrcX, lightSrcY, lightSrcZ);
					}

					for (@Pc(116) int i = 0; i < tile.locCount; i++) {
						@Pc(123) Loc loc = tile.locs[i];
						if (loc != null && loc.model != null && loc.model.vertexNormal != null) {
							this.mergeLocNormals(level, tileX, tileZ, loc.maxSceneTileX + 1 - loc.minSceneTileX, loc.maxSceneTileZ - loc.minSceneTileZ + 1, loc.model);
							loc.model.applyLighting(lightAmbient, attenuation, lightSrcX, lightSrcY, lightSrcZ);
						}
					}

					@Pc(170) GroundDecoration decor = tile.groundDecoration;
					if (decor != null && decor.model.vertexNormal != null) {
						this.mergeGroundDecorationNormals(level, tileX, tileZ, decor.model);
						decor.model.applyLighting(lightAmbient, attenuation, lightSrcX, lightSrcY, lightSrcZ);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(BIILclient!eb;I)V")
	private void mergeGroundDecorationNormals(@OriginalArg(1) int level, @OriginalArg(4) int tileX, @OriginalArg(2) int tileZ, @OriginalArg(3) Model model) {
		@Pc(19) Tile tile;
		if (tileX < this.maxTileX) {
			tile = this.levelTiles[level][tileX + 1][tileZ];
			if (tile != null && tile.groundDecoration != null && tile.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(model, tile.groundDecoration.model, 128, 0, 0, true);
			}
		}

		if (tileZ < this.maxTileX) {
			tile = this.levelTiles[level][tileX][tileZ + 1];
			if (tile != null && tile.groundDecoration != null && tile.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(model, tile.groundDecoration.model, 0, 0, 128, true);
			}
		}

		if (tileX < this.maxTileX && tileZ < this.maxTileZ) {
			tile = this.levelTiles[level][tileX + 1][tileZ + 1];
			if (tile != null && tile.groundDecoration != null && tile.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(model, tile.groundDecoration.model, 128, 0, 128, true);
			}
		}

		if (tileX < this.maxTileX && tileZ > 0) {
			tile = this.levelTiles[level][tileX + 1][tileZ - 1];
			if (tile != null && tile.groundDecoration != null && tile.groundDecoration.model.vertexNormal != null) {
				this.mergeNormals(model, tile.groundDecoration.model, 128, 0, -128, true);
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIILclient!eb;I)V")
	private void mergeLocNormals(@OriginalArg(3) int level, @OriginalArg(0) int tileX, @OriginalArg(6) int tileZ, @OriginalArg(1) int tileSizeX, @OriginalArg(2) int tileSizeZ, @OriginalArg(5) Model model) {
		@Pc(7) boolean allowFaceRemoval = true;

		@Pc(9) int minTileX = tileX;
		@Pc(13) int maxTileX = tileX + tileSizeX;
		@Pc(17) int minTileZ = tileZ - 1;
		@Pc(21) int maxTileZ = tileZ + tileSizeZ;

		for (@Pc(23) int l = level; l <= level + 1; l++) {
			if (l == this.maxLevel) {
				continue;
			}

			for (@Pc(31) int x = minTileX; x <= maxTileX; x++) {
				if (x < 0 || x >= this.maxTileX) {
					continue;
				}

				for (@Pc(42) int z = minTileZ; z <= maxTileZ; z++) {
					if (z < 0 || z >= this.maxTileZ || (allowFaceRemoval && x < maxTileX && z < maxTileZ && (z >= tileZ || x == tileX))) {
						continue;
					}

					@Pc(75) Tile tile = this.levelTiles[l][x][z];
					if (tile == null) {
						continue;
					}

					@Pc(169) int offsetY = (this.levelHeightmaps[l][x][z] + this.levelHeightmaps[l][x + 1][z] + this.levelHeightmaps[l][x][z + 1] + this.levelHeightmaps[l][x + 1][z + 1]) / 4 - (this.levelHeightmaps[level][tileX][tileZ] + this.levelHeightmaps[level][tileX + 1][tileZ] + this.levelHeightmaps[level][tileX][tileZ + 1] + this.levelHeightmaps[level][tileX + 1][tileZ + 1]) / 4;

					@Pc(172) Wall wall = tile.wall;
					if (wall != null && wall.modelA != null && wall.modelA.vertexNormal != null) {
						this.mergeNormals(model, wall.modelA, (x - tileX) * 128 + (1 - tileSizeX) * 64, offsetY, (z - tileZ) * 128 + (1 - tileSizeZ) * 64, allowFaceRemoval);
					}

					if (wall != null && wall.modelB != null && wall.modelB.vertexNormal != null) {
						this.mergeNormals(model, wall.modelB, (x - tileX) * 128 + (1 - tileSizeX) * 64, offsetY, (z - tileZ) * 128 + (1 - tileSizeZ) * 64, allowFaceRemoval);
					}

					for (@Pc(250) int i = 0; i < tile.locCount; i++) {
						@Pc(257) Loc loc = tile.locs[i];
						if (loc == null || loc.model == null || loc.model.vertexNormal == null) {
							continue;
						}

						@Pc(274) int locTileSizeX = loc.maxSceneTileX + 1 - loc.minSceneTileX;
						@Pc(282) int locTileSizeZ = loc.maxSceneTileZ + 1 - loc.minSceneTileZ;
						this.mergeNormals(model, loc.model, (loc.minSceneTileX - tileX) * 128 + (locTileSizeX - tileSizeX) * 64, offsetY, (loc.minSceneTileZ - tileZ) * 128 + (locTileSizeZ - tileSizeZ) * 64, allowFaceRemoval);
					}
				}
			}

			minTileX--;
			allowFaceRemoval = false;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!eb;Lclient!eb;IIIZ)V")
	private void mergeNormals(@OriginalArg(0) Model modelA, @OriginalArg(1) Model modelB, @OriginalArg(2) int offsetX, @OriginalArg(3) int offsetY, @OriginalArg(4) int offsetZ, @OriginalArg(5) boolean allowFaceRemoval) {
		this.tmpMergeIndex++;

		@Pc(9) int merged = 0;
		@Pc(12) int[] vertexX = modelB.vertexX;
		@Pc(15) int vertexCountB = modelB.vertexCount;

		for (@Pc(17) int vertexA = 0; vertexA < modelA.vertexCount; vertexA++) {
			@Pc(24) Model.VertexNormal normalA = modelA.vertexNormal[vertexA];
			@Pc(29) Model.VertexNormal originalNormalA = modelA.vertexNormalOriginal[vertexA];
			if (originalNormalA.w != 0) {
				@Pc(39) int y = modelA.vertexY[vertexA] - offsetY;
				if (y > modelB.minY) {
					continue;
				}

				@Pc(50) int x = modelA.vertexX[vertexA] - offsetX;
				if (x < modelB.minX || x > modelB.maxX) {
					continue;
				}

				@Pc(66) int z = modelA.vertexZ[vertexA] - offsetZ;
				if (z < modelB.minZ || z > modelB.maxZ) {
					continue;
				}

				for (@Pc(77) int vertexB = 0; vertexB < vertexCountB; vertexB++) {
					@Pc(84) Model.VertexNormal normalB = modelB.vertexNormal[vertexB];
					@Pc(89) Model.VertexNormal originalNormalB = modelB.vertexNormalOriginal[vertexB];
					if (x != vertexX[vertexB] || z != modelB.vertexZ[vertexB] || y != modelB.vertexY[vertexB] || originalNormalB.w == 0) {
						continue;
					}

					normalA.x += originalNormalB.x;
					normalA.y += originalNormalB.y;
					normalA.z += originalNormalB.z;
					normalA.w += originalNormalB.w;
					normalB.x += originalNormalA.x;
					normalB.y += originalNormalA.y;
					normalB.z += originalNormalA.z;
					normalB.w += originalNormalA.w;
					merged++;
					this.mergeIndexA[vertexA] = this.tmpMergeIndex;
					this.mergeIndexB[vertexB] = this.tmpMergeIndex;
				}
			}
		}

		if (merged < 3 || !allowFaceRemoval) {
			return;
		}

		for (@Pc(195) int i = 0; i < modelA.faceCount; i++) {
			if (this.mergeIndexA[modelA.faceVertexA[i]] == this.tmpMergeIndex && this.mergeIndexA[modelA.faceVertexB[i]] == this.tmpMergeIndex && this.mergeIndexA[modelA.faceVertexC[i]] == this.tmpMergeIndex) {
				modelA.faceInfo[i] = -1;
			}
		}

		for (@Pc(239) int i = 0; i < modelB.faceCount; i++) {
			if (this.mergeIndexB[modelB.faceVertexA[i]] == this.tmpMergeIndex && this.mergeIndexB[modelB.faceVertexB[i]] == this.tmpMergeIndex && this.mergeIndexB[modelB.faceVertexC[i]] == this.tmpMergeIndex) {
				modelB.faceInfo[i] = -1;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "([IIIIII)V")
	public void drawMinimapTile(@OriginalArg(3) int level, @OriginalArg(4) int x, @OriginalArg(5) int z, @OriginalArg(0) int[] dst, @OriginalArg(1) int offset, @OriginalArg(2) int step) {
		@Pc(10) Tile tile = this.levelTiles[level][x][z];
		if (tile == null) {
			return;
		}

		@Pc(16) TileUnderlay underlay = tile.underlay;
		if (underlay != null) {
			@Pc(21) int rgb = underlay.rgb;
			if (rgb == 0) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				dst[offset] = rgb;
				dst[offset + 1] = rgb;
				dst[offset + 2] = rgb;
				dst[offset + 3] = rgb;
				offset += step;
			}

			return;
		}

		@Pc(62) TileOverlay overlay = tile.overlay;
		if (overlay == null) {
			return;
		}

		int shape = overlay.shape;
		@Pc(71) int angle = overlay.rotation;
		@Pc(74) int background = overlay.backgroundRgb;
		@Pc(77) int foreground = overlay.foregroundRgb;
		@Pc(82) int[] mask = this.MINIMAP_OVERLAY_SHAPE[shape];
		@Pc(87) int[] rotation = this.MINIMAP_OVERLAY_ROTATION[angle];

		@Pc(89) int off = 0;
		if (background != 0) {
			for (int i = 0; i < 4; i++) {
				dst[offset] = mask[rotation[off++]] == 0 ? background : foreground;
				dst[offset + 1] = mask[rotation[off++]] == 0 ? background : foreground;
				dst[offset + 2] = mask[rotation[off++]] == 0 ? background : foreground;
				dst[offset + 3] = mask[rotation[off++]] == 0 ? background : foreground;
				offset += step;
			}

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (mask[rotation[off++]] != 0) {
				dst[offset] = foreground;
			}

			if (mask[rotation[off++]] != 0) {
				dst[offset + 1] = foreground;
			}

			if (mask[rotation[off++]] != 0) {
				dst[offset + 2] = foreground;
			}

			if (mask[rotation[off++]] != 0) {
				dst[offset + 3] = foreground;
			}

			offset += step;
		}
	}

	@OriginalMember(owner = "client!r", name = "e", descriptor = "(III)V")
	public void click(@OriginalArg(2) int mouseX, @OriginalArg(1) int mouseY) {
		takingInput = true;
		World3D.mouseX = mouseX;
		World3D.mouseY = mouseY;
		clickTileX = -1;
		clickTileZ = -1;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIII)V")
	public void draw(@OriginalArg(1) int eyeX, @OriginalArg(4) int eyeY, @OriginalArg(5) int eyeZ, @OriginalArg(2) int topLevel, @OriginalArg(0) int eyeYaw, @OriginalArg(3) int eyePitch, int loopCycle) {
		if (eyeX < 0) {
			eyeX = 0;
		} else if (eyeX >= this.maxTileX * 128) {
			eyeX = this.maxTileX * 128 - 1;
		}

		if (eyeZ < 0) {
			eyeZ = 0;
		} else if (eyeZ >= this.maxTileZ * 128) {
			eyeZ = this.maxTileZ * 128 - 1;
		}

		cycle++;
		sinEyePitch = Model.sin[eyePitch];
		cosEyePitch = Model.cos[eyePitch];
		sinEyeYaw = Model.sin[eyeYaw];
		cosEyeYaw = Model.cos[eyeYaw];

		visibilityMap = visibilityMatrix[(eyePitch - 128) / 32][eyeYaw / 64];
		World3D.eyeX = eyeX;
		World3D.eyeY = eyeY;
		World3D.eyeZ = eyeZ;
		eyeTileX = eyeX / 128;
		eyeTileZ = eyeZ / 128;
		World3D.topLevel = topLevel;

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

		for (@Pc(138) int level = this.minLevel; level < this.maxLevel; level++) {
			@Pc(145) Tile[][] tiles = this.levelTiles[level];
			for (int x = minDrawTileX; x < maxDrawTileX; x++) {
				for (int z = minDrawTileZ; z < maxDrawTileZ; z++) {
					@Pc(159) Tile tile = tiles[x][z];
					if (tile == null) {
						continue;
					}

					if (tile.drawLevel <= topLevel && (visibilityMap[x + 25 - eyeTileX][z + 25 - eyeTileZ] || this.levelHeightmaps[level][x][z] - eyeY >= 2000)) {
						tile.visible = true;
						tile.update = true;
						tile.containsLocs = tile.locCount > 0;
						tilesRemaining++;
					} else {
						tile.visible = false;
						tile.update = false;
						tile.checkLocSpans = 0;
					}
				}
			}
		}

		for (@Pc(239) int level = this.minLevel; level < this.maxLevel; level++) {
			@Pc(246) Tile[][] tiles = this.levelTiles[level];
			for (int dx = -25; dx <= 0; dx++) {
				int rightTileX = eyeTileX + dx;
				int leftTileX = eyeTileX - dx;

				if (rightTileX < minDrawTileX && leftTileX >= maxDrawTileX) {
					continue;
				}

				for (int dz = -25; dz <= 0; dz++) {
					int forwardTileZ = eyeTileZ + dz;
					int backwardTileZ = eyeTileZ - dz;
					@Pc(288) Tile tile;
					if (rightTileX >= minDrawTileX) {
						if (forwardTileZ >= minDrawTileZ) {
							tile = tiles[rightTileX][forwardTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, true, loopCycle);
							}
						}

						if (backwardTileZ < maxDrawTileZ) {
							tile = tiles[rightTileX][backwardTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, true, loopCycle);
							}
						}
					}

					if (leftTileX < maxDrawTileX) {
						if (forwardTileZ >= minDrawTileZ) {
							tile = tiles[leftTileX][forwardTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, true, loopCycle);
							}
						}

						if (backwardTileZ < maxDrawTileZ) {
							tile = tiles[leftTileX][backwardTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, true, loopCycle);
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

		for (int level = this.minLevel; level < this.maxLevel; level++) {
			@Pc(380) Tile[][] tiles = this.levelTiles[level];
			for (int dx = -25; dx <= 0; dx++) {
				int rightTileX = eyeTileX + dx;
				int leftTileX = eyeTileX - dx;
				if (rightTileX < minDrawTileX && leftTileX >= maxDrawTileX) {
					continue;
				}

				for (int dz = -25; dz <= 0; dz++) {
					int forwardTileZ = eyeTileZ + dz;
					@Pc(410) int backgroundTileZ = eyeTileZ - dz;
					@Pc(422) Tile tile;
					if (rightTileX >= minDrawTileX) {
						if (forwardTileZ >= minDrawTileZ) {
							tile = tiles[rightTileX][forwardTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, false, loopCycle);
							}
						}

						if (backgroundTileZ < maxDrawTileZ) {
							tile = tiles[rightTileX][backgroundTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, false, loopCycle);
							}
						}
					}

					if (leftTileX < maxDrawTileX) {
						if (forwardTileZ >= minDrawTileZ) {
							tile = tiles[leftTileX][forwardTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, false, loopCycle);
							}
						}

						if (backgroundTileZ < maxDrawTileZ) {
							tile = tiles[leftTileX][backgroundTileZ];
							if (tile != null && tile.visible) {
								this.drawTile(tile, false, loopCycle);
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

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!cb;Z)V")
	private void drawTile(@OriginalArg(0) Tile next, @OriginalArg(1) boolean checkAdjacent, int loopCycle) {
		drawTileQueue.addTail(next);

		while (true) {
			Tile tile;

			do {
				tile = (Tile) drawTileQueue.removeHead();

				if (tile == null) {
					return;
				}
			} while (!tile.update);

			int tileX = tile.x;
			int tileZ = tile.z;
			int level = tile.level;
			int occludeLevel = tile.occludeLevel;
			Tile[][] tiles = this.levelTiles[level];

			if (tile.visible) {
				if (checkAdjacent) {
					if (level > 0) {
						Tile above = this.levelTiles[level - 1][tileX][tileZ];

						if (above != null && above.update) {
							continue;
						}
					}

					if (tileX <= eyeTileX && tileX > minDrawTileX) {
						Tile adjacent = tiles[tileX - 1][tileZ];

						if (adjacent != null && adjacent.update && (adjacent.visible || (tile.locSpans & 0x1) == 0)) {
							continue;
						}
					}

					if (tileX >= eyeTileX && tileX < maxDrawTileX - 1) {
						Tile adjacent = tiles[tileX + 1][tileZ];

						if (adjacent != null && adjacent.update && (adjacent.visible || (tile.locSpans & 0x4) == 0)) {
							continue;
						}
					}

					if (tileZ <= eyeTileZ && tileZ > minDrawTileZ) {
						Tile adjacent = tiles[tileX][tileZ - 1];

						if (adjacent != null && adjacent.update && (adjacent.visible || (tile.locSpans & 0x8) == 0)) {
							continue;
						}
					}

					if (tileZ >= eyeTileZ && tileZ < maxDrawTileZ - 1) {
						Tile adjacent = tiles[tileX][tileZ + 1];

						if (adjacent != null && adjacent.update && (adjacent.visible || (tile.locSpans & 0x2) == 0)) {
							continue;
						}
					}
				} else {
					checkAdjacent = true;
				}

				tile.visible = false;

				if (tile.bridge != null) {
					Tile bridge = tile.bridge;

					if (bridge.underlay == null) {
						if (bridge.overlay != null && !this.tileVisible(0, tileX, tileZ)) {
							this.drawTileOverlay(tileX, tileZ, bridge.overlay, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw);
						}
					} else if (!this.tileVisible(0, tileX, tileZ)) {
						this.drawTileUnderlay(bridge.underlay, 0, tileX, tileZ, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw);
					}

					@Pc(227) Wall wall = bridge.wall;
					if (wall != null) {
						wall.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, wall.x - eyeX, wall.y - eyeY, wall.z - eyeZ, wall.bitset);
					}

					for (int i = 0; i < bridge.locCount; i++) {
						Loc loc = bridge.locs[i];

						if (loc != null) {
							@Pc(265) Model model = loc.model;
							if (model == null) {
								model = loc.entity.draw(loopCycle);
							}
							model.draw(loc.yaw, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, loc.x - eyeX, loc.y - eyeY, loc.z - eyeZ, loc.bitset);
						}
					}
				}

				boolean tileDrawn = false;
				if (tile.underlay == null) {
					if (tile.overlay != null && !this.tileVisible(occludeLevel, tileX, tileZ)) {
						tileDrawn = true;
						this.drawTileOverlay(tileX, tileZ, tile.overlay, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw);
					}
				} else if (!this.tileVisible(occludeLevel, tileX, tileZ)) {
					tileDrawn = true;
					this.drawTileUnderlay(tile.underlay, occludeLevel, tileX, tileZ, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw);
				}

				int direction = 0;
				int frontWallTypes = 0;

				@Pc(354) Wall wall = tile.wall;
				@Pc(357) WallDecoration decor = tile.wallDecoration;

				if (wall != null || decor != null) {
					if (eyeTileX == tileX) {
						direction += 1;
					} else if (eyeTileX < tileX) {
						direction += 2;
					}

					if (eyeTileZ == tileZ) {
						direction += 3;
					} else if (eyeTileZ > tileZ) {
						direction += 6;
					}

					frontWallTypes = FRONT_WALL_TYPES[direction];
					tile.backWallTypes = BACK_WALL_TYPES[direction];
				}

				if (wall != null) {
					if ((wall.typeA & DIRECTION_ALLOW_WALL_CORNER_TYPE[direction]) == 0) {
						tile.checkLocSpans = 0;
					} else if (wall.typeA == 16) {
						tile.checkLocSpans = 3;
						tile.blockLocSpans = WALL_CORNER_TYPE_16_BLOCK_LOC_SPANS[direction];
						tile.inverseBlockLocSpans = 3 - tile.blockLocSpans;
					} else if (wall.typeA == 32) {
						tile.checkLocSpans = 6;
						tile.blockLocSpans = WALL_CORNER_TYPE_32_BLOCK_LOC_SPANS[direction];
						tile.inverseBlockLocSpans = 6 - tile.blockLocSpans;
					} else if (wall.typeA == 64) {
						tile.checkLocSpans = 12;
						tile.blockLocSpans = WALL_CORNER_TYPE_64_BLOCK_LOC_SPANS[direction];
						tile.inverseBlockLocSpans = 12 - tile.blockLocSpans;
					} else {
						tile.checkLocSpans = 9;
						tile.blockLocSpans = WALL_CORNER_TYPE_128_BLOCK_LOC_SPANS[direction];
						tile.inverseBlockLocSpans = 9 - tile.blockLocSpans;
					}

					if ((wall.typeA & frontWallTypes) != 0 && !this.wallVisible(occludeLevel, tileX, tileZ, wall.typeA)) {
						wall.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, wall.x - eyeX, wall.y - eyeY, wall.z - eyeZ, wall.bitset);
					}

					if ((wall.typeB & frontWallTypes) != 0 && !this.wallVisible(occludeLevel, tileX, tileZ, wall.typeB)) {
						wall.modelB.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, wall.x - eyeX, wall.y - eyeY, wall.z - eyeZ, wall.bitset);
					}
				}

				if (decor != null && !this.visible(occludeLevel, tileX, tileZ, decor.model.maxY)) {
					if ((decor.type & frontWallTypes) != 0) {
						decor.model.draw(decor.angle, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, decor.x - eyeX, decor.y - eyeY, decor.z - eyeZ, decor.bitset);
					} else if ((decor.type & 0x300) != 0) {
						int x = decor.x - eyeX;
						int y = decor.y - eyeY;
						int z = decor.z - eyeZ;
						int rotation = decor.angle;

						int nearestX;
						if (rotation == 1 || rotation == 2) {
							nearestX = -x;
						} else {
							nearestX = x;
						}

						@Pc(634) int nearestZ;
						if (rotation == 2 || rotation == 3) {
							nearestZ = -z;
						} else {
							nearestZ = z;
						}

						if ((decor.type & 0x100) != 0 && nearestZ < nearestX) {
							int drawX = x + WALL_DECORATION_INSET_X[rotation];
							int drawZ = z + WALL_DECORATION_INSET_Z[rotation];
							decor.model.draw(rotation * 512 + 256, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, drawX, y, drawZ, decor.bitset);
						}

						if ((decor.type & 0x200) != 0 && nearestZ > nearestX) {
							int drawX = x + WALL_DECORATION_OUTSET_X[rotation];
							int drawZ = z + WALL_DECORATION_OUTSET_Z[rotation];
							decor.model.draw(rotation * 512 + 1280 & 0x7FF, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, drawX, y, drawZ, decor.bitset);
						}
					}
				}

				if (tileDrawn) {
					@Pc(719) GroundDecoration groundDecor = tile.groundDecoration;
					if (groundDecor != null) {
						groundDecor.model.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, groundDecor.x - eyeX, groundDecor.y - eyeY, groundDecor.z - eyeZ, groundDecor.bitset);
					}

					@Pc(746) ObjStack objs = tile.objStack;
					if (objs != null && objs.offset == 0) {
						if (objs.bottomObj != null) {
							objs.bottomObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, objs.x - eyeX, objs.y - eyeY, objs.z - eyeZ, objs.bitset);
						}

						if (objs.middleObj != null) {
							objs.middleObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, objs.x - eyeX, objs.y - eyeY, objs.z - eyeZ, objs.bitset);
						}

						if (objs.topObj != null) {
							objs.topObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, objs.x - eyeX, objs.y - eyeY, objs.z - eyeZ, objs.bitset);
						}
					}
				}

				int spans = tile.locSpans;

				if (spans != 0) {
					if (tileX < eyeTileX && (spans & 0x4) != 0) {
						Tile adjacent = tiles[tileX + 1][tileZ];
						if (adjacent != null && adjacent.update) {
							drawTileQueue.addTail(adjacent);
						}
					}

					if (tileZ < eyeTileZ && (spans & 0x2) != 0) {
						Tile adjacent = tiles[tileX][tileZ + 1];
						if (adjacent != null && adjacent.update) {
							drawTileQueue.addTail(adjacent);
						}
					}

					if (tileX > eyeTileX && (spans & 0x1) != 0) {
						Tile adjacent = tiles[tileX - 1][tileZ];
						if (adjacent != null && adjacent.update) {
							drawTileQueue.addTail(adjacent);
						}
					}

					if (tileZ > eyeTileZ && (spans & 0x8) != 0) {
						Tile adjacent = tiles[tileX][tileZ - 1];
						if (adjacent != null && adjacent.update) {
							drawTileQueue.addTail(adjacent);
						}
					}
				}
			}

			if (tile.checkLocSpans != 0) {
				boolean draw = true;
				for (int i = 0; i < tile.locCount; i++) {
					if (tile.locs[i].cycle != cycle && (tile.locSpan[i] & tile.checkLocSpans) == tile.blockLocSpans) {
						draw = false;
						break;
					}
				}

				if (draw) {
					Wall wall = tile.wall;

					if (!this.wallVisible(occludeLevel, tileX, tileZ, wall.typeA)) {
						wall.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, wall.x - eyeX, wall.y - eyeY, wall.z - eyeZ, wall.bitset);
					}

					tile.checkLocSpans = 0;
				}
			}

			if (tile.containsLocs) {
				@Pc(1002) int locCount = tile.locCount;
				tile.containsLocs = false;
				int locBufferSize = 0;

				iterate_locs:
				for (int i = 0; i < locCount; i++) {
					Loc loc = tile.locs[i];

					if (loc.cycle == cycle) {
						continue;
					}

					for (int x = loc.minSceneTileX; x <= loc.maxSceneTileX; x++) {
						for (int z = loc.minSceneTileZ; z <= loc.maxSceneTileZ; z++) {
							Tile other = tiles[x][z];

							if (!other.visible) {
								if (other.checkLocSpans == 0) {
									continue;
								}

								int spans = 0;

								if (x > loc.minSceneTileX) {
									spans += 1;
								}

								if (x < loc.maxSceneTileX) {
									spans += 4;
								}

								if (z > loc.minSceneTileZ) {
									spans += 8;
								}

								if (z < loc.maxSceneTileZ) {
									spans += 2;
								}

								if ((spans & other.checkLocSpans) != tile.inverseBlockLocSpans) {
									continue;
								}
							}

							tile.containsLocs = true;
							continue iterate_locs;
						}
					}

					locBuffer[locBufferSize++] = loc;

					int minTileDistanceX = eyeTileX - loc.minSceneTileX;
					int maxTileDistanceX = loc.maxSceneTileX - eyeTileX;

					if (maxTileDistanceX > minTileDistanceX) {
						minTileDistanceX = maxTileDistanceX;
					}

					int minTileDistanceZ = eyeTileZ - loc.minSceneTileZ;
					int maxTileDistanceZ = loc.maxSceneTileZ - eyeTileZ;

					if (maxTileDistanceZ > minTileDistanceZ) {
						loc.distance = minTileDistanceX + maxTileDistanceZ;
					} else {
						loc.distance = minTileDistanceX + minTileDistanceZ;
					}
				}

				while (true) {
					int farthestDistance = -50;
					int farthestIndex = -1;

					for (int index = 0; index < locBufferSize; index++) {
						Loc loc = locBuffer[index];

						if (loc.cycle != cycle) {
							if (loc.distance > farthestDistance) {
								farthestDistance = loc.distance;
								farthestIndex = index;
							}
						}
					}

					if (farthestIndex == -1) {
						break;
					}

					Loc farthest = locBuffer[farthestIndex];
					farthest.cycle = cycle;

					@Pc(1184) Model model = farthest.model;
					if (model == null) {
						model = farthest.entity.draw(loopCycle);
					}

					if (!this.locVisible(occludeLevel, farthest.minSceneTileX, farthest.maxSceneTileX, farthest.minSceneTileZ, farthest.maxSceneTileZ, model.maxY)) {
						model.draw(farthest.yaw, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, farthest.x - eyeX, farthest.y - eyeY, farthest.z - eyeZ, farthest.bitset);
					}

					for (int x = farthest.minSceneTileX; x <= farthest.maxSceneTileX; x++) {
						for (int z = farthest.minSceneTileZ; z <= farthest.maxSceneTileZ; z++) {
							@Pc(1243) Tile occupied = tiles[x][z];

							if (occupied.checkLocSpans != 0) {
								drawTileQueue.addTail(occupied);
							} else if ((x != tileX || z != tileZ) && occupied.update) {
								drawTileQueue.addTail(occupied);
							}
						}
					}
				}

				if (tile.containsLocs) {
					continue;
				}
			}

			if (!tile.update || tile.checkLocSpans != 0) {
				continue;
			}

			if (tileX <= eyeTileX && tileX > minDrawTileX) {
				Tile adjacent = tiles[tileX - 1][tileZ];
				if (adjacent != null && adjacent.update) {
					continue;
				}
			}

			if (tileX >= eyeTileX && tileX < maxDrawTileX - 1) {
				Tile adjacent = tiles[tileX + 1][tileZ];
				if (adjacent != null && adjacent.update) {
					continue;
				}
			}

			if (tileZ <= eyeTileZ && tileZ > minDrawTileZ) {
				Tile adjacent = tiles[tileX][tileZ - 1];
				if (adjacent != null && adjacent.update) {
					continue;
				}
			}

			if (tileZ >= eyeTileZ && tileZ < maxDrawTileZ - 1) {
				Tile adjacent = tiles[tileX][tileZ + 1];
				if (adjacent != null && adjacent.update) {
					continue;
				}
			}

			tile.update = false;
			tilesRemaining--;

			@Pc(1379) ObjStack objs = tile.objStack;
			if (objs != null && objs.offset != 0) {
				if (objs.bottomObj != null) {
					objs.bottomObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, objs.x - eyeX, objs.y - eyeY - objs.offset, objs.z - eyeZ, objs.bitset);
				}

				if (objs.middleObj != null) {
					objs.middleObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, objs.x - eyeX, objs.y - eyeY - objs.offset, objs.z - eyeZ, objs.bitset);
				}

				if (objs.topObj != null) {
					objs.topObj.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, objs.x - eyeX, objs.y - eyeY - objs.offset, objs.z - eyeZ, objs.bitset);
				}
			}

			if (tile.backWallTypes != 0) {
				@Pc(1474) WallDecoration decor = tile.wallDecoration;

				if (decor != null && !this.visible(occludeLevel, tileX, tileZ, decor.model.maxY)) {
					if ((decor.type & tile.backWallTypes) != 0) {
						decor.model.draw(decor.angle, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, decor.x - eyeX, decor.y - eyeY, decor.z - eyeZ, decor.bitset);
					} else if ((decor.type & 0x300) != 0) {
						int x = decor.x - eyeX;
						int y = decor.y - eyeY;
						int z = decor.z - eyeZ;
						int rotation = decor.angle;

						int nearestX;
						if (rotation == 1 || rotation == 2) {
							nearestX = -x;
						} else {
							nearestX = x;
						}

						int nearestZ;
						if (rotation == 2 || rotation == 3) {
							nearestZ = -z;
						} else {
							nearestZ = z;
						}

						if ((decor.type & 0x100) != 0 && nearestZ >= nearestX) {
							int drawX = x + WALL_DECORATION_INSET_X[rotation];
							int drawZ = z + WALL_DECORATION_INSET_Z[rotation];
							decor.model.draw(rotation * 512 + 256, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, drawX, y, drawZ, decor.bitset);
						}

						if ((decor.type & 0x200) != 0 && nearestZ <= nearestX) {
							int drawX = x + WALL_DECORATION_OUTSET_X[rotation];
							int drawZ = z + WALL_DECORATION_OUTSET_Z[rotation];
							decor.model.draw(rotation * 512 + 1280 & 0x7FF, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, drawX, y, drawZ, decor.bitset);
						}
					}
				}

				Wall wall = tile.wall;
				if (wall != null) {
					if ((wall.typeB & tile.backWallTypes) != 0 && !this.wallVisible(occludeLevel, tileX, tileZ, wall.typeB)) {
						wall.modelB.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, wall.x - eyeX, wall.y - eyeY, wall.z - eyeZ, wall.bitset);
					}

					if ((wall.typeA & tile.backWallTypes) != 0 && !this.wallVisible(occludeLevel, tileX, tileZ, wall.typeA)) {
						wall.modelA.draw(0, sinEyePitch, cosEyePitch, sinEyeYaw, cosEyeYaw, wall.x - eyeX, wall.y - eyeY, wall.z - eyeZ, wall.bitset);
					}
				}
			}

			if (level < this.maxLevel - 1) {
				Tile above = this.levelTiles[level + 1][tileX][tileZ];
				if (above != null && above.update) {
					drawTileQueue.addTail(above);
				}
			}

			if (tileX < eyeTileX) {
				Tile adjacent = tiles[tileX + 1][tileZ];
				if (adjacent != null && adjacent.update) {
					drawTileQueue.addTail(adjacent);
				}
			}

			if (tileZ < eyeTileZ) {
				Tile adjacent = tiles[tileX][tileZ + 1];
				if (adjacent != null && adjacent.update) {
					drawTileQueue.addTail(adjacent);
				}
			}

			if (tileX > eyeTileX) {
				Tile adjacent = tiles[tileX - 1][tileZ];
				if (adjacent != null && adjacent.update) {
					drawTileQueue.addTail(adjacent);
				}
			}

			if (tileZ > eyeTileZ) {
				Tile adjacent = tiles[tileX][tileZ - 1];
				if (adjacent != null && adjacent.update) {
					drawTileQueue.addTail(adjacent);
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(Lclient!o;IIIIIII)V")
	private void drawTileUnderlay(@OriginalArg(0) TileUnderlay underlay, @OriginalArg(1) int level, @OriginalArg(6) int tileX, @OriginalArg(7) int tileZ, @OriginalArg(2) int sinEyePitch, @OriginalArg(3) int cosEyePitch, @OriginalArg(4) int sinEyeYaw, @OriginalArg(5) int cosEyeYaw) {
		@Pc(8) int x3;
		@Pc(9) int x0 = x3 = (tileX << 7) - eyeX;
		@Pc(16) int z1;
		@Pc(17) int z0 = z1 = (tileZ << 7) - eyeZ;
		@Pc(22) int x2;
		@Pc(23) int x1 = x2 = x0 + 128;
		@Pc(28) int z3;
		@Pc(29) int z2 = z3 = z0 + 128;

		@Pc(40) int y0 = this.levelHeightmaps[level][tileX][tileZ] - eyeY;
		@Pc(53) int y1 = this.levelHeightmaps[level][tileX + 1][tileZ] - eyeY;
		@Pc(68) int y2 = this.levelHeightmaps[level][tileX + 1][tileZ + 1] - eyeY;
		@Pc(81) int y3 = this.levelHeightmaps[level][tileX][tileZ + 1] - eyeY;

		int tmp = z0 * sinEyeYaw + x0 * cosEyeYaw >> 16;
		z0 = z0 * cosEyeYaw - x0 * sinEyeYaw >> 16;
		x0 = tmp;

		tmp = y0 * cosEyePitch - z0 * sinEyePitch >> 16;
		z0 = y0 * sinEyePitch + z0 * cosEyePitch >> 16;
		y0 = tmp;

		if (z0 < 50) {
			return;
		}

		tmp = z1 * sinEyeYaw + x1 * cosEyeYaw >> 16;
		z1 = z1 * cosEyeYaw - x1 * sinEyeYaw >> 16;
		x1 = tmp;

		tmp = y1 * cosEyePitch - z1 * sinEyePitch >> 16;
		z1 = y1 * sinEyePitch + z1 * cosEyePitch >> 16;
		y1 = tmp;

		if (z1 < 50) {
			return;
		}

		tmp = z2 * sinEyeYaw + x2 * cosEyeYaw >> 16;
		z2 = z2 * cosEyeYaw - x2 * sinEyeYaw >> 16;
		x2 = tmp;

		tmp = y2 * cosEyePitch - z2 * sinEyePitch >> 16;
		z2 = y2 * sinEyePitch + z2 * cosEyePitch >> 16;
		y2 = tmp;

		if (z2 < 50) {
			return;
		}

		tmp = z3 * sinEyeYaw + x3 * cosEyeYaw >> 16;
		z3 = z3 * cosEyeYaw - x3 * sinEyeYaw >> 16;
		x3 = tmp;

		tmp = y3 * cosEyePitch - z3 * sinEyePitch >> 16;
		z3 = y3 * sinEyePitch + z3 * cosEyePitch >> 16;
		y3 = tmp;

		if (z3 < 50) {
			return;
		}

		@Pc(281) int px0 = Draw3D.centerX + (x0 << 9) / z0;
		@Pc(289) int py0 = Draw3D.centerY + (y0 << 9) / z0;
		@Pc(297) int pz0 = Draw3D.centerX + (x1 << 9) / z1;
		@Pc(305) int px1 = Draw3D.centerY + (y1 << 9) / z1;
		@Pc(313) int py1 = Draw3D.centerX + (x2 << 9) / z2;
		@Pc(321) int pz1 = Draw3D.centerY + (y2 << 9) / z2;
		@Pc(329) int px3 = Draw3D.centerX + (x3 << 9) / z3;
		@Pc(337) int py3 = Draw3D.centerY + (y3 << 9) / z3;

		Draw3D.alpha = 0;

		if ((py1 - px3) * (px1 - py3) - (pz1 - py3) * (pz0 - px3) > 0) {
			Draw3D.clipX = py1 < 0 || px3 < 0 || pz0 < 0 || py1 > Draw2D.boundX || px3 > Draw2D.boundX || pz0 > Draw2D.boundX;
			if (takingInput && this.pointInsideTriangle(mouseX, mouseY, pz1, py3, px1, py1, px3, pz0)) {
				clickTileX = tileX;
				clickTileZ = tileZ;
			}
			if (underlay.textureId == -1) {
				if (underlay.northeastColor != 12345678) {
					Draw3D.fillGouraudTriangle(py1, px3, pz0, pz1, py3, px1, underlay.northeastColor, underlay.northwestColor, underlay.southeastColor);
				}
			} else if (lowMemory) {
				int averageColor = TEXTURE_HSL[underlay.textureId];
				Draw3D.fillGouraudTriangle(py1, px3, pz0, pz1, py3, px1, this.mulLightness(averageColor, underlay.northeastColor), this.mulLightness(averageColor, underlay.northwestColor), this.mulLightness(averageColor, underlay.southeastColor));
			} else if (underlay.flat) {
				Draw3D.fillTexturedTriangle(py1, px3, pz0, pz1, py3, px1, underlay.northeastColor, underlay.northwestColor, underlay.southeastColor, x0, y0, z0, x1, x3, y1, y3, z1, z3, underlay.textureId);
			} else {
				Draw3D.fillTexturedTriangle(py1, px3, pz0, pz1, py3, px1, underlay.northeastColor, underlay.northwestColor, underlay.southeastColor, x2, y2, z2, x3, x1, y3, y1, z3, z1, underlay.textureId);
			}
		}
		if ((px0 - pz0) * (py3 - px1) - (py0 - px1) * (px3 - pz0) <= 0) {
			return;
		}
		Draw3D.clipX = px0 < 0 || pz0 < 0 || px3 < 0 || px0 > Draw2D.boundX || pz0 > Draw2D.boundX || px3 > Draw2D.boundX;
		if (takingInput && this.pointInsideTriangle(mouseX, mouseY, py0, px1, py3, px0, pz0, px3)) {
			clickTileX = tileX;
			clickTileZ = tileZ;
		}
		if (underlay.textureId != -1) {
			if (!lowMemory) {
				Draw3D.fillTexturedTriangle(px0, pz0, px3, py0, px1, py3, underlay.southwestColor, underlay.southeastColor, underlay.northwestColor, x0, y0, z0, x1, x3, y1, y3, z1, z3, underlay.textureId);
				return;
			}
			int averageColor = TEXTURE_HSL[underlay.textureId];
			Draw3D.fillGouraudTriangle(px0, pz0, px3, py0, px1, py3, this.mulLightness(averageColor, underlay.southwestColor), this.mulLightness(averageColor, underlay.southeastColor), this.mulLightness(averageColor, underlay.northwestColor));
		} else if (underlay.southwestColor != 12345678) {
			Draw3D.fillGouraudTriangle(px0, pz0, px3, py0, px1, py3, underlay.southwestColor, underlay.southeastColor, underlay.northwestColor);
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IILclient!i;IIIIZ)V")
	private void drawTileOverlay(@OriginalArg(3) int tileX, @OriginalArg(1) int tileZ, @OriginalArg(2) TileOverlay overlay, @OriginalArg(5) int sinEyePitch, @OriginalArg(4) int cosEyePitch, @OriginalArg(0) int sinEyeYaw, @OriginalArg(6) int cosEyeYaw) {
		@Pc(5) int vertexCount = overlay.vertexX.length;

		for (@Pc(7) int i = 0; i < vertexCount; i++) {
			int x = overlay.vertexX[i] - eyeX;
			int y = overlay.vertexY[i] - eyeY;
			int z = overlay.vertexZ[i] - eyeZ;

			int tmp = z * sinEyeYaw + x * cosEyeYaw >> 16;
			z = z * cosEyeYaw - x * sinEyeYaw >> 16;
			x = tmp;

			tmp = y * cosEyePitch - z * sinEyePitch >> 16;
			z = y * sinEyePitch + z * cosEyePitch >> 16;
			y = tmp;

			if (z < 50) {
				return;
			}

			if (overlay.triangleTextureIds != null) {
				TileOverlay.tmpViewspaceX[i] = x;
				TileOverlay.tmpViewspaceY[i] = y;
				TileOverlay.tmpViewspaceZ[i] = z;
			}
			TileOverlay.tmpScreenX[i] = Draw3D.centerX + (x << 9) / z;
			TileOverlay.tmpScreenY[i] = Draw3D.centerY + (y << 9) / z;
		}

		Draw3D.alpha = 0;

		vertexCount = overlay.triangleVertexA.length;
		for (int v = 0; v < vertexCount; v++) {
			int a = overlay.triangleVertexA[v];
			int b = overlay.triangleVertexB[v];
			int c = overlay.triangleVertexC[v];

			@Pc(149) int x0 = TileOverlay.tmpScreenX[a];
			@Pc(153) int x1 = TileOverlay.tmpScreenX[b];
			@Pc(157) int x2 = TileOverlay.tmpScreenX[c];
			@Pc(161) int y0 = TileOverlay.tmpScreenY[a];
			@Pc(165) int y1 = TileOverlay.tmpScreenY[b];
			@Pc(169) int y2 = TileOverlay.tmpScreenY[c];

			if ((x0 - x1) * (y2 - y1) - (y0 - y1) * (x2 - x1) > 0) {
				Draw3D.clipX = x0 < 0 || x1 < 0 || x2 < 0 || x0 > Draw2D.boundX || x1 > Draw2D.boundX || x2 > Draw2D.boundX;
				if (takingInput && this.pointInsideTriangle(mouseX, mouseY, y0, y1, y2, x0, x1, x2)) {
					clickTileX = tileX;
					clickTileZ = tileZ;
				}
				if (overlay.triangleTextureIds == null || overlay.triangleTextureIds[v] == -1) {
					if (overlay.triangleColorA[v] != 12345678) {
						Draw3D.fillGouraudTriangle(x0, x1, x2, y0, y1, y2, overlay.triangleColorA[v], overlay.triangleColorB[v], overlay.triangleColorC[v]);
					}
				} else if (lowMemory) {
					@Pc(373) int textureColor = TEXTURE_HSL[overlay.triangleTextureIds[v]];
					Draw3D.fillGouraudTriangle(x0, x1, x2, y0, y1, y2, this.mulLightness(textureColor, overlay.triangleColorA[v]), this.mulLightness(textureColor, overlay.triangleColorB[v]), this.mulLightness(textureColor, overlay.triangleColorC[v]));
				} else if (overlay.flat) {
					Draw3D.fillTexturedTriangle(x0, x1, x2, y0, y1, y2, overlay.triangleColorA[v], overlay.triangleColorB[v], overlay.triangleColorC[v], TileOverlay.tmpViewspaceX[0], TileOverlay.tmpViewspaceY[0], TileOverlay.tmpViewspaceZ[0], TileOverlay.tmpViewspaceX[1], TileOverlay.tmpViewspaceX[3], TileOverlay.tmpViewspaceY[1], TileOverlay.tmpViewspaceY[3], TileOverlay.tmpViewspaceZ[1], TileOverlay.tmpViewspaceZ[3], overlay.triangleTextureIds[v]);
				} else {
					Draw3D.fillTexturedTriangle(x0, x1, x2, y0, y1, y2, overlay.triangleColorA[v], overlay.triangleColorB[v], overlay.triangleColorC[v], TileOverlay.tmpViewspaceX[a], TileOverlay.tmpViewspaceY[a], TileOverlay.tmpViewspaceZ[a], TileOverlay.tmpViewspaceX[b], TileOverlay.tmpViewspaceX[c], TileOverlay.tmpViewspaceY[b], TileOverlay.tmpViewspaceY[c], TileOverlay.tmpViewspaceZ[b], TileOverlay.tmpViewspaceZ[c], overlay.triangleTextureIds[v]);
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "f", descriptor = "(III)I")
	private int mulLightness(@OriginalArg(1) int hsl, @OriginalArg(0) int lightness) {
		@Pc(3) int invLightness = 127 - lightness;
		lightness = invLightness * (hsl & 0x7F) / 160;
		if (lightness < 2) {
			lightness = 2;
		} else if (lightness > 126) {
			lightness = 126;
		}
		return (hsl & 0xFF80) + lightness;
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIIIII)Z")
	private boolean pointInsideTriangle(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int y0, @OriginalArg(3) int y1, @OriginalArg(4) int y2, @OriginalArg(5) int x0, @OriginalArg(6) int x1, @OriginalArg(7) int x2) {
		if (y < y0 && y < y1 && y < y2) {
			return false;
		} else if (y > y0 && y > y1 && y > y2) {
			return false;
		} else if (x < x0 && x < x1 && x < x2) {
			return false;
		} else if (x > x0 && x > x1 && x > x2) {
			return false;
		} else {
			@Pc(59) int crossProduct_01 = (y - y0) * (x1 - x0) - (x - x0) * (y1 - y0);
			@Pc(75) int crossProduct_20 = (y - y2) * (x0 - x2) - (x - x2) * (y0 - y2);
			@Pc(91) int crossProduct_12 = (y - y1) * (x2 - x1) - (x - x1) * (y2 - y1);
			return crossProduct_01 * crossProduct_12 > 0 && crossProduct_12 * crossProduct_20 > 0;
		}
	}

	@OriginalMember(owner = "client!r", name = "b", descriptor = "(Z)V")
	private void updateActiveOccluders() {
		@Pc(5) int count = levelOccluderCount[topLevel];
		@Pc(9) Occluder[] occluders = levelOccluders[topLevel];
		activeOccluderCount = 0;
		for (@Pc(13) int i = 0; i < count; i++) {
			@Pc(19) Occluder occluder = occluders[i];
			@Pc(30) int deltaMaxY;
			@Pc(43) int deltaMinTileZ;
			@Pc(54) int deltaMaxTileZ;
			@Pc(84) int deltaMaxTileX;
			if (occluder.type == 1) {
				deltaMaxY = occluder.minTileX + 25 - eyeTileX;
				if (deltaMaxY >= 0 && deltaMaxY <= 50) {
					deltaMinTileZ = occluder.minTileZ + 25 - eyeTileZ;
					if (deltaMinTileZ < 0) {
						deltaMinTileZ = 0;
					}
					deltaMaxTileZ = occluder.maxTileZ + 25 - eyeTileZ;
					if (deltaMaxTileZ > 50) {
						deltaMaxTileZ = 50;
					}
					boolean ok = false;
					while (deltaMinTileZ <= deltaMaxTileZ) {
						if (visibilityMap[deltaMaxY][deltaMinTileZ++]) {
							ok = true;
							break;
						}
					}
					if (ok) {
						deltaMaxTileX = eyeX - occluder.minX;
						if (deltaMaxTileX > 32) {
							occluder.mode = 1;
						} else {
							if (deltaMaxTileX >= -32) {
								continue;
							}
							occluder.mode = 2;
							deltaMaxTileX = -deltaMaxTileX;
						}
						occluder.minDeltaZ = (occluder.minZ - eyeZ << 8) / deltaMaxTileX;
						occluder.maxDeltaZ = (occluder.maxZ - eyeZ << 8) / deltaMaxTileX;
						occluder.minDeltaY = (occluder.minY - eyeY << 8) / deltaMaxTileX;
						occluder.maxDeltaY = (occluder.maxY - eyeY << 8) / deltaMaxTileX;
						activeOccluders[activeOccluderCount++] = occluder;
					}
				}
			} else if (occluder.type == 2) {
				deltaMaxY = occluder.minTileZ + 25 - eyeTileZ;
				if (deltaMaxY >= 0 && deltaMaxY <= 50) {
					deltaMinTileZ = occluder.minTileX + 25 - eyeTileX;
					if (deltaMinTileZ < 0) {
						deltaMinTileZ = 0;
					}
					deltaMaxTileZ = occluder.maxTileX + 25 - eyeTileX;
					if (deltaMaxTileZ > 50) {
						deltaMaxTileZ = 50;
					}
					boolean ok = false;
					while (deltaMinTileZ <= deltaMaxTileZ) {
						if (visibilityMap[deltaMinTileZ++][deltaMaxY]) {
							ok = true;
							break;
						}
					}
					if (ok) {
						deltaMaxTileX = eyeZ - occluder.minZ;
						if (deltaMaxTileX > 32) {
							occluder.mode = 3;
						} else {
							if (deltaMaxTileX >= -32) {
								continue;
							}
							occluder.mode = 4;
							deltaMaxTileX = -deltaMaxTileX;
						}
						occluder.minDeltaX = (occluder.minX - eyeX << 8) / deltaMaxTileX;
						occluder.maxDeltaX = (occluder.maxX - eyeX << 8) / deltaMaxTileX;
						occluder.minDeltaY = (occluder.minY - eyeY << 8) / deltaMaxTileX;
						occluder.maxDeltaY = (occluder.maxY - eyeY << 8) / deltaMaxTileX;
						activeOccluders[activeOccluderCount++] = occluder;
					}
				}
			} else if (occluder.type == 4) {
				deltaMaxY = occluder.minY - eyeY;
				if (deltaMaxY > 128) {
					deltaMinTileZ = occluder.minTileZ + 25 - eyeTileZ;
					if (deltaMinTileZ < 0) {
						deltaMinTileZ = 0;
					}
					deltaMaxTileZ = occluder.maxTileZ + 25 - eyeTileZ;
					if (deltaMaxTileZ > 50) {
						deltaMaxTileZ = 50;
					}
					if (deltaMinTileZ <= deltaMaxTileZ) {
						@Pc(330) int deltaMinTileX = occluder.minTileX + 25 - eyeTileX;
						if (deltaMinTileX < 0) {
							deltaMinTileX = 0;
						}
						deltaMaxTileX = occluder.maxTileX + 25 - eyeTileX;
						if (deltaMaxTileX > 50) {
							deltaMaxTileX = 50;
						}
						@Pc(348) boolean ok = false;
						find_visible_tile:
						for (@Pc(350) int x = deltaMinTileX; x <= deltaMaxTileX; x++) {
							for (@Pc(354) int z = deltaMinTileZ; z <= deltaMaxTileZ; z++) {
								if (visibilityMap[x][z]) {
									ok = true;
									break find_visible_tile;
								}
							}
						}
						if (ok) {
							occluder.mode = 5;
							occluder.minDeltaX = (occluder.minX - eyeX << 8) / deltaMaxY;
							occluder.maxDeltaX = (occluder.maxX - eyeX << 8) / deltaMaxY;
							occluder.minDeltaZ = (occluder.minZ - eyeZ << 8) / deltaMaxY;
							occluder.maxDeltaZ = (occluder.maxZ - eyeZ << 8) / deltaMaxY;
							activeOccluders[activeOccluderCount++] = occluder;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "g", descriptor = "(III)Z")
	private boolean tileVisible(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
		@Pc(8) int cycle = this.levelTileOcclusionCycles[level][x][z];
		if (cycle == -World3D.cycle) {
			return false;
		} else if (cycle == World3D.cycle) {
			return true;
		} else {
			@Pc(23) int sx = x << 7;
			@Pc(27) int sz = z << 7;
			if (this.occluded(sx + 1, this.levelHeightmaps[level][x][z], sz + 1) && this.occluded(sx + 128 - 1, this.levelHeightmaps[level][x + 1][z], sz + 1) && this.occluded(sx + 128 - 1, this.levelHeightmaps[level][x + 1][z + 1], sz + 128 - 1) && this.occluded(sx + 1, this.levelHeightmaps[level][x][z + 1], sz + 128 - 1)) {
				this.levelTileOcclusionCycles[level][x][z] = World3D.cycle;
				return true;
			} else {
				this.levelTileOcclusionCycles[level][x][z] = -World3D.cycle;
				return false;
			}
		}
	}

	@OriginalMember(owner = "client!r", name = "i", descriptor = "(IIII)Z")
	private boolean wallVisible(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z, @OriginalArg(3) int type) {
		if (!this.tileVisible(level, x, z)) {
			return false;
		}
		@Pc(11) int sceneX = x << 7;
		@Pc(15) int sceneZ = z << 7;
		@Pc(26) int sceneY = this.levelHeightmaps[level][x][z] - 1;
		@Pc(30) int y0 = sceneY - 120;
		@Pc(34) int y1 = sceneY - 230;
		@Pc(38) int y2 = sceneY - 238;
		if (type < 16) {
			if (type == 1) {
				if (sceneX > eyeX) {
					if (!this.occluded(sceneX, sceneY, sceneZ)) {
						return false;
					}
					if (!this.occluded(sceneX, sceneY, sceneZ + 128)) {
						return false;
					}
				}
				if (level > 0) {
					if (!this.occluded(sceneX, y0, sceneZ)) {
						return false;
					}
					if (!this.occluded(sceneX, y0, sceneZ + 128)) {
						return false;
					}
				}
				if (!this.occluded(sceneX, y1, sceneZ)) {
					return false;
				}
				return this.occluded(sceneX, y1, sceneZ + 128);
			}
			if (type == 2) {
				if (sceneZ < eyeZ) {
					if (!this.occluded(sceneX, sceneY, sceneZ + 128)) {
						return false;
					}
					if (!this.occluded(sceneX + 128, sceneY, sceneZ + 128)) {
						return false;
					}
				}
				if (level > 0) {
					if (!this.occluded(sceneX, y0, sceneZ + 128)) {
						return false;
					}
					if (!this.occluded(sceneX + 128, y0, sceneZ + 128)) {
						return false;
					}
				}
				if (!this.occluded(sceneX, y1, sceneZ + 128)) {
					return false;
				}
				return this.occluded(sceneX + 128, y1, sceneZ + 128);
			}
			if (type == 4) {
				if (sceneX < eyeX) {
					if (!this.occluded(sceneX + 128, sceneY, sceneZ)) {
						return false;
					}
					if (!this.occluded(sceneX + 128, sceneY, sceneZ + 128)) {
						return false;
					}
				}
				if (level > 0) {
					if (!this.occluded(sceneX + 128, y0, sceneZ)) {
						return false;
					}
					if (!this.occluded(sceneX + 128, y0, sceneZ + 128)) {
						return false;
					}
				}
				if (!this.occluded(sceneX + 128, y1, sceneZ)) {
					return false;
				}
				return this.occluded(sceneX + 128, y1, sceneZ + 128);
			}
			if (type == 8) {
				if (sceneZ > eyeZ) {
					if (!this.occluded(sceneX, sceneY, sceneZ)) {
						return false;
					}
					if (!this.occluded(sceneX + 128, sceneY, sceneZ)) {
						return false;
					}
				}
				if (level > 0) {
					if (!this.occluded(sceneX, y0, sceneZ)) {
						return false;
					}
					if (!this.occluded(sceneX + 128, y0, sceneZ)) {
						return false;
					}
				}
				if (!this.occluded(sceneX, y1, sceneZ)) {
					return false;
				}
				return this.occluded(sceneX + 128, y1, sceneZ);
			}
		}
		if (!this.occluded(sceneX + 64, y2, sceneZ + 64)) {
			return false;
		} else if (type == 16) {
			return this.occluded(sceneX, y1, sceneZ + 128);
		} else if (type == 32) {
			return this.occluded(sceneX + 128, y1, sceneZ + 128);
		} else if (type == 64) {
			return this.occluded(sceneX + 128, y1, sceneZ);
		} else if (type == 128) {
			return this.occluded(sceneX, y1, sceneZ);
		} else {
			System.out.println("Warning unsupported wall type");
			return true;
		}
	}

	@OriginalMember(owner = "client!r", name = "j", descriptor = "(IIII)Z")
	private boolean visible(@OriginalArg(0) int level, @OriginalArg(1) int tileX, @OriginalArg(2) int tileZ, @OriginalArg(3) int y) {
		if (this.tileVisible(level, tileX, tileZ)) {
			@Pc(11) int x = tileX << 7;
			@Pc(15) int z = tileZ << 7;
			return this.occluded(x + 1, this.levelHeightmaps[level][tileX][tileZ] - y, z + 1) && this.occluded(x + 128 - 1, this.levelHeightmaps[level][tileX + 1][tileZ] - y, z + 1) && this.occluded(x + 128 - 1, this.levelHeightmaps[level][tileX + 1][tileZ + 1] - y, z + 128 - 1) && this.occluded(x + 1, this.levelHeightmaps[level][tileX][tileZ + 1] - y, z + 128 - 1);
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "a", descriptor = "(IIIIII)Z")
	private boolean locVisible(@OriginalArg(0) int level, @OriginalArg(1) int minX, @OriginalArg(2) int maxX, @OriginalArg(3) int minZ, @OriginalArg(4) int maxZ, @OriginalArg(5) int y) {
		@Pc(19) int x;
		@Pc(23) int z;
		if (minX != maxX || minZ != maxZ) {
			for (x = minX; x <= maxX; x++) {
				for (z = minZ; z <= maxZ; z++) {
					if (this.levelTileOcclusionCycles[level][x][z] == -cycle) {
						return false;
					}
				}
			}
			z = (minX << 7) + 1;
			@Pc(160) int z0 = (minZ << 7) + 2;
			@Pc(171) int y0 = this.levelHeightmaps[level][minX][minZ] - y;
			if (!this.occluded(z, y0, z0)) {
				return false;
			}
			@Pc(185) int x1 = (maxX << 7) - 1;
			if (!this.occluded(x1, y0, z0)) {
				return false;
			}
			@Pc(199) int z1 = (maxZ << 7) - 1;
			if (!this.occluded(z, y0, z1)) {
				return false;
			} else return this.occluded(x1, y0, z1);
		} else if (this.tileVisible(level, minX, minZ)) {
			x = minX << 7;
			z = minZ << 7;
			return this.occluded(x + 1, this.levelHeightmaps[level][minX][minZ] - y, z + 1) && this.occluded(x + 128 - 1, this.levelHeightmaps[level][minX + 1][minZ] - y, z + 1) && this.occluded(x + 128 - 1, this.levelHeightmaps[level][minX + 1][minZ + 1] - y, z + 128 - 1) && this.occluded(x + 1, this.levelHeightmaps[level][minX][minZ + 1] - y, z + 128 - 1);
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!r", name = "h", descriptor = "(III)Z")
	private boolean occluded(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int z) {
		for (@Pc(1) int i = 0; i < activeOccluderCount; i++) {
			@Pc(7) Occluder occluder = activeOccluders[i];

			if (occluder.mode == 1) {
				int dx = occluder.minX - x;
				if (dx > 0) {
					int minZ = occluder.minZ + (occluder.minDeltaZ * dx >> 8);
					int maxZ = occluder.maxZ + (occluder.maxDeltaZ * dx >> 8);
					int minY = occluder.minY + (occluder.minDeltaY * dx >> 8);
					int maxY = occluder.maxY + (occluder.maxDeltaY * dx >> 8);
					if (z >= minZ && z <= maxZ && y >= minY && y <= maxY) {
						return true;
					}
				}
			} else if (occluder.mode == 2) {
				int dx = x - occluder.minX;
				if (dx > 0) {
					int minZ = occluder.minZ + (occluder.minDeltaZ * dx >> 8);
					int maxZ = occluder.maxZ + (occluder.maxDeltaZ * dx >> 8);
					int minY = occluder.minY + (occluder.minDeltaY * dx >> 8);
					int maxY = occluder.maxY + (occluder.maxDeltaY * dx >> 8);
					if (z >= minZ && z <= maxZ && y >= minY && y <= maxY) {
						return true;
					}
				}
			} else if (occluder.mode == 3) {
				int dz = occluder.minZ - z;
				if (dz > 0) {
					int minX = occluder.minX + (occluder.minDeltaX * dz >> 8);
					int maxX = occluder.maxX + (occluder.maxDeltaX * dz >> 8);
					int minY = occluder.minY + (occluder.minDeltaY * dz >> 8);
					int maxY = occluder.maxY + (occluder.maxDeltaY * dz >> 8);
					if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
						return true;
					}
				}
			} else if (occluder.mode == 4) {
				int dz = z - occluder.minZ;
				if (dz > 0) {
					int minX = occluder.minX + (occluder.minDeltaX * dz >> 8);
					int maxX = occluder.maxX + (occluder.maxDeltaX * dz >> 8);
					int minY = occluder.minY + (occluder.minDeltaY * dz >> 8);
					int maxY = occluder.maxY + (occluder.maxDeltaY * dz >> 8);
					if (x >= minX && x <= maxX && y >= minY && y <= maxY) {
						return true;
					}
				}
			} else if (occluder.mode == 5) {
				int dy = y - occluder.minY;
				if (dy > 0) {
					int minX = occluder.minX + (occluder.minDeltaX * dy >> 8);
					int maxX = occluder.maxX + (occluder.maxDeltaX * dy >> 8);
					int minZ = occluder.minZ + (occluder.minDeltaZ * dy >> 8);
					int maxZ = occluder.maxZ + (occluder.maxDeltaZ * dy >> 8);
					if (x >= minX && x <= maxX && z >= minZ && z <= maxZ) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
