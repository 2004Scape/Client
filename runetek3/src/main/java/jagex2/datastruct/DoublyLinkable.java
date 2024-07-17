package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!db")
public class DoublyLinkable extends Linkable {

	@OriginalMember(owner = "client!db", name = "e", descriptor = "Lclient!db;")
	public DoublyLinkable next2;

	@OriginalMember(owner = "client!db", name = "f", descriptor = "Lclient!db;")
	public DoublyLinkable prev2;

	@OriginalMember(owner = "client!db", name = "b", descriptor = "()V")
	public final void uncache() {
		if (this.prev2 != null) {
			this.prev2.next2 = this.next2;
			this.next2.prev2 = this.prev2;
			this.next2 = null;
			this.prev2 = null;
		}
	}
}
