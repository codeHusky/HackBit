package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

import com.terminalbit.HackBit.game.components.Network;

public class ServerConnection {
	//will use sockets once server exists.
	private FakeServer server;
	private int clientID;
	public ServerConnection(String ipaddress) {
		server = new FakeServer(ipaddress);
		try{
			clientID = (int) rD("ClientID").get();
		}catch(NullPointerException e){
			System.out.println("Failed to fetch ClientID");
		}
	}
	public Optional<Object> rD(String string) {
		return server.requestData(string);
	}
}
