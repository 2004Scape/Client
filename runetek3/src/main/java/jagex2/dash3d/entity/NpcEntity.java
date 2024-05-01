package jagex2.dash3d.entity;

import jagex2.config.NpcType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!y")
public class NpcEntity extends PathingEntity {

	@OriginalMember(owner = "client!y", name = "ib", descriptor = "Lclient!bc;")
	public NpcType type;

	@OriginalMember(owner = "client!y", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		if (this.type == null) {
			return null;
		}

		if (super.spotanimId == -1 || super.spotanimFrame == -1) {
			return this.getSequencedModel();
		}

		@Pc(20) Model model = this.getSequencedModel();
		@Pc(25) SpotAnimType spotanim = SpotAnimType.instances[super.spotanimId];

		@Pc(41) Model model1 = new Model(spotanim.getModel(), true, !spotanim.disposeAlpha, false);
		model1.translate(-super.spotanimOffset, 0, 0);
		model1.createLabelReferences();
		model1.applyTransform(spotanim.seq.frames[super.spotanimFrame]);
		model1.labelFaces = null;
		model1.labelVertices = null;

		if (spotanim.resizeh != 128 || spotanim.resizev != 128) {
			model1.scale(spotanim.resizeh, spotanim.resizev, spotanim.resizeh);
		}

		model1.calculateNormals(64 + spotanim.ambient, 850 + spotanim.contrast, -30, -50, -30, true);
		@Pc(115) Model[] models = new Model[] { model, model1 };

		@Pc(123) Model tmp = new Model(models, 2, true);
		if (this.type.size == 1) {
			tmp.pickable = true;
		}

		return tmp;
	}

	@OriginalMember(owner = "client!y", name = "c", descriptor = "(Z)Lclient!eb;")
	private Model getSequencedModel() {
		if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
			@Pc(14) int primaryTransformId = SeqType.instances[super.primarySeqId].frames[super.primarySeqFrame];
			@Pc(16) int secondaryTransformId = -1;
			if (super.secondarySeqId >= 0 && super.secondarySeqId != super.seqStandId) {
				secondaryTransformId = SeqType.instances[super.secondarySeqId].frames[super.secondarySeqFrame];
			}
			return this.type.getSequencedModel(primaryTransformId, secondaryTransformId, SeqType.instances[super.primarySeqId].walkmerge);
		}

		int transformId = -1;
		if (super.secondarySeqId >= 0) {
			transformId = SeqType.instances[super.secondarySeqId].frames[super.secondarySeqFrame];
		}

		@Pc(71) Model model = this.type.getSequencedModel(transformId, -1, null);
		super.height = model.maxY;
		return model;
	}

	@OriginalMember(owner = "client!y", name = "b", descriptor = "(Z)Z")
	@Override
	public boolean isVisible() {
		return this.type != null;
	}
}
