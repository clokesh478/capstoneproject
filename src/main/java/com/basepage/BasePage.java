package com.basepage;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	WebDriver wd;

	public BasePage(WebDriver wd) {
		this.setWebDriver(wd);
	}

	public WebElement findWebElement(By locator) {
		return getWebDriver().findElement(locator);
	}
	
	public List<WebElement> findWebElements(By locator){
		return getWebDriver().findElements(locator);
	}

	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public void onClick(WebElement element) {
		element.click();
	}

	public WebDriver getWebDriver() {
		return wd;
	}

	public void setWebDriver(WebDriver wd) {
		this.wd = wd;
	}
	
}