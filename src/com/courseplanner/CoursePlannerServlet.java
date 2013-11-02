package com.courseplanner;

import java.io.IOException;

import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@SuppressWarnings("serial")
public class CoursePlannerServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		System.out.println("Before User");
		
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();

		System.out.println("After User");
		
        CollegeInfo test = new CollegeInfo();
        test.insertCollegeInfo();

        if (user != null) {
            resp.setContentType("text/html");
            resp.getWriter().println("Hello, " + user.getNickname());
            resp.getWriter().println("<a href='" + userService.createLogoutURL("/") + "'>Log Out</a>");
            resp.getWriter().println("Testing if data is pushing");
        } else {
            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }

	}
}
