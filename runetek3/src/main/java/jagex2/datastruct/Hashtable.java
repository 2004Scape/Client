package jagex2.datastruct;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!t")
public final class Hashtable {

	@OriginalMember(owner = "client!t", name = "c", descriptor = "I")
	private final int size;

	@OriginalMember(owner = "client!t", name = "d", descriptor = "[Lclient!u;")
	private final Linkable[] nodes;

	@OriginalMember(owner = "client!t", name = "<init>", descriptor = "(II)V")
	public Hashtable(@OriginalArg(1) int arg1) {
		this.size = arg1;
		this.nodes = new Linkable[arg1];
		for (@Pc(30) int local30 = 0; local30 < arg1; local30++) {
			@Pc(40) Linkable local40 = this.nodes[local30] = new Linkable();
			local40.prev = local40;
			local40.next = local40;
		}
	}

	@OriginalMember(owner = "client!t", name = "a", descriptor = "(J)Lclient!u;")
	public Linkable get(@OriginalArg(0) long arg0) {
		@Pc(11) Linkable local11 = this.nodes[(int) (arg0 & (long) (this.size - 1))];
		for (@Pc(14) Linkable local14 = local11.prev; local14 != local11; local14 = local14.prev) {
			if (local14.id == arg0) {
				return local14;
			}
		}
		return null;
	}

	@OriginalMember(owner = "client!t", name = "a", descriptor = "(JILclient!u;)V")
	public void put(@OriginalArg(0) long arg0, @OriginalArg(2) Linkable arg2) {
		if (arg2.next != null) {
			arg2.unlink();
		}
		@Pc(18) Linkable local18 = this.nodes[(int) (arg0 & (long) (this.size - 1))];
		arg2.next = local18.next;
		arg2.prev = local18;
		arg2.next.prev = arg2;
		arg2.prev.next = arg2;
		arg2.id = arg0;
	}
}
