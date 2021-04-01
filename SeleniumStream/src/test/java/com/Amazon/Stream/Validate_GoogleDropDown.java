package com.Amazon.Stream;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate_GoogleDropDown {

	@Test
	public void validateGoogleDrpDwnByLamda() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
	
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("Google11", driver.getTitle());
	
	//	Assert.assertEquals("Google44", driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(d -> driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).isDisplayed());
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("java");
	
		
		softAssert.assertEquals("Google22", driver.getTitle());
	
		Predicate<WebElement> searchValue = t->t.getText().contains("download");
		wait.until(d -> driver.findElement(By.xpath("//li[@class='sbct']//div//div//div//span")).isDisplayed());
			
		List<WebElement> searchList = driver.findElements(By.xpath("//li[@class='sbct']//div//div//div//span"));
		searchList.forEach(t->System.out.println(t.getText()));
		WebElement first = searchList
				.stream()
				.filter( searchValue)
				.findFirst()
				.get();
				
		first.click();
		softAssert.assertEquals("Google3", driver.getTitle());
		
	driver.findElement(By.xpath("//a[contains(text(),'Books')]")).click();;
		
		softAssert.assertAll();
	}

}
