package com.springtutorial.learn_spring_framework;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BasicSpring {

	public static void main(String[] args) {
	
		//1: Launch spring Context 
		// With reflection, spring collects everything about every class, like what annotation is being used, 
		// what peroperties are there, what methods are there and makes a map of all these info somewhere during
		//spring starts. Hence spring has all info about every calls and annotation. 
		var context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		
		//2: Configure the things which we want spring to manage @Configuration
		// SpringConfiguration.java - @Configuration annotation. 
		
		
		//3: Retrieving beans managed by Spring. 
		//there are many ways to retrieve bean but one of the way is by name. funciton name is name();
		
		var name = context.getBean("name");
		System.out.println(name);

		//var is an object here whereever we are calling bean by context
		Object age = context.getBean("age");
		System.out.println(age);
		
		var person = context.getBean("person");
		System.out.println(person);
		
		var address = context.getBean("homeaddress");
		System.out.println(address);
		
		
		//Refer note about erros in case of multiple qualifying beans. @primary annotation. 
		var addressByClassName = context.getBean(Address.class);
		System.out.println(addressByClassName);
		
		//here we are using existing address bean by method call - method name
		System.out.println(context.getBean("reuseExistingBeanByMethodCall"));
		
		//here we are using existing address bean by parameter call - actual bean name
		System.out.println(context.getBean("reuseExistingBeanByParameter"));
		
		System.out.println(context.getBean("person2"));
		
		System.out.println(context.getBean("person3"));
		
		System.out.println(context.getBean("fulldata"));
		

		//displaying all the beans managed by spring... 
		System.out.println("===================displaying all the beans managed by spring...==========");
		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
		//other methods.
		System.out.println(context.getBeanDefinitionCount());
		System.out.println(context.getBeanDefinition("fulldata"));
		
	}
}
