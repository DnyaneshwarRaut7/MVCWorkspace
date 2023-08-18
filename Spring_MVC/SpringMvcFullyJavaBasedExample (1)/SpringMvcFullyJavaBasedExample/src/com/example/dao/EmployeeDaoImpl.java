package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.exception.UserNotFoundException;
import com.example.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void addEmployeeData(Employee employee) {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		session.save(employee);
		session.beginTransaction().commit();
		System.out.println("Data Inserted");
	}

	@Override
	public List<Employee> getLoginData(String uname, String pass) throws UserNotFoundException {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		List<Employee> list = null;
		if("admin".equals(uname) && "admin".equals(pass)) {
			Query<Employee> query = session.createQuery("from Employee");
			list = query.getResultList();
			
		}else {
			try {
			Query<Employee> query = session.createQuery("from Employee where uname=:un and pass=:ps");
			query.setParameter("un", uname);
			query.setParameter("ps", pass);
			Employee employee = query.getSingleResult();
			list.add(employee);
			}catch (Exception e) {
				// TODO: handle exception
				throw new UserNotFoundException("Invalid User...!");
			}
		   
		}
		
		return list;
	}

}
