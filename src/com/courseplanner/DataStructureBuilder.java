package com.courseplanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class DataStructureBuilder {
	Map<String,Course> courses = new HashMap<String,Course>();//c1: courseID; c2: ID, Name, Description, Units, Prerequisites, Corequisites;

	public DataStructureBuilder() {
		//datastore instantiation
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		ArrayList<Entity> entities_to_write = new ArrayList<Entity>();
		
		Entity courseTable = new Entity("CourseTable");
		datastore.put(courseTable);
		
		//department major codes
		String[] major_codes = {"ANES","ANBI","ANAR","ANTH","ANSC","BENG","BFNO","BIEB","BICD","BIPN","BIBC","BGGN","BGRD","BGSE","BILD","BIMM","BISP","BIOM",
				"CMM","CENG","CHEM","CHIN","CLIN","CLRE","COGS","COMM","COGR","CSE","ICAM","CGS","CAT","TDCH","TDHD","TDMV","TDTR","DOC","ECON","EDS","ERC",
				"ECE","EMED","ENG","ESYS","ETHN","FPM","FPMU","FILM","GLBH","HLAW","HITO","HIAF","HIEA","HIEU","HILA","HISC","HINE","HIUS","HIGR","HILD",
				"HDP","HMNR","HUM","INTL","IRCO","IRGN","IRLA","JAPN","JUDA","LATI","LHCO","LISL","LIAB","LIDS","LIFR","LIGN","LIGM","LIHL","LIIT","LIPO",
				"LISP","LTAM","LTAF","LTCH","LTCO","LTCS","LTEU","LTFR","LTGM","LTGK","LTIT","LTKO","LTLA","LTRU","LTSP","LITH","LTWR","LTEA","MMW","MBC",
				"MATS","MATH","MAE","MDE","MED","MUIR","MCWP","MUS","NANO","NEU","OPTH","ORTH","PATH","PEDS","PHAR","SPPS","PHIL","PHYS","POLI","PSY","PSYC",
				"RMAS","RAD","MGTF","MGT","RELI","RMED","REV","SDCC","SOMI","SOMC","SIO","SOCG","SOCE","SOCI","SE","SURG","TDAC","TDDE","TDDR","TDGE","TDGR",
				"TDHT","TDPW","TDPR","TWS","TMC","USP","VIS","WARR","WCWP","WES"};
		URL url;
		String line = null;
		String id = null;
		
		for (int i = 0; i < major_codes.length; i++) {
			try {
				url = new URL("http://www.ucsd.edu/catalog/courses/"+major_codes[i]+".html");
				URLConnection con = url.openConnection();
				InputStream is = con.getInputStream();
				System.out.println("Testing URL: "+url);
				
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				StringBuilder stringBuilder = new StringBuilder();
				
				while((line = br.readLine()) != null) {
					Entity course = new Entity("Course",courseTable.getKey());
					//parse course ID
					if(line.contains("<p class=\"course-name\">")) {
						try {
							String title = line.substring(line.indexOf("course-name\">")+13,line.indexOf("</p>"));
							stringBuilder.append("\nTitle: "+title+"\n");
							
							//set strings
							id = title.substring(0,title.indexOf("."));
							id = major_codes[i]+" "+id;
							
							String name = title.substring(title.indexOf(".")+1,title.indexOf(" ("));
							String units = title.substring(title.indexOf("(")+1,title.indexOf(")"));
							
							course.setProperty("ID",id);
							course.setProperty("Name",name);
							course.setProperty("Units",units);
					
						} catch (Exception e) {
						}
					}
					//parse course description
					if(line.contains("<p class=\"course-descriptions\">")) {
						try {
							//set strings
							String description = line.substring(line.indexOf(">")+1,line.indexOf("</p>"));
							if(description.contains("<strong class=")) {
								String prerequisites = description.substring(description.indexOf("</strong>")+9);
								course.setProperty("Prereq",prerequisites);
								description = description.substring(0,description.indexOf("<strong class="));
								stringBuilder.append("Prerequisites: "+courses.get(id+"_prerequisites")+"\n");
							} else {
								course.setProperty("Prereq","Prerequisites: None");
							}
							course.setProperty("Description",description);
						} catch (Exception e) {
						}
						entities_to_write.add(course);
					}
				}
			} catch (MalformedURLException e) {
			} catch (IOException e) {
			}
		}
		datastore.put(entities_to_write);
	}
}