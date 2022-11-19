import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!db")
public class Class1_Sub3 extends Class1 {

	@OriginalMember(owner = "client!db", name = "e", descriptor = "Lclient!db;")
	public Class1_Sub3 aClass1_Sub3_15;

	@OriginalMember(owner = "client!db", name = "f", descriptor = "Lclient!db;")
	public Class1_Sub3 aClass1_Sub3_16;

	@OriginalMember(owner = "client!db", name = "b", descriptor = "()V")
	public final void method377() {
		if (this.aClass1_Sub3_16 != null) {
			this.aClass1_Sub3_16.aClass1_Sub3_15 = this.aClass1_Sub3_15;
			this.aClass1_Sub3_15.aClass1_Sub3_16 = this.aClass1_Sub3_16;
			this.aClass1_Sub3_15 = null;
			this.aClass1_Sub3_16 = null;
		}
	}
}
