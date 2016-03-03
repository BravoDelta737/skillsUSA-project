package com.main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class mainprogram {
	public static void main(String[] args) throws FileNotFoundException{
		//Creates an instance of the Scanner class to take keyboard input
		Scanner kbReader = new Scanner(System.in);
		//Creates vars for the contact info
		String firstName;
		String lastName;
		String address;
		String city;
		String state;
		String zip;
		String email;
		//This bool makes the collect info loop, loop until the info correct
		boolean incorrectInfo = true;
		
		while(incorrectInfo){
			
			//Gathers all the info from the user
			firstName = getUserInfo(kbReader,"first name");
			lastName = getUserInfo(kbReader,"last name");
			address = getUserInfo(kbReader,"address");
			city = getUserInfo(kbReader,"city");
			state = getUserInfo(kbReader,"state");
			zip = getUserInfo(kbReader,"zip code");
			email = getUserInfo(kbReader,"email");
			
			//Prints the info for the user to check
			System.out.println(firstName + " " + lastName);
			System.out.println(address);
			System.out.println(city + " " + state + " " + zip);
			System.out.println(email);
			System.out.println("Is this information correct?");
			String response = kbReader.nextLine();
			response.toLowerCase();
			
			//Asks the user if the information is correct
			switch(response){
			
			case "yes":
				//Setting this to false breaks the loop
				incorrectInfo = false;
				//Creates the file <userlastname>.txt
				createFile(lastName);
				//Makes a String with the file name to pass to the write method
				String writeFile = lastName + ".txt";
				//Creates an instance of the file writer
				PrintWriter writerFile = new PrintWriter(writeFile);
				
				//Writes each element to the file
				writeToFile(writerFile,firstName + " " + lastName,"write");
				writeToFile(writerFile,address,"write");
				writeToFile(writerFile, city + ", " + state + " " + zip,"write");
				writeToFile(writerFile, email,"write");
				writeToFile(writerFile, null,"close");
				
				//Tells the user that everything worked and the program has ended
				System.out.println("Elements have been written to the file. Goodbye.");
			break;
			
			case "no":
				System.out.println("Please enter the info again");
			break;
			}
		}
		
	}
	//Method collects user info
	public static String getUserInfo(Scanner x, String infoName){
		System.out.println("Please enter " + infoName);
		return x.nextLine();
	}
	//Creates the file
	public static void createFile (String x) throws FileNotFoundException{
		Formatter fileFormat = new Formatter(x + ".txt");
		System.out.println("File has been created");
	}
	
	public static void writeToFile (PrintWriter file, String toWrite,String command) throws FileNotFoundException{
		switch (command){
		case "write":
		
		file.println(toWrite);
		break;
		case "close":
			file.close();
			break;
		}
	}
	
}