package uistore;

import org.openqa.selenium.By;

public class DepositUI {
    public static By depositLink = By.linkText("Deposit");
    public static By accType = By.id("selectedAccount");
    public static By amount = By.id("amount");
    // public static By amount = By.id("amont");
   
    public static String submitAcc = "//button[text()=' Submit']";
}
