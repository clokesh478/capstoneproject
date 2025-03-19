package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class WebTablePage extends BasePage {
    WebDriverWait wait;

    public WebTablePage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//table[@id='product']//td[contains(text(),'Python Programming Language')]/following-sibling::td[1]")
    WebElement webtableprice;

    
    public String getWebTablePrice() {
        return wait.until(ExpectedConditions.visibilityOf(webtableprice)).getText();
    }
}
