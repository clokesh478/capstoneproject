package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class SelectDropdownPage extends BasePage {
    WebDriverWait wait;
    WebDriver wd;

    public SelectDropdownPage(WebDriver wd) {
        super(wd);
        this.wd = wd;
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//select[@id='carselect']")
    WebElement selectclass;

    public void selectDropdownOption(String value) {
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(selectclass)));
        select.selectByVisibleText(value);
    }

    public String getSelectedDropdownValue() {
        Select select = new Select(selectclass);
        return select.getFirstSelectedOption().getText();
    }
}
