package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;

@Controller
public class HomeController {

	@RequestMapping(value = "log")
	public String getSuccessPage() {

		System.out.println("Data Trancefer Successfully");

		return "register";
	}

	@RequestMapping(value = "login")
	public String getLoginData(@RequestParam String uname, @RequestParam String pass) {
		System.out.println("Data Login Successfully :" + uname + " " + pass);
		return "success";

	}
	
	@RequestMapping(value ="reg")
	public String getRegisterData(@ModelAttribute Student Student) {
		
		System.out.println("Student Data Register Successfully : "+Student);
		
		return "login";
	}

}
