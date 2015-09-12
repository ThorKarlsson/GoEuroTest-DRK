package com.goet.service;


import com.goet.model.Place;

public interface DataParser {

	/**
	 * Get list of all place 
	 * @param jsonStringInput
	 * @return
	 */
	public Place[] getPlaces(String jsonStringInput) ;
}
