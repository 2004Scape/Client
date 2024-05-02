import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!mapview")
public final class mapview extends Applet_Sub1 {

	@OriginalMember(owner = "mapview!mapview", name = "M", descriptor = "I")
	private int anInt119;

	@OriginalMember(owner = "mapview!mapview", name = "N", descriptor = "[I")
	private int[] anIntArray23;

	@OriginalMember(owner = "mapview!mapview", name = "O", descriptor = "[I")
	private int[] anIntArray24;

	@OriginalMember(owner = "mapview!mapview", name = "P", descriptor = "[[I")
	private int[][] anIntArrayArray1;

	@OriginalMember(owner = "mapview!mapview", name = "Q", descriptor = "[[I")
	private int[][] anIntArrayArray2;

	@OriginalMember(owner = "mapview!mapview", name = "R", descriptor = "[[B")
	private byte[][] aByteArrayArray2;

	@OriginalMember(owner = "mapview!mapview", name = "S", descriptor = "[[B")
	private byte[][] aByteArrayArray3;

	@OriginalMember(owner = "mapview!mapview", name = "T", descriptor = "[[B")
	private byte[][] aByteArrayArray4;

	@OriginalMember(owner = "mapview!mapview", name = "U", descriptor = "[[B")
	private byte[][] aByteArrayArray5;

	@OriginalMember(owner = "mapview!mapview", name = "X", descriptor = "Lmapview!j;")
	private Class2_Sub1_Sub1_Sub4 aClass2_Sub1_Sub1_Sub4_1;

	@OriginalMember(owner = "mapview!mapview", name = "Y", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_1;

	@OriginalMember(owner = "mapview!mapview", name = "Z", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_2;

	@OriginalMember(owner = "mapview!mapview", name = "ab", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_3;

	@OriginalMember(owner = "mapview!mapview", name = "bb", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_4;

	@OriginalMember(owner = "mapview!mapview", name = "cb", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_5;

	@OriginalMember(owner = "mapview!mapview", name = "db", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_6;

	@OriginalMember(owner = "mapview!mapview", name = "eb", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_7;

	@OriginalMember(owner = "mapview!mapview", name = "fb", descriptor = "Lmapview!g;")
	private Class2_Sub1_Sub1_Sub1 aClass2_Sub1_Sub1_Sub1_8;

	@OriginalMember(owner = "mapview!mapview", name = "jb", descriptor = "I")
	private int anInt120;

	@OriginalMember(owner = "mapview!mapview", name = "rb", descriptor = "I")
	private int anInt125;

	@OriginalMember(owner = "mapview!mapview", name = "sb", descriptor = "I")
	private int anInt126;

	@OriginalMember(owner = "mapview!mapview", name = "xb", descriptor = "I")
	private int anInt130;

	@OriginalMember(owner = "mapview!mapview", name = "Db", descriptor = "Lmapview!h;")
	private Class2_Sub1_Sub1_Sub2 aClass2_Sub1_Sub1_Sub2_1;

	@OriginalMember(owner = "mapview!mapview", name = "Eb", descriptor = "I")
	private int anInt135;

	@OriginalMember(owner = "mapview!mapview", name = "Fb", descriptor = "I")
	private int anInt136;

	@OriginalMember(owner = "mapview!mapview", name = "Gb", descriptor = "I")
	private int anInt137;

	@OriginalMember(owner = "mapview!mapview", name = "Hb", descriptor = "I")
	private int anInt138;

	@OriginalMember(owner = "mapview!mapview", name = "Ib", descriptor = "I")
	private int anInt139;

	@OriginalMember(owner = "mapview!mapview", name = "F", descriptor = "I")
	private int anInt113 = 8943445;

	@OriginalMember(owner = "mapview!mapview", name = "G", descriptor = "I")
	private int anInt114 = 7824964;

	@OriginalMember(owner = "mapview!mapview", name = "H", descriptor = "I")
	private int anInt115 = 6706483;

	@OriginalMember(owner = "mapview!mapview", name = "I", descriptor = "I")
	private int anInt116 = 11141120;

	@OriginalMember(owner = "mapview!mapview", name = "J", descriptor = "I")
	private int anInt117 = 10027008;

	@OriginalMember(owner = "mapview!mapview", name = "K", descriptor = "I")
	private int anInt118 = 8912896;

	@OriginalMember(owner = "mapview!mapview", name = "L", descriptor = "Z")
	private boolean aBoolean25 = true;

	@OriginalMember(owner = "mapview!mapview", name = "V", descriptor = "[Lmapview!i;")
	private Class2_Sub1_Sub1_Sub3[] aClass2_Sub1_Sub1_Sub3Array1 = new Class2_Sub1_Sub1_Sub3[50];

	@OriginalMember(owner = "mapview!mapview", name = "W", descriptor = "[Lmapview!h;")
	private Class2_Sub1_Sub1_Sub2[] aClass2_Sub1_Sub1_Sub2Array3 = new Class2_Sub1_Sub1_Sub2[50];

	@OriginalMember(owner = "mapview!mapview", name = "gb", descriptor = "[I")
	private int[] anIntArray25 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "hb", descriptor = "[I")
	private int[] anIntArray26 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "ib", descriptor = "[I")
	private int[] anIntArray27 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "kb", descriptor = "[I")
	private int[] anIntArray28 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "lb", descriptor = "[I")
	private int[] anIntArray29 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "mb", descriptor = "[I")
	private int[] anIntArray30 = new int[2000];

	@OriginalMember(owner = "mapview!mapview", name = "nb", descriptor = "I")
	private int anInt121 = 5;

	@OriginalMember(owner = "mapview!mapview", name = "ob", descriptor = "I")
	private int anInt122 = 13;

	@OriginalMember(owner = "mapview!mapview", name = "pb", descriptor = "I")
	private int anInt123 = 140;

	@OriginalMember(owner = "mapview!mapview", name = "qb", descriptor = "I")
	private int anInt124 = 470;

	@OriginalMember(owner = "mapview!mapview", name = "tb", descriptor = "Z")
	private boolean aBoolean26 = false;

	@OriginalMember(owner = "mapview!mapview", name = "ub", descriptor = "I")
	private int anInt127 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "vb", descriptor = "I")
	private int anInt128 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "wb", descriptor = "I")
	private int anInt129 = -1;

	@OriginalMember(owner = "mapview!mapview", name = "yb", descriptor = "I")
	private int anInt131 = 200;

	@OriginalMember(owner = "mapview!mapview", name = "zb", descriptor = "I")
	private int anInt132 = this.anInt131 * 1280 / 1216;

	@OriginalMember(owner = "mapview!mapview", name = "Ab", descriptor = "I")
	private int anInt133 = 635 - this.anInt132 - 5;

	@OriginalMember(owner = "mapview!mapview", name = "Bb", descriptor = "I")
	private int anInt134 = 503 - this.anInt131 - 20;

	@OriginalMember(owner = "mapview!mapview", name = "Cb", descriptor = "Z")
	private boolean aBoolean27 = false;

	@OriginalMember(owner = "mapview!mapview", name = "Jb", descriptor = "I")
	private int anInt140 = 1000;

	@OriginalMember(owner = "mapview!mapview", name = "Kb", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray1 = new String[this.anInt140];

	@OriginalMember(owner = "mapview!mapview", name = "Lb", descriptor = "[I")
	private int[] anIntArray31 = new int[this.anInt140];

	@OriginalMember(owner = "mapview!mapview", name = "Mb", descriptor = "[I")
	private int[] anIntArray32 = new int[this.anInt140];

	@OriginalMember(owner = "mapview!mapview", name = "Nb", descriptor = "[I")
	private int[] anIntArray33 = new int[this.anInt140];

	@OriginalMember(owner = "mapview!mapview", name = "Ob", descriptor = "D")
	private double aDouble1 = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Pb", descriptor = "D")
	private double aDouble2 = 4.0D;

	@OriginalMember(owner = "mapview!mapview", name = "Qb", descriptor = "I")
	private int anInt141 = 896;

	@OriginalMember(owner = "mapview!mapview", name = "Rb", descriptor = "I")
	private int anInt142 = 832;

	@OriginalMember(owner = "mapview!mapview", name = "Sb", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray2 = new String[] { "General Store", "Sword Shop", "Magic Shop", "Axe Shop", "Helmet Shop", "Bank", "Quest Start", "Amulet Shop", "Mining Site", "Furnace", "Anvil", "Combat Training", "Dungeon", "Staff Shop", "Platebody Shop", "Platelegs Shop", "Scimitar Shop", "Archery Shop", "Shield Shop", "Altar", "Herbalist", "Jewelery", "Gem Shop", "Crafting Shop", "Candle Shop", "Fishing Shop", "Fishing Spot", "Clothes Shop", "Apothecary", "Silk Trader", "Kebab Seller", "Pub/Bar", "Mace Shop", "Tannery", "Rare Trees", "Spinning Wheel", "Food Shop", "Cookery Shop", "???", "Water Source", "Cooking Range", "Skirt Shop", "Potters Wheel", "Windmill", "Mining Shop", "Chainmail Shop", "Silver Shop", "Fur Trader", "Spice Shop" };

	@OriginalMember(owner = "mapview!mapview", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] arg0) {
		@Pc(3) mapview local3 = new mapview();
		local3.method115(635, 503);
	}

	@OriginalMember(owner = "mapview!mapview", name = "<init>", descriptor = "()V")
	private mapview() {
	}

	@OriginalMember(owner = "mapview!mapview", name = "init", descriptor = "()V")
	@Override
	public void init() {
		this.method119(635, 503);
	}

	@OriginalMember(owner = "mapview!mapview", name = "c", descriptor = "()V")
	@Override
	protected void method114() {
		@Pc(4) Class7 local4 = this.method130();
		this.method111(100, "Please wait... Rendering Map");
		@Pc(16) Class2_Sub1_Sub2 local16 = new Class2_Sub1_Sub2(local4.method145("labels.dat", null));
		this.anInt139 = local16.method100();
		for (@Pc(22) int local22 = 0; local22 < this.anInt139; local22++) {
			this.aStringArray1[local22] = local16.method102();
			this.anIntArray31[local22] = local16.method100();
			this.anIntArray32[local22] = local16.method100();
			this.anIntArray33[local22] = local16.method98();
		}
		@Pc(61) Class2_Sub1_Sub2 local61 = new Class2_Sub1_Sub2(local4.method145("floorcol.dat", null));
		@Pc(64) int local64 = local61.method100();
		this.anIntArray23 = new int[local64 + 1];
		this.anIntArray24 = new int[local64 + 1];
		for (@Pc(78) int local78 = 0; local78 < local64; local78++) {
			this.anIntArray23[local78 + 1] = local61.method97();
			this.anIntArray24[local78 + 1] = local61.method97();
		}
		@Pc(105) byte[] local105 = local4.method145("underlay.dat", null);
		@Pc(109) byte[][] local109 = new byte[1280][1216];
		this.method123(local105, local109);
		@Pc(118) byte[] local118 = local4.method145("overlay.dat", null);
		this.anIntArrayArray2 = new int[1280][1216];
		this.aByteArrayArray2 = new byte[1280][1216];
		this.method124(local118, this.anIntArrayArray2, this.aByteArrayArray2);
		@Pc(140) byte[] local140 = local4.method145("loc.dat", null);
		this.aByteArrayArray3 = new byte[1280][1216];
		this.aByteArrayArray5 = new byte[1280][1216];
		this.aByteArrayArray4 = new byte[1280][1216];
		this.method122(local140, this.aByteArrayArray3, this.aByteArrayArray5, this.aByteArrayArray4);
		@Pc(166) int local166;
		try {
			for (local166 = 0; local166 < 50; local166++) {
				this.aClass2_Sub1_Sub1_Sub3Array1[local166] = new Class2_Sub1_Sub1_Sub3(local4, "mapscene", local166);
			}
		} catch (@Pc(184) Exception local184) {
		}
		try {
			for (local166 = 0; local166 < 50; local166++) {
				this.aClass2_Sub1_Sub1_Sub2Array3[local166] = new Class2_Sub1_Sub1_Sub2(local4, "mapfunction", local166);
			}
		} catch (@Pc(204) Exception local204) {
		}
		this.aClass2_Sub1_Sub1_Sub4_1 = new Class2_Sub1_Sub1_Sub4(local4, "b12");
		this.aClass2_Sub1_Sub1_Sub1_1 = new Class2_Sub1_Sub1_Sub1(11, true, this);
		this.aClass2_Sub1_Sub1_Sub1_2 = new Class2_Sub1_Sub1_Sub1(12, true, this);
		this.aClass2_Sub1_Sub1_Sub1_3 = new Class2_Sub1_Sub1_Sub1(14, true, this);
		this.aClass2_Sub1_Sub1_Sub1_4 = new Class2_Sub1_Sub1_Sub1(17, true, this);
		this.aClass2_Sub1_Sub1_Sub1_5 = new Class2_Sub1_Sub1_Sub1(19, true, this);
		this.aClass2_Sub1_Sub1_Sub1_6 = new Class2_Sub1_Sub1_Sub1(22, true, this);
		this.aClass2_Sub1_Sub1_Sub1_7 = new Class2_Sub1_Sub1_Sub1(26, true, this);
		this.aClass2_Sub1_Sub1_Sub1_8 = new Class2_Sub1_Sub1_Sub1(30, true, this);
		this.anIntArrayArray1 = new int[1280][1216];
		this.method125(local109, this.anIntArrayArray1);
		this.aClass2_Sub1_Sub1_Sub2_1 = new Class2_Sub1_Sub1_Sub2(this.anInt132, this.anInt131);
		this.aClass2_Sub1_Sub1_Sub2_1.method64();
		this.method128(0, 0, 1280, 1216, 0, 0, this.anInt132, this.anInt131);
		Class2_Sub1_Sub1.method86(0, 0, this.anInt132, this.anInt131, 0);
		Class2_Sub1_Sub1.method86(1, 1, this.anInt132 - 2, this.anInt131 - 2, this.anInt113);
		super.aClass4_2.method107();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B[[B[[B)V")
	private void method122(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1, @OriginalArg(2) byte[][] arg2, @OriginalArg(3) byte[][] arg3) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - 2304;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - 2816;
				@Pc(43) int local43;
				if (local16 > 0 && local27 > 0 && local16 + 64 < 1280 && local27 + 64 < 1216) {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(51) byte[] local51 = arg1[local43 + local16];
						@Pc(57) byte[] local57 = arg2[local43 + local16];
						@Pc(63) byte[] local63 = arg3[local43 + local16];
						@Pc(69) int local69 = 1216 - local27 - 1;
						for (@Pc(71) int local71 = -64; local71 < 0; local71++) {
							while (true) {
								@Pc(80) int local80 = arg0[local3++] & 0xFF;
								if (local80 == 0) {
									local69--;
									break;
								}
								if (local80 < 29) {
									local51[local69] = (byte) local80;
								} else if (local80 < 160) {
									local57[local69] = (byte) (local80 - 28);
								} else {
									local63[local69] = (byte) (local80 - 159);
									this.anIntArray28[this.anInt120] = local43 + local16;
									this.anIntArray29[this.anInt120] = local69;
									this.anIntArray30[this.anInt120] = local80 - 160;
									this.anInt120++;
								}
							}
						}
					}
				} else {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(164) byte local164;
						for (@Pc(157) int local157 = -64; local157 < 0; local157++) {
							do {
								local164 = arg0[local3++];
							} while (local164 != 0);
						}
					}
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[B)V")
	private void method123(@OriginalArg(0) byte[] arg0, @OriginalArg(1) byte[][] arg1) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - 2304;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - 2816;
				if (local16 > 0 && local27 > 0 && local16 + 64 < 1280 && local27 + 64 < 1216) {
					for (@Pc(43) int local43 = 0; local43 < 64; local43++) {
						@Pc(51) byte[] local51 = arg1[local43 + local16];
						@Pc(57) int local57 = 1216 - local27 - 1;
						for (@Pc(59) int local59 = -64; local59 < 0; local59++) {
							local51[local57--] = arg0[local3++];
						}
					}
				} else {
					local3 += 4096;
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B[[I[[B)V")
	private void method124(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int[][] arg1, @OriginalArg(2) byte[][] arg2) {
		@Pc(3) int local3 = 0;
		while (true) {
			while (local3 < arg0.length) {
				@Pc(16) int local16 = (arg0[local3++] & 0xFF) * 64 - 2304;
				@Pc(27) int local27 = (arg0[local3++] & 0xFF) * 64 - 2816;
				@Pc(72) byte local72;
				@Pc(43) int local43;
				if (local16 > 0 && local27 > 0 && local16 + 64 < 1280 && local27 + 64 < 1216) {
					for (local43 = 0; local43 < 64; local43++) {
						@Pc(51) int[] local51 = arg1[local43 + local16];
						@Pc(57) byte[] local57 = arg2[local43 + local16];
						@Pc(63) int local63 = 1216 - local27 - 1;
						for (@Pc(65) int local65 = -64; local65 < 0; local65++) {
							local72 = arg0[local3++];
							if (local72 == 0) {
								local51[local63--] = 0;
							} else {
								local57[local63] = arg0[local3++];
								local51[local63--] = this.anIntArray24[local72];
							}
						}
					}
				} else {
					for (local43 = -4096; local43 < 0; local43++) {
						local72 = arg0[local3++];
						if (local72 != 0) {
							local3++;
						}
					}
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([[B[[I)V")
	private void method125(@OriginalArg(0) byte[][] arg0, @OriginalArg(1) int[][] arg1) {
		@Pc(3) short local3 = 1280;
		@Pc(5) short local5 = 1216;
		@Pc(8) int[] local8 = new int[local5];
		for (@Pc(10) int local10 = 0; local10 < local5; local10++) {
			local8[local10] = 0;
		}
		for (@Pc(22) int local22 = 5; local22 < local3 - 5; local22++) {
			@Pc(30) byte[] local30 = arg0[local22 + 5];
			@Pc(36) byte[] local36 = arg0[local22 - 5];
			for (@Pc(38) int local38 = 0; local38 < local5; local38++) {
				local8[local38] += this.anIntArray23[local30[local38] & 0xFF] - this.anIntArray23[local36[local38] & 0xFF];
			}
			if (local22 > 10 && local22 < local3 - 10) {
				@Pc(77) int local77 = 0;
				@Pc(79) int local79 = 0;
				@Pc(81) int local81 = 0;
				@Pc(85) int[] local85 = arg1[local22];
				for (@Pc(87) int local87 = 5; local87 < local5 - 5; local87++) {
					@Pc(95) int local95 = local8[local87 - 5];
					@Pc(101) int local101 = local8[local87 + 5];
					local77 += (local101 >> 20) - (local95 >> 20);
					local79 += (local101 >> 10 & 0x3FF) - (local95 >> 10 & 0x3FF);
					local81 += (local101 & 0x3FF) - (local95 & 0x3FF);
					if (local81 > 0) {
						local85[local87] = this.method126((double) local77 / 8533.0D, (double) local79 / 8533.0D, (double) local81 / 8533.0D);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(DDD)I")
	private int method126(@OriginalArg(0) double arg0, @OriginalArg(1) double arg1, @OriginalArg(2) double arg2) {
		@Pc(3) double local3 = arg2;
		@Pc(5) double local5 = arg2;
		@Pc(7) double local7 = arg2;
		if (arg1 != 0.0D) {
			@Pc(21) double local21;
			if (arg2 < 0.5D) {
				local21 = arg2 * (arg1 + 1.0D);
			} else {
				local21 = arg2 + arg1 - arg2 * arg1;
			}
			@Pc(37) double local37 = arg2 * 2.0D - local21;
			@Pc(41) double local41 = arg0 + 0.3333333333333333D;
			if (local41 > 1.0D) {
				local41--;
			}
			@Pc(55) double local55 = arg0 - 0.3333333333333333D;
			if (local55 < 0.0D) {
				local55++;
			}
			if (local41 * 6.0D < 1.0D) {
				local3 = local37 + (local21 - local37) * 6.0D * local41;
			} else if (local41 * 2.0D < 1.0D) {
				local3 = local21;
			} else if (local41 * 3.0D < 2.0D) {
				local3 = local37 + (local21 - local37) * (0.6666666666666666D - local41) * 6.0D;
			} else {
				local3 = local37;
			}
			if (arg0 * 6.0D < 1.0D) {
				local5 = local37 + (local21 - local37) * 6.0D * arg0;
			} else if (arg0 * 2.0D < 1.0D) {
				local5 = local21;
			} else if (arg0 * 3.0D < 2.0D) {
				local5 = local37 + (local21 - local37) * (0.6666666666666666D - arg0) * 6.0D;
			} else {
				local5 = local37;
			}
			if (local55 * 6.0D < 1.0D) {
				local7 = local37 + (local21 - local37) * 6.0D * local55;
			} else if (local55 * 2.0D < 1.0D) {
				local7 = local21;
			} else if (local55 * 3.0D < 2.0D) {
				local7 = local37 + (local21 - local37) * (0.6666666666666666D - local55) * 6.0D;
			} else {
				local7 = local37;
			}
		}
		@Pc(218) int local218 = (int) (local3 * 256.0D);
		@Pc(223) int local223 = (int) (local5 * 256.0D);
		@Pc(228) int local228 = (int) (local7 * 256.0D);
		return (local218 << 16) + (local223 << 8) + local228;
	}

	@OriginalMember(owner = "mapview!mapview", name = "g", descriptor = "()V")
	@Override
	protected void method120() {
		try {
			this.anIntArray23 = null;
			this.anIntArray24 = null;
			this.anIntArrayArray1 = null;
			this.anIntArrayArray2 = null;
			this.aByteArrayArray2 = null;
			this.aByteArrayArray3 = null;
			this.aByteArrayArray4 = null;
			this.aByteArrayArray5 = null;
			this.aClass2_Sub1_Sub1_Sub3Array1 = null;
			this.aClass2_Sub1_Sub1_Sub2Array3 = null;
			this.aClass2_Sub1_Sub1_Sub4_1 = null;
			this.anIntArray25 = null;
			this.anIntArray26 = null;
			this.anIntArray27 = null;
			this.anIntArray28 = null;
			this.anIntArray29 = null;
			this.anIntArray30 = null;
			this.aClass2_Sub1_Sub1_Sub2_1 = null;
			this.aStringArray1 = null;
			this.anIntArray31 = null;
			this.anIntArray32 = null;
			this.anIntArray33 = null;
			this.aStringArray2 = null;
			System.gc();
		} catch (@Pc(71) Throwable local71) {
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "h", descriptor = "()V")
	@Override
	protected void method121() {
		if (super.anIntArray21[1] == 1) {
			this.anInt141 = (int) ((double) this.anInt141 - 16.0D / this.aDouble1);
			this.aBoolean25 = true;
		}
		if (super.anIntArray21[2] == 1) {
			this.anInt141 = (int) ((double) this.anInt141 + 16.0D / this.aDouble1);
			this.aBoolean25 = true;
		}
		if (super.anIntArray21[3] == 1) {
			this.anInt142 = (int) ((double) this.anInt142 - 16.0D / this.aDouble1);
			this.aBoolean25 = true;
		}
		if (super.anIntArray21[4] == 1) {
			this.anInt142 = (int) ((double) this.anInt142 + 16.0D / this.aDouble1);
			this.aBoolean25 = true;
		}
		@Pc(83) int local83 = 1;
		while (true) {
			do {
				if (local83 <= 0) {
					if (super.anInt108 == 1) {
						this.anInt135 = super.anInt109;
						this.anInt136 = super.anInt110;
						this.anInt137 = this.anInt141;
						this.anInt138 = this.anInt142;
						if (super.anInt109 > 170 && super.anInt109 < 220 && super.anInt110 > 471 && super.anInt110 < 503) {
							this.aDouble2 = 3.0D;
							this.anInt135 = -1;
						}
						if (super.anInt109 > 230 && super.anInt109 < 280 && super.anInt110 > 471 && super.anInt110 < 503) {
							this.aDouble2 = 4.0D;
							this.anInt135 = -1;
						}
						if (super.anInt109 > 290 && super.anInt109 < 340 && super.anInt110 > 471 && super.anInt110 < 503) {
							this.aDouble2 = 6.0D;
							this.anInt135 = -1;
						}
						if (super.anInt109 > 350 && super.anInt109 < 400 && super.anInt110 > 471 && super.anInt110 < 503) {
							this.aDouble2 = 8.0D;
							this.anInt135 = -1;
						}
						if (super.anInt109 > this.anInt121 && super.anInt110 > this.anInt122 + this.anInt124 && super.anInt109 < this.anInt121 + this.anInt123 && super.anInt110 < 503) {
							this.aBoolean26 = !this.aBoolean26;
							this.anInt135 = -1;
						}
						if (super.anInt109 > this.anInt133 && super.anInt110 > this.anInt134 + this.anInt131 && super.anInt109 < this.anInt133 + this.anInt132 && super.anInt110 < 503) {
							this.aBoolean27 = !this.aBoolean27;
							this.anInt135 = -1;
						}
						if (this.aBoolean26) {
							if (super.anInt109 > this.anInt121 && super.anInt110 > this.anInt122 && super.anInt109 < this.anInt121 + this.anInt123 && super.anInt110 < this.anInt122 + this.anInt124) {
								this.anInt135 = -1;
							}
							if (super.anInt109 > this.anInt121 && super.anInt110 > this.anInt122 && super.anInt109 < this.anInt121 + this.anInt123 && super.anInt110 < this.anInt122 + 18) {
								this.anInt126 = 0;
							}
							if (super.anInt109 > this.anInt121 && super.anInt110 > this.anInt122 + this.anInt124 - 18 && super.anInt109 < this.anInt121 + this.anInt123 && super.anInt110 < this.anInt122 + this.anInt124) {
								this.anInt126 = 25;
							}
						}
						this.aBoolean25 = true;
					}
					@Pc(463) int local463;
					@Pc(465) int local465;
					if (this.aBoolean26) {
						this.anInt127 = -1;
						if (super.anInt103 > this.anInt121 && super.anInt103 < this.anInt121 + this.anInt123) {
							local463 = this.anInt122 + 21 + 5;
							for (local465 = 0; local465 < 25; local465++) {
								if (local465 + this.anInt125 >= this.aStringArray2.length || !this.aStringArray2[local465 + this.anInt125].equals("???")) {
									if (super.anInt104 >= local463 && super.anInt104 < local463 + 17) {
										this.anInt127 = local465 + this.anInt125;
										if (super.anInt108 == 1) {
											this.anInt129 = local465 + this.anInt125;
											this.anInt130 = 50;
										}
									}
									local463 += 17;
								}
							}
						}
						if (this.anInt127 != this.anInt128) {
							this.anInt128 = this.anInt127;
							this.aBoolean25 = true;
						}
					}
					if ((super.anInt102 == 1 || super.anInt108 == 1) && this.aBoolean27) {
						local463 = super.anInt109;
						local465 = super.anInt110;
						if (super.anInt102 == 1) {
							local463 = super.anInt103;
							local465 = super.anInt104;
						}
						if (local463 > this.anInt133 && local465 > this.anInt134 && local463 < this.anInt133 + this.anInt132 && local465 < this.anInt134 + this.anInt131) {
							this.anInt141 = (local463 - this.anInt133) * 1280 / this.anInt132;
							this.anInt142 = (local465 - this.anInt134) * 1216 / this.anInt131;
							this.anInt135 = -1;
							this.aBoolean25 = true;
						}
					}
					if (super.anInt102 == 1 && this.anInt135 != -1) {
						this.anInt141 = this.anInt137 + (int) ((double) (this.anInt135 - super.anInt103) * 2.0D / this.aDouble2);
						this.anInt142 = this.anInt138 + (int) ((double) (this.anInt136 - super.anInt104) * 2.0D / this.aDouble2);
						this.aBoolean25 = true;
					}
					if (this.aDouble1 < this.aDouble2) {
						this.aBoolean25 = true;
						this.aDouble1 /= 30.0D;
						if (this.aDouble1 > this.aDouble2) {
							this.aDouble1 = this.aDouble2;
						}
					}
					if (this.aDouble1 > this.aDouble2) {
						this.aBoolean25 = true;
						this.aDouble1 /= 30.0D;
						if (this.aDouble1 < this.aDouble2) {
							this.aDouble1 = this.aDouble2;
						}
					}
					if (this.anInt125 < this.anInt126) {
						this.aBoolean25 = true;
						this.anInt125++;
					}
					if (this.anInt125 > this.anInt126) {
						this.aBoolean25 = true;
						this.anInt125--;
					}
					if (this.anInt130 > 0) {
						this.aBoolean25 = true;
						this.anInt130--;
					}
					local463 = this.anInt141 - (int) (635.0D / this.aDouble1);
					local465 = this.anInt142 - (int) (503.0D / this.aDouble1);
					@Pc(776) int local776 = this.anInt141 + (int) (635.0D / this.aDouble1);
					@Pc(785) int local785 = this.anInt142 + (int) (503.0D / this.aDouble1);
					if (local463 < 48) {
						this.anInt141 = (int) (635.0D / this.aDouble1) + 48;
					}
					if (local465 < 48) {
						this.anInt142 = (int) (503.0D / this.aDouble1) + 48;
					}
					if (local776 > 1232) {
						this.anInt141 = 1232 - (int) (635.0D / this.aDouble1);
					}
					if (local785 > 1168) {
						this.anInt142 = 1168 - (int) (503.0D / this.aDouble1);
					}
					return;
				}
				local83 = this.method116();
				if (local83 == 49) {
					this.aDouble2 = 3.0D;
					this.aBoolean25 = true;
				}
				if (local83 == 50) {
					this.aDouble2 = 4.0D;
					this.aBoolean25 = true;
				}
				if (local83 == 51) {
					this.aDouble2 = 6.0D;
					this.aBoolean25 = true;
				}
				if (local83 == 52) {
					this.aDouble2 = 8.0D;
					this.aBoolean25 = true;
				}
				if (local83 == 107 || local83 == 75) {
					this.aBoolean26 = !this.aBoolean26;
					this.aBoolean25 = true;
				}
			} while (local83 != 111 && local83 != 79);
			this.aBoolean27 = !this.aBoolean27;
			this.aBoolean25 = true;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "e", descriptor = "()V")
	@Override
	protected void method117() {
		if (this.aBoolean25) {
			this.aBoolean25 = false;
			this.anInt119 = 0;
			Class2_Sub1_Sub1.method89();
			@Pc(20) int local20 = this.anInt141 - (int) (635.0D / this.aDouble1);
			@Pc(29) int local29 = this.anInt142 - (int) (503.0D / this.aDouble1);
			@Pc(38) int local38 = this.anInt141 + (int) (635.0D / this.aDouble1);
			@Pc(47) int local47 = this.anInt142 + (int) (503.0D / this.aDouble1);
			this.method128(local20, local29, local38, local47, 0, 0, 635, 503);
			@Pc(151) int local151;
			@Pc(173) int local173;
			@Pc(186) int local186;
			if (this.aBoolean27) {
				this.aClass2_Sub1_Sub1_Sub2_1.method67(this.anInt133, this.anInt134);
				Class2_Sub1_Sub1.method85(this.anInt133 + this.anInt132 * local20 / 1280, this.anInt134 + this.anInt131 * local29 / 1216, (local38 - local20) * this.anInt132 / 1280, (local47 - local29) * this.anInt131 / 1216, 16711680, 128);
				Class2_Sub1_Sub1.method86(this.anInt133 + this.anInt132 * local20 / 1280, this.anInt134 + this.anInt131 * local29 / 1216, (local38 - local20) * this.anInt132 / 1280, (local47 - local29) * this.anInt131 / 1216, 16711680);
				if (this.anInt130 > 0 && this.anInt130 % 10 < 5) {
					for (local151 = 0; local151 < this.anInt120; local151++) {
						if (this.anIntArray30[local151] == this.anInt129) {
							local173 = this.anInt133 + this.anInt132 * this.anIntArray28[local151] / 1280;
							local186 = this.anInt134 + this.anInt131 * this.anIntArray29[local151] / 1216;
							Class2_Sub1_Sub1.method90(local173, local186, 2, 16776960, 256);
						}
					}
				}
			}
			if (this.aBoolean26) {
				this.method127(this.anInt121, this.anInt122, this.anInt123, 18, 10066329, 7829367, 5592405, "Prev page");
				this.method127(this.anInt121, this.anInt122 + 18, this.anInt123, this.anInt124 - 36, 10066329, 7829367, 5592405, "");
				this.method127(this.anInt121, this.anInt122 + this.anInt124 - 18, this.anInt123, 18, 10066329, 7829367, 5592405, "Next page");
				local151 = this.anInt122 + 3 + 18;
				for (local173 = 0; local173 < 25; local173++) {
					if (local173 + this.anInt125 < this.aClass2_Sub1_Sub1_Sub2Array3.length && local173 + this.anInt125 < this.aStringArray2.length) {
						if (this.aStringArray2[local173 + this.anInt125].equals("???")) {
							continue;
						}
						this.aClass2_Sub1_Sub1_Sub2Array3[local173 + this.anInt125].method65(this.anInt121 + 3, local151);
						this.aClass2_Sub1_Sub1_Sub4_1.method91(this.aStringArray2[local173 + this.anInt125], this.anInt121 + 21, local151 + 14, 0);
						local186 = 16777215;
						if (this.anInt127 == local173 + this.anInt125) {
							local186 = 12298922;
						}
						if (this.anInt130 > 0 && this.anInt130 % 10 < 5 && this.anInt129 == local173 + this.anInt125) {
							local186 = 16776960;
						}
						this.aClass2_Sub1_Sub1_Sub4_1.method91(this.aStringArray2[local173 + this.anInt125], this.anInt121 + 20, local151 + 13, local186);
					}
					local151 += 17;
				}
			}
			this.method127(this.anInt133, this.anInt134 + this.anInt131, this.anInt132, 18, this.anInt113, this.anInt114, this.anInt115, "Overview");
			this.method127(this.anInt121, this.anInt122 + this.anInt124, this.anInt123, 18, this.anInt113, this.anInt114, this.anInt115, "Key");
			if (this.aDouble2 == 3.0D) {
				this.method127(170, 471, 50, 30, this.anInt116, this.anInt117, this.anInt118, "37%");
			} else {
				this.method127(170, 471, 50, 30, this.anInt113, this.anInt114, this.anInt115, "37%");
			}
			if (this.aDouble2 == 4.0D) {
				this.method127(230, 471, 50, 30, this.anInt116, this.anInt117, this.anInt118, "50%");
			} else {
				this.method127(230, 471, 50, 30, this.anInt113, this.anInt114, this.anInt115, "50%");
			}
			if (this.aDouble2 == 6.0D) {
				this.method127(290, 471, 50, 30, this.anInt116, this.anInt117, this.anInt118, "75%");
			} else {
				this.method127(290, 471, 50, 30, this.anInt113, this.anInt114, this.anInt115, "75%");
			}
			if (this.aDouble2 == 8.0D) {
				this.method127(350, 471, 50, 30, this.anInt116, this.anInt117, this.anInt118, "100%");
			} else {
				this.method127(350, 471, 50, 30, this.anInt113, this.anInt114, this.anInt115, "100%");
			}
		}
		this.anInt119--;
		if (this.anInt119 <= 0) {
			super.aClass4_2.method108(super.aGraphics2, 0, 0);
			this.anInt119 = 50;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "()V")
	@Override
	protected void method110() {
		this.anInt119 = 0;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIILjava/lang/String;)V")
	private void method127(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) String arg7) {
		Class2_Sub1_Sub1.method86(arg0, arg1, arg2, arg3, 0);
		@Pc(6) int local6 = arg0 + 1;
		@Pc(7) int local7 = arg1 + 1;
		@Pc(8) int local8 = arg2 - 2;
		@Pc(9) int local9 = arg3 - 2;
		Class2_Sub1_Sub1.method88(local6, local7, local8, local9, arg5);
		Class2_Sub1_Sub1.method82(local6, local7, local8, arg4);
		Class2_Sub1_Sub1.method83(local6, local7, local9, arg4);
		Class2_Sub1_Sub1.method82(local6, local7 + local9 - 1, local8, arg6);
		Class2_Sub1_Sub1.method83(local6 + local8 - 1, local7, local9, arg6);
		this.aClass2_Sub1_Sub1_Sub4_1.method92(arg7, local6 + local8 / 2 + 1, local7 + local9 / 2 + 1 + 4, 0);
		this.aClass2_Sub1_Sub1_Sub4_1.method92(arg7, local6 + local8 / 2, local7 + local9 / 2 + 4, 16777215);
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(IIIIIIII)V")
	private void method128(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(5) int local5 = arg2 - arg0;
		@Pc(9) int local9 = arg3 - arg1;
		@Pc(17) int local17 = (arg6 - arg4 << 16) / local5;
		@Pc(25) int local25 = (arg7 - arg5 << 16) / local9;
		@Pc(35) int local35;
		@Pc(43) int local43;
		@Pc(47) int local47;
		@Pc(78) byte[] local78;
		@Pc(80) int local80;
		@Pc(88) int local88;
		@Pc(96) int local96;
		@Pc(100) int local100;
		@Pc(116) int local116;
		@Pc(144) int local144;
		for (@Pc(27) int local27 = 0; local27 < local5; local27++) {
			local35 = local17 * local27 >> 16;
			local43 = local17 * (local27 + 1) >> 16;
			local47 = local43 - local35;
			if (local47 > 0) {
				local35 += arg4;
				local43 += arg4;
				@Pc(64) int[] local64 = this.anIntArrayArray1[local27 + arg0];
				@Pc(71) int[] local71 = this.anIntArrayArray2[local27 + arg0];
				local78 = this.aByteArrayArray2[local27 + arg0];
				for (local80 = 0; local80 < local9; local80++) {
					local88 = local25 * local80 >> 16;
					local96 = local25 * (local80 + 1) >> 16;
					local100 = local96 - local88;
					if (local100 > 0) {
						local88 += arg5;
						local96 += arg5;
						local116 = local71[local80 + arg1];
						if (local116 == 0) {
							Class2_Sub1_Sub1.method88(local35, local88, local43 - local35, local96 - local88, local64[local80 + arg1]);
						} else {
							@Pc(140) byte local140 = local78[local80 + arg1];
							local144 = local140 & 0xFC;
							if (local144 == 0 || local47 <= 1 || local100 <= 1) {
								Class2_Sub1_Sub1.method88(local35, local88, local47, local100, local116);
							} else {
								this.method129(Class2_Sub1_Sub1.anIntArray10, local88 * Class2_Sub1_Sub1.anInt78 + local35, local64[local80 + arg1], local116, local47, local100, local144 >> 2, local140 & 0x3);
							}
						}
					}
				}
			}
		}
		if (arg2 - arg0 > arg6 - arg4) {
			return;
		}
		local35 = 0;
		@Pc(284) int local284;
		@Pc(295) int local295;
		@Pc(218) int local218;
		@Pc(222) int local222;
		for (local43 = 0; local43 < local5; local43++) {
			local47 = local17 * local43 >> 16;
			local218 = local17 * (local43 + 1) >> 16;
			local222 = local218 - local47;
			if (local222 > 0) {
				local78 = this.aByteArrayArray3[local43 + arg0];
				@Pc(238) byte[] local238 = this.aByteArrayArray5[local43 + arg0];
				@Pc(245) byte[] local245 = this.aByteArrayArray4[local43 + arg0];
				for (local96 = 0; local96 < local9; local96++) {
					local100 = local25 * local96 >> 16;
					local116 = local25 * (local96 + 1) >> 16;
					@Pc(267) int local267 = local116 - local100;
					if (local267 > 0) {
						local144 = local78[local96 + arg1] & 0xFF;
						if (local144 != 0) {
							if (local222 == 1) {
								local284 = local47;
							} else {
								local284 = local218 - 1;
							}
							if (local267 == 1) {
								local295 = local100;
							} else {
								local295 = local116 - 1;
							}
							@Pc(303) int local303 = 13421772;
							if (local144 >= 5 && local144 <= 8 || local144 >= 13 && local144 <= 16 || local144 >= 21 && local144 <= 24 || local144 == 27 || local144 == 28) {
								local303 = 13369344;
								local144 -= 4;
							}
							if (local144 == 1) {
								Class2_Sub1_Sub1.method83(local47, local100, local267, local303);
							} else if (local144 == 2) {
								Class2_Sub1_Sub1.method82(local47, local100, local222, local303);
							} else if (local144 == 3) {
								Class2_Sub1_Sub1.method83(local284, local100, local267, local303);
							} else if (local144 == 4) {
								Class2_Sub1_Sub1.method82(local47, local295, local222, local303);
							} else if (local144 == 9) {
								Class2_Sub1_Sub1.method83(local47, local100, local267, 16777215);
								Class2_Sub1_Sub1.method82(local47, local100, local222, local303);
							} else if (local144 == 10) {
								Class2_Sub1_Sub1.method83(local284, local100, local267, 16777215);
								Class2_Sub1_Sub1.method82(local47, local100, local222, local303);
							} else if (local144 == 11) {
								Class2_Sub1_Sub1.method83(local284, local100, local267, 16777215);
								Class2_Sub1_Sub1.method82(local47, local295, local222, local303);
							} else if (local144 == 12) {
								Class2_Sub1_Sub1.method83(local47, local100, local267, 16777215);
								Class2_Sub1_Sub1.method82(local47, local295, local222, local303);
							} else if (local144 == 17) {
								Class2_Sub1_Sub1.method82(local47, local100, 1, local303);
							} else if (local144 == 18) {
								Class2_Sub1_Sub1.method82(local284, local100, 1, local303);
							} else if (local144 == 19) {
								Class2_Sub1_Sub1.method82(local284, local295, 1, local303);
							} else if (local144 == 20) {
								Class2_Sub1_Sub1.method82(local47, local295, 1, local303);
							} else {
								@Pc(475) int local475;
								if (local144 == 25) {
									for (local475 = 0; local475 < local267; local475++) {
										Class2_Sub1_Sub1.method82(local47 + local475, local295 - local475, 1, local303);
									}
								} else if (local144 == 26) {
									for (local475 = 0; local475 < local267; local475++) {
										Class2_Sub1_Sub1.method82(local47 + local475, local100 + local475, 1, local303);
									}
								}
							}
						}
						local284 = local238[local96 + arg1] & 0xFF;
						if (local284 != 0) {
							this.aClass2_Sub1_Sub1_Sub3Array1[local284 - 1].method79(local47 - local222 / 2, local100 - local267 / 2, local222 * 2, local267 * 2);
						}
						local295 = local245[local96 + arg1] & 0xFF;
						if (local295 != 0) {
							this.anIntArray27[local35] = local295 - 1;
							this.anIntArray25[local35] = local47 + local222 / 2;
							this.anIntArray26[local35] = local100 + local267 / 2;
							local35++;
						}
					}
				}
			}
		}
		for (local47 = 0; local47 < local35; local47++) {
			this.aClass2_Sub1_Sub1_Sub2Array3[this.anIntArray27[local47]].method65(this.anIntArray25[local47] - 7, this.anIntArray26[local47] - 7);
		}
		if (this.anInt130 > 0) {
			for (local218 = 0; local218 < local35; local218++) {
				if (this.anIntArray27[local218] == this.anInt129) {
					this.aClass2_Sub1_Sub1_Sub2Array3[this.anIntArray27[local218]].method65(this.anIntArray25[local218] - 7, this.anIntArray26[local218] - 7);
					if (this.anInt130 % 10 < 5) {
						Class2_Sub1_Sub1.method90(this.anIntArray25[local218], this.anIntArray26[local218], 15, 16776960, 128);
						Class2_Sub1_Sub1.method90(this.anIntArray25[local218], this.anIntArray26[local218], 7, 16777215, 256);
					}
				}
			}
		}
		if (this.aDouble1 != this.aDouble2) {
			return;
		}
		for (local218 = 0; local218 < this.anInt139; local218++) {
			local222 = this.anIntArray31[local218];
			@Pc(704) int local704 = this.anIntArray32[local218];
			local222 -= 2304;
			@Pc(709) int local709 = 4032 - local704;
			local80 = arg4 + (arg6 - arg4) * (local222 - arg0) / (arg2 - arg0);
			local88 = arg5 + (arg7 - arg5) * (local709 - arg1) / (arg3 - arg1);
			local96 = this.anIntArray33[local218];
			local100 = 16777215;
			@Pc(746) Class2_Sub1_Sub1_Sub1 local746 = null;
			if (local96 == 0) {
				if (this.aDouble1 == 3.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_1;
				}
				if (this.aDouble1 == 4.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_2;
				}
				if (this.aDouble1 == 6.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_3;
				}
				if (this.aDouble1 == 8.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_4;
				}
			}
			if (local96 == 1) {
				if (this.aDouble1 == 3.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_3;
				}
				if (this.aDouble1 == 4.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_4;
				}
				if (this.aDouble1 == 6.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_5;
				}
				if (this.aDouble1 == 8.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_6;
				}
			}
			if (local96 == 2) {
				local100 = 16755200;
				if (this.aDouble1 == 3.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_5;
				}
				if (this.aDouble1 == 4.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_6;
				}
				if (this.aDouble1 == 6.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_7;
				}
				if (this.aDouble1 == 8.0D) {
					local746 = this.aClass2_Sub1_Sub1_Sub1_8;
				}
			}
			if (local746 != null) {
				@Pc(859) String local859 = this.aStringArray1[local218];
				local144 = 1;
				for (local284 = 0; local284 < local859.length(); local284++) {
					if (local859.charAt(local284) == '/') {
						local144++;
					}
				}
				local88 -= local746.method49() * (local144 - 1) / 2;
				local88 += local746.method53() / 2;
				while (true) {
					local295 = local859.indexOf("/");
					if (local295 == -1) {
						local746.method47(local859, local80, local88, local100, true);
						break;
					}
					@Pc(915) String local915 = local859.substring(0, local295);
					local746.method47(local915, local80, local88, local100, true);
					local88 += local746.method49();
					local859 = local859.substring(local295 + 1);
				}
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([IIIIIIII)V")
	private void method129(@OriginalArg(0) int[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		@Pc(5) int local5 = Class2_Sub1_Sub1.anInt78 - arg4;
		if (arg6 == 9) {
			arg6 = 1;
			arg7 = arg7 + 1 & 0x3;
		}
		if (arg6 == 10) {
			arg6 = 1;
			arg7 = arg7 + 3 & 0x3;
		}
		if (arg6 == 11) {
			arg6 = 8;
			arg7 = arg7 + 3 & 0x3;
		}
		@Pc(45) int local45;
		@Pc(49) int local49;
		if (arg6 == 1) {
			if (arg7 == 0) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 == 2) {
			if (arg7 == 0) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 == 3) {
			if (arg7 == 0) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 >= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 == 4) {
			if (arg7 == 0) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 >= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 1) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = 0; local49 < arg4; local49++) {
						if (local49 <= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 2) {
				for (local45 = 0; local45 < arg5; local45++) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 >= local45 >> 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			} else if (arg7 == 3) {
				for (local45 = arg5 - 1; local45 >= 0; local45--) {
					for (local49 = arg4 - 1; local49 >= 0; local49--) {
						if (local49 <= local45 << 1) {
							arg0[arg1++] = arg3;
						} else {
							arg0[arg1++] = arg2;
						}
					}
					arg1 += local5;
				}
			}
		} else if (arg6 != 5) {
			if (arg6 == 6) {
				if (arg7 == 0) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 <= arg4 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 1) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local45 <= arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 2) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 >= arg4 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 3) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local45 >= arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
			}
			if (arg6 == 7) {
				if (arg7 == 0) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 1) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 2) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 3) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 <= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
			}
			if (arg6 == 8) {
				if (arg7 == 0) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 1) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = 0; local49 < arg4; local49++) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 2) {
					for (local45 = arg5 - 1; local45 >= 0; local45--) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
				if (arg7 == 3) {
					for (local45 = 0; local45 < arg5; local45++) {
						for (local49 = arg4 - 1; local49 >= 0; local49--) {
							if (local49 >= local45 - arg5 / 2) {
								arg0[arg1++] = arg3;
							} else {
								arg0[arg1++] = arg2;
							}
						}
						arg1 += local5;
					}
					return;
				}
			}
		} else if (arg7 == 0) {
			for (local45 = arg5 - 1; local45 >= 0; local45--) {
				for (local49 = arg4 - 1; local49 >= 0; local49--) {
					if (local49 >= local45 >> 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		} else if (arg7 == 1) {
			for (local45 = arg5 - 1; local45 >= 0; local45--) {
				for (local49 = 0; local49 < arg4; local49++) {
					if (local49 <= local45 << 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		} else if (arg7 == 2) {
			for (local45 = 0; local45 < arg5; local45++) {
				for (local49 = 0; local49 < arg4; local49++) {
					if (local49 >= local45 >> 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		} else if (arg7 == 3) {
			for (local45 = 0; local45 < arg5; local45++) {
				for (local49 = arg4 - 1; local49 >= 0; local49--) {
					if (local49 <= local45 << 1) {
						arg0[arg1++] = arg3;
					} else {
						arg0[arg1++] = arg2;
					}
				}
				arg1 += local5;
			}
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "i", descriptor = "()Lmapview!p;")
	private Class7 method130() {
		@Pc(1) Object local1 = null;
		@Pc(3) String local3 = null;
		@Pc(17) byte[] local17;
		try {
			local3 = this.method132();
			local17 = this.method133(local3 + "/worldmap.dat");
			if (!this.method135(local17)) {
				local17 = null;
			}
			if (local17 != null) {
				return new Class7(local17);
			}
		} catch (@Pc(31) Throwable local31) {
		}
		local17 = this.method131();
		if (local3 != null && local17 != null) {
			try {
				this.method134(local3 + "/worldmap.dat", local17);
			} catch (@Pc(51) Throwable local51) {
			}
		}
		return new Class7(local17);
	}

	@OriginalMember(owner = "mapview!mapview", name = "j", descriptor = "()[B")
	private byte[] method131() {
		System.out.println("Updating");
		this.method111(0, "Requesting map");
		try {
			@Pc(10) String local10 = "";
			for (@Pc(12) int local12 = 0; local12 < 10; local12++) {
				local10 = local10 + Class8.anIntArray44[local12];
			}
			@Pc(40) DataInputStream local40;
			if (super.aFrame_Sub1_2 == null) {
				local40 = new DataInputStream((new URL(this.getCodeBase(), "worldmap" + local10 + ".jag")).openStream());
			} else {
				local40 = new DataInputStream(new FileInputStream("worldmap.jag"));
			}
			@Pc(63) int local63 = 0;
			@Pc(65) int local65 = 0;
			@Pc(67) int local67 = 220637;
			@Pc(70) byte[] local70 = new byte[local67];
			while (local65 < local67) {
				@Pc(76) int local76 = local67 - local65;
				if (local76 > 1000) {
					local76 = 1000;
				}
				@Pc(87) int local87 = local40.read(local70, local65, local76);
				if (local87 < 0) {
					throw new IOException("EOF");
				}
				local65 += local87;
				@Pc(104) int local104 = local65 * 100 / local67;
				if (local104 != local63) {
					this.method111(local104, "Loading map - " + local104 + "%");
				}
				local63 = local104;
			}
			local40.close();
			return local70;
		} catch (@Pc(129) IOException local129) {
			System.out.println("Error loading");
			local129.printStackTrace();
			return null;
		}
	}

	@OriginalMember(owner = "mapview!mapview", name = "k", descriptor = "()Ljava/lang/String;")
	private String method132() {
		@Pc(50) String[] local50 = new String[] { "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", "~/", "/tmp/", "" };
		@Pc(52) String local52 = ".file_store_32";
		for (@Pc(54) int local54 = 0; local54 < local50.length; local54++) {
			try {
				@Pc(60) String local60 = local50[local54];
				@Pc(68) File local68;
				if (local60.length() > 0) {
					local68 = new File(local60);
					if (!local68.exists()) {
						continue;
					}
				}
				local68 = new File(local60 + local52);
				if (local68.exists() || local68.mkdir()) {
					return local60 + local52 + "/";
				}
			} catch (@Pc(103) Exception local103) {
			}
		}
		return null;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(Ljava/lang/String;)[B")
	private byte[] method133(@OriginalArg(0) String arg0) throws IOException {
		@Pc(4) File local4 = new File(arg0);
		if (!local4.exists()) {
			return null;
		}
		@Pc(13) int local13 = (int) local4.length();
		@Pc(16) byte[] local16 = new byte[local13];
		@Pc(27) DataInputStream local27 = new DataInputStream(new BufferedInputStream(new FileInputStream(arg0)));
		local27.readFully(local16, 0, local13);
		local27.close();
		return local16;
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "(Ljava/lang/String;[B)V")
	private void method134(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) throws IOException {
		@Pc(4) FileOutputStream local4 = new FileOutputStream(arg0);
		local4.write(arg1, 0, arg1.length);
		local4.close();
	}

	@OriginalMember(owner = "mapview!mapview", name = "a", descriptor = "([B)Z")
	private boolean method135(@OriginalArg(0) byte[] arg0) throws Exception {
		if (arg0 == null) {
			return false;
		}
		@Pc(6) MessageDigest local6 = MessageDigest.getInstance("SHA");
		local6.reset();
		local6.update(arg0);
		@Pc(14) byte[] local14 = local6.digest();
		for (@Pc(16) int local16 = 0; local16 < 20; local16++) {
			if (local14[local16] != Class8.anIntArray44[local16]) {
				return false;
			}
		}
		return true;
	}
}
