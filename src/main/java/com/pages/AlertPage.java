package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class AlertPage extends BasePage {
    WebDriverWait wait;

    public AlertPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement alerttextfield;

    @FindBy(xpath = "//input[@id='alertbtn']")
    WebElement alertbutton;

   
    public void enterAlertText(String text) {
        wait.until(ExpectedConditions.visibilityOf(alerttextfield));
        enterText(alerttextfield, text);
    }

    
    public void clickAlertButton() {
        wait.until(ExpectedConditions.elementToBeClickable(alertbutton));
        onClick(alertbutton);
    }

    
    public String getAlertText() {
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
}
