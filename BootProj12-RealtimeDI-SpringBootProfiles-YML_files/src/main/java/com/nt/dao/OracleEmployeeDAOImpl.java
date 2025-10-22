package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.nt.modal.Employee;

@Repository("ora_empDAO")
@Profile({"uat","prod"})
public class OracleEmployeeDAOImpl implements IEmployeeDAO 
{
	private static final String GET_EMPS_BY_DESGS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE DESG IN(?,?,?)ORDER BY DESG ";
	@Autowired
private DataSource ds;
	
	public OracleEmployeeDAOImpl()
	{
		System.out.println("OracleEmployeeDAOImpl :: 0-param  Contructor");
	}
	
	@Override
	public List<Employee> getEmpsByDesgs(String deg1, String deg2, String deg3) throws Exception {
		System.out.println("OracleEmployeeDAOImpl.getEmpsByDesgs"+ds.getClass());
		List<Employee>list=null;
		try(Connection con=ds.getConnection();
				PreparedStatement ps= con.prepareStatement(GET_EMPS_BY_DESGS))
		{
			System.out.println("DS  object class  name ::"+ds.getClass());
			
			//set values to query params
			ps.setString(1, deg1);
			ps.setString(2, deg2);
			ps.setString(3, deg3);
			//exsicute the query and copy the result set obj records to list <Employee> object
			try(ResultSet rs=ps.executeQuery())
			{
				list= new ArrayList<Employee>();
				while(rs.next()) {
				//copy each record to employee class obj
				Employee emp= new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setDesg(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setDeptno(rs.getInt(5));
				//add Each Emp.oyee class to list collection
				list.add(emp);
			}//while
			}//try1
		}//try2
		catch (SQLException se)
		{
		se.printStackTrace();
		throw se;
		}
		catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
		
		return list;
	}

}
