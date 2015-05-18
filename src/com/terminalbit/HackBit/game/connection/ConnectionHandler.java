package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

import com.terminalbit.HackBit.HackBit;

public class ConnectionHandler {
	public Boolean connected = false;
	private String connectionIP;
	public ConnectionHandler(String ip){
		connectionIP = ip;
	}
	public void connect() {
		HackBit.fakeserver.connect(connectionIP);
		System.out.println("Connected.");
		connected = true;
	}
	public Optional<Object> requestData(String string) {
		return HackBit.fakeserver.requestData(string);
	}
}
