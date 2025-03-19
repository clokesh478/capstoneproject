package com.elementssteps;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.CheckBoxPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckBoxStepDefinitions {
    WebDriver wd;
    CheckBoxPage cbp;

    public CheckBoxStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        cbp = new CheckBoxPage(wd);
    }

    @Given("User navigates to {string} for checkbox")
    public void user_navigates_to_for_checkbox(String url) throws InterruptedException {
        wd.get(url);
        Thread.sleep(1000);
    }

    @When("User selects {string} from the checkbox options")
    public void user_selects_from_the_checkbox_options(String option) throws InterruptedException {
        if (option.equalsIgnoreCase("Honda")) {
            cbp.selectcheckbox();
        } else {
            throw new IllegalArgumentException("Invalid checkbox option: " + option);
        }
        Thread.sleep(5000);
    }

    @Then("{string} checkbox should be verified")
    public void checkbox_should_be_verified(String option) {
        assertTrue(cbp.isCheckBoxSelected(), option + " checkbox is not selected!");
    }
}
