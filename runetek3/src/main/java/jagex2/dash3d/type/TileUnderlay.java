package jagex2.dash3d.type;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!o")
public class TileUnderlay {

	@OriginalMember(owner = "client!o", name = "a", descriptor = "I")
	public final int southwestColor;

	@OriginalMember(owner = "client!o", name = "b", descriptor = "I")
	public final int southeastColor;

	@OriginalMember(owner = "client!o", name = "c", descriptor = "I")
	public final int northeastColor;

	@OriginalMember(owner = "client!o", name = "d", descriptor = "I")
	public final int northwestColor;

	@OriginalMember(owner = "client!o", name = "e", descriptor = "I")
	public final int textureId;

	@OriginalMember(owner = "client!o", name = "f", descriptor = "Z")
	public boolean flat = true;

	@OriginalMember(owner = "client!o", name = "g", descriptor = "I")
	public final int rgb;

	@OriginalMember(owner = "client!o", name = "<init>", descriptor = "(IIIIIIZ)V")
	public TileUnderlay(@OriginalArg(0) int southwestColor, @OriginalArg(1) int southeastColor, @OriginalArg(2) int northeastColor, @OriginalArg(3) int northwestColor, @OriginalArg(4) int textureId, @OriginalArg(5) int rgb, @OriginalArg(6) boolean flat) {
		this.southwestColor = southwestColor;
		this.southeastColor = southeastColor;
		this.northeastColor = northeastColor;
		this.northwestColor = northwestColor;
		this.textureId = textureId;
		this.rgb = rgb;
		this.flat = flat;
	}
}
