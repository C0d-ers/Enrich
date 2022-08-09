package LoginModules;

import EnrichAppLogin.Card_to_Card_Transfer;
import EnrichAppLogin.Home_Page;
import EnrichAppOnboarding.enterOTP;
import Others.Contacts;
import Others.data;
import chrome.finexusOTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class cardToCard extends Base_Page {
    Contacts one;
    Home_Page homePage;
    Card_to_Card_Transfer cardToCardTransfer;
    enterOTP entOTP;
    finexusOTP finexus;
    @BeforeTest
    public void beforeSuite() throws IOException, InterruptedException {
        setupEmulator();
        chromeSetup();
        one = new Contacts(driver);
        homePage = new Home_Page(driver);
        cardToCardTransfer = new Card_to_Card_Transfer(driver);
        entOTP = new enterOTP(driver);
        finexus = new finexusOTP(chromeDriver);
        //log_In("5010150046");
        homePage.pressInbuiltButton("123456");
        homePage.clickSend();
        homePage.cardToCard();
    }

    @Test (dataProviderClass = data.class, dataProvider = "My Contacts")
    public void beforeTest(String name, String phone) throws InterruptedException {
        Random rand = new Random();
        int decide = rand.nextInt(2);
        int Amount;
        if(decide == 1)
            Amount = 500 + rand.nextInt(200);
        else
            Amount = 1000 + rand.nextInt(200);

        System.out.print( phone + "  ->  " );

        cardToCardTransfer.randomAmount(String.valueOf(Amount));
        cardToCardTransfer.selectContact();
        //cardToCardTransfer.clickYes();
        Thread.sleep(3000);
        cardToCardTransfer.selectUser(name);
        cardToCardTransfer.clickContinue();
        cardToCardTransfer.clickConfirm();

        //OTP from finexus
        Thread.sleep(6000);
        String otp = finexus.findOTP("5010150046");
        //String otp = finexus.findOTP("6010160335");
        entOTP.typeOTP(otp,"");
//        cardToCardTransfer.clickAddToFavourite();
//        cardToCardTransfer.clickConfirm();
//        cardToCardTransfer.clickDone();
        cardToCardTransfer.clickGotIt();
    }
   @AfterTest
    public void burnDown() throws InterruptedException {
        driver.navigate().back();
        sign_out();
        Thread.sleep(3000);
        burnItToGround();
    }
}
//Important Number login in monday 5010150055   ->   Check video for Saving box
