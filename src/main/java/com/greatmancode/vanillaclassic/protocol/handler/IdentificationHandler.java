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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		if (message.getVerificationKeyOrServerMOTD().equals(md5(VanillaClassicPlugin.salt + message.getUsernameOrServerName()))) {
			//User is valid. Let's send our response
			if (PlayerConnectEvent.getHandlerList().getRegisteredListeners().length > 0) {
				Spout.getEventManager().callEvent(new PlayerConnectEvent(session, (String) session.getDataMap().get("username")));
				session.send(false, new IdentificationMessage((byte)0x07, VanillaClassicConfiguration.SERVER_NAME.getString(), VanillaClassicConfiguration.SERVER_NAME.getString(), (byte) 0x00)); //TODO: Get the real OP status
			}
		}
	}
	
	public static String md5(String input){
        String res = "";
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(input.getBytes());
            byte[] md5 = algorithm.digest();
            String tmp = "";
            for (int i = 0; i < md5.length; i++) {
                tmp = (Integer.toHexString(0xFF & md5[i]));
                if (tmp.length() == 1) {
                    res += "0" + tmp;
                } else {
                    res += tmp;
                }
            }
        } catch (NoSuchAlgorithmException ex) {}
        return res;
    }
}
