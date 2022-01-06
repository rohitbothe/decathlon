package com.decathlon.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
/**
 *@author Rohit Bothe 
 */
public class ReadCSV {
	/** 
     * This method reads CSV file and provide data in the form of list. 
     * @param filePath This takes input as file path.
     * @return List<String> This returns the list of rows from CSV file present at given path.
     */  
	public List<String> readCSVFile(String filePath) {
		List<String> rows = new ArrayList<String>();
		Stream<String> lines = null;
		try {
			lines = Files.lines(Paths.get(filePath));
			lines.forEach(rowFile -> {
				if (rowFile != null && rowFile.trim().length() > 1) {
					rows.add(rowFile);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lines != null) {
				lines.close();
			}
		}
		return rows;
	}
}
