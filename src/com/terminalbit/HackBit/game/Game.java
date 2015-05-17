package com.terminalbit.HackBit.game;

import java.util.Optional;

import com.terminalbit.HackBit.game.components.Network;
import com.terminalbit.HackBit.game.connection.Connection;
import com.terminalbit.HackBit.game.render.StateRenderer;

public class Game implements Runnable {
	public StateRenderer renderer;
	public Connection serverConnection;
	public ComputerRoom currentRoom;
	public String connectionIP = "fakeServer";
	public Thread thread;
	public Boolean alive = false;
	public Boolean hasInit = false;
	public Game() {
		renderer = new StateRenderer();
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
	public void init() {
		hasInit = true;
		System.out.println(getConnectionData("ServerIP").get());
	}
	public void update() {
		if(!hasInit)
			init();
		alive = false;
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
