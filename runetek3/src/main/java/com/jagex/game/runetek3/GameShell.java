package com.jagex.game.runetek3;

import com.jagex.game.runetek3.graphics.DrawArea;
import com.jagex.game.runetek3.graphics.Image24;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@OriginalClass("client!a")
public class GameShell extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {

	@OriginalMember(owner = "client!a", name = "a", descriptor = "Z")
	private boolean flowObfuscator1 = false;

	@OriginalMember(owner = "client!a", name = "b", descriptor = "Z")
	private boolean flowObfuscator2 = false;

	@OriginalMember(owner = "client!a", name = "c", descriptor = "I")
	private int flowObfuscator3;

	@OriginalMember(owner = "client!a", name = "d", descriptor = "Z")
	private boolean flowObfuscator4 = false;

	@OriginalMember(owner = "client!a", name = "e", descriptor = "B")
	private final byte flowObfuscator5 = 3;

	@OriginalMember(owner = "client!a", name = "f", descriptor = "I")
	private int flowObfuscator6 = 27808;

	@OriginalMember(owner = "client!a", name = "g", descriptor = "I")
	private int state;

	@OriginalMember(owner = "client!a", name = "h", descriptor = "I")
	private int deltime = 20;

	@OriginalMember(owner = "client!a", name = "i", descriptor = "I")
	protected int mindel = 1;

	@OriginalMember(owner = "client!a", name = "j", descriptor = "[J")
	private final long[] otim = new long[10];

	@OriginalMember(owner = "client!a", name = "k", descriptor = "I")
	private int fps;

	@OriginalMember(owner = "client!a", name = "l", descriptor = "I")
	protected int screenWidth;

	@OriginalMember(owner = "client!a", name = "m", descriptor = "I")
	protected int screenHeight;

	@OriginalMember(owner = "client!a", name = "n", descriptor = "Ljava/awt/Graphics;")
	protected Graphics graphics;

	@OriginalMember(owner = "client!a", name = "o", descriptor = "Lclient!qb;")
	protected DrawArea drawArea;

	@OriginalMember(owner = "client!a", name = "p", descriptor = "[Lclient!hb;")
	private final Image24[] aClass1_Sub3_Sub2_Sub2Array2 = new Image24[6];

	@OriginalMember(owner = "client!a", name = "q", descriptor = "Lclient!b;")
	protected GameFrame frame;

	@OriginalMember(owner = "client!a", name = "r", descriptor = "Z")
	private boolean refresh = true;

	@OriginalMember(owner = "client!a", name = "s", descriptor = "I")
	protected int idleCycles;

	@OriginalMember(owner = "client!a", name = "t", descriptor = "I")
	protected int mouseButton;

	@OriginalMember(owner = "client!a", name = "u", descriptor = "I")
	protected int mouseX;

	@OriginalMember(owner = "client!a", name = "v", descriptor = "I")
	protected int mouseY;

	@OriginalMember(owner = "client!a", name = "w", descriptor = "I")
	protected int mouseClickButton;

	@OriginalMember(owner = "client!a", name = "x", descriptor = "I")
	protected int mouseClickX;

	@OriginalMember(owner = "client!a", name = "y", descriptor = "I")
	protected int mouseClickY;

	@OriginalMember(owner = "client!a", name = "z", descriptor = "[I")
	protected final int[] actionKey = new int[128];

	@OriginalMember(owner = "client!a", name = "A", descriptor = "[I")
	private final int[] keyQueue = new int[128];

	@OriginalMember(owner = "client!a", name = "B", descriptor = "I")
	private int keyQueueReadPos;

	@OriginalMember(owner = "client!a", name = "C", descriptor = "I")
	private int keyQueueWritePos;

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(III)V")
	protected final void initApplication(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) int arg2) {
		try {
			if (arg2 != 0) {
				this.flowObfuscator3 = 411;
			}
			this.screenWidth = arg1;
			this.screenHeight = arg0;
			this.frame = new GameFrame(this.screenHeight, 35731, this, this.screenWidth);
			this.graphics = this.getBaseComponent(this.flowObfuscator5).getGraphics();
			this.drawArea = new DrawArea(this.getBaseComponent(this.flowObfuscator5), this.screenWidth, 299, this.screenHeight);
			this.startThread(this, 1);
		} catch (@Pc(48) RuntimeException local48) {
			Signlink.reporterror("32828, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local48.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(IZI)V")
	protected final void initApplet(@OriginalArg(0) int arg0, @OriginalArg(1) boolean arg1, @OriginalArg(2) int arg2) {
		try {
			this.screenWidth = arg2;
			this.screenHeight = arg0;
			this.graphics = this.getBaseComponent(this.flowObfuscator5).getGraphics();
			this.drawArea = new DrawArea(this.getBaseComponent(this.flowObfuscator5), this.screenWidth, 299, this.screenHeight);
			if (arg1) {
				this.flowObfuscator3 = -370;
			}
			this.startThread(this, 1);
		} catch (@Pc(37) RuntimeException local37) {
			Signlink.reporterror("68129, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local37.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "run", descriptor = "()V")
	@Override
	public void run() {
		this.getBaseComponent(this.flowObfuscator5).addMouseListener(this);
		this.getBaseComponent(this.flowObfuscator5).addMouseMotionListener(this);
		this.getBaseComponent(this.flowObfuscator5).addKeyListener(this);
		this.getBaseComponent(this.flowObfuscator5).addFocusListener(this);
		if (this.frame != null) {
			this.frame.addWindowListener(this);
		}
		this.drawProgress(true, "Loading...", 0);
		this.load();
		@Pc(41) int local41 = 0;
		@Pc(43) int local43 = 256;
		@Pc(45) int local45 = 1;
		@Pc(47) int local47 = 0;
		for (@Pc(49) int local49 = 0; local49 < 10; local49++) {
			this.otim[local49] = System.currentTimeMillis();
		}
		@Pc(62) long local62 = System.currentTimeMillis();
		while (this.state >= 0) {
			if (this.state > 0) {
				this.state--;
				if (this.state == 0) {
					this.shutdown(-652);
					return;
				}
			}
			@Pc(82) int local82 = local43;
			@Pc(84) int local84 = local45;
			local43 = 300;
			local45 = 1;
			local62 = System.currentTimeMillis();
			if (this.otim[local41] == 0L) {
				local43 = local82;
				local45 = local84;
			} else if (local62 > this.otim[local41]) {
				local43 = (int) ((long) (this.deltime * 2560) / (local62 - this.otim[local41]));
			}
			if (local43 < 25) {
				local43 = 25;
			}
			if (local43 > 256) {
				local43 = 256;
				local45 = (int) ((long) this.deltime - (local62 - this.otim[local41]) / 10L);
			}
			this.otim[local41] = local62;
			local41 = (local41 + 1) % 10;
			if (local45 > 1) {
				for (@Pc(164) int local164 = 0; local164 < 10; local164++) {
					if (this.otim[local164] != 0L) {
						this.otim[local164] += local45;
					}
				}
			}
			if (local45 < this.mindel) {
				local45 = this.mindel;
			}
			try {
				Thread.sleep((long) local45);
			} catch (@Pc(198) InterruptedException local198) {
			}
			while (local47 < 256) {
				this.update(437);
				this.mouseClickButton = 0;
				this.keyQueueReadPos = this.keyQueueWritePos;
				local47 += local43;
			}
			local47 &= 0xFF;
			if (this.deltime > 0) {
				this.fps = local43 * 1000 / (this.deltime * 256);
			}
			this.draw(false);
		}
		if (this.state == -1) {
			this.shutdown(-652);
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(I)V")
	private void shutdown(@OriginalArg(0) int arg0) {
		try {
			while (arg0 >= 0) {
				this.flowObfuscator4 = !this.flowObfuscator4;
			}
			this.state = -2;
			this.unload((byte) -28);
			try {
				Thread.sleep(1000L);
			} catch (@Pc(21) Exception local21) {
			}
			try {
				System.exit(0);
			} catch (@Pc(25) Throwable local25) {
			}
		} catch (@Pc(27) RuntimeException local27) {
			Signlink.reporterror("31182, " + arg0 + ", " + local27.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(II)V")
	protected final void setFramerate(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			this.deltime = 1000 / arg1;
			if (arg0 <= 0) {
				this.flowObfuscator1 = !this.flowObfuscator1;
			}
		} catch (@Pc(16) RuntimeException local16) {
			Signlink.reporterror("9789, " + arg0 + ", " + arg1 + ", " + local16.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "start", descriptor = "()V")
	@Override
	public final void start() {
		if (this.state >= 0) {
			this.state = 0;
		}
	}

	@OriginalMember(owner = "client!a", name = "stop", descriptor = "()V")
	@Override
	public final void stop() {
		if (this.state >= 0) {
			this.state = 4000 / this.deltime;
		}
	}

	@OriginalMember(owner = "client!a", name = "destroy", descriptor = "()V")
	@Override
	public final void destroy() {
		this.state = -1;
		try {
			Thread.sleep(5000L);
		} catch (@Pc(6) Exception local6) {
		}
		if (this.state == -1) {
			this.shutdown(-652);
		}
	}

	@OriginalMember(owner = "client!a", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void update(@OriginalArg(0) Graphics arg0) {
		if (this.graphics == null) {
			this.graphics = arg0;
		}
		this.refresh = true;
		this.refresh(3);
	}

	@OriginalMember(owner = "client!a", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void paint(@OriginalArg(0) Graphics arg0) {
		if (this.graphics == null) {
			this.graphics = arg0;
		}
		this.refresh = true;
		this.refresh(3);
	}

	@OriginalMember(owner = "client!a", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mousePressed(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		if (this.frame != null) {
			local2 -= 4;
			local5 -= 22;
		}
		this.idleCycles = 0;
		this.mouseClickX = local2;
		this.mouseClickY = local5;
		if (arg0.isMetaDown()) {
			this.mouseClickButton = 2;
			this.mouseButton = 2;
		} else {
			this.mouseClickButton = 1;
			this.mouseButton = 1;
		}
		if (InputTracking.enabled) {
			InputTracking.mousePressed(local2, arg0.isMetaDown() ? 1 : 0, local5, (byte) 4);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseReleased(@OriginalArg(0) MouseEvent arg0) {
		this.idleCycles = 0;
		this.mouseButton = 0;
		if (InputTracking.enabled) {
			InputTracking.mouseReleased(arg0.isMetaDown() ? 1 : 0, 0);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseClicked(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseEntered(@OriginalArg(0) MouseEvent arg0) {
		if (InputTracking.enabled) {
			InputTracking.mouseEntered(-657);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseExited(@OriginalArg(0) MouseEvent arg0) {
		if (InputTracking.enabled) {
			InputTracking.mouseExited(false);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseDragged(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		if (this.frame != null) {
			local2 -= 4;
			local5 -= 22;
		}
		this.idleCycles = 0;
		this.mouseX = local2;
		this.mouseY = local5;
		if (InputTracking.enabled) {
			InputTracking.mouseMoved(local5, true, local2);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseMoved(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		if (this.frame != null) {
			local2 -= 4;
			local5 -= 22;
		}
		this.idleCycles = 0;
		this.mouseX = local2;
		this.mouseY = local5;
		if (InputTracking.enabled) {
			InputTracking.mouseMoved(local5, true, local2);
		}
	}

	@OriginalMember(owner = "client!a", name = "keyPressed", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public final void keyPressed(@OriginalArg(0) KeyEvent arg0) {
		this.idleCycles = 0;
		@Pc(7) int local7 = arg0.getKeyCode();
		@Pc(10) int local10 = arg0.getKeyChar();
		if (local10 < 30) {
			local10 = 0;
		}
		if (local7 == 37) {
			local10 = 1;
		}
		if (local7 == 39) {
			local10 = 2;
		}
		if (local7 == 38) {
			local10 = 3;
		}
		if (local7 == 40) {
			local10 = 4;
		}
		if (local7 == 17) {
			local10 = 5;
		}
		if (local7 == 8) {
			local10 = 8;
		}
		if (local7 == 127) {
			local10 = 8;
		}
		if (local7 == 9) {
			local10 = 9;
		}
		if (local7 == 10) {
			local10 = 10;
		}
		if (local7 >= 112 && local7 <= 123) {
			local10 = local7 + 1008 - 112;
		}
		if (local7 == 36) {
			local10 = 1000;
		}
		if (local7 == 35) {
			local10 = 1001;
		}
		if (local7 == 33) {
			local10 = 1002;
		}
		if (local7 == 34) {
			local10 = 1003;
		}
		if (local10 > 0 && local10 < 128) {
			this.actionKey[local10] = 1;
		}
		if (local10 > 4) {
			this.keyQueue[this.keyQueueWritePos] = local10;
			this.keyQueueWritePos = this.keyQueueWritePos + 1 & 0x7F;
		}
		if (InputTracking.enabled) {
			InputTracking.keyPressed(local10, true);
		}
	}

	@OriginalMember(owner = "client!a", name = "keyReleased", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public final void keyReleased(@OriginalArg(0) KeyEvent arg0) {
		this.idleCycles = 0;
		@Pc(5) int local5 = arg0.getKeyCode();
		@Pc(8) char local8 = arg0.getKeyChar();
		if (local8 < '\u001e') {
			local8 = '\u0000';
		}
		if (local5 == 37) {
			local8 = '\u0001';
		}
		if (local5 == 39) {
			local8 = '\u0002';
		}
		if (local5 == 38) {
			local8 = '\u0003';
		}
		if (local5 == 40) {
			local8 = '\u0004';
		}
		if (local5 == 17) {
			local8 = '\u0005';
		}
		if (local5 == 8) {
			local8 = '\b';
		}
		if (local5 == 127) {
			local8 = '\b';
		}
		if (local5 == 9) {
			local8 = '\t';
		}
		if (local5 == 10) {
			local8 = '\n';
		}
		if (local8 > '\u0000' && local8 < '\u0080') {
			this.actionKey[local8] = 0;
		}
		if (InputTracking.enabled) {
			InputTracking.keyReleased(local8, 1);
		}
	}

	@OriginalMember(owner = "client!a", name = "keyTyped", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public final void keyTyped(@OriginalArg(0) KeyEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "focusGained", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusGained(@OriginalArg(0) FocusEvent arg0) {
		this.refresh = true;
		this.refresh(3);
		if (InputTracking.enabled) {
			InputTracking.focusGained(-936);
		}
	}

	@OriginalMember(owner = "client!a", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusLost(@OriginalArg(0) FocusEvent arg0) {
		if (InputTracking.enabled) {
			InputTracking.focusLost(0);
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(Z)I")
	protected final int pollKey(@OriginalArg(0) boolean arg0) {
		try {
			@Pc(1) int local1 = -1;
			if (arg0) {
				return 2;
			}
			if (this.keyQueueWritePos != this.keyQueueReadPos) {
				local1 = this.keyQueue[this.keyQueueReadPos];
				this.keyQueueReadPos = this.keyQueueReadPos + 1 & 0x7F;
			}
			return local1;
		} catch (@Pc(27) RuntimeException local27) {
			Signlink.reporterror("3026, " + arg0 + ", " + local27.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowActivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowClosed(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		this.destroy();
	}

	@OriginalMember(owner = "client!a", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowDeactivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowIconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowOpened(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "()V")
	protected void load() {
	}

	@OriginalMember(owner = "client!a", name = "b", descriptor = "(I)V")
	protected void update(@OriginalArg(0) int arg0) {
		try {
			if (arg0 <= 0) {
				this.flowObfuscator2 = !this.flowObfuscator2;
			}
		} catch (@Pc(11) RuntimeException local11) {
			Signlink.reporterror("39582, " + arg0 + ", " + local11.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(B)V")
	protected void unload(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != -28) {
				this.flowObfuscator6 = -407;
			}
		} catch (@Pc(7) RuntimeException local7) {
			Signlink.reporterror("60526, " + arg0 + ", " + local7.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "b", descriptor = "(Z)V")
	protected void draw(@OriginalArg(0) boolean arg0) {
		try {
			if (arg0) {
				this.flowObfuscator4 = !this.flowObfuscator4;
			}
		} catch (@Pc(11) RuntimeException local11) {
			Signlink.reporterror("89494, " + arg0 + ", " + local11.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "c", descriptor = "(I)V")
	protected void refresh(@OriginalArg(0) int arg0) {
		try {
			if (arg0 < 3 || arg0 > 3) {
				this.flowObfuscator2 = !this.flowObfuscator2;
			}
		} catch (@Pc(15) RuntimeException local15) {
			Signlink.reporterror("40825, " + arg0 + ", " + local15.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "b", descriptor = "(B)Ljava/awt/Component;")
	protected Component getBaseComponent(@OriginalArg(0) byte arg0) {
		try {
			if (arg0 != 3) {
				throw new NullPointerException();
			}
			return this.frame == null ? this : this.frame;
		} catch (@Pc(15) RuntimeException local15) {
			Signlink.reporterror("24145, " + arg0 + ", " + local15.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	public void startThread(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		@Pc(4) Thread local4 = new Thread(arg0);
		local4.start();
		local4.setPriority(arg1);
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(ZLjava/lang/String;I)V")
	protected void drawProgress(@OriginalArg(0) boolean arg0, @OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		try {
			while (this.graphics == null) {
				this.graphics = this.getBaseComponent(this.flowObfuscator5).getGraphics();
				try {
					this.getBaseComponent(this.flowObfuscator5).repaint();
				} catch (@Pc(22) Exception local22) {
				}
				try {
					Thread.sleep(1000L);
				} catch (@Pc(26) Exception local26) {
				}
			}
			@Pc(37) Font local37 = new Font("Helvetica", 1, 13);
			@Pc(44) FontMetrics local44 = this.getBaseComponent(this.flowObfuscator5).getFontMetrics(local37);
			@Pc(51) Font local51 = new Font("Helvetica", 0, 13);
			this.getBaseComponent(this.flowObfuscator5).getFontMetrics(local51);
			if (this.refresh) {
				this.graphics.setColor(Color.black);
				this.graphics.fillRect(0, 0, this.screenWidth, this.screenHeight);
				this.refresh = false;
			}
			@Pc(84) Color local84 = new Color(140, 17, 17);
			@Pc(91) int local91 = this.screenHeight / 2 - 18;
			this.graphics.setColor(local84);
			this.graphics.drawRect(this.screenWidth / 2 - 152, local91, 304, 34);
			this.graphics.fillRect(this.screenWidth / 2 - 150, local91 + 2, arg2 * 3, 30);
			this.graphics.setColor(Color.black);
			this.graphics.fillRect(this.screenWidth / 2 + arg2 * 3 - 150, local91 + 2, 300 - arg2 * 3, 30);
			this.graphics.setFont(local37);
			this.graphics.setColor(Color.white);
			if (arg0) {
				this.graphics.drawString(arg1, (this.screenWidth - local44.stringWidth(arg1)) / 2, local91 + 22);
			}
		} catch (@Pc(177) RuntimeException local177) {
			Signlink.reporterror("55533, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + local177.toString());
			throw new RuntimeException();
		}
	}
}
