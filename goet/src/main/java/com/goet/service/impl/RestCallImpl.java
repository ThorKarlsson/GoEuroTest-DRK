package com.goet.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goet.handler.HttpConnectionHandler;
import com.goet.service.RestCall;

@Service
public class RestCallImpl implements RestCall {

	Logger logger = Logger.getLogger(RestCallImpl.class.getName());
	
	@Autowired
	HttpConnectionHandler httpConnectionHandler;
	
	public String callPlacesGetApi(String cityName) {
		
		StringBuffer response = new StringBuffer();
		String url = getUrlWithParam(cityName);
		try{
			
			CloseableHttpClient client = httpConnectionHandler.getHttpConnection();
			HttpGet httpGet = httpConnectionHandler.requestGetObject(url);
			CloseableHttpResponse httpResponse = client.execute(httpGet);
			 
			BufferedReader reader = new BufferedReader(new InputStreamReader(
	                httpResponse.getEntity().getContent()));
	
	        String inputLine;
	        while ((inputLine = reader.readLine()) != null) {
	            response.append(inputLine);
	        }
	        reader.close();
	        client.close();
		}
		catch(ClientProtocolException e){
			e.printStackTrace();
		}
		catch (IOException e) { 
			e.printStackTrace();
		}
		
		return response.toString();
	}

	private String getUrlWithParam(String cityName){
		String url = HttpConnectionHandler.PLACES_GET_URL;
		StringBuffer urlBuffer =  new StringBuffer(url);
		urlBuffer.append(cityName);
		return urlBuffer.toString();
	}
	
	
}
