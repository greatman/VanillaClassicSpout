package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.ChannelBufferUtils;
import org.greatmancode.vanillaclassic.protocol.msg.PlayerMessageMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class PlayerMessageCodec extends MessageCodec<PlayerMessageMessage> {
	public PlayerMessageCodec() {
		super(PlayerMessageMessage.class, 0x0d);
	}

	@Override
	public PlayerMessageMessage decode(ChannelBuffer buffer) throws IOException {
		buffer.readByte(); //Unused
		String message = ChannelBufferUtils.readString(buffer);
		return new PlayerMessageMessage((short) 0, message);
	}

	@Override
	public ChannelBuffer encode(PlayerMessageMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(65);
		buffer.writeByte(message.getPlayerID());
		ChannelBufferUtils.writeString(buffer, message.getMessage());
		return buffer;
	}
}
