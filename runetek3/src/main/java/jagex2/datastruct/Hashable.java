package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

// Hashable: A linkable node that can be associated with a key inside Hashtable, LruCache, and Stack
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
