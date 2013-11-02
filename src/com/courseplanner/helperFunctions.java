package com.courseplanner;

import com.google.appengine.api.datastore.Entity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class helperFunctions {
	
	public String entityToJson (Entity a ) {
		Gson gson = new Gson();
		String json = gson.toJson(a);  
		
		if (json == null)
		  System.out.println("There was an error converting the entity to Json");
		
		return json;		
	}

	public static Entity jsonToEntity (JsonObject a) {
		Entity b = new Entity("Used to get type");
		Gson gson = new Gson();
		Entity entity = gson.fromJson(a, b.getClass());  
		
		if (entity == null)
		  System.out.println("There was an error converting the entity to Json");
		
		return entity;		
	}
}