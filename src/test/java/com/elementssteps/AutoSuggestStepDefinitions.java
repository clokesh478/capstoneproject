package com.elementssteps;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.AutoSuggestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AutoSuggestStepDefinitions {
    WebDriver wd;
    AutoSuggestPage asp;

    public AutoSuggestStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        asp = new AutoSuggestPage(wd);
    }

    @Given("User navigates to {string} for auto suggest")
    public void user_navigates_to_for_auto_suggest(String url) {
        wd.get(url);
    }

    @When("User types {string} in the auto suggest box")
    public void user_types_in_the_auto_suggest_box(String text) {
        asp.typeInAutoSuggest(text);
    }

    @Then("The suggestion {string} should be displayed")
    public void the_suggestion_should_be_displayed(String expectedSuggestion) {
        assertTrue(asp.isSuggestionDisplayed(expectedSuggestion), 
                  "Expected suggestion '" + expectedSuggestion + "' was not displayed!");
    }
}
