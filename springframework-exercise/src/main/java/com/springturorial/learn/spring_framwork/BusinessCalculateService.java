package com.springturorial.learn.spring_framwork;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculateService {
	
	private DataService ds;
	
	public BusinessCalculateService(DataService ds) {
		this.ds = ds;
	}
	
	public int findMax() {
		return Arrays.stream(ds.retrieveData()).max().orElse(0);
	}

}
