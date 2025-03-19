package com.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {
    private static WebDriver wd;

    @Before
    public void setup() {
        System.out.println("Launching browser...");
        wd = new ChromeDriver();
        wd.manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            captureScreenshot(scenario.getName());
        }
        System.out.println("Closing browser...");
        if (wd != null) {
            wd.quit();
        }
    }

    public static WebDriver getWebDriver() {
        return wd;
    }

    public void captureScreenshot(String scenarioName) {
        TakesScreenshot ts = (TakesScreenshot) wd;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String screenshotName = scenarioName.replaceAll(" ", "_") + "_" + timestamp + ".png";

        File destFile = new File("target/screenshots/" + screenshotName);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
