package com.terminalbit.HackBit.game.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.terminalbit.HackBit.game.components.Device;
import com.terminalbit.HackBit.game.components.Network;

public class FakeServer {
	private String serverIP;
	private List<Network> networks;
	private int deviceCounter = 0;
	public FakeServer(String ip){
		serverIP = ip;
	}
	public void setupNetwork(String name){
		Network newNetwork = new Network(name,deviceCounter,new ArrayList<Device>());
	}
	public Optional<String> getIP(int ipID){
		return Optional.of("FakeIP");
	}
	public String getServerIP(){
		return serverIP;
	}
}
