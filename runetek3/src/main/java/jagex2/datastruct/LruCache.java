package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!s")
public class LruCache {

	@OriginalMember(owner = "client!s", name = "c", descriptor = "I")
	private final int capacity;

	@OriginalMember(owner = "client!s", name = "d", descriptor = "I")
	private int available;

	@OriginalMember(owner = "client!s", name = "e", descriptor = "Lclient!t;")
	private final HashTable hashtable = new HashTable(1024);

	@OriginalMember(owner = "client!s", name = "f", descriptor = "Lclient!pb;")
	private final DoublyLinkList history = new DoublyLinkList();

	@OriginalMember(owner = "client!s", name = "<init>", descriptor = "(BI)V")
	public LruCache(@OriginalArg(1) int size) {
		this.capacity = size;
		this.available = size;
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(J)Lclient!db;")
	public DoublyLinkable get(@OriginalArg(0) long key) {
		@Pc(5) DoublyLinkable node = (DoublyLinkable) this.hashtable.get(key);
		if (node != null) {
			this.history.push(node);
		}

		return node;
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(IJLclient!db;)V")
	public void put(@OriginalArg(1) long key, @OriginalArg(2) DoublyLinkable value) {
		if (this.available == 0) {
			@Pc(8) DoublyLinkable node = this.history.pop();
			node.unlink();
			node.uncache();
		} else {
			this.available--;
		}

		this.hashtable.put(key, value);
		this.history.push(value);
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "()V")
	public void clear() {
		while (true) {
			@Pc(3) DoublyLinkable node = this.history.pop();
			if (node == null) {
				this.available = this.capacity;
				return;
			}

			node.unlink();
			node.uncache();
		}
	}
}
