package com.project.FoodWasteManagementProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_Ngos")
public class NGOs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Ngo_id")
	private Integer id;
	
	@Column(name="Ngo_username")
	private String ngoName;
	
	@Column(name="Ngo_password")
	private String password;
	
	@Column(name="Ngo_type")
	private String type;
	
	@Column(name="Ngo_fullname")
	private String ngoFullname;
	
	@Column(name="Ngo_address")
	private String address;
	
	@Column(name = "ngo_city")
	private String city;
	
	@Column(name="Ngo_pincode")
	@NotNull
	private Integer pinCode;
	
	

}
