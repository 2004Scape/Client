package jagex2;

import org.openrs2.deob.annotation.OriginalMember;

public class ClientProt {

	@OriginalMember(owner = "client!dc", name = "a", descriptor = "[I")
	private static final int[] SCRAMBLED = new int[] { 95, 218, 67, 50, 253, 222, 194, 60, 101, 128, 8, 251, 92, 111, 24, 33, 223, 66, 232, 59, 227, 113, 153, 105, 126, 98, 167, 102, 177, 238, 62, 190, 147, 23, 150, 151, 156, 144, 193, 155, 81, 0, 198, 22, 137, 210, 179, 16, 168, 170, 32, 181, 248, 141, 58, 87, 208, 106, 180, 191, 221, 241, 40, 176, 196, 154, 65, 145, 230, 78, 30, 161, 188, 41, 14, 129, 18, 199, 47, 247, 225, 34, 51, 10, 159, 75, 12, 56, 61, 31, 39, 91, 46, 242, 134, 5, 122, 123, 209, 228, 104, 195, 21, 3, 11, 44, 107, 172, 6, 186, 110, 215, 205, 103, 27, 185, 124, 77, 252, 117, 86, 115, 127, 207, 52, 79, 43, 97, 219, 116, 169, 7, 118, 162, 108, 36, 20, 233, 88, 135, 80, 19, 42, 237, 57, 152, 71, 9, 250, 17, 4, 119, 234, 130, 26, 200, 189, 163, 254, 245, 197, 171, 220, 235, 140, 244, 184, 94, 211, 231, 99, 246, 121, 212, 112, 204, 63, 148, 83, 178, 1, 255, 131, 13, 183, 142, 236, 45, 55, 35, 243, 136, 37, 85, 100, 160, 38, 224, 146, 174, 82, 48, 109, 132, 125, 90, 143, 138, 240, 173, 165, 164, 192, 175, 29, 74, 28, 114, 213, 73, 64, 206, 76, 139, 96, 2, 229, 15, 93, 25, 239, 202, 49, 70, 214, 201, 72, 203, 68, 89, 69, 157, 216, 217, 249, 120, 226, 84, 149, 187, 54, 53, 158, 166, 182, 133, 0 };

	public static final int[] PACKET_LENGTHS = new int[256];

	// anticheat_* helps detect reflection bots
	public static final int ANTICHEAT_DRAW = 146;
	public static final int ANTICHEAT_UPDATE = 215;
	public static final int ANTICHEAT_UPDATE2 = 236;
	public static final int ANTICHEAT_UPDATE_LOCS = 85;
	public static final int ANTICHEAT_UPDATE_PLAYERS = 219;
	public static final int ANTICHEAT_SIDEBAR_INPUT = 233;

	public static final int IF_BUTTON = 155; // clicking an interface button
	public static final int IF_BUTTON1 = 31; // interface options 1-5 on an obj
	public static final int IF_BUTTON2 = 59;
	public static final int IF_BUTTON3 = 212;
	public static final int IF_BUTTON4 = 38;
	public static final int ANTICHEAT_IF_BUTTON4 = 238;
	public static final int IF_BUTTON5 = 6;
	public static final int ANTICHEAT_IF_BUTTON5 = 17;
	public static final int IF_BUTTOND = 159; // dragging an inv obj to another slot
	public static final int IF_FLASHING_TAB = 175; // todo name: clicked flashing tab during tutorial
	public static final int IF_DESIGN = 52; // todo name: finished customizing character design
	public static final int CLOSE_MODAL = 231; // closing an interface
	public static final int RESUME_PAUSEBUTTON = 235; // "Continue" button dialog
	public static final int RESUME_P_COUNTDIALOG = 237; // "Enter amount" dialog

	public static final int OPNPC1 = 194; // npc options 1-5
	public static final int OPNPC2 = 8;
	public static final int OPNPC3 = 27;
	public static final int ANTICHEAT_OPNPC3 = 88;
	public static final int OPNPC4 = 113;
	public static final int OPNPC5 = 100;
	public static final int ANTICHEAT_OPNPC5 = 176;
	public static final int OPNPCU = 202; // using an item on a npc
	public static final int OPNPCT = 134; // targeting a npc with a spell

	public static final int OPLOC1 = 245; // loc (object) options 1-5
	public static final int OPLOC2 = 172;
	public static final int OPLOC3 = 96;
	public static final int OPLOC4 = 97;
	public static final int ANTICHEAT_OPLOC4 = 7;
	public static final int OPLOC5 = 116;
	public static final int ANTICHEAT_OPLOC5 = 66;
	public static final int OPLOCU = 75; // using an item on a loc
	public static final int OPLOCT = 9; // targeting a loc with a spell

	public static final int OPOBJ1 = 140; // objstack (ground item) options 1-5
	public static final int OPOBJ2 = 40;
	public static final int OPOBJ3 = 200;
	public static final int OPOBJ4 = 178;
	public static final int OPOBJ5 = 247;
	public static final int OPOBJU = 239; // using an item on an objstack
	public static final int OPOBJT = 138; // targeting an objstack with a spell

	public static final int OPHELD1 = 195; // inv obj (items in inventory) options 1-5
	public static final int ANTICHEAT_OPHELD1 = 30;
	public static final int OPHELD2 = 71;
	public static final int OPHELD3 = 133;
	public static final int OPHELD4 = 157;
	public static final int ANTICHEAT_OPHELD4 = 220;
	public static final int OPHELD5 = 211;
	public static final int OPHELDU = 130; // using an item on an inv obj
	public static final int OPHELDT = 48; // targeting a spell on an inv obj

	public static final int OPPLAYER1 = 164; // player options 1-5
	public static final int OPPLAYER2 = 53;
	public static final int ANTICHEAT_OPPLAYER2 = 2;
	public static final int OPPLAYER3 = 185;
	public static final int OPPLAYER4 = 206;
	public static final int OPPLAYERU = 248; // using an item on a player
	public static final int OPPLAYERT = 177; // targeting a spell on a player

	public static final int CHAT_SETMODE = 244;
	public static final int BUG_REPORT = 190; // todo: confirm if this is report abuse
	public static final int MESSAGE_PUBLIC = 158;
	public static final int MESSAGE_PRIVATE = 148;
	public static final int FRIENDLIST_ADD = 118;
	public static final int FRIENDLIST_DEL = 11;
	public static final int IGNORELIST_ADD = 79;
	public static final int IGNORELIST_DEL = 171;

	public static final int MOVE_MINIMAPCLICK = 165;
	public static final int MOVE_GAMECLICK = 181;
	public static final int MOVE_OPCLICK = 93; // todo: sent when an OP is selected >1 tile away, what's the real name?

	public static final int EVENT_CAMERA_POSITION = 189;
	public static final int CLIENT_CHEAT = 4;
	public static final int NO_TIMEOUT = 108;
	public static final int IDLE_TIMER = 70; // todo name: no input, notify the server to log out
	public static final int MAP_REQUEST_AREAS = 150; // todo name: request missing map files
	public static final int EVENT_TRACKING = 81; // todo name: bot detection, all inputs get recorded in a buffer and sent up

	static {
		PACKET_LENGTHS[ANTICHEAT_DRAW] = -1;
		PACKET_LENGTHS[ANTICHEAT_UPDATE] = 3;
		PACKET_LENGTHS[ANTICHEAT_UPDATE2] = 4;
		PACKET_LENGTHS[ANTICHEAT_UPDATE_LOCS] = 0;
		PACKET_LENGTHS[ANTICHEAT_UPDATE_PLAYERS] = -1;
		PACKET_LENGTHS[ANTICHEAT_SIDEBAR_INPUT] = 1;

		PACKET_LENGTHS[IF_BUTTON] = 2;
		PACKET_LENGTHS[IF_BUTTON1] = 6;
		PACKET_LENGTHS[IF_BUTTON2] = 6;
		PACKET_LENGTHS[IF_BUTTON3] = 6;
		PACKET_LENGTHS[IF_BUTTON4] = 6;
		PACKET_LENGTHS[ANTICHEAT_IF_BUTTON4] = 1;
		PACKET_LENGTHS[IF_BUTTON5] = 6;
		PACKET_LENGTHS[ANTICHEAT_IF_BUTTON5] = 4;
		PACKET_LENGTHS[IF_BUTTOND] = 6;
		PACKET_LENGTHS[IF_FLASHING_TAB] = 1;
		PACKET_LENGTHS[IF_DESIGN] = 13;
		PACKET_LENGTHS[CLOSE_MODAL] = 0;
		PACKET_LENGTHS[RESUME_PAUSEBUTTON] = 2;
		PACKET_LENGTHS[RESUME_P_COUNTDIALOG] = 4;

		PACKET_LENGTHS[OPNPC1] = 2;
		PACKET_LENGTHS[OPNPC2] = 2;
		PACKET_LENGTHS[OPNPC3] = 2;
		PACKET_LENGTHS[ANTICHEAT_OPNPC3] = 4;
		PACKET_LENGTHS[OPNPC4] = 2;
		PACKET_LENGTHS[OPNPC5] = 2;
		PACKET_LENGTHS[ANTICHEAT_OPNPC5] = 2;
		PACKET_LENGTHS[OPNPCU] = 8;
		PACKET_LENGTHS[OPNPCT] = 4;

		PACKET_LENGTHS[OPLOC1] = 6;
		PACKET_LENGTHS[OPLOC2] = 6;
		PACKET_LENGTHS[OPLOC3] = 6;
		PACKET_LENGTHS[OPLOC4] = 6;
		PACKET_LENGTHS[ANTICHEAT_OPLOC4] = 4;
		PACKET_LENGTHS[OPLOC5] = 6;
		PACKET_LENGTHS[ANTICHEAT_OPLOC5] = 4;
		PACKET_LENGTHS[OPLOCU] = 12;
		PACKET_LENGTHS[OPLOCT] = 8;

		PACKET_LENGTHS[OPOBJ1] = 6;
		PACKET_LENGTHS[OPOBJ2] = 6;
		PACKET_LENGTHS[OPOBJ3] = 6;
		PACKET_LENGTHS[OPOBJ4] = 6;
		PACKET_LENGTHS[OPOBJ5] = 6;
		PACKET_LENGTHS[OPOBJU] = 12;
		PACKET_LENGTHS[OPOBJT] = 8;

		PACKET_LENGTHS[OPHELD1] = 6;
		PACKET_LENGTHS[ANTICHEAT_OPHELD1] = 3;
		PACKET_LENGTHS[OPHELD2] = 6;
		PACKET_LENGTHS[OPHELD3] = 6;
		PACKET_LENGTHS[OPHELD4] = 6;
		PACKET_LENGTHS[ANTICHEAT_OPHELD4] = 0;
		PACKET_LENGTHS[OPHELD5] = 6;
		PACKET_LENGTHS[OPHELDU] = 12;
		PACKET_LENGTHS[OPHELDT] = 8;

		PACKET_LENGTHS[OPPLAYER3] = 2;
		PACKET_LENGTHS[OPPLAYER4] = 2;
		PACKET_LENGTHS[OPPLAYER2] = 2;
		PACKET_LENGTHS[ANTICHEAT_OPPLAYER2] = 2;
		PACKET_LENGTHS[OPPLAYER1] = 2;
		PACKET_LENGTHS[OPPLAYERU] = 8;
		PACKET_LENGTHS[OPPLAYERT] = 4;

		PACKET_LENGTHS[CHAT_SETMODE] = 3;
		PACKET_LENGTHS[BUG_REPORT] = 10;
		PACKET_LENGTHS[MESSAGE_PUBLIC] = -1;
		PACKET_LENGTHS[MESSAGE_PRIVATE] = -1;
		PACKET_LENGTHS[FRIENDLIST_ADD] = 8;
		PACKET_LENGTHS[FRIENDLIST_DEL] = 8;
		PACKET_LENGTHS[IGNORELIST_ADD] = 8;
		PACKET_LENGTHS[IGNORELIST_DEL] = 8;

		PACKET_LENGTHS[MOVE_GAMECLICK] = -1;
		PACKET_LENGTHS[MOVE_MINIMAPCLICK] = -1;
		PACKET_LENGTHS[MOVE_OPCLICK] = -1;

		PACKET_LENGTHS[EVENT_CAMERA_POSITION] = 6;
		PACKET_LENGTHS[CLIENT_CHEAT] = -1;
		PACKET_LENGTHS[NO_TIMEOUT] = 0;
		PACKET_LENGTHS[IDLE_TIMER] = 0;
		PACKET_LENGTHS[MAP_REQUEST_AREAS] = -1;
		PACKET_LENGTHS[EVENT_TRACKING] = -2;
	}

}
