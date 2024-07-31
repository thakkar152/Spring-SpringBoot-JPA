package com.springtutorial.learn_spring_framework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age) {};
record Address(String firstLine, String city) {};
record FullData(Person person, Address address) {};

@Configuration
public class SpringConfiguration {
	
	@Bean
	public String name() {
		return "Bhupat";
	}
	
	@Bean
	public int age() {
		return 37;
	}
	
	@Bean
	public Person person() {
		Person person = new Person("Chaman", 40);
		return person;
	}
	
	@Bean(name = "homeaddress")
	@Primary
	public Address address() {
		return new Address("chamn lane", "Chaman Gaon");
	}
	
	//here we are using existing address bean by method call - method name
	@Bean
	public Address reuseExistingBeanByMethodCall() {
		return address();
	}
	
	//here we are using existing address bean by parameter call - actual bean name. Here name should be homeaddress itself. 
	//actual name of the bean. 
	@Bean
	@Qualifier("reuseExistingBeanByParameterQualifier")
	public Address reuseExistingBeanByParameter(Address homeaddress) {
		return homeaddress;
	}
	
	//reusing name bean and age bean as a method. 
	@Bean
	public Person person2() {
		var person = new Person(name(), age());
		return person;
	}
	
	//reusing name bean and age bean as a parameter. 
	@Bean
	public Person person3(String name, int age) {
		var person = new Person(name, age);
		return person;
	}
	
	@Bean
	public FullData fulldata(Person person, @Qualifier("reuseExistingBeanByParameterQualifier") Address homeaddress ) {
		return new FullData(person, homeaddress);
	}
}
