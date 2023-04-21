package jagex2.config;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// FloType: Floor definitions
@OriginalClass("client!fc")
public final class FloType {

	@OriginalMember(owner = "client!fc", name = "c", descriptor = "I")
	public static int count;

	@OriginalMember(owner = "client!fc", name = "d", descriptor = "[Lclient!fc;")
	public static FloType[] instances;

	@OriginalMember(owner = "client!fc", name = "e", descriptor = "I")
	public int rgb;

	@OriginalMember(owner = "client!fc", name = "f", descriptor = "I")
	public int texture = -1;

	@OriginalMember(owner = "client!fc", name = "g", descriptor = "Z")
	private boolean opcode3 = false;

	@OriginalMember(owner = "client!fc", name = "h", descriptor = "Z")
	public boolean occludes = true;

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
	public static void unpack(@OriginalArg(0) Jagfile arg0) {
		@Pc(9) Packet local9 = new Packet(arg0.read("flo.dat", null));
		count = local9.g2();
		if (instances == null) {
			instances = new FloType[count];
		}
		for (@Pc(23) int local23 = 0; local23 < count; local23++) {
			if (instances[local23] == null) {
				instances[local23] = new FloType();
			}
			instances[local23].decode(local9);
			// if (instances[local23].name.equals("mudfloor2")) {
			// 	instances[local23].texture = 3;
			// }
		}
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet buf) {
		while (true) {
			@Pc(10) int opcode = buf.g1();
			if (opcode == 0) {
				break;
			}

			if (opcode == 1) {
				this.rgb = buf.g3();
				this.setColor(this.rgb);
			} else if (opcode == 2) {
				this.texture = buf.g1();
			} else if (opcode == 3) {
				this.opcode3 = true;
			} else if (opcode == 5) {
				this.occludes = false;
			} else if (opcode == 6) {
				this.name = buf.gstr();
			} else {
				System.out.println("Error unrecognised config code: " + opcode);
			}
		}
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(II)V")
	private void setColor(@OriginalArg(1) int arg1) {
		@Pc(10) double local10 = (double) (arg1 >> 16 & 0xFF) / 256.0D;
		@Pc(28) double local28 = (double) (arg1 >> 8 & 0xFF) / 256.0D;
		@Pc(35) double local35 = (double) (arg1 & 0xFF) / 256.0D;
		@Pc(37) double local37 = local10;
		if (local28 < local10) {
			local37 = local28;
		}
		if (local35 < local37) {
			local37 = local35;
		}
		@Pc(51) double local51 = local10;
		if (local28 > local10) {
			local51 = local28;
		}
		if (local35 > local51) {
			local51 = local35;
		}
		@Pc(65) double local65 = 0.0D;
		@Pc(67) double local67 = 0.0D;
		@Pc(73) double local73 = (local37 + local51) / 2.0D;
		if (local37 != local51) {
			if (local73 < 0.5D) {
				local67 = (local51 - local37) / (local51 + local37);
			}
			if (local73 >= 0.5D) {
				local67 = (local51 - local37) / (2.0D - local51 - local37);
			}
			if (local10 == local51) {
				local65 = (local28 - local35) / (local51 - local37);
			} else if (local28 == local51) {
				local65 = (local35 - local10) / (local51 - local37) + 2.0D;
			} else if (local35 == local51) {
				local65 = (local10 - local28) / (local51 - local37) + 4.0D;
			}
		}
		local65 /= 6.0D;
		this.hue = (int) (local65 * 256.0D);
		this.saturation = (int) (local67 * 256.0D);
		this.lightness = (int) (local73 * 256.0D);
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
		if (local73 > 0.5D) {
			this.luminance = (int) ((1.0D - local73) * local67 * 512.0D);
		} else {
			this.luminance = (int) (local73 * local67 * 512.0D);
		}
		if (this.luminance < 1) {
			this.luminance = 1;
		}
		this.chroma = (int) (local65 * (double) this.luminance);
		@Pc(248) int local248 = this.hue + (int) (Math.random() * 16.0D) - 8;
		if (local248 < 0) {
			local248 = 0;
		} else if (local248 > 255) {
			local248 = 255;
		}
		@Pc(269) int local269 = this.saturation + (int) (Math.random() * 48.0D) - 24;
		if (local269 < 0) {
			local269 = 0;
		} else if (local269 > 255) {
			local269 = 255;
		}
		@Pc(290) int local290 = this.lightness + (int) (Math.random() * 48.0D) - 24;
		if (local290 < 0) {
			local290 = 0;
		} else if (local290 > 255) {
			local290 = 255;
		}
		this.hsl = this.hsl24to16(local248, local269, local290);
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(III)I")
	private int hsl24to16(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if (arg2 > 179) {
			arg1 /= 2;
		}
		if (arg2 > 192) {
			arg1 /= 2;
		}
		if (arg2 > 217) {
			arg1 /= 2;
		}
		if (arg2 > 243) {
			arg1 /= 2;
		}
		return (arg0 / 4 << 10) + (arg1 / 32 << 7) + arg2 / 2;
	}
}
