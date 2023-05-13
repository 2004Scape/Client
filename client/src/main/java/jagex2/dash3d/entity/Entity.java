package jagex2.dash3d.entity;

import jagex2.client.sign.signlink;
import jagex2.datastruct.Linkable;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!w")
public class Entity extends Linkable {

	@OriginalMember(owner = "client!w", name = "a", descriptor = "(Z)Lclient!eb;")
	public Model draw(@OriginalArg(0) boolean arg0) {
		try {
			if (!arg0) {
				throw new NullPointerException();
			}
			return null;
		} catch (@Pc(8) RuntimeException local8) {
			signlink.reporterror("84732, " + arg0 + ", " + local8.toString());
			throw new RuntimeException();
		}
	}
}
