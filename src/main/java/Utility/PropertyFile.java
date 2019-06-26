package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	public static Properties prop;
	
	public Properties getProperty() throws IOException
	{
		FileInputStream inputStream=null;
        prop = new Properties();
        try {        	 
            prop.load(new FileInputStream("resources/config.properties"));
            //properties.load(new FileInputStream("resources/testdata-config.properties"));
        } catch (Exception e) {
            System.out.println("Exception: " + e);
       } 
         return prop;	
	}
}	

