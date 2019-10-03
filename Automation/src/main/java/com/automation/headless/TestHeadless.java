package com.automation.headless;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestHeadless {
	
	  WebDriver driver;
	  
	  @Test(priority=1) public void HeadlessChrome_Test_1() {
	  
	  String path=System.getProperty("user.dir"); String
	  genericPath=path+"\\drivers\\chromedriver.exe";
	  System.setProperty("webdriver.chrome.driver", genericPath);
	  
	  ChromeOptions cOptions=new ChromeOptions(); cOptions.setHeadless(true);
	  driver=new ChromeDriver();
	  
	  driver.get("http://google.com"); String title=driver.getTitle();
	  System.out.println(title); }
	 

	
}
