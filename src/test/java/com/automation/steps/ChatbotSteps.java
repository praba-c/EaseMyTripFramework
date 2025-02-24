package com.automation.steps;

import com.automation.pages.web.ChatbotPage;
import com.automation.pages.web.WebHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ChatbotSteps {

    WebHomePage homePage = new WebHomePage();
    ChatbotPage chatbotPage = new ChatbotPage();


    @When("user clicks on the chatbot icon")
    public void userClicksOnTheChatbotIcon() {
        homePage.clickOnChatbotIcon();
    }

    @Then("verify chatbot pop-up is displayed")
    public void verifyChatbotPopUpIsDisplayed() {
        Assert.assertTrue(chatbotPage.isChatbotDisplayed());
    }

    @When("user selects {string} from the available options")
    public void userSelectsFromTheAvailableOptions(String option) {
        chatbotPage.selectOption(option);
    }

    @And("selects {string} for query number available option")
    public void selectsForQueryNumberAvailableOption(String option) {
        chatbotPage.enterQueryNumber(option);
    }

    @Then("verify the chatbot asks for the details to book a holiday plan")
    public void verifyTheChatbotAsksForTheDetailsToBookAHolidayPlan() {
        Assert.assertTrue(chatbotPage.isChatbotAsksDetails());
    }

    @When("the user provides the details needed for booking a holiday plan")
    public void theUserProvidesTheDetailsNeededForBookingAHolidayPlan(DataTable dataTable) {
        chatbotPage.enterDetails(dataTable);
    }

    @Then("verify chatbot displays a confirmation message")
    public void verifyChatbotDisplaysAConfirmationMessage() {
        chatbotPage.isConfirmationDisplayed();
    }
}
