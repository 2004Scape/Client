package com.jagex.core.util;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

@OriginalClass("client!s")
public final class Cache {

	@OriginalMember(owner = "client!s", name = "a", descriptor = "Z")
	private boolean flowObufscator1 = false;

	@OriginalMember(owner = "client!s", name = "b", descriptor = "I")
	public static final int CACHE_SIZE = 5;

	@OriginalMember(owner = "client!s", name = "c", descriptor = "I")
	private final int capacity;

	@OriginalMember(owner = "client!s", name = "d", descriptor = "I")
	private int available;

	@OriginalMember(owner = "client!s", name = "e", descriptor = "Lclient!t;")
	private final Hashtable hashtable = new Hashtable(9, 1024);

	@OriginalMember(owner = "client!s", name = "f", descriptor = "Lclient!pb;")
	private final Stack history = new Stack(CACHE_SIZE);

	@OriginalMember(owner = "client!s", name = "<init>", descriptor = "(BI)V")
	public Cache(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			this.capacity = arg1;
			if (arg0 != 0) {
				for (@Pc(24) int local24 = 1; local24 > 0; local24++) {
				}
			}
			this.available = arg1;
		} catch (@Pc(33) RuntimeException local33) {
			Signlink.reporterror("73592, " + arg0 + ", " + arg1 + ", " + local33.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(J)Lclient!db;")
	public CacheableNode get(@OriginalArg(0) long arg0) {
		@Pc(5) CacheableNode local5 = (CacheableNode) this.hashtable.get(arg0);
		if (local5 != null) {
			this.history.push(local5);
		}
		return local5;
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(IJLclient!db;)V")
	public void put(@OriginalArg(0) int arg0, @OriginalArg(1) long arg1, @OriginalArg(2) CacheableNode arg2) {
		try {
			if (this.available == 0) {
				@Pc(8) CacheableNode local8 = this.history.pop();
				local8.unlink();
				local8.uncache();
			} else {
				this.available--;
			}
			this.hashtable.put(arg1, -566, arg2);
			if (arg0 < 6 || arg0 > 6) {
				this.flowObufscator1 = !this.flowObufscator1;
			}
			this.history.push(arg2);
		} catch (@Pc(51) RuntimeException local51) {
			Signlink.reporterror("10260, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local51.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "()V")
	public void clear() {
		while (true) {
			@Pc(3) CacheableNode local3 = this.history.pop();
			if (local3 == null) {
				this.available = this.capacity;
				return;
			}
			local3.unlink();
			local3.uncache();
		}
	}
}
