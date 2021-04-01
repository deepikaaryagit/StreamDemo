package com.Stream;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidatesortedDropDown {

	
	
	@Test
	public void validateSortingonDrpDwn() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Live Posting")).click();
		Thread.sleep(3000);
		List<WebElement>  li = driver.findElements(By.xpath("//div[@class='jq-selectbox__dropdown']"));
		li.forEach(l->System.out.println(l.getText()));
		
	}
}
