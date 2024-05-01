package jagex2.dash3d.entity;

import jagex2.datastruct.Linkable;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!w")
public class Entity extends Linkable {

	@OriginalMember(owner = "client!w", name = "a", descriptor = "(Z)Lclient!eb;")
	public Model draw(int loopCycle) {
		return null;
	}
}
