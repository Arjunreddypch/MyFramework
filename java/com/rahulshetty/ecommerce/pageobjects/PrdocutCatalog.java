package com.rahulshetty.ecommerce.pageobjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rahulshetty.ecommerce.abstractcomponents.AbstractComponents;

public class PrdocutCatalog extends AbstractComponents{
	
	WebDriver driver;
	WebElement element;
	public PrdocutCatalog(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='card-body']/h5/b1")
	List<WebElement> product_catalog_list_products;
	By product_catalog_button_addToCart=By.xpath("//div[@class='card-body']/h5/b/following::button[contains(text(),'Add To Cart')]");
	By product_catalog_list_of_items=By.xpath("//div[@class='card-body']/h5/b");
	
	public void addItemToCart(HashMap<String, String> map) {
		waitforVisibilityOfElementLocated(product_catalog_list_of_items);
		element=product_catalog_list_products.stream().filter(product->product.getText().contains(map.get("item"))).findFirst().orElse(null);
		element.findElement(product_catalog_button_addToCart).click();
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
	}

}
