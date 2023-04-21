package jagex2.config;

import jagex2.datastruct.JString;
import jagex2.datastruct.LruCache;
import jagex2.graphics.BitmapFont;
import jagex2.graphics.Model;
import jagex2.graphics.Pix24;
import jagex2.io.Jagfile;
import jagex2.io.Packet;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;

// IfType: Component definitions that build interfaces for modals, chatboxes, etc.
@OriginalClass("client!hc")
public final class IfType {

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
	public BitmapFont font;

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
	public static void unpack(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) BitmapFont[] arg1, @OriginalArg(3) Jagfile arg3) {
		imageCache = new LruCache(50000);
		modelCache = new LruCache(50000);
		@Pc(27) Packet buf = new Packet(arg3.read("data", null));
		@Pc(29) int local29 = -1;
		@Pc(32) int local32 = buf.g2();
		instances = new IfType[local32];
		while (true) {
			@Pc(62) IfType local62;
			do {
				if (buf.pos >= buf.data.length) {
					imageCache = null;
					modelCache = null;
					return;
				}
				@Pc(45) int local45 = buf.g2();
				if (local45 == 65535) {
					local29 = buf.g2();
					local45 = buf.g2();
				}
				local62 = instances[local45] = new IfType();
				local62.id = local45;
				local62.parentId = local29;
				local62.type = buf.g1();
				local62.optionType = buf.g1();
				local62.contentType = buf.g2();
				local62.width = buf.g2();
				local62.height = buf.g2();
				local62.delegateHover = buf.g1();
				if (local62.delegateHover == 0) {
					local62.delegateHover = -1;
				} else {
					local62.delegateHover = (local62.delegateHover - 1 << 8) + buf.g1();
				}
				@Pc(114) int local114 = buf.g1();
				@Pc(126) int local126;
				if (local114 > 0) {
					local62.scriptComparator = new int[local114];
					local62.scriptOperand = new int[local114];
					for (local126 = 0; local126 < local114; local126++) {
						local62.scriptComparator[local126] = buf.g1();
						local62.scriptOperand[local126] = buf.g2();
					}
				}
				local126 = buf.g1();
				@Pc(155) int local155;
				@Pc(160) int local160;
				if (local126 > 0) {
					local62.scripts = new int[local126][];
					for (local155 = 0; local155 < local126; local155++) {
						local160 = buf.g2();
						local62.scripts[local155] = new int[local160];
						for (@Pc(168) int local168 = 0; local168 < local160; local168++) {
							local62.scripts[local155][local168] = buf.g2();
						}
					}
				}
				if (local62.type == 0) {
					local62.scrollableHeight = buf.g2();
					local62.hide = buf.g1() == 1;
					local155 = buf.g1();
					local62.childId = new int[local155];
					local62.childX = new int[local155];
					local62.childY = new int[local155];
					for (local160 = 0; local160 < local155; local160++) {
						local62.childId[local160] = buf.g2();
						local62.childX[local160] = buf.g2b();
						local62.childY[local160] = buf.g2b();
					}
				}
				if (local62.type == 1) {
					local62.unusedShort1 = buf.g2();
					local62.unusedBoolean1 = buf.g1() == 1;
				}
				if (local62.type == 2) {
					local62.inventorySlotObjId = new int[local62.width * local62.height];
					local62.inventorySlotObjCount = new int[local62.width * local62.height];
					local62.inventoryDraggable = buf.g1() == 1;
					local62.inventoryInteractable = buf.g1() == 1;
					local62.inventoryUsable = buf.g1() == 1;
					local62.inventoryMarginX = buf.g1();
					local62.inventoryMarginY = buf.g1();
					local62.inventorySlotOffsetX = new int[20];
					local62.inventorySlotOffsetY = new int[20];
					local62.inventorySlotImage = new Pix24[20];
					for (local155 = 0; local155 < 20; local155++) {
						local160 = buf.g1();
						if (local160 == 1) {
							local62.inventorySlotOffsetX[local155] = buf.g2b();
							local62.inventorySlotOffsetY[local155] = buf.g2b();
							@Pc(352) String local352 = buf.gstr();
							if (arg0 != null && local352.length() > 0) {
								@Pc(361) int local361 = local352.lastIndexOf(",");
								local62.inventorySlotImage[local155] = getImage(arg0, Integer.parseInt(local352.substring(local361 + 1)), local352.substring(0, local361));
							}
						}
					}
					local62.inventoryOptions = new String[5];
					for (local160 = 0; local160 < 5; local160++) {
						local62.inventoryOptions[local160] = buf.gstr();
						if (local62.inventoryOptions[local160].length() == 0) {
							local62.inventoryOptions[local160] = null;
						}
					}
				}
				if (local62.type == 3) {
					local62.fill = buf.g1() == 1;
				}
				if (local62.type == 4 || local62.type == 1) {
					local62.center = buf.g1() == 1;
					local155 = buf.g1();
					if (arg1 != null) {
						local62.font = arg1[local155];
					}
					local62.shadow = buf.g1() == 1;
				}
				if (local62.type == 4) {
					local62.text = buf.gstr();
					local62.activeText = buf.gstr();
				}
				if (local62.type == 1 || local62.type == 3 || local62.type == 4) {
					local62.color = buf.g4();
				}
				if (local62.type == 3 || local62.type == 4) {
					local62.activeColor = buf.g4();
					local62.hoverColor = buf.g4();
				}
				if (local62.type == 5) {
					@Pc(511) String local511 = buf.gstr();
					if (arg0 != null && local511.length() > 0) {
						local160 = local511.lastIndexOf(",");
						local62.image = getImage(arg0, Integer.parseInt(local511.substring(local160 + 1)), local511.substring(0, local160));
					}
					local511 = buf.gstr();
					if (arg0 != null && local511.length() > 0) {
						local160 = local511.lastIndexOf(",");
						local62.activeImage = getImage(arg0, Integer.parseInt(local511.substring(local160 + 1)), local511.substring(0, local160));
					}
				}
				if (local62.type == 6) {
					local45 = buf.g1();
					if (local45 != 0) {
						local62.model = getModel((local45 - 1 << 8) + buf.g1());
					}
					local45 = buf.g1();
					if (local45 != 0) {
						local62.activeModel = getModel((local45 - 1 << 8) + buf.g1());
					}
					local45 = buf.g1();
					if (local45 == 0) {
						local62.seqId = -1;
					} else {
						local62.seqId = (local45 - 1 << 8) + buf.g1();
					}
					local45 = buf.g1();
					if (local45 == 0) {
						local62.activeSeqId = -1;
					} else {
						local62.activeSeqId = (local45 - 1 << 8) + buf.g1();
					}
					local62.modelZoom = buf.g2();
					local62.modelPitch = buf.g2();
					local62.modelYaw = buf.g2();
				}
				if (local62.type == 7) {
					local62.inventorySlotObjId = new int[local62.width * local62.height];
					local62.inventorySlotObjCount = new int[local62.width * local62.height];
					local62.center = buf.g1() == 1;
					local155 = buf.g1();
					if (arg1 != null) {
						local62.font = arg1[local155];
					}
					local62.shadow = buf.g1() == 1;
					local62.color = buf.g4();
					local62.inventoryMarginX = buf.g2b();
					local62.inventoryMarginY = buf.g2b();
					local62.inventoryInteractable = buf.g1() == 1;
					local62.inventoryOptions = new String[5];
					for (local160 = 0; local160 < 5; local160++) {
						local62.inventoryOptions[local160] = buf.gstr();
						if (local62.inventoryOptions[local160].length() == 0) {
							local62.inventoryOptions[local160] = null;
						}
					}
				}
				if (local62.optionType == 2 || local62.type == 2) {
					local62.spellAction = buf.gstr();
					local62.spellName = buf.gstr();
					local62.spellFlags = buf.g2();
				}
			} while (local62.optionType != 1 && local62.optionType != 4 && local62.optionType != 5 && local62.optionType != 6);
			local62.option = buf.gstr();
			if (local62.option.length() == 0) {
				if (local62.optionType == 1) {
					local62.option = "Ok";
				}
				if (local62.optionType == 4) {
					local62.option = "Select";
				}
				if (local62.optionType == 5) {
					local62.option = "Select";
				}
				if (local62.optionType == 6) {
					local62.option = "Continue";
				}
			}
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;ILjava/lang/String;I)Lclient!hb;")
	private static Pix24 getImage(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2) {
		@Pc(8) long local8 = (JString.hashCode(arg2) << 8) + (long) arg1;
		@Pc(13) Pix24 local13 = (Pix24) imageCache.get(local8);
		if (local13 == null) {
			try {
				local13 = new Pix24(arg0, arg2, arg1);
				imageCache.put(local8, local13);
				return local13;
			} catch (@Pc(38) Exception local38) {
				return null;
			}
		} else {
			return local13;
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(II)Lclient!eb;")
	private static Model getModel(@OriginalArg(1) int arg1) {
		@Pc(5) Model local5 = (Model) modelCache.get((long) arg1);
		if (local5 == null) {
			local5 = new Model(arg1);
			modelCache.put((long) arg1, local5);
			return local5;
		} else {
			return local5;
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(IIZ)Lclient!eb;")
	public Model getModel(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1, @OriginalArg(2) boolean arg2) {
		@Pc(2) Model local2 = this.model;
		if (arg2) {
			local2 = this.activeModel;
		}
		if (local2 == null) {
			return null;
		} else if (arg0 == -1 && arg1 == -1 && local2.faceColor == null) {
			return local2;
		} else {
			@Pc(31) Model local31 = new Model(local2, true, true, false);
			if (arg0 != -1 || arg1 != -1) {
				local31.createLabelReferences();
			}
			if (arg0 != -1) {
				local31.applyTransform(arg0);
			}
			if (arg1 != -1) {
				local31.applyTransform(arg1);
			}
			local31.calculateNormals(64, 768, -50, -10, -50, true);
			return local31;
		}
	}
}
