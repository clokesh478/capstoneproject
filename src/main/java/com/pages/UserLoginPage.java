package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basepage.BasePage;

public class UserLoginPage extends BasePage{
	
	
	public UserLoginPage(WebDriver wd) {
		super(wd);
		PageFactory.initElements(wd, this);
		
	}
	@FindBy(xpath="//*[@id=\"navbar-inverse-collapse\"]/div/div/a")
	WebElement SignIn;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='login-password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@id='login']")
	WebElement login;

public void clickSignIn() {
		onClick(SignIn);
}
public void enterEmail(String email) {
	enterText(Email,email);
}
public void enterPassword(String pass) {
	enterText(Password,pass);
}
public void clickonlogin() {
	onClick(login);
}



}
