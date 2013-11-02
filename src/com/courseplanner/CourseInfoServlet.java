package com.courseplanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class CourseInfoServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Gson gson = new Gson();
		resp.setContentType("application/json");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		JSONArray courseInfo = new JSONArray();
		Query q = new Query("Course");
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			JSONObject newJsonObj = new JSONObject();
			try {
			  newJsonObj.put("id", (String)result.getProperty("ID") );
			  newJsonObj.put("name", (String)result.getProperty("Name") );
			  newJsonObj.put("description", (String)result.getProperty("Description") );
			  newJsonObj.put("prereq", (String)result.getProperty("Prereq") );
			  newJsonObj.put("units", (String)result.getProperty("Units") );
			courseInfo.put(newJsonObj);
			}
			catch (Exception e) {
				System.out.println("error!");
			}

			  
			}
		resp.getWriter().print(gson.toJson(courseInfo));
	}
}