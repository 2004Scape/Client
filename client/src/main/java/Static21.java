import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

public final class Static21 {

	@OriginalMember(owner = "client!kb", name = "w", descriptor = "I")
	public static int anInt563;

	@OriginalMember(owner = "client!kb", name = "x", descriptor = "I")
	public static int anInt564;

	@OriginalMember(owner = "client!kb", name = "y", descriptor = "I")
	public static int anInt565;

	@OriginalMember(owner = "client!kb", name = "h", descriptor = "I")
	public static int anInt556 = 40946;

	@OriginalMember(owner = "client!kb", name = "o", descriptor = "Z")
	public static boolean aBoolean129 = true;

	@OriginalMember(owner = "client!kb", name = "u", descriptor = "[I")
	public static final int[] anIntArray191 = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };

	@OriginalMember(owner = "client!kb", name = "z", descriptor = "Lclient!ob;")
	public static final Class28 aClass28_6 = new Class28(0);

	@OriginalMember(owner = "client!kb", name = "A", descriptor = "Lclient!ob;")
	public static final Class28 aClass28_7 = new Class28(0);

	@OriginalMember(owner = "client!kb", name = "B", descriptor = "Lclient!ob;")
	public static final Class28 aClass28_8 = new Class28(0);

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(II)Lclient!kb;")
	public static Class1_Sub3_Sub3 method378(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) Class28 local3 = aClass28_7;
			synchronized (aClass28_7) {
				@Pc(7) Class1_Sub3_Sub3 local7 = null;
				if (arg0 == 0 && anInt563 > 0) {
					anInt563--;
					local7 = (Class1_Sub3_Sub3) aClass28_6.method455();
				} else if (arg0 == 1 && anInt564 > 0) {
					anInt564--;
					local7 = (Class1_Sub3_Sub3) aClass28_7.method455();
				} else if (arg0 == 2 && anInt565 > 0) {
					anInt565--;
					local7 = (Class1_Sub3_Sub3) aClass28_8.method455();
				}
				if (local7 != null) {
					local7.anInt561 = 0;
					return local7;
				}
			}
			if (arg1 >= 0) {
				aBoolean129 = !aBoolean129;
			}
			@Pc(77) Class1_Sub3_Sub3 local77 = new Class1_Sub3_Sub3(anInt556);
			local77.anInt561 = 0;
			if (arg0 == 0) {
				local77.aByteArray7 = new byte[100];
			} else if (arg0 == 1) {
				local77.aByteArray7 = new byte[5000];
			} else {
				local77.aByteArray7 = new byte[30000];
			}
			return local77;
		} catch (@Pc(104) RuntimeException local104) {
			signlink.reporterror("65959, " + arg0 + ", " + arg1 + ", " + local104.toString());
			throw new RuntimeException();
		}
	}
}
