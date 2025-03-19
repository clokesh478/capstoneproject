package com.elementssteps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.HideShowPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HideShowStepDefinitions {
    WebDriver wd;
    HideShowPage hsp;

    public HideShowStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        hsp = new HideShowPage(wd);
    }

    @Given("I am on the Practice page")
    public void i_am_on_the_practice_page() {
        wd.get("https://www.letskodeit.com/practice");
    }

    @When("I hide the element")
    public void i_hide_the_element() throws InterruptedException{
        hsp.hideElement();
        Thread.sleep(2000);
    }

    @Then("The element should not be visible")
    public void the_element_should_not_be_visible() {
        assertFalse(hsp.isElementVisible(), "The element is still visible!");
    }

    @When("I show the element")
    public void i_show_the_element() throws InterruptedException{
        hsp.showElement();
        Thread.sleep(3000);
    }

    @Then("The element should be visible")
    public void the_element_should_be_visible() {
        assertTrue(hsp.isElementVisible(), "The element is not visible!");
    }

    @When("I enter text {string} in the displayed textbox")
    public void i_enter_text_in_the_displayed_textbox(String text) {
        hsp.enterTextInField(text);
    }

    @Then("I should see the entered text as {string}")
    public void i_should_see_the_entered_text_as(String expectedText) {
        assertEquals(hsp.getEnteredText(), expectedText, "The entered text does not match!");
    }
}
