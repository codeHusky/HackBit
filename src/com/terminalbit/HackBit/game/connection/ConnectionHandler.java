package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

public class ConnectionHandler {
	private ServerConnection connection;
	public ConnectionHandler(String ip){
		connection = new ServerConnection(ip);
	}
	public Optional<String> getIP(int ipID){
		return connection.getIP(ipID);
	}
}
