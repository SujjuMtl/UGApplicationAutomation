package com.asu.esid.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile
{
	Properties prop;
	File file = new File("C:\\Development\\ASUEnrollmentServices\\Automation\\config.properties");
	FileInputStream fileInput = null;
	
	public ReadPropertyFile() throws IOException
	{
		fileInput = new FileInputStream(file);
		prop = new Properties();
		
		prop.load(fileInput);
	}
	
	public String getProperty(String arg)
	{
		return prop.getProperty(arg);
	}

	public void setProperty(String arg)
	{
		
	}
}
