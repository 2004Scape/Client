import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!db")
public class CacheableNode extends Node {

	@OriginalMember(owner = "client!db", name = "e", descriptor = "Lclient!db;")
	public CacheableNode nextCacheable;

	@OriginalMember(owner = "client!db", name = "f", descriptor = "Lclient!db;")
	public CacheableNode prevCacheable;

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
