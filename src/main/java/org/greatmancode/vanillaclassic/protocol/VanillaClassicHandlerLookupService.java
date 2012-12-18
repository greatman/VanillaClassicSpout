package org.greatmancode.vanillaclassic.protocol;

import org.spout.api.protocol.HandlerLookupService;
import org.spout.vanilla.protocol.handler.player.conn.PlayerHandshakeHandler;
import org.spout.vanilla.protocol.msg.player.conn.PlayerHandshakeMessage;

public class VanillaClassicHandlerLookupService extends HandlerLookupService {

	public VanillaClassicHandlerLookupService() {
		bind(null, null);
	}
}
