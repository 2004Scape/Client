package jagex2.client;

import jagex2.config.*;
import jagex2.dash3d.entity.*;
import jagex2.datastruct.JString;
import jagex2.datastruct.LinkList;
import jagex2.dash3d.CollisionMap;
import jagex2.dash3d.Occluder;
import jagex2.dash3d.World3D;
import jagex2.dash3d.World;
import jagex2.graphics.*;
import jagex2.io.*;
import jagex2.dash3d.type.LocSpawned;
import jagex2.dash3d.type.LocTemporary;
import jagex2.ServerProt;
import jagex2.sound.Wave;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

@OriginalClass("client!client")
public final class Client extends GameShell {

	private static String SERVER_ADDRESS = "world2.runewiki.org";
	private static String SERVER_WEB_SCHEMA = "http:";
	private static int SERVER_WEB_PORT = 80;

	private boolean showPerformance = false;
	private boolean showOccluders = false;
	private boolean showDebug = false;

	@OriginalMember(owner = "client!client", name = "E", descriptor = "I")
	public static int opHeld1Counter;

	@OriginalMember(owner = "client!client", name = "F", descriptor = "Ljava/lang/String;")
	public static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";

	@OriginalMember(owner = "client!client", name = "G", descriptor = "I")
	private int midiSyncLen;

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
	private Packet login = Packet.alloc(1);

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
	private LinkList locList = new LinkList();

	@OriginalMember(owner = "client!client", name = "hb", descriptor = "Lclient!tb;")
	private Isaac randomIn;

	@OriginalMember(owner = "client!client", name = "ib", descriptor = "[Z")
	private final boolean[] cameraModifierEnabled = new boolean[5];

	@OriginalMember(owner = "client!client", name = "jb", descriptor = "I")
	private int privateChatSetting;

	@OriginalMember(owner = "client!client", name = "lb", descriptor = "I")
	private int selectedTab = 3;

	@OriginalMember(owner = "client!client", name = "mb", descriptor = "[[I")
	private int[][] bfsCost = new int[104][104];

	@OriginalMember(owner = "client!client", name = "ob", descriptor = "I")
	private int socialAction;

	@OriginalMember(owner = "client!client", name = "pb", descriptor = "I")
	private int sceneBaseTileX;

	@OriginalMember(owner = "client!client", name = "qb", descriptor = "I")
	private int sceneBaseTileZ;

	@OriginalMember(owner = "client!client", name = "rb", descriptor = "I")
	private int mapLastBaseX;

	@OriginalMember(owner = "client!client", name = "sb", descriptor = "I")
	private int mapLastBaseZ;

	@OriginalMember(owner = "client!client", name = "tb", descriptor = "Ljava/lang/String;")
	private String socialInput = "";

	@OriginalMember(owner = "client!client", name = "vb", descriptor = "Lclient!ob;")
	private LinkList temporaryLocs = new LinkList();

	@OriginalMember(owner = "client!client", name = "wb", descriptor = "[J")
	private final long[] ignoreName37 = new long[100];

	@OriginalMember(owner = "client!client", name = "xb", descriptor = "I")
	private int weightCarried;

	@OriginalMember(owner = "client!client", name = "yb", descriptor = "[[B")
	private byte[][] sceneMapLandData;

	@OriginalMember(owner = "client!client", name = "Ab", descriptor = "I")
	public static int opLoc4Counter;

	@OriginalMember(owner = "client!client", name = "Bb", descriptor = "[I")
	private int[] friendWorld = new int[100];

	@OriginalMember(owner = "client!client", name = "Cb", descriptor = "I")
	private int minimapLevel = -1;

	@OriginalMember(owner = "client!client", name = "Db", descriptor = "Ljava/lang/String;")
	private String socialMessage = "";

	@OriginalMember(owner = "client!client", name = "Eb", descriptor = "[Lclient!hb;")
	private Pix24[] imageHitmarks = new Pix24[20];

	@OriginalMember(owner = "client!client", name = "Fb", descriptor = "J")
	private long lastWaveStartTime;

	@OriginalMember(owner = "client!client", name = "Hb", descriptor = "I")
	private int packetSize;

	@OriginalMember(owner = "client!client", name = "Ib", descriptor = "I")
	private int packetType = -1;

	@OriginalMember(owner = "client!client", name = "Jb", descriptor = "I")
	private int idleNetCycles;

	@OriginalMember(owner = "client!client", name = "Kb", descriptor = "I")
	private int heartbeatTimer;

	@OriginalMember(owner = "client!client", name = "Lb", descriptor = "I")
	private int idleTimeout;

	@OriginalMember(owner = "client!client", name = "Mb", descriptor = "Ljava/lang/String;")
	private String chatbackInput = "";

	@OriginalMember(owner = "client!client", name = "Nb", descriptor = "I")
	private int cameraOffsetCycle;

	@OriginalMember(owner = "client!client", name = "Ob", descriptor = "I")
	private int lastWaveId = -1;

	@OriginalMember(owner = "client!client", name = "Qb", descriptor = "Z")
	private boolean updateDesignModel = false;

	@OriginalMember(owner = "client!client", name = "Rb", descriptor = "[I")
	private final int[] designIdentikits = new int[7];

	@OriginalMember(owner = "client!client", name = "Tb", descriptor = "[Lclient!hb;")
	private Pix24[] activeMapFunctions = new Pix24[1000];

	@OriginalMember(owner = "client!client", name = "Ub", descriptor = "I")
	private int chatScrollHeight = 78;

	@OriginalMember(owner = "client!client", name = "Vb", descriptor = "I")
	private int ignoreCount;

	@OriginalMember(owner = "client!client", name = "Wb", descriptor = "[[[I")
	private int[][][] levelHeightmap;

	@OriginalMember(owner = "client!client", name = "Xb", descriptor = "Lclient!kb;")
	private Packet in = Packet.alloc(1);

	@OriginalMember(owner = "client!client", name = "Zb", descriptor = "I")
	public static int opNpc5Counter;

	@OriginalMember(owner = "client!client", name = "ac", descriptor = "Lclient!kb;")
	private Packet out = Packet.alloc(1);

	@OriginalMember(owner = "client!client", name = "bc", descriptor = "Z")
	private boolean startMidiThread = false;

	@OriginalMember(owner = "client!client", name = "cc", descriptor = "I")
	private int chatEffects;

	@OriginalMember(owner = "client!client", name = "dc", descriptor = "I")
	private int hintNpc;

	@OriginalMember(owner = "client!client", name = "ec", descriptor = "I")
	private int overrideChat;

	@OriginalMember(owner = "client!client", name = "gc", descriptor = "I")
	public static int drawSceneCounter;

	@OriginalMember(owner = "client!client", name = "ic", descriptor = "I")
	public static int opHeld4Counter;

	@OriginalMember(owner = "client!client", name = "jc", descriptor = "[I")
	private final int[] skillLevel = new int[50];

	@OriginalMember(owner = "client!client", name = "kc", descriptor = "Lclient!hc;")
	private final IfType chatInterface = new IfType();

	@OriginalMember(owner = "client!client", name = "lc", descriptor = "[I")
	private final int[] waveLoops = new int[50];

	@OriginalMember(owner = "client!client", name = "mc", descriptor = "I")
	private int mouseButtonsOption;

	@OriginalMember(owner = "client!client", name = "nc", descriptor = "[I")
	private final int[] archiveChecksum = new int[9];

	@OriginalMember(owner = "client!client", name = "oc", descriptor = "Z")
	private boolean midiThreadActive = true;

	@OriginalMember(owner = "client!client", name = "qc", descriptor = "[Lclient!ib;")
	private Pix8[] imageSideicons = new Pix8[13];

	@OriginalMember(owner = "client!client", name = "rc", descriptor = "I")
	private int lastWaveLength;

	@OriginalMember(owner = "client!client", name = "sc", descriptor = "I")
	private int orbitCameraPitch = 128;

	@OriginalMember(owner = "client!client", name = "tc", descriptor = "I")
	private int orbitCameraYaw;

	@OriginalMember(owner = "client!client", name = "uc", descriptor = "I")
	private int orbitCameraYawVelocity;

	@OriginalMember(owner = "client!client", name = "vc", descriptor = "I")
	private int orbitCameraPitchVelocity;

	@OriginalMember(owner = "client!client", name = "wc", descriptor = "I")
	private final int MAX_PLAYER_COUNT = 2048;

	@OriginalMember(owner = "client!client", name = "xc", descriptor = "I")
	private final int LOCAL_PLAYER_INDEX = 2047;

	@OriginalMember(owner = "client!client", name = "yc", descriptor = "[Lclient!z;")
	private PlayerEntity[] players = new PlayerEntity[this.MAX_PLAYER_COUNT];

	@OriginalMember(owner = "client!client", name = "zc", descriptor = "I")
	private int playerCount;

	@OriginalMember(owner = "client!client", name = "Ac", descriptor = "[I")
	private int[] playerIds = new int[this.MAX_PLAYER_COUNT];

	@OriginalMember(owner = "client!client", name = "Bc", descriptor = "I")
	private int entityUpdateCount;

	@OriginalMember(owner = "client!client", name = "Cc", descriptor = "[I")
	private int[] entityUpdateIds = new int[this.MAX_PLAYER_COUNT];

	@OriginalMember(owner = "client!client", name = "Dc", descriptor = "[Lclient!kb;")
	private Packet[] playerAppearanceBuffer = new Packet[this.MAX_PLAYER_COUNT];

	@OriginalMember(owner = "client!client", name = "Ec", descriptor = "I")
	private int lastPacketType0 = -1;

	@OriginalMember(owner = "client!client", name = "Fc", descriptor = "I")
	private int lastPacketType1 = -1;

	@OriginalMember(owner = "client!client", name = "Gc", descriptor = "I")
	private int lastPacketType2 = -1;

	@OriginalMember(owner = "client!client", name = "Hc", descriptor = "Lclient!r;")
	private World3D world3D;

	@OriginalMember(owner = "client!client", name = "Ic", descriptor = "Lclient!ob;")
	private LinkList projectiles = new LinkList();

	@OriginalMember(owner = "client!client", name = "Jc", descriptor = "I")
	private int splitPrivateChat;

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
	private int[][][] levelTileFlags;

	@OriginalMember(owner = "client!client", name = "Rc", descriptor = "[I")
	private int[] flameBuffer0;

	@OriginalMember(owner = "client!client", name = "Sc", descriptor = "[I")
	private int[] flameBuffer1;

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

	@OriginalMember(owner = "client!client", name = "ad", descriptor = "[I")
	private final int[] flameLineOffset = new int[256];

	@OriginalMember(owner = "client!client", name = "cd", descriptor = "Lclient!qb;")
	private PixMap areaBackbase1;

	@OriginalMember(owner = "client!client", name = "dd", descriptor = "Lclient!qb;")
	private PixMap areaBackbase2;

	@OriginalMember(owner = "client!client", name = "ed", descriptor = "Lclient!qb;")
	private PixMap areaBackhmid1;

	@OriginalMember(owner = "client!client", name = "fd", descriptor = "I")
	private int privateMessageCount;

	@OriginalMember(owner = "client!client", name = "gd", descriptor = "[I")
	private final int[] compassMaskLineOffsets = new int[33];

	@OriginalMember(owner = "client!client", name = "hd", descriptor = "I")
	public static int opLoc5Counter;

	@OriginalMember(owner = "client!client", name = "id", descriptor = "[I")
	private final int[] waveDelay = new int[50];

	@OriginalMember(owner = "client!client", name = "jd", descriptor = "I")
	private int chatHoveredInterfaceIndex;

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

	@OriginalMember(owner = "client!client", name = "rd", descriptor = "I")
	public static int opNpc3Counter;

	@OriginalMember(owner = "client!client", name = "sd", descriptor = "I")
	private int lastHoveredInterfaceId;

	@OriginalMember(owner = "client!client", name = "td", descriptor = "Z")
	private boolean showSocialInput = false;

	@OriginalMember(owner = "client!client", name = "wd", descriptor = "Z")
	private boolean pressedContinueOption = false;

	@OriginalMember(owner = "client!client", name = "xd", descriptor = "I")
	private int daysSinceLastLogin;

	@OriginalMember(owner = "client!client", name = "yd", descriptor = "I")
	private int flameGradientCycle0;

	@OriginalMember(owner = "client!client", name = "zd", descriptor = "I")
	private int flameGradientCycle1;

	@OriginalMember(owner = "client!client", name = "Ad", descriptor = "I")
	public static int opHeld9Counter;

	@OriginalMember(owner = "client!client", name = "Cd", descriptor = "[I")
	private final int[] messageIds = new int[100];

	@OriginalMember(owner = "client!client", name = "Dd", descriptor = "Z")
	private boolean menuVisible = false;

	@OriginalMember(owner = "client!client", name = "Ed", descriptor = "I")
	private int currentLevel;

	@OriginalMember(owner = "client!client", name = "Fd", descriptor = "Z")
	private boolean reportAbuseMuteOption = false;

	@OriginalMember(owner = "client!client", name = "Gd", descriptor = "I")
	public static int handleTabInputCounter;

	@OriginalMember(owner = "client!client", name = "Id", descriptor = "Lclient!ob;")
	private LinkList spawnedLocations = new LinkList();

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
	public static int opPlayer2Counter;

	@OriginalMember(owner = "client!client", name = "Pd", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone1;

	@OriginalMember(owner = "client!client", name = "Qd", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone2;

	@OriginalMember(owner = "client!client", name = "Rd", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone3;

	@OriginalMember(owner = "client!client", name = "Sd", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone1h;

	@OriginalMember(owner = "client!client", name = "Td", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone2h;

	@OriginalMember(owner = "client!client", name = "Ud", descriptor = "[I")
	private final int[] messageType = new int[100];

	@OriginalMember(owner = "client!client", name = "Vd", descriptor = "[Ljava/lang/String;")
	private final String[] messageSender = new String[100];

	@OriginalMember(owner = "client!client", name = "Wd", descriptor = "[Ljava/lang/String;")
	private final String[] messageText = new String[100];

	@OriginalMember(owner = "client!client", name = "Yd", descriptor = "J")
	private long socialName37;

	@OriginalMember(owner = "client!client", name = "Zd", descriptor = "I")
	private int daysSinceRecoveriesChanged;

	@OriginalMember(owner = "client!client", name = "ae", descriptor = "Z")
	private boolean flameActive = false;

	@OriginalMember(owner = "client!client", name = "be", descriptor = "[I")
	private int[] flameGradient;

	@OriginalMember(owner = "client!client", name = "ce", descriptor = "[I")
	private int[] flameGradient0;

	@OriginalMember(owner = "client!client", name = "de", descriptor = "[I")
	private int[] flameGradient1;

	@OriginalMember(owner = "client!client", name = "ee", descriptor = "[I")
	private int[] flameGradient2;

	@OriginalMember(owner = "client!client", name = "fe", descriptor = "I")
	private int reportAbuseInterfaceID = -1;

	@OriginalMember(owner = "client!client", name = "ge", descriptor = "Lclient!ib;")
	private Pix8 imageBackbase1;

	@OriginalMember(owner = "client!client", name = "he", descriptor = "Lclient!ib;")
	private Pix8 imageBackbase2;

	@OriginalMember(owner = "client!client", name = "ie", descriptor = "Lclient!ib;")
	private Pix8 imageBackhmid1;

	@OriginalMember(owner = "client!client", name = "je", descriptor = "I")
	private int hintType;

	@OriginalMember(owner = "client!client", name = "le", descriptor = "I")
	public static int updatePlayersCounter;

	@OriginalMember(owner = "client!client", name = "me", descriptor = "I")
	private int orbitCameraX;

	@OriginalMember(owner = "client!client", name = "ne", descriptor = "I")
	private int orbitCameraZ;

	@OriginalMember(owner = "client!client", name = "oe", descriptor = "I")
	private int cameraMovedWrite;

	@OriginalMember(owner = "client!client", name = "pe", descriptor = "I")
	private int activeMapFunctionCount;

	@OriginalMember(owner = "client!client", name = "qe", descriptor = "[I")
	private int[] activeMapFunctionX = new int[1000];

	@OriginalMember(owner = "client!client", name = "re", descriptor = "[I")
	private int[] activeMapFunctionZ = new int[1000];

	@OriginalMember(owner = "client!client", name = "se", descriptor = "[[I")
	private int[][] tileLastOccupiedCycle = new int[104][104];

	@OriginalMember(owner = "client!client", name = "te", descriptor = "Z")
	private boolean redrawPrivacySettings = false;

	@OriginalMember(owner = "client!client", name = "ue", descriptor = "Ljava/math/BigInteger;")
	public static final BigInteger RSA_EXPONENT = new BigInteger("58778699976184461502525193738213253649000149147835990136706041084440742975821");

	@OriginalMember(owner = "client!client", name = "ve", descriptor = "Z")
	private boolean errorHost = false;

	@OriginalMember(owner = "client!client", name = "we", descriptor = "I")
	private int objDragCycles;

	@OriginalMember(owner = "client!client", name = "xe", descriptor = "[I")
	private int[] sceneMapIndex;

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
	private int worldLocationState;

	@OriginalMember(owner = "client!client", name = "Ge", descriptor = "I")
	private int dragCycles;

	@OriginalMember(owner = "client!client", name = "Ie", descriptor = "Ljava/lang/String;")
	private String modalMessage;

	@OriginalMember(owner = "client!client", name = "Je", descriptor = "I")
	public static int ifButton5Counter;

	@OriginalMember(owner = "client!client", name = "Ke", descriptor = "[I")
	private int[] varps = new int[2000];

	@OriginalMember(owner = "client!client", name = "Le", descriptor = "I")
	private int entityRemovalCount;

	@OriginalMember(owner = "client!client", name = "Me", descriptor = "[I")
	private int[] entityRemovalIds = new int[1000];

	@OriginalMember(owner = "client!client", name = "Ne", descriptor = "I")
	private int sidebarHoveredInterfaceIndex;

	@OriginalMember(owner = "client!client", name = "Pe", descriptor = "[J")
	private long[] friendName37 = new long[100];

	@OriginalMember(owner = "client!client", name = "Qe", descriptor = "I")
	private int selectedCycle;

	@OriginalMember(owner = "client!client", name = "Re", descriptor = "I")
	private int selectedInterface;

	@OriginalMember(owner = "client!client", name = "Se", descriptor = "I")
	private int selectedItem;

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
	private Pix24[] imageHeadicons = new Pix24[20];

	@OriginalMember(owner = "client!client", name = "df", descriptor = "I")
	private int systemUpdateTimer;

	@OriginalMember(owner = "client!client", name = "ff", descriptor = "[I")
	private final int[] cameraModifierJitter = new int[5];

	@OriginalMember(owner = "client!client", name = "gf", descriptor = "Z")
	private boolean objGrabThreshold = false;

	@OriginalMember(owner = "client!client", name = "hf", descriptor = "Lclient!hb;")
	private Pix24 genderButtonImage0;

	@OriginalMember(owner = "client!client", name = "jf", descriptor = "Lclient!hb;")
	private Pix24 genderButtonImage1;

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
	private int viewportInterfaceId = -1;

	@OriginalMember(owner = "client!client", name = "tf", descriptor = "I")
	private int titleLoginField;

	@OriginalMember(owner = "client!client", name = "uf", descriptor = "[Lclient!ib;")
	private Pix8[] imageRunes;

	@OriginalMember(owner = "client!client", name = "vf", descriptor = "Z")
	private boolean ingame = false;

	@OriginalMember(owner = "client!client", name = "wf", descriptor = "Z")
	private boolean flamesThread = false;

	@OriginalMember(owner = "client!client", name = "xf", descriptor = "I")
	private int publicChatSetting;

	@OriginalMember(owner = "client!client", name = "yf", descriptor = "I")
	private int chatScrollOffset;

	@OriginalMember(owner = "client!client", name = "zf", descriptor = "Lclient!hb;")
	private Pix24 imageFlamesLeft;

	@OriginalMember(owner = "client!client", name = "Af", descriptor = "Lclient!hb;")
	private Pix24 imageFlamesRight;

	@OriginalMember(owner = "client!client", name = "Bf", descriptor = "I")
	private final int SCROLLBAR_GRIP_LOWLIGHT = 3353893;

	@OriginalMember(owner = "client!client", name = "Cf", descriptor = "Lclient!ib;")
	private Pix8 imageInvback;

	@OriginalMember(owner = "client!client", name = "Df", descriptor = "Lclient!ib;")
	private Pix8 imageMapback;

	@OriginalMember(owner = "client!client", name = "Ef", descriptor = "Lclient!ib;")
	private Pix8 imageChatback;

	@OriginalMember(owner = "client!client", name = "Ff", descriptor = "I")
	private int inMultizone;

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

	@OriginalMember(owner = "client!client", name = "Mf", descriptor = "[I")
	private int[] flameBuffer3;

	@OriginalMember(owner = "client!client", name = "Nf", descriptor = "[I")
	private int[] flameBuffer2;

	@OriginalMember(owner = "client!client", name = "Of", descriptor = "I")
	private final int SCROLLBAR_GRIP_HIGHLIGHT = 7759444;

	@OriginalMember(owner = "client!client", name = "Pf", descriptor = "[I")
	private int[] bfsStepX = new int[4000];

	@OriginalMember(owner = "client!client", name = "Qf", descriptor = "[I")
	private int[] bfsStepZ = new int[4000];

	@OriginalMember(owner = "client!client", name = "Rf", descriptor = "Ljava/util/zip/CRC32;")
	private final CRC32 crc32 = new CRC32();

	@OriginalMember(owner = "client!client", name = "Sf", descriptor = "Lclient!hb;")
	private Pix24 imageMapflag;

	@OriginalMember(owner = "client!client", name = "Tf", descriptor = "I")
	public static int updateGame;

	@OriginalMember(owner = "client!client", name = "Uf", descriptor = "Lclient!d;")
	private ClientStream connection;

	@OriginalMember(owner = "client!client", name = "Vf", descriptor = "[[B")
	private byte[][] sceneMapLocData;

	@OriginalMember(owner = "client!client", name = "Wf", descriptor = "I")
	private int chatInterfaceId = -1;

	@OriginalMember(owner = "client!client", name = "Xf", descriptor = "I")
	private int objSelected;

	@OriginalMember(owner = "client!client", name = "Yf", descriptor = "I")
	private int objSelectedSlot;

	@OriginalMember(owner = "client!client", name = "Zf", descriptor = "I")
	private int objSelectedInterface;

	@OriginalMember(owner = "client!client", name = "ag", descriptor = "I")
	private int objInterface;

	@OriginalMember(owner = "client!client", name = "bg", descriptor = "Ljava/lang/String;")
	private String objSelectedName;

	@OriginalMember(owner = "client!client", name = "cg", descriptor = "Lclient!qb;")
	private PixMap areaBackleft1;

	@OriginalMember(owner = "client!client", name = "dg", descriptor = "Lclient!qb;")
	private PixMap areaBackleft2;

	@OriginalMember(owner = "client!client", name = "eg", descriptor = "Lclient!qb;")
	private PixMap areaBackright1;

	@OriginalMember(owner = "client!client", name = "fg", descriptor = "Lclient!qb;")
	private PixMap areaBackright2;

	@OriginalMember(owner = "client!client", name = "gg", descriptor = "Lclient!qb;")
	private PixMap areaBacktop1;

	@OriginalMember(owner = "client!client", name = "hg", descriptor = "Lclient!qb;")
	private PixMap areaBacktop2;

	@OriginalMember(owner = "client!client", name = "ig", descriptor = "Lclient!qb;")
	private PixMap areaBackvmid1;

	@OriginalMember(owner = "client!client", name = "jg", descriptor = "Lclient!qb;")
	private PixMap areaBackvmid2;

	@OriginalMember(owner = "client!client", name = "kg", descriptor = "Lclient!qb;")
	private PixMap areaBackvmid3;

	@OriginalMember(owner = "client!client", name = "lg", descriptor = "Lclient!qb;")
	private PixMap areaBackhmid2;

	@OriginalMember(owner = "client!client", name = "ng", descriptor = "I")
	private int waveCount;

	@OriginalMember(owner = "client!client", name = "og", descriptor = "I")
	private int projectX = -1;

	@OriginalMember(owner = "client!client", name = "pg", descriptor = "I")
	private int projectY = -1;

	@OriginalMember(owner = "client!client", name = "qg", descriptor = "I")
	private int stickyChatInterfaceId = -1;

	@OriginalMember(owner = "client!client", name = "sg", descriptor = "Z")
	private boolean rights = false;

	@OriginalMember(owner = "client!client", name = "tg", descriptor = "[I")
	private final int[] cameraModifierCycle = new int[5];

	@OriginalMember(owner = "client!client", name = "ug", descriptor = "I")
	private int spellSelected;

	@OriginalMember(owner = "client!client", name = "vg", descriptor = "I")
	private int activeSpellId;

	@OriginalMember(owner = "client!client", name = "wg", descriptor = "I")
	private int activeSpellFlags;

	@OriginalMember(owner = "client!client", name = "xg", descriptor = "Ljava/lang/String;")
	private String spellCaption;

	@OriginalMember(owner = "client!client", name = "yg", descriptor = "Lclient!qb;")
	private PixMap imageTitle2;

	@OriginalMember(owner = "client!client", name = "zg", descriptor = "Lclient!qb;")
	private PixMap imageTitle3;

	@OriginalMember(owner = "client!client", name = "Ag", descriptor = "Lclient!qb;")
	private PixMap imageTitle4;

	@OriginalMember(owner = "client!client", name = "Bg", descriptor = "Lclient!qb;")
	private PixMap imageTitle0;

	@OriginalMember(owner = "client!client", name = "Cg", descriptor = "Lclient!qb;")
	private PixMap imageTitle1;

	@OriginalMember(owner = "client!client", name = "Dg", descriptor = "Lclient!qb;")
	private PixMap imageTitle5;

	@OriginalMember(owner = "client!client", name = "Eg", descriptor = "Lclient!qb;")
	private PixMap imageTitle6;

	@OriginalMember(owner = "client!client", name = "Fg", descriptor = "Lclient!qb;")
	private PixMap imageTitle7;

	@OriginalMember(owner = "client!client", name = "Gg", descriptor = "Lclient!qb;")
	private PixMap imageTitle8;

	@OriginalMember(owner = "client!client", name = "Hg", descriptor = "[Lclient!ib;")
	private Pix8[] imageMapscene = new Pix8[50];

	@OriginalMember(owner = "client!client", name = "Jg", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone1v;

	@OriginalMember(owner = "client!client", name = "Kg", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone2v;

	@OriginalMember(owner = "client!client", name = "Lg", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone3v;

	@OriginalMember(owner = "client!client", name = "Mg", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone1hv;

	@OriginalMember(owner = "client!client", name = "Ng", descriptor = "Lclient!ib;")
	private Pix8 imageRedstone2hv;

	@OriginalMember(owner = "client!client", name = "Og", descriptor = "[I")
	private final int[] CHAT_COLORS = new int[] { 16776960, 16711680, 65280, 65535, 16711935, 16777215 };

	@OriginalMember(owner = "client!client", name = "Pg", descriptor = "Lclient!qb;")
	private PixMap areaSidebar;

	@OriginalMember(owner = "client!client", name = "Qg", descriptor = "Lclient!qb;")
	private PixMap areaMapback;

	@OriginalMember(owner = "client!client", name = "Rg", descriptor = "Lclient!qb;")
	private PixMap areaViewport;

	@OriginalMember(owner = "client!client", name = "Sg", descriptor = "Lclient!qb;")
	private PixMap areaChatback;

	@OriginalMember(owner = "client!client", name = "Tg", descriptor = "I")
	private final int SCROLLBAR_TRACK = 2301979;

	@OriginalMember(owner = "client!client", name = "Ug", descriptor = "I")
	private int flagSceneTileX;

	@OriginalMember(owner = "client!client", name = "Vg", descriptor = "I")
	private int flagSceneTileZ;

	@OriginalMember(owner = "client!client", name = "Wg", descriptor = "Lclient!hb;")
	private Pix24 imageMinimap;

	@OriginalMember(owner = "client!client", name = "Xg", descriptor = "I")
	private int unreadMessages;

	@OriginalMember(owner = "client!client", name = "Yg", descriptor = "Z")
	private boolean chatbackInputOpen = false;

	@OriginalMember(owner = "client!client", name = "Zg", descriptor = "Lclient!ob;")
	private LinkList spotanims = new LinkList();

	@OriginalMember(owner = "client!client", name = "ah", descriptor = "Lclient!hb;")
	private Pix24 imageMapdot0;

	@OriginalMember(owner = "client!client", name = "bh", descriptor = "Lclient!hb;")
	private Pix24 imageMapdot1;

	@OriginalMember(owner = "client!client", name = "ch", descriptor = "Lclient!hb;")
	private Pix24 imageMapdot2;

	@OriginalMember(owner = "client!client", name = "dh", descriptor = "Lclient!hb;")
	private Pix24 imageMapdot3;

	@OriginalMember(owner = "client!client", name = "eh", descriptor = "I")
	private int lastAddress;

	@OriginalMember(owner = "client!client", name = "fh", descriptor = "Ljava/math/BigInteger;")
	public static final BigInteger RSA_MODULUS = new BigInteger("7162900525229798032761816791230527296329313291232324290237849263501208207972894053929065636522363163621000728841182238772712427862772219676577293600221789");

	@OriginalMember(owner = "client!client", name = "gh", descriptor = "I")
	private int viewportHoveredInterfaceIndex;

	@OriginalMember(owner = "client!client", name = "hh", descriptor = "Ljava/lang/String;")
	private String midiSyncName;

	@OriginalMember(owner = "client!client", name = "ih", descriptor = "I")
	private int lastWaveLoops = -1;

	@OriginalMember(owner = "client!client", name = "jh", descriptor = "Ljava/lang/String;")
	private String username = "";

	@OriginalMember(owner = "client!client", name = "kh", descriptor = "Ljava/lang/String;")
	private String password = "";

	@OriginalMember(owner = "client!client", name = "mh", descriptor = "[B")
	private byte[] textureBuffer = new byte[16384];

	@OriginalMember(owner = "client!client", name = "nh", descriptor = "Z")
	private boolean errorStarted = false;

	@OriginalMember(owner = "client!client", name = "ph", descriptor = "I")
	private int energy;

	@OriginalMember(owner = "client!client", name = "rh", descriptor = "I")
	private int menuSize;

	@OriginalMember(owner = "client!client", name = "sh", descriptor = "[I")
	private final int[] varCache = new int[2000];

	@OriginalMember(owner = "client!client", name = "th", descriptor = "I")
	private int hintPlayer;

	@OriginalMember(owner = "client!client", name = "vh", descriptor = "I")
	private int sceneState;

	@OriginalMember(owner = "client!client", name = "wh", descriptor = "[I")
	private final int[] skillExperience = new int[50];

	@OriginalMember(owner = "client!client", name = "xh", descriptor = "Z")
	private boolean redrawSideicons = false;

	@OriginalMember(owner = "client!client", name = "yh", descriptor = "Lclient!ib;")
	private Pix8 imageScrollbar0;

	@OriginalMember(owner = "client!client", name = "zh", descriptor = "Lclient!ib;")
	private Pix8 imageScrollbar1;

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
	public static int updateGameCounter2;

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
	private int wildernessLevel;

	@OriginalMember(owner = "client!client", name = "Th", descriptor = "Z")
	public static boolean started;

	@OriginalMember(owner = "client!client", name = "Uh", descriptor = "Lclient!ib;")
	private Pix8 imageTitlebox;

	@OriginalMember(owner = "client!client", name = "Vh", descriptor = "Lclient!ib;")
	private Pix8 imageTitlebutton;

	@OriginalMember(owner = "client!client", name = "Yh", descriptor = "[I")
	private final int[] LOC_KIND_TO_CLASS_ID = new int[] { 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3 };

	@OriginalMember(owner = "client!client", name = "Zh", descriptor = "I")
	public static int updateTemporaryLocsCounter;

	@OriginalMember(owner = "client!client", name = "ai", descriptor = "I")
	private int titleScreenState;

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

	@OriginalMember(owner = "client!client", name = "ii", descriptor = "[I")
	private final int[] compassMaskLineLengths = new int[33];

	@OriginalMember(owner = "client!client", name = "ji", descriptor = "[[I")
	private int[][] bfsDirection = new int[104][104];

	@OriginalMember(owner = "client!client", name = "ki", descriptor = "Ljava/lang/String;")
	private String currentMidi;

	@OriginalMember(owner = "client!client", name = "li", descriptor = "[Lclient!hb;")
	private Pix24[] imageCrosses = new Pix24[8];

	@OriginalMember(owner = "client!client", name = "mi", descriptor = "Z")
	private boolean flameThread = false;

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

	@OriginalMember(owner = "client!client", name = "yi", descriptor = "[I")
	private final int[] minimapMaskLineOffsets = new int[151];

	@OriginalMember(owner = "client!client", name = "zi", descriptor = "I")
	private int cameraAnticheatAngle;

	@OriginalMember(owner = "client!client", name = "Ai", descriptor = "I")
	private int cameraOffsetYawModifier = 1;

	@OriginalMember(owner = "client!client", name = "Bi", descriptor = "Lclient!ub;")
	private Jagfile archiveTitle;

	@OriginalMember(owner = "client!client", name = "Ci", descriptor = "Ljava/lang/String;")
	private String chatTyped = "";

	@OriginalMember(owner = "client!client", name = "Di", descriptor = "[Lclient!hb;")
	private Pix24[] imageMapfunction = new Pix24[50];

	@OriginalMember(owner = "client!client", name = "Ei", descriptor = "[I")
	private int[] menuParamA = new int[500];

	@OriginalMember(owner = "client!client", name = "Fi", descriptor = "[I")
	private int[] menuParamB = new int[500];

	@OriginalMember(owner = "client!client", name = "Gi", descriptor = "[I")
	private int[] menuAction = new int[500];

	@OriginalMember(owner = "client!client", name = "Hi", descriptor = "[I")
	private int[] menuParamC = new int[500];

	@OriginalMember(owner = "client!client", name = "Ji", descriptor = "Z")
	private boolean scrollGrabbed = false;

	@OriginalMember(owner = "client!client", name = "Ki", descriptor = "Lclient!hb;")
	private Pix24 imageCompass;

	@OriginalMember(owner = "client!client", name = "Li", descriptor = "J")
	private long serverSeed;

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
	private int flameCycle0;

	@OriginalMember(owner = "client!client", name = "Wi", descriptor = "[[[Lclient!ob;")
	private LinkList[][][] levelObjStacks = new LinkList[4][104][104];

	@OriginalMember(owner = "client!client", name = "Xi", descriptor = "I")
	private final int SCROLLBAR_GRIP_FOREGROUND = 5063219;

	@OriginalMember(owner = "client!client", name = "Yi", descriptor = "[I")
	private final int[] cameraModifierWobbleSpeed = new int[5];

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
	public static void main(@OriginalArg(0) String[] args) {
		try {
			System.out.println("RS2 user client - release #" + Signlink.clientversion);

			// sane defaults
			nodeId = 10;
			portOffset = 0;
			setHighMemory();
			members = true;

			if (args.length > 0) {
				nodeId = Integer.parseInt(args[0]);
			}

			if (args.length > 1) {
				portOffset = Integer.parseInt(args[1]);
			}

			if (args.length > 2) {
				if (args[2].equals("lowmem")) {
					setLowMemory();
				} else if (args[2].equals("highmem")) {
					setHighMemory();
				}
			}

			if (args.length > 3) {
				if (args[3].equals("free")) {
					members = false;
				} else if (args[3].equals("members")) {
					members = true;
				}
			}

			Signlink.startpriv();

			@Pc(82) Client local82 = new Client();
			local82.initApplication(532, 789);
		} catch (@Pc(89) Exception ex) {
			ex.printStackTrace();
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(Z)V")
	public static void setLowMemory() {
		World3D.lowMemory = true;
		Draw3D.lowMemory = true;
		lowMemory = true;
		World.lowMemory = true;
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(II)Ljava/lang/String;")
	public static String formatObjCountTagged(@OriginalArg(0) int arg0) {
		@Pc(4) String local4 = String.valueOf(arg0);
		for (@Pc(9) int local9 = local4.length() - 3; local9 > 0; local9 -= 3) {
			local4 = local4.substring(0, local9) + "," + local4.substring(local9);
		}
		if (local4.length() > 8) {
			local4 = "@gre@" + local4.substring(0, local4.length() - 8) + " million @whi@(" + local4 + ")";
		} else if (local4.length() > 4) {
			local4 = "@cya@" + local4.substring(0, local4.length() - 4) + "K @whi@(" + local4 + ")";
		}
		return " " + local4;
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IZI)Ljava/lang/String;")
	public static String getCombatLevelColorTag(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2) {
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
	}

	@OriginalMember(owner = "client!client", name = "B", descriptor = "(I)V")
	public static void setHighMemory() {
		World3D.lowMemory = false;
		Draw3D.lowMemory = false;
		lowMemory = false;
		World.lowMemory = false;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZI)Ljava/lang/String;")
	public static String formatObjCount(@OriginalArg(1) int arg1) {
		if (arg1 < 100000) {
			return String.valueOf(arg1);
		} else if (arg1 < 10000000) {
			return arg1 / 1000 + "K";
		} else {
			return arg1 / 1000000 + "M";
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILjava/lang/String;I)V")
	private void setMidi(@OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3) {
		if (arg2 == null) {
			return;
		}

		synchronized (this.midiSync) {
			this.midiSyncName = arg2;
			this.midiSyncCrc = arg1;
			this.midiSyncLen = arg3;
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(I)V")
	private void draw2DEntityElements() {
		this.chatCount = 0;
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
			if (local23 != null && local23.isVisible()) {
				if (local15 < this.playerCount) {
					local63 = 30;
					@Pc(66) PlayerEntity local66 = (PlayerEntity) local23;
					if (local66.headicons != 0) {
						this.projectFromGround(local23.height + 15, local23);
						if (this.projectX > -1) {
							for (local84 = 0; local84 < 8; local84++) {
								if ((local66.headicons & 0x1 << local84) != 0) {
									this.imageHeadicons[local84].draw(this.projectY - local63, this.projectX - 12);
									local63 -= 25;
								}
							}
						}
					}
					if (local15 >= 0 && this.hintType == 10 && this.hintPlayer == this.playerIds[local15]) {
						this.projectFromGround(local23.height + 15, local23);
						if (this.projectX > -1) {
							this.imageHeadicons[7].draw(this.projectY - local63, this.projectX - 12);
						}
					}
				} else if (this.hintType == 1 && this.hintNpc == this.npcIds[local15 - this.playerCount] && loopCycle % 20 < 10) {
					this.projectFromGround(local23.height + 15, local23);
					if (this.projectX > -1) {
						this.imageHeadicons[2].draw(this.projectY - 28, this.projectX - 12);
					}
				}
				if (local23.chat != null && (local15 >= this.playerCount || this.publicChatSetting == 0 || this.publicChatSetting == 3 || this.publicChatSetting == 1 && this.isFriend(((PlayerEntity) local23).name))) {
					this.projectFromGround(local23.height, local23);
					if (this.projectX > -1 && this.chatCount < this.MAX_CHATS) {
						this.chatWidth[this.chatCount] = this.fontBold12.stringWidth(local23.chat) / 2;
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
					this.projectFromGround(local23.height + 15, local23);
					if (this.projectX > -1) {
						local63 = local23.health * 30 / local23.totalHealth;
						if (local63 > 30) {
							local63 = 30;
						}
						Draw2D.fillRect(this.projectY - 3, this.projectX - 15, 65280, local63, 5);
						Draw2D.fillRect(this.projectY - 3, this.projectX - 15 + local63, 16711680, 30 - local63, 5);
					}
				}
				if (local23.combatCycle > loopCycle + 330) {
					this.projectFromGround(local23.height / 2, local23);
					if (this.projectX > -1) {
						this.imageHitmarks[local23.damageType].draw(this.projectY - 12, this.projectX - 12);
						this.fontPlain11.drawStringCenter(this.projectY + 4, 0, String.valueOf(local23.damage), this.projectX);
						this.fontPlain11.drawStringCenter(this.projectY + 3, 16777215, String.valueOf(local23.damage), this.projectX - 1);
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
					this.fontBold12.drawStringCenter(this.projectY + 1, 0, local612, this.projectX);
					this.fontBold12.drawStringCenter(this.projectY, local617, local612, this.projectX);
				}
				if (this.chatStyles[local483] == 1) {
					this.fontBold12.drawCenteredWave(this.sceneCycle, this.projectX, this.projectY + 1, 0, local612);
					this.fontBold12.drawCenteredWave(this.sceneCycle, this.projectX, this.projectY, local617, local612);
				}
				if (this.chatStyles[local483] == 2) {
					local692 = this.fontBold12.stringWidth(local612);
					@Pc(913) int local913 = (150 - this.chatTimers[local483]) * (local692 + 100) / 150;
					Draw2D.setBounds(334, 0, this.projectX + 50, this.projectX - 50);
					this.fontBold12.drawString(this.projectX + 50 - local913, this.projectY + 1, 0, local612);
					this.fontBold12.drawString(this.projectX + 50 - local913, this.projectY, local617, local612);
					Draw2D.resetBounds();
				}
			} else {
				this.fontBold12.drawStringCenter(this.projectY + 1, 0, local612, this.projectX);
				this.fontBold12.drawStringCenter(this.projectY, 16776960, local612, this.projectX);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(B)V")
	private void closeInterfaces() {
		this.out.p1isaac(231);
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
		this.viewportInterfaceId = -1;
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(I)V")
	private void stopMidi() {
		Signlink.midifade = false;
		Signlink.midi = "stop";
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(I)V")
	private void drawWildyLevel() {
		@Pc(10) int local10 = (this.localPlayer.x >> 7) + this.sceneBaseTileX;
		@Pc(19) int local19 = (this.localPlayer.z >> 7) + this.sceneBaseTileZ;
		if (local10 >= 2944 && local10 < 3392 && local19 >= 3520 && local19 < 6400) {
			this.wildernessLevel = (local19 - 3520) / 8 + 1;
		} else if (local10 >= 2944 && local10 < 3392 && local19 >= 9920 && local19 < 12800) {
			this.wildernessLevel = (local19 - 9920) / 8 + 1;
		} else {
			this.wildernessLevel = 0;
		}
		this.worldLocationState = 0;
		if (local10 >= 3328 && local10 < 3392 && local19 >= 3200 && local19 < 3264) {
			@Pc(98) int local98 = local10 & 0x3F;
			@Pc(102) int local102 = local19 & 0x3F;
			if (local98 >= 4 && local98 <= 29 && local102 >= 44 && local102 <= 58) {
				this.worldLocationState = 1;
			}
			if (local98 >= 36 && local98 <= 61 && local102 >= 44 && local102 <= 58) {
				this.worldLocationState = 1;
			}
			if (local98 >= 4 && local98 <= 29 && local102 >= 25 && local102 <= 39) {
				this.worldLocationState = 1;
			}
			if (local98 >= 36 && local98 <= 61 && local102 >= 25 && local102 <= 39) {
				this.worldLocationState = 1;
			}
			if (local98 >= 4 && local98 <= 29 && local102 >= 6 && local102 <= 20) {
				this.worldLocationState = 1;
			}
			if (local98 >= 36 && local98 <= 61 && local102 >= 6 && local102 <= 20) {
				this.worldLocationState = 1;
			}
		}
		if (this.worldLocationState == 0 && local10 >= 3328 && local10 <= 3393 && local19 >= 3203 && local19 <= 3325) {
			this.worldLocationState = 2;
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
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(I)V")
	private void drawPrivateMessages() {
		if (this.splitPrivateChat == 0) {
			return;
		}

		@Pc(9) BitmapFont local9 = this.fontPlain12;
		@Pc(11) int local11 = 0;
		if (this.systemUpdateTimer != 0) {
			local11 = 1;
		}
		for (@Pc(18) int local18 = 0; local18 < 100; local18++) {
			if (this.messageText[local18] != null) {
				@Pc(30) int local30 = this.messageType[local18];
				@Pc(60) int local60;
				if ((local30 == 3 || local30 == 7) && (local30 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[local18]))) {
					local60 = 329 - local11 * 13;
					local9.drawString(4, local60, 0, "From " + this.messageSender[local18] + ": " + this.messageText[local18]);
					local9.drawString(4, local60 - 1, 65535, "From " + this.messageSender[local18] + ": " + this.messageText[local18]);
					local11++;
					if (local11 >= 5) {
						return;
					}
				}
				if (local30 == 5 && this.privateChatSetting < 2) {
					local60 = 329 - local11 * 13;
					local9.drawString(4, local60, 0, this.messageText[local18]);
					local9.drawString(4, local60 - 1, 65535, this.messageText[local18]);
					local11++;
					if (local11 >= 5) {
						return;
					}
				}
				if (local30 == 6 && this.privateChatSetting < 2) {
					local60 = 329 - local11 * 13;
					local9.drawString(4, local60, 0, "To " + this.messageSender[local18] + ": " + this.messageText[local18]);
					local9.drawString(4, local60 - 1, 65535, "To " + this.messageSender[local18] + ": " + this.messageText[local18]);
					local11++;
					if (local11 >= 5) {
						return;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!kb;II)V")
	private void readNpcUpdates(@OriginalArg(0) Packet arg0, @OriginalArg(1) int arg1) {
		for (@Pc(1) int local1 = 0; local1 < this.entityUpdateCount; local1++) {
			@Pc(8) int local8 = this.entityUpdateIds[local1];
			@Pc(13) NpcEntity local13 = this.npcs[local8];
			@Pc(16) int local16 = arg0.g1();
			@Pc(24) int local24;
			if ((local16 & 0x2) == 2) {
				local24 = arg0.g2();
				if (local24 == 65535) {
					local24 = -1;
				}
				if (local24 == local13.primarySeqId) {
					local13.primarySeqLoop = 0;
				}
				@Pc(39) int local39 = arg0.g1();
				if (local24 == -1 || local13.primarySeqId == -1 || SeqType.instances[local24].priority > SeqType.instances[local13.primarySeqId].priority || SeqType.instances[local13.primarySeqId].priority == 0) {
					local13.primarySeqId = local24;
					local13.primarySeqFrame = 0;
					local13.primarySeqCycle = 0;
					local13.primarySeqDelay = local39;
					local13.primarySeqLoop = 0;
				}
			}
			if ((local16 & 0x4) == 4) {
				local13.targetId = arg0.g2();
				if (local13.targetId == 65535) {
					local13.targetId = -1;
				}
			}
			if ((local16 & 0x8) == 8) {
				local13.chat = arg0.gstr();
				local13.chatTimer = 100;
			}
			if ((local16 & 0x10) == 16) {
				local13.damage = arg0.g1();
				local13.damageType = arg0.g1();
				local13.combatCycle = loopCycle + 400;
				local13.health = arg0.g1();
				local13.totalHealth = arg0.g1();
			}
			if ((local16 & 0x20) == 32) {
				local13.type = NpcType.get(arg0.g2());
				local13.seqWalkId = local13.type.walkanim;
				local13.seqTurnAroundId = local13.type.walkanim_b;
				local13.seqTurnLeftId = local13.type.walkanim_r;
				local13.seqTurnRightId = local13.type.walkanim_l;
				local13.seqStandId = local13.type.readyanim;
			}
			if ((local16 & 0x40) == 64) {
				local13.spotanimId = arg0.g2();
				local24 = arg0.g4();
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
				local13.targetTileX = arg0.g2();
				local13.targetTileZ = arg0.g2();
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(JB)V")
	private void addIgnore(@OriginalArg(0) long arg0) {
		if (arg0 == 0L) {
			return;
		}

		if (this.ignoreCount >= 100) {
			this.addMessage(0, "Your ignore list is full. Max of 100 hit", "");
		} else {
			@Pc(23) String local23 = JString.formatName(JString.fromBase37(arg0));
			for (@Pc(25) int local25 = 0; local25 < this.ignoreCount; local25++) {
				if (this.ignoreName37[local25] == arg0) {
					this.addMessage(0, local23 + " is already on your ignore list", "");
					return;
				}
			}
			for (@Pc(55) int local55 = 0; local55 < this.friendCount; local55++) {
				if (this.friendName37[local55] == arg0) {
					this.addMessage(0, "Please remove " + local23 + " from your friend list first", "");
					return;
				}
			}
			this.ignoreName37[this.ignoreCount++] = arg0;
			this.redrawSidebar = true;
			this.out.p1isaac(79);
			this.out.p8(arg0);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(BLclient!kb;I)V")
	private void readZonePacket(@OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
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
			local15 = arg1.g1();
			local24 = this.baseX + (local15 >> 4 & 0x7);
			local31 = this.baseZ + (local15 & 0x7);
			local34 = arg1.g1();
			local38 = local34 >> 2;
			local42 = local34 & 0x3;
			local47 = this.LOC_KIND_TO_CLASS_ID[local38];
			if (arg2 == 76) {
				local52 = -1;
			} else {
				local52 = arg1.g2();
			}
			if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
				@Pc(69) LocTemporary local69 = null;
				for (@Pc(74) LocTemporary local74 = (LocTemporary) this.spawnedLocations.peekFront(); local74 != null; local74 = (LocTemporary) this.spawnedLocations.prev()) {
					if (local74.plane == this.currentLevel && local74.x == local24 && local74.z == local31 && local74.classType == local47) {
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
						local108 = this.world3D.getWallBitset(this.currentLevel, local24, local31);
					}
					if (local47 == 1) {
						local108 = this.world3D.getWallDecorationBitset(this.currentLevel, local31, local24);
					}
					if (local47 == 2) {
						local108 = this.world3D.getLocBitset(this.currentLevel, local24, local31);
					}
					if (local47 == 3) {
						local108 = this.world3D.getGroundDecorationBitset(this.currentLevel, local24, local31);
					}
					if (local108 != 0) {
						@Pc(169) int local169 = this.world3D.getInfo(this.currentLevel, local24, local31, local108);
						local110 = local108 >> 14 & 0x7FFF;
						local112 = local169 & 0x1F;
						local114 = local169 >> 6;
					}
					local69 = new LocTemporary();
					local69.plane = this.currentLevel;
					local69.classType = local47;
					local69.x = local24;
					local69.z = local31;
					local69.lastLocIndex = local110;
					local69.lastType = local112;
					local69.lastOrientation = local114;
					this.spawnedLocations.pushBack(local69);
				}
				local69.locIndex = local52;
				local69.type = local38;
				local69.orientation = local42;
				this.addLoc(local42, local24, local31, local47, local52, local38, this.currentLevel);
			}
		} else if (arg2 == 42) {
			local15 = arg1.g1();
			local24 = this.baseX + (local15 >> 4 & 0x7);
			local31 = this.baseZ + (local15 & 0x7);
			local34 = arg1.g1();
			local38 = local34 >> 2;
			local42 = this.LOC_KIND_TO_CLASS_ID[local38];
			local47 = arg1.g2();
			if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
				local52 = 0;
				if (local42 == 0) {
					local52 = this.world3D.getWallBitset(this.currentLevel, local24, local31);
				}
				if (local42 == 1) {
					local52 = this.world3D.getWallDecorationBitset(this.currentLevel, local31, local24);
				}
				if (local42 == 2) {
					local52 = this.world3D.getLocBitset(this.currentLevel, local24, local31);
				}
				if (local42 == 3) {
					local52 = this.world3D.getGroundDecorationBitset(this.currentLevel, local24, local31);
				}
				if (local52 != 0) {
					@Pc(348) LocEntity local348 = new LocEntity(false, local52 >> 14 & 0x7FFF, this.currentLevel, local42, SeqType.instances[local47], local31, local24);
					this.locList.pushBack(local348);
				}
			}
		} else {
			@Pc(395) ObjEntity local395;
			if (arg2 == 223) {
				local15 = arg1.g1();
				local24 = this.baseX + (local15 >> 4 & 0x7);
				local31 = this.baseZ + (local15 & 0x7);
				local34 = arg1.g2();
				local38 = arg1.g2();
				if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
					local395 = new ObjEntity();
					local395.index = local34;
					local395.count = local38;
					if (this.levelObjStacks[this.currentLevel][local24][local31] == null) {
						this.levelObjStacks[this.currentLevel][local24][local31] = new LinkList();
					}
					this.levelObjStacks[this.currentLevel][local24][local31].pushBack(local395);
					this.sortObjStacks(local24, local31);
				}
			} else if (arg2 == 49) {
				local15 = arg1.g1();
				local24 = this.baseX + (local15 >> 4 & 0x7);
				local31 = this.baseZ + (local15 & 0x7);
				local34 = arg1.g2();
				if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
					@Pc(485) LinkList local485 = this.levelObjStacks[this.currentLevel][local24][local31];
					if (local485 != null) {
						for (local395 = (ObjEntity) local485.peekFront(); local395 != null; local395 = (ObjEntity) local485.prev()) {
							if (local395.index == (local34 & 0x7FFF)) {
								local395.unlink();
								break;
							}
						}
						if (local485.peekFront() == null) {
							this.levelObjStacks[this.currentLevel][local24][local31] = null;
						}
						this.sortObjStacks(local24, local31);
					}
				}
			} else {
				@Pc(572) int local572;
				@Pc(575) int local575;
				if (arg2 == 69) {
					local15 = arg1.g1();
					local24 = this.baseX + (local15 >> 4 & 0x7);
					local31 = this.baseZ + (local15 & 0x7);
					local34 = local24 + arg1.g1b();
					local38 = local31 + arg1.g1b();
					local42 = arg1.g2b();
					local47 = arg1.g2();
					local52 = arg1.g1();
					local572 = arg1.g1();
					local575 = arg1.g2();
					local108 = arg1.g2();
					local110 = arg1.g1();
					local112 = arg1.g1();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104 && local34 >= 0 && local38 >= 0 && local34 < 104 && local38 < 104) {
						local24 = local24 * 128 + 64;
						local31 = local31 * 128 + 64;
						local34 = local34 * 128 + 64;
						local38 = local38 * 128 + 64;
						@Pc(657) ProjectileEntity local657 = new ProjectileEntity(local572, local110, local31, local108 + loopCycle, this.currentLevel, local42, local575 + loopCycle, local112, this.getHeightmapY(this.currentLevel, local24, local31) - local52, local47, local24);
						local657.updateVelocity(this.getHeightmapY(this.currentLevel, local34, local38) - local572, local38, local34, local575 + loopCycle);
						this.projectiles.pushBack(local657);
					}
				} else if (arg2 == 191) {
					local15 = arg1.g1();
					local24 = this.baseX + (local15 >> 4 & 0x7);
					local31 = this.baseZ + (local15 & 0x7);
					local34 = arg1.g2();
					local38 = arg1.g1();
					local42 = arg1.g2();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
						local24 = local24 * 128 + 64;
						local31 = local31 * 128 + 64;
						@Pc(753) SpotAnimEntity local753 = new SpotAnimEntity(local24, local34, local31, local42, this.getHeightmapY(this.currentLevel, local24, local31) - local38, this.currentLevel, loopCycle);
						this.spotanims.pushBack(local753);
					}
				} else if (arg2 == 50) {
					local15 = arg1.g1();
					local24 = this.baseX + (local15 >> 4 & 0x7);
					local31 = this.baseZ + (local15 & 0x7);
					local34 = arg1.g2();
					local38 = arg1.g2();
					local42 = arg1.g2();
					if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104 && local42 != this.localPid) {
						@Pc(807) ObjEntity local807 = new ObjEntity();
						local807.index = local34;
						local807.count = local38;
						if (this.levelObjStacks[this.currentLevel][local24][local31] == null) {
							this.levelObjStacks[this.currentLevel][local24][local31] = new LinkList();
						}
						this.levelObjStacks[this.currentLevel][local24][local31].pushBack(local807);
						this.sortObjStacks(local24, local31);
					}
				} else {
					if (arg2 == 23) {
						local15 = arg1.g1();
						local24 = this.baseX + (local15 >> 4 & 0x7);
						local31 = this.baseZ + (local15 & 0x7);
						local34 = arg1.g1();
						local38 = local34 >> 2;
						local42 = local34 & 0x3;
						local47 = this.LOC_KIND_TO_CLASS_ID[local38];
						local52 = arg1.g2();
						local572 = arg1.g2();
						local575 = arg1.g2();
						local108 = arg1.g2();
						@Pc(905) byte local905 = arg1.g1b();
						@Pc(908) byte local908 = arg1.g1b();
						@Pc(911) byte local911 = arg1.g1b();
						@Pc(914) byte local914 = arg1.g1b();
						@Pc(921) PlayerEntity local921;
						if (local108 == this.localPid) {
							local921 = this.localPlayer;
						} else {
							local921 = this.players[local108];
						}
						if (local921 != null) {
							@Pc(946) LocSpawned local946 = new LocSpawned(this.currentLevel, local42, local31, local572 + loopCycle, local38, -1, local24, local47);
							this.temporaryLocs.pushBack(local946);
							@Pc(966) LocSpawned local966 = new LocSpawned(this.currentLevel, local42, local31, local575 + loopCycle, local38, local52, local24, local47);
							this.temporaryLocs.pushBack(local966);
							@Pc(980) int local980 = this.levelHeightmap[this.currentLevel][local24][local31];
							@Pc(992) int local992 = this.levelHeightmap[this.currentLevel][local24 + 1][local31];
							@Pc(1006) int local1006 = this.levelHeightmap[this.currentLevel][local24 + 1][local31 + 1];
							@Pc(1018) int local1018 = this.levelHeightmap[this.currentLevel][local24][local31 + 1];
							@Pc(1021) LocType local1021 = LocType.get(local52);
							local921.locStartCycle = local572 + loopCycle;
							local921.locStopCycle = local575 + loopCycle;
							local921.locModel = local1021.getModel(local38, local42, local980, local992, local1006, local1018, -1);
							@Pc(1045) int local1045 = local1021.sizeX;
							@Pc(1048) int local1048 = local1021.sizeZ;
							if (local42 == 1 || local42 == 3) {
								local1045 = local1021.sizeZ;
								local1048 = local1021.sizeX;
							}
							local921.locOffsetX = local24 * 128 + local1045 * 64;
							local921.locOffsetZ = local31 * 128 + local1048 * 64;
							local921.locOffsetY = this.getHeightmapY(this.currentLevel, local921.locOffsetX, local921.locOffsetZ);
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
							local921.minTileX = local24 + local905;
							local921.maxTileX = local24 + local911;
							local921.minTileZ = local31 + local908;
							local921.maxTileZ = local31 + local914;
						}
					}
					if (arg2 == 151) {
						local15 = arg1.g1();
						local24 = this.baseX + (local15 >> 4 & 0x7);
						local31 = this.baseZ + (local15 & 0x7);
						local34 = arg1.g2();
						local38 = arg1.g2();
						local42 = arg1.g2();
						if (local24 >= 0 && local31 >= 0 && local24 < 104 && local31 < 104) {
							@Pc(1178) LinkList local1178 = this.levelObjStacks[this.currentLevel][local24][local31];
							if (local1178 != null) {
								for (@Pc(1184) ObjEntity local1184 = (ObjEntity) local1178.peekFront(); local1184 != null; local1184 = (ObjEntity) local1178.prev()) {
									if (local1184.index == (local34 & 0x7FFF) && local1184.count == local38) {
										local1184.count = local42;
										break;
									}
								}
								this.sortObjStacks(local24, local31);
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(B)I")
	private int getTopLevel() {
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
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(I)I")
	private int getTopLevelCutscene() {
		@Pc(9) int local9 = this.getHeightmapY(this.currentLevel, this.cameraX, this.cameraZ);
		return local9 - this.cameraY >= 800 || (this.levelTileFlags[this.currentLevel][this.cameraX >> 7][this.cameraZ >> 7] & 0x4) == 0 ? 3 : this.currentLevel;
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
	private void drawScene() {
		this.sceneCycle++;
		this.pushPlayers();
		this.pushNpcs();
		this.pushProjectiles();
		this.pushSpotanims();
		this.pushLocs();
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
			this.orbitCamera(this.getHeightmapY(this.currentLevel, this.localPlayer.x, this.localPlayer.z) - 50, this.orbitCameraX, local73, local34, this.orbitCameraZ, local34 * 3 + 600);
			drawSceneCounter++;
			if (drawSceneCounter > 1802) {
				drawSceneCounter = 0;
				this.out.p1isaac(146);
				this.out.p1(0);
				local122 = this.out.pos;
				this.out.p2(29711);
				this.out.p1(70);
				this.out.p1((int) (Math.random() * 256.0D));
				this.out.p1(242);
				this.out.p1(186);
				this.out.p1(39);
				this.out.p1(61);
				if ((int) (Math.random() * 2.0D) == 0) {
					this.out.p1(13);
				}
				if ((int) (Math.random() * 2.0D) == 0) {
					this.out.p2(57856);
				}
				this.out.p2((int) (Math.random() * 65536.0D));
				this.out.psize1(this.out.pos - local122);
			}
		}
		if (this.cutscene) {
			local34 = this.getTopLevelCutscene();
		} else {
			local34 = this.getTopLevel();
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
		local264 = Draw3D.cycle;
		Model.checkHover = true;
		Model.pickedCount = 0;
		Model.mouseX = super.mouseX - 8;
		Model.mouseZ = super.mouseY - 11;
		Draw2D.clear();
		this.world3D.draw(this.cameraYaw, this.cameraX, local34, this.cameraPitch, this.cameraY, this.cameraZ, loopCycle);
		this.world3D.clearTemporaryLocs();
		this.draw2DEntityElements();
		this.drawTileHint();
		this.updateTextures(local264);
		this.drawViewportInterfaces();
		this.areaViewport.draw(11, super.graphics, 8);
		this.cameraX = local73;
		this.cameraY = local122;
		this.cameraZ = local209;
		this.cameraPitch = local212;
		this.cameraYaw = local215;
	}

	public void drawDebug() {
		if (showOccluders) {
			for (int i = 0; i < World3D.levelOccluderCount[World3D.topLevel]; i++) {
				Occluder occluder = World3D.levelOccluders[World3D.topLevel][i];

				boolean active = false;
				for (int j = 0; j < World3D.activeOccluderCount; j++) {
					if (occluder == World3D.activeOccluders[j]) {
						active = true;
						break;
					}
				}

				if (!active) {
					continue;
				}

				int color = 0xFF0000;
				int x0 = -1, y0 = -1;
				int x1 = -1, y1 = -1;
				int x2 = -1, y2 = -1;
				int x3 = -1, y3 = -1;

				switch (occluder.type) {
					case 1: {
						this.project(occluder.minX, occluder.minY, occluder.minZ);
						x0 = this.projectX;
						y0 = this.projectY;
						this.project(occluder.minX, occluder.maxY, occluder.minZ);
						x1 = this.projectX;
						y1 = this.projectY;
						this.project(occluder.minX, occluder.minY, occluder.maxZ);
						x2 = this.projectX;
						y2 = this.projectY;
						this.project(occluder.minX, occluder.maxY, occluder.maxZ);
						x3 = this.projectX;
						y3 = this.projectY;
						break;
					}
					case 2: {
						this.project(occluder.minX, occluder.minY, occluder.minZ);
						x0 = this.projectX;
						y0 = this.projectY;
						this.project(occluder.maxX, occluder.minY, occluder.minZ);
						x1 = this.projectX;
						y1 = this.projectY;
						this.project(occluder.minX, occluder.maxY, occluder.minZ);
						x2 = this.projectX;
						y2 = this.projectY;
						this.project(occluder.maxX, occluder.maxY, occluder.minZ);
						x3 = this.projectX;
						y3 = this.projectY;
						break;
					}
					case 4: { // Ground on XZ plane
						color = 0x0000FF;
						this.project(occluder.minX, occluder.minY, occluder.minZ);
						x0 = this.projectX;
						y0 = this.projectY;
						this.project(occluder.maxX, occluder.minY, occluder.minZ);
						x1 = this.projectX;
						y1 = this.projectY;
						this.project(occluder.minX, occluder.minY, occluder.maxZ);
						x2 = this.projectX;
						y2 = this.projectY;
						this.project(occluder.maxX, occluder.minY, occluder.maxZ);
						x3 = this.projectX;
						y3 = this.projectY;
						break;
					}
				}

				// one of our points failed to project
				if ((x0 == -1) || (x1 == -1) || (x2 == -1) || (x3 == -1)) {
					continue;
				}

				Draw2D.drawLine(x0, y0, x1, y1, color);
				Draw2D.drawLine(x0, y0, x2, y2, color);
				Draw2D.drawLine(x0, y0, x3, y3, (color & 0xFEFEFE) >> 1);
				Draw2D.drawLine(x1, y1, x2, y2, (color & 0xFEFEFE) >> 1);
				Draw2D.drawLine(x1, y1, x3, y3, color);
				Draw2D.drawLine(x2, y2, x3, y3, color);
			}
		}

		int x = 507;
		int y = 20;

		if (showPerformance) {
			this.fontPlain11.drawStringRight(String.format("FPS: %d", super.fps), x, y, 0xFFFF00, true);
			y += 13;

			double ft = 0;
			for (double delta : super.frameTime) {
				ft += delta;
			}
			ft /= super.frameTime.length;
			this.fontPlain11.drawStringRight(String.format("%04.4f ms", ft), x, y, 0xFFFF00, true);
			y += 13;

			Runtime runtime = Runtime.getRuntime();
			int mem = (int) ((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
			this.fontPlain11.drawStringRight(String.format("Mem: %d kB", mem), x, y, 0xFFFF00, true);
			y += 13;
		}

		if (showOccluders) {
			this.fontPlain11.drawStringRight(String.format("Occluders: %d Active: %d", World3D.levelOccluderCount[World3D.topLevel], World3D.activeOccluderCount), x, y, 0xFFFF00, true);
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(Z)V")
	private void runMidi() {
		this.startMidiThread = false;
		while (this.midiThreadActive) {
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
				@Pc(52) byte[] local52 = Signlink.cacheload(local19 + ".mid");
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
						@Pc(91) DataInputStream local91 = this.openUrl(local19 + "_" + local22 + ".mid");
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
						Signlink.cachesave(local19 + ".mid", local52);
					} catch (@Pc(153) Exception local153) {
					}
				}
				if (local52 == null) {
					return;
				}
				local69 = (new Packet(local52)).g4();
				@Pc(167) byte[] local167 = new byte[local69];
				BZip2.read(local167, local69, local52, local25, 4);
				this.saveMidi(local167, local69, true);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(Z)V")
	private void drawFlames() {
		@Pc(3) short local3 = 256;
		@Pc(8) int local8;
		if (this.flameGradientCycle0 > 0) {
			for (local8 = 0; local8 < 256; local8++) {
				if (this.flameGradientCycle0 > 768) {
					this.flameGradient[local8] = this.mix(this.flameGradient0[local8], 1024 - this.flameGradientCycle0, this.flameGradient1[local8]);
				} else if (this.flameGradientCycle0 > 256) {
					this.flameGradient[local8] = this.flameGradient1[local8];
				} else {
					this.flameGradient[local8] = this.mix(this.flameGradient1[local8], 256 - this.flameGradientCycle0, this.flameGradient0[local8]);
				}
			}
		} else if (this.flameGradientCycle1 > 0) {
			for (local8 = 0; local8 < 256; local8++) {
				if (this.flameGradientCycle1 > 768) {
					this.flameGradient[local8] = this.mix(this.flameGradient0[local8], 1024 - this.flameGradientCycle1, this.flameGradient2[local8]);
				} else if (this.flameGradientCycle1 > 256) {
					this.flameGradient[local8] = this.flameGradient2[local8];
				} else {
					this.flameGradient[local8] = this.mix(this.flameGradient2[local8], 256 - this.flameGradientCycle1, this.flameGradient0[local8]);
				}
			}
		} else {
			for (local8 = 0; local8 < 256; local8++) {
				this.flameGradient[local8] = this.flameGradient0[local8];
			}
		}
		for (local8 = 0; local8 < 33920; local8++) {
			this.imageTitle0.pixels[local8] = this.imageFlamesLeft.pixels[local8];
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
			local198 = this.flameLineOffset[local185] * (local3 - local185) / local3;
			local202 = local198 + 22;
			if (local202 < 0) {
				local202 = 0;
			}
			local181 += local202;
			for (local212 = local202; local212 < 128; local212++) {
				local220 = this.flameBuffer3[local181++];
				if (local220 == 0) {
					local183++;
				} else {
					local224 = local220;
					local228 = 256 - local220;
					local220 = this.flameGradient[local220];
					local239 = this.imageTitle0.pixels[local183];
					this.imageTitle0.pixels[local183++] = ((local220 & 0xFF00FF) * local224 + (local239 & 0xFF00FF) * local228 & 0xFF00FF00) + ((local220 & 0xFF00) * local224 + (local239 & 0xFF00) * local228 & 0xFF0000) >> 8;
				}
			}
			local183 += local202;
		}
		this.imageTitle0.draw(0, super.graphics, 0);
		for (local198 = 0; local198 < 33920; local198++) {
			this.imageTitle1.pixels[local198] = this.imageFlamesRight.pixels[local198];
		}
		local181 = 0;
		local183 = 1176;
		for (local202 = 1; local202 < local3 - 1; local202++) {
			local212 = this.flameLineOffset[local202] * (local3 - local202) / local3;
			local220 = 103 - local212;
			local183 += local212;
			for (local224 = 0; local224 < local220; local224++) {
				local228 = this.flameBuffer3[local181++];
				if (local228 == 0) {
					local183++;
				} else {
					local239 = local228;
					@Pc(362) int local362 = 256 - local228;
					local228 = this.flameGradient[local228];
					@Pc(373) int local373 = this.imageTitle1.pixels[local183];
					this.imageTitle1.pixels[local183++] = ((local228 & 0xFF00FF) * local239 + (local373 & 0xFF00FF) * local362 & 0xFF00FF00) + ((local228 & 0xFF00) * local239 + (local373 & 0xFF00) * local362 & 0xFF0000) >> 8;
				}
			}
			local181 += 128 - local220;
			local183 += 128 - local220 - local212;
		}
		this.imageTitle1.draw(0, super.graphics, 661);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;III)V")
	private void handleInterfaceInput(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) IfType arg3, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		if (arg3.type != 0 || arg3.childId == null || arg3.hide || (arg1 < arg5 || arg0 < arg2 || arg1 > arg5 + arg3.width || arg0 > arg2 + arg3.height)) {
			return;
		}

		@Pc(34) int local34 = arg3.childId.length;
		for (@Pc(44) int local44 = 0; local44 < local34; local44++) {
			@Pc(53) int local53 = arg3.childX[local44] + arg5;
			@Pc(62) int local62 = arg3.childY[local44] + arg2 - arg6;
			@Pc(69) IfType local69 = IfType.instances[arg3.childId[local44]];
			@Pc(74) int local74 = local53 + local69.x;
			@Pc(79) int local79 = local62 + local69.y;
			if ((local69.delegateHover >= 0 || local69.hoverColor != 0) && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
				if (local69.delegateHover >= 0) {
					this.lastHoveredInterfaceId = local69.delegateHover;
				} else {
					this.lastHoveredInterfaceId = local69.id;
				}
			}
			if (local69.type == 0) {
				this.handleInterfaceInput(arg0, arg1, local79, local69, local74, local69.scrollPosition);
				if (local69.scrollableHeight > local69.height) {
					this.handleScrollInput(arg1, arg0, local69.scrollableHeight, local69.height, true, local74 + local69.width, local79, local69);
				}
			} else {
				if (local69.optionType == 1 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
					@Pc(176) boolean local176 = false;
					if (local69.contentType != 0) {
						local176 = this.handleSocialMenuOption(local69);
					}
					if (!local176) {
						this.menuOption[this.menuSize] = local69.option;
						this.menuAction[this.menuSize] = 951;
						this.menuParamB[this.menuSize] = local69.id;
						this.menuSize++;
					}
				}
				if (local69.optionType == 2 && this.spellSelected == 0 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
					@Pc(240) String local240 = local69.spellAction;
					if (local240.indexOf(" ") != -1) {
						local240 = local240.substring(0, local240.indexOf(" "));
					}
					this.menuOption[this.menuSize] = local240 + " @gre@" + local69.spellName;
					this.menuAction[this.menuSize] = 930;
					this.menuParamB[this.menuSize] = local69.id;
					this.menuSize++;
				}
				if (local69.optionType == 3 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
					this.menuOption[this.menuSize] = "Close";
					this.menuAction[this.menuSize] = 947;
					this.menuParamB[this.menuSize] = local69.id;
					this.menuSize++;
				}
				if (local69.optionType == 4 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
					this.menuOption[this.menuSize] = local69.option;
					this.menuAction[this.menuSize] = 465;
					this.menuParamB[this.menuSize] = local69.id;
					this.menuSize++;
				}
				if (local69.optionType == 5 && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
					this.menuOption[this.menuSize] = local69.option;
					this.menuAction[this.menuSize] = 960;
					this.menuParamB[this.menuSize] = local69.id;
					this.menuSize++;
				}
				if (local69.optionType == 6 && !this.pressedContinueOption && arg1 >= local74 && arg0 >= local79 && arg1 < local74 + local69.width && arg0 < local79 + local69.height) {
					this.menuOption[this.menuSize] = local69.option;
					this.menuAction[this.menuSize] = 44;
					this.menuParamB[this.menuSize] = local69.id;
					this.menuSize++;
				}
				if (local69.type == 2) {
					@Pc(488) int local488 = 0;
					for (@Pc(490) int local490 = 0; local490 < local69.height; local490++) {
						for (@Pc(494) int local494 = 0; local494 < local69.width; local494++) {
							@Pc(505) int local505 = local74 + local494 * (local69.inventoryMarginX + 32);
							@Pc(514) int local514 = local79 + local490 * (local69.inventoryMarginY + 32);
							if (local488 < 20) {
								local505 += local69.inventorySlotOffsetX[local488];
								local514 += local69.inventorySlotOffsetY[local488];
							}
							if (arg1 >= local505 && arg0 >= local514 && arg1 < local505 + 32 && arg0 < local514 + 32) {
								this.hoveredSlot = local488;
								this.hoveredSlotParentId = local69.id;
								if (local69.inventorySlotObjId[local488] > 0) {
									@Pc(567) ObjType obj = ObjType.get(local69.inventorySlotObjId[local488] - 1);
									if (this.objSelected == 1 && local69.inventoryInteractable) {
										if (local69.id != this.objSelectedInterface || local488 != this.objSelectedSlot) {
											this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + obj.name;
											this.menuAction[this.menuSize] = 881;
											this.menuParamC[this.menuSize] = obj.index;
											this.menuParamA[this.menuSize] = local488;
											this.menuParamB[this.menuSize] = local69.id;
											this.menuSize++;
										}
									} else if (this.spellSelected != 1 || !local69.inventoryInteractable) {
										@Pc(704) int local704;
										if (local69.inventoryInteractable) {
											for (local704 = 4; local704 >= 3; local704--) {
												if (obj.iops != null && obj.iops[local704] != null) {
													this.menuOption[this.menuSize] = obj.iops[local704] + " @lre@" + obj.name;
													if (local704 == 3) {
														this.menuAction[this.menuSize] = 478;
													}
													if (local704 == 4) {
														this.menuAction[this.menuSize] = 347;
													}
													this.menuParamC[this.menuSize] = obj.index;
													this.menuParamA[this.menuSize] = local488;
													this.menuParamB[this.menuSize] = local69.id;
													this.menuSize++;
												} else if (local704 == 4) {
													this.menuOption[this.menuSize] = "Drop @lre@" + obj.name;
													this.menuAction[this.menuSize] = 347;
													this.menuParamC[this.menuSize] = obj.index;
													this.menuParamA[this.menuSize] = local488;
													this.menuParamB[this.menuSize] = local69.id;
													this.menuSize++;
												}
											}
										}
										if (local69.inventoryUsable) {
											this.menuOption[this.menuSize] = "Use @lre@" + obj.name;
											this.menuAction[this.menuSize] = 188;
											this.menuParamC[this.menuSize] = obj.index;
											this.menuParamA[this.menuSize] = local488;
											this.menuParamB[this.menuSize] = local69.id;
											this.menuSize++;
										}
										if (local69.inventoryInteractable && obj.iops != null) {
											for (local704 = 2; local704 >= 0; local704--) {
												if (obj.iops[local704] != null) {
													this.menuOption[this.menuSize] = obj.iops[local704] + " @lre@" + obj.name;
													if (local704 == 0) {
														this.menuAction[this.menuSize] = 405;
													}
													if (local704 == 1) {
														this.menuAction[this.menuSize] = 38;
													}
													if (local704 == 2) {
														this.menuAction[this.menuSize] = 422;
													}
													this.menuParamC[this.menuSize] = obj.index;
													this.menuParamA[this.menuSize] = local488;
													this.menuParamB[this.menuSize] = local69.id;
													this.menuSize++;
												}
											}
										}
										if (local69.inventoryOptions != null) {
											for (local704 = 4; local704 >= 0; local704--) {
												if (local69.inventoryOptions[local704] != null) {
													this.menuOption[this.menuSize] = local69.inventoryOptions[local704] + " @lre@" + obj.name;
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
													this.menuParamC[this.menuSize] = obj.index;
													this.menuParamA[this.menuSize] = local488;
													this.menuParamB[this.menuSize] = local69.id;
													this.menuSize++;
												}
											}
										}
										this.menuOption[this.menuSize] = "Examine @lre@" + obj.name;
										if (this.showDebug) {
											this.menuOption[this.menuSize] += "@whi@ (" + obj.index + ")";
										}
										this.menuAction[this.menuSize] = 1773;
										this.menuParamC[this.menuSize] = obj.index;
										this.menuParamB[this.menuSize] = local69.inventorySlotObjCount[local488];
										this.menuSize++;
									} else if ((this.activeSpellFlags & 0x10) == 16) {
										this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + obj.name;
										this.menuAction[this.menuSize] = 391;
										this.menuParamC[this.menuSize] = obj.index;
										this.menuParamA[this.menuSize] = local488;
										this.menuParamB[this.menuSize] = local69.id;
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

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
	private void handleChatSettingsInput(@OriginalArg(0) int arg0) {
		if (super.mouseClickButton != 1) {
			return;
		}

		if (super.mouseClickX >= 8 && super.mouseClickX <= 108 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
			this.publicChatSetting = (this.publicChatSetting + 1) % 4;
			this.redrawPrivacySettings = true;
			this.redrawChatback = true;
			this.out.p1isaac(244);
			this.out.p1(this.publicChatSetting);
			this.out.p1(this.privateChatSetting);
			this.out.p1(this.tradeChatSetting);
		}
		if (super.mouseClickX >= 137 && super.mouseClickX <= 237 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
			this.privateChatSetting = (this.privateChatSetting + 1) % 3;
			this.redrawPrivacySettings = true;
			this.redrawChatback = true;
			this.out.p1isaac(244);
			this.out.p1(this.publicChatSetting);
			this.out.p1(this.privateChatSetting);
			this.out.p1(this.tradeChatSetting);
		}
		if (super.mouseClickX >= 275 && super.mouseClickX <= 375 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
			this.tradeChatSetting = (this.tradeChatSetting + 1) % 3;
			this.redrawPrivacySettings = true;
			this.redrawChatback = true;
			this.out.p1isaac(244);
			this.out.p1(this.publicChatSetting);
			this.out.p1(this.privateChatSetting);
			this.out.p1(this.tradeChatSetting);
		}
		if (super.mouseClickX >= 416 && super.mouseClickX <= 516 && super.mouseClickY >= 490 && super.mouseClickY <= 522) {
			this.closeInterfaces();
			this.reportAbuseInput = "";
			this.reportAbuseMuteOption = false;
			for (@Pc(186) int local186 = 0; local186 < IfType.instances.length; local186++) {
				if (IfType.instances[local186] != null && IfType.instances[local186].contentType == 600) {
					this.reportAbuseInterfaceID = this.viewportInterfaceId = IfType.instances[local186].parentId;
					return;
				}
			}
			return;
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(III)V")
	private void handleChatMouseInput(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2) {
		@Pc(1) int local1 = 0;
		for (@Pc(3) int local3 = 0; local3 < 100; local3++) {
			if (this.messageText[local3] != null) {
				@Pc(15) int local15 = this.messageType[local3];
				@Pc(26) int local26 = this.chatScrollOffset + 70 + 4 - local1 * 14;
				if (local26 < -20) {
					break;
				}
				if (local15 == 0) {
					local1++;
				}
				if ((local15 == 1 || local15 == 2) && (local15 == 1 || this.publicChatSetting == 0 || this.publicChatSetting == 1 && this.isFriend(this.messageSender[local3]))) {
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
				if ((local15 == 3 || local15 == 7) && this.splitPrivateChat == 0 && (local15 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[local3]))) {
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
				if (local15 == 4 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[local3]))) {
					if (arg0 > local26 - 14 && arg0 <= local26) {
						this.menuOption[this.menuSize] = "Accept trade @whi@" + this.messageSender[local3];
						this.menuAction[this.menuSize] = 903;
						this.menuSize++;
					}
					local1++;
				}
				if ((local15 == 5 || local15 == 6) && this.splitPrivateChat == 0 && this.privateChatSetting < 2) {
					local1++;
				}
				if (local15 == 8 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[local3]))) {
					if (arg0 > local26 - 14 && arg0 <= local26) {
						this.menuOption[this.menuSize] = "Accept duel @whi@" + this.messageSender[local3];
						this.menuAction[this.menuSize] = 363;
						this.menuSize++;
					}
					local1++;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(I)V")
	private void pushPlayers() {
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
			if (local30 != null && local30.isVisible()) {
				local30.lowMemory = false;
				if ((lowMemory && this.playerCount > 50 || this.playerCount > 200) && local22 != -1 && local30.secondarySeqId == local30.seqStandId) {
					local30.lowMemory = true;
				}
				@Pc(87) int local87 = local30.x >> 7;
				@Pc(92) int local92 = local30.z >> 7;
				if (local87 >= 0 && local87 < 104 && local92 >= 0 && local92 < 104) {
					if (local30.locModel == null || loopCycle < local30.locStartCycle || loopCycle >= local30.locStopCycle) {
						if ((local30.x & 0x7F) == 64 && (local30.z & 0x7F) == 64) {
							if (this.tileLastOccupiedCycle[local87][local92] == this.sceneCycle) {
								continue;
							}
							this.tileLastOccupiedCycle[local87][local92] = this.sceneCycle;
						}
						local30.y = this.getHeightmapY(this.currentLevel, local30.x, local30.z);
						this.world3D.addTemporary(local30.z, 60, local30.seqDelay, local30.x, local35, local30.seqStretches, null, local30, local30.y, this.currentLevel);
					} else {
						local30.lowMemory = false;
						local30.y = this.getHeightmapY(this.currentLevel, local30.x, local30.z);
						this.world3D.addTemporary(local30.maxTileX, null, local30.z, local30.y, local35, local30.seqDelay, local30.minTileZ, local30.minTileX, local30, this.currentLevel, local30.maxTileZ, local30.x);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIBI)I")
	private int getHeightmapY(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) {
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
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!bc;IIII)V")
	private void addNpcOptions(@OriginalArg(0) NpcType npc, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4) {
		if (this.menuSize >= 400) {
			return;
		}

		@Pc(16) String name = npc.name;
		if (npc.vislevel != 0) {
			name = name + getCombatLevelColorTag(this.localPlayer.combatLevel, npc.vislevel) + " (level-" + npc.vislevel + ")";
		}
		if (this.objSelected == 1) {
			this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @yel@" + name;
			this.menuAction[this.menuSize] = 900;
			this.menuParamC[this.menuSize] = arg4;
			this.menuParamA[this.menuSize] = arg3;
			this.menuParamB[this.menuSize] = arg2;
			this.menuSize++;
		} else if (this.spellSelected != 1) {
			@Pc(155) int local155;
			if (npc.ops != null) {
				for (local155 = 4; local155 >= 0; local155--) {
					if (npc.ops[local155] != null && !npc.ops[local155].equalsIgnoreCase("attack")) {
						this.menuOption[this.menuSize] = npc.ops[local155] + " @yel@" + name;
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
						this.menuParamC[this.menuSize] = arg4;
						this.menuParamA[this.menuSize] = arg3;
						this.menuParamB[this.menuSize] = arg2;
						this.menuSize++;
					}
				}
			}
			if (npc.ops != null) {
				for (local155 = 4; local155 >= 0; local155--) {
					if (npc.ops[local155] != null && npc.ops[local155].equalsIgnoreCase("attack")) {
						@Pc(279) short local279 = 0;
						if (npc.vislevel > this.localPlayer.combatLevel) {
							local279 = 2000;
						}
						this.menuOption[this.menuSize] = npc.ops[local155] + " @yel@" + name;
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
						this.menuParamC[this.menuSize] = arg4;
						this.menuParamA[this.menuSize] = arg3;
						this.menuParamB[this.menuSize] = arg2;
						this.menuSize++;
					}
				}
			}
			this.menuOption[this.menuSize] = "Examine @yel@" + name;
			if (this.showDebug) {
				this.menuOption[this.menuSize] += "@whi@ (" + npc.index + ")";
			}
			this.menuAction[this.menuSize] = 1607;
			this.menuParamC[this.menuSize] = arg4;
			this.menuParamA[this.menuSize] = arg3;
			this.menuParamB[this.menuSize] = arg2;
			this.menuSize++;
		} else if ((this.activeSpellFlags & 0x2) == 2) {
			this.menuOption[this.menuSize] = this.spellCaption + " @yel@" + name;
			this.menuAction[this.menuSize] = 265;
			this.menuParamC[this.menuSize] = arg4;
			this.menuParamA[this.menuSize] = arg3;
			this.menuParamB[this.menuSize] = arg2;
			this.menuSize++;
			return;
		}
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
	private void handleInputKey() {
		while (true) {
			@Pc(13) int local13;
			do {
				while (true) {
					local13 = this.pollKey();
					if (local13 == -1) {
						return;
					}
					if (this.viewportInterfaceId != -1 && this.viewportInterfaceId == this.reportAbuseInterfaceID) {
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
								local153 = JString.toBase37(this.socialInput);
								this.addFriend(local153);
							}
							if (this.socialAction == 2 && this.friendCount > 0) {
								local153 = JString.toBase37(this.socialInput);
								this.removeFriend(local153);
							}
							if (this.socialAction == 3 && this.socialInput.length() > 0) {
								this.out.p1isaac(148);
								this.out.p1(0);
								local193 = this.out.pos;
								this.out.p8(this.socialName37);
								WordPack.pack(this.out, this.socialInput);
								this.out.psize1(this.out.pos - local193);
								this.socialInput = JString.toSentenceCase(this.socialInput);
								this.socialInput = WordFilter.filter(this.socialInput);
								this.addMessage(6, this.socialInput, JString.formatName(JString.fromBase37(this.socialName37)));
								if (this.privateChatSetting == 2) {
									this.privateChatSetting = 1;
									this.redrawPrivacySettings = true;
									this.out.p1isaac(244);
									this.out.p1(this.publicChatSetting);
									this.out.p1(this.privateChatSetting);
									this.out.p1(this.tradeChatSetting);
								}
							}
							if (this.socialAction == 4 && this.ignoreCount < 100) {
								local153 = JString.toBase37(this.socialInput);
								this.addIgnore(local153);
							}
							if (this.socialAction == 5 && this.ignoreCount > 0) {
								local153 = JString.toBase37(this.socialInput);
								this.removeIgnore(local153);
							}
						}
					} else if (this.chatbackInputOpen) {
						if (local13 >= 48 && local13 <= 57 && this.chatbackInput.length() < 10) {
							this.chatbackInput = this.chatbackInput + (char) local13;
							this.redrawChatback = true;
						}
						if (local13 == 8 && this.chatbackInput.length() > 0) {
							this.chatbackInput = this.chatbackInput.substring(0, this.chatbackInput.length() - 1);
							this.redrawChatback = true;
						}
						if (local13 == 13 || local13 == 10) {
							if (this.chatbackInput.length() > 0) {
								local193 = 0;
								try {
									local193 = Integer.parseInt(this.chatbackInput);
								} catch (@Pc(369) Exception local369) {
								}
								this.out.p1isaac(237);
								this.out.p4(local193);
							}
							this.chatbackInputOpen = false;
							this.redrawChatback = true;
						}
					} else if (this.chatInterfaceId == -1) {
						if (local13 >= 32 && local13 <= 122 && this.chatTyped.length() < 80) {
							this.chatTyped = this.chatTyped + (char) local13;
							this.redrawChatback = true;
						}
						if (local13 == 8 && this.chatTyped.length() > 0) {
							this.chatTyped = this.chatTyped.substring(0, this.chatTyped.length() - 1);
							this.redrawChatback = true;
						}
						if ((local13 == 13 || local13 == 10) && this.chatTyped.length() > 0) {
							if (this.chatTyped.equals("::perf")) {
								this.showPerformance = !this.showPerformance;
							} else if (this.chatTyped.equals("::occluders")) {
								this.showOccluders = !this.showOccluders;
							} else if (this.chatTyped.startsWith("::occludert")) {
								try {
									World.OCCLUDER_THRESHOLD = Integer.parseInt(this.chatTyped.substring(12));
									this.buildScene();
								} catch (Exception ignored) {}
							} else if (this.chatTyped.equals("::debug")) {
								this.showDebug = !this.showDebug;
							} else if (this.chatTyped.equals("::authentic")) {
								Draw3D.fixTransparency = false;
								Pix24.bilinearFiltering = false;
								Draw2D.fullViewport = false;
							} else if (this.chatTyped.equals("::qol")) {
								Draw3D.fixTransparency = true;
								Pix24.bilinearFiltering = true;
								Draw2D.fullViewport = true;
							} else if (this.chatTyped.startsWith("::")) {
								this.out.p1isaac(4);
								this.out.p1(this.chatTyped.length() - 1);
								this.out.pjstr(this.chatTyped.substring(2));
							} else {
								@Pc(496) byte local496 = 0;
								if (this.chatTyped.startsWith("yellow:")) {
									local496 = 0;
									this.chatTyped = this.chatTyped.substring(7);
								}
								if (this.chatTyped.startsWith("red:")) {
									local496 = 1;
									this.chatTyped = this.chatTyped.substring(4);
								}
								if (this.chatTyped.startsWith("green:")) {
									local496 = 2;
									this.chatTyped = this.chatTyped.substring(6);
								}
								if (this.chatTyped.startsWith("cyan:")) {
									local496 = 3;
									this.chatTyped = this.chatTyped.substring(5);
								}
								if (this.chatTyped.startsWith("purple:")) {
									local496 = 4;
									this.chatTyped = this.chatTyped.substring(7);
								}
								if (this.chatTyped.startsWith("white:")) {
									local496 = 5;
									this.chatTyped = this.chatTyped.substring(6);
								}
								if (this.chatTyped.startsWith("flash1:")) {
									local496 = 6;
									this.chatTyped = this.chatTyped.substring(7);
								}
								if (this.chatTyped.startsWith("flash2:")) {
									local496 = 7;
									this.chatTyped = this.chatTyped.substring(7);
								}
								if (this.chatTyped.startsWith("flash3:")) {
									local496 = 8;
									this.chatTyped = this.chatTyped.substring(7);
								}
								if (this.chatTyped.startsWith("glow1:")) {
									local496 = 9;
									this.chatTyped = this.chatTyped.substring(6);
								}
								if (this.chatTyped.startsWith("glow2:")) {
									local496 = 10;
									this.chatTyped = this.chatTyped.substring(6);
								}
								if (this.chatTyped.startsWith("glow3:")) {
									local496 = 11;
									this.chatTyped = this.chatTyped.substring(6);
								}
								@Pc(654) byte local654 = 0;
								if (this.chatTyped.startsWith("wave:")) {
									local654 = 1;
									this.chatTyped = this.chatTyped.substring(5);
								}
								if (this.chatTyped.startsWith("scroll:")) {
									local654 = 2;
									this.chatTyped = this.chatTyped.substring(7);
								}
								this.out.p1isaac(158);
								this.out.p1(0);
								@Pc(693) int local693 = this.out.pos;
								this.out.p1(local496);
								this.out.p1(local654);
								WordPack.pack(this.out, this.chatTyped);
								this.out.psize1(this.out.pos - local693);
								this.chatTyped = JString.toSentenceCase(this.chatTyped);
								this.chatTyped = WordFilter.filter(this.chatTyped);
								this.localPlayer.chat = this.chatTyped;
								this.localPlayer.chatColor = local496;
								this.localPlayer.chatStyle = local654;
								this.localPlayer.chatTimer = 150;
								this.addMessage(2, this.localPlayer.chat, this.localPlayer.name);
								if (this.publicChatSetting == 2) {
									this.publicChatSetting = 3;
									this.redrawPrivacySettings = true;
									this.out.p1isaac(244);
									this.out.p1(this.publicChatSetting);
									this.out.p1(this.privateChatSetting);
									this.out.p1(this.tradeChatSetting);
								}
							}
							this.chatTyped = "";
							this.redrawChatback = true;
						}
					}
				}
			} while ((local13 < 97 || local13 > 122) && (local13 < 65 || local13 > 90) && (local13 < 48 || local13 > 57) && local13 != 32);
			if (this.reportAbuseInput.length() < 12) {
				this.reportAbuseInput = this.reportAbuseInput + (char) local13;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Z)V")
	@Override
	protected void draw() {
		if (this.errorStarted || this.errorLoading || this.errorHost) {
			this.drawError();
			return;
		}

		if (this.ingame) {
			this.drawGame();
		} else {
			this.drawTitleScreen();
		}
		this.dragCycles = 0;
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(B)V")
	private void updateTitle() {
		@Pc(17) int local17;
		@Pc(24) int local24;
		if (this.titleScreenState == 0) {
			local17 = super.screenWidth / 2 - 80;
			local24 = super.screenHeight / 2 + 20;
			local24 += 20;
			if (super.mouseClickButton == 1 && super.mouseClickX >= local17 - 75 && super.mouseClickX <= local17 + 75 && super.mouseClickY >= local24 - 20 && super.mouseClickY <= local24 + 20) {
				this.titleScreenState = 3;
				this.titleLoginField = 0;
			}
			local17 = super.screenWidth / 2 + 80;
			if (super.mouseClickButton == 1 && super.mouseClickX >= local17 - 75 && super.mouseClickX <= local17 + 75 && super.mouseClickY >= local24 - 20 && super.mouseClickY <= local24 + 20) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Enter your username & password.";
				this.titleScreenState = 2;
				this.titleLoginField = 0;
			}
		} else if (this.titleScreenState == 2) {
			local17 = super.screenHeight / 2 - 40;
			local17 += 30;
			local17 += 25;
			if (super.mouseClickButton == 1 && super.mouseClickY >= local17 - 15 && super.mouseClickY < local17) {
				this.titleLoginField = 0;
			}
			local17 += 15;
			if (super.mouseClickButton == 1 && super.mouseClickY >= local17 - 15 && super.mouseClickY < local17) {
				this.titleLoginField = 1;
			}
			local17 += 15;
			local24 = super.screenWidth / 2 - 80;
			@Pc(170) int local170 = super.screenHeight / 2 + 50;
			@Pc(171) int local171 = local170 + 20;
			if (super.mouseClickButton == 1 && super.mouseClickX >= local24 - 75 && super.mouseClickX <= local24 + 75 && super.mouseClickY >= local171 - 20 && super.mouseClickY <= local171 + 20) {
				this.login(this.username, this.password, false);
			}
			local24 = super.screenWidth / 2 + 80;
			if (super.mouseClickButton == 1 && super.mouseClickX >= local24 - 75 && super.mouseClickX <= local24 + 75 && super.mouseClickY >= local171 - 20 && super.mouseClickY <= local171 + 20) {
				this.titleScreenState = 0;
				this.username = "";
				this.password = "";
			}
			while (true) {
				while (true) {
					@Pc(254) int local254 = this.pollKey();
					if (local254 == -1) {
						return;
					}
					@Pc(259) boolean local259 = false;
					for (@Pc(261) int local261 = 0; local261 < CHARSET.length(); local261++) {
						if (local254 == CHARSET.charAt(local261)) {
							local259 = true;
							break;
						}
					}
					if (this.titleLoginField == 0) {
						if (local254 == 8 && this.username.length() > 0) {
							this.username = this.username.substring(0, this.username.length() - 1);
						}
						if (local254 == 9 || local254 == 10 || local254 == 13) {
							this.titleLoginField = 1;
						}
						if (local259) {
							this.username = this.username + (char) local254;
						}
						if (this.username.length() > 12) {
							this.username = this.username.substring(0, 12);
						}
					} else if (this.titleLoginField == 1) {
						if (local254 == 8 && this.password.length() > 0) {
							this.password = this.password.substring(0, this.password.length() - 1);
						}
						if (local254 == 9 || local254 == 10 || local254 == 13) {
							this.titleLoginField = 0;
						}
						if (local259) {
							this.password = this.password + (char) local254;
						}
						if (this.password.length() > 20) {
							this.password = this.password.substring(0, 20);
						}
					}
				}
			}
		} else if (this.titleScreenState == 3) {
			local17 = super.screenWidth / 2;
			local24 = super.screenHeight / 2 + 50;
			@Pc(418) int local418 = local24 + 20;
			if (super.mouseClickButton == 1 && super.mouseClickX >= local17 - 75 && super.mouseClickX <= local17 + 75 && super.mouseClickY >= local418 - 20 && super.mouseClickY <= local418 + 20) {
				this.titleScreenState = 0;
				return;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;II)Lclient!ub;")
	private Jagfile loadArchive(@OriginalArg(0) String arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3) {
		@Pc(3) int local3 = 5;
		@Pc(6) byte[] local6 = Signlink.cacheload(arg2);
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
			return new Jagfile(local6);
		}
		while (local6 == null) {
			this.drawProgress("Requesting " + arg0, arg3);
			try {
				local20 = 0;
				@Pc(60) DataInputStream local60 = this.openUrl(arg2 + arg1);
				@Pc(63) byte[] local63 = new byte[6];
				local60.readFully(local63, 0, 6);
				@Pc(74) Packet local74 = new Packet(local63);
				local74.pos = 3;
				@Pc(82) int local82 = local74.g3() + 6;
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
						this.drawProgress("Loading " + arg0 + " - " + local126 + "%", arg3);
					}
					local20 = local126;
				}
				local60.close();
			} catch (@Pc(155) IOException local155) {
				local6 = null;
				for (local20 = local3; local20 > 0; local20--) {
					this.drawProgress("Error loading - Will retry in " + local20 + " secs.", arg3);
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
		Signlink.cachesave(arg2, local6);
		return new Jagfile(local6);
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(Z)V")
	private void unloadTitle() {
		this.flameActive = false;
		while (this.flameThread) {
			this.flameActive = false;
			try {
				Thread.sleep(50L);
			} catch (@Pc(13) Exception local13) {
			}
		}
		this.imageTitlebox = null;
		this.imageTitlebutton = null;
		this.imageRunes = null;
		this.flameGradient = null;
		this.flameGradient0 = null;
		this.flameGradient1 = null;
		this.flameGradient2 = null;
		this.flameBuffer0 = null;
		this.flameBuffer1 = null;
		this.flameBuffer3 = null;
		this.flameBuffer2 = null;
		this.imageFlamesLeft = null;
		this.imageFlamesRight = null;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIII)V")
	private void orbitCamera(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
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
		this.cameraYaw = arg2;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZ)V")
	private void updateTextures(@OriginalArg(0) int arg0) {
		if (lowMemory) {
			return;
		}

		@Pc(17) Pix8 local17;
		@Pc(25) int local25;
		@Pc(33) int local33;
		@Pc(36) byte[] local36;
		@Pc(39) byte[] local39;
		@Pc(41) int local41;
		if (Draw3D.textureCycle[17] >= arg0) {
			local17 = Draw3D.textures[17];
			local25 = local17.width * local17.height - 1;
			local33 = local17.width * this.sceneDelta * 2;
			local36 = local17.pixels;
			local39 = this.textureBuffer;
			for (local41 = 0; local41 <= local25; local41++) {
				local39[local41] = local36[local41 - local33 & local25];
			}
			local17.pixels = local39;
			this.textureBuffer = local36;
			Draw3D.pushTexture(17);
		}
		if (Draw3D.textureCycle[24] >= arg0) {
			local17 = Draw3D.textures[24];
			local25 = local17.width * local17.height - 1;
			local33 = local17.width * this.sceneDelta * 2;
			local36 = local17.pixels;
			local39 = this.textureBuffer;
			for (local41 = 0; local41 <= local25; local41++) {
				local39[local41] = local36[local41 - local33 & local25];
			}
			local17.pixels = local39;
			this.textureBuffer = local36;
			Draw3D.pushTexture(24);
			return;
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(Z)V")
	private void updateFlames() {
		@Pc(3) short local3 = 256;
		@Pc(12) int local12;
		for (@Pc(5) int local5 = 10; local5 < 117; local5++) {
			local12 = (int) (Math.random() * 100.0D);
			if (local12 < 50) {
				this.flameBuffer3[local5 + (local3 - 2 << 7)] = 255;
			}
		}
		@Pc(41) int local41;
		@Pc(48) int local48;
		@Pc(54) int local54;
		for (local12 = 0; local12 < 100; local12++) {
			local41 = (int) (Math.random() * 124.0D) + 2;
			local48 = (int) (Math.random() * 128.0D) + 128;
			local54 = local41 + (local48 << 7);
			this.flameBuffer3[local54] = 192;
		}
		for (local41 = 1; local41 < local3 - 1; local41++) {
			for (local48 = 1; local48 < 127; local48++) {
				local54 = local48 + (local41 << 7);
				this.flameBuffer2[local54] = (this.flameBuffer3[local54 - 1] + this.flameBuffer3[local54 + 1] + this.flameBuffer3[local54 - 128] + this.flameBuffer3[local54 + 128]) / 4;
			}
		}
		this.flameCycle0 += 128;
		if (this.flameCycle0 > this.flameBuffer0.length) {
			this.flameCycle0 -= this.flameBuffer0.length;
			local48 = (int) (Math.random() * 12.0D);
			this.updateFlameBuffer(this.imageRunes[local48]);
		}
		@Pc(173) int local173;
		for (local48 = 1; local48 < local3 - 1; local48++) {
			for (local54 = 1; local54 < 127; local54++) {
				local173 = local54 + (local48 << 7);
				@Pc(196) int local196 = this.flameBuffer2[local173 + 128] - this.flameBuffer0[local173 + this.flameCycle0 & this.flameBuffer0.length - 1] / 5;
				if (local196 < 0) {
					local196 = 0;
				}
				this.flameBuffer3[local173] = local196;
			}
		}
		for (local54 = 0; local54 < local3 - 1; local54++) {
			this.flameLineOffset[local54] = this.flameLineOffset[local54 + 1];
		}
		this.flameLineOffset[local3 - 1] = (int) (Math.sin((double) loopCycle / 14.0D) * 16.0D + Math.sin((double) loopCycle / 15.0D) * 14.0D + Math.sin((double) loopCycle / 16.0D) * 12.0D);
		if (this.flameGradientCycle0 > 0) {
			this.flameGradientCycle0 -= 4;
		}
		if (this.flameGradientCycle1 > 0) {
			this.flameGradientCycle1 -= 4;
		}
		if (this.flameGradientCycle0 == 0 && this.flameGradientCycle1 == 0) {
			local173 = (int) (Math.random() * 2000.0D);
			if (local173 == 0) {
				this.flameGradientCycle0 = 1024;
			}
			if (local173 == 1) {
				this.flameGradientCycle1 = 1024;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
	private void drawMinimap() {
		this.areaMapback.bind();
		@Pc(18) int local18 = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
		@Pc(26) int local26 = this.localPlayer.x / 32 + 48;
		@Pc(34) int local34 = 464 - this.localPlayer.z / 32;
		this.imageMinimap.drawRotatedMasked(local18, 146, this.minimapMaskLineOffsets, 151, local34, this.minimapZoom + 256, local26, 21, 9, this.minimapMaskLineLengths);
		this.imageCompass.drawRotatedMasked(this.orbitCameraYaw, 33, this.compassMaskLineOffsets, 33, 25, 256, 25, 0, 0, this.compassMaskLineLengths);
		for (@Pc(72) int local72 = 0; local72 < this.activeMapFunctionCount; local72++) {
			local26 = this.activeMapFunctionX[local72] * 4 + 2 - this.localPlayer.x / 32;
			local34 = this.activeMapFunctionZ[local72] * 4 + 2 - this.localPlayer.z / 32;
			this.drawOnMinimap(local34, this.activeMapFunctions[local72], local26);
		}
		@Pc(124) int local124;
		for (@Pc(120) int local120 = 0; local120 < 104; local120++) {
			for (local124 = 0; local124 < 104; local124++) {
				@Pc(136) LinkList local136 = this.levelObjStacks[this.currentLevel][local120][local124];
				if (local136 != null) {
					local26 = local120 * 4 + 2 - this.localPlayer.x / 32;
					local34 = local124 * 4 + 2 - this.localPlayer.z / 32;
					this.drawOnMinimap(local34, this.imageMapdot0, local26);
				}
			}
		}
		for (local124 = 0; local124 < this.npcCount; local124++) {
			@Pc(189) NpcEntity local189 = this.npcs[this.npcIds[local124]];
			if (local189 != null && local189.isVisible() && local189.type.visonmap) {
				local26 = local189.x / 32 - this.localPlayer.x / 32;
				local34 = local189.z / 32 - this.localPlayer.z / 32;
				this.drawOnMinimap(local34, this.imageMapdot1, local26);
			}
		}
		for (@Pc(235) int local235 = 0; local235 < this.playerCount; local235++) {
			@Pc(245) PlayerEntity local245 = this.players[this.playerIds[local235]];
			if (local245 != null && local245.isVisible()) {
				local26 = local245.x / 32 - this.localPlayer.x / 32;
				local34 = local245.z / 32 - this.localPlayer.z / 32;
				@Pc(275) boolean local275 = false;
				@Pc(279) long local279 = JString.toBase37(local245.name);
				for (@Pc(281) int local281 = 0; local281 < this.friendCount; local281++) {
					if (local279 == this.friendName37[local281] && this.friendWorld[local281] != 0) {
						local275 = true;
						break;
					}
				}
				if (local275) {
					this.drawOnMinimap(local34, this.imageMapdot3, local26);
				} else {
					this.drawOnMinimap(local34, this.imageMapdot2, local26);
				}
			}
		}
		if (this.flagSceneTileX != 0) {
			local26 = this.flagSceneTileX * 4 + 2 - this.localPlayer.x / 32;
			local34 = this.flagSceneTileZ * 4 + 2 - this.localPlayer.z / 32;
			this.drawOnMinimap(local34, this.imageMapflag, local26);
		}
		Draw2D.fillRect(82, 93, 16777215, 3, 3);
		this.areaViewport.bind();
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(B)Ljava/awt/Component;")
	@Override
	protected Component getBaseComponent() {
		return this;
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(I)V")
	private void updateTemporaryLocs() {
		if (this.sceneState != 2) {
			return;
		}

		for (@Pc(12) LocSpawned local12 = (LocSpawned) this.temporaryLocs.peekFront(); local12 != null; local12 = (LocSpawned) this.temporaryLocs.prev()) {
			if (loopCycle >= local12.lastCycle) {
				this.addLoc(local12.orientation, local12.x, local12.z, local12.classType, local12.locIndex, local12.type, local12.plane);
				local12.unlink();
			}
		}
		updateTemporaryLocsCounter++;
		if (updateTemporaryLocsCounter > 85) {
			updateTemporaryLocsCounter = 0;
			this.out.p1isaac(85);
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(II)V")
	private void createMinimap(@OriginalArg(0) int arg0) {
		@Pc(5) int[] local5 = this.imageMinimap.pixels;
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
					this.world3D.drawMinimapTile(local5, local37, 512, arg0, local39, local25);
				}
				if (arg0 < 3 && (this.levelTileFlags[arg0 + 1][local39][local25] & 0x8) != 0) {
					this.world3D.drawMinimapTile(local5, local37, 512, arg0 + 1, local39, local25);
				}
				local37 += 4;
			}
		}
		local37 = ((int) (Math.random() * 20.0D) + 238 - 10 << 16) + ((int) (Math.random() * 20.0D) + 238 - 10 << 8) + (int) (Math.random() * 20.0D) + 238 - 10;
		local39 = (int) (Math.random() * 20.0D) + 238 - 10 << 16;
		this.imageMinimap.bind();
		@Pc(149) int local149;
		for (@Pc(145) int local145 = 1; local145 < 103; local145++) {
			for (local149 = 1; local149 < 103; local149++) {
				if ((this.levelTileFlags[arg0][local149][local145] & 0x18) == 0) {
					this.drawMinimapLoc(arg0, local37, local149, local39, local145);
				}
				if (arg0 < 3 && (this.levelTileFlags[arg0 + 1][local149][local145] & 0x8) != 0) {
					this.drawMinimapLoc(arg0 + 1, local37, local149, local39, local145);
				}
			}
		}
		this.areaViewport.bind();
		this.activeMapFunctionCount = 0;
		for (local149 = 0; local149 < 104; local149++) {
			for (@Pc(217) int local217 = 0; local217 < 104; local217++) {
				@Pc(227) int local227 = this.world3D.getGroundDecorationBitset(this.currentLevel, local149, local217);
				if (local227 != 0) {
					local227 = local227 >> 14 & 0x7FFF;
					@Pc(239) int local239 = LocType.get(local227).mapfunction;
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
						this.activeMapFunctions[this.activeMapFunctionCount] = this.imageMapfunction[local239];
						this.activeMapFunctionX[this.activeMapFunctionCount] = local243;
						this.activeMapFunctionZ[this.activeMapFunctionCount] = local245;
						this.activeMapFunctionCount++;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIII)V")
	private void drawMinimapLoc(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		@Pc(8) int local8 = this.world3D.getWallBitset(arg1, arg3, arg5);
		@Pc(18) int local18;
		@Pc(24) int local24;
		@Pc(28) int local28;
		@Pc(30) int local30;
		@Pc(52) int local52;
		@Pc(58) int local58;
		if (local8 != 0) {
			local18 = this.world3D.getInfo(arg1, arg3, arg5, local8);
			local24 = local18 >> 6 & 0x3;
			local28 = local18 & 0x1F;
			local30 = arg2;
			if (local8 > 0) {
				local30 = arg4;
			}
			@Pc(38) int[] local38 = this.imageMinimap.pixels;
			local52 = arg3 * 4 + (103 - arg5) * 512 * 4 + 24624;
			local58 = local8 >> 14 & 0x7FFF;
			@Pc(61) LocType local61 = LocType.get(local58);
			if (local61.mapscene == -1) {
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
				@Pc(71) Pix8 local71 = this.imageMapscene[local61.mapscene];
				if (local71 != null) {
					@Pc(83) int local83 = (local61.sizeX * 4 - local71.width) / 2;
					@Pc(93) int local93 = (local61.sizeZ * 4 - local71.height) / 2;
					local71.draw((104 - arg5 - local61.sizeZ) * 4 + local93 + 48, arg3 * 4 + 48 + local83);
				}
			}
		}
		local8 = this.world3D.getLocBitset(arg1, arg3, arg5);
		if (local8 != 0) {
			local18 = this.world3D.getInfo(arg1, arg3, arg5, local8);
			local24 = local18 >> 6 & 0x3;
			local28 = local18 & 0x1F;
			local30 = local8 >> 14 & 0x7FFF;
			@Pc(451) LocType local451 = LocType.get(local30);
			@Pc(483) int local483;
			if (local451.mapscene != -1) {
				@Pc(461) Pix8 local461 = this.imageMapscene[local451.mapscene];
				if (local461 != null) {
					local58 = (local451.sizeX * 4 - local461.width) / 2;
					local483 = (local451.sizeZ * 4 - local461.height) / 2;
					local461.draw((104 - arg5 - local451.sizeZ) * 4 + local483 + 48, arg3 * 4 + 48 + local58);
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
		local8 = this.world3D.getGroundDecorationBitset(arg1, arg3, arg5);
		if (local8 != 0) {
			local18 = local8 >> 14 & 0x7FFF;
			@Pc(615) LocType local615 = LocType.get(local18);
			if (local615.mapscene != -1) {
				@Pc(625) Pix8 local625 = this.imageMapscene[local615.mapscene];
				if (local625 != null) {
					local30 = (local615.sizeX * 4 - local625.width) / 2;
					@Pc(647) int local647 = (local615.sizeZ * 4 - local625.height) / 2;
					local625.draw((104 - arg5 - local615.sizeZ) * 4 + local647 + 48, arg3 * 4 + 48 + local30);
					return;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!kb;IZ)V")
	private void readNpcInfo(@OriginalArg(0) Packet arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2) {
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;
		this.readNpcs(arg0, arg1);
		this.readNewNpcs(arg0, arg1);
		this.readNpcUpdates(arg0, arg1);
		@Pc(36) int local36;
		for (@Pc(29) int local29 = 0; local29 < this.entityRemovalCount; local29++) {
			local36 = this.entityRemovalIds[local29];
			if (this.npcs[local36].cycle != loopCycle) {
				this.npcs[local36].type = null;
				this.npcs[local36] = null;
			}
		}
		if (arg0.pos != arg1) {
			System.err.println(this.username + " size mismatch in getnpcpos - pos:" + arg0.pos + " psize:" + arg1);
			throw new RuntimeException("eek");
		}
		for (local36 = 0; local36 < this.npcCount; local36++) {
			if (this.npcs[this.npcIds[local36]] == null) {
				System.err.println(this.username + " null entry in npc list - pos:" + local36 + " size:" + this.npcCount);
				throw new RuntimeException("eek");
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	@Override
	public void startThread(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		super.startThread(arg0, arg1);
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(I)V")
	private void loadTitleImages() {
		this.imageTitlebox = new Pix8(this.archiveTitle, "titlebox", 0);
		this.imageTitlebutton = new Pix8(this.archiveTitle, "titlebutton", 0);
		this.imageRunes = new Pix8[12];
		for (@Pc(32) int local32 = 0; local32 < 12; local32++) {
			this.imageRunes[local32] = new Pix8(this.archiveTitle, "runes", local32);
		}
		this.imageFlamesLeft = new Pix24(128, 265);
		this.imageFlamesRight = new Pix24(128, 265);
		for (@Pc(65) int local65 = 0; local65 < 33920; local65++) {
			this.imageFlamesLeft.pixels[local65] = this.imageTitle0.pixels[local65];
		}
		for (@Pc(83) int local83 = 0; local83 < 33920; local83++) {
			this.imageFlamesRight.pixels[local83] = this.imageTitle1.pixels[local83];
		}
		this.flameGradient0 = new int[256];
		for (@Pc(105) int local105 = 0; local105 < 64; local105++) {
			this.flameGradient0[local105] = local105 * 262144;
		}
		for (@Pc(120) int local120 = 0; local120 < 64; local120++) {
			this.flameGradient0[local120 + 64] = local120 * 1024 + 16711680;
		}
		for (@Pc(139) int local139 = 0; local139 < 64; local139++) {
			this.flameGradient0[local139 + 128] = local139 * 4 + 16776960;
		}
		for (@Pc(158) int local158 = 0; local158 < 64; local158++) {
			this.flameGradient0[local158 + 192] = 16777215;
		}
		this.flameGradient1 = new int[256];
		for (@Pc(177) int local177 = 0; local177 < 64; local177++) {
			this.flameGradient1[local177] = local177 * 1024;
		}
		for (@Pc(192) int local192 = 0; local192 < 64; local192++) {
			this.flameGradient1[local192 + 64] = local192 * 4 + 65280;
		}
		for (@Pc(211) int local211 = 0; local211 < 64; local211++) {
			this.flameGradient1[local211 + 128] = local211 * 262144 + 65535;
		}
		for (@Pc(230) int local230 = 0; local230 < 64; local230++) {
			this.flameGradient1[local230 + 192] = 16777215;
		}
		this.flameGradient2 = new int[256];
		for (@Pc(249) int local249 = 0; local249 < 64; local249++) {
			this.flameGradient2[local249] = local249 * 4;
		}
		for (@Pc(264) int local264 = 0; local264 < 64; local264++) {
			this.flameGradient2[local264 + 64] = local264 * 262144 + 255;
		}
		for (@Pc(283) int local283 = 0; local283 < 64; local283++) {
			this.flameGradient2[local283 + 128] = local283 * 1024 + 16711935;
		}
		for (@Pc(302) int local302 = 0; local302 < 64; local302++) {
			this.flameGradient2[local302 + 192] = 16777215;
		}
		this.flameGradient = new int[256];
		this.flameBuffer0 = new int[32768];
		this.flameBuffer1 = new int[32768];
		this.updateFlameBuffer(null);
		this.flameBuffer3 = new int[32768];
		this.flameBuffer2 = new int[32768];
		this.drawProgress("Connecting to fileserver", 10);
		if (!this.flameActive) {
			this.flamesThread = true;
			this.flameActive = true;
			this.startThread(this, 2);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!kb;I)V")
	private void readPlayers(@OriginalArg(0) int arg0, @OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
		@Pc(6) int local6 = arg1.gBit(8);
		@Pc(10) int local10;
		if (local6 < this.playerCount) {
			for (local10 = local6; local10 < this.playerCount; local10++) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.playerIds[local10];
			}
		}
		if (local6 > this.playerCount) {
			System.err.println(this.username + " Too many players");
			throw new RuntimeException("eek");
		}
		this.playerCount = 0;
		for (local10 = 0; local10 < local6; local10++) {
			@Pc(73) int local73 = this.playerIds[local10];
			@Pc(78) PlayerEntity local78 = this.players[local73];
			@Pc(83) int local83 = arg1.gBit(1);
			if (local83 == 0) {
				this.playerIds[this.playerCount++] = local73;
				local78.cycle = loopCycle;
			} else {
				@Pc(106) int local106 = arg1.gBit(2);
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
						local157 = arg1.gBit(3);
						local78.step(false, local157);
						local167 = arg1.gBit(1);
						if (local167 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = local73;
						}
					} else if (local106 == 2) {
						this.playerIds[this.playerCount++] = local73;
						local78.cycle = loopCycle;
						local157 = arg1.gBit(3);
						local78.step(true, local157);
						local167 = arg1.gBit(3);
						local78.step(true, local167);
						@Pc(225) int local225 = arg1.gBit(1);
						if (local225 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = local73;
						}
					} else if (local106 == 3) {
						this.entityRemovalIds[this.entityRemovalCount++] = local73;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IIIIII)V")
	private void drawScrollbar(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		this.imageScrollbar0.draw(arg2, arg1);
		this.imageScrollbar1.draw(arg2 + arg5 - 16, arg1);
		Draw2D.fillRect(arg2 + 16, arg1, this.SCROLLBAR_TRACK, 16, arg5 - 32);
		@Pc(35) int local35 = (arg5 - 32) * arg5 / arg4;
		if (local35 < 8) {
			local35 = 8;
		}
		@Pc(52) int local52 = (arg5 - local35 - 32) * arg3 / (arg4 - arg5);
		Draw2D.fillRect(arg2 + local52 + 16, arg1, this.SCROLLBAR_GRIP_FOREGROUND, 16, local35);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, arg2 + local52 + 16, local35, arg1);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, arg2 + local52 + 16, local35, arg1 + 1);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, arg2 + local52 + 16, 16, arg1);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, arg2 + local52 + 17, 16, arg1);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_LOWLIGHT, arg2 + local52 + 16, local35, arg1 + 15);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_LOWLIGHT, arg2 + local52 + 17, local35 - 1, arg1 + 14);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_LOWLIGHT, arg2 + local52 + local35 + 15, 16, arg1);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_LOWLIGHT, arg2 + local52 + local35 + 14, 15, arg1 + 1);
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(B)V")
	private void validateCharacterDesign() {
		this.updateDesignModel = true;
		for (@Pc(12) int local12 = 0; local12 < 7; local12++) {
			this.designIdentikits[local12] = -1;
			for (@Pc(21) int local21 = 0; local21 < IdkType.count; local21++) {
				if (!IdkType.instances[local21].disable && IdkType.instances[local21].type == local12 + (this.designGenderMale ? 0 : 7)) {
					this.designIdentikits[local12] = local21;
					break;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BIIZ)V")
	private void saveMidi(@OriginalArg(0) byte[] arg0, @OriginalArg(2) int arg2, @OriginalArg(3) boolean arg3) {
		Signlink.midifade = arg3;
		Signlink.midisave(arg0, arg2);
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(Z)V")
	private void pushNpcs() {
		for (@Pc(1) int local1 = 0; local1 < this.npcCount; local1++) {
			@Pc(11) NpcEntity local11 = this.npcs[this.npcIds[local1]];
			@Pc(20) int local20 = (this.npcIds[local1] << 14) + 536870912;
			if (local11 != null && local11.isVisible()) {
				@Pc(31) int local31 = local11.x >> 7;
				@Pc(36) int local36 = local11.z >> 7;
				if (local31 >= 0 && local31 < 104 && local36 >= 0 && local36 < 104) {
					if (local11.size == 1 && (local11.x & 0x7F) == 64 && (local11.z & 0x7F) == 64) {
						if (this.tileLastOccupiedCycle[local31][local36] == this.sceneCycle) {
							continue;
						}
						this.tileLastOccupiedCycle[local31][local36] = this.sceneCycle;
					}
					this.world3D.addTemporary(local11.z, (local11.size - 1) * 64 + 60, local11.seqDelay, local11.x, local20, local11.seqStretches, null, local11, this.getHeightmapY(this.currentLevel, local11.x, local11.z), this.currentLevel);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZ)V")
	private void setMidiVolume(@OriginalArg(1) int arg1) {
		Signlink.midivol = arg1;
		Signlink.midi = "voladjust";
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(I)V")
	private void drawTitleScreen() {
		this.loadTitle();
		this.imageTitle4.bind();
		this.imageTitlebox.draw(0, 0);
		@Pc(21) short local21 = 360;
		@Pc(23) short local23 = 200;
		@Pc(32) int local32;
		@Pc(50) int local50;
		@Pc(56) int local56;
		if (this.titleScreenState == 0) {
			local32 = local23 / 2 - 20;
			this.fontBold12.drawStringTaggableCenter(local21 / 2, 16776960, true, local32, "Welcome to RuneScape");
			@Pc(44) int local44 = local32 + 30;
			local50 = local21 / 2 - 80;
			local56 = local23 / 2 + 20;
			this.imageTitlebutton.draw(local56 - 20, local50 - 73);
			this.fontBold12.drawStringTaggableCenter(local50, 16777215, true, local56 + 5, "New user");
			@Pc(83) int local83 = local21 / 2 + 80;
			this.imageTitlebutton.draw(local56 - 20, local83 - 73);
			this.fontBold12.drawStringTaggableCenter(local83, 16777215, true, local56 + 5, "Existing User");
		}
		if (this.titleScreenState == 2) {
			local32 = local23 / 2 - 40;
			if (this.loginMessage0.length() > 0) {
				this.fontBold12.drawStringTaggableCenter(local21 / 2, 16776960, true, local32 - 15, this.loginMessage0);
				this.fontBold12.drawStringTaggableCenter(local21 / 2, 16776960, true, local32, this.loginMessage1);
				local32 += 30;
			} else {
				this.fontBold12.drawStringTaggableCenter(local21 / 2, 16776960, true, local32 - 7, this.loginMessage1);
				local32 += 30;
			}
			this.fontBold12.drawStringTaggable(local21 / 2 - 90, local32, "Username: " + this.username + (this.titleLoginField == 0 & loopCycle % 40 < 20 ? "@yel@|" : ""), true, 16777215);
			local32 += 15;
			this.fontBold12.drawStringTaggable(local21 / 2 - 88, local32, "Password: " + JString.toAsterisks(this.password) + (this.titleLoginField == 1 & loopCycle % 40 < 20 ? "@yel@|" : ""), true, 16777215);
			local32 += 15;
			local50 = local21 / 2 - 80;
			local56 = local23 / 2 + 50;
			this.imageTitlebutton.draw(local56 - 20, local50 - 73);
			this.fontBold12.drawStringTaggableCenter(local50, 16777215, true, local56 + 5, "Login");
			local50 = local21 / 2 + 80;
			this.imageTitlebutton.draw(local56 - 20, local50 - 73);
			this.fontBold12.drawStringTaggableCenter(local50, 16777215, true, local56 + 5, "Cancel");
		}
		if (this.titleScreenState == 3) {
			this.fontBold12.drawStringTaggableCenter(local21 / 2, 16776960, true, local23 / 2 - 60, "Create a free account");
			local32 = local23 / 2 - 35;
			this.fontBold12.drawStringTaggableCenter(local21 / 2, 16777215, true, local32, "To create a new account you need to");
			local32 += 15;
			this.fontBold12.drawStringTaggableCenter(local21 / 2, 16777215, true, local32, "go back to the main RuneScape webpage");
			local32 += 15;
			this.fontBold12.drawStringTaggableCenter(local21 / 2, 16777215, true, local32, "and choose the red 'create account'");
			local32 += 15;
			this.fontBold12.drawStringTaggableCenter(local21 / 2, 16777215, true, local32, "button at the top right of that page.");
			local32 += 15;
			local50 = local21 / 2;
			local56 = local23 / 2 + 50;
			this.imageTitlebutton.draw(local56 - 20, local50 - 73);
			this.fontBold12.drawStringTaggableCenter(local50, 16777215, true, local56 + 5, "Cancel");
		}
		this.imageTitle4.draw(186, super.graphics, 214);
		if (this.redrawTitleBackground) {
			this.redrawTitleBackground = false;
			this.imageTitle2.draw(0, super.graphics, 128);
			this.imageTitle3.draw(386, super.graphics, 214);
			this.imageTitle5.draw(265, super.graphics, 0);
			this.imageTitle6.draw(265, super.graphics, 574);
			this.imageTitle7.draw(186, super.graphics, 128);
			this.imageTitle8.draw(186, super.graphics, 574);
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(I)V")
	private void prepareGameScreen() {
		if (this.areaChatback != null) {
			return;
		}

		this.unloadTitle();
		super.pixMap = null;
		this.imageTitle2 = null;
		this.imageTitle3 = null;
		this.imageTitle4 = null;
		this.imageTitle0 = null;
		this.imageTitle1 = null;
		this.imageTitle5 = null;
		this.imageTitle6 = null;
		this.imageTitle7 = null;
		this.imageTitle8 = null;
		this.areaChatback = new PixMap(this.getBaseComponent(), 479, 96);
		this.areaMapback = new PixMap(this.getBaseComponent(), 168, 160);
		Draw2D.clear();
		this.imageMapback.draw(0, 0);
		this.areaSidebar = new PixMap(this.getBaseComponent(), 190, 261);
		this.areaViewport = new PixMap(this.getBaseComponent(), 512, 334);
		Draw2D.clear();
		this.areaBackbase1 = new PixMap(this.getBaseComponent(), 501, 61);
		this.areaBackbase2 = new PixMap(this.getBaseComponent(), 288, 40);
		this.areaBackhmid1 = new PixMap(this.getBaseComponent(), 269, 66);
		this.redrawTitleBackground = true;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!kb;)V")
	private void readNewPlayers(@OriginalArg(1) int arg1, @OriginalArg(2) Packet arg2) {
		@Pc(9) int local9;
		while (arg2.bitPosition + 10 < arg1 * 8) {
			local9 = arg2.gBit(11);
			if (local9 == 2047) {
				break;
			}
			if (this.players[local9] == null) {
				this.players[local9] = new PlayerEntity();
				if (this.playerAppearanceBuffer[local9] != null) {
					this.players[local9].read(this.playerAppearanceBuffer[local9]);
				}
			}
			this.playerIds[this.playerCount++] = local9;
			@Pc(73) PlayerEntity local73 = this.players[local9];
			local73.cycle = loopCycle;
			@Pc(81) int local81 = arg2.gBit(5);
			if (local81 > 15) {
				local81 -= 32;
			}
			@Pc(90) int local90 = arg2.gBit(5);
			if (local90 > 15) {
				local90 -= 32;
			}
			@Pc(99) int local99 = arg2.gBit(1);
			local73.move(local99 == 1, this.localPlayer.pathTileX[0] + local81, this.localPlayer.pathTileZ[0] + local90);
			@Pc(127) int local127 = arg2.gBit(1);
			if (local127 == 1) {
				this.entityUpdateIds[this.entityUpdateCount++] = local9;
			}
		}
		arg2.accessBytes();
	}

	@OriginalMember(owner = "client!client", name = "q", descriptor = "(I)V")
	private void logout() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (@Pc(9) Exception local9) {
		}
		this.connection = null;
		this.ingame = false;
		this.titleScreenState = 0;
		this.username = "";
		this.password = "";
		TrackInput.setDisabled();
		this.clearCaches();
		this.world3D.reset();
		this.sceneState = 0;
		for (@Pc(41) int local41 = 0; local41 < 4; local41++) {
			this.levelCollisionMap[local41].reset();
		}
		System.gc();
		this.stopMidi();
		this.currentMidi = null;
		this.nextMusicDelay = 0;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;I)V")
	private void drawParentInterface(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(3) IfType arg3, @OriginalArg(4) int arg4) {
		if (arg3.type != 0 || arg3.childId == null || (arg3.hide && this.viewportHoveredInterfaceIndex != arg3.id && this.sidebarHoveredInterfaceIndex != arg3.id && this.chatHoveredInterfaceIndex != arg3.id)) {
			return;
		}

		@Pc(29) int local29 = Draw2D.left;
		@Pc(31) int local31 = Draw2D.top;
		@Pc(33) int local33 = Draw2D.right;
		@Pc(35) int local35 = Draw2D.bottom;
		Draw2D.setBounds(arg0 + arg3.height, arg0, arg1 + arg3.width, arg1);
		@Pc(57) int local57 = arg3.childId.length;
		for (@Pc(59) int local59 = 0; local59 < local57; local59++) {
			@Pc(68) int local68 = arg3.childX[local59] + arg1;
			@Pc(77) int local77 = arg3.childY[local59] + arg0 - arg4;
			@Pc(84) IfType local84 = IfType.instances[arg3.childId[local59]];
			@Pc(89) int local89 = local68 + local84.x;
			@Pc(94) int local94 = local77 + local84.y;
			if (local84.contentType > 0) {
				this.updateInterfaceContent(local84);
			}
			if (local84.type == 0) {
				if (local84.scrollPosition > local84.scrollableHeight - local84.height) {
					local84.scrollPosition = local84.scrollableHeight - local84.height;
				}
				if (local84.scrollPosition < 0) {
					local84.scrollPosition = 0;
				}
				this.drawParentInterface(local94, local89, local84, local84.scrollPosition);
				if (local84.scrollableHeight > local84.height) {
					this.drawScrollbar(local89 + local84.width, local94, local84.scrollPosition, local84.scrollableHeight, local84.height);
				}
			} else if (local84.type != 1) {
				@Pc(167) int local167;
				@Pc(171) int local171;
				@Pc(182) int local182;
				@Pc(217) int local217;
				@Pc(224) int local224;
				@Pc(165) int local165;
				@Pc(191) int local191;
				@Pc(215) int local215;
				if (local84.type == 2) {
					local165 = 0;
					for (local167 = 0; local167 < local84.height; local167++) {
						for (local171 = 0; local171 < local84.width; local171++) {
							local182 = local89 + local171 * (local84.inventoryMarginX + 32);
							local191 = local94 + local167 * (local84.inventoryMarginY + 32);
							if (local165 < 20) {
								local182 += local84.inventorySlotOffsetX[local165];
								local191 += local84.inventorySlotOffsetY[local165];
							}
							if (local84.inventorySlotObjId[local165] > 0) {
								local215 = 0;
								local217 = 0;
								local224 = local84.inventorySlotObjId[local165] - 1;
								if (local182 >= -32 && local182 <= 512 && local191 >= -32 && local191 <= 334 || this.objDragArea != 0 && this.objDragSlot == local165) {
									@Pc(251) Pix24 local251 = ObjType.getIcon(local224, 24638, local84.inventorySlotObjCount[local165]);
									if (this.objDragArea != 0 && this.objDragSlot == local165 && this.objDragInterfaceId == local84.id) {
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
										local251.draw(128, local182 + local215, local191 + local217);
									} else if (this.selectedArea != 0 && this.selectedItem == local165 && this.selectedInterface == local84.id) {
										local251.draw(128, local182, local191);
									} else {
										local251.draw(local191, local182);
									}
									if (local251.cropW == 33 || local84.inventorySlotObjCount[local165] != 1) {
										@Pc(351) int local351 = local84.inventorySlotObjCount[local165];
										this.fontPlain11.drawString(local182 + local215 + 1, local191 + 10 + local217, 0, formatObjCount(local351));
										this.fontPlain11.drawString(local182 + local215, local191 + 9 + local217, 16776960, formatObjCount(local351));
									}
								}
							} else if (local84.inventorySlotImage != null && local165 < 20) {
								@Pc(398) Pix24 local398 = local84.inventorySlotImage[local165];
								if (local398 != null) {
									local398.draw(local191, local182);
								}
							}
							local165++;
						}
					}
				} else if (local84.type != 3) {
					@Pc(456) BitmapFont local456;
					if (local84.type == 4) {
						local456 = local84.font;
						local167 = local84.color;
						@Pc(462) String local462 = local84.text;
						if ((this.chatHoveredInterfaceIndex == local84.id || this.sidebarHoveredInterfaceIndex == local84.id || this.viewportHoveredInterfaceIndex == local84.id) && local84.hoverColor != 0) {
							local167 = local84.hoverColor;
						}
						if (this.executeInterfaceScript(local84)) {
							local167 = local84.activeColor;
							if (local84.activeText.length() > 0) {
								local462 = local84.activeText;
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
																	local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(local84, 4)) + local462.substring(local215 + 2);
																}
															}
															local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(local84, 3)) + local462.substring(local215 + 2);
														}
													}
													local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(local84, 2)) + local462.substring(local215 + 2);
												}
											}
											local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(local84, 1)) + local462.substring(local215 + 2);
										}
									}
									local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(local84, 0)) + local462.substring(local215 + 2);
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
							if (local84.center) {
								local456.drawStringTaggableCenter(local89 + local84.width / 2, local167, local84.shadow, local191, local704);
							} else {
								local456.drawStringTaggable(local89, local191, local704, local84.shadow, local167);
							}
							local191 += local456.height;
						}
					} else if (local84.type == 5) {
						@Pc(766) Pix24 local766;
						if (this.executeInterfaceScript(local84)) {
							local766 = local84.activeImage;
						} else {
							local766 = local84.image;
						}
						if (local766 != null) {
							local766.draw(local94, local89);
						}
					} else if (local84.type == 6) {
						local165 = Draw3D.centerX;
						local167 = Draw3D.centerY;
						Draw3D.centerX = local89 + local84.width / 2;
						Draw3D.centerY = local94 + local84.height / 2;
						local171 = Draw3D.sin[local84.modelPitch] * local84.modelZoom >> 16;
						local182 = Draw3D.cos[local84.modelPitch] * local84.modelZoom >> 16;
						@Pc(827) boolean local827 = this.executeInterfaceScript(local84);
						if (local827) {
							local215 = local84.activeSeqId;
						} else {
							local215 = local84.seqId;
						}
						@Pc(846) Model local846;
						if (local215 == -1) {
							local846 = local84.getModel(-1, -1, local827);
						} else {
							@Pc(852) SeqType local852 = SeqType.instances[local215];
							local846 = local84.getModel(local852.primaryFrames[local84.seqFrame], local852.secondaryFrames[local84.seqFrame], local827);
						}
						if (local846 != null) {
							local846.drawSimple(0, local84.modelYaw, 0, local84.modelPitch, 0, local171, local182);
						}
						Draw3D.centerX = local165;
						Draw3D.centerY = local167;
					} else if (local84.type == 7) {
						local456 = local84.font;
						local167 = 0;
						for (local171 = 0; local171 < local84.height; local171++) {
							for (local182 = 0; local182 < local84.width; local182++) {
								if (local84.inventorySlotObjId[local167] > 0) {
									@Pc(915) ObjType local915 = ObjType.get(local84.inventorySlotObjId[local167] - 1);
									@Pc(918) String local918 = local915.name;
									if (local915.stackable || local84.inventorySlotObjCount[local167] != 1) {
										local918 = local918 + " x" + formatObjCountTagged(local84.inventorySlotObjCount[local167]);
									}
									local217 = local89 + local182 * (local84.inventoryMarginX + 115);
									local224 = local94 + local171 * (local84.inventoryMarginY + 12);
									if (local84.center) {
										local456.drawStringTaggableCenter(local217 + local84.width / 2, local84.color, local84.shadow, local224, local918);
									} else {
										local456.drawStringTaggable(local217, local224, local918, local84.shadow, local84.color);
									}
								}
								local167++;
							}
						}
					}
				} else if (local84.fill) {
					Draw2D.fillRect(local94, local89, local84.color, local84.width, local84.height);
				} else {
					Draw2D.drawRect(local89, local84.color, local84.height, local94, local84.width);
				}
			}
		}
		Draw2D.setBounds(local35, local31, local33, local29);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILclient!kb;)V")
	private void readPlayerUpdates(@OriginalArg(1) int arg1, @OriginalArg(2) Packet arg2) {
		for (@Pc(1) int local1 = 0; local1 < this.entityUpdateCount; local1++) {
			@Pc(8) int local8 = this.entityUpdateIds[local1];
			@Pc(13) PlayerEntity local13 = this.players[local8];
			@Pc(16) int local16 = arg2.g1();
			if ((local16 & 0x80) == 128) {
				local16 += arg2.g1() << 8;
			}
			this.readPlayerUpdates(local8, local16, arg2, local13);
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(II)V")
	private void updateVarp(@OriginalArg(0) int arg0) {
		@Pc(8) int local8 = VarpType.instances[arg0].clientcode;
		if (local8 == 0) {
			return;
		}

		@Pc(16) int local16 = this.varps[arg0];
		if (local8 == 1) {
			if (local16 == 1) {
				Draw3D.setBrightness(0.9D);
			}
			if (local16 == 2) {
				Draw3D.setBrightness(0.8D);
			}
			if (local16 == 3) {
				Draw3D.setBrightness(0.7D);
			}
			if (local16 == 4) {
				Draw3D.setBrightness(0.6D);
			}
			ObjType.iconCache.clear();
			this.redrawTitleBackground = true;
		}
		if (local8 == 3) {
			@Pc(54) boolean local54 = this.midiActive;
			if (local16 == 0) {
				this.setMidiVolume(192);
				this.midiActive = true;
			}
			if (local16 == 1) {
				this.setMidiVolume(128);
				this.midiActive = true;
			}
			if (local16 == 2) {
				this.setMidiVolume(64);
				this.midiActive = true;
			}
			if (local16 == 3) {
				this.setMidiVolume(32);
				this.midiActive = true;
			}
			if (local16 == 4) {
				this.midiActive = false;
			}
			if (this.midiActive != local54) {
				if (this.midiActive) {
					this.setMidi(this.midiCrc, this.currentMidi, this.midiSize);
				} else {
					this.stopMidi();
				}
				this.nextMusicDelay = 0;
			}
		}
		if (local8 == 4) {
			if (local16 == 0) {
				this.waveEnabled = true;
				this.setWaveVolume(0);
			}
			if (local16 == 1) {
				this.waveEnabled = true;
				this.setWaveVolume(-400);
			}
			if (local16 == 2) {
				this.waveEnabled = true;
				this.setWaveVolume(-800);
			}
			if (local16 == 3) {
				this.waveEnabled = true;
				this.setWaveVolume(-1200);
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
			this.splitPrivateChat = local16;
			this.redrawChatback = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(Z)V")
	private void updateNpcs() {
		for (@Pc(7) int local7 = 0; local7 < this.npcCount; local7++) {
			@Pc(14) int local14 = this.npcIds[local7];
			@Pc(19) NpcEntity local19 = this.npcs[local14];
			if (local19 != null) {
				this.updateEntity(local19, local19.type.size);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;BI)V")
	private void updateEntity(@OriginalArg(0) PathingEntity arg0, @OriginalArg(2) int arg2) {
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
			this.updateForceMovement(arg0);
		} else if (arg0.forceMoveStartCycle >= loopCycle) {
			this.startForceMovement(arg0);
		} else {
			this.updateMovement(arg0);
		}
		this.updateFacingDirection(arg0);
		this.updateSequences(arg0);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;I)V")
	private void updateForceMovement(@OriginalArg(0) PathingEntity arg0) {
		@Pc(4) int local4 = arg0.forceMoveEndCycle - loopCycle;
		@Pc(14) int local14 = arg0.forceMoveStartSceneTileX * 128 + arg0.size * 64;
		@Pc(24) int local24 = arg0.forceMoveStartSceneTileZ * 128 + arg0.size * 64;
		arg0.x += (local14 - arg0.x) / local4;
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
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!x;I)V")
	private void startForceMovement(@OriginalArg(0) PathingEntity arg0) {
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
		arg0.seqDelay = arg0.dstYaw;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!x;)V")
	private void updateMovement(@OriginalArg(1) PathingEntity arg1) {
		arg1.secondarySeqId = arg1.seqStandId;
		if (arg1.pathLength == 0) {
			arg1.seqPathLength = 0;
			return;
		}

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
			@Pc(168) int local168 = arg1.dstYaw - arg1.seqDelay & 0x7FF;
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
			if (arg1.seqDelay != arg1.dstYaw && arg1.targetId == -1) {
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

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;B)V")
	private void updateFacingDirection(@OriginalArg(0) PathingEntity arg0) {
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
		local61 = arg0.dstYaw - arg0.seqDelay & 0x7FF;
		if (local61 != 0) {
			if (local61 < 32 || local61 > 2016) {
				arg0.seqDelay = arg0.dstYaw;
			} else if (local61 > 1024) {
				arg0.seqDelay -= 32;
			} else {
				arg0.seqDelay += 32;
			}
			arg0.seqDelay &= 0x7FF;
			if (arg0.secondarySeqId == arg0.seqStandId && arg0.seqDelay != arg0.dstYaw) {
				if (arg0.seqTurnId != -1) {
					arg0.secondarySeqId = arg0.seqTurnId;
					return;
				}
				arg0.secondarySeqId = arg0.seqWalkId;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!x;)V")
	private void updateSequences(@OriginalArg(1) PathingEntity arg1) {
		arg1.seqStretches = false;
		@Pc(16) SeqType local16;
		if (arg1.secondarySeqId != -1) {
			local16 = SeqType.instances[arg1.secondarySeqId];
			arg1.secondarySeqCycle++;
			if (arg1.secondarySeqFrame < local16.framecount && arg1.secondarySeqCycle > local16.frameDelay[arg1.secondarySeqFrame]) {
				arg1.secondarySeqCycle = 0;
				arg1.secondarySeqFrame++;
			}
			if (arg1.secondarySeqFrame >= local16.framecount) {
				arg1.secondarySeqCycle = 0;
				arg1.secondarySeqFrame = 0;
			}
		}
		if (arg1.primarySeqId != -1 && arg1.primarySeqDelay == 0) {
			local16 = SeqType.instances[arg1.primarySeqId];
			arg1.primarySeqCycle++;
			while (arg1.primarySeqFrame < local16.framecount && arg1.primarySeqCycle > local16.frameDelay[arg1.primarySeqFrame]) {
				arg1.primarySeqCycle -= local16.frameDelay[arg1.primarySeqFrame];
				arg1.primarySeqFrame++;
			}
			if (arg1.primarySeqFrame >= local16.framecount) {
				arg1.primarySeqFrame -= local16.replayoff;
				arg1.primarySeqLoop++;
				if (arg1.primarySeqLoop >= local16.replaycount) {
					arg1.primarySeqId = -1;
				}
				if (arg1.primarySeqFrame < 0 || arg1.primarySeqFrame >= local16.framecount) {
					arg1.primarySeqId = -1;
				}
			}
			arg1.seqStretches = local16.stretches;
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
			while (arg1.spotanimFrame < local16.framecount && arg1.spotanimCycle > local16.frameDelay[arg1.spotanimFrame]) {
				arg1.spotanimCycle -= local16.frameDelay[arg1.spotanimFrame];
				arg1.spotanimFrame++;
			}
			if (arg1.spotanimFrame >= local16.framecount) {
				if (arg1.spotanimFrame < 0 || arg1.spotanimFrame >= local16.framecount) {
					arg1.spotanimId = -1;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "r", descriptor = "(I)V")
	private void drawGame() {
		if (this.redrawTitleBackground) {
			this.redrawTitleBackground = false;
			this.areaBackleft1.draw(11, super.graphics, 0);
			this.areaBackleft2.draw(375, super.graphics, 0);
			this.areaBackright1.draw(5, super.graphics, 729);
			this.areaBackright2.draw(231, super.graphics, 752);
			this.areaBacktop1.draw(0, super.graphics, 0);
			this.areaBacktop2.draw(0, super.graphics, 561);
			this.areaBackvmid1.draw(11, super.graphics, 520);
			this.areaBackvmid2.draw(231, super.graphics, 520);
			this.areaBackvmid3.draw(375, super.graphics, 501);
			this.areaBackhmid2.draw(345, super.graphics, 0);
			this.redrawSidebar = true;
			this.redrawChatback = true;
			this.redrawSideicons = true;
			this.redrawPrivacySettings = true;
			if (this.sceneState != 2) {
				this.areaViewport.draw(11, super.graphics, 8);
				this.areaMapback.draw(5, super.graphics, 561);
			}
		}
		if (this.sceneState == 2) {
			this.drawScene();
		}
		if (this.menuVisible && this.menuArea == 1) {
			this.redrawSidebar = true;
		}
		@Pc(152) boolean local152;
		if (this.sidebarInterfaceId != -1) {
			local152 = this.updateInterfaceAnimation(this.sidebarInterfaceId, this.sceneDelta);
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
			this.drawSidebar();
			this.redrawSidebar = false;
		}
		if (this.chatInterfaceId == -1) {
			this.chatInterface.scrollPosition = this.chatScrollHeight - this.chatScrollOffset - 77;
			if (super.mouseX > 453 && super.mouseX < 565 && super.mouseY > 350) {
				this.handleScrollInput(super.mouseX - 22, super.mouseY - 375, this.chatScrollHeight, 77, false, 463, 0, this.chatInterface);
			}
			@Pc(234) int local234 = this.chatScrollHeight - this.chatInterface.scrollPosition - 77;
			if (local234 < 0) {
				local234 = 0;
			}
			if (local234 > this.chatScrollHeight - 77) {
				local234 = this.chatScrollHeight - 77;
			}
			if (this.chatScrollOffset != local234) {
				this.chatScrollOffset = local234;
				this.redrawChatback = true;
			}
		}
		if (this.chatInterfaceId != -1) {
			local152 = this.updateInterfaceAnimation(this.chatInterfaceId, this.sceneDelta);
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
			this.drawChatback();
			this.redrawChatback = false;
		}
		if (this.sceneState == 2) {
			this.drawMinimap();
			this.areaMapback.draw(5, super.graphics, 561);
		}
		if (this.flashingTab != -1) {
			this.redrawSideicons = true;
		}
		if (this.redrawSideicons) {
			if (this.flashingTab != -1 && this.flashingTab == this.selectedTab) {
				this.flashingTab = -1;
				this.out.p1isaac(175);
				this.out.p1(this.selectedTab);
			}
			this.redrawSideicons = false;
			this.areaBackhmid1.bind();
			this.imageBackhmid1.draw(0, 0);
			if (this.sidebarInterfaceId == -1) {
				if (this.tabInterfaceId[this.selectedTab] != -1) {
					if (this.selectedTab == 0) {
						this.imageRedstone1.draw(30, 29);
					}
					if (this.selectedTab == 1) {
						this.imageRedstone2.draw(29, 59);
					}
					if (this.selectedTab == 2) {
						this.imageRedstone2.draw(29, 87);
					}
					if (this.selectedTab == 3) {
						this.imageRedstone3.draw(29, 115);
					}
					if (this.selectedTab == 4) {
						this.imageRedstone2h.draw(29, 156);
					}
					if (this.selectedTab == 5) {
						this.imageRedstone2h.draw(29, 184);
					}
					if (this.selectedTab == 6) {
						this.imageRedstone1h.draw(30, 212);
					}
				}
				if (this.tabInterfaceId[0] != -1 && (this.flashingTab != 0 || loopCycle % 20 < 10)) {
					this.imageSideicons[0].draw(34, 35);
				}
				if (this.tabInterfaceId[1] != -1 && (this.flashingTab != 1 || loopCycle % 20 < 10)) {
					this.imageSideicons[1].draw(32, 59);
				}
				if (this.tabInterfaceId[2] != -1 && (this.flashingTab != 2 || loopCycle % 20 < 10)) {
					this.imageSideicons[2].draw(32, 86);
				}
				if (this.tabInterfaceId[3] != -1 && (this.flashingTab != 3 || loopCycle % 20 < 10)) {
					this.imageSideicons[3].draw(33, 121);
				}
				if (this.tabInterfaceId[4] != -1 && (this.flashingTab != 4 || loopCycle % 20 < 10)) {
					this.imageSideicons[4].draw(34, 157);
				}
				if (this.tabInterfaceId[5] != -1 && (this.flashingTab != 5 || loopCycle % 20 < 10)) {
					this.imageSideicons[5].draw(32, 185);
				}
				if (this.tabInterfaceId[6] != -1 && (this.flashingTab != 6 || loopCycle % 20 < 10)) {
					this.imageSideicons[6].draw(34, 212);
				}
			}
			this.areaBackhmid1.draw(165, super.graphics, 520);
			this.areaBackbase2.bind();
			this.imageBackbase2.draw(0, 0);
			if (this.sidebarInterfaceId == -1) {
				if (this.tabInterfaceId[this.selectedTab] != -1) {
					if (this.selectedTab == 7) {
						this.imageRedstone1v.draw(0, 49);
					}
					if (this.selectedTab == 8) {
						this.imageRedstone2v.draw(0, 81);
					}
					if (this.selectedTab == 9) {
						this.imageRedstone2v.draw(0, 108);
					}
					if (this.selectedTab == 10) {
						this.imageRedstone3v.draw(1, 136);
					}
					if (this.selectedTab == 11) {
						this.imageRedstone2hv.draw(0, 178);
					}
					if (this.selectedTab == 12) {
						this.imageRedstone2hv.draw(0, 205);
					}
					if (this.selectedTab == 13) {
						this.imageRedstone1hv.draw(0, 233);
					}
				}
				if (this.tabInterfaceId[8] != -1 && (this.flashingTab != 8 || loopCycle % 20 < 10)) {
					this.imageSideicons[7].draw(2, 80);
				}
				if (this.tabInterfaceId[9] != -1 && (this.flashingTab != 9 || loopCycle % 20 < 10)) {
					this.imageSideicons[8].draw(3, 107);
				}
				if (this.tabInterfaceId[10] != -1 && (this.flashingTab != 10 || loopCycle % 20 < 10)) {
					this.imageSideicons[9].draw(4, 142);
				}
				if (this.tabInterfaceId[11] != -1 && (this.flashingTab != 11 || loopCycle % 20 < 10)) {
					this.imageSideicons[10].draw(2, 179);
				}
				if (this.tabInterfaceId[12] != -1 && (this.flashingTab != 12 || loopCycle % 20 < 10)) {
					this.imageSideicons[11].draw(2, 206);
				}
				if (this.tabInterfaceId[13] != -1 && (this.flashingTab != 13 || loopCycle % 20 < 10)) {
					this.imageSideicons[12].draw(2, 230);
				}
			}
			this.areaBackbase2.draw(492, super.graphics, 501);
			this.areaViewport.bind();
		}
		if (this.redrawPrivacySettings) {
			this.redrawPrivacySettings = false;
			this.areaBackbase1.bind();
			this.imageBackbase1.draw(0, 0);
			this.fontPlain12.drawStringTaggableCenter(57, 16777215, true, 33, "Public chat");
			if (this.publicChatSetting == 0) {
				this.fontPlain12.drawStringTaggableCenter(57, 65280, true, 46, "On");
			}
			if (this.publicChatSetting == 1) {
				this.fontPlain12.drawStringTaggableCenter(57, 16776960, true, 46, "Friends");
			}
			if (this.publicChatSetting == 2) {
				this.fontPlain12.drawStringTaggableCenter(57, 16711680, true, 46, "Off");
			}
			if (this.publicChatSetting == 3) {
				this.fontPlain12.drawStringTaggableCenter(57, 65535, true, 46, "Hide");
			}
			this.fontPlain12.drawStringTaggableCenter(186, 16777215, true, 33, "Private chat");
			if (this.privateChatSetting == 0) {
				this.fontPlain12.drawStringTaggableCenter(186, 65280, true, 46, "On");
			}
			if (this.privateChatSetting == 1) {
				this.fontPlain12.drawStringTaggableCenter(186, 16776960, true, 46, "Friends");
			}
			if (this.privateChatSetting == 2) {
				this.fontPlain12.drawStringTaggableCenter(186, 16711680, true, 46, "Off");
			}
			this.fontPlain12.drawStringTaggableCenter(326, 16777215, true, 33, "Trade/duel");
			if (this.tradeChatSetting == 0) {
				this.fontPlain12.drawStringTaggableCenter(326, 65280, true, 46, "On");
			}
			if (this.tradeChatSetting == 1) {
				this.fontPlain12.drawStringTaggableCenter(326, 16776960, true, 46, "Friends");
			}
			if (this.tradeChatSetting == 2) {
				this.fontPlain12.drawStringTaggableCenter(326, 16711680, true, 46, "Off");
			}
			this.fontPlain12.drawStringTaggableCenter(462, 16777215, true, 38, "Report abuse");
			this.areaBackbase1.draw(471, super.graphics, 0);
			this.areaViewport.bind();
		}
		this.sceneDelta = 0;
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(II)Z")
	private boolean isAddFriendOption(@OriginalArg(1) int arg1) {
		if (arg1 < 0) {
			return false;
		}
		@Pc(8) int local8 = this.menuAction[arg1];
		if (local8 >= 2000) {
			local8 -= 2000;
		}
		return local8 == 406;
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(II)V")
	private void useMenuOption(@OriginalArg(1) int arg1) {
		if (this.chatbackInputOpen) {
			this.chatbackInputOpen = false;
			this.redrawChatback = true;
		}
		@Pc(18) int local18 = this.menuParamA[arg1];
		@Pc(23) int local23 = this.menuParamB[arg1];
		@Pc(28) int local28 = this.menuAction[arg1];
		@Pc(33) int local33 = this.menuParamC[arg1];
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
				local69 = JString.formatName(JString.fromBase37(JString.toBase37(local48)));
				@Pc(71) boolean local71 = false;
				for (local73 = 0; local73 < this.playerCount; local73++) {
					@Pc(83) PlayerEntity local83 = this.players[this.playerIds[local73]];
					if (local83 != null && local83.name != null && local83.name.equalsIgnoreCase(local69)) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local83.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local83.pathTileZ[0], 0, 0, 0);
						if (local28 == 903) {
							this.out.p1isaac(206);
						}
						if (local28 == 363) {
							this.out.p1isaac(164);
						}
						this.out.p2(this.playerIds[local73]);
						local71 = true;
						break;
					}
				}
				if (!local71) {
					this.addMessage(0, "Unable to find " + local69, "");
				}
			}
		}
		if (local28 == 450 && this.interactWithLoc(75, local18, local23, local33)) {
			this.out.p2(this.objInterface);
			this.out.p2(this.objSelectedSlot);
			this.out.p2(this.objSelectedInterface);
		}
		if (local28 == 405 || local28 == 38 || local28 == 422 || local28 == 478 || local28 == 347) {
			if (local28 == 478) {
				if ((local18 & 0x3) == 0) {
					opHeld1Counter++;
				}
				if (opHeld1Counter >= 90) {
					this.out.p1isaac(220);
				}
				this.out.p1isaac(157);
			}
			if (local28 == 347) {
				this.out.p1isaac(211);
			}
			if (local28 == 422) {
				this.out.p1isaac(133);
			}
			if (local28 == 405) {
				opHeld4Counter += local33;
				if (opHeld4Counter >= 97) {
					this.out.p1isaac(30);
					this.out.p3(14953816);
				}
				this.out.p1isaac(195);
			}
			if (local28 == 38) {
				this.out.p1isaac(71);
			}
			this.out.p2(local33);
			this.out.p2(local18);
			this.out.p2(local23);
			this.selectedCycle = 0;
			this.selectedInterface = local23;
			this.selectedItem = local18;
			this.selectedArea = 2;
			if (IfType.instances[local23].parentId == this.viewportInterfaceId) {
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
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local345.pathTileZ[0], 0, 0, 0);
				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;
				if (local28 == 542) {
					this.out.p1isaac(8);
				}
				if (local28 == 6) {
					if ((local33 & 0x3) == 0) {
						opNpc3Counter++;
					}
					if (opNpc3Counter >= 124) {
						this.out.p1isaac(88);
						this.out.p4(0);
					}
					this.out.p1isaac(27);
				}
				if (local28 == 963) {
					this.out.p1isaac(113);
				}
				if (local28 == 728) {
					this.out.p1isaac(194);
				}
				if (local28 == 245) {
					if ((local33 & 0x3) == 0) {
						opNpc5Counter++;
					}
					if (opNpc5Counter >= 85) {
						this.out.p1isaac(176);
						this.out.p2(39596);
					}
					this.out.p1isaac(100);
				}
				this.out.p2(local33);
			}
		}
		@Pc(500) boolean local500;
		if (local28 == 217) {
			local500 = this.tryMove(this.localPlayer.pathTileX[0], 0, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 0, local23, 0, 0, 0);
			if (!local500) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 1, local23, 0, 0, 0);
			}
			this.crossX = super.mouseClickX;
			this.crossY = super.mouseClickY;
			this.crossMode = 2;
			this.crossCycle = 0;
			this.out.p1isaac(239);
			this.out.p2(local18 + this.sceneBaseTileX);
			this.out.p2(local23 + this.sceneBaseTileZ);
			this.out.p2(local33);
			this.out.p2(this.objInterface);
			this.out.p2(this.objSelectedSlot);
			this.out.p2(this.objSelectedInterface);
		}
		if (local28 == 1175) {
			@Pc(586) int local586 = local33 >> 14 & 0x7FFF;
			@Pc(589) LocType local589 = LocType.get(local586);
			if (local589.desc == null) {
				local69 = "It's a " + local589.name + ".";
			} else {
				local69 = new String(local589.desc);
			}
			this.addMessage(0, local69, "");
		}
		if (local28 == 285) {
			this.interactWithLoc(245, local18, local23, local33);
		}
		if (local28 == 881) {
			this.out.p1isaac(130);
			this.out.p2(local33);
			this.out.p2(local18);
			this.out.p2(local23);
			this.out.p2(this.objInterface);
			this.out.p2(this.objSelectedSlot);
			this.out.p2(this.objSelectedInterface);
			this.selectedCycle = 0;
			this.selectedInterface = local23;
			this.selectedItem = local18;
			this.selectedArea = 2;
			if (IfType.instances[local23].parentId == this.viewportInterfaceId) {
				this.selectedArea = 1;
			}
			if (IfType.instances[local23].parentId == this.chatInterfaceId) {
				this.selectedArea = 3;
			}
		}
		if (local28 == 391) {
			this.out.p1isaac(48);
			this.out.p2(local33);
			this.out.p2(local18);
			this.out.p2(local23);
			this.out.p2(this.activeSpellId);
			this.selectedCycle = 0;
			this.selectedInterface = local23;
			this.selectedItem = local18;
			this.selectedArea = 2;
			if (IfType.instances[local23].parentId == this.viewportInterfaceId) {
				this.selectedArea = 1;
			}
			if (IfType.instances[local23].parentId == this.chatInterfaceId) {
				this.selectedArea = 3;
			}
		}
		if (local28 == 660) {
			if (this.menuVisible) {
				this.world3D.click(local23 - 11, local18 - 8);
			} else {
				this.world3D.click(super.mouseClickY - 11, super.mouseClickX - 8);
			}
		}
		if (local28 == 188) {
			this.objSelected = 1;
			this.objSelectedSlot = local18;
			this.objSelectedInterface = local23;
			this.objInterface = local33;
			this.objSelectedName = ObjType.get(local33).name;
			this.spellSelected = 0;
		} else {
			if (local28 == 44 && !this.pressedContinueOption) {
				this.out.p1isaac(235);
				this.out.p2(local23);
				this.pressedContinueOption = true;
			}
			@Pc(830) ObjType local830;
			@Pc(845) String local845;
			if (local28 == 1773) {
				local830 = ObjType.get(local33);
				if (local23 >= 100000) {
					local845 = local23 + " x " + local830.name;
				} else if (local830.desc == null) {
					local845 = "It's a " + local830.name + ".";
				} else {
					local845 = new String(local830.desc);
				}
				this.addMessage(0, local845, "");
			}
			if (local28 == 900) {
				local345 = this.npcs[local33];
				if (local345 != null) {
					this.tryMove(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local345.pathTileZ[0], 0, 0, 0);
					this.crossX = super.mouseClickX;
					this.crossY = super.mouseClickY;
					this.crossMode = 2;
					this.crossCycle = 0;
					this.out.p1isaac(202);
					this.out.p2(local33);
					this.out.p2(this.objInterface);
					this.out.p2(this.objSelectedSlot);
					this.out.p2(this.objSelectedInterface);
				}
			}
			@Pc(969) PlayerEntity local969;
			if (local28 == 1373 || local28 == 1544 || local28 == 151 || local28 == 1101) {
				local969 = this.players[local33];
				if (local969 != null) {
					this.tryMove(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local969.pathTileZ[0], 0, 0, 0);
					this.crossX = super.mouseClickX;
					this.crossY = super.mouseClickY;
					this.crossMode = 2;
					this.crossCycle = 0;
					if (local28 == 1101) {
						this.out.p1isaac(164);
					}
					if (local28 == 151) {
						opPlayer2Counter++;
						if (opPlayer2Counter >= 90) {
							this.out.p1isaac(2);
							this.out.p2(31114);
						}
						this.out.p1isaac(53);
					}
					if (local28 == 1373) {
						this.out.p1isaac(206);
					}
					if (local28 == 1544) {
						this.out.p1isaac(185);
					}
					this.out.p2(local33);
				}
			}
			if (local28 == 265) {
				local345 = this.npcs[local33];
				if (local345 != null) {
					this.tryMove(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local345.pathTileZ[0], 0, 0, 0);
					this.crossX = super.mouseClickX;
					this.crossY = super.mouseClickY;
					this.crossMode = 2;
					this.crossCycle = 0;
					this.out.p1isaac(134);
					this.out.p2(local33);
					this.out.p2(this.activeSpellId);
				}
			}
			@Pc(1156) long local1156;
			if (local28 == 679) {
				local48 = this.menuOption[arg1];
				local52 = local48.indexOf("@whi@");
				if (local52 != -1) {
					local1156 = JString.toBase37(local48.substring(local52 + 5).trim());
					local73 = -1;
					for (@Pc(1160) int local1160 = 0; local1160 < this.friendCount; local1160++) {
						if (this.friendName37[local1160] == local1156) {
							local73 = local1160;
							break;
						}
					}
					if (local73 != -1 && this.friendWorld[local73] > 0) {
						this.redrawChatback = true;
						this.chatbackInputOpen = false;
						this.showSocialInput = true;
						this.socialInput = "";
						this.socialAction = 3;
						this.socialName37 = this.friendName37[local73];
						this.socialMessage = "Enter message to send to " + this.friendName[local73];
					}
				}
			}
			if (local28 == 55 && this.interactWithLoc(9, local18, local23, local33)) {
				this.out.p2(this.activeSpellId);
			}
			if (local28 == 224 || local28 == 993 || local28 == 99 || local28 == 746 || local28 == 877) {
				local500 = this.tryMove(this.localPlayer.pathTileX[0], 0, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 0, local23, 0, 0, 0);
				if (!local500) {
					this.tryMove(this.localPlayer.pathTileX[0], 1, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 1, local23, 0, 0, 0);
				}
				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;
				if (local28 == 224) {
					this.out.p1isaac(140);
				}
				if (local28 == 746) {
					this.out.p1isaac(178);
				}
				if (local28 == 877) {
					this.out.p1isaac(247);
				}
				if (local28 == 99) {
					this.out.p1isaac(200);
				}
				if (local28 == 993) {
					this.out.p1isaac(40);
				}
				this.out.p2(local18 + this.sceneBaseTileX);
				this.out.p2(local23 + this.sceneBaseTileZ);
				this.out.p2(local33);
			}
			if (local28 == 1607) {
				local345 = this.npcs[local33];
				if (local345 != null) {
					if (local345.type.desc == null) {
						local845 = "It's a " + local345.type.name + ".";
					} else {
						local845 = new String(local345.type.desc);
					}
					this.addMessage(0, local845, "");
				}
			}
			if (local28 == 504) {
				this.interactWithLoc(172, local18, local23, local33);
			}
			@Pc(1429) IfType local1429;
			if (local28 == 930) {
				local1429 = IfType.instances[local23];
				this.spellSelected = 1;
				this.activeSpellId = local23;
				this.activeSpellFlags = local1429.spellFlags;
				this.objSelected = 0;
				local845 = local1429.spellAction;
				if (local845.indexOf(" ") != -1) {
					local845 = local845.substring(0, local845.indexOf(" "));
				}
				local69 = local1429.spellAction;
				if (local69.indexOf(" ") != -1) {
					local69 = local69.substring(local69.indexOf(" ") + 1);
				}
				this.spellCaption = local845 + " " + local1429.spellName + " " + local69;
				if (this.activeSpellFlags == 16) {
					this.redrawSidebar = true;
					this.selectedTab = 3;
					this.redrawSideicons = true;
				}
			} else {
				if (local28 == 951) {
					local1429 = IfType.instances[local23];
					@Pc(1513) boolean local1513 = true;
					if (local1429.contentType > 0) {
						local1513 = this.handleInterfaceAction(local1429);
					}
					if (local1513) {
						this.out.p1isaac(155);
						this.out.p2(local23);
					}
				}
				if (local28 == 602 || local28 == 596 || local28 == 22 || local28 == 892 || local28 == 415) {
					if (local28 == 22) {
						this.out.p1isaac(212);
					}
					if (local28 == 415) {
						if ((local23 & 0x3) == 0) {
							ifButton5Counter++;
						}
						if (ifButton5Counter >= 55) {
							this.out.p1isaac(17);
							this.out.p4(0);
						}
						this.out.p1isaac(6);
					}
					if (local28 == 602) {
						this.out.p1isaac(31);
					}
					if (local28 == 892) {
						if ((local18 & 0x3) == 0) {
							opHeld9Counter++;
						}
						if (opHeld9Counter >= 130) {
							this.out.p1isaac(238);
							this.out.p1(177);
						}
						this.out.p1isaac(38);
					}
					if (local28 == 596) {
						this.out.p1isaac(59);
					}
					this.out.p2(local33);
					this.out.p2(local18);
					this.out.p2(local23);
					this.selectedCycle = 0;
					this.selectedInterface = local23;
					this.selectedItem = local18;
					this.selectedArea = 2;
					if (IfType.instances[local23].parentId == this.viewportInterfaceId) {
						this.selectedArea = 1;
					}
					if (IfType.instances[local23].parentId == this.chatInterfaceId) {
						this.selectedArea = 3;
					}
				}
				if (local28 == 581) {
					if ((local33 & 0x3) == 0) {
						opLoc4Counter++;
					}
					if (opLoc4Counter >= 99) {
						this.out.p1isaac(7);
						this.out.p4(0);
					}
					this.interactWithLoc(97, local18, local23, local33);
				}
				if (local28 == 965) {
					local500 = this.tryMove(this.localPlayer.pathTileX[0], 0, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 0, local23, 0, 0, 0);
					if (!local500) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local18, this.localPlayer.pathTileZ[0], 0, 2, 1, local23, 0, 0, 0);
					}
					this.crossX = super.mouseClickX;
					this.crossY = super.mouseClickY;
					this.crossMode = 2;
					this.crossCycle = 0;
					this.out.p1isaac(138);
					this.out.p2(local18 + this.sceneBaseTileX);
					this.out.p2(local23 + this.sceneBaseTileZ);
					this.out.p2(local33);
					this.out.p2(this.activeSpellId);
				}
				if (local28 == 1501) {
					opLoc5Counter += this.sceneBaseTileZ;
					if (opLoc5Counter >= 92) {
						this.out.p1isaac(66);
						this.out.p4(0);
					}
					this.interactWithLoc(116, local18, local23, local33);
				}
				if (local28 == 364) {
					this.interactWithLoc(96, local18, local23, local33);
				}
				if (local28 == 1102) {
					local830 = ObjType.get(local33);
					if (local830.desc == null) {
						local845 = "It's a " + local830.name + ".";
					} else {
						local845 = new String(local830.desc);
					}
					this.addMessage(0, local845, "");
				}
				if (local28 == 960) {
					this.out.p1isaac(155);
					this.out.p2(local23);
					local1429 = IfType.instances[local23];
					if (local1429.scripts != null && local1429.scripts[0][0] == 5) {
						local52 = local1429.scripts[0][1];
						if (this.varps[local52] != local1429.scriptOperand[0]) {
							this.varps[local52] = local1429.scriptOperand[0];
							this.updateVarp(local52);
							this.redrawSidebar = true;
						}
					}
				}
				if (local28 == 34) {
					local48 = this.menuOption[arg1];
					local52 = local48.indexOf("@whi@");
					if (local52 != -1) {
						this.closeInterfaces();
						this.reportAbuseInput = local48.substring(local52 + 5).trim();
						this.reportAbuseMuteOption = false;
						for (@Pc(1957) int local1957 = 0; local1957 < IfType.instances.length; local1957++) {
							if (IfType.instances[local1957] != null && IfType.instances[local1957].contentType == 600) {
								this.reportAbuseInterfaceID = this.viewportInterfaceId = IfType.instances[local1957].parentId;
								break;
							}
						}
					}
				}
				if (local28 == 947) {
					this.closeInterfaces();
				}
				if (local28 == 367) {
					local969 = this.players[local33];
					if (local969 != null) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local969.pathTileZ[0], 0, 0, 0);
						this.crossX = super.mouseClickX;
						this.crossY = super.mouseClickY;
						this.crossMode = 2;
						this.crossCycle = 0;
						this.out.p1isaac(248);
						this.out.p2(local33);
						this.out.p2(this.objInterface);
						this.out.p2(this.objSelectedSlot);
						this.out.p2(this.objSelectedInterface);
					}
				}
				if (local28 == 465) {
					this.out.p1isaac(155);
					this.out.p2(local23);
					local1429 = IfType.instances[local23];
					if (local1429.scripts != null && local1429.scripts[0][0] == 5) {
						local52 = local1429.scripts[0][1];
						this.varps[local52] = 1 - this.varps[local52];
						this.updateVarp(local52);
						this.redrawSidebar = true;
					}
				}
				if (local28 == 406 || local28 == 436 || local28 == 557 || local28 == 556) {
					local48 = this.menuOption[arg1];
					local52 = local48.indexOf("@whi@");
					if (local52 != -1) {
						local1156 = JString.toBase37(local48.substring(local52 + 5).trim());
						if (local28 == 406) {
							this.addFriend(local1156);
						}
						if (local28 == 436) {
							this.addIgnore(local1156);
						}
						if (local28 == 557) {
							this.removeFriend(local1156);
						}
						if (local28 == 556) {
							this.removeIgnore(local1156);
						}
					}
				}
				if (local28 == 651) {
					local969 = this.players[local33];
					if (local969 != null) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 0, 2, 1, local969.pathTileZ[0], 0, 0, 0);
						this.crossX = super.mouseClickX;
						this.crossY = super.mouseClickY;
						this.crossMode = 2;
						this.crossCycle = 0;
						this.out.p1isaac(177);
						this.out.p2(local33);
						this.out.p2(this.activeSpellId);
					}
				}
				this.objSelected = 0;
				this.spellSelected = 0;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "t", descriptor = "(I)V")
	private void drawMenu() {
		@Pc(2) int local2 = this.menuX;
		@Pc(5) int local5 = this.menuY;
		@Pc(8) int local8 = this.menuWidth;
		@Pc(11) int local11 = this.menuHeight;
		@Pc(13) int local13 = 6116423;
		Draw2D.fillRect(local5, local2, local13, local8, local11);
		Draw2D.fillRect(local5 + 1, local2 + 1, 0, local8 - 2, 16);
		Draw2D.drawRect(local2 + 1, 0, local11 - 19, local5 + 18, local8 - 2);
		this.fontBold12.drawString(local2 + 3, local5 + 14, local13, "Choose Option");
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
			this.fontBold12.drawStringTaggable(local2 + 3, local100, this.menuOption[local85], true, local102);
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(III)V")
	private void handlePrivateChatInput(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2) {
		if (this.splitPrivateChat == 0) {
			return;
		}

		@Pc(5) int local5 = 0;
		if (this.systemUpdateTimer != 0) {
			local5 = 1;
		}
		for (@Pc(12) int local12 = 0; local12 < 100; local12++) {
			if (this.messageText[local12] != null) {
				@Pc(24) int local24 = this.messageType[local12];
				if ((local24 == 3 || local24 == 7) && (local24 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[local12]))) {
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
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!hc;)V")
	private void updateInterfaceContent(@OriginalArg(1) IfType arg1) {
		@Pc(4) int local4 = arg1.contentType;
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
				arg1.text = JString.formatName(JString.fromBase37(this.ignoreName37[local4]));
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
						local209[local211++] = IdkType.instances[local220].getModel();
					}
				}
				@Pc(241) Model local241 = new Model(local209, local211);
				for (@Pc(243) int local243 = 0; local243 < 5; local243++) {
					if (this.designColors[local243] != 0) {
						local241.recolor(PlayerEntity.designPartColor[local243][0], PlayerEntity.designPartColor[local243][this.designColors[local243]]);
						if (local243 == 1) {
							local241.recolor(PlayerEntity.designHairColor[0], PlayerEntity.designHairColor[this.designColors[local243]]);
						}
					}
				}
				local241.createLabelReferences();
				local241.applyTransform(SeqType.instances[this.localPlayer.seqStandId].primaryFrames[0]);
				local241.calculateNormals(64, 850, -30, -50, -30, true);
				arg1.model = local241;
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
					arg1.text = "You last logged in " + local441 + " from: " + Signlink.dns;
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
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BII)Z")
	private boolean saveWave(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1) {
		return arg0 == null ? true : Signlink.wavesave(arg0, arg1);
	}

	@OriginalMember(owner = "client!client", name = "u", descriptor = "(I)Z")
	private boolean replayWave() {
		return Signlink.wavereplay();
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(II)V")
	private void setWaveVolume(@OriginalArg(0) int arg0) {
		Signlink.wavevol = arg0;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!kb;I)V")
	private void readNewNpcs(@OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
		while (arg1.bitPosition + 21 < arg2 * 8) {
			@Pc(16) int local16 = arg1.gBit(13);
			if (local16 == 8191) {
				break;
			}
			if (this.npcs[local16] == null) {
				this.npcs[local16] = new NpcEntity();
			}
			@Pc(36) NpcEntity local36 = this.npcs[local16];
			this.npcIds[this.npcCount++] = local16;
			local36.cycle = loopCycle;
			local36.type = NpcType.get(arg1.gBit(11));
			local36.size = local36.type.size;
			local36.seqWalkId = local36.type.walkanim;
			local36.seqTurnAroundId = local36.type.walkanim_b;
			local36.seqTurnLeftId = local36.type.walkanim_r;
			local36.seqTurnRightId = local36.type.walkanim_l;
			local36.seqStandId = local36.type.readyanim;
			@Pc(92) int local92 = arg1.gBit(5);
			if (local92 > 15) {
				local92 -= 32;
			}
			@Pc(101) int local101 = arg1.gBit(5);
			if (local101 > 15) {
				local101 -= 32;
			}
			local36.move(false, this.localPlayer.pathTileX[0] + local92, this.localPlayer.pathTileZ[0] + local101);
			@Pc(128) int local128 = arg1.gBit(1);
			if (local128 == 1) {
				this.entityUpdateIds[this.entityUpdateCount++] = local16;
			}
		}
		arg1.accessBytes();
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!hc;)Z")
	private boolean handleInterfaceAction(@OriginalArg(1) IfType arg1) {
		@Pc(4) int local4 = arg1.contentType;
		if (local4 == 201) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
			this.showSocialInput = true;
			this.socialInput = "";
			this.socialAction = 1;
			this.socialMessage = "Enter name of friend to add to list";
		}
		if (local4 == 202) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
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
			this.chatbackInputOpen = false;
			this.showSocialInput = true;
			this.socialInput = "";
			this.socialAction = 4;
			this.socialMessage = "Enter name of player to add to list";
		}
		if (local4 == 502) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
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
					if (!IdkType.instances[local121].disable && IdkType.instances[local121].type == local112 + (this.designGenderMale ? 0 : 7)) {
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
			this.validateCharacterDesign();
		}
		if (local4 == 325 && this.designGenderMale) {
			this.designGenderMale = false;
			this.validateCharacterDesign();
		}
		if (local4 == 326) {
			this.out.p1isaac(52);
			this.out.p1(this.designGenderMale ? 0 : 1);
			for (local112 = 0; local112 < 7; local112++) {
				this.out.p1(this.designIdentikits[local112]);
			}
			for (local116 = 0; local116 < 5; local116++) {
				this.out.p1(this.designColors[local116]);
			}
			return true;
		}
		if (local4 == 613) {
			this.reportAbuseMuteOption = !this.reportAbuseMuteOption;
		}
		if (local4 >= 601 && local4 <= 612) {
			this.closeInterfaces();
			if (this.reportAbuseInput.length() > 0) {
				this.out.p1isaac(190);
				this.out.p8(JString.toBase37(this.reportAbuseInput));
				this.out.p1(local4 - 601);
				this.out.p1(this.reportAbuseMuteOption ? 1 : 0);
			}
		}
		return false;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "()V")
	@Override
	protected void load() {
		if (Signlink.sunjava) {
			super.mindel = 5;
		}
		if (!lowMemory) {
			this.startMidiThread = true;
			this.midiThreadActive = true;
			this.startThread(this, 2);
			this.setMidi(12345678, "scape_main", 40000);
		}
		if (started) {
			this.errorStarted = true;
			return;
		}
		started = true;
		try {
			@Pc(94) int local94 = 5;
			this.archiveChecksum[8] = 0;
			while (this.archiveChecksum[8] == 0) {
				this.drawProgress("Connecting to fileserver", 10);
				try {
					@Pc(119) DataInputStream local119 = this.openUrl("crc" + (int) (Math.random() * 9.9999999E7D));
					@Pc(126) Packet local126 = new Packet(new byte[36]);
					local119.readFully(local126.data, 0, 36);
					for (@Pc(134) int local134 = 0; local134 < 9; local134++) {
						this.archiveChecksum[local134] = local126.g4();
					}
					local119.close();
				} catch (@Pc(150) IOException local150) {
					for (@Pc(152) int local152 = local94; local152 > 0; local152--) {
						this.drawProgress("Error loading - Will retry in " + local152 + " secs.", 10);
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
			this.archiveTitle = this.loadArchive("title screen", this.archiveChecksum[1], "title", 10);
			this.fontPlain11 = new BitmapFont(this.archiveTitle, "p11");
			this.fontPlain12 = new BitmapFont(this.archiveTitle, "p12");
			this.fontBold12 = new BitmapFont(this.archiveTitle, "b12");
			this.fontQuill8 = new BitmapFont(this.archiveTitle, "q8");
			this.loadTitleBackground();
			this.loadTitleImages();
			@Pc(255) Jagfile local255 = this.loadArchive("config", this.archiveChecksum[2], "config", 15);
			@Pc(266) Jagfile local266 = this.loadArchive("interface", this.archiveChecksum[3], "interface", 20);
			@Pc(277) Jagfile local277 = this.loadArchive("2d graphics", this.archiveChecksum[4], "media", 30);
			@Pc(288) Jagfile local288 = this.loadArchive("3d graphics", this.archiveChecksum[5], "models", 40);
			@Pc(299) Jagfile local299 = this.loadArchive("textures", this.archiveChecksum[6], "textures", 60);
			@Pc(310) Jagfile local310 = this.loadArchive("chat system", this.archiveChecksum[7], "wordenc", 65);
			@Pc(321) Jagfile local321 = null;
			if (!lowMemory) {
				local321 = this.loadArchive("sound effects", this.archiveChecksum[8], "sounds", 70);
			}

			this.drawProgress("Unpacking media", 75);

			this.imageInvback = new Pix8(local277, "invback", 0);
			this.imageChatback = new Pix8(local277, "chatback", 0);
			this.imageMapback = new Pix8(local277, "mapback", 0);
			this.imageBackbase1 = new Pix8(local277, "backbase1", 0);
			this.imageBackbase2 = new Pix8(local277, "backbase2", 0);
			this.imageBackhmid1 = new Pix8(local277, "backhmid1", 0);

			for (@Pc(424) int local424 = 0; local424 < 13; local424++) {
				this.imageSideicons[local424] = new Pix8(local277, "sideicons", local424);
			}

			this.imageCompass = new Pix24(local277, "compass", 0);

			@Pc(450) int local450;
			try {
				for (local450 = 0; local450 < 50; local450++) {
					if (local450 == 22) {
						continue;
					}
					this.imageMapscene[local450] = new Pix8(local277, "mapscene", local450);
				}
			} catch (@Pc(468) Exception local468) {
			}

			try {
				for (local450 = 0; local450 < 50; local450++) {
					this.imageMapfunction[local450] = new Pix24(local277, "mapfunction", local450);
				}
			} catch (@Pc(488) Exception local488) {
			}

			try {
				for (local450 = 0; local450 < 20; local450++) {
					this.imageHitmarks[local450] = new Pix24(local277, "hitmarks", local450);
				}
			} catch (@Pc(508) Exception local508) {
			}

			try {
				for (local450 = 0; local450 < 8; local450++) {
					this.imageHeadicons[local450] = new Pix24(local277, "headicons", local450);
				}
			} catch (@Pc(528) Exception local528) {
			}

			this.imageMapflag = new Pix24(local277, "mapflag", 0);

			for (local450 = 0; local450 < 8; local450++) {
				this.imageCrosses[local450] = new Pix24(local277, "cross", local450);
			}

			this.imageMapdot0 = new Pix24(local277, "mapdots", 0);
			this.imageMapdot1 = new Pix24(local277, "mapdots", 1);
			this.imageMapdot2 = new Pix24(local277, "mapdots", 2);
			this.imageMapdot3 = new Pix24(local277, "mapdots", 3);
			this.imageScrollbar0 = new Pix8(local277, "scrollbar", 0);
			this.imageScrollbar1 = new Pix8(local277, "scrollbar", 1);
			this.imageRedstone1 = new Pix8(local277, "redstone1", 0);
			this.imageRedstone2 = new Pix8(local277, "redstone2", 0);
			this.imageRedstone3 = new Pix8(local277, "redstone3", 0);

			this.imageRedstone1h = new Pix8(local277, "redstone1", 0);
			this.imageRedstone1h.flipHorizontally();
			this.imageRedstone2h = new Pix8(local277, "redstone2", 0);
			this.imageRedstone2h.flipHorizontally();
			this.imageRedstone1v = new Pix8(local277, "redstone1", 0);
			this.imageRedstone1v.flipVertically();
			this.imageRedstone2v = new Pix8(local277, "redstone2", 0);
			this.imageRedstone2v.flipVertically();
			this.imageRedstone3v = new Pix8(local277, "redstone3", 0);
			this.imageRedstone3v.flipVertically();
			this.imageRedstone1hv = new Pix8(local277, "redstone1", 0);
			this.imageRedstone1hv.flipHorizontally();
			this.imageRedstone1hv.flipVertically();
			this.imageRedstone2hv = new Pix8(local277, "redstone2", 0);
			this.imageRedstone2hv.flipHorizontally();
			this.imageRedstone2hv.flipVertically();

			@Pc(975) int local975 = (int) (Math.random() * 21.0D) - 10;
			@Pc(982) int local982 = (int) (Math.random() * 21.0D) - 10;
			@Pc(989) int local989 = (int) (Math.random() * 21.0D) - 10;
			@Pc(996) int local996 = (int) (Math.random() * 41.0D) - 20;
			for (@Pc(998) int local998 = 0; local998 < 50; local998++) {
				if (this.imageMapfunction[local998] != null) {
					this.imageMapfunction[local998].translate(local975 + local996, local982 + local996, local989 + local996);
				}

				if (this.imageMapscene[local998] != null) {
					this.imageMapscene[local998].translate(local975 + local996, local982 + local996, local989 + local996);
				}
			}

			@Pc(725) Pix24 local725 = new Pix24(local277, "backleft1", 0);
			this.areaBackleft1 = new PixMap(this.getBaseComponent(), local725.width, local725.height);
			local725.blitOpaque(0, 0);
			@Pc(750) Pix24 local750 = new Pix24(local277, "backleft2", 0);
			this.areaBackleft2 = new PixMap(this.getBaseComponent(), local750.width, local750.height);
			local750.blitOpaque(0, 0);
			@Pc(775) Pix24 local775 = new Pix24(local277, "backright1", 0);
			this.areaBackright1 = new PixMap(this.getBaseComponent(), local775.width, local775.height);
			local775.blitOpaque(0, 0);
			@Pc(800) Pix24 local800 = new Pix24(local277, "backright2", 0);
			this.areaBackright2 = new PixMap(this.getBaseComponent(), local800.width, local800.height);
			local800.blitOpaque(0, 0);
			@Pc(825) Pix24 local825 = new Pix24(local277, "backtop1", 0);
			this.areaBacktop1 = new PixMap(this.getBaseComponent(), local825.width, local825.height);
			local825.blitOpaque(0, 0);
			@Pc(850) Pix24 local850 = new Pix24(local277, "backtop2", 0);
			this.areaBacktop2 = new PixMap(this.getBaseComponent(), local850.width, local850.height);
			local850.blitOpaque(0, 0);
			@Pc(875) Pix24 local875 = new Pix24(local277, "backvmid1", 0);
			this.areaBackvmid1 = new PixMap(this.getBaseComponent(), local875.width, local875.height);
			local875.blitOpaque(0, 0);
			@Pc(900) Pix24 local900 = new Pix24(local277, "backvmid2", 0);
			this.areaBackvmid2 = new PixMap(this.getBaseComponent(), local900.width, local900.height);
			local900.blitOpaque(0, 0);
			@Pc(925) Pix24 local925 = new Pix24(local277, "backvmid3", 0);
			this.areaBackvmid3 = new PixMap(this.getBaseComponent(), local925.width, local925.height);
			local925.blitOpaque(0, 0);
			@Pc(950) Pix24 local950 = new Pix24(local277, "backhmid2", 0);
			this.areaBackhmid2 = new PixMap(this.getBaseComponent(), local950.width, local950.height);
			local950.blitOpaque(0, 0);

			this.drawProgress("Unpacking textures", 80);
			Draw3D.unpackTextures(local299);
			Draw3D.setBrightness(0.8D);
			Draw3D.initPool(20);

			this.drawProgress("Unpacking models", 83);
			Model.unpack(local288);
			SeqBase.unpack(local288);
			SeqFrame.unpack(local288);

			this.drawProgress("Unpacking config", 86);
			SeqType.unpack(local255);
			LocType.unpack(local255);
			FloType.unpack(local255);
			ObjType.unpack(local255);
			NpcType.unpack(local255);
			IdkType.unpack(local255, 473);
			SpotAnimType.unpack(local255);
			VarpType.unpack(local255);
			ObjType.membersWorld = members;

			if (!lowMemory) {
				this.drawProgress("Unpacking sounds", 90);
				@Pc(1113) byte[] local1113 = local321.read("sounds.dat", null);
				@Pc(1119) Packet local1119 = new Packet(local1113);
				Wave.unpack(local1119);
			}

			this.drawProgress("Unpacking interfaces", 92);
			@Pc(1150) BitmapFont[] local1150 = new BitmapFont[] { this.fontPlain11, this.fontPlain12, this.fontBold12, this.fontQuill8 };
			IfType.unpack(local277, local1150, local266);

			this.drawProgress("Preparing game engine", 97);
			WordFilter.unpack(local310);
			this.imageMinimap = new Pix24(512, 512);

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

			Draw3D.init3D(96, 479);
			this.areaChatbackOffsets = Draw3D.lineOffset;
			Draw3D.init3D(261, 190);
			this.areaSidebarOffsets = Draw3D.lineOffset;
			Draw3D.init3D(334, 512);
			this.areaViewportOffsets = Draw3D.lineOffset;

			this.levelTileFlags = new int[4][104][104];
			this.levelHeightmap = new int[4][105][105];
			this.world3D = new World3D(this.levelHeightmap, 104, 4, 104);
			for (@Pc(346) int local346 = 0; local346 < 4; local346++) {
				this.levelCollisionMap[local346] = new CollisionMap(104, -708, 104);
			}

			@Pc(1312) int[] local1312 = new int[9];
			for (local1170 = 0; local1170 < 9; local1170++) {
				local1228 = local1170 * 32 + 128 + 15;
				@Pc(1330) int local1330 = local1228 * 3 + 600;
				@Pc(1334) int local1334 = Draw3D.sin[local1228];
				local1312[local1170] = local1330 * local1334 >> 16;
			}

			World3D.init(local1312, 800, 512, 334, 500);
		} catch (@Pc(1357) Exception local1357) {
			this.errorLoading = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "v", descriptor = "(I)V")
	private void handleInput() {
		if (this.objDragArea != 0) {
			return;
		}

		this.menuOption[0] = "Cancel";
		this.menuAction[0] = 1252;
		this.menuSize = 1;
		this.handlePrivateChatInput(super.mouseX, super.mouseY);
		this.lastHoveredInterfaceId = 0;
		if (super.mouseX > 8 && super.mouseY > 11 && super.mouseX < 520 && super.mouseY < 345) {
			if (this.viewportInterfaceId == -1) {
				this.handleViewportOptions();
			} else {
				this.handleInterfaceInput(super.mouseY, super.mouseX, 11, IfType.instances[this.viewportInterfaceId], 8, 0);
			}
		}
		if (this.lastHoveredInterfaceId != this.viewportHoveredInterfaceIndex) {
			this.viewportHoveredInterfaceIndex = this.lastHoveredInterfaceId;
		}
		this.lastHoveredInterfaceId = 0;
		if (super.mouseX > 562 && super.mouseY > 231 && super.mouseX < 752 && super.mouseY < 492) {
			if (this.sidebarInterfaceId != -1) {
				this.handleInterfaceInput(super.mouseY, super.mouseX, 231, IfType.instances[this.sidebarInterfaceId], 562, 0);
			} else if (this.tabInterfaceId[this.selectedTab] != -1) {
				this.handleInterfaceInput(super.mouseY, super.mouseX, 231, IfType.instances[this.tabInterfaceId[this.selectedTab]], 562, 0);
			}
		}
		if (this.lastHoveredInterfaceId != this.sidebarHoveredInterfaceIndex) {
			this.redrawSidebar = true;
			this.sidebarHoveredInterfaceIndex = this.lastHoveredInterfaceId;
		}
		this.lastHoveredInterfaceId = 0;
		if (super.mouseX > 22 && super.mouseY > 375 && super.mouseX < 431 && super.mouseY < 471) {
			if (this.chatInterfaceId == -1) {
				this.handleChatMouseInput(super.mouseY - 375, super.mouseX - 22);
			} else {
				this.handleInterfaceInput(super.mouseY, super.mouseX, 375, IfType.instances[this.chatInterfaceId], 22, 0);
			}
		}
		if (this.chatInterfaceId != -1 && this.lastHoveredInterfaceId != this.chatHoveredInterfaceIndex) {
			this.redrawChatback = true;
			this.chatHoveredInterfaceIndex = this.lastHoveredInterfaceId;
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
					@Pc(294) int local294 = this.menuParamA[local229];
					this.menuParamA[local229] = this.menuParamA[local229 + 1];
					this.menuParamA[local229 + 1] = local294;
					@Pc(316) int local316 = this.menuParamB[local229];
					this.menuParamB[local229] = this.menuParamB[local229 + 1];
					this.menuParamB[local229 + 1] = local316;
					@Pc(338) int local338 = this.menuParamC[local229];
					this.menuParamC[local229] = this.menuParamC[local229 + 1];
					this.menuParamC[local229 + 1] = local338;
					local223 = false;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(B)V")
	private void clearCaches() {
		LocType.modelCacheStatic.clear();
		LocType.modelCacheDynamic.clear();
		NpcType.modelCache.clear();
		ObjType.modelCache.clear();
		ObjType.iconCache.clear();
		PlayerEntity.modelCache.clear();
		SpotAnimType.modelCache.clear();
	}

	@OriginalMember(owner = "client!client", name = "w", descriptor = "(I)V")
	private void drawViewportInterfaces() {
		@Pc(7) int local7;
		this.drawPrivateMessages();
		if (this.crossMode == 1) {
			this.imageCrosses[this.crossCycle / 100].draw(this.crossY - 8 - 11, this.crossX - 8 - 8);
		}
		if (this.crossMode == 2) {
			this.imageCrosses[this.crossCycle / 100 + 4].draw(this.crossY - 8 - 11, this.crossX - 8 - 8);
		}
		if (this.viewportInterfaceId != -1) {
			this.updateInterfaceAnimation(this.viewportInterfaceId, this.sceneDelta);
			this.drawParentInterface(0, 0, IfType.instances[this.viewportInterfaceId], 0);
		}
		this.drawWildyLevel();
		if (!this.menuVisible) {
			this.handleInput();
			this.drawTooltip();
		} else if (this.menuArea == 0) {
			this.drawMenu();
		}
		if (this.inMultizone == 1) {
			if (this.wildernessLevel > 0 || this.worldLocationState == 1) {
				this.imageHeadicons[1].draw(258, 472);
			} else {
				this.imageHeadicons[1].draw(296, 472);
			}
		}
		if (this.wildernessLevel > 0) {
			this.imageHeadicons[0].draw(296, 472);
			this.fontPlain12.drawStringCenter(329, 16776960, "Level: " + this.wildernessLevel, 484);
		}
		if (this.worldLocationState == 1) {
			this.imageHeadicons[6].draw(296, 472);
			this.fontPlain12.drawStringCenter(329, 16776960, "Arena", 484);
		}
		if (this.systemUpdateTimer != 0) {
			local7 = this.systemUpdateTimer / 50;
			@Pc(196) int local196 = local7 / 60;
			local7 %= 60;
			if (local7 < 10) {
				this.fontPlain12.drawString(4, 329, 16776960, "System update in: " + local196 + ":0" + local7);
			} else {
				this.fontPlain12.drawString(4, 329, 16776960, "System update in: " + local196 + ":" + local7);
			}
		}
		this.drawDebug();
	}

	@OriginalMember(owner = "client!client", name = "x", descriptor = "(I)V")
	private void updateOrbitCamera() {
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
		this.orbitCameraPitch += this.orbitCameraPitchVelocity / 2;
		if (this.orbitCameraPitch < 128) {
			this.orbitCameraPitch = 128;
		}
		if (this.orbitCameraPitch > 383) {
			this.orbitCameraPitch = 383;
		}
		@Pc(208) int local208 = this.orbitCameraX >> 7;
		@Pc(213) int local213 = this.orbitCameraZ >> 7;
		@Pc(223) int local223 = this.getHeightmapY(this.currentLevel, this.orbitCameraX, this.orbitCameraZ);
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
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(B)V")
	private void pushProjectiles() {
		for (@Pc(12) ProjectileEntity local12 = (ProjectileEntity) this.projectiles.peekFront(); local12 != null; local12 = (ProjectileEntity) this.projectiles.prev()) {
			if (local12.level != this.currentLevel || loopCycle > local12.lastCycle) {
				local12.unlink();
			} else if (loopCycle >= local12.startCycle) {
				if (local12.target > 0) {
					@Pc(42) NpcEntity local42 = this.npcs[local12.target - 1];
					if (local42 != null) {
						local12.updateVelocity(this.getHeightmapY(local12.level, local42.x, local42.z) - local12.offsetY, local42.z, local42.x, loopCycle);
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
						local12.updateVelocity(this.getHeightmapY(local12.level, local80.x, local80.z) - local12.offsetY, local80.z, local80.x, loopCycle);
					}
				}
				local12.update(this.sceneDelta);
				this.world3D.addTemporary((int) local12.z, 60, local12.yaw, (int) local12.x, -1, false, null, local12, (int) local12.y, this.currentLevel);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(I)V")
	@Override
	protected void refresh() {
		this.redrawTitleBackground = true;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!hb;I)V")
	private void drawOnMinimap(@OriginalArg(0) int arg0, @OriginalArg(2) Pix24 arg2, @OriginalArg(3) int arg3) {
		@Pc(7) int local7 = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
		@Pc(15) int local15 = arg3 * arg3 + arg0 * arg0;
		if (local15 > 6400) {
			return;
		}

		@Pc(34) int local34 = Model.sin[local7];
		@Pc(38) int local38 = Model.cos[local7];
		@Pc(47) int local47 = local34 * 256 / (this.minimapZoom + 256);
		@Pc(56) int local56 = local38 * 256 / (this.minimapZoom + 256);
		@Pc(66) int local66 = arg0 * local47 + arg3 * local56 >> 16;
		@Pc(76) int local76 = arg0 * local56 - arg3 * local47 >> 16;
		if (local15 > 2500) {
			arg2.drawMasked(this.imageMapback, 83 - local76 - arg2.cropH / 2, local66 + 94 - arg2.cropW / 2);
		} else {
			arg2.draw(83 - local76 - arg2.cropH / 2, local66 + 94 - arg2.cropW / 2);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIII)I")
	private int mix(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(3) int local3 = 256 - arg1;
		return ((arg0 & 0xFF00FF) * local3 + (arg2 & 0xFF00FF) * arg1 & 0xFF00FF00) + ((arg0 & 0xFF00) * local3 + (arg2 & 0xFF00) * arg1 & 0xFF0000) >> 8;
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(II)Ljava/lang/String;")
	private String getIntString(@OriginalArg(0) int arg0) {
		return arg0 < 999999999 ? String.valueOf(arg0) : "*";
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZLclient!x;)V")
	private void projectFromGround(@OriginalArg(0) int height, @OriginalArg(2) PathingEntity entity) {
		this.projectFromGround(entity.x, height, entity.z);
	}

	private void projectFromGround(int x, int height, int z) {
		if ((x < 128) || (z < 128) || (x > 13056) || (z > 13056)) {
			projectX = -1;
			projectY = -1;
			return;
		}

		this.project(x, this.getHeightmapY(this.currentLevel, x, z) - height, z);
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IIII)V")
	private void project(@OriginalArg(1) int x, @OriginalArg(3) int y, @OriginalArg(0) int z) {
		x -= this.cameraX;
		y -= this.cameraY;
		z -= this.cameraZ;

		@Pc(48) int sinPitch = Model.sin[this.cameraPitch];
		@Pc(53) int cosPitch = Model.cos[this.cameraPitch];
		@Pc(58) int sinYaw = Model.sin[this.cameraYaw];
		@Pc(63) int cosYaw = Model.cos[this.cameraYaw];

		int tmp = ((z * sinYaw) + (x * cosYaw)) >> 16;
		z = ((z * cosYaw) - (x * sinYaw)) >> 16;
		x = tmp;

		tmp = ((y * cosPitch) - (z * sinPitch)) >> 16;
		z = ((y * sinPitch) + (z * cosPitch)) >> 16;
		y = tmp;

		if (z >= 50) {
			this.projectX = Draw3D.centerX + (x << 9) / z;
			this.projectY = Draw3D.centerY + (y << 9) / z;
		} else {
			this.projectX = -1;
			this.projectY = -1;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIZ)Z")
	private boolean interactWithLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		@Pc(7) int local7 = arg3 >> 14 & 0x7FFF;
		@Pc(16) int local16 = this.world3D.getInfo(this.currentLevel, arg1, arg2, arg3);
		if (local16 == -1) {
			return false;
		}
		@Pc(25) int local25 = local16 & 0x1F;
		@Pc(31) int local31 = local16 >> 6 & 0x3;
		if (local25 == 10 || local25 == 11 || local25 == 22) {
			@Pc(43) LocType local43 = LocType.get(local7);
			@Pc(51) int local51;
			@Pc(54) int local54;
			if (local31 == 0 || local31 == 2) {
				local51 = local43.sizeX;
				local54 = local43.sizeZ;
			} else {
				local51 = local43.sizeZ;
				local54 = local43.sizeX;
			}
			@Pc(65) int local65 = local43.blocksides;
			if (local31 != 0) {
				local65 = (local65 << local31 & 0xF) + (local65 >> 4 - local31);
			}
			this.tryMove(this.localPlayer.pathTileX[0], local51, false, arg1, this.localPlayer.pathTileZ[0], 0, 2, local54, arg2, 0, 0, local65);
		} else {
			this.tryMove(this.localPlayer.pathTileX[0], 0, false, arg1, this.localPlayer.pathTileZ[0], 0, 2, 0, arg2, local31, local25 + 1, 0);
		}
		this.crossX = super.mouseClickX;
		this.crossY = super.mouseClickY;
		this.crossMode = 2;
		this.crossCycle = 0;
		this.out.p1isaac(arg0);
		this.out.p2(arg1 + this.sceneBaseTileX);
		this.out.p2(arg2 + this.sceneBaseTileZ);
		this.out.p2(local7);
		return true;
	}

	@OriginalMember(owner = "client!client", name = "y", descriptor = "(I)V")
	private void showContextMenu() {
		@Pc(7) int local7 = this.fontBold12.stringWidth("Choose Option");
		@Pc(20) int local20;
		for (@Pc(9) int local9 = 0; local9 < this.menuSize; local9++) {
			local20 = this.fontBold12.stringWidth(this.menuOption[local9]);
			if (local20 > local7) {
				local7 = local20;
			}
		}
		local7 += 8;
		local20 = this.menuSize * 15 + 21;
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

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;)Ljava/io/DataInputStream;")
	private DataInputStream openUrl(@OriginalArg(0) String arg0) throws IOException {
		return new DataInputStream((new URL(this.getCodeBase(), arg0)).openStream());
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(B)V")
	private void loadTitle() {
		if (this.imageTitle2 != null) {
			return;
		}

		super.pixMap = null;
		this.areaChatback = null;
		this.areaMapback = null;
		this.areaSidebar = null;
		this.areaViewport = null;
		this.areaBackbase1 = null;
		this.areaBackbase2 = null;
		this.areaBackhmid1 = null;
		this.imageTitle0 = new PixMap(this.getBaseComponent(), 128, 265);
		Draw2D.clear();
		this.imageTitle1 = new PixMap(this.getBaseComponent(), 128, 265);
		Draw2D.clear();
		this.imageTitle2 = new PixMap(this.getBaseComponent(), 533, 186);
		Draw2D.clear();
		this.imageTitle3 = new PixMap(this.getBaseComponent(), 360, 146);
		Draw2D.clear();
		this.imageTitle4 = new PixMap(this.getBaseComponent(), 360, 200);
		Draw2D.clear();
		this.imageTitle5 = new PixMap(this.getBaseComponent(), 214, 267);
		Draw2D.clear();
		this.imageTitle6 = new PixMap(this.getBaseComponent(), 215, 267);
		Draw2D.clear();
		this.imageTitle7 = new PixMap(this.getBaseComponent(), 86, 79);
		Draw2D.clear();
		this.imageTitle8 = new PixMap(this.getBaseComponent(), 87, 79);
		Draw2D.clear();
		if (this.archiveTitle != null) {
			this.loadTitleBackground();
			this.loadTitleImages();
		}
		this.redrawTitleBackground = true;
	}

	@OriginalMember(owner = "client!client", name = "z", descriptor = "(I)V")
	private void runFlames() {
		this.flameThread = true;
		try {
			@Pc(4) long local4 = System.currentTimeMillis();
			@Pc(6) int local6 = 0;
			@Pc(8) int local8 = 20;
			while (this.flameActive) {
				this.updateFlames();
				this.updateFlames();
				this.drawFlames();
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
	}

	@OriginalMember(owner = "client!client", name = "run", descriptor = "()V")
	@Override
	public void run() {
		if (this.flamesThread) {
			this.runFlames();
		} else if (this.startMidiThread) {
			this.runMidi();
		} else {
			super.run();
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIZIILclient!hc;)V")
	private void handleScrollInput(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) IfType arg8) {
		if (this.scrollGrabbed) {
			this.scrollInputPadding = 32;
		} else {
			this.scrollInputPadding = 0;
		}
		this.scrollGrabbed = false;
		if (arg0 >= arg6 && arg0 < arg6 + 16 && arg2 >= arg7 && arg2 < arg7 + 16) {
			arg8.scrollPosition -= this.dragCycles * 4;
			if (arg5) {
				this.redrawSidebar = true;
			}
		} else if (arg0 >= arg6 && arg0 < arg6 + 16 && arg2 >= arg7 + arg4 - 16 && arg2 < arg7 + arg4) {
			arg8.scrollPosition += this.dragCycles * 4;
			if (arg5) {
				this.redrawSidebar = true;
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
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;Z)V")
	private void login(@OriginalArg(0) String arg0, @OriginalArg(1) String arg1, @OriginalArg(2) boolean arg2) {
		Signlink.errorname = arg0;
		try {
			if (!arg2) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Connecting to server...";
				this.drawTitleScreen();
			}
			this.connection = new ClientStream(this, this.openSocket(portOffset + 43594));
			this.connection.read(this.in.data, 0, 8);
			this.in.pos = 0;
			this.serverSeed = this.in.g8();
			@Pc(47) int[] local47 = new int[] { (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (this.serverSeed >> 32), (int) this.serverSeed };
			this.out.pos = 0;
			this.out.p1(10);
			this.out.p4(local47[0]);
			this.out.p4(local47[1]);
			this.out.p4(local47[2]);
			this.out.p4(local47[3]);
			this.out.p4(Signlink.uid);
			this.out.pjstr(arg0);
			this.out.pjstr(arg1);
			this.out.rsaenc(RSA_MODULUS, RSA_EXPONENT);
			this.login.pos = 0;
			if (arg2) {
				this.login.p1(18);
			} else {
				this.login.p1(16);
			}
			this.login.p1(this.out.pos + 36 + 1 + 1);
			this.login.p1(Signlink.clientversion);
			this.login.p1(lowMemory ? 1 : 0);
			for (@Pc(168) int local168 = 0; local168 < 9; local168++) {
				this.login.p4(this.archiveChecksum[local168]);
			}
			this.login.pdata(this.out.data, this.out.pos, 0);
			this.out.random = new Isaac(local47);
			for (@Pc(202) int local202 = 0; local202 < 4; local202++) {
				local47[local202] += 50;
			}
			this.randomIn = new Isaac(local47);
			this.connection.write(this.login.data, this.login.pos, 0);
			@Pc(237) int local237 = this.connection.read();
			if (local237 == 1) {
				try {
					Thread.sleep(2000L);
				} catch (@Pc(244) Exception local244) {
				}
				this.login(arg0, arg1, arg2);
				return;
			}
			if (local237 == 2 || local237 == 18) {
				if (local237 == 18) {
					this.rights = true;
				} else {
					this.rights = false;
				}
				TrackInput.setDisabled();
				this.ingame = true;
				this.out.pos = 0;
				this.in.pos = 0;
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
				this.minimapLevel = -1;
				this.flagSceneTileX = 0;
				this.flagSceneTileZ = 0;
				this.playerCount = 0;
				this.npcCount = 0;
				for (@Pc(408) int local408 = 0; local408 < this.MAX_PLAYER_COUNT; local408++) {
					this.players[local408] = null;
					this.playerAppearanceBuffer[local408] = null;
				}
				for (@Pc(427) int local427 = 0; local427 < 8192; local427++) {
					this.npcs[local427] = null;
				}
				this.localPlayer = this.players[this.LOCAL_PLAYER_INDEX] = new PlayerEntity();
				this.projectiles.clear();
				this.spotanims.clear();
				this.temporaryLocs.clear();
				@Pc(464) int local464;
				for (@Pc(460) int local460 = 0; local460 < 4; local460++) {
					for (local464 = 0; local464 < 104; local464++) {
						for (@Pc(468) int local468 = 0; local468 < 104; local468++) {
							this.levelObjStacks[local460][local464][local468] = null;
						}
					}
				}
				this.spawnedLocations = new LinkList();
				this.friendCount = 0;
				this.stickyChatInterfaceId = -1;
				this.chatInterfaceId = -1;
				this.viewportInterfaceId = -1;
				this.sidebarInterfaceId = -1;
				this.pressedContinueOption = false;
				this.selectedTab = 3;
				this.chatbackInputOpen = false;
				this.menuVisible = false;
				this.showSocialInput = false;
				this.modalMessage = null;
				this.inMultizone = 0;
				this.flashingTab = -1;
				this.designGenderMale = true;
				this.validateCharacterDesign();
				for (local464 = 0; local464 < 5; local464++) {
					this.designColors[local464] = 0;
				}
				opLoc4Counter = 0;
				opNpc3Counter = 0;
				opHeld4Counter = 0;
				opNpc5Counter = 0;
				opHeld1Counter = 0;
				opLoc5Counter = 0;
				ifButton5Counter = 0;
				opPlayer2Counter = 0;
				opHeld9Counter = 0;
				this.prepareGameScreen();
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
				this.out.pos = 0;
				this.in.pos = 0;
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
	private void addLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(7) int arg7) {
		if (arg1 < 1 || arg2 < 1 || arg1 > 102 || arg2 > 102) {
			return;
		}

		if (lowMemory && arg7 != this.currentLevel) {
			return;
		}
		@Pc(25) int local25 = 0;
		@Pc(27) boolean local27 = true;
		@Pc(29) boolean local29 = false;
		@Pc(31) boolean local31 = false;
		if (arg3 == 0) {
			local25 = this.world3D.getWallBitset(arg7, arg1, arg2);
		}
		if (arg3 == 1) {
			local25 = this.world3D.getWallDecorationBitset(arg7, arg2, arg1);
		}
		if (arg3 == 2) {
			local25 = this.world3D.getLocBitset(arg7, arg1, arg2);
		}
		if (arg3 == 3) {
			local25 = this.world3D.getGroundDecorationBitset(arg7, arg1, arg2);
		}
		@Pc(81) int local81;
		if (local25 != 0) {
			local81 = this.world3D.getInfo(arg7, arg1, arg2, local25);
			@Pc(87) int local87 = local25 >> 14 & 0x7FFF;
			@Pc(91) int local91 = local81 & 0x1F;
			@Pc(95) int local95 = local81 >> 6;
			@Pc(107) LocType local107;
			if (arg3 == 0) {
				this.world3D.removeWall(arg1, arg7, arg2, 1);
				local107 = LocType.get(local87);
				if (local107.blockwalk) {
					this.levelCollisionMap[arg7].removeWall(local107.blockrange, local95, arg1, arg2, local91);
				}
			}
			if (arg3 == 1) {
				this.world3D.removeWallDecoration(arg7, arg2, arg1);
			}
			if (arg3 == 2) {
				this.world3D.removeLoc(arg1, arg2, arg7);
				local107 = LocType.get(local87);
				if (arg1 + local107.sizeX > 103 || arg2 + local107.sizeX > 103 || arg1 + local107.sizeZ > 103 || arg2 + local107.sizeZ > 103) {
					return;
				}
				if (local107.blockwalk) {
					this.levelCollisionMap[arg7].removeLoc(arg2, arg1, local95, local107.sizeX, local107.blockrange, local107.sizeZ);
				}
			}
			if (arg3 == 3) {
				this.world3D.removeGroundDecoration(arg7, arg1, arg2);
				local107 = LocType.get(local87);
				if (local107.blockwalk && local107.interactable) {
					this.levelCollisionMap[arg7].removeBlocked(arg2, arg1);
				}
			}
		}
		if (arg4 >= 0) {
			local81 = arg7;
			if (arg7 < 3 && (this.levelTileFlags[1][arg1][arg2] & 0x2) == 2) {
				local81 = arg7 + 1;
			}
			World.addLoc(arg1, this.locList, this.levelCollisionMap[arg7], arg2, arg0, this.levelHeightmap, arg7, arg4, arg5, this.world3D, local81);
			return;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(JI)V")
	private void addFriend(@OriginalArg(0) long arg0) {
		if (arg0 == 0L) {
			return;
		}

		if (this.friendCount >= 100) {
			this.addMessage(0, "Your friends list is full. Max of 100 hit", "");
		} else {
			@Pc(23) String local23 = JString.formatName(JString.fromBase37(arg0));
			for (@Pc(25) int local25 = 0; local25 < this.friendCount; local25++) {
				if (this.friendName37[local25] == arg0) {
					this.addMessage(0, local23 + " is already on your friend list", "");
					return;
				}
			}
			for (@Pc(55) int local55 = 0; local55 < this.ignoreCount; local55++) {
				if (this.ignoreName37[local55] == arg0) {
					this.addMessage(0, "Please remove " + local23 + " from your ignore list first", "");
					return;
				}
			}
			if (!local23.equals(this.localPlayer.name)) {
				this.friendName[this.friendCount] = local23;
				this.friendName37[this.friendCount] = arg0;
				this.friendWorld[this.friendCount] = 0;
				this.friendCount++;
				this.redrawSidebar = true;
				this.out.p1isaac(118);
				this.out.p8(arg0);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(B)V")
	@Override
	protected void unload() {
		try {
			if (this.connection != null) {
				this.connection.close();
			}
		} catch (@Pc(11) Exception local11) {
		}
		this.connection = null;
		this.stopMidi();
		this.midiThreadActive = false;
		this.out = null;
		this.login = null;
		this.in = null;
		this.sceneMapIndex = null;
		this.sceneMapLandData = null;
		this.sceneMapLocData = null;
		this.levelHeightmap = null;
		this.levelTileFlags = null;
		this.world3D = null;
		this.levelCollisionMap = null;
		this.bfsDirection = null;
		this.bfsCost = null;
		this.bfsStepX = null;
		this.bfsStepZ = null;
		this.textureBuffer = null;
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
		this.imageMapfunction = null;
		this.tileLastOccupiedCycle = null;
		this.players = null;
		this.playerIds = null;
		this.entityUpdateIds = null;
		this.playerAppearanceBuffer = null;
		this.entityRemovalIds = null;
		this.npcs = null;
		this.npcIds = null;
		this.levelObjStacks = null;
		this.spawnedLocations = null;
		this.temporaryLocs = null;
		this.projectiles = null;
		this.spotanims = null;
		this.locList = null;
		this.menuParamA = null;
		this.menuParamB = null;
		this.menuAction = null;
		this.menuParamC = null;
		this.menuOption = null;
		this.varps = null;
		this.activeMapFunctionX = null;
		this.activeMapFunctionZ = null;
		this.activeMapFunctions = null;
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
		this.unloadTitle();
		LocType.unload();
		NpcType.unload();
		ObjType.unload();
		FloType.instances = null;
		IdkType.instances = null;
		IfType.instances = null;
		SeqType.instances = null;
		SpotAnimType.instances = null;
		SpotAnimType.modelCache = null;
		VarpType.instances = null;
		super.pixMap = null;
		PlayerEntity.modelCache = null;
		Draw3D.unload();
		World3D.unload();
		Model.unload();
		SeqBase.instances = null;
		SeqFrame.instances = null;
		System.gc(); System.gc();
	}

	@OriginalMember(owner = "client!client", name = "A", descriptor = "(I)Ljava/net/Socket;")
	private Socket openSocket(@OriginalArg(0) int arg0) throws IOException {
		return new Socket(InetAddress.getByName(this.getCodeBase().getHost()), arg0);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!z;I)V")
	private void addPlayerOptions(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) PlayerEntity arg3, @OriginalArg(4) int arg4) {
		if (arg3 == this.localPlayer || this.menuSize >= 400) {
			return;
		}

		@Pc(41) String local41 = arg3.name + getCombatLevelColorTag(this.localPlayer.combatLevel, arg3.combatLevel) + " (level-" + arg3.combatLevel + ")";
		if (this.objSelected == 1) {
			this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @whi@" + local41;
			this.menuAction[this.menuSize] = 367;
			this.menuParamC[this.menuSize] = arg2;
			this.menuParamA[this.menuSize] = arg4;
			this.menuParamB[this.menuSize] = arg1;
			this.menuSize++;
		} else if (this.spellSelected != 1) {
			this.menuOption[this.menuSize] = "Follow @whi@" + local41;
			this.menuAction[this.menuSize] = 1544;
			this.menuParamC[this.menuSize] = arg2;
			this.menuParamA[this.menuSize] = arg4;
			this.menuParamB[this.menuSize] = arg1;
			this.menuSize++;
			if (this.overrideChat == 0) {
				this.menuOption[this.menuSize] = "Trade with @whi@" + local41;
				this.menuAction[this.menuSize] = 1373;
				this.menuParamC[this.menuSize] = arg2;
				this.menuParamA[this.menuSize] = arg4;
				this.menuParamB[this.menuSize] = arg1;
				this.menuSize++;
			}
			if (this.wildernessLevel > 0) {
				this.menuOption[this.menuSize] = "Attack @whi@" + local41;
				if (this.localPlayer.combatLevel >= arg3.combatLevel) {
					this.menuAction[this.menuSize] = 151;
				} else {
					this.menuAction[this.menuSize] = 2151;
				}
				this.menuParamC[this.menuSize] = arg2;
				this.menuParamA[this.menuSize] = arg4;
				this.menuParamB[this.menuSize] = arg1;
				this.menuSize++;
			}
			if (this.worldLocationState == 1) {
				this.menuOption[this.menuSize] = "Fight @whi@" + local41;
				this.menuAction[this.menuSize] = 151;
				this.menuParamC[this.menuSize] = arg2;
				this.menuParamA[this.menuSize] = arg4;
				this.menuParamB[this.menuSize] = arg1;
				this.menuSize++;
			}
			if (this.worldLocationState == 2) {
				this.menuOption[this.menuSize] = "Duel-with @whi@" + local41;
				this.menuAction[this.menuSize] = 1101;
				this.menuParamC[this.menuSize] = arg2;
				this.menuParamA[this.menuSize] = arg4;
				this.menuParamB[this.menuSize] = arg1;
				this.menuSize++;
			}
		} else if ((this.activeSpellFlags & 0x8) == 8) {
			this.menuOption[this.menuSize] = this.spellCaption + " @whi@" + local41;
			this.menuAction[this.menuSize] = 651;
			this.menuParamC[this.menuSize] = arg2;
			this.menuParamA[this.menuSize] = arg4;
			this.menuParamB[this.menuSize] = arg1;
			this.menuSize++;
		}
		for (@Pc(392) int local392 = 0; local392 < this.menuSize; local392++) {
			if (this.menuAction[local392] == 660) {
				this.menuOption[local392] = "Walk here @whi@" + local41;
				return;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(Z)V")
	private void updateGame() {
		if (this.systemUpdateTimer > 1) {
			this.systemUpdateTimer--;
		}
		if (this.idleTimeout > 0) {
			this.idleTimeout--;
		}
		for (@Pc(22) int local22 = 0; local22 < 5 && this.read(); local22++) {
		}
		if (this.ingame) {
			@Pc(155) int local155;
			@Pc(207) int local207;
			for (@Pc(46) int local46 = 0; local46 < this.waveCount; local46++) {
				if (this.waveDelay[local46] <= 0) {
					@Pc(55) boolean local55 = false;
					try {
						if (this.waveIds[local46] != this.lastWaveId || this.waveLoops[local46] != this.lastWaveLoops) {
							@Pc(89) Packet local89 = Wave.generate(this.waveLoops[local46], this.waveIds[local46]);
							if (System.currentTimeMillis() + (long) (local89.pos / 22) > this.lastWaveStartTime + (long) (this.lastWaveLength / 22)) {
								this.lastWaveLength = local89.pos;
								this.lastWaveStartTime = System.currentTimeMillis();
								if (this.saveWave(local89.data, local89.pos)) {
									this.lastWaveId = this.waveIds[local46];
									this.lastWaveLoops = this.waveLoops[local46];
								} else {
									local55 = true;
								}
							}
						} else if (!this.replayWave()) {
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
					this.setMidi(this.midiCrc, this.currentMidi, this.midiSize);
				}
			}
			@Pc(250) Packet local250 = TrackInput.flush();
			if (local250 != null) {
				this.out.p1isaac(81);
				this.out.p2(local250.pos);
				this.out.pdata(local250.data, local250.pos, 0);
				local250.release();
			}
			this.idleNetCycles++;
			if (this.idleNetCycles > 750) {
				this.tryReconnect();
			}
			this.updatePlayers();
			this.updateNpcs();
			this.updateEntityChats();
			this.updateTemporaryLocs();
			if ((super.actionKey[1] == 1 || super.actionKey[2] == 1 || super.actionKey[3] == 1 || super.actionKey[4] == 1) && this.cameraMovedWrite++ > 5) {
				this.cameraMovedWrite = 0;
				this.out.p1isaac(189);
				this.out.p2(this.orbitCameraPitch);
				this.out.p2(this.orbitCameraYaw);
				this.out.p1(this.minimapAnticheatAngle);
				this.out.p1(this.minimapZoom);
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
						this.handleInput();
						if (this.hoveredSlotParentId == this.objDragInterfaceId && this.hoveredSlot != this.objDragSlot) {
							@Pc(502) IfType local502 = IfType.instances[this.objDragInterfaceId];
							local508 = local502.inventorySlotObjId[this.hoveredSlot];
							local502.inventorySlotObjId[this.hoveredSlot] = local502.inventorySlotObjId[this.objDragSlot];
							local502.inventorySlotObjId[this.objDragSlot] = local508;
							@Pc(530) int local530 = local502.inventorySlotObjCount[this.hoveredSlot];
							local502.inventorySlotObjCount[this.hoveredSlot] = local502.inventorySlotObjCount[this.objDragSlot];
							local502.inventorySlotObjCount[this.objDragSlot] = local530;
							this.out.p1isaac(159);
							this.out.p2(this.objDragInterfaceId);
							this.out.p2(this.objDragSlot);
							this.out.p2(this.hoveredSlot);
						}
					} else if ((this.mouseButtonsOption == 1 || this.isAddFriendOption(this.menuSize - 1)) && this.menuSize > 2) {
						this.showContextMenu();
					} else if (this.menuSize > 0) {
						this.useMenuOption(this.menuSize - 1);
					}
					this.selectedCycle = 10;
					super.mouseClickButton = 0;
				}
			}
			updateGame++;
			if (updateGame > 127) {
				updateGame = 0;
				this.out.p1isaac(215);
				this.out.p3(4991788);
			}
			if (World3D.clickTileX != -1) {
				local155 = World3D.clickTileX;
				local508 = World3D.clickTileZ;
				@Pc(653) boolean local653 = this.tryMove(this.localPlayer.pathTileX[0], 0, true, local155, this.localPlayer.pathTileZ[0], 0, 0, 0, local508, 0, 0, 0);
				World3D.clickTileX = -1;
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
			this.handleObjDragging();
			this.drawOnMinimap();
			this.handleTabInput();
			this.handleChatSettingsInput(0);
			if (super.mouseButton == 1 || super.mouseClickButton == 1) {
				this.dragCycles++;
			}
			if (this.sceneState == 2) {
				this.updateOrbitCamera();
			}
			if (this.sceneState == 2 && this.cutscene) {
				this.applyCutscene();
			}
			for (local155 = 0; local155 < 5; local155++) {
				local207 = this.cameraModifierCycle[local155]++;
			}
			this.handleInputKey();
			super.idleCycles++;
			if (super.idleCycles > 4500) {
				this.idleTimeout = 250;
				super.idleCycles -= 500;
				this.out.p1isaac(70);
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
			updateGameCounter2++;
			if (updateGameCounter2 > 110) {
				updateGameCounter2 = 0;
				this.out.p1isaac(236);
				this.out.p4(0);
			}
			this.heartbeatTimer++;
			if (this.heartbeatTimer > 50) {
				this.out.p1isaac(108);
			}
			try {
				if (this.connection != null && this.out.pos > 0) {
					this.connection.write(this.out.data, this.out.pos, 0);
					this.out.pos = 0;
					this.heartbeatTimer = 0;
				}
			} catch (@Pc(1001) IOException local1001) {
				this.tryReconnect();
			} catch (@Pc(1006) Exception local1006) {
				this.logout();
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(Z)V")
	private void drawTooltip() {
		if (this.menuSize < 2 && this.objSelected == 0 && this.spellSelected == 0) {
			return;
		}

		@Pc(31) String local31;
		if (this.objSelected == 1 && this.menuSize < 2) {
			local31 = "Use " + this.objSelectedName + " with...";
		} else if (this.spellSelected == 1 && this.menuSize < 2) {
			local31 = this.spellCaption + "...";
		} else {
			local31 = this.menuOption[this.menuSize - 1];
		}
		if (this.menuSize > 2) {
			local31 = local31 + "@whi@ / " + (this.menuSize - 2) + " more options";
		}
		this.fontBold12.drawStringTooltip(loopCycle / 1000, true, 15, 16777215, local31, 4);
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(B)V")
	private void pushSpotanims() {
		for (@Pc(13) SpotAnimEntity local13 = (SpotAnimEntity) this.spotanims.peekFront(); local13 != null; local13 = (SpotAnimEntity) this.spotanims.prev()) {
			if (local13.level != this.currentLevel || local13.seqComplete) {
				local13.unlink();
			} else if (loopCycle >= local13.startCycle) {
				local13.update(this.sceneDelta);
				if (local13.seqComplete) {
					local13.unlink();
				} else {
					this.world3D.addTemporary(local13.z, 60, 0, local13.x, -1, false, null, local13, local13.y, local13.level);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "getCodeBase", descriptor = "()Ljava/net/URL;")
	public URL getCodeBase() {
		try {
			return new URL(Client.SERVER_WEB_SCHEMA + "//" + Client.SERVER_ADDRESS + ":" + (portOffset + Client.SERVER_WEB_PORT));
		} catch (Exception ex) {
			return null;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZIIIIIIIII)Z")
	private boolean tryMove(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(8) int arg8, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
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
				if ((arg10 < 5 || arg10 == 10) && this.levelCollisionMap[this.currentLevel].reachedWall(arg9, arg8, arg10 - 1, local39, arg3, local11)) {
					local70 = true;
					break;
				}
				if (arg10 < 10 && this.levelCollisionMap[this.currentLevel].reachedWallDecoration(arg9, arg10 - 1, local11, arg3, local39, arg8)) {
					local70 = true;
					break;
				}
			}
			if (arg1 != 0 && arg7 != 0 && this.levelCollisionMap[this.currentLevel].reachedLoc(local39, arg7, local11, arg3, arg11, arg8, arg1)) {
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
			this.packetType = this.in.g1();
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
				this.out.p1isaac(181);
				this.out.p1(local74 + local74 + 3);
			}
			if (arg6 == 1) {
				this.out.p1isaac(165);
				this.out.p1(local74 + local74 + 3 + 14);
			}
			if (arg6 == 2) {
				this.out.p1isaac(93);
				this.out.p1(local74 + local74 + 3);
			}
			if (super.actionKey[5] == 1) {
				this.out.p1(1);
			} else {
				this.out.p1(0);
			}
			this.out.p2(local815 + this.sceneBaseTileX);
			this.out.p2(local821 + this.sceneBaseTileZ);
			this.flagSceneTileX = this.bfsStepX[0];
			this.flagSceneTileZ = this.bfsStepZ[0];
			for (@Pc(1077) int local1077 = 1; local1077 < local74; local1077++) {
				local57--;
				this.out.p1(this.bfsStepX[local57] - local815);
				this.out.p1(this.bfsStepZ[local57] - local821);
			}
			return true;
		} else if (arg6 == 1) {
			return false;
		} else {
			return true;
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!kb;II)V")
	private void readPlayerInfo(@OriginalArg(0) Packet arg0, @OriginalArg(1) int arg1) {
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;
		this.readLocalPlayer(arg1, arg0);
		this.readPlayers(arg1, arg0, 0);
		this.readNewPlayers(arg1, arg0);
		this.readPlayerUpdates(arg1, arg0);
		@Pc(36) int local36;
		for (@Pc(29) int local29 = 0; local29 < this.entityRemovalCount; local29++) {
			local36 = this.entityRemovalIds[local29];
			if (this.players[local36].cycle != loopCycle) {
				this.players[local36] = null;
			}
		}
		if (arg0.pos != arg1) {
			System.err.println("Error packet size mismatch in getplayer pos:" + arg0.pos + " psize:" + arg1);
			throw new RuntimeException("eek");
		}
		for (local36 = 0; local36 < this.playerCount; local36++) {
			if (this.players[this.playerIds[local36]] == null) {
				System.err.println(this.username + " null entry in pl list - pos:" + local36 + " size:" + this.playerCount);
				throw new RuntimeException("eek");
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(III)Z")
	private boolean updateInterfaceAnimation(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(3) boolean local3 = false;
		@Pc(7) IfType local7 = IfType.instances[arg0];
		for (@Pc(9) int local9 = 0; local9 < local7.childId.length && local7.childId[local9] != -1; local9++) {
			@Pc(24) IfType local24 = IfType.instances[local7.childId[local9]];
			if (local24.type == 1) {
				local3 |= this.updateInterfaceAnimation(local24.id, arg1);
			}
			if (local24.type == 6 && (local24.seqId != -1 || local24.activeSeqId != -1)) {
				@Pc(54) boolean local54 = this.executeInterfaceScript(local24);
				@Pc(59) int local59;
				if (local54) {
					local59 = local24.activeSeqId;
				} else {
					local59 = local24.seqId;
				}
				if (local59 != -1) {
					@Pc(71) SeqType local71 = SeqType.instances[local59];
					local24.seqCycle += arg1;
					while (local24.seqCycle > local71.frameDelay[local24.seqFrame]) {
						local24.seqCycle -= local71.frameDelay[local24.seqFrame] + 1;
						local24.seqFrame++;
						if (local24.seqFrame >= local71.framecount) {
							local24.seqFrame -= local71.replayoff;
							if (local24.seqFrame < 0 || local24.seqFrame >= local71.framecount) {
								local24.seqFrame = 0;
							}
						}
						local3 = true;
					}
				}
			}
		}
		return local3;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILjava/lang/String;BLjava/lang/String;)V")
	private void addMessage(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1, @OriginalArg(3) String arg3) {
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
		this.messageText[0] = arg1;
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(II)V")
	private void resetInterfaceAnimation(@OriginalArg(1) int arg1) {
		@Pc(3) IfType local3 = IfType.instances[arg1];
		for (@Pc(5) int local5 = 0; local5 < local3.childId.length && local3.childId[local5] != -1; local5++) {
			@Pc(20) IfType local20 = IfType.instances[local3.childId[local5]];
			if (local20.type == 1) {
				this.resetInterfaceAnimation(local20.id);
			}
			local20.seqFrame = 0;
			local20.seqCycle = 0;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IJ)V")
	private void removeFriend(@OriginalArg(1) long arg1) {
		@Pc(6) int local6;
		if (arg1 == 0L) {
			return;
		}

		for (local6 = 0; local6 < this.friendCount; local6++) {
			if (this.friendName37[local6] == arg1) {
				this.friendCount--;
				this.redrawSidebar = true;
				for (@Pc(38) int local38 = local6; local38 < this.friendCount; local38++) {
					this.friendName[local38] = this.friendName[local38 + 1];
					this.friendWorld[local38] = this.friendWorld[local38 + 1];
					this.friendName37[local38] = this.friendName37[local38 + 1];
				}
				this.out.p1isaac(11);
				this.out.p8(arg1);
				return;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;I)Z")
	private boolean executeInterfaceScript(@OriginalArg(0) IfType arg0) {
		if (arg0.scriptComparator == null) {
			return false;
		}
		for (@Pc(6) int local6 = 0; local6 < arg0.scriptComparator.length; local6++) {
			@Pc(14) int local14 = this.executeClientscript1(arg0, local6);
			@Pc(19) int local19 = arg0.scriptOperand[local6];
			if (arg0.scriptComparator[local6] == 2) {
				if (local14 >= local19) {
					return false;
				}
			} else if (arg0.scriptComparator[local6] == 3) {
				if (local14 <= local19) {
					return false;
				}
			} else if (arg0.scriptComparator[local6] == 4) {
				if (local14 == local19) {
					return false;
				}
			} else if (local14 != local19) {
				return false;
			}
		}
		return true;
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(B)V")
	private void drawOnMinimap() {
		if (super.mouseClickButton != 1) {
			return;
		}

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
			@Pc(129) boolean local129 = this.tryMove(this.localPlayer.pathTileX[0], 0, true, local98, this.localPlayer.pathTileZ[0], 0, 1, 0, local106, 0, 0, 0);
			if (local129) {
				// the additional 14-bytes in MOVE_MINIMAPCLICK
				this.out.p1(local17);
				this.out.p1(local24);
				this.out.p2(this.orbitCameraYaw);
				this.out.p1(57);
				this.out.p1(this.minimapAnticheatAngle);
				this.out.p1(this.minimapZoom);
				this.out.p1(89);
				this.out.p2(this.localPlayer.x);
				this.out.p2(this.localPlayer.z);
				this.out.p1(this.tryMoveNearest);
				this.out.p1(63);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(B)V")
	private void handleObjDragging() {
		if (this.objDragArea != 0) {
			return;
		}

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
					this.useMenuOption(local149);
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
					local48 = this.menuParamA[this.menuSize - 1];
					local124 = this.menuParamB[this.menuSize - 1];
					@Pc(283) IfType local283 = IfType.instances[local124];
					if (local283.inventoryDraggable) {
						this.objGrabThreshold = false;
						this.objDragCycles = 0;
						this.objDragInterfaceId = local124;
						this.objDragSlot = local48;
						this.objDragArea = 2;
						this.objGrabX = super.mouseClickX;
						this.objGrabY = super.mouseClickY;
						if (IfType.instances[local124].parentId == this.viewportInterfaceId) {
							this.objDragArea = 1;
						}
						if (IfType.instances[local124].parentId == this.chatInterfaceId) {
							this.objDragArea = 3;
						}
						return;
					}
				}
			}
			if (local14 == 1 && (this.mouseButtonsOption == 1 || this.isAddFriendOption(this.menuSize - 1)) && this.menuSize > 2) {
				local14 = 2;
			}
			if (local14 == 1 && this.menuSize > 0) {
				this.useMenuOption(this.menuSize - 1);
			}
			if (local14 != 2 || this.menuSize <= 0) {
				return;
			}
			this.showContextMenu();
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(B)V")
	private void applyCutscene() {
		@Pc(6) int local6 = this.cutsceneSrcLocalTileX * 128 + 64;
		@Pc(13) int local13 = this.cutsceneSrcLocalTileZ * 128 + 64;
		@Pc(26) int local26 = this.getHeightmapY(this.currentLevel, this.cutsceneSrcLocalTileX, this.cutsceneSrcLocalTileZ) - this.cutsceneSrcHeight;
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
		local26 = this.getHeightmapY(this.currentLevel, this.cutsceneDstLocalTileX, this.cutsceneDstLocalTileZ) - this.cutsceneDstHeight;
		@Pc(226) int local226 = local6 - this.cameraX;
		@Pc(231) int local231 = local26 - this.cameraY;
		@Pc(236) int local236 = local13 - this.cameraZ;
		@Pc(247) int local247 = (int) Math.sqrt((double) (local226 * local226 + local236 * local236));
		@Pc(258) int local258 = (int) (Math.atan2((double) local231, (double) local247) * 325.949D) & 0x7FF;
		@Pc(269) int local269 = (int) (Math.atan2((double) local226, (double) local236) * -325.949D) & 0x7FF;
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

	@OriginalMember(owner = "client!client", name = "C", descriptor = "(I)V")
	private void handleTabInput() {
		if (super.mouseClickButton != 1) {
			return;
		}

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
		handleTabInputCounter++;
		if (handleTabInputCounter > 150) {
			handleTabInputCounter = 0;
			this.out.p1isaac(233);
			this.out.p1(43);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;B)Z")
	private boolean handleSocialMenuOption(@OriginalArg(0) IfType arg0) {
		@Pc(2) int local2 = arg0.contentType;
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
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(ILclient!kb;I)V")
	private void readNpcs(@OriginalArg(1) Packet arg1, @OriginalArg(2) int arg2) {
		arg1.accessBits();
		@Pc(14) int local14 = arg1.gBit(8);
		@Pc(20) int local20;
		if (local14 < this.npcCount) {
			for (local20 = local14; local20 < this.npcCount; local20++) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.npcIds[local20];
			}
		}
		if (local14 > this.npcCount) {
			System.err.println(this.username + " Too many npcs");
			throw new RuntimeException("eek");
		}
		this.npcCount = 0;
		for (local20 = 0; local20 < local14; local20++) {
			@Pc(72) int local72 = this.npcIds[local20];
			@Pc(77) NpcEntity local77 = this.npcs[local72];
			@Pc(82) int local82 = arg1.gBit(1);
			if (local82 == 0) {
				this.npcIds[this.npcCount++] = local72;
				local77.cycle = loopCycle;
			} else {
				@Pc(105) int local105 = arg1.gBit(2);
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
						local156 = arg1.gBit(3);
						local77.step(false, local156);
						local166 = arg1.gBit(1);
						if (local166 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = local72;
						}
					} else if (local105 == 2) {
						this.npcIds[this.npcCount++] = local72;
						local77.cycle = loopCycle;
						local156 = arg1.gBit(3);
						local77.step(true, local156);
						local166 = arg1.gBit(3);
						local77.step(true, local166);
						@Pc(224) int local224 = arg1.gBit(1);
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

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(Z)V")
	private void tryReconnect() {
		if (this.idleTimeout > 0) {
			this.logout();
		} else {
			this.areaViewport.bind();
			this.fontPlain12.drawStringCenter(144, 0, "Connection lost", 257);
			this.fontPlain12.drawStringCenter(143, 16777215, "Connection lost", 256);
			this.fontPlain12.drawStringCenter(159, 0, "Please wait - attempting to reestablish", 257);
			this.fontPlain12.drawStringCenter(158, 16777215, "Please wait - attempting to reestablish", 256);
			this.areaViewport.draw(11, super.graphics, 8);
			this.flagSceneTileX = 0;
			@Pc(60) ClientStream local60 = this.connection;
			this.ingame = false;
			this.login(this.username, this.password, true);
			if (!this.ingame) {
				this.logout();
			}
			try {
				local60.close();
			} catch (@Pc(80) Exception local80) {
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!ib;)V")
	private void updateFlameBuffer(@OriginalArg(1) Pix8 arg1) {
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
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(II)V")
	private void sortObjStacks(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		@Pc(9) LinkList local9 = this.levelObjStacks[this.currentLevel][arg0][arg1];
		if (local9 == null) {
			this.world3D.removeObjStack(this.currentLevel, arg0, arg1);
			return;
		}
		@Pc(21) int local21 = -99999999;
		@Pc(23) ObjEntity local23 = null;
		@Pc(27) ObjEntity local27;
		@Pc(35) int local35;
		for (local27 = (ObjEntity) local9.peekFront(); local27 != null; local27 = (ObjEntity) local9.prev()) {
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
		local9.pushFront(local23);
		@Pc(65) int local65 = -1;
		local35 = -1;
		@Pc(69) int local69 = 0;
		@Pc(71) int local71 = 0;
		for (local27 = (ObjEntity) local9.peekFront(); local27 != null; local27 = (ObjEntity) local9.prev()) {
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
			local118 = ObjType.get(local65).getInterfaceModel(local69);
		}
		@Pc(128) Model local128 = null;
		if (local35 != -1) {
			local128 = ObjType.get(local35).getInterfaceModel(local71);
		}
		@Pc(144) int local144 = arg0 + (arg1 << 7) + 1610612736;
		@Pc(148) ObjType local148 = ObjType.get(local23.index);
		this.world3D.addObjStack(local148.getInterfaceModel(local23.count), local118, this.getHeightmapY(this.currentLevel, arg0 * 128 + 64, arg1 * 128 + 64), this.currentLevel, local144, arg1, arg0, local128);
	}

	@OriginalMember(owner = "client!client", name = "D", descriptor = "(I)V")
	private void buildScene() {
		try {
			this.minimapLevel = -1;
			this.temporaryLocs.clear();
			this.locList.clear();
			this.spotanims.clear();
			this.projectiles.clear();
			Draw3D.clearTexels();
			this.clearCaches();
			this.world3D.reset();
			for (@Pc(28) int local28 = 0; local28 < 4; local28++) {
				this.levelCollisionMap[local28].reset();
			}
			System.gc();
			@Pc(53) World local53 = new World(104, this.levelTileFlags, 104, this.levelHeightmap);
			@Pc(56) byte[] local56 = new byte[100000];
			@Pc(60) int local60 = this.sceneMapLandData.length;
			World.lowMemory = World3D.lowMemory;
			@Pc(73) int local73;
			@Pc(80) int local80;
			for (@Pc(64) int local64 = 0; local64 < local60; local64++) {
				local73 = this.sceneMapIndex[local64] >> 8;
				local80 = this.sceneMapIndex[local64] & 0xFF;
				if (local73 == 33 && local80 >= 71 && local80 <= 73) {
					World.lowMemory = false;
				}
			}
			if (World.lowMemory) {
				this.world3D.setMinLevel(this.currentLevel);
			} else {
				this.world3D.setMinLevel(0);
			}
			this.out.p1isaac(108);
			@Pc(157) int local157;
			for (local73 = 0; local73 < local60; local73++) {
				local80 = (this.sceneMapIndex[local73] >> 8) * 64 - this.sceneBaseTileX;
				@Pc(143) int local143 = (this.sceneMapIndex[local73] & 0xFF) * 64 - this.sceneBaseTileZ;
				@Pc(148) byte[] local148 = this.sceneMapLandData[local73];
				if (local148 != null) {
					local157 = (new Packet(local148)).g4();
					BZip2.read(local56, local157, local148, local148.length - 4, 4);
					local53.readLandscape(local56, (this.sceneCenterZoneX - 6) * 8, local143, local80, (this.sceneCenterZoneZ - 6) * 8);
				} else if (this.sceneCenterZoneZ < 800) {
					local53.clearLandscape(local80, local143, 64, 64);
				}
			}
			this.out.p1isaac(108);
			@Pc(225) int local225;
			for (local80 = 0; local80 < local60; local80++) {
				@Pc(216) byte[] local216 = this.sceneMapLocData[local80];
				if (local216 != null) {
					local225 = (new Packet(local216)).g4();
					BZip2.read(local56, local225, local216, local216.length - 4, 4);
					local157 = (this.sceneMapIndex[local80] >> 8) * 64 - this.sceneBaseTileX;
					@Pc(259) int local259 = (this.sceneMapIndex[local80] & 0xFF) * 64 - this.sceneBaseTileZ;
					local53.readLocs(local56, this.world3D, this.levelCollisionMap, this.locList, local259, local157);
				}
			}
			this.out.p1isaac(108);
			local53.build(this.world3D, -270, this.levelCollisionMap);
			this.areaViewport.bind();
			this.out.p1isaac(108);
			for (@Pc(301) LocEntity local301 = (LocEntity) this.locList.peekFront(); local301 != null; local301 = (LocEntity) this.locList.prev()) {
				if ((this.levelTileFlags[1][local301.heightmapNE][local301.heightmapNW] & 0x2) == 2) {
					local301.heightmapSW--;
					if (local301.heightmapSW < 0) {
						local301.unlink();
					}
				}
			}
			for (local225 = 0; local225 < 104; local225++) {
				for (local157 = 0; local157 < 104; local157++) {
					this.sortObjStacks(local225, local157);
				}
			}
			for (@Pc(361) LocTemporary local361 = (LocTemporary) this.spawnedLocations.peekFront(); local361 != null; local361 = (LocTemporary) this.spawnedLocations.prev()) {
				this.addLoc(local361.orientation, local361.x, local361.z, local361.classType, local361.locIndex, local361.type, local361.plane);
			}
		} catch (@Pc(390) Exception local390) {
		}
		LocType.modelCacheStatic.clear();
		System.gc(); System.gc();
		Draw3D.initPool(20);
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(I)V")
	@Override
	protected void update() {
		if (this.errorStarted || this.errorLoading || this.errorHost) {
			return;
		}

		loopCycle++;
		if (this.ingame) {
			this.updateGame();
		} else {
			this.updateTitle();
		}
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(B)V")
	private void updateEntityChats() {
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
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;ZI)I")
	private int executeClientscript1(@OriginalArg(0) IfType arg0, @OriginalArg(2) int arg2) {
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
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(Z)V")
	private void drawError() {
		@Pc(4) Graphics local4 = this.getBaseComponent().getGraphics();
		local4.setColor(Color.black);
		local4.fillRect(0, 0, 789, 532);
		this.setFramerate(1);
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
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(B)V")
	private void loadTitleBackground() {
		@Pc(8) byte[] local8 = this.archiveTitle.read("title.dat", null);
		@Pc(14) Pix24 local14 = new Pix24(local8, this);
		this.imageTitle0.bind();
		local14.blitOpaque(0, 0);
		this.imageTitle1.bind();
		local14.blitOpaque(-661, 0);
		this.imageTitle2.bind();
		local14.blitOpaque(-128, 0);
		this.imageTitle3.bind();
		local14.blitOpaque(-214, -386);
		this.imageTitle4.bind();
		local14.blitOpaque(-214, -186);
		this.imageTitle5.bind();
		local14.blitOpaque(0, -265);
		this.imageTitle6.bind();
		local14.blitOpaque(-574, -265);
		this.imageTitle7.bind();
		local14.blitOpaque(-128, -186);
		this.imageTitle8.bind();
		local14.blitOpaque(-574, -186);
		@Pc(110) int[] local110 = new int[local14.width];
		for (@Pc(112) int local112 = 0; local112 < local14.height; local112++) {
			for (@Pc(116) int local116 = 0; local116 < local14.width; local116++) {
				local110[local116] = local14.pixels[local14.width + local14.width * local112 - local116 - 1];
			}
			for (@Pc(142) int local142 = 0; local142 < local14.width; local142++) {
				local14.pixels[local142 + local14.width * local112] = local110[local142];
			}
		}
		this.imageTitle0.bind();
		local14.blitOpaque(394, 0);
		this.imageTitle1.bind();
		local14.blitOpaque(-267, 0);
		this.imageTitle2.bind();
		local14.blitOpaque(266, 0);
		this.imageTitle3.bind();
		local14.blitOpaque(180, -386);
		this.imageTitle4.bind();
		local14.blitOpaque(180, -186);
		this.imageTitle5.bind();
		local14.blitOpaque(394, -265);
		this.imageTitle6.bind();
		local14.blitOpaque(-180, -265);
		this.imageTitle7.bind();
		local14.blitOpaque(212, -186);
		this.imageTitle8.bind();
		local14.blitOpaque(-180, -186);
		local14 = new Pix24(this.archiveTitle, "logo", 0);
		this.imageTitle2.bind();
		local14.draw(18, super.screenWidth / 2 - local14.width / 2 - 128);
		local14 = null;
		System.gc(); System.gc();
	}

	@OriginalMember(owner = "client!client", name = "E", descriptor = "(I)V")
	private void pushLocs() {
		for (@Pc(10) LocEntity local10 = (LocEntity) this.locList.peekFront(); local10 != null; local10 = (LocEntity) this.locList.prev()) {
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
					} while (local10.seqFrame < local10.seq.framecount);
					local10.seqFrame -= local10.seq.replayoff;
				} while (local10.seqFrame >= 0 && local10.seqFrame < local10.seq.framecount);
				local10.unlink();
				local14 = false;
			}
			if (local14) {
				@Pc(96) int local96 = local10.heightmapSW;
				@Pc(99) int local99 = local10.heightmapNE;
				@Pc(102) int local102 = local10.heightmapNW;
				@Pc(104) int local104 = 0;
				if (local10.heightmapSE == 0) {
					local104 = this.world3D.getWallBitset(local96, local99, local102);
				}
				if (local10.heightmapSE == 1) {
					local104 = this.world3D.getWallDecorationBitset(local96, local102, local99);
				}
				if (local10.heightmapSE == 2) {
					local104 = this.world3D.getLocBitset(local96, local99, local102);
				}
				if (local10.heightmapSE == 3) {
					local104 = this.world3D.getGroundDecorationBitset(local96, local99, local102);
				}
				if (local104 != 0 && (local104 >> 14 & 0x7FFF) == local10.index) {
					@Pc(171) int local171 = this.levelHeightmap[local96][local99][local102];
					@Pc(182) int local182 = this.levelHeightmap[local96][local99 + 1][local102];
					@Pc(195) int local195 = this.levelHeightmap[local96][local99 + 1][local102 + 1];
					@Pc(206) int local206 = this.levelHeightmap[local96][local99][local102 + 1];
					@Pc(210) LocType local210 = LocType.get(local10.index);
					@Pc(212) int local212 = -1;
					if (local10.seqFrame != -1) {
						local212 = local10.seq.primaryFrames[local10.seqFrame];
					}
					@Pc(235) int local235;
					@Pc(239) int local239;
					@Pc(243) int local243;
					@Pc(258) Model local258;
					if (local10.heightmapSE == 2) {
						local235 = this.world3D.getInfo(local96, local99, local102, local104);
						local239 = local235 & 0x1F;
						local243 = local235 >> 6;
						if (local239 == 11) {
							local239 = 10;
						}
						local258 = local210.getModel(local239, local243, local171, local182, local195, local206, local212);
						this.world3D.setLocModel(local99, local258, local96, local102);
					} else if (local10.heightmapSE == 1) {
						@Pc(282) Model local282 = local210.getModel(4, 0, local171, local182, local195, local206, local212);
						this.world3D.setWallDecorationModel(local102, local99, local282, local96);
					} else if (local10.heightmapSE == 0) {
						local235 = this.world3D.getInfo(local96, local99, local102, local104);
						local239 = local235 & 0x1F;
						local243 = local235 >> 6;
						if (local239 == 2) {
							@Pc(320) int local320 = local243 + 1 & 0x3;
							@Pc(332) Model local332 = local210.getModel(2, local243 + 4, local171, local182, local195, local206, local212);
							@Pc(342) Model local342 = local210.getModel(2, local320, local171, local182, local195, local206, local212);
							this.world3D.setWallModels(local332, local342, local102, local99, local96);
						} else {
							local258 = local210.getModel(local239, local243, local171, local182, local195, local206, local212);
							this.world3D.setWallModel(local258, local102, local99, local96);
						}
					} else if (local10.heightmapSE == 3) {
						local235 = this.world3D.getInfo(local96, local99, local102, local104);
						local239 = local235 >> 6;
						@Pc(400) Model local400 = local210.getModel(22, local239, local171, local182, local195, local206, local212);
						this.world3D.setGroundDecorationModel(local400, local102, local99, local96);
					}
				} else {
					local10.unlink();
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IJ)V")
	private void removeIgnore(@OriginalArg(1) long arg1) {
		if (arg1 == 0L) {
			return;
		}

		for (@Pc(14) int local14 = 0; local14 < this.ignoreCount; local14++) {
			if (this.ignoreName37[local14] == arg1) {
				this.ignoreCount--;
				this.redrawSidebar = true;
				for (@Pc(34) int local34 = local14; local34 < this.ignoreCount; local34++) {
					this.ignoreName37[local34] = this.ignoreName37[local34 + 1];
				}
				this.out.p1isaac(171);
				this.out.p8(arg1);
				return;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "q", descriptor = "(B)V")
	private void handleViewportOptions() {
		if (this.objSelected == 0 && this.spellSelected == 0) {
			this.menuOption[this.menuSize] = "Walk here";
			this.menuAction[this.menuSize] = 660;
			this.menuParamA[this.menuSize] = super.mouseX;
			this.menuParamB[this.menuSize] = super.mouseY;
			this.menuSize++;
		}
		@Pc(41) int local41 = -1;
		for (@Pc(52) int local52 = 0; local52 < Model.pickedCount; local52++) {
			@Pc(58) int local58 = Model.pickedBitsets[local52];
			@Pc(62) int local62 = local58 & 0x7F;
			@Pc(68) int local68 = local58 >> 7 & 0x7F;
			@Pc(74) int local74 = local58 >> 29 & 0x3;
			@Pc(80) int local80 = local58 >> 14 & 0x7FFF;
			if (local58 != local41) {
				local41 = local58;
				@Pc(218) int local218;
				if (local74 == 2 && this.world3D.getInfo(this.currentLevel, local62, local68, local58) >= 0) {
					@Pc(100) LocType loc = LocType.get(local80);
					if (this.objSelected == 1) {
						this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @cya@" + loc.name;
						this.menuAction[this.menuSize] = 450;
						this.menuParamC[this.menuSize] = local58;
						this.menuParamA[this.menuSize] = local62;
						this.menuParamB[this.menuSize] = local68;
						this.menuSize++;
					} else if (this.spellSelected != 1) {
						if (loc.ops != null) {
							for (local218 = 4; local218 >= 0; local218--) {
								if (loc.ops[local218] != null) {
									this.menuOption[this.menuSize] = loc.ops[local218] + " @cya@" + loc.name;
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
									this.menuParamC[this.menuSize] = local58;
									this.menuParamA[this.menuSize] = local62;
									this.menuParamB[this.menuSize] = local68;
									this.menuSize++;
								}
							}
						}
						this.menuOption[this.menuSize] = "Examine @cya@" + loc.name;
						if (this.showDebug) {
							this.menuOption[this.menuSize] += "@whi@ (" + loc.index + ")";
						}
						this.menuAction[this.menuSize] = 1175;
						this.menuParamC[this.menuSize] = local58;
						this.menuParamA[this.menuSize] = local62;
						this.menuParamB[this.menuSize] = local68;
						this.menuSize++;
					} else if ((this.activeSpellFlags & 0x4) == 4) {
						this.menuOption[this.menuSize] = this.spellCaption + " @cya@" + loc.name;
						this.menuAction[this.menuSize] = 55;
						this.menuParamC[this.menuSize] = local58;
						this.menuParamA[this.menuSize] = local62;
						this.menuParamB[this.menuSize] = local68;
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
								this.addNpcOptions(local395.type, local68, local62, this.npcIds[local218]);
							}
						}
					}
					this.addNpcOptions(local366.type, local68, local62, local80);
				}
				if (local74 == 0) {
					@Pc(446) PlayerEntity local446 = this.players[local80];
					if ((local446.x & 0x7F) == 64 && (local446.z & 0x7F) == 64) {
						for (local218 = 0; local218 < this.npcCount; local218++) {
							local395 = this.npcs[this.npcIds[local218]];
							if (local395 != null && local395.type.size == 1 && local395.x == local446.x && local395.z == local446.z) {
								this.addNpcOptions(local395.type, local68, local62, this.npcIds[local218]);
							}
						}
						for (@Pc(505) int local505 = 0; local505 < this.playerCount; local505++) {
							@Pc(515) PlayerEntity local515 = this.players[this.playerIds[local505]];
							if (local515 != null && local515 != local446 && local515.x == local446.x && local515.z == local446.z) {
								this.addPlayerOptions(local68, this.playerIds[local505], local515, local62);
							}
						}
					}
					this.addPlayerOptions(local68, local80, local446, local62);
				}
				if (local74 == 3) {
					@Pc(565) LinkList local565 = this.levelObjStacks[this.currentLevel][local62][local68];
					if (local565 != null) {
						for (@Pc(572) ObjEntity local572 = (ObjEntity) local565.peekBack(); local572 != null; local572 = (ObjEntity) local565.next()) {
							@Pc(578) ObjType obj = ObjType.get(local572.index);
							if (this.objSelected == 1) {
								this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + obj.name;
								this.menuAction[this.menuSize] = 217;
								this.menuParamC[this.menuSize] = local572.index;
								this.menuParamA[this.menuSize] = local62;
								this.menuParamB[this.menuSize] = local68;
								this.menuSize++;
							} else if (this.spellSelected != 1) {
								for (@Pc(695) int local695 = 4; local695 >= 0; local695--) {
									if (obj.ops != null && obj.ops[local695] != null) {
										this.menuOption[this.menuSize] = obj.ops[local695] + " @lre@" + obj.name;
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
										this.menuParamC[this.menuSize] = local572.index;
										this.menuParamA[this.menuSize] = local62;
										this.menuParamB[this.menuSize] = local68;
										this.menuSize++;
									} else if (local695 == 2) {
										this.menuOption[this.menuSize] = "Take @lre@" + obj.name;
										this.menuAction[this.menuSize] = 99;
										this.menuParamC[this.menuSize] = local572.index;
										this.menuParamA[this.menuSize] = local62;
										this.menuParamB[this.menuSize] = local68;
										this.menuSize++;
									}
								}
								this.menuOption[this.menuSize] = "Examine @lre@" + obj.name;
								if (this.showDebug) {
									this.menuOption[this.menuSize] += "@whi@ (" + obj.index + ")";
								}
								this.menuAction[this.menuSize] = 1102;
								this.menuParamC[this.menuSize] = local572.index;
								this.menuParamA[this.menuSize] = local62;
								this.menuParamB[this.menuSize] = local68;
								this.menuSize++;
							} else if ((this.activeSpellFlags & 0x1) == 1) {
								this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + obj.name;
								this.menuAction[this.menuSize] = 965;
								this.menuParamC[this.menuSize] = local572.index;
								this.menuParamA[this.menuSize] = local62;
								this.menuParamB[this.menuSize] = local68;
								this.menuSize++;
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(Z)V")
	private void updatePlayers() {
		@Pc(17) int local17;
		for (@Pc(9) int local9 = -1; local9 < this.playerCount; local9++) {
			if (local9 == -1) {
				local17 = this.LOCAL_PLAYER_INDEX;
			} else {
				local17 = this.playerIds[local9];
			}
			@Pc(29) PlayerEntity local29 = this.players[local17];
			if (local29 != null) {
				this.updateEntity(local29, 1);
			}
		}
		updatePlayersCounter++;
		if (updatePlayersCounter > 1406) {
			updatePlayersCounter = 0;
			this.out.p1isaac(219);
			this.out.p1(0);
			local17 = this.out.pos;
			this.out.p1(162);
			this.out.p1(22);
			if ((int) (Math.random() * 2.0D) == 0) {
				this.out.p1(84);
			}
			this.out.p2(31824);
			this.out.p2(13490);
			if ((int) (Math.random() * 2.0D) == 0) {
				this.out.p1(123);
			}
			if ((int) (Math.random() * 2.0D) == 0) {
				this.out.p1(134);
			}
			this.out.p1(100);
			this.out.p1(94);
			this.out.p2(35521);
			this.out.psize1(this.out.pos - local17);
		}
	}

	@OriginalMember(owner = "client!client", name = "r", descriptor = "(B)V")
	private void drawTileHint() {
		if (this.hintType != 2) {
			return;
		}

		this.project((this.hintTileX - this.sceneBaseTileX << 7) + this.hintOffsetX, this.hintHeight * 2, (this.hintTileZ - this.sceneBaseTileZ << 7) + this.hintOffsetZ);
		if (this.projectX > -1 && loopCycle % 20 < 10) {
			this.imageHeadicons[2].draw(this.projectY - 28, this.projectX - 12);
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IILclient!kb;)V")
	private void readLocalPlayer(@OriginalArg(1) int arg1, @OriginalArg(2) Packet arg2) {
		arg2.accessBits();
		@Pc(7) int local7 = arg2.gBit(1);
		if (local7 == 0) {
			return;
		}

		@Pc(21) int local21 = arg2.gBit(2);
		if (local21 == 0) {
			this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
		} else {
			@Pc(44) int local44;
			@Pc(55) int local55;
			if (local21 == 1) {
				local44 = arg2.gBit(3);
				this.localPlayer.step(false, local44);
				local55 = arg2.gBit(1);
				if (local55 == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				}
			} else {
				@Pc(101) int local101;
				if (local21 == 2) {
					local44 = arg2.gBit(3);
					this.localPlayer.step(true, local44);
					local55 = arg2.gBit(3);
					this.localPlayer.step(true, local55);
					local101 = arg2.gBit(1);
					if (local101 == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
					}
				} else if (local21 == 3) {
					this.currentLevel = arg2.gBit(2);
					local44 = arg2.gBit(7);
					local55 = arg2.gBit(7);
					local101 = arg2.gBit(1);
					this.localPlayer.move(local101 == 1, local44, local55);
					@Pc(158) int local158 = arg2.gBit(1);
					if (local158 == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(Z)V")
	private void drawChatback() {
		this.areaChatback.bind();
		Draw3D.lineOffset = this.areaChatbackOffsets;
		this.imageChatback.draw(0, 0);
		if (this.showSocialInput) {
			this.fontBold12.drawStringCenter(40, 0, this.socialMessage, 239);
			this.fontBold12.drawStringCenter(60, 128, this.socialInput + "*", 239);
		} else if (this.chatbackInputOpen) {
			this.fontBold12.drawStringCenter(40, 0, "Enter amount:", 239);
			this.fontBold12.drawStringCenter(60, 128, this.chatbackInput + "*", 239);
		} else if (this.modalMessage != null) {
			this.fontBold12.drawStringCenter(40, 0, this.modalMessage, 239);
			this.fontBold12.drawStringCenter(60, 128, "Click to continue", 239);
		} else if (this.chatInterfaceId != -1) {
			this.drawParentInterface(0, 0, IfType.instances[this.chatInterfaceId], 0);
		} else if (this.stickyChatInterfaceId == -1) {
			@Pc(135) BitmapFont local135 = this.fontPlain12;
			@Pc(137) int local137 = 0;
			Draw2D.setBounds(77, 0, 463, 0);
			for (@Pc(145) int local145 = 0; local145 < 100; local145++) {
				if (this.messageText[local145] != null) {
					@Pc(157) int local157 = this.messageType[local145];
					@Pc(166) int local166 = this.chatScrollOffset + 70 - local137 * 14;
					if (local157 == 0) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 0, this.messageText[local145]);
						}
						local137++;
					}
					if (local157 == 1) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 16777215, this.messageSender[local145] + ":");
							local135.drawString(local135.stringWidth(this.messageSender[local145]) + 12, local166, 255, this.messageText[local145]);
						}
						local137++;
					}
					if (local157 == 2 && (this.publicChatSetting == 0 || this.publicChatSetting == 1 && this.isFriend(this.messageSender[local145]))) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 0, this.messageSender[local145] + ":");
							local135.drawString(local135.stringWidth(this.messageSender[local145]) + 12, local166, 255, this.messageText[local145]);
						}
						local137++;
					}
					if ((local157 == 3 || local157 == 7) && this.splitPrivateChat == 0 && (local157 == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[local145]))) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 0, "From " + this.messageSender[local145] + ":");
							local135.drawString(local135.stringWidth("From " + this.messageSender[local145]) + 12, local166, 8388608, this.messageText[local145]);
						}
						local137++;
					}
					if (local157 == 4 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[local145]))) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 8388736, this.messageSender[local145] + " " + this.messageText[local145]);
						}
						local137++;
					}
					if (local157 == 5 && this.splitPrivateChat == 0 && this.privateChatSetting < 2) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 8388608, this.messageText[local145]);
						}
						local137++;
					}
					if (local157 == 6 && this.splitPrivateChat == 0 && this.privateChatSetting < 2) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 0, "To " + this.messageSender[local145] + ":");
							local135.drawString(local135.stringWidth("To " + this.messageSender[local145]) + 12, local166, 8388608, this.messageText[local145]);
						}
						local137++;
					}
					if (local157 == 8 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[local145]))) {
						if (local166 > 0 && local166 < 110) {
							local135.drawString(4, local166, 13350793, this.messageSender[local145] + " " + this.messageText[local145]);
						}
						local137++;
					}
				}
			}
			Draw2D.resetBounds();
			this.chatScrollHeight = local137 * 14 + 7;
			if (this.chatScrollHeight < 78) {
				this.chatScrollHeight = 78;
			}
			this.drawScrollbar(463, 0, this.chatScrollHeight - this.chatScrollOffset - 77, this.chatScrollHeight, 77);
			local135.drawString(4, 90, 0, JString.formatName(this.username) + ":");
			local135.drawString(local135.stringWidth(this.username + ": ") + 6, 90, 255, this.chatTyped + "*");
			Draw2D.drawHorizontalLine(0, 77, 479, 0);
		} else {
			this.drawParentInterface(0, 0, IfType.instances[this.stickyChatInterfaceId], 0);
		}
		if (this.menuVisible && this.menuArea == 2) {
			this.drawMenu();
		}
		this.areaChatback.draw(375, super.graphics, 22);
		this.areaViewport.bind();
		Draw3D.lineOffset = this.areaViewportOffsets;
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(Z)Z")
	private boolean read() {
		if (this.connection == null) {
			return false;
		}
		@Pc(1264) String local1264;
		@Pc(462) int local462;
		try {
			@Pc(15) int local15 = this.connection.available();
			if (local15 == 0) {
				return false;
			}
			if (this.packetType == -1) {
				this.connection.read(this.in.data, 0, 1);
				this.packetType = this.in.data[0] & 0xFF;
				if (this.randomIn != null) {
					this.packetType = this.packetType - this.randomIn.nextInt() & 0xFF;
				}
				this.packetSize = ServerProt.PACKET_LENGTHS[this.packetType];
				local15--;
			}
			if (this.packetSize == -1) {
				if (local15 <= 0) {
					return false;
				}
				this.connection.read(this.in.data, 0, 1);
				this.packetSize = this.in.data[0] & 0xFF;
				local15--;
			}
			if (this.packetSize == -2) {
				if (local15 <= 1) {
					return false;
				}
				this.connection.read(this.in.data, 0, 2);
				this.in.pos = 0;
				this.packetSize = this.in.g2();
				local15 -= 2;
			}
			if (local15 < this.packetSize) {
				return false;
			}
			this.in.pos = 0;
			this.connection.read(this.in.data, 0, this.packetSize);
			this.idleNetCycles = 0;
			this.lastPacketType2 = this.lastPacketType1;
			this.lastPacketType1 = this.lastPacketType0;
			this.lastPacketType0 = this.packetType;
			@Pc(159) int local159;
			if (this.packetType == 150) {
				local159 = this.in.g2();
				@Pc(163) byte local163 = this.in.g1b();
				this.varCache[local159] = local163;
				if (this.varps[local159] != local163) {
					this.varps[local159] = local163;
					this.updateVarp(local159);
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
				local207 = this.in.g8();
				local211 = this.in.g1();
				@Pc(217) String local217 = JString.formatName(JString.fromBase37(local207));
				for (local219 = 0; local219 < this.friendCount; local219++) {
					if (local207 == this.friendName37[local219]) {
						if (this.friendWorld[local219] != local211) {
							this.friendWorld[local219] = local211;
							this.redrawSidebar = true;
							if (local211 > 0) {
								this.addMessage(5, local217 + " has logged in.", "");
							}
							if (local211 == 0) {
								this.addMessage(5, local217 + " has logged out.", "");
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
				this.systemUpdateTimer = this.in.g2() * 30;
				this.packetType = -1;
				return true;
			}
			@Pc(466) int local466;
			if (this.packetType == 80) {
				local159 = this.in.g1();
				local462 = this.in.g1();
				local211 = -1;
				for (local466 = 0; local466 < this.sceneMapIndex.length; local466++) {
					if (this.sceneMapIndex[local466] == (local159 << 8) + local462) {
						local211 = local466;
					}
				}
				if (local211 != -1) {
					Signlink.cachesave("m" + local159 + "_" + local462, this.sceneMapLandData[local211]);
					this.sceneState = 1;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 1) {
				this.readNpcInfo(this.in, this.packetSize, false);
				this.packetType = -1;
				return true;
			}
			@Pc(650) int local650;
			if (this.packetType == 237) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				if (this.sceneCenterZoneX == local159 && this.sceneCenterZoneZ == local462 && this.sceneState != 0) {
					this.packetType = -1;
					return true;
				}
				this.sceneCenterZoneX = local159;
				this.sceneCenterZoneZ = local462;
				this.sceneBaseTileX = (this.sceneCenterZoneX - 6) * 8;
				this.sceneBaseTileZ = (this.sceneCenterZoneZ - 6) * 8;
				this.sceneState = 1;
				this.areaViewport.bind();
				this.fontPlain12.drawStringCenter(151, 0, "Loading - please wait.", 257);
				this.fontPlain12.drawStringCenter(150, 16777215, "Loading - please wait.", 256);
				this.areaViewport.draw(11, super.graphics, 8);
				Signlink.looprate(5);
				local211 = (this.packetSize - 2) / 10;
				this.sceneMapLandData = new byte[local211][];
				this.sceneMapLocData = new byte[local211][];
				this.sceneMapIndex = new int[local211];
				this.out.p1isaac(150);
				this.out.p1(0);
				local466 = 0;
				@Pc(662) int local662;
				for (local219 = 0; local219 < local211; local219++) {
					local650 = this.in.g1();
					local321 = this.in.g1();
					local354 = this.in.g4();
					local662 = this.in.g4();
					this.sceneMapIndex[local219] = (local650 << 8) + local321;
					@Pc(686) byte[] local686;
					if (local354 != 0) {
						local686 = Signlink.cacheload("m" + local650 + "_" + local321);
						if (local686 != null) {
							this.crc32.reset();
							this.crc32.update(local686);
							if ((int) this.crc32.getValue() != local354) {
								local686 = null;
							}
						}
						if (local686 == null) {
							this.sceneState = 0;
							this.out.p1(0);
							this.out.p1(local650);
							this.out.p1(local321);
							local466 += 3;
						} else {
							this.sceneMapLandData[local219] = local686;
						}
					}
					if (local662 != 0) {
						local686 = Signlink.cacheload("l" + local650 + "_" + local321);
						if (local686 != null) {
							this.crc32.reset();
							this.crc32.update(local686);
							if ((int) this.crc32.getValue() != local662) {
								local686 = null;
							}
						}
						if (local686 == null) {
							this.sceneState = 0;
							this.out.p1(1);
							this.out.p1(local650);
							this.out.p1(local321);
							local466 += 3;
						} else {
							this.sceneMapLocData[local219] = local686;
						}
					}
				}
				this.out.psize1(local466);
				Signlink.looprate(50);
				this.areaViewport.bind();
				if (this.sceneState == 0) {
					this.fontPlain12.drawStringCenter(166, 0, "Map area updated since last visit, so load will take longer this time only", 257);
					this.fontPlain12.drawStringCenter(165, 16777215, "Map area updated since last visit, so load will take longer this time only", 256);
				}
				this.areaViewport.draw(11, super.graphics, 8);
				local650 = this.sceneBaseTileX - this.mapLastBaseX;
				local321 = this.sceneBaseTileZ - this.mapLastBaseZ;
				this.mapLastBaseX = this.sceneBaseTileX;
				this.mapLastBaseZ = this.sceneBaseTileZ;
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
				for (local662 = 0; local662 < this.MAX_PLAYER_COUNT; local662++) {
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
				for (@Pc(1066) LocTemporary local1066 = (LocTemporary) this.spawnedLocations.peekFront(); local1066 != null; local1066 = (LocTemporary) this.spawnedLocations.prev()) {
					local1066.x -= local650;
					local1066.z -= local321;
					if (local1066.x < 0 || local1066.z < 0 || local1066.x >= 104 || local1066.z >= 104) {
						local1066.unlink();
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
				local159 = this.in.g2();
				IfType.instances[local159].model = this.localPlayer.getHeadModel();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 25) {
				this.hintType = this.in.g1();
				if (this.hintType == 1) {
					this.hintNpc = this.in.g2();
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
					this.hintTileX = this.in.g2();
					this.hintTileZ = this.in.g2();
					this.hintHeight = this.in.g1();
				}
				if (this.hintType == 10) {
					this.hintPlayer = this.in.g2();
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 54) {
				local1264 = this.in.gstr();
				local462 = this.in.g4();
				local211 = this.in.g4();
				if (!local1264.equals(this.currentMidi) && this.midiActive && !lowMemory) {
					this.setMidi(local462, local1264, local211);
				}
				this.currentMidi = local1264;
				this.midiCrc = local462;
				this.midiSize = local211;
				this.nextMusicDelay = 0;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 142) {
				this.logout();
				this.packetType = -1;
				return false;
			}
			if (this.packetType == 20) {
				local159 = this.in.g1();
				local462 = this.in.g1();
				local211 = -1;
				for (local466 = 0; local466 < this.sceneMapIndex.length; local466++) {
					if (this.sceneMapIndex[local466] == (local159 << 8) + local462) {
						local211 = local466;
					}
				}
				if (local211 != -1) {
					Signlink.cachesave("l" + local159 + "_" + local462, this.sceneMapLocData[local211]);
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
				this.localPid = this.in.g2();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 151 || this.packetType == 23 || this.packetType == 50 || this.packetType == 191 || this.packetType == 69 || this.packetType == 49 || this.packetType == 223 || this.packetType == 42 || this.packetType == 76 || this.packetType == 59) {
				this.readZonePacket(this.in, this.packetType);
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 28) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				if (this.chatInterfaceId != -1) {
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
				}
				if (this.chatbackInputOpen) {
					this.chatbackInputOpen = false;
					this.redrawChatback = true;
				}
				this.viewportInterfaceId = local159;
				this.sidebarInterfaceId = local462;
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 175) {
				local159 = this.in.g2();
				local462 = this.in.g4();
				this.varCache[local159] = local462;
				if (this.varps[local159] != local462) {
					this.varps[local159] = local462;
					this.updateVarp(local159);
					this.redrawSidebar = true;
					if (this.stickyChatInterfaceId != -1) {
						this.redrawChatback = true;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 146) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				IfType.instances[local159].seqId = local462;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 167) {
				local159 = this.in.g2();
				local462 = this.in.g1();
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
				local159 = this.in.g1();
				local462 = this.in.g1();
				local211 = this.in.g2();
				local466 = this.in.g2();
				local219 = -1;
				for (local650 = 0; local650 < this.sceneMapIndex.length; local650++) {
					if (this.sceneMapIndex[local650] == (local159 << 8) + local462) {
						local219 = local650;
					}
				}
				if (local219 != -1) {
					if (this.sceneMapLocData[local219] == null || this.sceneMapLocData[local219].length != local466) {
						this.sceneMapLocData[local219] = new byte[local466];
					}
					this.in.gdata(this.packetSize - 6, local211, this.sceneMapLocData[local219]);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 133) {
				@Pc(1701) Packet local1701 = TrackInput.stop();
				if (local1701 != null) {
					this.out.p1isaac(81);
					this.out.p2(local1701.pos);
					this.out.pdata(local1701.data, local1701.pos, 0);
					local1701.release();
				}
				this.packetType = -1;
				return true;
			}
			@Pc(1745) IfType local1745;
			if (this.packetType == 98) {
				this.redrawSidebar = true;
				local159 = this.in.g2();
				local1745 = IfType.instances[local159];
				local211 = this.in.g1();
				for (local466 = 0; local466 < local211; local466++) {
					local1745.inventorySlotObjId[local466] = this.in.g2();
					local219 = this.in.g1();
					if (local219 == 255) {
						local219 = this.in.g4();
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
				TrackInput.setEnabled();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 243) {
				this.showSocialInput = false;
				this.chatbackInputOpen = true;
				this.chatbackInput = "";
				this.redrawChatback = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 15) {
				local159 = this.in.g2();
				local1745 = IfType.instances[local159];
				for (local211 = 0; local211 < local1745.inventorySlotObjId.length; local211++) {
					local1745.inventorySlotObjId[local211] = -1;
					local1745.inventorySlotObjId[local211] = 0;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 140) {
				this.lastAddress = this.in.g4();
				this.daysSinceLastLogin = this.in.g2();
				this.daysSinceRecoveriesChanged = this.in.g1();
				this.unreadMessages = this.in.g2();
				if (this.lastAddress != 0 && this.viewportInterfaceId == -1) {
					Signlink.dnslookup(JString.formatIPv4(this.lastAddress));
					this.closeInterfaces();
					@Pc(1915) short local1915 = 650;
					if (this.daysSinceRecoveriesChanged != 201) {
						local1915 = 655;
					}
					this.reportAbuseInput = "";
					this.reportAbuseMuteOption = false;
					for (local462 = 0; local462 < IfType.instances.length; local462++) {
						if (IfType.instances[local462] != null && IfType.instances[local462].contentType == local1915) {
							this.viewportInterfaceId = IfType.instances[local462].parentId;
							break;
						}
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 126) {
				this.flashingTab = this.in.g1();
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
					local159 = this.in.g2();
					local462 = this.in.g4();
					local211 = this.packetSize - 6;
					@Pc(2018) byte[] local2018 = new byte[local462];
					BZip2.read(local2018, local462, this.in.data, local211, this.in.pos);
					this.saveMidi(local2018, local462, false);
					this.nextMusicDelay = local159;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 254) {
				this.inMultizone = this.in.g1();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 12) {
				local159 = this.in.g2();
				local462 = this.in.g1();
				local211 = this.in.g2();
				if (this.waveEnabled && !lowMemory && this.waveCount < 50) {
					this.waveIds[this.waveCount] = local159;
					this.waveLoops[this.waveCount] = local462;
					this.waveDelay[this.waveCount] = local211 + Wave.delays[local159];
					this.waveCount++;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 204) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				@Pc(2130) NpcType local2130 = NpcType.get(local462);
				IfType.instances[local159].model = local2130.getHeadModel();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 7) {
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1();
				this.packetType = -1;
				return true;
			}
			@Pc(2181) IfType local2181;
			if (this.packetType == 103) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				local211 = this.in.g2();
				local2181 = IfType.instances[local159];
				@Pc(2184) Model local2184 = local2181.model;
				if (local2184 != null) {
					local2184.recolor(local462, local211);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 32) {
				this.publicChatSetting = this.in.g1();
				this.privateChatSetting = this.in.g1();
				this.tradeChatSetting = this.in.g1();
				this.redrawPrivacySettings = true;
				this.redrawChatback = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 195) {
				local159 = this.in.g2();
				this.resetInterfaceAnimation(local159);
				if (this.chatInterfaceId != -1) {
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
				}
				if (this.chatbackInputOpen) {
					this.chatbackInputOpen = false;
					this.redrawChatback = true;
				}
				this.sidebarInterfaceId = local159;
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.viewportInterfaceId = -1;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 14) {
				local159 = this.in.g2();
				this.resetInterfaceAnimation(local159);
				if (this.sidebarInterfaceId != -1) {
					this.sidebarInterfaceId = -1;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
				}
				this.chatInterfaceId = local159;
				this.redrawChatback = true;
				this.viewportInterfaceId = -1;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 209) {
				local159 = this.in.g2();
				local462 = this.in.g2b();
				local211 = this.in.g2b();
				local2181 = IfType.instances[local159];
				local2181.x = local462;
				local2181.y = local211;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 3) {
				this.cutscene = true;
				this.cutsceneSrcLocalTileX = this.in.g1();
				this.cutsceneSrcLocalTileZ = this.in.g1();
				this.cutsceneSrcHeight = this.in.g2();
				this.cutsceneMoveSpeed = this.in.g1();
				this.cutsceneMoveAcceleration = this.in.g1();
				if (this.cutsceneMoveAcceleration >= 100) {
					this.cameraX = this.cutsceneSrcLocalTileX * 128 + 64;
					this.cameraZ = this.cutsceneSrcLocalTileZ * 128 + 64;
					this.cameraY = this.getHeightmapY(this.currentLevel, this.cutsceneSrcLocalTileX, this.cutsceneSrcLocalTileZ) - this.cutsceneSrcHeight;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 135) {
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1();
				for (local159 = this.baseX; local159 < this.baseX + 8; local159++) {
					for (local462 = this.baseZ; local462 < this.baseZ + 8; local462++) {
						if (this.levelObjStacks[this.currentLevel][local159][local462] != null) {
							this.levelObjStacks[this.currentLevel][local159][local462] = null;
							this.sortObjStacks(local159, local462);
						}
					}
				}
				for (@Pc(2487) LocTemporary local2487 = (LocTemporary) this.spawnedLocations.peekFront(); local2487 != null; local2487 = (LocTemporary) this.spawnedLocations.prev()) {
					if (local2487.x >= this.baseX && local2487.x < this.baseX + 8 && local2487.z >= this.baseZ && local2487.z < this.baseZ + 8 && local2487.plane == this.currentLevel) {
						this.addLoc(local2487.lastOrientation, local2487.x, local2487.z, local2487.classType, local2487.lastLocIndex, local2487.lastType, local2487.plane);
						local2487.unlink();
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 132) {
				local159 = this.in.g1();
				local462 = this.in.g1();
				local211 = this.in.g2();
				local466 = this.in.g2();
				local219 = -1;
				for (local650 = 0; local650 < this.sceneMapIndex.length; local650++) {
					if (this.sceneMapIndex[local650] == (local159 << 8) + local462) {
						local219 = local650;
					}
				}
				if (local219 != -1) {
					if (this.sceneMapLandData[local219] == null || this.sceneMapLandData[local219].length != local466) {
						this.sceneMapLandData[local219] = new byte[local466];
					}
					this.in.gdata(this.packetSize - 6, local211, this.sceneMapLandData[local219]);
				}
				this.packetType = -1;
				return true;
			}
			@Pc(2652) boolean local2652;
			if (this.packetType == 41) {
				local207 = this.in.g8();
				local211 = this.in.g4();
				local466 = this.in.g1();
				local2652 = false;
				for (local650 = 0; local650 < 100; local650++) {
					if (this.messageIds[local650] == local211) {
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
						this.messageIds[this.privateMessageCount] = local211;
						this.privateMessageCount = (this.privateMessageCount + 1) % 100;
						@Pc(2721) String local2721 = WordPack.unpack(this.in, this.packetSize - 13);
						@Pc(2725) String local2725 = WordFilter.filter(local2721);
						if (local466 > 1) {
							this.addMessage(7, local2725, JString.formatName(JString.fromBase37(local207)));
						} else {
							this.addMessage(3, local2725, JString.formatName(JString.fromBase37(local207)));
						}
					} catch (@Pc(2752) Exception local2752) {
						System.err.println("cde1");
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 193) {
				for (local159 = 0; local159 < this.varps.length; local159++) {
					if (this.varps[local159] != this.varCache[local159]) {
						this.varps[local159] = this.varCache[local159];
						this.updateVarp(local159);
						this.redrawSidebar = true;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 87) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				IfType.instances[local159].model = new Model(local462);
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 185) {
				local159 = this.in.g2b();
				this.stickyChatInterfaceId = local159;
				this.redrawChatback = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 68) {
				if (this.selectedTab == 12) {
					this.redrawSidebar = true;
				}
				this.energy = this.in.g1();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 74) {
				this.cutscene = true;
				this.cutsceneDstLocalTileX = this.in.g1();
				this.cutsceneDstLocalTileZ = this.in.g1();
				this.cutsceneDstHeight = this.in.g2();
				this.cutsceneRotateSpeed = this.in.g1();
				this.cutsceneRotateAcceleration = this.in.g1();
				if (this.cutsceneRotateAcceleration >= 100) {
					local159 = this.cutsceneDstLocalTileX * 128 + 64;
					local462 = this.cutsceneDstLocalTileZ * 128 + 64;
					local211 = this.getHeightmapY(this.currentLevel, this.cutsceneDstLocalTileX, this.cutsceneDstLocalTileZ) - this.cutsceneDstHeight;
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
				this.selectedTab = this.in.g1();
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.packetType = -1;
				return true;
			}
			@Pc(3040) String local3040;
			if (this.packetType == 4) {
				local1264 = this.in.gstr();
				@Pc(3043) long local3043;
				if (local1264.endsWith(":tradereq:")) {
					local3040 = local1264.substring(0, local1264.indexOf(":"));
					local3043 = JString.toBase37(local3040);
					local2652 = false;
					for (local650 = 0; local650 < this.ignoreCount; local650++) {
						if (this.ignoreName37[local650] == local3043) {
							local2652 = true;
							break;
						}
					}
					if (!local2652 && this.overrideChat == 0) {
						this.addMessage(4, "wishes to trade with you.", local3040);
					}
				} else if (local1264.endsWith(":duelreq:")) {
					local3040 = local1264.substring(0, local1264.indexOf(":"));
					local3043 = JString.toBase37(local3040);
					local2652 = false;
					for (local650 = 0; local650 < this.ignoreCount; local650++) {
						if (this.ignoreName37[local650] == local3043) {
							local2652 = true;
							break;
						}
					}
					if (!local2652 && this.overrideChat == 0) {
						this.addMessage(8, "wishes to duel with you.", local3040);
					}
				} else {
					this.addMessage(0, local1264, "");
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 46) {
				local159 = this.in.g2();
				local462 = this.in.g2();
				local211 = this.in.g2();
				@Pc(3157) ObjType local3157 = ObjType.get(local462);
				IfType.instances[local159].model = local3157.getInterfaceModel(50);
				IfType.instances[local159].modelPitch = local3157.xan2d;
				IfType.instances[local159].modelYaw = local3157.yan2d;
				IfType.instances[local159].modelZoom = local3157.zoom2d * 100 / local211;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 168) {
				local159 = this.in.g2();
				this.resetInterfaceAnimation(local159);
				if (this.sidebarInterfaceId != -1) {
					this.sidebarInterfaceId = -1;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
				}
				if (this.chatInterfaceId != -1) {
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
				}
				if (this.chatbackInputOpen) {
					this.chatbackInputOpen = false;
					this.redrawChatback = true;
				}
				this.viewportInterfaceId = local159;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 2) {
				local159 = this.in.g2();
				local462 = this.in.g2();
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
				local159 = this.in.g2();
				@Pc(3362) boolean local3362 = this.in.g1() == 1;
				IfType.instances[local159].hide = local3362;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 21) {
				this.ignoreCount = this.packetSize / 8;
				for (local159 = 0; local159 < this.ignoreCount; local159++) {
					this.ignoreName37[local159] = this.in.g8();
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
				if (this.chatbackInputOpen) {
					this.chatbackInputOpen = false;
					this.redrawChatback = true;
				}
				this.viewportInterfaceId = -1;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 201) {
				local159 = this.in.g2();
				local3040 = this.in.gstr();
				IfType.instances[local159].text = local3040;
				if (IfType.instances[local159].parentId == this.tabInterfaceId[this.selectedTab]) {
					this.redrawSidebar = true;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 44) {
				this.redrawSidebar = true;
				local159 = this.in.g1();
				local462 = this.in.g4();
				local211 = this.in.g1();
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
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1();
				while (this.in.pos < this.packetSize) {
					local159 = this.in.g1();
					this.readZonePacket(this.in, local159);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 22) {
				if (this.selectedTab == 12) {
					this.redrawSidebar = true;
				}
				this.weightCarried = this.in.g2b();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 13) {
				local159 = this.in.g1();
				local462 = this.in.g1();
				local211 = this.in.g1();
				local466 = this.in.g1();
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
				local159 = this.in.g2();
				local1745 = IfType.instances[local159];
				while (this.in.pos < this.packetSize) {
					local211 = this.in.g1();
					local466 = this.in.g2();
					local219 = this.in.g1();
					if (local219 == 255) {
						local219 = this.in.g4();
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
				this.readPlayerInfo(this.in, this.packetSize);
				if (this.sceneState == 1) {
					this.sceneState = 2;
					World.levelBuilt = this.currentLevel;
					this.buildScene();
				}
				if (lowMemory && this.sceneState == 2 && World.levelBuilt != this.currentLevel) {
					this.areaViewport.bind();
					this.fontPlain12.drawStringCenter(151, 0, "Loading - please wait.", 257);
					this.fontPlain12.drawStringCenter(150, 16777215, "Loading - please wait.", 256);
					this.areaViewport.draw(11, super.graphics, 8);
					World.levelBuilt = this.currentLevel;
					this.buildScene();
				}
				if (this.currentLevel != this.minimapLevel && this.sceneState == 2) {
					this.minimapLevel = this.currentLevel;
					this.createMinimap(this.currentLevel);
				}
				this.packetType = -1;
				return true;
			}
			System.err.println("T1 - " + this.packetType + "," + this.packetSize + " - " + this.lastPacketType1 + "," + this.lastPacketType2);
			this.logout();
		} catch (@Pc(3862) IOException local3862) {
			this.tryReconnect();
		} catch (@Pc(3867) Exception local3867) {
			local1264 = "T2 - " + this.packetType + "," + this.lastPacketType1 + "," + this.lastPacketType2 + " - " + this.packetSize + "," + (this.sceneBaseTileX + this.localPlayer.pathTileX[0]) + "," + (this.sceneBaseTileZ + this.localPlayer.pathTileZ[0]) + " - ";
			for (local462 = 0; local462 < this.packetSize && local462 < 50; local462++) {
				local1264 = local1264 + this.in.data[local462] + ",";
			}
			System.err.println(local1264);
			this.logout();
		}
		return true;
	}

	@OriginalMember(owner = "client!client", name = "s", descriptor = "(B)V")
	private void drawSidebar() {
		this.areaSidebar.bind();
		Draw3D.lineOffset = this.areaSidebarOffsets;
		this.imageInvback.draw(0, 0);
		if (this.sidebarInterfaceId != -1) {
			this.drawParentInterface(0, 0, IfType.instances[this.sidebarInterfaceId], 0);
		} else if (this.tabInterfaceId[this.selectedTab] != -1) {
			this.drawParentInterface(0, 0, IfType.instances[this.tabInterfaceId[this.selectedTab]], 0);
		}
		if (this.menuVisible && this.menuArea == 1) {
			this.drawMenu();
		}
		this.areaSidebar.draw(231, super.graphics, 562);
		this.areaViewport.bind();
		Draw3D.lineOffset = this.areaViewportOffsets;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILjava/lang/String;)Z")
	private boolean isFriend(@OriginalArg(1) String arg1) {
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
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!kb;Lclient!z;)V")
	private void readPlayerUpdates(@OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Packet arg3, @OriginalArg(4) PlayerEntity arg4) {
		@Pc(19) int local19;
		if ((arg2 & 0x1) == 1) {
			local19 = arg3.g1();
			@Pc(22) byte[] local22 = new byte[local19];
			@Pc(28) Packet local28 = new Packet(local22);
			arg3.gdata(local19, 0, local22);
			this.playerAppearanceBuffer[arg1] = local28;
			arg4.read(local28);
		}
		@Pc(66) int local66;
		if ((arg2 & 0x2) == 2) {
			local19 = arg3.g2();
			if (local19 == 65535) {
				local19 = -1;
			}
			if (local19 == arg4.primarySeqId) {
				arg4.primarySeqLoop = 0;
			}
			local66 = arg3.g1();
			if (local19 == -1 || arg4.primarySeqId == -1 || SeqType.instances[local19].priority > SeqType.instances[arg4.primarySeqId].priority || SeqType.instances[arg4.primarySeqId].priority == 0) {
				arg4.primarySeqId = local19;
				arg4.primarySeqFrame = 0;
				arg4.primarySeqCycle = 0;
				arg4.primarySeqDelay = local66;
				arg4.primarySeqLoop = 0;
			}
		}
		if ((arg2 & 0x4) == 4) {
			arg4.targetId = arg3.g2();
			if (arg4.targetId == 65535) {
				arg4.targetId = -1;
			}
		}
		if ((arg2 & 0x8) == 8) {
			arg4.chat = arg3.gstr();
			arg4.chatColor = 0;
			arg4.chatStyle = 0;
			arg4.chatTimer = 150;
			this.addMessage(2, arg4.chat, arg4.name);
		}
		if ((arg2 & 0x10) == 16) {
			arg4.damage = arg3.g1();
			arg4.damageType = arg3.g1();
			arg4.combatCycle = loopCycle + 400;
			arg4.health = arg3.g1();
			arg4.totalHealth = arg3.g1();
		}
		if ((arg2 & 0x20) == 32) {
			arg4.targetTileX = arg3.g2();
			arg4.targetTileZ = arg3.g2();
		}
		if ((arg2 & 0x40) == 64) {
			local19 = arg3.g2();
			local66 = arg3.g1();
			@Pc(199) int local199 = arg3.g1();
			@Pc(202) int local202 = arg3.pos;
			if (arg4.name != null) {
				@Pc(209) long local209 = JString.toBase37(arg4.name);
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
						@Pc(244) String local244 = WordPack.unpack(arg3, local199);
						@Pc(248) String local248 = WordFilter.filter(local244);
						arg4.chat = local248;
						arg4.chatColor = local19 >> 8;
						arg4.chatStyle = local19 & 0xFF;
						arg4.chatTimer = 150;
						if (local66 > 1) {
							this.addMessage(1, local248, arg4.name);
						} else {
							this.addMessage(2, local248, arg4.name);
						}
					} catch (@Pc(285) Exception local285) {
						System.err.println("cde2");
					}
				}
			}
			arg3.pos = local202 + local199;
		}
		if ((arg2 & 0x100) == 256) {
			arg4.spotanimId = arg3.g2();
			local19 = arg3.g4();
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
			arg4.forceMoveStartSceneTileX = arg3.g1();
			arg4.forceMoveStartSceneTileZ = arg3.g1();
			arg4.forceMoveEndSceneTileX = arg3.g1();
			arg4.forceMoveEndSceneTileZ = arg3.g1();
			arg4.forceMoveEndCycle = arg3.g2() + loopCycle;
			arg4.forceMoveStartCycle = arg3.g2() + loopCycle;
			arg4.forceMoveFaceDirection = arg3.g1();
			arg4.pathLength = 0;
			arg4.pathTileX[0] = arg4.forceMoveEndSceneTileX;
			arg4.pathTileZ[0] = arg4.forceMoveEndSceneTileZ;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLjava/lang/String;I)V")
	@Override
	protected void drawProgress(@OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		this.loadTitle();
		if (this.archiveTitle == null) {
			super.drawProgress(arg1, arg2);
		} else {
			this.imageTitle4.bind();
			@Pc(17) short local17 = 360;
			@Pc(19) short local19 = 200;
			@Pc(21) byte local21 = 20;
			this.fontBold12.drawStringCenter(local19 / 2 - local21 - 26, 16777215, "RuneScape is loading - please wait...", local17 / 2);
			@Pc(51) int local51 = local19 / 2 - local21 - 18;
			Draw2D.drawRect(local17 / 2 - 152, 9179409, 34, local51, 304);
			Draw2D.drawRect(local17 / 2 - 151, 0, 32, local51 + 1, 302);
			Draw2D.fillRect(local51 + 2, local17 / 2 - 150, 9179409, arg2 * 3, 30);
			Draw2D.fillRect(local51 + 2, local17 / 2 - 150 + arg2 * 3, 0, 300 - arg2 * 3, 30);
			this.fontBold12.drawStringCenter(local19 / 2 + 5 - local21, 16777215, arg1, local17 / 2);
			this.imageTitle4.draw(186, super.graphics, 214);
			if (this.redrawTitleBackground) {
				this.redrawTitleBackground = false;
				if (!this.flameActive) {
					this.imageTitle0.draw(0, super.graphics, 0);
					this.imageTitle1.draw(0, super.graphics, 661);
				}
				this.imageTitle2.draw(0, super.graphics, 128);
				this.imageTitle3.draw(386, super.graphics, 214);
				this.imageTitle5.draw(265, super.graphics, 0);
				this.imageTitle6.draw(265, super.graphics, 574);
				this.imageTitle7.draw(186, super.graphics, 128);
				this.imageTitle8.draw(186, super.graphics, 574);
			}
		}
	}

	@Override
	protected void mouseWheelMoved(int rotation) {
		if (this.sceneState == 2) {
			if (super.mouseX > 22 && super.mouseY > 375 && super.mouseX < 431 && super.mouseY < 471 && this.chatInterfaceId == -1) {
				// chat scrolling
				this.chatInterface.scrollPosition += rotation * 8;
				int offset = this.chatScrollHeight - this.chatInterface.scrollPosition - 77;
				if (offset < 0) {
					offset = 0;
				}
				if (offset > this.chatScrollHeight - 77) {
					offset = this.chatScrollHeight - 77;
				}
				if (this.chatScrollOffset != offset) {
					this.chatScrollOffset = offset;
					this.redrawChatback = true;
				}
			}

			if (super.mouseX > 8 && super.mouseY > 11 && super.mouseX < 520 && super.mouseY < 345) {
				if (this.viewportInterfaceId == -1) {
					// viewport zooming
				} else {
					// viewport scrolling
					IfType parent = IfType.instances[this.viewportInterfaceId];
					if (parent.type == 0 && parent.childId != null && !parent.hide) {
						for (int i = 0; i < parent.childId.length; i++) {
							IfType child = IfType.instances[parent.childId[i]];

							if (child.scrollableHeight > child.height) {
								int offset = child.scrollPosition + (rotation * 8);
								if (offset < 0) {
									offset = 0;
								} else if (offset > child.scrollableHeight) {
									offset = child.scrollableHeight;
								}
								if (child.scrollPosition != offset) {
									child.scrollPosition = offset;
								}
							}
						}
					}
				}
			}

			if (super.mouseX > 562 && super.mouseY > 231 && super.mouseX < 752 && super.mouseY < 492) {
				if (this.sidebarInterfaceId != -1) {
					// sidebar interface scrolling
					IfType parent = IfType.instances[this.sidebarInterfaceId];
					if (parent.type == 0 && parent.childId != null && !parent.hide) {
						for (int i = 0; i < parent.childId.length; i++) {
							IfType child = IfType.instances[parent.childId[i]];

							if (child.scrollableHeight > child.height) {
								int offset = child.scrollPosition + (rotation * 8);
								if (offset < 0) {
									offset = 0;
								} else if (offset > child.scrollableHeight) {
									offset = child.scrollableHeight;
								}
								if (child.scrollPosition != offset) {
									child.scrollPosition = offset;
									this.redrawSidebar = true;
								}
							}
						}
					}
				} else if (this.tabInterfaceId[this.selectedTab] != -1) {
					// tab interface scrolling
					IfType parent = IfType.instances[this.tabInterfaceId[this.selectedTab]];
					if (parent.type == 0 && parent.childId != null && !parent.hide) {
						for (int i = 0; i < parent.childId.length; i++) {
							IfType child = IfType.instances[parent.childId[i]];

							if (child.scrollableHeight > child.height) {
								int offset = child.scrollPosition + (rotation * 8);
								if (offset < 0) {
									offset = 0;
								} else if (offset > child.scrollableHeight) {
									offset = child.scrollableHeight;
								}
								if (child.scrollPosition != offset) {
									child.scrollPosition = offset;
									this.redrawSidebar = true;
								}
							}
						}
					}
				}
			}

			/*if (super.mouseX > 579 && super.mouseY > 12 && super.mouseX < 730 && super.mouseY < 167) {
				// minimap zooming
				this.minimapZoom += rotation * 8;
				if (this.minimapZoom < -150) {
					this.minimapZoom = -150;
				}
				if (this.minimapZoom > 300) {
					this.minimapZoom = 300;
				}
			}*/
		}
	}

	@Override
	protected void mouseWheelDragged(int x, int y) {
		if (this.sceneState == 2) {
			// limit to viewport: super.mouseX > 8 && super.mouseY > 11 && super.mouseX < 520 && super.mouseY < 345
			if (this.viewportInterfaceId == -1) {
				x *= 3;
				y <<= 1;
				if (x > 3) {
					x = 3;
				}
				if (x < -3) {
					x = -3;
				}
				if (y > 3) {
					y = 3;
				}
				if (y < -3) {
					y = -3;
				}

				this.orbitCameraYaw += x;
				this.orbitCameraPitch += y;

				// sanity checks:
				this.orbitCameraYaw = this.orbitCameraYaw & 0x7FFF;
				if (this.orbitCameraPitch < 128) {
					this.orbitCameraPitch = 128;
				}
				if (this.orbitCameraPitch > 383) {
					this.orbitCameraPitch = 383;
				}
			}
		}
	}
}
