package jagex2.config;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!lc")
public final class VarpType {

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
	public static void unpack(@OriginalArg(0) Jagfile config) {
		@Pc(9) Packet dat = new Packet(config.read("varp.dat", null));
		opcode3Count = 0;
		count = dat.g2();
		if (instances == null) {
			instances = new VarpType[count];
		}
		if (opcode3 == null) {
			opcode3 = new int[count];
		}
		for (@Pc(30) int id = 0; id < count; id++) {
			if (instances[id] == null) {
				instances[id] = new VarpType();
			}
			instances[id].decode(id, dat);
		}
	}

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(IILclient!kb;)V")
	public void decode(@OriginalArg(1) int id, @OriginalArg(2) Packet dat) {
		while (true) {
			@Pc(8) int code = dat.g1();
			if (code == 0) {
				return;
			}

			if (code == 1) {
				this.opcode1 = dat.g1();
			} else if (code == 2) {
				this.opcode2 = dat.g1();
			} else if (code == 3) {
				this.hasOpcode3 = true;
				opcode3[opcode3Count++] = id;
			} else if (code == 4) {
				this.opcode4 = false;
			} else if (code == 5) {
				this.clientcode = dat.g2();
			} else if (code == 6) {
				this.opcode6 = true;
			} else if (code == 7) {
				this.opcode7 = dat.g4();
			} else if (code == 8) {
				this.opcode8 = true;
			} else if (code == 10) {
				this.opcode10 = dat.gstr();
			} else {
				System.out.println("Error unrecognised config code: " + code);
			}
		}
	}
}
