package org.greatmancode.vanillaclassic.protocol.codec;

import org.greatmancode.vanillaclassic.protocol.msg.PingMessage;
import org.spout.api.protocol.MessageCodec;

public final class PingCodec extends MessageCodec<PingMessage> {

	public PingCodec() {
		super(PingMessage.class, 0x01);
	}

}
