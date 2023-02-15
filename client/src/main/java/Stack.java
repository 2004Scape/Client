import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!pb")
public final class Stack {

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "I")
	private int flowObfuscator1 = 679;

	@OriginalMember(owner = "client!pb", name = "b", descriptor = "B")
	private final byte flowObfuscator2 = 2;

	@OriginalMember(owner = "client!pb", name = "c", descriptor = "Z")
	private final boolean flowObfuscator3 = true;

	@OriginalMember(owner = "client!pb", name = "d", descriptor = "Lclient!db;")
	private final CacheableNode head = new CacheableNode();

	@OriginalMember(owner = "client!pb", name = "<init>", descriptor = "(I)V")
	public Stack(@OriginalArg(0) int arg0) {
		try {
			this.head.nextCacheable = this.head;
			if (arg0 < 5 || arg0 > 5) {
				this.flowObfuscator1 = -426;
			}
			this.head.prevCacheable = this.head;
		} catch (@Pc(36) RuntimeException local36) {
			signlink.reporterror("27606, " + arg0 + ", " + local36.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "(Lclient!db;)V")
	public void push(@OriginalArg(0) CacheableNode arg0) {
		if (arg0.prevCacheable != null) {
			arg0.uncache();
		}
		arg0.prevCacheable = this.head.prevCacheable;
		arg0.nextCacheable = this.head;
		arg0.prevCacheable.nextCacheable = arg0;
		arg0.nextCacheable.prevCacheable = arg0;
	}

	@OriginalMember(owner = "client!pb", name = "a", descriptor = "()Lclient!db;")
	public CacheableNode pop() {
		@Pc(3) CacheableNode local3 = this.head.nextCacheable;
		if (local3 == this.head) {
			return null;
		} else {
			local3.uncache();
			return local3;
		}
	}
}
