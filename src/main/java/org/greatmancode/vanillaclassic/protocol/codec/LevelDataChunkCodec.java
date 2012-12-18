package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.LevelDataChunkMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class LevelDataChunkCodec extends MessageCodec<LevelDataChunkMessage> {
	public LevelDataChunkCodec() {
		super(LevelDataChunkMessage.class, 0x03);
	}

	@Override
	public ChannelBuffer encode(LevelDataChunkMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(1028);
		buffer.writeShort(message.getChunkLength());
		buffer.writeBytes(message.getChunkData());
		buffer.writeByte(message.getPercentComplete());
		return buffer;
	}
}
