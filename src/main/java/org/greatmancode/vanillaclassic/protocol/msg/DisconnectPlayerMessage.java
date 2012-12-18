package org.greatmancode.vanillaclassic.protocol.msg;

public class DisconnectPlayerMessage extends VanillaClassicMessage {

	private final String reason;

	public DisconnectPlayerMessage(String reason) {
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}
}
