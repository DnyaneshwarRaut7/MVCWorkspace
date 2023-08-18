package com.example.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Student;

public interface StudentService {

	public abstract void addStudentData(Student student);// add student data

	List<Student> getStudentData(String uname, String pass);

	Student getStudentUsingId(int id);

	List<Student> updateStudentInformention(Student student);//update student data
	
	List<Student> dataDelete(int id);// delete Student Data
	

	void fileDataStore(MultipartFile file); // file Handeling
}
