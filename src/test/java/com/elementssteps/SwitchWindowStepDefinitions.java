package com.elementssteps;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import java.util.Set;
import com.hooks.Hooks;
import com.pages.SwitchWindowPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwitchWindowStepDefinitions {
    WebDriver wd;
    SwitchWindowPage swp;
    String newWindowUrl;

    public SwitchWindowStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        swp = new SwitchWindowPage(wd);
    }

    @Given("User navigates to {string} for switch window")
    public void user_navigates_to_for_switch_window(String url) {
        wd.get(url);
    }
    @When("User clicks on the switch window button")
    public void user_clicks_on_the_switch_window_button() throws InterruptedException{
        swp.switchwindow();
        Thread.sleep(2000);
        String parentWindow = wd.getWindowHandle();
        Set<String> allWindows = wd.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                wd.switchTo().window(window);
                newWindowUrl = wd.getCurrentUrl();
                break;
            }
        }
    }


    @Then("The new window URL should be {string}")
    public void the_new_window_url_should_be(String expectedUrl) {
        assertEquals(newWindowUrl, expectedUrl, "The new window URL is incorrect!");
    }
}
