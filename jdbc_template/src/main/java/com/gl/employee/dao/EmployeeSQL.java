package com.gl.employee.dao;

public interface EmployeeSQL {
	public final static String Insert_EMPLOYEES_SQL =
			"insert into employee (EMPLOYEE_ID, NAME, AGE,SALARY) values (?, ?, ?,?)";
	
	public final static String Update_EMPLOYEES_SQL = "update employee set name=?, age=?, "
			+ "salary=? where EMPLOYEE_ID=?";
	
	public final static String	Delete_Product_ID_SQL = "delete from employee where EMPLOYEE_ID=?";
	
	public final static String Find_Product_EXPIRY_SQL = "select * from employee";
}
