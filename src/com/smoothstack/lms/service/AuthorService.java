package com.smoothstack.lms.service;


import com.smoothstack.lms.dao.AuthorDao;
import com.smoothstack.lms.entity.Author;


public class AuthorService {
	private AuthorDao authorDao;
	public AuthorService (){
		authorDao = new AuthorDao();
	}
	public String addAuthors(String authorName) {
		authorDao.addAuthors(authorName);
		return authorName + " has been added";
	}
	public String retrieveAuthor(String authorName) {
		Author newAuthor = authorDao.retrieveAuthor(authorName);
    	if(newAuthor == null) {
    		return "You are trying to retrieve an author that does not exist";
    	}
    	return newAuthor.toString();
	}
	public String updateAuthor(String authorName, String newAuthorName) {
		Author newAuthor = authorDao.updateAuthor(authorName, newAuthorName);
		if(newAuthor == null) {
    		return "You are trying to update an author that does not exist";
		}
		return newAuthor.toString();
	}
	public String removeAuthor(String authorName) {
    	Author newAuthor= authorDao.removeBooksAndPublishersByAuthors(authorName);
    	if(newAuthor == null) {
    		return "You are trying to remove an author that does not exist";
    	}
    	return newAuthor.getName() + " has been removed";
	}
	public String printAllAuthors() {
		return authorDao.printAuthorList();
	}
}
