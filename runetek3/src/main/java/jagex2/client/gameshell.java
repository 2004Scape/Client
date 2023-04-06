package jagex2.client;

import jagex2.graphics.DrawArea;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

@OriginalClass("client!a")
public class gameshell extends Applet implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener, KeyListener, FocusListener, WindowListener {

	public final double[] frameTime = new double[100];
	int fpos = 0;

	@OriginalMember(owner = "client!a", name = "g", descriptor = "I")
	private int state;

	@OriginalMember(owner = "client!a", name = "h", descriptor = "I")
	private int deltime = 20;

	@OriginalMember(owner = "client!a", name = "i", descriptor = "I")
	protected int mindel = 1;

	@OriginalMember(owner = "client!a", name = "j", descriptor = "[J")
	private final long[] otim = new long[10];

	@OriginalMember(owner = "client!a", name = "k", descriptor = "I")
	protected int fps;

	@OriginalMember(owner = "client!a", name = "l", descriptor = "I")
	protected int screenWidth;

	@OriginalMember(owner = "client!a", name = "m", descriptor = "I")
	protected int screenHeight;

	@OriginalMember(owner = "client!a", name = "n", descriptor = "Ljava/awt/Graphics;")
	protected Graphics graphics;

	@OriginalMember(owner = "client!a", name = "o", descriptor = "Lclient!qb;")
	protected DrawArea drawArea;

	@OriginalMember(owner = "client!a", name = "q", descriptor = "Lclient!b;")
	protected gameframe frame;

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

	private boolean mouseWheelDown = false;
	private int mouseWheelX = 0;
	private int mouseWheelY = 0;

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(III)V")
	protected final void initApplication(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.screenWidth = arg1;
		this.screenHeight = arg0;
		this.setPreferredSize(new Dimension(this.screenWidth, this.screenHeight));
		this.frame = new gameframe(this);
		this.graphics = this.getBaseComponent().getGraphics();
		this.drawArea = new DrawArea(this.getBaseComponent(), this.screenWidth, this.screenHeight);
		this.startThread(this, 1);
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(IZI)V")
	protected final void initApplet(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2) {
		this.screenWidth = arg2;
		this.screenHeight = arg0;
		this.graphics = this.getBaseComponent().getGraphics();
		this.drawArea = new DrawArea(this.getBaseComponent(), this.screenWidth, this.screenHeight);
		this.startThread(this, 1);
	}

	@OriginalMember(owner = "client!a", name = "run", descriptor = "()V")
	@Override
	public void run() {
		this.getBaseComponent().addMouseListener(this);
		this.getBaseComponent().addMouseMotionListener(this);
		this.getBaseComponent().addMouseWheelListener(this);
		this.getBaseComponent().addKeyListener(this);
		this.getBaseComponent().addFocusListener(this);
		if (this.frame != null) {
			this.frame.addWindowListener(this);
		}

		this.drawProgress("Loading...", 0);
		this.load();

		@Pc(41) int opos = 0;
		@Pc(43) int ratio = 256;
		@Pc(45) int delta = 1;
		@Pc(47) int count = 0;
		for (@Pc(49) int local49 = 0; local49 < 10; local49++) {
			this.otim[local49] = System.currentTimeMillis();
		}

		@Pc(62) long ntime = System.currentTimeMillis();
		while (this.state >= 0) {
			if (this.state > 0) {
				this.state--;
				if (this.state == 0) {
					this.shutdown();
					return;
				}
			}

			@Pc(82) int local82 = ratio;
			@Pc(84) int local84 = delta;
			ratio = 300;
			delta = 1;

			ntime = System.currentTimeMillis();

			if (this.otim[opos] == 0L) {
				ratio = local82;
				delta = local84;
			} else if (ntime > this.otim[opos]) {
				ratio = (int) ((long) (this.deltime * 2560) / (ntime - this.otim[opos]));
			}

			if (ratio < 25) {
				ratio = 25;
			}

			if (ratio > 256) {
				ratio = 256;
				delta = (int) ((long) this.deltime - (ntime - this.otim[opos]) / 10L);
			}

			this.otim[opos] = ntime;
			opos = (opos + 1) % 10;

			if (delta > 1) {
				for (@Pc(164) int i = 0; i < 10; i++) {
					if (this.otim[i] != 0L) {
						this.otim[i] += delta;
					}
				}
			}

			if (delta < this.mindel) {
				delta = this.mindel;
			}

			try {
				Thread.sleep((long) delta);
			} catch (@Pc(198) InterruptedException ignored) {
			}

			long time = System.nanoTime();

			while (count < 256) {
				this.update();
				this.mouseClickButton = 0;
				this.keyQueueReadPos = this.keyQueueWritePos;
				count += ratio;
			}

			count &= 0xFF;

			if (this.deltime > 0) {
				this.fps = ratio * 1000 / (this.deltime * 256);
			}

			this.draw();

			frameTime[fpos] = (double) (System.nanoTime() - time) / 1_000_000.0;
			fpos = (fpos + 1) % frameTime.length;
		}

		if (this.state == -1) {
			this.shutdown();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(I)V")
	private void shutdown() {
		this.state = -2;
		this.unload();
		try {
			Thread.sleep(1000L);
		} catch (@Pc(21) Exception local21) {
		}
		try {
			System.exit(0);
		} catch (@Pc(25) Throwable local25) {
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(II)V")
	protected final void setFramerate(@OriginalArg(1) int arg1) {
		this.deltime = 1000 / arg1;
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
			this.shutdown();
		}
	}

	@OriginalMember(owner = "client!a", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void update(@OriginalArg(0) Graphics arg0) {
		if (this.graphics == null) {
			this.graphics = arg0;
		}
		this.refresh = true;
		this.refresh();
	}

	@OriginalMember(owner = "client!a", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void paint(@OriginalArg(0) Graphics arg0) {
		if (this.graphics == null) {
			this.graphics = arg0;
		}
		this.refresh = true;
		this.refresh();
	}

	@OriginalMember(owner = "client!a", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mousePressed(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		this.idleCycles = 0;
		this.mouseClickX = local2;
		this.mouseClickY = local5;

		if ((arg0.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0) {
			this.mouseClickButton = 2;
			this.mouseButton = 2;
		} else if ((arg0.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0) {
			this.mouseClickButton = 1;
			this.mouseButton = 1;
		} else if ((arg0.getModifiersEx() & MouseEvent.BUTTON2_DOWN_MASK) != 0) {
			this.mouseWheelDown = true;
		}

		if (trackinput.enabled && ((arg0.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0 || (arg0.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0)) {
			trackinput.mousePressed(local2, (arg0.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0 ? 1 : 0, local5);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseReleased(@OriginalArg(0) MouseEvent arg0) {
		this.idleCycles = 0;
		this.mouseButton = 0;
		this.mouseWheelDown = false;

		if (trackinput.enabled && ((arg0.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0 || (arg0.getModifiersEx() & MouseEvent.BUTTON1_DOWN_MASK) != 0)) {
			trackinput.mouseReleased((arg0.getModifiersEx() & MouseEvent.BUTTON3_DOWN_MASK) != 0 ? 1 : 0);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseClicked(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "client!a", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseEntered(@OriginalArg(0) MouseEvent arg0) {
		if (trackinput.enabled) {
			trackinput.mouseEntered();
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseExited(@OriginalArg(0) MouseEvent arg0) {
		if (trackinput.enabled) {
			trackinput.mouseExited();
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseDragged(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		this.idleCycles = 0;
		this.mouseX = local2;
		this.mouseY = local5;

		if (this.mouseWheelDown) {
			this.mouseWheelDragged(this.mouseWheelX - this.mouseX, -(this.mouseWheelY - this.mouseY));
			this.mouseWheelX = local2;
			this.mouseWheelY = local5;
		}

		if (trackinput.enabled) {
			trackinput.mouseMoved(local5, local2);
		}
	}

	@OriginalMember(owner = "client!a", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseMoved(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		this.idleCycles = 0;
		this.mouseX = local2;
		this.mouseY = local5;
		if (trackinput.enabled) {
			trackinput.mouseMoved(local5, local2);
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
		if (trackinput.enabled) {
			trackinput.keyPressed(local10);
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
		if (trackinput.enabled) {
			trackinput.keyReleased(local8);
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
		this.refresh();
		if (trackinput.enabled) {
			trackinput.focusGained();
		}
	}

	@OriginalMember(owner = "client!a", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusLost(@OriginalArg(0) FocusEvent arg0) {
		if (trackinput.enabled) {
			trackinput.focusLost();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(Z)I")
	protected final int pollKey() {
		@Pc(1) int local1 = -1;
		if (this.keyQueueWritePos != this.keyQueueReadPos) {
			local1 = this.keyQueue[this.keyQueueReadPos];
			this.keyQueueReadPos = this.keyQueueReadPos + 1 & 0x7F;
		}
		return local1;
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
	protected void update() {
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(B)V")
	protected void unload() {
	}

	@OriginalMember(owner = "client!a", name = "b", descriptor = "(Z)V")
	protected void draw() {
	}

	@OriginalMember(owner = "client!a", name = "c", descriptor = "(I)V")
	protected void refresh() {
	}

	@OriginalMember(owner = "client!a", name = "b", descriptor = "(B)Ljava/awt/Component;")
	protected Component getBaseComponent() {
		return this;
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	public void startThread(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		@Pc(4) Thread local4 = new Thread(arg0);
		local4.start();
		local4.setPriority(arg1);
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(ZLjava/lang/String;I)V")
	protected void drawProgress(@OriginalArg(1) String arg1, @OriginalArg(2) int arg2) {
		while (this.graphics == null) {
			this.graphics = this.getBaseComponent().getGraphics();
			try {
				this.getBaseComponent().repaint();
			} catch (@Pc(22) Exception local22) {
			}
			try {
				Thread.sleep(1000L);
			} catch (@Pc(26) Exception local26) {
			}
		}
		@Pc(37) Font local37 = new Font("Helvetica", 1, 13);
		@Pc(44) FontMetrics local44 = this.getBaseComponent().getFontMetrics(local37);
		@Pc(51) Font local51 = new Font("Helvetica", 0, 13);
		this.getBaseComponent().getFontMetrics(local51);
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
		this.graphics.drawString(arg1, (this.screenWidth - local44.stringWidth(arg1)) / 2, local91 + 22);
	}

	protected void mouseWheelMoved(int rotation) {
	}

	protected void mouseWheelDragged(int x, int y) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		this.mouseWheelMoved(e.getWheelRotation());
	}
}
