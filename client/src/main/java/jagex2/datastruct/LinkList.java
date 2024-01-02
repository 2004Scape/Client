package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ob")
public class LinkList {

	@OriginalMember(owner = "client!ob", name = "e", descriptor = "Lclient!u;")
	private final Linkable head = new Linkable();

	@OriginalMember(owner = "client!ob", name = "f", descriptor = "Lclient!u;")
	private Linkable peeked;

	@OriginalMember(owner = "client!ob", name = "<init>", descriptor = "(I)V")
	public LinkList() {
		this.head.prev = this.head;
		this.head.next = this.head;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Lclient!u;)V")
	public void pushBack(@OriginalArg(0) Linkable node) {
		if (node.next != null) {
			node.unlink();
		}

		node.next = this.head.next;
		node.prev = this.head;
		node.next.prev = node;
		node.prev.next = node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Lclient!u;I)V")
	public void pushFront(@OriginalArg(0) Linkable node) {
		if (node.next != null) {
			node.unlink();
		}

		node.next = this.head;
		node.prev = this.head.prev;
		node.next.prev = node;
		node.prev.next = node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "()Lclient!u;")
	public Linkable pollFront() {
		@Pc(3) Linkable node = this.head.prev;
		if (node == this.head) {
			return null;
		}
		node.unlink();
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "b", descriptor = "()Lclient!u;")
	public Linkable peekFront() {
		@Pc(3) Linkable node = this.head.prev;
		if (node == this.head) {
			this.peeked = null;
			return null;
		}
		this.peeked = node.prev;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(B)Lclient!u;")
	public Linkable peekBack() {
		@Pc(3) Linkable node = this.head.next;
		if (node == this.head) {
			this.peeked = null;
			return null;
		}
		this.peeked = node.next;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(I)Lclient!u;")
	public Linkable prev() {
		@Pc(8) Linkable node = this.peeked;
		if (node == this.head) {
			this.peeked = null;
			return null;
		}
		this.peeked = node.prev;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Z)Lclient!u;")
	public Linkable next() {
		@Pc(2) Linkable node = this.peeked;
		if (node == this.head) {
			this.peeked = null;
			return null;
		}
		this.peeked = node.next;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "c", descriptor = "()V")
	public void clear() {
		while (true) {
			@Pc(3) Linkable node = this.head.prev;
			if (node == this.head) {
				return;
			}
			node.unlink();
		}
	}
}
