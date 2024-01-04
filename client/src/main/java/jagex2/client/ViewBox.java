package jagex2.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.awt.*;

@OriginalClass("client!b")
public class ViewBox extends Frame {

	@OriginalMember(owner = "client!b", name = "b", descriptor = "Lclient!a;")
	private final GameShell shell;

	@OriginalMember(owner = "client!b", name = "<init>", descriptor = "(IILclient!a;I)V")
	public ViewBox(@OriginalArg(2) GameShell shell, @OriginalArg(3) int width, @OriginalArg(0) int height) {
		this.shell = shell;
		this.setTitle("Jagex");
		this.setResizable(false);

        this.setLayout(new BorderLayout());
        this.add(shell);
        this.pack();

        // for compatibility with Java < 1.4
        Insets insets = this.getInsets();
        this.setSize(width + insets.left + insets.bottom, height + insets.top + insets.bottom);
        this.setVisible(true);

		this.toFront();
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
