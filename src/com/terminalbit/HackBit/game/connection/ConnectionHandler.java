package com.terminalbit.HackBit.game.connection;

public class ConnectionHandler {
	private ServerConnection connection;
	public static ServerConnection Connection(String ip) {
		connection = new ServerConnection(ip);
	}
}
