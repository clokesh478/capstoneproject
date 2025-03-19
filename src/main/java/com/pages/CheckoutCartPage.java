package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class CheckoutCartPage extends BasePage {
    WebDriverWait wait;

    public CheckoutCartPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/div[1]/div[2]/div[1]/div[4]/button[2]")
    WebElement goToCartButton;

    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/div[1]/div[4]/div[2]/div/div[3]/div/button")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div[2]/div/div[2]/div[2]/button")
    WebElement finalCheckoutButton;

    @FindBy(xpath = "//*[contains(text(), 'Thank You!')]")
    WebElement thankYouMessage;

    public void clickGoToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(goToCartButton));
        onClick(goToCartButton);
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        onClick(checkoutButton);
    }

    public void clickFinalCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(finalCheckoutButton));
        onClick(finalCheckoutButton);
    }

    public boolean isThankYouMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
        return thankYouMessage.isDisplayed();
    }
}
