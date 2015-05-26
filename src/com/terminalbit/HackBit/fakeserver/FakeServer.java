package com.terminalbit.HackBit.fakeserver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import com.terminalbit.HackBit.fakeserver.datatypes.Account;
import com.terminalbit.HackBit.fakeserver.datatypes.ComputerRoom;
import com.terminalbit.HackBit.fakeserver.datatypes.Terminal;
import com.terminalbit.HackBit.fakeserver.datatypes.Device;
import com.terminalbit.HackBit.fakeserver.datatypes.Network;

public class FakeServer implements Runnable {
	private String serverIP = "fakeServer";
	private Map<String, Account> accounts = new HashMap<String,Account>();
 	public Thread thread;
 	public Boolean alive = false;
 	public Boolean loggedin = false;
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
	}
	public Optional<Object> sendOff(Object anything){
		return Optional.of((Object) anything);
	}
	@Override
	public void run() {}
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
						if(dCSplit.length == 3){
							Account newAccount = new Account(dCSplit[1],dCSplit[2]);
							if(!accounts.containsKey(dCSplit[1])){
								accounts.put(dCSplit[1], newAccount);
								breaker = "Account \"" + dCSplit[1] + "\" has been created. Please log in.";
							}else{
								breaker = "Account already exists with that username.";
							}
						}else{
							breaker = "Account creation failed.";
						}
					break;
					case "Login":
						if(loggedin){
							breaker = "You're already logged in.";
						}else if(dCSplit.length == 3){
							if(accounts.containsKey(dCSplit[1])){
								Account loginAccount = accounts.get(dCSplit[1]);
								if(loginAccount.checkPass(dCSplit[2])){
									loggedin = true;
									breaker = "Logged in!";
								}else{
									breaker = "Incorrect password";
								}
							}else{
								breaker = "Account does not exist D:";
							}
						}else{
							breaker = "Failed to log in.";
						}
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
