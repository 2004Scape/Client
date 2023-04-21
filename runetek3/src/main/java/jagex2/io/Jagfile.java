package jagex2.io;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// Jagfile: Jagex's archive format
@OriginalClass("client!ub")
public final class Jagfile {

	@OriginalMember(owner = "client!ub", name = "e", descriptor = "[B")
	private byte[] buffer;

	@OriginalMember(owner = "client!ub", name = "f", descriptor = "I")
	private int fileCount;

	@OriginalMember(owner = "client!ub", name = "g", descriptor = "[I")
	private int[] fileHash;

	@OriginalMember(owner = "client!ub", name = "h", descriptor = "[I")
	private int[] fileSizeInflated;

	@OriginalMember(owner = "client!ub", name = "i", descriptor = "[I")
	private int[] fileSizeDeflated;

	@OriginalMember(owner = "client!ub", name = "j", descriptor = "[I")
	private int[] fileOffset;

	@OriginalMember(owner = "client!ub", name = "k", descriptor = "Z")
	private boolean unpacked;

	@OriginalMember(owner = "client!ub", name = "<init>", descriptor = "([BZ)V")
	public Jagfile(@OriginalArg(0) byte[] arg0) {
		this.load(true, arg0);
	}

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "(Z[B)V")
	private void load(@OriginalArg(0) boolean parse, @OriginalArg(1) byte[] arg1) {
		@Pc(7) Packet local7 = new Packet(arg1);
		@Pc(10) int local10 = local7.g3();
		@Pc(13) int local13 = local7.g3();
		if (local13 == local10) {
			this.buffer = arg1;
			this.unpacked = false;
		} else {
			@Pc(19) byte[] local19 = new byte[local10];
			BZip2.read(local19, local10, arg1, local13, 6);
			this.buffer = local19;
			local7 = new Packet(this.buffer);
			this.unpacked = true;
		}
		this.fileCount = local7.g2();
		this.fileHash = new int[this.fileCount];
		this.fileSizeInflated = new int[this.fileCount];
		this.fileSizeDeflated = new int[this.fileCount];
		this.fileOffset = new int[this.fileCount];
		if (parse) {
			@Pc(82) int local82 = local7.pos + this.fileCount * 10;
			for (@Pc(84) int local84 = 0; local84 < this.fileCount; local84++) {
				this.fileHash[local84] = local7.g4();
				this.fileSizeInflated[local84] = local7.g3();
				this.fileSizeDeflated[local84] = local7.g3();
				this.fileOffset[local84] = local82;
				local82 += this.fileSizeDeflated[local84];
			}
		}
	}

	@OriginalMember(owner = "client!ub", name = "a", descriptor = "(Ljava/lang/String;[BB)[B")
	public byte[] read(@OriginalArg(0) String arg0, @OriginalArg(1) byte[] arg1) {
		@Pc(3) int local3 = 0;
		@Pc(6) String local6 = arg0.toUpperCase();
		for (@Pc(8) int local8 = 0; local8 < local6.length(); local8++) {
			local3 = local3 * 61 + local6.charAt(local8) - 32;
		}
		for (@Pc(27) int local27 = 0; local27 < this.fileCount; local27++) {
			if (this.fileHash[local27] == local3) {
				if (arg1 == null) {
					arg1 = new byte[this.fileSizeInflated[local27]];
				}
				if (this.unpacked) {
					for (@Pc(67) int local67 = 0; local67 < this.fileSizeInflated[local27]; local67++) {
						arg1[local67] = this.buffer[this.fileOffset[local27] + local67];
					}
				} else {
					BZip2.read(arg1, this.fileSizeInflated[local27], this.buffer, this.fileSizeDeflated[local27], this.fileOffset[local27]);
				}
				return arg1;
			}
		}
		return null;
	}
}
