package com.lock.me;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileOption {

	public static void createLockMEFolderIfNotPresent(String FName) {
		File file = new File(FName);

		if (!file.exists()) {
			file.mkdirs();
	}
	}
	public static void displayAllFiles(String path) {
	FileOption.createLockMEFolderIfNotPresent("LockME");
	System.out.println("Displaying all files in ascending order\n");

	List<String> FLNames = FileOption.listFilesInDirectory(path, 0, new ArrayList<String>());

	System.out.println("Displaying all files in ascending order\n");
	Collections.sort(FLNames);

	FLNames.stream().forEach(System.out::println);
	}
	public static List<String> listFilesInDirectory(String path, int Count, List<String> FLNames) {
	File dir = new File(path);
	File[] files = dir.listFiles();
	List<File> filesList = Arrays.asList(files);

	Collections.sort(filesList);

	if (files != null && files.length > 0) {
		for (File file : filesList) {

		System.out.print(" ".repeat(Count * 2));

		if (file.isDirectory()) {
		System.out.println("... " + file.getName());

	FLNames.add(file.getName());
	listFilesInDirectory(file.getAbsolutePath(), Count + 1, FLNames);
	} else {
		System.out.println("... " + file.getName());
		FLNames.add(file.getName());
	}
	}
			} 
	else{
	System.out.print(" ".repeat(Count * 2));
	System.out.println("... Empty Dir");
	}
	System.out.println();
	return FLNames;
}

public static void createFile(String FAdd, Scanner sc) {
	FileOption.createLockMEFolderIfNotPresent("LockME");
	Path pathToFile = Paths.get("./LockME/" + FAdd);
	try {
		Files.createDirectories(pathToFile.getParent());
		Files.createFile(pathToFile);
		System.out.println(FAdd + " created successfully");
		System.out.println("Do you want to add to the file (Y/N)");
		String choice = sc.next().toLowerCase();

		sc.nextLine();
		if (choice.equals("y")) {
			System.out.println("\nInput\n");
			String content = sc.nextLine();
			Files.write(pathToFile, content.getBytes());
			System.out.println("\nAdded to file " + FAdd);
			System.out.println("View the Data");
		}
	} catch (IOException e) {
	System.out.println("Failed File Creation " + FAdd);
	System.out.println(e.getClass().getName());
	}
	}

	public static List<String> displayFileLocations(String FName, String path) {
	List<String> FLNames = new ArrayList<>();
	FileOption.searchFileRecursively(path, FName, FLNames);

	if (FLNames.isEmpty()) {
		System.out.println("\t\n !! File Not Found !! \"" + FName + "\" !!!!\n");
	} else {
			System.out.println("\t\nFile location(s):");
		List<String> files = IntStream.range(0, FLNames.size())
				.mapToObj(i -> (i + 1) + ": " + FLNames.get(i)).collect(Collectors.toList());

		files.forEach(System.out::println);
	}

	return FLNames;
	}

	public static void searchFileRecursively(String path, String FName, List<String> FLNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);
		
		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().startsWith(FName)) {
					FLNames.add(file.getAbsolutePath());
				}

		if (file.isDirectory()) {
		searchFileRecursively(file.getAbsolutePath(), FName, FLNames);
	}
	}
}
	}

	public static void deleteFileRecursively(String path) {

		File currFile = new File(path);
		File[] files = currFile.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {

				String FName = file.getName() + " at " + file.getParent();
				if (file.isDirectory()) {
					deleteFileRecursively(file.getAbsolutePath());
				}

				if (file.delete()) {
					System.out.println(FName + " deleted successfully");
				} else {
					System.out.println("Failed to delete " + FName);
				}
			}
		}

		String currFileName = currFile.getName() + " at " + currFile.getParent();
		if (currFile.delete()) {
			System.out.println(currFileName + " deleted successfully");
		} else {
			System.out.println("Failed to delete " + currFileName);
		}
	}
}
