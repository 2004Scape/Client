package jagex2.graphics;

import jagex2.datastruct.Hashable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fb")
public class Draw2D extends Hashable {

	public static boolean fullViewport = true;

	@OriginalMember(owner = "client!fb", name = "k", descriptor = "[I")
	public static int[] data;

	@OriginalMember(owner = "client!fb", name = "l", descriptor = "I")
	public static int width2d;

	@OriginalMember(owner = "client!fb", name = "m", descriptor = "I")
	public static int height2d;

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
	public static int centerX2d;

	@OriginalMember(owner = "client!fb", name = "t", descriptor = "I")
	public static int centerY2d;

	@OriginalMember(owner = "client!fb", name = "<init>", descriptor = "()V")
	protected Draw2D() {
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(I[III)V")
	public static void bind(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1, @OriginalArg(3) int arg3) {
		data = arg1;
		width2d = arg0;
		height2d = arg3;
		setBounds(arg3, 0, arg0, 0);
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(I)V")
	public static void resetBounds() {
		left = 0;
		top = 0;
		right = width2d;
		bottom = height2d;
		if (fullViewport) {
			boundX = right;
		} else {
			boundX = right - 1;
		}
		centerX2d = right / 2;
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIII)V")
	public static void setBounds(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg4) {
		if (arg4 < 0) {
			arg4 = 0;
		}
		if (arg1 < 0) {
			arg1 = 0;
		}
		if (arg2 > width2d) {
			arg2 = width2d;
		}
		if (arg0 > height2d) {
			arg0 = height2d;
		}
		left = arg4;
		top = arg1;
		right = arg2;
		bottom = arg0;
		if (fullViewport) {
			boundX = right;
		} else {
			boundX = right - 1;
		}
		centerX2d = right / 2;
		centerY2d = bottom / 2;
	}

	@OriginalMember(owner = "client!fb", name = "b", descriptor = "(I)V")
	public static void clear() {
		@Pc(7) int local7 = width2d * height2d;
		for (@Pc(9) int local9 = 0; local9 < local7; local9++) {
			data[local9] = 0;
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIBII)V")
	public static void fillRect(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
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
		@Pc(50) int local50 = width2d - arg4;
		@Pc(56) int local56 = arg1 + arg0 * width2d;
		for (@Pc(59) int local59 = -arg5; local59 < 0; local59++) {
			for (@Pc(64) int local64 = -arg4; local64 < 0; local64++) {
				data[local56++] = arg2;
			}
			local56 += local50;
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIIII)V")
	public static void drawRect(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		drawHorizontalLine(arg2, arg4, arg5, arg1);
		drawHorizontalLine(arg2, arg4 + arg3 - 1, arg5, arg1);
		drawVerticalLine(arg2, arg4, arg3, arg1);
		drawVerticalLine(arg2, arg4, arg3, arg1 + arg5 - 1);
	}

	@OriginalMember(owner = "client!fb", name = "b", descriptor = "(IIIII)V")
	public static void drawHorizontalLine(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg2 < top || arg2 >= bottom) {
			return;
		}

		if (arg4 < left) {
			arg3 -= left - arg4;
			arg4 = left;
		}
		if (arg4 + arg3 > right) {
			arg3 = right - arg4;
		}
		@Pc(32) int local32 = arg4 + arg2 * width2d;
		for (@Pc(37) int local37 = 0; local37 < arg3; local37++) {
			data[local32 + local37] = arg0;
		}
	}

	@OriginalMember(owner = "client!fb", name = "c", descriptor = "(IIIII)V")
	public static void drawVerticalLine(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (arg4 < left || arg4 >= right) {
			return;
		}

		if (arg2 < top) {
			arg3 -= top - arg2;
			arg2 = top;
		}
		if (arg2 + arg3 > bottom) {
			arg3 = bottom - arg2;
		}
		@Pc(32) int local32 = arg4 + arg2 * width2d;
		for (@Pc(38) int local38 = 0; local38 < arg3; local38++) {
			data[local32 + local38 * width2d] = arg0;
		}
	}

	public static void drawLine(int x1, int y1, int x2, int y2, int rgb) {
		int dx = Math.abs(x2 - x1);
		int dy = Math.abs(y2 - y1);

		int sx = (x1 < x2) ? 1 : -1;
		int sy = (y1 < y2) ? 1 : -1;

		int err = dx - dy;

		while (true) {
			if ((x1 >= left) && (x1 < right) && (y1 >= top) && (y1 < bottom)) {
				data[x1 + (y1 * width2d)] = rgb;
			}

			if ((x1 == x2) && (y1 == y2)) {
				break;
			}

			int e2 = 2 * err;

			if (e2 > -dy) {
				err = err - dy;
				x1 = x1 + sx;
			}

			if (e2 < dx) {
				err = err + dx;
				y1 = y1 + sy;
			}
		}
	}

}
