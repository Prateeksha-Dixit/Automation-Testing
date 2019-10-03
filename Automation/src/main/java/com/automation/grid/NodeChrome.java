package com.automation.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class NodeChrome {
	
	WebDriver driver;
	String nodeUrl;
	
	@Test
	public void setUp_Chrome() throws MalformedURLException{
		
		nodeUrl="http://192.168.17.1:4444/wd/hub";
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		driver=new RemoteWebDriver(new URL(nodeUrl),capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //global wait will apply on all elements
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://google.com");
	}

}
