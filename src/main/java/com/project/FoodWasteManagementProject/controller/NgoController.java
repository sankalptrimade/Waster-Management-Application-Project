package com.project.FoodWasteManagementProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.FoodWasteManagementProject.service.NgosService;

@RestController
@RequestMapping("api/v1/ngo")
public class NgoController {
		
	@Autowired
	NgosService ngosService;
	
	@PostMapping("/addNgo")
	public ResponseEntity<String> addNgo(@RequestBody String ngo){
		ResponseEntity<String> msgEntity=ngosService.addNgo(ngo);
		return msgEntity;
	}
	
	@PutMapping("/updateNgo/{ngoid}")
	public ResponseEntity<String> updateDetail(@PathVariable int ngoid, @RequestBody String ngo){
		ResponseEntity<String> msgEntity=ngosService.updateNgo(ngoid,ngo);
		return msgEntity;
	}
	
	@DeleteMapping("/deleteMapping/{ngoid}")
	public ResponseEntity<String> deleteNgo(@PathVariable int ngoid){
		ResponseEntity<String> msgEntity=ngosService.deleteNgo(ngoid);
		return msgEntity;
	}
	
	
	
}
