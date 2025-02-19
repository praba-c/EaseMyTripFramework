package com.automation.pages.android;

import com.automation.pages.ui.QueryPage;

public class AndroidQueryPage extends AndroidBasePage implements QueryPage {

    public boolean isQueryPageDisplayed() {
        return true;
    }

    public boolean isQueryNumberGenerated() {
        return true;
    }

    public void clickOnGotoHomeBtn() {}
}
