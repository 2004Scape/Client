package jagex2.config;

import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name derived from other types + varp.dat (rs3 has this as VarPlayerType)
@OriginalClass("client!lc")
public class VarpType {

	@OriginalMember(owner = "client!lc", name = "c", descriptor = "I")
	private static int count;

	@OriginalMember(owner = "client!lc", name = "d", descriptor = "[Lclient!lc;")
	public static VarpType[] instances;

	@OriginalMember(owner = "client!lc", name = "e", descriptor = "I")
	public static int code3Count;

	@OriginalMember(owner = "client!lc", name = "f", descriptor = "[I")
	public static int[] code3;

	@OriginalMember(owner = "client!lc", name = "g", descriptor = "Ljava/lang/String;")
	private String code10;

	@OriginalMember(owner = "client!lc", name = "h", descriptor = "I")
	private int code1;

	@OriginalMember(owner = "client!lc", name = "i", descriptor = "I")
	private int code2;

	@OriginalMember(owner = "client!lc", name = "j", descriptor = "Z")
	private boolean hasCode3 = false;

	@OriginalMember(owner = "client!lc", name = "k", descriptor = "Z")
	private boolean code4 = true;

	@OriginalMember(owner = "client!lc", name = "l", descriptor = "I")
	public int clientcode;

	@OriginalMember(owner = "client!lc", name = "n", descriptor = "I")
	private int code7;

	@OriginalMember(owner = "client!lc", name = "m", descriptor = "Z")
	private boolean code6 = false;

	@OriginalMember(owner = "client!lc", name = "o", descriptor = "Z")
	private boolean code8 = false;

	@OriginalMember(owner = "client!lc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void unpack(@OriginalArg(0) Jagfile config) {
		@Pc(9) Packet dat = new Packet(config.read("varp.dat", null));
		code3Count = 0;
		count = dat.g2();

		if (instances == null) {
			instances = new VarpType[count];
		}

		if (code3 == null) {
			code3 = new int[count];
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
				this.code1 = dat.g1();
			} else if (code == 2) {
				this.code2 = dat.g1();
			} else if (code == 3) {
				this.hasCode3 = true;
				VarpType.code3[VarpType.code3Count++] = id;
			} else if (code == 4) {
				this.code4 = false;
			} else if (code == 5) {
				this.clientcode = dat.g2();
			} else if (code == 6) {
				this.code6 = true;
			} else if (code == 7) {
				this.code7 = dat.g4();
			} else if (code == 8) {
				this.code8 = true;
			} else if (code == 10) {
				this.code10 = dat.gjstr();
			} else {
				System.out.println("Error unrecognised config code: " + code);
			}
		}
	}
}
