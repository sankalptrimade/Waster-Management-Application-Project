package com.project.FoodWasteManagementProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.FoodWasteManagementProject.model.User;

public interface IUserRepository extends JpaRepository<User,Integer>{

	User findByUsername(String usenameString);

}
