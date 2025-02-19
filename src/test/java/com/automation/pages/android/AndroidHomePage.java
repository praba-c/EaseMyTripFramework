package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Holidays']")
    WebElement holidaysTab;


    public boolean isHomePageDisplayed() {
        return holidaysTab.isDisplayed();
    }

    public void clickOnHolidayTab() {
        holidaysTab.click();
    }

    public void openApplication() {

    }
}
