package com.project.FoodWasteManagementProject.utils;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.FoodWasteManagementProject.model.NGOs;
import com.project.FoodWasteManagementProject.model.Status;
import com.project.FoodWasteManagementProject.repository.StatusRepository;

@Component
public class SetNgos {

	@Autowired
	StatusRepository statusRepository;
	
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
	  if(!jsObject.has("phoneNumber")) {
		  jsonArray.put("phoneNumber is Not present"); 
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
		newNgos.setPhoneNumber(jsonObject.getString("phoneNumber"));
		Status status=statusRepository.findById(1).get();
		newNgos.setStatusid(status);
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
	
	public JSONObject getNgos(NGOs ngOs) {
		
		 JSONObject ngoJsonObject=new JSONObject();
		 ngoJsonObject.put("NGO Full Name",ngOs.getNgoFullname());
		 ngoJsonObject.put("City",ngOs.getCity());
		 ngoJsonObject.put("Address",ngOs.getAddress());
		 ngoJsonObject.put("Pincode",ngOs.getPinCode());
		 ngoJsonObject.put("Type",ngOs.getType());
		 ngoJsonObject.put("phoneNumber",ngOs.getPhoneNumber());
		
		 
		 return ngoJsonObject;
	}

}
