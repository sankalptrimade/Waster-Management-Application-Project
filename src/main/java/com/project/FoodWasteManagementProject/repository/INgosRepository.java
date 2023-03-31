package com.project.FoodWasteManagementProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.FoodWasteManagementProject.model.NGOs;

@Repository
public interface INgosRepository extends JpaRepository<NGOs, Integer>{

}
