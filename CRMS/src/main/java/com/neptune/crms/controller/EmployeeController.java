package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.crms.business.service.EmployeeService;
import com.neptune.crms.dto.EmployeeDTO;
import com.neptune.crms.enums.EmployeeStatus;
import com.neptune.crms.indto.EmployeeInDTO;

@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getEmployees(@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String firstName, @RequestParam(required = false) EmployeeStatus status) {
		return employeeService.getEmployees(lastName, firstName, status);
	}

	@PostMapping
	public void add(@RequestBody EmployeeInDTO employee) {
		System.out.println("Post mapping add employee called");
		employeeService.save(employee);
	}

	@PatchMapping("activate/{id}")
	public EmployeeDTO activateEmployee(@PathVariable int id) {
		return employeeService.activateEmployee(id);
	}

	@PatchMapping("deactivate/{id}")
	public EmployeeDTO deactivateEmployee(@PathVariable int id) {
		return employeeService.deactivateEmployee(id);
	}

}
