package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pb")
public class Stack {

	@OriginalMember(owner = "client!pb", name = "d", descriptor = "Lclient!db;")
	private final Hashable head = new Hashable();

	@OriginalMember(owner = "client!pb", name = "<init>", descriptor = "(I)V")
	public Stack() {
		this.head.nextHashable = this.head;
		this.head.prevHashable = this.head;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!db;)V")
	public void push(@OriginalArg(0) Hashable node) {
		if (node.prevHashable != null) {
			node.uncache();
		}

		node.prevHashable = this.head.prevHashable;
		node.nextHashable = this.head;
		node.prevHashable.nextHashable = node;
		node.nextHashable.prevHashable = node;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "()Lclient!db;")
	public Hashable pop() {
		@Pc(3) Hashable node = this.head.nextHashable;
		if (node == this.head) {
			return null;
		} else {
			node.uncache();
			return node;
		}
	}
}
