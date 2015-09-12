package com.goet.service.impl;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.goet.model.Place;
import com.goet.service.DataParser;
import com.goet.service.utils.ApplicationParser;

@Service
public class DataParserImpl implements DataParser{

	Logger logger = Logger.getLogger(DataParserImpl.class.getName());
	
	/**
	 *  Get all places;
	 */
	public Place[] getPlaces(String jsonStringInput) {
		
		Place[] places = null; 
		try {
			
			places =  ApplicationParser.mapper.readValue(jsonStringInput, Place[].class);
			logger.info("Data Parsed Successfully");
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return places;
	}

	
}
