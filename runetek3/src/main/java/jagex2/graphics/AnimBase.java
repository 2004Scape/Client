package jagex2.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import jagex2.io.Jagfile;
import jagex2.io.Packet;

// name taken from runetek5
@OriginalClass("client!f")
public class AnimBase {

	public static final int OP_BASE = 0;
	public static final int OP_TRANSLATE = 1;
	public static final int OP_ROTATE = 2;
	public static final int OP_SCALE = 3;
	public static final int OP_ALPHA = 5;

	@OriginalMember(owner = "client!f", name = "a", descriptor = "[Lclient!f;")
	public static AnimBase[] instances;

	@OriginalMember(owner = "client!f", name = "b", descriptor = "I")
	public int length;

	// an operation for a specific group - [group]
	@OriginalMember(owner = "client!f", name = "c", descriptor = "[I")
	public int[] types;

	// labels for a specific group - [group] [label]
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

			@Pc(61) int[] types = new int[length];
			@Pc(64) int[][] labels = new int[length][];

			for (@Pc(66) int g = 0; g < length; g++) {
				types[g] = type.g1();

				@Pc(76) int labelCount = label.g1();
				labels[g] = new int[labelCount];

				for (@Pc(83) int l = 0; l < labelCount; l++) {
					labels[g][l] = label.g1();
				}
			}

			instances[id] = new AnimBase();
			instances[id].length = length;
			instances[id].types = types;
			instances[id].labels = labels;
		}
	}
}
