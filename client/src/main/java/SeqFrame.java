import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!g")
public final class SeqFrame {

	@OriginalMember(owner = "client!g", name = "a", descriptor = "[Lclient!g;")
	public static SeqFrame[] aClass12Array1;

	@OriginalMember(owner = "client!g", name = "b", descriptor = "I")
	public int anInt411;

	@OriginalMember(owner = "client!g", name = "c", descriptor = "Lclient!f;")
	public SeqBase aClass10_1;

	@OriginalMember(owner = "client!g", name = "d", descriptor = "I")
	public int anInt412;

	@OriginalMember(owner = "client!g", name = "e", descriptor = "[I")
	public int[] anIntArray130;

	@OriginalMember(owner = "client!g", name = "f", descriptor = "[I")
	public int[] anIntArray131;

	@OriginalMember(owner = "client!g", name = "g", descriptor = "[I")
	public int[] anIntArray132;

	@OriginalMember(owner = "client!g", name = "h", descriptor = "[I")
	public int[] anIntArray133;

	@OriginalMember(owner = "client!g", name = "a", descriptor = "(ZLclient!ub;)V")
	public static void method276(@OriginalArg(0) boolean arg0, @OriginalArg(1) FileArchive arg1) {
		try {
			if (arg0) {
				throw new NullPointerException();
			}
			@Pc(17) Buffer local17 = new Buffer(363, arg1.method536("frame_head.dat", null, (byte) 2));
			@Pc(27) Buffer local27 = new Buffer(363, arg1.method536("frame_tran1.dat", null, (byte) 2));
			@Pc(37) Buffer local37 = new Buffer(363, arg1.method536("frame_tran2.dat", null, (byte) 2));
			@Pc(47) Buffer local47 = new Buffer(363, arg1.method536("frame_del.dat", null, (byte) 2));
			@Pc(50) int local50 = local17.method393();
			@Pc(53) int local53 = local17.method393();
			aClass12Array1 = new SeqFrame[local53 + 1];
			@Pc(61) int[] local61 = new int[500];
			@Pc(64) int[] local64 = new int[500];
			@Pc(67) int[] local67 = new int[500];
			@Pc(70) int[] local70 = new int[500];
			for (@Pc(72) int local72 = 0; local72 < local50; local72++) {
				@Pc(77) int local77 = local17.method393();
				@Pc(85) SeqFrame local85 = aClass12Array1[local77] = new SeqFrame();
				local85.anInt411 = local47.method391();
				@Pc(92) int local92 = local17.method393();
				@Pc(96) SeqBase local96 = SeqBase.aClass10Array1[local92];
				local85.aClass10_1 = local96;
				@Pc(102) int local102 = local17.method391();
				@Pc(104) int local104 = -1;
				@Pc(106) int local106 = 0;
				@Pc(113) int local113;
				for (@Pc(108) int local108 = 0; local108 < local102; local108++) {
					local113 = local27.method391();
					if (local113 > 0) {
						if (local96.anIntArray128[local108] != 0) {
							for (@Pc(124) int local124 = local108 - 1; local124 > local104; local124--) {
								if (local96.anIntArray128[local124] == 0) {
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
						if (local96.anIntArray128[local61[local106]] == 3) {
							local160 = 128;
						}
						if ((local113 & 0x1) == 0) {
							local64[local106] = local160;
						} else {
							local64[local106] = local37.method404();
						}
						if ((local113 & 0x2) == 0) {
							local67[local106] = local160;
						} else {
							local67[local106] = local37.method404();
						}
						if ((local113 & 0x4) == 0) {
							local70[local106] = local160;
						} else {
							local70[local106] = local37.method404();
						}
						local104 = local108;
						local106++;
					}
				}
				local85.anInt412 = local106;
				local85.anIntArray130 = new int[local106];
				local85.anIntArray131 = new int[local106];
				local85.anIntArray132 = new int[local106];
				local85.anIntArray133 = new int[local106];
				for (local113 = 0; local113 < local106; local113++) {
					local85.anIntArray130[local113] = local61[local113];
					local85.anIntArray131[local113] = local64[local113];
					local85.anIntArray132[local113] = local67[local113];
					local85.anIntArray133[local113] = local70[local113];
				}
			}
		} catch (@Pc(283) RuntimeException local283) {
			signlink.reporterror("10576, " + arg0 + ", " + arg1 + ", " + local283.toString());
			throw new RuntimeException();
		}
	}

}
