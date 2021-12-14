package com.flipkart.stepdefinition;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps {
	static WebDriver driver; 
	static String Mobilename;
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		
		System.out.println("lanunch");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	

	@Given("user login by entering crendentials")
	public void user_login_by_entering_crendentials() {
	  
try {
			
			WebElement button = driver.findElement(By.xpath("//button[text()='✕']"));
	          button.isDisplayed();
		button.click();
		
		}
		catch (Exception e) {
			System.out.println("pop up is not dispaly");
			
		}
	}

	@When("user search mobile")
	public void user_search_mobile() {
		Mobilename ="realme";
		WebElement searchBar = driver.findElement(By.name("q"));
		searchBar.sendKeys("realme",Keys.ENTER);
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() {
		
		WebElement mobile = driver.findElement(By.xpath("(//div[contains(text(),'"+Mobilename+"')])[1]"));
		mobile.click();
	  

	}

	@Then("user click on add to cart")
	public void user_click_on_add_to_cart() {
		
String parentURL = driver.getWindowHandle();
		
		Set<String> childURL = driver.getWindowHandles();
		for(String child : childURL) {
			
			if(!parentURL.equals(child)) {
			
				driver.switchTo().window(child);
				}
		}
		
		WebElement atc1 = driver.findElement(By.xpath("//span[text()='Cart']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",atc1);
		
	  atc1.click();
	  driver.quit();
	}
	@When("user search mobile by one dim list")
	public void user_search_mobile_by_one_dim_list(DataTable dataTable) {
	List<String> asList = dataTable.asList(String.class);
	
	WebElement searchbar = driver.findElement(By.name("q"));
	searchbar.sendKeys(asList.get(1),Keys.ENTER);
	Mobilename = asList.get(1);
	
	}

	@When("user search mobile by one dim map")
	public void user_search_mobile_by_one_dim_map(io.cucumber.datatable.DataTable dataTable) {
	Map<String,String> asMap = dataTable.asMap(String.class,String.class);
	
		WebElement searchbar = driver.findElement(By.name("q"));
		searchbar.sendKeys(asMap.get("1"),Keys.ENTER);
		Mobilename = asMap.get("1");
	
	}

@When("user search mobile{string}")
public void user_search_mobile(String mobile) {
	WebElement searchbar = driver.findElement(By.name("q"));
	searchbar.sendKeys(mobile,Keys.ENTER);
	Mobilename = mobile;
}


}
