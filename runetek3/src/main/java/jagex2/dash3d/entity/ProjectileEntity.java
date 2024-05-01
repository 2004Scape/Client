package jagex2.dash3d.entity;

import jagex2.config.SpotAnimType;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ab")
public class ProjectileEntity extends Entity {

	@OriginalMember(owner = "client!ab", name = "g", descriptor = "Lclient!kc;")
	private final SpotAnimType spotanim;

	@OriginalMember(owner = "client!ab", name = "h", descriptor = "I")
	public final int level;

	@OriginalMember(owner = "client!ab", name = "i", descriptor = "I")
	private final int srcX;

	@OriginalMember(owner = "client!ab", name = "j", descriptor = "I")
	private final int srcZ;

	@OriginalMember(owner = "client!ab", name = "k", descriptor = "I")
	private final int srcY;

	@OriginalMember(owner = "client!ab", name = "l", descriptor = "I")
	public final int offsetY;

	@OriginalMember(owner = "client!ab", name = "m", descriptor = "I")
	public final int startCycle;

	@OriginalMember(owner = "client!ab", name = "n", descriptor = "I")
	public final int lastCycle;

	@OriginalMember(owner = "client!ab", name = "o", descriptor = "I")
	private final int peakPitch;

	@OriginalMember(owner = "client!ab", name = "p", descriptor = "I")
	private final int arc;

	@OriginalMember(owner = "client!ab", name = "q", descriptor = "I")
	public final int target;

	@OriginalMember(owner = "client!ab", name = "r", descriptor = "Z")
	private boolean mobile = false;

	@OriginalMember(owner = "client!ab", name = "s", descriptor = "D")
	public double x;

	@OriginalMember(owner = "client!ab", name = "t", descriptor = "D")
	public double z;

	@OriginalMember(owner = "client!ab", name = "u", descriptor = "D")
	public double y;

	@OriginalMember(owner = "client!ab", name = "v", descriptor = "D")
	private double velocityX;

	@OriginalMember(owner = "client!ab", name = "w", descriptor = "D")
	private double velocityZ;

	@OriginalMember(owner = "client!ab", name = "x", descriptor = "D")
	private double velocity;

	@OriginalMember(owner = "client!ab", name = "y", descriptor = "D")
	private double velocityY;

	@OriginalMember(owner = "client!ab", name = "z", descriptor = "D")
	private double accelerationY;

	@OriginalMember(owner = "client!ab", name = "A", descriptor = "I")
	public int yaw;

	@OriginalMember(owner = "client!ab", name = "B", descriptor = "I")
	private int pitch;

	@OriginalMember(owner = "client!ab", name = "C", descriptor = "I")
	private int seqFrame;

	@OriginalMember(owner = "client!ab", name = "D", descriptor = "I")
	private int seqCycle;

	@OriginalMember(owner = "client!ab", name = "<init>", descriptor = "(IIIIIIIIIIII)V")
	public ProjectileEntity(@OriginalArg(10) int spotanim, @OriginalArg(4) int level, @OriginalArg(11) int srcX, @OriginalArg(9) int srcY, @OriginalArg(2) int srcZ, @OriginalArg(6) int startCycle, @OriginalArg(3) int lastCycle, @OriginalArg(1) int peakPitch, @OriginalArg(7) int arc, @OriginalArg(5) int target, @OriginalArg(0) int offsetY) {
		this.spotanim = SpotAnimType.instances[spotanim];
		this.level = level;
		this.srcX = srcX;
		this.srcZ = srcZ;
		this.srcY = srcY;
		this.startCycle = startCycle;
		this.lastCycle = lastCycle;
		this.peakPitch = peakPitch;
		this.arc = arc;
		this.target = target;
		this.offsetY = offsetY;
		this.mobile = false;
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(IIIII)V")
	public void updateVelocity(@OriginalArg(2) int dstX, @OriginalArg(0) int dstY, @OriginalArg(1) int dstZ, @OriginalArg(4) int cycle) {
		if (!this.mobile) {
			@Pc(8) double dx = dstX - this.srcX;
			@Pc(14) double dz = dstZ - this.srcZ;
			@Pc(23) double d = Math.sqrt(dx * dx + dz * dz);

			this.x = (double) this.srcX + dx * (double) this.arc / d;
			this.z = (double) this.srcZ + dz * (double) this.arc / d;
			this.y = this.srcY;
		}

		double dt = this.lastCycle + 1 - cycle;
		this.velocityX = ((double) dstX - this.x) / dt;
		this.velocityZ = ((double) dstZ - this.z) / dt;
		this.velocity = Math.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);

		if (!this.mobile) {
			this.velocityY = -this.velocity * Math.tan((double) this.peakPitch * 0.02454369D);
		}

		this.accelerationY = ((double) dstY - this.y - this.velocityY * dt) * 2.0D / (dt * dt);
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(BI)V")
	public void update(@OriginalArg(1) int delta) {
		this.mobile = true;
		this.x += this.velocityX * (double) delta;
		this.z += this.velocityZ * (double) delta;
		this.y += this.velocityY * (double) delta + this.accelerationY * 0.5D * (double) delta * (double) delta;
		this.velocityY += this.accelerationY * (double) delta;
		this.yaw = (int) (Math.atan2(this.velocityX, this.velocityZ) * 325.949D) + 1024 & 0x7FF;
		this.pitch = (int) (Math.atan2(this.velocityY, this.velocity) * 325.949D) & 0x7FF;

		if (this.spotanim.seq != null) {
			this.seqCycle += delta;

			while (this.seqCycle > this.spotanim.seq.delay[this.seqFrame]) {
				this.seqCycle -= this.spotanim.seq.delay[this.seqFrame] + 1;
				this.seqFrame++;
				if (this.seqFrame >= this.spotanim.seq.frameCount) {
					this.seqFrame = 0;
				}
			}
		}
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		@Pc(3) Model tmp = this.spotanim.getModel();
		@Pc(19) Model model = new Model(tmp, true, !this.spotanim.disposeAlpha, false);

		if (this.spotanim.seq != null) {
			model.createLabelReferences();
			model.applyTransform(this.spotanim.seq.frames[this.seqFrame]);
			model.labelFaces = null;
			model.labelVertices = null;
		}

		if (this.spotanim.resizeh != 128 || this.spotanim.resizev != 128) {
			model.scale(this.spotanim.resizeh, this.spotanim.resizev, this.spotanim.resizeh);
		}

		model.rotateX(this.pitch);
		model.calculateNormals(64 + this.spotanim.ambient, 850 + this.spotanim.contrast, -30, -50, -30, true);
		return model;
	}
}
