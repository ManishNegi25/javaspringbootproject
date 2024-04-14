package com.cetpa.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cetpa.models.Employee;
import com.cetpa.services.EmployeeService;

@Controller
public class EmployeeController 
{
@Autowired
 private EmployeeService employeeService;
 

@RequestMapping("")
 private String getEmployeeDashboard(Model model)
 {
	List<Employee> employeeList= employeeService.getList();
	 model.addAttribute("elist", employeeList);	
	  return"employee-dashboard";
 }

@RequestMapping("add")
private String  getEmployeeAdd()
{
	return "add-employee";
}

@RequestMapping("save-record")
private String  saveEmployeeRecord(Employee employee)
{
	employeeService.saveRecord(employee);
	return "redirect";
}
@RequestMapping("delete-record")
private String deleteRecord(int eid)
{
	employeeService.deleteRecord(eid);
	 return "redirect";
}
@RequestMapping("edit-record")
private String editRecord(int eid, Model model)
{List<String> list=Arrays.asList("Training","Marketing","Accounts","Inventory","Sales","Human Resource");
Employee employee=employeeService.getRecord(eid);
model.addAttribute("emp",employee);
model.addAttribute("dlist",list);
return "edit-employee";

	}
@RequestMapping("update-record")
private String UpdateRecord(Employee employee) {
	employeeService.updateRecord(employee);
	return"redirect:/";
}
}
