package com.rahulshetty.ecommerce.pageobjects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rahulshetty.ecommerce.abstractcomponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="input[type='email']")
	WebElement login_email;
	@FindBy(css="input[type='password']")
	WebElement login_password;
	@FindBy(css="input[type='submit']")
	WebElement login_button;
	
	public PrdocutCatalog loginToApplication(HashMap<String, String> map) {
		login_email.sendKeys(map.get("email"));
		login_password.sendKeys(map.get("password"));
		login_button.click();
		return new PrdocutCatalog(driver);
	}
	public PrdocutCatalog loginToApplication(String email, String password) {
		login_email.sendKeys(email);
		login_password.sendKeys(password);
		login_button.click();
		return new PrdocutCatalog(driver);
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}

}
