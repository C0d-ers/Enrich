package SecondayNumber;

import EnrichAppLogin.Edit_Profile;
import EnrichAppLogin.Home_Page;
import EnrichAppLogin.Secondary_Number;
import EnrichAppLogin.Setting;
import EnrichAppOnboarding.Login_SignUP;
import LoginModules.Base_Page;
import chrome.smsForBOUser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AddSecondaryNumber extends Base_Page {
    Secondary_Number secondaryNumber;
    Home_Page homePage;
    Setting setting;
    Edit_Profile editProfile;
    smsForBOUser otp;
    Login_SignUP login;

    @BeforeSuite
    public void setTheSetup() throws IOException, InterruptedException {
        setupDevice();
        chromeSetup();
        login = new Login_SignUP(driver);
        secondaryNumber = new Secondary_Number(driver);
        homePage = new Home_Page(driver);
        editProfile = new Edit_Profile(driver);
        setting = new Setting(driver);
        secondaryNumber = new Secondary_Number(driver);
        otp = new smsForBOUser(chromeDriver);
        //log_In();
    }
    //@Test(priority = 1)
    public void addSecondaryNumber() throws InterruptedException, IOException {
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);

        String secondaryNum = properties.getProperty("SecondaryNumber");
        String phoneNumber = "4010150" + properties.getProperty("numPost");
        Thread.sleep(3000);

        homePage.clickSettings();
        setting.clickEditProfile();
        editProfile.clickAddSecondaryNumber();
        secondaryNumber.selectCountry(properties.getProperty("SecondaryCountry"));
        secondaryNumber.enterNumber(secondaryNum);
        secondaryNumber.enterActivationDate();
        secondaryNumber.clickContinue();
        secondaryNumber.clickConfirm();

        String OTP = otp.findOTP(phoneNumber,"379");
        secondaryNumber.enterOTP(OTP);
        secondaryNumber.clickGotIt();
        secondaryNumber.clickBack();
        sign_out();
    }
    @Test(priority = 2)
    public void signInFromSecondaryNumber() throws IOException, InterruptedException {
        log_In_SecondaryNumber();
        sign_out();
    }
    @AfterTest
    public void burn(){
        burnItToGround();
    }
}
