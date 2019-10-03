package com.wp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {

	WebDriver driver;

	@Test(priority = 1)
	public void browser() throws IOException {

		
		 
		String path = System.getProperty("user.dir");
		String genericPath = path + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", genericPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); // global wait will apply on all elements
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}

	@Test(priority=2)
	public void logIn() throws IOException {

		driver.get("https://flipkart.com");
		WebElement element = driver.findElement(By.xpath("(//span[@class=\"nav-action-inner\"])[2]"));
		element.click();
	}

}
