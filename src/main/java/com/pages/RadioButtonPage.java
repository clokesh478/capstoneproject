package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import com.basepage.BasePage;

public class RadioButtonPage extends BasePage {
    WebDriverWait wait;

    public RadioButtonPage(WebDriver wd) {
        super(wd);
        PageFactory.initElements(wd, this);
        wait = new WebDriverWait(wd, Duration.ofSeconds(10)); 
    }
    
      

    @FindBy(xpath = "//input[@id='bmwradio']")
    WebElement bmwradiobutton;
    
    public void selectRadioButton() {
        onClick(bmwradiobutton);
   
    }


    public boolean isRadioButtonSelected() {
        wait.until(ExpectedConditions.visibilityOf(bmwradiobutton));
        return bmwradiobutton.isSelected();
    }
}
