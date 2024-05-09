package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.*;
import java.awt.image.PixelGrabber;

// name derived from Pix8
@OriginalClass("client!hb")
public class Pix24 extends Draw2D {

	@OriginalMember(owner = "client!hb", name = "A", descriptor = "[I")
	public int[] pixels;

	@OriginalMember(owner = "client!hb", name = "B", descriptor = "I")
	public int width;

	@OriginalMember(owner = "client!hb", name = "C", descriptor = "I")
	public int height;

	@OriginalMember(owner = "client!hb", name = "D", descriptor = "I")
	private int cropX;

	@OriginalMember(owner = "client!hb", name = "E", descriptor = "I")
	private int cropY;

	@OriginalMember(owner = "client!hb", name = "F", descriptor = "I")
	public int cropW;

	@OriginalMember(owner = "client!hb", name = "G", descriptor = "I")
	public int cropH;

	@OriginalMember(owner = "client!hb", name = "<init>", descriptor = "(II)V")
	public Pix24(@OriginalArg(0) int width, @OriginalArg(1) int height) {
		this.pixels = new int[width * height];
		this.width = this.cropW = width;
		this.height = this.cropH = height;
		this.cropX = this.cropY = 0;
	}

	@OriginalMember(owner = "client!hb", name = "<init>", descriptor = "([BLjava/awt/Component;)V")
	public Pix24(@OriginalArg(0) byte[] src, @OriginalArg(1) Component c) {
		try {
			@Pc(17) Image image = Toolkit.getDefaultToolkit().createImage(src);
			@Pc(22) MediaTracker tracker = new MediaTracker(c);
			tracker.addImage(image, 0);
			tracker.waitForAll();
			this.width = image.getWidth(c);
			this.height = image.getHeight(c);
			this.cropW = this.width;
			this.cropH = this.height;
			this.cropX = 0;
			this.cropY = 0;
			this.pixels = new int[this.width * this.height];
			@Pc(76) PixelGrabber grabber = new PixelGrabber(image, 0, 0, this.width, this.height, this.pixels, 0, this.width);
			grabber.grabPixels();
		} catch (@Pc(81) Exception ignored) {
			System.out.println("Error converting jpg");
		}
	}

	@OriginalMember(owner = "client!hb", name = "<init>", descriptor = "(Lclient!ub;Ljava/lang/String;I)V")
	public Pix24(@OriginalArg(0) Jagfile jag, @OriginalArg(1) String name, @OriginalArg(2) int index) {
		@Pc(32) Packet dat = new Packet(jag.read(name + ".dat", null));
		@Pc(42) Packet idx = new Packet(jag.read("index.dat", null));

		idx.pos = dat.g2();
		this.cropW = idx.g2();
		this.cropH = idx.g2();

		@Pc(57) int paletteCount = idx.g1();
		@Pc(60) int[] palette = new int[paletteCount];
		for (@Pc(62) int i = 0; i < paletteCount - 1; i++) {
			palette[i + 1] = idx.g3();
			if (palette[i + 1] == 0) {
				palette[i + 1] = 1;
			}
		}

		for (@Pc(91) int i = 0; i < index; i++) {
			idx.pos += 2;
			dat.pos += idx.g2() * idx.g2();
			idx.pos++;
		}

		this.cropX = idx.g1();
		this.cropY = idx.g1();
		this.width = idx.g2();
		this.height = idx.g2();

		@Pc(138) int pixelOrder = idx.g1();
		@Pc(144) int len = this.width * this.height;
		this.pixels = new int[len];

		if (pixelOrder == 0) {
			for (int i = 0; i < len; i++) {
				this.pixels[i] = palette[dat.g1()];
			}
		} else if (pixelOrder == 1) {
			for (int x = 0; x < this.width; x++) {
				for (@Pc(176) int y = 0; y < this.height; y++) {
					this.pixels[x + y * this.width] = palette[dat.g1()];
				}
			}
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(B)V")
	public void bind() {
		Draw2D.bind(this.width, this.height, this.pixels);
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIIZ)V")
	public void translate(@OriginalArg(0) int r, @OriginalArg(1) int g, @OriginalArg(2) int b) {
		for (@Pc(3) int i = 0; i < this.pixels.length; i++) {
			@Pc(10) int rgb = this.pixels[i];

			if (rgb != 0) {
				@Pc(18) int red = rgb >> 16 & 0xFF;
				red += r;
				if (red < 1) {
					red = 1;
				} else if (red > 255) {
					red = 255;
				}

				@Pc(40) int green = rgb >> 8 & 0xFF;
				green += g;
				if (green < 1) {
					green = 1;
				} else if (green > 255) {
					green = 255;
				}

				@Pc(60) int blue = rgb & 0xFF;
				blue += b;
				if (blue < 1) {
					blue = 1;
				} else if (blue > 255) {
					blue = 255;
				}

				this.pixels[i] = (red << 16) + (green << 8) + blue;
			}
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(III)V")
	public void blitOpaque(@OriginalArg(1) int x, @OriginalArg(2) int y) {
		x += this.cropX;
		y += this.cropY;

		@Pc(15) int dstOff = x + y * Draw2D.width2d;
		@Pc(17) int srcOff = 0;
		@Pc(20) int h = this.height;
		@Pc(23) int w = this.width;
		@Pc(27) int dstStep = Draw2D.width2d - w;
		@Pc(29) int srcStep = 0;

		if (y < Draw2D.top) {
			int cutoff = Draw2D.top - y;
			h -= cutoff;
			y = Draw2D.top;
			srcOff += cutoff * w;
			dstOff += cutoff * Draw2D.width2d;
		}

		if (y + h > Draw2D.bottom) {
			h -= y + h - Draw2D.bottom;
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

		if (x + w > Draw2D.right) {
			int cutoff = x + w - Draw2D.right;
			w -= cutoff;
			srcStep += cutoff;
			dstStep += cutoff;
		}

		if (w > 0 && h > 0) {
			this.copyPixels(w, h, this.pixels, srcOff, srcStep, Draw2D.data, dstOff, dstStep);
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(I[IIIIIII[I)V")
	private void copyPixels(@OriginalArg(7) int w, @OriginalArg(3) int h, @OriginalArg(1) int[] src, @OriginalArg(4) int srcOff, @OriginalArg(5) int srcStep, @OriginalArg(8) int[] dst, @OriginalArg(6) int dstOff, @OriginalArg(2) int dstStep) {
		@Pc(6) int qw = -(w >> 2);
		w = -(w & 0x3);

		for (@Pc(14) int y = -h; y < 0; y++) {
			for (@Pc(18) int x = qw; x < 0; x++) {
				dst[dstOff++] = src[srcOff++];
				dst[dstOff++] = src[srcOff++];
				dst[dstOff++] = src[srcOff++];
				dst[dstOff++] = src[srcOff++];
			}

			for (@Pc(57) int x = w; x < 0; x++) {
				dst[dstOff++] = src[srcOff++];
			}

			dstOff += dstStep;
			srcOff += srcStep;
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIZ)V")
	public void draw(@OriginalArg(1) int x, @OriginalArg(0) int y) {
		x += this.cropX;
		y += this.cropY;

		@Pc(20) int dstOff = x + y * Draw2D.width2d;
		@Pc(22) int srcOff = 0;
		@Pc(25) int h = this.height;
		@Pc(28) int w = this.width;
		@Pc(32) int dstStep = Draw2D.width2d - w;
		@Pc(34) int srcStep = 0;

		if (y < Draw2D.top) {
			int cutoff = Draw2D.top - y;
			h -= cutoff;
			y = Draw2D.top;
			srcOff += cutoff * w;
			dstOff += cutoff * Draw2D.width2d;
		}

		if (y + h > Draw2D.bottom) {
			h -= y + h - Draw2D.bottom;
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

		if (x + w > Draw2D.right) {
			int cutoff = x + w - Draw2D.right;
			w -= cutoff;
			srcStep += cutoff;
			dstStep += cutoff;
		}

		if (w > 0 && h > 0) {
			this.copyPixels(Draw2D.data, this.pixels, srcOff, dstOff, w, h, dstStep, srcStep);
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "([I[IIIIIIII)V")
	private void copyPixels(@OriginalArg(0) int[] dst, @OriginalArg(1) int[] src, @OriginalArg(3) int srcOff, @OriginalArg(4) int dstOff, @OriginalArg(5) int w, @OriginalArg(6) int h, @OriginalArg(7) int dstStep, @OriginalArg(8) int srcStep) {
		@Pc(6) int qw = -(w >> 2);
		w = -(w & 0x3);

		for (@Pc(14) int y = -h; y < 0; y++) {
			for (@Pc(18) int x = qw; x < 0; x++) {
				int rgb = src[srcOff++];
				if (rgb == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}

				rgb = src[srcOff++];
				if (rgb == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}

				rgb = src[srcOff++];
				if (rgb == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}

				rgb = src[srcOff++];
				if (rgb == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}
			}

			for (@Pc(85) int x = w; x < 0; x++) {
				int rgb = src[srcOff++];
				if (rgb == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = rgb;
				}
			}

			dstOff += dstStep;
			srcOff += srcStep;
		}
	}

	@OriginalMember(owner = "client!hb", name = "d", descriptor = "(IIIII)V")
	public void crop(@OriginalArg(4) int x, @OriginalArg(1) int y, @OriginalArg(2) int w, @OriginalArg(0) int h) {
		try {
			@Pc(6) int currentW = this.width;
			@Pc(9) int currentH = this.height;

			@Pc(11) int offW = 0;
			@Pc(13) int offH = 0;
			@Pc(19) int scaleWidth = (currentW << 16) / w;
			@Pc(25) int scaleHeight = (currentH << 16) / h;

			@Pc(28) int cw = this.cropW;
			@Pc(31) int ch = this.cropH;
			@Pc(37) int scaleCropWidth = (cw << 16) / w;
			@Pc(43) int scaleCropHeight = (ch << 16) / h;

			x += (this.cropX * w + cw - 1) / cw;
			y += (this.cropY * h + ch - 1) / ch;

			if (this.cropX * w % cw != 0) {
				offW = (cw - this.cropX * w % cw << 16) / w;
			}

			if (this.cropY * h % ch != 0) {
				offH = (ch - this.cropY * h % ch << 16) / h;
			}

			w = w * (this.width - (offW >> 16)) / cw;
			h = h * (this.height - (offH >> 16)) / ch;

			@Pc(137) int dstStep = x + y * Draw2D.width2d;
			@Pc(141) int dstOff = Draw2D.width2d - w;

			if (y < Draw2D.top) {
				int cutoff = Draw2D.top - y;
				h -= cutoff;
				y = 0;
				dstStep += cutoff * Draw2D.width2d;
				offH += scaleCropHeight * cutoff;
			}

			if (y + h > Draw2D.bottom) {
				h -= y + h - Draw2D.bottom;
			}

			if (x < Draw2D.left) {
				int cutoff = Draw2D.left - x;
				w -= cutoff;
				x = 0;
				dstStep += cutoff;
				offW += scaleCropWidth * cutoff;
				dstOff += cutoff;
			}

			if (x + w > Draw2D.right) {
				int cutoff = x + w - Draw2D.right;
				w -= cutoff;
				dstOff += cutoff;
			}

			this.scale(w, h, this.pixels, offW, offH, Draw2D.data, dstOff, dstStep, currentW, scaleCropWidth, scaleCropHeight);
		} catch (@Pc(243) Exception ignored) {
			System.out.println("error in sprite clipping routine");
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(II[IIIII[IIIIII)V")
	private void scale(@OriginalArg(12) int w, @OriginalArg(10) int h, @OriginalArg(7) int[] src, @OriginalArg(0) int offW, @OriginalArg(5) int offH, @OriginalArg(2) int[] dst, @OriginalArg(8) int dstStep, @OriginalArg(9) int dstOff, @OriginalArg(11) int currentW, @OriginalArg(1) int scaleCropWidth, @OriginalArg(4) int scaleCropHeight) {
		try {
			@Pc(5) int lastOffW = offW;

			for (@Pc(15) int y = -h; y < 0; y++) {
				@Pc(23) int offY = (offH >> 16) * currentW;

				for (@Pc(26) int x = -w; x < 0; x++) {
					@Pc(36) int rgb = src[(offW >> 16) + offY];
					if (rgb == 0) {
						dstOff++;
					} else {
						dst[dstOff++] = rgb;
					}

					offW += scaleCropWidth;
				}

				offH += scaleCropHeight;
				offW = lastOffW;
				dstOff += dstStep;
			}
		} catch (@Pc(68) Exception ignored) {
			System.out.println("error in plot_scale");
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIIB)V")
	public void drawAlpha(@OriginalArg(0) int alpha, @OriginalArg(1) int x, @OriginalArg(2) int y) {
		x += this.cropX;
		y += this.cropY;

		@Pc(4) int dstStep = x + y * Draw2D.width2d;
		@Pc(27) int srcStep = 0;
		@Pc(30) int h = this.height;
		@Pc(33) int w = this.width;
		@Pc(37) int dstOff = Draw2D.width2d - w;
		@Pc(39) int srcOff = 0;

		if (y < Draw2D.top) {
			int cutoff = Draw2D.top - y;
			h -= cutoff;
			y = Draw2D.top;
			srcStep += cutoff * w;
			dstStep += cutoff * Draw2D.width2d;
		}

		if (y + h > Draw2D.bottom) {
			h -= y + h - Draw2D.bottom;
		}

		if (x < Draw2D.left) {
			int cutoff = Draw2D.left - x;
			w -= cutoff;
			x = Draw2D.left;
			srcStep += cutoff;
			dstStep += cutoff;
			srcOff += cutoff;
			dstOff += cutoff;
		}

		if (x + w > Draw2D.right) {
			int cutoff = x + w - Draw2D.right;
			w -= cutoff;
			srcOff += cutoff;
			dstOff += cutoff;
		}

		if (w > 0 && h > 0) {
			this.copyPixelsAlpha(w, h, this.pixels, srcStep, srcOff, Draw2D.data, dstStep, dstOff, alpha);
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(II[III[IIBIII)V")
	private void copyPixelsAlpha(@OriginalArg(8) int w, @OriginalArg(4) int h, @OriginalArg(2) int[] src, @OriginalArg(6) int srcOff, @OriginalArg(10) int srcStep, @OriginalArg(5) int[] dst, @OriginalArg(0) int dstOff, @OriginalArg(9) int dstStep, @OriginalArg(3) int alpha) {
		@Pc(5) int invAlpha = 256 - alpha;

		for (@Pc(19) int y = -h; y < 0; y++) {
			for (@Pc(24) int x = -w; x < 0; x++) {
				@Pc(31) int rgb = src[srcOff++];
				if (rgb == 0) {
					dstOff++;
				} else {
					@Pc(37) int dstRgb = dst[dstOff];
					dst[dstOff++] = ((rgb & 0xFF00FF) * alpha + (dstRgb & 0xFF00FF) * invAlpha & 0xFF00FF00) + ((rgb & 0xFF00) * alpha + (dstRgb & 0xFF00) * invAlpha & 0xFF0000) >> 8;
				}
			}

			dstOff += dstStep;
			srcOff += srcStep;
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(II[IIIIIIIZ[I)V")
	public void drawRotatedMasked(@OriginalArg(7) int x, @OriginalArg(8) int y, @OriginalArg(1) int w, @OriginalArg(3) int h, @OriginalArg(2) int[] lineStart, @OriginalArg(10) int[] lineWidth, @OriginalArg(6) int anchorX, @OriginalArg(4) int anchorY, @OriginalArg(0) int theta, @OriginalArg(5) int zoom) {
		try {
			@Pc(16) int centerX = -w / 2;
			@Pc(21) int centerY = -h / 2;

			@Pc(30) int sin = (int) (Math.sin((double) theta / 326.11D) * 65536.0D);
			@Pc(39) int cos = (int) (Math.cos((double) theta / 326.11D) * 65536.0D);
			@Pc(45) int sinZoom = sin * zoom >> 8;
			@Pc(51) int cosZoom = cos * zoom >> 8;

			@Pc(63) int leftX = (anchorX << 16) + centerY * sinZoom + centerX * cosZoom;
			@Pc(75) int leftY = (anchorY << 16) + (centerY * cosZoom - centerX * sinZoom);
			@Pc(81) int leftOff = x + y * Draw2D.width2d;

			for (@Pc(83) int i = 0; i < h; i++) {
				@Pc(89) int dstOff = lineStart[i];
				@Pc(93) int dstX = leftOff + dstOff;

				@Pc(99) int srcX = leftX + cosZoom * dstOff;
				@Pc(105) int srcY = leftY - sinZoom * dstOff;
				for (@Pc(110) int j = -lineWidth[i]; j < 0; j++) {
					Draw2D.data[dstX++] = this.pixels[(srcX >> 16) + (srcY >> 16) * this.width];
					srcX += cosZoom;
					srcY -= sinZoom;
				}

				leftX += sinZoom;
				leftY += cosZoom;
				leftOff += Draw2D.width2d;
			}
		} catch (@Pc(158) Exception ignored) {
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(Lclient!ib;IIB)V")
	public void drawMasked(@OriginalArg(2) int x, @OriginalArg(1) int y, @OriginalArg(0) Pix8 mask) {
		x += this.cropX;
		y += this.cropY;

		@Pc(15) int dstStep = x + y * Draw2D.width2d;
		@Pc(17) int srcStep = 0;
		@Pc(24) int h = this.height;
		@Pc(27) int w = this.width;
		@Pc(31) int dstOff = Draw2D.width2d - w;
		@Pc(33) int srcOff = 0;

		if (y < Draw2D.top) {
			int cutoff = Draw2D.top - y;
			h -= cutoff;
			y = Draw2D.top;
			srcStep += cutoff * w;
			dstStep += cutoff * Draw2D.width2d;
		}

		if (y + h > Draw2D.bottom) {
			h -= y + h - Draw2D.bottom;
		}

		if (x < Draw2D.left) {
			int cutoff = Draw2D.left - x;
			w -= cutoff;
			x = Draw2D.left;
			srcStep += cutoff;
			dstStep += cutoff;
			srcOff += cutoff;
			dstOff += cutoff;
		}

		if (x + w > Draw2D.right) {
			int cutoff = x + w - Draw2D.right;
			w -= cutoff;
			srcOff += cutoff;
			dstOff += cutoff;
		}

		if (w > 0 && h > 0) {
			this.copyPixelsMasked(w, h, this.pixels, srcOff, srcStep, Draw2D.data, dstStep, dstOff, mask.pixels);
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIIIII[I[II[BI)V")
	private void copyPixelsMasked(@OriginalArg(0) int w, @OriginalArg(4) int h, @OriginalArg(7) int[] src, @OriginalArg(1) int srcStep, @OriginalArg(5) int srcOff, @OriginalArg(6) int[] dst, @OriginalArg(8) int dstOff, @OriginalArg(10) int dstStep, @OriginalArg(9) byte[] mask) {
		@Pc(9) int qw = -(w >> 2);
		w = -(w & 0x3);

		for (@Pc(17) int y = -h; y < 0; y++) {
			for (@Pc(21) int x = qw; x < 0; x++) {
				int rgb = src[srcOff++];
				if (rgb != 0 && mask[dstOff] == 0) {
					dst[dstOff++] = rgb;
				} else {
					dstOff++;
				}

				rgb = src[srcOff++];
				if (rgb != 0 && mask[dstOff] == 0) {
					dst[dstOff++] = rgb;
				} else {
					dstOff++;
				}

				rgb = src[srcOff++];
				if (rgb != 0 && mask[dstOff] == 0) {
					dst[dstOff++] = rgb;
				} else {
					dstOff++;
				}

				rgb = src[srcOff++];
				if (rgb != 0 && mask[dstOff] == 0) {
					dst[dstOff++] = rgb;
				} else {
					dstOff++;
				}
			}

			for (@Pc(104) int x = w; x < 0; x++) {
				int rgb = src[srcOff++];
				if (rgb != 0 && mask[dstOff] == 0) {
					dst[dstOff++] = rgb;
				} else {
					dstOff++;
				}
			}

			dstOff += dstStep;
			srcOff += srcStep;
		}
	}
}
