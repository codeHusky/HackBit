package com.terminalbit.HackBit.fakeserver.datatypes;

public class User {
	public int UserID;
	public ComputerRoom userRoom;
	public User(int ID, ComputerRoom userRoom) {
		//This user is used for just holding a logged in user.
		UserID = ID;
		this.userRoom = userRoom;
	}
}
