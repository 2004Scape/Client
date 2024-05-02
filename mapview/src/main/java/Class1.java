import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!c")
public final class Class1 {

	@OriginalMember(owner = "mapview!c", name = "a", descriptor = "Z")
	public static boolean aBoolean5 = false;

	@OriginalMember(owner = "mapview!c", name = "b", descriptor = "Lmapview!k;")
	private static Class2_Sub1_Sub2 aClass2_Sub1_Sub2_1 = null;

	@OriginalMember(owner = "mapview!c", name = "c", descriptor = "Lmapview!k;")
	private static Class2_Sub1_Sub2 aClass2_Sub1_Sub2_2 = null;

	@OriginalMember(owner = "mapview!c", name = "d", descriptor = "J")
	private static long aLong3 = 0L;

	@OriginalMember(owner = "mapview!c", name = "f", descriptor = "J")
	private static long aLong4 = 0L;

	@OriginalMember(owner = "mapview!c", name = "g", descriptor = "I")
	private static int anInt20 = 0;

	@OriginalMember(owner = "mapview!c", name = "h", descriptor = "I")
	private static int anInt21 = 0;

	@OriginalMember(owner = "mapview!c", name = "a", descriptor = "(I)V")
	private static synchronized void method13(@OriginalArg(0) int arg0) {
		if (aClass2_Sub1_Sub2_1.anInt89 + arg0 >= 500) {
			@Pc(7) Class2_Sub1_Sub2 local7 = aClass2_Sub1_Sub2_1;
			aClass2_Sub1_Sub2_1 = Class2_Sub1_Sub2.method104(1);
			aClass2_Sub1_Sub2_2 = local7;
		}
	}

	@OriginalMember(owner = "mapview!c", name = "a", descriptor = "(II)V")
	public static synchronized void method14(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		if (!aBoolean5 || (arg0 < 0 || arg0 >= 789 || arg1 < 0 || arg1 >= 532)) {
			return;
		}
		@Pc(17) long local17 = System.currentTimeMillis();
		if (local17 - aLong4 < 50L) {
			return;
		}
		aLong4 = local17;
		@Pc(35) long local35 = (local17 - aLong3) / 10L;
		if (local35 > 250L) {
			local35 = 250L;
		}
		aLong3 = local17;
		if (arg0 - anInt20 < 8 && arg0 - anInt20 >= -8 && arg1 - anInt21 < 8 && arg1 - anInt21 >= -8) {
			method13(3);
			aClass2_Sub1_Sub2_1.method101(5);
			aClass2_Sub1_Sub2_1.method101((int) local35);
			aClass2_Sub1_Sub2_1.method101(arg0 - anInt20 + 8 + (arg1 - anInt21 + 8 << 4));
		} else if (arg0 - anInt20 < 128 && arg0 - anInt20 >= -128 && arg1 - anInt21 < 128 && arg1 - anInt21 >= -128) {
			method13(4);
			aClass2_Sub1_Sub2_1.method101(6);
			aClass2_Sub1_Sub2_1.method101((int) local35);
			aClass2_Sub1_Sub2_1.method101(arg0 - anInt20 + 128);
			aClass2_Sub1_Sub2_1.method101(arg1 - anInt21 + 128);
		} else {
			method13(5);
			aClass2_Sub1_Sub2_1.method101(7);
			aClass2_Sub1_Sub2_1.method101((int) local35);
			aClass2_Sub1_Sub2_1.method105(arg0 + (arg1 << 10));
		}
		anInt20 = arg0;
		anInt21 = arg1;
	}

	@OriginalMember(owner = "mapview!c", name = "a", descriptor = "()V")
	public static synchronized void method15() {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		method13(2);
		aClass2_Sub1_Sub2_1.method101(10);
		aClass2_Sub1_Sub2_1.method101((int) local14);
	}

	@OriginalMember(owner = "mapview!c", name = "a", descriptor = "(III)V")
	public static synchronized void method16(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if (!aBoolean5 || (arg0 < 0 || arg0 >= 789 || arg1 < 0 || arg1 >= 532)) {
			return;
		}
		@Pc(19) long local19 = System.currentTimeMillis();
		@Pc(25) long local25 = (local19 - aLong3) / 10L;
		if (local25 > 250L) {
			local25 = 250L;
		}
		aLong3 = local19;
		method13(5);
		if (arg2 == 1) {
			aClass2_Sub1_Sub2_1.method101(1);
		} else {
			aClass2_Sub1_Sub2_1.method101(2);
		}
		aClass2_Sub1_Sub2_1.method101((int) local25);
		aClass2_Sub1_Sub2_1.method105(arg0 + (arg1 << 10));
	}

	@OriginalMember(owner = "mapview!c", name = "b", descriptor = "()V")
	public static synchronized void method17() {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		method13(2);
		aClass2_Sub1_Sub2_1.method101(11);
		aClass2_Sub1_Sub2_1.method101((int) local14);
	}

	@OriginalMember(owner = "mapview!c", name = "b", descriptor = "(I)V")
	public static synchronized void method18(@OriginalArg(0) int arg0) {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		method13(2);
		if (arg0 == 1) {
			aClass2_Sub1_Sub2_1.method101(3);
		} else {
			aClass2_Sub1_Sub2_1.method101(4);
		}
		aClass2_Sub1_Sub2_1.method101((int) local14);
	}

	@OriginalMember(owner = "mapview!c", name = "c", descriptor = "(I)V")
	public static synchronized void method19(@OriginalArg(0) int arg0) {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		if (arg0 == 1000) {
			arg0 = 11;
		}
		if (arg0 == 1001) {
			arg0 = 12;
		}
		if (arg0 == 1002) {
			arg0 = 14;
		}
		if (arg0 == 1003) {
			arg0 = 15;
		}
		if (arg0 >= 1008) {
			arg0 -= 992;
		}
		method13(3);
		aClass2_Sub1_Sub2_1.method101(8);
		aClass2_Sub1_Sub2_1.method101((int) local14);
		aClass2_Sub1_Sub2_1.method101(arg0);
	}

	@OriginalMember(owner = "mapview!c", name = "c", descriptor = "()V")
	public static synchronized void method20() {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		method13(2);
		aClass2_Sub1_Sub2_1.method101(12);
		aClass2_Sub1_Sub2_1.method101((int) local14);
	}

	@OriginalMember(owner = "mapview!c", name = "d", descriptor = "()V")
	public static synchronized void method21() {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		method13(2);
		aClass2_Sub1_Sub2_1.method101(13);
		aClass2_Sub1_Sub2_1.method101((int) local14);
	}

	@OriginalMember(owner = "mapview!c", name = "d", descriptor = "(I)V")
	public static synchronized void method22(@OriginalArg(0) int arg0) {
		if (!aBoolean5) {
			return;
		}
		@Pc(8) long local8 = System.currentTimeMillis();
		@Pc(14) long local14 = (local8 - aLong3) / 10L;
		if (local14 > 250L) {
			local14 = 250L;
		}
		aLong3 = local8;
		if (arg0 == 1000) {
			arg0 = 11;
		}
		if (arg0 == 1001) {
			arg0 = 12;
		}
		if (arg0 == 1002) {
			arg0 = 14;
		}
		if (arg0 == 1003) {
			arg0 = 15;
		}
		if (arg0 >= 1008) {
			arg0 -= 992;
		}
		method13(3);
		aClass2_Sub1_Sub2_1.method101(9);
		aClass2_Sub1_Sub2_1.method101((int) local14);
		aClass2_Sub1_Sub2_1.method101(arg0);
	}
}
