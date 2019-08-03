package com.smoothstack.lms.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.lms.entity.Book;
import com.smoothstack.lms.entity.Publisher;

public class PublisherDao {
	private final static String PATH = "src/com/smoothstack/lms/resources/";	
	public Publisher updatePublisher(String publisherName, String newPublisherName) {
		List<Publisher> publishers = loadPublisherDataBase();

		String str = "not";
		for(int i = 0; i < publishers.size(); i ++) {
			if(publishers.get(i).getPublisherName().equals(publisherName)) {
				publishers.get(i).setPublisherName(newPublisherName);
				Publisher publisher = publishers.get(i);
				uploadPublisherDataBase(publishers);
				return publisher;
			}
		}
		return null;
	}
	
	public void addPublishers(String publisherName) {
		List<Publisher> publishers = loadPublisherDataBase();

		int firstPublisherIndex = findFirstPublisherIndex();
		publishers.add(firstPublisherIndex, new Publisher(firstPublisherIndex, publisherName));
		uploadPublisherDataBase(publishers);

	}
	
	public Publisher retrievePublisher(String publisherName) {
		List<Publisher> publishers = loadPublisherDataBase();

		for(int i = 0; i < publishers.size(); i ++) {
			if(publishers.get(i).getPublisherName().equals(publisherName)) {
				return publishers.get(i);
			}
		}
		return null;
	}
	public void removePublisher(int tempPublisherID) {
		// TODO Auto-generated method stub
		List<Publisher> publishers = loadPublisherDataBase();
		for(int i = 0; i < publishers.size(); i ++) {
			if(tempPublisherID == publishers.get(i).getPublisherID()) {
				
				System.out.println(publishers.remove(i).getPublisherName() + " has been removed");
				i--;
			}
		}
		uploadPublisherDataBase(publishers);
	}
	public Publisher removeBooksAndAuthorsByPublisher(String publisherName) {
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.loadBookDataBase();
		AuthorDao authorDao= new AuthorDao();
		Publisher publisher = retrievePublisher(publisherName);
		if(publisher == null) {
			return null;
		}
		int publisherID = publisher.getPublisherID();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getPublisherID() == publisherID) {
				int tempAuthorID = books.get(i).getAuthorID();
				authorDao.removeAuthors(tempAuthorID);
				Book book = books.remove(i);
				bookDao.removeBook(book.getBookName());
				i--;
			}
		}
		removePublisher(publisherID);
		return publisher;
	}
	
	public int findFirstPublisherIndex() { //**
		List<Publisher> publishers = loadPublisherDataBase();

		for(int i = 0; i < publishers.size(); i ++) {
			
			if(i != publishers.get(i).getPublisherID()) {
				return i;
			}
		}
		return publishers.size();
	}
	public String printPublisherList() {
		List<Publisher> publishers = loadPublisherDataBase();

		String str = "";
		for(int i =0 ; i < publishers.size(); i ++) {
			str += "PublisherID: " + publishers.get(i).getPublisherID() + "\n";
			str += "PublisherName: " + publishers.get(i).getPublisherName() +  "\n";
			str += "\n";
		}
		return str;
	}
	public List<Publisher> loadPublisherDataBase()  {
		List<Publisher> publishers = new ArrayList<>();
		String row;
		try {
			BufferedReader csvReader;

			csvReader = new BufferedReader(new FileReader(PATH + "publisher.csv"));
			while ((row = csvReader.readLine()) != null) {  
			    String[] data = row.split(",");
			    int publisherID = Integer.parseInt(data[0]);
			    String name  = data[1];
			    Publisher newPublisher = new Publisher(publisherID, name);
			    publishers.add(newPublisher);
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

		return publishers;
	}
	
	public void uploadPublisherDataBase(List<Publisher> publishers) {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(PATH + "publisher.csv");  
			for (Publisher rowData : publishers) {  
				csvWriter.append(rowData.getPublisherID() + ",");
				csvWriter.append(rowData.getPublisherName() + ",");
			    csvWriter.append("\n");
			}
			csvWriter.flush();  
			csvWriter.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	public Publisher retrievePublisherByID(int publisherID) {
		// TODO Auto-generated method stub
		List<Publisher> publishers = loadPublisherDataBase();

		for(int i = 0; i < publishers.size(); i ++) {
			if(publishers.get(i).getPublisherID() == publisherID) {
				return publishers.get(i);
			}
		}
		return null;
	}
}
