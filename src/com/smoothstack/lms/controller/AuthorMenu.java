package com.smoothstack.lms.controller;

import java.util.Scanner;

import com.smoothstack.lms.service.AuthorService;

public class AuthorMenu {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nHello you have choosen to modify Author!");
		Boolean runAuthorMenu = true;
        Scanner sc = new Scanner(System.in); 
        AuthorService newAuthorService = new AuthorService();
        String authorName;
		while(runAuthorMenu) {
			System.out.println(MenuOptions.MODFICATIONMENU);
	        String authorMenuChoice = sc.nextLine();
	        switch(authorMenuChoice) {
	        case "1":
	        	System.out.println(MenuOptions.ADDMENU);
	        	System.out.println(MenuOptions.NameQuestion("Author"));
	        	authorName = sc.nextLine();
	        	System.out.println(newAuthorService.addAuthors(authorName));
	        	break;
	        case "2":
	        	System.out.println(MenuOptions.REMOVEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Author"));
	        	authorName = sc.nextLine();
	        	System.out.println(newAuthorService.removeAuthor(authorName));
	        	break;
	        case "3":
	        	System.out.println(MenuOptions.RETRIEVEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Author"));
	        	authorName = sc.nextLine();
	        	System.out.println(newAuthorService.retrieveAuthor(authorName));
	        	break;
	        case "4":
	        	System.out.println(MenuOptions.UPDATEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Author"));
	        	authorName = sc.nextLine();
	        	System.out.println(MenuOptions.updateByNameQuestion("Author"));
	        	String newAuthorName = sc.nextLine();
	        	System.out.println(newAuthorService.updateAuthor(authorName, newAuthorName));
	        	break;
	        case "5":
	        	System.out.println(MenuOptions.QUITOPTION);
	        	runAuthorMenu = false;
	        	break;
	        default:
	        	System.out.println(MenuOptions.INVALIDOPTION);
	        		break;
	        }
		}
	}

}
