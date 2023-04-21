package jagex2.dash3d.entity;

import jagex2.config.SeqType;
import jagex2.datastruct.Linkable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nb")
public final class LocEntity extends Linkable {

	@OriginalMember(owner = "client!nb", name = "e", descriptor = "I")
	public int heightmapSW;

	@OriginalMember(owner = "client!nb", name = "f", descriptor = "I")
	public final int heightmapSE;

	@OriginalMember(owner = "client!nb", name = "g", descriptor = "I")
	public final int heightmapNE;

	@OriginalMember(owner = "client!nb", name = "h", descriptor = "I")
	public final int heightmapNW;

	@OriginalMember(owner = "client!nb", name = "i", descriptor = "I")
	public final int index;

	@OriginalMember(owner = "client!nb", name = "j", descriptor = "Lclient!jc;")
	public final SeqType seq;

	@OriginalMember(owner = "client!nb", name = "k", descriptor = "I")
	public int seqFrame;

	@OriginalMember(owner = "client!nb", name = "l", descriptor = "I")
	public int seqCycle;

	@OriginalMember(owner = "client!nb", name = "<init>", descriptor = "(ZIIIILclient!jc;II)V")
	public LocEntity(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg4, @OriginalArg(5) SeqType arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		this.heightmapSW = arg2;
		this.heightmapSE = arg4;
		this.heightmapNE = arg7;
		this.heightmapNW = arg6;
		this.index = arg1;
		this.seq = arg5;
		if (arg0 && arg5.replayoff != -1) {
			this.seqFrame = (int) (Math.random() * (double) this.seq.framecount);
			this.seqCycle = (int) (Math.random() * (double) this.seq.frameDelay[this.seqFrame]);
		} else {
			this.seqFrame = -1;
			this.seqCycle = 0;
		}
	}
}
