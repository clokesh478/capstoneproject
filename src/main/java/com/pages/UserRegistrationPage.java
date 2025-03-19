package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.basepage.BasePage;

public class UserRegistrationPage extends BasePage{
	

	public UserRegistrationPage(WebDriver wd) {
		super(wd);
		PageFactory.initElements(wd, this);
		
	}
	@FindBy(xpath="//*[@id=\"navbar-inverse-collapse\"]/div/div/a")
	WebElement SignIn;
	
	@FindBy(xpath="//*[@id=\"page\"]/div[2]/div/div/div/div/form/div[5]/div[3]/a")
	WebElement SignUp;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement FirstName;

	@FindBy(xpath="//input[@id='last_name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement EmailAddress;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='password_confirmation']")
	WebElement PasswordConfirmation;
	
	@FindBy(xpath="//input[@value='Sign Up']")
	WebElement SIGNUP;
	

	public void clickSignIn() {
		onClick(SignIn);
	}
	public void clickSignUp() {
		onClick(SignUp);
	}
	public void setFirstName(String fn) {
		enterText(FirstName,fn);
	}
	public void setLastName(String ln) {
		enterText(LastName,ln);
	}
	public void setEmailAddress(String email) {
		enterText(EmailAddress,email);
	}
	public void setPassword(String pass) {
		enterText(Password,pass);
	}
	public void setConfirmPassword(String passcon) {
		enterText(PasswordConfirmation,passcon);
	}
	
	public void clickSignupfinal() {
		onClick(SIGNUP);
	}
	

}

