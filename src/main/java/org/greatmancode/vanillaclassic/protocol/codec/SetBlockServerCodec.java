package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.SetBlockServerMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class SetBlockServerCodec extends MessageCodec<SetBlockServerMessage> {
	
	public SetBlockServerCodec() {
		super(SetBlockServerMessage.class, 0x06);
	}

	@Override
	public ChannelBuffer encode(SetBlockServerMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(7);
		buffer.writeShort(message.getX());
		buffer.writeShort(message.getY());
		buffer.writeShort(message.getZ());
		buffer.writeByte(message.getBlockType());
		return buffer;
	}
}
