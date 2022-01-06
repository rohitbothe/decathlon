package com.decathlon;

import com.decathlon.file.ReadCSV;
import com.decathlon.file.WriteXML;
import com.decathlon.model.DecathlonAthlete;
import com.decathlon.service.DecathlonService;

import java.util.List;
import java.util.Scanner;

/**
 *@author Rohit Bothe 
 */
public class DecathlonMain {

	/** 
     * Main method to run the program. It will ask for Input file and Output file.. 
     */  
	public static void main(String[] args) {
		System.out.println("Please enter input CSV file with full path...");
		Scanner scanner = new Scanner(System.in);
		String inputPath = scanner.nextLine();
		System.out.println("You have entered input file = " + inputPath);

		System.out.println("\nPlease enter output XML file with full path...");
		String output = scanner.nextLine();
		System.out.println("You have entered output file = " + output);

		List<DecathlonAthlete> finalList;
		ReadCSV readCSV = new ReadCSV();
		try {
			if(!inputPath.trim().equals("") && !output.trim().equals("") ) {
				List<String> rowsFromCSV = readCSV.readCSVFile(inputPath); // "/users/rohit/Downloads/DecathlonTestAssignment/results.csv");
				DecathlonService service = new DecathlonService();
				finalList = service.getDecathlonAthleteList(rowsFromCSV);

				WriteXML writeXML = new WriteXML();
				writeXML.createXML(finalList, output);

				System.out.println("\nOutput file " + output + " successfully created.");
			}else {
				System.out.println("\nInvalid input and output files and path.");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
