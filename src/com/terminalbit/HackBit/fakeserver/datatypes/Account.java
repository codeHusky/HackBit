package com.terminalbit.HackBit.fakeserver.datatypes;

public class Account {
	private String password; // Uh, no public passwords, please :D
	public String username;
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean checkPass(String checkedPass) {
		return checkedPass.equals(password);
	}

}
