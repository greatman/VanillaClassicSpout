package org.greatmancode.vanillaclassic.protocol.msg;

import org.spout.api.protocol.Message;

public class VanillaClassicMessage implements Message {
	
	@Override
	public int getChannelId() {
		return DEFAULT_CHANNEL;
	}

}
