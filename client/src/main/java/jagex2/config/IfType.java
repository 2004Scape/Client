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

@OriginalClass("client!hc")
public class IfType {

	@OriginalMember(owner = "client!hc", name = "c", descriptor = "[Lclient!hc;")
	public static IfType[] instances;

	@OriginalMember(owner = "client!hc", name = "d", descriptor = "[I")
	public int[] inventorySlotObjId;

	@OriginalMember(owner = "client!hc", name = "e", descriptor = "[I")
	public int[] inventorySlotObjCount;

	@OriginalMember(owner = "client!hc", name = "f", descriptor = "I")
	public int seqFrame;

	@OriginalMember(owner = "client!hc", name = "g", descriptor = "I")
	public int seqCycle;

	@OriginalMember(owner = "client!hc", name = "h", descriptor = "I")
	public int id;

	@OriginalMember(owner = "client!hc", name = "i", descriptor = "I")
	public int parentId;

	@OriginalMember(owner = "client!hc", name = "j", descriptor = "I")
	public int type;

	@OriginalMember(owner = "client!hc", name = "k", descriptor = "I")
	public int optionType;

	@OriginalMember(owner = "client!hc", name = "l", descriptor = "I")
	public int contentType;

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
	public int delegateHover;

	@OriginalMember(owner = "client!hc", name = "u", descriptor = "I")
	public int scrollableHeight;

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
	public boolean inventoryDraggable;

	@OriginalMember(owner = "client!hc", name = "D", descriptor = "Z")
	public boolean inventoryInteractable;

	@OriginalMember(owner = "client!hc", name = "E", descriptor = "Z")
	public boolean inventoryUsable;

	@OriginalMember(owner = "client!hc", name = "F", descriptor = "I")
	public int inventoryMarginX;

	@OriginalMember(owner = "client!hc", name = "G", descriptor = "I")
	public int inventoryMarginY;

	@OriginalMember(owner = "client!hc", name = "H", descriptor = "[Lclient!hb;")
	public Pix24[] inventorySlotImage;

	@OriginalMember(owner = "client!hc", name = "I", descriptor = "[I")
	public int[] inventorySlotOffsetX;

	@OriginalMember(owner = "client!hc", name = "J", descriptor = "[I")
	public int[] inventorySlotOffsetY;

	@OriginalMember(owner = "client!hc", name = "K", descriptor = "[Ljava/lang/String;")
	public String[] inventoryOptions;

	@OriginalMember(owner = "client!hc", name = "L", descriptor = "Z")
	public boolean fill;

	@OriginalMember(owner = "client!hc", name = "M", descriptor = "Z")
	public boolean center;

	@OriginalMember(owner = "client!hc", name = "N", descriptor = "Z")
	public boolean shadow;

	@OriginalMember(owner = "client!hc", name = "O", descriptor = "Lclient!jb;")
	public PixFont font;

	@OriginalMember(owner = "client!hc", name = "P", descriptor = "Ljava/lang/String;")
	public String text;

	@OriginalMember(owner = "client!hc", name = "Q", descriptor = "Ljava/lang/String;")
	public String activeText;

	@OriginalMember(owner = "client!hc", name = "R", descriptor = "I")
	public int color;

	@OriginalMember(owner = "client!hc", name = "S", descriptor = "I")
	public int activeColor;

	@OriginalMember(owner = "client!hc", name = "T", descriptor = "I")
	public int hoverColor;

	@OriginalMember(owner = "client!hc", name = "U", descriptor = "Lclient!hb;")
	public Pix24 image;

	@OriginalMember(owner = "client!hc", name = "V", descriptor = "Lclient!hb;")
	public Pix24 activeImage;

	@OriginalMember(owner = "client!hc", name = "W", descriptor = "Lclient!eb;")
	public Model model;

	@OriginalMember(owner = "client!hc", name = "X", descriptor = "Lclient!eb;")
	public Model activeModel;

	@OriginalMember(owner = "client!hc", name = "Y", descriptor = "I")
	public int seqId;

	@OriginalMember(owner = "client!hc", name = "Z", descriptor = "I")
	public int activeSeqId;

	@OriginalMember(owner = "client!hc", name = "ab", descriptor = "I")
	public int modelZoom;

	@OriginalMember(owner = "client!hc", name = "bb", descriptor = "I")
	public int modelPitch;

	@OriginalMember(owner = "client!hc", name = "cb", descriptor = "I")
	public int modelYaw;

	@OriginalMember(owner = "client!hc", name = "db", descriptor = "Ljava/lang/String;")
	public String spellAction;

	@OriginalMember(owner = "client!hc", name = "eb", descriptor = "Ljava/lang/String;")
	public String spellName;

	@OriginalMember(owner = "client!hc", name = "fb", descriptor = "I")
	public int spellFlags;

	@OriginalMember(owner = "client!hc", name = "gb", descriptor = "Ljava/lang/String;")
	public String option;

	@OriginalMember(owner = "client!hc", name = "hb", descriptor = "Lclient!s;")
	private static LruCache imageCache;

	@OriginalMember(owner = "client!hc", name = "ib", descriptor = "Lclient!s;")
	private static LruCache modelCache;

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;[Lclient!jb;ILclient!ub;)V")
	public static void unpack(@OriginalArg(0) Jagfile media, @OriginalArg(1) PixFont[] fonts, @OriginalArg(3) Jagfile jag) {
		imageCache = new LruCache(50000);
		modelCache = new LruCache(50000);

		@Pc(27) Packet dat = new Packet(jag.read("data", null));
		@Pc(29) int parentId = -1;

		@Pc(32) int count = dat.g2();
		instances = new IfType[count];

		while (dat.pos < dat.data.length) {
			@Pc(45) int id = dat.g2();
			if (id == 65535) {
				parentId = dat.g2();
				id = dat.g2();
			}

			@Pc(62) IfType com = instances[id] = new IfType();
			com.id = id;
			com.parentId = parentId;
			com.type = dat.g1();
			com.optionType = dat.g1();
			com.contentType = dat.g2();
			com.width = dat.g2();
			com.height = dat.g2();
			com.delegateHover = dat.g1();
			if (com.delegateHover == 0) {
				com.delegateHover = -1;
			} else {
				com.delegateHover = (com.delegateHover - 1 << 8) + dat.g1();
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

			if (com.type == 0) {
				com.scrollableHeight = dat.g2();
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

			if (com.type == 1) {
				com.unusedShort1 = dat.g2();
				com.unusedBoolean1 = dat.g1() == 1;
			}

			if (com.type == 2) {
				com.inventorySlotObjId = new int[com.width * com.height];
				com.inventorySlotObjCount = new int[com.width * com.height];

				com.inventoryDraggable = dat.g1() == 1;
				com.inventoryInteractable = dat.g1() == 1;
				com.inventoryUsable = dat.g1() == 1;
				com.inventoryMarginX = dat.g1();
				com.inventoryMarginY = dat.g1();

				com.inventorySlotOffsetX = new int[20];
				com.inventorySlotOffsetY = new int[20];
				com.inventorySlotImage = new Pix24[20];

				for (int i = 0; i < 20; i++) {
					if (dat.g1() == 1) {
						com.inventorySlotOffsetX[i] = dat.g2b();
						com.inventorySlotOffsetY[i] = dat.g2b();

						@Pc(352) String sprite = dat.gjstr();
						if (media != null && sprite.length() > 0) {
							@Pc(361) int spriteIndex = sprite.lastIndexOf(",");
							com.inventorySlotImage[i] = getImage(media, Integer.parseInt(sprite.substring(spriteIndex + 1)), sprite.substring(0, spriteIndex));
						}
					}
				}

				com.inventoryOptions = new String[5];
				for (int i = 0; i < 5; i++) {
					com.inventoryOptions[i] = dat.gjstr();

					if (com.inventoryOptions[i].length() == 0) {
						com.inventoryOptions[i] = null;
					}
				}
			}

			if (com.type == 3) {
				com.fill = dat.g1() == 1;
			}

			if (com.type == 4 || com.type == 1) {
				com.center = dat.g1() == 1;
				int fontId = dat.g1();
				if (fonts != null) {
					com.font = fonts[fontId];
				}
				com.shadow = dat.g1() == 1;
			}

			if (com.type == 4) {
				com.text = dat.gjstr();
				com.activeText = dat.gjstr();
			}

			if (com.type == 1 || com.type == 3 || com.type == 4) {
				com.color = dat.g4();
			}

			if (com.type == 3 || com.type == 4) {
				com.activeColor = dat.g4();
				com.hoverColor = dat.g4();
			}

			if (com.type == 5) {
				@Pc(511) String sprite = dat.gjstr();
				if (media != null && sprite.length() > 0) {
					int spriteIndex = sprite.lastIndexOf(",");
					com.image = getImage(media, Integer.parseInt(sprite.substring(spriteIndex + 1)), sprite.substring(0, spriteIndex));
				}

				sprite = dat.gjstr();
				if (media != null && sprite.length() > 0) {
					int spriteIndex = sprite.lastIndexOf(",");
					com.activeImage = getImage(media, Integer.parseInt(sprite.substring(spriteIndex + 1)), sprite.substring(0, spriteIndex));
				}
			}

			if (com.type == 6) {
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
					com.seqId = -1;
				} else {
					com.seqId = (tmp - 1 << 8) + dat.g1();
				}

				tmp = dat.g1();
				if (tmp == 0) {
					com.activeSeqId = -1;
				} else {
					com.activeSeqId = (tmp - 1 << 8) + dat.g1();
				}

				com.modelZoom = dat.g2();
				com.modelPitch = dat.g2();
				com.modelYaw = dat.g2();
			}

			if (com.type == 7) {
				com.inventorySlotObjId = new int[com.width * com.height];
				com.inventorySlotObjCount = new int[com.width * com.height];
				com.center = dat.g1() == 1;
				int fontId = dat.g1();
				if (fonts != null) {
					com.font = fonts[fontId];
				}
				com.shadow = dat.g1() == 1;
				com.color = dat.g4();
				com.inventoryMarginX = dat.g2b();
				com.inventoryMarginY = dat.g2b();
				com.inventoryInteractable = dat.g1() == 1;

				com.inventoryOptions = new String[5];
				for (int i = 0; i < 5; i++) {
					com.inventoryOptions[i] = dat.gjstr();
					if (com.inventoryOptions[i].length() == 0) {
						com.inventoryOptions[i] = null;
					}
				}
			}

			if (com.optionType == 2 || com.type == 2) {
				com.spellAction = dat.gjstr();
				com.spellName = dat.gjstr();
				com.spellFlags = dat.g2();
			}

			if (com.optionType == 1 || com.optionType == 4 || com.optionType == 5 || com.optionType == 6) {
				com.option = dat.gjstr();

				if (com.option.length() == 0) {
					if (com.optionType == 1) {
						com.option = "Ok";
					} else if (com.optionType == 4) {
						com.option = "Select";
					} else if (com.optionType == 5) {
						com.option = "Select";
					} else if (com.optionType == 6) {
						com.option = "Continue";
					}
				}
			}
		}

		imageCache = null;
		modelCache = null;
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;ILjava/lang/String;I)Lclient!hb;")
	private static Pix24 getImage(@OriginalArg(0) Jagfile media, @OriginalArg(1) int spriteId, @OriginalArg(2) String sprite) {
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
