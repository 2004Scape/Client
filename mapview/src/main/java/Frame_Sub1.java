import java.awt.Frame;
import java.awt.Graphics;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!b")
public final class Frame_Sub1 extends Frame {

	@OriginalMember(owner = "mapview!b", name = "a", descriptor = "Lmapview!a;")
	private Applet_Sub1 anApplet_Sub1_1;

	@OriginalMember(owner = "mapview!b", name = "<init>", descriptor = "(Lmapview!a;II)V")
	public Frame_Sub1(@OriginalArg(0) Applet_Sub1 arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		this.anApplet_Sub1_1 = arg0;
		this.setTitle("Jagex");
		this.setResizable(false);
		this.show();
		this.toFront();
		this.resize(arg1 + 8, arg2 + 28);
	}

	@OriginalMember(owner = "mapview!b", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		this.anApplet_Sub1_1.paint(arg0);
	}

	@OriginalMember(owner = "mapview!b", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics arg0) {
		this.anApplet_Sub1_1.update(arg0);
	}

	@OriginalMember(owner = "mapview!b", name = "getGraphics", descriptor = "()Ljava/awt/Graphics;")
	@Override
	public Graphics getGraphics() {
		@Pc(2) Graphics local2 = super.getGraphics();
		local2.translate(4, 24);
		return local2;
	}
}
