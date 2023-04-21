package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// Stack: A stack (FIFO) of Hashables
@OriginalClass("client!pb")
public final class Stack {

	@OriginalMember(owner = "client!pb", name = "d", descriptor = "Lclient!db;")
	private final Hashable head = new Hashable();

	@OriginalMember(owner = "client!pb", name = "<init>", descriptor = "(I)V")
	public Stack() {
		this.head.nextHashable = this.head;
		this.head.prevHashable = this.head;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!db;)V")
	public void push(@OriginalArg(0) Hashable arg0) {
		if (arg0.prevHashable != null) {
			arg0.uncache();
		}
		arg0.prevHashable = this.head.prevHashable;
		arg0.nextHashable = this.head;
		arg0.prevHashable.nextHashable = arg0;
		arg0.nextHashable.prevHashable = arg0;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "()Lclient!db;")
	public Hashable pop() {
		@Pc(3) Hashable local3 = this.head.nextHashable;
		if (local3 == this.head) {
			return null;
		} else {
			local3.uncache();
			return local3;
		}
	}
}
