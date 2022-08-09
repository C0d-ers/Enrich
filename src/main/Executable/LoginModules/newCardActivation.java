package LoginModules;

import EnrichAppOnboarding.enterOTP;
import EnrichAppLogin.Card_Setting;
import EnrichAppLogin.Home_Page;
import EnrichAppLogin.New_Card_Activation;
import chrome.UserManagement;
import chrome.finexusOTP;
import chrome.logInBackOffice;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class newCardActivation extends Base_Page{
    New_Card_Activation newCardActivation;
    UserManagement userManagement;
    logInBackOffice logInBO;
    Home_Page homePage;
    Card_Setting cardSetting;
    New_Card_Activation newCardActive;
    finexusOTP finexus;
    enterOTP entOTP;
    @BeforeTest
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
        log_In("98798");
    }
    @Test
    public void start() throws IOException, InterruptedException {
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);

        String phoneNumber = properties.getProperty("RegisteredNumber");

        logInBO.visitBO();
        logInBO.enterUserName("bijay.c@grr.la");
        logInBO.enterPassword("Bijay@123");
        logInBO.clickLogIn();
        Thread.sleep(5000);
        //logInBO.clickUserManagement();

        userManagement.clickCustomer();
        userManagement.searchPhoneNumber("60" + phoneNumber);
        userManagement.clickEdit();

        homePage.clickSettings();
        setting.clickCardSetting();
        cardSetting.clickCardActivation();
        newCardActive.enterCardNumber(userManagement.getCardN0());
        newCardActive.enterIdNumber("OK90");
        newCardActive.clickActiveCardNow();
        Thread.sleep(3000);
        entOTP.typeOTP(finexus.findOTP(phoneNumber)," ");
        Random rnd = new Random();
        String password = String.format("%06d", rnd.nextInt(999999));
        System.out.println(password);
        entOTP.typeOTP(password,"");
        entOTP.typeOTP(password,"");
        entOTP.typeOTP(finexus.findOTP(phoneNumber)," ");
        newCardActive.clickDone();
    }
    @AfterTest
    public void burnItDown(){
        sign_out();
        burnItToGround();
    }
}
