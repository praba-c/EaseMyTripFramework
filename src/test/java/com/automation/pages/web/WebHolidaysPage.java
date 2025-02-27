package com.automation.pages.web;

import com.automation.pages.ui.HolidayPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WebHolidaysPage extends WebBasePage implements HolidayPage {

    @FindBy(id = "txtDesCity")
    WebElement searchBar;

    @FindBy(xpath = "//li[@class='d-flex align-items-center ng-scope']/a/div[2]/p")
    List<WebElement> citiesResultList;

    public void searchCity(String cityName) {

        searchBar.sendKeys(cityName);
        pause(2000);

        for (WebElement city : citiesResultList) {

            if (city.getText().equalsIgnoreCase(cityName)) {
                city.click();
                break;
            }
        }
    }

    public boolean isHolidayPageDisplayed() {
        return searchBar.isDisplayed();
    }
}
