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

public class CourseFilterPage extends BasePage {
    WebDriverWait wait;

    public CourseFilterPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(name = "categories")
    WebElement categoryDropdown;

    public void selectCategory(String categoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(categoryDropdown));
        new Select(categoryDropdown).selectByVisibleText(categoryName);
    }

    public String getSelectedCategory() {
        wait.until(ExpectedConditions.visibilityOf(categoryDropdown));
        return new Select(categoryDropdown).getFirstSelectedOption().getText();
    }
}
