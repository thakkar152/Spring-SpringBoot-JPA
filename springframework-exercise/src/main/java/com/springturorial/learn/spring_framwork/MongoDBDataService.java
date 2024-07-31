package com.springturorial.learn.spring_framwork;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDBDataService implements DataService {

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		int[] mongoData = {1,2,3,4,5};
		return mongoData;
	}

}
