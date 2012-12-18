package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.LevelFinalizeMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class LevelFinalizeCodec extends MessageCodec<LevelFinalizeMessage> {
	public LevelFinalizeCodec() {
		super(LevelFinalizeMessage.class, 0x04);
	}

	@Override
	public ChannelBuffer encode(LevelFinalizeMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(6);
		buffer.writeShort(message.getX());
		buffer.writeShort(message.getY());
		buffer.writeShort(message.getZ());
		return buffer;
	}
}
