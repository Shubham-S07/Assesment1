package com.lock.me;

public class WelcomePage {

	public static void main(String[] args) {
		
		FileOption.createLockMEFolderIfNotPresent("LockME");
		
		OptionDisplay.printWelcomeScreen("LockedME", "Shubham Sharma");
		
		Handling.WelcomePageInput();
	}
}