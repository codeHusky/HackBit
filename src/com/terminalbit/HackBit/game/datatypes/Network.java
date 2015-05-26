package com.terminalbit.HackBit.game.datatypes;

import java.util.List;

import com.terminalbit.HackBit.fakeserver.datatypes.Terminal;

public class Network {
	public List<Device> devices;
	public Network(List<Device> devices2) {
		devices = devices2;
	}
	public List<Device> getDevices() {
		return devices;
	}
}
