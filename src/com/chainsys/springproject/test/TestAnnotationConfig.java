package com.chainsys.springproject.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.component.MobilePhone;

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

	//ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml"); 
	public static void testPhone() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com.chainsys.springproject.component");
		ac.refresh();
		MobilePhone phone = ac.getBean(MobilePhone.class);
		phone.setPhoneNumber(9362469055l);
		long number = phone.getPhoneNumber();
		System.out.println("Phone Number: " + number);
	}
}
