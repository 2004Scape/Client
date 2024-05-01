package jagex2.dash3d.type;

import jagex2.datastruct.Linkable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cb")
public class Tile extends Linkable {

	@OriginalMember(owner = "client!cb", name = "e", descriptor = "I")
	public int level;

	@OriginalMember(owner = "client!cb", name = "f", descriptor = "I")
	public final int x;

	@OriginalMember(owner = "client!cb", name = "g", descriptor = "I")
	public final int z;

	@OriginalMember(owner = "client!cb", name = "h", descriptor = "I")
	public final int occludeLevel;

	@OriginalMember(owner = "client!cb", name = "i", descriptor = "Lclient!o;")
	public TileUnderlay underlay;

	@OriginalMember(owner = "client!cb", name = "j", descriptor = "Lclient!i;")
	public TileOverlay overlay;

	@OriginalMember(owner = "client!cb", name = "k", descriptor = "Lclient!q;")
	public Wall wall;

	@OriginalMember(owner = "client!cb", name = "l", descriptor = "Lclient!h;")
	public WallDecoration wallDecoration;

	@OriginalMember(owner = "client!cb", name = "m", descriptor = "Lclient!j;")
	public GroundDecoration groundDecoration;

	@OriginalMember(owner = "client!cb", name = "n", descriptor = "Lclient!k;")
	public ObjStack objStack;

	@OriginalMember(owner = "client!cb", name = "o", descriptor = "I")
	public int locCount;

	@OriginalMember(owner = "client!cb", name = "p", descriptor = "[Lclient!p;")
	public final Loc[] locs = new Loc[5];

	@OriginalMember(owner = "client!cb", name = "q", descriptor = "[I")
	public final int[] locSpan = new int[5];

	@OriginalMember(owner = "client!cb", name = "r", descriptor = "I")
	public int locSpans;

	@OriginalMember(owner = "client!cb", name = "s", descriptor = "I")
	public int drawLevel;

	@OriginalMember(owner = "client!cb", name = "t", descriptor = "Z")
	public boolean visible;

	@OriginalMember(owner = "client!cb", name = "u", descriptor = "Z")
	public boolean update;

	@OriginalMember(owner = "client!cb", name = "v", descriptor = "Z")
	public boolean containsLocs;

	@OriginalMember(owner = "client!cb", name = "w", descriptor = "I")
	public int checkLocSpans;

	@OriginalMember(owner = "client!cb", name = "x", descriptor = "I")
	public int blockLocSpans;

	@OriginalMember(owner = "client!cb", name = "y", descriptor = "I")
	public int inverseBlockLocSpans;

	@OriginalMember(owner = "client!cb", name = "z", descriptor = "I")
	public int backWallTypes;

	@OriginalMember(owner = "client!cb", name = "A", descriptor = "Lclient!cb;")
	public Tile bridge;

	@OriginalMember(owner = "client!cb", name = "<init>", descriptor = "(III)V")
	public Tile(@OriginalArg(0) int level, @OriginalArg(1) int x, @OriginalArg(2) int z) {
		this.occludeLevel = this.level = level;
		this.x = x;
		this.z = z;
	}
}
