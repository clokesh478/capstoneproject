package com.elementssteps;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.IFramePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IFrameStepDefinitions {
    WebDriver wd;
    IFramePage ifp;

    public IFrameStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        ifp = new IFramePage(wd);
    }

    @Given("User is on the Practice page with iframe")
    public void user_is_on_the_practice_page_with_iframe() {
        wd.get("https://www.letskodeit.com/practice");
    }
    @When("User moves near the iframe")
    public void user_moves_near_the_iframe() {
        ifp.moveToIframe();
    }

    @When("User switches to the iframe")
    public void user_switches_to_the_iframe() throws InterruptedException {
        ifp.switchToIframe();
        Thread.sleep(3000);
    }

    @Then("User should be inside the iframe")
    public void user_should_be_inside_the_iframe() {
        assertTrue(wd.getTitle().contains("Practice"), "User is not inside the iframe!");
    }

    @When("User switches back to the main page")
    public void user_switches_back_to_the_main_page() {
        ifp.switchToMainPage();
    }

    @Then("User should be back on the main page")
    public void user_should_be_back_on_the_main_page() {
        assertTrue(wd.getTitle().contains("Practice"), "User is not back on the main page!");
    }
}
