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

public class MouseHoverPage extends BasePage {
    WebDriverWait wait;

    public MouseHoverPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[@id='mousehover']")
    WebElement mousehoverbutton;

    @FindBy(xpath = "//div[@class='mouse-hover-content']//a[contains(text(),'Top')]")
    WebElement mousehovertopoption;

    @FindBy(xpath = "//div[@class='mouse-hover-content']//a[contains(text(),'Reload')]")
    WebElement mousehoverreloadoption;

   
    public void hoverOverButton() {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(wait.until(ExpectedConditions.visibilityOf(mousehoverbutton))).perform();
    }

    
    public boolean isHoverOptionDisplayed(String option) {
        return option.equalsIgnoreCase("Top") ? mousehovertopoption.isDisplayed() : mousehoverreloadoption.isDisplayed();
    }

    
    public void clickHoverOption(String option) {
        WebElement element = option.equalsIgnoreCase("Top") ? mousehovertopoption : mousehoverreloadoption;
        wait.until(ExpectedConditions.elementToBeClickable(element));
        onClick(element);
    }
}
