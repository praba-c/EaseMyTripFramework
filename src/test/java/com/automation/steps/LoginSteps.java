package com.automation.steps;

import com.automation.pages.android.AndroidHomePage;
import com.automation.pages.ui.HomePage;
import com.automation.pages.web.WebHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    HomePage homePage;

    public LoginSteps() {
        if (ConfigReader.getConfigValue("application.type").equals("web")) {
            homePage = new WebHomePage();
        }
        else {
            homePage = new AndroidHomePage();
        }
    }

    @When("user clicks on login button and selects customer login")
    public void userClicksOnLoginButtonAndSelectsCustomerLogin() {
        homePage.clickOnLoginBtn();
    }

    @Then("verify a popup is displayed asking for mobile number or email for login")
    public void verifyAPopupIsDisplayedAskingForMobileNumberOrEmailForLogin() {
        Assert.assertTrue(homePage.isPopupDisplayed());
    }

    @When("user enters a valid mobile number or email {string}")
    public void userEntersAValidMobileNumberOrEmail(String mobileNumber) {
        homePage.enterMobile(mobileNumber);
    }

    @And("user clicks on the continue button")
    public void userClicksOnTheContinueButton() {
        homePage.clickOnContinueBtn();
    }

    @Then("verify the system sends an OTP to the provided mobile number or email")
    public void verifyTheSystemSendsAnOTPToTheProvidedMobileNumberOrEmail() {
        Assert.assertTrue(homePage.isOtpGenerated());
    }

    @When("user enters the OTP")
    public void userEntersTheOTP() {
        homePage.enterOtp();
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        homePage.clickOnOtpOrPasswordLoginBtn();
    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

    @When("user clicks profile tab")
    public void userClicksProfileTab() {
        homePage.clickOnProfileTab();
    }

    @And("clicks on log out button")
    public void clicksOnLogOutButton() {
        homePage.clickOnLogoutBtn();
    }

    @Then("verify user is logged out")
    public void verifyUserIsLoggedOut() {
        Assert.assertTrue(homePage.isUserLoggedOut());
    }

    @Then("verify the system ask password for logging in")
    public void verifyTheSystemAskPasswordForLoggingIn() {
        Assert.assertTrue(homePage.isPasswordOptionDisplayed());
    }

    @When("user selects the password option and enters the {string}")
    public void userSelectsThePasswordOptionAndEntersThe(String password) {
        homePage.enterPassword(password);
    }
}
