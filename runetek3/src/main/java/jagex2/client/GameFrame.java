package jagex2.client;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

import java.awt.*;

@OriginalClass("client!b")
public final class GameFrame extends Frame {

	@OriginalMember(owner = "client!b", name = "b", descriptor = "Lclient!a;")
	private final GameShell shell;

	@OriginalMember(owner = "client!b", name = "<init>", descriptor = "(IILclient!a;I)V")
	public GameFrame(@OriginalArg(2) GameShell arg2) {
		this.shell = arg2;
		this.setTitle("Jagex");
		this.setResizable(false);

		this.setLayout(new BorderLayout());
		this.add(shell);
		this.pack();

		this.setVisible(true);
		this.toFront();
	}

	@OriginalMember(owner = "client!b", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void update(@OriginalArg(0) Graphics arg0) {
		this.shell.update(arg0);
	}

	@OriginalMember(owner = "client!b", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public void paint(@OriginalArg(0) Graphics arg0) {
		this.shell.paint(arg0);
	}
}
