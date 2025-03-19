package com.elementssteps;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.WebTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTableStepDefinitions {
    WebDriver wd;
    WebTablePage wtp;

    public WebTableStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        wtp = new WebTablePage(wd);
    }

    @Given("User is on the Practice page for web table")
    public void user_is_on_the_practice_page_for_web_table() {
        wd.get("https://www.letskodeit.com/practice");
    }

    @When("User checks the price of {string}")
    public void user_checks_the_price_of(String courseName) {
        
    }

    @Then("The price should be {string}")
    public void the_price_should_be(String expectedPrice) {
        assertEquals(wtp.getWebTablePrice(), expectedPrice, "Price does not match!");
    }
}
