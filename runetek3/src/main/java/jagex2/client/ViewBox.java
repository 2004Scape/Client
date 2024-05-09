package jagex2.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.awt.*;

// name taken from rsc
@OriginalClass("client!b")
public class ViewBox extends Frame {

	@OriginalMember(owner = "client!b", name = "b", descriptor = "Lclient!a;")
	private final GameShell shell;

	public Insets insets;

	@OriginalMember(owner = "client!b", name = "<init>", descriptor = "(IILclient!a;I)V")
	public ViewBox(@OriginalArg(2) GameShell shell, @OriginalArg(3) int width, @OriginalArg(0) int height) {
		this.shell = shell;
		this.setTitle("Jagex");
		this.setResizable(false);
		this.show();
		this.toFront();
		this.insets = this.getInsets();
		this.resize(width + this.insets.left + this.insets.bottom, height + this.insets.top + this.insets.bottom);
	}

	@OriginalMember(owner = "client!b", name = "getGraphics", descriptor = "()Ljava/awt/Graphics;")
	@Override
	public Graphics getGraphics() {
		@Pc(2) Graphics g = super.getGraphics();
        if (this.insets != null) {
		    g.translate(this.insets.left, this.insets.top);
        }
		return g;
	}

	@OriginalMember(owner = "client!b", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics g) {
		this.shell.update(g);
	}

	@OriginalMember(owner = "client!b", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics g) {
		this.shell.paint(g);
	}
}
