package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Tourist;

@SpringBootApplication
public class BootProj09WorkingWithYmlOrYamlApplication {

	public static void main(String[] args) 
	{
		// get IOC Container
	ConfigurableApplicationContext ctx=	SpringApplication.run(BootProj09WorkingWithYmlOrYamlApplication.class, args);
	//getSpring bean class object
	Tourist trst=ctx.getBean("tourist",Tourist.class);
	System.out.println("Torisrt data :: "+trst);
	//close The Container 
	 ctx.close();
	
	}//main
}//close
