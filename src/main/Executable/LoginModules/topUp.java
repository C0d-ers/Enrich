package LoginModules;

import EnrichAppLogin.TopUp;
import EnrichAppOnboarding.FPX;
import EnrichAppLogin.Home_Page;
import EnrichAppLogin.Online_TopUp;
import EnrichAppLogin.TopUp_Money;
import io.appium.java_client.TouchAction;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class topUp extends Base_Page{
    Home_Page homePage;
    TopUp onlineTopUp;
    TopUp_Money topUpMoney;
    FPX fpx;
    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException {
        setupDevice();
        //log_In();
        homePage = new Home_Page(driver);
        onlineTopUp = new TopUp(driver);
        topUpMoney = new TopUp_Money(driver);
        fpx = new FPX(driver);
    }
    @Test
    public void performTopUp() throws InterruptedException {
        TouchAction<?> action = new TouchAction<>(driver);
        homePage.clickAddMoney();
        topUpMoney.clickOnlineTopUp();
        String amountLeft = onlineTopUp.ammountLeftForReload();
        System.out.println(amountLeft);
        onlineTopUp.enterAmount("100");
        onlineTopUp.bankDropDown();
        scroll(driver, (TouchAction<?>) action, (float) 0.8, (float) 0.3);
        onlineTopUp.selectBank();
        onlineTopUp.clickLoad();
        onlineTopUp.confirm();

        fpx.clickUserID();
        fpx.clickPassword();
        fpx.clickSignIn();
        fpx.clickConfirm();
        Thread.sleep(6500);

        onlineTopUp.done();
    }
}
