package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.DespawnPlayerMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class DespawnPlayerCodec extends MessageCodec<DespawnPlayerMessage> {

	public DespawnPlayerCodec() {
		super(DespawnPlayerMessage.class, 0x0c);
	}

	@Override
	public ChannelBuffer encode(DespawnPlayerMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(1);
		buffer.writeByte(message.getPlayerID());
		return buffer;
	}
}
