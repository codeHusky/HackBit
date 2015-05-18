package com.terminalbit.HackBit.game.connection;

import java.util.Optional;


public class Connection {
	private ConnectionHandler ch;
	public boolean connected = false;
	private int connectionAttempt = 1;
	public Connection(String serverIP) {
		ch = new ConnectionHandler(serverIP);
		while(!ch.connected){
			ch.connect();
			connectionAttempt++;
		}
		connected = true;
	}

	public Optional<Object> getData(String data) {
		return ch.requestData(data);
	}

}
