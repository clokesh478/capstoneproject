package com.elementssteps;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.RadioButtonPage;
import com.pages.UserLoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RadioButtonStepDefinitions {
    WebDriver wd;    
    RadioButtonPage rbp;
    UserLoginPage loginPage;

    public RadioButtonStepDefinitions() {
        this.wd = Hooks.getWebDriver();    
        rbp = new RadioButtonPage(wd);
        loginPage = new UserLoginPage(wd);
    }

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        wd.get(url);
    }

    @When("User selects {string} from the radio button options")
    public void user_selects_from_the_radio_button_options(String option) throws InterruptedException {
        rbp.selectRadioButton();
        Thread.sleep(5000);
    }

    @Then("{string} should be verified")
    public void should_be_verified(String option) {
        assertTrue(rbp.isRadioButtonSelected(), option + " radio button is not selected!");
    }
}
