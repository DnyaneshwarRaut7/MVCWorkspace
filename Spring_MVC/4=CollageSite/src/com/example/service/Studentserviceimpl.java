package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Service
public class Studentserviceimpl implements StudentService {

	@Autowired
	private StudentDao StudentDao;

	@Override
	public void addStudentData(Student student) {

		System.out.println("In Service layerStudent :" + student);
		
		StudentDao.addStudentInformention(student);
	}

	@Override
	public List<Student> getStudentData(String uname, String pass) {
		
		return StudentDao.getStudentInormention(uname, pass);
	}

	@Override
	public Student getStudentUsingId(int id) {
		
		return StudentDao.getStudentUsingUnformentionId(id);
	}

	@Override
	public List<Student> updateStudentInformention(Student student) {
		return	StudentDao.updateStudentInformention(student);
	 
	}

	@Override
	public List<Student> dataDelete(int id) {
		
		return StudentDao.dataDelete(id);
	}

	@Override
	public void fileDataStore(MultipartFile file) {
		
     StudentDao.fileDataStore(file);		
	}

}
