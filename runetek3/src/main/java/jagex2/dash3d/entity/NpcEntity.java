package jagex2.dash3d.entity;

import jagex2.config.NpcType;
import jagex2.config.SeqType;
import jagex2.config.SpotAnimType;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!y")
public final class NpcEntity extends PathingEntity {

	@OriginalMember(owner = "client!y", name = "ib", descriptor = "Lclient!bc;")
	public NpcType type;

	@OriginalMember(owner = "client!y", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		if (this.type == null) {
			return null;
		} else if (super.spotanimId == -1 || super.spotanimFrame == -1) {
			return this.getSequencedModel();
		} else {
			@Pc(20) Model local20 = this.getSequencedModel();
			@Pc(25) SpotAnimType local25 = SpotAnimType.instances[super.spotanimId];
			@Pc(41) Model local41 = new Model(local25.getModel(), true, !local25.disposeAlpha, false);
			local41.translate(-super.spotanimOffset, 0, 0);
			local41.createLabelReferences();
			local41.applyTransform(local25.seq.primaryFrames[super.spotanimFrame]);
			local41.labelFaces = null;
			local41.labelVertices = null;
			if (local25.resizeh != 128 || local25.resizev != 128) {
				local41.scale(local25.resizeh, local25.resizev, local25.resizeh);
			}
			local41.calculateNormals(local25.ambient + 64, local25.contrast + 850, -30, -50, -30, true);
			@Pc(115) Model[] local115 = new Model[] { local20, local41 };
			@Pc(123) Model local123 = new Model(local115, 2, true);
			if (this.type.size == 1) {
				local123.pickable = true;
			}
			return local123;
		}
	}

	@OriginalMember(owner = "client!y", name = "c", descriptor = "(Z)Lclient!eb;")
	private Model getSequencedModel() {
		@Pc(14) int local14;
		if (super.primarySeqId >= 0 && super.primarySeqDelay == 0) {
			local14 = SeqType.instances[super.primarySeqId].primaryFrames[super.primarySeqFrame];
			@Pc(16) int local16 = -1;
			if (super.secondarySeqId >= 0 && super.secondarySeqId != super.seqStandId) {
				local16 = SeqType.instances[super.secondarySeqId].primaryFrames[super.secondarySeqFrame];
			}
			return this.type.getSequencedModel(local14, local16, SeqType.instances[super.primarySeqId].mask);
		}
		local14 = -1;
		if (super.secondarySeqId >= 0) {
			local14 = SeqType.instances[super.secondarySeqId].primaryFrames[super.secondarySeqFrame];
		}
		@Pc(71) Model local71 = this.type.getSequencedModel(local14, -1, null);
		super.height = local71.maxY;
		return local71;
	}

	@OriginalMember(owner = "client!y", name = "b", descriptor = "(Z)Z")
	@Override
	public boolean isVisible() {
		return this.type != null;
	}
}
