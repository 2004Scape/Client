package jagex2.io;

import jagex2.datastruct.Hashable;
import jagex2.datastruct.LinkList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.math.BigInteger;

// Packet: Buffer wrapper for reading and writing data
@OriginalClass("client!kb")
public final class Packet extends Hashable {

	@OriginalMember(owner = "client!kb", name = "q", descriptor = "[B")
	public byte[] data;

	@OriginalMember(owner = "client!kb", name = "r", descriptor = "I")
	public int pos;

	@OriginalMember(owner = "client!kb", name = "s", descriptor = "I")
	public int bitPosition;

	@OriginalMember(owner = "client!kb", name = "t", descriptor = "[I")
	private static final int[] crctable = new int[256];

	@OriginalMember(owner = "client!kb", name = "u", descriptor = "[I")
	public static final int[] BITMASK = new int[] { 0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1 };

	@OriginalMember(owner = "client!kb", name = "v", descriptor = "Lclient!tb;")
	public Isaac random;

	@OriginalMember(owner = "client!kb", name = "w", descriptor = "I")
	public static int cacheMinCount;

	@OriginalMember(owner = "client!kb", name = "x", descriptor = "I")
	public static int cacheMidCount;

	@OriginalMember(owner = "client!kb", name = "y", descriptor = "I")
	public static int cacheMaxCount;

	@OriginalMember(owner = "client!kb", name = "z", descriptor = "Lclient!ob;")
	public static final LinkList cacheMin = new LinkList();

	@OriginalMember(owner = "client!kb", name = "A", descriptor = "Lclient!ob;")
	public static final LinkList cacheMid = new LinkList();

	@OriginalMember(owner = "client!kb", name = "B", descriptor = "Lclient!ob;")
	public static final LinkList cacheMax = new LinkList();

	static {
		for (@Pc(8) int local8 = 0; local8 < 256; local8++) {
			@Pc(11) int local11 = local8;
			for (@Pc(13) int local13 = 0; local13 < 8; local13++) {
				if ((local11 & 0x1) == 1) {
					local11 = local11 >>> 1 ^ 0xEDB88320;
				} else {
					local11 >>>= 0x1;
				}
			}
			crctable[local8] = local11;
		}
	}

	@OriginalMember(owner = "client!kb", name = "<init>", descriptor = "(I)V")
	public Packet() {
	}

	@OriginalMember(owner = "client!kb", name = "<init>", descriptor = "(I[B)V")
	public Packet(@OriginalArg(1) byte[] arg1) {
		this.data = arg1;
		this.pos = 0;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(II)Lclient!kb;")
	public static Packet alloc(@OriginalArg(0) int arg0) {
		synchronized (cacheMid) {
			@Pc(7) Packet local7 = null;
			if (arg0 == 0 && cacheMinCount > 0) {
				cacheMinCount--;
				local7 = (Packet) cacheMin.pollFront();
			} else if (arg0 == 1 && cacheMidCount > 0) {
				cacheMidCount--;
				local7 = (Packet) cacheMid.pollFront();
			} else if (arg0 == 2 && cacheMaxCount > 0) {
				cacheMaxCount--;
				local7 = (Packet) cacheMax.pollFront();
			}
			if (local7 != null) {
				local7.pos = 0;
				return local7;
			}
		}
		@Pc(77) Packet local77 = new Packet();
		local77.pos = 0;
		if (arg0 == 0) {
			local77.data = new byte[100];
		} else if (arg0 == 1) {
			local77.data = new byte[5000];
		} else {
			local77.data = new byte[30000];
		}
		return local77;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(B)V")
	public void release() {
		synchronized (cacheMid) {
			this.pos = 0;
			if (this.data.length == 100 && cacheMinCount < 1000) {
				cacheMin.pushBack(this);
				cacheMinCount++;
			}
			if (this.data.length == 5000 && cacheMidCount < 250) {
				cacheMid.pushBack(this);
				cacheMidCount++;
			}
			if (this.data.length == 30000 && cacheMaxCount < 50) {
				cacheMax.pushBack(this);
				cacheMaxCount++;
			}
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(BI)V")
	public void p1isaac(@OriginalArg(1) int arg1) {
		this.data[this.pos++] = (byte) (arg1 + this.random.nextInt());
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(I)V")
	public void p1(@OriginalArg(0) int arg0) {
		this.data[this.pos++] = (byte) arg0;
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(I)V")
	public void p2(@OriginalArg(0) int arg0) {
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) arg0;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(ZI)V")
	public void ip2(@OriginalArg(1) int arg1) {
		this.data[this.pos++] = (byte) arg1;
		this.data[this.pos++] = (byte) (arg1 >> 8);
	}

	@OriginalMember(owner = "client!kb", name = "c", descriptor = "(I)V")
	public void p3(@OriginalArg(0) int arg0) {
		this.data[this.pos++] = (byte) (arg0 >> 16);
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) arg0;
	}

	@OriginalMember(owner = "client!kb", name = "d", descriptor = "(I)V")
	public void p4(@OriginalArg(0) int arg0) {
		this.data[this.pos++] = (byte) (arg0 >> 24);
		this.data[this.pos++] = (byte) (arg0 >> 16);
		this.data[this.pos++] = (byte) (arg0 >> 8);
		this.data[this.pos++] = (byte) arg0;
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(ZI)V")
	public void ip4(@OriginalArg(1) int arg1) {
		this.data[this.pos++] = (byte) arg1;
		this.data[this.pos++] = (byte) (arg1 >> 8);
		this.data[this.pos++] = (byte) (arg1 >> 16);
		this.data[this.pos++] = (byte) (arg1 >> 24);
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(ZJ)V")
	public void p8(@OriginalArg(1) long arg1) {
		this.data[this.pos++] = (byte) (arg1 >> 56);
		this.data[this.pos++] = (byte) (arg1 >> 48);
		this.data[this.pos++] = (byte) (arg1 >> 40);
		this.data[this.pos++] = (byte) (arg1 >> 32);
		this.data[this.pos++] = (byte) (arg1 >> 24);
		this.data[this.pos++] = (byte) (arg1 >> 16);
		this.data[this.pos++] = (byte) (arg1 >> 8);
		this.data[this.pos++] = (byte) arg1;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(Ljava/lang/String;)V")
	public void pjstr(@OriginalArg(0) String arg0) {
		System.arraycopy(arg0.getBytes(), 0, this.data, this.pos, arg0.length());
		this.pos += arg0.length();
		this.data[this.pos++] = 10;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "([BIIB)V")
	public void pdata(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		@Pc(7) int local7;
		for (local7 = arg2; local7 < arg2 + arg1; local7++) {
			this.data[this.pos++] = arg0[local7];
		}
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(II)V")
	public void psize1(@OriginalArg(1) int arg1) {
		this.data[this.pos - arg1 - 1] = (byte) arg1;
	}

	@OriginalMember(owner = "client!kb", name = "c", descriptor = "()I")
	public int g1() {
		return this.data[this.pos++] & 0xFF;
	}

	@OriginalMember(owner = "client!kb", name = "d", descriptor = "()B")
	public byte g1b() {
		return this.data[this.pos++];
	}

	@OriginalMember(owner = "client!kb", name = "e", descriptor = "()I")
	public int g2() {
		this.pos += 2;
		return ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
	}

	@OriginalMember(owner = "client!kb", name = "f", descriptor = "()I")
	public int g2b() {
		this.pos += 2;
		@Pc(27) int local27 = ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
		if (local27 > 32767) {
			local27 -= 65536;
		}
		return local27;
	}

	@OriginalMember(owner = "client!kb", name = "g", descriptor = "()I")
	public int g3() {
		this.pos += 3;
		return ((this.data[this.pos - 3] & 0xFF) << 16) + ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
	}

	@OriginalMember(owner = "client!kb", name = "h", descriptor = "()I")
	public int g4() {
		this.pos += 4;
		return ((this.data[this.pos - 4] & 0xFF) << 24) + ((this.data[this.pos - 3] & 0xFF) << 16) + ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
	}

	@OriginalMember(owner = "client!kb", name = "e", descriptor = "(I)J")
	public long g8() {
		@Pc(5) long local5 = (long) this.g4() & 0xFFFFFFFFL;
		@Pc(15) long local15 = (long) this.g4() & 0xFFFFFFFFL;
		return (local5 << 32) + local15;
	}

	@OriginalMember(owner = "client!kb", name = "i", descriptor = "()Ljava/lang/String;")
	public String gstr() {
		@Pc(2) int local2 = this.pos;
		while (this.data[this.pos++] != 10) {
		}
		return new String(this.data, local2, this.pos - local2 - 1);
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(B)[B")
	public byte[] gstrbyte() {
		@Pc(2) int local2 = this.pos;
		while (this.data[this.pos++] != 10) {
		}
		@Pc(29) byte[] local29 = new byte[this.pos - local2 - 1];
		for (@Pc(31) int local31 = local2; local31 < this.pos - 1; local31++) {
			local29[local31 - local2] = this.data[local31];
		}
		return local29;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(III[B)V")
	public void gdata(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2, @OriginalArg(3) byte[] arg3) {
		for (@Pc(6) int local6 = arg2; local6 < arg2 + arg0; local6++) {
			arg3[local6] = this.data[this.pos++];
		}
	}

	@OriginalMember(owner = "client!kb", name = "f", descriptor = "(I)V")
	public void accessBits() {
		this.bitPosition = this.pos * 8;
	}

	@OriginalMember(owner = "client!kb", name = "c", descriptor = "(II)I")
	public int gBit(@OriginalArg(1) int arg1) {
		@Pc(15) int local15 = this.bitPosition >> 3;
		@Pc(22) int local22 = 8 - (this.bitPosition & 0x7);
		@Pc(24) int local24 = 0;
		this.bitPosition += arg1;
		while (arg1 > local22) {
			local24 += (this.data[local15++] & BITMASK[local22]) << arg1 - local22;
			arg1 -= local22;
			local22 = 8;
		}
		if (arg1 == local22) {
			local24 += this.data[local15] & BITMASK[local22];
		} else {
			local24 += this.data[local15] >> local22 - arg1 & BITMASK[arg1];
		}
		return local24;
	}

	@OriginalMember(owner = "client!kb", name = "g", descriptor = "(I)V")
	public void accessBytes() {
		this.pos = (this.bitPosition + 7) / 8;
	}

	@OriginalMember(owner = "client!kb", name = "j", descriptor = "()I")
	public int gsmart() {
		@Pc(7) int local7 = this.data[this.pos] & 0xFF;
		return local7 < 128 ? this.g1() - 64 : this.g2() - 49152;
	}

	@OriginalMember(owner = "client!kb", name = "k", descriptor = "()I")
	public int gsmarts() {
		@Pc(7) int local7 = this.data[this.pos] & 0xFF;
		return local7 < 128 ? this.g1() : this.g2() - 32768;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V")
	public void rsaenc(@OriginalArg(0) BigInteger arg0, @OriginalArg(1) BigInteger arg1) {
		@Pc(2) int local2 = this.pos;
		this.pos = 0;
		@Pc(8) byte[] local8 = new byte[local2];
		this.gdata(local2, 0, local8);
		@Pc(19) BigInteger local19 = new BigInteger(local8);
		@Pc(24) BigInteger local24 = local19.modPow(arg1, arg0);
		@Pc(27) byte[] local27 = local24.toByteArray();
		this.pos = 0;
		this.p1(local27.length);
		this.pdata(local27, local27.length, 0);
	}
}
