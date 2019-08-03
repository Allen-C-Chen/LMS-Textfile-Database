package com.smoothstack.lms.controller;

import java.util.Scanner;

import com.smoothstack.lms.service.PublisherService;

public class PublisherMenu {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nHello you have choosen to modify Publisher!");
		Boolean runPublisherMenu = true;
        Scanner sc = new Scanner(System.in); 
        PublisherService newPublisherService = new PublisherService();
        String publisherName;
		while(runPublisherMenu) {
			System.out.println(MenuOptions.MODFICATIONMENU);
	        String publisherMenuChoice = sc.nextLine();
	        switch(publisherMenuChoice) {
	        case "1":
	        	System.out.println(MenuOptions.ADDMENU);
	        	System.out.println(MenuOptions.NameQuestion("Publisher"));
	        	publisherName = sc.nextLine();
	        	System.out.println(newPublisherService.addPublishers(publisherName));
	        	break;
	        case "2":
	        	System.out.println(MenuOptions.REMOVEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Publisher"));
	        	publisherName = sc.nextLine();
	        	System.out.println(newPublisherService.removePublisher(publisherName));
	        	break;
	        case "3":
	        	System.out.println(MenuOptions.RETRIEVEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Publisher"));
	        	publisherName = sc.nextLine();
	        	System.out.println(newPublisherService.retrievePublisher(publisherName));
	        	break;
	        case "4":
	        	System.out.println(MenuOptions.UPDATEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Publisher"));
	        	publisherName = sc.nextLine();
	        	System.out.println(MenuOptions.updateByNameQuestion("Publisher"));
	        	String newPublisherName = sc.nextLine();
	        	System.out.println(newPublisherService.updatePublisher(publisherName, newPublisherName));
	        	break;
	        case "5":
	        	System.out.println(MenuOptions.QUITOPTION);
	        	runPublisherMenu = false;
	        	break;
	        default:
	        	System.out.println(MenuOptions.INVALIDOPTION);
	        		break;
	        }
		}
	}

}
