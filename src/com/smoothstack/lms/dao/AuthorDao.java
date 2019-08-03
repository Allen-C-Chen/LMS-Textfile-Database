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
import com.smoothstack.lms.service.BookService;
import com.smoothstack.lms.service.PublisherService;
public class AuthorDao {
	private final static String PATH = "src/com/smoothstack/lms/resources/";
	public void addAuthors(String authorName) {
		List<Author> authors = loadAuthorDataBase();

		int firstAuthorIndex = findFirstAuthorIndex();
		authors.add(firstAuthorIndex,new Author(firstAuthorIndex, authorName));
		uploadAuthorDataBase(authors);

	}
	public Author retrieveAuthor(String authorName) {
		List<Author> authors = loadAuthorDataBase();
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				return authors.get(i);
			}
		}
		return null;
	}
	public Author retrieveAuthorByID(int authorID) {
		List<Author> authors = loadAuthorDataBase();
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getAuthorID() == authorID) {
				return authors.get(i);
			}
		}
		return null;
	}

	public Author updateAuthor(String authorName, String newAuthorName) {
		List<Author> authors = loadAuthorDataBase();

		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				authors.get(i).setName(newAuthorName);
				uploadAuthorDataBase(authors);
				return authors.get(i);
			}
		}
		return null;

	}
	public Author removeBooksAndPublishersByAuthors(String authorName) {
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.loadBookDataBase();
		PublisherDao publisherDao = new PublisherDao();
		Author author = retrieveAuthor(authorName);
		if(author == null) {
			return null;
		}
		int authorID = author.getAuthorID();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getAuthorID() == authorID) {
				int tempPublisherID = books.get(i).getPublisherID();
				publisherDao.removePublisher(tempPublisherID);
				Book book = books.remove(i);
				bookDao.removeBook(book.getBookName());
				i--;
			}
		}
		removeAuthors(authorID);
		return author;
	}
	
	public Author removeAuthors(int tempAuthorID) {
		List<Author> authors = loadAuthorDataBase();
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getAuthorID() ==  tempAuthorID) {
				Author newAuthor = authors.remove(i);
				uploadAuthorDataBase(authors);

				return newAuthor;
			}
		}	
		return null;

	}
	public int findFirstAuthorIndex() { //**
		List<Author> authors = loadAuthorDataBase();

		for(int i = 0; i < authors.size(); i ++) {
			
			if(i != authors.get(i).getAuthorID()) {
				return i;
			}
		}
		return authors.size();
	}
	public String printAuthorList() {
		List<Author> authors = loadAuthorDataBase();

		String str = "";
		for(int i =0 ; i < authors.size(); i ++) {
			str += "authorID: " + authors.get(i).getAuthorID() + "\n";
			str += "authorName: "+ authors.get(i).getName() + "\n";
			str += "\n";
		}
		return str;
	}
	
	public List<Author> loadAuthorDataBase() { //Fix excepetions later
		
		List<Author> authors = new ArrayList<>();
		String row;
		try {
			BufferedReader csvReader;

			csvReader = new BufferedReader(new FileReader(PATH + "author.csv"));
			while ((row = csvReader.readLine()) != null) {  
			    String[] data = row.split(",");
			    int authorID = Integer.parseInt(data[0]);
			    String name = data[1];
			    Author newAuthor = new Author(authorID, name);
			    authors.add(newAuthor);
			    
			}
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
		return authors;
	}
	public void uploadAuthorDataBase(List<Author> authors ) {
		
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(PATH + "author.csv");  
			for (Author rowData : authors) {  
				csvWriter.append(rowData.getAuthorID() + ",");
				csvWriter.append(rowData.getName() + ",");
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
