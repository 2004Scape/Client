import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!l")
public final class Class3 {

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "Lmapview!d;")
	private Class2 aClass2_17 = new Class2();

	@OriginalMember(owner = "mapview!l", name = "<init>", descriptor = "()V")
	public Class3() {
		this.aClass2_17.aClass2_15 = this.aClass2_17;
		this.aClass2_17.aClass2_16 = this.aClass2_17;
	}

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "()Lmapview!d;")
	public Class2 method106() {
		@Pc(1) boolean local1 = Class2_Sub1.aBoolean19;
		@Pc(5) Class2 local5 = this.aClass2_17.aClass2_15;
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
