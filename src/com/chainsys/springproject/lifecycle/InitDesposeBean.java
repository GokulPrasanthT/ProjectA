package com.chainsys.springproject.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.config.BeanPostProcessor; //refer aop

public class InitDesposeBean implements DisposableBean, InitializingBean{
private String city;
public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public int getPincode() {
	return pincode;
}

public void setPincode(int pincode) {
	this.pincode = pincode;
}

private int pincode;
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet Method Called");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy Method Called");
	}
	public InitDesposeBean () {
		System.out.println("InitDesposeBean Object is Created " + hashCode());
	}
	// After Constructor
	public void setup() {
		System.out.println("Starting...");
	}
	public void close() {
		System.out.println("Closing...");
	}
	public void print() {
		System.out.println("Print...");
	}

}
