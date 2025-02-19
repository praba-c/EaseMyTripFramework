package com.automation.pages.web;

import com.automation.pages.ui.HolidayPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebHolidaysPage extends WebBasePage implements HolidayPage {

    @FindBy(id = "txtDesCity")
    WebElement searchBar;

    @FindBy(xpath = "//li[@class='d-flex align-items-center ng-scope']/a/div[2]/p")
    List<WebElement> citiesResultList;

    public void searchCity(String cityName) {

        searchBar.sendKeys(ConfigReader.getConfigValue(cityName));

        for (WebElement city : citiesResultList) {

            if (city.getText().equalsIgnoreCase(ConfigReader.getConfigValue(cityName))) {
                city.click();
                break;
            }
        }
    }

    public boolean isHolidayPageDisplayed() {
        return searchBar.isDisplayed();
    }
}
