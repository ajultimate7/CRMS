package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.entity.EmployeeEntity;
import com.neptune.crms.indto.EmployeeInDTO;
import com.neptune.crms.mapper.EmployeeMapper;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private EmployeeMapper mapper;

	@GetMapping("/employee/id/{id}")
	public EmployeeEntity getById(@PathVariable int id) {
		System.out.println("Get Employee called");
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/employee", produces = "application/json", method = RequestMethod.GET)
	public List<EmployeeEntity> getAll() {
		System.out.println("Got all employees");
		return employeeService.getAllEmployees();
	}

	@PostMapping("/employee")
	public void addEmployee(@RequestBody EmployeeInDTO employee) {
		System.out.println("Post mapping add employee called");
		employeeService.save(employee);
	}

	@GetMapping("/employee/lName/{lName}")
	public List<EmployeeEntity> getByLastName(@PathVariable String lName) {
		System.out.println("Get by last name Employee called");
		return employeeService.getByLastName(lName);
	}

}
