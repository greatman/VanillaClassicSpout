package org.greatmancode.vanillaclassic.protocol.msg;

public class IdentificationMessage extends VanillaClassicMessage {

	private final byte userType;
	private final short protocolVersion;
	private final String verificationKeyOrServerMOTD, usernameOrServerName;
	
	public IdentificationMessage(short protocolVersion, String usernameOrServerName, String verificationKeyOrServerMOTD, byte userType) {
		this.protocolVersion = protocolVersion;
		this.usernameOrServerName = usernameOrServerName;
		this.verificationKeyOrServerMOTD = verificationKeyOrServerMOTD;
		this.userType = userType;
	}
	
	public short getProtocolVersion() {
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
