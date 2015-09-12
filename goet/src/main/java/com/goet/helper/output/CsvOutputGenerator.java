package com.goet.helper.output;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goet.service.impl.CsvOutPutServiceImpl;

@Component("CsvOutputGenerator")
public class CsvOutputGenerator implements IOutputGenerator {

	@Autowired
	CsvOutPutServiceImpl csvOutPutServiceImpl;
	
	public void generateOutput(String cityName) {
		
		csvOutPutServiceImpl.generateOutput(cityName);
	}

}
