package src.loganalyser;

import java.io.IOException;
import java.util.Scanner;

/*
 * 6. Log Analyzer for Large Files
	✅ Concepts Used: File Handling, Java Streams, Multithreading
	💡 Description:
	
	Create a tool that parses large log files and extracts relevant information.
	Implement multi-threading for faster processing.
	Allow users to filter logs based on timestamps, severity levels, etc.
 */
public class Main {
	
	private static final String Input_File_Name = "inputFile.txt";
	private static final String Output_File_Name = "outputFile.txt";
	
	/*This is content of input file
	 * 
	 *  2025-03-14 10:30:12 INFO User logged in successfully
	 *	2025-03-14 10:31:45 ERROR Database connection failed
	 *	2025-03-14 10:33:00 DEBUG Checking user session
	 * 
	 */

	public static void main(String[] args) throws IOException {
		
		LogAnalyser ans = new LogAnalyser();
	
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Keyword:");
		String keyword = sc.nextLine();
		System.out.println("Enter loggerType");
		String loggerType = sc.next();
		
		ans.processLogs(Input_File_Name, keyword, loggerType, Output_File_Name);
		
		
		
	}
}
