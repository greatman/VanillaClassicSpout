package com.greatmancode.vanillaclassic.protocol.handler;

import org.spout.api.chat.ChatArguments;
import org.spout.api.entity.Player;
import org.spout.api.protocol.MessageHandler;
import org.spout.api.protocol.Session;

import com.greatmancode.vanillaclassic.protocol.msg.MessageMessage;

public final class PlayerMessageHandler extends MessageHandler<MessageMessage> {

	@Override
	public void handleServer(Session session, MessageMessage message)  {
		if (!session.hasPlayer()) {
			return;
		}

		Player player = session.getPlayer();
		String text = message.getMessage();
		text = text.trim();

		if (text.length() > 100) {
			//session.disconnect("Chat message is too long."); TODO Don't disconnect people...
			text = text.substring(0, 99);
		}
		String command;
		ChatArguments args;
		if (text.startsWith("/")) {
			int spaceIndex = text.indexOf(" ");
			if (spaceIndex != -1) {
				command = text.substring(1, spaceIndex);
				text = text.substring(spaceIndex + 1);
			} else {
				command = text.substring(1);
				text = "";
			}
		} else {
			command = "say";
		}

		args = ChatArguments.fromString(text);
		player.processCommand(command, args);
	}
}
