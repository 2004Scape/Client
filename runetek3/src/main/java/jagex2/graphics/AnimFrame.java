package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from runetek5
@OriginalClass("client!g")
public class AnimFrame {

	@OriginalMember(owner = "client!g", name = "a", descriptor = "[Lclient!g;")
	public static AnimFrame[] instances;

	@OriginalMember(owner = "client!g", name = "b", descriptor = "I")
	public int delay;

	@OriginalMember(owner = "client!g", name = "c", descriptor = "Lclient!f;")
	public AnimBase base;

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
	public static void unpack(@OriginalArg(1) Jagfile models) {
		@Pc(17) Packet head = new Packet(models.read("frame_head.dat", null));
		@Pc(27) Packet tran1 = new Packet(models.read("frame_tran1.dat", null));
		@Pc(37) Packet tran2 = new Packet(models.read("frame_tran2.dat", null));
		@Pc(47) Packet del = new Packet(models.read("frame_del.dat", null));

		@Pc(50) int total = head.g2();
		@Pc(53) int count = head.g2();
		instances = new AnimFrame[count + 1];

		@Pc(61) int[] labels = new int[500];
		@Pc(64) int[] x = new int[500];
		@Pc(67) int[] y = new int[500];
		@Pc(70) int[] z = new int[500];

		for (@Pc(72) int i = 0; i < total; i++) {
			@Pc(77) int id = head.g2();
			@Pc(85) AnimFrame frame = instances[id] = new AnimFrame();
			frame.delay = del.g1();

			@Pc(92) int baseId = head.g2();
			@Pc(96) AnimBase base = AnimBase.instances[baseId];
			frame.base = base;

			@Pc(102) int groupCount = head.g1();
			@Pc(104) int lastGroup = -1;
			@Pc(106) int current = 0;

			for (@Pc(108) int j = 0; j < groupCount; j++) {
				int flags = tran1.g1();

				if (flags > 0) {
					if (base.types[j] != 0) {
						for (@Pc(124) int group = j - 1; group > lastGroup; group--) {
							if (base.types[group] == 0) {
								labels[current] = group;
								x[current] = 0;
								y[current] = 0;
								z[current] = 0;
								current++;
								break;
							}
						}
					}

					labels[current] = j;

					@Pc(160) short defaultValue = 0;
					if (base.types[labels[current]] == 3) {
						defaultValue = 128;
					}

					if ((flags & 0x1) == 0) {
						x[current] = defaultValue;
					} else {
						x[current] = tran2.gsmart();
					}

					if ((flags & 0x2) == 0) {
						y[current] = defaultValue;
					} else {
						y[current] = tran2.gsmart();
					}

					if ((flags & 0x4) == 0) {
						z[current] = defaultValue;
					} else {
						z[current] = tran2.gsmart();
					}

					lastGroup = j;
					current++;
				}
			}

			frame.length = current;
			frame.bases = new int[current];
			frame.x = new int[current];
			frame.y = new int[current];
			frame.z = new int[current];

			for (int j = 0; j < current; j++) {
				frame.bases[j] = labels[j];
				frame.x[j] = x[j];
				frame.y[j] = y[j];
				frame.z[j] = z[j];
			}
		}
	}

}
