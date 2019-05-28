package com.searchengine.www;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextFiles 
{
	
	private String str = ""; 
	private File searchFile;
	private ArrayList<String> textFiles_ArrayList = new ArrayList<>();
	private ArrayList<String> searchTerms = new ArrayList<>();
	private String searchTerm;
	
	
	//Constructors
	public TextFiles(String searchTerm)
	{
		this.searchTerm = searchTerm;
	}
	
	public TextFiles(File searchFile)
	{
		this.searchFile = searchFile;
	}

	//Methods
	
	//Method for reading files
	public ArrayList<String> fileReader()
	{
		Scanner scanner = null;
		
		try 
		{
			scanner = new Scanner(searchFile);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		str = scanner.nextLine();
		
		while (scanner.hasNextLine())
		{
			str = str + "\n" + scanner.nextLine();
		}
		
		//Strip str of uppercase characters
		str = str.toLowerCase();
		//Strip str of commas and full stops etc
		str = str.replaceAll("[,.“”;:'!?\"()]","");
		
		String[] parts = str.split(" ");
		int length = parts.length;
		int n;
		 
		for (n=0; n<length; n=n+1)
		{
			String p1 = parts[n];
			textFiles_ArrayList.add(p1);
		}
		
		return textFiles_ArrayList;
	}
	
	//Method for reading Search Terms
	public ArrayList<String> searchTerms()
	{
		
		//Strip searchTerm of Uppercase characters
		searchTerm = searchTerm.toLowerCase();

		if(searchTerm.contains(","))
		{
			
			searchTerm = searchTerm.replaceAll(" ","");
			String[] parts = searchTerm.split(",");
			int length = parts.length;
			int n;
			
			for (n=0; n<length; n=n+1)
			{
				String p1 = parts[n];
				searchTerms.add(p1);
			}
			
			return searchTerms;
		}
		else
		{
			String f1 = searchTerm;
			searchTerms.add(f1);
			return searchTerms;
		}
		
	}

	//Getters and Setters
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public ArrayList<String> getTextFiles_ArrayList() {
		return textFiles_ArrayList;
	}

	public void setTextFiles_ArrayList(ArrayList<String> textFiles_ArrayList) {
		this.textFiles_ArrayList = textFiles_ArrayList;
	}
	
	public ArrayList<String> getSearchTerms() {
		return searchTerms;
	}

	public void setSearchTerms(ArrayList<String> searchTerms) {
		this.searchTerms = searchTerms;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	public File getSearchFile() {
		return searchFile;
	}

	public void setSearchFile(File searchFile) {
		this.searchFile = searchFile;
	}
	
	
}
