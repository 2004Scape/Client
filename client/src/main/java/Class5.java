import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!cc")
public final class Class5 {

	@OriginalMember(owner = "client!cc", name = "l", descriptor = "I")
	private int anInt104;

	@OriginalMember(owner = "client!cc", name = "m", descriptor = "Ljava/lang/String;")
	public String aString3;

	@OriginalMember(owner = "client!cc", name = "n", descriptor = "[B")
	public byte[] aByteArray3;

	@OriginalMember(owner = "client!cc", name = "o", descriptor = "[I")
	private int[] anIntArray24;

	@OriginalMember(owner = "client!cc", name = "p", descriptor = "[I")
	private int[] anIntArray25;

	@OriginalMember(owner = "client!cc", name = "q", descriptor = "I")
	public int anInt105;

	@OriginalMember(owner = "client!cc", name = "r", descriptor = "I")
	public int anInt106;

	@OriginalMember(owner = "client!cc", name = "s", descriptor = "I")
	public int anInt107;

	@OriginalMember(owner = "client!cc", name = "t", descriptor = "I")
	public int anInt108;

	@OriginalMember(owner = "client!cc", name = "u", descriptor = "I")
	public int anInt109;

	@OriginalMember(owner = "client!cc", name = "v", descriptor = "I")
	public int anInt110;

	@OriginalMember(owner = "client!cc", name = "w", descriptor = "Z")
	private boolean aBoolean30;

	@OriginalMember(owner = "client!cc", name = "x", descriptor = "I")
	private int anInt111;

	@OriginalMember(owner = "client!cc", name = "y", descriptor = "Z")
	public boolean aBoolean31;

	@OriginalMember(owner = "client!cc", name = "z", descriptor = "I")
	public int anInt112;

	@OriginalMember(owner = "client!cc", name = "A", descriptor = "Z")
	public boolean aBoolean32;

	@OriginalMember(owner = "client!cc", name = "B", descriptor = "[Ljava/lang/String;")
	public String[] aStringArray3;

	@OriginalMember(owner = "client!cc", name = "C", descriptor = "[Ljava/lang/String;")
	public String[] aStringArray4;

	@OriginalMember(owner = "client!cc", name = "D", descriptor = "I")
	private int anInt113;

	@OriginalMember(owner = "client!cc", name = "E", descriptor = "I")
	private int anInt114;

	@OriginalMember(owner = "client!cc", name = "F", descriptor = "B")
	private byte aByte5;

	@OriginalMember(owner = "client!cc", name = "G", descriptor = "I")
	private int anInt115;

	@OriginalMember(owner = "client!cc", name = "H", descriptor = "I")
	private int anInt116;

	@OriginalMember(owner = "client!cc", name = "I", descriptor = "B")
	private byte aByte6;

	@OriginalMember(owner = "client!cc", name = "J", descriptor = "I")
	private int anInt117;

	@OriginalMember(owner = "client!cc", name = "K", descriptor = "I")
	private int anInt118;

	@OriginalMember(owner = "client!cc", name = "L", descriptor = "I")
	private int anInt119;

	@OriginalMember(owner = "client!cc", name = "M", descriptor = "I")
	private int anInt120;

	@OriginalMember(owner = "client!cc", name = "N", descriptor = "I")
	private int anInt121;

	@OriginalMember(owner = "client!cc", name = "O", descriptor = "I")
	private int anInt122;

	@OriginalMember(owner = "client!cc", name = "P", descriptor = "[I")
	public int[] anIntArray26;

	@OriginalMember(owner = "client!cc", name = "Q", descriptor = "[I")
	public int[] anIntArray27;

	@OriginalMember(owner = "client!cc", name = "R", descriptor = "I")
	public int anInt123;

	@OriginalMember(owner = "client!cc", name = "S", descriptor = "I")
	public int anInt124;

	@OriginalMember(owner = "client!cc", name = "b", descriptor = "Z")
	private boolean aBoolean28 = false;

	@OriginalMember(owner = "client!cc", name = "d", descriptor = "I")
	private final int anInt100 = -22246;

	@OriginalMember(owner = "client!cc", name = "k", descriptor = "I")
	public int anInt103 = -1;

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "()V")
	public void method55() {
		this.anInt104 = 0;
		this.aString3 = null;
		this.aByteArray3 = null;
		this.anIntArray24 = null;
		this.anIntArray25 = null;
		this.anInt105 = 2000;
		this.anInt106 = 0;
		this.anInt107 = 0;
		this.anInt108 = 0;
		this.anInt109 = 0;
		this.anInt110 = 0;
		this.aBoolean30 = false;
		this.anInt111 = -1;
		this.aBoolean31 = false;
		this.anInt112 = 1;
		this.aBoolean32 = false;
		this.aStringArray3 = null;
		this.aStringArray4 = null;
		this.anInt113 = -1;
		this.anInt114 = -1;
		this.aByte5 = 0;
		this.anInt115 = -1;
		this.anInt116 = -1;
		this.aByte6 = 0;
		this.anInt117 = -1;
		this.anInt118 = -1;
		this.anInt119 = -1;
		this.anInt120 = -1;
		this.anInt121 = -1;
		this.anInt122 = -1;
		this.anIntArray26 = null;
		this.anIntArray27 = null;
		this.anInt123 = -1;
		this.anInt124 = -1;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method56(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1) {
		try {
			if (arg0) {
				throw new NullPointerException();
			}
			while (true) {
				while (true) {
					@Pc(10) int local10 = arg1.method391();
					if (local10 == 0) {
						return;
					}
					if (local10 == 1) {
						this.anInt104 = arg1.method393();
					} else if (local10 == 2) {
						this.aString3 = arg1.method398();
					} else if (local10 == 3) {
						this.aByteArray3 = arg1.method399((byte) 31);
					} else if (local10 == 4) {
						this.anInt105 = arg1.method393();
					} else if (local10 == 5) {
						this.anInt106 = arg1.method393();
					} else if (local10 == 6) {
						this.anInt107 = arg1.method393();
					} else if (local10 == 7) {
						this.anInt109 = arg1.method393();
						if (this.anInt109 > 32767) {
							this.anInt109 -= 65536;
						}
					} else if (local10 == 8) {
						this.anInt110 = arg1.method393();
						if (this.anInt110 > 32767) {
							this.anInt110 -= 65536;
						}
					} else if (local10 == 9) {
						this.aBoolean30 = true;
					} else if (local10 == 10) {
						this.anInt111 = arg1.method393();
					} else if (local10 == 11) {
						this.aBoolean31 = true;
					} else if (local10 == 12) {
						this.anInt112 = arg1.method396();
					} else if (local10 == 16) {
						this.aBoolean32 = true;
					} else if (local10 == 23) {
						this.anInt113 = arg1.method393();
						this.aByte5 = arg1.method392();
					} else if (local10 == 24) {
						this.anInt114 = arg1.method393();
					} else if (local10 == 25) {
						this.anInt115 = arg1.method393();
						this.aByte6 = arg1.method392();
					} else if (local10 == 26) {
						this.anInt116 = arg1.method393();
					} else if (local10 >= 30 && local10 < 35) {
						if (this.aStringArray3 == null) {
							this.aStringArray3 = new String[5];
						}
						this.aStringArray3[local10 - 30] = arg1.method398();
						if (this.aStringArray3[local10 - 30].equalsIgnoreCase("hidden")) {
							this.aStringArray3[local10 - 30] = null;
						}
					} else if (local10 >= 35 && local10 < 40) {
						if (this.aStringArray4 == null) {
							this.aStringArray4 = new String[5];
						}
						this.aStringArray4[local10 - 35] = arg1.method398();
					} else if (local10 == 40) {
						@Pc(260) int local260 = arg1.method391();
						this.anIntArray24 = new int[local260];
						this.anIntArray25 = new int[local260];
						for (@Pc(270) int local270 = 0; local270 < local260; local270++) {
							this.anIntArray24[local270] = arg1.method393();
							this.anIntArray25[local270] = arg1.method393();
						}
					} else if (local10 == 78) {
						this.anInt117 = arg1.method393();
					} else if (local10 == 79) {
						this.anInt118 = arg1.method393();
					} else if (local10 == 90) {
						this.anInt119 = arg1.method393();
					} else if (local10 == 91) {
						this.anInt121 = arg1.method393();
					} else if (local10 == 92) {
						this.anInt120 = arg1.method393();
					} else if (local10 == 93) {
						this.anInt122 = arg1.method393();
					} else if (local10 == 95) {
						this.anInt108 = arg1.method393();
					} else if (local10 == 97) {
						this.anInt123 = arg1.method393();
					} else if (local10 == 98) {
						this.anInt124 = arg1.method393();
					} else if (local10 >= 100 && local10 < 110) {
						if (this.anIntArray26 == null) {
							this.anIntArray26 = new int[10];
							this.anIntArray27 = new int[10];
						}
						this.anIntArray26[local10 - 100] = arg1.method393();
						this.anIntArray27[local10 - 100] = arg1.method393();
					}
				}
			}
		} catch (@Pc(406) RuntimeException local406) {
			signlink.reporterror("9273, " + arg0 + ", " + arg1 + ", " + local406.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "b", descriptor = "(I)V")
	public void method57(@OriginalArg(0) int arg0) {
		try {
			@Pc(3) Class5 local3 = Static5.method54(this.anInt124);
			this.anInt104 = local3.anInt104;
			this.anInt105 = local3.anInt105;
			this.anInt106 = local3.anInt106;
			while (arg0 >= 0) {
				this.aBoolean28 = !this.aBoolean28;
			}
			this.anInt107 = local3.anInt107;
			this.anInt108 = local3.anInt108;
			this.anInt109 = local3.anInt109;
			this.anInt110 = local3.anInt110;
			this.anIntArray24 = local3.anIntArray24;
			this.anIntArray25 = local3.anIntArray25;
			@Pc(55) Class5 local55 = Static5.method54(this.anInt123);
			this.aString3 = local55.aString3;
			this.aBoolean32 = local55.aBoolean32;
			this.anInt112 = local55.anInt112;
			@Pc(69) String local69 = "a";
			@Pc(74) char local74 = local55.aString3.charAt(0);
			if (local74 == 'A' || local74 == 'E' || local74 == 'I' || local74 == 'O' || local74 == 'U') {
				local69 = "an";
			}
			this.aByteArray3 = ("Swap this note at any bank for " + local69 + " " + local55.aString3 + ".").getBytes();
			this.aBoolean31 = true;
		} catch (@Pc(113) RuntimeException local113) {
			signlink.reporterror("96838, " + arg0 + ", " + local113.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "c", descriptor = "(I)Lclient!eb;")
	public Class1_Sub3_Sub1 method58(@OriginalArg(0) int arg0) {
		@Pc(11) int local11;
		if (this.anIntArray26 != null && arg0 > 1) {
			@Pc(9) int local9 = -1;
			for (local11 = 0; local11 < 10; local11++) {
				if (arg0 >= this.anIntArray27[local11] && this.anIntArray27[local11] != 0) {
					local9 = this.anIntArray26[local11];
				}
			}
			if (local9 != -1) {
				return Static5.method54(local9).method58(1);
			}
		}
		@Pc(48) Class1_Sub3_Sub1 local48 = (Class1_Sub3_Sub1) Static5.aClass35_4.method527((long) this.anInt103);
		if (local48 != null) {
			return local48;
		}
		local48 = new Class1_Sub3_Sub1(false, this.anInt104);
		if (this.anIntArray24 != null) {
			for (local11 = 0; local11 < this.anIntArray24.length; local11++) {
				local48.method237(this.anIntArray24[local11], this.anIntArray25[local11]);
			}
		}
		local48.method240(64, 768, -50, -10, -50, true);
		local48.aBoolean84 = true;
		Static5.aClass35_4.method528(6, (long) this.anInt103, local48);
		return local48;
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(BI)Lclient!eb;")
	public Class1_Sub3_Sub1 method60(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(4) int local4 = this.anInt113;
			if (arg0 != 6) {
				throw new NullPointerException();
			}
			if (arg1 == 1) {
				local4 = this.anInt115;
			}
			if (local4 == -1) {
				return null;
			}
			@Pc(25) int local25 = this.anInt114;
			@Pc(28) int local28 = this.anInt117;
			if (arg1 == 1) {
				local25 = this.anInt116;
				local28 = this.anInt118;
			}
			@Pc(43) Class1_Sub3_Sub1 local43 = new Class1_Sub3_Sub1(false, local4);
			if (local25 != -1) {
				@Pc(55) Class1_Sub3_Sub1 local55;
				if (local28 == -1) {
					local55 = new Class1_Sub3_Sub1(false, local25);
					@Pc(102) Class1_Sub3_Sub1[] local102 = new Class1_Sub3_Sub1[] { local43, local55 };
					local43 = new Class1_Sub3_Sub1(0, local102, 2);
				} else {
					local55 = new Class1_Sub3_Sub1(false, local25);
					@Pc(61) Class1_Sub3_Sub1 local61 = new Class1_Sub3_Sub1(false, local28);
					@Pc(76) Class1_Sub3_Sub1[] local76 = new Class1_Sub3_Sub1[] { local43, local55, local61 };
					local43 = new Class1_Sub3_Sub1(0, local76, 3);
				}
			}
			if (arg1 == 0 && this.aByte5 != 0) {
				local43.method236(this.aByte5, 0, -122, 0);
			}
			if (arg1 == 1 && this.aByte6 != 0) {
				local43.method236(this.aByte6, 0, -122, 0);
			}
			if (this.anIntArray24 != null) {
				for (@Pc(139) int local139 = 0; local139 < this.anIntArray24.length; local139++) {
					local43.method237(this.anIntArray24[local139], this.anIntArray25[local139]);
				}
			}
			return local43;
		} catch (@Pc(160) RuntimeException local160) {
			signlink.reporterror("95348, " + arg0 + ", " + arg1 + ", " + local160.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!cc", name = "a", descriptor = "(II)Lclient!eb;")
	public Class1_Sub3_Sub1 method61(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(2) int local2 = this.anInt119;
			if (arg0 != this.anInt100) {
				Static5.anInt99 = 205;
			}
			if (arg1 == 1) {
				local2 = this.anInt121;
			}
			if (local2 == -1) {
				return null;
			}
			@Pc(22) int local22 = this.anInt120;
			if (arg1 == 1) {
				local22 = this.anInt122;
			}
			@Pc(34) Class1_Sub3_Sub1 local34 = new Class1_Sub3_Sub1(false, local2);
			if (local22 != -1) {
				@Pc(43) Class1_Sub3_Sub1 local43 = new Class1_Sub3_Sub1(false, local22);
				@Pc(54) Class1_Sub3_Sub1[] local54 = new Class1_Sub3_Sub1[] { local34, local43 };
				local34 = new Class1_Sub3_Sub1(0, local54, 2);
			}
			if (this.anIntArray24 != null) {
				for (@Pc(66) int local66 = 0; local66 < this.anIntArray24.length; local66++) {
					local34.method237(this.anIntArray24[local66], this.anIntArray25[local66]);
				}
			}
			return local34;
		} catch (@Pc(87) RuntimeException local87) {
			signlink.reporterror("22260, " + arg0 + ", " + arg1 + ", " + local87.toString());
			throw new RuntimeException();
		}
	}
}
