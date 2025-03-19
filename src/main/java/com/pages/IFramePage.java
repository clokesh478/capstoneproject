package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class IFramePage extends BasePage {
    WebDriverWait wait;

    public IFramePage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//iframe[@id='courses-iframe']")
    WebElement iframeelement;
    
    public void moveToIframe() {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(iframeelement))).perform();
    }

    
    public void switchToIframe(){
       getWebDriver().switchTo().frame(iframeelement);
       
    }

   
    public void switchToMainPage() {
        getWebDriver().switchTo().defaultContent();
    }
}
