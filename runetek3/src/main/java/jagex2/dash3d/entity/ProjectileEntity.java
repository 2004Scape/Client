package jagex2.dash3d.entity;

import jagex2.config.SpotAnimType;
import jagex2.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ab")
public final class ProjectileEntity extends Entity {

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
	public ProjectileEntity(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7, @OriginalArg(9) int arg9, @OriginalArg(10) int arg10, @OriginalArg(11) int arg11) {
		this.spotanim = SpotAnimType.instances[arg10];
		this.level = arg4;
		this.srcX = arg11;
		this.srcZ = arg2;
		this.srcY = arg9;
		this.startCycle = arg6;
		this.lastCycle = arg3;
		this.peakPitch = arg1;
		this.arc = arg7;
		this.target = arg5;
		this.offsetY = arg0;
		this.mobile = false;
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(IIIII)V")
	public void updateVelocity(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(4) int arg4) {
		@Pc(8) double local8;
		if (!this.mobile) {
			local8 = arg2 - this.srcX;
			@Pc(14) double local14 = (double) (arg1 - this.srcZ);
			@Pc(23) double local23 = Math.sqrt(local8 * local8 + local14 * local14);
			this.x = (double) this.srcX + local8 * (double) this.arc / local23;
			this.z = (double) this.srcZ + local14 * (double) this.arc / local23;
			this.y = this.srcY;
		}
		local8 = this.lastCycle + 1 - arg4;
		this.velocityX = ((double) arg2 - this.x) / local8;
		this.velocityZ = ((double) arg1 - this.z) / local8;
		this.velocity = Math.sqrt(this.velocityX * this.velocityX + this.velocityZ * this.velocityZ);
		if (!this.mobile) {
			this.velocityY = -this.velocity * Math.tan((double) this.peakPitch * 0.02454369D);
		}
		this.accelerationY = ((double) arg0 - this.y - this.velocityY * local8) * 2.0D / (local8 * local8);
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(BI)V")
	public void update(@OriginalArg(1) int arg1) {
		this.mobile = true;
		this.x += this.velocityX * (double) arg1;
		this.z += this.velocityZ * (double) arg1;
		this.y += this.velocityY * (double) arg1 + this.accelerationY * 0.5D * (double) arg1 * (double) arg1;
		this.velocityY += this.accelerationY * (double) arg1;
		this.yaw = (int) (Math.atan2(this.velocityX, this.velocityZ) * 325.949D) + 1024 & 0x7FF;
		this.pitch = (int) (Math.atan2(this.velocityY, this.velocity) * 325.949D) & 0x7FF;
		if (this.spotanim.seq != null) {
			this.seqCycle += arg1;
			while (this.seqCycle > this.spotanim.seq.frameDelay[this.seqFrame]) {
				this.seqCycle -= this.spotanim.seq.frameDelay[this.seqFrame] + 1;
				this.seqFrame++;
				if (this.seqFrame >= this.spotanim.seq.framecount) {
					this.seqFrame = 0;
				}
			}
		}
	}

	@OriginalMember(owner = "client!ab", name = "a", descriptor = "(Z)Lclient!eb;")
	@Override
	public Model draw(int loopCycle) {
		@Pc(3) Model local3 = this.spotanim.getModel();
		@Pc(19) Model local19 = new Model(local3, true, !this.spotanim.disposeAlpha, false);
		if (this.spotanim.seq != null) {
			local19.createLabelReferences();
			local19.applyTransform(this.spotanim.seq.primaryFrames[this.seqFrame]);
			local19.labelFaces = null;
			local19.labelVertices = null;
		}
		if (this.spotanim.resizeh != 128 || this.spotanim.resizev != 128) {
			local19.scale(this.spotanim.resizeh, this.spotanim.resizev, this.spotanim.resizeh);
		}
		local19.rotateX(this.pitch);
		local19.calculateNormals(this.spotanim.ambient + 64, this.spotanim.contrast + 850, -30, -50, -30, true);
		return local19;
	}
}
