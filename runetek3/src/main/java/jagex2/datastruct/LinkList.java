package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from jaclib
@OriginalClass("client!ob")
public class LinkList {

	@OriginalMember(owner = "client!ob", name = "e", descriptor = "Lclient!u;")
	private final Linkable sentinel = new Linkable();

	@OriginalMember(owner = "client!ob", name = "f", descriptor = "Lclient!u;")
	private Linkable cursor;

	@OriginalMember(owner = "client!ob", name = "<init>", descriptor = "(I)V")
	public LinkList() {
		this.sentinel.next = this.sentinel;
		this.sentinel.prev = this.sentinel;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Lclient!u;)V")
	public void addTail(@OriginalArg(0) Linkable node) {
		if (node.prev != null) {
			node.unlink();
		}

		node.prev = this.sentinel.prev;
		node.next = this.sentinel;
		node.prev.next = node;
		node.next.prev = node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Lclient!u;I)V")
	public void addHead(@OriginalArg(0) Linkable node) {
		if (node.prev != null) {
			node.unlink();
		}

		node.prev = this.sentinel;
		node.next = this.sentinel.next;
		node.prev.next = node;
		node.next.prev = node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "()Lclient!u;")
	public Linkable removeHead() {
		@Pc(3) Linkable node = this.sentinel.next;
		if (node == this.sentinel) {
			return null;
		}
		node.unlink();
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "b", descriptor = "()Lclient!u;")
	public Linkable head() {
		@Pc(3) Linkable node = this.sentinel.next;
		if (node == this.sentinel) {
			this.cursor = null;
			return null;
		}
		this.cursor = node.next;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(B)Lclient!u;")
	public Linkable tail() {
		@Pc(3) Linkable node = this.sentinel.prev;
		if (node == this.sentinel) {
			this.cursor = null;
			return null;
		}
		this.cursor = node.prev;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(I)Lclient!u;")
	public Linkable next() {
		@Pc(8) Linkable node = this.cursor;
		if (node == this.sentinel) {
			this.cursor = null;
			return null;
		}
		this.cursor = node.next;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "a", descriptor = "(Z)Lclient!u;")
	public Linkable prev() {
		@Pc(2) Linkable node = this.cursor;
		if (node == this.sentinel) {
			this.cursor = null;
			return null;
		}
		this.cursor = node.prev;
		return node;
	}

	@OriginalMember(owner = "client!ob", name = "c", descriptor = "()V")
	public void clear() {
		while (true) {
			@Pc(3) Linkable node = this.sentinel.next;
			if (node == this.sentinel) {
				return;
			}
			node.unlink();
		}
	}
}
