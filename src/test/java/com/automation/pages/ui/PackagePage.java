package com.automation.pages.ui;

import io.cucumber.datatable.DataTable;

public interface PackagePage {

    void printDetails();

    boolean isPackagePageDisplayed();

    void clickOnEnquiryBtnAndFillDetails(String name, String mobileNo, String mail);

    void clickOnEnquiryBtn();

    void customizeRooms(String sortOption);

    void printPriceDetails();

    default void clickOnBookNowBtn(){}

    default void fillDetails(DataTable dataTable) {}

    default void clickOnContinueBookingBtn(){}
}
