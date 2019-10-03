package com.wp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class Flipkart {
	
	WebDriver driver;
	@Test(priority = 1)
	public void browser()
	{
		String path=System.getProperty("user.dir");
		String genericPath=path+"\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", genericPath);
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //global wait will apply on all elements
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@Test(priority = 2)
	public void cart() throws Exception
	{
		driver.get(GetConfig.getData("Environment"));
		WebElement element=driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		//element.sendKeys("8305542842");
		/*
		 * driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(
		 * "prakharfanse");
		 * driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		 */
		//driver.findElement(By.xpath("//a[@class=\"_3ko_Ud\"]")).click();
		
		/*
		 * Actions action =new Actions(driver); 
		 * Action build=action.moveToElement(element).keyDown(Keys.SHIFT).sendKeys("8305542842"
		 * ).keyUp(Keys.SHIFT).build(); //to perform mouse and keyboard actions we use
		 * these classes. build.perform();
		 */
		
		 Actions action =new Actions(driver);
		 element=driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		 Action build=action.click(element).build();
		 build.perform();
		
		
	}
	
	@Test(priority = 3)
	public void sikuliMethod() throws Exception
	{
		Screen screen= new Screen();
		Pattern searchBox= new Pattern("C:\\Users\\Prateeksha Dixit\\Desktop\\search.png");
		screen.type(searchBox,"Book");
		
		//WebDriverWait
		//wait.until
	}
	
	/*
	 * @Test public void popup() {
	 * 
	 * driver.get("Your page url");
	 * driver.findElement(By.xpath("//button")).click();
	 * 
	 * Alert alert=driver.switchTo().alert();
	 * 
	 * //multiple actions on pop up
	 * 
	 * alert.accept(); alert.dismiss(); alert.getText(); alert.sendKeys("hiii"); }
	 */
	
	@Test
	public void javaScript()
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("scroll(0,8000)");
		jse.executeScript("window.open()");
		
	}
	
}
