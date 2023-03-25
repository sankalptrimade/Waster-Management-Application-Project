package com.project.FoodWasteManagementProject.service;

import com.project.FoodWasteManagementProject.model.Status;
import com.project.FoodWasteManagementProject.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    StatusRepository statusRepository;

    public int createStatus(Status newStatus) {
        Status status = statusRepository.save(newStatus);
        return status.getStatusId();
    }
}
