package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.global.hr.entity.Employee;
import com.global.hr.repository.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo; // Autowire the EmployeeRepo dependency

	public long count() {
		return employeeRepo.count(); // Use the count() method from EmployeeRepo to get the count of employees
	}

	public Employee findById(Long id) {
		return employeeRepo.findById(id).get(); // Use the findById() method from EmployeeRepo to find an employee by ID
	}

	public Iterable<Employee> findAll() {
		return employeeRepo.findAll(); // Use the findAll() method from EmployeeRepo to get all employees
	}

	public Employee insert(Employee emp) {
		return employeeRepo.save(emp); // Use the save() method from EmployeeRepo to insert a new employee
	}

	public Employee update(Employee emp) {
		return employeeRepo.save(emp); // Use the save() method from EmployeeRepo to update an existing employee
	}

	public List<Employee> findByName(String name) {
		return employeeRepo.findByName(name); // Use the findByName() method from EmployeeRepo to find employees by name
	}

	public List<Employee> findByEmployeeId(String name) {
		return employeeRepo.findByEmployeeId(name); // Use the findByEmployeeId() method from EmployeeRepo to find employees by employee ID
	}

	public List<Employee> findByNameAndSalary(@Param("empName") String name, @Param("empSalary") Double salary) {
		return employeeRepo.findByNameAndSalary(name, salary); // Use the findByNameAndSalary() method from EmployeeRepo to find employees by name and salary
	}

	public void deleteById(Long id) {
		employeeRepo.deleteById(id); // Use the deleteById() method from EmployeeRepo to delete an employee by ID
	}

	public int updateSalary(Double salary, Long id) {
		return employeeRepo.updateSalary(salary, id); // Use the updateSalary() method from EmployeeRepo to update the salary of an employee by ID
	}

}
