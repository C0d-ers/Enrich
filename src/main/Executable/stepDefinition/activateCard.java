package stepDefinition;

import EnrichAppOnboarding.enterOTP;
import EnrichAppLogin.Card_Setting;
import EnrichAppLogin.Home_Page;
import EnrichAppLogin.New_Card_Activation;
import LoginModules.Base_Page;
import chrome.UserManagement;
import chrome.finexusOTP;
import chrome.logInBackOffice;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.Random;

public class activateCard extends Base_Page{
    New_Card_Activation newCardActivation;
    UserManagement userManagement;
    logInBackOffice logInBO;
    Home_Page homePage;
    Card_Setting cardSetting;
    New_Card_Activation newCardActive;
    finexusOTP finexus;
    enterOTP entOTP;

    @Before("@ActivateCard")
    public void setTheFire() throws IOException, InterruptedException {
        setupDevice();
        chromeSetup();
        newCardActivation = new New_Card_Activation(driver);
        homePage = new Home_Page(driver);
        cardSetting = new Card_Setting(driver);
        newCardActive = new New_Card_Activation(driver);
        entOTP = new enterOTP(driver);

        userManagement = new UserManagement(chromeDriver);
        logInBO = new logInBackOffice(chromeDriver);
        finexus = new finexusOTP(chromeDriver);
    }
    @When("User login to the App")
    public void userLoginToTheApp() throws IOException, InterruptedException {
        log_In("234");
    }

    @Then("User will navigate to CardSetting")
    public void userWillNavigateToCardSetting() {
        homePage.clickSettings();
    }

    @And("Enter Activate Card")
    public void enterActivateCard() {
        cardSetting.clickCardActivation();
    }

    @But("User should know there CardNumber and Their ID number")
    public void userShouldKnowThereCardNumberAndTheirIDNNumber() throws InterruptedException {
        logInBO.visitBO();
        logInBO.enterUserName("bijay.c@grr.la");
        logInBO.enterPassword("Bijay@123");
        logInBO.clickLogIn();
        Thread.sleep(5000);
        //logInBO.clickUserManagement();

        userManagement.clickCustomer();
        userManagement.searchPhoneNumber("60" + "4010150119");
        userManagement.clickEdit();
    }

    @Then("User will enter last four digits of there CardNumber and IDNumber")
    public void userWillEnterLastFourDigitsOfThereCardNumberAndIDNumber() throws InterruptedException {
        newCardActive.enterCardNumber(userManagement.getCardN0());
        newCardActive.enterIdNumber("5606");
        newCardActive.clickActiveCardNow();
        Thread.sleep(3000);
    }

    @And("Enters the OTP received")
    public void entersTheOTPReceived() throws InterruptedException {
        entOTP.typeOTP(finexus.findOTP("4010150119")," ");
    }

    @Then("User sets the new PIN and again enters OTP")
    public void userSetsTheNewPINAndAgainEntersOTP() throws InterruptedException {
        Random rnd = new Random();
        String password = String.format("%06d", rnd.nextInt(999999));
        System.out.println(password);
        entOTP.typeOTP(password,"");
        entOTP.typeOTP(password,"");
        entOTP.typeOTP(finexus.findOTP("4010150119")," ");
    }

    @And("Finally user will be redirected to successfully Page")
    public void finallyUserWillBeRedirectedToSuccessfullyPage() {
        newCardActive.clickDone();
    }
    @After("@ActivateCard")
    public void burnItDown(){
        sign_out();
        burnItToGround();
    }
}
