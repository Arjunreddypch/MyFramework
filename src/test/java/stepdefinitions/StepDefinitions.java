package stepdefinitions;

import java.io.IOException;

import com.rahulshetty.ecommerce.abstractcomponents.BaseTest;
import com.rahulshetty.ecommerce.pageobjects.LoginPage;
import com.rahulshetty.ecommerce.pageobjects.PrdocutCatalog;

import io.cucumber.java.en.*;

public class StepDefinitions extends BaseTest{

		public LoginPage login;
		public PrdocutCatalog productCatalog;
		@Given("the user logs in with username {string} and password {string}")
	public void the_user_logs_in_with_username_and_password(String string, String string2) throws IOException {
		
		login=launchApplication();
		login.goTo();
		productCatalog=login.loginToApplication(string,"#"+string2);
	}


	@When("the user selects the {string} from search results")
	public void the_user_selects_the_from_search_results(String string) {
		productCatalog.addItemToCart(string);
	}


	@Then("the shopping cart should contain {string}")
	public void the_shopping_cart_should_contain(String string) {
		System.out.println(string);
		driver.quit();
	}
}
