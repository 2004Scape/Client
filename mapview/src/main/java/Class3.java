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

@OriginalClass("mapview!l")
public final class Class3 implements ImageProducer, ImageObserver {

	@OriginalMember(owner = "mapview!l", name = "e", descriptor = "Ljava/awt/image/ImageConsumer;")
	private ImageConsumer anImageConsumer1;

	@OriginalMember(owner = "mapview!l", name = "b", descriptor = "I")
	private int anInt102;

	@OriginalMember(owner = "mapview!l", name = "c", descriptor = "I")
	private int anInt103;

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "[I")
	private int[] anIntArray18;

	@OriginalMember(owner = "mapview!l", name = "d", descriptor = "Ljava/awt/image/ColorModel;")
	private ColorModel aColorModel1;

	@OriginalMember(owner = "mapview!l", name = "f", descriptor = "Ljava/awt/Image;")
	private Image anImage1;

	@OriginalMember(owner = "mapview!l", name = "<init>", descriptor = "(IILjava/awt/Component;)V")
	public Class3(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) Component arg2) {
		this.anInt102 = arg0;
		this.anInt103 = arg1;
		this.anIntArray18 = new int[arg0 * arg1];
		this.aColorModel1 = new DirectColorModel(32, 16711680, 65280, 255);
		this.anImage1 = arg2.createImage(this);
		this.method88();
		arg2.prepareImage(this.anImage1, this);
		this.method88();
		arg2.prepareImage(this.anImage1, this);
		this.method88();
		arg2.prepareImage(this.anImage1, this);
		this.method86();
	}

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "()V")
	public void method86() {
		Class1_Sub1_Sub1.method70(this.anIntArray18, this.anInt102, this.anInt103);
	}

	@OriginalMember(owner = "mapview!l", name = "imageUpdate", descriptor = "(Ljava/awt/Image;IIIII)Z")
	@Override
	public boolean imageUpdate(@OriginalArg(0) Image arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2, @OriginalArg(3) int arg3, @OriginalArg(4) int arg4, @OriginalArg(5) int arg5) {
		return true;
	}

	@OriginalMember(owner = "mapview!l", name = "requestTopDownLeftRightResend", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public void requestTopDownLeftRightResend(@OriginalArg(0) ImageConsumer arg0) {
		System.out.println("TDLR");
	}

	@OriginalMember(owner = "mapview!l", name = "isConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)Z")
	@Override
	public synchronized boolean isConsumer(@OriginalArg(0) ImageConsumer arg0) {
		return this.anImageConsumer1 == arg0;
	}

	@OriginalMember(owner = "mapview!l", name = "removeConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public synchronized void removeConsumer(@OriginalArg(0) ImageConsumer arg0) {
		if (this.anImageConsumer1 == arg0) {
			this.anImageConsumer1 = null;
		}
	}

	@OriginalMember(owner = "mapview!l", name = "a", descriptor = "(Ljava/awt/Graphics;II)V")
	public void method87(@OriginalArg(0) Graphics arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		this.method88();
		arg0.drawImage(this.anImage1, arg1, arg2, this);
	}

	@OriginalMember(owner = "mapview!l", name = "startProduction", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public void startProduction(@OriginalArg(0) ImageConsumer arg0) {
		this.addConsumer(arg0);
	}

	@OriginalMember(owner = "mapview!l", name = "addConsumer", descriptor = "(Ljava/awt/image/ImageConsumer;)V")
	@Override
	public synchronized void addConsumer(@OriginalArg(0) ImageConsumer arg0) {
		this.anImageConsumer1 = arg0;
		arg0.setDimensions(this.anInt102, this.anInt103);
		arg0.setProperties(null);
		arg0.setColorModel(this.aColorModel1);
		arg0.setHints(14);
	}

	@OriginalMember(owner = "mapview!l", name = "b", descriptor = "()V")
	private synchronized void method88() {
		if (this.anImageConsumer1 != null) {
			this.anImageConsumer1.setPixels(0, 0, this.anInt102, this.anInt103, this.aColorModel1, this.anIntArray18, 0, this.anInt102);
			this.anImageConsumer1.imageComplete(2);
		}
	}
}
