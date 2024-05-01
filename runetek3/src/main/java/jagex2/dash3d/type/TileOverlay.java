package jagex2.dash3d.type;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!i")
public class TileOverlay {

	@OriginalMember(owner = "client!i", name = "a", descriptor = "[I")
	public final int[] vertexX;

	@OriginalMember(owner = "client!i", name = "b", descriptor = "[I")
	public final int[] vertexY;

	@OriginalMember(owner = "client!i", name = "c", descriptor = "[I")
	public final int[] vertexZ;

	@OriginalMember(owner = "client!i", name = "d", descriptor = "[I")
	public final int[] triangleColorA;

	@OriginalMember(owner = "client!i", name = "e", descriptor = "[I")
	public final int[] triangleColorB;

	@OriginalMember(owner = "client!i", name = "f", descriptor = "[I")
	public final int[] triangleColorC;

	@OriginalMember(owner = "client!i", name = "g", descriptor = "[I")
	public final int[] triangleVertexA;

	@OriginalMember(owner = "client!i", name = "h", descriptor = "[I")
	public final int[] triangleVertexB;

	@OriginalMember(owner = "client!i", name = "i", descriptor = "[I")
	public final int[] triangleVertexC;

	@OriginalMember(owner = "client!i", name = "j", descriptor = "[I")
	public int[] triangleTextureIds;

	@OriginalMember(owner = "client!i", name = "k", descriptor = "Z")
	public boolean flat = true;

	@OriginalMember(owner = "client!i", name = "l", descriptor = "I")
	public final int shape;

	@OriginalMember(owner = "client!i", name = "m", descriptor = "I")
	public final int rotation;

	@OriginalMember(owner = "client!i", name = "n", descriptor = "I")
	public final int backgroundRgb;

	@OriginalMember(owner = "client!i", name = "o", descriptor = "I")
	public final int foregroundRgb;

	@OriginalMember(owner = "client!i", name = "p", descriptor = "[I")
	public static final int[] tmpScreenX = new int[6];

	@OriginalMember(owner = "client!i", name = "q", descriptor = "[I")
	public static final int[] tmpScreenY = new int[6];

	@OriginalMember(owner = "client!i", name = "r", descriptor = "[I")
	public static final int[] tmpViewspaceX = new int[6];

	@OriginalMember(owner = "client!i", name = "s", descriptor = "[I")
	public static final int[] tmpViewspaceY = new int[6];

	@OriginalMember(owner = "client!i", name = "t", descriptor = "[I")
	public static final int[] tmpViewspaceZ = new int[6];

	@OriginalMember(owner = "client!i", name = "x", descriptor = "[[I")
	public static final int[][] SHAPE_POINTS = new int[][] {
		{ 1, 3, 5, 7 },
		{ 1, 3, 5, 7 }, // PLAIN_SHAPE
		{ 1, 3, 5, 7 }, // DIAGONAL_SHAPE
		{ 1, 3, 5, 7, 6 }, // LEFT_SEMI_DIAGONAL_SMALL_SHAPE
		{ 1, 3, 5, 7, 6 }, // RIGHT_SEMI_DIAGONAL_SMALL_SHAPE
		{ 1, 3, 5, 7, 6 }, // LEFT_SEMI_DIAGONAL_BIG_SHAPE
		{ 1, 3, 5, 7, 6 }, // RIGHT_SEMI_DIAGONAL_BIG_SHAPE
		{ 1, 3, 5, 7, 2, 6 }, // HALF_SQUARE_SHAPE
		{ 1, 3, 5, 7, 2, 8 }, // CORNER_SMALL_SHAPE
		{ 1, 3, 5, 7, 2, 8 }, // CORNER_BIG_SHAPE
		{ 1, 3, 5, 7, 11, 12 }, // FAN_SMALL_SHAPE
		{ 1, 3, 5, 7, 11, 12 }, // FAN_BIG_SHAPE
		{ 1, 3, 5, 7, 13, 14 } // TRAPEZIUM_SHAPE
	};

	@OriginalMember(owner = "client!i", name = "y", descriptor = "[[I")
	public static final int[][] SHAPE_PATHS = new int[][] {
		{ 0, 1, 2, 3, 0, 0, 1, 3 },
		{ 1, 1, 2, 3, 1, 0, 1, 3 }, // PLAIN_SHAPE
		{ 0, 1, 2, 3, 1, 0, 1, 3 }, // DIAGONAL_SHAPE
		{ 0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3 }, // LEFT_SEMI_DIAGONAL_SMALL_SHAPE
		{ 0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4 }, // RIGHT_SEMI_DIAGONAL_SMALL_SHAPE
		{ 0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4 }, // LEFT_SEMI_DIAGONAL_BIG_SHAPE
		{ 0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3 }, // RIGHT_SEMI_DIAGONAL_BIG_SHAPE
		{ 0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3 }, // HALF_SQUARE_SHAPE
		{ 0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5 }, // CORNER_SMALL_SHAPE
		{ 0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5 }, // CORNER_BIG_SHAPE
		{ 0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3 }, // FAN_SMALL_SHAPE
		{ 1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3 }, // FAN_BIG_SHAPE
		{ 1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5 } // TRAPEZIUM_SHAPE
	};

	@OriginalMember(owner = "client!i", name = "<init>", descriptor = "(IIIIIIIIIIIIIIIIIIII)V")
	public TileOverlay(@OriginalArg(0) int tileX, @OriginalArg(1) int shape, @OriginalArg(2) int southeastColor2, @OriginalArg(3) int southeastY, @OriginalArg(4) int northeastColor1, @OriginalArg(5) int rotation, @OriginalArg(6) int southwestColor1, @OriginalArg(7) int northwestY, @OriginalArg(8) int foregroundRgb, @OriginalArg(9) int southwestColor2, @OriginalArg(10) int textureId, @OriginalArg(11) int northwestColor2, @OriginalArg(12) int backgroundRgb, @OriginalArg(13) int northeastY, @OriginalArg(14) int northeastColor2, @OriginalArg(15) int northwestColor1, @OriginalArg(17) int southwestY, @OriginalArg(18) int tileZ, @OriginalArg(19) int southeastColor1) {
		if (southwestY != southeastY || southwestY != northeastY || southwestY != northwestY) {
			this.flat = false;
		}

		this.shape = shape;
		this.rotation = rotation;
		this.backgroundRgb = backgroundRgb;
		this.foregroundRgb = foregroundRgb;

		@Pc(32) short ONE = 128;
		@Pc(36) int HALF = ONE / 2;
		@Pc(40) int QUARTER = ONE / 4;
		@Pc(46) int THREE_QUARTER = ONE * 3 / 4;

		@Pc(50) int[] points = SHAPE_POINTS[shape];
		@Pc(53) int vertexCount = points.length;
		this.vertexX = new int[vertexCount];
		this.vertexY = new int[vertexCount];
		this.vertexZ = new int[vertexCount];
		@Pc(68) int[] primaryColors = new int[vertexCount];
		@Pc(71) int[] secondaryColors = new int[vertexCount];

		@Pc(75) int sceneX = tileX * ONE;
		@Pc(79) int sceneZ = tileZ * ONE;

		for (@Pc(81) int v = 0; v < vertexCount; v++) {
			@Pc(87) int type = points[v];

			if ((type & 0x1) == 0 && type <= 8) {
				type = (type - rotation - rotation - 1 & 0x7) + 1;
			}

			if (type > 8 && type <= 12) {
				type = (type - rotation - 9 & 0x3) + 9;
			}

			if (type > 12 && type <= 16) {
				type = (type - rotation - 13 & 0x3) + 13;
			}

			@Pc(143) int x;
			@Pc(145) int z;
			@Pc(147) int y;
			@Pc(149) int color1;
			@Pc(151) int color2;

			if (type == 1) {
				x = sceneX;
				z = sceneZ;
				y = southwestY;
				color1 = southwestColor1;
				color2 = southwestColor2;
			} else if (type == 2) {
				x = sceneX + HALF;
				z = sceneZ;
				y = southwestY + southeastY >> 1;
				color1 = southwestColor1 + southeastColor1 >> 1;
				color2 = southwestColor2 + southeastColor2 >> 1;
			} else if (type == 3) {
				x = sceneX + ONE;
				z = sceneZ;
				y = southeastY;
				color1 = southeastColor1;
				color2 = southeastColor2;
			} else if (type == 4) {
				x = sceneX + ONE;
				z = sceneZ + HALF;
				y = southeastY + northeastY >> 1;
				color1 = southeastColor1 + northeastColor1 >> 1;
				color2 = southeastColor2 + northeastColor2 >> 1;
			} else if (type == 5) {
				x = sceneX + ONE;
				z = sceneZ + ONE;
				y = northeastY;
				color1 = northeastColor1;
				color2 = northeastColor2;
			} else if (type == 6) {
				x = sceneX + HALF;
				z = sceneZ + ONE;
				y = northeastY + northwestY >> 1;
				color1 = northeastColor1 + northwestColor1 >> 1;
				color2 = northeastColor2 + northwestColor2 >> 1;
			} else if (type == 7) {
				x = sceneX;
				z = sceneZ + ONE;
				y = northwestY;
				color1 = northwestColor1;
				color2 = northwestColor2;
			} else if (type == 8) {
				x = sceneX;
				z = sceneZ + HALF;
				y = northwestY + southwestY >> 1;
				color1 = northwestColor1 + southwestColor1 >> 1;
				color2 = northwestColor2 + southwestColor2 >> 1;
			} else if (type == 9) {
				x = sceneX + HALF;
				z = sceneZ + QUARTER;
				y = southwestY + southeastY >> 1;
				color1 = southwestColor1 + southeastColor1 >> 1;
				color2 = southwestColor2 + southeastColor2 >> 1;
			} else if (type == 10) {
				x = sceneX + THREE_QUARTER;
				z = sceneZ + HALF;
				y = southeastY + northeastY >> 1;
				color1 = southeastColor1 + northeastColor1 >> 1;
				color2 = southeastColor2 + northeastColor2 >> 1;
			} else if (type == 11) {
				x = sceneX + HALF;
				z = sceneZ + THREE_QUARTER;
				y = northeastY + northwestY >> 1;
				color1 = northeastColor1 + northwestColor1 >> 1;
				color2 = northeastColor2 + northwestColor2 >> 1;
			} else if (type == 12) {
				x = sceneX + QUARTER;
				z = sceneZ + HALF;
				y = northwestY + southwestY >> 1;
				color1 = northwestColor1 + southwestColor1 >> 1;
				color2 = northwestColor2 + southwestColor2 >> 1;
			} else if (type == 13) {
				x = sceneX + QUARTER;
				z = sceneZ + QUARTER;
				y = southwestY;
				color1 = southwestColor1;
				color2 = southwestColor2;
			} else if (type == 14) {
				x = sceneX + THREE_QUARTER;
				z = sceneZ + QUARTER;
				y = southeastY;
				color1 = southeastColor1;
				color2 = southeastColor2;
			} else if (type == 15) {
				x = sceneX + THREE_QUARTER;
				z = sceneZ + THREE_QUARTER;
				y = northeastY;
				color1 = northeastColor1;
				color2 = northeastColor2;
			} else {
				x = sceneX + QUARTER;
				z = sceneZ + THREE_QUARTER;
				y = northwestY;
				color1 = northwestColor1;
				color2 = northwestColor2;
			}

			this.vertexX[v] = x;
			this.vertexY[v] = y;
			this.vertexZ[v] = z;
			primaryColors[v] = color1;
			secondaryColors[v] = color2;
		}

		@Pc(552) int[] paths = SHAPE_PATHS[shape];
		int triangleCount = paths.length / 4;
		this.triangleVertexA = new int[triangleCount];
		this.triangleVertexB = new int[triangleCount];
		this.triangleVertexC = new int[triangleCount];
		this.triangleColorA = new int[triangleCount];
		this.triangleColorB = new int[triangleCount];
		this.triangleColorC = new int[triangleCount];

		if (textureId != -1) {
			this.triangleTextureIds = new int[triangleCount];
		}

		int index = 0;
		for (int t = 0; t < triangleCount; t++) {
			int color = paths[index];
			int a = paths[index + 1];
			@Pc(617) int b = paths[index + 2];
			@Pc(623) int c = paths[index + 3];
			index += 4;

			if (a < 4) {
				a = a - rotation & 0x3;
			}

			if (b < 4) {
				b = b - rotation & 0x3;
			}

			if (c < 4) {
				c = c - rotation & 0x3;
			}

			this.triangleVertexA[t] = a;
			this.triangleVertexB[t] = b;
			this.triangleVertexC[t] = c;

			if (color == 0) {
				this.triangleColorA[t] = primaryColors[a];
				this.triangleColorB[t] = primaryColors[b];
				this.triangleColorC[t] = primaryColors[c];

				if (this.triangleTextureIds != null) {
					this.triangleTextureIds[t] = -1;
				}
			} else {
				this.triangleColorA[t] = secondaryColors[a];
				this.triangleColorB[t] = secondaryColors[b];
				this.triangleColorC[t] = secondaryColors[c];

				if (this.triangleTextureIds != null) {
					this.triangleTextureIds[t] = textureId;
				}
			}
		}
	}
}
