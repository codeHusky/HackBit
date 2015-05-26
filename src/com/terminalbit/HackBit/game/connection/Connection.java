package com.terminalbit.HackBit.game.connection;

import java.util.Optional;


public class Connection {
	private ConnectionHandler ch;
	public boolean connected = false;
	@SuppressWarnings("unused")
	private int connectionAttempt = 1;
	public Connection(String serverIP) {
		ch = new ConnectionHandler(serverIP);
		while(!ch.connected){
			ch.connect();
			connectionAttempt++;
		}
		connected = true;
	}

	public Optional<Object> send(String dT, String dC) {
		return ch.send(dT, dC);
	}

}
