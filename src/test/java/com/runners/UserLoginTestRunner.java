package com.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features/UserLogin.feature",
        glue = {"com.loginsteps","com.hooks"},
        plugin = {
        		    		"pretty",
        		    		
        		    		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        		    		"html:target/Cucumber-Reports/cucumber_report.html",
        		    		"json:target/Cucumber-Reports/cucumber_report.json",
        		    		
        		    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/Cucumber-Reports" // Extent Report Adapter
        		    	      
        		    },
        monochrome = true
)
public class UserLoginTestRunner extends AbstractTestNGCucumberTests {
}
