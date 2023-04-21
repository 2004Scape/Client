package jagex2.graphics;

import jagex2.datastruct.Hashable;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!eb")
public final class Model extends Hashable {

	@OriginalMember(owner = "client!eb", name = "n", descriptor = "I")
	public int vertexCount;

	@OriginalMember(owner = "client!eb", name = "o", descriptor = "[I")
	public int[] vertexX;

	@OriginalMember(owner = "client!eb", name = "p", descriptor = "[I")
	public int[] vertexY;

	@OriginalMember(owner = "client!eb", name = "q", descriptor = "[I")
	public int[] vertexZ;

	@OriginalMember(owner = "client!eb", name = "r", descriptor = "I")
	public int faceCount;

	@OriginalMember(owner = "client!eb", name = "s", descriptor = "[I")
	public int[] faceVertexA;

	@OriginalMember(owner = "client!eb", name = "t", descriptor = "[I")
	public int[] faceVertexB;

	@OriginalMember(owner = "client!eb", name = "u", descriptor = "[I")
	public int[] faceVertexC;

	@OriginalMember(owner = "client!eb", name = "v", descriptor = "[I")
	private int[] faceColorA;

	@OriginalMember(owner = "client!eb", name = "w", descriptor = "[I")
	private int[] faceColorB;

	@OriginalMember(owner = "client!eb", name = "x", descriptor = "[I")
	private int[] faceColorC;

	@OriginalMember(owner = "client!eb", name = "y", descriptor = "[I")
	public int[] faceInfo;

	@OriginalMember(owner = "client!eb", name = "z", descriptor = "[I")
	private int[] facePriority;

	@OriginalMember(owner = "client!eb", name = "A", descriptor = "[I")
	private int[] faceAlpha;

	@OriginalMember(owner = "client!eb", name = "B", descriptor = "[I")
	public int[] faceColor;

	@OriginalMember(owner = "client!eb", name = "C", descriptor = "I")
	private int priority;

	@OriginalMember(owner = "client!eb", name = "D", descriptor = "I")
	private int texturedFaceCount;

	@OriginalMember(owner = "client!eb", name = "E", descriptor = "[I")
	private int[] texturedVertexA;

	@OriginalMember(owner = "client!eb", name = "F", descriptor = "[I")
	private int[] texturedVertexB;

	@OriginalMember(owner = "client!eb", name = "G", descriptor = "[I")
	private int[] texturedVertexC;

	@OriginalMember(owner = "client!eb", name = "H", descriptor = "I")
	public int minX;

	@OriginalMember(owner = "client!eb", name = "I", descriptor = "I")
	public int maxX;

	@OriginalMember(owner = "client!eb", name = "J", descriptor = "I")
	public int maxZ;

	@OriginalMember(owner = "client!eb", name = "K", descriptor = "I")
	public int minZ;

	@OriginalMember(owner = "client!eb", name = "L", descriptor = "I")
	public int radius;

	@OriginalMember(owner = "client!eb", name = "M", descriptor = "I")
	public int maxY;

	@OriginalMember(owner = "client!eb", name = "N", descriptor = "I")
	public int minY;

	@OriginalMember(owner = "client!eb", name = "O", descriptor = "I")
	private int maxDepth;

	@OriginalMember(owner = "client!eb", name = "P", descriptor = "I")
	private int minDepth;

	@OriginalMember(owner = "client!eb", name = "Q", descriptor = "I")
	public int objRaise;

	@OriginalMember(owner = "client!eb", name = "R", descriptor = "[I")
	private int[] vertexLabel;

	@OriginalMember(owner = "client!eb", name = "S", descriptor = "[I")
	private int[] faceLabel;

	@OriginalMember(owner = "client!eb", name = "T", descriptor = "[[I")
	public int[][] labelVertices;

	@OriginalMember(owner = "client!eb", name = "U", descriptor = "[[I")
	public int[][] labelFaces;

	@OriginalMember(owner = "client!eb", name = "V", descriptor = "Z")
	public boolean pickable = false;

	@OriginalMember(owner = "client!eb", name = "W", descriptor = "[Lclient!n;")
	public VertexNormal[] vertexNormal;

	@OriginalMember(owner = "client!eb", name = "X", descriptor = "[Lclient!n;")
	public VertexNormal[] vertexNormalOriginal;

	@OriginalMember(owner = "client!eb", name = "Y", descriptor = "[Lclient!l;")
	public static Metadata[] metadata;

	@OriginalMember(owner = "client!eb", name = "Z", descriptor = "Lclient!kb;")
	private static Packet head;

	@OriginalMember(owner = "client!eb", name = "ab", descriptor = "Lclient!kb;")
	public static Packet face1;

	@OriginalMember(owner = "client!eb", name = "bb", descriptor = "Lclient!kb;")
	public static Packet face2;

	@OriginalMember(owner = "client!eb", name = "cb", descriptor = "Lclient!kb;")
	public static Packet face3;

	@OriginalMember(owner = "client!eb", name = "db", descriptor = "Lclient!kb;")
	public static Packet face4;

	@OriginalMember(owner = "client!eb", name = "eb", descriptor = "Lclient!kb;")
	public static Packet face5;

	@OriginalMember(owner = "client!eb", name = "fb", descriptor = "Lclient!kb;")
	public static Packet point1;

	@OriginalMember(owner = "client!eb", name = "gb", descriptor = "Lclient!kb;")
	public static Packet point2;

	@OriginalMember(owner = "client!eb", name = "hb", descriptor = "Lclient!kb;")
	public static Packet point3;

	@OriginalMember(owner = "client!eb", name = "ib", descriptor = "Lclient!kb;")
	public static Packet point4;

	@OriginalMember(owner = "client!eb", name = "jb", descriptor = "Lclient!kb;")
	public static Packet point5;

	@OriginalMember(owner = "client!eb", name = "kb", descriptor = "Lclient!kb;")
	public static Packet vertex1;

	@OriginalMember(owner = "client!eb", name = "lb", descriptor = "Lclient!kb;")
	public static Packet vertex2;

	@OriginalMember(owner = "client!eb", name = "mb", descriptor = "Lclient!kb;")
	public static Packet axis;

	@OriginalMember(owner = "client!eb", name = "nb", descriptor = "[Z")
	public static boolean[] faceClippedX = new boolean[4096];

	@OriginalMember(owner = "client!eb", name = "ob", descriptor = "[Z")
	public static boolean[] faceNearClipped = new boolean[4096];

	@OriginalMember(owner = "client!eb", name = "pb", descriptor = "[I")
	public static int[] vertexScreenX = new int[4096];

	@OriginalMember(owner = "client!eb", name = "qb", descriptor = "[I")
	public static int[] vertexScreenY = new int[4096];

	@OriginalMember(owner = "client!eb", name = "rb", descriptor = "[I")
	public static int[] vertexScreenZ = new int[4096];

	@OriginalMember(owner = "client!eb", name = "sb", descriptor = "[I")
	public static int[] vertexViewSpaceX = new int[4096];

	@OriginalMember(owner = "client!eb", name = "tb", descriptor = "[I")
	public static int[] vertexViewSpaceY = new int[4096];

	@OriginalMember(owner = "client!eb", name = "ub", descriptor = "[I")
	public static int[] vertexViewSpaceZ = new int[4096];

	@OriginalMember(owner = "client!eb", name = "vb", descriptor = "[I")
	public static int[] tmpDepthFaceCount = new int[1500];

	@OriginalMember(owner = "client!eb", name = "wb", descriptor = "[[I")
	public static int[][] tmpDepthFaces = new int[1500][512];

	@OriginalMember(owner = "client!eb", name = "xb", descriptor = "[I")
	public static int[] tmpPriorityFaceCount = new int[12];

	@OriginalMember(owner = "client!eb", name = "yb", descriptor = "[[I")
	public static int[][] tmpPriorityFaces = new int[12][2000];

	@OriginalMember(owner = "client!eb", name = "zb", descriptor = "[I")
	public static int[] tmpPriority10FaceDepth = new int[2000];

	@OriginalMember(owner = "client!eb", name = "Ab", descriptor = "[I")
	public static int[] tmpPriority11FaceDepth = new int[2000];

	@OriginalMember(owner = "client!eb", name = "Bb", descriptor = "[I")
	public static int[] tmpPriorityDepthSum = new int[12];

	@OriginalMember(owner = "client!eb", name = "Cb", descriptor = "[I")
	public static final int[] clippedX = new int[10];

	@OriginalMember(owner = "client!eb", name = "Db", descriptor = "[I")
	public static final int[] clippedY = new int[10];

	@OriginalMember(owner = "client!eb", name = "Eb", descriptor = "[I")
	public static final int[] clippedColor = new int[10];

	@OriginalMember(owner = "client!eb", name = "Fb", descriptor = "I")
	public static int baseX;

	@OriginalMember(owner = "client!eb", name = "Gb", descriptor = "I")
	public static int baseY;

	@OriginalMember(owner = "client!eb", name = "Hb", descriptor = "I")
	public static int baseZ;

	@OriginalMember(owner = "client!eb", name = "Ib", descriptor = "Z")
	public static boolean checkHover;

	@OriginalMember(owner = "client!eb", name = "Jb", descriptor = "I")
	public static int mouseX;

	@OriginalMember(owner = "client!eb", name = "Kb", descriptor = "I")
	public static int mouseZ;

	@OriginalMember(owner = "client!eb", name = "Lb", descriptor = "I")
	public static int pickedCount;

	@OriginalMember(owner = "client!eb", name = "Mb", descriptor = "[I")
	public static final int[] pickedBitsets = new int[1000];

	@OriginalMember(owner = "client!eb", name = "Nb", descriptor = "[I")
	public static int[] sin = Draw3D.sin;

	@OriginalMember(owner = "client!eb", name = "Ob", descriptor = "[I")
	public static int[] cos = Draw3D.cos;

	@OriginalMember(owner = "client!eb", name = "Pb", descriptor = "[I")
	public static int[] palette = Draw3D.palette;

	@OriginalMember(owner = "client!eb", name = "Qb", descriptor = "[I")
	public static int[] reciprical16 = Draw3D.reciprocal16;

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(ZI)V")
	public Model(@OriginalArg(1) int arg1) {
		if (metadata != null) {
			@Pc(28) Metadata local28 = metadata[arg1];
			if (local28 == null) {
				System.out.println("Error model:" + arg1 + " not found!");
			} else {
				this.vertexCount = local28.vertexCount;
				this.faceCount = local28.faceCount;
				this.texturedFaceCount = local28.texturedFaceCount;
				this.vertexX = new int[this.vertexCount];
				this.vertexY = new int[this.vertexCount];
				this.vertexZ = new int[this.vertexCount];
				this.faceVertexA = new int[this.faceCount];
				this.faceVertexB = new int[this.faceCount];
				this.faceVertexC = new int[this.faceCount];
				this.texturedVertexA = new int[this.texturedFaceCount];
				this.texturedVertexB = new int[this.texturedFaceCount];
				this.texturedVertexC = new int[this.texturedFaceCount];
				if (local28.vertexLabelsOffset >= 0) {
					this.vertexLabel = new int[this.vertexCount];
				}
				if (local28.faceInfosOffset >= 0) {
					this.faceInfo = new int[this.faceCount];
				}
				if (local28.facePrioritiesOffset >= 0) {
					this.facePriority = new int[this.faceCount];
				} else {
					this.priority = -local28.facePrioritiesOffset - 1;
				}
				if (local28.faceAlphasOffset >= 0) {
					this.faceAlpha = new int[this.faceCount];
				}
				if (local28.faceLabelsOffset >= 0) {
					this.faceLabel = new int[this.faceCount];
				}
				this.faceColor = new int[this.faceCount];
				point1.pos = local28.vertexFlagsOffset;
				point2.pos = local28.vertexXOffset;
				point3.pos = local28.vertexYOffset;
				point4.pos = local28.vertexZOffset;
				point5.pos = local28.vertexLabelsOffset;
				@Pc(175) int local175 = 0;
				@Pc(177) int local177 = 0;
				@Pc(179) int local179 = 0;
				@Pc(186) int local186;
				@Pc(188) int local188;
				@Pc(197) int local197;
				@Pc(206) int local206;
				for (@Pc(181) int local181 = 0; local181 < this.vertexCount; local181++) {
					local186 = point1.g1();
					local188 = 0;
					if ((local186 & 0x1) != 0) {
						local188 = point2.gsmart();
					}
					local197 = 0;
					if ((local186 & 0x2) != 0) {
						local197 = point3.gsmart();
					}
					local206 = 0;
					if ((local186 & 0x4) != 0) {
						local206 = point4.gsmart();
					}
					this.vertexX[local181] = local175 + local188;
					this.vertexY[local181] = local177 + local197;
					this.vertexZ[local181] = local179 + local206;
					local175 = this.vertexX[local181];
					local177 = this.vertexY[local181];
					local179 = this.vertexZ[local181];
					if (this.vertexLabel != null) {
						this.vertexLabel[local181] = point5.g1();
					}
				}
				face1.pos = local28.faceColorsOffset;
				face2.pos = local28.faceInfosOffset;
				face3.pos = local28.facePrioritiesOffset;
				face4.pos = local28.faceAlphasOffset;
				face5.pos = local28.faceLabelsOffset;
				for (local186 = 0; local186 < this.faceCount; local186++) {
					this.faceColor[local186] = face1.g2();
					if (this.faceInfo != null) {
						this.faceInfo[local186] = face2.g1();
					}
					if (this.facePriority != null) {
						this.facePriority[local186] = face3.g1();
					}
					if (this.faceAlpha != null) {
						this.faceAlpha[local186] = face4.g1();
					}
					if (this.faceLabel != null) {
						this.faceLabel[local186] = face5.g1();
					}
				}
				vertex1.pos = local28.faceVerticesOffset;
				vertex2.pos = local28.faceOrientationsOffset;
				local188 = 0;
				local197 = 0;
				local206 = 0;
				@Pc(350) int local350 = 0;
				@Pc(357) int local357;
				for (@Pc(352) int local352 = 0; local352 < this.faceCount; local352++) {
					local357 = vertex2.g1();
					if (local357 == 1) {
						local188 = vertex1.gsmart() + local350;
						local197 = vertex1.gsmart() + local188;
						local206 = vertex1.gsmart() + local197;
						local350 = local206;
						this.faceVertexA[local352] = local188;
						this.faceVertexB[local352] = local197;
						this.faceVertexC[local352] = local206;
					}
					if (local357 == 2) {
						local188 = local188;
						local197 = local206;
						local206 = vertex1.gsmart() + local350;
						local350 = local206;
						this.faceVertexA[local352] = local188;
						this.faceVertexB[local352] = local197;
						this.faceVertexC[local352] = local206;
					}
					if (local357 == 3) {
						local188 = local206;
						local197 = local197;
						local206 = vertex1.gsmart() + local350;
						local350 = local206;
						this.faceVertexA[local352] = local188;
						this.faceVertexB[local352] = local197;
						this.faceVertexC[local352] = local206;
					}
					if (local357 == 4) {
						@Pc(459) int local459 = local188;
						local188 = local197;
						local197 = local459;
						local206 = vertex1.gsmart() + local350;
						local350 = local206;
						this.faceVertexA[local352] = local188;
						this.faceVertexB[local352] = local459;
						this.faceVertexC[local352] = local206;
					}
				}
				axis.pos = local28.faceTextureAxisOffset * 6;
				for (local357 = 0; local357 < this.texturedFaceCount; local357++) {
					this.texturedVertexA[local357] = axis.g2();
					this.texturedVertexB[local357] = axis.g2();
					this.texturedVertexC[local357] = axis.g2();
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(I[Lclient!eb;I)V")
	public Model(@OriginalArg(1) Model[] arg1, @OriginalArg(2) int arg2) {
		@Pc(23) boolean local23 = false;
		@Pc(25) boolean local25 = false;
		@Pc(27) boolean local27 = false;
		@Pc(29) boolean local29 = false;
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		this.priority = -1;
		for (@Pc(43) int local43 = 0; local43 < arg2; local43++) {
			@Pc(49) Model local49 = arg1[local43];
			if (local49 != null) {
				this.vertexCount += local49.vertexCount;
				this.faceCount += local49.faceCount;
				this.texturedFaceCount += local49.texturedFaceCount;
				local23 |= local49.faceInfo != null;
				if (local49.facePriority == null) {
					if (this.priority == -1) {
						this.priority = local49.priority;
					}
					if (this.priority != local49.priority) {
						local25 = true;
					}
				} else {
					local25 = true;
				}
				local27 |= local49.faceAlpha != null;
				local29 |= local49.faceLabel != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.vertexLabel = new int[this.vertexCount];
		this.faceVertexA = new int[this.faceCount];
		this.faceVertexB = new int[this.faceCount];
		this.faceVertexC = new int[this.faceCount];
		this.texturedVertexA = new int[this.texturedFaceCount];
		this.texturedVertexB = new int[this.texturedFaceCount];
		this.texturedVertexC = new int[this.texturedFaceCount];
		if (local23) {
			this.faceInfo = new int[this.faceCount];
		}
		if (local25) {
			this.facePriority = new int[this.faceCount];
		}
		if (local27) {
			this.faceAlpha = new int[this.faceCount];
		}
		if (local29) {
			this.faceLabel = new int[this.faceCount];
		}
		this.faceColor = new int[this.faceCount];
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		for (@Pc(225) int local225 = 0; local225 < arg2; local225++) {
			@Pc(231) Model local231 = arg1[local225];
			if (local231 != null) {
				for (@Pc(235) int local235 = 0; local235 < local231.faceCount; local235++) {
					if (local23) {
						if (local231.faceInfo == null) {
							this.faceInfo[this.faceCount] = 0;
						} else {
							this.faceInfo[this.faceCount] = local231.faceInfo[local235];
						}
					}
					if (local25) {
						if (local231.facePriority == null) {
							this.facePriority[this.faceCount] = local231.priority;
						} else {
							this.facePriority[this.faceCount] = local231.facePriority[local235];
						}
					}
					if (local27) {
						if (local231.faceAlpha == null) {
							this.faceAlpha[this.faceCount] = 0;
						} else {
							this.faceAlpha[this.faceCount] = local231.faceAlpha[local235];
						}
					}
					if (local29 && local231.faceLabel != null) {
						this.faceLabel[this.faceCount] = local231.faceLabel[local235];
					}
					this.faceColor[this.faceCount] = local231.faceColor[local235];
					this.faceVertexA[this.faceCount] = this.addVertex(local231, local231.faceVertexA[local235]);
					this.faceVertexB[this.faceCount] = this.addVertex(local231, local231.faceVertexB[local235]);
					this.faceVertexC[this.faceCount] = this.addVertex(local231, local231.faceVertexC[local235]);
					this.faceCount++;
				}
				for (@Pc(376) int local376 = 0; local376 < local231.texturedFaceCount; local376++) {
					this.texturedVertexA[this.texturedFaceCount] = this.addVertex(local231, local231.texturedVertexA[local376]);
					this.texturedVertexB[this.texturedFaceCount] = this.addVertex(local231, local231.texturedVertexB[local376]);
					this.texturedVertexC[this.texturedFaceCount] = this.addVertex(local231, local231.texturedVertexC[local376]);
					this.texturedFaceCount++;
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "([Lclient!eb;BIZ)V")
	public Model(@OriginalArg(0) Model[] arg0, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
		@Pc(23) boolean local23 = false;
		@Pc(25) boolean local25 = false;
		@Pc(27) boolean local27 = false;
		@Pc(29) boolean local29 = false;
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		this.priority = -1;
		for (@Pc(43) int local43 = 0; local43 < arg2; local43++) {
			@Pc(49) Model local49 = arg0[local43];
			if (local49 != null) {
				this.vertexCount += local49.vertexCount;
				this.faceCount += local49.faceCount;
				this.texturedFaceCount += local49.texturedFaceCount;
				local23 |= local49.faceInfo != null;
				if (local49.facePriority == null) {
					if (this.priority == -1) {
						this.priority = local49.priority;
					}
					if (this.priority != local49.priority) {
						local25 = true;
					}
				} else {
					local25 = true;
				}
				local27 |= local49.faceAlpha != null;
				local29 |= local49.faceColor != null;
			}
		}
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		this.faceVertexA = new int[this.faceCount];
		this.faceVertexB = new int[this.faceCount];
		this.faceVertexC = new int[this.faceCount];
		this.faceColorA = new int[this.faceCount];
		this.faceColorB = new int[this.faceCount];
		this.faceColorC = new int[this.faceCount];
		this.texturedVertexA = new int[this.texturedFaceCount];
		this.texturedVertexB = new int[this.texturedFaceCount];
		this.texturedVertexC = new int[this.texturedFaceCount];
		if (local23) {
			this.faceInfo = new int[this.faceCount];
		}
		if (local25) {
			this.facePriority = new int[this.faceCount];
		}
		if (local27) {
			this.faceAlpha = new int[this.faceCount];
		}
		if (local29) {
			this.faceColor = new int[this.faceCount];
		}
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		@Pc(227) int local227;
		for (local227 = 0; local227 < arg2; local227++) {
			@Pc(240) Model local240 = arg0[local227];
			if (local240 != null) {
				@Pc(245) int local245 = this.vertexCount;
				for (@Pc(247) int local247 = 0; local247 < local240.vertexCount; local247++) {
					this.vertexX[this.vertexCount] = local240.vertexX[local247];
					this.vertexY[this.vertexCount] = local240.vertexY[local247];
					this.vertexZ[this.vertexCount] = local240.vertexZ[local247];
					this.vertexCount++;
				}
				for (@Pc(289) int local289 = 0; local289 < local240.faceCount; local289++) {
					this.faceVertexA[this.faceCount] = local240.faceVertexA[local289] + local245;
					this.faceVertexB[this.faceCount] = local240.faceVertexB[local289] + local245;
					this.faceVertexC[this.faceCount] = local240.faceVertexC[local289] + local245;
					this.faceColorA[this.faceCount] = local240.faceColorA[local289];
					this.faceColorB[this.faceCount] = local240.faceColorB[local289];
					this.faceColorC[this.faceCount] = local240.faceColorC[local289];
					if (local23) {
						if (local240.faceInfo == null) {
							this.faceInfo[this.faceCount] = 0;
						} else {
							this.faceInfo[this.faceCount] = local240.faceInfo[local289];
						}
					}
					if (local25) {
						if (local240.facePriority == null) {
							this.facePriority[this.faceCount] = local240.priority;
						} else {
							this.facePriority[this.faceCount] = local240.facePriority[local289];
						}
					}
					if (local27) {
						if (local240.faceAlpha == null) {
							this.faceAlpha[this.faceCount] = 0;
						} else {
							this.faceAlpha[this.faceCount] = local240.faceAlpha[local289];
						}
					}
					if (local29 && local240.faceColor != null) {
						this.faceColor[this.faceCount] = local240.faceColor[local289];
					}
					this.faceCount++;
				}
				for (@Pc(445) int local445 = 0; local445 < local240.texturedFaceCount; local445++) {
					this.texturedVertexA[this.texturedFaceCount] = local240.texturedVertexA[local445] + local245;
					this.texturedVertexB[this.texturedFaceCount] = local240.texturedVertexB[local445] + local245;
					this.texturedVertexC[this.texturedFaceCount] = local240.texturedVertexC[local445] + local245;
					this.texturedFaceCount++;
				}
			}
		}
		this.calculateBoundsCylinder();
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(Lclient!eb;ZZIZ)V")
	public Model(@OriginalArg(0) Model arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) boolean arg2, @OriginalArg(4) boolean arg4) {
		this.vertexCount = arg0.vertexCount;
		this.faceCount = arg0.faceCount;
		this.texturedFaceCount = arg0.texturedFaceCount;
		@Pc(66) int local66;
		if (arg4) {
			this.vertexX = arg0.vertexX;
			this.vertexY = arg0.vertexY;
			this.vertexZ = arg0.vertexZ;
		} else {
			this.vertexX = new int[this.vertexCount];
			this.vertexY = new int[this.vertexCount];
			this.vertexZ = new int[this.vertexCount];
			for (local66 = 0; local66 < this.vertexCount; local66++) {
				this.vertexX[local66] = arg0.vertexX[local66];
				this.vertexY[local66] = arg0.vertexY[local66];
				this.vertexZ[local66] = arg0.vertexZ[local66];
			}
		}
		if (arg1) {
			this.faceColor = arg0.faceColor;
		} else {
			this.faceColor = new int[this.faceCount];
			for (local66 = 0; local66 < this.faceCount; local66++) {
				this.faceColor[local66] = arg0.faceColor[local66];
			}
		}
		if (arg2) {
			this.faceAlpha = arg0.faceAlpha;
		} else {
			this.faceAlpha = new int[this.faceCount];
			if (arg0.faceAlpha == null) {
				for (local66 = 0; local66 < this.faceCount; local66++) {
					this.faceAlpha[local66] = 0;
				}
			} else {
				for (local66 = 0; local66 < this.faceCount; local66++) {
					this.faceAlpha[local66] = arg0.faceAlpha[local66];
				}
			}
		}
		this.vertexLabel = arg0.vertexLabel;
		this.faceLabel = arg0.faceLabel;
		this.faceInfo = arg0.faceInfo;
		this.faceVertexA = arg0.faceVertexA;
		this.faceVertexB = arg0.faceVertexB;
		this.faceVertexC = arg0.faceVertexC;
		this.facePriority = arg0.facePriority;
		this.priority = arg0.priority;
		this.texturedVertexA = arg0.texturedVertexA;
		this.texturedVertexB = arg0.texturedVertexB;
		this.texturedVertexC = arg0.texturedVertexC;
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(Lclient!eb;BZZ)V")
	public Model(@OriginalArg(0) Model arg0, @OriginalArg(2) boolean arg2, @OriginalArg(3) boolean arg3) {
		this.vertexCount = arg0.vertexCount;
		this.faceCount = arg0.faceCount;
		this.texturedFaceCount = arg0.texturedFaceCount;
		@Pc(42) int local42;
		if (arg2) {
			this.vertexY = new int[this.vertexCount];
			for (local42 = 0; local42 < this.vertexCount; local42++) {
				this.vertexY[local42] = arg0.vertexY[local42];
			}
		} else {
			this.vertexY = arg0.vertexY;
		}
		if (arg3) {
			this.faceColorA = new int[this.faceCount];
			this.faceColorB = new int[this.faceCount];
			this.faceColorC = new int[this.faceCount];
			for (local42 = 0; local42 < this.faceCount; local42++) {
				this.faceColorA[local42] = arg0.faceColorA[local42];
				this.faceColorB[local42] = arg0.faceColorB[local42];
				this.faceColorC[local42] = arg0.faceColorC[local42];
			}
			this.faceInfo = new int[this.faceCount];
			@Pc(122) int local122;
			if (arg0.faceInfo == null) {
				for (local122 = 0; local122 < this.faceCount; local122++) {
					this.faceInfo[local122] = 0;
				}
			} else {
				for (local122 = 0; local122 < this.faceCount; local122++) {
					this.faceInfo[local122] = arg0.faceInfo[local122];
				}
			}
			this.vertexNormal = new VertexNormal[this.vertexCount];
			for (local122 = 0; local122 < this.vertexCount; local122++) {
				@Pc(170) VertexNormal local170 = this.vertexNormal[local122] = new VertexNormal();
				@Pc(175) VertexNormal local175 = arg0.vertexNormal[local122];
				local170.x = local175.x;
				local170.y = local175.y;
				local170.z = local175.z;
				local170.w = local175.w;
			}
			this.vertexNormalOriginal = arg0.vertexNormalOriginal;
		} else {
			this.faceColorA = arg0.faceColorA;
			this.faceColorB = arg0.faceColorB;
			this.faceColorC = arg0.faceColorC;
			this.faceInfo = arg0.faceInfo;
		}
		this.vertexX = arg0.vertexX;
		this.vertexZ = arg0.vertexZ;
		this.faceColor = arg0.faceColor;
		this.faceAlpha = arg0.faceAlpha;
		this.facePriority = arg0.facePriority;
		this.priority = arg0.priority;
		this.faceVertexA = arg0.faceVertexA;
		this.faceVertexB = arg0.faceVertexB;
		this.faceVertexC = arg0.faceVertexC;
		this.texturedVertexA = arg0.texturedVertexA;
		this.texturedVertexB = arg0.texturedVertexB;
		this.texturedVertexC = arg0.texturedVertexC;
		this.maxY = arg0.maxY;
		this.minY = arg0.minY;
		this.radius = arg0.radius;
		this.minDepth = arg0.minDepth;
		this.maxDepth = arg0.maxDepth;
		this.minX = arg0.minX;
		this.maxZ = arg0.maxZ;
		this.minZ = arg0.minZ;
		this.maxX = arg0.maxX;
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(ILclient!eb;Z)V")
	public Model(@OriginalArg(1) Model arg1, @OriginalArg(2) boolean arg2) {
		this.vertexCount = arg1.vertexCount;
		this.faceCount = arg1.faceCount;
		this.texturedFaceCount = arg1.texturedFaceCount;
		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];
		for (@Pc(50) int local50 = 0; local50 < this.vertexCount; local50++) {
			this.vertexX[local50] = arg1.vertexX[local50];
			this.vertexY[local50] = arg1.vertexY[local50];
			this.vertexZ[local50] = arg1.vertexZ[local50];
		}
		if (arg2) {
			this.faceAlpha = arg1.faceAlpha;
		} else {
			this.faceAlpha = new int[this.faceCount];
			@Pc(99) int local99;
			if (arg1.faceAlpha == null) {
				for (local99 = 0; local99 < this.faceCount; local99++) {
					this.faceAlpha[local99] = 0;
				}
			} else {
				for (local99 = 0; local99 < this.faceCount; local99++) {
					this.faceAlpha[local99] = arg1.faceAlpha[local99];
				}
			}
		}
		this.faceInfo = arg1.faceInfo;
		this.faceColor = arg1.faceColor;
		this.facePriority = arg1.facePriority;
		this.priority = arg1.priority;
		this.labelFaces = arg1.labelFaces;
		this.labelVertices = arg1.labelVertices;
		this.faceVertexA = arg1.faceVertexA;
		this.faceVertexB = arg1.faceVertexB;
		this.faceVertexC = arg1.faceVertexC;
		this.faceColorA = arg1.faceColorA;
		this.faceColorB = arg1.faceColorB;
		this.faceColorC = arg1.faceColorC;
		this.texturedVertexA = arg1.texturedVertexA;
		this.texturedVertexB = arg1.texturedVertexB;
		this.texturedVertexC = arg1.texturedVertexC;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(Z)V")
	public static void unload() {
		metadata = null;
		head = null;
		face1 = null;
		face2 = null;
		face3 = null;
		face4 = null;
		face5 = null;
		point1 = null;
		point2 = null;
		point3 = null;
		point4 = null;
		point5 = null;
		vertex1 = null;
		vertex2 = null;
		axis = null;
		faceClippedX = null;
		faceNearClipped = null;
		vertexScreenX = null;
		vertexScreenY = null;
		vertexScreenZ = null;
		vertexViewSpaceX = null;
		vertexViewSpaceY = null;
		vertexViewSpaceZ = null;
		tmpDepthFaceCount = null;
		tmpDepthFaces = null;
		tmpPriorityFaceCount = null;
		tmpPriorityFaces = null;
		tmpPriority10FaceDepth = null;
		tmpPriority11FaceDepth = null;
		tmpPriorityDepthSum = null;
		sin = null;
		cos = null;
		palette = null;
		reciprical16 = null;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(ILclient!ub;)V")
	public static void unpack(@OriginalArg(1) Jagfile arg1) {
		try {
			head = new Packet(arg1.read("ob_head.dat", null));
			face1 = new Packet(arg1.read("ob_face1.dat", null));
			face2 = new Packet(arg1.read("ob_face2.dat", null));
			face3 = new Packet(arg1.read("ob_face3.dat", null));
			face4 = new Packet(arg1.read("ob_face4.dat", null));
			face5 = new Packet(arg1.read("ob_face5.dat", null));
			point1 = new Packet(arg1.read("ob_point1.dat", null));
			point2 = new Packet(arg1.read("ob_point2.dat", null));
			point3 = new Packet(arg1.read("ob_point3.dat", null));
			point4 = new Packet(arg1.read("ob_point4.dat", null));
			point5 = new Packet(arg1.read("ob_point5.dat", null));
			vertex1 = new Packet(arg1.read("ob_vertex1.dat", null));
			vertex2 = new Packet(arg1.read("ob_vertex2.dat", null));
			axis = new Packet(arg1.read("ob_axis.dat", null));
			head.pos = 0;
			point1.pos = 0;
			point2.pos = 0;
			point3.pos = 0;
			point4.pos = 0;
			vertex1.pos = 0;
			vertex2.pos = 0;
			@Pc(172) int local172 = head.g2();
			metadata = new Metadata[local172 + 100];
			@Pc(179) int local179 = 0;
			@Pc(181) int local181 = 0;
			@Pc(183) int local183 = 0;
			@Pc(185) int local185 = 0;
			@Pc(187) int local187 = 0;
			@Pc(189) int local189 = 0;
			@Pc(191) int local191 = 0;
			for (@Pc(193) int local193 = 0; local193 < local172; local193++) {
				@Pc(198) int local198 = head.g2();
				@Pc(206) Metadata local206 = metadata[local198] = new Metadata();
				local206.vertexCount = head.g2();
				local206.faceCount = head.g2();
				local206.texturedFaceCount = head.g1();
				local206.vertexFlagsOffset = point1.pos;
				local206.vertexXOffset = point2.pos;
				local206.vertexYOffset = point3.pos;
				local206.vertexZOffset = point4.pos;
				local206.faceVerticesOffset = vertex1.pos;
				local206.faceOrientationsOffset = vertex2.pos;
				@Pc(245) int local245 = head.g1();
				@Pc(248) int local248 = head.g1();
				@Pc(251) int local251 = head.g1();
				@Pc(254) int local254 = head.g1();
				@Pc(257) int local257 = head.g1();
				@Pc(264) int local264;
				for (@Pc(259) int local259 = 0; local259 < local206.vertexCount; local259++) {
					local264 = point1.g1();
					if ((local264 & 0x1) != 0) {
						point2.gsmart();
					}
					if ((local264 & 0x2) != 0) {
						point3.gsmart();
					}
					if ((local264 & 0x4) != 0) {
						point4.gsmart();
					}
				}
				for (local264 = 0; local264 < local206.faceCount; local264++) {
					@Pc(297) int local297 = vertex2.g1();
					if (local297 == 1) {
						vertex1.gsmart();
						vertex1.gsmart();
					}
					vertex1.gsmart();
				}
				local206.faceColorsOffset = local183;
				local183 += local206.faceCount * 2;
				if (local245 == 1) {
					local206.faceInfosOffset = local185;
					local185 += local206.faceCount;
				} else {
					local206.faceInfosOffset = -1;
				}
				if (local248 == 255) {
					local206.facePrioritiesOffset = local187;
					local187 += local206.faceCount;
				} else {
					local206.facePrioritiesOffset = -local248 - 1;
				}
				if (local251 == 1) {
					local206.faceAlphasOffset = local189;
					local189 += local206.faceCount;
				} else {
					local206.faceAlphasOffset = -1;
				}
				if (local254 == 1) {
					local206.faceLabelsOffset = local191;
					local191 += local206.faceCount;
				} else {
					local206.faceLabelsOffset = -1;
				}
				if (local257 == 1) {
					local206.vertexLabelsOffset = local181;
					local181 += local206.vertexCount;
				} else {
					local206.vertexLabelsOffset = -1;
				}
				local206.faceTextureAxisOffset = local179;
				local179 += local206.texturedFaceCount;
			}
		} catch (@Pc(421) Exception local421) {
			System.out.println("Error loading model index");
			local421.printStackTrace();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(III)I")
	public static int mulColorLightness(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if ((arg2 & 0x2) == 2) {
			if (arg1 < 0) {
				arg1 = 0;
			} else if (arg1 > 127) {
				arg1 = 127;
			}
			return 127 - arg1;
		}
		arg1 = arg1 * (arg0 & 0x7F) >> 7;
		if (arg1 < 2) {
			arg1 = 2;
		} else if (arg1 > 126) {
			arg1 = 126;
		}
		return (arg0 & 0xFF80) + arg1;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(Lclient!eb;I)I")
	private int addVertex(@OriginalArg(0) Model arg0, @OriginalArg(1) int arg1) {
		@Pc(3) int local3 = -1;
		@Pc(8) int local8 = arg0.vertexX[arg1];
		@Pc(13) int local13 = arg0.vertexY[arg1];
		@Pc(18) int local18 = arg0.vertexZ[arg1];
		for (@Pc(20) int local20 = 0; local20 < this.vertexCount; local20++) {
			if (local8 == this.vertexX[local20] && local13 == this.vertexY[local20] && local18 == this.vertexZ[local20]) {
				local3 = local20;
				break;
			}
		}
		if (local3 == -1) {
			this.vertexX[this.vertexCount] = local8;
			this.vertexY[this.vertexCount] = local13;
			this.vertexZ[this.vertexCount] = local18;
			if (arg0.vertexLabel != null) {
				this.vertexLabel[this.vertexCount] = arg0.vertexLabel[arg1];
			}
			local3 = this.vertexCount++;
		}
		return local3;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(I)V")
	public void calculateBoundsCylinder() {
		this.maxY = 0;
		this.radius = 0;
		this.minY = 0;
		for (@Pc(14) int local14 = 0; local14 < this.vertexCount; local14++) {
			@Pc(21) int local21 = this.vertexX[local14];
			@Pc(26) int local26 = this.vertexY[local14];
			@Pc(31) int local31 = this.vertexZ[local14];
			if (-local26 > this.maxY) {
				this.maxY = -local26;
			}
			if (local26 > this.minY) {
				this.minY = local26;
			}
			@Pc(55) int local55 = local21 * local21 + local31 * local31;
			if (local55 > this.radius) {
				this.radius = local55;
			}
		}
		this.radius = (int) (Math.sqrt((double) this.radius) + 0.99D);
		this.minDepth = (int) (Math.sqrt((double) (this.radius * this.radius + this.maxY * this.maxY)) + 0.99D);
		this.maxDepth = this.minDepth + (int) (Math.sqrt((double) (this.radius * this.radius + this.minY * this.minY)) + 0.99D);
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(I)V")
	public void calculateBoundsY() {
		this.maxY = 0;
		@Pc(8) int local8;
		this.minY = 0;
		for (local8 = 0; local8 < this.vertexCount; local8++) {
			@Pc(25) int local25 = this.vertexY[local8];
			if (-local25 > this.maxY) {
				this.maxY = -local25;
			}
			if (local25 > this.minY) {
				this.minY = local25;
			}
		}
		this.minDepth = (int) (Math.sqrt((double) (this.radius * this.radius + this.maxY * this.maxY)) + 0.99D);
		this.maxDepth = this.minDepth + (int) (Math.sqrt((double) (this.radius * this.radius + this.minY * this.minY)) + 0.99D);
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(B)V")
	private void calculateBoundsAABB() {
		this.maxY = 0;
		this.radius = 0;
		this.minY = 0;
		this.minX = 999999;
		this.maxX = -999999;
		this.maxZ = -99999;
		this.minZ = 99999;
		for (@Pc(27) int local27 = 0; local27 < this.vertexCount; local27++) {
			@Pc(34) int local34 = this.vertexX[local27];
			@Pc(39) int local39 = this.vertexY[local27];
			@Pc(44) int local44 = this.vertexZ[local27];
			if (local34 < this.minX) {
				this.minX = local34;
			}
			if (local34 > this.maxX) {
				this.maxX = local34;
			}
			if (local44 < this.minZ) {
				this.minZ = local44;
			}
			if (local44 > this.maxZ) {
				this.maxZ = local44;
			}
			if (-local39 > this.maxY) {
				this.maxY = -local39;
			}
			if (local39 > this.minY) {
				this.minY = local39;
			}
			@Pc(96) int local96 = local34 * local34 + local44 * local44;
			if (local96 > this.radius) {
				this.radius = local96;
			}
		}
		this.radius = (int) Math.sqrt((double) this.radius);
		this.minDepth = (int) Math.sqrt((double) (this.radius * this.radius + this.maxY * this.maxY));
		this.maxDepth = this.minDepth + (int) Math.sqrt((double) (this.radius * this.radius + this.minY * this.minY));
	}

	@OriginalMember(owner = "client!eb", name = "c", descriptor = "(I)V")
	public void createLabelReferences() {
		@Pc(11) int[] local11;
		@Pc(26) int local26;
		@Pc(13) int local13;
		@Pc(15) int local15;
		@Pc(22) int local22;
		@Pc(67) int local67;
		@Pc(74) int local74;
		if (this.vertexLabel != null) {
			local11 = new int[256];
			local13 = 0;
			for (local15 = 0; local15 < this.vertexCount; local15++) {
				local22 = this.vertexLabel[local15];
				local26 = local11[local22]++;
				if (local22 > local13) {
					local13 = local22;
				}
			}
			this.labelVertices = new int[local13 + 1][];
			for (local22 = 0; local22 <= local13; local22++) {
				this.labelVertices[local22] = new int[local11[local22]];
				local11[local22] = 0;
			}
			local67 = 0;
			while (local67 < this.vertexCount) {
				local74 = this.vertexLabel[local67];
				this.labelVertices[local74][local11[local74]++] = local67++;
			}
			this.vertexLabel = null;
		}
		if (this.faceLabel != null) {
			local11 = new int[256];
			local13 = 0;
			for (local15 = 0; local15 < this.faceCount; local15++) {
				local22 = this.faceLabel[local15];
				local26 = local11[local22]++;
				if (local22 > local13) {
					local13 = local22;
				}
			}
			this.labelFaces = new int[local13 + 1][];
			for (local22 = 0; local22 <= local13; local22++) {
				this.labelFaces[local22] = new int[local11[local22]];
				local11[local22] = 0;
			}
			local67 = 0;
			while (local67 < this.faceCount) {
				local74 = this.faceLabel[local67];
				this.labelFaces[local74][local11[local74]++] = local67++;
			}
			this.faceLabel = null;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(II)V")
	public void applyTransform(@OriginalArg(1) int arg1) {
		if (this.labelVertices != null && arg1 != -1) {
			@Pc(11) SeqFrame local11 = SeqFrame.instances[arg1];
			@Pc(14) SeqBase local14 = local11.base;
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			for (@Pc(22) int local22 = 0; local22 < local11.length; local22++) {
				@Pc(29) int local29 = local11.bases[local22];
				this.applyTransform(local14.types[local29], local14.labels[local29], local11.x[local22], local11.y[local22], local11.z[local22]);
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(III[I)V")
	public void applyTransforms(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3) {
		if (arg3 == null || arg0 == -1) {
			this.applyTransform(arg2);
		} else {
			@Pc(19) SeqFrame local19 = SeqFrame.instances[arg2];
			@Pc(32) SeqFrame local32 = SeqFrame.instances[arg0];
			@Pc(35) SeqBase local35 = local19.base;
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			@Pc(43) byte local43 = 0;
			@Pc(46) int local46 = local43 + 1;
			@Pc(48) int local48 = arg3[local43];
			@Pc(57) int local57;
			for (@Pc(50) int local50 = 0; local50 < local19.length; local50++) {
				local57 = local19.bases[local50];
				while (local57 > local48) {
					local48 = arg3[local46++];
				}
				if (local57 != local48 || local35.types[local57] == 0) {
					this.applyTransform(local35.types[local57], local35.labels[local57], local19.x[local50], local19.y[local50], local19.z[local50]);
				}
			}
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			local43 = 0;
			local46 = local43 + 1;
			local48 = arg3[local43];
			for (local57 = 0; local57 < local32.length; local57++) {
				@Pc(124) int local124 = local32.bases[local57];
				while (local124 > local48) {
					local48 = arg3[local46++];
				}
				if (local124 == local48 || local35.types[local124] == 0) {
					this.applyTransform(local35.types[local124], local35.labels[local124], local32.x[local57], local32.y[local57], local32.z[local57]);
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(I[IIII)V")
	private void applyTransform(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(4) int local4 = arg1.length;
		@Pc(8) int local8;
		@Pc(16) int local16;
		@Pc(34) int local34;
		@Pc(40) int local40;
		if (arg0 == 0) {
			local8 = 0;
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			for (local16 = 0; local16 < local4; local16++) {
				@Pc(22) int local22 = arg1[local16];
				if (local22 < this.labelVertices.length) {
					@Pc(32) int[] local32 = this.labelVertices[local22];
					for (local34 = 0; local34 < local32.length; local34++) {
						local40 = local32[local34];
						baseX += this.vertexX[local40];
						baseY += this.vertexY[local40];
						baseZ += this.vertexZ[local40];
						local8++;
					}
				}
			}
			if (local8 > 0) {
				baseX = baseX / local8 + arg2;
				baseY = baseY / local8 + arg3;
				baseZ = baseZ / local8 + arg4;
			} else {
				baseX = arg2;
				baseY = arg3;
				baseZ = arg4;
			}
			return;
		}
		@Pc(120) int[] local120;
		@Pc(122) int local122;
		if (arg0 == 1) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.labelVertices.length) {
					local120 = this.labelVertices[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.vertexX[local34] += arg2;
						this.vertexY[local34] += arg3;
						this.vertexZ[local34] += arg4;
					}
				}
			}
		} else if (arg0 == 2) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.labelVertices.length) {
					local120 = this.labelVertices[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.vertexX[local34] -= baseX;
						this.vertexY[local34] -= baseY;
						this.vertexZ[local34] -= baseZ;
						local40 = (arg2 & 0xFF) * 8;
						@Pc(227) int local227 = (arg3 & 0xFF) * 8;
						@Pc(233) int local233 = (arg4 & 0xFF) * 8;
						@Pc(239) int local239;
						@Pc(243) int local243;
						@Pc(259) int local259;
						if (local233 != 0) {
							local239 = sin[local233];
							local243 = cos[local233];
							local259 = this.vertexY[local34] * local239 + this.vertexX[local34] * local243 >> 16;
							this.vertexY[local34] = this.vertexY[local34] * local243 - this.vertexX[local34] * local239 >> 16;
							this.vertexX[local34] = local259;
						}
						if (local40 != 0) {
							local239 = sin[local40];
							local243 = cos[local40];
							local259 = this.vertexY[local34] * local243 - this.vertexZ[local34] * local239 >> 16;
							this.vertexZ[local34] = this.vertexY[local34] * local239 + this.vertexZ[local34] * local243 >> 16;
							this.vertexY[local34] = local259;
						}
						if (local227 != 0) {
							local239 = sin[local227];
							local243 = cos[local227];
							local259 = this.vertexZ[local34] * local239 + this.vertexX[local34] * local243 >> 16;
							this.vertexZ[local34] = this.vertexZ[local34] * local243 - this.vertexX[local34] * local239 >> 16;
							this.vertexX[local34] = local259;
						}
						this.vertexX[local34] += baseX;
						this.vertexY[local34] += baseY;
						this.vertexZ[local34] += baseZ;
					}
				}
			}
		} else if (arg0 == 3) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.labelVertices.length) {
					local120 = this.labelVertices[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.vertexX[local34] -= baseX;
						this.vertexY[local34] -= baseY;
						this.vertexZ[local34] -= baseZ;
						this.vertexX[local34] = this.vertexX[local34] * arg2 / 128;
						this.vertexY[local34] = this.vertexY[local34] * arg3 / 128;
						this.vertexZ[local34] = this.vertexZ[local34] * arg4 / 128;
						this.vertexX[local34] += baseX;
						this.vertexY[local34] += baseY;
						this.vertexZ[local34] += baseZ;
					}
				}
			}
		} else if (arg0 == 5 && (this.labelFaces != null && this.faceAlpha != null)) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.labelFaces.length) {
					local120 = this.labelFaces[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.faceAlpha[local34] += arg2 * 8;
						if (this.faceAlpha[local34] < 0) {
							this.faceAlpha[local34] = 0;
						}
						if (this.faceAlpha[local34] > 255) {
							this.faceAlpha[local34] = 255;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "d", descriptor = "(I)V")
	public void rotateY90() {
		for (@Pc(6) int local6 = 0; local6 < this.vertexCount; local6++) {
			@Pc(13) int local13 = this.vertexX[local6];
			this.vertexX[local6] = this.vertexZ[local6];
			this.vertexZ[local6] = -local13;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(BI)V")
	public void rotateX(@OriginalArg(1) int arg1) {
		@Pc(3) int local3 = sin[arg1];
		@Pc(7) int local7 = cos[arg1];
		for (@Pc(9) int local9 = 0; local9 < this.vertexCount; local9++) {
			@Pc(27) int local27 = this.vertexY[local9] * local7 - this.vertexZ[local9] * local3 >> 16;
			this.vertexZ[local9] = this.vertexY[local9] * local3 + this.vertexZ[local9] * local7 >> 16;
			this.vertexY[local9] = local27;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIII)V")
	public void translate(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) {
		for (@Pc(11) int local11 = 0; local11 < this.vertexCount; local11++) {
			this.vertexX[local11] += arg1;
			this.vertexY[local11] += arg0;
			this.vertexZ[local11] += arg3;
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(II)V")
	public void recolor(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		for (@Pc(1) int local1 = 0; local1 < this.faceCount; local1++) {
			if (this.faceColor[local1] == arg0) {
				this.faceColor[local1] = arg1;
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "e", descriptor = "(I)V")
	public void rotateY180() {
		for (@Pc(3) int local3 = 0; local3 < this.vertexCount; local3++) {
			this.vertexZ[local3] = -this.vertexZ[local3];
		}
		@Pc(28) int local28;
		for (@Pc(21) int local21 = 0; local21 < this.faceCount; local21++) {
			local28 = this.faceVertexA[local21];
			this.faceVertexA[local21] = this.faceVertexC[local21];
			this.faceVertexC[local21] = local28;
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(IIII)V")
	public void scale(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		for (@Pc(1) int local1 = 0; local1 < this.vertexCount; local1++) {
			this.vertexX[local1] = this.vertexX[local1] * arg3 / 128;
			this.vertexY[local1] = this.vertexY[local1] * arg2 / 128;
			this.vertexZ[local1] = this.vertexZ[local1] * arg0 / 128;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIZ)V")
	public void calculateNormals(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5) {
		@Pc(16) int local16 = (int) Math.sqrt((double) (arg2 * arg2 + arg3 * arg3 + arg4 * arg4));
		@Pc(22) int local22 = arg1 * local16 >> 8;
		if (this.faceColorA == null) {
			this.faceColorA = new int[this.faceCount];
			this.faceColorB = new int[this.faceCount];
			this.faceColorC = new int[this.faceCount];
		}
		@Pc(50) int local50;
		if (this.vertexNormal == null) {
			this.vertexNormal = new VertexNormal[this.vertexCount];
			for (local50 = 0; local50 < this.vertexCount; local50++) {
				this.vertexNormal[local50] = new VertexNormal();
			}
		}
		@Pc(73) int local73;
		for (local50 = 0; local50 < this.faceCount; local50++) {
			local73 = this.faceVertexA[local50];
			@Pc(78) int local78 = this.faceVertexB[local50];
			@Pc(83) int local83 = this.faceVertexC[local50];
			@Pc(93) int local93 = this.vertexX[local78] - this.vertexX[local73];
			@Pc(103) int local103 = this.vertexY[local78] - this.vertexY[local73];
			@Pc(113) int local113 = this.vertexZ[local78] - this.vertexZ[local73];
			@Pc(123) int local123 = this.vertexX[local83] - this.vertexX[local73];
			@Pc(133) int local133 = this.vertexY[local83] - this.vertexY[local73];
			@Pc(143) int local143 = this.vertexZ[local83] - this.vertexZ[local73];
			@Pc(151) int local151 = local103 * local143 - local133 * local113;
			@Pc(159) int local159 = local113 * local123 - local143 * local93;
			@Pc(167) int local167;
			for (local167 = local93 * local133 - local123 * local103; local151 > 8192 || local159 > 8192 || local167 > 8192 || local151 < -8192 || local159 < -8192 || local167 < -8192; local167 >>= 0x1) {
				local151 >>= 0x1;
				local159 >>= 0x1;
			}
			@Pc(214) int local214 = (int) Math.sqrt((double) (local151 * local151 + local159 * local159 + local167 * local167));
			if (local214 <= 0) {
				local214 = 1;
			}
			local151 = local151 * 256 / local214;
			local159 = local159 * 256 / local214;
			local167 = local167 * 256 / local214;
			if (this.faceInfo == null || (this.faceInfo[local50] & 0x1) == 0) {
				@Pc(251) VertexNormal local251 = this.vertexNormal[local73];
				local251.x += local151;
				local251.y += local159;
				local251.z += local167;
				local251.w++;
				@Pc(280) VertexNormal local280 = this.vertexNormal[local78];
				local280.x += local151;
				local280.y += local159;
				local280.z += local167;
				local280.w++;
				@Pc(309) VertexNormal local309 = this.vertexNormal[local83];
				local309.x += local151;
				local309.y += local159;
				local309.z += local167;
				local309.w++;
			} else {
				@Pc(355) int local355 = arg0 + (arg2 * local151 + arg3 * local159 + arg4 * local167) / (local22 + local22 / 2);
				this.faceColorA[local50] = mulColorLightness(this.faceColor[local50], local355, this.faceInfo[local50]);
			}
		}
		if (arg5) {
			this.applyLighting(arg0, local22, arg2, arg3, arg4);
		} else {
			this.vertexNormalOriginal = new VertexNormal[this.vertexCount];
			for (local73 = 0; local73 < this.vertexCount; local73++) {
				@Pc(399) VertexNormal local399 = this.vertexNormal[local73];
				@Pc(408) VertexNormal local408 = this.vertexNormalOriginal[local73] = new VertexNormal();
				local408.x = local399.x;
				local408.y = local399.y;
				local408.z = local399.z;
				local408.w = local399.w;
			}
		}
		if (arg5) {
			this.calculateBoundsCylinder();
		} else {
			this.calculateBoundsAABB();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIII)V")
	public void applyLighting(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(10) int local10;
		for (@Pc(3) int local3 = 0; local3 < this.faceCount; local3++) {
			local10 = this.faceVertexA[local3];
			@Pc(15) int local15 = this.faceVertexB[local3];
			@Pc(20) int local20 = this.faceVertexC[local3];
			@Pc(33) VertexNormal local33;
			@Pc(55) int local55;
			@Pc(28) int local28;
			if (this.faceInfo == null) {
				local28 = this.faceColor[local3];
				local33 = this.vertexNormal[local10];
				local55 = arg0 + (arg2 * local33.x + arg3 * local33.y + arg4 * local33.z) / (arg1 * local33.w);
				this.faceColorA[local3] = mulColorLightness(local28, local55, 0);
				@Pc(68) VertexNormal local68 = this.vertexNormal[local15];
				@Pc(90) int local90 = arg0 + (arg2 * local68.x + arg3 * local68.y + arg4 * local68.z) / (arg1 * local68.w);
				this.faceColorB[local3] = mulColorLightness(local28, local90, 0);
				@Pc(103) VertexNormal local103 = this.vertexNormal[local20];
				@Pc(125) int local125 = arg0 + (arg2 * local103.x + arg3 * local103.y + arg4 * local103.z) / (arg1 * local103.w);
				this.faceColorC[local3] = mulColorLightness(local28, local125, 0);
			} else if ((this.faceInfo[local3] & 0x1) == 0) {
				local28 = this.faceColor[local3];
				@Pc(152) int local152 = this.faceInfo[local3];
				local33 = this.vertexNormal[local10];
				local55 = arg0 + (arg2 * local33.x + arg3 * local33.y + arg4 * local33.z) / (arg1 * local33.w);
				this.faceColorA[local3] = mulColorLightness(local28, local55, local152);
				local33 = this.vertexNormal[local15];
				local55 = arg0 + (arg2 * local33.x + arg3 * local33.y + arg4 * local33.z) / (arg1 * local33.w);
				this.faceColorB[local3] = mulColorLightness(local28, local55, local152);
				local33 = this.vertexNormal[local20];
				local55 = arg0 + (arg2 * local33.x + arg3 * local33.y + arg4 * local33.z) / (arg1 * local33.w);
				this.faceColorC[local3] = mulColorLightness(local28, local55, local152);
			}
		}
		this.vertexNormal = null;
		this.vertexNormalOriginal = null;
		this.vertexLabel = null;
		this.faceLabel = null;
		if (this.faceInfo != null) {
			for (local10 = 0; local10 < this.faceCount; local10++) {
				if ((this.faceInfo[local10] & 0x2) == 2) {
					return;
				}
			}
		}
		this.faceColor = null;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIII)V")
	public void drawSimple(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		@Pc(1) int local1 = Draw3D.centerX;
		@Pc(3) int local3 = Draw3D.centerY;
		@Pc(7) int local7 = sin[arg0];
		@Pc(11) int local11 = cos[arg0];
		@Pc(15) int local15 = sin[arg1];
		@Pc(19) int local19 = cos[arg1];
		@Pc(23) int local23 = sin[arg2];
		@Pc(27) int local27 = cos[arg2];
		@Pc(31) int local31 = sin[arg3];
		@Pc(35) int local35 = cos[arg3];
		@Pc(45) int local45 = arg5 * local31 + arg6 * local35 >> 16;
		for (@Pc(47) int local47 = 0; local47 < this.vertexCount; local47++) {
			@Pc(54) int local54 = this.vertexX[local47];
			@Pc(59) int local59 = this.vertexY[local47];
			@Pc(64) int local64 = this.vertexZ[local47];
			@Pc(76) int local76;
			if (arg2 != 0) {
				local76 = local59 * local23 + local54 * local27 >> 16;
				local59 = local59 * local27 - local54 * local23 >> 16;
				local54 = local76;
			}
			if (arg0 != 0) {
				local76 = local59 * local11 - local64 * local7 >> 16;
				local64 = local59 * local7 + local64 * local11 >> 16;
				local59 = local76;
			}
			if (arg1 != 0) {
				local76 = local64 * local15 + local54 * local19 >> 16;
				local64 = local64 * local19 - local54 * local15 >> 16;
				local54 = local76;
			}
			local54 += arg4;
			local59 += arg5;
			local64 += arg6;
			local76 = local59 * local35 - local64 * local31 >> 16;
			local64 = local59 * local31 + local64 * local35 >> 16;
			vertexScreenZ[local47] = local64 - local45;
			vertexScreenX[local47] = local1 + (local54 << 9) / local64;
			vertexScreenY[local47] = local3 + (local76 << 9) / local64;
			if (this.texturedFaceCount > 0) {
				vertexViewSpaceX[local47] = local54;
				vertexViewSpaceY[local47] = local76;
				vertexViewSpaceZ[local47] = local64;
			}
		}
		try {
			this.draw(false, false, 0);
		} catch (@Pc(223) Exception local223) {
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIIIII)V")
	public void draw(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(11) int local11 = arg7 * arg4 - arg5 * arg3 >> 16;
		@Pc(21) int local21 = arg6 * arg1 + local11 * arg2 >> 16;
		@Pc(28) int local28 = this.radius * arg2 >> 16;
		@Pc(32) int local32 = local21 + local28;
		if (local32 <= 50 || local21 >= 3500) {
			return;
		}
		@Pc(49) int local49 = arg7 * arg3 + arg5 * arg4 >> 16;
		@Pc(56) int local56 = local49 - this.radius << 9;
		if (local56 / local32 >= Draw2D.centerX2d) {
			return;
		}
		@Pc(69) int local69 = local49 + this.radius << 9;
		if (local69 / local32 <= -Draw2D.centerX2d) {
			return;
		}
		@Pc(86) int local86 = arg6 * arg2 - local11 * arg1 >> 16;
		@Pc(93) int local93 = this.radius * arg1 >> 16;
		@Pc(99) int local99 = local86 + local93 << 9;
		if (local99 / local32 <= -Draw2D.centerY2d) {
			return;
		}
		@Pc(115) int local115 = local93 + (this.maxY * arg2 >> 16);
		@Pc(121) int local121 = local86 - local115 << 9;
		if (local121 / local32 >= Draw2D.centerY2d) {
			return;
		}
		@Pc(136) int local136 = local28 + (this.maxY * arg1 >> 16);
		@Pc(138) boolean local138 = false;
		if (local21 - local136 <= 50) {
			local138 = true;
		}
		@Pc(147) boolean local147 = false;
		@Pc(155) int local155;
		@Pc(204) int local204;
		@Pc(208) int local208;
		if (arg8 > 0 && checkHover) {
			local155 = local21 - local28;
			if (local155 <= 50) {
				local155 = 50;
			}
			if (local49 > 0) {
				local56 /= local32;
				local69 /= local155;
			} else {
				local69 /= local32;
				local56 /= local155;
			}
			if (local86 > 0) {
				local121 /= local32;
				local99 /= local155;
			} else {
				local99 /= local32;
				local121 /= local155;
			}
			local204 = mouseX - Draw3D.centerX;
			local208 = mouseZ - Draw3D.centerY;
			if (local204 > local56 && local204 < local69 && local208 > local121 && local208 < local99) {
				if (this.pickable) {
					pickedBitsets[pickedCount++] = arg8;
				} else {
					local147 = true;
				}
			}
		}
		local155 = Draw3D.centerX;
		local204 = Draw3D.centerY;
		local208 = 0;
		@Pc(243) int local243 = 0;
		if (arg0 != 0) {
			local208 = sin[arg0];
			local243 = cos[arg0];
		}
		for (@Pc(255) int local255 = 0; local255 < this.vertexCount; local255++) {
			@Pc(262) int local262 = this.vertexX[local255];
			@Pc(267) int local267 = this.vertexY[local255];
			@Pc(272) int local272 = this.vertexZ[local255];
			@Pc(284) int local284;
			if (arg0 != 0) {
				local284 = local272 * local208 + local262 * local243 >> 16;
				local272 = local272 * local243 - local262 * local208 >> 16;
				local262 = local284;
			}
			local262 += arg5;
			local267 += arg6;
			local272 += arg7;
			local284 = local272 * arg3 + local262 * arg4 >> 16;
			local272 = local272 * arg4 - local262 * arg3 >> 16;
			local262 = local284;
			local284 = local267 * arg2 - local272 * arg1 >> 16;
			local272 = local267 * arg1 + local272 * arg2 >> 16;
			vertexScreenZ[local255] = local272 - local21;
			if (local272 >= 50) {
				vertexScreenX[local255] = local155 + (local262 << 9) / local272;
				vertexScreenY[local255] = local204 + (local284 << 9) / local272;
			} else {
				vertexScreenX[local255] = -5000;
				local138 = true;
			}
			if (local138 || this.texturedFaceCount > 0) {
				vertexViewSpaceX[local255] = local262;
				vertexViewSpaceY[local255] = local284;
				vertexViewSpaceZ[local255] = local272;
			}
		}
		try {
			this.draw(local138, local147, arg8);
		} catch (@Pc(418) Exception local418) {
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(ZZI)V")
	private void draw(@OriginalArg(0) boolean arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		for (@Pc(3) int local3 = 0; local3 < this.maxDepth; local3++) {
			tmpDepthFaceCount[local3] = 0;
		}
		@Pc(32) int local32;
		@Pc(37) int local37;
		@Pc(42) int local42;
		@Pc(46) int local46;
		@Pc(50) int local50;
		@Pc(54) int local54;
		@Pc(86) int local86;
		for (@Pc(16) int local16 = 0; local16 < this.faceCount; local16++) {
			if (this.faceInfo == null || this.faceInfo[local16] != -1) {
				local32 = this.faceVertexA[local16];
				local37 = this.faceVertexB[local16];
				local42 = this.faceVertexC[local16];
				local46 = vertexScreenX[local32];
				local50 = vertexScreenX[local37];
				local54 = vertexScreenX[local42];
				if (arg0 && (local46 == -5000 || local50 == -5000 || local54 == -5000)) {
					faceNearClipped[local16] = true;
					local86 = (vertexScreenZ[local32] + vertexScreenZ[local37] + vertexScreenZ[local42]) / 3 + this.minDepth;
					tmpDepthFaces[local86][tmpDepthFaceCount[local86]++] = local16;
				} else {
					if (arg1 && this.pointWithinTriangle(mouseX, mouseZ, vertexScreenY[local32], vertexScreenY[local37], vertexScreenY[local42], local46, local50, local54)) {
						pickedBitsets[pickedCount++] = arg2;
						arg1 = false;
					}
					if ((local46 - local50) * (vertexScreenY[local42] - vertexScreenY[local37]) - (vertexScreenY[local32] - vertexScreenY[local37]) * (local54 - local50) > 0) {
						faceNearClipped[local16] = false;
						if (local46 >= 0 && local50 >= 0 && local54 >= 0 && local46 <= Draw2D.boundX && local50 <= Draw2D.boundX && local54 <= Draw2D.boundX) {
							faceClippedX[local16] = false;
						} else {
							faceClippedX[local16] = true;
						}
						local86 = (vertexScreenZ[local32] + vertexScreenZ[local37] + vertexScreenZ[local42]) / 3 + this.minDepth;
						tmpDepthFaces[local86][tmpDepthFaceCount[local86]++] = local16;
					}
				}
			}
		}
		if (this.facePriority == null) {
			for (local32 = this.maxDepth - 1; local32 >= 0; local32--) {
				local37 = tmpDepthFaceCount[local32];
				if (local37 > 0) {
					@Pc(238) int[] local238 = tmpDepthFaces[local32];
					for (local46 = 0; local46 < local37; local46++) {
						this.drawFace(local238[local46]);
					}
				}
			}
			return;
		}
		for (local32 = 0; local32 < 12; local32++) {
			tmpPriorityFaceCount[local32] = 0;
			tmpPriorityDepthSum[local32] = 0;
		}
		@Pc(310) int local310;
		for (local37 = this.maxDepth - 1; local37 >= 0; local37--) {
			local42 = tmpDepthFaceCount[local37];
			if (local42 > 0) {
				@Pc(288) int[] local288 = tmpDepthFaces[local37];
				for (local50 = 0; local50 < local42; local50++) {
					local54 = local288[local50];
					local86 = this.facePriority[local54];
					local310 = tmpPriorityFaceCount[local86]++;
					tmpPriorityFaces[local86][local310] = local54;
					if (local86 < 10) {
						tmpPriorityDepthSum[local86] += local37;
					} else if (local86 == 10) {
						tmpPriority10FaceDepth[local310] = local37;
					} else {
						tmpPriority11FaceDepth[local310] = local37;
					}
				}
			}
		}
		local42 = 0;
		if (tmpPriorityFaceCount[1] > 0 || tmpPriorityFaceCount[2] > 0) {
			local42 = (tmpPriorityDepthSum[1] + tmpPriorityDepthSum[2]) / (tmpPriorityFaceCount[1] + tmpPriorityFaceCount[2]);
		}
		local46 = 0;
		if (tmpPriorityFaceCount[3] > 0 || tmpPriorityFaceCount[4] > 0) {
			local46 = (tmpPriorityDepthSum[3] + tmpPriorityDepthSum[4]) / (tmpPriorityFaceCount[3] + tmpPriorityFaceCount[4]);
		}
		local50 = 0;
		if (tmpPriorityFaceCount[6] > 0 || tmpPriorityFaceCount[8] > 0) {
			local50 = (tmpPriorityDepthSum[6] + tmpPriorityDepthSum[8]) / (tmpPriorityFaceCount[6] + tmpPriorityFaceCount[8]);
		}
		local86 = 0;
		local310 = tmpPriorityFaceCount[10];
		@Pc(436) int[] local436 = tmpPriorityFaces[10];
		@Pc(438) int[] local438 = tmpPriority10FaceDepth;
		if (local86 == local310) {
			local86 = 0;
			local310 = tmpPriorityFaceCount[11];
			local436 = tmpPriorityFaces[11];
			local438 = tmpPriority11FaceDepth;
		}
		if (local86 < local310) {
			local54 = local438[local86];
		} else {
			local54 = -1000;
		}
		for (@Pc(466) int local466 = 0; local466 < 10; local466++) {
			while (local466 == 0 && local54 > local42) {
				this.drawFace(local436[local86++]);
				if (local86 == local310 && local436 != tmpPriorityFaces[11]) {
					local86 = 0;
					local310 = tmpPriorityFaceCount[11];
					local436 = tmpPriorityFaces[11];
					local438 = tmpPriority11FaceDepth;
				}
				if (local86 < local310) {
					local54 = local438[local86];
				} else {
					local54 = -1000;
				}
			}
			while (local466 == 3 && local54 > local46) {
				this.drawFace(local436[local86++]);
				if (local86 == local310 && local436 != tmpPriorityFaces[11]) {
					local86 = 0;
					local310 = tmpPriorityFaceCount[11];
					local436 = tmpPriorityFaces[11];
					local438 = tmpPriority11FaceDepth;
				}
				if (local86 < local310) {
					local54 = local438[local86];
				} else {
					local54 = -1000;
				}
			}
			while (local466 == 5 && local54 > local50) {
				this.drawFace(local436[local86++]);
				if (local86 == local310 && local436 != tmpPriorityFaces[11]) {
					local86 = 0;
					local310 = tmpPriorityFaceCount[11];
					local436 = tmpPriorityFaces[11];
					local438 = tmpPriority11FaceDepth;
				}
				if (local86 < local310) {
					local54 = local438[local86];
				} else {
					local54 = -1000;
				}
			}
			@Pc(604) int local604 = tmpPriorityFaceCount[local466];
			@Pc(608) int[] local608 = tmpPriorityFaces[local466];
			for (@Pc(610) int local610 = 0; local610 < local604; local610++) {
				this.drawFace(local608[local610]);
			}
		}
		while (local54 != -1000) {
			this.drawFace(local436[local86++]);
			if (local86 == local310 && local436 != tmpPriorityFaces[11]) {
				local86 = 0;
				local436 = tmpPriorityFaces[11];
				local310 = tmpPriorityFaceCount[11];
				local438 = tmpPriority11FaceDepth;
			}
			if (local86 < local310) {
				local54 = local438[local86];
			} else {
				local54 = -1000;
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "f", descriptor = "(I)V")
	private void drawFace(@OriginalArg(0) int arg0) {
		if (faceNearClipped[arg0]) {
			this.drawNearClippedFace(arg0);
			return;
		}
		@Pc(14) int local14 = this.faceVertexA[arg0];
		@Pc(19) int local19 = this.faceVertexB[arg0];
		@Pc(24) int local24 = this.faceVertexC[arg0];
		Draw3D.clipX = faceClippedX[arg0];
		if (this.faceAlpha == null) {
			Draw3D.alpha = 0;
		} else {
			Draw3D.alpha = this.faceAlpha[arg0];
		}
		@Pc(45) int local45;
		if (this.faceInfo == null) {
			local45 = 0;
		} else {
			local45 = this.faceInfo[arg0] & 0x3;
		}
		if (local45 == 0) {
			Draw3D.fillGouraudTriangle(vertexScreenY[local14], vertexScreenY[local19], vertexScreenY[local24], vertexScreenX[local14], vertexScreenX[local19], vertexScreenX[local24], this.faceColorA[arg0], this.faceColorB[arg0], this.faceColorC[arg0]);
		} else if (local45 == 1) {
			Draw3D.fillTriangle(vertexScreenY[local14], vertexScreenY[local19], vertexScreenY[local24], vertexScreenX[local14], vertexScreenX[local19], vertexScreenX[local24], palette[this.faceColorA[arg0]]);
		} else {
			@Pc(127) int local127;
			@Pc(132) int local132;
			@Pc(137) int local137;
			@Pc(142) int local142;
			if (local45 == 2) {
				local127 = this.faceInfo[arg0] >> 2;
				local132 = this.texturedVertexA[local127];
				local137 = this.texturedVertexB[local127];
				local142 = this.texturedVertexC[local127];
				Draw3D.fillTexturedTriangle(vertexScreenY[local14], vertexScreenY[local19], vertexScreenY[local24], vertexScreenX[local14], vertexScreenX[local19], vertexScreenX[local24], this.faceColorA[arg0], this.faceColorB[arg0], this.faceColorC[arg0], vertexViewSpaceX[local132], vertexViewSpaceX[local137], vertexViewSpaceX[local142], vertexViewSpaceY[local132], vertexViewSpaceY[local137], vertexViewSpaceY[local142], vertexViewSpaceZ[local132], vertexViewSpaceZ[local137], vertexViewSpaceZ[local142], this.faceColor[arg0]);
			} else if (local45 == 3) {
				local127 = this.faceInfo[arg0] >> 2;
				local132 = this.texturedVertexA[local127];
				local137 = this.texturedVertexB[local127];
				local142 = this.texturedVertexC[local127];
				Draw3D.fillTexturedTriangle(vertexScreenY[local14], vertexScreenY[local19], vertexScreenY[local24], vertexScreenX[local14], vertexScreenX[local19], vertexScreenX[local24], this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[local132], vertexViewSpaceX[local137], vertexViewSpaceX[local142], vertexViewSpaceY[local132], vertexViewSpaceY[local137], vertexViewSpaceY[local142], vertexViewSpaceZ[local132], vertexViewSpaceZ[local137], vertexViewSpaceZ[local142], this.faceColor[arg0]);
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "g", descriptor = "(I)V")
	private void drawNearClippedFace(@OriginalArg(0) int arg0) {
		@Pc(3) int local3 = Draw3D.centerX;
		@Pc(5) int local5 = Draw3D.centerY;
		@Pc(7) int local7 = 0;
		@Pc(12) int local12 = this.faceVertexA[arg0];
		@Pc(17) int local17 = this.faceVertexB[arg0];
		@Pc(22) int local22 = this.faceVertexC[arg0];
		@Pc(26) int local26 = vertexViewSpaceZ[local12];
		@Pc(30) int local30 = vertexViewSpaceZ[local17];
		@Pc(34) int local34 = vertexViewSpaceZ[local22];
		@Pc(63) int local63;
		@Pc(67) int local67;
		@Pc(72) int local72;
		@Pc(85) int local85;
		if (local26 >= 50) {
			clippedX[local7] = vertexScreenX[local12];
			clippedY[local7] = vertexScreenY[local12];
			clippedColor[local7++] = this.faceColorA[arg0];
		} else {
			local63 = vertexViewSpaceX[local12];
			local67 = vertexViewSpaceY[local12];
			local72 = this.faceColorA[arg0];
			if (local34 >= 50) {
				local85 = (50 - local26) * reciprical16[local34 - local26];
				clippedX[local7] = local3 + (local63 + ((vertexViewSpaceX[local22] - local63) * local85 >> 16) << 9) / 50;
				clippedY[local7] = local5 + (local67 + ((vertexViewSpaceY[local22] - local67) * local85 >> 16) << 9) / 50;
				clippedColor[local7++] = local72 + ((this.faceColorC[arg0] - local72) * local85 >> 16);
			}
			if (local30 >= 50) {
				local85 = (50 - local26) * reciprical16[local30 - local26];
				clippedX[local7] = local3 + (local63 + ((vertexViewSpaceX[local17] - local63) * local85 >> 16) << 9) / 50;
				clippedY[local7] = local5 + (local67 + ((vertexViewSpaceY[local17] - local67) * local85 >> 16) << 9) / 50;
				clippedColor[local7++] = local72 + ((this.faceColorB[arg0] - local72) * local85 >> 16);
			}
		}
		if (local30 >= 50) {
			clippedX[local7] = vertexScreenX[local17];
			clippedY[local7] = vertexScreenY[local17];
			clippedColor[local7++] = this.faceColorB[arg0];
		} else {
			local63 = vertexViewSpaceX[local17];
			local67 = vertexViewSpaceY[local17];
			local72 = this.faceColorB[arg0];
			if (local26 >= 50) {
				local85 = (50 - local30) * reciprical16[local26 - local30];
				clippedX[local7] = local3 + (local63 + ((vertexViewSpaceX[local12] - local63) * local85 >> 16) << 9) / 50;
				clippedY[local7] = local5 + (local67 + ((vertexViewSpaceY[local12] - local67) * local85 >> 16) << 9) / 50;
				clippedColor[local7++] = local72 + ((this.faceColorA[arg0] - local72) * local85 >> 16);
			}
			if (local34 >= 50) {
				local85 = (50 - local30) * reciprical16[local34 - local30];
				clippedX[local7] = local3 + (local63 + ((vertexViewSpaceX[local22] - local63) * local85 >> 16) << 9) / 50;
				clippedY[local7] = local5 + (local67 + ((vertexViewSpaceY[local22] - local67) * local85 >> 16) << 9) / 50;
				clippedColor[local7++] = local72 + ((this.faceColorC[arg0] - local72) * local85 >> 16);
			}
		}
		if (local34 >= 50) {
			clippedX[local7] = vertexScreenX[local22];
			clippedY[local7] = vertexScreenY[local22];
			clippedColor[local7++] = this.faceColorC[arg0];
		} else {
			local63 = vertexViewSpaceX[local22];
			local67 = vertexViewSpaceY[local22];
			local72 = this.faceColorC[arg0];
			if (local30 >= 50) {
				local85 = (50 - local34) * reciprical16[local30 - local34];
				clippedX[local7] = local3 + (local63 + ((vertexViewSpaceX[local17] - local63) * local85 >> 16) << 9) / 50;
				clippedY[local7] = local5 + (local67 + ((vertexViewSpaceY[local17] - local67) * local85 >> 16) << 9) / 50;
				clippedColor[local7++] = local72 + ((this.faceColorB[arg0] - local72) * local85 >> 16);
			}
			if (local26 >= 50) {
				local85 = (50 - local34) * reciprical16[local26 - local34];
				clippedX[local7] = local3 + (local63 + ((vertexViewSpaceX[local12] - local63) * local85 >> 16) << 9) / 50;
				clippedY[local7] = local5 + (local67 + ((vertexViewSpaceY[local12] - local67) * local85 >> 16) << 9) / 50;
				clippedColor[local7++] = local72 + ((this.faceColorA[arg0] - local72) * local85 >> 16);
			}
		}
		local63 = clippedX[0];
		local67 = clippedX[1];
		local72 = clippedX[2];
		local85 = clippedY[0];
		@Pc(582) int local582 = clippedY[1];
		@Pc(586) int local586 = clippedY[2];
		if ((local63 - local67) * (local586 - local582) - (local85 - local582) * (local72 - local67) <= 0) {
			return;
		}
		Draw3D.clipX = false;
		@Pc(629) int local629;
		@Pc(686) int local686;
		@Pc(691) int local691;
		@Pc(696) int local696;
		@Pc(701) int local701;
		if (local7 == 3) {
			if (local63 < 0 || local67 < 0 || local72 < 0 || local63 > Draw2D.boundX || local67 > Draw2D.boundX || local72 > Draw2D.boundX) {
				Draw3D.clipX = true;
			}
			if (this.faceInfo == null) {
				local629 = 0;
			} else {
				local629 = this.faceInfo[arg0] & 0x3;
			}
			if (local629 == 0) {
				Draw3D.fillGouraudTriangle(local85, local582, local586, local63, local67, local72, clippedColor[0], clippedColor[1], clippedColor[2]);
			} else if (local629 == 1) {
				Draw3D.fillTriangle(local85, local582, local586, local63, local67, local72, palette[this.faceColorA[arg0]]);
			} else if (local629 == 2) {
				local686 = this.faceInfo[arg0] >> 2;
				local691 = this.texturedVertexA[local686];
				local696 = this.texturedVertexB[local686];
				local701 = this.texturedVertexC[local686];
				Draw3D.fillTexturedTriangle(local85, local582, local586, local63, local67, local72, clippedColor[0], clippedColor[1], clippedColor[2], vertexViewSpaceX[local691], vertexViewSpaceX[local696], vertexViewSpaceX[local701], vertexViewSpaceY[local691], vertexViewSpaceY[local696], vertexViewSpaceY[local701], vertexViewSpaceZ[local691], vertexViewSpaceZ[local696], vertexViewSpaceZ[local701], this.faceColor[arg0]);
			} else if (local629 == 3) {
				local686 = this.faceInfo[arg0] >> 2;
				local691 = this.texturedVertexA[local686];
				local696 = this.texturedVertexB[local686];
				local701 = this.texturedVertexC[local686];
				Draw3D.fillTexturedTriangle(local85, local582, local586, local63, local67, local72, this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[local691], vertexViewSpaceX[local696], vertexViewSpaceX[local701], vertexViewSpaceY[local691], vertexViewSpaceY[local696], vertexViewSpaceY[local701], vertexViewSpaceZ[local691], vertexViewSpaceZ[local696], vertexViewSpaceZ[local701], this.faceColor[arg0]);
			}
		}
		if (local7 != 4) {
			return;
		}
		if (local63 < 0 || local67 < 0 || local72 < 0 || local63 > Draw2D.boundX || local67 > Draw2D.boundX || local72 > Draw2D.boundX || clippedX[3] < 0 || clippedX[3] > Draw2D.boundX) {
			Draw3D.clipX = true;
		}
		if (this.faceInfo == null) {
			local629 = 0;
		} else {
			local629 = this.faceInfo[arg0] & 0x3;
		}
		if (local629 == 0) {
			Draw3D.fillGouraudTriangle(local85, local582, local586, local63, local67, local72, clippedColor[0], clippedColor[1], clippedColor[2]);
			Draw3D.fillGouraudTriangle(local85, local586, clippedY[3], local63, local72, clippedX[3], clippedColor[0], clippedColor[2], clippedColor[3]);
			return;
		}
		if (local629 == 1) {
			local686 = palette[this.faceColorA[arg0]];
			Draw3D.fillTriangle(local85, local582, local586, local63, local67, local72, local686);
			Draw3D.fillTriangle(local85, local586, clippedY[3], local63, local72, clippedX[3], local686);
			return;
		}
		if (local629 == 2) {
			local686 = this.faceInfo[arg0] >> 2;
			local691 = this.texturedVertexA[local686];
			local696 = this.texturedVertexB[local686];
			local701 = this.texturedVertexC[local686];
			Draw3D.fillTexturedTriangle(local85, local582, local586, local63, local67, local72, clippedColor[0], clippedColor[1], clippedColor[2], vertexViewSpaceX[local691], vertexViewSpaceX[local696], vertexViewSpaceX[local701], vertexViewSpaceY[local691], vertexViewSpaceY[local696], vertexViewSpaceY[local701], vertexViewSpaceZ[local691], vertexViewSpaceZ[local696], vertexViewSpaceZ[local701], this.faceColor[arg0]);
			Draw3D.fillTexturedTriangle(local85, local586, clippedY[3], local63, local72, clippedX[3], clippedColor[0], clippedColor[2], clippedColor[3], vertexViewSpaceX[local691], vertexViewSpaceX[local696], vertexViewSpaceX[local701], vertexViewSpaceY[local691], vertexViewSpaceY[local696], vertexViewSpaceY[local701], vertexViewSpaceZ[local691], vertexViewSpaceZ[local696], vertexViewSpaceZ[local701], this.faceColor[arg0]);
			return;
		}
		if (local629 != 3) {
			return;
		}
		local686 = this.faceInfo[arg0] >> 2;
		local691 = this.texturedVertexA[local686];
		local696 = this.texturedVertexB[local686];
		local701 = this.texturedVertexC[local686];
		Draw3D.fillTexturedTriangle(local85, local582, local586, local63, local67, local72, this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[local691], vertexViewSpaceX[local696], vertexViewSpaceX[local701], vertexViewSpaceY[local691], vertexViewSpaceY[local696], vertexViewSpaceY[local701], vertexViewSpaceZ[local691], vertexViewSpaceZ[local696], vertexViewSpaceZ[local701], this.faceColor[arg0]);
		Draw3D.fillTexturedTriangle(local85, local586, clippedY[3], local63, local72, clippedX[3], this.faceColorA[arg0], this.faceColorA[arg0], this.faceColorA[arg0], vertexViewSpaceX[local691], vertexViewSpaceX[local696], vertexViewSpaceX[local701], vertexViewSpaceY[local691], vertexViewSpaceY[local696], vertexViewSpaceY[local701], vertexViewSpaceZ[local691], vertexViewSpaceZ[local696], vertexViewSpaceZ[local701], this.faceColor[arg0]);
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIIII)Z")
	private boolean pointWithinTriangle(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else {
			return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
		}
	}

	@OriginalClass("client!l")
	public static final class Metadata {

		@OriginalMember(owner = "client!l", name = "a", descriptor = "I")
		public int vertexCount;

		@OriginalMember(owner = "client!l", name = "b", descriptor = "I")
		public int faceCount;

		@OriginalMember(owner = "client!l", name = "c", descriptor = "I")
		public int texturedFaceCount;

		@OriginalMember(owner = "client!l", name = "d", descriptor = "I")
		public int vertexFlagsOffset;

		@OriginalMember(owner = "client!l", name = "e", descriptor = "I")
		public int vertexXOffset;

		@OriginalMember(owner = "client!l", name = "f", descriptor = "I")
		public int vertexYOffset;

		@OriginalMember(owner = "client!l", name = "g", descriptor = "I")
		public int vertexZOffset;

		@OriginalMember(owner = "client!l", name = "h", descriptor = "I")
		public int vertexLabelsOffset;

		@OriginalMember(owner = "client!l", name = "i", descriptor = "I")
		public int faceVerticesOffset;

		@OriginalMember(owner = "client!l", name = "j", descriptor = "I")
		public int faceOrientationsOffset;

		@OriginalMember(owner = "client!l", name = "k", descriptor = "I")
		public int faceColorsOffset;

		@OriginalMember(owner = "client!l", name = "l", descriptor = "I")
		public int faceInfosOffset;

		@OriginalMember(owner = "client!l", name = "m", descriptor = "I")
		public int facePrioritiesOffset;

		@OriginalMember(owner = "client!l", name = "n", descriptor = "I")
		public int faceAlphasOffset;

		@OriginalMember(owner = "client!l", name = "o", descriptor = "I")
		public int faceLabelsOffset;

		@OriginalMember(owner = "client!l", name = "p", descriptor = "I")
		public int faceTextureAxisOffset;
	}

	@OriginalClass("client!n")
	public static final class VertexNormal {

		@OriginalMember(owner = "client!n", name = "a", descriptor = "I")
		public int x;

		@OriginalMember(owner = "client!n", name = "b", descriptor = "I")
		public int y;

		@OriginalMember(owner = "client!n", name = "c", descriptor = "I")
		public int z;

		@OriginalMember(owner = "client!n", name = "d", descriptor = "I")
		public int w;
	}

}
