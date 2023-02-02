package com.gl.employee.dao.impl;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO
{
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void insert(Employee employee)
	{
		jdbcTemplate.update(Insert_EMPLOYEES_SQL,
				new Object[] { employee.getEmployeeId(),
						employee.getName(), employee.getAge(),
						employee.getSalary() });
	}

	public void update(int empolyeeID, String name, int age, int salary) {
		jdbcTemplate.update(Update_EMPLOYEES_SQL,
				new Object[] { name, age, salary, empolyeeID });
		
	}

	public void delete(int empolyeeID) {
		jdbcTemplate.update(Delete_Product_ID_SQL,
				new Object[] { empolyeeID });
	}

	public void select() {
		for(Map<String, Object> i : jdbcTemplate.queryForList(Find_Product_EXPIRY_SQL)) {
			System.out.println(i);
		};
		
	}
}
