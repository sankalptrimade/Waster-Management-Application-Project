package com.project.FoodWasteManagementProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodWasteManagementProject.service.UserService;

import io.micrometer.common.lang.Nullable;




@RestController
@RequestMapping("api/v1/user")
public class UserController {
		
	@Autowired
	UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody String user){
		ResponseEntity<String> msgEntity=userService.addUser(user);
		return msgEntity;
	}
	
	@GetMapping("/getNgoByCity")
	public ResponseEntity<String> getNgoByCity(@Nullable @RequestParam String cityName , @Nullable @RequestParam Integer pincode){
		ResponseEntity<String> msgEntity=userService.getNgoByCity(cityName,pincode);
		return msgEntity;
	}
	
	
}
