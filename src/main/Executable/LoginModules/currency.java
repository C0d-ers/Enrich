package LoginModules;

import EnrichAppLogin.Home_Page;
import EnrichAppLogin.MCW_Exchange;
import EnrichAppLogin.Multi_Currency;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class currency extends Base_Page{
    Home_Page homePage;
    Multi_Currency multiCurrency;
    MCW_Exchange mcwExchange;
    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException {
        setupDevice();
        chromeSetup();
        homePage = new Home_Page(driver);
        multiCurrency = new Multi_Currency(driver);
        mcwExchange = new MCW_Exchange(driver);
    }
    @Test
    public void testStarts(){
        Random rand = new Random();
        int val = rand.nextInt(200);

        //homePage.clickEye();
        //int userAmount = Integer.parseInt(homePage.checkMoney());
        homePage.clickCurrency();
        multiCurrency.clickUSD();
        mcwExchange.clickBuy();
        mcwExchange.enterAmount(String.valueOf(rand.nextInt(200) + mcwExchange.randomDecimalAmount()));
        mcwExchange.clickCONFIRM();
        mcwExchange.clickConfirm();
        mcwExchange.clickDone();

        multiCurrency.clickSGD();
        mcwExchange.clickBuy();
        mcwExchange.enterAmount(String.valueOf(rand.nextInt(200) + mcwExchange.randomDecimalAmount()));
        mcwExchange.clickCONFIRM();
        mcwExchange.clickConfirm();
        mcwExchange.clickDone();

        for (int i=3;i<9;i++){

            multiCurrency.otherCurrency(i);
            mcwExchange.clickBuy();
            mcwExchange.enterAmount(String.valueOf(rand.nextInt(200) + mcwExchange.randomDecimalAmount()));
            mcwExchange.clickCONFIRM();
            mcwExchange.clickConfirm();
            mcwExchange.clickDone();
        }
        driver.navigate().back();
    }
    @AfterTest
    public void afterTest(){
        sign_out();
        burnItToGround();
    }
}
