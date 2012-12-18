package org.greatmancode.vanillaclassic.protocol.codec;

import java.io.IOException;

import org.greatmancode.vanillaclassic.protocol.msg.PlayerPositionMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.spout.api.protocol.MessageCodec;

public final class PlayerPositionCodec extends MessageCodec<PlayerPositionMessage> {
	public PlayerPositionCodec() {
		super(PlayerPositionMessage.class, 0x09);
	}

	@Override
	public PlayerPositionMessage decode(ChannelBuffer buffer) throws IOException {
		short playerID = buffer.readUnsignedByte();
		short x = buffer.readShort();
		short y = buffer.readShort();
		short z = buffer.readShort();
		byte yaw = buffer.readByte();
		byte pitch = buffer.readByte();
		
		return new PlayerPositionMessage(playerID, x, y, z, yaw, pitch);
	}

	@Override
	public ChannelBuffer encode(PlayerPositionMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(9);
		buffer.writeByte(message.getPlayerID());
		buffer.writeShort(message.getX());
		buffer.writeShort(message.getY());
		buffer.writeShort(message.getZ());
		buffer.writeByte(message.getYaw());
		buffer.writeByte(message.getPitch());
		return buffer;
	}
}
