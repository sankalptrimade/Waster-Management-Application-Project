package com.project.FoodWasteManagementProject.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.FoodWasteManagementProject.model.NGOs;
import com.project.FoodWasteManagementProject.repository.INgosRepository;
import com.project.FoodWasteManagementProject.utils.SetNgos;



@Service
public class NgosService {
	
	@Autowired
	SetNgos setNgos;
	
	@Autowired
	INgosRepository iNgosRepository;

	public ResponseEntity<String> addNgo(String ngo) {
		JSONObject jsObject=new JSONObject(ngo);
		JSONArray isValidArray=setNgos.validateNgo(jsObject);
		if(isValidArray.isEmpty()) {
			NGOs newSetNgos=setNgos.setNgo(ngo);
			iNgosRepository.save(newSetNgos);
			return new ResponseEntity<String>("Account is Created",HttpStatus.CREATED);
			}
		else {
			return new ResponseEntity<String>(isValidArray.toString(),HttpStatus.BAD_REQUEST);
		}
		

	}

	public ResponseEntity<String> updateNgo(int ngoid, String ngo) {
		NGOs oldNgOs=null;
		try {
			oldNgOs=iNgosRepository.findById(ngoid).get();
			JSONObject jsObject=new JSONObject(ngo);
			NGOs newSetNgos=setNgos.setUpdateNgoDetails(oldNgOs,ngo);
			iNgosRepository.save(newSetNgos);
			return new ResponseEntity<String>("Account is Updated",HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("NGO ID is Wrong",HttpStatus.NOT_FOUND);
		}
		
	}

	public ResponseEntity<String> deleteNgo(int ngoid) {
		try {
			iNgosRepository.deleteById(ngoid);
			return new ResponseEntity<String>("Account is Deleted",HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<String>("NGO ID is Wrong",HttpStatus.NOT_FOUND);
		}
	
	}

}
