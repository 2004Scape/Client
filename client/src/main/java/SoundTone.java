import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!zb")
public final class SoundTone {

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "I")
	public static final int flowObfuscator1 = 8;

	@OriginalMember(owner = "client!zb", name = "b", descriptor = "I")
	private final int flowObfuscator2 = -15143;

	@OriginalMember(owner = "client!zb", name = "c", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_1;

	@OriginalMember(owner = "client!zb", name = "d", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_2;

	@OriginalMember(owner = "client!zb", name = "e", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_3;

	@OriginalMember(owner = "client!zb", name = "f", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_4;

	@OriginalMember(owner = "client!zb", name = "g", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_5;

	@OriginalMember(owner = "client!zb", name = "h", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_6;

	@OriginalMember(owner = "client!zb", name = "i", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_7;

	@OriginalMember(owner = "client!zb", name = "j", descriptor = "Lclient!xb;")
	private SoundEnvelope aClass42_8;

	@OriginalMember(owner = "client!zb", name = "k", descriptor = "[I")
	private final int[] anIntArray236 = new int[5];

	@OriginalMember(owner = "client!zb", name = "l", descriptor = "[I")
	private final int[] anIntArray237 = new int[5];

	@OriginalMember(owner = "client!zb", name = "m", descriptor = "[I")
	private final int[] anIntArray238 = new int[5];

	@OriginalMember(owner = "client!zb", name = "n", descriptor = "I")
	private int anInt945;

	@OriginalMember(owner = "client!zb", name = "o", descriptor = "I")
	private int anInt946 = 100;

	@OriginalMember(owner = "client!zb", name = "p", descriptor = "I")
	public int anInt947 = 500;

	@OriginalMember(owner = "client!zb", name = "q", descriptor = "I")
	public int anInt948;

	@OriginalMember(owner = "client!zb", name = "r", descriptor = "[I")
	public static int[] anIntArray239;

	@OriginalMember(owner = "client!zb", name = "s", descriptor = "[I")
	public static int[] anIntArray240;

	@OriginalMember(owner = "client!zb", name = "t", descriptor = "[I")
	public static int[] anIntArray241;

	@OriginalMember(owner = "client!zb", name = "u", descriptor = "[I")
	public static final int[] anIntArray242 = new int[5];

	@OriginalMember(owner = "client!zb", name = "v", descriptor = "[I")
	public static final int[] anIntArray243 = new int[5];

	@OriginalMember(owner = "client!zb", name = "w", descriptor = "[I")
	public static final int[] anIntArray244 = new int[5];

	@OriginalMember(owner = "client!zb", name = "x", descriptor = "[I")
	public static final int[] anIntArray245 = new int[5];

	@OriginalMember(owner = "client!zb", name = "y", descriptor = "[I")
	public static final int[] anIntArray246 = new int[5];

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "()V")
	public static void method575() {
		anIntArray240 = new int[32768];
		for (@Pc(6) int local6 = 0; local6 < 32768; local6++) {
			if (Math.random() > 0.5D) {
				anIntArray240[local6] = 1;
			} else {
				anIntArray240[local6] = -1;
			}
		}
		anIntArray241 = new int[32768];
		for (@Pc(31) int local31 = 0; local31 < 32768; local31++) {
			anIntArray241[local31] = (int) (Math.sin((double) local31 / 5215.1903D) * 16384.0D);
		}
		anIntArray239 = new int[220500];
	}

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "(II)[I")
	public int[] method576(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		for (@Pc(3) int local3 = 0; local3 < arg0; local3++) {
			anIntArray239[local3] = 0;
		}
		if (arg1 < 10) {
			return anIntArray239;
		}
		@Pc(26) double local26 = (double) arg0 / ((double) arg1 + 0.0D);
		this.aClass42_1.method553(flowObfuscator1);
		this.aClass42_2.method553(flowObfuscator1);
		@Pc(36) int local36 = 0;
		@Pc(38) int local38 = 0;
		@Pc(40) int local40 = 0;
		if (this.aClass42_3 != null) {
			this.aClass42_3.method553(flowObfuscator1);
			this.aClass42_4.method553(flowObfuscator1);
			local36 = (int) ((double) (this.aClass42_3.anInt820 - this.aClass42_3.anInt819) * 32.768D / local26);
			local38 = (int) ((double) this.aClass42_3.anInt819 * 32.768D / local26);
		}
		@Pc(77) int local77 = 0;
		@Pc(79) int local79 = 0;
		@Pc(81) int local81 = 0;
		if (this.aClass42_5 != null) {
			this.aClass42_5.method553(flowObfuscator1);
			this.aClass42_6.method553(flowObfuscator1);
			local77 = (int) ((double) (this.aClass42_5.anInt820 - this.aClass42_5.anInt819) * 32.768D / local26);
			local79 = (int) ((double) this.aClass42_5.anInt819 * 32.768D / local26);
		}
		for (@Pc(118) int local118 = 0; local118 < 5; local118++) {
			if (this.anIntArray236[local118] != 0) {
				anIntArray242[local118] = 0;
				anIntArray243[local118] = (int) ((double) this.anIntArray238[local118] * local26);
				anIntArray244[local118] = (this.anIntArray236[local118] << 14) / 100;
				anIntArray245[local118] = (int) ((double) (this.aClass42_1.anInt820 - this.aClass42_1.anInt819) * 32.768D * Math.pow(1.0057929410678534D, (double) this.anIntArray237[local118]) / local26);
				anIntArray246[local118] = (int) ((double) this.aClass42_1.anInt819 * 32.768D / local26);
			}
		}
		@Pc(201) int local201;
		@Pc(207) int local207;
		@Pc(222) int local222;
		for (@Pc(193) int local193 = 0; local193 < arg0; local193++) {
			local201 = this.aClass42_1.method554(true, arg0);
			local207 = this.aClass42_2.method554(true, arg0);
			@Pc(216) int local216;
			if (this.aClass42_3 != null) {
				local216 = this.aClass42_3.method554(true, arg0);
				local222 = this.aClass42_4.method554(true, arg0);
				local201 += this.method577(-15143, local222, local40, this.aClass42_3.anInt821) >> 1;
				local40 += (local216 * local36 >> 16) + local38;
			}
			if (this.aClass42_5 != null) {
				local216 = this.aClass42_5.method554(true, arg0);
				local222 = this.aClass42_6.method554(true, arg0);
				local207 = local207 * ((this.method577(-15143, local222, local81, this.aClass42_5.anInt821) >> 1) + 32768) >> 15;
				local81 += (local216 * local77 >> 16) + local79;
			}
			for (local216 = 0; local216 < 5; local216++) {
				if (this.anIntArray236[local216] != 0) {
					local222 = local193 + anIntArray243[local216];
					if (local222 < arg0) {
						anIntArray239[local222] += this.method577(-15143, local207 * anIntArray244[local216] >> 15, anIntArray242[local216], this.aClass42_1.anInt821);
						anIntArray242[local216] += (local201 * anIntArray245[local216] >> 16) + anIntArray246[local216];
					}
				}
			}
		}
		if (this.aClass42_7 != null) {
			this.aClass42_7.method553(flowObfuscator1);
			this.aClass42_8.method553(flowObfuscator1);
			local201 = 0;
			@Pc(367) boolean local367 = false;
			@Pc(369) boolean local369 = true;
			for (local222 = 0; local222 < arg0; local222++) {
				@Pc(379) int local379 = this.aClass42_7.method554(true, arg0);
				@Pc(385) int local385 = this.aClass42_8.method554(true, arg0);
				if (local369) {
					local207 = this.aClass42_7.anInt819 + ((this.aClass42_7.anInt820 - this.aClass42_7.anInt819) * local379 >> 8);
				} else {
					local207 = this.aClass42_7.anInt819 + ((this.aClass42_7.anInt820 - this.aClass42_7.anInt819) * local385 >> 8);
				}
				local201 += 256;
				if (local201 >= local207) {
					local201 = 0;
					local369 = !local369;
				}
				if (local369) {
					anIntArray239[local222] = 0;
				}
			}
		}
		if (this.anInt945 > 0 && this.anInt946 > 0) {
			local201 = (int) ((double) this.anInt945 * local26);
			for (local207 = local201; local207 < arg0; local207++) {
				anIntArray239[local207] += anIntArray239[local207 - local201] * this.anInt946 / 100;
			}
		}
		for (local201 = 0; local201 < arg0; local201++) {
			if (anIntArray239[local201] < -32768) {
				anIntArray239[local201] = -32768;
			}
			if (anIntArray239[local201] > 32767) {
				anIntArray239[local201] = 32767;
			}
		}
		return anIntArray239;
	}

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "(IIII)I")
	private int method577(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg0 != this.flowObfuscator2) {
				return 2;
			} else if (arg3 == 1) {
				return (arg2 & 0x7FFF) < 16384 ? arg1 : -arg1;
			} else if (arg3 == 2) {
				return anIntArray241[arg2 & 0x7FFF] * arg1 >> 14;
			} else if (arg3 == 3) {
				return ((arg2 & 0x7FFF) * arg1 >> 14) - arg1;
			} else if (arg3 == 4) {
				return anIntArray240[arg2 / 2607 & 0x7FFF] * arg1;
			} else {
				return 0;
			}
		} catch (@Pc(60) RuntimeException local60) {
			signlink.reporterror("41611, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local60.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "(ZLclient!kb;)V")
	public void method578(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			this.aClass42_1 = new SoundEnvelope();
			this.aClass42_1.method552(false, arg1);
			this.aClass42_2 = new SoundEnvelope();
			this.aClass42_2.method552(false, arg1);
			@Pc(24) int local24 = arg1.method391();
			if (arg0) {
				throw new NullPointerException();
			}
			if (local24 != 0) {
				arg1.position--;
				this.aClass42_3 = new SoundEnvelope();
				this.aClass42_3.method552(false, arg1);
				this.aClass42_4 = new SoundEnvelope();
				this.aClass42_4.method552(false, arg1);
			}
			local24 = arg1.method391();
			if (local24 != 0) {
				arg1.position--;
				this.aClass42_5 = new SoundEnvelope();
				this.aClass42_5.method552(false, arg1);
				this.aClass42_6 = new SoundEnvelope();
				this.aClass42_6.method552(false, arg1);
			}
			local24 = arg1.method391();
			if (local24 != 0) {
				arg1.position--;
				this.aClass42_7 = new SoundEnvelope();
				this.aClass42_7.method552(false, arg1);
				this.aClass42_8 = new SoundEnvelope();
				this.aClass42_8.method552(false, arg1);
			}
			for (@Pc(122) int local122 = 0; local122 < 10; local122++) {
				@Pc(132) int local132 = arg1.method405();
				if (local132 == 0) {
					break;
				}
				this.anIntArray236[local122] = local132;
				this.anIntArray237[local122] = arg1.method404();
				this.anIntArray238[local122] = arg1.method405();
			}
			this.anInt945 = arg1.method405();
			this.anInt946 = arg1.method405();
			this.anInt947 = arg1.method393();
			this.anInt948 = arg1.method393();
		} catch (@Pc(173) RuntimeException local173) {
			signlink.reporterror("36876, " + arg0 + ", " + arg1 + ", " + local173.toString());
			throw new RuntimeException();
		}
	}
}
