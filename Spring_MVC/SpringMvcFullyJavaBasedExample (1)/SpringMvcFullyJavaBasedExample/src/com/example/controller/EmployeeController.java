package com.example.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/")
	public String getIndex() {
		return "index";
	}
	
	
	@RequestMapping(value = "regis",method = RequestMethod.POST)
	public String getRegisterData(@ModelAttribute Employee employee) {
		LOGGER.info("Registered Data : " + employee);
		//System.out.println("Registered Data : " + employee);
		employeeService.addEmployeeData(employee);
		
		return "login";
	}
	
	@RequestMapping(value = "log")
	public String getLoginData(@RequestParam("uname") String uname,@RequestParam("pass") String pass,Model model) throws UserNotFoundException{
		System.out.println("login Check : " + uname + "  "  + pass);
		List<Employee> list = null;
		try {
		 list = employeeService.getLoginData(uname, pass);
		}catch (UserNotFoundException e) {
		
			System.out.println("In Employee Controller : " + e.getMessage());
		}
		if(list == null) {
			String msg = "Invalid user Credentials...!";
			model.addAttribute("str", msg);
			return "login";
		}
		else {
		model.addAttribute("l", list);
		return "success";
		}
	}
}
