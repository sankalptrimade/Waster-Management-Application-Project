package com.project.FoodWasteManagementProject.repository;

import com.project.FoodWasteManagementProject.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
