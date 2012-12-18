package org.greatmancode.vanillaclassic.protocol.msg;

public class DespawnPlayerMessage extends VanillaClassicMessage {

	private final byte playerID;
	
	public DespawnPlayerMessage(byte playerID) {
		this.playerID = playerID;
	}

	public byte getPlayerID() {
		return playerID;
	}
	
}
