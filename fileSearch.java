package com.searchengine.www;

import java.util.ArrayList;

public class fileSearch
{
	private ArrayList<String> ArrayList_ST; //ArrayList of Search Terms
	private ArrayList<String> ArrayList_TF; //ArrayList of Text File
	private int counter = 0;
	private int counterArray[];
	
	//Constructor
	fileSearch(ArrayList<String> ArrayList_ST, ArrayList<String> ArrayList_TF )
	{
		this.ArrayList_ST = ArrayList_ST;
		this.ArrayList_TF = ArrayList_TF;
	}
	

	//Method for checking matches
	public int matchCheck()
	{
		//System.out.println(ArrayList_ST);
		//System.out.println(ArrayList_TF);
		
		for (int i = 0; i < ArrayList_ST.size();)
		{
			//Store matches into first element of array and reset counter
			//counterArray[i] = counter;

			for (int j = 0; j < ArrayList_TF.size(); j=j+1)
			{
				if (ArrayList_ST.get(i).equals(ArrayList_TF.get(j)))
				{
					counter = counter + 1; //A match has been made
				}

			}
			
			i++;
		}
		
		return counter;
	}
	
	//Getters and Setters

	public ArrayList<String> getArrayList_ST() {
		return ArrayList_ST;
	}


	public void setArrayList_ST(ArrayList<String> arrayList_ST) {
		ArrayList_ST = arrayList_ST;
	}


	public ArrayList<String> getArrayList_TF() {
		return ArrayList_TF;
	}


	public void setArrayList_TF(ArrayList<String> arrayList_TF) {
		ArrayList_TF = arrayList_TF;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public int[] getCounterArray() {
		return counterArray;
	}


	public void setCounterArray(int[] counterArray) {
		this.counterArray = counterArray;
	}


	
}
