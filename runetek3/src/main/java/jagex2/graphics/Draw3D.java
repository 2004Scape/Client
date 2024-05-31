package jagex2.graphics;

import jagex2.io.Jagfile;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("client!gb")
public class Draw3D extends Draw2D {

	@OriginalMember(owner = "client!gb", name = "A", descriptor = "Z")
	public static boolean lowMemory = true;

	@OriginalMember(owner = "client!gb", name = "B", descriptor = "Z")
	public static boolean clipX;

	@OriginalMember(owner = "client!gb", name = "C", descriptor = "Z")
	private static boolean opaque;

	@OriginalMember(owner = "client!gb", name = "D", descriptor = "Z")
	public static boolean jagged = true;

	@OriginalMember(owner = "client!gb", name = "E", descriptor = "I")
	public static int alpha;

	@OriginalMember(owner = "client!gb", name = "F", descriptor = "I")
	public static int centerX;

	@OriginalMember(owner = "client!gb", name = "G", descriptor = "I")
	public static int centerY;

	@OriginalMember(owner = "client!gb", name = "H", descriptor = "[I")
	public static int[] reciprocal15 = new int[512];

	@OriginalMember(owner = "client!gb", name = "I", descriptor = "[I")
	public static int[] reciprocal16 = new int[2048];

	@OriginalMember(owner = "client!gb", name = "J", descriptor = "[I")
	public static int[] sin = new int[2048];

	@OriginalMember(owner = "client!gb", name = "K", descriptor = "[I")
	public static int[] cos = new int[2048];

	@OriginalMember(owner = "client!gb", name = "L", descriptor = "[I")
	public static int[] lineOffset;

	@OriginalMember(owner = "client!gb", name = "M", descriptor = "I")
	private static int textureCount;

	@OriginalMember(owner = "client!gb", name = "N", descriptor = "[Lclient!ib;")
	public static Pix8[] textures = new Pix8[50];

	@OriginalMember(owner = "client!gb", name = "O", descriptor = "[Z")
	private static boolean[] textureTranslucent = new boolean[50];

	@OriginalMember(owner = "client!gb", name = "P", descriptor = "[I")
	private static int[] averageTextureRGB = new int[50];

	@OriginalMember(owner = "client!gb", name = "Q", descriptor = "I")
	private static int poolSize;

	@OriginalMember(owner = "client!gb", name = "R", descriptor = "[[I")
	private static int[][] texelPool;

	@OriginalMember(owner = "client!gb", name = "S", descriptor = "[[I")
	private static int[][] activeTexels = new int[50][];

	@OriginalMember(owner = "client!gb", name = "T", descriptor = "[I")
	public static int[] textureCycle = new int[50];

	@OriginalMember(owner = "client!gb", name = "U", descriptor = "I")
	public static int cycle;

	@OriginalMember(owner = "client!gb", name = "V", descriptor = "[I")
	public static int[] palette = new int[65536];

	@OriginalMember(owner = "client!gb", name = "W", descriptor = "[[I")
	private static int[][] texturePalette = new int[50][];

	static {
		for (@Pc(23) int i = 1; i < 512; i++) {
			reciprocal15[i] = 32768 / i;
		}

		for (@Pc(36) int i = 1; i < 2048; i++) {
			reciprocal16[i] = 65536 / i;
		}

		for (@Pc(49) int i = 0; i < 2048; i++) {
			sin[i] = (int) (Math.sin((double) i * 0.0030679615D) * 65536.0D);
			cos[i] = (int) (Math.cos((double) i * 0.0030679615D) * 65536.0D);
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(Z)V")
	public static void unload() {
		reciprocal15 = null;
		reciprocal16 = null; // original typo: reciprocal15 = null; (yes twice)
		sin = null;
		cos = null;
		lineOffset = null;
		textures = null;
		textureTranslucent = null;
		averageTextureRGB = null;
		texelPool = null;
		activeTexels = null;
		textureCycle = null;
		palette = null;
		texturePalette = null;
	}

	@OriginalMember(owner = "client!gb", name = "c", descriptor = "(I)V")
	public static void init2D() {
		lineOffset = new int[height2d];
		for (int y = 0; y < height2d; y++) {
			lineOffset[y] = width2d * y;
		}
		centerX = width2d / 2;
		centerY = height2d / 2;
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(III)V")
	public static void init3D(@OriginalArg(1) int width, @OriginalArg(0) int height) {
		lineOffset = new int[height];
		for (@Pc(12) int y = 0; y < height; y++) {
			lineOffset[y] = width * y;
		}
		centerX = width / 2;
		centerY = height / 2;
	}

	@OriginalMember(owner = "client!gb", name = "b", descriptor = "(Z)V")
	public static void clearTexels() {
		texelPool = null;
		for (@Pc(6) int i = 0; i < 50; i++) {
			activeTexels[i] = null;
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(II)V")
	public static void initPool(@OriginalArg(0) int size) {
		if (texelPool != null) {
			return;
		}
		poolSize = size;
		if (lowMemory) {
			texelPool = new int[poolSize][16384];
		} else {
			texelPool = new int[poolSize][65536];
		}
		for (int i = 0; i < 50; i++) {
			activeTexels[i] = null;
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(BLclient!ub;)V")
	public static void unpackTextures(@OriginalArg(1) Jagfile jag) {
		textureCount = 0;
		for (@Pc(9) int id = 0; id < 50; id++) {
			try {
				textures[id] = new Pix8(jag, String.valueOf(id), 0);
				if (lowMemory && textures[id].cropW == 128) {
					textures[id].shrink();
				} else {
					textures[id].crop();
				}
				textureCount++;
			} catch (@Pc(47) Exception ex) {
			}
		}
	}

	@OriginalMember(owner = "client!gb", name = "b", descriptor = "(II)I")
	public static int getAverageTextureRGB(@OriginalArg(1) int id) {
		if (averageTextureRGB[id] != 0) {
			return averageTextureRGB[id];
		}

		@Pc(13) int r = 0;
		@Pc(15) int g = 0;
		@Pc(17) int b = 0;
		@Pc(22) int length = texturePalette[id].length;
		for (@Pc(24) int i = 0; i < length; i++) {
            r += (texturePalette[id][i] >> 16) & 0xFF;
            g += (texturePalette[id][i] >> 8) & 0xFF;
			b += texturePalette[id][i] & 0xFF;
		}

		@Pc(80) int rgb = ((r / length) << 16) + ((g / length) << 8) + (b / length);
		rgb = setGamma(rgb, 1.4D);
		if (rgb == 0) {
			rgb = 1;
		}
		averageTextureRGB[id] = rgb;
		return rgb;
	}

	@OriginalMember(owner = "client!gb", name = "c", descriptor = "(II)V")
	public static void pushTexture(@OriginalArg(0) int id) {
		if (activeTexels[id] != null) {
			texelPool[poolSize++] = activeTexels[id];
			activeTexels[id] = null;
		}
	}

	@OriginalMember(owner = "client!gb", name = "d", descriptor = "(I)[I")
	private static int[] getTexels(@OriginalArg(0) int id) {
		textureCycle[id] = cycle++;
		if (activeTexels[id] != null) {
			return activeTexels[id];
		}

		@Pc(27) int[] texels;
		if (poolSize > 0) {
			texels = texelPool[--poolSize];
			texelPool[poolSize] = null;
		} else {
			@Pc(35) int cycle = 0;
			@Pc(37) int selected = -1;
			for (int t = 0; t < textureCount; t++) {
				if (activeTexels[t] != null && (textureCycle[t] < cycle || selected == -1)) {
					cycle = textureCycle[t];
					selected = t;
				}
			}
			texels = activeTexels[selected];
			activeTexels[selected] = null;
		}

		activeTexels[id] = texels;
		@Pc(79) Pix8 texture = textures[id];
		@Pc(83) int[] palette = texturePalette[id];

		if (lowMemory) {
			textureTranslucent[id] = false;
			for (int i = 0; i < 4096; i++) {
				int rgb = texels[i] = palette[texture.pixels[i]] & 0xF8F8FF;
				if (rgb == 0) {
					textureTranslucent[id] = true;
				}
				texels[i + 4096] = rgb - (rgb >>> 3) & 0xF8F8FF;
				texels[i + 8192] = rgb - (rgb >>> 2) & 0xF8F8FF;
				texels[i + 12288] = rgb - (rgb >>> 2) - (rgb >>> 3) & 0xF8F8FF;
			}
		} else {
			if (texture.width == 64) {
				for (int y = 0; y < 128; y++) {
					for (int x = 0; x < 128; x++) {
						texels[x + (y << 7)] = palette[texture.pixels[(x >> 1) + (y >> 1 << 6)]];
					}
				}
			} else {
				for (int i = 0; i < 16384; i++) {
					texels[i] = palette[texture.pixels[i]];
				}
			}

			textureTranslucent[id] = false;
			for (int i = 0; i < 0x4000; i++) {
				texels[i] &= 0xF8F8FF;

				int rgb = texels[i];
				if (rgb == 0) {
					textureTranslucent[id] = true;
				}

                texels[i + 0x4000] = (rgb - (rgb >>> 3)) & 0xF8F8FF;
                texels[i + 0x8000] = (rgb - (rgb >>> 2)) & 0xF8F8FF;
                texels[i + 0xc000] = (rgb - (rgb >>> 2) - (rgb >>> 3)) & 0xF8F8FF;
			}
		}
		return texels;
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(ZD)V")
	public static void setBrightness(@OriginalArg(1) double brightness) {
		@Pc(9) double randomized = brightness + Math.random() * 0.03D - 0.015D;

		@Pc(11) int offset = 0;
		for (@Pc(13) int y = 0; y < 512; y++) {
			@Pc(24) double hue = (double) (y / 8) / 64.0D + 0.0078125D;
			@Pc(33) double saturation = (double) (y & 0x7) / 8.0D + 0.0625D;

			for (@Pc(35) int x = 0; x < 128; x++) {
				@Pc(42) double lightness = (double) x / 128.0D;
				@Pc(44) double r = lightness;
				@Pc(46) double g = lightness;
				@Pc(48) double b = lightness;

				if (saturation != 0.0D) {
					@Pc(62) double q;
					if (lightness < 0.5D) {
						q = lightness * (saturation + 1.0D);
					} else {
						q = lightness + saturation - lightness * saturation;
					}

					@Pc(78) double p = lightness * 2.0D - q;

					@Pc(82) double t = hue + 0.3333333333333333D;
					if (t > 1.0D) {
						t--;
					}

					@Pc(96) double d11 = hue - 0.3333333333333333D;
					if (d11 < 0.0D) {
						d11++;
					}

					if (t * 6.0D < 1.0D) {
						r = p + (q - p) * 6.0D * t;
					} else if (t * 2.0D < 1.0D) {
						r = q;
					} else if (t * 3.0D < 2.0D) {
						r = p + (q - p) * (0.6666666666666666D - t) * 6.0D;
					} else {
						r = p;
					}

					if (hue * 6.0D < 1.0D) {
						g = p + (q - p) * 6.0D * hue;
					} else if (hue * 2.0D < 1.0D) {
						g = q;
					} else if (hue * 3.0D < 2.0D) {
						g = p + (q - p) * (0.6666666666666666D - hue) * 6.0D;
					} else {
						g = p;
					}

					if (d11 * 6.0D < 1.0D) {
						b = p + (q - p) * 6.0D * d11;
					} else if (d11 * 2.0D < 1.0D) {
						b = q;
					} else if (d11 * 3.0D < 2.0D) {
						b = p + (q - p) * (0.6666666666666666D - d11) * 6.0D;
					} else {
						b = p;
					}
				}

				@Pc(259) int intR = (int) (r * 256.0D);
				@Pc(264) int intG = (int) (g * 256.0D);
				@Pc(269) int intB = (int) (b * 256.0D);
				@Pc(279) int rgb = (intR << 16) + (intG << 8) + intB;
				@Pc(283) int rgbAdjusted = setGamma(rgb, randomized);
				palette[offset++] = rgbAdjusted;
			}
		}

		for (@Pc(298) int id = 0; id < 50; id++) {
			if (textures[id] != null) {
				@Pc(309) int[] palette = textures[id].palette;
				texturePalette[id] = new int[palette.length];

				for (@Pc(317) int i = 0; i < palette.length; i++) {
					texturePalette[id][i] = setGamma(palette[i], randomized);
				}
			}
		}

		for (@Pc(344) int id = 0; id < 50; id++) {
			pushTexture(id);
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(ID)I")
	private static int setGamma(@OriginalArg(0) int rgb, @OriginalArg(1) double gamma) {
		@Pc(6) double r = (double) ((rgb >> 16) & 0xFF) / 256.0D;
		@Pc(15) double g = (double) ((rgb >> 8) & 0xFF) / 256.0D;
		@Pc(22) double b = (double) (rgb & 0xFF) / 256.0D;

		@Pc(26) double powR = Math.pow(r, gamma);
		@Pc(30) double powG = Math.pow(g, gamma);
		@Pc(34) double powB = Math.pow(b, gamma);

		@Pc(39) int intR = (int) (powR * 256.0D);
		@Pc(44) int intG = (int) (powG * 256.0D);
		@Pc(49) int intB = (int) (powB * 256.0D);
		return (intR << 16) + (intG << 8) + intB;
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(IIIIIIIII)V")
	public static void fillGouraudTriangle(@OriginalArg(3) int xA, @OriginalArg(4) int xB, @OriginalArg(5) int xC, @OriginalArg(0) int yA, @OriginalArg(1) int yB, @OriginalArg(2) int yC, @OriginalArg(6) int colorA, @OriginalArg(7) int colorB, @OriginalArg(8) int colorC) {
		int dxAB = xB - xA;
		int dyAB = yB - yA;
		int dxAC = xC - xA;
		int dyAC = yC - yA;

		@Pc(3) int xStepAB = 0;
		@Pc(5) int colorStepAB = 0;
		if (yB != yA) {
			xStepAB = (dxAB << 16) / dyAB;
            colorStepAB = ((colorB - colorA) << 15) / dyAB;
		}

		@Pc(30) int xStepBC = 0;
		@Pc(32) int colorStepBC = 0;
		if (yC != yB) {
            xStepBC = ((xC - xB) << 16) / (yC - yB);
            colorStepBC = ((colorC - colorB) << 15) / (yC - yB);
		}

		@Pc(57) int xStepAC = 0;
		@Pc(59) int colorStepAC = 0;
		if (yC != yA) {
            xStepAC = ((xA - xC) << 16) / (yA - yC);
            colorStepAC = ((colorA - colorC) << 15) / (yA - yC);
		}

		// this won't change any rendering, saves not wasting time "drawing" an invalid triangle
		int triangleArea = (dxAB * dyAC) - (dyAB * dxAC);
		if (triangleArea == 0) {
			return;
		}

		if (yA <= yB && yA <= yC) {
			if (yA < bottom) {
				if (yB > bottom) {
					yB = bottom;
				}

				if (yC > bottom) {
					yC = bottom;
				}

				if (yB < yC) {
					xC = xA <<= 16;
					colorC = colorA <<= 15;
					if (yA < 0) {
						xC -= xStepAC * yA;
						xA -= xStepAB * yA;
						colorC -= colorStepAC * yA;
						colorA -= colorStepAB * yA;
						yA = 0;
					}

					xB <<= 16;
					colorB <<= 15;
					if (yB < 0) {
						xB -= xStepBC * yB;
						colorB -= colorStepBC * yB;
						yB = 0;
					}

					if (yA != yB && xStepAC < xStepAB || yA == yB && xStepAC > xStepBC) {
						yC -= yB;
						yB -= yA;
						yA = lineOffset[yA];

						while (--yB >= 0) {
							drawGouraudScanline(xC >> 16, xA >> 16, colorC >> 7, colorA >> 7, data, yA, 0);
							xC += xStepAC;
							xA += xStepAB;
							colorC += colorStepAC;
							colorA += colorStepAB;
							yA += width2d;
						}
						while (--yC >= 0) {
							drawGouraudScanline(xC >> 16, xB >> 16, colorC >> 7, colorB >> 7, data, yA, 0);
							xC += xStepAC;
							xB += xStepBC;
							colorC += colorStepAC;
							colorB += colorStepBC;
							yA += width2d;
						}
					} else {
						yC -= yB;
						yB -= yA;
						yA = lineOffset[yA];

						while (--yB >= 0) {
							drawGouraudScanline(xA >> 16, xC >> 16, colorA >> 7, colorC >> 7, data, yA, 0);
							xC += xStepAC;
							xA += xStepAB;
							colorC += colorStepAC;
							colorA += colorStepAB;
							yA += width2d;
						}
						while (--yC >= 0) {
							drawGouraudScanline(xB >> 16, xC >> 16, colorB >> 7, colorC >> 7, data, yA, 0);
							xC += xStepAC;
							xB += xStepBC;
							colorC += colorStepAC;
							colorB += colorStepBC;
							yA += width2d;
						}
					}
				} else {
					xB = xA <<= 16;
					colorB = colorA <<= 15;
					if (yA < 0) {
						xB -= xStepAC * yA;
						xA -= xStepAB * yA;
						colorB -= colorStepAC * yA;
						colorA -= colorStepAB * yA;
						yA = 0;
					}

					xC <<= 16;
					colorC <<= 15;
					if (yC < 0) {
						xC -= xStepBC * yC;
						colorC -= colorStepBC * yC;
						yC = 0;
					}

					if (yA != yC && xStepAC < xStepAB || yA == yC && xStepBC > xStepAB) {
						yB -= yC;
						yC -= yA;
						yA = lineOffset[yA];

						while (--yC >= 0) {
							drawGouraudScanline(xB >> 16, xA >> 16, colorB >> 7, colorA >> 7, data, yA, 0);
							xB += xStepAC;
							xA += xStepAB;
							colorB += colorStepAC;
							colorA += colorStepAB;
							yA += width2d;
						}
						while (--yB >= 0) {
							drawGouraudScanline(xC >> 16, xA >> 16, colorC >> 7, colorA >> 7, data, yA, 0);
							xC += xStepBC;
							xA += xStepAB;
							colorC += colorStepBC;
							colorA += colorStepAB;
							yA += width2d;
						}
					} else {
						yB -= yC;
						yC -= yA;
						yA = lineOffset[yA];

						while (--yC >= 0) {
							drawGouraudScanline(xA >> 16, xB >> 16, colorA >> 7, colorB >> 7, data, yA, 0);
							xB += xStepAC;
							xA += xStepAB;
							colorB += colorStepAC;
							colorA += colorStepAB;
							yA += width2d;
						}
						while (--yB >= 0) {
							drawGouraudScanline(xA >> 16, xC >> 16, colorA >> 7, colorC >> 7, data, yA, 0);
							xC += xStepBC;
							xA += xStepAB;
							colorC += colorStepBC;
							colorA += colorStepAB;
							yA += width2d;
						}
					}
				}
			}
		} else if (yB <= yC) {
			if (yB < bottom) {
				if (yC > bottom) {
					yC = bottom;
				}

				if (yA > bottom) {
					yA = bottom;
				}

				if (yC < yA) {
					xA = xB <<= 16;
					colorA = colorB <<= 15;
					if (yB < 0) {
						xA -= xStepAB * yB;
						xB -= xStepBC * yB;
						colorA -= colorStepAB * yB;
						colorB -= colorStepBC * yB;
						yB = 0;
					}

					xC <<= 16;
					colorC <<= 15;
					if (yC < 0) {
						xC -= xStepAC * yC;
						colorC -= colorStepAC * yC;
						yC = 0;
					}

					if (yB != yC && xStepAB < xStepBC || yB == yC && xStepAB > xStepAC) {
						yA -= yC;
						yC -= yB;
						yB = lineOffset[yB];

						while (--yC >= 0) {
							drawGouraudScanline(xA >> 16, xB >> 16, colorA >> 7, colorB >> 7, data, yB, 0);
							xA += xStepAB;
							xB += xStepBC;
							colorA += colorStepAB;
							colorB += colorStepBC;
							yB += width2d;
						}
						while (--yA >= 0) {
							drawGouraudScanline(xA >> 16, xC >> 16, colorA >> 7, colorC >> 7, data, yB, 0);
							xA += xStepAB;
							xC += xStepAC;
							colorA += colorStepAB;
							colorC += colorStepAC;
							yB += width2d;
						}
					} else {
						yA -= yC;
						yC -= yB;
						yB = lineOffset[yB];

						while (--yC >= 0) {
							drawGouraudScanline(xB >> 16, xA >> 16, colorB >> 7, colorA >> 7, data, yB, 0);
							xA += xStepAB;
							xB += xStepBC;
							colorA += colorStepAB;
							colorB += colorStepBC;
							yB += width2d;
						}
						while (--yA >= 0) {
							drawGouraudScanline(xC >> 16, xA >> 16, colorC >> 7, colorA >> 7, data, yB, 0);
							xA += xStepAB;
							xC += xStepAC;
							colorA += colorStepAB;
							colorC += colorStepAC;
							yB += width2d;
						}
					}
				} else {
					xC = xB <<= 16;
					colorC = colorB <<= 15;
					if (yB < 0) {
						xC -= xStepAB * yB;
						xB -= xStepBC * yB;
						colorC -= colorStepAB * yB;
						colorB -= colorStepBC * yB;
						yB = 0;
					}

					xA <<= 16;
					colorA <<= 15;
					if (yA < 0) {
						xA -= xStepAC * yA;
						colorA -= colorStepAC * yA;
						yA = 0;
					}

					if (xStepAB < xStepBC) {
						yC -= yA;
						yA -= yB;
						yB = lineOffset[yB];

						while (--yA >= 0) {
							drawGouraudScanline(xC >> 16, xB >> 16, colorC >> 7, colorB >> 7, data, yB, 0);
							xC += xStepAB;
							xB += xStepBC;
							colorC += colorStepAB;
							colorB += colorStepBC;
							yB += width2d;
						}
						while (--yC >= 0) {
							drawGouraudScanline(xA >> 16, xB >> 16, colorA >> 7, colorB >> 7, data, yB, 0);
							xA += xStepAC;
							xB += xStepBC;
							colorA += colorStepAC;
							colorB += colorStepBC;
							yB += width2d;
						}
					} else {
						yC -= yA;
						yA -= yB;
						yB = lineOffset[yB];

						while (--yA >= 0) {
							drawGouraudScanline(xB >> 16, xC >> 16, colorB >> 7, colorC >> 7, data, yB, 0);
							xC += xStepAB;
							xB += xStepBC;
							colorC += colorStepAB;
							colorB += colorStepBC;
							yB += width2d;
						}
						while (--yC >= 0) {
							drawGouraudScanline(xB >> 16, xA >> 16, colorB >> 7, colorA >> 7, data, yB, 0);
							xA += xStepAC;
							xB += xStepBC;
							colorA += colorStepAC;
							colorB += colorStepBC;
							yB += width2d;
						}
					}
				}
			}
		} else if (yC < bottom) {
			if (yA > bottom) {
				yA = bottom;
			}

			if (yB > bottom) {
				yB = bottom;
			}

			if (yA < yB) {
				xB = xC <<= 16;
				colorB = colorC <<= 15;
				if (yC < 0) {
					xB -= xStepBC * yC;
					xC -= xStepAC * yC;
					colorB -= colorStepBC * yC;
					colorC -= colorStepAC * yC;
					yC = 0;
				}

				xA <<= 16;
				colorA <<= 15;
				if (yA < 0) {
					xA -= xStepAB * yA;
					colorA -= colorStepAB * yA;
					yA = 0;
				}

				if (xStepBC < xStepAC) {
					yB -= yA;
					yA -= yC;
					yC = lineOffset[yC];

					while (--yA >= 0) {
						drawGouraudScanline(xB >> 16, xC >> 16, colorB >> 7, colorC >> 7, data, yC, 0);
						xB += xStepBC;
						xC += xStepAC;
						colorB += colorStepBC;
						colorC += colorStepAC;
						yC += width2d;
					}
					while (--yB >= 0) {
						drawGouraudScanline(xB >> 16, xA >> 16, colorB >> 7, colorA >> 7, data, yC, 0);
						xB += xStepBC;
						xA += xStepAB;
						colorB += colorStepBC;
						colorA += colorStepAB;
						yC += width2d;
					}
				} else {
					yB -= yA;
					yA -= yC;
					yC = lineOffset[yC];

					while (--yA >= 0) {
						drawGouraudScanline(xC >> 16, xB >> 16, colorC >> 7, colorB >> 7, data, yC, 0);
						xB += xStepBC;
						xC += xStepAC;
						colorB += colorStepBC;
						colorC += colorStepAC;
						yC += width2d;
					}
					while (--yB >= 0) {
						drawGouraudScanline(xA >> 16, xB >> 16, colorA >> 7, colorB >> 7, data, yC, 0);
						xB += xStepBC;
						xA += xStepAB;
						colorB += colorStepBC;
						colorA += colorStepAB;
						yC += width2d;
					}
				}
			} else {
				xA = xC <<= 16;
				colorA = colorC <<= 15;
				if (yC < 0) {
					xA -= xStepBC * yC;
					xC -= xStepAC * yC;
					colorA -= colorStepBC * yC;
					colorC -= colorStepAC * yC;
					yC = 0;
				}

				xB <<= 16;
				colorB <<= 15;
				if (yB < 0) {
					xB -= xStepAB * yB;
					colorB -= colorStepAB * yB;
					yB = 0;
				}

				if (xStepBC < xStepAC) {
					yA -= yB;
					yB -= yC;
					yC = lineOffset[yC];

					while (--yB >= 0) {
						drawGouraudScanline(xA >> 16, xC >> 16, colorA >> 7, colorC >> 7, data, yC, 0);
						xA += xStepBC;
						xC += xStepAC;
						colorA += colorStepBC;
						colorC += colorStepAC;
						yC += width2d;
					}
					while (--yA >= 0) {
						drawGouraudScanline(xB >> 16, xC >> 16, colorB >> 7, colorC >> 7, data, yC, 0);
						xB += xStepAB;
						xC += xStepAC;
						colorB += colorStepAB;
						colorC += colorStepAC;
						yC += width2d;
					}
				} else {
					yA -= yB;
					yB -= yC;
					yC = lineOffset[yC];

					while (--yB >= 0) {
						drawGouraudScanline(xC >> 16, xA >> 16, colorC >> 7, colorA >> 7, data, yC, 0);
						xA += xStepBC;
						xC += xStepAC;
						colorA += colorStepBC;
						colorC += colorStepAC;
						yC += width2d;
					}
					while (--yA >= 0) {
						drawGouraudScanline(xC >> 16, xB >> 16, colorC >> 7, colorB >> 7, data, yC, 0);
						xB += xStepAB;
						xC += xStepAC;
						colorB += colorStepAB;
						colorC += colorStepAC;
						yC += width2d;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "([IIIIIIII)V")
	private static void drawGouraudScanline(@OriginalArg(4) int x0, @OriginalArg(5) int x1, @OriginalArg(6) int color0, @OriginalArg(7) int color1, @OriginalArg(0) int[] dst, @OriginalArg(1) int offset, @OriginalArg(3) int length) {
		int rgb;

		if (jagged) {
			int colorStep;

			if (clipX) {
				if (x1 - x0 > 3) {
					colorStep = (color1 - color0) / (x1 - x0);
				} else {
					colorStep = 0;
				}

				if (x1 > boundX) {
					x1 = boundX;
				}

				if (x0 < 0) {
					color0 -= x0 * colorStep;
					x0 = 0;
				}

				if (x0 >= x1) {
					return;
				}

				offset += x0;
                length = (x1 - x0) >> 2;
				colorStep <<= 2;
			} else if (x0 < x1) {
				offset += x0;
                length = (x1 - x0) >> 2;

				if (length > 0) {
					colorStep = (color1 - color0) * reciprocal15[length] >> 15;
				} else {
					colorStep = 0;
				}
			} else {
				return;
			}

			if (alpha == 0) {
				while (--length >= 0) {
					rgb = palette[color0 >> 8];
					color0 += colorStep;

					dst[offset++] = rgb;
					dst[offset++] = rgb;
					dst[offset++] = rgb;
					dst[offset++] = rgb;
				}

                length = (x1 - x0) & 0x3;
				if (length > 0) {
					rgb = palette[color0 >> 8];

					while (--length >= 0) {
						dst[offset++] = rgb;
					}
				}
			} else {
				int alpha = Draw3D.alpha;
				int invAlpha = 256 - Draw3D.alpha;

				while (--length >= 0) {
					rgb = palette[color0 >> 8];
					color0 += colorStep;

                    rgb = ((((rgb & 0xFF00FF) * invAlpha) >> 8) & 0xFF00FF) + ((((rgb & 0xFF00) * invAlpha) >> 8) & 0xFF00);
                    dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
                    dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
                    dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
                    dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
				}

                length = (x1 - x0) & 0x3;
				if (length > 0) {
					rgb = palette[color0 >> 8];
                    rgb = ((((rgb & 0xFF00FF) * invAlpha) >> 8) & 0xFF00FF) + ((((rgb & 0xFF00) * invAlpha) >> 8) & 0xFF00);

					while (--length >= 0) {
                        dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
					}
				}
			}
		} else if (x0 < x1) {
			int colorStep = (color1 - color0) / (x1 - x0);

			if (clipX) {
				if (x1 > boundX) {
					x1 = boundX;
				}

				if (x0 < 0) {
					color0 -= x0 * colorStep;
					x0 = 0;
				}

				if (x0 >= x1) {
					return;
				}
			}

			offset += x0;
			length = x1 - x0;

			if (alpha == 0) {
				while (--length >= 0) {
					dst[offset++] = palette[color0 >> 8];
					color0 += colorStep;
				}
			} else {
				int alpha = Draw3D.alpha;
				int invAlpha = 256 - Draw3D.alpha;

				while (--length >= 0) {
					rgb = palette[color0 >> 8];
					color0 += colorStep;

                    rgb = ((((rgb & 0xFF00FF) * invAlpha) >> 8) & 0xFF00FF) + ((((rgb & 0xFF00) * invAlpha) >> 8) & 0xFF00);
                    dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
				}
			}
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(IIIIIII)V")
	public static void fillTriangle(@OriginalArg(3) int xA, @OriginalArg(4) int xB, @OriginalArg(5) int xC, @OriginalArg(0) int yA, @OriginalArg(1) int yB, @OriginalArg(2) int yC, @OriginalArg(6) int color) {
		int dxAB = xB - xA;
		int dyAB = yB - yA;
		int dxAC = xC - xA;
		int dyAC = yC - yA;

		@Pc(3) int xStepAB = 0;
		if (yB != yA) {
			xStepAB = (dxAB << 16) / dyAB;
		}

		@Pc(18) int xStepBC = 0;
		if (yC != yB) {
            xStepBC = ((xC - xB) << 16) / (yC - yB);
		}

		@Pc(33) int xStepAC = 0;
		if (yC != yA) {
            xStepAC = ((xA - xC) << 16) / (yA - yC);
		}

		// this won't change any rendering, saves not wasting time "drawing" an invalid triangle
		int triangleArea = (dxAB * dyAC) - (dyAB * dxAC);
		if (triangleArea == 0) {
			return;
		}

		if (yA <= yB && yA <= yC) {
			if (yA < bottom) {
				if (yB > bottom) {
					yB = bottom;
				}

				if (yC > bottom) {
					yC = bottom;
				}

				if (yB < yC) {
					xC = xA <<= 16;
					if (yA < 0) {
						xC -= xStepAC * yA;
						xA -= xStepAB * yA;
						yA = 0;
					}

					xB <<= 16;
					if (yB < 0) {
						xB -= xStepBC * yB;
						yB = 0;
					}

					if (yA != yB && xStepAC < xStepAB || yA == yB && xStepAC > xStepBC) {
						yC -= yB;
						yB -= yA;
						yA = lineOffset[yA];

						while (--yB >= 0) {
							drawScanline(xC >> 16, xA >> 16, data, yA, color);
							xC += xStepAC;
							xA += xStepAB;
							yA += width2d;
						}
						while (--yC >= 0.0F) {
							drawScanline(xC >> 16, xB >> 16, data, yA, color);
							xC += xStepAC;
							xB += xStepBC;
							yA += width2d;
						}
					} else {
						yC -= yB;
						yB -= yA;
						yA = lineOffset[yA];

						while (--yB >= 0) {
							drawScanline(xA >> 16, xC >> 16, data, yA, color);
							xC += xStepAC;
							xA += xStepAB;
							yA += width2d;
						}
						while (--yC >= 0) {
							drawScanline(xB >> 16, xC >> 16, data, yA, color);
							xC += xStepAC;
							xB += xStepBC;
							yA += width2d;
						}
					}
				} else {
					xB = xA <<= 16;
					if (yA < 0) {
						xB -= xStepAC * yA;
						xA -= xStepAB * yA;
						yA = 0;
					}

					xC <<= 16;
					if (yC < 0) {
						xC -= xStepBC * yC;
						yC = 0;
					}

					if (yA != yC && xStepAC < xStepAB || yA == yC && xStepBC > xStepAB) {
						yB -= yC;
						yC -= yA;
						yA = lineOffset[yA];

						while (--yC >= 0) {
							drawScanline(xB >> 16, xA >> 16, data, yA, color);
							xB += xStepAC;
							xA += xStepAB;
							yA += width2d;
						}
						while (--yB >= 0) {
							drawScanline(xC >> 16, xA >> 16, data, yA, color);
							xC += xStepBC;
							xA += xStepAB;
							yA += width2d;
						}
					} else {
						yB -= yC;
						yC -= yA;
						yA = lineOffset[yA];

						while (--yC >= 0) {
							drawScanline(xA >> 16, xB >> 16, data, yA, color);
							xB += xStepAC;
							xA += xStepAB;
							yA += width2d;
						}
						while (--yB >= 0) {
							drawScanline(xA >> 16, xC >> 16, data, yA, color);
							xC += xStepBC;
							xA += xStepAB;
							yA += width2d;
						}
					}
				}
			}
		} else if (yB <= yC) {
			if (yB < bottom) {
				if (yC > bottom) {
					yC = bottom;
				}

				if (yA > bottom) {
					yA = bottom;
				}

				if (yC < yA) {
					xA = xB <<= 16;
					if (yB < 0) {
						xA -= xStepAB * yB;
						xB -= xStepBC * yB;
						yB = 0;
					}

					xC <<= 16;
					if (yC < 0) {
						xC -= xStepAC * yC;
						yC = 0;
					}

					if (yB != yC && xStepAB < xStepBC || yB == yC && xStepAB > xStepAC) {
						yA -= yC;
						yC -= yB;
						yB = lineOffset[yB];

						while (--yC >= 0) {
							drawScanline(xA >> 16, xB >> 16, data, yB, color);
							xA += xStepAB;
							xB += xStepBC;
							yB += width2d;
						}
						while (--yA >= 0) {
							drawScanline(xA >> 16, xC >> 16, data, yB, color);
							xA += xStepAB;
							xC += xStepAC;
							yB += width2d;
						}
					} else {
						yA -= yC;
						yC -= yB;
						yB = lineOffset[yB];

						while (--yC >= 0) {
							drawScanline(xB >> 16, xA >> 16, data, yB, color);
							xA += xStepAB;
							xB += xStepBC;
							yB += width2d;
						}
						while (--yA >= 0) {
							drawScanline(xC >> 16, xA >> 16, data, yB, color);
							xA += xStepAB;
							xC += xStepAC;
							yB += width2d;
						}
					}
				} else {
					xC = xB <<= 16;
					if (yB < 0) {
						xC -= xStepAB * yB;
						xB -= xStepBC * yB;
						yB = 0;
					}

					xA <<= 16;
					if (yA < 0) {
						xA -= xStepAC * yA;
						yA = 0;
					}

					if (xStepAB < xStepBC) {
						yC -= yA;
						yA -= yB;
						yB = lineOffset[yB];

						while (--yA >= 0) {
							drawScanline(xC >> 16, xB >> 16, data, yB, color);
							xC += xStepAB;
							xB += xStepBC;
							yB += width2d;
						}
						while (--yC >= 0) {
							drawScanline(xA >> 16, xB >> 16, data, yB, color);
							xA += xStepAC;
							xB += xStepBC;
							yB += width2d;
						}
					} else {
						yC -= yA;
						yA -= yB;
						yB = lineOffset[yB];

						while (--yA >= 0) {
							drawScanline(xB >> 16, xC >> 16, data, yB, color);
							xC += xStepAB;
							xB += xStepBC;
							yB += width2d;
						}
						while (--yC >= 0) {
							drawScanline(xB >> 16, xA >> 16, data, yB, color);
							xA += xStepAC;
							xB += xStepBC;
							yB += width2d;
						}
					}
				}
			}
		} else if (yC < bottom) {
			if (yA > bottom) {
				yA = bottom;
			}

			if (yB > bottom) {
				yB = bottom;
			}

			if (yA < yB) {
				xB = xC <<= 16;
				if (yC < 0) {
					xB -= xStepBC * yC;
					xC -= xStepAC * yC;
					yC = 0;
				}

				xA <<= 16;
				if (yA < 0) {
					xA -= xStepAB * yA;
					yA = 0;
				}

				if (xStepBC < xStepAC) {
					yB -= yA;
					yA -= yC;
					yC = lineOffset[yC];

					while (--yA >= 0) {
						drawScanline(xB >> 16, xC >> 16, data, yC, color);
						xB += xStepBC;
						xC += xStepAC;
						yC += width2d;
					}
					while (--yB >= 0) {
						drawScanline(xB >> 16, xA >> 16, data, yC, color);
						xB += xStepBC;
						xA += xStepAB;
						yC += width2d;
					}
				} else {
					yB -= yA;
					yA -= yC;
					yC = lineOffset[yC];

					while (--yA >= 0) {
						drawScanline(xC >> 16, xB >> 16, data, yC, color);
						xB += xStepBC;
						xC += xStepAC;
						yC += width2d;
					}
					while (--yB >= 0) {
						drawScanline(xA >> 16, xB >> 16, data, yC, color);
						xB += xStepBC;
						xA += xStepAB;
						yC += width2d;
					}
				}
			} else {
				xA = xC <<= 16;
				if (yC < 0) {
					xA -= xStepBC * yC;
					xC -= xStepAC * yC;
					yC = 0;
				}

				xB <<= 16;
				if (yB < 0) {
					xB -= xStepAB * yB;
					yB = 0;
				}

				if (xStepBC < xStepAC) {
					yA -= yB;
					yB -= yC;
					yC = lineOffset[yC];

					while (--yB >= 0) {
						drawScanline(xA >> 16, xC >> 16, data, yC, color);
						xA += xStepBC;
						xC += xStepAC;
						yC += width2d;
					}
					while (--yA >= 0) {
						drawScanline(xB >> 16, xC >> 16, data, yC, color);
						xB += xStepAB;
						xC += xStepAC;
						yC += width2d;
					}
				} else {
					yA -= yB;
					yB -= yC;
					yC = lineOffset[yC];

					while (--yB >= 0) {
						drawScanline(xC >> 16, xA >> 16, data, yC, color);
						xA += xStepBC;
						xC += xStepAC;
						yC += width2d;
					}
					while (--yA >= 0) {
						drawScanline(xC >> 16, xB >> 16, data, yC, color);
						xB += xStepAB;
						xC += xStepAC;
						yC += width2d;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "([IIIIII)V")
	private static void drawScanline(@OriginalArg(4) int x0, @OriginalArg(5) int x1, @OriginalArg(0) int[] dst, @OriginalArg(1) int offset, @OriginalArg(2) int rgb) {
		if (clipX) {
			if (x1 > boundX) {
				x1 = boundX;
			}

			if (x0 < 0) {
				x0 = 0;
			}
		}

		if (x0 >= x1) {
			return;
		}

		offset += x0;
		@Pc(26) int length = (x1 - x0) >> 2;

		if (alpha == 0) {
			while (--length >= 0) {
				dst[offset++] = rgb;
				dst[offset++] = rgb;
				dst[offset++] = rgb;
				dst[offset++] = rgb;
			}

            length = (x1 - x0) & 0x3;
			while (--length >= 0) {
				dst[offset++] = rgb;
			}
		} else {
			@Pc(72) int alpha = Draw3D.alpha;
			@Pc(76) int invAlpha = 256 - Draw3D.alpha;
			rgb = ((rgb & 0xFF00FF) * invAlpha >> 8 & 0xFF00FF) + ((rgb & 0xFF00) * invAlpha >> 8 & 0xFF00);

			while (--length >= 0) {
				dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
				dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
				dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
				dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
			}

			length = (x1 - x0) & 0x3;
			while (--length >= 0) {
				dst[offset++] = rgb + ((((dst[offset] & 0xFF00FF) * alpha) >> 8) & 0xFF00FF) + ((((dst[offset] & 0xFF00) * alpha) >> 8) & 0xFF00);
			}
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "(IIIIIIIIIIIIIIIIIII)V")
	public static void fillTexturedTriangle(@OriginalArg(3) int xA, @OriginalArg(4) int xB, @OriginalArg(5) int xC, @OriginalArg(0) int yA, @OriginalArg(1) int yB, @OriginalArg(2) int yC, @OriginalArg(6) int shadeA, @OriginalArg(7) int shadeB, @OriginalArg(8) int shadeC, @OriginalArg(9) int originX, @OriginalArg(12) int originY, @OriginalArg(15) int originZ, @OriginalArg(10) int txB, @OriginalArg(11) int txC, @OriginalArg(13) int tyB, @OriginalArg(14) int tyC, @OriginalArg(16) int tzB, @OriginalArg(17) int tzC, @OriginalArg(18) int texture) {
		@Pc(4) int[] texels = getTexels(texture);
		opaque = !textureTranslucent[texture];

		@Pc(16) int verticalX = originX - txB;
		@Pc(20) int verticalY = originY - tyB;
		@Pc(24) int verticalZ = originZ - tzB;

		@Pc(28) int horizontalX = txC - originX;
		@Pc(32) int horizontalY = tyC - originY;
		@Pc(36) int horizontalZ = tzC - originZ;

		@Pc(46) int u = ((horizontalX * originY) - (horizontalY * originX)) << 14;
		@Pc(56) int uStride = ((horizontalY * originZ) - (horizontalZ * originY)) << 8;
		@Pc(66) int uStepVertical = ((horizontalZ * originX) - (horizontalX * originZ)) << 5;

		@Pc(76) int v = ((verticalX * originY) - (verticalY * originX)) << 14;
		@Pc(86) int vStride = ((verticalY * originZ) - (verticalZ * originY)) << 8;
		@Pc(96) int vStepVertical = ((verticalZ * originX) - (verticalX * originZ)) << 5;

		@Pc(106) int w = ((verticalY * horizontalX) - (verticalX * horizontalY)) << 14;
		@Pc(116) int wStride = ((verticalZ * horizontalY) - (verticalY * horizontalZ)) << 8;
		@Pc(126) int wStepVertical = ((verticalX * horizontalZ) - (verticalZ * horizontalX)) << 5;

		int dxAB = xB - xA;
		int dyAB = yB - yA;
		int dxAC = xC - xA;
		int dyAC = yC - yA;

		@Pc(128) int xStepAB = 0;
		@Pc(130) int shadeStepAB = 0;
		if (yB != yA) {
			xStepAB = (dxAB << 16) / dyAB;
            shadeStepAB = ((shadeB - shadeA) << 16) / dyAB;
		}

		@Pc(155) int xStepBC = 0;
		@Pc(157) int shadeStepBC = 0;
		if (yC != yB) {
            xStepBC = ((xC - xB) << 16) / (yC - yB);
            shadeStepBC = ((shadeC - shadeB) << 16) / (yC - yB);
		}

		@Pc(182) int xStepAC = 0;
		@Pc(184) int shadeStepAC = 0;
		if (yC != yA) {
            xStepAC = ((xA - xC) << 16) / (yA - yC);
            shadeStepAC = ((shadeA - shadeC) << 16) / (yA - yC);
		}

		// this won't change any rendering, saves not wasting time "drawing" an invalid triangle
		int triangleArea = (dxAB * dyAC) - (dyAB * dxAC);
		if (triangleArea == 0) {
			return;
		}

		if (yA <= yB && yA <= yC) {
			if (yA < bottom) {
				if (yB > bottom) {
					yB = bottom;
				}

				if (yC > bottom) {
					yC = bottom;
				}

				if (yB < yC) {
					xC = xA <<= 16;
					shadeC = shadeA <<= 16;
					if (yA < 0) {
						xC -= xStepAC * yA;
						xA -= xStepAB * yA;
						shadeC -= shadeStepAC * yA;
						shadeA -= shadeStepAB * yA;
						yA = 0;
					}

					xB <<= 16;
					shadeB <<= 16;
					if (yB < 0) {
						xB -= xStepBC * yB;
						shadeB -= shadeStepBC * yB;
						yB = 0;
					}

					int dy = yA - centerY;
					u += uStepVertical * dy;
					v += vStepVertical * dy;
					w += wStepVertical * dy;

					if (yA != yB && xStepAC < xStepAB || yA == yB && xStepAC > xStepBC) {
						yC -= yB;
						yB -= yA;
						yA = lineOffset[yA];

						while (--yB >= 0) {
							drawTexturedScanline(xC >> 16, xA >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeA >> 8);
							xC += xStepAC;
							xA += xStepAB;
							shadeC += shadeStepAC;
							shadeA += shadeStepAB;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yC >= 0) {
							drawTexturedScanline(xC >> 16, xB >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeB >> 8);
							xC += xStepAC;
							xB += xStepBC;
							shadeC += shadeStepAC;
							shadeB += shadeStepBC;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					} else {
						yC -= yB;
						yB -= yA;
						yA = lineOffset[yA];

						while (--yB >= 0) {
							drawTexturedScanline(xA >> 16, xC >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeC >> 8);
							xC += xStepAC;
							xA += xStepAB;
							shadeC += shadeStepAC;
							shadeA += shadeStepAB;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yC >= 0) {
							drawTexturedScanline(xB >> 16, xC >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeC >> 8);
							xC += xStepAC;
							xB += xStepBC;
							shadeC += shadeStepAC;
							shadeB += shadeStepBC;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					}
				} else {
					xB = xA <<= 16;
					shadeB = shadeA <<= 16;
					if (yA < 0) {
						xB -= xStepAC * yA;
						xA -= xStepAB * yA;
						shadeB -= shadeStepAC * yA;
						shadeA -= shadeStepAB * yA;
						yA = 0;
					}

					xC <<= 16;
					shadeC <<= 16;
					if (yC < 0) {
						xC -= xStepBC * yC;
						shadeC -= shadeStepBC * yC;
						yC = 0;
					}

					int dy = yA - centerY;
					u += uStepVertical * dy;
					v += vStepVertical * dy;
					w += wStepVertical * dy;

					if ((yA == yC || xStepAC >= xStepAB) && (yA != yC || xStepBC <= xStepAB)) {
						yB -= yC;
						yC -= yA;
						yA = lineOffset[yA];

						while (--yC >= 0) {
							drawTexturedScanline(xA >> 16, xB >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeB >> 8);
							xB += xStepAC;
							xA += xStepAB;
							shadeB += shadeStepAC;
							shadeA += shadeStepAB;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yB >= 0) {
							drawTexturedScanline(xA >> 16, xC >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeC >> 8);
							xC += xStepBC;
							xA += xStepAB;
							shadeC += shadeStepBC;
							shadeA += shadeStepAB;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					} else {
						yB -= yC;
						yC -= yA;
						yA = lineOffset[yA];

						while (--yC >= 0) {
							drawTexturedScanline(xB >> 16, xA >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeA >> 8);
							xB += xStepAC;
							xA += xStepAB;
							shadeB += shadeStepAC;
							shadeA += shadeStepAB;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yB >= 0) {
							drawTexturedScanline(xC >> 16, xA >> 16, data, yA, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeA >> 8);
							xC += xStepBC;
							xA += xStepAB;
							shadeC += shadeStepBC;
							shadeA += shadeStepAB;
							yA += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					}
				}
			}
		} else if (yB <= yC) {
			if (yB < bottom) {
				if (yC > bottom) {
					yC = bottom;
				}

				if (yA > bottom) {
					yA = bottom;
				}

				if (yC < yA) {
					xA = xB <<= 16;
					shadeA = shadeB <<= 16;
					if (yB < 0) {
						xA -= xStepAB * yB;
						xB -= xStepBC * yB;
						shadeA -= shadeStepAB * yB;
						shadeB -= shadeStepBC * yB;
						yB = 0;
					}

					xC <<= 16;
					shadeC <<= 16;
					if (yC < 0) {
						xC -= xStepAC * yC;
						shadeC -= shadeStepAC * yC;
						yC = 0;
					}

					int dy = yB - centerY;
					u += uStepVertical * dy;
					v += vStepVertical * dy;
					w += wStepVertical * dy;

					if (yB != yC && xStepAB < xStepBC || yB == yC && xStepAB > xStepAC) {
						yA -= yC;
						yC -= yB;
						yB = lineOffset[yB];

						while (--yC >= 0) {
							drawTexturedScanline(xA >> 16, xB >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeB >> 8);
							xA += xStepAB;
							xB += xStepBC;
							shadeA += shadeStepAB;
							shadeB += shadeStepBC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yA >= 0) {
							drawTexturedScanline(xA >> 16, xC >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeC >> 8);
							xA += xStepAB;
							xC += xStepAC;
							shadeA += shadeStepAB;
							shadeC += shadeStepAC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					} else {
						yA -= yC;
						yC -= yB;
						yB = lineOffset[yB];

						while (--yC >= 0) {
							drawTexturedScanline(xB >> 16, xA >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeA >> 8);
							xA += xStepAB;
							xB += xStepBC;
							shadeA += shadeStepAB;
							shadeB += shadeStepBC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yA >= 0) {
							drawTexturedScanline(xC >> 16, xA >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeA >> 8);
							xA += xStepAB;
							xC += xStepAC;
							shadeA += shadeStepAB;
							shadeC += shadeStepAC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					}
				} else {
					xC = xB <<= 16;
					shadeC = shadeB <<= 16;
					if (yB < 0) {
						xC -= xStepAB * yB;
						xB -= xStepBC * yB;
						shadeC -= shadeStepAB * yB;
						shadeB -= shadeStepBC * yB;
						yB = 0;
					}

					xA <<= 16;
					shadeA <<= 16;
					if (yA < 0) {
						xA -= xStepAC * yA;
						shadeA -= shadeStepAC * yA;
						yA = 0;
					}

					int dy = yB - centerY;
					u += uStepVertical * dy;
					v += vStepVertical * dy;
					w += wStepVertical * dy;

					if (xStepAB < xStepBC) {
						yC -= yA;
						yA -= yB;
						yB = lineOffset[yB];

						while (--yA >= 0) {
							drawTexturedScanline(xC >> 16, xB >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeB >> 8);
							xC += xStepAB;
							xB += xStepBC;
							shadeC += shadeStepAB;
							shadeB += shadeStepBC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yC >= 0) {
							drawTexturedScanline(xA >> 16, xB >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeB >> 8);
							xA += xStepAC;
							xB += xStepBC;
							shadeA += shadeStepAC;
							shadeB += shadeStepBC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					} else {
						yC -= yA;
						yA -= yB;
						yB = lineOffset[yB];

						while (--yA >= 0) {
							drawTexturedScanline(xB >> 16, xC >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeC >> 8);
							xC += xStepAB;
							xB += xStepBC;
							shadeC += shadeStepAB;
							shadeB += shadeStepBC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
						while (--yC >= 0) {
							drawTexturedScanline(xB >> 16, xA >> 16, data, yB, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeA >> 8);
							xA += xStepAC;
							xB += xStepBC;
							shadeA += shadeStepAC;
							shadeB += shadeStepBC;
							yB += width2d;
							u += uStepVertical;
							v += vStepVertical;
							w += wStepVertical;
						}
					}
				}
			}
		} else if (yC < bottom) {
			if (yA > bottom) {
				yA = bottom;
			}

			if (yB > bottom) {
				yB = bottom;
			}

			if (yA < yB) {
				xB = xC <<= 16;
				shadeB = shadeC <<= 16;
				if (yC < 0) {
					xB -= xStepBC * yC;
					xC -= xStepAC * yC;
					shadeB -= shadeStepBC * yC;
					shadeC -= shadeStepAC * yC;
					yC = 0;
				}

				xA <<= 16;
				shadeA <<= 16;
				if (yA < 0) {
					xA -= xStepAB * yA;
					shadeA -= shadeStepAB * yA;
					yA = 0;
				}

				int dy = yC - centerY;
				u += uStepVertical * dy;
				v += vStepVertical * dy;
				w += wStepVertical * dy;

				if (xStepBC < xStepAC) {
					yB -= yA;
					yA -= yC;
					yC = lineOffset[yC];

					while (--yA >= 0) {
						drawTexturedScanline(xB >> 16, xC >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeC >> 8);
						xB += xStepBC;
						xC += xStepAC;
						shadeB += shadeStepBC;
						shadeC += shadeStepAC;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
					while (--yB >= 0) {
						drawTexturedScanline(xB >> 16, xA >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeA >> 8);
						xB += xStepBC;
						xA += xStepAB;
						shadeB += shadeStepBC;
						shadeA += shadeStepAB;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
				} else {
					yB -= yA;
					yA -= yC;
					yC = lineOffset[yC];

					while (--yA >= 0) {
						drawTexturedScanline(xC >> 16, xB >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeB >> 8);
						xB += xStepBC;
						xC += xStepAC;
						shadeB += shadeStepBC;
						shadeC += shadeStepAC;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
					while (--yB >= 0) {
						drawTexturedScanline(xA >> 16, xB >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeB >> 8);
						xB += xStepBC;
						xA += xStepAB;
						shadeB += shadeStepBC;
						shadeA += shadeStepAB;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
				}
			} else {
				xA = xC <<= 16;
				shadeA = shadeC <<= 16;
				if (yC < 0) {
					xA -= xStepBC * yC;
					xC -= xStepAC * yC;
					shadeA -= shadeStepBC * yC;
					shadeC -= shadeStepAC * yC;
					yC = 0;
				}

				xB <<= 16;
				shadeB <<= 16;
				if (yB < 0) {
					xB -= xStepAB * yB;
					shadeB -= shadeStepAB * yB;
					yB = 0;
				}

				int dy = yC - centerY;
				u += uStepVertical * dy;
				v += vStepVertical * dy;
				w += wStepVertical * dy;

				if (xStepBC < xStepAC) {
					yA -= yB;
					yB -= yC;
					yC = lineOffset[yC];

					while (--yB >= 0) {
						drawTexturedScanline(xA >> 16, xC >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeA >> 8, shadeC >> 8);
						xA += xStepBC;
						xC += xStepAC;
						shadeA += shadeStepBC;
						shadeC += shadeStepAC;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
					while (--yA >= 0) {
						drawTexturedScanline(xB >> 16, xC >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeB >> 8, shadeC >> 8);
						xB += xStepAB;
						xC += xStepAC;
						shadeB += shadeStepAB;
						shadeC += shadeStepAC;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
				} else {
					yA -= yB;
					yB -= yC;
					yC = lineOffset[yC];

					while (--yB >= 0) {
						drawTexturedScanline(xC >> 16, xA >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeA >> 8);
						xA += xStepBC;
						xC += xStepAC;
						shadeA += shadeStepBC;
						shadeC += shadeStepAC;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
					while (--yA >= 0) {
						drawTexturedScanline(xC >> 16, xB >> 16, data, yC, texels, 0, 0, u, v, w, uStride, vStride, wStride, shadeC >> 8, shadeB >> 8);
						xB += xStepAB;
						xC += xStepAC;
						shadeB += shadeStepAB;
						shadeC += shadeStepAC;
						yC += width2d;
						u += uStepVertical;
						v += vStepVertical;
						w += wStepVertical;
					}
				}
			}
		}
	}

	@OriginalMember(owner = "client!gb", name = "a", descriptor = "([I[IIIIIIIIIIIIII)V")
	private static void drawTexturedScanline(@OriginalArg(5) int xA, @OriginalArg(6) int xB, @OriginalArg(0) int[] dst, @OriginalArg(4) int offset, @OriginalArg(1) int[] texels, @OriginalArg(2) int curU, @OriginalArg(3) int curV, @OriginalArg(9) int u, @OriginalArg(10) int v, @OriginalArg(11) int w, @OriginalArg(12) int uStride, @OriginalArg(13) int vStride, @OriginalArg(14) int wStride, @OriginalArg(7) int shadeA, @OriginalArg(8) int shadeB) {
		if (xA >= xB) {
			return;
		}

		@Pc(15) int shadeStrides;
		@Pc(40) int strides;
		if (clipX) {
			shadeStrides = (shadeB - shadeA) / (xB - xA);

			if (xB > boundX) {
				xB = boundX;
			}

			if (xA < 0) {
				shadeA -= xA * shadeStrides;
				xA = 0;
			}

			if (xA >= xB) {
				return;
			}

            strides = (xB - xA) >> 3;
			shadeStrides <<= 12;
			shadeA <<= 9;
		} else {
			if (xB - xA > 7) {
                strides = (xB - xA) >> 3;
				shadeStrides = (shadeB - shadeA) * reciprocal15[strides] >> 6;
			} else {
				strides = 0;
				shadeStrides = 0;
			}

			shadeA <<= 9;
		}

		offset += xA;

		if (lowMemory) {
			int nextU = 0;
			int nextV = 0;
			int dx = xA - centerX;

			u = u + (uStride >> 3) * dx;
			v = v + (vStride >> 3) * dx;
			w = w + (wStride >> 3) * dx;

			int curW = w >> 12;
			if (curW != 0) {
				curU = u / curW;
				curV = v / curW;
				if (curU < 0) {
					curU = 0;
				} else if (curU > 0xfc0) {
					curU = 0xfc0;
				}
			}

			u = u + uStride;
			v = v + vStride;
			w = w + wStride;

			curW = w >> 12;
			if (curW != 0) {
				nextU = u / curW;
				nextV = v / curW;
				if (nextU < 0x7) {
					nextU = 0x7;
				} else if (nextU > 0xfc0) {
					nextU = 0xfc0;
				}
			}

			int stepU = (nextU - curU) >> 3;
			int stepV = (nextV - curV) >> 3;
            curU += (shadeA >> 3) & 0xC0000;
			int shadeShift = shadeA >> 23;

			if (opaque) {
				while (strides-- > 0) {
					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU = nextU;
					curV = nextV;

					u += uStride;
					v += vStride;
					w += wStride;

					curW = w >> 12;
					if (curW != 0) {
						nextU = u / curW;
						nextV = v / curW;
						if (nextU < 0x7) {
							nextU = 0x7;
						} else if (nextU > 0xfc0) {
							nextU = 0xfc0;
						}
					}

                    stepU = (nextU - curU) >> 3;
                    stepV = (nextV - curV) >> 3;
					shadeA += shadeStrides;
                    curU += (shadeA >> 3) & 0xC0000;
					shadeShift = shadeA >> 23;
				}

				strides = xB - xA & 0x7;
				while (strides-- > 0) {
					dst[offset++] = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift;
					curU += stepU;
					curV += stepV;
				}
			} else {
				while (strides-- > 0) {
					@Pc(507) int rgb;
					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU = nextU;
					curV = nextV;

					u += uStride;
					v += vStride;
					w += wStride;

					curW = w >> 12;
					if (curW != 0) {
						nextU = u / curW;
						nextV = v / curW;
						if (nextU < 7) {
							nextU = 7;
						} else if (nextU > 0xfc0) {
							nextU = 0xfc0;
						}
					}

					stepU = nextU - curU >> 3;
					stepV = nextV - curV >> 3;
					shadeA += shadeStrides;
                    curU += (shadeA >> 3) & 0xC0000;
					shadeShift = shadeA >> 23;
				}

                strides = (xB - xA) & 0x7;
				while (strides-- > 0) {
					@Pc(796) int rgb;
					if ((rgb = texels[(curV & 0xFC0) + (curU >> 6)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}

					offset++;
					curU += stepU;
					curV += stepV;
				}
			}
		} else {
			int nextU = 0;
			int nextV = 0;
			int dx = xA - centerX;

			u = u + (uStride >> 3) * dx;
			v = v + (vStride >> 3) * dx;
			w = w + (wStride >> 3) * dx;

			int curW = w >> 14;
			if (curW != 0) {
				curU = u / curW;
				curV = v / curW;
				if (curU < 0) {
					curU = 0;
				} else if (curU > 0x3f80) {
					curU = 0x3f80;
				}
			}

			u = u + uStride;
			v = v + vStride;
			w = w + wStride;

			curW = w >> 14;
			if (curW != 0) {
				nextU = u / curW;
				nextV = v / curW;
				if (nextU < 0x7) {
					nextU = 0x7;
				} else if (nextU > 0x3f80) {
					nextU = 0x3f80;
				}
			}

			int stepU = nextU - curU >> 3;
			int stepV = nextV - curV >> 3;
			curU += shadeA & 0x600000;
			int shadeShift = shadeA >> 23;

			if (opaque) {
				while (strides-- > 0) {
					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;

					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU = nextU;
					curV = nextV;

					u += uStride;
					v += vStride;
					w += wStride;

					curW = w >> 14;
					if (curW != 0) {
						nextU = u / curW;
						nextV = v / curW;
						if (nextU < 0x7) {
							nextU = 0x7;
						} else if (nextU > 0x3f80) {
							nextU = 0x3f80;
						}
					}

					stepU = nextU - curU >> 3;
					stepV = nextV - curV >> 3;
					shadeA += shadeStrides;
					curU += shadeA & 0x600000;
					shadeShift = shadeA >> 23;
				}

				strides = xB - xA & 0x7;
				while (strides-- > 0) {
					dst[offset++] = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift;
					curU += stepU;
					curV += stepV;
				}
			} else {
				while (strides-- > 0) {
					@Pc(1230) int rgb;
					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU += stepU;
					curV += stepV;

					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}
					offset++;
					curU = nextU;
					curV = nextV;

					u += uStride;
					v += vStride;
					w += wStride;

					curW = w >> 14;
					if (curW != 0) {
						nextU = u / curW;
						nextV = v / curW;
						if (nextU < 0x7) {
							nextU = 0x7;
						} else if (nextU > 0x3f80) {
							nextU = 0x3f80;
						}
					}

					stepU = nextU - curU >> 3;
					stepV = nextV - curV >> 3;
					shadeA += shadeStrides;
					curU += shadeA & 0x600000;
					shadeShift = shadeA >> 23;
				}

				strides = xB - xA & 0x7;
				while (strides-- > 0) {
					@Pc(1517) int rgb;
					if ((rgb = texels[(curV & 0x3F80) + (curU >> 7)] >>> shadeShift) != 0) {
						dst[offset] = rgb;
					}

					offset++;
					curU += stepU;
					curV += stepV;
				}
			}
		}
	}

}
