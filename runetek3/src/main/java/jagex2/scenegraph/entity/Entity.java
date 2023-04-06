package jagex2.scenegraph.entity;

import jagex2.datastruct.linkable;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!w")
public class Entity extends linkable {

	@OriginalMember(owner = "client!w", name = "a", descriptor = "(Z)Lclient!eb;")
	public Model draw(int loopCycle) {
		return null;
	}
}
