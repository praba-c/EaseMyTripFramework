package com.automation.steps;

import com.automation.pages.android.AndroidQueryPage;
import com.automation.pages.ui.QueryPage;
import com.automation.pages.web.WebQueryPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class QuerySteps {

    QueryPage queryPage;

    public QuerySteps() {

        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            queryPage = new WebQueryPage();
        } else {
            queryPage = new AndroidQueryPage();
        }
    }

    @Then("verify user is on query page")
    public void verifyUserIsOnQueryPage() {
        Assert.assertTrue(queryPage.isQueryPageDisplayed());
    }

    @Then("verify query number is generated")
    public void verifyQueryNumberIsGenerated() {
        Assert.assertTrue(queryPage.isQueryNumberGenerated());
    }

    @When("user clicks on goto homepage btn")
    public void userClicksOnGotoHomepageBtn() {
        queryPage.clickOnGotoHomeBtn();
    }
}
