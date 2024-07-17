package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pb")
public class DoublyLinkList {

	@OriginalMember(owner = "client!pb", name = "d", descriptor = "Lclient!db;")
	private final DoublyLinkable head = new DoublyLinkable();

	@OriginalMember(owner = "client!pb", name = "<init>", descriptor = "(I)V")
	public DoublyLinkList() {
		this.head.next2 = this.head;
		this.head.prev2 = this.head;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!db;)V")
	public void push(@OriginalArg(0) DoublyLinkable node) {
		if (node.prev2 != null) {
			node.uncache();
		}

		node.prev2 = this.head.prev2;
		node.next2 = this.head;
		node.prev2.next2 = node;
		node.next2.prev2 = node;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "()Lclient!db;")
	public DoublyLinkable pop() {
		@Pc(3) DoublyLinkable node = this.head.next2;
		if (node == this.head) {
			return null;
		} else {
			node.uncache();
			return node;
		}
	}
}
