package com.project.FoodWasteManagementProject.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.FoodWasteManagementProject.model.NGOs;
import com.project.FoodWasteManagementProject.model.User;
import com.project.FoodWasteManagementProject.repository.INgosRepository;
import com.project.FoodWasteManagementProject.repository.IUserRepository;
import com.project.FoodWasteManagementProject.utils.SetNgos;
import com.project.FoodWasteManagementProject.utils.SetUser;

@Service
public class UserService {

	@Autowired
	IUserRepository iUserRepository;

	@Autowired
	SetUser setUser;

	@Autowired
	INgosRepository iNgosRepository;

	@Autowired
	SetNgos setNgos;

	public ResponseEntity<String> addUser(String user) {
		JSONObject jsonObject = new JSONObject(user);
		JSONArray jsonArray = setUser.validateUser(jsonObject);
		if (jsonArray.isEmpty()) {
			User user2 = setUser.setUser(jsonObject);
			iUserRepository.save(user2);
			return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(jsonArray.toString(), HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<String> getNgoByCity(String cityName, Integer pincode) {
		List<NGOs> allList = new ArrayList<>();
		JSONObject jsonObject = new JSONObject();
		JSONArray ngos = new JSONArray();
		if (cityName != null) {
			try {

				allList = iNgosRepository.findByCity(cityName);

				for (int i = 0; i < allList.size(); i++) {
					NGOs ngOs = allList.get(i);
					JSONObject ngo = setNgos.getNgos(ngOs);
					ngos.put(ngo);
				}
				jsonObject.put("Ngos", ngos);

				return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);

			} catch (Exception e) {
				return new ResponseEntity<String>("Ngos not Found", HttpStatus.BAD_REQUEST);
			}
		} else {
			try {

				allList = iNgosRepository.findByPinCode(pincode);
				for (int i = 0; i < allList.size(); i++) {
					NGOs ngOs = allList.get(i);
					JSONObject ngo = setNgos.getNgos(ngOs);
					ngos.put(ngo);
				}
				jsonObject.put("Ngos", ngos);

				return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);

			} catch (Exception e) {

				return new ResponseEntity<String>("Ngos not Found", HttpStatus.BAD_REQUEST);
			}
		}
	}

}
