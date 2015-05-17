package com.terminalbit.HackBit.game.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.terminalbit.HackBit.game.components.Device;
import com.terminalbit.HackBit.game.components.Network;

public class FakeServer {
	private String serverIP;
	private List<Network> networks;
 	private int networkCount = 0;
	public FakeServer(String ip){
		serverIP = ip;
	}
	public void setupNetwork(String name){
		Network newNetwork = new Network(name,networkCount,new ArrayList<Device>());
		networks.add(newNetwork);
		networkCount++;
	}
	public Optional<Object> sendOff(Object anything){
		return Optional.of((Object) anything);
	}
	public Optional<Object> requestData(String string) {
		if(string.equals("ServerIP")){
			return sendOff(serverIP);
		}
		if(string.equals("ClientID")){
			return sendOff(0);
		}
		return null;
	}
}
