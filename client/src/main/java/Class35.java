import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!s")
public final class Class35 {

	@OriginalMember(owner = "client!s", name = "a", descriptor = "Z")
	private boolean aBoolean145 = false;

	@OriginalMember(owner = "client!s", name = "e", descriptor = "Lclient!t;")
	private final Class37 aClass37_1 = new Class37(9, 1024);

	@OriginalMember(owner = "client!s", name = "f", descriptor = "Lclient!pb;")
	private final Class30 aClass30_1 = new Class30(Static27.anInt725);

	@OriginalMember(owner = "client!s", name = "c", descriptor = "I")
	private final int anInt726;

	@OriginalMember(owner = "client!s", name = "d", descriptor = "I")
	private int anInt727;

	@OriginalMember(owner = "client!s", name = "<init>", descriptor = "(BI)V")
	public Class35(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			this.anInt726 = arg1;
			if (arg0 != 0) {
				for (@Pc(24) int local24 = 1; local24 > 0; local24++) {
				}
			}
			this.anInt727 = arg1;
		} catch (@Pc(33) RuntimeException local33) {
			signlink.reporterror("73592, " + arg0 + ", " + arg1 + ", " + local33.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(J)Lclient!db;")
	public Class1_Sub3 method527(@OriginalArg(0) long arg0) {
		@Pc(5) Class1_Sub3 local5 = (Class1_Sub3) this.aClass37_1.method530(arg0);
		if (local5 != null) {
			this.aClass30_1.method461(local5);
		}
		return local5;
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "(IJLclient!db;)V")
	public void method528(@OriginalArg(0) int arg0, @OriginalArg(1) long arg1, @OriginalArg(2) Class1_Sub3 arg2) {
		try {
			if (this.anInt727 == 0) {
				@Pc(8) Class1_Sub3 local8 = this.aClass30_1.method462();
				local8.method567();
				local8.method377();
			} else {
				this.anInt727--;
			}
			this.aClass37_1.method531(arg1, -566, arg2);
			if (arg0 < 6 || arg0 > 6) {
				this.aBoolean145 = !this.aBoolean145;
			}
			this.aClass30_1.method461(arg2);
		} catch (@Pc(51) RuntimeException local51) {
			signlink.reporterror("10260, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local51.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!s", name = "a", descriptor = "()V")
	public void method529() {
		while (true) {
			@Pc(3) Class1_Sub3 local3 = this.aClass30_1.method462();
			if (local3 == null) {
				this.anInt727 = this.anInt726;
				return;
			}
			local3.method567();
			local3.method377();
		}
	}
}
