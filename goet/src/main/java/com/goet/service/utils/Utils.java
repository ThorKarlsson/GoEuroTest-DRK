package com.goet.service.utils;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

	public static String getResourcePath() {
	    try {
	    	
	        
	    	/*InputStream in = System.class.getResourceAsStream("/places.csv");
	    	
	        URI resourcePathFile = System.class.getResource("/RESOURCE_PATH").toURI();
	        
	        System.out.println("get path : "+resourcePathFile.getPath()); 
	        String resourcePath = Files.readAllLines(Paths.get(resourcePathFile)).get(0);
	        URI rootURI = new File("").toURI();
	        URI resourceURI = new File(resourcePath).toURI();
	        URI relativeResourceURI = rootURI.relativize(resourceURI);
	        return relativeResourceURI.getPath();*/
	        
	        String workingDir = System.getProperty("user.dir");
	        return workingDir;
	        
	    } catch (Exception e) {
	        return null;
	    }
	   
	}
	
	public static File getNewFile(){
		File file = new File(getResourcePath()+File.pathSeparator+System.currentTimeMillis()+".csv");
		return file;
	}
}
