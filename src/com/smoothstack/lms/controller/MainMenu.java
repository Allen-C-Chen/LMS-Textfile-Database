package com.smoothstack.lms.controller;

import java.util.Scanner;

public class MainMenu {
	public final static String DEFAULTMENU = 
			"Hello there, would you like to modfiy \n" + 
			"(1) Book \n" +
			"(2) Authors \n" +
			"(3) Publisher \n" +
			"(4) Quit";

	public void runMainMenu() {
		Boolean mainMennRun = true;
        String mainMenuChoice = "default";
		while(mainMennRun) {
			System.out.println(DEFAULTMENU);
	        Scanner sc = new Scanner(System.in); 
			if(sc.hasNextLine()) {
		        mainMenuChoice = sc.nextLine();
			}
	        switch(mainMenuChoice)
	        {
	        case "1":
	        		BookMenu bookMenu = new BookMenu();
	        		bookMenu.run();
	        	break;
	        case "2":
	        		AuthorMenu authorMenu = new AuthorMenu();
	        		authorMenu.run();
	        	break;
	        case "3":
	        		PublisherMenu publisherMenu = new PublisherMenu();
	        		publisherMenu.run();
	        	break;
	        case "4":
	        	mainMennRun = false;
	        	break;
	        default:
	        		System.out.println("Invalid input, please try again");
	        	
	        }
		}

	}
}
