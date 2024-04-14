package com.cetpa.repositories;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cetpa.models.Employee;

@Repository
public class EmployeeRepository 
{
	private Session session;
	 private Transaction transaction ;
	 
	 @Autowired
	 private EmployeeRepository(SessionFactory sessionFactory)
	 {
		 session  = sessionFactory.openSession();
		 transaction= session.getTransaction();
	 }

	public List<Employee> getList() {
		Query<Employee> query= session.createQuery("from employee", Employee.class);
		 return query.list();
	}

	public void saveRecord(Employee employee) {
	 transaction.begin();
	 session.save(employee);
	 transaction.commit();
		
	}

	public Employee getEmployee(int eid) {
		Employee employee=session.get(Employee.class, eid);
		return employee;
	}

	public void deleteRecord(Employee employee) {
		 transaction.begin();
		 session.delete(employee);
		 transaction.commit();
		
	}

	public void updateRecord(Employee empold, Employee empnew) {
		 transaction.begin();
	     empold.setFirstname(empnew.getFirstname());
	     empold.setLastname(empnew.getLastname());
	     empold.setDepartment(empnew.getDepartment());
	     empold.setEmail(empnew.getEmail());
	     empold.setPhone(empnew.getPhone());
	     empold.setDob(empnew.getDob());
		 transaction.commit();
		
	}

	



}
