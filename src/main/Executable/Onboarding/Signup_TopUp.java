package Onboarding;

import EnrichAppOnboarding.*;
import chrome.smsForBOUser;
import io.appium.java_client.TouchAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.Random;

public class Signup_TopUp extends basePage{
    LandingPage landingPage;
    Login_SignUP signUp;
    enterOTP OTP;
    smsForBOUser smsOTP;
    reloadYourCardInitial reloadAmount;
   FPX fpx;
    @BeforeTest
    public void startServer() throws MalformedURLException {
        setupEmulator();
        chromeSetup();
        landingPage = new LandingPage(driver);
        signUp = new Login_SignUP(driver);
        OTP = new enterOTP(driver);
        smsOTP = new smsForBOUser(chromeDriver);
        reloadAmount = new reloadYourCardInitial(driver);
        fpx = new FPX(driver);
    }
    @Test
    public void start() throws IOException, InterruptedException {
        TouchAction<?> action = new TouchAction<>(driver);
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);
        Random random = new Random();

        String phoneNumber = "5010150" + properties.getProperty("numPost");
        String Phrase = properties.getProperty("numPost") + " " +dateForPhrase();
        int amount = 100 + random.nextInt(9900);

        touch(action);
        landingPage.signUp();
        signUp.enterPhoneNumber(phoneNumber);
        signUp.clickSignUp();

        String otp = smsOTP.findOTP(phoneNumber);
        if(otp.length()!=6){
            System.out.println("Sorry invalid OTP provided \t length : " + otp.length() + " -> " + otp);
            tearDown();
        }
        else
            OTP.typeOTP(otp,"SignUp");

        reloadAmount.randomAmount("100");
        reloadAmount.topUpMethod();
        reloadAmount.selectOnlineBank();
        reloadAmount.bankDropDown();
        scroll(driver,action,0.8F,0.3F);
        reloadAmount.selectBank();
        reloadAmount.confirm();

        fpx.clickUserID();
        fpx.clickPassword();
        fpx.clickSignIn();
        fpx.clickConfirm();
        Thread.sleep(6500);

        reloadAmount.clickDone();
    }
}
