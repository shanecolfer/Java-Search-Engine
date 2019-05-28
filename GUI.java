package com.searchengine.www;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;


import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class GUI extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Buttons | TextFields | TextAreas
	public JButton goButton;
	public JTextField userInput1;
	public JTextArea outPut1;
	
	//ArrayList to hold user input
	private ArrayList<String> GUI_ArrayList_U = new ArrayList<>();
	
	//ArrayLists to hold 5 search files
	private ArrayList<String> GUI_ArrayList_T_1 = new ArrayList<>();

	//ArrayList to hold class SearchResults
	private ArrayList<SearchResults> AL_searchResults = new ArrayList<>();
	
	//Counter
	private int counter;
	private int counter1;
	
	//Constructor
	GUI(String title)
	{
		super(title);
		setTitle("Shane's Search Engine");
		setResizable(false);
		setSize (742,498);
		
		//Textfield1
		userInput1 = new JTextField("");
		
		//Button1
		goButton = new JButton("GO!");
		goButton.addActionListener(this);
		setVisible(true);
	
		
		//Output1
		outPut1 = new JTextArea(15,20);
		
		JLabel lblNewLabel = new JLabel("Enter your search terms");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblWhen = new JLabel("When searching multiple terms, please separate");
		lblWhen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblYourTermsUsing = new JLabel("your terms using a comma (,).");
		lblYourTermsUsing.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblYouCanSearch = new JLabel("You can search a single term by entering it in");
		lblYouCanSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblAlone = new JLabel("alone.");
		lblAlone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your search terms first, then");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblGoToChoose = new JLabel("press GO! to choose your files");
		lblGoToChoose.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(lblYouCanSearch, 0, 0, Short.MAX_VALUE)
							.addComponent(lblYourTermsUsing, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblWhen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblAlone, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblPleaseEnterYour, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblGoToChoose, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(outPut1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(userInput1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(goButton)))
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(userInput1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(goButton))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(outPut1, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblWhen)
							.addGap(14)
							.addComponent(lblYourTermsUsing)
							.addGap(42)
							.addComponent(lblYouCanSearch)
							.addGap(11)
							.addComponent(lblAlone)
							.addGap(34)
							.addComponent(lblPleaseEnterYour)
							.addGap(11)
							.addComponent(lblGoToChoose)))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent event) 
	{
		//If Statement to check if button was pressed
		if(event.getSource()==goButton)
		{
			//Read in search terms
			String searchTerm = userInput1.getText();
			
			//Create a TextFiles object 
			TextFiles s1 = new TextFiles(searchTerm);
			
			//Return searchTerms into an arrayList
			GUI_ArrayList_U = s1.searchTerms();
			
			//Set TextBox to blank
			outPut1.setText(null);
			
			//Take in selected files in an array
			File[] files = FileSelector.main();
			
			
			//Loop for match checking
			for(counter=0; counter<files.length;)
			{
				//Reads each textFile into ArrayList
				TextFiles t1 = new TextFiles(files[counter]);
				GUI_ArrayList_T_1 = t1.fileReader();
				
				//Creates fileSearch object using searchTerms and textFile
				fileSearch f1 = new fileSearch(GUI_ArrayList_U,GUI_ArrayList_T_1);
				
				//Uses matchCheck method to find matches
				counter1 = f1.matchCheck();
				
				//Creates searchResults object using results of matchCheck (counter) and index of file (counter1)
				SearchResults r1 = new SearchResults(counter, counter1);
				
				//Adds result searchResults object to AL_searchResults ArrayList
				AL_searchResults.add(r1);
				counter++;
			}//End of for
			
			
			
			String tf = AL_searchResults.toString()
					.replace(",", "")
					.replace("[", "")
					.replace("]", "")
					.replace(" ", "");

			
			outPut1.setText(tf);
			
			//Clears the ArrayList of Search Results
			AL_searchResults.clear();
			GUI_ArrayList_T_1.clear();
			GUI_ArrayList_U.clear();
			
			//Set counter1 to zero
			counter1 = 0;
		}	
		
		
	}

	//Getters and Setters
	public JTextField getUserInput1() {
		return userInput1;
	}

	public void setUserInput1(JTextField userInput1) {
		this.userInput1 = userInput1;
	}

	public ArrayList<String> getGUI_ArrayList() {
		return GUI_ArrayList_U;
	}

	public void setGUI_ArrayList(ArrayList<String> gUI_ArrayList) {
		GUI_ArrayList_U = gUI_ArrayList;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	
	public int getCounter1() {
		return counter1;
	}

	public void setCounter1(int counter1) {
		this.counter1 = counter1;
	}
}