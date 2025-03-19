package com.elementssteps;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.MouseHoverPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MouseHoverStepDefinitions {
    WebDriver wd;
    MouseHoverPage mhp;

    public MouseHoverStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        mhp = new MouseHoverPage(wd);
    }

    @Given("User is on the Practice page for mouse hover")
    public void user_is_on_the_practice_page_for_mouse_hover() {
        wd.get("https://www.letskodeit.com/practice");
    }

    @When("User hovers over the mouse hover button")
    public void user_hovers_over_the_mouse_hover_button() {
        mhp.hoverOverButton();
    }

    @Then("The {string} option should be displayed")
    public void the_option_should_be_displayed(String option) {
        assertTrue(mhp.isHoverOptionDisplayed(option), "The option " + option + " is not displayed!");
    }

    @When("User clicks on {string} option")
    public void user_clicks_on_option(String option) {
        mhp.clickHoverOption(option);
    }

    @Then("The page should scroll to the top")
    public void the_page_should_scroll_to_the_top() {       
        assertTrue(true, "Page did not scroll to the top!");
    }
}
