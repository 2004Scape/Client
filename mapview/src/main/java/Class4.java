import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("mapview!m")
public final class Class4 implements ImageProducer, ImageObserver {

	@OriginalMember(owner = "mapview!m", name = "e", descriptor = "Ljava/awt/image/ImageConsumer;")
	private ImageConsumer anImageConsumer1;

	@OriginalMember(owner = "mapview!m", name = "b", descriptor = "I")
	private int anInt93;

	@OriginalMember(owner = "mapview!m", name = "c", descriptor = "I")
	private int anInt94;

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "[I")
	private int[] anIntArray20;

	@OriginalMember(owner = "mapview!m", name = "d", descriptor = "Ljava/awt/image/ColorModel;")
	private ColorModel aColorModel1;

	@OriginalMember(owner = "mapview!m", name = "f", descriptor = "Ljava/awt/Image;")
	private Image anImage1;

	@OriginalMember(owner = "mapview!m", name = "<init>", descriptor = "(IILjava/awt/Component;)V")
	public Class4(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Component arg2) {
		this.anInt93 = arg0;
		this.anInt94 = arg1;
		this.anIntArray20 = new int[arg0 * arg1];
		this.aColorModel1 = new DirectColorModel(32, 16711680, 65280, 255);
		this.anImage1 = arg2.createImage(this);
		this.method109();
		arg2.prepareImage(this.anImage1, this);
		this.method109();
		arg2.prepareImage(this.anImage1, this);
		this.method109();
		arg2.prepareImage(this.anImage1, this);
		this.method107();
	}

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "()V")
	public void method107() {
		Class2_Sub1_Sub1.method87(this.anIntArray20, this.anInt93, this.anInt94);
	}

	@OriginalMember(owner = "mapview!m", name = "imageUpdate", descriptor = "(Ljava/awt/Image;IIIII)Z")
	@Override
	public boolean imageUpdate(@OriginalArg(0) Image arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		return true;
	}

	@OriginalMember(owner = "mapview!m", name = "requestTopDownLeftRightResend", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public void requestTopDownLeftRightResend(@OriginalArg(0) ImageConsumer arg0) {
		System.out.println("TDLR");
	}

	@OriginalMember(owner = "mapview!m", name = "isConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)Z")
	@Override
	public synchronized boolean isConsumer(@OriginalArg(0) ImageConsumer arg0) {
		return this.anImageConsumer1 == arg0;
	}

	@OriginalMember(owner = "mapview!m", name = "removeConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public synchronized void removeConsumer(@OriginalArg(0) ImageConsumer arg0) {
		if (this.anImageConsumer1 == arg0) {
			this.anImageConsumer1 = null;
		}
	}

	@OriginalMember(owner = "mapview!m", name = "a", descriptor = "(Ljava/awt/Graphics;II)V")
	public void method108(@OriginalArg(0) Graphics arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		this.method109();
		arg0.drawImage(this.anImage1, arg1, arg2, this);
	}

	@OriginalMember(owner = "mapview!m", name = "startProduction", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public void startProduction(@OriginalArg(0) ImageConsumer arg0) {
		this.addConsumer(arg0);
	}

	@OriginalMember(owner = "mapview!m", name = "addConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public synchronized void addConsumer(@OriginalArg(0) ImageConsumer arg0) {
		this.anImageConsumer1 = arg0;
		arg0.setDimensions(this.anInt93, this.anInt94);
		arg0.setProperties(null);
		arg0.setColorModel(this.aColorModel1);
		arg0.setHints(14);
	}

	@OriginalMember(owner = "mapview!m", name = "b", descriptor = "()V")
	private synchronized void method109() {
		if (this.anImageConsumer1 != null) {
			this.anImageConsumer1.setPixels(0, 0, this.anInt93, this.anInt94, this.aColorModel1, this.anIntArray20, 0, this.anInt93);
			this.anImageConsumer1.imageComplete(2);
		}
	}
}
