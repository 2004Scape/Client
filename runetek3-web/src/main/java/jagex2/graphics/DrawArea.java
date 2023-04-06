package jagex2.graphics;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.teavm.jso.canvas.CanvasRenderingContext2D;
import org.teavm.jso.canvas.ImageData;
import org.teavm.jso.typedarrays.Uint8ClampedArray;

@OriginalClass("client!qb")
public final class DrawArea {

	@OriginalMember(owner = "client!qb", name = "b", descriptor = "[I")
	public final int[] pixels;

	@OriginalMember(owner = "client!qb", name = "c", descriptor = "I")
	private final int width;

	@OriginalMember(owner = "client!qb", name = "d", descriptor = "I")
	private final int height;

	private final ImageData imageData;
	private final Uint8ClampedArray rgbPixels;

	@OriginalMember(owner = "client!qb", name = "<init>", descriptor = "(Ljava/awt/Component;III)V")
	public DrawArea(CanvasRenderingContext2D context, @OriginalArg(1) int arg1, @OriginalArg(3) int arg3) {
		this.width = arg1;
		this.height = arg3;
		this.pixels = new int[arg1 * arg3];
		this.imageData = context.createImageData(width, height);
		this.rgbPixels = this.imageData.getData();
		this.bind();
	}

	@OriginalMember(owner = "client!qb", name = "a", descriptor = "(B)V")
	public void bind() {
		Draw2D.bind(this.width, this.pixels, this.height);
	}

	@OriginalMember(owner = "client!qb", name = "a", descriptor = "(ILjava/awt/Graphics;II)V")
	public void draw(@OriginalArg(0) int arg0, CanvasRenderingContext2D context, @OriginalArg(2) int arg2) {
		for (int i = 0; i < width * height * 4; i += 4) {
			int pixel = this.pixels[i / 4];
			this.rgbPixels.set(i, (pixel >> 16) & 255);
			this.rgbPixels.set(i + 1, (pixel >> 8) & 255);
			this.rgbPixels.set(i + 2, pixel & 255);
			this.rgbPixels.set(i + 3, 255);
		}

		context.putImageData(imageData, arg2, arg0);
	}
}
