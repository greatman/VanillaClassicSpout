package org.greatmancode.vanillaclassic.protocol.msg;

public class SetBlockMessage extends VanillaClassicMessage {

	private final short x, y, z;
	private final byte blockType;

	public SetBlockMessage(short x, short y, short z, byte blockType) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.blockType = blockType;
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

	public byte getBlockType() {
		return blockType;
	}
}
