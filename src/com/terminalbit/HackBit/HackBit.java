package com.terminalbit.HackBit;

import com.terminalbit.HackBit.game.Game;
import com.terminalbit.HackBit.renderer.HBRender;
 
public class HackBit {
	public static Game hbsession = new Game();
    public static void main(String[] args) {
    	hbsession.start();
    }
 
}
