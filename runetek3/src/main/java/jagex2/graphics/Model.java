package jagex2.graphics;

import jagex2.datastruct.Hashable;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!eb")
public class Model extends Hashable {

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
	public Model(@OriginalArg(1) int id) {
		if (metadata == null) {
			return;
		}

		@Pc(28) Metadata meta = metadata[id];
		if (meta == null) {
			System.out.println("Error model:" + id + " not found!");
		} else {
			this.vertexCount = meta.vertexCount;
			this.faceCount = meta.faceCount;
			this.texturedFaceCount = meta.texturedFaceCount;
			this.vertexX = new int[this.vertexCount];
			this.vertexY = new int[this.vertexCount];
			this.vertexZ = new int[this.vertexCount];
			this.faceVertexA = new int[this.faceCount];
			this.faceVertexB = new int[this.faceCount];
			this.faceVertexC = new int[this.faceCount];
			this.texturedVertexA = new int[this.texturedFaceCount];
			this.texturedVertexB = new int[this.texturedFaceCount];
			this.texturedVertexC = new int[this.texturedFaceCount];

			if (meta.vertexLabelsOffset >= 0) {
				this.vertexLabel = new int[this.vertexCount];
			}

			if (meta.faceInfosOffset >= 0) {
				this.faceInfo = new int[this.faceCount];
			}

			if (meta.facePrioritiesOffset >= 0) {
				this.facePriority = new int[this.faceCount];
			} else {
				this.priority = -meta.facePrioritiesOffset - 1;
			}

			if (meta.faceAlphasOffset >= 0) {
				this.faceAlpha = new int[this.faceCount];
			}

			if (meta.faceLabelsOffset >= 0) {
				this.faceLabel = new int[this.faceCount];
			}

			this.faceColor = new int[this.faceCount];

			point1.pos = meta.vertexFlagsOffset;
			point2.pos = meta.vertexXOffset;
			point3.pos = meta.vertexYOffset;
			point4.pos = meta.vertexZOffset;
			point5.pos = meta.vertexLabelsOffset;

			@Pc(175) int dx = 0;
			@Pc(177) int db = 0;
			@Pc(179) int dc = 0;
			@Pc(188) int a;
			@Pc(197) int b;
			@Pc(206) int c;

			for (@Pc(181) int v = 0; v < this.vertexCount; v++) {
				int flags = point1.g1();
				a = 0;
				if ((flags & 0x1) != 0) {
					a = point2.gsmart();
				}

				b = 0;
				if ((flags & 0x2) != 0) {
					b = point3.gsmart();
				}

				c = 0;
				if ((flags & 0x4) != 0) {
					c = point4.gsmart();
				}

				this.vertexX[v] = dx + a;
				this.vertexY[v] = db + b;
				this.vertexZ[v] = dc + c;
				dx = this.vertexX[v];
				db = this.vertexY[v];
				dc = this.vertexZ[v];

				if (this.vertexLabel != null) {
					this.vertexLabel[v] = point5.g1();
				}
			}

			face1.pos = meta.faceColorsOffset;
			face2.pos = meta.faceInfosOffset;
			face3.pos = meta.facePrioritiesOffset;
			face4.pos = meta.faceAlphasOffset;
			face5.pos = meta.faceLabelsOffset;
			for (int f = 0; f < this.faceCount; f++) {
				this.faceColor[f] = face1.g2();
				if (this.faceInfo != null) {
					this.faceInfo[f] = face2.g1();
				}

				if (this.facePriority != null) {
					this.facePriority[f] = face3.g1();
				}

				if (this.faceAlpha != null) {
					this.faceAlpha[f] = face4.g1();
				}

				if (this.faceLabel != null) {
					this.faceLabel[f] = face5.g1();
				}
			}

			vertex1.pos = meta.faceVerticesOffset;
			vertex2.pos = meta.faceOrientationsOffset;

			a = 0;
			b = 0;
			c = 0;
			@Pc(350) int last = 0;

			for (@Pc(352) int f = 0; f < this.faceCount; f++) {
				int orientation = vertex2.g1();

				if (orientation == 1) {
					a = vertex1.gsmart() + last;
					b = vertex1.gsmart() + a;
					c = vertex1.gsmart() + b;
					last = c;
					this.faceVertexA[f] = a;
					this.faceVertexB[f] = b;
					this.faceVertexC[f] = c;
				} else if (orientation == 2) {
					a = a;
					b = c;
					c = vertex1.gsmart() + last;
					last = c;
					this.faceVertexA[f] = a;
					this.faceVertexB[f] = b;
					this.faceVertexC[f] = c;
				} else if (orientation == 3) {
					a = c;
					b = b;
					c = vertex1.gsmart() + last;
					last = c;
					this.faceVertexA[f] = a;
					this.faceVertexB[f] = b;
					this.faceVertexC[f] = c;
				} else if (orientation == 4) {
					@Pc(459) int tmp = a;
					a = b;
					b = tmp;
					c = vertex1.gsmart() + last;
					last = c;
					this.faceVertexA[f] = a;
					this.faceVertexB[f] = tmp;
					this.faceVertexC[f] = c;
				}
			}

			axis.pos = meta.faceTextureAxisOffset * 6;
			for (int f = 0; f < this.texturedFaceCount; f++) {
				this.texturedVertexA[f] = axis.g2();
				this.texturedVertexB[f] = axis.g2();
				this.texturedVertexC[f] = axis.g2();
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(I[Lclient!eb;I)V")
	public Model(@OriginalArg(1) Model[] models, @OriginalArg(2) int count) {
		@Pc(23) boolean copyInfo = false;
		@Pc(25) boolean copyPriorities = false;
		@Pc(27) boolean copyAlpha = false;
		@Pc(29) boolean copyLabels = false;

		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		this.priority = -1;

		for (@Pc(43) int i = 0; i < count; i++) {
			@Pc(49) Model model = models[i];
			if (model != null) {
				this.vertexCount += model.vertexCount;
				this.faceCount += model.faceCount;
				this.texturedFaceCount += model.texturedFaceCount;
				copyInfo |= model.faceInfo != null;

				if (model.facePriority == null) {
					if (this.priority == -1) {
						this.priority = model.priority;
					}

					if (this.priority != model.priority) {
						copyPriorities = true;
					}
				} else {
					copyPriorities = true;
				}

				copyAlpha |= model.faceAlpha != null;
				copyLabels |= model.faceLabel != null;
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

		if (copyInfo) {
			this.faceInfo = new int[this.faceCount];
		}

		if (copyPriorities) {
			this.facePriority = new int[this.faceCount];
		}

		if (copyAlpha) {
			this.faceAlpha = new int[this.faceCount];
		}

		if (copyLabels) {
			this.faceLabel = new int[this.faceCount];
		}

		this.faceColor = new int[this.faceCount];
		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;

		for (@Pc(225) int i = 0; i < count; i++) {
			@Pc(231) Model model = models[i];

			if (model != null) {
				for (@Pc(235) int face = 0; face < model.faceCount; face++) {
					if (copyInfo) {
						if (model.faceInfo == null) {
							this.faceInfo[this.faceCount] = 0;
						} else {
							this.faceInfo[this.faceCount] = model.faceInfo[face];
						}
					}

					if (copyPriorities) {
						if (model.facePriority == null) {
							this.facePriority[this.faceCount] = model.priority;
						} else {
							this.facePriority[this.faceCount] = model.facePriority[face];
						}
					}

					if (copyAlpha) {
						if (model.faceAlpha == null) {
							this.faceAlpha[this.faceCount] = 0;
						} else {
							this.faceAlpha[this.faceCount] = model.faceAlpha[face];
						}
					}

					if (copyLabels && model.faceLabel != null) {
						this.faceLabel[this.faceCount] = model.faceLabel[face];
					}

					this.faceColor[this.faceCount] = model.faceColor[face];
					this.faceVertexA[this.faceCount] = this.addVertex(model, model.faceVertexA[face]);
					this.faceVertexB[this.faceCount] = this.addVertex(model, model.faceVertexB[face]);
					this.faceVertexC[this.faceCount] = this.addVertex(model, model.faceVertexC[face]);
					this.faceCount++;
				}

				for (@Pc(376) int f = 0; f < model.texturedFaceCount; f++) {
					this.texturedVertexA[this.texturedFaceCount] = this.addVertex(model, model.texturedVertexA[f]);
					this.texturedVertexB[this.texturedFaceCount] = this.addVertex(model, model.texturedVertexB[f]);
					this.texturedVertexC[this.texturedFaceCount] = this.addVertex(model, model.texturedVertexC[f]);
					this.texturedFaceCount++;
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "([Lclient!eb;BIZ)V")
	public Model(@OriginalArg(0) Model[] models, @OriginalArg(2) int count, @OriginalArg(3) boolean dummy) {
		@Pc(23) boolean copyInfo = false;
		@Pc(25) boolean copyPriority = false;
		@Pc(27) boolean copyAlpha = false;
		@Pc(29) boolean copyColor = false;

		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;
		this.priority = -1;

		for (@Pc(43) int i = 0; i < count; i++) {
			@Pc(49) Model model = models[i];
			if (model != null) {
				this.vertexCount += model.vertexCount;
				this.faceCount += model.faceCount;
				this.texturedFaceCount += model.texturedFaceCount;

				copyInfo |= model.faceInfo != null;

				if (model.facePriority == null) {
					if (this.priority == -1) {
						this.priority = model.priority;
					}
					if (this.priority != model.priority) {
						copyPriority = true;
					}
				} else {
					copyPriority = true;
				}

				copyAlpha |= model.faceAlpha != null;
				copyColor |= model.faceColor != null;
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

		if (copyInfo) {
			this.faceInfo = new int[this.faceCount];
		}

		if (copyPriority) {
			this.facePriority = new int[this.faceCount];
		}

		if (copyAlpha) {
			this.faceAlpha = new int[this.faceCount];
		}

		if (copyColor) {
			this.faceColor = new int[this.faceCount];
		}

		this.vertexCount = 0;
		this.faceCount = 0;
		this.texturedFaceCount = 0;

		@Pc(227) int i;
		for (i = 0; i < count; i++) {
			@Pc(240) Model model = models[i];
			if (model != null) {
				@Pc(245) int vertexCount = this.vertexCount;

				for (@Pc(247) int v = 0; v < model.vertexCount; v++) {
					this.vertexX[this.vertexCount] = model.vertexX[v];
					this.vertexY[this.vertexCount] = model.vertexY[v];
					this.vertexZ[this.vertexCount] = model.vertexZ[v];
					this.vertexCount++;
				}

				for (@Pc(289) int f = 0; f < model.faceCount; f++) {
					this.faceVertexA[this.faceCount] = model.faceVertexA[f] + vertexCount;
					this.faceVertexB[this.faceCount] = model.faceVertexB[f] + vertexCount;
					this.faceVertexC[this.faceCount] = model.faceVertexC[f] + vertexCount;
					this.faceColorA[this.faceCount] = model.faceColorA[f];
					this.faceColorB[this.faceCount] = model.faceColorB[f];
					this.faceColorC[this.faceCount] = model.faceColorC[f];

					if (copyInfo) {
						if (model.faceInfo == null) {
							this.faceInfo[this.faceCount] = 0;
						} else {
							this.faceInfo[this.faceCount] = model.faceInfo[f];
						}
					}

					if (copyPriority) {
						if (model.facePriority == null) {
							this.facePriority[this.faceCount] = model.priority;
						} else {
							this.facePriority[this.faceCount] = model.facePriority[f];
						}
					}

					if (copyAlpha) {
						if (model.faceAlpha == null) {
							this.faceAlpha[this.faceCount] = 0;
						} else {
							this.faceAlpha[this.faceCount] = model.faceAlpha[f];
						}
					}

					if (copyColor && model.faceColor != null) {
						this.faceColor[this.faceCount] = model.faceColor[f];
					}

					this.faceCount++;
				}

				for (@Pc(445) int f = 0; f < model.texturedFaceCount; f++) {
					this.texturedVertexA[this.texturedFaceCount] = model.texturedVertexA[f] + vertexCount;
					this.texturedVertexB[this.texturedFaceCount] = model.texturedVertexB[f] + vertexCount;
					this.texturedVertexC[this.texturedFaceCount] = model.texturedVertexC[f] + vertexCount;
					this.texturedFaceCount++;
				}
			}
		}

		this.calculateBoundsCylinder();
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(Lclient!eb;ZZIZ)V")
	public Model(@OriginalArg(0) Model src, @OriginalArg(1) boolean shareColors, @OriginalArg(2) boolean shareAlpha, @OriginalArg(4) boolean shareVertices) {
		this.vertexCount = src.vertexCount;
		this.faceCount = src.faceCount;
		this.texturedFaceCount = src.texturedFaceCount;

		if (shareVertices) {
			this.vertexX = src.vertexX;
			this.vertexY = src.vertexY;
			this.vertexZ = src.vertexZ;
		} else {
			this.vertexX = new int[this.vertexCount];
			this.vertexY = new int[this.vertexCount];
			this.vertexZ = new int[this.vertexCount];

			for (int v = 0; v < this.vertexCount; v++) {
				this.vertexX[v] = src.vertexX[v];
				this.vertexY[v] = src.vertexY[v];
				this.vertexZ[v] = src.vertexZ[v];
			}
		}

		if (shareColors) {
			this.faceColor = src.faceColor;
		} else {
			this.faceColor = new int[this.faceCount];
			System.arraycopy(src.faceColor, 0, this.faceColor, 0, this.faceCount);
		}

		if (shareAlpha) {
			this.faceAlpha = src.faceAlpha;
		} else {
			this.faceAlpha = new int[this.faceCount];
			if (src.faceAlpha == null) {
				for (int f = 0; f < this.faceCount; f++) {
					this.faceAlpha[f] = 0;
				}
			} else {
				System.arraycopy(src.faceAlpha, 0, this.faceAlpha, 0, this.faceCount);
			}
		}

		this.vertexLabel = src.vertexLabel;
		this.faceLabel = src.faceLabel;
		this.faceInfo = src.faceInfo;
		this.faceVertexA = src.faceVertexA;
		this.faceVertexB = src.faceVertexB;
		this.faceVertexC = src.faceVertexC;
		this.facePriority = src.facePriority;
		this.priority = src.priority;
		this.texturedVertexA = src.texturedVertexA;
		this.texturedVertexB = src.texturedVertexB;
		this.texturedVertexC = src.texturedVertexC;
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(Lclient!eb;BZZ)V")
	public Model(@OriginalArg(0) Model src, @OriginalArg(2) boolean copyVertexY, @OriginalArg(3) boolean copyFaces) {
		this.vertexCount = src.vertexCount;
		this.faceCount = src.faceCount;
		this.texturedFaceCount = src.texturedFaceCount;

		if (copyVertexY) {
			this.vertexY = new int[this.vertexCount];
			System.arraycopy(src.vertexY, 0, this.vertexY, 0, this.vertexCount);
		} else {
			this.vertexY = src.vertexY;
		}

		if (copyFaces) {
			this.faceColorA = new int[this.faceCount];
			this.faceColorB = new int[this.faceCount];
			this.faceColorC = new int[this.faceCount];
			for (int f = 0; f < this.faceCount; f++) {
				this.faceColorA[f] = src.faceColorA[f];
				this.faceColorB[f] = src.faceColorB[f];
				this.faceColorC[f] = src.faceColorC[f];
			}

			this.faceInfo = new int[this.faceCount];
			if (src.faceInfo == null) {
				for (int f = 0; f < this.faceCount; f++) {
					this.faceInfo[f] = 0;
				}
			} else {
				System.arraycopy(src.faceInfo, 0, this.faceInfo, 0, this.faceCount);
			}

			this.vertexNormal = new VertexNormal[this.vertexCount];
			for (int v = 0; v < this.vertexCount; v++) {
				@Pc(170) VertexNormal copy = this.vertexNormal[v] = new VertexNormal();
				@Pc(175) VertexNormal original = src.vertexNormal[v];
				copy.x = original.x;
				copy.y = original.y;
				copy.z = original.z;
				copy.w = original.w;
			}

			this.vertexNormalOriginal = src.vertexNormalOriginal;
		} else {
			this.faceColorA = src.faceColorA;
			this.faceColorB = src.faceColorB;
			this.faceColorC = src.faceColorC;
			this.faceInfo = src.faceInfo;
		}

		this.vertexX = src.vertexX;
		this.vertexZ = src.vertexZ;
		this.faceColor = src.faceColor;
		this.faceAlpha = src.faceAlpha;
		this.facePriority = src.facePriority;
		this.priority = src.priority;
		this.faceVertexA = src.faceVertexA;
		this.faceVertexB = src.faceVertexB;
		this.faceVertexC = src.faceVertexC;
		this.texturedVertexA = src.texturedVertexA;
		this.texturedVertexB = src.texturedVertexB;
		this.texturedVertexC = src.texturedVertexC;
		this.maxY = src.maxY;
		this.minY = src.minY;
		this.radius = src.radius;
		this.minDepth = src.minDepth;
		this.maxDepth = src.maxDepth;
		this.minX = src.minX;
		this.maxZ = src.maxZ;
		this.minZ = src.minZ;
		this.maxX = src.maxX;
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(ILclient!eb;Z)V")
	public Model(@OriginalArg(1) Model src, @OriginalArg(2) boolean shareAlpha) {
		this.vertexCount = src.vertexCount;
		this.faceCount = src.faceCount;
		this.texturedFaceCount = src.texturedFaceCount;

		this.vertexX = new int[this.vertexCount];
		this.vertexY = new int[this.vertexCount];
		this.vertexZ = new int[this.vertexCount];

		for (@Pc(50) int v = 0; v < this.vertexCount; v++) {
			this.vertexX[v] = src.vertexX[v];
			this.vertexY[v] = src.vertexY[v];
			this.vertexZ[v] = src.vertexZ[v];
		}

		if (shareAlpha) {
			this.faceAlpha = src.faceAlpha;
		} else {
			this.faceAlpha = new int[this.faceCount];
			if (src.faceAlpha == null) {
				for (int f = 0; f < this.faceCount; f++) {
					this.faceAlpha[f] = 0;
				}
			} else {
				System.arraycopy(src.faceAlpha, 0, this.faceAlpha, 0, this.faceCount);
			}
		}

		this.faceInfo = src.faceInfo;
		this.faceColor = src.faceColor;
		this.facePriority = src.facePriority;
		this.priority = src.priority;
		this.labelFaces = src.labelFaces;
		this.labelVertices = src.labelVertices;
		this.faceVertexA = src.faceVertexA;
		this.faceVertexB = src.faceVertexB;
		this.faceVertexC = src.faceVertexC;
		this.faceColorA = src.faceColorA;
		this.faceColorB = src.faceColorB;
		this.faceColorC = src.faceColorC;
		this.texturedVertexA = src.texturedVertexA;
		this.texturedVertexB = src.texturedVertexB;
		this.texturedVertexC = src.texturedVertexC;
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
	public static void unpack(@OriginalArg(1) Jagfile models) {
		try {
			head = new Packet(models.read("ob_head.dat", null));
			face1 = new Packet(models.read("ob_face1.dat", null));
			face2 = new Packet(models.read("ob_face2.dat", null));
			face3 = new Packet(models.read("ob_face3.dat", null));
			face4 = new Packet(models.read("ob_face4.dat", null));
			face5 = new Packet(models.read("ob_face5.dat", null));
			point1 = new Packet(models.read("ob_point1.dat", null));
			point2 = new Packet(models.read("ob_point2.dat", null));
			point3 = new Packet(models.read("ob_point3.dat", null));
			point4 = new Packet(models.read("ob_point4.dat", null));
			point5 = new Packet(models.read("ob_point5.dat", null));
			vertex1 = new Packet(models.read("ob_vertex1.dat", null));
			vertex2 = new Packet(models.read("ob_vertex2.dat", null));
			axis = new Packet(models.read("ob_axis.dat", null));
			head.pos = 0;
			point1.pos = 0;
			point2.pos = 0;
			point3.pos = 0;
			point4.pos = 0;
			vertex1.pos = 0;
			vertex2.pos = 0;
			@Pc(172) int count = head.g2();
			metadata = new Metadata[count + 100];
			@Pc(179) int vertexTextureDataOffset = 0;
			@Pc(181) int labelDataOffset = 0;
			@Pc(183) int triangleColorDataOffset = 0;
			@Pc(185) int triangleInfoDataOffset = 0;
			@Pc(187) int trianglePriorityDataOffset = 0;
			@Pc(189) int triangleAlphaDataOffset = 0;
			@Pc(191) int triangleSkinDataOffset = 0;
			for (@Pc(193) int i = 0; i < count; i++) {
				@Pc(198) int index = head.g2();
				@Pc(206) Metadata meta = metadata[index] = new Metadata();
				meta.vertexCount = head.g2();
				meta.faceCount = head.g2();
				meta.texturedFaceCount = head.g1();
				meta.vertexFlagsOffset = point1.pos;
				meta.vertexXOffset = point2.pos;
				meta.vertexYOffset = point3.pos;
				meta.vertexZOffset = point4.pos;
				meta.faceVerticesOffset = vertex1.pos;
				meta.faceOrientationsOffset = vertex2.pos;
				@Pc(245) int hasInfo = head.g1();
				@Pc(248) int hasPriorities = head.g1();
				@Pc(251) int hasAlpha = head.g1();
				@Pc(254) int hasSkins = head.g1();
				@Pc(257) int hasLabels = head.g1();
				for (@Pc(259) int v = 0; v < meta.vertexCount; v++) {
					int flags = point1.g1();
					if ((flags & 0x1) != 0) {
						point2.gsmart();
					}
					if ((flags & 0x2) != 0) {
						point3.gsmart();
					}
					if ((flags & 0x4) != 0) {
						point4.gsmart();
					}
				}
				for (int f = 0; f < meta.faceCount; f++) {
					@Pc(297) int type = vertex2.g1();
					if (type == 1) {
						vertex1.gsmart();
						vertex1.gsmart();
					}
					vertex1.gsmart();
				}
				meta.faceColorsOffset = triangleColorDataOffset;
				triangleColorDataOffset += meta.faceCount * 2;
				if (hasInfo == 1) {
					meta.faceInfosOffset = triangleInfoDataOffset;
					triangleInfoDataOffset += meta.faceCount;
				} else {
					meta.faceInfosOffset = -1;
				}
				if (hasPriorities == 255) {
					meta.facePrioritiesOffset = trianglePriorityDataOffset;
					trianglePriorityDataOffset += meta.faceCount;
				} else {
					meta.facePrioritiesOffset = -hasPriorities - 1;
				}
				if (hasAlpha == 1) {
					meta.faceAlphasOffset = triangleAlphaDataOffset;
					triangleAlphaDataOffset += meta.faceCount;
				} else {
					meta.faceAlphasOffset = -1;
				}
				if (hasSkins == 1) {
					meta.faceLabelsOffset = triangleSkinDataOffset;
					triangleSkinDataOffset += meta.faceCount;
				} else {
					meta.faceLabelsOffset = -1;
				}
				if (hasLabels == 1) {
					meta.vertexLabelsOffset = labelDataOffset;
					labelDataOffset += meta.vertexCount;
				} else {
					meta.vertexLabelsOffset = -1;
				}
				meta.faceTextureAxisOffset = vertexTextureDataOffset;
				vertexTextureDataOffset += meta.texturedFaceCount;
			}
		} catch (@Pc(421) Exception ex) {
			System.out.println("Error loading model index");
			ex.printStackTrace();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(III)I")
	public static int mulColorLightness(@OriginalArg(0) int hsl, @OriginalArg(1) int scalar, @OriginalArg(2) int faceInfo) {
		if ((faceInfo & 0x2) == 2) {
			if (scalar < 0) {
				scalar = 0;
			} else if (scalar > 127) {
				scalar = 127;
			}
			return 127 - scalar;
		}
		scalar = scalar * (hsl & 0x7F) >> 7;
		if (scalar < 2) {
			scalar = 2;
		} else if (scalar > 126) {
			scalar = 126;
		}
		return (hsl & 0xFF80) + scalar;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(Lclient!eb;I)I")
	private int addVertex(@OriginalArg(0) Model src, @OriginalArg(1) int vertexId) {
		@Pc(3) int identical = -1;
		@Pc(8) int x = src.vertexX[vertexId];
		@Pc(13) int y = src.vertexY[vertexId];
		@Pc(18) int z = src.vertexZ[vertexId];
		for (@Pc(20) int v = 0; v < this.vertexCount; v++) {
			if (x == this.vertexX[v] && y == this.vertexY[v] && z == this.vertexZ[v]) {
				identical = v;
				break;
			}
		}
		if (identical == -1) {
			this.vertexX[this.vertexCount] = x;
			this.vertexY[this.vertexCount] = y;
			this.vertexZ[this.vertexCount] = z;
			if (src.vertexLabel != null) {
				this.vertexLabel[this.vertexCount] = src.vertexLabel[vertexId];
			}
			identical = this.vertexCount++;
		}
		return identical;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(I)V")
	public void calculateBoundsCylinder() {
		this.maxY = 0;
		this.radius = 0;
		this.minY = 0;
		for (@Pc(14) int i = 0; i < this.vertexCount; i++) {
			@Pc(21) int x = this.vertexX[i];
			@Pc(26) int y = this.vertexY[i];
			@Pc(31) int z = this.vertexZ[i];
			if (-y > this.maxY) {
				this.maxY = -y;
			}
			if (y > this.minY) {
				this.minY = y;
			}
			@Pc(55) int radiusSqr = x * x + z * z;
			if (radiusSqr > this.radius) {
				this.radius = radiusSqr;
			}
		}
		this.radius = (int) (Math.sqrt(this.radius) + 0.99D);
		this.minDepth = (int) (Math.sqrt(this.radius * this.radius + this.maxY * this.maxY) + 0.99D);
		this.maxDepth = this.minDepth + (int) (Math.sqrt(this.radius * this.radius + this.minY * this.minY) + 0.99D);
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(I)V")
	public void calculateBoundsY() {
		this.maxY = 0;
		this.minY = 0;
		for (@Pc(8) int v = 0; v < this.vertexCount; v++) {
			@Pc(25) int y = this.vertexY[v];
			if (-y > this.maxY) {
				this.maxY = -y;
			}
			if (y > this.minY) {
				this.minY = y;
			}
		}
		this.minDepth = (int) (Math.sqrt(this.radius * this.radius + this.maxY * this.maxY) + 0.99D);
		this.maxDepth = this.minDepth + (int) (Math.sqrt(this.radius * this.radius + this.minY * this.minY) + 0.99D);
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
		for (@Pc(27) int v = 0; v < this.vertexCount; v++) {
			@Pc(34) int x = this.vertexX[v];
			@Pc(39) int y = this.vertexY[v];
			@Pc(44) int z = this.vertexZ[v];
			if (x < this.minX) {
				this.minX = x;
			}
			if (x > this.maxX) {
				this.maxX = x;
			}
			if (z < this.minZ) {
				this.minZ = z;
			}
			if (z > this.maxZ) {
				this.maxZ = z;
			}
			if (-y > this.maxY) {
				this.maxY = -y;
			}
			if (y > this.minY) {
				this.minY = y;
			}
			@Pc(96) int radiusSqr = x * x + z * z;
			if (radiusSqr > this.radius) {
				this.radius = radiusSqr;
			}
		}
		this.radius = (int) Math.sqrt(this.radius);
		this.minDepth = (int) Math.sqrt(this.radius * this.radius + this.maxY * this.maxY);
		this.maxDepth = this.minDepth + (int) Math.sqrt(this.radius * this.radius + this.minY * this.minY);
	}

	@OriginalMember(owner = "client!eb", name = "c", descriptor = "(I)V")
	public void createLabelReferences() {
		if (this.vertexLabel != null) {
			int[] labelVertexCount = new int[256];
			int count = 0;
			for (int v = 0; v < this.vertexCount; v++) {
				int label = this.vertexLabel[v];
				int countDebug = labelVertexCount[label]++;
				if (label > count) {
					count = label;
				}
			}
			this.labelVertices = new int[count + 1][];
			for (int label = 0; label <= count; label++) {
				this.labelVertices[label] = new int[labelVertexCount[label]];
				labelVertexCount[label] = 0;
			}
			int v = 0;
			while (v < this.vertexCount) {
				int label = this.vertexLabel[v];
				this.labelVertices[label][labelVertexCount[label]++] = v++;
			}
			this.vertexLabel = null;
		}

		if (this.faceLabel != null) {
			int[] labelFaceCount = new int[256];
			int count = 0;
			for (int f = 0; f < this.faceCount; f++) {
				int label = this.faceLabel[f];
				int countDebug = labelFaceCount[label]++;
				if (label > count) {
					count = label;
				}
			}
			this.labelFaces = new int[count + 1][];
			for (int label = 0; label <= count; label++) {
				this.labelFaces[label] = new int[labelFaceCount[label]];
				labelFaceCount[label] = 0;
			}
			int face = 0;
			while (face < this.faceCount) {
				int label = this.faceLabel[face];
				this.labelFaces[label][labelFaceCount[label]++] = face++;
			}
			this.faceLabel = null;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(II)V")
	public void applyTransform(@OriginalArg(1) int id) {
		if (this.labelVertices != null && id != -1) {
			@Pc(11) AnimFrame transform = AnimFrame.instances[id];
			@Pc(14) AnimBase skeleton = transform.base;
			baseX = 0;
			baseY = 0;
			baseZ = 0;
			for (@Pc(22) int i = 0; i < transform.length; i++) {
				@Pc(29) int base = transform.bases[i];
				this.applyTransform(transform.x[i], transform.y[i], transform.z[i], skeleton.labels[base], skeleton.types[base]);
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(III[I)V")
	public void applyTransforms(@OriginalArg(2) int primaryId, @OriginalArg(0) int secondaryId, @OriginalArg(3) int[] mask) {
		if (primaryId == -1) {
			return;
		}

		if (mask == null || secondaryId == -1) {
			this.applyTransform(primaryId);
		} else {
			@Pc(19) AnimFrame primary = AnimFrame.instances[primaryId];
			@Pc(32) AnimFrame secondary = AnimFrame.instances[secondaryId];
			@Pc(35) AnimBase skeleton = primary.base;

			baseX = 0;
			baseY = 0;
			baseZ = 0;

			@Pc(46) int counter = 0;
			@Pc(48) int maskBase = mask[counter++];

			for (@Pc(50) int i = 0; i < primary.length; i++) {
				int base = primary.bases[i];
				while (base > maskBase) {
					maskBase = mask[counter++];
				}

				if (base != maskBase || skeleton.types[base] == 0) {
					this.applyTransform(primary.x[i], primary.y[i], primary.z[i], skeleton.labels[base], skeleton.types[base]);
				}
			}

			baseX = 0;
			baseY = 0;
			baseZ = 0;

			counter = 0;
			maskBase = mask[counter++];

			for (int i = 0; i < secondary.length; i++) {
				@Pc(124) int base = secondary.bases[i];
				while (base > maskBase) {
					maskBase = mask[counter++];
				}

				if (base == maskBase || skeleton.types[base] == 0) {
					this.applyTransform(secondary.x[i], secondary.y[i], secondary.z[i], skeleton.labels[base], skeleton.types[base]);
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(I[IIII)V")
	private void applyTransform(@OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(4) int z, @OriginalArg(1) int[] labels, @OriginalArg(0) int type) {
		@Pc(4) int labelCount = labels.length;

		if (type == 0) {
			int count = 0;
			baseX = 0;
			baseY = 0;
			baseZ = 0;

			for (int g = 0; g < labelCount; g++) {
				@Pc(22) int label = labels[g];
				if (label < this.labelVertices.length) {
					@Pc(32) int[] vertices = this.labelVertices[label];
					for (int i = 0; i < vertices.length; i++) {
						int v = vertices[i];
						baseX += this.vertexX[v];
						baseY += this.vertexY[v];
						baseZ += this.vertexZ[v];
						count++;
					}
				}
			}

			if (count > 0) {
				baseX = baseX / count + x;
				baseY = baseY / count + y;
				baseZ = baseZ / count + z;
			} else {
				baseX = x;
				baseY = y;
				baseZ = z;
			}
		} else if (type == 1) {
			for (int g = 0; g < labelCount; g++) {
				int group = labels[g];
				if (group >= this.labelVertices.length) {
					continue;
				}

				int[] vertices = this.labelVertices[group];
				for (int i = 0; i < vertices.length; i++) {
					int v = vertices[i];
					this.vertexX[v] += x;
					this.vertexY[v] += y;
					this.vertexZ[v] += z;
				}
			}
		} else if (type == 2) {
			for (int g = 0; g < labelCount; g++) {
				int label = labels[g];
				if (label >= this.labelVertices.length) {
					continue;
				}

				int[] vertices = this.labelVertices[label];
				for (int i = 0; i < vertices.length; i++) {
					int v = vertices[i];
					this.vertexX[v] -= baseX;
					this.vertexY[v] -= baseY;
					this.vertexZ[v] -= baseZ;

					int pitch = (x & 0xFF) * 8;
					@Pc(227) int yaw = (y & 0xFF) * 8;
					@Pc(233) int roll = (z & 0xFF) * 8;

					@Pc(239) int sin;
					@Pc(243) int cos;

					if (roll != 0) {
						sin = Model.sin[roll];
						cos = Model.cos[roll];
						int x_ = this.vertexY[v] * sin + this.vertexX[v] * cos >> 16;
						this.vertexY[v] = this.vertexY[v] * cos - this.vertexX[v] * sin >> 16;
						this.vertexX[v] = x_;
					}

					if (pitch != 0) {
						sin = Model.sin[pitch];
						cos = Model.cos[pitch];
						int y_ = this.vertexY[v] * cos - this.vertexZ[v] * sin >> 16;
						this.vertexZ[v] = this.vertexY[v] * sin + this.vertexZ[v] * cos >> 16;
						this.vertexY[v] = y_;
					}

					if (yaw != 0) {
						sin = Model.sin[yaw];
						cos = Model.cos[yaw];
						int x_ = this.vertexZ[v] * sin + this.vertexX[v] * cos >> 16;
						this.vertexZ[v] = this.vertexZ[v] * cos - this.vertexX[v] * sin >> 16;
						this.vertexX[v] = x_;
					}

					this.vertexX[v] += baseX;
					this.vertexY[v] += baseY;
					this.vertexZ[v] += baseZ;
				}
			}
		} else if (type == 3) {
			for (int g = 0; g < labelCount; g++) {
				int label = labels[g];
				if (label >= this.labelVertices.length) {
					continue;
				}

				int[] vertices = this.labelVertices[label];
				for (int i = 0; i < vertices.length; i++) {
					int v = vertices[i];
					this.vertexX[v] -= baseX;
					this.vertexY[v] -= baseY;
					this.vertexZ[v] -= baseZ;
					this.vertexX[v] = this.vertexX[v] * x / 128;
					this.vertexY[v] = this.vertexY[v] * y / 128;
					this.vertexZ[v] = this.vertexZ[v] * z / 128;
					this.vertexX[v] += baseX;
					this.vertexY[v] += baseY;
					this.vertexZ[v] += baseZ;
				}
			}
		} else if (type == 5 && (this.labelFaces != null && this.faceAlpha != null)) {
			for (int g = 0; g < labelCount; g++) {
				int label = labels[g];
				if (label >= this.labelFaces.length) {
					continue;
				}

				int[] triangles = this.labelFaces[label];
				for (int i = 0; i < triangles.length; i++) {
					int t = triangles[i];

					this.faceAlpha[t] += x * 8;
					if (this.faceAlpha[t] < 0) {
						this.faceAlpha[t] = 0;
					}

					if (this.faceAlpha[t] > 255) {
						this.faceAlpha[t] = 255;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "d", descriptor = "(I)V")
	public void rotateY90() {
		for (@Pc(6) int v = 0; v < this.vertexCount; v++) {
			@Pc(13) int tmp = this.vertexX[v];
			this.vertexX[v] = this.vertexZ[v];
			this.vertexZ[v] = -tmp;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(BI)V")
	public void rotateX(@OriginalArg(1) int angle) {
		@Pc(3) int sin = Model.sin[angle];
		@Pc(7) int cos = Model.cos[angle];
		for (@Pc(9) int v = 0; v < this.vertexCount; v++) {
			@Pc(27) int tmp = this.vertexY[v] * cos - this.vertexZ[v] * sin >> 16;
			this.vertexZ[v] = this.vertexY[v] * sin + this.vertexZ[v] * cos >> 16;
			this.vertexY[v] = tmp;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIII)V")
	public void translate(@OriginalArg(0) int y, @OriginalArg(1) int x, @OriginalArg(3) int z) {
		for (@Pc(11) int v = 0; v < this.vertexCount; v++) {
			this.vertexX[v] += x;
			this.vertexY[v] += y;
			this.vertexZ[v] += z;
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(II)V")
	public void recolor(@OriginalArg(0) int src, @OriginalArg(1) int dst) {
		for (@Pc(1) int f = 0; f < this.faceCount; f++) {
			if (this.faceColor[f] == src) {
				this.faceColor[f] = dst;
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "e", descriptor = "(I)V")
	public void rotateY180() {
		for (@Pc(3) int v = 0; v < this.vertexCount; v++) {
			this.vertexZ[v] = -this.vertexZ[v];
		}

		for (@Pc(21) int f = 0; f < this.faceCount; f++) {
			int temp = this.faceVertexA[f];
			this.faceVertexA[f] = this.faceVertexC[f];
			this.faceVertexC[f] = temp;
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(IIII)V")
	public void scale(@OriginalArg(3) int x, @OriginalArg(2) int y, @OriginalArg(0) int z) {
		for (@Pc(1) int v = 0; v < this.vertexCount; v++) {
			this.vertexX[v] = this.vertexX[v] * x / 128;
			this.vertexY[v] = this.vertexY[v] * y / 128;
			this.vertexZ[v] = this.vertexZ[v] * z / 128;
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIZ)V")
	public void calculateNormals(@OriginalArg(0) int lightAmbient, @OriginalArg(1) int lightAttenuation, @OriginalArg(2) int lightSrcX, @OriginalArg(3) int lightSrcY, @OriginalArg(4) int lightSrcZ, @OriginalArg(5) boolean applyLighting) {
		@Pc(16) int lightMagnitude = (int) Math.sqrt(lightSrcX * lightSrcX + lightSrcY * lightSrcY + lightSrcZ * lightSrcZ);
		@Pc(22) int attenuation = lightAttenuation * lightMagnitude >> 8;

		if (this.faceColorA == null) {
			this.faceColorA = new int[this.faceCount];
			this.faceColorB = new int[this.faceCount];
			this.faceColorC = new int[this.faceCount];
		}

		if (this.vertexNormal == null) {
			this.vertexNormal = new VertexNormal[this.vertexCount];
			for (int v = 0; v < this.vertexCount; v++) {
				this.vertexNormal[v] = new VertexNormal();
			}
		}

		for (int f = 0; f < this.faceCount; f++) {
			int a = this.faceVertexA[f];
			@Pc(78) int b = this.faceVertexB[f];
			@Pc(83) int c = this.faceVertexC[f];

			@Pc(93) int dxAB = this.vertexX[b] - this.vertexX[a];
			@Pc(103) int dyAB = this.vertexY[b] - this.vertexY[a];
			@Pc(113) int dzAB = this.vertexZ[b] - this.vertexZ[a];

			@Pc(123) int dxAC = this.vertexX[c] - this.vertexX[a];
			@Pc(133) int dyAC = this.vertexY[c] - this.vertexY[a];
			@Pc(143) int dzAC = this.vertexZ[c] - this.vertexZ[a];

			@Pc(151) int nx = dyAB * dzAC - dyAC * dzAB;
			@Pc(159) int ny = dzAB * dxAC - dzAC * dxAB;
			@Pc(167) int nz;
			for (nz = dxAB * dyAC - dxAC * dyAB; nx > 8192 || ny > 8192 || nz > 8192 || nx < -8192 || ny < -8192 || nz < -8192; nz >>= 0x1) {
				nx >>= 0x1;
				ny >>= 0x1;
			}

			@Pc(214) int length = (int) Math.sqrt(nx * nx + ny * ny + nz * nz);
			if (length <= 0) {
				length = 1;
			}

			nx = nx * 256 / length;
			ny = ny * 256 / length;
			nz = nz * 256 / length;

			if (this.faceInfo == null || (this.faceInfo[f] & 0x1) == 0) {
				@Pc(251) VertexNormal n = this.vertexNormal[a];
				n.x += nx;
				n.y += ny;
				n.z += nz;
				n.w++;

				n = this.vertexNormal[b];
				n.x += nx;
				n.y += ny;
				n.z += nz;
				n.w++;

				n = this.vertexNormal[c];
				n.x += nx;
				n.y += ny;
				n.z += nz;
				n.w++;
			} else {
				@Pc(355) int lightness = lightAmbient + (lightSrcX * nx + lightSrcY * ny + lightSrcZ * nz) / (attenuation + attenuation / 2);
				this.faceColorA[f] = mulColorLightness(this.faceColor[f], lightness, this.faceInfo[f]);
			}
		}

		if (applyLighting) {
			this.applyLighting(lightAmbient, attenuation, lightSrcX, lightSrcY, lightSrcZ);
		} else {
			this.vertexNormalOriginal = new VertexNormal[this.vertexCount];
			for (int v = 0; v < this.vertexCount; v++) {
				@Pc(399) VertexNormal normal = this.vertexNormal[v];
				@Pc(408) VertexNormal copy = this.vertexNormalOriginal[v] = new VertexNormal();
				copy.x = normal.x;
				copy.y = normal.y;
				copy.z = normal.z;
				copy.w = normal.w;
			}
		}

		if (applyLighting) {
			this.calculateBoundsCylinder();
		} else {
			this.calculateBoundsAABB();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIII)V")
	public void applyLighting(@OriginalArg(0) int lightAmbient, @OriginalArg(1) int lightAttenuation, @OriginalArg(2) int lightSrcX, @OriginalArg(3) int lightSrcY, @OriginalArg(4) int lightSrcZ) {
		for (@Pc(3) int f = 0; f < this.faceCount; f++) {
			int a = this.faceVertexA[f];
			@Pc(15) int b = this.faceVertexB[f];
			@Pc(20) int c = this.faceVertexC[f];

			if (this.faceInfo == null) {
				int color = this.faceColor[f];

				VertexNormal n = this.vertexNormal[a];
				int lightness = lightAmbient + (lightSrcX * n.x + lightSrcY * n.y + lightSrcZ * n.z) / (lightAttenuation * n.w);
				this.faceColorA[f] = mulColorLightness(color, lightness, 0);

				n = this.vertexNormal[b];
				lightness = lightAmbient + (lightSrcX * n.x + lightSrcY * n.y + lightSrcZ * n.z) / (lightAttenuation * n.w);
				this.faceColorB[f] = mulColorLightness(color, lightness, 0);

				n = this.vertexNormal[c];
				lightness = lightAmbient + (lightSrcX * n.x + lightSrcY * n.y + lightSrcZ * n.z) / (lightAttenuation * n.w);
				this.faceColorC[f] = mulColorLightness(color, lightness, 0);
			} else if ((this.faceInfo[f] & 0x1) == 0) {
				int color = this.faceColor[f];
				@Pc(152) int info = this.faceInfo[f];

				VertexNormal n = this.vertexNormal[a];
				int lightness = lightAmbient + (lightSrcX * n.x + lightSrcY * n.y + lightSrcZ * n.z) / (lightAttenuation * n.w);
				this.faceColorA[f] = mulColorLightness(color, lightness, info);

				n = this.vertexNormal[b];
				lightness = lightAmbient + (lightSrcX * n.x + lightSrcY * n.y + lightSrcZ * n.z) / (lightAttenuation * n.w);
				this.faceColorB[f] = mulColorLightness(color, lightness, info);

				n = this.vertexNormal[c];
				lightness = lightAmbient + (lightSrcX * n.x + lightSrcY * n.y + lightSrcZ * n.z) / (lightAttenuation * n.w);
				this.faceColorC[f] = mulColorLightness(color, lightness, info);
			}
		}

		this.vertexNormal = null;
		this.vertexNormalOriginal = null;
		this.vertexLabel = null;
		this.faceLabel = null;

		if (this.faceInfo != null) {
			for (int f = 0; f < this.faceCount; f++) {
				if ((this.faceInfo[f] & 0x2) == 2) {
					return;
				}
			}
		}

		this.faceColor = null;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIII)V")
	public void drawSimple(@OriginalArg(0) int pitch, @OriginalArg(1) int yaw, @OriginalArg(2) int roll, @OriginalArg(3) int eyePitch, @OriginalArg(4) int eyeX, @OriginalArg(5) int eyeY, @OriginalArg(6) int eyeZ) {
		@Pc(1) int centerX = Draw3D.centerX;
		@Pc(3) int centerY = Draw3D.centerY;
		@Pc(7) int sinPitch = sin[pitch];
		@Pc(11) int cosPitch = cos[pitch];
		@Pc(15) int sinYaw = sin[yaw];
		@Pc(19) int cosYaw = cos[yaw];
		@Pc(23) int sinRoll = sin[roll];
		@Pc(27) int cosRoll = cos[roll];
		@Pc(31) int sinEyePitch = sin[eyePitch];
		@Pc(35) int cosEyePitch = cos[eyePitch];
		@Pc(45) int midZ = eyeY * sinEyePitch + eyeZ * cosEyePitch >> 16;

		for (@Pc(47) int v = 0; v < this.vertexCount; v++) {
			@Pc(54) int x = this.vertexX[v];
			@Pc(59) int y = this.vertexY[v];
			@Pc(64) int z = this.vertexZ[v];

			@Pc(76) int temp;
			if (roll != 0) {
				temp = y * sinRoll + x * cosRoll >> 16;
				y = y * cosRoll - x * sinRoll >> 16;
				x = temp;
			}

			if (pitch != 0) {
				temp = y * cosPitch - z * sinPitch >> 16;
				z = y * sinPitch + z * cosPitch >> 16;
				y = temp;
			}

			if (yaw != 0) {
				temp = z * sinYaw + x * cosYaw >> 16;
				z = z * cosYaw - x * sinYaw >> 16;
				x = temp;
			}

			x += eyeX;
			y += eyeY;
			z += eyeZ;

			temp = y * cosEyePitch - z * sinEyePitch >> 16;
			z = y * sinEyePitch + z * cosEyePitch >> 16;

			vertexScreenZ[v] = z - midZ;
			vertexScreenX[v] = centerX + (x << 9) / z;
			vertexScreenY[v] = centerY + (temp << 9) / z;

			if (this.texturedFaceCount > 0) {
				vertexViewSpaceX[v] = x;
				vertexViewSpaceY[v] = temp;
				vertexViewSpaceZ[v] = z;
			}
		}

		try {
			this.draw(false, false, 0);
		} catch (@Pc(223) Exception ex) {
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIIIII)V")
	public void draw(@OriginalArg(0) int yaw, @OriginalArg(1) int sinEyePitch, @OriginalArg(2) int cosEyePitch, @OriginalArg(3) int sinEyeYaw, @OriginalArg(4) int cosEyeYaw, @OriginalArg(5) int relativeX, @OriginalArg(6) int relativeY, @OriginalArg(7) int relativeZ, @OriginalArg(8) int bitset) {
		@Pc(11) int zPrime = relativeZ * cosEyeYaw - relativeX * sinEyeYaw >> 16;
		@Pc(21) int midZ = relativeY * sinEyePitch + zPrime * cosEyePitch >> 16;
		@Pc(28) int radiusCosEyePitch = this.radius * cosEyePitch >> 16;

		@Pc(32) int maxZ = midZ + radiusCosEyePitch;
		if (maxZ <= 50 || midZ >= 3500) {
			return;
		}

		@Pc(49) int midX = relativeZ * sinEyeYaw + relativeX * cosEyeYaw >> 16;
		@Pc(56) int leftX = midX - this.radius << 9;
		if (leftX / maxZ >= Draw2D.centerX2d) {
			return;
		}

		@Pc(69) int rightX = midX + this.radius << 9;
		if (rightX / maxZ <= -Draw2D.centerX2d) {
			return;
		}

		@Pc(86) int midY = relativeY * cosEyePitch - zPrime * sinEyePitch >> 16;
		@Pc(93) int radiusSinEyePitch = this.radius * sinEyePitch >> 16;

		@Pc(99) int bottomY = midY + radiusSinEyePitch << 9;
		if (bottomY / maxZ <= -Draw2D.centerY2d) {
			return;
		}

		@Pc(115) int yPrime = radiusSinEyePitch + (this.maxY * cosEyePitch >> 16);
		@Pc(121) int topY = midY - yPrime << 9;
		if (topY / maxZ >= Draw2D.centerY2d) {
			return;
		}

		@Pc(136) int radiusZ = radiusCosEyePitch + (this.maxY * sinEyePitch >> 16);

		@Pc(138) boolean clipped = midZ - radiusZ <= 50;
		@Pc(147) boolean picking = false;

		if (bitset > 0 && checkHover) {
			int z = midZ - radiusCosEyePitch;
			if (z <= 50) {
				z = 50;
			}

			if (midX > 0) {
				leftX /= maxZ;
				rightX /= z;
			} else {
				rightX /= maxZ;
				leftX /= z;
			}

			if (midY > 0) {
				topY /= maxZ;
				bottomY /= z;
			} else {
				bottomY /= maxZ;
				topY /= z;
			}

			int mouseX = Model.mouseX - Draw3D.centerX;
			int mouseY = mouseZ - Draw3D.centerY;
			if (mouseX > leftX && mouseX < rightX && mouseY > topY && mouseY < bottomY) {
				if (this.pickable) {
					pickedBitsets[pickedCount++] = bitset;
				} else {
					picking = true;
				}
			}
		}

		int centerX = Draw3D.centerX;
		int centerY = Draw3D.centerY;

		int sinYaw = 0;
		@Pc(243) int cosYaw = 0;
		if (yaw != 0) {
			sinYaw = sin[yaw];
			cosYaw = cos[yaw];
		}

		for (@Pc(255) int v = 0; v < this.vertexCount; v++) {
			@Pc(262) int x = this.vertexX[v];
			@Pc(267) int y = this.vertexY[v];
			@Pc(272) int z = this.vertexZ[v];

			@Pc(284) int temp;
			if (yaw != 0) {
				temp = z * sinYaw + x * cosYaw >> 16;
				z = z * cosYaw - x * sinYaw >> 16;
				x = temp;
			}

			x += relativeX;
			y += relativeY;
			z += relativeZ;

			temp = z * sinEyeYaw + x * cosEyeYaw >> 16;
			z = z * cosEyeYaw - x * sinEyeYaw >> 16;
			x = temp;

			temp = y * cosEyePitch - z * sinEyePitch >> 16;
			z = y * sinEyePitch + z * cosEyePitch >> 16;

			vertexScreenZ[v] = z - midZ;

			if (z >= 50) {
				vertexScreenX[v] = centerX + (x << 9) / z;
				vertexScreenY[v] = centerY + (temp << 9) / z;
			} else {
				vertexScreenX[v] = -5000;
				clipped = true;
			}

			if (clipped || this.texturedFaceCount > 0) {
				vertexViewSpaceX[v] = x;
				vertexViewSpaceY[v] = temp;
				vertexViewSpaceZ[v] = z;
			}
		}

		try {
			this.draw(clipped, picking, bitset);
		} catch (@Pc(418) Exception ex) {
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(ZZI)V")
	private void draw(@OriginalArg(0) boolean clipped, @OriginalArg(1) boolean picking, @OriginalArg(2) int bitset) {
		for (@Pc(3) int depth = 0; depth < this.maxDepth; depth++) {
			tmpDepthFaceCount[depth] = 0;
		}

		for (@Pc(16) int f = 0; f < this.faceCount; f++) {
			if (this.faceInfo == null || this.faceInfo[f] != -1) {
				int a = this.faceVertexA[f];
				int b = this.faceVertexB[f];
				int c = this.faceVertexC[f];

				int xA = vertexScreenX[a];
				int xB = vertexScreenX[b];
				int xC = vertexScreenX[c];

				if (clipped && (xA == -5000 || xB == -5000 || xC == -5000)) {
					faceNearClipped[f] = true;
					int depthAverage = (vertexScreenZ[a] + vertexScreenZ[b] + vertexScreenZ[c]) / 3 + this.minDepth;
					tmpDepthFaces[depthAverage][tmpDepthFaceCount[depthAverage]++] = f;
				} else {
					if (picking && this.pointWithinTriangle(mouseX, mouseZ, vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], xA, xB, xC)) {
						pickedBitsets[pickedCount++] = bitset;
						picking = false;
					}

					if ((xA - xB) * (vertexScreenY[c] - vertexScreenY[b]) - (vertexScreenY[a] - vertexScreenY[b]) * (xC - xB) > 0) {
						faceNearClipped[f] = false;
						faceClippedX[f] = xA < 0 || xB < 0 || xC < 0 || xA > Draw2D.boundX || xB > Draw2D.boundX || xC > Draw2D.boundX;
						int depthAverage = (vertexScreenZ[a] + vertexScreenZ[b] + vertexScreenZ[c]) / 3 + this.minDepth;
						tmpDepthFaces[depthAverage][tmpDepthFaceCount[depthAverage]++] = f;
					}
				}
			}
		}

		if (this.facePriority == null) {
			for (int depth = this.maxDepth - 1; depth >= 0; depth--) {
				int count = tmpDepthFaceCount[depth];
				if (count > 0) {
					@Pc(238) int[] faces = tmpDepthFaces[depth];
					for (int f = 0; f < count; f++) {
						this.drawFace(faces[f]);
					}
				}
			}
			return;
		}

		for (int priority = 0; priority < 12; priority++) {
			tmpPriorityFaceCount[priority] = 0;
			tmpPriorityDepthSum[priority] = 0;
		}

		for (int depth = this.maxDepth - 1; depth >= 0; depth--) {
			int faceCount = tmpDepthFaceCount[depth];
			if (faceCount > 0) {
				@Pc(288) int[] faces = tmpDepthFaces[depth];
				for (int i = 0; i < faceCount; i++) {
					int priorityDepth = faces[i];
					int priorityFace = this.facePriority[priorityDepth];
					int priorityFaceCount = tmpPriorityFaceCount[priorityFace]++;
					tmpPriorityFaces[priorityFace][priorityFaceCount] = priorityDepth;
					if (priorityFace < 10) {
						tmpPriorityDepthSum[priorityFace] += depth;
					} else if (priorityFace == 10) {
						tmpPriority10FaceDepth[priorityFaceCount] = depth;
					} else {
						tmpPriority11FaceDepth[priorityFaceCount] = depth;
					}
				}
			}
		}

		int averagePriorityDepthSum1_2 = 0;
		if (tmpPriorityFaceCount[1] > 0 || tmpPriorityFaceCount[2] > 0) {
			averagePriorityDepthSum1_2 = (tmpPriorityDepthSum[1] + tmpPriorityDepthSum[2]) / (tmpPriorityFaceCount[1] + tmpPriorityFaceCount[2]);
		}
		int averagePriorityDepthSum3_4 = 0;
		if (tmpPriorityFaceCount[3] > 0 || tmpPriorityFaceCount[4] > 0) {
			averagePriorityDepthSum3_4 = (tmpPriorityDepthSum[3] + tmpPriorityDepthSum[4]) / (tmpPriorityFaceCount[3] + tmpPriorityFaceCount[4]);
		}
		int averagePriorityDepthSum6_8 = 0;
		if (tmpPriorityFaceCount[6] > 0 || tmpPriorityFaceCount[8] > 0) {
			averagePriorityDepthSum6_8 = (tmpPriorityDepthSum[6] + tmpPriorityDepthSum[8]) / (tmpPriorityFaceCount[6] + tmpPriorityFaceCount[8]);
		}

		int priorityFace = 0;
		int priorityFaceCount = tmpPriorityFaceCount[10];

		@Pc(436) int[] priorityFaces = tmpPriorityFaces[10];
		@Pc(438) int[] priorithFaceDepths = tmpPriority10FaceDepth;
		if (priorityFace == priorityFaceCount) {
			priorityFace = 0;
			priorityFaceCount = tmpPriorityFaceCount[11];
			priorityFaces = tmpPriorityFaces[11];
			priorithFaceDepths = tmpPriority11FaceDepth;
		}

		int priorityDepth;
		if (priorityFace < priorityFaceCount) {
			priorityDepth = priorithFaceDepths[priorityFace];
		} else {
			priorityDepth = -1000;
		}

		for (@Pc(466) int priority = 0; priority < 10; priority++) {
			while (priority == 0 && priorityDepth > averagePriorityDepthSum1_2) {
				this.drawFace(priorityFaces[priorityFace++]);

				if (priorityFace == priorityFaceCount && priorityFaces != tmpPriorityFaces[11]) {
					priorityFace = 0;
					priorityFaceCount = tmpPriorityFaceCount[11];
					priorityFaces = tmpPriorityFaces[11];
					priorithFaceDepths = tmpPriority11FaceDepth;
				}

				if (priorityFace < priorityFaceCount) {
					priorityDepth = priorithFaceDepths[priorityFace];
				} else {
					priorityDepth = -1000;
				}
			}

			while (priority == 3 && priorityDepth > averagePriorityDepthSum3_4) {
				this.drawFace(priorityFaces[priorityFace++]);

				if (priorityFace == priorityFaceCount && priorityFaces != tmpPriorityFaces[11]) {
					priorityFace = 0;
					priorityFaceCount = tmpPriorityFaceCount[11];
					priorityFaces = tmpPriorityFaces[11];
					priorithFaceDepths = tmpPriority11FaceDepth;
				}

				if (priorityFace < priorityFaceCount) {
					priorityDepth = priorithFaceDepths[priorityFace];
				} else {
					priorityDepth = -1000;
				}
			}

			while (priority == 5 && priorityDepth > averagePriorityDepthSum6_8) {
				this.drawFace(priorityFaces[priorityFace++]);

				if (priorityFace == priorityFaceCount && priorityFaces != tmpPriorityFaces[11]) {
					priorityFace = 0;
					priorityFaceCount = tmpPriorityFaceCount[11];
					priorityFaces = tmpPriorityFaces[11];
					priorithFaceDepths = tmpPriority11FaceDepth;
				}

				if (priorityFace < priorityFaceCount) {
					priorityDepth = priorithFaceDepths[priorityFace];
				} else {
					priorityDepth = -1000;
				}
			}

			@Pc(604) int count = tmpPriorityFaceCount[priority];
			@Pc(608) int[] faces = tmpPriorityFaces[priority];
			for (@Pc(610) int i = 0; i < count; i++) {
				this.drawFace(faces[i]);
			}
		}

		while (priorityDepth != -1000) {
			this.drawFace(priorityFaces[priorityFace++]);

			if (priorityFace == priorityFaceCount && priorityFaces != tmpPriorityFaces[11]) {
				priorityFace = 0;
				priorityFaces = tmpPriorityFaces[11];
				priorityFaceCount = tmpPriorityFaceCount[11];
				priorithFaceDepths = tmpPriority11FaceDepth;
			}

			if (priorityFace < priorityFaceCount) {
				priorityDepth = priorithFaceDepths[priorityFace];
			} else {
				priorityDepth = -1000;
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "f", descriptor = "(I)V")
	private void drawFace(@OriginalArg(0) int face) {
		if (faceNearClipped[face]) {
			this.drawNearClippedFace(face);
			return;
		}

		@Pc(14) int a = this.faceVertexA[face];
		@Pc(19) int b = this.faceVertexB[face];
		@Pc(24) int c = this.faceVertexC[face];

		Draw3D.clipX = faceClippedX[face];

		if (this.faceAlpha == null) {
			Draw3D.alpha = 0;
		} else {
			Draw3D.alpha = this.faceAlpha[face];
		}

		@Pc(45) int type;
		if (this.faceInfo == null) {
			type = 0;
		} else {
			type = this.faceInfo[face] & 0x3;
		}

		if (type == 0) {
			Draw3D.fillGouraudTriangle(vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], this.faceColorA[face], this.faceColorB[face], this.faceColorC[face]);
		} else if (type == 1) {
			Draw3D.fillTriangle(vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], palette[this.faceColorA[face]]);
		} else if (type == 2) {
			int texturedFace = this.faceInfo[face] >> 2;
			int tA = this.texturedVertexA[texturedFace];
			int tB = this.texturedVertexB[texturedFace];
			int tC = this.texturedVertexC[texturedFace];
			Draw3D.fillTexturedTriangle(vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], this.faceColorA[face], this.faceColorB[face], this.faceColorC[face], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
		} else if (type == 3) {
			int texturedFace = this.faceInfo[face] >> 2;
			int tA = this.texturedVertexA[texturedFace];
			int tB = this.texturedVertexB[texturedFace];
			int tC = this.texturedVertexC[texturedFace];
			Draw3D.fillTexturedTriangle(vertexScreenX[a], vertexScreenX[b], vertexScreenX[c], vertexScreenY[a], vertexScreenY[b], vertexScreenY[c], this.faceColorA[face], this.faceColorA[face], this.faceColorA[face], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
		}
	}

	@OriginalMember(owner = "client!eb", name = "g", descriptor = "(I)V")
	private void drawNearClippedFace(@OriginalArg(0) int face) {
		@Pc(3) int centerX = Draw3D.centerX;
		@Pc(5) int centerY = Draw3D.centerY;
		@Pc(7) int elements = 0;

		@Pc(12) int a = this.faceVertexA[face];
		@Pc(17) int b = this.faceVertexB[face];
		@Pc(22) int c = this.faceVertexC[face];

		@Pc(26) int zA = vertexViewSpaceZ[a];
		@Pc(30) int zB = vertexViewSpaceZ[b];
		@Pc(34) int zC = vertexViewSpaceZ[c];

		if (zA >= 50) {
			clippedX[elements] = vertexScreenX[a];
			clippedY[elements] = vertexScreenY[a];
			clippedColor[elements++] = this.faceColorA[face];
		} else {
			int xA = vertexViewSpaceX[a];
			int yA = vertexViewSpaceY[a];
			int colorA = this.faceColorA[face];

			if (zC >= 50) {
				int scalar = (50 - zA) * reciprical16[zC - zA];
				clippedX[elements] = centerX + (xA + ((vertexViewSpaceX[c] - xA) * scalar >> 16) << 9) / 50;
				clippedY[elements] = centerY + (yA + ((vertexViewSpaceY[c] - yA) * scalar >> 16) << 9) / 50;
				clippedColor[elements++] = colorA + ((this.faceColorC[face] - colorA) * scalar >> 16);
			}

			if (zB >= 50) {
				int scalar = (50 - zA) * reciprical16[zB - zA];
				clippedX[elements] = centerX + (xA + ((vertexViewSpaceX[b] - xA) * scalar >> 16) << 9) / 50;
				clippedY[elements] = centerY + (yA + ((vertexViewSpaceY[b] - yA) * scalar >> 16) << 9) / 50;
				clippedColor[elements++] = colorA + ((this.faceColorB[face] - colorA) * scalar >> 16);
			}
		}

		if (zB >= 50) {
			clippedX[elements] = vertexScreenX[b];
			clippedY[elements] = vertexScreenY[b];
			clippedColor[elements++] = this.faceColorB[face];
		} else {
			int xB = vertexViewSpaceX[b];
			int yB = vertexViewSpaceY[b];
			int colorB = this.faceColorB[face];

			if (zA >= 50) {
				int scalar = (50 - zB) * reciprical16[zA - zB];
				clippedX[elements] = centerX + (xB + ((vertexViewSpaceX[a] - xB) * scalar >> 16) << 9) / 50;
				clippedY[elements] = centerY + (yB + ((vertexViewSpaceY[a] - yB) * scalar >> 16) << 9) / 50;
				clippedColor[elements++] = colorB + ((this.faceColorA[face] - colorB) * scalar >> 16);
			}

			if (zC >= 50) {
				int scalar = (50 - zB) * reciprical16[zC - zB];
				clippedX[elements] = centerX + (xB + ((vertexViewSpaceX[c] - xB) * scalar >> 16) << 9) / 50;
				clippedY[elements] = centerY + (yB + ((vertexViewSpaceY[c] - yB) * scalar >> 16) << 9) / 50;
				clippedColor[elements++] = colorB + ((this.faceColorC[face] - colorB) * scalar >> 16);
			}
		}

		if (zC >= 50) {
			clippedX[elements] = vertexScreenX[c];
			clippedY[elements] = vertexScreenY[c];
			clippedColor[elements++] = this.faceColorC[face];
		} else {
			int xC = vertexViewSpaceX[c];
			int yC = vertexViewSpaceY[c];
			int colorC = this.faceColorC[face];

			if (zB >= 50) {
				int scalar = (50 - zC) * reciprical16[zB - zC];
				clippedX[elements] = centerX + (xC + ((vertexViewSpaceX[b] - xC) * scalar >> 16) << 9) / 50;
				clippedY[elements] = centerY + (yC + ((vertexViewSpaceY[b] - yC) * scalar >> 16) << 9) / 50;
				clippedColor[elements++] = colorC + ((this.faceColorB[face] - colorC) * scalar >> 16);
			}

			if (zA >= 50) {
				int scalar = (50 - zC) * reciprical16[zA - zC];
				clippedX[elements] = centerX + (xC + ((vertexViewSpaceX[a] - xC) * scalar >> 16) << 9) / 50;
				clippedY[elements] = centerY + (yC + ((vertexViewSpaceY[a] - yC) * scalar >> 16) << 9) / 50;
				clippedColor[elements++] = colorC + ((this.faceColorA[face] - colorC) * scalar >> 16);
			}
		}

		int x0 = clippedX[0];
		int x1 = clippedX[1];
		int x2 = clippedX[2];
		int y0 = clippedY[0];
		@Pc(582) int y1 = clippedY[1];
		@Pc(586) int y2 = clippedY[2];

		if ((x0 - x1) * (y2 - y1) - (y0 - y1) * (x2 - x1) <= 0) {
			return;
		}

		Draw3D.clipX = false;

		if (elements == 3) {
			if (x0 < 0 || x1 < 0 || x2 < 0 || x0 > Draw2D.boundX || x1 > Draw2D.boundX || x2 > Draw2D.boundX) {
				Draw3D.clipX = true;
			}

			int type;
			if (this.faceInfo == null) {
				type = 0;
			} else {
				type = this.faceInfo[face] & 0x3;
			}

			if (type == 0) {
				Draw3D.fillGouraudTriangle(x0, x1, x2, y0, y1, y2, clippedColor[0], clippedColor[1], clippedColor[2]);
			} else if (type == 1) {
				Draw3D.fillTriangle(x0, x1, x2, y0, y1, y2, palette[this.faceColorA[face]]);
			} else if (type == 2) {
				int texturedFace = this.faceInfo[face] >> 2;
				int tA = this.texturedVertexA[texturedFace];
				int tB = this.texturedVertexB[texturedFace];
				int tC = this.texturedVertexC[texturedFace];
				Draw3D.fillTexturedTriangle(x0, x1, x2, y0, y1, y2, clippedColor[0], clippedColor[1], clippedColor[2], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
			} else if (type == 3) {
				int texturedFace = this.faceInfo[face] >> 2;
				int tA = this.texturedVertexA[texturedFace];
				int tB = this.texturedVertexB[texturedFace];
				int tC = this.texturedVertexC[texturedFace];
				Draw3D.fillTexturedTriangle(x0, x1, x2, y0, y1, y2, this.faceColorA[face], this.faceColorA[face], this.faceColorA[face], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
			}
		} else if (elements == 4) {
			if (x0 < 0 || x1 < 0 || x2 < 0 || x0 > Draw2D.boundX || x1 > Draw2D.boundX || x2 > Draw2D.boundX || clippedX[3] < 0 || clippedX[3] > Draw2D.boundX) {
				Draw3D.clipX = true;
			}

			int type;
			if (this.faceInfo == null) {
				type = 0;
			} else {
				type = this.faceInfo[face] & 0x3;
			}

			if (type == 0) {
				Draw3D.fillGouraudTriangle(x0, x1, x2, y0, y1, y2, clippedColor[0], clippedColor[1], clippedColor[2]);
				Draw3D.fillGouraudTriangle(x0, x2, clippedX[3], y0, y2, clippedY[3], clippedColor[0], clippedColor[2], clippedColor[3]);
			} else if (type == 1) {
				int colorA = palette[this.faceColorA[face]];
				Draw3D.fillTriangle(x0, x1, x2, y0, y1, y2, colorA);
				Draw3D.fillTriangle(x0, x2, clippedX[3], y0, y2, clippedY[3], colorA);
			} else if (type == 2) {
				int texturedFace = this.faceInfo[face] >> 2;
				int tA = this.texturedVertexA[texturedFace];
				int tB = this.texturedVertexB[texturedFace];
				int tC = this.texturedVertexC[texturedFace];
				Draw3D.fillTexturedTriangle(x0, x1, x2, y0, y1, y2, clippedColor[0], clippedColor[1], clippedColor[2], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
				Draw3D.fillTexturedTriangle(x0, x2, clippedX[3], y0, y2, clippedY[3], clippedColor[0], clippedColor[2], clippedColor[3], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
			} else if (type == 3) {
				int texturedFace = this.faceInfo[face] >> 2;
				int tA = this.texturedVertexA[texturedFace];
				int tB = this.texturedVertexB[texturedFace];
				int tC = this.texturedVertexC[texturedFace];
				Draw3D.fillTexturedTriangle(x0, x1, x2, y0, y1, y2, this.faceColorA[face], this.faceColorA[face], this.faceColorA[face], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
				Draw3D.fillTexturedTriangle(x0, x2, clippedX[3], y0, y2, clippedY[3], this.faceColorA[face], this.faceColorA[face], this.faceColorA[face], vertexViewSpaceX[tA], vertexViewSpaceY[tA], vertexViewSpaceZ[tA], vertexViewSpaceX[tB], vertexViewSpaceX[tC], vertexViewSpaceY[tB], vertexViewSpaceY[tC], vertexViewSpaceZ[tB], vertexViewSpaceZ[tC], this.faceColor[face]);
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIIII)Z")
	private boolean pointWithinTriangle(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(2) int yA, @OriginalArg(3) int yB, @OriginalArg(4) int yC, @OriginalArg(5) int xA, @OriginalArg(6) int xB, @OriginalArg(7) int xC) {
		if (y < yA && y < yB && y < yC) {
			return false;
		} else if (y > yA && y > yB && y > yC) {
			return false;
		} else if (x < xA && x < xB && x < xC) {
			return false;
		} else {
			return x <= xA || x <= xB || x <= xC;
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
