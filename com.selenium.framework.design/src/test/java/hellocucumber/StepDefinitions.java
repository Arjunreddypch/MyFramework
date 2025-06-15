package hellocucumber;

import java.io.IOException;

import org.testng.internal.BaseClassFinder;

import com.rahulshetty.ecommerce.abstractcomponents.BaseTest;

import io.cucumber.java.en.*;

public class StepDefinitions extends BaseTest{

	@Given("today is Sunday")
	public void today_is_sunday() throws IOException {
	   System.out.println("Hello");
	   launchApplication();
	}

	@When("I ask whether it's Friday yet")
	public void i_ask_whether_it_s_friday_yet() {
	    System.out.println("hi");
	}

	@Then("I should be told {string}")
	public void i_should_be_told(String string) {
	    System.out.println(string);
	}
}
