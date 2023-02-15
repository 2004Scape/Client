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
	private SoundEnvelope frequencyBase;

	@OriginalMember(owner = "client!zb", name = "d", descriptor = "Lclient!xb;")
	private SoundEnvelope amplitudeBase;

	@OriginalMember(owner = "client!zb", name = "e", descriptor = "Lclient!xb;")
	private SoundEnvelope frequencyModRate;

	@OriginalMember(owner = "client!zb", name = "f", descriptor = "Lclient!xb;")
	private SoundEnvelope frequencyModRange;

	@OriginalMember(owner = "client!zb", name = "g", descriptor = "Lclient!xb;")
	private SoundEnvelope amplitudeModRate;

	@OriginalMember(owner = "client!zb", name = "h", descriptor = "Lclient!xb;")
	private SoundEnvelope amplitudeModRange;

	@OriginalMember(owner = "client!zb", name = "i", descriptor = "Lclient!xb;")
	private SoundEnvelope release;

	@OriginalMember(owner = "client!zb", name = "j", descriptor = "Lclient!xb;")
	private SoundEnvelope attack;

	@OriginalMember(owner = "client!zb", name = "k", descriptor = "[I")
	private final int[] harmonicVolume = new int[5];

	@OriginalMember(owner = "client!zb", name = "l", descriptor = "[I")
	private final int[] harmonicSemitone = new int[5];

	@OriginalMember(owner = "client!zb", name = "m", descriptor = "[I")
	private final int[] harmonicDelay = new int[5];

	@OriginalMember(owner = "client!zb", name = "n", descriptor = "I")
	private int reverbDelay;

	@OriginalMember(owner = "client!zb", name = "o", descriptor = "I")
	private int reverbVolume = 100;

	@OriginalMember(owner = "client!zb", name = "p", descriptor = "I")
	public int length = 500;

	@OriginalMember(owner = "client!zb", name = "q", descriptor = "I")
	public int start;

	@OriginalMember(owner = "client!zb", name = "r", descriptor = "[I")
	public static int[] buffer;

	@OriginalMember(owner = "client!zb", name = "s", descriptor = "[I")
	public static int[] noise;

	@OriginalMember(owner = "client!zb", name = "t", descriptor = "[I")
	public static int[] sin;

	@OriginalMember(owner = "client!zb", name = "u", descriptor = "[I")
	public static final int[] tmpPhases = new int[5];

	@OriginalMember(owner = "client!zb", name = "v", descriptor = "[I")
	public static final int[] tmpDelays = new int[5];

	@OriginalMember(owner = "client!zb", name = "w", descriptor = "[I")
	public static final int[] tmpVolumes = new int[5];

	@OriginalMember(owner = "client!zb", name = "x", descriptor = "[I")
	public static final int[] tmpSemitones = new int[5];

	@OriginalMember(owner = "client!zb", name = "y", descriptor = "[I")
	public static final int[] tmpStarts = new int[5];

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "()V")
	public static void init() {
		noise = new int[32768];
		for (@Pc(6) int local6 = 0; local6 < 32768; local6++) {
			if (Math.random() > 0.5D) {
				noise[local6] = 1;
			} else {
				noise[local6] = -1;
			}
		}
		sin = new int[32768];
		for (@Pc(31) int local31 = 0; local31 < 32768; local31++) {
			sin[local31] = (int) (Math.sin((double) local31 / 5215.1903D) * 16384.0D);
		}
		buffer = new int[220500]; // 10s * 22050 KHz
	}

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "(II)[I")
	public int[] generate(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		for (@Pc(3) int local3 = 0; local3 < arg0; local3++) {
			buffer[local3] = 0;
		}
		if (arg1 < 10) {
			return buffer;
		}
		@Pc(26) double local26 = (double) arg0 / ((double) arg1 + 0.0D);
		this.frequencyBase.reset(flowObfuscator1);
		this.amplitudeBase.reset(flowObfuscator1);
		@Pc(36) int local36 = 0;
		@Pc(38) int local38 = 0;
		@Pc(40) int local40 = 0;
		if (this.frequencyModRate != null) {
			this.frequencyModRate.reset(flowObfuscator1);
			this.frequencyModRange.reset(flowObfuscator1);
			local36 = (int) ((double) (this.frequencyModRate.end - this.frequencyModRate.start) * 32.768D / local26);
			local38 = (int) ((double) this.frequencyModRate.start * 32.768D / local26);
		}
		@Pc(77) int local77 = 0;
		@Pc(79) int local79 = 0;
		@Pc(81) int local81 = 0;
		if (this.amplitudeModRate != null) {
			this.amplitudeModRate.reset(flowObfuscator1);
			this.amplitudeModRange.reset(flowObfuscator1);
			local77 = (int) ((double) (this.amplitudeModRate.end - this.amplitudeModRate.start) * 32.768D / local26);
			local79 = (int) ((double) this.amplitudeModRate.start * 32.768D / local26);
		}
		for (@Pc(118) int local118 = 0; local118 < 5; local118++) {
			if (this.harmonicVolume[local118] != 0) {
				tmpPhases[local118] = 0;
				tmpDelays[local118] = (int) ((double) this.harmonicDelay[local118] * local26);
				tmpVolumes[local118] = (this.harmonicVolume[local118] << 14) / 100;
				tmpSemitones[local118] = (int) ((double) (this.frequencyBase.end - this.frequencyBase.start) * 32.768D * Math.pow(1.0057929410678534D, (double) this.harmonicSemitone[local118]) / local26);
				tmpStarts[local118] = (int) ((double) this.frequencyBase.start * 32.768D / local26);
			}
		}
		@Pc(201) int local201;
		@Pc(207) int local207;
		@Pc(222) int local222;
		for (@Pc(193) int local193 = 0; local193 < arg0; local193++) {
			local201 = this.frequencyBase.evaluate(true, arg0);
			local207 = this.amplitudeBase.evaluate(true, arg0);
			@Pc(216) int local216;
			if (this.frequencyModRate != null) {
				local216 = this.frequencyModRate.evaluate(true, arg0);
				local222 = this.frequencyModRange.evaluate(true, arg0);
				local201 += this.generate(-15143, local222, local40, this.frequencyModRate.form) >> 1;
				local40 += (local216 * local36 >> 16) + local38;
			}
			if (this.amplitudeModRate != null) {
				local216 = this.amplitudeModRate.evaluate(true, arg0);
				local222 = this.amplitudeModRange.evaluate(true, arg0);
				local207 = local207 * ((this.generate(-15143, local222, local81, this.amplitudeModRate.form) >> 1) + 32768) >> 15;
				local81 += (local216 * local77 >> 16) + local79;
			}
			for (local216 = 0; local216 < 5; local216++) {
				if (this.harmonicVolume[local216] != 0) {
					local222 = local193 + tmpDelays[local216];
					if (local222 < arg0) {
						buffer[local222] += this.generate(-15143, local207 * tmpVolumes[local216] >> 15, tmpPhases[local216], this.frequencyBase.form);
						tmpPhases[local216] += (local201 * tmpSemitones[local216] >> 16) + tmpStarts[local216];
					}
				}
			}
		}
		if (this.release != null) {
			this.release.reset(flowObfuscator1);
			this.attack.reset(flowObfuscator1);
			local201 = 0;
			@Pc(367) boolean local367 = false;
			@Pc(369) boolean local369 = true;
			for (local222 = 0; local222 < arg0; local222++) {
				@Pc(379) int local379 = this.release.evaluate(true, arg0);
				@Pc(385) int local385 = this.attack.evaluate(true, arg0);
				if (local369) {
					local207 = this.release.start + ((this.release.end - this.release.start) * local379 >> 8);
				} else {
					local207 = this.release.start + ((this.release.end - this.release.start) * local385 >> 8);
				}
				local201 += 256;
				if (local201 >= local207) {
					local201 = 0;
					local369 = !local369;
				}
				if (local369) {
					buffer[local222] = 0;
				}
			}
		}
		if (this.reverbDelay > 0 && this.reverbVolume > 0) {
			local201 = (int) ((double) this.reverbDelay * local26);
			for (local207 = local201; local207 < arg0; local207++) {
				buffer[local207] += buffer[local207 - local201] * this.reverbVolume / 100;
			}
		}
		for (local201 = 0; local201 < arg0; local201++) {
			if (buffer[local201] < -32768) {
				buffer[local201] = -32768;
			}
			if (buffer[local201] > 32767) {
				buffer[local201] = 32767;
			}
		}
		return buffer;
	}

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "(IIII)I")
	private int generate(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg0 != this.flowObfuscator2) {
				return 2;
			} else if (arg3 == 1) {
				return (arg2 & 0x7FFF) < 16384 ? arg1 : -arg1;
			} else if (arg3 == 2) {
				return sin[arg2 & 0x7FFF] * arg1 >> 14;
			} else if (arg3 == 3) {
				return ((arg2 & 0x7FFF) * arg1 >> 14) - arg1;
			} else if (arg3 == 4) {
				return noise[arg2 / 2607 & 0x7FFF] * arg1;
			} else {
				return 0;
			}
		} catch (@Pc(60) RuntimeException local60) {
			signlink.reporterror("41611, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local60.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!zb", name = "a", descriptor = "(ZLclient!kb;)V")
	public void read(@OriginalArg(0) boolean arg0, @OriginalArg(1) Buffer arg1) {
		try {
			this.frequencyBase = new SoundEnvelope();
			this.frequencyBase.read(false, arg1);
			this.amplitudeBase = new SoundEnvelope();
			this.amplitudeBase.read(false, arg1);
			@Pc(24) int local24 = arg1.g1();
			if (arg0) {
				throw new NullPointerException();
			}
			if (local24 != 0) {
				arg1.pos--;
				this.frequencyModRate = new SoundEnvelope();
				this.frequencyModRate.read(false, arg1);
				this.frequencyModRange = new SoundEnvelope();
				this.frequencyModRange.read(false, arg1);
			}
			local24 = arg1.g1();
			if (local24 != 0) {
				arg1.pos--;
				this.amplitudeModRate = new SoundEnvelope();
				this.amplitudeModRate.read(false, arg1);
				this.amplitudeModRange = new SoundEnvelope();
				this.amplitudeModRange.read(false, arg1);
			}
			local24 = arg1.g1();
			if (local24 != 0) {
				arg1.pos--;
				this.release = new SoundEnvelope();
				this.release.read(false, arg1);
				this.attack = new SoundEnvelope();
				this.attack.read(false, arg1);
			}
			for (@Pc(122) int local122 = 0; local122 < 10; local122++) {
				@Pc(132) int local132 = arg1.gsmarts();
				if (local132 == 0) {
					break;
				}
				this.harmonicVolume[local122] = local132;
				this.harmonicSemitone[local122] = arg1.gsmart();
				this.harmonicDelay[local122] = arg1.gsmarts();
			}
			this.reverbDelay = arg1.gsmarts();
			this.reverbVolume = arg1.gsmarts();
			this.length = arg1.g2();
			this.start = arg1.g2();
		} catch (@Pc(173) RuntimeException local173) {
			signlink.reporterror("36876, " + arg0 + ", " + arg1 + ", " + local173.toString());
			throw new RuntimeException();
		}
	}
}
