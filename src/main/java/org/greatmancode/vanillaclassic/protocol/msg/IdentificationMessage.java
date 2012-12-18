package org.greatmancode.vanillaclassic.protocol.msg;

public class IdentificationMessage extends VanillaClassicMessage {

	private final byte protocolVersion, userType;
	private final String verificationKeyOrServerMOTD, usernameOrServerName;
	
	public IdentificationMessage(byte protocolVersion, String usernameOrServerName, String verificationKeyOrServerMOTD, byte userType) {
		this.protocolVersion = protocolVersion;
		this.usernameOrServerName = usernameOrServerName;
		this.verificationKeyOrServerMOTD = verificationKeyOrServerMOTD;
		this.userType = userType;
	}
	
	public byte getProtocolVersion() {
		return protocolVersion;
	}
	public byte getUserType() {
		return userType;
	}
	
	public String getVerificationKeyOrServerMOTD() {
		return verificationKeyOrServerMOTD;
	}
	
	public String getUsernameOrServerName() {
		return usernameOrServerName;
	}
}
