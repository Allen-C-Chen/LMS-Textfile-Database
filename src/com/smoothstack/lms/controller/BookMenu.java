package com.smoothstack.lms.controller;

import java.util.Scanner;

import com.smoothstack.lms.service.BookService;

public class BookMenu {

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\nHello you have choosen to modify Book!");
		Boolean runBookMenu = true;
        Scanner sc = new Scanner(System.in); 
        BookService newBookService = new BookService();
        String bookName;
		while(runBookMenu) {
			System.out.println(MenuOptions.MODFICATIONMENU);
	        String bookMenuChoice = sc.nextLine();
	        switch(bookMenuChoice) {
	        case "1":
	        	System.out.println(MenuOptions.ADDMENU);
	        	System.out.println(MenuOptions.NameQuestion("book"));
	        	bookName = sc.nextLine();
	        	System.out.println(MenuOptions.NameQuestion("author"));
	        	String authorName = sc.nextLine();
	        	System.out.println(MenuOptions.NameQuestion("publisher"));
	        	String publisherName = sc.nextLine();

	        	System.out.println(newBookService.addBooks(bookName, authorName, publisherName));
	        	break;
	        case "2":
	        	System.out.println(MenuOptions.REMOVEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Book"));
	        	bookName = sc.nextLine();
	        	System.out.println(newBookService.removeBook(bookName));
	        	break;
	        case "3":
	        	System.out.println(MenuOptions.RETRIEVEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Book"));
	        	bookName = sc.nextLine();
	        	System.out.println(newBookService.retrieveBook(bookName));
	        	break;
	        case "4":
	        	System.out.println(MenuOptions.UPDATEMENU);
	        	System.out.println(MenuOptions.NameQuestion("Book"));
	        	bookName = sc.nextLine();
	        	System.out.println(MenuOptions.updateByNameQuestion("Book"));
	        	String newBookName = sc.nextLine();
	        	System.out.println(newBookService.updateBook(bookName, newBookName));
	        	break;
	        case "5":
	        	System.out.println(MenuOptions.QUITOPTION);
	        	runBookMenu = false;
	        	break;
	        default:
	        	System.out.println(MenuOptions.INVALIDOPTION);
	        		break;
	        }
		}
	}

}
