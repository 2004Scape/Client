import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!ec")
public final class CollisionMap {

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "Z")
	private boolean flowObfuscator1 = false;

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "I")
	private int flowObfuscator2;

	@OriginalMember(owner = "client!ec", name = "c", descriptor = "B")
	private final byte flowObfuscator3 = 12;

	@OriginalMember(owner = "client!ec", name = "d", descriptor = "I")
	private final int flowObfuscator4 = 27808;

	@OriginalMember(owner = "client!ec", name = "e", descriptor = "Z")
	private boolean flowObfuscator5 = true;

	@OriginalMember(owner = "client!ec", name = "f", descriptor = "I")
	private final int offsetX;

	@OriginalMember(owner = "client!ec", name = "g", descriptor = "I")
	private final int offsetZ;

	@OriginalMember(owner = "client!ec", name = "h", descriptor = "I")
	private final int sizeX;

	@OriginalMember(owner = "client!ec", name = "i", descriptor = "I")
	private final int sizeZ;

	@OriginalMember(owner = "client!ec", name = "j", descriptor = "[[I")
	public final int[][] flags;

	@OriginalMember(owner = "client!ec", name = "<init>", descriptor = "(III)V")
	public CollisionMap(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			while (arg1 >= 0) {
				this.flowObfuscator5 = !this.flowObfuscator5;
			}
			this.offsetX = 0;
			this.offsetZ = 0;
			this.sizeX = arg0;
			this.sizeZ = arg2;
			this.flags = new int[this.sizeX][this.sizeZ];
			this.reset((byte) 74);
		} catch (@Pc(49) RuntimeException local49) {
			signlink.reporterror("56319, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local49.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(B)V")
	public void reset(@OriginalArg(0) byte arg0) {
		try {
			@Pc(7) int local7;
			for (@Pc(3) int local3 = 0; local3 < this.sizeX; local3++) {
				for (local7 = 0; local7 < this.sizeZ; local7++) {
					if (local3 == 0 || local7 == 0 || local3 == this.sizeX - 1 || local7 == this.sizeZ - 1) {
						this.flags[local3][local7] = 16777215;
					} else {
						this.flags[local3][local7] = 0;
					}
				}
			}
			if (arg0 != 74) {
				for (local7 = 1; local7 > 0; local7++) {
				}
			}
		} catch (@Pc(63) RuntimeException local63) {
			signlink.reporterror("82442, " + arg0 + ", " + local63.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(ZIIIZI)V")
	public void addWall(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) int arg5) {
		try {
			@Pc(4) int local4 = arg3 - this.offsetX;
			if (!arg0) {
				this.flowObfuscator1 = !this.flowObfuscator1;
			}
			@Pc(19) int local19 = arg2 - this.offsetZ;
			if (arg5 == 0) {
				if (arg1 == 0) {
					this.add(local4, local19, 128);
					this.add(local4 - 1, local19, 8);
				}
				if (arg1 == 1) {
					this.add(local4, local19, 2);
					this.add(local4, local19 + 1, 32);
				}
				if (arg1 == 2) {
					this.add(local4, local19, 8);
					this.add(local4 + 1, local19, 128);
				}
				if (arg1 == 3) {
					this.add(local4, local19, 32);
					this.add(local4, local19 - 1, 2);
				}
			}
			if (arg5 == 1 || arg5 == 3) {
				if (arg1 == 0) {
					this.add(local4, local19, 1);
					this.add(local4 - 1, local19 + 1, 16);
				}
				if (arg1 == 1) {
					this.add(local4, local19, 4);
					this.add(local4 + 1, local19 + 1, 64);
				}
				if (arg1 == 2) {
					this.add(local4, local19, 16);
					this.add(local4 + 1, local19 - 1, 1);
				}
				if (arg1 == 3) {
					this.add(local4, local19, 64);
					this.add(local4 - 1, local19 - 1, 4);
				}
			}
			if (arg5 == 2) {
				if (arg1 == 0) {
					this.add(local4, local19, 130);
					this.add(local4 - 1, local19, 8);
					this.add(local4, local19 + 1, 32);
				}
				if (arg1 == 1) {
					this.add(local4, local19, 10);
					this.add(local4, local19 + 1, 32);
					this.add(local4 + 1, local19, 128);
				}
				if (arg1 == 2) {
					this.add(local4, local19, 40);
					this.add(local4 + 1, local19, 128);
					this.add(local4, local19 - 1, 2);
				}
				if (arg1 == 3) {
					this.add(local4, local19, 160);
					this.add(local4, local19 - 1, 2);
					this.add(local4 - 1, local19, 8);
				}
			}
			if (arg4) {
				if (arg5 == 0) {
					if (arg1 == 0) {
						this.add(local4, local19, 65536);
						this.add(local4 - 1, local19, 4096);
					}
					if (arg1 == 1) {
						this.add(local4, local19, 1024);
						this.add(local4, local19 + 1, 16384);
					}
					if (arg1 == 2) {
						this.add(local4, local19, 4096);
						this.add(local4 + 1, local19, 65536);
					}
					if (arg1 == 3) {
						this.add(local4, local19, 16384);
						this.add(local4, local19 - 1, 1024);
					}
				}
				if (arg5 == 1 || arg5 == 3) {
					if (arg1 == 0) {
						this.add(local4, local19, 512);
						this.add(local4 - 1, local19 + 1, 8192);
					}
					if (arg1 == 1) {
						this.add(local4, local19, 2048);
						this.add(local4 + 1, local19 + 1, 32768);
					}
					if (arg1 == 2) {
						this.add(local4, local19, 8192);
						this.add(local4 + 1, local19 - 1, 512);
					}
					if (arg1 == 3) {
						this.add(local4, local19, 32768);
						this.add(local4 - 1, local19 - 1, 2048);
					}
				}
				if (arg5 == 2) {
					if (arg1 == 0) {
						this.add(local4, local19, 66560);
						this.add(local4 - 1, local19, 4096);
						this.add(local4, local19 + 1, 16384);
					}
					if (arg1 == 1) {
						this.add(local4, local19, 5120);
						this.add(local4, local19 + 1, 16384);
						this.add(local4 + 1, local19, 65536);
					}
					if (arg1 == 2) {
						this.add(local4, local19, 20480);
						this.add(local4 + 1, local19, 65536);
						this.add(local4, local19 - 1, 1024);
					}
					if (arg1 == 3) {
						this.add(local4, local19, 81920);
						this.add(local4, local19 - 1, 1024);
						this.add(local4 - 1, local19, 4096);
						return;
					}
				}
			}
		} catch (@Pc(471) RuntimeException local471) {
			signlink.reporterror("61774, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local471.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIIZ)V")
	public void addLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) boolean arg6) {
		try {
			@Pc(3) int local3 = 256;
			if (arg6) {
				local3 += 131072;
			}
			@Pc(14) int local14 = arg3 - this.offsetX;
			@Pc(19) int local19 = arg5 - this.offsetZ;
			@Pc(27) int local27;
			if (arg0 == 1 || arg0 == 3) {
				local27 = arg2;
				arg2 = arg1;
				arg1 = local27;
			}
			@Pc(43) int local43;
			for (local27 = local14; local27 < local14 + arg2; local27++) {
				if (local27 >= 0 && local27 < this.sizeX) {
					for (local43 = local19; local43 < local19 + arg1; local43++) {
						if (local43 >= 0 && local43 < this.sizeZ) {
							this.add(local27, local43, local3);
						}
					}
				}
			}
			if (arg4 != 9) {
				for (local43 = 1; local43 > 0; local43++) {
				}
			}
		} catch (@Pc(80) RuntimeException local80) {
			signlink.reporterror("17129, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local80.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(BII)V")
	public void setBlocked(@OriginalArg(0) byte arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg0 == this.flowObfuscator3) {
				@Pc(9) int local9 = arg2 - this.offsetX;
				@Pc(14) int local14 = arg1 - this.offsetZ;
				this.flags[local9][local14] |= 0x200000;
			}
		} catch (@Pc(26) RuntimeException local26) {
			signlink.reporterror("23195, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local26.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(III)V")
	private void add(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		this.flags[arg0][arg1] |= arg2;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(ZIIIII)V")
	public void removeWall(@OriginalArg(0) boolean arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		try {
			@Pc(3) int local3 = 9 / arg4;
			@Pc(8) int local8 = arg2 - this.offsetX;
			@Pc(13) int local13 = arg3 - this.offsetZ;
			if (arg5 == 0) {
				if (arg1 == 0) {
					this.remove(local13, (byte) -9, local8, 128);
					this.remove(local13, (byte) -9, local8 - 1, 8);
				}
				if (arg1 == 1) {
					this.remove(local13, (byte) -9, local8, 2);
					this.remove(local13 + 1, (byte) -9, local8, 32);
				}
				if (arg1 == 2) {
					this.remove(local13, (byte) -9, local8, 8);
					this.remove(local13, (byte) -9, local8 + 1, 128);
				}
				if (arg1 == 3) {
					this.remove(local13, (byte) -9, local8, 32);
					this.remove(local13 - 1, (byte) -9, local8, 2);
				}
			}
			if (arg5 == 1 || arg5 == 3) {
				if (arg1 == 0) {
					this.remove(local13, (byte) -9, local8, 1);
					this.remove(local13 + 1, (byte) -9, local8 - 1, 16);
				}
				if (arg1 == 1) {
					this.remove(local13, (byte) -9, local8, 4);
					this.remove(local13 + 1, (byte) -9, local8 + 1, 64);
				}
				if (arg1 == 2) {
					this.remove(local13, (byte) -9, local8, 16);
					this.remove(local13 - 1, (byte) -9, local8 + 1, 1);
				}
				if (arg1 == 3) {
					this.remove(local13, (byte) -9, local8, 64);
					this.remove(local13 - 1, (byte) -9, local8 - 1, 4);
				}
			}
			if (arg5 == 2) {
				if (arg1 == 0) {
					this.remove(local13, (byte) -9, local8, 130);
					this.remove(local13, (byte) -9, local8 - 1, 8);
					this.remove(local13 + 1, (byte) -9, local8, 32);
				}
				if (arg1 == 1) {
					this.remove(local13, (byte) -9, local8, 10);
					this.remove(local13 + 1, (byte) -9, local8, 32);
					this.remove(local13, (byte) -9, local8 + 1, 128);
				}
				if (arg1 == 2) {
					this.remove(local13, (byte) -9, local8, 40);
					this.remove(local13, (byte) -9, local8 + 1, 128);
					this.remove(local13 - 1, (byte) -9, local8, 2);
				}
				if (arg1 == 3) {
					this.remove(local13, (byte) -9, local8, 160);
					this.remove(local13 - 1, (byte) -9, local8, 2);
					this.remove(local13, (byte) -9, local8 - 1, 8);
				}
			}
			if (arg0) {
				if (arg5 == 0) {
					if (arg1 == 0) {
						this.remove(local13, (byte) -9, local8, 65536);
						this.remove(local13, (byte) -9, local8 - 1, 4096);
					}
					if (arg1 == 1) {
						this.remove(local13, (byte) -9, local8, 1024);
						this.remove(local13 + 1, (byte) -9, local8, 16384);
					}
					if (arg1 == 2) {
						this.remove(local13, (byte) -9, local8, 4096);
						this.remove(local13, (byte) -9, local8 + 1, 65536);
					}
					if (arg1 == 3) {
						this.remove(local13, (byte) -9, local8, 16384);
						this.remove(local13 - 1, (byte) -9, local8, 1024);
					}
				}
				if (arg5 == 1 || arg5 == 3) {
					if (arg1 == 0) {
						this.remove(local13, (byte) -9, local8, 512);
						this.remove(local13 + 1, (byte) -9, local8 - 1, 8192);
					}
					if (arg1 == 1) {
						this.remove(local13, (byte) -9, local8, 2048);
						this.remove(local13 + 1, (byte) -9, local8 + 1, 32768);
					}
					if (arg1 == 2) {
						this.remove(local13, (byte) -9, local8, 8192);
						this.remove(local13 - 1, (byte) -9, local8 + 1, 512);
					}
					if (arg1 == 3) {
						this.remove(local13, (byte) -9, local8, 32768);
						this.remove(local13 - 1, (byte) -9, local8 - 1, 2048);
					}
				}
				if (arg5 == 2) {
					if (arg1 == 0) {
						this.remove(local13, (byte) -9, local8, 66560);
						this.remove(local13, (byte) -9, local8 - 1, 4096);
						this.remove(local13 + 1, (byte) -9, local8, 16384);
					}
					if (arg1 == 1) {
						this.remove(local13, (byte) -9, local8, 5120);
						this.remove(local13 + 1, (byte) -9, local8, 16384);
						this.remove(local13, (byte) -9, local8 + 1, 65536);
					}
					if (arg1 == 2) {
						this.remove(local13, (byte) -9, local8, 20480);
						this.remove(local13, (byte) -9, local8 + 1, 65536);
						this.remove(local13 - 1, (byte) -9, local8, 1024);
					}
					if (arg1 == 3) {
						this.remove(local13, (byte) -9, local8, 81920);
						this.remove(local13 - 1, (byte) -9, local8, 1024);
						this.remove(local13, (byte) -9, local8 - 1, 4096);
						return;
					}
				}
			}
		} catch (@Pc(521) RuntimeException local521) {
			signlink.reporterror("76395, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + local521.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIZZI)V")
	public void removeLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) boolean arg4, @OriginalArg(5) boolean arg5, @OriginalArg(6) int arg6) {
		try {
			@Pc(3) int local3 = 256;
			if (arg5) {
				local3 += 131072;
			}
			@Pc(14) int local14 = arg1 - this.offsetX;
			@Pc(19) int local19 = arg0 - this.offsetZ;
			if (!arg4) {
				this.flowObfuscator2 = 67;
			}
			@Pc(32) int local32;
			if (arg2 == 1 || arg2 == 3) {
				local32 = arg3;
				arg3 = arg6;
				arg6 = local32;
			}
			for (local32 = local14; local32 < local14 + arg3; local32++) {
				if (local32 >= 0 && local32 < this.sizeX) {
					for (@Pc(48) int local48 = local19; local48 < local19 + arg6; local48++) {
						if (local48 >= 0 && local48 < this.sizeZ) {
							this.remove(local48, (byte) -9, local32, local3);
						}
					}
				}
			}
		} catch (@Pc(76) RuntimeException local76) {
			signlink.reporterror("21118, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local76.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IBII)V")
	private void remove(@OriginalArg(0) int arg0, @OriginalArg(1) byte arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3) {
		try {
			this.flags[arg2][arg0] &= 16777215 - arg3;
			if (arg1 == -9) {
				;
			}
		} catch (@Pc(16) RuntimeException local16) {
			signlink.reporterror("67253, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local16.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "(III)V")
	public void removeBlocked(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg2 == 0) {
				@Pc(7) int local7 = arg1 - this.offsetX;
				@Pc(12) int local12 = arg0 - this.offsetZ;
				this.flags[local7][local12] &= 0xDFFFFF;
			}
		} catch (@Pc(24) RuntimeException local24) {
			signlink.reporterror("3785, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local24.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIII)Z")
	public boolean reachedWall(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			if (arg6 == arg5 && arg4 == arg2) {
				return true;
			}
			@Pc(12) int local12 = arg6 - this.offsetX;
			@Pc(17) int local17 = arg4 - this.offsetZ;
			if (arg0 != -7517) {
				throw new NullPointerException();
			}
			@Pc(29) int local29 = arg5 - this.offsetX;
			@Pc(34) int local34 = arg2 - this.offsetZ;
			if (arg3 == 0) {
				if (arg1 == 0) {
					if (local12 == local29 - 1 && local17 == local34) {
						return true;
					}
					if (local12 == local29 && local17 == local34 + 1 && (this.flags[local12][local17] & 0x280120) == 0) {
						return true;
					}
					if (local12 == local29 && local17 == local34 - 1 && (this.flags[local12][local17] & 0x280102) == 0) {
						return true;
					}
				} else if (arg1 == 1) {
					if (local12 == local29 && local17 == local34 + 1) {
						return true;
					}
					if (local12 == local29 - 1 && local17 == local34 && (this.flags[local12][local17] & 0x280108) == 0) {
						return true;
					}
					if (local12 == local29 + 1 && local17 == local34 && (this.flags[local12][local17] & 0x280180) == 0) {
						return true;
					}
				} else if (arg1 == 2) {
					if (local12 == local29 + 1 && local17 == local34) {
						return true;
					}
					if (local12 == local29 && local17 == local34 + 1 && (this.flags[local12][local17] & 0x280120) == 0) {
						return true;
					}
					if (local12 == local29 && local17 == local34 - 1 && (this.flags[local12][local17] & 0x280102) == 0) {
						return true;
					}
				} else if (arg1 == 3) {
					if (local12 == local29 && local17 == local34 - 1) {
						return true;
					}
					if (local12 == local29 - 1 && local17 == local34 && (this.flags[local12][local17] & 0x280108) == 0) {
						return true;
					}
					if (local12 == local29 + 1 && local17 == local34 && (this.flags[local12][local17] & 0x280180) == 0) {
						return true;
					}
				}
			}
			if (arg3 == 2) {
				if (arg1 == 0) {
					if (local12 == local29 - 1 && local17 == local34) {
						return true;
					}
					if (local12 == local29 && local17 == local34 + 1) {
						return true;
					}
					if (local12 == local29 + 1 && local17 == local34 && (this.flags[local12][local17] & 0x280180) == 0) {
						return true;
					}
					if (local12 == local29 && local17 == local34 - 1 && (this.flags[local12][local17] & 0x280102) == 0) {
						return true;
					}
				} else if (arg1 == 1) {
					if (local12 == local29 - 1 && local17 == local34 && (this.flags[local12][local17] & 0x280108) == 0) {
						return true;
					}
					if (local12 == local29 && local17 == local34 + 1) {
						return true;
					}
					if (local12 == local29 + 1 && local17 == local34) {
						return true;
					}
					if (local12 == local29 && local17 == local34 - 1 && (this.flags[local12][local17] & 0x280102) == 0) {
						return true;
					}
				} else if (arg1 == 2) {
					if (local12 == local29 - 1 && local17 == local34 && (this.flags[local12][local17] & 0x280108) == 0) {
						return true;
					}
					if (local12 == local29 && local17 == local34 + 1 && (this.flags[local12][local17] & 0x280120) == 0) {
						return true;
					}
					if (local12 == local29 + 1 && local17 == local34) {
						return true;
					}
					if (local12 == local29 && local17 == local34 - 1) {
						return true;
					}
				} else if (arg1 == 3) {
					if (local12 == local29 - 1 && local17 == local34) {
						return true;
					}
					if (local12 == local29 && local17 == local34 + 1 && (this.flags[local12][local17] & 0x280120) == 0) {
						return true;
					}
					if (local12 == local29 + 1 && local17 == local34 && (this.flags[local12][local17] & 0x280180) == 0) {
						return true;
					}
					if (local12 == local29 && local17 == local34 - 1) {
						return true;
					}
				}
			}
			if (arg3 == 9) {
				if (local12 == local29 && local17 == local34 + 1 && (this.flags[local12][local17] & 0x20) == 0) {
					return true;
				}
				if (local12 == local29 && local17 == local34 - 1 && (this.flags[local12][local17] & 0x2) == 0) {
					return true;
				}
				if (local12 == local29 - 1 && local17 == local34 && (this.flags[local12][local17] & 0x8) == 0) {
					return true;
				}
				if (local12 == local29 + 1 && local17 == local34 && (this.flags[local12][local17] & 0x80) == 0) {
					return true;
				}
			}
			return false;
		} catch (@Pc(567) RuntimeException local567) {
			signlink.reporterror("67481, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local567.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "(IIIIIII)Z")
	public boolean reachedWallDecoration(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6) {
		try {
			if (arg2 != this.flowObfuscator4) {
				this.flowObfuscator2 = -218;
			}
			if (arg3 == arg4 && arg5 == arg6) {
				return true;
			}
			@Pc(19) int local19 = arg3 - this.offsetX;
			@Pc(24) int local24 = arg5 - this.offsetZ;
			@Pc(29) int local29 = arg4 - this.offsetX;
			@Pc(34) int local34 = arg6 - this.offsetZ;
			if (arg1 == 6 || arg1 == 7) {
				if (arg1 == 7) {
					arg0 = arg0 + 2 & 0x3;
				}
				if (arg0 == 0) {
					if (local19 == local29 + 1 && local24 == local34 && (this.flags[local19][local24] & 0x80) == 0) {
						return true;
					}
					if (local19 == local29 && local24 == local34 - 1 && (this.flags[local19][local24] & 0x2) == 0) {
						return true;
					}
				} else if (arg0 == 1) {
					if (local19 == local29 - 1 && local24 == local34 && (this.flags[local19][local24] & 0x8) == 0) {
						return true;
					}
					if (local19 == local29 && local24 == local34 - 1 && (this.flags[local19][local24] & 0x2) == 0) {
						return true;
					}
				} else if (arg0 == 2) {
					if (local19 == local29 - 1 && local24 == local34 && (this.flags[local19][local24] & 0x8) == 0) {
						return true;
					}
					if (local19 == local29 && local24 == local34 + 1 && (this.flags[local19][local24] & 0x20) == 0) {
						return true;
					}
				} else if (arg0 == 3) {
					if (local19 == local29 + 1 && local24 == local34 && (this.flags[local19][local24] & 0x80) == 0) {
						return true;
					}
					if (local19 == local29 && local24 == local34 + 1 && (this.flags[local19][local24] & 0x20) == 0) {
						return true;
					}
				}
			}
			if (arg1 == 8) {
				if (local19 == local29 && local24 == local34 + 1 && (this.flags[local19][local24] & 0x20) == 0) {
					return true;
				}
				if (local19 == local29 && local24 == local34 - 1 && (this.flags[local19][local24] & 0x2) == 0) {
					return true;
				}
				if (local19 == local29 - 1 && local24 == local34 && (this.flags[local19][local24] & 0x8) == 0) {
					return true;
				}
				if (local19 == local29 + 1 && local24 == local34 && (this.flags[local19][local24] & 0x80) == 0) {
					return true;
				}
			}
			return false;
		} catch (@Pc(294) RuntimeException local294) {
			signlink.reporterror("20247, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + local294.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIIII)Z")
	public boolean reachedLoc(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5, @OriginalArg(6) int arg6, @OriginalArg(7) int arg7) {
		try {
			@Pc(5) int local5 = arg3 + arg6 - 1;
			@Pc(11) int local11 = arg5 + arg1 - 1;
			@Pc(15) int local15 = 17 / arg7;
			if (arg2 >= arg3 && arg2 <= local5 && arg0 >= arg5 && arg0 <= local11) {
				return true;
			} else if (arg2 == arg3 - 1 && arg0 >= arg5 && arg0 <= local11 && (this.flags[arg2 - this.offsetX][arg0 - this.offsetZ] & 0x8) == 0 && (arg4 & 0x8) == 0) {
				return true;
			} else if (arg2 == local5 + 1 && arg0 >= arg5 && arg0 <= local11 && (this.flags[arg2 - this.offsetX][arg0 - this.offsetZ] & 0x80) == 0 && (arg4 & 0x2) == 0) {
				return true;
			} else if (arg0 == arg5 - 1 && arg2 >= arg3 && arg2 <= local5 && (this.flags[arg2 - this.offsetX][arg0 - this.offsetZ] & 0x2) == 0 && (arg4 & 0x4) == 0) {
				return true;
			} else {
				return arg0 == local11 + 1 && arg2 >= arg3 && arg2 <= local5 && (this.flags[arg2 - this.offsetX][arg0 - this.offsetZ] & 0x20) == 0 && (arg4 & 0x1) == 0;
			}
		} catch (@Pc(160) RuntimeException local160) {
			signlink.reporterror("71488, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + arg4 + ", " + arg5 + ", " + arg6 + ", " + arg7 + ", " + local160.toString());
			throw new RuntimeException();
		}
	}
}
