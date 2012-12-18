/*
 * This file is part of VanillaClassic.
 *
 * Copyright (c) 2012, Greatman <http://www.github.com/greatman/>
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

import org.greatmancode.vanillaclassic.protocol.ChannelBufferUtils;
import org.greatmancode.vanillaclassic.protocol.msg.IdentificationMessage;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import org.spout.api.protocol.MessageCodec;

public final class IdentificationCodec extends MessageCodec<IdentificationMessage> {
	public IdentificationCodec() {
		super(IdentificationMessage.class, 0x00);
	}

	@Override
	public IdentificationMessage decode(ChannelBuffer buffer) throws IOException {
		short protocolVersion = buffer.readUnsignedByte();
		String username = ChannelBufferUtils.readString(buffer);
		String verificationKey = ChannelBufferUtils.readString(buffer);
		buffer.readUnsignedByte();
		return new IdentificationMessage(protocolVersion, username, verificationKey, (byte) 0);
	}

	@Override
	public ChannelBuffer encode(IdentificationMessage message) throws IOException {
		ChannelBuffer buffer = ChannelBuffers.buffer(130);
		buffer.writeByte(message.getProtocolVersion());
		ChannelBufferUtils.writeString(buffer, message.getUsernameOrServerName());
		ChannelBufferUtils.writeString(buffer, message.getVerificationKeyOrServerMOTD());
		buffer.writeByte(message.getUserType());
		return buffer;
	}
}
