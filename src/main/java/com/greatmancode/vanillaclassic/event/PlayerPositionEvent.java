package com.greatmancode.vanillaclassic.event;

import org.spout.api.entity.Player;
import org.spout.api.geo.discrete.Point;
import org.spout.api.protocol.event.ProtocolEvent;

public class PlayerPositionEvent implements ProtocolEvent {

	private Player pl;
	private Point position;
	
	public PlayerPositionEvent(Player pl, Point position) {
		this.pl = pl;
		this.position = position;
	}
	
	public Player getPlayer() {
		return pl;
	}

	public void setPlayer(Player pl) {
		this.pl = pl;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	

	
}
