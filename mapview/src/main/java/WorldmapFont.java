import jagex2.client.GameShell;
import jagex2.graphics.Pix2D;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.*;
import java.awt.image.PixelGrabber;

@OriginalClass("mapview!g")
public final class WorldmapFont extends Pix2D {

	private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

	@OriginalMember(owner = "mapview!g", name = "s", descriptor = "[I")
	private static int[] fontChar = new int[256];

	@OriginalMember(owner = "mapview!g", name = "p", descriptor = "Z")
	private boolean fontCharFlagged = false;

	@OriginalMember(owner = "mapview!g", name = "q", descriptor = "I")
	private int fontCharPos = 0;

	@OriginalMember(owner = "mapview!g", name = "r", descriptor = "[B")
	private byte[] fontCharInfo = new byte[100000];

	static {
		for (@Pc(4) int i = 0; i < 256; i++) {
			@Pc(9) int c = CHARSET.indexOf(i);
			if (c == -1) {
				c = 'J';
			}
			fontChar[i] = c * 9;
		}
	}

	@OriginalMember(owner = "mapview!g", name = "<init>", descriptor = "(IZLmapview!a;)V")
	public WorldmapFont(@OriginalArg(0) int size, @OriginalArg(1) boolean bold, @OriginalArg(2) GameShell shell) {
		this.fontCharPos = 855;
		this.fontCharFlagged = false;

		@Pc(30) Font font = new Font("Helvetica", bold ? Font.BOLD : Font.PLAIN, size);
		@Pc(34) FontMetrics metrics = shell.getFontMetrics(font);

		for (int i = 0; i < 95; i++) {
			this.load(font, metrics, CHARSET.charAt(i), i, false, shell);
		}

		if (bold && this.fontCharFlagged) {
			this.fontCharPos = 855;
			this.fontCharFlagged = false;

			font = new Font("Helvetica", Font.PLAIN, size);
			metrics = shell.getFontMetrics(font);

			for (int i = 0; i < 95; i++) {
				this.load(font, metrics, CHARSET.charAt(i), i, false, shell);
			}

			if (!this.fontCharFlagged) {
				this.fontCharPos = 855;
				this.fontCharFlagged = false;

				for (int i = 0; i < 95; i++) {
					this.load(font, metrics, CHARSET.charAt(i), i, true, shell);
				}
			}
		}

		@Pc(123) byte[] chars = new byte[this.fontCharPos];
		for (@Pc(125) int i = 0; i < this.fontCharPos; i++) {
			chars[i] = this.fontCharInfo[i];
		}
		this.fontCharInfo = chars;
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(Ljava/awt/Font;Ljava/awt/FontMetrics;CIZLmapview!a;)V")
	private void load(@OriginalArg(0) Font font, @OriginalArg(1) FontMetrics metrics, @OriginalArg(2) char c, @OriginalArg(3) int id, @OriginalArg(4) boolean offset, @OriginalArg(5) GameShell shell) {
		@Pc(5) int width = metrics.charWidth(c);
		@Pc(7) int initialWidth = width;

		if (offset) {
			try {
				if (c == '/') {
					offset = false;
				}

				if (c == 'f' || c == 't' || c == 'w' || c == 'v' || c == 'k' || c == 'x' || c == 'y' || c == 'A' || c == 'V' || c == 'W') {
					width++;
				}
			} catch (@Pc(47) Exception ignore) {
			}
		}

		@Pc(50) int maxAscent = metrics.getMaxAscent();
		@Pc(56) int totalDescent = metrics.getMaxAscent() + metrics.getMaxDescent();
		@Pc(59) int height = metrics.getHeight();

		@Pc(65) Image image = shell.getBaseComponent().createImage(width, totalDescent);
		@Pc(68) Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, totalDescent);

		g.setColor(Color.white);
		g.setFont(font);
		g.drawString(c + "", 0, maxAscent);

		if (offset) {
			g.drawString(c + "", 1, maxAscent);
		}

		@Pc(114) int[] pixels = new int[width * totalDescent];
		@Pc(126) PixelGrabber grabber = new PixelGrabber(image, 0, 0, width, totalDescent, pixels, 0, width);
		try {
			grabber.grabPixels();
		} catch (@Pc(131) Exception ignore) {
		}
		image.flush();
		image = null;

		@Pc(137) int left = 0;
		@Pc(139) int top = 0;
		@Pc(141) int right = width;
		@Pc(143) int bottom = totalDescent;

		findTop: for (int y = 0; y < totalDescent; y++) {
			for (int x = 0; x < width; x++) {
				int color = pixels[x + y * width];
				if ((color & 0xFFFFFF) != 0) {
					top = y;
					break findTop;
				}
			}
		}

		findLeft: for (int x = 0; x < width; x++) {
			for (int y = 0; y < totalDescent; y++) {
				int color = pixels[x + y * width];
				if ((color & 0xFFFFFF) != 0) {
					left = x;
					break findLeft;
				}
			}
		}

		findBottom: for (int y = totalDescent - 1; y >= 0; y--) {
			for (int x = 0; x < width; x++) {
				int color = pixels[x + y * width];
				if ((color & 0xFFFFFF) != 0) {
					bottom = y + 1;
					break findBottom;
				}
			}
		}

		findRight: for (int x = width - 1; x >= 0; x--) {
			for (int y = 0; y < totalDescent; y++) {
				int color = pixels[x + y * width];
				if ((color & 0xFFFFFF) != 0) {
					right = x + 1;
					break findRight;
				}
			}
		}

		this.fontCharInfo[id * 9] = (byte) (this.fontCharPos / 0x4000);
		this.fontCharInfo[id * 9 + 1] = (byte) (this.fontCharPos / 0x80 & 0x7F);
		this.fontCharInfo[id * 9 + 2] = (byte) (this.fontCharPos & 0x7F);
		this.fontCharInfo[id * 9 + 3] = (byte) (right - left);
		this.fontCharInfo[id * 9 + 4] = (byte) (bottom - top);
		this.fontCharInfo[id * 9 + 5] = (byte) left;
		this.fontCharInfo[id * 9 + 6] = (byte) (maxAscent - top);
		this.fontCharInfo[id * 9 + 7] = (byte) initialWidth;
		this.fontCharInfo[id * 9 + 8] = (byte) height;

		for (int y = top; y < bottom; y++) {
			for (int x = left; x < right; x++) {
				int color = pixels[x + y * width] & 0xFF;

				if (color > 30 && color < 230) {
					this.fontCharFlagged = true;
				}

				this.fontCharInfo[this.fontCharPos++] = (byte) color;
			}
		}
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(Ljava/lang/String;IIIZ)V")
	private void drawString(@OriginalArg(0) String str, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int rgb, @OriginalArg(4) boolean shadowed) {
		try {
			if (this.fontCharFlagged || rgb == 0) {
				shadowed = false;
			}

			for (@Pc(8) int i = 0; i < str.length(); i++) {
				@Pc(16) int c = fontChar[str.charAt(i)];

				if (shadowed) {
					this.drawChar(c, x + 1, y, 0, this.fontCharInfo, this.fontCharFlagged);
					this.drawChar(c, x, y + 1, 0, this.fontCharInfo, this.fontCharFlagged);
				}

				this.drawChar(c, x, y, rgb, this.fontCharInfo, this.fontCharFlagged);
				x += this.fontCharInfo[c + 7];
			}
		} catch (@Pc(68) Exception ex) {
			System.out.println("drawstring: " + ex);
			ex.printStackTrace();
		}
	}

	@OriginalMember(owner = "mapview!g", name = "b", descriptor = "(Ljava/lang/String;IIIZ)V")
	public void drawStringCenter(@OriginalArg(0) String str, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int rgb, @OriginalArg(4) boolean shadowed) {
		@Pc(5) int xOffset = this.stringWidth(str) / 2;
		@Pc(8) int yOffset = this.getYOffset();
		if (x - xOffset <= Pix2D.right && (x + xOffset >= Pix2D.left && (y - yOffset <= Pix2D.bottom && y >= 0))) {
			this.drawString(str, x - xOffset, y, rgb, shadowed);
		}
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "([I[BIIIIIII)V")
	private void plotLetter2(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		for (@Pc(4) int local4 = -arg6; local4 < 0; local4++) {
			for (@Pc(9) int local9 = -arg5; local9 < 0; local9++) {
				@Pc(18) int local18 = arg1[arg3++] & 0xFF;
				if (local18 <= 30) {
					arg4++;
				} else if (local18 >= 230) {
					arg0[arg4++] = arg2;
				} else {
					@Pc(35) int local35 = arg0[arg4];
					arg0[arg4++] = ((arg2 & 0xFF00FF) * local18 + (local35 & 0xFF00FF) * (256 - local18) & 0xFF00FF00) + ((arg2 & 0xFF00) * local18 + (local35 & 0xFF00) * (256 - local18) & 0xFF0000) >> 8;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	@OriginalMember(owner = "mapview!g", name = "c", descriptor = "()I")
	public int getHeight() {
		return this.fontCharInfo[8] - 1; // (byte) height;
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(Ljava/lang/String;)I")
	private int stringWidth(@OriginalArg(0) String arg0) {
		@Pc(3) int local3 = 0;
		for (@Pc(5) int local5 = 0; local5 < arg0.length(); local5++) {
			if (arg0.charAt(local5) == '@' && local5 + 4 < arg0.length() && arg0.charAt(local5 + 4) == '@') {
				local5 += 4;
			} else if (arg0.charAt(local5) == '~' && local5 + 4 < arg0.length() && arg0.charAt(local5 + 4) == '~') {
				local5 += 4;
			} else {
				local3 += this.fontCharInfo[fontChar[arg0.charAt(local5)] + 7];
			}
		}
		return local3;
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(IIII[BZ)V")
	private void drawChar(@OriginalArg(0) int c, @OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int rgb, @OriginalArg(4) byte[] info, @OriginalArg(5) boolean flagged) {
		@Pc(7) int local7 = x + info[c + 5];
		@Pc(15) int local15 = y - info[c + 6];
		@Pc(21) int local21 = info[c + 3];
		@Pc(27) int local27 = info[c + 4];
		@Pc(47) int local47 = info[c] * 16384 + info[c + 1] * 128 + info[c + 2];
		@Pc(53) int local53 = local7 + local15 * Pix2D.width2d;
		@Pc(57) int local57 = Pix2D.width2d - local21;
		@Pc(59) int local59 = 0;
		@Pc(66) int local66;
		if (local15 < Pix2D.top) {
			local66 = Pix2D.top - local15;
			local27 -= local66;
			local15 = Pix2D.top;
			local47 += local66 * local21;
			local53 += local66 * Pix2D.width2d;
		}
		if (local15 + local27 >= Pix2D.bottom) {
			local27 -= local15 + local27 - Pix2D.bottom + 1;
		}
		if (local7 < Pix2D.left) {
			local66 = Pix2D.left - local7;
			local21 -= local66;
			local7 = Pix2D.left;
			local47 += local66;
			local53 += local66;
			local59 += local66;
			local57 += local66;
		}
		if (local7 + local21 >= Pix2D.right) {
			local66 = local7 + local21 - Pix2D.right + 1;
			local21 -= local66;
			local59 += local66;
			local57 += local66;
		}
		if (local21 <= 0 || local27 <= 0) {
			return;
		}
		if (flagged) {
			this.plotLetter2(Pix2D.data, info, rgb, local47, local53, local21, local27, local57, local59);
		} else {
			this.plotLetter(Pix2D.data, info, rgb, local47, local53, local21, local27, local57, local59);
		}
	}

	@OriginalMember(owner = "mapview!g", name = "b", descriptor = "([I[BIIIIIII)V")
	private void plotLetter(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		try {
			@Pc(6) int local6 = -(arg5 >> 2);
			@Pc(11) int local11 = -(arg5 & 0x3);
			for (@Pc(14) int local14 = -arg6; local14 < 0; local14++) {
				@Pc(18) int local18;
				for (local18 = local6; local18 < 0; local18++) {
					if (arg1[arg3++] == 0) {
						arg4++;
					} else {
						arg0[arg4++] = arg2;
					}
					if (arg1[arg3++] == 0) {
						arg4++;
					} else {
						arg0[arg4++] = arg2;
					}
					if (arg1[arg3++] == 0) {
						arg4++;
					} else {
						arg0[arg4++] = arg2;
					}
					if (arg1[arg3++] == 0) {
						arg4++;
					} else {
						arg0[arg4++] = arg2;
					}
				}
				for (local18 = local11; local18 < 0; local18++) {
					if (arg1[arg3++] == 0) {
						arg4++;
					} else {
						arg0[arg4++] = arg2;
					}
				}
				arg4 += arg7;
				arg3 += arg8;
			}
		} catch (@Pc(108) Exception ex) {
			System.out.println("plotletter: " + ex);
			ex.printStackTrace();
		}
	}

	@OriginalMember(owner = "mapview!g", name = "d", descriptor = "()I")
	public int getYOffset() {
		return this.fontCharInfo[6]; // (byte) (maxAscent - top);
	}
}
