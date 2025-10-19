package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dao.IEmployeeDAO;
import com.nt.modal.Employee;
import com.nt.service.IEmployeeMgmService;

@Controller("cfgController")
public class CollageOperationsController 
{
	@Autowired
private IEmployeeMgmService  empService;
	public List<Employee> showEmployeesByDesgs(String desg1,String desg2,String desg3) throws Exception
	{
	//use Service
		List<Employee>list=empService.fetchEmployeesByDesg(desg1, desg2, desg3);
		
		return list;
	}
}
