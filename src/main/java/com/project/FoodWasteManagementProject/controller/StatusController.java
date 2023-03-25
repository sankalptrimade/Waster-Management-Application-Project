package com.project.FoodWasteManagementProject.controller;

import com.project.FoodWasteManagementProject.model.Status;
import com.project.FoodWasteManagementProject.service.StatusService;
import com.project.FoodWasteManagementProject.utils.StatusUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/status")
public class StatusController {
    @Autowired
    StatusService statusService;
    @Autowired
    StatusUtility statusUtility;
    @PostMapping(value = "create-status")
    public ResponseEntity<String> createStatus(@RequestBody String statusData){
        Status status = statusUtility.setStatus(statusData);
        int statusId = statusService.createStatus(status);
        return new ResponseEntity<String>("Status Created with id: "+statusId, HttpStatus.CREATED);
    }
}
