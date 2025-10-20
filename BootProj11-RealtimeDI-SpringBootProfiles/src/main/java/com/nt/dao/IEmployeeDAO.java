package com.nt.dao;

import java.util.List;

import com.nt.modal.Employee;

public interface IEmployeeDAO
{
public List<Employee> getEmpsByDesgs(String deg1,String deg2,String deg3) throws Exception;



}
