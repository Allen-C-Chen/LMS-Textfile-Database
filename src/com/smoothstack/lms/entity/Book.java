package com.smoothstack.lms.entity;

public class Book {
	private int bookID;
	private String bookName;
	private int authorID;
	private int publisherID;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookID, String bookName, int authorID, int publisherID) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorID = authorID;
		this.publisherID = publisherID;
	}
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public int getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(int publisherID) {
		this.publisherID = publisherID;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + "]";
	}
	
}
