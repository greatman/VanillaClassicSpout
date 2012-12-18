package org.greatmancode.vanillaclassic.protocol.msg;

public class SetBlockClientMessage extends VanillaClassicMessage {

	private final short x, y, z;
	private final byte blockType, mode;

	public SetBlockClientMessage(short x, short y, short z, byte mode, byte blockType) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.mode = mode;
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

	public byte getMode() {
		return mode;
	}
}
