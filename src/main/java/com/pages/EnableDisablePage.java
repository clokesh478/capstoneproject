package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class EnableDisablePage extends BasePage {
    WebDriverWait wait;

    public EnableDisablePage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='enabled-example-input']")
    WebElement enabledisablefield;

    @FindBy(xpath = "//input[@id='disabled-button']")
    WebElement disablebutton;

    @FindBy(xpath = "//input[@id='enabled-button']")
    WebElement enablebutton;

    public void disableField() {
        wait.until(ExpectedConditions.elementToBeClickable(disablebutton));
        onClick(disablebutton);
    }

    public boolean isFieldDisabled() {
        return !enabledisablefield.isEnabled();
    }

    public void enableField() {
        wait.until(ExpectedConditions.elementToBeClickable(enablebutton));
        onClick(enablebutton);
    }

    public boolean isFieldEnabled() {
        return enabledisablefield.isEnabled();
    }

    public void enterTextInField(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(enabledisablefield));
        enterText(enabledisablefield, text);
    }

    public String getEnteredText() {
        return enabledisablefield.getAttribute("value");
    }
}
