import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!lb")
public final class SceneLocTemporary extends Node {

	@OriginalMember(owner = "client!lb", name = "e", descriptor = "I")
	public int plane;

	@OriginalMember(owner = "client!lb", name = "f", descriptor = "I")
	public int classType;

	@OriginalMember(owner = "client!lb", name = "g", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!lb", name = "h", descriptor = "I")
	public int z;

	@OriginalMember(owner = "client!lb", name = "i", descriptor = "I")
	public int locIndex;

	@OriginalMember(owner = "client!lb", name = "j", descriptor = "I")
	public int orientation;

	@OriginalMember(owner = "client!lb", name = "k", descriptor = "I")
	public int type;

	@OriginalMember(owner = "client!lb", name = "l", descriptor = "I")
	public int lastLocIndex;

	@OriginalMember(owner = "client!lb", name = "m", descriptor = "I")
	public int lastOrientation;

	@OriginalMember(owner = "client!lb", name = "n", descriptor = "I")
	public int lastType;
}
