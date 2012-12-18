package org.greatmancode.vanillaclassic.protocol.codec;

import org.greatmancode.vanillaclassic.protocol.msg.LevelInitializeMessage;
import org.spout.api.protocol.MessageCodec;

public final class LevelInitializeCodec extends MessageCodec<LevelInitializeMessage> {
	public LevelInitializeCodec() {
		super(LevelInitializeMessage.class, 0x02);
	}
}
