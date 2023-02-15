import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
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
public final class Game extends GameShell {

	@OriginalMember(owner = "client!client", name = "E", descriptor = "I")
	public static int anInt143;

	@OriginalMember(owner = "client!client", name = "F", descriptor = "Ljava/lang/String;")
	public static final String aString4 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

	@OriginalMember(owner = "client!client", name = "G", descriptor = "I")
	private int midiSyncLen;

	@OriginalMember(owner = "client!client", name = "H", descriptor = "I")
	private int anInt145;

	@OriginalMember(owner = "client!client", name = "I", descriptor = "I")
	private int cutsceneSrcLocalTileX;

	@OriginalMember(owner = "client!client", name = "J", descriptor = "I")
	private int cutsceneSrcLocalTileZ;

	@OriginalMember(owner = "client!client", name = "K", descriptor = "I")
	private int cutsceneSrcHeight;

	@OriginalMember(owner = "client!client", name = "L", descriptor = "I")
	private int cutsceneMoveSpeed;

	@OriginalMember(owner = "client!client", name = "M", descriptor = "I")
	private int cutsceneMoveAcceleration;

	@OriginalMember(owner = "client!client", name = "N", descriptor = "I")
	private int anInt151 = 24676;

	@OriginalMember(owner = "client!client", name = "O", descriptor = "I")
	private int localPid = -1;

	@OriginalMember(owner = "client!client", name = "P", descriptor = "[I")
	private int[] areaChatbackOffsets;

	@OriginalMember(owner = "client!client", name = "Q", descriptor = "[I")
	private int[] areaSidebarOffsets;

	@OriginalMember(owner = "client!client", name = "R", descriptor = "[I")
	private int[] areaViewportOffsets;

	@OriginalMember(owner = "client!client", name = "S", descriptor = "I")
	private int crossX;

	@OriginalMember(owner = "client!client", name = "T", descriptor = "I")
	private int crossY;

	@OriginalMember(owner = "client!client", name = "U", descriptor = "I")
	private int crossCycle;

	@OriginalMember(owner = "client!client", name = "V", descriptor = "I")
	private int crossMode;

	@OriginalMember(owner = "client!client", name = "W", descriptor = "[I")
	private final int[] designColors = new int[5];

	@OriginalMember(owner = "client!client", name = "X", descriptor = "Lclient!kb;")
	private Buffer login = Buffer.method378(1, -737);

	@OriginalMember(owner = "client!client", name = "Y", descriptor = "I")
	private int nextMusicDelay;

	@OriginalMember(owner = "client!client", name = "Z", descriptor = "I")
	private int hintTileX;

	@OriginalMember(owner = "client!client", name = "ab", descriptor = "I")
	private int hintTileZ;

	@OriginalMember(owner = "client!client", name = "bb", descriptor = "I")
	private int hintHeight;

	@OriginalMember(owner = "client!client", name = "cb", descriptor = "I")
	private int hintOffsetX;

	@OriginalMember(owner = "client!client", name = "db", descriptor = "I")
	private int hintOffsetZ;

	@OriginalMember(owner = "client!client", name = "eb", descriptor = "I")
	private int minimapOffsetCycle;

	@OriginalMember(owner = "client!client", name = "fb", descriptor = "Z")
	private boolean redrawTitleBackground = false;

	@OriginalMember(owner = "client!client", name = "gb", descriptor = "Lclient!ob;")
	private DoublyLinkedList aClass28_1 = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!client", name = "hb", descriptor = "Lclient!tb;")
	private IsaacRandom randomIn;

	@OriginalMember(owner = "client!client", name = "ib", descriptor = "[Z")
	private final boolean[] cameraModifierEnabled = new boolean[5];

	@OriginalMember(owner = "client!client", name = "jb", descriptor = "I")
	private int privateChatSetting;

	@OriginalMember(owner = "client!client", name = "kb", descriptor = "I")
	private int anInt165 = 9;

	@OriginalMember(owner = "client!client", name = "lb", descriptor = "I")
	private int selectedTab = 3;

	@OriginalMember(owner = "client!client", name = "mb", descriptor = "[[I")
	private int[][] bfsCost = new int[104][104];

	@OriginalMember(owner = "client!client", name = "nb", descriptor = "I")
	private int anInt167 = 997;

	@OriginalMember(owner = "client!client", name = "ob", descriptor = "I")
	private int socialAction;

	@OriginalMember(owner = "client!client", name = "pb", descriptor = "I")
	private int sceneBaseTileX;

	@OriginalMember(owner = "client!client", name = "qb", descriptor = "I")
	private int sceneBaseTileZ;

	@OriginalMember(owner = "client!client", name = "rb", descriptor = "I")
	private int anInt171;

	@OriginalMember(owner = "client!client", name = "sb", descriptor = "I")
	private int anInt172;

	@OriginalMember(owner = "client!client", name = "tb", descriptor = "Ljava/lang/String;")
	private String socialInput = "";

	@OriginalMember(owner = "client!client", name = "ub", descriptor = "B")
	private final byte aByte8 = 106;

	@OriginalMember(owner = "client!client", name = "vb", descriptor = "Lclient!ob;")
	private DoublyLinkedList aClass28_2 = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!client", name = "wb", descriptor = "[J")
	private final long[] ignoreName37 = new long[100];

	@OriginalMember(owner = "client!client", name = "xb", descriptor = "I")
	private int weightCarried;

	@OriginalMember(owner = "client!client", name = "yb", descriptor = "[[B")
	private byte[][] sceneMapLandData;

	@OriginalMember(owner = "client!client", name = "zb", descriptor = "I")
	private int anInt174 = 723;

	@OriginalMember(owner = "client!client", name = "Ab", descriptor = "I")
	public static int anInt175;

	@OriginalMember(owner = "client!client", name = "Bb", descriptor = "[I")
	private int[] friendWorld = new int[100];

	@OriginalMember(owner = "client!client", name = "Cb", descriptor = "I")
	private int anInt176 = -1;

	@OriginalMember(owner = "client!client", name = "Db", descriptor = "Ljava/lang/String;")
	private String socialMessage = "";

	@OriginalMember(owner = "client!client", name = "Eb", descriptor = "[Lclient!hb;")
	private Image24[] imageHitmarks = new Image24[20];

	@OriginalMember(owner = "client!client", name = "Fb", descriptor = "J")
	private long aLong7;

	@OriginalMember(owner = "client!client", name = "Gb", descriptor = "I")
	private final int anInt177 = 332;

	@OriginalMember(owner = "client!client", name = "Hb", descriptor = "I")
	private int packetSize;

	@OriginalMember(owner = "client!client", name = "Ib", descriptor = "I")
	private int packetType;

	@OriginalMember(owner = "client!client", name = "Jb", descriptor = "I")
	private int idleNetCycles;

	@OriginalMember(owner = "client!client", name = "Kb", descriptor = "I")
	private int heartbeatTimer;

	@OriginalMember(owner = "client!client", name = "Lb", descriptor = "I")
	private int idleTimeout;

	@OriginalMember(owner = "client!client", name = "Mb", descriptor = "Ljava/lang/String;")
	private String aString7 = "";

	@OriginalMember(owner = "client!client", name = "Nb", descriptor = "I")
	private int cameraOffsetCycle;

	@OriginalMember(owner = "client!client", name = "Ob", descriptor = "I")
	private int anInt184 = -1;

	@OriginalMember(owner = "client!client", name = "Pb", descriptor = "Z")
	private boolean aBoolean38 = true;

	@OriginalMember(owner = "client!client", name = "Qb", descriptor = "Z")
	private boolean updateDesignModel = false;

	@OriginalMember(owner = "client!client", name = "Rb", descriptor = "[I")
	private final int[] designIdentikits = new int[7];

	@OriginalMember(owner = "client!client", name = "Sb", descriptor = "B")
	private final byte aByte9 = 8;

	@OriginalMember(owner = "client!client", name = "Tb", descriptor = "[Lclient!hb;")
	private Image24[] aClass1_Sub3_Sub2_Sub2Array4 = new Image24[1000];

	@OriginalMember(owner = "client!client", name = "Ub", descriptor = "I")
	private int anInt185 = 78;

	@OriginalMember(owner = "client!client", name = "Vb", descriptor = "I")
	private int ignoreCount;

	@OriginalMember(owner = "client!client", name = "Wb", descriptor = "[[[I")
	private int[][][] levelHeightmap;

	@OriginalMember(owner = "client!client", name = "Xb", descriptor = "Lclient!kb;")
	private Buffer in = Buffer.method378(1, -737);

	@OriginalMember(owner = "client!client", name = "Yb", descriptor = "I")
	private int anInt187;

	@OriginalMember(owner = "client!client", name = "Zb", descriptor = "I")
	public static int anInt188;

	@OriginalMember(owner = "client!client", name = "ac", descriptor = "Lclient!kb;")
	private Buffer out = Buffer.method378(1, -737);

	@OriginalMember(owner = "client!client", name = "bc", descriptor = "Z")
	private boolean aBoolean40 = false;

	@OriginalMember(owner = "client!client", name = "cc", descriptor = "I")
	private int chatEffects;

	@OriginalMember(owner = "client!client", name = "dc", descriptor = "I")
	private int hintNpc;

	@OriginalMember(owner = "client!client", name = "ec", descriptor = "I")
	private int overrideChat;

	@OriginalMember(owner = "client!client", name = "fc", descriptor = "I")
	private final int anInt192 = 3;

	@OriginalMember(owner = "client!client", name = "gc", descriptor = "I")
	public static int anInt193;

	@OriginalMember(owner = "client!client", name = "hc", descriptor = "I")
	private int anInt194 = -655;

	@OriginalMember(owner = "client!client", name = "ic", descriptor = "I")
	public static int anInt195;

	@OriginalMember(owner = "client!client", name = "jc", descriptor = "[I")
	private final int[] skillLevel = new int[50];

	@OriginalMember(owner = "client!client", name = "kc", descriptor = "Lclient!hc;")
	private final IfType aClass15_1 = new IfType();

	@OriginalMember(owner = "client!client", name = "lc", descriptor = "[I")
	private final int[] waveLoops = new int[50];

	@OriginalMember(owner = "client!client", name = "mc", descriptor = "I")
	private int mouseButtonsOption;

	@OriginalMember(owner = "client!client", name = "nc", descriptor = "[I")
	private final int[] archiveChecksum = new int[9];

	@OriginalMember(owner = "client!client", name = "oc", descriptor = "Z")
	private boolean aBoolean41 = true;

	@OriginalMember(owner = "client!client", name = "pc", descriptor = "I")
	private final int anInt197 = 4277;

	@OriginalMember(owner = "client!client", name = "qc", descriptor = "[Lclient!ib;")
	private Image8[] imageSideicons = new Image8[13];

	@OriginalMember(owner = "client!client", name = "rc", descriptor = "I")
	private int anInt198;

	@OriginalMember(owner = "client!client", name = "sc", descriptor = "I")
	private int orbitCameraPitch = 128;

	@OriginalMember(owner = "client!client", name = "tc", descriptor = "I")
	private int orbitCameraYaw;

	@OriginalMember(owner = "client!client", name = "uc", descriptor = "I")
	private int orbitCameraYawVelocity;

	@OriginalMember(owner = "client!client", name = "vc", descriptor = "I")
	private int orbitCameraPitchVelocity;

	@OriginalMember(owner = "client!client", name = "wc", descriptor = "I")
	private final int anInt203 = 2048;

	@OriginalMember(owner = "client!client", name = "xc", descriptor = "I")
	private final int LOCAL_PLAYER_INDEX = 2047;

	@OriginalMember(owner = "client!client", name = "yc", descriptor = "[Lclient!z;")
	private PlayerEntity[] players = new PlayerEntity[this.anInt203];

	@OriginalMember(owner = "client!client", name = "zc", descriptor = "I")
	private int playerCount;

	@OriginalMember(owner = "client!client", name = "Ac", descriptor = "[I")
	private int[] playerIds = new int[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Bc", descriptor = "I")
	private int entityUpdateCount;

	@OriginalMember(owner = "client!client", name = "Cc", descriptor = "[I")
	private int[] entityUpdateIds = new int[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Dc", descriptor = "[Lclient!kb;")
	private Buffer[] playerAppearanceBuffer = new Buffer[this.anInt203];

	@OriginalMember(owner = "client!client", name = "Ec", descriptor = "I")
	private int lastPacketType0;

	@OriginalMember(owner = "client!client", name = "Fc", descriptor = "I")
	private int lastPacketType1;

	@OriginalMember(owner = "client!client", name = "Gc", descriptor = "I")
	private int lastPacketType2;

	@OriginalMember(owner = "client!client", name = "Hc", descriptor = "Lclient!r;")
	private Scene scene;

	@OriginalMember(owner = "client!client", name = "Ic", descriptor = "Lclient!ob;")
	private DoublyLinkedList projectiles = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!client", name = "Jc", descriptor = "I")
	private int anInt210;

	@OriginalMember(owner = "client!client", name = "Kc", descriptor = "[Ljava/lang/String;")
	private String[] menuOption = new String[500];

	@OriginalMember(owner = "client!client", name = "Lc", descriptor = "Z")
	private boolean midiActive = true;

	@OriginalMember(owner = "client!client", name = "Mc", descriptor = "Z")
	private boolean designGenderMale = true;

	@OriginalMember(owner = "client!client", name = "Nc", descriptor = "I")
	private int sceneCycle;

	@OriginalMember(owner = "client!client", name = "Oc", descriptor = "I")
	private int sceneCenterZoneX;

	@OriginalMember(owner = "client!client", name = "Pc", descriptor = "I")
	private int sceneCenterZoneZ;

	@OriginalMember(owner = "client!client", name = "Qc", descriptor = "[[[B")
	private byte[][][] levelTileFlags;

	@OriginalMember(owner = "client!client", name = "Rc", descriptor = "[I")
	private int[] flameBuffer0;

	@OriginalMember(owner = "client!client", name = "Sc", descriptor = "[I")
	private int[] flameBuffer1;

	@OriginalMember(owner = "client!client", name = "Tc", descriptor = "B")
	private final byte aByte10 = 4;

	@OriginalMember(owner = "client!client", name = "Uc", descriptor = "I")
	private int objDragInterfaceId;

	@OriginalMember(owner = "client!client", name = "Vc", descriptor = "I")
	private int objDragSlot;

	@OriginalMember(owner = "client!client", name = "Wc", descriptor = "I")
	private int objDragArea;

	@OriginalMember(owner = "client!client", name = "Xc", descriptor = "I")
	private int objGrabX;

	@OriginalMember(owner = "client!client", name = "Yc", descriptor = "I")
	private int objGrabY;

	@OriginalMember(owner = "client!client", name = "Zc", descriptor = "Z")
	private boolean aBoolean44 = false;

	@OriginalMember(owner = "client!client", name = "ad", descriptor = "[I")
	private final int[] anIntArray43 = new int[256];

	@OriginalMember(owner = "client!client", name = "bd", descriptor = "B")
	private final byte aByte11 = 2;

	@OriginalMember(owner = "client!client", name = "cd", descriptor = "Lclient!qb;")
	private DrawArea areaBackbase1;

	@OriginalMember(owner = "client!client", name = "dd", descriptor = "Lclient!qb;")
	private DrawArea areaBackbase2;

	@OriginalMember(owner = "client!client", name = "ed", descriptor = "Lclient!qb;")
	private DrawArea areaBackhmid1;

	@OriginalMember(owner = "client!client", name = "fd", descriptor = "I")
	private int anInt219;

	@OriginalMember(owner = "client!client", name = "gd", descriptor = "[I")
	private final int[] compassMaskLineOffsets = new int[33];

	@OriginalMember(owner = "client!client", name = "hd", descriptor = "I")
	public static int anInt220;

	@OriginalMember(owner = "client!client", name = "id", descriptor = "[I")
	private final int[] waveDelay = new int[50];

	@OriginalMember(owner = "client!client", name = "jd", descriptor = "I")
	private int anInt221;

	@OriginalMember(owner = "client!client", name = "kd", descriptor = "Z")
	private boolean aBoolean45 = false;

	@OriginalMember(owner = "client!client", name = "ld", descriptor = "[I")
	private final int[] tabInterfaceId = new int[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	@OriginalMember(owner = "client!client", name = "md", descriptor = "I")
	private int baseX;

	@OriginalMember(owner = "client!client", name = "nd", descriptor = "I")
	private int baseZ;

	@OriginalMember(owner = "client!client", name = "od", descriptor = "[I")
	private static final int[] levelExperience = new int[99];

	@OriginalMember(owner = "client!client", name = "pd", descriptor = "Z")
	private boolean errorLoading = false;

	@OriginalMember(owner = "client!client", name = "qd", descriptor = "B")
	private final byte aByte12 = 99;

	@OriginalMember(owner = "client!client", name = "rd", descriptor = "I")
	public static int anInt224;

	@OriginalMember(owner = "client!client", name = "sd", descriptor = "I")
	private int anInt225;

	@OriginalMember(owner = "client!client", name = "td", descriptor = "Z")
	private boolean showSocialInput = false;

	@OriginalMember(owner = "client!client", name = "ud", descriptor = "Z")
	public static boolean aBoolean48 = true;

	@OriginalMember(owner = "client!client", name = "vd", descriptor = "B")
	public static final byte aByte13 = 15;

	@OriginalMember(owner = "client!client", name = "wd", descriptor = "Z")
	private boolean pressedContinueOption = false;

	@OriginalMember(owner = "client!client", name = "xd", descriptor = "I")
	private int daysSinceLastLogin;

	@OriginalMember(owner = "client!client", name = "yd", descriptor = "I")
	private int anInt227;

	@OriginalMember(owner = "client!client", name = "zd", descriptor = "I")
	private int anInt228;

	@OriginalMember(owner = "client!client", name = "Ad", descriptor = "I")
	public static int anInt229;

	@OriginalMember(owner = "client!client", name = "Bd", descriptor = "I")
	private final int anInt230 = 100;

	@OriginalMember(owner = "client!client", name = "Cd", descriptor = "[I")
	private final int[] anIntArray48 = new int[100];

	@OriginalMember(owner = "client!client", name = "Dd", descriptor = "Z")
	private boolean menuVisible = false;

	@OriginalMember(owner = "client!client", name = "Ed", descriptor = "I")
	private int currentLevel;

	@OriginalMember(owner = "client!client", name = "Fd", descriptor = "Z")
	private boolean reportAbuseMuteOption = false;

	@OriginalMember(owner = "client!client", name = "Gd", descriptor = "I")
	public static int anInt232;

	@OriginalMember(owner = "client!client", name = "Hd", descriptor = "I")
	private int anInt233 = -655;

	@OriginalMember(owner = "client!client", name = "Id", descriptor = "Lclient!ob;")
	private DoublyLinkedList aClass28_4 = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!client", name = "Jd", descriptor = "I")
	private int tradeChatSetting;

	@OriginalMember(owner = "client!client", name = "Kd", descriptor = "I")
	public static int nodeId = 10;

	@OriginalMember(owner = "client!client", name = "Ld", descriptor = "I")
	public static int portOffset;

	@OriginalMember(owner = "client!client", name = "Md", descriptor = "Z")
	public static boolean members = true;

	@OriginalMember(owner = "client!client", name = "Nd", descriptor = "Z")
	public static boolean lowMemory;

	@OriginalMember(owner = "client!client", name = "Od", descriptor = "I")
	public static int anInt237;

	@OriginalMember(owner = "client!client", name = "Pd", descriptor = "Lclient!ib;")
	private Image8 imageRedstone1;

	@OriginalMember(owner = "client!client", name = "Qd", descriptor = "Lclient!ib;")
	private Image8 imageRedstone2;

	@OriginalMember(owner = "client!client", name = "Rd", descriptor = "Lclient!ib;")
	private Image8 imageRedstone3;

	@OriginalMember(owner = "client!client", name = "Sd", descriptor = "Lclient!ib;")
	private Image8 imageRedstone1h;

	@OriginalMember(owner = "client!client", name = "Td", descriptor = "Lclient!ib;")
	private Image8 imageRedstone2h;

	@OriginalMember(owner = "client!client", name = "Ud", descriptor = "[I")
	private final int[] messageType = new int[100];

	@OriginalMember(owner = "client!client", name = "Vd", descriptor = "[Ljava/lang/String;")
	private final String[] messageSender = new String[100];

	@OriginalMember(owner = "client!client", name = "Wd", descriptor = "[Ljava/lang/String;")
	private final String[] messageText = new String[100];

	@OriginalMember(owner = "client!client", name = "Xd", descriptor = "I")
	public static int anInt238 = 629;

	@OriginalMember(owner = "client!client", name = "Yd", descriptor = "J")
	private long aLong8;

	@OriginalMember(owner = "client!client", name = "Zd", descriptor = "I")
	private int daysSinceRecoveriesChanged;

	@OriginalMember(owner = "client!client", name = "ae", descriptor = "Z")
	private boolean flameActive = false;

	@OriginalMember(owner = "client!client", name = "be", descriptor = "[I")
	private int[] anIntArray50;

	@OriginalMember(owner = "client!client", name = "ce", descriptor = "[I")
	private int[] anIntArray51;

	@OriginalMember(owner = "client!client", name = "de", descriptor = "[I")
	private int[] anIntArray52;

	@OriginalMember(owner = "client!client", name = "ee", descriptor = "[I")
	private int[] anIntArray53;

	@OriginalMember(owner = "client!client", name = "fe", descriptor = "I")
	private int reportAbuseInterfaceID = -1;

	@OriginalMember(owner = "client!client", name = "ge", descriptor = "Lclient!ib;")
	private Image8 imageBackbase1;

	@OriginalMember(owner = "client!client", name = "he", descriptor = "Lclient!ib;")
	private Image8 imageBackbase2;

	@OriginalMember(owner = "client!client", name = "ie", descriptor = "Lclient!ib;")
	private Image8 imageBackhmid1;

	@OriginalMember(owner = "client!client", name = "je", descriptor = "I")
	private int hintType;

	@OriginalMember(owner = "client!client", name = "ke", descriptor = "Z")
	private boolean aBoolean55 = false;

	@OriginalMember(owner = "client!client", name = "le", descriptor = "I")
	public static int anInt242;

	@OriginalMember(owner = "client!client", name = "me", descriptor = "I")
	private int orbitCameraX;

	@OriginalMember(owner = "client!client", name = "ne", descriptor = "I")
	private int orbitCameraZ;

	@OriginalMember(owner = "client!client", name = "oe", descriptor = "I")
	private int cameraMovedWrite;

	@OriginalMember(owner = "client!client", name = "pe", descriptor = "I")
	private int anInt246;

	@OriginalMember(owner = "client!client", name = "qe", descriptor = "[I")
	private int[] anIntArray54 = new int[1000];

	@OriginalMember(owner = "client!client", name = "re", descriptor = "[I")
	private int[] anIntArray55 = new int[1000];

	@OriginalMember(owner = "client!client", name = "se", descriptor = "[[I")
	private int[][] anIntArrayArray3 = new int[104][104];

	@OriginalMember(owner = "client!client", name = "te", descriptor = "Z")
	private boolean redrawPrivacySettings = false;

	@OriginalMember(owner = "client!client", name = "ue", descriptor = "Ljava/math/BigInteger;")
	public static final BigInteger RSA_EXPONENT = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");

	@OriginalMember(owner = "client!client", name = "ve", descriptor = "Z")
	private boolean errorHost = false;

	@OriginalMember(owner = "client!client", name = "we", descriptor = "I")
	private int objDragCycles;

	@OriginalMember(owner = "client!client", name = "xe", descriptor = "[I")
	private int[] anIntArray56;

	@OriginalMember(owner = "client!client", name = "ye", descriptor = "[I")
	private final int[] skillBaseLevel = new int[50];

	@OriginalMember(owner = "client!client", name = "ze", descriptor = "[Lclient!y;")
	private NpcEntity[] npcs = new NpcEntity[8192];

	@OriginalMember(owner = "client!client", name = "Ae", descriptor = "I")
	private int npcCount;

	@OriginalMember(owner = "client!client", name = "Be", descriptor = "[I")
	private int[] npcIds = new int[8192];

	@OriginalMember(owner = "client!client", name = "Ce", descriptor = "I")
	private int minimapZoom;

	@OriginalMember(owner = "client!client", name = "De", descriptor = "I")
	private int minimapZoomModifier = 1;

	@OriginalMember(owner = "client!client", name = "Ee", descriptor = "I")
	private int cameraPitchClamp;

	@OriginalMember(owner = "client!client", name = "Fe", descriptor = "I")
	private int anInt252;

	@OriginalMember(owner = "client!client", name = "Ge", descriptor = "I")
	private int dragCycles;

	@OriginalMember(owner = "client!client", name = "He", descriptor = "B")
	private final byte aByte14 = -46;

	@OriginalMember(owner = "client!client", name = "Ie", descriptor = "Ljava/lang/String;")
	private String modalMessage;

	@OriginalMember(owner = "client!client", name = "Je", descriptor = "I")
	public static int anInt254;

	@OriginalMember(owner = "client!client", name = "Ke", descriptor = "[I")
	private int[] varps = new int[2000];

	@OriginalMember(owner = "client!client", name = "Le", descriptor = "I")
	private int entityRemovalCount;

	@OriginalMember(owner = "client!client", name = "Me", descriptor = "[I")
	private int[] entityRemovalIds = new int[1000];

	@OriginalMember(owner = "client!client", name = "Ne", descriptor = "I")
	private int anInt256;

	@OriginalMember(owner = "client!client", name = "Pe", descriptor = "[J")
	private long[] friendName37 = new long[100];

	@OriginalMember(owner = "client!client", name = "Qe", descriptor = "I")
	private int selectedCycle;

	@OriginalMember(owner = "client!client", name = "Re", descriptor = "I")
	private int anInt258;

	@OriginalMember(owner = "client!client", name = "Se", descriptor = "I")
	private int anInt259;

	@OriginalMember(owner = "client!client", name = "Te", descriptor = "I")
	private int selectedArea;

	@OriginalMember(owner = "client!client", name = "Ue", descriptor = "I")
	private int cutsceneDstLocalTileX;

	@OriginalMember(owner = "client!client", name = "Ve", descriptor = "I")
	private int cutsceneDstLocalTileZ;

	@OriginalMember(owner = "client!client", name = "We", descriptor = "I")
	private int cutsceneDstHeight;

	@OriginalMember(owner = "client!client", name = "Xe", descriptor = "I")
	private int cutsceneRotateSpeed;

	@OriginalMember(owner = "client!client", name = "Ye", descriptor = "I")
	private int cutsceneRotateAcceleration;

	@OriginalMember(owner = "client!client", name = "Ze", descriptor = "[I")
	private final int[] minimapMaskLineLengths = new int[151];

	@OriginalMember(owner = "client!client", name = "af", descriptor = "[Lclient!ec;")
	private CollisionMap[] levelCollisionMap = new CollisionMap[4];

	@OriginalMember(owner = "client!client", name = "bf", descriptor = "I")
	public static int loopCycle;

	@OriginalMember(owner = "client!client", name = "cf", descriptor = "[Lclient!hb;")
	private Image24[] imageHeadicons = new Image24[20];

	@OriginalMember(owner = "client!client", name = "df", descriptor = "I")
	private int systemUpdateTimer;

	@OriginalMember(owner = "client!client", name = "ef", descriptor = "I")
	public static int anInt268 = 3;

	@OriginalMember(owner = "client!client", name = "ff", descriptor = "[I")
	private final int[] cameraModifierJitter = new int[5];

	@OriginalMember(owner = "client!client", name = "gf", descriptor = "Z")
	private boolean objGrabThreshold = false;

	@OriginalMember(owner = "client!client", name = "hf", descriptor = "Lclient!hb;")
	private Image24 genderButtonImage0;

	@OriginalMember(owner = "client!client", name = "jf", descriptor = "Lclient!hb;")
	private Image24 genderButtonImage1;

	@OriginalMember(owner = "client!client", name = "kf", descriptor = "I")
	private int midiSyncCrc;

	@OriginalMember(owner = "client!client", name = "lf", descriptor = "Z")
	private boolean redrawSidebar = false;

	@OriginalMember(owner = "client!client", name = "mf", descriptor = "Z")
	private boolean redrawChatback = false;

	@OriginalMember(owner = "client!client", name = "nf", descriptor = "[I")
	private final int[] cameraModifierWobbleScale = new int[5];

	@OriginalMember(owner = "client!client", name = "of", descriptor = "Lclient!z;")
	private PlayerEntity localPlayer;

	@OriginalMember(owner = "client!client", name = "pf", descriptor = "Z")
	private boolean cutscene = false;

	@OriginalMember(owner = "client!client", name = "qf", descriptor = "I")
	private int sceneDelta;

	@OriginalMember(owner = "client!client", name = "rf", descriptor = "Ljava/lang/String;")
	private String reportAbuseInput = "";

	@OriginalMember(owner = "client!client", name = "sf", descriptor = "I")
	private int viewportInterfaceID = -1;

	@OriginalMember(owner = "client!client", name = "tf", descriptor = "I")
	private int anInt272;

	@OriginalMember(owner = "client!client", name = "uf", descriptor = "[Lclient!ib;")
	private Image8[] aClass1_Sub3_Sub2_Sub3Array2;

	@OriginalMember(owner = "client!client", name = "vf", descriptor = "Z")
	private boolean ingame = false;

	@OriginalMember(owner = "client!client", name = "wf", descriptor = "Z")
	private boolean aBoolean63 = false;

	@OriginalMember(owner = "client!client", name = "xf", descriptor = "I")
	private int publicChatSetting;

	@OriginalMember(owner = "client!client", name = "yf", descriptor = "I")
	private int anInt274;

	@OriginalMember(owner = "client!client", name = "zf", descriptor = "Lclient!hb;")
	private Image24 aClass1_Sub3_Sub2_Sub2_3;

	@OriginalMember(owner = "client!client", name = "Af", descriptor = "Lclient!hb;")
	private Image24 aClass1_Sub3_Sub2_Sub2_4;

	@OriginalMember(owner = "client!client", name = "Bf", descriptor = "I")
	private final int anInt275 = 3353893;

	@OriginalMember(owner = "client!client", name = "Cf", descriptor = "Lclient!ib;")
	private Image8 imageInvback;

	@OriginalMember(owner = "client!client", name = "Df", descriptor = "Lclient!ib;")
	private Image8 imageMapback;

	@OriginalMember(owner = "client!client", name = "Ef", descriptor = "Lclient!ib;")
	private Image8 imageChatback;

	@OriginalMember(owner = "client!client", name = "Ff", descriptor = "I")
	private int anInt276;

	@OriginalMember(owner = "client!client", name = "Gf", descriptor = "Lclient!jb;")
	private BitmapFont fontPlain11;

	@OriginalMember(owner = "client!client", name = "Hf", descriptor = "Lclient!jb;")
	private BitmapFont fontPlain12;

	@OriginalMember(owner = "client!client", name = "If", descriptor = "Lclient!jb;")
	private BitmapFont fontBold12;

	@OriginalMember(owner = "client!client", name = "Jf", descriptor = "Lclient!jb;")
	private BitmapFont fontQuill8;

	@OriginalMember(owner = "client!client", name = "Kf", descriptor = "I")
	private int tryMoveNearest;

	@OriginalMember(owner = "client!client", name = "Lf", descriptor = "Z")
	private final boolean aBoolean64 = false;

	@OriginalMember(owner = "client!client", name = "Mf", descriptor = "[I")
	private int[] anIntArray64;

	@OriginalMember(owner = "client!client", name = "Nf", descriptor = "[I")
	private int[] anIntArray65;

	@OriginalMember(owner = "client!client", name = "Of", descriptor = "I")
	private final int anInt278 = 7759444;

	@OriginalMember(owner = "client!client", name = "Pf", descriptor = "[I")
	private int[] bfsStepX = new int[4000];

	@OriginalMember(owner = "client!client", name = "Qf", descriptor = "[I")
	private int[] bfsStepZ = new int[4000];

	@OriginalMember(owner = "client!client", name = "Rf", descriptor = "Ljava/util/zip/CRC32;")
	private final CRC32 crc32 = new CRC32();

	@OriginalMember(owner = "client!client", name = "Sf", descriptor = "Lclient!hb;")
	private Image24 imageMapflag;

	@OriginalMember(owner = "client!client", name = "Tf", descriptor = "I")
	public static int updateCounter;

	@OriginalMember(owner = "client!client", name = "Uf", descriptor = "Lclient!d;")
	private Connection connection;

	@OriginalMember(owner = "client!client", name = "Vf", descriptor = "[[B")
	private byte[][] aByteArrayArray2;

	@OriginalMember(owner = "client!client", name = "Wf", descriptor = "I")
	private int chatInterfaceId = -1;

	@OriginalMember(owner = "client!client", name = "Xf", descriptor = "I")
	private int objSelected;

	@OriginalMember(owner = "client!client", name = "Yf", descriptor = "I")
	private int anInt282;

	@OriginalMember(owner = "client!client", name = "Zf", descriptor = "I")
	private int anInt283;

	@OriginalMember(owner = "client!client", name = "ag", descriptor = "I")
	private int anInt284;

	@OriginalMember(owner = "client!client", name = "bg", descriptor = "Ljava/lang/String;")
	private String selectedObjName;

	@OriginalMember(owner = "client!client", name = "cg", descriptor = "Lclient!qb;")
	private DrawArea areaBackleft1;

	@OriginalMember(owner = "client!client", name = "dg", descriptor = "Lclient!qb;")
	private DrawArea areaBackleft2;

	@OriginalMember(owner = "client!client", name = "eg", descriptor = "Lclient!qb;")
	private DrawArea areaBackright1;

	@OriginalMember(owner = "client!client", name = "fg", descriptor = "Lclient!qb;")
	private DrawArea areaBackright2;

	@OriginalMember(owner = "client!client", name = "gg", descriptor = "Lclient!qb;")
	private DrawArea areaBacktop1;

	@OriginalMember(owner = "client!client", name = "hg", descriptor = "Lclient!qb;")
	private DrawArea areaBacktop2;

	@OriginalMember(owner = "client!client", name = "ig", descriptor = "Lclient!qb;")
	private DrawArea areaBackvmid1;

	@OriginalMember(owner = "client!client", name = "jg", descriptor = "Lclient!qb;")
	private DrawArea areaBackvmid2;

	@OriginalMember(owner = "client!client", name = "kg", descriptor = "Lclient!qb;")
	private DrawArea areaBackvmid3;

	@OriginalMember(owner = "client!client", name = "lg", descriptor = "Lclient!qb;")
	private DrawArea areaBackhmid2;

	@OriginalMember(owner = "client!client", name = "ng", descriptor = "I")
	private int waveCount;

	@OriginalMember(owner = "client!client", name = "og", descriptor = "I")
	private int projectX = -1;

	@OriginalMember(owner = "client!client", name = "pg", descriptor = "I")
	private int projectY = -1;

	@OriginalMember(owner = "client!client", name = "qg", descriptor = "I")
	private int stickyChatInterfaceId = -1;

	@OriginalMember(owner = "client!client", name = "rg", descriptor = "I")
	private int anInt290;

	@OriginalMember(owner = "client!client", name = "sg", descriptor = "Z")
	private boolean rights = false;

	@OriginalMember(owner = "client!client", name = "tg", descriptor = "[I")
	private final int[] cameraModifierCycle = new int[5];

	@OriginalMember(owner = "client!client", name = "ug", descriptor = "I")
	private int spellSelected;

	@OriginalMember(owner = "client!client", name = "vg", descriptor = "I")
	private int anInt292;

	@OriginalMember(owner = "client!client", name = "wg", descriptor = "I")
	private int anInt293;

	@OriginalMember(owner = "client!client", name = "xg", descriptor = "Ljava/lang/String;")
	private String spellCaption;

	@OriginalMember(owner = "client!client", name = "yg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle2;

	@OriginalMember(owner = "client!client", name = "zg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle3;

	@OriginalMember(owner = "client!client", name = "Ag", descriptor = "Lclient!qb;")
	private DrawArea imageTitle4;

	@OriginalMember(owner = "client!client", name = "Bg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle0;

	@OriginalMember(owner = "client!client", name = "Cg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle1;

	@OriginalMember(owner = "client!client", name = "Dg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle5;

	@OriginalMember(owner = "client!client", name = "Eg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle6;

	@OriginalMember(owner = "client!client", name = "Fg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle7;

	@OriginalMember(owner = "client!client", name = "Gg", descriptor = "Lclient!qb;")
	private DrawArea imageTitle8;

	@OriginalMember(owner = "client!client", name = "Hg", descriptor = "[Lclient!ib;")
	private Image8[] imageMapscene = new Image8[50];

	@OriginalMember(owner = "client!client", name = "Ig", descriptor = "I")
	private int anInt294 = 27808;

	@OriginalMember(owner = "client!client", name = "Jg", descriptor = "Lclient!ib;")
	private Image8 imageRedstone1v;

	@OriginalMember(owner = "client!client", name = "Kg", descriptor = "Lclient!ib;")
	private Image8 imageRedstone2v;

	@OriginalMember(owner = "client!client", name = "Lg", descriptor = "Lclient!ib;")
	private Image8 imageRedstone3v;

	@OriginalMember(owner = "client!client", name = "Mg", descriptor = "Lclient!ib;")
	private Image8 imageRedstone1hv;

	@OriginalMember(owner = "client!client", name = "Ng", descriptor = "Lclient!ib;")
	private Image8 imageRedstone2hv;

	@OriginalMember(owner = "client!client", name = "Og", descriptor = "[I")
	private final int[] CHAT_COLORS = new int[] { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };

	@OriginalMember(owner = "client!client", name = "Pg", descriptor = "Lclient!qb;")
	private DrawArea areaSidebar;

	@OriginalMember(owner = "client!client", name = "Qg", descriptor = "Lclient!qb;")
	private DrawArea areaMapback;

	@OriginalMember(owner = "client!client", name = "Rg", descriptor = "Lclient!qb;")
	private DrawArea areaViewport;

	@OriginalMember(owner = "client!client", name = "Sg", descriptor = "Lclient!qb;")
	private DrawArea areaChatback;

	@OriginalMember(owner = "client!client", name = "Tg", descriptor = "I")
	private final int anInt295 = 2301979;

	@OriginalMember(owner = "client!client", name = "Ug", descriptor = "I")
	private int flagSceneTileX;

	@OriginalMember(owner = "client!client", name = "Vg", descriptor = "I")
	private int flagSceneTileZ;

	@OriginalMember(owner = "client!client", name = "Wg", descriptor = "Lclient!hb;")
	private Image24 imageMinimap;

	@OriginalMember(owner = "client!client", name = "Xg", descriptor = "I")
	private int unreadMessages;

	@OriginalMember(owner = "client!client", name = "Yg", descriptor = "Z")
	private boolean chatbackInput = false;

	@OriginalMember(owner = "client!client", name = "Zg", descriptor = "Lclient!ob;")
	private DoublyLinkedList aClass28_5 = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!client", name = "ah", descriptor = "Lclient!hb;")
	private Image24 imageMapdot0;

	@OriginalMember(owner = "client!client", name = "bh", descriptor = "Lclient!hb;")
	private Image24 imageMapdot1;

	@OriginalMember(owner = "client!client", name = "ch", descriptor = "Lclient!hb;")
	private Image24 imageMapdot2;

	@OriginalMember(owner = "client!client", name = "dh", descriptor = "Lclient!hb;")
	private Image24 imageMapdot3;

	@OriginalMember(owner = "client!client", name = "eh", descriptor = "I")
	private int lastAddress;

	@OriginalMember(owner = "client!client", name = "fh", descriptor = "Ljava/math/BigInteger;")
	public static final BigInteger RSA_MODULUS = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");

	@OriginalMember(owner = "client!client", name = "gh", descriptor = "I")
	private int anInt300;

	@OriginalMember(owner = "client!client", name = "hh", descriptor = "Ljava/lang/String;")
	private String midiSyncName;

	@OriginalMember(owner = "client!client", name = "ih", descriptor = "I")
	private int anInt301 = -1;

	@OriginalMember(owner = "client!client", name = "jh", descriptor = "Ljava/lang/String;")
	private String username = "";

	@OriginalMember(owner = "client!client", name = "kh", descriptor = "Ljava/lang/String;")
	private String aString14 = "";

	@OriginalMember(owner = "client!client", name = "lh", descriptor = "B")
	private final byte aByte15 = 7;

	@OriginalMember(owner = "client!client", name = "mh", descriptor = "[B")
	private byte[] aByteArray4 = new byte[16384];

	@OriginalMember(owner = "client!client", name = "nh", descriptor = "Z")
	private boolean errorStarted = false;

	@OriginalMember(owner = "client!client", name = "oh", descriptor = "I")
	private final int anInt302 = 242;

	@OriginalMember(owner = "client!client", name = "ph", descriptor = "I")
	private int energy;

	@OriginalMember(owner = "client!client", name = "rh", descriptor = "I")
	private int menuSize;

	@OriginalMember(owner = "client!client", name = "sh", descriptor = "[I")
	private final int[] varCache = new int[2000];

	@OriginalMember(owner = "client!client", name = "th", descriptor = "I")
	private int hintPlayer;

	@OriginalMember(owner = "client!client", name = "uh", descriptor = "I")
	private int anInt306;

	@OriginalMember(owner = "client!client", name = "vh", descriptor = "I")
	private int sceneState;

	@OriginalMember(owner = "client!client", name = "wh", descriptor = "[I")
	private final int[] skillExperience = new int[50];

	@OriginalMember(owner = "client!client", name = "xh", descriptor = "Z")
	private boolean redrawSideicons = false;

	@OriginalMember(owner = "client!client", name = "yh", descriptor = "Lclient!ib;")
	private Image8 imageScrollbar0;

	@OriginalMember(owner = "client!client", name = "zh", descriptor = "Lclient!ib;")
	private Image8 imageScrollbar1;

	@OriginalMember(owner = "client!client", name = "Ah", descriptor = "Ljava/lang/String;")
	private String loginMessage0 = "";

	@OriginalMember(owner = "client!client", name = "Bh", descriptor = "Ljava/lang/String;")
	private String loginMessage1 = "";

	@OriginalMember(owner = "client!client", name = "Ch", descriptor = "I")
	private int minimapAnticheatAngle;

	@OriginalMember(owner = "client!client", name = "Dh", descriptor = "I")
	private int minimapAngleModifier = 2;

	@OriginalMember(owner = "client!client", name = "Eh", descriptor = "I")
	private int hoveredSlot;

	@OriginalMember(owner = "client!client", name = "Fh", descriptor = "I")
	private int hoveredSlotParentId;

	@OriginalMember(owner = "client!client", name = "Gh", descriptor = "I")
	private int friendCount;

	@OriginalMember(owner = "client!client", name = "Hh", descriptor = "I")
	public static int update2Counter;

	@OriginalMember(owner = "client!client", name = "Ih", descriptor = "I")
	private int chatCount;

	@OriginalMember(owner = "client!client", name = "Jh", descriptor = "I")
	private final int MAX_CHATS = 50;

	@OriginalMember(owner = "client!client", name = "Kh", descriptor = "[I")
	private final int[] chatX = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Lh", descriptor = "[I")
	private final int[] chatY = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Mh", descriptor = "[I")
	private final int[] chatHeight = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Nh", descriptor = "[I")
	private final int[] chatWidth = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Oh", descriptor = "[I")
	private final int[] chatColors = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Ph", descriptor = "[I")
	private final int[] chatStyles = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Qh", descriptor = "[I")
	private final int[] chatTimers = new int[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Rh", descriptor = "[Ljava/lang/String;")
	private final String[] chats = new String[this.MAX_CHATS];

	@OriginalMember(owner = "client!client", name = "Sh", descriptor = "I")
	private int anInt316;

	@OriginalMember(owner = "client!client", name = "Th", descriptor = "Z")
	public static boolean aBoolean69;

	@OriginalMember(owner = "client!client", name = "Uh", descriptor = "Lclient!ib;")
	private Image8 aClass1_Sub3_Sub2_Sub3_19;

	@OriginalMember(owner = "client!client", name = "Vh", descriptor = "Lclient!ib;")
	private Image8 aClass1_Sub3_Sub2_Sub3_20;

	@OriginalMember(owner = "client!client", name = "Wh", descriptor = "I")
	private final int anInt317 = -986;

	@OriginalMember(owner = "client!client", name = "Xh", descriptor = "I")
	private final int anInt318 = -35388;

	@OriginalMember(owner = "client!client", name = "Yh", descriptor = "[I")
	private final int[] anIntArray80 = new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };

	@OriginalMember(owner = "client!client", name = "Zh", descriptor = "I")
	public static int anInt319;

	@OriginalMember(owner = "client!client", name = "ai", descriptor = "I")
	private int anInt320;

	@OriginalMember(owner = "client!client", name = "bi", descriptor = "I")
	private int midiCrc;

	@OriginalMember(owner = "client!client", name = "ci", descriptor = "I")
	private int cameraX;

	@OriginalMember(owner = "client!client", name = "di", descriptor = "I")
	private int cameraY;

	@OriginalMember(owner = "client!client", name = "ei", descriptor = "I")
	private int cameraZ;

	@OriginalMember(owner = "client!client", name = "fi", descriptor = "I")
	private int cameraPitch;

	@OriginalMember(owner = "client!client", name = "gi", descriptor = "I")
	private int cameraYaw;

	@OriginalMember(owner = "client!client", name = "hi", descriptor = "B")
	public static final byte aByte16 = 3;

	@OriginalMember(owner = "client!client", name = "ii", descriptor = "[I")
	private final int[] compassMaskLineLengths = new int[33];

	@OriginalMember(owner = "client!client", name = "ji", descriptor = "[[I")
	private int[][] bfsDirection = new int[104][104];

	@OriginalMember(owner = "client!client", name = "ki", descriptor = "Ljava/lang/String;")
	private String currentMidi;

	@OriginalMember(owner = "client!client", name = "li", descriptor = "[Lclient!hb;")
	private Image24[] imageCrosses = new Image24[8];

	@OriginalMember(owner = "client!client", name = "mi", descriptor = "Z")
	private boolean flameThread = false;

	@OriginalMember(owner = "client!client", name = "ni", descriptor = "B")
	private final byte aByte17 = 94;

	@OriginalMember(owner = "client!client", name = "oi", descriptor = "Ljava/lang/Object;")
	private final Object midiSync = new Object();

	@OriginalMember(owner = "client!client", name = "pi", descriptor = "[I")
	private final int[] waveIds = new int[50];

	@OriginalMember(owner = "client!client", name = "qi", descriptor = "I")
	private int cameraAnticheatOffsetX;

	@OriginalMember(owner = "client!client", name = "ri", descriptor = "I")
	private int cameraOffsetXModifier = 2;

	@OriginalMember(owner = "client!client", name = "si", descriptor = "[Ljava/lang/String;")
	private String[] friendName = new String[100];

	@OriginalMember(owner = "client!client", name = "ti", descriptor = "I")
	private int flashingTab = -1;

	@OriginalMember(owner = "client!client", name = "ui", descriptor = "I")
	private int sidebarInterfaceId = -1;

	@OriginalMember(owner = "client!client", name = "vi", descriptor = "I")
	private int cameraAnticheatOffsetZ;

	@OriginalMember(owner = "client!client", name = "wi", descriptor = "I")
	private int cameraOffsetZModifier = 2;

	@OriginalMember(owner = "client!client", name = "xi", descriptor = "I")
	private int anInt333 = 29286;

	@OriginalMember(owner = "client!client", name = "yi", descriptor = "[I")
	private final int[] minimapMaskLineOffsets = new int[151];

	@OriginalMember(owner = "client!client", name = "zi", descriptor = "I")
	private int cameraAnticheatAngle;

	@OriginalMember(owner = "client!client", name = "Ai", descriptor = "I")
	private int cameraOffsetYawModifier = 1;

	@OriginalMember(owner = "client!client", name = "Bi", descriptor = "Lclient!ub;")
	private FileArchive archiveTitle;

	@OriginalMember(owner = "client!client", name = "Ci", descriptor = "Ljava/lang/String;")
	private String aString18 = "";

	@OriginalMember(owner = "client!client", name = "Di", descriptor = "[Lclient!hb;")
	private Image24[] imageMapfunction = new Image24[50];

	@OriginalMember(owner = "client!client", name = "Ei", descriptor = "[I")
	private int[] menuParamB = new int[500];

	@OriginalMember(owner = "client!client", name = "Fi", descriptor = "[I")
	private int[] menuParamC = new int[500];

	@OriginalMember(owner = "client!client", name = "Gi", descriptor = "[I")
	private int[] menuAction = new int[500];

	@OriginalMember(owner = "client!client", name = "Hi", descriptor = "[I")
	private int[] menuParamA = new int[500];

	@OriginalMember(owner = "client!client", name = "Ii", descriptor = "I")
	private final int anInt336 = 701;

	@OriginalMember(owner = "client!client", name = "Ji", descriptor = "Z")
	private boolean scrollGrabbed = false;

	@OriginalMember(owner = "client!client", name = "Ki", descriptor = "Lclient!hb;")
	private Image24 imageCompass;

	@OriginalMember(owner = "client!client", name = "Li", descriptor = "J")
	private long name37;

	@OriginalMember(owner = "client!client", name = "Mi", descriptor = "Z")
	private boolean aBoolean72 = true;

	@OriginalMember(owner = "client!client", name = "Ni", descriptor = "I")
	private int menuArea;

	@OriginalMember(owner = "client!client", name = "Oi", descriptor = "I")
	private int menuX;

	@OriginalMember(owner = "client!client", name = "Pi", descriptor = "I")
	private int menuY;

	@OriginalMember(owner = "client!client", name = "Qi", descriptor = "I")
	private int menuWidth;

	@OriginalMember(owner = "client!client", name = "Ri", descriptor = "I")
	private int menuHeight;

	@OriginalMember(owner = "client!client", name = "Si", descriptor = "Z")
	private boolean waveEnabled = true;

	@OriginalMember(owner = "client!client", name = "Ti", descriptor = "I")
	private int scrollInputPadding;

	@OriginalMember(owner = "client!client", name = "Ui", descriptor = "I")
	private int midiSize;

	@OriginalMember(owner = "client!client", name = "Vi", descriptor = "I")
	private int anInt344;

	@OriginalMember(owner = "client!client", name = "Wi", descriptor = "[[[Lclient!ob;")
	private DoublyLinkedList[][][] levelObjStacks = new DoublyLinkedList[4][104][104];

	@OriginalMember(owner = "client!client", name = "Xi", descriptor = "I")
	private final int anInt345 = 5063219;

	@OriginalMember(owner = "client!client", name = "Yi", descriptor = "[I")
	private final int[] cameraModifierWobbleSpeed = new int[5];

	@OriginalMember(owner = "client!client", name = "Zi", descriptor = "I")
	private final int anInt346 = -676;

	static {
		@Pc(6) int local6 = 0;
		for (@Pc(8) int local8 = 0; local8 < 99; local8++) {
			@Pc(13) int local13 = local8 + 1;
			@Pc(26) int local26 = (int) ((double) local13 + Math.pow(2.0D, (double) local13 / 7.0D) * 300.0D);
			local6 += local26;
			levelExperience[local8] = local6 / 4;
		}
	}

	@OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] arg0) {
		try {
			System.out.println("RS2 user client - release #" + 225);
			if (arg0.length == 4) {
				nodeId = Integer.parseInt(arg0[0]);
				portOffset = Integer.parseInt(arg0[1]);
				if (arg0[2].equals("lowmem")) {
					method88(true);
				} else if (arg0[2].equals("highmem")) {
					method167(9);
				} else {
					System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members]");
					return;
				}
				if (arg0[3].equals("free")) {
					members = false;
				} else if (arg0[3].equals("members")) {
					members = true;
				} else {
					System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members]");
					return;
				}
				signlink.startpriv(InetAddress.getByName("world2.runewiki.org"));
				@Pc(82) Game local82 = new Game();
				local82.method62(532, 789, 0);
			} else {
				System.out.println("Usage: node-id, port-offset, [lowmem/highmem], [free/members]");
			}
		} catch (@Pc(89) Exception local89) {
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(Z)V")
	public static void method88(@OriginalArg(0) boolean arg0) {
		try {
			if (!arg0) {
				aBoolean48 = !aBoolean48;
			}
			Scene.lowMemory = true;
			Draw3D.lowMemory = true;
			lowMemory = true;
			SceneBuilder.lowMemory = true;
		} catch (@Pc(17) RuntimeException local17) {
			signlink.reporterror("70501, " + arg0 + ", " + local17.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(II)Ljava/lang/String;")
	public static String method101(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(4) String local4 = String.valueOf(arg0);
			for (@Pc(9) int local9 = local4.length() - 3; local9 > 0; local9 -= 3) {
				local4 = local4.substring(0, local9) + "," + local4.substring(local9);
			}
			if (arg1 != 0) {
				throw new NullPointerException();
			}
			if (local4.length() > 8) {
				local4 = "@gre@" + local4.substring(0, local4.length() - 8) + " million @whi@(" + local4 + ")";
			} else if (local4.length() > 4) {
				local4 = "@cya@" + local4.substring(0, local4.length() - 4) + "K @whi@(" + local4 + ")";
			}
			return " " + local4;
		} catch (@Pc(95) RuntimeException local95) {
			signlink.reporterror("92962, " + arg0 + ", " + arg1 + ", " + local95.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IZI)Ljava/lang/String;")
	public static String method133(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg1) {
				throw new NullPointerException();
			}
			@Pc(9) int local9 = arg0 - arg2;
			if (local9 < -9) {
				return "@red@";
			} else if (local9 < -6) {
				return "@or3@";
			} else if (local9 < -3) {
				return "@or2@";
			} else if (local9 < 0) {
				return "@or1@";
			} else if (local9 > 9) {
				return "@gre@";
			} else if (local9 > 6) {
				return "@gr3@";
			} else if (local9 > 3) {
				return "@gr2@";
			} else if (local9 > 0) {
				return "@gr1@";
			} else {
				return "@yel@";
			}
		} catch (@Pc(50) RuntimeException local50) {
			signlink.reporterror("26325, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local50.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "B", descriptor = "(I)V")
	public static void method167(@OriginalArg(0) int arg0) {
		try {
			Scene.lowMemory = false;
			Draw3D.lowMemory = false;
			if (arg0 == 9) {
				lowMemory = false;
				SceneBuilder.lowMemory = false;
			}
		} catch (@Pc(13) RuntimeException local13) {
			signlink.reporterror("39707, " + arg0 + ", " + local13.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZI)Ljava/lang/String;")
	public static String method169(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
		try {
			if (!arg0) {
				anInt238 = 434;
			}
			if (arg1 < 100000) {
				return String.valueOf(arg1);
			} else if (arg1 < 10000000) {
				return arg1 / 1000 + "K";
			} else {
				return arg1 / 1000000 + "M";
			}
		} catch (@Pc(35) RuntimeException local35) {
			signlink.reporterror("32689, " + arg0 + ", " + arg1 + ", " + local35.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILjava/lang/String;I)V")
	private void method75(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg2 != null) {
				@Pc(5) Object local5 = this.midiSync;
				synchronized (this.midiSync) {
					this.midiSyncName = arg2;
					this.midiSyncCrc = arg1;
					this.midiSyncLen = arg3;
				}
				if (arg0) {
					this.packetType = -1;
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
			this.chatCount = 0;
			while (arg0 >= 0) {
				this.anInt233 = this.randomIn.method532();
			}
			@Pc(63) int local63;
			@Pc(84) int local84;
			for (@Pc(15) int local15 = -1; local15 < this.playerCount + this.npcCount; local15++) {
				@Pc(23) PathingEntity local23;
				if (local15 == -1) {
					local23 = this.localPlayer;
				} else if (local15 < this.playerCount) {
					local23 = this.players[this.playerIds[local15]];
				} else {
					local23 = this.npcs[this.npcIds[local15 - this.playerCount]];
				}
				if (local23 != null && local23.isVisible(false)) {
					if (local15 < this.playerCount) {
						local63 = 30;
						@Pc(66) PlayerEntity local66 = (PlayerEntity) local23;
						if (local66.headicons != 0) {
							this.method151(local23.height + 15, this.aBoolean45, local23);
							if (this.projectX > -1) {
								for (local84 = 0; local84 < 8; local84++) {
									if ((local66.headicons & 0x1 << local84) != 0) {
										this.imageHeadicons[local84].method322(this.projectY - local63, this.projectX - 12, false);
										local63 -= 25;
									}
								}
							}
						}
						if (local15 >= 0 && this.hintType == 10 && this.hintPlayer == this.playerIds[local15]) {
							this.method151(local23.height + 15, this.aBoolean45, local23);
							if (this.projectX > -1) {
								this.imageHeadicons[7].method322(this.projectY - local63, this.projectX - 12, false);
							}
						}
					} else if (this.hintType == 1 && this.hintNpc == this.npcIds[local15 - this.playerCount] && loopCycle % 20 < 10) {
						this.method151(local23.height + 15, this.aBoolean45, local23);
						if (this.projectX > -1) {
							this.imageHeadicons[2].method322(this.projectY - 28, this.projectX - 12, false);
						}
					}
					if (local23.chat != null && (local15 >= this.playerCount || this.publicChatSetting == 0 || this.publicChatSetting == 3 || this.publicChatSetting == 1 && this.method199(-20, ((PlayerEntity) local23).name))) {
						this.method151(local23.height, this.aBoolean45, local23);
						if (this.projectX > -1 && this.chatCount < this.MAX_CHATS) {
							this.chatWidth[this.chatCount] = this.fontBold12.method364(false, local23.chat) / 2;
							this.chatHeight[this.chatCount] = this.fontBold12.height;
							this.chatX[this.chatCount] = this.projectX;
							this.chatY[this.chatCount] = this.projectY;
							this.chatColors[this.chatCount] = local23.chatColor;
							this.chatStyles[this.chatCount] = local23.chatStyle;
							this.chatTimers[this.chatCount] = local23.chatTimer;
							this.chats[this.chatCount++] = local23.chat;
							if (this.chatEffects == 0 && local23.chatStyle == 1) {
								this.chatHeight[this.chatCount] += 10;
								this.chatY[this.chatCount] += 5;
							}
							if (this.chatEffects == 0 && local23.chatStyle == 2) {
								this.chatWidth[this.chatCount] = 60;
							}
						}
					}
					if (local23.combatCycle > loopCycle + 100) {
						this.method151(local23.height + 15, this.aBoolean45, local23);
						if (this.projectX > -1) {
							local63 = local23.health * 30 / local23.totalHealth;
							if (local63 > 30) {
								local63 = 30;
							}
							Draw2D.method358(this.projectY - 3, this.projectX - 15, 65280, (byte) 93, local63, 5);
							Draw2D.method358(this.projectY - 3, this.projectX - 15 + local63, 16711680, (byte) 93, 30 - local63, 5);
						}
					}
					if (local23.combatCycle > loopCycle + 330) {
						this.method151(local23.height / 2, this.aBoolean45, local23);
						if (this.projectX > -1) {
							this.imageHitmarks[local23.damageType].method322(this.projectY - 12, this.projectX - 12, false);
							this.fontPlain11.method362(this.projectY + 4, (byte) 6, 0, String.valueOf(local23.damage), this.projectX);
							this.fontPlain11.method362(this.projectY + 3, (byte) 6, 16777215, String.valueOf(local23.damage), this.projectX - 1);
						}
					}
				}
			}
			for (@Pc(483) int local483 = 0; local483 < this.chatCount; local483++) {
				local63 = this.chatX[local483];
				@Pc(495) int local495 = this.chatY[local483];
				local84 = this.chatWidth[local483];
				@Pc(505) int local505 = this.chatHeight[local483];
				@Pc(507) boolean local507 = true;
				while (local507) {
					local507 = false;
					for (@Pc(513) int local513 = 0; local513 < local483; local513++) {
						if (local495 + 2 > this.chatY[local513] - this.chatHeight[local513] && local495 - local505 < this.chatY[local513] + 2 && local63 - local84 < this.chatX[local513] + this.chatWidth[local513] && local63 + local84 > this.chatX[local513] - this.chatWidth[local513] && this.chatY[local513] - this.chatHeight[local513] < local495) {
							local495 = this.chatY[local513] - this.chatHeight[local513];
							local507 = true;
						}
					}
				}
				this.projectX = this.chatX[local483];
				this.projectY = this.chatY[local483] = local495;
				@Pc(612) String local612 = this.chats[local483];
				if (this.chatEffects == 0) {
					@Pc(617) int local617 = 16776960;
					if (this.chatColors[local483] < 6) {
						local617 = this.CHAT_COLORS[this.chatColors[local483]];
					}
					if (this.chatColors[local483] == 6) {
						local617 = this.sceneCycle % 20 < 10 ? 16711680 : 16776960;
					}
					if (this.chatColors[local483] == 7) {
						local617 = this.sceneCycle % 20 < 10 ? 255 : 65535;
					}
					if (this.chatColors[local483] == 8) {
						local617 = this.sceneCycle % 20 < 10 ? 45056 : 8454016;
					}
					@Pc(692) int local692;
					if (this.chatColors[local483] == 9) {
						local692 = 150 - this.chatTimers[local483];
						if (local692 < 50) {
							local617 = local692 * 1280 + 16711680;
						} else if (local692 < 100) {
							local617 = 16776960 - (local692 - 50) * 327680;
						} else if (local692 < 150) {
							local617 = (local692 - 100) * 5 + 65280;
						}
					}
					if (this.chatColors[local483] == 10) {
						local692 = 150 - this.chatTimers[local483];
						if (local692 < 50) {
							local617 = local692 * 5 + 16711680;
						} else if (local692 < 100) {
							local617 = 16711935 - (local692 - 50) * 327680;
						} else if (local692 < 150) {
							local617 = (local692 - 100) * 327680 + 255 - (local692 - 100) * 5;
						}
					}
					if (this.chatColors[local483] == 11) {
						local692 = 150 - this.chatTimers[local483];
						if (local692 < 50) {
							local617 = 16777215 - local692 * 327685;
						} else if (local692 < 100) {
							local617 = (local692 - 50) * 327685 + 65280;
						} else if (local692 < 150) {
							local617 = 16777215 - (local692 - 100) * 327680;
						}
					}
					if (this.chatStyles[local483] == 0) {
						this.fontBold12.method362(this.projectY + 1, (byte) 6, 0, local612, this.projectX);
						this.fontBold12.method362(this.projectY, (byte) 6, local617, local612, this.projectX);
					}
					if (this.chatStyles[local483] == 1) {
						this.fontBold12.method366(this.sceneCycle, (byte) 8, this.projectX, this.projectY + 1, 0, local612);
						this.fontBold12.method366(this.sceneCycle, (byte) 8, this.projectX, this.projectY, local617, local612);
					}
					if (this.chatStyles[local483] == 2) {
						local692 = this.fontBold12.method364(false, local612);
						@Pc(913) int local913 = (150 - this.chatTimers[local483]) * (local692 + 100) / 150;
						Draw2D.method356(334, 0, this.projectX + 50, 789, this.projectX - 50);
						this.fontBold12.method365(this.projectX + 50 - local913, this.projectY + 1, false, 0, local612);
						this.fontBold12.method365(this.projectX + 50 - local913, this.projectY, false, local617, local612);
						Draw2D.method355(0);
					}
				} else {
					this.fontBold12.method362(this.projectY + 1, (byte) 6, 0, local612, this.projectX);
					this.fontBold12.method362(this.projectY, (byte) 6, 16776960, local612, this.projectX);
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
				this.levelObjStacks = null;
			}
			this.out.method380((byte) -34, 231);
			if (this.sidebarInterfaceId != -1) {
				this.sidebarInterfaceId = -1;
				this.redrawSidebar = true;
				this.pressedContinueOption = false;
				this.redrawSideicons = true;
			}
			if (this.chatInterfaceId != -1) {
				this.chatInterfaceId = -1;
				this.redrawChatback = true;
				this.pressedContinueOption = false;
			}
			this.viewportInterfaceID = -1;
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
			@Pc(10) int local10 = (this.localPlayer.x >> 7) + this.sceneBaseTileX;
			@Pc(19) int local19 = (this.localPlayer.z >> 7) + this.sceneBaseTileZ;
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
			this.overrideChat = 0;
			if (local10 >= 3053 && local10 <= 3156 && local19 >= 3056 && local19 <= 3136) {
				this.overrideChat = 1;
			}
			if (local10 >= 3072 && local10 <= 3118 && local19 >= 9492 && local19 <= 9535) {
				this.overrideChat = 1;
			}
			if (this.overrideChat == 1 && local10 >= 3139 && local10 <= 3199 && local19 >= 3008 && local19 <= 3062) {
				this.overrideChat = 0;
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
				@Pc(9) BitmapFont local9 = this.fontPlain12;
				@Pc(11) int local11 = 0;
				if (this.systemUpdateTimer != 0) {
					local11 = 1;
				}
				for (@Pc(18) int local18 = 0; local18 < 100; local18++) {
					if (this.messageText[local18] != null) {
						@Pc(30) int local30 = this.messageType[local18];
						@Pc(60) int local60;
						if ((local30 == 3 || local30 == 7) && (local30 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.method199(-20, this.messageSender[local18]))) {
							local60 = 329 - local11 * 13;
							local9.method365(4, local60, false, 0, "From " + this.messageSender[local18] + ": " + this.messageText[local18]);
							local9.method365(4, local60 - 1, false, 65535, "From " + this.messageSender[local18] + ": " + this.messageText[local18]);
							local11++;
							if (local11 >= 5) {
								return;
							}
						}
						if (local30 == 5 && this.privateChatSetting < 2) {
							local60 = 329 - local11 * 13;
							local9.method365(4, local60, false, 0, this.messageText[local18]);
							local9.method365(4, local60 - 1, false, 65535, this.messageText[local18]);
							local11++;
							if (local11 >= 5) {
								return;
							}
						}
						if (local30 == 6 && this.privateChatSetting < 2) {
							local60 = 329 - local11 * 13;
							local9.method365(4, local60, false, 0, "To " + this.messageSender[local18] + ": " + this.messageText[local18]);
							local9.method365(4, local60 - 1, false, 65535, "To " + this.messageSender[local18] + ": " + this.messageText[local18]);
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
	private void method81(@OriginalArg(0) Buffer arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.entityUpdateCount; local1++) {
				@Pc(8) int local8 = this.entityUpdateIds[local1];
				@Pc(13) NpcEntity local13 = this.npcs[local8];
				@Pc(16) int local16 = arg0.method391();
				@Pc(24) int local24;
				if ((local16 & 0x2) == 2) {
					local24 = arg0.method393();
					if (local24 == 65535) {
						local24 = -1;
					}
					if (local24 == local13.primarySeqId) {
						local13.primarySeqLoop = 0;
					}
					@Pc(39) int local39 = arg0.method391();
					if (local24 == -1 || local13.primarySeqId == -1 || SeqType.instances[local24].idleStyle > SeqType.instances[local13.primarySeqId].idleStyle || SeqType.instances[local13.primarySeqId].idleStyle == 0) {
						local13.primarySeqId = local24;
						local13.primarySeqFrame = 0;
						local13.primarySeqCycle = 0;
						local13.primarySeqDelay = local39;
						local13.primarySeqLoop = 0;
					}
				}
				if ((local16 & 0x4) == 4) {
					local13.targetId = arg0.method393();
					if (local13.targetId == 65535) {
						local13.targetId = -1;
					}
				}
				if ((local16 & 0x8) == 8) {
					local13.chat = arg0.method398();
					local13.chatTimer = 100;
				}
				if ((local16 & 0x10) == 16) {
					local13.damage = arg0.method391();
					local13.damageType = arg0.method391();
					local13.combatCycle = loopCycle + 400;
					local13.health = arg0.method391();
					local13.totalHealth = arg0.method391();
				}
				if ((local16 & 0x20) == 32) {
					local13.type = NpcType.method32(arg0.method393());
					local13.seqWalkId = local13.type.seqWalkId;
					local13.seqTurnAroundId = local13.type.seqTurnAroundId;
					local13.seqTurnLeftId = local13.type.seqTurnLeftId;
					local13.seqTurnRightId = local13.type.seqTurnRightId;
					local13.seqStandId = local13.type.seqStandId;
				}
				if ((local16 & 0x40) == 64) {
					local13.spotanimId = arg0.method393();
					local24 = arg0.method396();
					local13.spotanimOffset = local24 >> 16;
					local13.spotanimLastCycle = loopCycle + (local24 & 0xFFFF);
					local13.spotanimFrame = 0;
					local13.spotanimCycle = 0;
					if (local13.spotanimLastCycle > loopCycle) {
						local13.spotanimFrame = -1;
					}
					if (local13.spotanimId == 65535) {
						local13.spotanimId = -1;
					}
				}
				if ((local16 & 0x80) == 128) {
					local13.targetTileX = arg0.method393();
					local13.targetTileZ = arg0.method393();
				}
			}
			if (arg2 <= 0) {
				this.anInt165 = this.randomIn.method532();
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
				if (this.ignoreCount >= 100) {
					this.method172(0, "Your ignore list is full. Max of 100 hit", (byte) 4, "");
				} else {
					@Pc(23) String local23 = StringUtils.formatName(0, StringUtils.fromBase37(arg0, false));
					for (@Pc(25) int local25 = 0; local25 < this.ignoreCount; local25++) {
						if (this.ignoreName37[local25] == arg0) {
							this.method172(0, local23 + " is already on your ignore list", (byte) 4, "");
							return;
						}
					}
					for (@Pc(55) int local55 = 0; local55 < this.friendCount; local55++) {
						if (this.friendName37[local55] == arg0) {
							this.method172(0, "Please remove " + local23 + " from your friend list first", (byte) 4, "");
							return;
						}
					}
					this.ignoreName37[this.ignoreCount++] = arg0;
					this.redrawSidebar = true;
					if (arg1 == 3) {
						this.out.method380((byte) -34, 79);
						this.out.method387(true, arg0);
					}
				}
			}
		} catch (@Pc(114) RuntimeException local114) {
			signlink.reporterror("96582, " + arg0 + ", " + arg1 + ", " + local114.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(BLclient!kb;I)V")
	private void method83(@OriginalArg(0) byte arg0, @OriginalArg(1) Buffer arg1, @OriginalArg(2) int arg2) {
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
				local24 = this.baseX + (local15 >> 4 & 0x7);
				local31 = this.baseZ + (local15 & 0x7);
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
					@Pc(69) SceneLocTemporary local69 = null;
					for (@Pc(74) SceneLocTemporary local74 = (SceneLocTemporary) this.aClass28_4.method456(); local74 != null; local74 = (SceneLocTemporary) this.aClass28_4.method458(551)) {
						if (local74.anInt593 == this.currentLevel && local74.anInt595 == local24 && local74.anInt596 == local31 && local74.anInt594 == local47) {
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
							local108 = this.scene.method494(this.currentLevel, local24, local31);
						}
						if (local47 == 1) {
							local108 = this.scene.method495(this.currentLevel, local31, 3, local24);
						}
						if (local47 == 2) {
							local108 = this.scene.method496(this.currentLevel, local24, local31);
						}
						if (local47 == 3) {
							local108 = this.scene.method497(this.currentLevel, local24, local31);
						}
						if (local108 != 0) {
							@Pc(169) int local169 = this.scene.method498(this.currentLevel, local24, local31, local108);
							local110 = local108 >> 14 & 0x7FFF;
							local112 = local169 & 0x1F;
							local114 = local169 >> 6;
						}
						local69 = new SceneLocTemporary();
						local69.anInt593 = this.currentLevel;
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
					this.method160(local42, local24, local31, local47, local52, local38, -27819, this.currentLevel);
				}
			} else if (arg2 == 42) {
				local15 = arg1.method391();
				local24 = this.baseX + (local15 >> 4 & 0x7);
				local31 = this.baseZ + (local15 & 0x7);
				local34 = arg1.method391();
				local38 = local34 >> 2;
				local42 = this.anIntArray80[local38];
				local47 = arg1.method393();
				if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
					local52 = 0;
					if (local42 == 0) {
						local52 = this.scene.method494(this.currentLevel, local24, local31);
					}
					if (local42 == 1) {
						local52 = this.scene.method495(this.currentLevel, local31, 3, local24);
					}
					if (local42 == 2) {
						local52 = this.scene.method496(this.currentLevel, local24, local31);
					}
					if (local42 == 3) {
						local52 = this.scene.method497(this.currentLevel, local24, local31);
					}
					if (local52 != 0) {
						@Pc(348) LocEntity local348 = new LocEntity(false, local52 >> 14 & 0x7FFF, this.currentLevel, 0, local42, SeqType.instances[local47], local31, local24);
						this.aClass28_1.method453(local348);
					}
				}
			} else {
				@Pc(395) ObjEntity local395;
				if (arg2 == 223) {
					local15 = arg1.method391();
					local24 = this.baseX + (local15 >> 4 & 0x7);
					local31 = this.baseZ + (local15 & 0x7);
					local34 = arg1.method393();
					local38 = arg1.method393();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
						local395 = new ObjEntity();
						local395.index = local34;
						local395.count = local38;
						if (this.levelObjStacks[this.currentLevel][local24][local31] == null) {
							this.levelObjStacks[this.currentLevel][local24][local31] = new DoublyLinkedList(0);
						}
						this.levelObjStacks[this.currentLevel][local24][local31].method453(local395);
						this.method184(local24, local31);
					}
				} else if (arg2 == 49) {
					local15 = arg1.method391();
					local24 = this.baseX + (local15 >> 4 & 0x7);
					local31 = this.baseZ + (local15 & 0x7);
					local34 = arg1.method393();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
						@Pc(485) DoublyLinkedList local485 = this.levelObjStacks[this.currentLevel][local24][local31];
						if (local485 != null) {
							for (local395 = (ObjEntity) local485.method456(); local395 != null; local395 = (ObjEntity) local485.method458(551)) {
								if (local395.index == (local34 & 0x7FFF)) {
									local395.method567();
									break;
								}
							}
							if (local485.method456() == null) {
								this.levelObjStacks[this.currentLevel][local24][local31] = null;
							}
							this.method184(local24, local31);
						}
					}
				} else {
					@Pc(572) int local572;
					@Pc(575) int local575;
					if (arg2 == 69) {
						local15 = arg1.method391();
						local24 = this.baseX + (local15 >> 4 & 0x7);
						local31 = this.baseZ + (local15 & 0x7);
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
							@Pc(657) ProjectileEntity local657 = new ProjectileEntity(local572, local110, local31, local108 + loopCycle, this.currentLevel, local42, local575 + loopCycle, local112, 0, this.method94(this.currentLevel, local24, (byte) 5, local31) - local52, local47, local24);
							local657.method19(this.method94(this.currentLevel, local34, (byte) 5, local38) - local572, local38, local34, -855, local575 + loopCycle);
							this.projectiles.method453(local657);
						}
					} else if (arg2 == 191) {
						local15 = arg1.method391();
						local24 = this.baseX + (local15 >> 4 & 0x7);
						local31 = this.baseZ + (local15 & 0x7);
						local34 = arg1.method393();
						local38 = arg1.method391();
						local42 = arg1.method393();
						if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
							local24 = local24 * 128 + 64;
							local31 = local31 * 128 + 64;
							@Pc(753) SpotAnimEntity local753 = new SpotAnimEntity(local24, local34, false, local31, local42, this.method94(this.currentLevel, local24, (byte) 5, local31) - local38, this.currentLevel, loopCycle);
							this.aClass28_5.method453(local753);
						}
					} else if (arg2 == 50) {
						local15 = arg1.method391();
						local24 = this.baseX + (local15 >> 4 & 0x7);
						local31 = this.baseZ + (local15 & 0x7);
						local34 = arg1.method393();
						local38 = arg1.method393();
						local42 = arg1.method393();
						if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104 && local42 != this.localPid) {
							@Pc(807) ObjEntity local807 = new ObjEntity();
							local807.index = local34;
							local807.count = local38;
							if (this.levelObjStacks[this.currentLevel][local24][local31] == null) {
								this.levelObjStacks[this.currentLevel][local24][local31] = new DoublyLinkedList(0);
							}
							this.levelObjStacks[this.currentLevel][local24][local31].method453(local807);
							this.method184(local24, local31);
						}
					} else {
						if (arg2 == 23) {
							local15 = arg1.method391();
							local24 = this.baseX + (local15 >> 4 & 0x7);
							local31 = this.baseZ + (local15 & 0x7);
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
							@Pc(921) PlayerEntity local921;
							if (local108 == this.localPid) {
								local921 = this.localPlayer;
							} else {
								local921 = this.players[local108];
							}
							if (local921 != null) {
								@Pc(946) SceneLocTemporary2 local946 = new SceneLocTemporary2(this.currentLevel, local42, local31, local572 + loopCycle, 2, local38, -1, local24, local47);
								this.aClass28_2.method453(local946);
								@Pc(966) SceneLocTemporary2 local966 = new SceneLocTemporary2(this.currentLevel, local42, local31, local575 + loopCycle, 2, local38, local52, local24, local47);
								this.aClass28_2.method453(local966);
								@Pc(980) int local980 = this.levelHeightmap[this.currentLevel][local24][local31];
								@Pc(992) int local992 = this.levelHeightmap[this.currentLevel][local24 + 1][local31];
								@Pc(1006) int local1006 = this.levelHeightmap[this.currentLevel][local24 + 1][local31 + 1];
								@Pc(1018) int local1018 = this.levelHeightmap[this.currentLevel][local24][local31 + 1];
								@Pc(1021) LocType local1021 = LocType.method23(local52);
								local921.locStartCycle = local572 + loopCycle;
								local921.locStopCycle = local575 + loopCycle;
								local921.locModel = local1021.method26(local38, local42, local980, local992, local1006, local1018, -1);
								@Pc(1045) int local1045 = local1021.sizeX;
								@Pc(1048) int local1048 = local1021.sizeZ;
								if (local42 == 1 || local42 == 3) {
									local1045 = local1021.sizeZ;
									local1048 = local1021.sizeX;
								}
								local921.locOffsetX = local24 * 128 + local1045 * 64;
								local921.locOffsetZ = local31 * 128 + local1048 * 64;
								local921.locOffsetY = this.method94(this.currentLevel, local921.locOffsetX, (byte) 5, local921.locOffsetZ);
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
							local24 = this.baseX + (local15 >> 4 & 0x7);
							local31 = this.baseZ + (local15 & 0x7);
							local34 = arg1.method393();
							local38 = arg1.method393();
							local42 = arg1.method393();
							if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
								@Pc(1178) DoublyLinkedList local1178 = this.levelObjStacks[this.currentLevel][local24][local31];
								if (local1178 != null) {
									for (@Pc(1184) ObjEntity local1184 = (ObjEntity) local1178.method456(); local1184 != null; local1184 = (ObjEntity) local1178.method458(551)) {
										if (local1184.index == (local34 & 0x7FFF) && local1184.count == local38) {
											local1184.count = local42;
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
				this.packetType = this.in.method391();
			}
			@Pc(11) int local11 = 3;
			if (this.cameraPitch < 310) {
				@Pc(20) int local20 = this.cameraX >> 7;
				@Pc(25) int local25 = this.cameraZ >> 7;
				@Pc(31) int local31 = this.localPlayer.x >> 7;
				@Pc(37) int local37 = this.localPlayer.z >> 7;
				if ((this.levelTileFlags[this.currentLevel][local20][local25] & 0x4) != 0) {
					local11 = this.currentLevel;
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
						if ((this.levelTileFlags[this.currentLevel][local20][local25] & 0x4) != 0) {
							local11 = this.currentLevel;
						}
						local89 += local87;
						if (local89 >= 65536) {
							local89 -= 65536;
							if (local25 < local37) {
								local25++;
							} else if (local25 > local37) {
								local25--;
							}
							if ((this.levelTileFlags[this.currentLevel][local20][local25] & 0x4) != 0) {
								local11 = this.currentLevel;
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
						if ((this.levelTileFlags[this.currentLevel][local20][local25] & 0x4) != 0) {
							local11 = this.currentLevel;
						}
						local89 += local87;
						if (local89 >= 65536) {
							local89 -= 65536;
							if (local20 < local31) {
								local20++;
							} else if (local20 > local31) {
								local20--;
							}
							if ((this.levelTileFlags[this.currentLevel][local20][local25] & 0x4) != 0) {
								local11 = this.currentLevel;
							}
						}
					}
				}
			}
			if ((this.levelTileFlags[this.currentLevel][this.localPlayer.x >> 7][this.localPlayer.z >> 7] & 0x4) != 0) {
				local11 = this.currentLevel;
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
			@Pc(9) int local9 = this.method94(this.currentLevel, this.cameraX, (byte) 5, this.cameraZ);
			this.packetSize += arg0;
			return local9 - this.cameraY >= 800 || (this.levelTileFlags[this.currentLevel][this.cameraX >> 7][this.cameraZ >> 7] & 0x4) == 0 ? 3 : this.currentLevel;
		} catch (@Pc(45) RuntimeException local45) {
			signlink.reporterror("97355, " + arg0 + ", " + local45.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
	private void method86(@OriginalArg(0) int arg0) {
		try {
			this.sceneCycle++;
			this.method93(284);
			this.method114(false);
			this.packetSize += arg0;
			this.method147((byte) -26);
			this.method166((byte) 106);
			this.method190(254);
			@Pc(34) int local34;
			@Pc(73) int local73;
			@Pc(122) int local122;
			if (!this.cutscene) {
				local34 = this.orbitCameraPitch;
				if (this.cameraPitchClamp / 256 > local34) {
					local34 = this.cameraPitchClamp / 256;
				}
				if (this.cameraModifierEnabled[4] && this.cameraModifierWobbleScale[4] + 128 > local34) {
					local34 = this.cameraModifierWobbleScale[4] + 128;
				}
				local73 = this.orbitCameraYaw + this.cameraAnticheatAngle & 0x7FF;
				this.method100(this.method94(this.currentLevel, this.localPlayer.x, (byte) 5, this.localPlayer.z) - 50, this.orbitCameraX, local73, local34, 16418, this.orbitCameraZ, local34 * 3 + 600);
				anInt193++;
				if (anInt193 > 1802) {
					anInt193 = 0;
					this.out.method380((byte) -34, 146);
					this.out.method381(0);
					local122 = this.out.position;
					this.out.method382(29711);
					this.out.method381(70);
					this.out.method381((int) (Math.random() * 256.0D));
					this.out.method381(242);
					this.out.method381(186);
					this.out.method381(39);
					this.out.method381(61);
					if ((int) (Math.random() * 2.0D) == 0) {
						this.out.method381(13);
					}
					if ((int) (Math.random() * 2.0D) == 0) {
						this.out.method382(57856);
					}
					this.out.method382((int) (Math.random() * 65536.0D));
					this.out.method390(0, this.out.position - local122);
				}
			}
			if (this.cutscene) {
				local34 = this.method85(0);
			} else {
				local34 = this.method84((byte) 106);
			}
			local73 = this.cameraX;
			local122 = this.cameraY;
			@Pc(209) int local209 = this.cameraZ;
			@Pc(212) int local212 = this.cameraPitch;
			@Pc(215) int local215 = this.cameraYaw;
			@Pc(264) int local264;
			for (@Pc(217) int local217 = 0; local217 < 5; local217++) {
				if (this.cameraModifierEnabled[local217]) {
					local264 = (int) (Math.random() * (double) (this.cameraModifierJitter[local217] * 2 + 1) - (double) this.cameraModifierJitter[local217] + Math.sin((double) this.cameraModifierCycle[local217] * ((double) this.cameraModifierWobbleSpeed[local217] / 100.0D)) * (double) this.cameraModifierWobbleScale[local217]);
					if (local217 == 0) {
						this.cameraX += local264;
					}
					if (local217 == 1) {
						this.cameraY += local264;
					}
					if (local217 == 2) {
						this.cameraZ += local264;
					}
					if (local217 == 3) {
						this.cameraYaw = this.cameraYaw + local264 & 0x7FF;
					}
					if (local217 == 4) {
						this.cameraPitch += local264;
						if (this.cameraPitch < 128) {
							this.cameraPitch = 128;
						}
						if (this.cameraPitch > 383) {
							this.cameraPitch = 383;
						}
					}
				}
			}
			local264 = Draw3D.anInt434;
			Model.aBoolean85 = true;
			Model.anInt378 = 0;
			Model.anInt376 = super.mouseX - 8;
			Model.anInt377 = super.mouseY - 11;
			Draw2D.method357(this.anInt336);
			this.scene.method507(this.cameraYaw, this.cameraX, local34, this.cameraPitch, this.cameraY, this.cameraZ, 0);
			this.scene.method481(0);
			this.method76(this.anInt194);
			this.method194((byte) -11);
			this.method102(local264, true);
			this.method145(9);
			this.areaViewport.method464(11, super.graphics, 8, 5193);
			this.cameraX = local73;
			this.cameraY = local122;
			this.cameraZ = local209;
			this.cameraPitch = local212;
			this.cameraYaw = local215;
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
					@Pc(14) Object local14 = this.midiSync;
					@Pc(19) String local19;
					@Pc(22) int local22;
					@Pc(25) int local25;
					synchronized (this.midiSync) {
						local19 = this.midiSyncName;
						local22 = this.midiSyncCrc;
						local25 = this.midiSyncLen;
						this.midiSyncName = null;
						this.midiSyncCrc = 0;
						this.midiSyncLen = 0;
					}
					if (local19 != null) {
						@Pc(52) byte[] local52 = signlink.cacheload(local19 + ".mid");
						@Pc(69) int local69;
						if (local52 != null && local22 != 12345678) {
							this.crc32.reset();
							this.crc32.update(local52);
							local69 = (int) this.crc32.getValue();
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
						local69 = (new Buffer(363, local52)).method396();
						@Pc(167) byte[] local167 = new byte[local69];
						BZip2InputStream.method519(local167, local69, local52, local25, 4);
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
				this.imageTitle0.anIntArray197[local8] = this.aClass1_Sub3_Sub2_Sub2_3.pixels[local8];
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
						local239 = this.imageTitle0.anIntArray197[local183];
						this.imageTitle0.anIntArray197[local183++] = ((local220 & 0xFF00FF) * local224 + (local239 & 0xFF00FF) * local228 & 0xFF00FF00) + ((local220 & 0xFF00) * local224 + (local239 & 0xFF00) * local228 & 0xFF0000) >> 8;
					}
				}
				local183 += local202;
			}
			this.imageTitle0.method464(0, super.graphics, 0, 5193);
			for (local198 = 0; local198 < 33920; local198++) {
				this.imageTitle1.anIntArray197[local198] = this.aClass1_Sub3_Sub2_Sub2_4.pixels[local198];
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
						@Pc(373) int local373 = this.imageTitle1.anIntArray197[local183];
						this.imageTitle1.anIntArray197[local183++] = ((local228 & 0xFF00FF) * local239 + (local373 & 0xFF00FF) * local362 & 0xFF00FF00) + ((local228 & 0xFF00) * local239 + (local373 & 0xFF00) * local362 & 0xFF0000) >> 8;
					}
				}
				local181 += 128 - local220;
				local183 += 128 - local220 - local212;
			}
			if (!arg0) {
				anInt268 = 281;
			}
			this.imageTitle1.method464(0, super.graphics, 661, 5193);
		} catch (@Pc(449) RuntimeException local449) {
			signlink.reporterror("82128, " + arg0 + ", " + local449.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;III)V")
	private void method90(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) IfType arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			if (arg3.anInt472 == 0 && arg3.anIntArray153 != null && !arg3.aBoolean106 && (arg1 >= arg5 && arg0 >= arg2 && arg1 <= arg5 + arg3.anInt475 && arg0 <= arg2 + arg3.height)) {
				@Pc(34) int local34 = arg3.anIntArray153.length;
				if (arg4 != 5082) {
					this.packetType = this.in.method391();
				}
				for (@Pc(44) int local44 = 0; local44 < local34; local44++) {
					@Pc(53) int local53 = arg3.anIntArray154[local44] + arg5;
					@Pc(62) int local62 = arg3.anIntArray155[local44] + arg2 - arg6;
					@Pc(69) IfType local69 = IfType.instances[arg3.anIntArray153[local44]];
					@Pc(74) int local74 = local53 + local69.anInt477;
					@Pc(79) int local79 = local62 + local69.anInt478;
					if ((local69.anInt479 >= 0 || local69.anInt487 != 0) && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
						if (local69.anInt479 >= 0) {
							this.anInt225 = local69.anInt479;
						} else {
							this.anInt225 = local69.anInt470;
						}
					}
					if (local69.anInt472 == 0) {
						this.method90(arg0, arg1, local79, local69, 5082, local74, local69.scrollPosition);
						if (local69.scrollableHeight > local69.height) {
							this.method158(arg1, 0, arg0, local69.scrollableHeight, local69.height, true, local74 + local69.anInt475, local79, local69);
						}
					} else {
						if (local69.optionType == 1 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
							@Pc(176) boolean local176 = false;
							if (local69.contentType != 0) {
								local176 = this.method180(local69, (byte) 8);
							}
							if (!local176) {
								this.menuOption[this.menuSize] = local69.aString24;
								this.menuAction[this.menuSize] = 951;
								this.menuParamC[this.menuSize] = local69.anInt470;
								this.menuSize++;
							}
						}
						if (local69.optionType == 2 && this.spellSelected == 0 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
							@Pc(240) String local240 = local69.aString22;
							if (local240.indexOf(" ") != -1) {
								local240 = local240.substring(0, local240.indexOf(" "));
							}
							this.menuOption[this.menuSize] = local240 + " @gre@" + local69.aString23;
							this.menuAction[this.menuSize] = 930;
							this.menuParamC[this.menuSize] = local69.anInt470;
							this.menuSize++;
						}
						if (local69.optionType == 3 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
							this.menuOption[this.menuSize] = "Close";
							this.menuAction[this.menuSize] = 947;
							this.menuParamC[this.menuSize] = local69.anInt470;
							this.menuSize++;
						}
						if (local69.optionType == 4 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
							this.menuOption[this.menuSize] = local69.aString24;
							this.menuAction[this.menuSize] = 465;
							this.menuParamC[this.menuSize] = local69.anInt470;
							this.menuSize++;
						}
						if (local69.optionType == 5 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
							this.menuOption[this.menuSize] = local69.aString24;
							this.menuAction[this.menuSize] = 960;
							this.menuParamC[this.menuSize] = local69.anInt470;
							this.menuSize++;
						}
						if (local69.optionType == 6 && !this.pressedContinueOption && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.anInt475 && arg0 < local79 + local69.height) {
							this.menuOption[this.menuSize] = local69.aString24;
							this.menuAction[this.menuSize] = 44;
							this.menuParamC[this.menuSize] = local69.anInt470;
							this.menuSize++;
						}
						if (local69.anInt472 == 2) {
							@Pc(488) int local488 = 0;
							for (@Pc(490) int local490 = 0; local490 < local69.height; local490++) {
								for (@Pc(494) int local494 = 0; local494 < local69.anInt475; local494++) {
									@Pc(505) int local505 = local74 + local494 * (local69.anInt483 + 32);
									@Pc(514) int local514 = local79 + local490 * (local69.anInt484 + 32);
									if (local488 < 20) {
										local505 += local69.anIntArray156[local488];
										local514 += local69.anIntArray157[local488];
									}
									if (arg1 >= local505 && arg0 >= local514 && arg1 < local505 + 32 && arg0 < local514 + 32) {
										this.hoveredSlot = local488;
										this.hoveredSlotParentId = local69.anInt470;
										if (local69.inventorySlotObjId[local488] > 0) {
											@Pc(567) ObjType local567 = ObjType.get(local69.inventorySlotObjId[local488] - 1);
											if (this.objSelected == 1 && local69.aBoolean109) {
												if (local69.anInt470 != this.anInt283 || local488 != this.anInt282) {
													this.menuOption[this.menuSize] = "Use " + this.selectedObjName + " with @lre@" + local567.aString3;
													this.menuAction[this.menuSize] = 881;
													this.menuParamA[this.menuSize] = local567.anInt103;
													this.menuParamB[this.menuSize] = local488;
													this.menuParamC[this.menuSize] = local69.anInt470;
													this.menuSize++;
												}
											} else if (this.spellSelected != 1 || !local69.aBoolean109) {
												@Pc(704) int local704;
												if (local69.aBoolean109) {
													for (local704 = 4; local704 >= 3; local704--) {
														if (local567.aStringArray4 != null && local567.aStringArray4[local704] != null) {
															this.menuOption[this.menuSize] = local567.aStringArray4[local704] + " @lre@" + local567.aString3;
															if (local704 == 3) {
																this.menuAction[this.menuSize] = 478;
															}
															if (local704 == 4) {
																this.menuAction[this.menuSize] = 347;
															}
															this.menuParamA[this.menuSize] = local567.anInt103;
															this.menuParamB[this.menuSize] = local488;
															this.menuParamC[this.menuSize] = local69.anInt470;
															this.menuSize++;
														} else if (local704 == 4) {
															this.menuOption[this.menuSize] = "Drop @lre@" + local567.aString3;
															this.menuAction[this.menuSize] = 347;
															this.menuParamA[this.menuSize] = local567.anInt103;
															this.menuParamB[this.menuSize] = local488;
															this.menuParamC[this.menuSize] = local69.anInt470;
															this.menuSize++;
														}
													}
												}
												if (local69.aBoolean110) {
													this.menuOption[this.menuSize] = "Use @lre@" + local567.aString3;
													this.menuAction[this.menuSize] = 188;
													this.menuParamA[this.menuSize] = local567.anInt103;
													this.menuParamB[this.menuSize] = local488;
													this.menuParamC[this.menuSize] = local69.anInt470;
													this.menuSize++;
												}
												if (local69.aBoolean109 && local567.aStringArray4 != null) {
													for (local704 = 2; local704 >= 0; local704--) {
														if (local567.aStringArray4[local704] != null) {
															this.menuOption[this.menuSize] = local567.aStringArray4[local704] + " @lre@" + local567.aString3;
															if (local704 == 0) {
																this.menuAction[this.menuSize] = 405;
															}
															if (local704 == 1) {
																this.menuAction[this.menuSize] = 38;
															}
															if (local704 == 2) {
																this.menuAction[this.menuSize] = 422;
															}
															this.menuParamA[this.menuSize] = local567.anInt103;
															this.menuParamB[this.menuSize] = local488;
															this.menuParamC[this.menuSize] = local69.anInt470;
															this.menuSize++;
														}
													}
												}
												if (local69.aStringArray10 != null) {
													for (local704 = 4; local704 >= 0; local704--) {
														if (local69.aStringArray10[local704] != null) {
															this.menuOption[this.menuSize] = local69.aStringArray10[local704] + " @lre@" + local567.aString3;
															if (local704 == 0) {
																this.menuAction[this.menuSize] = 602;
															}
															if (local704 == 1) {
																this.menuAction[this.menuSize] = 596;
															}
															if (local704 == 2) {
																this.menuAction[this.menuSize] = 22;
															}
															if (local704 == 3) {
																this.menuAction[this.menuSize] = 892;
															}
															if (local704 == 4) {
																this.menuAction[this.menuSize] = 415;
															}
															this.menuParamA[this.menuSize] = local567.anInt103;
															this.menuParamB[this.menuSize] = local488;
															this.menuParamC[this.menuSize] = local69.anInt470;
															this.menuSize++;
														}
													}
												}
												this.menuOption[this.menuSize] = "Examine @lre@" + local567.aString3;
												this.menuAction[this.menuSize] = 1773;
												this.menuParamA[this.menuSize] = local567.anInt103;
												this.menuParamC[this.menuSize] = local69.inventorySlotObjCount[local488];
												this.menuSize++;
											} else if ((this.anInt293 & 0x10) == 16) {
												this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + local567.aString3;
												this.menuAction[this.menuSize] = 391;
												this.menuParamA[this.menuSize] = local567.anInt103;
												this.menuParamB[this.menuSize] = local488;
												this.menuParamC[this.menuSize] = local69.anInt470;
												this.menuSize++;
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
			this.packetSize += arg0;
			if (super.mouseClickButton == 1) {
				if (super.mouseClickX >= 8 && super.mouseClickX <= 108 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
					this.publicChatSetting = (this.publicChatSetting + 1) % 4;
					this.redrawPrivacySettings = true;
					this.redrawChatback = true;
					this.out.method380((byte) -34, 244);
					this.out.method381(this.publicChatSetting);
					this.out.method381(this.privateChatSetting);
					this.out.method381(this.tradeChatSetting);
				}
				if (super.mouseClickX >= 137 && super.mouseClickX <= 237 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
					this.privateChatSetting = (this.privateChatSetting + 1) % 3;
					this.redrawPrivacySettings = true;
					this.redrawChatback = true;
					this.out.method380((byte) -34, 244);
					this.out.method381(this.publicChatSetting);
					this.out.method381(this.privateChatSetting);
					this.out.method381(this.tradeChatSetting);
				}
				if (super.mouseClickX >= 275 && super.mouseClickX <= 375 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
					this.tradeChatSetting = (this.tradeChatSetting + 1) % 3;
					this.redrawPrivacySettings = true;
					this.redrawChatback = true;
					this.out.method380((byte) -34, 244);
					this.out.method381(this.publicChatSetting);
					this.out.method381(this.privateChatSetting);
					this.out.method381(this.tradeChatSetting);
				}
				if (super.mouseClickX >= 416 && super.mouseClickX <= 516 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
					this.method77((byte) -60);
					this.reportAbuseInput = "";
					this.reportAbuseMuteOption = false;
					for (@Pc(186) int local186 = 0; local186 < IfType.instances.length; local186++) {
						if (IfType.instances[local186] != null && IfType.instances[local186].contentType == 600) {
							this.reportAbuseInterfaceID = this.viewportInterfaceID = IfType.instances[local186].parentId;
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
				if (this.messageText[local3] != null) {
					@Pc(15) int local15 = this.messageType[local3];
					@Pc(26) int local26 = this.anInt274 + 70 + 4 - local1 * 14;
					if (local26 < -20) {
						break;
					}
					if (local15 == 0) {
						local1++;
					}
					if ((local15 == 1 || local15 == 2) && (local15 == 1 || this.publicChatSetting == 0 || this.publicChatSetting == 1 && this.method199(-20, this.messageSender[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26 && !this.messageSender[local3].equals(this.localPlayer.name)) {
							if (this.rights) {
								this.menuOption[this.menuSize] = "Report abuse @whi@" + this.messageSender[local3];
								this.menuAction[this.menuSize] = 34;
								this.menuSize++;
							}
							this.menuOption[this.menuSize] = "Add ignore @whi@" + this.messageSender[local3];
							this.menuAction[this.menuSize] = 436;
							this.menuSize++;
							this.menuOption[this.menuSize] = "Add friend @whi@" + this.messageSender[local3];
							this.menuAction[this.menuSize] = 406;
							this.menuSize++;
						}
						local1++;
					}
					if ((local15 == 3 || local15 == 7) && this.anInt210 == 0 && (local15 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.method199(-20, this.messageSender[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26) {
							if (this.rights) {
								this.menuOption[this.menuSize] = "Report abuse @whi@" + this.messageSender[local3];
								this.menuAction[this.menuSize] = 34;
								this.menuSize++;
							}
							this.menuOption[this.menuSize] = "Add ignore @whi@" + this.messageSender[local3];
							this.menuAction[this.menuSize] = 436;
							this.menuSize++;
							this.menuOption[this.menuSize] = "Add friend @whi@" + this.messageSender[local3];
							this.menuAction[this.menuSize] = 406;
							this.menuSize++;
						}
						local1++;
					}
					if (local15 == 4 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.method199(-20, this.messageSender[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26) {
							this.menuOption[this.menuSize] = "Accept trade @whi@" + this.messageSender[local3];
							this.menuAction[this.menuSize] = 903;
							this.menuSize++;
						}
						local1++;
					}
					if ((local15 == 5 || local15 == 6) && this.anInt210 == 0 && this.privateChatSetting < 2) {
						local1++;
					}
					if (local15 == 8 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.method199(-20, this.messageSender[local3]))) {
						if (arg0 > local26 - 14 && arg0 <= local26) {
							this.menuOption[this.menuSize] = "Accept duel @whi@" + this.messageSender[local3];
							this.menuAction[this.menuSize] = 363;
							this.menuSize++;
						}
						local1++;
					}
				}
			}
			this.packetSize += arg1;
		} catch (@Pc(412) RuntimeException local412) {
			signlink.reporterror("24152, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local412.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(I)V")
	private void method93(@OriginalArg(0) int arg0) {
		try {
			if (this.localPlayer.x >> 7 == this.flagSceneTileX && this.localPlayer.z >> 7 == this.flagSceneTileZ) {
				this.flagSceneTileX = 0;
			}
			for (@Pc(22) int local22 = -1; local22 < this.playerCount; local22++) {
				@Pc(30) PlayerEntity local30;
				@Pc(35) int local35;
				if (local22 == -1) {
					local30 = this.localPlayer;
					local35 = this.LOCAL_PLAYER_INDEX << 14;
				} else {
					local30 = this.players[this.playerIds[local22]];
					local35 = this.playerIds[local22] << 14;
				}
				if (local30 != null && local30.isVisible(false)) {
					local30.lowMemory = false;
					if ((lowMemory && this.playerCount > 50 || this.playerCount > 200) && local22 != -1 && local30.secondarySeqId == local30.seqStandId) {
						local30.lowMemory = true;
					}
					@Pc(87) int local87 = local30.x >> 7;
					@Pc(92) int local92 = local30.z >> 7;
					if (local87 >= 0 && local87 < 104 && local92 >= 0 && local92 < 104) {
						if (local30.locModel == null || loopCycle < local30.locStartCycle || loopCycle >= local30.locStopCycle) {
							if ((local30.x & 0x7F) == 64 && (local30.z & 0x7F) == 64) {
								if (this.anIntArrayArray3[local87][local92] == this.sceneCycle) {
									continue;
								}
								this.anIntArrayArray3[local87][local92] = this.sceneCycle;
							}
							local30.y = this.method94(this.currentLevel, local30.x, (byte) 5, local30.z);
							this.scene.method478(-44713, local30.z, 60, local30.anInt884, local30.x, local35, local30.aBoolean160, null, local30, local30.y, this.currentLevel);
						} else {
							local30.lowMemory = false;
							local30.y = this.method94(this.currentLevel, local30.x, (byte) 5, local30.z);
							this.scene.method479(local30.anInt941, 60, null, local30.z, local30.y, local35, local30.anInt884, local30.anInt940, local30.anInt939, local30, false, this.currentLevel, local30.anInt942, local30.x);
						}
					}
				}
			}
			if (arg0 <= 0) {
				this.out.method381(210);
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
				this.packetType = this.in.method391();
			}
			@Pc(11) int local11 = arg1 >> 7;
			@Pc(15) int local15 = arg3 >> 7;
			@Pc(17) int local17 = arg0;
			if (arg0 < 3 && (this.levelTileFlags[1][local11][local15] & 0x2) == 2) {
				local17 = arg0 + 1;
			}
			@Pc(37) int local37 = arg1 & 0x7F;
			@Pc(41) int local41 = arg3 & 0x7F;
			@Pc(69) int local69 = this.levelHeightmap[local17][local11][local15] * (128 - local37) + this.levelHeightmap[local17][local11 + 1][local15] * local37 >> 7;
			@Pc(101) int local101 = this.levelHeightmap[local17][local11][local15 + 1] * (128 - local37) + this.levelHeightmap[local17][local11 + 1][local15 + 1] * local37 >> 7;
			return local69 * (128 - local41) + local101 * local41 >> 7;
		} catch (@Pc(114) RuntimeException local114) {
			signlink.reporterror("41583, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local114.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!bc;IIII)V")
	private void method95(@OriginalArg(0) NpcType arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			while (arg1 >= 0) {
				this.packetType = -1;
			}
			if (this.menuSize < 400) {
				@Pc(16) String local16 = arg0.aString2;
				if (arg0.anInt77 != 0) {
					local16 = local16 + method133(this.localPlayer.combatLevel, false, arg0.anInt77) + " (level-" + arg0.anInt77 + ")";
				}
				if (this.objSelected == 1) {
					this.menuOption[this.menuSize] = "Use " + this.selectedObjName + " with @yel@" + local16;
					this.menuAction[this.menuSize] = 900;
					this.menuParamA[this.menuSize] = arg4;
					this.menuParamB[this.menuSize] = arg3;
					this.menuParamC[this.menuSize] = arg2;
					this.menuSize++;
				} else if (this.spellSelected != 1) {
					@Pc(155) int local155;
					if (arg0.aStringArray2 != null) {
						for (local155 = 4; local155 >= 0; local155--) {
							if (arg0.aStringArray2[local155] != null && !arg0.aStringArray2[local155].equalsIgnoreCase("attack")) {
								this.menuOption[this.menuSize] = arg0.aStringArray2[local155] + " @yel@" + local16;
								if (local155 == 0) {
									this.menuAction[this.menuSize] = 728;
								}
								if (local155 == 1) {
									this.menuAction[this.menuSize] = 542;
								}
								if (local155 == 2) {
									this.menuAction[this.menuSize] = 6;
								}
								if (local155 == 3) {
									this.menuAction[this.menuSize] = 963;
								}
								if (local155 == 4) {
									this.menuAction[this.menuSize] = 245;
								}
								this.menuParamA[this.menuSize] = arg4;
								this.menuParamB[this.menuSize] = arg3;
								this.menuParamC[this.menuSize] = arg2;
								this.menuSize++;
							}
						}
					}
					if (arg0.aStringArray2 != null) {
						for (local155 = 4; local155 >= 0; local155--) {
							if (arg0.aStringArray2[local155] != null && arg0.aStringArray2[local155].equalsIgnoreCase("attack")) {
								@Pc(279) short local279 = 0;
								if (arg0.anInt77 > this.localPlayer.combatLevel) {
									local279 = 2000;
								}
								this.menuOption[this.menuSize] = arg0.aStringArray2[local155] + " @yel@" + local16;
								if (local155 == 0) {
									this.menuAction[this.menuSize] = local279 + 728;
								}
								if (local155 == 1) {
									this.menuAction[this.menuSize] = local279 + 542;
								}
								if (local155 == 2) {
									this.menuAction[this.menuSize] = local279 + 6;
								}
								if (local155 == 3) {
									this.menuAction[this.menuSize] = local279 + 963;
								}
								if (local155 == 4) {
									this.menuAction[this.menuSize] = local279 + 245;
								}
								this.menuParamA[this.menuSize] = arg4;
								this.menuParamB[this.menuSize] = arg3;
								this.menuParamC[this.menuSize] = arg2;
								this.menuSize++;
							}
						}
					}
					this.menuOption[this.menuSize] = "Examine @yel@" + local16;
					this.menuAction[this.menuSize] = 1607;
					this.menuParamA[this.menuSize] = arg4;
					this.menuParamB[this.menuSize] = arg3;
					this.menuParamC[this.menuSize] = arg2;
					this.menuSize++;
				} else if ((this.anInt293 & 0x2) == 2) {
					this.menuOption[this.menuSize] = this.spellCaption + " @yel@" + local16;
					this.menuAction[this.menuSize] = 265;
					this.menuParamA[this.menuSize] = arg4;
					this.menuParamB[this.menuSize] = arg3;
					this.menuParamC[this.menuSize] = arg2;
					this.menuSize++;
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
				this.anInt333 = this.randomIn.method532();
			}
			while (true) {
				@Pc(13) int local13;
				do {
					while (true) {
						local13 = this.method66(false);
						if (local13 == -1) {
							return;
						}
						if (this.viewportInterfaceID != -1 && this.viewportInterfaceID == this.reportAbuseInterfaceID) {
							if (local13 == 8 && this.reportAbuseInput.length() > 0) {
								this.reportAbuseInput = this.reportAbuseInput.substring(0, this.reportAbuseInput.length() - 1);
							}
							break;
						}
						@Pc(193) int local193;
						if (this.showSocialInput) {
							if (local13 >= 32 && local13 <= 122 && this.socialInput.length() < 80) {
								this.socialInput = this.socialInput + (char) local13;
								this.redrawChatback = true;
							}
							if (local13 == 8 && this.socialInput.length() > 0) {
								this.socialInput = this.socialInput.substring(0, this.socialInput.length() - 1);
								this.redrawChatback = true;
							}
							if (local13 == 13 || local13 == 10) {
								this.showSocialInput = false;
								this.redrawChatback = true;
								@Pc(153) long local153;
								if (this.socialAction == 1) {
									local153 = StringUtils.method538(this.socialInput);
									this.method161(local153, -460);
								}
								if (this.socialAction == 2 && this.friendCount > 0) {
									local153 = StringUtils.method538(this.socialInput);
									this.method174(43808, local153);
								}
								if (this.socialAction == 3 && this.socialInput.length() > 0) {
									this.out.method380((byte) -34, 148);
									this.out.method381(0);
									local193 = this.out.position;
									this.out.method387(true, this.aLong8);
									ChatCompression.method546(this.out, true, this.socialInput);
									this.out.method390(0, this.out.position - local193);
									this.socialInput = StringUtils.method543(this.socialInput, 0);
									this.socialInput = Censor.method424(this.socialInput, 0);
									this.method172(6, this.socialInput, (byte) 4, StringUtils.formatName(0, StringUtils.fromBase37(this.aLong8, false)));
									if (this.privateChatSetting == 2) {
										this.privateChatSetting = 1;
										this.redrawPrivacySettings = true;
										this.out.method380((byte) -34, 244);
										this.out.method381(this.publicChatSetting);
										this.out.method381(this.privateChatSetting);
										this.out.method381(this.tradeChatSetting);
									}
								}
								if (this.socialAction == 4 && this.ignoreCount < 100) {
									local153 = StringUtils.method538(this.socialInput);
									this.method82(local153, (byte) 3);
								}
								if (this.socialAction == 5 && this.ignoreCount > 0) {
									local153 = StringUtils.method538(this.socialInput);
									this.method191(1, local153);
								}
							}
						} else if (this.chatbackInput) {
							if (local13 >= 48 && local13 <= 57 && this.aString7.length() < 10) {
								this.aString7 = this.aString7 + (char) local13;
								this.redrawChatback = true;
							}
							if (local13 == 8 && this.aString7.length() > 0) {
								this.aString7 = this.aString7.substring(0, this.aString7.length() - 1);
								this.redrawChatback = true;
							}
							if (local13 == 13 || local13 == 10) {
								if (this.aString7.length() > 0) {
									local193 = 0;
									try {
										local193 = Integer.parseInt(this.aString7);
									} catch (@Pc(369) Exception local369) {
									}
									this.out.method380((byte) -34, 237);
									this.out.method385(local193);
								}
								this.chatbackInput = false;
								this.redrawChatback = true;
							}
						} else if (this.chatInterfaceId == -1) {
							if (local13 >= 32 && local13 <= 122 && this.aString18.length() < 80) {
								this.aString18 = this.aString18 + (char) local13;
								this.redrawChatback = true;
							}
							if (local13 == 8 && this.aString18.length() > 0) {
								this.aString18 = this.aString18.substring(0, this.aString18.length() - 1);
								this.redrawChatback = true;
							}
							if ((local13 == 13 || local13 == 10) && this.aString18.length() > 0) {
								if (this.aString18.equals("::clientdrop") && (super.frame != null || this.method134(-7437).indexOf("192.168.1.") != -1)) {
									this.method182(false);
								} else if (this.aString18.startsWith("::")) {
									this.out.method380((byte) -34, 4);
									this.out.method381(this.aString18.length() - 1);
									this.out.method388(this.aString18.substring(2));
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
									this.out.method380((byte) -34, 158);
									this.out.method381(0);
									@Pc(693) int local693 = this.out.position;
									this.out.method381(local496);
									this.out.method381(local654);
									ChatCompression.method546(this.out, true, this.aString18);
									this.out.method390(0, this.out.position - local693);
									this.aString18 = StringUtils.method543(this.aString18, 0);
									this.aString18 = Censor.method424(this.aString18, 0);
									this.localPlayer.chat = this.aString18;
									this.localPlayer.chatColor = local496;
									this.localPlayer.chatStyle = local654;
									this.localPlayer.chatTimer = 150;
									this.method172(2, this.localPlayer.chat, (byte) 4, this.localPlayer.name);
									if (this.publicChatSetting == 2) {
										this.publicChatSetting = 3;
										this.redrawPrivacySettings = true;
										this.out.method380((byte) -34, 244);
										this.out.method381(this.publicChatSetting);
										this.out.method381(this.privateChatSetting);
										this.out.method381(this.tradeChatSetting);
									}
								}
								this.aString18 = "";
								this.redrawChatback = true;
							}
						}
					}
				} while ((local13 < 97 || local13 > 122) && (local13 < 65 || local13 > 90) && (local13 < 48 || local13 > 57) && local13 != 32);
				if (this.reportAbuseInput.length() < 12) {
					this.reportAbuseInput = this.reportAbuseInput + (char) local13;
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
			if (this.errorStarted || this.errorLoading || this.errorHost) {
				this.method188(false);
			} else {
				if (this.ingame) {
					this.method130(29510);
				} else {
					this.method116(4);
				}
				this.dragCycles = 0;
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
				this.levelObjStacks = null;
			}
			@Pc(17) int local17;
			@Pc(24) int local24;
			if (this.anInt320 == 0) {
				local17 = super.anInt131 / 2 - 80;
				local24 = super.anInt132 / 2 + 20;
				local24 += 20;
				if (super.mouseClickButton == 1 && super.mouseClickX >= local17 - 75 && super.mouseClickX <= local17 + 75 && super.mouseClickY >= local24 - 20 && super.mouseClickY <= local24 + 20) {
					this.anInt320 = 3;
					this.anInt272 = 0;
				}
				local17 = super.anInt131 / 2 + 80;
				if (super.mouseClickButton == 1 && super.mouseClickX >= local17 - 75 && super.mouseClickX <= local17 + 75 && super.mouseClickY >= local24 - 20 && super.mouseClickY <= local24 + 20) {
					this.loginMessage0 = "";
					this.loginMessage1 = "Enter your username & password.";
					this.anInt320 = 2;
					this.anInt272 = 0;
				}
			} else if (this.anInt320 == 2) {
				local17 = super.anInt132 / 2 - 40;
				local17 += 30;
				local17 += 25;
				if (super.mouseClickButton == 1 && super.mouseClickY >= local17 - 15 && super.mouseClickY < local17) {
					this.anInt272 = 0;
				}
				local17 += 15;
				if (super.mouseClickButton == 1 && super.mouseClickY >= local17 - 15 && super.mouseClickY < local17) {
					this.anInt272 = 1;
				}
				local17 += 15;
				local24 = super.anInt131 / 2 - 80;
				@Pc(170) int local170 = super.anInt132 / 2 + 50;
				@Pc(171) int local171 = local170 + 20;
				if (super.mouseClickButton == 1 && super.mouseClickX >= local24 - 75 && super.mouseClickX <= local24 + 75 && super.mouseClickY >= local171 - 20 && super.mouseClickY <= local171 + 20) {
					this.method159(this.username, this.aString14, false);
				}
				local24 = super.anInt131 / 2 + 80;
				if (super.mouseClickButton == 1 && super.mouseClickX >= local24 - 75 && super.mouseClickX <= local24 + 75 && super.mouseClickY >= local171 - 20 && super.mouseClickY <= local171 + 20) {
					this.anInt320 = 0;
					this.username = "";
					this.aString14 = "";
				}
				while (true) {
					while (true) {
						@Pc(254) int local254 = this.method66(false);
						if (local254 == -1) {
							return;
						}
						@Pc(259) boolean local259 = false;
						for (@Pc(261) int local261 = 0; local261 < aString4.length(); local261++) {
							if (local254 == aString4.charAt(local261)) {
								local259 = true;
								break;
							}
						}
						if (this.anInt272 == 0) {
							if (local254 == 8 && this.username.length() > 0) {
								this.username = this.username.substring(0, this.username.length() - 1);
							}
							if (local254 == 9 || local254 == 10 || local254 == 13) {
								this.anInt272 = 1;
							}
							if (local259) {
								this.username = this.username + (char) local254;
							}
							if (this.username.length() > 12) {
								this.username = this.username.substring(0, 12);
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
				if (super.mouseClickButton == 1 && super.mouseClickX >= local17 - 75 && super.mouseClickX <= local17 + 75 && super.mouseClickY >= local418 - 20 && super.mouseClickY <= local418 + 20) {
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
	private FileArchive method98(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		try {
			@Pc(3) int local3 = 5;
			@Pc(6) byte[] local6 = signlink.cacheload(arg2);
			@Pc(20) int local20;
			if (local6 != null) {
				this.crc32.reset();
				this.crc32.update(local6);
				local20 = (int) this.crc32.getValue();
				if (local20 != arg1) {
					local6 = null;
				}
			}
			if (local6 != null) {
				return new FileArchive(local6, this.aBoolean55);
			}
			while (local6 == null) {
				this.method74(true, "Requesting " + arg0, arg3);
				try {
					local20 = 0;
					@Pc(60) DataInputStream local60 = this.method155(arg2 + arg1);
					@Pc(63) byte[] local63 = new byte[6];
					local60.readFully(local63, 0, 6);
					@Pc(74) Buffer local74 = new Buffer(363, local63);
					local74.position = 3;
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
			return new FileArchive(local6, this.aBoolean55);
		} catch (@Pc(216) RuntimeException local216) {
			signlink.reporterror("37683, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local216.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(Z)V")
	private void method99(@OriginalArg(0) boolean arg0) {
		try {
			this.flameActive = false;
			while (this.flameThread) {
				this.flameActive = false;
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
			this.flameBuffer0 = null;
			this.flameBuffer1 = null;
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
				local23 = Model.sin[local5];
				local27 = Model.cos[local5];
				local37 = local15 * local27 - arg6 * local23 >> 16;
				local17 = local15 * local23 + arg6 * local27 >> 16;
				local15 = local37;
			}
			if (local11 != 0) {
				local23 = Model.sin[local11];
				local27 = Model.cos[local11];
				local37 = local17 * local23 + local13 * local27 >> 16;
				local17 = local17 * local27 - local13 * local23 >> 16;
				local13 = local37;
			}
			this.cameraX = arg1 - local13;
			this.cameraY = arg0 - local15;
			this.cameraZ = arg5 - local17;
			this.cameraPitch = arg3;
			if (arg4 != 16418) {
				this.levelObjStacks = null;
			}
			this.cameraYaw = arg2;
		} catch (@Pc(110) RuntimeException local110) {
			signlink.reporterror("79526, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local110.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZ)V")
	private void method102(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1) {
		try {
			if (!arg1) {
				this.packetType = -1;
			}
			if (!lowMemory) {
				@Pc(17) Image8 local17;
				@Pc(25) int local25;
				@Pc(33) int local33;
				@Pc(36) byte[] local36;
				@Pc(39) byte[] local39;
				@Pc(41) int local41;
				if (Draw3D.anIntArray141[17] >= arg0) {
					local17 = Draw3D.aClass1_Sub3_Sub2_Sub3Array4[17];
					local25 = local17.width * local17.height - 1;
					local33 = local17.width * this.sceneDelta * 2;
					local36 = local17.pixels;
					local39 = this.aByteArray4;
					for (local41 = 0; local41 <= local25; local41++) {
						local39[local41] = local36[local41 - local33 & local25];
					}
					local17.pixels = local39;
					this.aByteArray4 = local36;
					Draw3D.method294(17, 150);
				}
				if (Draw3D.anIntArray141[24] >= arg0) {
					local17 = Draw3D.aClass1_Sub3_Sub2_Sub3Array4[24];
					local25 = local17.width * local17.height - 1;
					local33 = local17.width * this.sceneDelta * 2;
					local36 = local17.pixels;
					local39 = this.aByteArray4;
					for (local41 = 0; local41 <= local25; local41++) {
						local39[local41] = local36[local41 - local33 & local25];
					}
					local17.pixels = local39;
					this.aByteArray4 = local36;
					Draw3D.method294(24, 150);
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
				this.packetType = this.in.method391();
			}
			for (local41 = 1; local41 < local3 - 1; local41++) {
				for (local48 = 1; local48 < 127; local48++) {
					local54 = local48 + (local41 << 7);
					this.anIntArray65[local54] = (this.anIntArray64[local54 - 1] + this.anIntArray64[local54 + 1] + this.anIntArray64[local54 - 128] + this.anIntArray64[local54 + 128]) / 4;
				}
			}
			this.anInt344 += 128;
			if (this.anInt344 > this.flameBuffer0.length) {
				this.anInt344 -= this.flameBuffer0.length;
				local48 = (int) (Math.random() * 12.0D);
				this.method183(578, this.aClass1_Sub3_Sub2_Sub3Array2[local48]);
			}
			@Pc(173) int local173;
			for (local48 = 1; local48 < local3 - 1; local48++) {
				for (local54 = 1; local54 < 127; local54++) {
					local173 = local54 + (local48 << 7);
					@Pc(196) int local196 = this.anIntArray65[local173 + 128] - this.flameBuffer0[local173 + this.anInt344 & this.flameBuffer0.length - 1] / 5;
					if (local196 < 0) {
						local196 = 0;
					}
					this.anIntArray64[local173] = local196;
				}
			}
			for (local54 = 0; local54 < local3 - 1; local54++) {
				this.anIntArray43[local54] = this.anIntArray43[local54 + 1];
			}
			this.anIntArray43[local3 - 1] = (int) (Math.sin((double) loopCycle / 14.0D) * 16.0D + Math.sin((double) loopCycle / 15.0D) * 14.0D + Math.sin((double) loopCycle / 16.0D) * 12.0D);
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
			this.areaMapback.method463((byte) 62);
			if (arg0 != -46) {
				this.method67();
			}
			@Pc(18) int local18 = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
			@Pc(26) int local26 = this.localPlayer.x / 32 + 48;
			@Pc(34) int local34 = 464 - this.localPlayer.z / 32;
			this.imageMinimap.method328(local18, 146, this.minimapMaskLineOffsets, 151, local34, this.minimapZoom + 256, local26, 21, 9, false, this.minimapMaskLineLengths);
			this.imageCompass.method328(this.orbitCameraYaw, 33, this.compassMaskLineOffsets, 33, 25, 256, 25, 0, 0, false, this.compassMaskLineLengths);
			for (@Pc(72) int local72 = 0; local72 < this.anInt246; local72++) {
				local26 = this.anIntArray54[local72] * 4 + 2 - this.localPlayer.x / 32;
				local34 = this.anIntArray55[local72] * 4 + 2 - this.localPlayer.z / 32;
				this.method148(local34, 4, this.aClass1_Sub3_Sub2_Sub2Array4[local72], local26);
			}
			@Pc(124) int local124;
			for (@Pc(120) int local120 = 0; local120 < 104; local120++) {
				for (local124 = 0; local124 < 104; local124++) {
					@Pc(136) DoublyLinkedList local136 = this.levelObjStacks[this.currentLevel][local120][local124];
					if (local136 != null) {
						local26 = local120 * 4 + 2 - this.localPlayer.x / 32;
						local34 = local124 * 4 + 2 - this.localPlayer.z / 32;
						this.method148(local34, 4, this.imageMapdot0, local26);
					}
				}
			}
			for (local124 = 0; local124 < this.npcCount; local124++) {
				@Pc(189) NpcEntity local189 = this.npcs[this.npcIds[local124]];
				if (local189 != null && local189.isVisible(false) && local189.type.aBoolean20) {
					local26 = local189.x / 32 - this.localPlayer.x / 32;
					local34 = local189.z / 32 - this.localPlayer.z / 32;
					this.method148(local34, 4, this.imageMapdot1, local26);
				}
			}
			for (@Pc(235) int local235 = 0; local235 < this.playerCount; local235++) {
				@Pc(245) PlayerEntity local245 = this.players[this.playerIds[local235]];
				if (local245 != null && local245.isVisible(false)) {
					local26 = local245.x / 32 - this.localPlayer.x / 32;
					local34 = local245.z / 32 - this.localPlayer.z / 32;
					@Pc(275) boolean local275 = false;
					@Pc(279) long local279 = StringUtils.method538(local245.name);
					for (@Pc(281) int local281 = 0; local281 < this.friendCount; local281++) {
						if (local279 == this.friendName37[local281] && this.friendWorld[local281] != 0) {
							local275 = true;
							break;
						}
					}
					if (local275) {
						this.method148(local34, 4, this.imageMapdot3, local26);
					} else {
						this.method148(local34, 4, this.imageMapdot2, local26);
					}
				}
			}
			if (this.flagSceneTileX != 0) {
				local26 = this.flagSceneTileX * 4 + 2 - this.localPlayer.x / 32;
				local34 = this.flagSceneTileZ * 4 + 2 - this.localPlayer.z / 32;
				this.method148(local34, 4, this.imageMapflag, local26);
			}
			Draw2D.method358(82, 93, 16777215, (byte) 93, 3, 3);
			this.areaViewport.method463((byte) 62);
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
				return super.frame == null ? this : super.frame;
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
			if (this.sceneState == 2) {
				for (@Pc(12) SceneLocTemporary2 local12 = (SceneLocTemporary2) this.aClass28_2.method456(); local12 != null; local12 = (SceneLocTemporary2) this.aClass28_2.method458(551)) {
					if (loopCycle >= local12.anInt638) {
						this.method160(local12.anInt636, local12.anInt633, local12.anInt634, local12.anInt632, local12.anInt635, local12.anInt637, -27819, local12.anInt631);
						local12.method567();
					}
				}
				anInt319++;
				if (anInt319 > 85) {
					anInt319 = 0;
					this.out.method380((byte) -34, 85);
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
			@Pc(5) int[] local5 = this.imageMinimap.pixels;
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
						if ((this.levelTileFlags[arg0][local39][local25] & 0x18) == 0) {
							this.scene.method503(local5, local37, 512, arg0, local39, local25);
						}
						if (arg0 < 3 && (this.levelTileFlags[arg0 + 1][local39][local25] & 0x8) != 0) {
							this.scene.method503(local5, local37, 512, arg0 + 1, local39, local25);
						}
						local37 += 4;
					}
				}
				local37 = ((int) (Math.random() * 20.0D) + 238 - 10 << 16) + ((int) (Math.random() * 20.0D) + 238 - 10 << 8) + (int) (Math.random() * 20.0D) + 238 - 10;
				local39 = (int) (Math.random() * 20.0D) + 238 - 10 << 16;
				this.imageMinimap.method318((byte) 62);
				@Pc(149) int local149;
				for (@Pc(145) int local145 = 1; local145 < 103; local145++) {
					for (local149 = 1; local149 < 103; local149++) {
						if ((this.levelTileFlags[arg0][local149][local145] & 0x18) == 0) {
							this.method107(anInt238, arg0, local37, local149, local39, local145);
						}
						if (arg0 < 3 && (this.levelTileFlags[arg0 + 1][local149][local145] & 0x8) != 0) {
							this.method107(anInt238, arg0 + 1, local37, local149, local39, local145);
						}
					}
				}
				this.areaViewport.method463((byte) 62);
				this.anInt246 = 0;
				for (local149 = 0; local149 < 104; local149++) {
					for (@Pc(217) int local217 = 0; local217 < 104; local217++) {
						@Pc(227) int local227 = this.scene.method497(this.currentLevel, local149, local217);
						if (local227 != 0) {
							local227 = local227 >> 14 & 0x7FFF;
							@Pc(239) int local239 = LocType.method23(local227).anInt47;
							if (local239 >= 0) {
								@Pc(243) int local243 = local149;
								@Pc(245) int local245 = local217;
								if (local239 != 22 && local239 != 29 && local239 != 34 && local239 != 36 && local239 != 46 && local239 != 47 && local239 != 48) {
									@Pc(268) byte local268 = 104;
									@Pc(270) byte local270 = 104;
									@Pc(277) int[][] local277 = this.levelCollisionMap[this.currentLevel].flags;
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
								this.aClass1_Sub3_Sub2_Sub2Array4[this.anInt246] = this.imageMapfunction[local239];
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
			@Pc(8) int local8 = this.scene.method494(arg1, arg3, arg5);
			@Pc(18) int local18;
			@Pc(24) int local24;
			@Pc(28) int local28;
			@Pc(30) int local30;
			@Pc(52) int local52;
			@Pc(58) int local58;
			if (local8 != 0) {
				local18 = this.scene.method498(arg1, arg3, arg5, local8);
				local24 = local18 >> 6 & 0x3;
				local28 = local18 & 0x1F;
				local30 = arg2;
				if (local8 > 0) {
					local30 = arg4;
				}
				@Pc(38) int[] local38 = this.imageMinimap.pixels;
				local52 = arg3 * 4 + (103 - arg5) * 512 * 4 + 24624;
				local58 = local8 >> 14 & 0x7FFF;
				@Pc(61) LocType local61 = LocType.method23(local58);
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
					@Pc(71) Image8 local71 = this.imageMapscene[local61.anInt48];
					if (local71 != null) {
						@Pc(83) int local83 = (local61.sizeX * 4 - local71.width) / 2;
						@Pc(93) int local93 = (local61.sizeZ * 4 - local71.height) / 2;
						local71.method350((104 - arg5 - local61.sizeZ) * 4 + local93 + 48, arg3 * 4 + 48 + local83, false);
					}
				}
			}
			local8 = this.scene.method496(arg1, arg3, arg5);
			@Pc(422) int local422 = 56 / arg0;
			if (local8 != 0) {
				local18 = this.scene.method498(arg1, arg3, arg5, local8);
				local24 = local18 >> 6 & 0x3;
				local28 = local18 & 0x1F;
				local30 = local8 >> 14 & 0x7FFF;
				@Pc(451) LocType local451 = LocType.method23(local30);
				@Pc(483) int local483;
				if (local451.anInt48 != -1) {
					@Pc(461) Image8 local461 = this.imageMapscene[local451.anInt48];
					if (local461 != null) {
						local58 = (local451.sizeX * 4 - local461.width) / 2;
						local483 = (local451.sizeZ * 4 - local461.height) / 2;
						local461.method350((104 - arg5 - local451.sizeZ) * 4 + local483 + 48, arg3 * 4 + 48 + local58, false);
					}
				} else if (local28 == 9) {
					local52 = 15658734;
					if (local8 > 0) {
						local52 = 15597568;
					}
					@Pc(520) int[] local520 = this.imageMinimap.pixels;
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
			local8 = this.scene.method497(arg1, arg3, arg5);
			if (local8 != 0) {
				local18 = local8 >> 14 & 0x7FFF;
				@Pc(615) LocType local615 = LocType.method23(local18);
				if (local615.anInt48 != -1) {
					@Pc(625) Image8 local625 = this.imageMapscene[local615.anInt48];
					if (local625 != null) {
						local30 = (local615.sizeX * 4 - local625.width) / 2;
						@Pc(647) int local647 = (local615.sizeZ * 4 - local625.height) / 2;
						local625.method350((104 - arg5 - local615.sizeZ) * 4 + local647 + 48, arg3 * 4 + 48 + local30, false);
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
	private void method108(@OriginalArg(0) Buffer arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2) {
		try {
			this.entityRemovalCount = 0;
			this.entityUpdateCount = 0;
			this.method181(-542, arg0, arg1);
			this.method141(false, arg0, arg1);
			this.method81(arg0, arg1, this.anInt302);
			if (arg2) {
				anInt268 = 338;
			}
			@Pc(36) int local36;
			for (@Pc(29) int local29 = 0; local29 < this.entityRemovalCount; local29++) {
				local36 = this.entityRemovalIds[local29];
				if (this.npcs[local36].cycle != loopCycle) {
					this.npcs[local36].type = null;
					this.npcs[local36] = null;
				}
			}
			if (arg0.position != arg1) {
				signlink.reporterror(this.username + " size mismatch in getnpcpos - pos:" + arg0.position + " psize:" + arg1);
				throw new RuntimeException("eek");
			}
			for (local36 = 0; local36 < this.npcCount; local36++) {
				if (this.npcs[this.npcIds[local36]] == null) {
					signlink.reporterror(this.username + " null entry in npc list - pos:" + local36 + " size:" + this.npcCount);
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
			this.aClass1_Sub3_Sub2_Sub3_19 = new Image8(this.archiveTitle, "titlebox", 0);
			this.aClass1_Sub3_Sub2_Sub3_20 = new Image8(this.archiveTitle, "titlebutton", 0);
			if (arg0 != 0) {
				this.packetType = this.in.method391();
			}
			this.aClass1_Sub3_Sub2_Sub3Array2 = new Image8[12];
			for (@Pc(32) int local32 = 0; local32 < 12; local32++) {
				this.aClass1_Sub3_Sub2_Sub3Array2[local32] = new Image8(this.archiveTitle, "runes", local32);
			}
			this.aClass1_Sub3_Sub2_Sub2_3 = new Image24(128, 265);
			this.aClass1_Sub3_Sub2_Sub2_4 = new Image24(128, 265);
			for (@Pc(65) int local65 = 0; local65 < 33920; local65++) {
				this.aClass1_Sub3_Sub2_Sub2_3.pixels[local65] = this.imageTitle0.anIntArray197[local65];
			}
			for (@Pc(83) int local83 = 0; local83 < 33920; local83++) {
				this.aClass1_Sub3_Sub2_Sub2_4.pixels[local83] = this.imageTitle1.anIntArray197[local83];
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
			this.flameBuffer0 = new int[32768];
			this.flameBuffer1 = new int[32768];
			this.method183(578, null);
			this.anIntArray64 = new int[32768];
			this.anIntArray65 = new int[32768];
			this.method74(true, "Connecting to fileserver", 10);
			if (!this.flameActive) {
				this.aBoolean63 = true;
				this.flameActive = true;
				this.method73(this, 2);
			}
		} catch (@Pc(359) RuntimeException local359) {
			signlink.reporterror("57688, " + arg0 + ", " + local359.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!kb;I)V")
	private void method110(@OriginalArg(0) int arg0, @OriginalArg(1) Buffer arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(6) int local6 = arg1.method402(9, 8);
			@Pc(10) int local10;
			if (arg2 != 0) {
				for (local10 = 1; local10 > 0; local10++) {
				}
			}
			if (local6 < this.playerCount) {
				for (local10 = local6; local10 < this.playerCount; local10++) {
					this.entityRemovalIds[this.entityRemovalCount++] = this.playerIds[local10];
				}
			}
			if (local6 > this.playerCount) {
				signlink.reporterror(this.username + " Too many players");
				throw new RuntimeException("eek");
			}
			this.playerCount = 0;
			for (local10 = 0; local10 < local6; local10++) {
				@Pc(73) int local73 = this.playerIds[local10];
				@Pc(78) PlayerEntity local78 = this.players[local73];
				@Pc(83) int local83 = arg1.method402(9, 1);
				if (local83 == 0) {
					this.playerIds[this.playerCount++] = local73;
					local78.cycle = loopCycle;
				} else {
					@Pc(106) int local106 = arg1.method402(9, 2);
					if (local106 == 0) {
						this.playerIds[this.playerCount++] = local73;
						local78.cycle = loopCycle;
						this.entityUpdateIds[this.entityUpdateCount++] = local73;
					} else {
						@Pc(157) int local157;
						@Pc(167) int local167;
						if (local106 == 1) {
							this.playerIds[this.playerCount++] = local73;
							local78.cycle = loopCycle;
							local157 = arg1.method402(9, 3);
							local78.step(false, local157, (byte) 6);
							local167 = arg1.method402(9, 1);
							if (local167 == 1) {
								this.entityUpdateIds[this.entityUpdateCount++] = local73;
							}
						} else if (local106 == 2) {
							this.playerIds[this.playerCount++] = local73;
							local78.cycle = loopCycle;
							local157 = arg1.method402(9, 3);
							local78.step(true, local157, (byte) 6);
							local167 = arg1.method402(9, 3);
							local78.step(true, local167, (byte) 6);
							@Pc(225) int local225 = arg1.method402(9, 1);
							if (local225 == 1) {
								this.entityUpdateIds[this.entityUpdateCount++] = local73;
							}
						} else if (local106 == 3) {
							this.entityRemovalIds[this.entityRemovalCount++] = local73;
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
			this.imageScrollbar0.method350(arg2, arg1, false);
			this.imageScrollbar1.method350(arg2 + arg5 - 16, arg1, false);
			Draw2D.method358(arg2 + 16, arg1, this.anInt295, (byte) 93, 16, arg5 - 32);
			@Pc(35) int local35 = (arg5 - 32) * arg5 / arg4;
			if (local35 < 8) {
				local35 = 8;
			}
			@Pc(52) int local52 = (arg5 - local35 - 32) * arg3 / (arg4 - arg5);
			if (arg0 <= 0) {
				this.packetType = -1;
			}
			Draw2D.method358(arg2 + local52 + 16, arg1, this.anInt345, (byte) 93, 16, local35);
			Draw2D.method361(this.anInt278, this.anInt145, arg2 + local52 + 16, local35, arg1);
			Draw2D.method361(this.anInt278, this.anInt145, arg2 + local52 + 16, local35, arg1 + 1);
			Draw2D.method360(this.anInt278, 0, arg2 + local52 + 16, 16, arg1);
			Draw2D.method360(this.anInt278, 0, arg2 + local52 + 17, 16, arg1);
			Draw2D.method361(this.anInt275, this.anInt145, arg2 + local52 + 16, local35, arg1 + 15);
			Draw2D.method361(this.anInt275, this.anInt145, arg2 + local52 + 17, local35 - 1, arg1 + 14);
			Draw2D.method360(this.anInt275, 0, arg2 + local52 + local35 + 15, 16, arg1);
			Draw2D.method360(this.anInt275, 0, arg2 + local52 + local35 + 14, 15, arg1 + 1);
		} catch (@Pc(177) RuntimeException local177) {
			signlink.reporterror("15221, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local177.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(B)V")
	private void method112(@OriginalArg(0) byte arg0) {
		try {
			this.updateDesignModel = true;
			if (arg0 != -6) {
				this.levelObjStacks = null;
			}
			for (@Pc(12) int local12 = 0; local12 < 7; local12++) {
				this.designIdentikits[local12] = -1;
				for (@Pc(21) int local21 = 0; local21 < IdkType.count; local21++) {
					if (!IdkType.instances[local21].selectable && IdkType.instances[local21].type == local12 + (this.designGenderMale ? 0 : 7)) {
						this.designIdentikits[local12] = local21;
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
			for (@Pc(1) int local1 = 0; local1 < this.npcCount; local1++) {
				@Pc(11) NpcEntity local11 = this.npcs[this.npcIds[local1]];
				@Pc(20) int local20 = (this.npcIds[local1] << 14) + 536870912;
				if (local11 != null && local11.isVisible(false)) {
					@Pc(31) int local31 = local11.x >> 7;
					@Pc(36) int local36 = local11.z >> 7;
					if (local31 >= 0 && local31 < 104 && local36 >= 0 && local36 < 104) {
						if (local11.size == 1 && (local11.x & 0x7F) == 64 && (local11.z & 0x7F) == 64) {
							if (this.anIntArrayArray3[local31][local36] == this.sceneCycle) {
								continue;
							}
							this.anIntArrayArray3[local31][local36] = this.sceneCycle;
						}
						this.scene.method478(-44713, local11.z, (local11.size - 1) * 64 + 60, local11.anInt884, local11.x, local20, local11.aBoolean160, null, local11, this.method94(this.currentLevel, local11.x, (byte) 5, local11.z), this.currentLevel);
					}
				}
			}
			if (arg0) {
				this.packetType = -1;
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
			this.packetSize += arg0;
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
			this.imageTitle4.method463((byte) 62);
			if (arg0 >= 4 && arg0 <= 4) {
				this.aClass1_Sub3_Sub2_Sub3_19.method350(0, 0, false);
				@Pc(21) short local21 = 360;
				@Pc(23) short local23 = 200;
				@Pc(32) int local32;
				@Pc(50) int local50;
				@Pc(56) int local56;
				if (this.anInt320 == 0) {
					local32 = local23 / 2 - 20;
					this.fontBold12.method363(local21 / 2, 16776960, true, local32, "Welcome to RuneScape", 0);
					@Pc(44) int local44 = local32 + 30;
					local50 = local21 / 2 - 80;
					local56 = local23 / 2 + 20;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.fontBold12.method363(local50, 16777215, true, local56 + 5, "New user", 0);
					@Pc(83) int local83 = local21 / 2 + 80;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local83 - 73, false);
					this.fontBold12.method363(local83, 16777215, true, local56 + 5, "Existing User", 0);
				}
				if (this.anInt320 == 2) {
					local32 = local23 / 2 - 40;
					if (this.loginMessage0.length() > 0) {
						this.fontBold12.method363(local21 / 2, 16776960, true, local32 - 15, this.loginMessage0, 0);
						this.fontBold12.method363(local21 / 2, 16776960, true, local32, this.loginMessage1, 0);
						local32 += 30;
					} else {
						this.fontBold12.method363(local21 / 2, 16776960, true, local32 - 7, this.loginMessage1, 0);
						local32 += 30;
					}
					this.fontBold12.method367(local21 / 2 - 90, 6, local32, "Username: " + this.username + (this.anInt272 == 0 & loopCycle % 40 < 20 ? "@yel@|" : ""), true, 16777215);
					local32 += 15;
					this.fontBold12.method367(local21 / 2 - 88, 6, local32, "Password: " + StringUtils.method544(7, this.aString14) + (this.anInt272 == 1 & loopCycle % 40 < 20 ? "@yel@|" : ""), true, 16777215);
					local32 += 15;
					local50 = local21 / 2 - 80;
					local56 = local23 / 2 + 50;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.fontBold12.method363(local50, 16777215, true, local56 + 5, "Login", 0);
					local50 = local21 / 2 + 80;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.fontBold12.method363(local50, 16777215, true, local56 + 5, "Cancel", 0);
				}
				if (this.anInt320 == 3) {
					this.fontBold12.method363(local21 / 2, 16776960, true, local23 / 2 - 60, "Create a free account", 0);
					local32 = local23 / 2 - 35;
					this.fontBold12.method363(local21 / 2, 16777215, true, local32, "To create a new account you need to", 0);
					local32 += 15;
					this.fontBold12.method363(local21 / 2, 16777215, true, local32, "go back to the main RuneScape webpage", 0);
					local32 += 15;
					this.fontBold12.method363(local21 / 2, 16777215, true, local32, "and choose the red 'create account'", 0);
					local32 += 15;
					this.fontBold12.method363(local21 / 2, 16777215, true, local32, "button at the top right of that page.", 0);
					local32 += 15;
					local50 = local21 / 2;
					local56 = local23 / 2 + 50;
					this.aClass1_Sub3_Sub2_Sub3_20.method350(local56 - 20, local50 - 73, false);
					this.fontBold12.method363(local50, 16777215, true, local56 + 5, "Cancel", 0);
				}
				this.imageTitle4.method464(186, super.graphics, 214, 5193);
				if (this.redrawTitleBackground) {
					this.redrawTitleBackground = false;
					this.imageTitle2.method464(0, super.graphics, 128, 5193);
					this.imageTitle3.method464(386, super.graphics, 214, 5193);
					this.imageTitle5.method464(265, super.graphics, 0, 5193);
					this.imageTitle6.method464(265, super.graphics, 574, 5193);
					this.imageTitle7.method464(186, super.graphics, 128, 5193);
					this.imageTitle8.method464(186, super.graphics, 574, 5193);
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
			if (this.areaChatback == null) {
				this.method99(true);
				super.aClass32_2 = null;
				this.imageTitle2 = null;
				this.imageTitle3 = null;
				this.imageTitle4 = null;
				this.imageTitle0 = null;
				if (arg0 == -7185) {
					this.imageTitle1 = null;
					this.imageTitle5 = null;
					this.imageTitle6 = null;
					this.imageTitle7 = null;
					this.imageTitle8 = null;
					this.areaChatback = new DrawArea(this.method72(aByte16), 479, 299, 96);
					this.areaMapback = new DrawArea(this.method72(aByte16), 168, 299, 160);
					Draw2D.method357(this.anInt336);
					this.imageMapback.method350(0, 0, false);
					this.areaSidebar = new DrawArea(this.method72(aByte16), 190, 299, 261);
					this.areaViewport = new DrawArea(this.method72(aByte16), 512, 299, 334);
					Draw2D.method357(this.anInt336);
					this.areaBackbase1 = new DrawArea(this.method72(aByte16), 501, 299, 61);
					this.areaBackbase2 = new DrawArea(this.method72(aByte16), 288, 299, 40);
					this.areaBackhmid1 = new DrawArea(this.method72(aByte16), 269, 299, 66);
					this.redrawTitleBackground = true;
				}
			}
		} catch (@Pc(134) RuntimeException local134) {
			signlink.reporterror("20178, " + arg0 + ", " + local134.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!kb;)V")
	private void method118(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Buffer arg2) {
		try {
			@Pc(9) int local9;
			if (arg0 < 2 || arg0 > 2) {
				for (local9 = 1; local9 > 0; local9++) {
				}
			}
			while (arg2.bitPosition + 10 < arg1 * 8) {
				local9 = arg2.method402(9, 11);
				if (local9 == 2047) {
					break;
				}
				if (this.players[local9] == null) {
					this.players[local9] = new PlayerEntity();
					if (this.playerAppearanceBuffer[local9] != null) {
						this.players[local9].method572(false, this.playerAppearanceBuffer[local9]);
					}
				}
				this.playerIds[this.playerCount++] = local9;
				@Pc(73) PlayerEntity local73 = this.players[local9];
				local73.cycle = loopCycle;
				@Pc(81) int local81 = arg2.method402(9, 5);
				if (local81 > 15) {
					local81 -= 32;
				}
				@Pc(90) int local90 = arg2.method402(9, 5);
				if (local90 > 15) {
					local90 -= 32;
				}
				@Pc(99) int local99 = arg2.method402(9, 1);
				local73.move(false, local99 == 1, this.localPlayer.pathTileX[0] + local81, this.localPlayer.pathTileZ[0] + local90);
				@Pc(127) int local127 = arg2.method402(9, 1);
				if (local127 == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = local9;
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
				if (this.connection != null) {
					this.connection.method201();
				}
			} catch (@Pc(9) Exception local9) {
			}
			this.connection = null;
			this.ingame = false;
			this.anInt320 = 0;
			this.username = "";
			this.aString14 = "";
			InputTracking.method209((byte) 65);
			this.method144(this.aByte10);
			if (arg0 < 0) {
				this.scene.method467(742);
				for (@Pc(41) int local41 = 0; local41 < 4; local41++) {
					this.levelCollisionMap[local41].method249((byte) 74);
				}
				System.gc();
				this.method78(0);
				this.currentMidi = null;
				this.nextMusicDelay = 0;
			}
		} catch (@Pc(65) RuntimeException local65) {
			signlink.reporterror("36279, " + arg0 + ", " + local65.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;I)V")
	private void method120(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) IfType arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg3.anInt472 == 0 && arg3.anIntArray153 != null && (!arg3.aBoolean106 || this.anInt300 == arg3.anInt470 || this.anInt256 == arg3.anInt470 || this.anInt221 == arg3.anInt470)) {
				@Pc(29) int local29 = Draw2D.anInt532;
				@Pc(31) int local31 = Draw2D.anInt530;
				@Pc(33) int local33 = Draw2D.anInt533;
				@Pc(35) int local35 = Draw2D.anInt531;
				if (arg2 != 38682) {
					this.packetType = -1;
				}
				Draw2D.method356(arg0 + arg3.height, arg0, arg1 + arg3.anInt475, 789, arg1);
				@Pc(57) int local57 = arg3.anIntArray153.length;
				for (@Pc(59) int local59 = 0; local59 < local57; local59++) {
					@Pc(68) int local68 = arg3.anIntArray154[local59] + arg1;
					@Pc(77) int local77 = arg3.anIntArray155[local59] + arg0 - arg4;
					@Pc(84) IfType local84 = IfType.instances[arg3.anIntArray153[local59]];
					@Pc(89) int local89 = local68 + local84.anInt477;
					@Pc(94) int local94 = local77 + local84.anInt478;
					if (local84.contentType > 0) {
						this.method137(0, local84);
					}
					if (local84.anInt472 == 0) {
						if (local84.scrollPosition > local84.scrollableHeight - local84.height) {
							local84.scrollPosition = local84.scrollableHeight - local84.height;
						}
						if (local84.scrollPosition < 0) {
							local84.scrollPosition = 0;
						}
						this.method120(local94, local89, 38682, local84, local84.scrollPosition);
						if (local84.scrollableHeight > local84.height) {
							this.method111(this.anInt192, local89 + local84.anInt475, local94, local84.scrollPosition, local84.scrollableHeight, local84.height);
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
							for (local167 = 0; local167 < local84.height; local167++) {
								for (local171 = 0; local171 < local84.anInt475; local171++) {
									local182 = local89 + local171 * (local84.anInt483 + 32);
									local191 = local94 + local167 * (local84.anInt484 + 32);
									if (local165 < 20) {
										local182 += local84.anIntArray156[local165];
										local191 += local84.anIntArray157[local165];
									}
									if (local84.inventorySlotObjId[local165] > 0) {
										local215 = 0;
										local217 = 0;
										local224 = local84.inventorySlotObjId[local165] - 1;
										if (local182 >= -32 && local182 <= 512 && local191 >= -32 && local191 <= 334 || this.objDragArea != 0 && this.objDragSlot == local165) {
											@Pc(251) Image24 local251 = ObjType.method59(local224, 24638, local84.inventorySlotObjCount[local165]);
											if (this.objDragArea != 0 && this.objDragSlot == local165 && this.objDragInterfaceId == local84.anInt470) {
												local215 = super.mouseX - this.objGrabX;
												local217 = super.mouseY - this.objGrabY;
												if (local215 < 5 && local215 > -5) {
													local215 = 0;
												}
												if (local217 < 5 && local217 > -5) {
													local217 = 0;
												}
												if (this.objDragCycles < 5) {
													local215 = 0;
													local217 = 0;
												}
												local251.method326(128, local182 + local215, local191 + local217, (byte) -26);
											} else if (this.selectedArea != 0 && this.anInt259 == local165 && this.anInt258 == local84.anInt470) {
												local251.method326(128, local182, local191, (byte) -26);
											} else {
												local251.method322(local191, local182, false);
											}
											if (local251.cropW == 33 || local84.inventorySlotObjCount[local165] != 1) {
												@Pc(351) int local351 = local84.inventorySlotObjCount[local165];
												this.fontPlain11.method365(local182 + local215 + 1, local191 + 10 + local217, false, 0, method169(true, local351));
												this.fontPlain11.method365(local182 + local215, local191 + 9 + local217, false, 16776960, method169(true, local351));
											}
										}
									} else if (local84.aClass1_Sub3_Sub2_Sub2Array8 != null && local165 < 20) {
										@Pc(398) Image24 local398 = local84.aClass1_Sub3_Sub2_Sub2Array8[local165];
										if (local398 != null) {
											local398.method322(local191, local182, false);
										}
									}
									local165++;
								}
							}
						} else if (local84.anInt472 != 3) {
							@Pc(456) BitmapFont local456;
							if (local84.anInt472 == 4) {
								local456 = local84.aClass1_Sub3_Sub2_Sub4_5;
								local167 = local84.color;
								@Pc(462) String local462 = local84.text;
								if ((this.anInt221 == local84.anInt470 || this.anInt256 == local84.anInt470 || this.anInt300 == local84.anInt470) && local84.anInt487 != 0) {
									local167 = local84.anInt487;
								}
								if (this.method175(local84, 65)) {
									local167 = local84.anInt486;
									if (local84.aString21.length() > 0) {
										local462 = local84.aString21;
									}
								}
								if (local84.optionType == 6 && this.pressedContinueOption) {
									local462 = "Please wait...";
									local167 = local84.color;
								}
								local191 = local94 + local456.height;
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
									local191 += local456.height;
								}
							} else if (local84.anInt472 == 5) {
								@Pc(766) Image24 local766;
								if (this.method175(local84, 65)) {
									local766 = local84.activeImage;
								} else {
									local766 = local84.image;
								}
								if (local766 != null) {
									local766.method322(local94, local89, false);
								}
							} else if (local84.anInt472 == 6) {
								local165 = Draw3D.centerX;
								local167 = Draw3D.centerY;
								Draw3D.centerX = local89 + local84.anInt475 / 2;
								Draw3D.centerY = local94 + local84.height / 2;
								local171 = Draw3D.sin[local84.modelPitch] * local84.modelZoo >> 16;
								local182 = Draw3D.cos[local84.modelPitch] * local84.modelZoo >> 16;
								@Pc(827) boolean local827 = this.method175(local84, 65);
								if (local827) {
									local215 = local84.anInt489;
								} else {
									local215 = local84.anInt488;
								}
								@Pc(846) Model local846;
								if (local215 == -1) {
									local846 = local84.method332(-1, -1, local827);
								} else {
									@Pc(852) SeqType local852 = SeqType.instances[local215];
									local846 = local84.method332(local852.transformIds[local84.anInt468], local852.anIntArray187[local84.anInt468], local827);
								}
								if (local846 != null) {
									local846.method243(0, local84.modelYaw, 0, local84.modelPitch, 0, local171, local182);
								}
								Draw3D.centerX = local165;
								Draw3D.centerY = local167;
							} else if (local84.anInt472 == 7) {
								local456 = local84.aClass1_Sub3_Sub2_Sub4_5;
								local167 = 0;
								for (local171 = 0; local171 < local84.height; local171++) {
									for (local182 = 0; local182 < local84.anInt475; local182++) {
										if (local84.inventorySlotObjId[local167] > 0) {
											@Pc(915) ObjType local915 = ObjType.get(local84.inventorySlotObjId[local167] - 1);
											@Pc(918) String local918 = local915.aString3;
											if (local915.stackable || local84.inventorySlotObjCount[local167] != 1) {
												local918 = local918 + " x" + method101(local84.inventorySlotObjCount[local167], 0);
											}
											local217 = local89 + local182 * (local84.anInt483 + 115);
											local224 = local94 + local171 * (local84.anInt484 + 12);
											if (local84.aBoolean112) {
												local456.method363(local217 + local84.anInt475 / 2, local84.color, local84.aBoolean113, local224, local918, 0);
											} else {
												local456.method367(local217, 6, local224, local918, local84.aBoolean113, local84.color);
											}
										}
										local167++;
									}
								}
							}
						} else if (local84.aBoolean111) {
							Draw2D.method358(local94, local89, local84.color, (byte) 93, local84.anInt475, local84.height);
						} else {
							Draw2D.method359(3, local89, local84.color, local84.height, local94, local84.anInt475);
						}
					}
				}
				Draw2D.method356(local35, local31, local33, 789, local29);
			}
		} catch (@Pc(1014) RuntimeException local1014) {
			signlink.reporterror("44309, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + local1014.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILclient!kb;)V")
	private void method121(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Buffer arg2) {
		try {
			for (@Pc(1) int local1 = 0; local1 < this.entityUpdateCount; local1++) {
				@Pc(8) int local8 = this.entityUpdateIds[local1];
				@Pc(13) PlayerEntity local13 = this.players[local8];
				@Pc(16) int local16 = arg2.method391();
				if ((local16 & 0x80) == 128) {
					local16 += arg2.method391() << 8;
				}
				this.method200(true, local8, local16, arg2, local13);
			}
			this.ingame &= arg0;
		} catch (@Pc(48) RuntimeException local48) {
			signlink.reporterror("96435, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local48.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(II)V")
	private void method122(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = 19 / arg1;
			@Pc(8) int local8 = VarpType.aClass23Array1[arg0].anInt609;
			if (local8 != 0) {
				@Pc(16) int local16 = this.varps[arg0];
				if (local8 == 1) {
					if (local16 == 1) {
						Draw3D.method296(true, 0.9D);
					}
					if (local16 == 2) {
						Draw3D.method296(true, 0.8D);
					}
					if (local16 == 3) {
						Draw3D.method296(true, 0.7D);
					}
					if (local16 == 4) {
						Draw3D.method296(true, 0.6D);
					}
					ObjType.aClass35_5.method529();
					this.redrawTitleBackground = true;
				}
				if (local8 == 3) {
					@Pc(54) boolean local54 = this.midiActive;
					if (local16 == 0) {
						this.method115(0, 0, this.midiActive);
						this.midiActive = true;
					}
					if (local16 == 1) {
						this.method115(0, -400, this.midiActive);
						this.midiActive = true;
					}
					if (local16 == 2) {
						this.method115(0, -800, this.midiActive);
						this.midiActive = true;
					}
					if (local16 == 3) {
						this.method115(0, -1200, this.midiActive);
						this.midiActive = true;
					}
					if (local16 == 4) {
						this.midiActive = false;
					}
					if (this.midiActive != local54) {
						if (this.midiActive) {
							this.method75(false, this.midiCrc, this.currentMidi, this.midiSize);
						} else {
							this.method78(0);
						}
						this.nextMusicDelay = 0;
					}
				}
				if (local8 == 4) {
					if (local16 == 0) {
						this.waveEnabled = true;
						this.method140(0, 0);
					}
					if (local16 == 1) {
						this.waveEnabled = true;
						this.method140(-400, 0);
					}
					if (local16 == 2) {
						this.waveEnabled = true;
						this.method140(-800, 0);
					}
					if (local16 == 3) {
						this.waveEnabled = true;
						this.method140(-1200, 0);
					}
					if (local16 == 4) {
						this.waveEnabled = false;
					}
				}
				if (local8 == 5) {
					this.mouseButtonsOption = local16;
				}
				if (local8 == 6) {
					this.chatEffects = local16;
				}
				if (local8 == 8) {
					this.anInt210 = local16;
					this.redrawChatback = true;
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
			this.ingame &= arg0;
			for (@Pc(7) int local7 = 0; local7 < this.npcCount; local7++) {
				@Pc(14) int local14 = this.npcIds[local7];
				@Pc(19) NpcEntity local19 = this.npcs[local14];
				if (local19 != null) {
					this.method124(local19, (byte) -128, local19.type.size);
				}
			}
		} catch (@Pc(35) RuntimeException local35) {
			signlink.reporterror("3061, " + arg0 + ", " + local35.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;BI)V")
	private void method124(@OriginalArg(0) PathingEntity arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0.x < 128 || arg0.z < 128 || arg0.x >= 13184 || arg0.z >= 13184) {
				arg0.primarySeqId = -1;
				arg0.spotanimId = -1;
				arg0.forceMoveEndCycle = 0;
				arg0.forceMoveStartCycle = 0;
				arg0.x = arg0.pathTileX[0] * 128 + arg0.size * 64;
				arg0.z = arg0.pathTileZ[0] * 128 + arg0.size * 64;
				arg0.pathLength = 0;
			}
			if (arg0 == this.localPlayer && (arg0.x < 1536 || arg0.z < 1536 || arg0.x >= 11776 || arg0.z >= 11776)) {
				arg0.primarySeqId = -1;
				arg0.spotanimId = -1;
				arg0.forceMoveEndCycle = 0;
				arg0.forceMoveStartCycle = 0;
				arg0.x = arg0.pathTileX[0] * 128 + arg0.size * 64;
				arg0.z = arg0.pathTileZ[0] * 128 + arg0.size * 64;
				arg0.pathLength = 0;
			}
			if (arg0.forceMoveEndCycle > loopCycle) {
				this.method125(arg0, -25115);
			} else if (arg0.forceMoveStartCycle >= loopCycle) {
				this.method126(arg0, 0);
			} else {
				this.method127(598, arg0);
			}
			this.method128(arg0, (byte) 117);
			if (arg1 != -128) {
				this.out.method381(11);
			}
			this.method129(this.aBoolean38, arg0);
		} catch (@Pc(161) RuntimeException local161) {
			signlink.reporterror("58564, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local161.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;I)V")
	private void method125(@OriginalArg(0) PathingEntity arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(4) int local4 = arg0.forceMoveEndCycle - loopCycle;
			@Pc(14) int local14 = arg0.forceMoveStartSceneTileX * 128 + arg0.size * 64;
			@Pc(24) int local24 = arg0.forceMoveStartSceneTileZ * 128 + arg0.size * 64;
			arg0.x += (local14 - arg0.x) / local4;
			if (arg1 != -25115) {
				this.anInt151 = this.randomIn.method532();
			}
			arg0.z += (local24 - arg0.z) / local4;
			arg0.seqPathLength = 0;
			if (arg0.forceMoveFaceDirection == 0) {
				arg0.dstYaw = 1024;
			}
			if (arg0.forceMoveFaceDirection == 1) {
				arg0.dstYaw = 1536;
			}
			if (arg0.forceMoveFaceDirection == 2) {
				arg0.dstYaw = 0;
			}
			if (arg0.forceMoveFaceDirection == 3) {
				arg0.dstYaw = 512;
			}
		} catch (@Pc(86) RuntimeException local86) {
			signlink.reporterror("13971, " + arg0 + ", " + arg1 + ", " + local86.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!x;I)V")
	private void method126(@OriginalArg(0) PathingEntity arg0, @OriginalArg(1) int arg1) {
		try {
			this.packetSize += arg1;
			if (arg0.forceMoveStartCycle == loopCycle || arg0.primarySeqId == -1 || arg0.primarySeqDelay != 0 || arg0.primarySeqCycle + 1 > SeqType.instances[arg0.primarySeqId].frameDelay[arg0.primarySeqFrame]) {
				@Pc(35) int local35 = arg0.forceMoveStartCycle - arg0.forceMoveEndCycle;
				@Pc(40) int local40 = loopCycle - arg0.forceMoveEndCycle;
				@Pc(50) int local50 = arg0.forceMoveStartSceneTileX * 128 + arg0.size * 64;
				@Pc(60) int local60 = arg0.forceMoveStartSceneTileZ * 128 + arg0.size * 64;
				@Pc(70) int local70 = arg0.forceMoveEndSceneTileX * 128 + arg0.size * 64;
				@Pc(80) int local80 = arg0.forceMoveEndSceneTileZ * 128 + arg0.size * 64;
				arg0.x = (local50 * (local35 - local40) + local70 * local40) / local35;
				arg0.z = (local60 * (local35 - local40) + local80 * local40) / local35;
			}
			arg0.seqPathLength = 0;
			if (arg0.forceMoveFaceDirection == 0) {
				arg0.dstYaw = 1024;
			}
			if (arg0.forceMoveFaceDirection == 1) {
				arg0.dstYaw = 1536;
			}
			if (arg0.forceMoveFaceDirection == 2) {
				arg0.dstYaw = 0;
			}
			if (arg0.forceMoveFaceDirection == 3) {
				arg0.dstYaw = 512;
			}
			arg0.anInt884 = arg0.dstYaw;
		} catch (@Pc(142) RuntimeException local142) {
			signlink.reporterror("86706, " + arg0 + ", " + arg1 + ", " + local142.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!x;)V")
	private void method127(@OriginalArg(0) int arg0, @OriginalArg(1) PathingEntity arg1) {
		try {
			arg1.secondarySeqId = arg1.seqStandId;
			@Pc(9) int local9 = 56 / arg0;
			if (arg1.pathLength == 0) {
				arg1.seqPathLength = 0;
			} else {
				if (arg1.primarySeqId != -1 && arg1.primarySeqDelay == 0) {
					@Pc(28) SeqType local28 = SeqType.instances[arg1.primarySeqId];
					if (local28.mask == null) {
						arg1.seqPathLength++;
						return;
					}
				}
				@Pc(41) int local41 = arg1.x;
				@Pc(44) int local44 = arg1.z;
				@Pc(59) int local59 = arg1.pathTileX[arg1.pathLength - 1] * 128 + arg1.size * 64;
				@Pc(74) int local74 = arg1.pathTileZ[arg1.pathLength - 1] * 128 + arg1.size * 64;
				if (local59 - local41 <= 256 && local59 - local41 >= -256 && local74 - local44 <= 256 && local74 - local44 >= -256) {
					if (local41 < local59) {
						if (local44 < local74) {
							arg1.dstYaw = 1280;
						} else if (local44 > local74) {
							arg1.dstYaw = 1792;
						} else {
							arg1.dstYaw = 1536;
						}
					} else if (local41 > local59) {
						if (local44 < local74) {
							arg1.dstYaw = 768;
						} else if (local44 > local74) {
							arg1.dstYaw = 256;
						} else {
							arg1.dstYaw = 512;
						}
					} else if (local44 < local74) {
						arg1.dstYaw = 1024;
					} else {
						arg1.dstYaw = 0;
					}
					@Pc(168) int local168 = arg1.dstYaw - arg1.anInt884 & 0x7FF;
					if (local168 > 1024) {
						local168 -= 2048;
					}
					@Pc(175) int local175 = arg1.seqTurnAroundId;
					if (local168 >= -256 && local168 <= 256) {
						local175 = arg1.seqWalkId;
					} else if (local168 >= 256 && local168 < 768) {
						local175 = arg1.seqTurnRightId;
					} else if (local168 >= -768 && local168 <= -256) {
						local175 = arg1.seqTurnLeftId;
					}
					if (local175 == -1) {
						local175 = arg1.seqWalkId;
					}
					arg1.secondarySeqId = local175;
					@Pc(217) int local217 = 4;
					if (arg1.anInt884 != arg1.dstYaw && arg1.targetId == -1) {
						local217 = 2;
					}
					if (arg1.pathLength > 2) {
						local217 = 6;
					}
					if (arg1.pathLength > 3) {
						local217 = 8;
					}
					if (arg1.seqPathLength > 0 && arg1.pathLength > 1) {
						local217 = 8;
						arg1.seqPathLength--;
					}
					if (arg1.pathRunning[arg1.pathLength - 1]) {
						local217 <<= 0x1;
					}
					if (local217 >= 8 && arg1.secondarySeqId == arg1.seqWalkId && arg1.seqRunId != -1) {
						arg1.secondarySeqId = arg1.seqRunId;
					}
					if (local41 < local59) {
						arg1.x += local217;
						if (arg1.x > local59) {
							arg1.x = local59;
						}
					} else if (local41 > local59) {
						arg1.x -= local217;
						if (arg1.x < local59) {
							arg1.x = local59;
						}
					}
					if (local44 < local74) {
						arg1.z += local217;
						if (arg1.z > local74) {
							arg1.z = local74;
						}
					} else if (local44 > local74) {
						arg1.z -= local217;
						if (arg1.z < local74) {
							arg1.z = local74;
						}
					}
					if (arg1.x == local59 && arg1.z == local74) {
						arg1.pathLength--;
					}
				} else {
					arg1.x = local59;
					arg1.z = local74;
				}
			}
		} catch (@Pc(367) RuntimeException local367) {
			signlink.reporterror("70559, " + arg0 + ", " + arg1 + ", " + local367.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;B)V")
	private void method128(@OriginalArg(0) PathingEntity arg0, @OriginalArg(1) byte arg1) {
		try {
			if (arg1 != 117) {
				this.out.method381(89);
			}
			@Pc(30) int local30;
			@Pc(36) int local36;
			if (arg0.targetId != -1 && arg0.targetId < 32768) {
				@Pc(22) NpcEntity local22 = this.npcs[arg0.targetId];
				if (local22 != null) {
					local30 = arg0.x - local22.x;
					local36 = arg0.z - local22.z;
					if (local30 != 0 || local36 != 0) {
						arg0.dstYaw = (int) (Math.atan2((double) local30, (double) local36) * 325.949D) & 0x7FF;
					}
				}
			}
			@Pc(61) int local61;
			if (arg0.targetId >= 32768) {
				local61 = arg0.targetId - 32768;
				if (local61 == this.localPid) {
					local61 = this.LOCAL_PLAYER_INDEX;
				}
				@Pc(73) PlayerEntity local73 = this.players[local61];
				if (local73 != null) {
					local36 = arg0.x - local73.x;
					@Pc(87) int local87 = arg0.z - local73.z;
					if (local36 != 0 || local87 != 0) {
						arg0.dstYaw = (int) (Math.atan2((double) local36, (double) local87) * 325.949D) & 0x7FF;
					}
				}
			}
			if ((arg0.targetTileX != 0 || arg0.targetTileZ != 0) && (arg0.pathLength == 0 || arg0.seqPathLength > 0)) {
				local61 = arg0.x - (arg0.targetTileX - this.sceneBaseTileX - this.sceneBaseTileX) * 64;
				local30 = arg0.z - (arg0.targetTileZ - this.sceneBaseTileZ - this.sceneBaseTileZ) * 64;
				if (local61 != 0 || local30 != 0) {
					arg0.dstYaw = (int) (Math.atan2((double) local61, (double) local30) * 325.949D) & 0x7FF;
				}
				arg0.targetTileX = 0;
				arg0.targetTileZ = 0;
			}
			local61 = arg0.dstYaw - arg0.anInt884 & 0x7FF;
			if (local61 != 0) {
				if (local61 < 32 || local61 > 2016) {
					arg0.anInt884 = arg0.dstYaw;
				} else if (local61 > 1024) {
					arg0.anInt884 -= 32;
				} else {
					arg0.anInt884 += 32;
				}
				arg0.anInt884 &= 0x7FF;
				if (arg0.secondarySeqId == arg0.seqStandId && arg0.anInt884 != arg0.dstYaw) {
					if (arg0.seqTurnId != -1) {
						arg0.secondarySeqId = arg0.seqTurnId;
						return;
					}
					arg0.secondarySeqId = arg0.seqWalkId;
					return;
				}
			}
		} catch (@Pc(235) RuntimeException local235) {
			signlink.reporterror("29025, " + arg0 + ", " + arg1 + ", " + local235.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!x;)V")
	private void method129(@OriginalArg(0) boolean arg0, @OriginalArg(1) PathingEntity arg1) {
		try {
			if (arg0) {
				arg1.aBoolean160 = false;
				@Pc(16) SeqType local16;
				if (arg1.secondarySeqId != -1) {
					local16 = SeqType.instances[arg1.secondarySeqId];
					arg1.anInt906++;
					if (arg1.secondarySeqFrame < local16.frameCount && arg1.anInt906 > local16.frameDelay[arg1.secondarySeqFrame]) {
						arg1.anInt906 = 0;
						arg1.secondarySeqFrame++;
					}
					if (arg1.secondarySeqFrame >= local16.frameCount) {
						arg1.anInt906 = 0;
						arg1.secondarySeqFrame = 0;
					}
				}
				if (arg1.primarySeqId != -1 && arg1.primarySeqDelay == 0) {
					local16 = SeqType.instances[arg1.primarySeqId];
					arg1.primarySeqCycle++;
					while (arg1.primarySeqFrame < local16.frameCount && arg1.primarySeqCycle > local16.frameDelay[arg1.primarySeqFrame]) {
						arg1.primarySeqCycle -= local16.frameDelay[arg1.primarySeqFrame];
						arg1.primarySeqFrame++;
					}
					if (arg1.primarySeqFrame >= local16.frameCount) {
						arg1.primarySeqFrame -= local16.loopFrameCount;
						arg1.primarySeqLoop++;
						if (arg1.primarySeqLoop >= local16.anInt548) {
							arg1.primarySeqId = -1;
						}
						if (arg1.primarySeqFrame < 0 || arg1.primarySeqFrame >= local16.frameCount) {
							arg1.primarySeqId = -1;
						}
					}
					arg1.aBoolean160 = local16.aBoolean126;
				}
				if (arg1.primarySeqDelay > 0) {
					arg1.primarySeqDelay--;
				}
				if (arg1.spotanimId != -1 && loopCycle >= arg1.spotanimLastCycle) {
					if (arg1.spotanimFrame < 0) {
						arg1.spotanimFrame = 0;
					}
					local16 = SpotAnimType.instances[arg1.spotanimId].seq;
					arg1.spotanimCycle++;
					while (arg1.spotanimFrame < local16.frameCount && arg1.spotanimCycle > local16.frameDelay[arg1.spotanimFrame]) {
						arg1.spotanimCycle -= local16.frameDelay[arg1.spotanimFrame];
						arg1.spotanimFrame++;
					}
					if (arg1.spotanimFrame >= local16.frameCount) {
						if (arg1.spotanimFrame < 0 || arg1.spotanimFrame >= local16.frameCount) {
							arg1.spotanimId = -1;
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
			if (this.redrawTitleBackground) {
				this.redrawTitleBackground = false;
				this.areaBackleft1.method464(11, super.graphics, 0, 5193);
				this.areaBackleft2.method464(375, super.graphics, 0, 5193);
				this.areaBackright1.method464(5, super.graphics, 729, 5193);
				this.areaBackright2.method464(231, super.graphics, 752, 5193);
				this.areaBacktop1.method464(0, super.graphics, 0, 5193);
				this.areaBacktop2.method464(0, super.graphics, 561, 5193);
				this.areaBackvmid1.method464(11, super.graphics, 520, 5193);
				this.areaBackvmid2.method464(231, super.graphics, 520, 5193);
				this.areaBackvmid3.method464(375, super.graphics, 501, 5193);
				this.areaBackhmid2.method464(345, super.graphics, 0, 5193);
				this.redrawSidebar = true;
				this.redrawChatback = true;
				this.redrawSideicons = true;
				this.redrawPrivacySettings = true;
				if (this.sceneState != 2) {
					this.areaViewport.method464(11, super.graphics, 8, 5193);
					this.areaMapback.method464(5, super.graphics, 561, 5193);
				}
			}
			if (this.sceneState == 2) {
				this.method86(0);
			}
			if (this.menuVisible && this.menuArea == 1) {
				this.redrawSidebar = true;
			}
			@Pc(152) boolean local152;
			if (this.sidebarInterfaceId != -1) {
				local152 = this.method171(this.sidebarInterfaceId, this.sceneDelta, 623);
				if (local152) {
					this.redrawSidebar = true;
				}
			}
			if (this.selectedArea == 2) {
				this.redrawSidebar = true;
			}
			if (this.objDragArea == 2) {
				this.redrawSidebar = true;
			}
			if (this.redrawSidebar) {
				this.method198((byte) 2);
				this.redrawSidebar = false;
			}
			if (this.chatInterfaceId == -1) {
				this.aClass15_1.scrollPosition = this.anInt185 - this.anInt274 - 77;
				if (super.mouseX > 453 && super.mouseX < 565 && super.mouseY > 350) {
					this.method158(super.mouseX - 22, 0, super.mouseY - 375, this.anInt185, 77, false, 463, 0, this.aClass15_1);
				}
				@Pc(234) int local234 = this.anInt185 - this.aClass15_1.scrollPosition - 77;
				if (local234 < 0) {
					local234 = 0;
				}
				if (local234 > this.anInt185 - 77) {
					local234 = this.anInt185 - 77;
				}
				if (this.anInt274 != local234) {
					this.anInt274 = local234;
					this.redrawChatback = true;
				}
			}
			if (this.chatInterfaceId != -1) {
				local152 = this.method171(this.chatInterfaceId, this.sceneDelta, 623);
				if (local152) {
					this.redrawChatback = true;
				}
			}
			if (this.selectedArea == 3) {
				this.redrawChatback = true;
			}
			if (this.objDragArea == 3) {
				this.redrawChatback = true;
			}
			if (this.modalMessage != null) {
				this.redrawChatback = true;
			}
			if (this.menuVisible && this.menuArea == 2) {
				this.redrawChatback = true;
			}
			if (this.redrawChatback) {
				this.method196(false);
				this.redrawChatback = false;
			}
			if (this.sceneState == 2) {
				this.method104(this.aByte14);
				this.areaMapback.method464(5, super.graphics, 561, 5193);
			}
			if (this.flashingTab != -1) {
				this.redrawSideicons = true;
			}
			if (this.redrawSideicons) {
				if (this.flashingTab != -1 && this.flashingTab == this.selectedTab) {
					this.flashingTab = -1;
					this.out.method380((byte) -34, 175);
					this.out.method381(this.selectedTab);
				}
				this.redrawSideicons = false;
				this.areaBackhmid1.method463((byte) 62);
				this.imageBackhmid1.method350(0, 0, false);
				if (this.sidebarInterfaceId == -1) {
					if (this.tabInterfaceId[this.selectedTab] != -1) {
						if (this.selectedTab == 0) {
							this.imageRedstone1.method350(30, 29, false);
						}
						if (this.selectedTab == 1) {
							this.imageRedstone2.method350(29, 59, false);
						}
						if (this.selectedTab == 2) {
							this.imageRedstone2.method350(29, 87, false);
						}
						if (this.selectedTab == 3) {
							this.imageRedstone3.method350(29, 115, false);
						}
						if (this.selectedTab == 4) {
							this.imageRedstone2h.method350(29, 156, false);
						}
						if (this.selectedTab == 5) {
							this.imageRedstone2h.method350(29, 184, false);
						}
						if (this.selectedTab == 6) {
							this.imageRedstone1h.method350(30, 212, false);
						}
					}
					if (this.tabInterfaceId[0] != -1 && (this.flashingTab != 0 || loopCycle % 20 < 10)) {
						this.imageSideicons[0].method350(34, 35, false);
					}
					if (this.tabInterfaceId[1] != -1 && (this.flashingTab != 1 || loopCycle % 20 < 10)) {
						this.imageSideicons[1].method350(32, 59, false);
					}
					if (this.tabInterfaceId[2] != -1 && (this.flashingTab != 2 || loopCycle % 20 < 10)) {
						this.imageSideicons[2].method350(32, 86, false);
					}
					if (this.tabInterfaceId[3] != -1 && (this.flashingTab != 3 || loopCycle % 20 < 10)) {
						this.imageSideicons[3].method350(33, 121, false);
					}
					if (this.tabInterfaceId[4] != -1 && (this.flashingTab != 4 || loopCycle % 20 < 10)) {
						this.imageSideicons[4].method350(34, 157, false);
					}
					if (this.tabInterfaceId[5] != -1 && (this.flashingTab != 5 || loopCycle % 20 < 10)) {
						this.imageSideicons[5].method350(32, 185, false);
					}
					if (this.tabInterfaceId[6] != -1 && (this.flashingTab != 6 || loopCycle % 20 < 10)) {
						this.imageSideicons[6].method350(34, 212, false);
					}
				}
				this.areaBackhmid1.method464(165, super.graphics, 520, 5193);
				this.areaBackbase2.method463((byte) 62);
				this.imageBackbase2.method350(0, 0, false);
				if (this.sidebarInterfaceId == -1) {
					if (this.tabInterfaceId[this.selectedTab] != -1) {
						if (this.selectedTab == 7) {
							this.imageRedstone1v.method350(0, 49, false);
						}
						if (this.selectedTab == 8) {
							this.imageRedstone2v.method350(0, 81, false);
						}
						if (this.selectedTab == 9) {
							this.imageRedstone2v.method350(0, 108, false);
						}
						if (this.selectedTab == 10) {
							this.imageRedstone3v.method350(1, 136, false);
						}
						if (this.selectedTab == 11) {
							this.imageRedstone2hv.method350(0, 178, false);
						}
						if (this.selectedTab == 12) {
							this.imageRedstone2hv.method350(0, 205, false);
						}
						if (this.selectedTab == 13) {
							this.imageRedstone1hv.method350(0, 233, false);
						}
					}
					if (this.tabInterfaceId[8] != -1 && (this.flashingTab != 8 || loopCycle % 20 < 10)) {
						this.imageSideicons[7].method350(2, 80, false);
					}
					if (this.tabInterfaceId[9] != -1 && (this.flashingTab != 9 || loopCycle % 20 < 10)) {
						this.imageSideicons[8].method350(3, 107, false);
					}
					if (this.tabInterfaceId[10] != -1 && (this.flashingTab != 10 || loopCycle % 20 < 10)) {
						this.imageSideicons[9].method350(4, 142, false);
					}
					if (this.tabInterfaceId[11] != -1 && (this.flashingTab != 11 || loopCycle % 20 < 10)) {
						this.imageSideicons[10].method350(2, 179, false);
					}
					if (this.tabInterfaceId[12] != -1 && (this.flashingTab != 12 || loopCycle % 20 < 10)) {
						this.imageSideicons[11].method350(2, 206, false);
					}
					if (this.tabInterfaceId[13] != -1 && (this.flashingTab != 13 || loopCycle % 20 < 10)) {
						this.imageSideicons[12].method350(2, 230, false);
					}
				}
				this.areaBackbase2.method464(492, super.graphics, 501, 5193);
				this.areaViewport.method463((byte) 62);
			}
			if (this.redrawPrivacySettings) {
				this.redrawPrivacySettings = false;
				this.areaBackbase1.method463((byte) 62);
				this.imageBackbase1.method350(0, 0, false);
				this.fontPlain12.method363(57, 16777215, true, 33, "Public chat", 0);
				if (this.publicChatSetting == 0) {
					this.fontPlain12.method363(57, 65280, true, 46, "On", 0);
				}
				if (this.publicChatSetting == 1) {
					this.fontPlain12.method363(57, 16776960, true, 46, "Friends", 0);
				}
				if (this.publicChatSetting == 2) {
					this.fontPlain12.method363(57, 16711680, true, 46, "Off", 0);
				}
				if (this.publicChatSetting == 3) {
					this.fontPlain12.method363(57, 65535, true, 46, "Hide", 0);
				}
				this.fontPlain12.method363(186, 16777215, true, 33, "Private chat", 0);
				if (this.privateChatSetting == 0) {
					this.fontPlain12.method363(186, 65280, true, 46, "On", 0);
				}
				if (this.privateChatSetting == 1) {
					this.fontPlain12.method363(186, 16776960, true, 46, "Friends", 0);
				}
				if (this.privateChatSetting == 2) {
					this.fontPlain12.method363(186, 16711680, true, 46, "Off", 0);
				}
				this.fontPlain12.method363(326, 16777215, true, 33, "Trade/duel", 0);
				if (this.tradeChatSetting == 0) {
					this.fontPlain12.method363(326, 65280, true, 46, "On", 0);
				}
				if (this.tradeChatSetting == 1) {
					this.fontPlain12.method363(326, 16776960, true, 46, "Friends", 0);
				}
				if (this.tradeChatSetting == 2) {
					this.fontPlain12.method363(326, 16711680, true, 46, "Off", 0);
				}
				this.fontPlain12.method363(462, 16777215, true, 38, "Report abuse", 0);
				this.areaBackbase1.method464(471, super.graphics, 0, 5193);
				this.areaViewport.method463((byte) 62);
			}
			this.sceneDelta = 0;
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
			@Pc(8) int local8 = this.menuAction[arg1];
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
				if (this.chatbackInput) {
					this.chatbackInput = false;
					this.redrawChatback = true;
				}
				@Pc(18) int local18 = this.menuParamB[arg1];
				@Pc(23) int local23 = this.menuParamC[arg1];
				@Pc(28) int local28 = this.menuAction[arg1];
				@Pc(33) int local33 = this.menuParamA[arg1];
				if (local28 >= 2000) {
					local28 -= 2000;
				}
				@Pc(48) String local48;
				@Pc(52) int local52;
				@Pc(69) String local69;
				@Pc(73) int local73;
				if (local28 == 903 || local28 == 363) {
					local48 = this.menuOption[arg1];
					local52 = local48.indexOf("@whi@");
					if (local52 != -1) {
						local48 = local48.substring(local52 + 5).trim();
						local69 = StringUtils.formatName(0, StringUtils.fromBase37(StringUtils.method538(local48), false));
						@Pc(71) boolean local71 = false;
						for (local73 = 0; local73 < this.playerCount; local73++) {
							@Pc(83) PlayerEntity local83 = this.players[this.playerIds[local73]];
							if (local83 != null && local83.name != null && local83.name.equalsIgnoreCase(local69)) {
								this.method168(this.localPlayer.pathTileX[0], 1, false, local83.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local83.pathTileZ[0], 0, 0, 0);
								if (local28 == 903) {
									this.out.method380((byte) -34, 206);
								}
								if (local28 == 363) {
									this.out.method380((byte) -34, 164);
								}
								this.out.method382(this.playerIds[local73]);
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
					this.out.method382(this.anInt284);
					this.out.method382(this.anInt282);
					this.out.method382(this.anInt283);
				}
				if (local28 == 405 || local28 == 38 || local28 == 422 || local28 == 478 || local28 == 347) {
					if (local28 == 478) {
						if ((local18 & 0x3) == 0) {
							anInt143++;
						}
						if (anInt143 >= 90) {
							this.out.method380((byte) -34, 220);
						}
						this.out.method380((byte) -34, 157);
					}
					if (local28 == 347) {
						this.out.method380((byte) -34, 211);
					}
					if (local28 == 422) {
						this.out.method380((byte) -34, 133);
					}
					if (local28 == 405) {
						anInt195 += local33;
						if (anInt195 >= 97) {
							this.out.method380((byte) -34, 30);
							this.out.method384(14953816);
						}
						this.out.method380((byte) -34, 195);
					}
					if (local28 == 38) {
						this.out.method380((byte) -34, 71);
					}
					this.out.method382(local33);
					this.out.method382(local18);
					this.out.method382(local23);
					this.selectedCycle = 0;
					this.anInt258 = local23;
					this.anInt259 = local18;
					this.selectedArea = 2;
					if (IfType.instances[local23].parentId == this.viewportInterfaceID) {
						this.selectedArea = 1;
					}
					if (IfType.instances[local23].parentId == this.chatInterfaceId) {
						this.selectedArea = 3;
					}
				}
				@Pc(345) NpcEntity local345;
				if (local28 == 728 || local28 == 542 || local28 == 6 || local28 == 963 || local28 == 245) {
					local345 = this.npcs[local33];
					if (local345 != null) {
						this.method168(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local345.pathTileZ[0], 0, 0, 0);
						this.crossX = super.mouseClickX;
						this.crossY = super.mouseClickY;
						this.crossMode = 2;
						this.crossCycle = 0;
						if (local28 == 542) {
							this.out.method380((byte) -34, 8);
						}
						if (local28 == 6) {
							if ((local33 & 0x3) == 0) {
								anInt224++;
							}
							if (anInt224 >= 124) {
								this.out.method380((byte) -34, 88);
								this.out.method385(0);
							}
							this.out.method380((byte) -34, 27);
						}
						if (local28 == 963) {
							this.out.method380((byte) -34, 113);
						}
						if (local28 == 728) {
							this.out.method380((byte) -34, 194);
						}
						if (local28 == 245) {
							if ((local33 & 0x3) == 0) {
								anInt188++;
							}
							if (anInt188 >= 85) {
								this.out.method380((byte) -34, 176);
								this.out.method382(39596);
							}
							this.out.method380((byte) -34, 100);
						}
						this.out.method382(local33);
					}
				}
				@Pc(500) boolean local500;
				if (local28 == 217) {
					local500 = this.method168(this.localPlayer.pathTileX[0], 0, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 0, local23, 0, 0, 0);
					if (!local500) {
						this.method168(this.localPlayer.pathTileX[0], 1, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 1, local23, 0, 0, 0);
					}
					this.crossX = super.mouseClickX;
					this.crossY = super.mouseClickY;
					this.crossMode = 2;
					this.crossCycle = 0;
					this.out.method380((byte) -34, 239);
					this.out.method382(local18 + this.sceneBaseTileX);
					this.out.method382(local23 + this.sceneBaseTileZ);
					this.out.method382(local33);
					this.out.method382(this.anInt284);
					this.out.method382(this.anInt282);
					this.out.method382(this.anInt283);
				}
				if (local28 == 1175) {
					@Pc(586) int local586 = local33 >> 14 & 0x7FFF;
					@Pc(589) LocType local589 = LocType.method23(local586);
					if (local589.aByteArray1 == null) {
						local69 = "It's a " + local589.name + ".";
					} else {
						local69 = new String(local589.aByteArray1);
					}
					this.method172(0, local69, (byte) 4, "");
				}
				if (local28 == 285) {
					this.method153(245, local18, local23, local33, true);
				}
				if (local28 == 881) {
					this.out.method380((byte) -34, 130);
					this.out.method382(local33);
					this.out.method382(local18);
					this.out.method382(local23);
					this.out.method382(this.anInt284);
					this.out.method382(this.anInt282);
					this.out.method382(this.anInt283);
					this.selectedCycle = 0;
					this.anInt258 = local23;
					this.anInt259 = local18;
					this.selectedArea = 2;
					if (IfType.instances[local23].parentId == this.viewportInterfaceID) {
						this.selectedArea = 1;
					}
					if (IfType.instances[local23].parentId == this.chatInterfaceId) {
						this.selectedArea = 3;
					}
				}
				if (local28 == 391) {
					this.out.method380((byte) -34, 48);
					this.out.method382(local33);
					this.out.method382(local18);
					this.out.method382(local23);
					this.out.method382(this.anInt292);
					this.selectedCycle = 0;
					this.anInt258 = local23;
					this.anInt259 = local18;
					this.selectedArea = 2;
					if (IfType.instances[local23].parentId == this.viewportInterfaceID) {
						this.selectedArea = 1;
					}
					if (IfType.instances[local23].parentId == this.chatInterfaceId) {
						this.selectedArea = 3;
					}
				}
				if (local28 == 660) {
					if (this.menuVisible) {
						this.scene.method506(4, local23 - 11, local18 - 8);
					} else {
						this.scene.method506(4, super.mouseClickY - 11, super.mouseClickX - 8);
					}
				}
				if (local28 == 188) {
					this.objSelected = 1;
					this.anInt282 = local18;
					this.anInt283 = local23;
					this.anInt284 = local33;
					this.selectedObjName = ObjType.get(local33).aString3;
					this.spellSelected = 0;
				} else {
					if (local28 == 44 && !this.pressedContinueOption) {
						this.out.method380((byte) -34, 235);
						this.out.method382(local23);
						this.pressedContinueOption = true;
					}
					@Pc(830) ObjType local830;
					@Pc(845) String local845;
					if (local28 == 1773) {
						local830 = ObjType.get(local33);
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
						local345 = this.npcs[local33];
						if (local345 != null) {
							this.method168(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local345.pathTileZ[0], 0, 0, 0);
							this.crossX = super.mouseClickX;
							this.crossY = super.mouseClickY;
							this.crossMode = 2;
							this.crossCycle = 0;
							this.out.method380((byte) -34, 202);
							this.out.method382(local33);
							this.out.method382(this.anInt284);
							this.out.method382(this.anInt282);
							this.out.method382(this.anInt283);
						}
					}
					@Pc(969) PlayerEntity local969;
					if (local28 == 1373 || local28 == 1544 || local28 == 151 || local28 == 1101) {
						local969 = this.players[local33];
						if (local969 != null) {
							this.method168(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local969.pathTileZ[0], 0, 0, 0);
							this.crossX = super.mouseClickX;
							this.crossY = super.mouseClickY;
							this.crossMode = 2;
							this.crossCycle = 0;
							if (local28 == 1101) {
								this.out.method380((byte) -34, 164);
							}
							if (local28 == 151) {
								anInt237++;
								if (anInt237 >= 90) {
									this.out.method380((byte) -34, 2);
									this.out.method382(31114);
								}
								this.out.method380((byte) -34, 53);
							}
							if (local28 == 1373) {
								this.out.method380((byte) -34, 206);
							}
							if (local28 == 1544) {
								this.out.method380((byte) -34, 185);
							}
							this.out.method382(local33);
						}
					}
					if (local28 == 265) {
						local345 = this.npcs[local33];
						if (local345 != null) {
							this.method168(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local345.pathTileZ[0], 0, 0, 0);
							this.crossX = super.mouseClickX;
							this.crossY = super.mouseClickY;
							this.crossMode = 2;
							this.crossCycle = 0;
							this.out.method380((byte) -34, 134);
							this.out.method382(local33);
							this.out.method382(this.anInt292);
						}
					}
					@Pc(1156) long local1156;
					if (local28 == 679) {
						local48 = this.menuOption[arg1];
						local52 = local48.indexOf("@whi@");
						if (local52 != -1) {
							local1156 = StringUtils.method538(local48.substring(local52 + 5).trim());
							local73 = -1;
							for (@Pc(1160) int local1160 = 0; local1160 < this.friendCount; local1160++) {
								if (this.friendName37[local1160] == local1156) {
									local73 = local1160;
									break;
								}
							}
							if (local73 != -1 && this.friendWorld[local73] > 0) {
								this.redrawChatback = true;
								this.chatbackInput = false;
								this.showSocialInput = true;
								this.socialInput = "";
								this.socialAction = 3;
								this.aLong8 = this.friendName37[local73];
								this.socialMessage = "Enter message to send to " + this.friendName[local73];
							}
						}
					}
					if (local28 == 55 && this.method153(9, local18, local23, local33, true)) {
						this.out.method382(this.anInt292);
					}
					if (local28 == 224 || local28 == 993 || local28 == 99 || local28 == 746 || local28 == 877) {
						local500 = this.method168(this.localPlayer.pathTileX[0], 0, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 0, local23, 0, 0, 0);
						if (!local500) {
							this.method168(this.localPlayer.pathTileX[0], 1, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 1, local23, 0, 0, 0);
						}
						this.crossX = super.mouseClickX;
						this.crossY = super.mouseClickY;
						this.crossMode = 2;
						this.crossCycle = 0;
						if (local28 == 224) {
							this.out.method380((byte) -34, 140);
						}
						if (local28 == 746) {
							this.out.method380((byte) -34, 178);
						}
						if (local28 == 877) {
							this.out.method380((byte) -34, 247);
						}
						if (local28 == 99) {
							this.out.method380((byte) -34, 200);
						}
						if (local28 == 993) {
							this.out.method380((byte) -34, 40);
						}
						this.out.method382(local18 + this.sceneBaseTileX);
						this.out.method382(local23 + this.sceneBaseTileZ);
						this.out.method382(local33);
					}
					if (local28 == 1607) {
						local345 = this.npcs[local33];
						if (local345 != null) {
							if (local345.type.aByteArray2 == null) {
								local845 = "It's a " + local345.type.aString2 + ".";
							} else {
								local845 = new String(local345.type.aByteArray2);
							}
							this.method172(0, local845, (byte) 4, "");
						}
					}
					if (local28 == 504) {
						this.method153(172, local18, local23, local33, true);
					}
					@Pc(1429) IfType local1429;
					if (local28 == 930) {
						local1429 = IfType.instances[local23];
						this.spellSelected = 1;
						this.anInt292 = local23;
						this.anInt293 = local1429.anInt493;
						this.objSelected = 0;
						local845 = local1429.aString22;
						if (local845.indexOf(" ") != -1) {
							local845 = local845.substring(0, local845.indexOf(" "));
						}
						local69 = local1429.aString22;
						if (local69.indexOf(" ") != -1) {
							local69 = local69.substring(local69.indexOf(" ") + 1);
						}
						this.spellCaption = local845 + " " + local1429.aString23 + " " + local69;
						if (this.anInt293 == 16) {
							this.redrawSidebar = true;
							this.selectedTab = 3;
							this.redrawSideicons = true;
						}
					} else {
						if (local28 == 951) {
							local1429 = IfType.instances[local23];
							@Pc(1513) boolean local1513 = true;
							if (local1429.contentType > 0) {
								local1513 = this.method142(false, local1429);
							}
							if (local1513) {
								this.out.method380((byte) -34, 155);
								this.out.method382(local23);
							}
						}
						if (local28 == 602 || local28 == 596 || local28 == 22 || local28 == 892 || local28 == 415) {
							if (local28 == 22) {
								this.out.method380((byte) -34, 212);
							}
							if (local28 == 415) {
								if ((local23 & 0x3) == 0) {
									anInt254++;
								}
								if (anInt254 >= 55) {
									this.out.method380((byte) -34, 17);
									this.out.method385(0);
								}
								this.out.method380((byte) -34, 6);
							}
							if (local28 == 602) {
								this.out.method380((byte) -34, 31);
							}
							if (local28 == 892) {
								if ((local18 & 0x3) == 0) {
									anInt229++;
								}
								if (anInt229 >= 130) {
									this.out.method380((byte) -34, 238);
									this.out.method381(177);
								}
								this.out.method380((byte) -34, 38);
							}
							if (local28 == 596) {
								this.out.method380((byte) -34, 59);
							}
							this.out.method382(local33);
							this.out.method382(local18);
							this.out.method382(local23);
							this.selectedCycle = 0;
							this.anInt258 = local23;
							this.anInt259 = local18;
							this.selectedArea = 2;
							if (IfType.instances[local23].parentId == this.viewportInterfaceID) {
								this.selectedArea = 1;
							}
							if (IfType.instances[local23].parentId == this.chatInterfaceId) {
								this.selectedArea = 3;
							}
						}
						if (local28 == 581) {
							if ((local33 & 0x3) == 0) {
								anInt175++;
							}
							if (anInt175 >= 99) {
								this.out.method380((byte) -34, 7);
								this.out.method385(0);
							}
							this.method153(97, local18, local23, local33, true);
						}
						if (local28 == 965) {
							local500 = this.method168(this.localPlayer.pathTileX[0], 0, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 0, local23, 0, 0, 0);
							if (!local500) {
								this.method168(this.localPlayer.pathTileX[0], 1, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 1, local23, 0, 0, 0);
							}
							this.crossX = super.mouseClickX;
							this.crossY = super.mouseClickY;
							this.crossMode = 2;
							this.crossCycle = 0;
							this.out.method380((byte) -34, 138);
							this.out.method382(local18 + this.sceneBaseTileX);
							this.out.method382(local23 + this.sceneBaseTileZ);
							this.out.method382(local33);
							this.out.method382(this.anInt292);
						}
						if (local28 == 1501) {
							anInt220 += this.sceneBaseTileZ;
							if (anInt220 >= 92) {
								this.out.method380((byte) -34, 66);
								this.out.method385(0);
							}
							this.method153(116, local18, local23, local33, true);
						}
						if (local28 == 364) {
							this.method153(96, local18, local23, local33, true);
						}
						if (local28 == 1102) {
							local830 = ObjType.get(local33);
							if (local830.aByteArray3 == null) {
								local845 = "It's a " + local830.aString3 + ".";
							} else {
								local845 = new String(local830.aByteArray3);
							}
							this.method172(0, local845, (byte) 4, "");
						}
						if (local28 == 960) {
							this.out.method380((byte) -34, 155);
							this.out.method382(local23);
							local1429 = IfType.instances[local23];
							if (local1429.scripts != null && local1429.scripts[0][0] == 5) {
								local52 = local1429.scripts[0][1];
								if (this.varps[local52] != local1429.anIntArray152[0]) {
									this.varps[local52] = local1429.anIntArray152[0];
									this.method122(local52, 49);
									this.redrawSidebar = true;
								}
							}
						}
						if (local28 == 34) {
							local48 = this.menuOption[arg1];
							local52 = local48.indexOf("@whi@");
							if (local52 != -1) {
								this.method77((byte) -60);
								this.reportAbuseInput = local48.substring(local52 + 5).trim();
								this.reportAbuseMuteOption = false;
								for (@Pc(1957) int local1957 = 0; local1957 < IfType.instances.length; local1957++) {
									if (IfType.instances[local1957] != null && IfType.instances[local1957].contentType == 600) {
										this.reportAbuseInterfaceID = this.viewportInterfaceID = IfType.instances[local1957].parentId;
										break;
									}
								}
							}
						}
						if (local28 == 947) {
							this.method77((byte) -60);
						}
						if (local28 == 367) {
							local969 = this.players[local33];
							if (local969 != null) {
								this.method168(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local969.pathTileZ[0], 0, 0, 0);
								this.crossX = super.mouseClickX;
								this.crossY = super.mouseClickY;
								this.crossMode = 2;
								this.crossCycle = 0;
								this.out.method380((byte) -34, 248);
								this.out.method382(local33);
								this.out.method382(this.anInt284);
								this.out.method382(this.anInt282);
								this.out.method382(this.anInt283);
							}
						}
						if (local28 == 465) {
							this.out.method380((byte) -34, 155);
							this.out.method382(local23);
							local1429 = IfType.instances[local23];
							if (local1429.scripts != null && local1429.scripts[0][0] == 5) {
								local52 = local1429.scripts[0][1];
								this.varps[local52] = 1 - this.varps[local52];
								this.method122(local52, 49);
								this.redrawSidebar = true;
							}
						}
						if (local28 == 406 || local28 == 436 || local28 == 557 || local28 == 556) {
							local48 = this.menuOption[arg1];
							local52 = local48.indexOf("@whi@");
							if (local52 != -1) {
								local1156 = StringUtils.method538(local48.substring(local52 + 5).trim());
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
							local969 = this.players[local33];
							if (local969 != null) {
								this.method168(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local969.pathTileZ[0], 0, 0, 0);
								this.crossX = super.mouseClickX;
								this.crossY = super.mouseClickY;
								this.crossMode = 2;
								this.crossCycle = 0;
								this.out.method380((byte) -34, 177);
								this.out.method382(local33);
								this.out.method382(this.anInt292);
							}
						}
						this.objSelected = 0;
						if (arg0 != 6412) {
							this.method67();
						}
						this.spellSelected = 0;
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
				this.out.method381(216);
			}
			if (signlink.mainapp == null) {
				return super.frame == null ? super.getDocumentBase().getHost().toLowerCase() : "runescape.com";
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
			@Pc(2) int local2 = this.menuX;
			@Pc(5) int local5 = this.menuY;
			@Pc(8) int local8 = this.menuWidth;
			@Pc(11) int local11 = this.menuHeight;
			@Pc(13) int local13 = 6116423;
			Draw2D.method358(local5, local2, local13, (byte) 93, local8, local11);
			Draw2D.method358(local5 + 1, local2 + 1, 0, (byte) 93, local8 - 2, 16);
			Draw2D.method359(3, local2 + 1, 0, local11 - 19, local5 + 18, local8 - 2);
			this.fontBold12.method365(local2 + 3, local5 + 14, false, local13, "Choose Option");
			@Pc(63) int local63 = super.mouseX;
			@Pc(66) int local66 = super.mouseY;
			if (this.menuArea == 0) {
				local63 -= 8;
				local66 -= 11;
			}
			if (this.menuArea == 1) {
				local63 -= 562;
				local66 -= 231;
			}
			if (this.menuArea == 2) {
				local63 -= 22;
				local66 -= 375;
			}
			for (@Pc(85) int local85 = 0; local85 < this.menuSize; local85++) {
				@Pc(100) int local100 = local5 + (this.menuSize - 1 - local85) * 15 + 31;
				@Pc(102) int local102 = 16777215;
				if (local63 > local2 && local63 < local2 + local8 && local66 > local100 - 13 && local66 < local100 + 3) {
					local102 = 16776960;
				}
				this.fontBold12.method367(local2 + 3, 6, local100, this.menuOption[local85], true, local102);
			}
			if (arg0 >= 0) {
				this.packetType = this.in.method391();
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
				if (this.systemUpdateTimer != 0) {
					local5 = 1;
				}
				for (@Pc(12) int local12 = 0; local12 < 100; local12++) {
					if (this.messageText[local12] != null) {
						@Pc(24) int local24 = this.messageType[local12];
						if ((local24 == 3 || local24 == 7) && (local24 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.method199(-20, this.messageSender[local12]))) {
							@Pc(54) int local54 = 329 - local5 * 13;
							if (super.mouseX > 8 && super.mouseX < 520 && arg2 - 11 > local54 - 10 && arg2 - 11 <= local54 + 3) {
								if (this.rights) {
									this.menuOption[this.menuSize] = "Report abuse @whi@" + this.messageSender[local12];
									this.menuAction[this.menuSize] = 2034;
									this.menuSize++;
								}
								this.menuOption[this.menuSize] = "Add ignore @whi@" + this.messageSender[local12];
								this.menuAction[this.menuSize] = 2436;
								this.menuSize++;
								this.menuOption[this.menuSize] = "Add friend @whi@" + this.messageSender[local12];
								this.menuAction[this.menuSize] = 2406;
								this.menuSize++;
							}
							local5++;
							if (local5 >= 5) {
								return;
							}
						}
						if ((local24 == 5 || local24 == 6) && this.privateChatSetting < 2) {
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
	private void method137(@OriginalArg(0) int arg0, @OriginalArg(1) IfType arg1) {
		try {
			@Pc(4) int local4 = arg1.contentType;
			if (arg0 != 0) {
				anInt268 = -68;
			}
			if (local4 >= 1 && local4 <= 100) {
				local4--;
				if (local4 >= this.friendCount) {
					arg1.text = "";
					arg1.optionType = 0;
				} else {
					arg1.text = this.friendName[local4];
					arg1.optionType = 1;
				}
			} else if (local4 >= 101 && local4 <= 200) {
				local4 -= 101;
				if (local4 >= this.friendCount) {
					arg1.text = "";
					arg1.optionType = 0;
				} else {
					if (this.friendWorld[local4] == 0) {
						arg1.text = "@red@Offline";
					} else if (this.friendWorld[local4] == nodeId) {
						arg1.text = "@gre@World-" + (this.friendWorld[local4] - 9);
					} else {
						arg1.text = "@yel@World-" + (this.friendWorld[local4] - 9);
					}
					arg1.optionType = 1;
				}
			} else if (local4 == 203) {
				arg1.scrollableHeight = this.friendCount * 15 + 20;
				if (arg1.scrollableHeight <= arg1.height) {
					arg1.scrollableHeight = arg1.height + 1;
				}
			} else if (local4 >= 401 && local4 <= 500) {
				local4 -= 401;
				if (local4 >= this.ignoreCount) {
					arg1.text = "";
					arg1.optionType = 0;
				} else {
					arg1.text = StringUtils.formatName(0, StringUtils.fromBase37(this.ignoreName37[local4], false));
					arg1.optionType = 1;
				}
			} else if (local4 == 503) {
				arg1.scrollableHeight = this.ignoreCount * 15 + 20;
				if (arg1.scrollableHeight <= arg1.height) {
					arg1.scrollableHeight = arg1.height + 1;
				}
			} else if (local4 == 327) {
				arg1.modelPitch = 150;
				arg1.modelYaw = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;
				if (this.updateDesignModel) {
					this.updateDesignModel = false;
					@Pc(209) Model[] local209 = new Model[7];
					@Pc(211) int local211 = 0;
					for (@Pc(213) int local213 = 0; local213 < 7; local213++) {
						@Pc(220) int local220 = this.designIdentikits[local213];
						if (local220 >= 0) {
							local209[local211++] = IdkType.instances[local220].method306();
						}
					}
					@Pc(241) Model local241 = new Model(0, local209, local211);
					for (@Pc(243) int local243 = 0; local243 < 5; local243++) {
						if (this.designColors[local243] != 0) {
							local241.recolor(PlayerEntity.designPartColor[local243][0], PlayerEntity.designPartColor[local243][this.designColors[local243]]);
							if (local243 == 1) {
								local241.recolor(PlayerEntity.designHairColor[0], PlayerEntity.designHairColor[this.designColors[local243]]);
							}
						}
					}
					local241.createLabelReferences(4);
					local241.applyTransform(-16599, SeqType.instances[this.localPlayer.seqStandId].transformIds[0]);
					local241.calculateNormals(64, 850, -30, -50, -30, true);
					arg1.aClass1_Sub3_Sub1_2 = local241;
				}
			} else if (local4 == 324) {
				if (this.genderButtonImage0 == null) {
					this.genderButtonImage0 = arg1.image;
					this.genderButtonImage1 = arg1.activeImage;
				}
				if (this.designGenderMale) {
					arg1.image = this.genderButtonImage1;
				} else {
					arg1.image = this.genderButtonImage0;
				}
			} else if (local4 == 325) {
				if (this.genderButtonImage0 == null) {
					this.genderButtonImage0 = arg1.image;
					this.genderButtonImage1 = arg1.activeImage;
				}
				if (this.designGenderMale) {
					arg1.image = this.genderButtonImage0;
				} else {
					arg1.image = this.genderButtonImage1;
				}
			} else if (local4 == 600) {
				arg1.text = this.reportAbuseInput;
				if (loopCycle % 20 < 10) {
					arg1.text = arg1.text + "|";
				} else {
					arg1.text = arg1.text + " ";
				}
			} else {
				if (local4 == 613) {
					if (!this.rights) {
						arg1.text = "";
					} else if (this.reportAbuseMuteOption) {
						arg1.color = 16711680;
						arg1.text = "Moderator option: Mute player for 48 hours: <ON>";
					} else {
						arg1.color = 16777215;
						arg1.text = "Moderator option: Mute player for 48 hours: <OFF>";
					}
				}
				@Pc(441) String local441;
				if (local4 == 650 || local4 == 655) {
					if (this.lastAddress == 0) {
						arg1.text = "";
					} else {
						if (this.daysSinceLastLogin == 0) {
							local441 = "earlier today";
						} else if (this.daysSinceLastLogin == 1) {
							local441 = "yesterday";
						} else {
							local441 = this.daysSinceLastLogin + " days ago";
						}
						arg1.text = "You last logged in " + local441 + " from: " + signlink.dns;
					}
				}
				if (local4 == 651) {
					if (this.unreadMessages == 0) {
						arg1.text = "0 unread messages";
						arg1.color = 16776960;
					}
					if (this.unreadMessages == 1) {
						arg1.text = "1 unread message";
						arg1.color = 65280;
					}
					if (this.unreadMessages > 1) {
						arg1.text = this.unreadMessages + " unread messages";
						arg1.color = 65280;
					}
				}
				if (local4 == 652) {
					if (this.daysSinceRecoveriesChanged == 201) {
						arg1.text = "";
					} else if (this.daysSinceRecoveriesChanged == 200) {
						arg1.text = "You have not yet set any password recovery questions.";
					} else {
						if (this.daysSinceRecoveriesChanged == 0) {
							local441 = "Earlier today";
						} else if (this.daysSinceRecoveriesChanged == 1) {
							local441 = "Yesterday";
						} else {
							local441 = this.daysSinceRecoveriesChanged + " days ago";
						}
						arg1.text = local441 + " you changed your recovery questions";
					}
				}
				if (local4 == 653) {
					if (this.daysSinceRecoveriesChanged == 201) {
						arg1.text = "";
					} else if (this.daysSinceRecoveriesChanged == 200) {
						arg1.text = "We strongly recommend you do so now to secure your account.";
					} else {
						arg1.text = "If you do not remember making this change then cancel it immediately";
					}
				}
				if (local4 == 654) {
					if (this.daysSinceRecoveriesChanged == 201) {
						arg1.text = "";
					} else if (this.daysSinceRecoveriesChanged == 200) {
						arg1.text = "Do this from the 'account management' area on our front webpage";
					} else {
						arg1.text = "Do this from the 'account management' area on our front webpage";
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
				this.packetType = -1;
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
				this.out.method381(77);
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
				this.levelObjStacks = null;
			}
			signlink.wavevol = arg0;
		} catch (@Pc(8) RuntimeException local8) {
			signlink.reporterror("63786, " + arg0 + ", " + arg1 + ", " + local8.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!kb;I)V")
	private void method141(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0) {
				this.method67();
			}
			while (arg1.bitPosition + 21 < arg2 * 8) {
				@Pc(16) int local16 = arg1.method402(9, 13);
				if (local16 == 8191) {
					break;
				}
				if (this.npcs[local16] == null) {
					this.npcs[local16] = new NpcEntity();
				}
				@Pc(36) NpcEntity local36 = this.npcs[local16];
				this.npcIds[this.npcCount++] = local16;
				local36.cycle = loopCycle;
				local36.type = NpcType.method32(arg1.method402(9, 11));
				local36.size = local36.type.size;
				local36.seqWalkId = local36.type.seqWalkId;
				local36.seqTurnAroundId = local36.type.seqTurnAroundId;
				local36.seqTurnLeftId = local36.type.seqTurnLeftId;
				local36.seqTurnRightId = local36.type.seqTurnRightId;
				local36.seqStandId = local36.type.seqStandId;
				@Pc(92) int local92 = arg1.method402(9, 5);
				if (local92 > 15) {
					local92 -= 32;
				}
				@Pc(101) int local101 = arg1.method402(9, 5);
				if (local101 > 15) {
					local101 -= 32;
				}
				local36.move(false, false, this.localPlayer.pathTileX[0] + local92, this.localPlayer.pathTileZ[0] + local101);
				@Pc(128) int local128 = arg1.method402(9, 1);
				if (local128 == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = local16;
				}
			}
			arg1.method403(this.anInt197);
		} catch (@Pc(150) RuntimeException local150) {
			signlink.reporterror("14259, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local150.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!hc;)Z")
	private boolean method142(@OriginalArg(0) boolean arg0, @OriginalArg(1) IfType arg1) {
		try {
			@Pc(4) int local4 = arg1.contentType;
			if (arg0) {
				this.method67();
			}
			if (local4 == 201) {
				this.redrawChatback = true;
				this.chatbackInput = false;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialAction = 1;
				this.socialMessage = "Enter name of friend to add to list";
			}
			if (local4 == 202) {
				this.redrawChatback = true;
				this.chatbackInput = false;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialAction = 2;
				this.socialMessage = "Enter name of friend to delete from list";
			}
			if (local4 == 205) {
				this.idleTimeout = 250;
				return true;
			}
			if (local4 == 501) {
				this.redrawChatback = true;
				this.chatbackInput = false;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialAction = 4;
				this.socialMessage = "Enter name of player to add to list";
			}
			if (local4 == 502) {
				this.redrawChatback = true;
				this.chatbackInput = false;
				this.showSocialInput = true;
				this.socialInput = "";
				this.socialAction = 5;
				this.socialMessage = "Enter name of player to delete from list";
			}
			@Pc(112) int local112;
			@Pc(116) int local116;
			@Pc(121) int local121;
			if (local4 >= 300 && local4 <= 313) {
				local112 = (local4 - 300) / 2;
				local116 = local4 & 0x1;
				local121 = this.designIdentikits[local112];
				if (local121 != -1) {
					while (true) {
						if (local116 == 0) {
							local121--;
							if (local121 < 0) {
								local121 = IdkType.count - 1;
							}
						}
						if (local116 == 1) {
							local121++;
							if (local121 >= IdkType.count) {
								local121 = 0;
							}
						}
						if (!IdkType.instances[local121].selectable && IdkType.instances[local121].type == local112 + (this.designGenderMale ? 0 : 7)) {
							this.designIdentikits[local112] = local121;
							this.updateDesignModel = true;
							break;
						}
					}
				}
			}
			if (local4 >= 314 && local4 <= 323) {
				local112 = (local4 - 314) / 2;
				local116 = local4 & 0x1;
				local121 = this.designColors[local112];
				if (local116 == 0) {
					local121--;
					if (local121 < 0) {
						local121 = PlayerEntity.designPartColor[local112].length - 1;
					}
				}
				if (local116 == 1) {
					local121++;
					if (local121 >= PlayerEntity.designPartColor[local112].length) {
						local121 = 0;
					}
				}
				this.designColors[local112] = local121;
				this.updateDesignModel = true;
			}
			if (local4 == 324 && !this.designGenderMale) {
				this.designGenderMale = true;
				this.method112((byte) -6);
			}
			if (local4 == 325 && this.designGenderMale) {
				this.designGenderMale = false;
				this.method112((byte) -6);
			}
			if (local4 == 326) {
				this.out.method380((byte) -34, 52);
				this.out.method381(this.designGenderMale ? 0 : 1);
				for (local112 = 0; local112 < 7; local112++) {
					this.out.method381(this.designIdentikits[local112]);
				}
				for (local116 = 0; local116 < 5; local116++) {
					this.out.method381(this.designColors[local116]);
				}
				return true;
			}
			if (local4 == 613) {
				this.reportAbuseMuteOption = !this.reportAbuseMuteOption;
			}
			if (local4 >= 601 && local4 <= 612) {
				this.method77((byte) -60);
				if (this.reportAbuseInput.length() > 0) {
					this.out.method380((byte) -34, 190);
					this.out.method387(true, StringUtils.method538(this.reportAbuseInput));
					this.out.method381(local4 - 601);
					this.out.method381(this.reportAbuseMuteOption ? 1 : 0);
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
		if (!lowMemory) {
			this.aBoolean40 = true;
			this.aBoolean41 = true;
			this.method73(this, 2);
			this.method75(false, 12345678, "scape_main", 40000);
		}
		if (aBoolean69) {
			this.errorStarted = true;
			return;
		}
		aBoolean69 = true;
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
			this.errorHost = true;
			return;
		}
		try {
			@Pc(94) int local94 = 5;
			this.archiveChecksum[8] = 0;
			while (this.archiveChecksum[8] == 0) {
				this.method74(true, "Connecting to fileserver", 10);
				try {
					@Pc(119) DataInputStream local119 = this.method155("crc" + (int) (Math.random() * 9.9999999E7D));
					@Pc(126) Buffer local126 = new Buffer(363, new byte[36]);
					local119.readFully(local126.data, 0, 36);
					for (@Pc(134) int local134 = 0; local134 < 9; local134++) {
						this.archiveChecksum[local134] = local126.method396();
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
			this.archiveTitle = this.method98("title screen", this.archiveChecksum[1], "title", 10, 0);
			this.fontPlain11 = new BitmapFont(this.archiveTitle, "p11", 530);
			this.fontPlain12 = new BitmapFont(this.archiveTitle, "p12", 530);
			this.fontBold12 = new BitmapFont(this.archiveTitle, "b12", 530);
			this.fontQuill8 = new BitmapFont(this.archiveTitle, "q8", 530);
			this.method189((byte) 5);
			this.method109(0);
			@Pc(255) FileArchive local255 = this.method98("config", this.archiveChecksum[2], "config", 15, 0);
			@Pc(266) FileArchive local266 = this.method98("interface", this.archiveChecksum[3], "interface", 20, 0);
			@Pc(277) FileArchive local277 = this.method98("2d graphics", this.archiveChecksum[4], "media", 30, 0);
			@Pc(288) FileArchive local288 = this.method98("3d graphics", this.archiveChecksum[5], "models", 40, 0);
			@Pc(299) FileArchive local299 = this.method98("textures", this.archiveChecksum[6], "textures", 60, 0);
			@Pc(310) FileArchive local310 = this.method98("chat system", this.archiveChecksum[7], "wordenc", 65, 0);
			@Pc(321) FileArchive local321 = this.method98("sound effects", this.archiveChecksum[8], "sounds", 70, 0);
			this.levelTileFlags = new byte[4][104][104];
			this.levelHeightmap = new int[4][105][105];
			this.scene = new Scene(415, this.levelHeightmap, 104, 4, 104);
			for (@Pc(346) int local346 = 0; local346 < 4; local346++) {
				this.levelCollisionMap[local346] = new CollisionMap(104, -708, 104);
			}
			this.imageMinimap = new Image24(512, 512);
			this.method74(true, "Unpacking media", 75);
			this.imageInvback = new Image8(local277, "invback", 0);
			this.imageChatback = new Image8(local277, "chatback", 0);
			this.imageMapback = new Image8(local277, "mapback", 0);
			this.imageBackbase1 = new Image8(local277, "backbase1", 0);
			this.imageBackbase2 = new Image8(local277, "backbase2", 0);
			this.imageBackhmid1 = new Image8(local277, "backhmid1", 0);
			for (@Pc(424) int local424 = 0; local424 < 13; local424++) {
				this.imageSideicons[local424] = new Image8(local277, "sideicons", local424);
			}
			this.imageCompass = new Image24(local277, "compass", 0);
			@Pc(450) int local450;
			try {
				for (local450 = 0; local450 < 50; local450++) {
					this.imageMapscene[local450] = new Image8(local277, "mapscene", local450);
				}
			} catch (@Pc(468) Exception local468) {
			}
			try {
				for (local450 = 0; local450 < 50; local450++) {
					this.imageMapfunction[local450] = new Image24(local277, "mapfunction", local450);
				}
			} catch (@Pc(488) Exception local488) {
			}
			try {
				for (local450 = 0; local450 < 20; local450++) {
					this.imageHitmarks[local450] = new Image24(local277, "hitmarks", local450);
				}
			} catch (@Pc(508) Exception local508) {
			}
			try {
				for (local450 = 0; local450 < 20; local450++) {
					this.imageHeadicons[local450] = new Image24(local277, "headicons", local450);
				}
			} catch (@Pc(528) Exception local528) {
			}
			this.imageMapflag = new Image24(local277, "mapflag", 0);
			for (local450 = 0; local450 < 8; local450++) {
				this.imageCrosses[local450] = new Image24(local277, "cross", local450);
			}
			this.imageMapdot0 = new Image24(local277, "mapdots", 0);
			this.imageMapdot1 = new Image24(local277, "mapdots", 1);
			this.imageMapdot2 = new Image24(local277, "mapdots", 2);
			this.imageMapdot3 = new Image24(local277, "mapdots", 3);
			this.imageScrollbar0 = new Image8(local277, "scrollbar", 0);
			this.imageScrollbar1 = new Image8(local277, "scrollbar", 1);
			this.imageRedstone1 = new Image8(local277, "redstone1", 0);
			this.imageRedstone2 = new Image8(local277, "redstone2", 0);
			this.imageRedstone3 = new Image8(local277, "redstone3", 0);
			this.imageRedstone1h = new Image8(local277, "redstone1", 0);
			this.imageRedstone1h.method347(-725);
			this.imageRedstone2h = new Image8(local277, "redstone2", 0);
			this.imageRedstone2h.method347(-725);
			this.imageRedstone1v = new Image8(local277, "redstone1", 0);
			this.imageRedstone1v.method348((byte) -74);
			this.imageRedstone2v = new Image8(local277, "redstone2", 0);
			this.imageRedstone2v.method348((byte) -74);
			this.imageRedstone3v = new Image8(local277, "redstone3", 0);
			this.imageRedstone3v.method348((byte) -74);
			this.imageRedstone1hv = new Image8(local277, "redstone1", 0);
			this.imageRedstone1hv.method347(-725);
			this.imageRedstone1hv.method348((byte) -74);
			this.imageRedstone2hv = new Image8(local277, "redstone2", 0);
			this.imageRedstone2hv.method347(-725);
			this.imageRedstone2hv.method348((byte) -74);
			@Pc(725) Image24 local725 = new Image24(local277, "backleft1", 0);
			this.areaBackleft1 = new DrawArea(this.method72(aByte16), local725.width, 299, local725.height);
			local725.method320(34676, 0, 0);
			@Pc(750) Image24 local750 = new Image24(local277, "backleft2", 0);
			this.areaBackleft2 = new DrawArea(this.method72(aByte16), local750.width, 299, local750.height);
			local750.method320(34676, 0, 0);
			@Pc(775) Image24 local775 = new Image24(local277, "backright1", 0);
			this.areaBackright1 = new DrawArea(this.method72(aByte16), local775.width, 299, local775.height);
			local775.method320(34676, 0, 0);
			@Pc(800) Image24 local800 = new Image24(local277, "backright2", 0);
			this.areaBackright2 = new DrawArea(this.method72(aByte16), local800.width, 299, local800.height);
			local800.method320(34676, 0, 0);
			@Pc(825) Image24 local825 = new Image24(local277, "backtop1", 0);
			this.areaBacktop1 = new DrawArea(this.method72(aByte16), local825.width, 299, local825.height);
			local825.method320(34676, 0, 0);
			@Pc(850) Image24 local850 = new Image24(local277, "backtop2", 0);
			this.areaBacktop2 = new DrawArea(this.method72(aByte16), local850.width, 299, local850.height);
			local850.method320(34676, 0, 0);
			@Pc(875) Image24 local875 = new Image24(local277, "backvmid1", 0);
			this.areaBackvmid1 = new DrawArea(this.method72(aByte16), local875.width, 299, local875.height);
			local875.method320(34676, 0, 0);
			@Pc(900) Image24 local900 = new Image24(local277, "backvmid2", 0);
			this.areaBackvmid2 = new DrawArea(this.method72(aByte16), local900.width, 299, local900.height);
			local900.method320(34676, 0, 0);
			@Pc(925) Image24 local925 = new Image24(local277, "backvmid3", 0);
			this.areaBackvmid3 = new DrawArea(this.method72(aByte16), local925.width, 299, local925.height);
			local925.method320(34676, 0, 0);
			@Pc(950) Image24 local950 = new Image24(local277, "backhmid2", 0);
			this.areaBackhmid2 = new DrawArea(this.method72(aByte16), local950.width, 299, local950.height);
			local950.method320(34676, 0, 0);
			@Pc(975) int local975 = (int) (Math.random() * 21.0D) - 10;
			@Pc(982) int local982 = (int) (Math.random() * 21.0D) - 10;
			@Pc(989) int local989 = (int) (Math.random() * 21.0D) - 10;
			@Pc(996) int local996 = (int) (Math.random() * 41.0D) - 20;
			for (@Pc(998) int local998 = 0; local998 < 50; local998++) {
				if (this.imageMapfunction[local998] != null) {
					this.imageMapfunction[local998].method319(local975 + local996, local982 + local996, local989 + local996, true);
				}
				if (this.imageMapscene[local998] != null) {
					this.imageMapscene[local998].method349(local975 + local996, local982 + local996, local989 + local996, true);
				}
			}
			this.method74(true, "Unpacking textures", 80);
			Draw3D.method292((byte) 2, local299);
			Draw3D.method296(true, 0.8D);
			Draw3D.method291(20, -20);
			this.method74(true, "Unpacking models", 83);
			Model.method225(anInt268, local288);
			SeqBase.method261(false, local288);
			SeqFrame.method276(false, local288);
			this.method74(true, "Unpacking config", 86);
			SeqType.method374(local255, 473);
			LocType.method21(local255);
			FloType.method272(local255, 473);
			ObjType.method52(local255);
			NpcType.method30(local255);
			IdkType.method304(local255, 473);
			SpotAnimType.method407(local255, 473);
			VarpType.method411(local255, 473);
			ObjType.members = members;
			if (!lowMemory) {
				this.method74(true, "Unpacking sounds", 90);
				@Pc(1113) byte[] local1113 = local321.method536("sounds.dat", null, (byte) 2);
				@Pc(1119) Buffer local1119 = new Buffer(363, local1113);
				SoundTrack.method561(local1119, 473);
			}
			this.method74(true, "Unpacking interfaces", 92);
			@Pc(1150) BitmapFont[] local1150 = new BitmapFont[] { this.fontPlain11, this.fontPlain12, this.fontBold12, this.fontQuill8 };
			IfType.method331(local277, local1150, 30, local266);
			this.method74(true, "Preparing game engine", 97);
			@Pc(1166) int local1166;
			@Pc(1168) int local1168;
			@Pc(1170) int local1170;
			for (@Pc(1162) int local1162 = 0; local1162 < 33; local1162++) {
				local1166 = 999;
				local1168 = 0;
				for (local1170 = 0; local1170 < 35; local1170++) {
					if (this.imageMapback.pixels[local1170 + local1162 * this.imageMapback.width] == 0) {
						if (local1166 == 999) {
							local1166 = local1170;
						}
					} else if (local1166 != 999) {
						local1168 = local1170;
						break;
					}
				}
				this.compassMaskLineOffsets[local1162] = local1166;
				this.compassMaskLineLengths[local1162] = local1168 - local1166;
			}
			@Pc(1228) int local1228;
			for (local1166 = 9; local1166 < 160; local1166++) {
				local1168 = 999;
				local1170 = 0;
				for (local1228 = 10; local1228 < 168; local1228++) {
					if (this.imageMapback.pixels[local1228 + local1166 * this.imageMapback.width] == 0 && (local1228 > 34 || local1166 > 34)) {
						if (local1168 == 999) {
							local1168 = local1228;
						}
					} else if (local1168 != 999) {
						local1170 = local1228;
						break;
					}
				}
				this.minimapMaskLineOffsets[local1166 - 9] = local1168 - 21;
				this.minimapMaskLineLengths[local1166 - 9] = local1170 - local1168;
			}
			Draw3D.method289(96, 479, 0);
			this.areaChatbackOffsets = Draw3D.lineOffset;
			Draw3D.method289(261, 190, 0);
			this.areaSidebarOffsets = Draw3D.lineOffset;
			Draw3D.method289(334, 512, 0);
			this.areaViewportOffsets = Draw3D.lineOffset;
			@Pc(1312) int[] local1312 = new int[9];
			for (local1170 = 0; local1170 < 9; local1170++) {
				local1228 = local1170 * 32 + 128 + 15;
				@Pc(1330) int local1330 = local1228 * 3 + 600;
				@Pc(1334) int local1334 = Draw3D.sin[local1228];
				local1312[local1170] = local1330 * local1334 >> 16;
			}
			Scene.method504(local1312, 800, 512, aByte13, 334, 500);
			Censor.method414(local310);
		} catch (@Pc(1357) Exception local1357) {
			this.errorLoading = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "v", descriptor = "(I)V")
	private void method143(@OriginalArg(0) int arg0) {
		try {
			if (this.objDragArea == 0) {
				this.menuOption[0] = "Cancel";
				this.menuAction[0] = 1252;
				this.menuSize = 1;
				this.method136(super.mouseX, 27078, super.mouseY);
				this.anInt225 = 0;
				@Pc(32) int local32 = 12 / arg0;
				if (super.mouseX > 8 && super.mouseY > 11 && super.mouseX < 520 && super.mouseY < 345) {
					if (this.viewportInterfaceID == -1) {
						this.method192((byte) 2);
					} else {
						this.method90(super.mouseY, super.mouseX, 11, IfType.instances[this.viewportInterfaceID], 5082, 8, 0);
					}
				}
				if (this.anInt225 != this.anInt300) {
					this.anInt300 = this.anInt225;
				}
				this.anInt225 = 0;
				if (super.mouseX > 562 && super.mouseY > 231 && super.mouseX < 752 && super.mouseY < 492) {
					if (this.sidebarInterfaceId != -1) {
						this.method90(super.mouseY, super.mouseX, 231, IfType.instances[this.sidebarInterfaceId], 5082, 562, 0);
					} else if (this.tabInterfaceId[this.selectedTab] != -1) {
						this.method90(super.mouseY, super.mouseX, 231, IfType.instances[this.tabInterfaceId[this.selectedTab]], 5082, 562, 0);
					}
				}
				if (this.anInt225 != this.anInt256) {
					this.redrawSidebar = true;
					this.anInt256 = this.anInt225;
				}
				this.anInt225 = 0;
				if (super.mouseX > 22 && super.mouseY > 375 && super.mouseX < 431 && super.mouseY < 471) {
					if (this.chatInterfaceId == -1) {
						this.method92(super.mouseY - 375, 0, super.mouseX - 22);
					} else {
						this.method90(super.mouseY, super.mouseX, 375, IfType.instances[this.chatInterfaceId], 5082, 22, 0);
					}
				}
				if (this.chatInterfaceId != -1 && this.anInt225 != this.anInt221) {
					this.redrawChatback = true;
					this.anInt221 = this.anInt225;
				}
				@Pc(223) boolean local223 = false;
				while (!local223) {
					local223 = true;
					for (@Pc(229) int local229 = 0; local229 < this.menuSize - 1; local229++) {
						if (this.menuAction[local229] < 1000 && this.menuAction[local229 + 1] > 1000) {
							@Pc(250) String local250 = this.menuOption[local229];
							this.menuOption[local229] = this.menuOption[local229 + 1];
							this.menuOption[local229 + 1] = local250;
							@Pc(272) int local272 = this.menuAction[local229];
							this.menuAction[local229] = this.menuAction[local229 + 1];
							this.menuAction[local229 + 1] = local272;
							@Pc(294) int local294 = this.menuParamB[local229];
							this.menuParamB[local229] = this.menuParamB[local229 + 1];
							this.menuParamB[local229 + 1] = local294;
							@Pc(316) int local316 = this.menuParamC[local229];
							this.menuParamC[local229] = this.menuParamC[local229 + 1];
							this.menuParamC[local229 + 1] = local316;
							@Pc(338) int local338 = this.menuParamA[local229];
							this.menuParamA[local229] = this.menuParamA[local229 + 1];
							this.menuParamA[local229 + 1] = local338;
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
			LocType.aClass35_1.method529();
			LocType.aClass35_2.method529();
			NpcType.aClass35_3.method529();
			ObjType.aClass35_4.method529();
			ObjType.aClass35_5.method529();
			PlayerEntity.modelCache.method529();
			SpotAnimType.modelCache.method529();
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
			if (this.crossMode == 1) {
				this.imageCrosses[this.crossCycle / 100].method322(this.crossY - 8 - 11, this.crossX - 8 - 8, false);
			}
			if (this.crossMode == 2) {
				this.imageCrosses[this.crossCycle / 100 + 4].method322(this.crossY - 8 - 11, this.crossX - 8 - 8, false);
			}
			if (this.viewportInterfaceID != -1) {
				this.method171(this.viewportInterfaceID, this.sceneDelta, 623);
				this.method120(0, 0, 38682, IfType.instances[this.viewportInterfaceID], 0);
			}
			this.method79(39734);
			if (!this.menuVisible) {
				this.method143(26);
				this.method165(true);
			} else if (this.menuArea == 0) {
				this.method135(-961);
			}
			if (this.anInt276 == 1) {
				if (this.anInt316 > 0 || this.anInt252 == 1) {
					this.imageHeadicons[1].method322(258, 472, false);
				} else {
					this.imageHeadicons[1].method322(296, 472, false);
				}
			}
			if (this.anInt316 > 0) {
				this.imageHeadicons[0].method322(296, 472, false);
				this.fontPlain12.method362(329, (byte) 6, 16776960, "Level: " + this.anInt316, 484);
			}
			if (this.anInt252 == 1) {
				this.imageHeadicons[6].method322(296, 472, false);
				this.fontPlain12.method362(329, (byte) 6, 16776960, "Arena", 484);
			}
			if (this.systemUpdateTimer != 0) {
				local7 = this.systemUpdateTimer / 50;
				@Pc(196) int local196 = local7 / 60;
				local7 %= 60;
				if (local7 < 10) {
					this.fontPlain12.method365(4, 329, false, 16776960, "System update in: " + local196 + ":0" + local7);
				} else {
					this.fontPlain12.method365(4, 329, false, 16776960, "System update in: " + local196 + ":" + local7);
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
			@Pc(8) int local8 = this.localPlayer.x + this.cameraAnticheatOffsetX;
			@Pc(15) int local15 = this.localPlayer.z + this.cameraAnticheatOffsetZ;
			if (this.orbitCameraX - local8 < -500 || this.orbitCameraX - local8 > 500 || this.orbitCameraZ - local15 < -500 || this.orbitCameraZ - local15 > 500) {
				this.orbitCameraX = local8;
				this.orbitCameraZ = local15;
			}
			if (this.orbitCameraX != local8) {
				this.orbitCameraX += (local8 - this.orbitCameraX) / 16;
			}
			if (this.orbitCameraZ != local15) {
				this.orbitCameraZ += (local15 - this.orbitCameraZ) / 16;
			}
			if (super.actionKey[1] == 1) {
				this.orbitCameraYawVelocity += (-this.orbitCameraYawVelocity - 24) / 2;
			} else if (super.actionKey[2] == 1) {
				this.orbitCameraYawVelocity += (24 - this.orbitCameraYawVelocity) / 2;
			} else {
				this.orbitCameraYawVelocity /= 2;
			}
			if (super.actionKey[3] == 1) {
				this.orbitCameraPitchVelocity += (12 - this.orbitCameraPitchVelocity) / 2;
			} else if (super.actionKey[4] == 1) {
				this.orbitCameraPitchVelocity += (-this.orbitCameraPitchVelocity - 12) / 2;
			} else {
				this.orbitCameraPitchVelocity /= 2;
			}
			this.orbitCameraYaw = this.orbitCameraYaw + this.orbitCameraYawVelocity / 2 & 0x7FF;
			this.packetSize += arg0;
			this.orbitCameraPitch += this.orbitCameraPitchVelocity / 2;
			if (this.orbitCameraPitch < 128) {
				this.orbitCameraPitch = 128;
			}
			if (this.orbitCameraPitch > 383) {
				this.orbitCameraPitch = 383;
			}
			@Pc(208) int local208 = this.orbitCameraX >> 7;
			@Pc(213) int local213 = this.orbitCameraZ >> 7;
			@Pc(223) int local223 = this.method94(this.currentLevel, this.orbitCameraX, (byte) 5, this.orbitCameraZ);
			@Pc(225) int local225 = 0;
			@Pc(241) int local241;
			if (local208 > 3 && local213 > 3 && local208 < 100 && local213 < 100) {
				for (local241 = local208 - 4; local241 <= local208 + 4; local241++) {
					for (@Pc(247) int local247 = local213 - 4; local247 <= local213 + 4; local247++) {
						@Pc(252) int local252 = this.currentLevel;
						if (local252 < 3 && (this.levelTileFlags[1][local241][local247] & 0x2) == 2) {
							local252++;
						}
						@Pc(279) int local279 = local223 - this.levelHeightmap[local252][local241][local247];
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
			if (local241 > this.cameraPitchClamp) {
				this.cameraPitchClamp += (local241 - this.cameraPitchClamp) / 24;
			} else if (local241 < this.cameraPitchClamp) {
				this.cameraPitchClamp += (local241 - this.cameraPitchClamp) / 80;
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
				this.packetType = -1;
			}
			for (@Pc(12) ProjectileEntity local12 = (ProjectileEntity) this.projectiles.method456(); local12 != null; local12 = (ProjectileEntity) this.projectiles.method458(551)) {
				if (local12.level != this.currentLevel || loopCycle > local12.lastCycle) {
					local12.method567();
				} else if (loopCycle >= local12.startCycle) {
					if (local12.target > 0) {
						@Pc(42) NpcEntity local42 = this.npcs[local12.target - 1];
						if (local42 != null) {
							local12.method19(this.method94(local12.level, local42.x, (byte) 5, local42.z) - local12.offsetY, local42.z, local42.x, -855, loopCycle);
						}
					}
					if (local12.target < 0) {
						@Pc(73) int local73 = -local12.target - 1;
						@Pc(80) PlayerEntity local80;
						if (local73 == this.localPid) {
							local80 = this.localPlayer;
						} else {
							local80 = this.players[local73];
						}
						if (local80 != null) {
							local12.method19(this.method94(local12.level, local80.x, (byte) 5, local80.z) - local12.offsetY, local80.z, local80.x, -855, loopCycle);
						}
					}
					local12.method20((byte) -30, this.sceneDelta);
					this.scene.method478(-44713, (int) local12.z, 60, local12.yaw, (int) local12.x, -1, false, null, local12, (int) local12.y, this.currentLevel);
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
				aBoolean48 = !aBoolean48;
			}
			this.redrawTitleBackground = true;
		} catch (@Pc(13) RuntimeException local13) {
			signlink.reporterror("92948, " + arg0 + ", " + local13.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!hb;I)V")
	private void method148(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Image24 arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(7) int local7 = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
			@Pc(15) int local15 = arg3 * arg3 + arg0 * arg0;
			if (arg1 != 4) {
				this.aBoolean45 = !this.aBoolean45;
			}
			if (local15 <= 6400) {
				@Pc(34) int local34 = Model.sin[local7];
				@Pc(38) int local38 = Model.cos[local7];
				@Pc(47) int local47 = local34 * 256 / (this.minimapZoom + 256);
				@Pc(56) int local56 = local38 * 256 / (this.minimapZoom + 256);
				@Pc(66) int local66 = arg0 * local47 + arg3 * local56 >> 16;
				@Pc(76) int local76 = arg0 * local56 - arg3 * local47 >> 16;
				if (local15 > 2500) {
					arg2.method329(this.imageMapback, 83 - local76 - arg2.cropH / 2, local66 + 94 - arg2.cropW / 2, (byte) -15);
				} else {
					arg2.method322(83 - local76 - arg2.cropH / 2, local66 + 94 - arg2.cropW / 2, false);
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
				aBoolean48 = !aBoolean48;
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
	private void method151(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) PathingEntity arg2) {
		try {
			this.method152(arg2.z, arg2.x, this.anInt317, arg0);
			if (arg1) {
				this.packetType = -1;
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
				@Pc(28) int local28 = this.method94(this.currentLevel, arg1, (byte) 5, arg0) - arg3;
				@Pc(33) int local33 = arg1 - this.cameraX;
				@Pc(38) int local38 = local28 - this.cameraY;
				@Pc(43) int local43 = arg0 - this.cameraZ;
				@Pc(48) int local48 = Model.sin[this.cameraPitch];
				@Pc(53) int local53 = Model.cos[this.cameraPitch];
				@Pc(58) int local58 = Model.sin[this.cameraYaw];
				@Pc(63) int local63 = Model.cos[this.cameraYaw];
				@Pc(73) int local73 = local43 * local58 + local33 * local63 >> 16;
				@Pc(83) int local83 = local43 * local63 - local33 * local58 >> 16;
				if (arg2 >= 0) {
					this.out.method381(131);
				}
				local33 = local73;
				local73 = local38 * local53 - local83 * local48 >> 16;
				local43 = local38 * local48 + local83 * local53 >> 16;
				if (local43 >= 50) {
					this.projectX = Draw3D.centerX + (local33 << 9) / local43;
					this.projectY = Draw3D.centerY + (local73 << 9) / local43;
				} else {
					this.projectX = -1;
					this.projectY = -1;
				}
			} else {
				this.projectX = -1;
				this.projectY = -1;
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
			@Pc(16) int local16 = this.scene.method498(this.currentLevel, arg1, arg2, arg3);
			if (local16 == -1) {
				return false;
			}
			@Pc(25) int local25 = local16 & 0x1F;
			@Pc(31) int local31 = local16 >> 6 & 0x3;
			if (local25 == 10 || local25 == 11 || local25 == 22) {
				@Pc(43) LocType local43 = LocType.method23(local7);
				@Pc(51) int local51;
				@Pc(54) int local54;
				if (local31 == 0 || local31 == 2) {
					local51 = local43.sizeX;
					local54 = local43.sizeZ;
				} else {
					local51 = local43.sizeZ;
					local54 = local43.sizeX;
				}
				@Pc(65) int local65 = local43.interactionSideFlags;
				if (local31 != 0) {
					local65 = (local65 << local31 & 0xF) + (local65 >> 4 - local31);
				}
				this.method168(this.localPlayer.pathTileX[0], local51, false, arg1, this.localPlayer.pathTileZ[0], 0, 2, local54, arg2, 0, 0, local65);
			} else {
				this.method168(this.localPlayer.pathTileX[0], 0, false, arg1, this.localPlayer.pathTileZ[0], 0, 2, 0, arg2, local31, local25 + 1, 0);
			}
			this.crossX = super.mouseClickX;
			this.crossY = super.mouseClickY;
			this.crossMode = 2;
			this.crossCycle = 0;
			this.out.method380((byte) -34, arg0);
			this.out.method382(arg1 + this.sceneBaseTileX);
			this.out.method382(arg2 + this.sceneBaseTileZ);
			this.out.method382(local7);
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
			@Pc(7) int local7 = this.fontBold12.method364(false, "Choose Option");
			@Pc(20) int local20;
			for (@Pc(9) int local9 = 0; local9 < this.menuSize; local9++) {
				local20 = this.fontBold12.method364(false, this.menuOption[local9]);
				if (local20 > local7) {
					local7 = local20;
				}
			}
			local7 += 8;
			local20 = this.menuSize * 15 + 21;
			if (arg0 < 0) {
				@Pc(66) int local66;
				@Pc(84) int local84;
				if (super.mouseClickX > 8 && super.mouseClickY > 11 && super.mouseClickX < 520 && super.mouseClickY < 345) {
					local66 = super.mouseClickX - local7 / 2 - 8;
					if (local66 + local7 > 512) {
						local66 = 512 - local7;
					}
					if (local66 < 0) {
						local66 = 0;
					}
					local84 = super.mouseClickY - 11;
					if (local84 + local20 > 334) {
						local84 = 334 - local20;
					}
					if (local84 < 0) {
						local84 = 0;
					}
					this.menuVisible = true;
					this.menuArea = 0;
					this.menuX = local66;
					this.menuY = local84;
					this.menuWidth = local7;
					this.menuHeight = this.menuSize * 15 + 22;
				}
				if (super.mouseClickX > 562 && super.mouseClickY > 231 && super.mouseClickX < 752 && super.mouseClickY < 492) {
					local66 = super.mouseClickX - local7 / 2 - 562;
					if (local66 < 0) {
						local66 = 0;
					} else if (local66 + local7 > 190) {
						local66 = 190 - local7;
					}
					local84 = super.mouseClickY - 231;
					if (local84 < 0) {
						local84 = 0;
					} else if (local84 + local20 > 261) {
						local84 = 261 - local20;
					}
					this.menuVisible = true;
					this.menuArea = 1;
					this.menuX = local66;
					this.menuY = local84;
					this.menuWidth = local7;
					this.menuHeight = this.menuSize * 15 + 22;
				}
				if (super.mouseClickX > 22 && super.mouseClickY > 375 && super.mouseClickX < 501 && super.mouseClickY < 471) {
					local66 = super.mouseClickX - local7 / 2 - 22;
					if (local66 < 0) {
						local66 = 0;
					} else if (local66 + local7 > 479) {
						local66 = 479 - local7;
					}
					local84 = super.mouseClickY - 375;
					if (local84 < 0) {
						local84 = 0;
					} else if (local84 + local20 > 96) {
						local84 = 96 - local20;
					}
					this.menuVisible = true;
					this.menuArea = 2;
					this.menuX = local66;
					this.menuY = local84;
					this.menuWidth = local7;
					this.menuHeight = this.menuSize * 15 + 22;
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
			if (this.imageTitle2 == null) {
				super.aClass32_2 = null;
				this.areaChatback = null;
				this.areaMapback = null;
				this.areaSidebar = null;
				this.areaViewport = null;
				this.areaBackbase1 = null;
				this.areaBackbase2 = null;
				this.areaBackhmid1 = null;
				this.imageTitle0 = new DrawArea(this.method72(aByte16), 128, 299, 265);
				Draw2D.method357(this.anInt336);
				this.imageTitle1 = new DrawArea(this.method72(aByte16), 128, 299, 265);
				Draw2D.method357(this.anInt336);
				this.imageTitle2 = new DrawArea(this.method72(aByte16), 533, 299, 186);
				Draw2D.method357(this.anInt336);
				this.imageTitle3 = new DrawArea(this.method72(aByte16), 360, 299, 146);
				Draw2D.method357(this.anInt336);
				this.imageTitle4 = new DrawArea(this.method72(aByte16), 360, 299, 200);
				Draw2D.method357(this.anInt336);
				this.imageTitle5 = new DrawArea(this.method72(aByte16), 214, 299, 267);
				Draw2D.method357(this.anInt336);
				this.imageTitle6 = new DrawArea(this.method72(aByte16), 215, 299, 267);
				Draw2D.method357(this.anInt336);
				this.imageTitle7 = new DrawArea(this.method72(aByte16), 86, 299, 79);
				if (arg0 != this.aByte12) {
					this.out.method381(73);
				}
				Draw2D.method357(this.anInt336);
				this.imageTitle8 = new DrawArea(this.method72(aByte16), 87, 299, 79);
				Draw2D.method357(this.anInt336);
				if (this.archiveTitle != null) {
					this.method189((byte) 5);
					this.method109(0);
				}
				this.redrawTitleBackground = true;
			}
		} catch (@Pc(175) RuntimeException local175) {
			signlink.reporterror("86250, " + arg0 + ", " + local175.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "z", descriptor = "(I)V")
	private void method157(@OriginalArg(0) int arg0) {
		try {
			this.flameThread = true;
			try {
				@Pc(4) long local4 = System.currentTimeMillis();
				@Pc(6) int local6 = 0;
				@Pc(8) int local8 = 20;
				while (this.flameActive) {
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
			this.flameThread = false;
			if (arg0 != -33833) {
				aBoolean48 = !aBoolean48;
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
	private void method158(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) IfType arg8) {
		try {
			if (this.scrollGrabbed) {
				this.scrollInputPadding = 32;
			} else {
				this.scrollInputPadding = 0;
			}
			this.scrollGrabbed = false;
			this.packetSize += arg1;
			if (arg0 >= arg6 && arg0 < arg6 + 16 && arg2 >= arg7 && arg2 < arg7 + 16) {
				arg8.scrollPosition -= this.dragCycles * 4;
				if (arg5) {
					this.redrawSidebar = true;
					return;
				}
			} else if (arg0 >= arg6 && arg0 < arg6 + 16 && arg2 >= arg7 + arg4 - 16 && arg2 < arg7 + arg4) {
				arg8.scrollPosition += this.dragCycles * 4;
				if (arg5) {
					this.redrawSidebar = true;
					return;
				}
			} else if (arg0 >= arg6 - this.scrollInputPadding && arg0 < arg6 + this.scrollInputPadding + 16 && arg2 >= arg7 + 16 && arg2 < arg7 + arg4 - 16 && this.dragCycles > 0) {
				@Pc(122) int local122 = (arg4 - 32) * arg4 / arg3;
				if (local122 < 8) {
					local122 = 8;
				}
				@Pc(137) int local137 = arg2 - arg7 - local122 / 2 - 16;
				@Pc(143) int local143 = arg4 - local122 - 32;
				arg8.scrollPosition = (arg3 - arg4) * local137 / local143;
				if (arg5) {
					this.redrawSidebar = true;
				}
				this.scrollGrabbed = true;
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
				this.loginMessage0 = "";
				this.loginMessage1 = "Connecting to server...";
				this.method116(4);
			}
			this.connection = new Connection(this, (byte) 2, this.method162(portOffset + 43594));
			this.connection.method204(this.in.data, 0, 8);
			this.in.position = 0;
			this.name37 = this.in.method397(603);
			@Pc(47) int[] local47 = new int[] { (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (this.name37 >> 32), (int) this.name37 };
			this.out.position = 0;
			this.out.method381(10);
			this.out.method385(local47[0]);
			this.out.method385(local47[1]);
			this.out.method385(local47[2]);
			this.out.method385(local47[3]);
			this.out.method385(signlink.uid);
			this.out.method388(arg0);
			this.out.method388(arg1);
			this.out.method406(RSA_MODULUS, RSA_EXPONENT, this.anInt151);
			this.login.position = 0;
			if (arg2) {
				this.login.method381(18);
			} else {
				this.login.method381(16);
			}
			this.login.method381(this.out.position + 36 + 1 + 1);
			this.login.method381(225);
			this.login.method381(lowMemory ? 1 : 0);
			for (@Pc(168) int local168 = 0; local168 < 9; local168++) {
				this.login.method385(this.archiveChecksum[local168]);
			}
			this.login.method389(this.out.data, this.out.position, 0, (byte) -106);
			this.out.random = new IsaacRandom((byte) 1, local47);
			for (@Pc(202) int local202 = 0; local202 < 4; local202++) {
				local47[local202] += 50;
			}
			this.randomIn = new IsaacRandom((byte) 1, local47);
			this.connection.method205(this.login.data, this.login.position, true, 0);
			@Pc(237) int local237 = this.connection.method202();
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
					this.rights = true;
				} else {
					this.rights = false;
				}
				InputTracking.method209((byte) 65);
				this.ingame = true;
				this.out.position = 0;
				this.in.position = 0;
				this.packetType = -1;
				this.lastPacketType0 = -1;
				this.lastPacketType1 = -1;
				this.lastPacketType2 = -1;
				this.packetSize = 0;
				this.idleNetCycles = 0;
				this.systemUpdateTimer = 0;
				this.idleTimeout = 0;
				this.hintType = 0;
				this.menuSize = 0;
				this.menuVisible = false;
				super.idleCycles = 0;
				for (@Pc(318) int local318 = 0; local318 < 100; local318++) {
					this.messageText[local318] = null;
				}
				this.objSelected = 0;
				this.spellSelected = 0;
				this.sceneState = 0;
				this.waveCount = 0;
				this.cameraAnticheatOffsetX = (int) (Math.random() * 100.0D) - 50;
				this.cameraAnticheatOffsetZ = (int) (Math.random() * 110.0D) - 55;
				this.cameraAnticheatAngle = (int) (Math.random() * 80.0D) - 40;
				this.minimapAnticheatAngle = (int) (Math.random() * 120.0D) - 60;
				this.minimapZoom = (int) (Math.random() * 30.0D) - 20;
				this.orbitCameraYaw = (int) (Math.random() * 20.0D) - 10 & 0x7FF;
				this.anInt176 = -1;
				this.flagSceneTileX = 0;
				this.flagSceneTileZ = 0;
				this.playerCount = 0;
				this.npcCount = 0;
				for (@Pc(408) int local408 = 0; local408 < this.anInt203; local408++) {
					this.players[local408] = null;
					this.playerAppearanceBuffer[local408] = null;
				}
				for (@Pc(427) int local427 = 0; local427 < 8192; local427++) {
					this.npcs[local427] = null;
				}
				this.localPlayer = this.players[this.LOCAL_PLAYER_INDEX] = new PlayerEntity();
				this.projectiles.method460();
				this.aClass28_5.method460();
				this.aClass28_2.method460();
				@Pc(464) int local464;
				for (@Pc(460) int local460 = 0; local460 < 4; local460++) {
					for (local464 = 0; local464 < 104; local464++) {
						for (@Pc(468) int local468 = 0; local468 < 104; local468++) {
							this.levelObjStacks[local460][local464][local468] = null;
						}
					}
				}
				this.aClass28_4 = new DoublyLinkedList(0);
				this.friendCount = 0;
				this.stickyChatInterfaceId = -1;
				this.chatInterfaceId = -1;
				this.viewportInterfaceID = -1;
				this.sidebarInterfaceId = -1;
				this.pressedContinueOption = false;
				this.selectedTab = 3;
				this.chatbackInput = false;
				this.menuVisible = false;
				this.showSocialInput = false;
				this.modalMessage = null;
				this.anInt276 = 0;
				this.flashingTab = -1;
				this.designGenderMale = true;
				this.method112((byte) -6);
				for (local464 = 0; local464 < 5; local464++) {
					this.designColors[local464] = 0;
				}
				anInt175 = 0;
				anInt224 = 0;
				anInt195 = 0;
				anInt188 = 0;
				anInt143 = 0;
				anInt220 = 0;
				anInt254 = 0;
				anInt237 = 0;
				anInt229 = 0;
				this.method117(-7185);
				return;
			}
			if (local237 == 3) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Invalid username or password.";
				return;
			}
			if (local237 == 4) {
				this.loginMessage0 = "Your account has been disabled.";
				this.loginMessage1 = "Please check your message-centre for details.";
				return;
			}
			if (local237 == 5) {
				this.loginMessage0 = "Your account is already logged in.";
				this.loginMessage1 = "Try again in 60 secs...";
				return;
			}
			if (local237 == 6) {
				this.loginMessage0 = "RuneScape has been updated!";
				this.loginMessage1 = "Please reload this page.";
				return;
			}
			if (local237 == 7) {
				this.loginMessage0 = "This world is full.";
				this.loginMessage1 = "Please use a different world.";
				return;
			}
			if (local237 == 8) {
				this.loginMessage0 = "Unable to connect.";
				this.loginMessage1 = "Login server offline.";
				return;
			}
			if (local237 == 9) {
				this.loginMessage0 = "Login limit exceeded.";
				this.loginMessage1 = "Too many connections from your address.";
				return;
			}
			if (local237 == 10) {
				this.loginMessage0 = "Unable to connect.";
				this.loginMessage1 = "Bad session id.";
				return;
			}
			if (local237 == 11) {
				this.loginMessage1 = "Login server rejected session.";
				this.loginMessage1 = "Please try again.";
				return;
			}
			if (local237 == 12) {
				this.loginMessage0 = "You need a members account to login to this world.";
				this.loginMessage1 = "Please subscribe, or use a different world.";
				return;
			}
			if (local237 == 13) {
				this.loginMessage0 = "Could not complete login.";
				this.loginMessage1 = "Please try using a different world.";
				return;
			}
			if (local237 == 14) {
				this.loginMessage0 = "The server is being updated.";
				this.loginMessage1 = "Please wait 1 minute and try again.";
				return;
			}
			if (local237 == 15) {
				this.ingame = true;
				this.out.position = 0;
				this.in.position = 0;
				this.packetType = -1;
				this.lastPacketType0 = -1;
				this.lastPacketType1 = -1;
				this.lastPacketType2 = -1;
				this.packetSize = 0;
				this.idleNetCycles = 0;
				this.systemUpdateTimer = 0;
				this.menuSize = 0;
				this.menuVisible = false;
				return;
			}
			if (local237 == 16) {
				this.loginMessage0 = "Login attempts exceeded.";
				this.loginMessage1 = "Please wait 1 minute and try again.";
				return;
			}
			if (local237 == 17) {
				this.loginMessage0 = "You are standing in a members-only area.";
				this.loginMessage1 = "To play on this world move to a free area first";
				return;
			}
		} catch (@Pc(762) IOException local762) {
			this.loginMessage0 = "";
			this.loginMessage1 = "Error connecting to server.";
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIIII)V")
	private void method160(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		try {
			if (arg6 != -27819) {
				this.method67();
			}
			if (arg1 >= 1 && arg2 >= 1 && arg1 <= 102 && arg2 <= 102) {
				if (lowMemory && arg7 != this.currentLevel) {
					return;
				}
				@Pc(25) int local25 = 0;
				@Pc(27) boolean local27 = true;
				@Pc(29) boolean local29 = false;
				@Pc(31) boolean local31 = false;
				if (arg3 == 0) {
					local25 = this.scene.method494(arg7, arg1, arg2);
				}
				if (arg3 == 1) {
					local25 = this.scene.method495(arg7, arg2, 3, arg1);
				}
				if (arg3 == 2) {
					local25 = this.scene.method496(arg7, arg1, arg2);
				}
				if (arg3 == 3) {
					local25 = this.scene.method497(arg7, arg1, arg2);
				}
				@Pc(81) int local81;
				if (local25 != 0) {
					local81 = this.scene.method498(arg7, arg1, arg2, local25);
					@Pc(87) int local87 = local25 >> 14 & 0x7FFF;
					@Pc(91) int local91 = local81 & 0x1F;
					@Pc(95) int local95 = local81 >> 6;
					@Pc(107) LocType local107;
					if (arg3 == 0) {
						this.scene.method489(arg1, arg7, arg2, 1);
						local107 = LocType.method23(local87);
						if (local107.aBoolean7) {
							this.levelCollisionMap[arg7].method254(local107.aBoolean8, local95, arg1, arg2, 323, local91);
						}
					}
					if (arg3 == 1) {
						this.scene.method490(arg7, arg2, this.anInt306, arg1);
					}
					if (arg3 == 2) {
						this.scene.method491(arg1, arg2, -54, arg7);
						local107 = LocType.method23(local87);
						if (arg1 + local107.sizeX > 103 || arg2 + local107.sizeX > 103 || arg1 + local107.sizeZ > 103 || arg2 + local107.sizeZ > 103) {
							return;
						}
						if (local107.aBoolean7) {
							this.levelCollisionMap[arg7].method255(arg2, arg1, local95, local107.sizeX, true, local107.aBoolean8, local107.sizeZ);
						}
					}
					if (arg3 == 3) {
						this.scene.method492(arg7, this.anInt290, arg1, arg2);
						local107 = LocType.method23(local87);
						if (local107.aBoolean7 && local107.aBoolean9) {
							this.levelCollisionMap[arg7].method257(arg2, arg1, 0);
						}
					}
				}
				if (arg4 >= 0) {
					local81 = arg7;
					if (arg7 < 3 && (this.levelTileFlags[1][arg1][arg2] & 0x2) == 2) {
						local81 = arg7 + 1;
					}
					SceneBuilder.method50(arg1, this.aClass28_1, this.levelCollisionMap[arg7], arg2, arg0, this.levelHeightmap, 0, arg7, arg4, arg5, this.scene, local81);
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
				if (this.friendCount >= 100) {
					this.method172(0, "Your friends list is full. Max of 100 hit", (byte) 4, "");
				} else {
					@Pc(23) String local23 = StringUtils.formatName(0, StringUtils.fromBase37(arg0, false));
					for (@Pc(25) int local25 = 0; local25 < this.friendCount; local25++) {
						if (this.friendName37[local25] == arg0) {
							this.method172(0, local23 + " is already on your friend list", (byte) 4, "");
							return;
						}
					}
					for (@Pc(55) int local55 = 0; local55 < this.ignoreCount; local55++) {
						if (this.ignoreName37[local55] == arg0) {
							this.method172(0, "Please remove " + local23 + " from your ignore list first", (byte) 4, "");
							return;
						}
					}
					if (!local23.equals(this.localPlayer.name)) {
						this.friendName[this.friendCount] = local23;
						this.friendName37[this.friendCount] = arg0;
						this.friendWorld[this.friendCount] = 0;
						this.friendCount++;
						if (arg1 >= 0) {
							this.anInt294 = this.randomIn.method532();
						}
						this.redrawSidebar = true;
						this.out.method380((byte) -34, 118);
						this.out.method387(true, arg0);
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
				if (this.connection != null) {
					this.connection.method201();
				}
			} catch (@Pc(11) Exception local11) {
			}
			this.connection = null;
			this.method78(0);
			this.aBoolean41 = false;
			this.out = null;
			this.login = null;
			this.in = null;
			this.anIntArray56 = null;
			this.sceneMapLandData = null;
			this.aByteArrayArray2 = null;
			this.levelHeightmap = null;
			this.levelTileFlags = null;
			this.scene = null;
			this.levelCollisionMap = null;
			this.bfsDirection = null;
			this.bfsCost = null;
			this.bfsStepX = null;
			this.bfsStepZ = null;
			this.aByteArray4 = null;
			this.areaSidebar = null;
			this.areaMapback = null;
			this.areaViewport = null;
			this.areaChatback = null;
			this.areaBackbase1 = null;
			this.areaBackbase2 = null;
			this.areaBackhmid1 = null;
			this.areaBackleft1 = null;
			this.areaBackleft2 = null;
			this.areaBackright1 = null;
			this.areaBackright2 = null;
			this.areaBacktop1 = null;
			this.areaBacktop2 = null;
			this.areaBackvmid1 = null;
			this.areaBackvmid2 = null;
			this.areaBackvmid3 = null;
			this.areaBackhmid2 = null;
			this.imageInvback = null;
			this.imageMapback = null;
			this.imageChatback = null;
			this.imageBackbase1 = null;
			this.imageBackbase2 = null;
			this.imageBackhmid1 = null;
			this.imageSideicons = null;
			this.imageRedstone1 = null;
			this.imageRedstone2 = null;
			this.imageRedstone3 = null;
			this.imageRedstone1h = null;
			this.imageRedstone2h = null;
			this.imageRedstone1v = null;
			this.imageRedstone2v = null;
			this.imageRedstone3v = null;
			this.imageRedstone1hv = null;
			this.imageRedstone2hv = null;
			this.imageCompass = null;
			this.imageHitmarks = null;
			this.imageHeadicons = null;
			this.imageCrosses = null;
			this.imageMapdot0 = null;
			this.imageMapdot1 = null;
			this.imageMapdot2 = null;
			this.imageMapdot3 = null;
			this.imageMapscene = null;
			if (arg0 != -28) {
				this.method67();
			}
			this.imageMapfunction = null;
			this.anIntArrayArray3 = null;
			this.players = null;
			this.playerIds = null;
			this.entityUpdateIds = null;
			this.playerAppearanceBuffer = null;
			this.entityRemovalIds = null;
			this.npcs = null;
			this.npcIds = null;
			this.levelObjStacks = null;
			this.aClass28_4 = null;
			this.aClass28_2 = null;
			this.projectiles = null;
			this.aClass28_5 = null;
			this.aClass28_1 = null;
			this.menuParamB = null;
			this.menuParamC = null;
			this.menuAction = null;
			this.menuParamA = null;
			this.menuOption = null;
			this.varps = null;
			this.anIntArray54 = null;
			this.anIntArray55 = null;
			this.aClass1_Sub3_Sub2_Sub2Array4 = null;
			this.imageMinimap = null;
			this.friendName = null;
			this.friendName37 = null;
			this.friendWorld = null;
			this.imageTitle0 = null;
			this.imageTitle1 = null;
			this.imageTitle2 = null;
			this.imageTitle3 = null;
			this.imageTitle4 = null;
			this.imageTitle5 = null;
			this.imageTitle6 = null;
			this.imageTitle7 = null;
			this.imageTitle8 = null;
			this.method99(true);
			LocType.method22(true);
			NpcType.method31(true);
			ObjType.method53(true);
			FloType.instances = null;
			IdkType.instances = null;
			IfType.instances = null;
			DeadType.instances = null;
			SeqType.instances = null;
			SpotAnimType.instances = null;
			SpotAnimType.modelCache = null;
			VarpType.aClass23Array1 = null;
			super.aClass32_2 = null;
			PlayerEntity.modelCache = null;
			Draw3D.method287(true);
			Scene.method466(true);
			Model.method224(true);
			SeqBase.aClass10Array1 = null;
			SeqFrame.aClass12Array1 = null;
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
	private void method163(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) PlayerEntity arg3, @OriginalArg(4) int arg4) {
		try {
			if (arg0) {
				this.anInt290 = this.randomIn.method532();
			}
			if (arg3 != this.localPlayer && this.menuSize < 400) {
				@Pc(41) String local41 = arg3.name + method133(this.localPlayer.combatLevel, false, arg3.combatLevel) + " (level-" + arg3.combatLevel + ")";
				if (this.objSelected == 1) {
					this.menuOption[this.menuSize] = "Use " + this.selectedObjName + " with @whi@" + local41;
					this.menuAction[this.menuSize] = 367;
					this.menuParamA[this.menuSize] = arg2;
					this.menuParamB[this.menuSize] = arg4;
					this.menuParamC[this.menuSize] = arg1;
					this.menuSize++;
				} else if (this.spellSelected != 1) {
					this.menuOption[this.menuSize] = "Follow @whi@" + local41;
					this.menuAction[this.menuSize] = 1544;
					this.menuParamA[this.menuSize] = arg2;
					this.menuParamB[this.menuSize] = arg4;
					this.menuParamC[this.menuSize] = arg1;
					this.menuSize++;
					if (this.overrideChat == 0) {
						this.menuOption[this.menuSize] = "Trade with @whi@" + local41;
						this.menuAction[this.menuSize] = 1373;
						this.menuParamA[this.menuSize] = arg2;
						this.menuParamB[this.menuSize] = arg4;
						this.menuParamC[this.menuSize] = arg1;
						this.menuSize++;
					}
					if (this.anInt316 > 0) {
						this.menuOption[this.menuSize] = "Attack @whi@" + local41;
						if (this.localPlayer.combatLevel >= arg3.combatLevel) {
							this.menuAction[this.menuSize] = 151;
						} else {
							this.menuAction[this.menuSize] = 2151;
						}
						this.menuParamA[this.menuSize] = arg2;
						this.menuParamB[this.menuSize] = arg4;
						this.menuParamC[this.menuSize] = arg1;
						this.menuSize++;
					}
					if (this.anInt252 == 1) {
						this.menuOption[this.menuSize] = "Fight @whi@" + local41;
						this.menuAction[this.menuSize] = 151;
						this.menuParamA[this.menuSize] = arg2;
						this.menuParamB[this.menuSize] = arg4;
						this.menuParamC[this.menuSize] = arg1;
						this.menuSize++;
					}
					if (this.anInt252 == 2) {
						this.menuOption[this.menuSize] = "Duel-with @whi@" + local41;
						this.menuAction[this.menuSize] = 1101;
						this.menuParamA[this.menuSize] = arg2;
						this.menuParamB[this.menuSize] = arg4;
						this.menuParamC[this.menuSize] = arg1;
						this.menuSize++;
					}
				} else if ((this.anInt293 & 0x8) == 8) {
					this.menuOption[this.menuSize] = this.spellCaption + " @whi@" + local41;
					this.menuAction[this.menuSize] = 651;
					this.menuParamA[this.menuSize] = arg2;
					this.menuParamB[this.menuSize] = arg4;
					this.menuParamC[this.menuSize] = arg1;
					this.menuSize++;
				}
				for (@Pc(392) int local392 = 0; local392 < this.menuSize; local392++) {
					if (this.menuAction[local392] == 660) {
						this.menuOption[local392] = "Walk here @whi@" + local41;
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
			if (this.systemUpdateTimer > 1) {
				this.systemUpdateTimer--;
			}
			if (this.idleTimeout > 0) {
				this.idleTimeout--;
			}
			for (@Pc(22) int local22 = 0; local22 < 5 && this.method197(false); local22++) {
			}
			if (!arg0) {
				this.packetType = this.in.method391();
			}
			if (this.ingame) {
				@Pc(155) int local155;
				@Pc(207) int local207;
				for (@Pc(46) int local46 = 0; local46 < this.waveCount; local46++) {
					if (this.waveDelay[local46] <= 0) {
						@Pc(55) boolean local55 = false;
						try {
							if (this.waveIds[local46] != this.anInt184 || this.waveLoops[local46] != this.anInt301) {
								@Pc(89) Buffer local89 = SoundTrack.method562((byte) -16, this.waveLoops[local46], this.waveIds[local46]);
								if (System.currentTimeMillis() + (long) (local89.position / 22) > this.aLong7 + (long) (this.anInt198 / 22)) {
									this.anInt198 = local89.position;
									this.aLong7 = System.currentTimeMillis();
									if (this.method138(local89.data, local89.position, 0)) {
										this.anInt184 = this.waveIds[local46];
										this.anInt301 = this.waveLoops[local46];
									} else {
										local55 = true;
									}
								}
							} else if (!this.method139(this.anInt177)) {
								local55 = true;
							}
						} catch (@Pc(139) Exception local139) {
						}
						if (local55 && this.waveDelay[local46] != -5) {
							this.waveDelay[local46] = -5;
						} else {
							this.waveCount--;
							for (local155 = local46; local155 < this.waveCount; local155++) {
								this.waveIds[local155] = this.waveIds[local155 + 1];
								this.waveLoops[local155] = this.waveLoops[local155 + 1];
								this.waveDelay[local155] = this.waveDelay[local155 + 1];
							}
							local46--;
						}
					} else {
						local207 = this.waveDelay[local46]--;
					}
				}
				if (this.nextMusicDelay > 0) {
					this.nextMusicDelay -= 20;
					if (this.nextMusicDelay < 0) {
						this.nextMusicDelay = 0;
					}
					if (this.nextMusicDelay == 0 && this.midiActive && !lowMemory) {
						this.method75(false, this.midiCrc, this.currentMidi, this.midiSize);
					}
				}
				@Pc(250) Buffer local250 = InputTracking.method210(-809);
				if (local250 != null) {
					this.out.method380((byte) -34, 81);
					this.out.method382(local250.position);
					this.out.method389(local250.data, local250.position, 0, (byte) -106);
					local250.method379((byte) 8);
				}
				this.idleNetCycles++;
				if (this.idleNetCycles > 750) {
					this.method182(false);
				}
				this.method193(true);
				this.method123(true);
				this.method186(this.aByte17);
				this.method105(this.anInt174);
				if ((super.actionKey[1] == 1 || super.actionKey[2] == 1 || super.actionKey[3] == 1 || super.actionKey[4] == 1) && this.cameraMovedWrite++ > 5) {
					this.cameraMovedWrite = 0;
					this.out.method380((byte) -34, 189);
					this.out.method382(this.orbitCameraPitch);
					this.out.method382(this.orbitCameraYaw);
					this.out.method381(this.minimapAnticheatAngle);
					this.out.method381(this.minimapZoom);
				}
				this.sceneDelta++;
				if (this.crossMode != 0) {
					this.crossCycle += 20;
					if (this.crossCycle >= 400) {
						this.crossMode = 0;
					}
				}
				if (this.selectedArea != 0) {
					this.selectedCycle++;
					if (this.selectedCycle >= 15) {
						if (this.selectedArea == 2) {
							this.redrawSidebar = true;
						}
						if (this.selectedArea == 3) {
							this.redrawChatback = true;
						}
						this.selectedArea = 0;
					}
				}
				@Pc(508) int local508;
				if (this.objDragArea != 0) {
					this.objDragCycles++;
					if (super.mouseX > this.objGrabX + 5 || super.mouseX < this.objGrabX - 5 || super.mouseY > this.objGrabY + 5 || super.mouseY < this.objGrabY - 5) {
						this.objGrabThreshold = true;
					}
					if (super.mouseButton == 0) {
						if (this.objDragArea == 2) {
							this.redrawSidebar = true;
						}
						if (this.objDragArea == 3) {
							this.redrawChatback = true;
						}
						this.objDragArea = 0;
						if (this.objGrabThreshold && this.objDragCycles >= 5) {
							this.hoveredSlotParentId = -1;
							this.method143(26);
							if (this.hoveredSlotParentId == this.objDragInterfaceId && this.hoveredSlot != this.objDragSlot) {
								@Pc(502) IfType local502 = IfType.instances[this.objDragInterfaceId];
								local508 = local502.inventorySlotObjId[this.hoveredSlot];
								local502.inventorySlotObjId[this.hoveredSlot] = local502.inventorySlotObjId[this.objDragSlot];
								local502.inventorySlotObjId[this.objDragSlot] = local508;
								@Pc(530) int local530 = local502.inventorySlotObjCount[this.hoveredSlot];
								local502.inventorySlotObjCount[this.hoveredSlot] = local502.inventorySlotObjCount[this.objDragSlot];
								local502.inventorySlotObjCount[this.objDragSlot] = local530;
								this.out.method380((byte) -34, 159);
								this.out.method382(this.objDragInterfaceId);
								this.out.method382(this.objDragSlot);
								this.out.method382(this.hoveredSlot);
							}
						} else if ((this.mouseButtonsOption == 1 || this.method131(145, this.menuSize - 1)) && this.menuSize > 2) {
							this.method154(-386);
						} else if (this.menuSize > 0) {
							this.method132(6412, this.menuSize - 1);
						}
						this.selectedCycle = 10;
						super.mouseClickButton = 0;
					}
				}
				updateCounter++;
				if (updateCounter > 127) {
					updateCounter = 0;
					this.out.method380((byte) -34, 215);
					this.out.method384(4991788);
				}
				if (Scene.clickedTileX != -1) {
					local155 = Scene.clickedTileX;
					local508 = Scene.clickTileZ;
					@Pc(653) boolean local653 = this.method168(this.localPlayer.pathTileX[0], 0, true, local155, this.localPlayer.pathTileZ[0], 0, 0, 0, local508, 0, 0, 0);
					Scene.clickedTileX = -1;
					if (local653) {
						this.crossX = super.mouseClickX;
						this.crossY = super.mouseClickY;
						this.crossMode = 1;
						this.crossCycle = 0;
					}
				}
				if (super.mouseClickButton == 1 && this.modalMessage != null) {
					this.modalMessage = null;
					this.redrawChatback = true;
					super.mouseClickButton = 0;
				}
				this.method177((byte) 3);
				this.method176((byte) 7);
				this.method179(this.anInt333);
				this.method91(0);
				if (super.mouseButton == 1 || super.mouseClickButton == 1) {
					this.dragCycles++;
				}
				if (this.sceneState == 2) {
					this.method146(0);
				}
				if (this.sceneState == 2 && this.cutscene) {
					this.method178(this.aByte11);
				}
				for (local155 = 0; local155 < 5; local155++) {
					local207 = this.cameraModifierCycle[local155]++;
				}
				this.method96(7);
				super.idleCycles++;
				if (super.idleCycles > 4500) {
					this.idleTimeout = 250;
					super.idleCycles -= 500;
					this.out.method380((byte) -34, 70);
				}
				this.cameraOffsetCycle++;
				if (this.cameraOffsetCycle > 500) {
					this.cameraOffsetCycle = 0;
					local508 = (int) (Math.random() * 8.0D);
					if ((local508 & 0x1) == 1) {
						this.cameraAnticheatOffsetX += this.cameraOffsetXModifier;
					}
					if ((local508 & 0x2) == 2) {
						this.cameraAnticheatOffsetZ += this.cameraOffsetZModifier;
					}
					if ((local508 & 0x4) == 4) {
						this.cameraAnticheatAngle += this.cameraOffsetYawModifier;
					}
				}
				if (this.cameraAnticheatOffsetX < -50) {
					this.cameraOffsetXModifier = 2;
				}
				if (this.cameraAnticheatOffsetX > 50) {
					this.cameraOffsetXModifier = -2;
				}
				if (this.cameraAnticheatOffsetZ < -55) {
					this.cameraOffsetZModifier = 2;
				}
				if (this.cameraAnticheatOffsetZ > 55) {
					this.cameraOffsetZModifier = -2;
				}
				if (this.cameraAnticheatAngle < -40) {
					this.cameraOffsetYawModifier = 1;
				}
				if (this.cameraAnticheatAngle > 40) {
					this.cameraOffsetYawModifier = -1;
				}
				this.minimapOffsetCycle++;
				if (this.minimapOffsetCycle > 500) {
					this.minimapOffsetCycle = 0;
					local508 = (int) (Math.random() * 8.0D);
					if ((local508 & 0x1) == 1) {
						this.minimapAnticheatAngle += this.minimapAngleModifier;
					}
					if ((local508 & 0x2) == 2) {
						this.minimapZoom += this.minimapZoomModifier;
					}
				}
				if (this.minimapAnticheatAngle < -60) {
					this.minimapAngleModifier = 2;
				}
				if (this.minimapAnticheatAngle > 60) {
					this.minimapAngleModifier = -2;
				}
				if (this.minimapZoom < -20) {
					this.minimapZoomModifier = 1;
				}
				if (this.minimapZoom > 10) {
					this.minimapZoomModifier = -1;
				}
				update2Counter++;
				if (update2Counter > 110) {
					update2Counter = 0;
					this.out.method380((byte) -34, 236);
					this.out.method385(0);
				}
				this.heartbeatTimer++;
				if (this.heartbeatTimer > 50) {
					this.out.method380((byte) -34, 108);
				}
				try {
					if (this.connection != null && this.out.position > 0) {
						this.connection.method205(this.out.data, this.out.position, true, 0);
						this.out.position = 0;
						this.heartbeatTimer = 0;
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
			if (this.menuSize >= 2 || this.objSelected != 0 || this.spellSelected != 0) {
				@Pc(31) String local31;
				if (this.objSelected == 1 && this.menuSize < 2) {
					local31 = "Use " + this.selectedObjName + " with...";
				} else if (this.spellSelected == 1 && this.menuSize < 2) {
					local31 = this.spellCaption + "...";
				} else {
					local31 = this.menuOption[this.menuSize - 1];
				}
				if (this.menuSize > 2) {
					local31 = local31 + "@whi@ / " + (this.menuSize - 2) + " more options";
				}
				this.fontBold12.method368(loopCycle / 1000, true, (byte) -121, 15, 16777215, local31, 4);
				if (!arg0) {
					this.packetType = -1;
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
			for (@Pc(13) SpotAnimEntity local13 = (SpotAnimEntity) this.aClass28_5.method456(); local13 != null; local13 = (SpotAnimEntity) this.aClass28_5.method458(551)) {
				if (local13.level != this.currentLevel || local13.seqComplete) {
					local13.method567();
				} else if (loopCycle >= local13.startCycle) {
					local13.method29(this.sceneDelta, 0);
					if (local13.seqComplete) {
						local13.method567();
					} else {
						this.scene.method478(-44713, local13.z, 60, 0, local13.x, -1, false, null, local13, local13.y, local13.level);
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
			if (super.frame != null) {
				return new URL("http://world2.runewiki.org:" + (portOffset + 80));
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
					this.bfsDirection[local7][local11] = 0;
					this.bfsCost[local7][local11] = 99999999;
				}
			}
			local11 = arg0;
			@Pc(39) int local39 = arg4;
			this.bfsDirection[arg0][arg4] = 99;
			this.bfsCost[arg0][arg4] = 0;
			@Pc(55) byte local55 = 0;
			@Pc(57) int local57 = 0;
			this.bfsStepX[local55] = arg0;
			@Pc(66) int local66 = local55 + 1;
			this.bfsStepZ[local55] = arg4;
			@Pc(70) boolean local70 = false;
			@Pc(74) int local74 = this.bfsStepX.length;
			@Pc(81) int[][] local81 = this.levelCollisionMap[this.currentLevel].flags;
			@Pc(193) int local193;
			while (local57 != local66) {
				local11 = this.bfsStepX[local57];
				local39 = this.bfsStepZ[local57];
				local57 = (local57 + 1) % local74;
				if (local11 == arg3 && local39 == arg8) {
					local70 = true;
					break;
				}
				if (arg10 != 0) {
					if ((arg10 < 5 || arg10 == 10) && this.levelCollisionMap[this.currentLevel].method258(-7517, arg9, arg8, arg10 - 1, local39, arg3, local11)) {
						local70 = true;
						break;
					}
					if (arg10 < 10 && this.levelCollisionMap[this.currentLevel].method259(arg9, arg10 - 1, this.anInt294, local11, arg3, local39, arg8)) {
						local70 = true;
						break;
					}
				}
				if (arg1 != 0 && arg7 != 0 && this.levelCollisionMap[this.currentLevel].method260(local39, arg7, local11, arg3, arg11, arg8, arg1, 168)) {
					local70 = true;
					break;
				}
				local193 = this.bfsCost[local11][local39] + 1;
				if (local11 > 0 && this.bfsDirection[local11 - 1][local39] == 0 && (local81[local11 - 1][local39] & 0x280108) == 0) {
					this.bfsStepX[local66] = local11 - 1;
					this.bfsStepZ[local66] = local39;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11 - 1][local39] = 2;
					this.bfsCost[local11 - 1][local39] = local193;
				}
				if (local11 < local3 - 1 && this.bfsDirection[local11 + 1][local39] == 0 && (local81[local11 + 1][local39] & 0x280180) == 0) {
					this.bfsStepX[local66] = local11 + 1;
					this.bfsStepZ[local66] = local39;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11 + 1][local39] = 8;
					this.bfsCost[local11 + 1][local39] = local193;
				}
				if (local39 > 0 && this.bfsDirection[local11][local39 - 1] == 0 && (local81[local11][local39 - 1] & 0x280102) == 0) {
					this.bfsStepX[local66] = local11;
					this.bfsStepZ[local66] = local39 - 1;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11][local39 - 1] = 1;
					this.bfsCost[local11][local39 - 1] = local193;
				}
				if (local39 < local5 - 1 && this.bfsDirection[local11][local39 + 1] == 0 && (local81[local11][local39 + 1] & 0x280120) == 0) {
					this.bfsStepX[local66] = local11;
					this.bfsStepZ[local66] = local39 + 1;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11][local39 + 1] = 4;
					this.bfsCost[local11][local39 + 1] = local193;
				}
				if (local11 > 0 && local39 > 0 && this.bfsDirection[local11 - 1][local39 - 1] == 0 && (local81[local11 - 1][local39 - 1] & 0x28010E) == 0 && (local81[local11 - 1][local39] & 0x280108) == 0 && (local81[local11][local39 - 1] & 0x280102) == 0) {
					this.bfsStepX[local66] = local11 - 1;
					this.bfsStepZ[local66] = local39 - 1;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11 - 1][local39 - 1] = 3;
					this.bfsCost[local11 - 1][local39 - 1] = local193;
				}
				if (local11 < local3 - 1 && local39 > 0 && this.bfsDirection[local11 + 1][local39 - 1] == 0 && (local81[local11 + 1][local39 - 1] & 0x280183) == 0 && (local81[local11 + 1][local39] & 0x280180) == 0 && (local81[local11][local39 - 1] & 0x280102) == 0) {
					this.bfsStepX[local66] = local11 + 1;
					this.bfsStepZ[local66] = local39 - 1;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11 + 1][local39 - 1] = 9;
					this.bfsCost[local11 + 1][local39 - 1] = local193;
				}
				if (local11 > 0 && local39 < local5 - 1 && this.bfsDirection[local11 - 1][local39 + 1] == 0 && (local81[local11 - 1][local39 + 1] & 0x280138) == 0 && (local81[local11 - 1][local39] & 0x280108) == 0 && (local81[local11][local39 + 1] & 0x280120) == 0) {
					this.bfsStepX[local66] = local11 - 1;
					this.bfsStepZ[local66] = local39 + 1;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11 - 1][local39 + 1] = 6;
					this.bfsCost[local11 - 1][local39 + 1] = local193;
				}
				if (local11 < local3 - 1 && local39 < local5 - 1 && this.bfsDirection[local11 + 1][local39 + 1] == 0 && (local81[local11 + 1][local39 + 1] & 0x2801E0) == 0 && (local81[local11 + 1][local39] & 0x280180) == 0 && (local81[local11][local39 + 1] & 0x280120) == 0) {
					this.bfsStepX[local66] = local11 + 1;
					this.bfsStepZ[local66] = local39 + 1;
					local66 = (local66 + 1) % local74;
					this.bfsDirection[local11 + 1][local39 + 1] = 12;
					this.bfsCost[local11 + 1][local39 + 1] = local193;
				}
			}
			this.tryMoveNearest = 0;
			@Pc(809) int local809;
			@Pc(815) int local815;
			@Pc(821) int local821;
			if (!local70) {
				if (arg2) {
					local193 = 100;
					for (local809 = 1; local809 < 2; local809++) {
						for (local815 = arg3 - local809; local815 <= arg3 + local809; local815++) {
							for (local821 = arg8 - local809; local821 <= arg8 + local809; local821++) {
								if (local815 >= 0 && local821 >= 0 && local815 < 104 && local821 < 104 && this.bfsCost[local815][local821] < local193) {
									local193 = this.bfsCost[local815][local821];
									local11 = local815;
									local39 = local821;
									this.tryMoveNearest = 1;
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
			this.bfsStepX[local882] = local11;
			if (arg5 != 0) {
				this.packetType = this.in.method391();
			}
			local57 = local882 + 1;
			this.bfsStepZ[local882] = local39;
			local193 = local809 = this.bfsDirection[local11][local39];
			while (local11 != arg0 || local39 != arg4) {
				if (local193 != local809) {
					local809 = local193;
					this.bfsStepX[local57] = local11;
					this.bfsStepZ[local57++] = local39;
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
				local193 = this.bfsDirection[local11][local39];
			}
			if (local57 > 0) {
				local74 = local57;
				if (local57 > 25) {
					local74 = 25;
				}
				local57--;
				local815 = this.bfsStepX[local57];
				local821 = this.bfsStepZ[local57];
				if (arg6 == 0) {
					this.out.method380((byte) -34, 181);
					this.out.method381(local74 + local74 + 3);
				}
				if (arg6 == 1) {
					this.out.method380((byte) -34, 165);
					this.out.method381(local74 + local74 + 3 + 14);
				}
				if (arg6 == 2) {
					this.out.method380((byte) -34, 93);
					this.out.method381(local74 + local74 + 3);
				}
				if (super.actionKey[5] == 1) {
					this.out.method381(1);
				} else {
					this.out.method381(0);
				}
				this.out.method382(local815 + this.sceneBaseTileX);
				this.out.method382(local821 + this.sceneBaseTileZ);
				this.flagSceneTileX = this.bfsStepX[0];
				this.flagSceneTileZ = this.bfsStepZ[0];
				for (@Pc(1077) int local1077 = 1; local1077 < local74; local1077++) {
					local57--;
					this.out.method381(this.bfsStepX[local57] - local815);
					this.out.method381(this.bfsStepZ[local57] - local821);
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
	private void method170(@OriginalArg(0) Buffer arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			this.entityRemovalCount = 0;
			this.entityUpdateCount = 0;
			this.method195(11522, arg1, arg0);
			this.method110(arg1, arg0, 0);
			this.method118(2, arg1, arg0);
			this.method121(true, arg1, arg0);
			@Pc(36) int local36;
			for (@Pc(29) int local29 = 0; local29 < this.entityRemovalCount; local29++) {
				local36 = this.entityRemovalIds[local29];
				if (this.players[local36].cycle != loopCycle) {
					this.players[local36] = null;
				}
			}
			if (arg2 > 0) {
				if (arg0.position != arg1) {
					signlink.reporterror("Error packet size mismatch in getplayer pos:" + arg0.position + " psize:" + arg1);
					throw new RuntimeException("eek");
				}
				for (local36 = 0; local36 < this.playerCount; local36++) {
					if (this.players[this.playerIds[local36]] == null) {
						signlink.reporterror(this.username + " null entry in pl list - pos:" + local36 + " size:" + this.playerCount);
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
			@Pc(7) IfType local7 = IfType.instances[arg0];
			for (@Pc(9) int local9 = 0; local9 < local7.anIntArray153.length && local7.anIntArray153[local9] != -1; local9++) {
				@Pc(24) IfType local24 = IfType.instances[local7.anIntArray153[local9]];
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
						@Pc(71) SeqType local71 = SeqType.instances[local59];
						local24.anInt469 += arg1;
						while (local24.anInt469 > local71.frameDelay[local24.anInt468]) {
							local24.anInt469 -= local71.frameDelay[local24.anInt468] + 1;
							local24.anInt468++;
							if (local24.anInt468 >= local71.frameCount) {
								local24.anInt468 -= local71.loopFrameCount;
								if (local24.anInt468 < 0 || local24.anInt468 >= local71.frameCount) {
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
			if (arg0 == 0 && this.stickyChatInterfaceId != -1) {
				this.modalMessage = arg1;
				super.mouseClickButton = 0;
			}
			if (this.chatInterfaceId == -1) {
				this.redrawChatback = true;
			}
			for (@Pc(20) int local20 = 99; local20 > 0; local20--) {
				this.messageType[local20] = this.messageType[local20 - 1];
				this.messageSender[local20] = this.messageSender[local20 - 1];
				this.messageText[local20] = this.messageText[local20 - 1];
			}
			this.messageType[0] = arg0;
			this.messageSender[0] = arg3;
			if (arg2 != 4) {
				this.aBoolean55 = !this.aBoolean55;
			}
			this.messageText[0] = arg1;
		} catch (@Pc(83) RuntimeException local83) {
			signlink.reporterror("40788, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local83.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(II)V")
	private void method173(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) IfType local3 = IfType.instances[arg1];
			for (@Pc(5) int local5 = 0; local5 < local3.anIntArray153.length && local3.anIntArray153[local5] != -1; local5++) {
				@Pc(20) IfType local20 = IfType.instances[local3.anIntArray153[local5]];
				if (local20.anInt472 == 1) {
					this.method173(-321, local20.anInt470);
				}
				local20.anInt468 = 0;
				local20.anInt469 = 0;
			}
			if (arg0 >= 0) {
				this.levelObjStacks = null;
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
				for (local6 = 0; local6 < this.friendCount; local6++) {
					if (this.friendName37[local6] == arg1) {
						this.friendCount--;
						this.redrawSidebar = true;
						for (@Pc(38) int local38 = local6; local38 < this.friendCount; local38++) {
							this.friendName[local38] = this.friendName[local38 + 1];
							this.friendWorld[local38] = this.friendWorld[local38 + 1];
							this.friendName37[local38] = this.friendName37[local38 + 1];
						}
						this.out.method380((byte) -34, 11);
						this.out.method387(true, arg1);
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
	private boolean method175(@OriginalArg(0) IfType arg0, @OriginalArg(1) int arg1) {
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
				this.out.method381(82);
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
				this.levelObjStacks = null;
			}
			if (super.mouseClickButton == 1) {
				@Pc(17) int local17 = super.mouseClickX - 21 - 561;
				@Pc(24) int local24 = super.mouseClickY - 9 - 5;
				if (local17 >= 0 && local24 >= 0 && local17 < 146 && local24 < 151) {
					local17 -= 73;
					local24 -= 75;
					@Pc(44) int local44 = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
					@Pc(48) int local48 = Draw3D.sin[local44];
					@Pc(52) int local52 = Draw3D.cos[local44];
					@Pc(61) int local61 = local48 * (this.minimapZoom + 256) >> 8;
					@Pc(70) int local70 = local52 * (this.minimapZoom + 256) >> 8;
					@Pc(80) int local80 = local24 * local61 + local17 * local70 >> 11;
					@Pc(90) int local90 = local24 * local70 - local17 * local61 >> 11;
					@Pc(98) int local98 = this.localPlayer.x + local80 >> 7;
					@Pc(106) int local106 = this.localPlayer.z - local90 >> 7;
					@Pc(129) boolean local129 = this.method168(this.localPlayer.pathTileX[0], 0, true, local98, this.localPlayer.pathTileZ[0], 0, 1, 0, local106, 0, 0, 0);
					if (local129) {
						// the additional 14-bytes in MOVE_MINIMAPCLICK
						this.out.method381(local17);
						this.out.method381(local24);
						this.out.method382(this.orbitCameraYaw);
						this.out.method381(57);
						this.out.method381(this.minimapAnticheatAngle);
						this.out.method381(this.minimapZoom);
						this.out.method381(89);
						this.out.method382(this.localPlayer.x);
						this.out.method382(this.localPlayer.z);
						this.out.method381(this.tryMoveNearest);
						this.out.method381(63);
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
				this.packetType = this.in.method391();
			}
			if (this.objDragArea == 0) {
				@Pc(14) int local14 = super.mouseClickButton;
				if (this.spellSelected == 1 && super.mouseClickX >= 520 && super.mouseClickY >= 165 && super.mouseClickX <= 788 && super.mouseClickY <= 230) {
					local14 = 0;
				}
				@Pc(45) int local45;
				@Pc(48) int local48;
				@Pc(124) int local124;
				if (this.menuVisible) {
					if (local14 != 1) {
						local45 = super.mouseX;
						local48 = super.mouseY;
						if (this.menuArea == 0) {
							local45 -= 8;
							local48 -= 11;
						}
						if (this.menuArea == 1) {
							local45 -= 562;
							local48 -= 231;
						}
						if (this.menuArea == 2) {
							local45 -= 22;
							local48 -= 375;
						}
						if (local45 < this.menuX - 10 || local45 > this.menuX + this.menuWidth + 10 || local48 < this.menuY - 10 || local48 > this.menuY + this.menuHeight + 10) {
							this.menuVisible = false;
							if (this.menuArea == 1) {
								this.redrawSidebar = true;
							}
							if (this.menuArea == 2) {
								this.redrawChatback = true;
							}
						}
					}
					if (local14 == 1) {
						local45 = this.menuX;
						local48 = this.menuY;
						local124 = this.menuWidth;
						@Pc(127) int local127 = super.mouseClickX;
						@Pc(130) int local130 = super.mouseClickY;
						if (this.menuArea == 0) {
							local127 -= 8;
							local130 -= 11;
						}
						if (this.menuArea == 1) {
							local127 -= 562;
							local130 -= 231;
						}
						if (this.menuArea == 2) {
							local127 -= 22;
							local130 -= 375;
						}
						@Pc(149) int local149 = -1;
						for (@Pc(151) int local151 = 0; local151 < this.menuSize; local151++) {
							@Pc(166) int local166 = local48 + (this.menuSize - 1 - local151) * 15 + 31;
							if (local127 > local45 && local127 < local45 + local124 && local130 > local166 - 13 && local130 < local166 + 3) {
								local149 = local151;
							}
						}
						if (local149 != -1) {
							this.method132(6412, local149);
						}
						this.menuVisible = false;
						if (this.menuArea == 1) {
							this.redrawSidebar = true;
						}
						if (this.menuArea == 2) {
							this.redrawChatback = true;
							return;
						}
					}
				} else {
					if (local14 == 1 && this.menuSize > 0) {
						local45 = this.menuAction[this.menuSize - 1];
						if (local45 == 602 || local45 == 596 || local45 == 22 || local45 == 892 || local45 == 415 || local45 == 405 || local45 == 38 || local45 == 422 || local45 == 478 || local45 == 347 || local45 == 188) {
							local48 = this.menuParamB[this.menuSize - 1];
							local124 = this.menuParamC[this.menuSize - 1];
							@Pc(283) IfType local283 = IfType.instances[local124];
							if (local283.inventoryDraggable) {
								this.objGrabThreshold = false;
								this.objDragCycles = 0;
								this.objDragInterfaceId = local124;
								this.objDragSlot = local48;
								this.objDragArea = 2;
								this.objGrabX = super.mouseClickX;
								this.objGrabY = super.mouseClickY;
								if (IfType.instances[local124].parentId == this.viewportInterfaceID) {
									this.objDragArea = 1;
								}
								if (IfType.instances[local124].parentId == this.chatInterfaceId) {
									this.objDragArea = 3;
								}
								return;
							}
						}
					}
					if (local14 == 1 && (this.mouseButtonsOption == 1 || this.method131(145, this.menuSize - 1)) && this.menuSize > 2) {
						local14 = 2;
					}
					if (local14 == 1 && this.menuSize > 0) {
						this.method132(6412, this.menuSize - 1);
					}
					if (local14 != 2 || this.menuSize <= 0) {
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
			@Pc(6) int local6 = this.cutsceneSrcLocalTileX * 128 + 64;
			@Pc(13) int local13 = this.cutsceneSrcLocalTileZ * 128 + 64;
			@Pc(26) int local26 = this.method94(this.currentLevel, this.cutsceneSrcLocalTileX, (byte) 5, this.cutsceneSrcLocalTileZ) - this.cutsceneSrcHeight;
			if (this.cameraX < local6) {
				this.cameraX += this.cutsceneMoveSpeed + (local6 - this.cameraX) * this.cutsceneMoveAcceleration / 1000;
				if (this.cameraX > local6) {
					this.cameraX = local6;
				}
			}
			if (this.cameraX > local6) {
				this.cameraX -= this.cutsceneMoveSpeed + (this.cameraX - local6) * this.cutsceneMoveAcceleration / 1000;
				if (this.cameraX < local6) {
					this.cameraX = local6;
				}
			}
			if (this.cameraY < local26) {
				this.cameraY += this.cutsceneMoveSpeed + (local26 - this.cameraY) * this.cutsceneMoveAcceleration / 1000;
				if (this.cameraY > local26) {
					this.cameraY = local26;
				}
			}
			if (this.cameraY > local26) {
				this.cameraY -= this.cutsceneMoveSpeed + (this.cameraY - local26) * this.cutsceneMoveAcceleration / 1000;
				if (this.cameraY < local26) {
					this.cameraY = local26;
				}
			}
			if (this.cameraZ < local13) {
				this.cameraZ += this.cutsceneMoveSpeed + (local13 - this.cameraZ) * this.cutsceneMoveAcceleration / 1000;
				if (this.cameraZ > local13) {
					this.cameraZ = local13;
				}
			}
			if (this.cameraZ > local13) {
				this.cameraZ -= this.cutsceneMoveSpeed + (this.cameraZ - local13) * this.cutsceneMoveAcceleration / 1000;
				if (this.cameraZ < local13) {
					this.cameraZ = local13;
				}
			}
			local6 = this.cutsceneDstLocalTileX * 128 + 64;
			local13 = this.cutsceneDstLocalTileZ * 128 + 64;
			local26 = this.method94(this.currentLevel, this.cutsceneDstLocalTileX, (byte) 5, this.cutsceneDstLocalTileZ) - this.cutsceneDstHeight;
			@Pc(226) int local226 = local6 - this.cameraX;
			@Pc(231) int local231 = local26 - this.cameraY;
			@Pc(236) int local236 = local13 - this.cameraZ;
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
				if (this.cameraPitch < local258) {
					this.cameraPitch += this.cutsceneRotateSpeed + (local258 - this.cameraPitch) * this.cutsceneRotateAcceleration / 1000;
					if (this.cameraPitch > local258) {
						this.cameraPitch = local258;
					}
				}
				if (this.cameraPitch > local258) {
					this.cameraPitch -= this.cutsceneRotateSpeed + (this.cameraPitch - local258) * this.cutsceneRotateAcceleration / 1000;
					if (this.cameraPitch < local258) {
						this.cameraPitch = local258;
					}
				}
				@Pc(344) int local344 = local269 - this.cameraYaw;
				if (local344 > 1024) {
					local344 -= 2048;
				}
				if (local344 < -1024) {
					local344 += 2048;
				}
				if (local344 > 0) {
					this.cameraYaw += this.cutsceneRotateSpeed + local344 * this.cutsceneRotateAcceleration / 1000;
					this.cameraYaw &= 0x7FF;
				}
				if (local344 < 0) {
					this.cameraYaw -= this.cutsceneRotateSpeed + -local344 * this.cutsceneRotateAcceleration / 1000;
					this.cameraYaw &= 0x7FF;
				}
				@Pc(402) int local402 = local269 - this.cameraYaw;
				if (local402 > 1024) {
					local402 -= 2048;
				}
				if (local402 < -1024) {
					local402 += 2048;
				}
				if (local402 < 0 && local344 > 0 || local402 > 0 && local344 < 0) {
					this.cameraYaw = local269;
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
				this.anInt174 = this.randomIn.method532();
			}
			if (super.mouseClickButton == 1) {
				if (super.mouseClickX >= 549 && super.mouseClickX <= 583 && super.mouseClickY >= 195 && super.mouseClickY < 231 && this.tabInterfaceId[0] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 0;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 579 && super.mouseClickX <= 609 && super.mouseClickY >= 194 && super.mouseClickY < 231 && this.tabInterfaceId[1] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 1;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 607 && super.mouseClickX <= 637 && super.mouseClickY >= 194 && super.mouseClickY < 231 && this.tabInterfaceId[2] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 2;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 635 && super.mouseClickX <= 679 && super.mouseClickY >= 194 && super.mouseClickY < 229 && this.tabInterfaceId[3] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 3;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 676 && super.mouseClickX <= 706 && super.mouseClickY >= 194 && super.mouseClickY < 231 && this.tabInterfaceId[4] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 4;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 704 && super.mouseClickX <= 734 && super.mouseClickY >= 194 && super.mouseClickY < 231 && this.tabInterfaceId[5] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 5;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 732 && super.mouseClickX <= 766 && super.mouseClickY >= 195 && super.mouseClickY < 231 && this.tabInterfaceId[6] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 6;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 550 && super.mouseClickX <= 584 && super.mouseClickY >= 492 && super.mouseClickY < 528 && this.tabInterfaceId[7] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 7;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 582 && super.mouseClickX <= 612 && super.mouseClickY >= 492 && super.mouseClickY < 529 && this.tabInterfaceId[8] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 8;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 609 && super.mouseClickX <= 639 && super.mouseClickY >= 492 && super.mouseClickY < 529 && this.tabInterfaceId[9] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 9;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 637 && super.mouseClickX <= 681 && super.mouseClickY >= 493 && super.mouseClickY < 528 && this.tabInterfaceId[10] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 10;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 679 && super.mouseClickX <= 709 && super.mouseClickY >= 492 && super.mouseClickY < 529 && this.tabInterfaceId[11] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 11;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 706 && super.mouseClickX <= 736 && super.mouseClickY >= 492 && super.mouseClickY < 529 && this.tabInterfaceId[12] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 12;
					this.redrawSideicons = true;
				}
				if (super.mouseClickX >= 734 && super.mouseClickX <= 768 && super.mouseClickY >= 492 && super.mouseClickY < 528 && this.tabInterfaceId[13] != -1) {
					this.redrawSidebar = true;
					this.selectedTab = 13;
					this.redrawSideicons = true;
				}
				anInt232++;
				if (anInt232 > 150) {
					anInt232 = 0;
					this.out.method380((byte) -34, 233);
					this.out.method381(43);
					return;
				}
			}
		} catch (@Pc(465) RuntimeException local465) {
			signlink.reporterror("26651, " + arg0 + ", " + local465.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;B)Z")
	private boolean method180(@OriginalArg(0) IfType arg0, @OriginalArg(1) byte arg1) {
		try {
			@Pc(2) int local2 = arg0.contentType;
			if (arg1 != this.aByte9) {
				this.anInt294 = this.randomIn.method532();
			}
			if (local2 >= 1 && local2 <= 200) {
				if (local2 >= 101) {
					local2 -= 101;
				} else {
					local2--;
				}
				this.menuOption[this.menuSize] = "Remove @whi@" + this.friendName[local2];
				this.menuAction[this.menuSize] = 557;
				this.menuSize++;
				this.menuOption[this.menuSize] = "Message @whi@" + this.friendName[local2];
				this.menuAction[this.menuSize] = 679;
				this.menuSize++;
				return true;
			} else if (local2 >= 401 && local2 <= 500) {
				this.menuOption[this.menuSize] = "Remove @whi@" + arg0.text;
				this.menuAction[this.menuSize] = 556;
				this.menuSize++;
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
	private void method181(@OriginalArg(0) int arg0, @OriginalArg(1) Buffer arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 < 0) {
				arg1.method401(223);
				@Pc(14) int local14 = arg1.method402(9, 8);
				@Pc(20) int local20;
				if (local14 < this.npcCount) {
					for (local20 = local14; local20 < this.npcCount; local20++) {
						this.entityRemovalIds[this.entityRemovalCount++] = this.npcIds[local20];
					}
				}
				if (local14 > this.npcCount) {
					signlink.reporterror(this.username + " Too many npcs");
					throw new RuntimeException("eek");
				}
				this.npcCount = 0;
				for (local20 = 0; local20 < local14; local20++) {
					@Pc(72) int local72 = this.npcIds[local20];
					@Pc(77) NpcEntity local77 = this.npcs[local72];
					@Pc(82) int local82 = arg1.method402(9, 1);
					if (local82 == 0) {
						this.npcIds[this.npcCount++] = local72;
						local77.cycle = loopCycle;
					} else {
						@Pc(105) int local105 = arg1.method402(9, 2);
						if (local105 == 0) {
							this.npcIds[this.npcCount++] = local72;
							local77.cycle = loopCycle;
							this.entityUpdateIds[this.entityUpdateCount++] = local72;
						} else {
							@Pc(156) int local156;
							@Pc(166) int local166;
							if (local105 == 1) {
								this.npcIds[this.npcCount++] = local72;
								local77.cycle = loopCycle;
								local156 = arg1.method402(9, 3);
								local77.step(false, local156, (byte) 6);
								local166 = arg1.method402(9, 1);
								if (local166 == 1) {
									this.entityUpdateIds[this.entityUpdateCount++] = local72;
								}
							} else if (local105 == 2) {
								this.npcIds[this.npcCount++] = local72;
								local77.cycle = loopCycle;
								local156 = arg1.method402(9, 3);
								local77.step(true, local156, (byte) 6);
								local166 = arg1.method402(9, 3);
								local77.step(true, local166, (byte) 6);
								@Pc(224) int local224 = arg1.method402(9, 1);
								if (local224 == 1) {
									this.entityUpdateIds[this.entityUpdateCount++] = local72;
								}
							} else if (local105 == 3) {
								this.entityRemovalIds[this.entityRemovalCount++] = local72;
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
			if (this.idleTimeout > 0) {
				this.method119(-780);
			} else {
				this.areaViewport.method463((byte) 62);
				if (arg0) {
					this.method67();
				}
				this.fontPlain12.method362(144, (byte) 6, 0, "Connection lost", 257);
				this.fontPlain12.method362(143, (byte) 6, 16777215, "Connection lost", 256);
				this.fontPlain12.method362(159, (byte) 6, 0, "Please wait - attempting to reestablish", 257);
				this.fontPlain12.method362(158, (byte) 6, 16777215, "Please wait - attempting to reestablish", 256);
				this.areaViewport.method464(11, super.graphics, 8, 5193);
				this.flagSceneTileX = 0;
				@Pc(60) Connection local60 = this.connection;
				this.ingame = false;
				this.method159(this.username, this.aString14, true);
				if (!this.ingame) {
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
	private void method183(@OriginalArg(0) int arg0, @OriginalArg(1) Image8 arg1) {
		try {
			@Pc(3) short local3 = 256;
			for (@Pc(5) int local5 = 0; local5 < this.flameBuffer0.length; local5++) {
				this.flameBuffer0[local5] = 0;
			}
			@Pc(30) int local30;
			for (@Pc(20) int local20 = 0; local20 < 5000; local20++) {
				local30 = (int) (Math.random() * 128.0D * (double) local3);
				this.flameBuffer0[local30] = (int) (Math.random() * 256.0D);
			}
			@Pc(48) int local48;
			@Pc(52) int local52;
			@Pc(60) int local60;
			for (local30 = 0; local30 < 20; local30++) {
				for (local48 = 1; local48 < local3 - 1; local48++) {
					for (local52 = 1; local52 < 127; local52++) {
						local60 = local52 + (local48 << 7);
						this.flameBuffer1[local60] = (this.flameBuffer0[local60 - 1] + this.flameBuffer0[local60 + 1] + this.flameBuffer0[local60 - 128] + this.flameBuffer0[local60 + 128]) / 4;
					}
				}
				@Pc(106) int[] local106 = this.flameBuffer0;
				this.flameBuffer0 = this.flameBuffer1;
				this.flameBuffer1 = local106;
			}
			if (arg0 <= 0) {
				this.aBoolean55 = !this.aBoolean55;
			}
			if (arg1 != null) {
				local48 = 0;
				for (local52 = 0; local52 < arg1.height; local52++) {
					for (local60 = 0; local60 < arg1.width; local60++) {
						if (arg1.pixels[local48++] != 0) {
							@Pc(152) int local152 = local60 + arg1.cropX + 16;
							@Pc(159) int local159 = local52 + arg1.cropY + 16;
							@Pc(165) int local165 = local152 + (local159 << 7);
							this.flameBuffer0[local165] = 0;
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
		@Pc(9) DoublyLinkedList local9 = this.levelObjStacks[this.currentLevel][arg0][arg1];
		if (local9 == null) {
			this.scene.method493(this.currentLevel, arg0, arg1);
			return;
		}
		@Pc(21) int local21 = -99999999;
		@Pc(23) ObjEntity local23 = null;
		@Pc(27) ObjEntity local27;
		@Pc(35) int local35;
		for (local27 = (ObjEntity) local9.method456(); local27 != null; local27 = (ObjEntity) local9.method458(551)) {
			@Pc(32) ObjType local32 = ObjType.get(local27.index);
			local35 = local32.cost;
			if (local32.stackable) {
				local35 *= local27.count + 1;
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
		for (local27 = (ObjEntity) local9.method456(); local27 != null; local27 = (ObjEntity) local9.method458(551)) {
			if (local27.index != local23.index && local65 == -1) {
				local65 = local27.index;
				local69 = local27.count;
			}
			if (local27.index != local23.index && local27.index != local65 && local35 == -1) {
				local35 = local27.index;
				local71 = local27.count;
			}
		}
		@Pc(118) Model local118 = null;
		if (local65 != -1) {
			local118 = ObjType.get(local65).method58(local69);
		}
		@Pc(128) Model local128 = null;
		if (local35 != -1) {
			local128 = ObjType.get(local35).method58(local71);
		}
		@Pc(144) int local144 = arg0 + (arg1 << 7) + 1610612736;
		@Pc(148) ObjType local148 = ObjType.get(local23.index);
		this.scene.method474(local148.method58(local23.count), local118, this.method94(this.currentLevel, arg0 * 128 + 64, (byte) 5, arg1 * 128 + 64), this.currentLevel, local144, arg1, arg0, local128, 429);
	}

	@OriginalMember(owner = "client!client", name = "D", descriptor = "(I)V")
	private void method185(@OriginalArg(0) int arg0) {
		try {
			try {
				this.anInt176 = -1;
				this.aClass28_2.method460();
				this.aClass28_1.method460();
				this.aClass28_5.method460();
				this.projectiles.method460();
				Draw3D.method290(false);
				this.method144(this.aByte10);
				this.scene.method467(742);
				for (@Pc(28) int local28 = 0; local28 < 4; local28++) {
					this.levelCollisionMap[local28].method249((byte) 74);
				}
				System.gc();
				@Pc(53) SceneBuilder local53 = new SceneBuilder(104, this.levelTileFlags, 104, this.levelHeightmap, this.anInt318);
				@Pc(56) byte[] local56 = new byte[100000];
				@Pc(60) int local60 = this.sceneMapLandData.length;
				SceneBuilder.lowMemory = Scene.lowMemory;
				@Pc(73) int local73;
				@Pc(80) int local80;
				for (@Pc(64) int local64 = 0; local64 < local60; local64++) {
					local73 = this.anIntArray56[local64] >> 8;
					local80 = this.anIntArray56[local64] & 0xFF;
					if (local73 == 33 && local80 >= 71 && local80 <= 73) {
						SceneBuilder.lowMemory = false;
					}
				}
				if (SceneBuilder.lowMemory) {
					this.scene.method468(0, this.currentLevel);
				} else {
					this.scene.method468(0, 0);
				}
				this.out.method380((byte) -34, 108);
				@Pc(157) int local157;
				for (local73 = 0; local73 < local60; local73++) {
					local80 = (this.anIntArray56[local73] >> 8) * 64 - this.sceneBaseTileX;
					@Pc(143) int local143 = (this.anIntArray56[local73] & 0xFF) * 64 - this.sceneBaseTileZ;
					@Pc(148) byte[] local148 = this.sceneMapLandData[local73];
					if (local148 != null) {
						local157 = (new Buffer(363, local148)).method396();
						BZip2InputStream.method519(local56, local157, local148, local148.length - 4, 4);
						local53.method37(local56, (this.sceneCenterZoneX - 6) * 8, 1, local143, local80, (this.sceneCenterZoneZ - 6) * 8);
					} else if (this.sceneCenterZoneZ < 800) {
						local53.method36(local80, local143, 3, 64, 64);
					}
				}
				this.out.method380((byte) -34, 108);
				@Pc(225) int local225;
				for (local80 = 0; local80 < local60; local80++) {
					@Pc(216) byte[] local216 = this.aByteArrayArray2[local80];
					if (local216 != null) {
						local225 = (new Buffer(363, local216)).method396();
						BZip2InputStream.method519(local56, local225, local216, local216.length - 4, 4);
						local157 = (this.anIntArray56[local80] >> 8) * 64 - this.sceneBaseTileX;
						@Pc(259) int local259 = (this.anIntArray56[local80] & 0xFF) * 64 - this.sceneBaseTileZ;
						local53.method38(local56, this.scene, this.levelCollisionMap, this.aClass28_1, true, local259, local157);
					}
				}
				this.out.method380((byte) -34, 108);
				local53.method40(this.scene, -270, this.levelCollisionMap);
				this.areaViewport.method463((byte) 62);
				this.out.method380((byte) -34, 108);
				for (@Pc(301) LocEntity local301 = (LocEntity) this.aClass28_1.method456(); local301 != null; local301 = (LocEntity) this.aClass28_1.method458(551)) {
					if ((this.levelTileFlags[1][local301.heightmapNE][local301.heightmapNW] & 0x2) == 2) {
						local301.heightmapSW--;
						if (local301.heightmapSW < 0) {
							local301.method567();
						}
					}
				}
				for (local225 = 0; local225 < 104; local225++) {
					for (local157 = 0; local157 < 104; local157++) {
						this.method184(local225, local157);
					}
				}
				for (@Pc(361) SceneLocTemporary local361 = (SceneLocTemporary) this.aClass28_4.method456(); local361 != null; local361 = (SceneLocTemporary) this.aClass28_4.method458(551)) {
					this.method160(local361.anInt598, local361.anInt595, local361.anInt596, local361.anInt594, local361.anInt597, local361.anInt599, -27819, local361.anInt593);
				}
			} catch (@Pc(390) Exception local390) {
			}
			LocType.aClass35_1.method529();
			if (arg0 <= 0) {
				this.aBoolean72 = !this.aBoolean72;
			}
			System.gc();
			Draw3D.method291(20, -20);
		} catch (@Pc(408) RuntimeException local408) {
			signlink.reporterror("85866, " + arg0 + ", " + local408.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(I)V")
	@Override
	protected void method68(@OriginalArg(0) int arg0) {
		try {
			if (!this.errorStarted && !this.errorLoading && !this.errorHost) {
				loopCycle++;
				if (arg0 > 0) {
					if (this.ingame) {
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
			for (@Pc(8) int local8 = -1; local8 < this.playerCount; local8++) {
				if (local8 == -1) {
					local16 = this.LOCAL_PLAYER_INDEX;
				} else {
					local16 = this.playerIds[local8];
				}
				@Pc(28) PlayerEntity local28 = this.players[local16];
				if (local28 != null && local28.chatTimer > 0) {
					local28.chatTimer--;
					if (local28.chatTimer == 0) {
						local28.chat = null;
					}
				}
			}
			for (local16 = 0; local16 < this.npcCount; local16++) {
				@Pc(59) int local59 = this.npcIds[local16];
				@Pc(64) NpcEntity local64 = this.npcs[local59];
				if (local64 != null && local64.chatTimer > 0) {
					local64.chatTimer--;
					if (local64.chatTimer == 0) {
						local64.chat = null;
					}
				}
			}
		} catch (@Pc(88) RuntimeException local88) {
			signlink.reporterror("25131, " + arg0 + ", " + local88.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;ZI)I")
	private int method187(@OriginalArg(0) IfType arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg1) {
				this.aBoolean44 = !this.aBoolean44;
			}
			if (arg0.scripts == null || arg2 >= arg0.scripts.length) {
				return -2;
			}
			try {
				@Pc(26) int[] local26 = arg0.scripts[arg2];
				@Pc(28) int local28 = 0;
				@Pc(30) int local30 = 0;
				while (true) {
					@Pc(35) int local35 = local26[local30++];
					if (local35 == 0) {
						return local28;
					}
					if (local35 == 1) { // load_skill_level {skill}
						local28 += this.skillLevel[local26[local30++]];
					}
					if (local35 == 2) { // load_skill_base_level {skill}
						local28 += this.skillBaseLevel[local26[local30++]];
					}
					if (local35 == 3) { // load_skill_exp {skill}
						local28 += this.skillExperience[local26[local30++]];
					}
					@Pc(88) IfType local88;
					@Pc(95) int local95;
					@Pc(97) int local97;
					if (local35 == 4) { // load_inv_count {interface id} {obj id}
						local88 = IfType.instances[local26[local30++]];
						local95 = local26[local30++] + 1;
						for (local97 = 0; local97 < local88.inventorySlotObjId.length; local97++) {
							if (local88.inventorySlotObjId[local97] == local95) {
								local28 += local88.inventorySlotObjCount[local97];
							}
						}
					}
					if (local35 == 5) { // load_var {id}
						local28 += this.varps[local26[local30++]];
					}
					if (local35 == 6) { // load_next_level_xp {skill}
						local28 += levelExperience[this.skillBaseLevel[local26[local30++]] - 1];
					}
					if (local35 == 7) {
						local28 += this.varps[local26[local30++]] * 100 / 46875;
					}
					if (local35 == 8) { // load_combat_level
						local28 += this.localPlayer.combatLevel;
					}
					@Pc(179) int local179;
					if (local35 == 9) { // load_total_level
						for (local179 = 0; local179 < 19; local179++) {
							if (local179 == 18) {
								local179 = 20;
							}
							local28 += this.skillBaseLevel[local179];
						}
					}
					if (local35 == 10) { // load_inv_contains {interface id} {obj id}
						local88 = IfType.instances[local26[local30++]];
						local95 = local26[local30++] + 1;
						for (local97 = 0; local97 < local88.inventorySlotObjId.length; local97++) {
							if (local88.inventorySlotObjId[local97] == local95) {
								local28 += 999999999;
								break;
							}
						}
					}
					if (local35 == 11) { // load_energy
						local28 += this.energy;
					}
					if (local35 == 12) { // load_weight
						local28 += this.weightCarried;
					}
					if (local35 == 13) { // load_bool {varp} {bit: 0..31}
						local179 = this.varps[local26[local30++]];
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
			@Pc(4) Graphics local4 = this.method72(aByte16).getGraphics();
			local4.setColor(Color.black);
			local4.fillRect(0, 0, 789, 532);
			this.method65(386, 1);
			if (arg0) {
				this.method67();
			}
			@Pc(40) byte local40;
			@Pc(46) int local46;
			if (this.errorLoading) {
				this.flameActive = false;
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
			if (this.errorHost) {
				this.flameActive = false;
				local4.setFont(new Font("Helvetica", 1, 20));
				local4.setColor(Color.white);
				local4.drawString("Error - unable to load game!", 50, 50);
				local4.drawString("To play RuneScape make sure you play from", 50, 100);
				local4.drawString("http://www.runescape.com", 50, 150);
			}
			if (this.errorStarted) {
				this.flameActive = false;
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
			@Pc(8) byte[] local8 = this.archiveTitle.method536("title.dat", null, (byte) 2);
			@Pc(14) Image24 local14 = new Image24(local8, this);
			this.imageTitle0.method463((byte) 62);
			local14.method320(34676, 0, 0);
			this.imageTitle1.method463((byte) 62);
			local14.method320(34676, -661, 0);
			this.imageTitle2.method463((byte) 62);
			local14.method320(34676, -128, 0);
			this.imageTitle3.method463((byte) 62);
			local14.method320(34676, -214, -386);
			this.imageTitle4.method463((byte) 62);
			local14.method320(34676, -214, -186);
			this.imageTitle5.method463((byte) 62);
			local14.method320(34676, 0, -265);
			this.imageTitle6.method463((byte) 62);
			local14.method320(34676, -574, -265);
			this.imageTitle7.method463((byte) 62);
			if (arg0 != 5) {
				this.aBoolean55 = !this.aBoolean55;
			}
			local14.method320(34676, -128, -186);
			this.imageTitle8.method463((byte) 62);
			local14.method320(34676, -574, -186);
			@Pc(110) int[] local110 = new int[local14.width];
			for (@Pc(112) int local112 = 0; local112 < local14.height; local112++) {
				for (@Pc(116) int local116 = 0; local116 < local14.width; local116++) {
					local110[local116] = local14.pixels[local14.width + local14.width * local112 - local116 - 1];
				}
				for (@Pc(142) int local142 = 0; local142 < local14.width; local142++) {
					local14.pixels[local142 + local14.width * local112] = local110[local142];
				}
			}
			this.imageTitle0.method463((byte) 62);
			local14.method320(34676, 394, 0);
			this.imageTitle1.method463((byte) 62);
			local14.method320(34676, -267, 0);
			this.imageTitle2.method463((byte) 62);
			local14.method320(34676, 266, 0);
			this.imageTitle3.method463((byte) 62);
			local14.method320(34676, 180, -386);
			this.imageTitle4.method463((byte) 62);
			local14.method320(34676, 180, -186);
			this.imageTitle5.method463((byte) 62);
			local14.method320(34676, 394, -265);
			this.imageTitle6.method463((byte) 62);
			local14.method320(34676, -180, -265);
			this.imageTitle7.method463((byte) 62);
			local14.method320(34676, 212, -186);
			this.imageTitle8.method463((byte) 62);
			local14.method320(34676, -180, -186);
			local14 = new Image24(this.archiveTitle, "logo", 0);
			this.imageTitle2.method463((byte) 62);
			local14.method322(18, super.anInt131 / 2 - local14.width / 2 - 128, false);
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
			for (@Pc(10) LocEntity local10 = (LocEntity) this.aClass28_1.method456(); local10 != null; local10 = (LocEntity) this.aClass28_1.method458(551)) {
				@Pc(14) boolean local14 = false;
				local10.seqCycle += this.sceneDelta;
				if (local10.seqFrame == -1) {
					local10.seqFrame = 0;
					local14 = true;
				}
				label70: {
					do {
						do {
							if (local10.seqCycle <= local10.seq.frameDelay[local10.seqFrame]) {
								break label70;
							}
							local10.seqCycle -= local10.seq.frameDelay[local10.seqFrame] + 1;
							local10.seqFrame++;
							local14 = true;
						} while (local10.seqFrame < local10.seq.frameCount);
						local10.seqFrame -= local10.seq.loopFrameCount;
					} while (local10.seqFrame >= 0 && local10.seqFrame < local10.seq.frameCount);
					local10.method567();
					local14 = false;
				}
				if (local14) {
					@Pc(96) int local96 = local10.heightmapSW;
					@Pc(99) int local99 = local10.heightmapNE;
					@Pc(102) int local102 = local10.heightmapNW;
					@Pc(104) int local104 = 0;
					if (local10.heightmapSE == 0) {
						local104 = this.scene.method494(local96, local99, local102);
					}
					if (local10.heightmapSE == 1) {
						local104 = this.scene.method495(local96, local102, 3, local99);
					}
					if (local10.heightmapSE == 2) {
						local104 = this.scene.method496(local96, local99, local102);
					}
					if (local10.heightmapSE == 3) {
						local104 = this.scene.method497(local96, local99, local102);
					}
					if (local104 != 0 && (local104 >> 14 & 0x7FFF) == local10.anInt655) {
						@Pc(171) int local171 = this.levelHeightmap[local96][local99][local102];
						@Pc(182) int local182 = this.levelHeightmap[local96][local99 + 1][local102];
						@Pc(195) int local195 = this.levelHeightmap[local96][local99 + 1][local102 + 1];
						@Pc(206) int local206 = this.levelHeightmap[local96][local99][local102 + 1];
						@Pc(210) LocType local210 = LocType.method23(local10.anInt655);
						@Pc(212) int local212 = -1;
						if (local10.seqFrame != -1) {
							local212 = local10.seq.transformIds[local10.seqFrame];
						}
						@Pc(235) int local235;
						@Pc(239) int local239;
						@Pc(243) int local243;
						@Pc(258) Model local258;
						if (local10.heightmapSE == 2) {
							local235 = this.scene.method498(local96, local99, local102, local104);
							local239 = local235 & 0x1F;
							local243 = local235 >> 6;
							if (local239 == 11) {
								local239 = 10;
							}
							local258 = local210.method26(local239, local243, local171, local182, local195, local206, local212);
							this.scene.method483(local99, local258, 1, local96, local102);
						} else if (local10.heightmapSE == 1) {
							@Pc(282) Model local282 = local210.method26(4, 0, local171, local182, local195, local206, local212);
							this.scene.method485(266, local102, local99, local282, local96);
						} else if (local10.heightmapSE == 0) {
							local235 = this.scene.method498(local96, local99, local102, local104);
							local239 = local235 & 0x1F;
							local243 = local235 >> 6;
							if (local239 == 2) {
								@Pc(320) int local320 = local243 + 1 & 0x3;
								@Pc(332) Model local332 = local210.method26(2, local243 + 4, local171, local182, local195, local206, local212);
								@Pc(342) Model local342 = local210.method26(2, local320, local171, local182, local195, local206, local212);
								this.scene.method488(local332, local342, local102, this.aBoolean44, local99, local96);
							} else {
								local258 = local210.method26(local239, local243, local171, local182, local195, local206, local212);
								this.scene.method487(35568, local258, local102, local99, local96);
							}
						} else if (local10.heightmapSE == 3) {
							local235 = this.scene.method498(local96, local99, local102, local104);
							local239 = local235 >> 6;
							@Pc(400) Model local400 = local210.method26(22, local239, local171, local182, local195, local206, local212);
							this.scene.method486(local400, local102, -48639, local99, local96);
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
				this.packetType = -1;
			}
			if (arg1 != 0L) {
				for (@Pc(14) int local14 = 0; local14 < this.ignoreCount; local14++) {
					if (this.ignoreName37[local14] == arg1) {
						this.ignoreCount--;
						this.redrawSidebar = true;
						for (@Pc(34) int local34 = local14; local34 < this.ignoreCount; local34++) {
							this.ignoreName37[local34] = this.ignoreName37[local34 + 1];
						}
						this.out.method380((byte) -34, 171);
						this.out.method387(true, arg1);
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
			if (this.objSelected == 0 && this.spellSelected == 0) {
				this.menuOption[this.menuSize] = "Walk here";
				this.menuAction[this.menuSize] = 660;
				this.menuParamB[this.menuSize] = super.mouseX;
				this.menuParamC[this.menuSize] = super.mouseY;
				this.menuSize++;
			}
			@Pc(41) int local41 = -1;
			if (arg0 != 2) {
				aBoolean48 = !aBoolean48;
			}
			for (@Pc(52) int local52 = 0; local52 < Model.anInt378; local52++) {
				@Pc(58) int local58 = Model.anIntArray123[local52];
				@Pc(62) int local62 = local58 & 0x7F;
				@Pc(68) int local68 = local58 >> 7 & 0x7F;
				@Pc(74) int local74 = local58 >> 29 & 0x3;
				@Pc(80) int local80 = local58 >> 14 & 0x7FFF;
				if (local58 != local41) {
					local41 = local58;
					@Pc(218) int local218;
					if (local74 == 2 && this.scene.method498(this.currentLevel, local62, local68, local58) >= 0) {
						@Pc(100) LocType local100 = LocType.method23(local80);
						if (this.objSelected == 1) {
							this.menuOption[this.menuSize] = "Use " + this.selectedObjName + " with @cya@" + local100.name;
							this.menuAction[this.menuSize] = 450;
							this.menuParamA[this.menuSize] = local58;
							this.menuParamB[this.menuSize] = local62;
							this.menuParamC[this.menuSize] = local68;
							this.menuSize++;
						} else if (this.spellSelected != 1) {
							if (local100.aStringArray1 != null) {
								for (local218 = 4; local218 >= 0; local218--) {
									if (local100.aStringArray1[local218] != null) {
										this.menuOption[this.menuSize] = local100.aStringArray1[local218] + " @cya@" + local100.name;
										if (local218 == 0) {
											this.menuAction[this.menuSize] = 285;
										}
										if (local218 == 1) {
											this.menuAction[this.menuSize] = 504;
										}
										if (local218 == 2) {
											this.menuAction[this.menuSize] = 364;
										}
										if (local218 == 3) {
											this.menuAction[this.menuSize] = 581;
										}
										if (local218 == 4) {
											this.menuAction[this.menuSize] = 1501;
										}
										this.menuParamA[this.menuSize] = local58;
										this.menuParamB[this.menuSize] = local62;
										this.menuParamC[this.menuSize] = local68;
										this.menuSize++;
									}
								}
							}
							this.menuOption[this.menuSize] = "Examine @cya@" + local100.name;
							this.menuAction[this.menuSize] = 1175;
							this.menuParamA[this.menuSize] = local58;
							this.menuParamB[this.menuSize] = local62;
							this.menuParamC[this.menuSize] = local68;
							this.menuSize++;
						} else if ((this.anInt293 & 0x4) == 4) {
							this.menuOption[this.menuSize] = this.spellCaption + " @cya@" + local100.name;
							this.menuAction[this.menuSize] = 55;
							this.menuParamA[this.menuSize] = local58;
							this.menuParamB[this.menuSize] = local62;
							this.menuParamC[this.menuSize] = local68;
							this.menuSize++;
						}
					}
					@Pc(395) NpcEntity local395;
					if (local74 == 1) {
						@Pc(366) NpcEntity local366 = this.npcs[local80];
						if (local366.type.size == 1 && (local366.x & 0x7F) == 64 && (local366.z & 0x7F) == 64) {
							for (local218 = 0; local218 < this.npcCount; local218++) {
								local395 = this.npcs[this.npcIds[local218]];
								if (local395 != null && local395 != local366 && local395.type.size == 1 && local395.x == local366.x && local395.z == local366.z) {
									this.method95(local395.type, -641, local68, local62, this.npcIds[local218]);
								}
							}
						}
						this.method95(local366.type, -641, local68, local62, local80);
					}
					if (local74 == 0) {
						@Pc(446) PlayerEntity local446 = this.players[local80];
						if ((local446.x & 0x7F) == 64 && (local446.z & 0x7F) == 64) {
							for (local218 = 0; local218 < this.npcCount; local218++) {
								local395 = this.npcs[this.npcIds[local218]];
								if (local395 != null && local395.type.size == 1 && local395.x == local446.x && local395.z == local446.z) {
									this.method95(local395.type, -641, local68, local62, this.npcIds[local218]);
								}
							}
							for (@Pc(505) int local505 = 0; local505 < this.playerCount; local505++) {
								@Pc(515) PlayerEntity local515 = this.players[this.playerIds[local505]];
								if (local515 != null && local515 != local446 && local515.x == local446.x && local515.z == local446.z) {
									this.method163(false, local68, this.playerIds[local505], local515, local62);
								}
							}
						}
						this.method163(false, local68, local80, local446, local62);
					}
					if (local74 == 3) {
						@Pc(565) DoublyLinkedList local565 = this.levelObjStacks[this.currentLevel][local62][local68];
						if (local565 != null) {
							for (@Pc(572) ObjEntity local572 = (ObjEntity) local565.method457((byte) 2); local572 != null; local572 = (ObjEntity) local565.method459(false)) {
								@Pc(578) ObjType local578 = ObjType.get(local572.index);
								if (this.objSelected == 1) {
									this.menuOption[this.menuSize] = "Use " + this.selectedObjName + " with @lre@" + local578.aString3;
									this.menuAction[this.menuSize] = 217;
									this.menuParamA[this.menuSize] = local572.index;
									this.menuParamB[this.menuSize] = local62;
									this.menuParamC[this.menuSize] = local68;
									this.menuSize++;
								} else if (this.spellSelected != 1) {
									for (@Pc(695) int local695 = 4; local695 >= 0; local695--) {
										if (local578.aStringArray3 != null && local578.aStringArray3[local695] != null) {
											this.menuOption[this.menuSize] = local578.aStringArray3[local695] + " @lre@" + local578.aString3;
											if (local695 == 0) {
												this.menuAction[this.menuSize] = 224;
											}
											if (local695 == 1) {
												this.menuAction[this.menuSize] = 993;
											}
											if (local695 == 2) {
												this.menuAction[this.menuSize] = 99;
											}
											if (local695 == 3) {
												this.menuAction[this.menuSize] = 746;
											}
											if (local695 == 4) {
												this.menuAction[this.menuSize] = 877;
											}
											this.menuParamA[this.menuSize] = local572.index;
											this.menuParamB[this.menuSize] = local62;
											this.menuParamC[this.menuSize] = local68;
											this.menuSize++;
										} else if (local695 == 2) {
											this.menuOption[this.menuSize] = "Take @lre@" + local578.aString3;
											this.menuAction[this.menuSize] = 99;
											this.menuParamA[this.menuSize] = local572.index;
											this.menuParamB[this.menuSize] = local62;
											this.menuParamC[this.menuSize] = local68;
											this.menuSize++;
										}
									}
									this.menuOption[this.menuSize] = "Examine @lre@" + local578.aString3;
									this.menuAction[this.menuSize] = 1102;
									this.menuParamA[this.menuSize] = local572.index;
									this.menuParamB[this.menuSize] = local62;
									this.menuParamC[this.menuSize] = local68;
									this.menuSize++;
								} else if ((this.anInt293 & 0x1) == 1) {
									this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + local578.aString3;
									this.menuAction[this.menuSize] = 965;
									this.menuParamA[this.menuSize] = local572.index;
									this.menuParamB[this.menuSize] = local62;
									this.menuParamC[this.menuSize] = local68;
									this.menuSize++;
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
			this.ingame &= arg0;
			@Pc(17) int local17;
			for (@Pc(9) int local9 = -1; local9 < this.playerCount; local9++) {
				if (local9 == -1) {
					local17 = this.LOCAL_PLAYER_INDEX;
				} else {
					local17 = this.playerIds[local9];
				}
				@Pc(29) PlayerEntity local29 = this.players[local17];
				if (local29 != null) {
					this.method124(local29, (byte) -128, 1);
				}
			}
			anInt242++;
			if (anInt242 > 1406) {
				anInt242 = 0;
				this.out.method380((byte) -34, 219);
				this.out.method381(0);
				local17 = this.out.position;
				this.out.method381(162);
				this.out.method381(22);
				if ((int) (Math.random() * 2.0D) == 0) {
					this.out.method381(84);
				}
				this.out.method382(31824);
				this.out.method382(13490);
				if ((int) (Math.random() * 2.0D) == 0) {
					this.out.method381(123);
				}
				if ((int) (Math.random() * 2.0D) == 0) {
					this.out.method381(134);
				}
				this.out.method381(100);
				this.out.method381(94);
				this.out.method382(35521);
				this.out.method390(0, this.out.position - local17);
			}
		} catch (@Pc(129) RuntimeException local129) {
			signlink.reporterror("87242, " + arg0 + ", " + local129.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "r", descriptor = "(B)V")
	private void method194(@OriginalArg(0) byte arg0) {
		try {
			if (this.hintType == 2) {
				this.method152((this.hintTileZ - this.sceneBaseTileZ << 7) + this.hintOffsetZ, (this.hintTileX - this.sceneBaseTileX << 7) + this.hintOffsetX, this.anInt317, this.hintHeight * 2);
				if (arg0 != -11) {
					this.aBoolean72 = !this.aBoolean72;
				}
				if (this.projectX > -1 && loopCycle % 20 < 10) {
					this.imageHeadicons[2].method322(this.projectY - 28, this.projectX - 12, false);
				}
			}
		} catch (@Pc(68) RuntimeException local68) {
			signlink.reporterror("792, " + arg0 + ", " + local68.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IILclient!kb;)V")
	private void method195(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Buffer arg2) {
		try {
			arg2.method401(223);
			@Pc(7) int local7 = arg2.method402(9, 1);
			if (arg0 != 11522) {
				this.levelObjStacks = null;
			}
			if (local7 != 0) {
				@Pc(21) int local21 = arg2.method402(9, 2);
				if (local21 == 0) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				} else {
					@Pc(44) int local44;
					@Pc(55) int local55;
					if (local21 == 1) {
						local44 = arg2.method402(9, 3);
						this.localPlayer.step(false, local44, (byte) 6);
						local55 = arg2.method402(9, 1);
						if (local55 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
						}
					} else {
						@Pc(101) int local101;
						if (local21 == 2) {
							local44 = arg2.method402(9, 3);
							this.localPlayer.step(true, local44, (byte) 6);
							local55 = arg2.method402(9, 3);
							this.localPlayer.step(true, local55, (byte) 6);
							local101 = arg2.method402(9, 1);
							if (local101 == 1) {
								this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
							}
						} else if (local21 == 3) {
							this.currentLevel = arg2.method402(9, 2);
							local44 = arg2.method402(9, 7);
							local55 = arg2.method402(9, 7);
							local101 = arg2.method402(9, 1);
							this.localPlayer.move(false, local101 == 1, local44, local55);
							@Pc(158) int local158 = arg2.method402(9, 1);
							if (local158 == 1) {
								this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
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
				this.packetType = -1;
			}
			this.areaChatback.method463((byte) 62);
			Draw3D.lineOffset = this.areaChatbackOffsets;
			this.imageChatback.method350(0, 0, false);
			if (this.showSocialInput) {
				this.fontBold12.method362(40, (byte) 6, 0, this.socialMessage, 239);
				this.fontBold12.method362(60, (byte) 6, 128, this.socialInput + "*", 239);
			} else if (this.chatbackInput) {
				this.fontBold12.method362(40, (byte) 6, 0, "Enter amount:", 239);
				this.fontBold12.method362(60, (byte) 6, 128, this.aString7 + "*", 239);
			} else if (this.modalMessage != null) {
				this.fontBold12.method362(40, (byte) 6, 0, this.modalMessage, 239);
				this.fontBold12.method362(60, (byte) 6, 128, "Click to continue", 239);
			} else if (this.chatInterfaceId != -1) {
				this.method120(0, 0, 38682, IfType.instances[this.chatInterfaceId], 0);
			} else if (this.stickyChatInterfaceId == -1) {
				@Pc(135) BitmapFont local135 = this.fontPlain12;
				@Pc(137) int local137 = 0;
				Draw2D.method356(77, 0, 463, 789, 0);
				for (@Pc(145) int local145 = 0; local145 < 100; local145++) {
					if (this.messageText[local145] != null) {
						@Pc(157) int local157 = this.messageType[local145];
						@Pc(166) int local166 = this.anInt274 + 70 - local137 * 14;
						if (local157 == 0) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, this.messageText[local145]);
							}
							local137++;
						}
						if (local157 == 1) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 16777215, this.messageSender[local145] + ":");
								local135.method365(local135.method364(false, this.messageSender[local145]) + 12, local166, false, 255, this.messageText[local145]);
							}
							local137++;
						}
						if (local157 == 2 && (this.publicChatSetting == 0 || this.publicChatSetting == 1 && this.method199(-20, this.messageSender[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, this.messageSender[local145] + ":");
								local135.method365(local135.method364(false, this.messageSender[local145]) + 12, local166, false, 255, this.messageText[local145]);
							}
							local137++;
						}
						if ((local157 == 3 || local157 == 7) && this.anInt210 == 0 && (local157 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.method199(-20, this.messageSender[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, "From " + this.messageSender[local145] + ":");
								local135.method365(local135.method364(false, "From " + this.messageSender[local145]) + 12, local166, false, 8388608, this.messageText[local145]);
							}
							local137++;
						}
						if (local157 == 4 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.method199(-20, this.messageSender[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 8388736, this.messageSender[local145] + " " + this.messageText[local145]);
							}
							local137++;
						}
						if (local157 == 5 && this.anInt210 == 0 && this.privateChatSetting < 2) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 8388608, this.messageText[local145]);
							}
							local137++;
						}
						if (local157 == 6 && this.anInt210 == 0 && this.privateChatSetting < 2) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 0, "To " + this.messageSender[local145] + ":");
								local135.method365(local135.method364(false, "To " + this.messageSender[local145]) + 12, local166, false, 8388608, this.messageText[local145]);
							}
							local137++;
						}
						if (local157 == 8 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.method199(-20, this.messageSender[local145]))) {
							if (local166 > 0 && local166 < 110) {
								local135.method365(4, local166, false, 13350793, this.messageSender[local145] + " " + this.messageText[local145]);
							}
							local137++;
						}
					}
				}
				Draw2D.method355(0);
				this.anInt185 = local137 * 14 + 7;
				if (this.anInt185 < 78) {
					this.anInt185 = 78;
				}
				this.method111(this.anInt192, 463, 0, this.anInt185 - this.anInt274 - 77, this.anInt185, 77);
				local135.method365(4, 90, false, 0, StringUtils.formatName(0, this.username) + ":");
				local135.method365(local135.method364(false, this.username + ": ") + 6, 90, false, 255, this.aString18 + "*");
				Draw2D.method360(0, 0, 77, 479, 0);
			} else {
				this.method120(0, 0, 38682, IfType.instances[this.stickyChatInterfaceId], 0);
			}
			if (this.menuVisible && this.menuArea == 2) {
				this.method135(-961);
			}
			this.areaChatback.method464(375, super.graphics, 22, 5193);
			this.areaViewport.method463((byte) 62);
			Draw3D.lineOffset = this.areaViewportOffsets;
		} catch (@Pc(652) RuntimeException local652) {
			signlink.reporterror("15378, " + arg0 + ", " + local652.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(Z)Z")
	private boolean method197(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				this.levelObjStacks = null;
			}
			if (this.connection == null) {
				return false;
			}
			@Pc(1264) String local1264;
			@Pc(462) int local462;
			try {
				@Pc(15) int local15 = this.connection.method203();
				if (local15 == 0) {
					return false;
				}
				if (this.packetType == -1) {
					this.connection.method204(this.in.data, 0, 1);
					this.packetType = this.in.data[0] & 0xFF;
					if (this.randomIn != null) {
						this.packetType = this.packetType - this.randomIn.method532() & 0xFF;
					}
					this.packetSize = Protocol.anIntArray90[this.packetType];
					local15--;
				}
				if (this.packetSize == -1) {
					if (local15 <= 0) {
						return false;
					}
					this.connection.method204(this.in.data, 0, 1);
					this.packetSize = this.in.data[0] & 0xFF;
					local15--;
				}
				if (this.packetSize == -2) {
					if (local15 <= 1) {
						return false;
					}
					this.connection.method204(this.in.data, 0, 2);
					this.in.position = 0;
					this.packetSize = this.in.method393();
					local15 -= 2;
				}
				if (local15 < this.packetSize) {
					return false;
				}
				this.in.position = 0;
				this.connection.method204(this.in.data, 0, this.packetSize);
				this.idleNetCycles = 0;
				this.lastPacketType2 = this.lastPacketType1;
				this.lastPacketType1 = this.lastPacketType0;
				this.lastPacketType0 = this.packetType;
				@Pc(159) int local159;
				if (this.packetType == 150) {
					local159 = this.in.method393();
					@Pc(163) byte local163 = this.in.method392();
					this.varCache[local159] = local163;
					if (this.varps[local159] != local163) {
						this.varps[local159] = local163;
						this.method122(local159, 49);
						this.redrawSidebar = true;
						if (this.stickyChatInterfaceId != -1) {
							this.redrawChatback = true;
						}
					}
					this.packetType = -1;
					return true;
				}
				@Pc(211) int local211;
				@Pc(219) int local219;
				@Pc(321) int local321;
				@Pc(354) int local354;
				@Pc(207) long local207;
				if (this.packetType == 152) {
					local207 = this.in.method397(603);
					local211 = this.in.method391();
					@Pc(217) String local217 = StringUtils.formatName(0, StringUtils.fromBase37(local207, false));
					for (local219 = 0; local219 < this.friendCount; local219++) {
						if (local207 == this.friendName37[local219]) {
							if (this.friendWorld[local219] != local211) {
								this.friendWorld[local219] = local211;
								this.redrawSidebar = true;
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
					if (local217 != null && this.friendCount < 100) {
						this.friendName37[this.friendCount] = local207;
						this.friendName[this.friendCount] = local217;
						this.friendWorld[this.friendCount] = local211;
						this.friendCount++;
						this.redrawSidebar = true;
					}
					@Pc(315) boolean local315 = false;
					while (!local315) {
						local315 = true;
						for (local321 = 0; local321 < this.friendCount - 1; local321++) {
							if (this.friendWorld[local321] != nodeId && this.friendWorld[local321 + 1] == nodeId || this.friendWorld[local321] == 0 && this.friendWorld[local321 + 1] != 0) {
								local354 = this.friendWorld[local321];
								this.friendWorld[local321] = this.friendWorld[local321 + 1];
								this.friendWorld[local321 + 1] = local354;
								@Pc(376) String local376 = this.friendName[local321];
								this.friendName[local321] = this.friendName[local321 + 1];
								this.friendName[local321 + 1] = local376;
								@Pc(398) long local398 = this.friendName37[local321];
								this.friendName37[local321] = this.friendName37[local321 + 1];
								this.friendName37[local321 + 1] = local398;
								this.redrawSidebar = true;
								local315 = false;
							}
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 43) {
					this.systemUpdateTimer = this.in.method393() * 30;
					this.packetType = -1;
					return true;
				}
				@Pc(466) int local466;
				if (this.packetType == 80) {
					local159 = this.in.method391();
					local462 = this.in.method391();
					local211 = -1;
					for (local466 = 0; local466 < this.anIntArray56.length; local466++) {
						if (this.anIntArray56[local466] == (local159 << 8) + local462) {
							local211 = local466;
						}
					}
					if (local211 != -1) {
						signlink.cachesave("m" + local159 + "_" + local462, this.sceneMapLandData[local211]);
						this.sceneState = 1;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 1) {
					this.method108(this.in, this.packetSize, false);
					this.packetType = -1;
					return true;
				}
				@Pc(650) int local650;
				if (this.packetType == 237) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					if (this.sceneCenterZoneX == local159 && this.sceneCenterZoneZ == local462 && this.sceneState != 0) {
						this.packetType = -1;
						return true;
					}
					this.sceneCenterZoneX = local159;
					this.sceneCenterZoneZ = local462;
					this.sceneBaseTileX = (this.sceneCenterZoneX - 6) * 8;
					this.sceneBaseTileZ = (this.sceneCenterZoneZ - 6) * 8;
					this.sceneState = 1;
					this.areaViewport.method463((byte) 62);
					this.fontPlain12.method362(151, (byte) 6, 0, "Loading - please wait.", 257);
					this.fontPlain12.method362(150, (byte) 6, 16777215, "Loading - please wait.", 256);
					this.areaViewport.method464(11, super.graphics, 8, 5193);
					signlink.looprate(5);
					local211 = (this.packetSize - 2) / 10;
					this.sceneMapLandData = new byte[local211][];
					this.aByteArrayArray2 = new byte[local211][];
					this.anIntArray56 = new int[local211];
					this.out.method380((byte) -34, 150);
					this.out.method381(0);
					local466 = 0;
					@Pc(662) int local662;
					for (local219 = 0; local219 < local211; local219++) {
						local650 = this.in.method391();
						local321 = this.in.method391();
						local354 = this.in.method396();
						local662 = this.in.method396();
						this.anIntArray56[local219] = (local650 << 8) + local321;
						@Pc(686) byte[] local686;
						if (local354 != 0) {
							local686 = signlink.cacheload("m" + local650 + "_" + local321);
							if (local686 != null) {
								this.crc32.reset();
								this.crc32.update(local686);
								if ((int) this.crc32.getValue() != local354) {
									local686 = null;
								}
							}
							if (local686 == null) {
								this.sceneState = 0;
								this.out.method381(0);
								this.out.method381(local650);
								this.out.method381(local321);
								local466 += 3;
							} else {
								this.sceneMapLandData[local219] = local686;
							}
						}
						if (local662 != 0) {
							local686 = signlink.cacheload("l" + local650 + "_" + local321);
							if (local686 != null) {
								this.crc32.reset();
								this.crc32.update(local686);
								if ((int) this.crc32.getValue() != local662) {
									local686 = null;
								}
							}
							if (local686 == null) {
								this.sceneState = 0;
								this.out.method381(1);
								this.out.method381(local650);
								this.out.method381(local321);
								local466 += 3;
							} else {
								this.aByteArrayArray2[local219] = local686;
							}
						}
					}
					this.out.method390(0, local466);
					signlink.looprate(50);
					this.areaViewport.method463((byte) 62);
					if (this.sceneState == 0) {
						this.fontPlain12.method362(166, (byte) 6, 0, "Map area updated since last visit, so load will take longer this time only", 257);
						this.fontPlain12.method362(165, (byte) 6, 16777215, "Map area updated since last visit, so load will take longer this time only", 256);
					}
					this.areaViewport.method464(11, super.graphics, 8, 5193);
					local650 = this.sceneBaseTileX - this.anInt171;
					local321 = this.sceneBaseTileZ - this.anInt172;
					this.anInt171 = this.sceneBaseTileX;
					this.anInt172 = this.sceneBaseTileZ;
					for (local354 = 0; local354 < 8192; local354++) {
						@Pc(856) NpcEntity local856 = this.npcs[local354];
						if (local856 != null) {
							for (@Pc(860) int local860 = 0; local860 < 10; local860++) {
								local856.pathTileX[local860] -= local650;
								local856.pathTileZ[local860] -= local321;
							}
							local856.x -= local650 * 128;
							local856.z -= local321 * 128;
						}
					}
					for (local662 = 0; local662 < this.anInt203; local662++) {
						@Pc(911) PlayerEntity local911 = this.players[local662];
						if (local911 != null) {
							for (@Pc(915) int local915 = 0; local915 < 10; local915++) {
								local911.pathTileX[local915] -= local650;
								local911.pathTileZ[local915] -= local321;
							}
							local911.x -= local650 * 128;
							local911.z -= local321 * 128;
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
									this.levelObjStacks[local1004][local988][local992] = this.levelObjStacks[local1004][local998][local1002];
								} else {
									this.levelObjStacks[local1004][local988][local992] = null;
								}
							}
						}
					}
					for (@Pc(1066) SceneLocTemporary local1066 = (SceneLocTemporary) this.aClass28_4.method456(); local1066 != null; local1066 = (SceneLocTemporary) this.aClass28_4.method458(551)) {
						local1066.anInt595 -= local650;
						local1066.anInt596 -= local321;
						if (local1066.anInt595 < 0 || local1066.anInt596 < 0 || local1066.anInt595 >= 104 || local1066.anInt596 >= 104) {
							local1066.method567();
						}
					}
					if (this.flagSceneTileX != 0) {
						this.flagSceneTileX -= local650;
						this.flagSceneTileZ -= local321;
					}
					this.cutscene = false;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 197) {
					local159 = this.in.method393();
					IfType.instances[local159].aClass1_Sub3_Sub1_2 = this.localPlayer.getHeadModel(-718);
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 25) {
					this.hintType = this.in.method391();
					if (this.hintType == 1) {
						this.hintNpc = this.in.method393();
					}
					if (this.hintType >= 2 && this.hintType <= 6) {
						if (this.hintType == 2) {
							this.hintOffsetX = 64;
							this.hintOffsetZ = 64;
						}
						if (this.hintType == 3) {
							this.hintOffsetX = 0;
							this.hintOffsetZ = 64;
						}
						if (this.hintType == 4) {
							this.hintOffsetX = 128;
							this.hintOffsetZ = 64;
						}
						if (this.hintType == 5) {
							this.hintOffsetX = 64;
							this.hintOffsetZ = 0;
						}
						if (this.hintType == 6) {
							this.hintOffsetX = 64;
							this.hintOffsetZ = 128;
						}
						this.hintType = 2;
						this.hintTileX = this.in.method393();
						this.hintTileZ = this.in.method393();
						this.hintHeight = this.in.method391();
					}
					if (this.hintType == 10) {
						this.hintPlayer = this.in.method393();
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 54) {
					local1264 = this.in.method398();
					local462 = this.in.method396();
					local211 = this.in.method396();
					if (!local1264.equals(this.currentMidi) && this.midiActive && !lowMemory) {
						this.method75(false, local462, local1264, local211);
					}
					this.currentMidi = local1264;
					this.midiCrc = local462;
					this.midiSize = local211;
					this.nextMusicDelay = 0;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 142) {
					this.method119(-780);
					this.packetType = -1;
					return false;
				}
				if (this.packetType == 20) {
					local159 = this.in.method391();
					local462 = this.in.method391();
					local211 = -1;
					for (local466 = 0; local466 < this.anIntArray56.length; local466++) {
						if (this.anIntArray56[local466] == (local159 << 8) + local462) {
							local211 = local466;
						}
					}
					if (local211 != -1) {
						signlink.cachesave("l" + local159 + "_" + local462, this.aByteArrayArray2[local211]);
						this.sceneState = 1;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 19) {
					this.flagSceneTileX = 0;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 139) {
					this.localPid = this.in.method393();
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 151 || this.packetType == 23 || this.packetType == 50 || this.packetType == 191 || this.packetType == 69 || this.packetType == 49 || this.packetType == 223 || this.packetType == 42 || this.packetType == 76 || this.packetType == 59) {
					this.method83((byte) -45, this.in, this.packetType);
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 28) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					if (this.chatInterfaceId != -1) {
						this.chatInterfaceId = -1;
						this.redrawChatback = true;
					}
					if (this.chatbackInput) {
						this.chatbackInput = false;
						this.redrawChatback = true;
					}
					this.viewportInterfaceID = local159;
					this.sidebarInterfaceId = local462;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
					this.pressedContinueOption = false;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 175) {
					local159 = this.in.method393();
					local462 = this.in.method396();
					this.varCache[local159] = local462;
					if (this.varps[local159] != local462) {
						this.varps[local159] = local462;
						this.method122(local159, 49);
						this.redrawSidebar = true;
						if (this.stickyChatInterfaceId != -1) {
							this.redrawChatback = true;
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 146) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					IfType.instances[local159].anInt488 = local462;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 167) {
					local159 = this.in.method393();
					local462 = this.in.method391();
					if (local159 == 65535) {
						local159 = -1;
					}
					this.tabInterfaceId[local462] = local159;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 220) {
					local159 = this.in.method391();
					local462 = this.in.method391();
					local211 = this.in.method393();
					local466 = this.in.method393();
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
						this.in.method400(this.packetSize - 6, -110, local211, this.aByteArrayArray2[local219]);
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 133) {
					@Pc(1701) Buffer local1701 = InputTracking.method211(854);
					if (local1701 != null) {
						this.out.method380((byte) -34, 81);
						this.out.method382(local1701.position);
						this.out.method389(local1701.data, local1701.position, 0, (byte) -106);
						local1701.method379((byte) 8);
					}
					this.packetType = -1;
					return true;
				}
				@Pc(1745) IfType local1745;
				if (this.packetType == 98) {
					this.redrawSidebar = true;
					local159 = this.in.method393();
					local1745 = IfType.instances[local159];
					local211 = this.in.method391();
					for (local466 = 0; local466 < local211; local466++) {
						local1745.inventorySlotObjId[local466] = this.in.method393();
						local219 = this.in.method391();
						if (local219 == 255) {
							local219 = this.in.method396();
						}
						local1745.inventorySlotObjCount[local466] = local219;
					}
					for (local219 = local211; local219 < local1745.inventorySlotObjId.length; local219++) {
						local1745.inventorySlotObjId[local219] = 0;
						local1745.inventorySlotObjCount[local219] = 0;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 226) {
					InputTracking.method208(-31717);
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 243) {
					this.showSocialInput = false;
					this.chatbackInput = true;
					this.aString7 = "";
					this.redrawChatback = true;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 15) {
					local159 = this.in.method393();
					local1745 = IfType.instances[local159];
					for (local211 = 0; local211 < local1745.inventorySlotObjId.length; local211++) {
						local1745.inventorySlotObjId[local211] = -1;
						local1745.inventorySlotObjId[local211] = 0;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 140) {
					this.lastAddress = this.in.method396();
					this.daysSinceLastLogin = this.in.method393();
					this.daysSinceRecoveriesChanged = this.in.method391();
					this.unreadMessages = this.in.method393();
					if (this.lastAddress != 0 && this.viewportInterfaceID == -1) {
						signlink.dnslookup(StringUtils.method541(-946, this.lastAddress));
						this.method77((byte) -60);
						@Pc(1915) short local1915 = 650;
						if (this.daysSinceRecoveriesChanged != 201) {
							local1915 = 655;
						}
						this.reportAbuseInput = "";
						this.reportAbuseMuteOption = false;
						for (local462 = 0; local462 < IfType.instances.length; local462++) {
							if (IfType.instances[local462] != null && IfType.instances[local462].contentType == local1915) {
								this.viewportInterfaceID = IfType.instances[local462].parentId;
								break;
							}
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 126) {
					this.flashingTab = this.in.method391();
					if (this.flashingTab == this.selectedTab) {
						if (this.flashingTab == 3) {
							this.selectedTab = 1;
						} else {
							this.selectedTab = 3;
						}
						this.redrawSidebar = true;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 212) {
					if (this.midiActive && !lowMemory) {
						local159 = this.in.method393();
						local462 = this.in.method396();
						local211 = this.packetSize - 6;
						@Pc(2018) byte[] local2018 = new byte[local462];
						BZip2InputStream.method519(local2018, local462, this.in.data, local211, this.in.position);
						this.method113(local2018, 625, local462, false);
						this.nextMusicDelay = local159;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 254) {
					this.anInt276 = this.in.method391();
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 12) {
					local159 = this.in.method393();
					local462 = this.in.method391();
					local211 = this.in.method393();
					if (this.waveEnabled && !lowMemory && this.waveCount < 50) {
						this.waveIds[this.waveCount] = local159;
						this.waveLoops[this.waveCount] = local462;
						this.waveDelay[this.waveCount] = local211 + SoundTrack.delays[local159];
						this.waveCount++;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 204) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					@Pc(2130) NpcType local2130 = NpcType.method32(local462);
					IfType.instances[local159].aClass1_Sub3_Sub1_2 = local2130.method35(false);
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 7) {
					this.baseX = this.in.method391();
					this.baseZ = this.in.method391();
					this.packetType = -1;
					return true;
				}
				@Pc(2181) IfType local2181;
				if (this.packetType == 103) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					local211 = this.in.method393();
					local2181 = IfType.instances[local159];
					@Pc(2184) Model local2184 = local2181.aClass1_Sub3_Sub1_2;
					if (local2184 != null) {
						local2184.recolor(local462, local211);
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 32) {
					this.publicChatSetting = this.in.method391();
					this.privateChatSetting = this.in.method391();
					this.tradeChatSetting = this.in.method391();
					this.redrawPrivacySettings = true;
					this.redrawChatback = true;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 195) {
					local159 = this.in.method393();
					this.method173(-321, local159);
					if (this.chatInterfaceId != -1) {
						this.chatInterfaceId = -1;
						this.redrawChatback = true;
					}
					if (this.chatbackInput) {
						this.chatbackInput = false;
						this.redrawChatback = true;
					}
					this.sidebarInterfaceId = local159;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
					this.viewportInterfaceID = -1;
					this.pressedContinueOption = false;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 14) {
					local159 = this.in.method393();
					this.method173(-321, local159);
					if (this.sidebarInterfaceId != -1) {
						this.sidebarInterfaceId = -1;
						this.redrawSidebar = true;
						this.redrawSideicons = true;
					}
					this.chatInterfaceId = local159;
					this.redrawChatback = true;
					this.viewportInterfaceID = -1;
					this.pressedContinueOption = false;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 209) {
					local159 = this.in.method393();
					local462 = this.in.method394();
					local211 = this.in.method394();
					local2181 = IfType.instances[local159];
					local2181.anInt477 = local462;
					local2181.anInt478 = local211;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 3) {
					this.cutscene = true;
					this.cutsceneSrcLocalTileX = this.in.method391();
					this.cutsceneSrcLocalTileZ = this.in.method391();
					this.cutsceneSrcHeight = this.in.method393();
					this.cutsceneMoveSpeed = this.in.method391();
					this.cutsceneMoveAcceleration = this.in.method391();
					if (this.cutsceneMoveAcceleration >= 100) {
						this.cameraX = this.cutsceneSrcLocalTileX * 128 + 64;
						this.cameraZ = this.cutsceneSrcLocalTileZ * 128 + 64;
						this.cameraY = this.method94(this.currentLevel, this.cutsceneSrcLocalTileX, (byte) 5, this.cutsceneSrcLocalTileZ) - this.cutsceneSrcHeight;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 135) {
					this.baseX = this.in.method391();
					this.baseZ = this.in.method391();
					for (local159 = this.baseX; local159 < this.baseX + 8; local159++) {
						for (local462 = this.baseZ; local462 < this.baseZ + 8; local462++) {
							if (this.levelObjStacks[this.currentLevel][local159][local462] != null) {
								this.levelObjStacks[this.currentLevel][local159][local462] = null;
								this.method184(local159, local462);
							}
						}
					}
					for (@Pc(2487) SceneLocTemporary local2487 = (SceneLocTemporary) this.aClass28_4.method456(); local2487 != null; local2487 = (SceneLocTemporary) this.aClass28_4.method458(551)) {
						if (local2487.anInt595 >= this.baseX && local2487.anInt595 < this.baseX + 8 && local2487.anInt596 >= this.baseZ && local2487.anInt596 < this.baseZ + 8 && local2487.anInt593 == this.currentLevel) {
							this.method160(local2487.anInt601, local2487.anInt595, local2487.anInt596, local2487.anInt594, local2487.anInt600, local2487.anInt602, -27819, local2487.anInt593);
							local2487.method567();
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 132) {
					local159 = this.in.method391();
					local462 = this.in.method391();
					local211 = this.in.method393();
					local466 = this.in.method393();
					local219 = -1;
					for (local650 = 0; local650 < this.anIntArray56.length; local650++) {
						if (this.anIntArray56[local650] == (local159 << 8) + local462) {
							local219 = local650;
						}
					}
					if (local219 != -1) {
						if (this.sceneMapLandData[local219] == null || this.sceneMapLandData[local219].length != local466) {
							this.sceneMapLandData[local219] = new byte[local466];
						}
						this.in.method400(this.packetSize - 6, -110, local211, this.sceneMapLandData[local219]);
					}
					this.packetType = -1;
					return true;
				}
				@Pc(2652) boolean local2652;
				if (this.packetType == 41) {
					local207 = this.in.method397(603);
					local211 = this.in.method396();
					local466 = this.in.method391();
					local2652 = false;
					for (local650 = 0; local650 < 100; local650++) {
						if (this.anIntArray48[local650] == local211) {
							local2652 = true;
							break;
						}
					}
					if (local466 <= 1) {
						for (local321 = 0; local321 < this.ignoreCount; local321++) {
							if (this.ignoreName37[local321] == local207) {
								local2652 = true;
								break;
							}
						}
					}
					if (!local2652 && this.overrideChat == 0) {
						try {
							this.anIntArray48[this.anInt219] = local211;
							this.anInt219 = (this.anInt219 + 1) % 100;
							@Pc(2721) String local2721 = ChatCompression.method545(this.in, 118, this.packetSize - 13);
							@Pc(2725) String local2725 = Censor.method424(local2721, 0);
							if (local466 > 1) {
								this.method172(7, local2725, (byte) 4, StringUtils.formatName(0, StringUtils.fromBase37(local207, false)));
							} else {
								this.method172(3, local2725, (byte) 4, StringUtils.formatName(0, StringUtils.fromBase37(local207, false)));
							}
						} catch (@Pc(2752) Exception local2752) {
							signlink.reporterror("cde1");
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 193) {
					for (local159 = 0; local159 < this.varps.length; local159++) {
						if (this.varps[local159] != this.varCache[local159]) {
							this.varps[local159] = this.varCache[local159];
							this.method122(local159, 49);
							this.redrawSidebar = true;
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 87) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					IfType.instances[local159].aClass1_Sub3_Sub1_2 = new Model(false, local462);
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 185) {
					local159 = this.in.method394();
					this.stickyChatInterfaceId = local159;
					this.redrawChatback = true;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 68) {
					if (this.selectedTab == 12) {
						this.redrawSidebar = true;
					}
					this.energy = this.in.method391();
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 74) {
					this.cutscene = true;
					this.cutsceneDstLocalTileX = this.in.method391();
					this.cutsceneDstLocalTileZ = this.in.method391();
					this.cutsceneDstHeight = this.in.method393();
					this.cutsceneRotateSpeed = this.in.method391();
					this.cutsceneRotateAcceleration = this.in.method391();
					if (this.cutsceneRotateAcceleration >= 100) {
						local159 = this.cutsceneDstLocalTileX * 128 + 64;
						local462 = this.cutsceneDstLocalTileZ * 128 + 64;
						local211 = this.method94(this.currentLevel, this.cutsceneDstLocalTileX, (byte) 5, this.cutsceneDstLocalTileZ) - this.cutsceneDstHeight;
						local466 = local159 - this.cameraX;
						local219 = local211 - this.cameraY;
						local650 = local462 - this.cameraZ;
						local321 = (int) Math.sqrt((double) (local466 * local466 + local650 * local650));
						this.cameraPitch = (int) (Math.atan2((double) local219, (double) local321) * 325.949D) & 0x7FF;
						this.cameraYaw = (int) (Math.atan2((double) local466, (double) local650) * -325.949D) & 0x7FF;
						if (this.cameraPitch < 128) {
							this.cameraPitch = 128;
						}
						if (this.cameraPitch > 383) {
							this.cameraPitch = 383;
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 84) {
					this.selectedTab = this.in.method391();
					this.redrawSidebar = true;
					this.redrawSideicons = true;
					this.packetType = -1;
					return true;
				}
				@Pc(3040) String local3040;
				if (this.packetType == 4) {
					local1264 = this.in.method398();
					@Pc(3043) long local3043;
					if (local1264.endsWith(":tradereq:")) {
						local3040 = local1264.substring(0, local1264.indexOf(":"));
						local3043 = StringUtils.method538(local3040);
						local2652 = false;
						for (local650 = 0; local650 < this.ignoreCount; local650++) {
							if (this.ignoreName37[local650] == local3043) {
								local2652 = true;
								break;
							}
						}
						if (!local2652 && this.overrideChat == 0) {
							this.method172(4, "wishes to trade with you.", (byte) 4, local3040);
						}
					} else if (local1264.endsWith(":duelreq:")) {
						local3040 = local1264.substring(0, local1264.indexOf(":"));
						local3043 = StringUtils.method538(local3040);
						local2652 = false;
						for (local650 = 0; local650 < this.ignoreCount; local650++) {
							if (this.ignoreName37[local650] == local3043) {
								local2652 = true;
								break;
							}
						}
						if (!local2652 && this.overrideChat == 0) {
							this.method172(8, "wishes to duel with you.", (byte) 4, local3040);
						}
					} else {
						this.method172(0, local1264, (byte) 4, "");
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 46) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					local211 = this.in.method393();
					@Pc(3157) ObjType local3157 = ObjType.get(local462);
					IfType.instances[local159].aClass1_Sub3_Sub1_2 = local3157.method58(50);
					IfType.instances[local159].modelPitch = local3157.iconPitch;
					IfType.instances[local159].modelYaw = local3157.iconYaw;
					IfType.instances[local159].modelZoo = local3157.iconZoom * 100 / local211;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 168) {
					local159 = this.in.method393();
					this.method173(-321, local159);
					if (this.sidebarInterfaceId != -1) {
						this.sidebarInterfaceId = -1;
						this.redrawSidebar = true;
						this.redrawSideicons = true;
					}
					if (this.chatInterfaceId != -1) {
						this.chatInterfaceId = -1;
						this.redrawChatback = true;
					}
					if (this.chatbackInput) {
						this.chatbackInput = false;
						this.redrawChatback = true;
					}
					this.viewportInterfaceID = local159;
					this.pressedContinueOption = false;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 2) {
					local159 = this.in.method393();
					local462 = this.in.method393();
					local211 = local462 >> 10 & 0x1F;
					local466 = local462 >> 5 & 0x1F;
					local219 = local462 & 0x1F;
					IfType.instances[local159].color = (local211 << 19) + (local466 << 11) + (local219 << 3);
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 136) {
					for (local159 = 0; local159 < this.players.length; local159++) {
						if (this.players[local159] != null) {
							this.players[local159].primarySeqId = -1;
						}
					}
					for (local462 = 0; local462 < this.npcs.length; local462++) {
						if (this.npcs[local462] != null) {
							this.npcs[local462].primarySeqId = -1;
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 26) {
					local159 = this.in.method393();
					@Pc(3362) boolean local3362 = this.in.method391() == 1;
					IfType.instances[local159].aBoolean106 = local3362;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 21) {
					this.ignoreCount = this.packetSize / 8;
					for (local159 = 0; local159 < this.ignoreCount; local159++) {
						this.ignoreName37[local159] = this.in.method397(603);
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 239) {
					this.cutscene = false;
					for (local159 = 0; local159 < 5; local159++) {
						this.cameraModifierEnabled[local159] = false;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 129) {
					if (this.sidebarInterfaceId != -1) {
						this.sidebarInterfaceId = -1;
						this.redrawSidebar = true;
						this.redrawSideicons = true;
					}
					if (this.chatInterfaceId != -1) {
						this.chatInterfaceId = -1;
						this.redrawChatback = true;
					}
					if (this.chatbackInput) {
						this.chatbackInput = false;
						this.redrawChatback = true;
					}
					this.viewportInterfaceID = -1;
					this.pressedContinueOption = false;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 201) {
					local159 = this.in.method393();
					local3040 = this.in.method398();
					IfType.instances[local159].text = local3040;
					if (IfType.instances[local159].parentId == this.tabInterfaceId[this.selectedTab]) {
						this.redrawSidebar = true;
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 44) {
					this.redrawSidebar = true;
					local159 = this.in.method391();
					local462 = this.in.method396();
					local211 = this.in.method391();
					this.skillExperience[local159] = local462;
					this.skillLevel[local159] = local211;
					this.skillBaseLevel[local159] = 1;
					for (local466 = 0; local466 < 98; local466++) {
						if (local462 >= levelExperience[local466]) {
							this.skillBaseLevel[local159] = local466 + 2;
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 162) {
					this.baseX = this.in.method391();
					this.baseZ = this.in.method391();
					while (this.in.position < this.packetSize) {
						local159 = this.in.method391();
						this.method83((byte) -45, this.in, local159);
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 22) {
					if (this.selectedTab == 12) {
						this.redrawSidebar = true;
					}
					this.weightCarried = this.in.method394();
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 13) {
					local159 = this.in.method391();
					local462 = this.in.method391();
					local211 = this.in.method391();
					local466 = this.in.method391();
					this.cameraModifierEnabled[local159] = true;
					this.cameraModifierJitter[local159] = local462;
					this.cameraModifierWobbleScale[local159] = local211;
					this.cameraModifierWobbleSpeed[local159] = local466;
					this.cameraModifierCycle[local159] = 0;
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 213) {
					this.redrawSidebar = true;
					local159 = this.in.method393();
					local1745 = IfType.instances[local159];
					while (this.in.position < this.packetSize) {
						local211 = this.in.method391();
						local466 = this.in.method393();
						local219 = this.in.method391();
						if (local219 == 255) {
							local219 = this.in.method396();
						}
						if (local211 >= 0 && local211 < local1745.inventorySlotObjId.length) {
							local1745.inventorySlotObjId[local211] = local466;
							local1745.inventorySlotObjCount[local211] = local219;
						}
					}
					this.packetType = -1;
					return true;
				}
				if (this.packetType == 184) {
					this.method170(this.in, this.packetSize, 822);
					if (this.sceneState == 1) {
						this.sceneState = 2;
						SceneBuilder.anInt81 = this.currentLevel;
						this.method185(869);
					}
					if (lowMemory && this.sceneState == 2 && SceneBuilder.anInt81 != this.currentLevel) {
						this.areaViewport.method463((byte) 62);
						this.fontPlain12.method362(151, (byte) 6, 0, "Loading - please wait.", 257);
						this.fontPlain12.method362(150, (byte) 6, 16777215, "Loading - please wait.", 256);
						this.areaViewport.method464(11, super.graphics, 8, 5193);
						SceneBuilder.anInt81 = this.currentLevel;
						this.method185(869);
					}
					if (this.currentLevel != this.anInt176 && this.sceneState == 2) {
						this.anInt176 = this.currentLevel;
						this.method106(this.currentLevel, -153);
					}
					this.packetType = -1;
					return true;
				}
				signlink.reporterror("T1 - " + this.packetType + "," + this.packetSize + " - " + this.lastPacketType1 + "," + this.lastPacketType2);
				this.method119(-780);
			} catch (@Pc(3862) IOException local3862) {
				this.method182(false);
			} catch (@Pc(3867) Exception local3867) {
				local1264 = "T2 - " + this.packetType + "," + this.lastPacketType1 + "," + this.lastPacketType2 + " - " + this.packetSize + "," + (this.sceneBaseTileX + this.localPlayer.pathTileX[0]) + "," + (this.sceneBaseTileZ + this.localPlayer.pathTileZ[0]) + " - ";
				for (local462 = 0; local462 < this.packetSize && local462 < 50; local462++) {
					local1264 = local1264 + this.in.data[local462] + ",";
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
			this.areaSidebar.method463((byte) 62);
			Draw3D.lineOffset = this.areaSidebarOffsets;
			this.imageInvback.method350(0, 0, false);
			if (this.sidebarInterfaceId != -1) {
				this.method120(0, 0, 38682, IfType.instances[this.sidebarInterfaceId], 0);
			} else if (this.tabInterfaceId[this.selectedTab] != -1) {
				this.method120(0, 0, 38682, IfType.instances[this.tabInterfaceId[this.selectedTab]], 0);
			}
			if (this.menuVisible && this.menuArea == 1) {
				this.method135(-961);
			}
			this.areaSidebar.method464(231, super.graphics, 562, 5193);
			if (arg0 == 2) {
				@Pc(73) boolean local73 = false;
				this.areaViewport.method463((byte) 62);
				Draw3D.lineOffset = this.areaViewportOffsets;
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
				this.out.method381(74);
			}
			if (arg1 == null) {
				return false;
			}
			for (@Pc(15) int local15 = 0; local15 < this.friendCount; local15++) {
				if (arg1.equalsIgnoreCase(this.friendName[local15])) {
					return true;
				}
			}
			if (arg1.equalsIgnoreCase(this.localPlayer.name)) {
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
		nodeId = Integer.parseInt(this.getParameter("nodeid"));
		portOffset = Integer.parseInt(this.getParameter("portoff"));
		@Pc(15) String local15 = this.getParameter("lowmem");
		if (local15 != null && local15.equals("1")) {
			method88(true);
		} else {
			method167(9);
		}
		@Pc(31) String local31 = this.getParameter("free");
		if (local31 != null && local31.equals("1")) {
			members = false;
		} else {
			members = true;
		}
		this.method63(532, false, 789);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!kb;Lclient!z;)V")
	private void method200(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Buffer arg3, @OriginalArg(4) PlayerEntity arg4) {
		try {
			if (!arg0) {
				this.aBoolean44 = !this.aBoolean44;
			}
			@Pc(19) int local19;
			if ((arg2 & 0x1) == 1) {
				local19 = arg3.method391();
				@Pc(22) byte[] local22 = new byte[local19];
				@Pc(28) Buffer local28 = new Buffer(363, local22);
				arg3.method400(local19, -110, 0, local22);
				this.playerAppearanceBuffer[arg1] = local28;
				arg4.method572(false, local28);
			}
			@Pc(66) int local66;
			if ((arg2 & 0x2) == 2) {
				local19 = arg3.method393();
				if (local19 == 65535) {
					local19 = -1;
				}
				if (local19 == arg4.primarySeqId) {
					arg4.primarySeqLoop = 0;
				}
				local66 = arg3.method391();
				if (local19 == -1 || arg4.primarySeqId == -1 || SeqType.instances[local19].idleStyle > SeqType.instances[arg4.primarySeqId].idleStyle || SeqType.instances[arg4.primarySeqId].idleStyle == 0) {
					arg4.primarySeqId = local19;
					arg4.primarySeqFrame = 0;
					arg4.primarySeqCycle = 0;
					arg4.primarySeqDelay = local66;
					arg4.primarySeqLoop = 0;
				}
			}
			if ((arg2 & 0x4) == 4) {
				arg4.targetId = arg3.method393();
				if (arg4.targetId == 65535) {
					arg4.targetId = -1;
				}
			}
			if ((arg2 & 0x8) == 8) {
				arg4.chat = arg3.method398();
				arg4.chatColor = 0;
				arg4.chatStyle = 0;
				arg4.chatTimer = 150;
				this.method172(2, arg4.chat, (byte) 4, arg4.name);
			}
			if ((arg2 & 0x10) == 16) {
				arg4.damage = arg3.method391();
				arg4.damageType = arg3.method391();
				arg4.combatCycle = loopCycle + 400;
				arg4.health = arg3.method391();
				arg4.totalHealth = arg3.method391();
			}
			if ((arg2 & 0x20) == 32) {
				arg4.targetTileX = arg3.method393();
				arg4.targetTileZ = arg3.method393();
			}
			if ((arg2 & 0x40) == 64) {
				local19 = arg3.method393();
				local66 = arg3.method391();
				@Pc(199) int local199 = arg3.method391();
				@Pc(202) int local202 = arg3.position;
				if (arg4.name != null) {
					@Pc(209) long local209 = StringUtils.method538(arg4.name);
					@Pc(211) boolean local211 = false;
					if (local66 <= 1) {
						for (@Pc(216) int local216 = 0; local216 < this.ignoreCount; local216++) {
							if (this.ignoreName37[local216] == local209) {
								local211 = true;
								break;
							}
						}
					}
					if (!local211 && this.overrideChat == 0) {
						try {
							@Pc(244) String local244 = ChatCompression.method545(arg3, 118, local199);
							@Pc(248) String local248 = Censor.method424(local244, 0);
							arg4.chat = local248;
							arg4.chatColor = local19 >> 8;
							arg4.chatStyle = local19 & 0xFF;
							arg4.chatTimer = 150;
							if (local66 > 1) {
								this.method172(1, local248, (byte) 4, arg4.name);
							} else {
								this.method172(2, local248, (byte) 4, arg4.name);
							}
						} catch (@Pc(285) Exception local285) {
							signlink.reporterror("cde2");
						}
					}
				}
				arg3.position = local202 + local199;
			}
			if ((arg2 & 0x100) == 256) {
				arg4.spotanimId = arg3.method393();
				local19 = arg3.method396();
				arg4.spotanimOffset = local19 >> 16;
				arg4.spotanimLastCycle = loopCycle + (local19 & 0xFFFF);
				arg4.spotanimFrame = 0;
				arg4.spotanimCycle = 0;
				if (arg4.spotanimLastCycle > loopCycle) {
					arg4.spotanimFrame = -1;
				}
				if (arg4.spotanimId == 65535) {
					arg4.spotanimId = -1;
				}
			}
			if ((arg2 & 0x200) == 512) {
				arg4.forceMoveStartSceneTileX = arg3.method391();
				arg4.forceMoveStartSceneTileZ = arg3.method391();
				arg4.forceMoveEndSceneTileX = arg3.method391();
				arg4.forceMoveEndSceneTileZ = arg3.method391();
				arg4.forceMoveEndCycle = arg3.method393() + loopCycle;
				arg4.forceMoveStartCycle = arg3.method393() + loopCycle;
				arg4.forceMoveFaceDirection = arg3.method391();
				arg4.pathLength = 0;
				arg4.pathTileX[0] = arg4.forceMoveEndSceneTileX;
				arg4.pathTileZ[0] = arg4.forceMoveEndSceneTileZ;
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
			if (this.archiveTitle == null) {
				super.method74(true, arg1, arg2);
			} else {
				this.imageTitle4.method463((byte) 62);
				@Pc(17) short local17 = 360;
				@Pc(19) short local19 = 200;
				@Pc(21) byte local21 = 20;
				this.fontBold12.method362(local19 / 2 - local21 - 26, (byte) 6, 16777215, "RuneScape is loading - please wait...", local17 / 2);
				this.ingame &= arg0;
				@Pc(51) int local51 = local19 / 2 - local21 - 18;
				Draw2D.method359(3, local17 / 2 - 152, 9179409, 34, local51, 304);
				Draw2D.method359(3, local17 / 2 - 151, 0, 32, local51 + 1, 302);
				Draw2D.method358(local51 + 2, local17 / 2 - 150, 9179409, (byte) 93, arg2 * 3, 30);
				Draw2D.method358(local51 + 2, local17 / 2 - 150 + arg2 * 3, 0, (byte) 93, 300 - arg2 * 3, 30);
				this.fontBold12.method362(local19 / 2 + 5 - local21, (byte) 6, 16777215, arg1, local17 / 2);
				this.imageTitle4.method464(186, super.graphics, 214, 5193);
				if (this.redrawTitleBackground) {
					this.redrawTitleBackground = false;
					if (!this.flameActive) {
						this.imageTitle0.method464(0, super.graphics, 0, 5193);
						this.imageTitle1.method464(0, super.graphics, 661, 5193);
					}
					this.imageTitle2.method464(0, super.graphics, 128, 5193);
					this.imageTitle3.method464(386, super.graphics, 214, 5193);
					this.imageTitle5.method464(265, super.graphics, 0, 5193);
					this.imageTitle6.method464(265, super.graphics, 574, 5193);
					this.imageTitle7.method464(186, super.graphics, 128, 5193);
					this.imageTitle8.method464(186, super.graphics, 574, 5193);
				}
			}
		} catch (@Pc(210) RuntimeException local210) {
			signlink.reporterror("68527, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local210.toString());
			throw new RuntimeException();
		}
	}
}
