package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.ChannelBufferUtils;
import org.greatmancode.vanillaclassic.protocol.msg.SpawnPlayerMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class SpawnPlayerCodec extends MessageCodec<SpawnPlayerMessage> {

	public SpawnPlayerCodec() {
		super(SpawnPlayerMessage.class, 0x07);
	}

	@Override
	public ChannelBuffer encode(SpawnPlayerMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(73);
		buffer.writeByte(message.getPlayerID());
		ChannelBufferUtils.writeString(buffer, message.getPlayerName());
		buffer.writeShort(message.getX());
		buffer.writeShort(message.getY());
		buffer.writeShort(message.getZ());
		buffer.writeByte(message.getYaw());
		buffer.writeByte(message.getPitch());
		return buffer;
	}
}
