package com.lock.me;

import java.io.IOException;
import java.util.Scanner;

public class file {
	
	Handling c1 = new Handling();
	public  file()
	{
		System.out.println("The Application  is ___________LockedME.com_______________");
		System.out.println("Developer Name: Shubham Sharma");
	}
	public void selection() 
	{
	 String menu =
     "\n MENU - Select any of the following: \n"+
             "1 - List files in directory\n"+
             "2 - Add, Search or Delete \n"+
             "3 - Exit";
           System.out.println(menu);
       	try
		{
			while(true)
			{
		Scanner sc = new Scanner(System.in);
		int Selection = sc.nextInt();
         switch(Selection)
         {
         case 1: 
         {
        	 c1.displayfiles();
        	 break;
         }
         case 2:
         {
        	 submenu();
        	 break;
         }
         case 3:
         {
        	 System.out.println("Thanks");
        	 System.exit(0);
         }
         default :  selection();
        	 
         }
		}
		}
         catch(Exception e)
         {
        	 System.out.println("Enter your choice:- \t");
        	 selection();
        	 }
		
	}
	
	@SuppressWarnings("resource")
	public  void submenu() throws IOException
	{
		String submenu=
  "   \nSelect any of thefollowing: \n"+
	   "   1 - Add file \n"+
       "   2 - Search file \n"+
	   "   3 - Delete file \n"+
	   "   4 - Previous \n";
		System.out.println(submenu);
		try
		{
		Scanner s1 = new Scanner(System.in);
		     int option = s1.nextInt();
		 switch(option)
		 {
		 case  1:
		 {
			 c1.addfile();
			 break;
		 }
		 case 2:
		 {
			 c1.searchfile();
			 break;
		 }
		 case 3:
		 {
			 c1.deletefile();
			 break;
		 }
		 case 4:
		 {
			 System.out.println("Previous Menu");
			 selection();
			 break;
		 }
		 default : System.out.println("Enter your choice:-\t");	
	}
	}
		catch(Exception e)
		{
			System.out.println("Enter your choice:-\t");
			submenu();
			}
		}
}