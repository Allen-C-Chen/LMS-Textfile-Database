package com.smoothstack.lms.controller;

import com.smoothstack.lms.service.PublisherService;
import com.smoothstack.lms.service.AuthorService;
import com.smoothstack.lms.service.BookService;
import com.smoothstack.lms.service.PublisherService;

public class BookTest {
	public static void main(String[] args) {
//		PublisherService authorService1 = new PublisherService();
//		PublisherService authorService2 = new PublisherService();
		AuthorService authorService3 = new AuthorService();
//		authorService1.addPublishers("Diana");
//		authorService2.addPublishers("diana2");
//		System.out.println(authorService3.printAllPublishers());

		BookService bookService1 = new BookService();
		BookService bookService2 = new BookService();
		BookService bookService3 = new BookService();
		//bookService1.addBooks("Diana Book", "Diana Author" , "Diana Publisher");
		bookService2.addBooks("Vivian Book", "Vivian Author" , "Vivian Publisher");
		System.out.println(bookService3.printAllBooks());

		authorService3.removeAuthor("Vivian Author");
		//bookService2.removeBook("Vivian Book");
		//bookService1.updateBook("Diana Book", "Diana bank");
		System.out.println(bookService3.printAllBooks());
		System.out.println("Author List");
		AuthorService authorService1 = new AuthorService();
		System.out.println(authorService1.printAllAuthors());
		System.out.println("PublisherList");
		PublisherService publisherService = new PublisherService();
		System.out.println(publisherService.printAllPublishers());
	}
}
