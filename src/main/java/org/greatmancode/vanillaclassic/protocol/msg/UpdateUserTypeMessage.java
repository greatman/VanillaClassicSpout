package org.greatmancode.vanillaclassic.protocol.msg;

public class UpdateUserTypeMessage extends VanillaClassicMessage {

	private final byte userType;

	public UpdateUserTypeMessage(byte userType) {
		this.userType = userType;
	}

	public byte getUserType() {
		return userType;
	}
}
