package com.wp;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlipKart2 {

	WebDriver driver;
	@BeforeTest
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
	public void login() throws Exception
	{
		driver.get(GetConfig.getData("Environment"));
		
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\Prateeksha Dixit\\Desktop\\Book2.xlsx"));
		XSSFWorkbook  workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		XSSFRow row=sheet.getRow(0);
		String password=row.getCell(0).getStringCellValue();
		
		WebElement element=driver.findElement(By.xpath("(//input[@type=\"text\"])[2]"));
		Actions action=new Actions(driver);
		Action build=action.moveToElement(element).sendKeys("8305542842").build();
		build.perform();
		
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(password);;
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		workbook.close();
	}
	
	@Test(priority = 3)
	public void sikuliMethod() throws Exception
	{
		Screen screen= new Screen();
		Pattern searchBox= new Pattern("C:\\Users\\Prateeksha Dixit\\Desktop\\search.png");
		screen.type(searchBox,"mobiles"+Key.ENTER);
		driver.findElement(By.xpath("(//div[@class=\"_3wU53n\"])[1]")).click();
		ArrayList<String> newTab=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(newTab.get(1));
		driver.findElement(By.xpath("//button[@class=\"_2AkmmA _2Npkh4 _2MWPVK\"]")).click();
		Thread.sleep(5);
		driver.findElement(By.xpath("//button[@class=\"_2AkmmA iwYpF9 _7UHT_c\"]")).click();
		
		
		
		
	}
	
	@AfterTest
	public void closeDriver() {
		
		driver.quit();
	}
	
}
