package com.cg.service;

import java.util.List;

import com.cg.bean.Employee;

public interface IEmployeeService {


		void insertEmployee(Employee emp);
		void insertEmployees(List<Employee> employees);
		void getAllEmployees();
		void getEmployeeById(String empid);
	
}
