package com.jagex.core.io;

import com.jagex.core.crypto.IsaacRandom;
import com.jagex.core.util.CacheableNode;
import com.jagex.core.util.DoublyLinkedList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

import java.math.BigInteger;

@OriginalClass("client!kb")
public final class Buffer extends CacheableNode {

	@OriginalMember(owner = "client!kb", name = "h", descriptor = "I")
	public static int flowObfuscator1 = 40946;

	@OriginalMember(owner = "client!kb", name = "i", descriptor = "B")
	private final byte flowObfuscator2 = -34;

	@OriginalMember(owner = "client!kb", name = "j", descriptor = "B")
	private final byte flowObfuscator3 = -106;

	@OriginalMember(owner = "client!kb", name = "k", descriptor = "I")
	private final int flowObfuscator4 = 3;

	@OriginalMember(owner = "client!kb", name = "l", descriptor = "I")
	private int flowObfuscator5 = -506;

	@OriginalMember(owner = "client!kb", name = "m", descriptor = "Z")
	private boolean flowObfuscator6 = true;

	@OriginalMember(owner = "client!kb", name = "n", descriptor = "I")
	private final int flowObfuscator7 = 4277;

	@OriginalMember(owner = "client!kb", name = "o", descriptor = "Z")
	public static boolean flowObfuscator8 = true;

	@OriginalMember(owner = "client!kb", name = "p", descriptor = "I")
	private final int flowObfuscator9 = -178;

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
	public IsaacRandom random;

	@OriginalMember(owner = "client!kb", name = "w", descriptor = "I")
	public static int cacheMinCount;

	@OriginalMember(owner = "client!kb", name = "x", descriptor = "I")
	public static int cacheMidCount;

	@OriginalMember(owner = "client!kb", name = "y", descriptor = "I")
	public static int cacheMaxCount;

	@OriginalMember(owner = "client!kb", name = "z", descriptor = "Lclient!ob;")
	public static final DoublyLinkedList cacheMin = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!kb", name = "A", descriptor = "Lclient!ob;")
	public static final DoublyLinkedList cacheMid = new DoublyLinkedList(0);

	@OriginalMember(owner = "client!kb", name = "B", descriptor = "Lclient!ob;")
	public static final DoublyLinkedList cacheMax = new DoublyLinkedList(0);

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
	public Buffer(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != 40946) {
				flowObfuscator8 = !flowObfuscator8;
			}
		} catch (@Pc(33) RuntimeException local33) {
			Signlink.reporterror("73559, " + arg0 + ", " + local33.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "<init>", descriptor = "(I[B)V")
	public Buffer(@OriginalArg(0) int arg0, @OriginalArg(1) byte[] arg1) {
		try {
			this.data = arg1;
			this.pos = 0;
			@Pc(32) int local32 = 15 / arg0;
		} catch (@Pc(34) RuntimeException local34) {
			Signlink.reporterror("63917, " + arg0 + ", " + arg1 + ", " + local34.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(II)Lclient!kb;")
	public static Buffer alloc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(3) DoublyLinkedList local3 = cacheMid;
			synchronized (cacheMid) {
				@Pc(7) Buffer local7 = null;
				if (arg0 == 0 && cacheMinCount > 0) {
					cacheMinCount--;
					local7 = (Buffer) cacheMin.pollFront();
				} else if (arg0 == 1 && cacheMidCount > 0) {
					cacheMidCount--;
					local7 = (Buffer) cacheMid.pollFront();
				} else if (arg0 == 2 && cacheMaxCount > 0) {
					cacheMaxCount--;
					local7 = (Buffer) cacheMax.pollFront();
				}
				if (local7 != null) {
					local7.pos = 0;
					return local7;
				}
			}
			if (arg1 >= 0) {
				flowObfuscator8 = !flowObfuscator8;
			}
			@Pc(77) Buffer local77 = new Buffer(flowObfuscator1);
			local77.pos = 0;
			if (arg0 == 0) {
				local77.data = new byte[100];
			} else if (arg0 == 1) {
				local77.data = new byte[5000];
			} else {
				local77.data = new byte[30000];
			}
			return local77;
		} catch (@Pc(104) RuntimeException local104) {
			Signlink.reporterror("65959, " + arg0 + ", " + arg1 + ", " + local104.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(B)V")
	public void release(@OriginalArg(0) byte arg0) {
		try {
			@Pc(1) DoublyLinkedList local1 = cacheMid;
			synchronized (cacheMid) {
				this.pos = 0;
				if (this.data.length == 100 && cacheMinCount < 1000) {
					cacheMin.pushBack(this);
					cacheMinCount++;
					return;
				}
				if (this.data.length == 5000 && cacheMidCount < 250) {
					cacheMid.pushBack(this);
					cacheMidCount++;
					return;
				}
				if (this.data.length == 30000 && cacheMaxCount < 50) {
					cacheMax.pushBack(this);
					cacheMaxCount++;
					return;
				}
			}
			if (arg0 != 8) {
				flowObfuscator1 = -173;
			}
		} catch (@Pc(73) RuntimeException local73) {
			Signlink.reporterror("53281, " + arg0 + ", " + local73.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(BI)V")
	public void p1isaac(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1) {
		try {
			this.data[this.pos++] = (byte) (arg1 + this.random.nextInt());
			if (arg0 != this.flowObfuscator2) {
				flowObfuscator8 = !flowObfuscator8;
			}
		} catch (@Pc(27) RuntimeException local27) {
			Signlink.reporterror("36381, " + arg0 + ", " + arg1 + ", " + local27.toString());
			throw new RuntimeException();
		}
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
	public void ip2(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
		try {
			if (!arg0) {
				flowObfuscator8 = !flowObfuscator8;
			}
			this.data[this.pos++] = (byte) arg1;
			this.data[this.pos++] = (byte) (arg1 >> 8);
		} catch (@Pc(35) RuntimeException local35) {
			Signlink.reporterror("76445, " + arg0 + ", " + arg1 + ", " + local35.toString());
			throw new RuntimeException();
		}
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
	public void ip4(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1) {
		try {
			this.data[this.pos++] = (byte) arg1;
			this.data[this.pos++] = (byte) (arg1 >> 8);
			this.data[this.pos++] = (byte) (arg1 >> 16);
			if (!arg0) {
				this.data[this.pos++] = (byte) (arg1 >> 24);
			}
		} catch (@Pc(58) RuntimeException local58) {
			Signlink.reporterror("60396, " + arg0 + ", " + arg1 + ", " + local58.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(ZJ)V")
	public void p8(@OriginalArg(0) boolean arg0, @OriginalArg(1) long arg1) {
		try {
			this.data[this.pos++] = (byte) (arg1 >> 56);
			this.data[this.pos++] = (byte) (arg1 >> 48);
			this.data[this.pos++] = (byte) (arg1 >> 40);
			this.data[this.pos++] = (byte) (arg1 >> 32);
			this.data[this.pos++] = (byte) (arg1 >> 24);
			this.data[this.pos++] = (byte) (arg1 >> 16);
			this.data[this.pos++] = (byte) (arg1 >> 8);
			if (arg0) {
				this.data[this.pos++] = (byte) arg1;
			}
		} catch (@Pc(131) RuntimeException local131) {
			Signlink.reporterror("23917, " + arg0 + ", " + arg1 + ", " + local131.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(Ljava/lang/String;)V")
	public void pjstr(@OriginalArg(0) String arg0) {
		arg0.getBytes(0, arg0.length(), this.data, this.pos);
		this.pos += arg0.length();
		this.data[this.pos++] = 10;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "([BIIB)V")
	public void pdata(@OriginalArg(0) byte[] arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte arg3) {
		try {
			@Pc(7) int local7;
			if (arg3 != this.flowObfuscator3) {
				for (local7 = 1; local7 > 0; local7++) {
				}
			}
			for (local7 = arg2; local7 < arg2 + arg1; local7++) {
				this.data[this.pos++] = arg0[local7];
			}
		} catch (@Pc(37) RuntimeException local37) {
			Signlink.reporterror("88471, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(II)V")
	public void psize1(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 != 0) {
				flowObfuscator8 = !flowObfuscator8;
			}
			this.data[this.pos - arg1 - 1] = (byte) arg1;
		} catch (@Pc(20) RuntimeException local20) {
			Signlink.reporterror("44726, " + arg0 + ", " + arg1 + ", " + local20.toString());
			throw new RuntimeException();
		}
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
	public long g8(@OriginalArg(0) int arg0) {
		try {
			@Pc(5) long local5 = (long) this.g4() & 0xFFFFFFFFL;
			@Pc(9) int local9 = 87 / arg0;
			@Pc(15) long local15 = (long) this.g4() & 0xFFFFFFFFL;
			return (local5 << 32) + local15;
		} catch (@Pc(22) RuntimeException local22) {
			Signlink.reporterror("61408, " + arg0 + ", " + local22.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "i", descriptor = "()Ljava/lang/String;")
	public String gstr() {
		@Pc(2) int local2 = this.pos;
		while (this.data[this.pos++] != 10) {
		}
		return new String(this.data, local2, this.pos - local2 - 1);
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(B)[B")
	public byte[] gstrbyte(@OriginalArg(0) byte arg0) {
		try {
			@Pc(2) int local2 = this.pos;
			if (arg0 != 31) {
				throw new NullPointerException();
			}
			while (this.data[this.pos++] != 10) {
			}
			@Pc(29) byte[] local29 = new byte[this.pos - local2 - 1];
			for (@Pc(31) int local31 = local2; local31 < this.pos - 1; local31++) {
				local29[local31 - local2] = this.data[local31];
			}
			return local29;
		} catch (@Pc(52) RuntimeException local52) {
			Signlink.reporterror("66822, " + arg0 + ", " + local52.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(III[B)V")
	public void gdata(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) byte[] arg3) {
		try {
			if (arg1 >= 0) {
				this.flowObfuscator5 = -432;
			}
			for (@Pc(6) int local6 = arg2; local6 < arg2 + arg0; local6++) {
				arg3[local6] = this.data[this.pos++];
			}
		} catch (@Pc(29) RuntimeException local29) {
			Signlink.reporterror("61364, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local29.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "f", descriptor = "(I)V")
	public void accessBits(@OriginalArg(0) int arg0) {
		try {
			this.bitPosition = this.pos * 8;
			if (arg0 <= 0) {
				this.flowObfuscator6 = !this.flowObfuscator6;
			}
		} catch (@Pc(17) RuntimeException local17) {
			Signlink.reporterror("5633, " + arg0 + ", " + local17.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "c", descriptor = "(II)I")
	public int gBit(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			if (arg0 < 9 || arg0 > 9) {
				return this.flowObfuscator4;
			}
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
		} catch (@Pc(91) RuntimeException local91) {
			Signlink.reporterror("91100, " + arg0 + ", " + arg1 + ", " + local91.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!kb", name = "g", descriptor = "(I)V")
	public void accessBytes(@OriginalArg(0) int arg0) {
		try {
			if (arg0 != this.flowObfuscator7) {
				for (@Pc(5) int local5 = 1; local5 > 0; local5++) {
				}
			}
			this.pos = (this.bitPosition + 7) / 8;
		} catch (@Pc(20) RuntimeException local20) {
			Signlink.reporterror("27753, " + arg0 + ", " + local20.toString());
			throw new RuntimeException();
		}
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
	public void rsaenc(@OriginalArg(0) BigInteger arg0, @OriginalArg(1) BigInteger arg1, @OriginalArg(2) int arg2) {
		try {
			@Pc(2) int local2 = this.pos;
			this.pos = 0;
			@Pc(8) byte[] local8 = new byte[local2];
			this.gdata(local2, -110, 0, local8);
			@Pc(19) BigInteger local19 = new BigInteger(local8);
			@Pc(24) BigInteger local24 = local19.modPow(arg1, arg0);
			@Pc(27) byte[] local27 = local24.toByteArray();
			this.pos = 0;
			if (arg2 == 24676) {
				this.p1(local27.length);
				this.pdata(local27, local27.length, 0, (byte) -106);
			}
		} catch (@Pc(47) RuntimeException local47) {
			Signlink.reporterror("7102, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local47.toString());
			throw new RuntimeException();
		}
	}
}
