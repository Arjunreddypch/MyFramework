package com.rahulshetty.ecommerce.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("nagarjuna.pc9@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("#Arjun789");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		List<WebElement> itemNames=driver.findElements(By.xpath("//div[@class='card-body']/h5/b"));
		
		WebElement item=itemNames.stream().filter(product->product.getText().contains("ZARA COAT 3")).findFirst().orElse(null);
		item.findElement(By.xpath("//div[@class='card-body']/h5/b/following::button[contains(text(),'Add To Cart')]")).click();
	}
}
