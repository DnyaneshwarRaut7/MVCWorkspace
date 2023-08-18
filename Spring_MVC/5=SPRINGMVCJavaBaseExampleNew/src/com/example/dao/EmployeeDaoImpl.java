package com.example.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;
import com.example.model.FileData;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addEmployeeData(Employee employee) {

		Session session = sf.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("Data Inserted");

	}

	@Override
	public List<Employee> getLoginData(String uname, String pass) throws UserNotFoundException {
		Session session = sf.openSession();
		List<Employee> list = new ArrayList<Employee>();

		if ("Dnyaneshwar".equals(uname) && "mauli@123".equals(pass)) {

			Query<Employee> query = session.createQuery("from Employee");
			list = query.getResultList();
		} else {
			try {
				Query<Employee> query = session.createQuery("from Employee where uname =:un and pass =:ps");
				query.setParameter("un", uname);
				query.setParameter("ps", pass);

				Employee employee = query.getSingleResult();
				list.add(employee);
			} catch (Exception e) {
				//System.out.println(e.getMessage());
				
				throw new UserNotFoundException("Invalied User....!");
			}
		}

		return list;
	}

	@Override
	public Employee getEmployeeUsingId(int eid) {

		Session session = sf.openSession();
		Employee employee = session.get(Employee.class, eid);

		return employee;
	}

	@Override
	public List<Employee> updateInEmployeeData(Employee employee) {

		Session session = sf.openSession();
		session.update(employee);
		session.beginTransaction().commit();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();

		return list;
	}

	@Override
	public List<Employee> deletingEmployeeData(int eid) {
		
		Session session = sf.openSession();
		Employee employee = session.get(Employee.class, eid);
		session.delete(employee);
		session.beginTransaction().commit();
		Query<Employee> query = session.createQuery("from Employee");
		List<Employee> list = query.getResultList();
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
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
		
}


