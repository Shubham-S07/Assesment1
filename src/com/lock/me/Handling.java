package com.lock.me;

	import java.util.List;
	import java.util.Scanner;

	public class Handling {
		public static void WelcomePageInput() {
			boolean running = true;
			Scanner sc = new Scanner(System.in);
			do {
				try {
					OptionDisplay.displayMenu();
					int input = sc.nextInt();

					switch (input) {
					case 1:
						FileOption.displayAllFiles("LockME");
						break;
					case 2:
						Handling.FileMenuOptions();
						break;
					case 3:
						System.out.println("Program Exited.");
						running = false;
						sc.close();
						System.exit(0);
						break;
					default:
						System.out.println("Please select an Option.");
					}
				} catch (Exception e) {
					System.out.println(e.getClass().getName());
					WelcomePageInput();
				} 
			} while (running == true);
		}
		
		public static void FileMenuOptions() {
			boolean running = true;
			Scanner sc = new Scanner(System.in);
			do {
				try {
					OptionDisplay.displayFileMenuOptions();
					FileOption.createLockMEFolderIfNotPresent("LockME");
					
					int input = sc.nextInt();
					switch (input) {
					case 1:
						System.out.println("Enter the name of the file to add\"LockME\" folder");
						String fileToAdd = sc.next();
						
						FileOption.createFile(fileToAdd, sc);
						
						break;
					case 2:
						System.out.println("Enter the name of the file to be deleted from \"LockME\" folder");
						String fileToDelete = sc.next();
						
						FileOption.createLockMEFolderIfNotPresent("LockME");
						List<String> filesToDelete = FileOption.displayFileLocations(fileToDelete, "LockME");
						
					String deletionPrompt = "\nSelect index of which file to delete?"
					+ "\n(Enter 0 if you want to delete all elements)";
						System.out.println(deletionPrompt);
					
						int index = sc.nextInt();
						
						if (index != 0) {
							FileOption.deleteFileRecursively(filesToDelete.get(index - 1));
						} else {
							
							for (String path : filesToDelete) {
								FileOption.deleteFileRecursively(path);
							}
						}
						

						break;
					case 3:

						System.out.println("Enter the name of the file to be searched from \"LockME\" folder");
						String fileName = sc.next();
						
						FileOption.createLockMEFolderIfNotPresent("LockME");
						FileOption.displayFileLocations(fileName, "LockME");

						
						break;
					case 4:
						
						return;
					case 5:
						
						System.out.println("Program Exited.");
						running = false;
						sc.close();
						System.exit(0);
					default:
						System.out.println("Please select an option.");
					}
				} catch (Exception e) {
					System.out.println(e.getClass().getName());
					FileMenuOptions();
				}
			} while (running == true);
		}
	}
