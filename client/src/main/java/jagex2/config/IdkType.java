package jagex2.config;

import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gc")
public final class IdkType {

	@OriginalMember(owner = "client!gc", name = "d", descriptor = "I")
	public static int count;

	@OriginalMember(owner = "client!gc", name = "e", descriptor = "[Lclient!gc;")
	public static IdkType[] instances;

	@OriginalMember(owner = "client!gc", name = "f", descriptor = "I")
	public int type = -1;

	@OriginalMember(owner = "client!gc", name = "g", descriptor = "[I")
	private int[] models;

	@OriginalMember(owner = "client!gc", name = "h", descriptor = "[I")
	private final int[] recol_s = new int[6];

	@OriginalMember(owner = "client!gc", name = "i", descriptor = "[I")
	private final int[] recol_d = new int[6];

	@OriginalMember(owner = "client!gc", name = "j", descriptor = "[I")
	private final int[] heads = new int[] { -1, -1, -1, -1, -1 };

	@OriginalMember(owner = "client!gc", name = "k", descriptor = "Z")
	public boolean disable = false;

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "(Lclient!ub;I)V")
	public static void unpack(@OriginalArg(0) Jagfile config) {
		@Pc(9) Packet dat = new Packet(config.read("idk.dat", null));
		count = dat.g2();

		if (instances == null) {
			instances = new IdkType[count];
		}

		for (@Pc(19) int id = 0; id < count; id++) {
			if (instances[id] == null) {
				instances[id] = new IdkType();
			}

			instances[id].decode(dat);
		}
	}

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void decode(@OriginalArg(1) Packet dat) {
		while (true) {
			@Pc(8) int code = dat.g1();
			if (code == 0) {
				break;
			}

			if (code == 1) {
				this.type = dat.g1();
			} else if (code == 2) {
				@Pc(26) int local26 = dat.g1();
				this.models = new int[local26];

				for (@Pc(32) int local32 = 0; local32 < local26; local32++) {
					this.models[local32] = dat.g2();
				}
			} else if (code == 3) {
				this.disable = true;
			} else if (code >= 40 && code < 50) {
				this.recol_s[code - 40] = dat.g2();
			} else if (code >= 50 && code < 60) {
				this.recol_d[code - 50] = dat.g2();
			} else if (code >= 60 && code < 70) {
				this.heads[code - 60] = dat.g2();
			} else {
				System.out.println("Error unrecognised config code: " + code);
			}
		}
	}

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "()Lclient!eb;")
	public Model getModel() {
		if (this.models == null) {
			return null;
		}

		@Pc(11) Model[] local11 = new Model[this.models.length];
		for (@Pc(13) int local13 = 0; local13 < this.models.length; local13++) {
			local11[local13] = new Model(this.models[local13]);
		}

		@Pc(40) Model local40;
		if (local11.length == 1) {
			local40 = local11[0];
		} else {
			local40 = new Model(local11, local11.length);
		}

		for (@Pc(52) int local52 = 0; local52 < 6 && this.recol_s[local52] != 0; local52++) {
			local40.recolor(this.recol_s[local52], this.recol_d[local52]);
		}

		return local40;
	}

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "(Z)Lclient!eb;")
	public Model getHeadModel() {
		@Pc(4) Model[] local4 = new Model[5];
		@Pc(6) int local6 = 0;

		for (@Pc(8) int local8 = 0; local8 < 5; local8++) {
			if (this.heads[local8] != -1) {
				local4[local6++] = new Model(this.heads[local8]);
			}
		}

		@Pc(39) Model local39 = new Model(local4, local6);
		for (@Pc(41) int local41 = 0; local41 < 6 && this.recol_s[local41] != 0; local41++) {
			local39.recolor(this.recol_s[local41], this.recol_d[local41]);
		}

		return local39;
	}
}
