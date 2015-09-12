package com.goet.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goet.model.Place;
import com.goet.service.OutPutService;
import com.goet.service.utils.Utils;

@Service
public class CsvOutPutServiceImpl implements OutPutService{

	Logger logger = Logger.getLogger(CsvOutPutServiceImpl.class.getName());

	
	@Autowired
	RestCallImpl restCallImpl;
	
	@Autowired
	DataParserImpl dataParserImpl;
	
	public void generateOutput(String cityName) {
		
		File file = Utils.getNewFile();
		try {
			String jsonText = restCallImpl.callPlacesGetApi(cityName);
			
			Place[] p = dataParserImpl.getPlaces(jsonText);
			FileWriter writer = new FileWriter(file);
			
			if( p != null ){
				if( p.length > 0 ){
					
					for( int i = 0; i < p.length ; i++){
						
						writer.append(String.valueOf(p[i].get_id()));
						writer.append(",");
						writer.append(p[i].getName());
						writer.append(",");
						writer.append(  ( p[i].getType() == null )? "" :  p[i].getType() );
						writer.append(",");
						writer.append(String.valueOf(p[i].getGeo_position().getLatitude()));
						writer.append(",");
						writer.append(String.valueOf(p[i].getGeo_position().getLongitude()));
						writer.append('\n');
						
					}
					
				}
			}
			writer.flush();
			writer.close();
			
			logger.info("CSV file Generated");
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
