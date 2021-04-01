package com.Stream;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaExecutor {

	@Test
	public void validateJavaExecuteor() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		List<WebElement> listofLinks = driver.findElements(By.tagName("a"));
		listofLinks
				.stream()
				.filter(t->t.getAttribute("href")!=null)
				.forEach(t -> { 
					
					System.out.println("Text" +t.getText());
					System.out.println("Href" + t.getAttribute("href"));
					
				
				
				});

	}
}
