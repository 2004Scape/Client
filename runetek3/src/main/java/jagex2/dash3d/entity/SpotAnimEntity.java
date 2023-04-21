package jagex2.dash3d.entity;

import jagex2.config.SpotAnimType;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!bb")
public final class SpotAnimEntity extends Entity {

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
	public SpotAnimEntity(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		this.type = SpotAnimType.instances[arg1];
		this.level = arg6;
		this.x = arg0;
		this.z = arg3;
		this.y = arg5;
		this.startCycle = arg7 + arg4;
		this.seqComplete = false;
	}

	@OriginalMember(owner = "client!bb", name = "a", descriptor = "(II)V")
	public void update(@OriginalArg(0) int arg0) {
		this.seqCycle += arg0;
		while (true) {
			do {
				do {
					if (this.seqCycle <= this.type.seq.frameDelay[this.seqFrame]) {
						return;
					}
					this.seqCycle -= this.type.seq.frameDelay[this.seqFrame] + 1;
					this.seqFrame++;
				} while (this.seqFrame < this.type.seq.framecount);
			} while (this.seqFrame >= 0 && this.seqFrame < this.type.seq.framecount);
			this.seqFrame = 0;
			this.seqComplete = true;
		}
	}

	@OriginalMember(owner = "client!bb", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		@Pc(3) Model local3 = this.type.getModel();
		@Pc(19) Model local19 = new Model(local3, true, !this.type.disposeAlpha, false);
		if (!this.seqComplete) {
			local19.createLabelReferences();
			local19.applyTransform(this.type.seq.primaryFrames[this.seqFrame]);
			local19.labelFaces = null;
			local19.labelVertices = null;
		}
		if (this.type.resizeh != 128 || this.type.resizev != 128) {
			local19.scale(this.type.resizeh, this.type.resizev, this.type.resizeh);
		}
		if (this.type.orientation != 0) {
			if (this.type.orientation == 90) {
				local19.rotateY90();
			}
			if (this.type.orientation == 180) {
				local19.rotateY90();
				local19.rotateY90();
			}
			if (this.type.orientation == 270) {
				local19.rotateY90();
				local19.rotateY90();
				local19.rotateY90();
			}
		}
		local19.calculateNormals(this.type.ambient + 64, this.type.contrast + 850, -30, -50, -30, true);
		return local19;
	}
}
