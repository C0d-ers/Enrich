package Onboarding;

import EnrichAppLogin.Online_TopUp;
import EnrichAppLogin.Pass_Code;
import EnrichAppLogin.Security_Phrase;
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

public class Login_TopUp extends basePage {
    LandingPage landingPage;
    Login_SignUP logIn;
    enterOTP OTP;
    Online_TopUp firstTopUp;
    FPX fpx;
    yourAccountIsNowActive activeAccount;
    smsForBOUser smsOTP;

    @BeforeTest
    public void startServer() throws MalformedURLException {
        setupDevice();
        chromeSetup();
        landingPage = new LandingPage(driver);
        logIn = new Login_SignUP(driver);
        OTP = new enterOTP(driver);
        firstTopUp = new Online_TopUp(driver);
        fpx = new FPX(driver);
        activeAccount = new yourAccountIsNowActive(driver);
        smsOTP = new smsForBOUser(chromeDriver);
    }
    @Test
    public void start() throws IOException, InterruptedException {
        TouchAction<?> action = new TouchAction<>(driver);
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);
        Random random = new Random();

        String phoneNumber = "5010150" + properties.getProperty("numPost");
        int amount = 100 + random.nextInt(9900);

        touch(action);
        landingPage.logIn();
        logIn.enterPhoneNumber(phoneNumber);
        logIn.clickLogin();

        OTP.typeOTP(smsOTP.findOTP(phoneNumber),"");

        firstTopUp.randomAmount(Integer.toString(amount));
        firstTopUp.topUpMethod();
        firstTopUp.selectOnlineBank();
        firstTopUp.bankDropDown();
        Thread.sleep(2000);
        scroll(driver, (TouchAction) action, (float) 0.8,(float) 0.3);
        firstTopUp.selectBank();
        firstTopUp.confirm();
        firstTopUp.confirm();

        fpx.clickUserID();
        fpx.clickPassword();
        fpx.clickSignIn();
        fpx.clickConfirm();
        Thread.sleep(6500);
        firstTopUp.clickDone();
        firstTopUp.clickOkGotIt();
    }
}
