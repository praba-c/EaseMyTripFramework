package com.automation.pages.android;

import com.automation.pages.ui.PackagePage;
import com.automation.utils.ConfigReader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class AndroidPackagePage extends AndroidBasePage implements PackagePage {

    @FindBy(xpath = "//android.webkit.WebView[@text]/android.view.View[3]/android.widget.TextView[1]")
    WebElement title;

    @FindBy(xpath = "(//android.widget.TextView[@text='×'])[1]")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Enquire Now']")
    WebElement enquireNowBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='ContactName']")
    WebElement nameInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='MobileNo']")
    WebElement mobileNoInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='ContactEmail']")
    WebElement emailInput;

    @FindBy(xpath = "(//android.widget.Button[@text='+'])[2]")
    WebElement childQtyIncreaseBtn;

    @FindBy(xpath = "(//android.widget.Button[@text='+'])[3]")
    WebElement infantQtyIncreaseBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='Button2']")
    WebElement enquireBtn;

    @FindBy(xpath = "//android.view.View[@resource-id='btndet']/android.view.View[3]/android.widget.TextView[2]")
    WebElement titleCard;

    @FindBy(xpath = "//android.widget.TextView[@text='Change Hotel']")
    WebElement changeHotelBtn;

    @FindBy(xpath = "(//android.view.View[@resource-id='mnrmdiv']/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView[1])[2]")
    WebElement room;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='showprde']")
    WebElement price;

    @FindBy(xpath = "//android.widget.TextView[@text='Book Now']")
    WebElement bookNowBtn;

    @FindBy(xpath = "//android.view.View[@text='First Name']")
    List<WebElement> firstNameInputField;

    @FindBy(xpath = "//android.view.View[@text='Last Name']")
    List<WebElement> lastNameInputField;

    @FindBy(xpath = "//android.view.View[@text='Age']")
    List<WebElement> ageInputField;

    @FindBy(xpath = "//android.widget.TextView[@text='Continue Booking']")
    WebElement continueBookingBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='txtCPhone']")
    WebElement phoneNo;

    @FindBy(xpath = "//android.view.View[@resource-id='cont_20']/android.view.View[4]/android.widget.EditText")
    WebElement email;

    public void printDetails() {

        if (flightOption.equalsIgnoreCase("with flights")) {
            System.out.println(titleCard.getText());
        } else {
            System.out.println(title.getText().replace("Land Only", ""));
        }

        closeBtn.click();
    }

    public boolean isPackagePageDisplayed() {
        if (flightOption.equalsIgnoreCase("with flights")) {
            return titleCard.isDisplayed();
        }
        return title.isDisplayed();
    }

    public void clickOnEnquiryBtnAndFillDetails(String name, String mobileNo, String mail) {
        enquireNowBtn.click();
        nameInput.sendKeys(ConfigReader.getConfigValue(name));
        mobileNoInput.sendKeys(ConfigReader.getConfigValue(mobileNo));
        emailInput.sendKeys(ConfigReader.getConfigValue(mail));
    }

    public void clickOnEnquiryBtn() {
        while (!isPresent(enquireBtn)) {
            scroll();
        }
        enquireBtn.click();
    }

    public void customizeRooms(String sortOption) {
        while (!isPresent(changeHotelBtn)) {
            scroll();
        }
        changeHotelBtn.click();
        room.click();
    }

    public void printPriceDetails() {
        System.out.println(price.getText());
    }

    public void clickOnBookNowBtn() {
        bookNowBtn.click();
    }

    public void fillDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        for (int i=0;i<2;++i) {
            String firstNameValue = data.get(i).get("firstName");
            String lastNameValue = data.get(i).get("lastName");
            String ageValue = data.get(i).get("age");

            firstNameInputField.get(i).sendKeys(firstNameValue);
            lastNameInputField.get(i).sendKeys(lastNameValue);
            ageInputField.get(i).sendKeys(ageValue);
        }
    }

    public void clickOnContinueBookingBtn() {
        continueBookingBtn.click();
    }
}
