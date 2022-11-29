package utilities;

import org.openqa.selenium.WebDriver;

import base.BaseClass;
import pageObjects.PageObjectManager;

public class ContextUI extends BaseClass {

	private PageObjectManager pageObjectManager;
	
	public ContextUI()
	{
		System.out.println("********ContextUI**********");
		setup();
		pageObjectManager = new PageObjectManager(driver);
		
	}
	
	public WebDriver getDriver()
	{
		return driver;
	}
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}
	
	public ReadConfig getReadConfig()
	{
		return readconfig;
	}
}
