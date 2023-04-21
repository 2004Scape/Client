package jagex2.dash3d.type;

import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!k")
public final class GroundObj {

	@OriginalMember(owner = "client!k", name = "a", descriptor = "I")
	public int y;

	@OriginalMember(owner = "client!k", name = "b", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!k", name = "c", descriptor = "I")
	public int z;

	@OriginalMember(owner = "client!k", name = "d", descriptor = "Lclient!eb;")
	public Model topObj;

	@OriginalMember(owner = "client!k", name = "e", descriptor = "Lclient!eb;")
	public Model middleObj;

	@OriginalMember(owner = "client!k", name = "f", descriptor = "Lclient!eb;")
	public Model bottomObj;

	@OriginalMember(owner = "client!k", name = "g", descriptor = "I")
	public int bitset;

	@OriginalMember(owner = "client!k", name = "h", descriptor = "I")
	public int offset;
}
