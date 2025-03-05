package com.automation.pages.android;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndroidHomePage extends AndroidBasePage implements HomePage {

    @FindBy(id = "com.google.android.gms:id/cancel")
    WebElement googlePopupCloseBtn;

    @FindBy(id = "com.easemytrip.android:id/iv_close")
    WebElement loginPopupClosBtn;

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

    @FindBy(xpath = "//android.widget.ImageView")
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

    @FindBy(xpath = "//android.widget.TextView[@text='Explore Bharat']")
    WebElement exploreBharatTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Activities']")
    WebElement activitiesTab;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/txtLoginAuthOption']")
    WebElement passwordOptionBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/txtAuthInput']")
    WebElement passwordInputTab;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_authenticate']")
    WebElement passwordLoginBtn;

    @FindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View")
    WebElement expandBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Airport Service']")
    WebElement airportServicesTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Duty Free']")
    WebElement dutyFreeTab;

    boolean pass = false;

    public boolean isHomePageDisplayed() {
        return holidaysTab.isDisplayed();
    }

    public void clickOnHolidayTab() {
        holidaysTab.click();
    }

    public void openApplication() {
        if (isPresent(googlePopupCloseBtn)) {
            googlePopupCloseBtn.click();
            loginPopupClosBtn.click();
        }
    }

    public void clickOnActivitiesTab() {
        activitiesTab.click();
    }

    public void clickOnLoginBtn() {
        toggleBar.click();
        loginBtn.click();
    }

    public boolean isPopupDisplayed() {
        googlePopupCloseBtn.click();
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

    public void clickOnOtpOrPasswordLoginBtn() {
        if (pass) {
            passwordLoginBtn.click();
        } else {
            otpLoginBtn.click();
        }
    }

    public boolean isUserLoggedIn() {
        toggleBar.click();
        return profile.isDisplayed();
    }

    public void clickOnProfileTab() {
        closeBtn.click();
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

    public boolean isPasswordOptionDisplayed() {
        return passwordOptionBtn.isDisplayed();
    }

    public void enterPassword(String password) {
        passwordOptionBtn.click();
        denyBtn.click();
        passwordInputTab.sendKeys(ConfigReader.getConfigValue(password));
        pass = true;
    }

    public void clickOnExploreBharatTab() {
        exploreBharatTab.click();
    }


}
