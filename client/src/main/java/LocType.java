import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!ac")
public final class LocType {

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "I")
	public static int flowObfuscator1;

	@OriginalMember(owner = "client!ac", name = "b", descriptor = "I")
	public static int flowObfuscator2;

	@OriginalMember(owner = "client!ac", name = "c", descriptor = "Z")
	public static boolean aBoolean6;

	@OriginalMember(owner = "client!ac", name = "d", descriptor = "I")
	private static int anInt40;

	@OriginalMember(owner = "client!ac", name = "e", descriptor = "[I")
	private static int[] anIntArray3;

	@OriginalMember(owner = "client!ac", name = "f", descriptor = "Lclient!kb;")
	private static Buffer aClass1_Sub3_Sub3_1;

	@OriginalMember(owner = "client!ac", name = "g", descriptor = "[Lclient!ac;")
	private static LocType[] aClass2Array1;

	@OriginalMember(owner = "client!ac", name = "h", descriptor = "I")
	private static int anInt41;

	@OriginalMember(owner = "client!ac", name = "i", descriptor = "I")
	public int anInt42 = -1;

	@OriginalMember(owner = "client!ac", name = "j", descriptor = "[I")
	private int[] anIntArray4;

	@OriginalMember(owner = "client!ac", name = "k", descriptor = "[I")
	private int[] anIntArray5;

	@OriginalMember(owner = "client!ac", name = "l", descriptor = "Ljava/lang/String;")
	public String name;

	@OriginalMember(owner = "client!ac", name = "m", descriptor = "[B")
	public byte[] aByteArray1;

	@OriginalMember(owner = "client!ac", name = "n", descriptor = "[I")
	private int[] anIntArray6;

	@OriginalMember(owner = "client!ac", name = "o", descriptor = "[I")
	private int[] anIntArray7;

	@OriginalMember(owner = "client!ac", name = "p", descriptor = "I")
	public int sizeX;

	@OriginalMember(owner = "client!ac", name = "q", descriptor = "I")
	public int sizeZ;

	@OriginalMember(owner = "client!ac", name = "r", descriptor = "Z")
	public boolean aBoolean7;

	@OriginalMember(owner = "client!ac", name = "s", descriptor = "Z")
	public boolean aBoolean8;

	@OriginalMember(owner = "client!ac", name = "t", descriptor = "Z")
	public boolean aBoolean9;

	@OriginalMember(owner = "client!ac", name = "u", descriptor = "Z")
	private boolean aBoolean10;

	@OriginalMember(owner = "client!ac", name = "v", descriptor = "Z")
	private boolean aBoolean11;

	@OriginalMember(owner = "client!ac", name = "w", descriptor = "Z")
	public boolean aBoolean12;

	@OriginalMember(owner = "client!ac", name = "x", descriptor = "I")
	public int anInt45;

	@OriginalMember(owner = "client!ac", name = "y", descriptor = "I")
	public int anInt46;

	@OriginalMember(owner = "client!ac", name = "z", descriptor = "B")
	private byte aByte2;

	@OriginalMember(owner = "client!ac", name = "A", descriptor = "B")
	private byte aByte3;

	@OriginalMember(owner = "client!ac", name = "B", descriptor = "[Ljava/lang/String;")
	public String[] aStringArray1;

	@OriginalMember(owner = "client!ac", name = "C", descriptor = "Z")
	private boolean aBoolean13;

	@OriginalMember(owner = "client!ac", name = "D", descriptor = "I")
	public int anInt47;

	@OriginalMember(owner = "client!ac", name = "E", descriptor = "I")
	public int anInt48;

	@OriginalMember(owner = "client!ac", name = "F", descriptor = "Z")
	private boolean aBoolean14;

	@OriginalMember(owner = "client!ac", name = "G", descriptor = "Z")
	public boolean aBoolean15;

	@OriginalMember(owner = "client!ac", name = "H", descriptor = "I")
	private int anInt49;

	@OriginalMember(owner = "client!ac", name = "I", descriptor = "I")
	private int anInt50;

	@OriginalMember(owner = "client!ac", name = "J", descriptor = "I")
	private int anInt51;

	@OriginalMember(owner = "client!ac", name = "K", descriptor = "I")
	private int anInt52;

	@OriginalMember(owner = "client!ac", name = "L", descriptor = "I")
	private int anInt53;

	@OriginalMember(owner = "client!ac", name = "M", descriptor = "I")
	private int anInt54;

	@OriginalMember(owner = "client!ac", name = "N", descriptor = "I")
	public int interactionSideFlags;

	@OriginalMember(owner = "client!ac", name = "O", descriptor = "Z")
	public boolean aBoolean16;

	@OriginalMember(owner = "client!ac", name = "P", descriptor = "Lclient!s;")
	public static Cache aClass35_1 = new Cache((byte) 0, 500);

	@OriginalMember(owner = "client!ac", name = "Q", descriptor = "Lclient!s;")
	public static Cache aClass35_2 = new Cache((byte) 0, 30);

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(Lclient!ub;)V")
	public static void method21(@OriginalArg(0) FileArchive arg0) {
		aClass1_Sub3_Sub3_1 = new Buffer(363, arg0.method536("loc.dat", null, (byte) 2));
		@Pc(21) Buffer local21 = new Buffer(363, arg0.method536("loc.idx", null, (byte) 2));
		anInt40 = local21.method393();
		anIntArray3 = new int[anInt40];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < anInt40; local31++) {
			anIntArray3[local31] = local29;
			local29 += local21.method393();
		}
		aClass2Array1 = new LocType[10];
		for (@Pc(51) int local51 = 0; local51 < 10; local51++) {
			aClass2Array1[local51] = new LocType();
		}
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(Z)V")
	public static void method22(@OriginalArg(0) boolean arg0) {
		try {
			aClass35_1 = null;
			aClass35_2 = null;
			if (arg0) {
				anIntArray3 = null;
				aClass2Array1 = null;
				aClass1_Sub3_Sub3_1 = null;
			}
		} catch (@Pc(14) RuntimeException local14) {
			signlink.reporterror("1378, " + arg0 + ", " + local14.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(I)Lclient!ac;")
	public static LocType method23(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 10; local1++) {
			if (aClass2Array1[local1].anInt42 == arg0) {
				return aClass2Array1[local1];
			}
		}
		anInt41 = (anInt41 + 1) % 10;
		@Pc(27) LocType local27 = aClass2Array1[anInt41];
		aClass1_Sub3_Sub3_1.position = anIntArray3[arg0];
		local27.anInt42 = arg0;
		local27.method24();
		local27.method25(false, aClass1_Sub3_Sub3_1);
		return local27;
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "()V")
	public void method24() {
		this.anIntArray4 = null;
		this.anIntArray5 = null;
		this.name = null;
		this.aByteArray1 = null;
		this.anIntArray6 = null;
		this.anIntArray7 = null;
		this.sizeX = 1;
		this.sizeZ = 1;
		this.aBoolean7 = true;
		this.aBoolean8 = true;
		this.aBoolean9 = false;
		this.aBoolean10 = false;
		this.aBoolean11 = false;
		this.aBoolean12 = false;
		this.anInt45 = -1;
		this.anInt46 = 16;
		this.aByte2 = 0;
		this.aByte3 = 0;
		this.aStringArray1 = null;
		this.aBoolean13 = false;
		this.anInt47 = -1;
		this.anInt48 = -1;
		this.aBoolean14 = false;
		this.aBoolean15 = true;
		this.anInt49 = 128;
		this.anInt50 = 128;
		this.anInt51 = 128;
		this.interactionSideFlags = 0;
		this.anInt52 = 0;
		this.anInt53 = 0;
		this.anInt54 = 0;
		this.aBoolean16 = false;
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method25(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			@Pc(5) int local5;
			if (arg0) {
				for (local5 = 1; local5 > 0; local5++) {
				}
			}
			local5 = -1;
			while (true) {
				while (true) {
					@Pc(15) int local15 = arg1.method391();
					if (local15 == 0) {
						if (this.anIntArray5 == null) {
							this.anIntArray5 = new int[0];
						}
						if (local5 == -1) {
							this.aBoolean9 = false;
							if (this.anIntArray5.length > 0 && this.anIntArray5[0] == 10) {
								this.aBoolean9 = true;
							}
							if (this.aStringArray1 != null) {
								this.aBoolean9 = true;
								return;
							}
						}
						return;
					}
					@Pc(23) int local23;
					@Pc(33) int local33;
					if (local15 == 1) {
						local23 = arg1.method391();
						this.anIntArray5 = new int[local23];
						this.anIntArray4 = new int[local23];
						for (local33 = 0; local33 < local23; local33++) {
							this.anIntArray4[local33] = arg1.method393();
							this.anIntArray5[local33] = arg1.method391();
						}
					} else if (local15 == 2) {
						this.name = arg1.method398();
					} else if (local15 == 3) {
						this.aByteArray1 = arg1.method399((byte) 31);
					} else if (local15 == 14) {
						this.sizeX = arg1.method391();
					} else if (local15 == 15) {
						this.sizeZ = arg1.method391();
					} else if (local15 == 17) {
						this.aBoolean7 = false;
					} else if (local15 == 18) {
						this.aBoolean8 = false;
					} else if (local15 == 19) {
						local5 = arg1.method391();
						if (local5 == 1) {
							this.aBoolean9 = true;
						}
					} else if (local15 == 21) {
						this.aBoolean10 = true;
					} else if (local15 == 22) {
						this.aBoolean11 = true;
					} else if (local15 == 23) {
						this.aBoolean12 = true;
					} else if (local15 == 24) {
						this.anInt45 = arg1.method393();
						if (this.anInt45 == 65535) {
							this.anInt45 = -1;
						}
					} else if (local15 == 25) {
						this.aBoolean13 = true;
					} else if (local15 == 28) {
						this.anInt46 = arg1.method391();
					} else if (local15 == 29) {
						this.aByte2 = arg1.method392();
					} else if (local15 == 39) {
						this.aByte3 = arg1.method392();
					} else if (local15 >= 30 && local15 < 39) {
						if (this.aStringArray1 == null) {
							this.aStringArray1 = new String[5];
						}
						this.aStringArray1[local15 - 30] = arg1.method398();
						if (this.aStringArray1[local15 - 30].equalsIgnoreCase("hidden")) {
							this.aStringArray1[local15 - 30] = null;
						}
					} else if (local15 == 40) {
						local23 = arg1.method391();
						this.anIntArray6 = new int[local23];
						this.anIntArray7 = new int[local23];
						for (local33 = 0; local33 < local23; local33++) {
							this.anIntArray6[local33] = arg1.method393();
							this.anIntArray7[local33] = arg1.method393();
						}
					} else if (local15 == 60) {
						this.anInt47 = arg1.method393();
					} else if (local15 == 62) {
						this.aBoolean14 = true;
					} else if (local15 == 64) {
						this.aBoolean15 = false;
					} else if (local15 == 65) {
						this.anInt49 = arg1.method393();
					} else if (local15 == 66) {
						this.anInt50 = arg1.method393();
					} else if (local15 == 67) {
						this.anInt51 = arg1.method393();
					} else if (local15 == 68) {
						this.anInt48 = arg1.method393();
					} else if (local15 == 69) {
						this.interactionSideFlags = arg1.method391();
					} else if (local15 == 70) {
						this.anInt52 = arg1.method394();
					} else if (local15 == 71) {
						this.anInt53 = arg1.method394();
					} else if (local15 == 72) {
						this.anInt54 = arg1.method394();
					} else if (local15 == 73) {
						this.aBoolean16 = true;
					}
				}
			}
		} catch (@Pc(409) RuntimeException local409) {
			signlink.reporterror("20782, " + arg0 + ", " + arg1 + ", " + local409.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ac", name = "a", descriptor = "(IIIIIII)Lclient!eb;")
	public Model method26(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		@Pc(3) int local3 = -1;
		for (@Pc(5) int local5 = 0; local5 < this.anIntArray5.length; local5++) {
			if (this.anIntArray5[local5] == arg0) {
				local3 = local5;
				break;
			}
		}
		if (local3 == -1) {
			return null;
		}
		@Pc(47) long local47 = (long) ((this.anInt42 << 6) + (local3 << 3) + arg1) + ((long) (arg6 + 1) << 32);
		if (aBoolean6) {
			local47 = 0L;
		}
		@Pc(56) Model local56 = (Model) aClass35_2.get(local47);
		@Pc(91) int local91;
		@Pc(141) int local141;
		if (local56 == null) {
			if (local3 >= this.anIntArray4.length) {
				return null;
			}
			local91 = this.anIntArray4[local3];
			if (local91 == -1) {
				return null;
			}
			@Pc(188) boolean local188 = this.aBoolean14 ^ arg1 > 3;
			if (local188) {
				local91 += 65536;
			}
			@Pc(200) Model local200 = (Model) aClass35_1.get((long) local91);
			if (local200 == null) {
				local200 = new Model(false, local91 & 0xFFFF);
				if (local188) {
					local200.method238(-725);
				}
				aClass35_1.put(6, (long) local91, local200);
			}
			@Pc(235) boolean local235;
			if (this.anInt49 == 128 && this.anInt50 == 128 && this.anInt51 == 128) {
				local235 = false;
			} else {
				local235 = true;
			}
			@Pc(250) boolean local250;
			if (this.anInt52 == 0 && this.anInt53 == 0 && this.anInt54 == 0) {
				local250 = false;
			} else {
				local250 = true;
			}
			@Pc(284) Model local284 = new Model(local200, this.anIntArray6 == null, !this.aBoolean13, flowObfuscator1, arg1 == 0 && arg6 == -1 && !local235 && !local250);
			if (arg6 != -1) {
				local284.createLabelReferences(4);
				local284.applyTransform(-16599, arg6);
				local284.labelFaces = null;
				local284.labelVertices = null;
			}
			while (arg1-- > 0) {
				local284.rotateY90(0);
			}
			if (this.anIntArray6 != null) {
				for (local141 = 0; local141 < this.anIntArray6.length; local141++) {
					local284.recolor(this.anIntArray6[local141], this.anIntArray7[local141]);
				}
			}
			if (local235) {
				local284.scale(this.anInt51, 2, this.anInt50, this.anInt49);
			}
			if (local250) {
				local284.translate(this.anInt53, this.anInt52, -122, this.anInt54);
			}
			local284.calculateNormals(this.aByte2 + 64, this.aByte3 * 5 + 768, -50, -10, -50, !this.aBoolean11);
			if (this.aBoolean7) {
				local284.anInt372 = local284.minY;
			}
			aClass35_2.put(6, local47, local284);
			if (this.aBoolean10 || this.aBoolean11) {
				local284 = new Model(local284, (byte) -31, this.aBoolean10, this.aBoolean11);
			}
			if (this.aBoolean10) {
				local141 = (arg2 + arg3 + arg4 + arg5) / 4;
				for (@Pc(417) int local417 = 0; local417 < local284.anInt359; local417++) {
					@Pc(424) int local424 = local284.anIntArray91[local417];
					@Pc(429) int local429 = local284.anIntArray93[local417];
					@Pc(441) int local441 = arg2 + (arg3 - arg2) * (local424 + 64) / 128;
					@Pc(453) int local453 = arg5 + (arg4 - arg5) * (local424 + 64) / 128;
					@Pc(465) int local465 = local441 + (local453 - local441) * (local429 + 64) / 128;
					local284.anIntArray92[local417] += local465 - local141;
				}
				local284.method228(flowObfuscator2);
			}
			return local284;
		} else if (aBoolean6) {
			return local56;
		} else {
			if (this.aBoolean10 || this.aBoolean11) {
				local56 = new Model(local56, (byte) -31, this.aBoolean10, this.aBoolean11);
			}
			if (this.aBoolean10) {
				local91 = (arg2 + arg3 + arg4 + arg5) / 4;
				for (@Pc(93) int local93 = 0; local93 < local56.anInt359; local93++) {
					@Pc(100) int local100 = local56.anIntArray91[local93];
					@Pc(105) int local105 = local56.anIntArray93[local93];
					@Pc(117) int local117 = arg2 + (arg3 - arg2) * (local100 + 64) / 128;
					@Pc(129) int local129 = arg5 + (arg4 - arg5) * (local100 + 64) / 128;
					local141 = local117 + (local129 - local117) * (local105 + 64) / 128;
					local56.anIntArray92[local93] += local141 - local91;
				}
				local56.method228(flowObfuscator2);
			}
			return local56;
		}
	}
}
