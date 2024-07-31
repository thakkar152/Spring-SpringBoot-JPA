package com.springturorial.learn.spring_framwork;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Qualifier("MySQLDataServiceQualifier")
public class MySQLDataService implements DataService{

	@Override
	public int[] retrieveData() {
		// TODO Auto-generated method stub
		int[] mysqlData = {9,10,11,12};
		return mysqlData;
	}

}
