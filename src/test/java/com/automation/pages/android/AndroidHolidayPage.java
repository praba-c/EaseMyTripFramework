package com.automation.pages.android;

import com.automation.pages.ui.HolidayPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHolidayPage extends AndroidBasePage implements HolidayPage {

    @FindBy(xpath = "//android.widget.EditText[@resource-id='txtDesCity']")
    WebElement searchBar;

    @FindBy(xpath = "//android.view.View[@resource-id='yourDivId']/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.ListView/android.view.View/android.view.View/android.widget.TextView")
    List<WebElement> citiesResultList;

    public boolean isHolidayPageDisplayed() {
        return searchBar.isDisplayed();
    }

    public void searchCity(String cityName) {

        pause(6000);

        searchBar.sendKeys(ConfigReader.getConfigValue(cityName));

        for (WebElement city : citiesResultList) {

            System.out.println("City - " + city.getText());
            if (city.getText().equalsIgnoreCase(ConfigReader.getConfigValue(cityName))) {
                city.click();
                break;
            }
        }
    }

}
