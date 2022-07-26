package LoginModules;

import EnrichAppLogin.Card_to_Card_Transfer;
import EnrichAppLogin.Home_Page;
import EnrichAppLogin.Local_Bank_Transfer;
import EnrichAppOnboarding.enterOTP;
import Others.Contacts;
import chrome.finexusOTP;
import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class LocalBankTransfer extends  Base_Page{
    Home_Page homePage;
    Local_Bank_Transfer localBankTransfer;
    enterOTP entOTP;
    finexusOTP finexus;
    @BeforeTest
    public void beforeSuite() throws IOException, InterruptedException {
        setupEmulator();
        chromeSetup();

        homePage = new Home_Page(driver);
        localBankTransfer = new Local_Bank_Transfer(driver);
        entOTP = new enterOTP(driver);
        finexus = new finexusOTP(chromeDriver);
        homePage.pressInbuiltButton("123456");

    }
    @Test
    public void localBankTransfer() throws InterruptedException {
        Faker faker = new Faker();
        String val = faker.gameOfThrones().character();
        String random = faker.dragonBall().character();
        Random rand = new Random();
        int decide = rand.nextInt(2);
        int Amount;
        if(decide == 1)
            Amount = 500 + rand.nextInt(200);
        else
            Amount = 1000 + rand.nextInt(200);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        homePage.clickSend();
        homePage.clickBankTransfer();

        localBankTransfer.newTransfer();
        localBankTransfer.randomAmount(String.valueOf(Amount));
        localBankTransfer.openBankList();
        localBankTransfer.selectBank();
        localBankTransfer.enterAccountNum("8881029052082");
        localBankTransfer.enterReceipientRef( dtf.format(now) + " " + val);
        localBankTransfer.enterOther(random);
        localBankTransfer.clickContinue();
        localBankTransfer.favouriteToogle();
        localBankTransfer.clickConfirm();

        Thread.sleep(6000);
        String otp = finexus.findOTP("6010160333");
        entOTP.typeOTP(otp,"");
        Thread.sleep(5000);
        localBankTransfer.clickDone();
    }
}
