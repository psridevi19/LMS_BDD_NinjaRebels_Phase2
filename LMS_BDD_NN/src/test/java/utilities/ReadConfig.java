package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./src/test/resources/Configs/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception is "+e.getMessage());
		} 
	}
	
	public String getApplicationURL() {
		System.out.println("In getApplicationURL");
		String url = pro.getProperty("baseurl");
		System.out.println("In getApplicationURL : "+url);
		return url;
	}
	
	public String getUsername() {
		System.out.println("In getUsername");
		String username = pro.getProperty("username");
		return username;
	}
	
	public String getRandomUsername() {
		String rUsername = pro.getProperty("randomusername");
		return rUsername;
	}
	
	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chrome = pro.getProperty("chromePath");
		return chrome;
	}
	
	public String getFireFoxPath() {
		String fireFox = pro.getProperty("firefoxPath");
		return fireFox;
	}
	public String getEdgePath() {
		String edge = pro.getProperty("edgePath");
		return edge;
	}
}
