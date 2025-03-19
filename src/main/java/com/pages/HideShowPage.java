package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class HideShowPage extends BasePage {
    WebDriverWait wait;

    public HideShowPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='hide-textbox']")
    WebElement hideelementbutton;

    @FindBy(xpath = "//input[@id='show-textbox']")
    WebElement showelementbutton;

    @FindBy(xpath = "//input[@id='displayed-text']")
    WebElement displayedelement;

    public void hideElement() {
        wait.until(ExpectedConditions.elementToBeClickable(hideelementbutton));
        onClick(hideelementbutton);
    }

    public boolean isElementVisible() {
        try {
            return displayedelement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void showElement() {
        wait.until(ExpectedConditions.elementToBeClickable(showelementbutton));
        onClick(showelementbutton);
    }

    public void enterTextInField(String text) {
        wait.until(ExpectedConditions.visibilityOf(displayedelement));
        enterText(displayedelement, text);
    }

    public String getEnteredText() {
        return displayedelement.getAttribute("value");
    }
}
