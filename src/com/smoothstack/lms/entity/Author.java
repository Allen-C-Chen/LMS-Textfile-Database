package com.smoothstack.lms.entity;

public class Author {
	private int authorID;
	private String name;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int authorID, String name) {
		super();
		this.authorID = authorID;
		this.name = name;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Author [name=" + name + "]";
	}

	
	
}
