package jagex2.graphics;

import jagex2.datastruct.Hashable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!fb")
public class Draw2D extends Hashable {

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
	public static void bind(@OriginalArg(0) int width, @OriginalArg(1) int[] src, @OriginalArg(3) int height) {
		data = src;
		width2d = width;
		height2d = height;
		setBounds(height, 0, width, 0);
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(I)V")
	public static void resetBounds() {
		left = 0;
		top = 0;
		right = width2d;
		bottom = height2d;
		boundX = right - 1;
		centerX2d = right / 2;
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIII)V")
	public static void setBounds(@OriginalArg(0) int bottom, @OriginalArg(1) int top, @OriginalArg(2) int right, @OriginalArg(4) int left) {
		if (left < 0) {
			left = 0;
		}

		if (top < 0) {
			top = 0;
		}

		if (right > width2d) {
			right = width2d;
		}

		if (bottom > height2d) {
			bottom = height2d;
		}

		Draw2D.left = left;
		Draw2D.top = top;
		Draw2D.right = right;
		Draw2D.bottom = bottom;
		boundX = Draw2D.right - 1;
		centerX2d = Draw2D.right / 2;
		centerY2d = Draw2D.bottom / 2;
	}

	@OriginalMember(owner = "client!fb", name = "b", descriptor = "(I)V")
	public static void clear() {
		@Pc(7) int len = width2d * height2d;
		for (@Pc(9) int i = 0; i < len; i++) {
			data[i] = 0;
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIBII)V")
	public static void fillRect(@OriginalArg(0) int y, @OriginalArg(1) int x, @OriginalArg(2) int rgb, @OriginalArg(4) int width, @OriginalArg(5) int height) {
		if (x < left) {
			width -= left - x;
			x = left;
		}

		if (y < top) {
			height -= top - y;
			y = top;
		}

		if (x + width > right) {
			width = right - x;
		}

		if (y + height > bottom) {
			height = bottom - y;
		}

		@Pc(50) int step = width2d - width;
		@Pc(56) int offset = x + y * width2d;
		for (@Pc(59) int i = -height; i < 0; i++) {
			for (@Pc(64) int j = -width; j < 0; j++) {
				data[offset++] = rgb;
			}

			offset += step;
		}
	}

	@OriginalMember(owner = "client!fb", name = "a", descriptor = "(IIIIII)V")
	public static void drawRect(@OriginalArg(1) int x, @OriginalArg(2) int rgb, @OriginalArg(3) int height, @OriginalArg(4) int y, @OriginalArg(5) int len) {
		drawHorizontalLine(rgb, y, len, x);
		drawHorizontalLine(rgb, y + height - 1, len, x);
		drawVerticalLine(rgb, y, height, x);
		drawVerticalLine(rgb, y, height, x + len - 1);
	}

	@OriginalMember(owner = "client!fb", name = "b", descriptor = "(IIIII)V")
	public static void drawHorizontalLine(@OriginalArg(0) int rgb, @OriginalArg(2) int y, @OriginalArg(3) int len, @OriginalArg(4) int x) {
		if (y < top || y >= bottom) {
			return;
		}

		if (x < left) {
			len -= left - x;
			x = left;
		}

		if (x + len > right) {
			len = right - x;
		}

		@Pc(32) int off = x + y * width2d;
		for (@Pc(37) int i = 0; i < len; i++) {
			data[off + i] = rgb;
		}
	}

	@OriginalMember(owner = "client!fb", name = "c", descriptor = "(IIIII)V")
	public static void drawVerticalLine(@OriginalArg(0) int rgb, @OriginalArg(2) int y, @OriginalArg(3) int len, @OriginalArg(4) int x) {
		if (x < left || x >= right) {
			return;
		}

		if (y < top) {
			len -= top - y;
			y = top;
		}

		if (y + len > bottom) {
			len = bottom - y;
		}

		@Pc(32) int off = x + y * width2d;
		for (@Pc(38) int i = 0; i < len; i++) {
			data[off + i * width2d] = rgb;
		}
	}

}
