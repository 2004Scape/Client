import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!eb")
public final class Class1_Sub3_Sub1 extends Class1_Sub3 {

	@OriginalMember(owner = "client!eb", name = "v", descriptor = "[I")
	private int[] anIntArray97;

	@OriginalMember(owner = "client!eb", name = "w", descriptor = "[I")
	private int[] anIntArray98;

	@OriginalMember(owner = "client!eb", name = "x", descriptor = "[I")
	private int[] anIntArray99;

	@OriginalMember(owner = "client!eb", name = "H", descriptor = "I")
	public int anInt363;

	@OriginalMember(owner = "client!eb", name = "I", descriptor = "I")
	public int anInt364;

	@OriginalMember(owner = "client!eb", name = "J", descriptor = "I")
	public int anInt365;

	@OriginalMember(owner = "client!eb", name = "K", descriptor = "I")
	public int anInt366;

	@OriginalMember(owner = "client!eb", name = "L", descriptor = "I")
	public int anInt367;

	@OriginalMember(owner = "client!eb", name = "M", descriptor = "I")
	public int anInt368;

	@OriginalMember(owner = "client!eb", name = "N", descriptor = "I")
	public int anInt369;

	@OriginalMember(owner = "client!eb", name = "O", descriptor = "I")
	private int anInt370;

	@OriginalMember(owner = "client!eb", name = "P", descriptor = "I")
	private int anInt371;

	@OriginalMember(owner = "client!eb", name = "Q", descriptor = "I")
	public int anInt372;

	@OriginalMember(owner = "client!eb", name = "T", descriptor = "[[I")
	public int[][] anIntArrayArray6;

	@OriginalMember(owner = "client!eb", name = "U", descriptor = "[[I")
	public int[][] anIntArrayArray7;

	@OriginalMember(owner = "client!eb", name = "W", descriptor = "[Lclient!n;")
	public Class26[] aClass26Array1;

	@OriginalMember(owner = "client!eb", name = "X", descriptor = "[Lclient!n;")
	public Class26[] aClass26Array2;

	@OriginalMember(owner = "client!eb", name = "i", descriptor = "I")
	private int anInt357 = 45861;

	@OriginalMember(owner = "client!eb", name = "j", descriptor = "B")
	private final byte aByte19 = 47;

	@OriginalMember(owner = "client!eb", name = "k", descriptor = "B")
	private final byte aByte20 = 47;

	@OriginalMember(owner = "client!eb", name = "l", descriptor = "I")
	private int anInt358 = 5;

	@OriginalMember(owner = "client!eb", name = "m", descriptor = "Z")
	private boolean aBoolean83 = false;

	@OriginalMember(owner = "client!eb", name = "V", descriptor = "Z")
	public boolean aBoolean84 = false;

	@OriginalMember(owner = "client!eb", name = "n", descriptor = "I")
	public int anInt359;

	@OriginalMember(owner = "client!eb", name = "r", descriptor = "I")
	public int anInt360;

	@OriginalMember(owner = "client!eb", name = "D", descriptor = "I")
	private int anInt362;

	@OriginalMember(owner = "client!eb", name = "o", descriptor = "[I")
	public int[] anIntArray91;

	@OriginalMember(owner = "client!eb", name = "p", descriptor = "[I")
	public int[] anIntArray92;

	@OriginalMember(owner = "client!eb", name = "q", descriptor = "[I")
	public int[] anIntArray93;

	@OriginalMember(owner = "client!eb", name = "s", descriptor = "[I")
	public int[] anIntArray94;

	@OriginalMember(owner = "client!eb", name = "t", descriptor = "[I")
	public int[] anIntArray95;

	@OriginalMember(owner = "client!eb", name = "u", descriptor = "[I")
	public int[] anIntArray96;

	@OriginalMember(owner = "client!eb", name = "E", descriptor = "[I")
	private int[] anIntArray104;

	@OriginalMember(owner = "client!eb", name = "F", descriptor = "[I")
	private int[] anIntArray105;

	@OriginalMember(owner = "client!eb", name = "G", descriptor = "[I")
	private int[] anIntArray106;

	@OriginalMember(owner = "client!eb", name = "R", descriptor = "[I")
	private int[] anIntArray107;

	@OriginalMember(owner = "client!eb", name = "y", descriptor = "[I")
	public int[] anIntArray100;

	@OriginalMember(owner = "client!eb", name = "z", descriptor = "[I")
	private int[] anIntArray101;

	@OriginalMember(owner = "client!eb", name = "C", descriptor = "I")
	private int anInt361;

	@OriginalMember(owner = "client!eb", name = "A", descriptor = "[I")
	private int[] anIntArray102;

	@OriginalMember(owner = "client!eb", name = "S", descriptor = "[I")
	private int[] anIntArray108;

	@OriginalMember(owner = "client!eb", name = "B", descriptor = "[I")
	public int[] anIntArray103;

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(ZI)V")
	public Class1_Sub3_Sub1(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
		try {
			if (Static10.aClass22Array1 != null) {
				@Pc(28) Class22 local28 = Static10.aClass22Array1[arg1];
				if (local28 == null) {
					System.out.println("Error model:" + arg1 + " not found!");
				} else {
					this.anInt359 = local28.anInt576;
					this.anInt360 = local28.anInt577;
					this.anInt362 = local28.anInt578;
					this.anIntArray91 = new int[this.anInt359];
					this.anIntArray92 = new int[this.anInt359];
					this.anIntArray93 = new int[this.anInt359];
					this.anIntArray94 = new int[this.anInt360];
					this.anIntArray95 = new int[this.anInt360];
					this.anIntArray96 = new int[this.anInt360];
					this.anIntArray104 = new int[this.anInt362];
					this.anIntArray105 = new int[this.anInt362];
					this.anIntArray106 = new int[this.anInt362];
					if (local28.anInt583 >= 0) {
						this.anIntArray107 = new int[this.anInt359];
					}
					if (local28.anInt587 >= 0) {
						this.anIntArray100 = new int[this.anInt360];
					}
					if (local28.anInt588 >= 0) {
						this.anIntArray101 = new int[this.anInt360];
					} else {
						this.anInt361 = -local28.anInt588 - 1;
					}
					if (local28.anInt589 >= 0) {
						this.anIntArray102 = new int[this.anInt360];
					}
					if (local28.anInt590 >= 0) {
						this.anIntArray108 = new int[this.anInt360];
					}
					this.anIntArray103 = new int[this.anInt360];
					Static10.aClass1_Sub3_Sub3_15.anInt561 = local28.anInt579;
					Static10.aClass1_Sub3_Sub3_16.anInt561 = local28.anInt580;
					Static10.aClass1_Sub3_Sub3_17.anInt561 = local28.anInt581;
					Static10.aClass1_Sub3_Sub3_18.anInt561 = local28.anInt582;
					Static10.aClass1_Sub3_Sub3_19.anInt561 = local28.anInt583;
					@Pc(175) int local175 = 0;
					@Pc(177) int local177 = 0;
					@Pc(179) int local179 = 0;
					@Pc(186) int local186;
					@Pc(188) int local188;
					@Pc(197) int local197;
					@Pc(206) int local206;
					for (@Pc(181) int local181 = 0; local181 < this.anInt359; local181++) {
						local186 = Static10.aClass1_Sub3_Sub3_15.method391();
						local188 = 0;
						if ((local186 & 0x1) != 0) {
							local188 = Static10.aClass1_Sub3_Sub3_16.method404();
						}
						local197 = 0;
						if ((local186 & 0x2) != 0) {
							local197 = Static10.aClass1_Sub3_Sub3_17.method404();
						}
						local206 = 0;
						if ((local186 & 0x4) != 0) {
							local206 = Static10.aClass1_Sub3_Sub3_18.method404();
						}
						this.anIntArray91[local181] = local175 + local188;
						this.anIntArray92[local181] = local177 + local197;
						this.anIntArray93[local181] = local179 + local206;
						local175 = this.anIntArray91[local181];
						local177 = this.anIntArray92[local181];
						local179 = this.anIntArray93[local181];
						if (this.anIntArray107 != null) {
							this.anIntArray107[local181] = Static10.aClass1_Sub3_Sub3_19.method391();
						}
					}
					Static10.aClass1_Sub3_Sub3_10.anInt561 = local28.anInt586;
					Static10.aClass1_Sub3_Sub3_11.anInt561 = local28.anInt587;
					Static10.aClass1_Sub3_Sub3_12.anInt561 = local28.anInt588;
					Static10.aClass1_Sub3_Sub3_13.anInt561 = local28.anInt589;
					Static10.aClass1_Sub3_Sub3_14.anInt561 = local28.anInt590;
					for (local186 = 0; local186 < this.anInt360; local186++) {
						this.anIntArray103[local186] = Static10.aClass1_Sub3_Sub3_10.method393();
						if (this.anIntArray100 != null) {
							this.anIntArray100[local186] = Static10.aClass1_Sub3_Sub3_11.method391();
						}
						if (this.anIntArray101 != null) {
							this.anIntArray101[local186] = Static10.aClass1_Sub3_Sub3_12.method391();
						}
						if (this.anIntArray102 != null) {
							this.anIntArray102[local186] = Static10.aClass1_Sub3_Sub3_13.method391();
						}
						if (this.anIntArray108 != null) {
							this.anIntArray108[local186] = Static10.aClass1_Sub3_Sub3_14.method391();
						}
					}
					Static10.aClass1_Sub3_Sub3_20.anInt561 = local28.anInt584;
					Static10.aClass1_Sub3_Sub3_21.anInt561 = local28.anInt585;
					local188 = 0;
					local197 = 0;
					local206 = 0;
					@Pc(350) int local350 = 0;
					@Pc(357) int local357;
					for (@Pc(352) int local352 = 0; local352 < this.anInt360; local352++) {
						local357 = Static10.aClass1_Sub3_Sub3_21.method391();
						if (local357 == 1) {
							local188 = Static10.aClass1_Sub3_Sub3_20.method404() + local350;
							local197 = Static10.aClass1_Sub3_Sub3_20.method404() + local188;
							local206 = Static10.aClass1_Sub3_Sub3_20.method404() + local197;
							local350 = local206;
							this.anIntArray94[local352] = local188;
							this.anIntArray95[local352] = local197;
							this.anIntArray96[local352] = local206;
						}
						if (local357 == 2) {
							local188 = local188;
							local197 = local206;
							local206 = Static10.aClass1_Sub3_Sub3_20.method404() + local350;
							local350 = local206;
							this.anIntArray94[local352] = local188;
							this.anIntArray95[local352] = local197;
							this.anIntArray96[local352] = local206;
						}
						if (local357 == 3) {
							local188 = local206;
							local197 = local197;
							local206 = Static10.aClass1_Sub3_Sub3_20.method404() + local350;
							local350 = local206;
							this.anIntArray94[local352] = local188;
							this.anIntArray95[local352] = local197;
							this.anIntArray96[local352] = local206;
						}
						if (local357 == 4) {
							@Pc(459) int local459 = local188;
							local188 = local197;
							local197 = local459;
							local206 = Static10.aClass1_Sub3_Sub3_20.method404() + local350;
							local350 = local206;
							this.anIntArray94[local352] = local188;
							this.anIntArray95[local352] = local459;
							this.anIntArray96[local352] = local206;
						}
					}
					if (arg0) {
						throw new NullPointerException();
					}
					Static10.aClass1_Sub3_Sub3_22.anInt561 = local28.anInt591 * 6;
					for (local357 = 0; local357 < this.anInt362; local357++) {
						this.anIntArray104[local357] = Static10.aClass1_Sub3_Sub3_22.method393();
						this.anIntArray105[local357] = Static10.aClass1_Sub3_Sub3_22.method393();
						this.anIntArray106[local357] = Static10.aClass1_Sub3_Sub3_22.method393();
					}
				}
			}
		} catch (@Pc(531) RuntimeException local531) {
			signlink.reporterror("23365, " + arg0 + ", " + arg1 + ", " + local531.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(I[Lclient!eb;I)V")
	public Class1_Sub3_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub1[] arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(23) boolean local23 = false;
			@Pc(25) boolean local25 = false;
			@Pc(27) boolean local27 = false;
			@Pc(29) boolean local29 = false;
			this.anInt359 = 0;
			this.anInt360 = 0;
			this.anInt362 = 0;
			this.anInt361 = -1;
			for (@Pc(43) int local43 = 0; local43 < arg2; local43++) {
				@Pc(49) Class1_Sub3_Sub1 local49 = arg1[local43];
				if (local49 != null) {
					this.anInt359 += local49.anInt359;
					this.anInt360 += local49.anInt360;
					this.anInt362 += local49.anInt362;
					local23 |= local49.anIntArray100 != null;
					if (local49.anIntArray101 == null) {
						if (this.anInt361 == -1) {
							this.anInt361 = local49.anInt361;
						}
						if (this.anInt361 != local49.anInt361) {
							local25 = true;
						}
					} else {
						local25 = true;
					}
					local27 |= local49.anIntArray102 != null;
					local29 |= local49.anIntArray108 != null;
				}
			}
			if (arg0 != 0) {
				throw new NullPointerException();
			}
			this.anIntArray91 = new int[this.anInt359];
			this.anIntArray92 = new int[this.anInt359];
			this.anIntArray93 = new int[this.anInt359];
			this.anIntArray107 = new int[this.anInt359];
			this.anIntArray94 = new int[this.anInt360];
			this.anIntArray95 = new int[this.anInt360];
			this.anIntArray96 = new int[this.anInt360];
			this.anIntArray104 = new int[this.anInt362];
			this.anIntArray105 = new int[this.anInt362];
			this.anIntArray106 = new int[this.anInt362];
			if (local23) {
				this.anIntArray100 = new int[this.anInt360];
			}
			if (local25) {
				this.anIntArray101 = new int[this.anInt360];
			}
			if (local27) {
				this.anIntArray102 = new int[this.anInt360];
			}
			if (local29) {
				this.anIntArray108 = new int[this.anInt360];
			}
			this.anIntArray103 = new int[this.anInt360];
			this.anInt359 = 0;
			this.anInt360 = 0;
			this.anInt362 = 0;
			for (@Pc(225) int local225 = 0; local225 < arg2; local225++) {
				@Pc(231) Class1_Sub3_Sub1 local231 = arg1[local225];
				if (local231 != null) {
					for (@Pc(235) int local235 = 0; local235 < local231.anInt360; local235++) {
						if (local23) {
							if (local231.anIntArray100 == null) {
								this.anIntArray100[this.anInt360] = 0;
							} else {
								this.anIntArray100[this.anInt360] = local231.anIntArray100[local235];
							}
						}
						if (local25) {
							if (local231.anIntArray101 == null) {
								this.anIntArray101[this.anInt360] = local231.anInt361;
							} else {
								this.anIntArray101[this.anInt360] = local231.anIntArray101[local235];
							}
						}
						if (local27) {
							if (local231.anIntArray102 == null) {
								this.anIntArray102[this.anInt360] = 0;
							} else {
								this.anIntArray102[this.anInt360] = local231.anIntArray102[local235];
							}
						}
						if (local29 && local231.anIntArray108 != null) {
							this.anIntArray108[this.anInt360] = local231.anIntArray108[local235];
						}
						this.anIntArray103[this.anInt360] = local231.anIntArray103[local235];
						this.anIntArray94[this.anInt360] = this.method226(local231, local231.anIntArray94[local235]);
						this.anIntArray95[this.anInt360] = this.method226(local231, local231.anIntArray95[local235]);
						this.anIntArray96[this.anInt360] = this.method226(local231, local231.anIntArray96[local235]);
						this.anInt360++;
					}
					for (@Pc(376) int local376 = 0; local376 < local231.anInt362; local376++) {
						this.anIntArray104[this.anInt362] = this.method226(local231, local231.anIntArray104[local376]);
						this.anIntArray105[this.anInt362] = this.method226(local231, local231.anIntArray105[local376]);
						this.anIntArray106[this.anInt362] = this.method226(local231, local231.anIntArray106[local376]);
						this.anInt362++;
					}
				}
			}
		} catch (@Pc(431) RuntimeException local431) {
			signlink.reporterror("76712, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local431.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "([Lclient!eb;BIZ)V")
	public Class1_Sub3_Sub1(@OriginalArg(0) Class1_Sub3_Sub1[] arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
		try {
			@Pc(23) boolean local23 = false;
			@Pc(25) boolean local25 = false;
			@Pc(27) boolean local27 = false;
			@Pc(29) boolean local29 = false;
			this.anInt359 = 0;
			this.anInt360 = 0;
			this.anInt362 = 0;
			this.anInt361 = -1;
			for (@Pc(43) int local43 = 0; local43 < arg2; local43++) {
				@Pc(49) Class1_Sub3_Sub1 local49 = arg0[local43];
				if (local49 != null) {
					this.anInt359 += local49.anInt359;
					this.anInt360 += local49.anInt360;
					this.anInt362 += local49.anInt362;
					local23 |= local49.anIntArray100 != null;
					if (local49.anIntArray101 == null) {
						if (this.anInt361 == -1) {
							this.anInt361 = local49.anInt361;
						}
						if (this.anInt361 != local49.anInt361) {
							local25 = true;
						}
					} else {
						local25 = true;
					}
					local27 |= local49.anIntArray102 != null;
					local29 |= local49.anIntArray103 != null;
				}
			}
			this.anIntArray91 = new int[this.anInt359];
			this.anIntArray92 = new int[this.anInt359];
			this.anIntArray93 = new int[this.anInt359];
			this.anIntArray94 = new int[this.anInt360];
			this.anIntArray95 = new int[this.anInt360];
			this.anIntArray96 = new int[this.anInt360];
			this.anIntArray97 = new int[this.anInt360];
			this.anIntArray98 = new int[this.anInt360];
			this.anIntArray99 = new int[this.anInt360];
			this.anIntArray104 = new int[this.anInt362];
			this.anIntArray105 = new int[this.anInt362];
			this.anIntArray106 = new int[this.anInt362];
			if (local23) {
				this.anIntArray100 = new int[this.anInt360];
			}
			if (local25) {
				this.anIntArray101 = new int[this.anInt360];
			}
			if (local27) {
				this.anIntArray102 = new int[this.anInt360];
			}
			if (local29) {
				this.anIntArray103 = new int[this.anInt360];
			}
			this.anInt359 = 0;
			this.anInt360 = 0;
			this.anInt362 = 0;
			@Pc(227) int local227;
			if (arg1 != -31) {
				for (local227 = 1; local227 > 0; local227++) {
				}
			}
			for (local227 = 0; local227 < arg2; local227++) {
				@Pc(240) Class1_Sub3_Sub1 local240 = arg0[local227];
				if (local240 != null) {
					@Pc(245) int local245 = this.anInt359;
					for (@Pc(247) int local247 = 0; local247 < local240.anInt359; local247++) {
						this.anIntArray91[this.anInt359] = local240.anIntArray91[local247];
						this.anIntArray92[this.anInt359] = local240.anIntArray92[local247];
						this.anIntArray93[this.anInt359] = local240.anIntArray93[local247];
						this.anInt359++;
					}
					for (@Pc(289) int local289 = 0; local289 < local240.anInt360; local289++) {
						this.anIntArray94[this.anInt360] = local240.anIntArray94[local289] + local245;
						this.anIntArray95[this.anInt360] = local240.anIntArray95[local289] + local245;
						this.anIntArray96[this.anInt360] = local240.anIntArray96[local289] + local245;
						this.anIntArray97[this.anInt360] = local240.anIntArray97[local289];
						this.anIntArray98[this.anInt360] = local240.anIntArray98[local289];
						this.anIntArray99[this.anInt360] = local240.anIntArray99[local289];
						if (local23) {
							if (local240.anIntArray100 == null) {
								this.anIntArray100[this.anInt360] = 0;
							} else {
								this.anIntArray100[this.anInt360] = local240.anIntArray100[local289];
							}
						}
						if (local25) {
							if (local240.anIntArray101 == null) {
								this.anIntArray101[this.anInt360] = local240.anInt361;
							} else {
								this.anIntArray101[this.anInt360] = local240.anIntArray101[local289];
							}
						}
						if (local27) {
							if (local240.anIntArray102 == null) {
								this.anIntArray102[this.anInt360] = 0;
							} else {
								this.anIntArray102[this.anInt360] = local240.anIntArray102[local289];
							}
						}
						if (local29 && local240.anIntArray103 != null) {
							this.anIntArray103[this.anInt360] = local240.anIntArray103[local289];
						}
						this.anInt360++;
					}
					for (@Pc(445) int local445 = 0; local445 < local240.anInt362; local445++) {
						this.anIntArray104[this.anInt362] = local240.anIntArray104[local445] + local245;
						this.anIntArray105[this.anInt362] = local240.anIntArray105[local445] + local245;
						this.anIntArray106[this.anInt362] = local240.anIntArray106[local445] + local245;
						this.anInt362++;
					}
				}
			}
			this.method227(2992);
		} catch (@Pc(500) RuntimeException local500) {
			signlink.reporterror("4659, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local500.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(Lclient!eb;ZZIZ)V")
	public Class1_Sub3_Sub1(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4) {
		try {
			this.anInt359 = arg0.anInt359;
			this.anInt360 = arg0.anInt360;
			this.anInt362 = arg0.anInt362;
			@Pc(66) int local66;
			if (arg4) {
				this.anIntArray91 = arg0.anIntArray91;
				this.anIntArray92 = arg0.anIntArray92;
				this.anIntArray93 = arg0.anIntArray93;
			} else {
				this.anIntArray91 = new int[this.anInt359];
				this.anIntArray92 = new int[this.anInt359];
				this.anIntArray93 = new int[this.anInt359];
				for (local66 = 0; local66 < this.anInt359; local66++) {
					this.anIntArray91[local66] = arg0.anIntArray91[local66];
					this.anIntArray92[local66] = arg0.anIntArray92[local66];
					this.anIntArray93[local66] = arg0.anIntArray93[local66];
				}
			}
			if (arg1) {
				this.anIntArray103 = arg0.anIntArray103;
			} else {
				this.anIntArray103 = new int[this.anInt360];
				for (local66 = 0; local66 < this.anInt360; local66++) {
					this.anIntArray103[local66] = arg0.anIntArray103[local66];
				}
			}
			if (arg2) {
				this.anIntArray102 = arg0.anIntArray102;
			} else {
				this.anIntArray102 = new int[this.anInt360];
				if (arg0.anIntArray102 == null) {
					for (local66 = 0; local66 < this.anInt360; local66++) {
						this.anIntArray102[local66] = 0;
					}
				} else {
					for (local66 = 0; local66 < this.anInt360; local66++) {
						this.anIntArray102[local66] = arg0.anIntArray102[local66];
					}
				}
			}
			this.anIntArray107 = arg0.anIntArray107;
			this.anIntArray108 = arg0.anIntArray108;
			this.anIntArray100 = arg0.anIntArray100;
			if (arg3 != 0) {
				Static10.aBoolean82 = !Static10.aBoolean82;
			}
			this.anIntArray94 = arg0.anIntArray94;
			this.anIntArray95 = arg0.anIntArray95;
			this.anIntArray96 = arg0.anIntArray96;
			this.anIntArray101 = arg0.anIntArray101;
			this.anInt361 = arg0.anInt361;
			this.anIntArray104 = arg0.anIntArray104;
			this.anIntArray105 = arg0.anIntArray105;
			this.anIntArray106 = arg0.anIntArray106;
		} catch (@Pc(229) RuntimeException local229) {
			signlink.reporterror("52705, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local229.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(Lclient!eb;BZZ)V")
	public Class1_Sub3_Sub1(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) boolean arg3) {
		try {
			this.anInt359 = arg0.anInt359;
			this.anInt360 = arg0.anInt360;
			this.anInt362 = arg0.anInt362;
			@Pc(42) int local42;
			if (arg2) {
				this.anIntArray92 = new int[this.anInt359];
				for (local42 = 0; local42 < this.anInt359; local42++) {
					this.anIntArray92[local42] = arg0.anIntArray92[local42];
				}
			} else {
				this.anIntArray92 = arg0.anIntArray92;
			}
			if (arg3) {
				this.anIntArray97 = new int[this.anInt360];
				this.anIntArray98 = new int[this.anInt360];
				this.anIntArray99 = new int[this.anInt360];
				for (local42 = 0; local42 < this.anInt360; local42++) {
					this.anIntArray97[local42] = arg0.anIntArray97[local42];
					this.anIntArray98[local42] = arg0.anIntArray98[local42];
					this.anIntArray99[local42] = arg0.anIntArray99[local42];
				}
				this.anIntArray100 = new int[this.anInt360];
				@Pc(122) int local122;
				if (arg0.anIntArray100 == null) {
					for (local122 = 0; local122 < this.anInt360; local122++) {
						this.anIntArray100[local122] = 0;
					}
				} else {
					for (local122 = 0; local122 < this.anInt360; local122++) {
						this.anIntArray100[local122] = arg0.anIntArray100[local122];
					}
				}
				this.aClass26Array1 = new Class26[this.anInt359];
				for (local122 = 0; local122 < this.anInt359; local122++) {
					@Pc(170) Class26 local170 = this.aClass26Array1[local122] = new Class26();
					@Pc(175) Class26 local175 = arg0.aClass26Array1[local122];
					local170.anInt646 = local175.anInt646;
					local170.anInt647 = local175.anInt647;
					local170.anInt648 = local175.anInt648;
					local170.anInt649 = local175.anInt649;
				}
				this.aClass26Array2 = arg0.aClass26Array2;
			} else {
				this.anIntArray97 = arg0.anIntArray97;
				this.anIntArray98 = arg0.anIntArray98;
				this.anIntArray99 = arg0.anIntArray99;
				this.anIntArray100 = arg0.anIntArray100;
			}
			this.anIntArray91 = arg0.anIntArray91;
			this.anIntArray93 = arg0.anIntArray93;
			this.anIntArray103 = arg0.anIntArray103;
			this.anIntArray102 = arg0.anIntArray102;
			this.anIntArray101 = arg0.anIntArray101;
			this.anInt361 = arg0.anInt361;
			this.anIntArray94 = arg0.anIntArray94;
			this.anIntArray95 = arg0.anIntArray95;
			this.anIntArray96 = arg0.anIntArray96;
			this.anIntArray104 = arg0.anIntArray104;
			this.anIntArray105 = arg0.anIntArray105;
			this.anIntArray106 = arg0.anIntArray106;
			if (arg1 != -31) {
				throw new NullPointerException();
			}
			this.anInt368 = arg0.anInt368;
			this.anInt369 = arg0.anInt369;
			this.anInt367 = arg0.anInt367;
			this.anInt371 = arg0.anInt371;
			this.anInt370 = arg0.anInt370;
			this.anInt363 = arg0.anInt363;
			this.anInt365 = arg0.anInt365;
			this.anInt366 = arg0.anInt366;
			this.anInt364 = arg0.anInt364;
		} catch (@Pc(311) RuntimeException local311) {
			signlink.reporterror("38920, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local311.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "<init>", descriptor = "(ILclient!eb;Z)V")
	public Class1_Sub3_Sub1(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub1 arg1, @OriginalArg(2) boolean arg2) {
		try {
			this.anInt359 = arg1.anInt359;
			this.anInt360 = arg1.anInt360;
			this.anInt362 = arg1.anInt362;
			this.anIntArray91 = new int[this.anInt359];
			this.anIntArray92 = new int[this.anInt359];
			this.anIntArray93 = new int[this.anInt359];
			for (@Pc(50) int local50 = 0; local50 < this.anInt359; local50++) {
				this.anIntArray91[local50] = arg1.anIntArray91[local50];
				this.anIntArray92[local50] = arg1.anIntArray92[local50];
				this.anIntArray93[local50] = arg1.anIntArray93[local50];
			}
			if (arg2) {
				this.anIntArray102 = arg1.anIntArray102;
			} else {
				this.anIntArray102 = new int[this.anInt360];
				@Pc(99) int local99;
				if (arg1.anIntArray102 == null) {
					for (local99 = 0; local99 < this.anInt360; local99++) {
						this.anIntArray102[local99] = 0;
					}
				} else {
					for (local99 = 0; local99 < this.anInt360; local99++) {
						this.anIntArray102[local99] = arg1.anIntArray102[local99];
					}
				}
			}
			this.anIntArray100 = arg1.anIntArray100;
			this.anIntArray103 = arg1.anIntArray103;
			this.anIntArray101 = arg1.anIntArray101;
			if (arg0 != 0) {
				this.anInt358 = 213;
			}
			this.anInt361 = arg1.anInt361;
			this.anIntArrayArray7 = arg1.anIntArrayArray7;
			this.anIntArrayArray6 = arg1.anIntArrayArray6;
			this.anIntArray94 = arg1.anIntArray94;
			this.anIntArray95 = arg1.anIntArray95;
			this.anIntArray96 = arg1.anIntArray96;
			this.anIntArray97 = arg1.anIntArray97;
			this.anIntArray98 = arg1.anIntArray98;
			this.anIntArray99 = arg1.anIntArray99;
			this.anIntArray104 = arg1.anIntArray104;
			this.anIntArray105 = arg1.anIntArray105;
			this.anIntArray106 = arg1.anIntArray106;
		} catch (@Pc(196) RuntimeException local196) {
			signlink.reporterror("94709, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local196.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(Lclient!eb;I)I")
	private int method226(@OriginalArg(0) Class1_Sub3_Sub1 arg0, @OriginalArg(1) int arg1) {
		@Pc(3) int local3 = -1;
		@Pc(8) int local8 = arg0.anIntArray91[arg1];
		@Pc(13) int local13 = arg0.anIntArray92[arg1];
		@Pc(18) int local18 = arg0.anIntArray93[arg1];
		for (@Pc(20) int local20 = 0; local20 < this.anInt359; local20++) {
			if (local8 == this.anIntArray91[local20] && local13 == this.anIntArray92[local20] && local18 == this.anIntArray93[local20]) {
				local3 = local20;
				break;
			}
		}
		if (local3 == -1) {
			this.anIntArray91[this.anInt359] = local8;
			this.anIntArray92[this.anInt359] = local13;
			this.anIntArray93[this.anInt359] = local18;
			if (arg0.anIntArray107 != null) {
				this.anIntArray107[this.anInt359] = arg0.anIntArray107[arg1];
			}
			local3 = this.anInt359++;
		}
		return local3;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(I)V")
	public void method227(@OriginalArg(0) int arg0) {
		try {
			this.anInt368 = 0;
			if (arg0 == 2992) {
				this.anInt367 = 0;
				this.anInt369 = 0;
				for (@Pc(14) int local14 = 0; local14 < this.anInt359; local14++) {
					@Pc(21) int local21 = this.anIntArray91[local14];
					@Pc(26) int local26 = this.anIntArray92[local14];
					@Pc(31) int local31 = this.anIntArray93[local14];
					if (-local26 > this.anInt368) {
						this.anInt368 = -local26;
					}
					if (local26 > this.anInt369) {
						this.anInt369 = local26;
					}
					@Pc(55) int local55 = local21 * local21 + local31 * local31;
					if (local55 > this.anInt367) {
						this.anInt367 = local55;
					}
				}
				this.anInt367 = (int) (Math.sqrt((double) this.anInt367) + 0.99D);
				this.anInt371 = (int) (Math.sqrt((double) (this.anInt367 * this.anInt367 + this.anInt368 * this.anInt368)) + 0.99D);
				this.anInt370 = this.anInt371 + (int) (Math.sqrt((double) (this.anInt367 * this.anInt367 + this.anInt369 * this.anInt369)) + 0.99D);
			}
		} catch (@Pc(117) RuntimeException local117) {
			signlink.reporterror("64225, " + arg0 + ", " + local117.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(I)V")
	public void method228(@OriginalArg(0) int arg0) {
		try {
			this.anInt368 = 0;
			@Pc(8) int local8;
			if (arg0 != 0) {
				for (local8 = 1; local8 > 0; local8++) {
				}
			}
			this.anInt369 = 0;
			for (local8 = 0; local8 < this.anInt359; local8++) {
				@Pc(25) int local25 = this.anIntArray92[local8];
				if (-local25 > this.anInt368) {
					this.anInt368 = -local25;
				}
				if (local25 > this.anInt369) {
					this.anInt369 = local25;
				}
			}
			this.anInt371 = (int) (Math.sqrt((double) (this.anInt367 * this.anInt367 + this.anInt368 * this.anInt368)) + 0.99D);
			this.anInt370 = this.anInt371 + (int) (Math.sqrt((double) (this.anInt367 * this.anInt367 + this.anInt369 * this.anInt369)) + 0.99D);
		} catch (@Pc(87) RuntimeException local87) {
			signlink.reporterror("27954, " + arg0 + ", " + local87.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(B)V")
	private void method229(@OriginalArg(0) byte arg0) {
		try {
			this.anInt368 = 0;
			if (arg0 == this.aByte20) {
				this.anInt367 = 0;
				this.anInt369 = 0;
				this.anInt363 = 999999;
				this.anInt364 = -999999;
				this.anInt365 = -99999;
				this.anInt366 = 99999;
				for (@Pc(27) int local27 = 0; local27 < this.anInt359; local27++) {
					@Pc(34) int local34 = this.anIntArray91[local27];
					@Pc(39) int local39 = this.anIntArray92[local27];
					@Pc(44) int local44 = this.anIntArray93[local27];
					if (local34 < this.anInt363) {
						this.anInt363 = local34;
					}
					if (local34 > this.anInt364) {
						this.anInt364 = local34;
					}
					if (local44 < this.anInt366) {
						this.anInt366 = local44;
					}
					if (local44 > this.anInt365) {
						this.anInt365 = local44;
					}
					if (-local39 > this.anInt368) {
						this.anInt368 = -local39;
					}
					if (local39 > this.anInt369) {
						this.anInt369 = local39;
					}
					@Pc(96) int local96 = local34 * local34 + local44 * local44;
					if (local96 > this.anInt367) {
						this.anInt367 = local96;
					}
				}
				this.anInt367 = (int) Math.sqrt((double) this.anInt367);
				this.anInt371 = (int) Math.sqrt((double) (this.anInt367 * this.anInt367 + this.anInt368 * this.anInt368));
				this.anInt370 = this.anInt371 + (int) Math.sqrt((double) (this.anInt367 * this.anInt367 + this.anInt369 * this.anInt369));
			}
		} catch (@Pc(152) RuntimeException local152) {
			signlink.reporterror("62953, " + arg0 + ", " + local152.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "c", descriptor = "(I)V")
	public void method230(@OriginalArg(0) int arg0) {
		try {
			if (arg0 == 4) {
				@Pc(11) int[] local11;
				@Pc(26) int local26;
				@Pc(13) int local13;
				@Pc(15) int local15;
				@Pc(22) int local22;
				@Pc(67) int local67;
				@Pc(74) int local74;
				if (this.anIntArray107 != null) {
					local11 = new int[256];
					local13 = 0;
					for (local15 = 0; local15 < this.anInt359; local15++) {
						local22 = this.anIntArray107[local15];
						local26 = local11[local22]++;
						if (local22 > local13) {
							local13 = local22;
						}
					}
					this.anIntArrayArray6 = new int[local13 + 1][];
					for (local22 = 0; local22 <= local13; local22++) {
						this.anIntArrayArray6[local22] = new int[local11[local22]];
						local11[local22] = 0;
					}
					local67 = 0;
					while (local67 < this.anInt359) {
						local74 = this.anIntArray107[local67];
						this.anIntArrayArray6[local74][local11[local74]++] = local67++;
					}
					this.anIntArray107 = null;
				}
				if (this.anIntArray108 != null) {
					local11 = new int[256];
					local13 = 0;
					for (local15 = 0; local15 < this.anInt360; local15++) {
						local22 = this.anIntArray108[local15];
						local26 = local11[local22]++;
						if (local22 > local13) {
							local13 = local22;
						}
					}
					this.anIntArrayArray7 = new int[local13 + 1][];
					for (local22 = 0; local22 <= local13; local22++) {
						this.anIntArrayArray7[local22] = new int[local11[local22]];
						local11[local22] = 0;
					}
					local67 = 0;
					while (local67 < this.anInt360) {
						local74 = this.anIntArray108[local67];
						this.anIntArrayArray7[local74][local11[local74]++] = local67++;
					}
					this.anIntArray108 = null;
				}
			}
		} catch (@Pc(189) RuntimeException local189) {
			signlink.reporterror("9753, " + arg0 + ", " + local189.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(II)V")
	public void method231(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (this.anIntArrayArray6 != null && arg1 != -1) {
				@Pc(11) Class12 local11 = Static14.aClass12Array1[arg1];
				@Pc(14) Class10 local14 = local11.aClass10_1;
				Static10.anInt373 = 0;
				Static10.anInt374 = 0;
				Static10.anInt375 = 0;
				for (@Pc(22) int local22 = 0; local22 < local11.anInt412; local22++) {
					@Pc(29) int local29 = local11.anIntArray130[local22];
					this.method233(local14.anIntArray128[local29], local14.anIntArrayArray11[local29], local11.anIntArray131[local22], local11.anIntArray132[local22], local11.anIntArray133[local22]);
				}
				if (arg0 == -16599) {
					;
				}
			}
		} catch (@Pc(61) RuntimeException local61) {
			signlink.reporterror("30537, " + arg0 + ", " + arg1 + ", " + local61.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(III[I)V")
	public void method232(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int[] arg3) {
		try {
			if (arg2 != -1) {
				if (arg3 == null || arg0 == -1) {
					this.method231(-16599, arg2);
				} else {
					@Pc(19) Class12 local19 = Static14.aClass12Array1[arg2];
					if (arg1 < 3 || arg1 > 3) {
						this.anInt358 = -162;
					}
					@Pc(32) Class12 local32 = Static14.aClass12Array1[arg0];
					@Pc(35) Class10 local35 = local19.aClass10_1;
					Static10.anInt373 = 0;
					Static10.anInt374 = 0;
					Static10.anInt375 = 0;
					@Pc(43) byte local43 = 0;
					@Pc(46) int local46 = local43 + 1;
					@Pc(48) int local48 = arg3[local43];
					@Pc(57) int local57;
					for (@Pc(50) int local50 = 0; local50 < local19.anInt412; local50++) {
						local57 = local19.anIntArray130[local50];
						while (local57 > local48) {
							local48 = arg3[local46++];
						}
						if (local57 != local48 || local35.anIntArray128[local57] == 0) {
							this.method233(local35.anIntArray128[local57], local35.anIntArrayArray11[local57], local19.anIntArray131[local50], local19.anIntArray132[local50], local19.anIntArray133[local50]);
						}
					}
					Static10.anInt373 = 0;
					Static10.anInt374 = 0;
					Static10.anInt375 = 0;
					local43 = 0;
					local46 = local43 + 1;
					local48 = arg3[local43];
					for (local57 = 0; local57 < local32.anInt412; local57++) {
						@Pc(124) int local124 = local32.anIntArray130[local57];
						while (local124 > local48) {
							local48 = arg3[local46++];
						}
						if (local124 == local48 || local35.anIntArray128[local124] == 0) {
							this.method233(local35.anIntArray128[local124], local35.anIntArrayArray11[local124], local32.anIntArray131[local57], local32.anIntArray132[local57], local32.anIntArray133[local57]);
						}
					}
				}
			}
		} catch (@Pc(171) RuntimeException local171) {
			signlink.reporterror("37286, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local171.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(I[IIII)V")
	private void method233(@OriginalArg(0) int arg0, @OriginalArg(1) int[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(4) int local4 = arg1.length;
		@Pc(8) int local8;
		@Pc(16) int local16;
		@Pc(34) int local34;
		@Pc(40) int local40;
		if (arg0 == 0) {
			local8 = 0;
			Static10.anInt373 = 0;
			Static10.anInt374 = 0;
			Static10.anInt375 = 0;
			for (local16 = 0; local16 < local4; local16++) {
				@Pc(22) int local22 = arg1[local16];
				if (local22 < this.anIntArrayArray6.length) {
					@Pc(32) int[] local32 = this.anIntArrayArray6[local22];
					for (local34 = 0; local34 < local32.length; local34++) {
						local40 = local32[local34];
						Static10.anInt373 += this.anIntArray91[local40];
						Static10.anInt374 += this.anIntArray92[local40];
						Static10.anInt375 += this.anIntArray93[local40];
						local8++;
					}
				}
			}
			if (local8 > 0) {
				Static10.anInt373 = Static10.anInt373 / local8 + arg2;
				Static10.anInt374 = Static10.anInt374 / local8 + arg3;
				Static10.anInt375 = Static10.anInt375 / local8 + arg4;
			} else {
				Static10.anInt373 = arg2;
				Static10.anInt374 = arg3;
				Static10.anInt375 = arg4;
			}
			return;
		}
		@Pc(120) int[] local120;
		@Pc(122) int local122;
		if (arg0 == 1) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.anIntArrayArray6.length) {
					local120 = this.anIntArrayArray6[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.anIntArray91[local34] += arg2;
						this.anIntArray92[local34] += arg3;
						this.anIntArray93[local34] += arg4;
					}
				}
			}
		} else if (arg0 == 2) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.anIntArrayArray6.length) {
					local120 = this.anIntArrayArray6[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.anIntArray91[local34] -= Static10.anInt373;
						this.anIntArray92[local34] -= Static10.anInt374;
						this.anIntArray93[local34] -= Static10.anInt375;
						local40 = (arg2 & 0xFF) * 8;
						@Pc(227) int local227 = (arg3 & 0xFF) * 8;
						@Pc(233) int local233 = (arg4 & 0xFF) * 8;
						@Pc(239) int local239;
						@Pc(243) int local243;
						@Pc(259) int local259;
						if (local233 != 0) {
							local239 = Static10.anIntArray124[local233];
							local243 = Static10.anIntArray125[local233];
							local259 = this.anIntArray92[local34] * local239 + this.anIntArray91[local34] * local243 >> 16;
							this.anIntArray92[local34] = this.anIntArray92[local34] * local243 - this.anIntArray91[local34] * local239 >> 16;
							this.anIntArray91[local34] = local259;
						}
						if (local40 != 0) {
							local239 = Static10.anIntArray124[local40];
							local243 = Static10.anIntArray125[local40];
							local259 = this.anIntArray92[local34] * local243 - this.anIntArray93[local34] * local239 >> 16;
							this.anIntArray93[local34] = this.anIntArray92[local34] * local239 + this.anIntArray93[local34] * local243 >> 16;
							this.anIntArray92[local34] = local259;
						}
						if (local227 != 0) {
							local239 = Static10.anIntArray124[local227];
							local243 = Static10.anIntArray125[local227];
							local259 = this.anIntArray93[local34] * local239 + this.anIntArray91[local34] * local243 >> 16;
							this.anIntArray93[local34] = this.anIntArray93[local34] * local243 - this.anIntArray91[local34] * local239 >> 16;
							this.anIntArray91[local34] = local259;
						}
						this.anIntArray91[local34] += Static10.anInt373;
						this.anIntArray92[local34] += Static10.anInt374;
						this.anIntArray93[local34] += Static10.anInt375;
					}
				}
			}
		} else if (arg0 == 3) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.anIntArrayArray6.length) {
					local120 = this.anIntArrayArray6[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.anIntArray91[local34] -= Static10.anInt373;
						this.anIntArray92[local34] -= Static10.anInt374;
						this.anIntArray93[local34] -= Static10.anInt375;
						this.anIntArray91[local34] = this.anIntArray91[local34] * arg2 / 128;
						this.anIntArray92[local34] = this.anIntArray92[local34] * arg3 / 128;
						this.anIntArray93[local34] = this.anIntArray93[local34] * arg4 / 128;
						this.anIntArray91[local34] += Static10.anInt373;
						this.anIntArray92[local34] += Static10.anInt374;
						this.anIntArray93[local34] += Static10.anInt375;
					}
				}
			}
		} else if (arg0 == 5 && (this.anIntArrayArray7 != null && this.anIntArray102 != null)) {
			for (local8 = 0; local8 < local4; local8++) {
				local16 = arg1[local8];
				if (local16 < this.anIntArrayArray7.length) {
					local120 = this.anIntArrayArray7[local16];
					for (local122 = 0; local122 < local120.length; local122++) {
						local34 = local120[local122];
						this.anIntArray102[local34] += arg2 * 8;
						if (this.anIntArray102[local34] < 0) {
							this.anIntArray102[local34] = 0;
						}
						if (this.anIntArray102[local34] > 255) {
							this.anIntArray102[local34] = 255;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "d", descriptor = "(I)V")
	public void method234(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 0) {
				this.anInt357 = 472;
			}
			for (@Pc(6) int local6 = 0; local6 < this.anInt359; local6++) {
				@Pc(13) int local13 = this.anIntArray91[local6];
				this.anIntArray91[local6] = this.anIntArray93[local6];
				this.anIntArray93[local6] = -local13;
			}
		} catch (@Pc(34) RuntimeException local34) {
			signlink.reporterror("87214, " + arg0 + ", " + local34.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(BI)V")
	public void method235(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = Static10.anIntArray124[arg1];
			@Pc(7) int local7 = Static10.anIntArray125[arg1];
			for (@Pc(9) int local9 = 0; local9 < this.anInt359; local9++) {
				@Pc(27) int local27 = this.anIntArray92[local9] * local7 - this.anIntArray93[local9] * local3 >> 16;
				this.anIntArray93[local9] = this.anIntArray92[local9] * local3 + this.anIntArray93[local9] * local7 >> 16;
				this.anIntArray92[local9] = local27;
			}
			if (arg0 == 7) {
				@Pc(61) boolean local61 = false;
			}
		} catch (@Pc(64) RuntimeException local64) {
			signlink.reporterror("42556, " + arg0 + ", " + arg1 + ", " + local64.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIII)V")
	public void method236(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg2 >= 0) {
				this.aBoolean83 = !this.aBoolean83;
			}
			for (@Pc(11) int local11 = 0; local11 < this.anInt359; local11++) {
				this.anIntArray91[local11] += arg1;
				this.anIntArray92[local11] += arg0;
				this.anIntArray93[local11] += arg3;
			}
		} catch (@Pc(44) RuntimeException local44) {
			signlink.reporterror("79785, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local44.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(II)V")
	public void method237(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		for (@Pc(1) int local1 = 0; local1 < this.anInt360; local1++) {
			if (this.anIntArray103[local1] == arg0) {
				this.anIntArray103[local1] = arg1;
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "e", descriptor = "(I)V")
	public void method238(@OriginalArg(0) int arg0) {
		try {
			for (@Pc(3) int local3 = 0; local3 < this.anInt359; local3++) {
				this.anIntArray93[local3] = -this.anIntArray93[local3];
			}
			@Pc(28) int local28;
			for (@Pc(21) int local21 = 0; local21 < this.anInt360; local21++) {
				local28 = this.anIntArray94[local21];
				this.anIntArray94[local21] = this.anIntArray96[local21];
				this.anIntArray96[local21] = local28;
			}
			if (arg0 >= 0) {
				for (local28 = 1; local28 > 0; local28++) {
				}
			}
		} catch (@Pc(57) RuntimeException local57) {
			signlink.reporterror("99608, " + arg0 + ", " + local57.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "b", descriptor = "(IIII)V")
	public void method239(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.anInt359; local1++) {
				this.anIntArray91[local1] = this.anIntArray91[local1] * arg3 / 128;
				this.anIntArray92[local1] = this.anIntArray92[local1] * arg2 / 128;
				this.anIntArray93[local1] = this.anIntArray93[local1] * arg0 / 128;
			}
			if (arg1 < 2 || arg1 > 2) {
				;
			}
		} catch (@Pc(52) RuntimeException local52) {
			signlink.reporterror("99322, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local52.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIZ)V")
	public void method240(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5) {
		@Pc(16) int local16 = (int) Math.sqrt((double) (arg2 * arg2 + arg3 * arg3 + arg4 * arg4));
		@Pc(22) int local22 = arg1 * local16 >> 8;
		if (this.anIntArray97 == null) {
			this.anIntArray97 = new int[this.anInt360];
			this.anIntArray98 = new int[this.anInt360];
			this.anIntArray99 = new int[this.anInt360];
		}
		@Pc(50) int local50;
		if (this.aClass26Array1 == null) {
			this.aClass26Array1 = new Class26[this.anInt359];
			for (local50 = 0; local50 < this.anInt359; local50++) {
				this.aClass26Array1[local50] = new Class26();
			}
		}
		@Pc(73) int local73;
		for (local50 = 0; local50 < this.anInt360; local50++) {
			local73 = this.anIntArray94[local50];
			@Pc(78) int local78 = this.anIntArray95[local50];
			@Pc(83) int local83 = this.anIntArray96[local50];
			@Pc(93) int local93 = this.anIntArray91[local78] - this.anIntArray91[local73];
			@Pc(103) int local103 = this.anIntArray92[local78] - this.anIntArray92[local73];
			@Pc(113) int local113 = this.anIntArray93[local78] - this.anIntArray93[local73];
			@Pc(123) int local123 = this.anIntArray91[local83] - this.anIntArray91[local73];
			@Pc(133) int local133 = this.anIntArray92[local83] - this.anIntArray92[local73];
			@Pc(143) int local143 = this.anIntArray93[local83] - this.anIntArray93[local73];
			@Pc(151) int local151 = local103 * local143 - local133 * local113;
			@Pc(159) int local159 = local113 * local123 - local143 * local93;
			@Pc(167) int local167;
			for (local167 = local93 * local133 - local123 * local103; local151 > 8192 || local159 > 8192 || local167 > 8192 || local151 < -8192 || local159 < -8192 || local167 < -8192; local167 >>= 0x1) {
				local151 >>= 0x1;
				local159 >>= 0x1;
			}
			@Pc(214) int local214 = (int) Math.sqrt((double) (local151 * local151 + local159 * local159 + local167 * local167));
			if (local214 <= 0) {
				local214 = 1;
			}
			local151 = local151 * 256 / local214;
			local159 = local159 * 256 / local214;
			local167 = local167 * 256 / local214;
			if (this.anIntArray100 == null || (this.anIntArray100[local50] & 0x1) == 0) {
				@Pc(251) Class26 local251 = this.aClass26Array1[local73];
				local251.anInt646 += local151;
				local251.anInt647 += local159;
				local251.anInt648 += local167;
				local251.anInt649++;
				@Pc(280) Class26 local280 = this.aClass26Array1[local78];
				local280.anInt646 += local151;
				local280.anInt647 += local159;
				local280.anInt648 += local167;
				local280.anInt649++;
				@Pc(309) Class26 local309 = this.aClass26Array1[local83];
				local309.anInt646 += local151;
				local309.anInt647 += local159;
				local309.anInt648 += local167;
				local309.anInt649++;
			} else {
				@Pc(355) int local355 = arg0 + (arg2 * local151 + arg3 * local159 + arg4 * local167) / (local22 + local22 / 2);
				this.anIntArray97[local50] = Static10.method242(this.anIntArray103[local50], local355, this.anIntArray100[local50]);
			}
		}
		if (arg5) {
			this.method241(arg0, local22, arg2, arg3, arg4);
		} else {
			this.aClass26Array2 = new Class26[this.anInt359];
			for (local73 = 0; local73 < this.anInt359; local73++) {
				@Pc(399) Class26 local399 = this.aClass26Array1[local73];
				@Pc(408) Class26 local408 = this.aClass26Array2[local73] = new Class26();
				local408.anInt646 = local399.anInt646;
				local408.anInt647 = local399.anInt647;
				local408.anInt648 = local399.anInt648;
				local408.anInt649 = local399.anInt649;
			}
		}
		if (arg5) {
			this.method227(2992);
		} else {
			this.method229(this.aByte19);
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIII)V")
	public void method241(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		@Pc(10) int local10;
		for (@Pc(3) int local3 = 0; local3 < this.anInt360; local3++) {
			local10 = this.anIntArray94[local3];
			@Pc(15) int local15 = this.anIntArray95[local3];
			@Pc(20) int local20 = this.anIntArray96[local3];
			@Pc(33) Class26 local33;
			@Pc(55) int local55;
			@Pc(28) int local28;
			if (this.anIntArray100 == null) {
				local28 = this.anIntArray103[local3];
				local33 = this.aClass26Array1[local10];
				local55 = arg0 + (arg2 * local33.anInt646 + arg3 * local33.anInt647 + arg4 * local33.anInt648) / (arg1 * local33.anInt649);
				this.anIntArray97[local3] = Static10.method242(local28, local55, 0);
				@Pc(68) Class26 local68 = this.aClass26Array1[local15];
				@Pc(90) int local90 = arg0 + (arg2 * local68.anInt646 + arg3 * local68.anInt647 + arg4 * local68.anInt648) / (arg1 * local68.anInt649);
				this.anIntArray98[local3] = Static10.method242(local28, local90, 0);
				@Pc(103) Class26 local103 = this.aClass26Array1[local20];
				@Pc(125) int local125 = arg0 + (arg2 * local103.anInt646 + arg3 * local103.anInt647 + arg4 * local103.anInt648) / (arg1 * local103.anInt649);
				this.anIntArray99[local3] = Static10.method242(local28, local125, 0);
			} else if ((this.anIntArray100[local3] & 0x1) == 0) {
				local28 = this.anIntArray103[local3];
				@Pc(152) int local152 = this.anIntArray100[local3];
				local33 = this.aClass26Array1[local10];
				local55 = arg0 + (arg2 * local33.anInt646 + arg3 * local33.anInt647 + arg4 * local33.anInt648) / (arg1 * local33.anInt649);
				this.anIntArray97[local3] = Static10.method242(local28, local55, local152);
				local33 = this.aClass26Array1[local15];
				local55 = arg0 + (arg2 * local33.anInt646 + arg3 * local33.anInt647 + arg4 * local33.anInt648) / (arg1 * local33.anInt649);
				this.anIntArray98[local3] = Static10.method242(local28, local55, local152);
				local33 = this.aClass26Array1[local20];
				local55 = arg0 + (arg2 * local33.anInt646 + arg3 * local33.anInt647 + arg4 * local33.anInt648) / (arg1 * local33.anInt649);
				this.anIntArray99[local3] = Static10.method242(local28, local55, local152);
			}
		}
		this.aClass26Array1 = null;
		this.aClass26Array2 = null;
		this.anIntArray107 = null;
		this.anIntArray108 = null;
		if (this.anIntArray100 != null) {
			for (local10 = 0; local10 < this.anInt360; local10++) {
				if ((this.anIntArray100[local10] & 0x2) == 2) {
					return;
				}
			}
		}
		this.anIntArray103 = null;
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIII)V")
	public void method243(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		@Pc(1) int local1 = Static15.anInt430;
		@Pc(3) int local3 = Static15.anInt431;
		@Pc(7) int local7 = Static10.anIntArray124[arg0];
		@Pc(11) int local11 = Static10.anIntArray125[arg0];
		@Pc(15) int local15 = Static10.anIntArray124[arg1];
		@Pc(19) int local19 = Static10.anIntArray125[arg1];
		@Pc(23) int local23 = Static10.anIntArray124[arg2];
		@Pc(27) int local27 = Static10.anIntArray125[arg2];
		@Pc(31) int local31 = Static10.anIntArray124[arg3];
		@Pc(35) int local35 = Static10.anIntArray125[arg3];
		@Pc(45) int local45 = arg5 * local31 + arg6 * local35 >> 16;
		for (@Pc(47) int local47 = 0; local47 < this.anInt359; local47++) {
			@Pc(54) int local54 = this.anIntArray91[local47];
			@Pc(59) int local59 = this.anIntArray92[local47];
			@Pc(64) int local64 = this.anIntArray93[local47];
			@Pc(76) int local76;
			if (arg2 != 0) {
				local76 = local59 * local23 + local54 * local27 >> 16;
				local59 = local59 * local27 - local54 * local23 >> 16;
				local54 = local76;
			}
			if (arg0 != 0) {
				local76 = local59 * local11 - local64 * local7 >> 16;
				local64 = local59 * local7 + local64 * local11 >> 16;
				local59 = local76;
			}
			if (arg1 != 0) {
				local76 = local64 * local15 + local54 * local19 >> 16;
				local64 = local64 * local19 - local54 * local15 >> 16;
				local54 = local76;
			}
			local54 += arg4;
			local59 += arg5;
			local64 += arg6;
			local76 = local59 * local35 - local64 * local31 >> 16;
			local64 = local59 * local31 + local64 * local35 >> 16;
			Static10.anIntArray111[local47] = local64 - local45;
			Static10.anIntArray109[local47] = local1 + (local54 << 9) / local64;
			Static10.anIntArray110[local47] = local3 + (local76 << 9) / local64;
			if (this.anInt362 > 0) {
				Static10.anIntArray112[local47] = local54;
				Static10.anIntArray113[local47] = local76;
				Static10.anIntArray114[local47] = local64;
			}
		}
		try {
			this.method245(false, false, 0);
		} catch (@Pc(223) Exception local223) {
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIIIII)V")
	public void method244(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8) {
		@Pc(11) int local11 = arg7 * arg4 - arg5 * arg3 >> 16;
		@Pc(21) int local21 = arg6 * arg1 + local11 * arg2 >> 16;
		@Pc(28) int local28 = this.anInt367 * arg2 >> 16;
		@Pc(32) int local32 = local21 + local28;
		if (local32 <= 50 || local21 >= 3500) {
			return;
		}
		@Pc(49) int local49 = arg7 * arg3 + arg5 * arg4 >> 16;
		@Pc(56) int local56 = local49 - this.anInt367 << 9;
		if (local56 / local32 >= Static12.anInt535) {
			return;
		}
		@Pc(69) int local69 = local49 + this.anInt367 << 9;
		if (local69 / local32 <= -Static12.anInt535) {
			return;
		}
		@Pc(86) int local86 = arg6 * arg2 - local11 * arg1 >> 16;
		@Pc(93) int local93 = this.anInt367 * arg1 >> 16;
		@Pc(99) int local99 = local86 + local93 << 9;
		if (local99 / local32 <= -Static12.anInt536) {
			return;
		}
		@Pc(115) int local115 = local93 + (this.anInt368 * arg2 >> 16);
		@Pc(121) int local121 = local86 - local115 << 9;
		if (local121 / local32 >= Static12.anInt536) {
			return;
		}
		@Pc(136) int local136 = local28 + (this.anInt368 * arg1 >> 16);
		@Pc(138) boolean local138 = false;
		if (local21 - local136 <= 50) {
			local138 = true;
		}
		@Pc(147) boolean local147 = false;
		@Pc(155) int local155;
		@Pc(204) int local204;
		@Pc(208) int local208;
		if (arg8 > 0 && Static10.aBoolean85) {
			local155 = local21 - local28;
			if (local155 <= 50) {
				local155 = 50;
			}
			if (local49 > 0) {
				local56 /= local32;
				local69 /= local155;
			} else {
				local69 /= local32;
				local56 /= local155;
			}
			if (local86 > 0) {
				local121 /= local32;
				local99 /= local155;
			} else {
				local99 /= local32;
				local121 /= local155;
			}
			local204 = Static10.anInt376 - Static15.anInt430;
			local208 = Static10.anInt377 - Static15.anInt431;
			if (local204 > local56 && local204 < local69 && local208 > local121 && local208 < local99) {
				if (this.aBoolean84) {
					Static10.anIntArray123[Static10.anInt378++] = arg8;
				} else {
					local147 = true;
				}
			}
		}
		local155 = Static15.anInt430;
		local204 = Static15.anInt431;
		local208 = 0;
		@Pc(243) int local243 = 0;
		if (arg0 != 0) {
			local208 = Static10.anIntArray124[arg0];
			local243 = Static10.anIntArray125[arg0];
		}
		for (@Pc(255) int local255 = 0; local255 < this.anInt359; local255++) {
			@Pc(262) int local262 = this.anIntArray91[local255];
			@Pc(267) int local267 = this.anIntArray92[local255];
			@Pc(272) int local272 = this.anIntArray93[local255];
			@Pc(284) int local284;
			if (arg0 != 0) {
				local284 = local272 * local208 + local262 * local243 >> 16;
				local272 = local272 * local243 - local262 * local208 >> 16;
				local262 = local284;
			}
			local262 += arg5;
			local267 += arg6;
			local272 += arg7;
			local284 = local272 * arg3 + local262 * arg4 >> 16;
			local272 = local272 * arg4 - local262 * arg3 >> 16;
			local262 = local284;
			local284 = local267 * arg2 - local272 * arg1 >> 16;
			local272 = local267 * arg1 + local272 * arg2 >> 16;
			Static10.anIntArray111[local255] = local272 - local21;
			if (local272 >= 50) {
				Static10.anIntArray109[local255] = local155 + (local262 << 9) / local272;
				Static10.anIntArray110[local255] = local204 + (local284 << 9) / local272;
			} else {
				Static10.anIntArray109[local255] = -5000;
				local138 = true;
			}
			if (local138 || this.anInt362 > 0) {
				Static10.anIntArray112[local255] = local262;
				Static10.anIntArray113[local255] = local284;
				Static10.anIntArray114[local255] = local272;
			}
		}
		try {
			this.method245(local138, local147, arg8);
		} catch (@Pc(418) Exception local418) {
		}
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(ZZI)V")
	private void method245(@OriginalArg(0) boolean arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		for (@Pc(3) int local3 = 0; local3 < this.anInt370; local3++) {
			Static10.anIntArray115[local3] = 0;
		}
		@Pc(32) int local32;
		@Pc(37) int local37;
		@Pc(42) int local42;
		@Pc(46) int local46;
		@Pc(50) int local50;
		@Pc(54) int local54;
		@Pc(86) int local86;
		for (@Pc(16) int local16 = 0; local16 < this.anInt360; local16++) {
			if (this.anIntArray100 == null || this.anIntArray100[local16] != -1) {
				local32 = this.anIntArray94[local16];
				local37 = this.anIntArray95[local16];
				local42 = this.anIntArray96[local16];
				local46 = Static10.anIntArray109[local32];
				local50 = Static10.anIntArray109[local37];
				local54 = Static10.anIntArray109[local42];
				if (arg0 && (local46 == -5000 || local50 == -5000 || local54 == -5000)) {
					Static10.aBooleanArray3[local16] = true;
					local86 = (Static10.anIntArray111[local32] + Static10.anIntArray111[local37] + Static10.anIntArray111[local42]) / 3 + this.anInt371;
					Static10.anIntArrayArray8[local86][Static10.anIntArray115[local86]++] = local16;
				} else {
					if (arg1 && this.method248(Static10.anInt376, Static10.anInt377, Static10.anIntArray110[local32], Static10.anIntArray110[local37], Static10.anIntArray110[local42], local46, local50, local54)) {
						Static10.anIntArray123[Static10.anInt378++] = arg2;
						arg1 = false;
					}
					if ((local46 - local50) * (Static10.anIntArray110[local42] - Static10.anIntArray110[local37]) - (Static10.anIntArray110[local32] - Static10.anIntArray110[local37]) * (local54 - local50) > 0) {
						Static10.aBooleanArray3[local16] = false;
						if (local46 >= 0 && local50 >= 0 && local54 >= 0 && local46 <= Static12.anInt534 && local50 <= Static12.anInt534 && local54 <= Static12.anInt534) {
							Static10.aBooleanArray2[local16] = false;
						} else {
							Static10.aBooleanArray2[local16] = true;
						}
						local86 = (Static10.anIntArray111[local32] + Static10.anIntArray111[local37] + Static10.anIntArray111[local42]) / 3 + this.anInt371;
						Static10.anIntArrayArray8[local86][Static10.anIntArray115[local86]++] = local16;
					}
				}
			}
		}
		if (this.anIntArray101 == null) {
			for (local32 = this.anInt370 - 1; local32 >= 0; local32--) {
				local37 = Static10.anIntArray115[local32];
				if (local37 > 0) {
					@Pc(238) int[] local238 = Static10.anIntArrayArray8[local32];
					for (local46 = 0; local46 < local37; local46++) {
						this.method246(local238[local46]);
					}
				}
			}
			return;
		}
		for (local32 = 0; local32 < 12; local32++) {
			Static10.anIntArray116[local32] = 0;
			Static10.anIntArray119[local32] = 0;
		}
		@Pc(310) int local310;
		for (local37 = this.anInt370 - 1; local37 >= 0; local37--) {
			local42 = Static10.anIntArray115[local37];
			if (local42 > 0) {
				@Pc(288) int[] local288 = Static10.anIntArrayArray8[local37];
				for (local50 = 0; local50 < local42; local50++) {
					local54 = local288[local50];
					local86 = this.anIntArray101[local54];
					local310 = Static10.anIntArray116[local86]++;
					Static10.anIntArrayArray9[local86][local310] = local54;
					if (local86 < 10) {
						Static10.anIntArray119[local86] += local37;
					} else if (local86 == 10) {
						Static10.anIntArray117[local310] = local37;
					} else {
						Static10.anIntArray118[local310] = local37;
					}
				}
			}
		}
		local42 = 0;
		if (Static10.anIntArray116[1] > 0 || Static10.anIntArray116[2] > 0) {
			local42 = (Static10.anIntArray119[1] + Static10.anIntArray119[2]) / (Static10.anIntArray116[1] + Static10.anIntArray116[2]);
		}
		local46 = 0;
		if (Static10.anIntArray116[3] > 0 || Static10.anIntArray116[4] > 0) {
			local46 = (Static10.anIntArray119[3] + Static10.anIntArray119[4]) / (Static10.anIntArray116[3] + Static10.anIntArray116[4]);
		}
		local50 = 0;
		if (Static10.anIntArray116[6] > 0 || Static10.anIntArray116[8] > 0) {
			local50 = (Static10.anIntArray119[6] + Static10.anIntArray119[8]) / (Static10.anIntArray116[6] + Static10.anIntArray116[8]);
		}
		local86 = 0;
		local310 = Static10.anIntArray116[10];
		@Pc(436) int[] local436 = Static10.anIntArrayArray9[10];
		@Pc(438) int[] local438 = Static10.anIntArray117;
		if (local86 == local310) {
			local86 = 0;
			local310 = Static10.anIntArray116[11];
			local436 = Static10.anIntArrayArray9[11];
			local438 = Static10.anIntArray118;
		}
		if (local86 < local310) {
			local54 = local438[local86];
		} else {
			local54 = -1000;
		}
		for (@Pc(466) int local466 = 0; local466 < 10; local466++) {
			while (local466 == 0 && local54 > local42) {
				this.method246(local436[local86++]);
				if (local86 == local310 && local436 != Static10.anIntArrayArray9[11]) {
					local86 = 0;
					local310 = Static10.anIntArray116[11];
					local436 = Static10.anIntArrayArray9[11];
					local438 = Static10.anIntArray118;
				}
				if (local86 < local310) {
					local54 = local438[local86];
				} else {
					local54 = -1000;
				}
			}
			while (local466 == 3 && local54 > local46) {
				this.method246(local436[local86++]);
				if (local86 == local310 && local436 != Static10.anIntArrayArray9[11]) {
					local86 = 0;
					local310 = Static10.anIntArray116[11];
					local436 = Static10.anIntArrayArray9[11];
					local438 = Static10.anIntArray118;
				}
				if (local86 < local310) {
					local54 = local438[local86];
				} else {
					local54 = -1000;
				}
			}
			while (local466 == 5 && local54 > local50) {
				this.method246(local436[local86++]);
				if (local86 == local310 && local436 != Static10.anIntArrayArray9[11]) {
					local86 = 0;
					local310 = Static10.anIntArray116[11];
					local436 = Static10.anIntArrayArray9[11];
					local438 = Static10.anIntArray118;
				}
				if (local86 < local310) {
					local54 = local438[local86];
				} else {
					local54 = -1000;
				}
			}
			@Pc(604) int local604 = Static10.anIntArray116[local466];
			@Pc(608) int[] local608 = Static10.anIntArrayArray9[local466];
			for (@Pc(610) int local610 = 0; local610 < local604; local610++) {
				this.method246(local608[local610]);
			}
		}
		while (local54 != -1000) {
			this.method246(local436[local86++]);
			if (local86 == local310 && local436 != Static10.anIntArrayArray9[11]) {
				local86 = 0;
				local436 = Static10.anIntArrayArray9[11];
				local310 = Static10.anIntArray116[11];
				local438 = Static10.anIntArray118;
			}
			if (local86 < local310) {
				local54 = local438[local86];
			} else {
				local54 = -1000;
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "f", descriptor = "(I)V")
	private void method246(@OriginalArg(0) int arg0) {
		if (Static10.aBooleanArray3[arg0]) {
			this.method247(arg0);
			return;
		}
		@Pc(14) int local14 = this.anIntArray94[arg0];
		@Pc(19) int local19 = this.anIntArray95[arg0];
		@Pc(24) int local24 = this.anIntArray96[arg0];
		Static15.aBoolean97 = Static10.aBooleanArray2[arg0];
		if (this.anIntArray102 == null) {
			Static15.anInt429 = 0;
		} else {
			Static15.anInt429 = this.anIntArray102[arg0];
		}
		@Pc(45) int local45;
		if (this.anIntArray100 == null) {
			local45 = 0;
		} else {
			local45 = this.anIntArray100[arg0] & 0x3;
		}
		if (local45 == 0) {
			Static15.method298(Static10.anIntArray110[local14], Static10.anIntArray110[local19], Static10.anIntArray110[local24], Static10.anIntArray109[local14], Static10.anIntArray109[local19], Static10.anIntArray109[local24], this.anIntArray97[arg0], this.anIntArray98[arg0], this.anIntArray99[arg0]);
		} else if (local45 == 1) {
			Static15.method300(Static10.anIntArray110[local14], Static10.anIntArray110[local19], Static10.anIntArray110[local24], Static10.anIntArray109[local14], Static10.anIntArray109[local19], Static10.anIntArray109[local24], Static10.anIntArray126[this.anIntArray97[arg0]]);
		} else {
			@Pc(127) int local127;
			@Pc(132) int local132;
			@Pc(137) int local137;
			@Pc(142) int local142;
			if (local45 == 2) {
				local127 = this.anIntArray100[arg0] >> 2;
				local132 = this.anIntArray104[local127];
				local137 = this.anIntArray105[local127];
				local142 = this.anIntArray106[local127];
				Static15.method302(Static10.anIntArray110[local14], Static10.anIntArray110[local19], Static10.anIntArray110[local24], Static10.anIntArray109[local14], Static10.anIntArray109[local19], Static10.anIntArray109[local24], this.anIntArray97[arg0], this.anIntArray98[arg0], this.anIntArray99[arg0], Static10.anIntArray112[local132], Static10.anIntArray112[local137], Static10.anIntArray112[local142], Static10.anIntArray113[local132], Static10.anIntArray113[local137], Static10.anIntArray113[local142], Static10.anIntArray114[local132], Static10.anIntArray114[local137], Static10.anIntArray114[local142], this.anIntArray103[arg0]);
			} else if (local45 == 3) {
				local127 = this.anIntArray100[arg0] >> 2;
				local132 = this.anIntArray104[local127];
				local137 = this.anIntArray105[local127];
				local142 = this.anIntArray106[local127];
				Static15.method302(Static10.anIntArray110[local14], Static10.anIntArray110[local19], Static10.anIntArray110[local24], Static10.anIntArray109[local14], Static10.anIntArray109[local19], Static10.anIntArray109[local24], this.anIntArray97[arg0], this.anIntArray97[arg0], this.anIntArray97[arg0], Static10.anIntArray112[local132], Static10.anIntArray112[local137], Static10.anIntArray112[local142], Static10.anIntArray113[local132], Static10.anIntArray113[local137], Static10.anIntArray113[local142], Static10.anIntArray114[local132], Static10.anIntArray114[local137], Static10.anIntArray114[local142], this.anIntArray103[arg0]);
			}
		}
	}

	@OriginalMember(owner = "client!eb", name = "g", descriptor = "(I)V")
	private void method247(@OriginalArg(0) int arg0) {
		@Pc(3) int local3 = Static15.anInt430;
		@Pc(5) int local5 = Static15.anInt431;
		@Pc(7) int local7 = 0;
		@Pc(12) int local12 = this.anIntArray94[arg0];
		@Pc(17) int local17 = this.anIntArray95[arg0];
		@Pc(22) int local22 = this.anIntArray96[arg0];
		@Pc(26) int local26 = Static10.anIntArray114[local12];
		@Pc(30) int local30 = Static10.anIntArray114[local17];
		@Pc(34) int local34 = Static10.anIntArray114[local22];
		@Pc(63) int local63;
		@Pc(67) int local67;
		@Pc(72) int local72;
		@Pc(85) int local85;
		if (local26 >= 50) {
			Static10.anIntArray120[local7] = Static10.anIntArray109[local12];
			Static10.anIntArray121[local7] = Static10.anIntArray110[local12];
			Static10.anIntArray122[local7++] = this.anIntArray97[arg0];
		} else {
			local63 = Static10.anIntArray112[local12];
			local67 = Static10.anIntArray113[local12];
			local72 = this.anIntArray97[arg0];
			if (local34 >= 50) {
				local85 = (50 - local26) * Static10.anIntArray127[local34 - local26];
				Static10.anIntArray120[local7] = local3 + (local63 + ((Static10.anIntArray112[local22] - local63) * local85 >> 16) << 9) / 50;
				Static10.anIntArray121[local7] = local5 + (local67 + ((Static10.anIntArray113[local22] - local67) * local85 >> 16) << 9) / 50;
				Static10.anIntArray122[local7++] = local72 + ((this.anIntArray99[arg0] - local72) * local85 >> 16);
			}
			if (local30 >= 50) {
				local85 = (50 - local26) * Static10.anIntArray127[local30 - local26];
				Static10.anIntArray120[local7] = local3 + (local63 + ((Static10.anIntArray112[local17] - local63) * local85 >> 16) << 9) / 50;
				Static10.anIntArray121[local7] = local5 + (local67 + ((Static10.anIntArray113[local17] - local67) * local85 >> 16) << 9) / 50;
				Static10.anIntArray122[local7++] = local72 + ((this.anIntArray98[arg0] - local72) * local85 >> 16);
			}
		}
		if (local30 >= 50) {
			Static10.anIntArray120[local7] = Static10.anIntArray109[local17];
			Static10.anIntArray121[local7] = Static10.anIntArray110[local17];
			Static10.anIntArray122[local7++] = this.anIntArray98[arg0];
		} else {
			local63 = Static10.anIntArray112[local17];
			local67 = Static10.anIntArray113[local17];
			local72 = this.anIntArray98[arg0];
			if (local26 >= 50) {
				local85 = (50 - local30) * Static10.anIntArray127[local26 - local30];
				Static10.anIntArray120[local7] = local3 + (local63 + ((Static10.anIntArray112[local12] - local63) * local85 >> 16) << 9) / 50;
				Static10.anIntArray121[local7] = local5 + (local67 + ((Static10.anIntArray113[local12] - local67) * local85 >> 16) << 9) / 50;
				Static10.anIntArray122[local7++] = local72 + ((this.anIntArray97[arg0] - local72) * local85 >> 16);
			}
			if (local34 >= 50) {
				local85 = (50 - local30) * Static10.anIntArray127[local34 - local30];
				Static10.anIntArray120[local7] = local3 + (local63 + ((Static10.anIntArray112[local22] - local63) * local85 >> 16) << 9) / 50;
				Static10.anIntArray121[local7] = local5 + (local67 + ((Static10.anIntArray113[local22] - local67) * local85 >> 16) << 9) / 50;
				Static10.anIntArray122[local7++] = local72 + ((this.anIntArray99[arg0] - local72) * local85 >> 16);
			}
		}
		if (local34 >= 50) {
			Static10.anIntArray120[local7] = Static10.anIntArray109[local22];
			Static10.anIntArray121[local7] = Static10.anIntArray110[local22];
			Static10.anIntArray122[local7++] = this.anIntArray99[arg0];
		} else {
			local63 = Static10.anIntArray112[local22];
			local67 = Static10.anIntArray113[local22];
			local72 = this.anIntArray99[arg0];
			if (local30 >= 50) {
				local85 = (50 - local34) * Static10.anIntArray127[local30 - local34];
				Static10.anIntArray120[local7] = local3 + (local63 + ((Static10.anIntArray112[local17] - local63) * local85 >> 16) << 9) / 50;
				Static10.anIntArray121[local7] = local5 + (local67 + ((Static10.anIntArray113[local17] - local67) * local85 >> 16) << 9) / 50;
				Static10.anIntArray122[local7++] = local72 + ((this.anIntArray98[arg0] - local72) * local85 >> 16);
			}
			if (local26 >= 50) {
				local85 = (50 - local34) * Static10.anIntArray127[local26 - local34];
				Static10.anIntArray120[local7] = local3 + (local63 + ((Static10.anIntArray112[local12] - local63) * local85 >> 16) << 9) / 50;
				Static10.anIntArray121[local7] = local5 + (local67 + ((Static10.anIntArray113[local12] - local67) * local85 >> 16) << 9) / 50;
				Static10.anIntArray122[local7++] = local72 + ((this.anIntArray97[arg0] - local72) * local85 >> 16);
			}
		}
		local63 = Static10.anIntArray120[0];
		local67 = Static10.anIntArray120[1];
		local72 = Static10.anIntArray120[2];
		local85 = Static10.anIntArray121[0];
		@Pc(582) int local582 = Static10.anIntArray121[1];
		@Pc(586) int local586 = Static10.anIntArray121[2];
		if ((local63 - local67) * (local586 - local582) - (local85 - local582) * (local72 - local67) <= 0) {
			return;
		}
		Static15.aBoolean97 = false;
		@Pc(629) int local629;
		@Pc(686) int local686;
		@Pc(691) int local691;
		@Pc(696) int local696;
		@Pc(701) int local701;
		if (local7 == 3) {
			if (local63 < 0 || local67 < 0 || local72 < 0 || local63 > Static12.anInt534 || local67 > Static12.anInt534 || local72 > Static12.anInt534) {
				Static15.aBoolean97 = true;
			}
			if (this.anIntArray100 == null) {
				local629 = 0;
			} else {
				local629 = this.anIntArray100[arg0] & 0x3;
			}
			if (local629 == 0) {
				Static15.method298(local85, local582, local586, local63, local67, local72, Static10.anIntArray122[0], Static10.anIntArray122[1], Static10.anIntArray122[2]);
			} else if (local629 == 1) {
				Static15.method300(local85, local582, local586, local63, local67, local72, Static10.anIntArray126[this.anIntArray97[arg0]]);
			} else if (local629 == 2) {
				local686 = this.anIntArray100[arg0] >> 2;
				local691 = this.anIntArray104[local686];
				local696 = this.anIntArray105[local686];
				local701 = this.anIntArray106[local686];
				Static15.method302(local85, local582, local586, local63, local67, local72, Static10.anIntArray122[0], Static10.anIntArray122[1], Static10.anIntArray122[2], Static10.anIntArray112[local691], Static10.anIntArray112[local696], Static10.anIntArray112[local701], Static10.anIntArray113[local691], Static10.anIntArray113[local696], Static10.anIntArray113[local701], Static10.anIntArray114[local691], Static10.anIntArray114[local696], Static10.anIntArray114[local701], this.anIntArray103[arg0]);
			} else if (local629 == 3) {
				local686 = this.anIntArray100[arg0] >> 2;
				local691 = this.anIntArray104[local686];
				local696 = this.anIntArray105[local686];
				local701 = this.anIntArray106[local686];
				Static15.method302(local85, local582, local586, local63, local67, local72, this.anIntArray97[arg0], this.anIntArray97[arg0], this.anIntArray97[arg0], Static10.anIntArray112[local691], Static10.anIntArray112[local696], Static10.anIntArray112[local701], Static10.anIntArray113[local691], Static10.anIntArray113[local696], Static10.anIntArray113[local701], Static10.anIntArray114[local691], Static10.anIntArray114[local696], Static10.anIntArray114[local701], this.anIntArray103[arg0]);
			}
		}
		if (local7 != 4) {
			return;
		}
		if (local63 < 0 || local67 < 0 || local72 < 0 || local63 > Static12.anInt534 || local67 > Static12.anInt534 || local72 > Static12.anInt534 || Static10.anIntArray120[3] < 0 || Static10.anIntArray120[3] > Static12.anInt534) {
			Static15.aBoolean97 = true;
		}
		if (this.anIntArray100 == null) {
			local629 = 0;
		} else {
			local629 = this.anIntArray100[arg0] & 0x3;
		}
		if (local629 == 0) {
			Static15.method298(local85, local582, local586, local63, local67, local72, Static10.anIntArray122[0], Static10.anIntArray122[1], Static10.anIntArray122[2]);
			Static15.method298(local85, local586, Static10.anIntArray121[3], local63, local72, Static10.anIntArray120[3], Static10.anIntArray122[0], Static10.anIntArray122[2], Static10.anIntArray122[3]);
			return;
		}
		if (local629 == 1) {
			local686 = Static10.anIntArray126[this.anIntArray97[arg0]];
			Static15.method300(local85, local582, local586, local63, local67, local72, local686);
			Static15.method300(local85, local586, Static10.anIntArray121[3], local63, local72, Static10.anIntArray120[3], local686);
			return;
		}
		if (local629 == 2) {
			local686 = this.anIntArray100[arg0] >> 2;
			local691 = this.anIntArray104[local686];
			local696 = this.anIntArray105[local686];
			local701 = this.anIntArray106[local686];
			Static15.method302(local85, local582, local586, local63, local67, local72, Static10.anIntArray122[0], Static10.anIntArray122[1], Static10.anIntArray122[2], Static10.anIntArray112[local691], Static10.anIntArray112[local696], Static10.anIntArray112[local701], Static10.anIntArray113[local691], Static10.anIntArray113[local696], Static10.anIntArray113[local701], Static10.anIntArray114[local691], Static10.anIntArray114[local696], Static10.anIntArray114[local701], this.anIntArray103[arg0]);
			Static15.method302(local85, local586, Static10.anIntArray121[3], local63, local72, Static10.anIntArray120[3], Static10.anIntArray122[0], Static10.anIntArray122[2], Static10.anIntArray122[3], Static10.anIntArray112[local691], Static10.anIntArray112[local696], Static10.anIntArray112[local701], Static10.anIntArray113[local691], Static10.anIntArray113[local696], Static10.anIntArray113[local701], Static10.anIntArray114[local691], Static10.anIntArray114[local696], Static10.anIntArray114[local701], this.anIntArray103[arg0]);
			return;
		}
		if (local629 != 3) {
			return;
		}
		local686 = this.anIntArray100[arg0] >> 2;
		local691 = this.anIntArray104[local686];
		local696 = this.anIntArray105[local686];
		local701 = this.anIntArray106[local686];
		Static15.method302(local85, local582, local586, local63, local67, local72, this.anIntArray97[arg0], this.anIntArray97[arg0], this.anIntArray97[arg0], Static10.anIntArray112[local691], Static10.anIntArray112[local696], Static10.anIntArray112[local701], Static10.anIntArray113[local691], Static10.anIntArray113[local696], Static10.anIntArray113[local701], Static10.anIntArray114[local691], Static10.anIntArray114[local696], Static10.anIntArray114[local701], this.anIntArray103[arg0]);
		Static15.method302(local85, local586, Static10.anIntArray121[3], local63, local72, Static10.anIntArray120[3], this.anIntArray97[arg0], this.anIntArray97[arg0], this.anIntArray97[arg0], Static10.anIntArray112[local691], Static10.anIntArray112[local696], Static10.anIntArray112[local701], Static10.anIntArray113[local691], Static10.anIntArray113[local696], Static10.anIntArray113[local701], Static10.anIntArray114[local691], Static10.anIntArray114[local696], Static10.anIntArray114[local701], this.anIntArray103[arg0]);
	}

	@OriginalMember(owner = "client!eb", name = "a", descriptor = "(IIIIIIII)Z")
	private boolean method248(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		if (arg1 < arg2 && arg1 < arg3 && arg1 < arg4) {
			return false;
		} else if (arg1 > arg2 && arg1 > arg3 && arg1 > arg4) {
			return false;
		} else if (arg0 < arg5 && arg0 < arg6 && arg0 < arg7) {
			return false;
		} else {
			return arg0 <= arg5 || arg0 <= arg6 || arg0 <= arg7;
		}
	}
}
