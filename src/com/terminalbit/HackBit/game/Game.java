package com.terminalbit.HackBit.game;

import com.terminalbit.HackBit.game.connection.Connection;
import com.terminalbit.HackBit.game.render.StateRenderer;

public class Game {
	public static StateRenderer renderer;
	public static Connection serverConnection;
	public static ComputerRoom currentRoom;
	public static String connectionIP = "fakeServer";
	public Game() {
		renderer = new StateRenderer();
		serverConnection = new Connection(connectionIP);
	}
	public static void update() {
		
	}
	public static void render() {
		
	}
	public static String getIP(int ipID) {
		return serverConnection.getIP(ipID).get();
	}
}
