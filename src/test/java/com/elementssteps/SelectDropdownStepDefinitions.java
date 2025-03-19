package com.elementssteps;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.SelectDropdownPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SelectDropdownStepDefinitions {
    WebDriver wd;
    SelectDropdownPage sdp;
    String selectedValue;

    public SelectDropdownStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        sdp = new SelectDropdownPage(wd);
    }

    @Given("User navigates to {string} for dropdown selection")
    public void user_navigates_to_for_dropdown_selection(String url) {
        wd.get(url);
    }

    @When("User selects {string} from the dropdown")
    public void user_selects_from_the_dropdown(String option) {
        sdp.selectDropdownOption(option);
        selectedValue = sdp.getSelectedDropdownValue();
    }

    @Then("The selected dropdown value should be {string}")
    public void the_selected_dropdown_value_should_be(String expectedValue) {
        assertEquals(selectedValue, expectedValue, "The selected dropdown value is incorrect!");
    }
}
