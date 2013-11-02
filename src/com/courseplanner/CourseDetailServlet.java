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
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.google.appengine.api.datastore.PropertyProjection;
import com.google.appengine.api.datastore.RawValue;


public class CourseDetailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 4474482550713758708L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException
	{
		Gson gson = new Gson();
		resp.setContentType("application/json");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		
		Filter courseIDMatch = new FilterPredicate( "ID", FilterOperator.EQUAL, req.getParameter( "course_id"));
			
		Query courseTableQ = new Query("CourseTable");
		Entity courseTable = datastore.prepare( courseTableQ).asSingleEntity();
				
		Query q = new Query("Course", courseTable.getKey()).setFilter( courseIDMatch);
		
		q.addProjection( new PropertyProjection("ID", String.class));
		q.addProjection( new PropertyProjection("Name", String.class));
		q.addProjection( new PropertyProjection("Description", String.class));
		q.addProjection( new PropertyProjection("Prereq", String.class));
		q.addProjection( new PropertyProjection("Units", String.class));
		
		PreparedQuery pq = datastore.prepare(q);
		Entity result = pq.asSingleEntity();
		
		JsonObject courseInfo = new JsonObject();
		try {
			courseInfo.addProperty("course_id", (String)result.getProperty("ID") );
			courseInfo.addProperty("name", (String)result.getProperty("Name") );
			courseInfo.addProperty("description", (String)result.getProperty("Description") );
			courseInfo.addProperty("prereq", (String)result.getProperty("Prereq") );
			courseInfo.addProperty("units", (String)result.getProperty("Units") );
			courseInfo.addProperty("type", "GE");

		}
		catch (Exception e) {
			System.out.println( e.toString());
		}
		
		resp.getWriter().print(gson.toJson(courseInfo));
	}
}
