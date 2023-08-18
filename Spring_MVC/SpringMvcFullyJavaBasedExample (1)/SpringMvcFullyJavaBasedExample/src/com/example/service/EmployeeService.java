package com.example.service;

import java.util.List;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;

public interface EmployeeService {

	void addEmployeeData(Employee employee);
	
	List<Employee> getLoginData(String uname,String pass) throws UserNotFoundException;
}
