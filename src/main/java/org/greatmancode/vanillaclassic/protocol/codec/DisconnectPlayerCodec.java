package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.ChannelBufferUtils;
import org.greatmancode.vanillaclassic.protocol.msg.DisconnectPlayerMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class DisconnectPlayerCodec extends MessageCodec<DisconnectPlayerMessage> {
	public DisconnectPlayerCodec() {
		super(DisconnectPlayerMessage.class, 0x0e);
	}

	@Override
	public ChannelBuffer encode(DisconnectPlayerMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(64);
		ChannelBufferUtils.writeString(buffer, message.getReason());
		return buffer;
	}
}
