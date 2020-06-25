package com.neptune.crms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@CrossOrigin(origins = "https://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<EmployeeDTO> getEmployees(@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String firstName, @RequestParam(required = false) EmployeeStatus status,
			@RequestParam(required = false) Integer id) {
		System.out.println("Get Employee called");
		return employeeService.getEmployees(lastName, firstName, status, id);
	}

	@GetMapping("/all")
	public List<EmployeeDTO> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("id/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable(value = "id") int id) {
		return employeeService.getById(id);
	}

	@PostMapping
	public String add(@RequestBody EmployeeInDTO employee) {
		System.out.println("Post mapping add employee called");
		employeeService.save(employee);
		return "Employee saved successfully";
	}

	@PatchMapping
	public EmployeeDTO toggleStatusOfEmployee(@RequestBody Integer id) {
		System.out.println("");
		return employeeService.toggleStatusOfEmployee(id);
	}

	@PutMapping("{id}")
	public EmployeeDTO editEmployee(@PathVariable int id, @RequestBody EmployeeInDTO employee) {
		System.out.println("Inside put method");
		return employeeService.updateEmployee(employee, id);
	}

}
