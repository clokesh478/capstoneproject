package com.homepagesteps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.pages.HomePagePage;
import com.pages.UserLoginPage;

public class HomePageStepDefinitions {
    WebDriver wd;
    HomePagePage homepage;
    UserLoginPage loginPage;

    public HomePageStepDefinitions() {  
        this.wd = Hooks.getWebDriver();
        homepage = new HomePagePage(wd);
        loginPage = new UserLoginPage(wd);
    }

    @Given("User is logged into the application")
    public void user_is_logged_into_the_application() throws InterruptedException {
        wd.get("https://www.letskodeit.com/");
        loginPage.clickSignIn();
        loginPage.enterEmail("arpan12@gmail.com");
        loginPage.enterPassword("ak@123");
        loginPage.clickonlogin();
        System.out.println("User successfully logged in.");
        Thread.sleep(1000);
    }

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        wd.get(url);
        System.out.println("User navigated to " + url);
    }

    @Then("The title of the page should be {string}")
    public void the_title_of_the_page_should_be(String expectedTitle) {
        String actual = homepage.getPageTitle();
        Assert.assertEquals(actual, expectedTitle, "Page title does not match!");
        System.out.println("The title of the homepage is: " + actual);
    }

    @Then("Home section should be displayed")
    public void home_section_should_be_displayed() {
        Assert.assertTrue(homepage.isHomeSectionDisplayed(), "Home section is not displayed!");
        System.out.println("Home section is displayed.");
    }

    @Then("All Courses section should be displayed")
    public void all_courses_section_should_be_displayed() {
        Assert.assertTrue(homepage.isAllCoursesSectionDisplayed(), "All Courses section is not displayed!");
        System.out.println("All Courses section is displayed.");
    }

    @Then("Interview section should be displayed")
    public void interview_section_should_be_displayed() {
        Assert.assertTrue(homepage.isInterviewSectionDisplayed(), "Interview section is not displayed!");
        System.out.println("Interview section is displayed.");
    }

    @Then("Support section should be displayed")
    public void support_section_should_be_displayed() {
        Assert.assertTrue(homepage.isSupportSectionDisplayed(), "Support section is not displayed!");
        System.out.println("Support section is displayed.");
    }

    @Then("Blog section should be displayed")
    public void blog_section_should_be_displayed() {
        Assert.assertTrue(homepage.isBlogSectionDisplayed(), "Blog section is not displayed!");
        System.out.println("Blog section is displayed.");
    }
}
