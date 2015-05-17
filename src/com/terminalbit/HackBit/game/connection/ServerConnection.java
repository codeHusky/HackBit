package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

public class ServerConnection {
	//will use sockets once server exists.
	private FakeServer server;
	public ServerConnection(String ipaddress) {
		server = new FakeServer(ipaddress);
	}
	public Optional<String> getIP(int ipID) {
		return server.getIP(ipID);
	}
}
