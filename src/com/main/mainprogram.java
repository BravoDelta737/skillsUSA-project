package com.main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class mainprogram {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner kbReader = new Scanner(System.in);
		String firstName;
		String lastName;
		String address;
		String city;
		String state;
		String zip;
		String email;
		boolean incorrectInfo = true;
		
		while(incorrectInfo){
			
			firstName = getUserInfo(kbReader,"first name");
			lastName = getUserInfo(kbReader,"last name");
			address = getUserInfo(kbReader,"address");
			city = getUserInfo(kbReader,"city");
			state = getUserInfo(kbReader,"state");
			zip = getUserInfo(kbReader,"zip code");
			email = getUserInfo(kbReader,"email");
			
			System.out.println(firstName + " " + lastName);
			System.out.println(address);
			System.out.println(city + " " + state + " " + zip);
			System.out.println(email);
			System.out.println("Is this information correct?");
			String response = kbReader.nextLine();
			response.toLowerCase();
			
			switch(response){
			case "yes":
				incorrectInfo = false;
				
				createFile(lastName);
				String writeFile = lastName + ".txt";
				PrintWriter writerFile = new PrintWriter(writeFile);
				writeToFile(writerFile,firstName + " " + lastName,"write");
				writeToFile(writerFile,address,"write");
				writeToFile(writerFile, city + ", " + state + " " + zip,"write");
				writeToFile(writerFile, email,"write");
				writeToFile(writerFile, null,"close");
			break;
			
			case "no":
				System.out.println("Please enter the info again");
			break;
			}
		}
		
	}
	public static String getUserInfo(Scanner x, String infoName){
		System.out.println("Please enter " + infoName);
		return x.nextLine();
	}
	public static void createFile (String x) throws FileNotFoundException{
		Formatter fileFormat = new Formatter(x + ".txt");
		
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