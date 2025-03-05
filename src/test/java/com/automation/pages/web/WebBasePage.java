package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebBasePage {

    static WebDriver driver;
    static WebDriverWait wait;
    static String flightOption = "";
    static String queryNumber = "";

    public WebBasePage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForElementClickable(WebElement ele) {
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    public void javascriptExecutor(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    public double stringPriceValueToDouble(String price) {
        if (price.isEmpty()) {
            return 0;
        }
        String priceValue = price.replace("₹", "").replace(",", "");
        return Double.parseDouble(priceValue.trim());
    }
}
