package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!pb")
public final class Stack {

	@OriginalMember(owner = "client!pb", name = "d", descriptor = "Lclient!db;")
	private final Hashable head = new Hashable();

	@OriginalMember(owner = "client!pb", name = "<init>", descriptor = "(I)V")
	public Stack() {
		this.head.nextCacheable = this.head;
		this.head.prevCacheable = this.head;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!db;)V")
	public void push(@OriginalArg(0) Hashable arg0) {
		if (arg0.prevCacheable != null) {
			arg0.uncache();
		}
		arg0.prevCacheable = this.head.prevCacheable;
		arg0.nextCacheable = this.head;
		arg0.prevCacheable.nextCacheable = arg0;
		arg0.nextCacheable.prevCacheable = arg0;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "()Lclient!db;")
	public Hashable pop() {
		@Pc(3) Hashable local3 = this.head.nextCacheable;
		if (local3 == this.head) {
			return null;
		} else {
			local3.uncache();
			return local3;
		}
	}
}
