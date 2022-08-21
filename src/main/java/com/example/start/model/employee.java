package com.example.start.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Employee")
public class employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EmployeeId;
	
	@Column(name = "EmployeeName")
	private String employeeName;
	
	@Column(name = "EmployeeEmail")
	private String employeeEmail;
	
	@Column(name="EmployeeContactNumber")
	private long employeeContactNumber;
	
	@Column(name ="EmployeeAddress")
	private String employeeAddress;
	

}
