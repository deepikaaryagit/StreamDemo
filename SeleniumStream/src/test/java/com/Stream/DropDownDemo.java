package com.Stream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {
	
	@Test
public void validateDropDown() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//List<WebElement> countryDrp = driver.findElements(By.xpath("//option"));
		//countryDrp.forEach(c-> System.out.println(c.getText()));
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		List<WebElement> ul = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']")) ;
		long size = ul.stream().count();
		System.out.println("Size : " + size);
		ul.forEach(l-> System.out.println("list : " + l.getText()));
		
	}	

}
