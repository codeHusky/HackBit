package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

public class Connection {
	private ConnectionHandler ch;
	public Connection(String serverIP) {
		ch = new ConnectionHandler(serverIP);
	}
	
	public Optional<String> getIP(int ipID) {
		return ch.getIP(ipID);
	}

}
