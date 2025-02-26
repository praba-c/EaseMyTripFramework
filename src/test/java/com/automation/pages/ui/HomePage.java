package com.automation.pages.ui;

public interface HomePage {

    void openApplication();

    boolean isHomePageDisplayed();

    void clickOnHolidayTab();

    void clickOnActivitiesTab();

    void clickOnLoginBtn();

    boolean isPopupDisplayed();

    void enterMobile(String mobileNumber);

    void clickOnContinueBtn();

    boolean isOtpGenerated();

    void enterOtp();

    void clickOnOtpLoginBtn();

    boolean isUserLoggedIn();

    void clickOnProfileTab();

    void clickOnLogoutBtn();

    boolean isUserLoggedOut();

    default boolean isPasswordOptionDisplayed() {
        return false;
    }

    default void enterPassword(String password) {}

    void clickOnExploreBharatTab();
}
