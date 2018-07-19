package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cg.bean.Employee;
import com.cg.service.EmployeeService;

@SpringBootApplication
public class SpringBootJdbcApplication {
	
	
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		
		Employee emp= new Employee();
		emp.setEmpId("emp3");
		emp.setEmpName("emp3");
		
		/*Employee emp1= new Employee();
		emp1.setEmpId("emp1");
		emp1.setEmpName("emp1");
		
		Employee emp2= new Employee();
		emp2.setEmpId("emp2");
		emp2.setEmpName("emp2");*/

		
		employeeService.insertEmployee(emp);

		List<Employee> employees = new ArrayList<>();
		employees.add(emp);
		//employees.add(emp2);
		employeeService.insertEmployees(employees);

		employeeService.getAllEmployees();
		
		employeeService.getEmployeeById(emp.getEmpId());

	}
}