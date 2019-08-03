package com.smoothstack.lms.service;


import com.smoothstack.lms.dao.PublisherDao;
import com.smoothstack.lms.entity.Publisher;


public class PublisherService {
	private PublisherDao publisherDao;
	public PublisherService (){
		publisherDao = new PublisherDao();
	}
	public String addPublishers(String publisherName) {
		publisherDao.addPublishers(publisherName);
		return publisherName + " has been added";
	}
	public String retrievePublisher(String publisherName) {
		Publisher newPublisher = publisherDao.retrievePublisher(publisherName);
    	if(newPublisher == null) {
    		return "You are trying to retrieve an publisher that does not exist";
    	}
    	return newPublisher.toString();
	}
	public String updatePublisher(String publisherName, String newPublisherName) {
		Publisher newPublisher = publisherDao.updatePublisher(publisherName, newPublisherName);
		if(newPublisher == null) {
    		return "You are trying to update an publisher that does not exist";
		}
		return newPublisher.toString();
	}
	public String removePublisher(String publisherName) {
    	Publisher newPublisher= publisherDao.removeBooksAndAuthorsByPublisher(publisherName);
    	if(newPublisher == null) {
    		return "You are trying to remove an publisher that does not exist";
    	}
    	return newPublisher.getPublisherName() + " has been removed";
	}
	public String printAllPublishers() {
		return publisherDao.printPublisherList();
	}
}
