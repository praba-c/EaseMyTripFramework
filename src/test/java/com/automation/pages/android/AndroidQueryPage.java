package com.automation.pages.android;

import com.automation.pages.ui.QueryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AndroidQueryPage extends AndroidBasePage implements QueryPage {

    @FindBy(xpath = "//android.widget.TextView[@text='THANK YOU !']/../android.view.View/android.view.View")
    WebElement queryNum;

    @FindBy(xpath = "//android.widget.TextView[@text='Goto Homepage']")
    WebElement gotoHomePageBtn;

    public boolean isQueryPageDisplayed() {
        return true;
    }

    public boolean isQueryNumberGenerated() {
        wait.until(ExpectedConditions.visibilityOf(queryNum));
        System.out.println(queryNum.getText());
        return queryNum.isDisplayed();
    }

    public void clickOnGotoHomeBtn() {
        gotoHomePageBtn.click();
    }
}
