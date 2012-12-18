package org.greatmancode.vanillaclassic.protocol.msg;

public class SpawnPlayerMessage extends VanillaClassicMessage {

	private final byte playerID, yaw, pitch;
	private final String playerName;
	private final short x, y, z;

	public SpawnPlayerMessage(byte playerID, String playerName, short x, short y, short z, byte yaw, byte pitch) {
		this.playerID = playerID;
		this.playerName = playerName;
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

	public String getPlayerName() {
		return playerName;
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
