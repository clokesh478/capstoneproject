package com.registrationsteps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hooks.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.UserRegistrationPage;

public class UserRegistrationStepDefinitions {
	WebDriver wd;
	UserRegistrationPage urp;
	
	public UserRegistrationStepDefinitions() {
		this.wd=Hooks.getWebDriver();
		if(this.wd==null) {
			throw new RuntimeException("WebDriver is not initialized! Check Hooks setup.");
		}
		this.urp=new UserRegistrationPage(wd);
	}
	
	@Given("User is on letskodeit homepage")
	public void user_is_on_letskodeit_homepage() {
	   wd.get("https://www.letskodeit.com/");
	  
	}

	@Given("User clicks on SIGN IN button")
	public void user_clicks_on_sign_in_button() {
	    urp.clickSignIn();
	}

	@Given("User clicks on Sign Up")
	public void user_clicks_on_sign_up() {
	    urp.clickSignUp();
	}

	@When("User is required to enter {string} and {string} and {string} and {string} and {string}")
	public void user_is_required_to_enter_and_and_and_and(String string, String string2, String string3, String string4, String string5) {
	    urp.setFirstName(string);
	    urp.setLastName(string2);
	    urp.setEmailAddress(string3);
	    urp.setPassword(string4);
	    urp.setConfirmPassword(string5);
	}

	@When("User clicks on Im not a robot")
	public void user_clicks_on_im_not_a_robot() {
		System.out.println("Please solve the CAPTCHA manually.");
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@When("User clicks on SIGN UP button")
	public void user_clicks_on_sign_up_button() {
	   urp.clickSignupfinal();
	}

	@Then("User is successfully registered")
	public void user_is_successfully_registered() {
	    String loginpage=wd.getCurrentUrl();
	    String expectedpage="https://www.letskodeit.com/";
	    Assert.assertEquals(loginpage, expectedpage);
	    System.out.println("User is Successfully Registered!");
	    
	}
}
	    
	    






