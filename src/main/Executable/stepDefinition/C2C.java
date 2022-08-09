package stepDefinition;

import EnrichAppOnboarding.enterOTP;
import EnrichAppLogin.Card_to_Card_Transfer;
import EnrichAppLogin.Home_Page;
import Others.Contacts;
import LoginModules.Base_Page;
import chrome.finexusOTP;
import io.appium.java_client.android.Activity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;
import java.net.MalformedURLException;

public class C2C extends Base_Page {
    Contacts one;
    Home_Page homePage;
    Card_to_Card_Transfer cardToCardTransfer;
    enterOTP entOTP;
    finexusOTP finexus;
    @Before("@CardToCard")
    public void turnOn() throws MalformedURLException {
        setupDevice();
        chromeSetup();
        one = new Contacts(driver);
        homePage = new Home_Page(driver);
        cardToCardTransfer = new Card_to_Card_Transfer(driver);
        entOTP = new enterOTP(driver);
        finexus = new finexusOTP(chromeDriver);
    }
    @When("User successfully adds Contact to perform Transaction")
    public void userSuccessfullyAddsContactToPerformTransaction() throws InterruptedException {
        driver.startActivity(new Activity("com.google.android.contacts","com.android.contacts.activities.PeopleActivity"));
        one.addcontacts("Bijay dai Ko Number", "604010150169");
    }
    @When("User logsIn to the App")
    public void userLogsInToTheApp() throws IOException, InterruptedException {
        driver.startActivity(new Activity("com.malaysiaairlines.enrichprepaidcard.dev","com.malaysiaairlines.enrichprepaidcard.MainActivity"));
        log_In("234");
        homePage = new Home_Page(driver);
    }
    @And("Goes to CardToCard Trasaction Page")
    public void goesToCardToCardTrasactionPage() {
        homePage.clickSend();
        homePage.cardToCard();
    }

    @When("user Enters amount and PhoneNumber")
    public void userEntersAmountAndPhoneNumber() {
        cardToCardTransfer.randomAmount("309");
        cardToCardTransfer.selectContact();
        cardToCardTransfer.clickYes();
        cardToCardTransfer.selectUser("Bijay dai Ko Number");
        cardToCardTransfer.clickContinue();
        cardToCardTransfer.clickConfirm();
    }

    @Then("User will be redirected to enter OTP")
    public void userWillBeRedirectedToEnterOTP() throws InterruptedException {
        Thread.sleep(3000);
        entOTP.typeOTP(finexus.findOTP("4010150300")," ");
    }

    @And("Finally to Successful Page")
    public void finallyToSuccessfulPage() {
        cardToCardTransfer.clickDone();
    }
    @Then("Signs Out from the App")
    public void signsOutFromTheApp() {
        sign_out();
    }
    @After("@CardToCard")
    public void burnDown() throws InterruptedException {
        driver.startActivity(new Activity("com.google.android.contacts","com.android.contacts.activities.PeopleActivity"));
        one.deleteAll();
        burnItToGround();
    }
}
