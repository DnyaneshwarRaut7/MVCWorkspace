package com.homecontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.Student;
import com.example.service.StudentService;

@Controller
public class HomeController {

	@Autowired
	private StudentService StudentService;

	@RequestMapping(value = "log")
	public String homePage() {

		return "login";
	}

	@RequestMapping(value = "login")
	public String loginPage(@RequestParam String uname, @RequestParam String pass, Model model) {

		System.out.println("Login Page Detail :- " + uname + " " + pass);
		List<Student> ls = StudentService.getStudentData(uname, pass);
		model.addAttribute("l", ls);

		return "bca";

	}

//  @RequestMapping(value = "register")
//	public String registerData(@RequestParam String id, @RequestParam String name, @RequestParam String address,
//			@RequestParam String mobileNo, @RequestParam String mailId, @RequestParam String gender ) {
//
//		System.out.println(
//				"Register Data :" + id + " " + name + " " + address + " " + mobileNo + " " + mailId + " " + gender);
//
//		return "reg";
//	}
//	
	@RequestMapping(value = "register")
	public String getRegisterData(@ModelAttribute Student student) {

		System.out.println("Register Student Data :-" + student);
		StudentService.addStudentData(student);

		return "login";
	}

	@RequestMapping(value = "update")
	public String getDataForUpdate(@RequestParam("id") int id, Model model) {
		System.out.println("Chek Id For Update : " + id);
		Student student = StudentService.getStudentUsingId(id);
		model.addAttribute("s", student);
		return "update";
	}

	@RequestMapping(value = "up")
	public String getupdateData(@ModelAttribute Student student ,Model model) {

		System.out.println("Update Student Data :-" + student);
	List<Student> list=	StudentService.updateStudentInformention(student);
	model.addAttribute("l", list);

		return "bca";
	}
	@RequestMapping(value = "remove")
	public String dataDeleting(@RequestParam("id") int id,Model model) {
		
		System.out.println("Delete Student Data :-"+ id);
	List<Student> list=	StudentService.dataDelete(id);
	model.addAttribute("l",list);
	
	return "bca";
		
	}
	@RequestMapping(value = "fileUpload",method = RequestMethod.POST)
	public String getFileData(@RequestParam MultipartFile file) {
		System.out.println("Check File Data : " + file.getOriginalFilename());
		StudentService.fileDataStore(file);
		return "fileupload";
	}
}
 