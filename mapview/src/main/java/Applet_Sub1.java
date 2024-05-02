import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

@OriginalClass("mapview!a")
public class Applet_Sub1 extends Applet implements Runnable, MouseListener, MouseMotionListener, KeyListener, FocusListener, WindowListener {

	@OriginalMember(owner = "mapview!a", name = "g", descriptor = "I")
	private int anInt99;

	@OriginalMember(owner = "mapview!a", name = "h", descriptor = "I")
	private int anInt100;

	@OriginalMember(owner = "mapview!a", name = "i", descriptor = "Ljava/awt/Graphics;")
	protected Graphics aGraphics2;

	@OriginalMember(owner = "mapview!a", name = "j", descriptor = "Lmapview!m;")
	protected Class4 aClass4_2;

	@OriginalMember(owner = "mapview!a", name = "l", descriptor = "Lmapview!b;")
	protected Frame_Sub1 aFrame_Sub1_2;

	@OriginalMember(owner = "mapview!a", name = "a", descriptor = "I")
	private int anInt95 = 0;

	@OriginalMember(owner = "mapview!a", name = "b", descriptor = "I")
	private int anInt96 = 20;

	@OriginalMember(owner = "mapview!a", name = "c", descriptor = "I")
	private int anInt97 = 1;

	@OriginalMember(owner = "mapview!a", name = "d", descriptor = "[J")
	private long[] aLongArray2 = new long[10];

	@OriginalMember(owner = "mapview!a", name = "e", descriptor = "I")
	private int anInt98 = 0;

	@OriginalMember(owner = "mapview!a", name = "f", descriptor = "Z")
	private boolean aBoolean21 = false;

	@OriginalMember(owner = "mapview!a", name = "k", descriptor = "[Lmapview!h;")
	private Class2_Sub1_Sub1_Sub2[] aClass2_Sub1_Sub1_Sub2Array2 = new Class2_Sub1_Sub1_Sub2[6];

	@OriginalMember(owner = "mapview!a", name = "m", descriptor = "Z")
	private boolean aBoolean22 = true;

	@OriginalMember(owner = "mapview!a", name = "n", descriptor = "Z")
	private boolean aBoolean23 = true;

	@OriginalMember(owner = "mapview!a", name = "o", descriptor = "I")
	private int anInt101 = 0;

	@OriginalMember(owner = "mapview!a", name = "p", descriptor = "I")
	protected int anInt102 = 0;

	@OriginalMember(owner = "mapview!a", name = "q", descriptor = "I")
	protected int anInt103 = 0;

	@OriginalMember(owner = "mapview!a", name = "r", descriptor = "I")
	protected int anInt104 = 0;

	@OriginalMember(owner = "mapview!a", name = "s", descriptor = "I")
	private int anInt105 = 0;

	@OriginalMember(owner = "mapview!a", name = "t", descriptor = "I")
	private int anInt106 = 0;

	@OriginalMember(owner = "mapview!a", name = "u", descriptor = "I")
	private int anInt107 = 0;

	@OriginalMember(owner = "mapview!a", name = "v", descriptor = "J")
	private long aLong5 = 0L;

	@OriginalMember(owner = "mapview!a", name = "w", descriptor = "I")
	protected int anInt108 = 0;

	@OriginalMember(owner = "mapview!a", name = "x", descriptor = "I")
	protected int anInt109 = 0;

	@OriginalMember(owner = "mapview!a", name = "y", descriptor = "I")
	protected int anInt110 = 0;

	@OriginalMember(owner = "mapview!a", name = "z", descriptor = "J")
	private long aLong6 = 0L;

	@OriginalMember(owner = "mapview!a", name = "A", descriptor = "[I")
	protected int[] anIntArray21 = new int[128];

	@OriginalMember(owner = "mapview!a", name = "B", descriptor = "[I")
	private int[] anIntArray22 = new int[128];

	@OriginalMember(owner = "mapview!a", name = "C", descriptor = "I")
	private int anInt111 = 0;

	@OriginalMember(owner = "mapview!a", name = "D", descriptor = "I")
	private int anInt112 = 0;

	@OriginalMember(owner = "mapview!a", name = "stop", descriptor = "()V")
	@Override
	public final void stop() {
		if (this.anInt95 >= 0) {
			this.anInt95 = 4000 / this.anInt96;
		}
	}

	@OriginalMember(owner = "mapview!a", name = "a", descriptor = "()V")
	protected void method110() {
	}

	@OriginalMember(owner = "mapview!a", name = "a", descriptor = "(ILjava/lang/String;)V")
	protected final void method111(@OriginalArg(0) int arg0, @OriginalArg(1) String arg1) {
		while (this.aGraphics2 == null) {
			this.aGraphics2 = this.method118().getGraphics();
			try {
				this.method118().repaint();
			} catch (@Pc(18) Exception local18) {
			}
			try {
				Thread.sleep(1000L);
			} catch (@Pc(22) Exception local22) {
			}
		}
		@Pc(32) Font local32 = new Font("Helvetica", 1, 13);
		@Pc(37) FontMetrics local37 = this.method118().getFontMetrics(local32);
		@Pc(44) Font local44 = new Font("Helvetica", 0, 13);
		@Pc(49) FontMetrics local49 = this.method118().getFontMetrics(local44);
		if (this.aBoolean22) {
			this.aGraphics2.setColor(Color.black);
			this.aGraphics2.fillRect(0, 0, this.anInt99, this.anInt100);
			this.aBoolean22 = false;
		}
		@Pc(75) Color local75 = new Color(140, 17, 17);
		@Pc(82) int local82 = this.anInt100 / 2 - 18;
		this.aGraphics2.setColor(local75);
		this.aGraphics2.drawRect(this.anInt99 / 2 - 152, local82, 304, 34);
		this.aGraphics2.fillRect(this.anInt99 / 2 - 150, local82 + 2, arg0 * 3, 30);
		this.aGraphics2.setColor(Color.black);
		this.aGraphics2.fillRect(this.anInt99 / 2 - 150 + arg0 * 3, local82 + 2, 300 - arg0 * 3, 30);
		this.aGraphics2.setFont(local32);
		this.aGraphics2.setColor(Color.white);
		this.aGraphics2.drawString(arg1, (this.anInt99 - local37.stringWidth(arg1)) / 2, local82 + 22);
	}

	@OriginalMember(owner = "mapview!a", name = "mouseReleased", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseReleased(@OriginalArg(0) MouseEvent arg0) {
		this.anInt101 = 0;
		this.anInt102 = 0;
		if (Class1.aBoolean5) {
			Class1.method18(arg0.isMetaDown() ? 1 : 0);
		}
	}

	@OriginalMember(owner = "mapview!a", name = "keyPressed", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public final void keyPressed(@OriginalArg(0) KeyEvent arg0) {
		this.anInt101 = 0;
		@Pc(5) int local5 = arg0.getKeyCode();
		@Pc(8) int local8 = arg0.getKeyChar();
		if (local8 < 30) {
			local8 = 0;
		}
		if (local5 == 37) {
			local8 = 1;
		}
		if (local5 == 39) {
			local8 = 2;
		}
		if (local5 == 38) {
			local8 = 3;
		}
		if (local5 == 40) {
			local8 = 4;
		}
		if (local5 == 17) {
			local8 = 5;
		}
		if (local5 == 8) {
			local8 = 8;
		}
		if (local5 == 127) {
			local8 = 8;
		}
		if (local5 == 9) {
			local8 = 9;
		}
		if (local5 == 10) {
			local8 = 10;
		}
		if (local5 >= 112 && local5 <= 123) {
			local8 = local5 + 1008 - 112;
		}
		if (local5 == 36) {
			local8 = 1000;
		}
		if (local5 == 35) {
			local8 = 1001;
		}
		if (local5 == 33) {
			local8 = 1002;
		}
		if (local5 == 34) {
			local8 = 1003;
		}
		if (local8 > 0 && local8 < 128) {
			this.anIntArray21[local8] = 1;
		}
		if (local8 > 4) {
			this.anIntArray22[this.anInt112] = local8;
			this.anInt112 = this.anInt112 + 1 & 0x7F;
		}
		if (Class1.aBoolean5) {
			Class1.method19(local8);
		}
	}

	@OriginalMember(owner = "mapview!a", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	private void method112(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		@Pc(4) Thread local4 = new Thread(arg0);
		local4.start();
		local4.setPriority(arg1);
	}

	@OriginalMember(owner = "mapview!a", name = "windowClosing", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowClosing(@OriginalArg(0) WindowEvent arg0) {
		this.destroy();
	}

	@OriginalMember(owner = "mapview!a", name = "b", descriptor = "()V")
	private void method113() {
		this.anInt95 = -2;
		this.method120();
		if (this.aFrame_Sub1_2 == null) {
			return;
		}
		try {
			Thread.sleep(1000L);
		} catch (@Pc(11) Exception local11) {
		}
		try {
			System.exit(0);
		} catch (@Pc(15) Throwable local15) {
		}
	}

	@OriginalMember(owner = "mapview!a", name = "update", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void update(@OriginalArg(0) Graphics arg0) {
		if (this.aGraphics2 == null) {
			this.aGraphics2 = arg0;
		}
		this.aBoolean22 = true;
		this.method110();
	}

	@OriginalMember(owner = "mapview!a", name = "mouseEntered", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseEntered(@OriginalArg(0) MouseEvent arg0) {
		if (Class1.aBoolean5) {
			Class1.method20();
		}
	}

	@OriginalMember(owner = "mapview!a", name = "mouseExited", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseExited(@OriginalArg(0) MouseEvent arg0) {
		this.anInt101 = 0;
		this.anInt103 = -1;
		this.anInt104 = -1;
		if (Class1.aBoolean5) {
			Class1.method21();
		}
	}

	@OriginalMember(owner = "mapview!a", name = "windowOpened", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowOpened(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "windowDeiconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowDeiconified(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "windowActivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowActivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "c", descriptor = "()V")
	protected void method114() {
	}

	@OriginalMember(owner = "mapview!a", name = "start", descriptor = "()V")
	@Override
	public final void start() {
		if (this.anInt95 >= 0) {
			this.anInt95 = 0;
		}
	}

	@OriginalMember(owner = "mapview!a", name = "a", descriptor = "(II)V")
	protected final void method115(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anInt99 = arg0;
		this.anInt100 = arg1;
		this.aFrame_Sub1_2 = new Frame_Sub1(this, this.anInt99, this.anInt100);
		this.aGraphics2 = this.method118().getGraphics();
		this.aClass4_2 = new Class4(this.anInt99, this.anInt100, this.method118());
		this.method112(this, 1);
	}

	@OriginalMember(owner = "mapview!a", name = "d", descriptor = "()I")
	protected final int method116() {
		@Pc(1) int local1 = -1;
		if (this.anInt112 != this.anInt111) {
			local1 = this.anIntArray22[this.anInt111];
			this.anInt111 = this.anInt111 + 1 & 0x7F;
		}
		return local1;
	}

	@OriginalMember(owner = "mapview!a", name = "e", descriptor = "()V")
	protected void method117() {
	}

	@OriginalMember(owner = "mapview!a", name = "f", descriptor = "()Ljava/awt/Component;")
	public final Component method118() {
		return this.aFrame_Sub1_2 == null ? this : this.aFrame_Sub1_2;
	}

	@OriginalMember(owner = "mapview!a", name = "mouseClicked", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseClicked(@OriginalArg(0) MouseEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "mousePressed", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mousePressed(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		if (this.aFrame_Sub1_2 != null) {
			local2 -= 4;
			local5 -= 22;
		}
		this.anInt101 = 0;
		this.anInt106 = local2;
		this.anInt107 = local5;
		this.aLong5 = System.currentTimeMillis();
		if (arg0.isMetaDown()) {
			this.anInt105 = 2;
			this.anInt102 = 2;
		} else {
			this.anInt105 = 1;
			this.anInt102 = 1;
		}
		if (Class1.aBoolean5) {
			Class1.method16(local2, local5, arg0.isMetaDown() ? 1 : 0);
		}
	}

	@OriginalMember(owner = "mapview!a", name = "mouseDragged", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseDragged(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		if (this.aFrame_Sub1_2 != null) {
			local2 -= 4;
			local5 -= 22;
		}
		this.anInt101 = 0;
		this.anInt103 = local2;
		this.anInt104 = local5;
		if (Class1.aBoolean5) {
			Class1.method14(local2, local5);
		}
	}

	@OriginalMember(owner = "mapview!a", name = "b", descriptor = "(II)V")
	protected final void method119(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		this.anInt99 = arg0;
		this.anInt100 = arg1;
		this.aGraphics2 = this.method118().getGraphics();
		this.aClass4_2 = new Class4(this.anInt99, this.anInt100, this.method118());
		this.method112(this, 1);
	}

	@OriginalMember(owner = "mapview!a", name = "mouseMoved", descriptor = "(Ljava/awt/event/MouseEvent;)V")
	@Override
	public final void mouseMoved(@OriginalArg(0) MouseEvent arg0) {
		@Pc(2) int local2 = arg0.getX();
		@Pc(5) int local5 = arg0.getY();
		if (this.aFrame_Sub1_2 != null) {
			local2 -= 4;
			local5 -= 22;
		}
		this.anInt101 = 0;
		this.anInt103 = local2;
		this.anInt104 = local5;
		if (Class1.aBoolean5) {
			Class1.method14(local2, local5);
		}
	}

	@OriginalMember(owner = "mapview!a", name = "keyTyped", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public final void keyTyped(@OriginalArg(0) KeyEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "windowDeactivated", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowDeactivated(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "paint", descriptor = "(Ljava/awt/Graphics;)V")
	@Override
	public final void paint(@OriginalArg(0) Graphics arg0) {
		if (this.aGraphics2 == null) {
			this.aGraphics2 = arg0;
		}
		this.aBoolean22 = true;
		this.method110();
	}

	@OriginalMember(owner = "mapview!a", name = "destroy", descriptor = "()V")
	@Override
	public final void destroy() {
		this.anInt95 = -1;
		try {
			Thread.sleep(5000L);
		} catch (@Pc(6) Exception local6) {
		}
		if (this.anInt95 == -1) {
			this.method113();
		}
	}

	@OriginalMember(owner = "mapview!a", name = "g", descriptor = "()V")
	protected void method120() {
	}

	@OriginalMember(owner = "mapview!a", name = "h", descriptor = "()V")
	protected void method121() {
	}

	@OriginalMember(owner = "mapview!a", name = "focusLost", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusLost(@OriginalArg(0) FocusEvent arg0) {
		this.aBoolean23 = false;
		if (Class1.aBoolean5) {
			Class1.method17();
		}
	}

	@OriginalMember(owner = "mapview!a", name = "keyReleased", descriptor = "(Ljava/awt/event/KeyEvent;)V")
	@Override
	public final void keyReleased(@OriginalArg(0) KeyEvent arg0) {
		this.anInt101 = 0;
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
			this.anIntArray21[local8] = 0;
		}
		if (Class1.aBoolean5) {
			Class1.method22(local8);
		}
	}

	@OriginalMember(owner = "mapview!a", name = "windowClosed", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowClosed(@OriginalArg(0) WindowEvent arg0) {
	}

	@OriginalMember(owner = "mapview!a", name = "run", descriptor = "()V")
	@Override
	public final void run() {
		this.method118().addMouseListener(this);
		this.method118().addMouseMotionListener(this);
		this.method118().addKeyListener(this);
		this.method118().addFocusListener(this);
		if (this.aFrame_Sub1_2 != null) {
			this.aFrame_Sub1_2.addWindowListener(this);
		}
		this.method111(0, "Loading...");
		this.method114();
		@Pc(32) int local32 = 0;
		@Pc(34) int local34 = 256;
		@Pc(36) int local36 = 1;
		@Pc(38) int local38 = 0;
		@Pc(40) int local40 = 0;
		@Pc(42) int local42;
		for (local42 = 0; local42 < 10; local42++) {
			this.aLongArray2[local42] = System.currentTimeMillis();
		}
		@Pc(55) long local55 = System.currentTimeMillis();
		while (true) {
			@Pc(163) int local163;
			do {
				if (this.anInt95 < 0) {
					if (this.anInt95 == -1) {
						this.method113();
					}
					return;
				}
				if (this.anInt95 > 0) {
					this.anInt95 += -1;
					if (this.anInt95 == 0) {
						this.method113();
						return;
					}
				}
				local42 = local34;
				@Pc(76) int local76 = local36;
				local34 = 300;
				local36 = 1;
				local55 = System.currentTimeMillis();
				if (this.aLongArray2[local32] == 0L) {
					local34 = local42;
					local36 = local76;
				} else if (local55 > this.aLongArray2[local32]) {
					local34 = (int) ((long) (this.anInt96 * 2560) / (local55 - this.aLongArray2[local32]));
				}
				if (local34 < 25) {
					local34 = 25;
				}
				if (local34 > 256) {
					local34 = 256;
					local36 = (int) ((long) this.anInt96 - (local55 - this.aLongArray2[local32]) / 10L);
				}
				if (local36 > this.anInt96) {
					local36 = this.anInt96;
				}
				this.aLongArray2[local32] = local55;
				local32 = (local32 + 1) % 10;
				if (local36 > 1) {
					for (local163 = 0; local163 < 10; local163++) {
						if (this.aLongArray2[local163] != 0L) {
							this.aLongArray2[local163] += local36;
						}
					}
				}
				if (local36 < this.anInt97) {
					local36 = this.anInt97;
				}
				try {
					Thread.sleep((long) local36);
				} catch (@Pc(197) InterruptedException local197) {
					local40++;
				}
				while (local38 < 256) {
					this.anInt108 = this.anInt105;
					this.anInt109 = this.anInt106;
					this.anInt110 = this.anInt107;
					this.aLong6 = this.aLong5;
					this.anInt105 = 0;
					this.method121();
					this.anInt111 = this.anInt112;
					local38 += local34;
				}
				local38 &= 0xFF;
				if (this.anInt96 > 0) {
					this.anInt98 = local34 * 1000 / (this.anInt96 * 256);
				}
				this.method117();
			} while (!this.aBoolean21);
			System.out.println("ntime:" + local55);
			for (local163 = 0; local163 < 10; local163++) {
				@Pc(278) int local278 = (local32 - local163 - 1 + 20) % 10;
				System.out.println("otim" + local278 + ":" + this.aLongArray2[local278]);
			}
			System.out.println("fps:" + this.anInt98 + " ratio:" + local34 + " count:" + local38);
			System.out.println("del:" + local36 + " deltime:" + this.anInt96 + " mindel:" + this.anInt97);
			System.out.println("intex:" + local40 + " opos:" + local32);
			this.aBoolean21 = false;
			local40 = 0;
		}
	}

	@OriginalMember(owner = "mapview!a", name = "focusGained", descriptor = "(Ljava/awt/event/FocusEvent;)V")
	@Override
	public final void focusGained(@OriginalArg(0) FocusEvent arg0) {
		this.aBoolean23 = true;
		this.aBoolean22 = true;
		this.method110();
		if (Class1.aBoolean5) {
			Class1.method15();
		}
	}

	@OriginalMember(owner = "mapview!a", name = "windowIconified", descriptor = "(Ljava/awt/event/WindowEvent;)V")
	@Override
	public final void windowIconified(@OriginalArg(0) WindowEvent arg0) {
	}
}
