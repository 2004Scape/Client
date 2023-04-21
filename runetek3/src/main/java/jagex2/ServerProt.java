package jagex2;

import org.openrs2.deob.annotation.OriginalMember;

public class ServerProt {

	@OriginalMember(owner = "client!dc", name = "b", descriptor = "[I")
	public static final int[] PACKET_LENGTHS = new int[256];

	public static final int IF_SETCOLOUR = 2; // not sure if this is supposed to represent text color or model color
	public static final int IF_OPENBOTTOM = 14; // not an original name
	public static final int IF_OPENSUB = 28;
	public static final int IF_SETHIDE = 26;
	public static final int IF_SETOBJECT = 46;
	public static final int IF_SETTAB_ACTIVE = 84; // not an original name
	public static final int IF_SETMODEL = 87;
	public static final int IF_SETMODEL_COLOUR = 103; // not an original name
	public static final int IF_SETTAB_FLASH = 126; // not an original name
	public static final int IF_CLOSESUB = 129;
	public static final int IF_SETANIM = 146;
	public static final int IF_SETTAB = 167; // not an original name
	public static final int IF_OPENTOP = 168;
	public static final int IF_OPENSTICKY = 185; // not an original name
	public static final int IF_OPENSIDEBAR = 195;
	public static final int IF_SETPLAYERHEAD = 197;
	public static final int IF_SETTEXT = 201;
	public static final int IF_SETNPCHEAD = 204;
	public static final int IF_SETPOSITION = 209;
	public static final int IF_IAMOUNT = 243; // not an original name
	public static final int IF_MULTIZONE = 254; // not an original name

	public static final int UPDATE_INV_CLEAR = 15; // not an original name
	public static final int UPDATE_INV_FULL = 98;
	public static final int UPDATE_INV_PARTIAL = 213;

	public static final int CAM_FORCEANGLE = 3;
	public static final int CAM_SHAKE = 13;
	public static final int CAM_MOVETO = 74;
	public static final int CAM_RESET = 239;

	public static final int NPC_INFO = 1;
	public static final int PLAYER_INFO = 184;

	public static final int CLEAR_WALKING_QUEUE = 19;
	public static final int UPDATE_RUNWEIGHT = 22;
	public static final int HINT_ARROW = 25;
	public static final int UPDATE_REBOOT_TIMER = 43;
	public static final int UPDATE_STAT = 44;
	public static final int UPDATE_RUNENERGY = 68;
	public static final int FINISH_TRACKING = 133; // not an original name. tell the client to flush input events
	public static final int RESET_ANIMS = 136;
	public static final int UPDATE_UID192 = 139;
	public static final int LAST_LOGIN_INFO = 140;
	public static final int LOGOUT = 142;
	public static final int ENABLE_TRACKING = 226; // not an original name. tell the client to track input events

	public static final int MESSAGE_GAME = 4;
	public static final int UPDATE_IGNORELIST = 21;
	public static final int CHAT_FILTER_SETTINGS = 32;
	public static final int MESSAGE_PRIVATE = 41;
	public static final int UPDATE_FRIENDLIST = 152;

	// none of these DATA_ packets are original names
	public static final int DATA_LOC_DONE = 20;
	public static final int DATA_LAND_DONE = 80;
	public static final int DATA_LAND = 132;
	public static final int DATA_LOC = 220;
	public static final int LOAD_AREA = 237;

	public static final int VARP_SMALL = 150;
	public static final int VARP_LARGE = 175;
	public static final int RESET_CLIENT_VARCACHE = 193;

	public static final int SYNTH_SOUND = 12;
	public static final int MIDI_SONG = 54;
	public static final int MIDI_JINGLE = 212;

	public static final int UPDATE_ZONE_PARTIAL_FOLLOWS = 7;
	public static final int UPDATE_ZONE_FULL_FOLLOWS = 135;
	public static final int UPDATE_ZONE_PARTIAL_ENCLOSED = 162;

	static {
		PACKET_LENGTHS[IF_SETCOLOUR] = 4;
		PACKET_LENGTHS[IF_OPENBOTTOM] = 2;
		PACKET_LENGTHS[IF_OPENSUB] = 4;
		PACKET_LENGTHS[IF_SETHIDE] = 3;
		PACKET_LENGTHS[IF_SETOBJECT] = 6;
		PACKET_LENGTHS[IF_SETTAB_ACTIVE] = 1;
		PACKET_LENGTHS[IF_SETMODEL] = 4;
		PACKET_LENGTHS[IF_SETMODEL_COLOUR] = 6;
		PACKET_LENGTHS[IF_SETTAB_FLASH] = 1;
		PACKET_LENGTHS[IF_CLOSESUB] = 0;
		PACKET_LENGTHS[IF_SETANIM] = 4;
		PACKET_LENGTHS[IF_SETTAB] = 3;
		PACKET_LENGTHS[IF_OPENTOP] = 2;
		PACKET_LENGTHS[IF_OPENSTICKY] = 2;
		PACKET_LENGTHS[IF_OPENSIDEBAR] = 2;
		PACKET_LENGTHS[IF_SETPLAYERHEAD] = 2;
		PACKET_LENGTHS[IF_SETTEXT] = -2;
		PACKET_LENGTHS[IF_SETNPCHEAD] = 4;
		PACKET_LENGTHS[IF_SETPOSITION] = 6;
		PACKET_LENGTHS[IF_IAMOUNT] = 0;
		PACKET_LENGTHS[IF_MULTIZONE] = 1;

		PACKET_LENGTHS[UPDATE_INV_CLEAR] = 2;
		PACKET_LENGTHS[UPDATE_INV_FULL] = -2;
		PACKET_LENGTHS[UPDATE_INV_PARTIAL] = -2;

		PACKET_LENGTHS[CAM_FORCEANGLE] = 6;
		PACKET_LENGTHS[CAM_SHAKE] = 4;
		PACKET_LENGTHS[CAM_MOVETO] = 6;
		PACKET_LENGTHS[CAM_RESET] = 0;

		PACKET_LENGTHS[NPC_INFO] = -2;
		PACKET_LENGTHS[PLAYER_INFO] = -2;

		PACKET_LENGTHS[CLEAR_WALKING_QUEUE] = 0;
		PACKET_LENGTHS[UPDATE_RUNWEIGHT] = 2;
		PACKET_LENGTHS[HINT_ARROW] = 6;
		PACKET_LENGTHS[UPDATE_REBOOT_TIMER] = 2;
		PACKET_LENGTHS[UPDATE_STAT] = 6;
		PACKET_LENGTHS[UPDATE_RUNENERGY] = 1;
		PACKET_LENGTHS[FINISH_TRACKING] = 0;
		PACKET_LENGTHS[RESET_ANIMS] = 0;
		PACKET_LENGTHS[UPDATE_UID192] = 2;
		PACKET_LENGTHS[LAST_LOGIN_INFO] = 9;
		PACKET_LENGTHS[LOGOUT] = 0;
		PACKET_LENGTHS[ENABLE_TRACKING] = 0;

		PACKET_LENGTHS[MESSAGE_GAME] = -1;
		PACKET_LENGTHS[UPDATE_IGNORELIST] = -2;
		PACKET_LENGTHS[CHAT_FILTER_SETTINGS] = 3;
		PACKET_LENGTHS[MESSAGE_PRIVATE] = -1;
		PACKET_LENGTHS[UPDATE_FRIENDLIST] = 9;

		PACKET_LENGTHS[DATA_LOC_DONE] = 2;
		PACKET_LENGTHS[DATA_LAND_DONE] = 2;
		PACKET_LENGTHS[DATA_LAND] = -2;
		PACKET_LENGTHS[DATA_LOC] = -2;
		PACKET_LENGTHS[LOAD_AREA] = -2;

		PACKET_LENGTHS[VARP_SMALL] = 3;
		PACKET_LENGTHS[VARP_LARGE] = 6;
		PACKET_LENGTHS[RESET_CLIENT_VARCACHE] = 0;

		PACKET_LENGTHS[SYNTH_SOUND] = 5;
		PACKET_LENGTHS[MIDI_SONG] = -1;
		PACKET_LENGTHS[MIDI_JINGLE] = -2;

		PACKET_LENGTHS[UPDATE_ZONE_PARTIAL_FOLLOWS] = 2;
		PACKET_LENGTHS[UPDATE_ZONE_FULL_FOLLOWS] = 2;
		PACKET_LENGTHS[UPDATE_ZONE_PARTIAL_ENCLOSED] = -2;

		PACKET_LENGTHS[ZoneProt.LOC_ADD_CHANGE] = 14;
		PACKET_LENGTHS[ZoneProt.LOC_ANIM] = 4;
		PACKET_LENGTHS[ZoneProt.OBJ_DEL] = 3;
		PACKET_LENGTHS[ZoneProt.OBJ_ADD] = 7;
		PACKET_LENGTHS[ZoneProt.LOC_ADD] = 4;
		PACKET_LENGTHS[ZoneProt.MAP_PROJANIM] = 15;
		PACKET_LENGTHS[ZoneProt.LOC_DEL] = 2;
		PACKET_LENGTHS[ZoneProt.OBJ_COUNT] = 7;
		PACKET_LENGTHS[ZoneProt.MAP_ANIM] = 6;
		PACKET_LENGTHS[ZoneProt.OBJ_REVEAL] = 5;
	}

}
