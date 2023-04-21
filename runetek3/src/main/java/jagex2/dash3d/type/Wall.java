package jagex2.dash3d.type;

import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!q")
public final class Wall {

	@OriginalMember(owner = "client!q", name = "a", descriptor = "I")
	public int y;

	@OriginalMember(owner = "client!q", name = "b", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!q", name = "c", descriptor = "I")
	public int z;

	@OriginalMember(owner = "client!q", name = "d", descriptor = "I")
	public int typeA;

	@OriginalMember(owner = "client!q", name = "e", descriptor = "I")
	public int typeB;

	@OriginalMember(owner = "client!q", name = "f", descriptor = "Lclient!eb;")
	public Model modelA;

	@OriginalMember(owner = "client!q", name = "g", descriptor = "Lclient!eb;")
	public Model modelB;

	@OriginalMember(owner = "client!q", name = "h", descriptor = "I")
	public int bitset;

	@OriginalMember(owner = "client!q", name = "i", descriptor = "B")
	public byte info;
}
