package com.smoothstack.lms.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.entity.Author;
import com.smoothstack.lms.entity.Book;
import com.smoothstack.lms.entity.Publisher;

public class BookDao {
	private final static String PATH = "src/com/smoothstack/lms/resources/";	
	
	public void addBook(String bookName, String authorName, String publisherName) {
		List<Book> books = loadBookDataBase();

		int firstBookIndex = findFirstBookIndex();
		AuthorDao authorDao = new AuthorDao();
		PublisherDao publisherDao = new PublisherDao();

		Author newAuthor = authorDao.retrieveAuthor(authorName);
		Publisher newPublisher = publisherDao.retrievePublisher(publisherName);
		int firstAuthorIndex = newAuthor == null ? authorDao.findFirstAuthorIndex() : newAuthor.getAuthorID();
		int firstPublisherIndex = newPublisher == null ? publisherDao.findFirstPublisherIndex() : newPublisher.getPublisherID();
		
		books.add(firstBookIndex, new Book(firstBookIndex, bookName, firstAuthorIndex, firstPublisherIndex));
		
		if(newAuthor == null) {
			authorDao.addAuthors(authorName);
		}
		if(newPublisher == null) { 
			publisherDao.addPublishers(publisherName);
		}
		uploadBookDataBase(books);

	}
		
	public Book retrieveBook(String bookName) {
		List<Book> books = loadBookDataBase();

		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getBookName().equals(bookName)) {
				return books.get(i);
			}
		}
		return null;
	}
	public Book updateBook(String bookName, String newBookName) {
		List<Book> books = loadBookDataBase();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getBookName().equals(bookName)) {
				books.get(i).setBookName(newBookName);
				Book newBook = new Book();
				uploadBookDataBase(books);
				return newBook;
			}
		}
		return null;
	}
	public void removeBook(String bookName) { //maybe return book removed
		List<Book> books = loadBookDataBase();

		for(int i = 0; i < books.size(); i ++) {
			if(bookName.equals(books.get(i).getBookName())) {
				System.out.println(books.remove(i).getBookName() + " has been removed");
				i--;
			}
		}
		uploadBookDataBase(books);

	}
	public Book removePublisherAndAuthorsByBook(String bookName) {
		PublisherDao publisherDao = new PublisherDao();
		AuthorDao authorrDao = new AuthorDao();

		Book tempBook = retrieveBook(bookName);
		if(tempBook == null) {
			return null;
		}
		int tempPublisherID = tempBook.getPublisherID();
		publisherDao.removePublisher(tempPublisherID); //remove publisher
		int tempAuthorID = tempBook.getAuthorID();
		
		authorrDao.removeAuthors(tempAuthorID); //remove author
		removeBook(bookName); //remove book
		return tempBook;
	}	
	public String printBookList() {
		List<Book> books = loadBookDataBase();

		
		String str = "";
		for(int i =0 ; i < books.size(); i ++) {
			str += "bookID: " + books.get(i).getBookID() + "\n";
			str += "bookName: "+ books.get(i).getBookName() + "\n";
			str += "authorID: "+ books.get(i).getAuthorID() + "\n";
			str += "publisherID: "+ books.get(i).getPublisherID()+ "\n";
			str += "\n";
		}
		return str;
	}
	public int findFirstBookIndex() { 
		List<Book> books = loadBookDataBase();

		for(int i = 0; i < books.size(); i ++) {
			
			if(i != books.get(i).getBookID()) {
				return i;
			}
		}
		return books.size();
	}
	
	
	public List<Book> loadBookDataBase() {
		String row;
		List<Book> books = new ArrayList<>();

		try {
			BufferedReader csvReader;

			csvReader = new BufferedReader(new FileReader(PATH + "book.csv"));
			while ((row = csvReader.readLine()) != null) {  
			    String[] data = row.split(",");
			    int bookID = Integer.parseInt(data[0]);//id
			    String name = data[1]; //name
			    int authorID = Integer.parseInt(data[2]);
			    int publisherID = Integer.parseInt(data[3]);
			    Book newBook = new Book(bookID,name,authorID,publisherID);
			    books.add(newBook);
			}
			//idBookCount = books.size(); /need to fi siizng issue
			csvReader.close();  

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return books;
	}
	public void uploadBookDataBase(	List<Book> books)  {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(PATH + "book.csv");
			for (Book rowData : books) {  
				csvWriter.append(rowData.getBookID() + ",");
				csvWriter.append(rowData.getBookName() + ",");
				csvWriter.append(rowData.getAuthorID() + ",");
				csvWriter.append(rowData.getPublisherID() + ",");
			    csvWriter.append("\n");
			}
			csvWriter.flush();  
			csvWriter.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
