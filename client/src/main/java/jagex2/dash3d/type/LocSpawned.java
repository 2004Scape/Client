package jagex2.dash3d.type;

import jagex2.datastruct.Linkable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!mb")
public final class LocSpawned extends Linkable {

	@OriginalMember(owner = "client!mb", name = "f", descriptor = "I")
	public final int plane;

	@OriginalMember(owner = "client!mb", name = "g", descriptor = "I")
	public final int classType;

	@OriginalMember(owner = "client!mb", name = "h", descriptor = "I")
	public final int x;

	@OriginalMember(owner = "client!mb", name = "i", descriptor = "I")
	public final int z;

	@OriginalMember(owner = "client!mb", name = "j", descriptor = "I")
	public final int locIndex;

	@OriginalMember(owner = "client!mb", name = "k", descriptor = "I")
	public final int orientation;

	@OriginalMember(owner = "client!mb", name = "l", descriptor = "I")
	public final int type;

	@OriginalMember(owner = "client!mb", name = "m", descriptor = "I")
	public final int lastCycle;

	@OriginalMember(owner = "client!mb", name = "<init>", descriptor = "(IIIIIIIII)V")
	public LocSpawned(@OriginalArg(0) int plane, @OriginalArg(1) int orientation, @OriginalArg(2) int z, @OriginalArg(3) int lastCycle, @OriginalArg(5) int type, @OriginalArg(6) int locIndex, @OriginalArg(7) int x, @OriginalArg(8) int classType) {
		this.plane = plane;
		this.classType = classType;
		this.x = x;
		this.z = z;
		this.locIndex = locIndex;
		this.orientation = orientation;
		this.type = type;
		this.lastCycle = lastCycle;
	}
}
