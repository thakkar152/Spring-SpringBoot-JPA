package com.springtutorial.learn_spring_framework.game;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
class Dependency1{
	
}

@Named
class Dependency2{
	

}

@Named
class YourBusinessClass{

	//Field Injeciton 
	
	//@Autowired
	Dependency1 dependency1;
	//@Autowired
	Dependency2 dependency2;
	
	
	//Setter based Injection
	@Inject
	public void setDependency1(Dependency1 dependency1) {
		this.dependency1 = dependency1;
	}



	@Inject
	public void setDependency2(Dependency2 dependency2) {
		this.dependency2 = dependency2;
	}


	
	//Constructor Based Injection 
	
//	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
//		super();
//		this.dependency1 = dependency1;
//		this.dependency2 = dependency2;
//	}



	@Override
	public String toString() {
		return "YourBusinessClass [dependency1=" + dependency1 + ", dependency2=" + dependency2 + "]";
	}
	
	
}


@Configuration
@ComponentScan
public class JakartaCDI {
	public static void main(String[] args) {
		
		
		try (var context = new AnnotationConfigApplicationContext(JakartaCDI.class)){
			
			 //Listing all beans. If I remove @Component, it will not listed as bean and will not be managed by Spring.
			 String[] beanDefinations = context.getBeanDefinitionNames();
			 Arrays.stream(beanDefinations).forEach(System.out :: println);
			
			 //getting bean is same as creating object of that class. And we are printing an object so it prints toString Method
			 System.out.println(context.getBean(YourBusinessClass.class));
			 
			 // this is same as above. but here dependecny will remain null as its not spring :)
			 //YourBusinessClass ybc = new YourBusinessClass();
			 //System.out.println(ybc);
			
		}


		
	}
}	
