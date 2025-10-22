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

public class BootProj12RealtimeDiRealtimeStrategyDpApplication {
	@Autowired
	private Environment env;

	@Bean(name = "c3P0Ds")
	@Profile("test")

	public ComboPooledDataSource createC3PoDs() throws Exception {
		System.out.println("BootProj11RealtimeDiRealtimeStrategyDpApplication.createC3P0Ds");
		ComboPooledDataSource c3PoDs = new ComboPooledDataSource();
		c3PoDs.setDriverClass(env.getRequiredProperty("spring.datasource.driver-class-name"));
		c3PoDs.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		c3PoDs.setUser(env.getRequiredProperty("spring.datasource.username"));
		c3PoDs.setPassword(env.getRequiredProperty("spring.datasource.password"));
		c3PoDs.setInitialPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.min-idle")));
		c3PoDs.setMaxPoolSize(Integer.parseInt(env.getRequiredProperty("c3p0.max-total")));
		return c3PoDs;

	}

	
	 
	  private final CollageOperationsController cfgController;
	  
	  BootProj12RealtimeDiRealtimeStrategyDpApplication(CollageOperationsController
	  cfgController) {
		  this.cfgController = cfgController; 
		  }
	  
	  public
	  static void main(String[] args) {
		SpringApplication app = new SpringApplication(BootProj12RealtimeDiRealtimeStrategyDpApplication.class);

		 //create the SpringApplication SpringApplication app=
		  
		  app.setAdditionalProfiles("uat"); // get controller class obj
		  
		  ApplicationContext ctx=app.run(args);
		 

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

	private static SpringApplication SpringApplication(Class<BootProj12RealtimeDiRealtimeStrategyDpApplication> class1,
			String[] args) {
		// TODO Auto-generated method stub
		return null;
	}
} // class
