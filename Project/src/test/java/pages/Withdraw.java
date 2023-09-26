package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import utils.LoggerHandler;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.poi.ss.usermodel.*;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import utils.Screenshot;
import utils.WebDriverHelper;
import uistore.HomepageUI;
import uistore.WithdrawUI;
import utils.ExcelReader;
import utils.Reporter;
public class Withdraw {

    private ExcelReader excelReader;    
    private WebDriverHelper webDriverHelper;
    private static final Logger log = LogManager.getLogger(Withdraw.class);


    ExcelReader file = new ExcelReader();
    Reporter reporter = new Reporter();
    
    public Withdraw(WebDriver driver) {
        webDriverHelper = new WebDriverHelper(driver);
        excelReader = new ExcelReader();
    }
   


  public void WithdrawTest(WebDriver driver)throws IOException {
            ExtentTest test = Reporter.generateExtentReport().createTest("Withdraw Test", "Execution for WithdrawTest  Function");
try{
    String withdrawAmount =excelReader.ReadData("./testdata/Testdata.xlsx","Sheet1", 1, "Wamt");

        try{
            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            driver.findElement(WithdrawUI.getWithdrawLinkLocator()).click();
            test.log(Status.PASS, "Click on the Withdrea link");
        }
        catch(Exception ex){
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, " Error in Withdrea link");
            test.fail("Failed to Perform  Withdrea link", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
     
        }try{
            Select accType=new Select(driver.findElement(WithdrawUI.accType));
            accType.selectByVisibleText("Individual Checking (Standard Checking)");

            test.log(Status.PASS, "Select the Account type");

        }catch(Exception ex){
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, " Error in Account type");
            test.fail("Failed to Perform  Account type", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
     
        }try{
            webDriverHelper.fillForm(WithdrawUI.amount, withdrawAmount);
             test.log(Status.PASS, "Enter the withdrawAmount");
        }catch(Exception ex){
            ex.printStackTrace();
            String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, " Error in withdrawAmount");
            test.fail("Failed to Perform  withdrawAmount", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
     
        }

        driver.findElement(By.xpath(WithdrawUI.submitAcc)).click();

    }
    catch(Exception ex){
        ex.printStackTrace();
        String base64Screenshot = Reporter.captureScreenshotAsBase64(driver, " Error in withdrawAmount");
        test.fail("Failed to Perform  withdrawAmount", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
 
    }
    }
}