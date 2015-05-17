package com.terminalbit.HackBit.game;

import com.terminalbit.HackBit.game.connection.Connection;
import com.terminalbit.HackBit.game.render.StateRenderer;

public class Game implements Runnable {
	public StateRenderer renderer;
	public Connection serverConnection;
	public ComputerRoom currentRoom;
	public String connectionIP = "fakeServer";
	public Thread thread;
	public Boolean alive = false;
	public Game() {
		renderer = new StateRenderer();
		serverConnection = new Connection(connectionIP);
		System.out.println("Constructed");
		start();
	}
	public synchronized void start() {
		if(alive)
			return;
		alive = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if(!alive)
			return;
		alive = false;
		try{
			System.out.println("Killed the thread.");
			thread.join();
			//Kill the thread, guys. :D
		}catch(InterruptedException e){
			//print le errors :(
			e.printStackTrace();
		}
	}
	public void update() {
		System.out.println(getIP(0));
	}
	public void render() {
		//rendering = later
	}
	public String getIP(int ipID) {
		return serverConnection.getIP(ipID).get();
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
