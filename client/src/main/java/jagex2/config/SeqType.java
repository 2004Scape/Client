package jagex2.config;

import jagex2.graphics.SeqFrame;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!jc")
public final class SeqType {

	@OriginalMember(owner = "client!jc", name = "c", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!jc", name = "d", descriptor = "[Lclient!jc;")
	public static SeqType[] instances;

	@OriginalMember(owner = "client!jc", name = "e", descriptor = "I")
	public int frameCount;

	@OriginalMember(owner = "client!jc", name = "f", descriptor = "[I")
	public int[] frames;

	@OriginalMember(owner = "client!jc", name = "g", descriptor = "[I")
	public int[] iframes;

	@OriginalMember(owner = "client!jc", name = "h", descriptor = "[I")
	public int[] delay;

	@OriginalMember(owner = "client!jc", name = "i", descriptor = "I")
	public int replayoff = -1;

	@OriginalMember(owner = "client!jc", name = "j", descriptor = "[I")
	public int[] labelGroups;

	@OriginalMember(owner = "client!jc", name = "k", descriptor = "Z")
	public boolean stretches = false;

	@OriginalMember(owner = "client!jc", name = "l", descriptor = "I")
	public int priority = 5;

	@OriginalMember(owner = "client!jc", name = "m", descriptor = "I")
	public int mainhand = -1;

	@OriginalMember(owner = "client!jc", name = "n", descriptor = "I")
	public int offhand = -1;

	@OriginalMember(owner = "client!jc", name = "o", descriptor = "I")
	public int replaycount = 99;

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void unpack(@OriginalArg(0) Jagfile config) {
		@Pc(9) Packet dat = new Packet(config.read("seq.dat", null));
		count = dat.g2();

		if (instances == null) {
			instances = new SeqType[count];
		}

		for (@Pc(27) int id = 0; id < count; id++) {
			if (instances[id] == null) {
				instances[id] = new SeqType();
			}

			instances[id].decode(dat);
		}
	}

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(5) int code = dat.g1();
			if (code == 0) {
				break;
			}

			@Pc(40) int local40;
			if (code == 1) {
				this.frameCount = dat.g1();
				this.frames = new int[this.frameCount];
				this.iframes = new int[this.frameCount];
				this.delay = new int[this.frameCount];

				for (local40 = 0; local40 < this.frameCount; local40++) {
					this.frames[local40] = dat.g2();

					this.iframes[local40] = dat.g2();
					if (this.iframes[local40] == 65535) {
						this.iframes[local40] = -1;
					}

					this.delay[local40] = dat.g2();
					if (this.delay[local40] == 0) {
						this.delay[local40] = SeqFrame.instances[this.frames[local40]].delay;
					}

					if (this.delay[local40] == 0) {
						this.delay[local40] = 1;
					}
				}
			} else if (code == 2) {
				this.replayoff = dat.g2();
			} else if (code == 3) {
				local40 = dat.g1();
				this.labelGroups = new int[local40 + 1];

				for (@Pc(127) int local127 = 0; local127 < local40; local127++) {
					this.labelGroups[local127] = dat.g1();
				}

				this.labelGroups[local40] = 9999999;
			} else if (code == 4) {
				this.stretches = true;
			} else if (code == 5) {
				this.priority = dat.g1();
			} else if (code == 6) {
				this.mainhand = dat.g2();
			} else if (code == 7) {
				this.offhand = dat.g2();
			} else if (code == 8) {
				this.replaycount = dat.g1();
			} else {
				System.out.println("Error unrecognised seq config code: " + code);
			}
		}

		if (this.frameCount == 0) {
			this.frameCount = 1;

			this.frames = new int[1];
			this.frames[0] = -1;

			this.iframes = new int[1];
			this.iframes[0] = -1;

			this.delay = new int[1];
			this.delay[0] = -1;
		}
	}
}
