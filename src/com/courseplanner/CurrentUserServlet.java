package com.courseplanner;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@SuppressWarnings("serial")
public class CurrentUserServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		Gson gson = new Gson();
		resp.setContentType("application/json");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		JsonElement respJson;

		if (user == null) {
			respJson = new JsonObject();
			respJson.getAsJsonObject().addProperty("loginUrl",userService.createLoginURL("/"));
		} else {
			Key userKey = KeyFactory.createKey("UserTable", user.getUserId());

			Query query = new Query("UserData").addFilter("user",Query.FilterOperator.EQUAL, user).setAncestor(userKey);

			PreparedQuery userQuery = datastore.prepare(query);
			Entity userDataEntity = userQuery.asSingleEntity();
			respJson = gson.toJsonTree(user);

			if (userDataEntity != null) {
				String courseJsonString = (String) userDataEntity.getProperty("courseJsonString");
				respJson.getAsJsonObject().addProperty("courseJsonString",courseJsonString);
			}
			respJson.getAsJsonObject().addProperty("logoutUrl",userService.createLogoutURL(userService.createLoginURL("/")));
		}

		resp.getWriter().print(gson.toJson(respJson));
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Gson gson = new Gson();
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		resp.setContentType("application/json");
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Filter equalsUserFilter = new FilterPredicate("user",FilterOperator.EQUAL, user);

		Key userKey = KeyFactory.createKey("UserTable", user.getUserId());
		Query query = new Query("UserData").setFilter(equalsUserFilter).setAncestor(userKey);

		PreparedQuery userQuery = datastore.prepare(query);
		Entity userDataEntity = userQuery.asSingleEntity();

		if (userDataEntity == null) {
			userDataEntity = new Entity("UserData", userKey);
			userDataEntity.setProperty("user", user);
		}

		StringBuffer jb = new StringBuffer();

		String line = null;
		try {
			BufferedReader reader = req.getReader();
			while ((line = reader.readLine()) != null)
				jb.append(line);
		} catch (Exception e) { /* report an error */
		}

		JsonElement jelem = gson.fromJson(jb.toString(), JsonElement.class);
		String courseJsonString = jelem.getAsJsonObject().get("courseJsonString").getAsString();

		userDataEntity.setProperty("courseJsonString", courseJsonString);
		datastore.put(userDataEntity);
	}
}