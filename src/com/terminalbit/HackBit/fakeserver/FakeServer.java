package com.terminalbit.HackBit.fakeserver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import com.terminalbit.HackBit.fakeserver.datatypes.ComputerRoom;
import com.terminalbit.HackBit.fakeserver.datatypes.Terminal;
import com.terminalbit.HackBit.fakeserver.datatypes.Device;
import com.terminalbit.HackBit.fakeserver.datatypes.Network;
import com.terminalbit.HackBit.fakeserver.datatypes.User;

public class FakeServer implements Runnable {
	private String serverIP;
	private List<User> users = new ArrayList<User>();
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
	public Optional<Object> sendOff(Object anything){
		return Optional.of((Object) anything);
	}
	@Override
	public void run() {
		
	}
	public Optional<Object> receive(String dT, String dC) {
		Object breaker;
		switch(dT){//Cuz Java 8
			case "ConnectionData":
				switch(dC){
					case "ServerIP":
						breaker = serverIP;
					break;
					case "ClientID":
						breaker = 0;
					break;
					default:
						breaker = "Error: Not found";
					break;
				}
			break;
			case "ClientPost":
				String[] dCSplit = dC.split(Pattern.quote("|"));
				String prefix = dCSplit[0];
				switch(prefix){
					case "CreateAccount":
						Terminal newTerminal = new Terminal();
						List<Device> devices = new ArrayList<Device>();
						Network newNetwork = new Network(devices);
						ComputerRoom userRoom = new ComputerRoom(newTerminal,newNetwork);
						users.add(new User(users.size(),userRoom));
						breaker = users.size();
					break;
					default:
						breaker = "Invalid ClientPost";
					break;
				}
			break;
			default:
				breaker = "Error: Type not found";
			break;
		}
		return sendOff(breaker);
	}
}
