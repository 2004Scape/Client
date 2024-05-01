package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Random;

@OriginalClass("client!jb")
public class PixFont extends Draw2D {

	@OriginalMember(owner = "client!jb", name = "B", descriptor = "[[B")
	private final byte[][] charMask = new byte[94][];

	@OriginalMember(owner = "client!jb", name = "C", descriptor = "[I")
	private final int[] charMaskWidth = new int[94];

	@OriginalMember(owner = "client!jb", name = "D", descriptor = "[I")
	private final int[] charMaskHeight = new int[94];

	@OriginalMember(owner = "client!jb", name = "E", descriptor = "[I")
	private final int[] charOffsetX = new int[94];

	@OriginalMember(owner = "client!jb", name = "F", descriptor = "[I")
	private final int[] charOffsetY = new int[94];

	@OriginalMember(owner = "client!jb", name = "G", descriptor = "[I")
	private final int[] charAdvance = new int[95];

	@OriginalMember(owner = "client!jb", name = "H", descriptor = "[I")
	private final int[] drawWidth = new int[256];

	@OriginalMember(owner = "client!jb", name = "I", descriptor = "I")
	public int height;

	@OriginalMember(owner = "client!jb", name = "J", descriptor = "Ljava/util/Random;")
	private final Random random = new Random();

	@OriginalMember(owner = "client!jb", name = "K", descriptor = "[I")
	private static final int[] CHAR_LOOKUP = new int[256];

	static {
		@Pc(4) String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

		for (@Pc(6) int i = 0; i < 256; i++) {
			@Pc(11) int c = charset.indexOf(i);
			if (c == -1) {
				c = 74;
			}

			CHAR_LOOKUP[i] = c;
		}
	}

	@OriginalMember(owner = "client!jb", name = "<init>", descriptor = "(Lclient!ub;Ljava/lang/String;I)V")
	public PixFont(@OriginalArg(0) Jagfile title, @OriginalArg(1) String font) {
		@Pc(71) Packet dat = new Packet(title.read(font + ".dat", null));
		@Pc(81) Packet idx = new Packet(title.read("index.dat", null));
		idx.pos = dat.g2() + 4;

		@Pc(90) int off = idx.g1();
		if (off > 0) {
			idx.pos += (off - 1) * 3;
		}

		for (@Pc(104) int i = 0; i < 94; i++) {
			this.charOffsetX[i] = idx.g1();
			this.charOffsetY[i] = idx.g1();

			@Pc(131) int w = this.charMaskWidth[i] = idx.g2();
			@Pc(139) int h = this.charMaskHeight[i] = idx.g2();

			@Pc(142) int type = idx.g1();
			@Pc(146) int len = w * h;

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

			if (h > this.height) {
				this.height = h;
			}

			this.charOffsetX[i] = 1;
			this.charAdvance[i] = w + 2;

			int space = 0;
			for (int j = h / 7; j < h; j++) {
				space += this.charMask[i][j * w];
			}

			if (space <= h / 7) {
				this.charAdvance[i]--;
				this.charOffsetX[i] = 0;
			}

			space = 0;
			for (@Pc(269) int j = h / 7; j < h; j++) {
				space += this.charMask[i][w + j * w - 1];
			}

			if (space <= h / 7) {
				this.charAdvance[i]--;
			}
		}

		this.charAdvance[94] = this.charAdvance[8];
		for (int c = 0; c < 256; c++) {
			this.drawWidth[c] = this.charAdvance[CHAR_LOOKUP[c]];
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IBILjava/lang/String;I)V")
	public void drawStringCenter(@OriginalArg(4) int x, @OriginalArg(0) int y, @OriginalArg(3) String str, @OriginalArg(2) int rgb) {
		this.drawString(x - this.stringWidth(str) / 2, y, str, rgb);
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IIZILjava/lang/String;I)V")
	public void drawStringTaggableCenter(@OriginalArg(4) String str, @OriginalArg(0) int x, @OriginalArg(3) int y, @OriginalArg(1) int color, @OriginalArg(2) boolean shadowed) {
		this.drawStringTaggable(x - this.stringWidth(str) / 2, y, str, color, shadowed);
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(ZLjava/lang/String;)I")
	public int stringWidth(@OriginalArg(1) String str) {
		if (str == null) {
			return 0;
		}

		@Pc(7) int size = 0;
		for (@Pc(14) int c = 0; c < str.length(); c++) {
			if (str.charAt(c) == '@' && c + 4 < str.length() && str.charAt(c + 4) == '@') {
				c += 4;
			} else {
				size += this.drawWidth[str.charAt(c)];
			}
		}

		return size;
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IIZILjava/lang/String;)V")
	public void drawString(@OriginalArg(0) int x, @OriginalArg(1) int y, @OriginalArg(4) String str, @OriginalArg(3) int rgb) {
		if (str == null) {
			return;
		}

		@Pc(7) int offY = y - this.height;

		for (@Pc(19) int i = 0; i < str.length(); i++) {
			@Pc(27) int c = CHAR_LOOKUP[str.charAt(i)];
			if (c != 94) {
				this.drawChar(this.charMask[c], x + this.charOffsetX[c], offY + this.charOffsetY[c], this.charMaskWidth[c], this.charMaskHeight[c], rgb);
			}

			x += this.charAdvance[c];
		}
	}

	public void drawStringRight(int x, int y, String str, int rgb, boolean shadowed) {
		if (shadowed) {
			this.drawString(x + 1 - this.stringWidth(str), y + 1, str, 0x000000);
		}

		this.drawString(x - this.stringWidth(str), y, str, rgb);
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IBIIILjava/lang/String;)V")
	public void drawCenteredWave(@OriginalArg(2) int x, @OriginalArg(3) int y, @OriginalArg(5) String str, @OriginalArg(4) int rgb, @OriginalArg(0) int phase) {
		if (str == null) {
			return;
		}

		x -= this.stringWidth(str) / 2;
		@Pc(18) int offY = y - this.height;

		for (@Pc(24) int i = 0; i < str.length(); i++) {
			@Pc(39) int c = CHAR_LOOKUP[str.charAt(i)];

			if (c != 94) {
				this.drawChar(this.charMask[c], x + this.charOffsetX[c], offY + this.charOffsetY[c] + (int) (Math.sin((double) i / 2.0D + (double) phase / 5.0D) * 5.0D), this.charMaskWidth[c], this.charMaskHeight[c], rgb);
			}

			x += this.charAdvance[c];
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IIILjava/lang/String;ZI)V")
	public void drawStringTaggable(@OriginalArg(0) int x, @OriginalArg(2) int y, @OriginalArg(3) String str, @OriginalArg(5) int rgb, @OriginalArg(4) boolean shadowed) {
		if (str == null) {
			return;
		}

		@Pc(9) int offY = y - this.height;

		for (@Pc(11) int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '@' && i + 4 < str.length() && str.charAt(i + 4) == '@') {
				rgb = this.evaluateTag(str.substring(i + 1, i + 4));
				i += 4;
			} else {
				@Pc(52) int c = CHAR_LOOKUP[str.charAt(i)];
				if (c != 94) {
					if (shadowed) {
						this.drawChar(this.charMask[c], x + this.charOffsetX[c] + 1, offY + this.charOffsetY[c] + 1, this.charMaskWidth[c], this.charMaskHeight[c], 0);
					}

					this.drawChar(this.charMask[c], x + this.charOffsetX[c], offY + this.charOffsetY[c], this.charMaskWidth[c], this.charMaskHeight[c], rgb);
				}

				x += this.charAdvance[c];
			}
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IZBIILjava/lang/String;I)V")
	public void drawStringTooltip(@OriginalArg(6) int x, @OriginalArg(3) int y, @OriginalArg(5) String str, @OriginalArg(4) int color, @OriginalArg(1) boolean shadowed, @OriginalArg(0) int seed) {
		if (str == null) {
			return;
		}

		this.random.setSeed(seed);

		@Pc(17) int rand = (this.random.nextInt() & 0x1F) + 192;
		@Pc(22) int offY = y - this.height;
		for (@Pc(30) int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '@' && i + 4 < str.length() && str.charAt(i + 4) == '@') {
				color = this.evaluateTag(str.substring(i + 1, i + 4));
				i += 4;
			} else {
				@Pc(71) int c = CHAR_LOOKUP[str.charAt(i)];
				if (c != 94) {
					if (shadowed) {
						this.drawCharAlpha(x + this.charOffsetX[c] + 1, offY + this.charOffsetY[c] + 1, this.charMaskWidth[c], this.charMaskHeight[c], 0, 192, this.charMask[c]);
					}

					this.drawCharAlpha(x + this.charOffsetX[c], offY + this.charOffsetY[c], this.charMaskWidth[c], this.charMaskHeight[c], color, rand, this.charMask[c]);
				}

				x += this.charAdvance[c];
				if ((this.random.nextInt() & 0x3) == 0) {
					x++;
				}
			}
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(ILjava/lang/String;)I")
	private int evaluateTag(@OriginalArg(1) String tag) {
		if (tag.equals("red")) {
			return 0xff0000;
		} else if (tag.equals("gre")) {
			return 0xff00;
		} else if (tag.equals("blu")) {
			return 0xff;
		} else if (tag.equals("yel")) {
			return 0xffff00;
		} else if (tag.equals("cya")) {
			return 0xffff;
		} else if (tag.equals("mag")) {
			return 0xff00ff;
		} else if (tag.equals("whi")) {
			return 0xffffff;
		} else if (tag.equals("bla")) {
			return 0;
		} else if (tag.equals("lre")) {
			return 0xff9040;
		} else if (tag.equals("dre")) {
			return 0x800000;
		} else if (tag.equals("dbl")) {
			return 0x80;
		} else if (tag.equals("or1")) {
			return 0xffb000;
		} else if (tag.equals("or2")) {
			return 0xff7000;
		} else if (tag.equals("or3")) {
			return 0xff3000;
		} else if (tag.equals("gr1")) {
			return 0xc0ff00;
		} else if (tag.equals("gr2")) {
			return 0x80ff00;
		} else if (tag.equals("gr3")) {
			return 0x40ff00;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "([BIIIII)V")
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
			h -= y + h + 1 - Draw2D.bottom;
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
			int cutoff = x + w + 1 - Draw2D.right;
			w -= cutoff;
			srcStep += cutoff;
			dstStep += cutoff;
		}

		if (w > 0 && h > 0) {
			this.drawMask(w, h, data, srcOff, srcStep, Draw2D.data, dstOff, dstStep, rgb);
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "([I[BIIIIIII)V")
	private void drawMask(@OriginalArg(5) int w, @OriginalArg(6) int h, @OriginalArg(1) byte[] src, @OriginalArg(3) int srcOff, @OriginalArg(8) int srcStep, @OriginalArg(0) int[] dst, @OriginalArg(4) int dstOff, @OriginalArg(7) int dstStep, @OriginalArg(2) int rgb) {
		@Pc(6) int hw = -(w >> 2);
		w = -(w & 0x3);

		for (@Pc(14) int y = -h; y < 0; y++) {
			for (@Pc(18) int x = hw; x < 0; x++) {
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

			for (@Pc(77) int x = w; x < 0; x++) {
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

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "([BBIIIIII)V")
	private void drawCharAlpha(@OriginalArg(2) int x, @OriginalArg(5) int y, @OriginalArg(7) int w, @OriginalArg(3) int h, @OriginalArg(4) int rgb, @OriginalArg(6) int alpha, @OriginalArg(0) byte[] mask) {
		@Pc(10) int dstOff = x + y * Draw2D.width2d;
		@Pc(14) int dstStep = Draw2D.width2d - w;

		@Pc(16) int srcStep = 0;
		@Pc(18) int srcOff = 0;

		if (y < Draw2D.top) {
			int cutoff = Draw2D.top - y;
			h -= cutoff;
			y = Draw2D.top;
			srcOff += cutoff * w;
			dstOff += cutoff * Draw2D.width2d;
		}

		if (y + h >= Draw2D.bottom) {
			h -= y + h + 1 - Draw2D.bottom;
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
			int cutoff = x + w + 1 - Draw2D.right;
			w -= cutoff;
			srcStep += cutoff;
			dstStep += cutoff;
		}

		if (w > 0 && h > 0) {
			this.drawMaskAlpha(w, h, Draw2D.data, dstOff, dstStep, mask, srcOff, srcStep, rgb, alpha);
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(III[I[BIIIIBI)V")
	private void drawMaskAlpha(@OriginalArg(2) int w, @OriginalArg(0) int h, @OriginalArg(3) int[] dst, @OriginalArg(1) int dstOff, @OriginalArg(7) int dstStep, @OriginalArg(4) byte[] mask, @OriginalArg(6) int maskOff, @OriginalArg(8) int maskStep, @OriginalArg(10) int color, @OriginalArg(5) int alpha) {
		@Pc(19) int rgb = ((color & 0xFF00FF) * alpha & 0xFF00FF00) + ((color & 0xFF00) * alpha & 0xFF0000) >> 8;
		@Pc(38) int invAlpha = 256 - alpha;

		for (@Pc(29) int y = -h; y < 0; y++) {
			for (@Pc(46) int x = -w; x < 0; x++) {
				if (mask[maskOff++] == 0) {
					dstOff++;
				} else {
					@Pc(57) int dstRgb = dst[dstOff];
					dst[dstOff++] = (((dstRgb & 0xFF00FF) * invAlpha & 0xFF00FF00) + ((dstRgb & 0xFF00) * invAlpha & 0xFF0000) >> 8) + rgb;
				}
			}

			dstOff += dstStep;
			maskOff += maskStep;
		}
	}
}
