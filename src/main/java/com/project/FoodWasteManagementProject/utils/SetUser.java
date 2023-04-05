package com.project.FoodWasteManagementProject.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.FoodWasteManagementProject.model.Status;
import com.project.FoodWasteManagementProject.model.User;
import com.project.FoodWasteManagementProject.repository.IUserRepository;
import com.project.FoodWasteManagementProject.repository.StatusRepository;


@Component
public class SetUser {
	
	@Autowired
	IUserRepository iUserRepository;
	
	@Autowired
	StatusRepository statusRepository;

	public JSONArray validateUser(JSONObject jsonObject) {
		
		JSONArray jsonArray=new JSONArray();
		
		if(jsonObject.has("username")) {
			String usenameString=jsonObject.getString("username");
			if(iUserRepository.findByUsername(usenameString)!=null) {
				jsonArray.put("Username Already Present");
			}
		}
		else {
			jsonArray.put("Username Not Present");
		}
		
		if(!jsonObject.has("firstName")) {
			jsonArray.put("firstName Not Present");
		}
		
		if(!jsonObject.has("lastName")) {
			jsonArray.put("lastName Not Present");
		}
		
		if(!jsonObject.has("city")) {
			jsonArray.put("city Not Present");
		}
		
		if(!jsonObject.has("number")) {
			jsonArray.put("number Not Present");
		}
		
		return jsonArray;
	}

	public User setUser(JSONObject jsonObject) {
		User user =new User();
		
		user.setUsername(jsonObject.getString("username"));
		user.setFirstName(jsonObject.getString("firstName"));
		user.setLastName(jsonObject.getString("lastName"));
		user.setCity(jsonObject.getString("city"));
		user.setNumber(jsonObject.getString("number"));
		Status status=statusRepository.findById(1).get();
		user.setStatusid(status);
		return user;
	}

}
