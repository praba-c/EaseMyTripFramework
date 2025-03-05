package com.automation.pages.web;

import com.automation.pages.ui.HomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class WebHomePage extends WebBasePage implements HomePage {

    public boolean isHomePageDisplayed() {
        return true;
    }

    @FindBy(xpath = "//span[text()='Holidays']")
    WebElement holidaysTab;

    @FindBy(xpath = "//span[text()='Activities']")
    WebElement activitiesTab;

    @FindBy(xpath = "//span[text()='Explore Bharat']")
    WebElement exploreBharatTab;

    @FindBy(xpath = "//a[text()='Duty Free']")
    WebElement dutyFreeTab;

    @FindBy(id = "divSignInPnl")
    WebElement loginBtn;

    @FindBy(id = "shwlogn")
    WebElement customerLoginBtn;

    @FindBy(id = "txtEmail")
    WebElement mobileOrEmailInputBar;

    @FindBy(xpath = "//div[@class='_inpwdth']/input")
    WebElement continueBtn;

    @FindBy(xpath = "//input[@id='OtpLgnBtn']")
    WebElement otpLoginBtn;

    @FindBy(xpath = "(//input[@value='Login'])[2]")
    WebElement passwordLoginBtn;

    @FindBy(xpath = "//div[@class='_crosslog _crosslogsuccess']")
    WebElement closeBtn;

    @FindBy(id = "welcome-det-User")
    WebElement profileTab;

    @FindBy(xpath = "//a[@class='_drpdubro LogOut']")
    WebElement logoutBtn;

    @FindBy(id = "shwlgnbx")
    WebElement passwordOptionBtn;

    @FindBy(xpath = "//input[@id='txtEmail2']")
    WebElement passwordInputTab;

    @FindBy(xpath = "//img[@class='_rohChatAI']")
    WebElement chatbotIcon;

    boolean pass = false;

    public void clickOnHolidayTab() {
        holidaysTab.click();
    }

    public void openApplication() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public void clickOnActivitiesTab() {
        activitiesTab.click();
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
        customerLoginBtn.click();
    }

    public boolean isPopupDisplayed() {
        return mobileOrEmailInputBar.isDisplayed();
    }

    public void enterMobile(String mobile) {
        mobileOrEmailInputBar.sendKeys(ConfigReader.getConfigValue(mobile));
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isOtpGenerated() {
        wait.until(ExpectedConditions.visibilityOf(otpLoginBtn));
        return otpLoginBtn.isDisplayed();
    }

    public void enterOtp() {
        pause(20000);
    }

    public void clickOnOtpOrPasswordLoginBtn() {
        if (pass) {
            passwordLoginBtn.click();
        } else {
            otpLoginBtn.click();
        }
        closeBtn.click();
    }

    public boolean isUserLoggedIn() {
        return profileTab.isDisplayed();
    }

    public void clickOnProfileTab() {
        profileTab.click();
    }

    public void clickOnLogoutBtn() {
        logoutBtn.click();
    }

    public boolean isUserLoggedOut() {
        return loginBtn.isDisplayed();
    }

    public boolean isPasswordOptionDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(passwordOptionBtn));
        return passwordOptionBtn.isDisplayed();
    }

    public void enterPassword(String password) {
        passwordOptionBtn.click();
        passwordInputTab.sendKeys(ConfigReader.getConfigValue(password));
        pass = true;
    }

    public void clickOnChatbotIcon() {
        chatbotIcon.click();
    }

    public void clickOnExploreBharatTab() {
        String originalWindow = driver.getWindowHandle();

        exploreBharatTab.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void clickOnDutyFreeTab() {
        String originalWindow = driver.getWindowHandle();
        dutyFreeTab.click();

        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
