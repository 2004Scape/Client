package jagex2.sound;

import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name and packaging confirmed 100% in rs2/mapview applet strings
@OriginalClass("client!yb")
public class Wave {

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
	public static void unpack(@OriginalArg(0) Packet dat) {
		waveBytes = new byte[441000];
		waveBuffer = new Packet(waveBytes);
		SoundTone.init();

		while (true) {
			@Pc(16) int id = dat.g2();
			if (id == 65535) {
				return;
			}

			tracks[id] = new Wave();
			tracks[id].read(dat);
			delays[id] = tracks[id].trim();
		}
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(BII)Lclient!kb;")
	public static Packet generate(@OriginalArg(2) int id, @OriginalArg(1) int loopCount) {
		if (tracks[id] == null) {
			return null;
		}

		@Pc(12) Wave track = tracks[id];
		return track.getWave(loopCount);
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(ZLclient!kb;)V")
	public void read(@OriginalArg(1) Packet dat) {
		for (@Pc(1) int tone = 0; tone < 10; tone++) {
			if (dat.g1() != 0) {
				dat.pos--;
				this.tones[tone] = new SoundTone();
				this.tones[tone].read(dat);
			}
		}

		this.loopBegin = dat.g2();
		this.loopEnd = dat.g2();
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(B)I")
	public int trim() {
		@Pc(3) int start = 9999999;
		for (@Pc(5) int tone = 0; tone < 10; tone++) {
			if (this.tones[tone] != null && this.tones[tone].start / 20 < start) {
				start = this.tones[tone].start / 20;
			}
		}

		if (this.loopBegin < this.loopEnd && this.loopBegin / 20 < start) {
			start = this.loopBegin / 20;
		}

		if (start == 9999999 || start == 0) {
			return 0;
		}

		for (@Pc(67) int tone = 0; tone < 10; tone++) {
			if (this.tones[tone] != null) {
				this.tones[tone].start -= start * 20;
			}
		}

		if (this.loopBegin < this.loopEnd) {
			this.loopBegin -= start * 20;
			this.loopEnd -= start * 20;
		}

		return start;
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(ZI)Lclient!kb;")
	public Packet getWave(@OriginalArg(1) int loopCount) {
		@Pc(3) int length = this.generate(loopCount);
		waveBuffer.pos = 0;
		waveBuffer.p4(0x52494646); // "RIFF" ChunkID
		waveBuffer.ip4(length + 36); // ChunkSize
		waveBuffer.p4(0x57415645); // "WAVE" format
		waveBuffer.p4(0x666d7420); // "fmt " chunk id
		waveBuffer.ip4(16); // chunk size
		waveBuffer.ip2(1); // audio format
		waveBuffer.ip2(1); // num channels
		waveBuffer.ip4(22050); // sample rate
		waveBuffer.ip4(22050); // byte rate
		waveBuffer.ip2(1); // block align
		waveBuffer.ip2(8); // bits per sample
		waveBuffer.p4(0x64617461); // "data"
		waveBuffer.ip4(length);
		waveBuffer.pos += length;
		return waveBuffer;
	}

	@OriginalMember(owner = "client!yb", name = "a", descriptor = "(I)I")
	private int generate(@OriginalArg(0) int loopCount) {
		@Pc(3) int duration = 0;
		for (@Pc(5) int tone = 0; tone < 10; tone++) {
			if (this.tones[tone] != null && this.tones[tone].length + this.tones[tone].start > duration) {
				duration = this.tones[tone].length + this.tones[tone].start;
			}
		}

		if (duration == 0) {
			return 0;
		}

		@Pc(51) int sampleCount = duration * 22050 / 1000;
		@Pc(58) int loopStart = this.loopBegin * 22050 / 1000;
		@Pc(65) int loopStop = this.loopEnd * 22050 / 1000;
		if (loopStart < 0 || loopStop < 0 || loopStop > sampleCount || loopStart >= loopStop) {
			loopCount = 0;
		}

		@Pc(90) int totalSampleCount = sampleCount + (loopStop - loopStart) * (loopCount - 1);
		for (@Pc(92) int sample = 44; sample < totalSampleCount + 44; sample++) {
			waveBytes[sample] = -128;
		}

		for (@Pc(106) int tone = 0; tone < 10; tone++) {
			if (this.tones[tone] != null) {
				int toneSampleCount = this.tones[tone].length * 22050 / 1000;
				int start = this.tones[tone].start * 22050 / 1000;
				@Pc(145) int[] samples = this.tones[tone].generate(toneSampleCount, this.tones[tone].length);

				for (int sample = 0; sample < toneSampleCount; sample++) {
					waveBytes[sample + start + 44] += (byte) (samples[sample] >> 8);
				}
			}
		}

		if (loopCount > 1) {
			loopStart += 44;
			loopStop += 44;
			sampleCount += 44;
			totalSampleCount += 44;

			int endOffset = totalSampleCount - sampleCount;
			for (int sample = sampleCount - 1; sample >= loopStop; sample--) {
				waveBytes[sample + endOffset] = waveBytes[sample];
			}

			for (@Pc(205) int loop = 1; loop < loopCount; loop++) {
				int offset = (loopStop - loopStart) * loop;

				for (int sample = loopStart; sample < loopStop; sample++) {
					waveBytes[sample + offset] = waveBytes[sample];
				}
			}

			totalSampleCount -= 44;
		}

		return totalSampleCount;
	}

	@OriginalClass("client!zb")
	public static final class SoundTone {

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
			for (@Pc(6) int i = 0; i < 32768; i++) {
				if (Math.random() > 0.5D) {
					noise[i] = 1;
				} else {
					noise[i] = -1;
				}
			}

			sin = new int[32768];
			for (@Pc(31) int i = 0; i < 32768; i++) {
				sin[i] = (int) (Math.sin((double) i / 5215.1903D) * 16384.0D);
			}

			buffer = new int[220500]; // 10s * 22050 KHz
		}

		@OriginalMember(owner = "client!zb", name = "a", descriptor = "(II)[I")
		public int[] generate(@OriginalArg(0) int sampleCount, @OriginalArg(1) int length) {
			for (@Pc(3) int sample = 0; sample < sampleCount; sample++) {
				buffer[sample] = 0;
			}

			if (length < 10) {
				return buffer;
			}

			@Pc(26) double samplesPerStep = (double) sampleCount / ((double) length + 0.0D);

			this.frequencyBase.reset();
			this.amplitudeBase.reset();

			@Pc(36) int frequencyStart = 0;
			@Pc(38) int frequencyDuration = 0;
			@Pc(40) int frequencyPhase = 0;

			if (this.frequencyModRate != null) {
				this.frequencyModRate.reset();
				this.frequencyModRange.reset();
				frequencyStart = (int) ((double) (this.frequencyModRate.end - this.frequencyModRate.start) * 32.768D / samplesPerStep);
				frequencyDuration = (int) ((double) this.frequencyModRate.start * 32.768D / samplesPerStep);
			}

			@Pc(77) int amplitudeStart = 0;
			@Pc(79) int amplitudeDuration = 0;
			@Pc(81) int amplitudePhase = 0;
			if (this.amplitudeModRate != null) {
				this.amplitudeModRate.reset();
				this.amplitudeModRange.reset();
				amplitudeStart = (int) ((double) (this.amplitudeModRate.end - this.amplitudeModRate.start) * 32.768D / samplesPerStep);
				amplitudeDuration = (int) ((double) this.amplitudeModRate.start * 32.768D / samplesPerStep);
			}

			for (@Pc(118) int harmonic = 0; harmonic < 5; harmonic++) {
				if (this.harmonicVolume[harmonic] != 0) {
					tmpPhases[harmonic] = 0;
					tmpDelays[harmonic] = (int) ((double) this.harmonicDelay[harmonic] * samplesPerStep);
					tmpVolumes[harmonic] = (this.harmonicVolume[harmonic] << 14) / 100;
					tmpSemitones[harmonic] = (int) ((double) (this.frequencyBase.end - this.frequencyBase.start) * 32.768D * Math.pow(1.0057929410678534D, this.harmonicSemitone[harmonic]) / samplesPerStep);
					tmpStarts[harmonic] = (int) ((double) this.frequencyBase.start * 32.768D / samplesPerStep);
				}
			}

			for (@Pc(193) int sample = 0; sample < sampleCount; sample++) {
				int frequency = this.frequencyBase.evaluate(sampleCount);
				int amplitude = this.amplitudeBase.evaluate(sampleCount);

				if (this.frequencyModRate != null) {
					int rate = this.frequencyModRate.evaluate(sampleCount);
					int range = this.frequencyModRange.evaluate(sampleCount);
					frequency += this.generate(range, frequencyPhase, this.frequencyModRate.form) >> 1;
					frequencyPhase += (rate * frequencyStart >> 16) + frequencyDuration;
				}

				if (this.amplitudeModRate != null) {
					int rate = this.amplitudeModRate.evaluate(sampleCount);
					int range = this.amplitudeModRange.evaluate(sampleCount);
					amplitude = amplitude * ((this.generate(range, amplitudePhase, this.amplitudeModRate.form) >> 1) + 32768) >> 15;
					amplitudePhase += (rate * amplitudeStart >> 16) + amplitudeDuration;
				}

				for (int harmonic = 0; harmonic < 5; harmonic++) {
					if (this.harmonicVolume[harmonic] != 0) {
						int position = sample + tmpDelays[harmonic];

						if (position < sampleCount) {
							buffer[position] += this.generate(amplitude * tmpVolumes[harmonic] >> 15, tmpPhases[harmonic], this.frequencyBase.form);
							tmpPhases[harmonic] += (frequency * tmpSemitones[harmonic] >> 16) + tmpStarts[harmonic];
						}
					}
				}
			}

			if (this.release != null) {
				this.release.reset();
				this.attack.reset();

				int counter = 0;
				@Pc(369) boolean muted = true;

				for (int sample = 0; sample < sampleCount; sample++) {
					@Pc(379) int releaseValue = this.release.evaluate(sampleCount);
					@Pc(385) int attackValue = this.attack.evaluate(sampleCount);

					int threshold;
					if (muted) {
						threshold = this.release.start + ((this.release.end - this.release.start) * releaseValue >> 8);
					} else {
						threshold = this.release.start + ((this.release.end - this.release.start) * attackValue >> 8);
					}

					counter += 256;
					if (counter >= threshold) {
						counter = 0;
						muted = !muted;
					}

					if (muted) {
						buffer[sample] = 0;
					}
				}
			}

			if (this.reverbDelay > 0 && this.reverbVolume > 0) {
				int start = (int) ((double) this.reverbDelay * samplesPerStep);

				for (int sample = start; sample < sampleCount; sample++) {
					buffer[sample] += buffer[sample - start] * this.reverbVolume / 100;
				}
			}

			for (int sample = 0; sample < sampleCount; sample++) {
				if (buffer[sample] < -32768) {
					buffer[sample] = -32768;
				}

				if (buffer[sample] > 32767) {
					buffer[sample] = 32767;
				}
			}

			return buffer;
		}

		@OriginalMember(owner = "client!zb", name = "a", descriptor = "(IIII)I")
		private int generate(@OriginalArg(1) int amplitude, @OriginalArg(2) int phase, @OriginalArg(3) int form) {
			if (form == 1) {
				return (phase & 0x7FFF) < 16384 ? amplitude : -amplitude;
			} else if (form == 2) {
				return sin[phase & 0x7FFF] * amplitude >> 14;
			} else if (form == 3) {
				return ((phase & 0x7FFF) * amplitude >> 14) - amplitude;
			} else if (form == 4) {
				return noise[phase / 2607 & 0x7FFF] * amplitude;
			} else {
				return 0;
			}
		}

		@OriginalMember(owner = "client!zb", name = "a", descriptor = "(ZLclient!kb;)V")
		public void read(@OriginalArg(1) Packet dat) {
			this.frequencyBase = new SoundEnvelope();
			this.frequencyBase.read(dat);

			this.amplitudeBase = new SoundEnvelope();
			this.amplitudeBase.read(dat);

			if (dat.g1() != 0) {
				dat.pos--;

				this.frequencyModRate = new SoundEnvelope();
				this.frequencyModRate.read(dat);

				this.frequencyModRange = new SoundEnvelope();
				this.frequencyModRange.read(dat);
			}

			if (dat.g1() != 0) {
				dat.pos--;

				this.amplitudeModRate = new SoundEnvelope();
				this.amplitudeModRate.read(dat);

				this.amplitudeModRange = new SoundEnvelope();
				this.amplitudeModRange.read(dat);
			}

			if (dat.g1() != 0) {
				dat.pos--;

				this.release = new SoundEnvelope();
				this.release.read(dat);

				this.attack = new SoundEnvelope();
				this.attack.read(dat);
			}

			for (@Pc(122) int harmonic = 0; harmonic < 10; harmonic++) {
				@Pc(132) int volume = dat.gsmarts();
				if (volume == 0) {
					break;
				}

				this.harmonicVolume[harmonic] = volume;
				this.harmonicSemitone[harmonic] = dat.gsmart();
				this.harmonicDelay[harmonic] = dat.gsmarts();
			}

			this.reverbDelay = dat.gsmarts();
			this.reverbVolume = dat.gsmarts();
			this.length = dat.g2();
			this.start = dat.g2();
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
		public void read(@OriginalArg(1) Packet dat) {
			this.form = dat.g1();
			this.start = dat.g4();
			this.end = dat.g4();
			this.length = dat.g1();
			this.shapeDelta = new int[this.length];
			this.shapePeak = new int[this.length];

			for (@Pc(31) int i = 0; i < this.length; i++) {
				this.shapeDelta[i] = dat.g2();
				this.shapePeak[i] = dat.g2();
			}
		}

		@OriginalMember(owner = "client!xb", name = "a", descriptor = "(I)V")
		public void reset() {
			this.threshold = 0;
			this.position = 0;
			this.delta = 0;
			this.amplitude = 0;
			this.ticks = 0;
		}

		@OriginalMember(owner = "client!xb", name = "a", descriptor = "(ZI)I")
		public int evaluate(@OriginalArg(1) int delta) {
			if (this.ticks >= this.threshold) {
				this.amplitude = this.shapePeak[this.position++] << 15;

				if (this.position >= this.length) {
					this.position = this.length - 1;
				}

				this.threshold = (int) ((double) this.shapeDelta[this.position] / 65536.0D * (double) delta);
				if (this.threshold > this.ticks) {
					this.delta = ((this.shapePeak[this.position] << 15) - this.amplitude) / (this.threshold - this.ticks);
				}
			}

			this.amplitude += this.delta;
			this.ticks++;
			return this.amplitude - this.delta >> 15;
		}
	}
}
