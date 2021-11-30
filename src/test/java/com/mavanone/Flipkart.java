package com.mavanone;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class Flipkart {
	static WebDriver driver;
	static  long startTime;
	@BeforeClass 
	public static void lanch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@AfterClass
	public static void quit() {
		System.out.println("after class");
//		driver.quit();
	}
	
	
	@Before
	public void startTime() {
		System.out.println("before  class");
		long startTime = System.currentTimeMillis();
		
	}
	
	
	@After
	public void endTime() {
		System.out.println("after method");
	long endTime = System.currentTimeMillis();
	long ee = endTime - startTime;
	System.out.println("Time taken :"+ee);
	}
	@Test
	public void Login() {
		
		try {
			
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
		button.isDisplayed();
		button.click();
		
		}
		catch (Exception e) {
			System.out.println("pop up is not dispaly");
			
		}
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("mobiles",Keys.ENTER);
	}
	
		static String MobileName;
		@Test
		
		
		public void test2() throws InterruptedException{
			
		
		
		Thread.sleep(2000);
		WebElement mobileName = driver.findElement(By.xpath("(//div[contains(text(),'realme Narzo 50A')])[1]"));
		MobileName = mobileName.getText();
		System.out.println(MobileName);
		mobileName.click();
		
		}
		
	
	
	@Test
	public void test3() {
		
		
		String parentURL = driver.getWindowHandle();
		Set<String> childURL = driver.getWindowHandles();
		for(String child : childURL) {
			
			
			if(!parentURL.equals(child)) {
				
				
				driver.switchTo().window(child);
			}
		}
	}
		@Test
		public void test4() {
			
			
		WebElement newMobileName = driver.findElement(By.xpath("(//span[contains(text(),'realme')])[1]"));
		

	String newMobile = newMobileName.getText();
		System.out.println(newMobile);
	Assert.assertTrue(newMobile.equals(MobileName));
		}
	

		
	}
