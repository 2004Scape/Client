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

// World: Constructs the world
@OriginalClass("client!c")
public final class World {

	public static int OCCLUDER_THRESHOLD = 8;

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
	private final int[][][] levelTileFlags;

	@OriginalMember(owner = "client!c", name = "k", descriptor = "[[[B")
	private final int[][][] levelTileUnderlayIds;

	@OriginalMember(owner = "client!c", name = "l", descriptor = "[[[B")
	private final int[][][] levelTileOverlayIds;

	@OriginalMember(owner = "client!c", name = "m", descriptor = "[[[B")
	private final int[][][] levelTileOverlayShape;

	@OriginalMember(owner = "client!c", name = "n", descriptor = "[[[B")
	private final int[][][] levelTileOverlayRotation;

	@OriginalMember(owner = "client!c", name = "o", descriptor = "[[[B")
	private final int[][][] levelShademap;

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
	public World(@OriginalArg(0) int arg0, @OriginalArg(1) int[][][] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[][][] arg3) {
		this.maxTileX = arg2;
		this.maxTileZ = arg0;
		this.levelHeightmap = arg3;
		this.levelTileFlags = arg1;
		this.levelTileUnderlayIds = new int[4][this.maxTileX][this.maxTileZ];
		this.levelTileOverlayIds = new int[4][this.maxTileX][this.maxTileZ];
		this.levelTileOverlayShape = new int[4][this.maxTileX][this.maxTileZ];
		this.levelTileOverlayRotation = new int[4][this.maxTileX][this.maxTileZ];
		this.levelOccludemap = new int[4][this.maxTileX + 1][this.maxTileZ + 1];
		this.levelShademap = new int[4][this.maxTileX + 1][this.maxTileZ + 1];
		this.levelLightmap = new int[this.maxTileX + 1][this.maxTileZ + 1];
		this.blendChroma = new int[this.maxTileZ];
		this.blendSaturation = new int[this.maxTileZ];
		this.blendLightness = new int[this.maxTileZ];
		this.blendLuminance = new int[this.maxTileZ];
		this.blendMagnitude = new int[this.maxTileZ];
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(II)I")
	public static int perlin(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(32) int local32 = perlin(arg0 + 45365, arg1 + 91923, 4) + (perlin(arg0 + 10294, arg1 + 37821, 2) - 128 >> 1) + (perlin(arg0, arg1, 1) - 128 >> 2) - 128;
		local32 = (int) ((double) local32 * 0.3D) + 35;
		if (local32 < 10) {
			local32 = 10;
		} else if (local32 > 60) {
			local32 = 60;
		}
		return local32;
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(III)I")
	private static int perlin(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(3) int local3 = arg0 / arg2;
		@Pc(9) int local9 = arg0 & arg2 - 1;
		@Pc(13) int local13 = arg1 / arg2;
		@Pc(19) int local19 = arg1 & arg2 - 1;
		@Pc(23) int local23 = smoothNoise(local3, local13);
		@Pc(29) int local29 = smoothNoise(local3 + 1, local13);
		@Pc(35) int local35 = smoothNoise(local3, local13 + 1);
		@Pc(43) int local43 = smoothNoise(local3 + 1, local13 + 1);
		@Pc(49) int local49 = interpolate(local23, local29, local9, arg2);
		@Pc(55) int local55 = interpolate(local35, local43, local9, arg2);
		return interpolate(local49, local55, local19, arg2);
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IIII)I")
	private static int interpolate(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(11) int local11 = 65536 - Draw3D.cos[arg2 * 1024 / arg3] >> 1;
		return (arg0 * (65536 - local11) >> 16) + (arg1 * local11 >> 16);
	}

	@OriginalMember(owner = "client!c", name = "b", descriptor = "(II)I")
	private static int smoothNoise(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(31) int local31 = noise(arg0 - 1, arg1 - 1) + noise(arg0 + 1, arg1 - 1) + noise(arg0 - 1, arg1 + 1) + noise(arg0 + 1, arg1 + 1);
		@Pc(55) int local55 = noise(arg0 - 1, arg1) + noise(arg0 + 1, arg1) + noise(arg0, arg1 - 1) + noise(arg0, arg1 + 1);
		@Pc(59) int local59 = noise(arg0, arg1);
		return local31 / 16 + local55 / 8 + local59 / 4;
	}

	@OriginalMember(owner = "client!c", name = "c", descriptor = "(II)I")
	private static int noise(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(5) int local5 = arg0 + arg1 * 57;
		@Pc(11) int local11 = local5 << 13 ^ local5;
		@Pc(25) int local25 = local11 * (local11 * local11 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
		return local25 >> 19 & 0xFF;
	}

	@OriginalMember(owner = "client!c", name = "d", descriptor = "(II)I")
	public static int mulHSL(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		if (arg0 == -1) {
			return 12345678;
		}
		arg1 = arg1 * (arg0 & 0x7F) / 128;
		if (arg1 < 2) {
			arg1 = 2;
		} else if (arg1 > 126) {
			arg1 = 126;
		}
		return (arg0 & 0xFF80) + arg1;
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(ILclient!ob;Lclient!ec;II[[[IIIIILclient!r;I)V")
	public static void addLoc(@OriginalArg(0) int arg0, @OriginalArg(1) LinkList arg1, @OriginalArg(2) CollisionMap arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int[][][] arg5, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) World3D arg10, @OriginalArg(11) int arg11) {
		@Pc(15) int local15 = arg5[arg11][arg0][arg3];
		@Pc(25) int local25 = arg5[arg11][arg0 + 1][arg3];
		@Pc(37) int local37 = arg5[arg11][arg0 + 1][arg3 + 1];
		@Pc(47) int local47 = arg5[arg11][arg0][arg3 + 1];
		@Pc(57) int local57 = local15 + local25 + local37 + local47 >> 2;
		@Pc(60) LocType local60 = LocType.get(arg8);
		@Pc(72) int local72 = arg0 + (arg3 << 7) + (arg8 << 14) + 1073741824;
		if (!local60.interactable) {
			local72 += Integer.MIN_VALUE;
		}
		@Pc(86) byte local86 = (byte) ((arg4 << 6) + arg9);
		@Pc(99) Model local99;
		if (arg9 == 22) {
			local99 = local60.getModel(22, arg4, local15, local25, local37, local47, -1);
			arg10.addGroundDecoration(local99, arg0, local72, arg3, arg7, local86, local57);
			if (local60.blockwalk && local60.interactable) {
				arg2.setBlocked(arg3, arg0);
			}
			if (local60.anim != -1) {
				arg1.pushBack(new LocEntity(true, arg8, arg7, 3, SeqType.instances[local60.anim], arg3, arg0));
			}
		} else {
			@Pc(174) int local174;
			if (arg9 == 10 || arg9 == 11) {
				local99 = local60.getModel(10, arg4, local15, local25, local37, local47, -1);
				if (local99 != null) {
					@Pc(161) int local161 = 0;
					if (arg9 == 11) {
						local161 += 256;
					}
					@Pc(177) int local177;
					if (arg4 == 1 || arg4 == 3) {
						local174 = local60.sizeZ;
						local177 = local60.sizeX;
					} else {
						local174 = local60.sizeX;
						local177 = local60.sizeZ;
					}
					arg10.addLoc(local57, arg7, null, local72, arg3, arg0, local174, local86, local99, local161, local177);
				}
				if (local60.blockwalk) {
					arg2.addLoc(arg4, local60.sizeZ, local60.sizeX, arg0, arg3, local60.blockrange);
				}
				if (local60.anim != -1) {
					arg1.pushBack(new LocEntity(true, arg8, arg7, 2, SeqType.instances[local60.anim], arg3, arg0));
				}
			} else if (arg9 >= 12) {
				local99 = local60.getModel(arg9, arg4, local15, local25, local37, local47, -1);
				arg10.addLoc(local57, arg7, null, local72, arg3, arg0, 1, local86, local99, 0, 1);
				if (local60.blockwalk) {
					arg2.addLoc(arg4, local60.sizeZ, local60.sizeX, arg0, arg3, local60.blockrange);
				}
				if (local60.anim != -1) {
					arg1.pushBack(new LocEntity(true, arg8, arg7, 2, SeqType.instances[local60.anim], arg3, arg0));
				}
			} else if (arg9 == 0) {
				local99 = local60.getModel(0, arg4, local15, local25, local37, local47, -1);
				arg10.addWall(0, local57, arg7, ROTATION_WALL_TYPE[arg4], local99, null, arg0, local72, arg3, local86);
				if (local60.blockwalk) {
					arg2.addWall(arg4, arg3, arg0, local60.blockrange, arg9);
				}
				if (local60.anim != -1) {
					arg1.pushBack(new LocEntity(true, arg8, arg7, 0, SeqType.instances[local60.anim], arg3, arg0));
				}
			} else if (arg9 == 1) {
				local99 = local60.getModel(1, arg4, local15, local25, local37, local47, -1);
				arg10.addWall(0, local57, arg7, ROTATION_WALL_CORNER_TYPE[arg4], local99, null, arg0, local72, arg3, local86);
				if (local60.blockwalk) {
					arg2.addWall(arg4, arg3, arg0, local60.blockrange, arg9);
				}
				if (local60.anim != -1) {
					arg1.pushBack(new LocEntity(true, arg8, arg7, 0, SeqType.instances[local60.anim], arg3, arg0));
				}
			} else {
				@Pc(430) int local430;
				@Pc(452) Model local452;
				if (arg9 == 2) {
					local430 = arg4 + 1 & 0x3;
					@Pc(442) Model local442 = local60.getModel(2, arg4 + 4, local15, local25, local37, local47, -1);
					local452 = local60.getModel(2, local430, local15, local25, local37, local47, -1);
					arg10.addWall(ROTATION_WALL_TYPE[local430], local57, arg7, ROTATION_WALL_TYPE[arg4], local442, local452, arg0, local72, arg3, local86);
					if (local60.blockwalk) {
						arg2.addWall(arg4, arg3, arg0, local60.blockrange, arg9);
					}
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 0, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 3) {
					local99 = local60.getModel(3, arg4, local15, local25, local37, local47, -1);
					arg10.addWall(0, local57, arg7, ROTATION_WALL_CORNER_TYPE[arg4], local99, null, arg0, local72, arg3, local86);
					if (local60.blockwalk) {
						arg2.addWall(arg4, arg3, arg0, local60.blockrange, arg9);
					}
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 0, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 9) {
					local99 = local60.getModel(arg9, arg4, local15, local25, local37, local47, -1);
					arg10.addLoc(local57, arg7, null, local72, arg3, arg0, 1, local86, local99, 0, 1);
					if (local60.blockwalk) {
						arg2.addLoc(arg4, local60.sizeZ, local60.sizeX, arg0, arg3, local60.blockrange);
					}
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 2, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 4) {
					local99 = local60.getModel(4, 0, local15, local25, local37, local47, -1);
					arg10.setWallDecoration(local57, arg3, 0, local72, arg4 * 512, ROTATION_WALL_TYPE[arg4], 0, arg0, local99, local86, arg7);
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 1, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 5) {
					local430 = 16;
					local174 = arg10.getWallBitset(arg7, arg0, arg3);
					if (local174 > 0) {
						local430 = LocType.get(local174 >> 14 & 0x7FFF).walloff;
					}
					local452 = local60.getModel(4, 0, local15, local25, local37, local47, -1);
					arg10.setWallDecoration(local57, arg3, WALL_DECORATION_ROTATION_FORWARD_Z[arg4] * local430, local72, arg4 * 512, ROTATION_WALL_TYPE[arg4], WALL_DECORATION_ROTATION_FORWARD_X[arg4] * local430, arg0, local452, local86, arg7);
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 1, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 6) {
					local99 = local60.getModel(4, 0, local15, local25, local37, local47, -1);
					arg10.setWallDecoration(local57, arg3, 0, local72, arg4, 256, 0, arg0, local99, local86, arg7);
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 1, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 7) {
					local99 = local60.getModel(4, 0, local15, local25, local37, local47, -1);
					arg10.setWallDecoration(local57, arg3, 0, local72, arg4, 512, 0, arg0, local99, local86, arg7);
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 1, SeqType.instances[local60.anim], arg3, arg0));
					}
				} else if (arg9 == 8) {
					local99 = local60.getModel(4, 0, local15, local25, local37, local47, -1);
					arg10.setWallDecoration(local57, arg3, 0, local72, arg4, 768, 0, arg0, local99, local86, arg7);
					if (local60.anim != -1) {
						arg1.pushBack(new LocEntity(true, arg8, arg7, 1, SeqType.instances[local60.anim], arg3, arg0));
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(IIIII)V")
	public void clearLandscape(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(3) byte local3 = 0;
		for (@Pc(11) int local11 = 0; local11 < FloType.count; local11++) {
			if (FloType.instances[local11].name.equalsIgnoreCase("water")) {
				local3 = (byte) (local11 + 1);
				break;
			}
		}
		for (@Pc(33) int local33 = arg1; local33 < arg1 + arg4; local33++) {
			for (@Pc(37) int local37 = arg0; local37 < arg0 + arg3; local37++) {
				if (local37 >= 0 && local37 < this.maxTileX && local33 >= 0 && local33 < this.maxTileZ) {
					this.levelTileOverlayIds[0][local37][local33] = local3;
					for (@Pc(62) int local62 = 0; local62 < 4; local62++) {
						this.levelHeightmap[local62][local37][local33] = 0;
						this.levelTileFlags[local62][local37][local33] = 0;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "([BIIIII)V")
	public void readLandscape(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(7) Packet local7 = new Packet(arg0);
		for (@Pc(20) int local20 = 0; local20 < 4; local20++) {
			for (@Pc(24) int local24 = 0; local24 < 64; local24++) {
				for (@Pc(28) int local28 = 0; local28 < 64; local28++) {
					@Pc(34) int local34 = local24 + arg4;
					@Pc(38) int local38 = local28 + arg3;
					@Pc(60) int local60;
					if (local34 >= 0 && local34 < 104 && local38 >= 0 && local38 < 104) {
						this.levelTileFlags[local20][local34][local38] = 0;
						while (true) {
							local60 = local7.g1();
							if (local60 == 0) {
								if (local20 == 0) {
									this.levelHeightmap[0][local34][local38] = -perlin(local34 + arg1 + 932731, local38 + 556238 + arg5) * 8;
								} else {
									this.levelHeightmap[local20][local34][local38] = this.levelHeightmap[local20 - 1][local34][local38] - 240;
								}
								break;
							}
							if (local60 == 1) {
								@Pc(116) int local116 = local7.g1();
								if (local116 == 1) {
									local116 = 0;
								}
								if (local20 == 0) {
									this.levelHeightmap[0][local34][local38] = -local116 * 8;
								} else {
									this.levelHeightmap[local20][local34][local38] = this.levelHeightmap[local20 - 1][local34][local38] - local116 * 8;
								}
								break;
							}
							if (local60 <= 49) {
								this.levelTileOverlayIds[local20][local34][local38] = local7.g1b();
								this.levelTileOverlayShape[local20][local34][local38] = (byte) ((local60 - 2) / 4);
								this.levelTileOverlayRotation[local20][local34][local38] = (byte) (local60 - 2 & 0x3);
							} else if (local60 <= 81) {
								this.levelTileFlags[local20][local34][local38] = (byte) (local60 - 49);
							} else {
								this.levelTileUnderlayIds[local20][local34][local38] = (byte) (local60 - 81);
							}
						}
					} else {
						while (true) {
							local60 = local7.g1();
							if (local60 == 0) {
								break;
							}
							if (local60 == 1) {
								local7.g1();
								break;
							}
							if (local60 <= 49) {
								local7.g1();
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "([BLclient!r;[Lclient!ec;Lclient!ob;ZII)V")
	public void readLocs(@OriginalArg(0) byte[] arg0, @OriginalArg(1) World3D arg1, @OriginalArg(2) CollisionMap[] arg2, @OriginalArg(3) LinkList arg3, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		@Pc(7) Packet local7 = new Packet(arg0);
		@Pc(19) int local19 = -1;
		while (true) {
			@Pc(22) int local22 = local7.gsmarts();
			if (local22 == 0) {
				return;
			}
			local19 += local22;
			@Pc(30) int local30 = 0;
			while (true) {
				@Pc(33) int local33 = local7.gsmarts();
				if (local33 == 0) {
					break;
				}
				local30 += local33 - 1;
				@Pc(45) int local45 = local30 & 0x3F;
				@Pc(51) int local51 = local30 >> 6 & 0x3F;
				@Pc(55) int local55 = local30 >> 12;
				@Pc(58) int local58 = local7.g1();
				@Pc(62) int local62 = local58 >> 2;
				@Pc(66) int local66 = local58 & 0x3;
				@Pc(70) int local70 = local51 + arg6;
				@Pc(74) int local74 = local45 + arg5;
				if (local70 > 0 && local74 > 0 && local70 < 103 && local74 < 103) {
					@Pc(86) int local86 = local55;
					if ((this.levelTileFlags[1][local70][local74] & 0x2) == 2) {
						local86 = local55 - 1;
					}
					@Pc(101) CollisionMap local101 = null;
					if (local86 >= 0) {
						local101 = arg2[local86];
					}
					this.addLoc(local101, local55, local74, local66, local62, arg1, arg3, local19, local70);
				}
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!ec;ZIIIILclient!r;Lclient!ob;II)V")
	private void addLoc(@OriginalArg(0) CollisionMap arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) World3D arg6, @OriginalArg(7) LinkList arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9) {
		if (lowMemory) {
			if ((this.levelTileFlags[arg2][arg9][arg3] & 0x10) != 0) {
				return;
			}
			if (this.getDrawLevel(arg2, arg9, arg3) != levelBuilt) {
				return;
			}
		}
		@Pc(36) int local36 = this.levelHeightmap[arg2][arg9][arg3];
		@Pc(47) int local47 = this.levelHeightmap[arg2][arg9 + 1][arg3];
		@Pc(60) int local60 = this.levelHeightmap[arg2][arg9 + 1][arg3 + 1];
		@Pc(71) int local71 = this.levelHeightmap[arg2][arg9][arg3 + 1];
		@Pc(81) int local81 = local36 + local47 + local60 + local71 >> 2;
		@Pc(84) LocType local84 = LocType.get(arg8);
		@Pc(96) int local96 = arg9 + (arg3 << 7) + (arg8 << 14) + 1073741824;
		if (!local84.interactable) {
			local96 += Integer.MIN_VALUE;
		}
		@Pc(110) byte local110 = (byte) ((arg4 << 6) + arg5);
		@Pc(132) Model local132;
		if (arg5 != 22) {
			@Pc(209) int local209;
			if (arg5 == 10 || arg5 == 11) {
				local132 = local84.getModel(10, arg4, local36, local47, local60, local71, -1);
				if (local132 != null) {
					@Pc(196) int local196 = 0;
					if (arg5 == 11) {
						local196 += 256;
					}
					@Pc(212) int local212;
					if (arg4 == 1 || arg4 == 3) {
						local209 = local84.sizeZ;
						local212 = local84.sizeX;
					} else {
						local209 = local84.sizeX;
						local212 = local84.sizeZ;
					}
					if (arg6.addLoc(local81, arg2, null, local96, arg3, arg9, local209, local110, local132, local196, local212) && local84.active) {
						for (@Pc(240) int local240 = 0; local240 <= local209; local240++) {
							for (@Pc(244) int local244 = 0; local244 <= local212; local244++) {
								@Pc(251) int local251 = local132.radius / 4;
								if (local251 > 30) {
									local251 = 30;
								}
								if (local251 > this.levelShademap[arg2][arg9 + local240][arg3 + local244]) {
									this.levelShademap[arg2][arg9 + local240][arg3 + local244] = (byte) local251;
								}
							}
						}
					}
				}
				if (local84.blockwalk && arg0 != null) {
					arg0.addLoc(arg4, local84.sizeZ, local84.sizeX, arg9, arg3, local84.blockrange);
				}
				if (local84.anim != -1) {
					arg7.pushBack(new LocEntity(true, arg8, arg2, 2, SeqType.instances[local84.anim], arg3, arg9));
				}
			} else if (arg5 >= 12) {
				local132 = local84.getModel(arg5, arg4, local36, local47, local60, local71, -1);
				arg6.addLoc(local81, arg2, null, local96, arg3, arg9, 1, local110, local132, 0, 1);
				if (arg5 >= 12 && arg5 <= 17 && arg5 != 13 && arg2 > 0) {
					this.levelOccludemap[arg2][arg9][arg3] |= 0x924;
				}
				if (local84.blockwalk && arg0 != null) {
					arg0.addLoc(arg4, local84.sizeZ, local84.sizeX, arg9, arg3, local84.blockrange);
				}
				if (local84.anim != -1) {
					arg7.pushBack(new LocEntity(true, arg8, arg2, 2, SeqType.instances[local84.anim], arg3, arg9));
				}
			} else if (arg5 == 0) {
				local132 = local84.getModel(0, arg4, local36, local47, local60, local71, -1);
				arg6.addWall(0, local81, arg2, ROTATION_WALL_TYPE[arg4], local132, null, arg9, local96, arg3, local110);
				if (arg4 == 0) {
					if (local84.active) {
						this.levelShademap[arg2][arg9][arg3] = 50;
						this.levelShademap[arg2][arg9][arg3 + 1] = 50;
					}
					if (local84.occlude) {
						this.levelOccludemap[arg2][arg9][arg3] |= 0x249;
					}
				} else if (arg4 == 1) {
					if (local84.active) {
						this.levelShademap[arg2][arg9][arg3 + 1] = 50;
						this.levelShademap[arg2][arg9 + 1][arg3 + 1] = 50;
					}
					if (local84.occlude) {
						this.levelOccludemap[arg2][arg9][arg3 + 1] |= 0x492;
					}
				} else if (arg4 == 2) {
					if (local84.active) {
						this.levelShademap[arg2][arg9 + 1][arg3] = 50;
						this.levelShademap[arg2][arg9 + 1][arg3 + 1] = 50;
					}
					if (local84.occlude) {
						this.levelOccludemap[arg2][arg9 + 1][arg3] |= 0x249;
					}
				} else if (arg4 == 3) {
					if (local84.active) {
						this.levelShademap[arg2][arg9][arg3] = 50;
						this.levelShademap[arg2][arg9 + 1][arg3] = 50;
					}
					if (local84.occlude) {
						this.levelOccludemap[arg2][arg9][arg3] |= 0x492;
					}
				}
				if (local84.blockwalk && arg0 != null) {
					arg0.addWall(arg4, arg3, arg9, local84.blockrange, arg5);
				}
				if (local84.anim != -1) {
					arg7.pushBack(new LocEntity(true, arg8, arg2, 0, SeqType.instances[local84.anim], arg3, arg9));
				}
				if (local84.walloff != 16) {
					arg6.setWallDecorationOffset(arg2, arg3, arg9, local84.walloff);
				}
			} else if (arg5 == 1) {
				local132 = local84.getModel(1, arg4, local36, local47, local60, local71, -1);
				arg6.addWall(0, local81, arg2, ROTATION_WALL_CORNER_TYPE[arg4], local132, null, arg9, local96, arg3, local110);
				if (local84.active) {
					if (arg4 == 0) {
						this.levelShademap[arg2][arg9][arg3 + 1] = 50;
					} else if (arg4 == 1) {
						this.levelShademap[arg2][arg9 + 1][arg3 + 1] = 50;
					} else if (arg4 == 2) {
						this.levelShademap[arg2][arg9 + 1][arg3] = 50;
					} else if (arg4 == 3) {
						this.levelShademap[arg2][arg9][arg3] = 50;
					}
				}
				if (local84.blockwalk && arg0 != null) {
					arg0.addWall(arg4, arg3, arg9, local84.blockrange, arg5);
				}
				if (local84.anim != -1) {
					arg7.pushBack(new LocEntity(true, arg8, arg2, 0, SeqType.instances[local84.anim], arg3, arg9));
				}
			} else {
				@Pc(810) int local810;
				@Pc(832) Model local832;
				if (arg5 == 2) {
					local810 = arg4 + 1 & 0x3;
					@Pc(822) Model local822 = local84.getModel(2, arg4 + 4, local36, local47, local60, local71, -1);
					local832 = local84.getModel(2, local810, local36, local47, local60, local71, -1);
					arg6.addWall(ROTATION_WALL_TYPE[local810], local81, arg2, ROTATION_WALL_TYPE[arg4], local822, local832, arg9, local96, arg3, local110);
					if (local84.occlude) {
						if (arg4 == 0) {
							this.levelOccludemap[arg2][arg9][arg3] |= 0x249;
							this.levelOccludemap[arg2][arg9][arg3 + 1] |= 0x492;
						} else if (arg4 == 1) {
							this.levelOccludemap[arg2][arg9][arg3 + 1] |= 0x492;
							this.levelOccludemap[arg2][arg9 + 1][arg3] |= 0x249;
						} else if (arg4 == 2) {
							this.levelOccludemap[arg2][arg9 + 1][arg3] |= 0x249;
							this.levelOccludemap[arg2][arg9][arg3] |= 0x492;
						} else if (arg4 == 3) {
							this.levelOccludemap[arg2][arg9][arg3] |= 0x492;
							this.levelOccludemap[arg2][arg9][arg3] |= 0x249;
						}
					}
					if (local84.blockwalk && arg0 != null) {
						arg0.addWall(arg4, arg3, arg9, local84.blockrange, arg5);
					}
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 0, SeqType.instances[local84.anim], arg3, arg9));
					}
					if (local84.walloff != 16) {
						arg6.setWallDecorationOffset(arg2, arg3, arg9, local84.walloff);
					}
				} else if (arg5 == 3) {
					local132 = local84.getModel(3, arg4, local36, local47, local60, local71, -1);
					arg6.addWall(0, local81, arg2, ROTATION_WALL_CORNER_TYPE[arg4], local132, null, arg9, local96, arg3, local110);
					if (local84.active) {
						if (arg4 == 0) {
							this.levelShademap[arg2][arg9][arg3 + 1] = 50;
						} else if (arg4 == 1) {
							this.levelShademap[arg2][arg9 + 1][arg3 + 1] = 50;
						} else if (arg4 == 2) {
							this.levelShademap[arg2][arg9 + 1][arg3] = 50;
						} else if (arg4 == 3) {
							this.levelShademap[arg2][arg9][arg3] = 50;
						}
					}
					if (local84.blockwalk && arg0 != null) {
						arg0.addWall(arg4, arg3, arg9, local84.blockrange, arg5);
					}
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 0, SeqType.instances[local84.anim], arg3, arg9));
					}
				} else if (arg5 == 9) {
					local132 = local84.getModel(arg5, arg4, local36, local47, local60, local71, -1);
					arg6.addLoc(local81, arg2, null, local96, arg3, arg9, 1, local110, local132, 0, 1);
					if (local84.blockwalk && arg0 != null) {
						arg0.addLoc(arg4, local84.sizeZ, local84.sizeX, arg9, arg3, local84.blockrange);
					}
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 2, SeqType.instances[local84.anim], arg3, arg9));
					}
				} else if (arg5 == 4) {
					local132 = local84.getModel(4, 0, local36, local47, local60, local71, -1);
					arg6.setWallDecoration(local81, arg3, 0, local96, arg4 * 512, ROTATION_WALL_TYPE[arg4], 0, arg9, local132, local110, arg2);
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 1, SeqType.instances[local84.anim], arg3, arg9));
					}
				} else if (arg5 == 5) {
					local810 = 16;
					local209 = arg6.getWallBitset(arg2, arg9, arg3);
					if (local209 > 0) {
						local810 = LocType.get(local209 >> 14 & 0x7FFF).walloff;
					}
					local832 = local84.getModel(4, 0, local36, local47, local60, local71, -1);
					arg6.setWallDecoration(local81, arg3, WALL_DECORATION_ROTATION_FORWARD_Z[arg4] * local810, local96, arg4 * 512, ROTATION_WALL_TYPE[arg4], WALL_DECORATION_ROTATION_FORWARD_X[arg4] * local810, arg9, local832, local110, arg2);
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 1, SeqType.instances[local84.anim], arg3, arg9));
					}
				} else if (arg5 == 6) {
					local132 = local84.getModel(4, 0, local36, local47, local60, local71, -1);
					arg6.setWallDecoration(local81, arg3, 0, local96, arg4, 256, 0, arg9, local132, local110, arg2);
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 1, SeqType.instances[local84.anim], arg3, arg9));
					}
				} else if (arg5 == 7) {
					local132 = local84.getModel(4, 0, local36, local47, local60, local71, -1);
					arg6.setWallDecoration(local81, arg3, 0, local96, arg4, 512, 0, arg9, local132, local110, arg2);
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 1, SeqType.instances[local84.anim], arg3, arg9));
					}
				} else if (arg5 == 8) {
					local132 = local84.getModel(4, 0, local36, local47, local60, local71, -1);
					arg6.setWallDecoration(local81, arg3, 0, local96, arg4, 768, 0, arg9, local132, local110, arg2);
					if (local84.anim != -1) {
						arg7.pushBack(new LocEntity(true, arg8, arg2, 1, SeqType.instances[local84.anim], arg3, arg9));
					}
				}
			}
		} else if (!lowMemory || local84.interactable || local84.forcedecor) {
			local132 = local84.getModel(22, arg4, local36, local47, local60, local71, -1);
			arg6.addGroundDecoration(local132, arg9, local96, arg3, arg2, local110, local81);
			if (local84.blockwalk && local84.interactable && arg0 != null) {
				arg0.setBlocked(arg3, arg9);
			}
			if (local84.anim != -1) {
				arg7.pushBack(new LocEntity(true, arg8, arg2, 3, SeqType.instances[local84.anim], arg3, arg9));
			}
		}
	}

	@OriginalMember(owner = "client!c", name = "a", descriptor = "(Lclient!r;I[Lclient!ec;)V")
	public void build(@OriginalArg(0) World3D arg0, @OriginalArg(1) int arg1, @OriginalArg(2) CollisionMap[] arg2) {
		@Pc(7) int local7;
		@Pc(11) int local11;
		@Pc(27) int local27;
		for (@Pc(3) int local3 = 0; local3 < 4; local3++) {
			for (local7 = 0; local7 < 104; local7++) {
				for (local11 = 0; local11 < 104; local11++) {
					if ((this.levelTileFlags[local3][local7][local11] & 0x1) == 1) {
						local27 = local3;
						if ((this.levelTileFlags[1][local7][local11] & 0x2) == 2) {
							local27 = local3 - 1;
						}
						if (local27 >= 0) {
							arg2[local27].setBlocked(local11, local7);
						}
					}
				}
			}
		}
		randomHueOffset += (int) (Math.random() * 5.0D) - 2;
		if (randomHueOffset < -8) {
			randomHueOffset = -8;
		}
		if (randomHueOffset > 8) {
			randomHueOffset = 8;
		}
		randomLightnessOffset += (int) (Math.random() * 5.0D) - 2;
		if (randomLightnessOffset < -16) {
			randomLightnessOffset = -16;
		}
		if (randomLightnessOffset > 16) {
			randomLightnessOffset = 16;
		}
		@Pc(133) int tileZ;
		@Pc(139) int tileX;
		@Pc(141) int local141;
		@Pc(145) int local145;
		@Pc(169) int local169;
		@Pc(191) int local191;
		@Pc(204) int local204;
		@Pc(210) int local210;
		@Pc(214) int local214;
		@Pc(220) int local220;
		@Pc(236) int local236;
		@Pc(284) int local284;
		for (local7 = 0; local7 < 4; local7++) {
			@Pc(108) int[][] local108 = this.levelShademap[local7];
			@Pc(110) byte local110 = 96;
			@Pc(112) short local112 = 768;
			@Pc(114) byte local114 = -50;
			@Pc(116) byte local116 = -10;
			@Pc(118) byte local118 = -50;
			tileZ = (int) Math.sqrt((double) (local114 * local114 + local116 * local116 + local118 * local118));
			tileX = local112 * tileZ >> 8;
			for (local141 = 1; local141 < this.maxTileZ - 1; local141++) {
				for (local145 = 1; local145 < this.maxTileX - 1; local145++) {
					local169 = this.levelHeightmap[local7][local145 + 1][local141] - this.levelHeightmap[local7][local145 - 1][local141];
					local191 = this.levelHeightmap[local7][local145][local141 + 1] - this.levelHeightmap[local7][local145][local141 - 1];
					local204 = (int) Math.sqrt((double) (local169 * local169 + local191 * local191 + 65536));
					local210 = (local169 << 8) / local204;
					local214 = 65536 / local204;
					local220 = (local191 << 8) / local204;
					local236 = local110 + (local114 * local210 + local116 * local214 + local118 * local220) / tileX;
					local284 = (local108[local145 - 1][local141] >> 2) + (local108[local145 + 1][local141] >> 3) + (local108[local145][local141 - 1] >> 2) + (local108[local145][local141 + 1] >> 3) + (local108[local145][local141] >> 1);
					this.levelLightmap[local145][local141] = local236 - local284;
				}
			}
			for (local145 = 0; local145 < this.maxTileZ; local145++) {
				this.blendChroma[local145] = 0;
				this.blendSaturation[local145] = 0;
				this.blendLightness[local145] = 0;
				this.blendLuminance[local145] = 0;
				this.blendMagnitude[local145] = 0;
			}
			for (local169 = -5; local169 < this.maxTileX + 5; local169++) {
				for (local191 = 0; local191 < this.maxTileZ; local191++) {
					local204 = local169 + 5;
					@Pc(419) int local419;
					if (local204 >= 0 && local204 < this.maxTileX) {
						local210 = this.levelTileUnderlayIds[local7][local204][local191] & 0xFF;
						if (local210 > 0) {
							@Pc(378) FloType local378 = FloType.instances[local210 - 1];
							this.blendChroma[local191] += local378.chroma;
							this.blendSaturation[local191] += local378.saturation;
							this.blendLightness[local191] += local378.lightness;
							this.blendLuminance[local191] += local378.luminance;
							local419 = this.blendMagnitude[local191]++;
						}
					}
					local210 = local169 - 5;
					if (local210 >= 0 && local210 < this.maxTileX) {
						local214 = this.levelTileUnderlayIds[local7][local210][local191] & 0xFF;
						if (local214 > 0) {
							@Pc(451) FloType local451 = FloType.instances[local214 - 1];
							this.blendChroma[local191] -= local451.chroma;
							this.blendSaturation[local191] -= local451.saturation;
							this.blendLightness[local191] -= local451.lightness;
							this.blendLuminance[local191] -= local451.luminance;
							local419 = this.blendMagnitude[local191]--;
						}
					}
				}
				if (local169 >= 1 && local169 < this.maxTileX - 1) {
					local204 = 0;
					local210 = 0;
					local214 = 0;
					local220 = 0;
					local236 = 0;
					for (local284 = -5; local284 < this.maxTileZ + 5; local284++) {
						@Pc(527) int local527 = local284 + 5;
						if (local527 >= 0 && local527 < this.maxTileZ) {
							local204 += this.blendChroma[local527];
							local210 += this.blendSaturation[local527];
							local214 += this.blendLightness[local527];
							local220 += this.blendLuminance[local527];
							local236 += this.blendMagnitude[local527];
						}
						@Pc(572) int local572 = local284 - 5;
						if (local572 >= 0 && local572 < this.maxTileZ) {
							local204 -= this.blendChroma[local572];
							local210 -= this.blendSaturation[local572];
							local214 -= this.blendLightness[local572];
							local220 -= this.blendLuminance[local572];
							local236 -= this.blendMagnitude[local572];
						}
						if (local284 >= 1 && local284 < this.maxTileZ - 1 && (!lowMemory || (this.levelTileFlags[local7][local169][local284] & 0x10) == 0 && this.getDrawLevel(local7, local169, local284) == levelBuilt)) {
							@Pc(655) int local655 = this.levelTileUnderlayIds[local7][local169][local284] & 0xFF;
							@Pc(666) int local666 = this.levelTileOverlayIds[local7][local169][local284] & 0xFF;
							if (local655 > 0 || local666 > 0) {
								@Pc(679) int local679 = this.levelHeightmap[local7][local169][local284];
								@Pc(690) int local690 = this.levelHeightmap[local7][local169 + 1][local284];
								@Pc(703) int local703 = this.levelHeightmap[local7][local169 + 1][local284 + 1];
								@Pc(714) int local714 = this.levelHeightmap[local7][local169][local284 + 1];
								@Pc(721) int local721 = this.levelLightmap[local169][local284];
								@Pc(730) int local730 = this.levelLightmap[local169 + 1][local284];
								@Pc(741) int local741 = this.levelLightmap[local169 + 1][local284 + 1];
								@Pc(750) int local750 = this.levelLightmap[local169][local284 + 1];
								@Pc(752) int local752 = -1;
								@Pc(754) int local754 = -1;
								@Pc(762) int local762;
								@Pc(766) int local766;
								if (local655 > 0) {
									local762 = local204 * 256 / local220;
									local766 = local210 / local236;
									@Pc(770) int local770 = local214 / local236;
									local752 = this.hsl24to16(local762, local766, local770);
									@Pc(782) int local782 = local762 + randomHueOffset & 0xFF;
									local770 += randomLightnessOffset;
									if (local770 < 0) {
										local770 = 0;
									} else if (local770 > 255) {
										local770 = 255;
									}
									local754 = this.hsl24to16(local782, local766, local770);
								}
								if (local7 > 0) {
									@Pc(807) boolean local807 = true;
									if (local655 == 0 && this.levelTileOverlayShape[local7][local169][local284] != 0) {
										local807 = false;
									}
									if (local666 > 0 && !FloType.instances[local666 - 1].occludes) {
										local807 = false;
									}
									if (local807 && local679 == local690 && local679 == local703 && local679 == local714) {
										this.levelOccludemap[local7][local169][local284] |= 0x924;
									}
								}
								local762 = 0;
								if (local752 != -1) {
									local762 = Draw3D.palette[mulHSL(local754, 96)];
								}
								if (local666 == 0) {
									arg0.setTile(local7, local169, local284, 0, 0, -1, local679, local690, local703, local714, mulHSL(local752, local721), mulHSL(local752, local730), mulHSL(local752, local741), mulHSL(local752, local750), 0, 0, 0, 0, local762, 0);
								} else {
									local766 = this.levelTileOverlayShape[local7][local169][local284] + 1;
									@Pc(919) int local919 = this.levelTileOverlayRotation[local7][local169][local284] & 0xFF;
									@Pc(925) FloType local925 = FloType.instances[local666 - 1];
									@Pc(928) int local928 = local925.texture;
									@Pc(936) int local936;
									@Pc(934) int local934;
									if (local928 >= 0) {
										local934 = Draw3D.getAverageTextureRGB(local928);
										local936 = -1;
									} else if (local925.rgb == 16711935) {
										local934 = 0;
										local936 = -2;
										local928 = -1;
									} else {
										local936 = this.hsl24to16(local925.hue, local925.saturation, local925.lightness);
										local934 = Draw3D.palette[this.adjustLightness(local925.hsl, 96)];
									}
									arg0.setTile(local7, local169, local284, local766, local919, local928, local679, local690, local703, local714, mulHSL(local752, local721), mulHSL(local752, local730), mulHSL(local752, local741), mulHSL(local752, local750), this.adjustLightness(local936, local721), this.adjustLightness(local936, local730), this.adjustLightness(local936, local741), this.adjustLightness(local936, local750), local762, local934);
								}
							}
						}
					}
				}
			}
			for (local191 = 1; local191 < this.maxTileZ - 1; local191++) {
				for (local204 = 1; local204 < this.maxTileX - 1; local204++) {
					arg0.setDrawLevel(local7, local204, local191, this.getDrawLevel(local7, local204, local191));
				}
			}
		}
		while (arg1 >= 0) {
			for (local11 = 1; local11 > 0; local11++) {
			}
		}
		if (!fullbright) {
			arg0.buildModels(-10, 64, -50, 768, -50);
		}
		for (local11 = 0; local11 < this.maxTileX; local11++) {
			for (local27 = 0; local27 < this.maxTileZ; local27++) {
				if ((this.levelTileFlags[1][local11][local27] & 0x2) == 2) {
					arg0.setBridge(local27, local11);
				}
			}
		}
		if (!fullbright) {
			int wall0 = 1;
			@Pc(1123) int wall1 = 2;
			@Pc(1125) int wall2 = 4;

			for (@Pc(1127) int topLevel = 0; topLevel < 4; topLevel++) {
				if (topLevel > 0) {
					wall0 <<= 0x3;
					wall1 <<= 0x3;
					wall2 <<= 0x3;
				}

				for (@Pc(1145) int level = 0; level <= topLevel; level++) {
					for (tileZ = 0; tileZ <= this.maxTileZ; tileZ++) {
						for (tileX = 0; tileX <= this.maxTileX; tileX++) {
							@Pc(1284) short local1284;

							if ((this.levelOccludemap[level][tileX][tileZ] & wall0) != 0) {
								local141 = tileZ;
								local145 = tileZ;
								local169 = level;
								local191 = level;
								while (local141 > 0 && (this.levelOccludemap[level][tileX][local141 - 1] & wall0) != 0) {
									local141--;
								}
								while (local145 < this.maxTileZ && (this.levelOccludemap[level][tileX][local145 + 1] & wall0) != 0) {
									local145++;
								}
								label337: while (local169 > 0) {
									for (local204 = local141; local204 <= local145; local204++) {
										if ((this.levelOccludemap[local169 - 1][tileX][local204] & wall0) == 0) {
											break label337;
										}
									}
									local169--;
								}
								label326: while (local191 < topLevel) {
									for (local204 = local141; local204 <= local145; local204++) {
										if ((this.levelOccludemap[local191 + 1][tileX][local204] & wall0) == 0) {
											break label326;
										}
									}
									local191++;
								}
								local204 = (local191 + 1 - local169) * (local145 + 1 - local141);
								if (local204 >= OCCLUDER_THRESHOLD) {
									local1284 = 240;
									local214 = this.levelHeightmap[local191][tileX][local141] - local1284;
									local220 = this.levelHeightmap[local169][tileX][local141];
									World3D.addOccluder(local145 * 128 + 128, tileX * 128, local220, 1, tileX * 128, topLevel, local214, local141 * 128);
									for (local236 = local169; local236 <= local191; local236++) {
										for (local284 = local141; local284 <= local145; local284++) {
											this.levelOccludemap[local236][tileX][local284] &= ~wall0;
										}
									}
								}
							}
							if ((this.levelOccludemap[level][tileX][tileZ] & wall1) != 0) {
								local141 = tileX;
								local145 = tileX;
								local169 = level;
								local191 = level;
								while (local141 > 0 && (this.levelOccludemap[level][local141 - 1][tileZ] & wall1) != 0) {
									local141--;
								}
								while (local145 < this.maxTileX && (this.levelOccludemap[level][local145 + 1][tileZ] & wall1) != 0) {
									local145++;
								}
								label390: while (local169 > 0) {
									for (local204 = local141; local204 <= local145; local204++) {
										if ((this.levelOccludemap[local169 - 1][local204][tileZ] & wall1) == 0) {
											break label390;
										}
									}
									local169--;
								}
								label379: while (local191 < topLevel) {
									for (local204 = local141; local204 <= local145; local204++) {
										if ((this.levelOccludemap[local191 + 1][local204][tileZ] & wall1) == 0) {
											break label379;
										}
									}
									local191++;
								}
								local204 = (local191 + 1 - local169) * (local145 + 1 - local141);
								if (local204 >= OCCLUDER_THRESHOLD) {
									local1284 = 240;
									local214 = this.levelHeightmap[local191][local141][tileZ] - local1284;
									local220 = this.levelHeightmap[local169][local141][tileZ];
									World3D.addOccluder(tileZ * 128, local141 * 128, local220, 2, local145 * 128 + 128, topLevel, local214, tileZ * 128);
									for (local236 = local169; local236 <= local191; local236++) {
										for (local284 = local141; local284 <= local145; local284++) {
											this.levelOccludemap[local236][local284][tileZ] &= ~wall1;
										}
									}
								}
							}
							if ((this.levelOccludemap[level][tileX][tileZ] & wall2) != 0) {
								local141 = tileX;
								local145 = tileX;
								local169 = tileZ;
								local191 = tileZ;
								while (local169 > 0 && (this.levelOccludemap[level][tileX][local169 - 1] & wall2) != 0) {
									local169--;
								}
								while (local191 < this.maxTileZ && (this.levelOccludemap[level][tileX][local191 + 1] & wall2) != 0) {
									local191++;
								}
								label443: while (local141 > 0) {
									for (local204 = local169; local204 <= local191; local204++) {
										if ((this.levelOccludemap[level][local141 - 1][local204] & wall2) == 0) {
											break label443;
										}
									}
									local141--;
								}
								label432: while (local145 < this.maxTileX) {
									for (local204 = local169; local204 <= local191; local204++) {
										if ((this.levelOccludemap[level][local145 + 1][local204] & wall2) == 0) {
											break label432;
										}
									}
									local145++;
								}
								if ((local145 + 1 - local141) * (local191 + 1 - local169) >= 4) {
									local204 = this.levelHeightmap[level][local141][local169];
									World3D.addOccluder(local191 * 128 + 128, local141 * 128, local204, 4, local145 * 128 + 128, topLevel, local204, local169 * 128);
									for (local210 = local141; local210 <= local145; local210++) {
										for (local214 = local169; local214 <= local191; local214++) {
											this.levelOccludemap[level][local210][local214] &= ~wall2;
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
	private int getDrawLevel(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		if ((this.levelTileFlags[arg0][arg2][arg3] & 0x8) == 0) {
			return arg0 <= 0 || (this.levelTileFlags[1][arg2][arg3] & 0x2) == 0 ? arg0 : arg0 - 1;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!c", name = "e", descriptor = "(II)I")
	private int adjustLightness(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		if (arg0 == -2) {
			return 12345678;
		} else if (arg0 == -1) {
			if (arg1 < 0) {
				arg1 = 0;
			} else if (arg1 > 127) {
				arg1 = 127;
			}
			return 127 - arg1;
		} else {
			arg1 = arg1 * (arg0 & 0x7F) / 128;
			if (arg1 < 2) {
				arg1 = 2;
			} else if (arg1 > 126) {
				arg1 = 126;
			}
			return (arg0 & 0xFF80) + arg1;
		}
	}

	@OriginalMember(owner = "client!c", name = "b", descriptor = "(III)I")
	private int hsl24to16(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if (arg2 > 179) {
			arg1 /= 2;
		}
		if (arg2 > 192) {
			arg1 /= 2;
		}
		if (arg2 > 217) {
			arg1 /= 2;
		}
		if (arg2 > 243) {
			arg1 /= 2;
		}
		return (arg0 / 4 << 10) + (arg1 / 32 << 7) + arg2 / 2;
	}
}
