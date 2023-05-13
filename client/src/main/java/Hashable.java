import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!db")
public class Hashable extends Linkable {

	@OriginalMember(owner = "client!db", name = "e", descriptor = "Lclient!db;")
	public Hashable nextCacheable;

	@OriginalMember(owner = "client!db", name = "f", descriptor = "Lclient!db;")
	public Hashable prevCacheable;

	@OriginalMember(owner = "client!db", name = "b", descriptor = "()V")
	public final void uncache() {
		if (this.prevCacheable != null) {
			this.prevCacheable.nextCacheable = this.nextCacheable;
			this.nextCacheable.prevCacheable = this.prevCacheable;
			this.nextCacheable = null;
			this.prevCacheable = null;
		}
	}
}
