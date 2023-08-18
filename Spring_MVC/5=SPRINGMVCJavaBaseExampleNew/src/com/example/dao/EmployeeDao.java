package com.example.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;

public interface EmployeeDao {
	
	void addEmployeeData(Employee employee);// add all information
	
	List<Employee> getLoginData(String uname,String pass) throws UserNotFoundException; // id pass show

	Employee getEmployeeUsingId(int eid); // update 
	
	List<Employee> updateInEmployeeData(Employee employee);// update Data
	
	List<Employee> deletingEmployeeData(int eid);// delete Data


	void fileDataStore(MultipartFile file); // file Handling

}
