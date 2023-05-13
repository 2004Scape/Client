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
	public LocSpawned(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		this.plane = arg0;
		this.classType = arg8;
		this.x = arg7;
		this.z = arg2;
		this.locIndex = arg6;
		this.orientation = arg1;
		this.type = arg5;
		this.lastCycle = arg3;
	}
}
