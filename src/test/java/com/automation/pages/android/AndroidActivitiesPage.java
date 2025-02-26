package com.automation.pages.android;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AndroidActivitiesPage extends AndroidBasePage {

    @FindBy(xpath = "//android.view.View[@resource-id='mainDiv']/android.view.View[4]")
    WebElement title;

    @FindBy(xpath = "//android.view.View[@resource-id='mainDiv']/android.view.View[4]//android.widget.TextView[2]")
    List<WebElement> availablePlaces;

    @FindBy(xpath = "//android.view.View[@resource-id='flterLst']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.view.View[@resource-id='fltrr']/android.view.View[6]//android.widget.TextView")
    List<WebElement> durationOptions;

    @FindBy(xpath = "//android.view.View[@resource-id='fltrr']/android.view.View[7]//android.widget.TextView")
    List<WebElement> specialOptions;

    @FindBy(xpath = "//android.widget.TextView[@text='Apply Filters']")
    WebElement applyFilterBtn;

    @FindBy(xpath = "//android.view.View[@resource-id='lstAct']/android.view.View/android.widget.TextView[1]")
    List<WebElement> availableActivities;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='selectedDate']")
    WebElement selectDateBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='selectedTime']")
    WebElement selectTimeBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='trvlrPlaceholerOuter']")
    WebElement selectTravelersBtn;

    public boolean isActivitiesPageDisplayed() {
        return title.isDisplayed();
    }

    public void selectPlace(String inputPlace) {

        for (WebElement place : availablePlaces) {
            if (place.getText().equalsIgnoreCase(ConfigReader.getConfigValue(inputPlace))) {
                place.click();
                break;
            }
        }
    }

    public void applyFilter(String durationVal, String specialVal) {
        filterBtn.click();

        for (WebElement duration : durationOptions) {
            if (duration.getText().equalsIgnoreCase(ConfigReader.getConfigValue(durationVal))) {
                duration.click();
                break;
            }
        }

        for (WebElement special : specialOptions) {
            if (special.getText().contains(ConfigReader.getConfigValue(specialVal))) {
                special.click();
                break;
            }
        }
        scroll();
        applyFilterBtn.click();
    }

    public void selectActivity(String location) {

        for (WebElement name : availableActivities) {
            if (name.getText().contains(ConfigReader.getConfigValue(location))) {
                name.click();
                break;
            } else {
                scroll();
            }
        }
    }

//    public void selectDate(String inputDate) {
//        pause(5000);
//        wait.until(ExpectedConditions.visibilityOf(selectDateBtn));
//        selectDateBtn.click();
//
//        for (WebElement date : dates) {
//            if (date.getText().equalsIgnoreCase(ConfigReader.getConfigValue(inputDate))) {
//                date.click();
//                break;
//            }
//        }
//    }
//
//    public void selectTime() {
//        selectTimeTab.click();
//
//        timeSlots.getFirst().click();
//    }
//
//    public void addPeople(int adultCount) {
//        selectTravelersTab.click();
//
//        for (int i=1;i<adultCount;++i) {
//            addAdultBtn.click();
//        }
//        doneBtn.click();
//    }
}
