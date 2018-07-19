package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bean.Employee;
import com.cg.dao.IEmployeeDao;

@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}

	@Override
	public void insertEmployees(List<Employee> employees) {
		employeeDao.insertEmployees(employees);
	}

	public void getAllEmployees() {
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}

	@Override
	public void getEmployeeById(String empId) {
		Employee employee = employeeDao.getEmployeeById(empId);
		System.out.println(employee);
	}

}
