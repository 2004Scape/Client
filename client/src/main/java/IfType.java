import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import sign.signlink;

@OriginalClass("client!hc")
public final class IfType {

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "I")
	public static int flowObfuscator1;

	@OriginalMember(owner = "client!hc", name = "b", descriptor = "Z")
	private static boolean flowObfuscator2;

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
	public static void unpack(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) PixFont[] arg1, @OriginalArg(2) int arg2, @OriginalArg(3) Jagfile arg3) {
		try {
			@Pc(5) int local5 = 17 / arg2;
			imageCache = new LruCache((byte) 0, 50000);
			modelCache = new LruCache((byte) 0, 50000);
			@Pc(27) Packet local27 = new Packet(363, arg3.read("data", null, (byte) 2));
			@Pc(29) int local29 = -1;
			@Pc(32) int local32 = local27.g2();
			instances = new IfType[local32];
			while (true) {
				@Pc(62) IfType local62;
				do {
					if (local27.pos >= local27.data.length) {
						imageCache = null;
						modelCache = null;
						return;
					}
					@Pc(45) int local45 = local27.g2();
					if (local45 == 65535) {
						local29 = local27.g2();
						local45 = local27.g2();
					}
					local62 = instances[local45] = new IfType();
					local62.id = local45;
					local62.parentId = local29;
					local62.type = local27.g1();
					local62.optionType = local27.g1();
					local62.contentType = local27.g2();
					local62.width = local27.g2();
					local62.height = local27.g2();
					local62.delegateHover = local27.g1();
					if (local62.delegateHover == 0) {
						local62.delegateHover = -1;
					} else {
						local62.delegateHover = (local62.delegateHover - 1 << 8) + local27.g1();
					}
					@Pc(114) int local114 = local27.g1();
					@Pc(126) int local126;
					if (local114 > 0) {
						local62.scriptComparator = new int[local114];
						local62.scriptOperand = new int[local114];
						for (local126 = 0; local126 < local114; local126++) {
							local62.scriptComparator[local126] = local27.g1();
							local62.scriptOperand[local126] = local27.g2();
						}
					}
					local126 = local27.g1();
					@Pc(155) int local155;
					@Pc(160) int local160;
					if (local126 > 0) {
						local62.scripts = new int[local126][];
						for (local155 = 0; local155 < local126; local155++) {
							local160 = local27.g2();
							local62.scripts[local155] = new int[local160];
							for (@Pc(168) int local168 = 0; local168 < local160; local168++) {
								local62.scripts[local155][local168] = local27.g2();
							}
						}
					}
					if (local62.type == 0) {
						local62.scrollableHeight = local27.g2();
						local62.hide = local27.g1() == 1;
						local155 = local27.g1();
						local62.childId = new int[local155];
						local62.childX = new int[local155];
						local62.childY = new int[local155];
						for (local160 = 0; local160 < local155; local160++) {
							local62.childId[local160] = local27.g2();
							local62.childX[local160] = local27.g2b();
							local62.childY[local160] = local27.g2b();
						}
					}
					if (local62.type == 1) {
						local62.unusedShort1 = local27.g2();
						local62.unusedBoolean1 = local27.g1() == 1;
					}
					if (local62.type == 2) {
						local62.inventorySlotObjId = new int[local62.width * local62.height];
						local62.inventorySlotObjCount = new int[local62.width * local62.height];
						local62.inventoryDraggable = local27.g1() == 1;
						local62.inventoryInteractable = local27.g1() == 1;
						local62.inventoryUsable = local27.g1() == 1;
						local62.inventoryMarginX = local27.g1();
						local62.inventoryMarginY = local27.g1();
						local62.inventorySlotOffsetX = new int[20];
						local62.inventorySlotOffsetY = new int[20];
						local62.inventorySlotImage = new Pix24[20];
						for (local155 = 0; local155 < 20; local155++) {
							local160 = local27.g1();
							if (local160 == 1) {
								local62.inventorySlotOffsetX[local155] = local27.g2b();
								local62.inventorySlotOffsetY[local155] = local27.g2b();
								@Pc(352) String local352 = local27.gstr();
								if (arg0 != null && local352.length() > 0) {
									@Pc(361) int local361 = local352.lastIndexOf(",");
									local62.inventorySlotImage[local155] = getImage(arg0, Integer.parseInt(local352.substring(local361 + 1)), local352.substring(0, local361), -36068);
								}
							}
						}
						local62.inventoryOptions = new String[5];
						for (local160 = 0; local160 < 5; local160++) {
							local62.inventoryOptions[local160] = local27.gstr();
							if (local62.inventoryOptions[local160].length() == 0) {
								local62.inventoryOptions[local160] = null;
							}
						}
					}
					if (local62.type == 3) {
						local62.fill = local27.g1() == 1;
					}
					if (local62.type == 4 || local62.type == 1) {
						local62.center = local27.g1() == 1;
						local155 = local27.g1();
						if (arg1 != null) {
							local62.font = arg1[local155];
						}
						local62.shadow = local27.g1() == 1;
					}
					if (local62.type == 4) {
						local62.text = local27.gstr();
						local62.activeText = local27.gstr();
					}
					if (local62.type == 1 || local62.type == 3 || local62.type == 4) {
						local62.color = local27.g4();
					}
					if (local62.type == 3 || local62.type == 4) {
						local62.activeColor = local27.g4();
						local62.hoverColor = local27.g4();
					}
					if (local62.type == 5) {
						@Pc(511) String local511 = local27.gstr();
						if (arg0 != null && local511.length() > 0) {
							local160 = local511.lastIndexOf(",");
							local62.image = getImage(arg0, Integer.parseInt(local511.substring(local160 + 1)), local511.substring(0, local160), -36068);
						}
						local511 = local27.gstr();
						if (arg0 != null && local511.length() > 0) {
							local160 = local511.lastIndexOf(",");
							local62.activeImage = getImage(arg0, Integer.parseInt(local511.substring(local160 + 1)), local511.substring(0, local160), -36068);
						}
					}
					if (local62.type == 6) {
						local45 = local27.g1();
						if (local45 != 0) {
							local62.model = getModel(4, (local45 - 1 << 8) + local27.g1());
						}
						local45 = local27.g1();
						if (local45 != 0) {
							local62.activeModel = getModel(4, (local45 - 1 << 8) + local27.g1());
						}
						local45 = local27.g1();
						if (local45 == 0) {
							local62.seqId = -1;
						} else {
							local62.seqId = (local45 - 1 << 8) + local27.g1();
						}
						local45 = local27.g1();
						if (local45 == 0) {
							local62.activeSeqId = -1;
						} else {
							local62.activeSeqId = (local45 - 1 << 8) + local27.g1();
						}
						local62.modelZoom = local27.g2();
						local62.modelPitch = local27.g2();
						local62.modelYaw = local27.g2();
					}
					if (local62.type == 7) {
						local62.inventorySlotObjId = new int[local62.width * local62.height];
						local62.inventorySlotObjCount = new int[local62.width * local62.height];
						local62.center = local27.g1() == 1;
						local155 = local27.g1();
						if (arg1 != null) {
							local62.font = arg1[local155];
						}
						local62.shadow = local27.g1() == 1;
						local62.color = local27.g4();
						local62.inventoryMarginX = local27.g2b();
						local62.inventoryMarginY = local27.g2b();
						local62.inventoryInteractable = local27.g1() == 1;
						local62.inventoryOptions = new String[5];
						for (local160 = 0; local160 < 5; local160++) {
							local62.inventoryOptions[local160] = local27.gstr();
							if (local62.inventoryOptions[local160].length() == 0) {
								local62.inventoryOptions[local160] = null;
							}
						}
					}
					if (local62.optionType == 2 || local62.type == 2) {
						local62.spellAction = local27.gstr();
						local62.spellName = local27.gstr();
						local62.spellFlags = local27.g2();
					}
				} while (local62.optionType != 1 && local62.optionType != 4 && local62.optionType != 5 && local62.optionType != 6);
				local62.option = local27.gstr();
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
		} catch (@Pc(834) RuntimeException local834) {
			signlink.reporterror("9595, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local834.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(Lclient!ub;ILjava/lang/String;I)Lclient!hb;")
	private static Pix24 getImage(@OriginalArg(0) Jagfile arg0, @OriginalArg(1) int arg1, @OriginalArg(2) String arg2, @OriginalArg(3) int arg3) {
		try {
			@Pc(8) long local8 = (JString.hashCode(0, arg2) << 8) + (long) arg1;
			@Pc(13) Pix24 local13 = (Pix24) imageCache.get(local8);
			if (arg3 != -36068) {
				throw new NullPointerException();
			} else if (local13 == null) {
				try {
					local13 = new Pix24(arg0, arg2, arg1);
					imageCache.put(6, local8, local13);
					return local13;
				} catch (@Pc(38) Exception local38) {
					return null;
				}
			} else {
				return local13;
			}
		} catch (@Pc(43) RuntimeException local43) {
			signlink.reporterror("51863, " + arg0 + ", " + arg1 + ", " + arg2 + ", " + arg3 + ", " + local43.toString());
			throw new RuntimeException();
		}
	}

	@OriginalMember(owner = "client!hc", name = "a", descriptor = "(II)Lclient!eb;")
	private static Model getModel(@OriginalArg(0) int arg0, @OriginalArg(1) int arg1) {
		try {
			@Pc(5) Model local5 = (Model) modelCache.get((long) arg1);
			if (arg0 != 4) {
				flowObfuscator2 = !flowObfuscator2;
			}
			if (local5 == null) {
				local5 = new Model(false, arg1);
				modelCache.put(6, (long) arg1, local5);
				return local5;
			} else {
				return local5;
			}
		} catch (@Pc(33) RuntimeException local33) {
			signlink.reporterror("7272, " + arg0 + ", " + arg1 + ", " + local33.toString());
			throw new RuntimeException();
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
			@Pc(31) Model local31 = new Model(local2, true, true, flowObfuscator1, false);
			if (arg0 != -1 || arg1 != -1) {
				local31.createLabelReferences(4);
			}
			if (arg0 != -1) {
				local31.applyTransform(-16599, arg0);
			}
			if (arg1 != -1) {
				local31.applyTransform(-16599, arg1);
			}
			local31.calculateNormals(64, 768, -50, -10, -50, true);
			return local31;
		}
	}
}
