package jagex2.dash3d.entity;

import jagex2.config.IdkType;
import jagex2.config.ObjType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.datastruct.JString;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!z")
public class PlayerEntity extends PathingEntity {

	@OriginalMember(owner = "client!client", name = "qh", descriptor = "[I")
	public static final int[] DESIGN_HAIR_COLOR = new int[] {
		9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486
	};

	@OriginalMember(owner = "client!client", name = "Oe", descriptor = "[[I")
	public static final int[][] DESIGN_BODY_COLOR = new int[][] {
		{ 6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193 },
		{ 8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239 },
		{ 25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003 },
		{ 4626, 11146, 6439, 12, 4758, 10270 },
		{ 4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574 }
	};

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
	public static LruCache modelCache = new LruCache(200);

	@OriginalMember(owner = "client!z", name = "a", descriptor = "(ZLclient!kb;)V")
	public void read(@OriginalArg(1) Packet buf) {
		buf.pos = 0;

		this.gender = buf.g1();
		this.headicons = buf.g1();

		for (@Pc(14) int part = 0; part < 12; part++) {
			int msb = buf.g1();
			if (msb == 0) {
				this.appearances[part] = 0;
			} else {
				int lsb = buf.g1();
				this.appearances[part] = (msb << 8) + lsb;
			}
		}

		for (int part = 0; part < 5; part++) {
			int color = buf.g1();
			if (color < 0 || color >= DESIGN_BODY_COLOR[part].length) {
				color = 0;
			}

			this.colors[part] = color;
		}

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

		this.name = JString.formatName(JString.fromBase37(buf.g8()));
		this.combatLevel = buf.g1();

		this.visible = true;
		this.appearanceHashcode = 0L;
		for (int part = 0; part < 12; part++) {
			this.appearanceHashcode <<= 0x4;

			if (this.appearances[part] >= 256) {
				this.appearanceHashcode += this.appearances[part] - 256;
			}
		}

		if (this.appearances[0] >= 256) {
			this.appearanceHashcode += this.appearances[0] - 256 >> 4;
		}

		if (this.appearances[1] >= 256) {
			this.appearanceHashcode += this.appearances[1] - 256 >> 8;
		}

		for (@Pc(243) int part = 0; part < 5; part++) {
			this.appearanceHashcode <<= 0x3;
			this.appearanceHashcode += this.colors[part];
		}

		this.appearanceHashcode <<= 0x1;
		this.appearanceHashcode += this.gender;
	}

	@OriginalMember(owner = "client!z", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		if (!this.visible) {
			return null;
		}

		@Pc(10) Model model = this.getSequencedModel();
		super.height = model.maxY;
		model.pickable = true;

		if (this.lowMemory) {
			return model;
		}

		if (super.spotanimId != -1 && super.spotanimFrame != -1) {
			@Pc(35) SpotAnimType spotanim = SpotAnimType.instances[super.spotanimId];
			@Pc(51) Model model2 = new Model(spotanim.getModel(), true, !spotanim.disposeAlpha, false);

			model2.translate(-super.spotanimOffset, 0, 0);
			model2.createLabelReferences();
			model2.applyTransform(spotanim.seq.frames[super.spotanimFrame]);
			model2.labelFaces = null;
			model2.labelVertices = null;
			if (spotanim.resizeh != 128 || spotanim.resizev != 128) {
				model2.scale(spotanim.resizeh, spotanim.resizev, spotanim.resizeh);
			}
			model2.calculateNormals(spotanim.ambient + 64, spotanim.contrast + 850, -30, -50, -30, true);

			@Pc(119) Model[] models = new Model[] { model, model2 };
			model = new Model(models, 2, true);
		}

		if (this.locModel != null) {
			if (loopCycle >= this.locStopCycle) {
				this.locModel = null;
			}

			if (loopCycle >= this.locStartCycle && loopCycle < this.locStopCycle) {
				@Pc(148) Model loc = this.locModel;
				loc.translate(this.locOffsetY - this.y, this.locOffsetX - super.x, this.locOffsetZ - super.z);
				if (super.dstYaw == 512) {
					loc.rotateY90();
					loc.rotateY90();
					loc.rotateY90();
				} else if (super.dstYaw == 1024) {
					loc.rotateY90();
					loc.rotateY90();
				} else if (super.dstYaw == 1536) {
					loc.rotateY90();
				}

				@Pc(211) Model[] models = new Model[] { model, loc };
				model = new Model(models, 2, true);
				if (super.dstYaw == 512) {
					loc.rotateY90();
				} else if (super.dstYaw == 1024) {
					loc.rotateY90();
					loc.rotateY90();
				} else if (super.dstYaw == 1536) {
					loc.rotateY90();
					loc.rotateY90();
					loc.rotateY90();
				}

				loc.translate(this.y - this.locOffsetY, super.x - this.locOffsetX, super.z - this.locOffsetZ);
			}
		}

		model.pickable = true;
		return model;
	}

	@OriginalMember(owner = "client!z", name = "c", descriptor = "(Z)Lclient!eb;")
	private Model getSequencedModel() {
		@Pc(4) long hashCode = this.appearanceHashcode;
		@Pc(6) int primaryTransformId = -1;
		@Pc(8) int secondaryTransformId = -1;
		@Pc(10) int rightHandValue = -1;
		@Pc(12) int leftHandValue = -1;

		if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
			@Pc(23) SeqType seq = SeqType.instances[super.primarySeqId];

			primaryTransformId = seq.frames[super.primarySeqFrame];
			if (super.secondarySeqId >= 0 && super.secondarySeqId != super.seqStandId) {
				secondaryTransformId = SeqType.instances[super.secondarySeqId].frames[super.secondarySeqFrame];
			}

			if (seq.righthand >= 0) {
				rightHandValue = seq.righthand;
				hashCode += (long) rightHandValue - this.appearances[5] << 8;
			}

			if (seq.lefthand >= 0) {
				leftHandValue = seq.lefthand;
				hashCode += (long) leftHandValue - this.appearances[3] << 16;
			}
		} else if (super.secondarySeqId >= 0) {
			primaryTransformId = SeqType.instances[super.secondarySeqId].frames[super.secondarySeqFrame];
		}

		@Pc(101) Model model = (Model) modelCache.get(hashCode);
		if (model == null) {
			@Pc(106) Model[] models = new Model[12];
			@Pc(108) int modelCount = 0;

			for (@Pc(110) int part = 0; part < 12; part++) {
				int value = this.appearances[part];

				if (leftHandValue >= 0 && part == 3) {
					value = leftHandValue;
				}

				if (rightHandValue >= 0 && part == 5) {
					value = rightHandValue;
				}

				if (value >= 256 && value < 512) {
					models[modelCount++] = IdkType.instances[value - 256].getModel();
				}

				if (value >= 512) {
					@Pc(155) ObjType obj = ObjType.get(value - 512);
					@Pc(161) Model wornModel = obj.getWornModel(this.gender);

					if (wornModel != null) {
						models[modelCount++] = wornModel;
					}
				}
			}

			model = new Model(models, modelCount);
			for (int part = 0; part < 5; part++) {
				if (this.colors[part] != 0) {
					model.recolor(DESIGN_BODY_COLOR[part][0], DESIGN_BODY_COLOR[part][this.colors[part]]);

					if (part == 1) {
						model.recolor(DESIGN_HAIR_COLOR[0], DESIGN_HAIR_COLOR[this.colors[part]]);
					}
				}
			}

			model.createLabelReferences();
			model.calculateNormals(64, 850, -30, -50, -30, true);
			modelCache.put(hashCode, model);
		}

		if (this.lowMemory) {
			return model;
		}

		@Pc(249) Model tmp = new Model(model, true);
		if (primaryTransformId != -1 && secondaryTransformId != -1) {
			tmp.applyTransforms(primaryTransformId, secondaryTransformId, SeqType.instances[super.primarySeqId].walkmerge);
		} else if (primaryTransformId != -1) {
			tmp.applyTransform(primaryTransformId);
		}

		tmp.calculateBoundsCylinder();
		tmp.labelFaces = null;
		tmp.labelVertices = null;
		return tmp;
	}

	@OriginalMember(owner = "client!z", name = "a", descriptor = "(I)Lclient!eb;")
	public Model getHeadModel() {
		if (!this.visible) {
			return null;
		}

		@Pc(9) Model[] models = new Model[12];
		@Pc(11) int modelCount = 0;
		for (@Pc(13) int part = 0; part < 12; part++) {
			@Pc(20) int value = this.appearances[part];

			if (value >= 256 && value < 512) {
				models[modelCount++] = IdkType.instances[value - 256].getHeadModel();
			}

			if (value >= 512) {
				@Pc(49) Model headModel = ObjType.get(value - 512).getHeadModel(this.gender);

				if (headModel != null) {
					models[modelCount++] = headModel;
				}
			}
		}

		@Pc(67) Model tmp = new Model(models, modelCount);
		for (@Pc(69) int part = 0; part < 5; part++) {
			if (this.colors[part] != 0) {
				tmp.recolor(DESIGN_BODY_COLOR[part][0], DESIGN_BODY_COLOR[part][this.colors[part]]);

				if (part == 1) {
					tmp.recolor(DESIGN_HAIR_COLOR[0], DESIGN_HAIR_COLOR[this.colors[part]]);
				}
			}
		}

		return tmp;
	}

	@OriginalMember(owner = "client!z", name = "b", descriptor = "(Z)Z")
	@Override
	public boolean isVisible() {
		return this.visible;
	}
}
