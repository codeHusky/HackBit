package com.terminalbit.HackBit.game;

import java.util.Optional;

import com.terminalbit.HackBit.HackBit;
import com.terminalbit.HackBit.game.connection.Connection;
//import com.terminalbit.HackBit.game.render.StateRenderer;
import com.terminalbit.HackBit.game.datatypes.ComputerRoom;

public class Game implements Runnable {
	//public StateRenderer renderer;
	public Connection serverConnection;
	public ComputerRoom currentRoom;
	public String connectionIP = "fakeServer";
	public Thread thread;
	public Boolean alive = false;
	public Boolean hasInit = false;
	public Game() {
		//renderer = new StateRenderer();
		serverConnection = new Connection(connectionIP);
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
		try{
			HackBit.fakeserver.thread.join();
			thread.join();
			//Kill the thread, guys. :D
			//Then kill the entire thing for debug purposes.
			System.exit(0);
		}catch(InterruptedException e){
			//print le errors :(
			e.printStackTrace();
		}
	}
	public void init() {
		if(!serverConnection.connected)
			return;
		System.out.println("Server IP: " + getConnectionData("ServerIP").get());
		System.out.println("Client ID: " + getConnectionData("ClientID").get());
		hasInit = true;
	}
	public void update() {
		if(!hasInit)
			init();
		//alive = false;
	}
	public void render() {
		//rendering = later
	}
	public Optional<Object> getConnectionData(String data){
		return serverConnection.getData(data);
	}
	@Override
	public void run() {
		while(alive){
			loop();
		}
		stop();
	}
	private void loop() {
		this.render();
		this.update();
	}
}
