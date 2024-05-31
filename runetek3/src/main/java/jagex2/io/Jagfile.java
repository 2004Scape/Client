package jagex2.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// name and packaging confirmed 100% in rs2/mapview applet strings
// it was also observed in an exception handler string during rev 234
@OriginalClass("client!ub")
public class Jagfile {

	@OriginalMember(owner = "client!ub", name = "e", descriptor = "[B")
	private byte[] buffer;

	@OriginalMember(owner = "client!ub", name = "f", descriptor = "I")
	private int fileCount;

	@OriginalMember(owner = "client!ub", name = "g", descriptor = "[I")
	private int[] fileHash;

	@OriginalMember(owner = "client!ub", name = "h", descriptor = "[I")
	private int[] fileUnpackedSize;

	@OriginalMember(owner = "client!ub", name = "i", descriptor = "[I")
	private int[] filePackedSize;

	@OriginalMember(owner = "client!ub", name = "j", descriptor = "[I")
	private int[] fileOffset;

	@OriginalMember(owner = "client!ub", name = "k", descriptor = "Z")
	private boolean unpacked;

	@OriginalMember(owner = "client!ub", name = "<init>", descriptor = "([BZ)V")
	public Jagfile(@OriginalArg(0) byte[] src) {
		this.load(src);
	}

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "(Z[B)V")
	private void load(@OriginalArg(1) byte[] src) {
		@Pc(7) Packet data = new Packet(src);
		@Pc(10) int unpackedSize = data.g3();
		@Pc(13) int packedSize = data.g3();

		if (packedSize == unpackedSize) {
			this.buffer = src;
			this.unpacked = false;
		} else {
			@Pc(19) byte[] temp = new byte[unpackedSize];
			BZip2.read(temp, unpackedSize, src, packedSize, 6);
			this.buffer = temp;

			data = new Packet(this.buffer);
			this.unpacked = true;
		}

		this.fileCount = data.g2();
		this.fileHash = new int[this.fileCount];
		this.fileUnpackedSize = new int[this.fileCount];
		this.filePackedSize = new int[this.fileCount];
		this.fileOffset = new int[this.fileCount];

		@Pc(82) int pos = data.pos + this.fileCount * 10;
		for (@Pc(84) int i = 0; i < this.fileCount; i++) {
			this.fileHash[i] = data.g4();
			this.fileUnpackedSize[i] = data.g3();
			this.filePackedSize[i] = data.g3();
			this.fileOffset[i] = pos;
			pos += this.filePackedSize[i];
		}
	}

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "(Ljava/lang/String;[BB)[B")
	public byte[] read(@OriginalArg(0) String name, @OriginalArg(1) byte[] dst) {
		@Pc(3) int hash = 0;
		@Pc(6) String upper = name.toUpperCase();
		for (@Pc(8) int i = 0; i < upper.length(); i++) {
			hash = hash * 61 + upper.charAt(i) - 32;
		}

		for (@Pc(27) int i = 0; i < this.fileCount; i++) {
			if (this.fileHash[i] == hash) {
				if (dst == null) {
					dst = new byte[this.fileUnpackedSize[i]];
				}

				if (this.unpacked) {
					if (this.fileUnpackedSize[i] >= 0) {
						System.arraycopy(this.buffer, this.fileOffset[i], dst, 0, this.fileUnpackedSize[i]);
					}
				} else {
					BZip2.read(dst, this.fileUnpackedSize[i], this.buffer, this.filePackedSize[i], this.fileOffset[i]);
				}

				return dst;
			}
		}

		return null;
	}
}
