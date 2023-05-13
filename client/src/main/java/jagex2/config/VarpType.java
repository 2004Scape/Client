package jagex2.config;

import jagex2.client.sign.signlink;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lc")
public final class VarpType {

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "I")
	private static final int flowObfuscator1 = 473;

	@OriginalMember(owner = "client!lc", name = "b", descriptor = "I")
	private static final int flowObfuscator2 = 13703;

	@OriginalMember(owner = "client!lc", name = "c", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!lc", name = "d", descriptor = "[Lclient!lc;")
	public static VarpType[] instances;

	@OriginalMember(owner = "client!lc", name = "e", descriptor = "I")
	public static int opcode3Count;

	@OriginalMember(owner = "client!lc", name = "f", descriptor = "[I")
	public static int[] opcode3;

	@OriginalMember(owner = "client!lc", name = "g", descriptor = "Ljava/lang/String;")
	private String opcode10;

	@OriginalMember(owner = "client!lc", name = "h", descriptor = "I")
	private int opcode1;

	@OriginalMember(owner = "client!lc", name = "i", descriptor = "I")
	private int opcode2;

	@OriginalMember(owner = "client!lc", name = "j", descriptor = "Z")
	private boolean hasOpcode3 = false;

	@OriginalMember(owner = "client!lc", name = "k", descriptor = "Z")
	private boolean opcode4 = true;

	@OriginalMember(owner = "client!lc", name = "l", descriptor = "I")
	public int clientcode;

	@OriginalMember(owner = "client!lc", name = "n", descriptor = "I")
	private int opcode7;

	@OriginalMember(owner = "client!lc", name = "m", descriptor = "Z")
	private boolean opcode6 = false;

	@OriginalMember(owner = "client!lc", name = "o", descriptor = "Z")
	private boolean opcode8 = false;

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void unpack(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(9) Packet local9 = new Packet(363, arg0.read("varp.dat", null, (byte) 2));
			opcode3Count = 0;
			@Pc(15) int local15 = 28 / arg1;
			count = local9.g2();
			if (instances == null) {
				instances = new VarpType[count];
			}
			if (opcode3 == null) {
				opcode3 = new int[count];
			}
			for (@Pc(30) int local30 = 0; local30 < count; local30++) {
				if (instances[local30] == null) {
					instances[local30] = new VarpType();
				}
				instances[local30].decode(flowObfuscator2, local30, local9);
			}
		} catch (@Pc(55) RuntimeException local55) {
			signlink.reporterror("45283, " + arg0 + ", " + arg1 + ", " + local55.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(IILclient!kb;)V")
	public void decode(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Packet buf) {
		try {
			if (arg0 == 13703) {
				while (true) {
					@Pc(8) int opcode = buf.g1();
					if (opcode == 0) {
						return;
					}
					if (opcode == 1) {
						this.opcode1 = buf.g1();
					} else if (opcode == 2) {
						this.opcode2 = buf.g1();
					} else if (opcode == 3) {
						this.hasOpcode3 = true;
						opcode3[opcode3Count++] = arg1;
					} else if (opcode == 4) {
						this.opcode4 = false;
					} else if (opcode == 5) {
						this.clientcode = buf.g2();
					} else if (opcode == 6) {
						this.opcode6 = true;
					} else if (opcode == 7) {
						this.opcode7 = buf.g4();
					} else if (opcode == 8) {
						this.opcode8 = true;
					} else if (opcode == 10) {
						this.opcode10 = buf.gstr();
					} else {
						System.out.println("Error unrecognised config code: " + opcode);
					}
				}
			}
		} catch (@Pc(107) RuntimeException local107) {
			signlink.reporterror("67426, " + arg0 + ", " + arg1 + ", " + buf + ", " + local107.toString());
			throw new RuntimeException();
		}
	}
}
