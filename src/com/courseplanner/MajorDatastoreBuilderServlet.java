package com.courseplanner;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MajorDatastoreBuilderServlet extends HttpServlet {
	public static String majorTableJsonPath = "/majorTable.json";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		try {
			System.out.println("Attempting to build major table...");
			
			FileInputStream fis = new FileInputStream( majorTableJsonPath);
	        String jsonString = new Scanner(fis,"UTF-8").useDelimiter("\\A").next();
			
			MajorDatastoreBuilder.jsonToDatastore( jsonString);
			System.out.println("Major Table built!");
		} catch ( Exception e) {
			System.out.println( e.getMessage());
		}
		
	}
}
