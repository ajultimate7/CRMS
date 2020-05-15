package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.entity.EmployeeEntity;

@Controller
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/{id}")
	public EmployeeEntity get(@PathVariable int id) {
		System.out.println("Get Employee called");
		return employeeService.getEmployee(id);
	}

	@RequestMapping(value = "/getAll", produces = "application/json", method = RequestMethod.GET)
	public List<EmployeeEntity> getAll() {
		System.out.println("Got all employees");
		return employeeService.getAllEmployees();
	}

	@PostMapping("/")
	public void addEmployee(@RequestBody EmployeeEntity employee) {
		employeeService.addEmployee(employee);
		System.out.println("Post Employee called");
	}

}
