package com.lock.me;

public class OptionDisplay {

	public static void printWelcomeScreen(String AppName, String DeveloperName) {
		String CompanyDetails = String.format("\n"
				+ "\tWelcome to %s.com \n" 
				+ "This application was developed by %s.\n"+ "\t\n", AppName, DeveloperName);
		String Function = "Application:-\n"
			+ "-> Retrieve file name in the \"LockME\" folder\n"
			+ "-> Search, add, or delete file in \"LockME\" folder.\n";
		System.out.println(CompanyDetails);

		System.out.println(Function);
			}

	public static void displayMenu() {
		String menu = "\n\n Select The Option:\n\n"
			+ "1) Retrieve all files \"LockME\" folder\n" 
			+ "2) Display Menu for Operations\n"
			+ "3) Exit\n";
		System.out.println(menu);
			}

	public static void displayFileMenuOptions() {
		String fileMenu = "\n Select Any Option\n"
			+ "1) Add a file to \"LockME\" folder\n"
			+ "2) Delete a file from \"LockME\" folder\n"
			+ "3) Search for a file from \"LockME\" folder\n" 
			+ "4) Show Previous \n" 
			+ "5) Exit \n";

		System.out.println(fileMenu);
		}
	}
