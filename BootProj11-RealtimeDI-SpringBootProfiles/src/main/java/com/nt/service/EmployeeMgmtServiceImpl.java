package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.modal.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmService {

	@Autowired
	private IEmployeeDAO empDAO;
	public EmployeeMgmtServiceImpl() 
	{
		System.out.println("EmployeeMgmtServiceImpl :: 0-param Contructor ----3");
	}
	
	
	
	@Override
	public  List<Employee> fetchEmployeesByDesg(String desg1, String dseg2, String desg3) throws Exception {
		System.out.println("EmployeeMgmtServiceImpl.fetchEmployeesByDesg()");
		//use dao
		List<Employee>list=empDAO.getEmpsByDesgs(desg1, dseg2, desg3);
		
		return list;
	}

}
