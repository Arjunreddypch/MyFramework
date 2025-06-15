package com.rahulshetty.ecommerce.pageobjects;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.rahulshetty.ecommerce.abstractcomponents.BaseTest;
import com.rahulshetty.ecommerce.abstractcomponents.Retry;

public class StandAloneTestSample2 extends BaseTest {
	
	
	@Test(dataProvider = "getData")
	public void addItemToCart(HashMap<String, String> map) throws IOException, InterruptedException {
		
		
		login.goTo();
		PrdocutCatalog productcatalogpage = login.loginToApplication("","");
		productcatalogpage.addItemToCart(map);
	}
}
