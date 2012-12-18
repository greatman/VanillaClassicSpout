package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.ChannelBufferUtils;
import org.greatmancode.vanillaclassic.protocol.msg.IdentificationMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class IdentificationCodec extends MessageCodec<IdentificationMessage> {
	public IdentificationCodec() {
		super(IdentificationMessage.class, 0x00);
	}

	@Override
	public IdentificationMessage decode(ChannelBuffer buffer) throws IOException {
		short protocolVersion = buffer.readUnsignedByte();
		String username = ChannelBufferUtils.readString(buffer);
		String verificationKey = ChannelBufferUtils.readString(buffer);
		buffer.readUnsignedByte();
		return new IdentificationMessage(protocolVersion, username, verificationKey, (byte) 0);
	}

	@Override
	public ChannelBuffer encode(IdentificationMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(130);
		buffer.writeByte(message.getProtocolVersion());
		ChannelBufferUtils.writeString(buffer, message.getUsernameOrServerName());
		ChannelBufferUtils.writeString(buffer, message.getVerificationKeyOrServerMOTD());
		buffer.writeByte(message.getUserType());
		return buffer;
	}
}
