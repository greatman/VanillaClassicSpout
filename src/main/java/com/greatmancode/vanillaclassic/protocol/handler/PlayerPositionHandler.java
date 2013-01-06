package com.greatmancode.vanillaclassic.protocol.handler;

import org.spout.api.entity.Player;
import org.spout.api.geo.discrete.Point;
import org.spout.api.protocol.MessageHandler;
import org.spout.api.protocol.Session;

import com.greatmancode.vanillaclassic.event.PlayerPositionEvent;
import com.greatmancode.vanillaclassic.protocol.msg.PositionMessage;

public final class PlayerPositionHandler extends MessageHandler<PositionMessage> {

	@Override
	public void handleServer(Session session, PositionMessage message)  {
		Player pl = session.getPlayer();
		
		pl.getTransform().setPosition(new Point(pl.getWorld(), message.getX(), message.getY(), message.getZ()));
		pl.getNetwork().callProtocolEvent(new PlayerPositionEvent(pl, pl.getTransform().getPosition()));
	}
}
