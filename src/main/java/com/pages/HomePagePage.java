package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basepage.BasePage;

public class HomePagePage extends BasePage{
	
	
	public HomePagePage(WebDriver wd) {
		super(wd);
		PageFactory.initElements(wd,this);
	}
	@FindBy(xpath="//a[text()='HOME']")
	WebElement homesection;
	
	@FindBy(xpath = "//a[text()='ALL COURSES']")
    WebElement allcoursessection;
	
	@FindBy(xpath = "//a[text()='INTERVIEW']")
    WebElement interviewsection;
	
	@FindBy(xpath = "//a[text()='SUPPORT']")
    WebElement supportsection;
	
	@FindBy(xpath = "//a[text()='BLOG']")
    WebElement blogsection;
	 
	public String getPageTitle() {
		return getWebDriver().getTitle();
	}
	public boolean isHomeSectionDisplayed() {
        return homesection.isDisplayed();
    }

    public boolean isAllCoursesSectionDisplayed() {
        return allcoursessection.isDisplayed();
    }

    public boolean isInterviewSectionDisplayed() {
        return interviewsection.isDisplayed();
    }

    public boolean isSupportSectionDisplayed() {
        return supportsection.isDisplayed();
    }

    public boolean isBlogSectionDisplayed() {
        return blogsection.isDisplayed();
    }
}