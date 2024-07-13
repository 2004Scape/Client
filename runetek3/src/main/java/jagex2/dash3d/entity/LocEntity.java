package jagex2.dash3d.entity;

import jagex2.config.SeqType;
import jagex2.datastruct.Linkable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!nb")
public class LocEntity extends Linkable {

	@OriginalMember(owner = "client!nb", name = "e", descriptor = "I")
	public int level;

	@OriginalMember(owner = "client!nb", name = "f", descriptor = "I")
	public final int type;

	@OriginalMember(owner = "client!nb", name = "g", descriptor = "I")
	public final int x;

	@OriginalMember(owner = "client!nb", name = "h", descriptor = "I")
	public final int z;

	@OriginalMember(owner = "client!nb", name = "i", descriptor = "I")
	public final int index;

	@OriginalMember(owner = "client!nb", name = "j", descriptor = "Lclient!jc;")
	public final SeqType seq;

	@OriginalMember(owner = "client!nb", name = "k", descriptor = "I")
	public int seqFrame;

	@OriginalMember(owner = "client!nb", name = "l", descriptor = "I")
	public int seqCycle;

	@OriginalMember(owner = "client!nb", name = "<init>", descriptor = "(ZIIIILclient!jc;II)V")
	public LocEntity(@OriginalArg(1) int index, @OriginalArg(2) int level, @OriginalArg(4) int type, @OriginalArg(7) int x, @OriginalArg(6) int z, @OriginalArg(5) SeqType seq, @OriginalArg(0) boolean randomFrame) {
		this.level = level;
		this.type = type;
		this.x = x;
		this.z = z;
		this.index = index;
		this.seq = seq;

		if (randomFrame && seq.replayoff != -1) {
			this.seqFrame = (int) (Math.random() * (double) this.seq.frameCount);
			this.seqCycle = (int) (Math.random() * (double) this.seq.delay[this.seqFrame]);
		} else {
			this.seqFrame = -1;
			this.seqCycle = 0;
		}
	}
}
