package com.automation.steps;

import com.automation.pages.android.AndroidPackagePage;
import com.automation.pages.ui.PackagePage;
import com.automation.pages.web.WebPackagePage;
import com.automation.utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PackageSteps {

    PackagePage packagePage;

    public PackageSteps() {

        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            packagePage = new WebPackagePage();
        } else {
            packagePage = new AndroidPackagePage();
        }
    }

    @Then("verify package page is displayed and print the details")
    public void verifyPackagePageIsDisplayedAndPrintTheDetails() {
        Assert.assertTrue(packagePage.isPackagePageDisplayed());
        packagePage.printDetails();
    }

    @When("user clicks on enquiry button and fill the {string} {string} and {string}")
    public void userClicksOnEnquiryButtonAndFillTheAnd(String name, String mobileNo, String email) {
        packagePage.clickOnEnquiryBtnAndFillDetails(name, mobileNo, email);
    }

    @And("clicks enquiry button")
    public void clicksEnquiryButton() {
        packagePage.clickOnEnquiryBtn();
    }

    @When("user customizes the hotels and rooms as {string}")
    public void userCustomizesTheHotelsAndRoomsAs(String sortOption) {
        packagePage.customizeRooms(sortOption);
    }

    @Then("print the price after changing the hotels and rooms")
    public void printThePriceAfterChangingTheHotelsAndRooms() {
        packagePage.printPriceDetails();
    }

    @When("user clicks on book now button and fill the details:")
    public void userClicksOnBookNowButtonAndFillTheDetails(DataTable dataTable) {
        packagePage.fillDetails(dataTable);
        packagePage.clickOnBookNowBtn();
    }

    @And("clicks continue booking button")
    public void clicksContinueBookingButton() {
        packagePage.clickOnContinueBookingBtn();
    }
}
