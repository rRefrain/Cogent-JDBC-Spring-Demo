package com.gl.employee.dao;

import com.gl.employee.model.Employee;

public interface EmployeeDAO extends EmployeeSQL
{	
	public void insert(Employee employee);
	public void update(int empolyeeID, String name, int age, int salary);
	public void delete(int empolyeeID);
	public void select();
}