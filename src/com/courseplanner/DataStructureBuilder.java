package com.courseplanner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class DataStructureBuilder {
	
	String[] data;
	Map<String,String> courses = new HashMap<String,String>();//c1: courseID; c2: ID, Name, Description, Units, Prerequisites, Corequisites;

	public DataStructureBuilder() {
		String[] major_codes = {"ANTH","BENG","BIOL","BIOM","CMM","CHEM","CHIN","CLRE","CLPH",
				"CLIN","COGS","COMM","CSE","ICAM","CGS","CAT","DOC","ECON","EDS","ERC","ECE",
				"EMED","ESYS","ETHN","FPM","FPMU","FILM","GLBH","HLAW","HIST","HDP","HMNR",
				"HUM","INTL","IRPS","JAPN","JUDA","LATI","LHCO","LING","LIT","MMW","MBC","MATS",
				"MATH","MAE","MED","MUIR","MCWP","MUS","NENG","NEU","OPTH","ORTH","PATH","PEDS",
				"PHAR","PHIL","PHYS","POLI","PSY","PSYC","RMAS","RAD","RSM","RELI","RMED",
				"REV","SDCC","SOMI","SOE","SOMC","SIO","SOC","SE","SURG","THEA","TWS","TMC",
				"USP","VIS","WARR"};
		data = new String[major_codes.length];
		URL url;
		String line = null;
		String id = null;
		//PrintWriter output = new PrintWriter("C:\\Users\\Ian\\workspace\\CoursePlanner.txt");
		
		for (int i = 0; i < major_codes.length; i++) {
			try {
				url = new URL("http://www.ucsd.edu/catalog/courses/"+major_codes[i]+".html");
				URLConnection con = url.openConnection();
				InputStream is = con.getInputStream();
				System.out.println("Testing URL: "+url);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuilder stringBuilder = new StringBuilder();
				
				while((line = br.readLine()) != null) {
					
					//stringBuilder.append(line);
					
					//parse course ID
					if(line.contains("<p class=\"course-name\">")) {
						try {
							String title = line.substring(line.indexOf("course-name\">")+13,line.indexOf("</p>"));
							stringBuilder.append("\nTitle: "+title+"\n");
							//System.out.println("Title: "+title);
							
							//set strings
							id = title.substring(0,title.indexOf("."));
							id = major_codes[i]+" "+id;
							//String[] id_split = title.split(".");
							//id = id_split[0];
							String name = title.substring(title.indexOf(".")+1,title.indexOf(" ("));
							String units = title.substring(title.indexOf("(")+1,title.indexOf(")"));
							
							//assign hashmap
							courses.put(id+"_id",id);
							courses.put(id+"_name",name);
							courses.put(id+"_units",units);
							
							//print course information
							stringBuilder.append("Course ID: "+courses.get(id+"_id")+"\n");
							stringBuilder.append("Course Name: "+courses.get(id+"_name")+"\n");
							stringBuilder.append("Number of Units: "+courses.get(id+"_units")+"\n");
							//System.out.println("Course ID: "+courses.get(id+"_id"));
							//System.out.println("Course Name: "+courses.get(id+"_name"));
							//System.out.println("Number of Units: "+courses.get(id+"_units"));
					
						} catch (Exception e) {
							//stringBuilder.append("ERROR PARSING TITLE @ i = "+i+"\n");
							//System.out.println("Error parsing title at i = "+i);
							//e.printStackTrace();
						}
					}
					//parse course description
					if(line.contains("<p class=\"course-descriptions\">")) {
						try {
							//set strings
							String description = line.substring(line.indexOf(">")+1,line.indexOf("</p>"));
							if(description.contains("<strong class=")) {
								String prerequisites = description.substring(description.indexOf("</strong>")+9);
								courses.put(courses.get(id+"_id")+"_prerequisites",prerequisites);
								description = description.substring(0,description.indexOf("<strong class="));
								stringBuilder.append("Prerequisites: "+courses.get(id+"_prerequisites")+"\n");
							}
							
							//assign hashmap
							courses.put(courses.get(id+"_id")+"_description",description);
							
							//print course information
							stringBuilder.append("Description: "+courses.get(id+"_description")+"\n");
							//System.out.println("Description: "+courses.get(id+"_description"));
						} catch (Exception e) {
							//stringBuilder.append("ERROR PARSING DESCRIPTION @ i = "+i+"\n");
							//System.out.println("Error parsing description at i = "+i);
							//e.printStackTrace();
						}

						//System.out.println();
					}
				}
				stringBuilder.append(line+"\n");
				data[i] = stringBuilder.toString();
				//output.println(data[i]);
				System.out.println(data[i]);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
		//System.out.println(courses.toString());
		//output.close();
	}
}