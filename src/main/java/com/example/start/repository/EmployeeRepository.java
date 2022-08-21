package com.example.start.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.start.model.employee;

@Repository
public interface EmployeeRepository extends JpaRepository<employee,Integer> {
	

}
