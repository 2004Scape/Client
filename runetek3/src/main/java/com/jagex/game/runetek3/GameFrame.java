package com.jagex.game.runetek3;

import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

import java.awt.*;

@OriginalClass("client!b")
public final class GameFrame extends Frame {

	@OriginalMember(owner = "client!b", name = "a", descriptor = "I")
	private int flowObfuscator1 = 8;

	@OriginalMember(owner = "client!b", name = "b", descriptor = "Lclient!a;")
	private final GameShell shell;

	@OriginalMember(owner = "client!b", name = "<init>", descriptor = "(IILclient!a;I)V")
	public GameFrame(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) GameShell arg2, @OriginalArg(3) int arg3) {
		try {
			if (arg1 != 35731) {
				this.flowObfuscator1 = -475;
			}
			this.shell = arg2;
			this.setTitle("Jagex");
			this.setResizable(false);
			this.show();
			this.toFront();
			this.resize(arg3 + 8, arg0 + 28);
		} catch (@Pc(33) RuntimeException local33) {
			Signlink.reporterror("51818, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local33.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!b", name = "getGraphics", descriptor = "()Ljava/awt/Graphics;")
	@Override
	public Graphics getGraphics() {
		@Pc(2) Graphics local2 = super.getGraphics();
		local2.translate(4, 24);
		return local2;
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
