package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// LruCache: A least-recently-used cache.
@OriginalClass("client!s")
public final class LruCache {

	@OriginalMember(owner = "client!s", name = "c", descriptor = "I")
	private final int capacity;

	@OriginalMember(owner = "client!s", name = "d", descriptor = "I")
	private int available;

	@OriginalMember(owner = "client!s", name = "e", descriptor = "Lclient!t;")
	private final Hashtable hashtable = new Hashtable(1024);

	@OriginalMember(owner = "client!s", name = "f", descriptor = "Lclient!pb;")
	private final Stack history = new Stack();

	@OriginalMember(owner = "client!s", name = "<init>", descriptor = "(BI)V")
	public LruCache(@OriginalArg(1) int arg1) {
		this.capacity = arg1;
		this.available = arg1;
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(J)Lclient!db;")
	public Hashable get(@OriginalArg(0) long arg0) {
		@Pc(5) Hashable local5 = (Hashable) this.hashtable.get(arg0);
		if (local5 != null) {
			this.history.push(local5);
		}
		return local5;
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(IJLclient!db;)V")
	public void put(@OriginalArg(1) long arg1, @OriginalArg(2) Hashable arg2) {
		if (this.available == 0) {
			@Pc(8) Hashable local8 = this.history.pop();
			local8.unlink();
			local8.uncache();
		} else {
			this.available--;
		}
		this.hashtable.put(arg1, arg2);
		this.history.push(arg2);
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "()V")
	public void clear() {
		while (true) {
			@Pc(3) Hashable local3 = this.history.pop();
			if (local3 == null) {
				this.available = this.capacity;
				return;
			}
			local3.unlink();
			local3.uncache();
		}
	}
}
