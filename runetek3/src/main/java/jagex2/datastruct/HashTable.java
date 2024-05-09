package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from jaclib
@OriginalClass("client!t")
public class HashTable {

	@OriginalMember(owner = "client!t", name = "c", descriptor = "I")
	private final int bucketCount;

	@OriginalMember(owner = "client!t", name = "d", descriptor = "[Lclient!u;")
	private final Linkable[] buckets;

	@OriginalMember(owner = "client!t", name = "<init>", descriptor = "(II)V")
	public HashTable(@OriginalArg(1) int size) {
		this.buckets = new Linkable[size];
		this.bucketCount = size;

		for (@Pc(30) int i = 0; i < size; i++) {
			@Pc(40) Linkable sentinel = this.buckets[i] = new Linkable();
			sentinel.next = sentinel;
			sentinel.prev = sentinel;
		}
	}

	@OriginalMember(owner = "client!t", name = "a", descriptor = "(J)Lclient!u;")
	public Linkable get(@OriginalArg(0) long key) {
		@Pc(11) Linkable sentinel = this.buckets[(int) (key & (long) (this.bucketCount - 1))];

		for (@Pc(14) Linkable node = sentinel.next; node != sentinel; node = node.next) {
			if (node.key == key) {
				return node;
			}
		}

		return null;
	}

	@OriginalMember(owner = "client!t", name = "a", descriptor = "(JILclient!u;)V")
	public void put(@OriginalArg(0) long key, @OriginalArg(2) Linkable value) {
		if (value.prev != null) {
			value.unlink();
		}

		@Pc(18) Linkable sentinel = this.buckets[(int) (key & (long) (this.bucketCount - 1))];
		value.prev = sentinel.prev;
		value.next = sentinel;
		value.prev.next = value;
		value.next.prev = value;
		value.key = key;
	}
}
