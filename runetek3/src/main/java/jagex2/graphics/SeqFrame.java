package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// Sequence Frame: Animation frame
@OriginalClass("client!g")
public final class SeqFrame {

	@OriginalMember(owner = "client!g", name = "a", descriptor = "[Lclient!g;")
	public static SeqFrame[] instances;

	@OriginalMember(owner = "client!g", name = "b", descriptor = "I")
	public int delay;

	@OriginalMember(owner = "client!g", name = "c", descriptor = "Lclient!f;")
	public SeqBase base;

	@OriginalMember(owner = "client!g", name = "d", descriptor = "I")
	public int length;

	@OriginalMember(owner = "client!g", name = "e", descriptor = "[I")
	public int[] bases;

	@OriginalMember(owner = "client!g", name = "f", descriptor = "[I")
	public int[] x;

	@OriginalMember(owner = "client!g", name = "g", descriptor = "[I")
	public int[] y;

	@OriginalMember(owner = "client!g", name = "h", descriptor = "[I")
	public int[] z;

	@OriginalMember(owner = "client!g", name = "a", descriptor = "(ZLclient!ub;)V")
	public static void unpack(@OriginalArg(1) Jagfile arg1) {
		@Pc(17) Packet local17 = new Packet(arg1.read("frame_head.dat", null));
		@Pc(27) Packet local27 = new Packet(arg1.read("frame_tran1.dat", null));
		@Pc(37) Packet local37 = new Packet(arg1.read("frame_tran2.dat", null));
		@Pc(47) Packet local47 = new Packet(arg1.read("frame_del.dat", null));
		@Pc(50) int local50 = local17.g2();
		@Pc(53) int local53 = local17.g2();
		instances = new SeqFrame[local53 + 1];
		@Pc(61) int[] local61 = new int[500];
		@Pc(64) int[] local64 = new int[500];
		@Pc(67) int[] local67 = new int[500];
		@Pc(70) int[] local70 = new int[500];
		for (@Pc(72) int local72 = 0; local72 < local50; local72++) {
			@Pc(77) int local77 = local17.g2();
			@Pc(85) SeqFrame local85 = instances[local77] = new SeqFrame();
			local85.delay = local47.g1();
			@Pc(92) int local92 = local17.g2();
			@Pc(96) SeqBase local96 = SeqBase.instances[local92];
			local85.base = local96;
			@Pc(102) int local102 = local17.g1();
			@Pc(104) int local104 = -1;
			@Pc(106) int local106 = 0;
			@Pc(113) int local113;
			for (@Pc(108) int local108 = 0; local108 < local102; local108++) {
				local113 = local27.g1();
				if (local113 > 0) {
					if (local96.types[local108] != 0) {
						for (@Pc(124) int local124 = local108 - 1; local124 > local104; local124--) {
							if (local96.types[local124] == 0) {
								local61[local106] = local124;
								local64[local106] = 0;
								local67[local106] = 0;
								local70[local106] = 0;
								local106++;
								break;
							}
						}
					}
					local61[local106] = local108;
					@Pc(160) short local160 = 0;
					if (local96.types[local61[local106]] == 3) {
						local160 = 128;
					}
					if ((local113 & 0x1) == 0) {
						local64[local106] = local160;
					} else {
						local64[local106] = local37.gsmart();
					}
					if ((local113 & 0x2) == 0) {
						local67[local106] = local160;
					} else {
						local67[local106] = local37.gsmart();
					}
					if ((local113 & 0x4) == 0) {
						local70[local106] = local160;
					} else {
						local70[local106] = local37.gsmart();
					}
					local104 = local108;
					local106++;
				}
			}
			local85.length = local106;
			local85.bases = new int[local106];
			local85.x = new int[local106];
			local85.y = new int[local106];
			local85.z = new int[local106];
			for (local113 = 0; local113 < local106; local113++) {
				local85.bases[local113] = local61[local113];
				local85.x[local113] = local64[local113];
				local85.y[local113] = local67[local113];
				local85.z[local113] = local70[local113];
			}
		}
	}

}
