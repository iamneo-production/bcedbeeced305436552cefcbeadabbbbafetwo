package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelper extends Base {
    private WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url)throws Exception  {
        try {
             driver.get(url);
        } catch (Exception e){
              e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
       
    }

    public void clickElement(By locator)throws Exception {
        try {
             WebElement element = driver.findElement(locator);
        element.click();
        } catch (Exception e) {
             e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
       
    }

    public void fillForm(By locator, String text)throws Exception {
        try {
             WebElement element = driver.findElement(locator);
            element.sendKeys(text);
        } catch (Exception e) {
             e.printStackTrace();
            throw new Exception("Error in " + e.getMessage());
        }
       
    }
    

}
