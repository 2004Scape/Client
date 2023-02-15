import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!z")
public final class PlayerEntity extends PathingEntity {

	@OriginalMember(owner = "client!client", name = "qh", descriptor = "[I")
	public static final int[] designHairColor = new int[] { 9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486 };

	@OriginalMember(owner = "client!client", name = "Oe", descriptor = "[[I")
	public static final int[][] designPartColor = new int[][] { { 6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193 }, { 8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239 }, { 25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003 }, { 4626, 11146, 6439, 12, 4758, 10270 }, { 4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574 } };

	@OriginalMember(owner = "client!z", name = "gb", descriptor = "I")
	private int flowObfuscator1;

	@OriginalMember(owner = "client!z", name = "hb", descriptor = "Z")
	private boolean flowObfuscator2 = false;

	@OriginalMember(owner = "client!z", name = "ib", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "client!z", name = "jb", descriptor = "Z")
	private boolean visible = false;

	@OriginalMember(owner = "client!z", name = "kb", descriptor = "I")
	private int gender;

	@OriginalMember(owner = "client!z", name = "lb", descriptor = "I")
	public int headicons;

	@OriginalMember(owner = "client!z", name = "mb", descriptor = "[I")
	private final int[] appearances = new int[12];

	@OriginalMember(owner = "client!z", name = "nb", descriptor = "[I")
	private final int[] colors = new int[5];

	@OriginalMember(owner = "client!z", name = "ob", descriptor = "I")
	public int combatLevel;

	@OriginalMember(owner = "client!z", name = "pb", descriptor = "J")
	private long appearanceHashcode;

	@OriginalMember(owner = "client!z", name = "qb", descriptor = "I")
	public int y;

	@OriginalMember(owner = "client!z", name = "rb", descriptor = "I")
	public int locStartCycle;

	@OriginalMember(owner = "client!z", name = "sb", descriptor = "I")
	public int locStopCycle;

	@OriginalMember(owner = "client!z", name = "tb", descriptor = "I")
	public int locOffsetX;

	@OriginalMember(owner = "client!z", name = "ub", descriptor = "I")
	public int locOffsetY;

	@OriginalMember(owner = "client!z", name = "vb", descriptor = "I")
	public int locOffsetZ;

	@OriginalMember(owner = "client!z", name = "wb", descriptor = "Lclient!eb;")
	public Model locModel;

	@OriginalMember(owner = "client!z", name = "xb", descriptor = "I")
	public int minTileX;

	@OriginalMember(owner = "client!z", name = "yb", descriptor = "I")
	public int minTileZ;

	@OriginalMember(owner = "client!z", name = "zb", descriptor = "I")
	public int maxTileX;

	@OriginalMember(owner = "client!z", name = "Ab", descriptor = "I")
	public int maxTileZ;

	@OriginalMember(owner = "client!z", name = "Bb", descriptor = "Z")
	public boolean lowMemory = false;

	@OriginalMember(owner = "client!z", name = "Cb", descriptor = "Lclient!s;")
	public static Cache modelCache = new Cache((byte) 0, 200);

	@OriginalMember(owner = "client!z", name = "a", descriptor = "(ZLclient!kb;)V")
	public void read(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer buf) {
		try {
			buf.pos = 0;
			this.gender = buf.g1();
			this.headicons = buf.g1();
			@Pc(19) int local19;
			@Pc(31) int local31;
			for (@Pc(14) int local14 = 0; local14 < 12; local14++) {
				local19 = buf.g1();
				if (local19 == 0) {
					this.appearances[local14] = 0;
				} else {
					local31 = buf.g1();
					this.appearances[local14] = (local19 << 8) + local31;
				}
			}
			for (local19 = 0; local19 < 5; local19++) {
				local31 = buf.g1();
				if (local31 < 0 || local31 >= designPartColor[local19].length) {
					local31 = 0;
				}
				this.colors[local19] = local31;
			}
			if (!arg0) {
				super.seqStandId = buf.g2();
				if (super.seqStandId == 65535) {
					super.seqStandId = -1;
				}
				super.seqTurnId = buf.g2();
				if (super.seqTurnId == 65535) {
					super.seqTurnId = -1;
				}
				super.seqWalkId = buf.g2();
				if (super.seqWalkId == 65535) {
					super.seqWalkId = -1;
				}
				super.seqTurnAroundId = buf.g2();
				if (super.seqTurnAroundId == 65535) {
					super.seqTurnAroundId = -1;
				}
				super.seqTurnLeftId = buf.g2();
				if (super.seqTurnLeftId == 65535) {
					super.seqTurnLeftId = -1;
				}
				super.seqTurnRightId = buf.g2();
				if (super.seqTurnRightId == 65535) {
					super.seqTurnRightId = -1;
				}
				super.seqRunId = buf.g2();
				if (super.seqRunId == 65535) {
					super.seqRunId = -1;
				}
				this.name = StringUtils.formatName(0, StringUtils.fromBase37(buf.g8(603), false));
				this.combatLevel = buf.g1();
				this.visible = true;
				this.appearanceHashcode = 0L;
				for (local31 = 0; local31 < 12; local31++) {
					this.appearanceHashcode <<= 0x4;
					if (this.appearances[local31] >= 256) {
						this.appearanceHashcode += this.appearances[local31] - 256;
					}
				}
				if (this.appearances[0] >= 256) {
					this.appearanceHashcode += this.appearances[0] - 256 >> 4;
				}
				if (this.appearances[1] >= 256) {
					this.appearanceHashcode += this.appearances[1] - 256 >> 8;
				}
				for (@Pc(243) int local243 = 0; local243 < 5; local243++) {
					this.appearanceHashcode <<= 0x3;
					this.appearanceHashcode += this.colors[local243];
				}
				this.appearanceHashcode <<= 0x1;
				this.appearanceHashcode += this.gender;
			}
		} catch (@Pc(281) RuntimeException local281) {
			signlink.reporterror("66007, " + arg0 + ", " + buf + ", " + local281.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!z", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(@OriginalArg(0) boolean arg0) {
		try {
			if (!this.visible) {
				return null;
			}
			@Pc(10) Model local10 = this.getSequencedModel(false);
			super.height = local10.maxY;
			local10.pickable = true;
			if (this.lowMemory) {
				return local10;
			}
			if (super.spotanimId != -1 && super.spotanimFrame != -1) {
				@Pc(35) SpotAnimType local35 = SpotAnimType.instances[super.spotanimId];
				@Pc(51) Model local51 = new Model(local35.getModel(), true, !local35.disposeAlpha, this.flowObfuscator1, false);
				local51.translate(-super.spotanimOffset, 0, -122, 0);
				local51.createLabelReferences(4);
				local51.applyTransform(-16599, local35.seq.primaryFrames[super.spotanimFrame]);
				local51.labelFaces = null;
				local51.labelVertices = null;
				if (local35.resizeh != 128 || local35.resizev != 128) {
					local51.scale(local35.resizeh, 2, local35.resizev, local35.resizeh);
				}
				local51.calculateNormals(local35.ambient + 64, local35.contrast + 850, -30, -50, -30, true);
				@Pc(119) Model[] local119 = new Model[] { local10, local51 };
				local10 = new Model(local119, (byte) -31, 2, true);
			}
			if (this.locModel != null) {
				if (Game.loopCycle >= this.locStopCycle) {
					this.locModel = null;
				}
				if (Game.loopCycle >= this.locStartCycle && Game.loopCycle < this.locStopCycle) {
					@Pc(148) Model local148 = this.locModel;
					local148.translate(this.locOffsetY - this.y, this.locOffsetX - super.x, -122, this.locOffsetZ - super.z);
					if (super.dstYaw == 512) {
						local148.rotateY90(0);
						local148.rotateY90(0);
						local148.rotateY90(0);
					} else if (super.dstYaw == 1024) {
						local148.rotateY90(0);
						local148.rotateY90(0);
					} else if (super.dstYaw == 1536) {
						local148.rotateY90(0);
					}
					@Pc(211) Model[] local211 = new Model[] { local10, local148 };
					local10 = new Model(local211, (byte) -31, 2, true);
					if (super.dstYaw == 512) {
						local148.rotateY90(0);
					} else if (super.dstYaw == 1024) {
						local148.rotateY90(0);
						local148.rotateY90(0);
					} else if (super.dstYaw == 1536) {
						local148.rotateY90(0);
						local148.rotateY90(0);
						local148.rotateY90(0);
					}
					local148.translate(this.y - this.locOffsetY, super.x - this.locOffsetX, -122, super.z - this.locOffsetZ);
				}
			}
			local10.pickable = true;
			if (!arg0) {
				for (@Pc(278) int local278 = 1; local278 > 0; local278++) {
				}
			}
			return local10;
		} catch (@Pc(286) RuntimeException local286) {
			signlink.reporterror("53201, " + arg0 + ", " + local286.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!z", name = "c", descriptor = "(Z)Lclient!eb;")
	private Model getSequencedModel(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(4) long local4 = this.appearanceHashcode;
			@Pc(6) int local6 = -1;
			@Pc(8) int local8 = -1;
			@Pc(10) int local10 = -1;
			@Pc(12) int local12 = -1;
			if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
				@Pc(23) SeqType local23 = SeqType.instances[super.primarySeqId];
				local6 = local23.primaryFrames[super.primarySeqFrame];
				if (super.secondarySeqId >= 0 && super.secondarySeqId != super.seqStandId) {
					local8 = SeqType.instances[super.secondarySeqId].primaryFrames[super.secondarySeqFrame];
				}
				if (local23.mainhand >= 0) {
					local10 = local23.mainhand;
					local4 += local10 - this.appearances[5] << 8;
				}
				if (local23.offhand >= 0) {
					local12 = local23.offhand;
					local4 += local12 - this.appearances[3] << 16;
				}
			} else if (super.secondarySeqId >= 0) {
				local6 = SeqType.instances[super.secondarySeqId].primaryFrames[super.secondarySeqFrame];
			}
			@Pc(101) Model local101 = (Model) modelCache.get(local4);
			if (local101 == null) {
				@Pc(106) Model[] local106 = new Model[12];
				@Pc(108) int local108 = 0;
				@Pc(117) int local117;
				for (@Pc(110) int local110 = 0; local110 < 12; local110++) {
					local117 = this.appearances[local110];
					if (local12 >= 0 && local110 == 3) {
						local117 = local12;
					}
					if (local10 >= 0 && local110 == 5) {
						local117 = local10;
					}
					if (local117 >= 256 && local117 < 512) {
						local106[local108++] = IdkType.instances[local117 - 256].getModel();
					}
					if (local117 >= 512) {
						@Pc(155) ObjType local155 = ObjType.get(local117 - 512);
						@Pc(161) Model local161 = local155.getWornModel((byte) 6, this.gender);
						if (local161 != null) {
							local106[local108++] = local161;
						}
					}
				}
				local101 = new Model(0, local106, local108);
				for (local117 = 0; local117 < 5; local117++) {
					if (this.colors[local117] != 0) {
						local101.recolor(designPartColor[local117][0], designPartColor[local117][this.colors[local117]]);
						if (local117 == 1) {
							local101.recolor(designHairColor[0], designHairColor[this.colors[local117]]);
						}
					}
				}
				local101.createLabelReferences(4);
				local101.calculateNormals(64, 850, -30, -50, -30, true);
				modelCache.put(6, local4, local101);
			}
			if (this.lowMemory) {
				return local101;
			}
			@Pc(249) Model local249 = new Model(0, local101, true);
			if (arg0) {
				this.flowObfuscator2 = !this.flowObfuscator2;
			}
			if (local6 != -1 && local8 != -1) {
				local249.applyTransforms(local8, 3, local6, SeqType.instances[super.primarySeqId].mask);
			} else if (local6 != -1) {
				local249.applyTransform(-16599, local6);
			}
			local249.calculateBoundsCylinder(2992);
			local249.labelFaces = null;
			local249.labelVertices = null;
			return local249;
		} catch (@Pc(296) RuntimeException local296) {
			signlink.reporterror("77654, " + arg0 + ", " + local296.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!z", name = "a", descriptor = "(I)Lclient!eb;")
	public Model getHeadModel(@OriginalArg(0) int arg0) {
		try {
			if (!this.visible) {
				return null;
			}
			@Pc(9) Model[] local9 = new Model[12];
			@Pc(11) int local11 = 0;
			for (@Pc(13) int local13 = 0; local13 < 12; local13++) {
				@Pc(20) int local20 = this.appearances[local13];
				if (local20 >= 256 && local20 < 512) {
					local9[local11++] = IdkType.instances[local20 - 256].getHeadModel(false);
				}
				if (local20 >= 512) {
					@Pc(49) Model local49 = ObjType.get(local20 - 512).getModel(-22246, this.gender);
					if (local49 != null) {
						local9[local11++] = local49;
					}
				}
			}
			@Pc(67) Model local67 = new Model(0, local9, local11);
			for (@Pc(69) int local69 = 0; local69 < 5; local69++) {
				if (this.colors[local69] != 0) {
					local67.recolor(designPartColor[local69][0], designPartColor[local69][this.colors[local69]]);
					if (local69 == 1) {
						local67.recolor(designHairColor[0], designHairColor[this.colors[local69]]);
					}
				}
			}
			if (arg0 >= 0) {
				throw new NullPointerException();
			}
			return local67;
		} catch (@Pc(120) RuntimeException local120) {
			signlink.reporterror("60004, " + arg0 + ", " + local120.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!z", name = "b", descriptor = "(Z)Z")
	@Override
	public boolean isVisible(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				this.flowObfuscator2 = !this.flowObfuscator2;
			}
			return this.visible;
		} catch (@Pc(17) RuntimeException local17) {
			signlink.reporterror("46403, " + arg0 + ", " + local17.toString());
			throw new RuntimeException();
		}
	}
}
