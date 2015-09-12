package com.goet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.goet.helper.output.CsvOutputGenerator;

public class App {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CsvOutputGenerator csvOutputGen = (CsvOutputGenerator) context.getBean("CsvOutputGenerator");
		
		if( args.length > 0 ){
			if(args[0] instanceof String )
			csvOutputGen.generateOutput(args[0]);
			else
			 System.out.println(" Please give a valid name in string"); 
		}
		else {
			 System.out.println(" Please Enter city name"); 
		}
		
		context.close();
	}
}
