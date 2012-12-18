package org.greatmancode.vanillaclassic.protocol.msg;

public class MessageMessage extends VanillaClassicMessage {

	private final byte playerID;
	private final String message;

	public MessageMessage(byte playerID, String message) {
		this.playerID = playerID;
		this.message = message;
	}

	public byte getPlayerID() {
		return playerID;
	}

	public String getMessage() {
		return message;
	}

}
