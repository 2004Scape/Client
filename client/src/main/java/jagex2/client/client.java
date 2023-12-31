package jagex2.client;

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

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.zip.CRC32;

@OriginalClass("client!client")
public final class client extends GameShell {

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
			System.out.println("RS2 user client - release #" + Signlink.clientversion);

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
				Signlink.sunjava = true;
			}

            Signlink.startpriv(InetAddress.getByName("w1.225.2004scape.org"));

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
		Signlink.midifade = 0;
		Signlink.midi = "stop";
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
			@Pc(98) int localX = x & 0x3F;
			@Pc(102) int localZ = z & 0x3F;
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
		this.scene.draw(this.cameraYaw, this.cameraX, level, this.cameraPitch, this.cameraY, this.cameraZ);
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
				@Pc(52) byte[] data = Signlink.cacheload(name + ".mid");
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
						Signlink.cachesave(name + ".mid", data);
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
	private void handleInterfaceInput(@OriginalArg(0) int mouseY, @OriginalArg(1) int mouseX, @OriginalArg(2) int y, @OriginalArg(3) IfType parent, @OriginalArg(5) int x, @OriginalArg(6) int scrollPosition) {
		if (parent.type == 0 && parent.childId != null && !parent.hide && (mouseX >= x && mouseY >= y && mouseX <= x + parent.width && mouseY <= y + parent.height)) {
			@Pc(34) int children = parent.childId.length;
			for (@Pc(44) int i = 0; i < children; i++) {
				@Pc(53) int childX = parent.childX[i] + x;
				@Pc(62) int childZ = parent.childY[i] + y - scrollPosition;
				@Pc(69) IfType child = IfType.instances[parent.childId[i]];
				@Pc(74) int local74 = childX + child.x;
				@Pc(79) int local79 = childZ + child.y;
				if ((child.delegateHover >= 0 || child.hoverColor != 0) && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
					if (child.delegateHover >= 0) {
						this.lastHoveredInterfaceId = child.delegateHover;
					} else {
						this.lastHoveredInterfaceId = child.id;
					}
				}
				if (child.type == 0) {
					this.handleInterfaceInput(mouseY, mouseX, local79, child, local74, child.scrollPosition);
					if (child.scrollableHeight > child.height) {
						this.handleScrollInput(mouseX, mouseY, child.scrollableHeight, child.height, true, local74 + child.width, local79, child);
					}
				} else {
					if (child.optionType == 1 && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
						@Pc(176) boolean local176 = false;
						if (child.contentType != 0) {
							local176 = this.handleSocialMenuOption(child);
						}
						if (!local176) {
							this.menuOption[this.menuSize] = child.option;
							this.menuAction[this.menuSize] = 951;
							this.menuParamC[this.menuSize] = child.id;
							this.menuSize++;
						}
					}
					if (child.optionType == 2 && this.spellSelected == 0 && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
						@Pc(240) String local240 = child.spellAction;
						if (local240.indexOf(" ") != -1) {
							local240 = local240.substring(0, local240.indexOf(" "));
						}
						this.menuOption[this.menuSize] = local240 + " @gre@" + child.spellName;
						this.menuAction[this.menuSize] = 930;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}
					if (child.optionType == 3 && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
						this.menuOption[this.menuSize] = "Close";
						this.menuAction[this.menuSize] = 947;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}
					if (child.optionType == 4 && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
						this.menuOption[this.menuSize] = child.option;
						this.menuAction[this.menuSize] = 465;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}
					if (child.optionType == 5 && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
						this.menuOption[this.menuSize] = child.option;
						this.menuAction[this.menuSize] = 960;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}
					if (child.optionType == 6 && !this.pressedContinueOption && mouseX >= local74 && mouseY >= local79 && mouseX < local74 + child.width && mouseY < local79 + child.height) {
						this.menuOption[this.menuSize] = child.option;
						this.menuAction[this.menuSize] = 44;
						this.menuParamC[this.menuSize] = child.id;
						this.menuSize++;
					}
					if (child.type == 2) {
						@Pc(488) int local488 = 0;
						for (@Pc(490) int local490 = 0; local490 < child.height; local490++) {
							for (@Pc(494) int local494 = 0; local494 < child.width; local494++) {
								@Pc(505) int local505 = local74 + local494 * (child.inventoryMarginX + 32);
								@Pc(514) int local514 = local79 + local490 * (child.inventoryMarginY + 32);
								if (local488 < 20) {
									local505 += child.inventorySlotOffsetX[local488];
									local514 += child.inventorySlotOffsetY[local488];
								}
								if (mouseX >= local505 && mouseY >= local514 && mouseX < local505 + 32 && mouseY < local514 + 32) {
									this.hoveredSlot = local488;
									this.hoveredSlotParentId = child.id;
									if (child.inventorySlotObjId[local488] > 0) {
										@Pc(567) ObjType local567 = ObjType.get(child.inventorySlotObjId[local488] - 1);
										if (this.objSelected == 1 && child.inventoryInteractable) {
											if (child.id != this.objSelectedInterface || local488 != this.objSelectedSlot) {
												this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + local567.name;
												this.menuAction[this.menuSize] = 881;
												this.menuParamA[this.menuSize] = local567.index;
												this.menuParamB[this.menuSize] = local488;
												this.menuParamC[this.menuSize] = child.id;
												this.menuSize++;
											}
										} else if (this.spellSelected != 1 || !child.inventoryInteractable) {
											@Pc(704) int local704;
											if (child.inventoryInteractable) {
												for (local704 = 4; local704 >= 3; local704--) {
													if (local567.iops != null && local567.iops[local704] != null) {
														this.menuOption[this.menuSize] = local567.iops[local704] + " @lre@" + local567.name;
														if (local704 == 3) {
															this.menuAction[this.menuSize] = 478;
														}
														if (local704 == 4) {
															this.menuAction[this.menuSize] = 347;
														}
														this.menuParamA[this.menuSize] = local567.index;
														this.menuParamB[this.menuSize] = local488;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													} else if (local704 == 4) {
														this.menuOption[this.menuSize] = "Drop @lre@" + local567.name;
														this.menuAction[this.menuSize] = 347;
														this.menuParamA[this.menuSize] = local567.index;
														this.menuParamB[this.menuSize] = local488;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													}
												}
											}
											if (child.inventoryUsable) {
												this.menuOption[this.menuSize] = "Use @lre@" + local567.name;
												this.menuAction[this.menuSize] = 188;
												this.menuParamA[this.menuSize] = local567.index;
												this.menuParamB[this.menuSize] = local488;
												this.menuParamC[this.menuSize] = child.id;
												this.menuSize++;
											}
											if (child.inventoryInteractable && local567.iops != null) {
												for (local704 = 2; local704 >= 0; local704--) {
													if (local567.iops[local704] != null) {
														this.menuOption[this.menuSize] = local567.iops[local704] + " @lre@" + local567.name;
														if (local704 == 0) {
															this.menuAction[this.menuSize] = 405;
														}
														if (local704 == 1) {
															this.menuAction[this.menuSize] = 38;
														}
														if (local704 == 2) {
															this.menuAction[this.menuSize] = 422;
														}
														this.menuParamA[this.menuSize] = local567.index;
														this.menuParamB[this.menuSize] = local488;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													}
												}
											}
											if (child.inventoryOptions != null) {
												for (local704 = 4; local704 >= 0; local704--) {
													if (child.inventoryOptions[local704] != null) {
														this.menuOption[this.menuSize] = child.inventoryOptions[local704] + " @lre@" + local567.name;
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
														this.menuParamA[this.menuSize] = local567.index;
														this.menuParamB[this.menuSize] = local488;
														this.menuParamC[this.menuSize] = child.id;
														this.menuSize++;
													}
												}
											}
											this.menuOption[this.menuSize] = "Examine @lre@" + local567.name;
											this.menuAction[this.menuSize] = 1773;
											this.menuParamA[this.menuSize] = local567.index;
											this.menuParamC[this.menuSize] = child.inventorySlotObjCount[local488];
											this.menuSize++;
										} else if ((this.activeSpellFlags & 0x10) == 16) {
											this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + local567.name;
											this.menuAction[this.menuSize] = 391;
											this.menuParamA[this.menuSize] = local567.index;
											this.menuParamB[this.menuSize] = local488;
											this.menuParamC[this.menuSize] = child.id;
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
				for (@Pc(186) int i = 0; i < IfType.instances.length; i++) {
					if (IfType.instances[i] != null && IfType.instances[i].contentType == 600) {
						this.reportAbuseInterfaceID = this.viewportInterfaceID = IfType.instances[i].parentId;
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
						this.scene.addTemporary(player.z, 60, player.seqDelay, player.x, id, player.seqStretches, null, player, player.y, this.currentLevel);
					} else {
						player.lowMemory = false;
						player.y = this.getHeightmapY(this.currentLevel, player.x, player.z);
						this.scene.addTemporary(player.maxTileX, null, player.z, player.y, id, player.seqDelay, player.minTileZ, player.minTileX, player, this.currentLevel, player.maxTileZ, player.x);
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
			@Pc(13) int local13;
			do {
				while (true) {
					local13 = this.pollKey();
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
							if (this.chatTyped.equals("::clientdrop") && (super.frame != null || this.getHost().indexOf("192.168.1.") != -1)) {
								this.tryReconnect();
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
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;ILjava/lang/String;II)Lclient!ub;")
	private Jagfile loadArchive(@OriginalArg(0) String displayName, @OriginalArg(1) int crc, @OriginalArg(2) String name, @OriginalArg(3) int progress) {
		@Pc(3) int retry = 5;
		@Pc(6) byte[] data = Signlink.cacheload(name);
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
					@Pc(107) int local107 = length - offset;
					if (local107 > 1000) {
						local107 = 1000;
					}
					offset += stream.read(data, offset, local107);
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
					} catch (@Pc(178) Exception ex2) {
					}
				}
				retry *= 2;
				if (retry > 60) {
					retry = 60;
				}
			}
		}
		Signlink.cachesave(name, data);
		return new Jagfile(data);
	}

	@OriginalMember(owner = "client!client", name = "f", descriptor = "(Z)V")
	private void unloadTitle() {
		this.flameActive = false;
		while (this.flameThread) {
			this.flameActive = false;
			try {
				Thread.sleep(50L);
			} catch (@Pc(13) Exception ex) {
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
			@Pc(17) Pix8 local17;
			@Pc(25) int local25;
			@Pc(33) int local33;
			@Pc(36) byte[] local36;
			@Pc(39) byte[] local39;
			@Pc(41) int local41;
			if (Draw3D.textureCycle[17] >= cycle) {
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
			if (Draw3D.textureCycle[24] >= cycle) {
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
			}
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
		if (Signlink.mainapp == null) {
			return this;
		} else {
			return Signlink.mainapp;
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

		@Pc(37) int local37;
		@Pc(39) int local39;
		for (@Pc(25) int local25 = 1; local25 < 103; local25++) {
			local37 = (103 - local25) * 512 * 4 + 24628;
			for (local39 = 1; local39 < 103; local39++) {
				if ((this.levelTileFlags[level][local39][local25] & 0x18) == 0) {
					this.scene.drawMinimapTile(pixels, local37, 512, level, local39, local25);
				}
				if (level < 3 && (this.levelTileFlags[level + 1][local39][local25] & 0x8) != 0) {
					this.scene.drawMinimapTile(pixels, local37, 512, level + 1, local39, local25);
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
				if ((this.levelTileFlags[level][local149][local145] & 0x18) == 0) {
					this.drawMinimapLoc(level, local37, local149, local39, local145);
				}
				if (level < 3 && (this.levelTileFlags[level + 1][local149][local145] & 0x8) != 0) {
					this.drawMinimapLoc(level + 1, local37, local149, local39, local145);
				}
			}
		}
		this.areaViewport.bind();
		this.activeMapFunctionCount = 0;
		for (int x = 0; x < 104; x++) {
			for (@Pc(217) int z = 0; z < 104; z++) {
				@Pc(227) int local227 = this.scene.getGroundDecorationBitset(this.currentLevel, x, z);
				if (local227 != 0) {
					local227 = local227 >> 14 & 0x7FFF;
					@Pc(239) int mapfunction = LocType.get(local227).mapfunction;
					if (mapfunction >= 0) {
						@Pc(243) int local243 = x;
						@Pc(245) int local245 = z;
						if (mapfunction != 22 && mapfunction != 29 && mapfunction != 34 && mapfunction != 36 && mapfunction != 46 && mapfunction != 47 && mapfunction != 48) {
							@Pc(268) byte local268 = 104;
							@Pc(270) byte local270 = 104;
							@Pc(277) int[][] local277 = this.levelCollisionMap[this.currentLevel].flags;
							for (@Pc(279) int local279 = 0; local279 < 10; local279++) {
								@Pc(286) int local286 = (int) (Math.random() * 4.0D);
								if (local286 == 0 && local243 > 0 && local243 > x - 3 && (local277[local243 - 1][local245] & 0x280108) == 0) {
									local243--;
								}
								if (local286 == 1 && local243 < local268 - 1 && local243 < x + 3 && (local277[local243 + 1][local245] & 0x280180) == 0) {
									local243++;
								}
								if (local286 == 2 && local245 > 0 && local245 > z - 3 && (local277[local243][local245 - 1] & 0x280102) == 0) {
									local245--;
								}
								if (local286 == 3 && local245 < local270 - 1 && local245 < z + 3 && (local277[local243][local245 + 1] & 0x280120) == 0) {
									local245++;
								}
							}
						}
						this.activeMapFunctions[this.activeMapFunctionCount] = this.imageMapfunction[mapfunction];
						this.activeMapFunctionX[this.activeMapFunctionCount] = local243;
						this.activeMapFunctionZ[this.activeMapFunctionCount] = local245;
						this.activeMapFunctionCount++;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIIIII)V")
	private void drawMinimapLoc(@OriginalArg(1) int level, @OriginalArg(2) int wallRgb, @OriginalArg(3) int tileX, @OriginalArg(4) int doorRgb, @OriginalArg(5) int tileZ) {
		@Pc(8) int local8 = this.scene.getWallBitset(level, tileX, tileZ);
		@Pc(18) int local18;
		@Pc(24) int local24;
		@Pc(28) int local28;
		@Pc(30) int local30;
		@Pc(52) int local52;
		@Pc(58) int local58;
		if (local8 != 0) {
			local18 = this.scene.getInfo(level, tileX, tileZ, local8);
			local24 = local18 >> 6 & 0x3;
			local28 = local18 & 0x1F;
			local30 = wallRgb;
			if (local8 > 0) {
				local30 = doorRgb;
			}
			@Pc(38) int[] local38 = this.imageMinimap.pixels;
			local52 = tileX * 4 + (103 - tileZ) * 512 * 4 + 24624;
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
					@Pc(83) int local83 = (local61.width * 4 - local71.width) / 2;
					@Pc(93) int local93 = (local61.length * 4 - local71.height) / 2;
					local71.draw((104 - tileZ - local61.length) * 4 + local93 + 48, tileX * 4 + 48 + local83);
				}
			}
		}
		local8 = this.scene.getLocBitset(level, tileX, tileZ);
		if (local8 != 0) {
			local18 = this.scene.getInfo(level, tileX, tileZ, local8);
			local24 = local18 >> 6 & 0x3;
			local28 = local18 & 0x1F;
			local30 = local8 >> 14 & 0x7FFF;
			@Pc(451) LocType local451 = LocType.get(local30);
			@Pc(483) int local483;
			if (local451.mapscene != -1) {
				@Pc(461) Pix8 local461 = this.imageMapscene[local451.mapscene];
				if (local461 != null) {
					local58 = (local451.width * 4 - local461.width) / 2;
					local483 = (local451.length * 4 - local461.height) / 2;
					local461.draw((104 - tileZ - local451.length) * 4 + local483 + 48, tileX * 4 + 48 + local58);
				}
			} else if (local28 == 9) {
				local52 = 15658734;
				if (local8 > 0) {
					local52 = 15597568;
				}
				@Pc(520) int[] local520 = this.imageMinimap.pixels;
				local483 = tileX * 4 + (103 - tileZ) * 512 * 4 + 24624;
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
		local8 = this.scene.getGroundDecorationBitset(level, tileX, tileZ);
		if (local8 != 0) {
			local18 = local8 >> 14 & 0x7FFF;
			@Pc(615) LocType local615 = LocType.get(local18);
			if (local615.mapscene != -1) {
				@Pc(625) Pix8 local625 = this.imageMapscene[local615.mapscene];
				if (local625 != null) {
					local30 = (local615.width * 4 - local625.width) / 2;
					@Pc(647) int local647 = (local615.length * 4 - local625.height) / 2;
					local625.draw((104 - tileZ - local615.length) * 4 + local647 + 48, tileX * 4 + 48 + local30);
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
			Signlink.reporterror(this.username + " size mismatch in getnpcpos - pos:" + buf.pos + " psize:" + size);
			throw new RuntimeException("eek");
		}
		for (int i = 0; i < this.npcCount; i++) {
			if (this.npcs[this.npcIds[i]] == null) {
				Signlink.reporterror(this.username + " null entry in npc list - pos:" + i + " size:" + this.npcCount);
				throw new RuntimeException("eek");
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	@Override
	public void startThread(@OriginalArg(0) Runnable runnable, @OriginalArg(1) int priority) {
		if (Signlink.mainapp == null) {
			super.startThread(runnable, priority);
		} else {
			Signlink.startthread(runnable, priority);
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
		@Pc(10) int local10;
		if (count < this.playerCount) {
			for (local10 = count; local10 < this.playerCount; local10++) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.playerIds[local10];
			}
		}
		if (count > this.playerCount) {
			Signlink.reporterror(this.username + " Too many players");
			throw new RuntimeException("eek");
		}
		this.playerCount = 0;
		for (local10 = 0; local10 < count; local10++) {
			@Pc(73) int index = this.playerIds[local10];
			@Pc(78) PlayerEntity player = this.players[index];
			@Pc(83) int hasUpdate = buf.gBit(1);
			if (hasUpdate == 0) {
				this.playerIds[this.playerCount++] = index;
				player.cycle = loopCycle;
			} else {
				@Pc(106) int update = buf.gBit(2);
				if (update == 0) {
					this.playerIds[this.playerCount++] = index;
					player.cycle = loopCycle;
					this.entityUpdateIds[this.entityUpdateCount++] = index;
				} else {
					@Pc(157) int local157;
					@Pc(167) int local167;
					if (update == 1) {
						this.playerIds[this.playerCount++] = index;
						player.cycle = loopCycle;
						local157 = buf.gBit(3);
						player.step(false, local157);
						local167 = buf.gBit(1);
						if (local167 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = index;
						}
					} else if (update == 2) {
						this.playerIds[this.playerCount++] = index;
						player.cycle = loopCycle;
						local157 = buf.gBit(3);
						player.step(true, local157);
						local167 = buf.gBit(3);
						player.step(true, local167);
						@Pc(225) int local225 = buf.gBit(1);
						if (local225 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = index;
						}
					} else if (update == 3) {
						this.entityRemovalIds[this.entityRemovalCount++] = index;
					}
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
		Signlink.midifade = fade;
		Signlink.midisave(src, length);
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
					this.scene.addTemporary(npc.z, (npc.size - 1) * 64 + 60, npc.seqDelay, npc.x, bitset, npc.seqStretches, null, npc, this.getHeightmapY(this.currentLevel, npc.x, npc.z), this.currentLevel);
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIZ)V")
	private void setMidiVolume(@OriginalArg(1) int volume) {
		Signlink.midivol = volume;
		Signlink.midi = "voladjust";
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
		@Pc(9) int local9;
		while (buf.bitPos + 10 < size * 8) {
			local9 = buf.gBit(11);
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
			@Pc(81) int local81 = buf.gBit(5);
			if (local81 > 15) {
				local81 -= 32;
			}
			@Pc(90) int local90 = buf.gBit(5);
			if (local90 > 15) {
				local90 -= 32;
			}
			@Pc(99) int local99 = buf.gBit(1);
			local73.move(local99 == 1, this.localPlayer.pathTileX[0] + local81, this.localPlayer.pathTileZ[0] + local90);
			@Pc(127) int local127 = buf.gBit(1);
			if (local127 == 1) {
				this.entityUpdateIds[this.entityUpdateCount++] = local9;
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
		} catch (@Pc(9) Exception local9) {
		}
		this.stream = null;
		this.ingame = false;
		this.titleScreenState = 0;
		this.username = "";
		this.password = "";
		InputTracking.setDisabled();
		this.clearCaches();
		this.scene.reset();
		for (@Pc(41) int local41 = 0; local41 < 4; local41++) {
			this.levelCollisionMap[local41].reset();
		}
		System.gc();
		this.stopMidi();
		this.currentMidi = null;
		this.nextMusicDelay = 0;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IIILclient!hc;I)V")
	private void drawParentInterface(@OriginalArg(0) int py, @OriginalArg(1) int px, @OriginalArg(3) IfType parent, @OriginalArg(4) int scrollY) {
		if (parent.type == 0 && parent.childId != null && (!parent.hide || this.viewportHoveredInterfaceIndex == parent.id || this.sidebarHoveredInterfaceIndex == parent.id || this.chatHoveredInterfaceIndex == parent.id)) {
			@Pc(29) int left = Draw2D.left;
			@Pc(31) int top = Draw2D.top;
			@Pc(33) int right = Draw2D.right;
			@Pc(35) int bottom = Draw2D.bottom;
			Draw2D.setBounds(py + parent.height, py, px + parent.width, px);
			@Pc(57) int local57 = parent.childId.length;
			for (@Pc(59) int i = 0; i < local57; i++) {
				@Pc(68) int x = parent.childX[i] + px;
				@Pc(77) int y = parent.childY[i] + py - scrollY;
				@Pc(84) IfType child = IfType.instances[parent.childId[i]];
				@Pc(89) int local89 = x + child.x;
				@Pc(94) int local94 = y + child.y;
				if (child.contentType > 0) {
					this.updateInterfaceContent(child);
				}
				if (child.type == 0) {
					if (child.scrollPosition > child.scrollableHeight - child.height) {
						child.scrollPosition = child.scrollableHeight - child.height;
					}
					if (child.scrollPosition < 0) {
						child.scrollPosition = 0;
					}
					this.drawParentInterface(local94, local89, child, child.scrollPosition);
					if (child.scrollableHeight > child.height) {
						this.drawScrollbar(local89 + child.width, local94, child.scrollPosition, child.scrollableHeight, child.height);
					}
				} else if (child.type != 1) {
					@Pc(167) int local167;
					@Pc(171) int local171;
					@Pc(182) int local182;
					@Pc(217) int local217;
					@Pc(224) int local224;
					@Pc(165) int local165;
					@Pc(191) int local191;
					@Pc(215) int local215;
					if (child.type == 2) {
						local165 = 0;
						for (local167 = 0; local167 < child.height; local167++) {
							for (local171 = 0; local171 < child.width; local171++) {
								local182 = local89 + local171 * (child.inventoryMarginX + 32);
								local191 = local94 + local167 * (child.inventoryMarginY + 32);
								if (local165 < 20) {
									local182 += child.inventorySlotOffsetX[local165];
									local191 += child.inventorySlotOffsetY[local165];
								}
								if (child.inventorySlotObjId[local165] > 0) {
									local215 = 0;
									local217 = 0;
									local224 = child.inventorySlotObjId[local165] - 1;
									if (local182 >= -32 && local182 <= 512 && local191 >= -32 && local191 <= 334 || this.objDragArea != 0 && this.objDragSlot == local165) {
										@Pc(251) Pix24 local251 = ObjType.getIcon(local224, child.inventorySlotObjCount[local165]);
										if (this.objDragArea != 0 && this.objDragSlot == local165 && this.objDragInterfaceId == child.id) {
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
											local251.drawAlpha(128, local182 + local215, local191 + local217);
										} else if (this.selectedArea != 0 && this.selectedItem == local165 && this.selectedInterface == child.id) {
											local251.drawAlpha(128, local182, local191);
										} else {
											local251.draw(local191, local182);
										}
										if (local251.cropW == 33 || child.inventorySlotObjCount[local165] != 1) {
											@Pc(351) int local351 = child.inventorySlotObjCount[local165];
											this.fontPlain11.drawString(local182 + local215 + 1, local191 + 10 + local217, 0, formatObjCount(local351));
											this.fontPlain11.drawString(local182 + local215, local191 + 9 + local217, 16776960, formatObjCount(local351));
										}
									}
								} else if (child.inventorySlotImage != null && local165 < 20) {
									@Pc(398) Pix24 local398 = child.inventorySlotImage[local165];
									if (local398 != null) {
										local398.draw(local191, local182);
									}
								}
								local165++;
							}
						}
					} else if (child.type != 3) {
						@Pc(456) PixFont local456;
						if (child.type == 4) {
							local456 = child.font;
							local167 = child.color;
							@Pc(462) String local462 = child.text;
							if ((this.chatHoveredInterfaceIndex == child.id || this.sidebarHoveredInterfaceIndex == child.id || this.viewportHoveredInterfaceIndex == child.id) && child.hoverColor != 0) {
								local167 = child.hoverColor;
							}
							if (this.executeInterfaceScript(child)) {
								local167 = child.activeColor;
								if (child.activeText.length() > 0) {
									local462 = child.activeText;
								}
							}
							if (child.optionType == 6 && this.pressedContinueOption) {
								local462 = "Please wait...";
								local167 = child.color;
							}
							local191 = local94 + local456.height;
							while (local462.length() > 0) {
								if (local462.indexOf("%") != -1) {
									label264:
									while (true) {
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
																		local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(child, 4)) + local462.substring(local215 + 2);
																	}
																}
																local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(child, 3)) + local462.substring(local215 + 2);
															}
														}
														local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(child, 2)) + local462.substring(local215 + 2);
													}
												}
												local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(child, 1)) + local462.substring(local215 + 2);
											}
										}
										local462 = local462.substring(0, local215) + this.getIntString(this.executeClientscript1(child, 0)) + local462.substring(local215 + 2);
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
								if (child.center) {
									local456.drawStringTaggableCenter(local89 + child.width / 2, local167, child.shadow, local191, local704);
								} else {
									local456.drawStringTaggable(local89, local191, local704, child.shadow, local167);
								}
								local191 += local456.height;
							}
						} else if (child.type == 5) {
							@Pc(766) Pix24 local766;
							if (this.executeInterfaceScript(child)) {
								local766 = child.activeImage;
							} else {
								local766 = child.image;
							}
							if (local766 != null) {
								local766.draw(local94, local89);
							}
						} else if (child.type == 6) {
							local165 = Draw3D.centerX;
							local167 = Draw3D.centerY;
							Draw3D.centerX = local89 + child.width / 2;
							Draw3D.centerY = local94 + child.height / 2;
							local171 = Draw3D.sin[child.modelPitch] * child.modelZoom >> 16;
							local182 = Draw3D.cos[child.modelPitch] * child.modelZoom >> 16;
							@Pc(827) boolean local827 = this.executeInterfaceScript(child);
							if (local827) {
								local215 = child.activeSeqId;
							} else {
								local215 = child.seqId;
							}
							@Pc(846) Model local846;
							if (local215 == -1) {
								local846 = child.getModel(-1, -1, local827);
							} else {
								@Pc(852) SeqType local852 = SeqType.instances[local215];
								local846 = child.getModel(local852.frames[child.seqFrame], local852.iframes[child.seqFrame], local827);
							}
							if (local846 != null) {
								local846.drawSimple(0, child.modelYaw, 0, child.modelPitch, 0, local171, local182);
							}
							Draw3D.centerX = local165;
							Draw3D.centerY = local167;
						} else if (child.type == 7) {
							local456 = child.font;
							local167 = 0;
							for (local171 = 0; local171 < child.height; local171++) {
								for (local182 = 0; local182 < child.width; local182++) {
									if (child.inventorySlotObjId[local167] > 0) {
										@Pc(915) ObjType local915 = ObjType.get(child.inventorySlotObjId[local167] - 1);
										@Pc(918) String local918 = local915.name;
										if (local915.stackable || child.inventorySlotObjCount[local167] != 1) {
											local918 = local918 + " x" + formatObjCountTagged(child.inventorySlotObjCount[local167]);
										}
										local217 = local89 + local182 * (child.inventoryMarginX + 115);
										local224 = local94 + local171 * (child.inventoryMarginY + 12);
										if (child.center) {
											local456.drawStringTaggableCenter(local217 + child.width / 2, child.color, child.shadow, local224, local918);
										} else {
											local456.drawStringTaggable(local217, local224, local918, child.shadow, child.color);
										}
									}
									local167++;
								}
							}
						}
					} else if (child.fill) {
						Draw2D.fillRect(local94, local89, child.color, child.width, child.height);
					} else {
						Draw2D.drawRect(local89, child.color, child.height, local94, child.width);
					}
				}
			}
			Draw2D.setBounds(bottom, top, right, left);
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZILclient!kb;)V")
	private void readPlayerUpdates(@OriginalArg(1) int size, @OriginalArg(2) Packet buf) {
		for (@Pc(1) int local1 = 0; local1 < this.entityUpdateCount; local1++) {
			@Pc(8) int id = this.entityUpdateIds[local1];
			@Pc(13) PlayerEntity local13 = this.players[id];
			@Pc(16) int local16 = buf.g1();
			if ((local16 & 0x80) == 128) {
				local16 += buf.g1() << 8;
			}
			this.readPlayerUpdates(id, local16, buf, local13);
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
		@Pc(4) int local4 = enttiy.forceMoveEndCycle - loopCycle;
		@Pc(14) int local14 = enttiy.forceMoveStartSceneTileX * 128 + enttiy.size * 64;
		@Pc(24) int local24 = enttiy.forceMoveStartSceneTileZ * 128 + enttiy.size * 64;
		enttiy.x += (local14 - enttiy.x) / local4;
		enttiy.z += (local24 - enttiy.z) / local4;
		enttiy.seqPathLength = 0;
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
			@Pc(35) int local35 = entity.forceMoveStartCycle - entity.forceMoveEndCycle;
			@Pc(40) int local40 = loopCycle - entity.forceMoveEndCycle;
			@Pc(50) int local50 = entity.forceMoveStartSceneTileX * 128 + entity.size * 64;
			@Pc(60) int local60 = entity.forceMoveStartSceneTileZ * 128 + entity.size * 64;
			@Pc(70) int local70 = entity.forceMoveEndSceneTileX * 128 + entity.size * 64;
			@Pc(80) int local80 = entity.forceMoveEndSceneTileZ * 128 + entity.size * 64;
			entity.x = (local50 * (local35 - local40) + local70 * local40) / local35;
			entity.z = (local60 * (local35 - local40) + local80 * local40) / local35;
		}
		entity.seqPathLength = 0;
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
		entity.seqDelay = entity.dstYaw;
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ILclient!x;)V")
	private void updateMovement(@OriginalArg(1) PathingEntity entity) {
		entity.secondarySeqId = entity.seqStandId;
		if (entity.pathLength == 0) {
			entity.seqPathLength = 0;
		} else {
			if (entity.primarySeqId != -1 && entity.primarySeqDelay == 0) {
				@Pc(28) SeqType local28 = SeqType.instances[entity.primarySeqId];
				if (local28.labelGroups == null) {
					entity.seqPathLength++;
					return;
				}
			}
			@Pc(41) int local41 = entity.x;
			@Pc(44) int local44 = entity.z;
			@Pc(59) int local59 = entity.pathTileX[entity.pathLength - 1] * 128 + entity.size * 64;
			@Pc(74) int local74 = entity.pathTileZ[entity.pathLength - 1] * 128 + entity.size * 64;
			if (local59 - local41 <= 256 && local59 - local41 >= -256 && local74 - local44 <= 256 && local74 - local44 >= -256) {
				if (local41 < local59) {
					if (local44 < local74) {
						entity.dstYaw = 1280;
					} else if (local44 > local74) {
						entity.dstYaw = 1792;
					} else {
						entity.dstYaw = 1536;
					}
				} else if (local41 > local59) {
					if (local44 < local74) {
						entity.dstYaw = 768;
					} else if (local44 > local74) {
						entity.dstYaw = 256;
					} else {
						entity.dstYaw = 512;
					}
				} else if (local44 < local74) {
					entity.dstYaw = 1024;
				} else {
					entity.dstYaw = 0;
				}
				@Pc(168) int local168 = entity.dstYaw - entity.seqDelay & 0x7FF;
				if (local168 > 1024) {
					local168 -= 2048;
				}
				@Pc(175) int local175 = entity.seqTurnAroundId;
				if (local168 >= -256 && local168 <= 256) {
					local175 = entity.seqWalkId;
				} else if (local168 >= 256 && local168 < 768) {
					local175 = entity.seqTurnRightId;
				} else if (local168 >= -768 && local168 <= -256) {
					local175 = entity.seqTurnLeftId;
				}
				if (local175 == -1) {
					local175 = entity.seqWalkId;
				}
				entity.secondarySeqId = local175;
				@Pc(217) int local217 = 4;
				if (entity.seqDelay != entity.dstYaw && entity.targetId == -1) {
					local217 = 2;
				}
				if (entity.pathLength > 2) {
					local217 = 6;
				}
				if (entity.pathLength > 3) {
					local217 = 8;
				}
				if (entity.seqPathLength > 0 && entity.pathLength > 1) {
					local217 = 8;
					entity.seqPathLength--;
				}
				if (entity.pathRunning[entity.pathLength - 1]) {
					local217 <<= 0x1;
				}
				if (local217 >= 8 && entity.secondarySeqId == entity.seqWalkId && entity.seqRunId != -1) {
					entity.secondarySeqId = entity.seqRunId;
				}
				if (local41 < local59) {
					entity.x += local217;
					if (entity.x > local59) {
						entity.x = local59;
					}
				} else if (local41 > local59) {
					entity.x -= local217;
					if (entity.x < local59) {
						entity.x = local59;
					}
				}
				if (local44 < local74) {
					entity.z += local217;
					if (entity.z > local74) {
						entity.z = local74;
					}
				} else if (local44 > local74) {
					entity.z -= local217;
					if (entity.z < local74) {
						entity.z = local74;
					}
				}
				if (entity.x == local59 && entity.z == local74) {
					entity.pathLength--;
				}
			} else {
				entity.x = local59;
				entity.z = local74;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!x;B)V")
	private void updateFacingDirection(@OriginalArg(0) PathingEntity entity) {
		@Pc(30) int local30;
		@Pc(36) int local36;
		if (entity.targetId != -1 && entity.targetId < 32768) {
			@Pc(22) NpcEntity local22 = this.npcs[entity.targetId];
			if (local22 != null) {
				local30 = entity.x - local22.x;
				local36 = entity.z - local22.z;
				if (local30 != 0 || local36 != 0) {
					entity.dstYaw = (int) (Math.atan2(local30, local36) * 325.949D) & 0x7FF;
				}
			}
		}
		@Pc(61) int local61;
		if (entity.targetId >= 32768) {
			local61 = entity.targetId - 32768;
			if (local61 == this.localPid) {
				local61 = this.LOCAL_PLAYER_INDEX;
			}
			@Pc(73) PlayerEntity local73 = this.players[local61];
			if (local73 != null) {
				local36 = entity.x - local73.x;
				@Pc(87) int local87 = entity.z - local73.z;
				if (local36 != 0 || local87 != 0) {
					entity.dstYaw = (int) (Math.atan2(local36, local87) * 325.949D) & 0x7FF;
				}
			}
		}
		if ((entity.targetTileX != 0 || entity.targetTileZ != 0) && (entity.pathLength == 0 || entity.seqPathLength > 0)) {
			local61 = entity.x - (entity.targetTileX - this.sceneBaseTileX - this.sceneBaseTileX) * 64;
			local30 = entity.z - (entity.targetTileZ - this.sceneBaseTileZ - this.sceneBaseTileZ) * 64;
			if (local61 != 0 || local30 != 0) {
				entity.dstYaw = (int) (Math.atan2(local61, local30) * 325.949D) & 0x7FF;
			}
			entity.targetTileX = 0;
			entity.targetTileZ = 0;
		}
		local61 = entity.dstYaw - entity.seqDelay & 0x7FF;
		if (local61 != 0) {
			if (local61 < 32 || local61 > 2016) {
				entity.seqDelay = entity.dstYaw;
			} else if (local61 > 1024) {
				entity.seqDelay -= 32;
			} else {
				entity.seqDelay += 32;
			}
			entity.seqDelay &= 0x7FF;
			if (entity.secondarySeqId == entity.seqStandId && entity.seqDelay != entity.dstYaw) {
				if (entity.seqTurnId != -1) {
					entity.secondarySeqId = entity.seqTurnId;
					return;
				}
				entity.secondarySeqId = entity.seqWalkId;
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(ZLclient!x;)V")
	private void updateSequences(@OriginalArg(1) PathingEntity entity) {
		entity.seqStretches = false;
		@Pc(16) SeqType local16;
		if (entity.secondarySeqId != -1) {
			local16 = SeqType.instances[entity.secondarySeqId];
			entity.secondarySeqCycle++;
			if (entity.secondarySeqFrame < local16.frameCount && entity.secondarySeqCycle > local16.delay[entity.secondarySeqFrame]) {
				entity.secondarySeqCycle = 0;
				entity.secondarySeqFrame++;
			}
			if (entity.secondarySeqFrame >= local16.frameCount) {
				entity.secondarySeqCycle = 0;
				entity.secondarySeqFrame = 0;
			}
		}
		if (entity.primarySeqId != -1 && entity.primarySeqDelay == 0) {
			local16 = SeqType.instances[entity.primarySeqId];
			entity.primarySeqCycle++;
			while (entity.primarySeqFrame < local16.frameCount && entity.primarySeqCycle > local16.delay[entity.primarySeqFrame]) {
				entity.primarySeqCycle -= local16.delay[entity.primarySeqFrame];
				entity.primarySeqFrame++;
			}
			if (entity.primarySeqFrame >= local16.frameCount) {
				entity.primarySeqFrame -= local16.replayoff;
				entity.primarySeqLoop++;
				if (entity.primarySeqLoop >= local16.replaycount) {
					entity.primarySeqId = -1;
				}
				if (entity.primarySeqFrame < 0 || entity.primarySeqFrame >= local16.frameCount) {
					entity.primarySeqId = -1;
				}
			}
			entity.seqStretches = local16.stretches;
		}
		if (entity.primarySeqDelay > 0) {
			entity.primarySeqDelay--;
		}
		if (entity.spotanimId != -1 && loopCycle >= entity.spotanimLastCycle) {
			if (entity.spotanimFrame < 0) {
				entity.spotanimFrame = 0;
			}
			local16 = SpotAnimType.instances[entity.spotanimId].seq;
			entity.spotanimCycle++;
			while (entity.spotanimFrame < local16.frameCount && entity.spotanimCycle > local16.delay[entity.spotanimFrame]) {
				entity.spotanimCycle -= local16.delay[entity.spotanimFrame];
				entity.spotanimFrame++;
			}
			if (entity.spotanimFrame >= local16.frameCount) {
				if (entity.spotanimFrame < 0 || entity.spotanimFrame >= local16.frameCount) {
					entity.spotanimId = -1;
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
	private void useMenuOption(@OriginalArg(1) int option) {
		if (option >= 0) {
			if (this.chatbackInputOpen) {
				this.chatbackInputOpen = false;
				this.redrawChatback = true;
			}

			@Pc(18) int b = this.menuParamB[option];
			@Pc(23) int c = this.menuParamC[option];
			@Pc(28) int action = this.menuAction[option];
			@Pc(33) int a = this.menuParamA[option];
			if (action >= 2000) {
				action -= 2000;
			}

			@Pc(48) String local48;
			@Pc(52) int local52;
			@Pc(69) String local69;
			@Pc(73) int local73;
			if (action == 903 || action == 363) {
				local48 = this.menuOption[option];
				local52 = local48.indexOf("@whi@");
				if (local52 != -1) {
					local48 = local48.substring(local52 + 5).trim();
					local69 = JString.formatName(JString.fromBase37(JString.toBase37(local48)));
					@Pc(71) boolean local71 = false;
					for (local73 = 0; local73 < this.playerCount; local73++) {
						@Pc(83) PlayerEntity local83 = this.players[this.playerIds[local73]];
						if (local83 != null && local83.name != null && local83.name.equalsIgnoreCase(local69)) {
							this.tryMove(this.localPlayer.pathTileX[0], 1, false, local83.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local83.pathTileZ[0], 0, 0, 0);
							if (action == 903) {
								this.out.p1isaac(206);
							}
							if (action == 363) {
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
				if (IfType.instances[c].parentId == this.viewportInterfaceID) {
					this.selectedArea = 1;
				}
				if (IfType.instances[c].parentId == this.chatInterfaceId) {
					this.selectedArea = 3;
				}
			}
			@Pc(345) NpcEntity local345;
			if (action == 728 || action == 542 || action == 6 || action == 963 || action == 245) {
				local345 = this.npcs[a];
				if (local345 != null) {
					this.tryMove(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local345.pathTileZ[0], 0, 0, 0);
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
			@Pc(500) boolean local500;
			if (action == 217) {
				local500 = this.tryMove(this.localPlayer.pathTileX[0], 0, false, b, this.localPlayer.pathTileZ[0], 2, 0, c, 0, 0, 0);
				if (!local500) {
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
				@Pc(586) int local586 = a >> 14 & 0x7FFF;
				@Pc(589) LocType local589 = LocType.get(local586);
				if (local589.desc == null) {
					local69 = "It's a " + local589.name + ".";
				} else {
					local69 = local589.desc;
				}
				this.addMessage(0, local69, "");
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
				if (IfType.instances[c].parentId == this.viewportInterfaceID) {
					this.selectedArea = 1;
				}
				if (IfType.instances[c].parentId == this.chatInterfaceId) {
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
				if (IfType.instances[c].parentId == this.viewportInterfaceID) {
					this.selectedArea = 1;
				}
				if (IfType.instances[c].parentId == this.chatInterfaceId) {
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
			} else {
				if (action == 44 && !this.pressedContinueOption) {
					this.out.p1isaac(235);
					this.out.p2(c);
					this.pressedContinueOption = true;
				}
				@Pc(830) ObjType local830;
				@Pc(845) String local845;
				if (action == 1773) {
					local830 = ObjType.get(a);
					if (c >= 100000) {
						local845 = c + " x " + local830.name;
					} else if (local830.desc == null) {
						local845 = "It's a " + local830.name + ".";
					} else {
						local845 = local830.desc;
					}
					this.addMessage(0, local845, "");
				}
				if (action == 900) {
					local345 = this.npcs[a];
					if (local345 != null) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local345.pathTileZ[0], 0, 0, 0);
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
				@Pc(969) PlayerEntity local969;
				if (action == 1373 || action == 1544 || action == 151 || action == 1101) {
					local969 = this.players[a];
					if (local969 != null) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local969.pathTileZ[0], 0, 0, 0);
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
					local345 = this.npcs[a];
					if (local345 != null) {
						this.tryMove(this.localPlayer.pathTileX[0], 1, false, local345.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local345.pathTileZ[0], 0, 0, 0);
						this.crossX = super.mouseClickX;
						this.crossY = super.mouseClickY;
						this.crossMode = 2;
						this.crossCycle = 0;
						this.out.p1isaac(134);
						this.out.p2(a);
						this.out.p2(this.activeSpellId);
					}
				}
				@Pc(1156) long local1156;
				if (action == 679) {
					local48 = this.menuOption[option];
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
				if (action == 55 && this.interactWithLoc(9, b, c, a)) {
					this.out.p2(this.activeSpellId);
				}
				if (action == 224 || action == 993 || action == 99 || action == 746 || action == 877) {
					local500 = this.tryMove(this.localPlayer.pathTileX[0], 0, false, b, this.localPlayer.pathTileZ[0], 2, 0, c, 0, 0, 0);
					if (!local500) {
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
					local345 = this.npcs[a];
					if (local345 != null) {
						if (local345.type.desc == null) {
							local845 = "It's a " + local345.type.name + ".";
						} else {
							local845 = local345.type.desc;
						}
						this.addMessage(0, local845, "");
					}
				}
				if (action == 504) {
					this.interactWithLoc(172, b, c, a);
				}
				@Pc(1429) IfType local1429;
				if (action == 930) {
					local1429 = IfType.instances[c];
					this.spellSelected = 1;
					this.activeSpellId = c;
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
					if (action == 951) {
						local1429 = IfType.instances[c];
						@Pc(1513) boolean local1513 = true;
						if (local1429.contentType > 0) {
							local1513 = this.handleInterfaceAction(local1429);
						}
						if (local1513) {
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
						if (IfType.instances[c].parentId == this.viewportInterfaceID) {
							this.selectedArea = 1;
						}
						if (IfType.instances[c].parentId == this.chatInterfaceId) {
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
						local500 = this.tryMove(this.localPlayer.pathTileX[0], 0, false, b, this.localPlayer.pathTileZ[0], 2, 0, c, 0, 0, 0);
						if (!local500) {
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
						local830 = ObjType.get(a);
						if (local830.desc == null) {
							local845 = "It's a " + local830.name + ".";
						} else {
							local845 = local830.desc;
						}
						this.addMessage(0, local845, "");
					}
					if (action == 960) {
						this.out.p1isaac(155);
						this.out.p2(c);
						local1429 = IfType.instances[c];
						if (local1429.scripts != null && local1429.scripts[0][0] == 5) {
							local52 = local1429.scripts[0][1];
							if (this.varps[local52] != local1429.scriptOperand[0]) {
								this.varps[local52] = local1429.scriptOperand[0];
								this.updateVarp(local52);
								this.redrawSidebar = true;
							}
						}
					}
					if (action == 34) {
						local48 = this.menuOption[option];
						local52 = local48.indexOf("@whi@");
						if (local52 != -1) {
							this.closeInterfaces();
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
					if (action == 947) {
						this.closeInterfaces();
					}
					if (action == 367) {
						local969 = this.players[a];
						if (local969 != null) {
							this.tryMove(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local969.pathTileZ[0], 0, 0, 0);
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
						local1429 = IfType.instances[c];
						if (local1429.scripts != null && local1429.scripts[0][0] == 5) {
							local52 = local1429.scripts[0][1];
							this.varps[local52] = 1 - this.varps[local52];
							this.updateVarp(local52);
							this.redrawSidebar = true;
						}
					}
					if (action == 406 || action == 436 || action == 557 || action == 556) {
						local48 = this.menuOption[option];
						local52 = local48.indexOf("@whi@");
						if (local52 != -1) {
							local1156 = JString.toBase37(local48.substring(local52 + 5).trim());
							if (action == 406) {
								this.addFriend(local1156);
							}
							if (action == 436) {
								this.addIgnore(local1156);
							}
							if (action == 557) {
								this.removeFriend(local1156);
							}
							if (action == 556) {
								this.removeIgnore(local1156);
							}
						}
					}
					if (action == 651) {
						local969 = this.players[a];
						if (local969 != null) {
							this.tryMove(this.localPlayer.pathTileX[0], 1, false, local969.pathTileX[0], this.localPlayer.pathTileZ[0], 2, 1, local969.pathTileZ[0], 0, 0, 0);
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
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "s", descriptor = "(I)Ljava/lang/String;")
	private String getHost() {
		if (Signlink.mainapp == null) {
			return super.frame == null ? super.getDocumentBase().getHost().toLowerCase() : "runescape.com";
		} else {
			return Signlink.mainapp.getDocumentBase().getHost().toLowerCase();
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
	private void updateInterfaceContent(@OriginalArg(1) IfType component) {
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
						local241.recolor(PlayerEntity.DESIGN_BODY_COLOR[local243][0], PlayerEntity.DESIGN_BODY_COLOR[local243][this.designColors[local243]]);
						if (local243 == 1) {
							local241.recolor(PlayerEntity.DESIGN_HAIR_COLOR[0], PlayerEntity.DESIGN_HAIR_COLOR[this.designColors[local243]]);
						}
					}
				}
				local241.createLabelReferences();
				local241.applyTransform(SeqType.instances[this.localPlayer.seqStandId].frames[0]);
				local241.calculateNormals(64, 850, -30, -50, -30, true);
				component.model = local241;
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
		} else {
			if (contentType == 613) {
				if (!this.rights) {
					component.text = "";
				} else if (this.reportAbuseMuteOption) {
					component.color = 16711680;
					component.text = "Moderator option: Mute player for 48 hours: <ON>";
				} else {
					component.color = 16777215;
					component.text = "Moderator option: Mute player for 48 hours: <OFF>";
				}
			}
			@Pc(441) String local441;
			if (contentType == 650 || contentType == 655) {
				if (this.lastAddress == 0) {
					component.text = "";
				} else {
					if (this.daysSinceLastLogin == 0) {
						local441 = "earlier today";
					} else if (this.daysSinceLastLogin == 1) {
						local441 = "yesterday";
					} else {
						local441 = this.daysSinceLastLogin + " days ago";
					}
					component.text = "You last logged in " + local441 + " from: " + Signlink.dns;
				}
			}
			if (contentType == 651) {
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
			}
			if (contentType == 652) {
				if (this.daysSinceRecoveriesChanged == 201) {
					component.text = "";
				} else if (this.daysSinceRecoveriesChanged == 200) {
					component.text = "You have not yet set any password recovery questions.";
				} else {
					if (this.daysSinceRecoveriesChanged == 0) {
						local441 = "Earlier today";
					} else if (this.daysSinceRecoveriesChanged == 1) {
						local441 = "Yesterday";
					} else {
						local441 = this.daysSinceRecoveriesChanged + " days ago";
					}
					component.text = local441 + " you changed your recovery questions";
				}
			}
			if (contentType == 653) {
				if (this.daysSinceRecoveriesChanged == 201) {
					component.text = "";
				} else if (this.daysSinceRecoveriesChanged == 200) {
					component.text = "We strongly recommend you do so now to secure your account.";
				} else {
					component.text = "If you do not remember making this change then cancel it immediately";
				}
			}
			if (contentType == 654) {
				if (this.daysSinceRecoveriesChanged == 201) {
					component.text = "";
				} else if (this.daysSinceRecoveriesChanged == 200) {
					component.text = "Do this from the 'account management' area on our front webpage";
				} else {
					component.text = "Do this from the 'account management' area on our front webpage";
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "([BII)Z")
	private boolean saveWave(@OriginalArg(0) byte[] src, @OriginalArg(1) int length) {
		return src == null || Signlink.wavesave(src, length);
	}

	@OriginalMember(owner = "client!client", name = "u", descriptor = "(I)Z")
	private boolean replayWave() {
		return Signlink.wavereplay();
	}

	@OriginalMember(owner = "client!client", name = "g", descriptor = "(II)V")
	private void setWaveVolume(@OriginalArg(0) int volume) {
		Signlink.wavevol = volume;
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
	private boolean handleInterfaceAction(@OriginalArg(1) IfType component) {
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
		@Pc(112) int local112;
		@Pc(116) int local116;
		@Pc(121) int local121;
		if (contentType >= 300 && contentType <= 313) {
			local112 = (contentType - 300) / 2;
			local116 = contentType & 0x1;
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
		if (contentType >= 314 && contentType <= 323) {
			local112 = (contentType - 314) / 2;
			local116 = contentType & 0x1;
			local121 = this.designColors[local112];
			if (local116 == 0) {
				local121--;
				if (local121 < 0) {
					local121 = PlayerEntity.DESIGN_BODY_COLOR[local112].length - 1;
				}
			}
			if (local116 == 1) {
				local121++;
				if (local121 >= PlayerEntity.DESIGN_BODY_COLOR[local112].length) {
					local121 = 0;
				}
			}
			this.designColors[local112] = local121;
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
			for (local112 = 0; local112 < 7; local112++) {
				this.out.p1(this.designIdentikits[local112]);
			}
			for (local116 = 0; local116 < 5; local116++) {
				this.out.p1(this.designColors[local116]);
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
		@Pc(34) boolean good = false;
		@Pc(38) String host = this.getHost();
		if (host.endsWith("jagex.com")) {
			good = true;
		}
		if (host.endsWith("runescape.com")) {
			good = true;
		}
		if (host.endsWith("192.168.1.2")) {
			good = true;
		}
		if (host.endsWith("192.168.1.249")) {
			good = true;
		}
		if (host.endsWith("192.168.1.252")) {
			good = true;
		}
		if (host.endsWith("192.168.1.253")) {
			good = true;
		}
		if (host.endsWith("192.168.1.254")) {
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
						} catch (@Pc(171) Exception local171) {
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
			IfType.unpack(media, fonts, inter);

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
					this.handleInterfaceInput(super.mouseY, super.mouseX, 11, IfType.instances[this.viewportInterfaceID], 8, 0);
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
		@Pc(7) int local7;
		this.drawPrivateMessages();
		if (this.crossMode == 1) {
			this.imageCrosses[this.crossCycle / 100].draw(this.crossY - 8 - 11, this.crossX - 8 - 8);
		}
		if (this.crossMode == 2) {
			this.imageCrosses[this.crossCycle / 100 + 4].draw(this.crossY - 8 - 11, this.crossX - 8 - 8);
		}
		if (this.viewportInterfaceID != -1) {
			this.updateInterfaceAnimation(this.viewportInterfaceID, this.sceneDelta);
			this.drawParentInterface(0, 0, IfType.instances[this.viewportInterfaceID], 0);
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
				this.scene.addTemporary((int) local12.z, 60, local12.yaw, (int) local12.x, -1, false, null, local12, (int) local12.y, this.currentLevel);
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
			@Pc(47) int local47 = sinAngle * 256 / (this.minimapZoom + 256);
			@Pc(56) int local56 = cosAngle * 256 / (this.minimapZoom + 256);
			@Pc(66) int x = dy * local47 + dx * local56 >> 16;
			@Pc(76) int y = dy * local56 - dx * local47 >> 16;
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
			@Pc(33) int local33 = x - this.cameraX;
			@Pc(38) int local38 = y - this.cameraY;
			@Pc(43) int local43 = z - this.cameraZ;
			@Pc(48) int local48 = Model.sin[this.cameraPitch];
			@Pc(53) int local53 = Model.cos[this.cameraPitch];
			@Pc(58) int local58 = Model.sin[this.cameraYaw];
			@Pc(63) int local63 = Model.cos[this.cameraYaw];
			@Pc(73) int local73 = local43 * local58 + local33 * local63 >> 16;
			@Pc(83) int local83 = local43 * local63 - local33 * local58 >> 16;
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
			@Pc(65) int local65 = loc.forceapproach;
			if (angle != 0) {
				local65 = (local65 << angle & 0xF) + (local65 >> 4 - angle);
			}
			this.tryMove(this.localPlayer.pathTileX[0], width, false, x, this.localPlayer.pathTileZ[0], 2, height, z, 0, 0, local65);
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
	private DataInputStream openUrl(@OriginalArg(0) String url) throws IOException {
		return Signlink.mainapp == null ? new DataInputStream((new URL(this.getCodeBase(), url)).openStream()) : Signlink.openurl(url);
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
			@Pc(4) long start = System.currentTimeMillis();
			@Pc(6) int local6 = 0;
			@Pc(8) int local8 = 20;
			while (this.flameActive) {
				this.updateFlames();
				this.updateFlames();
				this.drawFlames();
				local6++;
				if (local6 > 10) {
					@Pc(25) long local25 = System.currentTimeMillis();
					@Pc(34) int local34 = (int) (local25 - start) / 10 - local8;
					local8 = 40 - local34;
					if (local8 < 5) {
						local8 = 5;
					}
					local6 = 0;
					start = local25;
				}
				try {
					Thread.sleep(local8);
				} catch (@Pc(52) Exception ex) {
				}
			}
		} catch (@Pc(58) Exception ex) {
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
	private void handleScrollInput(@OriginalArg(0) int mouseX, @OriginalArg(2) int mouseY, @OriginalArg(3) int scrollableHeight, @OriginalArg(4) int height, @OriginalArg(5) boolean redraw, @OriginalArg(6) int left, @OriginalArg(7) int top, @OriginalArg(8) IfType component) {
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
			@Pc(122) int local122 = (height - 32) * height / scrollableHeight;
			if (local122 < 8) {
				local122 = 8;
			}
			@Pc(137) int local137 = mouseY - top - local122 / 2 - 16;
			@Pc(143) int local143 = height - local122 - 32;
			component.scrollPosition = (scrollableHeight - height) * local137 / local143;
			if (redraw) {
				this.redrawSidebar = true;
			}
			this.scrollGrabbed = true;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Ljava/lang/String;Ljava/lang/String;Z)V")
	private void login(@OriginalArg(0) String username, @OriginalArg(1) String password, @OriginalArg(2) boolean reconnect) {
		Signlink.errorname = username;
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
			this.out.p4(Signlink.uid);
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
		if (x >= 1 && z >= 1 && x <= 102 && z <= 102) {
			if (lowMemory && level != this.currentLevel) {
				return;
			}
			@Pc(25) int local25 = 0;
			@Pc(27) boolean local27 = true;
			@Pc(29) boolean local29 = false;
			@Pc(31) boolean local31 = false;
			if (layer == 0) {
				local25 = this.scene.getWallBitset(level, x, z);
			}
			if (layer == 1) {
				local25 = this.scene.getWallDecorationBitset(level, z, x);
			}
			if (layer == 2) {
				local25 = this.scene.getLocBitset(level, x, z);
			}
			if (layer == 3) {
				local25 = this.scene.getGroundDecorationBitset(level, x, z);
			}
			@Pc(81) int local81;
			if (local25 != 0) {
				local81 = this.scene.getInfo(level, x, z, local25);
				@Pc(87) int local87 = local25 >> 14 & 0x7FFF;
				@Pc(91) int local91 = local81 & 0x1F;
				@Pc(95) int local95 = local81 >> 6;
				@Pc(107) LocType local107;
				if (layer == 0) {
					this.scene.removeWall(x, level, z, 1);
					local107 = LocType.get(local87);
					if (local107.blockwalk) {
						this.levelCollisionMap[level].removeWall(local107.blockrange, local95, x, z, local91);
					}
				}
				if (layer == 1) {
					this.scene.removeWallDecoration(level, z, x);
				}
				if (layer == 2) {
					this.scene.removeLoc(x, z, level);
					local107 = LocType.get(local87);
					if (x + local107.width > 103 || z + local107.width > 103 || x + local107.length > 103 || z + local107.length > 103) {
						return;
					}
					if (local107.blockwalk) {
						this.levelCollisionMap[level].removeLoc(z, x, local95, local107.width, local107.blockrange, local107.length);
					}
				}
				if (layer == 3) {
					this.scene.removeGroundDecoration(level, x, z);
					local107 = LocType.get(local87);
					if (local107.blockwalk && local107.active) {
						this.levelCollisionMap[level].removeBlocked(z, x);
					}
				}
			}
			if (id >= 0) {
				local81 = level;
				if (level < 3 && (this.levelTileFlags[1][x][z] & 0x2) == 2) {
					local81 = level + 1;
				}
				World.addLoc(x, this.locList, this.levelCollisionMap[level], z, rotation, this.levelHeightmap, level, id, shape, this.scene, local81);
			}
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
		Signlink.reporterror = false;
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
		IfType.instances = null;
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
		return Signlink.mainapp == null ? new Socket(InetAddress.getByName(this.getCodeBase().getHost()), port) : Signlink.opensocket(port);
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
			@Pc(250) Packet local250 = InputTracking.flush();
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
			updateCounter++;
			if (updateCounter > 127) {
				updateCounter = 0;
				this.out.p1isaac(215);
				this.out.p3(4991788);
			}
			if (World3D.clickTileX != -1) {
				local155 = World3D.clickTileX;
				local508 = World3D.clickTileZ;
				@Pc(653) boolean local653 = this.tryMove(this.localPlayer.pathTileX[0], 0, true, local155, this.localPlayer.pathTileZ[0], 0, 0, local508, 0, 0, 0);
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
			} catch (@Pc(1001) IOException local1001) {
				this.tryReconnect();
			} catch (@Pc(1006) Exception local1006) {
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
		if (Signlink.mainapp != null) {
			return Signlink.mainapp.getCodeBase();
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
		@Pc(55) byte steps = 0;
		@Pc(57) int length = 0;
		this.bfsStepX[steps] = srcX;
		@Pc(66) int local66 = steps + 1;
		this.bfsStepZ[steps] = srcZ;
		@Pc(70) boolean arrived = false;
		@Pc(74) int bufferSize = this.bfsStepX.length;
		@Pc(81) int[][] flags = this.levelCollisionMap[this.currentLevel].flags;
		@Pc(193) int local193;
		while (length != local66) {
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
			local193 = this.bfsCost[x][z] + 1;
			if (x > 0 && this.bfsDirection[x - 1][z] == 0 && (flags[x - 1][z] & 0x280108) == 0) {
				this.bfsStepX[local66] = x - 1;
				this.bfsStepZ[local66] = z;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x - 1][z] = 2;
				this.bfsCost[x - 1][z] = local193;
			}
			if (x < sceneWidth - 1 && this.bfsDirection[x + 1][z] == 0 && (flags[x + 1][z] & 0x280180) == 0) {
				this.bfsStepX[local66] = x + 1;
				this.bfsStepZ[local66] = z;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x + 1][z] = 8;
				this.bfsCost[x + 1][z] = local193;
			}
			if (z > 0 && this.bfsDirection[x][z - 1] == 0 && (flags[x][z - 1] & 0x280102) == 0) {
				this.bfsStepX[local66] = x;
				this.bfsStepZ[local66] = z - 1;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x][z - 1] = 1;
				this.bfsCost[x][z - 1] = local193;
			}
			if (z < sceneLength - 1 && this.bfsDirection[x][z + 1] == 0 && (flags[x][z + 1] & 0x280120) == 0) {
				this.bfsStepX[local66] = x;
				this.bfsStepZ[local66] = z + 1;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x][z + 1] = 4;
				this.bfsCost[x][z + 1] = local193;
			}
			if (x > 0 && z > 0 && this.bfsDirection[x - 1][z - 1] == 0 && (flags[x - 1][z - 1] & 0x28010E) == 0 && (flags[x - 1][z] & 0x280108) == 0 && (flags[x][z - 1] & 0x280102) == 0) {
				this.bfsStepX[local66] = x - 1;
				this.bfsStepZ[local66] = z - 1;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x - 1][z - 1] = 3;
				this.bfsCost[x - 1][z - 1] = local193;
			}
			if (x < sceneWidth - 1 && z > 0 && this.bfsDirection[x + 1][z - 1] == 0 && (flags[x + 1][z - 1] & 0x280183) == 0 && (flags[x + 1][z] & 0x280180) == 0 && (flags[x][z - 1] & 0x280102) == 0) {
				this.bfsStepX[local66] = x + 1;
				this.bfsStepZ[local66] = z - 1;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x + 1][z - 1] = 9;
				this.bfsCost[x + 1][z - 1] = local193;
			}
			if (x > 0 && z < sceneLength - 1 && this.bfsDirection[x - 1][z + 1] == 0 && (flags[x - 1][z + 1] & 0x280138) == 0 && (flags[x - 1][z] & 0x280108) == 0 && (flags[x][z + 1] & 0x280120) == 0) {
				this.bfsStepX[local66] = x - 1;
				this.bfsStepZ[local66] = z + 1;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x - 1][z + 1] = 6;
				this.bfsCost[x - 1][z + 1] = local193;
			}
			if (x < sceneWidth - 1 && z < sceneLength - 1 && this.bfsDirection[x + 1][z + 1] == 0 && (flags[x + 1][z + 1] & 0x2801E0) == 0 && (flags[x + 1][z] & 0x280180) == 0 && (flags[x][z + 1] & 0x280120) == 0) {
				this.bfsStepX[local66] = x + 1;
				this.bfsStepZ[local66] = z + 1;
				local66 = (local66 + 1) % bufferSize;
				this.bfsDirection[x + 1][z + 1] = 12;
				this.bfsCost[x + 1][z + 1] = local193;
			}
		}
		this.tryMoveNearest = 0;
		@Pc(809) int local809;
		@Pc(815) int startX;
		@Pc(821) int startZ;
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
		@Pc(882) byte local882 = 0;
		this.bfsStepX[local882] = x;
		length = local882 + 1;
		this.bfsStepZ[local882] = z;
		local193 = local809 = this.bfsDirection[x][z];
		while (x != srcX || z != srcZ) {
			if (local193 != local809) {
				local809 = local193;
				this.bfsStepX[length] = x;
				this.bfsStepZ[length++] = z;
			}
			if ((local193 & 0x2) != 0) {
				x++;
			} else if ((local193 & 0x8) != 0) {
				x--;
			}
			if ((local193 & 0x1) != 0) {
				z++;
			} else if ((local193 & 0x4) != 0) {
				z--;
			}
			local193 = this.bfsDirection[x][z];
		}
		if (length > 0) {
			bufferSize = length;
			if (length > 25) {
				bufferSize = 25;
			}
			length--;
			startX = this.bfsStepX[length];
			startZ = this.bfsStepZ[length];
			if (type == 0) {
				this.out.p1isaac(181);
				this.out.p1(bufferSize + bufferSize + 3);
			}
			if (type == 1) {
				this.out.p1isaac(165);
				this.out.p1(bufferSize + bufferSize + 3 + 14);
			}
			if (type == 2) {
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
		} else return type != 1;
	}

	@OriginalMember(owner = "client!client", name = "b", descriptor = "(Lclient!kb;II)V")
	private void readPlayerInfo(@OriginalArg(0) Packet buf, @OriginalArg(1) int size) {
		this.entityRemovalCount = 0;
		this.entityUpdateCount = 0;
		this.readLocalPlayer(size, buf);
		this.readPlayers(size, buf);
		this.readNewPlayers(size, buf);
		this.readPlayerUpdates(size, buf);
		@Pc(36) int local36;
		for (@Pc(29) int i = 0; i < this.entityRemovalCount; i++) {
			local36 = this.entityRemovalIds[i];
			if (this.players[local36].cycle != loopCycle) {
				this.players[local36] = null;
			}
		}
		if (buf.pos != size) {
			Signlink.reporterror("Error packet size mismatch in getplayer pos:" + buf.pos + " psize:" + size);
			throw new RuntimeException("eek");
		}
		for (local36 = 0; local36 < this.playerCount; local36++) {
			if (this.players[this.playerIds[local36]] == null) {
				Signlink.reporterror(this.username + " null entry in pl list - pos:" + local36 + " size:" + this.playerCount);
				throw new RuntimeException("eek");
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "d", descriptor = "(III)Z")
	private boolean updateInterfaceAnimation(@OriginalArg(0) int id, @OriginalArg(1) int delta) {
		@Pc(3) boolean updated = false;
		@Pc(7) IfType parent = IfType.instances[id];
		for (@Pc(9) int i = 0; i < parent.childId.length && parent.childId[i] != -1; i++) {
			@Pc(24) IfType child = IfType.instances[parent.childId[i]];
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
		@Pc(3) IfType parent = IfType.instances[id];
		for (@Pc(5) int i = 0; i < parent.childId.length && parent.childId[i] != -1; i++) {
			@Pc(20) IfType child = IfType.instances[parent.childId[i]];
			if (child.type == 1) {
				this.resetInterfaceAnimation(child.id);
			}
			child.seqFrame = 0;
			child.seqCycle = 0;
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(IJ)V")
	private void removeFriend(@OriginalArg(1) long username) {
		@Pc(6) int local6;
		if (username != 0L) {
			for (local6 = 0; local6 < this.friendCount; local6++) {
				if (this.friendName37[local6] == username) {
					this.friendCount--;
					this.redrawSidebar = true;
					for (@Pc(38) int local38 = local6; local38 < this.friendCount; local38++) {
						this.friendName[local38] = this.friendName[local38 + 1];
						this.friendWorld[local38] = this.friendWorld[local38 + 1];
						this.friendName37[local38] = this.friendName37[local38 + 1];
					}
					this.out.p1isaac(11);
					this.out.p8(username);
					return;
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "a", descriptor = "(Lclient!hc;I)Z")
	private boolean executeInterfaceScript(@OriginalArg(0) IfType component) {
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
	private void drawOnMinimap() {
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
				@Pc(129) boolean local129 = this.tryMove(this.localPlayer.pathTileX[0], 0, true, local98, this.localPlayer.pathTileZ[0], 1, 0, local106, 0, 0, 0);
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
	}

	@OriginalMember(owner = "client!client", name = "m", descriptor = "(B)V")
	private void handleObjDragging() {
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
						this.useMenuOption(local149);
					}
					this.menuVisible = false;
					if (this.menuArea == 1) {
						this.redrawSidebar = true;
					}
					if (this.menuArea == 2) {
						this.redrawChatback = true;
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
		@Pc(247) int local247 = (int) Math.sqrt(local226 * local226 + local236 * local236);
		@Pc(258) int local258 = (int) (Math.atan2(local231, local247) * 325.949D) & 0x7FF;
		@Pc(269) int local269 = (int) (Math.atan2(local226, local236) * -325.949D) & 0x7FF;
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
	private boolean handleSocialMenuOption(@OriginalArg(0) IfType component) {
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
		@Pc(20) int local20;
		if (count < this.npcCount) {
			for (local20 = count; local20 < this.npcCount; local20++) {
				this.entityRemovalIds[this.entityRemovalCount++] = this.npcIds[local20];
			}
		}
		if (count > this.npcCount) {
			Signlink.reporterror(this.username + " Too many npcs");
			throw new RuntimeException("eek");
		}
		this.npcCount = 0;
		for (local20 = 0; local20 < count; local20++) {
			@Pc(72) int local72 = this.npcIds[local20];
			@Pc(77) NpcEntity local77 = this.npcs[local72];
			@Pc(82) int local82 = buf.gBit(1);
			if (local82 == 0) {
				this.npcIds[this.npcCount++] = local72;
				local77.cycle = loopCycle;
			} else {
				@Pc(105) int local105 = buf.gBit(2);
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
						local156 = buf.gBit(3);
						local77.step(false, local156);
						local166 = buf.gBit(1);
						if (local166 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = local72;
						}
					} else if (local105 == 2) {
						this.npcIds[this.npcCount++] = local72;
						local77.cycle = loopCycle;
						local156 = buf.gBit(3);
						local77.step(true, local156);
						local166 = buf.gBit(3);
						local77.step(true, local166);
						@Pc(224) int local224 = buf.gBit(1);
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

	@OriginalMember(owner = "client!client", name = "getParameter", descriptor = "(Ljava/lang/String;)Ljava/lang/String;")
	@Override
	public String getParameter(@OriginalArg(0) String name) {
		return Signlink.mainapp == null ? super.getParameter(name) : Signlink.mainapp.getParameter(name);
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
		if (image != null) {
			local48 = 0;
			for (int y = 0; y < image.height; y++) {
				for (int x = 0; x < image.width; x++) {
					if (image.pixels[local48++] != 0) {
						@Pc(152) int local152 = x + image.cropX + 16;
						@Pc(159) int local159 = y + image.cropY + 16;
						@Pc(165) int local165 = local152 + (local159 << 7);
						this.flameBuffer0[local165] = 0;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!client", name = "j", descriptor = "(II)V")
	private void sortObjStacks(@OriginalArg(0) int x, @OriginalArg(1) int z) {
		@Pc(9) LinkList local9 = this.levelObjStacks[this.currentLevel][x][z];
		if (local9 == null) {
			this.scene.removeObjStack(this.currentLevel, x, z);
			return;
		}
		@Pc(21) int local21 = -99999999;
		@Pc(23) ObjStackEntity local23 = null;
		@Pc(27) ObjStackEntity local27;
		@Pc(35) int local35;
		for (local27 = (ObjStackEntity) local9.peekFront(); local27 != null; local27 = (ObjStackEntity) local9.prev()) {
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
		for (local27 = (ObjStackEntity) local9.peekFront(); local27 != null; local27 = (ObjStackEntity) local9.prev()) {
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
		@Pc(144) int local144 = x + (z << 7) + 1610612736;
		@Pc(148) ObjType local148 = ObjType.get(local23.index);
		this.scene.addObjStack(local148.getInterfaceModel(local23.count), local118, this.getHeightmapY(this.currentLevel, x * 128 + 64, z * 128 + 64), this.currentLevel, local144, z, x, local128);
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
			@Pc(56) byte[] local56 = new byte[100000];
			@Pc(60) int local60 = this.sceneMapLandData.length;
			World.lowMemory = World3D.lowMemory;
			@Pc(73) int local73;
			@Pc(80) int local80;
			for (@Pc(64) int index = 0; index < local60; index++) {
				local73 = this.sceneMapIndex[index] >> 8;
				local80 = this.sceneMapIndex[index] & 0xFF;
				// underground pass check
				if (local73 == 33 && local80 >= 71 && local80 <= 73) {
					World.lowMemory = false;
				}
			}
			if (World.lowMemory) {
				this.scene.setMinLevel(this.currentLevel);
			} else {
				this.scene.setMinLevel(0);
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
					world.readLandscape(local56, (this.sceneCenterZoneX - 6) * 8, local143, local80, (this.sceneCenterZoneZ - 6) * 8);
				} else if (this.sceneCenterZoneZ < 800) {
					world.clearLandscape(local80, local143, 64, 64);
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
					world.readLocs(local56, this.scene, this.levelCollisionMap, this.locList, local259, local157);
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
		} catch (@Pc(390) Exception local390) {
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
	private int executeClientscript1(@OriginalArg(0) IfType component, @OriginalArg(2) int script) {
		if (component.scripts == null || script >= component.scripts.length) {
			return -2;
		}
		try {
			@Pc(26) int[] local26 = component.scripts[script];
			@Pc(28) int local28 = 0;
			@Pc(30) int local30 = 0;
			while (true) {
				@Pc(35) int opcode = local26[local30++];
				if (opcode == 0) {
					return local28;
				}
				if (opcode == 1) { // load_skill_level {skill}
					local28 += this.skillLevel[local26[local30++]];
				}
				if (opcode == 2) { // load_skill_base_level {skill}
					local28 += this.skillBaseLevel[local26[local30++]];
				}
				if (opcode == 3) { // load_skill_exp {skill}
					local28 += this.skillExperience[local26[local30++]];
				}
				@Pc(88) IfType local88;
				@Pc(95) int local95;
				@Pc(97) int local97;
				if (opcode == 4) { // load_inv_count {interface id} {obj id}
					local88 = IfType.instances[local26[local30++]];
					local95 = local26[local30++] + 1;
					for (local97 = 0; local97 < local88.inventorySlotObjId.length; local97++) {
						if (local88.inventorySlotObjId[local97] == local95) {
							local28 += local88.inventorySlotObjCount[local97];
						}
					}
				}
				if (opcode == 5) { // load_var {id}
					local28 += this.varps[local26[local30++]];
				}
				if (opcode == 6) { // load_next_level_xp {skill}
					local28 += levelExperience[this.skillBaseLevel[local26[local30++]] - 1];
				}
				if (opcode == 7) {
					local28 += this.varps[local26[local30++]] * 100 / 46875;
				}
				if (opcode == 8) { // load_combat_level
					local28 += this.localPlayer.combatLevel;
				}
				@Pc(179) int local179;
				if (opcode == 9) { // load_total_level
					for (local179 = 0; local179 < 19; local179++) {
						if (local179 == 18) {
							local179 = 20;
						}
						local28 += this.skillBaseLevel[local179];
					}
				}
				if (opcode == 10) { // load_inv_contains {interface id} {obj id}
					local88 = IfType.instances[local26[local30++]];
					local95 = local26[local30++] + 1;
					for (local97 = 0; local97 < local88.inventorySlotObjId.length; local97++) {
						if (local88.inventorySlotObjId[local97] == local95) {
							local28 += 999999999;
							break;
						}
					}
				}
				if (opcode == 11) { // load_energy
					local28 += this.energy;
				}
				if (opcode == 12) { // load_weight
					local28 += this.weightCarried;
				}
				if (opcode == 13) { // load_bool {varp} {bit: 0..31}
					local179 = this.varps[local26[local30++]];
					local95 = local26[local30++];
					local28 += (local179 & 0x1 << local95) == 0 ? 0 : 1;
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
			g.setFont(new Font("Helvetica", Font.BOLD, 16));
			g.setColor(Color.yellow);
			int y = 35;
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
			g.setColor(Color.yellow);
			int y = 35;
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
			@Pc(14) boolean local14 = false;
			loc.seqCycle += this.sceneDelta;
			if (loc.seqFrame == -1) {
				loc.seqFrame = 0;
				local14 = true;
			}
			label70:
			{
				do {
					do {
						if (loc.seqCycle <= loc.seq.delay[loc.seqFrame]) {
							break label70;
						}
						loc.seqCycle -= loc.seq.delay[loc.seqFrame] + 1;
						loc.seqFrame++;
						local14 = true;
					} while (loc.seqFrame < loc.seq.frameCount);
					loc.seqFrame -= loc.seq.replayoff;
				} while (loc.seqFrame >= 0 && loc.seqFrame < loc.seq.frameCount);
				loc.unlink();
				local14 = false;
			}
			if (local14) {
				@Pc(96) int local96 = loc.heightmapSW;
				@Pc(99) int local99 = loc.heightmapNE;
				@Pc(102) int local102 = loc.heightmapNW;
				@Pc(104) int local104 = 0;
				if (loc.heightmapSE == 0) {
					local104 = this.scene.getWallBitset(local96, local99, local102);
				}
				if (loc.heightmapSE == 1) {
					local104 = this.scene.getWallDecorationBitset(local96, local102, local99);
				}
				if (loc.heightmapSE == 2) {
					local104 = this.scene.getLocBitset(local96, local99, local102);
				}
				if (loc.heightmapSE == 3) {
					local104 = this.scene.getGroundDecorationBitset(local96, local99, local102);
				}
				if (local104 != 0 && (local104 >> 14 & 0x7FFF) == loc.index) {
					@Pc(171) int local171 = this.levelHeightmap[local96][local99][local102];
					@Pc(182) int local182 = this.levelHeightmap[local96][local99 + 1][local102];
					@Pc(195) int local195 = this.levelHeightmap[local96][local99 + 1][local102 + 1];
					@Pc(206) int local206 = this.levelHeightmap[local96][local99][local102 + 1];
					@Pc(210) LocType local210 = LocType.get(loc.index);
					@Pc(212) int local212 = -1;
					if (loc.seqFrame != -1) {
						local212 = loc.seq.frames[loc.seqFrame];
					}
					@Pc(235) int local235;
					@Pc(239) int local239;
					@Pc(243) int local243;
					@Pc(258) Model local258;
					if (loc.heightmapSE == 2) {
						local235 = this.scene.getInfo(local96, local99, local102, local104);
						local239 = local235 & 0x1F;
						local243 = local235 >> 6;
						if (local239 == 11) {
							local239 = 10;
						}
						local258 = local210.getModel(local239, local243, local171, local182, local195, local206, local212);
						this.scene.setLocModel(local99, local258, local96, local102);
					} else if (loc.heightmapSE == 1) {
						@Pc(282) Model local282 = local210.getModel(4, 0, local171, local182, local195, local206, local212);
						this.scene.setWallDecorationModel(local102, local99, local282, local96);
					} else if (loc.heightmapSE == 0) {
						local235 = this.scene.getInfo(local96, local99, local102, local104);
						local239 = local235 & 0x1F;
						local243 = local235 >> 6;
						if (local239 == 2) {
							@Pc(320) int local320 = local243 + 1 & 0x3;
							@Pc(332) Model local332 = local210.getModel(2, local243 + 4, local171, local182, local195, local206, local212);
							@Pc(342) Model local342 = local210.getModel(2, local320, local171, local182, local195, local206, local212);
							this.scene.setWallModels(local332, local342, local102, local99, local96);
						} else {
							local258 = local210.getModel(local239, local243, local171, local182, local195, local206, local212);
							this.scene.setWallModel(local258, local102, local99, local96);
						}
					} else if (loc.heightmapSE == 3) {
						local235 = this.scene.getInfo(local96, local99, local102, local104);
						local239 = local235 >> 6;
						@Pc(400) Model local400 = local210.getModel(22, local239, local171, local182, local195, local206, local212);
						this.scene.setGroundDecorationModel(local400, local102, local99, local96);
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
					for (@Pc(34) int local34 = i; local34 < this.ignoreCount; local34++) {
						this.ignoreName37[local34] = this.ignoreName37[local34 + 1];
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
				if (local74 == 2 && this.scene.getInfo(this.currentLevel, local62, local68, local58) >= 0) {
					@Pc(100) LocType local100 = LocType.get(local80);
					if (this.objSelected == 1) {
						this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @cya@" + local100.name;
						this.menuAction[this.menuSize] = 450;
						this.menuParamA[this.menuSize] = local58;
						this.menuParamB[this.menuSize] = local62;
						this.menuParamC[this.menuSize] = local68;
						this.menuSize++;
					} else if (this.spellSelected != 1) {
						if (local100.ops != null) {
							for (local218 = 4; local218 >= 0; local218--) {
								if (local100.ops[local218] != null) {
									this.menuOption[this.menuSize] = local100.ops[local218] + " @cya@" + local100.name;
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
					} else if ((this.activeSpellFlags & 0x4) == 4) {
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
						for (@Pc(572) ObjStackEntity local572 = (ObjStackEntity) local565.peekBack(); local572 != null; local572 = (ObjStackEntity) local565.next()) {
							@Pc(578) ObjType local578 = ObjType.get(local572.index);
							if (this.objSelected == 1) {
								this.menuOption[this.menuSize] = "Use " + this.objSelectedName + " with @lre@" + local578.name;
								this.menuAction[this.menuSize] = 217;
								this.menuParamA[this.menuSize] = local572.index;
								this.menuParamB[this.menuSize] = local62;
								this.menuParamC[this.menuSize] = local68;
								this.menuSize++;
							} else if (this.spellSelected != 1) {
								for (@Pc(695) int local695 = 4; local695 >= 0; local695--) {
									if (local578.ops != null && local578.ops[local695] != null) {
										this.menuOption[this.menuSize] = local578.ops[local695] + " @lre@" + local578.name;
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
										this.menuOption[this.menuSize] = "Take @lre@" + local578.name;
										this.menuAction[this.menuSize] = 99;
										this.menuParamA[this.menuSize] = local572.index;
										this.menuParamB[this.menuSize] = local62;
										this.menuParamC[this.menuSize] = local68;
										this.menuSize++;
									}
								}
								this.menuOption[this.menuSize] = "Examine @lre@" + local578.name;
								this.menuAction[this.menuSize] = 1102;
								this.menuParamA[this.menuSize] = local572.index;
								this.menuParamB[this.menuSize] = local62;
								this.menuParamC[this.menuSize] = local68;
								this.menuSize++;
							} else if ((this.activeSpellFlags & 0x1) == 1) {
								this.menuOption[this.menuSize] = this.spellCaption + " @lre@" + local578.name;
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
		@Pc(7) int local7 = buf.gBit(1);
		if (local7 != 0) {
			@Pc(21) int local21 = buf.gBit(2);
			if (local21 == 0) {
				this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
			} else {
				@Pc(44) int local44;
				@Pc(55) int local55;
				if (local21 == 1) {
					local44 = buf.gBit(3);
					this.localPlayer.step(false, local44);
					local55 = buf.gBit(1);
					if (local55 == 1) {
						this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
					}
				} else {
					@Pc(101) int local101;
					if (local21 == 2) {
						local44 = buf.gBit(3);
						this.localPlayer.step(true, local44);
						local55 = buf.gBit(3);
						this.localPlayer.step(true, local55);
						local101 = buf.gBit(1);
						if (local101 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
						}
					} else if (local21 == 3) {
						this.currentLevel = buf.gBit(2);
						local44 = buf.gBit(7);
						local55 = buf.gBit(7);
						local101 = buf.gBit(1);
						this.localPlayer.move(local101 == 1, local44, local55);
						@Pc(158) int local158 = buf.gBit(1);
						if (local158 == 1) {
							this.entityUpdateIds[this.entityUpdateCount++] = this.LOCAL_PLAYER_INDEX;
						}
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
			@Pc(135) PixFont local135 = this.fontPlain12;
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
					Signlink.cachesave("m" + x + "_" + z, this.sceneMapLandData[index]);
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
				Signlink.looprate(5);
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
						data = Signlink.cacheload("m" + mapsquareX + "_" + mapsquareZ);
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
						data = Signlink.cacheload("l" + mapsquareX + "_" + mapsquareZ);
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
				Signlink.looprate(50);
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
				IfType.instances[com].model = this.localPlayer.getHeadModel();
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
					Signlink.cachesave("l" + x + "_" + z, this.sceneMapLocData[index]);
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
				IfType.instances[com].seqId = seqId;
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
				IfType inv = IfType.instances[com];
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
				IfType inv = IfType.instances[com];
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
					Signlink.dnslookup(JString.formatIPv4(this.lastAddress));
					this.closeInterfaces();
					@Pc(1915) short contentType = 650;
					if (this.daysSinceRecoveriesChanged != 201) {
						contentType = 655;
					}
					this.reportAbuseInput = "";
					this.reportAbuseMuteOption = false;
					for (int i = 0; i < IfType.instances.length; i++) {
						if (IfType.instances[i] != null && IfType.instances[i].contentType == contentType) {
							this.viewportInterfaceID = IfType.instances[i].parentId;
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
				IfType.instances[com].model = npc.getHeadModel();
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
				IfType inter = IfType.instances[com];
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
				IfType inter = IfType.instances[com];
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
						Signlink.reporterror("cde1");
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
				IfType.instances[com].model = new Model(model);
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
					String local3040 = message.substring(0, message.indexOf(":"));
					username = JString.toBase37(local3040);
					boolean local2652 = false;
					for (int local650 = 0; local650 < this.ignoreCount; local650++) {
						if (this.ignoreName37[local650] == username) {
							local2652 = true;
							break;
						}
					}
					if (!local2652 && this.overrideChat == 0) {
						this.addMessage(8, "wishes to duel with you.", local3040);
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
				IfType.instances[com].model = obj.getInterfaceModel(50);
				IfType.instances[com].modelPitch = obj.xan2d;
				IfType.instances[com].modelYaw = obj.yan2d;
				IfType.instances[com].modelZoom = obj.zoom2d * 100 / zoom;
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
				IfType.instances[com].color = (r << 19) + (g << 11) + (b << 3);
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
				IfType.instances[com].hide = hide;
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
				IfType.instances[com].text = text;
				if (IfType.instances[com].parentId == this.tabInterfaceId[this.selectedTab]) {
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
				IfType inv = IfType.instances[com];
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
			Signlink.reporterror("T1 - " + this.packetType + "," + this.packetSize + " - " + this.lastPacketType1 + "," + this.lastPacketType2);
			this.logout();
		} catch (@Pc(3862) IOException ex) {
			this.tryReconnect();
		} catch (@Pc(3867) Exception ex) {
			String error = "T2 - " + this.packetType + "," + this.lastPacketType1 + "," + this.lastPacketType2 + " - " + this.packetSize + "," + (this.sceneBaseTileX + this.localPlayer.pathTileX[0]) + "," + (this.sceneBaseTileZ + this.localPlayer.pathTileZ[0]) + " - ";
			for (int i = 0; i < this.packetSize && i < 50; i++) {
				error = error + this.in.data[i] + ",";
			}
			Signlink.reporterror(error);
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
						Signlink.reporterror("cde2");
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
