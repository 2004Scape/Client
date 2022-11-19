import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!cb")
public final class Class1_Sub2 extends Class1 {

	@OriginalMember(owner = "client!cb", name = "i", descriptor = "Lclient!o;")
	public Class27 aClass27_1;

	@OriginalMember(owner = "client!cb", name = "j", descriptor = "Lclient!i;")
	public Class16 aClass16_1;

	@OriginalMember(owner = "client!cb", name = "k", descriptor = "Lclient!q;")
	public Class31 aClass31_1;

	@OriginalMember(owner = "client!cb", name = "l", descriptor = "Lclient!h;")
	public Class14 aClass14_1;

	@OriginalMember(owner = "client!cb", name = "m", descriptor = "Lclient!j;")
	public Class18 aClass18_1;

	@OriginalMember(owner = "client!cb", name = "n", descriptor = "Lclient!k;")
	public Class20 aClass20_1;

	@OriginalMember(owner = "client!cb", name = "o", descriptor = "I")
	public int anInt91;

	@OriginalMember(owner = "client!cb", name = "r", descriptor = "I")
	public int anInt92;

	@OriginalMember(owner = "client!cb", name = "s", descriptor = "I")
	public int anInt93;

	@OriginalMember(owner = "client!cb", name = "t", descriptor = "Z")
	public boolean aBoolean25;

	@OriginalMember(owner = "client!cb", name = "u", descriptor = "Z")
	public boolean aBoolean26;

	@OriginalMember(owner = "client!cb", name = "v", descriptor = "Z")
	public boolean aBoolean27;

	@OriginalMember(owner = "client!cb", name = "w", descriptor = "I")
	public int anInt94;

	@OriginalMember(owner = "client!cb", name = "x", descriptor = "I")
	public int anInt95;

	@OriginalMember(owner = "client!cb", name = "y", descriptor = "I")
	public int anInt96;

	@OriginalMember(owner = "client!cb", name = "z", descriptor = "I")
	public int anInt97;

	@OriginalMember(owner = "client!cb", name = "A", descriptor = "Lclient!cb;")
	public Class1_Sub2 aClass1_Sub2_1;

	@OriginalMember(owner = "client!cb", name = "p", descriptor = "[Lclient!p;")
	public final Class29[] aClass29Array1 = new Class29[5];

	@OriginalMember(owner = "client!cb", name = "q", descriptor = "[I")
	public final int[] anIntArray22 = new int[5];

	@OriginalMember(owner = "client!cb", name = "e", descriptor = "I")
	public int anInt87;

	@OriginalMember(owner = "client!cb", name = "h", descriptor = "I")
	public final int anInt90;

	@OriginalMember(owner = "client!cb", name = "f", descriptor = "I")
	public final int anInt88;

	@OriginalMember(owner = "client!cb", name = "g", descriptor = "I")
	public final int anInt89;

	@OriginalMember(owner = "client!cb", name = "<init>", descriptor = "(III)V")
	public Class1_Sub2(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		this.anInt90 = this.anInt87 = arg0;
		this.anInt88 = arg1;
		this.anInt89 = arg2;
	}
}
