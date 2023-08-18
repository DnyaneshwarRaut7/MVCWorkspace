package com.example.controller;

import java.util.ArrayList;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private static final Logger LOGGER = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "register",method = RequestMethod.POST)
	public String getRegisterData(@ModelAttribute Employee employee) {
    
		LOGGER.info("Register Data :-" + employee);
		
		//System.out.println("Register Data :-" + employee);

		employeeService.addEmployeeData(employee);

		return "login";
	}

	@RequestMapping(value = "login")
	public String getLoginData(@RequestParam("uname") String uname, @RequestParam("pass") String pass, Model model) throws UserNotFoundException {

		LOGGER.info("Login Click :-" + uname + "  " + pass);
		//System.out.println("Login Click :-" + uname + "  " + pass);
		List<Employee> list = new ArrayList<Employee>(); 
         try { 
        	 list =employeeService.getLoginData(uname, pass);
         }catch(UserNotFoundException e) {
        	 
        	 System.out.println("In Employee Controller : " +e.getMessage());
         }
		if (list.isEmpty()) {
			String msg = "Invalied UserName & Password ....!";
			model.addAttribute("str", msg);

			return "login";
		} else {

			model.addAttribute("l", list);
			return "sucess";
		}

	}

	@RequestMapping(value = "update")
	public String getDataForUpdate(@RequestParam("eid") int eid, Model model) {
  
		LOGGER.info("Check For Eid Update :-" + eid);
		//System.out.println("Check For Eid Update :-" + eid);
		Employee employee = employeeService.getEmployeeUsingId(eid);
		model.addAttribute("e", employee);
		return "update";
	}

	@RequestMapping(value = "up")
	public String getUpdateData(@ModelAttribute Employee employee, Model model) {
       
		
		System.out.println("Update Data :-" + employee);
		List<Employee> list = employeeService.updateInEmployeeData(employee);
		model.addAttribute("l", list);
		return "sucess";
	}

	@RequestMapping(value = "remove")
	public String dataDeleting(@RequestParam("eid") int eid, Model model) {
		System.out.println("Deleting Employee Id :-" + eid);
		List<Employee> list = employeeService.deletingEmployeeData(eid);
		model.addAttribute("l", list);
		return "sucess";
	}
	
	@RequestMapping(value = "fileupload",method =RequestMethod.POST)
	public String getFileData(@RequestParam("file") MultipartFile file) {
		System.out.println("check file Data :-"+ file.getOriginalFilename());
		employeeService.fileDataStore(file);
		return "fileupload";
		
		
	}
}