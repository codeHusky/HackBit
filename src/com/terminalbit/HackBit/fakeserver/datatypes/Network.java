package com.terminalbit.HackBit.fakeserver.datatypes;

import java.util.List;

public class Network {
	private List<Device> devices;
	public Network(List<Device> devices){
		//We use an ipID because assigning individual ips is bound to cause
		//conflict. So, we just get the ip using a getIP() function from the Connection.
		this.devices = devices;
	}
	public List<Device> getDevices() {
		return devices;
	}
}
