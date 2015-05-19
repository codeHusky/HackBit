package com.terminalbit.HackBit.fakeserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.terminalbit.HackBit.game.components.Device;
import com.terminalbit.HackBit.game.components.Network;

public class FakeServer implements Runnable {
	private String serverIP;
	private List<Network> networks;
 	private int networkCount = 0;
 	public Thread thread;
 	public Boolean alive = false;
 	private Boolean ClientConnected = false;
	public FakeServer(){
	}
	public synchronized void start() {
		if(alive)
			return;
		alive = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		System.out.println("JVM Stopping...");
		if(!alive)
			return;
		alive = false;
		try{
			thread.join();
			//Kill the thread, guys. :D
			//Then kill the entire thing for debug purposes.
			System.exit(0);
		}catch(InterruptedException e){
			//print le errors :(
			e.printStackTrace();
		}
	}
	public void connect(String ip) {
		serverIP = ip;
		ClientConnected = true;
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
		if(!ClientConnected)
			return sendOff(null);
		if(string.equals("ServerIP")){
			return sendOff(serverIP);
		}
		if(string.equals("ClientID")){
			return sendOff(0);
		}
		return sendOff(null);
	}
	@Override
	public void run() {
		
	}
}
