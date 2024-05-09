package jagex2.config;

import jagex2.graphics.Model;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name taken from rs3
@OriginalClass("client!gc")
public class IdkType {

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
				@Pc(26) int count = dat.g1();
				this.models = new int[count];

				for (@Pc(32) int i = 0; i < count; i++) {
					this.models[i] = dat.g2();
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

		@Pc(11) Model[] models = new Model[this.models.length];
		for (@Pc(13) int i = 0; i < this.models.length; i++) {
			models[i] = new Model(this.models[i]);
		}

		@Pc(40) Model model;
		if (models.length == 1) {
			model = models[0];
		} else {
			model = new Model(models, models.length);
		}

		for (@Pc(52) int i = 0; i < 6 && this.recol_s[i] != 0; i++) {
			model.recolor(this.recol_s[i], this.recol_d[i]);
		}

		return model;
	}

	@OriginalMember(owner = "client!gc", name = "a", descriptor = "(Z)Lclient!eb;")
	public Model getHeadModel() {
		@Pc(4) Model[] models = new Model[5];

		@Pc(6) int count = 0;
		for (@Pc(8) int i = 0; i < 5; i++) {
			if (this.heads[i] != -1) {
				models[count++] = new Model(this.heads[i]);
			}
		}

		@Pc(39) Model model = new Model(models, count);
		for (@Pc(41) int i = 0; i < 6 && this.recol_s[i] != 0; i++) {
			model.recolor(this.recol_s[i], this.recol_d[i]);
		}

		return model;
	}
}
