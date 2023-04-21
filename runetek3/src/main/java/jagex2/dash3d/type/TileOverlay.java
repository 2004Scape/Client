package jagex2.dash3d.type;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!i")
public final class TileOverlay {

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

	@OriginalMember(owner = "client!i", name = "u", descriptor = "[I")
	private static final int[] anIntArray173 = new int[] { 1, 0 };

	@OriginalMember(owner = "client!i", name = "v", descriptor = "[I")
	private static final int[] anIntArray174 = new int[] { 2, 1 };

	@OriginalMember(owner = "client!i", name = "w", descriptor = "[I")
	private static final int[] anIntArray175 = new int[] { 3, 3 };

	@OriginalMember(owner = "client!i", name = "x", descriptor = "[[I")
	public static final int[][] SHAPE_POINTS = new int[][] { { 1, 3, 5, 7 }, { 1, 3, 5, 7 }, { 1, 3, 5, 7 }, { 1, 3, 5, 7, 6 }, { 1, 3, 5, 7, 6 }, { 1, 3, 5, 7, 6 }, { 1, 3, 5, 7, 6 }, { 1, 3, 5, 7, 2, 6 }, { 1, 3, 5, 7, 2, 8 }, { 1, 3, 5, 7, 2, 8 }, { 1, 3, 5, 7, 11, 12 }, { 1, 3, 5, 7, 11, 12 }, { 1, 3, 5, 7, 13, 14 } };

	@OriginalMember(owner = "client!i", name = "y", descriptor = "[[I")
	public static final int[][] SHAPE_PATHS = new int[][] { { 0, 1, 2, 3, 0, 0, 1, 3 }, { 1, 1, 2, 3, 1, 0, 1, 3 }, { 0, 1, 2, 3, 1, 0, 1, 3 }, { 0, 0, 1, 2, 0, 0, 2, 4, 1, 0, 4, 3 }, { 0, 0, 1, 4, 0, 0, 4, 3, 1, 1, 2, 4 }, { 0, 0, 4, 3, 1, 0, 1, 2, 1, 0, 2, 4 }, { 0, 1, 2, 4, 1, 0, 1, 4, 1, 0, 4, 3 }, { 0, 4, 1, 2, 0, 4, 2, 5, 1, 0, 4, 5, 1, 0, 5, 3 }, { 0, 4, 1, 2, 0, 4, 2, 3, 0, 4, 3, 5, 1, 0, 4, 5 }, { 0, 0, 4, 5, 1, 4, 1, 2, 1, 4, 2, 3, 1, 4, 3, 5 }, { 0, 0, 1, 5, 0, 1, 4, 5, 0, 1, 2, 4, 1, 0, 5, 3, 1, 5, 4, 3, 1, 4, 2, 3 }, { 1, 0, 1, 5, 1, 1, 4, 5, 1, 1, 2, 4, 0, 0, 5, 3, 0, 5, 4, 3, 0, 4, 2, 3 }, { 1, 0, 5, 4, 1, 0, 1, 5, 0, 0, 4, 3, 0, 4, 5, 3, 0, 5, 2, 3, 0, 1, 2, 5 } };

	@OriginalMember(owner = "client!i", name = "<init>", descriptor = "(IIIIIIIIIIIIIIIIIIII)V")
	public TileOverlay(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12, @OriginalArg(13) int arg13, @OriginalArg(14) int arg14, @OriginalArg(15) int arg15, @OriginalArg(17) int arg17, @OriginalArg(18) int arg18, @OriginalArg(19) int arg19) {
		if (arg17 != arg3 || arg17 != arg13 || arg17 != arg7) {
			this.flat = false;
		}
		this.shape = arg1;
		this.rotation = arg5;
		this.backgroundRgb = arg12;
		this.foregroundRgb = arg8;
		@Pc(32) short local32 = 128;
		@Pc(36) int local36 = local32 / 2;
		@Pc(40) int local40 = local32 / 4;
		@Pc(46) int local46 = local32 * 3 / 4;
		@Pc(50) int[] local50 = SHAPE_POINTS[arg1];
		@Pc(53) int local53 = local50.length;
		this.vertexX = new int[local53];
		this.vertexY = new int[local53];
		this.vertexZ = new int[local53];
		@Pc(68) int[] local68 = new int[local53];
		@Pc(71) int[] local71 = new int[local53];
		@Pc(75) int local75 = arg0 * local32;
		@Pc(79) int local79 = arg18 * local32;
		@Pc(143) int local143;
		@Pc(145) int local145;
		@Pc(147) int local147;
		@Pc(149) int local149;
		@Pc(151) int local151;
		for (@Pc(81) int local81 = 0; local81 < local53; local81++) {
			@Pc(87) int local87 = local50[local81];
			if ((local87 & 0x1) == 0 && local87 <= 8) {
				local87 = (local87 - arg5 - arg5 - 1 & 0x7) + 1;
			}
			if (local87 > 8 && local87 <= 12) {
				local87 = (local87 - arg5 - 9 & 0x3) + 9;
			}
			if (local87 > 12 && local87 <= 16) {
				local87 = (local87 - arg5 - 13 & 0x3) + 13;
			}
			if (local87 == 1) {
				local143 = local75;
				local145 = local79;
				local147 = arg17;
				local149 = arg6;
				local151 = arg9;
			} else if (local87 == 2) {
				local143 = local75 + local36;
				local145 = local79;
				local147 = arg17 + arg3 >> 1;
				local149 = arg6 + arg19 >> 1;
				local151 = arg9 + arg2 >> 1;
			} else if (local87 == 3) {
				local143 = local75 + local32;
				local145 = local79;
				local147 = arg3;
				local149 = arg19;
				local151 = arg2;
			} else if (local87 == 4) {
				local143 = local75 + local32;
				local145 = local79 + local36;
				local147 = arg3 + arg13 >> 1;
				local149 = arg19 + arg4 >> 1;
				local151 = arg2 + arg14 >> 1;
			} else if (local87 == 5) {
				local143 = local75 + local32;
				local145 = local79 + local32;
				local147 = arg13;
				local149 = arg4;
				local151 = arg14;
			} else if (local87 == 6) {
				local143 = local75 + local36;
				local145 = local79 + local32;
				local147 = arg13 + arg7 >> 1;
				local149 = arg4 + arg15 >> 1;
				local151 = arg14 + arg11 >> 1;
			} else if (local87 == 7) {
				local143 = local75;
				local145 = local79 + local32;
				local147 = arg7;
				local149 = arg15;
				local151 = arg11;
			} else if (local87 == 8) {
				local143 = local75;
				local145 = local79 + local36;
				local147 = arg7 + arg17 >> 1;
				local149 = arg15 + arg6 >> 1;
				local151 = arg11 + arg9 >> 1;
			} else if (local87 == 9) {
				local143 = local75 + local36;
				local145 = local79 + local40;
				local147 = arg17 + arg3 >> 1;
				local149 = arg6 + arg19 >> 1;
				local151 = arg9 + arg2 >> 1;
			} else if (local87 == 10) {
				local143 = local75 + local46;
				local145 = local79 + local36;
				local147 = arg3 + arg13 >> 1;
				local149 = arg19 + arg4 >> 1;
				local151 = arg2 + arg14 >> 1;
			} else if (local87 == 11) {
				local143 = local75 + local36;
				local145 = local79 + local46;
				local147 = arg13 + arg7 >> 1;
				local149 = arg4 + arg15 >> 1;
				local151 = arg14 + arg11 >> 1;
			} else if (local87 == 12) {
				local143 = local75 + local40;
				local145 = local79 + local36;
				local147 = arg7 + arg17 >> 1;
				local149 = arg15 + arg6 >> 1;
				local151 = arg11 + arg9 >> 1;
			} else if (local87 == 13) {
				local143 = local75 + local40;
				local145 = local79 + local40;
				local147 = arg17;
				local149 = arg6;
				local151 = arg9;
			} else if (local87 == 14) {
				local143 = local75 + local46;
				local145 = local79 + local40;
				local147 = arg3;
				local149 = arg19;
				local151 = arg2;
			} else if (local87 == 15) {
				local143 = local75 + local46;
				local145 = local79 + local46;
				local147 = arg13;
				local149 = arg4;
				local151 = arg14;
			} else {
				local143 = local75 + local40;
				local145 = local79 + local46;
				local147 = arg7;
				local149 = arg15;
				local151 = arg11;
			}
			this.vertexX[local81] = local143;
			this.vertexY[local81] = local147;
			this.vertexZ[local81] = local145;
			local68[local81] = local149;
			local71[local81] = local151;
		}
		@Pc(552) int[] local552 = SHAPE_PATHS[arg1];
		local143 = local552.length / 4;
		this.triangleVertexA = new int[local143];
		this.triangleVertexB = new int[local143];
		this.triangleVertexC = new int[local143];
		this.triangleColorA = new int[local143];
		this.triangleColorB = new int[local143];
		this.triangleColorC = new int[local143];
		if (arg10 != -1) {
			this.triangleTextureIds = new int[local143];
		}
		local145 = 0;
		for (local147 = 0; local147 < local143; local147++) {
			local149 = local552[local145];
			local151 = local552[local145 + 1];
			@Pc(617) int local617 = local552[local145 + 2];
			@Pc(623) int local623 = local552[local145 + 3];
			local145 += 4;
			if (local151 < 4) {
				local151 = local151 - arg5 & 0x3;
			}
			if (local617 < 4) {
				local617 = local617 - arg5 & 0x3;
			}
			if (local623 < 4) {
				local623 = local623 - arg5 & 0x3;
			}
			this.triangleVertexA[local147] = local151;
			this.triangleVertexB[local147] = local617;
			this.triangleVertexC[local147] = local623;
			if (local149 == 0) {
				this.triangleColorA[local147] = local68[local151];
				this.triangleColorB[local147] = local68[local617];
				this.triangleColorC[local147] = local68[local623];
				if (this.triangleTextureIds != null) {
					this.triangleTextureIds[local147] = -1;
				}
			} else {
				this.triangleColorA[local147] = local71[local151];
				this.triangleColorB[local147] = local71[local617];
				this.triangleColorC[local147] = local71[local623];
				if (this.triangleTextureIds != null) {
					this.triangleTextureIds[local147] = arg10;
				}
			}
		}
		local149 = arg17;
		local151 = arg3;
		if (arg3 < arg17) {
			local149 = arg3;
		}
		if (arg3 > arg3) {
			local151 = arg3;
		}
		if (arg13 < local149) {
			local149 = arg13;
		}
		if (arg13 > arg3) {
			local151 = arg13;
		}
		if (arg7 < local149) {
			local149 = arg7;
		}
		if (arg7 > local151) {
			local151 = arg7;
		}
		local149 /= 14;
		local151 /= 14;
	}
}
