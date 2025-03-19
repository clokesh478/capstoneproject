package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class AddToCartPage extends BasePage {
    WebDriverWait wait;

    public AddToCartPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(css = "button.Button-module--button--c17ef.Button-module--primary--2e17d.Hero-module--ctaButton--06285.undefined")
    WebElement shopNowButton;

    @FindBy(xpath = "//img[@src='/products/woman2.jpeg']")
    WebElement productImage;

    @FindBy(xpath = "//*[@id=\"gatsby-focus-wrapper\"]/main/div/div[1]/div[2]/div[2]/div[2]/div/div/button[1]")
    WebElement colorSelectButton;

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[1]/span")
    WebElement sizeSelectButton;

    @FindBy(xpath = "//button[contains(text(), 'Add to Bag')]")
    WebElement addToBagButton;

    public void clickShopNow() {
        wait.until(ExpectedConditions.elementToBeClickable(shopNowButton));
        onClick(shopNowButton);
    }

    public void clickProductImage() {
        wait.until(ExpectedConditions.elementToBeClickable(productImage));
        onClick(productImage);
    }

    public void selectColor() {
        wait.until(ExpectedConditions.elementToBeClickable(colorSelectButton));
        onClick(colorSelectButton);
    }

    public void selectSize() {
        wait.until(ExpectedConditions.elementToBeClickable(sizeSelectButton));
        onClick(sizeSelectButton);
    }

    public void clickAddToBag() {
        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        onClick(addToBagButton);
    }
}
