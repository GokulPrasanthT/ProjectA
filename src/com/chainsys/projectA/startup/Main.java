package com.chainsys.projectA.startup;
import com.chainsys.projectA.appconfig.AppConfig;
import com.chainsys.projectA.test.TestAnnotationConfig;
import com.chainsys.projectA.test.TestClasspathXml;
import com.chainsys.projectA.test.TestXmlBeanFactory;

public class Main {

	public static void main(String[] args) {
		//testA();
		//testB();
		//TestClasspathXml.testFactoryMethod();
		//Calendar c1 = new Calendar();
		//TestClasspathXml.testLunchFactory();
		//TestClasspathXml.testSetterDi();
//		TestXmlBeanFactory.testA();
		TestAnnotationConfig.testA();
		
		
	}

}
//Constructor automatically invoked when application context is loaded
//first JVM gets Loaded
//Main method  gets executed
//Application context reads xml configuration file
//application cntext pre-load one object for each for each beans in the config file
//lazy-init="true" gis inform springContainer not to pre_load object for this bean
//by deafult Spring early loads object in memory.
//for lazy -init beans object is created only when the getbean() methd is called.
//for pre-init bean getmethd() return the reference of the pre-loaded object
// by default only one object for evry bean is created (singletom)
//singleton: atleast one object for every class but not more than nne object
//Spring fr lazy-init beans create a singlrton object on firstcall of getbeans() method
//and the uses that object of future getbean() method call
