package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

public class ConnectionHandler {
	private ServerConnection connection;
	public ConnectionHandler(String ip){
		connection = new ServerConnection(ip);
	}
	public Optional<Object> requestData(String string) {
		return connection.rD(string);
	}
}
