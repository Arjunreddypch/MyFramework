package com.rahulshetty.ecommerce.abstractcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahulshetty.ecommerce.pageobjects.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.With;

public class BaseTest {

	public WebDriver driver;

	public LoginPage login;

	public void waitforVisibilityOfElementLocated(By Locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public WebDriver initializeDriver() throws IOException {
		System.out.println(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//test//java//com//rahulshetty//ecommerce//resources//GlobalVariables.properties");
		Properties properties = new Properties();
		properties.load(fis);
		System.out.println(System.getProperty("browser"));
		String browser = System.getProperty("browser")!=null?System.getProperty("browser"):properties.getProperty("browser");
		if (browser.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if(browser.contains("chromeheadless")) {
				options=new ChromeOptions();
				options.addArguments("headless");
				options.addArguments("start-maxmized");
			}
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1440, 900));
//			System.setProperty("webdriver.chrome.driver",
//					"C://Users//dines//Downloads//Arjun Dubai//chromedriver-win32//chromedriver.exe");
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gheko.driver", 
					".//com.selenium.framework.design//drivers//geckodriver.exe");
			driver =new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			// Edge setup
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
	}

	@BeforeMethod()
	public LoginPage launchApplication() throws IOException {
		driver = initializeDriver();
		login = new LoginPage(driver);
		login.goTo();
		return login;
	}

	@AfterMethod()
	public void teadDown() {
		driver.close();
	}

	// this is one way

	/*
	 * @DataProvider public Object[][] getData() {
	 * 
	 * HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
	 * "nagarjuna.pc9@gmail.com"); map.put("password", "#Arjun789"); map.put("item",
	 * "ZARA COAT 3"); Object[][] obj = new Object[][] { { map, map } }; return obj;
	 * }
	 */

	// ** this data provider using external source

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> list = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//com//rahulshetty//ecommerce//data//Data.json");

		Object[][] obj = new Object[][] { { list.get(0) }, { list.get(1) } };
		return obj;
	}

	public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {

		String jsonConent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonConent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png"));
		
		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
		
	}
	
}
