package com.project.FoodWasteManagementProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.FoodWasteManagementProject.model.NGOs;

@Repository
public interface INgosRepository extends JpaRepository<NGOs, Integer>{

	@Query(value = "select * from tbl_ngos where ngo_city= :cityName and  status_id = 1 " , nativeQuery = true)
	List<NGOs> findByCity(String cityName);

	@Query(value = "select * from tbl_ngos where ngo_pincode= :pincode and  status_id = 1 " , nativeQuery = true)
	List<NGOs> findByPinCode(Integer pincode);

}
