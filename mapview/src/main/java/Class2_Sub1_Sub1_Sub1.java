import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.PixelGrabber;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!g")
public final class Class2_Sub1_Sub1_Sub1 extends Class2_Sub1_Sub1 {

	@OriginalMember(owner = "mapview!g", name = "s", descriptor = "[I")
	private static int[] anIntArray5 = new int[256];

	@OriginalMember(owner = "mapview!g", name = "p", descriptor = "Z")
	private boolean aBoolean11 = false;

	@OriginalMember(owner = "mapview!g", name = "q", descriptor = "I")
	private int anInt44 = 0;

	@OriginalMember(owner = "mapview!g", name = "r", descriptor = "[B")
	private byte[] aByteArray1 = new byte[100000];

	static {
		for (@Pc(4) int local4 = 0; local4 < 256; local4++) {
			@Pc(9) int local9 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(local4);
			if (local9 == -1) {
				local9 = 74;
			}
			anIntArray5[local4] = local9 * 9;
		}
	}

	@OriginalMember(owner = "mapview!g", name = "<init>", descriptor = "(IZLmapview!a;)V")
	public Class2_Sub1_Sub1_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Applet_Sub1 arg2) {
		this.anInt44 = 855;
		this.aBoolean11 = false;
		@Pc(30) Font local30 = new Font("Helvetica", arg1 ? 1 : 0, arg0);
		@Pc(34) FontMetrics local34 = arg2.getFontMetrics(local30);
		@Pc(36) int local36;
		for (local36 = 0; local36 < 95; local36++) {
			this.method45(local30, local34, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(local36), local36, false, arg2);
		}
		if (arg1 && this.aBoolean11) {
			this.anInt44 = 855;
			this.aBoolean11 = false;
			local30 = new Font("Helvetica", 0, arg0);
			local34 = arg2.getFontMetrics(local30);
			for (local36 = 0; local36 < 95; local36++) {
				this.method45(local30, local34, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(local36), local36, false, arg2);
			}
			if (!this.aBoolean11) {
				this.anInt44 = 855;
				this.aBoolean11 = false;
				for (local36 = 0; local36 < 95; local36++) {
					this.method45(local30, local34, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(local36), local36, true, arg2);
				}
			}
		}
		@Pc(123) byte[] local123 = new byte[this.anInt44];
		for (@Pc(125) int local125 = 0; local125 < this.anInt44; local125++) {
			local123[local125] = this.aByteArray1[local125];
		}
		this.aByteArray1 = local123;
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(Ljava/awt/Font;Ljava/awt/FontMetrics;CIZLmapview!a;)V")
	private void method45(@OriginalArg(0) Font arg0, @OriginalArg(1) FontMetrics arg1, @OriginalArg(2) char arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) Applet_Sub1 arg5) {
		@Pc(5) int local5 = arg1.charWidth(arg2);
		@Pc(7) int local7 = local5;
		if (arg4) {
			try {
				if (arg2 == '/') {
					arg4 = false;
				}
				if (arg2 == 'f' || arg2 == 't' || arg2 == 'w' || arg2 == 'v' || arg2 == 'k' || arg2 == 'x' || arg2 == 'y' || arg2 == 'A' || arg2 == 'V' || arg2 == 'W') {
					local5++;
				}
			} catch (@Pc(47) Exception local47) {
			}
		}
		@Pc(50) int local50 = arg1.getMaxAscent();
		@Pc(56) int local56 = arg1.getMaxAscent() + arg1.getMaxDescent();
		@Pc(59) int local59 = arg1.getHeight();
		@Pc(65) Image local65 = arg5.method118().createImage(local5, local56);
		@Pc(68) Graphics local68 = local65.getGraphics();
		local68.setColor(Color.black);
		local68.fillRect(0, 0, local5, local56);
		local68.setColor(Color.white);
		local68.setFont(arg0);
		local68.drawString(arg2 + "", 0, local50);
		if (arg4) {
			local68.drawString(arg2 + "", 1, local50);
		}
		@Pc(114) int[] local114 = new int[local5 * local56];
		@Pc(126) PixelGrabber local126 = new PixelGrabber(local65, 0, 0, local5, local56, local114, 0, local5);
		try {
			local126.grabPixels();
		} catch (@Pc(131) Exception local131) {
		}
		local65.flush();
		local65 = null;
		@Pc(137) int local137 = 0;
		@Pc(139) int local139 = 0;
		@Pc(141) int local141 = local5;
		@Pc(143) int local143 = local56;
		@Pc(145) int local145;
		@Pc(149) int local149;
		@Pc(159) int local159;
		label143: for (local145 = 0; local145 < local56; local145++) {
			for (local149 = 0; local149 < local5; local149++) {
				local159 = local114[local149 + local145 * local5];
				if ((local159 & 0xFFFFFF) != 0) {
					local139 = local145;
					break label143;
				}
			}
		}
		label129: for (local145 = 0; local145 < local5; local145++) {
			for (local149 = 0; local149 < local56; local149++) {
				local159 = local114[local145 + local149 * local5];
				if ((local159 & 0xFFFFFF) != 0) {
					local137 = local145;
					break label129;
				}
			}
		}
		label115: for (local145 = local56 - 1; local145 >= 0; local145--) {
			for (local149 = 0; local149 < local5; local149++) {
				local159 = local114[local149 + local145 * local5];
				if ((local159 & 0xFFFFFF) != 0) {
					local143 = local145 + 1;
					break label115;
				}
			}
		}
		label101: for (local145 = local5 - 1; local145 >= 0; local145--) {
			for (local149 = 0; local149 < local56; local149++) {
				local159 = local114[local145 + local149 * local5];
				if ((local159 & 0xFFFFFF) != 0) {
					local141 = local145 + 1;
					break label101;
				}
			}
		}
		this.aByteArray1[arg3 * 9] = (byte) (this.anInt44 / 16384);
		this.aByteArray1[arg3 * 9 + 1] = (byte) (this.anInt44 / 128 & 0x7F);
		this.aByteArray1[arg3 * 9 + 2] = (byte) (this.anInt44 & 0x7F);
		this.aByteArray1[arg3 * 9 + 3] = (byte) (local141 - local137);
		this.aByteArray1[arg3 * 9 + 4] = (byte) (local143 - local139);
		this.aByteArray1[arg3 * 9 + 5] = (byte) local137;
		this.aByteArray1[arg3 * 9 + 6] = (byte) (local50 - local139);
		this.aByteArray1[arg3 * 9 + 7] = (byte) local7;
		this.aByteArray1[arg3 * 9 + 8] = (byte) local59;
		for (local145 = local139; local145 < local143; local145++) {
			for (local149 = local137; local149 < local141; local149++) {
				local159 = local114[local149 + local145 * local5] & 0xFF;
				if (local159 > 30 && local159 < 230) {
					this.aBoolean11 = true;
				}
				this.aByteArray1[this.anInt44++] = (byte) local159;
			}
		}
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(Ljava/lang/String;IIIZ)V")
	private void method46(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4) {
		try {
			if (this.aBoolean11 || arg3 == 0) {
				arg4 = false;
			}
			for (@Pc(8) int local8 = 0; local8 < arg0.length(); local8++) {
				@Pc(16) int local16 = anIntArray5[arg0.charAt(local8)];
				if (arg4) {
					this.method51(local16, arg1 + 1, arg2, 0, this.aByteArray1, this.aBoolean11);
					this.method51(local16, arg1, arg2 + 1, 0, this.aByteArray1, this.aBoolean11);
				}
				this.method51(local16, arg1, arg2, arg3, this.aByteArray1, this.aBoolean11);
				arg1 += this.aByteArray1[local16 + 7];
			}
		} catch (@Pc(68) Exception local68) {
			System.out.println("drawstring: " + local68);
			local68.printStackTrace();
		}
	}

	@OriginalMember(owner = "mapview!g", name = "b", descriptor = "(Ljava/lang/String;IIIZ)V")
	public void method47(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4) {
		@Pc(5) int local5 = this.method50(arg0) / 2;
		@Pc(8) int local8 = this.method53();
		if (arg1 - local5 <= Class2_Sub1_Sub1.anInt83 && (arg1 + local5 >= Class2_Sub1_Sub1.anInt82 && (arg2 - local8 <= Class2_Sub1_Sub1.anInt81 && arg2 >= 0))) {
			this.method46(arg0, arg1 - local5, arg2, arg3, arg4);
		}
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "([I[BIIIIIII)V")
	private void method48(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
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
	public int method49() {
		return this.aByteArray1[8] - 1;
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(Ljava/lang/String;)I")
	private int method50(@OriginalArg(0) String arg0) {
		@Pc(3) int local3 = 0;
		for (@Pc(5) int local5 = 0; local5 < arg0.length(); local5++) {
			if (arg0.charAt(local5) == '@' && local5 + 4 < arg0.length() && arg0.charAt(local5 + 4) == '@') {
				local5 += 4;
			} else if (arg0.charAt(local5) == '~' && local5 + 4 < arg0.length() && arg0.charAt(local5 + 4) == '~') {
				local5 += 4;
			} else {
				local3 += this.aByteArray1[anIntArray5[arg0.charAt(local5)] + 7];
			}
		}
		return local3;
	}

	@OriginalMember(owner = "mapview!g", name = "a", descriptor = "(IIII[BZ)V")
	private void method51(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) byte[] arg4, @OriginalArg(5) boolean arg5) {
		@Pc(7) int local7 = arg1 + arg4[arg0 + 5];
		@Pc(15) int local15 = arg2 - arg4[arg0 + 6];
		@Pc(21) int local21 = arg4[arg0 + 3];
		@Pc(27) int local27 = arg4[arg0 + 4];
		@Pc(47) int local47 = arg4[arg0] * 16384 + arg4[arg0 + 1] * 128 + arg4[arg0 + 2];
		@Pc(53) int local53 = local7 + local15 * Class2_Sub1_Sub1.anInt78;
		@Pc(57) int local57 = Class2_Sub1_Sub1.anInt78 - local21;
		@Pc(59) int local59 = 0;
		@Pc(66) int local66;
		if (local15 < Class2_Sub1_Sub1.anInt80) {
			local66 = Class2_Sub1_Sub1.anInt80 - local15;
			local27 -= local66;
			local15 = Class2_Sub1_Sub1.anInt80;
			local47 += local66 * local21;
			local53 += local66 * Class2_Sub1_Sub1.anInt78;
		}
		if (local15 + local27 >= Class2_Sub1_Sub1.anInt81) {
			local27 -= local15 + local27 - Class2_Sub1_Sub1.anInt81 + 1;
		}
		if (local7 < Class2_Sub1_Sub1.anInt82) {
			local66 = Class2_Sub1_Sub1.anInt82 - local7;
			local21 -= local66;
			local7 = Class2_Sub1_Sub1.anInt82;
			local47 += local66;
			local53 += local66;
			local59 += local66;
			local57 += local66;
		}
		if (local7 + local21 >= Class2_Sub1_Sub1.anInt83) {
			local66 = local7 + local21 - Class2_Sub1_Sub1.anInt83 + 1;
			local21 -= local66;
			local59 += local66;
			local57 += local66;
		}
		if (local21 <= 0 || local27 <= 0) {
			return;
		}
		if (arg5) {
			this.method48(Class2_Sub1_Sub1.anIntArray10, arg4, arg3, local47, local53, local21, local27, local57, local59);
		} else {
			this.method52(Class2_Sub1_Sub1.anIntArray10, arg4, arg3, local47, local53, local21, local27, local57, local59);
		}
	}

	@OriginalMember(owner = "mapview!g", name = "b", descriptor = "([I[BIIIIIII)V")
	private void method52(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
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
		} catch (@Pc(108) Exception local108) {
			System.out.println("plotletter: " + local108);
			local108.printStackTrace();
		}
	}

	@OriginalMember(owner = "mapview!g", name = "d", descriptor = "()I")
	public int method53() {
		return this.aByteArray1[6];
	}
}
