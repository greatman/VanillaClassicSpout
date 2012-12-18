package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.UpdateUserTypeMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class UpdateUserTypeCodec extends MessageCodec<UpdateUserTypeMessage> {
	public UpdateUserTypeCodec() {
		super(UpdateUserTypeMessage.class, 0x03);
	}

	@Override
	public ChannelBuffer encode(UpdateUserTypeMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(1);
		buffer.writeByte(message.getUserType());
		return buffer;
	}
}
