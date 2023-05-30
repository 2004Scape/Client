package jagex2.dash3d;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ec")
public final class CollisionMap {

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
	public CollisionMap(@OriginalArg(0) int sizeX, @OriginalArg(2) int sizeZ) {
		this.offsetX = 0;
		this.offsetZ = 0;
		this.sizeX = sizeX;
		this.sizeZ = sizeZ;
		this.flags = new int[this.sizeX][this.sizeZ];
		this.reset();
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(B)V")
	public void reset() {
		for (@Pc(3) int x = 0; x < this.sizeX; x++) {
			for (@Pc(7) int z = 0; z < this.sizeZ; z++) {
				if (x == 0 || z == 0 || x == this.sizeX - 1 || z == this.sizeZ - 1) {
					this.flags[x][z] = 0xffffff;
				} else {
					this.flags[x][z] = 0;
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(ZIIIZI)V")
	public void addWall(@OriginalArg(1) int rotation, @OriginalArg(2) int tileZ, @OriginalArg(3) int tileX, @OriginalArg(4) boolean blockrange, @OriginalArg(5) int type) {
		@Pc(4) int x = tileX - this.offsetX;
		@Pc(19) int z = tileZ - this.offsetZ;

		if (type == 0) {
			if (rotation == 0) {
				this.add(x, z, 128);
				this.add(x - 1, z, 8);
			} else if (rotation == 1) {
				this.add(x, z, 2);
				this.add(x, z + 1, 32);
			} else if (rotation == 2) {
				this.add(x, z, 8);
				this.add(x + 1, z, 128);
			} else if (rotation == 3) {
				this.add(x, z, 32);
				this.add(x, z - 1, 2);
			}
		} else if (type == 1 || type == 3) {
			if (rotation == 0) {
				this.add(x, z, 1);
				this.add(x - 1, z + 1, 16);
			} else if (rotation == 1) {
				this.add(x, z, 4);
				this.add(x + 1, z + 1, 64);
			} else if (rotation == 2) {
				this.add(x, z, 16);
				this.add(x + 1, z - 1, 1);
			} else if (rotation == 3) {
				this.add(x, z, 64);
				this.add(x - 1, z - 1, 4);
			}
		} else if (type == 2) {
			if (rotation == 0) {
				this.add(x, z, 130);
				this.add(x - 1, z, 8);
				this.add(x, z + 1, 32);
			} else if (rotation == 1) {
				this.add(x, z, 10);
				this.add(x, z + 1, 32);
				this.add(x + 1, z, 128);
			} else if (rotation == 2) {
				this.add(x, z, 40);
				this.add(x + 1, z, 128);
				this.add(x, z - 1, 2);
			} else if (rotation == 3) {
				this.add(x, z, 160);
				this.add(x, z - 1, 2);
				this.add(x - 1, z, 8);
			}
		}

		if (blockrange) {
			if (type == 0) {
				if (rotation == 0) {
					this.add(x, z, 65536);
					this.add(x - 1, z, 4096);
				} else if (rotation == 1) {
					this.add(x, z, 1024);
					this.add(x, z + 1, 16384);
				} else if (rotation == 2) {
					this.add(x, z, 4096);
					this.add(x + 1, z, 65536);
				} else if (rotation == 3) {
					this.add(x, z, 16384);
					this.add(x, z - 1, 1024);
				}
			} else if (type == 1 || type == 3) {
				if (rotation == 0) {
					this.add(x, z, 512);
					this.add(x - 1, z + 1, 8192);
				} else if (rotation == 1) {
					this.add(x, z, 2048);
					this.add(x + 1, z + 1, 32768);
				} else if (rotation == 2) {
					this.add(x, z, 8192);
					this.add(x + 1, z - 1, 512);
				} else if (rotation == 3) {
					this.add(x, z, 32768);
					this.add(x - 1, z - 1, 2048);
				}
			} else if (type == 2) {
				if (rotation == 0) {
					this.add(x, z, 66560);
					this.add(x - 1, z, 4096);
					this.add(x, z + 1, 16384);
				} else if (rotation == 1) {
					this.add(x, z, 5120);
					this.add(x, z + 1, 16384);
					this.add(x + 1, z, 65536);
				} else if (rotation == 2) {
					this.add(x, z, 20480);
					this.add(x + 1, z, 65536);
					this.add(x, z - 1, 1024);
				} else if (rotation == 3) {
					this.add(x, z, 81920);
					this.add(x, z - 1, 1024);
					this.add(x - 1, z, 4096);
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIIZ)V")
	public void addLoc(@OriginalArg(0) int rotation, @OriginalArg(1) int sizeZ, @OriginalArg(2) int sizeX, @OriginalArg(3) int tileX, @OriginalArg(5) int tileZ, @OriginalArg(6) boolean blockrange) {
		@Pc(3) int flags = 256;
		if (blockrange) {
			flags += 131072;
		}

		@Pc(14) int x = tileX - this.offsetX;
		@Pc(19) int z = tileZ - this.offsetZ;

		if (rotation == 1 || rotation == 3) {
			int tmp = sizeX;
			sizeX = sizeZ;
			sizeZ = tmp;
		}

		for (int tx = x; tx < x + sizeX; tx++) {
			if (tx >= 0 && tx < this.sizeX) {
				for (int tz = z; tz < z + sizeZ; tz++) {
					if (tz >= 0 && tz < this.sizeZ) {
						this.add(tx, tz, flags);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(BII)V")
	public void setBlocked(@OriginalArg(1) int tileZ, @OriginalArg(2) int tileX) {
		@Pc(9) int x = tileX - this.offsetX;
		@Pc(14) int z = tileZ - this.offsetZ;
		this.flags[x][z] |= 0x200000;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(III)V")
	private void add(@OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(2) int flags) {
		this.flags[x][z] |= flags;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(ZIIIII)V")
	public void removeWall(@OriginalArg(0) boolean blockrange, @OriginalArg(1) int rotation, @OriginalArg(2) int tileX, @OriginalArg(3) int tileZ, @OriginalArg(5) int type) {
		@Pc(8) int x = tileX - this.offsetX;
		@Pc(13) int z = tileZ - this.offsetZ;

		if (type == 0) {
			if (rotation == 0) {
				this.remove(z, x, 128);
				this.remove(z, x - 1, 8);
			} else if (rotation == 1) {
				this.remove(z, x, 2);
				this.remove(z + 1, x, 32);
			} else if (rotation == 2) {
				this.remove(z, x, 8);
				this.remove(z, x + 1, 128);
			} else if (rotation == 3) {
				this.remove(z, x, 32);
				this.remove(z - 1, x, 2);
			}
		} else if (type == 1 || type == 3) {
			if (rotation == 0) {
				this.remove(z, x, 1);
				this.remove(z + 1, x - 1, 16);
			} else if (rotation == 1) {
				this.remove(z, x, 4);
				this.remove(z + 1, x + 1, 64);
			} else if (rotation == 2) {
				this.remove(z, x, 16);
				this.remove(z - 1, x + 1, 1);
			} else if (rotation == 3) {
				this.remove(z, x, 64);
				this.remove(z - 1, x - 1, 4);
			}
		} else if (type == 2) {
			if (rotation == 0) {
				this.remove(z, x, 130);
				this.remove(z, x - 1, 8);
				this.remove(z + 1, x, 32);
			} else if (rotation == 1) {
				this.remove(z, x, 10);
				this.remove(z + 1, x, 32);
				this.remove(z, x + 1, 128);
			} else if (rotation == 2) {
				this.remove(z, x, 40);
				this.remove(z, x + 1, 128);
				this.remove(z - 1, x, 2);
			} else if (rotation == 3) {
				this.remove(z, x, 160);
				this.remove(z - 1, x, 2);
				this.remove(z, x - 1, 8);
			}
		}

		if (blockrange) {
			if (type == 0) {
				if (rotation == 0) {
					this.remove(z, x, 65536);
					this.remove(z, x - 1, 4096);
				} else if (rotation == 1) {
					this.remove(z, x, 1024);
					this.remove(z + 1, x, 16384);
				} else if (rotation == 2) {
					this.remove(z, x, 4096);
					this.remove(z, x + 1, 65536);
				} else if (rotation == 3) {
					this.remove(z, x, 16384);
					this.remove(z - 1, x, 1024);
				}
			} else if (type == 1 || type == 3) {
				if (rotation == 0) {
					this.remove(z, x, 512);
					this.remove(z + 1, x - 1, 8192);
				} else if (rotation == 1) {
					this.remove(z, x, 2048);
					this.remove(z + 1, x + 1, 32768);
				} else if (rotation == 2) {
					this.remove(z, x, 8192);
					this.remove(z - 1, x + 1, 512);
				} else if (rotation == 3) {
					this.remove(z, x, 32768);
					this.remove(z - 1, x - 1, 2048);
				}
			} else if (type == 2) {
				if (rotation == 0) {
					this.remove(z, x, 66560);
					this.remove(z, x - 1, 4096);
					this.remove(z + 1, x, 16384);
				} else if (rotation == 1) {
					this.remove(z, x, 5120);
					this.remove(z + 1, x, 16384);
					this.remove(z, x + 1, 65536);
				} else if (rotation == 2) {
					this.remove(z, x, 20480);
					this.remove(z, x + 1, 65536);
					this.remove(z - 1, x, 1024);
				} else if (rotation == 3) {
					this.remove(z, x, 81920);
					this.remove(z - 1, x, 1024);
					this.remove(z, x - 1, 4096);
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIZZI)V")
	public void removeLoc(@OriginalArg(0) int tileZ, @OriginalArg(1) int tileX, @OriginalArg(2) int rotation, @OriginalArg(3) int sizeX, @OriginalArg(5) boolean blockrange, @OriginalArg(6) int sizeZ) {
		@Pc(3) int flags = 256;
		if (blockrange) {
			flags += 131072;
		}

		@Pc(14) int x = tileX - this.offsetX;
		@Pc(19) int z = tileZ - this.offsetZ;

		if (rotation == 1 || rotation == 3) {
			int tmp = sizeX;
			sizeX = sizeZ;
			sizeZ = tmp;
		}

		for (int tx = x; tx < x + sizeX; tx++) {
			if (tx >= 0 && tx < this.sizeX) {
				for (@Pc(48) int tz = z; tz < z + sizeZ; tz++) {
					if (tz >= 0 && tz < this.sizeZ) {
						this.remove(tz, tx, flags);
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IBII)V")
	private void remove(@OriginalArg(0) int z, @OriginalArg(2) int x, @OriginalArg(3) int flags) {
		this.flags[x][z] &= 16777215 - flags;
	}

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "(III)V")
	public void removeBlocked(@OriginalArg(0) int tileZ, @OriginalArg(1) int tileX) {
		@Pc(7) int x = tileX - this.offsetX;
		@Pc(12) int z = tileZ - this.offsetZ;
		this.flags[x][z] &= 0xDFFFFF;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIII)Z")
	public boolean reachedWall(@OriginalArg(1) int rotation, @OriginalArg(2) int destZ, @OriginalArg(3) int type, @OriginalArg(4) int sourceZ, @OriginalArg(5) int destX, @OriginalArg(6) int sourceX) {
		if (sourceX == destX && sourceZ == destZ) {
			return true;
		}

		@Pc(12) int sx = sourceX - this.offsetX;
		@Pc(17) int sz = sourceZ - this.offsetZ;
		@Pc(29) int dx = destX - this.offsetX;
		@Pc(34) int dz = destZ - this.offsetZ;

		if (type == 0) {
			if (rotation == 0) {
				if (sx == dx - 1 && sz == dz) {
					return true;
				} else if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x280120) == 0) {
					return true;
				} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x280102) == 0) {
					return true;
				}
			} else if (rotation == 1) {
				if (sx == dx && sz == dz + 1) {
					return true;
				} else if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x280108) == 0) {
					return true;
				} else if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x280180) == 0) {
					return true;
				}
			} else if (rotation == 2) {
				if (sx == dx + 1 && sz == dz) {
					return true;
				} else if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x280120) == 0) {
					return true;
				} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x280102) == 0) {
					return true;
				}
			} else if (rotation == 3) {
				if (sx == dx && sz == dz - 1) {
					return true;
				} else if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x280108) == 0) {
					return true;
				} else if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x280180) == 0) {
					return true;
				}
			}
		} else if (type == 2) {
			if (rotation == 0) {
				if (sx == dx - 1 && sz == dz) {
					return true;
				} else if (sx == dx && sz == dz + 1) {
					return true;
				} else if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x280180) == 0) {
					return true;
				} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x280102) == 0) {
					return true;
				}
			} else if (rotation == 1) {
				if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x280108) == 0) {
					return true;
				} else if (sx == dx && sz == dz + 1) {
					return true;
				} else if (sx == dx + 1 && sz == dz) {
					return true;
				} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x280102) == 0) {
					return true;
				}
			} else if (rotation == 2) {
				if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x280108) == 0) {
					return true;
				} else if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x280120) == 0) {
					return true;
				} else if (sx == dx + 1 && sz == dz) {
					return true;
				} else if (sx == dx && sz == dz - 1) {
					return true;
				}
			} else if (rotation == 3) {
				if (sx == dx - 1 && sz == dz) {
					return true;
				} else if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x280120) == 0) {
					return true;
				} else if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x280180) == 0) {
					return true;
				} else if (sx == dx && sz == dz - 1) {
					return true;
				}
			}
		} else if (type == 9) {
			if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x20) == 0) {
				return true;
			} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x2) == 0) {
				return true;
			} else if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x8) == 0) {
				return true;
			} else if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x80) == 0) {
				return true;
			}
		}

		return false;
	}

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "(IIIIIII)Z")
	public boolean reachedWallDecoration(@OriginalArg(0) int rotation, @OriginalArg(1) int type, @OriginalArg(3) int sourceX, @OriginalArg(4) int destX, @OriginalArg(5) int sourceZ, @OriginalArg(6) int destZ) {
		if (sourceX == destX && sourceZ == destZ) {
			return true;
		}

		@Pc(19) int sx = sourceX - this.offsetX;
		@Pc(24) int sz = sourceZ - this.offsetZ;
		@Pc(29) int dx = destX - this.offsetX;
		@Pc(34) int dz = destZ - this.offsetZ;

		if (type == 6 || type == 7) {
			if (type == 7) {
				rotation = rotation + 2 & 0x3;
			}

			if (rotation == 0) {
				if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x80) == 0) {
					return true;
				} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x2) == 0) {
					return true;
				}
			} else if (rotation == 1) {
				if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x8) == 0) {
					return true;
				} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x2) == 0) {
					return true;
				}
			} else if (rotation == 2) {
				if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x8) == 0) {
					return true;
				} else if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x20) == 0) {
					return true;
				}
			} else if (rotation == 3) {
				if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x80) == 0) {
					return true;
				} else if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x20) == 0) {
					return true;
				}
			}
		} else if (type == 8) {
			if (sx == dx && sz == dz + 1 && (this.flags[sx][sz] & 0x20) == 0) {
				return true;
			} else if (sx == dx && sz == dz - 1 && (this.flags[sx][sz] & 0x2) == 0) {
				return true;
			} else if (sx == dx - 1 && sz == dz && (this.flags[sx][sz] & 0x8) == 0) {
				return true;
			} else if (sx == dx + 1 && sz == dz && (this.flags[sx][sz] & 0x80) == 0) {
				return true;
			}
		}

		return false;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIIII)Z")
	public boolean reachedLoc(@OriginalArg(0) int srcZ, @OriginalArg(1) int dstSizeZ, @OriginalArg(2) int srcX, @OriginalArg(3) int dstX, @OriginalArg(4) int forceapproach, @OriginalArg(5) int dstZ, @OriginalArg(6) int dstSizeX) {
		@Pc(5) int maxX = dstX + dstSizeX - 1;
		@Pc(11) int maxZ = dstZ + dstSizeZ - 1;

		if (srcX >= dstX && srcX <= maxX && srcZ >= dstZ && srcZ <= maxZ) {
			return true;
		} else if (srcX == dstX - 1 && srcZ >= dstZ && srcZ <= maxZ && (this.flags[srcX - this.offsetX][srcZ - this.offsetZ] & 0x8) == 0 && (forceapproach & 0x8) == 0) {
			return true;
		} else if (srcX == maxX + 1 && srcZ >= dstZ && srcZ <= maxZ && (this.flags[srcX - this.offsetX][srcZ - this.offsetZ] & 0x80) == 0 && (forceapproach & 0x2) == 0) {
			return true;
		} else if (srcZ == dstZ - 1 && srcX >= dstX && srcX <= maxX && (this.flags[srcX - this.offsetX][srcZ - this.offsetZ] & 0x2) == 0 && (forceapproach & 0x4) == 0) {
			return true;
		} else if (srcZ == maxZ + 1 && srcX >= dstX && srcX <= maxX && (this.flags[srcX - this.offsetX][srcZ - this.offsetZ] & 0x20) == 0 && (forceapproach & 0x1) == 0) {
			return true;
		}

		return false;
	}
}
