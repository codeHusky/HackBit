package com.terminalbit.HackBit.fakeserver.datatypes;

import java.util.List;

public class ComputerRoom {
	public Terminal terminal;
	public List<Device> devices;
	public Network network;
	public ComputerRoom(Terminal mainTerminal, Network newNetwork){
		this.terminal = mainTerminal;
		this.network = newNetwork;
		this.devices = this.network.getDevices();
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
