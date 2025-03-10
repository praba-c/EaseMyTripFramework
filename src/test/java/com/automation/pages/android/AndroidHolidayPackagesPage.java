package com.automation.pages.android;

import com.automation.pages.ui.HolidayPackagePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidHolidayPackagesPage extends AndroidBasePage implements HolidayPackagePage {

    @FindBy(id = "com.easemytrip.android:id/tvSearchTittle")
    WebElement title;

    @FindBy(xpath = "//android.view.View[@resource-id='btn123']/android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    WebElement fromCityTab;

    @FindBy(xpath = "//android.view.View[@resource-id='autolt']/android.widget.ListView/android.view.View/android.widget.TextView")
    List<WebElement> fromCities;

    @FindBy(xpath = "//android.widget.TextView[@text='Sort by']")
    WebElement sortByBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Filter']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Themes']/following-sibling::android.view.View/android.widget.TextView")
    List<WebElement> availableThemes;

    @FindBy(xpath = "//android.view.View[@resource-id='sortId']/android.view.View/android.widget.TextView")
    List<WebElement> sortOptions;

    @FindBy(xpath = "//android.view.View/android.widget.CheckBox")
    List<WebElement> filterOptions;

    @FindBy(xpath = "//android.widget.Button[@text='Apply Filter']")
    WebElement applyFilterBtn;

    @FindBy(xpath = "//android.view.View[@resource-id='btn123']/android.view.View[3]/android.view.View/android.view.View/android.view.View")
    List<WebElement> availablePackages;

    @FindBy(xpath = "//android.widget.TextView[contains(@text, 'Nights')]/..")
    List<WebElement> cards;

    @FindBy(xpath = "//android.widget.TextView[@text='View Package']")
    WebElement viewPackageBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Customize & Book']")
    WebElement customizeAndBookBtn;

    String FROM_CITY_XPATH = "//android.widget.ListView//android.widget.TextView[@text='%s']";

    public boolean isTourPackagesPageDisplayed() {
        return title.isDisplayed();
    }

    public void selectFromCity(String inputCity) {

    }

    public void filterOptions(String sortOrder, String packageType) {
        flightOption = packageType;
        sortByBtn.click();

        for (WebElement element : sortOptions) {

            if (element.getText().equalsIgnoreCase(ConfigReader.getConfigValue(sortOrder))) {
                element.click();
                break;
            }
        }

        if (packageType.equalsIgnoreCase("with flight")) {
            while (!isPresent(viewPackageBtn)) {
                scroll();
            }
            viewPackageBtn.click();
        } else {
            while (!isPresent(customizeAndBookBtn)) {
                scroll();
            }
            customizeAndBookBtn.click();
        }
    }

    public void moreFilterOptions(String theme) {
        filterBtn.click();

        for (WebElement element : availableThemes) {
            if (element.getText().equalsIgnoreCase(ConfigReader.getConfigValue(theme))) {
                element.click();
                break;
            }
        }

        applyFilterBtn.click();

    }

    public boolean isPackagesDisplayed() {
        return true;
    }

    public void selectRecommendedPackage() {
        viewPackageBtn.click();
    }

}
