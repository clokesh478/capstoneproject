package com.elementssteps;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import java.util.Set;
import com.hooks.Hooks;
import com.pages.SwitchTabPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwitchTabStepDefinitions {
    WebDriver wd;
    SwitchTabPage stp;
    String newTabUrl;

    public SwitchTabStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        stp = new SwitchTabPage(wd);
    }

    @Given("User navigates to {string} for switch tab")
    public void user_navigates_to_for_switch_tab(String url) {
        wd.get(url);
    }

    @When("User clicks on the switch tab button")
    public void user_clicks_on_the_switch_tab_button() {
        stp.switchtab();
        String parentTab = wd.getWindowHandle();
        Set<String> allTabs = wd.getWindowHandles();

        for (String tab : allTabs) {
            if (!tab.equals(parentTab)) {
                wd.switchTo().window(tab);
                newTabUrl = stp.getCurrentPageUrl();
                break;
            }
        }
    }

    @Then("The new tab URL should be {string}")
    public void the_new_tab_url_should_be(String expectedUrl) {
        assertEquals(newTabUrl, expectedUrl, "The new tab URL is incorrect!");
    }
}
