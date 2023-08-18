package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileHandingController {

	@RequestMapping(value = "fileUpload",method = RequestMethod.POST)
	public String getFileData(@RequestParam("file") MultipartFile file) {
		System.out.println("Check Data : " + file.getOriginalFilename());
		return "fileupload";
	}
}
