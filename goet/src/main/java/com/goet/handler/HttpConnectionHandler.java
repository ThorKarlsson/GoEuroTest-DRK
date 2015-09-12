package com.goet.handler;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

@Component("HttpConnectionHandler")
public class HttpConnectionHandler {

	public static final String PLACES_GET_URL = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	public CloseableHttpClient getHttpConnection(){
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		return httpClient;
	}
	
	public HttpGet requestGetObject(String url){
		
		HttpGet httpGet = new HttpGet(url);
		return httpGet;
	}
}
