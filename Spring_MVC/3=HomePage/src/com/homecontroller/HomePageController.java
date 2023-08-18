package com.homecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

	@RequestMapping(value = "log")
	public String homepage() {
		return "login";
	}

	@RequestMapping(value = "login")
	public String getLoginData(@RequestParam String uname, @RequestParam String pass, @RequestParam String capche) {

		System.out.println("login data :" + uname + "  " + pass + " " + "  " + capche);
		return "register";
	}

	@RequestMapping(value = "register")
	public String registerData(@RequestParam String id, @RequestParam String name, @RequestParam String address,
			@RequestParam String mobileNo, @RequestParam String mailId, @RequestParam String gender ) {

		System.out.println(
				"Register Data :" + id + " " + name + " " + address + " " + mobileNo + " " + mailId + " " + gender);

		return "homepage";
	}
}