package jagex2.config;

import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;

@OriginalClass("client!ic")
public final class DeadType {

	@OriginalMember(owner = "client!ic", name = "a", descriptor = "I")
	private static final int flowObfuscator1 = 473;

	@OriginalMember(owner = "client!ic", name = "b", descriptor = "[Lclient!ic;")
	public static DeadType[] instances;

	@OriginalMember(owner = "client!ic", name = "c", descriptor = "Z")
	private final boolean aBoolean118 = true;

	@OriginalMember(owner = "client!ic", name = "d", descriptor = "Z")
	private final boolean aBoolean119 = false;

	@OriginalMember(owner = "client!ic", name = "e", descriptor = "Z")
	private final boolean aBoolean120 = true;

	@OriginalMember(owner = "client!ic", name = "f", descriptor = "Z")
	private final boolean aBoolean121 = true;

	@OriginalMember(owner = "client!ic", name = "g", descriptor = "Z")
	private final boolean aBoolean122 = false;

	@OriginalMember(owner = "client!ic", name = "<init>", descriptor = "()V")
	private DeadType() {
	}
}
