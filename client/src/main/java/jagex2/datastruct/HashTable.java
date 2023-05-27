package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!t")
public final class HashTable {

	@OriginalMember(owner = "client!t", name = "c", descriptor = "I")
	private final int size;

	@OriginalMember(owner = "client!t", name = "d", descriptor = "[Lclient!u;")
	private final Linkable[] nodes;

	@OriginalMember(owner = "client!t", name = "<init>", descriptor = "(II)V")
	public HashTable(@OriginalArg(1) int size) {
		this.size = size;
		this.nodes = new Linkable[size];

		for (@Pc(30) int i = 0; i < size; i++) {
			@Pc(40) Linkable node = this.nodes[i] = new Linkable();
			node.prev = node;
			node.next = node;
		}
	}

	@OriginalMember(owner = "client!t", name = "a", descriptor = "(J)Lclient!u;")
	public Linkable get(@OriginalArg(0) long key) {
		@Pc(11) Linkable start = this.nodes[(int) (key & (long) (this.size - 1))];

		for (@Pc(14) Linkable node = start.prev; node != start; node = node.prev) {
			if (node.id == key) {
				return node;
			}
		}

		return null;
	}

	@OriginalMember(owner = "client!t", name = "a", descriptor = "(JILclient!u;)V")
	public void put(@OriginalArg(0) long key, @OriginalArg(2) Linkable value) {
		if (value.next != null) {
			value.unlink();
		}

		@Pc(18) Linkable node = this.nodes[(int) (key & (long) (this.size - 1))];
		value.next = node.next;
		value.prev = node;
		value.next.prev = value;
		value.prev.next = value;
		value.id = key;
	}
}
