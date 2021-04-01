package com.Stream;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitTest {
	
	
	@Test
	public void validateWait()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMillis(5000));
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
		
		driver.get("https://facebook.com");
		
		driver.findElement(By.name("email")).sendKeys("Deepika");
				
		WebDriverWait wait = new WebDriverWait(driver, 3000);
		wait.until(d->driver.findElement(By.name("pass")).isDisplayed());
		driver.findElement(By.name("pass")).sendKeys("Mypassword");
		
	}

}
