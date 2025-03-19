package com.filterandsearchsteps;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.CourseFilterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CourseFilterStepDefinitions {
    WebDriver wd;
    CourseFilterPage courseFilterPage;

    public CourseFilterStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        courseFilterPage = new CourseFilterPage(wd);
    }

    @Given("User is on the Courses page for filtering")
    public void user_is_on_the_courses_page_for_filtering() {
        wd.get("https://www.letskodeit.com/courses");
    }

    @When("User selects category {string} from the dropdown")
    public void user_selects_category_from_the_dropdown(String category) throws InterruptedException {
        courseFilterPage.selectCategory(category);
        Thread.sleep(5000);
    }

    @Then("The selected category should be {string}")
    public void the_selected_category_should_be(String expectedCategory) {
        assertEquals(courseFilterPage.getSelectedCategory(), expectedCategory, "Category selection failed!");
    }
}
