import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!hb")
public final class Class1_Sub3_Sub2_Sub2 extends Class1_Sub3_Sub2 {

	@OriginalMember(owner = "client!hb", name = "w", descriptor = "I")
	private int anInt459;

	@OriginalMember(owner = "client!hb", name = "v", descriptor = "Z")
	private boolean aBoolean103 = false;

	@OriginalMember(owner = "client!hb", name = "x", descriptor = "Z")
	private boolean aBoolean104 = false;

	@OriginalMember(owner = "client!hb", name = "y", descriptor = "I")
	private int anInt460 = 15223;

	@OriginalMember(owner = "client!hb", name = "z", descriptor = "B")
	private final byte aByte23 = 5;

	@OriginalMember(owner = "client!hb", name = "A", descriptor = "[I")
	public int[] anIntArray148;

	@OriginalMember(owner = "client!hb", name = "F", descriptor = "I")
	public int anInt465;

	@OriginalMember(owner = "client!hb", name = "B", descriptor = "I")
	public int anInt461;

	@OriginalMember(owner = "client!hb", name = "G", descriptor = "I")
	public int anInt466;

	@OriginalMember(owner = "client!hb", name = "C", descriptor = "I")
	public int anInt462;

	@OriginalMember(owner = "client!hb", name = "E", descriptor = "I")
	private int anInt464;

	@OriginalMember(owner = "client!hb", name = "D", descriptor = "I")
	private int anInt463;

	@OriginalMember(owner = "client!hb", name = "<init>", descriptor = "(II)V")
	public Class1_Sub3_Sub2_Sub2(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anIntArray148 = new int[arg0 * arg1];
		this.anInt461 = this.anInt465 = arg0;
		this.anInt462 = this.anInt466 = arg1;
		this.anInt463 = this.anInt464 = 0;
	}

	@OriginalMember(owner = "client!hb", name = "<init>", descriptor = "([BLjava/awt/Component;)V")
	public Class1_Sub3_Sub2_Sub2(@OriginalArg(0) byte[] arg0, @OriginalArg(1) Component arg1) {
		try {
			@Pc(17) Image local17 = Toolkit.getDefaultToolkit().createImage(arg0);
			@Pc(22) MediaTracker local22 = new MediaTracker(arg1);
			local22.addImage(local17, 0);
			local22.waitForAll();
			this.anInt461 = local17.getWidth(arg1);
			this.anInt462 = local17.getHeight(arg1);
			this.anInt465 = this.anInt461;
			this.anInt466 = this.anInt462;
			this.anInt463 = 0;
			this.anInt464 = 0;
			this.anIntArray148 = new int[this.anInt461 * this.anInt462];
			@Pc(76) PixelGrabber local76 = new PixelGrabber(local17, 0, 0, this.anInt461, this.anInt462, this.anIntArray148, 0, this.anInt461);
			local76.grabPixels();
		} catch (@Pc(81) Exception local81) {
			System.out.println("Error converting jpg");
		}
	}

	@OriginalMember(owner = "client!hb", name = "<init>", descriptor = "(Lclient!ub;Ljava/lang/String;I)V")
	public Class1_Sub3_Sub2_Sub2(@OriginalArg(0) Class39 arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		@Pc(32) Class1_Sub3_Sub3 local32 = new Class1_Sub3_Sub3(363, arg0.method536(arg1 + ".dat", null, (byte) 2));
		@Pc(42) Class1_Sub3_Sub3 local42 = new Class1_Sub3_Sub3(363, arg0.method536("index.dat", null, (byte) 2));
		local42.anInt561 = local32.method393();
		this.anInt465 = local42.method393();
		this.anInt466 = local42.method393();
		@Pc(57) int local57 = local42.method391();
		@Pc(60) int[] local60 = new int[local57];
		for (@Pc(62) int local62 = 0; local62 < local57 - 1; local62++) {
			local60[local62 + 1] = local42.method395();
			if (local60[local62 + 1] == 0) {
				local60[local62 + 1] = 1;
			}
		}
		for (@Pc(91) int local91 = 0; local91 < arg2; local91++) {
			local42.anInt561 += 2;
			local32.anInt561 += local42.method393() * local42.method393();
			local42.anInt561++;
		}
		this.anInt463 = local42.method391();
		this.anInt464 = local42.method391();
		this.anInt461 = local42.method393();
		this.anInt462 = local42.method393();
		@Pc(138) int local138 = local42.method391();
		@Pc(144) int local144 = this.anInt461 * this.anInt462;
		this.anIntArray148 = new int[local144];
		@Pc(152) int local152;
		if (local138 == 0) {
			for (local152 = 0; local152 < local144; local152++) {
				this.anIntArray148[local152] = local60[local32.method391()];
			}
		} else if (local138 == 1) {
			for (local152 = 0; local152 < this.anInt461; local152++) {
				for (@Pc(176) int local176 = 0; local176 < this.anInt462; local176++) {
					this.anIntArray148[local152 + local176 * this.anInt461] = local60[local32.method391()];
				}
			}
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(B)V")
	public void method318(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != 62) {
				for (@Pc(4) int local4 = 1; local4 > 0; local4++) {
				}
			}
			Static12.method354(this.anInt461, this.anIntArray148, -657, this.anInt462);
		} catch (@Pc(19) RuntimeException local19) {
			signlink.reporterror("23946, " + arg0 + ", " + local19.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIIZ)V")
	public void method319(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
		try {
			for (@Pc(3) int local3 = 0; local3 < this.anIntArray148.length; local3++) {
				@Pc(10) int local10 = this.anIntArray148[local3];
				if (local10 != 0) {
					@Pc(18) int local18 = local10 >> 16 & 0xFF;
					local18 += arg0;
					if (local18 < 1) {
						local18 = 1;
					} else if (local18 > 255) {
						local18 = 255;
					}
					@Pc(40) int local40 = local10 >> 8 & 0xFF;
					local40 += arg1;
					if (local40 < 1) {
						local40 = 1;
					} else if (local40 > 255) {
						local40 = 255;
					}
					@Pc(60) int local60 = local10 & 0xFF;
					local60 += arg2;
					if (local60 < 1) {
						local60 = 1;
					} else if (local60 > 255) {
						local60 = 255;
					}
					this.anIntArray148[local3] = (local18 << 16) + (local40 << 8) + local60;
				}
			}
			if (arg3) {
				;
			}
		} catch (@Pc(99) RuntimeException local99) {
			signlink.reporterror("44391, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local99.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(III)V")
	public void method320(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			arg1 += this.anInt463;
			arg2 += this.anInt464;
			@Pc(15) int local15 = arg1 + arg2 * Static12.anInt528;
			@Pc(17) int local17 = 0;
			@Pc(20) int local20 = this.anInt462;
			@Pc(23) int local23 = this.anInt461;
			@Pc(27) int local27 = Static12.anInt528 - local23;
			@Pc(29) int local29 = 0;
			@Pc(36) int local36;
			if (arg2 < Static12.anInt530) {
				local36 = Static12.anInt530 - arg2;
				local20 -= local36;
				arg2 = Static12.anInt530;
				local17 += local36 * local23;
				local15 += local36 * Static12.anInt528;
			}
			if (arg2 + local20 > Static12.anInt531) {
				local20 -= arg2 + local20 - Static12.anInt531;
			}
			if (arg1 < Static12.anInt532) {
				local36 = Static12.anInt532 - arg1;
				local23 -= local36;
				arg1 = Static12.anInt532;
				local17 += local36;
				local15 += local36;
				local29 += local36;
				local27 += local36;
			}
			if (arg1 + local23 > Static12.anInt533) {
				local36 = arg1 + local23 - Static12.anInt533;
				local23 -= local36;
				local29 += local36;
				local27 += local36;
			}
			if (local23 > 0 && local20 > 0) {
				this.method321(15223, this.anIntArray148, local27, local20, local17, local29, local15, local23, Static12.anIntArray178);
				if (arg0 != 34676) {
					this.anInt459 = 117;
				}
			}
		} catch (@Pc(144) RuntimeException local144) {
			signlink.reporterror("18242, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local144.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(I[IIIIIII[I)V")
	private void method321(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int[] arg8) {
		try {
			@Pc(6) int local6 = -(arg7 >> 2);
			@Pc(11) int local11 = -(arg7 & 0x3);
			@Pc(18) int local18;
			for (@Pc(14) int local14 = -arg3; local14 < 0; local14++) {
				for (local18 = local6; local18 < 0; local18++) {
					arg8[arg6++] = arg1[arg4++];
					arg8[arg6++] = arg1[arg4++];
					arg8[arg6++] = arg1[arg4++];
					arg8[arg6++] = arg1[arg4++];
				}
				for (@Pc(57) int local57 = local11; local57 < 0; local57++) {
					arg8[arg6++] = arg1[arg4++];
				}
				arg6 += arg2;
				arg4 += arg5;
			}
			if (arg0 != this.anInt460) {
				for (local18 = 1; local18 > 0; local18++) {
				}
			}
		} catch (@Pc(94) RuntimeException local94) {
			signlink.reporterror("15160, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + local94.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIZ)V")
	public void method322(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2) {
		try {
			if (arg2) {
				this.anInt460 = 32;
			}
			arg1 += this.anInt463;
			arg0 += this.anInt464;
			@Pc(20) int local20 = arg1 + arg0 * Static12.anInt528;
			@Pc(22) int local22 = 0;
			@Pc(25) int local25 = this.anInt462;
			@Pc(28) int local28 = this.anInt461;
			@Pc(32) int local32 = Static12.anInt528 - local28;
			@Pc(34) int local34 = 0;
			@Pc(41) int local41;
			if (arg0 < Static12.anInt530) {
				local41 = Static12.anInt530 - arg0;
				local25 -= local41;
				arg0 = Static12.anInt530;
				local22 += local41 * local28;
				local20 += local41 * Static12.anInt528;
			}
			if (arg0 + local25 > Static12.anInt531) {
				local25 -= arg0 + local25 - Static12.anInt531;
			}
			if (arg1 < Static12.anInt532) {
				local41 = Static12.anInt532 - arg1;
				local28 -= local41;
				arg1 = Static12.anInt532;
				local22 += local41;
				local20 += local41;
				local34 += local41;
				local32 += local41;
			}
			if (arg1 + local28 > Static12.anInt533) {
				local41 = arg1 + local28 - Static12.anInt533;
				local28 -= local41;
				local34 += local41;
				local32 += local41;
			}
			if (local28 > 0 && local25 > 0) {
				this.method323(Static12.anIntArray178, this.anIntArray148, 0, local22, local20, local28, local25, local32, local34);
			}
		} catch (@Pc(143) RuntimeException local143) {
			signlink.reporterror("90492, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local143.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "([I[IIIIIIII)V")
	private void method323(@OriginalArg(0) int[] arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(6) int local6 = -(arg5 >> 2);
		@Pc(11) int local11 = -(arg5 & 0x3);
		for (@Pc(14) int local14 = -arg6; local14 < 0; local14++) {
			@Pc(25) int local25;
			for (@Pc(18) int local18 = local6; local18 < 0; local18++) {
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
			}
			for (@Pc(85) int local85 = local11; local85 < 0; local85++) {
				local25 = arg1[arg3++];
				if (local25 == 0) {
					arg4++;
				} else {
					arg0[arg4++] = local25;
				}
			}
			arg4 += arg7;
			arg3 += arg8;
		}
	}

	@OriginalMember(owner = "client!hb", name = "d", descriptor = "(IIIII)V")
	public void method324(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg3 == 17713) {
				try {
					@Pc(6) int local6 = this.anInt461;
					@Pc(9) int local9 = this.anInt462;
					@Pc(11) int local11 = 0;
					@Pc(13) int local13 = 0;
					@Pc(19) int local19 = (local6 << 16) / arg2;
					@Pc(25) int local25 = (local9 << 16) / arg0;
					@Pc(28) int local28 = this.anInt465;
					@Pc(31) int local31 = this.anInt466;
					@Pc(37) int local37 = (local28 << 16) / arg2;
					@Pc(43) int local43 = (local31 << 16) / arg0;
					arg4 += (this.anInt463 * arg2 + local28 - 1) / local28;
					arg1 += (this.anInt464 * arg0 + local31 - 1) / local31;
					if (this.anInt463 * arg2 % local28 != 0) {
						local11 = (local28 - this.anInt463 * arg2 % local28 << 16) / arg2;
					}
					if (this.anInt464 * arg0 % local31 != 0) {
						local13 = (local31 - this.anInt464 * arg0 % local31 << 16) / arg0;
					}
					arg2 = arg2 * (this.anInt461 - (local11 >> 16)) / local28;
					arg0 = arg0 * (this.anInt462 - (local13 >> 16)) / local31;
					@Pc(137) int local137 = arg4 + arg1 * Static12.anInt528;
					@Pc(141) int local141 = Static12.anInt528 - arg2;
					@Pc(148) int local148;
					if (arg1 < Static12.anInt530) {
						local148 = Static12.anInt530 - arg1;
						arg0 -= local148;
						arg1 = 0;
						local137 += local148 * Static12.anInt528;
						local13 += local43 * local148;
					}
					if (arg1 + arg0 > Static12.anInt531) {
						arg0 -= arg1 + arg0 - Static12.anInt531;
					}
					if (arg4 < Static12.anInt532) {
						local148 = Static12.anInt532 - arg4;
						arg2 -= local148;
						arg4 = 0;
						local137 += local148;
						local11 += local37 * local148;
						local141 += local148;
					}
					if (arg4 + arg2 > Static12.anInt533) {
						local148 = arg4 + arg2 - Static12.anInt533;
						arg2 -= local148;
						local141 += local148;
					}
					this.method325(local11, local37, Static12.anIntArray178, 0, local43, local13, 0, this.anIntArray148, local141, local137, arg0, local6, arg2);
				} catch (@Pc(243) Exception local243) {
					System.out.println("error in sprite clipping routine");
				}
			}
		} catch (@Pc(248) RuntimeException local248) {
			signlink.reporterror("90121, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local248.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(II[IIIII[IIIIII)V")
	private void method325(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int[] arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11, @OriginalArg(12) int arg12) {
		try {
			@Pc(5) int local5;
			if (arg6 != 0) {
				for (local5 = 1; local5 > 0; local5++) {
				}
			}
			try {
				local5 = arg0;
				for (@Pc(15) int local15 = -arg10; local15 < 0; local15++) {
					@Pc(23) int local23 = (arg5 >> 16) * arg11;
					for (@Pc(26) int local26 = -arg12; local26 < 0; local26++) {
						@Pc(36) int local36 = arg7[(arg0 >> 16) + local23];
						if (local36 == 0) {
							arg9++;
						} else {
							arg2[arg9++] = local36;
						}
						arg0 += arg1;
					}
					arg5 += arg4;
					arg0 = local5;
					arg9 += arg8;
				}
			} catch (@Pc(68) Exception local68) {
				System.out.println("error in plot_scale");
			}
		} catch (@Pc(73) RuntimeException local73) {
			signlink.reporterror("94187, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + arg12 + ", " + local73.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIIB)V")
	public void method326(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte arg3) {
		try {
			@Pc(4) int local4;
			if (arg3 != -26) {
				for (local4 = 1; local4 > 0; local4++) {
				}
			}
			arg1 += this.anInt463;
			arg2 += this.anInt464;
			local4 = arg1 + arg2 * Static12.anInt528;
			@Pc(27) int local27 = 0;
			@Pc(30) int local30 = this.anInt462;
			@Pc(33) int local33 = this.anInt461;
			@Pc(37) int local37 = Static12.anInt528 - local33;
			@Pc(39) int local39 = 0;
			@Pc(46) int local46;
			if (arg2 < Static12.anInt530) {
				local46 = Static12.anInt530 - arg2;
				local30 -= local46;
				arg2 = Static12.anInt530;
				local27 += local46 * local33;
				local4 += local46 * Static12.anInt528;
			}
			if (arg2 + local30 > Static12.anInt531) {
				local30 -= arg2 + local30 - Static12.anInt531;
			}
			if (arg1 < Static12.anInt532) {
				local46 = Static12.anInt532 - arg1;
				local33 -= local46;
				arg1 = Static12.anInt532;
				local27 += local46;
				local4 += local46;
				local39 += local46;
				local37 += local46;
			}
			if (arg1 + local33 > Static12.anInt533) {
				local46 = arg1 + local33 - Static12.anInt533;
				local33 -= local46;
				local39 += local46;
				local37 += local46;
			}
			if (local33 > 0 && local30 > 0) {
				this.method327(local4, 0, this.anIntArray148, arg0, local30, Static12.anIntArray178, local27, (byte) 8, local33, local37, local39);
			}
		} catch (@Pc(150) RuntimeException local150) {
			signlink.reporterror("1642, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local150.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(II[III[IIBIII)V")
	private void method327(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int[] arg5, @OriginalArg(6) int arg6, @OriginalArg(7) byte arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10) {
		try {
			@Pc(5) int local5 = 256 - arg3;
			if (arg7 != 8) {
				this.aBoolean103 = !this.aBoolean103;
			}
			for (@Pc(19) int local19 = -arg4; local19 < 0; local19++) {
				for (@Pc(24) int local24 = -arg8; local24 < 0; local24++) {
					@Pc(31) int local31 = arg2[arg6++];
					if (local31 == 0) {
						arg0++;
					} else {
						@Pc(37) int local37 = arg5[arg0];
						arg5[arg0++] = ((local31 & 0xFF00FF) * arg3 + (local37 & 0xFF00FF) * local5 & 0xFF00FF00) + ((local31 & 0xFF00) * arg3 + (local37 & 0xFF00) * local5 & 0xFF0000) >> 8;
					}
				}
				arg0 += arg9;
				arg6 += arg10;
			}
		} catch (@Pc(89) RuntimeException local89) {
			signlink.reporterror("62265, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + local89.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(II[IIIIIIIZ[I)V")
	public void method328(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) boolean arg9, @OriginalArg(10) int[] arg10) {
		try {
			if (arg9) {
				this.aBoolean104 = !this.aBoolean104;
			}
			try {
				@Pc(16) int local16 = -arg1 / 2;
				@Pc(21) int local21 = -arg3 / 2;
				@Pc(30) int local30 = (int) (Math.sin((double) arg0 / 326.11D) * 65536.0D);
				@Pc(39) int local39 = (int) (Math.cos((double) arg0 / 326.11D) * 65536.0D);
				@Pc(45) int local45 = local30 * arg5 >> 8;
				@Pc(51) int local51 = local39 * arg5 >> 8;
				@Pc(63) int local63 = (arg6 << 16) + local21 * local45 + local16 * local51;
				@Pc(75) int local75 = (arg4 << 16) + (local21 * local51 - local16 * local45);
				@Pc(81) int local81 = arg7 + arg8 * Static12.anInt528;
				for (@Pc(83) int local83 = 0; local83 < arg3; local83++) {
					@Pc(89) int local89 = arg2[local83];
					@Pc(93) int local93 = local81 + local89;
					@Pc(99) int local99 = local63 + local51 * local89;
					@Pc(105) int local105 = local75 - local45 * local89;
					for (@Pc(110) int local110 = -arg10[local83]; local110 < 0; local110++) {
						Static12.anIntArray178[local93++] = this.anIntArray148[(local99 >> 16) + (local105 >> 16) * this.anInt461];
						local99 += local51;
						local105 -= local45;
					}
					local63 += local45;
					local75 += local51;
					local81 += Static12.anInt528;
				}
			} catch (@Pc(158) Exception local158) {
			}
		} catch (@Pc(160) RuntimeException local160) {
			signlink.reporterror("53177, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + local160.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(Lclient!ib;IIB)V")
	public void method329(@OriginalArg(0) Class1_Sub3_Sub2_Sub3 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte arg3) {
		try {
			arg2 += this.anInt463;
			arg1 += this.anInt464;
			@Pc(15) int local15 = arg2 + arg1 * Static12.anInt528;
			@Pc(17) int local17 = 0;
			if (arg3 == -15) {
				@Pc(24) int local24 = this.anInt462;
				@Pc(27) int local27 = this.anInt461;
				@Pc(31) int local31 = Static12.anInt528 - local27;
				@Pc(33) int local33 = 0;
				@Pc(40) int local40;
				if (arg1 < Static12.anInt530) {
					local40 = Static12.anInt530 - arg1;
					local24 -= local40;
					arg1 = Static12.anInt530;
					local17 += local40 * local27;
					local15 += local40 * Static12.anInt528;
				}
				if (arg1 + local24 > Static12.anInt531) {
					local24 -= arg1 + local24 - Static12.anInt531;
				}
				if (arg2 < Static12.anInt532) {
					local40 = Static12.anInt532 - arg2;
					local27 -= local40;
					arg2 = Static12.anInt532;
					local17 += local40;
					local15 += local40;
					local33 += local40;
					local31 += local40;
				}
				if (arg2 + local27 > Static12.anInt533) {
					local40 = arg2 + local27 - Static12.anInt533;
					local27 -= local40;
					local33 += local40;
					local31 += local40;
				}
				if (local27 > 0 && local24 > 0) {
					this.method330(local27, local33, 0, -478, local24, local17, Static12.anIntArray178, this.anIntArray148, local15, arg0.aByteArray6, local31);
				}
			}
		} catch (@Pc(145) RuntimeException local145) {
			signlink.reporterror("13593, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local145.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hb", name = "a", descriptor = "(IIIIII[I[II[BI)V")
	private void method330(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int[] arg6, @OriginalArg(7) int[] arg7, @OriginalArg(8) int arg8, @OriginalArg(9) byte[] arg9, @OriginalArg(10) int arg10) {
		try {
			if (arg3 < 0) {
				@Pc(9) int local9 = -(arg0 >> 2);
				@Pc(14) int local14 = -(arg0 & 0x3);
				for (@Pc(17) int local17 = -arg4; local17 < 0; local17++) {
					@Pc(28) int local28;
					for (@Pc(21) int local21 = local9; local21 < 0; local21++) {
						local28 = arg7[arg5++];
						if (local28 != 0 && arg9[arg8] == 0) {
							arg6[arg8++] = local28;
						} else {
							arg8++;
						}
						local28 = arg7[arg5++];
						if (local28 != 0 && arg9[arg8] == 0) {
							arg6[arg8++] = local28;
						} else {
							arg8++;
						}
						local28 = arg7[arg5++];
						if (local28 != 0 && arg9[arg8] == 0) {
							arg6[arg8++] = local28;
						} else {
							arg8++;
						}
						local28 = arg7[arg5++];
						if (local28 != 0 && arg9[arg8] == 0) {
							arg6[arg8++] = local28;
						} else {
							arg8++;
						}
					}
					for (@Pc(104) int local104 = local14; local104 < 0; local104++) {
						local28 = arg7[arg5++];
						if (local28 != 0 && arg9[arg8] == 0) {
							arg6[arg8++] = local28;
						} else {
							arg8++;
						}
					}
					arg8 += arg10;
					arg5 += arg1;
				}
			}
		} catch (@Pc(141) RuntimeException local141) {
			signlink.reporterror("76267, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + local141.toString());
			throw new RuntimeException();
		}
	}
}
