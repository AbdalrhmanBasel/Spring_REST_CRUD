package com.global.hr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.global.hr.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Map the ResultSet to an Employee object

		// Retrieve the column values from the ResultSet
		long id = rs.getLong("id");
		String name = rs.getString("name");
		double salary = rs.getDouble("salary");
		String isCreate = rs.getString("is_create");

		// Create and return a new Employee object
		return new Employee(id, name, salary, isCreate);
	}

}
