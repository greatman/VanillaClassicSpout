/*
 * This file is part of VanillaClassic.
 *
 * Copyright (c) 2011-2012, Greatman <http://github.com/greatman/>
 * VanillaClassic is licensed under the SpoutDev License Version 1.
 *
 * VanillaClassic is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * In addition, 180 days after any changes are published, you can use the
 * software, incorporating those changes, under the terms of the MIT license,
 * as described in the SpoutDev License Version 1.
 *
 * VanillaClassic is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License,
 * the MIT license and the SpoutDev License Version 1 along with this program.
 * If not, see <http://www.gnu.org/licenses/> for the GNU Lesser General Public
 * License and see <http://www.spout.org/SpoutDevLicenseV1.txt> for the full license,
 * including the MIT license.
 */
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
