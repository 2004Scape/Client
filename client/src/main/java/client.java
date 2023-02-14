import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!client")
public final class client extends Applet_Sub1 {

	@OriginalMember(owner = "client!client", name = "od", descriptor = "[I")
	private static final int[] anIntArray47 = new int[99];

	@OriginalMember(owner = "client!client", name = "G", descriptor = "I")
	private int anInt144;

	@OriginalMember(owner = "client!client", name = "H", descriptor = "I")
	private int anInt145;

	@OriginalMember(owner = "client!client", name = "I", descriptor = "I")
	private int anInt146;

	@OriginalMember(owner = "client!client", name = "J", descriptor = "I")
	private int anInt147;

	@OriginalMember(owner = "client!client", name = "K", descriptor = "I")
	private int anInt148;

	@OriginalMember(owner = "client!client", name = "L", descriptor = "I")
	private int anInt149;

	@OriginalMember(owner = "client!client", name = "M", descriptor = "I")
	private int anInt150;

	@OriginalMember(owner = "client!client", name = "P", descriptor = "[I")
	private int[] anIntArray30;

	@OriginalMember(owner = "client!client", name = "Q", descriptor = "[I")
	private int[] anIntArray31;

	@OriginalMember(owner = "client!client", name = "R", descriptor = "[I")
	private int[] anIntArray32;

	@OriginalMember(owner = "client!client", name = "S", descriptor = "I")
	private int anInt153;

	@OriginalMember(owner = "client!client", name = "T", descriptor = "I")
	private int anInt154;

	@OriginalMember(owner = "client!client", name = "U", descriptor = "I")
	private int anInt155;

	@OriginalMember(owner = "client!client", name = "V", descriptor = "I")
	private int anInt156;

	@OriginalMember(owner = "client!client", name = "Y", descriptor = "I")
	private int anInt157;

	@OriginalMember(owner = "client!client", name = "Z", descriptor = "I")
	private int anInt158;

	@OriginalMember(owner = "client!client", name = "ab", descriptor = "I")
	private int anInt159;

	@OriginalMember(owner = "client!client", name = "bb", descriptor = "I")
	private int anInt160;

	@OriginalMember(owner = "client!client", name = "cb", descriptor = "I")
	private int anInt161;

	@OriginalMember(owner = "client!client", name = "db", descriptor = "I")
	private int anInt162;

	@OriginalMember(owner = "client!client", name = "eb", descriptor = "I")
	private int anInt163;

	@OriginalMember(owner = "client!client", name = "hb", descriptor = "Lclient!tb;")
	private Class38 aClass38_1;

	@OriginalMember(owner = "client!client", name = "jb", descriptor = "I")
	private int anInt164;

	@OriginalMember(owner = "client!client", name = "ob", descriptor = "I")
	private int anInt168;

	@OriginalMember(owner = "client!client", name = "pb", descriptor = "I")
	private int anInt169;

	@OriginalMember(owner = "client!client", name = "qb", descriptor = "I")
	private int anInt170;

	@OriginalMember(owner = "client!client", name = "rb", descriptor = "I")
	private int anInt171;

	@OriginalMember(owner = "client!client", name = "sb", descriptor = "I")
	private int anInt172;

	@OriginalMember(owner = "client!client", name = "xb", descriptor = "I")
	private int anInt173;

	@OriginalMember(owner = "client!client", name = "yb", descriptor = "[[B")
	private byte[][] aByteArrayArray1;

	@OriginalMember(owner = "client!client", name = "Fb", descriptor = "J")
	private long aLong7;

	@OriginalMember(owner = "client!client", name = "Hb", descriptor = "I")
	private int anInt178;

	@OriginalMember(owner = "client!client", name = "Ib", descriptor = "I")
	private int anInt179;

	@OriginalMember(owner = "client!client", name = "Jb", descriptor = "I")
	private int anInt180;

	@OriginalMember(owner = "client!client", name = "Kb", descriptor = "I")
	private int anInt181;

	@OriginalMember(owner = "client!client", name = "Lb", descriptor = "I")
	private int anInt182;

	@OriginalMember(owner = "client!client", name = "Nb", descriptor = "I")
	private int anInt183;

	@OriginalMember(owner = "client!client", name = "Vb", descriptor = "I")
	private int anInt186;

	@OriginalMember(owner = "client!client", name = "Wb", descriptor = "[[[I")
	private int[][][] anIntArrayArrayArray3;

	@OriginalMember(owner = "client!client", name = "Yb", descriptor = "I")
	private int anInt187;

	@OriginalMember(owner = "client!client", name = "cc", descriptor = "I")
	private int anInt189;

	@OriginalMember(owner = "client!client", name = "dc", descriptor = "I")
	private int anInt190;

	@OriginalMember(owner = "client!client", name = "ec", descriptor = "I")
	private int anInt191;

	@OriginalMember(owner = "client!client", name = "mc", descriptor = "I")
	private int anInt196;

	@OriginalMember(owner = "client!client", name = "rc", descriptor = "I")
	private int anInt198;

	@OriginalMember(owner = "client!client", name = "tc", descriptor = "I")
	private int anInt200;

	@OriginalMember(owner = "client!client", name = "uc", descriptor = "I")
	private int anInt201;

	@OriginalMember(owner = "client!client", name = "vc", descriptor = "I")
	private int anInt202;

	@OriginalMember(owner = "client!client", name = "zc", descriptor = "I")
	private int anInt205;

	@OriginalMember(owner = "client!client", name = "Bc", descriptor = "I")
	private int anInt206;

	@OriginalMember(owner = "client!client", name = "Ec", descriptor = "I")
	private int anInt207;

	@OriginalMember(owner = "client!client", name = "Fc", descriptor = "I")
	private int anInt208;

	@OriginalMember(owner = "client!client", name = "Gc", descriptor = "I")
	private int anInt209;

	@OriginalMember(owner = "client!client", name = "Hc", descriptor = "Lclient!r;")
	private Class33 aClass33_1;

	@OriginalMember(owner = "client!client", name = "Jc", descriptor = "I")
	private int anInt210;

	@OriginalMember(owner = "client!client", name = "Nc", descriptor = "I")
	private int anInt211;

	@OriginalMember(owner = "client!client", name = "Oc", descriptor = "I")
	private int anInt212;

	@OriginalMember(owner = "client!client", name = "Pc", descriptor = "I")
	private int anInt213;

	@OriginalMember(owner = "client!client", name = "Qc", descriptor = "[[[B")
	private byte[][][] aByteArrayArrayArray7;

	@OriginalMember(owner = "client!client", name = "Rc", descriptor = "[I")
	private int[] anIntArray41;

	@OriginalMember(owner = "client!client", name = "Sc", descriptor = "[I")
	private int[] anIntArray42;

	@OriginalMember(owner = "client!client", name = "Uc", descriptor = "I")
	private int anInt214;

	@OriginalMember(owner = "client!client", name = "Vc", descriptor = "I")
	private int anInt215;

	@OriginalMember(owner = "client!client", name = "Wc", descriptor = "I")
	private int anInt216;

	@OriginalMember(owner = "client!client", name = "Xc", descriptor = "I")
	private int anInt217;

	@OriginalMember(owner = "client!client", name = "Yc", descriptor = "I")
	private int anInt218;

	@OriginalMember(owner = "client!client", name = "cd", descriptor = "Lclient!qb;")
	private Class32 aClass32_3;

	@OriginalMember(owner = "client!client", name = "dd", descriptor = "Lclient!qb;")
	private Class32 aClass32_4;

	@OriginalMember(owner = "client!client", name = "ed", descriptor = "Lclient!qb;")
	private Class32 aClass32_5;

	@OriginalMember(owner = "client!client", name = "fd", descriptor = "I")
	private int anInt219;

	@OriginalMember(owner = "client!client", name = "jd", descriptor = "I")
	private int anInt221;

	@OriginalMember(owner = "client!client", name = "md", descriptor = "I")
	private int anInt222;

	@OriginalMember(owner = "client!client", name = "nd", descriptor = "I")
	private int anInt223;

	@OriginalMember(owner = "client!client", name = "sd", descriptor = "I")
	private int anInt225;

	@OriginalMember(owner = "client!client", name = "xd", descriptor = "I")
	private int anInt226;

	@OriginalMember(owner = "client!client", name = "yd", descriptor = "I")
	private int anInt227;

	@OriginalMember(owner = "client!client", name = "zd", descriptor = "I")
	private int anInt228;

	@OriginalMember(owner = "client!client", name = "Ed", descriptor = "I")
	private int anInt231;

	@OriginalMember(owner = "client!client", name = "Jd", descriptor = "I")
	private int anInt234;

	@OriginalMember(owner = "client!client", name = "Pd", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_1;

	@OriginalMember(owner = "client!client", name = "Qd", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_2;

	@OriginalMember(owner = "client!client", name = "Rd", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_3;

	@OriginalMember(owner = "client!client", name = "Sd", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_4;

	@OriginalMember(owner = "client!client", name = "Td", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_5;

	@OriginalMember(owner = "client!client", name = "Yd", descriptor = "J")
	private long aLong8;

	@OriginalMember(owner = "client!client", name = "Zd", descriptor = "I")
	private int anInt239;

	@OriginalMember(owner = "client!client", name = "be", descriptor = "[I")
	private int[] anIntArray50;

	@OriginalMember(owner = "client!client", name = "ce", descriptor = "[I")
	private int[] anIntArray51;

	@OriginalMember(owner = "client!client", name = "de", descriptor = "[I")
	private int[] anIntArray52;

	@OriginalMember(owner = "client!client", name = "ee", descriptor = "[I")
	private int[] anIntArray53;

	@OriginalMember(owner = "client!client", name = "ge", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_6;

	@OriginalMember(owner = "client!client", name = "he", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_7;

	@OriginalMember(owner = "client!client", name = "ie", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_8;

	@OriginalMember(owner = "client!client", name = "je", descriptor = "I")
	private int anInt241;

	@OriginalMember(owner = "client!client", name = "me", descriptor = "I")
	private int anInt243;

	@OriginalMember(owner = "client!client", name = "ne", descriptor = "I")
	private int anInt244;

	@OriginalMember(owner = "client!client", name = "oe", descriptor = "I")
	private int anInt245;

	@OriginalMember(owner = "client!client", name = "pe", descriptor = "I")
	private int anInt246;

	@OriginalMember(owner = "client!client", name = "we", descriptor = "I")
	private int anInt247;

	@OriginalMember(owner = "client!client", name = "xe", descriptor = "[I")
	private int[] anIntArray56;

	@OriginalMember(owner = "client!client", name = "Ae", descriptor = "I")
	private int anInt248;

	@OriginalMember(owner = "client!client", name = "Ce", descriptor = "I")
	private int anInt249;

	@OriginalMember(owner = "client!client", name = "Ee", descriptor = "I")
	private int anInt251;

	@OriginalMember(owner = "client!client", name = "Fe", descriptor = "I")
	private int anInt252;

	@OriginalMember(owner = "client!client", name = "Ge", descriptor = "I")
	private int anInt253;

	@OriginalMember(owner = "client!client", name = "Ie", descriptor = "Ljava/lang/String;")
	private String aString8;

	@OriginalMember(owner = "client!client", name = "Le", descriptor = "I")
	private int anInt255;

	@OriginalMember(owner = "client!client", name = "Ne", descriptor = "I")
	private int anInt256;

	@OriginalMember(owner = "client!client", name = "Qe", descriptor = "I")
	private int anInt257;

	@OriginalMember(owner = "client!client", name = "Re", descriptor = "I")
	private int anInt258;

	@OriginalMember(owner = "client!client", name = "Se", descriptor = "I")
	private int anInt259;

	@OriginalMember(owner = "client!client", name = "Te", descriptor = "I")
	private int anInt260;

	@OriginalMember(owner = "client!client", name = "Ue", descriptor = "I")
	private int anInt261;

	@OriginalMember(owner = "client!client", name = "Ve", descriptor = "I")
	private int anInt262;

	@OriginalMember(owner = "client!client", name = "We", descriptor = "I")
	private int anInt263;

	@OriginalMember(owner = "client!client", name = "Xe", descriptor = "I")
	private int anInt264;

	@OriginalMember(owner = "client!client", name = "Ye", descriptor = "I")
	private int anInt265;

	@OriginalMember(owner = "client!client", name = "df", descriptor = "I")
	private int anInt267;

	@OriginalMember(owner = "client!client", name = "hf", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_1;

	@OriginalMember(owner = "client!client", name = "jf", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_2;

	@OriginalMember(owner = "client!client", name = "kf", descriptor = "I")
	private int anInt269;

	@OriginalMember(owner = "client!client", name = "of", descriptor = "Lclient!z;")
	private Class1_Sub1_Sub3_Sub2 aClass1_Sub1_Sub3_Sub2_1;

	@OriginalMember(owner = "client!client", name = "qf", descriptor = "I")
	private int anInt270;

	@OriginalMember(owner = "client!client", name = "tf", descriptor = "I")
	private int anInt272;

	@OriginalMember(owner = "client!client", name = "uf", descriptor = "[Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3[] aClass1_Sub3_Sub2_Sub3Array2;

	@OriginalMember(owner = "client!client", name = "xf", descriptor = "I")
	private int anInt273;

	@OriginalMember(owner = "client!client", name = "yf", descriptor = "I")
	private int anInt274;

	@OriginalMember(owner = "client!client", name = "zf", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_3;

	@OriginalMember(owner = "client!client", name = "Af", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_4;

	@OriginalMember(owner = "client!client", name = "Cf", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_9;

	@OriginalMember(owner = "client!client", name = "Df", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_10;

	@OriginalMember(owner = "client!client", name = "Ef", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_11;

	@OriginalMember(owner = "client!client", name = "Ff", descriptor = "I")
	private int anInt276;

	@OriginalMember(owner = "client!client", name = "Gf", descriptor = "Lclient!jb;")
	private Class1_Sub3_Sub2_Sub4 aClass1_Sub3_Sub2_Sub4_1;

	@OriginalMember(owner = "client!client", name = "Hf", descriptor = "Lclient!jb;")
	private Class1_Sub3_Sub2_Sub4 aClass1_Sub3_Sub2_Sub4_2;

	@OriginalMember(owner = "client!client", name = "If", descriptor = "Lclient!jb;")
	private Class1_Sub3_Sub2_Sub4 aClass1_Sub3_Sub2_Sub4_3;

	@OriginalMember(owner = "client!client", name = "Jf", descriptor = "Lclient!jb;")
	private Class1_Sub3_Sub2_Sub4 aClass1_Sub3_Sub2_Sub4_4;

	@OriginalMember(owner = "client!client", name = "Kf", descriptor = "I")
	private int anInt277;

	@OriginalMember(owner = "client!client", name = "Mf", descriptor = "[I")
	private int[] anIntArray64;

	@OriginalMember(owner = "client!client", name = "Nf", descriptor = "[I")
	private int[] anIntArray65;

	@OriginalMember(owner = "client!client", name = "Sf", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_5;

	@OriginalMember(owner = "client!client", name = "Uf", descriptor = "Lclient!d;")
	private Class6 aClass6_1;

	@OriginalMember(owner = "client!client", name = "Vf", descriptor = "[[B")
	private byte[][] aByteArrayArray2;

	@OriginalMember(owner = "client!client", name = "Xf", descriptor = "I")
	private int anInt281;

	@OriginalMember(owner = "client!client", name = "Yf", descriptor = "I")
	private int anInt282;

	@OriginalMember(owner = "client!client", name = "Zf", descriptor = "I")
	private int anInt283;

	@OriginalMember(owner = "client!client", name = "ag", descriptor = "I")
	private int anInt284;

	@OriginalMember(owner = "client!client", name = "bg", descriptor = "Ljava/lang/String;")
	private String aString10;

	@OriginalMember(owner = "client!client", name = "cg", descriptor = "Lclient!qb;")
	private Class32 aClass32_6;

	@OriginalMember(owner = "client!client", name = "dg", descriptor = "Lclient!qb;")
	private Class32 aClass32_7;

	@OriginalMember(owner = "client!client", name = "eg", descriptor = "Lclient!qb;")
	private Class32 aClass32_8;

	@OriginalMember(owner = "client!client", name = "fg", descriptor = "Lclient!qb;")
	private Class32 aClass32_9;

	@OriginalMember(owner = "client!client", name = "gg", descriptor = "Lclient!qb;")
	private Class32 aClass32_10;

	@OriginalMember(owner = "client!client", name = "hg", descriptor = "Lclient!qb;")
	private Class32 aClass32_11;

	@OriginalMember(owner = "client!client", name = "ig", descriptor = "Lclient!qb;")
	private Class32 aClass32_12;

	@OriginalMember(owner = "client!client", name = "jg", descriptor = "Lclient!qb;")
	private Class32 aClass32_13;

	@OriginalMember(owner = "client!client", name = "kg", descriptor = "Lclient!qb;")
	private Class32 aClass32_14;

	@OriginalMember(owner = "client!client", name = "lg", descriptor = "Lclient!qb;")
	private Class32 aClass32_15;

	@OriginalMember(owner = "client!client", name = "ng", descriptor = "I")
	private int anInt286;

	@OriginalMember(owner = "client!client", name = "rg", descriptor = "I")
	private int anInt290;

	@OriginalMember(owner = "client!client", name = "ug", descriptor = "I")
	private int anInt291;

	@OriginalMember(owner = "client!client", name = "vg", descriptor = "I")
	private int anInt292;

	@OriginalMember(owner = "client!client", name = "wg", descriptor = "I")
	private int anInt293;

	@OriginalMember(owner = "client!client", name = "xg", descriptor = "Ljava/lang/String;")
	private String aString11;

	@OriginalMember(owner = "client!client", name = "yg", descriptor = "Lclient!qb;")
	private Class32 aClass32_16;

	@OriginalMember(owner = "client!client", name = "zg", descriptor = "Lclient!qb;")
	private Class32 aClass32_17;

	@OriginalMember(owner = "client!client", name = "Ag", descriptor = "Lclient!qb;")
	private Class32 aClass32_18;

	@OriginalMember(owner = "client!client", name = "Bg", descriptor = "Lclient!qb;")
	private Class32 aClass32_19;

	@OriginalMember(owner = "client!client", name = "Cg", descriptor = "Lclient!qb;")
	private Class32 aClass32_20;

	@OriginalMember(owner = "client!client", name = "Dg", descriptor = "Lclient!qb;")
	private Class32 aClass32_21;

	@OriginalMember(owner = "client!client", name = "Eg", descriptor = "Lclient!qb;")
	private Class32 aClass32_22;

	@OriginalMember(owner = "client!client", name = "Fg", descriptor = "Lclient!qb;")
	private Class32 aClass32_23;

	@OriginalMember(owner = "client!client", name = "Gg", descriptor = "Lclient!qb;")
	private Class32 aClass32_24;

	@OriginalMember(owner = "client!client", name = "Jg", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_12;

	@OriginalMember(owner = "client!client", name = "Kg", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_13;

	@OriginalMember(owner = "client!client", name = "Lg", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_14;

	@OriginalMember(owner = "client!client", name = "Mg", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_15;

	@OriginalMember(owner = "client!client", name = "Ng", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_16;

	@OriginalMember(owner = "client!client", name = "Pg", descriptor = "Lclient!qb;")
	private Class32 aClass32_25;

	@OriginalMember(owner = "client!client", name = "Qg", descriptor = "Lclient!qb;")
	private Class32 aClass32_26;

	@OriginalMember(owner = "client!client", name = "Rg", descriptor = "Lclient!qb;")
	private Class32 aClass32_27;

	@OriginalMember(owner = "client!client", name = "Sg", descriptor = "Lclient!qb;")
	private Class32 aClass32_28;

	@OriginalMember(owner = "client!client", name = "Ug", descriptor = "I")
	private int anInt296;

	@OriginalMember(owner = "client!client", name = "Vg", descriptor = "I")
	private int anInt297;

	@OriginalMember(owner = "client!client", name = "Wg", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_6;

	@OriginalMember(owner = "client!client", name = "Xg", descriptor = "I")
	private int anInt298;

	@OriginalMember(owner = "client!client", name = "ah", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_7;

	@OriginalMember(owner = "client!client", name = "bh", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_8;

	@OriginalMember(owner = "client!client", name = "ch", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_9;

	@OriginalMember(owner = "client!client", name = "dh", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_10;

	@OriginalMember(owner = "client!client", name = "eh", descriptor = "I")
	private int anInt299;

	@OriginalMember(owner = "client!client", name = "gh", descriptor = "I")
	private int anInt300;

	@OriginalMember(owner = "client!client", name = "hh", descriptor = "Ljava/lang/String;")
	private String aString12;

	@OriginalMember(owner = "client!client", name = "ph", descriptor = "I")
	private int anInt303;

	@OriginalMember(owner = "client!client", name = "rh", descriptor = "I")
	private int anInt304;

	@OriginalMember(owner = "client!client", name = "th", descriptor = "I")
	private int anInt305;

	@OriginalMember(owner = "client!client", name = "uh", descriptor = "I")
	private int anInt306;

	@OriginalMember(owner = "client!client", name = "vh", descriptor = "I")
	private int anInt307;

	@OriginalMember(owner = "client!client", name = "yh", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_17;

	@OriginalMember(owner = "client!client", name = "zh", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_18;

	@OriginalMember(owner = "client!client", name = "Ch", descriptor = "I")
	private int anInt308;

	@OriginalMember(owner = "client!client", name = "Eh", descriptor = "I")
	private int anInt310;

	@OriginalMember(owner = "client!client", name = "Fh", descriptor = "I")
	private int anInt311;

	@OriginalMember(owner = "client!client", name = "Gh", descriptor = "I")
	private int anInt312;

	@OriginalMember(owner = "client!client", name = "Ih", descriptor = "I")
	private int anInt314;

	@OriginalMember(owner = "client!client", name = "Sh", descriptor = "I")
	private int anInt316;

	@OriginalMember(owner = "client!client", name = "Uh", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_19;

	@OriginalMember(owner = "client!client", name = "Vh", descriptor = "Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3 aClass1_Sub3_Sub2_Sub3_20;

	@OriginalMember(owner = "client!client", name = "ai", descriptor = "I")
	private int anInt320;

	@OriginalMember(owner = "client!client", name = "bi", descriptor = "I")
	private int anInt321;

	@OriginalMember(owner = "client!client", name = "ci", descriptor = "I")
	private int anInt322;

	@OriginalMember(owner = "client!client", name = "di", descriptor = "I")
	private int anInt323;

	@OriginalMember(owner = "client!client", name = "ei", descriptor = "I")
	private int anInt324;

	@OriginalMember(owner = "client!client", name = "fi", descriptor = "I")
	private int anInt325;

	@OriginalMember(owner = "client!client", name = "gi", descriptor = "I")
	private int anInt326;

	@OriginalMember(owner = "client!client", name = "ki", descriptor = "Ljava/lang/String;")
	private String aString17;

	@OriginalMember(owner = "client!client", name = "qi", descriptor = "I")
	private int anInt327;

	@OriginalMember(owner = "client!client", name = "vi", descriptor = "I")
	private int anInt331;

	@OriginalMember(owner = "client!client", name = "zi", descriptor = "I")
	private int anInt334;

	@OriginalMember(owner = "client!client", name = "Bi", descriptor = "Lclient!ub;")
	private Class39 aClass39_1;

	@OriginalMember(owner = "client!client", name = "Ki", descriptor = "Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2 aClass1_Sub3_Sub2_Sub2_11;

	@OriginalMember(owner = "client!client", name = "Li", descriptor = "J")
	private long aLong9;

	@OriginalMember(owner = "client!client", name = "Ni", descriptor = "I")
	private int anInt337;

	@OriginalMember(owner = "client!client", name = "Oi", descriptor = "I")
	private int anInt338;

	@OriginalMember(owner = "client!client", name = "Pi", descriptor = "I")
	private int anInt339;

	@OriginalMember(owner = "client!client", name = "Qi", descriptor = "I")
	private int anInt340;

	@OriginalMember(owner = "client!client", name = "Ri", descriptor = "I")
	private int anInt341;

	@OriginalMember(owner = "client!client", name = "Ti", descriptor = "I")
	private int anInt342;

	@OriginalMember(owner = "client!client", name = "Ui", descriptor = "I")
	private int anInt343;

	@OriginalMember(owner = "client!client", name = "Vi", descriptor = "I")
	private int anInt344;

	@OriginalMember(owner = "client!client", name = "N", descriptor = "I")
	private int anInt151 = 24676;

	@OriginalMember(owner = "client!client", name = "O", descriptor = "I")
	private int anInt152 = -1;

	@OriginalMember(owner = "client!client", name = "W", descriptor = "[I")
	private final int[] anIntArray33 = new int[5];

	@OriginalMember(owner = "client!client", name = "X", descriptor = "Lclient!kb;")
	private Class1_Sub3_Sub3 aClass1_Sub3_Sub3_4 = Static21.method378(1, -737);

	@OriginalMember(owner = "client!client", name = "fb", descriptor = "Z")
	private boolean aBoolean37 = false;

	@OriginalMember(owner = "client!client", name = "gb", descriptor = "Lclient!ob;")
	private Class28 aClass28_1 = new Class28(0);

	@OriginalMember(owner = "client!client", name = "ib", descriptor = "[Z")
	private final boolean[] aBooleanArray1 = new boolean[5];

	@OriginalMember(owner = "client!client", name = "kb", descriptor = "I")
	private int anInt165 = 9;

	@OriginalMember(owner = "client!client", name = "lb", descriptor = "I")
	private int anInt166 = 3;

	@OriginalMember(owner = "client!client", name = "mb", descriptor = "[[I")
	private int[][] anIntArrayArray2 = new int[104][104];

	@OriginalMember(owner = "client!client", name = "nb", descriptor = "I")
	private int anInt167 = 997;

	@OriginalMember(owner = "client!client", name = "tb", descriptor = "Ljava/lang/String;")
	private String aString5 = "";

	@OriginalMember(owner = "client!client", name = "ub", descriptor = "B")
	private final byte aByte8 = 106;

	@OriginalMember(owner = "client!client", name = "vb", descriptor = "Lclient!ob;")
	private Class28 aClass28_2 = new Class28(0);

	@OriginalMember(owner = "client!client", name = "wb", descriptor = "[J")
	private final long[] aLongArray3 = new long[100];

	@OriginalMember(owner = "client!client", name = "zb", descriptor = "I")
	private int anInt174 = 723;

	@OriginalMember(owner = "client!client", name = "Bb", descriptor = "[I")
	private int[] anIntArray34 = new int[100];

	@OriginalMember(owner = "client!client", name = "Cb", descriptor = "I")
	private int anInt176 = -1;

	@OriginalMember(owner = "client!client", name = "Db", descriptor = "Ljava/lang/String;")
	private String aString6 = "";

	@OriginalMember(owner = "client!client", name = "Eb", descriptor = "[Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2[] aClass1_Sub3_Sub2_Sub2Array3 = new Class1_Sub3_Sub2_Sub2[20];

	@OriginalMember(owner = "client!client", name = "Gb", descriptor = "I")
	private final int anInt177 = 332;

	@OriginalMember(owner = "client!client", name = "Mb", descriptor = "Ljava/lang/String;")
	private String aString7 = "";

	@OriginalMember(owner = "client!client", name = "Ob", descriptor = "I")
	private int anInt184 = -1;

	@OriginalMember(owner = "client!client", name = "Pb", descriptor = "Z")
	private boolean aBoolean38 = true;

	@OriginalMember(owner = "client!client", name = "Qb", descriptor = "Z")
	private boolean aBoolean39 = false;

	@OriginalMember(owner = "client!client", name = "Rb", descriptor = "[I")
	private final int[] anIntArray35 = new int[7];

	@OriginalMember(owner = "client!client", name = "Sb", descriptor = "B")
	private final byte aByte9 = 8;

	@OriginalMember(owner = "client!client", name = "Tb", descriptor = "[Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2[] aClass1_Sub3_Sub2_Sub2Array4 = new Class1_Sub3_Sub2_Sub2[1000];

	@OriginalMember(owner = "client!client", name = "Ub", descriptor = "I")
	private int anInt185 = 78;

	@OriginalMember(owner = "client!client", name = "Xb", descriptor = "Lclient!kb;")
	private Class1_Sub3_Sub3 aClass1_Sub3_Sub3_5 = Static21.method378(1, -737);

	@OriginalMember(owner = "client!client", name = "ac", descriptor = "Lclient!kb;")
	private Class1_Sub3_Sub3 aClass1_Sub3_Sub3_6 = Static21.method378(1, -737);

	@OriginalMember(owner = "client!client", name = "bc", descriptor = "Z")
	private boolean aBoolean40 = false;

	@OriginalMember(owner = "client!client", name = "fc", descriptor = "I")
	private final int anInt192 = 3;

	@OriginalMember(owner = "client!client", name = "hc", descriptor = "I")
	private int anInt194 = -655;

	@OriginalMember(owner = "client!client", name = "jc", descriptor = "[I")
	private final int[] anIntArray36 = new int[50];

	@OriginalMember(owner = "client!client", name = "kc", descriptor = "Lclient!hc;")
	private final Class15 aClass15_1 = new Class15();

	@OriginalMember(owner = "client!client", name = "lc", descriptor = "[I")
	private final int[] anIntArray37 = new int[50];

	@OriginalMember(owner = "client!client", name = "nc", descriptor = "[I")
	private final int[] anIntArray38 = new int[9];

	@OriginalMember(owner = "client!client", name = "oc", descriptor = "Z")
	private boolean aBoolean41 = true;

	@OriginalMember(owner = "client!client", name = "pc", descriptor = "I")
	private final int anInt197 = 4277;

	@OriginalMember(owner = "client!client", name = "qc", descriptor = "[Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3[] aClass1_Sub3_Sub2_Sub3Array1 = new Class1_Sub3_Sub2_Sub3[13];

	@OriginalMember(owner = "client!client", name = "sc", descriptor = "I")
	private int anInt199 = 128;

	@OriginalMember(owner = "client!client", name = "wc", descriptor = "I")
	private final int anInt203 = 2048;

	@OriginalMember(owner = "client!client", name = "xc", descriptor = "I")
	private final int anInt204 = 2047;

	@OriginalMember(owner = "client!client", name = "yc", descriptor = "[Lclient!z;")
	private Class1_Sub1_Sub3_Sub2[] aClass1_Sub1_Sub3_Sub2Array1 = new Class1_Sub1_Sub3_Sub2[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Ac", descriptor = "[I")
	private int[] anIntArray39 = new int[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Cc", descriptor = "[I")
	private int[] anIntArray40 = new int[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Dc", descriptor = "[Lclient!kb;")
	private Class1_Sub3_Sub3[] aClass1_Sub3_Sub3Array1 = new Class1_Sub3_Sub3[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Ic", descriptor = "Lclient!ob;")
	private Class28 aClass28_3 = new Class28(0);

	@OriginalMember(owner = "client!client", name = "Kc", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray5 = new String[500];

	@OriginalMember(owner = "client!client", name = "Lc", descriptor = "Z")
	private boolean aBoolean42 = true;

	@OriginalMember(owner = "client!client", name = "Mc", descriptor = "Z")
	private boolean aBoolean43 = true;

	@OriginalMember(owner = "client!client", name = "Tc", descriptor = "B")
	private final byte aByte10 = 4;

	@OriginalMember(owner = "client!client", name = "Zc", descriptor = "Z")
	private boolean aBoolean44 = false;

	@OriginalMember(owner = "client!client", name = "ad", descriptor = "[I")
	private final int[] anIntArray43 = new int[256];

	@OriginalMember(owner = "client!client", name = "bd", descriptor = "B")
	private final byte aByte11 = 2;

	@OriginalMember(owner = "client!client", name = "gd", descriptor = "[I")
	private final int[] anIntArray44 = new int[33];

	@OriginalMember(owner = "client!client", name = "id", descriptor = "[I")
	private final int[] anIntArray45 = new int[50];

	@OriginalMember(owner = "client!client", name = "kd", descriptor = "Z")
	private boolean aBoolean45 = false;

	@OriginalMember(owner = "client!client", name = "ld", descriptor = "[I")
	private final int[] anIntArray46 = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	@OriginalMember(owner = "client!client", name = "pd", descriptor = "Z")
	private boolean aBoolean46 = false;

	@OriginalMember(owner = "client!client", name = "qd", descriptor = "B")
	private final byte aByte12 = 99;

	@OriginalMember(owner = "client!client", name = "td", descriptor = "Z")
	private boolean aBoolean47 = false;

	@OriginalMember(owner = "client!client", name = "wd", descriptor = "Z")
	private boolean aBoolean49 = false;

	@OriginalMember(owner = "client!client", name = "Bd", descriptor = "I")
	private final int anInt230 = 100;

	@OriginalMember(owner = "client!client", name = "Cd", descriptor = "[I")
	private final int[] anIntArray48 = new int[100];

	@OriginalMember(owner = "client!client", name = "Dd", descriptor = "Z")
	private boolean aBoolean50 = false;

	@OriginalMember(owner = "client!client", name = "Fd", descriptor = "Z")
	private boolean aBoolean51 = false;

	@OriginalMember(owner = "client!client", name = "Hd", descriptor = "I")
	private int anInt233 = -655;

	@OriginalMember(owner = "client!client", name = "Id", descriptor = "Lclient!ob;")
	private Class28 aClass28_4 = new Class28(0);

	@OriginalMember(owner = "client!client", name = "Ud", descriptor = "[I")
	private final int[] anIntArray49 = new int[100];

	@OriginalMember(owner = "client!client", name = "Vd", descriptor = "[Ljava/lang/String;")
	private final String[] aStringArray6 = new String[100];

	@OriginalMember(owner = "client!client", name = "Wd", descriptor = "[Ljava/lang/String;")
	private final String[] aStringArray7 = new String[100];

	@OriginalMember(owner = "client!client", name = "ae", descriptor = "Z")
	private boolean aBoolean54 = false;

	@OriginalMember(owner = "client!client", name = "fe", descriptor = "I")
	private int anInt240 = -1;

	@OriginalMember(owner = "client!client", name = "ke", descriptor = "Z")
	private boolean aBoolean55 = false;

	@OriginalMember(owner = "client!client", name = "qe", descriptor = "[I")
	private int[] anIntArray54 = new int[1000];

	@OriginalMember(owner = "client!client", name = "re", descriptor = "[I")
	private int[] anIntArray55 = new int[1000];

	@OriginalMember(owner = "client!client", name = "se", descriptor = "[[I")
	private int[][] anIntArrayArray3 = new int[104][104];

	@OriginalMember(owner = "client!client", name = "te", descriptor = "Z")
	private boolean aBoolean56 = false;

	@OriginalMember(owner = "client!client", name = "ve", descriptor = "Z")
	private boolean aBoolean57 = false;

	@OriginalMember(owner = "client!client", name = "ye", descriptor = "[I")
	private final int[] anIntArray57 = new int[50];

	@OriginalMember(owner = "client!client", name = "ze", descriptor = "[Lclient!y;")
	private Class1_Sub1_Sub3_Sub1[] aClass1_Sub1_Sub3_Sub1Array1 = new Class1_Sub1_Sub3_Sub1[8192];

	@OriginalMember(owner = "client!client", name = "Be", descriptor = "[I")
	private int[] anIntArray58 = new int[8192];

	@OriginalMember(owner = "client!client", name = "De", descriptor = "I")
	private int anInt250 = 1;

	@OriginalMember(owner = "client!client", name = "He", descriptor = "B")
	private final byte aByte14 = -46;

	@OriginalMember(owner = "client!client", name = "Ke", descriptor = "[I")
	private int[] anIntArray59 = new int[2000];

	@OriginalMember(owner = "client!client", name = "Me", descriptor = "[I")
	private int[] anIntArray60 = new int[1000];

	@OriginalMember(owner = "client!client", name = "Pe", descriptor = "[J")
	private long[] aLongArray4 = new long[100];

	@OriginalMember(owner = "client!client", name = "Ze", descriptor = "[I")
	private final int[] anIntArray61 = new int[151];

	@OriginalMember(owner = "client!client", name = "af", descriptor = "[Lclient!ec;")
	private Class9[] aClass9Array1 = new Class9[4];

	@OriginalMember(owner = "client!client", name = "cf", descriptor = "[Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2[] aClass1_Sub3_Sub2_Sub2Array5 = new Class1_Sub3_Sub2_Sub2[20];

	@OriginalMember(owner = "client!client", name = "ff", descriptor = "[I")
	private final int[] anIntArray62 = new int[5];

	@OriginalMember(owner = "client!client", name = "gf", descriptor = "Z")
	private boolean aBoolean58 = false;

	@OriginalMember(owner = "client!client", name = "lf", descriptor = "Z")
	private boolean aBoolean59 = false;

	@OriginalMember(owner = "client!client", name = "mf", descriptor = "Z")
	private boolean aBoolean60 = false;

	@OriginalMember(owner = "client!client", name = "nf", descriptor = "[I")
	private final int[] anIntArray63 = new int[5];

	@OriginalMember(owner = "client!client", name = "pf", descriptor = "Z")
	private boolean aBoolean61 = false;

	@OriginalMember(owner = "client!client", name = "rf", descriptor = "Ljava/lang/String;")
	private String aString9 = "";

	@OriginalMember(owner = "client!client", name = "sf", descriptor = "I")
	private int anInt271 = -1;

	@OriginalMember(owner = "client!client", name = "vf", descriptor = "Z")
	private boolean aBoolean62 = false;

	@OriginalMember(owner = "client!client", name = "wf", descriptor = "Z")
	private boolean aBoolean63 = false;

	@OriginalMember(owner = "client!client", name = "Bf", descriptor = "I")
	private final int anInt275 = 3353893;

	@OriginalMember(owner = "client!client", name = "Lf", descriptor = "Z")
	private final boolean aBoolean64 = false;

	@OriginalMember(owner = "client!client", name = "Of", descriptor = "I")
	private final int anInt278 = 7759444;

	@OriginalMember(owner = "client!client", name = "Pf", descriptor = "[I")
	private int[] anIntArray66 = new int[4000];

	@OriginalMember(owner = "client!client", name = "Qf", descriptor = "[I")
	private int[] anIntArray67 = new int[4000];

	@OriginalMember(owner = "client!client", name = "Rf", descriptor = "Ljava/util/zip/CRC32;")
	private final CRC32 aCRC32_1 = new CRC32();

	@OriginalMember(owner = "client!client", name = "Wf", descriptor = "I")
	private int anInt280 = -1;

	@OriginalMember(owner = "client!client", name = "og", descriptor = "I")
	private int anInt287 = -1;

	@OriginalMember(owner = "client!client", name = "pg", descriptor = "I")
	private int anInt288 = -1;

	@OriginalMember(owner = "client!client", name = "qg", descriptor = "I")
	private int anInt289 = -1;

	@OriginalMember(owner = "client!client", name = "sg", descriptor = "Z")
	private boolean aBoolean65 = false;

	@OriginalMember(owner = "client!client", name = "tg", descriptor = "[I")
	private final int[] anIntArray68 = new int[5];

	@OriginalMember(owner = "client!client", name = "Hg", descriptor = "[Lclient!ib;")
	private Class1_Sub3_Sub2_Sub3[] aClass1_Sub3_Sub2_Sub3Array3 = new Class1_Sub3_Sub2_Sub3[50];

	@OriginalMember(owner = "client!client", name = "Ig", descriptor = "I")
	private int anInt294 = 27808;

	@OriginalMember(owner = "client!client", name = "Og", descriptor = "[I")
	private final int[] anIntArray69 = new int[] { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };

	@OriginalMember(owner = "client!client", name = "Tg", descriptor = "I")
	private final int anInt295 = 2301979;

	@OriginalMember(owner = "client!client", name = "Yg", descriptor = "Z")
	private boolean aBoolean66 = false;

	@OriginalMember(owner = "client!client", name = "Zg", descriptor = "Lclient!ob;")
	private Class28 aClass28_5 = new Class28(0);

	@OriginalMember(owner = "client!client", name = "ih", descriptor = "I")
	private int anInt301 = -1;

	@OriginalMember(owner = "client!client", name = "jh", descriptor = "Ljava/lang/String;")
	private String aString13 = "";

	@OriginalMember(owner = "client!client", name = "kh", descriptor = "Ljava/lang/String;")
	private String aString14 = "";

	@OriginalMember(owner = "client!client", name = "lh", descriptor = "B")
	private final byte aByte15 = 7;

	@OriginalMember(owner = "client!client", name = "mh", descriptor = "[B")
	private byte[] aByteArray4 = new byte[16384];

	@OriginalMember(owner = "client!client", name = "nh", descriptor = "Z")
	private boolean aBoolean67 = false;

	@OriginalMember(owner = "client!client", name = "oh", descriptor = "I")
	private final int anInt302 = 242;

	@OriginalMember(owner = "client!client", name = "sh", descriptor = "[I")
	private final int[] anIntArray71 = new int[2000];

	@OriginalMember(owner = "client!client", name = "wh", descriptor = "[I")
	private final int[] anIntArray72 = new int[50];

	@OriginalMember(owner = "client!client", name = "xh", descriptor = "Z")
	private boolean aBoolean68 = false;

	@OriginalMember(owner = "client!client", name = "Ah", descriptor = "Ljava/lang/String;")
	private String aString15 = "";

	@OriginalMember(owner = "client!client", name = "Bh", descriptor = "Ljava/lang/String;")
	private String aString16 = "";

	@OriginalMember(owner = "client!client", name = "Dh", descriptor = "I")
	private int anInt309 = 2;

	@OriginalMember(owner = "client!client", name = "Jh", descriptor = "I")
	private final int anInt315 = 50;

	@OriginalMember(owner = "client!client", name = "Kh", descriptor = "[I")
	private final int[] anIntArray73 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Lh", descriptor = "[I")
	private final int[] anIntArray74 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Mh", descriptor = "[I")
	private final int[] anIntArray75 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Nh", descriptor = "[I")
	private final int[] anIntArray76 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Oh", descriptor = "[I")
	private final int[] anIntArray77 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Ph", descriptor = "[I")
	private final int[] anIntArray78 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Qh", descriptor = "[I")
	private final int[] anIntArray79 = new int[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Rh", descriptor = "[Ljava/lang/String;")
	private final String[] aStringArray8 = new String[this.anInt315];

	@OriginalMember(owner = "client!client", name = "Wh", descriptor = "I")
	private final int anInt317 = -986;

	@OriginalMember(owner = "client!client", name = "Xh", descriptor = "I")
	private final int anInt318 = -35388;

	@OriginalMember(owner = "client!client", name = "Yh", descriptor = "[I")
	private final int[] anIntArray80 = new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };

	@OriginalMember(owner = "client!client", name = "ii", descriptor = "[I")
	private final int[] anIntArray81 = new int[33];

	@OriginalMember(owner = "client!client", name = "ji", descriptor = "[[I")
	private int[][] anIntArrayArray5 = new int[104][104];

	@OriginalMember(owner = "client!client", name = "li", descriptor = "[Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2[] aClass1_Sub3_Sub2_Sub2Array6 = new Class1_Sub3_Sub2_Sub2[8];

	@OriginalMember(owner = "client!client", name = "mi", descriptor = "Z")
	private boolean aBoolean70 = false;

	@OriginalMember(owner = "client!client", name = "ni", descriptor = "B")
	private final byte aByte17 = 94;

	@OriginalMember(owner = "client!client", name = "oi", descriptor = "Ljava/lang/Object;")
	private final Object anObject1 = new Object();

	@OriginalMember(owner = "client!client", name = "pi", descriptor = "[I")
	private final int[] anIntArray82 = new int[50];

	@OriginalMember(owner = "client!client", name = "ri", descriptor = "I")
	private int anInt328 = 2;

	@OriginalMember(owner = "client!client", name = "si", descriptor = "[Ljava/lang/String;")
	private String[] aStringArray9 = new String[100];

	@OriginalMember(owner = "client!client", name = "ti", descriptor = "I")
	private int anInt329 = -1;

	@OriginalMember(owner = "client!client", name = "ui", descriptor = "I")
	private int anInt330 = -1;

	@OriginalMember(owner = "client!client", name = "wi", descriptor = "I")
	private int anInt332 = 2;

	@OriginalMember(owner = "client!client", name = "xi", descriptor = "I")
	private int anInt333 = 29286;

	@OriginalMember(owner = "client!client", name = "yi", descriptor = "[I")
	private final int[] anIntArray83 = new int[151];

	@OriginalMember(owner = "client!client", name = "Ai", descriptor = "I")
	private int anInt335 = 1;

	@OriginalMember(owner = "client!client", name = "Ci", descriptor = "Ljava/lang/String;")
	private String aString18 = "";

	@OriginalMember(owner = "client!client", name = "Di", descriptor = "[Lclient!hb;")
	private Class1_Sub3_Sub2_Sub2[] aClass1_Sub3_Sub2_Sub2Array7 = new Class1_Sub3_Sub2_Sub2[50];

	@OriginalMember(owner = "client!client", name = "Ei", descriptor = "[I")
	private int[] anIntArray84 = new int[500];

	@OriginalMember(owner = "client!client", name = "Fi", descriptor = "[I")
	private int[] anIntArray85 = new int[500];

	@OriginalMember(owner = "client!client", name = "Gi", descriptor = "[I")
	private int[] anIntArray86 = new int[500];

	@OriginalMember(owner = "client!client", name = "Hi", descriptor = "[I")
	private int[] anIntArray87 = new int[500];

	@OriginalMember(owner = "client!client", name = "Ii", descriptor = "I")
	private final int anInt336 = 701;

	@OriginalMember(owner = "client!client", name = "Ji", descriptor = "Z")
	private boolean aBoolean71 = false;

	@OriginalMember(owner = "client!client", name = "Mi", descriptor = "Z")
	private boolean aBoolean72 = true;

	@OriginalMember(owner = "client!client", name = "Si", descriptor = "Z")
	private boolean aBoolean73 = true;

	@OriginalMember(owner = "client!client", name = "Wi", descriptor = "[[[Lclient!ob;")
	private Class28[][][] aClass28ArrayArrayArray1 = new Class28[4][104][104];

	@OriginalMember(owner = "client!client", name = "Xi", descriptor = "I")
	private final int anInt345 = 5063219;

	@OriginalMember(owner = "client!client", name = "Yi", descriptor = "[I")
	private final int[] anIntArray88 = new int[5];

	@OriginalMember(owner = "client!client", name = "Zi", descriptor = "I")
	private final int anInt346 = -676;

	static {
		@Pc(6) int local6 = 0;
		for (@Pc(8) int local8 = 0; local8 < 99; local8++) {
			@Pc(13) int local13 = local8 + 1;
			@Pc(26) int local26 = (int) ((double) local13 + Math.pow(2.0D, (double) local13 / 7.0D) * 300.0D);
			local6 += local26;
			anIntArray47[local8] = local6 / 4;
		}
	}

	@OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] arg0) {
		try {
			System.out.println("RS2 user client - release #" + 225);
			if (arg0.length == 4) {
				Static6.anInt235 = Integer.parseInt(arg0[0]);
				Static6.anInt236 = Integer.parseInt(arg0[1]);
				if (arg0[2].equals("lowmem")) {
					Static6.method88(true);
				} else if (arg0[2].equals("highmem")) {
					Static6.method167(9);
				} else {
					System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members]");
					return;
				}
				if (arg0[3].equals("free")) {
					Static6.aBoolean52 = false;
				} else if (arg0[3].equals("members")) {
					Static6.aBoolean52 = true;
				} else {
					System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members]");
					return;
				}
				signlink.startpriv(InetAddress.getByName("world2.runewiki.org"));
				@Pc(82) client local82 = new client();
				local82.method62(532, 789, 0);
			} else {
				System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members]");
			}
		} catch (@Pc(89) Exception local89) {
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILjava/lang/String;I)V")
	private void method75(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg2 != null) {
				@Pc(5) Object local5 = this.anObject1;
				synchronized (this.anObject1) {
					this.aString12 = arg2;
					this.anInt269 = arg1;
					this.anInt144 = arg3;
				}
				if (arg0) {
					this.anInt179 = -1;
				}
			}
		} catch (@Pc(29) RuntimeException local29) {
			signlink.reporterror("88096, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local29.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(I)V")
	private void method76(@OriginalArg(0) int arg0) {
		try {
			this.anInt314 = 0;
			while (arg0 >= 0) {
				this.anInt233 = this.aClass38_1.method532();
			}
			@Pc(63) int local63;
			@Pc(84) int local84;
			for (@Pc(15) int local15 = -1; local15 < this.anInt205 + this.anInt248; local15++) {
				@Pc(23) Class1_Sub1_Sub3 local23;
				if (local15 == -1) {
					local23 = this.aClass1_Sub1_Sub3_Sub2_1;
				} else if (local15 < this.anInt205) {
					local23 = this.aClass1_Sub1_Sub3_Sub2Array1[this.anIntArray39[local15]];
				} else {
					local23 = this.aClass1_Sub1_Sub3_Sub1Array1[this.anIntArray58[local15 - this.anInt205]];
				}
				if (local23 != null && local23.method571(false)) {
					if (local15 < this.anInt205) {
						local63 = 30;
						@Pc(66) Class1_Sub1_Sub3_Sub2 local66 = (Class1_Sub1_Sub3_Sub2) local23;
						if (local66.anInt931 != 0) {
							this.method151(local23.anInt925 + 15, this.aBoolean45, local23);
							if (this.anInt287 > -1) {
								for (local84 = 0; local84 < 8; local84++) {
									if ((local66.anInt931 & 0x1 << local84) != 0) {
										this.aClass1_Sub3_Sub2_Sub2Array5[local84].method322(this.anInt288 - local63, this.anInt287 - 12, false);
										local63 -= 25;
									}
								}
							}
						}
						if (local15 >= 0 && this.anInt241 == 10 && this.anInt305 == this.anIntArray39[local15]) {
							this.method151(local23.anInt925 + 15, this.aBoolean45, local23);
							if (this.anInt287 > -1) {
								this.aClass1_Sub3_Sub2_Sub2Array5[7].method322(this.anInt288 - local63, this.anInt287 - 12, false);
							}
						}
					} else if (this.anInt241 == 1 && this.anInt190 == this.anIntArray58[local15 - this.anInt205] && Static6.anInt266 % 20 < 10) {
						this.method151(local23.anInt925 + 15, this.aBoolean45, local23);
						if (this.anInt287 > -1) {
							this.aClass1_Sub3_Sub2_Sub2Array5[2].method322(this.anInt288 - 28, this.anInt287 - 12, false);
						}
					}
					if (local23.aString28 != null && (local15 >= this.anInt205 || this.anInt273 == 0 || this.anInt273 == 3 || this.anInt273 == 1 && this.method199(-20, ((Class1_Sub1_Sub3_Sub2) local23).aString29))) {
						this.method151(local23.anInt925, this.aBoolean45, local23);
						if (this.anInt287 > -1 && this.anInt314 < this.anInt315) {
							this.anIntArray76[this.anInt314] = this.aClass1_Sub3_Sub2_Sub4_3.method364(false, local23.aString28) / 2;
							this.anIntArray75[this.anInt314] = this.aClass1_Sub3_Sub2_Sub4_3.anInt540;
							this.anIntArray73[this.anInt314] = this.anInt287;
							this.anIntArray74[this.anInt314] = this.anInt288;
							this.anIntArray77[this.anInt314] = local23.anInt894;
							this.anIntArray78[this.anInt314] = local23.anInt895;
							this.anIntArray79[this.anInt314] = local23.anInt893;
							this.aStringArray8[this.anInt314++] = local23.aString28;
							if (this.anInt189 == 0 && local23.anInt895 == 1) {
								this.anIntArray75[this.anInt314] += 10;
								this.anIntArray74[this.anInt314] += 5;
							}
							if (this.anInt189 == 0 && local23.anInt895 == 2) {
								this.anIntArray76[this.anInt314] = 60;
							}
						}
					}
					if (local23.anInt898 > Static6.anInt266 + 100) {
						this.method151(local23.anInt925 + 15, this.aBoolean45, local23);
						if (this.anInt287 > -1) {
							local63 = local23.anInt899 * 30 / local23.anInt900;
							if (local63 > 30) {
								local63 = 30;
							}
							Static12.method358(this.anInt288 - 3, this.anInt287 - 15, 65280, (byte) 93, local63, 5);
							Static12.method358(this.anInt288 - 3, this.anInt287 - 15 + local63, 16711680, (byte) 93, 30 - local63, 5);
						}
					}
					if (local23.anInt898 > Static6.anInt266 + 330) {
						this.method151(local23.anInt925 / 2, this.aBoolean45, local23);
						if (this.anInt287 > -1) {
							this.aClass1_Sub3_Sub2_Sub2Array3[local23.anInt897].method322(this.anInt288 - 12, this.anInt287 - 12, false);
							this.aClass1_Sub3_Sub2_Sub4_1.method362(this.anInt288 + 4, (byte) 6, 0, String.valueOf(local23.anInt896), this.anInt287);
							this.aClass1_Sub3_Sub2_Sub4_1.method362(this.anInt288 + 3, (byte) 6, 16777215, String.valueOf(local23.anInt896), this.anInt287 - 1);
						}
					}
				}
			}
			for (@Pc(483) int local483 = 0; local483 < this.anInt314; local483++) {
				local63 = this.anIntArray73[local483];
				@Pc(495) int local495 = this.anIntArray74[local483];
				local84 = this.anIntArray76[local483];
				@Pc(505) int local505 = this.anIntArray75[local483];
				@Pc(507) boolean local507 = true;
				while (local507) {
					local507 = false;
					for (@Pc(513) int local513 = 0; local513 < local483; local513++) {
						if (local495 + 2 > this.anIntArray74[local513] - this.anIntArray75[local513] && local495 - local505 < this.anIntArray74[local513] + 2 && local63 - local84 < this.anIntArray73[local513] + this.anIntArray76[local513] && local63 + local84 > this.anIntArray73[local513] - this.anIntArray76[local513] && this.anIntArray74[local513] - this.anIntArray75[local513] < local495) {
							local495 = this.anIntArray74[local513] - this.anIntArray75[local513];
							local507 = true;
						}
					}
				}
				this.anInt287 = this.anIntArray73[local483];
				this.anInt288 = this.anIntArray74[local483] = local495;
				@Pc(612) String local612 = this.aStringArray8[local483];
				if (this.anInt189 == 0) {
					@Pc(617) int local617 = 16776960;
					if (this.anIntArray77[local483] < 6) {
						local617 = this.anIntArray69[this.anIntArray77[local483]];
					}
					if (this.anIntArray77[local483] == 6) {
						local617 = this.anInt211 % 20 < 10 ? 16711680 : 16776960;
					}
					if (this.anIntArray77[local483] == 7) {
						local617 = this.anInt211 % 20 < 10 ? 255 : 65535;
					}
					if (this.anIntArray77[local483] == 8) {
						local617 = this.anInt211 % 20 < 10 ? 45056 : 8454016;
					}
					@Pc(692) int local692;
					if (this.anIntArray77[local483] == 9) {
						local692 = 150 - this.anIntArray79[local483];
						if (local692 < 50) {
							local617 = local692 * 1280 + 16711680;
						} else if (local692 < 100) {
							local617 = 16776960 - (local692 - 50) * 327680;
						} else if (local692 < 150) {
							local617 = (local692 - 100) * 5 + 65280;
						}
					}
					if (this.anIntArray77[local483] == 10) {
						local692 = 150 - this.anIntArray79[local483];
						if (local692 < 50) {
							local617 = local692 * 5 + 16711680;
						} else if (local692 < 100) {
							local617 = 16711935 - (local692 - 50) * 327680;
						} else if (local692 < 150) {
							local617 = (local692 - 100) * 327680 + 255 - (local692 - 100) * 5;
						}
					}
					if (this.anIntArray77[local483] == 11) {
						local692 = 150 - this.anIntArray79[local483];
						if (local692 < 50) {
							local617 = 16777215 - local692 * 327685;
						} else if (local692 < 100) {
							local617 = (local692 - 50) * 327685 + 65280;
						} else if (local692 < 150) {
							local617 = 16777215 - (local692 - 100) * 327680;
						}
					}
					if (this.anIntArray78[local483] == 0) {
						this.aClass1_Sub3_Sub2_Sub4_3.method362(this.anInt288 + 1, (byte) 6, 0, local612, this.anInt287);
						this.aClass1_Sub3_Sub2_Sub4_3.method362(this.anInt288, (byte) 6, local617, local612, this.anInt287);
					}
					if (this.anIntArray78[local483] == 1) {
						this.aClass1_Sub3_Sub2_Sub4_3.method366(this.anInt211, (byte) 8, this.anInt287, this.anInt288 + 1, 0, local612);
						this.aClass1_Sub3_Sub2_Sub4_3.method366(this.anInt211, (byte) 8, this.anInt287, this.anInt288, local617, local612);
					}
					if (this.anIntArray78[local483] == 2) {
						local692 = this.aClass1_Sub3_Sub2_Sub4_3.method364(false, local612);
						@Pc(913) int local913 = (150 - this.anIntArray79[local483]) * (local692 + 100) / 150;
						Static12.method356(334, 0, this.anInt287 + 50, 789, this.anInt287 - 50);
						this.aClass1_Sub3_Sub2_Sub4_3.method365(this.anInt287 + 50 - local913, this.anInt288 + 1, false, 0, local612);
						this.aClass1_Sub3_Sub2_Sub4_3.method365(this.anInt287 + 50 - local913, this.anInt288, false, local617, local612);
						Static12.method355(0);
					}
				} else {
					this.aClass1_Sub3_Sub2_Sub4_3.method362(this.anInt288 + 1, (byte) 6, 0, local612, this.anInt287);
					this.aClass1_Sub3_Sub2_Sub4_3.method362(this.anInt288, (byte) 6, 16776960, local612, this.anInt287);
				}
			}
		} catch (@Pc(988) RuntimeException local988) {
			signlink.reporterror("83588, " + arg0 + ", " + local988.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(B)V")
	private void method77(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != -60) {
				this.aClass28ArrayArrayArray1 = null;
			}
			this.aClass1_Sub3_Sub3_6.method380((byte) -34, 231);
			if (this.anInt330 != -1) {
				this.anInt330 = -1;
				this.aBoolean59 = true;
				this.aBoolean49 = false;
				this.aBoolean68 = true;
			}
			if (this.anInt280 != -1) {
				this.anInt280 = -1;
				this.aBoolean60 = true;
				this.aBoolean49 = false;
			}
			this.anInt271 = -1;
		} catch (@Pc(44) RuntimeException local44) {
			signlink.reporterror("46537, " + arg0 + ", " + local44.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(I)V")
	private void method78(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 0) {
				this.method67();
			}
			signlink.midifade = 0;
			signlink.midi = "stop";
		} catch (@Pc(9) RuntimeException local9) {
			signlink.reporterror("44297, " + arg0 + ", " + local9.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(I)V")
	private void method79(@OriginalArg(0) int arg0) {
		try {
			@Pc(10) int local10 = (this.aClass1_Sub1_Sub3_Sub2_1.anInt882 >> 7) + this.anInt169;
			@Pc(19) int local19 = (this.aClass1_Sub1_Sub3_Sub2_1.anInt883 >> 7) + this.anInt170;
			if (arg0 != 39734) {
				this.aBoolean55 = !this.aBoolean55;
			}
			if (local10 >= 2944 && local10 < 3392 && local19 >= 3520 && local19 < 6400) {
				this.anInt316 = (local19 - 3520) / 8 + 1;
			} else if (local10 >= 2944 && local10 < 3392 && local19 >= 9920 && local19 < 12800) {
				this.anInt316 = (local19 - 9920) / 8 + 1;
			} else {
				this.anInt316 = 0;
			}
			this.anInt252 = 0;
			if (local10 >= 3328 && local10 < 3392 && local19 >= 3200 && local19 < 3264) {
				@Pc(98) int local98 = local10 & 0x3F;
				@Pc(102) int local102 = local19 & 0x3F;
				if (local98 >= 4 && local98 <= 29 && local102 >= 44 && local102 <= 58) {
					this.anInt252 = 1;
				}
				if (local98 >= 36 && local98 <= 61 && local102 >= 44 && local102 <= 58) {
					this.anInt252 = 1;
				}
				if (local98 >= 4 && local98 <= 29 && local102 >= 25 && local102 <= 39) {
					this.anInt252 = 1;
				}
				if (local98 >= 36 && local98 <= 61 && local102 >= 25 && local102 <= 39) {
					this.anInt252 = 1;
				}
				if (local98 >= 4 && local98 <= 29 && local102 >= 6 && local102 <= 20) {
					this.anInt252 = 1;
				}
				if (local98 >= 36 && local98 <= 61 && local102 >= 6 && local102 <= 20) {
					this.anInt252 = 1;
				}
			}
			if (this.anInt252 == 0 && local10 >= 3328 && local10 <= 3393 && local19 >= 3203 && local19 <= 3325) {
				this.anInt252 = 2;
			}
			this.anInt191 = 0;
			if (local10 >= 3053 && local10 <= 3156 && local19 >= 3056 && local19 <= 3136) {
				this.anInt191 = 1;
			}
			if (local10 >= 3072 && local10 <= 3118 && local19 >= 9492 && local19 <= 9535) {
				this.anInt191 = 1;
			}
			if (this.anInt191 == 1 && local10 >= 3139 && local10 <= 3199 && local19 >= 3008 && local19 <= 3062) {
				this.anInt191 = 0;
			}
		} catch (@Pc(264) RuntimeException local264) {
			signlink.reporterror("93797, " + arg0 + ", " + local264.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(I)V")
	private void method80(@OriginalArg(0) int arg0) {
		try {
			if (arg0 > 0 && this.anInt210 != 0) {
				@Pc(9) Class1_Sub3_Sub2_Sub4 local9 = this.aClass1_Sub3_Sub2_Sub4_2;
				@Pc(11) int local11 = 0;
				if (this.anInt267 != 0) {
					local11 = 1;
				}
				for (@Pc(18) int local18 = 0; local18 < 100; local18++) {
					if (this.aStringArray7[local18] != null) {
						@Pc(30) int local30 = this.anIntArray49[local18];
						@Pc(60) int local60;
						if ((local30 == 3 || local30 == 7) && (local30 == 7 || this.anInt164 == 0 || this.anInt164 == 1 && this.method199(-20, this.aStringArray6[local18]))) {
							local60 = 329 - local11 * 13;
							local9.method365(4, local60, false, 0, "From " + this.aStringArray6[local18] + ": " + this.aStringArray7[local18]);
							local9.method365(4, local60 - 1, false, 65535, "From " + this.aStringArray6[local18] + ": " + this.aStringArray7[local18]);
							local11++;
							if (local11 >= 5) {
								return;
							}
						}
						if (local30 == 5 && this.anInt164 < 2) {
							local60 = 329 - local11 * 13;
							local9.method365(4, local60, false, 0, this.aStringArray7[local18]);
							local9.method365(4, local60 - 1, false, 65535, this.aStringArray7[local18]);
							local11++;
							if (local11 >= 5) {
								return;
							}
						}
						if (local30 == 6 && this.anInt164 < 2) {
							local60 = 329 - local11 * 13;
							local9.method365(4, local60, false, 0, "To " + this.aStringArray6[local18] + ": " + this.aStringArray7[local18]);
							local9.method365(4, local60 - 1, false, 65535, "To " + this.aStringArray6[local18] + ": " + this.aStringArray7[local18]);
							local11++;
							if (local11 >= 5) {
								return;
							}
						}
					}
				}
			}
		} catch (@Pc(225) RuntimeException local225) {
			signlink.reporterror("71214, " + arg0 + ", " + local225.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!kb;II)V")
	private void method81(@OriginalArg(0) Class1_Sub3_Sub3 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.anInt206; local1++) {
				@Pc(8) int local8 = this.anIntArray40[local1];
				@Pc(13) Class1_Sub1_Sub3_Sub1 local13 = this.aClass1_Sub1_Sub3_Sub1Array1[local8];
				@Pc(16) int local16 = arg0.method391();
				@Pc(24) int local24;
				if ((local16 & 0x2) == 2) {
					local24 = arg0.method393();
					if (local24 == 65535) {
						local24 = -1;
					}
					if (local24 == local13.anInt907) {
						local13.anInt911 = 0;
					}
					@Pc(39) int local39 = arg0.method391();
					if (local24 == -1 || local13.anInt907 == -1 || Static20.aClass19Array1[local24].anInt545 > Static20.aClass19Array1[local13.anInt907].anInt545 || Static20.aClass19Array1[local13.anInt907].anInt545 == 0) {
						local13.anInt907 = local24;
						local13.anInt908 = 0;
						local13.anInt909 = 0;
						local13.anInt910 = local39;
						local13.anInt911 = 0;
					}
				}
				if ((local16 & 0x4) == 4) {
					local13.anInt901 = arg0.method393();
					if (local13.anInt901 == 65535) {
						local13.anInt901 = -1;
					}
				}
				if ((local16 & 0x8) == 8) {
					local13.aString28 = arg0.method398();
					local13.anInt893 = 100;
				}
				if ((local16 & 0x10) == 16) {
					local13.anInt896 = arg0.method391();
					local13.anInt897 = arg0.method391();
					local13.anInt898 = Static6.anInt266 + 400;
					local13.anInt899 = arg0.method391();
					local13.anInt900 = arg0.method391();
				}
				if ((local16 & 0x20) == 32) {
					local13.aClass3_1 = Static3.method32(arg0.method393());
					local13.anInt888 = local13.aClass3_1.anInt70;
					local13.anInt889 = local13.aClass3_1.anInt71;
					local13.anInt890 = local13.aClass3_1.anInt72;
					local13.anInt891 = local13.aClass3_1.anInt73;
					local13.anInt886 = local13.aClass3_1.anInt69;
				}
				if ((local16 & 0x40) == 64) {
					local13.anInt912 = arg0.method393();
					local24 = arg0.method396();
					local13.anInt916 = local24 >> 16;
					local13.anInt915 = Static6.anInt266 + (local24 & 0xFFFF);
					local13.anInt913 = 0;
					local13.anInt914 = 0;
					if (local13.anInt915 > Static6.anInt266) {
						local13.anInt913 = -1;
					}
					if (local13.anInt912 == 65535) {
						local13.anInt912 = -1;
					}
				}
				if ((local16 & 0x80) == 128) {
					local13.anInt902 = arg0.method393();
					local13.anInt903 = arg0.method393();
				}
			}
			if (arg2 <= 0) {
				this.anInt165 = this.aClass38_1.method532();
			}
		} catch (@Pc(237) RuntimeException local237) {
			signlink.reporterror("52952, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local237.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(JB)V")
	private void method82(@OriginalArg(0) long arg0, @OriginalArg(1) byte arg1) {
		try {
			if (arg0 != 0L) {
				if (this.anInt186 >= 100) {
					this.method172(0, "Your ignore list is full. Max of 100 hit", (byte) 4, "");
				} else {
					@Pc(23) String local23 = Static30.method542(0, Static30.method539(arg0, false));
					for (@Pc(25) int local25 = 0; local25 < this.anInt186; local25++) {
						if (this.aLongArray3[local25] == arg0) {
							this.method172(0, local23 + " is already on your ignore list", (byte) 4, "");
							return;
						}
					}
					for (@Pc(55) int local55 = 0; local55 < this.anInt312; local55++) {
						if (this.aLongArray4[local55] == arg0) {
							this.method172(0, "Please remove " + local23 + " from your friend list first", (byte) 4, "");
							return;
						}
					}
					this.aLongArray3[this.anInt186++] = arg0;
					this.aBoolean59 = true;
					if (arg1 == 3) {
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 79);
						this.aClass1_Sub3_Sub3_6.method387(true, arg0);
					}
				}
			}
		} catch (@Pc(114) RuntimeException local114) {
			signlink.reporterror("96582, " + arg0 + ", " + arg1 + ", " + local114.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(BLclient!kb;I)V")
	private void method83(@OriginalArg(0) byte arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 != -45) {
				this.method67();
			}
			@Pc(15) int local15;
			@Pc(24) int local24;
			@Pc(31) int local31;
			@Pc(34) int local34;
			@Pc(38) int local38;
			@Pc(42) int local42;
			@Pc(47) int local47;
			@Pc(52) int local52;
			@Pc(108) int local108;
			@Pc(110) int local110;
			@Pc(112) int local112;
			if (arg2 == 59 || arg2 == 76) {
				local15 = arg1.method391();
				local24 = this.anInt222 + (local15 >> 4 & 0x7);
				local31 = this.anInt223 + (local15 & 0x7);
				local34 = arg1.method391();
				local38 = local34 >> 2;
				local42 = local34 & 0x3;
				local47 = this.anIntArray80[local38];
				if (arg2 == 76) {
					local52 = -1;
				} else {
					local52 = arg1.method393();
				}
				if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
					@Pc(69) Class1_Sub4 local69 = null;
					for (@Pc(74) Class1_Sub4 local74 = (Class1_Sub4) this.aClass28_4.method456(); local74 != null; local74 = (Class1_Sub4) this.aClass28_4.method458(551)) {
						if (local74.anInt593 == this.anInt231 && local74.anInt595 == local24 && local74.anInt596 == local31 && local74.anInt594 == local47) {
							local69 = local74;
							break;
						}
					}
					if (local69 == null) {
						local108 = 0;
						local110 = -1;
						local112 = 0;
						@Pc(114) int local114 = 0;
						if (local47 == 0) {
							local108 = this.aClass33_1.method494(this.anInt231, local24, local31);
						}
						if (local47 == 1) {
							local108 = this.aClass33_1.method495(this.anInt231, local31, 3, local24);
						}
						if (local47 == 2) {
							local108 = this.aClass33_1.method496(this.anInt231, local24, local31);
						}
						if (local47 == 3) {
							local108 = this.aClass33_1.method497(this.anInt231, local24, local31);
						}
						if (local108 != 0) {
							@Pc(169) int local169 = this.aClass33_1.method498(this.anInt231, local24, local31, local108);
							local110 = local108 >> 14 & 0x7FFF;
							local112 = local169 & 0x1F;
							local114 = local169 >> 6;
						}
						local69 = new Class1_Sub4();
						local69.anInt593 = this.anInt231;
						local69.anInt594 = local47;
						local69.anInt595 = local24;
						local69.anInt596 = local31;
						local69.anInt600 = local110;
						local69.anInt602 = local112;
						local69.anInt601 = local114;
						this.aClass28_4.method453(local69);
					}
					local69.anInt597 = local52;
					local69.anInt599 = local38;
					local69.anInt598 = local42;
					this.method160(local42, local24, local31, local47, local52, local38, -27819, this.anInt231);
				}
			} else if (arg2 == 42) {
				local15 = arg1.method391();
				local24 = this.anInt222 + (local15 >> 4 & 0x7);
				local31 = this.anInt223 + (local15 & 0x7);
				local34 = arg1.method391();
				local38 = local34 >> 2;
				local42 = this.anIntArray80[local38];
				local47 = arg1.method393();
				if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
					local52 = 0;
					if (local42 == 0) {
						local52 = this.aClass33_1.method494(this.anInt231, local24, local31);
					}
					if (local42 == 1) {
						local52 = this.aClass33_1.method495(this.anInt231, local31, 3, local24);
					}
					if (local42 == 2) {
						local52 = this.aClass33_1.method496(this.anInt231, local24, local31);
					}
					if (local42 == 3) {
						local52 = this.aClass33_1.method497(this.anInt231, local24, local31);
					}
					if (local52 != 0) {
						@Pc(348) Class1_Sub6 local348 = new Class1_Sub6(false, local52 >> 14 & 0x7FFF, this.anInt231, 0, local42, Static20.aClass19Array1[local47], local31, local24);
						this.aClass28_1.method453(local348);
					}
				}
			} else {
				@Pc(395) Class1_Sub7 local395;
				if (arg2 == 223) {
					local15 = arg1.method391();
					local24 = this.anInt222 + (local15 >> 4 & 0x7);
					local31 = this.anInt223 + (local15 & 0x7);
					local34 = arg1.method393();
					local38 = arg1.method393();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
						local395 = new Class1_Sub7();
						local395.anInt765 = local34;
						local395.anInt766 = local38;
						if (this.aClass28ArrayArrayArray1[this.anInt231][local24][local31] == null) {
							this.aClass28ArrayArrayArray1[this.anInt231][local24][local31] = new Class28(0);
						}
						this.aClass28ArrayArrayArray1[this.anInt231][local24][local31].method453(local395);
						this.method184(local24, local31);
					}
				} else if (arg2 == 49) {
					local15 = arg1.method391();
					local24 = this.anInt222 + (local15 >> 4 & 0x7);
					local31 = this.anInt223 + (local15 & 0x7);
					local34 = arg1.method393();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
						@Pc(485) Class28 local485 = this.aClass28ArrayArrayArray1[this.anInt231][local24][local31];
						if (local485 != null) {
							for (local395 = (Class1_Sub7) local485.method456(); local395 != null; local395 = (Class1_Sub7) local485.method458(551)) {
								if (local395.anInt765 == (local34 & 0x7FFF)) {
									local395.method567();
									break;
								}
							}
							if (local485.method456() == null) {
								this.aClass28ArrayArrayArray1[this.anInt231][local24][local31] = null;
							}
							this.method184(local24, local31);
						}
					}
				} else {
					@Pc(572) int local572;
					@Pc(575) int local575;
					if (arg2 == 69) {
						local15 = arg1.method391();
						local24 = this.anInt222 + (local15 >> 4 & 0x7);
						local31 = this.anInt223 + (local15 & 0x7);
						local34 = local24 + arg1.method392();
						local38 = local31 + arg1.method392();
						local42 = arg1.method394();
						local47 = arg1.method393();
						local52 = arg1.method391();
						local572 = arg1.method391();
						local575 = arg1.method393();
						local108 = arg1.method393();
						local110 = arg1.method391();
						local112 = arg1.method391();
						if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104 && local34 >= 0 && local38 >= 0 && local34 < 104 && local38 < 104) {
							local24 = local24 * 128 + 64;
							local31 = local31 * 128 + 64;
							local34 = local34 * 128 + 64;
							local38 = local38 * 128 + 64;
							@Pc(657) Class1_Sub1_Sub1 local657 = new Class1_Sub1_Sub1(local572, local110, local31, local108 + Static6.anInt266, this.anInt231, local42, local575 + Static6.anInt266, local112, 0, this.method94(this.anInt231, local24, (byte) 5, local31) - local52, local47, local24);
							local657.method19(this.method94(this.anInt231, local34, (byte) 5, local38) - local572, local38, local34, -855, local575 + Static6.anInt266);
							this.aClass28_3.method453(local657);
						}
					} else if (arg2 == 191) {
						local15 = arg1.method391();
						local24 = this.anInt222 + (local15 >> 4 & 0x7);
						local31 = this.anInt223 + (local15 & 0x7);
						local34 = arg1.method393();
						local38 = arg1.method391();
						local42 = arg1.method393();
						if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
							local24 = local24 * 128 + 64;
							local31 = local31 * 128 + 64;
							@Pc(753) Class1_Sub1_Sub2 local753 = new Class1_Sub1_Sub2(local24, local34, false, local31, local42, this.method94(this.anInt231, local24, (byte) 5, local31) - local38, this.anInt231, Static6.anInt266);
							this.aClass28_5.method453(local753);
						}
					} else if (arg2 == 50) {
						local15 = arg1.method391();
						local24 = this.anInt222 + (local15 >> 4 & 0x7);
						local31 = this.anInt223 + (local15 & 0x7);
						local34 = arg1.method393();
						local38 = arg1.method393();
						local42 = arg1.method393();
						if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104 && local42 != this.anInt152) {
							@Pc(807) Class1_Sub7 local807 = new Class1_Sub7();
							local807.anInt765 = local34;
							local807.anInt766 = local38;
							if (this.aClass28ArrayArrayArray1[this.anInt231][local24][local31] == null) {
								this.aClass28ArrayArrayArray1[this.anInt231][local24][local31] = new Class28(0);
							}
							this.aClass28ArrayArrayArray1[this.anInt231][local24][local31].method453(local807);
							this.method184(local24, local31);
						}
					} else {
						if (arg2 == 23) {
							local15 = arg1.method391();
							local24 = this.anInt222 + (local15 >> 4 & 0x7);
							local31 = this.anInt223 + (local15 & 0x7);
							local34 = arg1.method391();
							local38 = local34 >> 2;
							local42 = local34 & 0x3;
							local47 = this.anIntArray80[local38];
							local52 = arg1.method393();
							local572 = arg1.method393();
							local575 = arg1.method393();
							local108 = arg1.method393();
							@Pc(905) byte local905 = arg1.method392();
							@Pc(908) byte local908 = arg1.method392();
							@Pc(911) byte local911 = arg1.method392();
							@Pc(914) byte local914 = arg1.method392();
							@Pc(921) Class1_Sub1_Sub3_Sub2 local921;
							if (local108 == this.anInt152) {
								local921 = this.aClass1_Sub1_Sub3_Sub2_1;
							} else {
								local921 = this.aClass1_Sub1_Sub3_Sub2Array1[local108];
							}
							if (local921 != null) {
								@Pc(946) Class1_Sub5 local946 = new Class1_Sub5(this.anInt231, local42, local31, local572 + Static6.anInt266, 2, local38, -1, local24, local47);
								this.aClass28_2.method453(local946);
								@Pc(966) Class1_Sub5 local966 = new Class1_Sub5(this.anInt231, local42, local31, local575 + Static6.anInt266, 2, local38, local52, local24, local47);
								this.aClass28_2.method453(local966);
								@Pc(980) int local980 = this.anIntArrayArrayArray3[this.anInt231][local24][local31];
								@Pc(992) int local992 = this.anIntArrayArrayArray3[this.anInt231][local24 + 1][local31];
								@Pc(1006) int local1006 = this.anIntArrayArrayArray3[this.anInt231][local24 + 1][local31 + 1];
								@Pc(1018) int local1018 = this.anIntArrayArrayArray3[this.anInt231][local24][local31 + 1];
								@Pc(1021) Class2 local1021 = Static2.method23(local52);
								local921.anInt934 = local572 + Static6.anInt266;
								local921.anInt935 = local575 + Static6.anInt266;
								local921.aClass1_Sub3_Sub1_11 = local1021.method26(local38, local42, local980, local992, local1006, local1018, -1);
								@Pc(1045) int local1045 = local1021.anInt43;
								@Pc(1048) int local1048 = local1021.anInt44;
								if (local42 == 1 || local42 == 3) {
									local1045 = local1021.anInt44;
									local1048 = local1021.anInt43;
								}
								local921.anInt936 = local24 * 128 + local1045 * 64;
								local921.anInt938 = local31 * 128 + local1048 * 64;
								local921.anInt937 = this.method94(this.anInt231, local921.anInt936, (byte) 5, local921.anInt938);
								@Pc(1094) byte local1094;
								if (local905 > local911) {
									local1094 = local905;
									local905 = local911;
									local911 = local1094;
								}
								if (local908 > local914) {
									local1094 = local908;
									local908 = local914;
									local914 = local1094;
								}
								local921.anInt939 = local24 + local905;
								local921.anInt941 = local24 + local911;
								local921.anInt940 = local31 + local908;
								local921.anInt942 = local31 + local914;
							}
						}
						if (arg2 == 151) {
							local15 = arg1.method391();
							local24 = this.anInt222 + (local15 >> 4 & 0x7);
							local31 = this.anInt223 + (local15 & 0x7);
							local34 = arg1.method393();
							local38 = arg1.method393();
							local42 = arg1.method393();
							if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
								@Pc(1178) Class28 local1178 = this.aClass28ArrayArrayArray1[this.anInt231][local24][local31];
								if (local1178 != null) {
									for (@Pc(1184) Class1_Sub7 local1184 = (Class1_Sub7) local1178.method456(); local1184 != null; local1184 = (Class1_Sub7) local1178.method458(551)) {
										if (local1184.anInt765 == (local34 & 0x7FFF) && local1184.anInt766 == local38) {
											local1184.anInt766 = local42;
											break;
										}
									}
									this.method184(local24, local31);
								}
							}
						}
					}
				}
			}
		} catch (@Pc(1214) RuntimeException local1214) {
			signlink.reporterror("90582, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local1214.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(B)I")
	private int method84(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != 106) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			@Pc(11) int local11 = 3;
			if (this.anInt325 < 310) {
				@Pc(20) int local20 = this.anInt322 >> 7;
				@Pc(25) int local25 = this.anInt324 >> 7;
				@Pc(31) int local31 = this.aClass1_Sub1_Sub3_Sub2_1.anInt882 >> 7;
				@Pc(37) int local37 = this.aClass1_Sub1_Sub3_Sub2_1.anInt883 >> 7;
				if ((this.aByteArrayArrayArray7[this.anInt231][local20][local25] & 0x4) != 0) {
					local11 = this.anInt231;
				}
				@Pc(59) int local59;
				if (local31 > local20) {
					local59 = local31 - local20;
				} else {
					local59 = local20 - local31;
				}
				@Pc(72) int local72;
				if (local37 > local25) {
					local72 = local37 - local25;
				} else {
					local72 = local25 - local37;
				}
				@Pc(87) int local87;
				@Pc(89) int local89;
				if (local59 > local72) {
					local87 = local72 * 65536 / local59;
					local89 = 32768;
					while (local20 != local31) {
						if (local20 < local31) {
							local20++;
						} else if (local20 > local31) {
							local20--;
						}
						if ((this.aByteArrayArrayArray7[this.anInt231][local20][local25] & 0x4) != 0) {
							local11 = this.anInt231;
						}
						local89 += local87;
						if (local89 >= 65536) {
							local89 -= 65536;
							if (local25 < local37) {
								local25++;
							} else if (local25 > local37) {
								local25--;
							}
							if ((this.aByteArrayArrayArray7[this.anInt231][local20][local25] & 0x4) != 0) {
								local11 = this.anInt231;
							}
						}
					}
				} else {
					local87 = local59 * 65536 / local72;
					local89 = 32768;
					while (local25 != local37) {
						if (local25 < local37) {
							local25++;
						} else if (local25 > local37) {
							local25--;
						}
						if ((this.aByteArrayArrayArray7[this.anInt231][local20][local25] & 0x4) != 0) {
							local11 = this.anInt231;
						}
						local89 += local87;
						if (local89 >= 65536) {
							local89 -= 65536;
							if (local20 < local31) {
								local20++;
							} else if (local20 > local31) {
								local20--;
							}
							if ((this.aByteArrayArrayArray7[this.anInt231][local20][local25] & 0x4) != 0) {
								local11 = this.anInt231;
							}
						}
					}
				}
			}
			if ((this.aByteArrayArrayArray7[this.anInt231][this.aClass1_Sub1_Sub3_Sub2_1.anInt882 >> 7][this.aClass1_Sub1_Sub3_Sub2_1.anInt883 >> 7] & 0x4) != 0) {
				local11 = this.anInt231;
			}
			return local11;
		} catch (@Pc(257) RuntimeException local257) {
			signlink.reporterror("50986, " + arg0 + ", " + local257.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(I)I")
	private int method85(@OriginalArg(0) int arg0) {
		try {
			@Pc(9) int local9 = this.method94(this.anInt231, this.anInt322, (byte) 5, this.anInt324);
			this.anInt178 += arg0;
			return local9 - this.anInt323 >= 800 || (this.aByteArrayArrayArray7[this.anInt231][this.anInt322 >> 7][this.anInt324 >> 7] & 0x4) == 0 ? 3 : this.anInt231;
		} catch (@Pc(45) RuntimeException local45) {
			signlink.reporterror("97355, " + arg0 + ", " + local45.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
	private void method86(@OriginalArg(0) int arg0) {
		try {
			this.anInt211++;
			this.method93(284);
			this.method114(false);
			this.anInt178 += arg0;
			this.method147((byte) -26);
			this.method166((byte) 106);
			this.method190(254);
			@Pc(34) int local34;
			@Pc(73) int local73;
			@Pc(122) int local122;
			if (!this.aBoolean61) {
				local34 = this.anInt199;
				if (this.anInt251 / 256 > local34) {
					local34 = this.anInt251 / 256;
				}
				if (this.aBooleanArray1[4] && this.anIntArray63[4] + 128 > local34) {
					local34 = this.anIntArray63[4] + 128;
				}
				local73 = this.anInt200 + this.anInt334 & 0x7FF;
				this.method100(this.method94(this.anInt231, this.aClass1_Sub1_Sub3_Sub2_1.anInt882, (byte) 5, this.aClass1_Sub1_Sub3_Sub2_1.anInt883) - 50, this.anInt243, local73, local34, 16418, this.anInt244, local34 * 3 + 600);
				Static6.anInt193++;
				if (Static6.anInt193 > 1802) {
					Static6.anInt193 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 146);
					this.aClass1_Sub3_Sub3_6.method381(0);
					local122 = this.aClass1_Sub3_Sub3_6.anInt561;
					this.aClass1_Sub3_Sub3_6.method382(29711);
					this.aClass1_Sub3_Sub3_6.method381(70);
					this.aClass1_Sub3_Sub3_6.method381((int) (Math.random() * 256.0D));
					this.aClass1_Sub3_Sub3_6.method381(242);
					this.aClass1_Sub3_Sub3_6.method381(186);
					this.aClass1_Sub3_Sub3_6.method381(39);
					this.aClass1_Sub3_Sub3_6.method381(61);
					if ((int) (Math.random() * 2.0D) == 0) {
						this.aClass1_Sub3_Sub3_6.method381(13);
					}
					if ((int) (Math.random() * 2.0D) == 0) {
						this.aClass1_Sub3_Sub3_6.method382(57856);
					}
					this.aClass1_Sub3_Sub3_6.method382((int) (Math.random() * 65536.0D));
					this.aClass1_Sub3_Sub3_6.method390(0, this.aClass1_Sub3_Sub3_6.anInt561 - local122);
				}
			}
			if (this.aBoolean61) {
				local34 = this.method85(0);
			} else {
				local34 = this.method84((byte) 106);
			}
			local73 = this.anInt322;
			local122 = this.anInt323;
			@Pc(209) int local209 = this.anInt324;
			@Pc(212) int local212 = this.anInt325;
			@Pc(215) int local215 = this.anInt326;
			@Pc(264) int local264;
			for (@Pc(217) int local217 = 0; local217 < 5; local217++) {
				if (this.aBooleanArray1[local217]) {
					local264 = (int) (Math.random() * (double) (this.anIntArray62[local217] * 2 + 1) - (double) this.anIntArray62[local217] + Math.sin((double) this.anIntArray68[local217] * ((double) this.anIntArray88[local217] / 100.0D)) * (double) this.anIntArray63[local217]);
					if (local217 == 0) {
						this.anInt322 += local264;
					}
					if (local217 == 1) {
						this.anInt323 += local264;
					}
					if (local217 == 2) {
						this.anInt324 += local264;
					}
					if (local217 == 3) {
						this.anInt326 = this.anInt326 + local264 & 0x7FF;
					}
					if (local217 == 4) {
						this.anInt325 += local264;
						if (this.anInt325 < 128) {
							this.anInt325 = 128;
						}
						if (this.anInt325 > 383) {
							this.anInt325 = 383;
						}
					}
				}
			}
			local264 = Static15.anInt434;
			Static10.aBoolean85 = true;
			Static10.anInt378 = 0;
			Static10.anInt376 = super.anInt135 - 8;
			Static10.anInt377 = super.anInt136 - 11;
			Static12.method357(this.anInt336);
			this.aClass33_1.method507(this.anInt326, this.anInt322, local34, this.anInt325, this.anInt323, this.anInt324, 0);
			this.aClass33_1.method481(0);
			this.method76(this.anInt194);
			this.method194((byte) -11);
			this.method102(local264, true);
			this.method145(9);
			this.aClass32_27.method464(11, super.aGraphics2, 8, 5193);
			this.anInt322 = local73;
			this.anInt323 = local122;
			this.anInt324 = local209;
			this.anInt325 = local212;
			this.anInt326 = local215;
		} catch (@Pc(405) RuntimeException local405) {
			signlink.reporterror("36672, " + arg0 + ", " + local405.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(Z)V")
	private void method87(@OriginalArg(0) boolean arg0) {
		try {
			this.aBoolean40 = false;
			if (arg0) {
				while (this.aBoolean41) {
					try {
						Thread.sleep(50L);
					} catch (@Pc(11) Exception local11) {
					}
					@Pc(14) Object local14 = this.anObject1;
					@Pc(19) String local19;
					@Pc(22) int local22;
					@Pc(25) int local25;
					synchronized (this.anObject1) {
						local19 = this.aString12;
						local22 = this.anInt269;
						local25 = this.anInt144;
						this.aString12 = null;
						this.anInt269 = 0;
						this.anInt144 = 0;
					}
					if (local19 != null) {
						@Pc(52) byte[] local52 = signlink.cacheload(local19 + ".mid");
						@Pc(69) int local69;
						if (local52 != null && local22 != 12345678) {
							this.aCRC32_1.reset();
							this.aCRC32_1.update(local52);
							local69 = (int) this.aCRC32_1.getValue();
							if (local69 != local22) {
								local52 = null;
							}
						}
						if (local52 == null) {
							try {
								@Pc(91) DataInputStream local91 = this.method155(local19 + "_" + local22 + ".mid");
								local52 = new byte[local25];
								@Pc(106) int local106;
								for (@Pc(96) int local96 = 0; local96 < local25; local96 += local106) {
									local106 = local91.read(local52, local96, local25 - local96);
									if (local106 == -1) {
										@Pc(112) byte[] local112 = new byte[local96];
										for (@Pc(114) int local114 = 0; local114 < local96; local114++) {
											local112[local114] = local52[local114];
										}
										local52 = local112;
										local25 = local96;
										break;
									}
								}
								local91.close();
								signlink.cachesave(local19 + ".mid", local52);
							} catch (@Pc(153) Exception local153) {
							}
						}
						if (local52 == null) {
							return;
						}
						local69 = (new Class1_Sub3_Sub3(363, local52)).method396();
						@Pc(167) byte[] local167 = new byte[local69];
						Static26.method519(local167, local69, local52, local25, 4);
						this.method113(local167, 625, local69, true);
					}
				}
			}
		} catch (@Pc(185) RuntimeException local185) {
			signlink.reporterror("94943, " + arg0 + ", " + local185.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(Z)V")
	private void method89(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(3) short local3 = 256;
			@Pc(8) int local8;
			if (this.anInt227 > 0) {
				for (local8 = 0; local8 < 256; local8++) {
					if (this.anInt227 > 768) {
						this.anIntArray50[local8] = this.method149(this.anIntArray51[local8], 1024 - this.anInt227, this.anIntArray52[local8], 997);
					} else if (this.anInt227 > 256) {
						this.anIntArray50[local8] = this.anIntArray52[local8];
					} else {
						this.anIntArray50[local8] = this.method149(this.anIntArray52[local8], 256 - this.anInt227, this.anIntArray51[local8], 997);
					}
				}
			} else if (this.anInt228 > 0) {
				for (local8 = 0; local8 < 256; local8++) {
					if (this.anInt228 > 768) {
						this.anIntArray50[local8] = this.method149(this.anIntArray51[local8], 1024 - this.anInt228, this.anIntArray53[local8], 997);
					} else if (this.anInt228 > 256) {
						this.anIntArray50[local8] = this.anIntArray53[local8];
					} else {
						this.anIntArray50[local8] = this.method149(this.anIntArray53[local8], 256 - this.anInt228, this.anIntArray51[local8], 997);
					}
				}
			} else {
				for (local8 = 0; local8 < 256; local8++) {
					this.anIntArray50[local8] = this.anIntArray51[local8];
				}
			}
			for (local8 = 0; local8 < 33920; local8++) {
				this.aClass32_19.anIntArray197[local8] = this.aClass1_Sub3_Sub2_Sub2_3.anIntArray148[local8];
			}
			@Pc(181) int local181 = 0;
			@Pc(183) int local183 = 1152;
			@Pc(198) int local198;
			@Pc(202) int local202;
			@Pc(212) int local212;
			@Pc(220) int local220;
			@Pc(224) int local224;
			@Pc(228) int local228;
			@Pc(239) int local239;
			for (@Pc(185) int local185 = 1; local185 < local3 - 1; local185++) {
				local198 = this.anIntArray43[local185] * (local3 - local185) / local3;
				local202 = local198 + 22;
				if (local202 < 0) {
					local202 = 0;
				}
				local181 += local202;
				for (local212 = local202; local212 < 128; local212++) {
					local220 = this.anIntArray64[local181++];
					if (local220 == 0) {
						local183++;
					} else {
						local224 = local220;
						local228 = 256 - local220;
						local220 = this.anIntArray50[local220];
						local239 = this.aClass32_19.anIntArray197[local183];
						this.aClass32_19.anIntArray197[local183++] = ((local220 & 0xFF00FF) * local224 + (local239 & 0xFF00FF) * local228 & 0xFF00FF00) + ((local220 & 0xFF00) * local224 + (local239 & 0xFF00) * local228 & 0xFF0000) >> 8;
					}
				}
				local183 += local202;
			}
			this.aClass32_19.method464(0, super.aGraphics2, 0, 5193);
			for (local198 = 0; local198 < 33920; local198++) {
				this.aClass32_20.anIntArray197[local198] = this.aClass1_Sub3_Sub2_Sub2_4.anIntArray148[local198];
			}
			local181 = 0;
			local183 = 1176;
			for (local202 = 1; local202 < local3 - 1; local202++) {
				local212 = this.anIntArray43[local202] * (local3 - local202) / local3;
				local220 = 103 - local212;
				local183 += local212;
				for (local224 = 0; local224 < local220; local224++) {
					local228 = this.anIntArray64[local181++];
					if (local228 == 0) {
						local183++;
					} else {
						local239 = local228;
						@Pc(362) int local362 = 256 - local228;
						local228 = this.anIntArray50[local228];
						@Pc(373) int local373 = this.aClass32_20.anIntArray197[local183];
						this.aClass32_20.anIntArray197[local183++] = ((local228 & 0xFF00FF) * local239 + (local373 & 0xFF00FF) * local362 & 0xFF00FF00) + ((local228 & 0xFF00) * local239 + (local373 & 0xFF00) * local362 & 0xFF0000) >> 8;
					}
				}
				local181 += 128 - local220;
				local183 += 128 - local220 - local212;
			}
			if (!arg0) {
				Static6.anInt268 = 281;
			}
			this.aClass32_20.method464(0, super.aGraphics2, 661, 5193);
		} catch (@Pc(449) RuntimeException local449) {
			signlink.reporterror("82128, " + arg0 + ", " + local449.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;III)V")
	private void method90(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class15 arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			if (arg3.anInt472 == 0 && arg3.anIntArray153 != null && !arg3.aBoolean106 && (arg1 >= arg5 && arg0 >= arg2 && arg1 <= arg5 + arg3.anInt475 && arg0 <= arg2 + arg3.anInt476)) {
				@Pc(34) int local34 = arg3.anIntArray153.length;
				if (arg4 != 5082) {
					this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
				}
				for (@Pc(44) int local44 = 0; local44 < local34; local44++) {
					@Pc(53) int local53 = arg3.anIntArray154[local44] + arg5;
					@Pc(62) int local62 = arg3.anIntArray155[local44] + arg2 - arg6;
					@Pc(69) Class15 local69 = Static17.aClass15Array1[arg3.anIntArray153[local44]];
					@Pc(74) int local74 = local53 + local69.anInt477;
					@Pc(79) int local79 = local62 + local69.anInt478;
					if ((local69.anInt479 >= 0 || local69.anInt487 != 0) && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
						if (local69.anInt479 >= 0) {
							this.anInt225 = local69.anInt479;
						} else {
							this.anInt225 = local69.anInt470;
						}
					}
					if (local69.anInt472 == 0) {
						this.method90(arg0, arg1, local79, local69, 5082, local74, local69.anInt481);
						if (local69.anInt480 > local69.anInt476) {
							this.method158(arg1, 0, arg0, local69.anInt480, local69.anInt476, true, local74 + local69.anInt475, local79, local69);
						}
					} else {
						if (local69.anInt473 == 1 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
							@Pc(176) boolean local176 = false;
							if (local69.anInt474 != 0) {
								local176 = this.method180(local69, (byte) 8);
							}
							if (!local176) {
								this.aStringArray5[this.anInt304] = local69.aString24;
								this.anIntArray86[this.anInt304] = 951;
								this.anIntArray85[this.anInt304] = local69.anInt470;
								this.anInt304++;
							}
						}
						if (local69.anInt473 == 2 && this.anInt291 == 0 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
							@Pc(240) String local240 = local69.aString22;
							if (local240.indexOf(" ") != -1) {
								local240 = local240.substring(0, local240.indexOf(" "));
							}
							this.aStringArray5[this.anInt304] = local240 + " @gre@" + local69.aString23;
							this.anIntArray86[this.anInt304] = 930;
							this.anIntArray85[this.anInt304] = local69.anInt470;
							this.anInt304++;
						}
						if (local69.anInt473 == 3 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
							this.aStringArray5[this.anInt304] = "Close";
							this.anIntArray86[this.anInt304] = 947;
							this.anIntArray85[this.anInt304] = local69.anInt470;
							this.anInt304++;
						}
						if (local69.anInt473 == 4 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
							this.aStringArray5[this.anInt304] = local69.aString24;
							this.anIntArray86[this.anInt304] = 465;
							this.anIntArray85[this.anInt304] = local69.anInt470;
							this.anInt304++;
						}
						if (local69.anInt473 == 5 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
							this.aStringArray5[this.anInt304] = local69.aString24;
							this.anIntArray86[this.anInt304] = 960;
							this.anIntArray85[this.anInt304] = local69.anInt470;
							this.anInt304++;
						}
						if (local69.anInt473 == 6 && !this.aBoolean49 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.anInt476) {
							this.aStringArray5[this.anInt304] = local69.aString24;
							this.anIntArray86[this.anInt304] = 44;
							this.anIntArray85[this.anInt304] = local69.anInt470;
							this.anInt304++;
						}
						if (local69.anInt472 == 2) {
							@Pc(488) int local488 = 0;
							for (@Pc(490) int local490 = 0; local490 < local69.anInt476; local490++) {
								for (@Pc(494) int local494 = 0; local494 < local69.anInt475; local494++) {
									@Pc(505) int local505 = local74 + local494 * (local69.anInt483 + 32);
									@Pc(514) int local514 = local79 + local490 * (local69.anInt484 + 32);
									if (local488 < 20) {
										local505 += local69.anIntArray156[local488];
										local514 += local69.anIntArray157[local488];
									}
									if (arg1 >= local505 && arg0 >= local514 && arg1 < local505 + 32 && arg0 < local514 + 32) {
										this.anInt310 = local488;
										this.anInt311 = local69.anInt470;
										if (local69.anIntArray149[local488] > 0) {
											@Pc(567) Class5 local567 = Static5.method54(local69.anIntArray149[local488] - 1);
											if (this.anInt281 == 1 && local69.aBoolean109) {
												if (local69.anInt470 != this.anInt283 || local488 != this.anInt282) {
													this.aStringArray5[this.anInt304] = "Use " + this.aString10 + " with @lre@" + local567.aString3;
													this.anIntArray86[this.anInt304] = 881;
													this.anIntArray87[this.anInt304] = local567.anInt103;
													this.anIntArray84[this.anInt304] = local488;
													this.anIntArray85[this.anInt304] = local69.anInt470;
													this.anInt304++;
												}
											} else if (this.anInt291 != 1 || !local69.aBoolean109) {
												@Pc(704) int local704;
												if (local69.aBoolean109) {
													for (local704 = 4; local704 >= 3; local704--) {
														if (local567.aStringArray4 != null && local567.aStringArray4[local704] != null) {
															this.aStringArray5[this.anInt304] = local567.aStringArray4[local704] + " @lre@" + local567.aString3;
															if (local704 == 3) {
																this.anIntArray86[this.anInt304] = 478;
															}
															if (local704 == 4) {
																this.anIntArray86[this.anInt304] = 347;
															}
															this.anIntArray87[this.anInt304] = local567.anInt103;
															this.anIntArray84[this.anInt304] = local488;
															this.anIntArray85[this.anInt304] = local69.anInt470;
															this.anInt304++;
														} else if (local704 == 4) {
															this.aStringArray5[this.anInt304] = "Drop @lre@" + local567.aString3;
															this.anIntArray86[this.anInt304] = 347;
															this.anIntArray87[this.anInt304] = local567.anInt103;
															this.anIntArray84[this.anInt304] = local488;
															this.anIntArray85[this.anInt304] = local69.anInt470;
															this.anInt304++;
														}
													}
												}
												if (local69.aBoolean110) {
													this.aStringArray5[this.anInt304] = "Use @lre@" + local567.aString3;
													this.anIntArray86[this.anInt304] = 188;
													this.anIntArray87[this.anInt304] = local567.anInt103;
													this.anIntArray84[this.anInt304] = local488;
													this.anIntArray85[this.anInt304] = local69.anInt470;
													this.anInt304++;
												}
												if (local69.aBoolean109 && local567.aStringArray4 != null) {
													for (local704 = 2; local704 >= 0; local704--) {
														if (local567.aStringArray4[local704] != null) {
															this.aStringArray5[this.anInt304] = local567.aStringArray4[local704] + " @lre@" + local567.aString3;
															if (local704 == 0) {
																this.anIntArray86[this.anInt304] = 405;
															}
															if (local704 == 1) {
																this.anIntArray86[this.anInt304] = 38;
															}
															if (local704 == 2) {
																this.anIntArray86[this.anInt304] = 422;
															}
															this.anIntArray87[this.anInt304] = local567.anInt103;
															this.anIntArray84[this.anInt304] = local488;
															this.anIntArray85[this.anInt304] = local69.anInt470;
															this.anInt304++;
														}
													}
												}
												if (local69.aStringArray10 != null) {
													for (local704 = 4; local704 >= 0; local704--) {
														if (local69.aStringArray10[local704] != null) {
															this.aStringArray5[this.anInt304] = local69.aStringArray10[local704] + " @lre@" + local567.aString3;
															if (local704 == 0) {
																this.anIntArray86[this.anInt304] = 602;
															}
															if (local704 == 1) {
																this.anIntArray86[this.anInt304] = 596;
															}
															if (local704 == 2) {
																this.anIntArray86[this.anInt304] = 22;
															}
															if (local704 == 3) {
																this.anIntArray86[this.anInt304] = 892;
															}
															if (local704 == 4) {
																this.anIntArray86[this.anInt304] = 415;
															}
															this.anIntArray87[this.anInt304] = local567.anInt103;
															this.anIntArray84[this.anInt304] = local488;
															this.anIntArray85[this.anInt304] = local69.anInt470;
															this.anInt304++;
														}
													}
												}
												this.aStringArray5[this.anInt304] = "Examine @lre@" + local567.aString3;
												this.anIntArray86[this.anInt304] = 1773;
												this.anIntArray87[this.anInt304] = local567.anInt103;
												this.anIntArray85[this.anInt304] = local69.anIntArray150[local488];
												this.anInt304++;
											} else if ((this.anInt293 & 0x10) == 16) {
												this.aStringArray5[this.anInt304] = this.aString11 + " @lre@" + local567.aString3;
												this.anIntArray86[this.anInt304] = 391;
												this.anIntArray87[this.anInt304] = local567.anInt103;
												this.anIntArray84[this.anInt304] = local488;
												this.anIntArray85[this.anInt304] = local69.anInt470;
												this.anInt304++;
											}
										}
									}
									local488++;
								}
							}
						}
					}
				}
			}
		} catch (@Pc(1130) RuntimeException local1130) {
			signlink.reporterror("35323, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local1130.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
	private void method91(@OriginalArg(0) int arg0) {
		try {
			this.anInt178 += arg0;
			if (super.anInt137 == 1) {
				if (super.anInt138 >= 8 && super.anInt138 <= 108 && super.anInt139 >= 490 && super.anInt139 <= 522) {
					this.anInt273 = (this.anInt273 + 1) % 4;
					this.aBoolean56 = true;
					this.aBoolean60 = true;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 244);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt273);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt164);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt234);
				}
				if (super.anInt138 >= 137 && super.anInt138 <= 237 && super.anInt139 >= 490 && super.anInt139 <= 522) {
					this.anInt164 = (this.anInt164 + 1) % 3;
					this.aBoolean56 = true;
					this.aBoolean60 = true;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 244);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt273);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt164);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt234);
				}
				if (super.anInt138 >= 275 && super.anInt138 <= 375 && super.anInt139 >= 490 && super.anInt139 <= 522) {
					this.anInt234 = (this.anInt234 + 1) % 3;
					this.aBoolean56 = true;
					this.aBoolean60 = true;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 244);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt273);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt164);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt234);
				}
				if (super.anInt138 >= 416 && super.anInt138 <= 516 && super.anInt139 >= 490 && super.anInt139 <= 522) {
					this.method77((byte) -60);
					this.aString9 = "";
					this.aBoolean51 = false;
					for (@Pc(186) int local186 = 0; local186 < Static17.aClass15Array1.length; local186++) {
						if (Static17.aClass15Array1[local186] != null && Static17.aClass15Array1[local186].anInt474 == 600) {
							this.anInt240 = this.anInt271 = Static17.aClass15Array1[local186].anInt471;
							return;
						}
					}
					return;
				}
			}
		} catch (@Pc(215) RuntimeException local215) {
			signlink.reporterror("26269, " + arg0 + ", " + local215.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(III)V")
	private void method92(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(1) int local1 = 0;
			for (@Pc(3) int local3 = 0; local3 < 100; local3++) {
				if (this.aStringArray7[local3] != null) {
					@Pc(15) int local15 = this.anIntArray49[local3];
					@Pc(26) int local26 = this.anInt274 + 70 + 4 - local1 * 14;
					if (local26 < -20) {
						break;
					}
					if (local15 == 0) {
						local1++;
					}
					if ((local15 == 1 || local15 == 2) && (local15 == 1 || this.anInt273 == 0 || this.anInt273 == 1 && this.method199(-20, this.aStringArray6[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26 && !this.aStringArray6[local3].equals(this.aClass1_Sub1_Sub3_Sub2_1.aString29)) {
							if (this.aBoolean65) {
								this.aStringArray5[this.anInt304] = "Report abuse @whi@" + this.aStringArray6[local3];
								this.anIntArray86[this.anInt304] = 34;
								this.anInt304++;
							}
							this.aStringArray5[this.anInt304] = "Add ignore @whi@" + this.aStringArray6[local3];
							this.anIntArray86[this.anInt304] = 436;
							this.anInt304++;
							this.aStringArray5[this.anInt304] = "Add friend @whi@" + this.aStringArray6[local3];
							this.anIntArray86[this.anInt304] = 406;
							this.anInt304++;
						}
						local1++;
					}
					if ((local15 == 3 || local15 == 7) && this.anInt210 == 0 && (local15 == 7 || this.anInt164 == 0 || this.anInt164 == 1 && this.method199(-20, this.aStringArray6[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26) {
							if (this.aBoolean65) {
								this.aStringArray5[this.anInt304] = "Report abuse @whi@" + this.aStringArray6[local3];
								this.anIntArray86[this.anInt304] = 34;
								this.anInt304++;
							}
							this.aStringArray5[this.anInt304] = "Add ignore @whi@" + this.aStringArray6[local3];
							this.anIntArray86[this.anInt304] = 436;
							this.anInt304++;
							this.aStringArray5[this.anInt304] = "Add friend @whi@" + this.aStringArray6[local3];
							this.anIntArray86[this.anInt304] = 406;
							this.anInt304++;
						}
						local1++;
					}
					if (local15 == 4 && (this.anInt234 == 0 || this.anInt234 == 1 && this.method199(-20, this.aStringArray6[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26) {
							this.aStringArray5[this.anInt304] = "Accept trade @whi@" + this.aStringArray6[local3];
							this.anIntArray86[this.anInt304] = 903;
							this.anInt304++;
						}
						local1++;
					}
					if ((local15 == 5 || local15 == 6) && this.anInt210 == 0 && this.anInt164 < 2) {
						local1++;
					}
					if (local15 == 8 && (this.anInt234 == 0 || this.anInt234 == 1 && this.method199(-20, this.aStringArray6[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26) {
							this.aStringArray5[this.anInt304] = "Accept duel @whi@" + this.aStringArray6[local3];
							this.anIntArray86[this.anInt304] = 363;
							this.anInt304++;
						}
						local1++;
					}
				}
			}
			this.anInt178 += arg1;
		} catch (@Pc(412) RuntimeException local412) {
			signlink.reporterror("24152, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local412.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(I)V")
	private void method93(@OriginalArg(0) int arg0) {
		try {
			if (this.aClass1_Sub1_Sub3_Sub2_1.anInt882 >> 7 == this.anInt296 && this.aClass1_Sub1_Sub3_Sub2_1.anInt883 >> 7 == this.anInt297) {
				this.anInt296 = 0;
			}
			for (@Pc(22) int local22 = -1; local22 < this.anInt205; local22++) {
				@Pc(30) Class1_Sub1_Sub3_Sub2 local30;
				@Pc(35) int local35;
				if (local22 == -1) {
					local30 = this.aClass1_Sub1_Sub3_Sub2_1;
					local35 = this.anInt204 << 14;
				} else {
					local30 = this.aClass1_Sub1_Sub3_Sub2Array1[this.anIntArray39[local22]];
					local35 = this.anIntArray39[local22] << 14;
				}
				if (local30 != null && local30.method571(false)) {
					local30.aBoolean163 = false;
					if ((Static6.aBoolean53 && this.anInt205 > 50 || this.anInt205 > 200) && local22 != -1 && local30.anInt904 == local30.anInt886) {
						local30.aBoolean163 = true;
					}
					@Pc(87) int local87 = local30.anInt882 >> 7;
					@Pc(92) int local92 = local30.anInt883 >> 7;
					if (local87 >= 0 && local87 < 104 && local92 >= 0 && local92 < 104) {
						if (local30.aClass1_Sub3_Sub1_11 == null || Static6.anInt266 < local30.anInt934 || Static6.anInt266 >= local30.anInt935) {
							if ((local30.anInt882 & 0x7F) == 64 && (local30.anInt883 & 0x7F) == 64) {
								if (this.anIntArrayArray3[local87][local92] == this.anInt211) {
									continue;
								}
								this.anIntArrayArray3[local87][local92] = this.anInt211;
							}
							local30.anInt933 = this.method94(this.anInt231, local30.anInt882, (byte) 5, local30.anInt883);
							this.aClass33_1.method478(-44713, local30.anInt883, 60, local30.anInt884, local30.anInt882, local35, local30.aBoolean160, null, local30, local30.anInt933, this.anInt231);
						} else {
							local30.aBoolean163 = false;
							local30.anInt933 = this.method94(this.anInt231, local30.anInt882, (byte) 5, local30.anInt883);
							this.aClass33_1.method479(local30.anInt941, 60, null, local30.anInt883, local30.anInt933, local35, local30.anInt884, local30.anInt940, local30.anInt939, local30, false, this.anInt231, local30.anInt942, local30.anInt882);
						}
					}
				}
			}
			if (arg0 <= 0) {
				this.aClass1_Sub3_Sub3_6.method381(210);
			}
		} catch (@Pc(230) RuntimeException local230) {
			signlink.reporterror("13213, " + arg0 + ", " + local230.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIBI)I")
	private int method94(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) byte arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg2 != 5) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			@Pc(11) int local11 = arg1 >> 7;
			@Pc(15) int local15 = arg3 >> 7;
			@Pc(17) int local17 = arg0;
			if (arg0 < 3 && (this.aByteArrayArrayArray7[1][local11][local15] & 0x2) == 2) {
				local17 = arg0 + 1;
			}
			@Pc(37) int local37 = arg1 & 0x7F;
			@Pc(41) int local41 = arg3 & 0x7F;
			@Pc(69) int local69 = this.anIntArrayArrayArray3[local17][local11][local15] * (128 - local37) + this.anIntArrayArrayArray3[local17][local11 + 1][local15] * local37 >> 7;
			@Pc(101) int local101 = this.anIntArrayArrayArray3[local17][local11][local15 + 1] * (128 - local37) + this.anIntArrayArrayArray3[local17][local11 + 1][local15 + 1] * local37 >> 7;
			return local69 * (128 - local41) + local101 * local41 >> 7;
		} catch (@Pc(114) RuntimeException local114) {
			signlink.reporterror("41583, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local114.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!bc;IIII)V")
	private void method95(@OriginalArg(0) Class3 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			while (arg1 >= 0) {
				this.anInt179 = -1;
			}
			if (this.anInt304 < 400) {
				@Pc(16) String local16 = arg0.aString2;
				if (arg0.anInt77 != 0) {
					local16 = local16 + Static6.method133(this.aClass1_Sub1_Sub3_Sub2_1.anInt932, false, arg0.anInt77) + " (level-" + arg0.anInt77 + ")";
				}
				if (this.anInt281 == 1) {
					this.aStringArray5[this.anInt304] = "Use " + this.aString10 + " with @yel@" + local16;
					this.anIntArray86[this.anInt304] = 900;
					this.anIntArray87[this.anInt304] = arg4;
					this.anIntArray84[this.anInt304] = arg3;
					this.anIntArray85[this.anInt304] = arg2;
					this.anInt304++;
				} else if (this.anInt291 != 1) {
					@Pc(155) int local155;
					if (arg0.aStringArray2 != null) {
						for (local155 = 4; local155 >= 0; local155--) {
							if (arg0.aStringArray2[local155] != null && !arg0.aStringArray2[local155].equalsIgnoreCase("attack")) {
								this.aStringArray5[this.anInt304] = arg0.aStringArray2[local155] + " @yel@" + local16;
								if (local155 == 0) {
									this.anIntArray86[this.anInt304] = 728;
								}
								if (local155 == 1) {
									this.anIntArray86[this.anInt304] = 542;
								}
								if (local155 == 2) {
									this.anIntArray86[this.anInt304] = 6;
								}
								if (local155 == 3) {
									this.anIntArray86[this.anInt304] = 963;
								}
								if (local155 == 4) {
									this.anIntArray86[this.anInt304] = 245;
								}
								this.anIntArray87[this.anInt304] = arg4;
								this.anIntArray84[this.anInt304] = arg3;
								this.anIntArray85[this.anInt304] = arg2;
								this.anInt304++;
							}
						}
					}
					if (arg0.aStringArray2 != null) {
						for (local155 = 4; local155 >= 0; local155--) {
							if (arg0.aStringArray2[local155] != null && arg0.aStringArray2[local155].equalsIgnoreCase("attack")) {
								@Pc(279) short local279 = 0;
								if (arg0.anInt77 > this.aClass1_Sub1_Sub3_Sub2_1.anInt932) {
									local279 = 2000;
								}
								this.aStringArray5[this.anInt304] = arg0.aStringArray2[local155] + " @yel@" + local16;
								if (local155 == 0) {
									this.anIntArray86[this.anInt304] = local279 + 728;
								}
								if (local155 == 1) {
									this.anIntArray86[this.anInt304] = local279 + 542;
								}
								if (local155 == 2) {
									this.anIntArray86[this.anInt304] = local279 + 6;
								}
								if (local155 == 3) {
									this.anIntArray86[this.anInt304] = local279 + 963;
								}
								if (local155 == 4) {
									this.anIntArray86[this.anInt304] = local279 + 245;
								}
								this.anIntArray87[this.anInt304] = arg4;
								this.anIntArray84[this.anInt304] = arg3;
								this.anIntArray85[this.anInt304] = arg2;
								this.anInt304++;
							}
						}
					}
					this.aStringArray5[this.anInt304] = "Examine @yel@" + local16;
					this.anIntArray86[this.anInt304] = 1607;
					this.anIntArray87[this.anInt304] = arg4;
					this.anIntArray84[this.anInt304] = arg3;
					this.anIntArray85[this.anInt304] = arg2;
					this.anInt304++;
				} else if ((this.anInt293 & 0x2) == 2) {
					this.aStringArray5[this.anInt304] = this.aString11 + " @yel@" + local16;
					this.anIntArray86[this.anInt304] = 265;
					this.anIntArray87[this.anInt304] = arg4;
					this.anIntArray84[this.anInt304] = arg3;
					this.anIntArray85[this.anInt304] = arg2;
					this.anInt304++;
					return;
				}
			}
		} catch (@Pc(430) RuntimeException local430) {
			signlink.reporterror("93342, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local430.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
	private void method96(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 7) {
				this.anInt333 = this.aClass38_1.method532();
			}
			while (true) {
				@Pc(13) int local13;
				do {
					while (true) {
						local13 = this.method66(false);
						if (local13 == -1) {
							return;
						}
						if (this.anInt271 != -1 && this.anInt271 == this.anInt240) {
							if (local13 == 8 && this.aString9.length() > 0) {
								this.aString9 = this.aString9.substring(0, this.aString9.length() - 1);
							}
							break;
						}
						@Pc(193) int local193;
						if (this.aBoolean47) {
							if (local13 >= 32 && local13 <= 122 && this.aString5.length() < 80) {
								this.aString5 = this.aString5 + (char) local13;
								this.aBoolean60 = true;
							}
							if (local13 == 8 && this.aString5.length() > 0) {
								this.aString5 = this.aString5.substring(0, this.aString5.length() - 1);
								this.aBoolean60 = true;
							}
							if (local13 == 13 || local13 == 10) {
								this.aBoolean47 = false;
								this.aBoolean60 = true;
								@Pc(153) long local153;
								if (this.anInt168 == 1) {
									local153 = Static30.method538(this.aString5);
									this.method161(local153, -460);
								}
								if (this.anInt168 == 2 && this.anInt312 > 0) {
									local153 = Static30.method538(this.aString5);
									this.method174(43808, local153);
								}
								if (this.anInt168 == 3 && this.aString5.length() > 0) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 148);
									this.aClass1_Sub3_Sub3_6.method381(0);
									local193 = this.aClass1_Sub3_Sub3_6.anInt561;
									this.aClass1_Sub3_Sub3_6.method387(true, this.aLong8);
									Static31.method546(this.aClass1_Sub3_Sub3_6, true, this.aString5);
									this.aClass1_Sub3_Sub3_6.method390(0, this.aClass1_Sub3_Sub3_6.anInt561 - local193);
									this.aString5 = Static30.method543(this.aString5, 0);
									this.aString5 = Static24.method424(this.aString5, 0);
									this.method172(6, this.aString5, (byte) 4, Static30.method542(0, Static30.method539(this.aLong8, false)));
									if (this.anInt164 == 2) {
										this.anInt164 = 1;
										this.aBoolean56 = true;
										this.aClass1_Sub3_Sub3_6.method380((byte) -34, 244);
										this.aClass1_Sub3_Sub3_6.method381(this.anInt273);
										this.aClass1_Sub3_Sub3_6.method381(this.anInt164);
										this.aClass1_Sub3_Sub3_6.method381(this.anInt234);
									}
								}
								if (this.anInt168 == 4 && this.anInt186 < 100) {
									local153 = Static30.method538(this.aString5);
									this.method82(local153, (byte) 3);
								}
								if (this.anInt168 == 5 && this.anInt186 > 0) {
									local153 = Static30.method538(this.aString5);
									this.method191(1, local153);
								}
							}
						} else if (this.aBoolean66) {
							if (local13 >= 48 && local13 <= 57 && this.aString7.length() < 10) {
								this.aString7 = this.aString7 + (char) local13;
								this.aBoolean60 = true;
							}
							if (local13 == 8 && this.aString7.length() > 0) {
								this.aString7 = this.aString7.substring(0, this.aString7.length() - 1);
								this.aBoolean60 = true;
							}
							if (local13 == 13 || local13 == 10) {
								if (this.aString7.length() > 0) {
									local193 = 0;
									try {
										local193 = Integer.parseInt(this.aString7);
									} catch (@Pc(369) Exception local369) {
									}
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 237);
									this.aClass1_Sub3_Sub3_6.method385(local193);
								}
								this.aBoolean66 = false;
								this.aBoolean60 = true;
							}
						} else if (this.anInt280 == -1) {
							if (local13 >= 32 && local13 <= 122 && this.aString18.length() < 80) {
								this.aString18 = this.aString18 + (char) local13;
								this.aBoolean60 = true;
							}
							if (local13 == 8 && this.aString18.length() > 0) {
								this.aString18 = this.aString18.substring(0, this.aString18.length() - 1);
								this.aBoolean60 = true;
							}
							if ((local13 == 13 || local13 == 10) && this.aString18.length() > 0) {
								if (this.aString18.equals("::clientdrop") && (super.aFrame_Sub1_2 != null || this.method134(-7437).indexOf("192.168.1.") != -1)) {
									this.method182(false);
								} else if (this.aString18.startsWith("::")) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 4);
									this.aClass1_Sub3_Sub3_6.method381(this.aString18.length() - 1);
									this.aClass1_Sub3_Sub3_6.method388(this.aString18.substring(2));
								} else {
									@Pc(496) byte local496 = 0;
									if (this.aString18.startsWith("yellow:")) {
										local496 = 0;
										this.aString18 = this.aString18.substring(7);
									}
									if (this.aString18.startsWith("red:")) {
										local496 = 1;
										this.aString18 = this.aString18.substring(4);
									}
									if (this.aString18.startsWith("green:")) {
										local496 = 2;
										this.aString18 = this.aString18.substring(6);
									}
									if (this.aString18.startsWith("cyan:")) {
										local496 = 3;
										this.aString18 = this.aString18.substring(5);
									}
									if (this.aString18.startsWith("purple:")) {
										local496 = 4;
										this.aString18 = this.aString18.substring(7);
									}
									if (this.aString18.startsWith("white:")) {
										local496 = 5;
										this.aString18 = this.aString18.substring(6);
									}
									if (this.aString18.startsWith("flash1:")) {
										local496 = 6;
										this.aString18 = this.aString18.substring(7);
									}
									if (this.aString18.startsWith("flash2:")) {
										local496 = 7;
										this.aString18 = this.aString18.substring(7);
									}
									if (this.aString18.startsWith("flash3:")) {
										local496 = 8;
										this.aString18 = this.aString18.substring(7);
									}
									if (this.aString18.startsWith("glow1:")) {
										local496 = 9;
										this.aString18 = this.aString18.substring(6);
									}
									if (this.aString18.startsWith("glow2:")) {
										local496 = 10;
										this.aString18 = this.aString18.substring(6);
									}
									if (this.aString18.startsWith("glow3:")) {
										local496 = 11;
										this.aString18 = this.aString18.substring(6);
									}
									@Pc(654) byte local654 = 0;
									if (this.aString18.startsWith("wave:")) {
										local654 = 1;
										this.aString18 = this.aString18.substring(5);
									}
									if (this.aString18.startsWith("scroll:")) {
										local654 = 2;
										this.aString18 = this.aString18.substring(7);
									}
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 158);
									this.aClass1_Sub3_Sub3_6.method381(0);
									@Pc(693) int local693 = this.aClass1_Sub3_Sub3_6.anInt561;
									this.aClass1_Sub3_Sub3_6.method381(local496);
									this.aClass1_Sub3_Sub3_6.method381(local654);
									Static31.method546(this.aClass1_Sub3_Sub3_6, true, this.aString18);
									this.aClass1_Sub3_Sub3_6.method390(0, this.aClass1_Sub3_Sub3_6.anInt561 - local693);
									this.aString18 = Static30.method543(this.aString18, 0);
									this.aString18 = Static24.method424(this.aString18, 0);
									this.aClass1_Sub1_Sub3_Sub2_1.aString28 = this.aString18;
									this.aClass1_Sub1_Sub3_Sub2_1.anInt894 = local496;
									this.aClass1_Sub1_Sub3_Sub2_1.anInt895 = local654;
									this.aClass1_Sub1_Sub3_Sub2_1.anInt893 = 150;
									this.method172(2, this.aClass1_Sub1_Sub3_Sub2_1.aString28, (byte) 4, this.aClass1_Sub1_Sub3_Sub2_1.aString29);
									if (this.anInt273 == 2) {
										this.anInt273 = 3;
										this.aBoolean56 = true;
										this.aClass1_Sub3_Sub3_6.method380((byte) -34, 244);
										this.aClass1_Sub3_Sub3_6.method381(this.anInt273);
										this.aClass1_Sub3_Sub3_6.method381(this.anInt164);
										this.aClass1_Sub3_Sub3_6.method381(this.anInt234);
									}
								}
								this.aString18 = "";
								this.aBoolean60 = true;
							}
						}
					}
				} while ((local13 < 97 || local13 > 122) && (local13 < 65 || local13 > 90) && (local13 < 48 || local13 > 57) && local13 != 32);
				if (this.aString9.length() < 12) {
					this.aString9 = this.aString9 + (char) local13;
				}
			}
		} catch (@Pc(795) RuntimeException local795) {
			signlink.reporterror("2927, " + arg0 + ", " + local795.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Z)V")
	@Override
	protected void method70(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				this.anInt187 = -398;
			}
			if (this.aBoolean67 || this.aBoolean46 || this.aBoolean57) {
				this.method188(false);
			} else {
				if (this.aBoolean62) {
					this.method130(29510);
				} else {
					this.method116(4);
				}
				this.anInt253 = 0;
			}
		} catch (@Pc(33) RuntimeException local33) {
			signlink.reporterror("57311, " + arg0 + ", " + local33.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(B)V")
	private void method97(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != -70) {
				this.aClass28ArrayArrayArray1 = null;
			}
			@Pc(17) int local17;
			@Pc(24) int local24;
			if (this.anInt320 == 0) {
				local17 = super.anInt131 / 2 - 80;
				local24 = super.anInt132 / 2 + 20;
				local24 += 20;
				if (super.anInt137 == 1 && super.anInt138 >= local17 - 75 && super.anInt138 <= local17 + 75 && super.anInt139 >= local24 - 20 && super.anInt139 <= local24 + 20) {
					this.anInt320 = 3;
					this.anInt272 = 0;
				}
				local17 = super.anInt131 / 2 + 80;
				if (super.anInt137 == 1 && super.anInt138 >= local17 - 75 && super.anInt138 <= local17 + 75 && super.anInt139 >= local24 - 20 && super.anInt139 <= local24 + 20) {
					this.aString15 = "";
					this.aString16 = "Enter your username & password.";
					this.anInt320 = 2;
					this.anInt272 = 0;
				}
			} else if (this.anInt320 == 2) {
				local17 = super.anInt132 / 2 - 40;
				local17 += 30;
				local17 += 25;
				if (super.anInt137 == 1 && super.anInt139 >= local17 - 15 && super.anInt139 < local17) {
					this.anInt272 = 0;
				}
				local17 += 15;
				if (super.anInt137 == 1 && super.anInt139 >= local17 - 15 && super.anInt139 < local17) {
					this.anInt272 = 1;
				}
				local17 += 15;
				local24 = super.anInt131 / 2 - 80;
				@Pc(170) int local170 = super.anInt132 / 2 + 50;
				@Pc(171) int local171 = local170 + 20;
				if (super.anInt137 == 1 && super.anInt138 >= local24 - 75 && super.anInt138 <= local24 + 75 && super.anInt139 >= local171 - 20 && super.anInt139 <= local171 + 20) {
					this.method159(this.aString13, this.aString14, false);
				}
				local24 = super.anInt131 / 2 + 80;
				if (super.anInt137 == 1 && super.anInt138 >= local24 - 75 && super.anInt138 <= local24 + 75 && super.anInt139 >= local171 - 20 && super.anInt139 <= local171 + 20) {
					this.anInt320 = 0;
					this.aString13 = "";
					this.aString14 = "";
				}
				while (true) {
					while (true) {
						@Pc(254) int local254 = this.method66(false);
						if (local254 == -1) {
							return;
						}
						@Pc(259) boolean local259 = false;
						for (@Pc(261) int local261 = 0; local261 < Static6.aString4.length(); local261++) {
							if (local254 == Static6.aString4.charAt(local261)) {
								local259 = true;
								break;
							}
						}
						if (this.anInt272 == 0) {
							if (local254 == 8 && this.aString13.length() > 0) {
								this.aString13 = this.aString13.substring(0, this.aString13.length() - 1);
							}
							if (local254 == 9 || local254 == 10 || local254 == 13) {
								this.anInt272 = 1;
							}
							if (local259) {
								this.aString13 = this.aString13 + (char) local254;
							}
							if (this.aString13.length() > 12) {
								this.aString13 = this.aString13.substring(0, 12);
							}
						} else if (this.anInt272 == 1) {
							if (local254 == 8 && this.aString14.length() > 0) {
								this.aString14 = this.aString14.substring(0, this.aString14.length() - 1);
							}
							if (local254 == 9 || local254 == 10 || local254 == 13) {
								this.anInt272 = 0;
							}
							if (local259) {
								this.aString14 = this.aString14 + (char) local254;
							}
							if (this.aString14.length() > 20) {
								this.aString14 = this.aString14.substring(0, 20);
							}
						}
					}
				}
			} else if (this.anInt320 == 3) {
				local17 = super.anInt131 / 2;
				local24 = super.anInt132 / 2 + 50;
				@Pc(418) int local418 = local24 + 20;
				if (super.anInt137 == 1 && super.anInt138 >= local17 - 75 && super.anInt138 <= local17 + 75 && super.anInt139 >= local418 - 20 && super.anInt139 <= local418 + 20) {
					this.anInt320 = 0;
					return;
				}
			}
		} catch (@Pc(451) RuntimeException local451) {
			signlink.reporterror("38328, " + arg0 + ", " + local451.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;II)Lclient!ub;")
	private Class39 method98(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			@Pc(3) int local3 = 5;
			@Pc(6) byte[] local6 = signlink.cacheload(arg2);
			@Pc(20) int local20;
			if (local6 != null) {
				this.aCRC32_1.reset();
				this.aCRC32_1.update(local6);
				local20 = (int) this.aCRC32_1.getValue();
				if (local20 != arg1) {
					local6 = null;
				}
			}
			if (local6 != null) {
				return new Class39(local6, this.aBoolean55);
			}
			while (local6 == null) {
				this.method74(true, "Requesting " + arg0, arg3);
				try {
					local20 = 0;
					@Pc(60) DataInputStream local60 = this.method155(arg2 + arg1);
					@Pc(63) byte[] local63 = new byte[6];
					local60.readFully(local63, 0, 6);
					@Pc(74) Class1_Sub3_Sub3 local74 = new Class1_Sub3_Sub3(363, local63);
					local74.anInt561 = 3;
					@Pc(82) int local82 = local74.method395() + 6;
					@Pc(84) int local84 = 6;
					local6 = new byte[local82];
					for (@Pc(89) int local89 = 0; local89 < 6; local89++) {
						local6[local89] = local63[local89];
					}
					while (local84 < local82) {
						@Pc(107) int local107 = local82 - local84;
						if (local107 > 1000) {
							local107 = 1000;
						}
						local84 += local60.read(local6, local84, local107);
						@Pc(126) int local126 = local84 * 100 / local82;
						if (local126 != local20) {
							this.method74(true, "Loading " + arg0 + " - " + local126 + "%", arg3);
						}
						local20 = local126;
					}
					local60.close();
				} catch (@Pc(155) IOException local155) {
					local6 = null;
					for (local20 = local3; local20 > 0; local20--) {
						this.method74(true, "Error loading - Will retry in " + local20 + " secs.", arg3);
						try {
							Thread.sleep(1000L);
						} catch (@Pc(178) Exception local178) {
						}
					}
					local3 *= 2;
					if (local3 > 60) {
						local3 = 60;
					}
				}
			}
			signlink.cachesave(arg2, local6);
			if (arg4 != 0) {
				for (local20 = 1; local20 > 0; local20++) {
				}
			}
			return new Class39(local6, this.aBoolean55);
		} catch (@Pc(216) RuntimeException local216) {
			signlink.reporterror("37683, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local216.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(Z)V")
	private void method99(@OriginalArg(0) boolean arg0) {
		try {
			this.aBoolean54 = false;
			while (this.aBoolean70) {
				this.aBoolean54 = false;
				try {
					Thread.sleep(50L);
				} catch (@Pc(13) Exception local13) {
				}
			}
			this.aClass1_Sub3_Sub2_Sub3_19 = null;
			this.aClass1_Sub3_Sub2_Sub3_20 = null;
			this.aClass1_Sub3_Sub2_Sub3Array2 = null;
			this.anIntArray50 = null;
			this.anIntArray51 = null;
			this.anIntArray52 = null;
			this.anIntArray53 = null;
			this.anIntArray41 = null;
			this.anIntArray42 = null;
			if (!arg0) {
				for (@Pc(48) int local48 = 1; local48 > 0; local48++) {
				}
			}
			this.anIntArray64 = null;
			this.anIntArray65 = null;
			this.aClass1_Sub3_Sub2_Sub2_3 = null;
			this.aClass1_Sub3_Sub2_Sub2_4 = null;
		} catch (@Pc(67) RuntimeException local67) {
			signlink.reporterror("17778, " + arg0 + ", " + local67.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIII)V")
	private void method100(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			@Pc(5) int local5 = 2048 - arg3 & 0x7FF;
			@Pc(11) int local11 = 2048 - arg2 & 0x7FF;
			@Pc(13) int local13 = 0;
			@Pc(15) int local15 = 0;
			@Pc(17) int local17 = arg6;
			@Pc(23) int local23;
			@Pc(27) int local27;
			@Pc(37) int local37;
			if (local5 != 0) {
				local23 = Static10.anIntArray124[local5];
				local27 = Static10.anIntArray125[local5];
				local37 = local15 * local27 - arg6 * local23 >> 16;
				local17 = local15 * local23 + arg6 * local27 >> 16;
				local15 = local37;
			}
			if (local11 != 0) {
				local23 = Static10.anIntArray124[local11];
				local27 = Static10.anIntArray125[local11];
				local37 = local17 * local23 + local13 * local27 >> 16;
				local17 = local17 * local27 - local13 * local23 >> 16;
				local13 = local37;
			}
			this.anInt322 = arg1 - local13;
			this.anInt323 = arg0 - local15;
			this.anInt324 = arg5 - local17;
			this.anInt325 = arg3;
			if (arg4 != 16418) {
				this.aClass28ArrayArrayArray1 = null;
			}
			this.anInt326 = arg2;
		} catch (@Pc(110) RuntimeException local110) {
			signlink.reporterror("79526, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local110.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZ)V")
	private void method102(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
		try {
			if (!arg1) {
				this.anInt179 = -1;
			}
			if (!Static6.aBoolean53) {
				@Pc(17) Class1_Sub3_Sub2_Sub3 local17;
				@Pc(25) int local25;
				@Pc(33) int local33;
				@Pc(36) byte[] local36;
				@Pc(39) byte[] local39;
				@Pc(41) int local41;
				if (Static15.anIntArray141[17] >= arg0) {
					local17 = Static15.aClass1_Sub3_Sub2_Sub3Array4[17];
					local25 = local17.anInt513 * local17.anInt514 - 1;
					local33 = local17.anInt513 * this.anInt270 * 2;
					local36 = local17.aByteArray6;
					local39 = this.aByteArray4;
					for (local41 = 0; local41 <= local25; local41++) {
						local39[local41] = local36[local41 - local33 & local25];
					}
					local17.aByteArray6 = local39;
					this.aByteArray4 = local36;
					Static15.method294(17, 150);
				}
				if (Static15.anIntArray141[24] >= arg0) {
					local17 = Static15.aClass1_Sub3_Sub2_Sub3Array4[24];
					local25 = local17.anInt513 * local17.anInt514 - 1;
					local33 = local17.anInt513 * this.anInt270 * 2;
					local36 = local17.aByteArray6;
					local39 = this.aByteArray4;
					for (local41 = 0; local41 <= local25; local41++) {
						local39[local41] = local36[local41 - local33 & local25];
					}
					local17.aByteArray6 = local39;
					this.aByteArray4 = local36;
					Static15.method294(24, 150);
					return;
				}
			}
		} catch (@Pc(126) RuntimeException local126) {
			signlink.reporterror("14523, " + arg0 + ", " + arg1 + ", " + local126.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(Z)V")
	private void method103(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(3) short local3 = 256;
			@Pc(12) int local12;
			for (@Pc(5) int local5 = 10; local5 < 117; local5++) {
				local12 = (int) (Math.random() * 100.0D);
				if (local12 < 50) {
					this.anIntArray64[local5 + (local3 - 2 << 7)] = 255;
				}
			}
			@Pc(41) int local41;
			@Pc(48) int local48;
			@Pc(54) int local54;
			for (local12 = 0; local12 < 100; local12++) {
				local41 = (int) (Math.random() * 124.0D) + 2;
				local48 = (int) (Math.random() * 128.0D) + 128;
				local54 = local41 + (local48 << 7);
				this.anIntArray64[local54] = 192;
			}
			if (!arg0) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			for (local41 = 1; local41 < local3 - 1; local41++) {
				for (local48 = 1; local48 < 127; local48++) {
					local54 = local48 + (local41 << 7);
					this.anIntArray65[local54] = (this.anIntArray64[local54 - 1] + this.anIntArray64[local54 + 1] + this.anIntArray64[local54 - 128] + this.anIntArray64[local54 + 128]) / 4;
				}
			}
			this.anInt344 += 128;
			if (this.anInt344 > this.anIntArray41.length) {
				this.anInt344 -= this.anIntArray41.length;
				local48 = (int) (Math.random() * 12.0D);
				this.method183(578, this.aClass1_Sub3_Sub2_Sub3Array2[local48]);
			}
			@Pc(173) int local173;
			for (local48 = 1; local48 < local3 - 1; local48++) {
				for (local54 = 1; local54 < 127; local54++) {
					local173 = local54 + (local48 << 7);
					@Pc(196) int local196 = this.anIntArray65[local173 + 128] - this.anIntArray41[local173 + this.anInt344 & this.anIntArray41.length - 1] / 5;
					if (local196 < 0) {
						local196 = 0;
					}
					this.anIntArray64[local173] = local196;
				}
			}
			for (local54 = 0; local54 < local3 - 1; local54++) {
				this.anIntArray43[local54] = this.anIntArray43[local54 + 1];
			}
			this.anIntArray43[local3 - 1] = (int) (Math.sin((double) Static6.anInt266 / 14.0D) * 16.0D + Math.sin((double) Static6.anInt266 / 15.0D) * 14.0D + Math.sin((double) Static6.anInt266 / 16.0D) * 12.0D);
			if (this.anInt227 > 0) {
				this.anInt227 -= 4;
			}
			if (this.anInt228 > 0) {
				this.anInt228 -= 4;
			}
			if (this.anInt227 == 0 && this.anInt228 == 0) {
				local173 = (int) (Math.random() * 2000.0D);
				if (local173 == 0) {
					this.anInt227 = 1024;
				}
				if (local173 == 1) {
					this.anInt228 = 1024;
					return;
				}
			}
		} catch (@Pc(307) RuntimeException local307) {
			signlink.reporterror("55623, " + arg0 + ", " + local307.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
	private void method104(@OriginalArg(0) byte arg0) {
		try {
			this.aClass32_26.method463((byte) 62);
			if (arg0 != -46) {
				this.method67();
			}
			@Pc(18) int local18 = this.anInt200 + this.anInt308 & 0x7FF;
			@Pc(26) int local26 = this.aClass1_Sub1_Sub3_Sub2_1.anInt882 / 32 + 48;
			@Pc(34) int local34 = 464 - this.aClass1_Sub1_Sub3_Sub2_1.anInt883 / 32;
			this.aClass1_Sub3_Sub2_Sub2_6.method328(local18, 146, this.anIntArray83, 151, local34, this.anInt249 + 256, local26, 21, 9, false, this.anIntArray61);
			this.aClass1_Sub3_Sub2_Sub2_11.method328(this.anInt200, 33, this.anIntArray44, 33, 25, 256, 25, 0, 0, false, this.anIntArray81);
			for (@Pc(72) int local72 = 0; local72 < this.anInt246; local72++) {
				local26 = this.anIntArray54[local72] * 4 + 2 - this.aClass1_Sub1_Sub3_Sub2_1.anInt882 / 32;
				local34 = this.anIntArray55[local72] * 4 + 2 - this.aClass1_Sub1_Sub3_Sub2_1.anInt883 / 32;
				this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2Array4[local72], local26);
			}
			@Pc(124) int local124;
			for (@Pc(120) int local120 = 0; local120 < 104; local120++) {
				for (local124 = 0; local124 < 104; local124++) {
					@Pc(136) Class28 local136 = this.aClass28ArrayArrayArray1[this.anInt231][local120][local124];
					if (local136 != null) {
						local26 = local120 * 4 + 2 - this.aClass1_Sub1_Sub3_Sub2_1.anInt882 / 32;
						local34 = local124 * 4 + 2 - this.aClass1_Sub1_Sub3_Sub2_1.anInt883 / 32;
						this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2_7, local26);
					}
				}
			}
			for (local124 = 0; local124 < this.anInt248; local124++) {
				@Pc(189) Class1_Sub1_Sub3_Sub1 local189 = this.aClass1_Sub1_Sub3_Sub1Array1[this.anIntArray58[local124]];
				if (local189 != null && local189.method571(false) && local189.aClass3_1.aBoolean20) {
					local26 = local189.anInt882 / 32 - this.aClass1_Sub1_Sub3_Sub2_1.anInt882 / 32;
					local34 = local189.anInt883 / 32 - this.aClass1_Sub1_Sub3_Sub2_1.anInt883 / 32;
					this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2_8, local26);
				}
			}
			for (@Pc(235) int local235 = 0; local235 < this.anInt205; local235++) {
				@Pc(245) Class1_Sub1_Sub3_Sub2 local245 = this.aClass1_Sub1_Sub3_Sub2Array1[this.anIntArray39[local235]];
				if (local245 != null && local245.method571(false)) {
					local26 = local245.anInt882 / 32 - this.aClass1_Sub1_Sub3_Sub2_1.anInt882 / 32;
					local34 = local245.anInt883 / 32 - this.aClass1_Sub1_Sub3_Sub2_1.anInt883 / 32;
					@Pc(275) boolean local275 = false;
					@Pc(279) long local279 = Static30.method538(local245.aString29);
					for (@Pc(281) int local281 = 0; local281 < this.anInt312; local281++) {
						if (local279 == this.aLongArray4[local281] && this.anIntArray34[local281] != 0) {
							local275 = true;
							break;
						}
					}
					if (local275) {
						this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2_10, local26);
					} else {
						this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2_9, local26);
					}
				}
			}
			if (this.anInt296 != 0) {
				local26 = this.anInt296 * 4 + 2 - this.aClass1_Sub1_Sub3_Sub2_1.anInt882 / 32;
				local34 = this.anInt297 * 4 + 2 - this.aClass1_Sub1_Sub3_Sub2_1.anInt883 / 32;
				this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2_5, local26);
			}
			Static12.method358(82, 93, 16777215, (byte) 93, 3, 3);
			this.aClass32_27.method463((byte) 62);
		} catch (@Pc(376) RuntimeException local376) {
			signlink.reporterror("54096, " + arg0 + ", " + local376.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(B)Ljava/awt/Component;")
	@Override
	protected Component method72(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != 3) {
				this.anInt167 = 260;
			}
			if (signlink.mainapp == null) {
				return super.aFrame_Sub1_2 == null ? this : super.aFrame_Sub1_2;
			} else {
				return signlink.mainapp;
			}
		} catch (@Pc(18) RuntimeException local18) {
			signlink.reporterror("31136, " + arg0 + ", " + local18.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(I)V")
	private void method105(@OriginalArg(0) int arg0) {
		try {
			if (arg0 <= 0) {
				this.method67();
			}
			if (this.anInt307 == 2) {
				for (@Pc(12) Class1_Sub5 local12 = (Class1_Sub5) this.aClass28_2.method456(); local12 != null; local12 = (Class1_Sub5) this.aClass28_2.method458(551)) {
					if (Static6.anInt266 >= local12.anInt638) {
						this.method160(local12.anInt636, local12.anInt633, local12.anInt634, local12.anInt632, local12.anInt635, local12.anInt637, -27819, local12.anInt631);
						local12.method567();
					}
				}
				Static6.anInt319++;
				if (Static6.anInt319 > 85) {
					Static6.anInt319 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 85);
					return;
				}
			}
		} catch (@Pc(61) RuntimeException local61) {
			signlink.reporterror("93334, " + arg0 + ", " + local61.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(II)V")
	private void method106(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(5) int[] local5 = this.aClass1_Sub3_Sub2_Sub2_6.anIntArray148;
			if (arg1 < 0) {
				@Pc(11) int local11 = local5.length;
				for (@Pc(13) int local13 = 0; local13 < local11; local13++) {
					local5[local13] = 0;
				}
				@Pc(37) int local37;
				@Pc(39) int local39;
				for (@Pc(25) int local25 = 1; local25 < 103; local25++) {
					local37 = (103 - local25) * 512 * 4 + 24628;
					for (local39 = 1; local39 < 103; local39++) {
						if ((this.aByteArrayArrayArray7[arg0][local39][local25] & 0x18) == 0) {
							this.aClass33_1.method503(local5, local37, 512, arg0, local39, local25);
						}
						if (arg0 < 3 && (this.aByteArrayArrayArray7[arg0 + 1][local39][local25] & 0x8) != 0) {
							this.aClass33_1.method503(local5, local37, 512, arg0 + 1, local39, local25);
						}
						local37 += 4;
					}
				}
				local37 = ((int) (Math.random() * 20.0D) + 238 - 10 << 16) + ((int) (Math.random() * 20.0D) + 238 - 10 << 8) + (int) (Math.random() * 20.0D) + 238 - 10;
				local39 = (int) (Math.random() * 20.0D) + 238 - 10 << 16;
				this.aClass1_Sub3_Sub2_Sub2_6.method318((byte) 62);
				@Pc(149) int local149;
				for (@Pc(145) int local145 = 1; local145 < 103; local145++) {
					for (local149 = 1; local149 < 103; local149++) {
						if ((this.aByteArrayArrayArray7[arg0][local149][local145] & 0x18) == 0) {
							this.method107(Static6.anInt238, arg0, local37, local149, local39, local145);
						}
						if (arg0 < 3 && (this.aByteArrayArrayArray7[arg0 + 1][local149][local145] & 0x8) != 0) {
							this.method107(Static6.anInt238, arg0 + 1, local37, local149, local39, local145);
						}
					}
				}
				this.aClass32_27.method463((byte) 62);
				this.anInt246 = 0;
				for (local149 = 0; local149 < 104; local149++) {
					for (@Pc(217) int local217 = 0; local217 < 104; local217++) {
						@Pc(227) int local227 = this.aClass33_1.method497(this.anInt231, local149, local217);
						if (local227 != 0) {
							local227 = local227 >> 14 & 0x7FFF;
							@Pc(239) int local239 = Static2.method23(local227).anInt47;
							if (local239 >= 0) {
								@Pc(243) int local243 = local149;
								@Pc(245) int local245 = local217;
								if (local239 != 22 && local239 != 29 && local239 != 34 && local239 != 36 && local239 != 46 && local239 != 47 && local239 != 48) {
									@Pc(268) byte local268 = 104;
									@Pc(270) byte local270 = 104;
									@Pc(277) int[][] local277 = this.aClass9Array1[this.anInt231].anIntArrayArray10;
									for (@Pc(279) int local279 = 0; local279 < 10; local279++) {
										@Pc(286) int local286 = (int) (Math.random() * 4.0D);
										if (local286 == 0 && local243 > 0 && local243 > local149 - 3 && (local277[local243 - 1][local245] & 0x280108) == 0) {
											local243--;
										}
										if (local286 == 1 && local243 < local268 - 1 && local243 < local149 + 3 && (local277[local243 + 1][local245] & 0x280180) == 0) {
											local243++;
										}
										if (local286 == 2 && local245 > 0 && local245 > local217 - 3 && (local277[local243][local245 - 1] & 0x280102) == 0) {
											local245--;
										}
										if (local286 == 3 && local245 < local270 - 1 && local245 < local217 + 3 && (local277[local243][local245 + 1] & 0x280120) == 0) {
											local245++;
										}
									}
								}
								this.aClass1_Sub3_Sub2_Sub2Array4[this.anInt246] = this.aClass1_Sub3_Sub2_Sub2Array7[local239];
								this.anIntArray54[this.anInt246] = local243;
								this.anIntArray55[this.anInt246] = local245;
								this.anInt246++;
							}
						}
					}
				}
			}
		} catch (@Pc(416) RuntimeException local416) {
			signlink.reporterror("23407, " + arg0 + ", " + arg1 + ", " + local416.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIII)V")
	private void method107(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			@Pc(8) int local8 = this.aClass33_1.method494(arg1, arg3, arg5);
			@Pc(18) int local18;
			@Pc(24) int local24;
			@Pc(28) int local28;
			@Pc(30) int local30;
			@Pc(52) int local52;
			@Pc(58) int local58;
			if (local8 != 0) {
				local18 = this.aClass33_1.method498(arg1, arg3, arg5, local8);
				local24 = local18 >> 6 & 0x3;
				local28 = local18 & 0x1F;
				local30 = arg2;
				if (local8 > 0) {
					local30 = arg4;
				}
				@Pc(38) int[] local38 = this.aClass1_Sub3_Sub2_Sub2_6.anIntArray148;
				local52 = arg3 * 4 + (103 - arg5) * 512 * 4 + 24624;
				local58 = local8 >> 14 & 0x7FFF;
				@Pc(61) Class2 local61 = Static2.method23(local58);
				if (local61.anInt48 == -1) {
					if (local28 == 0 || local28 == 2) {
						if (local24 == 0) {
							local38[local52] = local30;
							local38[local52 + 512] = local30;
							local38[local52 + 1024] = local30;
							local38[local52 + 1536] = local30;
						} else if (local24 == 1) {
							local38[local52] = local30;
							local38[local52 + 1] = local30;
							local38[local52 + 2] = local30;
							local38[local52 + 3] = local30;
						} else if (local24 == 2) {
							local38[local52 + 3] = local30;
							local38[local52 + 3 + 512] = local30;
							local38[local52 + 3 + 1024] = local30;
							local38[local52 + 3 + 1536] = local30;
						} else if (local24 == 3) {
							local38[local52 + 1536] = local30;
							local38[local52 + 1536 + 1] = local30;
							local38[local52 + 1536 + 2] = local30;
							local38[local52 + 1536 + 3] = local30;
						}
					}
					if (local28 == 3) {
						if (local24 == 0) {
							local38[local52] = local30;
						} else if (local24 == 1) {
							local38[local52 + 3] = local30;
						} else if (local24 == 2) {
							local38[local52 + 3 + 1536] = local30;
						} else if (local24 == 3) {
							local38[local52 + 1536] = local30;
						}
					}
					if (local28 == 2) {
						if (local24 == 3) {
							local38[local52] = local30;
							local38[local52 + 512] = local30;
							local38[local52 + 1024] = local30;
							local38[local52 + 1536] = local30;
						} else if (local24 == 0) {
							local38[local52] = local30;
							local38[local52 + 1] = local30;
							local38[local52 + 2] = local30;
							local38[local52 + 3] = local30;
						} else if (local24 == 1) {
							local38[local52 + 3] = local30;
							local38[local52 + 3 + 512] = local30;
							local38[local52 + 3 + 1024] = local30;
							local38[local52 + 3 + 1536] = local30;
						} else if (local24 == 2) {
							local38[local52 + 1536] = local30;
							local38[local52 + 1536 + 1] = local30;
							local38[local52 + 1536 + 2] = local30;
							local38[local52 + 1536 + 3] = local30;
						}
					}
				} else {
					@Pc(71) Class1_Sub3_Sub2_Sub3 local71 = this.aClass1_Sub3_Sub2_Sub3Array3[local61.anInt48];
					if (local71 != null) {
						@Pc(83) int local83 = (local61.anInt43 * 4 - local71.anInt513) / 2;
						@Pc(93) int local93 = (local61.anInt44 * 4 - local71.anInt514) / 2;
						local71.method350((104 - arg5 - local61.anInt44) * 4 + local93 + 48, arg3 * 4 + 48 + local83, false);
					}
				}
			}
			local8 = this.aClass33_1.method496(arg1, arg3, arg5);
			@Pc(422) int local422 = 56 / arg0;
			if (local8 != 0) {
				local18 = this.aClass33_1.method498(arg1, arg3, arg5, local8);
				local24 = local18 >> 6 & 0x3;
				local28 = local18 & 0x1F;
				local30 = local8 >> 14 & 0x7FFF;
				@Pc(451) Class2 local451 = Static2.method23(local30);
				@Pc(483) int local483;
				if (local451.anInt48 != -1) {
					@Pc(461) Class1_Sub3_Sub2_Sub3 local461 = this.aClass1_Sub3_Sub2_Sub3Array3[local451.anInt48];
					if (local461 != null) {
						local58 = (local451.anInt43 * 4 - local461.anInt513) / 2;
						local483 = (local451.anInt44 * 4 - local461.anInt514) / 2;
						local461.method350((104 - arg5 - local451.anInt44) * 4 + local483 + 48, arg3 * 4 + 48 + local58, false);
					}
				} else if (local28 == 9) {
					local52 = 15658734;
					if (local8 > 0) {
						local52 = 15597568;
					}
					@Pc(520) int[] local520 = this.aClass1_Sub3_Sub2_Sub2_6.anIntArray148;
					local483 = arg3 * 4 + (103 - arg5) * 512 * 4 + 24624;
					if (local24 == 0 || local24 == 2) {
						local520[local483 + 1536] = local52;
						local520[local483 + 1024 + 1] = local52;
						local520[local483 + 512 + 2] = local52;
						local520[local483 + 3] = local52;
					} else {
						local520[local483] = local52;
						local520[local483 + 512 + 1] = local52;
						local520[local483 + 1024 + 2] = local52;
						local520[local483 + 1536 + 3] = local52;
					}
				}
			}
			local8 = this.aClass33_1.method497(arg1, arg3, arg5);
			if (local8 != 0) {
				local18 = local8 >> 14 & 0x7FFF;
				@Pc(615) Class2 local615 = Static2.method23(local18);
				if (local615.anInt48 != -1) {
					@Pc(625) Class1_Sub3_Sub2_Sub3 local625 = this.aClass1_Sub3_Sub2_Sub3Array3[local615.anInt48];
					if (local625 != null) {
						local30 = (local615.anInt43 * 4 - local625.anInt513) / 2;
						@Pc(647) int local647 = (local615.anInt44 * 4 - local625.anInt514) / 2;
						local625.method350((104 - arg5 - local615.anInt44) * 4 + local647 + 48, arg3 * 4 + 48 + local30, false);
						return;
					}
				}
			}
		} catch (@Pc(671) RuntimeException local671) {
			signlink.reporterror("84395, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local671.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!kb;IZ)V")
	private void method108(@OriginalArg(0) Class1_Sub3_Sub3 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2) {
		try {
			this.anInt255 = 0;
			this.anInt206 = 0;
			this.method181(-542, arg0, arg1);
			this.method141(false, arg0, arg1);
			this.method81(arg0, arg1, this.anInt302);
			if (arg2) {
				Static6.anInt268 = 338;
			}
			@Pc(36) int local36;
			for (@Pc(29) int local29 = 0; local29 < this.anInt255; local29++) {
				local36 = this.anIntArray60[local29];
				if (this.aClass1_Sub1_Sub3_Sub1Array1[local36].anInt924 != Static6.anInt266) {
					this.aClass1_Sub1_Sub3_Sub1Array1[local36].aClass3_1 = null;
					this.aClass1_Sub1_Sub3_Sub1Array1[local36] = null;
				}
			}
			if (arg0.anInt561 != arg1) {
				signlink.reporterror(this.aString13 + " size mismatch in getnpcpos - pos:" + arg0.anInt561 + " psize:" + arg1);
				throw new RuntimeException("eek");
			}
			for (local36 = 0; local36 < this.anInt248; local36++) {
				if (this.aClass1_Sub1_Sub3_Sub1Array1[this.anIntArray58[local36]] == null) {
					signlink.reporterror(this.aString13 + " null entry in npc list - pos:" + local36 + " size:" + this.anInt248);
					throw new RuntimeException("eek");
				}
			}
		} catch (@Pc(126) RuntimeException local126) {
			signlink.reporterror("3750, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local126.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	@Override
	public void method73(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		if (signlink.mainapp == null) {
			super.method73(arg0, arg1);
		} else {
			signlink.startthread(arg0, arg1);
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(I)V")
	private void method109(@OriginalArg(0) int arg0) {
		try {
			this.aClass1_Sub3_Sub2_Sub3_19 = new Class1_Sub3_Sub2_Sub3(this.aClass39_1, "titlebox", 0);
			this.aClass1_Sub3_Sub2_Sub3_20 = new Class1_Sub3_Sub2_Sub3(this.aClass39_1, "titlebutton", 0);
			if (arg0 != 0) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			this.aClass1_Sub3_Sub2_Sub3Array2 = new Class1_Sub3_Sub2_Sub3[12];
			for (@Pc(32) int local32 = 0; local32 < 12; local32++) {
				this.aClass1_Sub3_Sub2_Sub3Array2[local32] = new Class1_Sub3_Sub2_Sub3(this.aClass39_1, "runes", local32);
			}
			this.aClass1_Sub3_Sub2_Sub2_3 = new Class1_Sub3_Sub2_Sub2(128, 265);
			this.aClass1_Sub3_Sub2_Sub2_4 = new Class1_Sub3_Sub2_Sub2(128, 265);
			for (@Pc(65) int local65 = 0; local65 < 33920; local65++) {
				this.aClass1_Sub3_Sub2_Sub2_3.anIntArray148[local65] = this.aClass32_19.anIntArray197[local65];
			}
			for (@Pc(83) int local83 = 0; local83 < 33920; local83++) {
				this.aClass1_Sub3_Sub2_Sub2_4.anIntArray148[local83] = this.aClass32_20.anIntArray197[local83];
			}
			this.anIntArray51 = new int[256];
			for (@Pc(105) int local105 = 0; local105 < 64; local105++) {
				this.anIntArray51[local105] = local105 * 262144;
			}
			for (@Pc(120) int local120 = 0; local120 < 64; local120++) {
				this.anIntArray51[local120 + 64] = local120 * 1024 + 16711680;
			}
			for (@Pc(139) int local139 = 0; local139 < 64; local139++) {
				this.anIntArray51[local139 + 128] = local139 * 4 + 16776960;
			}
			for (@Pc(158) int local158 = 0; local158 < 64; local158++) {
				this.anIntArray51[local158 + 192] = 16777215;
			}
			this.anIntArray52 = new int[256];
			for (@Pc(177) int local177 = 0; local177 < 64; local177++) {
				this.anIntArray52[local177] = local177 * 1024;
			}
			for (@Pc(192) int local192 = 0; local192 < 64; local192++) {
				this.anIntArray52[local192 + 64] = local192 * 4 + 65280;
			}
			for (@Pc(211) int local211 = 0; local211 < 64; local211++) {
				this.anIntArray52[local211 + 128] = local211 * 262144 + 65535;
			}
			for (@Pc(230) int local230 = 0; local230 < 64; local230++) {
				this.anIntArray52[local230 + 192] = 16777215;
			}
			this.anIntArray53 = new int[256];
			for (@Pc(249) int local249 = 0; local249 < 64; local249++) {
				this.anIntArray53[local249] = local249 * 4;
			}
			for (@Pc(264) int local264 = 0; local264 < 64; local264++) {
				this.anIntArray53[local264 + 64] = local264 * 262144 + 255;
			}
			for (@Pc(283) int local283 = 0; local283 < 64; local283++) {
				this.anIntArray53[local283 + 128] = local283 * 1024 + 16711935;
			}
			for (@Pc(302) int local302 = 0; local302 < 64; local302++) {
				this.anIntArray53[local302 + 192] = 16777215;
			}
			this.anIntArray50 = new int[256];
			this.anIntArray41 = new int[32768];
			this.anIntArray42 = new int[32768];
			this.method183(578, null);
			this.anIntArray64 = new int[32768];
			this.anIntArray65 = new int[32768];
			this.method74(true, "Connecting to fileserver", 10);
			if (!this.aBoolean54) {
				this.aBoolean63 = true;
				this.aBoolean54 = true;
				this.method73(this, 2);
			}
		} catch (@Pc(359) RuntimeException local359) {
			signlink.reporterror("57688, " + arg0 + ", " + local359.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!kb;I)V")
	private void method110(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(6) int local6 = arg1.method402(9, 8);
			@Pc(10) int local10;
			if (arg2 != 0) {
				for (local10 = 1; local10 > 0; local10++) {
				}
			}
			if (local6 < this.anInt205) {
				for (local10 = local6; local10 < this.anInt205; local10++) {
					this.anIntArray60[this.anInt255++] = this.anIntArray39[local10];
				}
			}
			if (local6 > this.anInt205) {
				signlink.reporterror(this.aString13 + " Too many players");
				throw new RuntimeException("eek");
			}
			this.anInt205 = 0;
			for (local10 = 0; local10 < local6; local10++) {
				@Pc(73) int local73 = this.anIntArray39[local10];
				@Pc(78) Class1_Sub1_Sub3_Sub2 local78 = this.aClass1_Sub1_Sub3_Sub2Array1[local73];
				@Pc(83) int local83 = arg1.method402(9, 1);
				if (local83 == 0) {
					this.anIntArray39[this.anInt205++] = local73;
					local78.anInt924 = Static6.anInt266;
				} else {
					@Pc(106) int local106 = arg1.method402(9, 2);
					if (local106 == 0) {
						this.anIntArray39[this.anInt205++] = local73;
						local78.anInt924 = Static6.anInt266;
						this.anIntArray40[this.anInt206++] = local73;
					} else {
						@Pc(157) int local157;
						@Pc(167) int local167;
						if (local106 == 1) {
							this.anIntArray39[this.anInt205++] = local73;
							local78.anInt924 = Static6.anInt266;
							local157 = arg1.method402(9, 3);
							local78.method570(false, local157, (byte) 6);
							local167 = arg1.method402(9, 1);
							if (local167 == 1) {
								this.anIntArray40[this.anInt206++] = local73;
							}
						} else if (local106 == 2) {
							this.anIntArray39[this.anInt205++] = local73;
							local78.anInt924 = Static6.anInt266;
							local157 = arg1.method402(9, 3);
							local78.method570(true, local157, (byte) 6);
							local167 = arg1.method402(9, 3);
							local78.method570(true, local167, (byte) 6);
							@Pc(225) int local225 = arg1.method402(9, 1);
							if (local225 == 1) {
								this.anIntArray40[this.anInt206++] = local73;
							}
						} else if (local106 == 3) {
							this.anIntArray60[this.anInt255++] = local73;
						}
					}
				}
			}
		} catch (@Pc(262) RuntimeException local262) {
			signlink.reporterror("65167, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local262.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IIIIII)V")
	private void method111(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			this.aClass1_Sub3_Sub2_Sub3_17.method350(arg2, arg1, false);
			this.aClass1_Sub3_Sub2_Sub3_18.method350(arg2 + arg5 - 16, arg1, false);
			Static12.method358(arg2 + 16, arg1, this.anInt295, (byte) 93, 16, arg5 - 32);
			@Pc(35) int local35 = (arg5 - 32) * arg5 / arg4;
			if (local35 < 8) {
				local35 = 8;
			}
			@Pc(52) int local52 = (arg5 - local35 - 32) * arg3 / (arg4 - arg5);
			if (arg0 <= 0) {
				this.anInt179 = -1;
			}
			Static12.method358(arg2 + local52 + 16, arg1, this.anInt345, (byte) 93, 16, local35);
			Static12.method361(this.anInt278, this.anInt145, arg2 + local52 + 16, local35, arg1);
			Static12.method361(this.anInt278, this.anInt145, arg2 + local52 + 16, local35, arg1 + 1);
			Static12.method360(this.anInt278, 0, arg2 + local52 + 16, 16, arg1);
			Static12.method360(this.anInt278, 0, arg2 + local52 + 17, 16, arg1);
			Static12.method361(this.anInt275, this.anInt145, arg2 + local52 + 16, local35, arg1 + 15);
			Static12.method361(this.anInt275, this.anInt145, arg2 + local52 + 17, local35 - 1, arg1 + 14);
			Static12.method360(this.anInt275, 0, arg2 + local52 + local35 + 15, 16, arg1);
			Static12.method360(this.anInt275, 0, arg2 + local52 + local35 + 14, 15, arg1 + 1);
		} catch (@Pc(177) RuntimeException local177) {
			signlink.reporterror("15221, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local177.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(B)V")
	private void method112(@OriginalArg(0) byte arg0) {
		try {
			this.aBoolean39 = true;
			if (arg0 != -6) {
				this.aClass28ArrayArrayArray1 = null;
			}
			for (@Pc(12) int local12 = 0; local12 < 7; local12++) {
				this.anIntArray35[local12] = -1;
				for (@Pc(21) int local21 = 0; local21 < Static16.anInt437; local21++) {
					if (!Static16.aClass13Array1[local21].aBoolean101 && Static16.aClass13Array1[local21].anInt438 == local12 + (this.aBoolean43 ? 0 : 7)) {
						this.anIntArray35[local12] = local21;
						break;
					}
				}
			}
		} catch (@Pc(58) RuntimeException local58) {
			signlink.reporterror("82165, " + arg0 + ", " + local58.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BIIZ)V")
	private void method113(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
		try {
			if (arg1 <= 0) {
				this.aBoolean44 = !this.aBoolean44;
			}
			signlink.midifade = arg3 ? 1 : 0;
			signlink.midisave(arg0, arg2);
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("21924, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(Z)V")
	private void method114(@OriginalArg(0) boolean arg0) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.anInt248; local1++) {
				@Pc(11) Class1_Sub1_Sub3_Sub1 local11 = this.aClass1_Sub1_Sub3_Sub1Array1[this.anIntArray58[local1]];
				@Pc(20) int local20 = (this.anIntArray58[local1] << 14) + 536870912;
				if (local11 != null && local11.method571(false)) {
					@Pc(31) int local31 = local11.anInt882 >> 7;
					@Pc(36) int local36 = local11.anInt883 >> 7;
					if (local31 >= 0 && local31 < 104 && local36 >= 0 && local36 < 104) {
						if (local11.anInt885 == 1 && (local11.anInt882 & 0x7F) == 64 && (local11.anInt883 & 0x7F) == 64) {
							if (this.anIntArrayArray3[local31][local36] == this.anInt211) {
								continue;
							}
							this.anIntArrayArray3[local31][local36] = this.anInt211;
						}
						this.aClass33_1.method478(-44713, local11.anInt883, (local11.anInt885 - 1) * 64 + 60, local11.anInt884, local11.anInt882, local20, local11.aBoolean160, null, local11, this.method94(this.anInt231, local11.anInt882, (byte) 5, local11.anInt883), this.anInt231);
					}
				}
			}
			if (arg0) {
				this.anInt179 = -1;
			}
		} catch (@Pc(126) RuntimeException local126) {
			signlink.reporterror("90018, " + arg0 + ", " + local126.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZ)V")
	private void method115(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2) {
		try {
			signlink.midivol = arg1;
			this.anInt178 += arg0;
			if (arg2) {
				signlink.midi = "voladjust";
			}
		} catch (@Pc(13) RuntimeException local13) {
			signlink.reporterror("59417, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local13.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(I)V")
	private void method116(@OriginalArg(0) int arg0) {
		try {
			this.method156((byte) 99);
			this.aClass32_18.method463((byte) 62);
			if (arg0 >= 4 && arg0 <= 4) {
				this.aClass1_Sub3_Sub2_Sub3_19.method350(0, 0, false);
				@Pc(21) short local21 = 360;
				@Pc(23) short local23 = 200;
				@Pc(32) int local32;
				@Pc(50) int local50;
				@Pc(56) int local56;
				if (this.anInt320 == 0) {
					local32 = local23 / 2 - 20;
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16776960, true, local32, "Welcome to RuneScape", 0);
					@Pc(44) int local44 = local32 + 30;
					local50 = local21 / 2 - 80;
					local56 = local23 / 2 + 20;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local50, 16777215, true, local56 + 5, "New user", 0);
					@Pc(83) int local83 = local21 / 2 + 80;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local83 - 73, false);
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local83, 16777215, true, local56 + 5, "Existing User", 0);
				}
				if (this.anInt320 == 2) {
					local32 = local23 / 2 - 40;
					if (this.aString15.length() > 0) {
						this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16776960, true, local32 - 15, this.aString15, 0);
						this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16776960, true, local32, this.aString16, 0);
						local32 += 30;
					} else {
						this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16776960, true, local32 - 7, this.aString16, 0);
						local32 += 30;
					}
					this.aClass1_Sub3_Sub2_Sub4_3.method367(local21 / 2 - 90, 6, local32, "Username: " + this.aString13 + (this.anInt272 == 0 & Static6.anInt266 % 40 < 20 ? "@yel@|" : ""), true, 16777215);
					local32 += 15;
					this.aClass1_Sub3_Sub2_Sub4_3.method367(local21 / 2 - 88, 6, local32, "Password: " + Static30.method544(7, this.aString14) + (this.anInt272 == 1 & Static6.anInt266 % 40 < 20 ? "@yel@|" : ""), true, 16777215);
					local32 += 15;
					local50 = local21 / 2 - 80;
					local56 = local23 / 2 + 50;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local50, 16777215, true, local56 + 5, "Login", 0);
					local50 = local21 / 2 + 80;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local50, 16777215, true, local56 + 5, "Cancel", 0);
				}
				if (this.anInt320 == 3) {
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16776960, true, local23 / 2 - 60, "Create a free account", 0);
					local32 = local23 / 2 - 35;
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16777215, true, local32, "To create a new account you need to", 0);
					local32 += 15;
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16777215, true, local32, "go back to the main RuneScape webpage", 0);
					local32 += 15;
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16777215, true, local32, "and choose the red 'create account'", 0);
					local32 += 15;
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local21 / 2, 16777215, true, local32, "button at the top right of that page.", 0);
					local32 += 15;
					local50 = local21 / 2;
					local56 = local23 / 2 + 50;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.aClass1_Sub3_Sub2_Sub4_3.method363(local50, 16777215, true, local56 + 5, "Cancel", 0);
				}
				this.aClass32_18.method464(186, super.aGraphics2, 214, 5193);
				if (this.aBoolean37) {
					this.aBoolean37 = false;
					this.aClass32_16.method464(0, super.aGraphics2, 128, 5193);
					this.aClass32_17.method464(386, super.aGraphics2, 214, 5193);
					this.aClass32_21.method464(265, super.aGraphics2, 0, 5193);
					this.aClass32_22.method464(265, super.aGraphics2, 574, 5193);
					this.aClass32_23.method464(186, super.aGraphics2, 128, 5193);
					this.aClass32_24.method464(186, super.aGraphics2, 574, 5193);
				}
			}
		} catch (@Pc(475) RuntimeException local475) {
			signlink.reporterror("76487, " + arg0 + ", " + local475.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(I)V")
	private void method117(@OriginalArg(0) int arg0) {
		try {
			if (this.aClass32_28 == null) {
				this.method99(true);
				super.aClass32_2 = null;
				this.aClass32_16 = null;
				this.aClass32_17 = null;
				this.aClass32_18 = null;
				this.aClass32_19 = null;
				if (arg0 == -7185) {
					this.aClass32_20 = null;
					this.aClass32_21 = null;
					this.aClass32_22 = null;
					this.aClass32_23 = null;
					this.aClass32_24 = null;
					this.aClass32_28 = new Class32(this.method72(Static6.aByte16), 479, 299, 96);
					this.aClass32_26 = new Class32(this.method72(Static6.aByte16), 168, 299, 160);
					Static12.method357(this.anInt336);
					this.aClass1_Sub3_Sub2_Sub3_10.method350(0, 0, false);
					this.aClass32_25 = new Class32(this.method72(Static6.aByte16), 190, 299, 261);
					this.aClass32_27 = new Class32(this.method72(Static6.aByte16), 512, 299, 334);
					Static12.method357(this.anInt336);
					this.aClass32_3 = new Class32(this.method72(Static6.aByte16), 501, 299, 61);
					this.aClass32_4 = new Class32(this.method72(Static6.aByte16), 288, 299, 40);
					this.aClass32_5 = new Class32(this.method72(Static6.aByte16), 269, 299, 66);
					this.aBoolean37 = true;
				}
			}
		} catch (@Pc(134) RuntimeException local134) {
			signlink.reporterror("20178, " + arg0 + ", " + local134.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!kb;)V")
	private void method118(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class1_Sub3_Sub3 arg2) {
		try {
			@Pc(9) int local9;
			if (arg0 < 2 || arg0 > 2) {
				for (local9 = 1; local9 > 0; local9++) {
				}
			}
			while (arg2.anInt562 + 10 < arg1 * 8) {
				local9 = arg2.method402(9, 11);
				if (local9 == 2047) {
					break;
				}
				if (this.aClass1_Sub1_Sub3_Sub2Array1[local9] == null) {
					this.aClass1_Sub1_Sub3_Sub2Array1[local9] = new Class1_Sub1_Sub3_Sub2();
					if (this.aClass1_Sub3_Sub3Array1[local9] != null) {
						this.aClass1_Sub1_Sub3_Sub2Array1[local9].method572(false, this.aClass1_Sub3_Sub3Array1[local9]);
					}
				}
				this.anIntArray39[this.anInt205++] = local9;
				@Pc(73) Class1_Sub1_Sub3_Sub2 local73 = this.aClass1_Sub1_Sub3_Sub2Array1[local9];
				local73.anInt924 = Static6.anInt266;
				@Pc(81) int local81 = arg2.method402(9, 5);
				if (local81 > 15) {
					local81 -= 32;
				}
				@Pc(90) int local90 = arg2.method402(9, 5);
				if (local90 > 15) {
					local90 -= 32;
				}
				@Pc(99) int local99 = arg2.method402(9, 1);
				local73.method569(false, local99 == 1, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0] + local81, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0] + local90);
				@Pc(127) int local127 = arg2.method402(9, 1);
				if (local127 == 1) {
					this.anIntArray40[this.anInt206++] = local9;
				}
			}
			arg2.method403(this.anInt197);
		} catch (@Pc(149) RuntimeException local149) {
			signlink.reporterror("52149, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local149.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "q", descriptor = "(I)V")
	private void method119(@OriginalArg(0) int arg0) {
		try {
			try {
				if (this.aClass6_1 != null) {
					this.aClass6_1.method201();
				}
			} catch (@Pc(9) Exception local9) {
			}
			this.aClass6_1 = null;
			this.aBoolean62 = false;
			this.anInt320 = 0;
			this.aString13 = "";
			this.aString14 = "";
			Static9.method209((byte) 65);
			this.method144(this.aByte10);
			if (arg0 < 0) {
				this.aClass33_1.method467(742);
				for (@Pc(41) int local41 = 0; local41 < 4; local41++) {
					this.aClass9Array1[local41].method249((byte) 74);
				}
				System.gc();
				this.method78(0);
				this.aString17 = null;
				this.anInt157 = 0;
			}
		} catch (@Pc(65) RuntimeException local65) {
			signlink.reporterror("36279, " + arg0 + ", " + local65.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;I)V")
	private void method120(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class15 arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg3.anInt472 == 0 && arg3.anIntArray153 != null && (!arg3.aBoolean106 || this.anInt300 == arg3.anInt470 || this.anInt256 == arg3.anInt470 || this.anInt221 == arg3.anInt470)) {
				@Pc(29) int local29 = Static12.anInt532;
				@Pc(31) int local31 = Static12.anInt530;
				@Pc(33) int local33 = Static12.anInt533;
				@Pc(35) int local35 = Static12.anInt531;
				if (arg2 != 38682) {
					this.anInt179 = -1;
				}
				Static12.method356(arg0 + arg3.anInt476, arg0, arg1 + arg3.anInt475, 789, arg1);
				@Pc(57) int local57 = arg3.anIntArray153.length;
				for (@Pc(59) int local59 = 0; local59 < local57; local59++) {
					@Pc(68) int local68 = arg3.anIntArray154[local59] + arg1;
					@Pc(77) int local77 = arg3.anIntArray155[local59] + arg0 - arg4;
					@Pc(84) Class15 local84 = Static17.aClass15Array1[arg3.anIntArray153[local59]];
					@Pc(89) int local89 = local68 + local84.anInt477;
					@Pc(94) int local94 = local77 + local84.anInt478;
					if (local84.anInt474 > 0) {
						this.method137(0, local84);
					}
					if (local84.anInt472 == 0) {
						if (local84.anInt481 > local84.anInt480 - local84.anInt476) {
							local84.anInt481 = local84.anInt480 - local84.anInt476;
						}
						if (local84.anInt481 < 0) {
							local84.anInt481 = 0;
						}
						this.method120(local94, local89, 38682, local84, local84.anInt481);
						if (local84.anInt480 > local84.anInt476) {
							this.method111(this.anInt192, local89 + local84.anInt475, local94, local84.anInt481, local84.anInt480, local84.anInt476);
						}
					} else if (local84.anInt472 != 1) {
						@Pc(167) int local167;
						@Pc(171) int local171;
						@Pc(182) int local182;
						@Pc(217) int local217;
						@Pc(224) int local224;
						@Pc(165) int local165;
						@Pc(191) int local191;
						@Pc(215) int local215;
						if (local84.anInt472 == 2) {
							local165 = 0;
							for (local167 = 0; local167 < local84.anInt476; local167++) {
								for (local171 = 0; local171 < local84.anInt475; local171++) {
									local182 = local89 + local171 * (local84.anInt483 + 32);
									local191 = local94 + local167 * (local84.anInt484 + 32);
									if (local165 < 20) {
										local182 += local84.anIntArray156[local165];
										local191 += local84.anIntArray157[local165];
									}
									if (local84.anIntArray149[local165] > 0) {
										local215 = 0;
										local217 = 0;
										local224 = local84.anIntArray149[local165] - 1;
										if (local182 >= -32 && local182 <= 512 && local191 >= -32 && local191 <= 334 || this.anInt216 != 0 && this.anInt215 == local165) {
											@Pc(251) Class1_Sub3_Sub2_Sub2 local251 = Static5.method59(local224, 24638, local84.anIntArray150[local165]);
											if (this.anInt216 != 0 && this.anInt215 == local165 && this.anInt214 == local84.anInt470) {
												local215 = super.anInt135 - this.anInt217;
												local217 = super.anInt136 - this.anInt218;
												if (local215 < 5 && local215 > -5) {
													local215 = 0;
												}
												if (local217 < 5 && local217 > -5) {
													local217 = 0;
												}
												if (this.anInt247 < 5) {
													local215 = 0;
													local217 = 0;
												}
												local251.method326(128, local182 + local215, local191 + local217, (byte) -26);
											} else if (this.anInt260 != 0 && this.anInt259 == local165 && this.anInt258 == local84.anInt470) {
												local251.method326(128, local182, local191, (byte) -26);
											} else {
												local251.method322(local191, local182, false);
											}
											if (local251.anInt465 == 33 || local84.anIntArray150[local165] != 1) {
												@Pc(351) int local351 = local84.anIntArray150[local165];
												this.aClass1_Sub3_Sub2_Sub4_1.method365(local182 + local215 + 1, local191 + 10 + local217, false, 0, Static6.method169(true, local351));
												this.aClass1_Sub3_Sub2_Sub4_1.method365(local182 + local215, local191 + 9 + local217, false, 16776960, Static6.method169(true, local351));
											}
										}
									} else if (local84.aClass1_Sub3_Sub2_Sub2Array8 != null && local165 < 20) {
										@Pc(398) Class1_Sub3_Sub2_Sub2 local398 = local84.aClass1_Sub3_Sub2_Sub2Array8[local165];
										if (local398 != null) {
											local398.method322(local191, local182, false);
										}
									}
									local165++;
								}
							}
						} else if (local84.anInt472 != 3) {
							@Pc(456) Class1_Sub3_Sub2_Sub4 local456;
							if (local84.anInt472 == 4) {
								local456 = local84.aClass1_Sub3_Sub2_Sub4_5;
								local167 = local84.anInt485;
								@Pc(462) String local462 = local84.aString20;
								if ((this.anInt221 == local84.anInt470 || this.anInt256 == local84.anInt470 || this.anInt300 == local84.anInt470) && local84.anInt487 != 0) {
									local167 = local84.anInt487;
								}
								if (this.method175(local84, 65)) {
									local167 = local84.anInt486;
									if (local84.aString21.length() > 0) {
										local462 = local84.aString21;
									}
								}
								if (local84.anInt473 == 6 && this.aBoolean49) {
									local462 = "Please wait...";
									local167 = local84.anInt485;
								}
								local191 = local94 + local456.anInt540;
								while (local462.length() > 0) {
									if (local462.indexOf("%") != -1) {
										label264: while (true) {
											local215 = local462.indexOf("%1");
											if (local215 == -1) {
												while (true) {
													local215 = local462.indexOf("%2");
													if (local215 == -1) {
														while (true) {
															local215 = local462.indexOf("%3");
															if (local215 == -1) {
																while (true) {
																	local215 = local462.indexOf("%4");
																	if (local215 == -1) {
																		while (true) {
																			local215 = local462.indexOf("%5");
																			if (local215 == -1) {
																				break label264;
																			}
																			local462 = local462.substring(0, local215) + this.method150(this.method187(local84, false, 4), -676) + local462.substring(local215 + 2);
																		}
																	}
																	local462 = local462.substring(0, local215) + this.method150(this.method187(local84, false, 3), -676) + local462.substring(local215 + 2);
																}
															}
															local462 = local462.substring(0, local215) + this.method150(this.method187(local84, false, 2), -676) + local462.substring(local215 + 2);
														}
													}
													local462 = local462.substring(0, local215) + this.method150(this.method187(local84, false, 1), -676) + local462.substring(local215 + 2);
												}
											}
											local462 = local462.substring(0, local215) + this.method150(this.method187(local84, false, 0), -676) + local462.substring(local215 + 2);
										}
									}
									local215 = local462.indexOf("\\n");
									@Pc(704) String local704;
									if (local215 == -1) {
										local704 = local462;
										local462 = "";
									} else {
										local704 = local462.substring(0, local215);
										local462 = local462.substring(local215 + 2);
									}
									if (local84.aBoolean112) {
										local456.method363(local89 + local84.anInt475 / 2, local167, local84.aBoolean113, local191, local704, 0);
									} else {
										local456.method367(local89, 6, local191, local704, local84.aBoolean113, local167);
									}
									local191 += local456.anInt540;
								}
							} else if (local84.anInt472 == 5) {
								@Pc(766) Class1_Sub3_Sub2_Sub2 local766;
								if (this.method175(local84, 65)) {
									local766 = local84.aClass1_Sub3_Sub2_Sub2_13;
								} else {
									local766 = local84.aClass1_Sub3_Sub2_Sub2_12;
								}
								if (local766 != null) {
									local766.method322(local94, local89, false);
								}
							} else if (local84.anInt472 == 6) {
								local165 = Static15.anInt430;
								local167 = Static15.anInt431;
								Static15.anInt430 = local89 + local84.anInt475 / 2;
								Static15.anInt431 = local94 + local84.anInt476 / 2;
								local171 = Class1_Sub3_Sub2_Sub1.anIntArray137[local84.anInt491] * local84.anInt490 >> 16;
								local182 = Class1_Sub3_Sub2_Sub1.anIntArray138[local84.anInt491] * local84.anInt490 >> 16;
								@Pc(827) boolean local827 = this.method175(local84, 65);
								if (local827) {
									local215 = local84.anInt489;
								} else {
									local215 = local84.anInt488;
								}
								@Pc(846) Class1_Sub3_Sub1 local846;
								if (local215 == -1) {
									local846 = local84.method332(-1, -1, local827);
								} else {
									@Pc(852) Class19 local852 = Static20.aClass19Array1[local215];
									local846 = local84.method332(local852.anIntArray186[local84.anInt468], local852.anIntArray187[local84.anInt468], local827);
								}
								if (local846 != null) {
									local846.method243(0, local84.anInt492, 0, local84.anInt491, 0, local171, local182);
								}
								Static15.anInt430 = local165;
								Static15.anInt431 = local167;
							} else if (local84.anInt472 == 7) {
								local456 = local84.aClass1_Sub3_Sub2_Sub4_5;
								local167 = 0;
								for (local171 = 0; local171 < local84.anInt476; local171++) {
									for (local182 = 0; local182 < local84.anInt475; local182++) {
										if (local84.anIntArray149[local167] > 0) {
											@Pc(915) Class5 local915 = Static5.method54(local84.anIntArray149[local167] - 1);
											@Pc(918) String local918 = local915.aString3;
											if (local915.aBoolean31 || local84.anIntArray150[local167] != 1) {
												local918 = local918 + " x" + Static6.method101(local84.anIntArray150[local167], 0);
											}
											local217 = local89 + local182 * (local84.anInt483 + 115);
											local224 = local94 + local171 * (local84.anInt484 + 12);
											if (local84.aBoolean112) {
												local456.method363(local217 + local84.anInt475 / 2, local84.anInt485, local84.aBoolean113, local224, local918, 0);
											} else {
												local456.method367(local217, 6, local224, local918, local84.aBoolean113, local84.anInt485);
											}
										}
										local167++;
									}
								}
							}
						} else if (local84.aBoolean111) {
							Static12.method358(local94, local89, local84.anInt485, (byte) 93, local84.anInt475, local84.anInt476);
						} else {
							Static12.method359(3, local89, local84.anInt485, local84.anInt476, local94, local84.anInt475);
						}
					}
				}
				Static12.method356(local35, local31, local33, 789, local29);
			}
		} catch (@Pc(1014) RuntimeException local1014) {
			signlink.reporterror("44309, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local1014.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILclient!kb;)V")
	private void method121(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class1_Sub3_Sub3 arg2) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.anInt206; local1++) {
				@Pc(8) int local8 = this.anIntArray40[local1];
				@Pc(13) Class1_Sub1_Sub3_Sub2 local13 = this.aClass1_Sub1_Sub3_Sub2Array1[local8];
				@Pc(16) int local16 = arg2.method391();
				if ((local16 & 0x80) == 128) {
					local16 += arg2.method391() << 8;
				}
				this.method200(true, local8, local16, arg2, local13);
			}
			this.aBoolean62 &= arg0;
		} catch (@Pc(48) RuntimeException local48) {
			signlink.reporterror("96435, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local48.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(II)V")
	private void method122(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = 19 / arg1;
			@Pc(8) int local8 = Static23.aClass23Array1[arg0].anInt609;
			if (local8 != 0) {
				@Pc(16) int local16 = this.anIntArray59[arg0];
				if (local8 == 1) {
					if (local16 == 1) {
						Static15.method296(true, 0.9D);
					}
					if (local16 == 2) {
						Static15.method296(true, 0.8D);
					}
					if (local16 == 3) {
						Static15.method296(true, 0.7D);
					}
					if (local16 == 4) {
						Static15.method296(true, 0.6D);
					}
					Static5.aClass35_5.method529();
					this.aBoolean37 = true;
				}
				if (local8 == 3) {
					@Pc(54) boolean local54 = this.aBoolean42;
					if (local16 == 0) {
						this.method115(0, 0, this.aBoolean42);
						this.aBoolean42 = true;
					}
					if (local16 == 1) {
						this.method115(0, -400, this.aBoolean42);
						this.aBoolean42 = true;
					}
					if (local16 == 2) {
						this.method115(0, -800, this.aBoolean42);
						this.aBoolean42 = true;
					}
					if (local16 == 3) {
						this.method115(0, -1200, this.aBoolean42);
						this.aBoolean42 = true;
					}
					if (local16 == 4) {
						this.aBoolean42 = false;
					}
					if (this.aBoolean42 != local54) {
						if (this.aBoolean42) {
							this.method75(false, this.anInt321, this.aString17, this.anInt343);
						} else {
							this.method78(0);
						}
						this.anInt157 = 0;
					}
				}
				if (local8 == 4) {
					if (local16 == 0) {
						this.aBoolean73 = true;
						this.method140(0, 0);
					}
					if (local16 == 1) {
						this.aBoolean73 = true;
						this.method140(-400, 0);
					}
					if (local16 == 2) {
						this.aBoolean73 = true;
						this.method140(-800, 0);
					}
					if (local16 == 3) {
						this.aBoolean73 = true;
						this.method140(-1200, 0);
					}
					if (local16 == 4) {
						this.aBoolean73 = false;
					}
				}
				if (local8 == 5) {
					this.anInt196 = local16;
				}
				if (local8 == 6) {
					this.anInt189 = local16;
				}
				if (local8 == 8) {
					this.anInt210 = local16;
					this.aBoolean60 = true;
				}
			}
		} catch (@Pc(202) RuntimeException local202) {
			signlink.reporterror("71764, " + arg0 + ", " + arg1 + ", " + local202.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(Z)V")
	private void method123(@OriginalArg(0) boolean arg0) {
		try {
			this.aBoolean62 &= arg0;
			for (@Pc(7) int local7 = 0; local7 < this.anInt248; local7++) {
				@Pc(14) int local14 = this.anIntArray58[local7];
				@Pc(19) Class1_Sub1_Sub3_Sub1 local19 = this.aClass1_Sub1_Sub3_Sub1Array1[local14];
				if (local19 != null) {
					this.method124(local19, (byte) -128, local19.aClass3_1.aByte4);
				}
			}
		} catch (@Pc(35) RuntimeException local35) {
			signlink.reporterror("3061, " + arg0 + ", " + local35.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;BI)V")
	private void method124(@OriginalArg(0) Class1_Sub1_Sub3 arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0.anInt882 < 128 || arg0.anInt883 < 128 || arg0.anInt882 >= 13184 || arg0.anInt883 >= 13184) {
				arg0.anInt907 = -1;
				arg0.anInt912 = -1;
				arg0.anInt921 = 0;
				arg0.anInt922 = 0;
				arg0.anInt882 = arg0.anIntArray232[0] * 128 + arg0.anInt885 * 64;
				arg0.anInt883 = arg0.anIntArray233[0] * 128 + arg0.anInt885 * 64;
				arg0.anInt927 = 0;
			}
			if (arg0 == this.aClass1_Sub1_Sub3_Sub2_1 && (arg0.anInt882 < 1536 || arg0.anInt883 < 1536 || arg0.anInt882 >= 11776 || arg0.anInt883 >= 11776)) {
				arg0.anInt907 = -1;
				arg0.anInt912 = -1;
				arg0.anInt921 = 0;
				arg0.anInt922 = 0;
				arg0.anInt882 = arg0.anIntArray232[0] * 128 + arg0.anInt885 * 64;
				arg0.anInt883 = arg0.anIntArray233[0] * 128 + arg0.anInt885 * 64;
				arg0.anInt927 = 0;
			}
			if (arg0.anInt921 > Static6.anInt266) {
				this.method125(arg0, -25115);
			} else if (arg0.anInt922 >= Static6.anInt266) {
				this.method126(arg0, 0);
			} else {
				this.method127(598, arg0);
			}
			this.method128(arg0, (byte) 117);
			if (arg1 != -128) {
				this.aClass1_Sub3_Sub3_6.method381(11);
			}
			this.method129(this.aBoolean38, arg0);
		} catch (@Pc(161) RuntimeException local161) {
			signlink.reporterror("58564, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local161.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;I)V")
	private void method125(@OriginalArg(0) Class1_Sub1_Sub3 arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(4) int local4 = arg0.anInt921 - Static6.anInt266;
			@Pc(14) int local14 = arg0.anInt917 * 128 + arg0.anInt885 * 64;
			@Pc(24) int local24 = arg0.anInt919 * 128 + arg0.anInt885 * 64;
			arg0.anInt882 += (local14 - arg0.anInt882) / local4;
			if (arg1 != -25115) {
				this.anInt151 = this.aClass38_1.method532();
			}
			arg0.anInt883 += (local24 - arg0.anInt883) / local4;
			arg0.anInt928 = 0;
			if (arg0.anInt923 == 0) {
				arg0.anInt926 = 1024;
			}
			if (arg0.anInt923 == 1) {
				arg0.anInt926 = 1536;
			}
			if (arg0.anInt923 == 2) {
				arg0.anInt926 = 0;
			}
			if (arg0.anInt923 == 3) {
				arg0.anInt926 = 512;
			}
		} catch (@Pc(86) RuntimeException local86) {
			signlink.reporterror("13971, " + arg0 + ", " + arg1 + ", " + local86.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!x;I)V")
	private void method126(@OriginalArg(0) Class1_Sub1_Sub3 arg0, @OriginalArg(1) int arg1) {
		try {
			this.anInt178 += arg1;
			if (arg0.anInt922 == Static6.anInt266 || arg0.anInt907 == -1 || arg0.anInt910 != 0 || arg0.anInt909 + 1 > Static20.aClass19Array1[arg0.anInt907].anIntArray188[arg0.anInt908]) {
				@Pc(35) int local35 = arg0.anInt922 - arg0.anInt921;
				@Pc(40) int local40 = Static6.anInt266 - arg0.anInt921;
				@Pc(50) int local50 = arg0.anInt917 * 128 + arg0.anInt885 * 64;
				@Pc(60) int local60 = arg0.anInt919 * 128 + arg0.anInt885 * 64;
				@Pc(70) int local70 = arg0.anInt918 * 128 + arg0.anInt885 * 64;
				@Pc(80) int local80 = arg0.anInt920 * 128 + arg0.anInt885 * 64;
				arg0.anInt882 = (local50 * (local35 - local40) + local70 * local40) / local35;
				arg0.anInt883 = (local60 * (local35 - local40) + local80 * local40) / local35;
			}
			arg0.anInt928 = 0;
			if (arg0.anInt923 == 0) {
				arg0.anInt926 = 1024;
			}
			if (arg0.anInt923 == 1) {
				arg0.anInt926 = 1536;
			}
			if (arg0.anInt923 == 2) {
				arg0.anInt926 = 0;
			}
			if (arg0.anInt923 == 3) {
				arg0.anInt926 = 512;
			}
			arg0.anInt884 = arg0.anInt926;
		} catch (@Pc(142) RuntimeException local142) {
			signlink.reporterror("86706, " + arg0 + ", " + arg1 + ", " + local142.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!x;)V")
	private void method127(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub1_Sub3 arg1) {
		try {
			arg1.anInt904 = arg1.anInt886;
			@Pc(9) int local9 = 56 / arg0;
			if (arg1.anInt927 == 0) {
				arg1.anInt928 = 0;
			} else {
				if (arg1.anInt907 != -1 && arg1.anInt910 == 0) {
					@Pc(28) Class19 local28 = Static20.aClass19Array1[arg1.anInt907];
					if (local28.anIntArray189 == null) {
						arg1.anInt928++;
						return;
					}
				}
				@Pc(41) int local41 = arg1.anInt882;
				@Pc(44) int local44 = arg1.anInt883;
				@Pc(59) int local59 = arg1.anIntArray232[arg1.anInt927 - 1] * 128 + arg1.anInt885 * 64;
				@Pc(74) int local74 = arg1.anIntArray233[arg1.anInt927 - 1] * 128 + arg1.anInt885 * 64;
				if (local59 - local41 <= 256 && local59 - local41 >= -256 && local74 - local44 <= 256 && local74 - local44 >= -256) {
					if (local41 < local59) {
						if (local44 < local74) {
							arg1.anInt926 = 1280;
						} else if (local44 > local74) {
							arg1.anInt926 = 1792;
						} else {
							arg1.anInt926 = 1536;
						}
					} else if (local41 > local59) {
						if (local44 < local74) {
							arg1.anInt926 = 768;
						} else if (local44 > local74) {
							arg1.anInt926 = 256;
						} else {
							arg1.anInt926 = 512;
						}
					} else if (local44 < local74) {
						arg1.anInt926 = 1024;
					} else {
						arg1.anInt926 = 0;
					}
					@Pc(168) int local168 = arg1.anInt926 - arg1.anInt884 & 0x7FF;
					if (local168 > 1024) {
						local168 -= 2048;
					}
					@Pc(175) int local175 = arg1.anInt889;
					if (local168 >= -256 && local168 <= 256) {
						local175 = arg1.anInt888;
					} else if (local168 >= 256 && local168 < 768) {
						local175 = arg1.anInt891;
					} else if (local168 >= -768 && local168 <= -256) {
						local175 = arg1.anInt890;
					}
					if (local175 == -1) {
						local175 = arg1.anInt888;
					}
					arg1.anInt904 = local175;
					@Pc(217) int local217 = 4;
					if (arg1.anInt884 != arg1.anInt926 && arg1.anInt901 == -1) {
						local217 = 2;
					}
					if (arg1.anInt927 > 2) {
						local217 = 6;
					}
					if (arg1.anInt927 > 3) {
						local217 = 8;
					}
					if (arg1.anInt928 > 0 && arg1.anInt927 > 1) {
						local217 = 8;
						arg1.anInt928--;
					}
					if (arg1.aBooleanArray9[arg1.anInt927 - 1]) {
						local217 <<= 0x1;
					}
					if (local217 >= 8 && arg1.anInt904 == arg1.anInt888 && arg1.anInt892 != -1) {
						arg1.anInt904 = arg1.anInt892;
					}
					if (local41 < local59) {
						arg1.anInt882 += local217;
						if (arg1.anInt882 > local59) {
							arg1.anInt882 = local59;
						}
					} else if (local41 > local59) {
						arg1.anInt882 -= local217;
						if (arg1.anInt882 < local59) {
							arg1.anInt882 = local59;
						}
					}
					if (local44 < local74) {
						arg1.anInt883 += local217;
						if (arg1.anInt883 > local74) {
							arg1.anInt883 = local74;
						}
					} else if (local44 > local74) {
						arg1.anInt883 -= local217;
						if (arg1.anInt883 < local74) {
							arg1.anInt883 = local74;
						}
					}
					if (arg1.anInt882 == local59 && arg1.anInt883 == local74) {
						arg1.anInt927--;
					}
				} else {
					arg1.anInt882 = local59;
					arg1.anInt883 = local74;
				}
			}
		} catch (@Pc(367) RuntimeException local367) {
			signlink.reporterror("70559, " + arg0 + ", " + arg1 + ", " + local367.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;B)V")
	private void method128(@OriginalArg(0) Class1_Sub1_Sub3 arg0, @OriginalArg(1) byte arg1) {
		try {
			if (arg1 != 117) {
				this.aClass1_Sub3_Sub3_6.method381(89);
			}
			@Pc(30) int local30;
			@Pc(36) int local36;
			if (arg0.anInt901 != -1 && arg0.anInt901 < 32768) {
				@Pc(22) Class1_Sub1_Sub3_Sub1 local22 = this.aClass1_Sub1_Sub3_Sub1Array1[arg0.anInt901];
				if (local22 != null) {
					local30 = arg0.anInt882 - local22.anInt882;
					local36 = arg0.anInt883 - local22.anInt883;
					if (local30 != 0 || local36 != 0) {
						arg0.anInt926 = (int) (Math.atan2((double) local30, (double) local36) * 325.949D) & 0x7FF;
					}
				}
			}
			@Pc(61) int local61;
			if (arg0.anInt901 >= 32768) {
				local61 = arg0.anInt901 - 32768;
				if (local61 == this.anInt152) {
					local61 = this.anInt204;
				}
				@Pc(73) Class1_Sub1_Sub3_Sub2 local73 = this.aClass1_Sub1_Sub3_Sub2Array1[local61];
				if (local73 != null) {
					local36 = arg0.anInt882 - local73.anInt882;
					@Pc(87) int local87 = arg0.anInt883 - local73.anInt883;
					if (local36 != 0 || local87 != 0) {
						arg0.anInt926 = (int) (Math.atan2((double) local36, (double) local87) * 325.949D) & 0x7FF;
					}
				}
			}
			if ((arg0.anInt902 != 0 || arg0.anInt903 != 0) && (arg0.anInt927 == 0 || arg0.anInt928 > 0)) {
				local61 = arg0.anInt882 - (arg0.anInt902 - this.anInt169 - this.anInt169) * 64;
				local30 = arg0.anInt883 - (arg0.anInt903 - this.anInt170 - this.anInt170) * 64;
				if (local61 != 0 || local30 != 0) {
					arg0.anInt926 = (int) (Math.atan2((double) local61, (double) local30) * 325.949D) & 0x7FF;
				}
				arg0.anInt902 = 0;
				arg0.anInt903 = 0;
			}
			local61 = arg0.anInt926 - arg0.anInt884 & 0x7FF;
			if (local61 != 0) {
				if (local61 < 32 || local61 > 2016) {
					arg0.anInt884 = arg0.anInt926;
				} else if (local61 > 1024) {
					arg0.anInt884 -= 32;
				} else {
					arg0.anInt884 += 32;
				}
				arg0.anInt884 &= 0x7FF;
				if (arg0.anInt904 == arg0.anInt886 && arg0.anInt884 != arg0.anInt926) {
					if (arg0.anInt887 != -1) {
						arg0.anInt904 = arg0.anInt887;
						return;
					}
					arg0.anInt904 = arg0.anInt888;
					return;
				}
			}
		} catch (@Pc(235) RuntimeException local235) {
			signlink.reporterror("29025, " + arg0 + ", " + arg1 + ", " + local235.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!x;)V")
	private void method129(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class1_Sub1_Sub3 arg1) {
		try {
			if (arg0) {
				arg1.aBoolean160 = false;
				@Pc(16) Class19 local16;
				if (arg1.anInt904 != -1) {
					local16 = Static20.aClass19Array1[arg1.anInt904];
					arg1.anInt906++;
					if (arg1.anInt905 < local16.anInt543 && arg1.anInt906 > local16.anIntArray188[arg1.anInt905]) {
						arg1.anInt906 = 0;
						arg1.anInt905++;
					}
					if (arg1.anInt905 >= local16.anInt543) {
						arg1.anInt906 = 0;
						arg1.anInt905 = 0;
					}
				}
				if (arg1.anInt907 != -1 && arg1.anInt910 == 0) {
					local16 = Static20.aClass19Array1[arg1.anInt907];
					arg1.anInt909++;
					while (arg1.anInt908 < local16.anInt543 && arg1.anInt909 > local16.anIntArray188[arg1.anInt908]) {
						arg1.anInt909 -= local16.anIntArray188[arg1.anInt908];
						arg1.anInt908++;
					}
					if (arg1.anInt908 >= local16.anInt543) {
						arg1.anInt908 -= local16.anInt544;
						arg1.anInt911++;
						if (arg1.anInt911 >= local16.anInt548) {
							arg1.anInt907 = -1;
						}
						if (arg1.anInt908 < 0 || arg1.anInt908 >= local16.anInt543) {
							arg1.anInt907 = -1;
						}
					}
					arg1.aBoolean160 = local16.aBoolean126;
				}
				if (arg1.anInt910 > 0) {
					arg1.anInt910--;
				}
				if (arg1.anInt912 != -1 && Static6.anInt266 >= arg1.anInt915) {
					if (arg1.anInt913 < 0) {
						arg1.anInt913 = 0;
					}
					local16 = Static22.aClass21Array1[arg1.anInt912].aClass19_1;
					arg1.anInt914++;
					while (arg1.anInt913 < local16.anInt543 && arg1.anInt914 > local16.anIntArray188[arg1.anInt913]) {
						arg1.anInt914 -= local16.anIntArray188[arg1.anInt913];
						arg1.anInt913++;
					}
					if (arg1.anInt913 >= local16.anInt543) {
						if (arg1.anInt913 < 0 || arg1.anInt913 >= local16.anInt543) {
							arg1.anInt912 = -1;
						}
						return;
					}
				}
			}
		} catch (@Pc(229) RuntimeException local229) {
			signlink.reporterror("65300, " + arg0 + ", " + arg1 + ", " + local229.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "r", descriptor = "(I)V")
	private void method130(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 29510) {
				this.anInt333 = 411;
			}
			if (this.aBoolean37) {
				this.aBoolean37 = false;
				this.aClass32_6.method464(11, super.aGraphics2, 0, 5193);
				this.aClass32_7.method464(375, super.aGraphics2, 0, 5193);
				this.aClass32_8.method464(5, super.aGraphics2, 729, 5193);
				this.aClass32_9.method464(231, super.aGraphics2, 752, 5193);
				this.aClass32_10.method464(0, super.aGraphics2, 0, 5193);
				this.aClass32_11.method464(0, super.aGraphics2, 561, 5193);
				this.aClass32_12.method464(11, super.aGraphics2, 520, 5193);
				this.aClass32_13.method464(231, super.aGraphics2, 520, 5193);
				this.aClass32_14.method464(375, super.aGraphics2, 501, 5193);
				this.aClass32_15.method464(345, super.aGraphics2, 0, 5193);
				this.aBoolean59 = true;
				this.aBoolean60 = true;
				this.aBoolean68 = true;
				this.aBoolean56 = true;
				if (this.anInt307 != 2) {
					this.aClass32_27.method464(11, super.aGraphics2, 8, 5193);
					this.aClass32_26.method464(5, super.aGraphics2, 561, 5193);
				}
			}
			if (this.anInt307 == 2) {
				this.method86(0);
			}
			if (this.aBoolean50 && this.anInt337 == 1) {
				this.aBoolean59 = true;
			}
			@Pc(152) boolean local152;
			if (this.anInt330 != -1) {
				local152 = this.method171(this.anInt330, this.anInt270, 623);
				if (local152) {
					this.aBoolean59 = true;
				}
			}
			if (this.anInt260 == 2) {
				this.aBoolean59 = true;
			}
			if (this.anInt216 == 2) {
				this.aBoolean59 = true;
			}
			if (this.aBoolean59) {
				this.method198((byte) 2);
				this.aBoolean59 = false;
			}
			if (this.anInt280 == -1) {
				this.aClass15_1.anInt481 = this.anInt185 - this.anInt274 - 77;
				if (super.anInt135 > 453 && super.anInt135 < 565 && super.anInt136 > 350) {
					this.method158(super.anInt135 - 22, 0, super.anInt136 - 375, this.anInt185, 77, false, 463, 0, this.aClass15_1);
				}
				@Pc(234) int local234 = this.anInt185 - this.aClass15_1.anInt481 - 77;
				if (local234 < 0) {
					local234 = 0;
				}
				if (local234 > this.anInt185 - 77) {
					local234 = this.anInt185 - 77;
				}
				if (this.anInt274 != local234) {
					this.anInt274 = local234;
					this.aBoolean60 = true;
				}
			}
			if (this.anInt280 != -1) {
				local152 = this.method171(this.anInt280, this.anInt270, 623);
				if (local152) {
					this.aBoolean60 = true;
				}
			}
			if (this.anInt260 == 3) {
				this.aBoolean60 = true;
			}
			if (this.anInt216 == 3) {
				this.aBoolean60 = true;
			}
			if (this.aString8 != null) {
				this.aBoolean60 = true;
			}
			if (this.aBoolean50 && this.anInt337 == 2) {
				this.aBoolean60 = true;
			}
			if (this.aBoolean60) {
				this.method196(false);
				this.aBoolean60 = false;
			}
			if (this.anInt307 == 2) {
				this.method104(this.aByte14);
				this.aClass32_26.method464(5, super.aGraphics2, 561, 5193);
			}
			if (this.anInt329 != -1) {
				this.aBoolean68 = true;
			}
			if (this.aBoolean68) {
				if (this.anInt329 != -1 && this.anInt329 == this.anInt166) {
					this.anInt329 = -1;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 175);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt166);
				}
				this.aBoolean68 = false;
				this.aClass32_5.method463((byte) 62);
				this.aClass1_Sub3_Sub2_Sub3_8.method350(0, 0, false);
				if (this.anInt330 == -1) {
					if (this.anIntArray46[this.anInt166] != -1) {
						if (this.anInt166 == 0) {
							this.aClass1_Sub3_Sub2_Sub3_1.method350(30, 29, false);
						}
						if (this.anInt166 == 1) {
							this.aClass1_Sub3_Sub2_Sub3_2.method350(29, 59, false);
						}
						if (this.anInt166 == 2) {
							this.aClass1_Sub3_Sub2_Sub3_2.method350(29, 87, false);
						}
						if (this.anInt166 == 3) {
							this.aClass1_Sub3_Sub2_Sub3_3.method350(29, 115, false);
						}
						if (this.anInt166 == 4) {
							this.aClass1_Sub3_Sub2_Sub3_5.method350(29, 156, false);
						}
						if (this.anInt166 == 5) {
							this.aClass1_Sub3_Sub2_Sub3_5.method350(29, 184, false);
						}
						if (this.anInt166 == 6) {
							this.aClass1_Sub3_Sub2_Sub3_4.method350(30, 212, false);
						}
					}
					if (this.anIntArray46[0] != -1 && (this.anInt329 != 0 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[0].method350(34, 35, false);
					}
					if (this.anIntArray46[1] != -1 && (this.anInt329 != 1 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[1].method350(32, 59, false);
					}
					if (this.anIntArray46[2] != -1 && (this.anInt329 != 2 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[2].method350(32, 86, false);
					}
					if (this.anIntArray46[3] != -1 && (this.anInt329 != 3 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[3].method350(33, 121, false);
					}
					if (this.anIntArray46[4] != -1 && (this.anInt329 != 4 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[4].method350(34, 157, false);
					}
					if (this.anIntArray46[5] != -1 && (this.anInt329 != 5 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[5].method350(32, 185, false);
					}
					if (this.anIntArray46[6] != -1 && (this.anInt329 != 6 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[6].method350(34, 212, false);
					}
				}
				this.aClass32_5.method464(165, super.aGraphics2, 520, 5193);
				this.aClass32_4.method463((byte) 62);
				this.aClass1_Sub3_Sub2_Sub3_7.method350(0, 0, false);
				if (this.anInt330 == -1) {
					if (this.anIntArray46[this.anInt166] != -1) {
						if (this.anInt166 == 7) {
							this.aClass1_Sub3_Sub2_Sub3_12.method350(0, 49, false);
						}
						if (this.anInt166 == 8) {
							this.aClass1_Sub3_Sub2_Sub3_13.method350(0, 81, false);
						}
						if (this.anInt166 == 9) {
							this.aClass1_Sub3_Sub2_Sub3_13.method350(0, 108, false);
						}
						if (this.anInt166 == 10) {
							this.aClass1_Sub3_Sub2_Sub3_14.method350(1, 136, false);
						}
						if (this.anInt166 == 11) {
							this.aClass1_Sub3_Sub2_Sub3_16.method350(0, 178, false);
						}
						if (this.anInt166 == 12) {
							this.aClass1_Sub3_Sub2_Sub3_16.method350(0, 205, false);
						}
						if (this.anInt166 == 13) {
							this.aClass1_Sub3_Sub2_Sub3_15.method350(0, 233, false);
						}
					}
					if (this.anIntArray46[8] != -1 && (this.anInt329 != 8 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[7].method350(2, 80, false);
					}
					if (this.anIntArray46[9] != -1 && (this.anInt329 != 9 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[8].method350(3, 107, false);
					}
					if (this.anIntArray46[10] != -1 && (this.anInt329 != 10 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[9].method350(4, 142, false);
					}
					if (this.anIntArray46[11] != -1 && (this.anInt329 != 11 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[10].method350(2, 179, false);
					}
					if (this.anIntArray46[12] != -1 && (this.anInt329 != 12 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[11].method350(2, 206, false);
					}
					if (this.anIntArray46[13] != -1 && (this.anInt329 != 13 || Static6.anInt266 % 20 < 10)) {
						this.aClass1_Sub3_Sub2_Sub3Array1[12].method350(2, 230, false);
					}
				}
				this.aClass32_4.method464(492, super.aGraphics2, 501, 5193);
				this.aClass32_27.method463((byte) 62);
			}
			if (this.aBoolean56) {
				this.aBoolean56 = false;
				this.aClass32_3.method463((byte) 62);
				this.aClass1_Sub3_Sub2_Sub3_6.method350(0, 0, false);
				this.aClass1_Sub3_Sub2_Sub4_2.method363(57, 16777215, true, 33, "Public chat", 0);
				if (this.anInt273 == 0) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(57, 65280, true, 46, "On", 0);
				}
				if (this.anInt273 == 1) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(57, 16776960, true, 46, "Friends", 0);
				}
				if (this.anInt273 == 2) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(57, 16711680, true, 46, "Off", 0);
				}
				if (this.anInt273 == 3) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(57, 65535, true, 46, "Hide", 0);
				}
				this.aClass1_Sub3_Sub2_Sub4_2.method363(186, 16777215, true, 33, "Private chat", 0);
				if (this.anInt164 == 0) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(186, 65280, true, 46, "On", 0);
				}
				if (this.anInt164 == 1) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(186, 16776960, true, 46, "Friends", 0);
				}
				if (this.anInt164 == 2) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(186, 16711680, true, 46, "Off", 0);
				}
				this.aClass1_Sub3_Sub2_Sub4_2.method363(326, 16777215, true, 33, "Trade/duel", 0);
				if (this.anInt234 == 0) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(326, 65280, true, 46, "On", 0);
				}
				if (this.anInt234 == 1) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(326, 16776960, true, 46, "Friends", 0);
				}
				if (this.anInt234 == 2) {
					this.aClass1_Sub3_Sub2_Sub4_2.method363(326, 16711680, true, 46, "Off", 0);
				}
				this.aClass1_Sub3_Sub2_Sub4_2.method363(462, 16777215, true, 38, "Report abuse", 0);
				this.aClass32_3.method464(471, super.aGraphics2, 0, 5193);
				this.aClass32_27.method463((byte) 62);
			}
			this.anInt270 = 0;
		} catch (@Pc(1061) RuntimeException local1061) {
			signlink.reporterror("48371, " + arg0 + ", " + local1061.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(II)Z")
	private boolean method131(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg1 < 0) {
				return false;
			}
			@Pc(8) int local8 = this.anIntArray86[arg1];
			if (arg0 <= 0) {
				throw new NullPointerException();
			}
			if (local8 >= 2000) {
				local8 -= 2000;
			}
			return local8 == 406;
		} catch (@Pc(26) RuntimeException local26) {
			signlink.reporterror("6950, " + arg0 + ", " + arg1 + ", " + local26.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(II)V")
	private void method132(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg1 >= 0) {
				if (this.aBoolean66) {
					this.aBoolean66 = false;
					this.aBoolean60 = true;
				}
				@Pc(18) int local18 = this.anIntArray84[arg1];
				@Pc(23) int local23 = this.anIntArray85[arg1];
				@Pc(28) int local28 = this.anIntArray86[arg1];
				@Pc(33) int local33 = this.anIntArray87[arg1];
				if (local28 >= 2000) {
					local28 -= 2000;
				}
				@Pc(48) String local48;
				@Pc(52) int local52;
				@Pc(69) String local69;
				@Pc(73) int local73;
				if (local28 == 903 || local28 == 363) {
					local48 = this.aStringArray5[arg1];
					local52 = local48.indexOf("@whi@");
					if (local52 != -1) {
						local48 = local48.substring(local52 + 5).trim();
						local69 = Static30.method542(0, Static30.method539(Static30.method538(local48), false));
						@Pc(71) boolean local71 = false;
						for (local73 = 0; local73 < this.anInt205; local73++) {
							@Pc(83) Class1_Sub1_Sub3_Sub2 local83 = this.aClass1_Sub1_Sub3_Sub2Array1[this.anIntArray39[local73]];
							if (local83 != null && local83.aString29 != null && local83.aString29.equalsIgnoreCase(local69)) {
								this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local83.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local83.anIntArray233[0], 0, 0, 0);
								if (local28 == 903) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 206);
								}
								if (local28 == 363) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 164);
								}
								this.aClass1_Sub3_Sub3_6.method382(this.anIntArray39[local73]);
								local71 = true;
								break;
							}
						}
						if (!local71) {
							this.method172(0, "Unable to find " + local69, (byte) 4, "");
						}
					}
				}
				if (local28 == 450 && this.method153(75, local18, local23, local33, true)) {
					this.aClass1_Sub3_Sub3_6.method382(this.anInt284);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt282);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt283);
				}
				if (local28 == 405 || local28 == 38 || local28 == 422 || local28 == 478 || local28 == 347) {
					if (local28 == 478) {
						if ((local18 & 0x3) == 0) {
							Static6.anInt143++;
						}
						if (Static6.anInt143 >= 90) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 220);
						}
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 157);
					}
					if (local28 == 347) {
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 211);
					}
					if (local28 == 422) {
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 133);
					}
					if (local28 == 405) {
						Static6.anInt195 += local33;
						if (Static6.anInt195 >= 97) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 30);
							this.aClass1_Sub3_Sub3_6.method384(14953816);
						}
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 195);
					}
					if (local28 == 38) {
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 71);
					}
					this.aClass1_Sub3_Sub3_6.method382(local33);
					this.aClass1_Sub3_Sub3_6.method382(local18);
					this.aClass1_Sub3_Sub3_6.method382(local23);
					this.anInt257 = 0;
					this.anInt258 = local23;
					this.anInt259 = local18;
					this.anInt260 = 2;
					if (Static17.aClass15Array1[local23].anInt471 == this.anInt271) {
						this.anInt260 = 1;
					}
					if (Static17.aClass15Array1[local23].anInt471 == this.anInt280) {
						this.anInt260 = 3;
					}
				}
				@Pc(345) Class1_Sub1_Sub3_Sub1 local345;
				if (local28 == 728 || local28 == 542 || local28 == 6 || local28 == 963 || local28 == 245) {
					local345 = this.aClass1_Sub1_Sub3_Sub1Array1[local33];
					if (local345 != null) {
						this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local345.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local345.anIntArray233[0], 0, 0, 0);
						this.anInt153 = super.anInt138;
						this.anInt154 = super.anInt139;
						this.anInt156 = 2;
						this.anInt155 = 0;
						if (local28 == 542) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 8);
						}
						if (local28 == 6) {
							if ((local33 & 0x3) == 0) {
								Static6.anInt224++;
							}
							if (Static6.anInt224 >= 124) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 88);
								this.aClass1_Sub3_Sub3_6.method385(0);
							}
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 27);
						}
						if (local28 == 963) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 113);
						}
						if (local28 == 728) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 194);
						}
						if (local28 == 245) {
							if ((local33 & 0x3) == 0) {
								Static6.anInt188++;
							}
							if (Static6.anInt188 >= 85) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 176);
								this.aClass1_Sub3_Sub3_6.method382(39596);
							}
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 100);
						}
						this.aClass1_Sub3_Sub3_6.method382(local33);
					}
				}
				@Pc(500) boolean local500;
				if (local28 == 217) {
					local500 = this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 0, false, local18, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 0, local23, 0, 0, 0);
					if (!local500) {
						this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local18, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local23, 0, 0, 0);
					}
					this.anInt153 = super.anInt138;
					this.anInt154 = super.anInt139;
					this.anInt156 = 2;
					this.anInt155 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 239);
					this.aClass1_Sub3_Sub3_6.method382(local18 + this.anInt169);
					this.aClass1_Sub3_Sub3_6.method382(local23 + this.anInt170);
					this.aClass1_Sub3_Sub3_6.method382(local33);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt284);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt282);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt283);
				}
				if (local28 == 1175) {
					@Pc(586) int local586 = local33 >> 14 & 0x7FFF;
					@Pc(589) Class2 local589 = Static2.method23(local586);
					if (local589.aByteArray1 == null) {
						local69 = "It's a " + local589.aString1 + ".";
					} else {
						local69 = new String(local589.aByteArray1);
					}
					this.method172(0, local69, (byte) 4, "");
				}
				if (local28 == 285) {
					this.method153(245, local18, local23, local33, true);
				}
				if (local28 == 881) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 130);
					this.aClass1_Sub3_Sub3_6.method382(local33);
					this.aClass1_Sub3_Sub3_6.method382(local18);
					this.aClass1_Sub3_Sub3_6.method382(local23);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt284);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt282);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt283);
					this.anInt257 = 0;
					this.anInt258 = local23;
					this.anInt259 = local18;
					this.anInt260 = 2;
					if (Static17.aClass15Array1[local23].anInt471 == this.anInt271) {
						this.anInt260 = 1;
					}
					if (Static17.aClass15Array1[local23].anInt471 == this.anInt280) {
						this.anInt260 = 3;
					}
				}
				if (local28 == 391) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 48);
					this.aClass1_Sub3_Sub3_6.method382(local33);
					this.aClass1_Sub3_Sub3_6.method382(local18);
					this.aClass1_Sub3_Sub3_6.method382(local23);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt292);
					this.anInt257 = 0;
					this.anInt258 = local23;
					this.anInt259 = local18;
					this.anInt260 = 2;
					if (Static17.aClass15Array1[local23].anInt471 == this.anInt271) {
						this.anInt260 = 1;
					}
					if (Static17.aClass15Array1[local23].anInt471 == this.anInt280) {
						this.anInt260 = 3;
					}
				}
				if (local28 == 660) {
					if (this.aBoolean50) {
						this.aClass33_1.method506(4, local23 - 11, local18 - 8);
					} else {
						this.aClass33_1.method506(4, super.anInt139 - 11, super.anInt138 - 8);
					}
				}
				if (local28 == 188) {
					this.anInt281 = 1;
					this.anInt282 = local18;
					this.anInt283 = local23;
					this.anInt284 = local33;
					this.aString10 = Static5.method54(local33).aString3;
					this.anInt291 = 0;
				} else {
					if (local28 == 44 && !this.aBoolean49) {
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 235);
						this.aClass1_Sub3_Sub3_6.method382(local23);
						this.aBoolean49 = true;
					}
					@Pc(830) Class5 local830;
					@Pc(845) String local845;
					if (local28 == 1773) {
						local830 = Static5.method54(local33);
						if (local23 >= 100000) {
							local845 = local23 + " x " + local830.aString3;
						} else if (local830.aByteArray3 == null) {
							local845 = "It's a " + local830.aString3 + ".";
						} else {
							local845 = new String(local830.aByteArray3);
						}
						this.method172(0, local845, (byte) 4, "");
					}
					if (local28 == 900) {
						local345 = this.aClass1_Sub1_Sub3_Sub1Array1[local33];
						if (local345 != null) {
							this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local345.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local345.anIntArray233[0], 0, 0, 0);
							this.anInt153 = super.anInt138;
							this.anInt154 = super.anInt139;
							this.anInt156 = 2;
							this.anInt155 = 0;
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 202);
							this.aClass1_Sub3_Sub3_6.method382(local33);
							this.aClass1_Sub3_Sub3_6.method382(this.anInt284);
							this.aClass1_Sub3_Sub3_6.method382(this.anInt282);
							this.aClass1_Sub3_Sub3_6.method382(this.anInt283);
						}
					}
					@Pc(969) Class1_Sub1_Sub3_Sub2 local969;
					if (local28 == 1373 || local28 == 1544 || local28 == 151 || local28 == 1101) {
						local969 = this.aClass1_Sub1_Sub3_Sub2Array1[local33];
						if (local969 != null) {
							this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local969.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local969.anIntArray233[0], 0, 0, 0);
							this.anInt153 = super.anInt138;
							this.anInt154 = super.anInt139;
							this.anInt156 = 2;
							this.anInt155 = 0;
							if (local28 == 1101) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 164);
							}
							if (local28 == 151) {
								Static6.anInt237++;
								if (Static6.anInt237 >= 90) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 2);
									this.aClass1_Sub3_Sub3_6.method382(31114);
								}
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 53);
							}
							if (local28 == 1373) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 206);
							}
							if (local28 == 1544) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 185);
							}
							this.aClass1_Sub3_Sub3_6.method382(local33);
						}
					}
					if (local28 == 265) {
						local345 = this.aClass1_Sub1_Sub3_Sub1Array1[local33];
						if (local345 != null) {
							this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local345.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local345.anIntArray233[0], 0, 0, 0);
							this.anInt153 = super.anInt138;
							this.anInt154 = super.anInt139;
							this.anInt156 = 2;
							this.anInt155 = 0;
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 134);
							this.aClass1_Sub3_Sub3_6.method382(local33);
							this.aClass1_Sub3_Sub3_6.method382(this.anInt292);
						}
					}
					@Pc(1156) long local1156;
					if (local28 == 679) {
						local48 = this.aStringArray5[arg1];
						local52 = local48.indexOf("@whi@");
						if (local52 != -1) {
							local1156 = Static30.method538(local48.substring(local52 + 5).trim());
							local73 = -1;
							for (@Pc(1160) int local1160 = 0; local1160 < this.anInt312; local1160++) {
								if (this.aLongArray4[local1160] == local1156) {
									local73 = local1160;
									break;
								}
							}
							if (local73 != -1 && this.anIntArray34[local73] > 0) {
								this.aBoolean60 = true;
								this.aBoolean66 = false;
								this.aBoolean47 = true;
								this.aString5 = "";
								this.anInt168 = 3;
								this.aLong8 = this.aLongArray4[local73];
								this.aString6 = "Enter message to send to " + this.aStringArray9[local73];
							}
						}
					}
					if (local28 == 55 && this.method153(9, local18, local23, local33, true)) {
						this.aClass1_Sub3_Sub3_6.method382(this.anInt292);
					}
					if (local28 == 224 || local28 == 993 || local28 == 99 || local28 == 746 || local28 == 877) {
						local500 = this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 0, false, local18, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 0, local23, 0, 0, 0);
						if (!local500) {
							this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local18, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local23, 0, 0, 0);
						}
						this.anInt153 = super.anInt138;
						this.anInt154 = super.anInt139;
						this.anInt156 = 2;
						this.anInt155 = 0;
						if (local28 == 224) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 140);
						}
						if (local28 == 746) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 178);
						}
						if (local28 == 877) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 247);
						}
						if (local28 == 99) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 200);
						}
						if (local28 == 993) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 40);
						}
						this.aClass1_Sub3_Sub3_6.method382(local18 + this.anInt169);
						this.aClass1_Sub3_Sub3_6.method382(local23 + this.anInt170);
						this.aClass1_Sub3_Sub3_6.method382(local33);
					}
					if (local28 == 1607) {
						local345 = this.aClass1_Sub1_Sub3_Sub1Array1[local33];
						if (local345 != null) {
							if (local345.aClass3_1.aByteArray2 == null) {
								local845 = "It's a " + local345.aClass3_1.aString2 + ".";
							} else {
								local845 = new String(local345.aClass3_1.aByteArray2);
							}
							this.method172(0, local845, (byte) 4, "");
						}
					}
					if (local28 == 504) {
						this.method153(172, local18, local23, local33, true);
					}
					@Pc(1429) Class15 local1429;
					if (local28 == 930) {
						local1429 = Static17.aClass15Array1[local23];
						this.anInt291 = 1;
						this.anInt292 = local23;
						this.anInt293 = local1429.anInt493;
						this.anInt281 = 0;
						local845 = local1429.aString22;
						if (local845.indexOf(" ") != -1) {
							local845 = local845.substring(0, local845.indexOf(" "));
						}
						local69 = local1429.aString22;
						if (local69.indexOf(" ") != -1) {
							local69 = local69.substring(local69.indexOf(" ") + 1);
						}
						this.aString11 = local845 + " " + local1429.aString23 + " " + local69;
						if (this.anInt293 == 16) {
							this.aBoolean59 = true;
							this.anInt166 = 3;
							this.aBoolean68 = true;
						}
					} else {
						if (local28 == 951) {
							local1429 = Static17.aClass15Array1[local23];
							@Pc(1513) boolean local1513 = true;
							if (local1429.anInt474 > 0) {
								local1513 = this.method142(false, local1429);
							}
							if (local1513) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 155);
								this.aClass1_Sub3_Sub3_6.method382(local23);
							}
						}
						if (local28 == 602 || local28 == 596 || local28 == 22 || local28 == 892 || local28 == 415) {
							if (local28 == 22) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 212);
							}
							if (local28 == 415) {
								if ((local23 & 0x3) == 0) {
									Static6.anInt254++;
								}
								if (Static6.anInt254 >= 55) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 17);
									this.aClass1_Sub3_Sub3_6.method385(0);
								}
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 6);
							}
							if (local28 == 602) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 31);
							}
							if (local28 == 892) {
								if ((local18 & 0x3) == 0) {
									Static6.anInt229++;
								}
								if (Static6.anInt229 >= 130) {
									this.aClass1_Sub3_Sub3_6.method380((byte) -34, 238);
									this.aClass1_Sub3_Sub3_6.method381(177);
								}
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 38);
							}
							if (local28 == 596) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 59);
							}
							this.aClass1_Sub3_Sub3_6.method382(local33);
							this.aClass1_Sub3_Sub3_6.method382(local18);
							this.aClass1_Sub3_Sub3_6.method382(local23);
							this.anInt257 = 0;
							this.anInt258 = local23;
							this.anInt259 = local18;
							this.anInt260 = 2;
							if (Static17.aClass15Array1[local23].anInt471 == this.anInt271) {
								this.anInt260 = 1;
							}
							if (Static17.aClass15Array1[local23].anInt471 == this.anInt280) {
								this.anInt260 = 3;
							}
						}
						if (local28 == 581) {
							if ((local33 & 0x3) == 0) {
								Static6.anInt175++;
							}
							if (Static6.anInt175 >= 99) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 7);
								this.aClass1_Sub3_Sub3_6.method385(0);
							}
							this.method153(97, local18, local23, local33, true);
						}
						if (local28 == 965) {
							local500 = this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 0, false, local18, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 0, local23, 0, 0, 0);
							if (!local500) {
								this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local18, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local23, 0, 0, 0);
							}
							this.anInt153 = super.anInt138;
							this.anInt154 = super.anInt139;
							this.anInt156 = 2;
							this.anInt155 = 0;
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 138);
							this.aClass1_Sub3_Sub3_6.method382(local18 + this.anInt169);
							this.aClass1_Sub3_Sub3_6.method382(local23 + this.anInt170);
							this.aClass1_Sub3_Sub3_6.method382(local33);
							this.aClass1_Sub3_Sub3_6.method382(this.anInt292);
						}
						if (local28 == 1501) {
							Static6.anInt220 += this.anInt170;
							if (Static6.anInt220 >= 92) {
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 66);
								this.aClass1_Sub3_Sub3_6.method385(0);
							}
							this.method153(116, local18, local23, local33, true);
						}
						if (local28 == 364) {
							this.method153(96, local18, local23, local33, true);
						}
						if (local28 == 1102) {
							local830 = Static5.method54(local33);
							if (local830.aByteArray3 == null) {
								local845 = "It's a " + local830.aString3 + ".";
							} else {
								local845 = new String(local830.aByteArray3);
							}
							this.method172(0, local845, (byte) 4, "");
						}
						if (local28 == 960) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 155);
							this.aClass1_Sub3_Sub3_6.method382(local23);
							local1429 = Static17.aClass15Array1[local23];
							if (local1429.anIntArrayArray15 != null && local1429.anIntArrayArray15[0][0] == 5) {
								local52 = local1429.anIntArrayArray15[0][1];
								if (this.anIntArray59[local52] != local1429.anIntArray152[0]) {
									this.anIntArray59[local52] = local1429.anIntArray152[0];
									this.method122(local52, 49);
									this.aBoolean59 = true;
								}
							}
						}
						if (local28 == 34) {
							local48 = this.aStringArray5[arg1];
							local52 = local48.indexOf("@whi@");
							if (local52 != -1) {
								this.method77((byte) -60);
								this.aString9 = local48.substring(local52 + 5).trim();
								this.aBoolean51 = false;
								for (@Pc(1957) int local1957 = 0; local1957 < Static17.aClass15Array1.length; local1957++) {
									if (Static17.aClass15Array1[local1957] != null && Static17.aClass15Array1[local1957].anInt474 == 600) {
										this.anInt240 = this.anInt271 = Static17.aClass15Array1[local1957].anInt471;
										break;
									}
								}
							}
						}
						if (local28 == 947) {
							this.method77((byte) -60);
						}
						if (local28 == 367) {
							local969 = this.aClass1_Sub1_Sub3_Sub2Array1[local33];
							if (local969 != null) {
								this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local969.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local969.anIntArray233[0], 0, 0, 0);
								this.anInt153 = super.anInt138;
								this.anInt154 = super.anInt139;
								this.anInt156 = 2;
								this.anInt155 = 0;
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 248);
								this.aClass1_Sub3_Sub3_6.method382(local33);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt284);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt282);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt283);
							}
						}
						if (local28 == 465) {
							this.aClass1_Sub3_Sub3_6.method380((byte) -34, 155);
							this.aClass1_Sub3_Sub3_6.method382(local23);
							local1429 = Static17.aClass15Array1[local23];
							if (local1429.anIntArrayArray15 != null && local1429.anIntArrayArray15[0][0] == 5) {
								local52 = local1429.anIntArrayArray15[0][1];
								this.anIntArray59[local52] = 1 - this.anIntArray59[local52];
								this.method122(local52, 49);
								this.aBoolean59 = true;
							}
						}
						if (local28 == 406 || local28 == 436 || local28 == 557 || local28 == 556) {
							local48 = this.aStringArray5[arg1];
							local52 = local48.indexOf("@whi@");
							if (local52 != -1) {
								local1156 = Static30.method538(local48.substring(local52 + 5).trim());
								if (local28 == 406) {
									this.method161(local1156, -460);
								}
								if (local28 == 436) {
									this.method82(local1156, (byte) 3);
								}
								if (local28 == 557) {
									this.method174(43808, local1156);
								}
								if (local28 == 556) {
									this.method191(1, local1156);
								}
							}
						}
						if (local28 == 651) {
							local969 = this.aClass1_Sub1_Sub3_Sub2Array1[local33];
							if (local969 != null) {
								this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 1, false, local969.anIntArray232[0], this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 1, local969.anIntArray233[0], 0, 0, 0);
								this.anInt153 = super.anInt138;
								this.anInt154 = super.anInt139;
								this.anInt156 = 2;
								this.anInt155 = 0;
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 177);
								this.aClass1_Sub3_Sub3_6.method382(local33);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt292);
							}
						}
						this.anInt281 = 0;
						if (arg0 != 6412) {
							this.method67();
						}
						this.anInt291 = 0;
					}
				}
			}
		} catch (@Pc(2259) RuntimeException local2259) {
			signlink.reporterror("53215, " + arg0 + ", " + arg1 + ", " + local2259.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "s", descriptor = "(I)Ljava/lang/String;")
	private String method134(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != -7437) {
				this.aClass1_Sub3_Sub3_6.method381(216);
			}
			if (signlink.mainapp == null) {
				return super.aFrame_Sub1_2 == null ? super.getDocumentBase().getHost().toLowerCase() : "runescape.com";
			} else {
				return signlink.mainapp.getDocumentBase().getHost().toLowerCase();
			}
		} catch (@Pc(24) RuntimeException local24) {
			signlink.reporterror("57946, " + arg0 + ", " + local24.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "t", descriptor = "(I)V")
	private void method135(@OriginalArg(0) int arg0) {
		try {
			@Pc(2) int local2 = this.anInt338;
			@Pc(5) int local5 = this.anInt339;
			@Pc(8) int local8 = this.anInt340;
			@Pc(11) int local11 = this.anInt341;
			@Pc(13) int local13 = 6116423;
			Static12.method358(local5, local2, local13, (byte) 93, local8, local11);
			Static12.method358(local5 + 1, local2 + 1, 0, (byte) 93, local8 - 2, 16);
			Static12.method359(3, local2 + 1, 0, local11 - 19, local5 + 18, local8 - 2);
			this.aClass1_Sub3_Sub2_Sub4_3.method365(local2 + 3, local5 + 14, false, local13, "Choose Option");
			@Pc(63) int local63 = super.anInt135;
			@Pc(66) int local66 = super.anInt136;
			if (this.anInt337 == 0) {
				local63 -= 8;
				local66 -= 11;
			}
			if (this.anInt337 == 1) {
				local63 -= 562;
				local66 -= 231;
			}
			if (this.anInt337 == 2) {
				local63 -= 22;
				local66 -= 375;
			}
			for (@Pc(85) int local85 = 0; local85 < this.anInt304; local85++) {
				@Pc(100) int local100 = local5 + (this.anInt304 - 1 - local85) * 15 + 31;
				@Pc(102) int local102 = 16777215;
				if (local63 > local2 && local63 < local2 + local8 && local66 > local100 - 13 && local66 < local100 + 3) {
					local102 = 16776960;
				}
				this.aClass1_Sub3_Sub2_Sub4_3.method367(local2 + 3, 6, local100, this.aStringArray5[local85], true, local102);
			}
			if (arg0 >= 0) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
		} catch (@Pc(150) RuntimeException local150) {
			signlink.reporterror("42520, " + arg0 + ", " + local150.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(III)V")
	private void method136(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (this.anInt210 != 0) {
				@Pc(5) int local5 = 0;
				if (this.anInt267 != 0) {
					local5 = 1;
				}
				for (@Pc(12) int local12 = 0; local12 < 100; local12++) {
					if (this.aStringArray7[local12] != null) {
						@Pc(24) int local24 = this.anIntArray49[local12];
						if ((local24 == 3 || local24 == 7) && (local24 == 7 || this.anInt164 == 0 || this.anInt164 == 1 && this.method199(-20, this.aStringArray6[local12]))) {
							@Pc(54) int local54 = 329 - local5 * 13;
							if (super.anInt135 > 8 && super.anInt135 < 520 && arg2 - 11 > local54 - 10 && arg2 - 11 <= local54 + 3) {
								if (this.aBoolean65) {
									this.aStringArray5[this.anInt304] = "Report abuse @whi@" + this.aStringArray6[local12];
									this.anIntArray86[this.anInt304] = 2034;
									this.anInt304++;
								}
								this.aStringArray5[this.anInt304] = "Add ignore @whi@" + this.aStringArray6[local12];
								this.anIntArray86[this.anInt304] = 2436;
								this.anInt304++;
								this.aStringArray5[this.anInt304] = "Add friend @whi@" + this.aStringArray6[local12];
								this.anIntArray86[this.anInt304] = 2406;
								this.anInt304++;
							}
							local5++;
							if (local5 >= 5) {
								return;
							}
						}
						if ((local24 == 5 || local24 == 6) && this.anInt164 < 2) {
							local5++;
							if (local5 >= 5) {
								return;
							}
						}
					}
				}
				if (arg1 != 27078) {
					this.aBoolean38 = !this.aBoolean38;
				}
			}
		} catch (@Pc(197) RuntimeException local197) {
			signlink.reporterror("26899, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local197.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!hc;)V")
	private void method137(@OriginalArg(0) int arg0, @OriginalArg(1) Class15 arg1) {
		try {
			@Pc(4) int local4 = arg1.anInt474;
			if (arg0 != 0) {
				Static6.anInt268 = -68;
			}
			if (local4 >= 1 && local4 <= 100) {
				local4--;
				if (local4 >= this.anInt312) {
					arg1.aString20 = "";
					arg1.anInt473 = 0;
				} else {
					arg1.aString20 = this.aStringArray9[local4];
					arg1.anInt473 = 1;
				}
			} else if (local4 >= 101 && local4 <= 200) {
				local4 -= 101;
				if (local4 >= this.anInt312) {
					arg1.aString20 = "";
					arg1.anInt473 = 0;
				} else {
					if (this.anIntArray34[local4] == 0) {
						arg1.aString20 = "@red@Offline";
					} else if (this.anIntArray34[local4] == Static6.anInt235) {
						arg1.aString20 = "@gre@World-" + (this.anIntArray34[local4] - 9);
					} else {
						arg1.aString20 = "@yel@World-" + (this.anIntArray34[local4] - 9);
					}
					arg1.anInt473 = 1;
				}
			} else if (local4 == 203) {
				arg1.anInt480 = this.anInt312 * 15 + 20;
				if (arg1.anInt480 <= arg1.anInt476) {
					arg1.anInt480 = arg1.anInt476 + 1;
				}
			} else if (local4 >= 401 && local4 <= 500) {
				local4 -= 401;
				if (local4 >= this.anInt186) {
					arg1.aString20 = "";
					arg1.anInt473 = 0;
				} else {
					arg1.aString20 = Static30.method542(0, Static30.method539(this.aLongArray3[local4], false));
					arg1.anInt473 = 1;
				}
			} else if (local4 == 503) {
				arg1.anInt480 = this.anInt186 * 15 + 20;
				if (arg1.anInt480 <= arg1.anInt476) {
					arg1.anInt480 = arg1.anInt476 + 1;
				}
			} else if (local4 == 327) {
				arg1.anInt491 = 150;
				arg1.anInt492 = (int) (Math.sin((double) Static6.anInt266 / 40.0D) * 256.0D) & 0x7FF;
				if (this.aBoolean39) {
					this.aBoolean39 = false;
					@Pc(209) Class1_Sub3_Sub1[] local209 = new Class1_Sub3_Sub1[7];
					@Pc(211) int local211 = 0;
					for (@Pc(213) int local213 = 0; local213 < 7; local213++) {
						@Pc(220) int local220 = this.anIntArray35[local213];
						if (local220 >= 0) {
							local209[local211++] = Static16.aClass13Array1[local220].method306();
						}
					}
					@Pc(241) Class1_Sub3_Sub1 local241 = new Class1_Sub3_Sub1(0, local209, local211);
					for (@Pc(243) int local243 = 0; local243 < 5; local243++) {
						if (this.anIntArray33[local243] != 0) {
							local241.method237(Static6.anIntArrayArray4[local243][0], Static6.anIntArrayArray4[local243][this.anIntArray33[local243]]);
							if (local243 == 1) {
								local241.method237(Static6.anIntArray70[0], Static6.anIntArray70[this.anIntArray33[local243]]);
							}
						}
					}
					local241.method230(4);
					local241.method231(-16599, Static20.aClass19Array1[this.aClass1_Sub1_Sub3_Sub2_1.anInt886].anIntArray186[0]);
					local241.method240(64, 850, -30, -50, -30, true);
					arg1.aClass1_Sub3_Sub1_2 = local241;
				}
			} else if (local4 == 324) {
				if (this.aClass1_Sub3_Sub2_Sub2_1 == null) {
					this.aClass1_Sub3_Sub2_Sub2_1 = arg1.aClass1_Sub3_Sub2_Sub2_12;
					this.aClass1_Sub3_Sub2_Sub2_2 = arg1.aClass1_Sub3_Sub2_Sub2_13;
				}
				if (this.aBoolean43) {
					arg1.aClass1_Sub3_Sub2_Sub2_12 = this.aClass1_Sub3_Sub2_Sub2_2;
				} else {
					arg1.aClass1_Sub3_Sub2_Sub2_12 = this.aClass1_Sub3_Sub2_Sub2_1;
				}
			} else if (local4 == 325) {
				if (this.aClass1_Sub3_Sub2_Sub2_1 == null) {
					this.aClass1_Sub3_Sub2_Sub2_1 = arg1.aClass1_Sub3_Sub2_Sub2_12;
					this.aClass1_Sub3_Sub2_Sub2_2 = arg1.aClass1_Sub3_Sub2_Sub2_13;
				}
				if (this.aBoolean43) {
					arg1.aClass1_Sub3_Sub2_Sub2_12 = this.aClass1_Sub3_Sub2_Sub2_1;
				} else {
					arg1.aClass1_Sub3_Sub2_Sub2_12 = this.aClass1_Sub3_Sub2_Sub2_2;
				}
			} else if (local4 == 600) {
				arg1.aString20 = this.aString9;
				if (Static6.anInt266 % 20 < 10) {
					arg1.aString20 = arg1.aString20 + "|";
				} else {
					arg1.aString20 = arg1.aString20 + " ";
				}
			} else {
				if (local4 == 613) {
					if (!this.aBoolean65) {
						arg1.aString20 = "";
					} else if (this.aBoolean51) {
						arg1.anInt485 = 16711680;
						arg1.aString20 = "Moderator option: Mute player for 48 hours: <ON>";
					} else {
						arg1.anInt485 = 16777215;
						arg1.aString20 = "Moderator option: Mute player for 48 hours: <OFF>";
					}
				}
				@Pc(441) String local441;
				if (local4 == 650 || local4 == 655) {
					if (this.anInt299 == 0) {
						arg1.aString20 = "";
					} else {
						if (this.anInt226 == 0) {
							local441 = "earlier today";
						} else if (this.anInt226 == 1) {
							local441 = "yesterday";
						} else {
							local441 = this.anInt226 + " days ago";
						}
						arg1.aString20 = "You last logged in " + local441 + " from: " + signlink.dns;
					}
				}
				if (local4 == 651) {
					if (this.anInt298 == 0) {
						arg1.aString20 = "0 unread messages";
						arg1.anInt485 = 16776960;
					}
					if (this.anInt298 == 1) {
						arg1.aString20 = "1 unread message";
						arg1.anInt485 = 65280;
					}
					if (this.anInt298 > 1) {
						arg1.aString20 = this.anInt298 + " unread messages";
						arg1.anInt485 = 65280;
					}
				}
				if (local4 == 652) {
					if (this.anInt239 == 201) {
						arg1.aString20 = "";
					} else if (this.anInt239 == 200) {
						arg1.aString20 = "You have not yet set any password recovery questions.";
					} else {
						if (this.anInt239 == 0) {
							local441 = "Earlier today";
						} else if (this.anInt239 == 1) {
							local441 = "Yesterday";
						} else {
							local441 = this.anInt239 + " days ago";
						}
						arg1.aString20 = local441 + " you changed your recovery questions";
					}
				}
				if (local4 == 653) {
					if (this.anInt239 == 201) {
						arg1.aString20 = "";
					} else if (this.anInt239 == 200) {
						arg1.aString20 = "We strongly recommend you do so now to secure your account.";
					} else {
						arg1.aString20 = "If you do not remember making this change then cancel it immediately";
					}
				}
				if (local4 == 654) {
					if (this.anInt239 == 201) {
						arg1.aString20 = "";
					} else if (this.anInt239 == 200) {
						arg1.aString20 = "Do this from the 'account management' area on our front webpage";
					} else {
						arg1.aString20 = "Do this from the 'account management' area on our front webpage";
					}
				}
			}
		} catch (@Pc(623) RuntimeException local623) {
			signlink.reporterror("10984, " + arg0 + ", " + arg1 + ", " + local623.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BII)Z")
	private boolean method138(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg2 != 0) {
				this.anInt179 = -1;
			}
			return arg0 == null ? true : signlink.wavesave(arg0, arg1);
		} catch (@Pc(13) RuntimeException local13) {
			signlink.reporterror("94307, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local13.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "u", descriptor = "(I)Z")
	private boolean method139(@OriginalArg(0) int arg0) {
		try {
			if (arg0 <= 0) {
				this.aClass1_Sub3_Sub3_6.method381(77);
			}
			return signlink.wavereplay();
		} catch (@Pc(8) RuntimeException local8) {
			signlink.reporterror("495, " + arg0 + ", " + local8.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(II)V")
	private void method140(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg1 != 0) {
				this.aClass28ArrayArrayArray1 = null;
			}
			signlink.wavevol = arg0;
		} catch (@Pc(8) RuntimeException local8) {
			signlink.reporterror("63786, " + arg0 + ", " + arg1 + ", " + local8.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!kb;I)V")
	private void method141(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0) {
				this.method67();
			}
			while (arg1.anInt562 + 21 < arg2 * 8) {
				@Pc(16) int local16 = arg1.method402(9, 13);
				if (local16 == 8191) {
					break;
				}
				if (this.aClass1_Sub1_Sub3_Sub1Array1[local16] == null) {
					this.aClass1_Sub1_Sub3_Sub1Array1[local16] = new Class1_Sub1_Sub3_Sub1();
				}
				@Pc(36) Class1_Sub1_Sub3_Sub1 local36 = this.aClass1_Sub1_Sub3_Sub1Array1[local16];
				this.anIntArray58[this.anInt248++] = local16;
				local36.anInt924 = Static6.anInt266;
				local36.aClass3_1 = Static3.method32(arg1.method402(9, 11));
				local36.anInt885 = local36.aClass3_1.aByte4;
				local36.anInt888 = local36.aClass3_1.anInt70;
				local36.anInt889 = local36.aClass3_1.anInt71;
				local36.anInt890 = local36.aClass3_1.anInt72;
				local36.anInt891 = local36.aClass3_1.anInt73;
				local36.anInt886 = local36.aClass3_1.anInt69;
				@Pc(92) int local92 = arg1.method402(9, 5);
				if (local92 > 15) {
					local92 -= 32;
				}
				@Pc(101) int local101 = arg1.method402(9, 5);
				if (local101 > 15) {
					local101 -= 32;
				}
				local36.method569(false, false, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0] + local92, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0] + local101);
				@Pc(128) int local128 = arg1.method402(9, 1);
				if (local128 == 1) {
					this.anIntArray40[this.anInt206++] = local16;
				}
			}
			arg1.method403(this.anInt197);
		} catch (@Pc(150) RuntimeException local150) {
			signlink.reporterror("14259, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local150.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!hc;)Z")
	private boolean method142(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class15 arg1) {
		try {
			@Pc(4) int local4 = arg1.anInt474;
			if (arg0) {
				this.method67();
			}
			if (local4 == 201) {
				this.aBoolean60 = true;
				this.aBoolean66 = false;
				this.aBoolean47 = true;
				this.aString5 = "";
				this.anInt168 = 1;
				this.aString6 = "Enter name of friend to add to list";
			}
			if (local4 == 202) {
				this.aBoolean60 = true;
				this.aBoolean66 = false;
				this.aBoolean47 = true;
				this.aString5 = "";
				this.anInt168 = 2;
				this.aString6 = "Enter name of friend to delete from list";
			}
			if (local4 == 205) {
				this.anInt182 = 250;
				return true;
			}
			if (local4 == 501) {
				this.aBoolean60 = true;
				this.aBoolean66 = false;
				this.aBoolean47 = true;
				this.aString5 = "";
				this.anInt168 = 4;
				this.aString6 = "Enter name of player to add to list";
			}
			if (local4 == 502) {
				this.aBoolean60 = true;
				this.aBoolean66 = false;
				this.aBoolean47 = true;
				this.aString5 = "";
				this.anInt168 = 5;
				this.aString6 = "Enter name of player to delete from list";
			}
			@Pc(112) int local112;
			@Pc(116) int local116;
			@Pc(121) int local121;
			if (local4 >= 300 && local4 <= 313) {
				local112 = (local4 - 300) / 2;
				local116 = local4 & 0x1;
				local121 = this.anIntArray35[local112];
				if (local121 != -1) {
					while (true) {
						if (local116 == 0) {
							local121--;
							if (local121 < 0) {
								local121 = Static16.anInt437 - 1;
							}
						}
						if (local116 == 1) {
							local121++;
							if (local121 >= Static16.anInt437) {
								local121 = 0;
							}
						}
						if (!Static16.aClass13Array1[local121].aBoolean101 && Static16.aClass13Array1[local121].anInt438 == local112 + (this.aBoolean43 ? 0 : 7)) {
							this.anIntArray35[local112] = local121;
							this.aBoolean39 = true;
							break;
						}
					}
				}
			}
			if (local4 >= 314 && local4 <= 323) {
				local112 = (local4 - 314) / 2;
				local116 = local4 & 0x1;
				local121 = this.anIntArray33[local112];
				if (local116 == 0) {
					local121--;
					if (local121 < 0) {
						local121 = Static6.anIntArrayArray4[local112].length - 1;
					}
				}
				if (local116 == 1) {
					local121++;
					if (local121 >= Static6.anIntArrayArray4[local112].length) {
						local121 = 0;
					}
				}
				this.anIntArray33[local112] = local121;
				this.aBoolean39 = true;
			}
			if (local4 == 324 && !this.aBoolean43) {
				this.aBoolean43 = true;
				this.method112((byte) -6);
			}
			if (local4 == 325 && this.aBoolean43) {
				this.aBoolean43 = false;
				this.method112((byte) -6);
			}
			if (local4 == 326) {
				this.aClass1_Sub3_Sub3_6.method380((byte) -34, 52);
				this.aClass1_Sub3_Sub3_6.method381(this.aBoolean43 ? 0 : 1);
				for (local112 = 0; local112 < 7; local112++) {
					this.aClass1_Sub3_Sub3_6.method381(this.anIntArray35[local112]);
				}
				for (local116 = 0; local116 < 5; local116++) {
					this.aClass1_Sub3_Sub3_6.method381(this.anIntArray33[local116]);
				}
				return true;
			}
			if (local4 == 613) {
				this.aBoolean51 = !this.aBoolean51;
			}
			if (local4 >= 601 && local4 <= 612) {
				this.method77((byte) -60);
				if (this.aString9.length() > 0) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 190);
					this.aClass1_Sub3_Sub3_6.method387(true, Static30.method538(this.aString9));
					this.aClass1_Sub3_Sub3_6.method381(local4 - 601);
					this.aClass1_Sub3_Sub3_6.method381(this.aBoolean51 ? 1 : 0);
				}
			}
			return false;
		} catch (@Pc(349) RuntimeException local349) {
			signlink.reporterror("80636, " + arg0 + ", " + arg1 + ", " + local349.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "()V")
	@Override
	protected void method67() {
		if (signlink.sunjava) {
			super.anInt129 = 5;
		}
		if (!Static6.aBoolean53) {
			this.aBoolean40 = true;
			this.aBoolean41 = true;
			this.method73(this, 2);
			this.method75(false, 12345678, "scape_main", 40000);
		}
		if (Static6.aBoolean69) {
			this.aBoolean67 = true;
			return;
		}
		Static6.aBoolean69 = true;
		@Pc(34) boolean local34 = false;
		@Pc(38) String local38 = this.method134(-7437);
		if (local38.endsWith("jagex.com")) {
			local34 = true;
		}
		if (local38.endsWith("runescape.com")) {
			local34 = true;
		}
		if (local38.endsWith("192.168.1.2")) {
			local34 = true;
		}
		if (local38.endsWith("192.168.1.249")) {
			local34 = true;
		}
		if (local38.endsWith("192.168.1.252")) {
			local34 = true;
		}
		if (local38.endsWith("192.168.1.253")) {
			local34 = true;
		}
		if (local38.endsWith("192.168.1.254")) {
			local34 = true;
		}
		if (local38.endsWith("127.0.0.1")) {
			local34 = true;
		}
		if (!local34) {
			this.aBoolean57 = true;
			return;
		}
		try {
			@Pc(94) int local94 = 5;
			this.anIntArray38[8] = 0;
			while (this.anIntArray38[8] == 0) {
				this.method74(true, "Connecting to fileserver", 10);
				try {
					@Pc(119) DataInputStream local119 = this.method155("crc" + (int) (Math.random() * 9.9999999E7D));
					@Pc(126) Class1_Sub3_Sub3 local126 = new Class1_Sub3_Sub3(363, new byte[36]);
					local119.readFully(local126.aByteArray7, 0, 36);
					for (@Pc(134) int local134 = 0; local134 < 9; local134++) {
						this.anIntArray38[local134] = local126.method396();
					}
					local119.close();
				} catch (@Pc(150) IOException local150) {
					for (@Pc(152) int local152 = local94; local152 > 0; local152--) {
						this.method74(true, "Error loading - Will retry in " + local152 + " secs.", 10);
						try {
							Thread.sleep(1000L);
						} catch (@Pc(171) Exception local171) {
						}
					}
					local94 *= 2;
					if (local94 > 60) {
						local94 = 60;
					}
				}
			}
			this.aClass39_1 = this.method98("title screen", this.anIntArray38[1], "title", 10, 0);
			this.aClass1_Sub3_Sub2_Sub4_1 = new Class1_Sub3_Sub2_Sub4(this.aClass39_1, "p11", 530);
			this.aClass1_Sub3_Sub2_Sub4_2 = new Class1_Sub3_Sub2_Sub4(this.aClass39_1, "p12", 530);
			this.aClass1_Sub3_Sub2_Sub4_3 = new Class1_Sub3_Sub2_Sub4(this.aClass39_1, "b12", 530);
			this.aClass1_Sub3_Sub2_Sub4_4 = new Class1_Sub3_Sub2_Sub4(this.aClass39_1, "q8", 530);
			this.method189((byte) 5);
			this.method109(0);
			@Pc(255) Class39 local255 = this.method98("config", this.anIntArray38[2], "config", 15, 0);
			@Pc(266) Class39 local266 = this.method98("interface", this.anIntArray38[3], "interface", 20, 0);
			@Pc(277) Class39 local277 = this.method98("2d graphics", this.anIntArray38[4], "media", 30, 0);
			@Pc(288) Class39 local288 = this.method98("3d graphics", this.anIntArray38[5], "models", 40, 0);
			@Pc(299) Class39 local299 = this.method98("textures", this.anIntArray38[6], "textures", 60, 0);
			@Pc(310) Class39 local310 = this.method98("chat system", this.anIntArray38[7], "wordenc", 65, 0);
			@Pc(321) Class39 local321 = this.method98("sound effects", this.anIntArray38[8], "sounds", 70, 0);
			this.aByteArrayArrayArray7 = new byte[4][104][104];
			this.anIntArrayArrayArray3 = new int[4][105][105];
			this.aClass33_1 = new Class33(415, this.anIntArrayArrayArray3, 104, 4, 104);
			for (@Pc(346) int local346 = 0; local346 < 4; local346++) {
				this.aClass9Array1[local346] = new Class9(104, -708, 104);
			}
			this.aClass1_Sub3_Sub2_Sub2_6 = new Class1_Sub3_Sub2_Sub2(512, 512);
			this.method74(true, "Unpacking media", 75);
			this.aClass1_Sub3_Sub2_Sub3_9 = new Class1_Sub3_Sub2_Sub3(local277, "invback", 0);
			this.aClass1_Sub3_Sub2_Sub3_11 = new Class1_Sub3_Sub2_Sub3(local277, "chatback", 0);
			this.aClass1_Sub3_Sub2_Sub3_10 = new Class1_Sub3_Sub2_Sub3(local277, "mapback", 0);
			this.aClass1_Sub3_Sub2_Sub3_6 = new Class1_Sub3_Sub2_Sub3(local277, "backbase1", 0);
			this.aClass1_Sub3_Sub2_Sub3_7 = new Class1_Sub3_Sub2_Sub3(local277, "backbase2", 0);
			this.aClass1_Sub3_Sub2_Sub3_8 = new Class1_Sub3_Sub2_Sub3(local277, "backhmid1", 0);
			for (@Pc(424) int local424 = 0; local424 < 13; local424++) {
				this.aClass1_Sub3_Sub2_Sub3Array1[local424] = new Class1_Sub3_Sub2_Sub3(local277, "sideicons", local424);
			}
			this.aClass1_Sub3_Sub2_Sub2_11 = new Class1_Sub3_Sub2_Sub2(local277, "compass", 0);
			@Pc(450) int local450;
			try {
				for (local450 = 0; local450 < 50; local450++) {
					this.aClass1_Sub3_Sub2_Sub3Array3[local450] = new Class1_Sub3_Sub2_Sub3(local277, "mapscene", local450);
				}
			} catch (@Pc(468) Exception local468) {
			}
			try {
				for (local450 = 0; local450 < 50; local450++) {
					this.aClass1_Sub3_Sub2_Sub2Array7[local450] = new Class1_Sub3_Sub2_Sub2(local277, "mapfunction", local450);
				}
			} catch (@Pc(488) Exception local488) {
			}
			try {
				for (local450 = 0; local450 < 20; local450++) {
					this.aClass1_Sub3_Sub2_Sub2Array3[local450] = new Class1_Sub3_Sub2_Sub2(local277, "hitmarks", local450);
				}
			} catch (@Pc(508) Exception local508) {
			}
			try {
				for (local450 = 0; local450 < 20; local450++) {
					this.aClass1_Sub3_Sub2_Sub2Array5[local450] = new Class1_Sub3_Sub2_Sub2(local277, "headicons", local450);
				}
			} catch (@Pc(528) Exception local528) {
			}
			this.aClass1_Sub3_Sub2_Sub2_5 = new Class1_Sub3_Sub2_Sub2(local277, "mapflag", 0);
			for (local450 = 0; local450 < 8; local450++) {
				this.aClass1_Sub3_Sub2_Sub2Array6[local450] = new Class1_Sub3_Sub2_Sub2(local277, "cross", local450);
			}
			this.aClass1_Sub3_Sub2_Sub2_7 = new Class1_Sub3_Sub2_Sub2(local277, "mapdots", 0);
			this.aClass1_Sub3_Sub2_Sub2_8 = new Class1_Sub3_Sub2_Sub2(local277, "mapdots", 1);
			this.aClass1_Sub3_Sub2_Sub2_9 = new Class1_Sub3_Sub2_Sub2(local277, "mapdots", 2);
			this.aClass1_Sub3_Sub2_Sub2_10 = new Class1_Sub3_Sub2_Sub2(local277, "mapdots", 3);
			this.aClass1_Sub3_Sub2_Sub3_17 = new Class1_Sub3_Sub2_Sub3(local277, "scrollbar", 0);
			this.aClass1_Sub3_Sub2_Sub3_18 = new Class1_Sub3_Sub2_Sub3(local277, "scrollbar", 1);
			this.aClass1_Sub3_Sub2_Sub3_1 = new Class1_Sub3_Sub2_Sub3(local277, "redstone1", 0);
			this.aClass1_Sub3_Sub2_Sub3_2 = new Class1_Sub3_Sub2_Sub3(local277, "redstone2", 0);
			this.aClass1_Sub3_Sub2_Sub3_3 = new Class1_Sub3_Sub2_Sub3(local277, "redstone3", 0);
			this.aClass1_Sub3_Sub2_Sub3_4 = new Class1_Sub3_Sub2_Sub3(local277, "redstone1", 0);
			this.aClass1_Sub3_Sub2_Sub3_4.method347(-725);
			this.aClass1_Sub3_Sub2_Sub3_5 = new Class1_Sub3_Sub2_Sub3(local277, "redstone2", 0);
			this.aClass1_Sub3_Sub2_Sub3_5.method347(-725);
			this.aClass1_Sub3_Sub2_Sub3_12 = new Class1_Sub3_Sub2_Sub3(local277, "redstone1", 0);
			this.aClass1_Sub3_Sub2_Sub3_12.method348((byte) -74);
			this.aClass1_Sub3_Sub2_Sub3_13 = new Class1_Sub3_Sub2_Sub3(local277, "redstone2", 0);
			this.aClass1_Sub3_Sub2_Sub3_13.method348((byte) -74);
			this.aClass1_Sub3_Sub2_Sub3_14 = new Class1_Sub3_Sub2_Sub3(local277, "redstone3", 0);
			this.aClass1_Sub3_Sub2_Sub3_14.method348((byte) -74);
			this.aClass1_Sub3_Sub2_Sub3_15 = new Class1_Sub3_Sub2_Sub3(local277, "redstone1", 0);
			this.aClass1_Sub3_Sub2_Sub3_15.method347(-725);
			this.aClass1_Sub3_Sub2_Sub3_15.method348((byte) -74);
			this.aClass1_Sub3_Sub2_Sub3_16 = new Class1_Sub3_Sub2_Sub3(local277, "redstone2", 0);
			this.aClass1_Sub3_Sub2_Sub3_16.method347(-725);
			this.aClass1_Sub3_Sub2_Sub3_16.method348((byte) -74);
			@Pc(725) Class1_Sub3_Sub2_Sub2 local725 = new Class1_Sub3_Sub2_Sub2(local277, "backleft1", 0);
			this.aClass32_6 = new Class32(this.method72(Static6.aByte16), local725.anInt461, 299, local725.anInt462);
			local725.method320(34676, 0, 0);
			@Pc(750) Class1_Sub3_Sub2_Sub2 local750 = new Class1_Sub3_Sub2_Sub2(local277, "backleft2", 0);
			this.aClass32_7 = new Class32(this.method72(Static6.aByte16), local750.anInt461, 299, local750.anInt462);
			local750.method320(34676, 0, 0);
			@Pc(775) Class1_Sub3_Sub2_Sub2 local775 = new Class1_Sub3_Sub2_Sub2(local277, "backright1", 0);
			this.aClass32_8 = new Class32(this.method72(Static6.aByte16), local775.anInt461, 299, local775.anInt462);
			local775.method320(34676, 0, 0);
			@Pc(800) Class1_Sub3_Sub2_Sub2 local800 = new Class1_Sub3_Sub2_Sub2(local277, "backright2", 0);
			this.aClass32_9 = new Class32(this.method72(Static6.aByte16), local800.anInt461, 299, local800.anInt462);
			local800.method320(34676, 0, 0);
			@Pc(825) Class1_Sub3_Sub2_Sub2 local825 = new Class1_Sub3_Sub2_Sub2(local277, "backtop1", 0);
			this.aClass32_10 = new Class32(this.method72(Static6.aByte16), local825.anInt461, 299, local825.anInt462);
			local825.method320(34676, 0, 0);
			@Pc(850) Class1_Sub3_Sub2_Sub2 local850 = new Class1_Sub3_Sub2_Sub2(local277, "backtop2", 0);
			this.aClass32_11 = new Class32(this.method72(Static6.aByte16), local850.anInt461, 299, local850.anInt462);
			local850.method320(34676, 0, 0);
			@Pc(875) Class1_Sub3_Sub2_Sub2 local875 = new Class1_Sub3_Sub2_Sub2(local277, "backvmid1", 0);
			this.aClass32_12 = new Class32(this.method72(Static6.aByte16), local875.anInt461, 299, local875.anInt462);
			local875.method320(34676, 0, 0);
			@Pc(900) Class1_Sub3_Sub2_Sub2 local900 = new Class1_Sub3_Sub2_Sub2(local277, "backvmid2", 0);
			this.aClass32_13 = new Class32(this.method72(Static6.aByte16), local900.anInt461, 299, local900.anInt462);
			local900.method320(34676, 0, 0);
			@Pc(925) Class1_Sub3_Sub2_Sub2 local925 = new Class1_Sub3_Sub2_Sub2(local277, "backvmid3", 0);
			this.aClass32_14 = new Class32(this.method72(Static6.aByte16), local925.anInt461, 299, local925.anInt462);
			local925.method320(34676, 0, 0);
			@Pc(950) Class1_Sub3_Sub2_Sub2 local950 = new Class1_Sub3_Sub2_Sub2(local277, "backhmid2", 0);
			this.aClass32_15 = new Class32(this.method72(Static6.aByte16), local950.anInt461, 299, local950.anInt462);
			local950.method320(34676, 0, 0);
			@Pc(975) int local975 = (int) (Math.random() * 21.0D) - 10;
			@Pc(982) int local982 = (int) (Math.random() * 21.0D) - 10;
			@Pc(989) int local989 = (int) (Math.random() * 21.0D) - 10;
			@Pc(996) int local996 = (int) (Math.random() * 41.0D) - 20;
			for (@Pc(998) int local998 = 0; local998 < 50; local998++) {
				if (this.aClass1_Sub3_Sub2_Sub2Array7[local998] != null) {
					this.aClass1_Sub3_Sub2_Sub2Array7[local998].method319(local975 + local996, local982 + local996, local989 + local996, true);
				}
				if (this.aClass1_Sub3_Sub2_Sub3Array3[local998] != null) {
					this.aClass1_Sub3_Sub2_Sub3Array3[local998].method349(local975 + local996, local982 + local996, local989 + local996, true);
				}
			}
			this.method74(true, "Unpacking textures", 80);
			Static15.method292((byte) 2, local299);
			Static15.method296(true, 0.8D);
			Static15.method291(20, -20);
			this.method74(true, "Unpacking models", 83);
			Static10.method225(Static6.anInt268, local288);
			Static11.method261(false, local288);
			Static14.method276(false, local288);
			this.method74(true, "Unpacking config", 86);
			Static20.method374(local255, 473);
			Static2.method21(local255);
			Static13.method272(local255, 473);
			Static5.method52(local255);
			Static3.method30(local255);
			Static16.method304(local255, 473);
			Static22.method407(local255, 473);
			Static23.method411(local255, 473);
			Static5.aBoolean29 = Static6.aBoolean52;
			if (!Static6.aBoolean53) {
				this.method74(true, "Unpacking sounds", 90);
				@Pc(1113) byte[] local1113 = local321.method536("sounds.dat", null, (byte) 2);
				@Pc(1119) Class1_Sub3_Sub3 local1119 = new Class1_Sub3_Sub3(363, local1113);
				Static32.method561(local1119, 473);
			}
			this.method74(true, "Unpacking interfaces", 92);
			@Pc(1150) Class1_Sub3_Sub2_Sub4[] local1150 = new Class1_Sub3_Sub2_Sub4[] { this.aClass1_Sub3_Sub2_Sub4_1, this.aClass1_Sub3_Sub2_Sub4_2, this.aClass1_Sub3_Sub2_Sub4_3, this.aClass1_Sub3_Sub2_Sub4_4 };
			Static17.method331(local277, local1150, 30, local266);
			this.method74(true, "Preparing game engine", 97);
			@Pc(1166) int local1166;
			@Pc(1168) int local1168;
			@Pc(1170) int local1170;
			for (@Pc(1162) int local1162 = 0; local1162 < 33; local1162++) {
				local1166 = 999;
				local1168 = 0;
				for (local1170 = 0; local1170 < 35; local1170++) {
					if (this.aClass1_Sub3_Sub2_Sub3_10.aByteArray6[local1170 + local1162 * this.aClass1_Sub3_Sub2_Sub3_10.anInt513] == 0) {
						if (local1166 == 999) {
							local1166 = local1170;
						}
					} else if (local1166 != 999) {
						local1168 = local1170;
						break;
					}
				}
				this.anIntArray44[local1162] = local1166;
				this.anIntArray81[local1162] = local1168 - local1166;
			}
			@Pc(1228) int local1228;
			for (local1166 = 9; local1166 < 160; local1166++) {
				local1168 = 999;
				local1170 = 0;
				for (local1228 = 10; local1228 < 168; local1228++) {
					if (this.aClass1_Sub3_Sub2_Sub3_10.aByteArray6[local1228 + local1166 * this.aClass1_Sub3_Sub2_Sub3_10.anInt513] == 0 && (local1228 > 34 || local1166 > 34)) {
						if (local1168 == 999) {
							local1168 = local1228;
						}
					} else if (local1168 != 999) {
						local1170 = local1228;
						break;
					}
				}
				this.anIntArray83[local1166 - 9] = local1168 - 21;
				this.anIntArray61[local1166 - 9] = local1170 - local1168;
			}
			Static15.method289(96, 479, 0);
			this.anIntArray30 = Static15.anIntArray139;
			Static15.method289(261, 190, 0);
			this.anIntArray31 = Static15.anIntArray139;
			Static15.method289(334, 512, 0);
			this.anIntArray32 = Static15.anIntArray139;
			@Pc(1312) int[] local1312 = new int[9];
			for (local1170 = 0; local1170 < 9; local1170++) {
				local1228 = local1170 * 32 + 128 + 15;
				@Pc(1330) int local1330 = local1228 * 3 + 600;
				@Pc(1334) int local1334 = Class1_Sub3_Sub2_Sub1.anIntArray137[local1228];
				local1312[local1170] = local1330 * local1334 >> 16;
			}
			Static25.method504(local1312, 800, 512, Static6.aByte13, 334, 500);
			Static24.method414(local310);
		} catch (@Pc(1357) Exception local1357) {
			this.aBoolean46 = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "v", descriptor = "(I)V")
	private void method143(@OriginalArg(0) int arg0) {
		try {
			if (this.anInt216 == 0) {
				this.aStringArray5[0] = "Cancel";
				this.anIntArray86[0] = 1252;
				this.anInt304 = 1;
				this.method136(super.anInt135, 27078, super.anInt136);
				this.anInt225 = 0;
				@Pc(32) int local32 = 12 / arg0;
				if (super.anInt135 > 8 && super.anInt136 > 11 && super.anInt135 < 520 && super.anInt136 < 345) {
					if (this.anInt271 == -1) {
						this.method192((byte) 2);
					} else {
						this.method90(super.anInt136, super.anInt135, 11, Static17.aClass15Array1[this.anInt271], 5082, 8, 0);
					}
				}
				if (this.anInt225 != this.anInt300) {
					this.anInt300 = this.anInt225;
				}
				this.anInt225 = 0;
				if (super.anInt135 > 562 && super.anInt136 > 231 && super.anInt135 < 752 && super.anInt136 < 492) {
					if (this.anInt330 != -1) {
						this.method90(super.anInt136, super.anInt135, 231, Static17.aClass15Array1[this.anInt330], 5082, 562, 0);
					} else if (this.anIntArray46[this.anInt166] != -1) {
						this.method90(super.anInt136, super.anInt135, 231, Static17.aClass15Array1[this.anIntArray46[this.anInt166]], 5082, 562, 0);
					}
				}
				if (this.anInt225 != this.anInt256) {
					this.aBoolean59 = true;
					this.anInt256 = this.anInt225;
				}
				this.anInt225 = 0;
				if (super.anInt135 > 22 && super.anInt136 > 375 && super.anInt135 < 431 && super.anInt136 < 471) {
					if (this.anInt280 == -1) {
						this.method92(super.anInt136 - 375, 0, super.anInt135 - 22);
					} else {
						this.method90(super.anInt136, super.anInt135, 375, Static17.aClass15Array1[this.anInt280], 5082, 22, 0);
					}
				}
				if (this.anInt280 != -1 && this.anInt225 != this.anInt221) {
					this.aBoolean60 = true;
					this.anInt221 = this.anInt225;
				}
				@Pc(223) boolean local223 = false;
				while (!local223) {
					local223 = true;
					for (@Pc(229) int local229 = 0; local229 < this.anInt304 - 1; local229++) {
						if (this.anIntArray86[local229] < 1000 && this.anIntArray86[local229 + 1] > 1000) {
							@Pc(250) String local250 = this.aStringArray5[local229];
							this.aStringArray5[local229] = this.aStringArray5[local229 + 1];
							this.aStringArray5[local229 + 1] = local250;
							@Pc(272) int local272 = this.anIntArray86[local229];
							this.anIntArray86[local229] = this.anIntArray86[local229 + 1];
							this.anIntArray86[local229 + 1] = local272;
							@Pc(294) int local294 = this.anIntArray84[local229];
							this.anIntArray84[local229] = this.anIntArray84[local229 + 1];
							this.anIntArray84[local229 + 1] = local294;
							@Pc(316) int local316 = this.anIntArray85[local229];
							this.anIntArray85[local229] = this.anIntArray85[local229 + 1];
							this.anIntArray85[local229 + 1] = local316;
							@Pc(338) int local338 = this.anIntArray87[local229];
							this.anIntArray87[local229] = this.anIntArray87[local229 + 1];
							this.anIntArray87[local229 + 1] = local338;
							local223 = false;
						}
					}
				}
			}
		} catch (@Pc(368) RuntimeException local368) {
			signlink.reporterror("87687, " + arg0 + ", " + local368.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(B)V")
	private void method144(@OriginalArg(0) byte arg0) {
		try {
			Static2.aClass35_1.method529();
			Static2.aClass35_2.method529();
			Static3.aClass35_3.method529();
			Static5.aClass35_4.method529();
			Static5.aClass35_5.method529();
			Static33.aClass35_9.method529();
			Static22.aClass35_8.method529();
			if (arg0 == this.aByte10) {
				@Pc(19) boolean local19 = false;
			} else {
				this.aBoolean72 = !this.aBoolean72;
			}
		} catch (@Pc(30) RuntimeException local30) {
			signlink.reporterror("74536, " + arg0 + ", " + local30.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "w", descriptor = "(I)V")
	private void method145(@OriginalArg(0) int arg0) {
		try {
			@Pc(7) int local7;
			if (arg0 != this.anInt165) {
				for (local7 = 1; local7 > 0; local7++) {
				}
			}
			this.method80(222);
			if (this.anInt156 == 1) {
				this.aClass1_Sub3_Sub2_Sub2Array6[this.anInt155 / 100].method322(this.anInt154 - 8 - 11, this.anInt153 - 8 - 8, false);
			}
			if (this.anInt156 == 2) {
				this.aClass1_Sub3_Sub2_Sub2Array6[this.anInt155 / 100 + 4].method322(this.anInt154 - 8 - 11, this.anInt153 - 8 - 8, false);
			}
			if (this.anInt271 != -1) {
				this.method171(this.anInt271, this.anInt270, 623);
				this.method120(0, 0, 38682, Static17.aClass15Array1[this.anInt271], 0);
			}
			this.method79(39734);
			if (!this.aBoolean50) {
				this.method143(26);
				this.method165(true);
			} else if (this.anInt337 == 0) {
				this.method135(-961);
			}
			if (this.anInt276 == 1) {
				if (this.anInt316 > 0 || this.anInt252 == 1) {
					this.aClass1_Sub3_Sub2_Sub2Array5[1].method322(258, 472, false);
				} else {
					this.aClass1_Sub3_Sub2_Sub2Array5[1].method322(296, 472, false);
				}
			}
			if (this.anInt316 > 0) {
				this.aClass1_Sub3_Sub2_Sub2Array5[0].method322(296, 472, false);
				this.aClass1_Sub3_Sub2_Sub4_2.method362(329, (byte) 6, 16776960, "Level: " + this.anInt316, 484);
			}
			if (this.anInt252 == 1) {
				this.aClass1_Sub3_Sub2_Sub2Array5[6].method322(296, 472, false);
				this.aClass1_Sub3_Sub2_Sub4_2.method362(329, (byte) 6, 16776960, "Arena", 484);
			}
			if (this.anInt267 != 0) {
				local7 = this.anInt267 / 50;
				@Pc(196) int local196 = local7 / 60;
				local7 %= 60;
				if (local7 < 10) {
					this.aClass1_Sub3_Sub2_Sub4_2.method365(4, 329, false, 16776960, "System update in: " + local196 + ":0" + local7);
				} else {
					this.aClass1_Sub3_Sub2_Sub4_2.method365(4, 329, false, 16776960, "System update in: " + local196 + ":" + local7);
				}
			}
		} catch (@Pc(242) RuntimeException local242) {
			signlink.reporterror("17204, " + arg0 + ", " + local242.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "x", descriptor = "(I)V")
	private void method146(@OriginalArg(0) int arg0) {
		try {
			@Pc(8) int local8 = this.aClass1_Sub1_Sub3_Sub2_1.anInt882 + this.anInt327;
			@Pc(15) int local15 = this.aClass1_Sub1_Sub3_Sub2_1.anInt883 + this.anInt331;
			if (this.anInt243 - local8 < -500 || this.anInt243 - local8 > 500 || this.anInt244 - local15 < -500 || this.anInt244 - local15 > 500) {
				this.anInt243 = local8;
				this.anInt244 = local15;
			}
			if (this.anInt243 != local8) {
				this.anInt243 += (local8 - this.anInt243) / 16;
			}
			if (this.anInt244 != local15) {
				this.anInt244 += (local15 - this.anInt244) / 16;
			}
			if (super.anIntArray28[1] == 1) {
				this.anInt201 += (-this.anInt201 - 24) / 2;
			} else if (super.anIntArray28[2] == 1) {
				this.anInt201 += (24 - this.anInt201) / 2;
			} else {
				this.anInt201 /= 2;
			}
			if (super.anIntArray28[3] == 1) {
				this.anInt202 += (12 - this.anInt202) / 2;
			} else if (super.anIntArray28[4] == 1) {
				this.anInt202 += (-this.anInt202 - 12) / 2;
			} else {
				this.anInt202 /= 2;
			}
			this.anInt200 = this.anInt200 + this.anInt201 / 2 & 0x7FF;
			this.anInt178 += arg0;
			this.anInt199 += this.anInt202 / 2;
			if (this.anInt199 < 128) {
				this.anInt199 = 128;
			}
			if (this.anInt199 > 383) {
				this.anInt199 = 383;
			}
			@Pc(208) int local208 = this.anInt243 >> 7;
			@Pc(213) int local213 = this.anInt244 >> 7;
			@Pc(223) int local223 = this.method94(this.anInt231, this.anInt243, (byte) 5, this.anInt244);
			@Pc(225) int local225 = 0;
			@Pc(241) int local241;
			if (local208 > 3 && local213 > 3 && local208 < 100 && local213 < 100) {
				for (local241 = local208 - 4; local241 <= local208 + 4; local241++) {
					for (@Pc(247) int local247 = local213 - 4; local247 <= local213 + 4; local247++) {
						@Pc(252) int local252 = this.anInt231;
						if (local252 < 3 && (this.aByteArrayArrayArray7[1][local241][local247] & 0x2) == 2) {
							local252++;
						}
						@Pc(279) int local279 = local223 - this.anIntArrayArrayArray3[local252][local241][local247];
						if (local279 > local225) {
							local225 = local279;
						}
					}
				}
			}
			local241 = local225 * 192;
			if (local241 > 98048) {
				local241 = 98048;
			}
			if (local241 < 32768) {
				local241 = 32768;
			}
			if (local241 > this.anInt251) {
				this.anInt251 += (local241 - this.anInt251) / 24;
			} else if (local241 < this.anInt251) {
				this.anInt251 += (local241 - this.anInt251) / 80;
			}
		} catch (@Pc(343) RuntimeException local343) {
			signlink.reporterror("53255, " + arg0 + ", " + local343.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(B)V")
	private void method147(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != -26) {
				this.anInt179 = -1;
			}
			for (@Pc(12) Class1_Sub1_Sub1 local12 = (Class1_Sub1_Sub1) this.aClass28_3.method456(); local12 != null; local12 = (Class1_Sub1_Sub1) this.aClass28_3.method458(551)) {
				if (local12.anInt24 != this.anInt231 || Static6.anInt266 > local12.anInt30) {
					local12.method567();
				} else if (Static6.anInt266 >= local12.anInt29) {
					if (local12.anInt33 > 0) {
						@Pc(42) Class1_Sub1_Sub3_Sub1 local42 = this.aClass1_Sub1_Sub3_Sub1Array1[local12.anInt33 - 1];
						if (local42 != null) {
							local12.method19(this.method94(local12.anInt24, local42.anInt882, (byte) 5, local42.anInt883) - local12.anInt28, local42.anInt883, local42.anInt882, -855, Static6.anInt266);
						}
					}
					if (local12.anInt33 < 0) {
						@Pc(73) int local73 = -local12.anInt33 - 1;
						@Pc(80) Class1_Sub1_Sub3_Sub2 local80;
						if (local73 == this.anInt152) {
							local80 = this.aClass1_Sub1_Sub3_Sub2_1;
						} else {
							local80 = this.aClass1_Sub1_Sub3_Sub2Array1[local73];
						}
						if (local80 != null) {
							local12.method19(this.method94(local12.anInt24, local80.anInt882, (byte) 5, local80.anInt883) - local12.anInt28, local80.anInt883, local80.anInt882, -855, Static6.anInt266);
						}
					}
					local12.method20((byte) -30, this.anInt270);
					this.aClass33_1.method478(-44713, (int) local12.aDouble2, 60, local12.anInt34, (int) local12.aDouble1, -1, false, null, local12, (int) local12.aDouble3, this.anInt231);
				}
			}
		} catch (@Pc(147) RuntimeException local147) {
			signlink.reporterror("67909, " + arg0 + ", " + local147.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(I)V")
	@Override
	protected void method71(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 3) {
				Static6.aBoolean48 = !Static6.aBoolean48;
			}
			this.aBoolean37 = true;
		} catch (@Pc(13) RuntimeException local13) {
			signlink.reporterror("92948, " + arg0 + ", " + local13.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!hb;I)V")
	private void method148(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class1_Sub3_Sub2_Sub2 arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(7) int local7 = this.anInt200 + this.anInt308 & 0x7FF;
			@Pc(15) int local15 = arg3 * arg3 + arg0 * arg0;
			if (arg1 != 4) {
				this.aBoolean45 = !this.aBoolean45;
			}
			if (local15 <= 6400) {
				@Pc(34) int local34 = Static10.anIntArray124[local7];
				@Pc(38) int local38 = Static10.anIntArray125[local7];
				@Pc(47) int local47 = local34 * 256 / (this.anInt249 + 256);
				@Pc(56) int local56 = local38 * 256 / (this.anInt249 + 256);
				@Pc(66) int local66 = arg0 * local47 + arg3 * local56 >> 16;
				@Pc(76) int local76 = arg0 * local56 - arg3 * local47 >> 16;
				if (local15 > 2500) {
					arg2.method329(this.aClass1_Sub3_Sub2_Sub3_10, 83 - local76 - arg2.anInt466 / 2, local66 + 94 - arg2.anInt465 / 2, (byte) -15);
				} else {
					arg2.method322(83 - local76 - arg2.anInt466 / 2, local66 + 94 - arg2.anInt465 / 2, false);
				}
			}
		} catch (@Pc(122) RuntimeException local122) {
			signlink.reporterror("70875, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local122.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIII)I")
	private int method149(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(3) int local3 = 256 - arg1;
			if (arg3 <= 0) {
				Static6.aBoolean48 = !Static6.aBoolean48;
			}
			return ((arg0 & 0xFF00FF) * local3 + (arg2 & 0xFF00FF) * arg1 & 0xFF00FF00) + ((arg0 & 0xFF00) * local3 + (arg2 & 0xFF00) * arg1 & 0xFF0000) >> 8;
		} catch (@Pc(42) RuntimeException local42) {
			signlink.reporterror("68501, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(II)Ljava/lang/String;")
	private String method150(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg1 >= 0) {
				this.anInt333 = -430;
			}
			return arg0 < 999999999 ? String.valueOf(arg0) : "*";
		} catch (@Pc(13) RuntimeException local13) {
			signlink.reporterror("83712, " + arg0 + ", " + arg1 + ", " + local13.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZLclient!x;)V")
	private void method151(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) Class1_Sub1_Sub3 arg2) {
		try {
			this.method152(arg2.anInt883, arg2.anInt882, this.anInt317, arg0);
			if (arg1) {
				this.anInt179 = -1;
			}
		} catch (@Pc(15) RuntimeException local15) {
			signlink.reporterror("52028, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local15.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IIII)V")
	private void method152(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg1 >= 128 && arg0 >= 128 && arg1 <= 13056 && arg0 <= 13056) {
				@Pc(28) int local28 = this.method94(this.anInt231, arg1, (byte) 5, arg0) - arg3;
				@Pc(33) int local33 = arg1 - this.anInt322;
				@Pc(38) int local38 = local28 - this.anInt323;
				@Pc(43) int local43 = arg0 - this.anInt324;
				@Pc(48) int local48 = Static10.anIntArray124[this.anInt325];
				@Pc(53) int local53 = Static10.anIntArray125[this.anInt325];
				@Pc(58) int local58 = Static10.anIntArray124[this.anInt326];
				@Pc(63) int local63 = Static10.anIntArray125[this.anInt326];
				@Pc(73) int local73 = local43 * local58 + local33 * local63 >> 16;
				@Pc(83) int local83 = local43 * local63 - local33 * local58 >> 16;
				if (arg2 >= 0) {
					this.aClass1_Sub3_Sub3_6.method381(131);
				}
				local33 = local73;
				local73 = local38 * local53 - local83 * local48 >> 16;
				local43 = local38 * local48 + local83 * local53 >> 16;
				if (local43 >= 50) {
					this.anInt287 = Static15.anInt430 + (local33 << 9) / local43;
					this.anInt288 = Static15.anInt431 + (local73 << 9) / local43;
				} else {
					this.anInt287 = -1;
					this.anInt288 = -1;
				}
			} else {
				this.anInt287 = -1;
				this.anInt288 = -1;
			}
		} catch (@Pc(143) RuntimeException local143) {
			signlink.reporterror("27324, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local143.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIZ)Z")
	private boolean method153(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4) {
		try {
			@Pc(7) int local7 = arg3 >> 14 & 0x7FFF;
			@Pc(16) int local16 = this.aClass33_1.method498(this.anInt231, arg1, arg2, arg3);
			if (local16 == -1) {
				return false;
			}
			@Pc(25) int local25 = local16 & 0x1F;
			@Pc(31) int local31 = local16 >> 6 & 0x3;
			if (local25 == 10 || local25 == 11 || local25 == 22) {
				@Pc(43) Class2 local43 = Static2.method23(local7);
				@Pc(51) int local51;
				@Pc(54) int local54;
				if (local31 == 0 || local31 == 2) {
					local51 = local43.anInt43;
					local54 = local43.anInt44;
				} else {
					local51 = local43.anInt44;
					local54 = local43.anInt43;
				}
				@Pc(65) int local65 = local43.anInt55;
				if (local31 != 0) {
					local65 = (local65 << local31 & 0xF) + (local65 >> 4 - local31);
				}
				this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], local51, false, arg1, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, local54, arg2, 0, 0, local65);
			} else {
				this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 0, false, arg1, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 2, 0, arg2, local31, local25 + 1, 0);
			}
			this.anInt153 = super.anInt138;
			this.anInt154 = super.anInt139;
			this.anInt156 = 2;
			this.anInt155 = 0;
			this.aClass1_Sub3_Sub3_6.method380((byte) -34, arg0);
			this.aClass1_Sub3_Sub3_6.method382(arg1 + this.anInt169);
			this.aClass1_Sub3_Sub3_6.method382(arg2 + this.anInt170);
			this.aClass1_Sub3_Sub3_6.method382(local7);
			if (!arg4) {
				throw new NullPointerException();
			}
			return true;
		} catch (@Pc(175) RuntimeException local175) {
			signlink.reporterror("35563, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local175.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "y", descriptor = "(I)V")
	private void method154(@OriginalArg(0) int arg0) {
		try {
			@Pc(7) int local7 = this.aClass1_Sub3_Sub2_Sub4_3.method364(false, "Choose Option");
			@Pc(20) int local20;
			for (@Pc(9) int local9 = 0; local9 < this.anInt304; local9++) {
				local20 = this.aClass1_Sub3_Sub2_Sub4_3.method364(false, this.aStringArray5[local9]);
				if (local20 > local7) {
					local7 = local20;
				}
			}
			local7 += 8;
			local20 = this.anInt304 * 15 + 21;
			if (arg0 < 0) {
				@Pc(66) int local66;
				@Pc(84) int local84;
				if (super.anInt138 > 8 && super.anInt139 > 11 && super.anInt138 < 520 && super.anInt139 < 345) {
					local66 = super.anInt138 - local7 / 2 - 8;
					if (local66 + local7 > 512) {
						local66 = 512 - local7;
					}
					if (local66 < 0) {
						local66 = 0;
					}
					local84 = super.anInt139 - 11;
					if (local84 + local20 > 334) {
						local84 = 334 - local20;
					}
					if (local84 < 0) {
						local84 = 0;
					}
					this.aBoolean50 = true;
					this.anInt337 = 0;
					this.anInt338 = local66;
					this.anInt339 = local84;
					this.anInt340 = local7;
					this.anInt341 = this.anInt304 * 15 + 22;
				}
				if (super.anInt138 > 562 && super.anInt139 > 231 && super.anInt138 < 752 && super.anInt139 < 492) {
					local66 = super.anInt138 - local7 / 2 - 562;
					if (local66 < 0) {
						local66 = 0;
					} else if (local66 + local7 > 190) {
						local66 = 190 - local7;
					}
					local84 = super.anInt139 - 231;
					if (local84 < 0) {
						local84 = 0;
					} else if (local84 + local20 > 261) {
						local84 = 261 - local20;
					}
					this.aBoolean50 = true;
					this.anInt337 = 1;
					this.anInt338 = local66;
					this.anInt339 = local84;
					this.anInt340 = local7;
					this.anInt341 = this.anInt304 * 15 + 22;
				}
				if (super.anInt138 > 22 && super.anInt139 > 375 && super.anInt138 < 501 && super.anInt139 < 471) {
					local66 = super.anInt138 - local7 / 2 - 22;
					if (local66 < 0) {
						local66 = 0;
					} else if (local66 + local7 > 479) {
						local66 = 479 - local7;
					}
					local84 = super.anInt139 - 375;
					if (local84 < 0) {
						local84 = 0;
					} else if (local84 + local20 > 96) {
						local84 = 96 - local20;
					}
					this.aBoolean50 = true;
					this.anInt337 = 2;
					this.anInt338 = local66;
					this.anInt339 = local84;
					this.anInt340 = local7;
					this.anInt341 = this.anInt304 * 15 + 22;
				}
			}
		} catch (@Pc(288) RuntimeException local288) {
			signlink.reporterror("57560, " + arg0 + ", " + local288.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;)Ljava/io/DataInputStream;")
	private DataInputStream method155(@OriginalArg(0) String arg0) throws IOException {
		return signlink.mainapp == null ? new DataInputStream((new URL(this.getCodeBase(), arg0)).openStream()) : signlink.openurl(arg0);
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(B)V")
	private void method156(@OriginalArg(0) byte arg0) {
		try {
			if (this.aClass32_16 == null) {
				super.aClass32_2 = null;
				this.aClass32_28 = null;
				this.aClass32_26 = null;
				this.aClass32_25 = null;
				this.aClass32_27 = null;
				this.aClass32_3 = null;
				this.aClass32_4 = null;
				this.aClass32_5 = null;
				this.aClass32_19 = new Class32(this.method72(Static6.aByte16), 128, 299, 265);
				Static12.method357(this.anInt336);
				this.aClass32_20 = new Class32(this.method72(Static6.aByte16), 128, 299, 265);
				Static12.method357(this.anInt336);
				this.aClass32_16 = new Class32(this.method72(Static6.aByte16), 533, 299, 186);
				Static12.method357(this.anInt336);
				this.aClass32_17 = new Class32(this.method72(Static6.aByte16), 360, 299, 146);
				Static12.method357(this.anInt336);
				this.aClass32_18 = new Class32(this.method72(Static6.aByte16), 360, 299, 200);
				Static12.method357(this.anInt336);
				this.aClass32_21 = new Class32(this.method72(Static6.aByte16), 214, 299, 267);
				Static12.method357(this.anInt336);
				this.aClass32_22 = new Class32(this.method72(Static6.aByte16), 215, 299, 267);
				Static12.method357(this.anInt336);
				this.aClass32_23 = new Class32(this.method72(Static6.aByte16), 86, 299, 79);
				if (arg0 != this.aByte12) {
					this.aClass1_Sub3_Sub3_6.method381(73);
				}
				Static12.method357(this.anInt336);
				this.aClass32_24 = new Class32(this.method72(Static6.aByte16), 87, 299, 79);
				Static12.method357(this.anInt336);
				if (this.aClass39_1 != null) {
					this.method189((byte) 5);
					this.method109(0);
				}
				this.aBoolean37 = true;
			}
		} catch (@Pc(175) RuntimeException local175) {
			signlink.reporterror("86250, " + arg0 + ", " + local175.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "z", descriptor = "(I)V")
	private void method157(@OriginalArg(0) int arg0) {
		try {
			this.aBoolean70 = true;
			try {
				@Pc(4) long local4 = System.currentTimeMillis();
				@Pc(6) int local6 = 0;
				@Pc(8) int local8 = 20;
				while (this.aBoolean54) {
					this.method103(true);
					this.method103(true);
					this.method89(true);
					local6++;
					if (local6 > 10) {
						@Pc(25) long local25 = System.currentTimeMillis();
						@Pc(34) int local34 = (int) (local25 - local4) / 10 - local8;
						local8 = 40 - local34;
						if (local8 < 5) {
							local8 = 5;
						}
						local6 = 0;
						local4 = local25;
					}
					try {
						Thread.sleep((long) local8);
					} catch (@Pc(52) Exception local52) {
					}
				}
			} catch (@Pc(58) Exception local58) {
			}
			this.aBoolean70 = false;
			if (arg0 != -33833) {
				Static6.aBoolean48 = !Static6.aBoolean48;
			}
		} catch (@Pc(72) RuntimeException local72) {
			signlink.reporterror("93519, " + arg0 + ", " + local72.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "run", descriptor = "()V")
	@Override
	public void run() {
		if (this.aBoolean63) {
			this.method157(-33833);
		} else if (this.aBoolean40) {
			this.method87(true);
		} else {
			super.run();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIZIILclient!hc;)V")
	private void method158(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) Class15 arg8) {
		try {
			if (this.aBoolean71) {
				this.anInt342 = 32;
			} else {
				this.anInt342 = 0;
			}
			this.aBoolean71 = false;
			this.anInt178 += arg1;
			if (arg0 >= arg6 && arg0 < arg6 + 16 && arg2 >= arg7 && arg2 < arg7 + 16) {
				arg8.anInt481 -= this.anInt253 * 4;
				if (arg5) {
					this.aBoolean59 = true;
					return;
				}
			} else if (arg0 >= arg6 && arg0 < arg6 + 16 && arg2 >= arg7 + arg4 - 16 && arg2 < arg7 + arg4) {
				arg8.anInt481 += this.anInt253 * 4;
				if (arg5) {
					this.aBoolean59 = true;
					return;
				}
			} else if (arg0 >= arg6 - this.anInt342 && arg0 < arg6 + this.anInt342 + 16 && arg2 >= arg7 + 16 && arg2 < arg7 + arg4 - 16 && this.anInt253 > 0) {
				@Pc(122) int local122 = (arg4 - 32) * arg4 / arg3;
				if (local122 < 8) {
					local122 = 8;
				}
				@Pc(137) int local137 = arg2 - arg7 - local122 / 2 - 16;
				@Pc(143) int local143 = arg4 - local122 - 32;
				arg8.anInt481 = (arg3 - arg4) * local137 / local143;
				if (arg5) {
					this.aBoolean59 = true;
				}
				this.aBoolean71 = true;
			} else {
				return;
			}
		} catch (@Pc(162) RuntimeException local162) {
			signlink.reporterror("76637, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + local162.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;Z)V")
	private void method159(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(2) boolean arg2) {
		signlink.errorname = arg0;
		try {
			if (!arg2) {
				this.aString15 = "";
				this.aString16 = "Connecting to server...";
				this.method116(4);
			}
			this.aClass6_1 = new Class6(this, (byte) 2, this.method162(Static6.anInt236 + 43594));
			this.aClass6_1.method204(this.aClass1_Sub3_Sub3_5.aByteArray7, 0, 8);
			this.aClass1_Sub3_Sub3_5.anInt561 = 0;
			this.aLong9 = this.aClass1_Sub3_Sub3_5.method397(603);
			@Pc(47) int[] local47 = new int[] { (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (this.aLong9 >> 32), (int) this.aLong9 };
			this.aClass1_Sub3_Sub3_6.anInt561 = 0;
			this.aClass1_Sub3_Sub3_6.method381(10);
			this.aClass1_Sub3_Sub3_6.method385(local47[0]);
			this.aClass1_Sub3_Sub3_6.method385(local47[1]);
			this.aClass1_Sub3_Sub3_6.method385(local47[2]);
			this.aClass1_Sub3_Sub3_6.method385(local47[3]);
			this.aClass1_Sub3_Sub3_6.method385(signlink.uid);
			this.aClass1_Sub3_Sub3_6.method388(arg0);
			this.aClass1_Sub3_Sub3_6.method388(arg1);
			this.aClass1_Sub3_Sub3_6.method406(Static6.aBigInteger2, Static6.aBigInteger1, this.anInt151);
			this.aClass1_Sub3_Sub3_4.anInt561 = 0;
			if (arg2) {
				this.aClass1_Sub3_Sub3_4.method381(18);
			} else {
				this.aClass1_Sub3_Sub3_4.method381(16);
			}
			this.aClass1_Sub3_Sub3_4.method381(this.aClass1_Sub3_Sub3_6.anInt561 + 36 + 1 + 1);
			this.aClass1_Sub3_Sub3_4.method381(225);
			this.aClass1_Sub3_Sub3_4.method381(Static6.aBoolean53 ? 1 : 0);
			for (@Pc(168) int local168 = 0; local168 < 9; local168++) {
				this.aClass1_Sub3_Sub3_4.method385(this.anIntArray38[local168]);
			}
			this.aClass1_Sub3_Sub3_4.method389(this.aClass1_Sub3_Sub3_6.aByteArray7, this.aClass1_Sub3_Sub3_6.anInt561, 0, (byte) -106);
			this.aClass1_Sub3_Sub3_6.aClass38_2 = new Class38((byte) 1, local47);
			for (@Pc(202) int local202 = 0; local202 < 4; local202++) {
				local47[local202] += 50;
			}
			this.aClass38_1 = new Class38((byte) 1, local47);
			this.aClass6_1.method205(this.aClass1_Sub3_Sub3_4.aByteArray7, this.aClass1_Sub3_Sub3_4.anInt561, true, 0);
			@Pc(237) int local237 = this.aClass6_1.method202();
			if (local237 == 1) {
				try {
					Thread.sleep(2000L);
				} catch (@Pc(244) Exception local244) {
				}
				this.method159(arg0, arg1, arg2);
				return;
			}
			if (local237 == 2 || local237 == 18) {
				if (local237 == 18) {
					this.aBoolean65 = true;
				} else {
					this.aBoolean65 = false;
				}
				Static9.method209((byte) 65);
				this.aBoolean62 = true;
				this.aClass1_Sub3_Sub3_6.anInt561 = 0;
				this.aClass1_Sub3_Sub3_5.anInt561 = 0;
				this.anInt179 = -1;
				this.anInt207 = -1;
				this.anInt208 = -1;
				this.anInt209 = -1;
				this.anInt178 = 0;
				this.anInt180 = 0;
				this.anInt267 = 0;
				this.anInt182 = 0;
				this.anInt241 = 0;
				this.anInt304 = 0;
				this.aBoolean50 = false;
				super.anInt133 = 0;
				for (@Pc(318) int local318 = 0; local318 < 100; local318++) {
					this.aStringArray7[local318] = null;
				}
				this.anInt281 = 0;
				this.anInt291 = 0;
				this.anInt307 = 0;
				this.anInt286 = 0;
				this.anInt327 = (int) (Math.random() * 100.0D) - 50;
				this.anInt331 = (int) (Math.random() * 110.0D) - 55;
				this.anInt334 = (int) (Math.random() * 80.0D) - 40;
				this.anInt308 = (int) (Math.random() * 120.0D) - 60;
				this.anInt249 = (int) (Math.random() * 30.0D) - 20;
				this.anInt200 = (int) (Math.random() * 20.0D) - 10 & 0x7FF;
				this.anInt176 = -1;
				this.anInt296 = 0;
				this.anInt297 = 0;
				this.anInt205 = 0;
				this.anInt248 = 0;
				for (@Pc(408) int local408 = 0; local408 < this.anInt203; local408++) {
					this.aClass1_Sub1_Sub3_Sub2Array1[local408] = null;
					this.aClass1_Sub3_Sub3Array1[local408] = null;
				}
				for (@Pc(427) int local427 = 0; local427 < 8192; local427++) {
					this.aClass1_Sub1_Sub3_Sub1Array1[local427] = null;
				}
				this.aClass1_Sub1_Sub3_Sub2_1 = this.aClass1_Sub1_Sub3_Sub2Array1[this.anInt204] = new Class1_Sub1_Sub3_Sub2();
				this.aClass28_3.method460();
				this.aClass28_5.method460();
				this.aClass28_2.method460();
				@Pc(464) int local464;
				for (@Pc(460) int local460 = 0; local460 < 4; local460++) {
					for (local464 = 0; local464 < 104; local464++) {
						for (@Pc(468) int local468 = 0; local468 < 104; local468++) {
							this.aClass28ArrayArrayArray1[local460][local464][local468] = null;
						}
					}
				}
				this.aClass28_4 = new Class28(0);
				this.anInt312 = 0;
				this.anInt289 = -1;
				this.anInt280 = -1;
				this.anInt271 = -1;
				this.anInt330 = -1;
				this.aBoolean49 = false;
				this.anInt166 = 3;
				this.aBoolean66 = false;
				this.aBoolean50 = false;
				this.aBoolean47 = false;
				this.aString8 = null;
				this.anInt276 = 0;
				this.anInt329 = -1;
				this.aBoolean43 = true;
				this.method112((byte) -6);
				for (local464 = 0; local464 < 5; local464++) {
					this.anIntArray33[local464] = 0;
				}
				Static6.anInt175 = 0;
				Static6.anInt224 = 0;
				Static6.anInt195 = 0;
				Static6.anInt188 = 0;
				Static6.anInt143 = 0;
				Static6.anInt220 = 0;
				Static6.anInt254 = 0;
				Static6.anInt237 = 0;
				Static6.anInt229 = 0;
				this.method117(-7185);
				return;
			}
			if (local237 == 3) {
				this.aString15 = "";
				this.aString16 = "Invalid username or password.";
				return;
			}
			if (local237 == 4) {
				this.aString15 = "Your account has been disabled.";
				this.aString16 = "Please check your message-centre for details.";
				return;
			}
			if (local237 == 5) {
				this.aString15 = "Your account is already logged in.";
				this.aString16 = "Try again in 60 secs...";
				return;
			}
			if (local237 == 6) {
				this.aString15 = "RuneScape has been updated!";
				this.aString16 = "Please reload this page.";
				return;
			}
			if (local237 == 7) {
				this.aString15 = "This world is full.";
				this.aString16 = "Please use a different world.";
				return;
			}
			if (local237 == 8) {
				this.aString15 = "Unable to connect.";
				this.aString16 = "Login server offline.";
				return;
			}
			if (local237 == 9) {
				this.aString15 = "Login limit exceeded.";
				this.aString16 = "Too many connections from your address.";
				return;
			}
			if (local237 == 10) {
				this.aString15 = "Unable to connect.";
				this.aString16 = "Bad session id.";
				return;
			}
			if (local237 == 11) {
				this.aString16 = "Login server rejected session.";
				this.aString16 = "Please try again.";
				return;
			}
			if (local237 == 12) {
				this.aString15 = "You need a members account to login to this world.";
				this.aString16 = "Please subscribe, or use a different world.";
				return;
			}
			if (local237 == 13) {
				this.aString15 = "Could not complete login.";
				this.aString16 = "Please try using a different world.";
				return;
			}
			if (local237 == 14) {
				this.aString15 = "The server is being updated.";
				this.aString16 = "Please wait 1 minute and try again.";
				return;
			}
			if (local237 == 15) {
				this.aBoolean62 = true;
				this.aClass1_Sub3_Sub3_6.anInt561 = 0;
				this.aClass1_Sub3_Sub3_5.anInt561 = 0;
				this.anInt179 = -1;
				this.anInt207 = -1;
				this.anInt208 = -1;
				this.anInt209 = -1;
				this.anInt178 = 0;
				this.anInt180 = 0;
				this.anInt267 = 0;
				this.anInt304 = 0;
				this.aBoolean50 = false;
				return;
			}
			if (local237 == 16) {
				this.aString15 = "Login attempts exceeded.";
				this.aString16 = "Please wait 1 minute and try again.";
				return;
			}
			if (local237 == 17) {
				this.aString15 = "You are standing in a members-only area.";
				this.aString16 = "To play on this world move to a free area first";
				return;
			}
		} catch (@Pc(762) IOException local762) {
			this.aString15 = "";
			this.aString16 = "Error connecting to server.";
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIIII)V")
	private void method160(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		try {
			if (arg6 != -27819) {
				this.method67();
			}
			if (arg1 >= 1 && arg2 >= 1 && arg1 <= 102 && arg2 <= 102) {
				if (Static6.aBoolean53 && arg7 != this.anInt231) {
					return;
				}
				@Pc(25) int local25 = 0;
				@Pc(27) boolean local27 = true;
				@Pc(29) boolean local29 = false;
				@Pc(31) boolean local31 = false;
				if (arg3 == 0) {
					local25 = this.aClass33_1.method494(arg7, arg1, arg2);
				}
				if (arg3 == 1) {
					local25 = this.aClass33_1.method495(arg7, arg2, 3, arg1);
				}
				if (arg3 == 2) {
					local25 = this.aClass33_1.method496(arg7, arg1, arg2);
				}
				if (arg3 == 3) {
					local25 = this.aClass33_1.method497(arg7, arg1, arg2);
				}
				@Pc(81) int local81;
				if (local25 != 0) {
					local81 = this.aClass33_1.method498(arg7, arg1, arg2, local25);
					@Pc(87) int local87 = local25 >> 14 & 0x7FFF;
					@Pc(91) int local91 = local81 & 0x1F;
					@Pc(95) int local95 = local81 >> 6;
					@Pc(107) Class2 local107;
					if (arg3 == 0) {
						this.aClass33_1.method489(arg1, arg7, arg2, 1);
						local107 = Static2.method23(local87);
						if (local107.aBoolean7) {
							this.aClass9Array1[arg7].method254(local107.aBoolean8, local95, arg1, arg2, 323, local91);
						}
					}
					if (arg3 == 1) {
						this.aClass33_1.method490(arg7, arg2, this.anInt306, arg1);
					}
					if (arg3 == 2) {
						this.aClass33_1.method491(arg1, arg2, -54, arg7);
						local107 = Static2.method23(local87);
						if (arg1 + local107.anInt43 > 103 || arg2 + local107.anInt43 > 103 || arg1 + local107.anInt44 > 103 || arg2 + local107.anInt44 > 103) {
							return;
						}
						if (local107.aBoolean7) {
							this.aClass9Array1[arg7].method255(arg2, arg1, local95, local107.anInt43, true, local107.aBoolean8, local107.anInt44);
						}
					}
					if (arg3 == 3) {
						this.aClass33_1.method492(arg7, this.anInt290, arg1, arg2);
						local107 = Static2.method23(local87);
						if (local107.aBoolean7 && local107.aBoolean9) {
							this.aClass9Array1[arg7].method257(arg2, arg1, 0);
						}
					}
				}
				if (arg4 >= 0) {
					local81 = arg7;
					if (arg7 < 3 && (this.aByteArrayArrayArray7[1][arg1][arg2] & 0x2) == 2) {
						local81 = arg7 + 1;
					}
					Static4.method50(arg1, this.aClass28_1, this.aClass9Array1[arg7], arg2, arg0, this.anIntArrayArrayArray3, 0, arg7, arg4, arg5, this.aClass33_1, local81);
					return;
				}
			}
		} catch (@Pc(258) RuntimeException local258) {
			signlink.reporterror("53981, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + local258.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(JI)V")
	private void method161(@OriginalArg(0) long arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 != 0L) {
				if (this.anInt312 >= 100) {
					this.method172(0, "Your friends list is full. Max of 100 hit", (byte) 4, "");
				} else {
					@Pc(23) String local23 = Static30.method542(0, Static30.method539(arg0, false));
					for (@Pc(25) int local25 = 0; local25 < this.anInt312; local25++) {
						if (this.aLongArray4[local25] == arg0) {
							this.method172(0, local23 + " is already on your friend list", (byte) 4, "");
							return;
						}
					}
					for (@Pc(55) int local55 = 0; local55 < this.anInt186; local55++) {
						if (this.aLongArray3[local55] == arg0) {
							this.method172(0, "Please remove " + local23 + " from your ignore list first", (byte) 4, "");
							return;
						}
					}
					if (!local23.equals(this.aClass1_Sub1_Sub3_Sub2_1.aString29)) {
						this.aStringArray9[this.anInt312] = local23;
						this.aLongArray4[this.anInt312] = arg0;
						this.anIntArray34[this.anInt312] = 0;
						this.anInt312++;
						if (arg1 >= 0) {
							this.anInt294 = this.aClass38_1.method532();
						}
						this.aBoolean59 = true;
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 118);
						this.aClass1_Sub3_Sub3_6.method387(true, arg0);
					}
				}
			}
		} catch (@Pc(137) RuntimeException local137) {
			signlink.reporterror("3645, " + arg0 + ", " + arg1 + ", " + local137.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(B)V")
	@Override
	protected void method69(@OriginalArg(0) byte arg0) {
		try {
			signlink.reporterror = false;
			try {
				if (this.aClass6_1 != null) {
					this.aClass6_1.method201();
				}
			} catch (@Pc(11) Exception local11) {
			}
			this.aClass6_1 = null;
			this.method78(0);
			this.aBoolean41 = false;
			this.aClass1_Sub3_Sub3_6 = null;
			this.aClass1_Sub3_Sub3_4 = null;
			this.aClass1_Sub3_Sub3_5 = null;
			this.anIntArray56 = null;
			this.aByteArrayArray1 = null;
			this.aByteArrayArray2 = null;
			this.anIntArrayArrayArray3 = null;
			this.aByteArrayArrayArray7 = null;
			this.aClass33_1 = null;
			this.aClass9Array1 = null;
			this.anIntArrayArray5 = null;
			this.anIntArrayArray2 = null;
			this.anIntArray66 = null;
			this.anIntArray67 = null;
			this.aByteArray4 = null;
			this.aClass32_25 = null;
			this.aClass32_26 = null;
			this.aClass32_27 = null;
			this.aClass32_28 = null;
			this.aClass32_3 = null;
			this.aClass32_4 = null;
			this.aClass32_5 = null;
			this.aClass32_6 = null;
			this.aClass32_7 = null;
			this.aClass32_8 = null;
			this.aClass32_9 = null;
			this.aClass32_10 = null;
			this.aClass32_11 = null;
			this.aClass32_12 = null;
			this.aClass32_13 = null;
			this.aClass32_14 = null;
			this.aClass32_15 = null;
			this.aClass1_Sub3_Sub2_Sub3_9 = null;
			this.aClass1_Sub3_Sub2_Sub3_10 = null;
			this.aClass1_Sub3_Sub2_Sub3_11 = null;
			this.aClass1_Sub3_Sub2_Sub3_6 = null;
			this.aClass1_Sub3_Sub2_Sub3_7 = null;
			this.aClass1_Sub3_Sub2_Sub3_8 = null;
			this.aClass1_Sub3_Sub2_Sub3Array1 = null;
			this.aClass1_Sub3_Sub2_Sub3_1 = null;
			this.aClass1_Sub3_Sub2_Sub3_2 = null;
			this.aClass1_Sub3_Sub2_Sub3_3 = null;
			this.aClass1_Sub3_Sub2_Sub3_4 = null;
			this.aClass1_Sub3_Sub2_Sub3_5 = null;
			this.aClass1_Sub3_Sub2_Sub3_12 = null;
			this.aClass1_Sub3_Sub2_Sub3_13 = null;
			this.aClass1_Sub3_Sub2_Sub3_14 = null;
			this.aClass1_Sub3_Sub2_Sub3_15 = null;
			this.aClass1_Sub3_Sub2_Sub3_16 = null;
			this.aClass1_Sub3_Sub2_Sub2_11 = null;
			this.aClass1_Sub3_Sub2_Sub2Array3 = null;
			this.aClass1_Sub3_Sub2_Sub2Array5 = null;
			this.aClass1_Sub3_Sub2_Sub2Array6 = null;
			this.aClass1_Sub3_Sub2_Sub2_7 = null;
			this.aClass1_Sub3_Sub2_Sub2_8 = null;
			this.aClass1_Sub3_Sub2_Sub2_9 = null;
			this.aClass1_Sub3_Sub2_Sub2_10 = null;
			this.aClass1_Sub3_Sub2_Sub3Array3 = null;
			if (arg0 != -28) {
				this.method67();
			}
			this.aClass1_Sub3_Sub2_Sub2Array7 = null;
			this.anIntArrayArray3 = null;
			this.aClass1_Sub1_Sub3_Sub2Array1 = null;
			this.anIntArray39 = null;
			this.anIntArray40 = null;
			this.aClass1_Sub3_Sub3Array1 = null;
			this.anIntArray60 = null;
			this.aClass1_Sub1_Sub3_Sub1Array1 = null;
			this.anIntArray58 = null;
			this.aClass28ArrayArrayArray1 = null;
			this.aClass28_4 = null;
			this.aClass28_2 = null;
			this.aClass28_3 = null;
			this.aClass28_5 = null;
			this.aClass28_1 = null;
			this.anIntArray84 = null;
			this.anIntArray85 = null;
			this.anIntArray86 = null;
			this.anIntArray87 = null;
			this.aStringArray5 = null;
			this.anIntArray59 = null;
			this.anIntArray54 = null;
			this.anIntArray55 = null;
			this.aClass1_Sub3_Sub2_Sub2Array4 = null;
			this.aClass1_Sub3_Sub2_Sub2_6 = null;
			this.aStringArray9 = null;
			this.aLongArray4 = null;
			this.anIntArray34 = null;
			this.aClass32_19 = null;
			this.aClass32_20 = null;
			this.aClass32_16 = null;
			this.aClass32_17 = null;
			this.aClass32_18 = null;
			this.aClass32_21 = null;
			this.aClass32_22 = null;
			this.aClass32_23 = null;
			this.aClass32_24 = null;
			this.method99(true);
			Static2.method22(true);
			Static3.method31(true);
			Static5.method53(true);
			Static13.aClass11Array1 = null;
			Static16.aClass13Array1 = null;
			Static17.aClass15Array1 = null;
			Static19.aClass17Array1 = null;
			Static20.aClass19Array1 = null;
			Static22.aClass21Array1 = null;
			Static22.aClass35_8 = null;
			Static23.aClass23Array1 = null;
			super.aClass32_2 = null;
			Static33.aClass35_9 = null;
			Static15.method287(true);
			Static25.method466(true);
			Static10.method224(true);
			Static11.aClass10Array1 = null;
			Static14.aClass12Array1 = null;
			System.gc();
		} catch (@Pc(361) RuntimeException local361) {
			signlink.reporterror("6631, " + arg0 + ", " + local361.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "A", descriptor = "(I)Ljava/net/Socket;")
	private Socket method162(@OriginalArg(0) int arg0) throws IOException {
		return signlink.mainapp == null ? new Socket(InetAddress.getByName(this.getCodeBase().getHost()), arg0) : signlink.opensocket(arg0);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!z;I)V")
	private void method163(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class1_Sub1_Sub3_Sub2 arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg0) {
				this.anInt290 = this.aClass38_1.method532();
			}
			if (arg3 != this.aClass1_Sub1_Sub3_Sub2_1 && this.anInt304 < 400) {
				@Pc(41) String local41 = arg3.aString29 + Static6.method133(this.aClass1_Sub1_Sub3_Sub2_1.anInt932, false, arg3.anInt932) + " (level-" + arg3.anInt932 + ")";
				if (this.anInt281 == 1) {
					this.aStringArray5[this.anInt304] = "Use " + this.aString10 + " with @whi@" + local41;
					this.anIntArray86[this.anInt304] = 367;
					this.anIntArray87[this.anInt304] = arg2;
					this.anIntArray84[this.anInt304] = arg4;
					this.anIntArray85[this.anInt304] = arg1;
					this.anInt304++;
				} else if (this.anInt291 != 1) {
					this.aStringArray5[this.anInt304] = "Follow @whi@" + local41;
					this.anIntArray86[this.anInt304] = 1544;
					this.anIntArray87[this.anInt304] = arg2;
					this.anIntArray84[this.anInt304] = arg4;
					this.anIntArray85[this.anInt304] = arg1;
					this.anInt304++;
					if (this.anInt191 == 0) {
						this.aStringArray5[this.anInt304] = "Trade with @whi@" + local41;
						this.anIntArray86[this.anInt304] = 1373;
						this.anIntArray87[this.anInt304] = arg2;
						this.anIntArray84[this.anInt304] = arg4;
						this.anIntArray85[this.anInt304] = arg1;
						this.anInt304++;
					}
					if (this.anInt316 > 0) {
						this.aStringArray5[this.anInt304] = "Attack @whi@" + local41;
						if (this.aClass1_Sub1_Sub3_Sub2_1.anInt932 >= arg3.anInt932) {
							this.anIntArray86[this.anInt304] = 151;
						} else {
							this.anIntArray86[this.anInt304] = 2151;
						}
						this.anIntArray87[this.anInt304] = arg2;
						this.anIntArray84[this.anInt304] = arg4;
						this.anIntArray85[this.anInt304] = arg1;
						this.anInt304++;
					}
					if (this.anInt252 == 1) {
						this.aStringArray5[this.anInt304] = "Fight @whi@" + local41;
						this.anIntArray86[this.anInt304] = 151;
						this.anIntArray87[this.anInt304] = arg2;
						this.anIntArray84[this.anInt304] = arg4;
						this.anIntArray85[this.anInt304] = arg1;
						this.anInt304++;
					}
					if (this.anInt252 == 2) {
						this.aStringArray5[this.anInt304] = "Duel-with @whi@" + local41;
						this.anIntArray86[this.anInt304] = 1101;
						this.anIntArray87[this.anInt304] = arg2;
						this.anIntArray84[this.anInt304] = arg4;
						this.anIntArray85[this.anInt304] = arg1;
						this.anInt304++;
					}
				} else if ((this.anInt293 & 0x8) == 8) {
					this.aStringArray5[this.anInt304] = this.aString11 + " @whi@" + local41;
					this.anIntArray86[this.anInt304] = 651;
					this.anIntArray87[this.anInt304] = arg2;
					this.anIntArray84[this.anInt304] = arg4;
					this.anIntArray85[this.anInt304] = arg1;
					this.anInt304++;
				}
				for (@Pc(392) int local392 = 0; local392 < this.anInt304; local392++) {
					if (this.anIntArray86[local392] == 660) {
						this.aStringArray5[local392] = "Walk here @whi@" + local41;
						return;
					}
				}
			}
		} catch (@Pc(419) RuntimeException local419) {
			signlink.reporterror("4679, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local419.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(Z)V")
	private void method164(@OriginalArg(0) boolean arg0) {
		try {
			if (this.anInt267 > 1) {
				this.anInt267--;
			}
			if (this.anInt182 > 0) {
				this.anInt182--;
			}
			for (@Pc(22) int local22 = 0; local22 < 5 && this.method197(false); local22++) {
			}
			if (!arg0) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			if (this.aBoolean62) {
				@Pc(155) int local155;
				@Pc(207) int local207;
				for (@Pc(46) int local46 = 0; local46 < this.anInt286; local46++) {
					if (this.anIntArray45[local46] <= 0) {
						@Pc(55) boolean local55 = false;
						try {
							if (this.anIntArray82[local46] != this.anInt184 || this.anIntArray37[local46] != this.anInt301) {
								@Pc(89) Class1_Sub3_Sub3 local89 = Static32.method562((byte) -16, this.anIntArray37[local46], this.anIntArray82[local46]);
								if (System.currentTimeMillis() + (long) (local89.anInt561 / 22) > this.aLong7 + (long) (this.anInt198 / 22)) {
									this.anInt198 = local89.anInt561;
									this.aLong7 = System.currentTimeMillis();
									if (this.method138(local89.aByteArray7, local89.anInt561, 0)) {
										this.anInt184 = this.anIntArray82[local46];
										this.anInt301 = this.anIntArray37[local46];
									} else {
										local55 = true;
									}
								}
							} else if (!this.method139(this.anInt177)) {
								local55 = true;
							}
						} catch (@Pc(139) Exception local139) {
						}
						if (local55 && this.anIntArray45[local46] != -5) {
							this.anIntArray45[local46] = -5;
						} else {
							this.anInt286--;
							for (local155 = local46; local155 < this.anInt286; local155++) {
								this.anIntArray82[local155] = this.anIntArray82[local155 + 1];
								this.anIntArray37[local155] = this.anIntArray37[local155 + 1];
								this.anIntArray45[local155] = this.anIntArray45[local155 + 1];
							}
							local46--;
						}
					} else {
						local207 = this.anIntArray45[local46]--;
					}
				}
				if (this.anInt157 > 0) {
					this.anInt157 -= 20;
					if (this.anInt157 < 0) {
						this.anInt157 = 0;
					}
					if (this.anInt157 == 0 && this.aBoolean42 && !Static6.aBoolean53) {
						this.method75(false, this.anInt321, this.aString17, this.anInt343);
					}
				}
				@Pc(250) Class1_Sub3_Sub3 local250 = Static9.method210(-809);
				if (local250 != null) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 81);
					this.aClass1_Sub3_Sub3_6.method382(local250.anInt561);
					this.aClass1_Sub3_Sub3_6.method389(local250.aByteArray7, local250.anInt561, 0, (byte) -106);
					local250.method379((byte) 8);
				}
				this.anInt180++;
				if (this.anInt180 > 750) {
					this.method182(false);
				}
				this.method193(true);
				this.method123(true);
				this.method186(this.aByte17);
				this.method105(this.anInt174);
				if ((super.anIntArray28[1] == 1 || super.anIntArray28[2] == 1 || super.anIntArray28[3] == 1 || super.anIntArray28[4] == 1) && this.anInt245++ > 5) {
					this.anInt245 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 189);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt199);
					this.aClass1_Sub3_Sub3_6.method382(this.anInt200);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt308);
					this.aClass1_Sub3_Sub3_6.method381(this.anInt249);
				}
				this.anInt270++;
				if (this.anInt156 != 0) {
					this.anInt155 += 20;
					if (this.anInt155 >= 400) {
						this.anInt156 = 0;
					}
				}
				if (this.anInt260 != 0) {
					this.anInt257++;
					if (this.anInt257 >= 15) {
						if (this.anInt260 == 2) {
							this.aBoolean59 = true;
						}
						if (this.anInt260 == 3) {
							this.aBoolean60 = true;
						}
						this.anInt260 = 0;
					}
				}
				@Pc(508) int local508;
				if (this.anInt216 != 0) {
					this.anInt247++;
					if (super.anInt135 > this.anInt217 + 5 || super.anInt135 < this.anInt217 - 5 || super.anInt136 > this.anInt218 + 5 || super.anInt136 < this.anInt218 - 5) {
						this.aBoolean58 = true;
					}
					if (super.anInt134 == 0) {
						if (this.anInt216 == 2) {
							this.aBoolean59 = true;
						}
						if (this.anInt216 == 3) {
							this.aBoolean60 = true;
						}
						this.anInt216 = 0;
						if (this.aBoolean58 && this.anInt247 >= 5) {
							this.anInt311 = -1;
							this.method143(26);
							if (this.anInt311 == this.anInt214 && this.anInt310 != this.anInt215) {
								@Pc(502) Class15 local502 = Static17.aClass15Array1[this.anInt214];
								local508 = local502.anIntArray149[this.anInt310];
								local502.anIntArray149[this.anInt310] = local502.anIntArray149[this.anInt215];
								local502.anIntArray149[this.anInt215] = local508;
								@Pc(530) int local530 = local502.anIntArray150[this.anInt310];
								local502.anIntArray150[this.anInt310] = local502.anIntArray150[this.anInt215];
								local502.anIntArray150[this.anInt215] = local530;
								this.aClass1_Sub3_Sub3_6.method380((byte) -34, 159);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt214);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt215);
								this.aClass1_Sub3_Sub3_6.method382(this.anInt310);
							}
						} else if ((this.anInt196 == 1 || this.method131(145, this.anInt304 - 1)) && this.anInt304 > 2) {
							this.method154(-386);
						} else if (this.anInt304 > 0) {
							this.method132(6412, this.anInt304 - 1);
						}
						this.anInt257 = 10;
						super.anInt137 = 0;
					}
				}
				Static6.anInt279++;
				if (Static6.anInt279 > 127) {
					Static6.anInt279 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 215);
					this.aClass1_Sub3_Sub3_6.method384(4991788);
				}
				if (Static25.anInt714 != -1) {
					local155 = Static25.anInt714;
					local508 = Static25.anInt715;
					@Pc(653) boolean local653 = this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 0, true, local155, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 0, 0, local508, 0, 0, 0);
					Static25.anInt714 = -1;
					if (local653) {
						this.anInt153 = super.anInt138;
						this.anInt154 = super.anInt139;
						this.anInt156 = 1;
						this.anInt155 = 0;
					}
				}
				if (super.anInt137 == 1 && this.aString8 != null) {
					this.aString8 = null;
					this.aBoolean60 = true;
					super.anInt137 = 0;
				}
				this.method177((byte) 3);
				this.method176((byte) 7);
				this.method179(this.anInt333);
				this.method91(0);
				if (super.anInt134 == 1 || super.anInt137 == 1) {
					this.anInt253++;
				}
				if (this.anInt307 == 2) {
					this.method146(0);
				}
				if (this.anInt307 == 2 && this.aBoolean61) {
					this.method178(this.aByte11);
				}
				for (local155 = 0; local155 < 5; local155++) {
					local207 = this.anIntArray68[local155]++;
				}
				this.method96(7);
				super.anInt133++;
				if (super.anInt133 > 4500) {
					this.anInt182 = 250;
					super.anInt133 -= 500;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 70);
				}
				this.anInt183++;
				if (this.anInt183 > 500) {
					this.anInt183 = 0;
					local508 = (int) (Math.random() * 8.0D);
					if ((local508 & 0x1) == 1) {
						this.anInt327 += this.anInt328;
					}
					if ((local508 & 0x2) == 2) {
						this.anInt331 += this.anInt332;
					}
					if ((local508 & 0x4) == 4) {
						this.anInt334 += this.anInt335;
					}
				}
				if (this.anInt327 < -50) {
					this.anInt328 = 2;
				}
				if (this.anInt327 > 50) {
					this.anInt328 = -2;
				}
				if (this.anInt331 < -55) {
					this.anInt332 = 2;
				}
				if (this.anInt331 > 55) {
					this.anInt332 = -2;
				}
				if (this.anInt334 < -40) {
					this.anInt335 = 1;
				}
				if (this.anInt334 > 40) {
					this.anInt335 = -1;
				}
				this.anInt163++;
				if (this.anInt163 > 500) {
					this.anInt163 = 0;
					local508 = (int) (Math.random() * 8.0D);
					if ((local508 & 0x1) == 1) {
						this.anInt308 += this.anInt309;
					}
					if ((local508 & 0x2) == 2) {
						this.anInt249 += this.anInt250;
					}
				}
				if (this.anInt308 < -60) {
					this.anInt309 = 2;
				}
				if (this.anInt308 > 60) {
					this.anInt309 = -2;
				}
				if (this.anInt249 < -20) {
					this.anInt250 = 1;
				}
				if (this.anInt249 > 10) {
					this.anInt250 = -1;
				}
				Static6.anInt313++;
				if (Static6.anInt313 > 110) {
					Static6.anInt313 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 236);
					this.aClass1_Sub3_Sub3_6.method385(0);
				}
				this.anInt181++;
				if (this.anInt181 > 50) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 108);
				}
				try {
					if (this.aClass6_1 != null && this.aClass1_Sub3_Sub3_6.anInt561 > 0) {
						this.aClass6_1.method205(this.aClass1_Sub3_Sub3_6.aByteArray7, this.aClass1_Sub3_Sub3_6.anInt561, true, 0);
						this.aClass1_Sub3_Sub3_6.anInt561 = 0;
						this.anInt181 = 0;
					}
				} catch (@Pc(1001) IOException local1001) {
					this.method182(false);
				} catch (@Pc(1006) Exception local1006) {
					this.method119(-780);
				}
			}
		} catch (@Pc(1011) RuntimeException local1011) {
			signlink.reporterror("43736, " + arg0 + ", " + local1011.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(Z)V")
	private void method165(@OriginalArg(0) boolean arg0) {
		try {
			if (this.anInt304 >= 2 || this.anInt281 != 0 || this.anInt291 != 0) {
				@Pc(31) String local31;
				if (this.anInt281 == 1 && this.anInt304 < 2) {
					local31 = "Use " + this.aString10 + " with...";
				} else if (this.anInt291 == 1 && this.anInt304 < 2) {
					local31 = this.aString11 + "...";
				} else {
					local31 = this.aStringArray5[this.anInt304 - 1];
				}
				if (this.anInt304 > 2) {
					local31 = local31 + "@whi@ / " + (this.anInt304 - 2) + " more options";
				}
				this.aClass1_Sub3_Sub2_Sub4_3.method368(Static6.anInt266 / 1000, true, (byte) -121, 15, 16777215, local31, 4);
				if (!arg0) {
					this.anInt179 = -1;
				}
			}
		} catch (@Pc(100) RuntimeException local100) {
			signlink.reporterror("32785, " + arg0 + ", " + local100.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(B)V")
	private void method166(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != this.aByte8) {
				this.anInt194 = -357;
			}
			for (@Pc(13) Class1_Sub1_Sub2 local13 = (Class1_Sub1_Sub2) this.aClass28_5.method456(); local13 != null; local13 = (Class1_Sub1_Sub2) this.aClass28_5.method458(551)) {
				if (local13.anInt61 != this.anInt231 || local13.aBoolean17) {
					local13.method567();
				} else if (Static6.anInt266 >= local13.anInt60) {
					local13.method29(this.anInt270, 0);
					if (local13.aBoolean17) {
						local13.method567();
					} else {
						this.aClass33_1.method478(-44713, local13.anInt63, 60, 0, local13.anInt62, -1, false, null, local13, local13.anInt64, local13.anInt61);
					}
				}
			}
		} catch (@Pc(72) RuntimeException local72) {
			signlink.reporterror("59878, " + arg0 + ", " + local72.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "getCodeBase", descriptor = "()Ljava/net/URL;")
	@Override
	public URL getCodeBase() {
		if (signlink.mainapp != null) {
			return signlink.mainapp.getCodeBase();
		}
		try {
			if (super.aFrame_Sub1_2 != null) {
				return new URL("http://world2.runewiki.org:" + (Static6.anInt236 + 80));
			}
		} catch (@Pc(21) Exception local21) {
		}
		return super.getCodeBase();
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZIIIIIIIII)Z")
	private boolean method168(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
		try {
			@Pc(3) byte local3 = 104;
			@Pc(5) byte local5 = 104;
			@Pc(11) int local11;
			for (@Pc(7) int local7 = 0; local7 < local3; local7++) {
				for (local11 = 0; local11 < local5; local11++) {
					this.anIntArrayArray5[local7][local11] = 0;
					this.anIntArrayArray2[local7][local11] = 99999999;
				}
			}
			local11 = arg0;
			@Pc(39) int local39 = arg4;
			this.anIntArrayArray5[arg0][arg4] = 99;
			this.anIntArrayArray2[arg0][arg4] = 0;
			@Pc(55) byte local55 = 0;
			@Pc(57) int local57 = 0;
			this.anIntArray66[local55] = arg0;
			@Pc(66) int local66 = local55 + 1;
			this.anIntArray67[local55] = arg4;
			@Pc(70) boolean local70 = false;
			@Pc(74) int local74 = this.anIntArray66.length;
			@Pc(81) int[][] local81 = this.aClass9Array1[this.anInt231].anIntArrayArray10;
			@Pc(193) int local193;
			while (local57 != local66) {
				local11 = this.anIntArray66[local57];
				local39 = this.anIntArray67[local57];
				local57 = (local57 + 1) % local74;
				if (local11 == arg3 && local39 == arg8) {
					local70 = true;
					break;
				}
				if (arg10 != 0) {
					if ((arg10 < 5 || arg10 == 10) && this.aClass9Array1[this.anInt231].method258(-7517, arg9, arg8, arg10 - 1, local39, arg3, local11)) {
						local70 = true;
						break;
					}
					if (arg10 < 10 && this.aClass9Array1[this.anInt231].method259(arg9, arg10 - 1, this.anInt294, local11, arg3, local39, arg8)) {
						local70 = true;
						break;
					}
				}
				if (arg1 != 0 && arg7 != 0 && this.aClass9Array1[this.anInt231].method260(local39, arg7, local11, arg3, arg11, arg8, arg1, 168)) {
					local70 = true;
					break;
				}
				local193 = this.anIntArrayArray2[local11][local39] + 1;
				if (local11 > 0 && this.anIntArrayArray5[local11 - 1][local39] == 0 && (local81[local11 - 1][local39] & 0x280108) == 0) {
					this.anIntArray66[local66] = local11 - 1;
					this.anIntArray67[local66] = local39;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11 - 1][local39] = 2;
					this.anIntArrayArray2[local11 - 1][local39] = local193;
				}
				if (local11 < local3 - 1 && this.anIntArrayArray5[local11 + 1][local39] == 0 && (local81[local11 + 1][local39] & 0x280180) == 0) {
					this.anIntArray66[local66] = local11 + 1;
					this.anIntArray67[local66] = local39;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11 + 1][local39] = 8;
					this.anIntArrayArray2[local11 + 1][local39] = local193;
				}
				if (local39 > 0 && this.anIntArrayArray5[local11][local39 - 1] == 0 && (local81[local11][local39 - 1] & 0x280102) == 0) {
					this.anIntArray66[local66] = local11;
					this.anIntArray67[local66] = local39 - 1;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11][local39 - 1] = 1;
					this.anIntArrayArray2[local11][local39 - 1] = local193;
				}
				if (local39 < local5 - 1 && this.anIntArrayArray5[local11][local39 + 1] == 0 && (local81[local11][local39 + 1] & 0x280120) == 0) {
					this.anIntArray66[local66] = local11;
					this.anIntArray67[local66] = local39 + 1;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11][local39 + 1] = 4;
					this.anIntArrayArray2[local11][local39 + 1] = local193;
				}
				if (local11 > 0 && local39 > 0 && this.anIntArrayArray5[local11 - 1][local39 - 1] == 0 && (local81[local11 - 1][local39 - 1] & 0x28010E) == 0 && (local81[local11 - 1][local39] & 0x280108) == 0 && (local81[local11][local39 - 1] & 0x280102) == 0) {
					this.anIntArray66[local66] = local11 - 1;
					this.anIntArray67[local66] = local39 - 1;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11 - 1][local39 - 1] = 3;
					this.anIntArrayArray2[local11 - 1][local39 - 1] = local193;
				}
				if (local11 < local3 - 1 && local39 > 0 && this.anIntArrayArray5[local11 + 1][local39 - 1] == 0 && (local81[local11 + 1][local39 - 1] & 0x280183) == 0 && (local81[local11 + 1][local39] & 0x280180) == 0 && (local81[local11][local39 - 1] & 0x280102) == 0) {
					this.anIntArray66[local66] = local11 + 1;
					this.anIntArray67[local66] = local39 - 1;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11 + 1][local39 - 1] = 9;
					this.anIntArrayArray2[local11 + 1][local39 - 1] = local193;
				}
				if (local11 > 0 && local39 < local5 - 1 && this.anIntArrayArray5[local11 - 1][local39 + 1] == 0 && (local81[local11 - 1][local39 + 1] & 0x280138) == 0 && (local81[local11 - 1][local39] & 0x280108) == 0 && (local81[local11][local39 + 1] & 0x280120) == 0) {
					this.anIntArray66[local66] = local11 - 1;
					this.anIntArray67[local66] = local39 + 1;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11 - 1][local39 + 1] = 6;
					this.anIntArrayArray2[local11 - 1][local39 + 1] = local193;
				}
				if (local11 < local3 - 1 && local39 < local5 - 1 && this.anIntArrayArray5[local11 + 1][local39 + 1] == 0 && (local81[local11 + 1][local39 + 1] & 0x2801E0) == 0 && (local81[local11 + 1][local39] & 0x280180) == 0 && (local81[local11][local39 + 1] & 0x280120) == 0) {
					this.anIntArray66[local66] = local11 + 1;
					this.anIntArray67[local66] = local39 + 1;
					local66 = (local66 + 1) % local74;
					this.anIntArrayArray5[local11 + 1][local39 + 1] = 12;
					this.anIntArrayArray2[local11 + 1][local39 + 1] = local193;
				}
			}
			this.anInt277 = 0;
			@Pc(809) int local809;
			@Pc(815) int local815;
			@Pc(821) int local821;
			if (!local70) {
				if (arg2) {
					local193 = 100;
					for (local809 = 1; local809 < 2; local809++) {
						for (local815 = arg3 - local809; local815 <= arg3 + local809; local815++) {
							for (local821 = arg8 - local809; local821 <= arg8 + local809; local821++) {
								if (local815 >= 0 && local821 >= 0 && local815 < 104 && local821 < 104 && this.anIntArrayArray2[local815][local821] < local193) {
									local193 = this.anIntArrayArray2[local815][local821];
									local11 = local815;
									local39 = local821;
									this.anInt277 = 1;
									local70 = true;
								}
							}
						}
						if (local70) {
							break;
						}
					}
				}
				if (!local70) {
					return false;
				}
			}
			@Pc(882) byte local882 = 0;
			this.anIntArray66[local882] = local11;
			if (arg5 != 0) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			local57 = local882 + 1;
			this.anIntArray67[local882] = local39;
			local193 = local809 = this.anIntArrayArray5[local11][local39];
			while (local11 != arg0 || local39 != arg4) {
				if (local193 != local809) {
					local809 = local193;
					this.anIntArray66[local57] = local11;
					this.anIntArray67[local57++] = local39;
				}
				if ((local193 & 0x2) != 0) {
					local11++;
				} else if ((local193 & 0x8) != 0) {
					local11--;
				}
				if ((local193 & 0x1) != 0) {
					local39++;
				} else if ((local193 & 0x4) != 0) {
					local39--;
				}
				local193 = this.anIntArrayArray5[local11][local39];
			}
			if (local57 > 0) {
				local74 = local57;
				if (local57 > 25) {
					local74 = 25;
				}
				local57--;
				local815 = this.anIntArray66[local57];
				local821 = this.anIntArray67[local57];
				if (arg6 == 0) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 181);
					this.aClass1_Sub3_Sub3_6.method381(local74 + local74 + 3);
				}
				if (arg6 == 1) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 165);
					this.aClass1_Sub3_Sub3_6.method381(local74 + local74 + 3 + 14);
				}
				if (arg6 == 2) {
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 93);
					this.aClass1_Sub3_Sub3_6.method381(local74 + local74 + 3);
				}
				if (super.anIntArray28[5] == 1) {
					this.aClass1_Sub3_Sub3_6.method381(1);
				} else {
					this.aClass1_Sub3_Sub3_6.method381(0);
				}
				this.aClass1_Sub3_Sub3_6.method382(local815 + this.anInt169);
				this.aClass1_Sub3_Sub3_6.method382(local821 + this.anInt170);
				this.anInt296 = this.anIntArray66[0];
				this.anInt297 = this.anIntArray67[0];
				for (@Pc(1077) int local1077 = 1; local1077 < local74; local1077++) {
					local57--;
					this.aClass1_Sub3_Sub3_6.method381(this.anIntArray66[local57] - local815);
					this.aClass1_Sub3_Sub3_6.method381(this.anIntArray67[local57] - local821);
				}
				return true;
			} else if (arg6 == 1) {
				return false;
			} else {
				return true;
			}
		} catch (@Pc(1112) RuntimeException local1112) {
			signlink.reporterror("92875, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + arg8 + ", " + arg9 + ", " + arg10 + ", " + arg11 + ", " + local1112.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!kb;II)V")
	private void method170(@OriginalArg(0) Class1_Sub3_Sub3 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			this.anInt255 = 0;
			this.anInt206 = 0;
			this.method195(11522, arg1, arg0);
			this.method110(arg1, arg0, 0);
			this.method118(2, arg1, arg0);
			this.method121(true, arg1, arg0);
			@Pc(36) int local36;
			for (@Pc(29) int local29 = 0; local29 < this.anInt255; local29++) {
				local36 = this.anIntArray60[local29];
				if (this.aClass1_Sub1_Sub3_Sub2Array1[local36].anInt924 != Static6.anInt266) {
					this.aClass1_Sub1_Sub3_Sub2Array1[local36] = null;
				}
			}
			if (arg2 > 0) {
				if (arg0.anInt561 != arg1) {
					signlink.reporterror("Error packet size mismatch in getplayer pos:" + arg0.anInt561 + " psize:" + arg1);
					throw new RuntimeException("eek");
				}
				for (local36 = 0; local36 < this.anInt205; local36++) {
					if (this.aClass1_Sub1_Sub3_Sub2Array1[this.anIntArray39[local36]] == null) {
						signlink.reporterror(this.aString13 + " null entry in pl list - pos:" + local36 + " size:" + this.anInt205);
						throw new RuntimeException("eek");
					}
				}
			}
		} catch (@Pc(119) RuntimeException local119) {
			signlink.reporterror("9307, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local119.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(III)Z")
	private boolean method171(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(3) boolean local3 = false;
			@Pc(7) Class15 local7 = Static17.aClass15Array1[arg0];
			for (@Pc(9) int local9 = 0; local9 < local7.anIntArray153.length && local7.anIntArray153[local9] != -1; local9++) {
				@Pc(24) Class15 local24 = Static17.aClass15Array1[local7.anIntArray153[local9]];
				if (local24.anInt472 == 1) {
					local3 |= this.method171(local24.anInt470, arg1, 623);
				}
				if (local24.anInt472 == 6 && (local24.anInt488 != -1 || local24.anInt489 != -1)) {
					@Pc(54) boolean local54 = this.method175(local24, 65);
					@Pc(59) int local59;
					if (local54) {
						local59 = local24.anInt489;
					} else {
						local59 = local24.anInt488;
					}
					if (local59 != -1) {
						@Pc(71) Class19 local71 = Static20.aClass19Array1[local59];
						local24.anInt469 += arg1;
						while (local24.anInt469 > local71.anIntArray188[local24.anInt468]) {
							local24.anInt469 -= local71.anIntArray188[local24.anInt468] + 1;
							local24.anInt468++;
							if (local24.anInt468 >= local71.anInt543) {
								local24.anInt468 -= local71.anInt544;
								if (local24.anInt468 < 0 || local24.anInt468 >= local71.anInt543) {
									local24.anInt468 = 0;
								}
							}
							local3 = true;
						}
					}
				}
			}
			if (arg2 <= 0) {
				throw new NullPointerException();
			}
			return local3;
		} catch (@Pc(145) RuntimeException local145) {
			signlink.reporterror("31675, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local145.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILjava/lang/String;BLjava/lang/String;)V")
	private void method172(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1, @OriginalArg(2) byte arg2, @OriginalArg(3) String arg3) {
		try {
			if (arg0 == 0 && this.anInt289 != -1) {
				this.aString8 = arg1;
				super.anInt137 = 0;
			}
			if (this.anInt280 == -1) {
				this.aBoolean60 = true;
			}
			for (@Pc(20) int local20 = 99; local20 > 0; local20--) {
				this.anIntArray49[local20] = this.anIntArray49[local20 - 1];
				this.aStringArray6[local20] = this.aStringArray6[local20 - 1];
				this.aStringArray7[local20] = this.aStringArray7[local20 - 1];
			}
			this.anIntArray49[0] = arg0;
			this.aStringArray6[0] = arg3;
			if (arg2 != 4) {
				this.aBoolean55 = !this.aBoolean55;
			}
			this.aStringArray7[0] = arg1;
		} catch (@Pc(83) RuntimeException local83) {
			signlink.reporterror("40788, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local83.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(II)V")
	private void method173(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) Class15 local3 = Static17.aClass15Array1[arg1];
			for (@Pc(5) int local5 = 0; local5 < local3.anIntArray153.length && local3.anIntArray153[local5] != -1; local5++) {
				@Pc(20) Class15 local20 = Static17.aClass15Array1[local3.anIntArray153[local5]];
				if (local20.anInt472 == 1) {
					this.method173(-321, local20.anInt470);
				}
				local20.anInt468 = 0;
				local20.anInt469 = 0;
			}
			if (arg0 >= 0) {
				this.aClass28ArrayArrayArray1 = null;
			}
		} catch (@Pc(48) RuntimeException local48) {
			signlink.reporterror("24441, " + arg0 + ", " + arg1 + ", " + local48.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IJ)V")
	private void method174(@OriginalArg(0) int arg0, @OriginalArg(1) long arg1) {
		try {
			@Pc(6) int local6;
			if (arg0 != 43808) {
				for (local6 = 1; local6 > 0; local6++) {
				}
			}
			if (arg1 != 0L) {
				for (local6 = 0; local6 < this.anInt312; local6++) {
					if (this.aLongArray4[local6] == arg1) {
						this.anInt312--;
						this.aBoolean59 = true;
						for (@Pc(38) int local38 = local6; local38 < this.anInt312; local38++) {
							this.aStringArray9[local38] = this.aStringArray9[local38 + 1];
							this.anIntArray34[local38] = this.anIntArray34[local38 + 1];
							this.aLongArray4[local38] = this.aLongArray4[local38 + 1];
						}
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 11);
						this.aClass1_Sub3_Sub3_6.method387(true, arg1);
						return;
					}
				}
			}
		} catch (@Pc(93) RuntimeException local93) {
			signlink.reporterror("5387, " + arg0 + ", " + arg1 + ", " + local93.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;I)Z")
	private boolean method175(@OriginalArg(0) Class15 arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0.anIntArray151 == null) {
				return false;
			}
			for (@Pc(6) int local6 = 0; local6 < arg0.anIntArray151.length; local6++) {
				@Pc(14) int local14 = this.method187(arg0, false, local6);
				@Pc(19) int local19 = arg0.anIntArray152[local6];
				if (arg0.anIntArray151[local6] == 2) {
					if (local14 >= local19) {
						return false;
					}
				} else if (arg0.anIntArray151[local6] == 3) {
					if (local14 <= local19) {
						return false;
					}
				} else if (arg0.anIntArray151[local6] == 4) {
					if (local14 == local19) {
						return false;
					}
				} else if (local14 != local19) {
					return false;
				}
			}
			if (arg1 <= 0) {
				this.aClass1_Sub3_Sub3_6.method381(82);
			}
			return true;
		} catch (@Pc(72) RuntimeException local72) {
			signlink.reporterror("59816, " + arg0 + ", " + arg1 + ", " + local72.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(B)V")
	private void method176(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != this.aByte15) {
				this.aClass28ArrayArrayArray1 = null;
			}
			if (super.anInt137 == 1) {
				@Pc(17) int local17 = super.anInt138 - 21 - 561;
				@Pc(24) int local24 = super.anInt139 - 9 - 5;
				if (local17 >= 0 && local24 >= 0 && local17 < 146 && local24 < 151) {
					local17 -= 73;
					local24 -= 75;
					@Pc(44) int local44 = this.anInt200 + this.anInt308 & 0x7FF;
					@Pc(48) int local48 = Class1_Sub3_Sub2_Sub1.anIntArray137[local44];
					@Pc(52) int local52 = Class1_Sub3_Sub2_Sub1.anIntArray138[local44];
					@Pc(61) int local61 = local48 * (this.anInt249 + 256) >> 8;
					@Pc(70) int local70 = local52 * (this.anInt249 + 256) >> 8;
					@Pc(80) int local80 = local24 * local61 + local17 * local70 >> 11;
					@Pc(90) int local90 = local24 * local70 - local17 * local61 >> 11;
					@Pc(98) int local98 = this.aClass1_Sub1_Sub3_Sub2_1.anInt882 + local80 >> 7;
					@Pc(106) int local106 = this.aClass1_Sub1_Sub3_Sub2_1.anInt883 - local90 >> 7;
					@Pc(129) boolean local129 = this.method168(this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0], 0, true, local98, this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0], 0, 1, 0, local106, 0, 0, 0);
					if (local129) {
						this.aClass1_Sub3_Sub3_6.method381(local17);
						this.aClass1_Sub3_Sub3_6.method381(local24);
						this.aClass1_Sub3_Sub3_6.method382(this.anInt200);
						this.aClass1_Sub3_Sub3_6.method381(57);
						this.aClass1_Sub3_Sub3_6.method381(this.anInt308);
						this.aClass1_Sub3_Sub3_6.method381(this.anInt249);
						this.aClass1_Sub3_Sub3_6.method381(89);
						this.aClass1_Sub3_Sub3_6.method382(this.aClass1_Sub1_Sub3_Sub2_1.anInt882);
						this.aClass1_Sub3_Sub3_6.method382(this.aClass1_Sub1_Sub3_Sub2_1.anInt883);
						this.aClass1_Sub3_Sub3_6.method381(this.anInt277);
						this.aClass1_Sub3_Sub3_6.method381(63);
						return;
					}
				}
			}
		} catch (@Pc(185) RuntimeException local185) {
			signlink.reporterror("6474, " + arg0 + ", " + local185.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(B)V")
	private void method177(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != 3) {
				this.anInt179 = this.aClass1_Sub3_Sub3_5.method391();
			}
			if (this.anInt216 == 0) {
				@Pc(14) int local14 = super.anInt137;
				if (this.anInt291 == 1 && super.anInt138 >= 520 && super.anInt139 >= 165 && super.anInt138 <= 788 && super.anInt139 <= 230) {
					local14 = 0;
				}
				@Pc(45) int local45;
				@Pc(48) int local48;
				@Pc(124) int local124;
				if (this.aBoolean50) {
					if (local14 != 1) {
						local45 = super.anInt135;
						local48 = super.anInt136;
						if (this.anInt337 == 0) {
							local45 -= 8;
							local48 -= 11;
						}
						if (this.anInt337 == 1) {
							local45 -= 562;
							local48 -= 231;
						}
						if (this.anInt337 == 2) {
							local45 -= 22;
							local48 -= 375;
						}
						if (local45 < this.anInt338 - 10 || local45 > this.anInt338 + this.anInt340 + 10 || local48 < this.anInt339 - 10 || local48 > this.anInt339 + this.anInt341 + 10) {
							this.aBoolean50 = false;
							if (this.anInt337 == 1) {
								this.aBoolean59 = true;
							}
							if (this.anInt337 == 2) {
								this.aBoolean60 = true;
							}
						}
					}
					if (local14 == 1) {
						local45 = this.anInt338;
						local48 = this.anInt339;
						local124 = this.anInt340;
						@Pc(127) int local127 = super.anInt138;
						@Pc(130) int local130 = super.anInt139;
						if (this.anInt337 == 0) {
							local127 -= 8;
							local130 -= 11;
						}
						if (this.anInt337 == 1) {
							local127 -= 562;
							local130 -= 231;
						}
						if (this.anInt337 == 2) {
							local127 -= 22;
							local130 -= 375;
						}
						@Pc(149) int local149 = -1;
						for (@Pc(151) int local151 = 0; local151 < this.anInt304; local151++) {
							@Pc(166) int local166 = local48 + (this.anInt304 - 1 - local151) * 15 + 31;
							if (local127 > local45 && local127 < local45 + local124 && local130 > local166 - 13 && local130 < local166 + 3) {
								local149 = local151;
							}
						}
						if (local149 != -1) {
							this.method132(6412, local149);
						}
						this.aBoolean50 = false;
						if (this.anInt337 == 1) {
							this.aBoolean59 = true;
						}
						if (this.anInt337 == 2) {
							this.aBoolean60 = true;
							return;
						}
					}
				} else {
					if (local14 == 1 && this.anInt304 > 0) {
						local45 = this.anIntArray86[this.anInt304 - 1];
						if (local45 == 602 || local45 == 596 || local45 == 22 || local45 == 892 || local45 == 415 || local45 == 405 || local45 == 38 || local45 == 422 || local45 == 478 || local45 == 347 || local45 == 188) {
							local48 = this.anIntArray84[this.anInt304 - 1];
							local124 = this.anIntArray85[this.anInt304 - 1];
							@Pc(283) Class15 local283 = Static17.aClass15Array1[local124];
							if (local283.aBoolean108) {
								this.aBoolean58 = false;
								this.anInt247 = 0;
								this.anInt214 = local124;
								this.anInt215 = local48;
								this.anInt216 = 2;
								this.anInt217 = super.anInt138;
								this.anInt218 = super.anInt139;
								if (Static17.aClass15Array1[local124].anInt471 == this.anInt271) {
									this.anInt216 = 1;
								}
								if (Static17.aClass15Array1[local124].anInt471 == this.anInt280) {
									this.anInt216 = 3;
								}
								return;
							}
						}
					}
					if (local14 == 1 && (this.anInt196 == 1 || this.method131(145, this.anInt304 - 1)) && this.anInt304 > 2) {
						local14 = 2;
					}
					if (local14 == 1 && this.anInt304 > 0) {
						this.method132(6412, this.anInt304 - 1);
					}
					if (local14 != 2 || this.anInt304 <= 0) {
						return;
					}
					this.method154(-386);
				}
			}
		} catch (@Pc(375) RuntimeException local375) {
			signlink.reporterror("37713, " + arg0 + ", " + local375.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(B)V")
	private void method178(@OriginalArg(0) byte arg0) {
		try {
			@Pc(6) int local6 = this.anInt146 * 128 + 64;
			@Pc(13) int local13 = this.anInt147 * 128 + 64;
			@Pc(26) int local26 = this.method94(this.anInt231, this.anInt146, (byte) 5, this.anInt147) - this.anInt148;
			if (this.anInt322 < local6) {
				this.anInt322 += this.anInt149 + (local6 - this.anInt322) * this.anInt150 / 1000;
				if (this.anInt322 > local6) {
					this.anInt322 = local6;
				}
			}
			if (this.anInt322 > local6) {
				this.anInt322 -= this.anInt149 + (this.anInt322 - local6) * this.anInt150 / 1000;
				if (this.anInt322 < local6) {
					this.anInt322 = local6;
				}
			}
			if (this.anInt323 < local26) {
				this.anInt323 += this.anInt149 + (local26 - this.anInt323) * this.anInt150 / 1000;
				if (this.anInt323 > local26) {
					this.anInt323 = local26;
				}
			}
			if (this.anInt323 > local26) {
				this.anInt323 -= this.anInt149 + (this.anInt323 - local26) * this.anInt150 / 1000;
				if (this.anInt323 < local26) {
					this.anInt323 = local26;
				}
			}
			if (this.anInt324 < local13) {
				this.anInt324 += this.anInt149 + (local13 - this.anInt324) * this.anInt150 / 1000;
				if (this.anInt324 > local13) {
					this.anInt324 = local13;
				}
			}
			if (this.anInt324 > local13) {
				this.anInt324 -= this.anInt149 + (this.anInt324 - local13) * this.anInt150 / 1000;
				if (this.anInt324 < local13) {
					this.anInt324 = local13;
				}
			}
			local6 = this.anInt261 * 128 + 64;
			local13 = this.anInt262 * 128 + 64;
			local26 = this.method94(this.anInt231, this.anInt261, (byte) 5, this.anInt262) - this.anInt263;
			@Pc(226) int local226 = local6 - this.anInt322;
			@Pc(231) int local231 = local26 - this.anInt323;
			@Pc(236) int local236 = local13 - this.anInt324;
			@Pc(247) int local247 = (int) Math.sqrt((double) (local226 * local226 + local236 * local236));
			@Pc(258) int local258 = (int) (Math.atan2((double) local231, (double) local247) * 325.949D) & 0x7FF;
			@Pc(269) int local269 = (int) (Math.atan2((double) local226, (double) local236) * -325.949D) & 0x7FF;
			if (arg0 == 2) {
				if (local258 < 128) {
					local258 = 128;
				}
				if (local258 > 383) {
					local258 = 383;
				}
				if (this.anInt325 < local258) {
					this.anInt325 += this.anInt264 + (local258 - this.anInt325) * this.anInt265 / 1000;
					if (this.anInt325 > local258) {
						this.anInt325 = local258;
					}
				}
				if (this.anInt325 > local258) {
					this.anInt325 -= this.anInt264 + (this.anInt325 - local258) * this.anInt265 / 1000;
					if (this.anInt325 < local258) {
						this.anInt325 = local258;
					}
				}
				@Pc(344) int local344 = local269 - this.anInt326;
				if (local344 > 1024) {
					local344 -= 2048;
				}
				if (local344 < -1024) {
					local344 += 2048;
				}
				if (local344 > 0) {
					this.anInt326 += this.anInt264 + local344 * this.anInt265 / 1000;
					this.anInt326 &= 0x7FF;
				}
				if (local344 < 0) {
					this.anInt326 -= this.anInt264 + -local344 * this.anInt265 / 1000;
					this.anInt326 &= 0x7FF;
				}
				@Pc(402) int local402 = local269 - this.anInt326;
				if (local402 > 1024) {
					local402 -= 2048;
				}
				if (local402 < -1024) {
					local402 += 2048;
				}
				if (local402 < 0 && local344 > 0 || local402 > 0 && local344 < 0) {
					this.anInt326 = local269;
				}
			}
		} catch (@Pc(423) RuntimeException local423) {
			signlink.reporterror("52951, " + arg0 + ", " + local423.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "C", descriptor = "(I)V")
	private void method179(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 29286) {
				this.anInt174 = this.aClass38_1.method532();
			}
			if (super.anInt137 == 1) {
				if (super.anInt138 >= 549 && super.anInt138 <= 583 && super.anInt139 >= 195 && super.anInt139 < 231 && this.anIntArray46[0] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 0;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 579 && super.anInt138 <= 609 && super.anInt139 >= 194 && super.anInt139 < 231 && this.anIntArray46[1] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 1;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 607 && super.anInt138 <= 637 && super.anInt139 >= 194 && super.anInt139 < 231 && this.anIntArray46[2] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 2;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 635 && super.anInt138 <= 679 && super.anInt139 >= 194 && super.anInt139 < 229 && this.anIntArray46[3] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 3;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 676 && super.anInt138 <= 706 && super.anInt139 >= 194 && super.anInt139 < 231 && this.anIntArray46[4] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 4;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 704 && super.anInt138 <= 734 && super.anInt139 >= 194 && super.anInt139 < 231 && this.anIntArray46[5] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 5;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 732 && super.anInt138 <= 766 && super.anInt139 >= 195 && super.anInt139 < 231 && this.anIntArray46[6] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 6;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 550 && super.anInt138 <= 584 && super.anInt139 >= 492 && super.anInt139 < 528 && this.anIntArray46[7] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 7;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 582 && super.anInt138 <= 612 && super.anInt139 >= 492 && super.anInt139 < 529 && this.anIntArray46[8] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 8;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 609 && super.anInt138 <= 639 && super.anInt139 >= 492 && super.anInt139 < 529 && this.anIntArray46[9] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 9;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 637 && super.anInt138 <= 681 && super.anInt139 >= 493 && super.anInt139 < 528 && this.anIntArray46[10] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 10;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 679 && super.anInt138 <= 709 && super.anInt139 >= 492 && super.anInt139 < 529 && this.anIntArray46[11] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 11;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 706 && super.anInt138 <= 736 && super.anInt139 >= 492 && super.anInt139 < 529 && this.anIntArray46[12] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 12;
					this.aBoolean68 = true;
				}
				if (super.anInt138 >= 734 && super.anInt138 <= 768 && super.anInt139 >= 492 && super.anInt139 < 528 && this.anIntArray46[13] != -1) {
					this.aBoolean59 = true;
					this.anInt166 = 13;
					this.aBoolean68 = true;
				}
				Static6.anInt232++;
				if (Static6.anInt232 > 150) {
					Static6.anInt232 = 0;
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 233);
					this.aClass1_Sub3_Sub3_6.method381(43);
					return;
				}
			}
		} catch (@Pc(465) RuntimeException local465) {
			signlink.reporterror("26651, " + arg0 + ", " + local465.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;B)Z")
	private boolean method180(@OriginalArg(0) Class15 arg0, @OriginalArg(1) byte arg1) {
		try {
			@Pc(2) int local2 = arg0.anInt474;
			if (arg1 != this.aByte9) {
				this.anInt294 = this.aClass38_1.method532();
			}
			if (local2 >= 1 && local2 <= 200) {
				if (local2 >= 101) {
					local2 -= 101;
				} else {
					local2--;
				}
				this.aStringArray5[this.anInt304] = "Remove @whi@" + this.aStringArray9[local2];
				this.anIntArray86[this.anInt304] = 557;
				this.anInt304++;
				this.aStringArray5[this.anInt304] = "Message @whi@" + this.aStringArray9[local2];
				this.anIntArray86[this.anInt304] = 679;
				this.anInt304++;
				return true;
			} else if (local2 >= 401 && local2 <= 500) {
				this.aStringArray5[this.anInt304] = "Remove @whi@" + arg0.aString20;
				this.anIntArray86[this.anInt304] = 556;
				this.anInt304++;
				return true;
			} else {
				return false;
			}
		} catch (@Pc(116) RuntimeException local116) {
			signlink.reporterror("87437, " + arg0 + ", " + arg1 + ", " + local116.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(ILclient!kb;I)V")
	private void method181(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 < 0) {
				arg1.method401(223);
				@Pc(14) int local14 = arg1.method402(9, 8);
				@Pc(20) int local20;
				if (local14 < this.anInt248) {
					for (local20 = local14; local20 < this.anInt248; local20++) {
						this.anIntArray60[this.anInt255++] = this.anIntArray58[local20];
					}
				}
				if (local14 > this.anInt248) {
					signlink.reporterror(this.aString13 + " Too many npcs");
					throw new RuntimeException("eek");
				}
				this.anInt248 = 0;
				for (local20 = 0; local20 < local14; local20++) {
					@Pc(72) int local72 = this.anIntArray58[local20];
					@Pc(77) Class1_Sub1_Sub3_Sub1 local77 = this.aClass1_Sub1_Sub3_Sub1Array1[local72];
					@Pc(82) int local82 = arg1.method402(9, 1);
					if (local82 == 0) {
						this.anIntArray58[this.anInt248++] = local72;
						local77.anInt924 = Static6.anInt266;
					} else {
						@Pc(105) int local105 = arg1.method402(9, 2);
						if (local105 == 0) {
							this.anIntArray58[this.anInt248++] = local72;
							local77.anInt924 = Static6.anInt266;
							this.anIntArray40[this.anInt206++] = local72;
						} else {
							@Pc(156) int local156;
							@Pc(166) int local166;
							if (local105 == 1) {
								this.anIntArray58[this.anInt248++] = local72;
								local77.anInt924 = Static6.anInt266;
								local156 = arg1.method402(9, 3);
								local77.method570(false, local156, (byte) 6);
								local166 = arg1.method402(9, 1);
								if (local166 == 1) {
									this.anIntArray40[this.anInt206++] = local72;
								}
							} else if (local105 == 2) {
								this.anIntArray58[this.anInt248++] = local72;
								local77.anInt924 = Static6.anInt266;
								local156 = arg1.method402(9, 3);
								local77.method570(true, local156, (byte) 6);
								local166 = arg1.method402(9, 3);
								local77.method570(true, local166, (byte) 6);
								@Pc(224) int local224 = arg1.method402(9, 1);
								if (local224 == 1) {
									this.anIntArray40[this.anInt206++] = local72;
								}
							} else if (local105 == 3) {
								this.anIntArray60[this.anInt255++] = local72;
							}
						}
					}
				}
			}
		} catch (@Pc(261) RuntimeException local261) {
			signlink.reporterror("55760, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local261.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "getParameter", descriptor = "(Ljava/lang/String;)Ljava/lang/String;")
	@Override
	public String getParameter(@OriginalArg(0) String arg0) {
		return signlink.mainapp == null ? super.getParameter(arg0) : signlink.mainapp.getParameter(arg0);
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(Z)V")
	private void method182(@OriginalArg(0) boolean arg0) {
		try {
			if (this.anInt182 > 0) {
				this.method119(-780);
			} else {
				this.aClass32_27.method463((byte) 62);
				if (arg0) {
					this.method67();
				}
				this.aClass1_Sub3_Sub2_Sub4_2.method362(144, (byte) 6, 0, "Connection lost", 257);
				this.aClass1_Sub3_Sub2_Sub4_2.method362(143, (byte) 6, 16777215, "Connection lost", 256);
				this.aClass1_Sub3_Sub2_Sub4_2.method362(159, (byte) 6, 0, "Please wait - attempting to reestablish", 257);
				this.aClass1_Sub3_Sub2_Sub4_2.method362(158, (byte) 6, 16777215, "Please wait - attempting to reestablish", 256);
				this.aClass32_27.method464(11, super.aGraphics2, 8, 5193);
				this.anInt296 = 0;
				@Pc(60) Class6 local60 = this.aClass6_1;
				this.aBoolean62 = false;
				this.method159(this.aString13, this.aString14, true);
				if (!this.aBoolean62) {
					this.method119(-780);
				}
				try {
					local60.method201();
				} catch (@Pc(80) Exception local80) {
				}
			}
		} catch (@Pc(82) RuntimeException local82) {
			signlink.reporterror("55264, " + arg0 + ", " + local82.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!ib;)V")
	private void method183(@OriginalArg(0) int arg0, @OriginalArg(1) Class1_Sub3_Sub2_Sub3 arg1) {
		try {
			@Pc(3) short local3 = 256;
			for (@Pc(5) int local5 = 0; local5 < this.anIntArray41.length; local5++) {
				this.anIntArray41[local5] = 0;
			}
			@Pc(30) int local30;
			for (@Pc(20) int local20 = 0; local20 < 5000; local20++) {
				local30 = (int) (Math.random() * 128.0D * (double) local3);
				this.anIntArray41[local30] = (int) (Math.random() * 256.0D);
			}
			@Pc(48) int local48;
			@Pc(52) int local52;
			@Pc(60) int local60;
			for (local30 = 0; local30 < 20; local30++) {
				for (local48 = 1; local48 < local3 - 1; local48++) {
					for (local52 = 1; local52 < 127; local52++) {
						local60 = local52 + (local48 << 7);
						this.anIntArray42[local60] = (this.anIntArray41[local60 - 1] + this.anIntArray41[local60 + 1] + this.anIntArray41[local60 - 128] + this.anIntArray41[local60 + 128]) / 4;
					}
				}
				@Pc(106) int[] local106 = this.anIntArray41;
				this.anIntArray41 = this.anIntArray42;
				this.anIntArray42 = local106;
			}
			if (arg0 <= 0) {
				this.aBoolean55 = !this.aBoolean55;
			}
			if (arg1 != null) {
				local48 = 0;
				for (local52 = 0; local52 < arg1.anInt514; local52++) {
					for (local60 = 0; local60 < arg1.anInt513; local60++) {
						if (arg1.aByteArray6[local48++] != 0) {
							@Pc(152) int local152 = local60 + arg1.anInt515 + 16;
							@Pc(159) int local159 = local52 + arg1.anInt516 + 16;
							@Pc(165) int local165 = local152 + (local159 << 7);
							this.anIntArray41[local165] = 0;
						}
					}
				}
			}
		} catch (@Pc(182) RuntimeException local182) {
			signlink.reporterror("86499, " + arg0 + ", " + arg1 + ", " + local182.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(II)V")
	private void method184(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(9) Class28 local9 = this.aClass28ArrayArrayArray1[this.anInt231][arg0][arg1];
		if (local9 == null) {
			this.aClass33_1.method493(this.anInt231, arg0, arg1);
			return;
		}
		@Pc(21) int local21 = -99999999;
		@Pc(23) Class1_Sub7 local23 = null;
		@Pc(27) Class1_Sub7 local27;
		@Pc(35) int local35;
		for (local27 = (Class1_Sub7) local9.method456(); local27 != null; local27 = (Class1_Sub7) local9.method458(551)) {
			@Pc(32) Class5 local32 = Static5.method54(local27.anInt765);
			local35 = local32.anInt112;
			if (local32.aBoolean31) {
				local35 *= local27.anInt766 + 1;
			}
			if (local35 > local21) {
				local21 = local35;
				local23 = local27;
			}
		}
		local9.method454(local23, -26173);
		@Pc(65) int local65 = -1;
		local35 = -1;
		@Pc(69) int local69 = 0;
		@Pc(71) int local71 = 0;
		for (local27 = (Class1_Sub7) local9.method456(); local27 != null; local27 = (Class1_Sub7) local9.method458(551)) {
			if (local27.anInt765 != local23.anInt765 && local65 == -1) {
				local65 = local27.anInt765;
				local69 = local27.anInt766;
			}
			if (local27.anInt765 != local23.anInt765 && local27.anInt765 != local65 && local35 == -1) {
				local35 = local27.anInt765;
				local71 = local27.anInt766;
			}
		}
		@Pc(118) Class1_Sub3_Sub1 local118 = null;
		if (local65 != -1) {
			local118 = Static5.method54(local65).method58(local69);
		}
		@Pc(128) Class1_Sub3_Sub1 local128 = null;
		if (local35 != -1) {
			local128 = Static5.method54(local35).method58(local71);
		}
		@Pc(144) int local144 = arg0 + (arg1 << 7) + 1610612736;
		@Pc(148) Class5 local148 = Static5.method54(local23.anInt765);
		this.aClass33_1.method474(local148.method58(local23.anInt766), local118, this.method94(this.anInt231, arg0 * 128 + 64, (byte) 5, arg1 * 128 + 64), this.anInt231, local144, arg1, arg0, local128, 429);
	}

	@OriginalMember(owner = "client!client", name = "D", descriptor = "(I)V")
	private void method185(@OriginalArg(0) int arg0) {
		try {
			try {
				this.anInt176 = -1;
				this.aClass28_2.method460();
				this.aClass28_1.method460();
				this.aClass28_5.method460();
				this.aClass28_3.method460();
				Static15.method290(false);
				this.method144(this.aByte10);
				this.aClass33_1.method467(742);
				for (@Pc(28) int local28 = 0; local28 < 4; local28++) {
					this.aClass9Array1[local28].method249((byte) 74);
				}
				System.gc();
				@Pc(53) Class4 local53 = new Class4(104, this.aByteArrayArrayArray7, 104, this.anIntArrayArrayArray3, this.anInt318);
				@Pc(56) byte[] local56 = new byte[100000];
				@Pc(60) int local60 = this.aByteArrayArray1.length;
				Static4.aBoolean23 = Static25.aBoolean143;
				@Pc(73) int local73;
				@Pc(80) int local80;
				for (@Pc(64) int local64 = 0; local64 < local60; local64++) {
					local73 = this.anIntArray56[local64] >> 8;
					local80 = this.anIntArray56[local64] & 0xFF;
					if (local73 == 33 && local80 >= 71 && local80 <= 73) {
						Static4.aBoolean23 = false;
					}
				}
				if (Static4.aBoolean23) {
					this.aClass33_1.method468(0, this.anInt231);
				} else {
					this.aClass33_1.method468(0, 0);
				}
				this.aClass1_Sub3_Sub3_6.method380((byte) -34, 108);
				@Pc(157) int local157;
				for (local73 = 0; local73 < local60; local73++) {
					local80 = (this.anIntArray56[local73] >> 8) * 64 - this.anInt169;
					@Pc(143) int local143 = (this.anIntArray56[local73] & 0xFF) * 64 - this.anInt170;
					@Pc(148) byte[] local148 = this.aByteArrayArray1[local73];
					if (local148 != null) {
						local157 = (new Class1_Sub3_Sub3(363, local148)).method396();
						Static26.method519(local56, local157, local148, local148.length - 4, 4);
						local53.method37(local56, (this.anInt212 - 6) * 8, 1, local143, local80, (this.anInt213 - 6) * 8);
					} else if (this.anInt213 < 800) {
						local53.method36(local80, local143, 3, 64, 64);
					}
				}
				this.aClass1_Sub3_Sub3_6.method380((byte) -34, 108);
				@Pc(225) int local225;
				for (local80 = 0; local80 < local60; local80++) {
					@Pc(216) byte[] local216 = this.aByteArrayArray2[local80];
					if (local216 != null) {
						local225 = (new Class1_Sub3_Sub3(363, local216)).method396();
						Static26.method519(local56, local225, local216, local216.length - 4, 4);
						local157 = (this.anIntArray56[local80] >> 8) * 64 - this.anInt169;
						@Pc(259) int local259 = (this.anIntArray56[local80] & 0xFF) * 64 - this.anInt170;
						local53.method38(local56, this.aClass33_1, this.aClass9Array1, this.aClass28_1, true, local259, local157);
					}
				}
				this.aClass1_Sub3_Sub3_6.method380((byte) -34, 108);
				local53.method40(this.aClass33_1, -270, this.aClass9Array1);
				this.aClass32_27.method463((byte) 62);
				this.aClass1_Sub3_Sub3_6.method380((byte) -34, 108);
				for (@Pc(301) Class1_Sub6 local301 = (Class1_Sub6) this.aClass28_1.method456(); local301 != null; local301 = (Class1_Sub6) this.aClass28_1.method458(551)) {
					if ((this.aByteArrayArrayArray7[1][local301.anInt653][local301.anInt654] & 0x2) == 2) {
						local301.anInt651--;
						if (local301.anInt651 < 0) {
							local301.method567();
						}
					}
				}
				for (local225 = 0; local225 < 104; local225++) {
					for (local157 = 0; local157 < 104; local157++) {
						this.method184(local225, local157);
					}
				}
				for (@Pc(361) Class1_Sub4 local361 = (Class1_Sub4) this.aClass28_4.method456(); local361 != null; local361 = (Class1_Sub4) this.aClass28_4.method458(551)) {
					this.method160(local361.anInt598, local361.anInt595, local361.anInt596, local361.anInt594, local361.anInt597, local361.anInt599, -27819, local361.anInt593);
				}
			} catch (@Pc(390) Exception local390) {
			}
			Static2.aClass35_1.method529();
			if (arg0 <= 0) {
				this.aBoolean72 = !this.aBoolean72;
			}
			System.gc();
			Static15.method291(20, -20);
		} catch (@Pc(408) RuntimeException local408) {
			signlink.reporterror("85866, " + arg0 + ", " + local408.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(I)V")
	@Override
	protected void method68(@OriginalArg(0) int arg0) {
		try {
			if (!this.aBoolean67 && !this.aBoolean46 && !this.aBoolean57) {
				Static6.anInt266++;
				if (arg0 > 0) {
					if (this.aBoolean62) {
						this.method164(true);
					} else {
						this.method97((byte) -70);
					}
				}
			}
		} catch (@Pc(28) RuntimeException local28) {
			signlink.reporterror("41957, " + arg0 + ", " + local28.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(B)V")
	private void method186(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != 94) {
				this.method67();
			}
			@Pc(16) int local16;
			for (@Pc(8) int local8 = -1; local8 < this.anInt205; local8++) {
				if (local8 == -1) {
					local16 = this.anInt204;
				} else {
					local16 = this.anIntArray39[local8];
				}
				@Pc(28) Class1_Sub1_Sub3_Sub2 local28 = this.aClass1_Sub1_Sub3_Sub2Array1[local16];
				if (local28 != null && local28.anInt893 > 0) {
					local28.anInt893--;
					if (local28.anInt893 == 0) {
						local28.aString28 = null;
					}
				}
			}
			for (local16 = 0; local16 < this.anInt248; local16++) {
				@Pc(59) int local59 = this.anIntArray58[local16];
				@Pc(64) Class1_Sub1_Sub3_Sub1 local64 = this.aClass1_Sub1_Sub3_Sub1Array1[local59];
				if (local64 != null && local64.anInt893 > 0) {
					local64.anInt893--;
					if (local64.anInt893 == 0) {
						local64.aString28 = null;
					}
				}
			}
		} catch (@Pc(88) RuntimeException local88) {
			signlink.reporterror("25131, " + arg0 + ", " + local88.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;ZI)I")
	private int method187(@OriginalArg(0) Class15 arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg1) {
				this.aBoolean44 = !this.aBoolean44;
			}
			if (arg0.anIntArrayArray15 == null || arg2 >= arg0.anIntArrayArray15.length) {
				return -2;
			}
			try {
				@Pc(26) int[] local26 = arg0.anIntArrayArray15[arg2];
				@Pc(28) int local28 = 0;
				@Pc(30) int local30 = 0;
				while (true) {
					@Pc(35) int local35 = local26[local30++];
					if (local35 == 0) {
						return local28;
					}
					if (local35 == 1) {
						local28 += this.anIntArray36[local26[local30++]];
					}
					if (local35 == 2) {
						local28 += this.anIntArray57[local26[local30++]];
					}
					if (local35 == 3) {
						local28 += this.anIntArray72[local26[local30++]];
					}
					@Pc(88) Class15 local88;
					@Pc(95) int local95;
					@Pc(97) int local97;
					if (local35 == 4) {
						local88 = Static17.aClass15Array1[local26[local30++]];
						local95 = local26[local30++] + 1;
						for (local97 = 0; local97 < local88.anIntArray149.length; local97++) {
							if (local88.anIntArray149[local97] == local95) {
								local28 += local88.anIntArray150[local97];
							}
						}
					}
					if (local35 == 5) {
						local28 += this.anIntArray59[local26[local30++]];
					}
					if (local35 == 6) {
						local28 += anIntArray47[this.anIntArray57[local26[local30++]] - 1];
					}
					if (local35 == 7) {
						local28 += this.anIntArray59[local26[local30++]] * 100 / 46875;
					}
					if (local35 == 8) {
						local28 += this.aClass1_Sub1_Sub3_Sub2_1.anInt932;
					}
					@Pc(179) int local179;
					if (local35 == 9) {
						for (local179 = 0; local179 < 19; local179++) {
							if (local179 == 18) {
								local179 = 20;
							}
							local28 += this.anIntArray57[local179];
						}
					}
					if (local35 == 10) {
						local88 = Static17.aClass15Array1[local26[local30++]];
						local95 = local26[local30++] + 1;
						for (local97 = 0; local97 < local88.anIntArray149.length; local97++) {
							if (local88.anIntArray149[local97] == local95) {
								local28 += 999999999;
								break;
							}
						}
					}
					if (local35 == 11) {
						local28 += this.anInt303;
					}
					if (local35 == 12) {
						local28 += this.anInt173;
					}
					if (local35 == 13) {
						local179 = this.anIntArray59[local26[local30++]];
						local95 = local26[local30++];
						local28 += (local179 & 0x1 << local95) == 0 ? 0 : 1;
					}
				}
			} catch (@Pc(282) Exception local282) {
				return -1;
			}
		} catch (@Pc(285) RuntimeException local285) {
			signlink.reporterror("5084, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local285.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(Z)V")
	private void method188(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(4) Graphics local4 = this.method72(Static6.aByte16).getGraphics();
			local4.setColor(Color.black);
			local4.fillRect(0, 0, 789, 532);
			this.method65(386, 1);
			if (arg0) {
				this.method67();
			}
			@Pc(40) byte local40;
			@Pc(46) int local46;
			if (this.aBoolean46) {
				this.aBoolean54 = false;
				local4.setFont(new Font("Helvetica", 1, 16));
				local4.setColor(Color.yellow);
				local40 = 35;
				local4.drawString("Sorry, an error has occured whilst loading RuneScape", 30, local40);
				local46 = local40 + 50;
				local4.setColor(Color.white);
				local4.drawString("To fix this try the following (in order):", 30, local46);
				@Pc(55) int local55 = local46 + 50;
				local4.setColor(Color.white);
				local4.setFont(new Font("Helvetica", 1, 12));
				local4.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, local55);
				@Pc(72) int local72 = local55 + 30;
				local4.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, local72);
				@Pc(78) int local78 = local72 + 30;
				local4.drawString("3: Try using a different game-world", 30, local78);
				@Pc(84) int local84 = local78 + 30;
				local4.drawString("4: Try rebooting your computer", 30, local84);
				@Pc(90) int local90 = local84 + 30;
				local4.drawString("5: Try selecting a different version of Java from the play-game menu", 30, local90);
			}
			if (this.aBoolean57) {
				this.aBoolean54 = false;
				local4.setFont(new Font("Helvetica", 1, 20));
				local4.setColor(Color.white);
				local4.drawString("Error - unable to load game!", 50, 50);
				local4.drawString("To play RuneScape make sure you play from", 50, 100);
				local4.drawString("http://www.runescape.com", 50, 150);
			}
			if (this.aBoolean67) {
				this.aBoolean54 = false;
				local4.setColor(Color.yellow);
				local40 = 35;
				local4.drawString("Error a copy of RuneScape already appears to be loaded", 30, local40);
				local46 = local40 + 50;
				local4.setColor(Color.white);
				local4.drawString("To fix this try the following (in order):", 30, local46);
				local46 += 50;
				local4.setColor(Color.white);
				local4.setFont(new Font("Helvetica", 1, 12));
				local4.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, local46);
				local46 += 30;
				local4.drawString("2: Try rebooting your computer, and reloading", 30, local46);
				local46 += 30;
			}
		} catch (@Pc(178) RuntimeException local178) {
			signlink.reporterror("19392, " + arg0 + ", " + local178.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(B)V")
	private void method189(@OriginalArg(0) byte arg0) {
		try {
			@Pc(8) byte[] local8 = this.aClass39_1.method536("title.dat", null, (byte) 2);
			@Pc(14) Class1_Sub3_Sub2_Sub2 local14 = new Class1_Sub3_Sub2_Sub2(local8, this);
			this.aClass32_19.method463((byte) 62);
			local14.method320(34676, 0, 0);
			this.aClass32_20.method463((byte) 62);
			local14.method320(34676, -661, 0);
			this.aClass32_16.method463((byte) 62);
			local14.method320(34676, -128, 0);
			this.aClass32_17.method463((byte) 62);
			local14.method320(34676, -214, -386);
			this.aClass32_18.method463((byte) 62);
			local14.method320(34676, -214, -186);
			this.aClass32_21.method463((byte) 62);
			local14.method320(34676, 0, -265);
			this.aClass32_22.method463((byte) 62);
			local14.method320(34676, -574, -265);
			this.aClass32_23.method463((byte) 62);
			if (arg0 != 5) {
				this.aBoolean55 = !this.aBoolean55;
			}
			local14.method320(34676, -128, -186);
			this.aClass32_24.method463((byte) 62);
			local14.method320(34676, -574, -186);
			@Pc(110) int[] local110 = new int[local14.anInt461];
			for (@Pc(112) int local112 = 0; local112 < local14.anInt462; local112++) {
				for (@Pc(116) int local116 = 0; local116 < local14.anInt461; local116++) {
					local110[local116] = local14.anIntArray148[local14.anInt461 + local14.anInt461 * local112 - local116 - 1];
				}
				for (@Pc(142) int local142 = 0; local142 < local14.anInt461; local142++) {
					local14.anIntArray148[local142 + local14.anInt461 * local112] = local110[local142];
				}
			}
			this.aClass32_19.method463((byte) 62);
			local14.method320(34676, 394, 0);
			this.aClass32_20.method463((byte) 62);
			local14.method320(34676, -267, 0);
			this.aClass32_16.method463((byte) 62);
			local14.method320(34676, 266, 0);
			this.aClass32_17.method463((byte) 62);
			local14.method320(34676, 180, -386);
			this.aClass32_18.method463((byte) 62);
			local14.method320(34676, 180, -186);
			this.aClass32_21.method463((byte) 62);
			local14.method320(34676, 394, -265);
			this.aClass32_22.method463((byte) 62);
			local14.method320(34676, -180, -265);
			this.aClass32_23.method463((byte) 62);
			local14.method320(34676, 212, -186);
			this.aClass32_24.method463((byte) 62);
			local14.method320(34676, -180, -186);
			local14 = new Class1_Sub3_Sub2_Sub2(this.aClass39_1, "logo", 0);
			this.aClass32_16.method463((byte) 62);
			local14.method322(18, super.anInt131 / 2 - local14.anInt461 / 2 - 128, false);
			local14 = null;
			@Pc(278) Object local278 = null;
			@Pc(280) Object local280 = null;
			System.gc();
		} catch (@Pc(283) RuntimeException local283) {
			signlink.reporterror("21255, " + arg0 + ", " + local283.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "E", descriptor = "(I)V")
	private void method190(@OriginalArg(0) int arg0) {
		try {
			@Pc(5) int local5 = 30 / arg0;
			for (@Pc(10) Class1_Sub6 local10 = (Class1_Sub6) this.aClass28_1.method456(); local10 != null; local10 = (Class1_Sub6) this.aClass28_1.method458(551)) {
				@Pc(14) boolean local14 = false;
				local10.anInt657 += this.anInt270;
				if (local10.anInt656 == -1) {
					local10.anInt656 = 0;
					local14 = true;
				}
				label70: {
					do {
						do {
							if (local10.anInt657 <= local10.aClass19_2.anIntArray188[local10.anInt656]) {
								break label70;
							}
							local10.anInt657 -= local10.aClass19_2.anIntArray188[local10.anInt656] + 1;
							local10.anInt656++;
							local14 = true;
						} while (local10.anInt656 < local10.aClass19_2.anInt543);
						local10.anInt656 -= local10.aClass19_2.anInt544;
					} while (local10.anInt656 >= 0 && local10.anInt656 < local10.aClass19_2.anInt543);
					local10.method567();
					local14 = false;
				}
				if (local14) {
					@Pc(96) int local96 = local10.anInt651;
					@Pc(99) int local99 = local10.anInt653;
					@Pc(102) int local102 = local10.anInt654;
					@Pc(104) int local104 = 0;
					if (local10.anInt652 == 0) {
						local104 = this.aClass33_1.method494(local96, local99, local102);
					}
					if (local10.anInt652 == 1) {
						local104 = this.aClass33_1.method495(local96, local102, 3, local99);
					}
					if (local10.anInt652 == 2) {
						local104 = this.aClass33_1.method496(local96, local99, local102);
					}
					if (local10.anInt652 == 3) {
						local104 = this.aClass33_1.method497(local96, local99, local102);
					}
					if (local104 != 0 && (local104 >> 14 & 0x7FFF) == local10.anInt655) {
						@Pc(171) int local171 = this.anIntArrayArrayArray3[local96][local99][local102];
						@Pc(182) int local182 = this.anIntArrayArrayArray3[local96][local99 + 1][local102];
						@Pc(195) int local195 = this.anIntArrayArrayArray3[local96][local99 + 1][local102 + 1];
						@Pc(206) int local206 = this.anIntArrayArrayArray3[local96][local99][local102 + 1];
						@Pc(210) Class2 local210 = Static2.method23(local10.anInt655);
						@Pc(212) int local212 = -1;
						if (local10.anInt656 != -1) {
							local212 = local10.aClass19_2.anIntArray186[local10.anInt656];
						}
						@Pc(235) int local235;
						@Pc(239) int local239;
						@Pc(243) int local243;
						@Pc(258) Class1_Sub3_Sub1 local258;
						if (local10.anInt652 == 2) {
							local235 = this.aClass33_1.method498(local96, local99, local102, local104);
							local239 = local235 & 0x1F;
							local243 = local235 >> 6;
							if (local239 == 11) {
								local239 = 10;
							}
							local258 = local210.method26(local239, local243, local171, local182, local195, local206, local212);
							this.aClass33_1.method483(local99, local258, 1, local96, local102);
						} else if (local10.anInt652 == 1) {
							@Pc(282) Class1_Sub3_Sub1 local282 = local210.method26(4, 0, local171, local182, local195, local206, local212);
							this.aClass33_1.method485(266, local102, local99, local282, local96);
						} else if (local10.anInt652 == 0) {
							local235 = this.aClass33_1.method498(local96, local99, local102, local104);
							local239 = local235 & 0x1F;
							local243 = local235 >> 6;
							if (local239 == 2) {
								@Pc(320) int local320 = local243 + 1 & 0x3;
								@Pc(332) Class1_Sub3_Sub1 local332 = local210.method26(2, local243 + 4, local171, local182, local195, local206, local212);
								@Pc(342) Class1_Sub3_Sub1 local342 = local210.method26(2, local320, local171, local182, local195, local206, local212);
								this.aClass33_1.method488(local332, local342, local102, this.aBoolean44, local99, local96);
							} else {
								local258 = local210.method26(local239, local243, local171, local182, local195, local206, local212);
								this.aClass33_1.method487(35568, local258, local102, local99, local96);
							}
						} else if (local10.anInt652 == 3) {
							local235 = this.aClass33_1.method498(local96, local99, local102, local104);
							local239 = local235 >> 6;
							@Pc(400) Class1_Sub3_Sub1 local400 = local210.method26(22, local239, local171, local182, local195, local206, local212);
							this.aClass33_1.method486(local400, local102, -48639, local99, local96);
						}
					} else {
						local10.method567();
					}
				}
			}
		} catch (@Pc(418) RuntimeException local418) {
			signlink.reporterror("25821, " + arg0 + ", " + local418.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IJ)V")
	private void method191(@OriginalArg(0) int arg0, @OriginalArg(1) long arg1) {
		try {
			if (arg0 != 1) {
				this.anInt179 = -1;
			}
			if (arg1 != 0L) {
				for (@Pc(14) int local14 = 0; local14 < this.anInt186; local14++) {
					if (this.aLongArray3[local14] == arg1) {
						this.anInt186--;
						this.aBoolean59 = true;
						for (@Pc(34) int local34 = local14; local34 < this.anInt186; local34++) {
							this.aLongArray3[local34] = this.aLongArray3[local34 + 1];
						}
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 171);
						this.aClass1_Sub3_Sub3_6.method387(true, arg1);
						return;
					}
				}
			}
		} catch (@Pc(69) RuntimeException local69) {
			signlink.reporterror("36301, " + arg0 + ", " + arg1 + ", " + local69.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "q", descriptor = "(B)V")
	private void method192(@OriginalArg(0) byte arg0) {
		try {
			if (this.anInt281 == 0 && this.anInt291 == 0) {
				this.aStringArray5[this.anInt304] = "Walk here";
				this.anIntArray86[this.anInt304] = 660;
				this.anIntArray84[this.anInt304] = super.anInt135;
				this.anIntArray85[this.anInt304] = super.anInt136;
				this.anInt304++;
			}
			@Pc(41) int local41 = -1;
			if (arg0 != 2) {
				Static6.aBoolean48 = !Static6.aBoolean48;
			}
			for (@Pc(52) int local52 = 0; local52 < Static10.anInt378; local52++) {
				@Pc(58) int local58 = Static10.anIntArray123[local52];
				@Pc(62) int local62 = local58 & 0x7F;
				@Pc(68) int local68 = local58 >> 7 & 0x7F;
				@Pc(74) int local74 = local58 >> 29 & 0x3;
				@Pc(80) int local80 = local58 >> 14 & 0x7FFF;
				if (local58 != local41) {
					local41 = local58;
					@Pc(218) int local218;
					if (local74 == 2 && this.aClass33_1.method498(this.anInt231, local62, local68, local58) >= 0) {
						@Pc(100) Class2 local100 = Static2.method23(local80);
						if (this.anInt281 == 1) {
							this.aStringArray5[this.anInt304] = "Use " + this.aString10 + " with @cya@" + local100.aString1;
							this.anIntArray86[this.anInt304] = 450;
							this.anIntArray87[this.anInt304] = local58;
							this.anIntArray84[this.anInt304] = local62;
							this.anIntArray85[this.anInt304] = local68;
							this.anInt304++;
						} else if (this.anInt291 != 1) {
							if (local100.aStringArray1 != null) {
								for (local218 = 4; local218 >= 0; local218--) {
									if (local100.aStringArray1[local218] != null) {
										this.aStringArray5[this.anInt304] = local100.aStringArray1[local218] + " @cya@" + local100.aString1;
										if (local218 == 0) {
											this.anIntArray86[this.anInt304] = 285;
										}
										if (local218 == 1) {
											this.anIntArray86[this.anInt304] = 504;
										}
										if (local218 == 2) {
											this.anIntArray86[this.anInt304] = 364;
										}
										if (local218 == 3) {
											this.anIntArray86[this.anInt304] = 581;
										}
										if (local218 == 4) {
											this.anIntArray86[this.anInt304] = 1501;
										}
										this.anIntArray87[this.anInt304] = local58;
										this.anIntArray84[this.anInt304] = local62;
										this.anIntArray85[this.anInt304] = local68;
										this.anInt304++;
									}
								}
							}
							this.aStringArray5[this.anInt304] = "Examine @cya@" + local100.aString1;
							this.anIntArray86[this.anInt304] = 1175;
							this.anIntArray87[this.anInt304] = local58;
							this.anIntArray84[this.anInt304] = local62;
							this.anIntArray85[this.anInt304] = local68;
							this.anInt304++;
						} else if ((this.anInt293 & 0x4) == 4) {
							this.aStringArray5[this.anInt304] = this.aString11 + " @cya@" + local100.aString1;
							this.anIntArray86[this.anInt304] = 55;
							this.anIntArray87[this.anInt304] = local58;
							this.anIntArray84[this.anInt304] = local62;
							this.anIntArray85[this.anInt304] = local68;
							this.anInt304++;
						}
					}
					@Pc(395) Class1_Sub1_Sub3_Sub1 local395;
					if (local74 == 1) {
						@Pc(366) Class1_Sub1_Sub3_Sub1 local366 = this.aClass1_Sub1_Sub3_Sub1Array1[local80];
						if (local366.aClass3_1.aByte4 == 1 && (local366.anInt882 & 0x7F) == 64 && (local366.anInt883 & 0x7F) == 64) {
							for (local218 = 0; local218 < this.anInt248; local218++) {
								local395 = this.aClass1_Sub1_Sub3_Sub1Array1[this.anIntArray58[local218]];
								if (local395 != null && local395 != local366 && local395.aClass3_1.aByte4 == 1 && local395.anInt882 == local366.anInt882 && local395.anInt883 == local366.anInt883) {
									this.method95(local395.aClass3_1, -641, local68, local62, this.anIntArray58[local218]);
								}
							}
						}
						this.method95(local366.aClass3_1, -641, local68, local62, local80);
					}
					if (local74 == 0) {
						@Pc(446) Class1_Sub1_Sub3_Sub2 local446 = this.aClass1_Sub1_Sub3_Sub2Array1[local80];
						if ((local446.anInt882 & 0x7F) == 64 && (local446.anInt883 & 0x7F) == 64) {
							for (local218 = 0; local218 < this.anInt248; local218++) {
								local395 = this.aClass1_Sub1_Sub3_Sub1Array1[this.anIntArray58[local218]];
								if (local395 != null && local395.aClass3_1.aByte4 == 1 && local395.anInt882 == local446.anInt882 && local395.anInt883 == local446.anInt883) {
									this.method95(local395.aClass3_1, -641, local68, local62, this.anIntArray58[local218]);
								}
							}
							for (@Pc(505) int local505 = 0; local505 < this.anInt205; local505++) {
								@Pc(515) Class1_Sub1_Sub3_Sub2 local515 = this.aClass1_Sub1_Sub3_Sub2Array1[this.anIntArray39[local505]];
								if (local515 != null && local515 != local446 && local515.anInt882 == local446.anInt882 && local515.anInt883 == local446.anInt883) {
									this.method163(false, local68, this.anIntArray39[local505], local515, local62);
								}
							}
						}
						this.method163(false, local68, local80, local446, local62);
					}
					if (local74 == 3) {
						@Pc(565) Class28 local565 = this.aClass28ArrayArrayArray1[this.anInt231][local62][local68];
						if (local565 != null) {
							for (@Pc(572) Class1_Sub7 local572 = (Class1_Sub7) local565.method457((byte) 2); local572 != null; local572 = (Class1_Sub7) local565.method459(false)) {
								@Pc(578) Class5 local578 = Static5.method54(local572.anInt765);
								if (this.anInt281 == 1) {
									this.aStringArray5[this.anInt304] = "Use " + this.aString10 + " with @lre@" + local578.aString3;
									this.anIntArray86[this.anInt304] = 217;
									this.anIntArray87[this.anInt304] = local572.anInt765;
									this.anIntArray84[this.anInt304] = local62;
									this.anIntArray85[this.anInt304] = local68;
									this.anInt304++;
								} else if (this.anInt291 != 1) {
									for (@Pc(695) int local695 = 4; local695 >= 0; local695--) {
										if (local578.aStringArray3 != null && local578.aStringArray3[local695] != null) {
											this.aStringArray5[this.anInt304] = local578.aStringArray3[local695] + " @lre@" + local578.aString3;
											if (local695 == 0) {
												this.anIntArray86[this.anInt304] = 224;
											}
											if (local695 == 1) {
												this.anIntArray86[this.anInt304] = 993;
											}
											if (local695 == 2) {
												this.anIntArray86[this.anInt304] = 99;
											}
											if (local695 == 3) {
												this.anIntArray86[this.anInt304] = 746;
											}
											if (local695 == 4) {
												this.anIntArray86[this.anInt304] = 877;
											}
											this.anIntArray87[this.anInt304] = local572.anInt765;
											this.anIntArray84[this.anInt304] = local62;
											this.anIntArray85[this.anInt304] = local68;
											this.anInt304++;
										} else if (local695 == 2) {
											this.aStringArray5[this.anInt304] = "Take @lre@" + local578.aString3;
											this.anIntArray86[this.anInt304] = 99;
											this.anIntArray87[this.anInt304] = local572.anInt765;
											this.anIntArray84[this.anInt304] = local62;
											this.anIntArray85[this.anInt304] = local68;
											this.anInt304++;
										}
									}
									this.aStringArray5[this.anInt304] = "Examine @lre@" + local578.aString3;
									this.anIntArray86[this.anInt304] = 1102;
									this.anIntArray87[this.anInt304] = local572.anInt765;
									this.anIntArray84[this.anInt304] = local62;
									this.anIntArray85[this.anInt304] = local68;
									this.anInt304++;
								} else if ((this.anInt293 & 0x1) == 1) {
									this.aStringArray5[this.anInt304] = this.aString11 + " @lre@" + local578.aString3;
									this.anIntArray86[this.anInt304] = 965;
									this.anIntArray87[this.anInt304] = local572.anInt765;
									this.anIntArray84[this.anInt304] = local62;
									this.anIntArray85[this.anInt304] = local68;
									this.anInt304++;
								}
							}
						}
					}
				}
			}
		} catch (@Pc(902) RuntimeException local902) {
			signlink.reporterror("47222, " + arg0 + ", " + local902.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(Z)V")
	private void method193(@OriginalArg(0) boolean arg0) {
		try {
			this.aBoolean62 &= arg0;
			@Pc(17) int local17;
			for (@Pc(9) int local9 = -1; local9 < this.anInt205; local9++) {
				if (local9 == -1) {
					local17 = this.anInt204;
				} else {
					local17 = this.anIntArray39[local9];
				}
				@Pc(29) Class1_Sub1_Sub3_Sub2 local29 = this.aClass1_Sub1_Sub3_Sub2Array1[local17];
				if (local29 != null) {
					this.method124(local29, (byte) -128, 1);
				}
			}
			Static6.anInt242++;
			if (Static6.anInt242 > 1406) {
				Static6.anInt242 = 0;
				this.aClass1_Sub3_Sub3_6.method380((byte) -34, 219);
				this.aClass1_Sub3_Sub3_6.method381(0);
				local17 = this.aClass1_Sub3_Sub3_6.anInt561;
				this.aClass1_Sub3_Sub3_6.method381(162);
				this.aClass1_Sub3_Sub3_6.method381(22);
				if ((int) (Math.random() * 2.0D) == 0) {
					this.aClass1_Sub3_Sub3_6.method381(84);
				}
				this.aClass1_Sub3_Sub3_6.method382(31824);
				this.aClass1_Sub3_Sub3_6.method382(13490);
				if ((int) (Math.random() * 2.0D) == 0) {
					this.aClass1_Sub3_Sub3_6.method381(123);
				}
				if ((int) (Math.random() * 2.0D) == 0) {
					this.aClass1_Sub3_Sub3_6.method381(134);
				}
				this.aClass1_Sub3_Sub3_6.method381(100);
				this.aClass1_Sub3_Sub3_6.method381(94);
				this.aClass1_Sub3_Sub3_6.method382(35521);
				this.aClass1_Sub3_Sub3_6.method390(0, this.aClass1_Sub3_Sub3_6.anInt561 - local17);
			}
		} catch (@Pc(129) RuntimeException local129) {
			signlink.reporterror("87242, " + arg0 + ", " + local129.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "r", descriptor = "(B)V")
	private void method194(@OriginalArg(0) byte arg0) {
		try {
			if (this.anInt241 == 2) {
				this.method152((this.anInt159 - this.anInt170 << 7) + this.anInt162, (this.anInt158 - this.anInt169 << 7) + this.anInt161, this.anInt317, this.anInt160 * 2);
				if (arg0 != -11) {
					this.aBoolean72 = !this.aBoolean72;
				}
				if (this.anInt287 > -1 && Static6.anInt266 % 20 < 10) {
					this.aClass1_Sub3_Sub2_Sub2Array5[2].method322(this.anInt288 - 28, this.anInt287 - 12, false);
				}
			}
		} catch (@Pc(68) RuntimeException local68) {
			signlink.reporterror("792, " + arg0 + ", " + local68.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IILclient!kb;)V")
	private void method195(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Class1_Sub3_Sub3 arg2) {
		try {
			arg2.method401(223);
			@Pc(7) int local7 = arg2.method402(9, 1);
			if (arg0 != 11522) {
				this.aClass28ArrayArrayArray1 = null;
			}
			if (local7 != 0) {
				@Pc(21) int local21 = arg2.method402(9, 2);
				if (local21 == 0) {
					this.anIntArray40[this.anInt206++] = this.anInt204;
				} else {
					@Pc(44) int local44;
					@Pc(55) int local55;
					if (local21 == 1) {
						local44 = arg2.method402(9, 3);
						this.aClass1_Sub1_Sub3_Sub2_1.method570(false, local44, (byte) 6);
						local55 = arg2.method402(9, 1);
						if (local55 == 1) {
							this.anIntArray40[this.anInt206++] = this.anInt204;
						}
					} else {
						@Pc(101) int local101;
						if (local21 == 2) {
							local44 = arg2.method402(9, 3);
							this.aClass1_Sub1_Sub3_Sub2_1.method570(true, local44, (byte) 6);
							local55 = arg2.method402(9, 3);
							this.aClass1_Sub1_Sub3_Sub2_1.method570(true, local55, (byte) 6);
							local101 = arg2.method402(9, 1);
							if (local101 == 1) {
								this.anIntArray40[this.anInt206++] = this.anInt204;
							}
						} else if (local21 == 3) {
							this.anInt231 = arg2.method402(9, 2);
							local44 = arg2.method402(9, 7);
							local55 = arg2.method402(9, 7);
							local101 = arg2.method402(9, 1);
							this.aClass1_Sub1_Sub3_Sub2_1.method569(false, local101 == 1, local44, local55);
							@Pc(158) int local158 = arg2.method402(9, 1);
							if (local158 == 1) {
								this.anIntArray40[this.anInt206++] = this.anInt204;
							}
						}
					}
				}
			}
		} catch (@Pc(175) RuntimeException local175) {
			signlink.reporterror("31876, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local175.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(Z)V")
	private void method196(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				this.anInt179 = -1;
			}
			this.aClass32_28.method463((byte) 62);
			Static15.anIntArray139 = this.anIntArray30;
			this.aClass1_Sub3_Sub2_Sub3_11.method350(0, 0, false);
			if (this.aBoolean47) {
				this.aClass1_Sub3_Sub2_Sub4_3.method362(40, (byte) 6, 0, this.aString6, 239);
				this.aClass1_Sub3_Sub2_Sub4_3.method362(60, (byte) 6, 128, this.aString5 + "*", 239);
			} else if (this.aBoolean66) {
				this.aClass1_Sub3_Sub2_Sub4_3.method362(40, (byte) 6, 0, "Enter amount:", 239);
				this.aClass1_Sub3_Sub2_Sub4_3.method362(60, (byte) 6, 128, this.aString7 + "*", 239);
			} else if (this.aString8 != null) {
				this.aClass1_Sub3_Sub2_Sub4_3.method362(40, (byte) 6, 0, this.aString8, 239);
				this.aClass1_Sub3_Sub2_Sub4_3.method362(60, (byte) 6, 128, "Click to continue", 239);
			} else if (this.anInt280 != -1) {
				this.method120(0, 0, 38682, Static17.aClass15Array1[this.anInt280], 0);
			} else if (this.anInt289 == -1) {
				@Pc(135) Class1_Sub3_Sub2_Sub4 local135 = this.aClass1_Sub3_Sub2_Sub4_2;
				@Pc(137) int local137 = 0;
				Static12.method356(77, 0, 463, 789, 0);
				for (@Pc(145) int local145 = 0; local145 < 100; local145++) {
					if (this.aStringArray7[local145] != null) {
						@Pc(157) int local157 = this.anIntArray49[local145];
						@Pc(166) int local166 = this.anInt274 + 70 - local137 * 14;
						if (local157 == 0) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, this.aStringArray7[local145]);
							}
							local137++;
						}
						if (local157 == 1) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 16777215, this.aStringArray6[local145] + ":");
								local135.method365(local135.method364(false, this.aStringArray6[local145]) + 12, local166, false, 255, this.aStringArray7[local145]);
							}
							local137++;
						}
						if (local157 == 2 && (this.anInt273 == 0 || this.anInt273 == 1 && this.method199(-20, this.aStringArray6[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, this.aStringArray6[local145] + ":");
								local135.method365(local135.method364(false, this.aStringArray6[local145]) + 12, local166, false, 255, this.aStringArray7[local145]);
							}
							local137++;
						}
						if ((local157 == 3 || local157 == 7) && this.anInt210 == 0 && (local157 == 7 || this.anInt164 == 0 || this.anInt164 == 1 && this.method199(-20, this.aStringArray6[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, "From " + this.aStringArray6[local145] + ":");
								local135.method365(local135.method364(false, "From " + this.aStringArray6[local145]) + 12, local166, false, 8388608, this.aStringArray7[local145]);
							}
							local137++;
						}
						if (local157 == 4 && (this.anInt234 == 0 || this.anInt234 == 1 && this.method199(-20, this.aStringArray6[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 8388736, this.aStringArray6[local145] + " " + this.aStringArray7[local145]);
							}
							local137++;
						}
						if (local157 == 5 && this.anInt210 == 0 && this.anInt164 < 2) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 8388608, this.aStringArray7[local145]);
							}
							local137++;
						}
						if (local157 == 6 && this.anInt210 == 0 && this.anInt164 < 2) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, "To " + this.aStringArray6[local145] + ":");
								local135.method365(local135.method364(false, "To " + this.aStringArray6[local145]) + 12, local166, false, 8388608, this.aStringArray7[local145]);
							}
							local137++;
						}
						if (local157 == 8 && (this.anInt234 == 0 || this.anInt234 == 1 && this.method199(-20, this.aStringArray6[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 13350793, this.aStringArray6[local145] + " " + this.aStringArray7[local145]);
							}
							local137++;
						}
					}
				}
				Static12.method355(0);
				this.anInt185 = local137 * 14 + 7;
				if (this.anInt185 < 78) {
					this.anInt185 = 78;
				}
				this.method111(this.anInt192, 463, 0, this.anInt185 - this.anInt274 - 77, this.anInt185, 77);
				local135.method365(4, 90, false, 0, Static30.method542(0, this.aString13) + ":");
				local135.method365(local135.method364(false, this.aString13 + ": ") + 6, 90, false, 255, this.aString18 + "*");
				Static12.method360(0, 0, 77, 479, 0);
			} else {
				this.method120(0, 0, 38682, Static17.aClass15Array1[this.anInt289], 0);
			}
			if (this.aBoolean50 && this.anInt337 == 2) {
				this.method135(-961);
			}
			this.aClass32_28.method464(375, super.aGraphics2, 22, 5193);
			this.aClass32_27.method463((byte) 62);
			Static15.anIntArray139 = this.anIntArray32;
		} catch (@Pc(652) RuntimeException local652) {
			signlink.reporterror("15378, " + arg0 + ", " + local652.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(Z)Z")
	private boolean method197(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				this.aClass28ArrayArrayArray1 = null;
			}
			if (this.aClass6_1 == null) {
				return false;
			}
			@Pc(1264) String local1264;
			@Pc(462) int local462;
			try {
				@Pc(15) int local15 = this.aClass6_1.method203();
				if (local15 == 0) {
					return false;
				}
				if (this.anInt179 == -1) {
					this.aClass6_1.method204(this.aClass1_Sub3_Sub3_5.aByteArray7, 0, 1);
					this.anInt179 = this.aClass1_Sub3_Sub3_5.aByteArray7[0] & 0xFF;
					if (this.aClass38_1 != null) {
						this.anInt179 = this.anInt179 - this.aClass38_1.method532() & 0xFF;
					}
					this.anInt178 = Static8.anIntArray90[this.anInt179];
					local15--;
				}
				if (this.anInt178 == -1) {
					if (local15 <= 0) {
						return false;
					}
					this.aClass6_1.method204(this.aClass1_Sub3_Sub3_5.aByteArray7, 0, 1);
					this.anInt178 = this.aClass1_Sub3_Sub3_5.aByteArray7[0] & 0xFF;
					local15--;
				}
				if (this.anInt178 == -2) {
					if (local15 <= 1) {
						return false;
					}
					this.aClass6_1.method204(this.aClass1_Sub3_Sub3_5.aByteArray7, 0, 2);
					this.aClass1_Sub3_Sub3_5.anInt561 = 0;
					this.anInt178 = this.aClass1_Sub3_Sub3_5.method393();
					local15 -= 2;
				}
				if (local15 < this.anInt178) {
					return false;
				}
				this.aClass1_Sub3_Sub3_5.anInt561 = 0;
				this.aClass6_1.method204(this.aClass1_Sub3_Sub3_5.aByteArray7, 0, this.anInt178);
				this.anInt180 = 0;
				this.anInt209 = this.anInt208;
				this.anInt208 = this.anInt207;
				this.anInt207 = this.anInt179;
				@Pc(159) int local159;
				if (this.anInt179 == 150) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					@Pc(163) byte local163 = this.aClass1_Sub3_Sub3_5.method392();
					this.anIntArray71[local159] = local163;
					if (this.anIntArray59[local159] != local163) {
						this.anIntArray59[local159] = local163;
						this.method122(local159, 49);
						this.aBoolean59 = true;
						if (this.anInt289 != -1) {
							this.aBoolean60 = true;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				@Pc(211) int local211;
				@Pc(219) int local219;
				@Pc(321) int local321;
				@Pc(354) int local354;
				@Pc(207) long local207;
				if (this.anInt179 == 152) {
					local207 = this.aClass1_Sub3_Sub3_5.method397(603);
					local211 = this.aClass1_Sub3_Sub3_5.method391();
					@Pc(217) String local217 = Static30.method542(0, Static30.method539(local207, false));
					for (local219 = 0; local219 < this.anInt312; local219++) {
						if (local207 == this.aLongArray4[local219]) {
							if (this.anIntArray34[local219] != local211) {
								this.anIntArray34[local219] = local211;
								this.aBoolean59 = true;
								if (local211 > 0) {
									this.method172(5, local217 + " has logged in.", (byte) 4, "");
								}
								if (local211 == 0) {
									this.method172(5, local217 + " has logged out.", (byte) 4, "");
								}
							}
							local217 = null;
							break;
						}
					}
					if (local217 != null && this.anInt312 < 100) {
						this.aLongArray4[this.anInt312] = local207;
						this.aStringArray9[this.anInt312] = local217;
						this.anIntArray34[this.anInt312] = local211;
						this.anInt312++;
						this.aBoolean59 = true;
					}
					@Pc(315) boolean local315 = false;
					while (!local315) {
						local315 = true;
						for (local321 = 0; local321 < this.anInt312 - 1; local321++) {
							if (this.anIntArray34[local321] != Static6.anInt235 && this.anIntArray34[local321 + 1] == Static6.anInt235 || this.anIntArray34[local321] == 0 && this.anIntArray34[local321 + 1] != 0) {
								local354 = this.anIntArray34[local321];
								this.anIntArray34[local321] = this.anIntArray34[local321 + 1];
								this.anIntArray34[local321 + 1] = local354;
								@Pc(376) String local376 = this.aStringArray9[local321];
								this.aStringArray9[local321] = this.aStringArray9[local321 + 1];
								this.aStringArray9[local321 + 1] = local376;
								@Pc(398) long local398 = this.aLongArray4[local321];
								this.aLongArray4[local321] = this.aLongArray4[local321 + 1];
								this.aLongArray4[local321 + 1] = local398;
								this.aBoolean59 = true;
								local315 = false;
							}
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 43) {
					this.anInt267 = this.aClass1_Sub3_Sub3_5.method393() * 30;
					this.anInt179 = -1;
					return true;
				}
				@Pc(466) int local466;
				if (this.anInt179 == 80) {
					local159 = this.aClass1_Sub3_Sub3_5.method391();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					local211 = -1;
					for (local466 = 0; local466 < this.anIntArray56.length; local466++) {
						if (this.anIntArray56[local466] == (local159 << 8) + local462) {
							local211 = local466;
						}
					}
					if (local211 != -1) {
						signlink.cachesave("m" + local159 + "_" + local462, this.aByteArrayArray1[local211]);
						this.anInt307 = 1;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 1) {
					this.method108(this.aClass1_Sub3_Sub3_5, this.anInt178, false);
					this.anInt179 = -1;
					return true;
				}
				@Pc(650) int local650;
				if (this.anInt179 == 237) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					if (this.anInt212 == local159 && this.anInt213 == local462 && this.anInt307 != 0) {
						this.anInt179 = -1;
						return true;
					}
					this.anInt212 = local159;
					this.anInt213 = local462;
					this.anInt169 = (this.anInt212 - 6) * 8;
					this.anInt170 = (this.anInt213 - 6) * 8;
					this.anInt307 = 1;
					this.aClass32_27.method463((byte) 62);
					this.aClass1_Sub3_Sub2_Sub4_2.method362(151, (byte) 6, 0, "Loading - please wait.", 257);
					this.aClass1_Sub3_Sub2_Sub4_2.method362(150, (byte) 6, 16777215, "Loading - please wait.", 256);
					this.aClass32_27.method464(11, super.aGraphics2, 8, 5193);
					signlink.looprate(5);
					local211 = (this.anInt178 - 2) / 10;
					this.aByteArrayArray1 = new byte[local211][];
					this.aByteArrayArray2 = new byte[local211][];
					this.anIntArray56 = new int[local211];
					this.aClass1_Sub3_Sub3_6.method380((byte) -34, 150);
					this.aClass1_Sub3_Sub3_6.method381(0);
					local466 = 0;
					@Pc(662) int local662;
					for (local219 = 0; local219 < local211; local219++) {
						local650 = this.aClass1_Sub3_Sub3_5.method391();
						local321 = this.aClass1_Sub3_Sub3_5.method391();
						local354 = this.aClass1_Sub3_Sub3_5.method396();
						local662 = this.aClass1_Sub3_Sub3_5.method396();
						this.anIntArray56[local219] = (local650 << 8) + local321;
						@Pc(686) byte[] local686;
						if (local354 != 0) {
							local686 = signlink.cacheload("m" + local650 + "_" + local321);
							if (local686 != null) {
								this.aCRC32_1.reset();
								this.aCRC32_1.update(local686);
								if ((int) this.aCRC32_1.getValue() != local354) {
									local686 = null;
								}
							}
							if (local686 == null) {
								this.anInt307 = 0;
								this.aClass1_Sub3_Sub3_6.method381(0);
								this.aClass1_Sub3_Sub3_6.method381(local650);
								this.aClass1_Sub3_Sub3_6.method381(local321);
								local466 += 3;
							} else {
								this.aByteArrayArray1[local219] = local686;
							}
						}
						if (local662 != 0) {
							local686 = signlink.cacheload("l" + local650 + "_" + local321);
							if (local686 != null) {
								this.aCRC32_1.reset();
								this.aCRC32_1.update(local686);
								if ((int) this.aCRC32_1.getValue() != local662) {
									local686 = null;
								}
							}
							if (local686 == null) {
								this.anInt307 = 0;
								this.aClass1_Sub3_Sub3_6.method381(1);
								this.aClass1_Sub3_Sub3_6.method381(local650);
								this.aClass1_Sub3_Sub3_6.method381(local321);
								local466 += 3;
							} else {
								this.aByteArrayArray2[local219] = local686;
							}
						}
					}
					this.aClass1_Sub3_Sub3_6.method390(0, local466);
					signlink.looprate(50);
					this.aClass32_27.method463((byte) 62);
					if (this.anInt307 == 0) {
						this.aClass1_Sub3_Sub2_Sub4_2.method362(166, (byte) 6, 0, "Map area updated since last visit, so load will take longer this time only", 257);
						this.aClass1_Sub3_Sub2_Sub4_2.method362(165, (byte) 6, 16777215, "Map area updated since last visit, so load will take longer this time only", 256);
					}
					this.aClass32_27.method464(11, super.aGraphics2, 8, 5193);
					local650 = this.anInt169 - this.anInt171;
					local321 = this.anInt170 - this.anInt172;
					this.anInt171 = this.anInt169;
					this.anInt172 = this.anInt170;
					for (local354 = 0; local354 < 8192; local354++) {
						@Pc(856) Class1_Sub1_Sub3_Sub1 local856 = this.aClass1_Sub1_Sub3_Sub1Array1[local354];
						if (local856 != null) {
							for (@Pc(860) int local860 = 0; local860 < 10; local860++) {
								local856.anIntArray232[local860] -= local650;
								local856.anIntArray233[local860] -= local321;
							}
							local856.anInt882 -= local650 * 128;
							local856.anInt883 -= local321 * 128;
						}
					}
					for (local662 = 0; local662 < this.anInt203; local662++) {
						@Pc(911) Class1_Sub1_Sub3_Sub2 local911 = this.aClass1_Sub1_Sub3_Sub2Array1[local662];
						if (local911 != null) {
							for (@Pc(915) int local915 = 0; local915 < 10; local915++) {
								local911.anIntArray232[local915] -= local650;
								local911.anIntArray233[local915] -= local321;
							}
							local911.anInt882 -= local650 * 128;
							local911.anInt883 -= local321 * 128;
						}
					}
					@Pc(960) byte local960 = 0;
					@Pc(962) byte local962 = 104;
					@Pc(964) byte local964 = 1;
					if (local650 < 0) {
						local960 = 103;
						local962 = -1;
						local964 = -1;
					}
					@Pc(974) byte local974 = 0;
					@Pc(976) byte local976 = 104;
					@Pc(978) byte local978 = 1;
					if (local321 < 0) {
						local974 = 103;
						local976 = -1;
						local978 = -1;
					}
					for (@Pc(988) int local988 = local960; local988 != local962; local988 += local964) {
						for (@Pc(992) int local992 = local974; local992 != local976; local992 += local978) {
							@Pc(998) int local998 = local988 + local650;
							@Pc(1002) int local1002 = local992 + local321;
							for (@Pc(1004) int local1004 = 0; local1004 < 4; local1004++) {
								if (local998 >= 0 && local1002 >= 0 && local998 < 104 && local1002 < 104) {
									this.aClass28ArrayArrayArray1[local1004][local988][local992] = this.aClass28ArrayArrayArray1[local1004][local998][local1002];
								} else {
									this.aClass28ArrayArrayArray1[local1004][local988][local992] = null;
								}
							}
						}
					}
					for (@Pc(1066) Class1_Sub4 local1066 = (Class1_Sub4) this.aClass28_4.method456(); local1066 != null; local1066 = (Class1_Sub4) this.aClass28_4.method458(551)) {
						local1066.anInt595 -= local650;
						local1066.anInt596 -= local321;
						if (local1066.anInt595 < 0 || local1066.anInt596 < 0 || local1066.anInt595 >= 104 || local1066.anInt596 >= 104) {
							local1066.method567();
						}
					}
					if (this.anInt296 != 0) {
						this.anInt296 -= local650;
						this.anInt297 -= local321;
					}
					this.aBoolean61 = false;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 197) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					Static17.aClass15Array1[local159].aClass1_Sub3_Sub1_2 = this.aClass1_Sub1_Sub3_Sub2_1.method574(-718);
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 25) {
					this.anInt241 = this.aClass1_Sub3_Sub3_5.method391();
					if (this.anInt241 == 1) {
						this.anInt190 = this.aClass1_Sub3_Sub3_5.method393();
					}
					if (this.anInt241 >= 2 && this.anInt241 <= 6) {
						if (this.anInt241 == 2) {
							this.anInt161 = 64;
							this.anInt162 = 64;
						}
						if (this.anInt241 == 3) {
							this.anInt161 = 0;
							this.anInt162 = 64;
						}
						if (this.anInt241 == 4) {
							this.anInt161 = 128;
							this.anInt162 = 64;
						}
						if (this.anInt241 == 5) {
							this.anInt161 = 64;
							this.anInt162 = 0;
						}
						if (this.anInt241 == 6) {
							this.anInt161 = 64;
							this.anInt162 = 128;
						}
						this.anInt241 = 2;
						this.anInt158 = this.aClass1_Sub3_Sub3_5.method393();
						this.anInt159 = this.aClass1_Sub3_Sub3_5.method393();
						this.anInt160 = this.aClass1_Sub3_Sub3_5.method391();
					}
					if (this.anInt241 == 10) {
						this.anInt305 = this.aClass1_Sub3_Sub3_5.method393();
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 54) {
					local1264 = this.aClass1_Sub3_Sub3_5.method398();
					local462 = this.aClass1_Sub3_Sub3_5.method396();
					local211 = this.aClass1_Sub3_Sub3_5.method396();
					if (!local1264.equals(this.aString17) && this.aBoolean42 && !Static6.aBoolean53) {
						this.method75(false, local462, local1264, local211);
					}
					this.aString17 = local1264;
					this.anInt321 = local462;
					this.anInt343 = local211;
					this.anInt157 = 0;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 142) {
					this.method119(-780);
					this.anInt179 = -1;
					return false;
				}
				if (this.anInt179 == 20) {
					local159 = this.aClass1_Sub3_Sub3_5.method391();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					local211 = -1;
					for (local466 = 0; local466 < this.anIntArray56.length; local466++) {
						if (this.anIntArray56[local466] == (local159 << 8) + local462) {
							local211 = local466;
						}
					}
					if (local211 != -1) {
						signlink.cachesave("l" + local159 + "_" + local462, this.aByteArrayArray2[local211]);
						this.anInt307 = 1;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 19) {
					this.anInt296 = 0;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 139) {
					this.anInt152 = this.aClass1_Sub3_Sub3_5.method393();
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 151 || this.anInt179 == 23 || this.anInt179 == 50 || this.anInt179 == 191 || this.anInt179 == 69 || this.anInt179 == 49 || this.anInt179 == 223 || this.anInt179 == 42 || this.anInt179 == 76 || this.anInt179 == 59) {
					this.method83((byte) -45, this.aClass1_Sub3_Sub3_5, this.anInt179);
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 28) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					if (this.anInt280 != -1) {
						this.anInt280 = -1;
						this.aBoolean60 = true;
					}
					if (this.aBoolean66) {
						this.aBoolean66 = false;
						this.aBoolean60 = true;
					}
					this.anInt271 = local159;
					this.anInt330 = local462;
					this.aBoolean59 = true;
					this.aBoolean68 = true;
					this.aBoolean49 = false;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 175) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method396();
					this.anIntArray71[local159] = local462;
					if (this.anIntArray59[local159] != local462) {
						this.anIntArray59[local159] = local462;
						this.method122(local159, 49);
						this.aBoolean59 = true;
						if (this.anInt289 != -1) {
							this.aBoolean60 = true;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 146) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					Static17.aClass15Array1[local159].anInt488 = local462;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 167) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					if (local159 == 65535) {
						local159 = -1;
					}
					this.anIntArray46[local462] = local159;
					this.aBoolean59 = true;
					this.aBoolean68 = true;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 220) {
					local159 = this.aClass1_Sub3_Sub3_5.method391();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					local211 = this.aClass1_Sub3_Sub3_5.method393();
					local466 = this.aClass1_Sub3_Sub3_5.method393();
					local219 = -1;
					for (local650 = 0; local650 < this.anIntArray56.length; local650++) {
						if (this.anIntArray56[local650] == (local159 << 8) + local462) {
							local219 = local650;
						}
					}
					if (local219 != -1) {
						if (this.aByteArrayArray2[local219] == null || this.aByteArrayArray2[local219].length != local466) {
							this.aByteArrayArray2[local219] = new byte[local466];
						}
						this.aClass1_Sub3_Sub3_5.method400(this.anInt178 - 6, -110, local211, this.aByteArrayArray2[local219]);
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 133) {
					@Pc(1701) Class1_Sub3_Sub3 local1701 = Static9.method211(854);
					if (local1701 != null) {
						this.aClass1_Sub3_Sub3_6.method380((byte) -34, 81);
						this.aClass1_Sub3_Sub3_6.method382(local1701.anInt561);
						this.aClass1_Sub3_Sub3_6.method389(local1701.aByteArray7, local1701.anInt561, 0, (byte) -106);
						local1701.method379((byte) 8);
					}
					this.anInt179 = -1;
					return true;
				}
				@Pc(1745) Class15 local1745;
				if (this.anInt179 == 98) {
					this.aBoolean59 = true;
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local1745 = Static17.aClass15Array1[local159];
					local211 = this.aClass1_Sub3_Sub3_5.method391();
					for (local466 = 0; local466 < local211; local466++) {
						local1745.anIntArray149[local466] = this.aClass1_Sub3_Sub3_5.method393();
						local219 = this.aClass1_Sub3_Sub3_5.method391();
						if (local219 == 255) {
							local219 = this.aClass1_Sub3_Sub3_5.method396();
						}
						local1745.anIntArray150[local466] = local219;
					}
					for (local219 = local211; local219 < local1745.anIntArray149.length; local219++) {
						local1745.anIntArray149[local219] = 0;
						local1745.anIntArray150[local219] = 0;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 226) {
					Static9.method208(-31717);
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 243) {
					this.aBoolean47 = false;
					this.aBoolean66 = true;
					this.aString7 = "";
					this.aBoolean60 = true;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 15) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local1745 = Static17.aClass15Array1[local159];
					for (local211 = 0; local211 < local1745.anIntArray149.length; local211++) {
						local1745.anIntArray149[local211] = -1;
						local1745.anIntArray149[local211] = 0;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 140) {
					this.anInt299 = this.aClass1_Sub3_Sub3_5.method396();
					this.anInt226 = this.aClass1_Sub3_Sub3_5.method393();
					this.anInt239 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt298 = this.aClass1_Sub3_Sub3_5.method393();
					if (this.anInt299 != 0 && this.anInt271 == -1) {
						signlink.dnslookup(Static30.method541(-946, this.anInt299));
						this.method77((byte) -60);
						@Pc(1915) short local1915 = 650;
						if (this.anInt239 != 201) {
							local1915 = 655;
						}
						this.aString9 = "";
						this.aBoolean51 = false;
						for (local462 = 0; local462 < Static17.aClass15Array1.length; local462++) {
							if (Static17.aClass15Array1[local462] != null && Static17.aClass15Array1[local462].anInt474 == local1915) {
								this.anInt271 = Static17.aClass15Array1[local462].anInt471;
								break;
							}
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 126) {
					this.anInt329 = this.aClass1_Sub3_Sub3_5.method391();
					if (this.anInt329 == this.anInt166) {
						if (this.anInt329 == 3) {
							this.anInt166 = 1;
						} else {
							this.anInt166 = 3;
						}
						this.aBoolean59 = true;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 212) {
					if (this.aBoolean42 && !Static6.aBoolean53) {
						local159 = this.aClass1_Sub3_Sub3_5.method393();
						local462 = this.aClass1_Sub3_Sub3_5.method396();
						local211 = this.anInt178 - 6;
						@Pc(2018) byte[] local2018 = new byte[local462];
						Static26.method519(local2018, local462, this.aClass1_Sub3_Sub3_5.aByteArray7, local211, this.aClass1_Sub3_Sub3_5.anInt561);
						this.method113(local2018, 625, local462, false);
						this.anInt157 = local159;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 254) {
					this.anInt276 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 12) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					local211 = this.aClass1_Sub3_Sub3_5.method393();
					if (this.aBoolean73 && !Static6.aBoolean53 && this.anInt286 < 50) {
						this.anIntArray82[this.anInt286] = local159;
						this.anIntArray37[this.anInt286] = local462;
						this.anIntArray45[this.anInt286] = local211 + Static32.anIntArray231[local159];
						this.anInt286++;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 204) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					@Pc(2130) Class3 local2130 = Static3.method32(local462);
					Static17.aClass15Array1[local159].aClass1_Sub3_Sub1_2 = local2130.method35(false);
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 7) {
					this.anInt222 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt223 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt179 = -1;
					return true;
				}
				@Pc(2181) Class15 local2181;
				if (this.anInt179 == 103) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					local211 = this.aClass1_Sub3_Sub3_5.method393();
					local2181 = Static17.aClass15Array1[local159];
					@Pc(2184) Class1_Sub3_Sub1 local2184 = local2181.aClass1_Sub3_Sub1_2;
					if (local2184 != null) {
						local2184.method237(local462, local211);
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 32) {
					this.anInt273 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt164 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt234 = this.aClass1_Sub3_Sub3_5.method391();
					this.aBoolean56 = true;
					this.aBoolean60 = true;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 195) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					this.method173(-321, local159);
					if (this.anInt280 != -1) {
						this.anInt280 = -1;
						this.aBoolean60 = true;
					}
					if (this.aBoolean66) {
						this.aBoolean66 = false;
						this.aBoolean60 = true;
					}
					this.anInt330 = local159;
					this.aBoolean59 = true;
					this.aBoolean68 = true;
					this.anInt271 = -1;
					this.aBoolean49 = false;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 14) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					this.method173(-321, local159);
					if (this.anInt330 != -1) {
						this.anInt330 = -1;
						this.aBoolean59 = true;
						this.aBoolean68 = true;
					}
					this.anInt280 = local159;
					this.aBoolean60 = true;
					this.anInt271 = -1;
					this.aBoolean49 = false;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 209) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method394();
					local211 = this.aClass1_Sub3_Sub3_5.method394();
					local2181 = Static17.aClass15Array1[local159];
					local2181.anInt477 = local462;
					local2181.anInt478 = local211;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 3) {
					this.aBoolean61 = true;
					this.anInt146 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt147 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt148 = this.aClass1_Sub3_Sub3_5.method393();
					this.anInt149 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt150 = this.aClass1_Sub3_Sub3_5.method391();
					if (this.anInt150 >= 100) {
						this.anInt322 = this.anInt146 * 128 + 64;
						this.anInt324 = this.anInt147 * 128 + 64;
						this.anInt323 = this.method94(this.anInt231, this.anInt146, (byte) 5, this.anInt147) - this.anInt148;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 135) {
					this.anInt222 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt223 = this.aClass1_Sub3_Sub3_5.method391();
					for (local159 = this.anInt222; local159 < this.anInt222 + 8; local159++) {
						for (local462 = this.anInt223; local462 < this.anInt223 + 8; local462++) {
							if (this.aClass28ArrayArrayArray1[this.anInt231][local159][local462] != null) {
								this.aClass28ArrayArrayArray1[this.anInt231][local159][local462] = null;
								this.method184(local159, local462);
							}
						}
					}
					for (@Pc(2487) Class1_Sub4 local2487 = (Class1_Sub4) this.aClass28_4.method456(); local2487 != null; local2487 = (Class1_Sub4) this.aClass28_4.method458(551)) {
						if (local2487.anInt595 >= this.anInt222 && local2487.anInt595 < this.anInt222 + 8 && local2487.anInt596 >= this.anInt223 && local2487.anInt596 < this.anInt223 + 8 && local2487.anInt593 == this.anInt231) {
							this.method160(local2487.anInt601, local2487.anInt595, local2487.anInt596, local2487.anInt594, local2487.anInt600, local2487.anInt602, -27819, local2487.anInt593);
							local2487.method567();
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 132) {
					local159 = this.aClass1_Sub3_Sub3_5.method391();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					local211 = this.aClass1_Sub3_Sub3_5.method393();
					local466 = this.aClass1_Sub3_Sub3_5.method393();
					local219 = -1;
					for (local650 = 0; local650 < this.anIntArray56.length; local650++) {
						if (this.anIntArray56[local650] == (local159 << 8) + local462) {
							local219 = local650;
						}
					}
					if (local219 != -1) {
						if (this.aByteArrayArray1[local219] == null || this.aByteArrayArray1[local219].length != local466) {
							this.aByteArrayArray1[local219] = new byte[local466];
						}
						this.aClass1_Sub3_Sub3_5.method400(this.anInt178 - 6, -110, local211, this.aByteArrayArray1[local219]);
					}
					this.anInt179 = -1;
					return true;
				}
				@Pc(2652) boolean local2652;
				if (this.anInt179 == 41) {
					local207 = this.aClass1_Sub3_Sub3_5.method397(603);
					local211 = this.aClass1_Sub3_Sub3_5.method396();
					local466 = this.aClass1_Sub3_Sub3_5.method391();
					local2652 = false;
					for (local650 = 0; local650 < 100; local650++) {
						if (this.anIntArray48[local650] == local211) {
							local2652 = true;
							break;
						}
					}
					if (local466 <= 1) {
						for (local321 = 0; local321 < this.anInt186; local321++) {
							if (this.aLongArray3[local321] == local207) {
								local2652 = true;
								break;
							}
						}
					}
					if (!local2652 && this.anInt191 == 0) {
						try {
							this.anIntArray48[this.anInt219] = local211;
							this.anInt219 = (this.anInt219 + 1) % 100;
							@Pc(2721) String local2721 = Static31.method545(this.aClass1_Sub3_Sub3_5, 118, this.anInt178 - 13);
							@Pc(2725) String local2725 = Static24.method424(local2721, 0);
							if (local466 > 1) {
								this.method172(7, local2725, (byte) 4, Static30.method542(0, Static30.method539(local207, false)));
							} else {
								this.method172(3, local2725, (byte) 4, Static30.method542(0, Static30.method539(local207, false)));
							}
						} catch (@Pc(2752) Exception local2752) {
							signlink.reporterror("cde1");
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 193) {
					for (local159 = 0; local159 < this.anIntArray59.length; local159++) {
						if (this.anIntArray59[local159] != this.anIntArray71[local159]) {
							this.anIntArray59[local159] = this.anIntArray71[local159];
							this.method122(local159, 49);
							this.aBoolean59 = true;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 87) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					Static17.aClass15Array1[local159].aClass1_Sub3_Sub1_2 = new Class1_Sub3_Sub1(false, local462);
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 185) {
					local159 = this.aClass1_Sub3_Sub3_5.method394();
					this.anInt289 = local159;
					this.aBoolean60 = true;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 68) {
					if (this.anInt166 == 12) {
						this.aBoolean59 = true;
					}
					this.anInt303 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 74) {
					this.aBoolean61 = true;
					this.anInt261 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt262 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt263 = this.aClass1_Sub3_Sub3_5.method393();
					this.anInt264 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt265 = this.aClass1_Sub3_Sub3_5.method391();
					if (this.anInt265 >= 100) {
						local159 = this.anInt261 * 128 + 64;
						local462 = this.anInt262 * 128 + 64;
						local211 = this.method94(this.anInt231, this.anInt261, (byte) 5, this.anInt262) - this.anInt263;
						local466 = local159 - this.anInt322;
						local219 = local211 - this.anInt323;
						local650 = local462 - this.anInt324;
						local321 = (int) Math.sqrt((double) (local466 * local466 + local650 * local650));
						this.anInt325 = (int) (Math.atan2((double) local219, (double) local321) * 325.949D) & 0x7FF;
						this.anInt326 = (int) (Math.atan2((double) local466, (double) local650) * -325.949D) & 0x7FF;
						if (this.anInt325 < 128) {
							this.anInt325 = 128;
						}
						if (this.anInt325 > 383) {
							this.anInt325 = 383;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 84) {
					this.anInt166 = this.aClass1_Sub3_Sub3_5.method391();
					this.aBoolean59 = true;
					this.aBoolean68 = true;
					this.anInt179 = -1;
					return true;
				}
				@Pc(3040) String local3040;
				if (this.anInt179 == 4) {
					local1264 = this.aClass1_Sub3_Sub3_5.method398();
					@Pc(3043) long local3043;
					if (local1264.endsWith(":tradereq:")) {
						local3040 = local1264.substring(0, local1264.indexOf(":"));
						local3043 = Static30.method538(local3040);
						local2652 = false;
						for (local650 = 0; local650 < this.anInt186; local650++) {
							if (this.aLongArray3[local650] == local3043) {
								local2652 = true;
								break;
							}
						}
						if (!local2652 && this.anInt191 == 0) {
							this.method172(4, "wishes to trade with you.", (byte) 4, local3040);
						}
					} else if (local1264.endsWith(":duelreq:")) {
						local3040 = local1264.substring(0, local1264.indexOf(":"));
						local3043 = Static30.method538(local3040);
						local2652 = false;
						for (local650 = 0; local650 < this.anInt186; local650++) {
							if (this.aLongArray3[local650] == local3043) {
								local2652 = true;
								break;
							}
						}
						if (!local2652 && this.anInt191 == 0) {
							this.method172(8, "wishes to duel with you.", (byte) 4, local3040);
						}
					} else {
						this.method172(0, local1264, (byte) 4, "");
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 46) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					local211 = this.aClass1_Sub3_Sub3_5.method393();
					@Pc(3157) Class5 local3157 = Static5.method54(local462);
					Static17.aClass15Array1[local159].aClass1_Sub3_Sub1_2 = local3157.method58(50);
					Static17.aClass15Array1[local159].anInt491 = local3157.anInt106;
					Static17.aClass15Array1[local159].anInt492 = local3157.anInt107;
					Static17.aClass15Array1[local159].anInt490 = local3157.anInt105 * 100 / local211;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 168) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					this.method173(-321, local159);
					if (this.anInt330 != -1) {
						this.anInt330 = -1;
						this.aBoolean59 = true;
						this.aBoolean68 = true;
					}
					if (this.anInt280 != -1) {
						this.anInt280 = -1;
						this.aBoolean60 = true;
					}
					if (this.aBoolean66) {
						this.aBoolean66 = false;
						this.aBoolean60 = true;
					}
					this.anInt271 = local159;
					this.aBoolean49 = false;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 2) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local462 = this.aClass1_Sub3_Sub3_5.method393();
					local211 = local462 >> 10 & 0x1F;
					local466 = local462 >> 5 & 0x1F;
					local219 = local462 & 0x1F;
					Static17.aClass15Array1[local159].anInt485 = (local211 << 19) + (local466 << 11) + (local219 << 3);
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 136) {
					for (local159 = 0; local159 < this.aClass1_Sub1_Sub3_Sub2Array1.length; local159++) {
						if (this.aClass1_Sub1_Sub3_Sub2Array1[local159] != null) {
							this.aClass1_Sub1_Sub3_Sub2Array1[local159].anInt907 = -1;
						}
					}
					for (local462 = 0; local462 < this.aClass1_Sub1_Sub3_Sub1Array1.length; local462++) {
						if (this.aClass1_Sub1_Sub3_Sub1Array1[local462] != null) {
							this.aClass1_Sub1_Sub3_Sub1Array1[local462].anInt907 = -1;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 26) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					@Pc(3362) boolean local3362 = this.aClass1_Sub3_Sub3_5.method391() == 1;
					Static17.aClass15Array1[local159].aBoolean106 = local3362;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 21) {
					this.anInt186 = this.anInt178 / 8;
					for (local159 = 0; local159 < this.anInt186; local159++) {
						this.aLongArray3[local159] = this.aClass1_Sub3_Sub3_5.method397(603);
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 239) {
					this.aBoolean61 = false;
					for (local159 = 0; local159 < 5; local159++) {
						this.aBooleanArray1[local159] = false;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 129) {
					if (this.anInt330 != -1) {
						this.anInt330 = -1;
						this.aBoolean59 = true;
						this.aBoolean68 = true;
					}
					if (this.anInt280 != -1) {
						this.anInt280 = -1;
						this.aBoolean60 = true;
					}
					if (this.aBoolean66) {
						this.aBoolean66 = false;
						this.aBoolean60 = true;
					}
					this.anInt271 = -1;
					this.aBoolean49 = false;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 201) {
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local3040 = this.aClass1_Sub3_Sub3_5.method398();
					Static17.aClass15Array1[local159].aString20 = local3040;
					if (Static17.aClass15Array1[local159].anInt471 == this.anIntArray46[this.anInt166]) {
						this.aBoolean59 = true;
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 44) {
					this.aBoolean59 = true;
					local159 = this.aClass1_Sub3_Sub3_5.method391();
					local462 = this.aClass1_Sub3_Sub3_5.method396();
					local211 = this.aClass1_Sub3_Sub3_5.method391();
					this.anIntArray72[local159] = local462;
					this.anIntArray36[local159] = local211;
					this.anIntArray57[local159] = 1;
					for (local466 = 0; local466 < 98; local466++) {
						if (local462 >= anIntArray47[local466]) {
							this.anIntArray57[local159] = local466 + 2;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 162) {
					this.anInt222 = this.aClass1_Sub3_Sub3_5.method391();
					this.anInt223 = this.aClass1_Sub3_Sub3_5.method391();
					while (this.aClass1_Sub3_Sub3_5.anInt561 < this.anInt178) {
						local159 = this.aClass1_Sub3_Sub3_5.method391();
						this.method83((byte) -45, this.aClass1_Sub3_Sub3_5, local159);
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 22) {
					if (this.anInt166 == 12) {
						this.aBoolean59 = true;
					}
					this.anInt173 = this.aClass1_Sub3_Sub3_5.method394();
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 13) {
					local159 = this.aClass1_Sub3_Sub3_5.method391();
					local462 = this.aClass1_Sub3_Sub3_5.method391();
					local211 = this.aClass1_Sub3_Sub3_5.method391();
					local466 = this.aClass1_Sub3_Sub3_5.method391();
					this.aBooleanArray1[local159] = true;
					this.anIntArray62[local159] = local462;
					this.anIntArray63[local159] = local211;
					this.anIntArray88[local159] = local466;
					this.anIntArray68[local159] = 0;
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 213) {
					this.aBoolean59 = true;
					local159 = this.aClass1_Sub3_Sub3_5.method393();
					local1745 = Static17.aClass15Array1[local159];
					while (this.aClass1_Sub3_Sub3_5.anInt561 < this.anInt178) {
						local211 = this.aClass1_Sub3_Sub3_5.method391();
						local466 = this.aClass1_Sub3_Sub3_5.method393();
						local219 = this.aClass1_Sub3_Sub3_5.method391();
						if (local219 == 255) {
							local219 = this.aClass1_Sub3_Sub3_5.method396();
						}
						if (local211 >= 0 && local211 < local1745.anIntArray149.length) {
							local1745.anIntArray149[local211] = local466;
							local1745.anIntArray150[local211] = local219;
						}
					}
					this.anInt179 = -1;
					return true;
				}
				if (this.anInt179 == 184) {
					this.method170(this.aClass1_Sub3_Sub3_5, this.anInt178, 822);
					if (this.anInt307 == 1) {
						this.anInt307 = 2;
						Static4.anInt81 = this.anInt231;
						this.method185(869);
					}
					if (Static6.aBoolean53 && this.anInt307 == 2 && Static4.anInt81 != this.anInt231) {
						this.aClass32_27.method463((byte) 62);
						this.aClass1_Sub3_Sub2_Sub4_2.method362(151, (byte) 6, 0, "Loading - please wait.", 257);
						this.aClass1_Sub3_Sub2_Sub4_2.method362(150, (byte) 6, 16777215, "Loading - please wait.", 256);
						this.aClass32_27.method464(11, super.aGraphics2, 8, 5193);
						Static4.anInt81 = this.anInt231;
						this.method185(869);
					}
					if (this.anInt231 != this.anInt176 && this.anInt307 == 2) {
						this.anInt176 = this.anInt231;
						this.method106(this.anInt231, -153);
					}
					this.anInt179 = -1;
					return true;
				}
				signlink.reporterror("T1 - " + this.anInt179 + "," + this.anInt178 + " - " + this.anInt208 + "," + this.anInt209);
				this.method119(-780);
			} catch (@Pc(3862) IOException local3862) {
				this.method182(false);
			} catch (@Pc(3867) Exception local3867) {
				local1264 = "T2 - " + this.anInt179 + "," + this.anInt208 + "," + this.anInt209 + " - " + this.anInt178 + "," + (this.anInt169 + this.aClass1_Sub1_Sub3_Sub2_1.anIntArray232[0]) + "," + (this.anInt170 + this.aClass1_Sub1_Sub3_Sub2_1.anIntArray233[0]) + " - ";
				for (local462 = 0; local462 < this.anInt178 && local462 < 50; local462++) {
					local1264 = local1264 + this.aClass1_Sub3_Sub3_5.aByteArray7[local462] + ",";
				}
				signlink.reporterror(local1264);
				this.method119(-780);
			}
			return true;
		} catch (@Pc(3950) RuntimeException local3950) {
			signlink.reporterror("50315, " + arg0 + ", " + local3950.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "s", descriptor = "(B)V")
	private void method198(@OriginalArg(0) byte arg0) {
		try {
			this.aClass32_25.method463((byte) 62);
			Static15.anIntArray139 = this.anIntArray31;
			this.aClass1_Sub3_Sub2_Sub3_9.method350(0, 0, false);
			if (this.anInt330 != -1) {
				this.method120(0, 0, 38682, Static17.aClass15Array1[this.anInt330], 0);
			} else if (this.anIntArray46[this.anInt166] != -1) {
				this.method120(0, 0, 38682, Static17.aClass15Array1[this.anIntArray46[this.anInt166]], 0);
			}
			if (this.aBoolean50 && this.anInt337 == 1) {
				this.method135(-961);
			}
			this.aClass32_25.method464(231, super.aGraphics2, 562, 5193);
			if (arg0 == 2) {
				@Pc(73) boolean local73 = false;
				this.aClass32_27.method463((byte) 62);
				Static15.anIntArray139 = this.anIntArray32;
			}
		} catch (@Pc(85) RuntimeException local85) {
			signlink.reporterror("63572, " + arg0 + ", " + local85.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILjava/lang/String;)Z")
	private boolean method199(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		try {
			while (arg0 >= 0) {
				this.aClass1_Sub3_Sub3_6.method381(74);
			}
			if (arg1 == null) {
				return false;
			}
			for (@Pc(15) int local15 = 0; local15 < this.anInt312; local15++) {
				if (arg1.equalsIgnoreCase(this.aStringArray9[local15])) {
					return true;
				}
			}
			if (arg1.equalsIgnoreCase(this.aClass1_Sub1_Sub3_Sub2_1.aString29)) {
				return true;
			} else {
				return false;
			}
		} catch (@Pc(42) RuntimeException local42) {
			signlink.reporterror("64810, " + arg0 + ", " + arg1 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "init", descriptor = "()V")
	@Override
	public void init() {
		Static6.anInt235 = Integer.parseInt(this.getParameter("nodeid"));
		Static6.anInt236 = Integer.parseInt(this.getParameter("portoff"));
		@Pc(15) String local15 = this.getParameter("lowmem");
		if (local15 != null && local15.equals("1")) {
			Static6.method88(true);
		} else {
			Static6.method167(9);
		}
		@Pc(31) String local31 = this.getParameter("free");
		if (local31 != null && local31.equals("1")) {
			Static6.aBoolean52 = false;
		} else {
			Static6.aBoolean52 = true;
		}
		this.method63(532, false, 789);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!kb;Lclient!z;)V")
	private void method200(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Class1_Sub3_Sub3 arg3, @OriginalArg(4) Class1_Sub1_Sub3_Sub2 arg4) {
		try {
			if (!arg0) {
				this.aBoolean44 = !this.aBoolean44;
			}
			@Pc(19) int local19;
			if ((arg2 & 0x1) == 1) {
				local19 = arg3.method391();
				@Pc(22) byte[] local22 = new byte[local19];
				@Pc(28) Class1_Sub3_Sub3 local28 = new Class1_Sub3_Sub3(363, local22);
				arg3.method400(local19, -110, 0, local22);
				this.aClass1_Sub3_Sub3Array1[arg1] = local28;
				arg4.method572(false, local28);
			}
			@Pc(66) int local66;
			if ((arg2 & 0x2) == 2) {
				local19 = arg3.method393();
				if (local19 == 65535) {
					local19 = -1;
				}
				if (local19 == arg4.anInt907) {
					arg4.anInt911 = 0;
				}
				local66 = arg3.method391();
				if (local19 == -1 || arg4.anInt907 == -1 || Static20.aClass19Array1[local19].anInt545 > Static20.aClass19Array1[arg4.anInt907].anInt545 || Static20.aClass19Array1[arg4.anInt907].anInt545 == 0) {
					arg4.anInt907 = local19;
					arg4.anInt908 = 0;
					arg4.anInt909 = 0;
					arg4.anInt910 = local66;
					arg4.anInt911 = 0;
				}
			}
			if ((arg2 & 0x4) == 4) {
				arg4.anInt901 = arg3.method393();
				if (arg4.anInt901 == 65535) {
					arg4.anInt901 = -1;
				}
			}
			if ((arg2 & 0x8) == 8) {
				arg4.aString28 = arg3.method398();
				arg4.anInt894 = 0;
				arg4.anInt895 = 0;
				arg4.anInt893 = 150;
				this.method172(2, arg4.aString28, (byte) 4, arg4.aString29);
			}
			if ((arg2 & 0x10) == 16) {
				arg4.anInt896 = arg3.method391();
				arg4.anInt897 = arg3.method391();
				arg4.anInt898 = Static6.anInt266 + 400;
				arg4.anInt899 = arg3.method391();
				arg4.anInt900 = arg3.method391();
			}
			if ((arg2 & 0x20) == 32) {
				arg4.anInt902 = arg3.method393();
				arg4.anInt903 = arg3.method393();
			}
			if ((arg2 & 0x40) == 64) {
				local19 = arg3.method393();
				local66 = arg3.method391();
				@Pc(199) int local199 = arg3.method391();
				@Pc(202) int local202 = arg3.anInt561;
				if (arg4.aString29 != null) {
					@Pc(209) long local209 = Static30.method538(arg4.aString29);
					@Pc(211) boolean local211 = false;
					if (local66 <= 1) {
						for (@Pc(216) int local216 = 0; local216 < this.anInt186; local216++) {
							if (this.aLongArray3[local216] == local209) {
								local211 = true;
								break;
							}
						}
					}
					if (!local211 && this.anInt191 == 0) {
						try {
							@Pc(244) String local244 = Static31.method545(arg3, 118, local199);
							@Pc(248) String local248 = Static24.method424(local244, 0);
							arg4.aString28 = local248;
							arg4.anInt894 = local19 >> 8;
							arg4.anInt895 = local19 & 0xFF;
							arg4.anInt893 = 150;
							if (local66 > 1) {
								this.method172(1, local248, (byte) 4, arg4.aString29);
							} else {
								this.method172(2, local248, (byte) 4, arg4.aString29);
							}
						} catch (@Pc(285) Exception local285) {
							signlink.reporterror("cde2");
						}
					}
				}
				arg3.anInt561 = local202 + local199;
			}
			if ((arg2 & 0x100) == 256) {
				arg4.anInt912 = arg3.method393();
				local19 = arg3.method396();
				arg4.anInt916 = local19 >> 16;
				arg4.anInt915 = Static6.anInt266 + (local19 & 0xFFFF);
				arg4.anInt913 = 0;
				arg4.anInt914 = 0;
				if (arg4.anInt915 > Static6.anInt266) {
					arg4.anInt913 = -1;
				}
				if (arg4.anInt912 == 65535) {
					arg4.anInt912 = -1;
				}
			}
			if ((arg2 & 0x200) == 512) {
				arg4.anInt917 = arg3.method391();
				arg4.anInt919 = arg3.method391();
				arg4.anInt918 = arg3.method391();
				arg4.anInt920 = arg3.method391();
				arg4.anInt921 = arg3.method393() + Static6.anInt266;
				arg4.anInt922 = arg3.method393() + Static6.anInt266;
				arg4.anInt923 = arg3.method391();
				arg4.anInt927 = 0;
				arg4.anIntArray232[0] = arg4.anInt918;
				arg4.anIntArray233[0] = arg4.anInt920;
			}
		} catch (@Pc(391) RuntimeException local391) {
			signlink.reporterror("94218, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local391.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLjava/lang/String;I)V")
	@Override
	protected void method74(@OriginalArg(0) boolean arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		try {
			this.method156((byte) 99);
			if (this.aClass39_1 == null) {
				super.method74(true, arg1, arg2);
			} else {
				this.aClass32_18.method463((byte) 62);
				@Pc(17) short local17 = 360;
				@Pc(19) short local19 = 200;
				@Pc(21) byte local21 = 20;
				this.aClass1_Sub3_Sub2_Sub4_3.method362(local19 / 2 - local21 - 26, (byte) 6, 16777215, "RuneScape is loading - please wait...", local17 / 2);
				this.aBoolean62 &= arg0;
				@Pc(51) int local51 = local19 / 2 - local21 - 18;
				Static12.method359(3, local17 / 2 - 152, 9179409, 34, local51, 304);
				Static12.method359(3, local17 / 2 - 151, 0, 32, local51 + 1, 302);
				Static12.method358(local51 + 2, local17 / 2 - 150, 9179409, (byte) 93, arg2 * 3, 30);
				Static12.method358(local51 + 2, local17 / 2 - 150 + arg2 * 3, 0, (byte) 93, 300 - arg2 * 3, 30);
				this.aClass1_Sub3_Sub2_Sub4_3.method362(local19 / 2 + 5 - local21, (byte) 6, 16777215, arg1, local17 / 2);
				this.aClass32_18.method464(186, super.aGraphics2, 214, 5193);
				if (this.aBoolean37) {
					this.aBoolean37 = false;
					if (!this.aBoolean54) {
						this.aClass32_19.method464(0, super.aGraphics2, 0, 5193);
						this.aClass32_20.method464(0, super.aGraphics2, 661, 5193);
					}
					this.aClass32_16.method464(0, super.aGraphics2, 128, 5193);
					this.aClass32_17.method464(386, super.aGraphics2, 214, 5193);
					this.aClass32_21.method464(265, super.aGraphics2, 0, 5193);
					this.aClass32_22.method464(265, super.aGraphics2, 574, 5193);
					this.aClass32_23.method464(186, super.aGraphics2, 128, 5193);
					this.aClass32_24.method464(186, super.aGraphics2, 574, 5193);
				}
			}
		} catch (@Pc(210) RuntimeException local210) {
			signlink.reporterror("68527, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local210.toString());
			throw new RuntimeException();
		}
	}
}
