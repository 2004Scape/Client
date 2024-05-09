package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

// name and packaging confirmed 100% in rs2/mapview applet strings
@OriginalClass("client!u")
public class Linkable {

	@OriginalMember(owner = "client!u", name = "a", descriptor = "J")
	public long key;

	@OriginalMember(owner = "client!u", name = "b", descriptor = "Lclient!u;")
	public Linkable next;

	@OriginalMember(owner = "client!u", name = "c", descriptor = "Lclient!u;")
	public Linkable prev;

	@OriginalMember(owner = "client!u", name = "a", descriptor = "()V")
	public final void unlink() {
		if (this.prev != null) {
			this.prev.next = this.next;
			this.next.prev = this.prev;
			this.next = null;
			this.prev = null;
		}
	}
}
