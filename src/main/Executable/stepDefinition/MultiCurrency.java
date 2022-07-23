package stepDefinition;

import EnrichAppLogin.Home_Page;
import EnrichAppLogin.MCW_Exchange;
import EnrichAppLogin.Multi_Currency;
import LoginModules.Base_Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.net.MalformedURLException;

public class MultiCurrency extends Base_Page {
    Home_Page homePage;
    Multi_Currency multiCurrency;
    MCW_Exchange mcwExchange;
    @Before("@MultiCurrency")
    public void turnOn() throws MalformedURLException {
        setupDevice();
        chromeSetup();
    }
    @When("User logs In to the App")
    public void userLogsInToTheApp() throws IOException, InterruptedException {
        log_In();
        homePage = new Home_Page(driver);
        multiCurrency = new Multi_Currency(driver);
        mcwExchange = new MCW_Exchange(driver);
    }

    @Then("User navigates to Currency")
    public void userNavigatesToCurrency() {
        homePage.clickCurrency();
    }

    @And("Selects Desired currency to buy")
    public void selectsDesiredCurrencyToBuy() {
        multiCurrency.clickUSD();
    }

    @Then("User will be able to Enter the Amount to buy")
    public void userWillBeAbleToEnterTheAmountToBuy() {
        mcwExchange.clickSell();
        mcwExchange.enterAmount("100");
        mcwExchange.clickCONFIRM();
        mcwExchange.clickConfirm();
    }
    @When("Transaction becomes successful")
    public void transactionBecomesSuccessful() {
        mcwExchange.clickDone();

    }
    @Then("User will be redirected to MCW page")
    public void userWillBeRedirectedToMCWPage() {
        driver.navigate().back();
    }
    @After("@MultiCurrency")
    public void shutDown(){
        burnItToGround();
    }

}
