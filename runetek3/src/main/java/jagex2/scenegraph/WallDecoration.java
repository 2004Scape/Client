package jagex2.scenegraph;

import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!h")
public final class WallDecoration {

	@OriginalMember(owner = "client!h", name = "a", descriptor = "I")
	public int y;

	@OriginalMember(owner = "client!h", name = "b", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!h", name = "c", descriptor = "I")
	public int z;

	@OriginalMember(owner = "client!h", name = "d", descriptor = "I")
	public int type;

	@OriginalMember(owner = "client!h", name = "e", descriptor = "I")
	public int orientation;

	@OriginalMember(owner = "client!h", name = "f", descriptor = "Lclient!eb;")
	public Model model;

	@OriginalMember(owner = "client!h", name = "g", descriptor = "I")
	public int bitset;

	@OriginalMember(owner = "client!h", name = "h", descriptor = "B")
	public byte info;
}
