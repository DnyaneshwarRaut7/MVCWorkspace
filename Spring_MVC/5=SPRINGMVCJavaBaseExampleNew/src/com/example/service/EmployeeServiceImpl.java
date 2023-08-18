package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.EmployeeDao;
import com.example.exception.UserNotFoundException;
import com.example.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployeeData(Employee employee) {
		
		System.out.println("In service Layer :"+employee);

		employeeDao.addEmployeeData(employee);
	
	}

	@Override
	public List<Employee> getLoginData(String uname, String pass)throws UserNotFoundException {
		
		return employeeDao.getLoginData(uname, pass);
	}

	@Override
	public Employee getEmployeeUsingId(int eid) {
		
		return employeeDao.getEmployeeUsingId(eid);
	}

	@Override
	public List<Employee> updateInEmployeeData(Employee employee) {
		
		return employeeDao.updateInEmployeeData(employee)  ;
	}

	@Override
	public List<Employee> deletingEmployeeData(int eid) {
	
		return employeeDao.deletingEmployeeData(eid);
	}

	@Override
	public void fileDataStore(MultipartFile file) {
		employeeDao.fileDataStore(file);
	
		
	}

}
