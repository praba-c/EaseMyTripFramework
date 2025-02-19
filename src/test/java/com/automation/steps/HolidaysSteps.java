package com.automation.steps;

import com.automation.pages.android.AndroidHolidayPage;
import com.automation.pages.ui.HolidayPage;
import com.automation.pages.web.WebHolidaysPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HolidaysSteps {

    HolidayPage holidayPage;

    public HolidaysSteps() {

        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            holidayPage = new WebHolidaysPage();
        } else {
            holidayPage = new AndroidHolidayPage();
        }
    }

    @Then("holidays page is displayed")
    public void holidays_page_is_displayed() {
        Assert.assertTrue(holidayPage.isHolidayPageDisplayed());
    }

    @When("user enters {string} and clicks on search button")
    public void user_enters_and_clicks_on_search_button(String destination) {
        holidayPage.searchCity(destination);
    }
}
