package com.courseplanner;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MajorDatastoreBuilderServlet extends HttpServlet {
	public static String majorTableJsonPath = "/WEB-INF/Major_Table.JSON";
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		try {
			System.out.println("Attempting to build major table...");
			resp.getWriter().print("Attempting to build major table...");
			ServletContext context = getServletContext();
			InputStream is = context.getResourceAsStream( majorTableJsonPath);
			
	        String jsonString = new Scanner( is).useDelimiter("\\A").next();
			
			MajorDatastoreBuilder.jsonToDatastore( jsonString);
			System.out.println("Major Table built!");
			resp.getWriter().print("\nMajor Table built!");
		} catch ( Exception e) {
			System.out.println("Uh-oh...");
			System.out.println( e.toString());
		}
		
		
		
	}
}
