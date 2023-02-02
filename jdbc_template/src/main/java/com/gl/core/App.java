package com.gl.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gl.employee.dao.EmployeeDAO;
import com.gl.employee.model.Employee;
import com.helper.CustomReader;

public class App
{
	public static void main(String[] args)
	{
		String menu = "Press 1 to Add, "
				+ "2 to update, "
				+ "3 to Delete, "
				+ "4 to Show all "
				+ "and 5 to exit";
		ApplicationContext context = null;
		int choice = 0;
		try {
			context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			EmployeeDAO employeeDAO = (EmployeeDAO) context
					.getBean("employeeDAO");
			while (choice != 5) {
				System.out.println(menu);
				choice = CustomReader.readInt("Enter Your Choice: ");
				switch(choice) {
					case 1:
						employeeDAO.insert(new Employee(CustomReader.readInt("Enter ID:"),
								CustomReader.read("Enter Name:"),
								CustomReader.readInt("Enter Age:"),
								CustomReader.readInt("Enter Salary")));
						break;
					case 2:
						employeeDAO.update(CustomReader.readInt("Enter ID to Search by:"),
								CustomReader.read("Enter NEW Name:"),
								CustomReader.readInt("Enter NEW Age:"),
								CustomReader.readInt("Enter NEW Salary"));
						break;
					case 3:
						employeeDAO.delete(CustomReader.readInt("Enter ID to Search by:"));
						break;
					case 4:
						employeeDAO.select();
						break;
				}
			}
			
			((AbstractApplicationContext) context).close();	
		}
		finally {
			CustomReader.close();
			if (context != null ) {
				((AbstractApplicationContext) context).close();
			}
		}
		System.out.println("Exited inserted successfully.");
	}
}
