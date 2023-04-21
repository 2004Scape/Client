package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

// Linkable: A node in a linked list
@OriginalClass("client!u")
public class Linkable {

	@OriginalMember(owner = "client!u", name = "a", descriptor = "J")
	public long id;

	@OriginalMember(owner = "client!u", name = "b", descriptor = "Lclient!u;")
	public Linkable prev;

	@OriginalMember(owner = "client!u", name = "c", descriptor = "Lclient!u;")
	public Linkable next;

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
