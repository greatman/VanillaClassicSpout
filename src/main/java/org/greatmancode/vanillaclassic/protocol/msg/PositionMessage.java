package org.greatmancode.vanillaclassic.protocol.msg;

public class PositionMessage extends VanillaClassicMessage {

	private final byte playerID, yaw, pitch;
	private final short x, y, z;

	public PositionMessage(byte playerID, short x, short y, short z, byte yaw, byte pitch) {
		this.playerID = playerID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}

	public byte getPlayerID() {
		return playerID;
	}

	public byte getYaw() {
		return yaw;
	}

	public byte getPitch() {
		return pitch;
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
