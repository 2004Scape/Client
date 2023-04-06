package jagex2.client;

import jagex2.graphics.DrawArea;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import org.teavm.jso.JSBody;
import org.teavm.jso.browser.Window;
import org.teavm.jso.canvas.CanvasRenderingContext2D;
import org.teavm.jso.canvas.ImageData;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;
import org.teavm.jso.dom.events.MouseEvent;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.TextRectangle;

@OriginalClass("client!a")
public class gameshell implements Runnable {

	public static int KEY_LEFT = 1;
	public static int KEY_RIGHT = 2;
	public static int KEY_UP = 3;
	public static int KEY_DOWN = 4;
	public static int KEY_CONTROL = 5;
	public static int KEY_DELETE = 8;
	public static int KEY_TAB = 9;
	public static int KEY_ENTER = 10; // \n
	public static int KEY_RETURN = 13; // \r
	public static int KEY_HOME = 1000;
	public static int KEY_END = 1001;

	protected HTMLCanvasElement canvas;
	protected CanvasRenderingContext2D context;
	protected ImageData imageData;

	@JSBody(script = "return (document.fullscreenElement || document.webkitFullscreenElement || document.mozFullScreenElement || document.msFullscreenElement) != null")
	public static native boolean isFullscreen();

	private static double mapCoord(double v, double n1, double n2, double m1, double m2) {
		return (v - n1) * (m2 - m1) / (n2 - n1) + m1;
	}

	private void setMousePosition(MouseEvent event) {
		int fixedWidth = 789;
		int fixedHeight = 532;

		if (isFullscreen()) {
			HTMLElement element = (HTMLElement) event.getTarget();
			TextRectangle br = element.getBoundingClientRect();
			double ratio = (double) Window.current().getInnerHeight() / (double) canvas.getHeight();
			double offset = ((double) Window.current().getInnerWidth() - ((double) canvas.getWidth() * ratio)) / 2.0;
			this.mouseX = (int) mapCoord(((double) event.getClientX()) - ((double) br.getLeft()) - offset, 0, ((double) canvas.getWidth()) * ratio, 0, fixedWidth);
			this.mouseY = (int) mapCoord(((double) event.getClientY()) - ((double) br.getTop()), 0, ((double) canvas.getHeight()) * ratio, 0, fixedHeight);
		} else {
			TextRectangle br = canvas.getBoundingClientRect();
			double scaleX = (double) canvas.getWidth() / br.getWidth();
			double scaleY = (double) canvas.getHeight() / br.getHeight();
			this.mouseX = (int) ((event.getClientX() - br.getLeft()) * scaleX);
			this.mouseY = (int) ((event.getClientY() - br.getTop()) * scaleY);
		}

		if (this.mouseX < 0) {
			this.mouseX = 0;
		}

		if (this.mouseY < 0) {
			this.mouseY = 0;
		}

		if (this.mouseX > fixedWidth) {
			this.mouseX = fixedWidth;
		}

		if (this.mouseY > fixedHeight) {
			this.mouseY = fixedHeight;
		}
	}

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

	@OriginalMember(owner = "client!a", name = "o", descriptor = "Lclient!qb;")
	protected DrawArea drawArea;

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

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(IZI)V")
	protected final void initApplet(@OriginalArg(0) int arg0, @OriginalArg(2) int arg2) {
		this.screenWidth = arg2;
		this.screenHeight = arg0;

		this.canvas = (HTMLCanvasElement) HTMLDocument.current().getElementById("game");
		this.canvas.setAttribute("tabindex", "-1");
		this.canvas.setWidth(this.screenWidth);
		this.canvas.setHeight(this.screenHeight);

		this.context = (CanvasRenderingContext2D) this.canvas.getContext("2d");
		imageData = context.createImageData(this.screenWidth, this.screenHeight);

		this.canvas.addEventListener("mousedown", new EventListener<MouseEvent>() {
			public void handleEvent(MouseEvent event) {
				setMousePosition(event);
				mousePressed(event.getButton() == 2 ? 2 : 1);
			}
		});

		this.canvas.addEventListener("mouseup", new EventListener<MouseEvent>() {
			public void handleEvent(MouseEvent event) {
				setMousePosition(event);
				mouseReleased(event.getButton() == 2 ? 2 : 1);
			}
		});

		this.canvas.addEventListener("mousemove", new EventListener<MouseEvent>() {
			public void handleEvent(MouseEvent event) {
				setMousePosition(event);
				mouseMoved();
			}
		});

		this.canvas.addEventListener("contextmenu", new EventListener<MouseEvent>() {
			public void handleEvent(MouseEvent event) {
				event.preventDefault();
			}
		});

		this.canvas.addEventListener("keydown", new EventListener<KeyboardEvent>() {
			public void handleEvent(KeyboardEvent event) {
				int code = event.getKeyCode();
				int charCode = event.getKey().length() == 1 ? event.getKey().charAt(0) : 65535;

				if (code == 13) {
					code = 10; // convert \r to \n (enter key)
				}

				if (code == 8 || code == 10 || code == 9) {
					charCode = code;
				}

				keyPressed(charCode, code);
			}
		});

		this.canvas.addEventListener("keyup", new EventListener<KeyboardEvent>() {
			public void handleEvent(KeyboardEvent event) {
				int code = event.getKeyCode();
				int charCode = event.getKey().length() == 1 ? event.getKey().charAt(0) : 65535;

				if (code == 13) {
					code = 10; // convert \r to \n (enter key)
				}

				if (code == 8 || code == 10 || code == 9) {
					charCode = code;
				}

				keyReleased(charCode, code);
			}
		});
		this.drawArea = new DrawArea(this.context, this.screenWidth, this.screenHeight);

		this.run();
		// this.startThread(this, 1);
	}

	@OriginalMember(owner = "client!a", name = "run", descriptor = "()V")
	@Override
	public void run() {
		this.drawProgress("Loading...", 0, true);
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
		}

		if (this.state == -1) {
			this.shutdown();
		}
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(I)V")
	private void shutdown() {
		this.state = -2;
		this.unload();
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(II)V")
	protected final void setFramerate(@OriginalArg(1) int arg1) {
		this.deltime = 1000 / arg1;
	}

	public final void mousePressed(int button) {
		this.idleCycles = 0;
		this.mouseClickX = this.mouseX;
		this.mouseClickY = this.mouseY;

		if (button != 1) {
			this.mouseClickButton = 2;
			this.mouseButton = 2;
		} else {
			this.mouseClickButton = 1;
			this.mouseButton = 1;
		}

		if (trackinput.enabled) {
			trackinput.mousePressed(this.mouseClickX, button, this.mouseClickY);
		}
	}

	public final void mouseReleased(int button) {
		this.idleCycles = 0;
		this.mouseButton = 0;

		if (trackinput.enabled) {
			trackinput.mouseReleased(button);
		}
	}

	public final void mouseMoved() {
		this.idleCycles = 0;

		if (trackinput.enabled) {
			trackinput.mouseMoved(this.mouseY, this.mouseX);
		}
	}

	public final void keyPressed(int ch, int code) {
		this.idleCycles = 0;

		if (ch < 30) {
			ch = 0;
		}

		if (code == 37) {
			ch = KEY_LEFT;
		} else if (code == 39) {
			ch = KEY_RIGHT;
		} else if (code == 38) {
			ch = KEY_UP;
		} else if (code == 40) {
			ch = KEY_DOWN;
		} else if (code == 17) {
			ch = KEY_CONTROL;
		} else if (code == 8) {
			ch = KEY_DELETE;
		} else if (code == 127) {
			ch = KEY_DELETE;
		} else if (code == 9) {
			ch = KEY_TAB;
		} else if (code == 10) {
			ch = KEY_ENTER;
		} else if (code == 36) {
			ch = KEY_HOME;
		} else if (code == 35) {
			ch = KEY_END;
		} else if (code == 33) {
			ch = 1002;
		} else if (code == 34) {
			ch = 1003;
		} else if (code >= 112 && code <= 123) {
			ch = (1008 + code) - 112;
		}

		if (ch > 0 && ch < 128) {
			this.actionKey[ch] = 1;
		}

		if (ch > 4) {
			this.keyQueue[this.keyQueueWritePos] = ch;
			this.keyQueueWritePos = this.keyQueueWritePos + 1 & 0x7F;
		}

		if (trackinput.enabled) {
			trackinput.keyPressed(ch);
		}
	}

	public final void keyReleased(int ch, int code) {
		this.idleCycles = 0;

		if (ch < 30) {
			ch = 0;
		}

		if (code == 37) {
			ch = KEY_LEFT;
		} else if (code == 39) {
			ch = KEY_RIGHT;
		} else if (code == 38) {
			ch = KEY_UP;
		} else if (code == 40) {
			ch = KEY_DOWN;
		} else if (code == 17) {
			ch = KEY_CONTROL;
		} else if (code == 8) {
			ch = KEY_DELETE;
		} else if (code == 127) {
			ch = KEY_DELETE;
		} else if (code == 9) {
			ch = KEY_TAB;
		} else if (code == 10) {
			ch = KEY_ENTER;
		} else if (code == 36) {
			ch = KEY_HOME;
		} else if (code == 35) {
			ch = KEY_END;
		} else if (code == 33) {
			ch = 1002;
		} else if (code == 34) {
			ch = 1003;
		} else if (code >= 112 && code <= 123) {
			ch = (1008 + code) - 112;
		}

		if (ch > 0 && ch < 128) {
			this.actionKey[ch] = 0;
		}

		if (trackinput.enabled) {
			trackinput.keyReleased(ch);
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

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(Ljava/lang/Runnable;I)V")
	public void startThread(@OriginalArg(0) Runnable arg0, @OriginalArg(1) int arg1) {
		@Pc(4) Thread local4 = new Thread(arg0);
		local4.start();
		local4.setPriority(arg1);
	}

	@OriginalMember(owner = "client!a", name = "a", descriptor = "(ZLjava/lang/String;I)V")
	protected void drawProgress(@OriginalArg(1) String arg1, @OriginalArg(2) int arg2, boolean printToConsole) {
	}

	protected void mouseWheelMoved(int rotation) {
	}

	protected void mouseWheelDragged(int x, int y) {
	}
}
