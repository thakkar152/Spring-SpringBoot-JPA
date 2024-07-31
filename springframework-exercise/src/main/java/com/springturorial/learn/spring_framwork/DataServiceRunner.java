package com.springturorial.learn.spring_framwork;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class DataServiceRunner {

	public static void main(String[] args) {
		
		//Normal without spring
	
		/*
		DataService mysql = new MySQLDataService();
		BusinessCalculateService mysqlBCS = new BusinessCalculateService(mysql);
		System.out.println("Max for mysql :" + mysqlBCS.findMax());
		
		DataService mongo = new MongoDBDataService();
		BusinessCalculateService mongoBCS = new BusinessCalculateService(mongo);
		System.out.println("Max for mongo :" + mongoBCS.findMax());
		*/
		
		
		try(var context = new AnnotationConfigApplicationContext(DataServiceRunner.class)){
		
			System.out.println("Max for mongo :" + context.getBean(BusinessCalculateService.class).findMax());
		
		}
		
	}

}
