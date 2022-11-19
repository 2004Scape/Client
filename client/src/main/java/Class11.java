import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!fc")
public final class Class11 {

	@OriginalMember(owner = "client!fc", name = "e", descriptor = "I")
	public int anInt403;

	@OriginalMember(owner = "client!fc", name = "i", descriptor = "Ljava/lang/String;")
	public String aString19;

	@OriginalMember(owner = "client!fc", name = "j", descriptor = "I")
	public int anInt405;

	@OriginalMember(owner = "client!fc", name = "k", descriptor = "I")
	public int anInt406;

	@OriginalMember(owner = "client!fc", name = "l", descriptor = "I")
	public int anInt407;

	@OriginalMember(owner = "client!fc", name = "m", descriptor = "I")
	public int anInt408;

	@OriginalMember(owner = "client!fc", name = "n", descriptor = "I")
	public int anInt409;

	@OriginalMember(owner = "client!fc", name = "o", descriptor = "I")
	public int anInt410;

	@OriginalMember(owner = "client!fc", name = "f", descriptor = "I")
	public int anInt404 = -1;

	@OriginalMember(owner = "client!fc", name = "g", descriptor = "Z")
	private boolean aBoolean90 = false;

	@OriginalMember(owner = "client!fc", name = "h", descriptor = "Z")
	public boolean aBoolean91 = true;

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method273(@OriginalArg(0) boolean arg0, @OriginalArg(1) Class1_Sub3_Sub3 arg1) {
		try {
			if (arg0) {
				throw new NullPointerException();
			}
			while (true) {
				@Pc(10) int local10 = arg1.method391();
				if (local10 == 0) {
					return;
				}
				if (local10 == 1) {
					this.anInt403 = arg1.method395();
					this.method274(Static13.anInt401, this.anInt403);
				} else if (local10 == 2) {
					this.anInt404 = arg1.method391();
				} else if (local10 == 3) {
					this.aBoolean90 = true;
				} else if (local10 == 5) {
					this.aBoolean91 = false;
				} else if (local10 == 6) {
					this.aString19 = arg1.method398();
				} else {
					System.out.println("Error unrecognised config code: " + local10);
				}
			}
		} catch (@Pc(72) RuntimeException local72) {
			signlink.reporterror("91653, " + arg0 + ", " + arg1 + ", " + local72.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(II)V")
	private void method274(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(10) double local10 = (double) (arg1 >> 16 & 0xFF) / 256.0D;
			if (arg0 >= 0) {
				for (@Pc(14) int local14 = 1; local14 > 0; local14++) {
				}
			}
			@Pc(28) double local28 = (double) (arg1 >> 8 & 0xFF) / 256.0D;
			@Pc(35) double local35 = (double) (arg1 & 0xFF) / 256.0D;
			@Pc(37) double local37 = local10;
			if (local28 < local10) {
				local37 = local28;
			}
			if (local35 < local37) {
				local37 = local35;
			}
			@Pc(51) double local51 = local10;
			if (local28 > local10) {
				local51 = local28;
			}
			if (local35 > local51) {
				local51 = local35;
			}
			@Pc(65) double local65 = 0.0D;
			@Pc(67) double local67 = 0.0D;
			@Pc(73) double local73 = (local37 + local51) / 2.0D;
			if (local37 != local51) {
				if (local73 < 0.5D) {
					local67 = (local51 - local37) / (local51 + local37);
				}
				if (local73 >= 0.5D) {
					local67 = (local51 - local37) / (2.0D - local51 - local37);
				}
				if (local10 == local51) {
					local65 = (local28 - local35) / (local51 - local37);
				} else if (local28 == local51) {
					local65 = (local35 - local10) / (local51 - local37) + 2.0D;
				} else if (local35 == local51) {
					local65 = (local10 - local28) / (local51 - local37) + 4.0D;
				}
			}
			local65 /= 6.0D;
			this.anInt405 = (int) (local65 * 256.0D);
			this.anInt406 = (int) (local67 * 256.0D);
			this.anInt407 = (int) (local73 * 256.0D);
			if (this.anInt406 < 0) {
				this.anInt406 = 0;
			} else if (this.anInt406 > 255) {
				this.anInt406 = 255;
			}
			if (this.anInt407 < 0) {
				this.anInt407 = 0;
			} else if (this.anInt407 > 255) {
				this.anInt407 = 255;
			}
			if (local73 > 0.5D) {
				this.anInt409 = (int) ((1.0D - local73) * local67 * 512.0D);
			} else {
				this.anInt409 = (int) (local73 * local67 * 512.0D);
			}
			if (this.anInt409 < 1) {
				this.anInt409 = 1;
			}
			this.anInt408 = (int) (local65 * (double) this.anInt409);
			@Pc(248) int local248 = this.anInt405 + (int) (Math.random() * 16.0D) - 8;
			if (local248 < 0) {
				local248 = 0;
			} else if (local248 > 255) {
				local248 = 255;
			}
			@Pc(269) int local269 = this.anInt406 + (int) (Math.random() * 48.0D) - 24;
			if (local269 < 0) {
				local269 = 0;
			} else if (local269 > 255) {
				local269 = 255;
			}
			@Pc(290) int local290 = this.anInt407 + (int) (Math.random() * 48.0D) - 24;
			if (local290 < 0) {
				local290 = 0;
			} else if (local290 > 255) {
				local290 = 255;
			}
			this.anInt410 = this.method275(local248, local269, local290);
		} catch (@Pc(310) RuntimeException local310) {
			signlink.reporterror("14446, " + arg0 + ", " + arg1 + ", " + local310.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!fc", name = "a", descriptor = "(III)I")
	private int method275(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		if (arg2 > 179) {
			arg1 /= 2;
		}
		if (arg2 > 192) {
			arg1 /= 2;
		}
		if (arg2 > 217) {
			arg1 /= 2;
		}
		if (arg2 > 243) {
			arg1 /= 2;
		}
		return (arg0 / 4 << 10) + (arg1 / 32 << 7) + arg2 / 2;
	}
}
