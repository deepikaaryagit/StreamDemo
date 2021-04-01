package com.Amazon.Stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	@Test
	public void validateWindows()
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent Window Handle " + parentWindowHandle);
		Set<String> s=driver.getWindowHandles();
		
	//	s.stream().forEach(w->driver.switchTo().window(w));
		
		
	//	s.stream().forEach(i -> {
	//	     driver.switchTo().window(i);
	//	     System.out.println("Title  " + driver.getTitle());
	//	});
		
		//driver.close();
		//driver.quit();
		Assert.assertEquals("Amazon",driver.getTitle() );
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		long workinglinks = 
				linkList
				.stream()
				.filter(l->l.getAttribute("href")==null)
				.count();
				//.collect(Collectors.toList());
		
		
		System.out.println(workinglinks);
		
		
		}
	}

