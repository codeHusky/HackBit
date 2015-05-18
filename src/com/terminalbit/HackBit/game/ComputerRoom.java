package com.terminalbit.HackBit.game;

import java.util.List;

import com.terminalbit.HackBit.game.components.Device;
import com.terminalbit.HackBit.game.components.Network;
import com.terminalbit.HackBit.game.components.Terminal;

public class ComputerRoom {
	public Terminal terminal;
	public List<Device> devices;
	public Network network;
	public ComputerRoom(Terminal mainTerminal, Network network){
		this.terminal = mainTerminal;
		this.network = network;
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
