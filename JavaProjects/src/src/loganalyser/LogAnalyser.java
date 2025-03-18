package src.loganalyser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogAnalyser {
	
	public void processLogs(String inputFile, String keyword, String loggerType, String outputFile) throws IOException {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			
			String line;
			while((line = reader.readLine())!= null) {
				if(matchesCriteria(line, keyword, loggerType)) {
					writer.write(line);//there is issue with fileWriter need to check later
					writer.newLine();
					line.lines().forEach(System.out::println);//printing output stream here
				}
			}
			
			System.out.println("Filtered logs saved to: "+outputFile);		
		} catch (FileNotFoundException e) {
			System.out.println("Exception occured: "+e.getMessage());
		}
		
	}

	private boolean matchesCriteria(String line, String keyword, String loggerType) {
	//	System.out.println("line: "+line +" keyword: "+keyword+" loggerType: "+loggerType);
		
		boolean loggerTypematches = line.contains("All") || line.contains(loggerType);
		boolean keywordMatches = line.isEmpty() || line.contains(keyword);	
		
	//	System.out.println("loggerTypematches: "+loggerTypematches+" keywordMatches: "+keywordMatches);
		return loggerTypematches && keywordMatches;
		
	}

}
