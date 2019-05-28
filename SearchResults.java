package com.searchengine.www;

public class SearchResults 
{
	private int fileNumber; //Stores which file has been searched.
	private int counter;    //Stores how many matches there are within
						   //this file.
	
	//Constructor
	public SearchResults(int fileNumber, int counter)
	{
		this.fileNumber = fileNumber;
		this.counter = counter;
	}
	

	@Override
	public String toString() 
	{
		return "File: " + fileNumber + "\n" + " Matches: " + counter + "\n" + "\n";
	}

	//Getters and Setters
	public int getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(int fileNumber) {
		this.fileNumber = fileNumber;
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	
}
