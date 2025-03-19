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

public class SwitchTabPage extends BasePage {
    WebDriverWait wait;
    WebDriver wd;

    public SwitchTabPage(WebDriver wd) {
        super(wd);
        this.wd = wd;
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(wd, Duration.ofSeconds(10)); 
    }

    @FindBy(xpath = "//a[@id='opentab']")
    WebElement switchtabbutton;

    public void switchtab() {
        onClick(switchtabbutton);
    }

public String getCurrentPageUrl() {
    return wd.getCurrentUrl();
}
}
