package com.nt.service;

import java.util.List;

import com.nt.modal.Employee;

public interface IEmployeeMgmService 
{
public List<Employee> fetchEmployeesByDesg(String desg1,String dseg2,String desg3)throws Exception;
	

}
