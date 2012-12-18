package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.ChannelBufferUtils;
import org.greatmancode.vanillaclassic.protocol.msg.MessageMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class PlayerMessageCodec extends MessageCodec<MessageMessage> {
	public PlayerMessageCodec() {
		super(MessageMessage.class, 0x0d);
	}

	@Override
	public MessageMessage decode(ChannelBuffer buffer) throws IOException {
		buffer.readByte(); //Unused
		String message = ChannelBufferUtils.readString(buffer);
		return new MessageMessage((short) 0, message);
	}

	@Override
	public ChannelBuffer encode(MessageMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(65);
		buffer.writeByte(message.getPlayerID());
		ChannelBufferUtils.writeString(buffer, message.getMessage());
		return buffer;
	}
}
