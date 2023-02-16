package com.jagex.game.runetek3.config;

import com.jagex.core.io.Buffer;
import com.jagex.core.io.FileArchive;
import com.jagex.game.runetek3.graphics.SeqFrame;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

@OriginalClass("client!jc")
public final class SeqType {

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "Z")
	private static boolean flowObfuscator1 = true;

	@OriginalMember(owner = "client!jc", name = "b", descriptor = "I")
	private static final int flowObfuscator2 = 473;

	@OriginalMember(owner = "client!jc", name = "c", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!jc", name = "d", descriptor = "[Lclient!jc;")
	public static SeqType[] instances;

	@OriginalMember(owner = "client!jc", name = "e", descriptor = "I")
	public int framecount;

	@OriginalMember(owner = "client!jc", name = "f", descriptor = "[I")
	public int[] primaryFrames;

	@OriginalMember(owner = "client!jc", name = "g", descriptor = "[I")
	public int[] secondaryFrames;

	@OriginalMember(owner = "client!jc", name = "h", descriptor = "[I")
	public int[] frameDelay;

	@OriginalMember(owner = "client!jc", name = "i", descriptor = "I")
	public int replayoff = -1;

	@OriginalMember(owner = "client!jc", name = "j", descriptor = "[I")
	public int[] mask;

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
	public static void unpack(@OriginalArg(0) FileArchive arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(9) Buffer local9 = new Buffer(363, arg0.read("seq.dat", null, (byte) 2));
			if (arg1 <= 0) {
				flowObfuscator1 = !flowObfuscator1;
			}
			count = local9.g2();
			if (instances == null) {
				instances = new SeqType[count];
			}
			for (@Pc(27) int local27 = 0; local27 < count; local27++) {
				if (instances[local27] == null) {
					instances[local27] = new SeqType();
				}
				instances[local27].decode(false, local9);
			}
		} catch (@Pc(51) RuntimeException local51) {
			Signlink.reporterror("35892, " + arg0 + ", " + arg1 + ", " + local51.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!jc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			@Pc(5) int local5;
			if (arg0) {
				for (local5 = 1; local5 > 0; local5++) {
				}
			}
			while (true) {
				while (true) {
					local5 = arg1.g1();
					if (local5 == 0) {
						if (this.framecount == 0) {
							this.framecount = 1;
							this.primaryFrames = new int[1];
							this.primaryFrames[0] = -1;
							this.secondaryFrames = new int[1];
							this.secondaryFrames[0] = -1;
							this.frameDelay = new int[1];
							this.frameDelay[0] = -1;
							return;
						}
						return;
					}
					@Pc(40) int local40;
					if (local5 == 1) {
						this.framecount = arg1.g1();
						this.primaryFrames = new int[this.framecount];
						this.secondaryFrames = new int[this.framecount];
						this.frameDelay = new int[this.framecount];
						for (local40 = 0; local40 < this.framecount; local40++) {
							this.primaryFrames[local40] = arg1.g2();
							this.secondaryFrames[local40] = arg1.g2();
							if (this.secondaryFrames[local40] == 65535) {
								this.secondaryFrames[local40] = -1;
							}
							this.frameDelay[local40] = arg1.g2();
							if (this.frameDelay[local40] == 0) {
								this.frameDelay[local40] = SeqFrame.instances[this.primaryFrames[local40]].delay;
							}
							if (this.frameDelay[local40] == 0) {
								this.frameDelay[local40] = 1;
							}
						}
					} else if (local5 == 2) {
						this.replayoff = arg1.g2();
					} else if (local5 == 3) {
						local40 = arg1.g1();
						this.mask = new int[local40 + 1];
						for (@Pc(127) int local127 = 0; local127 < local40; local127++) {
							this.mask[local127] = arg1.g1();
						}
						this.mask[local40] = 9999999;
					} else if (local5 == 4) {
						this.stretches = true;
					} else if (local5 == 5) {
						this.priority = arg1.g1();
					} else if (local5 == 6) {
						this.mainhand = arg1.g2();
					} else if (local5 == 7) {
						this.offhand = arg1.g2();
					} else if (local5 == 8) {
						this.replaycount = arg1.g1();
					} else {
						System.out.println("Error unrecognised seq config code: " + local5);
					}
				}
			}
		} catch (@Pc(236) RuntimeException local236) {
			Signlink.reporterror("38080, " + arg0 + ", " + arg1 + ", " + local236.toString());
			throw new RuntimeException();
		}
	}
}
