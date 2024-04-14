package com.cetpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetpa.models.Employee;
import com.cetpa.repositories.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getList() 
	{
		
		return employeeRepository.getList();
	}

	public void saveRecord(Employee employee) {
	 employeeRepository.saveRecord(employee);
		
	}

	public void deleteRecord(int eid) {
		Employee employee= employeeRepository.getEmployee(eid);
		 employeeRepository.deleteRecord(employee);
		
	}

	public Employee getRecord(int eid) {
		
		return  employeeRepository.getEmployee(eid);
	}

	public void updateRecord(Employee empnew) {
		Employee empold= employeeRepository.getEmployee(empnew.getEid());
		employeeRepository.updateRecord(empold,empnew);
	}

}