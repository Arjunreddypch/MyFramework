package com.rahulshetty.ecommerce.abstractcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rahulshetty.ecommerce.pageobjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractComponents {
	
	public WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void waitforVisibilityOfElementLocated(By Locator) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}
	
	public WebDriver initializeDriver(WebDriver driver) throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//com//rahulshetty//ecommerce//resources//GlobalVariables");
		Properties properties=new Properties();
		properties.load(fis);
		String browser=properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		}
		else if(browser.equalsIgnoreCase("Firefox")){
			//firefox setup
		}
		else if(browser.equalsIgnoreCase("Edge")){
			//Edge setup
		}
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
	}
	
		public LoginPage launchApplication() {
			
			LoginPage login=new LoginPage(driver);
			login.goTo();
			return new LoginPage(driver);
		}



		

}
