package jagex2.dash3d.type;

import jagex2.dash3d.entity.Entity;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!p")
public final class Loc {

	@OriginalMember(owner = "client!p", name = "a", descriptor = "I")
	public int level;

	@OriginalMember(owner = "client!p", name = "b", descriptor = "I")
	public int y;

	@OriginalMember(owner = "client!p", name = "c", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!p", name = "d", descriptor = "I")
	public int z;

	@OriginalMember(owner = "client!p", name = "e", descriptor = "Lclient!eb;")
	public Model model;

	@OriginalMember(owner = "client!p", name = "f", descriptor = "Lclient!w;")
	public Entity entity;

	@OriginalMember(owner = "client!p", name = "g", descriptor = "I")
	public int yaw;

	@OriginalMember(owner = "client!p", name = "h", descriptor = "I")
	public int minSceneTileX;

	@OriginalMember(owner = "client!p", name = "i", descriptor = "I")
	public int maxSceneTileX;

	@OriginalMember(owner = "client!p", name = "j", descriptor = "I")
	public int minSceneTileZ;

	@OriginalMember(owner = "client!p", name = "k", descriptor = "I")
	public int maxSceneTileZ;

	@OriginalMember(owner = "client!p", name = "l", descriptor = "I")
	public int distance;

	@OriginalMember(owner = "client!p", name = "m", descriptor = "I")
	public int cycle;

	@OriginalMember(owner = "client!p", name = "n", descriptor = "I")
	public int bitset;

	@OriginalMember(owner = "client!p", name = "o", descriptor = "B")
	public byte info;
}
