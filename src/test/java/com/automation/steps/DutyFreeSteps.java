package com.automation.steps;

import com.automation.pages.web.DutyFreePage;
import com.automation.pages.web.WebHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DutyFreeSteps {

    DutyFreePage dutyFreePage = new DutyFreePage();
    WebHomePage homePage = new WebHomePage();

    @When("user clicks on the duty free tab")
    public void userClicksOnTheDutyFreeTab() {
        homePage.clickOnDutyFreeTab();
    }

    @Then("verify user is on the duty free page")
    public void verifyUserIsOnTheDutyFreePage() {
        Assert.assertTrue(dutyFreePage.isDutyFreePageDisplayed());
    }

    @And("verify list of airports where displayed")
    public void verifyListOfAirportsWhereDisplayed() {

    }

    @When("user selects the {string} airport")
    public void userSelectsTheAirport(String airport) {
        dutyFreePage.selectAirport(airport);
    }

    @Then("verify airport duty free page is displayed")
    public void verifyAirportDutyFreePageIsDisplayed() {
        Assert.assertTrue(dutyFreePage.isAirportDutyFreePageDisplayed());
    }

    @When("user choose order pickup location {string} and confirm age {string}")
    public void userChooseOrderPickupLocationAndConfirmAge(String pickupLocation, String age) {
        dutyFreePage.selectPickupLocationAndConfirmAge(pickupLocation, age);
    }

    @Then("verify products where displayed")
    public void verifyProductsWhereDisplayed() {
        Assert.assertTrue(dutyFreePage.isProductsDisplayed());
    }

    @When("user selects a particular category {string}")
    public void userSelectsAParticularCategory(String category) {
        dutyFreePage.selectCategory(category);
    }

    @And("selects {string} and add the product to the cart")
    public void selectsAndAddTheProductToTheCart(String product) {
        dutyFreePage.selectProduct(product);
    }

    @Then("verify cart quantity increased to {int}")
    public void verifyCartQuantityIncreasedTo(int count) {
        Assert.assertTrue(dutyFreePage.verifyCartIconQty(count));
    }

    @When("user clicks on cart icon")
    public void userClicksOnCartIcon() {
        dutyFreePage.clickOnCartIcon();
    }

    @Then("verify user is on the cart page")
    public void verifyUserIsOnTheCartPage() {
        Assert.assertTrue(dutyFreePage.isCartPageDisplayed());
    }

    @And("print the details of the product added to the cart")
    public void printTheDetailsOfTheProductAddedToTheCart() {
        dutyFreePage.printDetails();
    }

    @And("sort them {string} based on the price")
    public void sortThemBasedOnThePrice(String sortOption) {
        dutyFreePage.sort(sortOption);
    }

    @Then("verify products are sorted by {string}")
    public void verifyProductsAreSortedBy(String sortOrder) {
        Assert.assertTrue(dutyFreePage.verifySort(sortOrder));
    }
}
