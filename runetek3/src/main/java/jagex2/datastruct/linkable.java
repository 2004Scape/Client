package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!u")
public class linkable {

	@OriginalMember(owner = "client!u", name = "a", descriptor = "J")
	public long id;

	@OriginalMember(owner = "client!u", name = "b", descriptor = "Lclient!u;")
	public linkable prev;

	@OriginalMember(owner = "client!u", name = "c", descriptor = "Lclient!u;")
	public linkable next;

	@OriginalMember(owner = "client!u", name = "a", descriptor = "()V")
	public final void unlink() {
		if (this.next != null) {
			this.next.prev = this.prev;
			this.prev.next = this.next;
			this.prev = null;
			this.next = null;
		}
	}
}
