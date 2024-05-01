import java.util.Random;

import jagex2.graphics.Draw2D;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!i")
public final class PixFontFull extends Draw2D {

	@OriginalMember(owner = "mapview!i", name = "p", descriptor = "[[B")
	private byte[][] charMask = new byte[256][];

	@OriginalMember(owner = "mapview!i", name = "q", descriptor = "[I")
	private int[] charMaskWidth = new int[256];

	@OriginalMember(owner = "mapview!i", name = "r", descriptor = "[I")
	private int[] charMaskHeight = new int[256];

	@OriginalMember(owner = "mapview!i", name = "s", descriptor = "[I")
	private int[] charOffsetX = new int[256];

	@OriginalMember(owner = "mapview!i", name = "t", descriptor = "[I")
	private int[] charOffsetY = new int[256];

	@OriginalMember(owner = "mapview!i", name = "u", descriptor = "[I")
	private int[] charAdvance = new int[256];

	@OriginalMember(owner = "mapview!i", name = "v", descriptor = "I")
	private int height = 0;

	@OriginalMember(owner = "mapview!i", name = "w", descriptor = "Ljava/util/Random;")
	private Random random = new Random();

	@OriginalMember(owner = "mapview!i", name = "x", descriptor = "Z")
	private boolean aBoolean6 = false;

	@OriginalMember(owner = "mapview!i", name = "<init>", descriptor = "(Lmapview!o;Ljava/lang/String;Z)V")
	public PixFontFull(@OriginalArg(0) Jagfile title, @OriginalArg(1) String font, @OriginalArg(2) boolean swapSpace) {
		@Pc(53) Packet dat = new Packet(title.read(font + ".dat", null));
		@Pc(61) Packet idx = new Packet(title.read("index.dat", null));
		idx.pos = dat.g2() + 4;

		@Pc(72) int off = idx.g1();
		if (off > 0) {
			idx.pos += (off - 1) * 3;
		}

		for (@Pc(86) int i = 0; i < 256; i++) {
			this.charOffsetX[i] = idx.g1();
			this.charOffsetY[i] = idx.g1();

			@Pc(115) int w = this.charMaskWidth[i] = idx.g2();
			@Pc(123) int h = this.charMaskHeight[i] = idx.g2();

			@Pc(126) int type = idx.g1();
			@Pc(130) int len = w * h;
			this.charMask[i] = new byte[len];

			if (type == 0) {
				for (int j = 0; j < len; j++) {
					this.charMask[i][j] = dat.g1b();
				}
			} else if (type == 1) {
				for (int x = 0; x < w; x++) {
					for (int y = 0; y < h; y++) {
						this.charMask[i][x + y * w] = dat.g1b();
					}
				}
			}

			if (h > this.height && i < 128) {
				this.height = h;
			}

			this.charOffsetX[i] = 1;
			this.charAdvance[i] = w + 2;

			int space = 0;
			for (int j = h / 7; j < h; j++) {
				space += this.charMask[i][j * w];
			}

			if (space <= h / 7) {
				this.charAdvance[i] += -1;
				this.charOffsetX[i] = 0;
			}

			space = 0;
			for (int j = h / 7; j < h; j++) {
				space += this.charMask[i][w - 1 + j * w];
			}

			if (space <= h / 7) {
				this.charAdvance[i] += -1;
			}
		}

		if (swapSpace) {
			this.charAdvance[32] = this.charAdvance[73];
		} else {
			this.charAdvance[32] = this.charAdvance[105];
		}
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "(Ljava/lang/String;)I")
	private int stringWidth(@OriginalArg(0) String str) {
		if (str == null) {
			return 0;
		}

		@Pc(5) int size = 0;
		for (@Pc(7) int c = 0; c < str.length(); c++) {
			size += this.charAdvance[str.charAt(c)];
		}

		return size;
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "(Ljava/lang/String;III)V")
	public void drawString(@OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(0) String str, @OriginalArg(3) int rgb) {
		if (str == null) {
			return;
		}

		@Pc(7) int offY = y - this.height;

		for (@Pc(9) int i = 0; i < str.length(); i++) {
			@Pc(15) char c = str.charAt(i);
			if (c != ' ') {
				this.drawChar(this.charMask[c], x + this.charOffsetX[c], offY + this.charOffsetY[c], this.charMaskWidth[c], this.charMaskHeight[c], rgb);
			}

			x += this.charAdvance[c];
		}
	}

	@OriginalMember(owner = "mapview!i", name = "b", descriptor = "(Ljava/lang/String;III)V")
	public void drawStringRight(@OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(0) String str, @OriginalArg(3) int rgb) {
		this.drawString(x - this.stringWidth(str), y, str, rgb);
	}

	@OriginalMember(owner = "mapview!i", name = "c", descriptor = "(Ljava/lang/String;III)V")
	public void drawStringCenter(@OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(0) String str, @OriginalArg(3) int rgb) {
		this.drawString(x - this.stringWidth(str) / 2, y, str, rgb);
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "([BIIIII)V")
	private void drawChar(@OriginalArg(0) byte[] data, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int w, @OriginalArg(4) int h, @OriginalArg(5) int rgb) {
		@Pc(5) int dstOff = x + y * Draw2D.width2d;
		@Pc(9) int dstStep = Draw2D.width2d - w;

		@Pc(11) int srcStep = 0;
		@Pc(13) int srcOff = 0;

		if (y < Draw2D.top) {
			int cutoff = Draw2D.top - y;
			h -= cutoff;
			y = Draw2D.top;
			srcOff += cutoff * w;
			dstOff += cutoff * Draw2D.width2d;
		}

		if (y + h >= Draw2D.bottom) {
			h -= y + h - Draw2D.bottom + 1;
		}

		if (x < Draw2D.left) {
			int cutoff = Draw2D.left - x;
			w -= cutoff;
			x = Draw2D.left;
			srcOff += cutoff;
			dstOff += cutoff;
			srcStep += cutoff;
			dstStep += cutoff;
		}

		if (x + w >= Draw2D.right) {
			int local20 = x + w - Draw2D.right + 1;
			w -= local20;
			srcStep += local20;
			dstStep += local20;
		}

		if (w > 0 && h > 0) {
			this.drawMask(w, h, data, srcOff, srcStep, Draw2D.data, dstOff, dstStep, rgb);
		}
	}

	@OriginalMember(owner = "mapview!i", name = "a", descriptor = "([I[BIIIIIII)V")
	private void drawMask(@OriginalArg(5) int w, @OriginalArg(6) int h, @OriginalArg(1) byte[] src, @OriginalArg(3) int srcOff, @OriginalArg(8) int srcStep, @OriginalArg(0) int[] dst, @OriginalArg(4) int dstOff, @OriginalArg(7) int dstStep, @OriginalArg(2) int rgb) {
		@Pc(6) int hw = -(w >> 2);
		w = -(w & 0x3);

		for (@Pc(14) int y = -h; y < 0; y++) {
			for (int x = hw; x < 0; x++) {
				if (src[srcOff++] == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}

				if (src[srcOff++] == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}

				if (src[srcOff++] == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}

				if (src[srcOff++] == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}
			}

			for (int x = w; x < 0; x++) {
				if (src[srcOff++] == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}
			}

			dstOff += dstStep;
			srcOff += srcStep;
		}
	}
}
