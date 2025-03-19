package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class CourseSearchPage extends BasePage {
    WebDriverWait wait;

    public CourseSearchPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(id = "search")
    WebElement searchInput;

    @FindBy(xpath = "//button[@class='find-course search-course']")
    WebElement searchButton;

    By searchResultLocator = By.xpath("//h4[contains(text(),'Selenium WebDriver 4 With Python')]");

    public void enterSearchText(String text) {
        wait.until(ExpectedConditions.visibilityOf(searchInput)); 
        wait.until(ExpectedConditions.elementToBeClickable(searchInput)); 

        try {
            searchInput.clear();
            enterText(searchInput, text);  
        } catch (InvalidElementStateException e) {
            System.out.println("Element not interactable, using JavaScript to set value.");
            JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
            js.executeScript("arguments[0].value='" + text + "';", searchInput);
        }
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        onClick(searchButton); 
    }

    public boolean isSearchResultDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(findWebElement(searchResultLocator))).isDisplayed();
    }
}
