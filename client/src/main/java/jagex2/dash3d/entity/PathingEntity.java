package jagex2.dash3d.entity;

import jagex2.config.SeqType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!x")
public class PathingEntity extends Entity {

	@OriginalMember(owner = "client!x", name = "g", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!x", name = "h", descriptor = "I")
	public int z;

	@OriginalMember(owner = "client!x", name = "i", descriptor = "I")
	public int yaw;

	@OriginalMember(owner = "client!x", name = "j", descriptor = "Z")
	public boolean seqStretches = false;

	@OriginalMember(owner = "client!x", name = "k", descriptor = "I")
	public int size = 1;

	@OriginalMember(owner = "client!x", name = "l", descriptor = "I")
	public int seqStandId = -1;

	@OriginalMember(owner = "client!x", name = "m", descriptor = "I")
	public int seqTurnId = -1;

	@OriginalMember(owner = "client!x", name = "n", descriptor = "I")
	public int seqWalkId = -1;

	@OriginalMember(owner = "client!x", name = "o", descriptor = "I")
	public int seqTurnAroundId = -1;

	@OriginalMember(owner = "client!x", name = "p", descriptor = "I")
	public int seqTurnLeftId = -1;

	@OriginalMember(owner = "client!x", name = "q", descriptor = "I")
	public int seqTurnRightId = -1;

	@OriginalMember(owner = "client!x", name = "r", descriptor = "I")
	public int seqRunId = -1;

	@OriginalMember(owner = "client!x", name = "s", descriptor = "Ljava/lang/String;")
	public String chat;

	@OriginalMember(owner = "client!x", name = "t", descriptor = "I")
	public int chatTimer = 100;

	@OriginalMember(owner = "client!x", name = "u", descriptor = "I")
	public int chatColor;

	@OriginalMember(owner = "client!x", name = "v", descriptor = "I")
	public int chatStyle;

	@OriginalMember(owner = "client!x", name = "w", descriptor = "I")
	public int damage;

	@OriginalMember(owner = "client!x", name = "x", descriptor = "I")
	public int damageType;

	@OriginalMember(owner = "client!x", name = "y", descriptor = "I")
	public int combatCycle = -1000;

	@OriginalMember(owner = "client!x", name = "z", descriptor = "I")
	public int health;

	@OriginalMember(owner = "client!x", name = "A", descriptor = "I")
	public int totalHealth;

	@OriginalMember(owner = "client!x", name = "B", descriptor = "I")
	public int targetId = -1;

	@OriginalMember(owner = "client!x", name = "C", descriptor = "I")
	public int targetTileX;

	@OriginalMember(owner = "client!x", name = "D", descriptor = "I")
	public int targetTileZ;

	@OriginalMember(owner = "client!x", name = "E", descriptor = "I")
	public int secondarySeqId = -1;

	@OriginalMember(owner = "client!x", name = "F", descriptor = "I")
	public int secondarySeqFrame;

	@OriginalMember(owner = "client!x", name = "G", descriptor = "I")
	public int secondarySeqCycle;

	@OriginalMember(owner = "client!x", name = "H", descriptor = "I")
	public int primarySeqId = -1;

	@OriginalMember(owner = "client!x", name = "I", descriptor = "I")
	public int primarySeqFrame;

	@OriginalMember(owner = "client!x", name = "J", descriptor = "I")
	public int primarySeqCycle;

	@OriginalMember(owner = "client!x", name = "K", descriptor = "I")
	public int primarySeqDelay;

	@OriginalMember(owner = "client!x", name = "L", descriptor = "I")
	public int primarySeqLoop;

	@OriginalMember(owner = "client!x", name = "M", descriptor = "I")
	public int spotanimId = -1;

	@OriginalMember(owner = "client!x", name = "N", descriptor = "I")
	public int spotanimFrame;

	@OriginalMember(owner = "client!x", name = "O", descriptor = "I")
	public int spotanimCycle;

	@OriginalMember(owner = "client!x", name = "P", descriptor = "I")
	public int spotanimLastCycle;

	@OriginalMember(owner = "client!x", name = "Q", descriptor = "I")
	public int spotanimOffset;

	@OriginalMember(owner = "client!x", name = "R", descriptor = "I")
	public int forceMoveStartSceneTileX;

	@OriginalMember(owner = "client!x", name = "S", descriptor = "I")
	public int forceMoveEndSceneTileX;

	@OriginalMember(owner = "client!x", name = "T", descriptor = "I")
	public int forceMoveStartSceneTileZ;

	@OriginalMember(owner = "client!x", name = "U", descriptor = "I")
	public int forceMoveEndSceneTileZ;

	@OriginalMember(owner = "client!x", name = "V", descriptor = "I")
	public int forceMoveEndCycle;

	@OriginalMember(owner = "client!x", name = "W", descriptor = "I")
	public int forceMoveStartCycle;

	@OriginalMember(owner = "client!x", name = "X", descriptor = "I")
	public int forceMoveFaceDirection;

	@OriginalMember(owner = "client!x", name = "Y", descriptor = "I")
	public int cycle;

	@OriginalMember(owner = "client!x", name = "Z", descriptor = "I")
	public int height;

	@OriginalMember(owner = "client!x", name = "ab", descriptor = "I")
	public int dstYaw;

	@OriginalMember(owner = "client!x", name = "bb", descriptor = "I")
	public int pathLength;

	@OriginalMember(owner = "client!x", name = "cb", descriptor = "[I")
	public final int[] pathTileX = new int[10];

	@OriginalMember(owner = "client!x", name = "db", descriptor = "[I")
	public final int[] pathTileZ = new int[10];

	@OriginalMember(owner = "client!x", name = "eb", descriptor = "[Z")
	public final boolean[] pathRunning = new boolean[10];

	@OriginalMember(owner = "client!x", name = "fb", descriptor = "I")
	public int seqTrigger;

	public int lastMask = -1;
	public int lastMaskCycle = -1;
	public int lastFaceX = -1;
	public int lastFaceZ = -1;

	@OriginalMember(owner = "client!x", name = "a", descriptor = "(ZZII)V")
	public final void move(@OriginalArg(1) boolean teleport, @OriginalArg(2) int x, @OriginalArg(3) int z) {
		if (this.primarySeqId != -1 && SeqType.instances[this.primarySeqId].priority <= 1) {
			this.primarySeqId = -1;
		}

		if (!teleport) {
			@Pc(22) int dx = x - this.pathTileX[0];
			@Pc(29) int dz = z - this.pathTileZ[0];

			if (dx >= -8 && dx <= 8 && dz >= -8 && dz <= 8) {
				if (this.pathLength < 9) {
					this.pathLength++;
				}

				for (@Pc(54) int i = this.pathLength; i > 0; i--) {
					this.pathTileX[i] = this.pathTileX[i - 1];
					this.pathTileZ[i] = this.pathTileZ[i - 1];
					this.pathRunning[i] = this.pathRunning[i - 1];
				}

				this.pathTileX[0] = x;
				this.pathTileZ[0] = z;
				this.pathRunning[0] = false;
				return;
			}
		}

		this.pathLength = 0;
		this.seqTrigger = 0;
		this.pathTileX[0] = x;
		this.pathTileZ[0] = z;
		this.x = this.pathTileX[0] * 128 + this.size * 64;
		this.z = this.pathTileZ[0] * 128 + this.size * 64;
	}

	@OriginalMember(owner = "client!x", name = "a", descriptor = "(ZIB)V")
	public final void step(@OriginalArg(0) boolean running, @OriginalArg(1) int direction) {
		@Pc(6) int nextX = this.pathTileX[0];
		@Pc(11) int nextZ = this.pathTileZ[0];

		if (direction == 0) {
			nextX--;
			nextZ++;
		} else if (direction == 1) {
			nextZ++;
		} else if (direction == 2) {
			nextX++;
			nextZ++;
		} else if (direction == 3) {
			nextX--;
		} else if (direction == 4) {
			nextX++;
		} else if (direction == 5) {
			nextX--;
			nextZ--;
		} else if (direction == 6) {
			nextZ--;
		} else if (direction == 7) {
			nextX++;
			nextZ--;
		}

		if (this.primarySeqId != -1 && SeqType.instances[this.primarySeqId].priority <= 1) {
			this.primarySeqId = -1;
		}

		if (this.pathLength < 9) {
			this.pathLength++;
		}

		for (@Pc(83) int i = this.pathLength; i > 0; i--) {
			this.pathTileX[i] = this.pathTileX[i - 1];
			this.pathTileZ[i] = this.pathTileZ[i - 1];
			this.pathRunning[i] = this.pathRunning[i - 1];
		}

		this.pathTileX[0] = nextX;
		this.pathTileZ[0] = nextZ;
		this.pathRunning[0] = running;
	}

	@OriginalMember(owner = "client!x", name = "b", descriptor = "(Z)Z")
	public boolean isVisible() {
		return false;
	}
}
