import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!v")
public final class ObjEntity extends Node {

	@OriginalMember(owner = "client!v", name = "e", descriptor = "I")
	public int index;

	@OriginalMember(owner = "client!v", name = "f", descriptor = "I")
	public int count;
}
