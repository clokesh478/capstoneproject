package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import com.basepage.BasePage;

public class AutoSuggestPage extends BasePage {
    WebDriverWait wait;

    public AutoSuggestPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='autosuggest']")
    WebElement autosuggestTextbox;

    @FindBy(xpath = "//a[contains(@class,'ui-corner-all')]")
    List<WebElement> autosuggestoptions;

    public void typeInAutoSuggest(String text) {
        enterText(autosuggestTextbox, text);
    }

    public boolean isSuggestionDisplayed(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElements(autosuggestoptions));
        return autosuggestoptions.stream().anyMatch(option -> option.getText().equalsIgnoreCase(text));
    }
}
