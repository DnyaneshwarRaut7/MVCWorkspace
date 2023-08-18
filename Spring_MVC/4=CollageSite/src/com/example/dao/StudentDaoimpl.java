package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import javax.activation.FileDataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.FileData;
import com.example.model.Student;

@Repository
public class StudentDaoimpl implements StudentDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addStudentInformention(Student student) {
		System.out.println("In Dao layer: " + student);
		System.out.println("Student Data Inserted......");

		Session session = sf.openSession();
		session.save(student);
		session.beginTransaction().commit();
		System.out.println("Student Data Sucessfully...");

	}

	@Override
	public List<Student> getStudentInormention(String uname, String pass) {

		List<Student> list = new ArrayList<Student>();
		Session session = sf.openSession();
		if ("Dnyaneshwar".equals(uname) && "mauli@123".equals(pass)) {

			Query<Student> query = session.createQuery("from Student");
			list = query.getResultList();
		} else {
			Query<Student> query = session.createQuery("from Student where uname=:un and pass=:ps");
			query.setParameter("un", uname);
			query.setParameter("ps", pass);
			Student student = query.getSingleResult();
			list.add(student);
		}
		return list;
	}

	@Override
	public Student getStudentUsingUnformentionId(int id) {

		Session session = sf.openSession();
		Student student = session.get(Student.class, id);
		return student;
	}

//	@Override
//	public <List>Student updateStudentInformention(Student student) {
//		Session session = sf.openSession();
//		session.update(student);
//		session.beginTransaction().commit();
//		Query<Student> query = session.createQuery("from Student");
//		list<Student> list = query.getResultList();
//		System.out.println("Student Data Sucessfully...");
//	return list;
//		
//	}

	@Override
	public List<Student> updateStudentInformention(Student student) {
		Session session = sf.openSession();
		session.update(student);
		session.beginTransaction().commit();

		Query<Student> query = session.createQuery("from Student");
		List<Student> list = query.getResultList();

		return list;
	}

	@Override
	public List<Student> dataDelete(int id) {

		Session session = sf.openSession();
		Student student = session.get(Student.class, id);
		session.delete(student);
		session.beginTransaction().commit();

		Query<Student> query = session.createQuery("from Student");
		List<Student> list = query.getResultList();

		return list;
	}

	@Override
	public void fileDataStore(MultipartFile file) {
		
		Session session = sf.openSession();
		try {
			FileData fileData = new FileData();
			fileData.setFname(file.getOriginalFilename());
			fileData.setFdata(file.getBytes());
			session.save(fileData);
			session.beginTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}