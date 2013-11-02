package com.courseplanner;
import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
@SuppressWarnings("serial")

public class CollegeDatastoreBuilderServlet extends HttpServlet {

		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws IOException {
			DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		    Entity college = new Entity("CollegeTable");
		    datastore.put(college);
	        CollegeDatastoreBuilder test = new CollegeDatastoreBuilder();
	        
	        test.insertMuirInfo(datastore, college.getKey());
	        test.insertMarshallInfo(datastore, college.getKey());
	        test.insertERCInfo(datastore, college.getKey());
	        test.insertRevelleInfo(datastore, college.getKey());
	        test.insertSixthInfo(datastore, college.getKey());
	        test.insertWarrenInfo(datastore, college.getKey());
	        
			UserService userService = UserServiceFactory.getUserService();
	        User user = userService.getCurrentUser();

	        if (user != null) {
	            resp.setContentType("text/html");
	            resp.getWriter().println("Hello, " + user.getNickname());
	            resp.getWriter().println("<a href='" + userService.createLogoutURL("/") + "'>Log Out</a>");
	        } else {
	            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
	        }
		}
}
