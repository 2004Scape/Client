package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ib")
public class Pix8 extends Draw2D {

	@OriginalMember(owner = "client!ib", name = "z", descriptor = "[B")
	public byte[] pixels;

	@OriginalMember(owner = "client!ib", name = "A", descriptor = "[I")
	public final int[] palette;

	@OriginalMember(owner = "client!ib", name = "B", descriptor = "I")
	public int width;

	@OriginalMember(owner = "client!ib", name = "C", descriptor = "I")
	public int height;

	@OriginalMember(owner = "client!ib", name = "D", descriptor = "I")
	public int cropX;

	@OriginalMember(owner = "client!ib", name = "E", descriptor = "I")
	public int cropY;

	@OriginalMember(owner = "client!ib", name = "F", descriptor = "I")
	public int cropW;

	@OriginalMember(owner = "client!ib", name = "G", descriptor = "I")
	private int cropH;

	@OriginalMember(owner = "client!ib", name = "<init>", descriptor = "(Lclient!ub;Ljava/lang/String;I)V")
	public Pix8(@OriginalArg(0) Jagfile jag, @OriginalArg(1) String name, @OriginalArg(2) int index) {
		@Pc(32) Packet dat = new Packet(jag.read(name + ".dat", null));
		@Pc(42) Packet idx = new Packet(jag.read("index.dat", null));
		idx.pos = dat.g2();

		this.cropW = idx.g2();
		this.cropH = idx.g2();

		@Pc(57) int paletteCount = idx.g1();
		this.palette = new int[paletteCount];
		for (@Pc(63) int i = 0; i < paletteCount - 1; i++) {
			this.palette[i + 1] = idx.g3();
		}

		for (@Pc(81) int i = 0; i < index; i++) {
			idx.pos += 2;
			dat.pos += idx.g2() * idx.g2();
			idx.pos++;
		}

		this.cropX = idx.g1();
		this.cropY = idx.g1();
		this.width = idx.g2();
		this.height = idx.g2();

		@Pc(128) int pixelOrder = idx.g1();
		@Pc(134) int len = this.width * this.height;
		this.pixels = new byte[len];

		if (pixelOrder == 0) {
			for (int i = 0; i < len; i++) {
				this.pixels[i] = dat.g1b();
			}
		} else if (pixelOrder == 1) {
			for (@Pc(142) int x = 0; x < this.width; x++) {
				for (@Pc(164) int y = 0; y < this.height; y++) {
					this.pixels[x + y * this.width] = dat.g1b();
				}
			}
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(Z)V")
	public void shrink() {
		this.cropW /= 2;
		this.cropH /= 2;

		@Pc(20) byte[] pixels = new byte[this.cropW * this.cropH];
		@Pc(22) int off = 0;
		for (@Pc(24) int y = 0; y < this.height; y++) {
			for (@Pc(28) int x = 0; x < this.width; x++) {
				pixels[(x + this.cropX >> 1) + (y + this.cropY >> 1) * this.cropW] = this.pixels[off++];
			}
		}

		this.pixels = pixels;
		this.width = this.cropW;
		this.height = this.cropH;
		this.cropX = 0;
		this.cropY = 0;
	}

	@OriginalMember(owner = "client!ib", name = "c", descriptor = "(I)V")
	public void crop() {
		if (this.width == this.cropW && this.height == this.cropH) {
			return;
		}

		@Pc(19) byte[] pixels = new byte[this.cropW * this.cropH];
		@Pc(21) int off = 0;
		for (@Pc(33) int y = 0; y < this.height; y++) {
			for (@Pc(37) int x = 0; x < this.width; x++) {
				pixels[x + this.cropX + (y + this.cropY) * this.cropW] = this.pixels[off++];
			}
		}

		this.pixels = pixels;
		this.width = this.cropW;
		this.height = this.cropH;
		this.cropX = 0;
		this.cropY = 0;
	}

	@OriginalMember(owner = "client!ib", name = "d", descriptor = "(I)V")
	public void flipHorizontally() {
		@Pc(8) byte[] pixels = new byte[this.width * this.height];
		@Pc(10) int off = 0;
		for (@Pc(12) int y = 0; y < this.height; y++) {
			for (@Pc(19) int x = this.width - 1; x >= 0; x--) {
				pixels[off++] = this.pixels[x + y * this.width];
			}
		}

		this.pixels = pixels;
		this.cropX = this.cropW - this.width - this.cropX;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(B)V")
	public void flipVertically() {
		@Pc(8) byte[] pixels = new byte[this.width * this.height];
		@Pc(13) int off = 0;
		for (@Pc(25) int y = this.height - 1; y >= 0; y--) {
			for (@Pc(29) int x = 0; x < this.width; x++) {
				pixels[off++] = this.pixels[x + y * this.width];
			}
		}

		this.pixels = pixels;
		this.cropY = this.cropH - this.height - this.cropY;
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(IIIZ)V")
	public void translate(@OriginalArg(0) int r, @OriginalArg(1) int g, @OriginalArg(2) int b) {
		for (@Pc(3) int i = 0; i < this.palette.length; i++) {
			@Pc(14) int red = this.palette[i] >> 16 & 0xFF;
			red += r;
			if (red < 0) {
				red = 0;
			} else if (red > 255) {
				red = 255;
			}

			@Pc(38) int green = this.palette[i] >> 8 & 0xFF;
			green += g;
			if (green < 0) {
				green = 0;
			} else if (green > 255) {
				green = 255;
			}

			@Pc(60) int blue = this.palette[i] & 0xFF;
			blue += b;
			if (blue < 0) {
				blue = 0;
			} else if (blue > 255) {
				blue = 255;
			}

			this.palette[i] = (red << 16) + (green << 8) + blue;
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "(IIZ)V")
	public void draw(@OriginalArg(0) int y, @OriginalArg(1) int x) {
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
			this.copyPixels(Draw2D.data, srcOff, srcStep, this.pixels, h, w, dstOff, dstStep, this.palette);
		}
	}

	@OriginalMember(owner = "client!ib", name = "a", descriptor = "([III[BIIIII[I)V")
	private void copyPixels(@OriginalArg(0) int[] dst, @OriginalArg(1) int srcOff, @OriginalArg(2) int srcStep, @OriginalArg(3) byte[] src, @OriginalArg(4) int h, @OriginalArg(6) int w, @OriginalArg(7) int dstOff, @OriginalArg(8) int dstStep, @OriginalArg(9) int[] palette) {
		@Pc(6) int qw = -(w >> 2);
		w = -(w & 0x3);

		for (@Pc(17) int y = -h; y < 0; y++) {
			for (@Pc(21) int x = qw; x < 0; x++) {
				@Pc(28) byte palIndex = src[srcOff++];
				if (palIndex == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = palette[palIndex & 0xFF];
				}

				palIndex = src[srcOff++];
				if (palIndex == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = palette[palIndex & 0xFF];
				}

				palIndex = src[srcOff++];
				if (palIndex == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = palette[palIndex & 0xFF];
				}

				palIndex = src[srcOff++];
				if (palIndex == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = palette[palIndex & 0xFF];
				}
			}

			for (@Pc(104) int x = w; x < 0; x++) {
				@Pc(111) byte palIndex = src[srcOff++];
				if (palIndex == 0) {
					dstOff++;
				} else {
					dst[dstOff++] = palette[palIndex & 0xFF];
				}
			}

			dstOff += dstStep;
			srcOff += srcStep;
		}
	}
}
