package com.jagex.game.runetek3.scenegraph.entity;

import com.jagex.core.util.Node;
import com.jagex.game.runetek3.graphics.Model;
import org.openrs2.deob.annotation.OriginalArg;
import org.openrs2.deob.annotation.OriginalClass;
import org.openrs2.deob.annotation.OriginalMember;
import org.openrs2.deob.annotation.Pc;
import rs2.Signlink;

@OriginalClass("client!w")
public class Entity extends Node {

	@OriginalMember(owner = "client!w", name = "a", descriptor = "(Z)Lclient!eb;")
	public Model draw(@OriginalArg(0) boolean arg0, int loopCycle) {
		try {
			if (!arg0) {
				throw new NullPointerException();
			}
			return null;
		} catch (@Pc(8) RuntimeException local8) {
			Signlink.reporterror("84732, " + arg0 + ", " + local8.toString());
			throw new RuntimeException();
		}
	}
}
