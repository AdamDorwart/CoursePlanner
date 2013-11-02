package com.courseplanner;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@SuppressWarnings("serial")
public class CurrentUserServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException
	{
		UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        Gson gson = new Gson();
        resp.setContentType("application/json");  
        
        JsonElement respJson;
        
        if(user == null)
        {
        	respJson = new JsonObject();
        	respJson.getAsJsonObject().addProperty(
        			"loginUrl", 
        			userService.createLoginURL("/"));
        }
        else
        {   
        	respJson = gson.toJsonTree(user);
        	respJson.getAsJsonObject().addProperty(
        			"logoutUrl", 
        			userService.createLogoutURL(
        					userService.createLoginURL("/")));
        }
        
        resp.getWriter().print(gson.toJson(respJson));
	}
}
