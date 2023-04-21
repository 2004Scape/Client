package jagex2.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// Isaac: https://en.wikipedia.org/wiki/ISAAC_(cipher)
@OriginalClass("client!tb")
public final class Isaac {

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
	public Isaac(@OriginalArg(1) int[] arg1) {
		this.mem = new int[256];
		this.rsl = new int[256];
		for (@Pc(13) int local13 = 0; local13 < arg1.length; local13++) {
			this.rsl[local13] = arg1[local13];
		}
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
		for (@Pc(15) int local15 = 0; local15 < 256; local15++) {
			@Pc(22) int local22 = this.mem[local15];
			switch(local15 & 0x3) {
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
			this.a += this.mem[local15 + 128 & 0xFF];
			@Pc(101) int local101;
			this.mem[local15] = local101 = this.mem[local22 >> 2 & 0xFF] + this.a + this.b;
			this.rsl[local15] = this.b = this.mem[local101 >> 8 >> 2 & 0xFF] + local22;
		}
	}

	@OriginalMember(owner = "client!tb", name = "c", descriptor = "()V")
	private void init() {
		@Pc(4) int local4 = -1640531527;
		@Pc(6) int local6 = -1640531527;
		@Pc(8) int local8 = -1640531527;
		@Pc(10) int local10 = -1640531527;
		@Pc(12) int local12 = -1640531527;
		@Pc(14) int local14 = -1640531527;
		@Pc(16) int local16 = -1640531527;
		@Pc(17) int local17 = -1640531527;
		@Pc(19) int local19;
		for (local19 = 0; local19 < 4; local19++) {
			local17 ^= local16 << 11;
			local12 += local17;
			local16 += local14;
			local16 ^= local14 >>> 2;
			local10 += local16;
			local14 += local12;
			local14 ^= local12 << 8;
			local8 += local14;
			local12 += local10;
			local12 ^= local10 >>> 16;
			local6 += local12;
			local10 += local8;
			local10 ^= local8 << 10;
			local4 += local10;
			local8 += local6;
			local8 ^= local6 >>> 4;
			local17 += local8;
			local6 += local4;
			local6 ^= local4 << 8;
			local16 += local6;
			local4 += local17;
			local4 ^= local17 >>> 9;
			local14 += local4;
			local17 += local16;
		}
		for (local19 = 0; local19 < 256; local19 += 8) {
			local17 += this.rsl[local19];
			local16 += this.rsl[local19 + 1];
			local14 += this.rsl[local19 + 2];
			local12 += this.rsl[local19 + 3];
			local10 += this.rsl[local19 + 4];
			local8 += this.rsl[local19 + 5];
			local6 += this.rsl[local19 + 6];
			local4 += this.rsl[local19 + 7];
			local17 ^= local16 << 11;
			local12 += local17;
			local16 += local14;
			local16 ^= local14 >>> 2;
			local10 += local16;
			local14 += local12;
			local14 ^= local12 << 8;
			local8 += local14;
			local12 += local10;
			local12 ^= local10 >>> 16;
			local6 += local12;
			local10 += local8;
			local10 ^= local8 << 10;
			local4 += local10;
			local8 += local6;
			local8 ^= local6 >>> 4;
			local17 += local8;
			local6 += local4;
			local6 ^= local4 << 8;
			local16 += local6;
			local4 += local17;
			local4 ^= local17 >>> 9;
			local14 += local4;
			local17 += local16;
			this.mem[local19] = local17;
			this.mem[local19 + 1] = local16;
			this.mem[local19 + 2] = local14;
			this.mem[local19 + 3] = local12;
			this.mem[local19 + 4] = local10;
			this.mem[local19 + 5] = local8;
			this.mem[local19 + 6] = local6;
			this.mem[local19 + 7] = local4;
		}
		for (local19 = 0; local19 < 256; local19 += 8) {
			local17 += this.mem[local19];
			local16 += this.mem[local19 + 1];
			local14 += this.mem[local19 + 2];
			local12 += this.mem[local19 + 3];
			local10 += this.mem[local19 + 4];
			local8 += this.mem[local19 + 5];
			local6 += this.mem[local19 + 6];
			local4 += this.mem[local19 + 7];
			local17 ^= local16 << 11;
			local12 += local17;
			local16 += local14;
			local16 ^= local14 >>> 2;
			local10 += local16;
			local14 += local12;
			local14 ^= local12 << 8;
			local8 += local14;
			local12 += local10;
			local12 ^= local10 >>> 16;
			local6 += local12;
			local10 += local8;
			local10 ^= local8 << 10;
			local4 += local10;
			local8 += local6;
			local8 ^= local6 >>> 4;
			local17 += local8;
			local6 += local4;
			local6 ^= local4 << 8;
			local16 += local6;
			local4 += local17;
			local4 ^= local17 >>> 9;
			local14 += local4;
			local17 += local16;
			this.mem[local19] = local17;
			this.mem[local19 + 1] = local16;
			this.mem[local19 + 2] = local14;
			this.mem[local19 + 3] = local12;
			this.mem[local19 + 4] = local10;
			this.mem[local19 + 5] = local8;
			this.mem[local19 + 6] = local6;
			this.mem[local19 + 7] = local4;
		}
		this.isaac();
		this.count = 256;
	}
}
