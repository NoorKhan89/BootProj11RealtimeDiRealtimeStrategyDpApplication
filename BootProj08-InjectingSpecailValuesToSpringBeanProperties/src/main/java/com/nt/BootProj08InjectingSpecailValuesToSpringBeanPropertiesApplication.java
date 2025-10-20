package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj08InjectingSpecailValuesToSpringBeanPropertiesApplication {

	public static void main(String[] args) 
	{
		//Get IOC container
	ApplicationContext ctx=	SpringApplication.run(BootProj08InjectingSpecailValuesToSpringBeanPropertiesApplication.class, args);
	//get Spring Bean class object
	Employee emp=ctx.getBean("emp",Employee.class);
	System.out.println("Emp detials :: \n"+emp+"\n");
	
	((ConfigurableApplicationContext) ctx).close();
	}
}
