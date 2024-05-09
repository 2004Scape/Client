package jagex2.dash3d;

import jagex2.config.FloType;
import jagex2.config.LocType;
import jagex2.config.SeqType;
import jagex2.dash3d.entity.LocEntity;
import jagex2.datastruct.LinkList;
import jagex2.graphics.Draw3D;
import jagex2.graphics.Model;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name and packaging confirmed 100% in rs2/mapview applet strings
@OriginalClass("client!c")
public class World {

	@OriginalMember(owner = "client!c", name = "d", descriptor = "Z")
	public static boolean lowMemory = true;

	@OriginalMember(owner = "client!c", name = "e", descriptor = "I")
	public static int levelBuilt;

	@OriginalMember(owner = "client!c", name = "f", descriptor = "Z")
	public static boolean fullbright;

	@OriginalMember(owner = "client!c", name = "g", descriptor = "I")
	private final int maxTileX;

	@OriginalMember(owner = "client!c", name = "h", descriptor = "I")
	private final int maxTileZ;

	@OriginalMember(owner = "client!c", name = "i", descriptor = "[[[I")
	private final int[][][] levelHeightmap;

	@OriginalMember(owner = "client!c", name = "j", descriptor = "[[[B")
	private final byte[][][] levelTileFlags;

	@OriginalMember(owner = "client!c", name = "k", descriptor = "[[[B")
	private final byte[][][] levelTileUnderlayIds;

	@OriginalMember(owner = "client!c", name = "l", descriptor = "[[[B")
	private final byte[][][] levelTileOverlayIds;

	@OriginalMember(owner = "client!c", name = "m", descriptor = "[[[B")
	private final byte[][][] levelTileOverlayShape;

	@OriginalMember(owner = "client!c", name = "n", descriptor = "[[[B")
	private final byte[][][] levelTileOverlayRotation;

	@OriginalMember(owner = "client!c", name = "o", descriptor = "[[[B")
	private final byte[][][] levelShademap;

	@OriginalMember(owner = "client!c", name = "p", descriptor = "[[I")
	private final int[][] levelLightmap;

	@OriginalMember(owner = "client!c", name = "q", descriptor = "[I")
	private final int[] blendChroma;

	@OriginalMember(owner = "client!c", name = "r", descriptor = "[I")
	private final int[] blendSaturation;

	@OriginalMember(owner = "client!c", name = "s", descriptor = "[I")
	private final int[] blendLightness;

	@OriginalMember(owner = "client!c", name = "t", descriptor = "[I")
	private final int[] blendLuminance;

	@OriginalMember(owner = "client!c", name = "u", descriptor = "[I")
	private final int[] blendMagnitude;

	@OriginalMember(owner = "client!c", name = "v", descriptor = "[[[I")
	private final int[][][] levelOccludemap;

	@OriginalMember(owner = "client!c", name = "w", descriptor = "[I")
	public static final int[] ROTATION_WALL_TYPE = new int[] { 1, 2, 4, 8 };

	@OriginalMember(owner = "client!c", name = "x", descriptor = "[I")
	public static final int[] ROTATION_WALL_CORNER_TYPE = new int[] { 16, 32, 64, 128 };

	@OriginalMember(owner = "client!c", name = "y", descriptor = "[I")
	public static final int[] WALL_DECORATION_ROTATION_FORWARD_X = new int[] { 1, 0, -1, 0 };

	@OriginalMember(owner = "client!c", name = "z", descriptor = "[I")
	public static final int[] WALL_DECORATION_ROTATION_FORWARD_Z = new int[] { 0, -1, 0, 1 };

	@OriginalMember(owner = "client!c", name = "A", descriptor = "I")
	public static int randomHueOffset = (int) (Math.random() * 17.0D) - 8;

	@OriginalMember(owner = "client!c", name = "B", descriptor = "I")
	public static int randomLightnessOffset = (int) (Math.random() * 33.0D) - 16;

	@OriginalMember(owner = "client!c", name = "<init>", descriptor = "(I[[[BI[[[II)V")
	public World(@OriginalArg(2) int maxTileX, @OriginalArg(0) int maxTileZ, @OriginalArg(3) int[][][] levelHeightmap, @OriginalArg(1) byte[][][] levelTileFlags) {
		this.maxTileX = maxTileX;
		this.maxTileZ = maxTileZ;
		this.levelHeightmap = levelHeightmap;
		this.levelTileFlags = levelTileFlags;

		this.levelTileUnderlayIds = new byte[4][this.maxTileX][this.maxTileZ];
		this.levelTileOverlayIds = new byte[4][this.maxTileX][this.maxTileZ];
		this.levelTileOverlayShape = new byte[4][this.maxTileX][this.maxTileZ];
		this.levelTileOverlayRotation = new byte[4][this.maxTileX][this.maxTileZ];

		this.levelOccludemap = new int[4][this.maxTileX + 1][this.maxTileZ + 1];
		this.levelShademap = new byte[4][this.maxTileX + 1][this.maxTileZ + 1];
		this.levelLightmap = new int[this.maxTileX + 1][this.maxTileZ + 1];

		this.blendChroma = new int[this.maxTileZ];
		this.blendSaturation = new int[this.maxTileZ];
		this.blendLightness = new int[this.maxTileZ];
		this.blendLuminance = new int[this.maxTileZ];
		this.blendMagnitude = new int[this.maxTileZ];
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(II)I")
	public static int perlin(@OriginalArg(0) int x, @OriginalArg(1) int z) {
		@Pc(32) int value = perlin(x + 45365, z + 91923, 4) + (perlin(x + 10294, z + 37821, 2) - 128 >> 1) + (perlin(x, z, 1) - 128 >> 2) - 128;
		value = (int) ((double) value * 0.3D) + 35;
		if (value < 10) {
			value = 10;
		} else if (value > 60) {
			value = 60;
		}
		return value;
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(III)I")
	private static int perlin(@OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(2) int scale) {
		@Pc(3) int intX = x / scale;
		@Pc(9) int fracX = x & scale - 1;
		@Pc(13) int intZ = z / scale;
		@Pc(19) int fracZ = z & scale - 1;
		@Pc(23) int v1 = smoothNoise(intX, intZ);
		@Pc(29) int v2 = smoothNoise(intX + 1, intZ);
		@Pc(35) int v3 = smoothNoise(intX, intZ + 1);
		@Pc(43) int v4 = smoothNoise(intX + 1, intZ + 1);
		@Pc(49) int i1 = interpolate(v1, v2, fracX, scale);
		@Pc(55) int i2 = interpolate(v3, v4, fracX, scale);
		return interpolate(i1, i2, fracZ, scale);
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IIII)I")
	private static int interpolate(@OriginalArg(0) int a, @OriginalArg(1) int b, @OriginalArg(2) int x, @OriginalArg(3) int scale) {
		@Pc(11) int f = 65536 - Draw3D.cos[x * 1024 / scale] >> 1;
		return (a * (65536 - f) >> 16) + (b * f >> 16);
	}

	@OriginalMember(owner = "client!c", name = "b", descriptor = "(II)I")
	private static int smoothNoise(@OriginalArg(0) int x, @OriginalArg(1) int y) {
		@Pc(31) int corners = noise(x - 1, y - 1) + noise(x + 1, y - 1) + noise(x - 1, y + 1) + noise(x + 1, y + 1);
		@Pc(55) int sides = noise(x - 1, y) + noise(x + 1, y) + noise(x, y - 1) + noise(x, y + 1);
		@Pc(59) int center = noise(x, y);
		return corners / 16 + sides / 8 + center / 4;
	}

	@OriginalMember(owner = "client!c", name = "c", descriptor = "(II)I")
	private static int noise(@OriginalArg(0) int x, @OriginalArg(1) int y) {
		@Pc(5) int n = x + y * 57;
		@Pc(11) int n1 = n << 13 ^ n;
		@Pc(25) int n2 = n1 * (n1 * n1 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return n2 >> 19 & 0xFF;
	}

	@OriginalMember(owner = "client!c", name = "d", descriptor = "(II)I")
	public static int mulHSL(@OriginalArg(0) int hsl, @OriginalArg(1) int lightness) {
		if (hsl == -1) {
			return 12345678;
		}

		lightness = lightness * (hsl & 0x7F) / 128;
		if (lightness < 2) {
			lightness = 2;
		} else if (lightness > 126) {
			lightness = 126;
		}

		return (hsl & 0xFF80) + lightness;
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(ILclient!ob;Lclient!ec;II[[[IIIIILclient!r;I)V")
	public static void addLoc(@OriginalArg(7) int level, @OriginalArg(0) int x, @OriginalArg(3) int z, @OriginalArg(10) World3D scene, @OriginalArg(5) int[][][] levelHeightmap, @OriginalArg(1) LinkList locs, @OriginalArg(2) CollisionMap collision, @OriginalArg(8) int locId, @OriginalArg(9) int shape, @OriginalArg(4) int rotation, @OriginalArg(11) int trueLevel) {
		@Pc(15) int heightSW = levelHeightmap[trueLevel][x][z];
		@Pc(25) int heightSE = levelHeightmap[trueLevel][x + 1][z];
		@Pc(37) int heightNW = levelHeightmap[trueLevel][x + 1][z + 1];
		@Pc(47) int heightNE = levelHeightmap[trueLevel][x][z + 1];
		@Pc(57) int y = heightSW + heightSE + heightNW + heightNE >> 2;

		@Pc(60) LocType loc = LocType.get(locId);
		@Pc(72) int bitset = x + (z << 7) + (locId << 14) + 0x40000000;
		if (!loc.active) {
			bitset += Integer.MIN_VALUE;
		}

		@Pc(86) byte info = (byte) ((rotation << 6) + shape);
		@Pc(99) Model model1;
		@Pc(174) int width;
		@Pc(430) int offset;
		@Pc(452) Model model2;

		if (shape == LocType.GROUNDDECOR) {
			model1 = loc.getModel(LocType.GROUNDDECOR, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addGroundDecoration(model1, level, x, z, y, bitset, info);

			if (loc.blockwalk && loc.active) {
				collision.setBlocked(x, z);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 3, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.CENTREPIECE_STRAIGHT || shape == LocType.CENTREPIECE_DIAGONAL) {
			model1 = loc.getModel(LocType.CENTREPIECE_STRAIGHT, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			if (model1 != null) {
				@Pc(161) int yaw = 0;
				if (shape == LocType.CENTREPIECE_DIAGONAL) {
					yaw += 256;
				}

				@Pc(177) int height;
				if (rotation == 1 || rotation == 3) {
					width = loc.length;
					height = loc.width;
				} else {
					width = loc.width;
					height = loc.length;
				}

				scene.addLoc(level, x, z, y, model1, null, bitset, info, width, height, yaw);
			}

			if (loc.blockwalk) {
				collision.addLoc(x, z, loc.width, loc.length, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 2, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape >= LocType.ROOF_STRAIGHT) {
			model1 = loc.getModel(shape, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addLoc(level, x, z, y, model1, null, bitset, info, 1, 1, 0);

			if (loc.blockwalk) {
				collision.addLoc(x, z, loc.width, loc.length, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 2, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_STRAIGHT) {
			model1 = loc.getModel(LocType.WALL_STRAIGHT, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_TYPE[rotation], 0, model1, null, bitset, info);

			if (loc.blockwalk) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_DIAGONALCORNER) {
			model1 = loc.getModel(LocType.WALL_DIAGONALCORNER, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_CORNER_TYPE[rotation], 0, model1, null, bitset, info);

			if (loc.blockwalk) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_L) {
			int nextRotation = rotation + 1 & 0x3;
			@Pc(442) Model model3 = loc.getModel(LocType.WALL_L, rotation + 4, heightSW, heightSE, heightNW, heightNE, -1);
			model2 = loc.getModel(LocType.WALL_L, nextRotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_TYPE[rotation], ROTATION_WALL_TYPE[nextRotation], model3, model2, bitset, info);

			if (loc.blockwalk) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_SQUARECORNER) {
			model1 = loc.getModel(LocType.WALL_SQUARECORNER, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_CORNER_TYPE[rotation], 0, model1, null, bitset, info);

			if (loc.blockwalk) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_DIAGONAL) {
			model1 = loc.getModel(shape, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addLoc(level, x, z, y, model1, null, bitset, info, 1, 1, 0);

			if (loc.blockwalk) {
				collision.addLoc(x, z, loc.width, loc.length, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 2, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_STRAIGHT_NOOFFSET) {
			model1 = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model1, info, rotation * 512, ROTATION_WALL_TYPE[rotation]);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_STRAIGHT_OFFSET) {
			offset = 16;
			width = scene.getWallBitset(level, x, z);

			if (width > 0) {
				offset = LocType.get(width >> 14 & 0x7FFF).wallwidth;
			}

			model2 = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, WALL_DECORATION_ROTATION_FORWARD_X[rotation] * offset, WALL_DECORATION_ROTATION_FORWARD_Z[rotation] * offset, bitset, model2, info, rotation * 512, ROTATION_WALL_TYPE[rotation]);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_DIAGONAL_OFFSET) {
			model1 = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model1, info, rotation, 256);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_DIAGONAL_NOOFFSET) {
			model1 = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model1, info, rotation, 512);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_DIAGONAL_BOTH) {
			model1 = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model1, info, rotation, 768);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IIIII)V")
	public void clearLandscape(@OriginalArg(1) int startX, @OriginalArg(0) int startZ, @OriginalArg(4) int endX, @OriginalArg(3) int endZ) {
		@Pc(3) byte waterOverlay = 0;
		for (@Pc(11) int i = 0; i < FloType.count; i++) {
			if (FloType.instances[i].name.equalsIgnoreCase("water")) {
				waterOverlay = (byte) (i + 1);
				break;
			}
		}

		for (@Pc(33) int z = startX; z < startX + endX; z++) {
			for (@Pc(37) int x = startZ; x < startZ + endZ; x++) {
				if (x < 0 || x >= this.maxTileX || z < 0 || z >= this.maxTileZ) {
					continue;
				}

				this.levelTileOverlayIds[0][x][z] = waterOverlay;

				for (@Pc(62) int level = 0; level < 4; level++) {
					this.levelHeightmap[level][x][z] = 0;
					this.levelTileFlags[level][x][z] = 0;
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "([BIIIII)V")
	public void readLandscape(@OriginalArg(1) int originX, @OriginalArg(5) int originZ, @OriginalArg(4) int xOffset, @OriginalArg(3) int zOffset, @OriginalArg(0) byte[] src) {
		@Pc(7) Packet buf = new Packet(src);

		for (@Pc(20) int level = 0; level < 4; level++) {
			for (@Pc(24) int x = 0; x < 64; x++) {
				for (@Pc(28) int z = 0; z < 64; z++) {
					@Pc(34) int stx = x + xOffset;
					@Pc(38) int stz = z + zOffset;
					@Pc(60) int opcode;

					if (stx >= 0 && stx < 104 && stz >= 0 && stz < 104) {
						this.levelTileFlags[level][stx][stz] = 0;
						while (true) {
							opcode = buf.g1();
							if (opcode == 0) {
								if (level == 0) {
									this.levelHeightmap[0][stx][stz] = -perlin(stx + originX + 932731, stz + 556238 + originZ) * 8;
								} else {
									this.levelHeightmap[level][stx][stz] = this.levelHeightmap[level - 1][stx][stz] - 240;
								}
								break;
							}

							if (opcode == 1) {
								@Pc(116) int height = buf.g1();
								if (height == 1) {
									height = 0;
								}
								if (level == 0) {
									this.levelHeightmap[0][stx][stz] = -height * 8;
								} else {
									this.levelHeightmap[level][stx][stz] = this.levelHeightmap[level - 1][stx][stz] - height * 8;
								}
								break;
							}

							if (opcode <= 49) {
								this.levelTileOverlayIds[level][stx][stz] = buf.g1b();
								this.levelTileOverlayShape[level][stx][stz] = (byte) ((opcode - 2) / 4);
								this.levelTileOverlayRotation[level][stx][stz] = (byte) (opcode - 2 & 0x3);
							} else if (opcode <= 81) {
								this.levelTileFlags[level][stx][stz] = (byte) (opcode - 49);
							} else {
								this.levelTileUnderlayIds[level][stx][stz] = (byte) (opcode - 81);
							}
						}
					} else {
						while (true) {
							opcode = buf.g1();
							if (opcode == 0) {
								break;
							}

							if (opcode == 1) {
								buf.g1();
								break;
							}

							if (opcode <= 49) {
								buf.g1();
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "([BLclient!r;[Lclient!ec;Lclient!ob;ZII)V")
	public void readLocs(@OriginalArg(1) World3D scene, @OriginalArg(3) LinkList locs, @OriginalArg(2) CollisionMap[] collision, @OriginalArg(0) byte[] src, @OriginalArg(6) int xOffset, @OriginalArg(5) int zOffset) {
		@Pc(7) Packet buf = new Packet(src);
		@Pc(19) int locId = -1;

		while (true) {
			@Pc(22) int deltaId = buf.gsmarts();
			if (deltaId == 0) {
				return;
			}

			locId += deltaId;

			@Pc(30) int locPos = 0;
			while (true) {
				@Pc(33) int deltaPos = buf.gsmarts();
				if (deltaPos == 0) {
					break;
				}

				locPos += deltaPos - 1;
				@Pc(45) int z = locPos & 0x3F;
				@Pc(51) int x = locPos >> 6 & 0x3F;
				@Pc(55) int level = locPos >> 12;

				@Pc(58) int info = buf.g1();
				@Pc(62) int shape = info >> 2;
				@Pc(66) int rotation = info & 0x3;
				@Pc(70) int stx = x + xOffset;
				@Pc(74) int stz = z + zOffset;

				if (stx > 0 && stz > 0 && stx < 103 && stz < 103) {
					@Pc(86) int currentLevel = level;
					if ((this.levelTileFlags[1][stx][stz] & 0x2) == 2) {
						currentLevel = level - 1;
					}

					@Pc(101) CollisionMap collisionMap = null;
					if (currentLevel >= 0) {
						collisionMap = collision[currentLevel];
					}

					this.addLoc(level, stx, stz, scene, locs, collisionMap, locId, shape, rotation);
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!ec;ZIIIILclient!r;Lclient!ob;II)V")
	private void addLoc(@OriginalArg(2) int level, @OriginalArg(9) int x, @OriginalArg(3) int z, @OriginalArg(6) World3D scene, @OriginalArg(7) LinkList locs, @OriginalArg(0) CollisionMap collision, @OriginalArg(8) int locId, @OriginalArg(5) int shape, @OriginalArg(4) int rotation) {
		if (lowMemory) {
			if ((this.levelTileFlags[level][x][z] & 0x10) != 0) {
				return;
			}

			if (this.getDrawLevel(level, x, z) != levelBuilt) {
				return;
			}
		}

		@Pc(36) int heightSW = this.levelHeightmap[level][x][z];
		@Pc(47) int heightSE = this.levelHeightmap[level][x + 1][z];
		@Pc(60) int heightNW = this.levelHeightmap[level][x + 1][z + 1];
		@Pc(71) int heightNE = this.levelHeightmap[level][x][z + 1];
		@Pc(81) int y = heightSW + heightSE + heightNW + heightNE >> 2;

		@Pc(84) LocType loc = LocType.get(locId);
		@Pc(96) int bitset = x + (z << 7) + (locId << 14) + 0x40000000;
		if (!loc.active) {
			bitset += Integer.MIN_VALUE;
		}

		@Pc(110) byte info = (byte) ((rotation << 6) + shape);
		@Pc(132) Model model;
		@Pc(209) int width;
		@Pc(810) int offset;
		@Pc(832) Model model1;

		if (shape == LocType.GROUNDDECOR) {
			if (lowMemory && !loc.active && !loc.forcedecor) {
				return;
			}

			model = loc.getModel(LocType.GROUNDDECOR, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addGroundDecoration(model, level, x, z, y, bitset, info);

			if (loc.blockwalk && loc.active && collision != null) {
				collision.setBlocked(x, z);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 3, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.CENTREPIECE_STRAIGHT || shape == LocType.CENTREPIECE_DIAGONAL) {
			model = loc.getModel(LocType.CENTREPIECE_STRAIGHT, rotation, heightSW, heightSE, heightNW, heightNE, -1);

			if (model != null) {
				@Pc(196) int yaw = 0;
				if (shape == LocType.CENTREPIECE_DIAGONAL) {
					yaw += 256;
				}

				@Pc(212) int height;
				if (rotation == 1 || rotation == 3) {
					width = loc.length;
					height = loc.width;
				} else {
					width = loc.width;
					height = loc.length;
				}

				if (scene.addLoc(level, x, z, y, model, null, bitset, info, width, height, yaw) && loc.shadow) {
					for (@Pc(240) int dx = 0; dx <= width; dx++) {
						for (@Pc(244) int dz = 0; dz <= height; dz++) {
							@Pc(251) int shade = model.radius / 4;
							if (shade > 30) {
								shade = 30;
							}

							if (shade > this.levelShademap[level][x + dx][z + dz]) {
								this.levelShademap[level][x + dx][z + dz] = (byte) shade;
							}
						}
					}
				}
			}

			if (loc.blockwalk && collision != null) {
				collision.addLoc(x, z, loc.width, loc.length, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 2, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape >= LocType.ROOF_STRAIGHT) {
			model = loc.getModel(shape, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addLoc(level, x, z, y, model, null, bitset, info, 1, 1, 0);

			if (shape >= LocType.ROOF_STRAIGHT && shape <= LocType.ROOF_FLAT && shape != LocType.ROOF_DIAGONAL_WITH_ROOFEDGE && level > 0) {
				this.levelOccludemap[level][x][z] |= 0x924;
			}

			if (loc.blockwalk && collision != null) {
				collision.addLoc(x, z, loc.width, loc.length, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 2, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_STRAIGHT) {
			model = loc.getModel(LocType.WALL_STRAIGHT, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_TYPE[rotation], 0, model, null, bitset, info);

			if (rotation == 0) {
				if (loc.shadow) {
					this.levelShademap[level][x][z] = 50;
					this.levelShademap[level][x][z + 1] = 50;
				}

				if (loc.occlude) {
					this.levelOccludemap[level][x][z] |= 0x249;
				}
			} else if (rotation == 1) {
				if (loc.shadow) {
					this.levelShademap[level][x][z + 1] = 50;
					this.levelShademap[level][x + 1][z + 1] = 50;
				}

				if (loc.occlude) {
					this.levelOccludemap[level][x][z + 1] |= 0x492;
				}
			} else if (rotation == 2) {
				if (loc.shadow) {
					this.levelShademap[level][x + 1][z] = 50;
					this.levelShademap[level][x + 1][z + 1] = 50;
				}

				if (loc.occlude) {
					this.levelOccludemap[level][x + 1][z] |= 0x249;
				}
			} else if (rotation == 3) {
				if (loc.shadow) {
					this.levelShademap[level][x][z] = 50;
					this.levelShademap[level][x + 1][z] = 50;
				}

				if (loc.occlude) {
					this.levelOccludemap[level][x][z] |= 0x492;
				}
			}

			if (loc.blockwalk && collision != null) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}

			if (loc.wallwidth != 16) {
				scene.setWallDecorationOffset(level, x, z, loc.wallwidth);
			}
		} else if (shape == LocType.WALL_DIAGONALCORNER) {
			model = loc.getModel(LocType.WALL_DIAGONALCORNER, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_CORNER_TYPE[rotation], 0, model, null, bitset, info);

			if (loc.shadow) {
				if (rotation == 0) {
					this.levelShademap[level][x][z + 1] = 50;
				} else if (rotation == 1) {
					this.levelShademap[level][x + 1][z + 1] = 50;
				} else if (rotation == 2) {
					this.levelShademap[level][x + 1][z] = 50;
				} else if (rotation == 3) {
					this.levelShademap[level][x][z] = 50;
				}
			}

			if (loc.blockwalk && collision != null) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_L) {
			int nextRotation = rotation + 1 & 0x3;
			@Pc(822) Model model3 = loc.getModel(LocType.WALL_L, rotation + 4, heightSW, heightSE, heightNW, heightNE, -1);
			model1 = loc.getModel(LocType.WALL_L, nextRotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_TYPE[rotation], ROTATION_WALL_TYPE[nextRotation], model3, model1, bitset, info);

			if (loc.occlude) {
				if (rotation == 0) {
					this.levelOccludemap[level][x][z] |= 0x109;
					this.levelOccludemap[level][x][z + 1] |= 0x492;
				} else if (rotation == 1) {
					this.levelOccludemap[level][x][z + 1] |= 0x492;
					this.levelOccludemap[level][x + 1][z] |= 0x249;
				} else if (rotation == 2) {
					this.levelOccludemap[level][x + 1][z] |= 0x249;
					this.levelOccludemap[level][x][z] |= 0x492;
				} else if (rotation == 3) {
					this.levelOccludemap[level][x][z] |= 0x492;
					this.levelOccludemap[level][x][z] |= 0x249;
				}
			}

			if (loc.blockwalk && collision != null) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}

			if (loc.wallwidth != 16) {
				scene.setWallDecorationOffset(level, x, z, loc.wallwidth);
			}
		} else if (shape == LocType.WALL_SQUARECORNER) {
			model = loc.getModel(LocType.WALL_SQUARECORNER, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addWall(level, x, z, y, ROTATION_WALL_CORNER_TYPE[rotation], 0, model, null, bitset, info);

			if (loc.shadow) {
				if (rotation == 0) {
					this.levelShademap[level][x][z + 1] = 50;
				} else if (rotation == 1) {
					this.levelShademap[level][x + 1][z + 1] = 50;
				} else if (rotation == 2) {
					this.levelShademap[level][x + 1][z] = 50;
				} else if (rotation == 3) {
					this.levelShademap[level][x][z] = 50;
				}
			}

			if (loc.blockwalk && collision != null) {
				collision.addWall(x, z, shape, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 0, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALL_DIAGONAL) {
			model = loc.getModel(shape, rotation, heightSW, heightSE, heightNW, heightNE, -1);
			scene.addLoc(level, x, z, y, model, null, bitset, info, 1, 1, 0);

			if (loc.blockwalk && collision != null) {
				collision.addLoc(x, z, loc.width, loc.length, rotation, loc.blockrange);
			}

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 2, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_STRAIGHT_NOOFFSET) {
			model = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model, info, rotation * 512, ROTATION_WALL_TYPE[rotation]);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_STRAIGHT_OFFSET) {
			offset = 16;
			width = scene.getWallBitset(level, x, z);
			if (width > 0) {
				offset = LocType.get(width >> 14 & 0x7FFF).wallwidth;
			}

			model1 = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, WALL_DECORATION_ROTATION_FORWARD_X[rotation] * offset, WALL_DECORATION_ROTATION_FORWARD_Z[rotation] * offset, bitset, model1, info, rotation * 512, ROTATION_WALL_TYPE[rotation]);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_DIAGONAL_OFFSET) {
			model = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model, info, rotation, 256);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_DIAGONAL_NOOFFSET) {
			model = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model, info, rotation, 512);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		} else if (shape == LocType.WALLDECOR_DIAGONAL_BOTH) {
			model = loc.getModel(LocType.WALLDECOR_STRAIGHT_NOOFFSET, 0, heightSW, heightSE, heightNW, heightNE, -1);
			scene.setWallDecoration(level, x, z, y, 0, 0, bitset, model, info, rotation, 768);

			if (loc.anim != -1) {
				locs.addTail(new LocEntity(locId, level, 1, x, z, SeqType.instances[loc.anim], true));
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!r;I[Lclient!ec;)V")
	public void build(@OriginalArg(0) World3D scene, @OriginalArg(2) CollisionMap[] collision) {
		for (@Pc(3) int level = 0; level < 4; level++) {
			for (int x = 0; x < 104; x++) {
				for (int z = 0; z < 104; z++) {
					// solid
					if ((this.levelTileFlags[level][x][z] & 0x1) == 1) {
						int trueLevel = level;

						// bridge
						if ((this.levelTileFlags[1][x][z] & 0x2) == 2) {
							trueLevel--;
						}

						if (trueLevel >= 0) {
							collision[trueLevel].setBlocked(x, z);
						}
					}
				}
			}
		}

		randomHueOffset += (int) (Math.random() * 5.0D) - 2;
		if (randomHueOffset < -8) {
			randomHueOffset = -8;
		} else if (randomHueOffset > 8) {
			randomHueOffset = 8;
		}

		randomLightnessOffset += (int) (Math.random() * 5.0D) - 2;
		if (randomLightnessOffset < -16) {
			randomLightnessOffset = -16;
		} else if (randomLightnessOffset > 16) {
			randomLightnessOffset = 16;
		}

		for (int level = 0; level < 4; level++) {
			@Pc(108) byte[][] shademap = this.levelShademap[level];
			@Pc(110) byte lightAmbient = 96;
			@Pc(112) short lightAttenuation = 768;
			@Pc(114) byte lightX = -50;
			@Pc(116) byte lightY = -10;
			@Pc(118) byte lightZ = -50;
			int lightMag = (int) Math.sqrt(lightX * lightX + lightY * lightY + lightZ * lightZ);
			int lightMagnitude = lightAttenuation * lightMag >> 8;

			for (int z = 1; z < this.maxTileZ - 1; z++) {
				for (int x = 1; x < this.maxTileX - 1; x++) {
					int dx = this.levelHeightmap[level][x + 1][z] - this.levelHeightmap[level][x - 1][z];
					int dz = this.levelHeightmap[level][x][z + 1] - this.levelHeightmap[level][x][z - 1];
					int len = (int) Math.sqrt(dx * dx + dz * dz + 65536);
					int normalX = (dx << 8) / len;
					int normalY = 65536 / len;
					int normalZ = (dz << 8) / len;
					int light = lightAmbient + (lightX * normalX + lightY * normalY + lightZ * normalZ) / lightMagnitude;
					int shade = (shademap[x - 1][z] >> 2) + (shademap[x + 1][z] >> 3) + (shademap[x][z - 1] >> 2) + (shademap[x][z + 1] >> 3) + (shademap[x][z] >> 1);
					this.levelLightmap[x][z] = light - shade;
				}
			}

			for (int z = 0; z < this.maxTileZ; z++) {
				this.blendChroma[z] = 0;
				this.blendSaturation[z] = 0;
				this.blendLightness[z] = 0;
				this.blendLuminance[z] = 0;
				this.blendMagnitude[z] = 0;
			}

			for (int x0 = -5; x0 < this.maxTileX + 5; x0++) {
				for (int z0 = 0; z0 < this.maxTileZ; z0++) {
					int x1 = x0 + 5;
					@Pc(419) int debugMag;

					if (x1 >= 0 && x1 < this.maxTileX) {
						int underlayId = this.levelTileUnderlayIds[level][x1][z0] & 0xFF;

						if (underlayId > 0) {
							@Pc(378) FloType flu = FloType.instances[underlayId - 1];
							this.blendChroma[z0] += flu.chroma;
							this.blendSaturation[z0] += flu.saturation;
							this.blendLightness[z0] += flu.lightness;
							this.blendLuminance[z0] += flu.luminance;
							debugMag = this.blendMagnitude[z0]++;
						}
					}

					int x2 = x0 - 5;
					if (x2 >= 0 && x2 < this.maxTileX) {
						int underlayId = this.levelTileUnderlayIds[level][x2][z0] & 0xFF;

						if (underlayId > 0) {
							@Pc(451) FloType flu = FloType.instances[underlayId - 1];
							this.blendChroma[z0] -= flu.chroma;
							this.blendSaturation[z0] -= flu.saturation;
							this.blendLightness[z0] -= flu.lightness;
							this.blendLuminance[z0] -= flu.luminance;
							debugMag = this.blendMagnitude[z0]--;
						}
					}
				}

				if (x0 >= 1 && x0 < this.maxTileX - 1) {
					int hueAccumulator = 0;
					int saturationAccumulator = 0;
					int lightnessAccumulator = 0;
					int luminanceAccumulator = 0;
					int magnitudeAccumulator = 0;

					for (int z0 = -5; z0 < this.maxTileZ + 5; z0++) {
						@Pc(527) int dz1 = z0 + 5;
						if (dz1 >= 0 && dz1 < this.maxTileZ) {
							hueAccumulator += this.blendChroma[dz1];
							saturationAccumulator += this.blendSaturation[dz1];
							lightnessAccumulator += this.blendLightness[dz1];
							luminanceAccumulator += this.blendLuminance[dz1];
							magnitudeAccumulator += this.blendMagnitude[dz1];
						}

						@Pc(572) int dz2 = z0 - 5;
						if (dz2 >= 0 && dz2 < this.maxTileZ) {
							hueAccumulator -= this.blendChroma[dz2];
							saturationAccumulator -= this.blendSaturation[dz2];
							lightnessAccumulator -= this.blendLightness[dz2];
							luminanceAccumulator -= this.blendLuminance[dz2];
							magnitudeAccumulator -= this.blendMagnitude[dz2];
						}

						if (z0 >= 1 && z0 < this.maxTileZ - 1 && (!lowMemory || (this.levelTileFlags[level][x0][z0] & 0x10) == 0 && this.getDrawLevel(level, x0, z0) == levelBuilt)) {
							@Pc(655) int underlayId = this.levelTileUnderlayIds[level][x0][z0] & 0xFF;
							@Pc(666) int overlayId = this.levelTileOverlayIds[level][x0][z0] & 0xFF;

							if (underlayId > 0 || overlayId > 0) {
								@Pc(679) int heightSW = this.levelHeightmap[level][x0][z0];
								@Pc(690) int heightSE = this.levelHeightmap[level][x0 + 1][z0];
								@Pc(703) int heightNE = this.levelHeightmap[level][x0 + 1][z0 + 1];
								@Pc(714) int heightNW = this.levelHeightmap[level][x0][z0 + 1];

								@Pc(721) int lightSW = this.levelLightmap[x0][z0];
								@Pc(730) int lightSE = this.levelLightmap[x0 + 1][z0];
								@Pc(741) int lightNE = this.levelLightmap[x0 + 1][z0 + 1];
								@Pc(750) int lightNW = this.levelLightmap[x0][z0 + 1];

								@Pc(752) int baseColor = -1;
								@Pc(754) int tintColor = -1;

								if (underlayId > 0) {
									int hue = hueAccumulator * 256 / luminanceAccumulator;
									int saturation = saturationAccumulator / magnitudeAccumulator;
									@Pc(770) int lightness = lightnessAccumulator / magnitudeAccumulator;
									baseColor = this.hsl24to16(hue, saturation, lightness);
									@Pc(782) int randomHue = hue + randomHueOffset & 0xFF;
									lightness += randomLightnessOffset;
									if (lightness < 0) {
										lightness = 0;
									} else if (lightness > 255) {
										lightness = 255;
									}
									tintColor = this.hsl24to16(randomHue, saturation, lightness);
								}

								if (level > 0) {
									@Pc(807) boolean occludes = underlayId != 0 || this.levelTileOverlayShape[level][x0][z0] == 0;

									if (overlayId > 0 && !FloType.instances[overlayId - 1].occlude) {
										occludes = false;
									}

									// occludes && flat
									if (occludes && heightSW == heightSE && heightSW == heightNE && heightSW == heightNW) {
										this.levelOccludemap[level][x0][z0] |= 0x924;
									}
								}

								int shadeColor = 0;
								if (baseColor != -1) {
									shadeColor = Draw3D.palette[mulHSL(tintColor, 96)];
								}

								if (overlayId == 0) {
									scene.setTile(level, x0, z0, 0, 0, -1, heightSW, heightSE, heightNE, heightNW, mulHSL(baseColor, lightSW), mulHSL(baseColor, lightSE), mulHSL(baseColor, lightNE), mulHSL(baseColor, lightNW), 0, 0, 0, 0, shadeColor, 0);
								} else {
									int shape = this.levelTileOverlayShape[level][x0][z0] + 1;
									@Pc(919) byte rotation = this.levelTileOverlayRotation[level][x0][z0];
									@Pc(925) FloType flo = FloType.instances[overlayId - 1];
									@Pc(928) int textureId = flo.texture;
									@Pc(936) int hsl;
									@Pc(934) int rgb;

									if (textureId >= 0) {
										rgb = Draw3D.getAverageTextureRGB(textureId);
										hsl = -1;
									} else if (flo.rgb == 16711935) {
										rgb = 0;
										hsl = -2;
										textureId = -1;
									} else {
										hsl = this.hsl24to16(flo.hue, flo.saturation, flo.lightness);
										rgb = Draw3D.palette[this.adjustLightness(flo.hsl, 96)];
									}

									scene.setTile(level, x0, z0, shape, rotation, textureId, heightSW, heightSE, heightNE, heightNW, mulHSL(baseColor, lightSW), mulHSL(baseColor, lightSE), mulHSL(baseColor, lightNE), mulHSL(baseColor, lightNW), this.adjustLightness(hsl, lightSW), this.adjustLightness(hsl, lightSE), this.adjustLightness(hsl, lightNE), this.adjustLightness(hsl, lightNW), shadeColor, rgb);
								}
							}
						}
					}
				}
			}

			for (int stz = 1; stz < this.maxTileZ - 1; stz++) {
				for (int stx = 1; stx < this.maxTileX - 1; stx++) {
					scene.setDrawLevel(level, stx, stz, this.getDrawLevel(level, stx, stz));
				}
			}
		}

		if (!fullbright) {
			scene.buildModels(64, 768, -50, -10, -50);
		}

		for (int x = 0; x < this.maxTileX; x++) {
			for (int z = 0; z < this.maxTileZ; z++) {
				if ((this.levelTileFlags[1][x][z] & 0x2) == 2) {
					scene.setBridge(x, z);
				}
			}
		}

		if (!fullbright) {
			int wall0 = 0x1; // this flag is set by walls with rotation 0 or 2
			@Pc(1123) int wall1 = 0x2; // this flag is set by walls with rotation 1 or 3
			@Pc(1125) int floor = 0x4; // this flag is set by floors which are flat

			for (@Pc(1127) int topLevel = 0; topLevel < 4; topLevel++) {
				if (topLevel > 0) {
					wall0 <<= 0x3;
					wall1 <<= 0x3;
					floor <<= 0x3;
				}

				for (@Pc(1145) int level = 0; level <= topLevel; level++) {
					for (int tileZ = 0; tileZ <= this.maxTileZ; tileZ++) {
						for (int tileX = 0; tileX <= this.maxTileX; tileX++) {
							if ((this.levelOccludemap[level][tileX][tileZ] & wall0) != 0) {
								int minTileZ = tileZ;
								int maxTileZ = tileZ;
								int minLevel = level;
								int maxLevel = level;

								while (minTileZ > 0 && (this.levelOccludemap[level][tileX][minTileZ - 1] & wall0) != 0) {
									minTileZ--;
								}

								while (maxTileZ < this.maxTileZ && (this.levelOccludemap[level][tileX][maxTileZ + 1] & wall0) != 0) {
									maxTileZ++;
								}

								find_min_level:
								while (minLevel > 0) {
									for (int z = minTileZ; z <= maxTileZ; z++) {
										if ((this.levelOccludemap[minLevel - 1][tileX][z] & wall0) == 0) {
											break find_min_level;
										}
									}
									minLevel--;
								}

								find_max_level:
								while (maxLevel < topLevel) {
									for (int z = minTileZ; z <= maxTileZ; z++) {
										if ((this.levelOccludemap[maxLevel + 1][tileX][z] & wall0) == 0) {
											break find_max_level;
										}
									}
									maxLevel++;
								}

								int area = (maxLevel + 1 - minLevel) * (maxTileZ + 1 - minTileZ);
								if (area >= 8) {
									int minY = this.levelHeightmap[maxLevel][tileX][minTileZ] - 240;
									int maxX = this.levelHeightmap[minLevel][tileX][minTileZ];

									World3D.addOccluder(topLevel, 1, tileX * 128, minY, minTileZ * 128, tileX * 128, maxX, maxTileZ * 128 + 128);

									for (int l = minLevel; l <= maxLevel; l++) {
										for (int z = minTileZ; z <= maxTileZ; z++) {
											this.levelOccludemap[l][tileX][z] &= ~wall0;
										}
									}
								}
							}

							if ((this.levelOccludemap[level][tileX][tileZ] & wall1) != 0) {
								int minTileX = tileX;
								int maxTileX = tileX;
								int minLevel = level;
								int maxLevel = level;

								while (minTileX > 0 && (this.levelOccludemap[level][minTileX - 1][tileZ] & wall1) != 0) {
									minTileX--;
								}

								while (maxTileX < this.maxTileX && (this.levelOccludemap[level][maxTileX + 1][tileZ] & wall1) != 0) {
									maxTileX++;
								}

								find_min_level2:
								while (minLevel > 0) {
									for (int x = minTileX; x <= maxTileX; x++) {
										if ((this.levelOccludemap[minLevel - 1][x][tileZ] & wall1) == 0) {
											break find_min_level2;
										}
									}
									minLevel--;
								}

								find_max_level2:
								while (maxLevel < topLevel) {
									for (int x = minTileX; x <= maxTileX; x++) {
										if ((this.levelOccludemap[maxLevel + 1][x][tileZ] & wall1) == 0) {
											break find_max_level2;
										}
									}
									maxLevel++;
								}

								int area = (maxLevel + 1 - minLevel) * (maxTileX + 1 - minTileX);

								if (area >= 8) {
									int minY = this.levelHeightmap[maxLevel][minTileX][tileZ] - 240;
									int maxY = this.levelHeightmap[minLevel][minTileX][tileZ];

									World3D.addOccluder(topLevel, 2, minTileX * 128, minY, tileZ * 128, maxTileX * 128 + 128, maxY, tileZ * 128);

									for (int l = minLevel; l <= maxLevel; l++) {
										for (int x = minTileX; x <= maxTileX; x++) {
											this.levelOccludemap[l][x][tileZ] &= ~wall1;
										}
									}
								}
							}
							if ((this.levelOccludemap[level][tileX][tileZ] & floor) != 0) {
								int minTileX = tileX;
								int maxTileX = tileX;
								int minTileZ = tileZ;
								int maxTileZ = tileZ;

								while (minTileZ > 0 && (this.levelOccludemap[level][tileX][minTileZ - 1] & floor) != 0) {
									minTileZ--;
								}

								while (maxTileZ < this.maxTileZ && (this.levelOccludemap[level][tileX][maxTileZ + 1] & floor) != 0) {
									maxTileZ++;
								}

								find_min_tile_xz:
								while (minTileX > 0) {
									for (int z = minTileZ; z <= maxTileZ; z++) {
										if ((this.levelOccludemap[level][minTileX - 1][z] & floor) == 0) {
											break find_min_tile_xz;
										}
									}
									minTileX--;
								}

								find_max_tile_xz:
								while (maxTileX < this.maxTileX) {
									for (int z = minTileZ; z <= maxTileZ; z++) {
										if ((this.levelOccludemap[level][maxTileX + 1][z] & floor) == 0) {
											break find_max_tile_xz;
										}
									}
									maxTileX++;
								}

								if ((maxTileX + 1 - minTileX) * (maxTileZ + 1 - minTileZ) >= 4) {
									int y = this.levelHeightmap[level][minTileX][minTileZ];

									World3D.addOccluder(topLevel, 4, minTileX * 128, y, minTileZ * 128, maxTileX * 128 + 128, y, maxTileZ * 128 + 128);

									for (int x = minTileX; x <= maxTileX; x++) {
										for (int z = minTileZ; z <= maxTileZ; z++) {
											this.levelOccludemap[level][x][z] &= ~floor;
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IBII)I")
	private int getDrawLevel(@OriginalArg(0) int level, @OriginalArg(2) int stx, @OriginalArg(3) int stz) {
		if ((this.levelTileFlags[level][stx][stz] & 0x8) == 0) {
			return level <= 0 || (this.levelTileFlags[1][stx][stz] & 0x2) == 0 ? level : level - 1;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!c", name = "e", descriptor = "(II)I")
	private int adjustLightness(@OriginalArg(0) int hsl, @OriginalArg(1) int scalar) {
		if (hsl == -2) {
			return 12345678;
		}

		if (hsl == -1) {
			if (scalar < 0) {
				scalar = 0;
			} else if (scalar > 127) {
				scalar = 127;
			}
			return 127 - scalar;
		} else {
			scalar = scalar * (hsl & 0x7F) / 128;
			if (scalar < 2) {
				scalar = 2;
			} else if (scalar > 126) {
				scalar = 126;
			}
			return (hsl & 0xFF80) + scalar;
		}
	}

	@OriginalMember(owner = "client!c", name = "b", descriptor = "(III)I")
	private int hsl24to16(@OriginalArg(0) int hue, @OriginalArg(1) int saturation, @OriginalArg(2) int lightness) {
		if (lightness > 179) {
			saturation /= 2;
		}

		if (lightness > 192) {
			saturation /= 2;
		}

		if (lightness > 217) {
			saturation /= 2;
		}

		if (lightness > 243) {
			saturation /= 2;
		}

		return (hue / 4 << 10) + (saturation / 32 << 7) + lightness / 2;
	}
}
