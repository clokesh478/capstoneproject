package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basepage.BasePage;

public class CheckBoxPage extends BasePage {
    WebDriverWait wait;

    public CheckBoxPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(wd, Duration.ofSeconds(10)); 
    }
    
      

    @FindBy(xpath = "//input[@id='hondacheck']")
    WebElement hondacheckbox;
    
    
    public void selectcheckbox() {
       onClick(hondacheckbox);
    }

    public boolean isCheckBoxSelected() {
    	 wait.until(ExpectedConditions.visibilityOf(hondacheckbox));
         return hondacheckbox.isSelected();
    }
}
