package utility;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class ConnectionManager{
	public static Connection getConnection() throws Exception 
	{
		Properties prop=loadPropertiesFile();
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		Class.forName(driver);
		Connection con=null;
		con=DriverManager.getConnection(url,username,password);
		if(con!=null)
		{
			System.out.println("connection established");
			
		}
		else{
			System.out.println("connection ");
			
		}
		
		
		
		return con;
		
		
	 	
		
	}
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
	
}



