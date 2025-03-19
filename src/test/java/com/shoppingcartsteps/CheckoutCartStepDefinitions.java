package com.shoppingcartsteps;

import com.pages.CheckoutCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import com.hooks.Hooks; // Assuming Hooks class provides the WebDriver instance.

public class CheckoutCartStepDefinitions {

    WebDriver wd;
    CheckoutCartPage checkoutCartPage;

    public CheckoutCartStepDefinitions() {
        
        this.wd = Hooks.getWebDriver();
        checkoutCartPage = new CheckoutCartPage(wd); 
    }
    @Given("User is on homepage for checkout")
    public void user_is_on_homepage_for_checkout() throws InterruptedException {
        wd.get("https://ecommercepractice.letskodeit.com/");
        Thread.sleep(1000);
    }

    @When("User navigates to the cart")
    public void user_navigates_to_the_cart() {
        checkoutCartPage.clickGoToCart();
    }

    @And("User clicks the checkout button")
    public void user_clicks_the_checkout_button() {
        checkoutCartPage.clickCheckout();
    }

    @And("User clicks the final checkout button")
    public void user_clicks_the_final_checkout_button(){
        checkoutCartPage.clickFinalCheckout();
        
    }
    @Then("The \"Thank You!\" message should be displayed")
    public void the_thank_you_message_should_be_displayed() {
        try {
           
            Thread.sleep(3000); 
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
      
        assertTrue(checkoutCartPage.isThankYouMessageDisplayed(), "Thank You! message not displayed");
    }
}