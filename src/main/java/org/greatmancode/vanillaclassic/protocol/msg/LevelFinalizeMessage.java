package org.greatmancode.vanillaclassic.protocol.msg;

public class LevelFinalizeMessage extends VanillaClassicMessage {

	private final short x, y, z;

	public LevelFinalizeMessage(short x, short y, short z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public short getX() {
		return x;
	}

	public short getY() {
		return y;
	}

	public short getZ() {
		return z;
	}
}
