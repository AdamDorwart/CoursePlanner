package com.courseplanner;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@SuppressWarnings("serial")
public class CourseInfoServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Gson gson = new Gson();
		resp.setContentType("application/json");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		JsonArray courseInfo = new JsonArray();
		
		Query q = new Query("Course");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			JsonObject newJsonObj = new JsonObject();
			try {
			  newJsonObj.addProperty("course_id", (String)result.getProperty("ID") );
			  newJsonObj.addProperty("name", (String)result.getProperty("Name") );
			  newJsonObj.addProperty("description", (String)result.getProperty("Description") );
			  newJsonObj.addProperty("prereq", (String)result.getProperty("Prereq") );
			  newJsonObj.addProperty("units", (String)result.getProperty("Units") );
			  newJsonObj.addProperty("type", "GE");
		  
			  courseInfo.add(newJsonObj);
			}
			catch (Exception e) {
				System.out.println( e.toString());
			}

			  
			}
		resp.getWriter().print(gson.toJson(courseInfo));
	}
}