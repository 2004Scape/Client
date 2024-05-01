package jagex2.dash3d.type;

import jagex2.datastruct.Linkable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mb")
public class LocSpawned extends Linkable {

	@OriginalMember(owner = "client!mb", name = "f", descriptor = "I")
	public final int plane;

	@OriginalMember(owner = "client!mb", name = "g", descriptor = "I")
	public final int layer;

	@OriginalMember(owner = "client!mb", name = "h", descriptor = "I")
	public final int x;

	@OriginalMember(owner = "client!mb", name = "i", descriptor = "I")
	public final int z;

	@OriginalMember(owner = "client!mb", name = "j", descriptor = "I")
	public final int locIndex;

	@OriginalMember(owner = "client!mb", name = "k", descriptor = "I")
	public final int angle;

	@OriginalMember(owner = "client!mb", name = "l", descriptor = "I")
	public final int shape;

	@OriginalMember(owner = "client!mb", name = "m", descriptor = "I")
	public final int lastCycle;

	@OriginalMember(owner = "client!mb", name = "<init>", descriptor = "(IIIIIIIII)V")
	public LocSpawned(@OriginalArg(0) int plane, @OriginalArg(8) int layer, @OriginalArg(7) int x, @OriginalArg(2) int z, @OriginalArg(6) int locIndex, @OriginalArg(1) int angle, @OriginalArg(5) int shape, @OriginalArg(3) int lastCycle) {
		this.plane = plane;
		this.layer = layer;
		this.x = x;
		this.z = z;
		this.locIndex = locIndex;
		this.angle = angle;
		this.shape = shape;
		this.lastCycle = lastCycle;
	}
}
