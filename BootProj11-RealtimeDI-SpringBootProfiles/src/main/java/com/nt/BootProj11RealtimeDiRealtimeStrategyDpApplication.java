package com.nt;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.CollageOperationsController;
import com.nt.modal.Employee;
@SpringBootApplication
public class BootProj11RealtimeDiRealtimeStrategyDpApplication {
	@Autowired
	private Environment env;
//	@Bean(name="c3p0Ds")
	@Profile("test")
	/*
	public DataSource createC3P0Ds() throws Exception
	{
		System.out.println("BootProj11RealtimeDiRealtimeStrategyDpApplication.createC3P0Ds()");
		ComboPooledDataSource c3p0Ds= new ComboPooledDataSource();
		c3p0Ds.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		c3p0Ds.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		c3p0Ds.setUser(env.getRequiredProperty("spring.datasource.username"));
		c3p0Ds.setPassword(env.getRequiredProperty("spring.datasource.pass"));
		c3p0Ds.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.min-idle")));
		c3p0Ds.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.max.total")));
		return c3p0Ds;
	}	*/
	public static void main(String[] args) {
		// get access to IOC Container
		ApplicationContext ctx = SpringApplication.run(BootProj11RealtimeDiRealtimeStrategyDpApplication.class, args);
		// get controller class obj
		CollageOperationsController controller = ctx.getBean("cfgController", CollageOperationsController.class);
		// invoke the B.method
		try {
			List<Employee> list = controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMEN");
			list.forEach(emp -> {
				System.out.println(emp);
			});
		} // try
		catch (Exception e) {
			e.printStackTrace();
		}
		// close the container
		((ConfigurableApplicationContext) ctx).close();
	}// main
} // class
