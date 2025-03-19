package com.filterandsearchsteps;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.CourseSearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseSearchStepDefinitions {
    WebDriver wd;
    CourseSearchPage courseSearchPage;

    public CourseSearchStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        courseSearchPage = new CourseSearchPage(wd);
    }

    @Given("User is on the Courses page for searching")
    public void user_is_on_the_courses_page_for_searching() {
        wd.get("https://www.letskodeit.com/courses");
    }

    @When("User enters {string} in the search field")
    public void user_enters_in_the_search_field(String searchText) throws InterruptedException{
        courseSearchPage.enterSearchText(searchText);
        Thread.sleep(5000);
    }

    @When("User clicks on the search button")
    public void user_clicks_on_the_search_button() {
        courseSearchPage.clickSearchButton();
    }

    @Then("Search result for Selenium WebDriver 4 With Python should be displayed")
    public void search_result_for_selenium_webdriver_4_with_python_should_be_displayed() {
        assertTrue(courseSearchPage.isSearchResultDisplayed(), "Expected course not found in search results!");
    }
}
