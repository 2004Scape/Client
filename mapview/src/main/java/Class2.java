import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("mapview!d")
public class Class2 {

	@OriginalMember(owner = "mapview!d", name = "a", descriptor = "Lmapview!d;")
	public Class2 aClass2_15;

	@OriginalMember(owner = "mapview!d", name = "b", descriptor = "Lmapview!d;")
	public Class2 aClass2_16;

	@OriginalMember(owner = "mapview!d", name = "a", descriptor = "()V")
	public final void method96() {
		if (this.aClass2_16 != null) {
			this.aClass2_16.aClass2_15 = this.aClass2_15;
			this.aClass2_15.aClass2_16 = this.aClass2_16;
			this.aClass2_15 = null;
			this.aClass2_16 = null;
		}
	}
}
