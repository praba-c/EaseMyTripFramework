package com.automation.pages.web;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DutyFreePage extends WebBasePage {

    @FindBy(xpath = "//div[@class='card-title h5']")
    List<WebElement> airportsList;

    @FindBy(xpath = "//div[@class='btnText']/h4")
    List<WebElement> pickupLocation;

    @FindBy(xpath = "//span[@class='adl-label-arrow']")
    List<WebElement> categories;

    @FindBy(xpath = "//div[@class='card-title h5']")
    List<WebElement> productList;

    @FindBy(xpath = "//aside/span")
    List<WebElement> priceList;

    @FindBy(xpath = "//span[@class='badge rounded-pill bg-danger']/..")
    WebElement cartIcon;

    @FindBy(xpath = "//span[@class='badge rounded-pill bg-danger']")
    WebElement cartIconQty;

    @FindBy(xpath = "//h1[@class='lgFont']")
    WebElement cartTitle;

    @FindBy(xpath = "//h5[@role='button']")
    WebElement productTitle;

    @FindBy(xpath = "//div[@id='price-details']")
    WebElement productPriceDetails;

    @FindBy(xpath = "//button[text()='Sort']")
    WebElement sortBtn;

    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    List<WebElement> sortOptions;

    @FindBy(xpath = "//h1[contains(text(),'Thiruvananthapuram')]")
    WebElement title;

    public boolean isDutyFreePageDisplayed() {
        return !airportsList.isEmpty();
    }

    public void selectAirport(String airportInput) {
        for (WebElement airport : airportsList) {
            if (airport.getText().equalsIgnoreCase(ConfigReader.getConfigValue(airportInput))) {
                airport.click();
                break;
            }
        }
    }

    public boolean isAirportDutyFreePageDisplayed() {
        return title.isDisplayed();
    }

    public void selectPickupLocationAndConfirmAge(String location, String ageConfirm) {

//

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class='btn-close']"))));
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();
    }

    public boolean isProductsDisplayed() {
        return !categories.isEmpty();
    }

    public void selectCategory(String category) {
        for (WebElement element : categories) {
            if (element.getText().equalsIgnoreCase(ConfigReader.getConfigValue(category))) {
                element.click();
                break;
            }
        }
    }

    public void selectProduct(String product) {
        for (WebElement element : productList) {
            if (element.getText().contains(ConfigReader.getConfigValue(product))) {
                element.findElement(By.xpath("./ancestor::div[1]/following-sibling::button/div[2]")).click();
                break;
            }
        }
    }

    public boolean verifyCartIconQty(int number) {
        return cartIconQty.getText().equals(String.valueOf(number));
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public boolean isCartPageDisplayed() {
        return productTitle.isDisplayed();
    }

    public void printDetails() {
        System.out.println(productTitle.getText());
        System.out.println(productPriceDetails.getText());
    }

    public void sort(String sortOption) {
        sortBtn.click();
        for (WebElement element : sortOptions) {
            if (element.getText().equalsIgnoreCase(sortOption)) {
                element.click();
                break;
            }
        }
        sortBtn.click();
    }

    public boolean verifySort(String sortOrder) {

        if (sortOrder.equalsIgnoreCase("price low to high")) {

            for (int i = 1; i < priceList.size(); ++i) {
                double prev = stringPriceValueToInt(priceList.get(i - 1).getText());
                double curr = stringPriceValueToInt(priceList.get(i).getText());

                if (prev > curr) {
                    return false;
                }
            }

        } else {

            for (int i = 1; i < priceList.size(); ++i) {
                double prev = stringPriceValueToInt(priceList.get(i - 1).getText());
                double curr = stringPriceValueToInt(priceList.get(i).getText());

                if (prev < curr) {
                    return false;
                }
            }
        }
        return true;
    }
}
