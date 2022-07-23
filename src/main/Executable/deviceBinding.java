import EnrichAppLogin.Pass_Code;
import EnrichAppLogin.Security_Phrase;
import EnrichAppOnboarding.LandingPage;
import EnrichAppOnboarding.Login_SignUP;
import EnrichAppOnboarding.enterOTP;
import chrome.smsForBOUser;
import Onboarding.basePage;
import io.appium.java_client.TouchAction;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class deviceBinding extends basePage {
    LandingPage landingPage;
    Login_SignUP logIn;
    enterOTP OTP;
    smsForBOUser smsOTP;
    Security_Phrase securityPhrase;
    Pass_Code passCode;

    @Test
    public void getDevieBinded() throws IOException, InterruptedException {
        setupDevice();
        chromeSetup();
        landingPage = new LandingPage(driver);
        logIn = new Login_SignUP(driver);
        OTP = new enterOTP(driver);
        securityPhrase = new Security_Phrase(driver);
        passCode = new Pass_Code(driver);
        smsOTP = new smsForBOUser(chromeDriver);

        TouchAction<?> action = new TouchAction<>(driver);
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);

        String phoneNumber = "4010150285";

        touch(action);
        landingPage.logIn();
        logIn.enterPhoneNumber(phoneNumber);
        logIn.clickLogin();
        logIn.DeviceBindingYes();

        OTP.typeOTP(smsOTP.findOTP(phoneNumber),"");
    }

}
