package com.example.start.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.start.exception.ResourceNotFoundException;
import com.example.start.model.employee;
import com.example.start.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8083")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@Autowired
    private EmployeeRepository eRepo;
	
	@GetMapping("/employees")
    public List < employee > getAllEmployees() {
        return eRepo.findAll();
    }
	
	@GetMapping("/employees/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable Integer id) throws ResourceNotFoundException {
    	employee employee = null;
		try
		{
			employee =  eRepo.findById(id).orElse(null);
		}
		
		catch(ResourceNotFoundException e)
		{
			throw new ResourceNotFoundException("Employee not exist with id :" + id);
		}
        
           
        return ResponseEntity.ok(employee);
    }
	
	
	@PutMapping("/employees/{id}")
    public ResponseEntity < employee > updateEmployee(@PathVariable Integer id, @RequestBody employee employeeDetails) throws ResourceNotFoundException {
		employee employee = null;
		try
		{
			employee =  eRepo.findById(id).orElse(null);
		}
        catch(ResourceNotFoundException e)
		{
        	throw new ResourceNotFoundException("Employee not exist with id :" + id);
		}
        employee.setEmployeeName(employee.getEmployeeName());
        employee.setEmployeeEmail(employee.getEmployeeEmail());
        employee.setEmployeeContactNumber(employee.getEmployeeContactNumber());
        employee.setEmployeeAddress(employee.getEmployeeAddress());
        employee updatedEmployee = eRepo.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }
	
	@DeleteMapping("/employees/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteEmployee(@PathVariable Integer id) throws ResourceNotFoundException {
		employee employee = null;
		try
		{
			employee =  eRepo.findById(id).orElse(null);
			
		}
        catch(ResourceNotFoundException e)
		{
        	throw new ResourceNotFoundException("Employee not exist with id :" + id);
		}

        eRepo.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
	
	
	

}
