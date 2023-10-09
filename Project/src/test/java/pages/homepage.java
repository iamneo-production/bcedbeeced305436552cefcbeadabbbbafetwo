
package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReadPropertyFile;
import utils.ExcelReader;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.ss.usermodel.*;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import utils.Screenshot;
import utils.WebDriverHelper;
import uistore.HomepageUI;
import utils.ExcelReader;
import utils.Reporter;

public class homepage {

    private static final Logger log = LogManager.getLogger(homepage.class);
    private ExcelReader excelReader;    
    private WebDriverHelper webDriverHelper;
    ExcelReader file = new ExcelReader();
    Reporter reporter = new Reporter();
    ReadPropertyFile configReader = new ReadPropertyFile();
    String browserName = configReader.getBrowserName(); 


    public homepage(WebDriver driver) {
        webDriverHelper = new WebDriverHelper(driver);
        excelReader = new ExcelReader();
        log.info("1234");
        

    }


    public void Valid_Login_TC(WebDriver driver) throws IOException {
        log.info(("qwert"));
        log.info(browserName);
       

        ExtentTest test = Reporter.generateExtentReport().createTest("Login Test", "Execution for Login Function");

        try {
             test.log(Status.PASS, "Browser opened");
             String username =excelReader.ReadData("./testdata/Testdata.xlsx","Sheet1", 1, "username");
             String password =excelReader.ReadData("./testdata/Testdata.xlsx","Sheet1", 1, "password");

            try {
                webDriverHelper.fillForm(HomepageUI.username, username);
                Screenshot.getScreenShot(driver, "Login sucessfull");
                test.log(Status.PASS, "Enter Username");
               
               
                // All levels of logs start 
                
                
                log.trace("Trace Message!");
                log.debug("Debug Message!");
                log.info("Info Message!");
                log.warn("Warn Message!");
                log.error("Error Message!");
                log.fatal("Fatal Message!");   
                 
                //All levels of logs start 

            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "UsernameEntryError");
                test.fail("Failed to Enter Username", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }


            try {
                webDriverHelper.fillForm(HomepageUI.password, password);
                test.log(Status.PASS, "Enter Password");
            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "PasswordEntryError");
                test.fail("Failed to Enter Password", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }

            // Click on submit
            try {
                // driver.findElement(Locators1.submit).click();
                webDriverHelper.clickElement(HomepageUI.submit);
                test.log(Status.PASS, "Click on submit");
            } catch (Exception ex) {
                ex.printStackTrace();
                String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Error");
                test.fail("Failed to submit", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, "Valid_Login_TC");
            test.fail("Failed to Perform Valid_Login_TC", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
    }
}
