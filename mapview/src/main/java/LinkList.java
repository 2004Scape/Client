import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!l")
public final class LinkList {

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "Lmapview!d;")
	private Linkable aClass2_17 = new Linkable();

	@OriginalMember(owner = "mapview!l", name = "<init>", descriptor = "()V")
	public LinkList() {
		this.aClass2_17.aClass2_15 = this.aClass2_17;
		this.aClass2_17.aClass2_16 = this.aClass2_17;
	}

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "()Lmapview!d;")
	public Linkable method106() {
		@Pc(1) boolean local1 = Hashable.aBoolean19;
		@Pc(5) Linkable local5 = this.aClass2_17.aClass2_15;
		if (local5 == this.aClass2_17) {
			return null;
		} else {
			local5.method96();
			if (local1) {
			}
			return local5;
		}
	}
}
