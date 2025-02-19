package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage;
    public HomeSteps() {

        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            homePage = new WebHomePage();
        } else {
            homePage = new AndroidHomePage();
        }
    }

    @Given("user opens the application")
    public void user_opens_the_application() {
        homePage.openApplication();
    }

    @Then("verify user is on the home page")
    public void verify_user_is_on_the_home_page() {
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @When("user clicks on the holidays tab")
    public void user_clicks_on_the_holidays_tab() {
       homePage.clickOnHolidayTab();
    }
}
