package com.elementssteps;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.AlertPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertStepDefinitions {
    WebDriver wd;
    AlertPage ap;

    public AlertStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        ap = new AlertPage(wd);
    }

    @Given("User is on the Practice page for alert handling")
    public void user_is_on_the_practice_page_for_alert_handling() {
        wd.get("https://www.letskodeit.com/practice");
    }

    @When("User enters {string} in the alert text field")
    public void user_enters_in_the_alert_text_field(String text) throws InterruptedException{
        ap.enterAlertText(text);
        Thread.sleep(3000);
    }

    @When("User clicks the alert button")
    public void user_clicks_the_alert_button() throws InterruptedException{
        ap.clickAlertButton();
        Thread.sleep(3000);
    }

    @Then("An alert should display the message {string}")
    public void an_alert_should_display_the_message(String expectedAlertText) {
        assertEquals(ap.getAlertText(), expectedAlertText, "Alert message does not match!");
    }
}
