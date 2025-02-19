package com.automation.pages.web;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebHomePage extends WebBasePage implements HomePage {

    public boolean isHomePageDisplayed() {
        return true;
    }

    @FindBy(xpath = "//span[text()='Holidays']")
    WebElement holidaysTab;

    public void clickOnHolidayTab() {
        holidaysTab.click();
    }

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }
}
