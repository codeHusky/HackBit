package com.terminalbit.HackBit.game.connection;

import java.util.Optional;

public class FakeServer {
	private String serverIP;
	public FakeServer(String ip){
		serverIP = ip;
	}
	public Optional<String> getIP(int ipID){
		return Optional.of("FakeIP");
	}
	public String getServerIP(){
		return serverIP;
	}
}
