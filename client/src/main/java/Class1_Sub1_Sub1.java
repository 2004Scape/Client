import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!ab")
public final class Class1_Sub1_Sub1 extends Class1_Sub1 {

	@OriginalMember(owner = "client!ab", name = "e", descriptor = "I")
	private int anInt22;

	@OriginalMember(owner = "client!ab", name = "s", descriptor = "D")
	public double aDouble1;

	@OriginalMember(owner = "client!ab", name = "t", descriptor = "D")
	public double aDouble2;

	@OriginalMember(owner = "client!ab", name = "u", descriptor = "D")
	public double aDouble3;

	@OriginalMember(owner = "client!ab", name = "v", descriptor = "D")
	private double aDouble4;

	@OriginalMember(owner = "client!ab", name = "w", descriptor = "D")
	private double aDouble5;

	@OriginalMember(owner = "client!ab", name = "x", descriptor = "D")
	private double aDouble6;

	@OriginalMember(owner = "client!ab", name = "y", descriptor = "D")
	private double aDouble7;

	@OriginalMember(owner = "client!ab", name = "z", descriptor = "D")
	private double aDouble8;

	@OriginalMember(owner = "client!ab", name = "A", descriptor = "I")
	public int anInt34;

	@OriginalMember(owner = "client!ab", name = "B", descriptor = "I")
	private int anInt35;

	@OriginalMember(owner = "client!ab", name = "C", descriptor = "I")
	private int anInt36;

	@OriginalMember(owner = "client!ab", name = "D", descriptor = "I")
	private int anInt37;

	@OriginalMember(owner = "client!ab", name = "f", descriptor = "I")
	private int anInt23 = -159;

	@OriginalMember(owner = "client!ab", name = "r", descriptor = "Z")
	private boolean aBoolean5 = false;

	@OriginalMember(owner = "client!ab", name = "g", descriptor = "Lclient!kc;")
	private final Class21 aClass21_1;

	@OriginalMember(owner = "client!ab", name = "h", descriptor = "I")
	public final int anInt24;

	@OriginalMember(owner = "client!ab", name = "i", descriptor = "I")
	private final int anInt25;

	@OriginalMember(owner = "client!ab", name = "j", descriptor = "I")
	private final int anInt26;

	@OriginalMember(owner = "client!ab", name = "k", descriptor = "I")
	private final int anInt27;

	@OriginalMember(owner = "client!ab", name = "m", descriptor = "I")
	public final int anInt29;

	@OriginalMember(owner = "client!ab", name = "n", descriptor = "I")
	public final int anInt30;

	@OriginalMember(owner = "client!ab", name = "o", descriptor = "I")
	private final int anInt31;

	@OriginalMember(owner = "client!ab", name = "p", descriptor = "I")
	private final int anInt32;

	@OriginalMember(owner = "client!ab", name = "q", descriptor = "I")
	public final int anInt33;

	@OriginalMember(owner = "client!ab", name = "l", descriptor = "I")
	public final int anInt28;

	@OriginalMember(owner = "client!ab", name = "<init>", descriptor = "(IIIIIIIIIIII)V")
	public Class1_Sub1_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
		try {
			this.aClass21_1 = Static22.aClass21Array1[arg10];
			if (arg8 != 0) {
				throw new NullPointerException();
			}
			this.anInt24 = arg4;
			this.anInt25 = arg11;
			this.anInt26 = arg2;
			this.anInt27 = arg9;
			this.anInt29 = arg6;
			this.anInt30 = arg3;
			this.anInt31 = arg1;
			this.anInt32 = arg7;
			this.anInt33 = arg5;
			this.anInt28 = arg0;
			this.aBoolean5 = false;
		} catch (@Pc(53) RuntimeException local53) {
			signlink.reporterror("57613, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + local53.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(IIIII)V")
	public void method19(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			@Pc(8) double local8;
			if (!this.aBoolean5) {
				local8 = arg2 - this.anInt25;
				@Pc(14) double local14 = (double) (arg1 - this.anInt26);
				@Pc(23) double local23 = Math.sqrt(local8 * local8 + local14 * local14);
				this.aDouble1 = (double) this.anInt25 + local8 * (double) this.anInt32 / local23;
				this.aDouble2 = (double) this.anInt26 + local14 * (double) this.anInt32 / local23;
				this.aDouble3 = this.anInt27;
			}
			local8 = this.anInt30 + 1 - arg4;
			this.aDouble4 = ((double) arg2 - this.aDouble1) / local8;
			this.aDouble5 = ((double) arg1 - this.aDouble2) / local8;
			this.aDouble6 = Math.sqrt(this.aDouble4 * this.aDouble4 + this.aDouble5 * this.aDouble5);
			if (!this.aBoolean5) {
				this.aDouble7 = -this.aDouble6 * Math.tan((double) this.anInt31 * 0.02454369D);
			}
			this.aDouble8 = ((double) arg0 - this.aDouble3 - this.aDouble7 * local8) * 2.0D / (local8 * local8);
			if (arg3 < 0) {
				;
			}
		} catch (@Pc(131) RuntimeException local131) {
			signlink.reporterror("18544, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local131.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(BI)V")
	public void method20(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 != -30) {
				this.anInt23 = -454;
			}
			this.aBoolean5 = true;
			this.aDouble1 += this.aDouble4 * (double) arg1;
			this.aDouble2 += this.aDouble5 * (double) arg1;
			this.aDouble3 += this.aDouble7 * (double) arg1 + this.aDouble8 * 0.5D * (double) arg1 * (double) arg1;
			this.aDouble7 += this.aDouble8 * (double) arg1;
			this.anInt34 = (int) (Math.atan2(this.aDouble4, this.aDouble5) * 325.949D) + 1024 & 0x7FF;
			this.anInt35 = (int) (Math.atan2(this.aDouble7, this.aDouble6) * 325.949D) & 0x7FF;
			if (this.aClass21_1.aClass19_1 != null) {
				this.anInt37 += arg1;
				while (this.anInt37 > this.aClass21_1.aClass19_1.anIntArray188[this.anInt36]) {
					this.anInt37 -= this.aClass21_1.aClass19_1.anIntArray188[this.anInt36] + 1;
					this.anInt36++;
					if (this.anInt36 >= this.aClass21_1.aClass19_1.anInt543) {
						this.anInt36 = 0;
					}
				}
			}
		} catch (@Pc(139) RuntimeException local139) {
			signlink.reporterror("86911, " + arg0 + ", " + arg1 + ", " + local139.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Class1_Sub3_Sub1 method568(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(3) Class1_Sub3_Sub1 local3 = this.aClass21_1.method409();
			@Pc(19) Class1_Sub3_Sub1 local19 = new Class1_Sub3_Sub1(local3, true, !this.aClass21_1.aBoolean131, this.anInt22, false);
			if (!arg0) {
				for (@Pc(23) int local23 = 1; local23 > 0; local23++) {
				}
			}
			if (this.aClass21_1.aClass19_1 != null) {
				local19.method230(4);
				local19.method231(-16599, this.aClass21_1.aClass19_1.anIntArray186[this.anInt36]);
				local19.anIntArrayArray7 = null;
				local19.anIntArrayArray6 = null;
			}
			if (this.aClass21_1.anInt571 != 128 || this.aClass21_1.anInt572 != 128) {
				local19.method239(this.aClass21_1.anInt571, 2, this.aClass21_1.anInt572, this.aClass21_1.anInt571);
			}
			local19.method235((byte) 7, this.anInt35);
			local19.method240(this.aClass21_1.anInt574 + 64, this.aClass21_1.anInt575 + 850, -30, -50, -30, true);
			return local19;
		} catch (@Pc(97) RuntimeException local97) {
			signlink.reporterror("99718, " + arg0 + ", " + local97.toString());
			throw new RuntimeException();
		}
	}
}
