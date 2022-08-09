package LoginModules;

import EnrichAppOnboarding.LandingPage;
import EnrichAppOnboarding.Login_SignUP;
import EnrichAppOnboarding.enterOTP;
import EnrichAppLogin.*;
import EnrichAppLogin.Pass_Code;
import EnrichAppLogin.Security_Phrase;
import chrome.smsForBOUser;
import Onboarding.basePage;
import io.appium.java_client.TouchAction;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base_Page extends basePage {
    LandingPage landingPage;
    Login_SignUP logIn;
    enterOTP OTP;
    smsForBOUser smsOTP;
    Security_Phrase securityPhrase;
    Pass_Code passCode;
    Home_Page homePage;
    Setting setting;
    Profile profile;
    Device_Binding deviceBinding;
    public void log_In(String phoneNumber) throws IOException, InterruptedException {
        landingPage = new LandingPage(driver);
        logIn = new Login_SignUP(driver);
        OTP = new enterOTP(driver);
        securityPhrase = new Security_Phrase(driver);
        passCode = new Pass_Code(driver);
        smsOTP = new smsForBOUser(chromeDriver);
        deviceBinding = new Device_Binding(driver);

        TouchAction<?> action = new TouchAction<>(driver);
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);

        touch(action);
        landingPage.logIn();
        logIn.enterPhoneNumber(phoneNumber);
        logIn.clickLogin();
        String bind = "";
        try {
            deviceBinding.deviceBindingPopUp();
            deviceBinding.clickYes();
            deviceBinding.clickContinue();
            bind = "Yes";
        }
        catch (Exception e){
        }
        if(bind.equals("Yes"))
        {
            OTP.typeOTP(smsOTP.findOTP(phoneNumber),"");
            deviceBinding.clickOk();
            logIn.clickLogin();
        }
        OTP.typeOTP(smsOTP.findOTP(phoneNumber),"");
        securityPhrase.clickYes();
        passCode.enterPasscode("123456");
    }

    public void sign_out(){
        homePage = new Home_Page(driver);
        profile = new Profile(driver);
        setting = new Setting(driver);
        homePage.clickSettings();
        setting.clickEditProfile();
        profile.clickSignOut();
        profile.clickYes();
    }
    public void log_In_SecondaryNumber() throws IOException, InterruptedException {
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

        String secNumber = properties.getProperty("SecondaryNumber");

        touch(action);
        landingPage.logIn();
        logIn.selectCountry(properties.getProperty("SecondaryCountry"));
        logIn.enterPhoneNumber(secNumber);
        logIn.clickLogin();

        OTP.typeOTP(smsOTP.findOTP(secNumber,"977"),"");
        securityPhrase.clickYes();
        passCode.enterPasscode("123456");
    }
    public void burnItToGround(){
        driver.quit();
        chromeDriver.quit();
    }
}
