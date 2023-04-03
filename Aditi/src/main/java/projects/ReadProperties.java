package projects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	Properties properties;
	
	
	public ReadProperties()  {
		try {
		FileReader reader=new FileReader("D:\\workspace\\HealthCura\\src\\main\\java\\projects\\configuring.properties");
		properties =new Properties();
		properties.load(reader);
		}
		catch(Exception e) {
			System.out.println(e);
		}
     

	}
	
	
	
	public String getUrl()
	{
		return  properties.getProperty("url");
	}
	
	
	
	public String getBrowser()
	{
		return  properties.getProperty("browser");
	}
	
	
	public String getUsername()
	{
		return  properties.getProperty("username");
	}
	
	
	
	
	public String getPassword()
	{
		return  properties.getProperty("password");
	}

}
