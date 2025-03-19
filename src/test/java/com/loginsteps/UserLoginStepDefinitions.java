package com.loginsteps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.hooks.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.UserLoginPage;


public class UserLoginStepDefinitions {
	WebDriver wd;
	UserLoginPage ulp;
	 

	public UserLoginStepDefinitions() {
		this.wd=Hooks.getWebDriver();
		if(this.wd==null) {
			throw new RuntimeException("WebDriver is not initialized! Check Hooks setup.");
		}
		this.ulp=new UserLoginPage(wd);
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		   wd.get("https://www.letskodeit.com/");
		   ulp.clickSignIn();
		   ulp=new UserLoginPage(wd);
		  
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	   ulp.enterEmail(string);
	   ulp.enterPassword(string2);
	}

	@When("User clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
	   ulp.clickonlogin();
	   Thread.sleep(5000);
	  
	}
	

	@Then("User is on homepage")
	public void user_is_on_homepage() {
	    String actualurl=wd.getCurrentUrl();
	    String expectedurl="https://www.letskodeit.com/";
	    Assert.assertEquals(actualurl,expectedurl);
	}
	 



}
