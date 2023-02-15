import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!fb")
public class Draw2D extends CacheableNode {

	@OriginalMember(owner = "client!fb", name = "h", descriptor = "I")
	private static int flowObfuscator1;

	@OriginalMember(owner = "client!fb", name = "i", descriptor = "I")
	private static int flowObfuscator2;

	@OriginalMember(owner = "client!fb", name = "j", descriptor = "Z")
	private static final boolean flowObfuscator3 = true;

	@OriginalMember(owner = "client!fb", name = "k", descriptor = "[I")
	public static int[] anIntArray178;

	@OriginalMember(owner = "client!fb", name = "l", descriptor = "I")
	public static int anInt528;

	@OriginalMember(owner = "client!fb", name = "m", descriptor = "I")
	public static int anInt529;

	@OriginalMember(owner = "client!fb", name = "n", descriptor = "I")
	public static int top;

	@OriginalMember(owner = "client!fb", name = "o", descriptor = "I")
	public static int bottom;

	@OriginalMember(owner = "client!fb", name = "p", descriptor = "I")
	public static int left;

	@OriginalMember(owner = "client!fb", name = "q", descriptor = "I")
	public static int right;

	@OriginalMember(owner = "client!fb", name = "r", descriptor = "I")
	public static int boundX;

	@OriginalMember(owner = "client!fb", name = "s", descriptor = "I")
	public static int anInt535;

	@OriginalMember(owner = "client!fb", name = "t", descriptor = "I")
	public static int anInt536;

	@OriginalMember(owner = "client!fb", name = "<init>", descriptor = "()V")
	protected Draw2D() {
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(I[III)V")
	public static void bind(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			anIntArray178 = arg1;
			anInt528 = arg0;
			while (arg2 >= 0) {
				flowObfuscator1 = -151;
			}
			anInt529 = arg3;
			setBounds(arg3, 0, arg0, 789, 0);
		} catch (@Pc(19) RuntimeException local19) {
			signlink.reporterror("39631, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local19.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(I)V")
	public static void resetBounds(@OriginalArg(0) int arg0) {
		try {
			left = 0;
			top = 0;
			right = anInt528;
			if (arg0 != 0) {
				for (@Pc(9) int local9 = 1; local9 > 0; local9++) {
				}
			}
			bottom = anInt529;
			boundX = right - 1;
			anInt535 = right / 2;
		} catch (@Pc(26) RuntimeException local26) {
			signlink.reporterror("74265, " + arg0 + ", " + local26.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIII)V")
	public static void setBounds(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg4 < 0) {
				arg4 = 0;
			}
			if (arg1 < 0) {
				arg1 = 0;
			}
			if (arg2 > anInt528) {
				arg2 = anInt528;
			}
			if (arg0 > anInt529) {
				arg0 = anInt529;
			}
			left = arg4;
			top = arg1;
			right = arg2;
			bottom = arg0;
			boundX = right - 1;
			anInt535 = right / 2;
			if (arg3 <= 0) {
				for (@Pc(37) int local37 = 1; local37 > 0; local37++) {
				}
			}
			anInt536 = bottom / 2;
		} catch (@Pc(48) RuntimeException local48) {
			signlink.reporterror("56986, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local48.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "b", descriptor = "(I)V")
	public static void clear(@OriginalArg(0) int arg0) {
		try {
			@Pc(3) int local3 = 87 / arg0;
			@Pc(7) int local7 = anInt528 * anInt529;
			for (@Pc(9) int local9 = 0; local9 < local7; local9++) {
				anIntArray178[local9] = 0;
			}
		} catch (@Pc(21) RuntimeException local21) {
			signlink.reporterror("45949, " + arg0 + ", " + local21.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIBII)V")
	public static void fillRect(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			if (arg3 != 93) {
				flowObfuscator1 = 289;
			}
			if (arg1 < left) {
				arg4 -= left - arg1;
				arg1 = left;
			}
			if (arg0 < top) {
				arg5 -= top - arg0;
				arg0 = top;
			}
			if (arg1 + arg4 > right) {
				arg4 = right - arg1;
			}
			if (arg0 + arg5 > bottom) {
				arg5 = bottom - arg0;
			}
			@Pc(50) int local50 = anInt528 - arg4;
			@Pc(56) int local56 = arg1 + arg0 * anInt528;
			for (@Pc(59) int local59 = -arg5; local59 < 0; local59++) {
				for (@Pc(64) int local64 = -arg4; local64 < 0; local64++) {
					anIntArray178[local56++] = arg2;
				}
				local56 += local50;
			}
		} catch (@Pc(83) RuntimeException local83) {
			signlink.reporterror("10678, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local83.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIIII)V")
	public static void drawRect(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			if (arg0 >= 3 && arg0 <= 3) {
				drawHorizontalLine(arg2, 0, arg4, arg5, arg1);
				drawHorizontalLine(arg2, 0, arg4 + arg3 - 1, arg5, arg1);
				drawVerticalLine(arg2, flowObfuscator2, arg4, arg3, arg1);
				drawVerticalLine(arg2, flowObfuscator2, arg4, arg3, arg1 + arg5 - 1);
			}
		} catch (@Pc(40) RuntimeException local40) {
			signlink.reporterror("74170, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local40.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "b", descriptor = "(IIIII)V")
	public static void drawHorizontalLine(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg2 >= top && arg2 < bottom) {
				if (arg4 < left) {
					arg3 -= left - arg4;
					arg4 = left;
				}
				if (arg4 + arg3 > right) {
					arg3 = right - arg4;
				}
				@Pc(32) int local32 = arg4 + arg2 * anInt528;
				if (arg1 == 0) {
					for (@Pc(37) int local37 = 0; local37 < arg3; local37++) {
						anIntArray178[local32 + local37] = arg0;
					}
				}
			}
		} catch (@Pc(51) RuntimeException local51) {
			signlink.reporterror("17925, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local51.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fb", name = "c", descriptor = "(IIIII)V")
	public static void drawVerticalLine(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg4 >= left && arg4 < right) {
				if (arg2 < top) {
					arg3 -= top - arg2;
					arg2 = top;
				}
				if (arg2 + arg3 > bottom) {
					arg3 = bottom - arg2;
				}
				@Pc(32) int local32 = arg4 + arg2 * anInt528;
				if (arg1 != 0) {
					flowObfuscator2 = 71;
				}
				for (@Pc(38) int local38 = 0; local38 < arg3; local38++) {
					anIntArray178[local32 + local38 * anInt528] = arg0;
				}
			}
		} catch (@Pc(54) RuntimeException local54) {
			signlink.reporterror("40773, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local54.toString());
			throw new RuntimeException();
		}
	}

}
