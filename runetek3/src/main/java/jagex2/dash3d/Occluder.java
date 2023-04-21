package jagex2.dash3d;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

// Occluder: Occludes (hides) tiles behind it
@OriginalClass("client!m")
public final class Occluder {

	@OriginalMember(owner = "client!m", name = "a", descriptor = "I")
	public int minTileX;

	@OriginalMember(owner = "client!m", name = "b", descriptor = "I")
	public int maxTileX;

	@OriginalMember(owner = "client!m", name = "c", descriptor = "I")
	public int minTileZ;

	@OriginalMember(owner = "client!m", name = "d", descriptor = "I")
	public int maxTileZ;

	@OriginalMember(owner = "client!m", name = "e", descriptor = "I")
	public int type;

	@OriginalMember(owner = "client!m", name = "f", descriptor = "I")
	public int minX;

	@OriginalMember(owner = "client!m", name = "g", descriptor = "I")
	public int maxX;

	@OriginalMember(owner = "client!m", name = "h", descriptor = "I")
	public int minZ;

	@OriginalMember(owner = "client!m", name = "i", descriptor = "I")
	public int maxZ;

	@OriginalMember(owner = "client!m", name = "j", descriptor = "I")
	public int minY;

	@OriginalMember(owner = "client!m", name = "k", descriptor = "I")
	public int maxY;

	@OriginalMember(owner = "client!m", name = "l", descriptor = "I")
	public int mode;

	@OriginalMember(owner = "client!m", name = "m", descriptor = "I")
	public int minDeltaX;

	@OriginalMember(owner = "client!m", name = "n", descriptor = "I")
	public int maxDeltaX;

	@OriginalMember(owner = "client!m", name = "o", descriptor = "I")
	public int minDeltaZ;

	@OriginalMember(owner = "client!m", name = "p", descriptor = "I")
	public int maxDeltaZ;

	@OriginalMember(owner = "client!m", name = "q", descriptor = "I")
	public int minDeltaY;

	@OriginalMember(owner = "client!m", name = "r", descriptor = "I")
	public int maxDeltaY;
}
