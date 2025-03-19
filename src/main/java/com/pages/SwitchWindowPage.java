package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import com.basepage.BasePage;

public class SwitchWindowPage extends BasePage {
    WebDriverWait wait;
    WebDriver wd;

    public SwitchWindowPage(WebDriver wd) {
        super(wd);
        this.wd = wd;
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(wd, Duration.ofSeconds(10)); 
    }

    @FindBy(xpath = "//button[@id='openwindow']")
    WebElement switchwindowbutton;

    
    public void switchwindow() {
       onClick(switchwindowbutton);

    }
    public String getCurrentPageUrl() {
        return wd.getCurrentUrl();
    }
}
