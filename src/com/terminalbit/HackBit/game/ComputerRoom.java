package com.terminalbit.HackBit.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.terminalbit.HackBit.game.components.Device;
import com.terminalbit.HackBit.game.components.Network;
import com.terminalbit.HackBit.game.components.Terminal;

public class ComputerRoom {
	public static Terminal terminal;
	public static List<Device> devices;
	public static Network network;
	public ComputerRoom(Terminal mainTerminal, Network network, Optional<List<Device>> devices){
		this.terminal = mainTerminal;
		if(devices.isPresent()){
			this.devices = devices.get();
		}else{
			this.devices = new ArrayList<Device>();
		}
		this.network = network;
	}
	public Terminal getTerminal() {
		return terminal;
	}
	public Network getNetwork() {
		return network;
	}
	public List<Device> getDevices() {
		return devices;
	}
	public void update() {
		
	}
}
