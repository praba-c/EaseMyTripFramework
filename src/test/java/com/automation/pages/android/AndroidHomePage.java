package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Holidays']")
    WebElement holidaysTab;

    @FindBy(xpath = "//android.view.View[@content-desc='Toggle drawer']")
    WebElement toggleBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Login or Signup']")
    WebElement loginBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/txtLoginInput']")
    WebElement inputTextBar;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_login']")
    WebElement continueBtn;

    @FindBy(id = "com.easemytrip.android:id/btn_authenticate")
    WebElement otpLoginBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Hi')]")
    WebElement profile;

    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Cancel']")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gms:id/matched_sms']")
    WebElement otpText;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.google.android.gms:id/negative_button']")
    WebElement denyBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/txtAuthInput']")
    WebElement otpInputField;

    @FindBy(xpath = "//android.widget.TextView[@text='Sign Out']")
    WebElement signOutBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement logoutBtn;

    public boolean isHomePageDisplayed() {
        return holidaysTab.isDisplayed();
    }

    public void clickOnHolidayTab() {
        holidaysTab.click();
    }

    public void openApplication() {

    }

    public void clickOnActivitiesTab() {}


    public void clickOnLoginBtn() {
        toggleBar.click();
        loginBtn.click();
    }

    public boolean isPopupDisplayed() {
        closeBtn.click();
        return inputTextBar.isDisplayed();
    }

    public void enterMobile(String mobileNumber) {
        inputTextBar.sendKeys(ConfigReader.getConfigValue(mobileNumber));
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isOtpGenerated() {
        return otpLoginBtn.isDisplayed();
    }

    public void enterOtp() {
        String otp = otpText.getText().substring(0, 7);
        denyBtn.click();
        otpInputField.sendKeys(otp);
    }

    public void clickOnOtpLoginBtn() {
        otpLoginBtn.click();
    }

    public boolean isUserLoggedIn() {
        toggleBar.click();
        return profile.isDisplayed();
    }

    public void clickOnProfileTab() {
        toggleBar.click();
    }

    public void clickOnLogoutBtn() {
        scroll();
        signOutBtn.click();
        logoutBtn.click();
    }

    public boolean isUserLoggedOut() {
        toggleBar.click();
        return loginBtn.isDisplayed();
    }
}
