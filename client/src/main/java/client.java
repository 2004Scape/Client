import jagex2.client.*;
import jagex2.config.*;
import jagex2.dash3d.CollisionMap;
import jagex2.dash3d.World;
import jagex2.dash3d.World3D;
import jagex2.dash3d.entity.*;
import jagex2.dash3d.type.LocSpawned;
import jagex2.dash3d.type.LocTemporary;
import jagex2.datastruct.JString;
import jagex2.datastruct.LinkList;
import jagex2.graphics.*;
import jagex2.io.*;
import jagex2.sound.Wave;
import jagex2.wordenc.WordFilter;
import jagex2.wordenc.WordPack;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

@OriginalClass("client!client")
public class client extends GameShell {

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
	private int packetType;

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
	public static int drawCounter;

	@OriginalMember(owner = "client!client", name = "ic", descriptor = "I")
	public static int opHeld4Counter;

	@OriginalMember(owner = "client!client", name = "jc", descriptor = "[I")
	private final int[] skillLevel = new int[50];

	@OriginalMember(owner = "client!client", name = "kc", descriptor = "Lclient!hc;")
	private final ComType chatInterface = new ComType();

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
	private int lastPacketType0;

	@OriginalMember(owner = "client!client", name = "Fc", descriptor = "I")
	private int lastPacketType1;

	@OriginalMember(owner = "client!client", name = "Gc", descriptor = "I")
	private int lastPacketType2;

	@OriginalMember(owner = "client!client", name = "Hc", descriptor = "Lclient!r;")
	private World3D scene;

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
	private byte[][][] levelTileFlags;

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
	public static int sidebarInputCounter;

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
	private int viewportInterfaceID = -1;

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
	private final int SCROLLBAR_GRIP_LOWLIGHT = 0x332d25;

	@OriginalMember(owner = "client!client", name = "Cf", descriptor = "Lclient!ib;")
	private Pix8 imageInvback;

	@OriginalMember(owner = "client!client", name = "Df", descriptor = "Lclient!ib;")
	private Pix8 imageMapback;

	@OriginalMember(owner = "client!client", name = "Ef", descriptor = "Lclient!ib;")
	private Pix8 imageChatback;

	@OriginalMember(owner = "client!client", name = "Ff", descriptor = "I")
	private int inMultizone;

	@OriginalMember(owner = "client!client", name = "Gf", descriptor = "Lclient!jb;")
	private PixFont fontPlain11;

	@OriginalMember(owner = "client!client", name = "Hf", descriptor = "Lclient!jb;")
	private PixFont fontPlain12;

	@OriginalMember(owner = "client!client", name = "If", descriptor = "Lclient!jb;")
	private PixFont fontBold12;

	@OriginalMember(owner = "client!client", name = "Jf", descriptor = "Lclient!jb;")
	private PixFont fontQuill8;

	@OriginalMember(owner = "client!client", name = "Kf", descriptor = "I")
	private int tryMoveNearest;

	@OriginalMember(owner = "client!client", name = "Mf", descriptor = "[I")
	private int[] flameBuffer3;

	@OriginalMember(owner = "client!client", name = "Nf", descriptor = "[I")
	private int[] flameBuffer2;

	@OriginalMember(owner = "client!client", name = "Of", descriptor = "I")
	private final int SCROLLBAR_GRIP_HIGHLIGHT = 0x766654;

	@OriginalMember(owner = "client!client", name = "Pf", descriptor = "[I")
	private int[] bfsStepX = new int[4000];

	@OriginalMember(owner = "client!client", name = "Qf", descriptor = "[I")
	private int[] bfsStepZ = new int[4000];

	@OriginalMember(owner = "client!client", name = "Rf", descriptor = "Ljava/util/zip/CRC32;")
	private final CRC32 crc32 = new CRC32();

	@OriginalMember(owner = "client!client", name = "Sf", descriptor = "Lclient!hb;")
	private Pix24 imageMapflag;

	@OriginalMember(owner = "client!client", name = "Tf", descriptor = "I")
	public static int updateCounter;

	@OriginalMember(owner = "client!client", name = "Uf", descriptor = "Lclient!d;")
	private ClientStream stream;

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
	private final int SCROLLBAR_TRACK = 0x23201b;

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
	public static int updateLocCounter;

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
	private int[] menuParamB = new int[500];

	@OriginalMember(owner = "client!client", name = "Fi", descriptor = "[I")
	private int[] menuParamC = new int[500];

	@OriginalMember(owner = "client!client", name = "Gi", descriptor = "[I")
	private int[] menuAction = new int[500];

	@OriginalMember(owner = "client!client", name = "Hi", descriptor = "[I")
	private int[] menuParamA = new int[500];

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
	private final int SCROLLBAR_GRIP_FOREGROUND = 0x4d4233;

	@OriginalMember(owner = "client!client", name = "Yi", descriptor = "[I")
	private final int[] cameraModifierWobbleSpeed = new int[5];

	static {
		@Pc(6) int acc = 0;
		for (@Pc(8) int i = 0; i < 99; i++) {
			@Pc(13) int level = i + 1;
			@Pc(26) int delta = (int) ((double) level + Math.pow(2.0D, (double) level / 7.0D) * 300.0D);
			acc += delta;
			levelExperience[i] = acc / 4;
		}
	}

	@OriginalMember(owner = "client!client", name = "main", descriptor = "([Ljava/lang/String;)V")
	public static void main(@OriginalArg(0) String[] args) {
		try {
			System.out.println("RS2 user client - release #" + signlink.clientversion);

            if (args.length > 0) {
                nodeId = Integer.parseInt(args[0]);
            } else {
                nodeId = 10;
            }

            if (args.length > 1) {
                portOffset = Integer.parseInt(args[1]);
            } else {
                portOffset = 0;
            }

            if (args.length > 2 && args[2].equals("lowmem")) {
                setLowMemory();
            } else {
                setHighMemory();
            }

            if (args.length > 3 && args[3].equals("free")) {
                members = false;
            } else {
                members = true;
            }

			String vendor = System.getProperties().getProperty("java.vendor");
			if (vendor.toLowerCase().indexOf("sun") != -1 || vendor.toLowerCase().indexOf("apple") != -1) {
				signlink.sunjava = true;
			}

            signlink.startpriv(InetAddress.getByName("w1.225.2004scape.org"));

            @Pc(82) client c = new client();
            c.initApplication(532, 789);
		} catch (@Pc(89) Exception _ex) {
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
	public static String formatObjCountTagged(@OriginalArg(0) int amount) {
		@Pc(4) String s = String.valueOf(amount);
		for (@Pc(9) int i = s.length() - 3; i > 0; i -= 3) {
			s = s.substring(0, i) + "," + s.substring(i);
		}
		if (s.length() > 8) {
			s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
		} else if (s.length() > 4) {
			s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
		}
		return " " + s;
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IZI)Ljava/lang/String;")
	public static String getCombatLevelColorTag(@OriginalArg(0) int viewerLevel, @OriginalArg(2) int otherLevel) {
		@Pc(9) int diff = viewerLevel - otherLevel;
		if (diff < -9) {
			return "@red@";
		} else if (diff < -6) {
			return "@or3@";
		} else if (diff < -3) {
			return "@or2@";
		} else if (diff < 0) {
			return "@or1@";
		} else if (diff > 9) {
			return "@gre@";
		} else if (diff > 6) {
			return "@gr3@";
		} else if (diff > 3) {
			return "@gr2@";
		} else if (diff > 0) {
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
	public static String formatObjCount(@OriginalArg(1) int amount) {
		if (amount < 100000) {
			return String.valueOf(amount);
		} else if (amount < 10000000) {
			return amount / 1000 + "K";
		} else {
			return amount / 1000000 + "M";
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILjava/lang/String;I)V")
	private void setMidi(@OriginalArg(1) int crc, @OriginalArg(2) String name, @OriginalArg(3) int len) {
		synchronized (this.midiSync) {
			this.midiSyncName = name;
			this.midiSyncCrc = crc;
			this.midiSyncLen = len;
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(I)V")
	private void draw2DEntityElements() {
		this.chatCount = 0;

		for (@Pc(15) int index = -1; index < this.playerCount + this.npcCount; index++) {
			@Pc(23) PathingEntity entity;
			if (index == -1) {
				entity = this.localPlayer;
			} else if (index < this.playerCount) {
				entity = this.players[this.playerIds[index]];
			} else {
				entity = this.npcs[this.npcIds[index - this.playerCount]];
			}

			if (entity != null && entity.isVisible()) {
				if (index < this.playerCount) {
					int y = 30;
					@Pc(66) PlayerEntity player = (PlayerEntity) entity;
					if (player.headicons != 0) {
						this.projectFromGround(entity.height + 15, entity);
						if (this.projectX > -1) {
							for (int icon = 0; icon < 8; icon++) {
								if ((player.headicons & 0x1 << icon) != 0) {
									this.imageHeadicons[icon].draw(this.projectY - y, this.projectX - 12);
									y -= 25;
								}
							}
						}
					}
					if (index >= 0 && this.hintType == 10 && this.hintPlayer == this.playerIds[index]) {
						this.projectFromGround(entity.height + 15, entity);
						if (this.projectX > -1) {
							this.imageHeadicons[7].draw(this.projectY - y, this.projectX - 12);
						}
					}
				} else if (this.hintType == 1 && this.hintNpc == this.npcIds[index - this.playerCount] && loopCycle % 20 < 10) {
					this.projectFromGround(entity.height + 15, entity);
					if (this.projectX > -1) {
						this.imageHeadicons[2].draw(this.projectY - 28, this.projectX - 12);
					}
				}
				if (entity.chat != null && (index >= this.playerCount || this.publicChatSetting == 0 || this.publicChatSetting == 3 || this.publicChatSetting == 1 && this.isFriend(((PlayerEntity) entity).name))) {
					this.projectFromGround(entity.height, entity);
					if (this.projectX > -1 && this.chatCount < this.MAX_CHATS) {
						this.chatWidth[this.chatCount] = this.fontBold12.stringWidth(entity.chat) / 2;
						this.chatHeight[this.chatCount] = this.fontBold12.height;
						this.chatX[this.chatCount] = this.projectX;
						this.chatY[this.chatCount] = this.projectY;
						this.chatColors[this.chatCount] = entity.chatColor;
						this.chatStyles[this.chatCount] = entity.chatStyle;
						this.chatTimers[this.chatCount] = entity.chatTimer;
						this.chats[this.chatCount++] = entity.chat;
						if (this.chatEffects == 0 && entity.chatStyle == 1) {
							this.chatHeight[this.chatCount] += 10;
							this.chatY[this.chatCount] += 5;
						}
						if (this.chatEffects == 0 && entity.chatStyle == 2) {
							this.chatWidth[this.chatCount] = 60;
						}
					}
				}
				if (entity.combatCycle > loopCycle + 100) {
					this.projectFromGround(entity.height + 15, entity);
					if (this.projectX > -1) {
						int w = entity.health * 30 / entity.totalHealth;
						if (w > 30) {
							w = 30;
						}
						Draw2D.fillRect(this.projectY - 3, this.projectX - 15, 0xff00, w, 5);
						Draw2D.fillRect(this.projectY - 3, this.projectX - 15 + w, 0xff0000, 30 - w, 5);
					}
				}
				if (entity.combatCycle > loopCycle + 330) {
					this.projectFromGround(entity.height / 2, entity);
					if (this.projectX > -1) {
						this.imageHitmarks[entity.damageType].draw(this.projectY - 12, this.projectX - 12);
						this.fontPlain11.drawStringCenter(this.projectY + 4, 0, String.valueOf(entity.damage), this.projectX);
						this.fontPlain11.drawStringCenter(this.projectY + 3, 0xffffff, String.valueOf(entity.damage), this.projectX - 1);
					}
				}
			}
		}

		for (@Pc(483) int i = 0; i < this.chatCount; i++) {
			int x = this.chatX[i];
			@Pc(495) int y = this.chatY[i];
			int padding = this.chatWidth[i];
			@Pc(505) int height = this.chatHeight[i];
			@Pc(507) boolean sorting = true;
			while (sorting) {
				sorting = false;
				for (@Pc(513) int j = 0; j < i; j++) {
					if (y + 2 > this.chatY[j] - this.chatHeight[j] && y - height < this.chatY[j] + 2 && x - padding < this.chatX[j] + this.chatWidth[j] && x + padding > this.chatX[j] - this.chatWidth[j] && this.chatY[j] - this.chatHeight[j] < y) {
						y = this.chatY[j] - this.chatHeight[j];
						sorting = true;
					}
				}
			}
			this.projectX = this.chatX[i];
			this.projectY = this.chatY[i] = y;
			@Pc(612) String message = this.chats[i];
			if (this.chatEffects == 0) {
				@Pc(617) int color = 0xffff00;
				if (this.chatColors[i] < 6) {
					color = this.CHAT_COLORS[this.chatColors[i]];
				}
				if (this.chatColors[i] == 6) {
					color = this.sceneCycle % 20 < 10 ? 0xff0000 : 0xffff00;
				}
				if (this.chatColors[i] == 7) {
					color = this.sceneCycle % 20 < 10 ? 0xff : 0xffff;
				}
				if (this.chatColors[i] == 8) {
					color = this.sceneCycle % 20 < 10 ? 0xb000 : 0x80ff80;
				}
				if (this.chatColors[i] == 9) {
					int delta = 150 - this.chatTimers[i];
					if (delta < 50) {
						color = delta * 1280 + 0xff0000;
					} else if (delta < 100) {
						color = 0xffff00 - (delta - 50) * 327680;
					} else if (delta < 150) {
						color = (delta - 100) * 5 + 65280;
					}
				}
				if (this.chatColors[i] == 10) {
					int delta = 150 - this.chatTimers[i];
					if (delta < 50) {
						color = delta * 5 + 0xff0000;
					} else if (delta < 100) {
						color = 0xff00ff - (delta - 50) * 327680;
					} else if (delta < 150) {
						color = (delta - 100) * 327680 + 255 - (delta - 100) * 5;
					}
				}
				if (this.chatColors[i] == 11) {
					int delta = 150 - this.chatTimers[i];
					if (delta < 50) {
						color = 16777215 - delta * 327685;
					} else if (delta < 100) {
						color = (delta - 50) * 327685 + 65280;
					} else if (delta < 150) {
						color = 16777215 - (delta - 100) * 327680;
					}
				}
				if (this.chatStyles[i] == 0) {
					this.fontBold12.drawStringCenter(this.projectY + 1, 0, message, this.projectX);
					this.fontBold12.drawStringCenter(this.projectY, color, message, this.projectX);
				}
				if (this.chatStyles[i] == 1) {
					this.fontBold12.drawCenteredWave(this.sceneCycle, this.projectX, this.projectY + 1, 0, message);
					this.fontBold12.drawCenteredWave(this.sceneCycle, this.projectX, this.projectY, color, message);
				}
				if (this.chatStyles[i] == 2) {
					int w = this.fontBold12.stringWidth(message);
					@Pc(913) int offsetX = (150 - this.chatTimers[i]) * (w + 100) / 150;
					Draw2D.setBounds(334, 0, this.projectX + 50, this.projectX - 50);
					this.fontBold12.drawString(this.projectX + 50 - offsetX, this.projectY + 1, 0, message);
					this.fontBold12.drawString(this.projectX + 50 - offsetX, this.projectY, color, message);
					Draw2D.resetBounds();
				}
			} else {
				this.fontBold12.drawStringCenter(this.projectY + 1, 0, message, this.projectX);
				this.fontBold12.drawStringCenter(this.projectY, 16776960, message, this.projectX);
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
		this.viewportInterfaceID = -1;
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(I)V")
	private void stopMidi() {
		signlink.midifade = 0;
		signlink.midi = "stop";
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(I)V")
	private void drawWildyLevel() {
		@Pc(10) int x = (this.localPlayer.x >> 7) + this.sceneBaseTileX;
		@Pc(19) int z = (this.localPlayer.z >> 7) + this.sceneBaseTileZ;
		if (x >= 2944 && x < 3392 && z >= 3520 && z < 6400) {
			this.wildernessLevel = (z - 3520) / 8 + 1;
		} else if (x >= 2944 && x < 3392 && z >= 9920 && z < 12800) {
			this.wildernessLevel = (z - 9920) / 8 + 1;
		} else {
			this.wildernessLevel = 0;
		}
		this.worldLocationState = 0;
		if (x >= 3328 && x < 3392 && z >= 3200 && z < 3264) {
			@Pc(98) int localX = x & 63;
			@Pc(102) int localZ = z & 63;
			if (localX >= 4 && localX <= 29 && localZ >= 44 && localZ <= 58) {
				this.worldLocationState = 1;
			}
			if (localX >= 36 && localX <= 61 && localZ >= 44 && localZ <= 58) {
				this.worldLocationState = 1;
			}
			if (localX >= 4 && localX <= 29 && localZ >= 25 && localZ <= 39) {
				this.worldLocationState = 1;
			}
			if (localX >= 36 && localX <= 61 && localZ >= 25 && localZ <= 39) {
				this.worldLocationState = 1;
			}
			if (localX >= 4 && localX <= 29 && localZ >= 6 && localZ <= 20) {
				this.worldLocationState = 1;
			}
			if (localX >= 36 && localX <= 61 && localZ >= 6 && localZ <= 20) {
				this.worldLocationState = 1;
			}
		}
		if (this.worldLocationState == 0 && x >= 3328 && x <= 3393 && z >= 3203 && z <= 3325) {
			this.worldLocationState = 2;
		}
		this.overrideChat = 0;
		if (x >= 3053 && x <= 3156 && z >= 3056 && z <= 3136) {
			this.overrideChat = 1;
		}
		if (x >= 3072 && x <= 3118 && z >= 9492 && z <= 9535) {
			this.overrideChat = 1;
		}
		if (this.overrideChat == 1 && x >= 3139 && x <= 3199 && z >= 3008 && z <= 3062) {
			this.overrideChat = 0;
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(I)V")
	private void drawPrivateMessages() {
		if (this.splitPrivateChat != 0) {
			@Pc(9) PixFont font = this.fontPlain12;
			@Pc(11) int lineOffset = 0;
			if (this.systemUpdateTimer != 0) {
				lineOffset = 1;
			}
			for (@Pc(18) int i = 0; i < 100; i++) {
				if (this.messageText[i] != null) {
					@Pc(30) int type = this.messageType[i];
					@Pc(60) int y;
					if ((type == 3 || type == 7) && (type == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
						y = 329 - lineOffset * 13;
						font.drawString(4, y, 0, "From " + this.messageSender[i] + ": " + this.messageText[i]);
						font.drawString(4, y - 1, 65535, "From " + this.messageSender[i] + ": " + this.messageText[i]);
						lineOffset++;
						if (lineOffset >= 5) {
							return;
						}
					}
					if (type == 5 && this.privateChatSetting < 2) {
						y = 329 - lineOffset * 13;
						font.drawString(4, y, 0, this.messageText[i]);
						font.drawString(4, y - 1, 65535, this.messageText[i]);
						lineOffset++;
						if (lineOffset >= 5) {
							return;
						}
					}
					if (type == 6 && this.privateChatSetting < 2) {
						y = 329 - lineOffset * 13;
						font.drawString(4, y, 0, "To " + this.messageSender[i] + ": " + this.messageText[i]);
						font.drawString(4, y - 1, 65535, "To " + this.messageSender[i] + ": " + this.messageText[i]);
						lineOffset++;
						if (lineOffset >= 5) {
							return;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!kb;II)V")
	private void readNpcUpdates(@OriginalArg(0) Packet buf, @OriginalArg(1) int size) {
		for (@Pc(1) int i = 0; i < this.entityUpdateCount; i++) {
			@Pc(8) int id = this.entityUpdateIds[i];
			@Pc(13) NpcEntity npc = this.npcs[id];
			@Pc(16) int mask = buf.g1();

			if ((mask & 0x2) == 2) {
				int seqId = buf.g2();
				if (seqId == 65535) {
					seqId = -1;
				}
				if (seqId == npc.primarySeqId) {
					npc.primarySeqLoop = 0;
				}
				@Pc(39) int delay = buf.g1();
				if (seqId == -1 || npc.primarySeqId == -1 || SeqType.instances[seqId].priority > SeqType.instances[npc.primarySeqId].priority || SeqType.instances[npc.primarySeqId].priority == 0) {
					npc.primarySeqId = seqId;
					npc.primarySeqFrame = 0;
					npc.primarySeqCycle = 0;
					npc.primarySeqDelay = delay;
					npc.primarySeqLoop = 0;
				}
			}
			if ((mask & 0x4) == 4) {
				npc.targetId = buf.g2();
				if (npc.targetId == 65535) {
					npc.targetId = -1;
				}
			}
			if ((mask & 0x8) == 8) {
				npc.chat = buf.gjstr();
				npc.chatTimer = 100;
			}
			if ((mask & 0x10) == 16) {
				npc.damage = buf.g1();
				npc.damageType = buf.g1();
				npc.combatCycle = loopCycle + 400;
				npc.health = buf.g1();
				npc.totalHealth = buf.g1();
			}
			if ((mask & 0x20) == 32) {
				npc.type = NpcType.get(buf.g2());
				npc.seqWalkId = npc.type.walkanim;
				npc.seqTurnAroundId = npc.type.walkanim_b;
				npc.seqTurnLeftId = npc.type.walkanim_r;
				npc.seqTurnRightId = npc.type.walkanim_l;
				npc.seqStandId = npc.type.readyanim;
			}
			if ((mask & 0x40) == 64) {
				npc.spotanimId = buf.g2();
				int info = buf.g4();
				npc.spotanimOffset = info >> 16;
				npc.spotanimLastCycle = loopCycle + (info & 0xFFFF);
				npc.spotanimFrame = 0;
				npc.spotanimCycle = 0;
				if (npc.spotanimLastCycle > loopCycle) {
					npc.spotanimFrame = -1;
				}
				if (npc.spotanimId == 65535) {
					npc.spotanimId = -1;
				}
			}
			if ((mask & 0x80) == 128) {
				npc.targetTileX = buf.g2();
				npc.targetTileZ = buf.g2();
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(JB)V")
	private void addIgnore(@OriginalArg(0) long username) {
		if (username != 0L) {
			if (this.ignoreCount >= 100) {
				this.addMessage(0, "Your ignore list is full. Max of 100 hit", "");
			} else {
				@Pc(23) String displayName = JString.formatName(JString.fromBase37(username));
				for (@Pc(25) int i = 0; i < this.ignoreCount; i++) {
					if (this.ignoreName37[i] == username) {
						this.addMessage(0, displayName + " is already on your ignore list", "");
						return;
					}
				}
				for (@Pc(55) int i = 0; i < this.friendCount; i++) {
					if (this.friendName37[i] == username) {
						this.addMessage(0, "Please remove " + displayName + " from your friend list first", "");
						return;
					}
				}
				this.ignoreName37[this.ignoreCount++] = username;
				this.redrawSidebar = true;
				this.out.p1isaac(79);
				this.out.p8(username);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(BLclient!kb;I)V")
	private void readZonePacket(@OriginalArg(1) Packet buf, @OriginalArg(2) int opcode) {
		int pos = buf.g1();
		int x = this.baseX + (pos >> 4 & 0x7);
		int z = this.baseZ + (pos & 0x7);

		if (opcode == 59 || opcode == 76) {
			// LOC_ADD_CHANGE || LOC_DEL
			int info = buf.g1();
			int shape = info >> 2;
			int angle = info & 0x3;
			int layer = this.LOC_KIND_TO_CLASS_ID[shape];
			int id;
			if (opcode == 76) {
				id = -1;
			} else {
				id = buf.g2();
			}
			if (x >= 0 && z >= 0 && x < 104 && z < 104) {
				@Pc(69) LocTemporary loc = null;
				for (@Pc(74) LocTemporary next = (LocTemporary) this.spawnedLocations.peekFront(); next != null; next = (LocTemporary) this.spawnedLocations.prev()) {
					if (next.plane == this.currentLevel && next.x == x && next.z == z && next.classType == layer) {
						loc = next;
						break;
					}
				}
				if (loc == null) {
					int bitset = 0;
					int otherId = -1;
					int otherKind = 0;
					@Pc(114) int otherRotation = 0;
					if (layer == 0) {
						bitset = this.scene.getWallBitset(this.currentLevel, x, z);
					}
					if (layer == 1) {
						bitset = this.scene.getWallDecorationBitset(this.currentLevel, z, x);
					}
					if (layer == 2) {
						bitset = this.scene.getLocBitset(this.currentLevel, x, z);
					}
					if (layer == 3) {
						bitset = this.scene.getGroundDecorationBitset(this.currentLevel, x, z);
					}
					if (bitset != 0) {
						@Pc(169) int otherInfo = this.scene.getInfo(this.currentLevel, x, z, bitset);
						otherId = bitset >> 14 & 0x7FFF;
						otherKind = otherInfo & 0x1F;
						otherRotation = otherInfo >> 6;
					}
					loc = new LocTemporary();
					loc.plane = this.currentLevel;
					loc.classType = layer;
					loc.x = x;
					loc.z = z;
					loc.lastLocIndex = otherId;
					loc.lastType = otherKind;
					loc.lastOrientation = otherRotation;
					this.spawnedLocations.pushBack(loc);
				}
				loc.locIndex = id;
				loc.type = shape;
				loc.orientation = angle;
				this.addLoc(angle, x, z, layer, id, shape, this.currentLevel);
			}
		} else if (opcode == 42) {
			// LOC_ANIM
			int info = buf.g1();
			int shape = info >> 2;
			int layer = this.LOC_KIND_TO_CLASS_ID[shape];
			int id = buf.g2();
			if (x >= 0 && z >= 0 && x < 104 && z < 104) {
				int bitset = 0;
				if (layer == 0) {
					bitset = this.scene.getWallBitset(this.currentLevel, x, z);
				}
				if (layer == 1) {
					bitset = this.scene.getWallDecorationBitset(this.currentLevel, z, x);
				}
				if (layer == 2) {
					bitset = this.scene.getLocBitset(this.currentLevel, x, z);
				}
				if (layer == 3) {
					bitset = this.scene.getGroundDecorationBitset(this.currentLevel, x, z);
				}
				if (bitset != 0) {
					@Pc(348) LocEntity loc = new LocEntity(false, bitset >> 14 & 0x7FFF, this.currentLevel, layer, SeqType.instances[id], z, x);
					this.locList.pushBack(loc);
				}
			}
		} else if (opcode == 223) {
			// OBJ_ADD
			int id = buf.g2();
			int count = buf.g2();
			if (x >= 0 && z >= 0 && x < 104 && z < 104) {
				ObjStackEntity obj = new ObjStackEntity();
				obj.index = id;
				obj.count = count;
				if (this.levelObjStacks[this.currentLevel][x][z] == null) {
					this.levelObjStacks[this.currentLevel][x][z] = new LinkList();
				}
				this.levelObjStacks[this.currentLevel][x][z].pushBack(obj);
				this.sortObjStacks(x, z);
			}
		} else if (opcode == 49) {
			// OBJ_DEL
			int id = buf.g2();
			if (x >= 0 && z >= 0 && x < 104 && z < 104) {
				@Pc(485) LinkList list = this.levelObjStacks[this.currentLevel][x][z];
				if (list != null) {
					for (ObjStackEntity next = (ObjStackEntity) list.peekFront(); next != null; next = (ObjStackEntity) list.prev()) {
						if (next.index == (id & 0x7FFF)) {
							next.unlink();
							break;
						}
					}
					if (list.peekFront() == null) {
						this.levelObjStacks[this.currentLevel][x][z] = null;
					}
					this.sortObjStacks(x, z);
				}
			}
		} else if (opcode == 69) {
			// MAP_PROJANIM
			int dx = x + buf.g1b();
			int dz = z + buf.g1b();
			int target = buf.g2b();
			int spotanim = buf.g2();
			int srcHeight = buf.g1();
			int dstHeight = buf.g1();
			int startDelay = buf.g2();
			int endDelay = buf.g2();
			int peak = buf.g1();
			int arc = buf.g1();
			if (x >= 0 && z >= 0 && x < 104 && z < 104 && dx >= 0 && dz >= 0 && dx < 104 && dz < 104) {
				x = x * 128 + 64;
				z = z * 128 + 64;
				dx = dx * 128 + 64;
				dz = dz * 128 + 64;
				@Pc(657) ProjectileEntity proj = new ProjectileEntity(dstHeight, peak, z, endDelay + loopCycle, this.currentLevel, target, startDelay + loopCycle, arc, this.getHeightmapY(this.currentLevel, x, z) - srcHeight, spotanim, x);
				proj.updateVelocity(this.getHeightmapY(this.currentLevel, dx, dz) - dstHeight, dz, dx, startDelay + loopCycle);
				this.projectiles.pushBack(proj);
			}
		} else if (opcode == 191) {
			// MAP_ANIM
			int id = buf.g2();
			int height = buf.g1();
			int delay = buf.g2();
			if (x >= 0 && z >= 0 && x < 104 && z < 104) {
				x = x * 128 + 64;
				z = z * 128 + 64;
				@Pc(753) SpotAnimEntity spotanim = new SpotAnimEntity(x, id, z, delay, this.getHeightmapY(this.currentLevel, x, z) - height, this.currentLevel, loopCycle);
				this.spotanims.pushBack(spotanim);
			}
		} else if (opcode == 50) {
			// OBJ_REVEAL
			int id = buf.g2();
			int count = buf.g2();
			int receiver = buf.g2();
			if (x >= 0 && z >= 0 && x < 104 && z < 104 && receiver != this.localPid) {
				@Pc(807) ObjStackEntity obj = new ObjStackEntity();
				obj.index = id;
				obj.count = count;
				if (this.levelObjStacks[this.currentLevel][x][z] == null) {
					this.levelObjStacks[this.currentLevel][x][z] = new LinkList();
				}
				this.levelObjStacks[this.currentLevel][x][z].pushBack(obj);
				this.sortObjStacks(x, z);
			}
		} else if (opcode == 23) {
			// LOC_MERGE
			int info = buf.g1();
			int shape = info >> 2;
			int rotation = info & 0x3;
			int layer = this.LOC_KIND_TO_CLASS_ID[shape];
			int id = buf.g2();
			int start = buf.g2();
			int end = buf.g2();
			int pid = buf.g2();
			@Pc(905) byte east = buf.g1b();
			@Pc(908) byte south = buf.g1b();
			@Pc(911) byte west = buf.g1b();
			@Pc(914) byte north = buf.g1b();
			@Pc(921) PlayerEntity player;
			if (pid == this.localPid) {
				player = this.localPlayer;
			} else {
				player = this.players[pid];
			}
			if (player != null) {
				@Pc(946) LocSpawned loc1 = new LocSpawned(this.currentLevel, rotation, z, start + loopCycle, shape, -1, x, layer);
				this.temporaryLocs.pushBack(loc1);
				@Pc(966) LocSpawned loc2 = new LocSpawned(this.currentLevel, rotation, z, end + loopCycle, shape, id, x, layer);
				this.temporaryLocs.pushBack(loc2);
				@Pc(980) int y0 = this.levelHeightmap[this.currentLevel][x][z];
				@Pc(992) int y1 = this.levelHeightmap[this.currentLevel][x + 1][z];
				@Pc(1006) int y2 = this.levelHeightmap[this.currentLevel][x + 1][z + 1];
				@Pc(1018) int y3 = this.levelHeightmap[this.currentLevel][x][z + 1];
				@Pc(1021) LocType loc = LocType.get(id);
				player.locStartCycle = start + loopCycle;
				player.locStopCycle = end + loopCycle;
				player.locModel = loc.getModel(shape, rotation, y0, y1, y2, y3, -1);
				@Pc(1045) int width = loc.width;
				@Pc(1048) int height = loc.length;
				if (rotation == 1 || rotation == 3) {
					width = loc.length;
					height = loc.width;
				}
				player.locOffsetX = x * 128 + width * 64;
				player.locOffsetZ = z * 128 + height * 64;
				player.locOffsetY = this.getHeightmapY(this.currentLevel, player.locOffsetX, player.locOffsetZ);
				@Pc(1094) byte tmp;
				if (east > west) {
					tmp = east;
					east = west;
					west = tmp;
				}
				if (south > north) {
					tmp = south;
					south = north;
					north = tmp;
				}
				player.minTileX = x + east;
				player.maxTileX = x + west;
				player.minTileZ = z + south;
				player.maxTileZ = z + north;
			}
		} else if (opcode == 151) {
			// OBJ_COUNT
			int id = buf.g2();
			int oldCount = buf.g2();
			int newCount = buf.g2();
			if (x >= 0 && z >= 0 && x < 104 && z < 104) {
				@Pc(1178) LinkList list = this.levelObjStacks[this.currentLevel][x][z];
				if (list != null) {
					for (@Pc(1184) ObjStackEntity next = (ObjStackEntity) list.peekFront(); next != null; next = (ObjStackEntity) list.prev()) {
						if (next.index == (id & 0x7FFF) && next.count == oldCount) {
							next.count = newCount;
							break;
						}
					}
					this.sortObjStacks(x, z);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(B)I")
	private int getTopLevel() {
		@Pc(11) int top = 3;
		if (this.cameraPitch < 310) {
			@Pc(20) int cameraLocalTileX = this.cameraX >> 7;
			@Pc(25) int cameraLocalTileZ = this.cameraZ >> 7;
			@Pc(31) int playerLocalTileX = this.localPlayer.x >> 7;
			@Pc(37) int playerLocalTileZ = this.localPlayer.z >> 7;
			if ((this.levelTileFlags[this.currentLevel][cameraLocalTileX][cameraLocalTileZ] & 0x4) != 0) {
				top = this.currentLevel;
			}
			@Pc(59) int tileDeltaX;
			if (playerLocalTileX > cameraLocalTileX) {
				tileDeltaX = playerLocalTileX - cameraLocalTileX;
			} else {
				tileDeltaX = cameraLocalTileX - playerLocalTileX;
			}
			@Pc(72) int tileDeltaZ;
			if (playerLocalTileZ > cameraLocalTileZ) {
				tileDeltaZ = playerLocalTileZ - cameraLocalTileZ;
			} else {
				tileDeltaZ = cameraLocalTileZ - playerLocalTileZ;
			}
			@Pc(87) int delta;
			@Pc(89) int accumulator;
			if (tileDeltaX > tileDeltaZ) {
				delta = tileDeltaZ * 65536 / tileDeltaX;
				accumulator = 32768;
				while (cameraLocalTileX != playerLocalTileX) {
					if (cameraLocalTileX < playerLocalTileX) {
						cameraLocalTileX++;
					} else if (cameraLocalTileX > playerLocalTileX) {
						cameraLocalTileX--;
					}
					if ((this.levelTileFlags[this.currentLevel][cameraLocalTileX][cameraLocalTileZ] & 0x4) != 0) {
						top = this.currentLevel;
					}
					accumulator += delta;
					if (accumulator >= 65536) {
						accumulator -= 65536;
						if (cameraLocalTileZ < playerLocalTileZ) {
							cameraLocalTileZ++;
						} else if (cameraLocalTileZ > playerLocalTileZ) {
							cameraLocalTileZ--;
						}
						if ((this.levelTileFlags[this.currentLevel][cameraLocalTileX][cameraLocalTileZ] & 0x4) != 0) {
							top = this.currentLevel;
						}
					}
				}
			} else {
				delta = tileDeltaX * 65536 / tileDeltaZ;
				accumulator = 32768;
				while (cameraLocalTileZ != playerLocalTileZ) {
					if (cameraLocalTileZ < playerLocalTileZ) {
						cameraLocalTileZ++;
					} else if (cameraLocalTileZ > playerLocalTileZ) {
						cameraLocalTileZ--;
					}
					if ((this.levelTileFlags[this.currentLevel][cameraLocalTileX][cameraLocalTileZ] & 0x4) != 0) {
						top = this.currentLevel;
					}
					accumulator += delta;
					if (accumulator >= 65536) {
						accumulator -= 65536;
						if (cameraLocalTileX < playerLocalTileX) {
							cameraLocalTileX++;
						} else if (cameraLocalTileX > playerLocalTileX) {
							cameraLocalTileX--;
						}
						if ((this.levelTileFlags[this.currentLevel][cameraLocalTileX][cameraLocalTileZ] & 0x4) != 0) {
							top = this.currentLevel;
						}
					}
				}
			}
		}
		if ((this.levelTileFlags[this.currentLevel][this.localPlayer.x >> 7][this.localPlayer.z >> 7] & 0x4) != 0) {
			top = this.currentLevel;
		}
		return top;
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(I)I")
	private int getTopLevelCutscene() {
		@Pc(9) int y = this.getHeightmapY(this.currentLevel, this.cameraX, this.cameraZ);
		return y - this.cameraY >= 800 || (this.levelTileFlags[this.currentLevel][this.cameraX >> 7][this.cameraZ >> 7] & 0x4) == 0 ? 3 : this.currentLevel;
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(I)V")
	private void drawScene() {
		this.sceneCycle++;
		this.pushPlayers();
		this.pushNpcs();
		this.pushProjectiles();
		this.pushSpotanims();
		this.pushLocs();

		if (!this.cutscene) {
			int pitch = this.orbitCameraPitch;
			if (this.cameraPitchClamp / 256 > pitch) {
				pitch = this.cameraPitchClamp / 256;
			}
			if (this.cameraModifierEnabled[4] && this.cameraModifierWobbleScale[4] + 128 > pitch) {
				pitch = this.cameraModifierWobbleScale[4] + 128;
			}
			int yaw = this.orbitCameraYaw + this.cameraAnticheatAngle & 0x7FF;
			this.orbitCamera(this.getHeightmapY(this.currentLevel, this.localPlayer.x, this.localPlayer.z) - 50, this.orbitCameraX, yaw, pitch, this.orbitCameraZ, pitch * 3 + 600);
			drawCounter++;
			if (drawCounter > 1802) {
				drawCounter = 0;
				this.out.p1isaac(146);
				this.out.p1(0);
				int start = this.out.pos;
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
				this.out.psize1(this.out.pos - start);
			}
		}
		int level;
		if (this.cutscene) {
			level = this.getTopLevelCutscene();
		} else {
			level = this.getTopLevel();
		}
		int cameraX = this.cameraX;
		int cameraY = this.cameraY;
		@Pc(209) int cameraZ = this.cameraZ;
		@Pc(212) int cameraPitch = this.cameraPitch;
		@Pc(215) int cameraYaw = this.cameraYaw;
		@Pc(264) int jitter;
		for (@Pc(217) int type = 0; type < 5; type++) {
			if (this.cameraModifierEnabled[type]) {
				jitter = (int) (Math.random() * (double) (this.cameraModifierJitter[type] * 2 + 1) - (double) this.cameraModifierJitter[type] + Math.sin((double) this.cameraModifierCycle[type] * ((double) this.cameraModifierWobbleSpeed[type] / 100.0D)) * (double) this.cameraModifierWobbleScale[type]);
				if (type == 0) {
					this.cameraX += jitter;
				}
				if (type == 1) {
					this.cameraY += jitter;
				}
				if (type == 2) {
					this.cameraZ += jitter;
				}
				if (type == 3) {
					this.cameraYaw = this.cameraYaw + jitter & 0x7FF;
				}
				if (type == 4) {
					this.cameraPitch += jitter;
					if (this.cameraPitch < 128) {
						this.cameraPitch = 128;
					}
					if (this.cameraPitch > 383) {
						this.cameraPitch = 383;
					}
				}
			}
		}
		jitter = Draw3D.cycle;
		Model.checkHover = true;
		Model.pickedCount = 0;
		Model.mouseX = super.mouseX - 8;
		Model.mouseZ = super.mouseY - 11;
		Draw2D.clear();
		this.scene.draw(this.cameraYaw, this.cameraX, level, this.cameraPitch, this.cameraY, this.cameraZ, loopCycle);
		this.scene.clearTemporaryLocs();
		this.draw2DEntityElements();
		this.drawTileHint();
		this.updateTextures(jitter);
		this.draw3DEntityElements();
		this.areaViewport.draw(11, super.graphics, 8);
		this.cameraX = cameraX;
		this.cameraY = cameraY;
		this.cameraZ = cameraZ;
		this.cameraPitch = cameraPitch;
		this.cameraYaw = cameraYaw;
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(Z)V")
	private void runMidi() {
		this.startMidiThread = false;
		while (this.midiThreadActive) {
			try {
				Thread.sleep(50L);
			} catch (@Pc(11) Exception ex) {
			}

			@Pc(19) String name;
			@Pc(22) int crc;
			@Pc(25) int len;
			synchronized (this.midiSync) {
				name = this.midiSyncName;
				crc = this.midiSyncCrc;
				len = this.midiSyncLen;
				this.midiSyncName = null;
				this.midiSyncCrc = 0;
				this.midiSyncLen = 0;
			}

			if (name != null) {
				@Pc(52) byte[] data = signlink.cacheload(name + ".mid");
				@Pc(69) int dataCrc;
				if (data != null && crc != 12345678) {
					this.crc32.reset();
					this.crc32.update(data);
					dataCrc = (int) this.crc32.getValue();
					if (dataCrc != crc) {
						data = null;
					}
				}

				if (data == null) {
					try {
						@Pc(91) DataInputStream stream = this.openUrl(name + "_" + crc + ".mid");
						data = new byte[len];
						@Pc(106) int read;
						for (@Pc(96) int off = 0; off < len; off += read) {
							read = stream.read(data, off, len - off);
							if (read == -1) {
								@Pc(112) byte[] tmp = new byte[off];
								System.arraycopy(data, 0, tmp, 0, off);
								data = tmp;
								len = off;
								break;
							}
						}
						stream.close();
						signlink.cachesave(name + ".mid", data);
					} catch (@Pc(153) Exception ex) {
					}
				}
				if (data == null) {
					return;
				}
				int uncompressedLength = (new Packet(data)).g4();
				@Pc(167) byte[] uncompressed = new byte[uncompressedLength];
				BZip2.read(uncompressed, uncompressedLength, data, len, 4);
				this.saveMidi(uncompressed, uncompressedLength, 1);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(Z)V")
	private void drawFlames() {
		@Pc(3) short height = 256;

		if (this.flameGradientCycle0 > 0) {
			for (int i = 0; i < 256; i++) {
				if (this.flameGradientCycle0 > 768) {
					this.flameGradient[i] = this.mix(this.flameGradient0[i], 1024 - this.flameGradientCycle0, this.flameGradient1[i]);
				} else if (this.flameGradientCycle0 > 256) {
					this.flameGradient[i] = this.flameGradient1[i];
				} else {
					this.flameGradient[i] = this.mix(this.flameGradient1[i], 256 - this.flameGradientCycle0, this.flameGradient0[i]);
				}
			}
		} else if (this.flameGradientCycle1 > 0) {
			for (int i = 0; i < 256; i++) {
				if (this.flameGradientCycle1 > 768) {
					this.flameGradient[i] = this.mix(this.flameGradient0[i], 1024 - this.flameGradientCycle1, this.flameGradient2[i]);
				} else if (this.flameGradientCycle1 > 256) {
					this.flameGradient[i] = this.flameGradient2[i];
				} else {
					this.flameGradient[i] = this.mix(this.flameGradient2[i], 256 - this.flameGradientCycle1, this.flameGradient0[i]);
				}
			}
		} else {
			for (int i = 0; i < 256; i++) {
				this.flameGradient[i] = this.flameGradient0[i];
			}
		}
		for (int i = 0; i < 33920; i++) {
			this.imageTitle0.pixels[i] = this.imageFlamesLeft.pixels[i];
		}

		@Pc(181) int srcOffset = 0;
		@Pc(183) int dstOffset = 1152;

		for (@Pc(185) int y = 1; y < height - 1; y++) {
			int offset = this.flameLineOffset[y] * (height - y) / height;
			int step = offset + 22;
			if (step < 0) {
				step = 0;
			}
			srcOffset += step;
			for (int x = step; x < 128; x++) {
				int value = this.flameBuffer3[srcOffset++];
				if (value == 0) {
					dstOffset++;
				} else {
					int alpha = value;
					int invAlpha = 256 - value;
					value = this.flameGradient[value];
					int background = this.imageTitle0.pixels[dstOffset];
					this.imageTitle0.pixels[dstOffset++] = ((value & 0xFF00FF) * alpha + (background & 0xFF00FF) * invAlpha & 0xFF00FF00) + ((value & 0xFF00) * alpha + (background & 0xFF00) * invAlpha & 0xFF0000) >> 8;
				}
			}
			dstOffset += step;
		}
		this.imageTitle0.draw(0, super.graphics, 0);
		for (int i = 0; i < 33920; i++) {
			this.imageTitle1.pixels[i] = this.imageFlamesRight.pixels[i];
		}
		srcOffset = 0;
		dstOffset = 1176;
		for (int y = 1; y < height - 1; y++) {
			int offset = this.flameLineOffset[y] * (height - y) / height;
			int step = 103 - offset;
			dstOffset += offset;
			for (int x = 0; x < step; x++) {
				int value = this.flameBuffer3[srcOffset++];
				if (value == 0) {
					dstOffset++;
				} else {
					int alpha = value;
					@Pc(362) int invAlpha = 256 - value;
					value = this.flameGradient[value];
					@Pc(373) int background = this.imageTitle1.pixels[dstOffset];
					this.imageTitle1.pixels[dstOffset++] = ((value & 0xFF00FF) * alpha + (background & 0xFF00FF) * invAlpha & 0xFF00FF00) + ((value & 0xFF00) * alpha + (background & 0xFF00) * invAlpha & 0xFF0000) >> 8;
				}
			}
			srcOffset += 128 - step;
			dstOffset += 128 - step - offset;
		}
		this.imageTitle1.draw(0, super.graphics, 661);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;III)V")
	private void handleInterfaceInput(@OriginalArg(0) int mouseY, @OriginalArg(1) int mouseX, @OriginalArg(2) int y, @OriginalArg(3) ComType parent, @OriginalArg(5) int x, @OriginalArg(6) int scrollPosition) {
		if (parent.type == 0 && parent.childId != null && !parent.hide && (mouseX >= x && mouseY >= y && mouseX <= x + parent.width && mouseY <= y + parent.height)) {
			@Pc(34) int children = parent.childId.length;
			for (@Pc(44) int i = 0; i < children; i++) {
				@Pc(53) int childX = parent.childX[i] + x;
				@Pc(62) int childZ = parent.childY[i] + y - scrollPosition;
				@Pc(69) ComType child = ComType.instances[parent.childId[i]];
				@Pc(74) int relX = childX + child.x;
				@Pc(79) int relY = childZ + child.y;

				if ((child.delegateHover >= 0 || child.hoverColor != 0) && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
					if (child.delegateHover >= 0) {
						this.lastHoveredInterfaceId = child.delegateHover;
					} else {
						this.lastHoveredInterfaceId = child.id;
					}
				}

				if (child.type == 0) {
					this.handleInterfaceInput(mouseY, mouseX, relY, child, relX, child.scrollPosition);
					if (child.scrollableHeight > child.height) {
						this.handleScrollInput(mouseX, mouseY, child.scrollableHeight, child.height, true, relX + child.width, relY, child);
					}
				} else {
					if (child.optionType == 1 && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
						@Pc(176) boolean override = false;

						if (child.contentType != 0) {
							override = this.handleSocialMenuOption(child);
						}

						if (!override) {
							this.menuOption[this.menuSize] = child.option;
							this.menuAction[this.menuSize] = 951;
							this.menuParamC[this.menuSize] = child.id;
							this.menuSize++;
						}
					}

					if (child.optionType == 2 && this.spellSelected == 0 && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
						@Pc(240) String prefix = child.spellAction;
						if (prefix.indexOf(" ") != -1) {
							prefix = prefix.substring(0, prefix.indexOf(" "));
						}

						this.menuOption[this.menuSize] = prefix + " @gre@" + child.spellName;
						this.menuAction[this.menuSize] = 930;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}

					if (child.optionType == 3 && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
						this.menuOption[this.menuSize] = "Close";
						this.menuAction[this.menuSize] = 947;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}

					if (child.optionType == 4 && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
						this.menuOption[this.menuSize] = child.option;
						this.menuAction[this.menuSize] = 465;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}

					if (child.optionType == 5 && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
						this.menuOption[this.menuSize] = child.option;
						this.menuAction[this.menuSize] = 960;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}

					if (child.optionType == 6 && !this.pressedContinueOption && mouseX >= relX && mouseY >= relY && mouseX < relX + child.width && mouseY < relY + child.height) {
						this.menuOption[this.menuSize] = child.option;
						this.menuAction[this.menuSize] = 44;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}

					if (child.type == 2) {
						@Pc(488) int slot = 0;
						for (@Pc(490) int row = 0; row < child.height; row++) {
							for (@Pc(494) int col = 0; col < child.width; col++) {
								@Pc(505) int slotX = relX + col * (child.inventoryMarginX + 32);
								@Pc(514) int slotY = relY + row * (child.inventoryMarginY + 32);

								if (slot < 20) {
									slotX += child.inventorySlotOffsetX[slot];
									slotY += child.inventorySlotOffsetY[slot];
								}

								if (mouseX >= slotX && mouseY >= slotY && mouseX < slotX + 32 && mouseY < slotY + 32) {
									this.hoveredSlot = slot;
									this.hoveredSlotParentId = child.id;

									if (child.inventorySlotObjId[slot] > 0) {
										@Pc(567) ObjType obj = ObjType.get(child.inventorySlotObjId[slot] - 1);
										if (this.objSelected == 1 && child.inventoryInteractable) {
											if (child.id != this.objSelectedInterface || slot != this.objSelectedSlot) {
												this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + obj.name;
												this.menuAction[this.menuSize] = 881;
												this.menuParamA[this.menuSize] = obj.index;
												this.menuParamB[this.menuSize] = slot;
												this.menuParamC[this.menuSize] = child.id;
												this.menuSize++;
											}
										} else if (this.spellSelected != 1 || !child.inventoryInteractable) {
											if (child.inventoryInteractable) {
												for (int op = 4; op >= 3; op--) {
													if (obj.iops != null && obj.iops[op] != null) {
														this.menuOption[this.menuSize] = obj.iops[op] + " @lre@" + obj.name;
														if (op == 3) {
															this.menuAction[this.menuSize] = 478;
														}
														if (op == 4) {
															this.menuAction[this.menuSize] = 347;
														}
														this.menuParamA[this.menuSize] = obj.index;
														this.menuParamB[this.menuSize] = slot;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													} else if (op == 4) {
														this.menuOption[this.menuSize] = "Drop @lre@" + obj.name;
														this.menuAction[this.menuSize] = 347;
														this.menuParamA[this.menuSize] = obj.index;
														this.menuParamB[this.menuSize] = slot;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													}
												}
											}

											if (child.inventoryUsable) {
												this.menuOption[this.menuSize] = "Use @lre@" + obj.name;
												this.menuAction[this.menuSize] = 188;
												this.menuParamA[this.menuSize] = obj.index;
												this.menuParamB[this.menuSize] = slot;
												this.menuParamC[this.menuSize] = child.id;
												this.menuSize++;
											}

											if (child.inventoryInteractable && obj.iops != null) {
												for (int op = 2; op >= 0; op--) {
													if (obj.iops[op] != null) {
														this.menuOption[this.menuSize] = obj.iops[op] + " @lre@" + obj.name;
														if (op == 0) {
															this.menuAction[this.menuSize] = 405;
														}
														if (op == 1) {
															this.menuAction[this.menuSize] = 38;
														}
														if (op == 2) {
															this.menuAction[this.menuSize] = 422;
														}
														this.menuParamA[this.menuSize] = obj.index;
														this.menuParamB[this.menuSize] = slot;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													}
												}
											}

											if (child.inventoryOptions != null) {
												for (int op = 4; op >= 0; op--) {
													if (child.inventoryOptions[op] != null) {
														this.menuOption[this.menuSize] = child.inventoryOptions[op] + " @lre@" + obj.name;
														if (op == 0) {
															this.menuAction[this.menuSize] = 602;
														}
														if (op == 1) {
															this.menuAction[this.menuSize] = 596;
														}
														if (op == 2) {
															this.menuAction[this.menuSize] = 22;
														}
														if (op == 3) {
															this.menuAction[this.menuSize] = 892;
														}
														if (op == 4) {
															this.menuAction[this.menuSize] = 415;
														}
														this.menuParamA[this.menuSize] = obj.index;
														this.menuParamB[this.menuSize] = slot;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													}
												}
											}

											this.menuOption[this.menuSize] = "Examine @lre@" + obj.name;
											this.menuAction[this.menuSize] = 1773;
											this.menuParamA[this.menuSize] = obj.index;
											this.menuParamC[this.menuSize] = child.inventorySlotObjCount[slot];
											this.menuSize++;
										} else if ((this.activeSpellFlags & 0x10) == 16) {
											this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + obj.name;
											this.menuAction[this.menuSize] = 391;
											this.menuParamA[this.menuSize] = obj.index;
											this.menuParamB[this.menuSize] = slot;
											this.menuParamC[this.menuSize] = child.id;
											this.menuSize++;
										}
									}
								}

								slot++;
							}
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(I)V")
	private void handleChatSettingsInput() {
		if (super.mouseClickButton == 1) {
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
				for (@Pc(186) int i = 0; i < ComType.instances.length; i++) {
					if (ComType.instances[i] != null && ComType.instances[i].contentType == 600) {
						this.reportAbuseInterfaceID = this.viewportInterfaceID = ComType.instances[i].parentId;
						return;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(III)V")
	private void handleChatMouseInput(@OriginalArg(0) int mouseY, @OriginalArg(2) int mouseX) {
		@Pc(1) int line = 0;
		for (@Pc(3) int i = 0; i < 100; i++) {
			if (this.messageText[i] != null) {
				@Pc(15) int type = this.messageType[i];
				@Pc(26) int y = this.chatScrollOffset + 70 + 4 - line * 14;
				if (y < -20) {
					break;
				}
				if (type == 0) {
					line++;
				}
				if ((type == 1 || type == 2) && (type == 1 || this.publicChatSetting == 0 || this.publicChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
					if (mouseY > y - 14 && mouseY <= y && !this.messageSender[i].equals(this.localPlayer.name)) {
						if (this.rights) {
							this.menuOption[this.menuSize] = "Report abuse @whi@" + this.messageSender[i];
							this.menuAction[this.menuSize] = 34;
							this.menuSize++;
						}
						this.menuOption[this.menuSize] = "Add ignore @whi@" + this.messageSender[i];
						this.menuAction[this.menuSize] = 436;
						this.menuSize++;
						this.menuOption[this.menuSize] = "Add friend @whi@" + this.messageSender[i];
						this.menuAction[this.menuSize] = 406;
						this.menuSize++;
					}
					line++;
				}
				if ((type == 3 || type == 7) && this.splitPrivateChat == 0 && (type == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
					if (mouseY > y - 14 && mouseY <= y) {
						if (this.rights) {
							this.menuOption[this.menuSize] = "Report abuse @whi@" + this.messageSender[i];
							this.menuAction[this.menuSize] = 34;
							this.menuSize++;
						}
						this.menuOption[this.menuSize] = "Add ignore @whi@" + this.messageSender[i];
						this.menuAction[this.menuSize] = 436;
						this.menuSize++;
						this.menuOption[this.menuSize] = "Add friend @whi@" + this.messageSender[i];
						this.menuAction[this.menuSize] = 406;
						this.menuSize++;
					}
					line++;
				}
				if (type == 4 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
					if (mouseY > y - 14 && mouseY <= y) {
						this.menuOption[this.menuSize] = "Accept trade @whi@" + this.messageSender[i];
						this.menuAction[this.menuSize] = 903;
						this.menuSize++;
					}
					line++;
				}
				if ((type == 5 || type == 6) && this.splitPrivateChat == 0 && this.privateChatSetting < 2) {
					line++;
				}
				if (type == 8 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
					if (mouseY > y - 14 && mouseY <= y) {
						this.menuOption[this.menuSize] = "Accept duel @whi@" + this.messageSender[i];
						this.menuAction[this.menuSize] = 363;
						this.menuSize++;
					}
					line++;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(I)V")
	private void pushPlayers() {
		if (this.localPlayer.x >> 7 == this.flagSceneTileX && this.localPlayer.z >> 7 == this.flagSceneTileZ) {
			this.flagSceneTileX = 0;
		}
		for (@Pc(22) int i = -1; i < this.playerCount; i++) {
			@Pc(30) PlayerEntity player;
			@Pc(35) int id;
			if (i == -1) {
				player = this.localPlayer;
				id = this.LOCAL_PLAYER_INDEX << 14;
			} else {
				player = this.players[this.playerIds[i]];
				id = this.playerIds[i] << 14;
			}
			if (player != null && player.isVisible()) {
				player.lowMemory = (lowMemory && this.playerCount > 50 || this.playerCount > 200) && i != -1 && player.secondarySeqId == player.seqStandId;
				@Pc(87) int stx = player.x >> 7;
				@Pc(92) int stz = player.z >> 7;
				if (stx >= 0 && stx < 104 && stz >= 0 && stz < 104) {
					if (player.locModel == null || loopCycle < player.locStartCycle || loopCycle >= player.locStopCycle) {
						if ((player.x & 0x7F) == 64 && (player.z & 0x7F) == 64) {
							if (this.tileLastOccupiedCycle[stx][stz] == this.sceneCycle) {
								continue;
							}
							this.tileLastOccupiedCycle[stx][stz] = this.sceneCycle;
						}
						player.y = this.getHeightmapY(this.currentLevel, player.x, player.z);
						this.scene.addTemporary(player.z, 60, player.yaw, player.x, id, player.seqStretches, null, player, player.y, this.currentLevel);
					} else {
						player.lowMemory = false;
						player.y = this.getHeightmapY(this.currentLevel, player.x, player.z);
						this.scene.addTemporary(player.maxTileX, null, player.z, player.y, id, player.yaw, player.minTileZ, player.minTileX, player, this.currentLevel, player.maxTileZ, player.x);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIBI)I")
	private int getHeightmapY(@OriginalArg(0) int level, @OriginalArg(1) int sceneX, @OriginalArg(3) int sceneZ) {
		@Pc(11) int tileX = sceneX >> 7;
		@Pc(15) int tileZ = sceneZ >> 7;
		@Pc(17) int realLevel = level;
		if (level < 3 && (this.levelTileFlags[1][tileX][tileZ] & 0x2) == 2) {
			realLevel = level + 1;
		}
		@Pc(37) int tileLocalX = sceneX & 0x7F;
		@Pc(41) int tileLocalZ = sceneZ & 0x7F;
		@Pc(69) int y00 = this.levelHeightmap[realLevel][tileX][tileZ] * (128 - tileLocalX) + this.levelHeightmap[realLevel][tileX + 1][tileZ] * tileLocalX >> 7;
		@Pc(101) int y11 = this.levelHeightmap[realLevel][tileX][tileZ + 1] * (128 - tileLocalX) + this.levelHeightmap[realLevel][tileX + 1][tileZ + 1] * tileLocalX >> 7;
		return y00 * (128 - tileLocalZ) + y11 * tileLocalZ >> 7;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!bc;IIII)V")
	private void addNpcOptions(@OriginalArg(0) NpcType npc, @OriginalArg(2) int c, @OriginalArg(3) int b, @OriginalArg(4) int a) {
		if (this.menuSize < 400) {
			@Pc(16) String tooltip = npc.name;
			if (npc.vislevel != 0) {
				tooltip = tooltip + getCombatLevelColorTag(this.localPlayer.combatLevel, npc.vislevel) + " (level-" + npc.vislevel + ")";
			}
			if (this.objSelected == 1) {
				this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @yel@" + tooltip;
				this.menuAction[this.menuSize] = 900;
				this.menuParamA[this.menuSize] = a;
				this.menuParamB[this.menuSize] = b;
				this.menuParamC[this.menuSize] = c;
				this.menuSize++;
			} else if (this.spellSelected != 1) {
				@Pc(155) int type;
				if (npc.ops != null) {
					for (type = 4; type >= 0; type--) {
						if (npc.ops[type] != null && !npc.ops[type].equalsIgnoreCase("attack")) {
							this.menuOption[this.menuSize] = npc.ops[type] + " @yel@" + tooltip;
							if (type == 0) {
								this.menuAction[this.menuSize] = 728;
							}
							if (type == 1) {
								this.menuAction[this.menuSize] = 542;
							}
							if (type == 2) {
								this.menuAction[this.menuSize] = 6;
							}
							if (type == 3) {
								this.menuAction[this.menuSize] = 963;
							}
							if (type == 4) {
								this.menuAction[this.menuSize] = 245;
							}
							this.menuParamA[this.menuSize] = a;
							this.menuParamB[this.menuSize] = b;
							this.menuParamC[this.menuSize] = c;
							this.menuSize++;
						}
					}
				}
				if (npc.ops != null) {
					for (type = 4; type >= 0; type--) {
						if (npc.ops[type] != null && npc.ops[type].equalsIgnoreCase("attack")) {
							@Pc(279) short action = 0;
							if (npc.vislevel > this.localPlayer.combatLevel) {
								action = 2000;
							}
							this.menuOption[this.menuSize] = npc.ops[type] + " @yel@" + tooltip;
							if (type == 0) {
								this.menuAction[this.menuSize] = action + 728;
							}
							if (type == 1) {
								this.menuAction[this.menuSize] = action + 542;
							}
							if (type == 2) {
								this.menuAction[this.menuSize] = action + 6;
							}
							if (type == 3) {
								this.menuAction[this.menuSize] = action + 963;
							}
							if (type == 4) {
								this.menuAction[this.menuSize] = action + 245;
							}
							this.menuParamA[this.menuSize] = a;
							this.menuParamB[this.menuSize] = b;
							this.menuParamC[this.menuSize] = c;
							this.menuSize++;
						}
					}
				}
				this.menuOption[this.menuSize] = "Examine @yel@" + tooltip;
				this.menuAction[this.menuSize] = 1607;
				this.menuParamA[this.menuSize] = a;
				this.menuParamB[this.menuSize] = b;
				this.menuParamC[this.menuSize] = c;
				this.menuSize++;
			} else if ((this.activeSpellFlags & 0x2) == 2) {
				this.menuOption[this.menuSize] = this.spellCaption + " @yel@" + tooltip;
				this.menuAction[this.menuSize] = 265;
				this.menuParamA[this.menuSize] = a;
				this.menuParamB[this.menuSize] = b;
				this.menuParamC[this.menuSize] = c;
				this.menuSize++;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(I)V")
	private void handleInputKey() {
		while (true) {
			@Pc(13) int key;
			do {
				while (true) {
					key = this.pollKey();
					if (key == -1) {
						return;
					}

					if (this.viewportInterfaceID != -1 && this.viewportInterfaceID == this.reportAbuseInterfaceID) {
						if (key == 8 && this.reportAbuseInput.length() > 0) {
							this.reportAbuseInput = this.reportAbuseInput.substring(0, this.reportAbuseInput.length() - 1);
						}
						break;
					}

					if (this.showSocialInput) {
						if (key >= 32 && key <= 122 && this.socialInput.length() < 80) {
							this.socialInput = this.socialInput + (char) key;
							this.redrawChatback = true;
						}

						if (key == 8 && this.socialInput.length() > 0) {
							this.socialInput = this.socialInput.substring(0, this.socialInput.length() - 1);
							this.redrawChatback = true;
						}

						if (key == 13 || key == 10) {
							this.showSocialInput = false;
							this.redrawChatback = true;

							@Pc(153) long username;
							if (this.socialAction == 1) {
								username = JString.toBase37(this.socialInput);
								this.addFriend(username);
							}

							if (this.socialAction == 2 && this.friendCount > 0) {
								username = JString.toBase37(this.socialInput);
								this.removeFriend(username);
							}

							if (this.socialAction == 3 && this.socialInput.length() > 0) {
								this.out.p1isaac(148);
								this.out.p1(0);
								int start = this.out.pos;
								this.out.p8(this.socialName37);
								WordPack.pack(this.out, this.socialInput);
								this.out.psize1(this.out.pos - start);
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
								username = JString.toBase37(this.socialInput);
								this.addIgnore(username);
							}

							if (this.socialAction == 5 && this.ignoreCount > 0) {
								username = JString.toBase37(this.socialInput);
								this.removeIgnore(username);
							}
						}
					} else if (this.chatbackInputOpen) {
						if (key >= 48 && key <= 57 && this.chatbackInput.length() < 10) {
							this.chatbackInput = this.chatbackInput + (char) key;
							this.redrawChatback = true;
						}

						if (key == 8 && this.chatbackInput.length() > 0) {
							this.chatbackInput = this.chatbackInput.substring(0, this.chatbackInput.length() - 1);
							this.redrawChatback = true;
						}

						if (key == 13 || key == 10) {
							if (this.chatbackInput.length() > 0) {
								int value = 0;
								try {
									value = Integer.parseInt(this.chatbackInput);
								} catch (@Pc(369) Exception ignored) {
								}
								this.out.p1isaac(237);
								this.out.p4(value);
							}
							this.chatbackInputOpen = false;
							this.redrawChatback = true;
						}
					} else if (this.chatInterfaceId == -1) {
						if (key >= 32 && key <= 122 && this.chatTyped.length() < 80) {
							this.chatTyped = this.chatTyped + (char) key;
							this.redrawChatback = true;
						}

						if (key == 8 && this.chatTyped.length() > 0) {
							this.chatTyped = this.chatTyped.substring(0, this.chatTyped.length() - 1);
							this.redrawChatback = true;
						}

						if ((key == 13 || key == 10) && this.chatTyped.length() > 0) {
							if (this.chatTyped.equals("::clientdrop") && super.frame != null) {
								this.tryReconnect();
							} else if (this.chatTyped.startsWith("::")) {
								this.out.p1isaac(4);
								this.out.p1(this.chatTyped.length() - 1);
								this.out.pjstr(this.chatTyped.substring(2));
							} else {
								@Pc(496) byte color = 0;
								if (this.chatTyped.startsWith("yellow:")) {
									color = 0;
									this.chatTyped = this.chatTyped.substring(7);
								} else if (this.chatTyped.startsWith("red:")) {
									color = 1;
									this.chatTyped = this.chatTyped.substring(4);
								} else if (this.chatTyped.startsWith("green:")) {
									color = 2;
									this.chatTyped = this.chatTyped.substring(6);
								} else if (this.chatTyped.startsWith("cyan:")) {
									color = 3;
									this.chatTyped = this.chatTyped.substring(5);
								} else if (this.chatTyped.startsWith("purple:")) {
									color = 4;
									this.chatTyped = this.chatTyped.substring(7);
								} else if (this.chatTyped.startsWith("white:")) {
									color = 5;
									this.chatTyped = this.chatTyped.substring(6);
								} else if (this.chatTyped.startsWith("flash1:")) {
									color = 6;
									this.chatTyped = this.chatTyped.substring(7);
								} else if (this.chatTyped.startsWith("flash2:")) {
									color = 7;
									this.chatTyped = this.chatTyped.substring(7);
								} else if (this.chatTyped.startsWith("flash3:")) {
									color = 8;
									this.chatTyped = this.chatTyped.substring(7);
								} else if (this.chatTyped.startsWith("glow1:")) {
									color = 9;
									this.chatTyped = this.chatTyped.substring(6);
								} else if (this.chatTyped.startsWith("glow2:")) {
									color = 10;
									this.chatTyped = this.chatTyped.substring(6);
								} else if (this.chatTyped.startsWith("glow3:")) {
									color = 11;
									this.chatTyped = this.chatTyped.substring(6);
								}

								@Pc(654) byte effect = 0;
								if (this.chatTyped.startsWith("wave:")) {
									effect = 1;
									this.chatTyped = this.chatTyped.substring(5);
								}
								if (this.chatTyped.startsWith("scroll:")) {
									effect = 2;
									this.chatTyped = this.chatTyped.substring(7);
								}

								this.out.p1isaac(158);
								this.out.p1(0);
								@Pc(693) int start = this.out.pos;
								this.out.p1(color);
								this.out.p1(effect);
								WordPack.pack(this.out, this.chatTyped);
								this.out.psize1(this.out.pos - start);

								this.chatTyped = JString.toSentenceCase(this.chatTyped);
								this.chatTyped = WordFilter.filter(this.chatTyped);
								this.localPlayer.chat = this.chatTyped;
								this.localPlayer.chatColor = color;
								this.localPlayer.chatStyle = effect;
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
			} while ((key < 97 || key > 122) && (key < 65 || key > 90) && (key < 48 || key > 57) && key != 32);

			if (this.reportAbuseInput.length() < 12) {
				this.reportAbuseInput = this.reportAbuseInput + (char) key;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Z)V")
	@Override
	protected void draw() {
		if (this.errorStarted || this.errorLoading || this.errorHost) {
			this.drawError();
		} else {
			if (this.ingame) {
				this.drawGame();
			} else {
				this.drawTitleScreen();
			}
			this.dragCycles = 0;
		}
	}

	@OriginalMember(owner = "client!client", name = "e", descriptor = "(B)V")
	private void updateTitle() {
		if (this.titleScreenState == 0) {
			int x = super.screenWidth / 2 - 80;
			int y = super.screenHeight / 2 + 20;

			y += 20;
			if (super.mouseClickButton == 1 && super.mouseClickX >= x - 75 && super.mouseClickX <= x + 75 && super.mouseClickY >= y - 20 && super.mouseClickY <= y + 20) {
				this.titleScreenState = 3;
				this.titleLoginField = 0;
			}

			x = super.screenWidth / 2 + 80;
			if (super.mouseClickButton == 1 && super.mouseClickX >= x - 75 && super.mouseClickX <= x + 75 && super.mouseClickY >= y - 20 && super.mouseClickY <= y + 20) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Enter your username & password.";
				this.titleScreenState = 2;
				this.titleLoginField = 0;
			}
		} else if (this.titleScreenState == 2) {
			int y = super.screenHeight / 2 - 40;
			y += 30;
			y += 25;

			if (super.mouseClickButton == 1 && super.mouseClickY >= y - 15 && super.mouseClickY < y) {
				this.titleLoginField = 0;
			}
			y += 15;

			if (super.mouseClickButton == 1 && super.mouseClickY >= y - 15 && super.mouseClickY < y) {
				this.titleLoginField = 1;
			}
			y += 15;

			int buttonX = super.screenWidth / 2 - 80;
			@Pc(170) int buttonY = super.screenHeight / 2 + 50;
			buttonY += 20;

			if (super.mouseClickButton == 1 && super.mouseClickX >= buttonX - 75 && super.mouseClickX <= buttonX + 75 && super.mouseClickY >= buttonY - 20 && super.mouseClickY <= buttonY + 20) {
				this.login(this.username, this.password, false);
			}

			buttonX = super.screenWidth / 2 + 80;
			if (super.mouseClickButton == 1 && super.mouseClickX >= buttonX - 75 && super.mouseClickX <= buttonX + 75 && super.mouseClickY >= buttonY - 20 && super.mouseClickY <= buttonY + 20) {
				this.titleScreenState = 0;
				this.username = "";
				this.password = "";
			}

			while (true) {
				while (true) {
					@Pc(254) int key = this.pollKey();
					if (key == -1) {
						return;
					}

					@Pc(259) boolean valid = false;
					for (@Pc(261) int i = 0; i < CHARSET.length(); i++) {
						if (key == CHARSET.charAt(i)) {
							valid = true;
							break;
						}
					}

					if (this.titleLoginField == 0) {
						if (key == 8 && this.username.length() > 0) {
							this.username = this.username.substring(0, this.username.length() - 1);
						}

						if (key == 9 || key == 10 || key == 13) {
							this.titleLoginField = 1;
						}

						if (valid) {
							this.username = this.username + (char) key;
						}

						if (this.username.length() > 12) {
							this.username = this.username.substring(0, 12);
						}
					} else if (this.titleLoginField == 1) {
						if (key == 8 && this.password.length() > 0) {
							this.password = this.password.substring(0, this.password.length() - 1);
						}

						if (key == 9 || key == 10 || key == 13) {
							this.titleLoginField = 0;
						}

						if (valid) {
							this.password = this.password + (char) key;
						}

						if (this.password.length() > 20) {
							this.password = this.password.substring(0, 20);
						}
					}
				}
			}
		} else if (this.titleScreenState == 3) {
			int x = super.screenWidth / 2;
			int y = super.screenHeight / 2 + 50;
			y += 20;

			if (super.mouseClickButton == 1 && super.mouseClickX >= x - 75 && super.mouseClickX <= x + 75 && super.mouseClickY >= y - 20 && super.mouseClickY <= y + 20) {
				this.titleScreenState = 0;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;II)Lclient!ub;")
	private Jagfile loadArchive(@OriginalArg(0) String displayName, @OriginalArg(1) int crc, @OriginalArg(2) String name, @OriginalArg(3) int progress) {
		@Pc(3) int retry = 5;
		@Pc(6) byte[] data = signlink.cacheload(name);
		if (data != null) {
			this.crc32.reset();
			this.crc32.update(data);
			int crcValue = (int) this.crc32.getValue();
			if (crcValue != crc) {
				data = null;
			}
		}

		if (data != null) {
			return new Jagfile(data);
		}

		while (data == null) {
			this.drawProgress("Requesting " + displayName, progress);
			try {
				int lastProgress = 0;
				@Pc(60) DataInputStream stream = this.openUrl(name + crc);
				@Pc(63) byte[] header = new byte[6];
				stream.readFully(header, 0, 6);
				@Pc(74) Packet head = new Packet(header);
				head.pos = 3;
				@Pc(82) int length = head.g3() + 6;
				@Pc(84) int offset = 6;
				data = new byte[length];
				System.arraycopy(header, 0, data, 0, 6);
				while (offset < length) {
					@Pc(107) int remaining = length - offset;
					if (remaining > 1000) {
						remaining = 1000;
					}

					offset += stream.read(data, offset, remaining);
					@Pc(126) int currentProgress = offset * 100 / length;
					if (currentProgress != lastProgress) {
						this.drawProgress("Loading " + displayName + " - " + currentProgress + "%", progress);
					}
					lastProgress = currentProgress;
				}
				stream.close();
			} catch (@Pc(155) IOException ex) {
				data = null;
				for (int i = retry; i > 0; i--) {
					this.drawProgress("Error loading - Will retry in " + i + " secs.", progress);
					try {
						Thread.sleep(1000L);
					} catch (@Pc(178) Exception ignored) {
					}
				}

				retry *= 2;
				if (retry > 60) {
					retry = 60;
				}
			}
		}

		signlink.cachesave(name, data);
		return new Jagfile(data);
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(Z)V")
	private void unloadTitle() {
		this.flameActive = false;
		while (this.flameThread) {
			this.flameActive = false;
			try {
				Thread.sleep(50L);
			} catch (@Pc(13) Exception ignored) {
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
	private void orbitCamera(@OriginalArg(0) int targetY, @OriginalArg(1) int targetX, @OriginalArg(2) int yaw, @OriginalArg(3) int pitch, @OriginalArg(5) int targetZ, @OriginalArg(6) int distance) {
		@Pc(5) int invPitch = 2048 - pitch & 0x7FF;
		@Pc(11) int invYaw = 2048 - yaw & 0x7FF;
		@Pc(13) int x = 0;
		@Pc(15) int z = 0;
		@Pc(17) int y = distance;
		@Pc(23) int sin;
		@Pc(27) int cos;
		@Pc(37) int tmp;
		if (invPitch != 0) {
			sin = Model.sin[invPitch];
			cos = Model.cos[invPitch];
			tmp = z * cos - distance * sin >> 16;
			y = z * sin + distance * cos >> 16;
			z = tmp;
		}
		if (invYaw != 0) {
			sin = Model.sin[invYaw];
			cos = Model.cos[invYaw];
			tmp = y * sin + x * cos >> 16;
			y = y * cos - x * sin >> 16;
			x = tmp;
		}
		this.cameraX = targetX - x;
		this.cameraY = targetY - z;
		this.cameraZ = targetZ - y;
		this.cameraPitch = pitch;
		this.cameraYaw = yaw;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZ)V")
	private void updateTextures(@OriginalArg(0) int cycle) {
		if (!lowMemory) {
			if (Draw3D.textureCycle[17] >= cycle) {
				Pix8 texture = Draw3D.textures[17];
				int bottom = texture.width * texture.height - 1;
				int adjustment = texture.width * this.sceneDelta * 2;
				byte[] src = texture.pixels;
				byte[] dst = this.textureBuffer;
				for (int i = 0; i <= bottom; i++) {
					dst[i] = src[i - adjustment & bottom];
				}
				texture.pixels = dst;
				this.textureBuffer = src;
				Draw3D.pushTexture(17);
			}

			if (Draw3D.textureCycle[24] >= cycle) {
				Pix8 texture = Draw3D.textures[24];
				int bottom = texture.width * texture.height - 1;
				int adjustment = texture.width * this.sceneDelta * 2;
				byte[] src = texture.pixels;
				byte[] dst = this.textureBuffer;
				for (int i = 0; i <= bottom; i++) {
					dst[i] = src[i - adjustment & bottom];
				}
				texture.pixels = dst;
				this.textureBuffer = src;
				Draw3D.pushTexture(24);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(Z)V")
	private void updateFlames() {
		@Pc(3) short height = 256;
		for (@Pc(5) int x = 10; x < 117; x++) {
			int rand = (int) (Math.random() * 100.0D);
			if (rand < 50) {
				this.flameBuffer3[x + (height - 2 << 7)] = 255;
			}
		}

		for (int l = 0; l < 100; l++) {
			int x = (int) (Math.random() * 124.0D) + 2;
			int y = (int) (Math.random() * 128.0D) + 128;
			int index = x + (y << 7);
			this.flameBuffer3[index] = 192;
		}

		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < 127; x++) {
				int index = x + (y << 7);
				this.flameBuffer2[index] = (this.flameBuffer3[index - 1] + this.flameBuffer3[index + 1] + this.flameBuffer3[index - 128] + this.flameBuffer3[index + 128]) / 4;
			}
		}

		this.flameCycle0 += 128;
		if (this.flameCycle0 > this.flameBuffer0.length) {
			this.flameCycle0 -= this.flameBuffer0.length;
			int rand = (int) (Math.random() * 12.0D);
			this.updateFlameBuffer(this.imageRunes[rand]);
		}

		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < 127; x++) {
				int index = x + (y << 7);
				@Pc(196) int intensity = this.flameBuffer2[index + 128] - this.flameBuffer0[index + this.flameCycle0 & this.flameBuffer0.length - 1] / 5;
				if (intensity < 0) {
					intensity = 0;
				}
				this.flameBuffer3[index] = intensity;
			}
		}
		for (int y = 0; y < height - 1; y++) {
			this.flameLineOffset[y] = this.flameLineOffset[y + 1];
		}
		this.flameLineOffset[height - 1] = (int) (Math.sin((double) loopCycle / 14.0D) * 16.0D + Math.sin((double) loopCycle / 15.0D) * 14.0D + Math.sin((double) loopCycle / 16.0D) * 12.0D);
		if (this.flameGradientCycle0 > 0) {
			this.flameGradientCycle0 -= 4;
		}
		if (this.flameGradientCycle1 > 0) {
			this.flameGradientCycle1 -= 4;
		}
		if (this.flameGradientCycle0 == 0 && this.flameGradientCycle1 == 0) {
			int rand = (int) (Math.random() * 2000.0D);
			if (rand == 0) {
				this.flameGradientCycle0 = 1024;
			}
			if (rand == 1) {
				this.flameGradientCycle1 = 1024;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(B)V")
	private void drawMinimap() {
		this.areaMapback.bind();
		@Pc(18) int angle = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
		@Pc(26) int anchorX = this.localPlayer.x / 32 + 48;
		@Pc(34) int anchorY = 464 - this.localPlayer.z / 32;
		this.imageMinimap.drawRotatedMasked(angle, 146, this.minimapMaskLineOffsets, 151, anchorY, this.minimapZoom + 256, anchorX, 21, 9, this.minimapMaskLineLengths);
		this.imageCompass.drawRotatedMasked(this.orbitCameraYaw, 33, this.compassMaskLineOffsets, 33, 25, 256, 25, 0, 0, this.compassMaskLineLengths);
		for (@Pc(72) int i = 0; i < this.activeMapFunctionCount; i++) {
			anchorX = this.activeMapFunctionX[i] * 4 + 2 - this.localPlayer.x / 32;
			anchorY = this.activeMapFunctionZ[i] * 4 + 2 - this.localPlayer.z / 32;
			this.drawOnMinimap(anchorY, this.activeMapFunctions[i], anchorX);
		}

		for (@Pc(120) int ltx = 0; ltx < 104; ltx++) {
			for (int ltz = 0; ltz < 104; ltz++) {
				@Pc(136) LinkList stack = this.levelObjStacks[this.currentLevel][ltx][ltz];
				if (stack != null) {
					anchorX = ltx * 4 + 2 - this.localPlayer.x / 32;
					anchorY = ltz * 4 + 2 - this.localPlayer.z / 32;
					this.drawOnMinimap(anchorY, this.imageMapdot0, anchorX);
				}
			}
		}

		for (int i = 0; i < this.npcCount; i++) {
			@Pc(189) NpcEntity npc = this.npcs[this.npcIds[i]];
			if (npc != null && npc.isVisible() && npc.type.visonmap) {
				anchorX = npc.x / 32 - this.localPlayer.x / 32;
				anchorY = npc.z / 32 - this.localPlayer.z / 32;
				this.drawOnMinimap(anchorY, this.imageMapdot1, anchorX);
			}
		}

		for (@Pc(235) int i = 0; i < this.playerCount; i++) {
			@Pc(245) PlayerEntity player = this.players[this.playerIds[i]];
			if (player != null && player.isVisible()) {
				anchorX = player.x / 32 - this.localPlayer.x / 32;
				anchorY = player.z / 32 - this.localPlayer.z / 32;

				@Pc(275) boolean friend = false;
				@Pc(279) long name37 = JString.toBase37(player.name);
				for (@Pc(281) int j = 0; j < this.friendCount; j++) {
					if (name37 == this.friendName37[j] && this.friendWorld[j] != 0) {
						friend = true;
						break;
					}
				}

				if (friend) {
					this.drawOnMinimap(anchorY, this.imageMapdot3, anchorX);
				} else {
					this.drawOnMinimap(anchorY, this.imageMapdot2, anchorX);
				}
			}
		}

		if (this.flagSceneTileX != 0) {
			anchorX = this.flagSceneTileX * 4 + 2 - this.localPlayer.x / 32;
			anchorY = this.flagSceneTileZ * 4 + 2 - this.localPlayer.z / 32;
			this.drawOnMinimap(anchorY, this.imageMapflag, anchorX);
		}

		Draw2D.fillRect(82, 93, 0xffffff, 3, 3);
		this.areaViewport.bind();
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(B)Ljava/awt/Component;")
	@Override
	protected Component getBaseComponent() {
		if (signlink.mainapp == null) {
			return this;
		} else {
			return signlink.mainapp;
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(I)V")
	private void updateTemporaryLocs() {
		if (this.sceneState == 2) {
			for (@Pc(12) LocSpawned loc = (LocSpawned) this.temporaryLocs.peekFront(); loc != null; loc = (LocSpawned) this.temporaryLocs.prev()) {
				if (loopCycle >= loc.lastCycle) {
					this.addLoc(loc.orientation, loc.x, loc.z, loc.classType, loc.locIndex, loc.type, loc.plane);
					loc.unlink();
				}
			}

			updateLocCounter++;
			if (updateLocCounter > 85) {
				updateLocCounter = 0;
				this.out.p1isaac(85);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(II)V")
	private void createMinimap(@OriginalArg(0) int level) {
		@Pc(5) int[] pixels = this.imageMinimap.pixels;
		@Pc(11) int length = pixels.length;
		for (@Pc(13) int i = 0; i < length; i++) {
			pixels[i] = 0;
		}

		for (@Pc(25) int z = 1; z < 103; z++) {
			int offset = (103 - z) * 512 * 4 + 24628;

			for (int x = 1; x < 103; x++) {
				if ((this.levelTileFlags[level][x][z] & 0x18) == 0) {
					this.scene.drawMinimapTile(pixels, offset, 512, level, x, z);
				}

				if (level < 3 && (this.levelTileFlags[level + 1][x][z] & 0x8) != 0) {
					this.scene.drawMinimapTile(pixels, offset, 512, level + 1, x, z);
				}

				offset += 4;
			}
		}

		int wallRgb = ((int) (Math.random() * 20.0D) + 238 - 10 << 16) + ((int) (Math.random() * 20.0D) + 238 - 10 << 8) + (int) (Math.random() * 20.0D) + 238 - 10;
		int doorRgb = (int) (Math.random() * 20.0D) + 238 - 10 << 16;

		this.imageMinimap.bind();

		for (@Pc(145) int z = 1; z < 103; z++) {
			for (int x = 1; x < 103; x++) {
				if ((this.levelTileFlags[level][x][z] & 0x18) == 0) {
					this.drawMinimapLoc(level, wallRgb, x, doorRgb, z);
				}

				if (level < 3 && (this.levelTileFlags[level + 1][x][z] & 0x8) != 0) {
					this.drawMinimapLoc(level + 1, wallRgb, x, doorRgb, z);
				}
			}
		}

		this.areaViewport.bind();
		this.activeMapFunctionCount = 0;

		for (int x = 0; x < 104; x++) {
			for (@Pc(217) int z = 0; z < 104; z++) {
				@Pc(227) int bitset = this.scene.getGroundDecorationBitset(this.currentLevel, x, z);
				if (bitset != 0) {
					bitset = bitset >> 14 & 0x7FFF;

					@Pc(239) int func = LocType.get(bitset).mapfunction;
					if (func >= 0) {
						@Pc(243) int stx = x;
						@Pc(245) int stz = z;

						if (func != 22 && func != 29 && func != 34 && func != 36 && func != 46 && func != 47 && func != 48) {
							@Pc(268) byte maxX = 104;
							@Pc(270) byte maxZ = 104;
							@Pc(277) int[][] flags = this.levelCollisionMap[this.currentLevel].flags;

							for (@Pc(279) int i = 0; i < 10; i++) {
								@Pc(286) int rand = (int) (Math.random() * 4.0D);
								if (rand == 0 && stx > 0 && stx > x - 3 && (flags[stx - 1][stz] & 0x280108) == 0) {
									stx--;
								}

								if (rand == 1 && stx < maxX - 1 && stx < x + 3 && (flags[stx + 1][stz] & 0x280180) == 0) {
									stx++;
								}

								if (rand == 2 && stz > 0 && stz > z - 3 && (flags[stx][stz - 1] & 0x280102) == 0) {
									stz--;
								}

								if (rand == 3 && stz < maxZ - 1 && stz < z + 3 && (flags[stx][stz + 1] & 0x280120) == 0) {
									stz++;
								}
							}
						}

						this.activeMapFunctions[this.activeMapFunctionCount] = this.imageMapfunction[func];
						this.activeMapFunctionX[this.activeMapFunctionCount] = stx;
						this.activeMapFunctionZ[this.activeMapFunctionCount] = stz;
						this.activeMapFunctionCount++;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIII)V")
	private void drawMinimapLoc(@OriginalArg(1) int level, @OriginalArg(2) int wallRgb, @OriginalArg(3) int tileX, @OriginalArg(4) int doorRgb, @OriginalArg(5) int tileZ) {
		@Pc(8) int bitset = this.scene.getWallBitset(level, tileX, tileZ);

		if (bitset != 0) {
			int info = this.scene.getInfo(level, tileX, tileZ, bitset);
			int rotation = info >> 6 & 0x3;
			int shape = info & 0x1F;
			int rgb = wallRgb;
			if (bitset > 0) {
				rgb = doorRgb;
			}

			@Pc(38) int[] dst = this.imageMinimap.pixels;
			int offset = tileX * 4 + (103 - tileZ) * 512 * 4 + 24624;
			int locId = bitset >> 14 & 0x7FFF;

			@Pc(61) LocType loc = LocType.get(locId);
			if (loc.mapscene == -1) {
				if (shape == 0 || shape == 2) {
					if (rotation == 0) {
						dst[offset] = rgb;
						dst[offset + 512] = rgb;
						dst[offset + 1024] = rgb;
						dst[offset + 1536] = rgb;
					} else if (rotation == 1) {
						dst[offset] = rgb;
						dst[offset + 1] = rgb;
						dst[offset + 2] = rgb;
						dst[offset + 3] = rgb;
					} else if (rotation == 2) {
						dst[offset + 3] = rgb;
						dst[offset + 3 + 512] = rgb;
						dst[offset + 3 + 1024] = rgb;
						dst[offset + 3 + 1536] = rgb;
					} else if (rotation == 3) {
						dst[offset + 1536] = rgb;
						dst[offset + 1536 + 1] = rgb;
						dst[offset + 1536 + 2] = rgb;
						dst[offset + 1536 + 3] = rgb;
					}
				}

				if (shape == 3) {
					if (rotation == 0) {
						dst[offset] = rgb;
					} else if (rotation == 1) {
						dst[offset + 3] = rgb;
					} else if (rotation == 2) {
						dst[offset + 3 + 1536] = rgb;
					} else if (rotation == 3) {
						dst[offset + 1536] = rgb;
					}
				}

				if (shape == 2) {
					if (rotation == 3) {
						dst[offset] = rgb;
						dst[offset + 512] = rgb;
						dst[offset + 1024] = rgb;
						dst[offset + 1536] = rgb;
					} else if (rotation == 0) {
						dst[offset] = rgb;
						dst[offset + 1] = rgb;
						dst[offset + 2] = rgb;
						dst[offset + 3] = rgb;
					} else if (rotation == 1) {
						dst[offset + 3] = rgb;
						dst[offset + 3 + 512] = rgb;
						dst[offset + 3 + 1024] = rgb;
						dst[offset + 3 + 1536] = rgb;
					} else if (rotation == 2) {
						dst[offset + 1536] = rgb;
						dst[offset + 1536 + 1] = rgb;
						dst[offset + 1536 + 2] = rgb;
						dst[offset + 1536 + 3] = rgb;
					}
				}
			} else {
				@Pc(71) Pix8 scene = this.imageMapscene[loc.mapscene];
				if (scene != null) {
					@Pc(83) int offsetX = (loc.width * 4 - scene.width) / 2;
					@Pc(93) int offsetY = (loc.length * 4 - scene.height) / 2;
					scene.draw((104 - tileZ - loc.length) * 4 + offsetY + 48, tileX * 4 + 48 + offsetX);
				}
			}
		}

		bitset = this.scene.getLocBitset(level, tileX, tileZ);
		if (bitset != 0) {
			int info = this.scene.getInfo(level, tileX, tileZ, bitset);
			int rotation = info >> 6 & 0x3;
			int shape = info & 0x1F;
			int locId = bitset >> 14 & 0x7FFF;
			@Pc(451) LocType loc = LocType.get(locId);

			if (loc.mapscene != -1) {
				@Pc(461) Pix8 scene = this.imageMapscene[loc.mapscene];
				if (scene != null) {
					int offsetX = (loc.width * 4 - scene.width) / 2;
					int offsetY = (loc.length * 4 - scene.height) / 2;
					scene.draw((104 - tileZ - loc.length) * 4 + offsetY + 48, tileX * 4 + 48 + offsetX);
				}
			} else if (shape == 9) {
				int rgb = 0xeeeeee;
				if (bitset > 0) {
					rgb = 0xee0000;
				}

				@Pc(520) int[] dst = this.imageMinimap.pixels;
				int offset = tileX * 4 + (103 - tileZ) * 512 * 4 + 24624;

				if (rotation == 0 || rotation == 2) {
					dst[offset + 1536] = rgb;
					dst[offset + 1024 + 1] = rgb;
					dst[offset + 512 + 2] = rgb;
					dst[offset + 3] = rgb;
				} else {
					dst[offset] = rgb;
					dst[offset + 512 + 1] = rgb;
					dst[offset + 1024 + 2] = rgb;
					dst[offset + 1536 + 3] = rgb;
				}
			}
		}

		bitset = this.scene.getGroundDecorationBitset(level, tileX, tileZ);
		if (bitset != 0) {
			int locId = bitset >> 14 & 0x7FFF;
			@Pc(615) LocType loc = LocType.get(locId);
			if (loc.mapscene != -1) {
				@Pc(625) Pix8 scene = this.imageMapscene[loc.mapscene];
				if (scene != null) {
					int offsetX = (loc.width * 4 - scene.width) / 2;
					@Pc(647) int offsetY = (loc.length * 4 - scene.height) / 2;
					scene.draw((104 - tileZ - loc.length) * 4 + offsetY + 48, tileX * 4 + 48 + offsetX);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!kb;IZ)V")
	private void readNpcInfo(@OriginalArg(0) Packet buf, @OriginalArg(1) int size) {
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;

		this.readNpcs(buf, size);
		this.readNewNpcs(buf, size);
		this.readNpcUpdates(buf, size);

		for (@Pc(29) int i = 0; i < this.entityRemovalCount; i++) {
			int index = this.entityRemovalIds[i];
			if (this.npcs[index].cycle != loopCycle) {
				this.npcs[index].type = null;
				this.npcs[index] = null;
			}
		}

		if (buf.pos != size) {
			signlink.reporterror(this.username + " size mismatch in getnpcpos - pos:" + buf.pos + " psize:" + size);
			throw new RuntimeException("eek");
		}

		for (int i = 0; i < this.npcCount; i++) {
			if (this.npcs[this.npcIds[i]] == null) {
				signlink.reporterror(this.username + " null entry in npc list - pos:" + i + " size:" + this.npcCount);
				throw new RuntimeException("eek");
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	@Override
	public void startThread(@OriginalArg(0) Runnable runnable, @OriginalArg(1) int priority) {
		if (signlink.mainapp == null) {
			super.startThread(runnable, priority);
		} else {
			signlink.startthread(runnable, priority);
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(I)V")
	private void loadTitleImages() {
		this.imageTitlebox = new Pix8(this.archiveTitle, "titlebox", 0);
		this.imageTitlebutton = new Pix8(this.archiveTitle, "titlebutton", 0);
		this.imageRunes = new Pix8[12];
		for (@Pc(32) int i = 0; i < 12; i++) {
			this.imageRunes[i] = new Pix8(this.archiveTitle, "runes", i);
		}
		this.imageFlamesLeft = new Pix24(128, 265);
		this.imageFlamesRight = new Pix24(128, 265);
		System.arraycopy(this.imageTitle0.pixels, 0, this.imageFlamesLeft.pixels, 0, 33920);
		System.arraycopy(this.imageTitle1.pixels, 0, this.imageFlamesRight.pixels, 0, 33920);
		this.flameGradient0 = new int[256];
		for (@Pc(105) int i = 0; i < 64; i++) {
			this.flameGradient0[i] = i * 262144;
		}
		for (@Pc(120) int i = 0; i < 64; i++) {
			this.flameGradient0[i + 64] = i * 1024 + 16711680;
		}
		for (@Pc(139) int i = 0; i < 64; i++) {
			this.flameGradient0[i + 128] = i * 4 + 16776960;
		}
		for (@Pc(158) int i = 0; i < 64; i++) {
			this.flameGradient0[i + 192] = 16777215;
		}
		this.flameGradient1 = new int[256];
		for (@Pc(177) int i = 0; i < 64; i++) {
			this.flameGradient1[i] = i * 1024;
		}
		for (@Pc(192) int i = 0; i < 64; i++) {
			this.flameGradient1[i + 64] = i * 4 + 65280;
		}
		for (@Pc(211) int i = 0; i < 64; i++) {
			this.flameGradient1[i + 128] = i * 262144 + 65535;
		}
		for (@Pc(230) int i = 0; i < 64; i++) {
			this.flameGradient1[i + 192] = 16777215;
		}
		this.flameGradient2 = new int[256];
		for (@Pc(249) int i = 0; i < 64; i++) {
			this.flameGradient2[i] = i * 4;
		}
		for (@Pc(264) int i = 0; i < 64; i++) {
			this.flameGradient2[i + 64] = i * 262144 + 255;
		}
		for (@Pc(283) int i = 0; i < 64; i++) {
			this.flameGradient2[i + 128] = i * 1024 + 16711935;
		}
		for (@Pc(302) int i = 0; i < 64; i++) {
			this.flameGradient2[i + 192] = 16777215;
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
	private void readPlayers(@OriginalArg(0) int size, @OriginalArg(1) Packet buf) {
		@Pc(6) int count = buf.gBit(8);

		if (count < this.playerCount) {
			for (int i = count; i < this.playerCount; i++) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.playerIds[i];
			}
		}

		if (count > this.playerCount) {
			signlink.reporterror(this.username + " Too many players");
			throw new RuntimeException("eek");
		}

		this.playerCount = 0;
		for (int i = 0; i < count; i++) {
			@Pc(73) int index = this.playerIds[i];
			@Pc(78) PlayerEntity player = this.players[index];

			@Pc(83) int hasUpdate = buf.gBit(1);
			if (hasUpdate == 0) {
				this.playerIds[this.playerCount++] = index;
				player.cycle = loopCycle;
			} else {
				@Pc(106) int updateType = buf.gBit(2);

				if (updateType == 0) {
					this.playerIds[this.playerCount++] = index;
					player.cycle = loopCycle;
					this.entityUpdateIds[this.entityUpdateCount++] = index;
				} else if (updateType == 1) {
					this.playerIds[this.playerCount++] = index;
					player.cycle = loopCycle;

					int walkDir = buf.gBit(3);
					player.step(false, walkDir);

					int hasMaskUpdate = buf.gBit(1);
					if (hasMaskUpdate == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = index;
					}
				} else if (updateType == 2) {
					this.playerIds[this.playerCount++] = index;
					player.cycle = loopCycle;

					int walkDir = buf.gBit(3);
					player.step(true, walkDir);
					int runDir = buf.gBit(3);
					player.step(true, runDir);

					@Pc(225) int hasMaskUpdate = buf.gBit(1);
					if (hasMaskUpdate == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = index;
					}
				} else if (updateType == 3) {
					this.entityRemovalIds[this.entityRemovalCount++] = index;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IIIIII)V")
	private void drawScrollbar(@OriginalArg(1) int x, @OriginalArg(2) int y, @OriginalArg(3) int scrollY, @OriginalArg(4) int scrollHeight, @OriginalArg(5) int height) {
		this.imageScrollbar0.draw(y, x);
		this.imageScrollbar1.draw(y + height - 16, x);
		Draw2D.fillRect(y + 16, x, this.SCROLLBAR_TRACK, 16, height - 32);
		@Pc(35) int gripSize = (height - 32) * height / scrollHeight;
		if (gripSize < 8) {
			gripSize = 8;
		}
		@Pc(52) int gripY = (height - gripSize - 32) * scrollY / (scrollHeight - height);
		Draw2D.fillRect(y + gripY + 16, x, this.SCROLLBAR_GRIP_FOREGROUND, 16, gripSize);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, y + gripY + 16, gripSize, x);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, y + gripY + 16, gripSize, x + 1);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, y + gripY + 16, 16, x);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_HIGHLIGHT, y + gripY + 17, 16, x);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_LOWLIGHT, y + gripY + 16, gripSize, x + 15);
		Draw2D.drawVerticalLine(this.SCROLLBAR_GRIP_LOWLIGHT, y + gripY + 17, gripSize - 1, x + 14);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_LOWLIGHT, y + gripY + gripSize + 15, 16, x);
		Draw2D.drawHorizontalLine(this.SCROLLBAR_GRIP_LOWLIGHT, y + gripY + gripSize + 14, 15, x + 1);
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(B)V")
	private void validateCharacterDesign() {
		this.updateDesignModel = true;
		for (@Pc(12) int i = 0; i < 7; i++) {
			this.designIdentikits[i] = -1;
			for (@Pc(21) int j = 0; j < IdkType.count; j++) {
				if (!IdkType.instances[j].disable && IdkType.instances[j].type == i + (this.designGenderMale ? 0 : 7)) {
					this.designIdentikits[i] = j;
					break;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BIIZ)V")
	private void saveMidi(@OriginalArg(0) byte[] src, @OriginalArg(2) int length, @OriginalArg(3) int fade) {
		signlink.midifade = fade;
		signlink.midisave(src, length);
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(Z)V")
	private void pushNpcs() {
		for (@Pc(1) int i = 0; i < this.npcCount; i++) {
			@Pc(11) NpcEntity npc = this.npcs[this.npcIds[i]];
			@Pc(20) int bitset = (this.npcIds[i] << 14) + 0x20000000;
			if (npc != null && npc.isVisible()) {
				@Pc(31) int x = npc.x >> 7;
				@Pc(36) int z = npc.z >> 7;
				if (x >= 0 && x < 104 && z >= 0 && z < 104) {
					if (npc.size == 1 && (npc.x & 0x7F) == 64 && (npc.z & 0x7F) == 64) {
						if (this.tileLastOccupiedCycle[x][z] == this.sceneCycle) {
							continue;
						}
						this.tileLastOccupiedCycle[x][z] = this.sceneCycle;
					}
					this.scene.addTemporary(npc.z, (npc.size - 1) * 64 + 60, npc.yaw, npc.x, bitset, npc.seqStretches, null, npc, this.getHeightmapY(this.currentLevel, npc.x, npc.z), this.currentLevel);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZ)V")
	private void setMidiVolume(@OriginalArg(1) int volume) {
		signlink.midivol = volume;
		signlink.midi = "voladjust";
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(I)V")
	private void drawTitleScreen() {
		this.loadTitle();
		this.imageTitle4.bind();
		this.imageTitlebox.draw(0, 0);

		@Pc(21) int w = 360;
		@Pc(23) int h = 200;

		if (this.titleScreenState == 0) {
			int y = h / 2 - 20;
			this.fontBold12.drawStringTaggableCenter(w / 2, 16776960, true, y, "Welcome to RuneScape");

			int x = w / 2 - 80;
			y = h / 2 + 20;

			this.imageTitlebutton.draw(y - 20, x - 73);
			this.fontBold12.drawStringTaggableCenter(x, 16777215, true, y + 5, "New user");

			x = w / 2 + 80;
			this.imageTitlebutton.draw(y - 20, x - 73);
			this.fontBold12.drawStringTaggableCenter(x, 16777215, true, y + 5, "Existing User");
		} else if (this.titleScreenState == 2) {
			int y = h / 2 - 40;
			if (this.loginMessage0.length() > 0) {
				this.fontBold12.drawStringTaggableCenter(w / 2, 16776960, true, y - 15, this.loginMessage0);
				this.fontBold12.drawStringTaggableCenter(w / 2, 16776960, true, y, this.loginMessage1);
				y += 30;
			} else {
				this.fontBold12.drawStringTaggableCenter(w / 2, 16776960, true, y - 7, this.loginMessage1);
				y += 30;
			}

			this.fontBold12.drawStringTaggable(w / 2 - 90, y, "Username: " + this.username + (this.titleLoginField == 0 & loopCycle % 40 < 20 ? "@yel@|" : ""), true, 16777215);
			y += 15;

			this.fontBold12.drawStringTaggable(w / 2 - 88, y, "Password: " + JString.toAsterisks(this.password) + (this.titleLoginField == 1 & loopCycle % 40 < 20 ? "@yel@|" : ""), true, 16777215);
			y += 15;

			int x = w / 2 - 80;
			y = h / 2 + 50;
			this.imageTitlebutton.draw(y - 20, x - 73);
			this.fontBold12.drawStringTaggableCenter(x, 16777215, true, y + 5, "Login");

			x = w / 2 + 80;
			this.imageTitlebutton.draw(y - 20, x - 73);
			this.fontBold12.drawStringTaggableCenter(x, 16777215, true, y + 5, "Cancel");
		} else if (this.titleScreenState == 3) {
			this.fontBold12.drawStringTaggableCenter(w / 2, 16776960, true, h / 2 - 60, "Create a free account");

			int y = h / 2 - 35;
			this.fontBold12.drawStringTaggableCenter(w / 2, 16777215, true, y, "To create a new account you need to");
			y += 15;

			this.fontBold12.drawStringTaggableCenter(w / 2, 16777215, true, y, "go back to the main RuneScape webpage");
			y += 15;

			this.fontBold12.drawStringTaggableCenter(w / 2, 16777215, true, y, "and choose the red 'create account'");
			y += 15;

			this.fontBold12.drawStringTaggableCenter(w / 2, 16777215, true, y, "button at the top right of that page.");
			y += 15;

			int x = w / 2;
			y = h / 2 + 50;
			this.imageTitlebutton.draw(y - 20, x - 73);
			this.fontBold12.drawStringTaggableCenter(x, 16777215, true, y + 5, "Cancel");
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
		if (this.areaChatback == null) {
			this.unloadTitle();
			super.drawArea = null;
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
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!kb;)V")
	private void readNewPlayers(@OriginalArg(1) int size, @OriginalArg(2) Packet buf) {
		@Pc(9) int index;
		while (buf.bitPos + 10 < size * 8) {
			index = buf.gBit(11);
			if (index == 2047) {
				break;
			}

			if (this.players[index] == null) {
				this.players[index] = new PlayerEntity();
				if (this.playerAppearanceBuffer[index] != null) {
					this.players[index].read(this.playerAppearanceBuffer[index]);
				}
			}

			this.playerIds[this.playerCount++] = index;
			@Pc(73) PlayerEntity player = this.players[index];
			player.cycle = loopCycle;
			@Pc(81) int dx = buf.gBit(5);
			if (dx > 15) {
				dx -= 32;
			}
			@Pc(90) int dz = buf.gBit(5);
			if (dz > 15) {
				dz -= 32;
			}
			@Pc(99) int jump = buf.gBit(1);
			player.move(jump == 1, this.localPlayer.pathTileX[0] + dx, this.localPlayer.pathTileZ[0] + dz);

			@Pc(127) int hasMaskUpdate = buf.gBit(1);
			if (hasMaskUpdate == 1) {
				this.entityUpdateIds[this.entityUpdateCount++] = index;
			}
		}

		buf.accessBytes();
	}

	@OriginalMember(owner = "client!client", name = "q", descriptor = "(I)V")
	private void logout() {
		try {
			if (this.stream != null) {
				this.stream.close();
			}
		} catch (@Pc(9) Exception ignored) {
		}
		this.stream = null;
		this.ingame = false;
		this.titleScreenState = 0;
		this.username = "";
		this.password = "";
		InputTracking.setDisabled();
		this.clearCaches();
		this.scene.reset();
		for (@Pc(41) int level = 0; level < 4; level++) {
			this.levelCollisionMap[level].reset();
		}
		System.gc();
		this.stopMidi();
		this.currentMidi = null;
		this.nextMusicDelay = 0;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;I)V")
	private void drawInterface(@OriginalArg(0) int py, @OriginalArg(1) int px, @OriginalArg(3) ComType parent, @OriginalArg(4) int scrollY) {
		if (parent.type == 0 && parent.childId != null && (!parent.hide || this.viewportHoveredInterfaceIndex == parent.id || this.sidebarHoveredInterfaceIndex == parent.id || this.chatHoveredInterfaceIndex == parent.id)) {
			@Pc(29) int left = Draw2D.left;
			@Pc(31) int top = Draw2D.top;
			@Pc(33) int right = Draw2D.right;
			@Pc(35) int bottom = Draw2D.bottom;

			Draw2D.setBounds(py + parent.height, py, px + parent.width, px);
			@Pc(57) int children = parent.childId.length;

			for (@Pc(59) int i = 0; i < children; i++) {
				@Pc(68) int x = parent.childX[i] + px;
				@Pc(77) int y = parent.childY[i] + py - scrollY;

				@Pc(84) ComType com = ComType.instances[parent.childId[i]];
				x += com.x;
				y += com.y;

				if (com.contentType > 0) {
					this.updateInterfaceContent(com);
				}

				if (com.type == 0) {
					if (com.scrollPosition > com.scrollableHeight - com.height) {
						com.scrollPosition = com.scrollableHeight - com.height;
					}

					if (com.scrollPosition < 0) {
						com.scrollPosition = 0;
					}

					this.drawInterface(y, x, com, com.scrollPosition);
					if (com.scrollableHeight > com.height) {
						this.drawScrollbar(x + com.width, y, com.scrollPosition, com.scrollableHeight, com.height);
					}
				} else if (com.type == 2) {
					int slot = 0;

					for (int row = 0; row < com.height; row++) {
						for (int col = 0; col < com.width; col++) {
							int slotX = x + col * (com.inventoryMarginX + 32);
							int slotY = y + row * (com.inventoryMarginY + 32);

							if (slot < 20) {
								slotX += com.inventorySlotOffsetX[slot];
								slotY += com.inventorySlotOffsetY[slot];
							}

							if (com.inventorySlotObjId[slot] > 0) {
								int dx = 0;
								int dy = 0;
								int id = com.inventorySlotObjId[slot] - 1;

								if (slotX >= -32 && slotX <= 512 && slotY >= -32 && slotY <= 334 || this.objDragArea != 0 && this.objDragSlot == slot) {
									@Pc(251) Pix24 icon = ObjType.getIcon(id, com.inventorySlotObjCount[slot]);
									if (this.objDragArea != 0 && this.objDragSlot == slot && this.objDragInterfaceId == com.id) {
										dx = super.mouseX - this.objGrabX;
										dy = super.mouseY - this.objGrabY;

										if (dx < 5 && dx > -5) {
											dx = 0;
										}

										if (dy < 5 && dy > -5) {
											dy = 0;
										}

										if (this.objDragCycles < 5) {
											dx = 0;
											dy = 0;
										}

										icon.drawAlpha(128, slotX + dx, slotY + dy);
									} else if (this.selectedArea != 0 && this.selectedItem == slot && this.selectedInterface == com.id) {
										icon.drawAlpha(128, slotX, slotY);
									} else {
										icon.draw(slotY, slotX);
									}

									if (icon.cropW == 33 || com.inventorySlotObjCount[slot] != 1) {
										@Pc(351) int count = com.inventorySlotObjCount[slot];
										this.fontPlain11.drawString(slotX + dx + 1, slotY + 10 + dy, 0, formatObjCount(count));
										this.fontPlain11.drawString(slotX + dx, slotY + 9 + dy, 0xffff00, formatObjCount(count));
									}
								}
							} else if (com.inventorySlotImage != null && slot < 20) {
								@Pc(398) Pix24 image = com.inventorySlotImage[slot];

								if (image != null) {
									image.draw(slotY, slotX);
								}
							}

							slot++;
						}
					}
				} else if (com.type == 3) {
					if (com.fill) {
						Draw2D.fillRect(y, x, com.color, com.width, com.height);
					} else {
						Draw2D.drawRect(x, com.color, com.height, y, com.width);
					}
				} else if (com.type == 4) {
					PixFont font = com.font;
					int color = com.color;
					@Pc(462) String text = com.text;

					if ((this.chatHoveredInterfaceIndex == com.id || this.sidebarHoveredInterfaceIndex == com.id || this.viewportHoveredInterfaceIndex == com.id) && com.hoverColor != 0) {
						color = com.hoverColor;
					}

					if (this.executeInterfaceScript(com)) {
						color = com.activeColor;

						if (com.activeText.length() > 0) {
							text = com.activeText;
						}
					}

					if (com.optionType == 6 && this.pressedContinueOption) {
						text = "Please wait...";
						color = com.color;
					}

					for (int lineY = y + font.height; text.length() > 0; lineY += font.height) {
						if (text.indexOf("%") != -1) {
							do {
								int index = text.indexOf("%1");
								if (index == -1) {
									break;
								}

								text = text.substring(0, index) + this.getIntString(this.executeClientscript1(com, 0)) + text.substring(index + 2);
							} while (true);

							do {
								int index = text.indexOf("%2");
								if (index == -1) {
									break;
								}

								text = text.substring(0, index) + this.getIntString(this.executeClientscript1(com, 1)) + text.substring(index + 2);
							} while (true);

							do {
								int index = text.indexOf("%3");
								if (index == -1) {
									break;
								}

								text = text.substring(0, index) + this.getIntString(this.executeClientscript1(com, 2)) + text.substring(index + 2);
							} while (true);

							do {
								int index = text.indexOf("%4");
								if (index == -1) {
									break;
								}

								text = text.substring(0, index) + this.getIntString(this.executeClientscript1(com, 3)) + text.substring(index + 2);
							} while (true);

							do {
								int index = text.indexOf("%5");
								if (index == -1) {
									break;
								}

								text = text.substring(0, index) + this.getIntString(this.executeClientscript1(com, 4)) + text.substring(index + 2);
							} while (true);
						}

						int newline = text.indexOf("\\n");
						@Pc(704) String split;
                        if (newline != -1) {
                            split = text.substring(0, newline);
                            text = text.substring(newline + 2);
                        } else {
                            split = text;
                            text = "";
                        }

                        if (com.center) {
							font.drawStringTaggableCenter(x + com.width / 2, color, com.shadow, lineY, split);
						} else {
							font.drawStringTaggable(x, lineY, split, com.shadow, color);
						}
					}
				} else if (com.type == 5) {
					@Pc(766) Pix24 image;
					if (this.executeInterfaceScript(com)) {
						image = com.activeImage;
					} else {
						image = com.image;
					}

					if (image != null) {
						image.draw(y, x);
					}
				} else if (com.type == 6) {
					int tmpX = Draw3D.centerX;
					int tmpY = Draw3D.centerY;

					Draw3D.centerX = x + com.width / 2;
					Draw3D.centerY = y + com.height / 2;

					int eyeY = Draw3D.sin[com.modelPitch] * com.modelZoom >> 16;
					int eyeZ = Draw3D.cos[com.modelPitch] * com.modelZoom >> 16;

					@Pc(827) boolean active = this.executeInterfaceScript(com);
					int seqId;
					if (active) {
						seqId = com.activeSeqId;
					} else {
						seqId = com.seqId;
					}

					@Pc(846) Model model;
					if (seqId == -1) {
						model = com.getModel(-1, -1, active);
					} else {
						@Pc(852) SeqType seq = SeqType.instances[seqId];
						model = com.getModel(seq.frames[com.seqFrame], seq.iframes[com.seqFrame], active);
					}

					if (model != null) {
						model.drawSimple(0, com.modelYaw, 0, com.modelPitch, 0, eyeY, eyeZ);
					}

					Draw3D.centerX = tmpX;
					Draw3D.centerY = tmpY;
				} else if (com.type == 7) {
					PixFont font = com.font;
					int slot = 0;
					for (int row = 0; row < com.height; row++) {
						for (int col = 0; col < com.width; col++) {
							if (com.inventorySlotObjId[slot] > 0) {
								@Pc(915) ObjType obj = ObjType.get(com.inventorySlotObjId[slot] - 1);
								@Pc(918) String text = obj.name;
								if (obj.stackable || com.inventorySlotObjCount[slot] != 1) {
									text = text + " x" + formatObjCountTagged(com.inventorySlotObjCount[slot]);
								}

								int textX = x + col * (com.inventoryMarginX + 115);
								int textY = y + row * (com.inventoryMarginY + 12);

								if (com.center) {
									font.drawStringTaggableCenter(textX + com.width / 2, com.color, com.shadow, textY, text);
								} else {
									font.drawStringTaggable(textX, textY, text, com.shadow, com.color);
								}
							}

							slot++;
						}
					}
				}
			}

			Draw2D.setBounds(bottom, top, right, left);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILclient!kb;)V")
	private void readPlayerUpdates(@OriginalArg(1) int size, @OriginalArg(2) Packet buf) {
		for (@Pc(1) int i = 0; i < this.entityUpdateCount; i++) {
			@Pc(8) int index = this.entityUpdateIds[i];
			@Pc(13) PlayerEntity player = this.players[index];
			@Pc(16) int mask = buf.g1();
			if ((mask & 0x80) == 128) {
				mask += buf.g1() << 8;
			}
			this.readPlayerUpdates(index, mask, buf, player);
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(II)V")
	private void updateVarp(@OriginalArg(0) int id) {
		@Pc(8) int clientcode = VarpType.instances[id].clientcode;
		if (clientcode != 0) {
			@Pc(16) int value = this.varps[id];
			if (clientcode == 1) {
				if (value == 1) {
					Draw3D.setBrightness(0.9D);
				}
				if (value == 2) {
					Draw3D.setBrightness(0.8D);
				}
				if (value == 3) {
					Draw3D.setBrightness(0.7D);
				}
				if (value == 4) {
					Draw3D.setBrightness(0.6D);
				}
				ObjType.iconCache.clear();
				this.redrawTitleBackground = true;
			}
			if (clientcode == 3) {
				@Pc(54) boolean lastMidiActive = this.midiActive;
				if (value == 0) {
					this.setMidiVolume(0);
					this.midiActive = true;
				}
				if (value == 1) {
					this.setMidiVolume(-400);
					this.midiActive = true;
				}
				if (value == 2) {
					this.setMidiVolume(-800);
					this.midiActive = true;
				}
				if (value == 3) {
					this.setMidiVolume(-1200);
					this.midiActive = true;
				}
				if (value == 4) {
					this.midiActive = false;
				}
				if (this.midiActive != lastMidiActive) {
					if (this.midiActive) {
						this.setMidi(this.midiCrc, this.currentMidi, this.midiSize);
					} else {
						this.stopMidi();
					}
					this.nextMusicDelay = 0;
				}
			}
			if (clientcode == 4) {
				if (value == 0) {
					this.waveEnabled = true;
					this.setWaveVolume(0);
				}
				if (value == 1) {
					this.waveEnabled = true;
					this.setWaveVolume(-400);
				}
				if (value == 2) {
					this.waveEnabled = true;
					this.setWaveVolume(-800);
				}
				if (value == 3) {
					this.waveEnabled = true;
					this.setWaveVolume(-1200);
				}
				if (value == 4) {
					this.waveEnabled = false;
				}
			}
			if (clientcode == 5) {
				this.mouseButtonsOption = value;
			}
			if (clientcode == 6) {
				this.chatEffects = value;
			}
			if (clientcode == 8) {
				this.splitPrivateChat = value;
				this.redrawChatback = true;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(Z)V")
	private void updateNpcs() {
		for (@Pc(7) int i = 0; i < this.npcCount; i++) {
			@Pc(14) int id = this.npcIds[i];
			@Pc(19) NpcEntity npc = this.npcs[id];
			if (npc != null) {
				this.updateEntity(npc, npc.type.size);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;BI)V")
	private void updateEntity(@OriginalArg(0) PathingEntity entity, @OriginalArg(2) int size) {
		if (entity.x < 128 || entity.z < 128 || entity.x >= 13184 || entity.z >= 13184) {
			entity.primarySeqId = -1;
			entity.spotanimId = -1;
			entity.forceMoveEndCycle = 0;
			entity.forceMoveStartCycle = 0;
			entity.x = entity.pathTileX[0] * 128 + entity.size * 64;
			entity.z = entity.pathTileZ[0] * 128 + entity.size * 64;
			entity.pathLength = 0;
		}
		if (entity == this.localPlayer && (entity.x < 1536 || entity.z < 1536 || entity.x >= 11776 || entity.z >= 11776)) {
			entity.primarySeqId = -1;
			entity.spotanimId = -1;
			entity.forceMoveEndCycle = 0;
			entity.forceMoveStartCycle = 0;
			entity.x = entity.pathTileX[0] * 128 + entity.size * 64;
			entity.z = entity.pathTileZ[0] * 128 + entity.size * 64;
			entity.pathLength = 0;
		}
		if (entity.forceMoveEndCycle > loopCycle) {
			this.updateForceMovement(entity);
		} else if (entity.forceMoveStartCycle >= loopCycle) {
			this.startForceMovement(entity);
		} else {
			this.updateMovement(entity);
		}
		this.updateFacingDirection(entity);
		this.updateSequences(entity);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;I)V")
	private void updateForceMovement(@OriginalArg(0) PathingEntity enttiy) {
		@Pc(4) int delta = enttiy.forceMoveEndCycle - loopCycle;
		@Pc(14) int dstX = enttiy.forceMoveStartSceneTileX * 128 + enttiy.size * 64;
		@Pc(24) int dstZ = enttiy.forceMoveStartSceneTileZ * 128 + enttiy.size * 64;

		enttiy.x += (dstX - enttiy.x) / delta;
		enttiy.z += (dstZ - enttiy.z) / delta;

		enttiy.seqTrigger = 0;

		if (enttiy.forceMoveFaceDirection == 0) {
			enttiy.dstYaw = 1024;
		}

		if (enttiy.forceMoveFaceDirection == 1) {
			enttiy.dstYaw = 1536;
		}

		if (enttiy.forceMoveFaceDirection == 2) {
			enttiy.dstYaw = 0;
		}

		if (enttiy.forceMoveFaceDirection == 3) {
			enttiy.dstYaw = 512;
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!x;I)V")
	private void startForceMovement(@OriginalArg(0) PathingEntity entity) {
		if (entity.forceMoveStartCycle == loopCycle || entity.primarySeqId == -1 || entity.primarySeqDelay != 0 || entity.primarySeqCycle + 1 > SeqType.instances[entity.primarySeqId].delay[entity.primarySeqFrame]) {
			@Pc(35) int duration = entity.forceMoveStartCycle - entity.forceMoveEndCycle;
			@Pc(40) int delta = loopCycle - entity.forceMoveEndCycle;
			@Pc(50) int dx0 = entity.forceMoveStartSceneTileX * 128 + entity.size * 64;
			@Pc(60) int dz0 = entity.forceMoveStartSceneTileZ * 128 + entity.size * 64;
			@Pc(70) int dx1 = entity.forceMoveEndSceneTileX * 128 + entity.size * 64;
			@Pc(80) int dz1 = entity.forceMoveEndSceneTileZ * 128 + entity.size * 64;
			entity.x = (dx0 * (duration - delta) + dx1 * delta) / duration;
			entity.z = (dz0 * (duration - delta) + dz1 * delta) / duration;
		}

		entity.seqTrigger = 0;

		if (entity.forceMoveFaceDirection == 0) {
			entity.dstYaw = 1024;
		}

		if (entity.forceMoveFaceDirection == 1) {
			entity.dstYaw = 1536;
		}

		if (entity.forceMoveFaceDirection == 2) {
			entity.dstYaw = 0;
		}

		if (entity.forceMoveFaceDirection == 3) {
			entity.dstYaw = 512;
		}

		entity.yaw = entity.dstYaw;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!x;)V")
	private void updateMovement(@OriginalArg(1) PathingEntity entity) {
		entity.secondarySeqId = entity.seqStandId;

		if (entity.pathLength == 0) {
			entity.seqTrigger = 0;
			return;
		}

		if (entity.primarySeqId != -1 && entity.primarySeqDelay == 0) {
			@Pc(28) SeqType seq = SeqType.instances[entity.primarySeqId];
			if (seq.labelGroups == null) {
				entity.seqTrigger++;
				return;
			}
		}

		@Pc(41) int x = entity.x;
		@Pc(44) int z = entity.z;
		@Pc(59) int dstX = entity.pathTileX[entity.pathLength - 1] * 128 + entity.size * 64;
		@Pc(74) int dstZ = entity.pathTileZ[entity.pathLength - 1] * 128 + entity.size * 64;

		if (dstX - x <= 256 && dstX - x >= -256 && dstZ - z <= 256 && dstZ - z >= -256) {
			if (x < dstX) {
				if (z < dstZ) {
					entity.dstYaw = 1280;
				} else if (z > dstZ) {
					entity.dstYaw = 1792;
				} else {
					entity.dstYaw = 1536;
				}
			} else if (x > dstX) {
				if (z < dstZ) {
					entity.dstYaw = 768;
				} else if (z > dstZ) {
					entity.dstYaw = 256;
				} else {
					entity.dstYaw = 512;
				}
			} else if (z < dstZ) {
				entity.dstYaw = 1024;
			} else {
				entity.dstYaw = 0;
			}

			@Pc(168) int deltaYaw = entity.dstYaw - entity.yaw & 0x7FF;
			if (deltaYaw > 1024) {
				deltaYaw -= 2048;
			}

			@Pc(175) int seqId = entity.seqTurnAroundId;
			if (deltaYaw >= -256 && deltaYaw <= 256) {
				seqId = entity.seqWalkId;
			} else if (deltaYaw >= 256 && deltaYaw < 768) {
				seqId = entity.seqTurnRightId;
			} else if (deltaYaw >= -768 && deltaYaw <= -256) {
				seqId = entity.seqTurnLeftId;
			}

			if (seqId == -1) {
				seqId = entity.seqWalkId;
			}

			entity.secondarySeqId = seqId;
			@Pc(217) int moveSpeed = 4;
			if (entity.yaw != entity.dstYaw && entity.targetId == -1) {
				moveSpeed = 2;
			}

			if (entity.pathLength > 2) {
				moveSpeed = 6;
			}

			if (entity.pathLength > 3) {
				moveSpeed = 8;
			}

			if (entity.seqTrigger > 0 && entity.pathLength > 1) {
				moveSpeed = 8;
				entity.seqTrigger--;
			}

			if (entity.pathRunning[entity.pathLength - 1]) {
				moveSpeed <<= 0x1;
			}

			if (moveSpeed >= 8 && entity.secondarySeqId == entity.seqWalkId && entity.seqRunId != -1) {
				entity.secondarySeqId = entity.seqRunId;
			}

			if (x < dstX) {
				entity.x += moveSpeed;
				if (entity.x > dstX) {
					entity.x = dstX;
				}
			} else if (x > dstX) {
				entity.x -= moveSpeed;
				if (entity.x < dstX) {
					entity.x = dstX;
				}
			}
			if (z < dstZ) {
				entity.z += moveSpeed;
				if (entity.z > dstZ) {
					entity.z = dstZ;
				}
			} else if (z > dstZ) {
				entity.z -= moveSpeed;
				if (entity.z < dstZ) {
					entity.z = dstZ;
				}
			}

			if (entity.x == dstX && entity.z == dstZ) {
				entity.pathLength--;
			}
		} else {
			entity.x = dstX;
			entity.z = dstZ;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;B)V")
	private void updateFacingDirection(@OriginalArg(0) PathingEntity e) {
		if (e.targetId != -1 && e.targetId < 32768) {
			@Pc(22) NpcEntity npc = this.npcs[e.targetId];
			if (npc != null) {
				int dstX = e.x - npc.x;
				int dstZ = e.z - npc.z;

				if (dstX != 0 || dstZ != 0) {
					e.dstYaw = (int) (Math.atan2(dstX, dstZ) * 325.949D) & 0x7FF;
				}
			}
		}

		if (e.targetId >= 32768) {
			int index = e.targetId - 32768;
			if (index == this.localPid) {
				index = this.LOCAL_PLAYER_INDEX;
			}

			@Pc(73) PlayerEntity player = this.players[index];
			if (player != null) {
				int dstX = e.x - player.x;
				@Pc(87) int dstZ = e.z - player.z;

				if (dstX != 0 || dstZ != 0) {
					e.dstYaw = (int) (Math.atan2(dstX, dstZ) * 325.949D) & 0x7FF;
				}
			}
		}

		if ((e.targetTileX != 0 || e.targetTileZ != 0) && (e.pathLength == 0 || e.seqTrigger > 0)) {
			int dstX = e.x - (e.targetTileX - this.sceneBaseTileX - this.sceneBaseTileX) * 64;
			int dstZ = e.z - (e.targetTileZ - this.sceneBaseTileZ - this.sceneBaseTileZ) * 64;

			if (dstX != 0 || dstZ != 0) {
				e.dstYaw = (int) (Math.atan2(dstX, dstZ) * 325.949D) & 0x7FF;
			}

			e.targetTileX = 0;
			e.targetTileZ = 0;
		}

		int remainingYaw = e.dstYaw - e.yaw & 0x7FF;

		if (remainingYaw != 0) {
			if (remainingYaw < 32 || remainingYaw > 2016) {
				e.yaw = e.dstYaw;
			} else if (remainingYaw > 1024) {
				e.yaw -= 32;
			} else {
				e.yaw += 32;
			}

			e.yaw &= 0x7ff;

			if (e.secondarySeqId == e.seqStandId && e.yaw != e.dstYaw) {
				if (e.seqTurnId != -1) {
					e.secondarySeqId = e.seqTurnId;
					return;
				}

				e.secondarySeqId = e.seqWalkId;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!x;)V")
	private void updateSequences(@OriginalArg(1) PathingEntity e) {
		e.seqStretches = false;

		@Pc(16) SeqType seq;
		if (e.secondarySeqId != -1) {
			seq = SeqType.instances[e.secondarySeqId];
			e.secondarySeqCycle++;
			if (e.secondarySeqFrame < seq.frameCount && e.secondarySeqCycle > seq.delay[e.secondarySeqFrame]) {
				e.secondarySeqCycle = 0;
				e.secondarySeqFrame++;
			}
			if (e.secondarySeqFrame >= seq.frameCount) {
				e.secondarySeqCycle = 0;
				e.secondarySeqFrame = 0;
			}
		}

		if (e.primarySeqId != -1 && e.primarySeqDelay == 0) {
			seq = SeqType.instances[e.primarySeqId];
			e.primarySeqCycle++;
			while (e.primarySeqFrame < seq.frameCount && e.primarySeqCycle > seq.delay[e.primarySeqFrame]) {
				e.primarySeqCycle -= seq.delay[e.primarySeqFrame];
				e.primarySeqFrame++;
			}

			if (e.primarySeqFrame >= seq.frameCount) {
				e.primarySeqFrame -= seq.replayoff;
				e.primarySeqLoop++;
				if (e.primarySeqLoop >= seq.replaycount) {
					e.primarySeqId = -1;
				}
				if (e.primarySeqFrame < 0 || e.primarySeqFrame >= seq.frameCount) {
					e.primarySeqId = -1;
				}
			}

			e.seqStretches = seq.stretches;
		}

		if (e.primarySeqDelay > 0) {
			e.primarySeqDelay--;
		}

		if (e.spotanimId != -1 && loopCycle >= e.spotanimLastCycle) {
			if (e.spotanimFrame < 0) {
				e.spotanimFrame = 0;
			}

			seq = SpotAnimType.instances[e.spotanimId].seq;
			e.spotanimCycle++;
			while (e.spotanimFrame < seq.frameCount && e.spotanimCycle > seq.delay[e.spotanimFrame]) {
				e.spotanimCycle -= seq.delay[e.spotanimFrame];
				e.spotanimFrame++;
			}

			if (e.spotanimFrame >= seq.frameCount) {
				if (e.spotanimFrame < 0 || e.spotanimFrame >= seq.frameCount) {
					e.spotanimId = -1;
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
		@Pc(152) boolean redraw;
		if (this.sidebarInterfaceId != -1) {
			redraw = this.updateInterfaceAnimation(this.sidebarInterfaceId, this.sceneDelta);
			if (redraw) {
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
			@Pc(234) int offset = this.chatScrollHeight - this.chatInterface.scrollPosition - 77;
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
		if (this.chatInterfaceId != -1) {
			redraw = this.updateInterfaceAnimation(this.chatInterfaceId, this.sceneDelta);
			if (redraw) {
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
	private boolean isAddFriendOption(@OriginalArg(1) int option) {
		if (option < 0) {
			return false;
		}
		@Pc(8) int action = this.menuAction[option];
		if (action >= 2000) {
			action -= 2000;
		}
		return action == 406;
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(II)V")
	private void useMenuOption(@OriginalArg(1) int optionId) {
        if (optionId < 0) {
            return;
        }

        if (this.chatbackInputOpen) {
            this.chatbackInputOpen = false;
            this.redrawChatback = true;
        }

		@Pc(28) int action = this.menuAction[optionId];
		@Pc(33) int a = this.menuParamA[optionId];
        @Pc(18) int b = this.menuParamB[optionId];
        @Pc(23) int c = this.menuParamC[optionId];

        if (action >= 2000) {
            action -= 2000;
        }

        if (action == 903 || action == 363) {
            String option = this.menuOption[optionId];
			int tag = option.indexOf("@whi@");

            if (tag != -1) {
                option = option.substring(tag + 5).trim();
                String name = JString.formatName(JString.fromBase37(JString.toBase37(option)));
                @Pc(71) boolean found = false;

                for (int i = 0; i < this.playerCount; i++) {
                    @Pc(83) PlayerEntity player = this.players[this.playerIds[i]];

                    if (player != null && player.name != null && player.name.equalsIgnoreCase(name)) {
                        this.tryMove(this.localPlayer.pathTileX[0], 1, false, player.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, player.pathTileZ[0], 0, 0, 0);

                        if (action == 903) {
                            this.out.p1isaac(206);
                        } else if (action == 363) {
                            this.out.p1isaac(164);
                        }

                        this.out.p2(this.playerIds[i]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    this.addMessage(0, "Unable to find " + name, "");
                }
            }
        }

        if (action == 450 && this.interactWithLoc(75, b, c, a)) {
            this.out.p2(this.objInterface);
            this.out.p2(this.objSelectedSlot);
            this.out.p2(this.objSelectedInterface);
        }

        if (action == 405 || action == 38 || action == 422 || action == 478 || action == 347) {
            if (action == 478) {
                if ((b & 0x3) == 0) {
                    opHeld1Counter++;
                }

                if (opHeld1Counter >= 90) {
                    this.out.p1isaac(220);
                }

                this.out.p1isaac(157);
            }

            if (action == 347) {
                this.out.p1isaac(211);
            }

            if (action == 422) {
                this.out.p1isaac(133);
            }

            if (action == 405) {
                opHeld4Counter += a;
                if (opHeld4Counter >= 97) {
                    this.out.p1isaac(30);
                    this.out.p3(14953816);
                }
                this.out.p1isaac(195);
            }

            if (action == 38) {
                this.out.p1isaac(71);
            }

            this.out.p2(a);
            this.out.p2(b);
            this.out.p2(c);
            this.selectedCycle = 0;
            this.selectedInterface = c;
            this.selectedItem = b;
            this.selectedArea = 2;

            if (ComType.instances[c].parentId == this.viewportInterfaceID) {
                this.selectedArea = 1;
            }

            if (ComType.instances[c].parentId == this.chatInterfaceId) {
                this.selectedArea = 3;
            }
        }

        if (action == 728 || action == 542 || action == 6 || action == 963 || action == 245) {
            NpcEntity npc = this.npcs[a];
            if (npc != null) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, npc.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, npc.pathTileZ[0], 0, 0, 0);

                this.crossX = super.mouseClickX;
                this.crossY = super.mouseClickY;
                this.crossMode = 2;
                this.crossCycle = 0;

                if (action == 542) {
                    this.out.p1isaac(8);
                }

                if (action == 6) {
                    if ((a & 0x3) == 0) {
                        opNpc3Counter++;
                    }

                    if (opNpc3Counter >= 124) {
                        this.out.p1isaac(88);
                        this.out.p4(0);
                    }

                    this.out.p1isaac(27);
                }

                if (action == 963) {
                    this.out.p1isaac(113);
                }

                if (action == 728) {
                    this.out.p1isaac(194);
                }

                if (action == 245) {
                    if ((a & 0x3) == 0) {
                        opNpc5Counter++;
                    }

                    if (opNpc5Counter >= 85) {
                        this.out.p1isaac(176);
                        this.out.p2(39596);
                    }

                    this.out.p1isaac(100);
                }

                this.out.p2(a);
            }
        }

        if (action == 217) {
            boolean success = this.tryMove(this.localPlayer.pathTileX[0], 0, false, b, this.localPlayer.pathTileZ[0], 2, 0, c, 0, 0, 0);
            if (!success) {
                this.tryMove(this.localPlayer.pathTileX[0], 1, false, b, this.localPlayer.pathTileZ[0], 2, 1, c, 0, 0, 0);
            }

            this.crossX = super.mouseClickX;
            this.crossY = super.mouseClickY;
            this.crossMode = 2;
            this.crossCycle = 0;

            this.out.p1isaac(239);
            this.out.p2(b + this.sceneBaseTileX);
            this.out.p2(c + this.sceneBaseTileZ);
            this.out.p2(a);
            this.out.p2(this.objInterface);
            this.out.p2(this.objSelectedSlot);
            this.out.p2(this.objSelectedInterface);
        }

        if (action == 1175) {
            @Pc(586) int locId = a >> 14 & 0x7FFF;
            @Pc(589) LocType loc = LocType.get(locId);

			String examine;
            if (loc.desc == null) {
				examine = "It's a " + loc.name + ".";
            } else {
				examine = loc.desc;
            }

            this.addMessage(0, examine, "");
        }

        if (action == 285) {
            this.interactWithLoc(245, b, c, a);
        }

        if (action == 881) {
            this.out.p1isaac(130);
            this.out.p2(a);
            this.out.p2(b);
            this.out.p2(c);
            this.out.p2(this.objInterface);
            this.out.p2(this.objSelectedSlot);
            this.out.p2(this.objSelectedInterface);

            this.selectedCycle = 0;
            this.selectedInterface = c;
            this.selectedItem = b;
            this.selectedArea = 2;

            if (ComType.instances[c].parentId == this.viewportInterfaceID) {
                this.selectedArea = 1;
            }

            if (ComType.instances[c].parentId == this.chatInterfaceId) {
                this.selectedArea = 3;
            }
        }

        if (action == 391) {
            this.out.p1isaac(48);
            this.out.p2(a);
            this.out.p2(b);
            this.out.p2(c);
            this.out.p2(this.activeSpellId);

            this.selectedCycle = 0;
            this.selectedInterface = c;
            this.selectedItem = b;
            this.selectedArea = 2;

            if (ComType.instances[c].parentId == this.viewportInterfaceID) {
                this.selectedArea = 1;
            }

            if (ComType.instances[c].parentId == this.chatInterfaceId) {
                this.selectedArea = 3;
            }
        }

        if (action == 660) {
            if (this.menuVisible) {
                this.scene.click(c - 11, b - 8);
            } else {
                this.scene.click(super.mouseClickY - 11, super.mouseClickX - 8);
            }
        }

        if (action == 188) {
            this.objSelected = 1;
            this.objSelectedSlot = b;
            this.objSelectedInterface = c;
            this.objInterface = a;
            this.objSelectedName = ObjType.get(a).name;
            this.spellSelected = 0;
        }

		if (action == 44 && !this.pressedContinueOption) {
			this.out.p1isaac(235);
			this.out.p2(c);
			this.pressedContinueOption = true;
		}

		if (action == 1773) {
			ObjType obj = ObjType.get(a);
			String examine;

			if (c >= 100000) {
				examine = c + " x " + obj.name;
			} else if (obj.desc == null) {
				examine = "It's a " + obj.name + ".";
			} else {
				examine = obj.desc;
			}

			this.addMessage(0, examine, "");
		}

		if (action == 900) {
			NpcEntity npc = this.npcs[a];
			if (npc != null) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, npc.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, npc.pathTileZ[0], 0, 0, 0);
				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;
				this.out.p1isaac(202);
				this.out.p2(a);
				this.out.p2(this.objInterface);
				this.out.p2(this.objSelectedSlot);
				this.out.p2(this.objSelectedInterface);
			}
		}

		if (action == 1373 || action == 1544 || action == 151 || action == 1101) {
			PlayerEntity player = this.players[a];
			if (player != null) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, player.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, player.pathTileZ[0], 0, 0, 0);

				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;

				if (action == 1101) {
					this.out.p1isaac(164);
				}

				if (action == 151) {
					opPlayer2Counter++;
					if (opPlayer2Counter >= 90) {
						this.out.p1isaac(2);
						this.out.p2(31114);
					}
					this.out.p1isaac(53);
				}

				if (action == 1373) {
					this.out.p1isaac(206);
				}

				if (action == 1544) {
					this.out.p1isaac(185);
				}

				this.out.p2(a);
			}
		}

		if (action == 265) {
			NpcEntity npc = this.npcs[a];
			if (npc != null) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, npc.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, npc.pathTileZ[0], 0, 0, 0);

				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;

				this.out.p1isaac(134);
				this.out.p2(a);
				this.out.p2(this.activeSpellId);
			}
		}

		if (action == 679) {
			String option = this.menuOption[optionId];
			int tag = option.indexOf("@whi@");
			if (tag != -1) {
				long name37 = JString.toBase37(option.substring(tag + 5).trim());
				int friend = -1;
				for (@Pc(1160) int i = 0; i < this.friendCount; i++) {
					if (this.friendName37[i] == name37) {
						friend = i;
						break;
					}
				}

				if (friend != -1 && this.friendWorld[friend] > 0) {
					this.redrawChatback = true;
					this.chatbackInputOpen = false;
					this.showSocialInput = true;
					this.socialInput = "";
					this.socialAction = 3;
					this.socialName37 = this.friendName37[friend];
					this.socialMessage = "Enter message to send to " + this.friendName[friend];
				}
			}
		}

		if (action == 55 && this.interactWithLoc(9, b, c, a)) {
			this.out.p2(this.activeSpellId);
		}

		if (action == 224 || action == 993 || action == 99 || action == 746 || action == 877) {
			boolean success = this.tryMove(this.localPlayer.pathTileX[0], 0, false, b, this.localPlayer.pathTileZ[0], 2, 0, c, 0, 0, 0);
			if (!success) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, b, this.localPlayer.pathTileZ[0], 2, 1, c, 0, 0, 0);
			}

			this.crossX = super.mouseClickX;
			this.crossY = super.mouseClickY;
			this.crossMode = 2;
			this.crossCycle = 0;

			if (action == 224) {
				this.out.p1isaac(140);
			}

			if (action == 746) {
				this.out.p1isaac(178);
			}

			if (action == 877) {
				this.out.p1isaac(247);
			}

			if (action == 99) {
				this.out.p1isaac(200);
			}

			if (action == 993) {
				this.out.p1isaac(40);
			}

			this.out.p2(b + this.sceneBaseTileX);
			this.out.p2(c + this.sceneBaseTileZ);
			this.out.p2(a);
		}

		if (action == 1607) {
			NpcEntity npc = this.npcs[a];
			if (npc != null) {
				String examine;

				if (npc.type.desc == null) {
					examine = "It's a " + npc.type.name + ".";
				} else {
					examine = npc.type.desc;
				}

				this.addMessage(0, examine, "");
			}
		}

		if (action == 504) {
			this.interactWithLoc(172, b, c, a);
		}

		if (action == 930) {
			ComType com = ComType.instances[c];
			this.spellSelected = 1;
			this.activeSpellId = c;
			this.activeSpellFlags = com.spellFlags;
			this.objSelected = 0;

			String prefix = com.spellAction;
			if (prefix.indexOf(" ") != -1) {
				prefix = prefix.substring(0, prefix.indexOf(" "));
			}

			String suffix = com.spellAction;
			if (suffix.indexOf(" ") != -1) {
				suffix = suffix.substring(suffix.indexOf(" ") + 1);
			}

			this.spellCaption = prefix + " " + com.spellName + " " + suffix;
			if (this.activeSpellFlags == 16) {
				this.redrawSidebar = true;
				this.selectedTab = 3;
				this.redrawSideicons = true;
			}
		}

		if (action == 951) {
			ComType com = ComType.instances[c];
			@Pc(1513) boolean notify = true;

			if (com.contentType > 0) {
				notify = this.handleInterfaceAction(com);
			}

			if (notify) {
				this.out.p1isaac(155);
				this.out.p2(c);
			}
		}

		if (action == 602 || action == 596 || action == 22 || action == 892 || action == 415) {
			if (action == 22) {
				this.out.p1isaac(212);
			}

			if (action == 415) {
				if ((c & 0x3) == 0) {
					ifButton5Counter++;
				}
				if (ifButton5Counter >= 55) {
					this.out.p1isaac(17);
					this.out.p4(0);
				}
				this.out.p1isaac(6);
			}

			if (action == 602) {
				this.out.p1isaac(31);
			}

			if (action == 892) {
				if ((b & 0x3) == 0) {
					opHeld9Counter++;
				}

				if (opHeld9Counter >= 130) {
					this.out.p1isaac(238);
					this.out.p1(177);
				}

				this.out.p1isaac(38);
			}

			if (action == 596) {
				this.out.p1isaac(59);
			}

			this.out.p2(a);
			this.out.p2(b);
			this.out.p2(c);

			this.selectedCycle = 0;
			this.selectedInterface = c;
			this.selectedItem = b;
			this.selectedArea = 2;

			if (ComType.instances[c].parentId == this.viewportInterfaceID) {
				this.selectedArea = 1;
			}

			if (ComType.instances[c].parentId == this.chatInterfaceId) {
				this.selectedArea = 3;
			}
		}
		if (action == 581) {
			if ((a & 0x3) == 0) {
				opLoc4Counter++;
			}

			if (opLoc4Counter >= 99) {
				this.out.p1isaac(7);
				this.out.p4(0);
			}

			this.interactWithLoc(97, b, c, a);
		}

		if (action == 965) {
			boolean success = this.tryMove(this.localPlayer.pathTileX[0], 0, false, b, this.localPlayer.pathTileZ[0], 2, 0, c, 0, 0, 0);
			if (!success) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, b, this.localPlayer.pathTileZ[0], 2, 1, c, 0, 0, 0);
			}

			this.crossX = super.mouseClickX;
			this.crossY = super.mouseClickY;
			this.crossMode = 2;
			this.crossCycle = 0;

			this.out.p1isaac(138);
			this.out.p2(b + this.sceneBaseTileX);
			this.out.p2(c + this.sceneBaseTileZ);
			this.out.p2(a);
			this.out.p2(this.activeSpellId);
		}
		if (action == 1501) {
			opLoc5Counter += this.sceneBaseTileZ;
			if (opLoc5Counter >= 92) {
				this.out.p1isaac(66);
				this.out.p4(0);
			}

			this.interactWithLoc(116, b, c, a);
		}

		if (action == 364) {
			this.interactWithLoc(96, b, c, a);
		}

		if (action == 1102) {
			ObjType obj = ObjType.get(a);
			String examine;

			if (obj.desc == null) {
				examine = "It's a " + obj.name + ".";
			} else {
				examine = obj.desc;
			}
			this.addMessage(0, examine, "");
		}
		if (action == 960) {
			this.out.p1isaac(155);
			this.out.p2(c);

			ComType com = ComType.instances[c];
			if (com.scripts != null && com.scripts[0][0] == 5) {
				int varp = com.scripts[0][1];
				if (this.varps[varp] != com.scriptOperand[0]) {
					this.varps[varp] = com.scriptOperand[0];
					this.updateVarp(varp);
					this.redrawSidebar = true;
				}
			}
		}

		if (action == 34) {
			String option = this.menuOption[optionId];
			int tag = option.indexOf("@whi@");
			if (tag != -1) {
				this.closeInterfaces();
				this.reportAbuseInput = option.substring(tag + 5).trim();
				this.reportAbuseMuteOption = false;
				for (@Pc(1957) int i = 0; i < ComType.instances.length; i++) {
					if (ComType.instances[i] != null && ComType.instances[i].contentType == 600) {
						this.reportAbuseInterfaceID = this.viewportInterfaceID = ComType.instances[i].parentId;
						break;
					}
				}
			}
		}

		if (action == 947) {
			this.closeInterfaces();
		}

		if (action == 367) {
			PlayerEntity player = this.players[a];
			if (player != null) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, player.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, player.pathTileZ[0], 0, 0, 0);
				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;
				this.out.p1isaac(248);
				this.out.p2(a);
				this.out.p2(this.objInterface);
				this.out.p2(this.objSelectedSlot);
				this.out.p2(this.objSelectedInterface);
			}
		}

		if (action == 465) {
			this.out.p1isaac(155);
			this.out.p2(c);

			ComType com = ComType.instances[c];
			if (com.scripts != null && com.scripts[0][0] == 5) {
				int varp = com.scripts[0][1];
				this.varps[varp] = 1 - this.varps[varp];
				this.updateVarp(varp);
				this.redrawSidebar = true;
			}
		}

		if (action == 406 || action == 436 || action == 557 || action == 556) {
			String option = this.menuOption[optionId];
			int tag = option.indexOf("@whi@");
			if (tag != -1) {
				long username = JString.toBase37(option.substring(tag + 5).trim());
				if (action == 406) {
					this.addFriend(username);
				}

				if (action == 436) {
					this.addIgnore(username);
				}

				if (action == 557) {
					this.removeFriend(username);
				}

				if (action == 556) {
					this.removeIgnore(username);
				}
			}
		}

		if (action == 651) {
			PlayerEntity player = this.players[a];
			if (player != null) {
				this.tryMove(this.localPlayer.pathTileX[0], 1, false, player.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, player.pathTileZ[0], 0, 0, 0);
				this.crossX = super.mouseClickX;
				this.crossY = super.mouseClickY;
				this.crossMode = 2;
				this.crossCycle = 0;
				this.out.p1isaac(177);
				this.out.p2(a);
				this.out.p2(this.activeSpellId);
			}
		}

		this.objSelected = 0;
		this.spellSelected = 0;
    }

	@OriginalMember(owner = "client!client", name = "s", descriptor = "(I)Ljava/lang/String;")
	private String getHost() {
		if (signlink.mainapp == null) {
			return super.frame == null ? super.getDocumentBase().getHost().toLowerCase() : "runescape.com";
		} else {
			return signlink.mainapp.getDocumentBase().getHost().toLowerCase();
		}
	}

	@OriginalMember(owner = "client!client", name = "t", descriptor = "(I)V")
	private void drawMenu() {
		@Pc(2) int x = this.menuX;
		@Pc(5) int y = this.menuY;
		@Pc(8) int w = this.menuWidth;
		@Pc(11) int h = this.menuHeight;
		@Pc(13) int background = 0x5d5447;
		Draw2D.fillRect(y, x, background, w, h);
		Draw2D.fillRect(y + 1, x + 1, 0, w - 2, 16);
		Draw2D.drawRect(x + 1, 0, h - 19, y + 18, w - 2);

		this.fontBold12.drawString(x + 3, y + 14, background, "Choose Option");
		@Pc(63) int mouseX = super.mouseX;
		@Pc(66) int mouseY = super.mouseY;
		if (this.menuArea == 0) {
			mouseX -= 8;
			mouseY -= 11;
		}
		if (this.menuArea == 1) {
			mouseX -= 562;
			mouseY -= 231;
		}
		if (this.menuArea == 2) {
			mouseX -= 22;
			mouseY -= 375;
		}

		for (@Pc(85) int i = 0; i < this.menuSize; i++) {
			@Pc(100) int optionY = y + (this.menuSize - 1 - i) * 15 + 31;
			@Pc(102) int rgb = 0xffffff;
			if (mouseX > x && mouseX < x + w && mouseY > optionY - 13 && mouseY < optionY + 3) {
				rgb = 0xffff00;
			}
			this.fontBold12.drawStringTaggable(x + 3, optionY, this.menuOption[i], true, rgb);
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(III)V")
	private void handlePrivateChatInput(@OriginalArg(0) int mouseX, @OriginalArg(2) int mouseY) {
		if (this.splitPrivateChat != 0) {
			@Pc(5) int lineOffset = 0;
			if (this.systemUpdateTimer != 0) {
				lineOffset = 1;
			}
			for (@Pc(12) int i = 0; i < 100; i++) {
				if (this.messageText[i] != null) {
					@Pc(24) int type = this.messageType[i];
					if ((type == 3 || type == 7) && (type == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
						@Pc(54) int y = 329 - lineOffset * 13;
						if (super.mouseX > 8 && super.mouseX < 520 && mouseY - 11 > y - 10 && mouseY - 11 <= y + 3) {
							if (this.rights) {
								this.menuOption[this.menuSize] = "Report abuse @whi@" + this.messageSender[i];
								this.menuAction[this.menuSize] = 2034;
								this.menuSize++;
							}
							this.menuOption[this.menuSize] = "Add ignore @whi@" + this.messageSender[i];
							this.menuAction[this.menuSize] = 2436;
							this.menuSize++;
							this.menuOption[this.menuSize] = "Add friend @whi@" + this.messageSender[i];
							this.menuAction[this.menuSize] = 2406;
							this.menuSize++;
						}
						lineOffset++;
						if (lineOffset >= 5) {
							return;
						}
					}
					if ((type == 5 || type == 6) && this.privateChatSetting < 2) {
						lineOffset++;
						if (lineOffset >= 5) {
							return;
						}
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!hc;)V")
	private void updateInterfaceContent(@OriginalArg(1) ComType component) {
		@Pc(4) int contentType = component.contentType;
		if (contentType >= 1 && contentType <= 100) {
			contentType--;
			if (contentType >= this.friendCount) {
				component.text = "";
				component.optionType = 0;
			} else {
				component.text = this.friendName[contentType];
				component.optionType = 1;
			}
		} else if (contentType >= 101 && contentType <= 200) {
			contentType -= 101;
			if (contentType >= this.friendCount) {
				component.text = "";
				component.optionType = 0;
			} else {
				if (this.friendWorld[contentType] == 0) {
					component.text = "@red@Offline";
				} else if (this.friendWorld[contentType] == nodeId) {
					component.text = "@gre@World-" + (this.friendWorld[contentType] - 9);
				} else {
					component.text = "@yel@World-" + (this.friendWorld[contentType] - 9);
				}
				component.optionType = 1;
			}
		} else if (contentType == 203) {
			component.scrollableHeight = this.friendCount * 15 + 20;
			if (component.scrollableHeight <= component.height) {
				component.scrollableHeight = component.height + 1;
			}
		} else if (contentType >= 401 && contentType <= 500) {
			contentType -= 401;
			if (contentType >= this.ignoreCount) {
				component.text = "";
				component.optionType = 0;
			} else {
				component.text = JString.formatName(JString.fromBase37(this.ignoreName37[contentType]));
				component.optionType = 1;
			}
		} else if (contentType == 503) {
			component.scrollableHeight = this.ignoreCount * 15 + 20;
			if (component.scrollableHeight <= component.height) {
				component.scrollableHeight = component.height + 1;
			}
		} else if (contentType == 327) {
			component.modelPitch = 150;
			component.modelYaw = (int) (Math.sin((double) loopCycle / 40.0D) * 256.0D) & 0x7FF;
			if (this.updateDesignModel) {
				this.updateDesignModel = false;

				@Pc(209) Model[] models = new Model[7];
				@Pc(211) int modelCount = 0;
				for (@Pc(213) int part = 0; part < 7; part++) {
					@Pc(220) int kit = this.designIdentikits[part];
					if (kit >= 0) {
						models[modelCount++] = IdkType.instances[kit].getModel();
					}
				}

				@Pc(241) Model model = new Model(models, modelCount);
				for (@Pc(243) int part = 0; part < 5; part++) {
					if (this.designColors[part] != 0) {
						model.recolor(PlayerEntity.DESIGN_BODY_COLOR[part][0], PlayerEntity.DESIGN_BODY_COLOR[part][this.designColors[part]]);
						if (part == 1) {
							model.recolor(PlayerEntity.DESIGN_HAIR_COLOR[0], PlayerEntity.DESIGN_HAIR_COLOR[this.designColors[part]]);
						}
					}
				}

				model.createLabelReferences();
				model.applyTransform(SeqType.instances[this.localPlayer.seqStandId].frames[0]);
				model.calculateNormals(64, 850, -30, -50, -30, true);
				component.model = model;
			}
		} else if (contentType == 324) {
			if (this.genderButtonImage0 == null) {
				this.genderButtonImage0 = component.image;
				this.genderButtonImage1 = component.activeImage;
			}
			if (this.designGenderMale) {
				component.image = this.genderButtonImage1;
			} else {
				component.image = this.genderButtonImage0;
			}
		} else if (contentType == 325) {
			if (this.genderButtonImage0 == null) {
				this.genderButtonImage0 = component.image;
				this.genderButtonImage1 = component.activeImage;
			}
			if (this.designGenderMale) {
				component.image = this.genderButtonImage0;
			} else {
				component.image = this.genderButtonImage1;
			}
		} else if (contentType == 600) {
			component.text = this.reportAbuseInput;
			if (loopCycle % 20 < 10) {
				component.text = component.text + "|";
			} else {
				component.text = component.text + " ";
			}
		} else if (contentType == 613) {
			if (!this.rights) {
				component.text = "";
			} else if (this.reportAbuseMuteOption) {
				component.color = 16711680;
				component.text = "Moderator option: Mute player for 48 hours: <ON>";
			} else {
				component.color = 16777215;
				component.text = "Moderator option: Mute player for 48 hours: <OFF>";
			}
		} else if (contentType == 650 || contentType == 655) {
			if (this.lastAddress == 0) {
				component.text = "";
			} else {
				String text;
				if (this.daysSinceLastLogin == 0) {
					text = "earlier today";
				} else if (this.daysSinceLastLogin == 1) {
					text = "yesterday";
				} else {
					text = this.daysSinceLastLogin + " days ago";
				}
				component.text = "You last logged in " + text + " from: " + signlink.dns;
			}
		} else if (contentType == 651) {
			if (this.unreadMessages == 0) {
				component.text = "0 unread messages";
				component.color = 16776960;
			}
			if (this.unreadMessages == 1) {
				component.text = "1 unread message";
				component.color = 65280;
			}
			if (this.unreadMessages > 1) {
				component.text = this.unreadMessages + " unread messages";
				component.color = 65280;
			}
		} else if (contentType == 652) {
			if (this.daysSinceRecoveriesChanged == 201) {
				component.text = "";
			} else if (this.daysSinceRecoveriesChanged == 200) {
				component.text = "You have not yet set any password recovery questions.";
			} else {
				String text;
				if (this.daysSinceRecoveriesChanged == 0) {
					text = "Earlier today";
				} else if (this.daysSinceRecoveriesChanged == 1) {
					text = "Yesterday";
				} else {
					text = this.daysSinceRecoveriesChanged + " days ago";
				}
				component.text = text + " you changed your recovery questions";
			}
		} else if (contentType == 653) {
			if (this.daysSinceRecoveriesChanged == 201) {
				component.text = "";
			} else if (this.daysSinceRecoveriesChanged == 200) {
				component.text = "We strongly recommend you do so now to secure your account.";
			} else {
				component.text = "If you do not remember making this change then cancel it immediately";
			}
		} else if (contentType == 654) {
			if (this.daysSinceRecoveriesChanged == 201) {
				component.text = "";
			} else if (this.daysSinceRecoveriesChanged == 200) {
				component.text = "Do this from the 'account management' area on our front webpage";
			} else {
				component.text = "Do this from the 'account management' area on our front webpage";
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BII)Z")
	private boolean saveWave(@OriginalArg(0) byte[] src, @OriginalArg(1) int length) {
		return src == null || signlink.wavesave(src, length);
	}

	@OriginalMember(owner = "client!client", name = "u", descriptor = "(I)Z")
	private boolean replayWave() {
		return signlink.wavereplay();
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(II)V")
	private void setWaveVolume(@OriginalArg(0) int volume) {
		signlink.wavevol = volume;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!kb;I)V")
	private void readNewNpcs(@OriginalArg(1) Packet buf, @OriginalArg(2) int size) {
		while (buf.bitPos + 21 < size * 8) {
			@Pc(16) int index = buf.gBit(13);
			if (index == 8191) {
				break;
			}
			if (this.npcs[index] == null) {
				this.npcs[index] = new NpcEntity();
			}
			@Pc(36) NpcEntity npc = this.npcs[index];
			this.npcIds[this.npcCount++] = index;
			npc.cycle = loopCycle;
			npc.type = NpcType.get(buf.gBit(11));
			npc.size = npc.type.size;
			npc.seqWalkId = npc.type.walkanim;
			npc.seqTurnAroundId = npc.type.walkanim_b;
			npc.seqTurnLeftId = npc.type.walkanim_r;
			npc.seqTurnRightId = npc.type.walkanim_l;
			npc.seqStandId = npc.type.readyanim;
			@Pc(92) int dx = buf.gBit(5);
			if (dx > 15) {
				dx -= 32;
			}
			@Pc(101) int dz = buf.gBit(5);
			if (dz > 15) {
				dz -= 32;
			}
			npc.move(false, this.localPlayer.pathTileX[0] + dx, this.localPlayer.pathTileZ[0] + dz);
			@Pc(128) int update = buf.gBit(1);
			if (update == 1) {
				this.entityUpdateIds[this.entityUpdateCount++] = index;
			}
		}
		buf.accessBytes();
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!hc;)Z")
	private boolean handleInterfaceAction(@OriginalArg(1) ComType component) {
		@Pc(4) int contentType = component.contentType;
		if (contentType == 201) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
			this.showSocialInput = true;
			this.socialInput = "";
			this.socialAction = 1;
			this.socialMessage = "Enter name of friend to add to list";
		}

		if (contentType == 202) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
			this.showSocialInput = true;
			this.socialInput = "";
			this.socialAction = 2;
			this.socialMessage = "Enter name of friend to delete from list";
		}

		if (contentType == 205) {
			this.idleTimeout = 250;
			return true;
		}

		if (contentType == 501) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
			this.showSocialInput = true;
			this.socialInput = "";
			this.socialAction = 4;
			this.socialMessage = "Enter name of player to add to list";
		}

		if (contentType == 502) {
			this.redrawChatback = true;
			this.chatbackInputOpen = false;
			this.showSocialInput = true;
			this.socialInput = "";
			this.socialAction = 5;
			this.socialMessage = "Enter name of player to delete from list";
		}

		if (contentType >= 300 && contentType <= 313) {
			int part = (contentType - 300) / 2;
			int direction = contentType & 0x1;
			int kit = this.designIdentikits[part];

			if (kit != -1) {
				while (true) {
					if (direction == 0) {
						kit--;
						if (kit < 0) {
							kit = IdkType.count - 1;
						}
					}

					if (direction == 1) {
						kit++;
						if (kit >= IdkType.count) {
							kit = 0;
						}
					}

					if (!IdkType.instances[kit].disable && IdkType.instances[kit].type == part + (this.designGenderMale ? 0 : 7)) {
						this.designIdentikits[part] = kit;
						this.updateDesignModel = true;
						break;
					}
				}
			}
		}

		if (contentType >= 314 && contentType <= 323) {
			int part = (contentType - 314) / 2;
			int direction = contentType & 0x1;
			int color = this.designColors[part];

			if (direction == 0) {
				color--;
				if (color < 0) {
					color = PlayerEntity.DESIGN_BODY_COLOR[part].length - 1;
				}
			}

			if (direction == 1) {
				color++;
				if (color >= PlayerEntity.DESIGN_BODY_COLOR[part].length) {
					color = 0;
				}
			}

			this.designColors[part] = color;
			this.updateDesignModel = true;
		}

		if (contentType == 324 && !this.designGenderMale) {
			this.designGenderMale = true;
			this.validateCharacterDesign();
		}

		if (contentType == 325 && this.designGenderMale) {
			this.designGenderMale = false;
			this.validateCharacterDesign();
		}

		if (contentType == 326) {
			this.out.p1isaac(52);
			this.out.p1(this.designGenderMale ? 0 : 1);
			for (int i = 0; i < 7; i++) {
				this.out.p1(this.designIdentikits[i]);
			}
			for (int i = 0; i < 5; i++) {
				this.out.p1(this.designColors[i]);
			}
			return true;
		}

		if (contentType == 613) {
			this.reportAbuseMuteOption = !this.reportAbuseMuteOption;
		}

		if (contentType >= 601 && contentType <= 612) {
			this.closeInterfaces();
			if (this.reportAbuseInput.length() > 0) {
				this.out.p1isaac(190);
				this.out.p8(JString.toBase37(this.reportAbuseInput));
				this.out.p1(contentType - 601);
				this.out.p1(this.reportAbuseMuteOption ? 1 : 0);
			}
		}

		return false;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "()V")
	@Override
	protected void load() {
		if (signlink.sunjava) {
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

		@Pc(34) boolean good = this.frame != null;
		@Pc(38) String host = this.getHost();
		if (host.endsWith("2004scape.org")) {
			good = true;
		}
		if (host.endsWith("localhost")) {
			good = true;
		}
		if (host.endsWith("127.0.0.1")) {
			good = true;
		}

		if (!good) {
			this.errorHost = true;
			return;
		}

		try {
			@Pc(94) int retry = 5;
			this.archiveChecksum[8] = 0;
			while (this.archiveChecksum[8] == 0) {
				this.drawProgress("Connecting to fileserver", 10);
				try {
					@Pc(119) DataInputStream stream = this.openUrl("crc" + (int) (Math.random() * 9.9999999E7D));
					@Pc(126) Packet checksums = new Packet(new byte[36]);
					stream.readFully(checksums.data, 0, 36);
					for (@Pc(134) int i = 0; i < 9; i++) {
						this.archiveChecksum[i] = checksums.g4();
					}
					stream.close();
				} catch (@Pc(150) IOException ex) {
					for (@Pc(152) int i = retry; i > 0; i--) {
						this.drawProgress("Error loading - Will retry in " + i + " secs.", 10);
						try {
							Thread.sleep(1000L);
						} catch (@Pc(171) Exception ignored) {
						}
					}
					retry *= 2;
					if (retry > 60) {
						retry = 60;
					}
				}
			}

			this.archiveTitle = this.loadArchive("title screen", this.archiveChecksum[1], "title", 10);
			this.fontPlain11 = new PixFont(this.archiveTitle, "p11");
			this.fontPlain12 = new PixFont(this.archiveTitle, "p12");
			this.fontBold12 = new PixFont(this.archiveTitle, "b12");
			this.fontQuill8 = new PixFont(this.archiveTitle, "q8");
			this.loadTitleBackground();
			this.loadTitleImages();

			@Pc(255) Jagfile config = this.loadArchive("config", this.archiveChecksum[2], "config", 15);
			@Pc(266) Jagfile inter = this.loadArchive("interface", this.archiveChecksum[3], "interface", 20);
			@Pc(277) Jagfile media = this.loadArchive("2d graphics", this.archiveChecksum[4], "media", 30);
			@Pc(288) Jagfile models = this.loadArchive("3d graphics", this.archiveChecksum[5], "models", 40);
			@Pc(299) Jagfile textures = this.loadArchive("textures", this.archiveChecksum[6], "textures", 60);
			@Pc(310) Jagfile wordenc = this.loadArchive("chat system", this.archiveChecksum[7], "wordenc", 65);
			@Pc(321) Jagfile sounds = this.loadArchive("sound effects", this.archiveChecksum[8], "sounds", 70);

			this.levelTileFlags = new byte[4][104][104];
			this.levelHeightmap = new int[4][105][105];
			this.scene = new World3D(this.levelHeightmap, 104, 4, 104);
			for (@Pc(346) int level = 0; level < 4; level++) {
				this.levelCollisionMap[level] = new CollisionMap(104, 104);
			}
			this.imageMinimap = new Pix24(512, 512);
			this.drawProgress("Unpacking media", 75);
			this.imageInvback = new Pix8(media, "invback", 0);
			this.imageChatback = new Pix8(media, "chatback", 0);
			this.imageMapback = new Pix8(media, "mapback", 0);
			this.imageBackbase1 = new Pix8(media, "backbase1", 0);
			this.imageBackbase2 = new Pix8(media, "backbase2", 0);
			this.imageBackhmid1 = new Pix8(media, "backhmid1", 0);
			for (@Pc(424) int i = 0; i < 13; i++) {
				this.imageSideicons[i] = new Pix8(media, "sideicons", i);
			}
			this.imageCompass = new Pix24(media, "compass", 0);

			try {
				for (int i = 0; i < 50; i++) {
					this.imageMapscene[i] = new Pix8(media, "mapscene", i);
				}
			} catch (@Pc(468) Exception ex) {
			}
			try {
				for (int i = 0; i < 50; i++) {
					this.imageMapfunction[i] = new Pix24(media, "mapfunction", i);
				}
			} catch (@Pc(488) Exception ex) {
			}
			try {
				for (int i = 0; i < 20; i++) {
					this.imageHitmarks[i] = new Pix24(media, "hitmarks", i);
				}
			} catch (@Pc(508) Exception ex) {
			}
			try {
				for (int i = 0; i < 20; i++) {
					this.imageHeadicons[i] = new Pix24(media, "headicons", i);
				}
			} catch (@Pc(528) Exception ex) {
			}
			this.imageMapflag = new Pix24(media, "mapflag", 0);
			for (int i = 0; i < 8; i++) {
				this.imageCrosses[i] = new Pix24(media, "cross", i);
			}
			this.imageMapdot0 = new Pix24(media, "mapdots", 0);
			this.imageMapdot1 = new Pix24(media, "mapdots", 1);
			this.imageMapdot2 = new Pix24(media, "mapdots", 2);
			this.imageMapdot3 = new Pix24(media, "mapdots", 3);
			this.imageScrollbar0 = new Pix8(media, "scrollbar", 0);
			this.imageScrollbar1 = new Pix8(media, "scrollbar", 1);
			this.imageRedstone1 = new Pix8(media, "redstone1", 0);
			this.imageRedstone2 = new Pix8(media, "redstone2", 0);
			this.imageRedstone3 = new Pix8(media, "redstone3", 0);
			this.imageRedstone1h = new Pix8(media, "redstone1", 0);
			this.imageRedstone1h.flipHorizontally();
			this.imageRedstone2h = new Pix8(media, "redstone2", 0);
			this.imageRedstone2h.flipHorizontally();
			this.imageRedstone1v = new Pix8(media, "redstone1", 0);
			this.imageRedstone1v.flipVertically();
			this.imageRedstone2v = new Pix8(media, "redstone2", 0);
			this.imageRedstone2v.flipVertically();
			this.imageRedstone3v = new Pix8(media, "redstone3", 0);
			this.imageRedstone3v.flipVertically();
			this.imageRedstone1hv = new Pix8(media, "redstone1", 0);
			this.imageRedstone1hv.flipHorizontally();
			this.imageRedstone1hv.flipVertically();
			this.imageRedstone2hv = new Pix8(media, "redstone2", 0);
			this.imageRedstone2hv.flipHorizontally();
			this.imageRedstone2hv.flipVertically();
			@Pc(725) Pix24 backleft1 = new Pix24(media, "backleft1", 0);
			this.areaBackleft1 = new PixMap(this.getBaseComponent(), backleft1.width, backleft1.height);
			backleft1.blitOpaque(0, 0);
			@Pc(750) Pix24 backleft2 = new Pix24(media, "backleft2", 0);
			this.areaBackleft2 = new PixMap(this.getBaseComponent(), backleft2.width, backleft2.height);
			backleft2.blitOpaque(0, 0);
			@Pc(775) Pix24 backright1 = new Pix24(media, "backright1", 0);
			this.areaBackright1 = new PixMap(this.getBaseComponent(), backright1.width, backright1.height);
			backright1.blitOpaque(0, 0);
			@Pc(800) Pix24 backright2 = new Pix24(media, "backright2", 0);
			this.areaBackright2 = new PixMap(this.getBaseComponent(), backright2.width, backright2.height);
			backright2.blitOpaque(0, 0);
			@Pc(825) Pix24 backtop1 = new Pix24(media, "backtop1", 0);
			this.areaBacktop1 = new PixMap(this.getBaseComponent(), backtop1.width, backtop1.height);
			backtop1.blitOpaque(0, 0);
			@Pc(850) Pix24 backtop2 = new Pix24(media, "backtop2", 0);
			this.areaBacktop2 = new PixMap(this.getBaseComponent(), backtop2.width, backtop2.height);
			backtop2.blitOpaque(0, 0);
			@Pc(875) Pix24 backvmid1 = new Pix24(media, "backvmid1", 0);
			this.areaBackvmid1 = new PixMap(this.getBaseComponent(), backvmid1.width, backvmid1.height);
			backvmid1.blitOpaque(0, 0);
			@Pc(900) Pix24 backvmid2 = new Pix24(media, "backvmid2", 0);
			this.areaBackvmid2 = new PixMap(this.getBaseComponent(), backvmid2.width, backvmid2.height);
			backvmid2.blitOpaque(0, 0);
			@Pc(925) Pix24 backvmid3 = new Pix24(media, "backvmid3", 0);
			this.areaBackvmid3 = new PixMap(this.getBaseComponent(), backvmid3.width, backvmid3.height);
			backvmid3.blitOpaque(0, 0);
			@Pc(950) Pix24 backhmid2 = new Pix24(media, "backhmid2", 0);
			this.areaBackhmid2 = new PixMap(this.getBaseComponent(), backhmid2.width, backhmid2.height);
			backhmid2.blitOpaque(0, 0);

			@Pc(975) int randR = (int) (Math.random() * 21.0D) - 10;
			@Pc(982) int randG = (int) (Math.random() * 21.0D) - 10;
			@Pc(989) int randB = (int) (Math.random() * 21.0D) - 10;
			@Pc(996) int rand = (int) (Math.random() * 41.0D) - 20;
			for (@Pc(998) int i = 0; i < 50; i++) {
				if (this.imageMapfunction[i] != null) {
					this.imageMapfunction[i].translate(randR + rand, randG + rand, randB + rand);
				}

				if (this.imageMapscene[i] != null) {
					this.imageMapscene[i].translate(randR + rand, randG + rand, randB + rand);
				}
			}

			this.drawProgress("Unpacking textures", 80);
			Draw3D.unpackTextures(textures);
			Draw3D.setBrightness(0.8D);
			Draw3D.initPool(20);
			this.drawProgress("Unpacking models", 83);
			Model.unpack(models);
			SeqBase.unpack(models);
			SeqFrame.unpack(models);
			this.drawProgress("Unpacking config", 86);
			SeqType.unpack(config);
			LocType.unpack(config);
			FloType.unpack(config);
			ObjType.unpack(config);
			NpcType.unpack(config);
			IdkType.unpack(config);
			SpotAnimType.unpack(config);
			VarpType.unpack(config);

			ObjType.membersWorld = members;
			if (!lowMemory) {
				this.drawProgress("Unpacking sounds", 90);
				@Pc(1113) byte[] data = sounds.read("sounds.dat", null);
				@Pc(1119) Packet soundDat = new Packet(data);
				Wave.unpack(soundDat);
			}

			this.drawProgress("Unpacking interfaces", 92);
			@Pc(1150) PixFont[] fonts = new PixFont[] { this.fontPlain11, this.fontPlain12, this.fontBold12, this.fontQuill8 };
			ComType.unpack(media, fonts, inter);

			this.drawProgress("Preparing game engine", 97);
			for (@Pc(1162) int y = 0; y < 33; y++) {
				int left = 999;
				int right = 0;
				for (int x = 0; x < 35; x++) {
					if (this.imageMapback.pixels[x + y * this.imageMapback.width] == 0) {
						if (left == 999) {
							left = x;
						}
					} else if (left != 999) {
						right = x;
						break;
					}
				}
				this.compassMaskLineOffsets[y] = left;
				this.compassMaskLineLengths[y] = right - left;
			}

			for (int y = 9; y < 160; y++) {
				int left = 999;
				int right = 0;
				for (int x = 10; x < 168; x++) {
					if (this.imageMapback.pixels[x + y * this.imageMapback.width] == 0 && (x > 34 || y > 34)) {
						if (left == 999) {
							left = x;
						}
					} else if (left != 999) {
						right = x;
						break;
					}
				}
				this.minimapMaskLineOffsets[y - 9] = left - 21;
				this.minimapMaskLineLengths[y - 9] = right - left;
			}

			Draw3D.init3D(96, 479);
			this.areaChatbackOffsets = Draw3D.lineOffset;
			Draw3D.init3D(261, 190);
			this.areaSidebarOffsets = Draw3D.lineOffset;
			Draw3D.init3D(334, 512);
			this.areaViewportOffsets = Draw3D.lineOffset;

			@Pc(1312) int[] distance = new int[9];
			for (int x = 0; x < 9; x++) {
				int angle = x * 32 + 128 + 15;
				@Pc(1330) int offset = angle * 3 + 600;
				@Pc(1334) int sin = Draw3D.sin[angle];
				distance[x] = offset * sin >> 16;
			}
			World3D.init(distance, 800, 512, 334, 500);
			WordFilter.unpack(wordenc);
		} catch (@Pc(1357) Exception ex) {
			this.errorLoading = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "v", descriptor = "(I)V")
	private void handleInput() {
		if (this.objDragArea == 0) {
			this.menuOption[0] = "Cancel";
			this.menuAction[0] = 1252;
			this.menuSize = 1;
			this.handlePrivateChatInput(super.mouseX, super.mouseY);
			this.lastHoveredInterfaceId = 0;
			if (super.mouseX > 8 && super.mouseY > 11 && super.mouseX < 520 && super.mouseY < 345) {
				if (this.viewportInterfaceID == -1) {
					this.handleViewportOptions();
				} else {
					this.handleInterfaceInput(super.mouseY, super.mouseX, 11, ComType.instances[this.viewportInterfaceID], 8, 0);
				}
			}
			if (this.lastHoveredInterfaceId != this.viewportHoveredInterfaceIndex) {
				this.viewportHoveredInterfaceIndex = this.lastHoveredInterfaceId;
			}
			this.lastHoveredInterfaceId = 0;
			if (super.mouseX > 562 && super.mouseY > 231 && super.mouseX < 752 && super.mouseY < 492) {
				if (this.sidebarInterfaceId != -1) {
					this.handleInterfaceInput(super.mouseY, super.mouseX, 231, ComType.instances[this.sidebarInterfaceId], 562, 0);
				} else if (this.tabInterfaceId[this.selectedTab] != -1) {
					this.handleInterfaceInput(super.mouseY, super.mouseX, 231, ComType.instances[this.tabInterfaceId[this.selectedTab]], 562, 0);
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
					this.handleInterfaceInput(super.mouseY, super.mouseX, 375, ComType.instances[this.chatInterfaceId], 22, 0);
				}
			}
			if (this.chatInterfaceId != -1 && this.lastHoveredInterfaceId != this.chatHoveredInterfaceIndex) {
				this.redrawChatback = true;
				this.chatHoveredInterfaceIndex = this.lastHoveredInterfaceId;
			}

			@Pc(223) boolean done = false;
			while (!done) {
				done = true;

				for (@Pc(229) int i = 0; i < this.menuSize - 1; i++) {
					if (this.menuAction[i] < 1000 && this.menuAction[i + 1] > 1000) {
						@Pc(250) String tmp0 = this.menuOption[i];
						this.menuOption[i] = this.menuOption[i + 1];
						this.menuOption[i + 1] = tmp0;

						@Pc(272) int tmp1 = this.menuAction[i];
						this.menuAction[i] = this.menuAction[i + 1];
						this.menuAction[i + 1] = tmp1;

						@Pc(294) int tmp2 = this.menuParamB[i];
						this.menuParamB[i] = this.menuParamB[i + 1];
						this.menuParamB[i + 1] = tmp2;

						@Pc(316) int tmp3 = this.menuParamC[i];
						this.menuParamC[i] = this.menuParamC[i + 1];
						this.menuParamC[i + 1] = tmp3;

						@Pc(338) int tmp4 = this.menuParamA[i];
						this.menuParamA[i] = this.menuParamA[i + 1];
						this.menuParamA[i + 1] = tmp4;

						done = false;
					}
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
	private void draw3DEntityElements() {
		this.drawPrivateMessages();
		if (this.crossMode == 1) {
			this.imageCrosses[this.crossCycle / 100].draw(this.crossY - 8 - 11, this.crossX - 8 - 8);
		}
		if (this.crossMode == 2) {
			this.imageCrosses[this.crossCycle / 100 + 4].draw(this.crossY - 8 - 11, this.crossX - 8 - 8);
		}
		if (this.viewportInterfaceID != -1) {
			this.updateInterfaceAnimation(this.viewportInterfaceID, this.sceneDelta);
			this.drawInterface(0, 0, ComType.instances[this.viewportInterfaceID], 0);
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
			int seconds = this.systemUpdateTimer / 50;
			@Pc(196) int minutes = seconds / 60;
			seconds %= 60;

			if (seconds < 10) {
				this.fontPlain12.drawString(4, 329, 16776960, "System update in: " + minutes + ":0" + seconds);
			} else {
				this.fontPlain12.drawString(4, 329, 16776960, "System update in: " + minutes + ":" + seconds);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "x", descriptor = "(I)V")
	private void updateOrbitCamera() {
		@Pc(8) int orbitX = this.localPlayer.x + this.cameraAnticheatOffsetX;
		@Pc(15) int orbitZ = this.localPlayer.z + this.cameraAnticheatOffsetZ;
		if (this.orbitCameraX - orbitX < -500 || this.orbitCameraX - orbitX > 500 || this.orbitCameraZ - orbitZ < -500 || this.orbitCameraZ - orbitZ > 500) {
			this.orbitCameraX = orbitX;
			this.orbitCameraZ = orbitZ;
		}
		if (this.orbitCameraX != orbitX) {
			this.orbitCameraX += (orbitX - this.orbitCameraX) / 16;
		}
		if (this.orbitCameraZ != orbitZ) {
			this.orbitCameraZ += (orbitZ - this.orbitCameraZ) / 16;
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

		@Pc(208) int orbitTileX = this.orbitCameraX >> 7;
		@Pc(213) int orbitTileZ = this.orbitCameraZ >> 7;
		@Pc(223) int orbitY = this.getHeightmapY(this.currentLevel, this.orbitCameraX, this.orbitCameraZ);
		@Pc(225) int maxY = 0;

		if (orbitTileX > 3 && orbitTileZ > 3 && orbitTileX < 100 && orbitTileZ < 100) {
			for (int x = orbitTileX - 4; x <= orbitTileX + 4; x++) {
				for (@Pc(247) int z = orbitTileZ - 4; z <= orbitTileZ + 4; z++) {
					@Pc(252) int level = this.currentLevel;
					if (level < 3 && (this.levelTileFlags[1][x][z] & 0x2) == 2) {
						level++;
					}

					@Pc(279) int y = orbitY - this.levelHeightmap[level][x][z];
					if (y > maxY) {
						maxY = y;
					}
				}
			}
		}

		int clamp = maxY * 192;
		if (clamp > 98048) {
			clamp = 98048;
		}

		if (clamp < 32768) {
			clamp = 32768;
		}

		if (clamp > this.cameraPitchClamp) {
			this.cameraPitchClamp += (clamp - this.cameraPitchClamp) / 24;
		} else if (clamp < this.cameraPitchClamp) {
			this.cameraPitchClamp += (clamp - this.cameraPitchClamp) / 80;
		}
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(B)V")
	private void pushProjectiles() {
		for (@Pc(12) ProjectileEntity proj = (ProjectileEntity) this.projectiles.peekFront(); proj != null; proj = (ProjectileEntity) this.projectiles.prev()) {
			if (proj.level != this.currentLevel || loopCycle > proj.lastCycle) {
				proj.unlink();
			} else if (loopCycle >= proj.startCycle) {
				if (proj.target > 0) {
					@Pc(42) NpcEntity npc = this.npcs[proj.target - 1];
					if (npc != null) {
						proj.updateVelocity(this.getHeightmapY(proj.level, npc.x, npc.z) - proj.offsetY, npc.z, npc.x, loopCycle);
					}
				}

				if (proj.target < 0) {
					@Pc(73) int index = -proj.target - 1;
					@Pc(80) PlayerEntity player;
					if (index == this.localPid) {
						player = this.localPlayer;
					} else {
						player = this.players[index];
					}
					if (player != null) {
						proj.updateVelocity(this.getHeightmapY(proj.level, player.x, player.z) - proj.offsetY, player.z, player.x, loopCycle);
					}
				}

				proj.update(this.sceneDelta);
				this.scene.addTemporary((int) proj.z, 60, proj.yaw, (int) proj.x, -1, false, null, proj, (int) proj.y, this.currentLevel);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "c", descriptor = "(I)V")
	@Override
	protected void refresh() {
		this.redrawTitleBackground = true;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IILclient!hb;I)V")
	private void drawOnMinimap(@OriginalArg(0) int dy, @OriginalArg(2) Pix24 image, @OriginalArg(3) int dx) {
		@Pc(7) int angle = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
		@Pc(15) int distance = dx * dx + dy * dy;
		if (distance <= 6400) {
			@Pc(34) int sinAngle = Model.sin[angle];
			@Pc(38) int cosAngle = Model.cos[angle];

			sinAngle = sinAngle * 256 / (this.minimapZoom + 256);
			cosAngle = cosAngle * 256 / (this.minimapZoom + 256);

			@Pc(66) int x = dy * sinAngle + dx * cosAngle >> 16;
			@Pc(76) int y = dy * cosAngle - dx * sinAngle >> 16;

			if (distance > 2500) {
				image.drawMasked(this.imageMapback, 83 - y - image.cropH / 2, x + 94 - image.cropW / 2);
			} else {
				image.draw(83 - y - image.cropH / 2, x + 94 - image.cropW / 2);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIII)I")
	private int mix(@OriginalArg(0) int src, @OriginalArg(1) int alpha, @OriginalArg(2) int dst) {
		@Pc(3) int invAlpha = 256 - alpha;
		return ((src & 0xFF00FF) * invAlpha + (dst & 0xFF00FF) * alpha & 0xFF00FF00) + ((src & 0xFF00) * invAlpha + (dst & 0xFF00) * alpha & 0xFF0000) >> 8;
	}

	@OriginalMember(owner = "client!client", name = "h", descriptor = "(II)Ljava/lang/String;")
	private String getIntString(@OriginalArg(0) int value) {
		return value < 999999999 ? String.valueOf(value) : "*";
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IZLclient!x;)V")
	private void projectFromGround(@OriginalArg(0) int height, @OriginalArg(2) PathingEntity entity) {
		this.projectFromGround(entity.z, entity.x, height);
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IIII)V")
	private void projectFromGround(@OriginalArg(0) int z, @OriginalArg(1) int x, @OriginalArg(3) int height) {
		if (x >= 128 && z >= 128 && x <= 13056 && z <= 13056) {
			@Pc(28) int y = this.getHeightmapY(this.currentLevel, x, z) - height;

			@Pc(33) int dx = x - this.cameraX;
			@Pc(38) int dy = y - this.cameraY;
			@Pc(43) int dz = z - this.cameraZ;

			@Pc(48) int sinPitch = Model.sin[this.cameraPitch];
			@Pc(53) int cosPitch = Model.cos[this.cameraPitch];
			@Pc(58) int sinYaw = Model.sin[this.cameraYaw];
			@Pc(63) int cosYaw = Model.cos[this.cameraYaw];

			int tmp = dz * sinYaw + dx * cosYaw >> 16;
			dz = dz * cosYaw - dx * sinYaw >> 16;
			dx = tmp;

			tmp = dy * cosPitch - dz * sinPitch >> 16;
			dz = dy * sinPitch + dz * cosPitch >> 16;
			dy = tmp;

			if (dz >= 50) {
				this.projectX = Draw3D.centerX + (dx << 9) / dz;
				this.projectY = Draw3D.centerY + (dy << 9) / dz;
			} else {
				this.projectX = -1;
				this.projectY = -1;
			}
		} else {
			this.projectX = -1;
			this.projectY = -1;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIZ)Z")
	private boolean interactWithLoc(@OriginalArg(0) int opcode, @OriginalArg(1) int x, @OriginalArg(2) int z, @OriginalArg(3) int bitset) {
		@Pc(7) int locId = bitset >> 14 & 0x7FFF;
		@Pc(16) int info = this.scene.getInfo(this.currentLevel, x, z, bitset);
		if (info == -1) {
			return false;
		}

		@Pc(25) int type = info & 0x1F;
		@Pc(31) int angle = info >> 6 & 0x3;
		if (type == 10 || type == 11 || type == 22) {
			@Pc(43) LocType loc = LocType.get(locId);
			@Pc(51) int width;
			@Pc(54) int height;
			if (angle == 0 || angle == 2) {
				width = loc.width;
				height = loc.length;
			} else {
				width = loc.length;
				height = loc.width;
			}
			@Pc(65) int forceapproach = loc.forceapproach;
			if (angle != 0) {
				forceapproach = (forceapproach << angle & 0xF) + (forceapproach >> 4 - angle);
			}
			this.tryMove(this.localPlayer.pathTileX[0], width, false, x, this.localPlayer.pathTileZ[0], 2, height, z, 0, 0, forceapproach);
		} else {
			this.tryMove(this.localPlayer.pathTileX[0], 0, false, x, this.localPlayer.pathTileZ[0], 2, 0, z, angle, type + 1, 0);
		}
		this.crossX = super.mouseClickX;
		this.crossY = super.mouseClickY;
		this.crossMode = 2;
		this.crossCycle = 0;
		this.out.p1isaac(opcode);
		this.out.p2(x + this.sceneBaseTileX);
		this.out.p2(z + this.sceneBaseTileZ);
		this.out.p2(locId);
		return true;
	}

	@OriginalMember(owner = "client!client", name = "y", descriptor = "(I)V")
	private void showContextMenu() {
		@Pc(7) int width = this.fontBold12.stringWidth("Choose Option");
		@Pc(20) int maxWidth;
		for (@Pc(9) int i = 0; i < this.menuSize; i++) {
			maxWidth = this.fontBold12.stringWidth(this.menuOption[i]);
			if (maxWidth > width) {
				width = maxWidth;
			}
		}
		width += 8;

		int height = this.menuSize * 15 + 21;

		@Pc(66) int x;
		@Pc(84) int y;
		if (super.mouseClickX > 8 && super.mouseClickY > 11 && super.mouseClickX < 520 && super.mouseClickY < 345) {
			x = super.mouseClickX - width / 2 - 8;
			if (x + width > 512) {
				x = 512 - width;
			} else if (x < 0) {
				x = 0;
			}

			y = super.mouseClickY - 11;
			if (y + height > 334) {
				y = 334 - height;
			} else if (y < 0) {
				y = 0;
			}

			this.menuVisible = true;
			this.menuArea = 0;
			this.menuX = x;
			this.menuY = y;
			this.menuWidth = width;
			this.menuHeight = this.menuSize * 15 + 22;
		}
		if (super.mouseClickX > 562 && super.mouseClickY > 231 && super.mouseClickX < 752 && super.mouseClickY < 492) {
			x = super.mouseClickX - width / 2 - 562;
			if (x < 0) {
				x = 0;
			} else if (x + width > 190) {
				x = 190 - width;
			}

			y = super.mouseClickY - 231;
			if (y < 0) {
				y = 0;
			} else if (y + height > 261) {
				y = 261 - height;
			}

			this.menuVisible = true;
			this.menuArea = 1;
			this.menuX = x;
			this.menuY = y;
			this.menuWidth = width;
			this.menuHeight = this.menuSize * 15 + 22;
		}
		if (super.mouseClickX > 22 && super.mouseClickY > 375 && super.mouseClickX < 501 && super.mouseClickY < 471) {
			x = super.mouseClickX - width / 2 - 22;
			if (x < 0) {
				x = 0;
			} else if (x + width > 479) {
				x = 479 - width;
			}

			y = super.mouseClickY - 375;
			if (y < 0) {
				y = 0;
			} else if (y + height > 96) {
				y = 96 - height;
			}

			this.menuVisible = true;
			this.menuArea = 2;
			this.menuX = x;
			this.menuY = y;
			this.menuWidth = width;
			this.menuHeight = this.menuSize * 15 + 22;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;)Ljava/io/DataInputStream;")
	private DataInputStream openUrl(@OriginalArg(0) String url) throws IOException {
		return signlink.mainapp == null ? new DataInputStream((new URL(this.getCodeBase(), url)).openStream()) : signlink.openurl(url);
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(B)V")
	private void loadTitle() {
		if (this.imageTitle2 == null) {
			super.drawArea = null;
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
	}

	@OriginalMember(owner = "client!client", name = "z", descriptor = "(I)V")
	private void runFlames() {
		this.flameThread = true;

		try {
			@Pc(4) long last = System.currentTimeMillis();
			@Pc(6) int cycle = 0;
			@Pc(8) int interval = 20;
			while (this.flameActive) {
				this.updateFlames();
				this.updateFlames();
				this.drawFlames();

				cycle++;

				if (cycle > 10) {
					@Pc(25) long now = System.currentTimeMillis();
					@Pc(34) int delay = (int) (now - last) / 10 - interval;

					interval = 40 - delay;
					if (interval < 5) {
						interval = 5;
					}

					cycle = 0;
					last = now;
				}

				try {
					Thread.sleep(interval);
				} catch (@Pc(52) Exception ignored) {
				}
			}
		} catch (@Pc(58) Exception ignored) {
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
	private void handleScrollInput(@OriginalArg(0) int mouseX, @OriginalArg(2) int mouseY, @OriginalArg(3) int scrollableHeight, @OriginalArg(4) int height, @OriginalArg(5) boolean redraw, @OriginalArg(6) int left, @OriginalArg(7) int top, @OriginalArg(8) ComType component) {
		if (this.scrollGrabbed) {
			this.scrollInputPadding = 32;
		} else {
			this.scrollInputPadding = 0;
		}

		this.scrollGrabbed = false;

		if (mouseX >= left && mouseX < left + 16 && mouseY >= top && mouseY < top + 16) {
			component.scrollPosition -= this.dragCycles * 4;
			if (redraw) {
				this.redrawSidebar = true;
			}
		} else if (mouseX >= left && mouseX < left + 16 && mouseY >= top + height - 16 && mouseY < top + height) {
			component.scrollPosition += this.dragCycles * 4;
			if (redraw) {
				this.redrawSidebar = true;
			}
		} else if (mouseX >= left - this.scrollInputPadding && mouseX < left + this.scrollInputPadding + 16 && mouseY >= top + 16 && mouseY < top + height - 16 && this.dragCycles > 0) {
			@Pc(122) int gripSize = (height - 32) * height / scrollableHeight;
			if (gripSize < 8) {
				gripSize = 8;
			}
			@Pc(137) int gripY = mouseY - top - gripSize / 2 - 16;
			@Pc(143) int maxY = height - gripSize - 32;
			component.scrollPosition = (scrollableHeight - height) * gripY / maxY;
			if (redraw) {
				this.redrawSidebar = true;
			}
			this.scrollGrabbed = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;Z)V")
	private void login(@OriginalArg(0) String username, @OriginalArg(1) String password, @OriginalArg(2) boolean reconnect) {
		signlink.errorname = username;
		try {
			if (!reconnect) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Connecting to server...";
				this.drawTitleScreen();
			}
			this.stream = new ClientStream(this, this.openSocket(portOffset + 43594));
			this.stream.read(this.in.data, 0, 8);
			this.in.pos = 0;
			this.serverSeed = this.in.g8();
			@Pc(47) int[] seed = new int[] { (int) (Math.random() * 9.9999999E7D), (int) (Math.random() * 9.9999999E7D), (int) (this.serverSeed >> 32), (int) this.serverSeed };
			this.out.pos = 0;
			this.out.p1(10);
			this.out.p4(seed[0]);
			this.out.p4(seed[1]);
			this.out.p4(seed[2]);
			this.out.p4(seed[3]);
			this.out.p4(signlink.uid);
			this.out.pjstr(username);
			this.out.pjstr(password);
			this.out.rsaenc(RSA_MODULUS, RSA_EXPONENT);
			this.login.pos = 0;
			if (reconnect) {
				this.login.p1(18);
			} else {
				this.login.p1(16);
			}
			this.login.p1(this.out.pos + 36 + 1 + 1);
			this.login.p1(225);
			this.login.p1(lowMemory ? 1 : 0);
			for (@Pc(168) int i = 0; i < 9; i++) {
				this.login.p4(this.archiveChecksum[i]);
			}
			this.login.pdata(this.out.data, this.out.pos, 0);
			this.out.random = new Isaac(seed);
			for (@Pc(202) int i = 0; i < 4; i++) {
				seed[i] += 50;
			}
			this.randomIn = new Isaac(seed);
			this.stream.write(this.login.data, this.login.pos, 0);
			@Pc(237) int reply = this.stream.read();
			if (reply == 1) {
				try {
					Thread.sleep(2000L);
				} catch (@Pc(244) Exception ex) {
				}
				this.login(username, password, reconnect);
				return;
			}
			if (reply == 2 || reply == 18) {
				this.rights = reply == 18;
				InputTracking.setDisabled();
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
				for (@Pc(318) int i = 0; i < 100; i++) {
					this.messageText[i] = null;
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
				for (@Pc(408) int i = 0; i < this.MAX_PLAYER_COUNT; i++) {
					this.players[i] = null;
					this.playerAppearanceBuffer[i] = null;
				}
				for (@Pc(427) int i = 0; i < 8192; i++) {
					this.npcs[i] = null;
				}
				this.localPlayer = this.players[this.LOCAL_PLAYER_INDEX] = new PlayerEntity();
				this.projectiles.clear();
				this.spotanims.clear();
				this.temporaryLocs.clear();
				for (@Pc(460) int level = 0; level < 4; level++) {
					for (int x = 0; x < 104; x++) {
						for (@Pc(468) int z = 0; z < 104; z++) {
							this.levelObjStacks[level][x][z] = null;
						}
					}
				}
				this.spawnedLocations = new LinkList();
				this.friendCount = 0;
				this.stickyChatInterfaceId = -1;
				this.chatInterfaceId = -1;
				this.viewportInterfaceID = -1;
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
				for (int i = 0; i < 5; i++) {
					this.designColors[i] = 0;
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
			if (reply == 3) {
				this.loginMessage0 = "";
				this.loginMessage1 = "Invalid username or password.";
				return;
			}
			if (reply == 4) {
				this.loginMessage0 = "Your account has been disabled.";
				this.loginMessage1 = "Please check your message-centre for details.";
				return;
			}
			if (reply == 5) {
				this.loginMessage0 = "Your account is already logged in.";
				this.loginMessage1 = "Try again in 60 secs...";
				return;
			}
			if (reply == 6) {
				this.loginMessage0 = "RuneScape has been updated!";
				this.loginMessage1 = "Please reload this page.";
				return;
			}
			if (reply == 7) {
				this.loginMessage0 = "This world is full.";
				this.loginMessage1 = "Please use a different world.";
				return;
			}
			if (reply == 8) {
				this.loginMessage0 = "Unable to connect.";
				this.loginMessage1 = "Login server offline.";
				return;
			}
			if (reply == 9) {
				this.loginMessage0 = "Login limit exceeded.";
				this.loginMessage1 = "Too many connections from your address.";
				return;
			}
			if (reply == 10) {
				this.loginMessage0 = "Unable to connect.";
				this.loginMessage1 = "Bad session id.";
				return;
			}
			if (reply == 11) {
				this.loginMessage1 = "Login server rejected session.";
				this.loginMessage1 = "Please try again.";
				return;
			}
			if (reply == 12) {
				this.loginMessage0 = "You need a members account to login to this world.";
				this.loginMessage1 = "Please subscribe, or use a different world.";
				return;
			}
			if (reply == 13) {
				this.loginMessage0 = "Could not complete login.";
				this.loginMessage1 = "Please try using a different world.";
				return;
			}
			if (reply == 14) {
				this.loginMessage0 = "The server is being updated.";
				this.loginMessage1 = "Please wait 1 minute and try again.";
				return;
			}
			if (reply == 15) {
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
			if (reply == 16) {
				this.loginMessage0 = "Login attempts exceeded.";
				this.loginMessage1 = "Please wait 1 minute and try again.";
				return;
			}
			if (reply == 17) {
				this.loginMessage0 = "You are standing in a members-only area.";
				this.loginMessage1 = "To play on this world move to a free area first";
			}
		} catch (@Pc(762) IOException ex) {
			this.loginMessage0 = "";
			this.loginMessage1 = "Error connecting to server.";
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIIIII)V")
	private void addLoc(@OriginalArg(0) int rotation, @OriginalArg(1) int x, @OriginalArg(2) int z, @OriginalArg(3) int layer, @OriginalArg(4) int id, @OriginalArg(5) int shape, @OriginalArg(7) int level) {
        if (x < 1 || z < 1 || x > 102 || z > 102) {
            return;
        }

        if (lowMemory && level != this.currentLevel) {
            return;
        }

        @Pc(25) int bitset = 0;

        if (layer == 0) {
            bitset = this.scene.getWallBitset(level, x, z);
        }

        if (layer == 1) {
            bitset = this.scene.getWallDecorationBitset(level, z, x);
        }

        if (layer == 2) {
            bitset = this.scene.getLocBitset(level, x, z);
        }

        if (layer == 3) {
            bitset = this.scene.getGroundDecorationBitset(level, x, z);
        }

        if (bitset != 0) {
            int otherInfo = this.scene.getInfo(level, x, z, bitset);
            @Pc(87) int otherId = bitset >> 14 & 0x7FFF;
            @Pc(91) int otherShape = otherInfo & 0x1F;
            @Pc(95) int otherRotation = otherInfo >> 6;

            if (layer == 0) {
                this.scene.removeWall(x, level, z, 1);
                LocType type = LocType.get(otherId);

                if (type.blockwalk) {
                    this.levelCollisionMap[level].removeWall(type.blockrange, otherRotation, x, z, otherShape);
                }
            }

            if (layer == 1) {
                this.scene.removeWallDecoration(level, z, x);
            }

            if (layer == 2) {
                this.scene.removeLoc(x, z, level);
                LocType type = LocType.get(otherId);

                if (x + type.width > 103 || z + type.width > 103 || x + type.length > 103 || z + type.length > 103) {
                    return;
                }

                if (type.blockwalk) {
                    this.levelCollisionMap[level].removeLoc(z, x, otherRotation, type.width, type.blockrange, type.length);
                }
            }

            if (layer == 3) {
                this.scene.removeGroundDecoration(level, x, z);
                LocType type = LocType.get(otherId);

                if (type.blockwalk && type.active) {
                    this.levelCollisionMap[level].removeBlocked(z, x);
                }
            }
        }

        if (id >= 0) {
            int tileLevel = level;

            if (level < 3 && (this.levelTileFlags[1][x][z] & 0x2) == 2) {
                tileLevel = level + 1;
            }

            World.addLoc(x, this.locList, this.levelCollisionMap[level], z, rotation, this.levelHeightmap, level, id, shape, this.scene, tileLevel);
        }
    }

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(JI)V")
	private void addFriend(@OriginalArg(0) long username) {
		if (username != 0L) {
			if (this.friendCount >= 100) {
				this.addMessage(0, "Your friends list is full. Max of 100 hit", "");
			} else {
				@Pc(23) String displayName = JString.formatName(JString.fromBase37(username));
				for (@Pc(25) int i = 0; i < this.friendCount; i++) {
					if (this.friendName37[i] == username) {
						this.addMessage(0, displayName + " is already on your friend list", "");
						return;
					}
				}
				for (@Pc(55) int i = 0; i < this.ignoreCount; i++) {
					if (this.ignoreName37[i] == username) {
						this.addMessage(0, "Please remove " + displayName + " from your ignore list first", "");
						return;
					}
				}
				if (!displayName.equals(this.localPlayer.name)) {
					this.friendName[this.friendCount] = displayName;
					this.friendName37[this.friendCount] = username;
					this.friendWorld[this.friendCount] = 0;
					this.friendCount++;
					this.redrawSidebar = true;
					this.out.p1isaac(118);
					this.out.p8(username);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(B)V")
	@Override
	protected void unload() {
		signlink.reporterror = false;
		try {
			if (this.stream != null) {
				this.stream.close();
			}
		} catch (@Pc(11) Exception ex) {
		}
		this.stream = null;
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
		this.scene = null;
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
		this.menuParamB = null;
		this.menuParamC = null;
		this.menuAction = null;
		this.menuParamA = null;
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
		ComType.instances = null;
		SeqType.instances = null;
		SpotAnimType.instances = null;
		SpotAnimType.modelCache = null;
		VarpType.instances = null;
		super.drawArea = null;
		PlayerEntity.modelCache = null;
		Draw3D.unload();
		World3D.unload();
		Model.unload();
		SeqBase.instances = null;
		SeqFrame.instances = null;
		System.gc();
	}

	@OriginalMember(owner = "client!client", name = "A", descriptor = "(I)Ljava/net/Socket;")
	private Socket openSocket(@OriginalArg(0) int port) throws IOException {
		return signlink.mainapp == null ? new Socket(InetAddress.getByName(this.getCodeBase().getHost()), port) : signlink.opensocket(port);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!z;I)V")
	private void addPlayerOptions(@OriginalArg(1) int c, @OriginalArg(2) int a, @OriginalArg(3) PlayerEntity player, @OriginalArg(4) int b) {
		if (player != this.localPlayer && this.menuSize < 400) {
			@Pc(41) String tooltip = player.name + getCombatLevelColorTag(this.localPlayer.combatLevel, player.combatLevel) + " (level-" + player.combatLevel + ")";
			if (this.objSelected == 1) {
				this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @whi@" + tooltip;
				this.menuAction[this.menuSize] = 367;
				this.menuParamA[this.menuSize] = a;
				this.menuParamB[this.menuSize] = b;
				this.menuParamC[this.menuSize] = c;
				this.menuSize++;
			} else if (this.spellSelected != 1) {
				this.menuOption[this.menuSize] = "Follow @whi@" + tooltip;
				this.menuAction[this.menuSize] = 1544;
				this.menuParamA[this.menuSize] = a;
				this.menuParamB[this.menuSize] = b;
				this.menuParamC[this.menuSize] = c;
				this.menuSize++;
				if (this.overrideChat == 0) {
					this.menuOption[this.menuSize] = "Trade with @whi@" + tooltip;
					this.menuAction[this.menuSize] = 1373;
					this.menuParamA[this.menuSize] = a;
					this.menuParamB[this.menuSize] = b;
					this.menuParamC[this.menuSize] = c;
					this.menuSize++;
				}
				if (this.wildernessLevel > 0) {
					this.menuOption[this.menuSize] = "Attack @whi@" + tooltip;
					if (this.localPlayer.combatLevel >= player.combatLevel) {
						this.menuAction[this.menuSize] = 151;
					} else {
						this.menuAction[this.menuSize] = 2151;
					}
					this.menuParamA[this.menuSize] = a;
					this.menuParamB[this.menuSize] = b;
					this.menuParamC[this.menuSize] = c;
					this.menuSize++;
				}
				if (this.worldLocationState == 1) {
					this.menuOption[this.menuSize] = "Fight @whi@" + tooltip;
					this.menuAction[this.menuSize] = 151;
					this.menuParamA[this.menuSize] = a;
					this.menuParamB[this.menuSize] = b;
					this.menuParamC[this.menuSize] = c;
					this.menuSize++;
				}
				if (this.worldLocationState == 2) {
					this.menuOption[this.menuSize] = "Duel-with @whi@" + tooltip;
					this.menuAction[this.menuSize] = 1101;
					this.menuParamA[this.menuSize] = a;
					this.menuParamB[this.menuSize] = b;
					this.menuParamC[this.menuSize] = c;
					this.menuSize++;
				}
			} else if ((this.activeSpellFlags & 0x8) == 8) {
				this.menuOption[this.menuSize] = this.spellCaption + " @whi@" + tooltip;
				this.menuAction[this.menuSize] = 651;
				this.menuParamA[this.menuSize] = a;
				this.menuParamB[this.menuSize] = b;
				this.menuParamC[this.menuSize] = c;
				this.menuSize++;
			}
			for (@Pc(392) int i = 0; i < this.menuSize; i++) {
				if (this.menuAction[i] == 660) {
					this.menuOption[i] = "Walk here @whi@" + tooltip;
					return;
				}
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

		for (@Pc(22) int i = 0; i < 5 && this.read(); i++) {
		}

		if (this.ingame) {
			for (@Pc(46) int wave = 0; wave < this.waveCount; wave++) {
				if (this.waveDelay[wave] <= 0) {
					@Pc(55) boolean failed = false;
					try {
						if (this.waveIds[wave] != this.lastWaveId || this.waveLoops[wave] != this.lastWaveLoops) {
							@Pc(89) Packet buf = Wave.generate(this.waveLoops[wave], this.waveIds[wave]);

							if (System.currentTimeMillis() + (long) (buf.pos / 22) > this.lastWaveStartTime + (long) (this.lastWaveLength / 22)) {
								this.lastWaveLength = buf.pos;
								this.lastWaveStartTime = System.currentTimeMillis();
								if (this.saveWave(buf.data, buf.pos)) {
									this.lastWaveId = this.waveIds[wave];
									this.lastWaveLoops = this.waveLoops[wave];
								} else {
									failed = true;
								}
							}
						} else if (!this.replayWave()) {
							failed = true;
						}
					} catch (@Pc(139) Exception ignored) {
					}

					if (failed && this.waveDelay[wave] != -5) {
						this.waveDelay[wave] = -5;
					} else {
						this.waveCount--;
						for (int i = wave; i < this.waveCount; i++) {
							this.waveIds[i] = this.waveIds[i + 1];
							this.waveLoops[i] = this.waveLoops[i + 1];
							this.waveDelay[i] = this.waveDelay[i + 1];
						}
						wave--;
					}
				} else {
					this.waveDelay[wave]--;
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

			@Pc(250) Packet tracking = InputTracking.flush();
			if (tracking != null) {
				this.out.p1isaac(81);
				this.out.p2(tracking.pos);
				this.out.pdata(tracking.data, tracking.pos, 0);
				tracking.release();
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
							@Pc(502) ComType com = ComType.instances[this.objDragInterfaceId];
							int obj = com.inventorySlotObjId[this.hoveredSlot];
							com.inventorySlotObjId[this.hoveredSlot] = com.inventorySlotObjId[this.objDragSlot];
							com.inventorySlotObjId[this.objDragSlot] = obj;

							@Pc(530) int count = com.inventorySlotObjCount[this.hoveredSlot];
							com.inventorySlotObjCount[this.hoveredSlot] = com.inventorySlotObjCount[this.objDragSlot];
							com.inventorySlotObjCount[this.objDragSlot] = count;

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

			updateCounter++;
			if (updateCounter > 127) {
				updateCounter = 0;
				this.out.p1isaac(215);
				this.out.p3(4991788);
			}

			if (World3D.clickTileX != -1) {
				int x = World3D.clickTileX;
				int z = World3D.clickTileZ;
				@Pc(653) boolean success = this.tryMove(this.localPlayer.pathTileX[0], 0, true, x, this.localPlayer.pathTileZ[0], 0, 0, z, 0, 0, 0);
				World3D.clickTileX = -1;

				if (success) {
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

			this.handleMouseInput();
			this.handleMinimapInput();
			this.handleTabInput();
			this.handleChatSettingsInput();

			if (super.mouseButton == 1 || super.mouseClickButton == 1) {
				this.dragCycles++;
			}

			if (this.sceneState == 2) {
				this.updateOrbitCamera();
			}
			if (this.sceneState == 2 && this.cutscene) {
				this.applyCutscene();
			}

			for (int i = 0; i < 5; i++) {
				this.cameraModifierCycle[i]++;
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
				int rand = (int) (Math.random() * 8.0D);
				if ((rand & 0x1) == 1) {
					this.cameraAnticheatOffsetX += this.cameraOffsetXModifier;
				}
				if ((rand & 0x2) == 2) {
					this.cameraAnticheatOffsetZ += this.cameraOffsetZModifier;
				}
				if ((rand & 0x4) == 4) {
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
				int rand = (int) (Math.random() * 8.0D);
				if ((rand & 0x1) == 1) {
					this.minimapAnticheatAngle += this.minimapAngleModifier;
				}
				if ((rand & 0x2) == 2) {
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
				this.out.p1isaac(236);
				this.out.p4(0);
			}

			this.heartbeatTimer++;
			if (this.heartbeatTimer > 50) {
				this.out.p1isaac(108);
			}

			try {
				if (this.stream != null && this.out.pos > 0) {
					this.stream.write(this.out.data, this.out.pos, 0);
					this.out.pos = 0;
					this.heartbeatTimer = 0;
				}
			} catch (@Pc(1001) IOException ignored) {
				this.tryReconnect();
			} catch (@Pc(1006) Exception ignored) {
				this.logout();
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(Z)V")
	private void drawTooltip() {
		if (this.menuSize >= 2 || this.objSelected != 0 || this.spellSelected != 0) {
			@Pc(31) String tooltip;
			if (this.objSelected == 1 && this.menuSize < 2) {
				tooltip = "Use " + this.objSelectedName + " with...";
			} else if (this.spellSelected == 1 && this.menuSize < 2) {
				tooltip = this.spellCaption + "...";
			} else {
				tooltip = this.menuOption[this.menuSize - 1];
			}
			if (this.menuSize > 2) {
				tooltip = tooltip + "@whi@ / " + (this.menuSize - 2) + " more options";
			}
			this.fontBold12.drawStringTooltip(loopCycle / 1000, true, 15, 16777215, tooltip, 4);
		}
	}

	@OriginalMember(owner = "client!client", name = "k", descriptor = "(B)V")
	private void pushSpotanims() {
		for (@Pc(13) SpotAnimEntity entity = (SpotAnimEntity) this.spotanims.peekFront(); entity != null; entity = (SpotAnimEntity) this.spotanims.prev()) {
			if (entity.level != this.currentLevel || entity.seqComplete) {
				entity.unlink();
			} else if (loopCycle >= entity.startCycle) {
				entity.update(this.sceneDelta);
				if (entity.seqComplete) {
					entity.unlink();
				} else {
					this.scene.addTemporary(entity.z, 60, 0, entity.x, -1, false, null, entity, entity.y, entity.level);
				}
			}
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
				return new URL("http://w1.225.2004scape.org:" + (portOffset + 80));
			}
		} catch (@Pc(21) Exception ex) {
		}
		return super.getCodeBase();
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZIIIIIIIII)Z")
	private boolean tryMove(@OriginalArg(0) int srcX, @OriginalArg(1) int locWidth, @OriginalArg(2) boolean tryNearest, @OriginalArg(3) int dx, @OriginalArg(4) int srcZ, @OriginalArg(6) int type, @OriginalArg(7) int locLength, @OriginalArg(8) int dz, @OriginalArg(9) int locRotation, @OriginalArg(10) int locShape, @OriginalArg(11) int forceapproach) {
		@Pc(3) byte sceneWidth = 104;
		@Pc(5) byte sceneLength = 104;
		for (@Pc(7) int x = 0; x < sceneWidth; x++) {
			for (int z = 0; z < sceneLength; z++) {
				this.bfsDirection[x][z] = 0;
				this.bfsCost[x][z] = 99999999;
			}
		}

		int x = srcX;
		@Pc(39) int z = srcZ;

		this.bfsDirection[srcX][srcZ] = 99;
		this.bfsCost[srcX][srcZ] = 0;

		@Pc(55) int steps = 0;
		@Pc(57) int length = 0;

		this.bfsStepX[steps] = srcX;
		this.bfsStepZ[steps++] = srcZ;

		@Pc(70) boolean arrived = false;
		@Pc(74) int bufferSize = this.bfsStepX.length;
		@Pc(81) int[][] flags = this.levelCollisionMap[this.currentLevel].flags;

		while (length != steps) {
			x = this.bfsStepX[length];
			z = this.bfsStepZ[length];
			length = (length + 1) % bufferSize;

			if (x == dx && z == dz) {
				arrived = true;
				break;
			}

			if (locShape != 0) {
				if ((locShape < 5 || locShape == 10) && this.levelCollisionMap[this.currentLevel].reachedWall(locRotation, dz, locShape - 1, z, dx, x)) {
					arrived = true;
					break;
				}

				if (locShape < 10 && this.levelCollisionMap[this.currentLevel].reachedWallDecoration(locRotation, locShape - 1, x, dx, z, dz)) {
					arrived = true;
					break;
				}
			}

			if (locWidth != 0 && locLength != 0 && this.levelCollisionMap[this.currentLevel].reachedLoc(z, locLength, x, dx, forceapproach, dz, locWidth)) {
				arrived = true;
				break;
			}

			int nextCost = this.bfsCost[x][z] + 1;
			if (x > 0 && this.bfsDirection[x - 1][z] == 0 && (flags[x - 1][z] & 0x280108) == 0) {
				this.bfsStepX[steps] = x - 1;
				this.bfsStepZ[steps] = z;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x - 1][z] = 2;
				this.bfsCost[x - 1][z] = nextCost;
			}

			if (x < sceneWidth - 1 && this.bfsDirection[x + 1][z] == 0 && (flags[x + 1][z] & 0x280180) == 0) {
				this.bfsStepX[steps] = x + 1;
				this.bfsStepZ[steps] = z;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x + 1][z] = 8;
				this.bfsCost[x + 1][z] = nextCost;
			}

			if (z > 0 && this.bfsDirection[x][z - 1] == 0 && (flags[x][z - 1] & 0x280102) == 0) {
				this.bfsStepX[steps] = x;
				this.bfsStepZ[steps] = z - 1;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x][z - 1] = 1;
				this.bfsCost[x][z - 1] = nextCost;
			}

			if (z < sceneLength - 1 && this.bfsDirection[x][z + 1] == 0 && (flags[x][z + 1] & 0x280120) == 0) {
				this.bfsStepX[steps] = x;
				this.bfsStepZ[steps] = z + 1;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x][z + 1] = 4;
				this.bfsCost[x][z + 1] = nextCost;
			}

			if (x > 0 && z > 0 && this.bfsDirection[x - 1][z - 1] == 0 && (flags[x - 1][z - 1] & 0x28010E) == 0 && (flags[x - 1][z] & 0x280108) == 0 && (flags[x][z - 1] & 0x280102) == 0) {
				this.bfsStepX[steps] = x - 1;
				this.bfsStepZ[steps] = z - 1;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x - 1][z - 1] = 3;
				this.bfsCost[x - 1][z - 1] = nextCost;
			}

			if (x < sceneWidth - 1 && z > 0 && this.bfsDirection[x + 1][z - 1] == 0 && (flags[x + 1][z - 1] & 0x280183) == 0 && (flags[x + 1][z] & 0x280180) == 0 && (flags[x][z - 1] & 0x280102) == 0) {
				this.bfsStepX[steps] = x + 1;
				this.bfsStepZ[steps] = z - 1;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x + 1][z - 1] = 9;
				this.bfsCost[x + 1][z - 1] = nextCost;
			}

			if (x > 0 && z < sceneLength - 1 && this.bfsDirection[x - 1][z + 1] == 0 && (flags[x - 1][z + 1] & 0x280138) == 0 && (flags[x - 1][z] & 0x280108) == 0 && (flags[x][z + 1] & 0x280120) == 0) {
				this.bfsStepX[steps] = x - 1;
				this.bfsStepZ[steps] = z + 1;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x - 1][z + 1] = 6;
				this.bfsCost[x - 1][z + 1] = nextCost;
			}

			if (x < sceneWidth - 1 && z < sceneLength - 1 && this.bfsDirection[x + 1][z + 1] == 0 && (flags[x + 1][z + 1] & 0x2801E0) == 0 && (flags[x + 1][z] & 0x280180) == 0 && (flags[x][z + 1] & 0x280120) == 0) {
				this.bfsStepX[steps] = x + 1;
				this.bfsStepZ[steps] = z + 1;
				steps = (steps + 1) % bufferSize;
				this.bfsDirection[x + 1][z + 1] = 12;
				this.bfsCost[x + 1][z + 1] = nextCost;
			}
		}

		this.tryMoveNearest = 0;

		if (!arrived) {
			if (tryNearest) {
				int min = 100;
				for (int padding = 1; padding < 2; padding++) {
					for (int px = dx - padding; px <= dx + padding; px++) {
						for (int pz = dz - padding; pz <= dz + padding; pz++) {
							if (px >= 0 && pz >= 0 && px < 104 && pz < 104 && this.bfsCost[px][pz] < min) {
								min = this.bfsCost[px][pz];
								x = px;
								z = pz;
								this.tryMoveNearest = 1;
								arrived = true;
							}
						}
					}

					if (arrived) {
						break;
					}
				}
			}

			if (!arrived) {
				return false;
			}
		}

		length = 0;
		this.bfsStepX[length] = x;
		this.bfsStepZ[length++] = z;

		int dir = this.bfsDirection[x][z];
		int next = dir;
		while (x != srcX || z != srcZ) {
			if (next != dir) {
				dir = next;
				this.bfsStepX[length] = x;
				this.bfsStepZ[length++] = z;
			}

			if ((next & 0x2) != 0) {
				x++;
			} else if ((next & 0x8) != 0) {
				x--;
			}

			if ((next & 0x1) != 0) {
				z++;
			} else if ((next & 0x4) != 0) {
				z--;
			}

			next = this.bfsDirection[x][z];
		}

		if (length > 0) {
			bufferSize = length;

			if (length > 25) {
				bufferSize = 25;
			}

			length--;

			int startX = this.bfsStepX[length];
			int startZ = this.bfsStepZ[length];

			if (type == 0) {
				this.out.p1isaac(181);
				this.out.p1(bufferSize + bufferSize + 3);
			} else if (type == 1) {
				this.out.p1isaac(165);
				this.out.p1(bufferSize + bufferSize + 3 + 14);
			} else if (type == 2) {
				this.out.p1isaac(93);
				this.out.p1(bufferSize + bufferSize + 3);
			}

			if (super.actionKey[5] == 1) {
				this.out.p1(1);
			} else {
				this.out.p1(0);
			}

			this.out.p2(startX + this.sceneBaseTileX);
			this.out.p2(startZ + this.sceneBaseTileZ);
			this.flagSceneTileX = this.bfsStepX[0];
			this.flagSceneTileZ = this.bfsStepZ[0];

			for (@Pc(1077) int i = 1; i < bufferSize; i++) {
				length--;
				this.out.p1(this.bfsStepX[length] - startX);
				this.out.p1(this.bfsStepZ[length] - startZ);
			}

			return true;
		}

		return type != 1;
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!kb;II)V")
	private void readPlayerInfo(@OriginalArg(0) Packet buf, @OriginalArg(1) int size) {
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;

		this.readLocalPlayer(size, buf);
		this.readPlayers(size, buf);
		this.readNewPlayers(size, buf);
		this.readPlayerUpdates(size, buf);

		for (@Pc(29) int i = 0; i < this.entityRemovalCount; i++) {
			int index = this.entityRemovalIds[i];
			if (this.players[index].cycle != loopCycle) {
				this.players[index] = null;
			}
		}

		if (buf.pos != size) {
			signlink.reporterror("Error packet size mismatch in getplayer pos:" + buf.pos + " psize:" + size);
			throw new RuntimeException("eek");
		}

		for (int index = 0; index < this.playerCount; index++) {
			if (this.players[this.playerIds[index]] == null) {
				signlink.reporterror(this.username + " null entry in pl list - pos:" + index + " size:" + this.playerCount);
				throw new RuntimeException("eek");
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(III)Z")
	private boolean updateInterfaceAnimation(@OriginalArg(0) int id, @OriginalArg(1) int delta) {
		@Pc(3) boolean updated = false;
		@Pc(7) ComType parent = ComType.instances[id];
		for (@Pc(9) int i = 0; i < parent.childId.length && parent.childId[i] != -1; i++) {
			@Pc(24) ComType child = ComType.instances[parent.childId[i]];
			if (child.type == 1) {
				updated |= this.updateInterfaceAnimation(child.id, delta);
			}
			if (child.type == 6 && (child.seqId != -1 || child.activeSeqId != -1)) {
				@Pc(54) boolean active = this.executeInterfaceScript(child);
				@Pc(59) int seqId;
				if (active) {
					seqId = child.activeSeqId;
				} else {
					seqId = child.seqId;
				}
				if (seqId != -1) {
					@Pc(71) SeqType type = SeqType.instances[seqId];
					child.seqCycle += delta;
					while (child.seqCycle > type.delay[child.seqFrame]) {
						child.seqCycle -= type.delay[child.seqFrame] + 1;
						child.seqFrame++;
						if (child.seqFrame >= type.frameCount) {
							child.seqFrame -= type.replayoff;
							if (child.seqFrame < 0 || child.seqFrame >= type.frameCount) {
								child.seqFrame = 0;
							}
						}
						updated = true;
					}
				}
			}
		}
		return updated;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILjava/lang/String;BLjava/lang/String;)V")
	private void addMessage(@OriginalArg(0) int type, @OriginalArg(1) String message, @OriginalArg(3) String prefix) {
		if (type == 0 && this.stickyChatInterfaceId != -1) {
			this.modalMessage = message;
			super.mouseClickButton = 0;
		}
		if (this.chatInterfaceId == -1) {
			this.redrawChatback = true;
		}
		for (@Pc(20) int i = 99; i > 0; i--) {
			this.messageType[i] = this.messageType[i - 1];
			this.messageSender[i] = this.messageSender[i - 1];
			this.messageText[i] = this.messageText[i - 1];
		}
		this.messageType[0] = type;
		this.messageSender[0] = prefix;
		this.messageText[0] = message;
	}

	@OriginalMember(owner = "client!client", name = "i", descriptor = "(II)V")
	private void resetInterfaceAnimation(@OriginalArg(1) int id) {
		@Pc(3) ComType parent = ComType.instances[id];
		for (@Pc(5) int i = 0; i < parent.childId.length && parent.childId[i] != -1; i++) {
			@Pc(20) ComType child = ComType.instances[parent.childId[i]];
			if (child.type == 1) {
				this.resetInterfaceAnimation(child.id);
			}
			child.seqFrame = 0;
			child.seqCycle = 0;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IJ)V")
	private void removeFriend(@OriginalArg(1) long username) {
		if (username != 0L) {
			for (int i = 0; i < this.friendCount; i++) {
				if (this.friendName37[i] == username) {
					this.friendCount--;
					this.redrawSidebar = true;
					for (@Pc(38) int j = i; j < this.friendCount; j++) {
						this.friendName[j] = this.friendName[j + 1];
						this.friendWorld[j] = this.friendWorld[j + 1];
						this.friendName37[j] = this.friendName37[j + 1];
					}
					this.out.p1isaac(11);
					this.out.p8(username);
					return;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;I)Z")
	private boolean executeInterfaceScript(@OriginalArg(0) ComType component) {
		if (component.scriptComparator == null) {
			return false;
		}
		for (@Pc(6) int i = 0; i < component.scriptComparator.length; i++) {
			@Pc(14) int value = this.executeClientscript1(component, i);
			@Pc(19) int operand = component.scriptOperand[i];
			if (component.scriptComparator[i] == 2) {
				if (value >= operand) {
					return false;
				}
			} else if (component.scriptComparator[i] == 3) {
				if (value <= operand) {
					return false;
				}
			} else if (component.scriptComparator[i] == 4) {
				if (value == operand) {
					return false;
				}
			} else if (value != operand) {
				return false;
			}
		}
		return true;
	}

	@OriginalMember(owner = "client!client", name = "l", descriptor = "(B)V")
	private void handleMinimapInput() {
		if (super.mouseClickButton == 1) {
			@Pc(17) int x = super.mouseClickX - 21 - 561;
			@Pc(24) int y = super.mouseClickY - 9 - 5;

			if (x >= 0 && y >= 0 && x < 146 && y < 151) {
				x -= 73;
				y -= 75;

				@Pc(44) int yaw = this.orbitCameraYaw + this.minimapAnticheatAngle & 0x7FF;
				@Pc(48) int sinYaw = Draw3D.sin[yaw];
				@Pc(52) int cosYaw = Draw3D.cos[yaw];

				sinYaw = (sinYaw * (this.minimapZoom + 256)) >> 8;
				cosYaw = (cosYaw * (this.minimapZoom + 256)) >> 8;

				@Pc(80) int relX = y * sinYaw + x * cosYaw >> 11;
				@Pc(90) int relY = y * cosYaw - x * sinYaw >> 11;

				@Pc(98) int tileX = this.localPlayer.x + relX >> 7;
				@Pc(106) int tileZ = this.localPlayer.z - relY >> 7;

				@Pc(129) boolean success = this.tryMove(this.localPlayer.pathTileX[0], 0, true, tileX, this.localPlayer.pathTileZ[0], 1, 0, tileZ, 0, 0, 0);
				if (success) {
					// the additional 14-bytes in MOVE_MINIMAPCLICK
					this.out.p1(x);
					this.out.p1(y);
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
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(B)V")
	private void handleMouseInput() {
		if (this.objDragArea == 0) {
			@Pc(14) int button = super.mouseClickButton;
			if (this.spellSelected == 1 && super.mouseClickX >= 520 && super.mouseClickY >= 165 && super.mouseClickX <= 788 && super.mouseClickY <= 230) {
				button = 0;
			}

			if (this.menuVisible) {
				if (button != 1) {
					int x = super.mouseX;
					int y = super.mouseY;

					if (this.menuArea == 0) {
						x -= 8;
						y -= 11;
					} else if (this.menuArea == 1) {
						x -= 562;
						y -= 231;
					} else if (this.menuArea == 2) {
						x -= 22;
						y -= 375;
					}

					if (x < this.menuX - 10 || x > this.menuX + this.menuWidth + 10 || y < this.menuY - 10 || y > this.menuY + this.menuHeight + 10) {
						this.menuVisible = false;
						if (this.menuArea == 1) {
							this.redrawSidebar = true;
						}
						if (this.menuArea == 2) {
							this.redrawChatback = true;
						}
					}
				}

				if (button == 1) {
					int menuX = this.menuX;
					int menuY = this.menuY;
					int menuWidth = this.menuWidth;

					@Pc(127) int clickX = super.mouseClickX;
					@Pc(130) int clickY = super.mouseClickY;

					if (this.menuArea == 0) {
						clickX -= 8;
						clickY -= 11;
					} else if (this.menuArea == 1) {
						clickX -= 562;
						clickY -= 231;
					} else if (this.menuArea == 2) {
						clickX -= 22;
						clickY -= 375;
					}

					@Pc(149) int option = -1;
					for (@Pc(151) int i = 0; i < this.menuSize; i++) {
						@Pc(166) int optionY = menuY + (this.menuSize - 1 - i) * 15 + 31;
						if (clickX > menuX && clickX < menuX + menuWidth && clickY > optionY - 13 && clickY < optionY + 3) {
							option = i;
						}
					}

					if (option != -1) {
						this.useMenuOption(option);
					}

					this.menuVisible = false;
					if (this.menuArea == 1) {
						this.redrawSidebar = true;
					} else if (this.menuArea == 2) {
						this.redrawChatback = true;
					}
				}
			} else {
				if (button == 1 && this.menuSize > 0) {
					int action = this.menuAction[this.menuSize - 1];
					if (action == 602 || action == 596 || action == 22 || action == 892 || action == 415 || action == 405 || action == 38 || action == 422 || action == 478 || action == 347 || action == 188) {
						int slot = this.menuParamB[this.menuSize - 1];
						int comId = this.menuParamC[this.menuSize - 1];
						@Pc(283) ComType com = ComType.instances[comId];

						if (com.inventoryDraggable) {
							this.objGrabThreshold = false;
							this.objDragCycles = 0;
							this.objDragInterfaceId = comId;
							this.objDragSlot = slot;
							this.objDragArea = 2;
							this.objGrabX = super.mouseClickX;
							this.objGrabY = super.mouseClickY;

							if (ComType.instances[comId].parentId == this.viewportInterfaceID) {
								this.objDragArea = 1;
							}

							if (ComType.instances[comId].parentId == this.chatInterfaceId) {
								this.objDragArea = 3;
							}

							return;
						}
					}
				}

				if (button == 1 && (this.mouseButtonsOption == 1 || this.isAddFriendOption(this.menuSize - 1)) && this.menuSize > 2) {
					button = 2;
				}

				if (button == 1 && this.menuSize > 0) {
					this.useMenuOption(this.menuSize - 1);
				}

				if (button != 2 || this.menuSize <= 0) {
					return;
				}

				this.showContextMenu();
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(B)V")
	private void applyCutscene() {
		@Pc(6) int x = this.cutsceneSrcLocalTileX * 128 + 64;
		@Pc(13) int z = this.cutsceneSrcLocalTileZ * 128 + 64;
		@Pc(26) int y = this.getHeightmapY(this.currentLevel, this.cutsceneSrcLocalTileX, this.cutsceneSrcLocalTileZ) - this.cutsceneSrcHeight;

		if (this.cameraX < x) {
			this.cameraX += this.cutsceneMoveSpeed + (x - this.cameraX) * this.cutsceneMoveAcceleration / 1000;
			if (this.cameraX > x) {
				this.cameraX = x;
			}
		}

		if (this.cameraX > x) {
			this.cameraX -= this.cutsceneMoveSpeed + (this.cameraX - x) * this.cutsceneMoveAcceleration / 1000;
			if (this.cameraX < x) {
				this.cameraX = x;
			}
		}

		if (this.cameraY < y) {
			this.cameraY += this.cutsceneMoveSpeed + (y - this.cameraY) * this.cutsceneMoveAcceleration / 1000;
			if (this.cameraY > y) {
				this.cameraY = y;
			}
		}

		if (this.cameraY > y) {
			this.cameraY -= this.cutsceneMoveSpeed + (this.cameraY - y) * this.cutsceneMoveAcceleration / 1000;
			if (this.cameraY < y) {
				this.cameraY = y;
			}
		}

		if (this.cameraZ < z) {
			this.cameraZ += this.cutsceneMoveSpeed + (z - this.cameraZ) * this.cutsceneMoveAcceleration / 1000;
			if (this.cameraZ > z) {
				this.cameraZ = z;
			}
		}

		if (this.cameraZ > z) {
			this.cameraZ -= this.cutsceneMoveSpeed + (this.cameraZ - z) * this.cutsceneMoveAcceleration / 1000;
			if (this.cameraZ < z) {
				this.cameraZ = z;
			}
		}

		x = this.cutsceneDstLocalTileX * 128 + 64;
		z = this.cutsceneDstLocalTileZ * 128 + 64;
		y = this.getHeightmapY(this.currentLevel, this.cutsceneDstLocalTileX, this.cutsceneDstLocalTileZ) - this.cutsceneDstHeight;

		@Pc(226) int deltaX = x - this.cameraX;
		@Pc(231) int deltaY = y - this.cameraY;
		@Pc(236) int deltaZ = z - this.cameraZ;

		@Pc(247) int distance = (int) Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
		@Pc(258) int pitch = (int) (Math.atan2(deltaY, distance) * 325.949D) & 0x7FF;
		@Pc(269) int yaw = (int) (Math.atan2(deltaX, deltaZ) * -325.949D) & 0x7FF;

		if (pitch < 128) {
			pitch = 128;
		}

		if (pitch > 383) {
			pitch = 383;
		}

		if (this.cameraPitch < pitch) {
			this.cameraPitch += this.cutsceneRotateSpeed + (pitch - this.cameraPitch) * this.cutsceneRotateAcceleration / 1000;
			if (this.cameraPitch > pitch) {
				this.cameraPitch = pitch;
			}
		}

		if (this.cameraPitch > pitch) {
			this.cameraPitch -= this.cutsceneRotateSpeed + (this.cameraPitch - pitch) * this.cutsceneRotateAcceleration / 1000;
			if (this.cameraPitch < pitch) {
				this.cameraPitch = pitch;
			}
		}

		@Pc(344) int deltaYaw = yaw - this.cameraYaw;
		if (deltaYaw > 1024) {
			deltaYaw -= 2048;
		}

		if (deltaYaw < -1024) {
			deltaYaw += 2048;
		}

		if (deltaYaw > 0) {
			this.cameraYaw += this.cutsceneRotateSpeed + deltaYaw * this.cutsceneRotateAcceleration / 1000;
			this.cameraYaw &= 0x7FF;
		}

		if (deltaYaw < 0) {
			this.cameraYaw -= this.cutsceneRotateSpeed + -deltaYaw * this.cutsceneRotateAcceleration / 1000;
			this.cameraYaw &= 0x7FF;
		}

		@Pc(402) int tmp = yaw - this.cameraYaw;
		if (tmp > 1024) {
			tmp -= 2048;
		}

		if (tmp < -1024) {
			tmp += 2048;
		}

		if (tmp < 0 && deltaYaw > 0 || tmp > 0 && deltaYaw < 0) {
			this.cameraYaw = yaw;
		}
	}

	@OriginalMember(owner = "client!client", name = "C", descriptor = "(I)V")
	private void handleTabInput() {
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
			sidebarInputCounter++;
			if (sidebarInputCounter > 150) {
				sidebarInputCounter = 0;
				this.out.p1isaac(233);
				this.out.p1(43);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;B)Z")
	private boolean handleSocialMenuOption(@OriginalArg(0) ComType component) {
		@Pc(2) int type = component.contentType;
		if (type >= 1 && type <= 200) {
			if (type >= 101) {
				type -= 101;
			} else {
				type--;
			}
			this.menuOption[this.menuSize] = "Remove @whi@" + this.friendName[type];
			this.menuAction[this.menuSize] = 557;
			this.menuSize++;
			this.menuOption[this.menuSize] = "Message @whi@" + this.friendName[type];
			this.menuAction[this.menuSize] = 679;
			this.menuSize++;
			return true;
		} else if (type >= 401 && type <= 500) {
			this.menuOption[this.menuSize] = "Remove @whi@" + component.text;
			this.menuAction[this.menuSize] = 556;
			this.menuSize++;
			return true;
		} else {
			return false;
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(ILclient!kb;I)V")
	private void readNpcs(@OriginalArg(1) Packet buf, @OriginalArg(2) int size) {
		buf.accessBits();

		@Pc(14) int count = buf.gBit(8);
		if (count < this.npcCount) {
			for (int i = count; i < this.npcCount; i++) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.npcIds[i];
			}
		}

		if (count > this.npcCount) {
			signlink.reporterror(this.username + " Too many npcs");
			throw new RuntimeException("eek");
		}

		this.npcCount = 0;
		for (int i = 0; i < count; i++) {
			@Pc(72) int index = this.npcIds[i];
			@Pc(77) NpcEntity npc = this.npcs[index];

			@Pc(82) int hasUpdate = buf.gBit(1);
			if (hasUpdate == 0) {
				this.npcIds[this.npcCount++] = index;
				npc.cycle = loopCycle;
			} else {
				@Pc(105) int updateType = buf.gBit(2);

				if (updateType == 0) {
					this.npcIds[this.npcCount++] = index;
					npc.cycle = loopCycle;
					this.entityUpdateIds[this.entityUpdateCount++] = index;
				} else if (updateType == 1) {
					this.npcIds[this.npcCount++] = index;
					npc.cycle = loopCycle;

					int walkDir = buf.gBit(3);
					npc.step(false, walkDir);

					int hasMaskUpdate = buf.gBit(1);
					if (hasMaskUpdate == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = index;
					}
				} else if (updateType == 2) {
					this.npcIds[this.npcCount++] = index;
					npc.cycle = loopCycle;

					int walkDir = buf.gBit(3);
					npc.step(true, walkDir);
					int runDir = buf.gBit(3);
					npc.step(true, runDir);

					@Pc(224) int hasMaskUpdate = buf.gBit(1);
					if (hasMaskUpdate == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = index;
					}
				} else if (updateType == 3) {
					this.entityRemovalIds[this.entityRemovalCount++] = index;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "getParameter", descriptor = "(Ljava/lang/String;)Ljava/lang/String;")
	@Override
	public String getParameter(@OriginalArg(0) String name) {
		return signlink.mainapp == null ? super.getParameter(name) : signlink.mainapp.getParameter(name);
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
			@Pc(60) ClientStream stream = this.stream;
			this.ingame = false;
			this.login(this.username, this.password, true);
			if (!this.ingame) {
				this.logout();
			}
			try {
				stream.close();
			} catch (@Pc(80) Exception ex) {
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!ib;)V")
	private void updateFlameBuffer(@OriginalArg(1) Pix8 image) {
		@Pc(3) short flameHeight = 256;
		for (@Pc(5) int i = 0; i < this.flameBuffer0.length; i++) {
			this.flameBuffer0[i] = 0;
		}

		for (@Pc(20) int i = 0; i < 5000; i++) {
			int rand = (int) (Math.random() * 128.0D * (double) flameHeight);
			this.flameBuffer0[rand] = (int) (Math.random() * 256.0D);
		}

		for (int i = 0; i < 20; i++) {
			for (int y = 1; y < flameHeight - 1; y++) {
				for (int x = 1; x < 127; x++) {
					int index = x + (y << 7);
					this.flameBuffer1[index] = (this.flameBuffer0[index - 1] + this.flameBuffer0[index + 1] + this.flameBuffer0[index - 128] + this.flameBuffer0[index + 128]) / 4;
				}
			}

			@Pc(106) int[] last = this.flameBuffer0;
			this.flameBuffer0 = this.flameBuffer1;
			this.flameBuffer1 = last;
		}

		if (image != null) {
			int off = 0;

			for (int y = 0; y < image.height; y++) {
				for (int x = 0; x < image.width; x++) {
					if (image.pixels[off++] != 0) {
						@Pc(152) int x0 = x + image.cropX + 16;
						@Pc(159) int y0 = y + image.cropY + 16;
						@Pc(165) int index = x0 + (y0 << 7);
						this.flameBuffer0[index] = 0;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(II)V")
	private void sortObjStacks(@OriginalArg(0) int x, @OriginalArg(1) int z) {
		@Pc(9) LinkList objStacks = this.levelObjStacks[this.currentLevel][x][z];
		if (objStacks == null) {
			this.scene.removeObjStack(this.currentLevel, x, z);
			return;
		}

		@Pc(21) int topCost = -99999999;
		@Pc(23) ObjStackEntity topObj = null;

		for (ObjStackEntity obj = (ObjStackEntity) objStacks.peekFront(); obj != null; obj = (ObjStackEntity) objStacks.prev()) {
			@Pc(32) ObjType type = ObjType.get(obj.index);
			int cost = type.cost;

			if (type.stackable) {
				cost *= obj.count + 1;
			}

			if (cost > topCost) {
				topCost = cost;
				topObj = obj;
			}
		}

		objStacks.pushFront(topObj);

		@Pc(65) int bottomObjId = -1;
		int middleObjId = -1;
		@Pc(69) int bottomObjCount = 0;
		@Pc(71) int middleObjCount = 0;
		for (ObjStackEntity obj = (ObjStackEntity) objStacks.peekFront(); obj != null; obj = (ObjStackEntity) objStacks.prev()) {
			if (obj.index != topObj.index && bottomObjId == -1) {
				bottomObjId = obj.index;
				bottomObjCount = obj.count;
			}

			if (obj.index != topObj.index && obj.index != bottomObjId && middleObjId == -1) {
				middleObjId = obj.index;
				middleObjCount = obj.count;
			}
		}

		@Pc(118) Model bottomObj = null;
		if (bottomObjId != -1) {
			bottomObj = ObjType.get(bottomObjId).getInterfaceModel(bottomObjCount);
		}

		@Pc(128) Model middleObj = null;
		if (middleObjId != -1) {
			middleObj = ObjType.get(middleObjId).getInterfaceModel(middleObjCount);
		}

		@Pc(144) int bitset = x + (z << 7) + 1610612736;
		@Pc(148) ObjType type = ObjType.get(topObj.index);
		this.scene.addObjStack(type.getInterfaceModel(topObj.count), bottomObj, this.getHeightmapY(this.currentLevel, x * 128 + 64, z * 128 + 64), this.currentLevel, bitset, z, x, middleObj);
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
			this.scene.reset();
			for (@Pc(28) int level = 0; level < 4; level++) {
				this.levelCollisionMap[level].reset();
			}
			System.gc();

			@Pc(53) World world = new World(104, this.levelTileFlags, 104, this.levelHeightmap);
			World.lowMemory = World3D.lowMemory;

			@Pc(60) int maps = this.sceneMapLandData.length;

			for (@Pc(64) int index = 0; index < maps; index++) {
				int mapsquareX = this.sceneMapIndex[index] >> 8;
				int mapsquareZ = this.sceneMapIndex[index] & 0xFF;

				// underground pass check
				if (mapsquareX == 33 && mapsquareZ >= 71 && mapsquareZ <= 73) {
					World.lowMemory = false;
				}
			}

			if (World.lowMemory) {
				this.scene.setMinLevel(this.currentLevel);
			} else {
				this.scene.setMinLevel(0);
			}

			@Pc(56) byte[] data = new byte[100000];
			this.out.p1isaac(108);
			for (int i = 0; i < maps; i++) {
				int x = (this.sceneMapIndex[i] >> 8) * 64 - this.sceneBaseTileX;
				@Pc(143) int z = (this.sceneMapIndex[i] & 0xFF) * 64 - this.sceneBaseTileZ;
				@Pc(148) byte[] src = this.sceneMapLandData[i];

				if (src != null) {
					int length = (new Packet(src)).g4();
					BZip2.read(data, length, src, src.length - 4, 4);
					world.readLandscape(data, (this.sceneCenterZoneX - 6) * 8, z, x, (this.sceneCenterZoneZ - 6) * 8);
				} else if (this.sceneCenterZoneZ < 800) {
					world.clearLandscape(x, z, 64, 64);
				}
			}

			this.out.p1isaac(108);
			for (int i = 0; i < maps; i++) {
				@Pc(216) byte[] src = this.sceneMapLocData[i];
				if (src != null) {
					int length = (new Packet(src)).g4();
					BZip2.read(data, length, src, src.length - 4, 4);
					int x = (this.sceneMapIndex[i] >> 8) * 64 - this.sceneBaseTileX;
					@Pc(259) int z = (this.sceneMapIndex[i] & 0xFF) * 64 - this.sceneBaseTileZ;
					world.readLocs(data, this.scene, this.levelCollisionMap, this.locList, z, x);
				}
			}

			this.out.p1isaac(108);
			world.build(this.scene, this.levelCollisionMap);
			this.areaViewport.bind();
			this.out.p1isaac(108);
			for (@Pc(301) LocEntity loc = (LocEntity) this.locList.peekFront(); loc != null; loc = (LocEntity) this.locList.prev()) {
				if ((this.levelTileFlags[1][loc.heightmapNE][loc.heightmapNW] & 0x2) == 2) {
					loc.heightmapSW--;
					if (loc.heightmapSW < 0) {
						loc.unlink();
					}
				}
			}

			for (int x = 0; x < 104; x++) {
				for (int z = 0; z < 104; z++) {
					this.sortObjStacks(x, z);
				}
			}

			for (@Pc(361) LocTemporary loc = (LocTemporary) this.spawnedLocations.peekFront(); loc != null; loc = (LocTemporary) this.spawnedLocations.prev()) {
				this.addLoc(loc.orientation, loc.x, loc.z, loc.classType, loc.locIndex, loc.type, loc.plane);
			}
		} catch (@Pc(390) Exception ignored) {
		}

		LocType.modelCacheStatic.clear();
		System.gc();
		Draw3D.initPool(20);
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(I)V")
	@Override
	protected void update() {
		if (!this.errorStarted && !this.errorLoading && !this.errorHost) {
			loopCycle++;
			if (this.ingame) {
				this.updateGame();
			} else {
				this.updateTitle();
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "o", descriptor = "(B)V")
	private void updateEntityChats() {
		for (@Pc(8) int i = -1; i < this.playerCount; i++) {
			int index;
			if (i == -1) {
				index = this.LOCAL_PLAYER_INDEX;
			} else {
				index = this.playerIds[i];
			}

			@Pc(28) PlayerEntity player = this.players[index];
			if (player != null && player.chatTimer > 0) {
				player.chatTimer--;

				if (player.chatTimer == 0) {
					player.chat = null;
				}
			}
		}

		for (int i = 0; i < this.npcCount; i++) {
			@Pc(59) int index = this.npcIds[i];
			@Pc(64) NpcEntity npc = this.npcs[index];

			if (npc != null && npc.chatTimer > 0) {
				npc.chatTimer--;

				if (npc.chatTimer == 0) {
					npc.chat = null;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;ZI)I")
	private int executeClientscript1(@OriginalArg(0) ComType component, @OriginalArg(2) int scriptId) {
		if (component.scripts == null || scriptId >= component.scripts.length) {
			return -2;
		}

		try {
			@Pc(26) int[] script = component.scripts[scriptId];
			@Pc(28) int register = 0;
			@Pc(30) int pc = 0;

			while (true) {
				@Pc(35) int opcode = script[pc++];
				if (opcode == 0) {
					return register;
				}

				if (opcode == 1) { // load_skill_level {skill}
					register += this.skillLevel[script[pc++]];
				} else if (opcode == 2) { // load_skill_base_level {skill}
					register += this.skillBaseLevel[script[pc++]];
				} else if (opcode == 3) { // load_skill_exp {skill}
					register += this.skillExperience[script[pc++]];
				} else if (opcode == 4) { // load_inv_count {interface id} {obj id}
					ComType com = ComType.instances[script[pc++]];
					int obj = script[pc++] + 1;

					for (int i = 0; i < com.inventorySlotObjId.length; i++) {
						if (com.inventorySlotObjId[i] == obj) {
							register += com.inventorySlotObjCount[i];
						}
					}
				} else if (opcode == 5) { // load_var {id}
					register += this.varps[script[pc++]];
				} else if (opcode == 6) { // load_next_level_xp {skill}
					register += levelExperience[this.skillBaseLevel[script[pc++]] - 1];
				} else if (opcode == 7) {
					register += this.varps[script[pc++]] * 100 / 46875;
				} else if (opcode == 8) { // load_combat_level
					register += this.localPlayer.combatLevel;
				} else if (opcode == 9) { // load_total_level
					for (int i = 0; i < 19; i++) {
						if (i == 18) {
							// runecrafting
							i = 20;
						}

						register += this.skillBaseLevel[i];
					}
				} else if (opcode == 10) { // load_inv_contains {interface id} {obj id}
					ComType com = ComType.instances[script[pc++]];
					int obj = script[pc++] + 1;

					for (int i = 0; i < com.inventorySlotObjId.length; i++) {
						if (com.inventorySlotObjId[i] == obj) {
							register += 999999999;
							break;
						}
					}
				} else if (opcode == 11) { // load_energy
					register += this.energy;
				} else if (opcode == 12) { // load_weight
					register += this.weightCarried;
				} else if (opcode == 13) { // load_bool {varp} {bit: 0..31}
					int varp = this.varps[script[pc++]];
					int lsb = script[pc++];

					register += (varp & 0x1 << lsb) == 0 ? 0 : 1;
				}
			}
		} catch (@Pc(282) Exception ex) {
			return -1;
		}
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(Z)V")
	private void drawError() {
		@Pc(4) Graphics g = this.getBaseComponent().getGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, 789, 532);
		this.setFramerate(1);

		if (this.errorLoading) {
			this.flameActive = false;
			int y = 35;

			g.setFont(new Font("Helvetica", Font.BOLD, 16));
			g.setColor(Color.yellow);
			g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, y);
			y += 50;

			g.setColor(Color.white);
			g.drawString("To fix this try the following (in order):", 30, y);
			y += 50;

			g.setColor(Color.white);
			g.setFont(new Font("Helvetica", Font.BOLD, 12));
			g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, y);
			y += 30;

			g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, y);
			y += 30;

			g.drawString("3: Try using a different game-world", 30, y);
			y += 30;

			g.drawString("4: Try rebooting your computer", 30, y);
			y += 30;

			g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, y);
		}

		if (this.errorHost) {
			this.flameActive = false;
			g.setFont(new Font("Helvetica", Font.BOLD, 20));
			g.setColor(Color.white);
			g.drawString("Error - unable to load game!", 50, 50);
			g.drawString("To play RuneScape make sure you play from", 50, 100);
			g.drawString("http://www.runescape.com", 50, 150);
		}

		if (this.errorStarted) {
			this.flameActive = false;
			int y = 35;

			g.setColor(Color.yellow);
			g.drawString("Error a copy of RuneScape already appears to be loaded", 30, y);
			y += 50;

			g.setColor(Color.white);
			g.drawString("To fix this try the following (in order):", 30, y);
			y += 50;

			g.setColor(Color.white);
			g.setFont(new Font("Helvetica", Font.BOLD, 12));
			g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, y);
			y += 30;

			g.drawString("2: Try rebooting your computer, and reloading", 30, y);
			y += 30;
		}
	}

	@OriginalMember(owner = "client!client", name = "p", descriptor = "(B)V")
	private void loadTitleBackground() {
		@Pc(8) byte[] data = this.archiveTitle.read("title.dat", null);
		@Pc(14) Pix24 title = new Pix24(data, this);
		this.imageTitle0.bind();
		title.blitOpaque(0, 0);

		this.imageTitle1.bind();
		title.blitOpaque(-661, 0);

		this.imageTitle2.bind();
		title.blitOpaque(-128, 0);

		this.imageTitle3.bind();
		title.blitOpaque(-214, -386);

		this.imageTitle4.bind();
		title.blitOpaque(-214, -186);

		this.imageTitle5.bind();
		title.blitOpaque(0, -265);

		this.imageTitle6.bind();
		title.blitOpaque(-574, -265);

		this.imageTitle7.bind();
		title.blitOpaque(-128, -186);

		this.imageTitle8.bind();
		title.blitOpaque(-574, -186);

		@Pc(110) int[] mirror = new int[title.width];
		for (@Pc(112) int y = 0; y < title.height; y++) {
			for (@Pc(116) int x = 0; x < title.width; x++) {
				mirror[x] = title.pixels[title.width + title.width * y - x - 1];
			}

			if (title.width >= 0) {
				System.arraycopy(mirror, 0, title.pixels, 0 + title.width * y, title.width);
			}
		}

		this.imageTitle0.bind();
		title.blitOpaque(394, 0);

		this.imageTitle1.bind();
		title.blitOpaque(-267, 0);

		this.imageTitle2.bind();
		title.blitOpaque(266, 0);

		this.imageTitle3.bind();
		title.blitOpaque(180, -386);

		this.imageTitle4.bind();
		title.blitOpaque(180, -186);

		this.imageTitle5.bind();
		title.blitOpaque(394, -265);

		this.imageTitle6.bind();
		title.blitOpaque(-180, -265);

		this.imageTitle7.bind();
		title.blitOpaque(212, -186);

		this.imageTitle8.bind();
		title.blitOpaque(-180, -186);

		title = new Pix24(this.archiveTitle, "logo", 0);
		this.imageTitle2.bind();
		title.draw(18, super.screenWidth / 2 - title.width / 2 - 128);
		title = null;

		// some null objects may force garbage collection threshold
		@Pc(278) Object dummy1 = null;
		@Pc(280) Object dummy2 = null;
		System.gc();
	}

	@OriginalMember(owner = "client!client", name = "E", descriptor = "(I)V")
	private void pushLocs() {
		for (@Pc(10) LocEntity loc = (LocEntity) this.locList.peekFront(); loc != null; loc = (LocEntity) this.locList.prev()) {
			@Pc(14) boolean append = false;
			loc.seqCycle += this.sceneDelta;
			if (loc.seqFrame == -1) {
				loc.seqFrame = 0;
				append = true;
			}

			while (loc.seqCycle > loc.seq.delay[loc.seqFrame]) {
				loc.seqCycle -= loc.seq.delay[loc.seqFrame] + 1;
				loc.seqFrame++;

				append = true;

				if (loc.seqFrame >= loc.seq.frameCount) {
					loc.seqFrame -= loc.seq.replayoff;

                    if (loc.seqFrame < 0 || loc.seqFrame >= loc.seq.frameCount) {
						loc.unlink();
						append = false;
						break;
                    }
                }
			}

			if (append) {
				@Pc(96) int level = loc.heightmapSW;
				@Pc(99) int x = loc.heightmapNE;
				@Pc(102) int z = loc.heightmapNW;

				@Pc(104) int bitset = 0;
				if (loc.heightmapSE == 0) {
					bitset = this.scene.getWallBitset(level, x, z);
				}

				if (loc.heightmapSE == 1) {
					bitset = this.scene.getWallDecorationBitset(level, z, x);
				}

				if (loc.heightmapSE == 2) {
					bitset = this.scene.getLocBitset(level, x, z);
				}

				if (loc.heightmapSE == 3) {
					bitset = this.scene.getGroundDecorationBitset(level, x, z);
				}

				if (bitset != 0 && (bitset >> 14 & 0x7FFF) == loc.index) {
					@Pc(171) int heightmapSW = this.levelHeightmap[level][x][z];
					@Pc(182) int heightmapSE = this.levelHeightmap[level][x + 1][z];
					@Pc(195) int heightmapNE = this.levelHeightmap[level][x + 1][z + 1];
					@Pc(206) int heightmapNW = this.levelHeightmap[level][x][z + 1];

					@Pc(210) LocType type = LocType.get(loc.index);
					@Pc(212) int seqId = -1;
					if (loc.seqFrame != -1) {
						seqId = loc.seq.frames[loc.seqFrame];
					}

					if (loc.heightmapSE == 2) {
						int info = this.scene.getInfo(level, x, z, bitset);
						int shape = info & 0x1F;
						int rotation = info >> 6;
						if (shape == 11) {
							shape = 10;
						}

						Model model = type.getModel(shape, rotation, heightmapSW, heightmapSE, heightmapNE, heightmapNW, seqId);
						this.scene.setLocModel(x, model, level, z);
					} else if (loc.heightmapSE == 1) {
						@Pc(282) Model model = type.getModel(4, 0, heightmapSW, heightmapSE, heightmapNE, heightmapNW, seqId);
						this.scene.setWallDecorationModel(z, x, model, level);
					} else if (loc.heightmapSE == 0) {
						int info = this.scene.getInfo(level, x, z, bitset);
						int shape = info & 0x1F;
						int rotation = info >> 6;

						if (shape == 2) {
							@Pc(320) int nextRotation = rotation + 1 & 0x3;
							@Pc(332) Model model1 = type.getModel(2, rotation + 4, heightmapSW, heightmapSE, heightmapNE, heightmapNW, seqId);
							@Pc(342) Model mmodel2 = type.getModel(2, nextRotation, heightmapSW, heightmapSE, heightmapNE, heightmapNW, seqId);
							this.scene.setWallModels(model1, mmodel2, z, x, level);
						} else {
							Model model = type.getModel(shape, rotation, heightmapSW, heightmapSE, heightmapNE, heightmapNW, seqId);
							this.scene.setWallModel(model, z, x, level);
						}
					} else if (loc.heightmapSE == 3) {
						int info = this.scene.getInfo(level, x, z, bitset);
						int rotation = info >> 6;
						@Pc(400) Model model = type.getModel(22, rotation, heightmapSW, heightmapSE, heightmapNE, heightmapNW, seqId);
						this.scene.setGroundDecorationModel(model, z, x, level);
					}
				} else {
					loc.unlink();
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IJ)V")
	private void removeIgnore(@OriginalArg(1) long username) {
		if (username != 0L) {
			for (@Pc(14) int i = 0; i < this.ignoreCount; i++) {
				if (this.ignoreName37[i] == username) {
					this.ignoreCount--;
					this.redrawSidebar = true;
					for (@Pc(34) int j = i; j < this.ignoreCount; j++) {
						this.ignoreName37[j] = this.ignoreName37[j + 1];
					}
					this.out.p1isaac(171);
					this.out.p8(username);
					return;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "q", descriptor = "(B)V")
	private void handleViewportOptions() {
		if (this.objSelected == 0 && this.spellSelected == 0) {
			this.menuOption[this.menuSize] = "Walk here";
			this.menuAction[this.menuSize] = 660;
			this.menuParamB[this.menuSize] = super.mouseX;
			this.menuParamC[this.menuSize] = super.mouseY;
			this.menuSize++;
		}

		@Pc(41) int lastBitset = -1;
		for (@Pc(52) int picked = 0; picked < Model.pickedCount; picked++) {
			@Pc(58) int bitset = Model.pickedBitsets[picked];
			@Pc(62) int x = bitset & 0x7F;
			@Pc(68) int z = bitset >> 7 & 0x7F;
			@Pc(74) int entityType = bitset >> 29 & 0x3;
			@Pc(80) int typeId = bitset >> 14 & 0x7FFF;

            if (bitset == lastBitset) {
                continue;
            }

            lastBitset = bitset;

            if (entityType == 2 && this.scene.getInfo(this.currentLevel, x, z, bitset) >= 0) {
                @Pc(100) LocType loc = LocType.get(typeId);
                if (this.objSelected == 1) {
                    this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @cya@" + loc.name;
                    this.menuAction[this.menuSize] = 450;
                    this.menuParamA[this.menuSize] = bitset;
                    this.menuParamB[this.menuSize] = x;
                    this.menuParamC[this.menuSize] = z;
                    this.menuSize++;
                } else if (this.spellSelected != 1) {
                    if (loc.ops != null) {
                        for (int op = 4; op >= 0; op--) {
                            if (loc.ops[op] != null) {
                                this.menuOption[this.menuSize] = loc.ops[op] + " @cya@" + loc.name;
                                if (op == 0) {
                                    this.menuAction[this.menuSize] = 285;
                                }

                                if (op == 1) {
                                    this.menuAction[this.menuSize] = 504;
                                }

                                if (op == 2) {
                                    this.menuAction[this.menuSize] = 364;
                                }

                                if (op == 3) {
                                    this.menuAction[this.menuSize] = 581;
                                }

                                if (op == 4) {
                                    this.menuAction[this.menuSize] = 1501;
                                }

                                this.menuParamA[this.menuSize] = bitset;
                                this.menuParamB[this.menuSize] = x;
                                this.menuParamC[this.menuSize] = z;
                                this.menuSize++;
                            }
                        }
                    }

                    this.menuOption[this.menuSize] = "Examine @cya@" + loc.name;
                    this.menuAction[this.menuSize] = 1175;
                    this.menuParamA[this.menuSize] = bitset;
                    this.menuParamB[this.menuSize] = x;
                    this.menuParamC[this.menuSize] = z;
                    this.menuSize++;
                } else if ((this.activeSpellFlags & 0x4) == 4) {
                    this.menuOption[this.menuSize] = this.spellCaption + " @cya@" + loc.name;
                    this.menuAction[this.menuSize] = 55;
                    this.menuParamA[this.menuSize] = bitset;
                    this.menuParamB[this.menuSize] = x;
                    this.menuParamC[this.menuSize] = z;
                    this.menuSize++;
                }
            }

            if (entityType == 1) {
                @Pc(366) NpcEntity npc = this.npcs[typeId];
                if (npc.type.size == 1 && (npc.x & 0x7F) == 64 && (npc.z & 0x7F) == 64) {
                    for (int i = 0; i < this.npcCount; i++) {
                        NpcEntity other = this.npcs[this.npcIds[i]];

                        if (other != null && other != npc && other.type.size == 1 && other.x == npc.x && other.z == npc.z) {
                            this.addNpcOptions(other.type, z, x, this.npcIds[i]);
                        }
                    }
                }

                this.addNpcOptions(npc.type, z, x, typeId);
            }

            if (entityType == 0) {
                @Pc(446) PlayerEntity player = this.players[typeId];
                if ((player.x & 0x7F) == 64 && (player.z & 0x7F) == 64) {
                    for (int i = 0; i < this.npcCount; i++) {
                        NpcEntity other = this.npcs[this.npcIds[i]];

                        if (other != null && other.type.size == 1 && other.x == player.x && other.z == player.z) {
                            this.addNpcOptions(other.type, z, x, this.npcIds[i]);
                        }
                    }

                    for (@Pc(505) int i = 0; i < this.playerCount; i++) {
                        @Pc(515) PlayerEntity other = this.players[this.playerIds[i]];

                        if (other != null && other != player && other.x == player.x && other.z == player.z) {
                            this.addPlayerOptions(z, this.playerIds[i], other, x);
                        }
                    }
                }

                this.addPlayerOptions(z, typeId, player, x);
            }

            if (entityType == 3) {
                @Pc(565) LinkList objs = this.levelObjStacks[this.currentLevel][x][z];
                if (objs == null) {
                    continue;
                }

                for (@Pc(572) ObjStackEntity obj = (ObjStackEntity) objs.peekBack(); obj != null; obj = (ObjStackEntity) objs.next()) {
                    @Pc(578) ObjType type = ObjType.get(obj.index);
                    if (this.objSelected == 1) {
                        this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + type.name;
                        this.menuAction[this.menuSize] = 217;
                        this.menuParamA[this.menuSize] = obj.index;
                        this.menuParamB[this.menuSize] = x;
                        this.menuParamC[this.menuSize] = z;
                        this.menuSize++;
                    } else if (this.spellSelected != 1) {
                        for (@Pc(695) int op = 4; op >= 0; op--) {
                            if (type.ops != null && type.ops[op] != null) {
                                this.menuOption[this.menuSize] = type.ops[op] + " @lre@" + type.name;
                                if (op == 0) {
                                    this.menuAction[this.menuSize] = 224;
                                }

                                if (op == 1) {
                                    this.menuAction[this.menuSize] = 993;
                                }

                                if (op == 2) {
                                    this.menuAction[this.menuSize] = 99;
                                }

                                if (op == 3) {
                                    this.menuAction[this.menuSize] = 746;
                                }

                                if (op == 4) {
                                    this.menuAction[this.menuSize] = 877;
                                }

                                this.menuParamA[this.menuSize] = obj.index;
                                this.menuParamB[this.menuSize] = x;
                                this.menuParamC[this.menuSize] = z;
                                this.menuSize++;
                            } else if (op == 2) {
                                this.menuOption[this.menuSize] = "Take @lre@" + type.name;
                                this.menuAction[this.menuSize] = 99;
                                this.menuParamA[this.menuSize] = obj.index;
                                this.menuParamB[this.menuSize] = x;
                                this.menuParamC[this.menuSize] = z;
                                this.menuSize++;
                            }
                        }

                        this.menuOption[this.menuSize] = "Examine @lre@" + type.name;
                        this.menuAction[this.menuSize] = 1102;
                        this.menuParamA[this.menuSize] = obj.index;
                        this.menuParamB[this.menuSize] = x;
                        this.menuParamC[this.menuSize] = z;
                        this.menuSize++;
                    } else if ((this.activeSpellFlags & 0x1) == 1) {
                        this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + type.name;
                        this.menuAction[this.menuSize] = 965;
                        this.menuParamA[this.menuSize] = obj.index;
                        this.menuParamB[this.menuSize] = x;
                        this.menuParamC[this.menuSize] = z;
                        this.menuSize++;
                    }
                }
            }
        }
	}

	@OriginalMember(owner = "client!client", name = "n", descriptor = "(Z)V")
	private void updatePlayers() {
		for (@Pc(9) int i = -1; i < this.playerCount; i++) {
			int index;
			if (i == -1) {
				index = this.LOCAL_PLAYER_INDEX;
			} else {
				index = this.playerIds[i];
			}

			@Pc(29) PlayerEntity player = this.players[index];
			if (player != null) {
				this.updateEntity(player, 1);
			}
		}

		updatePlayersCounter++;
		if (updatePlayersCounter > 1406) {
			updatePlayersCounter = 0;
			this.out.p1isaac(219);
			this.out.p1(0);
			int start = this.out.pos;
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
			this.out.psize1(this.out.pos - start);
		}
	}

	@OriginalMember(owner = "client!client", name = "r", descriptor = "(B)V")
	private void drawTileHint() {
		if (this.hintType == 2) {
			this.projectFromGround((this.hintTileZ - this.sceneBaseTileZ << 7) + this.hintOffsetZ, (this.hintTileX - this.sceneBaseTileX << 7) + this.hintOffsetX, this.hintHeight * 2);
			if (this.projectX > -1 && loopCycle % 20 < 10) {
				this.imageHeadicons[2].draw(this.projectY - 28, this.projectX - 12);
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(IILclient!kb;)V")
	private void readLocalPlayer(@OriginalArg(1) int size, @OriginalArg(2) Packet buf) {
		buf.accessBits();

		@Pc(7) int hasUpdate = buf.gBit(1);
		if (hasUpdate != 0) {
			@Pc(21) int updateType = buf.gBit(2);

			if (updateType == 0) {
				this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
			} else if (updateType == 1) {
				int walkDir = buf.gBit(3);
				this.localPlayer.step(false, walkDir);

				int hasMaskUpdate = buf.gBit(1);
				if (hasMaskUpdate == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				}
			} else if (updateType == 2) {
				int walkDir = buf.gBit(3);
				this.localPlayer.step(true, walkDir);
				int runDir = buf.gBit(3);
				this.localPlayer.step(true, runDir);

				int hasMaskUpdate = buf.gBit(1);
				if (hasMaskUpdate == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
				}
			} else if (updateType == 3) {
				this.currentLevel = buf.gBit(2);
				int localX = buf.gBit(7);
				int localZ = buf.gBit(7);
				int jump = buf.gBit(1);
				this.localPlayer.move(jump == 1, localX, localZ);

				@Pc(158) int hasMaskUpdate = buf.gBit(1);
				if (hasMaskUpdate == 1) {
					this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
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
			this.drawInterface(0, 0, ComType.instances[this.chatInterfaceId], 0);
		} else if (this.stickyChatInterfaceId == -1) {
			@Pc(135) PixFont font = this.fontPlain12;
			@Pc(137) int line = 0;
			Draw2D.setBounds(77, 0, 463, 0);
			for (@Pc(145) int i = 0; i < 100; i++) {
				if (this.messageText[i] != null) {
					@Pc(157) int type = this.messageType[i];
					@Pc(166) int offset = this.chatScrollOffset + 70 - line * 14;
					if (type == 0) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 0, this.messageText[i]);
						}
						line++;
					}
					if (type == 1) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 16777215, this.messageSender[i] + ":");
							font.drawString(font.stringWidth(this.messageSender[i]) + 12, offset, 255, this.messageText[i]);
						}
						line++;
					}
					if (type == 2 && (this.publicChatSetting == 0 || this.publicChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 0, this.messageSender[i] + ":");
							font.drawString(font.stringWidth(this.messageSender[i]) + 12, offset, 255, this.messageText[i]);
						}
						line++;
					}
					if ((type == 3 || type == 7) && this.splitPrivateChat == 0 && (type == 7 || this.privateChatSetting == 0 || this.privateChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 0, "From " + this.messageSender[i] + ":");
							font.drawString(font.stringWidth("From " + this.messageSender[i]) + 12, offset, 8388608, this.messageText[i]);
						}
						line++;
					}
					if (type == 4 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 8388736, this.messageSender[i] + " " + this.messageText[i]);
						}
						line++;
					}
					if (type == 5 && this.splitPrivateChat == 0 && this.privateChatSetting < 2) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 8388608, this.messageText[i]);
						}
						line++;
					}
					if (type == 6 && this.splitPrivateChat == 0 && this.privateChatSetting < 2) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 0, "To " + this.messageSender[i] + ":");
							font.drawString(font.stringWidth("To " + this.messageSender[i]) + 12, offset, 8388608, this.messageText[i]);
						}
						line++;
					}
					if (type == 8 && (this.tradeChatSetting == 0 || this.tradeChatSetting == 1 && this.isFriend(this.messageSender[i]))) {
						if (offset > 0 && offset < 110) {
							font.drawString(4, offset, 13350793, this.messageSender[i] + " " + this.messageText[i]);
						}
						line++;
					}
				}
			}
			Draw2D.resetBounds();
			this.chatScrollHeight = line * 14 + 7;
			if (this.chatScrollHeight < 78) {
				this.chatScrollHeight = 78;
			}
			this.drawScrollbar(463, 0, this.chatScrollHeight - this.chatScrollOffset - 77, this.chatScrollHeight, 77);
			font.drawString(4, 90, 0, JString.formatName(this.username) + ":");
			font.drawString(font.stringWidth(this.username + ": ") + 6, 90, 255, this.chatTyped + "*");
			Draw2D.drawHorizontalLine(0, 77, 479, 0);
		} else {
			this.drawInterface(0, 0, ComType.instances[this.stickyChatInterfaceId], 0);
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
		if (this.stream == null) {
			return false;
		}

		try {
			@Pc(15) int available = this.stream.available();
			if (available == 0) {
				return false;
			}

			if (this.packetType == -1) {
				this.stream.read(this.in.data, 0, 1);
				this.packetType = this.in.data[0] & 0xFF;
				if (this.randomIn != null) {
					this.packetType = (this.packetType - this.randomIn.nextInt()) & 0xFF;
				}
				this.packetSize = Protocol.SERVERPROT_SIZES[this.packetType];
				available--;
			}

			if (this.packetSize == -1) {
				if (available <= 0) {
					return false;
				}

				this.stream.read(this.in.data, 0, 1);
				this.packetSize = this.in.data[0] & 0xFF;
				available--;
			}

			if (this.packetSize == -2) {
				if (available <= 1) {
					return false;
				}

				this.stream.read(this.in.data, 0, 2);
				this.in.pos = 0;
				this.packetSize = this.in.g2();
				available -= 2;
			}

			if (available < this.packetSize) {
				return false;
			}

			this.in.pos = 0;
			this.stream.read(this.in.data, 0, this.packetSize);
			this.idleNetCycles = 0;
			this.lastPacketType2 = this.lastPacketType1;
			this.lastPacketType1 = this.lastPacketType0;
			this.lastPacketType0 = this.packetType;

			if (this.packetType == 150) {
				// VARP_SMALL
				int varp = this.in.g2();
				@Pc(163) byte value = this.in.g1b();
				this.varCache[varp] = value;
				if (this.varps[varp] != value) {
					this.varps[varp] = value;
					this.updateVarp(varp);
					this.redrawSidebar = true;
					if (this.stickyChatInterfaceId != -1) {
						this.redrawChatback = true;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 152) {
				// UPDATE_FRIENDLIST
				long username = this.in.g8();
				int world = this.in.g1();
				@Pc(217) String displayName = JString.formatName(JString.fromBase37(username));
				for (int i = 0; i < this.friendCount; i++) {
					if (username == this.friendName37[i]) {
						if (this.friendWorld[i] != world) {
							this.friendWorld[i] = world;
							this.redrawSidebar = true;
							if (world > 0) {
								this.addMessage(5, displayName + " has logged in.", "");
							}
							if (world == 0) {
								this.addMessage(5, displayName + " has logged out.", "");
							}
						}
						displayName = null;
						break;
					}
				}
				if (displayName != null && this.friendCount < 100) {
					this.friendName37[this.friendCount] = username;
					this.friendName[this.friendCount] = displayName;
					this.friendWorld[this.friendCount] = world;
					this.friendCount++;
					this.redrawSidebar = true;
				}
				@Pc(315) boolean sorted = false;
				while (!sorted) {
					sorted = true;
					for (int i = 0; i < this.friendCount - 1; i++) {
						if (this.friendWorld[i] != nodeId && this.friendWorld[i + 1] == nodeId || this.friendWorld[i] == 0 && this.friendWorld[i + 1] != 0) {
							int oldWorld = this.friendWorld[i];
							this.friendWorld[i] = this.friendWorld[i + 1];
							this.friendWorld[i + 1] = oldWorld;

							@Pc(376) String oldName = this.friendName[i];
							this.friendName[i] = this.friendName[i + 1];
							this.friendName[i + 1] = oldName;

							@Pc(398) long oldName37 = this.friendName37[i];
							this.friendName37[i] = this.friendName37[i + 1];
							this.friendName37[i + 1] = oldName37;
							this.redrawSidebar = true;
							sorted = false;
						}
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 43) {
				// UPDATE_REBOOT_TIMER
				this.systemUpdateTimer = this.in.g2() * 30;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 80) {
				// DATA_LAND_DONE
				int x = this.in.g1();
				int z = this.in.g1();
				int index = -1;
				for (int i = 0; i < this.sceneMapIndex.length; i++) {
					if (this.sceneMapIndex[i] == (x << 8) + z) {
						index = i;
					}
				}
				if (index != -1) {
					signlink.cachesave("m" + x + "_" + z, this.sceneMapLandData[index]);
					this.sceneState = 1;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 1) {
				// NPC_INFO
				this.readNpcInfo(this.in, this.packetSize);
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 237) {
				// LOAD_AREA
				int zoneX = this.in.g2();
				int zoneZ = this.in.g2();
				if (this.sceneCenterZoneX == zoneX && this.sceneCenterZoneZ == zoneZ && this.sceneState != 0) {
					this.packetType = -1;
					return true;
				}
				this.sceneCenterZoneX = zoneX;
				this.sceneCenterZoneZ = zoneZ;
				this.sceneBaseTileX = (this.sceneCenterZoneX - 6) * 8;
				this.sceneBaseTileZ = (this.sceneCenterZoneZ - 6) * 8;
				this.sceneState = 1;
				this.areaViewport.bind();
				this.fontPlain12.drawStringCenter(151, 0, "Loading - please wait.", 257);
				this.fontPlain12.drawStringCenter(150, 16777215, "Loading - please wait.", 256);
				this.areaViewport.draw(11, super.graphics, 8);
				signlink.looprate(5);
				int regions = (this.packetSize - 2) / 10;
				this.sceneMapLandData = new byte[regions][];
				this.sceneMapLocData = new byte[regions][];
				this.sceneMapIndex = new int[regions];
				this.out.p1isaac(150);
				this.out.p1(0);
				int mapCount = 0;
				for (int i = 0; i < regions; i++) {
					int mapsquareX = this.in.g1();
					int mapsquareZ = this.in.g1();
					int landCrc = this.in.g4();
					int locCrc = this.in.g4();
					this.sceneMapIndex[i] = (mapsquareX << 8) + mapsquareZ;
					@Pc(686) byte[] data;
					if (landCrc != 0) {
						data = signlink.cacheload("m" + mapsquareX + "_" + mapsquareZ);
						if (data != null) {
							this.crc32.reset();
							this.crc32.update(data);
							if ((int) this.crc32.getValue() != landCrc) {
								data = null;
							}
						}
						if (data == null) {
							this.sceneState = 0;
							this.out.p1(0);
							this.out.p1(mapsquareX);
							this.out.p1(mapsquareZ);
							mapCount += 3;
						} else {
							this.sceneMapLandData[i] = data;
						}
					}
					if (locCrc != 0) {
						data = signlink.cacheload("l" + mapsquareX + "_" + mapsquareZ);
						if (data != null) {
							this.crc32.reset();
							this.crc32.update(data);
							if ((int) this.crc32.getValue() != locCrc) {
								data = null;
							}
						}
						if (data == null) {
							this.sceneState = 0;
							this.out.p1(1);
							this.out.p1(mapsquareX);
							this.out.p1(mapsquareZ);
							mapCount += 3;
						} else {
							this.sceneMapLocData[i] = data;
						}
					}
				}
				this.out.psize1(mapCount);
				signlink.looprate(50);
				this.areaViewport.bind();
				if (this.sceneState == 0) {
					this.fontPlain12.drawStringCenter(166, 0, "Map area updated since last visit, so load will take longer this time only", 257);
					this.fontPlain12.drawStringCenter(165, 16777215, "Map area updated since last visit, so load will take longer this time only", 256);
				}
				this.areaViewport.draw(11, super.graphics, 8);
				int dx = this.sceneBaseTileX - this.mapLastBaseX;
				int dz = this.sceneBaseTileZ - this.mapLastBaseZ;
				this.mapLastBaseX = this.sceneBaseTileX;
				this.mapLastBaseZ = this.sceneBaseTileZ;
				for (int i = 0; i < 8192; i++) {
					@Pc(856) NpcEntity npc = this.npcs[i];
					if (npc != null) {
						for (@Pc(860) int j = 0; j < 10; j++) {
							npc.pathTileX[j] -= dx;
							npc.pathTileZ[j] -= dz;
						}
						npc.x -= dx * 128;
						npc.z -= dz * 128;
					}
				}
				for (int i = 0; i < this.MAX_PLAYER_COUNT; i++) {
					@Pc(911) PlayerEntity player = this.players[i];
					if (player != null) {
						for (@Pc(915) int j = 0; j < 10; j++) {
							player.pathTileX[j] -= dx;
							player.pathTileZ[j] -= dz;
						}
						player.x -= dx * 128;
						player.z -= dz * 128;
					}
				}
				@Pc(960) byte startTileX = 0;
				@Pc(962) byte endTileX = 104;
				@Pc(964) byte dirX = 1;
				if (dx < 0) {
					startTileX = 103;
					endTileX = -1;
					dirX = -1;
				}
				@Pc(974) byte startTileZ = 0;
				@Pc(976) byte endTileZ = 104;
				@Pc(978) byte dirZ = 1;
				if (dz < 0) {
					startTileZ = 103;
					endTileZ = -1;
					dirZ = -1;
				}
				for (@Pc(988) int x = startTileX; x != endTileX; x += dirX) {
					for (@Pc(992) int z = startTileZ; z != endTileZ; z += dirZ) {
						@Pc(998) int lastX = x + dx;
						@Pc(1002) int lastZ = z + dz;
						for (@Pc(1004) int level = 0; level < 4; level++) {
							if (lastX >= 0 && lastZ >= 0 && lastX < 104 && lastZ < 104) {
								this.levelObjStacks[level][x][z] = this.levelObjStacks[level][lastX][lastZ];
							} else {
								this.levelObjStacks[level][x][z] = null;
							}
						}
					}
				}
				for (@Pc(1066) LocTemporary loc = (LocTemporary) this.spawnedLocations.peekFront(); loc != null; loc = (LocTemporary) this.spawnedLocations.prev()) {
					loc.x -= dx;
					loc.z -= dz;
					if (loc.x < 0 || loc.z < 0 || loc.x >= 104 || loc.z >= 104) {
						loc.unlink();
					}
				}
				if (this.flagSceneTileX != 0) {
					this.flagSceneTileX -= dx;
					this.flagSceneTileZ -= dz;
				}
				this.cutscene = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 197) {
				// IF_SETPLAYERHEAD
				int com = this.in.g2();
				ComType.instances[com].model = this.localPlayer.getHeadModel();
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
				// MIDI_SONG
				String name = this.in.gjstr();
				int crc = this.in.g4();
				int length = this.in.g4();
				if (!name.equals(this.currentMidi) && this.midiActive && !lowMemory) {
					this.setMidi(crc, name, length);
				}
				this.currentMidi = name;
				this.midiCrc = crc;
				this.midiSize = length;
				this.nextMusicDelay = 0;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 142) {
				// LOGOUT
				this.logout();
				this.packetType = -1;
				return false;
			}
			if (this.packetType == 20) {
				// DATA_LOC_DONE
				int x = this.in.g1();
				int z = this.in.g1();
				int index = -1;
				for (int i = 0; i < this.sceneMapIndex.length; i++) {
					if (this.sceneMapIndex[i] == (x << 8) + z) {
						index = i;
					}
				}
				if (index != -1) {
					signlink.cachesave("l" + x + "_" + z, this.sceneMapLocData[index]);
					this.sceneState = 1;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 19) {
				// CLEAR_WALKING_QUEUE
				this.flagSceneTileX = 0;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 139) {
				// UPDATE_UID192
				this.localPid = this.in.g2();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 151 || this.packetType == 23 || this.packetType == 50 || this.packetType == 191 || this.packetType == 69 || this.packetType == 49 || this.packetType == 223 || this.packetType == 42 || this.packetType == 76 || this.packetType == 59) {
				// Zone Protocol
				this.readZonePacket(this.in, this.packetType);
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 28) {
				// IF_OPENMAINMODALSIDEOVERLAY
				int main = this.in.g2();
				int side = this.in.g2();
				if (this.chatInterfaceId != -1) {
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
				}
				if (this.chatbackInputOpen) {
					this.chatbackInputOpen = false;
					this.redrawChatback = true;
				}
				this.viewportInterfaceID = main;
				this.sidebarInterfaceId = side;
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 175) {
				// VARP_LARGE
				int varp = this.in.g2();
				int value = this.in.g4();
				this.varCache[varp] = value;
				if (this.varps[varp] != value) {
					this.varps[varp] = value;
					this.updateVarp(varp);
					this.redrawSidebar = true;
					if (this.stickyChatInterfaceId != -1) {
						this.redrawChatback = true;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 146) {
				// IF_SETANIM
				int com = this.in.g2();
				int seqId = this.in.g2();
				ComType.instances[com].seqId = seqId;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 167) {
				// IF_SETTAB
				int com = this.in.g2();
				int tab = this.in.g1();
				if (com == 65535) {
					com = -1;
				}
				this.tabInterfaceId[tab] = com;
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 220) {
				// DATA_LOC
				int x = this.in.g1();
				int z = this.in.g1();
				int off = this.in.g2();
				int length = this.in.g2();
				int index = -1;
				for (int i = 0; i < this.sceneMapIndex.length; i++) {
					if (this.sceneMapIndex[i] == (x << 8) + z) {
						index = i;
					}
				}
				if (index != -1) {
					if (this.sceneMapLocData[index] == null || this.sceneMapLocData[index].length != length) {
						this.sceneMapLocData[index] = new byte[length];
					}
					this.in.gdata(this.packetSize - 6, off, this.sceneMapLocData[index]);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 133) {
				// FINISH_TRACKING
				@Pc(1701) Packet tracking = InputTracking.stop();
				if (tracking != null) {
					this.out.p1isaac(81);
					this.out.p2(tracking.pos);
					this.out.pdata(tracking.data, tracking.pos, 0);
					tracking.release();
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 98) {
				// UPDATE_INV_FULL
				this.redrawSidebar = true;
				int com = this.in.g2();
				ComType inv = ComType.instances[com];
				int size = this.in.g1();
				for (int i = 0; i < size; i++) {
					inv.inventorySlotObjId[i] = this.in.g2();
					int count = this.in.g1();
					if (count == 255) {
						count = this.in.g4();
					}
					inv.inventorySlotObjCount[i] = count;
				}
				for (int i = size; i < inv.inventorySlotObjId.length; i++) {
					inv.inventorySlotObjId[i] = 0;
					inv.inventorySlotObjCount[i] = 0;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 226) {
				// ENABLE_TRACKING
				InputTracking.setEnabled();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 243) {
				// IF_IAMOUNT
				this.showSocialInput = false;
				this.chatbackInputOpen = true;
				this.chatbackInput = "";
				this.redrawChatback = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 15) {
				// UPDATE_INV_STOP_TRANSMIT
				int com = this.in.g2();
				ComType inv = ComType.instances[com];
				for (int i = 0; i < inv.inventorySlotObjId.length; i++) {
					inv.inventorySlotObjId[i] = -1;
					inv.inventorySlotObjId[i] = 0;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 140) {
				// LAST_LOGIN_INFO
				this.lastAddress = this.in.g4();
				this.daysSinceLastLogin = this.in.g2();
				this.daysSinceRecoveriesChanged = this.in.g1();
				this.unreadMessages = this.in.g2();
				if (this.lastAddress != 0 && this.viewportInterfaceID == -1) {
					signlink.dnslookup(JString.formatIPv4(this.lastAddress));
					this.closeInterfaces();
					@Pc(1915) short contentType = 650;
					if (this.daysSinceRecoveriesChanged != 201) {
						contentType = 655;
					}
					this.reportAbuseInput = "";
					this.reportAbuseMuteOption = false;
					for (int i = 0; i < ComType.instances.length; i++) {
						if (ComType.instances[i] != null && ComType.instances[i].contentType == contentType) {
							this.viewportInterfaceID = ComType.instances[i].parentId;
							break;
						}
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 126) {
				// IF_SETTAB_FLASH
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
				// MIDI_JINGLE
				if (this.midiActive && !lowMemory) {
					int delay = this.in.g2();
					int length = this.in.g4();
					int remaining = this.packetSize - 6;
					@Pc(2018) byte[] src = new byte[length];
					BZip2.read(src, length, this.in.data, remaining, this.in.pos);
					this.saveMidi(src, length, 0);
					this.nextMusicDelay = delay;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 254) {
				// IF_MULTIZONE
				this.inMultizone = this.in.g1();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 12) {
				// SYNTH_SOUND
				int id = this.in.g2();
				int loop = this.in.g1();
				int delay = this.in.g2();
				if (this.waveEnabled && !lowMemory && this.waveCount < 50) {
					this.waveIds[this.waveCount] = id;
					this.waveLoops[this.waveCount] = loop;
					this.waveDelay[this.waveCount] = delay + Wave.delays[id];
					this.waveCount++;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 204) {
				// IF_SETNPCHEAD
				int com = this.in.g2();
				int npcId = this.in.g2();
				@Pc(2130) NpcType npc = NpcType.get(npcId);
				ComType.instances[com].model = npc.getHeadModel();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 7) {
				// UPDATE_ZONE_PARTIAL_FOLLOWS
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 103) {
				// IF_SETMODEL_COLOUR
				int com = this.in.g2();
				int src = this.in.g2();
				int dst = this.in.g2();
				ComType inter = ComType.instances[com];
				@Pc(2184) Model model = inter.model;
				if (model != null) {
					model.recolor(src, dst);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 32) {
				// CHAT_FILTER_SETTINGS
				this.publicChatSetting = this.in.g1();
				this.privateChatSetting = this.in.g1();
				this.tradeChatSetting = this.in.g1();
				this.redrawPrivacySettings = true;
				this.redrawChatback = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 195) {
				// IF_OPENSIDEOVERLAY
				int com = this.in.g2();
				this.resetInterfaceAnimation(com);
				if (this.chatInterfaceId != -1) {
					this.chatInterfaceId = -1;
					this.redrawChatback = true;
				}
				if (this.chatbackInputOpen) {
					this.chatbackInputOpen = false;
					this.redrawChatback = true;
				}
				this.sidebarInterfaceId = com;
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.viewportInterfaceID = -1;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 14) {
				// IF_OPENCHAT
				int com = this.in.g2();
				this.resetInterfaceAnimation(com);
				if (this.sidebarInterfaceId != -1) {
					this.sidebarInterfaceId = -1;
					this.redrawSidebar = true;
					this.redrawSideicons = true;
				}
				this.chatInterfaceId = com;
				this.redrawChatback = true;
				this.viewportInterfaceID = -1;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 209) {
				// IF_SETPOSITION
				int com = this.in.g2();
				int x = this.in.g2b();
				int z = this.in.g2b();
				ComType inter = ComType.instances[com];
				inter.x = x;
				inter.y = z;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 3) {
				// CAM_LOOKAT
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
				// UPDATE_ZONE_FULL_FOLLOWS
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1();
				for (int x = this.baseX; x < this.baseX + 8; x++) {
					for (int z = this.baseZ; z < this.baseZ + 8; z++) {
						if (this.levelObjStacks[this.currentLevel][x][z] != null) {
							this.levelObjStacks[this.currentLevel][x][z] = null;
							this.sortObjStacks(x, z);
						}
					}
				}
				for (@Pc(2487) LocTemporary loc = (LocTemporary) this.spawnedLocations.peekFront(); loc != null; loc = (LocTemporary) this.spawnedLocations.prev()) {
					if (loc.x >= this.baseX && loc.x < this.baseX + 8 && loc.z >= this.baseZ && loc.z < this.baseZ + 8 && loc.plane == this.currentLevel) {
						this.addLoc(loc.lastOrientation, loc.x, loc.z, loc.classType, loc.lastLocIndex, loc.lastType, loc.plane);
						loc.unlink();
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 132) {
				// DATA_LAND
				int x = this.in.g1();
				int z = this.in.g1();
				int offset = this.in.g2();
				int length = this.in.g2();
				int index = -1;
				for (int i = 0; i < this.sceneMapIndex.length; i++) {
					if (this.sceneMapIndex[i] == (x << 8) + z) {
						index = i;
					}
				}
				if (index != -1) {
					if (this.sceneMapLandData[index] == null || this.sceneMapLandData[index].length != length) {
						this.sceneMapLandData[index] = new byte[length];
					}
					this.in.gdata(this.packetSize - 6, offset, this.sceneMapLandData[index]);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 41) {
				// MESSAGE_PRIVATE
				long from = this.in.g8();
				int messageId = this.in.g4();
				int staffModLevel = this.in.g1();
				boolean ignored = false;
				for (int i = 0; i < 100; i++) {
					if (this.messageIds[i] == messageId) {
						ignored = true;
						break;
					}
				}
				if (staffModLevel <= 1) {
					for (int i = 0; i < this.ignoreCount; i++) {
						if (this.ignoreName37[i] == from) {
							ignored = true;
							break;
						}
					}
				}
				if (!ignored && this.overrideChat == 0) {
					try {
						this.messageIds[this.privateMessageCount] = messageId;
						this.privateMessageCount = (this.privateMessageCount + 1) % 100;
						@Pc(2721) String uncompressed = WordPack.unpack(this.in, this.packetSize - 13);
						@Pc(2725) String filtered = WordFilter.filter(uncompressed);
						if (staffModLevel > 1) {
							this.addMessage(7, filtered, JString.formatName(JString.fromBase37(from)));
						} else {
							this.addMessage(3, filtered, JString.formatName(JString.fromBase37(from)));
						}
					} catch (@Pc(2752) Exception ex) {
						signlink.reporterror("cde1");
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 193) {
				// RESET_CLIENT_VARCACHE
				for (int i = 0; i < this.varps.length; i++) {
					if (this.varps[i] != this.varCache[i]) {
						this.varps[i] = this.varCache[i];
						this.updateVarp(i);
						this.redrawSidebar = true;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 87) {
				// IF_SETMODEL
				int com = this.in.g2();
				int model = this.in.g2();
				ComType.instances[com].model = new Model(model);
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 185) {
				// IF_OPENCHATSTICKY
				int com = this.in.g2b();
				this.stickyChatInterfaceId = com;
				this.redrawChatback = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 68) {
				// UPDATE_RUNENERGY
				if (this.selectedTab == 12) {
					this.redrawSidebar = true;
				}
				this.energy = this.in.g1();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 74) {
				// CAM_MOVETO
				this.cutscene = true;
				this.cutsceneDstLocalTileX = this.in.g1();
				this.cutsceneDstLocalTileZ = this.in.g1();
				this.cutsceneDstHeight = this.in.g2();
				this.cutsceneRotateSpeed = this.in.g1();
				this.cutsceneRotateAcceleration = this.in.g1();
				if (this.cutsceneRotateAcceleration >= 100) {
					int sceneX = this.cutsceneDstLocalTileX * 128 + 64;
					int sceneZ = this.cutsceneDstLocalTileZ * 128 + 64;
					int sceneY = this.getHeightmapY(this.currentLevel, this.cutsceneDstLocalTileX, this.cutsceneDstLocalTileZ) - this.cutsceneDstHeight;
					int deltaX = sceneX - this.cameraX;
					int deltaY = sceneY - this.cameraY;
					int deltaZ = sceneZ - this.cameraZ;
					int distance = (int) Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
					this.cameraPitch = (int) (Math.atan2(deltaY, distance) * 325.949D) & 0x7FF;
					this.cameraYaw = (int) (Math.atan2(deltaX, deltaZ) * -325.949D) & 0x7FF;
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
				// IF_SETTAB_ACTIVE
				this.selectedTab = this.in.g1();
				this.redrawSidebar = true;
				this.redrawSideicons = true;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 4) {
				// MESSAGE_GAME
				String message = this.in.gjstr();
				@Pc(3043) long username;
				if (message.endsWith(":tradereq:")) {
					String player = message.substring(0, message.indexOf(":"));
					username = JString.toBase37(player);
					boolean ignored = false;
					for (int i = 0; i < this.ignoreCount; i++) {
						if (this.ignoreName37[i] == username) {
							ignored = true;
							break;
						}
					}
					if (!ignored && this.overrideChat == 0) {
						this.addMessage(4, "wishes to trade with you.", player);
					}
				} else if (message.endsWith(":duelreq:")) {
					String player = message.substring(0, message.indexOf(":"));
					username = JString.toBase37(player);
					boolean ignored = false;
					for (int i = 0; i < this.ignoreCount; i++) {
						if (this.ignoreName37[i] == username) {
							ignored = true;
							break;
						}
					}
					if (!ignored && this.overrideChat == 0) {
						this.addMessage(8, "wishes to duel with you.", player);
					}
				} else {
					this.addMessage(0, message, "");
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 46) {
				// IF_SETOBJECT
				int com = this.in.g2();
				int objId = this.in.g2();
				int zoom = this.in.g2();
				@Pc(3157) ObjType obj = ObjType.get(objId);
				ComType.instances[com].model = obj.getInterfaceModel(50);
				ComType.instances[com].modelPitch = obj.xan2d;
				ComType.instances[com].modelYaw = obj.yan2d;
				ComType.instances[com].modelZoom = obj.zoom2d * 100 / zoom;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 168) {
				// IF_OPENMAIN
				int com = this.in.g2();
				this.resetInterfaceAnimation(com);
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
				this.viewportInterfaceID = com;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 2) {
				// IF_SETCOLOUR
				int com = this.in.g2();
				int color = this.in.g2();
				int r = color >> 10 & 0x1F;
				int g = color >> 5 & 0x1F;
				int b = color & 0x1F;
				ComType.instances[com].color = (r << 19) + (g << 11) + (b << 3);
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 136) {
				// RESET_ANIMS
				for (int i = 0; i < this.players.length; i++) {
					if (this.players[i] != null) {
						this.players[i].primarySeqId = -1;
					}
				}
				for (int i = 0; i < this.npcs.length; i++) {
					if (this.npcs[i] != null) {
						this.npcs[i].primarySeqId = -1;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 26) {
				// IF_SETHIDE
				int com = this.in.g2();
				@Pc(3362) boolean hide = this.in.g1() == 1;
				ComType.instances[com].hide = hide;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 21) {
				// UPDATE_IGNORELIST
				this.ignoreCount = this.packetSize / 8;
				for (int i = 0; i < this.ignoreCount; i++) {
					this.ignoreName37[i] = this.in.g8();
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 239) {
				// CAM_RESET
				this.cutscene = false;
				for (int i = 0; i < 5; i++) {
					this.cameraModifierEnabled[i] = false;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 129) {
				// IF_CLOSE
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
				this.viewportInterfaceID = -1;
				this.pressedContinueOption = false;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 201) {
				// IF_SETTEXT
				int com = this.in.g2();
				String text = this.in.gjstr();
				ComType.instances[com].text = text;
				if (ComType.instances[com].parentId == this.tabInterfaceId[this.selectedTab]) {
					this.redrawSidebar = true;
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 44) {
				// UPDATE_STAT
				this.redrawSidebar = true;
				int stat = this.in.g1();
				int xp = this.in.g4();
				int level = this.in.g1();
				this.skillExperience[stat] = xp;
				this.skillLevel[stat] = level;
				this.skillBaseLevel[stat] = 1;
				for (int i = 0; i < 98; i++) {
					if (xp >= levelExperience[i]) {
						this.skillBaseLevel[stat] = i + 2;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 162) {
				// UPDATE_ZONE_PARTIAL_ENCLOSED
				this.baseX = this.in.g1();
				this.baseZ = this.in.g1();
				while (this.in.pos < this.packetSize) {
					int opcode = this.in.g1();
					this.readZonePacket(this.in, opcode);
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 22) {
				// UPDATE_RUNWEIGHT
				if (this.selectedTab == 12) {
					this.redrawSidebar = true;
				}
				this.weightCarried = this.in.g2b();
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 13) {
				// CAM_SHAKE
				int type = this.in.g1();
				int jitter = this.in.g1();
				int wobbleScale = this.in.g1();
				int wobbleSpeed = this.in.g1();
				this.cameraModifierEnabled[type] = true;
				this.cameraModifierJitter[type] = jitter;
				this.cameraModifierWobbleScale[type] = wobbleScale;
				this.cameraModifierWobbleSpeed[type] = wobbleSpeed;
				this.cameraModifierCycle[type] = 0;
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 213) {
				// UPDATE_INV_PARTIAL
				this.redrawSidebar = true;
				int com = this.in.g2();
				ComType inv = ComType.instances[com];
				while (this.in.pos < this.packetSize) {
					int slot = this.in.g1();
					int id = this.in.g2();
					int count = this.in.g1();
					if (count == 255) {
						count = this.in.g4();
					}
					if (slot >= 0 && slot < inv.inventorySlotObjId.length) {
						inv.inventorySlotObjId[slot] = id;
						inv.inventorySlotObjCount[slot] = count;
					}
				}
				this.packetType = -1;
				return true;
			}
			if (this.packetType == 184) {
				// PLAYER_INFO
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
			signlink.reporterror("T1 - " + this.packetType + "," + this.packetSize + " - " + this.lastPacketType1 + "," + this.lastPacketType2);
			this.logout();
		} catch (@Pc(3862) IOException ex) {
			this.tryReconnect();
		} catch (@Pc(3867) Exception ex) {
			String error = "T2 - " + this.packetType + "," + this.lastPacketType1 + "," + this.lastPacketType2 + " - " + this.packetSize + "," + (this.sceneBaseTileX + this.localPlayer.pathTileX[0]) + "," + (this.sceneBaseTileZ + this.localPlayer.pathTileZ[0]) + " - ";
			for (int i = 0; i < this.packetSize && i < 50; i++) {
				error = error + this.in.data[i] + ",";
			}
			signlink.reporterror(error);
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
			this.drawInterface(0, 0, ComType.instances[this.sidebarInterfaceId], 0);
		} else if (this.tabInterfaceId[this.selectedTab] != -1) {
			this.drawInterface(0, 0, ComType.instances[this.tabInterfaceId[this.selectedTab]], 0);
		}
		if (this.menuVisible && this.menuArea == 1) {
			this.drawMenu();
		}
		this.areaSidebar.draw(231, super.graphics, 562);
		this.areaViewport.bind();
		Draw3D.lineOffset = this.areaViewportOffsets;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILjava/lang/String;)Z")
	private boolean isFriend(@OriginalArg(1) String username) {
		if (username == null) {
			return false;
		}
		for (@Pc(15) int i = 0; i < this.friendCount; i++) {
			if (username.equalsIgnoreCase(this.friendName[i])) {
				return true;
			}
		}
		return username.equalsIgnoreCase(this.localPlayer.name);
	}

	@OriginalMember(owner = "client!client", name = "init", descriptor = "()V")
	@Override
	public void init() {
		nodeId = Integer.parseInt(this.getParameter("nodeid"));
		portOffset = Integer.parseInt(this.getParameter("portoff"));
		@Pc(15) String lowmem = this.getParameter("lowmem");
		if (lowmem != null && lowmem.equals("1")) {
			setLowMemory();
		} else {
			setHighMemory();
		}
		@Pc(31) String free = this.getParameter("free");
		members = free == null || !free.equals("1");
		this.initApplet(532, 789);
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZIILclient!kb;Lclient!z;)V")
	private void readPlayerUpdates(@OriginalArg(1) int id, @OriginalArg(2) int mask, @OriginalArg(3) Packet buf, @OriginalArg(4) PlayerEntity player) {
		if ((mask & 0x1) == 1) {
			int length = buf.g1();
			@Pc(22) byte[] data = new byte[length];
			@Pc(28) Packet appearance = new Packet(data);
			buf.gdata(length, 0, data);
			this.playerAppearanceBuffer[id] = appearance;
			player.read(appearance);
		}
		if ((mask & 0x2) == 2) {
			int seqId = buf.g2();
			if (seqId == 65535) {
				seqId = -1;
			}
			if (seqId == player.primarySeqId) {
				player.primarySeqLoop = 0;
			}
			int delay = buf.g1();
			if (seqId == -1 || player.primarySeqId == -1 || SeqType.instances[seqId].priority > SeqType.instances[player.primarySeqId].priority || SeqType.instances[player.primarySeqId].priority == 0) {
				player.primarySeqId = seqId;
				player.primarySeqFrame = 0;
				player.primarySeqCycle = 0;
				player.primarySeqDelay = delay;
				player.primarySeqLoop = 0;
			}
		}
		if ((mask & 0x4) == 4) {
			player.targetId = buf.g2();
			if (player.targetId == 65535) {
				player.targetId = -1;
			}
		}
		if ((mask & 0x8) == 8) {
			player.chat = buf.gjstr();
			player.chatColor = 0;
			player.chatStyle = 0;
			player.chatTimer = 150;
			this.addMessage(2, player.chat, player.name);
		}
		if ((mask & 0x10) == 16) {
			player.damage = buf.g1();
			player.damageType = buf.g1();
			player.combatCycle = loopCycle + 400;
			player.health = buf.g1();
			player.totalHealth = buf.g1();
		}
		if ((mask & 0x20) == 32) {
			player.targetTileX = buf.g2();
			player.targetTileZ = buf.g2();
		}
		if ((mask & 0x40) == 64) {
			int colorEffect = buf.g2();
			int type = buf.g1();
			@Pc(199) int length = buf.g1();
			@Pc(202) int start = buf.pos;
			if (player.name != null) {
				@Pc(209) long username = JString.toBase37(player.name);
				@Pc(211) boolean ignored = false;
				if (type <= 1) {
					for (@Pc(216) int i = 0; i < this.ignoreCount; i++) {
						if (this.ignoreName37[i] == username) {
							ignored = true;
							break;
						}
					}
				}
				if (!ignored && this.overrideChat == 0) {
					try {
						@Pc(244) String uncompressed = WordPack.unpack(buf, length);
						@Pc(248) String filtered = WordFilter.filter(uncompressed);
						player.chat = filtered;
						player.chatColor = colorEffect >> 8;
						player.chatStyle = colorEffect & 0xFF;
						player.chatTimer = 150;
						if (type > 1) {
							this.addMessage(1, filtered, player.name);
						} else {
							this.addMessage(2, filtered, player.name);
						}
					} catch (@Pc(285) Exception ex) {
						signlink.reporterror("cde2");
					}
				}
			}
			buf.pos = start + length;
		}
		if ((mask & 0x100) == 256) {
			player.spotanimId = buf.g2();
			int heightDelay = buf.g4();
			player.spotanimOffset = heightDelay >> 16;
			player.spotanimLastCycle = loopCycle + (heightDelay & 0xFFFF);
			player.spotanimFrame = 0;
			player.spotanimCycle = 0;
			if (player.spotanimLastCycle > loopCycle) {
				player.spotanimFrame = -1;
			}
			if (player.spotanimId == 65535) {
				player.spotanimId = -1;
			}
		}
		if ((mask & 0x200) == 512) {
			player.forceMoveStartSceneTileX = buf.g1();
			player.forceMoveStartSceneTileZ = buf.g1();
			player.forceMoveEndSceneTileX = buf.g1();
			player.forceMoveEndSceneTileZ = buf.g1();
			player.forceMoveEndCycle = buf.g2() + loopCycle;
			player.forceMoveStartCycle = buf.g2() + loopCycle;
			player.forceMoveFaceDirection = buf.g1();
			player.pathLength = 0;
			player.pathTileX[0] = player.forceMoveEndSceneTileX;
			player.pathTileZ[0] = player.forceMoveEndSceneTileZ;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLjava/lang/String;I)V")
	@Override
	protected void drawProgress(@OriginalArg(1) String message, @OriginalArg(2) int progress) {
		this.loadTitle();
		if (this.archiveTitle == null) {
			super.drawProgress(message, progress);
		} else {
			this.imageTitle4.bind();
			@Pc(17) short x = 360;
			@Pc(19) short y = 200;
			@Pc(21) byte offsetY = 20;
			this.fontBold12.drawStringCenter(y / 2 - offsetY - 26, 16777215, "RuneScape is loading - please wait...", x / 2);
			@Pc(51) int midY = y / 2 - offsetY - 18;
			Draw2D.drawRect(x / 2 - 152, 9179409, 34, midY, 304);
			Draw2D.drawRect(x / 2 - 151, 0, 32, midY + 1, 302);
			Draw2D.fillRect(midY + 2, x / 2 - 150, 9179409, progress * 3, 30);
			Draw2D.fillRect(midY + 2, x / 2 - 150 + progress * 3, 0, 300 - progress * 3, 30);
			this.fontBold12.drawStringCenter(y / 2 + 5 - offsetY, 16777215, message, x / 2);
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
}