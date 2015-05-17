package com.terminalbit.HackBit.game.connection;

public class ServerConnection {
	//will use sockets once server exists.
	private FakeServer server;
	public ServerConnection(String ipaddress) {
		server = new FakeServer(ipaddress);
	}
	public String getIP(int ipID) {
		return "testip";
	}
}
