package com.springtutorial.learn_spring_framework.game;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	

}

@Component
class YourBusinessClass{

	//Field Injeciton -- We do not have to specifiy setter as well if we go with field injection. 
	
	//@Autowired
	Dependency1 dependency1;
	//@Autowired
	Dependency2 dependency2;
	
	
	//Setter based Injection
	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		this.dependency1 = dependency1;
	}



	@Autowired
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
public class UnderstandingInjections {
	public static void main(String[] args) {
		
		
		try (var context = new AnnotationConfigApplicationContext(UnderstandingInjections.class)){
			
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
