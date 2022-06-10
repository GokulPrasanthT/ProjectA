package com.chainsys.projectA.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.projectA.beans.Actor;
import com.chainsys.projectA.beans.Calendar;
import com.chainsys.projectA.beans.CalendarFactory;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;
import com.chainsys.projectA.beans.Lunch;
import com.chainsys.projectA.beans.ScoreBoard;

public class TestClasspathXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(10);
		emp.setName("Gokul");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Employee emp = ac.getBean(Employee.class); // over loaded method of getbean(Calss) returns object of the class Employee
		Employee emp = (Employee) ac.getBean("emp"); // over loaded method of getbean(String)
		emp.setId(100);
		emp.setName("sanjay");
		emp.print();
		Customer c = ac.getBean(Customer.class);
		c.setId(12);
		c.setName("Doctor");
		c.print();
	}

	public static void testlazyinit() {

		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = (Employee) ac1.getBean("emp");
		Customer c = ac1.getBean(Customer.class);
		// Lazy-init="true" for Customer. An object is created now (firstcall to
		// getbean() method for Customer.class)
		Employee secondemp = (Employee) ac1.getBean("emp");
		Customer secondc = ac1.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(c.hashCode());
		System.out.println(secondemp.hashCode());
		System.out.println(secondc.hashCode());
	}

	public static void testPrototype() {
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
		Actor hero = ac1.getBean(Actor.class);
		Actor heroin = ac1.getBean(Actor.class);
		Actor comedian = ac1.getBean(Actor.class);
		Actor friend = ac1.getBean(Actor.class);
//		System.out.println(hero.hashCode());
//		System.out.println(heroin.hashCode());
//		System.out.println(comedian.hashCode());
//		System.out.println(friend.hashCode());
	}

	public static void testBeanWithConstructor() {
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
	}

	public static void testFactoryMethod() {
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
		ScoreBoard sb = ac1.getBean("sb", ScoreBoard.class);
		sb.targetScore = 134;
		System.out.println(sb.targetScore);
		ScoreBoard sb2 = ac1.getBean("sb2", ScoreBoard.class);
		// sb2.targetScore=400;
		System.out.println(sb2.targetScore);
	}

	public static void testCalendarFactory() {
		ApplicationContext ac1 = new ClassPathXmlApplicationContext("beans.xml");
		Calendar today = ac1.getBean(Calendar.class);
		today.Day = 9;
		today.month = "june";
		today.year = 2022;
		System.out.println(today.Day);
		System.out.println(today.month);
		System.out.println(today.year);
	}

	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml"); 
		Lunch nvsilunch=ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch=ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch=ac.getBean("nilunch", Lunch.class);
		Lunch chlunch=ac.getBean("chlunch", Lunch.class);
		System.out.println("-----");
		nvsilunch.serve(); 
		System.out.println("-----");
		vsilunch.serve(); 
		System.out.println("-----");
		nilunch.serve();
		System.out.println("-----");
		chlunch.serve();
		}
	public static void testSetterDi() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml"); 
		Employee emp=ac.getBean("emp2",Employee.class);
		emp.print();
	}
}