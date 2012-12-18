package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.SetBlockClientMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class SetBlockClientCodec extends MessageCodec<SetBlockClientMessage> {
	public SetBlockClientCodec() {
		super(SetBlockClientMessage.class, 0x05);
	}

	@Override
	public SetBlockClientMessage decode(ChannelBuffer buffer) throws IOException {
		short x = buffer.readShort();
		short y = buffer.readShort();
		short z = buffer.readShort();
		byte mode = buffer.readByte();
		byte blockType = buffer.readByte();
		return new SetBlockClientMessage(x, y, z, mode, blockType);
	}

	@Override
	public ChannelBuffer encode(SetBlockClientMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(7);
		buffer.writeShort(message.getX());
		buffer.writeShort(message.getY());
		buffer.writeShort(message.getZ());
		buffer.writeByte(message.getBlockType());
		return buffer;
	}
}
