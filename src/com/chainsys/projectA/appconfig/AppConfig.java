package com.chainsys.projectA.appconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import com.chainsys.projectA.beans.Employee;
import com.chainsys.projectA.beans.Customer;

public class AppConfig {
	@Bean
	@Scope(value="prototype")
	public Employee employee() {
		return new Employee();
	}

	@Bean
	public Customer customer() {
		return new Customer();
	}
}
