package jagex2.config;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from rs3
@OriginalClass("client!fc")
public class FloType {

	@OriginalMember(owner = "client!fc", name = "c", descriptor = "I")
	public static int count;

	@OriginalMember(owner = "client!fc", name = "d", descriptor = "[Lclient!fc;")
	public static FloType[] instances;

	@OriginalMember(owner = "client!fc", name = "e", descriptor = "I")
	public int rgb;

	@OriginalMember(owner = "client!fc", name = "f", descriptor = "I")
	public int texture = -1;

	@OriginalMember(owner = "client!fc", name = "g", descriptor = "Z")
	private boolean overlay = false;

	@OriginalMember(owner = "client!fc", name = "h", descriptor = "Z")
	public boolean occlude = true;

	@OriginalMember(owner = "client!fc", name = "i", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "client!fc", name = "j", descriptor = "I")
	public int hue;

	@OriginalMember(owner = "client!fc", name = "k", descriptor = "I")
	public int saturation;

	@OriginalMember(owner = "client!fc", name = "l", descriptor = "I")
	public int lightness;

	@OriginalMember(owner = "client!fc", name = "m", descriptor = "I")
	public int chroma;

	@OriginalMember(owner = "client!fc", name = "n", descriptor = "I")
	public int luminance;

	@OriginalMember(owner = "client!fc", name = "o", descriptor = "I")
	public int hsl;

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void unpack(@OriginalArg(0) Jagfile config) {
		@Pc(9) Packet dat = new Packet(config.read("flo.dat", null));
		count = dat.g2();

		if (instances == null) {
			instances = new FloType[count];
		}

		for (@Pc(23) int id = 0; id < count; id++) {
			if (instances[id] == null) {
				instances[id] = new FloType();
			}

			instances[id].decode(dat);
		}
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(10) int code = dat.g1();
			if (code == 0) {
				return;
			}

			if (code == 1) {
				this.rgb = dat.g3();
				this.setColor(this.rgb);
			} else if (code == 2) {
				this.texture = dat.g1();
			} else if (code == 3) {
				this.overlay = true;
			} else if (code == 5) {
				this.occlude = false;
			} else if (code == 6) {
				this.name = dat.gjstr();
			} else {
				System.out.println("Error unrecognised config code: " + code);
			}
		}
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(II)V")
	private void setColor(@OriginalArg(1) int rgb) {
		@Pc(10) double red = (double) (rgb >> 16 & 0xFF) / 256.0D;
		@Pc(28) double green = (double) (rgb >> 8 & 0xFF) / 256.0D;
		@Pc(35) double blue = (double) (rgb & 0xFF) / 256.0D;

		@Pc(37) double min = red;
		if (green < red) {
			min = green;
		}
		if (blue < min) {
			min = blue;
		}

		@Pc(51) double max = red;
		if (green > red) {
			max = green;
		}
		if (blue > max) {
			max = blue;
		}

		@Pc(65) double h = 0.0D;
		@Pc(67) double s = 0.0D;
		@Pc(73) double l = (min + max) / 2.0D;

		if (min != max) {
			if (l < 0.5D) {
				s = (max - min) / (max + min);
			}
			if (l >= 0.5D) {
				s = (max - min) / (2.0D - max - min);
			}

			if (red == max) {
				h = (green - blue) / (max - min);
			} else if (green == max) {
				h = (blue - red) / (max - min) + 2.0D;
			} else if (blue == max) {
				h = (red - green) / (max - min) + 4.0D;
			}
		}

		h /= 6.0D;

		this.hue = (int) (h * 256.0D);
		this.saturation = (int) (s * 256.0D);
		this.lightness = (int) (l * 256.0D);

		if (this.saturation < 0) {
			this.saturation = 0;
		} else if (this.saturation > 255) {
			this.saturation = 255;
		}

		if (this.lightness < 0) {
			this.lightness = 0;
		} else if (this.lightness > 255) {
			this.lightness = 255;
		}

		if (l > 0.5D) {
			this.luminance = (int) ((1.0D - l) * s * 512.0D);
		} else {
			this.luminance = (int) (l * s * 512.0D);
		}

		if (this.luminance < 1) {
			this.luminance = 1;
		}

		this.chroma = (int) (h * (double) this.luminance);

		@Pc(248) int hue = this.hue + (int) (Math.random() * 16.0D) - 8;
		if (hue < 0) {
			hue = 0;
		} else if (hue > 255) {
			hue = 255;
		}

		@Pc(269) int saturation = this.saturation + (int) (Math.random() * 48.0D) - 24;
		if (saturation < 0) {
			saturation = 0;
		} else if (saturation > 255) {
			saturation = 255;
		}

		@Pc(290) int lightness = this.lightness + (int) (Math.random() * 48.0D) - 24;
		if (lightness < 0) {
			lightness = 0;
		} else if (lightness > 255) {
			lightness = 255;
		}

		this.hsl = this.hsl24to16(hue, saturation, lightness);
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(III)I")
	private int hsl24to16(@OriginalArg(0) int hue, @OriginalArg(1) int saturation, @OriginalArg(2) int lightness) {
		if (lightness > 179) {
			saturation /= 2;
		}

		if (lightness > 192) {
			saturation /= 2;
		}

		if (lightness > 217) {
			saturation /= 2;
		}

		if (lightness > 243) {
			saturation /= 2;
		}

		return (hue / 4 << 10) + (saturation / 32 << 7) + lightness / 2;
	}
}
