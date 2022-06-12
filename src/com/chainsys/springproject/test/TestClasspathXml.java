package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.beans.Actor;
import com.chainsys.springproject.beans.Calendar;
import com.chainsys.springproject.beans.CalendarFactory;
import com.chainsys.springproject.autowire.Car;
import com.chainsys.springproject.autowire.CarServices;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.beans.Lunch;
import com.chainsys.springproject.beans.ScoreBoard;
import com.chainsys.springproject.lifecycle.AnnotationLc;
import com.chainsys.springproject.lifecycle.InitDesposeBean;
import com.chainsys.springproject.lifecycle.LifeCycleBean;

public class TestClasspathXml {
	public static void testA() {
		Employee emp = new Employee();
		emp.setId(10);
		emp.setName("Gokul");
		emp.print();
	}

	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Employee emp = ac.getBean(Employee.class); // over loaded method of getbean(Class) returns object of the class Employee
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
		Lunch nvsilunch = ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch = ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch = ac.getBean("nilunch", Lunch.class);
		Lunch chlunch = ac.getBean("chlunch", Lunch.class);
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
		Employee emp = ac.getBean("emp2", Employee.class);
		emp.print();
	}

	public static void testLifeCycle() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		LifeCycleBean life = ac1.getBean(LifeCycleBean.class);
		life.print();
		LifeCycleBean life1 = ac1.getBean(LifeCycleBean.class);
		LifeCycleBean life2 = ac1.getBean(LifeCycleBean.class);
		life = null;
		ac1.close();
		ac1 = null;
//		System.gc();
	}

	public static void testInitDesposeBean() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		InitDesposeBean init = ac1.getBean(InitDesposeBean.class);
		init.print();
		ac1.close();
		ac1 = null;
	}

	public static void testAnnotationLc() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Lc.xml");
		AnnotationLc an = ac1.getBean(AnnotationLc.class);
		an.print();
		ac1.close();
		ac1 = null;
	}

	public static void testAutoWire() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		Car car = ac1.getBean("car", Car.class);
		car.start();
		car.move();
		car = null;
		ac1.close();
	}

	public static void testAutowireQualifier() {
		ConfigurableApplicationContext ac1 = new ClassPathXmlApplicationContext("Autowire.xml");
		CarServices cs = ac1.getBean("carw",CarServices.class);
		cs.startTrip();
	}
}
