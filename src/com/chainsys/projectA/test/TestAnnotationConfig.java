package com.chainsys.projectA.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.projectA.appconfig.AppConfig;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;

public class TestAnnotationConfig {
	
	public static void testA()
	{
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp = ac.getBean(Employee.class);
		Customer c = ac.getBean(Customer.class);
		emp.setId(5);
		emp.setName("Gokul");
		emp.print();
//		Employee secondemp=ac.getBean(Employee.class);
		Customer cus = ac.getBean(Customer.class);
		
	}

	ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml"); 
}
