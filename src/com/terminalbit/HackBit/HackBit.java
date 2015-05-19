package com.terminalbit.HackBit;

import com.terminalbit.HackBit.fakeserver.FakeServer;
import com.terminalbit.HackBit.game.Game;
 
public class HackBit {
	public static Game hbsession;
	public static FakeServer fakeserver;
    public static void main(String[] args) {
		fakeserver = new FakeServer();//FakeIP is passed to the server later on 
		fakeserver.start();
    	hbsession = new Game();
		hbsession.start();
    }
}
