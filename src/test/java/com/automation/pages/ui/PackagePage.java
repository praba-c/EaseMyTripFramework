package com.automation.pages.ui;

public interface PackagePage {

    void printDetails();

    boolean isPackagePageDisplayed();

    void clickOnEnquiryBtnAndFillDetails(String name, String mobileNo, String mail);

    void clickOnEnquiryBtn();

    void customizeRooms(String sortOption);

    void printPriceDetails();


}
