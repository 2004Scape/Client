package jagex2.config;

import jagex2.datastruct.JString;
import jagex2.datastruct.LruCache;
import jagex2.graphics.Model;
import jagex2.graphics.Pix24;
import jagex2.graphics.PixFont;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// rs3 has this as config.iftype.Component
@OriginalClass("client!hc")
public class Component {

	public static final int TYPE_LAYER = 0;
	public static final int TYPE_UNUSED = 1; // TODO: decodes g2, gbool, center, font, shadowed, colour
	public static final int TYPE_INV = 2;
	public static final int TYPE_RECT = 3;
	public static final int TYPE_TEXT = 4;
	public static final int TYPE_GRAPHIC = 5;
	public static final int TYPE_MODEL = 6;
	public static final int TYPE_INV_TEXT = 7;

	public static final int BUTTON_OK = 1;
	public static final int BUTTON_TARGET = 2;
	public static final int BUTTON_CLOSE = 3;
	public static final int BUTTON_TOGGLE = 4;
	public static final int BUTTON_SELECT = 5;
	public static final int BUTTON_CONTINUE = 6;

	@OriginalMember(owner = "client!hc", name = "c", descriptor = "[Lclient!hc;")
	public static Component[] instances;

	@OriginalMember(owner = "client!hc", name = "d", descriptor = "[I")
	public int[] invSlotObjId;

	@OriginalMember(owner = "client!hc", name = "e", descriptor = "[I")
	public int[] invSlotObjCount;

	@OriginalMember(owner = "client!hc", name = "f", descriptor = "I")
	public int seqFrame;

	@OriginalMember(owner = "client!hc", name = "g", descriptor = "I")
	public int seqCycle;

	@OriginalMember(owner = "client!hc", name = "h", descriptor = "I")
	public int id;

	@OriginalMember(owner = "client!hc", name = "i", descriptor = "I")
	public int layer;

	@OriginalMember(owner = "client!hc", name = "j", descriptor = "I")
	public int type;

	@OriginalMember(owner = "client!hc", name = "k", descriptor = "I")
	public int buttonType;

	@OriginalMember(owner = "client!hc", name = "l", descriptor = "I")
	public int clientCode;

	/* Client codes:
	 * ---- friends
	 * 1-200: friends list
	 * 201: add friend
	 * 202: delete friend
	 * 203: friends list scrollbar size
	 * ---- logout
	 * 205: logout
	 * ---- player_design
	 * 300: change head (left)
	 * 301: change head (right)
	 * 302: change jaw (left)
	 * 303: change jaw (right)
	 * 304: change torso (left)
	 * 305: change torso (right)
	 * 306: change arms (left)
	 * 307: change arms (right)
	 * 308: change hands (left)
	 * 309: change hands (right)
	 * 310: change legs (left)
	 * 311: change legs (right)
	 * 312: change feet (left)
	 * 313: change feet (right)
	 * 314: recolour hair (left)
	 * 315: recolour hair (right)
	 * 316: recolour torso (left)
	 * 317: recolour torso (right)
	 * 318: recolour legs (left)
	 * 319: recolour legs (right)
	 * 320: recolour feet (left)
	 * 321: recolour feet (right)
	 * 322: recolour skin (left)
	 * 323: recolour skin (right)
	 * 324: switch to male
	 * 325: switch to female
	 * 326: accept design
	 * 327: design preview
	 * ---- ignore
	 * 401-500: ignore list
	 * 501: add ignore
	 * 502: delete ignore
	 * 503: ignore list scrollbar size
	 * ---- reportabuse
	 * 601: rule 1
	 * 602: rule 2
	 * 603: rule 3
	 * 604: rule 4
	 * 605: rule 5
	 * 606: rule 6
	 * 607: rule 7
	 * 608: rule 8
	 * 609: rule 9
	 * 610: rule 10
	 * 611: rule 11
	 * 612: rule 12
	 * 613: moderator mute
	 * ---- welcome_screen / welcome_screen2
	 * 650: last login info (has recovery questions set)
	 * 651: unread messages
	 * 655: last login info (no recovery questions set)
	 */

	@OriginalMember(owner = "client!hc", name = "m", descriptor = "I")
	public int width;

	@OriginalMember(owner = "client!hc", name = "n", descriptor = "I")
	public int height;

	@OriginalMember(owner = "client!hc", name = "o", descriptor = "I")
	public int x;

	@OriginalMember(owner = "client!hc", name = "p", descriptor = "I")
	public int y;

	@OriginalMember(owner = "client!hc", name = "q", descriptor = "[[I")
	public int[][] scripts;

	@OriginalMember(owner = "client!hc", name = "r", descriptor = "[I")
	public int[] scriptComparator;

	@OriginalMember(owner = "client!hc", name = "s", descriptor = "[I")
	public int[] scriptOperand;

	@OriginalMember(owner = "client!hc", name = "t", descriptor = "I")
	public int overLayer;

	@OriginalMember(owner = "client!hc", name = "u", descriptor = "I")
	public int scroll;

	@OriginalMember(owner = "client!hc", name = "v", descriptor = "I")
	public int scrollPosition;

	@OriginalMember(owner = "client!hc", name = "w", descriptor = "Z")
	public boolean hide;

	@OriginalMember(owner = "client!hc", name = "x", descriptor = "[I")
	public int[] childId;

	@OriginalMember(owner = "client!hc", name = "y", descriptor = "[I")
	public int[] childX;

	@OriginalMember(owner = "client!hc", name = "z", descriptor = "[I")
	public int[] childY;

	@OriginalMember(owner = "client!hc", name = "A", descriptor = "I")
	public int unusedShort1;

	@OriginalMember(owner = "client!hc", name = "B", descriptor = "Z")
	public boolean unusedBoolean1;

	@OriginalMember(owner = "client!hc", name = "C", descriptor = "Z")
	public boolean draggable;

	@OriginalMember(owner = "client!hc", name = "D", descriptor = "Z")
	public boolean interactable;

	@OriginalMember(owner = "client!hc", name = "E", descriptor = "Z")
	public boolean usable;

	@OriginalMember(owner = "client!hc", name = "F", descriptor = "I")
	public int marginX;

	@OriginalMember(owner = "client!hc", name = "G", descriptor = "I")
	public int marginY;

	@OriginalMember(owner = "client!hc", name = "H", descriptor = "[Lclient!hb;")
	public Pix24[] invSlotSprite;

	@OriginalMember(owner = "client!hc", name = "I", descriptor = "[I")
	public int[] invSlotOffsetX;

	@OriginalMember(owner = "client!hc", name = "J", descriptor = "[I")
	public int[] invSlotOffsetY;

	@OriginalMember(owner = "client!hc", name = "K", descriptor = "[Ljava/lang/String;")
	public String[] iops;

	@OriginalMember(owner = "client!hc", name = "L", descriptor = "Z")
	public boolean fill;

	@OriginalMember(owner = "client!hc", name = "M", descriptor = "Z")
	public boolean center;

	@OriginalMember(owner = "client!hc", name = "N", descriptor = "Z")
	public boolean shadowed;

	@OriginalMember(owner = "client!hc", name = "O", descriptor = "Lclient!jb;")
	public PixFont font;

	@OriginalMember(owner = "client!hc", name = "P", descriptor = "Ljava/lang/String;")
	public String text;

	@OriginalMember(owner = "client!hc", name = "Q", descriptor = "Ljava/lang/String;")
	public String activeText;

	@OriginalMember(owner = "client!hc", name = "R", descriptor = "I")
	public int colour;

	@OriginalMember(owner = "client!hc", name = "S", descriptor = "I")
	public int activeColour;

	@OriginalMember(owner = "client!hc", name = "T", descriptor = "I")
	public int overColour;

	@OriginalMember(owner = "client!hc", name = "U", descriptor = "Lclient!hb;")
	public Pix24 graphic;

	@OriginalMember(owner = "client!hc", name = "V", descriptor = "Lclient!hb;")
	public Pix24 activeGraphic;

	@OriginalMember(owner = "client!hc", name = "W", descriptor = "Lclient!eb;")
	public Model model;

	@OriginalMember(owner = "client!hc", name = "X", descriptor = "Lclient!eb;")
	public Model activeModel;

	@OriginalMember(owner = "client!hc", name = "Y", descriptor = "I")
	public int anim;

	@OriginalMember(owner = "client!hc", name = "Z", descriptor = "I")
	public int activeAnim;

	@OriginalMember(owner = "client!hc", name = "ab", descriptor = "I")
	public int zoom;

	@OriginalMember(owner = "client!hc", name = "bb", descriptor = "I")
	public int xan;

	@OriginalMember(owner = "client!hc", name = "cb", descriptor = "I")
	public int yan;

	@OriginalMember(owner = "client!hc", name = "db", descriptor = "Ljava/lang/String;")
	public String actionVerb;

	@OriginalMember(owner = "client!hc", name = "eb", descriptor = "Ljava/lang/String;")
	public String action;

	@OriginalMember(owner = "client!hc", name = "fb", descriptor = "I")
	public int actionTarget;

	@OriginalMember(owner = "client!hc", name = "gb", descriptor = "Ljava/lang/String;")
	public String option;

	@OriginalMember(owner = "client!hc", name = "hb", descriptor = "Lclient!s;")
	private static LruCache imageCache;

	@OriginalMember(owner = "client!hc", name = "ib", descriptor = "Lclient!s;")
	private static LruCache modelCache;

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;[Lclient!jb;ILclient!ub;)V")
	public static void unpack(@OriginalArg(3) Jagfile jag, @OriginalArg(0) Jagfile media, @OriginalArg(1) PixFont[] fonts) {
		imageCache = new LruCache(50000);
		modelCache = new LruCache(50000);

		@Pc(27) Packet dat = new Packet(jag.read("data", null));
		@Pc(29) int layer = -1;

		@Pc(32) int count = dat.g2();
		instances = new Component[count];

		while (dat.pos < dat.data.length) {
			@Pc(45) int id = dat.g2();
			if (id == 65535) {
				layer = dat.g2();
				id = dat.g2();
			}

			@Pc(62) Component com = instances[id] = new Component();
			com.id = id;
			com.layer = layer;
			com.type = dat.g1();
			com.buttonType = dat.g1();
			com.clientCode = dat.g2();
			com.width = dat.g2();
			com.height = dat.g2();
			com.overLayer = dat.g1();
			if (com.overLayer == 0) {
				com.overLayer = -1;
			} else {
				com.overLayer = (com.overLayer - 1 << 8) + dat.g1();
			}

			@Pc(114) int comparatorCount = dat.g1();
			if (comparatorCount > 0) {
				com.scriptComparator = new int[comparatorCount];
				com.scriptOperand = new int[comparatorCount];

				for (int i = 0; i < comparatorCount; i++) {
					com.scriptComparator[i] = dat.g1();
					com.scriptOperand[i] = dat.g2();
				}
			}

			int scriptCount = dat.g1();
			if (scriptCount > 0) {
				com.scripts = new int[scriptCount][];

				for (int i = 0; i < scriptCount; i++) {
					int opcodeCount = dat.g2();
					com.scripts[i] = new int[opcodeCount];

					for (@Pc(168) int j = 0; j < opcodeCount; j++) {
						com.scripts[i][j] = dat.g2();
					}
				}
			}

			if (com.type == TYPE_LAYER) {
				com.scroll = dat.g2();
				com.hide = dat.g1() == 1;

				int childCount = dat.g1();
				com.childId = new int[childCount];
				com.childX = new int[childCount];
				com.childY = new int[childCount];

				for (int i = 0; i < childCount; i++) {
					com.childId[i] = dat.g2();
					com.childX[i] = dat.g2b();
					com.childY[i] = dat.g2b();
				}
			}

			if (com.type == TYPE_UNUSED) {
				com.unusedShort1 = dat.g2();
				com.unusedBoolean1 = dat.g1() == 1;
			}

			if (com.type == TYPE_INV) {
				com.invSlotObjId = new int[com.width * com.height];
				com.invSlotObjCount = new int[com.width * com.height];

				com.draggable = dat.g1() == 1;
				com.interactable = dat.g1() == 1;
				com.usable = dat.g1() == 1;
				com.marginX = dat.g1();
				com.marginY = dat.g1();

				com.invSlotOffsetX = new int[20];
				com.invSlotOffsetY = new int[20];
				com.invSlotSprite = new Pix24[20];

				for (int i = 0; i < 20; i++) {
					if (dat.g1() == 1) {
						com.invSlotOffsetX[i] = dat.g2b();
						com.invSlotOffsetY[i] = dat.g2b();

						@Pc(352) String sprite = dat.gjstr();
						if (media != null && sprite.length() > 0) {
							@Pc(361) int spriteIndex = sprite.lastIndexOf(",");
							com.invSlotSprite[i] = getImage(media, sprite.substring(0, spriteIndex), Integer.parseInt(sprite.substring(spriteIndex + 1)));
						}
					}
				}

				com.iops = new String[5];
				for (int i = 0; i < 5; i++) {
					com.iops[i] = dat.gjstr();

					if (com.iops[i].length() == 0) {
						com.iops[i] = null;
					}
				}
			}

			if (com.type == TYPE_RECT) {
				com.fill = dat.g1() == 1;
			}

			if (com.type == TYPE_TEXT || com.type == TYPE_UNUSED) {
				com.center = dat.g1() == 1;
				int fontId = dat.g1();
				if (fonts != null) {
					com.font = fonts[fontId];
				}
				com.shadowed = dat.g1() == 1;
			}

			if (com.type == TYPE_TEXT) {
				com.text = dat.gjstr();
				com.activeText = dat.gjstr();
			}

			if (com.type == TYPE_UNUSED || com.type == TYPE_RECT || com.type == TYPE_TEXT) {
				com.colour = dat.g4();
			}

			if (com.type == TYPE_RECT || com.type == TYPE_TEXT) {
				com.activeColour = dat.g4();
				com.overColour = dat.g4();
			}

			if (com.type == TYPE_GRAPHIC) {
				@Pc(511) String sprite = dat.gjstr();
				if (media != null && sprite.length() > 0) {
					int spriteIndex = sprite.lastIndexOf(",");
					com.graphic = getImage(media, sprite.substring(0, spriteIndex), Integer.parseInt(sprite.substring(spriteIndex + 1)));
				}

				sprite = dat.gjstr();
				if (media != null && sprite.length() > 0) {
					int spriteIndex = sprite.lastIndexOf(",");
					com.activeGraphic = getImage(media, sprite.substring(0, spriteIndex), Integer.parseInt(sprite.substring(spriteIndex + 1)));
				}
			}

			if (com.type == TYPE_MODEL) {
				int tmp = dat.g1();
				if (tmp != 0) {
					com.model = getModel((tmp - 1 << 8) + dat.g1());
				}

				tmp = dat.g1();
				if (tmp != 0) {
					com.activeModel = getModel((tmp - 1 << 8) + dat.g1());
				}

				tmp = dat.g1();
				if (tmp == 0) {
					com.anim = -1;
				} else {
					com.anim = (tmp - 1 << 8) + dat.g1();
				}

				tmp = dat.g1();
				if (tmp == 0) {
					com.activeAnim = -1;
				} else {
					com.activeAnim = (tmp - 1 << 8) + dat.g1();
				}

				com.zoom = dat.g2();
				com.xan = dat.g2();
				com.yan = dat.g2();
			}

			if (com.type == TYPE_INV_TEXT) {
				com.invSlotObjId = new int[com.width * com.height];
				com.invSlotObjCount = new int[com.width * com.height];

				com.center = dat.g1() == 1;
				int fontId = dat.g1();
				if (fonts != null) {
					com.font = fonts[fontId];
				}
				com.shadowed = dat.g1() == 1;
				com.colour = dat.g4();
				com.marginX = dat.g2b();
				com.marginY = dat.g2b();
				com.interactable = dat.g1() == 1;

				com.iops = new String[5];
				for (int i = 0; i < 5; i++) {
					com.iops[i] = dat.gjstr();

					if (com.iops[i].length() == 0) {
						com.iops[i] = null;
					}
				}
			}

			if (com.buttonType == BUTTON_TARGET || com.type == TYPE_INV) {
				com.actionVerb = dat.gjstr();
				com.action = dat.gjstr();
				com.actionTarget = dat.g2();
			}

			if (com.buttonType == BUTTON_OK || com.buttonType == BUTTON_TOGGLE || com.buttonType == BUTTON_SELECT || com.buttonType == BUTTON_CONTINUE) {
				com.option = dat.gjstr();

				if (com.option.length() == 0) {
					if (com.buttonType == BUTTON_OK) {
						com.option = "Ok";
					} else if (com.buttonType == BUTTON_TOGGLE) {
						com.option = "Select";
					} else if (com.buttonType == BUTTON_SELECT) {
						com.option = "Select";
					} else if (com.buttonType == BUTTON_CONTINUE) {
						com.option = "Continue";
					}
				}
			}
		}

		imageCache = null;
		modelCache = null;
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;ILjava/lang/String;I)Lclient!hb;")
	private static Pix24 getImage(@OriginalArg(0) Jagfile media, @OriginalArg(2) String sprite, @OriginalArg(1) int spriteId) {
		@Pc(8) long uid = (JString.hashCode(sprite) << 8) + (long) spriteId;
		@Pc(13) Pix24 image = (Pix24) imageCache.get(uid);

		if (image != null) {
			return image;
		}

		try {
			image = new Pix24(media, sprite, spriteId);
			imageCache.put(uid, image);
		} catch (@Pc(38) Exception ignored) {
			return null;
		}

		return image;
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(II)Lclient!eb;")
	private static Model getModel(@OriginalArg(1) int id) {
		@Pc(5) Model m = (Model) modelCache.get(id);
		if (m != null) {
			return m;
		}

		m = new Model(id);
		modelCache.put(id, m);
		return m;
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(IIZ)Lclient!eb;")
	public Model getModel(@OriginalArg(0) int primaryFrame, @OriginalArg(1) int secondaryFrame, @OriginalArg(2) boolean active) {
		@Pc(2) Model m = this.model;
		if (active) {
			m = this.activeModel;
		}

		if (m == null) {
			return null;
		}

		if (primaryFrame == -1 && secondaryFrame == -1 && m.faceColor == null) {
			return m;
		}

		@Pc(31) Model tmp = new Model(m, true, true, false);
		if (primaryFrame != -1 || secondaryFrame != -1) {
			tmp.createLabelReferences();
		}

		if (primaryFrame != -1) {
			tmp.applyTransform(primaryFrame);
		}

		if (secondaryFrame != -1) {
			tmp.applyTransform(secondaryFrame);
		}

		tmp.calculateNormals(64, 768, -50, -10, -50, true);
		return tmp;
	}
}
