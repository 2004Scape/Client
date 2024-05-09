package jagex2.io;

import jagex2.datastruct.Hashable;
import jagex2.datastruct.LinkList;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.math.BigInteger;

// name and packaging confirmed 100% in rs2/mapview applet strings
@OriginalClass("client!kb")
public class Packet extends Hashable {

	@OriginalMember(owner = "client!kb", name = "t", descriptor = "[I")
	private static final int[] crctable = new int[256];

	@OriginalMember(owner = "client!kb", name = "u", descriptor = "[I")
	public static final int[] BITMASK = new int[33];

	@OriginalMember(owner = "mapview!k", name = "o", descriptor = "[C")
	private char[] aCharArray1 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };

	@OriginalMember(owner = "client!kb", name = "q", descriptor = "[B")
	public byte[] data;

	@OriginalMember(owner = "client!kb", name = "r", descriptor = "I")
	public int pos;

	@OriginalMember(owner = "client!kb", name = "s", descriptor = "I")
	public int bitPos;

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
		for (int i = 0; i < 32; i++) {
			BITMASK[i] = (1 << i) - 1;
		}
		BITMASK[32] = 0xFFFFFFFF;

		for (@Pc(8) int b = 0; b < 256; b++) {
			@Pc(11) int remainder = b;

			for (@Pc(13) int bit = 0; bit < 8; bit++) {
				if ((remainder & 0x1) == 1) {
					remainder = remainder >>> 1 ^ 0xEDB88320;
				} else {
					remainder >>>= 0x1;
				}
			}

			crctable[b] = remainder;
		}
	}

	@OriginalMember(owner = "client!kb", name = "<init>", descriptor = "(I)V")
	public Packet() {
	}

	@OriginalMember(owner = "client!kb", name = "<init>", descriptor = "(I[B)V")
	public Packet(@OriginalArg(1) byte[] src) {
		this.data = src;
		this.pos = 0;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(II)Lclient!kb;")
	public static Packet alloc(@OriginalArg(0) int type) {
		synchronized (cacheMid) {
			@Pc(7) Packet cached = null;
			if (type == 0 && cacheMinCount > 0) {
				cacheMinCount--;
				cached = (Packet) cacheMin.removeHead();
			} else if (type == 1 && cacheMidCount > 0) {
				cacheMidCount--;
				cached = (Packet) cacheMid.removeHead();
			} else if (type == 2 && cacheMaxCount > 0) {
				cacheMaxCount--;
				cached = (Packet) cacheMax.removeHead();
			}

			if (cached != null) {
				cached.pos = 0;
				return cached;
			}
		}

		@Pc(77) Packet packet = new Packet();
		packet.pos = 0;
		if (type == 0) {
			packet.data = new byte[100];
		} else if (type == 1) {
			packet.data = new byte[5000];
		} else {
			packet.data = new byte[30000];
		}
		return packet;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(B)V")
	public void release() {
		synchronized (cacheMid) {
			this.pos = 0;

			if (this.data.length == 100 && cacheMinCount < 1000) {
				cacheMin.addTail(this);
				cacheMinCount++;
			} else if (this.data.length == 5000 && cacheMidCount < 250) {
				cacheMid.addTail(this);
				cacheMidCount++;
			} else if (this.data.length == 30000 && cacheMaxCount < 50) {
				cacheMax.addTail(this);
				cacheMaxCount++;
			}
		}
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(BI)V")
	public void p1isaac(@OriginalArg(1) int opcode) {
		this.data[this.pos++] = (byte) (opcode + this.random.nextInt());
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(I)V")
	public void p1(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(I)V")
	public void p2(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(ZI)V")
	public void ip2(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 8);
	}

	@OriginalMember(owner = "client!kb", name = "c", descriptor = "(I)V")
	public void p3(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!kb", name = "d", descriptor = "(I)V")
	public void p4(@OriginalArg(0) int value) {
		this.data[this.pos++] = (byte) (value >> 24);
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(ZI)V")
	public void ip4(@OriginalArg(1) int value) {
		this.data[this.pos++] = (byte) value;
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 24);
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(ZJ)V")
	public void p8(@OriginalArg(1) long value) {
		this.data[this.pos++] = (byte) (value >> 56);
		this.data[this.pos++] = (byte) (value >> 48);
		this.data[this.pos++] = (byte) (value >> 40);
		this.data[this.pos++] = (byte) (value >> 32);
		this.data[this.pos++] = (byte) (value >> 24);
		this.data[this.pos++] = (byte) (value >> 16);
		this.data[this.pos++] = (byte) (value >> 8);
		this.data[this.pos++] = (byte) value;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(Ljava/lang/String;)V")
	public void pjstr(@OriginalArg(0) String str) {
		str.getBytes(0, str.length(), this.data, this.pos);
		this.pos += str.length();
		this.data[this.pos++] = 10;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "([BIIB)V")
	public void pdata(@OriginalArg(0) byte[] src, @OriginalArg(1) int length, @OriginalArg(2) int offset) {
		for (@Pc(7) int i = offset; i < offset + length; i++) {
			this.data[this.pos++] = src[i];
		}
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(II)V")
	public void psize1(@OriginalArg(1) int size) {
		this.data[this.pos - size - 1] = (byte) size;
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
		@Pc(27) int value = ((this.data[this.pos - 2] & 0xFF) << 8) + (this.data[this.pos - 1] & 0xFF);
		if (value > 32767) {
			value -= 65536;
		}
		return value;
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
		@Pc(5) long high = (long) this.g4() & 0xFFFFFFFFL;
		@Pc(15) long low = (long) this.g4() & 0xFFFFFFFFL;
		return (high << 32) + low;
	}

	@OriginalMember(owner = "client!kb", name = "i", descriptor = "()Ljava/lang/String;")
	public String gjstr() {
		@Pc(2) int start = this.pos;
		while (this.data[this.pos++] != 10) {}

		return new String(this.data, start, this.pos - start - 1);
	}

	@OriginalMember(owner = "client!kb", name = "b", descriptor = "(B)[B")
	public byte[] gstrbyte() {
		@Pc(2) int start = this.pos;
		while (this.data[this.pos++] != 10) {}

		@Pc(29) byte[] temp = new byte[this.pos - start - 1];
		if (this.pos - 1 - start >= 0) System.arraycopy(this.data, start, temp, 0, this.pos - 1 - start);
		return temp;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(III[B)V")
	public void gdata(@OriginalArg(0) int length, @OriginalArg(2) int offset, @OriginalArg(3) byte[] dest) {
		for (@Pc(6) int i = offset; i < offset + length; i++) {
			dest[i] = this.data[this.pos++];
		}
	}

	@OriginalMember(owner = "client!kb", name = "f", descriptor = "(I)V")
	public void accessBits() {
		this.bitPos = this.pos * 8;
	}

	@OriginalMember(owner = "client!kb", name = "c", descriptor = "(II)I")
	public int gBit(@OriginalArg(1) int n) {
		@Pc(15) int bytePos = this.bitPos >> 3;
		@Pc(22) int remainingBits = 8 - (this.bitPos & 0x7);

		@Pc(24) int value = 0;
		this.bitPos += n;

		while (n > remainingBits) {
			value += (this.data[bytePos++] & BITMASK[remainingBits]) << n - remainingBits;
			n -= remainingBits;
			remainingBits = 8;
		}

		if (n == remainingBits) {
			value += this.data[bytePos] & BITMASK[remainingBits];
		} else {
			value += this.data[bytePos] >> remainingBits - n & BITMASK[n];
		}

		return value;
	}

	@OriginalMember(owner = "client!kb", name = "g", descriptor = "(I)V")
	public void accessBytes() {
		this.pos = (this.bitPos + 7) / 8;
	}

	@OriginalMember(owner = "client!kb", name = "j", descriptor = "()I")
	public int gsmart() {
		@Pc(7) int value = this.data[this.pos] & 0xFF;
		return value < 128 ? this.g1() - 64 : this.g2() - 49152;
	}

	@OriginalMember(owner = "client!kb", name = "k", descriptor = "()I")
	public int gsmarts() {
		@Pc(7) int value = this.data[this.pos] & 0xFF;
		return value < 128 ? this.g1() : this.g2() - 32768;
	}

	@OriginalMember(owner = "client!kb", name = "a", descriptor = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V")
	public void rsaenc(@OriginalArg(0) BigInteger mod, @OriginalArg(1) BigInteger exp) {
		@Pc(2) int length = this.pos;
		this.pos = 0;

		@Pc(8) byte[] temp = new byte[length];
		this.gdata(length, 0, temp);
		@Pc(19) BigInteger bigRaw = new BigInteger(temp);
		@Pc(24) BigInteger bigEnc = bigRaw.modPow(exp, mod);
		@Pc(27) byte[] rawEnc = bigEnc.toByteArray();

		this.pos = 0;
		this.p1(rawEnc.length);
		this.pdata(rawEnc, rawEnc.length, 0);
	}
}
