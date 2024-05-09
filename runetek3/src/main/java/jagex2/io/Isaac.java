package jagex2.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name and packaging confirmed 100% in rs2/mapview applet strings
@OriginalClass("client!tb")
public class Isaac {

	@OriginalMember(owner = "client!tb", name = "a", descriptor = "I")
	private int count;

	@OriginalMember(owner = "client!tb", name = "b", descriptor = "[I")
	private final int[] rsl;

	@OriginalMember(owner = "client!tb", name = "c", descriptor = "[I")
	private final int[] mem;

	@OriginalMember(owner = "client!tb", name = "d", descriptor = "I")
	private int a;

	@OriginalMember(owner = "client!tb", name = "e", descriptor = "I")
	private int b;

	@OriginalMember(owner = "client!tb", name = "f", descriptor = "I")
	private int c;

	@OriginalMember(owner = "client!tb", name = "<init>", descriptor = "(B[I)V")
	public Isaac(@OriginalArg(1) int[] seed) {
		this.mem = new int[256];
		this.rsl = new int[256];
		System.arraycopy(seed, 0, this.rsl, 0, seed.length);
		this.init();
	}

	@OriginalMember(owner = "client!tb", name = "a", descriptor = "()I")
	public int nextInt() {
		if (this.count-- == 0) {
			this.isaac();
			this.count = 255;
		}
		return this.rsl[this.count];
	}

	@OriginalMember(owner = "client!tb", name = "b", descriptor = "()V")
	private void isaac() {
		this.b += ++this.c;

		for (@Pc(15) int i = 0; i < 256; i++) {
			@Pc(22) int x = this.mem[i];
			switch (i & 0x3) {
				case 0:
					this.a ^= this.a << 13;
					break;
				case 1:
					this.a ^= this.a >>> 6;
					break;
				case 2:
					this.a ^= this.a << 2;
					break;
				case 3:
					this.a ^= this.a >>> 16;
			}

			this.a += this.mem[i + 128 & 0xFF];
			@Pc(101) int y;
			this.mem[i] = y = this.mem[x >> 2 & 0xFF] + this.a + this.b;
			this.rsl[i] = this.b = this.mem[y >> 8 >> 2 & 0xFF] + x;
		}
	}

	@OriginalMember(owner = "client!tb", name = "c", descriptor = "()V")
	private void init() {
		@Pc(4) int h = 0x9e3779b9;
		@Pc(6) int g = 0x9e3779b9;
		@Pc(8) int f = 0x9e3779b9;
		@Pc(10) int e = 0x9e3779b9;
		@Pc(12) int d = 0x9e3779b9;
		@Pc(14) int c = 0x9e3779b9;
		@Pc(16) int b = 0x9e3779b9;
		@Pc(17) int a = 0x9e3779b9;

		@Pc(19) int i;
		for (i = 0; i < 4; i++) {
			a ^= b << 11; d += a; b += c;
			b ^= c >>> 2; e += b; c += d;
			c ^= d << 8; f += c; d += e;
			d ^= e >>> 16; g += d; e += f;
			e ^= f << 10; h += e; f += g;
			f ^= g >>> 4; a += f; g += h;
			g ^= h << 8; b += g; h += a;
			h ^= a >>> 9; c += h; a += b;
		}

		for (i = 0; i < 256; i += 8) {
			a += this.rsl[i];
			b += this.rsl[i + 1];
			c += this.rsl[i + 2];
			d += this.rsl[i + 3];
			e += this.rsl[i + 4];
			f += this.rsl[i + 5];
			g += this.rsl[i + 6];
			h += this.rsl[i + 7];

			a ^= b << 11; d += a; b += c;
			b ^= c >>> 2; e += b; c += d;
			c ^= d << 8; f += c; d += e;
			d ^= e >>> 16; g += d; e += f;
			e ^= f << 10; h += e; f += g;
			f ^= g >>> 4; a += f; g += h;
			g ^= h << 8; b += g; h += a;
			h ^= a >>> 9; c += h; a += b;

			this.mem[i] = a;
			this.mem[i + 1] = b;
			this.mem[i + 2] = c;
			this.mem[i + 3] = d;
			this.mem[i + 4] = e;
			this.mem[i + 5] = f;
			this.mem[i + 6] = g;
			this.mem[i + 7] = h;
		}
		for (i = 0; i < 256; i += 8) {
			a += this.mem[i];
			b += this.mem[i + 1];
			c += this.mem[i + 2];
			d += this.mem[i + 3];
			e += this.mem[i + 4];
			f += this.mem[i + 5];
			g += this.mem[i + 6];
			h += this.mem[i + 7];

			a ^= b << 11; d += a; b += c;
			b ^= c >>> 2; e += b; c += d;
			c ^= d << 8; f += c; d += e;
			d ^= e >>> 16; g += d; e += f;
			e ^= f << 10; h += e; f += g;
			f ^= g >>> 4; a += f; g += h;
			g ^= h << 8; b += g; h += a;
			h ^= a >>> 9; c += h; a += b;

			this.mem[i] = a;
			this.mem[i + 1] = b;
			this.mem[i + 2] = c;
			this.mem[i + 3] = d;
			this.mem[i + 4] = e;
			this.mem[i + 5] = f;
			this.mem[i + 6] = g;
			this.mem[i + 7] = h;
		}

		this.isaac();
		this.count = 256;
	}
}
