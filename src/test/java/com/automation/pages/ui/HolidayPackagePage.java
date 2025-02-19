package com.automation.pages.ui;

public interface HolidayPackagePage {

    boolean isTourPackagesPageDisplayed();

    void selectFromCity(String inputCity);

    void filterOptions(String sortOrder, String packageType);

    void moreFilterOptions(String theme);

    boolean isPackagesDisplayed();

    void selectRecommendedPackage();


}
