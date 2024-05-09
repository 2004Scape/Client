package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

// name taken from jaclib
@OriginalClass("client!db")
public class Hashable extends Linkable {

	@OriginalMember(owner = "client!db", name = "e", descriptor = "Lclient!db;")
	public Hashable nextHashable;

	@OriginalMember(owner = "client!db", name = "f", descriptor = "Lclient!db;")
	public Hashable prevHashable;

	@OriginalMember(owner = "client!db", name = "b", descriptor = "()V")
	public final void uncache() {
		if (this.prevHashable != null) {
			this.prevHashable.nextHashable = this.nextHashable;
			this.nextHashable.prevHashable = this.prevHashable;
			this.nextHashable = null;
			this.prevHashable = null;
		}
	}
}
