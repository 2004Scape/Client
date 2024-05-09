package jagex2.graphics;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from runetek5
@OriginalClass("client!f")
public class AnimBase {

	@OriginalMember(owner = "client!f", name = "a", descriptor = "[Lclient!f;")
	public static AnimBase[] instances;

	@OriginalMember(owner = "client!f", name = "b", descriptor = "I")
	public int length;

	@OriginalMember(owner = "client!f", name = "c", descriptor = "[I")
	public int[] types;

	@OriginalMember(owner = "client!f", name = "d", descriptor = "[[I")
	public int[][] labels;

	@OriginalMember(owner = "client!f", name = "a", descriptor = "(ZLclient!ub;)V")
	public static void unpack(@OriginalArg(1) Jagfile models) {
		@Pc(11) Packet head = new Packet(models.read("base_head.dat", null));
		@Pc(21) Packet type = new Packet(models.read("base_type.dat", null));
		@Pc(31) Packet label = new Packet(models.read("base_label.dat", null));

		@Pc(34) int total = head.g2();
		@Pc(37) int count = head.g2();
		instances = new AnimBase[count + 1];

		for (@Pc(50) int i = 0; i < total; i++) {
			@Pc(55) int id = head.g2();
			@Pc(58) int length = head.g1();

			@Pc(61) int[] transformTypes = new int[length];
			@Pc(64) int[][] groupLabels = new int[length][];

			for (@Pc(66) int j = 0; j < length; j++) {
				transformTypes[j] = type.g1();

				@Pc(76) int groupCount = label.g1();
				groupLabels[j] = new int[groupCount];

				for (@Pc(83) int k = 0; k < groupCount; k++) {
					groupLabels[j][k] = label.g1();
				}
			}

			instances[id] = new AnimBase();
			instances[id].length = length;
			instances[id].types = transformTypes;
			instances[id].labels = groupLabels;
		}
	}
}
