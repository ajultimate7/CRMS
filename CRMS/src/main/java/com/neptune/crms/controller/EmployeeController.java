package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.serviceimpl.EmployeeServiceImpl;
import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.indto.EmployeeInDTO;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping("{id}")
	public EmployeeDTO getById(@PathVariable int id) {
		System.out.println("Get Employee called");
		return employeeService.getEmployee(id);
	}

	@GetMapping
	public List<EmployeeDTO> getAll() {
		return employeeService.getAllEmployees();
	}

	@PostMapping
	public void add(@RequestBody EmployeeInDTO employee) {
		System.out.println("Post mapping add employee called");
		employeeService.save(employee);
	}

	@GetMapping("?lName{lName}")
	public List<EmployeeDTO> getByLastName(@PathVariable String lName) {
		System.out.println("Get by last name Employee called");
		return employeeService.getByLastName(lName);
	}

	@GetMapping("?fName/{fName}")
	public List<EmployeeDTO> getByFirstName(@PathVariable String fName) {
		System.out.println("Get by first name Employee called");
		return employeeService.getByLastName(fName);
	}

	@DeleteMapping
	public void deleteById(int id) {
		employeeService.deleteById(id);
	}

}
