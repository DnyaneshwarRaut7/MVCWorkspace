package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.exception.UserNotFoundException;
import com.example.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void addEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("In Service layer : " + employee);
		employeeDao.addEmployeeData(employee);
	}

	@Override
	public List<Employee> getLoginData(String uname, String pass) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return employeeDao.getLoginData(uname, pass);
	}

}
