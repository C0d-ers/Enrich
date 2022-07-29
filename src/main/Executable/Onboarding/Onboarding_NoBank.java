package Onboarding;

import EnrichAppOnboarding.*;
import chrome.mail7;
import chrome.smsForBOUser;
import com.github.javafaker.Faker;
import io.appium.java_client.TouchAction;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class Onboarding_NoBank extends basePage {
    LandingPage landingPage;
    Login_SignUP signUp;
    enterOTP OTP;
    SelectYourIDType country;
    ruEnrich no;
    EnterEmail dummyMail;
    EmailVerification verifyEmail;
    ApplyCard card;
    Milestone gotit;
    PersonalDetails personalDetails;
    Address residentailAddress;
    BankOccupation bankOccupation;
    mail7 mail;
    smsForBOUser smsOTP;
    ValidateYourDetails validate;


    @Test
    public void start() throws IOException, InterruptedException {
        setupDevice();
        chromeSetup();

        TouchAction<?> action = new TouchAction<>(driver);
        FileInputStream input = new FileInputStream("src/main/Resource/Resource.properties");
        Properties properties = new Properties();
        properties.load(input);
        Faker faker = new Faker(new Locale("en-MS"));

        String postFix = properties.getProperty("numPost");
        String phoneNumber = "5010150"+ postFix;

        String emailOTP;

        String fullName = faker.name().nameWithMiddle();
        String firstName = fullName.substring(0,fullName.indexOf(" "));
        String lastName = fullName.substring(fullName.lastIndexOf(" ")+1);

        String dummyEmail= (lastName.replaceAll("\\s", "")+postFix + properties.getProperty("email-postfix")).toLowerCase();

        String address1 = faker.address().streetAddress();
        String address2 = faker.address().secondaryAddress();
        String Company = faker.company().name() + " Sdn. Bhd.";
        String Country = properties.getProperty("Country");


        landingPage = new LandingPage(driver);
        signUp = new Login_SignUP(driver);
        OTP = new enterOTP(driver);
        country = new SelectYourIDType(driver);
        no = new ruEnrich(driver);
        dummyMail = new EnterEmail(driver);
        verifyEmail = new EmailVerification(driver);
        card = new ApplyCard(driver);
        gotit = new Milestone(driver);
        personalDetails = new PersonalDetails(driver);
        residentailAddress = new Address(driver);
        bankOccupation = new BankOccupation(driver);
        mail = new mail7(chromeDriver);
        smsOTP = new smsForBOUser(chromeDriver);
        validate = new ValidateYourDetails(driver);


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

        if(Country.equals("Nepal"))
            country.selectNepal(postFix,"");
        else
            country.selectMalaysia("070" + postFix,"");

        no.notMember();
        Thread.sleep(9000);
        dummyMail.enterEmail(dummyEmail);

        mail.createEmail(dummyEmail);
        emailOTP = mail.findOTP();

        driver.navigate().back();
        driver.getKeyboard().pressKey(emailOTP);
        driver.hideKeyboard();
        verifyEmail.verify();
        //verifyEmail.clickContinue();

        Thread.sleep(3000);
        card.apply();
        gotit.GotIt();

        Thread.sleep(30000);
        //Capturing process here
        continousTouch(action);

        personalDetails.selectTitle();
        personalDetails.nameAsPerIC();
        driver.getKeyboard().pressKey(fullName);
        personalDetails.preferredName();
        driver.getKeyboard().pressKey(firstName);
        driver.hideKeyboard();
        if(Country.equals("Nepal"))
            personalDetails.enterDOB(2000);
        personalDetails.gender();
        scroll(driver,action, (float) 0.8, (float) 0.5);
        personalDetails.motherMaidenName(lastName);
        personalDetails.promoCode(properties.getProperty("promoCode"));
        personalDetails.continueButton();

        residentailAddress.enterAddress1(address1);
        residentailAddress.enterAddress2(address2);
        residentailAddress.postalCode();
        residentailAddress.mailingSameAsResidential();
        residentailAddress.continueButton();

        bankOccupation.openBankList();
        bankOccupation.selectbankNone();
        bankOccupation.openOccupationList();
        randomScroll(2,action);
        bankOccupation.selectOccupation();

        if(!bankOccupation.openBusinessList()) {
            randomScroll(4, action);
            bankOccupation.selectBusiness();
            bankOccupation.enterCompany(Company);
        }

        bankOccupation.openFundList();
        bankOccupation.selectFund();
        bankOccupation.continueButton();

        validate.clickProductDisclosure();
        validate.clickTermsAndCondition();
        validate.clickPersonalData();
        validate.continueButton();

    }
}