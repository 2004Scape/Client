import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!bc")
public final class NpcType {

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "Z")
	private final boolean flowObfuscator1 = false;

	@OriginalMember(owner = "client!bc", name = "b", descriptor = "I")
	private static int anInt67;

	@OriginalMember(owner = "client!bc", name = "c", descriptor = "[I")
	private static int[] anIntArray8;

	@OriginalMember(owner = "client!bc", name = "d", descriptor = "Lclient!kb;")
	private static Buffer aClass1_Sub3_Sub3_2;

	@OriginalMember(owner = "client!bc", name = "e", descriptor = "[Lclient!bc;")
	private static NpcType[] aClass3Array1;

	@OriginalMember(owner = "client!bc", name = "f", descriptor = "I")
	private static int anInt68;

	@OriginalMember(owner = "client!bc", name = "g", descriptor = "J")
	public long aLong5 = -1L;

	@OriginalMember(owner = "client!bc", name = "h", descriptor = "Ljava/lang/String;")
	public String aString2;

	@OriginalMember(owner = "client!bc", name = "i", descriptor = "[B")
	public byte[] aByteArray2;

	@OriginalMember(owner = "client!bc", name = "j", descriptor = "B")
	public byte size = 1;

	@OriginalMember(owner = "client!bc", name = "k", descriptor = "[I")
	private int[] anIntArray9;

	@OriginalMember(owner = "client!bc", name = "l", descriptor = "[I")
	private int[] anIntArray10;

	@OriginalMember(owner = "client!bc", name = "m", descriptor = "I")
	public int seqStandId = -1;

	@OriginalMember(owner = "client!bc", name = "n", descriptor = "I")
	public int seqWalkId = -1;

	@OriginalMember(owner = "client!bc", name = "o", descriptor = "I")
	public int seqTurnAroundId = -1;

	@OriginalMember(owner = "client!bc", name = "p", descriptor = "I")
	public int seqTurnLeftId = -1;

	@OriginalMember(owner = "client!bc", name = "q", descriptor = "I")
	public int seqTurnRightId = -1;

	@OriginalMember(owner = "client!bc", name = "r", descriptor = "Z")
	private boolean aBoolean19 = false;

	@OriginalMember(owner = "client!bc", name = "s", descriptor = "[I")
	private int[] anIntArray11;

	@OriginalMember(owner = "client!bc", name = "t", descriptor = "[I")
	private int[] anIntArray12;

	@OriginalMember(owner = "client!bc", name = "u", descriptor = "[Ljava/lang/String;")
	public String[] aStringArray2;

	@OriginalMember(owner = "client!bc", name = "v", descriptor = "I")
	private int anInt74 = -1;

	@OriginalMember(owner = "client!bc", name = "w", descriptor = "I")
	private int anInt75 = -1;

	@OriginalMember(owner = "client!bc", name = "x", descriptor = "I")
	private int anInt76 = -1;

	@OriginalMember(owner = "client!bc", name = "y", descriptor = "Z")
	public boolean aBoolean20 = true;

	@OriginalMember(owner = "client!bc", name = "z", descriptor = "I")
	public int anInt77 = -1;

	@OriginalMember(owner = "client!bc", name = "A", descriptor = "I")
	private int anInt78 = 128;

	@OriginalMember(owner = "client!bc", name = "B", descriptor = "I")
	private int anInt79 = 128;

	@OriginalMember(owner = "client!bc", name = "C", descriptor = "Lclient!s;")
	public static Cache aClass35_3 = new Cache((byte) 0, 30);

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Lclient!ub;)V")
	public static void method30(@OriginalArg(0) FileArchive arg0) {
		aClass1_Sub3_Sub3_2 = new Buffer(363, arg0.method536("npc.dat", null, (byte) 2));
		@Pc(21) Buffer local21 = new Buffer(363, arg0.method536("npc.idx", null, (byte) 2));
		anInt67 = local21.method393();
		anIntArray8 = new int[anInt67];
		@Pc(29) int local29 = 2;
		for (@Pc(31) int local31 = 0; local31 < anInt67; local31++) {
			anIntArray8[local31] = local29;
			local29 += local21.method393();
		}
		aClass3Array1 = new NpcType[20];
		for (@Pc(51) int local51 = 0; local51 < 20; local51++) {
			aClass3Array1[local51] = new NpcType();
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(Z)V")
	public static void method31(@OriginalArg(0) boolean arg0) {
		try {
			aClass35_3 = null;
			anIntArray8 = null;
			aClass3Array1 = null;
			if (!arg0) {
				for (@Pc(9) int local9 = 1; local9 > 0; local9++) {
				}
			}
			aClass1_Sub3_Sub3_2 = null;
		} catch (@Pc(18) RuntimeException local18) {
			signlink.reporterror("32991, " + arg0 + ", " + local18.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(I)Lclient!bc;")
	public static NpcType method32(@OriginalArg(0) int arg0) {
		for (@Pc(1) int local1 = 0; local1 < 20; local1++) {
			if (aClass3Array1[local1].aLong5 == (long) arg0) {
				return aClass3Array1[local1];
			}
		}
		anInt68 = (anInt68 + 1) % 20;
		@Pc(33) NpcType local33 = aClass3Array1[anInt68] = new NpcType();
		aClass1_Sub3_Sub3_2.position = anIntArray8[arg0];
		local33.aLong5 = arg0;
		local33.method33(false, aClass1_Sub3_Sub3_2);
		return local33;
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method33(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
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
					@Pc(19) int local19;
					@Pc(25) int local25;
					if (local10 == 1) {
						local19 = arg1.method391();
						this.anIntArray9 = new int[local19];
						for (local25 = 0; local25 < local19; local25++) {
							this.anIntArray9[local25] = arg1.method393();
						}
					} else if (local10 == 2) {
						this.aString2 = arg1.method398();
					} else if (local10 == 3) {
						this.aByteArray2 = arg1.method399((byte) 31);
					} else if (local10 == 12) {
						this.size = arg1.method392();
					} else if (local10 == 13) {
						this.seqStandId = arg1.method393();
					} else if (local10 == 14) {
						this.seqWalkId = arg1.method393();
					} else if (local10 == 16) {
						this.aBoolean19 = true;
					} else if (local10 == 17) {
						this.seqWalkId = arg1.method393();
						this.seqTurnAroundId = arg1.method393();
						this.seqTurnLeftId = arg1.method393();
						this.seqTurnRightId = arg1.method393();
					} else if (local10 >= 30 && local10 < 40) {
						if (this.aStringArray2 == null) {
							this.aStringArray2 = new String[5];
						}
						this.aStringArray2[local10 - 30] = arg1.method398();
						if (this.aStringArray2[local10 - 30].equalsIgnoreCase("hidden")) {
							this.aStringArray2[local10 - 30] = null;
						}
					} else if (local10 == 40) {
						local19 = arg1.method391();
						this.anIntArray11 = new int[local19];
						this.anIntArray12 = new int[local19];
						for (local25 = 0; local25 < local19; local25++) {
							this.anIntArray11[local25] = arg1.method393();
							this.anIntArray12[local25] = arg1.method393();
						}
					} else if (local10 == 60) {
						local19 = arg1.method391();
						this.anIntArray10 = new int[local19];
						for (local25 = 0; local25 < local19; local25++) {
							this.anIntArray10[local25] = arg1.method393();
						}
					} else if (local10 == 90) {
						this.anInt74 = arg1.method393();
					} else if (local10 == 91) {
						this.anInt75 = arg1.method393();
					} else if (local10 == 92) {
						this.anInt76 = arg1.method393();
					} else if (local10 == 93) {
						this.aBoolean20 = false;
					} else if (local10 == 95) {
						this.anInt77 = arg1.method393();
					} else if (local10 == 97) {
						this.anInt78 = arg1.method393();
					} else if (local10 == 98) {
						this.anInt79 = arg1.method393();
					}
				}
			}
		} catch (@Pc(277) RuntimeException local277) {
			signlink.reporterror("30732, " + arg0 + ", " + arg1 + ", " + local277.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!bc", name = "a", descriptor = "(II[I)Lclient!eb;")
	public Model getSequencedModel(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int[] arg2) {
		@Pc(3) Model local3 = null;
		@Pc(9) Model local9 = (Model) aClass35_3.get(this.aLong5);
		if (local9 == null) {
			@Pc(16) Model[] local16 = new Model[this.anIntArray9.length];
			for (@Pc(18) int local18 = 0; local18 < this.anIntArray9.length; local18++) {
				local16[local18] = new Model(false, this.anIntArray9[local18]);
			}
			if (local16.length == 1) {
				local9 = local16[0];
			} else {
				local9 = new Model(0, local16, local16.length);
			}
			if (this.anIntArray11 != null) {
				for (@Pc(60) int local60 = 0; local60 < this.anIntArray11.length; local60++) {
					local9.recolor(this.anIntArray11[local60], this.anIntArray12[local60]);
				}
			}
			local9.createLabelReferences(4);
			local9.calculateNormals(64, 850, -30, -50, -30, true);
			aClass35_3.put(6, this.aLong5, local9);
		}
		local3 = new Model(0, local9, !this.aBoolean19);
		if (arg0 != -1 && arg1 != -1) {
			local3.applyTransforms(arg1, 3, arg0, arg2);
		} else if (arg0 != -1) {
			local3.applyTransform(-16599, arg0);
		}
		if (this.anInt78 != 128 || this.anInt79 != 128) {
			local3.scale(this.anInt78, 2, this.anInt79, this.anInt78);
		}
		local3.calculateBoundsCylinder(2992);
		local3.labelFaces = null;
		local3.labelVertices = null;
		if (this.size == 1) {
			local3.pickable = true;
		}
		return local3;
	}

	@OriginalMember(owner = "client!bc", name = "b", descriptor = "(Z)Lclient!eb;")
	public Model method35(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				throw new NullPointerException();
			} else if (this.anIntArray10 == null) {
				return null;
			} else {
				@Pc(17) Model[] local17 = new Model[this.anIntArray10.length];
				for (@Pc(19) int local19 = 0; local19 < this.anIntArray10.length; local19++) {
					local17[local19] = new Model(false, this.anIntArray10[local19]);
				}
				@Pc(46) Model local46;
				if (local17.length == 1) {
					local46 = local17[0];
				} else {
					local46 = new Model(0, local17, local17.length);
				}
				if (this.anIntArray11 != null) {
					for (@Pc(61) int local61 = 0; local61 < this.anIntArray11.length; local61++) {
						local46.recolor(this.anIntArray11[local61], this.anIntArray12[local61]);
					}
				}
				return local46;
			}
		} catch (@Pc(82) RuntimeException local82) {
			signlink.reporterror("86097, " + arg0 + ", " + local82.toString());
			throw new RuntimeException();
		}
	}
}
