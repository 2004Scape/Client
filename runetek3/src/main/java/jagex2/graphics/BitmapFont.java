package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.util.Random;

@OriginalClass("client!jb")
public final class BitmapFont extends Draw2D {

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

	private static int randomCycle = -1;
	private static int randomAlpha = 0;
	private static int randomSpacing = 0;

	static {
		@Pc(4) String local4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
		for (@Pc(6) int local6 = 0; local6 < 256; local6++) {
			@Pc(11) int local11 = local4.indexOf(local6);
			if (local11 == -1) {
				local11 = 74;
			}
			CHAR_LOOKUP[local6] = local11;
		}
	}

	@OriginalMember(owner = "client!jb", name = "<init>", descriptor = "(Lclient!ub;Ljava/lang/String;I)V")
	public BitmapFont(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) String arg1) {
		@Pc(71) Packet local71 = new Packet(arg0.read(arg1 + ".dat", null));
		@Pc(81) Packet local81 = new Packet(arg0.read("index.dat", null));
		local81.pos = local71.g2() + 4;
		@Pc(90) int local90 = local81.g1();
		if (local90 > 0) {
			local81.pos += (local90 - 1) * 3;
		}
		@Pc(131) int local131;
		for (@Pc(104) int local104 = 0; local104 < 94; local104++) {
			this.charOffsetX[local104] = local81.g1();
			this.charOffsetY[local104] = local81.g1();
			local131 = this.charMaskWidth[local104] = local81.g2();
			@Pc(139) int local139 = this.charMaskHeight[local104] = local81.g2();
			@Pc(142) int local142 = local81.g1();
			@Pc(146) int local146 = local131 * local139;
			this.charMask[local104] = new byte[local146];
			@Pc(156) int local156;
			@Pc(181) int local181;
			if (local142 == 0) {
				for (local156 = 0; local156 < local146; local156++) {
					this.charMask[local104][local156] = local71.g1b();
				}
			} else if (local142 == 1) {
				for (local156 = 0; local156 < local131; local156++) {
					for (local181 = 0; local181 < local139; local181++) {
						this.charMask[local104][local156 + local181 * local131] = local71.g1b();
					}
				}
			}
			if (local139 > this.height) {
				this.height = local139;
			}
			this.charOffsetX[local104] = 1;
			this.charAdvance[local104] = local131 + 2;
			local156 = 0;
			for (local181 = local139 / 7; local181 < local139; local181++) {
				local156 += this.charMask[local104][local181 * local131];
			}
			@Pc(255) int local255;
			if (local156 <= local139 / 7) {
				local255 = this.charAdvance[local104]--;
				this.charOffsetX[local104] = 0;
			}
			local156 = 0;
			for (@Pc(269) int local269 = local139 / 7; local269 < local139; local269++) {
				local156 += this.charMask[local104][local131 + local269 * local131 - 1];
			}
			if (local156 <= local139 / 7) {
				local255 = this.charAdvance[local104]--;
			}
		}
		this.charAdvance[94] = this.charAdvance[8];
		for (local131 = 0; local131 < 256; local131++) {
			this.drawWidth[local131] = this.charAdvance[CHAR_LOOKUP[local131]];
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IBILjava/lang/String;I)V")
	public void drawStringCenter(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) String arg3, @OriginalArg(4) int arg4) {
		this.drawString(arg4 - this.stringWidth(arg3) / 2, arg0, arg2, arg3);
	}

	public void drawStringRight(@OriginalArg(3) String str, @OriginalArg(4) int x, @OriginalArg(0) int y, @OriginalArg(2) int color, boolean shadowed) {
		if (shadowed) {
			this.drawString(x + 1 - this.stringWidth(str), y + 1, 0, str);
		}

		this.drawString(x - this.stringWidth(str), y, color, str);
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IIZILjava/lang/String;I)V")
	public void drawStringTaggableCenter(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) int arg3, @OriginalArg(4) String arg4) {
		this.drawStringTaggable(arg0 - this.stringWidth(arg4) / 2, arg3, arg4, arg2, arg1);
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(ZLjava/lang/String;)I")
	public int stringWidth(@OriginalArg(1) String arg1) {
		if (arg1 == null) {
			return 0;
		}
		@Pc(7) int local7 = 0;
		for (@Pc(14) int local14 = 0; local14 < arg1.length(); local14++) {
			if (arg1.charAt(local14) == '@' && local14 + 4 < arg1.length() && arg1.charAt(local14 + 4) == '@') {
				local14 += 4;
			} else {
				local7 += this.drawWidth[arg1.charAt(local14)];
			}
		}
		return local7;
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IIZILjava/lang/String;)V")
	public void drawString(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3, @OriginalArg(4) String arg4) {
		if (arg4 == null) {
			return;
		}

		@Pc(7) int local7 = arg1 - this.height;
		for (@Pc(19) int local19 = 0; local19 < arg4.length(); local19++) {
			@Pc(27) int local27 = CHAR_LOOKUP[arg4.charAt(local19)];
			if (local27 != 94) {
				this.fillMaskedRect(this.charMask[local27], arg0 + this.charOffsetX[local27], local7 + this.charOffsetY[local27], this.charMaskWidth[local27], this.charMaskHeight[local27], arg3);
			}
			arg0 += this.charAdvance[local27];
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IBIIILjava/lang/String;)V")
	public void drawCenteredWave(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) String arg5) {
		if (arg5 == null) {
			return;
		}

		arg2 -= this.stringWidth(arg5) / 2;
		@Pc(18) int local18 = arg3 - this.height;
		@Pc(24) int local24;
		for (local24 = 0; local24 < arg5.length(); local24++) {
			@Pc(39) int local39 = CHAR_LOOKUP[arg5.charAt(local24)];
			if (local39 != 94) {
				this.fillMaskedRect(this.charMask[local39], arg2 + this.charOffsetX[local39], local18 + this.charOffsetY[local39] + (int) (Math.sin((double) local24 / 2.0D + (double) arg0 / 5.0D) * 5.0D), this.charMaskWidth[local39], this.charMaskHeight[local39], arg4);
			}
			arg2 += this.charAdvance[local39];
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IIILjava/lang/String;ZI)V")
	public void drawStringTaggable(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) String arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) int arg5) {
		if (arg3 == null) {
			return;
		}

		@Pc(9) int local9 = arg2 - this.height;
		for (@Pc(11) int local11 = 0; local11 < arg3.length(); local11++) {
			if (arg3.charAt(local11) == '@' && local11 + 4 < arg3.length() && arg3.charAt(local11 + 4) == '@') {
				arg5 = this.evaluateTag(arg3.substring(local11 + 1, local11 + 4));
				local11 += 4;
			} else {
				@Pc(52) int local52 = CHAR_LOOKUP[arg3.charAt(local11)];
				if (local52 != 94) {
					if (arg4) {
						this.fillMaskedRect(this.charMask[local52], arg0 + this.charOffsetX[local52] + 1, local9 + this.charOffsetY[local52] + 1, this.charMaskWidth[local52], this.charMaskHeight[local52], 0);
					}
					this.fillMaskedRect(this.charMask[local52], arg0 + this.charOffsetX[local52], local9 + this.charOffsetY[local52], this.charMaskWidth[local52], this.charMaskHeight[local52], arg5);
				}
				arg0 += this.charAdvance[local52];
			}
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(IZBIILjava/lang/String;I)V")
	public void drawStringTooltip(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) String arg5, @OriginalArg(6) int arg6) {
		if (arg5 == null) {
			return;
		}

		if (randomCycle != arg0) {
			randomCycle = arg0;
			this.random.setSeed((long) arg0);
			randomAlpha = this.random.nextInt();
			randomSpacing = this.random.nextInt();
		}

		@Pc(17) int local17 = 192 + (randomAlpha & 0x1F);
		@Pc(22) int local22 = arg3 - this.height;
		for (@Pc(30) int local30 = 0; local30 < arg5.length(); local30++) {
			if (arg5.charAt(local30) == '@' && local30 + 4 < arg5.length() && arg5.charAt(local30 + 4) == '@') {
				arg4 = this.evaluateTag(arg5.substring(local30 + 1, local30 + 4));
				local30 += 4;
			} else {
				@Pc(71) int local71 = CHAR_LOOKUP[arg5.charAt(local30)];
				if (local71 != 94) {
					if (arg1) {
						this.fillMaskedRect(this.charMask[local71], arg6 + this.charOffsetX[local71] + 1, this.charMaskHeight[local71], 0, local22 + this.charOffsetY[local71] + 1, 192, this.charMaskWidth[local71]);
					}
					this.fillMaskedRect(this.charMask[local71], arg6 + this.charOffsetX[local71], this.charMaskHeight[local71], arg4, local22 + this.charOffsetY[local71], local17, this.charMaskWidth[local71]);
				}
				arg6 += this.charAdvance[local71];
				if ((randomSpacing & 0x3) == 0) {
					 arg6++;
				}
			}
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(ILjava/lang/String;)I")
	private int evaluateTag(@OriginalArg(1) String arg1) {
		if (arg1.equals("red")) {
			return 16711680;
		} else if (arg1.equals("gre")) {
			return 65280;
		} else if (arg1.equals("blu")) {
			return 255;
		} else if (arg1.equals("yel")) {
			return 16776960;
		} else if (arg1.equals("cya")) {
			return 65535;
		} else if (arg1.equals("mag")) {
			return 16711935;
		} else if (arg1.equals("whi")) {
			return 16777215;
		} else if (arg1.equals("bla")) {
			return 0;
		} else if (arg1.equals("lre")) {
			return 16748608;
		} else if (arg1.equals("dre")) {
			return 8388608;
		} else if (arg1.equals("dbl")) {
			return 128;
		} else if (arg1.equals("or1")) {
			return 16756736;
		} else if (arg1.equals("or2")) {
			return 16740352;
		} else if (arg1.equals("or3")) {
			return 16723968;
		} else if (arg1.equals("gr1")) {
			return 12648192;
		} else if (arg1.equals("gr2")) {
			return 8453888;
		} else if (arg1.equals("gr3")) {
			return 4259584;
		} else {
			return 0;
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "([BIIIII)V")
	private void fillMaskedRect(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(5) int local5 = arg1 + arg2 * Draw2D.width2d;
		@Pc(9) int local9 = Draw2D.width2d - arg3;
		@Pc(11) int local11 = 0;
		@Pc(13) int local13 = 0;
		@Pc(20) int local20;
		if (arg2 < Draw2D.top) {
			local20 = Draw2D.top - arg2;
			arg4 -= local20;
			arg2 = Draw2D.top;
			local13 += local20 * arg3;
			local5 += local20 * Draw2D.width2d;
		}
		if (arg2 + arg4 >= Draw2D.bottom) {
			arg4 -= arg2 + arg4 + 1 - Draw2D.bottom;
		}
		if (arg1 < Draw2D.left) {
			local20 = Draw2D.left - arg1;
			arg3 -= local20;
			arg1 = Draw2D.left;
			local13 += local20;
			local5 += local20;
			local11 += local20;
			local9 += local20;
		}
		if (arg1 + arg3 >= Draw2D.right) {
			local20 = arg1 + arg3 + 1 - Draw2D.right;
			arg3 -= local20;
			local11 += local20;
			local9 += local20;
		}
		if (arg3 > 0 && arg4 > 0) {
			this.fillMaskedRect(Draw2D.data, arg0, arg5, local13, local5, arg3, arg4, local9, local11);
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "([I[BIIIIIII)V")
	private void fillMaskedRect(@OriginalArg(0) int[] arg0, @OriginalArg(1) byte[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(6) int local6 = -(arg5 >> 2);
		@Pc(11) int local11 = -(arg5 & 0x3);
		for (@Pc(14) int local14 = -arg6; local14 < 0; local14++) {
			for (@Pc(18) int local18 = local6; local18 < 0; local18++) {
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
			for (@Pc(77) int local77 = local11; local77 < 0; local77++) {
				if (arg1[arg3++] == 0) {
					arg4++;
				} else {
					arg0[arg4++] = arg2;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "([BBIIIIII)V")
	private void fillMaskedRect(@OriginalArg(0) byte[] arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(10) int local10 = arg2 + arg5 * Draw2D.width2d;
		@Pc(14) int local14 = Draw2D.width2d - arg7;
		@Pc(16) int local16 = 0;
		@Pc(18) int local18 = 0;
		@Pc(25) int local25;
		if (arg5 < Draw2D.top) {
			local25 = Draw2D.top - arg5;
			arg3 -= local25;
			arg5 = Draw2D.top;
			local18 += local25 * arg7;
			local10 += local25 * Draw2D.width2d;
		}
		if (arg5 + arg3 >= Draw2D.bottom) {
			arg3 -= arg5 + arg3 + 1 - Draw2D.bottom;
		}
		if (arg2 < Draw2D.left) {
			local25 = Draw2D.left - arg2;
			arg7 -= local25;
			arg2 = Draw2D.left;
			local18 += local25;
			local10 += local25;
			local16 += local25;
			local14 += local25;
		}
		if (arg2 + arg7 >= Draw2D.right) {
			local25 = arg2 + arg7 + 1 - Draw2D.right;
			arg7 -= local25;
			local16 += local25;
			local14 += local25;
		}
		if (arg7 > 0 && arg3 > 0) {
			this.fillMaskedRect(arg3, local10, arg7, Draw2D.data, arg0, arg6, local18, local14, local16, arg4);
		}
	}

	@OriginalMember(owner = "client!jb", name = "a", descriptor = "(III[I[BIIIIBI)V")
	private void fillMaskedRect(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3, @OriginalArg(4) byte[] arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(10) int arg10) {
		@Pc(19) int local19 = ((arg10 & 0xFF00FF) * arg5 & 0xFF00FF00) + ((arg10 & 0xFF00) * arg5 & 0xFF0000) >> 8;
		@Pc(29) int local29;
		@Pc(38) int local38 = 256 - arg5;
		for (local29 = -arg0; local29 < 0; local29++) {
			for (@Pc(46) int local46 = -arg2; local46 < 0; local46++) {
				if (arg4[arg6++] == 0) {
					arg1++;
				} else {
					@Pc(57) int local57 = arg3[arg1];
					arg3[arg1++] = (((local57 & 0xFF00FF) * local38 & 0xFF00FF00) + ((local57 & 0xFF00) * local38 & 0xFF0000) >> 8) + local19;
				}
			}
			arg1 += arg7;
			arg6 += arg8;
		}
	}
}
