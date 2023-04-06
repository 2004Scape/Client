package jagex2;

public class zoneprot {

	public static final int LOC_ADD_CHANGE = 23; // not confident about the naming. Affects "temporary" locs instead of LOC_ADD "spawned" locs
	public static final int LOC_ANIM = 42;
	public static final int OBJ_DEL = 49;
	public static final int OBJ_ADD = 50;
	public static final int LOC_ADD = 59;
	public static final int MAP_PROJANIM = 69;
	public static final int LOC_DEL = 76;
	public static final int OBJ_COUNT = 151;
	public static final int MAP_ANIM = 191;
	public static final int OBJ_REVEAL = 223;

	static {
		serverprot.PACKET_LENGTHS[LOC_ADD_CHANGE] = 14;
		serverprot.PACKET_LENGTHS[LOC_ANIM] = 4;
		serverprot.PACKET_LENGTHS[OBJ_DEL] = 3;
		serverprot.PACKET_LENGTHS[OBJ_ADD] = 7;
		serverprot.PACKET_LENGTHS[LOC_ADD] = 4;
		serverprot.PACKET_LENGTHS[MAP_PROJANIM] = 15;
		serverprot.PACKET_LENGTHS[LOC_DEL] = 2;
		serverprot.PACKET_LENGTHS[OBJ_COUNT] = 7;
		serverprot.PACKET_LENGTHS[MAP_ANIM] = 6;
		serverprot.PACKET_LENGTHS[OBJ_REVEAL] = 5;
	}

}
