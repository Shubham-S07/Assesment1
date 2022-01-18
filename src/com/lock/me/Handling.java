package com.lock.me;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java. util.Scanner;

public class  Handling {

	File folder;
	static String dir;
     //Constructor
      Handling()
	{
// Directory
	  dir = System.getProperty("user.dir");
	     folder = new File(dir + "/LockME");
	     
		if (!folder.exists()) {
			folder.mkdir();
		}
	}
	//Display files in ascending order
	public void displayfiles() throws IOException {
	   
		File f1 = new File(folder + "/ First");
		f1.createNewFile();
		File f2 = new File(folder + "/Second");
		f2.createNewFile();
		String[] list = folder.list();
		System.out.println("The files present in" +folder+ " are:- " );
		Arrays.sort(list);
         for( String s:list)
         {
        	System.out.println(s); 
         }
	}
      //Add files to directory
	public void addfile() throws IOException
	{
		System.out.println("\n Enter the file name to add:- ");
		Scanner sc = new Scanner(System.in); 
			String filename = sc.nextLine();
			File path = new File(folder +"/" +filename);
			  String[] list = folder.list();
			  for(String list1:list)
			  {
				  if(filename.equalsIgnoreCase(list1))
				  {
					System.out.println("File cannot be created!");  
				  }
			  }
			  path.createNewFile();
		System.out.println("The file is added to the. " +folder);
	}
//Delete file from the directory
	   public void deletefile()
	   {   
           System.out.println("Enter the name of the file to be deleted");
          Scanner sc = new Scanner(System.in);
           String filename = sc.next();
           File filepath = new File(folder +"/"+filename);
           String[] list = folder.list();
           for (String file: list) {
           if (filename.equals(file) && filepath.delete()) {
                   System.out.println("File " + filename + " Deleted From " + folder);
                   return;           
	   }
              
}  
           System.out.println("Operation Failed ! FILE NOT FOUND !");
          
	   }
//Search the file
public void searchfile()
	    {
	    	System.out.println("Enter The File Name to Search");
	    	Scanner sc = new Scanner(System.in); 
				String addfile  =  sc.next();
	    	   File f = new File(folder + "/" +addfile);
	    	       String[] list   =  folder.list();
	    	       for(String s:list)
	    	       {
	    	    	  if(addfile.equals(s))
	    	    	  {
	    	    		  System.out.println("File Found  :" +addfile);
	    	    		  return;
	    	    	  }
	    	       }
	    	    System.out.println("File Not Found !!");	       
	    }
}


