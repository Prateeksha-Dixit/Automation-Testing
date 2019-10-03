package com.wp;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AnnotationTest {
	
	WebDriver driver;
	@Test(priority=1,enabled=false)
	public static void A() {
		
		System.out.println("A");
	}
	@Test(priority=1,enabled=false)
	public static void B() {				//if having same priority then alphabetically test cases will run.
		
		System.out.println("B");
		
	}
	@Test(priority=1,enabled=true)
	public static void C() {
		SoftAssert softAssert=new SoftAssert();
		A();								//In this case three methods will be called but test case would be only one this is used when
		B();								//we want the functionality of a method but dont want it to be a test case.
		System.out.println("C");
		//org.testng.Assert.assertEquals(true, false);  //in hard assertion next statements won't get executed if assertion fails.
		
		softAssert.assertEquals(true, false,"----------Test Fail-----------------"); //in soft assertion next statements would get executed if assertion fails but in this case test case would be passed since this assertion doesn't get executed
		System.out.println("D");			
		softAssert.assertAll();		//to execute soft assert we use assert all.
	}
	
	@Test
	public void javaScript()
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("scroll(0,8000)");
		jse.executeScript("window.open()");
		
	}

}
 