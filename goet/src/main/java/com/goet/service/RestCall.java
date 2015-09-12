package com.goet.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

public interface RestCall {


	/**
	 * 
	 * @param param
	 * @return
	 */
	public String callPlacesGetApi(String param) ;
}
