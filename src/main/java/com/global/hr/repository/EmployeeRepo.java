package com.global.hr.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
import com.global.hr.mapper.EmployeeMapper;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {

	// Find employees by name
	List<Employee> findByName(String name);

	// Find employees by employee ID
	List<Employee> findByEmployeeId(String name);

	// Find employees by name and salary using a custom query with parameterized values
	@Query(value = "SELECT id, name, salary, 'true' as is_create FROM employees WHERE name LIKE :empName AND salary >= :empSalary", rowMapperClass = EmployeeMapper.class)
	List<Employee> findByNameAndSalary(@Param("empName") String name, @Param("empSalary") Double salary);

	// Update employee salary using a custom query with parameterized values
	@Modifying
	@Query(value = "UPDATE employees SET salary = :salary WHERE id = :id")
	int updateSalary(Double salary, Long id);
}
