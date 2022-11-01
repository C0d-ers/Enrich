package Onboarding;

import EnrichAppLogin.*;
import EnrichAppOnboarding.LandingPage;
import EnrichAppOnboarding.Login_SignUP;
import EnrichAppOnboarding.enterOTP;
import Others.data;
import chrome.smsForBOUser;
import Onboarding.basePage;
import io.appium.java_client.TouchAction;
import org.junit.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public class phraseAndPasscode extends basePage {
    LandingPage landingPage;
    Login_SignUP logIn;
    enterOTP OTP;
    Security_Phrase phrase;
    Pass_Code passCode;
    smsForBOUser smsOTP;

    Home_Page homePage;
    Profile profile;
    Setting setting;

    @BeforeSuite
    public void startServer() throws MalformedURLException {
        setupDevice();
        chromeSetup();
        landingPage = new LandingPage(driver);
        logIn = new Login_SignUP(driver);
        phrase = new Security_Phrase(driver);
        OTP = new enterOTP(driver);
        passCode = new Pass_Code(driver);
        smsOTP = new smsForBOUser(chromeDriver);
        homePage = new Home_Page(driver);
        profile = new Profile(driver);
        setting = new Setting(driver);
    }
    @Test(dataProviderClass = data.class, dataProvider = "CreateSecurityPhrase")
    public void startPhraseAndPassword(String numPost) throws IOException, InterruptedException {

        String phoneNumber = "6010160" + numPost;
        String Phrase = "60" + numPost + dateForPhrase();

        landingPage.logIn();
        logIn.enterPhoneNumberLgn(phoneNumber);
        logIn.clickLogin();

        String otp = smsOTP.findOTP(phoneNumber);
        if(otp.length()!=6){
            System.out.println("Sorry invalid OTP provided \t length : " + otp.length() + " -> " + otp);
            tearDown();
        }
        else
            OTP.typeOTP(otp,"Login");

        phrase.enterSecurityPhrase(Phrase);
        System.out.println(Phrase);
        phrase.clickContinue();
        phrase.clickYes();
        System.out.println(phrase);
        passCode.enterPasscode("123456");
        passCode.enterPasscode("123456");

        homePage = new Home_Page(driver);
        profile = new Profile(driver);
        setting = new Setting(driver);

        homePage.clickSettings();
        setting.clickEditProfile();
        profile.clickSignOut();
        profile.clickYes();
    }
    @AfterTest
    public void closeServer(){
        tearDown();
    }
}
