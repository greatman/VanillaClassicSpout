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
package com.greatmancode.vanillaclassic.protocol;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import org.spout.api.chat.ChatArguments;
import org.spout.api.command.Command;
import org.spout.api.exception.UnknownPacketException;
import org.spout.api.protocol.Message;
import org.spout.api.protocol.MessageCodec;
import org.spout.api.protocol.Protocol;
import org.spout.api.protocol.Session;

import com.greatmancode.vanillaclassic.protocol.msg.DisconnectPlayerMessage;
import com.greatmancode.vanillaclassic.protocol.msg.MessageMessage;

public class VanillaClassicProtocol extends Protocol {
	public static final int DEFAULT_PORT = 25565;

	public VanillaClassicProtocol() {
		super("VanillaClassic", 25565, new VanillaClassicCodecLookupService(), new VanillaClassicHandlerLookupService());
	}

	@Override
	public MessageCodec<?> readHeader(ChannelBuffer buf) throws UnknownPacketException {
		int opcode = buf.readUnsignedByte();
		MessageCodec<?> codec = getCodecLookupService().find(opcode);
		if (codec == null) {
			throw new UnknownPacketException(opcode);
		}
		System.out.println("CODEC: " + codec.getOpcode());
		return codec;
	}

	@Override
	public ChannelBuffer writeHeader(MessageCodec<?> codec, ChannelBuffer data) {
		ChannelBuffer buffer = ChannelBuffers.buffer(1);
		buffer.writeByte(codec.getOpcode());
		return buffer;
	}

	@Override
	public Message getKickMessage(ChatArguments message) {
		return new DisconnectPlayerMessage(message.toString());
	}

	@Override
	public Message getCommandMessage(Command command, ChatArguments args) {
		if (command.getPreferredName().equals("kick")) {
			return getKickMessage(args);
		} else if (command.getPreferredName().equals("say")) {
			return new MessageMessage((short) 0, args.asString() + "\u00a7r"); // The reset text is a workaround for a change in 1.3 -- Remove if fixed
		} else {
			return new MessageMessage((short) 0, '/' + command.getPreferredName() + ' ' + args.asString());
		}
	}

	@Override
	public Message getIntroductionMessage(String playerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initializeSession(Session session) {
		session.setNetworkSynchronizer(new VanillaClassicSynchronizer(session));
	}
}
