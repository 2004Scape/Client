import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!yb")
public final class Wave {

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "Z")
	private final boolean flowObfuscator1 = true;

	@OriginalMember(owner = "client!yb", name = "b", descriptor = "I")
	public static int flowObfuscator2 = 473;

	@OriginalMember(owner = "client!yb", name = "c", descriptor = "[Lclient!yb;")
	private static final Wave[] tracks = new Wave[1000];

	@OriginalMember(owner = "client!yb", name = "d", descriptor = "[I")
	public static final int[] delays = new int[1000];

	@OriginalMember(owner = "client!yb", name = "e", descriptor = "[B")
	public static byte[] waveBytes;

	@OriginalMember(owner = "client!yb", name = "f", descriptor = "Lclient!kb;")
	public static Packet waveBuffer;

	@OriginalMember(owner = "client!yb", name = "g", descriptor = "[Lclient!zb;")
	private final SoundTone[] tones = new SoundTone[10];

	@OriginalMember(owner = "client!yb", name = "h", descriptor = "I")
	private int loopBegin;

	@OriginalMember(owner = "client!yb", name = "i", descriptor = "I")
	private int loopEnd;

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(Lclient!kb;I)V")
	public static void unpack(@OriginalArg(0) Packet arg0, @OriginalArg(1) int arg1) {
		try {
			waveBytes = new byte[441000];
			waveBuffer = new Packet(363, waveBytes);
			@Pc(12) int local12 = 87 / arg1;
			SoundTone.init();
			while (true) {
				@Pc(16) int local16 = arg0.g2();
				if (local16 == 65535) {
					return;
				}
				tracks[local16] = new Wave();
				tracks[local16].read(false, arg0);
				delays[local16] = tracks[local16].trim((byte) 7);
			}
		} catch (@Pc(42) RuntimeException local42) {
			signlink.reporterror("6214, " + arg0 + ", " + arg1 + ", " + local42.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(BII)Lclient!kb;")
	public static Packet generate(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 != -16) {
				flowObfuscator2 = -83;
			}
			if (tracks[arg2] == null) {
				return null;
			} else {
				@Pc(12) Wave local12 = tracks[arg2];
				return local12.getWave(true, arg1);
			}
		} catch (@Pc(20) RuntimeException local20) {
			signlink.reporterror("72905, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local20.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(ZLclient!kb;)V")
	public void read(@OriginalArg(0) boolean arg0, @OriginalArg(1) Packet arg1) {
		try {
			for (@Pc(1) int local1 = 0; local1 < 10; local1++) {
				@Pc(6) int local6 = arg1.g1();
				if (local6 != 0) {
					arg1.pos--;
					this.tones[local1] = new SoundTone();
					this.tones[local1].read(false, arg1);
				}
			}
			if (arg0) {
				flowObfuscator2 = -307;
			}
			this.loopBegin = arg1.g2();
			this.loopEnd = arg1.g2();
		} catch (@Pc(46) RuntimeException local46) {
			signlink.reporterror("58220, " + arg0 + ", " + arg1 + ", " + local46.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(B)I")
	public int trim(@OriginalArg(0) byte arg0) {
		try {
			@Pc(3) int local3 = 9999999;
			for (@Pc(5) int local5 = 0; local5 < 10; local5++) {
				if (this.tones[local5] != null && this.tones[local5].start / 20 < local3) {
					local3 = this.tones[local5].start / 20;
				}
			}
			if (arg0 == 7) {
				@Pc(38) boolean local38 = false;
			} else {
				flowObfuscator2 = -8;
			}
			if (this.loopBegin < this.loopEnd && this.loopBegin / 20 < local3) {
				local3 = this.loopBegin / 20;
			}
			if (local3 == 9999999 || local3 == 0) {
				return 0;
			}
			for (@Pc(67) int local67 = 0; local67 < 10; local67++) {
				if (this.tones[local67] != null) {
					this.tones[local67].start -= local3 * 20;
				}
			}
			if (this.loopBegin < this.loopEnd) {
				this.loopBegin -= local3 * 20;
				this.loopEnd -= local3 * 20;
			}
			return local3;
		} catch (@Pc(113) RuntimeException local113) {
			signlink.reporterror("49328, " + arg0 + ", " + local113.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(ZI)Lclient!kb;")
	public Packet getWave(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) int local3 = this.generate(arg1);
			waveBuffer.pos = 0;
			waveBuffer.p4(1380533830);
			waveBuffer.ip4(false, local3 + 36);
			waveBuffer.p4(1463899717);
			waveBuffer.p4(1718449184);
			waveBuffer.ip4(false, 16);
			if (!arg0) {
				for (@Pc(29) int local29 = 1; local29 > 0; local29++) {
				}
			}
			waveBuffer.ip2(this.flowObfuscator1, 1);
			waveBuffer.ip2(this.flowObfuscator1, 1);
			waveBuffer.ip4(false, 22050);
			waveBuffer.ip4(false, 22050);
			waveBuffer.ip2(this.flowObfuscator1, 1);
			waveBuffer.ip2(this.flowObfuscator1, 8);
			waveBuffer.p4(1684108385);
			waveBuffer.ip4(false, local3);
			waveBuffer.pos += local3;
			return waveBuffer;
		} catch (@Pc(78) RuntimeException local78) {
			signlink.reporterror("83597, " + arg0 + ", " + arg1 + ", " + local78.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(I)I")
	private int generate(@OriginalArg(0) int arg0) {
		@Pc(3) int local3 = 0;
		for (@Pc(5) int local5 = 0; local5 < 10; local5++) {
			if (this.tones[local5] != null && this.tones[local5].length + this.tones[local5].start > local3) {
				local3 = this.tones[local5].length + this.tones[local5].start;
			}
		}
		if (local3 == 0) {
			return 0;
		}
		@Pc(51) int local51 = local3 * 22050 / 1000;
		@Pc(58) int local58 = this.loopBegin * 22050 / 1000;
		@Pc(65) int local65 = this.loopEnd * 22050 / 1000;
		if (local58 < 0 || local58 > local51 || local65 < 0 || local65 > local51 || local58 >= local65) {
			arg0 = 0;
		}
		@Pc(90) int local90 = local51 + (local65 - local58) * (arg0 - 1);
		for (@Pc(92) int local92 = 44; local92 < local90 + 44; local92++) {
			waveBytes[local92] = -128;
		}
		@Pc(123) int local123;
		@Pc(133) int local133;
		@Pc(147) int local147;
		for (@Pc(106) int local106 = 0; local106 < 10; local106++) {
			if (this.tones[local106] != null) {
				local123 = this.tones[local106].length * 22050 / 1000;
				local133 = this.tones[local106].start * 22050 / 1000;
				@Pc(145) int[] local145 = this.tones[local106].generate(local123, this.tones[local106].length);
				for (local147 = 0; local147 < local123; local147++) {
					waveBytes[local147 + local133 + 44] += (byte) (local145[local147] >> 8);
				}
			}
		}
		if (arg0 > 1) {
			local58 += 44;
			local65 += 44;
			local51 += 44;
			local90 += 44;
			local123 = local90 - local51;
			for (local133 = local51 - 1; local133 >= local65; local133--) {
				waveBytes[local133 + local123] = waveBytes[local133];
			}
			for (@Pc(205) int local205 = 1; local205 < arg0; local205++) {
				local123 = (local65 - local58) * local205;
				for (local147 = local58; local147 < local65; local147++) {
					waveBytes[local147 + local123] = waveBytes[local147];
				}
			}
			local90 -= 44;
		}
		return local90;
	}

	@OriginalClass("client!zb")
	public static final class SoundTone {

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
		public void read(@OriginalArg(0) boolean arg0, @OriginalArg(1) Packet arg1) {
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

	@OriginalClass("client!xb")
	public static final class SoundEnvelope {

		@OriginalMember(owner = "client!xb", name = "a", descriptor = "I")
		private int length;

		@OriginalMember(owner = "client!xb", name = "b", descriptor = "[I")
		private int[] shapeDelta;

		@OriginalMember(owner = "client!xb", name = "c", descriptor = "[I")
		private int[] shapePeak;

		@OriginalMember(owner = "client!xb", name = "d", descriptor = "I")
		public int start;

		@OriginalMember(owner = "client!xb", name = "e", descriptor = "I")
		public int end;

		@OriginalMember(owner = "client!xb", name = "f", descriptor = "I")
		public int form;

		@OriginalMember(owner = "client!xb", name = "g", descriptor = "I")
		private int threshold;

		@OriginalMember(owner = "client!xb", name = "h", descriptor = "I")
		private int position;

		@OriginalMember(owner = "client!xb", name = "i", descriptor = "I")
		private int delta;

		@OriginalMember(owner = "client!xb", name = "j", descriptor = "I")
		private int amplitude;

		@OriginalMember(owner = "client!xb", name = "k", descriptor = "I")
		private int ticks;

		@OriginalMember(owner = "client!xb", name = "a", descriptor = "(ZLclient!kb;)V")
		public void read(@OriginalArg(0) boolean arg0, @OriginalArg(1) Packet arg1) {
			try {
				this.form = arg1.g1();
				this.start = arg1.g4();
				this.end = arg1.g4();
				this.length = arg1.g1();
				this.shapeDelta = new int[this.length];
				this.shapePeak = new int[this.length];
				@Pc(31) int local31;
				if (arg0) {
					for (local31 = 1; local31 > 0; local31++) {
					}
				}
				for (local31 = 0; local31 < this.length; local31++) {
					this.shapeDelta[local31] = arg1.g2();
					this.shapePeak[local31] = arg1.g2();
				}
			} catch (@Pc(67) RuntimeException local67) {
				signlink.reporterror("83915, " + arg0 + ", " + arg1 + ", " + local67.toString());
				throw new RuntimeException();
			}
		}

		@OriginalMember(owner = "client!xb", name = "a", descriptor = "(I)V")
		public void reset(@OriginalArg(0) int arg0) {
			try {
				this.threshold = 0;
				this.position = 0;
				this.delta = 0;
				this.amplitude = 0;
				if (arg0 >= 8 && arg0 <= 8) {
					this.ticks = 0;
				}
			} catch (@Pc(23) RuntimeException local23) {
				signlink.reporterror("47965, " + arg0 + ", " + local23.toString());
				throw new RuntimeException();
			}
		}

		@OriginalMember(owner = "client!xb", name = "a", descriptor = "(ZI)I")
		public int evaluate(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
			try {
				if (!arg0) {
					for (@Pc(3) int local3 = 1; local3 > 0; local3++) {
					}
				}
				if (this.ticks >= this.threshold) {
					this.amplitude = this.shapePeak[this.position++] << 15;
					if (this.position >= this.length) {
						this.position = this.length - 1;
					}
					this.threshold = (int) ((double) this.shapeDelta[this.position] / 65536.0D * (double) arg1);
					if (this.threshold > this.ticks) {
						this.delta = ((this.shapePeak[this.position] << 15) - this.amplitude) / (this.threshold - this.ticks);
					}
				}
				this.amplitude += this.delta;
				this.ticks++;
				return this.amplitude - this.delta >> 15;
			} catch (@Pc(97) RuntimeException local97) {
				signlink.reporterror("65731, " + arg0 + ", " + arg1 + ", " + local97.toString());
				throw new RuntimeException();
			}
		}
	}
}
