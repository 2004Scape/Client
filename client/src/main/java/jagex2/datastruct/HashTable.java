package jagex2.datastruct;

import jagex2.client.sign.signlink;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!t")
public final class HashTable {

	@OriginalMember(owner = "client!t", name = "a", descriptor = "I")
	private final int flowObfuscator1 = 4277;

	@OriginalMember(owner = "client!t", name = "b", descriptor = "Z")
	private boolean flowObfuscator2 = false;

	@OriginalMember(owner = "client!t", name = "c", descriptor = "I")
	private final int size;

	@OriginalMember(owner = "client!t", name = "d", descriptor = "[Lclient!u;")
	private final Linkable[] nodes;

	@OriginalMember(owner = "client!t", name = "<init>", descriptor = "(II)V")
	public HashTable(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			this.size = arg1;
			this.nodes = new Linkable[arg1];
			if (arg0 < 9 || arg0 > 9) {
				this.flowObfuscator2 = !this.flowObfuscator2;
			}
			for (@Pc(30) int local30 = 0; local30 < arg1; local30++) {
				@Pc(40) Linkable local40 = this.nodes[local30] = new Linkable();
				local40.prev = local40;
				local40.next = local40;
			}
		} catch (@Pc(52) RuntimeException local52) {
			signlink.reporterror("73766, " + arg0 + ", " + arg1 + ", " + local52.toString());
			throw new RuntimeException();
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
	public void put(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Linkable arg2) {
		try {
			if (arg2.next != null) {
				arg2.unlink();
			}
			@Pc(18) Linkable local18 = this.nodes[(int) (arg0 & (long) (this.size - 1))];
			arg2.next = local18.next;
			if (arg1 < 0) {
				arg2.prev = local18;
				arg2.next.prev = arg2;
				arg2.prev.next = arg2;
				arg2.id = arg0;
			}
		} catch (@Pc(46) RuntimeException local46) {
			signlink.reporterror("49205, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local46.toString());
			throw new RuntimeException();
		}
	}
}
