package jagex2.dash3d;

import jagex2.config.LocType;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!ec")
public class CollisionMap {

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
					this.flags[x][z] = 0xFFFFFF;
				} else {
					this.flags[x][z] = 0;
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(ZIIIZI)V")
	public void addWall(@OriginalArg(3) int tileX, @OriginalArg(2) int tileZ, @OriginalArg(5) int shape, @OriginalArg(1) int rotation, @OriginalArg(4) boolean blockrange) {
		@Pc(4) int x = tileX - this.offsetX;
		@Pc(19) int z = tileZ - this.offsetZ;

		if (shape == LocType.WALL_STRAIGHT) {
			if (rotation == 0) {
				this.add(x, z, 0x80);
				this.add(x - 1, z, 0x8);
			} else if (rotation == 1) {
				this.add(x, z, 0x2);
				this.add(x, z + 1, 0x20);
			} else if (rotation == 2) {
				this.add(x, z, 0x8);
				this.add(x + 1, z, 0x80);
			} else if (rotation == 3) {
				this.add(x, z, 32);
				this.add(x, z - 1, 0x2);
			}
		} else if (shape == LocType.WALL_DIAGONALCORNER || shape == LocType.WALL_SQUARECORNER) {
			if (rotation == 0) {
				this.add(x, z, 0x1);
				this.add(x - 1, z + 1, 0x10);
			} else if (rotation == 1) {
				this.add(x, z, 0x4);
				this.add(x + 1, z + 1, 0x40);
			} else if (rotation == 2) {
				this.add(x, z, 0x10);
				this.add(x + 1, z - 1, 0x1);
			} else if (rotation == 3) {
				this.add(x, z, 64);
				this.add(x - 1, z - 1, 0x4);
			}
		} else if (shape == LocType.WALL_L) {
			if (rotation == 0) {
				this.add(x, z, 0x82);
				this.add(x - 1, z, 0x8);
				this.add(x, z + 1, 0x20);
			} else if (rotation == 1) {
				this.add(x, z, 0xA);
				this.add(x, z + 1, 0x20);
				this.add(x + 1, z, 0x80);
			} else if (rotation == 2) {
				this.add(x, z, 0x28);
				this.add(x + 1, z, 0x80);
				this.add(x, z - 1, 0x2);
			} else if (rotation == 3) {
				this.add(x, z, 0xA0);
				this.add(x, z - 1, 0x2);
				this.add(x - 1, z, 0x8);
			}
		}

		if (blockrange) {
			if (shape == LocType.WALL_STRAIGHT) {
				if (rotation == 0) {
					this.add(x, z, 0x10000);
					this.add(x - 1, z, 0x1000);
				} else if (rotation == 1) {
					this.add(x, z, 0x400);
					this.add(x, z + 1, 0x4000);
				} else if (rotation == 2) {
					this.add(x, z, 0x1000);
					this.add(x + 1, z, 0x10000);
				} else if (rotation == 3) {
					this.add(x, z, 0x4000);
					this.add(x, z - 1, 0x400);
				}
			} else if (shape == LocType.WALL_DIAGONAL || shape == LocType.WALL_SQUARECORNER) {
				if (rotation == 0) {
					this.add(x, z, 0x200);
					this.add(x - 1, z + 1, 0x2000);
				} else if (rotation == 1) {
					this.add(x, z, 0x800);
					this.add(x + 1, z + 1, 0x8000);
				} else if (rotation == 2) {
					this.add(x, z, 0x2000);
					this.add(x + 1, z - 1, 0x200);
				} else if (rotation == 3) {
					this.add(x, z, 0x8000);
					this.add(x - 1, z - 1, 0x800);
				}
			} else if (shape == LocType.WALL_L) {
				if (rotation == 0) {
					this.add(x, z, 0x10400);
					this.add(x - 1, z, 0x1000);
					this.add(x, z + 1, 0x4000);
				} else if (rotation == 1) {
					this.add(x, z, 0x1400);
					this.add(x, z + 1, 0x4000);
					this.add(x + 1, z, 0x10000);
				} else if (rotation == 2) {
					this.add(x, z, 0x5000);
					this.add(x + 1, z, 0x10000);
					this.add(x, z - 1, 0x400);
				} else if (rotation == 3) {
					this.add(x, z, 0x14000);
					this.add(x, z - 1, 0x400);
					this.add(x - 1, z, 0x1000);
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIIZ)V")
	public void addLoc(@OriginalArg(3) int tileX, @OriginalArg(5) int tileZ, @OriginalArg(2) int sizeX, @OriginalArg(1) int sizeZ, @OriginalArg(0) int rotation, @OriginalArg(6) boolean blockrange) {
		@Pc(3) int flags = 0x100;
		if (blockrange) {
			flags += 0x20000;
		}

		@Pc(14) int x = tileX - this.offsetX;
		@Pc(19) int z = tileZ - this.offsetZ;

		if (rotation == 1 || rotation == 3) {
			int tmp = sizeX;
			sizeX = sizeZ;
			sizeZ = tmp;
		}

		for (int tx = x; tx < x + sizeX; tx++) {
			if (tx < 0 || tx >= this.sizeX) {
				continue;
			}

			for (int tz = z; tz < z + sizeZ; tz++) {
				if (tz < 0 || tz >= this.sizeZ) {
					continue;
				}

				this.add(tx, tz, flags);
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(BII)V")
	public void setBlocked(@OriginalArg(2) int tileX, @OriginalArg(1) int tileZ) {
		@Pc(9) int x = tileX - this.offsetX;
		@Pc(14) int z = tileZ - this.offsetZ;
		this.flags[x][z] |= 0x200000;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(III)V")
	private void add(@OriginalArg(0) int x, @OriginalArg(1) int z, @OriginalArg(2) int flags) {
		this.flags[x][z] |= flags;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(ZIIIII)V")
	public void removeWall(@OriginalArg(2) int tileX, @OriginalArg(3) int tileZ, @OriginalArg(5) int shape, @OriginalArg(1) int rotation, @OriginalArg(0) boolean blockrange) {
		@Pc(8) int x = tileX - this.offsetX;
		@Pc(13) int z = tileZ - this.offsetZ;

		if (shape == LocType.WALL_STRAIGHT) {
			if (rotation == 0) {
				this.remove(x, z, 0x80);
				this.remove(x - 1, z, 0x8);
			} else if (rotation == 1) {
				this.remove(x, z, 0x2);
				this.remove(x, z + 1, 0x20);
			} else if (rotation == 2) {
				this.remove(x, z, 0x8);
				this.remove(x + 1, z, 0x80);
			} else if (rotation == 3) {
				this.remove(x, z, 0x20);
				this.remove(x, z - 1, 0x2);
			}
		} else if (shape == LocType.WALL_DIAGONALCORNER || shape == LocType.WALL_SQUARECORNER) {
			if (rotation == 0) {
				this.remove(x, z, 0x1);
				this.remove(x - 1, z + 1, 0x10);
			} else if (rotation == 1) {
				this.remove(x, z, 0x4);
				this.remove(x + 1, z + 1, 0x40);
			} else if (rotation == 2) {
				this.remove(x, z, 0x10);
				this.remove(x + 1, z - 1, 0x1);
			} else if (rotation == 3) {
				this.remove(x, z, 0x40);
				this.remove(x - 1, z - 1, 0x4);
			}
		} else if (shape == LocType.WALL_L) {
			if (rotation == 0) {
				this.remove(x, z, 0x82);
				this.remove(x - 1, z, 0x8);
				this.remove(x, z + 1, 0x20);
			} else if (rotation == 1) {
				this.remove(x, z, 0xA);
				this.remove(x, z + 1, 0x20);
				this.remove(x + 1, z, 0x80);
			} else if (rotation == 2) {
				this.remove(x, z, 0x28);
				this.remove(x + 1, z, 0x80);
				this.remove(x, z - 1, 0x2);
			} else if (rotation == 3) {
				this.remove(x, z, 0xA0);
				this.remove(x, z - 1, 0x2);
				this.remove(x - 1, z, 0x8);
			}
		}

		if (blockrange) {
			if (shape == LocType.WALL_STRAIGHT) {
				if (rotation == 0) {
					this.remove(x, z, 0x10000);
					this.remove(x - 1, z, 0x1000);
				} else if (rotation == 1) {
					this.remove(x, z, 0x400);
					this.remove(x, z + 1, 0x4000);
				} else if (rotation == 2) {
					this.remove(x, z, 0x1000);
					this.remove(x + 1, z, 0x10000);
				} else if (rotation == 3) {
					this.remove(x, z, 0x4000);
					this.remove(x, z - 1, 0x400);
				}
			} else if (shape == LocType.WALL_DIAGONALCORNER || shape == LocType.WALL_SQUARECORNER) {
				if (rotation == 0) {
					this.remove(x, z, 0x200);
					this.remove(x - 1, z + 1, 0x2000);
				} else if (rotation == 1) {
					this.remove(x, z, 0x800);
					this.remove(x + 1, z + 1, 0x8000);
				} else if (rotation == 2) {
					this.remove(x, z, 0x2000);
					this.remove(x + 1, z - 1, 0x200);
				} else if (rotation == 3) {
					this.remove(x, z, 0x8000);
					this.remove(x - 1, z - 1, 0x800);
				}
			} else if (shape == LocType.WALL_L) {
				if (rotation == 0) {
					this.remove(x, z, 0x10400);
					this.remove(x - 1, z, 0x1000);
					this.remove(x, z + 1, 0x4000);
				} else if (rotation == 1) {
					this.remove(x, z, 0x1400);
					this.remove(x, z + 1, 0x4000);
					this.remove(x + 1, z, 0x10000);
				} else if (rotation == 2) {
					this.remove(x, z, 0x5000);
					this.remove(x + 1, z, 0x10000);
					this.remove(x, z - 1, 0x400);
				} else if (rotation == 3) {
					this.remove(x, z, 0x14000);
					this.remove(x, z - 1, 0x400);
					this.remove(x - 1, z, 0x1000);
				}
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIZZI)V")
	public void removeLoc(@OriginalArg(1) int tileX, @OriginalArg(0) int tileZ, @OriginalArg(3) int sizeX, @OriginalArg(6) int sizeZ, @OriginalArg(2) int rotation, @OriginalArg(5) boolean blockrange) {
		@Pc(3) int flags = 0x100;
		if (blockrange) {
			flags += 0x20000;
		}

		@Pc(14) int x = tileX - this.offsetX;
		@Pc(19) int z = tileZ - this.offsetZ;

		if (rotation == 1 || rotation == 3) {
			int tmp = sizeX;
			sizeX = sizeZ;
			sizeZ = tmp;
		}

		for (int tx = x; tx < x + sizeX; tx++) {
			if (tx < 0 || tx >= this.sizeX) {
				continue;
			}

			for (@Pc(48) int tz = z; tz < z + sizeZ; tz++) {
				if (tz < 0 || tz >= this.sizeZ) {
					continue;
				}

				this.remove(tx, tz, flags);
			}
		}
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IBII)V")
	private void remove(@OriginalArg(2) int x, @OriginalArg(0) int z, @OriginalArg(3) int flags) {
		this.flags[x][z] &= 0xFFFFFF - flags;
	}

	@OriginalMember(owner = "client!ec", name = "b", descriptor = "(III)V")
	public void removeBlocked(@OriginalArg(1) int tileX, @OriginalArg(0) int tileZ) {
		@Pc(7) int x = tileX - this.offsetX;
		@Pc(12) int z = tileZ - this.offsetZ;
		this.flags[x][z] &= 0xDFFFFF;
	}

	@OriginalMember(owner = "client!ec", name = "a", descriptor = "(IIIIIII)Z")
	public boolean reachedWall(@OriginalArg(6) int sourceX, @OriginalArg(4) int sourceZ, @OriginalArg(5) int destX, @OriginalArg(2) int destZ, @OriginalArg(3) int shape, @OriginalArg(1) int rotation) {
		if (sourceX == destX && sourceZ == destZ) {
			return true;
		}

		@Pc(12) int sx = sourceX - this.offsetX;
		@Pc(17) int sz = sourceZ - this.offsetZ;
		@Pc(29) int dx = destX - this.offsetX;
		@Pc(34) int dz = destZ - this.offsetZ;

		if (shape == LocType.WALL_STRAIGHT) {
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
		} else if (shape == LocType.WALL_L) {
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
		} else if (shape == LocType.WALL_DIAGONAL) {
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
	public boolean reachedWallDecoration(@OriginalArg(3) int sourceX, @OriginalArg(5) int sourceZ, @OriginalArg(4) int destX, @OriginalArg(6) int destZ, @OriginalArg(1) int shape, @OriginalArg(0) int rotation) {
		if (sourceX == destX && sourceZ == destZ) {
			return true;
		}

		@Pc(19) int sx = sourceX - this.offsetX;
		@Pc(24) int sz = sourceZ - this.offsetZ;
		@Pc(29) int dx = destX - this.offsetX;
		@Pc(34) int dz = destZ - this.offsetZ;

		if (shape == LocType.WALLDECOR_DIAGONAL_NOOFFSET || shape == LocType.WALLDECOR_DIAGONAL_OFFSET) {
			if (shape == LocType.WALLDECOR_DIAGONAL_OFFSET) {
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
		} else if (shape == LocType.WALLDECOR_DIAGONAL_BOTH) {
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
	public boolean reachedLoc(@OriginalArg(2) int srcX, @OriginalArg(0) int srcZ, @OriginalArg(3) int dstX, @OriginalArg(5) int dstZ, @OriginalArg(6) int dstSizeX, @OriginalArg(1) int dstSizeZ, @OriginalArg(4) int forceapproach) {
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
