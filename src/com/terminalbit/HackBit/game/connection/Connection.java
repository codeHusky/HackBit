package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

public class Connection {
	private ConnectionHandler ch;
	private String connectionIP;
	public Connection(String serverIP) {
		ch = new ConnectionHandler(serverIP);
		connectionIP = serverIP;
	}
	
	public Optional<String> getIP(int ipID) {
		return ch.getIP(ipID);
	}
	
	public String getServerIP(){
		return connectionIP;
	}

}
