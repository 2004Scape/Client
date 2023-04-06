package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ob")
public final class linkablelist {

	@OriginalMember(owner = "client!ob", name = "e", descriptor = "Lclient!u;")
	private final linkable head = new linkable();

	@OriginalMember(owner = "client!ob", name = "f", descriptor = "Lclient!u;")
	private linkable peeked;

	@OriginalMember(owner = "client!ob", name = "<init>", descriptor = "(I)V")
	public linkablelist() {
		this.head.prev = this.head;
		this.head.next = this.head;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Lclient!u;)V")
	public void pushBack(@OriginalArg(0) linkable arg0) {
		if (arg0.next != null) {
			arg0.unlink();
		}
		arg0.next = this.head.next;
		arg0.prev = this.head;
		arg0.next.prev = arg0;
		arg0.prev.next = arg0;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Lclient!u;I)V")
	public void pushFront(@OriginalArg(0) linkable arg0) {
		if (arg0.next != null) {
			arg0.unlink();
		}
		arg0.next = this.head;
		arg0.prev = this.head.prev;
		arg0.next.prev = arg0;
		arg0.prev.next = arg0;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "()Lclient!u;")
	public linkable pollFront() {
		@Pc(3) linkable local3 = this.head.prev;
		if (local3 == this.head) {
			return null;
		} else {
			local3.unlink();
			return local3;
		}
	}

	@OriginalMember(owner = "client!ob", name = "b", descriptor = "()Lclient!u;")
	public linkable peekFront() {
		@Pc(3) linkable local3 = this.head.prev;
		if (local3 == this.head) {
			this.peeked = null;
			return null;
		} else {
			this.peeked = local3.prev;
			return local3;
		}
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(B)Lclient!u;")
	public linkable peekBack() {
		@Pc(3) linkable local3 = this.head.next;
		if (local3 == this.head) {
			this.peeked = null;
			return null;
		}
		this.peeked = local3.next;
		return local3;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(I)Lclient!u;")
	public linkable prev() {
		@Pc(8) linkable local8 = this.peeked;
		if (local8 == this.head) {
			this.peeked = null;
			return null;
		} else {
			this.peeked = local8.prev;
			return local8;
		}
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Z)Lclient!u;")
	public linkable next() {
		@Pc(2) linkable local2 = this.peeked;
		if (local2 == this.head) {
			this.peeked = null;
			return null;
		} else {
			this.peeked = local2.next;
			return local2;
		}
	}

	@OriginalMember(owner = "client!ob", name = "c", descriptor = "()V")
	public void clear() {
		while (true) {
			@Pc(3) linkable local3 = this.head.prev;
			if (local3 == this.head) {
				return;
			}
			local3.unlink();
		}
	}
}
