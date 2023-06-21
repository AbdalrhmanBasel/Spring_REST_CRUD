package com.global.hr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET, path = "/count")
	public long countEmp() {
		// Endpoint to count the number of employees
		return employeeService.count();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader("accept-language") String acceptLanguage) {
		// Endpoint to find an employee by ID
		log.info(" Accept Language is " + acceptLanguage);
		return ResponseEntity.ok(employeeService.findById(id));
	}

	@GetMapping("/all")
	public Iterable<Employee> findAll() {
		// Endpoint to retrieve all employees
		return employeeService.findAll();
	}

	@PostMapping("/create")
	public Employee addEmp(@RequestBody Employee emp) {
		// Endpoint to add a new employee
		return employeeService.insert(emp);
	}

	@PutMapping("/update")
	public Employee updateEmp(@RequestBody Employee emp) {
		// Endpoint to update an existing employee
		return employeeService.update(emp);
	}

	@GetMapping("/filter")
	public List<Employee> filter(@RequestParam String name, @RequestParam Double salary) {
		// Endpoint to filter employees by name and salary
		return employeeService.findByNameAndSalary(name, salary);
	}

	@DeleteMapping("/{empId}")
	public void deleteEmp(@PathVariable(name = "empId") Long id) {
		// Endpoint to delete an employee by ID
		employeeService.deleteById(id);
	}

	@PutMapping("/salary")
	public int updateSalary(@RequestParam Double salary, @RequestParam Long id) {
		// Endpoint to update the salary of an employee
		return employeeService.updateSalary(salary, id);
	}



}
