package com.terminalbit.HackBit;

import com.terminalbit.HackBit.game.Game;
import com.terminalbit.HackBit.renderer.HBRender;
 
public class HackBit {
	public Game hbsession = new Game();
	public static HBRender HBRenderer = new HBRender();
    public static void main(String[] args) {
        HBRenderer.run();
        System.out.println("Hello World!");
    }
 
}
