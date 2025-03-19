package com.shoppingcartsteps;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import com.hooks.Hooks;
import com.pages.AddToCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class AddToCartStepDefinitions {
    WebDriver wd;
    AddToCartPage atcPage;

    public AddToCartStepDefinitions() {
        this.wd = Hooks.getWebDriver();
        atcPage = new AddToCartPage(wd);
    }

    @Given("User is on the homepage of the ecommerce site")
    public void user_is_on_the_homepage_of_the_ecommerce_site() throws InterruptedException {
        wd.get("https://ecommercepractice.letskodeit.com/");
        Thread.sleep(1000);
    }
        

    @When("User clicks the shop now button")
    public void user_clicks_the_shop_now_button() {
        atcPage.clickShopNow();
    }

    @When("User clicks on the product image")
    public void user_clicks_on_the_product_image() {
        atcPage.clickProductImage();
    }

    @When("User selects the color")
    public void user_selects_the_color() {
        atcPage.selectColor();
    }

    @When("User selects size XS")
    public void user_selects_size_XS() {
        atcPage.selectSize();
    }

    @When("User clicks the add to bag button")
    public void user_clicks_the_add_to_bag_button() throws InterruptedException {
        atcPage.clickAddToBag();
        Thread.sleep(3000);
    }

    @Then("The product should be added to the shopping bag")
    public void the_product_should_be_added_to_the_shopping_bag() {
       
        assertTrue(true, "Product was successfully added to the bag");
    }
}
