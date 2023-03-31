package com.project.FoodWasteManagementProject.utils;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.project.FoodWasteManagementProject.model.NGOs;

@Component
public class SetNgos {

	public JSONArray validateNgo(JSONObject jsObject) {
	  JSONArray jsonArray=new JSONArray();
	  if(!jsObject.has("ngoName")) {
		 jsonArray.put("Username is Not present"); 
	  }
	  if(!jsObject.has("password")) {
			 jsonArray.put("password is Not present"); 
		  }
	  if(!jsObject.has("type")) {
			 jsonArray.put("type is Not present"); 
		  }
	  if(!jsObject.has("ngoFullname")) {
			 jsonArray.put("ngoFullname is Not present"); 
		  }
	  if(!jsObject.has("address")) {
			 jsonArray.put("address is Not present"); 
		  }
	  if(!jsObject.has("city")) {
			 jsonArray.put("city is Not present"); 
		  }
	  if(!jsObject.has("pinCode")) {
			 jsonArray.put("pinCode is Not present"); 
		  }
	  
	  
		return jsonArray;
	}

	

	public NGOs setNgo(String ngo) {
		JSONObject jsonObject=new JSONObject(ngo);
		NGOs newNgos=new NGOs();
		newNgos.setNgoName(jsonObject.getString("ngoName"));
		newNgos.setPassword(jsonObject.getString("password"));
		newNgos.setNgoFullname(jsonObject.getString("ngoFullname"));
		newNgos.setType(jsonObject.getString("type"));
		newNgos.setAddress(jsonObject.getString("address"));
		newNgos.setCity(jsonObject.getString("city"));
		newNgos.setPinCode(jsonObject.getInt("pinCode"));
		return newNgos;
	}
	



	public NGOs setUpdateNgoDetails(NGOs oldNgOs,String ngo) {
		
		JSONObject jsonObject=new JSONObject(ngo);
	 	
		 if(jsonObject.has("ngoName")) {
			 oldNgOs.setNgoName(jsonObject.getString("ngoName"));
		  }
		  if(jsonObject.has("password")) {
				oldNgOs.setPassword(jsonObject.getString("password"));
			  }
		  if(jsonObject.has("type")) {
			    oldNgOs.setType(jsonObject.getString("type"));
			  }
		  if(jsonObject.has("ngoFullname")) {
				oldNgOs.setNgoFullname(jsonObject.getString("ngoFullname"));
			  }
		  if(jsonObject.has("address")) {
				oldNgOs.setAddress(jsonObject.getString("address"));
			  }
		  if(jsonObject.has("city")) {
				 oldNgOs.setCity(jsonObject.getString("city"));
			  }
		  if(jsonObject.has("pinCode")) {
				oldNgOs.setPinCode(jsonObject.getInt("pinCode"));
			  }
		return oldNgOs;
	}

}
