package com.project.FoodWasteManagementProject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="tbl_userId")
	private Integer userId;
	@Column(name ="tbl_username")
	private String username;
	@Column(name ="tbl_firstname")
	private String firstName;
	@Column(name ="tbl_lastname")
	private String lastName;
	@Column(name ="tbl_city")
	private String city;
	@Column(name ="tbl_number")
	private String number;
	
	@ManyToOne
	@JoinColumn(name = "statusId")
	private Status statusid;
	
}
