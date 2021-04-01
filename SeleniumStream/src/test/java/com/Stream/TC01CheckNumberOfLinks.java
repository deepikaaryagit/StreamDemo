package com.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC01CheckNumberOfLinks {

	@Test
	@Parameters({"browser", "url" })
	public void validateLinks(String browser , String url) throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		System.out.println(" Parameters coming from testNg xml : " + browser   + " parameter URL : " + url);
		driver.manage().window().maximize();
		//driver.get("https://amazon.com");
		driver.get("https://demo.nopcommerce.com/");
		Set<String> winHand = driver.getWindowHandles();
		
		winHand.forEach(w->System.out.println("Set of Window Handle :" + w.toString()));
				
		
	//	driver.get("https://a657480:Apassword%4022@eppportal-test.kp.org/");
		
	//	JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.open()");
		//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//driver.switchTo().window(tabs.get(1));
		
		//driver.get("https://a657480:Apassword%4022@eppportal-test.kp.org/");
		//Thread.sleep(5000);
	//	driver.navigate().refresh();
		
		
		//Get Text
		
		WebElement srcBoxText = driver.findElement(By.id("small-searchterms"));
		System.out.println("Search Text Box Text :" + srcBoxText.getAttribute("placeholder"));
		
		List<WebElement> listOfLinks = new ArrayList<>();
		listOfLinks = driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		long numLinks = listOfLinks
					.stream()
					.count();
					//.forEach(li->System.out.println(" All a links :  " + li.getText()  + "Link TagName" + li.getTagName()));
		
		
		System.out.println("Total Number of Links: " + numLinks);
		
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Nike");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> searchProductList = driver.findElements(By.xpath("//h2[@class='product-title']"));
		searchProductList
						.stream()
						.forEach(l->System.out.println("Product List : " + l.getText()));
		
		
		
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='priqce actual-price']"));
		priceList
						.stream()
						.forEach(l->System.out.println("Price : " + l.getText()   + l.getTagName()));
		
		
		//Drop Down
		
		WebElement sortBywe= driver.findElement(By.id("products-orderby"));
		Select sortByDropDown = new Select(sortBywe);
		sortByDropDown.selectByVisibleText("Price: Low to High");
		
		
	
	}
	
}
