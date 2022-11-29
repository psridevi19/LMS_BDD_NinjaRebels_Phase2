package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import utilities.LoggerClass;
import utilities.ReadConfig;



public class BaseClass {

	protected ReadConfig readconfig = new ReadConfig();
	public String baseUrl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String randomUsername = readconfig.getRandomUsername();
	public static WebDriver driver;
	public static WebDriverWait wait;
	//public static Logger logger;
	
	String br = "chrome";
	
	
	//@Parameters("browser")
	//
	//@BeforeClass
	//public void setup(String br)
	public void setup()
	{
		//logger = (Logger) LogManager.getLogger();
		//PropertyConfigurator.configure("log4j.properties");
		
		System.out.println("*******setup fn *******");
		System.out.println("Chromepath :"+readconfig.getChromePath());
		
		String path = System.getProperty("user.dir");
		if(driver==null)
		{
		if(br.equals("chrome"))
		{
			System.out.println("*******setup fn inside chrome*******");
			System.setProperty("webdriver.chrome.driver", path+readconfig.getChromePath());
			driver = new ChromeDriver();
			System.out.println("*******setup fn inside after chrome driver creation*******");
		}
		else if(br.equals("firefox"))
		{
			System.out.println("Inside firefox");
			System.setProperty("webdriver.gecko.driver", path+readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", path+readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		openUrl(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		System.out.println("*******setup fn completed*******");
		}
	}
	
	public void openUrl(String Url)
	{
		System.out.println("*******openUrl*******");
		//driver.get(Url);
		//driver.get("https://www.google.com/");
		System.out.println("*******openUrl completed*******");
	}
	
	//@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tcName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+ tcName + ".png");
		FileUtils.copyFile(source, target);
		LoggerClass.info("Screenshot taken");
	}
	
}
