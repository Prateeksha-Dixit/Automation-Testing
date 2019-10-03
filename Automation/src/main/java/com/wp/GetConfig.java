package com.wp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetConfig {
	
	public static String getData(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream(new File("P:\\Spring Projects\\Automation\\config.properties"));
		
		Properties prop=new Properties();
		prop.load(fis);
		String env=prop.getProperty(key);
		
		return env;
		
	}

}
