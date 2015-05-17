package com.terminalbit.HackBit;

import com.terminalbit.HackBit.game.Game;
 
public class HackBit {
	public static Game hbsession;
    public static void main(String[] args) {
    	hbsession = new Game();
		hbsession.start();
    }
}
