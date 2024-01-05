package jagex2.dash3d.entity;

import jagex2.config.SpotAnimType;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bb")
public class SpotAnimEntity extends Entity {

	@OriginalMember(owner = "client!bb", name = "g", descriptor = "Lclient!kc;")
	private final SpotAnimType type;

	@OriginalMember(owner = "client!bb", name = "h", descriptor = "I")
	public final int startCycle;

	@OriginalMember(owner = "client!bb", name = "i", descriptor = "I")
	public final int level;

	@OriginalMember(owner = "client!bb", name = "j", descriptor = "I")
	public final int x;

	@OriginalMember(owner = "client!bb", name = "k", descriptor = "I")
	public final int z;

	@OriginalMember(owner = "client!bb", name = "l", descriptor = "I")
	public final int y;

	@OriginalMember(owner = "client!bb", name = "m", descriptor = "I")
	private int seqFrame;

	@OriginalMember(owner = "client!bb", name = "n", descriptor = "I")
	private int seqCycle;

	@OriginalMember(owner = "client!bb", name = "o", descriptor = "Z")
	public boolean seqComplete = false;

	@OriginalMember(owner = "client!bb", name = "<init>", descriptor = "(IIZIIIII)V")
	public SpotAnimEntity(@OriginalArg(1) int id, @OriginalArg(6) int level, @OriginalArg(0) int x, @OriginalArg(3) int z, @OriginalArg(5) int y, @OriginalArg(7) int cycle, @OriginalArg(4) int delay) {
		this.type = SpotAnimType.instances[id];
		this.level = level;
		this.x = x;
		this.z = z;
		this.y = y;
		this.startCycle = cycle + delay;
		this.seqComplete = false;
	}

	@OriginalMember(owner = "client!bb", name = "a", descriptor = "(II)V")
	public void update(@OriginalArg(0) int delta) {
		for (this.seqCycle += delta; this.seqCycle > this.type.seq.delay[this.seqFrame]; ) {
			this.seqCycle -= this.type.seq.delay[this.seqFrame] + 1;
			this.seqFrame++;

			if (this.seqFrame >= this.type.seq.frameCount) {
				this.seqFrame = 0;
				this.seqComplete = true;
			}
		}
	}

	@OriginalMember(owner = "client!bb", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		@Pc(3) Model tmp = this.type.getModel();
		@Pc(19) Model model = new Model(tmp, true, !this.type.disposeAlpha, false);

		if (!this.seqComplete) {
			model.createLabelReferences();
			model.applyTransform(this.type.seq.frames[this.seqFrame]);
			model.labelFaces = null;
			model.labelVertices = null;
		}

		if (this.type.resizeh != 128 || this.type.resizev != 128) {
			model.scale(this.type.resizeh, this.type.resizev, this.type.resizeh);
		}

		if (this.type.orientation != 0) {
			if (this.type.orientation == 90) {
				model.rotateY90();
			} else if (this.type.orientation == 180) {
				model.rotateY90();
				model.rotateY90();
			} else if (this.type.orientation == 270) {
				model.rotateY90();
				model.rotateY90();
				model.rotateY90();
			}
		}

		model.calculateNormals(64 + this.type.ambient, 850 + this.type.contrast, -30, -50, -30, true);
		return model;
	}
}
