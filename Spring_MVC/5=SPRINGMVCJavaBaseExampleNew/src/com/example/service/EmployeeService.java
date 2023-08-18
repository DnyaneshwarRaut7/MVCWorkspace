package com.example.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;

public interface EmployeeService {
	
	// abstract method
	public abstract void addEmployeeData(Employee employee);
	
	List<Employee> getLoginData(String uname,String pass) throws UserNotFoundException;
	
	Employee getEmployeeUsingId(int eid);
	
	List<Employee> updateInEmployeeData(Employee employee);
	
	List<Employee> deletingEmployeeData(int eid);
	

	void fileDataStore(MultipartFile file); // file handling method

}
