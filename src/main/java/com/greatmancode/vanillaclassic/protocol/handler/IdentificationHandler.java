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
package com.greatmancode.vanillaclassic.protocol.handler;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;

import org.spout.api.Spout;
import org.spout.api.event.player.PlayerConnectEvent;
import org.spout.api.protocol.MessageHandler;
import org.spout.api.protocol.Session;

import com.greatmancode.vanillaclassic.VanillaClassicPlugin;
import com.greatmancode.vanillaclassic.configuration.VanillaClassicConfiguration;
import com.greatmancode.vanillaclassic.protocol.msg.IdentificationMessage;

public final class IdentificationHandler extends MessageHandler<IdentificationMessage> {
	@Override
	public void handleServer(Session session, IdentificationMessage message) {
		System.out.println("We received a player!");
		System.out.println(md5(VanillaClassicPlugin.SALT + message.getUsernameOrServerName()));
		
		if (message.getProtocolVersion() != VanillaClassicPlugin.PROTOCOL_VERSION) {
			session.disconnect("Invalid protocol ID! Are you updated?");
			return;
		}
		if (message.getVerificationKeyOrServerMOTD().equals(md5(VanillaClassicPlugin.SALT + message.getUsernameOrServerName()))) {
			// User is valid. Let's send our response
			System.out.println("User is valid. Let's roll!");
			if (PlayerConnectEvent.getHandlerList().getRegisteredListeners().length > 0) {
				Spout.getEventManager().callEvent(new PlayerConnectEvent(session, message.getUsernameOrServerName()));
				System.out.println("Sending auth notice.");
				session.send(false, new IdentificationMessage((byte) 0x07, VanillaClassicConfiguration.SERVER_NAME.getString(), VanillaClassicConfiguration.SERVER_NAME.getString(), (byte) 0x00)); // TODO: Get the real OP status
				System.out.println("Sent!");
			}
		}
	}

	public static String md5(String text) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(text.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1, digest);
			String hashtext = bigInt.toString(16);
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			VanillaClassicPlugin.getInstance().getLogger().log(Level.SEVERE, "Unable to find the MD5 algorithm!", e);
		}
		return null;
	}
}
