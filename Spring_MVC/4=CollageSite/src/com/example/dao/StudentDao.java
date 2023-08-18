package com.example.dao;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.Student;

public interface StudentDao {

	void addStudentInformention(Student student);

	List<Student> getStudentInormention(String uname, String pass);

	Student getStudentUsingUnformentionId(int id);

	List<Student> updateStudentInformention(Student student);// update student data
	

	List<Student> dataDelete(int id);// Delete Student Data
	
	void fileDataStore(MultipartFile file); // file handling

}
