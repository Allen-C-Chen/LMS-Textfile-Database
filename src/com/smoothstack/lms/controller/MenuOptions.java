package com.smoothstack.lms.controller;

public class MenuOptions {
	public final static String MODFICATIONMENU = 
			"Please choice one of the following options\n" + 
			"(1) ADD\n" +
			"(2) REMOVE\n" + 
			"(3) RETRIEVE\n" +  
			"(4) UPDATE\n" +
			"(5) Back to main menu";
	public final static String ADDMENU = 
			"Hello there you selected the add option";
	public final static String REMOVEMENU = 
			"Hello there you selected the remove option";
	public final static String RETRIEVEMENU = 
			"Hello there you selected the retrieve option";
	public final static String UPDATEMENU= 
			"Hello there you selected the update option";
	public final static String BOOKNAMEQUESTION = 
			"What is the book name?";
	public final static String INVALIDOPTION = 
			"Invalid Option, please try again";
	public final static String QUITOPTION = 
			"You choose to quit, returning to previous menu...";
	
	public static String NameQuestion(String str) { //works for author book and publisher
		if(str.equalsIgnoreCase("book")) {
			return "What is the " + str + " title";
		}
		return "What is the " + str + " name";
	}
	public static String updateByNameQuestion(String str) {
		if(str.equalsIgnoreCase("book")) {
			return "What is the new " + str + " title";
		}
		return "What is the new " + str + " name";

	}
}
