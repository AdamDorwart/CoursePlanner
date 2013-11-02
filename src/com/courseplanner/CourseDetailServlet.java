package com.courseplanner;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
                
                Query q = new Query("Course").setFilter( courseIDMatch);
                List<Entity> pq = datastore.prepare(q).asList(FetchOptions.Builder.withLimit(1));
                Entity result = pq.get(0);
                
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