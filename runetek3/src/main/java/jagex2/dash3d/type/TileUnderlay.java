package jagex2.dash3d.type;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!o")
public final class TileUnderlay {

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
	public TileUnderlay(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6) {
		this.southwestColor = arg0;
		this.southeastColor = arg1;
		this.northeastColor = arg2;
		this.northwestColor = arg3;
		this.textureId = arg4;
		this.rgb = arg5;
		this.flat = arg6;
	}
}
