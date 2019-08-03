package com.smoothstack.lms.service;


import com.smoothstack.lms.dao.AuthorDao;
import com.smoothstack.lms.dao.BookDao;
import com.smoothstack.lms.dao.PublisherDao;
import com.smoothstack.lms.entity.Book;


public class BookService {
	private BookDao bookDao;
	public BookService (){
		bookDao = new BookDao();
	}
	public String addBooks(String bookName, String authorName, String publisherName) {
		bookDao.addBook(bookName, authorName, publisherName);
		return bookName + " has been added";
	}
	public String retrieveBook(String bookName) {
		Book newBook = bookDao.retrieveBook(bookName);
    	if(newBook == null) {
    		return "You are trying to retrieve an book that does not exist";
    	}
    	String str = "";
    	AuthorDao authorDao = new AuthorDao();
    	PublisherDao publisherDao = new PublisherDao();
    	str += newBook.toString() + "\n";
    	str += authorDao.retrieveAuthorByID(newBook.getAuthorID()).toString() + "\n";
    	str += publisherDao.retrievePublisherByID(newBook.getPublisherID()).toString();
    	return str;
	}
	public String updateBook(String bookName, String newBookName) {
		Book newBook = bookDao.updateBook(bookName, newBookName);
		if(newBook == null) {
    		return "You are trying to update an book that does not exist";
		}
		return newBook.toString();
	}
	public String removeBook(String bookName) {
    	Book newBook= bookDao.removePublisherAndAuthorsByBook(bookName);
    	if(newBook == null) {
    		return "You are trying to remove an book that does not exist";
    	}
    	return newBook.getBookName() + " has been removed";
	}
	public String printAllBooks() {
		return bookDao.printBookList();
	}
}
