package com.automation.pages.web;

import com.automation.pages.ui.QueryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebQueryPage extends WebBasePage implements QueryPage {

    @FindBy(xpath = "//p/strong")
    WebElement queryNum;

    @FindBy(xpath = "//a[@class='button button-hero mt-4']")
    WebElement gotoHomeBtn;



    public boolean isQueryPageDisplayed() {
        return queryNum.isDisplayed();
    }

    public boolean isQueryNumberGenerated() {
        wait.until(ExpectedConditions.visibilityOf(queryNum));
        queryNumber = queryNum.getText();
        System.out.println("Query Number - " + queryNumber);
        return !queryNumber.isEmpty();
    }

    public void clickOnGotoHomeBtn() {
        gotoHomeBtn.click();
    }
}
