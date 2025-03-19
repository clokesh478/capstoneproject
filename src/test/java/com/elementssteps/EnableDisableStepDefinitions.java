package com.elementssteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.EnableDisablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EnableDisableStepDefinitions {
    WebDriver wd;
    EnableDisablePage edp;

    public EnableDisableStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        edp = new EnableDisablePage(wd);
    }

    @Given("User navigates to {string} for enable-disable field")
    public void user_navigates_to_for_enable_disable_field(String url) {
        wd.get(url);
    }

    @When("User clicks on disable button")
    public void user_clicks_on_disable_button() {
        edp.disableField();
    }

    @Then("The field should be disabled")
    public void the_field_should_be_disabled() {
        assertTrue(edp.isFieldDisabled(), "The field is not disabled!");
    }

    @When("User clicks on enable button")
    public void user_clicks_on_enable_button() {
        edp.enableField();
    }

    @Then("The field should be enabled")
    public void the_field_should_be_enabled() {
        assertTrue(edp.isFieldEnabled(), "The field is not enabled!");
    }

    @When("User enters {string} in the enabled field")
    public void user_enters_in_the_enabled_field(String text) throws InterruptedException {
        edp.enterTextInField(text);
        Thread.sleep(3000);
    }

    @Then("The entered text should be {string}")
    public void the_entered_text_should_be(String expectedText) {
        assertEquals(edp.getEnteredText(), expectedText, "The entered text does not match!");
    }
}
