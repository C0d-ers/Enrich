package Onboarding;

import EnrichAppOnboarding.LandingPage;
import EnrichAppOnboarding.Login_SignUP;
import EnrichAppOnboarding.enterOTP;
import EnrichAppLogin.Pass_Code;
import EnrichAppLogin.Security_Phrase;
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
    }
    @Test
    public void startPhraseAndPassword() throws IOException, InterruptedException {
        TouchAction<?> action = new TouchAction(driver);
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);

        String phoneNumber = "5010150" + properties.getProperty("numPost");
        String Phrase = properties.getProperty("numPost") + dateForPhrase();

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
        passCode.enterPasscode("123456");
        passCode.enterPasscode("123456");
    }
    @AfterTest
    public void closeServer(){
        tearDown();
    }
}
